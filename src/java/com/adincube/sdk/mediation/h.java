/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.location.Location
 *  com.adincube.sdk.h.g
 *  java.lang.Object
 */
package com.adincube.sdk.mediation;

import android.content.Context;
import android.location.Location;
import com.adincube.sdk.h.g;
import com.adincube.sdk.util.b.e;

public class h {
    public void a(Context context, g g2) {
        Location location = e.a(context);
        if (location == null && g2 != null) {
            location = g2.c;
        }
        if (location != null) {
            this.a(location);
        }
    }

    public void a(Location location) {
    }
}

