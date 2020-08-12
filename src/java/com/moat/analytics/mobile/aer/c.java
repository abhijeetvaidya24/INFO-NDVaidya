/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Application
 *  android.app.Application$ActivityLifecycleCallbacks
 *  android.util.Log
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.ref.WeakReference
 */
package com.moat.analytics.mobile.aer;

import android.app.Activity;
import android.app.Application;
import android.util.Log;
import com.moat.analytics.mobile.aer.al;
import com.moat.analytics.mobile.aer.base.asserts.a;
import com.moat.analytics.mobile.aer.d;
import com.moat.analytics.mobile.aer.e;
import java.lang.ref.WeakReference;

class c
implements com.moat.analytics.mobile.aer.a {
    private final WeakReference<Application> a;
    private final WeakReference<Activity> b;
    private boolean c;
    private final al d;
    private boolean e;

    c(Activity activity, al al2) {
        a.a((Object)activity);
        if (al2.b()) {
            String string;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Listening to Activity: ");
            if (activity != null) {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append((Object)activity.getClass());
                stringBuilder2.append("@");
                stringBuilder2.append(activity.hashCode());
                string = stringBuilder2.toString();
            } else {
                string = "null";
            }
            stringBuilder.append(string);
            Log.d((String)"MoatActivityState", (String)stringBuilder.toString());
        }
        this.a = new WeakReference((Object)activity.getApplication());
        this.b = new WeakReference((Object)activity);
        this.d = al2;
        this.c = false;
    }

    static /* synthetic */ al a(c c2) {
        return c2.d;
    }

    static /* synthetic */ boolean a(c c2, boolean bl2) {
        c2.e = bl2;
        return bl2;
    }

    static /* synthetic */ WeakReference b(c c2) {
        return c2.a;
    }

    static /* synthetic */ WeakReference c(c c2) {
        return c2.b;
    }

    @Override
    public boolean a() {
        return this.e;
    }

    @Override
    public void b() {
        if (!this.c) {
            e e2 = new e(this, null);
            ((Application)this.a.get()).registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)e2);
        }
    }

    @Override
    public Activity c() {
        return (Activity)this.b.get();
    }
}

