/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.os.Handler
 *  android.os.Looper
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 */
package com.tappx.a.a.a.h;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.tappx.a.a.a.h.g;
import com.tappx.sdk.android.TappxPrivacyManager;

final class k
implements TappxPrivacyManager {
    private final Handler a = new Handler(Looper.getMainLooper());
    private final g b;

    k(g g2) {
        this.b = g2;
    }

    @Override
    public void checkAndShowPrivacyDisclaimer(Activity activity) {
        this.checkAndShowPrivacyDisclaimer(activity, null);
    }

    @Override
    public void checkAndShowPrivacyDisclaimer(Activity activity, Runnable runnable) {
        this.b.a((Context)activity, runnable);
    }

    @Override
    public void denyPersonalInfoConsent() {
        this.b.b();
    }

    @Override
    public void grantPersonalInfoConsent() {
        this.b.a();
    }

    @Override
    public void renewPrivacyConsent(Activity activity) {
        this.b.a((Context)activity);
    }

    @Override
    public void setAutoPrivacyDisclaimerEnabled(boolean bl) {
        this.b.a(bl);
    }

    @Override
    public void setGDPRConsent(String string) {
        this.b.a(string);
    }
}

