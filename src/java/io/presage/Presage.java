/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.lang.Object
 *  java.lang.String
 */
package io.presage;

import android.content.Context;
import io.presage.ads.Ads;
import io.presage.core.Core;

public class Presage {
    private static Presage IIIIIIII;

    private Presage() {
    }

    public static Presage getInstance() {
        if (IIIIIIII == null) {
            IIIIIIII = new Presage();
        }
        return IIIIIIII;
    }

    public void start(String string2, Context context) {
        Ads.initialize(context, string2);
        Core.initialize(context, string2);
    }
}

