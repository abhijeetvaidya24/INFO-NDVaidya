/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.lang.Cloneable
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  org.json.JSONObject
 */
package com.onesignal;

import android.content.Context;
import com.onesignal.OSObservable;
import com.onesignal.OSUtils;
import com.onesignal.OneSignal;
import com.onesignal.OneSignalPrefs;
import org.json.JSONObject;

public class OSPermissionState
implements Cloneable {
    private boolean enabled;
    OSObservable<Object, OSPermissionState> observable = new OSObservable("changed", false);

    OSPermissionState(boolean bl2) {
        if (bl2) {
            this.enabled = OneSignalPrefs.getBool(OneSignalPrefs.PREFS_ONESIGNAL, "ONESIGNAL_ACCEPTED_NOTIFICATION_LAST", false);
            return;
        }
        this.refreshAsTo();
    }

    private void setEnabled(boolean bl2) {
        boolean bl3 = this.enabled != bl2;
        this.enabled = bl2;
        if (bl3) {
            this.observable.notifyChange(this);
        }
    }

    protected Object clone() {
        try {
            Object object = super.clone();
            return object;
        }
        catch (Throwable throwable) {
            return null;
        }
    }

    public boolean getEnabled() {
        return this.enabled;
    }

    void persistAsFrom() {
        OneSignalPrefs.saveBool(OneSignalPrefs.PREFS_ONESIGNAL, "ONESIGNAL_ACCEPTED_NOTIFICATION_LAST", this.enabled);
    }

    void refreshAsTo() {
        this.setEnabled(OSUtils.areNotificationsEnabled(OneSignal.appContext));
    }

    public JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("enabled", this.enabled);
            return jSONObject;
        }
        catch (Throwable throwable) {
            throwable.printStackTrace();
            return jSONObject;
        }
    }

    public String toString() {
        return this.toJSONObject().toString();
    }
}

