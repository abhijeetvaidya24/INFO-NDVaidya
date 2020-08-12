/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  java.lang.Boolean
 *  java.lang.Object
 *  java.lang.String
 */
package com.tapjoy.internal;

import android.content.Context;
import android.content.SharedPreferences;

public final class fh {
    private static final fh d;
    private static fh e;
    public Boolean a = null;
    public String b = null;
    public boolean c = false;
    private Context f;

    static {
        fh fh2;
        d = fh2 = new fh();
        e = fh2;
    }

    public static fh a() {
        return e;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void a(Context context) {
        fh fh2 = this;
        synchronized (fh2) {
            block7 : {
                boolean bl2;
                block10 : {
                    block8 : {
                        boolean bl3;
                        block9 : {
                            if (context != null && this.f == null) {
                                this.f = context;
                            }
                            fh fh3 = e;
                            if (fh3.f != null) {
                                SharedPreferences sharedPreferences = fh3.f.getSharedPreferences("tjcPrefrences", 0);
                                if (fh3.a == null && sharedPreferences.contains("gdpr")) {
                                    fh3.a = sharedPreferences.getBoolean("gdpr", false);
                                }
                                if (fh3.b == null) {
                                    fh3.b = sharedPreferences.getString("cgdpr", "");
                                }
                            }
                            if (!this.c) break block7;
                            fh fh4 = e;
                            if (fh4.f == null) break block8;
                            bl3 = fh4.a != null ? fh4.b() : false;
                            if (fh4.b == null) break block9;
                            if (!bl3 || !fh4.c()) break block8;
                            bl2 = true;
                            break block10;
                        }
                        bl2 = bl3;
                        break block10;
                    }
                    bl2 = false;
                }
                boolean bl4 = false;
                if (!bl2) {
                    bl4 = true;
                }
                this.c = bl4;
            }
            return;
        }
    }

    public final boolean b() {
        Context context = this.f;
        if (context != null) {
            SharedPreferences.Editor editor = context.getSharedPreferences("tjcPrefrences", 0).edit();
            editor.putBoolean("gdpr", this.a.booleanValue());
            editor.commit();
            return true;
        }
        return false;
    }

    public final boolean c() {
        Context context = this.f;
        if (context != null) {
            SharedPreferences.Editor editor = context.getSharedPreferences("tjcPrefrences", 0).edit();
            editor.putString("cgdpr", this.b);
            editor.commit();
            return true;
        }
        return false;
    }
}

