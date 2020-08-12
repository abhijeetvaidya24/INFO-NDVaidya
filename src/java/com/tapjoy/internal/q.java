/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  java.lang.String
 */
package com.tapjoy.internal;

import android.content.SharedPreferences;
import com.tapjoy.internal.o;

public final class q
extends o {
    private final String c = null;

    public q(SharedPreferences sharedPreferences, String string) {
        super(sharedPreferences, string);
    }

    public final SharedPreferences.Editor a(SharedPreferences.Editor editor, String string) {
        if (string != null) {
            return editor.putString(this.b, string);
        }
        return editor.remove(this.b);
    }

    public final String a() {
        return this.a.getString(this.b, this.c);
    }

    public final void a(String string) {
        this.a.edit().putString(this.b, string).commit();
    }
}

