/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  java.lang.Object
 */
package com.applovin.sdk;

import android.app.Activity;

public interface AppLovinUserService {
    public void showConsentDialog(Activity var1, OnConsentDialogDismissListener var2);

    public static interface OnConsentDialogDismissListener {
        public void onDismiss();
    }

}

