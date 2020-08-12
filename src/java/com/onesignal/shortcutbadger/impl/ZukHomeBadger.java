/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.content.ComponentName
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.net.Uri
 *  android.os.Bundle
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Collections
 *  java.util.List
 */
package com.onesignal.shortcutbadger.impl;

import android.annotation.TargetApi;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.onesignal.shortcutbadger.Badger;
import com.onesignal.shortcutbadger.ShortcutBadgeException;
import java.util.Collections;
import java.util.List;

public class ZukHomeBadger
implements Badger {
    private final Uri CONTENT_URI = Uri.parse((String)"content://com.android.badge/badge");

    @TargetApi(value=11)
    @Override
    public void executeBadge(Context context, ComponentName componentName, int n2) throws ShortcutBadgeException {
        Bundle bundle = new Bundle();
        bundle.putInt("app_badge_count", n2);
        context.getContentResolver().call(this.CONTENT_URI, "setAppBadgeCount", null, bundle);
    }

    @Override
    public List<String> getSupportLaunchers() {
        return Collections.singletonList((Object)"com.zui.launcher");
    }
}

