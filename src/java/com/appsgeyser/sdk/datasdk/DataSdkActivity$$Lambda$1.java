/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.view.View
 *  android.view.View$OnClickListener
 *  com.appsgeyser.sdk.datasdk.DataSdkActivity
 *  java.lang.Object
 */
package com.appsgeyser.sdk.datasdk;

import android.app.Activity;
import android.view.View;
import com.appsgeyser.sdk.configuration.models.ConfigPhp;
import com.appsgeyser.sdk.datasdk.DataSdkActivity;

final class DataSdkActivity$$Lambda$1
implements View.OnClickListener {
    private final DataSdkActivity arg$1;
    private final ConfigPhp arg$2;
    private final Activity arg$3;

    private DataSdkActivity$$Lambda$1(DataSdkActivity dataSdkActivity, ConfigPhp configPhp, Activity activity) {
        this.arg$1 = dataSdkActivity;
        this.arg$2 = configPhp;
        this.arg$3 = activity;
    }

    public static View.OnClickListener lambdaFactory$(DataSdkActivity dataSdkActivity, ConfigPhp configPhp, Activity activity) {
        return new DataSdkActivity$$Lambda$1(dataSdkActivity, configPhp, activity);
    }

    public void onClick(View view) {
        DataSdkActivity.lambda$showEulaDialog$0((DataSdkActivity)this.arg$1, (ConfigPhp)this.arg$2, (Activity)this.arg$3, (View)view);
    }
}

