/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.res.Configuration
 *  android.os.Bundle
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewParent
 *  com.adcolony.sdk.a
 *  com.adcolony.sdk.ad
 *  com.adcolony.sdk.ax
 *  com.adcolony.sdk.b
 *  com.adcolony.sdk.c
 *  com.adcolony.sdk.d
 *  com.adcolony.sdk.e
 *  com.adcolony.sdk.w
 *  java.lang.Deprecated
 *  java.lang.String
 *  java.lang.System
 *  org.json.JSONArray
 *  org.json.JSONObject
 */
package com.adcolony.sdk;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.adcolony.sdk.AdColonyNativeAdView;
import com.adcolony.sdk.AdColonyNativeAdViewListener;
import com.adcolony.sdk.a;
import com.adcolony.sdk.ad;
import com.adcolony.sdk.ax;
import com.adcolony.sdk.ay;
import com.adcolony.sdk.b;
import com.adcolony.sdk.c;
import com.adcolony.sdk.d;
import com.adcolony.sdk.e;
import com.adcolony.sdk.w;
import org.json.JSONArray;
import org.json.JSONObject;

@Deprecated
public class AdColonyAdViewActivity
extends b {
    ax n;
    boolean o;

    public AdColonyAdViewActivity() {
        ax ax2 = !a.b() ? null : a.a().t();
        this.n = ax2;
        this.o = this.n instanceof AdColonyNativeAdView;
    }

    void a(ad ad2) {
        super.a(ad2);
        if (this.n.getExpandedContainer() == null) {
            return;
        }
        JSONObject jSONObject = w.f((JSONObject)ad2.c(), (String)"v4iap");
        JSONArray jSONArray = w.g((JSONObject)jSONObject, (String)"product_ids");
        e e2 = this.n.getListener();
        if (e2 != null) {
            if (this.o) {
                AdColonyNativeAdViewListener adColonyNativeAdViewListener = (AdColonyNativeAdViewListener)e2;
                adColonyNativeAdViewListener.onClosed((AdColonyNativeAdView)this.n);
                if (jSONObject != null && jSONArray.length() > 0) {
                    adColonyNativeAdViewListener.onIAPEvent((AdColonyNativeAdView)this.n, w.c((JSONArray)jSONArray, (int)0), w.c((JSONObject)jSONObject, (String)"engagement_type"));
                }
            } else {
                ay ay2 = (ay)e2;
                ay2.c(this.n);
                if (jSONObject != null && jSONArray.length() > 0) {
                    ay2.a(this.n, w.c((JSONArray)jSONArray, (int)0), w.c((JSONObject)jSONObject, (String)"engagement_type"));
                }
            }
        }
        ((ViewGroup)this.n.getExpandedContainer().getParent()).removeView((View)this.n.getExpandedContainer());
        a.a().l().a(this.n.getExpandedContainer());
        this.n.setExpandedContainer(null);
        System.gc();
    }

    public void onCreate(Bundle bundle) {
        ax ax2 = this.n;
        int n2 = ax2 == null ? 0 : ax2.b;
        this.d = n2;
        super.onCreate(bundle);
        if (a.b()) {
            if (this.n == null) {
                return;
            }
            a.a().d(true);
            e e2 = this.n.getListener();
            if (e2 != null && e2 instanceof AdColonyNativeAdViewListener) {
                ((AdColonyNativeAdViewListener)e2).onOpened((AdColonyNativeAdView)this.n);
            }
        }
    }
}

