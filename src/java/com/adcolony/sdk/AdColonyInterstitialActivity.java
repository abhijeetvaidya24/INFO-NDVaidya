/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.res.Configuration
 *  android.media.MediaPlayer
 *  android.media.SoundPool
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Looper
 *  com.adcolony.sdk.AdColonyInterstitial
 *  com.adcolony.sdk.AdColonyInterstitialListener
 *  com.adcolony.sdk.a
 *  com.adcolony.sdk.ac
 *  com.adcolony.sdk.ad
 *  com.adcolony.sdk.ao
 *  com.adcolony.sdk.b
 *  com.adcolony.sdk.c
 *  com.adcolony.sdk.d
 *  com.adcolony.sdk.f
 *  com.adcolony.sdk.g
 *  com.adcolony.sdk.k
 *  com.adcolony.sdk.w
 *  com.adcolony.sdk.y
 *  com.adcolony.sdk.y$a
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Collection
 *  java.util.HashMap
 *  java.util.concurrent.ConcurrentHashMap
 *  org.json.JSONArray
 *  org.json.JSONObject
 */
package com.adcolony.sdk;

import android.content.res.Configuration;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.adcolony.sdk.AdColonyInterstitial;
import com.adcolony.sdk.AdColonyInterstitialListener;
import com.adcolony.sdk.a;
import com.adcolony.sdk.ac;
import com.adcolony.sdk.ad;
import com.adcolony.sdk.ao;
import com.adcolony.sdk.b;
import com.adcolony.sdk.c;
import com.adcolony.sdk.d;
import com.adcolony.sdk.f;
import com.adcolony.sdk.g;
import com.adcolony.sdk.k;
import com.adcolony.sdk.w;
import com.adcolony.sdk.y;
import java.util.Collection;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class AdColonyInterstitialActivity
extends b {
    AdColonyInterstitial n;
    private k o;

    public AdColonyInterstitialActivity() {
        AdColonyInterstitial adColonyInterstitial = !a.b() ? null : a.a().u();
        this.n = adColonyInterstitial;
    }

    void a(ad ad2) {
        k k2;
        AdColonyInterstitial adColonyInterstitial;
        AdColonyInterstitial adColonyInterstitial2;
        super.a(ad2);
        d d2 = a.a().l();
        f f2 = (f)d2.g().remove((Object)this.e);
        if (f2 != null) {
            for (MediaPlayer mediaPlayer : f2.c().c().values()) {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.stop();
                }
                mediaPlayer.release();
            }
            f2.d().a().autoPause();
            f2.d().a().release();
        }
        JSONObject jSONObject = w.f((JSONObject)ad2.c(), (String)"v4iap");
        JSONArray jSONArray = w.g((JSONObject)jSONObject, (String)"product_ids");
        if (jSONObject != null && (adColonyInterstitial2 = this.n) != null && adColonyInterstitial2.getListener() != null && jSONArray.length() > 0) {
            this.n.getListener().onIAPEvent(this.n, w.c((JSONArray)jSONArray, (int)0), w.c((JSONObject)jSONObject, (String)"engagement_type"));
        }
        d2.a(this.c);
        if (this.n != null) {
            d2.c().remove((Object)this.n.f());
        }
        if ((adColonyInterstitial = this.n) != null && adColonyInterstitial.getListener() != null) {
            this.n.getListener().onClosed(this.n);
            this.n.a(null);
            this.n.setListener(null);
            this.n = null;
        }
        if ((k2 = this.o) != null) {
            k2.a();
            this.o = null;
        }
        new y.a().a("finish_ad call finished").a(y.d);
    }

    public void onCreate(Bundle bundle) {
        AdColonyInterstitial adColonyInterstitial = this.n;
        int n2 = adColonyInterstitial == null ? 0 : adColonyInterstitial.e();
        this.d = n2;
        super.onCreate(bundle);
        if (a.b()) {
            AdColonyInterstitial adColonyInterstitial2 = this.n;
            if (adColonyInterstitial2 == null) {
                return;
            }
            if (adColonyInterstitial2.g()) {
                this.n.h().a(this.n.d());
            }
            this.o = new k(new Handler(Looper.getMainLooper()), this.n);
            if (this.n.getListener() != null) {
                this.n.getListener().onOpened(this.n);
            }
        }
    }
}

