/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.Uri
 *  androidx.core.app.NotificationCompat
 *  androidx.core.app.NotificationCompat$Extender
 *  com.onesignal.NotificationExtenderService
 *  java.lang.CharSequence
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.security.SecureRandom
 *  org.json.JSONObject
 */
package com.onesignal;

import android.content.Context;
import android.net.Uri;
import androidx.core.app.NotificationCompat;
import com.onesignal.NotificationExtenderService;
import java.security.SecureRandom;
import org.json.JSONObject;

class NotificationGenerationJob {
    Context context;
    JSONObject jsonPayload;
    Integer orgFlags;
    Uri orgSound;
    CharSequence overriddenBodyFromExtender;
    Integer overriddenFlags;
    Uri overriddenSound;
    CharSequence overriddenTitleFromExtender;
    NotificationExtenderService.OverrideSettings overrideSettings;
    boolean restoring;
    boolean showAsAlert;
    Long shownTimeStamp;

    NotificationGenerationJob(Context context) {
        this.context = context;
    }

    Integer getAndroidId() {
        if (this.overrideSettings == null) {
            this.overrideSettings = new NotificationExtenderService.OverrideSettings();
        }
        if (this.overrideSettings.androidNotificationId == null) {
            this.overrideSettings.androidNotificationId = new SecureRandom().nextInt();
        }
        return this.overrideSettings.androidNotificationId;
    }

    int getAndroidIdWithoutCreate() {
        NotificationExtenderService.OverrideSettings overrideSettings = this.overrideSettings;
        if (overrideSettings != null && overrideSettings.androidNotificationId != null) {
            return this.overrideSettings.androidNotificationId;
        }
        return -1;
    }

    CharSequence getBody() {
        CharSequence charSequence = this.overriddenBodyFromExtender;
        if (charSequence != null) {
            return charSequence;
        }
        return this.jsonPayload.optString("alert", null);
    }

    CharSequence getTitle() {
        CharSequence charSequence = this.overriddenTitleFromExtender;
        if (charSequence != null) {
            return charSequence;
        }
        return this.jsonPayload.optString("title", null);
    }

    boolean hasExtender() {
        NotificationExtenderService.OverrideSettings overrideSettings = this.overrideSettings;
        return overrideSettings != null && overrideSettings.extender != null;
    }

    void setAndroidIdWithOutOverriding(Integer n2) {
        if (n2 == null) {
            return;
        }
        NotificationExtenderService.OverrideSettings overrideSettings = this.overrideSettings;
        if (overrideSettings != null && overrideSettings.androidNotificationId != null) {
            return;
        }
        if (this.overrideSettings == null) {
            this.overrideSettings = new NotificationExtenderService.OverrideSettings();
        }
        this.overrideSettings.androidNotificationId = n2;
    }
}

