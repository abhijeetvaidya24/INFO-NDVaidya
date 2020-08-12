/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.adcolony.sdk.AdColonyZone
 *  com.adcolony.sdk.e
 *  java.lang.Deprecated
 *  java.lang.String
 */
package com.adcolony.sdk;

import com.adcolony.sdk.AdColonyNativeAdView;
import com.adcolony.sdk.AdColonyZone;
import com.adcolony.sdk.e;

@Deprecated
public abstract class AdColonyNativeAdViewListener
extends e {
    public void onAudioStarted(AdColonyNativeAdView adColonyNativeAdView) {
    }

    public void onAudioStopped(AdColonyNativeAdView adColonyNativeAdView) {
    }

    public void onClicked(AdColonyNativeAdView adColonyNativeAdView) {
    }

    public void onClosed(AdColonyNativeAdView adColonyNativeAdView) {
    }

    public void onIAPEvent(AdColonyNativeAdView adColonyNativeAdView, String string, int n2) {
    }

    public void onLeftApplication(AdColonyNativeAdView adColonyNativeAdView) {
    }

    public void onNativeVideoFinished(AdColonyNativeAdView adColonyNativeAdView) {
    }

    public void onNativeVideoStarted(AdColonyNativeAdView adColonyNativeAdView) {
    }

    public void onOpened(AdColonyNativeAdView adColonyNativeAdView) {
    }

    public abstract void onRequestFilled(AdColonyNativeAdView var1);

    public void onRequestNotFilled(AdColonyZone adColonyZone) {
    }
}

