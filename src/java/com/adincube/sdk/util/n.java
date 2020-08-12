/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.adincube.sdk.h.a.a.a
 *  java.io.ByteArrayInputStream
 *  java.io.FileInputStream
 *  java.io.FileNotFoundException
 *  java.io.FileOutputStream
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.UnsupportedEncodingException
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 */
package com.adincube.sdk.util;

import android.content.Context;
import com.adincube.sdk.util.a;
import com.adincube.sdk.util.w;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

public final class n {
    public static InputStream a(Context context, com.adincube.sdk.h.a.a.a a2) {
        if (a2.b()) {
            return context.openFileInput(n.b(a2));
        }
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(a2.e().getBytes("UTF-8"));
            return byteArrayInputStream;
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            return null;
        }
    }

    public static String a(Context context, String string) {
        StringBuilder stringBuilder = new StringBuilder("AIC_");
        stringBuilder.append(string);
        stringBuilder.append(".aic");
        return n.c(context, stringBuilder.toString());
    }

    public static String a(com.adincube.sdk.h.a.a.a a2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(n.c(a2));
        stringBuilder.append(a2.a());
        stringBuilder.append("_tmp");
        return stringBuilder.toString();
    }

    public static void a(Context context, String string, String string2) {
        StringBuilder stringBuilder = new StringBuilder("AIC_");
        stringBuilder.append(string);
        stringBuilder.append(".aic");
        n.b(context, stringBuilder.toString(), string2);
    }

    public static String b(com.adincube.sdk.h.a.a.a a2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(n.c(a2));
        stringBuilder.append(a2.a());
        return stringBuilder.toString();
    }

    public static void b(Context context, String string) {
        StringBuilder stringBuilder = new StringBuilder("AIC_");
        stringBuilder.append(string);
        stringBuilder.append(".aic");
        context.deleteFile(stringBuilder.toString());
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static void b(Context context, String string, String string2) {
        Class<n> class_ = n.class;
        synchronized (n.class) {
            try {
                try {
                    FileOutputStream fileOutputStream = context.openFileOutput(string, 0);
                    fileOutputStream.flush();
                    fileOutputStream.write(string2.getBytes());
                    fileOutputStream.close();
                    // ** MonitorExit[class_] (shouldn't be in output)
                    return;
                }
                catch (IOException iOException) {
                    a.c("writeConfig() IOException", new Object[]{iOException});
                    // ** MonitorExit[class_] (shouldn't be in output)
                    return;
                }
            }
            catch (Throwable throwable2) {}
            throw throwable2;
        }
    }

    private static String c(Context context, String string) {
        Class<n> class_ = n.class;
        synchronized (n.class) {
            try {
                FileInputStream fileInputStream = context.openFileInput(string);
                String string2 = w.a((InputStream)fileInputStream);
                fileInputStream.close();
                // ** MonitorExit[var5_2] (shouldn't be in output)
                return string2;
            }
            catch (IOException iOException) {
                return null;
            }
            catch (FileNotFoundException fileNotFoundException) {
                return null;
            }
            finally {
                // ** MonitorExit[var5_2] (shouldn't be in output)
            }
        }
    }

    private static String c(com.adincube.sdk.h.a.a.a a2) {
        StringBuilder stringBuilder = new StringBuilder("AIC_RTB_");
        stringBuilder.append(a2.g());
        stringBuilder.append("_");
        return stringBuilder.toString();
    }
}

