/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.util.NoSuchElementException
 */
package com.moat.analytics.mobile.tjy.base.functional;

import java.util.NoSuchElementException;

public final class a {
    private static final a a = new a();
    private final Object b;

    private a() {
        this.b = null;
    }

    private a(Object object) {
        if (object != null) {
            this.b = object;
            return;
        }
        throw new NullPointerException("Optional of null value.");
    }

    public static a a() {
        return a;
    }

    public static a a(Object object) {
        return new a(object);
    }

    public static a b(Object object) {
        if (object == null) {
            return a.a();
        }
        return a.a(object);
    }

    public final Object b() {
        Object object = this.b;
        if (object != null) {
            return object;
        }
        throw new NoSuchElementException("No value present");
    }

    public final Object c(Object object) {
        Object object2 = this.b;
        if (object2 != null) {
            return object2;
        }
        return object;
    }

    public final boolean c() {
        return this.b != null;
    }

    public final boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof a)) {
            return false;
        }
        a a2 = (a)object;
        Object object2 = this.b;
        Object object3 = a2.b;
        if (object2 == object3) {
            return true;
        }
        if (object2 != null) {
            if (object3 == null) {
                return false;
            }
            return object2.equals(object3);
        }
        return false;
    }

    public final int hashCode() {
        Object object = this.b;
        if (object == null) {
            return 0;
        }
        return object.hashCode();
    }

    public final String toString() {
        Object object = this.b;
        if (object != null) {
            return String.format((String)"Optional[%s]", (Object[])new Object[]{object});
        }
        return "Optional.empty";
    }
}

