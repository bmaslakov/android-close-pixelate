# android-close-pixelate

This is the android port of https://github.com/desandro/close-pixelate.

[**close-pixelate.desandro.com**](http://close-pixelate.desandro.com)

## Examples

![Officer](screenshots/officer.jpg?raw=true)

```
ClosePixelate.render(bitmap,
        new Options.Builder()
                .setResolution(48)
                .setSize(50)
                .setShape(Shape.Diamond)
                .build(),
        new Options.Builder()
                .setResolution(48)
                .setOffset(24)
                .setShape(Shape.Diamond)
                .build(),
        new Options.Builder()
                .setResolution(8)
                .setSize(6)
                .setShape(Shape.Circle)
                .build());
```

![Stanley](screenshots/stanley.jpg?raw=true)

```
ClosePixelate.render(bitmap,
        new Options.Builder()
                .setResolution(32)
                .setShape(Shape.Square)
                .build(),
        new Options.Builder()
                .setResolution(32)
                .setOffset(15)
                .setShape(Shape.Circle)
                .build(),
        new Options.Builder()
                .setResolution(32)
                .setSize(26)
                .setOffset(13)
                .setShape(Shape.Circle)
                .build(),
        new Options.Builder()
                .setResolution(32)
                .setSize(18)
                .setOffset(10)
                .setShape(Shape.Circle)
                .build(),
        new Options.Builder()
                .setResolution(32)
                .setSize(12)
                .setOffset(8)
                .setShape(Shape.Circle)
                .build());
```

![Take my portrait](screenshots/take-my-portrait.jpg?raw=true)

```
ClosePixelate.render(bitmap,
        new Options.Builder()
                .setResolution(48)
                .setShape(Shape.Square)
                .build(),
        new Options.Builder()
                .setResolution(48)
                .setOffset(12)
                .setAlpha(0.5f)
                .setShape(Shape.Diamond)
                .build(),
        new Options.Builder()
                .setResolution(48)
                .setOffset(36)
                .setAlpha(0.5f)
                .setShape(Shape.Diamond)
                .build(),
        new Options.Builder()
                .setResolution(16)
                .setSize(8)
                .setOffset(4)
                .setShape(Shape.Circle)
                .build());
```

![Tony](screenshots/tony.jpg?raw=true)

```
ClosePixelate.render(bitmap,
        new Options.Builder()
                .setResolution(32)
                .setSize(6)
                .setOffset(8)
                .setShape(Shape.Circle)
                .build(),
        new Options.Builder()
                .setResolution(32)
                .setSize(9)
                .setOffset(16)
                .setShape(Shape.Circle)
                .build(),
        new Options.Builder()
                .setResolution(32)
                .setSize(12)
                .setOffset(24)
                .setShape(Shape.Circle)
                .build(),
        new Options.Builder()
                .setResolution(32)
                .setSize(9)
                .setOffset(0)
                .setShape(Shape.Circle)
                .build());
```

![Wonder](screenshots/wonder.jpg?raw=true)

```
ClosePixelate.render(bitmap,
        new Options.Builder()
                .setResolution(24)
                .setSize(25)
                .setShape(Shape.Diamond)
                .build(),
        new Options.Builder()
                .setResolution(24)
                .setOffset(12)
                .setShape(Shape.Diamond)
                .build(),
        new Options.Builder()
                .setResolution(24)
                .setAlpha(0.6f)
                .setShape(Shape.Square)
                .build());
```

![Anita](screenshots/anita.jpg?raw=true)

```
ClosePixelate.render(bitmap,
        new Options.Builder()
                .setResolution(32)
                .setShape(Shape.Square)
                .build(),
        new Options.Builder()
                .setResolution(32)
                .setOffset(16)
                .setShape(Shape.Circle)
                .build(),
        new Options.Builder()
                .setResolution(32)
                .setOffset(0)
                .setAlpha(0.5f)
                .setShape(Shape.Circle)
                .build(),
        new Options.Builder()
                .setResolution(16)
                .setSize(9)
                .setOffset(0)
                .setAlpha(0.5f)
                .setShape(Shape.Circle)
                .build());
```

![Giraffe](screenshots/giraffe.jpg?raw=true)

```
ClosePixelate.render(bitmap,
        new Options.Builder()
                .setResolution(24)
                .setShape(Shape.Circle)
                .build(),
        new Options.Builder()
                .setResolution(24)
                .setSize(9)
                .setOffset(12)
                .setShape(Shape.Circle)
                .build());
```

![Kendra](screenshots/kendra.jpg?raw=true)

```
ClosePixelate.render(bitmap,
        new Options.Builder()
                .setResolution(48)
                .setOffset(24)
                .setShape(Shape.Square)
                .build(),
        new Options.Builder()
                .setResolution(48)
                .setOffset(0)
                .setShape(Shape.Circle)
                .build(),
        new Options.Builder()
                .setResolution(16)
                .setSize(15)
                .setOffset(0)
                .setAlpha(0.6f)
                .setShape(Shape.Diamond)
                .build(),
        new Options.Builder()
                .setResolution(16)
                .setSize(15)
                .setOffset(8)
                .setAlpha(0.6f)
                .setShape(Shape.Diamond)
                .build());
```

![Gavin](screenshots/gavin.jpg?raw=true)

```
ClosePixelate.render(bitmap,
        new Options.Builder()
                .setResolution(48)
                .setShape(Shape.Square)
                .build(),
        new Options.Builder()
                .setResolution(12)
                .setSize(8)
                .setShape(Shape.Diamond)
                .build(),
        new Options.Builder()
                .setResolution(12)
                .setSize(8)
                .setOffset(6)
                .setShape(Shape.Diamond)
                .build());
```
