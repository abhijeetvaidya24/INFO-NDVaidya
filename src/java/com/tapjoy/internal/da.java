/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.InputStream
 *  java.io.OutputStream
 *  java.lang.Object
 */
package com.tapjoy.internal;

import java.io.InputStream;
import java.io.OutputStream;

public final class da {
    public static long a(InputStream inputStream, OutputStream outputStream) {
        int n2;
        byte[] arrby = new byte[4096];
        long l2 = 0L;
        while ((n2 = inputStream.read(arrby)) != -1) {
            outputStream.write(arrby, 0, n2);
            l2 += (long)n2;
        }
        return l2;
    }
}

