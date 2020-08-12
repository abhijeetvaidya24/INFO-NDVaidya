/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  com.startapp.android.publish.common.model.GetAdRequest
 *  java.io.Serializable
 *  java.lang.Boolean
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.HashSet
 *  java.util.List
 *  java.util.Set
 */
package com.startapp.android.publish.a;

import android.content.Context;
import android.content.Intent;
import com.startapp.android.publish.adsCommon.Ad;
import com.startapp.android.publish.adsCommon.AdsConstants;
import com.startapp.android.publish.adsCommon.BaseRequest;
import com.startapp.android.publish.adsCommon.adListeners.AdEventListener;
import com.startapp.android.publish.adsCommon.adinformation.c;
import com.startapp.android.publish.adsCommon.d;
import com.startapp.android.publish.adsCommon.h;
import com.startapp.android.publish.common.model.AdDetails;
import com.startapp.android.publish.common.model.AdPreferences;
import com.startapp.android.publish.common.model.GetAdRequest;
import com.startapp.android.publish.common.model.GetAdResponse;
import com.startapp.common.a.g;
import com.startapp.common.b;
import com.startapp.common.e;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class a
extends d {
    private int g = 0;
    private Set<String> h = new HashSet();

    public a(Context context, Ad ad, AdPreferences adPreferences, AdEventListener adEventListener, AdPreferences.Placement placement) {
        super(context, ad, adPreferences, adEventListener, placement);
    }

    private boolean b() {
        this.g = 1 + this.g;
        return this.d();
    }

    protected abstract void a(Ad var1);

    @Override
    protected void a(Boolean bl) {
        super.a(bl);
        Intent intent = new Intent("com.startapp.android.OnReceiveResponseBroadcastListener");
        intent.putExtra("adHashcode", this.b.hashCode());
        intent.putExtra("adResult", (Serializable)bl);
        b.a(this.a).a(intent);
        if (!bl.booleanValue()) {
            return;
        }
        this.a((h)this.b);
        this.d.onReceiveAd(this.b);
    }

    @Override
    protected boolean a(Object object) {
        GetAdResponse getAdResponse = (GetAdResponse)object;
        if (object == null) {
            this.f = "Empty Response";
            g.a("AppPresence", 6, "Error Empty Response");
            return false;
        }
        if (!getAdResponse.isValidResponse()) {
            this.f = getAdResponse.getErrorMessage();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Error msg = [");
            stringBuilder.append(this.f);
            stringBuilder.append("]");
            g.a("AppPresence", 6, stringBuilder.toString());
            return false;
        }
        h h2 = (h)this.b;
        List<AdDetails> list = com.startapp.android.publish.adsCommon.b.c.a(this.a, getAdResponse.getAdsDetails(), this.g, this.h);
        h2.a(list);
        h2.setAdInfoOverride(getAdResponse.getAdInfoOverride());
        List<AdDetails> list2 = getAdResponse.getAdsDetails();
        boolean bl = false;
        if (list2 != null) {
            int n2 = getAdResponse.getAdsDetails().size();
            bl = false;
            if (n2 > 0) {
                bl = true;
            }
        }
        if (!bl) {
            this.f = "Empty Response";
            return bl;
        }
        if (list.size() == 0 && this.g == 0) {
            g.a("AppPresence", 3, "Packages exists - another request");
            return this.b();
        }
        return bl;
    }

    @Override
    protected Object e() {
        GetAdRequest getAdRequest = this.a();
        if (getAdRequest == null) {
            return null;
        }
        if (this.h.size() == 0) {
            this.h.add((Object)this.a.getPackageName());
        }
        if (this.g > 0) {
            getAdRequest.setEngInclude(false);
        }
        getAdRequest.setPackageExclude(this.h);
        int n2 = this.g;
        boolean bl = false;
        if (n2 == 0) {
            bl = true;
        }
        getAdRequest.setEngInclude(bl);
        try {
            GetAdResponse getAdResponse = com.startapp.android.publish.adsCommon.k.a.a(this.a, AdsConstants.a(AdsConstants.AdApiType.JSON, this.f()), (BaseRequest)getAdRequest, null, GetAdResponse.class);
            return getAdResponse;
        }
        catch (e e2) {
            g.a("AppPresence", 6, "Unable to handle GetAdsSetService command!!!!", (Throwable)e2);
            this.f = e2.getMessage();
            return null;
        }
    }
}

