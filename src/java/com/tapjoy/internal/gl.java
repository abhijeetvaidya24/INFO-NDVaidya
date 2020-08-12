/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 *  com.tapjoy.internal.q
 *  java.lang.Object
 *  java.lang.String
 *  java.text.SimpleDateFormat
 *  java.util.Date
 *  java.util.Locale
 */
package com.tapjoy.internal;

import android.content.Context;
import android.content.SharedPreferences;
import com.tapjoy.internal.q;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public final class gl {
    final q a;
    public final q b;
    private final SharedPreferences c;

    public gl(Context context) {
        this.c = context.getApplicationContext().getSharedPreferences("fiverocks", 0);
        this.a = new q(this.c, "noMoreToday.date");
        this.b = new q(this.c, "noMoreToday.actionIds");
        this.b();
    }

    static String a() {
        return new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
    }

    public final void b() {
        String string2 = this.a.a();
        if (string2 == null) {
            return;
        }
        if (!gl.a().equals((Object)string2)) {
            this.a.a(null);
            this.b.a(null);
        }
    }
}

