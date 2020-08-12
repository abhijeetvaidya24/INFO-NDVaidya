/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  java.lang.Object
 *  java.lang.String
 */
package com.tapjoy.internal;

import android.content.SharedPreferences;

public abstract class o {
    protected SharedPreferences a;
    protected String b;

    public o(SharedPreferences sharedPreferences, String string2) {
        this.a = sharedPreferences;
        this.b = string2;
    }

    public final void c() {
        this.a.edit().remove(this.b).commit();
    }
}

