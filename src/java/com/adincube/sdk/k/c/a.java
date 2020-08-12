/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.adincube.sdk.d.c.d
 *  com.adincube.sdk.j.b
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.net.HttpURLConnection
 *  java.net.URL
 */
package com.adincube.sdk.k.c;

import com.adincube.sdk.d.c.d;
import com.adincube.sdk.j.b;
import java.net.HttpURLConnection;
import java.net.URL;

public final class a
extends b {
    private String a;
    private URL b;

    public a(String string, URL uRL) {
        this.a = string;
        this.b = uRL;
    }

    protected final void g() {
        HttpURLConnection httpURLConnection;
        block5 : {
            int n2;
            httpURLConnection = null;
            try {
                httpURLConnection = super.a(this.b, "GET");
                n2 = httpURLConnection.getResponseCode();
                if (n2 == 404 || n2 < 500) break block5;
            }
            catch (Throwable throwable) {
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                throw throwable;
            }
            StringBuilder stringBuilder = new StringBuilder("Server Error : ");
            stringBuilder.append(n2);
            throw new d(stringBuilder.toString());
        }
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
    }

    protected final String i() {
        if (this.a != null) {
            StringBuilder stringBuilder = new StringBuilder("VASTTrackingRequest-");
            stringBuilder.append(this.a);
            return stringBuilder.toString();
        }
        return "VASTTrackingRequest";
    }
}

