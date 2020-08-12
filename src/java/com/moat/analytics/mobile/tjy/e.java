/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Application
 *  android.app.Application$ActivityLifecycleCallbacks
 *  android.os.Bundle
 *  android.util.Log
 *  com.moat.analytics.mobile.tjy.c
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.moat.analytics.mobile.tjy;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;
import com.moat.analytics.mobile.tjy.base.exception.a;
import com.moat.analytics.mobile.tjy.c;
import com.moat.analytics.mobile.tjy.d;

class e
implements Application.ActivityLifecycleCallbacks {
    final /* synthetic */ c a;

    private e(c c2) {
        this.a = c2;
    }

    /* synthetic */ e(c c2, d d2) {
        this(c2);
    }

    private boolean a(Activity activity) {
        Activity activity2 = (Activity)c.c((c)this.a).get();
        return activity2 != null && activity2.equals((Object)activity);
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityDestroyed(Activity activity) {
        try {
            if (c.a((c)this.a).b()) {
                StringBuilder stringBuilder = new StringBuilder("Activity destroyed: ");
                stringBuilder.append((Object)activity.getClass());
                stringBuilder.append("@");
                stringBuilder.append(activity.hashCode());
                Log.d((String)"MoatActivityState", (String)stringBuilder.toString());
            }
            if (this.a(activity)) {
                c.a((c)this.a, (boolean)false);
                ((Application)c.b((c)this.a).get()).unregisterActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)this);
            }
            return;
        }
        catch (Exception exception) {
            a.a(exception);
            return;
        }
    }

    public void onActivityPaused(Activity activity) {
        if (c.a((c)this.a).b()) {
            StringBuilder stringBuilder = new StringBuilder("Activity paused: ");
            stringBuilder.append((Object)activity.getClass());
            stringBuilder.append("@");
            stringBuilder.append(activity.hashCode());
            Log.d((String)"MoatActivityState", (String)stringBuilder.toString());
        }
        if (this.a(activity)) {
            c.a((c)this.a, (boolean)true);
        }
    }

    public void onActivityResumed(Activity activity) {
        if (c.a((c)this.a).b()) {
            StringBuilder stringBuilder = new StringBuilder("Activity resumed: ");
            stringBuilder.append((Object)activity.getClass());
            stringBuilder.append("@");
            stringBuilder.append(activity.hashCode());
            Log.d((String)"MoatActivityState", (String)stringBuilder.toString());
        }
        if (this.a(activity)) {
            c.a((c)this.a, (boolean)false);
        }
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
        if (c.a((c)this.a).b()) {
            StringBuilder stringBuilder = new StringBuilder("Activity started: ");
            stringBuilder.append((Object)activity.getClass());
            stringBuilder.append("@");
            stringBuilder.append(activity.hashCode());
            Log.d((String)"MoatActivityState", (String)stringBuilder.toString());
        }
        if (this.a(activity)) {
            c.a((c)this.a, (boolean)false);
        }
    }

    public void onActivityStopped(Activity activity) {
        if (c.a((c)this.a).b()) {
            StringBuilder stringBuilder = new StringBuilder("Activity stopped: ");
            stringBuilder.append((Object)activity.getClass());
            stringBuilder.append("@");
            stringBuilder.append(activity.hashCode());
            Log.d((String)"MoatActivityState", (String)stringBuilder.toString());
        }
        if (this.a(activity)) {
            c.a((c)this.a, (boolean)true);
        }
    }
}

