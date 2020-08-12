/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.adincube.sdk.a.a
 *  com.adincube.sdk.a.c
 *  com.adincube.sdk.h.f.d
 *  java.lang.Object
 *  java.lang.String
 *  java.util.HashSet
 *  java.util.Set
 */
package com.adincube.sdk.a.c;

import com.adincube.sdk.a.c;
import com.adincube.sdk.h.f.d;
import java.util.HashSet;
import java.util.Set;

public final class a
implements com.adincube.sdk.a.a {
    public String a;
    public Set<String> b = new HashSet();
    public Set<String> c = new HashSet();
    public c d = null;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final d a(String string) {
        a a2 = this;
        synchronized (a2) {
            if (this.c.contains((Object)string)) {
                return d.d;
            }
            if (!this.b.contains((Object)string)) return d.a;
            return d.c;
        }
    }

    public final String a() {
        return "External";
    }

    public final void a(c c2) {
        this.d = c2;
    }

    public final void b() {
    }

    public final boolean c() {
        return true;
    }

    public final String d() {
        return this.a;
    }
}

