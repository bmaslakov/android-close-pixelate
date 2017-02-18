/*
 * Close Pixelate for Android
 * based on http://desandro.com/resources/close-pixelate/
 *
 * Developed by
 * - David DeSandro  http://desandro.com
 * - John Schulz  http://twitter.com/jfsiii
 *
 * Android port by
 * - Boris Maslakov
 *
 * Licensed under MIT license
 */

package io.uuddlrlrba.closepixelate;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("WeakerAccess")
public class Pixelate {
    private final static float SQRT2 = (float) Math.sqrt(2);

    public static Bitmap fromAsset(@NonNull AssetManager assetManager, @NonNull String path, @NonNull PixelateLayer... layers) throws IOException {
        return fromInputStream(assetManager.open(path), layers);
    }

    public static Bitmap fromInputStream(@NonNull InputStream inputStream, @NonNull PixelateLayer... layers) throws IOException {
        Bitmap in = BitmapFactory.decodeStream(inputStream);
        inputStream.close();
        Bitmap out = fromBitmap(in, layers);
        in.recycle();
        return out;
    }

    public static Bitmap fromBitmap(@NonNull Bitmap in, @NonNull PixelateLayer... layers) {
        Bitmap out = Bitmap.createBitmap(in.getWidth(), in.getHeight(), Bitmap.Config.ARGB_8888);
        render(in, out, layers);
        return out;
    }

    public static void render(@NonNull Bitmap in, @NonNull Bitmap out, @NonNull PixelateLayer... layers) {
        render(in, null, out, layers);
    }

    public static void render(@NonNull Bitmap in, @Nullable Rect inBounds, @NonNull Bitmap out, @NonNull PixelateLayer... layers) {
        render(in, inBounds, out, null, layers);
    }

    public static void render(@NonNull Bitmap in, @Nullable Rect inBounds, @NonNull Bitmap out, @Nullable Rect outBounds, @NonNull PixelateLayer... layers) {
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG | Paint.FILTER_BITMAP_FLAG);
        if (outBounds == null) {
            outBounds = new Rect(0, 0, out.getWidth(), out.getHeight());
        }
        render(in, inBounds, new Canvas(out), outBounds, paint, layers);
    }

    public static void render(@NonNull Bitmap in, @Nullable Rect inBounds, @NonNull Canvas canvas, @NonNull Rect outBounds, @NonNull Paint paint, @NonNull PixelateLayer... layers) {
        int inWidth = inBounds == null ? in.getWidth() : inBounds.width();
        int inHeight = inBounds == null ? in.getHeight() : inBounds.height();
        int inX = inBounds == null ? 0 : inBounds.left;
        int inY = inBounds == null ? 0 : inBounds.top;
        float scaleX = ((float) outBounds.width()) / inWidth;
        float scaleY = ((float) outBounds.height()) / inHeight;

        canvas.save();
        canvas.clipRect(outBounds);
        canvas.translate(outBounds.left, outBounds.top);
        canvas.scale(scaleX, scaleY);

        for (PixelateLayer layer : layers) {
            // option defaults
            float size = layer.size == null ? layer.resolution : layer.size;
            int cols = (int) (inWidth / layer.resolution + 1);
            int rows = (int) (inHeight / layer.resolution + 1);
            float halfSize = size / 2f;
            float diamondSize = size / SQRT2;
            float halfDiamondSize = diamondSize / 2f;

            for (int row = 0; row <= rows; row++ ) {
                float y = (row - 0.5f) * layer.resolution + layer.offsetY;
                // normalize y so shapes around edges get color
                float pixelY = inY + Math.max(Math.min(y, inHeight - 1), 0);

                for (int col = 0; col <= cols; col++ ) {
                    float x = (col - 0.5f) * layer.resolution + layer.offsetX;
                    // normalize y so shapes around edges get color
                    float pixelX = inX + Math.max(Math.min(x, inWidth - 1), 0);

                    paint.setColor(getPixelColor(in, (int) pixelX, (int) pixelY, layer));

                    switch (layer.shape) {
                        case Circle:
                            canvas.drawCircle(x, y, halfSize, paint);
                            break;
                        case Diamond:
                            canvas.save();
                            canvas.translate(x, y);
                            canvas.rotate(45);
                            canvas.drawRect(-halfDiamondSize, -halfDiamondSize, halfDiamondSize, halfDiamondSize, paint);
                            canvas.restore();
                            break;
                        case Square:
                            canvas.drawRect(x - halfSize, y - halfSize, x + halfSize, y + halfSize, paint);
                            break;
                    } // switch
                } // col
            } // row
        }
        canvas.restore();
    }

    /**
     * Returns the color of the cluster. If options.enableDominantColor is true, return the
     * dominant color around the provided point. Return the color of the point itself otherwise.
     * The dominant color algorithm is based on simple counting search, so use with caution.
     *
     * @param pixels the bitmap
     * @param pixelX the x coordinate of the reference point
     * @param pixelY the y coordinate of the reference point
     * @param opts additional options
     * @return the color of the cluster
     */
    private static int getPixelColor(@NonNull Bitmap pixels, int pixelX, int pixelY, @NonNull PixelateLayer opts) {
        int pixel = pixels.getPixel(pixelX, pixelY);
        if (opts.enableDominantColor) {
            // TODO: optimise dominant color algorithm
            Map<Integer, Integer> colorCounter = new HashMap<>(100);
            for (int x = (int) Math.max(0, pixelX - opts.resolution); x < Math.min(pixels.getWidth(), pixelX + opts.resolution); x++) {
                for (int y = (int) Math.max(0, pixelY - opts.resolution); y < Math.min(pixels.getHeight(), pixelY + opts.resolution); y++) {
                    int currentRGB = pixels.getPixel(x, y);
                    int count = colorCounter.containsKey(currentRGB) ? colorCounter.get(currentRGB) : 0;
                    colorCounter.put(currentRGB, count + 1);
                }
            }
            Integer max = null;
            Integer dominantRGB = null;
            for (Map.Entry<Integer, Integer> entry : colorCounter.entrySet()) {
                if (max == null || entry.getValue() > max) {
                    max = entry.getValue();
                    dominantRGB = entry.getKey();
                }
            }

            pixel = dominantRGB;
        }
        int red = Color.red(pixel);
        int green = Color.green(pixel);
        int blue = Color.blue(pixel);
        int alpha = (int) (opts.alpha * Color.alpha(pixel));
        return Color.argb(alpha, red, green, blue);
    }
}
