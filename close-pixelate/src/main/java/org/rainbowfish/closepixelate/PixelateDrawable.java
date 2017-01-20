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
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class PixelateDrawable extends Drawable {
    @NonNull
    private final Bitmap mBitmap;
    @NonNull
    private final Paint mPaint;
    @NonNull
    private final PixelateLayer[] mLayers;

    public PixelateDrawable(@NonNull Bitmap bitmap, @NonNull PixelateLayer... layers) {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG | Paint.FILTER_BITMAP_FLAG);
        mBitmap = bitmap;
        mLayers = layers;
    }

    @Override
    public void draw(@NonNull Canvas canvas) {
        Pixelate.render(canvas, mBitmap.getWidth(), mBitmap.getHeight(), mPaint, mBitmap, mLayers);
    }

    @Override
    public void setAlpha(int alpha) {
        int oldAlpha = mPaint.getAlpha();
        if (alpha != oldAlpha) {
            mPaint.setAlpha(alpha);
            invalidateSelf();
        }
    }

    @Override
    public int getAlpha() {
        return mPaint.getAlpha();
    }

    @Override
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        ColorFilter oldColorFilter = mPaint.getColorFilter();
        if (colorFilter != oldColorFilter) {
            mPaint.setColorFilter(colorFilter);
            invalidateSelf();
        }
    }

    @Nullable
    @Override
    public ColorFilter getColorFilter() {
        return mPaint.getColorFilter();
    }

    @Override
    public int getIntrinsicWidth() {
        return mBitmap.getWidth();
    }

    @Override
    public int getIntrinsicHeight() {
        return mBitmap.getHeight();
    }

    @Override
    public int getOpacity() {
        Bitmap bm = mBitmap;
        return (bm.hasAlpha() || mPaint.getAlpha() < 255) ?
                    PixelFormat.TRANSLUCENT : PixelFormat.OPAQUE;
    }

    @NonNull
    public Bitmap getBitmap() {
        return mBitmap;
    }

    @NonNull
    public PixelateLayer[] getLayers() {
        return mLayers;
    }
}
