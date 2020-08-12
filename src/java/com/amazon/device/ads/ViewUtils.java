/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.view.ViewTreeObserver
 *  android.view.ViewTreeObserver$OnGlobalLayoutListener
 *  java.lang.Object
 */
package com.amazon.device.ads;

import android.annotation.SuppressLint;
import android.view.ViewTreeObserver;
import com.amazon.device.ads.AndroidBuildInfo;
import com.amazon.device.ads.AndroidTargetUtils;

class ViewUtils {
    private final AndroidBuildInfo androidBuildInfo;

    public ViewUtils() {
        this(new AndroidBuildInfo());
    }

    ViewUtils(AndroidBuildInfo androidBuildInfo) {
        this.androidBuildInfo = androidBuildInfo;
    }

    @SuppressLint(value={"NewApi"})
    public boolean removeOnGlobalLayoutListener(ViewTreeObserver viewTreeObserver, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        if (viewTreeObserver.isAlive()) {
            if (AndroidTargetUtils.isAtLeastAndroidAPI(this.androidBuildInfo, 16)) {
                viewTreeObserver.removeOnGlobalLayoutListener(onGlobalLayoutListener);
            } else {
                viewTreeObserver.removeGlobalOnLayoutListener(onGlobalLayoutListener);
            }
            return true;
        }
        return false;
    }
}

