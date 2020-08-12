/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Application
 *  android.content.Context
 *  android.content.Intent
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.util.HashMap
 *  java.util.concurrent.ConcurrentHashMap
 *  org.json.JSONObject
 */
package com.adcolony.sdk;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import com.adcolony.sdk.AdColonyAdOptions;
import com.adcolony.sdk.AdColonyInterstitialActivity;
import com.adcolony.sdk.AdColonyInterstitialListener;
import com.adcolony.sdk.AdColonyRewardListener;
import com.adcolony.sdk.AdColonyZone;
import com.adcolony.sdk.a;
import com.adcolony.sdk.ad;
import com.adcolony.sdk.c;
import com.adcolony.sdk.d;
import com.adcolony.sdk.g;
import com.adcolony.sdk.l;
import com.adcolony.sdk.w;
import com.adcolony.sdk.y;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

public class AdColonyInterstitial {
    private AdColonyInterstitialListener a;
    private c b;
    private AdColonyAdOptions c;
    private g d;
    private int e;
    private String f;
    private String g;
    private String h;
    private int i;
    private String j;
    private boolean k;
    private boolean l;
    private boolean m;

    AdColonyInterstitial(String string, AdColonyInterstitialListener adColonyInterstitialListener, String string2) {
        this.a = adColonyInterstitialListener;
        this.j = string2;
        this.f = string;
    }

    void a(int n2) {
        this.i = n2;
    }

    void a(AdColonyAdOptions adColonyAdOptions) {
        this.c = adColonyAdOptions;
    }

    void a(c c2) {
        this.b = c2;
    }

    void a(String string) {
        this.g = string;
    }

    void a(JSONObject jSONObject) {
        if (jSONObject.length() > 0) {
            this.d = new g(jSONObject);
        }
    }

    void a(boolean bl) {
        this.k = bl;
    }

    boolean a() {
        Context context = a.c();
        if (context != null && a.b()) {
            a.a().c(true);
            a.a().a(this.b);
            a.a().a(this);
            new y.a().a("Launching fullscreen Activity via AdColonyInterstitial's launch ").a("method.").a(y.b);
            Intent intent = new Intent(context, AdColonyInterstitialActivity.class);
            if (context instanceof Application) {
                intent.addFlags(268435456);
            }
            context.startActivity(intent);
            this.l = true;
            return true;
        }
        return false;
    }

    boolean a(AdColonyZone adColonyZone) {
        if (adColonyZone != null) {
            if (adColonyZone.getPlayFrequency() <= 1) {
                return false;
            }
            if (adColonyZone.b() == 0) {
                adColonyZone.a(adColonyZone.getPlayFrequency() - 1);
                return false;
            }
            adColonyZone.a(adColonyZone.b() - 1);
        }
        return true;
    }

    String b() {
        String string = this.g;
        if (string == null) {
            string = "";
        }
        return string;
    }

    void b(int n2) {
        this.e = n2;
    }

    void b(String string) {
        this.h = string;
    }

    void b(boolean bl) {
        this.m = bl;
    }

    public boolean cancel() {
        Context context;
        if (this.b != null && ((context = a.c()) == null || context instanceof AdColonyInterstitialActivity)) {
            JSONObject jSONObject = w.a();
            w.a(jSONObject, "id", this.b.b());
            new ad("AdSession.on_request_close", this.b.c(), jSONObject).b();
            return true;
        }
        return false;
    }

    c d() {
        return this.b;
    }

    public boolean destroy() {
        a.a().l().c().remove((Object)this.f);
        return true;
    }

    int e() {
        return this.e;
    }

    String f() {
        return this.f;
    }

    boolean g() {
        return this.d != null;
    }

    public AdColonyInterstitialListener getListener() {
        return this.a;
    }

    public String getZoneID() {
        return this.j;
    }

    g h() {
        return this.d;
    }

    boolean i() {
        return this.m;
    }

    public boolean isExpired() {
        return this.k || this.l;
        {
        }
    }

    public void setListener(AdColonyInterstitialListener adColonyInterstitialListener) {
        this.a = adColonyInterstitialListener;
    }

    public boolean show() {
        AdColonyZone adColonyZone;
        if (!a.b()) {
            return false;
        }
        l l2 = a.a();
        if (this.l) {
            new y.a().a("This ad object has already been shown. Please request a new ad ").a("via AdColony.requestInterstitial.").a(y.e);
            return false;
        }
        if (this.k) {
            new y.a().a("This ad object has expired. Please request a new ad via AdColony").a(".requestInterstitial.").a(y.e);
            return false;
        }
        if (l2.w()) {
            new y.a().a("Can not show ad while an interstitial is already active.").a(y.e);
            return false;
        }
        if (this.a((AdColonyZone)l2.f().get((Object)this.j))) {
            new y.a().a("Skipping show()").a(y.d);
            return false;
        }
        JSONObject jSONObject = w.a();
        w.a(jSONObject, "zone_id", this.j);
        w.b(jSONObject, "type", 0);
        w.a(jSONObject, "id", this.f);
        AdColonyAdOptions adColonyAdOptions = this.c;
        if (adColonyAdOptions != null) {
            w.a(jSONObject, "pre_popup", adColonyAdOptions.a);
            w.a(jSONObject, "post_popup", this.c.b);
        }
        if ((adColonyZone = (AdColonyZone)l2.f().get((Object)this.j)) != null && adColonyZone.isRewarded() && l2.i() == null) {
            new y.a().a("Rewarded ad: show() called with no reward listener set.").a(y.e);
        }
        new ad("AdSession.launch_ad_unit", 1, jSONObject).b();
        return true;
    }
}

