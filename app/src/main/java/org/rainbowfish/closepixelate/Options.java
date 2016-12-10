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

public class Options {
    boolean enableDominantColor;
    float resolution = 16;
    Float size;
    float alpha = 1;
    float offsetX = 0;
    float offsetY = 0;
    Shape shape;

    public static class Builder {
        private Options options = new Options();

        public Builder setResolution(float resolution) {
            options.resolution = resolution;
            return this;
        }

        public Builder setSize(float size) {
            options.size = size;
            return this;
        }

        public Builder setOffset(float size) {
            options.offsetX = size;
            options.offsetY = size;
            return this;
        }

        public Builder setShape(Shape shape) {
            options.shape = shape;
            return this;
        }

        public Builder setAlpha(float alpha) {
            options.alpha = alpha;
            return this;
        }

        public Builder setEnableDominantColors(boolean enable) {
            options.enableDominantColor = enable;
            return this;
        }

        public Options build() {
            return options;
        }
    }
}
