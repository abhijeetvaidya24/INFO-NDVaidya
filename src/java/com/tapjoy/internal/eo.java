/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Application
 *  android.app.Application$ActivityLifecycleCallbacks
 *  android.content.Context
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.util.Log
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Throwable
 *  java.lang.reflect.Method
 *  java.util.HashSet
 *  java.util.concurrent.CountDownLatch
 */
package com.tapjoy.internal;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import com.tapjoy.TapjoyLog;
import com.tapjoy.TapjoyUtil;
import com.tapjoy.internal.d;
import com.tapjoy.internal.fq;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.concurrent.CountDownLatch;

public final class eo {
    private static final eo a = new eo();
    private Application b;
    private Application.ActivityLifecycleCallbacks c;
    private final HashSet d = new HashSet();

    static /* synthetic */ Application a(eo eo2, Application application) {
        eo2.b = application;
        return application;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void a() {
        if (Build.VERSION.SDK_INT < 14) {
            return;
        }
        eo eo2 = a;
        if (eo2.b == null) {
            return;
        }
        eo eo3 = eo2;
        synchronized (eo3) {
            if (eo2.c != null) {
                eo2.b.unregisterActivityLifecycleCallbacks(eo2.c);
                eo2.c = null;
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void a(Context context) {
        if (Build.VERSION.SDK_INT < 14) {
            return;
        }
        if (context == null) {
            return;
        }
        eo eo2 = a;
        Context context2 = context.getApplicationContext();
        if (eo2.b == null) {
            try {
                if (context2 instanceof Application) {
                    eo2.b = (Application)context2;
                } else {
                    final CountDownLatch countDownLatch = new CountDownLatch(1);
                    TapjoyUtil.runOnMainThread(new Runnable(){

                        /*
                         * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
                         * Unable to fully structure code
                         * Enabled aggressive block sorting
                         * Enabled unnecessary exception pruning
                         * Enabled aggressive exception aggregation
                         * Lifted jumps to return sites
                         */
                        public final void run() {
                            eo.a(eo.this, eo.b());
lbl3: // 2 sources:
                            do {
                                countDownLatch.countDown();
                                return;
                                break;
                            } while (true);
                            {
                                catch (Throwable var2_1) {
                                }
                                catch (Exception var1_2) {}
                                {
                                    TapjoyLog.w("Tapjoy.ActivityTracker", Log.getStackTraceString((Throwable)var1_2));
                                    ** continue;
                                }
                            }
                            countDownLatch.countDown();
                            throw var2_1;
                        }
                    });
                    countDownLatch.await();
                }
            }
            catch (Exception exception) {
                TapjoyLog.w("Tapjoy.ActivityTracker", Log.getStackTraceString((Throwable)exception));
            }
            if (eo2.b == null) {
                return;
            }
        }
        eo eo3 = eo2;
        synchronized (eo3) {
            if (eo2.c == null) {
                Activity activity = d.c();
                if (activity != null) {
                    eo2.d.add((Object)eo.b(activity));
                }
                eo2.c = new Application.ActivityLifecycleCallbacks(){

                    public final void onActivityCreated(Activity activity, Bundle bundle) {
                    }

                    public final void onActivityDestroyed(Activity activity) {
                    }

                    public final void onActivityPaused(Activity activity) {
                    }

                    public final void onActivityResumed(Activity activity) {
                    }

                    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                    }

                    public final void onActivityStarted(Activity activity) {
                        String string2 = eo.b(activity);
                        d.add((Object)string2);
                        if (d.size() == 1) {
                            fq.a();
                        }
                        d.a(activity);
                    }

                    public final void onActivityStopped(Activity activity) {
                        String string2 = eo.b(activity);
                        d.remove((Object)string2);
                        if (d.size() <= 0) {
                            fq.b();
                        }
                    }
                };
                eo2.b.registerActivityLifecycleCallbacks(eo2.c);
                fq.a();
            }
            return;
        }
    }

    static /* synthetic */ Application b() {
        return (Application)Class.forName((String)"android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null);
    }

    private static String b(Activity activity) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(activity.getClass().getName());
        stringBuilder.append("@");
        stringBuilder.append(System.identityHashCode((Object)activity));
        return stringBuilder.toString();
    }

}

