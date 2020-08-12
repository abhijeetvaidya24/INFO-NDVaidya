/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.adincube.sdk.h.a.a.a
 *  com.adincube.sdk.h.a.a.b
 *  java.lang.String
 *  java.net.URL
 */
package com.adincube.sdk.h.a.a;

import com.adincube.sdk.h.a.a.a;
import com.adincube.sdk.h.a.a.b;
import com.adincube.sdk.h.a.e;
import com.adincube.sdk.util.p;
import java.net.URL;

public class c
extends a {
    private URL d;

    public c(e e2, b b2, boolean bl, URL uRL) {
        super(e2, b2, bl);
        this.d = uRL;
    }

    public final String a() {
        String string = this.d.toString();
        return p.a("SHA-1", string.substring(1 + string.lastIndexOf(47))).substring(0, 6);
    }

    public final boolean b() {
        return true;
    }

    public final URL c() {
        return this.d;
    }

    public final boolean d() {
        return false;
    }

    public final String e() {
        return null;
    }
}

