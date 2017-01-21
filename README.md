# android-close-pixelate

Android close pixelate allows you easily create and combine various pixelation effects.
The library is super lightweight (3 classes, 8KB) and easy to use.

This is the android port of https://github.com/desandro/close-pixelate.

[**close-pixelate.desandro.com**](http://close-pixelate.desandro.com)

## Download

The library is available at jcenter:

```groovy
repositories {
    jcenter()
}

dependencies {
    compile 'org.rainbowfish:close-pixelate:1.1.0'
}
```

## Usage

There are several `Pixelate.from*` methods in the
[`PixelateDrawable`](close-pixelate/src/main/java/org/rainbowfish/closepixelate/PixelateDrawable.java)
class, allowing to create a pixelated bitmap from other bitmaps, resources, input streams, etc:

```java
Bitmap pixelated = new Pixelate.fromBitmap(
        bitmap,
        new PixelateLayer.Builder(PixelateLayer.Shape.Square)
                .setResolution(48)
                .setSize(50)
                .build()
);
```

You can change output bitmap size, which can be used to conceal image upscaling artifacts:

```java
Bitmap big = new Pixelate.fromBitmap(
        small,
        1920,
        1280,
        new PixelateLayer.Builder(PixelateLayer.Shape.Circle)
                .setResolution(10)
                .setSize(10)
                .build()
);
```

You also can draw directly on a bitmap or on a canvas, using `Pixelate.render*` methods.

## Examples

Here are the simplest examples of single-layer configurations:

|                                               |                                                                  |
|-----------------------------------------------|------------------------------------------------------------------|
| Original                                      | ![original](app/src/main/assets/jamie-hyneman.jpg?raw=true)      |
| `resolution = 25, size = 25, shape = square`  | ![simple-hi-square](screenshots/simple-hi-square.png?raw=true)   |
| `resolution = 10, size = 10, shape = square`  | ![simple-lo-square](screenshots/simple-lo-square.png?raw=true)   |
| `resolution = 25, size = 25, shape = circle`  | ![simple-hi-circle](screenshots/simple-hi-circle.png?raw=true)   |
| `resolution = 10, size = 10, shape = circle`  | ![simple-lo-circle](screenshots/simple-lo-circle.png?raw=true)   |
| `resolution = 25, size = 25, shape = diamond` | ![simple-hi-diamond](screenshots/simple-hi-diamond.png?raw=true) |
| `resolution = 10, size = 10, shape = diamond` | ![simple-lo-diamond](screenshots/simple-lo-diamond.png?raw=true) |

Combining several layers, you can achieve more interesting effects:

![Officer](screenshots/officer.jpg?raw=true)

```java
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

```java
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

```java
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

```java
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

```java
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

```java
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

```java
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

```java
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

```java
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
