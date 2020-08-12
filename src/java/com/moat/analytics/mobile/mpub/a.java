/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Application
 *  android.app.Application$ActivityLifecycleCallbacks
 *  android.os.Bundle
 *  com.moat.analytics.mobile.mpub.k
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.ref.WeakReference
 */
package com.moat.analytics.mobile.mpub;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.moat.analytics.mobile.mpub.MoatAnalytics;
import com.moat.analytics.mobile.mpub.f;
import com.moat.analytics.mobile.mpub.k;
import com.moat.analytics.mobile.mpub.m;
import com.moat.analytics.mobile.mpub.o;
import com.moat.analytics.mobile.mpub.p;
import com.moat.analytics.mobile.mpub.w;
import java.lang.ref.WeakReference;

class a {
    static WeakReference<Activity> a;
    private static boolean b;
    private static Application c;
    private static int d;
    private static boolean e;

    a() {
    }

    static Application a() {
        return c;
    }

    static void a(Application application) {
        c = application;
        if (!b) {
            b = true;
            c.registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)new a());
        }
    }

    private static boolean b(Activity activity) {
        WeakReference<Activity> weakReference = a;
        return weakReference != null && weakReference.get() == activity;
    }

    private static class a
    implements Application.ActivityLifecycleCallbacks {
        a() {
        }

        private static void a(boolean bl2) {
            if (bl2) {
                p.a(3, "ActivityState", null, "App became visible");
                if (w.a().a == w.d.b && !((k)MoatAnalytics.getInstance()).c) {
                    o.a().c();
                    return;
                }
            } else {
                p.a(3, "ActivityState", null, "App became invisible");
                if (w.a().a == w.d.b && !((k)MoatAnalytics.getInstance()).c) {
                    o.a().d();
                }
            }
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
            d = 1;
        }

        public void onActivityDestroyed(Activity activity) {
            try {
                if (d != 3 && d != 5) {
                    if (e) {
                        a.a(false);
                    }
                    e = false;
                }
                d = 6;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Activity destroyed: ");
                stringBuilder.append((Object)activity.getClass());
                stringBuilder.append("@");
                stringBuilder.append(activity.hashCode());
                p.a(3, "ActivityState", this, stringBuilder.toString());
                if (a.b(activity)) {
                    a.a = new WeakReference(null);
                    return;
                }
            }
            catch (Exception exception) {
                m.a(exception);
            }
        }

        public void onActivityPaused(Activity activity) {
            try {
                d = 4;
                if (a.b(activity)) {
                    a.a = new WeakReference(null);
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Activity paused: ");
                stringBuilder.append((Object)activity.getClass());
                stringBuilder.append("@");
                stringBuilder.append(activity.hashCode());
                p.a(3, "ActivityState", this, stringBuilder.toString());
                return;
            }
            catch (Exception exception) {
                m.a(exception);
                return;
            }
        }

        public void onActivityResumed(Activity activity) {
            try {
                a.a = new WeakReference((Object)activity);
                d = 3;
                w.a().b();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Activity resumed: ");
                stringBuilder.append((Object)activity.getClass());
                stringBuilder.append("@");
                stringBuilder.append(activity.hashCode());
                p.a(3, "ActivityState", this, stringBuilder.toString());
                if (((k)MoatAnalytics.getInstance()).b) {
                    f.a(activity);
                    return;
                }
            }
            catch (Exception exception) {
                m.a(exception);
            }
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
            try {
                a.a = new WeakReference((Object)activity);
                d = 2;
                if (!e) {
                    a.a(true);
                }
                e = true;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Activity started: ");
                stringBuilder.append((Object)activity.getClass());
                stringBuilder.append("@");
                stringBuilder.append(activity.hashCode());
                p.a(3, "ActivityState", this, stringBuilder.toString());
                return;
            }
            catch (Exception exception) {
                m.a(exception);
                return;
            }
        }

        public void onActivityStopped(Activity activity) {
            try {
                if (d != 3) {
                    e = false;
                    a.a(false);
                }
                d = 5;
                if (a.b(activity)) {
                    a.a = new WeakReference(null);
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Activity stopped: ");
                stringBuilder.append((Object)activity.getClass());
                stringBuilder.append("@");
                stringBuilder.append(activity.hashCode());
                p.a(3, "ActivityState", this, stringBuilder.toString());
                return;
            }
            catch (Exception exception) {
                m.a(exception);
                return;
            }
        }
    }

}

