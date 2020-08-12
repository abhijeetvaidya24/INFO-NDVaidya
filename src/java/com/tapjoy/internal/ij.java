/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  java.lang.Throwable
 */
package com.tapjoy.internal;

public final class ij {
    public static ij a = new ij(null);
    public String b;
    public Throwable c;
    private Object[] d;

    public ij(String string2) {
        this(string2, null, null);
    }

    public ij(String string2, Object[] arrobject, Throwable throwable) {
        this.b = string2;
        this.c = throwable;
        if (throwable == null) {
            this.d = arrobject;
            return;
        }
        if (arrobject != null && arrobject.length != 0) {
            int n2 = -1 + arrobject.length;
            Object[] arrobject2 = new Object[n2];
            System.arraycopy((Object)arrobject, (int)0, (Object)arrobject2, (int)0, (int)n2);
            this.d = arrobject2;
            return;
        }
        throw new IllegalStateException("non-sensical empty or null argument array");
    }
}

