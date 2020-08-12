/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.AlertDialog
 *  android.app.AlertDialog$Builder
 *  android.app.Application
 *  android.app.Application$ActivityLifecycleCallbacks
 *  android.app.NotificationManager
 *  android.content.ContentValues
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.database.Cursor
 *  android.database.sqlite.SQLiteDatabase
 *  android.net.Uri
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.SystemClock
 *  android.util.Log
 *  com.onesignal.AdvertisingIdProviderGPS
 *  com.onesignal.OneSignal$19
 *  com.onesignal.OneSignal$2
 *  com.onesignal.OneSignal$3
 *  com.onesignal.OneSignal$4
 *  com.onesignal.OneSignal$6
 *  com.onesignal.PushRegistratorADM
 *  com.onesignal.PushRegistratorFCM
 *  com.onesignal.PushRegistratorGCM
 *  java.io.PrintWriter
 *  java.io.StringWriter
 *  java.io.Writer
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.ClassNotFoundException
 *  java.lang.Double
 *  java.lang.Enum
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Thread
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.Calendar
 *  java.util.Collection
 *  java.util.Date
 *  java.util.HashSet
 *  java.util.Iterator
 *  java.util.List
 *  java.util.TimeZone
 *  java.util.concurrent.ConcurrentLinkedQueue
 *  java.util.concurrent.ExecutorService
 *  java.util.concurrent.Executors
 *  java.util.concurrent.Future
 *  java.util.concurrent.ThreadFactory
 *  java.util.concurrent.atomic.AtomicLong
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.onesignal;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Application;
import android.app.NotificationManager;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import com.onesignal.ActivityLifecycleHandler;
import com.onesignal.ActivityLifecycleListener;
import com.onesignal.AdvertisingIdProviderGPS;
import com.onesignal.AdvertisingIdentifierProvider;
import com.onesignal.BadgeCountUpdater;
import com.onesignal.DelayedConsentInitializationParameters;
import com.onesignal.LocationGMS;
import com.onesignal.NotificationBundleProcessor;
import com.onesignal.NotificationRestorer;
import com.onesignal.NotificationSummaryManager;
import com.onesignal.OSEmailSubscriptionChangedInternalObserver;
import com.onesignal.OSEmailSubscriptionState;
import com.onesignal.OSNotification;
import com.onesignal.OSNotificationAction;
import com.onesignal.OSNotificationOpenResult;
import com.onesignal.OSNotificationPayload;
import com.onesignal.OSObservable;
import com.onesignal.OSPermissionChangedInternalObserver;
import com.onesignal.OSPermissionState;
import com.onesignal.OSPermissionStateChanges;
import com.onesignal.OSSubscriptionChangedInternalObserver;
import com.onesignal.OSSubscriptionState;
import com.onesignal.OSSubscriptionStateChanges;
import com.onesignal.OSUtils;
import com.onesignal.OneSignal;
import com.onesignal.OneSignalChromeTab;
import com.onesignal.OneSignalDbHelper;
import com.onesignal.OneSignalPrefs;
import com.onesignal.OneSignalRemoteParams;
import com.onesignal.OneSignalRestClient;
import com.onesignal.OneSignalStateSynchronizer;
import com.onesignal.OneSignalSyncServiceUtils;
import com.onesignal.PushRegistrator;
import com.onesignal.PushRegistratorADM;
import com.onesignal.PushRegistratorFCM;
import com.onesignal.PushRegistratorGCM;
import com.onesignal.RootToolsInternalMethods;
import com.onesignal.TrackAmazonPurchase;
import com.onesignal.TrackFirebaseAnalytics;
import com.onesignal.TrackGooglePurchase;
import com.onesignal.UserStateSynchronizer;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class OneSignal {
    static Context appContext;
    static String appId;
    private static OSEmailSubscriptionState currentEmailSubscriptionState;
    private static OSPermissionState currentPermissionState;
    private static OSSubscriptionState currentSubscriptionState;
    static DelayedConsentInitializationParameters delayedInitParams;
    private static int deviceType;
    private static String emailId;
    private static EmailUpdateHandler emailLogoutHandler;
    private static EmailUpdateHandler emailUpdateHandler;
    private static boolean foreground;
    private static boolean getTagsCall;
    private static IAPUpdateJob iapUpdateJob;
    private static IdsAvailableHandler idsAvailableHandler;
    static boolean initDone;
    private static LocationGMS.LocationPoint lastLocationPoint;
    static OSPermissionState lastPermissionState;
    private static String lastRegistrationId;
    static OSSubscriptionState lastSubscriptionState;
    static AtomicLong lastTaskId;
    private static long lastTrackedFocusTime;
    private static boolean locationFired;
    private static LOG_LEVEL logCatLevel;
    private static String mGoogleProjectNumber;
    static Builder mInitBuilder;
    private static PushRegistrator mPushRegistrator;
    private static AdvertisingIdentifierProvider mainAdIdProvider;
    private static OSUtils osUtils;
    private static ArrayList<GetTagsHandler> pendingGetTagsHandlers;
    static ExecutorService pendingTaskExecutor;
    private static OSObservable<Object, OSPermissionStateChanges> permissionStateChangesObserver;
    private static HashSet<String> postedOpenedNotifIds;
    private static boolean promptedLocation;
    private static boolean registerForPushFired;
    static OneSignalRemoteParams.Params remoteParams;
    static boolean requiresUserPrivacyConsent;
    public static String sdkType;
    static boolean shareLocation;
    private static int subscribableStatus;
    private static OSObservable<Object, OSSubscriptionStateChanges> subscriptionStateChangesObserver;
    public static ConcurrentLinkedQueue<Runnable> taskQueueWaitingForInit;
    private static TrackAmazonPurchase trackAmazonPurchase;
    private static TrackFirebaseAnalytics trackFirebaseAnalytics;
    private static TrackGooglePurchase trackGooglePurchase;
    private static long unSentActiveTime;
    private static Collection<JSONArray> unprocessedOpenedNotifis;
    private static String userId;
    private static LOG_LEVEL visualLogLevel;
    private static boolean waitingToPostStateSync;

    static {
        visualLogLevel = LOG_LEVEL.NONE;
        logCatLevel = LOG_LEVEL.WARN;
        userId = null;
        emailId = null;
        taskQueueWaitingForInit = new ConcurrentLinkedQueue();
        lastTaskId = new AtomicLong();
        lastTrackedFocusTime = 1L;
        unSentActiveTime = -1L;
        mainAdIdProvider = new AdvertisingIdProviderGPS();
        sdkType = "native";
        shareLocation = true;
        unprocessedOpenedNotifis = new ArrayList();
        postedOpenedNotifIds = new HashSet();
        pendingGetTagsHandlers = new ArrayList();
        requiresUserPrivacyConsent = false;
    }

    static long GetUnsentActiveTime() {
        if (unSentActiveTime == -1L && appContext != null) {
            unSentActiveTime = OneSignalPrefs.getLong(OneSignalPrefs.PREFS_ONESIGNAL, "GT_UNSENT_ACTIVE_TIME", 0L);
        }
        LOG_LEVEL lOG_LEVEL = LOG_LEVEL.INFO;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("GetUnsentActiveTime: ");
        stringBuilder.append(unSentActiveTime);
        OneSignal.Log(lOG_LEVEL, stringBuilder.toString());
        return unSentActiveTime;
    }

    static void Log(LOG_LEVEL lOG_LEVEL, String string2) {
        OneSignal.Log(lOG_LEVEL, string2, null);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static void Log(final LOG_LEVEL lOG_LEVEL, String string2, Throwable throwable) {
        if (lOG_LEVEL.compareTo((Enum)logCatLevel) < 1) {
            if (lOG_LEVEL == LOG_LEVEL.VERBOSE) {
                Log.v((String)"OneSignal", (String)string2, (Throwable)throwable);
            } else if (lOG_LEVEL == LOG_LEVEL.DEBUG) {
                Log.d((String)"OneSignal", (String)string2, (Throwable)throwable);
            } else if (lOG_LEVEL == LOG_LEVEL.INFO) {
                Log.i((String)"OneSignal", (String)string2, (Throwable)throwable);
            } else if (lOG_LEVEL == LOG_LEVEL.WARN) {
                Log.w((String)"OneSignal", (String)string2, (Throwable)throwable);
            } else if (lOG_LEVEL == LOG_LEVEL.ERROR || lOG_LEVEL == LOG_LEVEL.FATAL) {
                Log.e((String)"OneSignal", (String)string2, (Throwable)throwable);
            }
        }
        if (lOG_LEVEL.compareTo((Enum)visualLogLevel) < 1 && ActivityLifecycleHandler.curActivity != null) {
            try {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(string2);
                stringBuilder.append("\n");
                final String string3 = stringBuilder.toString();
                if (throwable != null) {
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(string3);
                    stringBuilder2.append(throwable.getMessage());
                    String string4 = stringBuilder2.toString();
                    StringWriter stringWriter = new StringWriter();
                    throwable.printStackTrace(new PrintWriter((Writer)stringWriter));
                    StringBuilder stringBuilder3 = new StringBuilder();
                    stringBuilder3.append(string4);
                    stringBuilder3.append(stringWriter.toString());
                    string3 = stringBuilder3.toString();
                }
                OSUtils.runOnMainUIThread(new Runnable(){

                    public void run() {
                        if (ActivityLifecycleHandler.curActivity != null) {
                            new AlertDialog.Builder((Context)ActivityLifecycleHandler.curActivity).setTitle((CharSequence)lOG_LEVEL.toString()).setMessage((CharSequence)string3).show();
                        }
                    }
                });
                return;
            }
            catch (Throwable throwable2) {
                Log.e((String)"OneSignal", (String)"Error showing logging message.", (Throwable)throwable2);
            }
        }
    }

    private static void SaveAppId(String string2) {
        if (appContext == null) {
            return;
        }
        OneSignalPrefs.saveString(OneSignalPrefs.PREFS_ONESIGNAL, "GT_APP_ID", string2);
    }

    private static void SaveUnsentActiveTime(long l2) {
        unSentActiveTime = l2;
        if (appContext == null) {
            return;
        }
        LOG_LEVEL lOG_LEVEL = LOG_LEVEL.INFO;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SaveUnsentActiveTime: ");
        stringBuilder.append(unSentActiveTime);
        OneSignal.Log(lOG_LEVEL, stringBuilder.toString());
        OneSignalPrefs.saveLong(OneSignalPrefs.PREFS_ONESIGNAL, "GT_UNSENT_ACTIVE_TIME", l2);
    }

    static /* synthetic */ String access$1002(String string2) {
        lastRegistrationId = string2;
        return string2;
    }

    static /* synthetic */ boolean access$1102(boolean bl2) {
        registerForPushFired = bl2;
        return bl2;
    }

    static /* synthetic */ OSSubscriptionState access$1200(Context context) {
        return OneSignal.getCurrentSubscriptionState(context);
    }

    static /* synthetic */ String access$1302(String string2) {
        mGoogleProjectNumber = string2;
        return string2;
    }

    static /* synthetic */ void access$1400() {
        OneSignal.registerForPushToken();
    }

    static /* synthetic */ void access$1500(String string2, int n2, Throwable throwable, String string3) {
        OneSignal.logHttpError(string2, n2, throwable, string3);
    }

    static /* synthetic */ void access$1600(long l2) {
        OneSignal.SaveUnsentActiveTime(l2);
    }

    static /* synthetic */ LocationGMS.LocationPoint access$502(LocationGMS.LocationPoint locationPoint) {
        lastLocationPoint = locationPoint;
        return locationPoint;
    }

    static /* synthetic */ boolean access$602(boolean bl2) {
        locationFired = bl2;
        return bl2;
    }

    static /* synthetic */ void access$700() {
        OneSignal.registerUser();
    }

    static /* synthetic */ int access$800() {
        return subscribableStatus;
    }

    static /* synthetic */ int access$802(int n2) {
        subscribableStatus = n2;
        return n2;
    }

    static /* synthetic */ boolean access$900(int n2) {
        return OneSignal.pushStatusRuntimeError(n2);
    }

    private static void addNetType(JSONObject jSONObject) {
        try {
            jSONObject.put("net_type", (Object)osUtils.getNetType());
        }
        catch (Throwable throwable) {}
    }

    static boolean areNotificationsEnabledForSubscribedState() {
        if (OneSignal.mInitBuilder.mUnsubscribeWhenNotificationsAreDisabled) {
            return OSUtils.areNotificationsEnabled(appContext);
        }
        return true;
    }

    private static boolean atLogLevel(LOG_LEVEL lOG_LEVEL) {
        int n2;
        int n3 = lOG_LEVEL.compareTo((Enum)visualLogLevel);
        if (n3 >= (n2 = 1)) {
            if (lOG_LEVEL.compareTo((Enum)logCatLevel) < n2) {
                return (boolean)n2;
            }
            n2 = 0;
        }
        return (boolean)n2;
    }

    public static void cancelNotification(final int n2) {
        Runnable runnable = new Runnable(){

            /*
             * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
             * Unable to fully structure code
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             * Lifted jumps to return sites
             */
            public void run() {
                block16 : {
                    block15 : {
                        var1_1 = OneSignalDbHelper.getInstance(OneSignal.appContext);
                        var2_2 = null;
                        var11_3 = var1_1.getWritableDbWithRetries();
                        try {
                            var11_3.beginTransaction();
                            var13_4 = new StringBuilder();
                            var13_4.append("android_notification_id = ");
                            var13_4.append(n2);
                            var13_4.append(" AND ");
                            var13_4.append("opened");
                            var13_4.append(" = 0 AND ");
                            var13_4.append("dismissed");
                            var13_4.append(" = 0");
                            var21_5 = var13_4.toString();
                            var22_6 = new ContentValues();
                            var22_6.put("dismissed", Integer.valueOf((int)1));
                            if (var11_3.update("notification", var22_6, var21_5, null) > 0) {
                                NotificationSummaryManager.updatePossibleDependentSummaryOnDismiss(OneSignal.appContext, var11_3, n2);
                            }
                            BadgeCountUpdater.update(var11_3, OneSignal.appContext);
                            var11_3.setTransactionSuccessful();
                            ** if (var11_3 == null) goto lbl-1000
                        }
                        catch (Throwable var10_7) {
                            break block16;
                        }
                        catch (Throwable var3_10) {
                            var2_2 = var11_3;
                            ** GOTO lbl-1000
                        }
lbl-1000: // 1 sources:
                        {
                            var11_3.endTransaction();
                        }
lbl-1000: // 2 sources:
                        {
                            break block15;
                        }
                        catch (Throwable var10_8) {
                            var11_3 = var2_2;
                            break block16;
                        }
                        catch (Throwable var3_11) {
                            // empty catch block
                        }
lbl-1000: // 2 sources:
                        {
                            var4_13 = LOG_LEVEL.ERROR;
                            var5_14 = new StringBuilder();
                            var5_14.append("Error marking a notification id ");
                            var5_14.append(n2);
                            var5_14.append(" as dismissed! ");
                            OneSignal.Log(var4_13, var5_14.toString(), (Throwable)var3_12);
                            ** if (var2_2 == null) goto lbl-1000
                        }
lbl-1000: // 1 sources:
                        {
                            var2_2.endTransaction();
                        }
lbl-1000: // 2 sources:
                        {
                            break block15;
                        }
                        catch (Throwable var9_15) {
                            OneSignal.Log(LOG_LEVEL.ERROR, "Error closing transaction! ", var9_15);
                        }
                    }
                    ((NotificationManager)OneSignal.appContext.getSystemService("notification")).cancel(n2);
                    return;
                }
                if (var11_3 == null) throw var10_9;
                try {
                    var11_3.endTransaction();
                    throw var10_9;
                }
                catch (Throwable var12_16) {
                    OneSignal.Log(LOG_LEVEL.ERROR, "Error closing transaction! ", var12_16);
                }
                throw var10_9;
            }
        };
        if (appContext != null && !OneSignal.shouldRunTaskThroughQueue()) {
            runnable.run();
            return;
        }
        LOG_LEVEL lOG_LEVEL = LOG_LEVEL.ERROR;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("OneSignal.init has not been called. Could not clear notification id: ");
        stringBuilder.append(n2);
        stringBuilder.append(" at this time - movingthis operation to a waiting task queue. The notification will still be canceledfrom NotificationManager at this time.");
        OneSignal.Log(lOG_LEVEL, stringBuilder.toString());
        taskQueueWaitingForInit.add((Object)runnable);
    }

    private static void fireCallbackForOpenedNotifications() {
        Iterator iterator = unprocessedOpenedNotifis.iterator();
        while (iterator.hasNext()) {
            OneSignal.runNotificationOpenedCallback((JSONArray)iterator.next(), true, false);
        }
        unprocessedOpenedNotifis.clear();
    }

    static void fireEmailUpdateFailure() {
        EmailUpdateHandler emailUpdateHandler = OneSignal.emailUpdateHandler;
        if (emailUpdateHandler != null) {
            emailUpdateHandler.onFailure(new EmailUpdateError(EmailErrorType.NETWORK, "Failed due to network failure. Will retry on next sync."));
            OneSignal.emailUpdateHandler = null;
        }
    }

    static void fireEmailUpdateSuccess() {
        EmailUpdateHandler emailUpdateHandler = OneSignal.emailUpdateHandler;
        if (emailUpdateHandler != null) {
            emailUpdateHandler.onSuccess();
            OneSignal.emailUpdateHandler = null;
        }
    }

    static void fireIdsAvailableCallback() {
        if (idsAvailableHandler != null) {
            OSUtils.runOnMainUIThread(new Runnable(){

                public void run() {
                    OneSignal.internalFireIdsAvailableCallback();
                }
            });
        }
    }

    private static void fireIntentFromNotificationOpen(Context context) {
        if (OneSignal.shouldLogUserPrivacyConsentErrorMessageForMethodName(null)) {
            return;
        }
        Intent intent = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
        if (intent != null) {
            intent.setFlags(268566528);
            context.startActivity(intent);
        }
    }

    private static void fireNotificationOpenedHandler(final OSNotificationOpenResult oSNotificationOpenResult) {
        OSUtils.runOnMainUIThread(new Runnable(){

            public void run() {
                OneSignal.mInitBuilder.mNotificationOpenedHandler.notificationOpened(oSNotificationOpenResult);
            }
        });
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static OSNotificationOpenResult generateOsNotificationOpenResult(JSONArray jSONArray, boolean bl2, boolean bl3) {
        int n2 = jSONArray.length();
        OSNotificationOpenResult oSNotificationOpenResult = new OSNotificationOpenResult();
        OSNotification oSNotification = new OSNotification();
        oSNotification.isAppInFocus = OneSignal.isAppActive();
        oSNotification.shown = bl2;
        oSNotification.androidNotificationId = jSONArray.optJSONObject(0).optInt("notificationId");
        String string2 = null;
        int n3 = 0;
        boolean bl4 = true;
        do {
            block10 : {
                block9 : {
                    if (n3 < n2) {
                        try {
                            JSONObject jSONObject = jSONArray.getJSONObject(n3);
                            oSNotification.payload = NotificationBundleProcessor.OSNotificationPayloadFrom(jSONObject);
                            if (string2 == null && jSONObject.has("actionSelected")) {
                                string2 = jSONObject.optString("actionSelected", null);
                            }
                            break block9;
                        }
                        catch (Throwable throwable) {
                            LOG_LEVEL lOG_LEVEL = LOG_LEVEL.ERROR;
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("Error parsing JSON item ");
                            stringBuilder.append(n3);
                            stringBuilder.append("/");
                            stringBuilder.append(n2);
                            stringBuilder.append(" for callback.");
                            OneSignal.Log(lOG_LEVEL, stringBuilder.toString(), throwable);
                            break block10;
                        }
                    }
                    oSNotificationOpenResult.notification = oSNotification;
                    oSNotificationOpenResult.action = new OSNotificationAction();
                    oSNotificationOpenResult.action.actionID = string2;
                    OSNotificationAction oSNotificationAction = oSNotificationOpenResult.action;
                    OSNotificationAction.ActionType actionType = string2 != null ? OSNotificationAction.ActionType.ActionTaken : OSNotificationAction.ActionType.Opened;
                    oSNotificationAction.type = actionType;
                    if (bl3) {
                        oSNotificationOpenResult.notification.displayType = OSNotification.DisplayType.InAppAlert;
                        return oSNotificationOpenResult;
                    }
                    oSNotificationOpenResult.notification.displayType = OSNotification.DisplayType.Notification;
                    return oSNotificationOpenResult;
                }
                if (bl4) {
                    bl4 = false;
                } else {
                    if (oSNotification.groupedNotifications == null) {
                        oSNotification.groupedNotifications = new ArrayList();
                    }
                    oSNotification.groupedNotifications.add((Object)oSNotification.payload);
                }
            }
            ++n3;
        } while (true);
    }

    private static OSEmailSubscriptionState getCurrentEmailSubscriptionState(Context context) {
        if (context == null) {
            return null;
        }
        if (currentEmailSubscriptionState == null) {
            currentEmailSubscriptionState = new OSEmailSubscriptionState(false);
            OneSignal.currentEmailSubscriptionState.observable.addObserverStrong(new OSEmailSubscriptionChangedInternalObserver());
        }
        return currentEmailSubscriptionState;
    }

    public static Builder getCurrentOrNewInitBuilder() {
        if (mInitBuilder == null) {
            mInitBuilder = new Builder();
        }
        return mInitBuilder;
    }

    private static OSPermissionState getCurrentPermissionState(Context context) {
        if (context == null) {
            return null;
        }
        if (currentPermissionState == null) {
            currentPermissionState = new OSPermissionState(false);
            OneSignal.currentPermissionState.observable.addObserverStrong(new OSPermissionChangedInternalObserver());
        }
        return currentPermissionState;
    }

    private static OSSubscriptionState getCurrentSubscriptionState(Context context) {
        if (context == null) {
            return null;
        }
        if (currentSubscriptionState == null) {
            currentSubscriptionState = new OSSubscriptionState(false, OneSignal.getCurrentPermissionState(context).getEnabled());
            OneSignal.getCurrentPermissionState((Context)context).observable.addObserver(currentSubscriptionState);
            OneSignal.currentSubscriptionState.observable.addObserverStrong(new OSSubscriptionChangedInternalObserver());
        }
        return currentSubscriptionState;
    }

    static String getEmailId() {
        if ("".equals((Object)emailId)) {
            return null;
        }
        if (emailId == null && appContext != null) {
            emailId = OneSignalPrefs.getString(OneSignalPrefs.PREFS_ONESIGNAL, "OS_EMAIL_ID", null);
        }
        return emailId;
    }

    static boolean getFilterOtherGCMReceivers(Context context) {
        return OneSignalPrefs.getBool(OneSignalPrefs.PREFS_ONESIGNAL, "OS_FILTER_OTHER_GCM_RECEIVERS", false);
    }

    static boolean getFirebaseAnalyticsEnabled(Context context) {
        return OneSignalPrefs.getBool(OneSignalPrefs.PREFS_ONESIGNAL, "GT_FIREBASE_TRACKING_ENABLED", false);
    }

    static boolean getInAppAlertNotificationEnabled() {
        Builder builder = mInitBuilder;
        if (builder == null) {
            return false;
        }
        OSInFocusDisplayOption oSInFocusDisplayOption = builder.mDisplayOption;
        OSInFocusDisplayOption oSInFocusDisplayOption2 = OSInFocusDisplayOption.InAppAlert;
        boolean bl2 = false;
        if (oSInFocusDisplayOption == oSInFocusDisplayOption2) {
            bl2 = true;
        }
        return bl2;
    }

    private static long getLastSessionTime(Context context) {
        return OneSignalPrefs.getLong(OneSignalPrefs.PREFS_ONESIGNAL, "OS_LAST_SESSION_TIME", -31000L);
    }

    static String getNotificationIdFromGCMBundle(Bundle bundle) {
        block5 : {
            if (bundle.isEmpty()) {
                return null;
            }
            try {
                if (!bundle.containsKey("custom")) break block5;
                JSONObject jSONObject = new JSONObject(bundle.getString("custom"));
                if (jSONObject.has("i")) {
                    return jSONObject.optString("i", null);
                }
                OneSignal.Log(LOG_LEVEL.DEBUG, "Not a OneSignal formatted GCM message. No 'i' field in custom.");
                return null;
            }
            catch (Throwable throwable) {
                OneSignal.Log(LOG_LEVEL.DEBUG, "Could not parse bundle, probably not a OneSignal notification.", throwable);
                return null;
            }
        }
        OneSignal.Log(LOG_LEVEL.DEBUG, "Not a OneSignal formatted GCM message. No 'custom' field in the bundle.");
        return null;
    }

    private static String getNotificationIdFromGCMJsonPayload(JSONObject jSONObject) {
        try {
            String string2 = new JSONObject(jSONObject.optString("custom")).optString("i", null);
            return string2;
        }
        catch (Throwable throwable) {
            return null;
        }
    }

    static boolean getNotificationsWhenActiveEnabled() {
        Builder builder = mInitBuilder;
        if (builder == null) {
            return true;
        }
        return builder.mDisplayOption == OSInFocusDisplayOption.Notification;
    }

    static OSObservable<Object, OSPermissionStateChanges> getPermissionStateChangesObserver() {
        if (permissionStateChangesObserver == null) {
            permissionStateChangesObserver = new OSObservable("onOSPermissionChanged", true);
        }
        return permissionStateChangesObserver;
    }

    private static PushRegistrator getPushRegistrator() {
        PushRegistrator pushRegistrator = mPushRegistrator;
        if (pushRegistrator != null) {
            return pushRegistrator;
        }
        mPushRegistrator = deviceType == 2 ? new PushRegistratorADM() : (OSUtils.hasFCMLibrary() ? new PushRegistratorFCM() : new PushRegistratorGCM());
        return mPushRegistrator;
    }

    static String getSavedAppId() {
        return OneSignal.getSavedAppId(appContext);
    }

    private static String getSavedAppId(Context context) {
        if (context == null) {
            return "";
        }
        return OneSignalPrefs.getString(OneSignalPrefs.PREFS_ONESIGNAL, "GT_APP_ID", null);
    }

    static boolean getSavedUserConsentStatus() {
        return OneSignalPrefs.getBool(OneSignalPrefs.PREFS_ONESIGNAL, "ONESIGNAL_USER_PROVIDED_CONSENT", false);
    }

    private static String getSavedUserId(Context context) {
        if (context == null) {
            return "";
        }
        return OneSignalPrefs.getString(OneSignalPrefs.PREFS_ONESIGNAL, "GT_PLAYER_ID", null);
    }

    static boolean getSoundEnabled(Context context) {
        return OneSignalPrefs.getBool(OneSignalPrefs.PREFS_ONESIGNAL, "GT_SOUND_ENABLED", true);
    }

    static OSObservable<Object, OSSubscriptionStateChanges> getSubscriptionStateChangesObserver() {
        if (subscriptionStateChangesObserver == null) {
            subscriptionStateChangesObserver = new OSObservable("onOSSubscriptionChanged", true);
        }
        return subscriptionStateChangesObserver;
    }

    private static int getTimeZoneOffset() {
        TimeZone timeZone = Calendar.getInstance().getTimeZone();
        int n2 = timeZone.getRawOffset();
        if (timeZone.inDaylightTime(new Date())) {
            n2 += timeZone.getDSTSavings();
        }
        return n2 / 1000;
    }

    static String getUserId() {
        if (userId == null && appContext != null) {
            userId = OneSignalPrefs.getString(OneSignalPrefs.PREFS_ONESIGNAL, "GT_PLAYER_ID", null);
        }
        return userId;
    }

    static boolean getVibrate(Context context) {
        return OneSignalPrefs.getBool(OneSignalPrefs.PREFS_ONESIGNAL, "GT_VIBRATE_ENABLED", true);
    }

    static void handleFailedEmailLogout() {
        EmailUpdateHandler emailUpdateHandler = emailLogoutHandler;
        if (emailUpdateHandler != null) {
            emailUpdateHandler.onFailure(new EmailUpdateError(EmailErrorType.NETWORK, "Failed due to network failure. Will retry on next sync."));
            emailLogoutHandler = null;
        }
    }

    public static void handleNotificationOpen(Context context, JSONArray jSONArray, boolean bl2) {
        if (OneSignal.shouldLogUserPrivacyConsentErrorMessageForMethodName(null)) {
            return;
        }
        OneSignal.notificationOpenedRESTCall(context, jSONArray);
        if (trackFirebaseAnalytics != null && OneSignal.getFirebaseAnalyticsEnabled(appContext)) {
            trackFirebaseAnalytics.trackOpenedEvent(OneSignal.generateOsNotificationOpenResult(jSONArray, true, bl2));
        }
        boolean bl3 = "DISABLE".equals((Object)OSUtils.getManifestMeta(context, "com.onesignal.NotificationOpened.DEFAULT"));
        boolean bl4 = false;
        if (!bl3) {
            bl4 = OneSignal.openURLFromNotification(context, jSONArray);
        }
        OneSignal.runNotificationOpenedCallback(jSONArray, true, bl2);
        if (!(bl2 || bl4 || bl3)) {
            OneSignal.fireIntentFromNotificationOpen(context);
        }
    }

    static void handleNotificationReceived(JSONArray jSONArray, boolean bl2, boolean bl3) {
        Builder builder;
        OSNotificationOpenResult oSNotificationOpenResult = OneSignal.generateOsNotificationOpenResult(jSONArray, bl2, bl3);
        if (trackFirebaseAnalytics != null && OneSignal.getFirebaseAnalyticsEnabled(appContext)) {
            trackFirebaseAnalytics.trackReceivedEvent(oSNotificationOpenResult);
        }
        if ((builder = mInitBuilder) != null) {
            if (builder.mNotificationReceivedHandler == null) {
                return;
            }
            OneSignal.mInitBuilder.mNotificationReceivedHandler.notificationReceived(oSNotificationOpenResult.notification);
        }
    }

    static void handleSuccessfulEmailLogout() {
        EmailUpdateHandler emailUpdateHandler = emailLogoutHandler;
        if (emailUpdateHandler != null) {
            emailUpdateHandler.onSuccess();
            emailLogoutHandler = null;
        }
    }

    public static void init(Context context, String string2, String string3, NotificationOpenedHandler notificationOpenedHandler, NotificationReceivedHandler notificationReceivedHandler) {
        boolean bl2;
        OneSignal.setAppContext(context);
        if (requiresUserPrivacyConsent && !OneSignal.userProvidedPrivacyConsent()) {
            DelayedConsentInitializationParameters delayedConsentInitializationParameters;
            OneSignal.Log(LOG_LEVEL.VERBOSE, "OneSignal SDK initialization delayed, user privacy consent is set to required for this application.");
            delayedInitParams = delayedConsentInitializationParameters = new DelayedConsentInitializationParameters(context, string2, string3, notificationOpenedHandler, notificationReceivedHandler);
            return;
        }
        Builder builder = mInitBuilder = OneSignal.getCurrentOrNewInitBuilder();
        builder.mDisplayOptionCarryOver = false;
        builder.mNotificationOpenedHandler = notificationOpenedHandler;
        builder.mNotificationReceivedHandler = notificationReceivedHandler;
        OneSignalRemoteParams.Params params = remoteParams;
        boolean bl3 = params != null && params.googleProjectNumber != null;
        if (!bl3) {
            mGoogleProjectNumber = string2;
        }
        if ((subscribableStatus = (osUtils = new OSUtils()).initializationChecker(context, deviceType = osUtils.getDeviceType(), string3)) == -999) {
            return;
        }
        if (initDone) {
            if (OneSignal.mInitBuilder.mNotificationOpenedHandler != null) {
                OneSignal.fireCallbackForOpenedNotifications();
            }
            return;
        }
        foreground = bl2 = context instanceof Activity;
        appId = string3;
        OneSignal.saveFilterOtherGCMReceivers(OneSignal.mInitBuilder.mFilterOtherGCMReceivers);
        if (bl2) {
            ActivityLifecycleHandler.curActivity = (Activity)context;
            NotificationRestorer.asyncRestore(appContext);
        } else {
            ActivityLifecycleHandler.nextResumeIsFirstActivity = true;
        }
        lastTrackedFocusTime = SystemClock.elapsedRealtime();
        OneSignalStateSynchronizer.initUserState();
        ((Application)appContext).registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)new ActivityLifecycleListener());
        try {
            Class.forName((String)"com.amazon.device.iap.PurchasingListener");
            trackAmazonPurchase = new TrackAmazonPurchase(appContext);
        }
        catch (ClassNotFoundException classNotFoundException) {}
        String string4 = OneSignal.getSavedAppId();
        if (string4 != null) {
            if (!string4.equals((Object)appId)) {
                OneSignal.Log(LOG_LEVEL.DEBUG, "APP ID changed, clearing user id as it is no longer valid.");
                OneSignal.SaveAppId(appId);
                OneSignalStateSynchronizer.resetCurrentState();
            }
        } else {
            BadgeCountUpdater.updateCount(0, appContext);
            OneSignal.SaveAppId(appId);
        }
        OSPermissionChangedInternalObserver.handleInternalChanges(OneSignal.getCurrentPermissionState(appContext));
        if (foreground || OneSignal.getUserId() == null) {
            if (OneSignal.isPastOnSessionTime()) {
                OneSignalStateSynchronizer.setNewSession();
            }
            OneSignal.setLastSessionTime(System.currentTimeMillis());
            OneSignal.startRegistrationOrOnSession();
        }
        if (OneSignal.mInitBuilder.mNotificationOpenedHandler != null) {
            OneSignal.fireCallbackForOpenedNotifications();
        }
        if (TrackGooglePurchase.CanTrack(appContext)) {
            trackGooglePurchase = new TrackGooglePurchase(appContext);
        }
        if (TrackFirebaseAnalytics.CanTrack()) {
            trackFirebaseAnalytics = new TrackFirebaseAnalytics(appContext);
        }
        PushRegistratorFCM.disableFirebaseInstanceIdService((Context)appContext);
        initDone = true;
        OneSignal.startPendingTasks();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static void internalFireGetTagsCallbacks() {
        ArrayList<GetTagsHandler> arrayList;
        ArrayList<GetTagsHandler> arrayList2 = arrayList = pendingGetTagsHandlers;
        synchronized (arrayList2) {
            if (pendingGetTagsHandlers.size() == 0) {
                return;
            }
        }
        new Thread(new Runnable(){

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            public void run() {
                ArrayList arrayList;
                UserStateSynchronizer.GetTagsResult getTagsResult = OneSignalStateSynchronizer.getTags(true ^ getTagsCall);
                if (getTagsResult.serverSuccess) {
                    getTagsCall = true;
                }
                ArrayList arrayList2 = arrayList = pendingGetTagsHandlers;
                synchronized (arrayList2) {
                    Iterator iterator = pendingGetTagsHandlers.iterator();
                    do {
                        if (!iterator.hasNext()) {
                            pendingGetTagsHandlers.clear();
                            return;
                        }
                        GetTagsHandler getTagsHandler = (GetTagsHandler)iterator.next();
                        JSONObject jSONObject = getTagsResult.result != null && !getTagsResult.toString().equals((Object)"{}") ? getTagsResult.result : null;
                        getTagsHandler.tagsAvailable(jSONObject);
                    } while (true);
                }
            }
        }, "OS_GETTAGS_CALLBACK").start();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static void internalFireIdsAvailableCallback() {
        Class<OneSignal> class_ = OneSignal.class;
        synchronized (OneSignal.class) {
            String string2;
            IdsAvailableHandler idsAvailableHandler = OneSignal.idsAvailableHandler;
            if (idsAvailableHandler == null) {
                // ** MonitorExit[var4] (shouldn't be in output)
                return;
            }
            String string3 = OneSignalStateSynchronizer.getRegistrationId();
            if (!OneSignalStateSynchronizer.getSubscribed()) {
                string3 = null;
            }
            if ((string2 = OneSignal.getUserId()) == null) {
                // ** MonitorExit[var4] (shouldn't be in output)
                return;
            }
            OneSignal.idsAvailableHandler.idsAvailable(string2, string3);
            if (string3 != null) {
                OneSignal.idsAvailableHandler = null;
            }
            // ** MonitorExit[var4] (shouldn't be in output)
            return;
        }
    }

    static boolean isAppActive() {
        return initDone && OneSignal.isForeground();
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private static boolean isDuplicateNotification(String var0, Context var1_1) {
        block6 : {
            if (var0 == null) return false;
            if ("".equals((Object)var0)) {
                return false;
            }
            var2_2 = OneSignalDbHelper.getInstance(var1_1);
            var3_3 = null;
            var3_3 = var2_2.getReadableDbWithRetries().query("notification", new String[]{"notification_id"}, "notification_id = ?", new String[]{var0}, null, null, null);
            var5_4 = var3_3.moveToFirst();
            ** if (var3_3 == null) goto lbl-1000
lbl-1000: // 1 sources:
            {
                var3_3.close();
            }
lbl-1000: // 2 sources:
            {
            }
            {
                block7 : {
                    catch (Throwable var10_5) {
                        break block6;
                    }
                    catch (Throwable var4_6) {}
                    {
                        OneSignal.Log(LOG_LEVEL.ERROR, "Could not check for duplicate, assuming unique.", var4_6);
                        if (var3_3 == null) break block7;
                    }
                    var3_3.close();
                }
                var5_4 = false;
            }
            if (var5_4 == false) return false;
            var6_7 = LOG_LEVEL.DEBUG;
            var7_8 = new StringBuilder();
            var7_8.append("Duplicate GCM message received, skip processing of ");
            var7_8.append(var0);
            OneSignal.Log(var6_7, var7_8.toString());
            return true;
        }
        if (var3_3 == null) throw var10_5;
        var3_3.close();
        throw var10_5;
    }

    static boolean isForeground() {
        return foreground;
    }

    private static boolean isPastOnSessionTime() {
        return (System.currentTimeMillis() - OneSignal.getLastSessionTime(appContext)) / 1000L >= 30L;
    }

    private static void logHttpError(String string2, int n2, Throwable throwable, String string3) {
        String string4;
        if (string3 != null && OneSignal.atLogLevel(LOG_LEVEL.INFO)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("\n");
            stringBuilder.append(string3);
            stringBuilder.append("\n");
            string4 = stringBuilder.toString();
        } else {
            string4 = "";
        }
        LOG_LEVEL lOG_LEVEL = LOG_LEVEL.WARN;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("HTTP code: ");
        stringBuilder.append(n2);
        stringBuilder.append(" ");
        stringBuilder.append(string2);
        stringBuilder.append(string4);
        OneSignal.Log(lOG_LEVEL, stringBuilder.toString(), throwable);
    }

    private static void makeAndroidParamsRequest() {
        if (remoteParams != null) {
            OneSignal.registerForPushToken();
            return;
        }
        OneSignalRemoteParams.makeAndroidParamsRequest((OneSignalRemoteParams.CallBack)new 4());
    }

    static boolean notValidOrDuplicated(Context context, JSONObject jSONObject) {
        String string2 = OneSignal.getNotificationIdFromGCMJsonPayload(jSONObject);
        return string2 == null || OneSignal.isDuplicateNotification(string2, context);
        {
        }
    }

    private static void notificationOpenedRESTCall(Context context, JSONArray jSONArray) {
        for (int i2 = 0; i2 < jSONArray.length(); ++i2) {
            try {
                String string2 = new JSONObject(jSONArray.getJSONObject(i2).optString("custom", null)).optString("i", null);
                if (postedOpenedNotifIds.contains((Object)string2)) continue;
                postedOpenedNotifIds.add((Object)string2);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("app_id", (Object)OneSignal.getSavedAppId(context));
                jSONObject.put("player_id", (Object)OneSignal.getSavedUserId(context));
                jSONObject.put("opened", true);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("notifications/");
                stringBuilder.append(string2);
                OneSignalRestClient.put(stringBuilder.toString(), jSONObject, (OneSignalRestClient.ResponseHandler)new 19());
                continue;
            }
            catch (Throwable throwable) {
                OneSignal.Log(LOG_LEVEL.ERROR, "Failed to generate JSON to send notification opened.", throwable);
            }
        }
    }

    static void onAppFocus() {
        foreground = true;
        LocationGMS.onFocusChange();
        lastTrackedFocusTime = SystemClock.elapsedRealtime();
        if (OneSignal.isPastOnSessionTime()) {
            OneSignalStateSynchronizer.setNewSession();
        }
        OneSignal.setLastSessionTime(System.currentTimeMillis());
        OneSignal.startRegistrationOrOnSession();
        TrackGooglePurchase trackGooglePurchase = OneSignal.trackGooglePurchase;
        if (trackGooglePurchase != null) {
            trackGooglePurchase.trackIAP();
        }
        NotificationRestorer.asyncRestore(appContext);
        OneSignal.getCurrentPermissionState(appContext).refreshAsTo();
        if (trackFirebaseAnalytics != null && OneSignal.getFirebaseAnalyticsEnabled(appContext)) {
            trackFirebaseAnalytics.trackInfluenceOpenEvent();
        }
        OneSignalSyncServiceUtils.cancelSyncTask(appContext);
    }

    static boolean onAppLostFocus() {
        foreground = false;
        OneSignal.setLastSessionTime(System.currentTimeMillis());
        LocationGMS.onFocusChange();
        if (!initDone) {
            return false;
        }
        TrackAmazonPurchase trackAmazonPurchase = OneSignal.trackAmazonPurchase;
        if (trackAmazonPurchase != null) {
            trackAmazonPurchase.checkListener();
        }
        if (lastTrackedFocusTime == -1L) {
            return false;
        }
        double d2 = SystemClock.elapsedRealtime() - lastTrackedFocusTime;
        Double.isNaN((double)d2);
        long l2 = (long)(0.5 + d2 / 1000.0);
        lastTrackedFocusTime = SystemClock.elapsedRealtime();
        long l3 = l2 LCMP 0L;
        boolean bl2 = false;
        if (l3 >= 0) {
            if (l2 > 86400L) {
                return false;
            }
            if (appContext == null) {
                OneSignal.Log(LOG_LEVEL.ERROR, "Android Context not found, please call OneSignal.init when your app starts.");
                return false;
            }
            boolean bl3 = OneSignal.scheduleSyncService();
            long l4 = l2 + OneSignal.GetUnsentActiveTime();
            OneSignal.SaveUnsentActiveTime(l4);
            if (l4 >= 60L && OneSignal.getUserId() != null) {
                if (!bl3) {
                    OneSignalSyncServiceUtils.scheduleSyncTask(appContext);
                }
                OneSignalSyncServiceUtils.syncOnFocusTime();
                return false;
            }
            long l5 = l4 LCMP 60L;
            bl2 = false;
            if (l5 >= 0) {
                bl2 = true;
            }
        }
        return bl2;
    }

    private static boolean openURLFromNotification(Context context, JSONArray jSONArray) {
        boolean bl2 = OneSignal.shouldLogUserPrivacyConsentErrorMessageForMethodName(null);
        if (bl2) {
            return false;
        }
        int n2 = jSONArray.length();
        boolean bl3 = false;
        for (int i2 = 0; i2 < n2; ++i2) {
            try {
                JSONObject jSONObject;
                JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                if (!jSONObject2.has("custom") || !(jSONObject = new JSONObject(jSONObject2.optString("custom"))).has("u")) continue;
                String string2 = jSONObject.optString("u", null);
                if (!string2.contains((CharSequence)"://")) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("http://");
                    stringBuilder.append(string2);
                    string2 = stringBuilder.toString();
                }
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse((String)string2.trim()));
                intent.addFlags(1476919296);
                context.startActivity(intent);
                bl3 = true;
                continue;
            }
            catch (Throwable throwable) {
                LOG_LEVEL lOG_LEVEL = LOG_LEVEL.ERROR;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Error parsing JSON item ");
                stringBuilder.append(i2);
                stringBuilder.append("/");
                stringBuilder.append(n2);
                stringBuilder.append(" for launching a web URL.");
                OneSignal.Log(lOG_LEVEL, stringBuilder.toString(), throwable);
            }
        }
        return bl3;
    }

    private static boolean pushStatusRuntimeError(int n2) {
        return n2 < -6;
    }

    private static void registerForPushToken() {
        OneSignal.getPushRegistrator().registerForPush(appContext, mGoogleProjectNumber, (PushRegistrator.RegisteredHandler)new 3());
    }

    private static void registerUser() {
        LOG_LEVEL lOG_LEVEL = LOG_LEVEL.DEBUG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("registerUser: registerForPushFired:");
        stringBuilder.append(registerForPushFired);
        stringBuilder.append(", locationFired: ");
        stringBuilder.append(locationFired);
        stringBuilder.append(", remoteParams: ");
        stringBuilder.append((Object)remoteParams);
        OneSignal.Log(lOG_LEVEL, stringBuilder.toString());
        if (registerForPushFired && locationFired) {
            if (remoteParams == null) {
                return;
            }
            new Thread(new Runnable(){

                public void run() {
                    try {
                        OneSignal.registerUserTask();
                        OneSignalChromeTab.setup(OneSignal.appContext, OneSignal.appId, userId, AdvertisingIdProviderGPS.getLastValue());
                        return;
                    }
                    catch (JSONException jSONException) {
                        OneSignal.Log(LOG_LEVEL.FATAL, "FATAL Error registering device!", jSONException);
                        return;
                    }
                }
            }, "OS_REG_USER").start();
        }
    }

    private static void registerUserTask() throws JSONException {
        JSONObject jSONObject;
        LocationGMS.LocationPoint locationPoint;
        String string2 = appContext.getPackageName();
        PackageManager packageManager = appContext.getPackageManager();
        jSONObject = new JSONObject();
        jSONObject.put("app_id", (Object)appId);
        String string3 = mainAdIdProvider.getIdentifier(appContext);
        if (string3 != null) {
            jSONObject.put("ad_id", (Object)string3);
        }
        jSONObject.put("device_os", (Object)Build.VERSION.RELEASE);
        jSONObject.put("timezone", OneSignal.getTimeZoneOffset());
        jSONObject.put("language", (Object)OSUtils.getCorrectedLanguage());
        jSONObject.put("sdk", (Object)"031009");
        jSONObject.put("sdk_type", (Object)sdkType);
        jSONObject.put("android_package", (Object)string2);
        jSONObject.put("device_model", (Object)Build.MODEL);
        try {
            jSONObject.put("game_version", packageManager.getPackageInfo((String)string2, (int)0).versionCode);
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {}
        jSONObject.put("net_type", (Object)osUtils.getNetType());
        jSONObject.put("carrier", (Object)osUtils.getCarrierName());
        jSONObject.put("rooted", RootToolsInternalMethods.isRooted());
        OneSignalStateSynchronizer.updateDeviceInfo(jSONObject);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("identifier", (Object)lastRegistrationId);
        jSONObject2.put("subscribableStatus", subscribableStatus);
        jSONObject2.put("androidPermission", OneSignal.areNotificationsEnabledForSubscribedState());
        jSONObject2.put("device_type", deviceType);
        OneSignalStateSynchronizer.updatePushState(jSONObject2);
        if (shareLocation && (locationPoint = lastLocationPoint) != null) {
            OneSignalStateSynchronizer.updateLocation(locationPoint);
        }
        OneSignalStateSynchronizer.readyToUpdate(true);
        waitingToPostStateSync = false;
    }

    private static void runNotificationOpenedCallback(JSONArray jSONArray, boolean bl2, boolean bl3) {
        Builder builder = mInitBuilder;
        if (builder != null && builder.mNotificationOpenedHandler != null) {
            OneSignal.fireNotificationOpenedHandler(OneSignal.generateOsNotificationOpenResult(jSONArray, bl2, bl3));
            return;
        }
        unprocessedOpenedNotifis.add((Object)jSONArray);
    }

    static void saveEmailId(String string2) {
        emailId = string2;
        if (appContext == null) {
            return;
        }
        String string3 = OneSignalPrefs.PREFS_ONESIGNAL;
        String string4 = "".equals((Object)emailId) ? null : emailId;
        OneSignalPrefs.saveString(string3, "OS_EMAIL_ID", string4);
    }

    static void saveFilterOtherGCMReceivers(boolean bl2) {
        if (appContext == null) {
            return;
        }
        OneSignalPrefs.saveBool(OneSignalPrefs.PREFS_ONESIGNAL, "OS_FILTER_OTHER_GCM_RECEIVERS", bl2);
    }

    static void saveUserId(String string2) {
        userId = string2;
        if (appContext == null) {
            return;
        }
        OneSignalPrefs.saveString(OneSignalPrefs.PREFS_ONESIGNAL, "GT_PLAYER_ID", userId);
    }

    static boolean scheduleSyncService() {
        boolean bl2 = OneSignalStateSynchronizer.persist();
        if (bl2) {
            OneSignalSyncServiceUtils.scheduleSyncTask(appContext);
        }
        return LocationGMS.scheduleUpdate(appContext) || bl2;
        {
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    static void sendOnFocus(long l2, boolean bl2) {
        JSONObject jSONObject = new JSONObject().put("app_id", (Object)appId).put("type", 1).put("state", (Object)"ping").put("active_time", l2);
        OneSignal.addNetType(jSONObject);
        OneSignal.sendOnFocusToPlayer(OneSignal.getUserId(), jSONObject, bl2);
        String string2 = OneSignal.getEmailId();
        if (string2 == null) return;
        try {
            OneSignal.sendOnFocusToPlayer(string2, jSONObject, bl2);
            return;
        }
        catch (Throwable throwable) {
            OneSignal.Log(LOG_LEVEL.ERROR, "Generating on_focus:JSON Failed.", throwable);
        }
    }

    private static void sendOnFocusToPlayer(String string2, JSONObject jSONObject, boolean bl2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("players/");
        stringBuilder.append(string2);
        stringBuilder.append("/on_focus");
        String string3 = stringBuilder.toString();
        6 var8_5 = new 6();
        if (bl2) {
            OneSignalRestClient.postSync(string3, jSONObject, (OneSignalRestClient.ResponseHandler)var8_5);
            return;
        }
        OneSignalRestClient.post(string3, jSONObject, (OneSignalRestClient.ResponseHandler)var8_5);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static void sendPurchases(JSONArray jSONArray, boolean bl2, OneSignalRestClient.ResponseHandler responseHandler) {
        if (OneSignal.shouldLogUserPrivacyConsentErrorMessageForMethodName("sendPurchases()")) {
            return;
        }
        if (OneSignal.getUserId() == null) {
            IAPUpdateJob iAPUpdateJob = iapUpdateJob = new IAPUpdateJob(jSONArray);
            iAPUpdateJob.newAsExisting = bl2;
            iAPUpdateJob.restResponseHandler = responseHandler;
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("app_id", (Object)appId);
            if (bl2) {
                jSONObject.put("existing", true);
            }
            jSONObject.put("purchases", (Object)jSONArray);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("players/");
            stringBuilder.append(OneSignal.getUserId());
            stringBuilder.append("/on_purchase");
            OneSignalRestClient.post(stringBuilder.toString(), jSONObject, responseHandler);
            if (OneSignal.getEmailId() == null) return;
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("players/");
            stringBuilder2.append(OneSignal.getEmailId());
            stringBuilder2.append("/on_purchase");
            OneSignalRestClient.post(stringBuilder2.toString(), jSONObject, null);
            return;
        }
        catch (Throwable throwable) {
            OneSignal.Log(LOG_LEVEL.ERROR, "Failed to generate JSON for sendPurchases.", throwable);
        }
    }

    public static void setAppContext(Context context) {
        if (context == null) {
            OneSignal.Log(LOG_LEVEL.WARN, "setAppContext(null) is not valid, ignoring!");
            return;
        }
        boolean bl2 = appContext == null;
        appContext = context.getApplicationContext();
        if (bl2) {
            OneSignalPrefs.startDelayedWrite();
        }
    }

    public static void setInFocusDisplaying(OSInFocusDisplayOption oSInFocusDisplayOption) {
        OneSignal.getCurrentOrNewInitBuilder().mDisplayOptionCarryOver = true;
        OneSignal.getCurrentOrNewInitBuilder().mDisplayOption = oSInFocusDisplayOption;
    }

    static void setLastSessionTime(long l2) {
        OneSignalPrefs.saveLong(OneSignalPrefs.PREFS_ONESIGNAL, "OS_LAST_SESSION_TIME", l2);
    }

    static boolean shouldLogUserPrivacyConsentErrorMessageForMethodName(String string2) {
        if (requiresUserPrivacyConsent && !OneSignal.userProvidedPrivacyConsent()) {
            if (string2 != null) {
                LOG_LEVEL lOG_LEVEL = LOG_LEVEL.WARN;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Method ");
                stringBuilder.append(string2);
                stringBuilder.append(" was called before the user provided privacy consent. Your application is set to require the user's privacy consent before the OneSignal SDK can be initialized. Please ensure the user has provided consent before calling this method. You can check the latest OneSignal consent status by calling OneSignal.userProvidedPrivacyConsent()");
                OneSignal.Log(lOG_LEVEL, stringBuilder.toString());
            }
            return true;
        }
        return false;
    }

    private static boolean shouldRunTaskThroughQueue() {
        if (initDone && pendingTaskExecutor == null) {
            return false;
        }
        if (!initDone && pendingTaskExecutor == null) {
            return true;
        }
        ExecutorService executorService = pendingTaskExecutor;
        return executorService != null && !executorService.isShutdown();
    }

    private static void startLocationUpdate() {
        2 var0 = new 2();
        boolean bl2 = OneSignal.mInitBuilder.mPromptLocation;
        boolean bl3 = true;
        boolean bl4 = bl2 && !promptedLocation;
        if (!promptedLocation && !OneSignal.mInitBuilder.mPromptLocation) {
            bl3 = false;
        }
        promptedLocation = bl3;
        LocationGMS.getLocation(appContext, bl4, (LocationGMS.LocationHandler)var0);
    }

    private static void startPendingTasks() {
        if (!taskQueueWaitingForInit.isEmpty()) {
            pendingTaskExecutor = Executors.newSingleThreadExecutor((ThreadFactory)new ThreadFactory(){

                public Thread newThread(Runnable runnable) {
                    Thread thread = new Thread(runnable);
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("OS_PENDING_EXECUTOR_");
                    stringBuilder.append(thread.getId());
                    thread.setName(stringBuilder.toString());
                    return thread;
                }
            });
            while (!taskQueueWaitingForInit.isEmpty()) {
                pendingTaskExecutor.submit((Runnable)taskQueueWaitingForInit.poll());
            }
        }
    }

    private static void startRegistrationOrOnSession() {
        if (waitingToPostStateSync) {
            return;
        }
        waitingToPostStateSync = true;
        if (OneSignalStateSynchronizer.getSyncAsNewSession()) {
            locationFired = false;
        }
        OneSignal.startLocationUpdate();
        registerForPushFired = false;
        OneSignal.makeAndroidParamsRequest();
    }

    static void updateEmailIdDependents(String string2) {
        OneSignal.saveEmailId(string2);
        OneSignal.getCurrentEmailSubscriptionState(appContext).setEmailUserId(string2);
        try {
            OneSignalStateSynchronizer.updatePushState(new JSONObject().put("parent_player_id", (Object)string2));
            return;
        }
        catch (JSONException jSONException) {
            jSONException.printStackTrace();
            return;
        }
    }

    static void updateUserIdDependents(String string2) {
        OneSignal.saveUserId(string2);
        OneSignal.fireIdsAvailableCallback();
        OneSignal.internalFireGetTagsCallbacks();
        OneSignal.getCurrentSubscriptionState(appContext).setUserId(string2);
        IAPUpdateJob iAPUpdateJob = iapUpdateJob;
        if (iAPUpdateJob != null) {
            OneSignal.sendPurchases(iAPUpdateJob.toReport, OneSignal.iapUpdateJob.newAsExisting, OneSignal.iapUpdateJob.restResponseHandler);
            iapUpdateJob = null;
        }
        OneSignalStateSynchronizer.refreshEmailState();
        OneSignalChromeTab.setup(appContext, appId, string2, AdvertisingIdProviderGPS.getLastValue());
    }

    public static boolean userProvidedPrivacyConsent() {
        return OneSignal.getSavedUserConsentStatus();
    }

    public static class Builder {
        boolean mDisableGmsMissingPrompt;
        OSInFocusDisplayOption mDisplayOption = OSInFocusDisplayOption.InAppAlert;
        boolean mDisplayOptionCarryOver;
        boolean mFilterOtherGCMReceivers;
        NotificationOpenedHandler mNotificationOpenedHandler;
        NotificationReceivedHandler mNotificationReceivedHandler;
        boolean mPromptLocation;
        boolean mUnsubscribeWhenNotificationsAreDisabled;

        private Builder() {
        }
    }

    public static interface ChangeTagsUpdateHandler {
        public void onFailure(SendTagsError var1);

        public void onSuccess(JSONObject var1);
    }

    public static final class EmailErrorType
    extends Enum<EmailErrorType> {
        private static final /* synthetic */ EmailErrorType[] $VALUES;
        public static final /* enum */ EmailErrorType INVALID_OPERATION;
        public static final /* enum */ EmailErrorType NETWORK;
        public static final /* enum */ EmailErrorType REQUIRES_EMAIL_AUTH;
        public static final /* enum */ EmailErrorType VALIDATION;

        static {
            VALIDATION = new EmailErrorType();
            REQUIRES_EMAIL_AUTH = new EmailErrorType();
            INVALID_OPERATION = new EmailErrorType();
            NETWORK = new EmailErrorType();
            EmailErrorType[] arremailErrorType = new EmailErrorType[]{VALIDATION, REQUIRES_EMAIL_AUTH, INVALID_OPERATION, NETWORK};
            $VALUES = arremailErrorType;
        }

        public static EmailErrorType valueOf(String string2) {
            return (EmailErrorType)Enum.valueOf(EmailErrorType.class, (String)string2);
        }

        public static EmailErrorType[] values() {
            return (EmailErrorType[])$VALUES.clone();
        }
    }

    public static class EmailUpdateError {
        private String message;
        private EmailErrorType type;

        EmailUpdateError(EmailErrorType emailErrorType, String string2) {
            this.type = emailErrorType;
            this.message = string2;
        }
    }

    public static interface EmailUpdateHandler {
        public void onFailure(EmailUpdateError var1);

        public void onSuccess();
    }

    public static interface GetTagsHandler {
        public void tagsAvailable(JSONObject var1);
    }

    private static class IAPUpdateJob {
        boolean newAsExisting;
        OneSignalRestClient.ResponseHandler restResponseHandler;
        JSONArray toReport;

        IAPUpdateJob(JSONArray jSONArray) {
            this.toReport = jSONArray;
        }
    }

    public static interface IdsAvailableHandler {
        public void idsAvailable(String var1, String var2);
    }

    public static final class LOG_LEVEL
    extends Enum<LOG_LEVEL> {
        private static final /* synthetic */ LOG_LEVEL[] $VALUES;
        public static final /* enum */ LOG_LEVEL DEBUG;
        public static final /* enum */ LOG_LEVEL ERROR;
        public static final /* enum */ LOG_LEVEL FATAL;
        public static final /* enum */ LOG_LEVEL INFO;
        public static final /* enum */ LOG_LEVEL NONE;
        public static final /* enum */ LOG_LEVEL VERBOSE;
        public static final /* enum */ LOG_LEVEL WARN;

        static {
            NONE = new LOG_LEVEL();
            FATAL = new LOG_LEVEL();
            ERROR = new LOG_LEVEL();
            WARN = new LOG_LEVEL();
            INFO = new LOG_LEVEL();
            DEBUG = new LOG_LEVEL();
            VERBOSE = new LOG_LEVEL();
            LOG_LEVEL[] arrlOG_LEVEL = new LOG_LEVEL[]{NONE, FATAL, ERROR, WARN, INFO, DEBUG, VERBOSE};
            $VALUES = arrlOG_LEVEL;
        }

        public static LOG_LEVEL valueOf(String string2) {
            return (LOG_LEVEL)Enum.valueOf(LOG_LEVEL.class, (String)string2);
        }

        public static LOG_LEVEL[] values() {
            return (LOG_LEVEL[])$VALUES.clone();
        }
    }

    public static interface NotificationOpenedHandler {
        public void notificationOpened(OSNotificationOpenResult var1);
    }

    public static interface NotificationReceivedHandler {
        public void notificationReceived(OSNotification var1);
    }

    public static final class OSInFocusDisplayOption
    extends Enum<OSInFocusDisplayOption> {
        private static final /* synthetic */ OSInFocusDisplayOption[] $VALUES;
        public static final /* enum */ OSInFocusDisplayOption InAppAlert;
        public static final /* enum */ OSInFocusDisplayOption None;
        public static final /* enum */ OSInFocusDisplayOption Notification;

        static {
            None = new OSInFocusDisplayOption();
            InAppAlert = new OSInFocusDisplayOption();
            Notification = new OSInFocusDisplayOption();
            OSInFocusDisplayOption[] arroSInFocusDisplayOption = new OSInFocusDisplayOption[]{None, InAppAlert, Notification};
            $VALUES = arroSInFocusDisplayOption;
        }

        public static OSInFocusDisplayOption valueOf(String string2) {
            return (OSInFocusDisplayOption)Enum.valueOf(OSInFocusDisplayOption.class, (String)string2);
        }

        public static OSInFocusDisplayOption[] values() {
            return (OSInFocusDisplayOption[])$VALUES.clone();
        }
    }

    public static class SendTagsError {
        private int code;
        private String message;

        SendTagsError(int n2, String string2) {
            this.message = string2;
            this.code = n2;
        }
    }

}

