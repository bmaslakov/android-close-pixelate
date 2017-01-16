# android-close-pixelate

This is the android port of https://github.com/desandro/close-pixelate.

[**close-pixelate.desandro.com**](http://close-pixelate.desandro.com)

## Download

The library is available at jcenter:

```
repositories {
    jcenter()
}

dependencies {
    compile 'org.rainbowfish:close-pixelate:1.0.0'
}
```

## Usage

Easiest way to use the library is to wrap plain old `Bitmap` into
[`PixelateDrawable`](close-pixelate/src/main/java/org/rainbowfish/closepixelate/PixelateDrawable.java)
and provide it with required layers:

```
PixelateDrawable drawable = new PixelateDrawable(
        bitmap,
        new PixelateLayer.Builder(PixelateLayer.Shape.Square)
                .setResolution(48)
                .setSize(50)
                .build()
));
imageView.setImageDrawable(drawable);
```

You can also create pixelated bitmaps and draw directly on the canvas.
Check out convenience methods in
[`Pixelate`](close-pixelate/src/main/java/org/rainbowfish/closepixelate/Pixelate.java).

## Examples

![Officer](screenshots/officer.jpg?raw=true)

```
Pixelate.render(bitmap,
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
                .build());
```

![Stanley](screenshots/stanley.jpg?raw=true)

```
Pixelate.render(bitmap,
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
                .build());
```

![Take my portrait](screenshots/take-my-portrait.jpg?raw=true)

```
Pixelate.render(bitmap,
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
                .build());
```

![Tony](screenshots/tony.jpg?raw=true)

```
Pixelate.render(bitmap,
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
                .build());
```

![Wonder](screenshots/wonder.jpg?raw=true)

```
Pixelate.render(bitmap,
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
                .build());
```

![Anita](screenshots/anita.jpg?raw=true)

```
Pixelate.render(bitmap,
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
                .build());
```

![Giraffe](screenshots/giraffe.jpg?raw=true)

```
Pixelate.render(bitmap,
        new PixelateLayer.Builder(PixelateLayer.Shape.Circle)
                .setResolution(24)
                .build(),
        new PixelateLayer.Builder(PixelateLayer.Shape.Circle)
                .setResolution(24)
                .setSize(9)
                .setOffset(12)
                .build());
```

![Kendra](screenshots/kendra.jpg?raw=true)

```
Pixelate.render(bitmap,
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
                .build());
```

![Gavin](screenshots/gavin.jpg?raw=true)

```
Pixelate.render(bitmap,
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
                .build());
```
