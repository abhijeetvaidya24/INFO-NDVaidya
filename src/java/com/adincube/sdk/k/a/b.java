/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.adincube.sdk.k.a.a
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.List
 *  java.util.Locale
 */
package com.adincube.sdk.k.a;

import com.adincube.sdk.k.a.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public final class b
extends Exception {
    public a a;
    public List<com.adincube.sdk.k.b.a.a> b = new ArrayList();

    public b(a a2) {
        this(a2, (List<? extends com.adincube.sdk.k.b.a.a>)new ArrayList(), (String)null);
    }

    public b(a a2, com.adincube.sdk.k.b.a.a a3) {
        this(a2, (List<? extends com.adincube.sdk.k.b.a.a>)Collections.singletonList((Object)a3), (String)null);
    }

    public b(a a2, com.adincube.sdk.k.b.a.a a3, String string) {
        this(a2, (List<? extends com.adincube.sdk.k.b.a.a>)Collections.singletonList((Object)a3), string);
    }

    public b(a a2, String string) {
        this(a2, (List<? extends com.adincube.sdk.k.b.a.a>)new ArrayList(), string);
    }

    public b(a a2, Throwable throwable) {
        this(a2, (List<? extends com.adincube.sdk.k.b.a.a>)new ArrayList(), throwable);
    }

    public b(a a2, List<? extends com.adincube.sdk.k.b.a.a> list) {
        this(a2, list, (String)null);
    }

    private b(a a2, List<? extends com.adincube.sdk.k.b.a.a> list, String string) {
        super(b.a(a2, string));
        this.a = a2;
        this.b.addAll(list);
    }

    private b(a a2, List<? extends com.adincube.sdk.k.b.a.a> list, Throwable throwable) {
        super(b.a(a2, null), throwable);
        this.a = a2;
        this.b.addAll(list);
    }

    private static String a(a a2, String string) {
        if (string == null) {
            Locale locale = Locale.US;
            Object[] arrobject = new Object[]{a2.k};
            return String.format((Locale)locale, (String)"VAST Error: %d", (Object[])arrobject);
        }
        Locale locale = Locale.US;
        Object[] arrobject = new Object[]{a2.k, string};
        return String.format((Locale)locale, (String)"VAST Error: %d. %s", (Object[])arrobject);
    }
}

