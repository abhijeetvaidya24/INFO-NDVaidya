/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 */
package com.appnext.base;

public final class a {
    private int ds;

    public a(int n2) {
        this.ds = n2;
    }

    public final int V() {
        return this.ds;
    }

    public static final class a
    extends Enum<a> {
        private static final /* synthetic */ int[] $VALUES$47a19cef;
        public static final int Internal$1d8b5b4a = 1;
        public static final int NoInternet$1d8b5b4a = 2;
        public static final int NoPermission$1d8b5b4a = 3;

        static {
            int[] arrn = new int[]{Internal$1d8b5b4a, NoInternet$1d8b5b4a, NoPermission$1d8b5b4a};
            $VALUES$47a19cef = arrn;
        }

        public static int[] W() {
            return (int[])$VALUES$47a19cef.clone();
        }
    }

}

