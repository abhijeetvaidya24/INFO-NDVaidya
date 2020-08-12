/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  java.io.OutputStream
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.net.HttpURLConnection
 *  java.nio.charset.Charset
 *  java.util.Iterator
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 */
package com.tapjoy.internal;

import android.net.Uri;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class en {
    public static String a(Map map) {
        StringBuilder stringBuilder = new StringBuilder();
        Iterator iterator = map.entrySet().iterator();
        boolean bl2 = true;
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry)iterator.next();
            if (bl2) {
                bl2 = false;
            } else {
                stringBuilder.append("&");
            }
            Object object = entry.getKey();
            if (object != null) {
                stringBuilder.append(Uri.encode((String)object.toString()));
            }
            stringBuilder.append("=");
            Object object2 = entry.getValue();
            if (object2 == null) continue;
            stringBuilder.append(Uri.encode((String)object2.toString()));
        }
        return stringBuilder.toString();
    }

    public static void a(HttpURLConnection httpURLConnection, String string2, String string3, Charset charset) {
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setRequestProperty("Content-Type", string2);
        byte[] arrby = string3.getBytes(charset);
        httpURLConnection.setFixedLengthStreamingMode(arrby.length);
        OutputStream outputStream = httpURLConnection.getOutputStream();
        try {
            outputStream.write(arrby);
            return;
        }
        finally {
            outputStream.close();
        }
    }
}

