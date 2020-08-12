/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Application
 *  android.app.Application$ActivityLifecycleCallbacks
 *  android.os.Bundle
 *  com.moat.analytics.mobile.cha.f
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.ref.WeakReference
 */
package com.moat.analytics.mobile.cha;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.moat.analytics.mobile.cha.MoatAnalytics;
import com.moat.analytics.mobile.cha.e;
import com.moat.analytics.mobile.cha.f;
import com.moat.analytics.mobile.cha.n;
import com.moat.analytics.mobile.cha.o;
import com.moat.analytics.mobile.cha.t;
import java.lang.ref.WeakReference;

final class c {
    private static boolean \u02ca;
    private static Application \u02cb;
    private static boolean \u02ce;
    static WeakReference<Activity> \u02cf;
    private static int \u0971;

    c() {
    }

    static /* synthetic */ boolean \u02ca(Activity activity) {
        WeakReference<Activity> weakReference = \u02cf;
        return weakReference != null && weakReference.get() == activity;
    }

    static Application \u02cf() {
        return \u02cb;
    }

    static void \u0971(Application application) {
        \u02cb = application;
        if (!\u02ce) {
            \u02ce = true;
            \u02cb.registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)new a());
        }
    }

    static final class a
    implements Application.ActivityLifecycleCallbacks {
        a() {
        }

        private static void \u0971(boolean bl2) {
            if (bl2) {
                com.moat.analytics.mobile.cha.a.\u02cf(3, "ActivityState", null, "App became visible");
                if (t.\u02cf().\u02ce == t.a.\u02ce && !((f)MoatAnalytics.getInstance()).\u02cb) {
                    n.\u02cf().\u02cb();
                    return;
                }
            } else {
                com.moat.analytics.mobile.cha.a.\u02cf(3, "ActivityState", null, "App became invisible");
                if (t.\u02cf().\u02ce == t.a.\u02ce && !((f)MoatAnalytics.getInstance()).\u02cb) {
                    n.\u02cf().\u0971();
                }
            }
        }

        public final void onActivityCreated(Activity activity, Bundle bundle) {
            \u0971 = 1;
        }

        public final void onActivityDestroyed(Activity activity) {
            try {
                if (\u0971 != 3 && \u0971 != 5) {
                    if (\u02ca) {
                        a.\u0971(false);
                    }
                    \u02ca = false;
                }
                \u0971 = 6;
                StringBuilder stringBuilder = new StringBuilder("Activity destroyed: ");
                stringBuilder.append((Object)activity.getClass());
                stringBuilder.append("@");
                stringBuilder.append(activity.hashCode());
                com.moat.analytics.mobile.cha.a.\u02cf(3, "ActivityState", this, stringBuilder.toString());
                if (c.\u02ca(activity)) {
                    c.\u02cf = new WeakReference(null);
                }
                return;
            }
            catch (Exception exception) {
                o.\u02ce(exception);
                return;
            }
        }

        public final void onActivityPaused(Activity activity) {
            try {
                \u0971 = 4;
                if (c.\u02ca(activity)) {
                    c.\u02cf = new WeakReference(null);
                }
                StringBuilder stringBuilder = new StringBuilder("Activity paused: ");
                stringBuilder.append((Object)activity.getClass());
                stringBuilder.append("@");
                stringBuilder.append(activity.hashCode());
                com.moat.analytics.mobile.cha.a.\u02cf(3, "ActivityState", this, stringBuilder.toString());
                return;
            }
            catch (Exception exception) {
                o.\u02ce(exception);
                return;
            }
        }

        public final void onActivityResumed(Activity activity) {
            try {
                c.\u02cf = new WeakReference((Object)activity);
                \u0971 = 3;
                t.\u02cf().\u02ce();
                StringBuilder stringBuilder = new StringBuilder("Activity resumed: ");
                stringBuilder.append((Object)activity.getClass());
                stringBuilder.append("@");
                stringBuilder.append(activity.hashCode());
                com.moat.analytics.mobile.cha.a.\u02cf(3, "ActivityState", this, stringBuilder.toString());
                if (((f)MoatAnalytics.getInstance()).\u02cf) {
                    e.\u02ce(activity);
                }
                return;
            }
            catch (Exception exception) {
                o.\u02ce(exception);
                return;
            }
        }

        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public final void onActivityStarted(Activity activity) {
            try {
                c.\u02cf = new WeakReference((Object)activity);
                \u0971 = 2;
                if (!\u02ca) {
                    a.\u0971(true);
                }
                \u02ca = true;
                StringBuilder stringBuilder = new StringBuilder("Activity started: ");
                stringBuilder.append((Object)activity.getClass());
                stringBuilder.append("@");
                stringBuilder.append(activity.hashCode());
                com.moat.analytics.mobile.cha.a.\u02cf(3, "ActivityState", this, stringBuilder.toString());
                return;
            }
            catch (Exception exception) {
                o.\u02ce(exception);
                return;
            }
        }

        public final void onActivityStopped(Activity activity) {
            try {
                if (\u0971 != 3) {
                    \u02ca = false;
                    a.\u0971(false);
                }
                \u0971 = 5;
                if (c.\u02ca(activity)) {
                    c.\u02cf = new WeakReference(null);
                }
                StringBuilder stringBuilder = new StringBuilder("Activity stopped: ");
                stringBuilder.append((Object)activity.getClass());
                stringBuilder.append("@");
                stringBuilder.append(activity.hashCode());
                com.moat.analytics.mobile.cha.a.\u02cf(3, "ActivityState", this, stringBuilder.toString());
                return;
            }
            catch (Exception exception) {
                o.\u02ce(exception);
                return;
            }
        }
    }

}

