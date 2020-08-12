/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  java.lang.Boolean
 *  java.lang.String
 */
package com.tapjoy.internal;

import android.content.SharedPreferences;
import com.tapjoy.internal.o;

public final class j
extends o {
    private final boolean c = false;

    public j(SharedPreferences sharedPreferences, String string) {
        super(sharedPreferences, string);
    }

    public final Boolean a() {
        return this.a.getBoolean(this.b, this.c);
    }

    public final void a(boolean bl) {
        this.a.edit().putBoolean(this.b, bl).commit();
    }
}

