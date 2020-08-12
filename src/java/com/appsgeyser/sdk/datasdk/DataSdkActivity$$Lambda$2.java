/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.view.View
 *  android.view.View$OnClickListener
 *  com.appsgeyser.sdk.datasdk.DataSdkActivity
 *  java.lang.Object
 *  java.lang.String
 */
package com.appsgeyser.sdk.datasdk;

import android.app.Activity;
import android.view.View;
import com.appsgeyser.sdk.configuration.models.ConfigPhp;
import com.appsgeyser.sdk.datasdk.DataSdkActivity;

final class DataSdkActivity$$Lambda$2
implements View.OnClickListener {
    private final DataSdkActivity arg$1;
    private final Activity arg$2;
    private final ConfigPhp arg$3;
    private final String arg$4;

    private DataSdkActivity$$Lambda$2(DataSdkActivity dataSdkActivity, Activity activity, ConfigPhp configPhp, String string2) {
        this.arg$1 = dataSdkActivity;
        this.arg$2 = activity;
        this.arg$3 = configPhp;
        this.arg$4 = string2;
    }

    public static View.OnClickListener lambdaFactory$(DataSdkActivity dataSdkActivity, Activity activity, ConfigPhp configPhp, String string2) {
        return new DataSdkActivity$$Lambda$2(dataSdkActivity, activity, configPhp, string2);
    }

    public void onClick(View view) {
        DataSdkActivity.lambda$showEulaDialog$1((DataSdkActivity)this.arg$1, (Activity)this.arg$2, (ConfigPhp)this.arg$3, (String)this.arg$4, (View)view);
    }
}

