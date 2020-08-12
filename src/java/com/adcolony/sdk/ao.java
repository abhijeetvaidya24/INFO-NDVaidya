/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.media.SoundPool
 *  android.media.SoundPool$OnLoadCompleteListener
 *  java.lang.Boolean
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.util.HashMap
 *  org.json.JSONObject
 */
package com.adcolony.sdk;

import android.annotation.SuppressLint;
import android.media.SoundPool;
import com.adcolony.sdk.ad;
import com.adcolony.sdk.w;
import com.adcolony.sdk.y;
import java.util.HashMap;
import org.json.JSONObject;

@SuppressLint(value={"UseSparseArrays"})
class ao {
    final String a;
    private final int b;
    private HashMap<Integer, Integer> c = new HashMap();
    private HashMap<Integer, Integer> d = new HashMap();
    private HashMap<Integer, Boolean> e = new HashMap();
    private HashMap<Integer, Integer> f = new HashMap();
    private HashMap<Integer, Integer> g = new HashMap();
    private HashMap<String, Integer> h = new HashMap();
    private SoundPool i;

    ao(final String string, final int n2) {
        this.a = string;
        this.b = n2;
        this.i = new SoundPool(50, 3, 0);
        this.i.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener(){

            public void onLoadComplete(SoundPool soundPool, int n22, int n3) {
                JSONObject jSONObject = w.a();
                w.b(jSONObject, "id", (Integer)ao.this.f.get((Object)n22));
                w.a(jSONObject, "ad_session_id", string);
                if (n3 == 0) {
                    new ad("AudioPlayer.on_ready", n2, jSONObject).b();
                    ao.this.g.put(ao.this.f.get((Object)n22), (Object)n22);
                    return;
                }
                new ad("AudioPlayer.on_error", n2, jSONObject).b();
            }
        });
    }

    SoundPool a() {
        return this.i;
    }

    void a(ad ad2) {
        JSONObject jSONObject = ad2.c();
        int n2 = this.i.load(w.b(jSONObject, "filepath"), 1);
        int n3 = w.d(jSONObject, "repeats") ? -1 : 0;
        this.f.put((Object)n2, (Object)w.c(jSONObject, "id"));
        new y.a().a("Load audio with id = ").a(n2).a(y.d);
        this.d.put((Object)n2, (Object)n3);
        this.e.put((Object)n2, (Object)false);
    }

    void b(ad ad2) {
        this.i.unload(((Integer)this.g.get((Object)w.c(ad2.c(), "id"))).intValue());
    }

    void c(ad ad2) {
        int n2 = (Integer)this.g.get((Object)w.c(ad2.c(), "id"));
        if (!((Boolean)this.e.get((Object)n2)).booleanValue()) {
            int n3 = this.i.play(n2, 1.0f, 1.0f, 0, ((Integer)this.d.get((Object)n2)).intValue(), 1.0f);
            if (n3 != 0) {
                this.c.put((Object)n2, (Object)n3);
                return;
            }
            JSONObject jSONObject = w.a();
            w.b(jSONObject, "id", w.c(ad2.c(), "id"));
            w.a(jSONObject, "ad_session_id", this.a);
            new ad("AudioPlayer.on_error", this.b, jSONObject).b();
            return;
        }
        this.i.resume(((Integer)this.c.get((Object)n2)).intValue());
    }

    void d(ad ad2) {
        int n2 = (Integer)this.g.get((Object)w.c(ad2.c(), "id"));
        this.i.pause(((Integer)this.c.get((Object)n2)).intValue());
        this.e.put((Object)n2, (Object)true);
    }

    void e(ad ad2) {
        this.i.stop(((Integer)this.c.get(this.g.get((Object)w.c(ad2.c(), "id")))).intValue());
    }

}

