/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.tappx.a.a.a.g.c
 *  java.lang.Object
 *  java.lang.String
 */
package com.tappx.sdk.android;

import android.content.Context;
import com.tappx.a.a.a.g.c;
import com.tappx.sdk.android.AdRequest;
import com.tappx.sdk.android.ITappxInterstitial;
import com.tappx.sdk.android.TappxInterstitialListener;

public final class TappxInterstitial
implements ITappxInterstitial {
    private final Context a;
    private c b;

    public TappxInterstitial(Context context, String string) {
        this.a = context;
        this.b = new c(this, context);
        this.b.a(string);
    }

    @Override
    public void destroy() {
        this.b.b();
    }

    @Override
    public Context getContext() {
        return this.a;
    }

    @Override
    public boolean isReady() {
        return this.b.f();
    }

    @Override
    public void loadAd() {
        this.loadAd(null);
    }

    @Override
    public void loadAd(AdRequest adRequest) {
        this.b.a(adRequest);
    }

    @Override
    public void setAutoShowWhenReady(boolean bl) {
        this.b.a(bl);
    }

    @Override
    public void setListener(TappxInterstitialListener tappxInterstitialListener) {
        this.b.a(tappxInterstitialListener);
    }

    @Override
    public void show() {
        this.b.g();
    }
}

