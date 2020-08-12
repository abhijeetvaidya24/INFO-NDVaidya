/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.yandex.metrica.impl.bc
 *  java.io.IOException
 *  java.lang.Object
 *  java.lang.String
 *  java.net.HttpURLConnection
 *  java.net.URL
 *  java.net.URLConnection
 *  java.util.concurrent.TimeUnit
 */
package com.yandex.metrica.impl.ob;

import com.yandex.metrica.impl.bc;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.TimeUnit;

public abstract class cq {
    private final String a;

    public cq(String string2) {
        this.a = string2;
    }

    public HttpURLConnection a() throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection)new URL(this.a).openConnection();
        httpURLConnection.setConnectTimeout(a.a);
        httpURLConnection.setReadTimeout(a.a);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setRequestProperty("Accept", "application/json");
        httpURLConnection.setRequestProperty("User-Agent", bc.a((String)"com.yandex.mobile.metrica.sdk"));
        return httpURLConnection;
    }

    public abstract boolean b();

    public static final class a {
        public static final int a = (int)TimeUnit.SECONDS.toMillis(30L);
    }

}

