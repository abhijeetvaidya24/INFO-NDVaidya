/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.util.NoSuchElementException
 */
package com.moat.analytics.mobile.mpub.a.b;

import java.util.NoSuchElementException;

public final class a<T> {
    private static final a<?> a = new a<T>();
    private final T b;

    private a() {
        this.b = null;
    }

    private a(T t2) {
        if (t2 != null) {
            this.b = t2;
            return;
        }
        throw new NullPointerException("Optional of null value.");
    }

    public static <T> a<T> a() {
        return a;
    }

    public static <T> a<T> a(T t2) {
        return new a<T>(t2);
    }

    public static <T> a<T> b(T t2) {
        if (t2 == null) {
            return a.a();
        }
        return a.a(t2);
    }

    public T b() {
        T t2 = this.b;
        if (t2 != null) {
            return t2;
        }
        throw new NoSuchElementException("No value present");
    }

    public T c(T t2) {
        T t3 = this.b;
        if (t3 != null) {
            t2 = t3;
        }
        return t2;
    }

    public boolean c() {
        return this.b != null;
    }

    public boolean equals(Object object) {
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        if (!(object instanceof a)) {
            return false;
        }
        a a2 = (a)object;
        T t2 = this.b;
        T t3 = a2.b;
        if (t2 != t3) {
            if (t2 != null && t3 != null && t2.equals(t3)) {
                return bl2;
            }
            bl2 = false;
        }
        return bl2;
    }

    public int hashCode() {
        T t2 = this.b;
        if (t2 == null) {
            return 0;
        }
        return t2.hashCode();
    }

    public String toString() {
        T t2 = this.b;
        if (t2 != null) {
            return String.format((String)"Optional[%s]", (Object[])new Object[]{t2});
        }
        return "Optional.empty";
    }
}

