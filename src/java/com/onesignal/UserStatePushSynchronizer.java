/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Set
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.onesignal;

import com.onesignal.JSONUtils;
import com.onesignal.OneSignal;
import com.onesignal.OneSignalRestClient;
import com.onesignal.UserState;
import com.onesignal.UserStatePush;
import com.onesignal.UserStateSynchronizer;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

class UserStatePushSynchronizer
extends UserStateSynchronizer {
    private static boolean serverSuccess;

    UserStatePushSynchronizer() {
    }

    @Override
    protected void addOnSessionOrCreateExtras(JSONObject jSONObject) {
    }

    @Override
    protected void fireEventsForUpdateFailure(JSONObject jSONObject) {
        if (jSONObject.has("email")) {
            OneSignal.fireEmailUpdateFailure();
        }
    }

    @Override
    protected String getId() {
        return OneSignal.getUserId();
    }

    @Override
    boolean getSubscribed() {
        return this.getToSyncUserState().isSubscribed();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    UserStateSynchronizer.GetTagsResult getTags(boolean bl2) {
        Object object;
        if (bl2) {
            String string = OneSignal.getUserId();
            String string2 = OneSignal.getSavedAppId();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("players/");
            stringBuilder.append(string);
            stringBuilder.append("?app_id=");
            stringBuilder.append(string2);
            OneSignalRestClient.getSync(stringBuilder.toString(), new OneSignalRestClient.ResponseHandler(){

                /*
                 * Enabled aggressive block sorting
                 * Enabled unnecessary exception pruning
                 * Enabled aggressive exception aggregation
                 * Converted monitor instructions to comments
                 * Lifted jumps to return sites
                 */
                @Override
                void onSuccess(String string) {
                    JSONObject jSONObject;
                    serverSuccess = true;
                    try {
                        Object object;
                        jSONObject = new JSONObject(string);
                        if (!jSONObject.has("tags")) return;
                        Object object2 = object = UserStatePushSynchronizer.this.syncLock;
                        // MONITORENTER : object2
                    }
                    catch (JSONException jSONException) {
                        jSONException.printStackTrace();
                    }
                    JSONObject jSONObject2 = UserStatePushSynchronizer.this.generateJsonDiff(UserStatePushSynchronizer.this.currentUserState.syncValues.optJSONObject("tags"), UserStatePushSynchronizer.this.getToSyncUserState().syncValues.optJSONObject("tags"), null, null);
                    UserStatePushSynchronizer.this.currentUserState.syncValues.put("tags", (Object)jSONObject.optJSONObject("tags"));
                    UserStatePushSynchronizer.this.currentUserState.persistState();
                    UserStatePushSynchronizer.this.getToSyncUserState().mergeTags(jSONObject, jSONObject2);
                    UserStatePushSynchronizer.this.getToSyncUserState().persistState();
                    // MONITOREXIT : object2
                    return;
                }
            }, "CACHE_KEY_GET_TAGS");
        }
        Object object2 = object = this.syncLock;
        synchronized (object2) {
            return new UserStateSynchronizer.GetTagsResult(serverSuccess, JSONUtils.getJSONObjectWithoutBlankValues(this.toSyncUserState.syncValues, "tags"));
        }
    }

    public boolean getUserSubscribePreference() {
        return this.getToSyncUserState().dependValues.optBoolean("userSubscribePref", true);
    }

    @Override
    protected UserState newUserState(String string, boolean bl2) {
        return new UserStatePush(string, bl2);
    }

    @Override
    protected void onSuccessfulSync(JSONObject jSONObject) {
        if (jSONObject.has("email")) {
            OneSignal.fireEmailUpdateSuccess();
        }
        if (jSONObject.has("identifier")) {
            OneSignal.fireIdsAvailableCallback();
        }
    }

    @Override
    protected void scheduleSyncToServer() {
        this.getNetworkHandlerThread(0).runNewJobDelayed();
    }

    public void setPermission(boolean bl2) {
        try {
            this.getUserStateForModification().dependValues.put("androidPermission", bl2);
            return;
        }
        catch (JSONException jSONException) {
            jSONException.printStackTrace();
            return;
        }
    }

    @Override
    void updateIdDependents(String string) {
        OneSignal.updateUserIdDependents(string);
    }

    @Override
    void updateState(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt("identifier", (Object)jSONObject.optString("identifier", null));
            if (jSONObject.has("device_type")) {
                jSONObject2.put("device_type", jSONObject.optInt("device_type"));
            }
            jSONObject2.putOpt("parent_player_id", (Object)jSONObject.optString("parent_player_id", null));
            JSONObject jSONObject3 = this.getUserStateForModification().syncValues;
            this.generateJsonDiff(jSONObject3, jSONObject2, jSONObject3, null);
        }
        catch (JSONException jSONException) {
            jSONException.printStackTrace();
        }
        try {
            JSONObject jSONObject4 = new JSONObject();
            if (jSONObject.has("subscribableStatus")) {
                jSONObject4.put("subscribableStatus", jSONObject.optInt("subscribableStatus"));
            }
            if (jSONObject.has("androidPermission")) {
                jSONObject4.put("androidPermission", jSONObject.optBoolean("androidPermission"));
            }
            JSONObject jSONObject5 = this.getUserStateForModification().dependValues;
            this.generateJsonDiff(jSONObject5, jSONObject4, jSONObject5, null);
            return;
        }
        catch (JSONException jSONException) {
            jSONException.printStackTrace();
            return;
        }
    }

}

