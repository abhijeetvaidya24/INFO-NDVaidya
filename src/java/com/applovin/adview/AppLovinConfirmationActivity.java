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
 *  android.content.Intent
 *  android.os.Bundle
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 */
package com.applovin.adview;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

public class AppLovinConfirmationActivity
extends Activity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        AlertDialog.Builder builder = new AlertDialog.Builder((Context)this);
        Intent intent = this.getIntent();
        builder.setTitle((CharSequence)intent.getStringExtra("dialog_title"));
        builder.setMessage((CharSequence)intent.getStringExtra("dialog_body"));
        builder.setCancelable(false);
        builder.setPositiveButton((CharSequence)intent.getStringExtra("dialog_button_text"), new DialogInterface.OnClickListener(){

            public void onClick(DialogInterface dialogInterface, int n) {
                dialogInterface.dismiss();
                AppLovinConfirmationActivity.this.finish();
            }
        });
        builder.show();
    }

}

