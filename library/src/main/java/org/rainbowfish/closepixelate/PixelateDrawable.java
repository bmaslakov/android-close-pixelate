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
    @Nullable
    private Bitmap mBitmap;
    @NonNull
    private Paint mPaint;
    @NonNull
    private PixelateLayer[] mLayers;

    // These are scaled to match the target density.
    private int mBitmapWidth;
    private int mBitmapHeight;

    public PixelateDrawable() {
        this(null);
    }

    public PixelateDrawable(@Nullable Bitmap bitmap, @NonNull PixelateLayer... layers) {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG | Paint.FILTER_BITMAP_FLAG);
        setBitmap(bitmap);
        mLayers = layers;
    }

    @Override
    public void draw(@NonNull Canvas canvas) {
        if (mBitmap != null) {
            Pixelate.render(canvas, mBitmapWidth, mBitmapHeight, mPaint, mBitmap, mLayers);
        }
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
        return mBitmapWidth;
    }

    @Override
    public int getIntrinsicHeight() {
        return mBitmapHeight;
    }

    @Override
    public int getOpacity() {
        Bitmap bm = mBitmap;
        return (bm == null || bm.hasAlpha() || mPaint.getAlpha() < 255) ?
                    PixelFormat.TRANSLUCENT : PixelFormat.OPAQUE;
    }

    public void setBitmap(@Nullable Bitmap bitmap) {
        if (mBitmap != bitmap) {
            mBitmap = bitmap;
            if (bitmap != null) {
                mBitmapWidth = bitmap.getWidth();
                mBitmapHeight = bitmap.getHeight();
            }
            invalidateSelf();
        }
    }

    @Nullable
    public Bitmap getBitmap() {
        return mBitmap;
    }

    public void setLayers(@NonNull PixelateLayer... layers) {
        if (mLayers != layers) {
            mLayers = layers;
            invalidateSelf();
        }
    }
}
