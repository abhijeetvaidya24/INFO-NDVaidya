/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.io.Serializable
 *  java.lang.Object
 *  java.lang.String
 */
package com.startapp.android.publish.ads.splash;

import android.content.Context;
import com.startapp.android.publish.ads.splash.SplashConfig;
import com.startapp.android.publish.adsCommon.AdsConstants;
import com.startapp.android.publish.adsCommon.Utils.i;
import com.startapp.android.publish.adsCommon.f.d;
import com.startapp.common.a.e;
import java.io.Serializable;

public class f
implements Serializable {
    private static transient f a = new f();
    private static Object b = new Object();
    private static final long serialVersionUID = 1L;
    @com.startapp.common.c.f(a=true)
    private SplashConfig SplashConfig = new SplashConfig();
    private String splashMetadataUpdateVersion = AdsConstants.h;

    private f() {
    }

    public static void a(Context context) {
        f f2 = e.a(context, "StartappSplashMetadata", f.class);
        f f3 = new f();
        if (f2 != null) {
            boolean bl = i.a(f2, f3);
            if (!f2.c() && bl) {
                com.startapp.android.publish.adsCommon.f.f.a(context, d.k, "SplashMetaData", "", "");
            }
            a = f2;
            return;
        }
        a = f3;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void a(Context context, f f2) {
        Object object;
        Object object2 = object = b;
        synchronized (object2) {
            f2.splashMetadataUpdateVersion = AdsConstants.h;
            a = f2;
            e.a(context, "StartappSplashMetadata", (Serializable)f2);
            return;
        }
    }

    public static f b() {
        return a;
    }

    private boolean c() {
        return true ^ AdsConstants.h.equals((Object)this.splashMetadataUpdateVersion);
    }

    public SplashConfig a() {
        return this.SplashConfig;
    }
}

