/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.Closeable
 *  java.io.File
 *  java.io.FileInputStream
 *  java.io.FileOutputStream
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.InputStreamReader
 *  java.io.OutputStream
 *  java.io.OutputStreamWriter
 *  java.lang.Object
 *  java.lang.Readable
 *  java.lang.String
 *  java.nio.charset.Charset
 */
package com.tapjoy.internal;

import com.tapjoy.internal.ap;
import com.tapjoy.internal.db;
import com.tapjoy.internal.dc;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;

public final class bl {
    public static String a(File file) {
        try {
            String string2 = bl.a(file, ap.c);
            return string2;
        }
        catch (IOException iOException) {
            return null;
        }
    }

    public static String a(File file, Charset charset) {
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            String string2 = db.a((Readable)new InputStreamReader((InputStream)fileInputStream, charset));
            return string2;
        }
        finally {
            dc.a((Closeable)fileInputStream);
        }
    }

    public static void a(File file, String string2) {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            bl.a((OutputStream)fileOutputStream, string2);
            return;
        }
        finally {
            dc.a((Closeable)fileOutputStream);
        }
    }

    public static void a(OutputStream outputStream, String string2) {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, ap.c);
        outputStreamWriter.write(string2);
        outputStreamWriter.flush();
    }
}

