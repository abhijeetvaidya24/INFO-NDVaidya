/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  io.presage.bu
 *  java.io.File
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package io.presage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import io.presage.bu;
import io.presage.cl;
import java.io.File;

public final class CarreMirabelle {
    public static final CamembertauCalvados a = new CamembertauCalvados(0);
    @SuppressLint(value={"StaticFieldLeak"})
    private static CarreMirabelle d;
    private final SharedPreferences b;
    private final Context c;

    private CarreMirabelle(Context context) {
        this.c = context;
        this.b = this.c.getSharedPreferences("mraid", 0);
    }

    public /* synthetic */ CarreMirabelle(Context context, byte by) {
        this(context);
    }

    public static final /* synthetic */ void a(CarreMirabelle carreMirabelle) {
        d = carreMirabelle;
    }

    public final String a() {
        String string2 = this.b.getString("mraid_download_url", "");
        cl.a((Object)string2, "sharedPref.getString(Mra\u2026o.MRAID_DOWNLOAD_URL, \"\")");
        return string2;
    }

    public final void a(String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        File file = this.c.getFilesDir();
        cl.a((Object)file, "context.filesDir");
        stringBuilder.append(file.getPath().toString());
        stringBuilder.append("/mraidJs.txt");
        bu.a((File)new File(stringBuilder.toString()), (String)string2);
    }

    public final String b() {
        StringBuilder stringBuilder = new StringBuilder();
        File file = this.c.getFilesDir();
        cl.a((Object)file, "context.filesDir");
        stringBuilder.append(file.getPath().toString());
        stringBuilder.append("/mraidJs.txt");
        File file2 = new File(stringBuilder.toString());
        if (file2.exists()) {
            return bu.b((File)file2);
        }
        return "";
    }

    public final void b(String string2) {
        this.b.edit().putString("mraid_download_url", string2).apply();
    }

    public static final class CamembertauCalvados {
        private CamembertauCalvados() {
        }

        public /* synthetic */ CamembertauCalvados(byte by) {
            this();
        }

        public static CarreMirabelle a(Context context) {
            CarreMirabelle carreMirabelle;
            if (d == null) {
                Context context2 = context.getApplicationContext();
                cl.a((Object)context2, "context.applicationContext");
                CarreMirabelle.a(new CarreMirabelle(context2, 0));
            }
            if ((carreMirabelle = d) == null) {
                cl.a();
            }
            return carreMirabelle;
        }
    }

}

