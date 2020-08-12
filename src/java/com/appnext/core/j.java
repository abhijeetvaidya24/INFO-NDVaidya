/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Thread
 *  java.util.HashMap
 */
package com.appnext.core;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.HashMap;

public final class j {
    private static j hs;
    private int be = 24;
    private HashMap<String, SharedPreferences> ht = new HashMap();

    private j() {
    }

    public static j bh() {
        Class<j> class_ = j.class;
        synchronized (j.class) {
            if (hs == null) {
                hs = new j();
            }
            j j2 = hs;
            // ** MonitorExit[var2] (shouldn't be in output)
            return j2;
        }
    }

    public final void ac(String string2) {
        ((SharedPreferences)this.ht.get((Object)string2)).edit().clear().apply();
    }

    public final void b(int n2) {
        this.be = n2;
    }

    public final void d(final Context context, final String string2) {
        if (!this.ht.containsKey((Object)string2.replace((CharSequence)"/", (CharSequence)""))) {
            new Thread(new Runnable(){

                public final void run() {
                    HashMap hashMap = j.this.ht;
                    String string22 = string2;
                    Context context2 = context;
                    StringBuilder stringBuilder = new StringBuilder("apnxt_cap");
                    stringBuilder.append(string2.replace((CharSequence)"/", (CharSequence)""));
                    hashMap.put((Object)string22, (Object)context2.getSharedPreferences(stringBuilder.toString(), 0));
                }
            }).start();
        }
    }

    public final void n(String string2, String string3) {
        ((SharedPreferences)this.ht.get((Object)string3)).edit().putLong(string2, System.currentTimeMillis()).apply();
    }

    public final boolean o(String string2, String string3) {
        long l2 = ((SharedPreferences)this.ht.get((Object)string3)).getLong(string2, -1L);
        return l2 != -1L && System.currentTimeMillis() - (long)(3600000 * this.be) <= l2;
    }

    public final boolean p(String string2, String string3) {
        long l2 = ((SharedPreferences)this.ht.get((Object)string3)).getLong(string2, -1L);
        return l2 != -1L && System.currentTimeMillis() - 120000L <= l2;
    }

}

