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

package org.rainbowfish.closepixelate;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import java.util.HashMap;
import java.util.Map;

public class ClosePixelate {
    private final static float SQRT2 = (float) Math.sqrt(2);

    public static void render(Bitmap bitmap, Bitmap target, Options... opts) {
        for (Options options : opts) {
            renderClosePixels(target, bitmap, options);
        }
    }

    public static Bitmap render(Bitmap bitmap, Options... opts) {
        Bitmap target = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        render(bitmap, target, opts);
        return target;
    }

    private static void renderClosePixels(Bitmap out, Bitmap data, Options opts) {
        int w = data.getWidth();
        int h = data.getHeight();
        Canvas canvas = new Canvas(out);
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG | Paint.FILTER_BITMAP_FLAG);
        paint.setColorFilter(opts.colorFilter);

        // option defaults
        float size = opts.size == null ? opts.resolution : opts.size;
        int cols = (int) (w / opts.resolution + 1);
        int rows = (int) (h / opts.resolution + 1);
        float halfSize = size / 2f;
        float diamondSize = size / SQRT2;
        float halfDiamondSize = diamondSize / 2f;

        canvas.scale(((float) out.getWidth()) / data.getWidth(), ((float) out.getHeight()) / data.getHeight());

        for (int row = 0; row < rows; row++ ) {
            float y = (row - 0.5f) * opts.resolution + opts.offsetY;
            // normalize y so shapes around edges get color
            float pixelY = Math.max(Math.min(y, h - 1), 0);

            for (int col = 0; col < cols; col++ ) {
                float x = (col - 0.5f) * opts.resolution + opts.offsetX;
                // normalize y so shapes around edges get color
                float pixelX = Math.max(Math.min(x, w - 1), 0);

                paint.setColor(getPixelColor(data, (int) pixelX, (int) pixelY, opts));

                switch (opts.shape) {
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
    private static int getPixelColor(Bitmap pixels, int pixelX, int pixelY, Options opts) {
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
