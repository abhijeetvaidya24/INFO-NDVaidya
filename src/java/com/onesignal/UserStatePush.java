/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.String
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.onesignal;

import com.onesignal.UserState;
import org.json.JSONException;
import org.json.JSONObject;

class UserStatePush
extends UserState {
    UserStatePush(String string, boolean bl2) {
        super(string, bl2);
    }

    private int getNotificationTypes() {
        int n2 = this.dependValues.optInt("subscribableStatus", 1);
        if (n2 < -2) {
            return n2;
        }
        if (!this.dependValues.optBoolean("androidPermission", true)) {
            return 0;
        }
        if (!this.dependValues.optBoolean("userSubscribePref", true)) {
            return -2;
        }
        return 1;
    }

    @Override
    protected void addDependFields() {
        try {
            this.syncValues.put("notification_types", this.getNotificationTypes());
        }
        catch (JSONException jSONException) {}
    }

    @Override
    boolean isSubscribed() {
        return this.getNotificationTypes() > 0;
    }

    @Override
    UserState newInstance(String string) {
        return new UserStatePush(string, false);
    }
}

