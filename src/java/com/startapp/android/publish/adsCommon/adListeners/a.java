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
import com.startapp.android.publish.adsCommon.adListeners.AdDisplayListener;
import com.startapp.android.publish.adsCommon.adListeners.a;

public class a
implements AdDisplayListener {
    AdDisplayListener a;

    public a(AdDisplayListener adDisplayListener) {
        this.a = adDisplayListener;
    }

    @Override
    public void adClicked(Ad ad) {
        if (this.a != null) {
            new Handler(Looper.getMainLooper()).post(new Runnable(this, ad){
                final /* synthetic */ Ad a;
                final /* synthetic */ a b;
                {
                    this.b = a2;
                    this.a = ad;
                }

                public void run() {
                    this.b.a.adClicked(this.a);
                }
            });
        }
    }

    @Override
    public void adDisplayed(Ad ad) {
        if (this.a != null) {
            new Handler(Looper.getMainLooper()).post(new Runnable(this, ad){
                final /* synthetic */ Ad a;
                final /* synthetic */ a b;
                {
                    this.b = a2;
                    this.a = ad;
                }

                public void run() {
                    this.b.a.adDisplayed(this.a);
                }
            });
        }
    }

    @Override
    public void adHidden(Ad ad) {
        if (this.a != null) {
            new Handler(Looper.getMainLooper()).post(new Runnable(this, ad){
                final /* synthetic */ Ad a;
                final /* synthetic */ a b;
                {
                    this.b = a2;
                    this.a = ad;
                }

                public void run() {
                    this.b.a.adHidden(this.a);
                }
            });
        }
    }

    @Override
    public void adNotDisplayed(Ad ad) {
        if (this.a != null) {
            new Handler(Looper.getMainLooper()).post(new Runnable(this, ad){
                final /* synthetic */ Ad a;
                final /* synthetic */ a b;
                {
                    this.b = a2;
                    this.a = ad;
                }

                public void run() {
                    this.b.a.adNotDisplayed(this.a);
                }
            });
        }
    }
}

