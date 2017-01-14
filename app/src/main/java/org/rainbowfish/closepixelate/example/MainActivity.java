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

package org.rainbowfish.closepixelate.example;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import org.rainbowfish.closepixelate.ClosePixelate;
import org.rainbowfish.closepixelate.Options;
import org.rainbowfish.closepixelate.Shape;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById(R.id.imageView1);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.BLACK));
        select(1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(Menu.NONE, 1, Menu.NONE, "Officer");
        menu.add(Menu.NONE, 2, Menu.NONE, "Stanley");
        menu.add(Menu.NONE, 3, Menu.NONE, "Take my portrait");
        menu.add(Menu.NONE, 4, Menu.NONE, "Tony");
        menu.add(Menu.NONE, 5, Menu.NONE, "Wonder");
        menu.add(Menu.NONE, 6, Menu.NONE, "Anita");
        menu.add(Menu.NONE, 7, Menu.NONE, "Giraffe");
        menu.add(Menu.NONE, 8, Menu.NONE, "Kendra");
        menu.add(Menu.NONE, 9, Menu.NONE, "Gavin");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        select(item.getItemId());
        return true;
    }

    @Override
    protected void onStop() {
        super.onStop();
        recycle();
    }

    private void recycle() {
        if (imageView.getDrawable() != null) {
            if (imageView.getDrawable() instanceof BitmapDrawable) {
                Bitmap bitmap = ((BitmapDrawable) imageView.getDrawable()).getBitmap();
                imageView.setImageBitmap(null);
                if (bitmap != null && !bitmap.isRecycled()) {
                    bitmap.recycle();
                }
            }
        }
    }

    private void select(int index) {
        recycle();
        Bitmap bitmap, out;
        switch (index) {
            case 1:
                bitmap = getBitmapFromAsset(this, "officer.jpg");
                out = bitmap.copy(Bitmap.Config.ARGB_8888, true);
                ClosePixelate.render(bitmap, out,
                        new Options.Builder(Shape.Diamond)
                                .setResolution(48)
                                .setSize(50)
                                .build(),
                        new Options.Builder(Shape.Diamond)
                                .setResolution(48)
                                .setOffset(24)
                                .build(),
                        new Options.Builder(Shape.Circle)
                                .setResolution(8)
                                .setSize(6)
                                .build());
                break;

            case 2:
                bitmap = getBitmapFromAsset(this, "stanley.jpg");
                out = bitmap.copy(Bitmap.Config.ARGB_8888, true);
                ClosePixelate.render(bitmap, out,
                        new Options.Builder(Shape.Square)
                                .setResolution(32)
                                .build(),
                        new Options.Builder(Shape.Circle)
                                .setResolution(32)
                                .setOffset(15)
                                .build(),
                        new Options.Builder(Shape.Circle)
                                .setResolution(32)
                                .setSize(26)
                                .setOffset(13)
                                .build(),
                        new Options.Builder(Shape.Circle)
                                .setResolution(32)
                                .setSize(18)
                                .setOffset(10)
                                .build(),
                        new Options.Builder(Shape.Circle)
                                .setResolution(32)
                                .setSize(12)
                                .setOffset(8)
                                .build());
                break;

            case 3:
                bitmap = getBitmapFromAsset(this, "take-my-portrait.jpg");
                out = bitmap.copy(Bitmap.Config.ARGB_8888, true);
                ClosePixelate.render(bitmap, out,
                        new Options.Builder(Shape.Square)
                                .setResolution(48)
                                .build(),
                        new Options.Builder(Shape.Diamond)
                                .setResolution(48)
                                .setOffset(12)
                                .setAlpha(0.5f)
                                .build(),
                        new Options.Builder(Shape.Diamond)
                                .setResolution(48)
                                .setOffset(36)
                                .setAlpha(0.5f)
                                .build(),
                        new Options.Builder(Shape.Circle)
                                .setResolution(16)
                                .setSize(8)
                                .setOffset(4)
                                .build());
                break;

            case 4:
                bitmap = getBitmapFromAsset(this, "tony.jpg");
                out = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Config.ARGB_8888);
                ClosePixelate.render(bitmap, out,
                        new Options.Builder(Shape.Circle)
                                .setResolution(32)
                                .setSize(6)
                                .setOffset(8)
                                .build(),
                        new Options.Builder(Shape.Circle)
                                .setResolution(32)
                                .setSize(9)
                                .setOffset(16)
                                .build(),
                        new Options.Builder(Shape.Circle)
                                .setResolution(32)
                                .setSize(12)
                                .setOffset(24)
                                .build(),
                        new Options.Builder(Shape.Circle)
                                .setResolution(32)
                                .setSize(9)
                                .setOffset(0)
                                .build());
                break;

            case 5:
                bitmap = getBitmapFromAsset(this, "wonder.jpg");
                out = bitmap.copy(Bitmap.Config.ARGB_8888, true);
                ClosePixelate.render(bitmap, out,
                        new Options.Builder(Shape.Diamond)
                                .setResolution(24)
                                .setSize(25)
                                .build(),
                        new Options.Builder(Shape.Diamond)
                                .setResolution(24)
                                .setOffset(12)
                                .build(),
                        new Options.Builder(Shape.Square)
                                .setResolution(24)
                                .setAlpha(0.6f)
                                .build());
                break;

            case 6:
                bitmap = getBitmapFromAsset(this, "anita.jpg");
                out = bitmap.copy(Bitmap.Config.ARGB_8888, true);
                ClosePixelate.render(bitmap, out,
                        new Options.Builder(Shape.Square)
                                .setResolution(32)
                                .build(),
                        new Options.Builder(Shape.Circle)
                                .setResolution(32)
                                .setOffset(16)
                                .build(),
                        new Options.Builder(Shape.Circle)
                                .setResolution(32)
                                .setOffset(0)
                                .setAlpha(0.5f)
                                .build(),
                        new Options.Builder(Shape.Circle)
                                .setResolution(16)
                                .setSize(9)
                                .setOffset(0)
                                .setAlpha(0.5f)
                                .build());
                break;

            case 7:
                bitmap = getBitmapFromAsset(this, "giraffe.jpg");
                out = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Config.ARGB_8888);
                ClosePixelate.render(bitmap, out,
                        new Options.Builder(Shape.Circle)
                                .setResolution(24)
                                .build(),
                        new Options.Builder(Shape.Circle)
                                .setResolution(24)
                                .setSize(9)
                                .setOffset(12)
                                .build());
                break;

            case 8:
                bitmap = getBitmapFromAsset(this, "kendra.jpg");
                out = bitmap.copy(Bitmap.Config.ARGB_8888, true);
                ClosePixelate.render(bitmap, out,
                        new Options.Builder(Shape.Square)
                                .setResolution(48)
                                .setOffset(24)
                                .build(),
                        new Options.Builder(Shape.Circle)
                                .setResolution(48)
                                .setOffset(0)
                                .build(),
                        new Options.Builder(Shape.Diamond)
                                .setResolution(16)
                                .setSize(15)
                                .setOffset(0)
                                .setAlpha(0.6f)
                                .build(),
                        new Options.Builder(Shape.Diamond)
                                .setResolution(16)
                                .setSize(15)
                                .setOffset(8)
                                .setAlpha(0.6f)
                                .build());
                break;

            case 9:
                bitmap = getBitmapFromAsset(this, "gavin.jpg");
                out = bitmap.copy(Bitmap.Config.ARGB_8888, true);
                ClosePixelate.render(bitmap, out,
                        new Options.Builder(Shape.Square)
                                .setResolution(48)
                                .build(),
                        new Options.Builder(Shape.Diamond)
                                .setResolution(12)
                                .setSize(8)
                                .build(),
                        new Options.Builder(Shape.Diamond)
                                .setResolution(12)
                                .setSize(8)
                                .setOffset(6)
                                .build());
                break;

            default:
                return;
        }
        imageView.setImageBitmap(out);
        bitmap.recycle();

    }

    private static Bitmap getBitmapFromAsset(Context context, String filePath) {
        AssetManager assetManager = context.getAssets();

        InputStream istr;
        Bitmap bitmap = null;
        try {
            istr = assetManager.open(filePath);
            bitmap = BitmapFactory.decodeStream(istr);
        } catch (IOException e) {
            // handle exception
        }
        return bitmap;
    }
}
