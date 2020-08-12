/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.onesignal;

import com.onesignal.OneSignal;
import com.onesignal.UserState;
import com.onesignal.UserStateEmail;
import com.onesignal.UserStateSynchronizer;
import org.json.JSONException;
import org.json.JSONObject;

class UserStateEmailSynchronizer
extends UserStateSynchronizer {
    UserStateEmailSynchronizer() {
    }

    @Override
    protected void addOnSessionOrCreateExtras(JSONObject jSONObject) {
        try {
            jSONObject.put("device_type", 11);
            jSONObject.putOpt("device_player_id", (Object)OneSignal.getUserId());
            return;
        }
        catch (JSONException jSONException) {
            jSONException.printStackTrace();
            return;
        }
    }

    @Override
    protected void fireEventsForUpdateFailure(JSONObject jSONObject) {
        if (jSONObject.has("identifier")) {
            OneSignal.fireEmailUpdateFailure();
        }
    }

    @Override
    protected String getId() {
        return OneSignal.getEmailId();
    }

    @Override
    boolean getSubscribed() {
        return false;
    }

    @Override
    UserStateSynchronizer.GetTagsResult getTags(boolean bl2) {
        return null;
    }

    @Override
    protected UserState newUserState(String string, boolean bl2) {
        return new UserStateEmail(string, bl2);
    }

    @Override
    protected void onSuccessfulSync(JSONObject jSONObject) {
        if (jSONObject.has("identifier")) {
            OneSignal.fireEmailUpdateSuccess();
        }
    }

    void refresh() {
        this.scheduleSyncToServer();
    }

    @Override
    protected void scheduleSyncToServer() {
        boolean bl2 = this.getId() == null && this.getRegistrationId() == null;
        if (!bl2) {
            if (OneSignal.getUserId() == null) {
                return;
            }
            this.getNetworkHandlerThread(0).runNewJobDelayed();
        }
    }

    @Override
    void updateIdDependents(String string) {
        OneSignal.updateEmailIdDependents(string);
    }

    @Override
    void updateState(JSONObject jSONObject) {
    }
}

