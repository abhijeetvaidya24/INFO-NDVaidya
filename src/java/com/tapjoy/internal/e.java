/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Dialog
 *  android.content.Context
 *  android.view.Window
 */
package com.tapjoy.internal;

import android.app.Dialog;
import android.content.Context;
import android.view.Window;

public final class e
extends Dialog {
    private boolean a = false;

    public e(Context context) {
        super(context, 16973835);
        this.requestWindowFeature(1);
        this.getWindow().setBackgroundDrawableResource(17170445);
    }

    public final void cancel() {
        this.a = true;
        super.cancel();
    }

    public final void show() {
        this.a = false;
        super.show();
    }
}

