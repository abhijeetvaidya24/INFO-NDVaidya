/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.BufferedReader
 *  java.io.ByteArrayInputStream
 *  java.io.ByteArrayOutputStream
 *  java.io.Closeable
 *  java.io.InputStream
 *  java.io.InputStreamReader
 *  java.io.OutputStream
 *  java.io.Reader
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.nio.charset.Charset
 *  java.util.zip.GZIPInputStream
 *  java.util.zip.GZIPOutputStream
 */
package io.presage;

import io.presage.bz;
import io.presage.cl;
import io.presage.n;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public final class q {
    public static final q a = new q();

    private q() {
    }

    public static String a(byte[] arrby) throws Exception {
        BufferedReader bufferedReader = new BufferedReader((Reader)new InputStreamReader((InputStream)new GZIPInputStream((InputStream)new ByteArrayInputStream(arrby)), "UTF-8"));
        try {
            String string = bz.a((Reader)bufferedReader);
            return string;
        }
        finally {
            n.a((Closeable)bufferedReader);
        }
    }

    public static byte[] a(String string) throws Exception {
        boolean bl2 = ((CharSequence)string).length() == 0;
        if (bl2) {
            return new byte[0];
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream((OutputStream)byteArrayOutputStream);
        Charset charset = Charset.forName((String)"UTF-8");
        cl.a((Object)charset, "Charset.forName(charsetName)");
        byte[] arrby = string.getBytes(charset);
        cl.a((Object)arrby, "(this as java.lang.String).getBytes(charset)");
        gZIPOutputStream.write(arrby);
        byte[] arrby2 = byteArrayOutputStream.toByteArray();
        cl.a((Object)arrby2, "obj.toByteArray()");
        return arrby2;
        finally {
            n.a((Closeable)gZIPOutputStream);
        }
    }
}

