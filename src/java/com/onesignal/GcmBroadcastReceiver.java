/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.app.job.JobInfo
 *  android.app.job.JobInfo$Builder
 *  android.app.job.JobScheduler
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.PersistableBundle
 *  androidx.legacy.content.WakefulBroadcastReceiver
 *  java.lang.IllegalStateException
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  java.security.SecureRandom
 */
package com.onesignal;

import android.annotation.TargetApi;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import androidx.legacy.content.WakefulBroadcastReceiver;
import com.onesignal.BundleCompat;
import com.onesignal.BundleCompatBundle;
import com.onesignal.BundleCompatFactory;
import com.onesignal.GcmIntentJobService;
import com.onesignal.GcmIntentService;
import com.onesignal.NotificationBundleProcessor;
import com.onesignal.OneSignal;
import java.security.SecureRandom;

public class GcmBroadcastReceiver
extends WakefulBroadcastReceiver {
    private static boolean isGcmMessage(Intent intent) {
        boolean bl2;
        block2 : {
            block3 : {
                boolean bl3 = "com.google.android.c2dm.intent.RECEIVE".equals((Object)intent.getAction());
                bl2 = false;
                if (!bl3) break block2;
                String string = intent.getStringExtra("message_type");
                if (string == null) break block3;
                boolean bl4 = "gcm".equals((Object)string);
                bl2 = false;
                if (!bl4) break block2;
            }
            bl2 = true;
        }
        return bl2;
    }

    private static NotificationBundleProcessor.ProcessedBundleResult processOrderBroadcast(Context context, Intent intent, Bundle bundle) {
        if (!GcmBroadcastReceiver.isGcmMessage(intent)) {
            return null;
        }
        NotificationBundleProcessor.ProcessedBundleResult processedBundleResult = NotificationBundleProcessor.processBundleFromReceiver(context, bundle);
        if (processedBundleResult.processed()) {
            return processedBundleResult;
        }
        GcmBroadcastReceiver.startGCMService(context, bundle);
        return processedBundleResult;
    }

    private void setAbort() {
        if (this.isOrderedBroadcast()) {
            this.abortBroadcast();
            this.setResultCode(-1);
        }
    }

    private static BundleCompat setCompatBundleForServer(Bundle bundle, BundleCompat bundleCompat) {
        bundleCompat.putString("json_payload", NotificationBundleProcessor.bundleAsJSONObject(bundle).toString());
        bundleCompat.putLong("timestamp", System.currentTimeMillis() / 1000L);
        return bundleCompat;
    }

    private void setSuccessfulResultCode() {
        if (this.isOrderedBroadcast()) {
            this.setResultCode(-1);
        }
    }

    private static void startGCMService(Context context, Bundle bundle) {
        if (!NotificationBundleProcessor.hasRemoteResource(bundle)) {
            NotificationBundleProcessor.ProcessFromGCMIntentService(context, GcmBroadcastReceiver.setCompatBundleForServer(bundle, BundleCompatFactory.getInstance()), null);
            return;
        }
        boolean bl2 = Integer.parseInt((String)bundle.getString("pri", "0")) > 9;
        if (!bl2 && Build.VERSION.SDK_INT >= 26) {
            GcmBroadcastReceiver.startGCMServiceWithJobScheduler(context, bundle);
            return;
        }
        try {
            GcmBroadcastReceiver.startGCMServiceWithWakefulService(context, bundle);
            return;
        }
        catch (IllegalStateException illegalStateException) {
            if (Build.VERSION.SDK_INT >= 21) {
                GcmBroadcastReceiver.startGCMServiceWithJobScheduler(context, bundle);
                return;
            }
            throw illegalStateException;
        }
    }

    @TargetApi(value=21)
    private static void startGCMServiceWithJobScheduler(Context context, Bundle bundle) {
        BundleCompat bundleCompat = GcmBroadcastReceiver.setCompatBundleForServer(bundle, BundleCompatFactory.getInstance());
        ComponentName componentName = new ComponentName(context.getPackageName(), GcmIntentJobService.class.getName());
        JobInfo jobInfo = new JobInfo.Builder(new SecureRandom().nextInt(), componentName).setOverrideDeadline(0L).setExtras((PersistableBundle)bundleCompat.getBundle()).build();
        ((JobScheduler)context.getSystemService("jobscheduler")).schedule(jobInfo);
    }

    private static void startGCMServiceWithWakefulService(Context context, Bundle bundle) {
        ComponentName componentName = new ComponentName(context.getPackageName(), GcmIntentService.class.getName());
        BundleCompat bundleCompat = GcmBroadcastReceiver.setCompatBundleForServer(bundle, new BundleCompatBundle());
        GcmBroadcastReceiver.startWakefulService((Context)context, (Intent)new Intent().replaceExtras((Bundle)bundleCompat.getBundle()).setComponent(componentName));
    }

    public void onReceive(Context context, Intent intent) {
        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            if ("google.com/iid".equals((Object)bundle.getString("from"))) {
                return;
            }
            OneSignal.setAppContext(context);
            NotificationBundleProcessor.ProcessedBundleResult processedBundleResult = GcmBroadcastReceiver.processOrderBroadcast(context, intent, bundle);
            if (processedBundleResult == null) {
                this.setSuccessfulResultCode();
                return;
            }
            if (!processedBundleResult.isDup && !processedBundleResult.hasExtenderService) {
                if (processedBundleResult.isOneSignalPayload && OneSignal.getFilterOtherGCMReceivers(context)) {
                    this.setAbort();
                    return;
                }
                this.setSuccessfulResultCode();
                return;
            }
            this.setAbort();
        }
    }
}

