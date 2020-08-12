/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  java.lang.Integer
 *  java.lang.String
 */
package com.tapjoy.internal;

import android.content.SharedPreferences;
import com.tapjoy.internal.o;

public final class m
extends o {
    private final int c;

    public m(SharedPreferences sharedPreferences, String string, int n2) {
        super(sharedPreferences, string);
        this.c = n2;
    }

    public final SharedPreferences.Editor a(SharedPreferences.Editor editor, int n2) {
        return editor.putInt(this.b, n2);
    }

    public final Integer a() {
        return this.b();
    }

    public final void a(int n2) {
        this.a.edit().putInt(this.b, n2).commit();
    }

    public final void a(Integer n2) {
        if (n2 != null) {
            this.a((int)n2);
            return;
        }
        this.c();
    }

    public final int b() {
        return this.a.getInt(this.b, this.c);
    }
}

