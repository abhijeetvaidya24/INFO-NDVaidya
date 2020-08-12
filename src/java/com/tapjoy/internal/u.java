/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  com.tapjoy.internal.v
 *  java.io.InputStream
 *  java.lang.Object
 *  java.net.ContentHandler
 *  java.net.URLConnection
 */
package com.tapjoy.internal;

import android.graphics.Bitmap;
import com.tapjoy.internal.v;
import java.io.InputStream;
import java.net.ContentHandler;
import java.net.URLConnection;

public final class u
extends ContentHandler {
    public static final u a = new u();

    private u() {
    }

    public static Bitmap a(InputStream inputStream) {
        try {
            Bitmap bitmap = v.a.a(inputStream);
            return bitmap;
        }
        finally {
            inputStream.close();
        }
    }

    private static Bitmap a(URLConnection uRLConnection) {
        InputStream inputStream = uRLConnection.getInputStream();
        try {
            Bitmap bitmap = v.a.a(inputStream);
            return bitmap;
        }
        finally {
            inputStream.close();
        }
    }

    public final /* synthetic */ Object getContent(URLConnection uRLConnection) {
        return u.a(uRLConnection);
    }
}

