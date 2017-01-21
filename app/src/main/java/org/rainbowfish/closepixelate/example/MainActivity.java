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

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import org.rainbowfish.closepixelate.Pixelate;
import org.rainbowfish.closepixelate.PixelateLayer;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById(R.id.imageView1);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.BLACK));
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
        try {
            select(item.getItemId());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    protected void onStop() {
        super.onStop();
        recycle();
    }

    @Override
    protected void onStart() {
        super.onStart();
        try {
            select(1);
        } catch (IOException e) {
            e.printStackTrace();
        }
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

    private void select(int index) throws IOException {
        recycle();
        switch (index) {
            case 1:
                imageView.setImageBitmap(Pixelate.fromAsset(
                        getAssets(), "officer.jpg",
                        new PixelateLayer.Builder(PixelateLayer.Shape.Diamond)
                                .setResolution(48)
                                .setSize(50)
                                .build(),
                        new PixelateLayer.Builder(PixelateLayer.Shape.Diamond)
                                .setResolution(48)
                                .setOffset(24)
                                .build(),
                        new PixelateLayer.Builder(PixelateLayer.Shape.Circle)
                                .setResolution(8)
                                .setSize(6)
                                .build()
                ));
                break;

            case 2:
                imageView.setImageBitmap(Pixelate.fromAsset(
                        getAssets(), "stanley.jpg",
                        new PixelateLayer.Builder(PixelateLayer.Shape.Square)
                                .setResolution(32)
                                .build(),
                        new PixelateLayer.Builder(PixelateLayer.Shape.Circle)
                                .setResolution(32)
                                .setOffset(15)
                                .build(),
                        new PixelateLayer.Builder(PixelateLayer.Shape.Circle)
                                .setResolution(32)
                                .setSize(26)
                                .setOffset(13)
                                .build(),
                        new PixelateLayer.Builder(PixelateLayer.Shape.Circle)
                                .setResolution(32)
                                .setSize(18)
                                .setOffset(10)
                                .build(),
                        new PixelateLayer.Builder(PixelateLayer.Shape.Circle)
                                .setResolution(32)
                                .setSize(12)
                                .setOffset(8)
                                .build()
                ));
                break;

            case 3:
                imageView.setImageBitmap(Pixelate.fromAsset(
                        getAssets(), "take-my-portrait.jpg",
                        new PixelateLayer.Builder(PixelateLayer.Shape.Square)
                                .setResolution(48)
                                .build(),
                        new PixelateLayer.Builder(PixelateLayer.Shape.Diamond)
                                .setResolution(48)
                                .setOffset(12)
                                .setAlpha(0.5f)
                                .build(),
                        new PixelateLayer.Builder(PixelateLayer.Shape.Diamond)
                                .setResolution(48)
                                .setOffset(36)
                                .setAlpha(0.5f)
                                .build(),
                        new PixelateLayer.Builder(PixelateLayer.Shape.Circle)
                                .setResolution(16)
                                .setSize(8)
                                .setOffset(4)
                                .build()
                ));
                break;

            case 4:
                imageView.setImageBitmap(Pixelate.fromAsset(
                        getAssets(), "tony.jpg",
                        new PixelateLayer.Builder(PixelateLayer.Shape.Circle)
                                .setResolution(32)
                                .setSize(6)
                                .setOffset(8)
                                .build(),
                        new PixelateLayer.Builder(PixelateLayer.Shape.Circle)
                                .setResolution(32)
                                .setSize(9)
                                .setOffset(16)
                                .build(),
                        new PixelateLayer.Builder(PixelateLayer.Shape.Circle)
                                .setResolution(32)
                                .setSize(12)
                                .setOffset(24)
                                .build(),
                        new PixelateLayer.Builder(PixelateLayer.Shape.Circle)
                                .setResolution(32)
                                .setSize(9)
                                .setOffset(0)
                                .build()
                ));
                break;

            case 5:
                imageView.setImageBitmap(Pixelate.fromAsset(
                        getAssets(), "wonder.jpg",
                        new PixelateLayer.Builder(PixelateLayer.Shape.Diamond)
                                .setResolution(24)
                                .setSize(25)
                                .build(),
                        new PixelateLayer.Builder(PixelateLayer.Shape.Diamond)
                                .setResolution(24)
                                .setOffset(12)
                                .build(),
                        new PixelateLayer.Builder(PixelateLayer.Shape.Square)
                                .setResolution(24)
                                .setAlpha(0.6f)
                                .build()
                ));
                break;

            case 6:
                imageView.setImageBitmap(Pixelate.fromAsset(
                        getAssets(), "anita.jpg",
                        new PixelateLayer.Builder(PixelateLayer.Shape.Square)
                                .setResolution(32)
                                .build(),
                        new PixelateLayer.Builder(PixelateLayer.Shape.Circle)
                                .setResolution(32)
                                .setOffset(16)
                                .build(),
                        new PixelateLayer.Builder(PixelateLayer.Shape.Circle)
                                .setResolution(32)
                                .setOffset(0)
                                .setAlpha(0.5f)
                                .build(),
                        new PixelateLayer.Builder(PixelateLayer.Shape.Circle)
                                .setResolution(16)
                                .setSize(9)
                                .setOffset(0)
                                .setAlpha(0.5f)
                                .build()
                ));
                break;

            case 7:
                imageView.setImageBitmap(Pixelate.fromAsset(
                        getAssets(), "giraffe.jpg",
                        new PixelateLayer.Builder(PixelateLayer.Shape.Circle)
                                .setResolution(24)
                                .build(),
                        new PixelateLayer.Builder(PixelateLayer.Shape.Circle)
                                .setResolution(24)
                                .setSize(9)
                                .setOffset(12)
                                .build()
                ));
                break;

            case 8:
                imageView.setImageBitmap(Pixelate.fromAsset(
                        getAssets(), "kendra.jpg",
                        new PixelateLayer.Builder(PixelateLayer.Shape.Square)
                                .setResolution(48)
                                .setOffset(24)
                                .build(),
                        new PixelateLayer.Builder(PixelateLayer.Shape.Circle)
                                .setResolution(48)
                                .setOffset(0)
                                .build(),
                        new PixelateLayer.Builder(PixelateLayer.Shape.Diamond)
                                .setResolution(16)
                                .setSize(15)
                                .setOffset(0)
                                .setAlpha(0.6f)
                                .build(),
                        new PixelateLayer.Builder(PixelateLayer.Shape.Diamond)
                                .setResolution(16)
                                .setSize(15)
                                .setOffset(8)
                                .setAlpha(0.6f)
                                .build()
                ));
                break;

            case 9:
                imageView.setImageBitmap(Pixelate.fromAsset(
                        getAssets(), "gavin.jpg",
                        new PixelateLayer.Builder(PixelateLayer.Shape.Square)
                                .setResolution(48)
                                .build(),
                        new PixelateLayer.Builder(PixelateLayer.Shape.Diamond)
                                .setResolution(12)
                                .setSize(8)
                                .build(),
                        new PixelateLayer.Builder(PixelateLayer.Shape.Diamond)
                                .setResolution(12)
                                .setSize(8)
                                .setOffset(6)
                                .build()
                ));
                break;

            default:
                return;
        }
    }
}
