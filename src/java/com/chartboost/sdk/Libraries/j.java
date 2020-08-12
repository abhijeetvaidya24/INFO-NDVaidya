/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  com.chartboost.sdk.impl.aq
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.ref.WeakReference
 */
package com.chartboost.sdk.Libraries;

import android.app.Activity;
import com.chartboost.sdk.impl.aq;
import java.lang.ref.WeakReference;

public final class j
extends WeakReference<Activity> {
    public final int a;

    public j(Activity activity) {
        super((Object)activity);
        aq.a((String)"WeakActivity.WeakActivity", (Object)activity);
        this.a = activity.hashCode();
    }

    public boolean a(Activity activity) {
        return activity != null && activity.hashCode() == this.a;
    }

    public int hashCode() {
        return this.a;
    }
}

