/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.yandex.metrica.impl.h
 *  com.yandex.metrica.impl.ob.aa
 *  java.lang.Object
 */
package com.yandex.metrica.impl.ob;

import com.yandex.metrica.impl.h;
import com.yandex.metrica.impl.ob.aa;
import com.yandex.metrica.impl.ob.x;

public abstract class v<T> {
    private final aa<T> a;

    protected v(aa<T> aa2) {
        this.a = aa2;
    }

    public boolean a(h h2) {
        return this.a(h2, this.b(h2));
    }

    protected abstract boolean a(h var1, x<T> var2);

    x<T> b(h h2) {
        return this.a.a(h2.c());
    }
}

