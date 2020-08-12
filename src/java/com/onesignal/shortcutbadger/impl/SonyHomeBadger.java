/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.AsyncQueryHandler
 *  android.content.ComponentName
 *  android.content.ContentResolver
 *  android.content.ContentValues
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.PackageManager
 *  android.content.pm.ProviderInfo
 *  android.net.Uri
 *  android.os.Looper
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Arrays
 *  java.util.List
 */
package com.onesignal.shortcutbadger.impl;

import android.content.AsyncQueryHandler;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.net.Uri;
import android.os.Looper;
import com.onesignal.shortcutbadger.Badger;
import com.onesignal.shortcutbadger.ShortcutBadgeException;
import com.onesignal.shortcutbadger.impl.SonyHomeBadger;
import java.util.Arrays;
import java.util.List;

public class SonyHomeBadger
implements Badger {
    private final Uri BADGE_CONTENT_URI = Uri.parse((String)"content://com.sonymobile.home.resourceprovider/badge");
    private AsyncQueryHandler mQueryHandler;

    private ContentValues createContentValues(int n2, ComponentName componentName) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("badge_count", Integer.valueOf((int)n2));
        contentValues.put("package_name", componentName.getPackageName());
        contentValues.put("activity_name", componentName.getClassName());
        return contentValues;
    }

    private static void executeBadgeByBroadcast(Context context, ComponentName componentName, int n2) {
        Intent intent = new Intent("com.sonyericsson.home.action.UPDATE_BADGE");
        intent.putExtra("com.sonyericsson.home.intent.extra.badge.PACKAGE_NAME", componentName.getPackageName());
        intent.putExtra("com.sonyericsson.home.intent.extra.badge.ACTIVITY_NAME", componentName.getClassName());
        intent.putExtra("com.sonyericsson.home.intent.extra.badge.MESSAGE", String.valueOf((int)n2));
        boolean bl2 = n2 > 0;
        intent.putExtra("com.sonyericsson.home.intent.extra.badge.SHOW_MESSAGE", bl2);
        context.sendBroadcast(intent);
    }

    private void executeBadgeByContentProvider(Context context, ComponentName componentName, int n2) {
        if (n2 < 0) {
            return;
        }
        ContentValues contentValues = this.createContentValues(n2, componentName);
        if (Looper.myLooper() == Looper.getMainLooper()) {
            if (this.mQueryHandler == null) {
                this.mQueryHandler = new AsyncQueryHandler(this, context.getApplicationContext().getContentResolver()){
                    final /* synthetic */ SonyHomeBadger this$0;
                    {
                        this.this$0 = sonyHomeBadger;
                        super(contentResolver);
                    }
                };
            }
            this.insertBadgeAsync(contentValues);
            return;
        }
        this.insertBadgeSync(context, contentValues);
    }

    private void insertBadgeAsync(ContentValues contentValues) {
        this.mQueryHandler.startInsert(0, null, this.BADGE_CONTENT_URI, contentValues);
    }

    private void insertBadgeSync(Context context, ContentValues contentValues) {
        context.getApplicationContext().getContentResolver().insert(this.BADGE_CONTENT_URI, contentValues);
    }

    private static boolean sonyBadgeContentProviderExists(Context context) {
        ProviderInfo providerInfo = context.getPackageManager().resolveContentProvider("com.sonymobile.home.resourceprovider", 0);
        boolean bl2 = false;
        if (providerInfo != null) {
            bl2 = true;
        }
        return bl2;
    }

    @Override
    public void executeBadge(Context context, ComponentName componentName, int n2) throws ShortcutBadgeException {
        if (SonyHomeBadger.sonyBadgeContentProviderExists(context)) {
            this.executeBadgeByContentProvider(context, componentName, n2);
            return;
        }
        SonyHomeBadger.executeBadgeByBroadcast(context, componentName, n2);
    }

    @Override
    public List<String> getSupportLaunchers() {
        return Arrays.asList((Object[])new String[]{"com.sonyericsson.home", "com.sonymobile.home"});
    }
}

