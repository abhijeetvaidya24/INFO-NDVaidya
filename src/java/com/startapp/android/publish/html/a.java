/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.text.TextUtils
 *  com.startapp.android.publish.common.model.GetAdRequest
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.HashSet
 *  java.util.List
 *  java.util.Set
 */
package com.startapp.android.publish.html;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.startapp.android.publish.adsCommon.Ad;
import com.startapp.android.publish.adsCommon.AdsConstants;
import com.startapp.android.publish.adsCommon.BaseRequest;
import com.startapp.android.publish.adsCommon.Utils.i;
import com.startapp.android.publish.adsCommon.adListeners.AdEventListener;
import com.startapp.android.publish.adsCommon.b.c;
import com.startapp.android.publish.adsCommon.d;
import com.startapp.android.publish.adsCommon.f.f;
import com.startapp.android.publish.adsCommon.l;
import com.startapp.android.publish.common.metaData.MetaData;
import com.startapp.android.publish.common.metaData.h;
import com.startapp.android.publish.common.model.AdPreferences;
import com.startapp.android.publish.common.model.GetAdRequest;
import com.startapp.common.a.g;
import com.startapp.common.a.h;
import com.startapp.common.b;
import com.startapp.common.e;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class a
extends d {
    protected Set<String> g = new HashSet();
    protected GetAdRequest h;
    private Set<String> i = new HashSet();
    private List<com.startapp.android.publish.adsCommon.b.a> j = new ArrayList();
    private int k = 0;
    private boolean l;

    public a(Context context, Ad ad, AdPreferences adPreferences, AdEventListener adEventListener, AdPreferences.Placement placement, boolean bl) {
        super(context, ad, adPreferences, adEventListener, placement);
        this.l = bl;
    }

    @Override
    protected void a(Boolean bl) {
        super.a(bl);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Html onPostExecute, result=[");
        stringBuilder.append((Object)bl);
        stringBuilder.append("]");
        g.a("BaseHtmlService", 4, stringBuilder.toString());
    }

    protected void a(boolean bl) {
        Intent intent = new Intent("com.startapp.android.OnReceiveResponseBroadcastListener");
        intent.putExtra("adHashcode", this.b.hashCode());
        intent.putExtra("adResult", bl);
        b.a(this.a).a(intent);
        if (bl && this.b != null) {
            if (this.l) {
                i.a(this.a, ((com.startapp.android.publish.adsCommon.e)this.b).f(), new i.a(){

                    @Override
                    public void a() {
                        a.this.d.onReceiveAd(a.this.b);
                    }

                    @Override
                    public void a(String string) {
                        a.this.b.setErrorMessage(string);
                        a.this.d.onFailedToReceiveAd(a.this.b);
                    }
                });
                return;
            }
            if (bl) {
                this.d.onReceiveAd(this.b);
                return;
            }
            this.d.onFailedToReceiveAd(this.b);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Html onPostExecute failed error=[");
        stringBuilder.append(this.f);
        stringBuilder.append("]");
        g.a("BaseHtmlService", 6, stringBuilder.toString());
    }

    protected boolean a(GetAdRequest getAdRequest) {
        return getAdRequest != null;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    protected boolean a(Object object) {
        g.a("BaseHtmlService", 4, "Handle Html Response");
        try {
            this.j = new ArrayList();
            String string = ((h.a)object).a();
            if (TextUtils.isEmpty((CharSequence)string)) {
                if (this.f != null) return false;
                if (this.h != null && this.h.isAdTypeVideo()) {
                    this.f = "Video isn't available";
                    return false;
                }
                this.f = "Empty Ad";
                return false;
            }
            List<com.startapp.android.publish.adsCommon.b.a> list = c.a(string, this.k);
            boolean bl = com.startapp.android.publish.adsCommon.b.a().E() ? c.a(this.a, list, this.k, this.i, this.j) : false;
            if (bl) return this.g();
            ((com.startapp.android.publish.adsCommon.e)this.b).a(list);
            return this.a(string);
        }
        catch (Exception exception) {
            return false;
        }
    }

    protected boolean a(String string) {
        com.startapp.android.publish.adsCommon.e e2 = (com.startapp.android.publish.adsCommon.e)this.b;
        if (com.startapp.android.publish.adsCommon.g.d.a.b(string)) {
            string = com.startapp.android.publish.adsCommon.g.d.a.a(string);
        }
        e2.b(string);
        return true;
    }

    @Override
    protected void b(Boolean bl) {
        super.b(bl);
    }

    @Override
    protected Object e() {
        this.h = this.a();
        if (this.a(this.h)) {
            if (this.i.size() == 0) {
                this.i.add((Object)this.a.getPackageName());
            }
            this.h.setPackageExclude(this.i);
            this.h.setCampaignExclude(this.g);
            if (this.k > 0) {
                this.h.setEngInclude(false);
                if (MetaData.getInstance().getSimpleTokenConfig().b(this.a)) {
                    l.b(this.a);
                }
            }
            try {
                h.a a2 = com.startapp.android.publish.adsCommon.k.a.a(this.a, AdsConstants.a(AdsConstants.AdApiType.HTML, this.f()), (BaseRequest)this.h, null);
                return a2;
            }
            catch (e e2) {
                if (!MetaData.getInstance().getInvalidNetworkCodesInfoEvents().contains((Object)e2.a())) {
                    f.a(this.a, com.startapp.android.publish.adsCommon.f.d.b, "BaseHtmlService.sendCommand - network failure", e2.getMessage(), "");
                }
                g.a("BaseHtmlService", 6, "Unable to handle GetHtmlAdService command!!!!", (Throwable)((Object)e2));
                this.f = e2.getMessage();
            }
        }
        return null;
    }

    protected boolean g() {
        g.a("BaseHtmlService", 3, "At least one package is present. sending another request to AdPlatform");
        this.k = 1 + this.k;
        new com.startapp.android.publish.adsCommon.b.b(this.a, this.j).a();
        return this.d();
    }

}

