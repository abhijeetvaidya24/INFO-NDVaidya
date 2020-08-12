/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  com.adincube.sdk.mediation.r.f$1
 *  com.adincube.sdk.mediation.r.f$2
 *  com.adincube.sdk.mediation.r.f$5
 *  com.adincube.sdk.mediation.r.i
 *  com.mopub.common.ExternalViewabilitySessionManager
 *  com.mopub.common.ExternalViewabilitySessionManager$ViewabilityVendor
 *  com.mopub.common.MoPub
 *  com.mopub.common.SdkConfiguration
 *  com.mopub.common.SdkConfiguration$Builder
 *  com.mopub.common.SdkInitializationListener
 *  com.mopub.mobileads.MoPubInterstitial
 *  com.mopub.mobileads.MoPubInterstitial$InterstitialAdListener
 *  com.mopub.mobileads.MoPubView
 *  com.mopub.mobileads.MoPubView$BannerAdListener
 *  java.lang.Object
 *  java.lang.String
 */
package com.adincube.sdk.mediation.r;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import com.adincube.sdk.mediation.r.e;
import com.adincube.sdk.mediation.r.f;
import com.adincube.sdk.mediation.r.i;
import com.adincube.sdk.util.c.a;
import com.adincube.sdk.util.u;
import com.mopub.common.ExternalViewabilitySessionManager;
import com.mopub.common.MoPub;
import com.mopub.common.SdkConfiguration;
import com.mopub.common.SdkInitializationListener;
import com.mopub.mobileads.MoPubInterstitial;
import com.mopub.mobileads.MoPubView;

public final class f {
    u a = new u();
    private i b = null;
    private e c = null;
    private boolean d = false;
    private final SdkInitializationListener e = new 5(this);

    public f(i i2, e e2) {
        this.b = i2;
        this.c = e2;
    }

    private void a(Context context, String string) {
        f f2 = this;
        synchronized (f2) {
            if (!this.d) {
                this.d = true;
                if (this.b.k) {
                    MoPub.disableViewability((ExternalViewabilitySessionManager.ViewabilityVendor)ExternalViewabilitySessionManager.ViewabilityVendor.ALL);
                }
                MoPub.initializeSdk((Context)context, (SdkConfiguration)new SdkConfiguration.Builder(string).build(), (SdkInitializationListener)this.e);
            }
            return;
        }
    }

    public final MoPubInterstitial a(Activity activity, String string, MoPubInterstitial.InterstitialAdListener interstitialAdListener) {
        f f2 = this;
        synchronized (f2) {
            this.a((Context)activity, string);
            MoPubInterstitial moPubInterstitial = new MoPubInterstitial(activity, string);
            moPubInterstitial.setInterstitialAdListener(interstitialAdListener);
            moPubInterstitial.setKeywords("");
            moPubInterstitial.setUserDataKeywords(this.c.a());
            this.a.a(string, moPubInterstitial, new 2(this));
            return moPubInterstitial;
        }
    }

    public final MoPubView a(Context context, String string, ViewGroup.LayoutParams layoutParams, MoPubView.BannerAdListener bannerAdListener) {
        f f2 = this;
        synchronized (f2) {
            this.a(context, string);
            MoPubView moPubView = new MoPubView(context);
            moPubView.setAdUnitId(string);
            moPubView.setAutorefreshEnabled(false);
            moPubView.setBannerAdListener(bannerAdListener);
            moPubView.setLayoutParams(layoutParams);
            moPubView.setKeywords("");
            moPubView.setUserDataKeywords(this.c.a());
            this.a.a(string, moPubView, new 1(this));
            return moPubView;
        }
    }

    public final void a(String string) {
        f f2 = this;
        synchronized (f2) {
            this.a.a(string);
            return;
        }
    }
}

