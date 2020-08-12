/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.view.View
 *  android.view.Window
 *  com.integralads.avid.library.adcolony.weakreference.AvidActivity
 *  java.lang.Object
 *  java.util.ArrayList
 *  java.util.Iterator
 *  java.util.List
 */
package com.integralads.avid.library.adcolony.activity;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.Window;
import com.integralads.avid.library.adcolony.weakreference.AvidActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AvidActivityStack {
    private static AvidActivityStack a = new AvidActivityStack();
    private final ArrayList<AvidActivity> b = new ArrayList();

    private View b(AvidActivity avidActivity) {
        Activity activity = (Activity)avidActivity.get();
        if (activity == null) {
            return null;
        }
        Window window = activity.getWindow();
        if (window != null) {
            if (!activity.hasWindowFocus()) {
                return null;
            }
            View view = window.getDecorView();
            if (view != null && view.isShown()) {
                return view;
            }
            return null;
        }
        return null;
    }

    public static AvidActivityStack getInstance() {
        return a;
    }

    AvidActivity a(Activity activity) {
        for (AvidActivity avidActivity : this.b) {
            if (!avidActivity.contains((Object)activity)) continue;
            return avidActivity;
        }
        return null;
    }

    boolean a(AvidActivity avidActivity) {
        Activity activity = (Activity)avidActivity.get();
        if (activity == null) {
            return true;
        }
        if (Build.VERSION.SDK_INT >= 17) {
            return activity.isDestroyed();
        }
        return activity.isFinishing();
    }

    public void addActivity(Activity activity) {
        if (this.a(activity) == null) {
            this.b.add((Object)new AvidActivity(activity));
        }
    }

    public void cleanup() {
        this.b.clear();
    }

    public List<View> getRootViews() {
        ArrayList arrayList = new ArrayList();
        Iterator iterator = this.b.iterator();
        View view = null;
        while (iterator.hasNext()) {
            AvidActivity avidActivity = (AvidActivity)iterator.next();
            if (this.a(avidActivity)) {
                iterator.remove();
                continue;
            }
            View view2 = this.b(avidActivity);
            if (view2 == null) continue;
            view = view2;
        }
        if (view != null) {
            arrayList.add(view);
        }
        return arrayList;
    }
}

