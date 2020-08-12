/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.PackageManager
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 */
package com.amazon.device.ads;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;

class AmazonDeviceLauncher {
    private static final String WINDOWSHOP_PKG = "com.amazon.windowshop";

    AmazonDeviceLauncher() {
    }

    public boolean isInWindowshopApp(Context context) {
        return context.getPackageName().equals((Object)WINDOWSHOP_PKG);
    }

    public boolean isWindowshopPresent(Context context) {
        return context.getPackageManager().getLaunchIntentForPackage(WINDOWSHOP_PKG) != null;
    }

    public void launchWindowshopDetailPage(Context context, String string) {
        Intent intent = context.getPackageManager().getLaunchIntentForPackage(WINDOWSHOP_PKG);
        if (intent != null) {
            intent.putExtra("com.amazon.windowshop.refinement.asin", string);
            context.startActivity(intent);
        }
    }

    public void launchWindowshopSearchPage(Context context, String string) {
        Intent intent = new Intent("android.intent.action.SEARCH");
        intent.setComponent(new ComponentName(WINDOWSHOP_PKG, "com.amazon.windowshop.search.SearchResultsGridActivity"));
        intent.putExtra("query", string);
        try {
            context.startActivity(intent);
        }
        catch (RuntimeException runtimeException) {}
    }
}

