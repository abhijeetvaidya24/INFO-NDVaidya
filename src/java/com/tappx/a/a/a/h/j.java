/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  java.lang.Boolean
 *  java.lang.NoSuchFieldError
 *  java.lang.Object
 *  java.lang.String
 */
package com.tappx.a.a.a.h;

import android.content.SharedPreferences;
import com.tappx.a.a.a.h.i;

final class j {
    private final SharedPreferences s;

    j(SharedPreferences sharedPreferences) {
        this.s = sharedPreferences;
    }

    private int b(i i2) {
        int n2 = 1.a[i2.ordinal()];
        if (n2 != 1) {
            if (n2 != 2) {
                if (n2 != 3) {
                    return n2 == 4;
                }
                return 2;
            }
            return -1;
        }
        return -2;
    }

    private int b(Boolean bl2) {
        if (bl2 == null) {
            return 0;
        }
        if (bl2.booleanValue()) {
            return 1;
        }
        return -1;
    }

    private Boolean b(int n2) {
        if (n2 != -1) {
            if (n2 != 1) {
                return null;
            }
            return true;
        }
        return true;
    }

    private i c(int n2) {
        if (n2 != -2) {
            if (n2 != -1) {
                if (n2 != 1) {
                    if (n2 != 2) {
                        return i.e;
                    }
                    return i.a;
                }
                return i.c;
            }
            return i.d;
        }
        return i.b;
    }

    public Boolean a() {
        return this.b(this.s.getInt("tappx_privacy_applies", 0));
    }

    public void a(int n2) {
        this.s.edit().putInt("tappx_privacy_version", n2).apply();
    }

    public void a(long l2) {
        this.s.edit().putLong("tappx_consent_timestamp", l2).apply();
    }

    public void a(i i2) {
        int n2 = this.b(i2);
        this.s.edit().putInt("tappx_privacy_accepted", n2).apply();
    }

    public void a(Boolean bl2) {
        this.s.edit().putInt("tappx_privacy_applies", this.b(bl2)).apply();
    }

    public void a(Boolean bl2, String string2) {
        this.s.edit().putInt("tappx_privacy_applies", this.b(bl2)).putString("tappx_privacy_consent_html", string2).apply();
    }

    public void a(String string2) {
        this.s.edit().putString("tappx_privacy_gdpr_consent", string2).apply();
    }

    public void a(boolean bl2) {
        this.s.edit().putBoolean("tappx_privacy_autoDisclaimer", bl2).apply();
    }

    public i b() {
        return this.c(this.s.getInt("tappx_privacy_accepted", 0));
    }

    public void b(String string2) {
        this.s.edit().putString("tappx_mark_choice", string2).apply();
    }

    public void b(boolean bl2) {
        if (bl2) {
            this.s.edit().putBoolean("tappx_privacy_renew", true).apply();
            return;
        }
        this.s.edit().remove("tappx_privacy_renew").apply();
    }

    public void c() {
        this.s.edit().remove("tappx_privacy_accepted").remove("tappx_sync_required").apply();
    }

    public void c(boolean bl2) {
        this.s.edit().putBoolean("tappx_sync_required", bl2).apply();
    }

    public String d() {
        return this.s.getString("tappx_privacy_consent_html", null);
    }

    public boolean e() {
        return this.s.getBoolean("tappx_privacy_autoDisclaimer", false);
    }

    public boolean f() {
        return this.s.getBoolean("tappx_privacy_renew", false);
    }

    public String g() {
        return this.s.getString("tappx_privacy_gdpr_consent", null);
    }

    public void h() {
        this.s.edit().remove("tappx_privacy_applies").remove("tappx_privacy_autoDisclaimer").remove("tappx_consent_timestamp").remove("tappx_privacy_renew").remove("tappx_privacy_consent_html").apply();
    }

    public int i() {
        return this.s.getInt("tappx_privacy_version", 0);
    }

    public boolean j() {
        return this.s.getBoolean("tappx_sync_required", false);
    }

    public long k() {
        return this.s.getLong("tappx_consent_timestamp", -1L);
    }

    public String l() {
        return this.s.getString("tappx_mark_choice", null);
    }

}

