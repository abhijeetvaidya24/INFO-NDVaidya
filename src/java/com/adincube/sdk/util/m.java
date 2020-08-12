/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.ByteArrayOutputStream
 *  java.io.OutputStream
 *  java.io.PrintStream
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 */
package com.adincube.sdk.util;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

public final class m {
    public static String a(Throwable throwable) {
        if (throwable == null) {
            return null;
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            throwable.printStackTrace(new PrintStream((OutputStream)byteArrayOutputStream));
            String string = new String(byteArrayOutputStream.toByteArray(), "UTF-8");
            return string;
        }
        catch (Throwable throwable2) {
            return null;
        }
    }
}

