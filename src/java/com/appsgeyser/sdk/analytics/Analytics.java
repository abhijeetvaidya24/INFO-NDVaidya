/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.appsgeyser.sdk.analytics;

import android.content.Context;
import com.appsgeyser.sdk.Logger;
import com.appsgeyser.sdk.configuration.Configuration;
import com.appsgeyser.sdk.server.implementation.AppsgeyserServerClient;

public final class Analytics {
    private static Analytics instance;
    private Configuration configuration;
    private AppsgeyserServerClient serverClient;
    private boolean usageAlreadySent = false;

    private Analytics(Context context) {
        this.configuration = Configuration.getInstance(context);
        this.serverClient = AppsgeyserServerClient.getInstance();
    }

    public static Analytics getInstance(Context context) {
        Class<Analytics> class_ = Analytics.class;
        synchronized (Analytics.class) {
            if (instance == null) {
                instance = new Analytics(context);
            }
            Analytics analytics = instance;
            // ** MonitorExit[var3_1] (shouldn't be in output)
            return analytics;
        }
    }

    private void sendActivityStartedInfo(Context context) {
        if (!this.configuration.isRegistered()) {
            this.configuration.registerNew();
            this.serverClient.sendAfterInstallInfo(context);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("App install was sent: id ");
            stringBuilder.append(this.configuration.getApplicationId());
            stringBuilder.append(" , guid ");
            stringBuilder.append(this.configuration.getAppGuid());
            Logger.DebugLog(stringBuilder.toString());
        }
        if (!this.usageAlreadySent) {
            this.serverClient.sendUsageInfo(context);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("App usage was sent: id ");
            stringBuilder.append(this.configuration.getApplicationId());
            stringBuilder.append(" , guid ");
            stringBuilder.append(this.configuration.getAppGuid());
            Logger.DebugLog(stringBuilder.toString());
            this.usageAlreadySent = true;
        }
        this.serverClient.sendUpdateInfo(context);
        this.serverClient.sendApplicationMode(context);
    }

    public void activityStarted(Context context) {
        this.sendActivityStartedInfo(context);
    }

    public boolean isUsageAlreadySent() {
        return this.usageAlreadySent;
    }
}

