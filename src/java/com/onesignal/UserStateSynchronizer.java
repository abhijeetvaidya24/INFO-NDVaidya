/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.HandlerThread
 *  android.os.Looper
 *  com.onesignal.UserStateSynchronizer$3
 *  com.onesignal.UserStateSynchronizer$4
 *  com.onesignal.UserStateSynchronizer$5
 *  java.lang.CharSequence
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.HashMap
 *  java.util.Iterator
 *  java.util.Set
 *  java.util.concurrent.atomic.AtomicBoolean
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.onesignal;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.onesignal.JSONUtils;
import com.onesignal.LocationGMS;
import com.onesignal.OneSignal;
import com.onesignal.OneSignalRestClient;
import com.onesignal.OneSignalStateSynchronizer;
import com.onesignal.UserState;
import com.onesignal.UserStateSynchronizer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

abstract class UserStateSynchronizer {
    private boolean canMakeUpdates;
    protected UserState currentUserState;
    private final Object networkHandlerSyncLock = new Object(){};
    HashMap<Integer, NetworkHandlerThread> networkHandlerThreads = new HashMap();
    private AtomicBoolean runningSyncUserState = new AtomicBoolean();
    private ArrayList<OneSignal.ChangeTagsUpdateHandler> sendTagsHandlers = new ArrayList();
    protected final Object syncLock = new Object(){};
    protected UserState toSyncUserState;
    protected boolean waitingForSessionResponse = false;

    UserStateSynchronizer() {
    }

    static /* synthetic */ boolean access$200(UserStateSynchronizer userStateSynchronizer, int n2, String string2, String string3) {
        return userStateSynchronizer.response400WithErrorsContaining(n2, string2, string3);
    }

    static /* synthetic */ void access$300(UserStateSynchronizer userStateSynchronizer) {
        userStateSynchronizer.logoutEmailSyncSuccess();
    }

    static /* synthetic */ void access$400(UserStateSynchronizer userStateSynchronizer) {
        userStateSynchronizer.handlePlayerDeletedFromServer();
    }

    static /* synthetic */ void access$500(UserStateSynchronizer userStateSynchronizer, int n2) {
        userStateSynchronizer.handleNetworkFailure(n2);
    }

    private void doCreateOrNewSession(String string2, JSONObject jSONObject, JSONObject jSONObject2) {
        String string3;
        if (string2 == null) {
            string3 = "players";
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("players/");
            stringBuilder.append(string2);
            stringBuilder.append("/on_session");
            string3 = stringBuilder.toString();
        }
        this.waitingForSessionResponse = true;
        this.addOnSessionOrCreateExtras(jSONObject);
        OneSignalRestClient.postSync(string3, jSONObject, (OneSignalRestClient.ResponseHandler)new 5(this, jSONObject2, jSONObject, string2));
    }

    private void doEmailLogout(String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("players/");
        stringBuilder.append(string2);
        stringBuilder.append("/email_logout");
        String string3 = stringBuilder.toString();
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2;
            JSONObject jSONObject3 = this.currentUserState.dependValues;
            if (jSONObject3.has("email_auth_hash")) {
                jSONObject.put("email_auth_hash", (Object)jSONObject3.optString("email_auth_hash"));
            }
            if ((jSONObject2 = this.currentUserState.syncValues).has("parent_player_id")) {
                jSONObject.put("parent_player_id", (Object)jSONObject2.optString("parent_player_id"));
            }
            jSONObject.put("app_id", (Object)jSONObject2.optString("app_id"));
        }
        catch (JSONException jSONException) {
            jSONException.printStackTrace();
        }
        OneSignalRestClient.postSync(string3, jSONObject, (OneSignalRestClient.ResponseHandler)new 3(this));
    }

    private void doPutSync(String string2, JSONObject jSONObject, JSONObject jSONObject2) {
        if (string2 == null) {
            for (OneSignal.ChangeTagsUpdateHandler changeTagsUpdateHandler : this.sendTagsHandlers) {
                if (changeTagsUpdateHandler == null) continue;
                changeTagsUpdateHandler.onFailure(new OneSignal.SendTagsError(-1, "Unable to update tags: the current user is not registered with OneSignal"));
            }
            this.sendTagsHandlers.clear();
            return;
        }
        ArrayList arrayList = (ArrayList)this.sendTagsHandlers.clone();
        this.sendTagsHandlers.clear();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("players/");
        stringBuilder.append(string2);
        OneSignalRestClient.putSync(stringBuilder.toString(), jSONObject, (OneSignalRestClient.ResponseHandler)new 4(this, jSONObject, arrayList, jSONObject2));
    }

    private void fireNetworkFailureEvents() {
        JSONObject jSONObject = this.currentUserState.generateJsonDiff(this.toSyncUserState, false);
        if (jSONObject != null) {
            this.fireEventsForUpdateFailure(jSONObject);
        }
        if (this.getToSyncUserState().dependValues.optBoolean("logoutEmail", false)) {
            OneSignal.handleFailedEmailLogout();
        }
    }

    private void handleNetworkFailure(int n2) {
        if (n2 == 403) {
            OneSignal.Log(OneSignal.LOG_LEVEL.FATAL, "403 error updating player, omitting further retries!");
            this.fireNetworkFailureEvents();
            return;
        }
        if (!this.getNetworkHandlerThread(0).doRetry()) {
            this.fireNetworkFailureEvents();
        }
    }

    private void handlePlayerDeletedFromServer() {
        OneSignal.handleSuccessfulEmailLogout();
        this.resetCurrentState();
        this.scheduleSyncToServer();
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    private void internalSyncUserState(boolean bl2) {
        String string2;
        JSONObject jSONObject2;
        JSONObject jSONObject;
        block9 : {
            Object object;
            string2 = this.getId();
            if (this.syncEmailLogout() && string2 != null) {
                this.doEmailLogout(string2);
                return;
            }
            if (this.currentUserState == null) {
                this.initUserState();
            }
            boolean bl3 = !bl2 && this.isSessionCall();
            Object object2 = object = this.syncLock;
            // MONITORENTER : object2
            jSONObject = this.currentUserState.generateJsonDiff(this.getToSyncUserState(), bl3);
            jSONObject2 = this.generateJsonDiff(this.currentUserState.dependValues, this.getToSyncUserState().dependValues, null, null);
            if (jSONObject == null) {
                this.currentUserState.persistStateAfterSync(jSONObject2, null);
                Iterator iterator = this.sendTagsHandlers.iterator();
                do {
                    if (!iterator.hasNext()) {
                        this.sendTagsHandlers.clear();
                        // MONITOREXIT : object2
                        return;
                    }
                    OneSignal.ChangeTagsUpdateHandler changeTagsUpdateHandler = (OneSignal.ChangeTagsUpdateHandler)iterator.next();
                    if (changeTagsUpdateHandler == null) continue;
                    changeTagsUpdateHandler.onSuccess(OneSignalStateSynchronizer.getTags((boolean)false).result);
                } while (true);
            }
            this.getToSyncUserState().persistState();
            // MONITOREXIT : object2
            if (bl3) break block9;
            {
                catch (Throwable throwable) {}
                {
                    // MONITOREXIT : object2
                    throw throwable;
                }
            }
            this.doPutSync(string2, jSONObject, jSONObject2);
            return;
        }
        this.doCreateOrNewSession(string2, jSONObject, jSONObject2);
    }

    private boolean isSessionCall() {
        return (this.getToSyncUserState().dependValues.optBoolean("session") || this.getId() == null) && !this.waitingForSessionResponse;
    }

    private void logoutEmailSyncSuccess() {
        this.getToSyncUserState().dependValues.remove("logoutEmail");
        this.toSyncUserState.dependValues.remove("email_auth_hash");
        this.toSyncUserState.syncValues.remove("parent_player_id");
        this.toSyncUserState.persistState();
        this.currentUserState.dependValues.remove("email_auth_hash");
        this.currentUserState.syncValues.remove("parent_player_id");
        String string2 = this.currentUserState.syncValues.optString("email");
        this.currentUserState.syncValues.remove("email");
        OneSignalStateSynchronizer.setNewSessionForEmail();
        OneSignal.LOG_LEVEL lOG_LEVEL = OneSignal.LOG_LEVEL.INFO;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Device successfully logged out of email: ");
        stringBuilder.append(string2);
        OneSignal.Log(lOG_LEVEL, stringBuilder.toString());
        OneSignal.handleSuccessfulEmailLogout();
    }

    private boolean response400WithErrorsContaining(int n2, String string2, String string3) {
        if (n2 == 400 && string2 != null) {
            boolean bl2;
            block4 : {
                JSONObject jSONObject = new JSONObject(string2);
                boolean bl3 = jSONObject.has("errors");
                bl2 = false;
                if (!bl3) break block4;
                try {
                    boolean bl4 = jSONObject.optString("errors").contains((CharSequence)string3);
                    bl2 = false;
                    if (!bl4) break block4;
                    bl2 = true;
                }
                catch (Throwable throwable) {
                    throwable.printStackTrace();
                }
            }
            return bl2;
        }
        return false;
    }

    private boolean syncEmailLogout() {
        return this.getToSyncUserState().dependValues.optBoolean("logoutEmail", false);
    }

    protected abstract void addOnSessionOrCreateExtras(JSONObject var1);

    protected abstract void fireEventsForUpdateFailure(JSONObject var1);

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    protected JSONObject generateJsonDiff(JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, Set<String> set) {
        Object object;
        Object object2 = object = this.syncLock;
        synchronized (object2) {
            return JSONUtils.generateJsonDiff(jSONObject, jSONObject2, jSONObject3, set);
        }
    }

    protected abstract String getId();

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    protected NetworkHandlerThread getNetworkHandlerThread(Integer n2) {
        Object object;
        Object object2 = object = this.networkHandlerSyncLock;
        synchronized (object2) {
            if (this.networkHandlerThreads.containsKey((Object)n2)) return (NetworkHandlerThread)((Object)this.networkHandlerThreads.get((Object)n2));
            this.networkHandlerThreads.put((Object)n2, (Object)((Object)new NetworkHandlerThread(n2)));
            return (NetworkHandlerThread)((Object)this.networkHandlerThreads.get((Object)n2));
        }
    }

    String getRegistrationId() {
        return this.getToSyncUserState().syncValues.optString("identifier", null);
    }

    abstract boolean getSubscribed();

    boolean getSyncAsNewSession() {
        return this.getUserStateForModification().dependValues.optBoolean("session");
    }

    abstract GetTagsResult getTags(boolean var1);

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    protected UserState getToSyncUserState() {
        Object object;
        Object object2 = object = this.syncLock;
        synchronized (object2) {
            if (this.toSyncUserState == null) {
                this.toSyncUserState = this.newUserState("TOSYNC_STATE", true);
            }
            return this.toSyncUserState;
        }
    }

    protected UserState getUserStateForModification() {
        if (this.toSyncUserState == null) {
            this.toSyncUserState = this.currentUserState.deepClone("TOSYNC_STATE");
        }
        this.scheduleSyncToServer();
        return this.toSyncUserState;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    void initUserState() {
        Object object;
        Object object2 = object = this.syncLock;
        synchronized (object2) {
            if (this.currentUserState == null) {
                this.currentUserState = this.newUserState("CURRENT_STATE", true);
            }
        }
        this.getToSyncUserState();
    }

    protected abstract UserState newUserState(String var1, boolean var2);

    protected abstract void onSuccessfulSync(JSONObject var1);

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    boolean persist() {
        Object object;
        if (this.toSyncUserState == null) {
            return false;
        }
        Object object2 = object = this.syncLock;
        synchronized (object2) {
            JSONObject jSONObject = this.currentUserState.generateJsonDiff(this.toSyncUserState, this.isSessionCall());
            boolean bl2 = false;
            if (jSONObject != null) {
                bl2 = true;
            }
            this.toSyncUserState.persistState();
            return bl2;
        }
    }

    void readyToUpdate(boolean bl2) {
        boolean bl3 = this.canMakeUpdates != bl2;
        this.canMakeUpdates = bl2;
        if (bl3 && bl2) {
            this.scheduleSyncToServer();
        }
    }

    void resetCurrentState() {
        this.currentUserState.syncValues = new JSONObject();
        this.currentUserState.persistState();
    }

    protected abstract void scheduleSyncToServer();

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    void setNewSession() {
        try {
            Object object;
            Object object2 = object = this.syncLock;
            // MONITORENTER : object2
        }
        catch (JSONException jSONException) {
            jSONException.printStackTrace();
            return;
        }
        this.getUserStateForModification().dependValues.put("session", true);
        this.getUserStateForModification().persistState();
        // MONITOREXIT : object2
    }

    void syncUserState(boolean bl2) {
        this.runningSyncUserState.set(true);
        this.internalSyncUserState(bl2);
        this.runningSyncUserState.set(false);
    }

    void updateDeviceInfo(JSONObject jSONObject) {
        JSONObject jSONObject2 = this.getUserStateForModification().syncValues;
        this.generateJsonDiff(jSONObject2, jSONObject, jSONObject2, null);
    }

    abstract void updateIdDependents(String var1);

    void updateLocation(LocationGMS.LocationPoint locationPoint) {
        this.getUserStateForModification().setLocation(locationPoint);
    }

    abstract void updateState(JSONObject var1);

    static class GetTagsResult {
        JSONObject result;
        boolean serverSuccess;

        GetTagsResult(boolean bl2, JSONObject jSONObject) {
            this.serverSuccess = bl2;
            this.result = jSONObject;
        }
    }

    class NetworkHandlerThread
    extends HandlerThread {
        int currentRetry;
        Handler mHandler;
        int mType;

        NetworkHandlerThread(int n2) {
            super("OSH_NetworkHandlerThread");
            this.mHandler = null;
            this.mType = n2;
            this.start();
            this.mHandler = new Handler(this.getLooper());
        }

        private Runnable getNewRunnable() {
            if (this.mType != 0) {
                return null;
            }
            return new Runnable(){

                public void run() {
                    if (!UserStateSynchronizer.this.runningSyncUserState.get()) {
                        UserStateSynchronizer.this.syncUserState(false);
                    }
                }
            };
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        boolean doRetry() {
            Handler handler;
            Handler handler2 = handler = this.mHandler;
            synchronized (handler2) {
                boolean bl2 = this.currentRetry < 3;
                boolean bl3 = this.mHandler.hasMessages(0);
                if (!bl2) return this.mHandler.hasMessages(0);
                if (bl3) return this.mHandler.hasMessages(0);
                this.currentRetry = 1 + this.currentRetry;
                this.mHandler.postDelayed(this.getNewRunnable(), (long)(15000 * this.currentRetry));
                return this.mHandler.hasMessages(0);
            }
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        void runNewJobDelayed() {
            Handler handler;
            if (!UserStateSynchronizer.this.canMakeUpdates) {
                return;
            }
            Handler handler2 = handler = this.mHandler;
            synchronized (handler2) {
                this.currentRetry = 0;
                this.mHandler.removeCallbacksAndMessages(null);
                this.mHandler.postDelayed(this.getNewRunnable(), 5000L);
                return;
            }
        }

    }

}

