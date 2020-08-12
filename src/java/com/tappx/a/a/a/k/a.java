/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.View
 *  com.tappx.sdk.android.PrivacyView
 *  java.lang.Object
 */
package com.tappx.a.a.a.k;

import android.content.Context;
import android.view.View;
import com.tappx.sdk.android.PrivacyView;

public class a {
    public static View a(Context context) {
        return a.c(context);
    }

    public static View b(Context context) {
        return a.c(context);
    }

    private static View c(Context context) {
        return new PrivacyView(context);
    }
}

