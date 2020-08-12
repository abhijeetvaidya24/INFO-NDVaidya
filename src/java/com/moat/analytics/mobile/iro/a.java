/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Application
 *  android.app.Application$ActivityLifecycleCallbacks
 *  android.os.Bundle
 *  com.moat.analytics.mobile.iro.j
 *  com.moat.analytics.mobile.iro.k
 *  com.moat.analytics.mobile.iro.o
 *  com.moat.analytics.mobile.iro.t
 *  com.moat.analytics.mobile.iro.t$c
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.ref.WeakReference
 */
package com.moat.analytics.mobile.iro;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.moat.analytics.mobile.iro.MoatAnalytics;
import com.moat.analytics.mobile.iro.b;
import com.moat.analytics.mobile.iro.e;
import com.moat.analytics.mobile.iro.j;
import com.moat.analytics.mobile.iro.k;
import com.moat.analytics.mobile.iro.o;
import com.moat.analytics.mobile.iro.t;
import java.lang.ref.WeakReference;

final class a {
    static WeakReference<Activity> \u02ca;
    private static boolean \u02cb;
    private static boolean \u02ce;
    private static Application \u02cf;
    private static int \u0971;

    a() {
    }

    static void \u02ca(Application application) {
        \u02cf = application;
        if (!\u02cb) {
            \u02cb = true;
            \u02cf.registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)new c());
        }
    }

    static Application \u02ce() {
        return \u02cf;
    }

    static /* synthetic */ boolean \u02ce(Activity activity) {
        WeakReference<Activity> weakReference = \u02ca;
        return weakReference != null && weakReference.get() == activity;
    }

    static final class c
    implements Application.ActivityLifecycleCallbacks {
        c() {
        }

        private static void \u02cb(boolean bl2) {
            if (bl2) {
                b.\u02cf(3, "ActivityState", null, "App became visible");
                if (t.\u02cb().\u02cb == t.c.\u0971 && !((j)MoatAnalytics.getInstance()).\u02cf) {
                    k.\u02ce().\u02cb();
                    return;
                }
            } else {
                b.\u02cf(3, "ActivityState", null, "App became invisible");
                if (t.\u02cb().\u02cb == t.c.\u0971 && !((j)MoatAnalytics.getInstance()).\u02cf) {
                    k.\u02ce().\u02ca();
                }
            }
        }

        public final void onActivityCreated(Activity activity, Bundle bundle) {
            \u0971 = 1;
        }

        public final void onActivityDestroyed(Activity activity) {
            try {
                if (\u0971 != 3 && \u0971 != 5) {
                    if (\u02ce) {
                        c.\u02cb(false);
                    }
                    \u02ce = false;
                }
                \u0971 = 6;
                StringBuilder stringBuilder = new StringBuilder("Activity destroyed: ");
                stringBuilder.append((Object)activity.getClass());
                stringBuilder.append("@");
                stringBuilder.append(activity.hashCode());
                b.\u02cf(3, "ActivityState", this, stringBuilder.toString());
                if (a.\u02ce(activity)) {
                    a.\u02ca = new WeakReference(null);
                }
                return;
            }
            catch (Exception exception) {
                o.\u0971((Exception)exception);
                return;
            }
        }

        public final void onActivityPaused(Activity activity) {
            try {
                \u0971 = 4;
                if (a.\u02ce(activity)) {
                    a.\u02ca = new WeakReference(null);
                }
                StringBuilder stringBuilder = new StringBuilder("Activity paused: ");
                stringBuilder.append((Object)activity.getClass());
                stringBuilder.append("@");
                stringBuilder.append(activity.hashCode());
                b.\u02cf(3, "ActivityState", this, stringBuilder.toString());
                return;
            }
            catch (Exception exception) {
                o.\u0971((Exception)exception);
                return;
            }
        }

        public final void onActivityResumed(Activity activity) {
            try {
                a.\u02ca = new WeakReference((Object)activity);
                \u0971 = 3;
                t.\u02cb().\u02cf();
                StringBuilder stringBuilder = new StringBuilder("Activity resumed: ");
                stringBuilder.append((Object)activity.getClass());
                stringBuilder.append("@");
                stringBuilder.append(activity.hashCode());
                b.\u02cf(3, "ActivityState", this, stringBuilder.toString());
                if (((j)MoatAnalytics.getInstance()).\u02ce) {
                    e.\u02ca(activity);
                }
                return;
            }
            catch (Exception exception) {
                o.\u0971((Exception)exception);
                return;
            }
        }

        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public final void onActivityStarted(Activity activity) {
            try {
                a.\u02ca = new WeakReference((Object)activity);
                \u0971 = 2;
                if (!\u02ce) {
                    c.\u02cb(true);
                }
                \u02ce = true;
                StringBuilder stringBuilder = new StringBuilder("Activity started: ");
                stringBuilder.append((Object)activity.getClass());
                stringBuilder.append("@");
                stringBuilder.append(activity.hashCode());
                b.\u02cf(3, "ActivityState", this, stringBuilder.toString());
                return;
            }
            catch (Exception exception) {
                o.\u0971((Exception)exception);
                return;
            }
        }

        public final void onActivityStopped(Activity activity) {
            try {
                if (\u0971 != 3) {
                    \u02ce = false;
                    c.\u02cb(false);
                }
                \u0971 = 5;
                if (a.\u02ce(activity)) {
                    a.\u02ca = new WeakReference(null);
                }
                StringBuilder stringBuilder = new StringBuilder("Activity stopped: ");
                stringBuilder.append((Object)activity.getClass());
                stringBuilder.append("@");
                stringBuilder.append(activity.hashCode());
                b.\u02cf(3, "ActivityState", this, stringBuilder.toString());
                return;
            }
            catch (Exception exception) {
                o.\u0971((Exception)exception);
                return;
            }
        }
    }

}

