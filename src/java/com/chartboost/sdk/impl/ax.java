/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.View
 */
package com.chartboost.sdk.impl;

import android.content.Context;
import android.view.View;
import com.chartboost.sdk.Model.a;
import com.chartboost.sdk.impl.aw;

public final class ax
extends View {
    private boolean a = false;

    public ax(Context context) {
        super(context);
        this.setFocusable(false);
        this.setBackgroundColor(-1442840576);
    }

    public void a(aw aw2, a a2) {
        if (!this.a) {
            aw2.a(true, (View)this, a2);
            this.a = true;
        }
    }
}

