/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 */
package com.yandex.metrica.impl.utils;

import android.util.Log;

public abstract class c {
    private volatile boolean a = false;

    public c(boolean bl2) {
        this.a = bl2;
    }

    private static String d(String string2) {
        if (string2 == null) {
            string2 = "";
        }
        return string2;
    }

    private String d(String string2, Object[] arrobject) {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.e());
            stringBuilder.append(this.c(c.d(string2), arrobject));
            String string3 = stringBuilder.toString();
            return string3;
        }
        catch (Throwable throwable) {
            return this.c();
        }
    }

    public void a() {
        this.a = true;
    }

    void a(int n2, String string2) {
        if (this.a) {
            String string3 = this.d();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.e());
            stringBuilder.append(c.d(string2));
            Log.println((int)n2, (String)string3, (String)stringBuilder.toString());
        }
    }

    /* varargs */ void a(int n2, String string2, Object ... arrobject) {
        if (this.a) {
            Log.println((int)n2, (String)this.d(), (String)this.d(string2, arrobject));
        }
    }

    public void a(String string2) {
        this.a(4, string2);
    }

    public /* varargs */ void a(String string2, Object ... arrobject) {
        this.a(4, string2, arrobject);
    }

    public void b(String string2) {
        this.a(5, string2);
    }

    public /* varargs */ void b(String string2, Object ... arrobject) {
        this.a(5, string2, arrobject);
    }

    public boolean b() {
        return this.a;
    }

    String c() {
        return this.e();
    }

    abstract String c(String var1, Object[] var2);

    public void c(String string2) {
        this.a(6, string2);
    }

    abstract String d();

    abstract String e();
}

