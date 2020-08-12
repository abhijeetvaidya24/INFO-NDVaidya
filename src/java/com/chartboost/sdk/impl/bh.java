/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.File
 *  java.io.FileInputStream
 *  java.io.FileNotFoundException
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.math.BigInteger
 *  java.nio.charset.Charset
 */
package com.chartboost.sdk.impl;

import com.chartboost.sdk.impl.bi;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.nio.charset.Charset;

public class bh {
    public static final BigInteger a;
    public static final BigInteger b;
    public static final BigInteger c;
    public static final BigInteger d;
    public static final BigInteger e;
    public static final BigInteger f;
    public static final BigInteger g;
    public static final BigInteger h;
    public static final File[] i;
    private static final Charset j;

    static {
        BigInteger bigInteger = a = BigInteger.valueOf((long)1024L);
        b = bigInteger.multiply(bigInteger);
        c = a.multiply(b);
        d = a.multiply(c);
        e = a.multiply(d);
        f = a.multiply(e);
        g = BigInteger.valueOf((long)1024L).multiply(BigInteger.valueOf((long)0x1000000000000000L));
        h = a.multiply(g);
        i = new File[0];
        j = Charset.forName((String)"UTF-8");
    }

    public static FileInputStream a(File file) throws IOException {
        if (file.exists()) {
            if (!file.isDirectory()) {
                if (file.canRead()) {
                    return new FileInputStream(file);
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("File '");
                stringBuilder.append((Object)file);
                stringBuilder.append("' cannot be read");
                throw new IOException(stringBuilder.toString());
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("File '");
            stringBuilder.append((Object)file);
            stringBuilder.append("' exists but is a directory");
            throw new IOException(stringBuilder.toString());
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("File '");
        stringBuilder.append((Object)file);
        stringBuilder.append("' does not exist");
        throw new FileNotFoundException(stringBuilder.toString());
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static byte[] b(File file) throws IOException {
        FileInputStream fileInputStream;
        void var1_5;
        block4 : {
            byte[] arrby;
            fileInputStream = bh.a(file);
            try {
                arrby = bi.a((InputStream)fileInputStream, file.length());
            }
            catch (Throwable throwable) {
                break block4;
            }
            bi.a((InputStream)fileInputStream);
            return arrby;
            catch (Throwable throwable) {
                fileInputStream = null;
            }
        }
        bi.a((InputStream)fileInputStream);
        throw var1_5;
    }
}

