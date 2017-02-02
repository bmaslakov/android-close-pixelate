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
    compile 'org.rainbowfish:close-pixelate:1.2.0'
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

|                                                  |                                                  |
|--------------------------------------------------|--------------------------------------------------|
| ![Officer-old](screenshots/officer.jpg?raw=true) | ![Officer-new](screenshots/officer.png?raw=true) |

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

|                                                  |                                                  |
|--------------------------------------------------|--------------------------------------------------|
| ![Stanley-old](screenshots/stanley.jpg?raw=true) | ![Stanley-new](screenshots/stanley.png?raw=true) |

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

|                                                           |                                                           |
|-----------------------------------------------------------|-----------------------------------------------------------|
| ![Stanley-old](screenshots/take-my-portrait.jpg?raw=true) | ![Stanley-new](screenshots/take-my-portrait.png?raw=true) |

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

|                                            |                                            |
|--------------------------------------------|--------------------------------------------|
| ![Tony-old](screenshots/tony.jpg?raw=true) | ![Tony-new](screenshots/tony.png?raw=true) |

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

|                                                |                                                |
|------------------------------------------------|------------------------------------------------|
| ![Wonder-old](screenshots/wonder.jpg?raw=true) | ![Wonder-new](screenshots/wonder.png?raw=true) |

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

|                                              |                                              |
|----------------------------------------------|----------------------------------------------|
| ![Anita-old](screenshots/anita.jpg?raw=true) | ![Anita-new](screenshots/anita.png?raw=true) |

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

|                                                  |                                                  |
|--------------------------------------------------|--------------------------------------------------|
| ![Giraffe-old](screenshots/giraffe.jpg?raw=true) | ![Giraffe-new](screenshots/giraffe.png?raw=true) |

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

|                                                |                                                |
|------------------------------------------------|------------------------------------------------|
| ![Kendra-old](screenshots/kendra.jpg?raw=true) | ![Kendra-new](screenshots/kendra.png?raw=true) |

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

|                                              |                                              |
|----------------------------------------------|----------------------------------------------|
| ![Gavin-old](screenshots/gavin.jpg?raw=true) | ![Gavin-new](screenshots/gavin.png?raw=true) |

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
