/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  java.lang.String
 */
package com.ironsource.sdk.controller;

import android.os.Bundle;
import com.ironsource.sdk.controller.ControllerActivity;
import com.ironsource.sdk.utils.Logger;

public class InterstitialActivity
extends ControllerActivity {
    private static final String TAG = ControllerActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Logger.i(TAG, "onCreate");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Logger.i(TAG, "onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Logger.i(TAG, "onResume");
    }
}

