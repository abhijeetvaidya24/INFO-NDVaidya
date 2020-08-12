/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.util.Base64
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.util.HashSet
 *  java.util.Set
 */
package com.yandex.metrica.impl.ob;

import android.util.Base64;
import com.yandex.metrica.impl.ob.ev;
import java.util.HashSet;
import java.util.Set;

class fb {
    private ev a;
    private String b;

    fb(ev ev2, String string2) {
        this(ev2, string2, null);
    }

    fb(ev ev2, String string2, String[] arrstring) {
        this.a = ev2;
        this.b = string2;
        if (arrstring != null) {
            this.a.a(this.b, arrstring);
        }
    }

    public void a() {
        this.a.a(this.b, (Set<String>)new HashSet());
    }

    public boolean a(String string2) {
        if (Base64.decode((String)string2, (int)2).length == 32) {
            return this.a.a(this.b, string2);
        }
        throw new IllegalArgumentException("pin has bad length");
    }

    Set<String> b() {
        HashSet hashSet = this.a.a(this.b);
        if (hashSet == null) {
            hashSet = new HashSet();
        }
        return hashSet;
    }

    long c() {
        return this.a.a();
    }

    void d() {
        this.a.b();
    }
}

