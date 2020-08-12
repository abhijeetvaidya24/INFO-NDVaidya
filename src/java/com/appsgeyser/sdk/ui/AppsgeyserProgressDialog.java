/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Dialog
 *  android.content.Context
 */
package com.appsgeyser.sdk.ui;

import android.app.Dialog;
import android.content.Context;
import com.appsgeyser.sdk.R;

public class AppsgeyserProgressDialog
extends Dialog {
    public AppsgeyserProgressDialog(Context context) {
        super(context);
        this.setCancelable(false);
        this.setContentView(R.layout.appsgeysersdk_progress_dialog);
    }
}

