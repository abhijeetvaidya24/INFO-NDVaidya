/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 *  java.lang.Object
 *  java.lang.Runnable
 */
package com.startapp.android.publish.adsCommon.adListeners;

import android.os.Handler;
import android.os.Looper;
import com.startapp.android.publish.adsCommon.Ad;
import com.startapp.android.publish.adsCommon.adListeners.AdEventListener;
import com.startapp.android.publish.adsCommon.adListeners.b;

public class b
implements AdEventListener {
    AdEventListener a;

    public b(AdEventListener adEventListener) {
        this.a = adEventListener;
    }

    public Handler a() {
        return new Handler(Looper.getMainLooper());
    }

    @Override
    public void onFailedToReceiveAd(Ad ad) {
        if (this.a != null) {
            Handler handler = this.a();
            if (handler != null) {
                handler.post(new Runnable(this, ad){
                    final /* synthetic */ Ad a;
                    final /* synthetic */ b b;
                    {
                        this.b = b2;
                        this.a = ad;
                    }

                    public void run() {
                        this.b.a.onFailedToReceiveAd(this.a);
                    }
                });
                return;
            }
            this.a.onFailedToReceiveAd(ad);
        }
    }

    @Override
    public void onReceiveAd(Ad ad) {
        if (this.a != null) {
            Handler handler = this.a();
            if (handler != null) {
                handler.post(new Runnable(this, ad){
                    final /* synthetic */ Ad a;
                    final /* synthetic */ b b;
                    {
                        this.b = b2;
                        this.a = ad;
                    }

                    public void run() {
                        this.b.a.onReceiveAd(this.a);
                    }
                });
                return;
            }
            this.a.onReceiveAd(ad);
        }
    }
}

