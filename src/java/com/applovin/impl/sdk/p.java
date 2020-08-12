/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  java.lang.Boolean
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 */
package com.applovin.impl.sdk;

import android.util.Log;
import com.applovin.impl.sdk.b.b;
import com.applovin.impl.sdk.b.c;
import com.applovin.impl.sdk.c.f;
import com.applovin.impl.sdk.j;

public class p {
    private final j a;

    p(j j2) {
        this.a = j2;
    }

    private boolean a() {
        return this.a.v().d();
    }

    public void a(String string2, Boolean bl, String string3) {
        this.a(string2, bl, string3, null);
    }

    public void a(String string2, Boolean bl, String string3, Throwable throwable) {
        if (this.a()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("[");
            stringBuilder.append(string2);
            stringBuilder.append("] ");
            stringBuilder.append(string3);
            Log.e((String)"AppLovinSdk", (String)stringBuilder.toString(), (Throwable)throwable);
        }
        if (bl.booleanValue() && this.a.a(b.eJ).booleanValue() && this.a.H() != null) {
            this.a.H().a(string3, throwable);
        }
    }

    public void a(String string2, String string3) {
        if (this.a()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("[");
            stringBuilder.append(string2);
            stringBuilder.append("] ");
            stringBuilder.append(string3);
            Log.d((String)"AppLovinSdk", (String)stringBuilder.toString());
        }
    }

    public void a(String string2, String string3, Throwable throwable) {
        if (this.a()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("[");
            stringBuilder.append(string2);
            stringBuilder.append("] ");
            stringBuilder.append(string3);
            Log.w((String)"AppLovinSdk", (String)stringBuilder.toString(), (Throwable)throwable);
        }
    }

    public void b(String string2, String string3) {
        if (this.a()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("[");
            stringBuilder.append(string2);
            stringBuilder.append("] ");
            stringBuilder.append(string3);
            Log.i((String)"AppLovinSdk", (String)stringBuilder.toString());
        }
    }

    public void b(String string2, String string3, Throwable throwable) {
        this.a(string2, true, string3, throwable);
    }

    public void c(String string2, String string3) {
        this.a(string2, string3, null);
    }

    public void c(String string2, String string3, Throwable throwable) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        stringBuilder.append(string2);
        stringBuilder.append("] ");
        stringBuilder.append(string3);
        Log.e((String)"AppLovinSdk", (String)stringBuilder.toString(), (Throwable)throwable);
    }

    public void d(String string2, String string3) {
        this.b(string2, string3, null);
    }

    public void e(String string2, String string3) {
        this.c(string2, string3, null);
    }
}

