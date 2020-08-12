/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Build
 *  android.os.Build$VERSION
 *  com.moat.analytics.mobile.mpub.k
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  org.json.JSONArray
 *  org.json.JSONObject
 */
package com.moat.analytics.mobile.mpub;

import android.os.Build;
import com.moat.analytics.mobile.mpub.MoatAnalytics;
import com.moat.analytics.mobile.mpub.k;
import com.moat.analytics.mobile.mpub.m;
import com.moat.analytics.mobile.mpub.s;
import com.moat.analytics.mobile.mpub.w;
import org.json.JSONArray;
import org.json.JSONObject;

class l {
    private boolean a = false;
    private boolean b = false;
    private boolean c = false;
    private int d = 200;
    private int e = 10;

    l(String string2) {
        this.a(string2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void a(String string2) {
        if (string2 == null) {
            return;
        }
        try {
            int n2;
            JSONObject jSONObject = new JSONObject(string2);
            String string3 = jSONObject.getString("sa");
            boolean bl2 = string3.equals((Object)"9d24c90729bf464dce5d8fd1ace14a60656dbb2d");
            boolean bl3 = string3.equals((Object)"8f1d08a2d6496191a5ebae8f0590f513e2619489");
            if ((string3.equals((Object)"on") || bl2 || bl3) && !this.a(jSONObject) && !this.b(jSONObject)) {
                this.a = true;
                this.b = bl2;
                this.c = bl3;
                if (this.c) {
                    this.b = true;
                }
            }
            if (jSONObject.has("in") && (n2 = jSONObject.getInt("in")) >= 100 && n2 <= 1000) {
                this.d = n2;
            }
            if (jSONObject.has("es")) {
                this.e = jSONObject.getInt("es");
            }
            if (!this.c(jSONObject)) return;
            ((k)MoatAnalytics.getInstance()).c = true;
            return;
        }
        catch (Exception exception) {
            this.a = false;
            this.b = false;
            this.d = 200;
            m.a(exception);
        }
    }

    private boolean a(JSONObject jSONObject) {
        block6 : {
            JSONArray jSONArray;
            int n2;
            block5 : {
                if (16 <= Build.VERSION.SDK_INT) break block5;
                return true;
            }
            try {
                if (!jSONObject.has("ob")) break block6;
                jSONArray = jSONObject.getJSONArray("ob");
                n2 = jSONArray.length();
            }
            catch (Exception exception) {
                return true;
            }
            for (int i2 = 0; i2 < n2; ++i2) {
                int n3 = jSONArray.getInt(i2);
                int n4 = Build.VERSION.SDK_INT;
                if (n3 != n4) continue;
                return true;
            }
        }
        return false;
    }

    private boolean b(JSONObject jSONObject) {
        block4 : {
            if (!jSONObject.has("ap")) break block4;
            String string2 = s.d().b();
            JSONArray jSONArray = jSONObject.getJSONArray("ap");
            int n2 = jSONArray.length();
            for (int i2 = 0; i2 < n2; ++i2) {
                try {
                    boolean bl2 = jSONArray.getString(i2).contentEquals((CharSequence)string2);
                    if (!bl2) continue;
                    return true;
                }
                catch (Exception exception) {
                    m.a(exception);
                    break;
                }
            }
        }
        return false;
    }

    private boolean c(JSONObject jSONObject) {
        block4 : {
            if (!jSONObject.has("al")) break block4;
            String string2 = s.d().b();
            JSONArray jSONArray = jSONObject.getJSONArray("al");
            int n2 = jSONArray.length();
            for (int i2 = 0; i2 < n2; ++i2) {
                try {
                    boolean bl2 = jSONArray.getString(i2).contentEquals((CharSequence)string2);
                    if (!bl2) continue;
                    return true;
                }
                catch (Exception exception) {
                    m.a(exception);
                    break;
                }
            }
        }
        return false;
    }

    boolean a() {
        return this.b;
    }

    boolean b() {
        return this.c;
    }

    int c() {
        return this.d;
    }

    int d() {
        return this.e;
    }

    w.d e() {
        if (this.a) {
            return w.d.b;
        }
        return w.d.a;
    }
}

