/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.media.SoundPool
 *  java.lang.Boolean
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.util.HashMap
 *  org.json.JSONObject
 */
package com.adcolony.sdk;

import android.media.SoundPool;
import com.adcolony.sdk.ac;
import com.adcolony.sdk.ad;
import com.adcolony.sdk.ao;
import com.adcolony.sdk.w;
import java.util.HashMap;
import org.json.JSONObject;

class f {
    String a;
    private HashMap<Integer, Boolean> b = new HashMap();
    private ao c;
    private ac d;
    private int e;

    f(String string, int n2) {
        this.a = string;
        this.e = n2;
    }

    void a() {
        this.c.a().autoPause();
        this.d.a();
    }

    void a(ad ad2) {
        if (this.c == null) {
            this.c = new ao(this.a, this.e);
            this.d = new ac(this.a, this.e);
        }
        int n2 = w.c(ad2.c(), "id");
        if (w.d(ad2.c(), "use_sound_pool")) {
            this.b.put((Object)n2, (Object)true);
            this.c.a(ad2);
            return;
        }
        this.b.put((Object)n2, (Object)false);
        this.d.a(ad2);
    }

    void b() {
        this.c.a().autoResume();
        this.d.b();
    }

    void b(ad ad2) {
        if (((Boolean)this.b.get((Object)w.c(ad2.c(), "id"))).booleanValue()) {
            this.c.d(ad2);
            return;
        }
        this.d.b(ad2);
    }

    ac c() {
        return this.d;
    }

    void c(ad ad2) {
        if (((Boolean)this.b.get((Object)w.c(ad2.c(), "id"))).booleanValue()) {
            this.c.c(ad2);
            return;
        }
        this.d.c(ad2);
    }

    ao d() {
        return this.c;
    }

    void d(ad ad2) {
        if (((Boolean)this.b.get((Object)w.c(ad2.c(), "id"))).booleanValue()) {
            this.c.b(ad2);
            return;
        }
        this.d.d(ad2);
    }

    void e(ad ad2) {
        if (((Boolean)this.b.get((Object)w.c(ad2.c(), "id"))).booleanValue()) {
            this.c.e(ad2);
            return;
        }
        this.d.e(ad2);
    }
}

