/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.Process
 *  android.util.Pair
 *  com.startapp.android.publish.adsCommon.adListeners.b
 *  com.startapp.android.publish.common.model.GetAdRequest
 *  java.lang.Boolean
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 */
package com.startapp.android.publish.adsCommon;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.util.Pair;
import com.startapp.android.publish.adsCommon.Ad;
import com.startapp.android.publish.adsCommon.adListeners.AdEventListener;
import com.startapp.android.publish.adsCommon.adListeners.b;
import com.startapp.android.publish.adsCommon.c;
import com.startapp.android.publish.adsCommon.f.f;
import com.startapp.android.publish.adsCommon.l;
import com.startapp.android.publish.common.model.AdPreferences;
import com.startapp.android.publish.common.model.GetAdRequest;
import com.startapp.common.g;

public abstract class d {
    protected final Context a;
    protected final Ad b;
    protected final AdPreferences c;
    protected final AdEventListener d;
    protected AdPreferences.Placement e;
    protected String f = null;

    public d(Context context, Ad ad, AdPreferences adPreferences, AdEventListener adEventListener, AdPreferences.Placement placement) {
        this.a = context;
        this.b = ad;
        this.c = adPreferences;
        this.d = new b(adEventListener);
        this.e = placement;
    }

    protected GetAdRequest a() {
        return this.b(new GetAdRequest());
    }

    protected void a(Boolean bl) {
        this.b(bl);
        if (!bl.booleanValue()) {
            this.b.setErrorMessage(this.f);
            this.d.onFailedToReceiveAd(this.b);
        }
    }

    protected abstract boolean a(Object var1);

    protected GetAdRequest b(GetAdRequest getAdRequest) {
        block4 : {
            Pair<String, String> pair = l.d(this.a);
            try {
                getAdRequest.fillAdPreferences(this.a, this.c, this.e, pair);
                if (com.startapp.android.publish.adsCommon.b.a().D()) break block4;
                com.startapp.common.a.g.a(6, "forceExternal - check - request - metadata false disabletwoclicks");
                if (!c.a(this.a, this.e)) break block4;
                getAdRequest.setDisableTwoClicks(true);
            }
            catch (Exception exception) {
                l.a(pair);
                return null;
            }
        }
        try {
            getAdRequest.fillApplicationDetails(this.a, this.c, false);
            return getAdRequest;
        }
        catch (Exception exception) {
            f.a(this.a, com.startapp.android.publish.adsCommon.f.d.b, "BaseService.GetAdRequest - fillApplicationDetails failed", exception.getMessage(), "");
            return getAdRequest;
        }
    }

    protected void b(Boolean bl) {
        Ad ad = this.b;
        Ad.AdState adState = bl != false ? Ad.AdState.READY : Ad.AdState.UN_INITIALIZED;
        ad.setState(adState);
    }

    public void c() {
        g.a(g.a.b, new Runnable(){

            public void run() {
                Process.setThreadPriority((int)10);
                final Boolean bl = d.this.d();
                new Handler(Looper.getMainLooper()).post(new Runnable(){

                    public void run() {
                        d.this.a(bl);
                    }
                });
            }

        });
    }

    protected Boolean d() {
        return this.a(this.e());
    }

    protected abstract Object e();

    protected AdPreferences.Placement f() {
        return this.e;
    }

}

