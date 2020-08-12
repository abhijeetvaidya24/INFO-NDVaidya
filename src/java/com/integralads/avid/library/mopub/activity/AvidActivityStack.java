/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.view.View
 *  android.view.Window
 *  com.integralads.avid.library.mopub.weakreference.AvidActivity
 *  java.lang.Object
 *  java.util.ArrayList
 *  java.util.Iterator
 *  java.util.List
 */
package com.integralads.avid.library.mopub.activity;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.Window;
import com.integralads.avid.library.mopub.weakreference.AvidActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AvidActivityStack {
    private static AvidActivityStack avidActivityStackInstance = new AvidActivityStack();
    private final ArrayList<AvidActivity> activities = new ArrayList();

    public static AvidActivityStack getInstance() {
        return avidActivityStackInstance;
    }

    private View getRootView(AvidActivity avidActivity) {
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

    public void addActivity(Activity activity) {
        if (this.find(activity) == null) {
            this.activities.add((Object)new AvidActivity(activity));
        }
    }

    public void cleanup() {
        this.activities.clear();
    }

    AvidActivity find(Activity activity) {
        for (AvidActivity avidActivity : this.activities) {
            if (!avidActivity.contains((Object)activity)) continue;
            return avidActivity;
        }
        return null;
    }

    public List<View> getRootViews() {
        ArrayList arrayList = new ArrayList();
        Iterator iterator = this.activities.iterator();
        View view = null;
        while (iterator.hasNext()) {
            AvidActivity avidActivity = (AvidActivity)iterator.next();
            if (this.isFinished(avidActivity)) {
                iterator.remove();
                continue;
            }
            View view2 = this.getRootView(avidActivity);
            if (view2 == null) continue;
            view = view2;
        }
        if (view != null) {
            arrayList.add(view);
        }
        return arrayList;
    }

    boolean isFinished(AvidActivity avidActivity) {
        Activity activity = (Activity)avidActivity.get();
        if (activity == null) {
            return true;
        }
        if (Build.VERSION.SDK_INT >= 17) {
            return activity.isDestroyed();
        }
        return activity.isFinishing();
    }
}

