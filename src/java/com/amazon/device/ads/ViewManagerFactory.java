/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.ViewGroup
 *  java.lang.Object
 */
package com.amazon.device.ads;

import android.view.ViewGroup;
import com.amazon.device.ads.ViewManager;

class ViewManagerFactory {
    private ViewGroup viewGroup;

    ViewManagerFactory() {
    }

    public ViewManager createViewManager() {
        return new ViewManager(this.viewGroup);
    }

    public ViewManagerFactory withViewGroup(ViewGroup viewGroup) {
        this.viewGroup = viewGroup;
        return this;
    }
}

