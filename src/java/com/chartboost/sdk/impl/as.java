/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Dialog
 *  android.content.Context
 *  com.google.android.gms.common.GoogleApiAvailability
 *  java.lang.Object
 */
package com.chartboost.sdk.impl;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import com.google.android.gms.common.GoogleApiAvailability;

public class as {
    public static boolean a(Context context) {
        GoogleApiAvailability googleApiAvailability = GoogleApiAvailability.getInstance();
        int n2 = googleApiAvailability.isGooglePlayServicesAvailable(context);
        if (n2 != 0) {
            if (googleApiAvailability.isUserResolvableError(n2) && context instanceof Activity) {
                googleApiAvailability.getErrorDialog((Activity)context, n2, 9000).show();
                return true;
            }
            return false;
        }
        return true;
    }
}

