/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  java.lang.Object
 */
package com.applovin.impl.sdk;

import android.app.Activity;
import com.applovin.impl.sdk.i;
import com.applovin.impl.sdk.j;
import com.applovin.sdk.AppLovinUserService;

public class UserServiceImpl
implements AppLovinUserService {
    private final j a;

    UserServiceImpl(j j2) {
        this.a = j2;
    }

    @Override
    public void showConsentDialog(Activity activity, AppLovinUserService.OnConsentDialogDismissListener onConsentDialogDismissListener) {
        this.a.I().a(activity, onConsentDialogDismissListener);
    }
}

