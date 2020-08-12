/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.util.AttributeSet
 *  java.lang.Object
 *  java.lang.String
 */
package com.applovin.impl.sdk.e;

import android.util.AttributeSet;
import com.applovin.impl.sdk.e.j;
import com.applovin.sdk.AppLovinAdSize;

public class b {
    public static AppLovinAdSize a(AttributeSet attributeSet) {
        if (attributeSet == null) {
            return null;
        }
        String string2 = attributeSet.getAttributeValue("http://schemas.applovin.com/android/1.0", "size");
        boolean bl = j.b(string2);
        AppLovinAdSize appLovinAdSize = null;
        if (bl) {
            appLovinAdSize = AppLovinAdSize.fromString(string2);
        }
        return appLovinAdSize;
    }

    public static boolean b(AttributeSet attributeSet) {
        boolean bl = false;
        if (attributeSet != null) {
            boolean bl2 = attributeSet.getAttributeBooleanValue("http://schemas.applovin.com/android/1.0", "loadAdOnCreate", false);
            bl = false;
            if (bl2) {
                bl = true;
            }
        }
        return bl;
    }
}

