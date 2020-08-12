/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.lang.Object
 *  java.lang.String
 */
package com.tappx.sdk.android;

import android.content.Context;
import com.tappx.a.a.a.a.b;
import com.tappx.a.a.a.h.h;
import com.tappx.sdk.android.TappxPrivacyManager;

public abstract class Tappx {
    public static TappxPrivacyManager getPrivacyManager(Context context) {
        return h.a(context).b();
    }

    public static String getVersion() {
        return "3.1.2";
    }

    protected static void sbmp(boolean bl) {
        b.a = bl;
        b.b = bl;
    }
}

