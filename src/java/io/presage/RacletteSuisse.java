/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.webkit.WebView
 *  android.widget.FrameLayout
 */
package io.presage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout;

public final class RacletteSuisse
extends FrameLayout {
    public RacletteSuisse(Context context) {
        super(context);
    }

    public final void addView(View view, ViewGroup.LayoutParams layoutParams) {
        if (view instanceof WebView && this.getChildCount() > 0) {
            super.addView(view, -1 + this.getChildCount(), layoutParams);
            return;
        }
        super.addView(view, layoutParams);
    }
}

