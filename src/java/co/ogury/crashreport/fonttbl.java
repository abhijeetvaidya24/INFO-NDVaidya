/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  java.lang.Object
 *  java.lang.String
 */
package co.ogury.crashreport;

import android.content.Context;
import android.content.SharedPreferences;
import co.ogury.crashreport.tx8640;

public final class fonttbl {
    private final SharedPreferences a;

    static {
        new rtf1(0);
    }

    public fonttbl(Context context) {
        tx8640.b((Object)context, "context");
        this.a = context.getSharedPreferences("crashreport", 0);
    }

    public final String a(String string) {
        tx8640.b(string, "key");
        String string2 = this.a.getString(string, "");
        if (string2 == null) {
            string2 = "";
        }
        return string2;
    }

    public final void a(String string, String string2) {
        tx8640.b(string, "key");
        tx8640.b(string2, "uploadUrl");
        this.a.edit().putString(string, string2).apply();
    }

    public static final class rtf1 {
        private rtf1() {
        }

        public /* synthetic */ rtf1(byte by2) {
            this();
        }
    }

}

