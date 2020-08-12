/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  java.lang.Object
 */
package com.tapjoy.internal;

import android.graphics.Bitmap;
import com.tapjoy.internal.hf;

final class hk
implements hf.a {
    hk() {
    }

    @Override
    public final Bitmap a(int n2, int n3, Bitmap.Config config) {
        return Bitmap.createBitmap((int)n2, (int)n3, (Bitmap.Config)config);
    }

    @Override
    public final byte[] a(int n2) {
        return new byte[n2];
    }

    @Override
    public final int[] b(int n2) {
        return new int[n2];
    }
}

