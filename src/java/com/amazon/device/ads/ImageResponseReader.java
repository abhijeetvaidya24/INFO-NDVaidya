/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  java.io.InputStream
 */
package com.amazon.device.ads;

import android.graphics.Bitmap;
import com.amazon.device.ads.GraphicsUtils;
import com.amazon.device.ads.ResponseReader;
import java.io.InputStream;

class ImageResponseReader
extends ResponseReader {
    final GraphicsUtils graphicsUtils;

    ImageResponseReader(ResponseReader responseReader, GraphicsUtils graphicsUtils) {
        super(responseReader.getInputStream());
        this.graphicsUtils = graphicsUtils;
    }

    public Bitmap readAsBitmap() {
        return this.graphicsUtils.createBitmapImage(this.getInputStream());
    }
}

