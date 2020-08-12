/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Application
 *  android.app.Application$ActivityLifecycleCallbacks
 *  android.content.Context
 *  android.os.Bundle
 *  java.lang.Object
 *  java.lang.ref.WeakReference
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.Iterator
 *  java.util.List
 */
package com.applovin.impl.sdk;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import com.applovin.impl.sdk.j;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class a
implements Application.ActivityLifecycleCallbacks {
    private final j a;
    private final List<com.applovin.impl.sdk.e.a> b = Collections.synchronizedList((List)new ArrayList());
    private WeakReference<Activity> c = new WeakReference(null);

    public a(j j2, Context context) {
        this.a = j2;
        if (context instanceof Activity) {
            this.c = new WeakReference((Object)((Activity)context));
        }
        ((Application)context.getApplicationContext()).registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)this);
    }

    public Activity a() {
        return (Activity)this.c.get();
    }

    public void a(com.applovin.impl.sdk.e.a a2) {
        this.b.add((Object)a2);
    }

    public void b(com.applovin.impl.sdk.e.a a2) {
        this.b.remove((Object)a2);
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        Iterator iterator = new ArrayList(this.b).iterator();
        while (iterator.hasNext()) {
            ((com.applovin.impl.sdk.e.a)iterator.next()).onActivityCreated(activity, bundle);
        }
    }

    public void onActivityDestroyed(Activity activity) {
        Iterator iterator = new ArrayList(this.b).iterator();
        while (iterator.hasNext()) {
            ((com.applovin.impl.sdk.e.a)iterator.next()).onActivityDestroyed(activity);
        }
    }

    public void onActivityPaused(Activity activity) {
        Iterator iterator = new ArrayList(this.b).iterator();
        while (iterator.hasNext()) {
            ((com.applovin.impl.sdk.e.a)iterator.next()).onActivityPaused(activity);
        }
    }

    public void onActivityResumed(Activity activity) {
        this.c = new WeakReference((Object)activity);
        Iterator iterator = new ArrayList(this.b).iterator();
        while (iterator.hasNext()) {
            ((com.applovin.impl.sdk.e.a)iterator.next()).onActivityResumed(activity);
        }
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        Iterator iterator = new ArrayList(this.b).iterator();
        while (iterator.hasNext()) {
            ((com.applovin.impl.sdk.e.a)iterator.next()).onActivitySaveInstanceState(activity, bundle);
        }
    }

    public void onActivityStarted(Activity activity) {
        Iterator iterator = new ArrayList(this.b).iterator();
        while (iterator.hasNext()) {
            ((com.applovin.impl.sdk.e.a)iterator.next()).onActivityStarted(activity);
        }
    }

    public void onActivityStopped(Activity activity) {
        Iterator iterator = new ArrayList(this.b).iterator();
        while (iterator.hasNext()) {
            ((com.applovin.impl.sdk.e.a)iterator.next()).onActivityStopped(activity);
        }
    }
}

