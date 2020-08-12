/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  android.util.DisplayMetrics
 *  android.view.Display
 *  android.view.WindowManager
 *  java.lang.Object
 *  java.lang.String
 */
package com.tapjoy;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

public class TapjoyDisplayMetricsUtil {
    private Context a;
    private Configuration b;
    private DisplayMetrics c;

    public TapjoyDisplayMetricsUtil(Context context) {
        this.a = context;
        this.c = new DisplayMetrics();
        ((WindowManager)this.a.getSystemService("window")).getDefaultDisplay().getMetrics(this.c);
        this.b = this.a.getResources().getConfiguration();
    }

    public int getScreenDensityDPI() {
        return this.c.densityDpi;
    }

    public float getScreenDensityScale() {
        return this.c.density;
    }

    public int getScreenLayoutSize() {
        return 15 & this.b.screenLayout;
    }
}

