/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.opengl.GLSurfaceView
 *  com.tapjoy.internal.du
 *  java.lang.Class
 *  java.lang.Deprecated
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  java.lang.UnsatisfiedLinkError
 *  java.util.Hashtable
 *  java.util.Map
 *  java.util.Set
 */
package com.tapjoy;

import android.app.Activity;
import android.content.Context;
import android.opengl.GLSurfaceView;
import com.tapjoy.TJAwardCurrencyListener;
import com.tapjoy.TJConnectListener;
import com.tapjoy.TJEarnedCurrencyListener;
import com.tapjoy.TJGetCurrencyBalanceListener;
import com.tapjoy.TJPlacement;
import com.tapjoy.TJPlacementListener;
import com.tapjoy.TJSetUserIDListener;
import com.tapjoy.TJSpendCurrencyListener;
import com.tapjoy.TJVideoListener;
import com.tapjoy.internal.du;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

public final class Tapjoy {
    public static final String INTENT_EXTRA_PUSH_PAYLOAD = "com.tapjoy.PUSH_PAYLOAD";

    public static void actionComplete(String string) {
        du.a().e(string);
    }

    public static void addUserTag(String string) {
        du.a().c(string);
    }

    public static void awardCurrency(int n2, TJAwardCurrencyListener tJAwardCurrencyListener) {
        du.a().a(n2, tJAwardCurrencyListener);
    }

    public static void clearUserTags() {
        du.a().g();
    }

    public static boolean connect(Context context, String string) {
        return du.a().a(context, string);
    }

    public static boolean connect(Context context, String string, Hashtable hashtable) {
        return du.a().a(context, string, hashtable, null);
    }

    public static boolean connect(Context context, String string, Hashtable hashtable, TJConnectListener tJConnectListener) {
        Class<Tapjoy> class_ = Tapjoy.class;
        synchronized (Tapjoy.class) {
            boolean bl = du.a().a(context, string, hashtable, tJConnectListener);
            // ** MonitorExit[var6_4] (shouldn't be in output)
            return bl;
        }
    }

    public static void endSession() {
        du.a().e();
    }

    public static void getCurrencyBalance(TJGetCurrencyBalanceListener tJGetCurrencyBalanceListener) {
        du.a().a(tJGetCurrencyBalanceListener);
    }

    @Deprecated
    public static float getCurrencyMultiplier() {
        return du.a().c();
    }

    public static TJPlacement getPlacement(String string, TJPlacementListener tJPlacementListener) {
        return du.a().a(string, tJPlacementListener);
    }

    public static String getSupportURL() {
        return du.a().g(null);
    }

    public static String getSupportURL(String string) {
        return du.a().g(string);
    }

    public static Set getUserTags() {
        return du.a().f();
    }

    public static String getVersion() {
        return du.a().b();
    }

    public static boolean isConnected() {
        return du.a().i();
    }

    public static boolean isPushNotificationDisabled() {
        return du.a().h();
    }

    public static void loadSharedLibrary() {
        try {
            System.loadLibrary((String)"tapjoy");
        }
        catch (UnsatisfiedLinkError unsatisfiedLinkError) {}
    }

    public static void onActivityStart(Activity activity) {
        du.a().b(activity);
    }

    public static void onActivityStop(Activity activity) {
        du.a().c(activity);
    }

    public static void removeUserTag(String string) {
        du.a().d(string);
    }

    public static void setActivity(Activity activity) {
        du.a().a(activity);
    }

    public static void setAppDataVersion(String string) {
        du.a().b(string);
    }

    @Deprecated
    public static void setCurrencyMultiplier(float f2) {
        du.a().a(f2);
    }

    public static void setDebugEnabled(boolean bl) {
        du.a().a(bl);
    }

    public static void setEarnedCurrencyListener(TJEarnedCurrencyListener tJEarnedCurrencyListener) {
        du.a().a(tJEarnedCurrencyListener);
    }

    public static void setGLSurfaceView(GLSurfaceView gLSurfaceView) {
        du.a().a(gLSurfaceView);
    }

    public static void setGcmSender(String string) {
        du.a().f(string);
    }

    public static void setPushNotificationDisabled(boolean bl) {
        du.a().b(bl);
    }

    public static void setUserCohortVariable(int n2, String string) {
        du.a().a(n2, string);
    }

    public static void setUserConsent(String string) {
        du.a().h(string);
    }

    public static void setUserFriendCount(int n2) {
        du.a().b(n2);
    }

    public static void setUserID(String string) {
        Tapjoy.setUserID(string, null);
    }

    public static void setUserID(String string, TJSetUserIDListener tJSetUserIDListener) {
        du.a().a(string, tJSetUserIDListener);
    }

    public static void setUserLevel(int n2) {
        du.a().a(n2);
    }

    public static void setUserTags(Set set) {
        du.a().a(set);
    }

    public static void setVideoListener(TJVideoListener tJVideoListener) {
        du.a().a(tJVideoListener);
    }

    public static void spendCurrency(int n2, TJSpendCurrencyListener tJSpendCurrencyListener) {
        du.a().a(n2, tJSpendCurrencyListener);
    }

    public static void startSession() {
        du.a().d();
    }

    public static void subjectToGDPR(boolean bl) {
        du.a().c(bl);
    }

    public static void trackEvent(String string) {
        du.a().a(string);
    }

    public static void trackEvent(String string, long l2) {
        du.a().a(string, l2);
    }

    public static void trackEvent(String string, String string2, long l2) {
        du.a().a(string, string2, l2);
    }

    public static void trackEvent(String string, String string2, String string3, String string4) {
        du.a().b(string, string2, string3, string4);
    }

    public static void trackEvent(String string, String string2, String string3, String string4, long l2) {
        du.a().a(string, string2, string3, string4, l2);
    }

    public static void trackEvent(String string, String string2, String string3, String string4, String string5, long l2) {
        du.a().a(string, string2, string3, string4, string5, l2);
    }

    public static void trackEvent(String string, String string2, String string3, String string4, String string5, long l2, String string6, long l3) {
        du.a().a(string, string2, string3, string4, string5, l2, string6, l3);
    }

    public static void trackEvent(String string, String string2, String string3, String string4, String string5, long l2, String string6, long l3, String string7, long l4) {
        du.a().a(string, string2, string3, string4, string5, l2, string6, l3, string7, l4);
    }

    public static void trackEvent(String string, String string2, String string3, String string4, Map map) {
        du.a().a(string, string2, string3, string4, map);
    }

    @Deprecated
    public static void trackPurchase(String string, String string2) {
        du.a().a(string, string2);
    }

    public static void trackPurchase(String string, String string2, double d2, String string3) {
        du.a().a(string, string2, d2, string3);
    }

    public static void trackPurchase(String string, String string2, String string3, String string4) {
        du.a().a(string, string2, string3, string4);
    }
}

