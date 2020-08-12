/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.AlertDialog
 *  android.app.AlertDialog$Builder
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  android.os.Process
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.appsgeyser.sdk.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Process;
import com.appsgeyser.sdk.R;
import com.appsgeyser.sdk.configuration.Configuration;
import com.appsgeyser.sdk.configuration.PreferencesCoder;

public class AdvertisingTermsDialog {
    private static final String PREFERENCES_PREFIX;
    private static volatile boolean onScreen;
    private final AlertDialog dialog;

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(AdvertisingTermsDialog.class.getSimpleName());
        stringBuilder.append("AlreadyShown");
        PREFERENCES_PREFIX = stringBuilder.toString();
        onScreen = false;
    }

    public AdvertisingTermsDialog(Activity activity) {
        AlertDialog.Builder builder = new AlertDialog.Builder((Context)activity);
        builder.setTitle(R.string.appsgeysersdk_advertising_terms).setMessage(R.string.appsgeysersdk_advertising_terms_message).setCancelable(false).setPositiveButton(R.string.appsgeysersdk_accept, new DialogInterface.OnClickListener(){

            public void onClick(DialogInterface dialogInterface, int n2) {
                onScreen = false;
                AdvertisingTermsDialog.this.setAlreadyShown();
                dialogInterface.dismiss();
            }
        }).setNegativeButton(R.string.appsgeysersdk_refuse, new DialogInterface.OnClickListener(){

            public void onClick(DialogInterface dialogInterface, int n2) {
                onScreen = false;
                Process.killProcess((int)Process.myPid());
            }
        });
        this.dialog = builder.create();
    }

    private boolean isAlreadyShown() {
        return Configuration.getInstance(this.dialog.getContext()).getSettingsCoder().getPrefBoolean(PREFERENCES_PREFIX, false);
    }

    private void setAlreadyShown() {
        Configuration.getInstance(this.dialog.getContext()).getSettingsCoder().savePrefBoolean(PREFERENCES_PREFIX, true);
    }

    public void show(boolean bl) {
        if (bl && !this.isAlreadyShown()) {
            onScreen = true;
            this.dialog.show();
        }
    }

}

