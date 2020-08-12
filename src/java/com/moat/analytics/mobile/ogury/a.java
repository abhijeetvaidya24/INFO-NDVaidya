/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Application
 *  android.app.Application$ActivityLifecycleCallbacks
 *  android.os.Bundle
 *  com.moat.analytics.mobile.ogury.e
 *  com.moat.analytics.mobile.ogury.i
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.ref.WeakReference
 */
package com.moat.analytics.mobile.ogury;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.moat.analytics.mobile.ogury.MoatAnalytics;
import com.moat.analytics.mobile.ogury.b;
import com.moat.analytics.mobile.ogury.e;
import com.moat.analytics.mobile.ogury.i;
import com.moat.analytics.mobile.ogury.l;
import com.moat.analytics.mobile.ogury.m;
import com.moat.analytics.mobile.ogury.q;
import java.lang.ref.WeakReference;

final class a {
    private static Application \u02ca;
    private static boolean \u02cb;
    static WeakReference<Activity> \u02ce;
    private static int \u02cf;
    private static boolean \u0971;

    a() {
    }

    static void \u02cb(Application application) {
        \u02ca = application;
        if (!\u02cb) {
            \u02cb = true;
            \u02ca.registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)new a());
        }
    }

    static Application \u02cf() {
        return \u02ca;
    }

    static /* synthetic */ boolean \u0971(Activity activity) {
        WeakReference<Activity> weakReference = \u02ce;
        return weakReference != null && weakReference.get() == activity;
    }

    static final class a
    implements Application.ActivityLifecycleCallbacks {
        a() {
        }

        private static void \u02ce(boolean bl2) {
            if (bl2) {
                e.1.\u02cb(3, "ActivityState", null, "App became visible");
                if (q.\u02ca().\u0971 == q.e.\u02ce && !((i)MoatAnalytics.getInstance()).\u02cb) {
                    m.\u02ce().\u02ca();
                    return;
                }
            } else {
                e.1.\u02cb(3, "ActivityState", null, "App became invisible");
                if (q.\u02ca().\u0971 == q.e.\u02ce && !((i)MoatAnalytics.getInstance()).\u02cb) {
                    m.\u02ce().\u02cb();
                }
            }
        }

        public final void onActivityCreated(Activity activity, Bundle bundle) {
            \u02cf = 1;
        }

        public final void onActivityDestroyed(Activity activity) {
            try {
                if (\u02cf != 3 && \u02cf != 5) {
                    if (\u0971) {
                        a.\u02ce(false);
                    }
                    \u0971 = false;
                }
                \u02cf = 6;
                StringBuilder stringBuilder = new StringBuilder("Activity destroyed: ");
                stringBuilder.append((Object)activity.getClass());
                stringBuilder.append("@");
                stringBuilder.append(activity.hashCode());
                e.1.\u02cb(3, "ActivityState", this, stringBuilder.toString());
                if (a.\u0971(activity)) {
                    a.\u02ce = new WeakReference(null);
                }
                return;
            }
            catch (Exception exception) {
                l.\u0971(exception);
                return;
            }
        }

        public final void onActivityPaused(Activity activity) {
            try {
                \u02cf = 4;
                if (a.\u0971(activity)) {
                    a.\u02ce = new WeakReference(null);
                }
                StringBuilder stringBuilder = new StringBuilder("Activity paused: ");
                stringBuilder.append((Object)activity.getClass());
                stringBuilder.append("@");
                stringBuilder.append(activity.hashCode());
                e.1.\u02cb(3, "ActivityState", this, stringBuilder.toString());
                return;
            }
            catch (Exception exception) {
                l.\u0971(exception);
                return;
            }
        }

        public final void onActivityResumed(Activity activity) {
            try {
                a.\u02ce = new WeakReference((Object)activity);
                \u02cf = 3;
                q.\u02ca().\u0971();
                StringBuilder stringBuilder = new StringBuilder("Activity resumed: ");
                stringBuilder.append((Object)activity.getClass());
                stringBuilder.append("@");
                stringBuilder.append(activity.hashCode());
                e.1.\u02cb(3, "ActivityState", this, stringBuilder.toString());
                if (((i)MoatAnalytics.getInstance()).\u0971) {
                    b.\u02cb(activity);
                }
                return;
            }
            catch (Exception exception) {
                l.\u0971(exception);
                return;
            }
        }

        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public final void onActivityStarted(Activity activity) {
            try {
                a.\u02ce = new WeakReference((Object)activity);
                \u02cf = 2;
                if (!\u0971) {
                    a.\u02ce(true);
                }
                \u0971 = true;
                StringBuilder stringBuilder = new StringBuilder("Activity started: ");
                stringBuilder.append((Object)activity.getClass());
                stringBuilder.append("@");
                stringBuilder.append(activity.hashCode());
                e.1.\u02cb(3, "ActivityState", this, stringBuilder.toString());
                return;
            }
            catch (Exception exception) {
                l.\u0971(exception);
                return;
            }
        }

        public final void onActivityStopped(Activity activity) {
            try {
                if (\u02cf != 3) {
                    \u0971 = false;
                    a.\u02ce(false);
                }
                \u02cf = 5;
                if (a.\u0971(activity)) {
                    a.\u02ce = new WeakReference(null);
                }
                StringBuilder stringBuilder = new StringBuilder("Activity stopped: ");
                stringBuilder.append((Object)activity.getClass());
                stringBuilder.append("@");
                stringBuilder.append(activity.hashCode());
                e.1.\u02cb(3, "ActivityState", this, stringBuilder.toString());
                return;
            }
            catch (Exception exception) {
                l.\u0971(exception);
                return;
            }
        }
    }

}

