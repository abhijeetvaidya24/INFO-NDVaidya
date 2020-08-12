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
 *  android.text.TextUtils
 *  com.yandex.metrica.CounterConfiguration
 *  com.yandex.metrica.PreloadInfo
 *  com.yandex.metrica.e
 *  com.yandex.metrica.impl.an
 *  com.yandex.metrica.impl.aw
 *  com.yandex.metrica.impl.ay
 *  com.yandex.metrica.impl.b
 *  com.yandex.metrica.impl.bk
 *  com.yandex.metrica.impl.j
 *  com.yandex.metrica.impl.m
 *  com.yandex.metrica.impl.utils.j
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.Map
 */
package com.yandex.metrica.impl;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.yandex.metrica.CounterConfiguration;
import com.yandex.metrica.PreloadInfo;
import com.yandex.metrica.e;
import com.yandex.metrica.impl.an;
import com.yandex.metrica.impl.aw;
import com.yandex.metrica.impl.ay;
import com.yandex.metrica.impl.b;
import com.yandex.metrica.impl.bk;
import com.yandex.metrica.impl.j;
import com.yandex.metrica.impl.m;
import com.yandex.metrica.impl.ob.dw;
import java.util.Map;

public class z
extends b {
    z(Context context, e e2, ay ay2) {
        super(context, e2.getApiKey(), ay2, new aw());
        this.b.a(new an(e2.getPreloadInfo()));
    }

    private static void c(String string, String string2) {
        StringBuilder stringBuilder = new StringBuilder("Event received: ");
        stringBuilder.append(string);
        if (!TextUtils.isEmpty((CharSequence)string2)) {
            stringBuilder.append(". With value: ");
            stringBuilder.append(string2);
        }
        com.yandex.metrica.impl.utils.j.f().a(stringBuilder.toString());
    }

    public void a(Application application) {
        bk.a((Object)application, (String)"Application");
        if (Build.VERSION.SDK_INT >= 14) {
            com.yandex.metrica.impl.utils.j.f().a("Enable activity auto tracking");
            application.registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)new m(this));
            return;
        }
        com.yandex.metrica.impl.utils.j.f().b("Could not enable activity auto tracking. API level should be more than 14 (ICE_CREAM_SANDWICH)");
    }

    void a(e e2, boolean bl2) {
        this.b.b().a(e2);
        this.d(this.b.b().l());
        if (bl2) {
            this.b();
        }
        this.b(e2.j());
        this.a(e2.getErrorEnvironment());
    }

    void a(j j2) {
        super.a(j2);
    }

    void a(dw dw2) {
        super.a(dw2);
    }

    public void a(String string, String string2) {
        if (TextUtils.isEmpty((CharSequence)string)) {
            com.yandex.metrica.impl.utils.j.f().b("Invalid Error Environment (key,value) pair: (%s,%s).", new Object[]{string, string2});
            return;
        }
        super.a(string, string2);
    }

    public void b(Activity activity) {
        this.b(this.d(activity));
    }

    public void b(String string, String string2) {
        if (TextUtils.isEmpty((CharSequence)string)) {
            com.yandex.metrica.impl.utils.j.f().b("Invalid App Environment (key,value) pair: (%s,%s).", new Object[]{string, string2});
            return;
        }
        super.b(string, string2);
    }

    public void c(Activity activity) {
        this.c(this.d(activity));
    }

    public void c(boolean bl2) {
        this.b.b().a(bl2);
    }

    String d(Activity activity) {
        if (activity != null) {
            return activity.getClass().getSimpleName();
        }
        return null;
    }

    public void d(boolean bl2) {
        this.c.a(bl2, this.b);
    }

    public boolean f() {
        return this.b.b().k();
    }

    public void reportError(String string, Throwable throwable) {
        super.reportError(string, throwable);
        com.yandex.metrica.impl.utils.j.f().a("Error received: %s", new Object[]{string});
    }

    public void reportEvent(String string) {
        super.reportEvent(string);
    }

    public void reportEvent(String string, String string2) {
        super.reportEvent(string, string2);
        z.c(string, string2);
    }

    public void reportEvent(String string, Map<String, Object> map) {
        super.reportEvent(string, map);
        String string2 = map == null ? null : map.toString();
        z.c(string, string2);
    }
}

