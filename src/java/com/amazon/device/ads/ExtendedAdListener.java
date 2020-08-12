/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  java.lang.Object
 */
package com.amazon.device.ads;

import android.graphics.Rect;
import com.amazon.device.ads.Ad;
import com.amazon.device.ads.AdListener;

public interface ExtendedAdListener
extends AdListener {
    public void onAdExpired(Ad var1);

    public void onAdResized(Ad var1, Rect var2);
}

