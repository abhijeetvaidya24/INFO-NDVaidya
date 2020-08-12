/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.net.Uri
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 */
package com.ironsource.environment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public class UrlHandler {
    public static void openUrl(Context context, String string) throws Exception {
        if (string != null) {
            context.startActivity(new Intent("android.intent.action.VIEW").setData(Uri.parse((String)string)));
            return;
        }
        throw new Exception("url is null");
    }
}

