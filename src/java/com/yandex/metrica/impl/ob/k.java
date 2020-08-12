/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package com.yandex.metrica.impl.ob;

import com.yandex.metrica.impl.ob.h;
import com.yandex.metrica.impl.ob.i;
import com.yandex.metrica.impl.ob.j;

public class k<T extends i> {
    private final j<T> a;
    private final h<T> b;

    private k(a a2) {
        this.a = a2.b;
        this.b = a2.a;
    }

    /* synthetic */ k(a a2, byte by) {
        this(a2);
    }

    public static <T extends i> a<T> a(j<T> j2) {
        return new a<T>(j2);
    }

    final void a(i i2) {
        this.a.a(i2);
    }

    final boolean b(i i2) {
        h<i> h2 = this.b;
        if (h2 == null) {
            return false;
        }
        return h2.a(i2);
    }

    public static final class a<T extends i> {
        public h<T> a;
        private j<T> b;

        a(j<T> j2) {
            this.b = j2;
        }

        public a<T> a(h<T> h2) {
            this.a = h2;
            return this;
        }

        public k<T> a() {
            return new k(this, 0);
        }
    }

}

