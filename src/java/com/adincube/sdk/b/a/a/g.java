/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.Locale
 */
package com.adincube.sdk.b.a.a;

import android.net.Uri;
import com.adincube.sdk.b.a.a.e;
import com.adincube.sdk.b.a.a.h;
import com.adincube.sdk.util.m;
import java.util.Locale;

public final class g {
    public String a;
    public h b;
    public long c;
    public String d;
    public String e;

    private g(e e2, Uri uri) {
        this.a = e2.k();
        this.b = e2.a();
        this.c = e2.o();
        this.d = uri.toString();
    }

    public g(e e2, Uri uri, String string) {
        this(e2, uri);
        this.e = string;
    }

    public g(e e2, Uri uri, Throwable throwable) {
        this(e2, uri);
        this.e = m.a(throwable);
    }

    public final String toString() {
        String string;
        StringBuilder stringBuilder = new StringBuilder();
        Locale locale = Locale.US;
        Object[] arrobject = new Object[]{this.a};
        stringBuilder.append(String.format((Locale)locale, (String)"Player: %s\n", (Object[])arrobject));
        Locale locale2 = Locale.US;
        Object[] arrobject2 = new Object[]{this.b.h};
        stringBuilder.append(String.format((Locale)locale2, (String)"State: %s\n", (Object[])arrobject2));
        Locale locale3 = Locale.US;
        Object[] arrobject3 = new Object[]{this.c};
        stringBuilder.append(String.format((Locale)locale3, (String)"Position: %d\n", (Object[])arrobject3));
        if (this.d != null) {
            Locale locale4 = Locale.US;
            Object[] arrobject4 = new Object[]{this.d};
            stringBuilder.append(String.format((Locale)locale4, (String)"Media: %s\n", (Object[])arrobject4));
        }
        if ((string = this.e) != null) {
            stringBuilder.append(string);
        }
        return stringBuilder.toString();
    }
}

