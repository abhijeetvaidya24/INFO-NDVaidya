/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.lang.Object
 *  java.lang.String
 */
package com.tapjoy.internal;

import android.content.Context;
import com.tapjoy.TJPlacementListener;
import com.tapjoy.internal.ew;
import com.tapjoy.internal.ff;

@ew
public class TapjoyNative {
    @ew
    public static Object createPlacement(Context context, String string2, TJPlacementListener tJPlacementListener) {
        return ff.a().a(context, string2, tJPlacementListener);
    }
}

