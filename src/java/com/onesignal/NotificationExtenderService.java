/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.PackageManager
 *  android.content.pm.ResolveInfo
 *  android.content.pm.ServiceInfo
 *  androidx.core.app.NotificationCompat
 *  androidx.core.app.NotificationCompat$Extender
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 */
package com.onesignal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import androidx.core.app.NotificationCompat;
import com.onesignal.JobIntentService;
import java.util.List;

public abstract class NotificationExtenderService
extends JobIntentService {
    static Intent getIntent(Context context) {
        Intent intent;
        PackageManager packageManager = context.getPackageManager();
        List list = packageManager.queryIntentServices(intent = new Intent().setAction("com.onesignal.NotificationExtender").setPackage(context.getPackageName()), 128);
        if (list.size() < 1) {
            return null;
        }
        intent.setComponent(new ComponentName(context, ((ResolveInfo)list.get((int)0)).serviceInfo.name));
        return intent;
    }

}

