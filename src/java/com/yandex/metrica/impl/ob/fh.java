/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.text.TextUtils
 *  android.util.Log
 *  com.yandex.metrica.impl.ob.fh$1
 *  com.yandex.metrica.impl.ob.fh$2
 *  com.yandex.metrica.impl.ob.fi
 *  com.yandex.metrica.impl.ob.fv
 *  java.lang.CharSequence
 *  java.lang.InterruptedException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.util.HashMap
 *  java.util.Map
 *  java.util.concurrent.ExecutionException
 *  java.util.concurrent.TimeUnit
 *  java.util.concurrent.TimeoutException
 *  java.util.concurrent.locks.ReentrantLock
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.yandex.metrica.impl.ob;

import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.yandex.metrica.impl.ob.ey;
import com.yandex.metrica.impl.ob.fb;
import com.yandex.metrica.impl.ob.fd;
import com.yandex.metrica.impl.ob.fe;
import com.yandex.metrica.impl.ob.fh;
import com.yandex.metrica.impl.ob.fi;
import com.yandex.metrica.impl.ob.fj;
import com.yandex.metrica.impl.ob.fs;
import com.yandex.metrica.impl.ob.fu;
import com.yandex.metrica.impl.ob.fv;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class fh {
    private static final String a = "fh";
    private fb b;
    private fb c;
    private fs d;
    private Map<String, String> e;
    private fi f;
    private String g;
    private fj h;
    private long i;
    private final ReentrantLock j;

    fh(fe fe2, ey ey2, fs fs2, fd fd2) {
        this.b = ey2.c();
        this.c = ey2.a();
        this.d = fs2;
        this.g = fd2.b();
        this.j = new ReentrantLock();
        this.e = new HashMap();
        this.e.put((Object)"app_id", (Object)fe2.c());
        Map<String, String> map = this.e;
        StringBuilder stringBuilder = new StringBuilder("android_");
        stringBuilder.append(Build.VERSION.RELEASE);
        map.put((Object)"app_platform", (Object)stringBuilder.toString());
        this.e.put((Object)"manufacturer", (Object)Build.MANUFACTURER);
        this.e.put((Object)"model", (Object)Build.MODEL);
        this.e.put((Object)"app_version", (Object)fe2.a());
        this.i = fd2.a();
    }

    static /* synthetic */ fi a(fh fh2, fi fi2) {
        fh2.f = fi2;
        return fi2;
    }

    static /* synthetic */ void a(fh fh2) {
        fh2.h();
    }

    private static void a(JSONArray jSONArray, fb fb2) throws JSONException {
        fb2.a();
        for (int i2 = 0; i2 < jSONArray.length(); ++i2) {
            fb2.a(jSONArray.getString(i2));
        }
    }

    private static boolean a(fb fb2, long l2) {
        long l3 = System.currentTimeMillis();
        return l3 - fb2.c() >= l2 || l3 < fb2.c();
        {
        }
    }

    static /* synthetic */ boolean a(fh fh2, JSONObject jSONObject) {
        return fh2.a(jSONObject);
    }

    private boolean a(JSONObject jSONObject) {
        try {
            fh.a(jSONObject.getJSONArray("pins-sha256"), this.b);
            fh.a(jSONObject.getJSONArray("blacklist"), this.c);
        }
        catch (JSONException jSONException) {
            String string2 = a;
            StringBuilder stringBuilder = new StringBuilder("can't update pins: ");
            stringBuilder.append(jSONException.getMessage());
            Log.i((String)string2, (String)stringBuilder.toString());
            return false;
        }
        Log.i((String)a, (String)"pins have been updated");
        return true;
    }

    static /* synthetic */ String f() {
        return a;
    }

    private JSONObject g() {
        void var1_7;
        try {
            fv fv2 = fv.a();
            fi fi2 = this.i();
            this.d.a(fi2, fv2, (fu.a)fv2);
            JSONObject jSONObject = (JSONObject)fv2.get(30000L, TimeUnit.MILLISECONDS);
            return jSONObject;
        }
        catch (TimeoutException timeoutException) {
        }
        catch (ExecutionException executionException) {
        }
        catch (InterruptedException interruptedException) {
            // empty catch block
        }
        String string2 = a;
        StringBuilder stringBuilder = new StringBuilder("can't update pins on error: ");
        stringBuilder.append(var1_7.getMessage());
        Log.i((String)string2, (String)stringBuilder.toString());
        return null;
    }

    private void h() {
        this.b.d();
        this.c.d();
    }

    private fi i() {
        String string2 = this.h.a();
        if (TextUtils.isEmpty((CharSequence)string2)) {
            this.e.remove((Object)"uuid");
        } else {
            this.e.put((Object)"uuid", (Object)string2);
        }
        return new fi(this.g, this.e);
    }

    private boolean j() {
        return this.d != null;
    }

    ReentrantLock a() {
        return this.j;
    }

    void a(fj fj2) {
        fh fh2 = this;
        synchronized (fh2) {
            this.h = fj2;
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    boolean b() {
        fh fh2 = this;
        synchronized (fh2) {
            if (!this.j()) return false;
            Log.i((String)a, (String)"starting pins update on error");
            JSONObject jSONObject = this.g();
            if (jSONObject != null) {
                return this.a(jSONObject);
            }
            this.h();
            return false;
        }
    }

    void c() {
        fh fh2 = this;
        synchronized (fh2) {
            if (this.d() && this.j()) {
                Log.i((String)a, (String)"starting pins update on schedule");
                this.f = this.i();
                this.d.a(this.f, new 1(this), (fu.a)new 2(this));
            }
            return;
        }
    }

    boolean d() {
        return !this.e() && (fh.a(this.b, this.i) || fh.a(this.c, this.i));
    }

    boolean e() {
        return this.f != null;
    }
}

