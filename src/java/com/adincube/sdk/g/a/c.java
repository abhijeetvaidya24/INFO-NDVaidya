/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.provider.Settings
 *  android.provider.Settings$Secure
 *  com.adincube.sdk.g.a.a
 *  com.adincube.sdk.h.a
 *  java.lang.Object
 *  java.lang.String
 */
package com.adincube.sdk.g.a;

import android.content.ContentResolver;
import android.content.Context;
import android.provider.Settings;
import com.adincube.sdk.g.a.a;

public final class c
implements a {
    public final com.adincube.sdk.h.a a(Context context) {
        ContentResolver contentResolver = context.getContentResolver();
        String string = Settings.Secure.getString((ContentResolver)contentResolver, (String)"advertising_id");
        boolean bl = Settings.Secure.getInt((ContentResolver)contentResolver, (String)"limit_ad_tracking") != 0;
        return new com.adincube.sdk.h.a(string, bl);
    }
}

