/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package com.yandex.metrica.impl.ob;

import android.os.Bundle;

public final class du
extends Enum<du> {
    public static final /* enum */ du a = new du(0);
    public static final /* enum */ du b = new du(1);
    public static final /* enum */ du c = new du(2);
    private static final /* synthetic */ du[] e;
    private int d;

    static {
        du[] arrdu = new du[]{a, b, c};
        e = arrdu;
    }

    private du(int n3) {
        this.d = n3;
    }

    public static du b(Bundle bundle) {
        int n2 = bundle.getInt("startup_error_key_code");
        du du2 = a;
        if (n2 != 1) {
            if (n2 != 2) {
                return du2;
            }
            return c;
        }
        return b;
    }

    public static du valueOf(String string2) {
        return (du)Enum.valueOf(du.class, (String)string2);
    }

    public static du[] values() {
        return (du[])e.clone();
    }

    public int a() {
        return this.d;
    }

    public Bundle a(Bundle bundle) {
        bundle.putInt("startup_error_key_code", this.a());
        return bundle;
    }
}

