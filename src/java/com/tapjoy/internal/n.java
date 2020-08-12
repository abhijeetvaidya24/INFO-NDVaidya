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

public final class n
extends o {
    private final long c = 0L;

    public n(SharedPreferences sharedPreferences, String string) {
        super(sharedPreferences, string);
    }

    public final long a() {
        return this.a.getLong(this.b, this.c);
    }

    public final SharedPreferences.Editor a(SharedPreferences.Editor editor) {
        return editor.remove(this.b);
    }

    public final SharedPreferences.Editor a(SharedPreferences.Editor editor, long l2) {
        return editor.putLong(this.b, l2);
    }

    public final void a(long l2) {
        this.a.edit().putLong(this.b, l2).commit();
    }
}

