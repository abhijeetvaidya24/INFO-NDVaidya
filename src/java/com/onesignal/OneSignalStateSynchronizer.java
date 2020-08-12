/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.onesignal.UserStateEmailSynchronizer
 *  com.onesignal.UserStatePushSynchronizer
 *  java.lang.Object
 *  java.lang.String
 *  org.json.JSONObject
 */
package com.onesignal;

import com.onesignal.LocationGMS;
import com.onesignal.OneSignal;
import com.onesignal.UserStateEmailSynchronizer;
import com.onesignal.UserStatePushSynchronizer;
import com.onesignal.UserStateSynchronizer;
import org.json.JSONObject;

class OneSignalStateSynchronizer {
    private static UserStateEmailSynchronizer userStateEmailSynchronizer;
    private static UserStatePushSynchronizer userStatePushSynchronizer;

    static UserStateEmailSynchronizer getEmailStateSynchronizer() {
        if (userStateEmailSynchronizer == null) {
            userStateEmailSynchronizer = new UserStateEmailSynchronizer();
        }
        return userStateEmailSynchronizer;
    }

    static UserStatePushSynchronizer getPushStateSynchronizer() {
        if (userStatePushSynchronizer == null) {
            userStatePushSynchronizer = new UserStatePushSynchronizer();
        }
        return userStatePushSynchronizer;
    }

    static String getRegistrationId() {
        return OneSignalStateSynchronizer.getPushStateSynchronizer().getRegistrationId();
    }

    static boolean getSubscribed() {
        return OneSignalStateSynchronizer.getPushStateSynchronizer().getSubscribed();
    }

    static boolean getSyncAsNewSession() {
        return OneSignalStateSynchronizer.getPushStateSynchronizer().getSyncAsNewSession() || OneSignalStateSynchronizer.getEmailStateSynchronizer().getSyncAsNewSession();
        {
        }
    }

    static UserStateSynchronizer.GetTagsResult getTags(boolean bl2) {
        return OneSignalStateSynchronizer.getPushStateSynchronizer().getTags(bl2);
    }

    static boolean getUserSubscribePreference() {
        return OneSignalStateSynchronizer.getPushStateSynchronizer().getUserSubscribePreference();
    }

    static void initUserState() {
        OneSignalStateSynchronizer.getPushStateSynchronizer().initUserState();
        OneSignalStateSynchronizer.getEmailStateSynchronizer().initUserState();
    }

    static boolean persist() {
        boolean bl2;
        block5 : {
            block4 : {
                boolean bl3 = OneSignalStateSynchronizer.getPushStateSynchronizer().persist();
                boolean bl4 = OneSignalStateSynchronizer.getEmailStateSynchronizer().persist();
                if (bl4) {
                    bl4 = OneSignalStateSynchronizer.getEmailStateSynchronizer().getRegistrationId() != null;
                }
                if (bl3) break block4;
                bl2 = false;
                if (!bl4) break block5;
            }
            bl2 = true;
        }
        return bl2;
    }

    static void readyToUpdate(boolean bl2) {
        OneSignalStateSynchronizer.getPushStateSynchronizer().readyToUpdate(bl2);
        OneSignalStateSynchronizer.getEmailStateSynchronizer().readyToUpdate(bl2);
    }

    static void refreshEmailState() {
        OneSignalStateSynchronizer.getEmailStateSynchronizer().refresh();
    }

    static void resetCurrentState() {
        OneSignalStateSynchronizer.getPushStateSynchronizer().resetCurrentState();
        OneSignalStateSynchronizer.getEmailStateSynchronizer().resetCurrentState();
        OneSignal.saveUserId(null);
        OneSignal.saveEmailId(null);
        OneSignal.setLastSessionTime(-3660L);
    }

    static void setNewSession() {
        OneSignalStateSynchronizer.getPushStateSynchronizer().setNewSession();
        OneSignalStateSynchronizer.getEmailStateSynchronizer().setNewSession();
    }

    static void setNewSessionForEmail() {
        OneSignalStateSynchronizer.getEmailStateSynchronizer().setNewSession();
    }

    static void setPermission(boolean bl2) {
        OneSignalStateSynchronizer.getPushStateSynchronizer().setPermission(bl2);
    }

    static void syncUserState(boolean bl2) {
        OneSignalStateSynchronizer.getPushStateSynchronizer().syncUserState(bl2);
        OneSignalStateSynchronizer.getEmailStateSynchronizer().syncUserState(bl2);
    }

    static void updateDeviceInfo(JSONObject jSONObject) {
        OneSignalStateSynchronizer.getPushStateSynchronizer().updateDeviceInfo(jSONObject);
        OneSignalStateSynchronizer.getEmailStateSynchronizer().updateDeviceInfo(jSONObject);
    }

    static void updateLocation(LocationGMS.LocationPoint locationPoint) {
        OneSignalStateSynchronizer.getPushStateSynchronizer().updateLocation(locationPoint);
        OneSignalStateSynchronizer.getEmailStateSynchronizer().updateLocation(locationPoint);
    }

    static void updatePushState(JSONObject jSONObject) {
        OneSignalStateSynchronizer.getPushStateSynchronizer().updateState(jSONObject);
    }
}

