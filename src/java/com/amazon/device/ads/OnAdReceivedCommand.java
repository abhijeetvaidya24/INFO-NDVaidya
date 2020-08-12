/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package com.amazon.device.ads;

import com.amazon.device.ads.ActionCode;
import com.amazon.device.ads.Ad;
import com.amazon.device.ads.AdData;

interface OnAdReceivedCommand {
    public ActionCode onAdReceived(Ad var1, AdData var2);
}

