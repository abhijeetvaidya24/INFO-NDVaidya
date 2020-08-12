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
import com.tapjoy.TJPlacement;
import com.tapjoy.TJPlacementListener;
import com.tapjoy.internal.ff;

final class fg
extends ff {
    fg() {
    }

    @Override
    public final Object a(Context context, String string, TJPlacementListener tJPlacementListener) {
        return new TJPlacement(context, string, tJPlacementListener);
    }
}

