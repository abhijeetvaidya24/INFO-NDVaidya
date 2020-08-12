/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.yandex.metrica.impl.be
 *  com.yandex.metrica.impl.be$a
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.yandex.metrica.impl.ob;

import com.yandex.metrica.impl.be;
import com.yandex.metrica.impl.ob.ch;
import com.yandex.metrica.impl.ob.cj;

class ce {
    private final ch a;
    private final be.a b;

    ce(be.a a2, ch ch2) {
        this.a = ch2;
        this.b = a2;
    }

    public a a(cj cj2) {
        return a.a;
    }

    public String a() {
        return this.a.c();
    }

    public ch b() {
        return this.a;
    }

    public be.a c() {
        return this.b;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Bid{mCredentials='");
        stringBuilder.append((Object)this.a);
        stringBuilder.append('\'');
        stringBuilder.append(", mDescriptor=");
        stringBuilder.append((Object)this.b);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    static final class a
    extends Enum<a> {
        public static final /* enum */ a a = new a();
        public static final /* enum */ a b = new a();
        public static final /* enum */ a c = new a();
        private static final /* synthetic */ a[] d;

        static {
            a[] arra = new a[]{a, b, c};
            d = arra;
        }

        public static a valueOf(String string2) {
            return (a)Enum.valueOf(a.class, (String)string2);
        }

        public static a[] values() {
            return (a[])d.clone();
        }
    }

}

