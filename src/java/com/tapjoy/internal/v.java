/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$CompressFormat
 *  java.io.InputStream
 *  java.io.OutputStream
 *  java.lang.Object
 *  java.lang.OutOfMemoryError
 *  java.lang.RuntimeException
 */
package com.tapjoy.internal;

import android.graphics.Bitmap;
import com.tapjoy.internal.ad;
import com.tapjoy.internal.bg;
import com.tapjoy.internal.bi;
import com.tapjoy.internal.v;
import java.io.InputStream;
import java.io.OutputStream;

public final class v
implements bi {
    public static final v a = new v();

    private v() {
    }

    public final Bitmap a(InputStream inputStream) {
        try {
            Bitmap bitmap = (Bitmap)ad.a(new bg(this, inputStream){
                final /* synthetic */ InputStream a;
                final /* synthetic */ v b;
                {
                    this.b = v2;
                    this.a = inputStream;
                }

                public final /* synthetic */ Object call() {
                    InputStream inputStream = this.a;
                    if (inputStream instanceof com.tapjoy.internal.bh) {
                        return android.graphics.BitmapFactory.decodeStream((InputStream)inputStream);
                    }
                    return android.graphics.BitmapFactory.decodeStream((InputStream)new com.tapjoy.internal.bh(inputStream));
                }
            });
            return bitmap;
        }
        catch (OutOfMemoryError outOfMemoryError) {
            return null;
        }
    }

    @Override
    public final /* synthetic */ void a(OutputStream outputStream, Object object) {
        if (((Bitmap)object).compress(Bitmap.CompressFormat.PNG, 100, outputStream)) {
            return;
        }
        throw new RuntimeException();
    }

    @Override
    public final /* synthetic */ Object b(InputStream inputStream) {
        return this.a(inputStream);
    }
}

