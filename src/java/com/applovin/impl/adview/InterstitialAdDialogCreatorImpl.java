/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.ref.WeakReference
 */
package com.applovin.impl.adview;

import android.content.Context;
import com.applovin.adview.AppLovinInterstitialAdDialog;
import com.applovin.adview.InterstitialAdDialogCreator;
import com.applovin.impl.adview.l;
import com.applovin.impl.sdk.p;
import com.applovin.sdk.AppLovinSdk;
import java.lang.ref.WeakReference;

public class InterstitialAdDialogCreatorImpl
implements InterstitialAdDialogCreator {
    private static final Object a = new Object();
    private static WeakReference<l> b = new WeakReference(null);
    private static WeakReference<Context> c = new WeakReference(null);

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public AppLovinInterstitialAdDialog createInterstitialAdDialog(AppLovinSdk appLovinSdk, Context context) {
        Object object;
        if (appLovinSdk == null) {
            appLovinSdk = AppLovinSdk.getInstance(context);
        }
        Object object2 = object = a;
        synchronized (object2) {
            l l2 = (l)b.get();
            if (l2 != null && l2.isShowing() && c.get() == context) {
                appLovinSdk.getLogger().c("InterstitialAdDialogCreator", "An interstitial dialog is already showing, returning it");
            } else {
                l2 = new l(appLovinSdk, context);
                b = new WeakReference((Object)l2);
                c = new WeakReference((Object)context);
            }
            return l2;
        }
    }
}

