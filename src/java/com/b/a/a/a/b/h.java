/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.net.URL
 */
package com.b.a.a.a.b;

import com.b.a.a.a.e.e;
import java.net.URL;

public final class h {
    private final String a;
    private final URL b;
    private final String c;

    private h(String string2, URL uRL, String string3) {
        this.a = string2;
        this.b = uRL;
        this.c = string3;
    }

    public static h a(String string2, URL uRL, String string3) {
        e.a(string2, "VendorKey is null or empty");
        e.a((Object)uRL, "ResourceURL is null");
        e.a(string3, "VerificationParameters is null or empty");
        return new h(string2, uRL, string3);
    }

    public String a() {
        return this.a;
    }

    public URL b() {
        return this.b;
    }

    public String c() {
        return this.c;
    }
}

