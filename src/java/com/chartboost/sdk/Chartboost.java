/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.app.Activity
 *  android.app.Application
 *  android.app.Application$ActivityLifecycleCallbacks
 *  android.content.Context
 *  android.os.Handler
 *  com.chartboost.sdk.ChartboostDelegate
 *  com.chartboost.sdk.c
 *  com.chartboost.sdk.f
 *  com.chartboost.sdk.h
 *  com.chartboost.sdk.h$a
 *  com.chartboost.sdk.i
 *  com.chartboost.sdk.impl.aq
 *  com.chartboost.sdk.impl.c
 *  com.chartboost.sdk.impl.c$a
 *  com.chartboost.sdk.impl.e
 *  com.chartboost.sdk.impl.e$a
 *  com.chartboost.sdk.impl.f
 *  com.chartboost.sdk.impl.s
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Deprecated
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.util.concurrent.Executor
 *  java.util.concurrent.atomic.AtomicReference
 */
package com.chartboost.sdk;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Handler;
import com.chartboost.sdk.ChartboostDelegate;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Model.CBError;
import com.chartboost.sdk.a;
import com.chartboost.sdk.b;
import com.chartboost.sdk.c;
import com.chartboost.sdk.h;
import com.chartboost.sdk.i;
import com.chartboost.sdk.impl.aq;
import com.chartboost.sdk.impl.c;
import com.chartboost.sdk.impl.e;
import com.chartboost.sdk.impl.f;
import com.chartboost.sdk.impl.s;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

public class Chartboost {
    private Chartboost() {
    }

    public static void cacheInterstitial(String string2) {
        aq.a((String)"Chartboost.cacheInterstitial", (String)string2);
        h h2 = h.a();
        if (h2 != null) {
            if (!b.a()) {
                return;
            }
            if (!h.f()) {
                return;
            }
            if (s.a().a((CharSequence)string2)) {
                CBLogging.b("Chartboost", "cacheInterstitial location cannot be empty");
                Handler handler = h2.p;
                c c2 = h2.g;
                c2.getClass();
                handler.post((Runnable)new c.a(c2, 4, string2, CBError.CBImpressionError.INVALID_LOCATION));
                return;
            }
            com.chartboost.sdk.Model.e e2 = (com.chartboost.sdk.Model.e)h2.m.get();
            if (e2.y && e2.A || e2.e && e2.g) {
                e e3 = h2.f;
                e3.getClass();
                e.a a2 = new e.a(e3, 3, string2, null, null);
                h2.a.execute((Runnable)a2);
                return;
            }
            Handler handler = h2.p;
            c c3 = h2.g;
            c3.getClass();
            handler.post((Runnable)new c.a(c3, 4, string2, CBError.CBImpressionError.END_POINT_DISABLED));
        }
    }

    public static void cacheMoreApps(String string2) {
        h h2 = h.a();
        if (h2 != null) {
            if (!b.a()) {
                return;
            }
            if (!h.f()) {
                return;
            }
            h2.getClass();
            h.a a2 = new h.a(h2, 5);
            a2.b = string2;
            h2.p.postDelayed((Runnable)a2, com.chartboost.sdk.Libraries.b.c);
        }
    }

    public static void cacheRewardedVideo(String string2) {
        aq.a((String)"Chartboost.cacheRewardedVideo", (String)string2);
        h h2 = h.a();
        if (h2 != null) {
            if (!b.a()) {
                return;
            }
            if (!h.f()) {
                return;
            }
            if (s.a().a((CharSequence)string2)) {
                CBLogging.b("Chartboost", "cacheRewardedVideo location cannot be empty");
                Handler handler = h2.p;
                c c2 = h2.l;
                c2.getClass();
                handler.post((Runnable)new c.a(c2, 4, string2, CBError.CBImpressionError.INVALID_LOCATION));
                return;
            }
            com.chartboost.sdk.Model.e e2 = (com.chartboost.sdk.Model.e)h2.m.get();
            if (e2.y && e2.E || e2.e && e2.j) {
                e e3 = h2.k;
                e3.getClass();
                e.a a2 = new e.a(e3, 3, string2, null, null);
                h2.a.execute((Runnable)a2);
                return;
            }
            Handler handler = h2.p;
            c c3 = h2.l;
            c3.getClass();
            handler.post((Runnable)new c.a(c3, 4, string2, CBError.CBImpressionError.END_POINT_DISABLED));
        }
    }

    @Deprecated
    public static void closeImpression() {
    }

    private static void forwardTouchEventsAIR(boolean bl) {
        h h2 = h.a();
        if (h2 == null) {
            return;
        }
        com.chartboost.sdk.c c2 = h2.q;
        c2.getClass();
        c.c c3 = new c.c(c2, 6);
        c3.c = bl;
        h.b((Runnable)c3);
    }

    public static boolean getAutoCacheAds() {
        return i.t;
    }

    public static String getCustomId() {
        if (!b.b()) {
            return "";
        }
        return i.a;
    }

    public static a getDelegate() {
        return i.c;
    }

    public static CBLogging.Level getLoggingLevel() {
        b.b();
        return CBLogging.a;
    }

    public static String getSDKVersion() {
        return "7.2.1";
    }

    public static boolean hasInterstitial(String string2) {
        aq.a((String)"Chartboost.hasInterstitial", (String)string2);
        h h2 = h.a();
        boolean bl = false;
        if (h2 != null) {
            if (!b.a()) {
                return false;
            }
            com.chartboost.sdk.Model.a a2 = h2.f.a(string2);
            bl = false;
            if (a2 != null) {
                bl = true;
            }
        }
        return bl;
    }

    public static boolean hasMoreApps(String string2) {
        return false;
    }

    public static boolean hasRewardedVideo(String string2) {
        aq.a((String)"Chartboost.hasRewardedVideo", (String)string2);
        h h2 = h.a();
        boolean bl = false;
        if (h2 != null) {
            if (!b.a()) {
                return false;
            }
            com.chartboost.sdk.Model.a a2 = h2.k.a(string2);
            bl = false;
            if (a2 != null) {
                bl = true;
            }
        }
        return bl;
    }

    public static boolean isAnyViewVisible() {
        aq.a((String)"Chartboost.isAnyViewVisible");
        h h2 = h.a();
        return h2 != null && h2.q.e();
    }

    public static boolean isWebViewEnabled() {
        h h2 = h.a();
        return h2 == null || ((com.chartboost.sdk.Model.e)h2.m.get()).y;
        {
        }
    }

    public static boolean onBackPressed() {
        aq.a((String)"Chartboost.onBackPressed");
        h h2 = h.a();
        if (h2 == null) {
            return false;
        }
        return h2.q.j();
    }

    public static void onCreate(Activity activity) {
        aq.a((String)"Chartboost.onCreate", (Object)activity);
        h h2 = h.a();
        if (h2 == null) {
            return;
        }
        if (!i.s) {
            h2.q.b(activity);
        }
    }

    public static void onDestroy(Activity activity) {
        aq.a((String)"Chartboost.onDestroy", (Object)activity);
        h h2 = h.a();
        if (h2 == null) {
            return;
        }
        if (!i.s) {
            h2.q.j(activity);
        }
    }

    public static void onPause(Activity activity) {
        aq.a((String)"Chartboost.onPause", (Object)activity);
        h h2 = h.a();
        if (h2 == null) {
            return;
        }
        if (!i.s) {
            h2.q.g(activity);
        }
    }

    public static void onResume(Activity activity) {
        aq.a((String)"Chartboost.onResume", (Object)activity);
        h h2 = h.a();
        if (h2 == null) {
            return;
        }
        if (!i.s) {
            h2.q.f(activity);
        }
    }

    public static void onStart(Activity activity) {
        aq.a((String)"Chartboost.onStart", (Object)activity);
        h h2 = h.a();
        if (h2 == null) {
            return;
        }
        if (!i.s) {
            h2.q.d(activity);
        }
    }

    public static void onStop(Activity activity) {
        aq.a((String)"Chartboost.onStop", (Object)activity);
        h h2 = h.a();
        if (h2 == null) {
            return;
        }
        if (!i.s) {
            h2.q.h(activity);
        }
    }

    public static void restrictDataCollection(Context context, boolean bl) {
        h.a((Context)context, (boolean)bl);
    }

    @TargetApi(value=14)
    public static void setActivityCallbacks(boolean bl) {
        Application.ActivityLifecycleCallbacks activityLifecycleCallbacks;
        aq.a((String)"Chartboost.setActivityCallbacks", (boolean)bl);
        h h2 = h.a();
        if (h2 == null) {
            return;
        }
        Activity activity = h2.q.a();
        if (activity != null && (activityLifecycleCallbacks = h2.q.h) != null) {
            if (!i.s && bl) {
                activity.getApplication().registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
                i.s = true;
                return;
            }
            if (i.s && !bl) {
                activity.getApplication().unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
                i.s = false;
            }
        }
    }

    public static void setAutoCacheAds(boolean bl) {
        aq.a((String)"Chartboost.setAutoCacheAds", (boolean)bl);
        h h2 = h.a();
        if (h2 != null) {
            h2.getClass();
            h.a a2 = new h.a(h2, 1);
            a2.c = bl;
            h.b((Runnable)a2);
        }
    }

    public static void setChartboostWrapperVersion(String string2) {
        aq.a((String)"Chartboost.setChartboostWrapperVersion", (String)string2);
        com.chartboost.sdk.f f2 = new com.chartboost.sdk.f(5);
        f2.d = string2;
        h.b((Runnable)f2);
    }

    public static void setCustomId(String string2) {
        aq.a((String)"Chartboost.setCustomId", (String)string2);
        com.chartboost.sdk.f f2 = new com.chartboost.sdk.f(6);
        f2.e = string2;
        h.b((Runnable)f2);
    }

    public static void setDelegate(ChartboostDelegate chartboostDelegate) {
        aq.a((String)"Chartboost.setDelegate", (Object)chartboostDelegate);
        com.chartboost.sdk.f f2 = new com.chartboost.sdk.f(8);
        f2.g = chartboostDelegate;
        h.b((Runnable)f2);
    }

    public static void setFramework(CBFramework cBFramework, String string2) {
        aq.a((String)"Chartboost.setFramework");
        com.chartboost.sdk.f f2 = new com.chartboost.sdk.f(4);
        f2.b = cBFramework;
        f2.d = string2;
        h.b((Runnable)f2);
    }

    @Deprecated
    public static void setFrameworkVersion(String string2) {
        aq.a((String)"Chartboost.setFrameworkVersion", (String)string2);
        com.chartboost.sdk.f f2 = new com.chartboost.sdk.f(5);
        f2.d = string2;
        h.b((Runnable)f2);
    }

    public static void setLoggingLevel(CBLogging.Level level) {
        aq.a((String)"Chartboost.setLoggingLevel", (String)level.toString());
        com.chartboost.sdk.f f2 = new com.chartboost.sdk.f(7);
        f2.f = level;
        h.b((Runnable)f2);
    }

    public static void setMediation(CBMediation cBMediation, String string2) {
        aq.a((String)"Chartboost.setMediation");
        com.chartboost.sdk.f f2 = new com.chartboost.sdk.f(3);
        f2.c = cBMediation;
        f2.d = string2;
        h.b((Runnable)f2);
    }

    public static void setShouldDisplayLoadingViewForMoreApps(boolean bl) {
    }

    public static void setShouldHideSystemUI(Boolean bl) {
        aq.a((String)"Chartboost.setHideSystemUI", (Object)bl);
        i.g = bl;
    }

    public static void setShouldPrefetchVideoContent(boolean bl) {
        aq.a((String)"Chartboost.setShouldPrefetchVideoContent", (boolean)bl);
        h h2 = h.a();
        if (h2 != null) {
            if (!b.a()) {
                return;
            }
            h2.getClass();
            h.a a2 = new h.a(h2, 2);
            a2.d = bl;
            h.b((Runnable)a2);
        }
    }

    public static void setShouldRequestInterstitialsInFirstSession(boolean bl) {
        aq.a((String)"Chartboost.setShouldRequestInterstitialsInFirstSession", (boolean)bl);
        if (b.b()) {
            com.chartboost.sdk.f f2 = new com.chartboost.sdk.f(1);
            f2.a = bl;
            h.b((Runnable)f2);
        }
    }

    public static void showInterstitial(String string2) {
        aq.a((String)"Chartboost.showInterstitial", (String)string2);
        h h2 = h.a();
        if (h2 != null) {
            if (!b.a()) {
                return;
            }
            if (!h.f()) {
                return;
            }
            if (s.a().a((CharSequence)string2)) {
                CBLogging.b("Chartboost", "showInterstitial location cannot be empty");
                Handler handler = h2.p;
                c c2 = h2.g;
                c2.getClass();
                handler.post((Runnable)new c.a(c2, 4, string2, CBError.CBImpressionError.INVALID_LOCATION));
                return;
            }
            com.chartboost.sdk.Model.e e2 = (com.chartboost.sdk.Model.e)h2.m.get();
            if (e2.y && e2.A || e2.e && e2.g) {
                e e3 = h2.f;
                e3.getClass();
                e.a a2 = new e.a(e3, 4, string2, null, null);
                h2.a.execute((Runnable)a2);
                return;
            }
            Handler handler = h2.p;
            c c3 = h2.g;
            c3.getClass();
            handler.post((Runnable)new c.a(c3, 4, string2, CBError.CBImpressionError.END_POINT_DISABLED));
        }
    }

    private static void showInterstitialAIR(String string2, boolean bl) {
        h h2 = h.a();
        if (h2 != null) {
            if (!b.a()) {
                return;
            }
            if (!h.f()) {
                return;
            }
            com.chartboost.sdk.Model.e e2 = (com.chartboost.sdk.Model.e)h2.m.get();
            if (e2.y && e2.A || e2.e && e2.g) {
                Handler handler = h2.p;
                c c2 = h2.g;
                c2.getClass();
                handler.post((Runnable)new c.a(c2, 4, string2, CBError.CBImpressionError.INTERNAL));
                return;
            }
            i.c.didFailToLoadInterstitial(string2, CBError.CBImpressionError.END_POINT_DISABLED);
        }
    }

    public static void showMoreApps(String string2) {
        Chartboost.cacheMoreApps(string2);
    }

    private static void showMoreAppsAIR(String string2, boolean bl) {
        Chartboost.cacheMoreApps(string2);
    }

    public static void showRewardedVideo(String string2) {
        aq.a((String)"Chartboost.showRewardedVideo", (String)string2);
        h h2 = h.a();
        if (h2 != null) {
            if (!b.a()) {
                return;
            }
            if (!h.f()) {
                return;
            }
            if (s.a().a((CharSequence)string2)) {
                CBLogging.b("Chartboost", "showRewardedVideo location cannot be empty");
                Handler handler = h2.p;
                c c2 = h2.l;
                c2.getClass();
                handler.post((Runnable)new c.a(c2, 4, string2, CBError.CBImpressionError.INVALID_LOCATION));
                return;
            }
            com.chartboost.sdk.Model.e e2 = (com.chartboost.sdk.Model.e)h2.m.get();
            if (e2.y && e2.E || e2.e && e2.j) {
                e e3 = h2.k;
                e3.getClass();
                e.a a2 = new e.a(e3, 4, string2, null, null);
                h2.a.execute((Runnable)a2);
                return;
            }
            Handler handler = h2.p;
            c c3 = h2.l;
            c3.getClass();
            handler.post((Runnable)new c.a(c3, 4, string2, CBError.CBImpressionError.END_POINT_DISABLED));
        }
    }

    private static void showRewardedVideoAIR(String string2, boolean bl) {
        h h2 = h.a();
        if (h2 != null) {
            if (!b.a()) {
                return;
            }
            if (!h.f()) {
                return;
            }
            com.chartboost.sdk.Model.e e2 = (com.chartboost.sdk.Model.e)h2.m.get();
            if (e2.y && e2.E || e2.e && e2.j) {
                Handler handler = h2.p;
                c c2 = h2.g;
                c2.getClass();
                handler.post((Runnable)new c.a(c2, 4, string2, CBError.CBImpressionError.INTERNAL));
                return;
            }
            i.c.didFailToLoadRewardedVideo(string2, CBError.CBImpressionError.END_POINT_DISABLED);
        }
    }

    public static void startWithAppId(Activity activity, String string2, String string3) {
        aq.a((String)"Chartboost.startWithAppId", (Object)activity);
        com.chartboost.sdk.f f2 = new com.chartboost.sdk.f(0);
        f2.h = activity;
        f2.i = string2;
        f2.j = string3;
        h.b((Runnable)f2);
    }

    public static final class CBFramework
    extends Enum<CBFramework> {
        public static final /* enum */ CBFramework CBFrameworkAir;
        public static final /* enum */ CBFramework CBFrameworkCocoonJS;
        public static final /* enum */ CBFramework CBFrameworkCocos2dx;
        public static final /* enum */ CBFramework CBFrameworkCordova;
        public static final /* enum */ CBFramework CBFrameworkCorona;
        public static final /* enum */ CBFramework CBFrameworkGameSalad;
        public static final /* enum */ CBFramework CBFrameworkOther;
        public static final /* enum */ CBFramework CBFrameworkPrime31Unreal;
        public static final /* enum */ CBFramework CBFrameworkUnity;
        public static final /* enum */ CBFramework CBFrameworkWeeby;
        private static final /* synthetic */ CBFramework[] b;
        private final String a;

        static {
            CBFrameworkUnity = new CBFramework("Unity");
            CBFrameworkCorona = new CBFramework("Corona");
            CBFrameworkAir = new CBFramework("AIR");
            CBFrameworkGameSalad = new CBFramework("GameSalad");
            CBFrameworkCordova = new CBFramework("Cordova");
            CBFrameworkCocoonJS = new CBFramework("CocoonJS");
            CBFrameworkCocos2dx = new CBFramework("Cocos2dx");
            CBFrameworkPrime31Unreal = new CBFramework("Prime31Unreal");
            CBFrameworkWeeby = new CBFramework("Weeby");
            CBFrameworkOther = new CBFramework("Other");
            CBFramework[] arrcBFramework = new CBFramework[]{CBFrameworkUnity, CBFrameworkCorona, CBFrameworkAir, CBFrameworkGameSalad, CBFrameworkCordova, CBFrameworkCocoonJS, CBFrameworkCocos2dx, CBFrameworkPrime31Unreal, CBFrameworkWeeby, CBFrameworkOther};
            b = arrcBFramework;
        }

        private CBFramework(String string3) {
            this.a = string3;
        }

        public static CBFramework valueOf(String string2) {
            return (CBFramework)Enum.valueOf(CBFramework.class, (String)string2);
        }

        public static CBFramework[] values() {
            return (CBFramework[])b.clone();
        }

        public boolean doesWrapperUseCustomBackgroundingBehavior() {
            return this == CBFrameworkAir;
        }

        public boolean doesWrapperUseCustomShouldDisplayBehavior() {
            return this == CBFrameworkAir || this == CBFrameworkCocos2dx;
            {
            }
        }

        public String toString() {
            return this.a;
        }
    }

    public static final class CBMediation
    extends Enum<CBMediation> {
        public static final /* enum */ CBMediation CBMediationAdMarvel = new CBMediation("AdMarvel");
        public static final /* enum */ CBMediation CBMediationAdMob = new CBMediation("AdMob");
        public static final /* enum */ CBMediation CBMediationAerServ;
        public static final /* enum */ CBMediation CBMediationFuse;
        public static final /* enum */ CBMediation CBMediationFyber;
        public static final /* enum */ CBMediation CBMediationHeyZap;
        public static final /* enum */ CBMediation CBMediationHyprMX;
        public static final /* enum */ CBMediation CBMediationMoPub;
        public static final /* enum */ CBMediation CBMediationOther;
        public static final /* enum */ CBMediation CBMediationironSource;
        private static final /* synthetic */ CBMediation[] b;
        private final String a;

        static {
            CBMediationFuse = new CBMediation("Fuse");
            CBMediationFyber = new CBMediation("Fyber");
            CBMediationHeyZap = new CBMediation("HeyZap");
            CBMediationMoPub = new CBMediation("MoPub");
            CBMediationironSource = new CBMediation("ironSource");
            CBMediationHyprMX = new CBMediation("HyprMX");
            CBMediationAerServ = new CBMediation("AerServ");
            CBMediationOther = new CBMediation("Other");
            CBMediation[] arrcBMediation = new CBMediation[]{CBMediationAdMarvel, CBMediationAdMob, CBMediationFuse, CBMediationFyber, CBMediationHeyZap, CBMediationMoPub, CBMediationironSource, CBMediationHyprMX, CBMediationAerServ, CBMediationOther};
            b = arrcBMediation;
        }

        private CBMediation(String string3) {
            this.a = string3;
        }

        public static CBMediation valueOf(String string2) {
            return (CBMediation)Enum.valueOf(CBMediation.class, (String)string2);
        }

        public static CBMediation[] values() {
            return (CBMediation[])b.clone();
        }

        public String toString() {
            return this.a;
        }
    }

}

