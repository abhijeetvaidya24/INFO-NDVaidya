/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Appendable
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.Readable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.nio.Buffer
 *  java.nio.CharBuffer
 */
package com.tapjoy.internal;

import java.nio.Buffer;
import java.nio.CharBuffer;

public final class db {
    private static long a(Readable readable, Appendable appendable) {
        int n2;
        CharBuffer charBuffer = CharBuffer.allocate((int)2048);
        long l2 = 0L;
        while ((n2 = readable.read(charBuffer)) != -1) {
            charBuffer.flip();
            appendable.append((CharSequence)charBuffer, 0, n2);
            l2 += (long)n2;
        }
        return l2;
    }

    public static String a(Readable readable) {
        StringBuilder stringBuilder = new StringBuilder();
        db.a(readable, (Appendable)stringBuilder);
        return stringBuilder.toString();
    }
}

