/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.ByteArrayOutputStream
 *  java.io.InputStream
 *  java.io.OutputStream
 *  java.lang.Math
 *  java.lang.Object
 */
package io.presage;

import io.presage.cl;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public final class bs {
    private static long a(InputStream inputStream, OutputStream outputStream) {
        byte[] arrby = new byte[8192];
        int n2 = inputStream.read(arrby);
        long l2 = 0L;
        while (n2 >= 0) {
            outputStream.write(arrby, 0, n2);
            l2 += (long)n2;
            n2 = inputStream.read(arrby);
        }
        return l2;
    }

    public static final byte[] a(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(Math.max((int)8192, (int)inputStream.available()));
        bs.a(inputStream, (OutputStream)byteArrayOutputStream);
        byte[] arrby = byteArrayOutputStream.toByteArray();
        cl.a((Object)arrby, "buffer.toByteArray()");
        return arrby;
    }
}

