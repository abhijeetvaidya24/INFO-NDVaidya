/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.DataOutputStream
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.OutputStream
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.net.HttpURLConnection
 *  java.net.URL
 *  java.net.URLConnection
 *  java.util.ArrayList
 *  java.util.HashMap
 *  java.util.List
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 *  javax.net.ssl.HttpsURLConnection
 *  javax.net.ssl.SSLSocketFactory
 */
package com.tappx.b.a;

import com.tappx.b.a.d;
import com.tappx.b.a.k;
import com.tappx.b.g;
import com.tappx.b.n;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

public class m
extends d {
    private static final int a = 100;
    private final a b;
    private final SSLSocketFactory c;

    public m() {
        this(null);
    }

    public m(a a2) {
        this(a2, null);
    }

    public m(a a2, SSLSocketFactory sSLSocketFactory) {
        this.b = a2;
        this.c = sSLSocketFactory;
    }

    private static InputStream a(HttpURLConnection httpURLConnection) {
        try {
            InputStream inputStream = httpURLConnection.getInputStream();
            return inputStream;
        }
        catch (IOException iOException) {
            return httpURLConnection.getErrorStream();
        }
    }

    private HttpURLConnection a(URL uRL, n<?> n2) {
        SSLSocketFactory sSLSocketFactory;
        HttpURLConnection httpURLConnection = this.a(uRL);
        int n3 = n2.x();
        httpURLConnection.setConnectTimeout(n3);
        httpURLConnection.setReadTimeout(n3);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setDoInput(true);
        if ("https".equals((Object)uRL.getProtocol()) && (sSLSocketFactory = this.c) != null) {
            ((HttpsURLConnection)httpURLConnection).setSSLSocketFactory(sSLSocketFactory);
        }
        return httpURLConnection;
    }

    static List<g> a(Map<String, List<String>> map) {
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry entry : map.entrySet()) {
            if (entry.getKey() == null) continue;
            for (String string : (List)entry.getValue()) {
                arrayList.add((Object)new g((String)entry.getKey(), string));
            }
        }
        return arrayList;
    }

    static void a(HttpURLConnection httpURLConnection, n<?> n2) {
        switch (n2.f()) {
            default: {
                throw new IllegalStateException("Unknown method type.");
            }
            case 7: {
                httpURLConnection.setRequestMethod("PATCH");
                m.b(httpURLConnection, n2);
                return;
            }
            case 6: {
                httpURLConnection.setRequestMethod("TRACE");
                return;
            }
            case 5: {
                httpURLConnection.setRequestMethod("OPTIONS");
                return;
            }
            case 4: {
                httpURLConnection.setRequestMethod("HEAD");
                return;
            }
            case 3: {
                httpURLConnection.setRequestMethod("DELETE");
                return;
            }
            case 2: {
                httpURLConnection.setRequestMethod("PUT");
                m.b(httpURLConnection, n2);
                return;
            }
            case 1: {
                httpURLConnection.setRequestMethod("POST");
                m.b(httpURLConnection, n2);
                return;
            }
            case 0: {
                httpURLConnection.setRequestMethod("GET");
                return;
            }
            case -1: 
        }
        byte[] arrby = n2.b();
        if (arrby != null) {
            httpURLConnection.setRequestMethod("POST");
            m.a(httpURLConnection, n2, arrby);
        }
    }

    private static void a(HttpURLConnection httpURLConnection, n<?> n2, byte[] arrby) {
        httpURLConnection.setDoOutput(true);
        httpURLConnection.addRequestProperty("Content-Type", n2.u());
        DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
        dataOutputStream.write(arrby);
        dataOutputStream.close();
    }

    private static boolean a(int n2, int n3) {
        return n2 != 4 && (100 > n3 || n3 >= 200) && n3 != 204 && n3 != 304;
    }

    private static void b(HttpURLConnection httpURLConnection, n<?> n2) {
        byte[] arrby = n2.a();
        if (arrby != null) {
            m.a(httpURLConnection, n2, arrby);
        }
    }

    @Override
    public k a(n<?> n2, Map<String, String> map) {
        IOException iOException;
        String string;
        String string2 = n2.k();
        HashMap hashMap = new HashMap();
        hashMap.putAll(n2.c());
        hashMap.putAll(map);
        a a2 = this.b;
        if (a2 != null) {
            string = a2.a(string2);
            if (string == null) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("URL blocked by rewriter: ");
                stringBuilder.append(string2);
                throw new IOException(stringBuilder.toString());
            }
        } else {
            string = string2;
        }
        HttpURLConnection httpURLConnection = this.a(new URL(string), n2);
        for (String string3 : hashMap.keySet()) {
            httpURLConnection.addRequestProperty(string3, (String)hashMap.get((Object)string3));
        }
        m.a(httpURLConnection, n2);
        int n3 = httpURLConnection.getResponseCode();
        if (n3 != -1) {
            if (!m.a(n2.f(), n3)) {
                return new k(n3, m.a((Map<String, List<String>>)httpURLConnection.getHeaderFields()));
            }
            return new k(n3, m.a((Map<String, List<String>>)httpURLConnection.getHeaderFields()), httpURLConnection.getContentLength(), m.a(httpURLConnection));
        }
        iOException = new IOException("Could not retrieve response code from HttpUrlConnection.");
        throw iOException;
    }

    protected HttpURLConnection a(URL uRL) {
        HttpURLConnection httpURLConnection = (HttpURLConnection)uRL.openConnection();
        httpURLConnection.setInstanceFollowRedirects(HttpURLConnection.getFollowRedirects());
        return httpURLConnection;
    }

}

