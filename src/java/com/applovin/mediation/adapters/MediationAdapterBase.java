/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.pm.ActivityInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.util.Log
 *  java.lang.Class
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 */
package com.applovin.mediation.adapters;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import com.applovin.impl.sdk.e.m;
import com.applovin.impl.sdk.j;
import com.applovin.mediation.adapter.MaxAdapter;
import com.applovin.sdk.AppLovinSdk;

public abstract class MediationAdapterBase
implements MaxAdapter {
    protected static final String KEY_MUTED = "muted";
    private final j mSdk;
    private final String mTag;

    public MediationAdapterBase(AppLovinSdk appLovinSdk) {
        this.mSdk = m.a(appLovinSdk);
        this.mTag = this.getClass().getSimpleName();
    }

    protected static String mediationTag() {
        return "AppLovinSdk_9.2.1";
    }

    protected /* varargs */ void checkActivities(Context context, Class<?> ... arrclass) {
        if (arrclass != null && arrclass.length > 0) {
            for (Class<?> class_ : arrclass) {
                block5 : {
                    try {
                        ComponentName componentName = new ComponentName(context, class_);
                        if (context.getPackageManager().getActivityInfo(componentName, 128) == null) break block5;
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Found defined activity: ");
                        stringBuilder.append(class_.getName());
                        this.log(stringBuilder.toString());
                    }
                    catch (PackageManager.NameNotFoundException nameNotFoundException) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("No activity found for: ");
                        stringBuilder.append(class_);
                        this.log(stringBuilder.toString());
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append("Activity ");
                        stringBuilder2.append(class_.getName());
                        stringBuilder2.append(" not defined");
                        throw new IllegalStateException(stringBuilder2.toString(), (Throwable)nameNotFoundException);
                    }
                    continue;
                }
                throw new PackageManager.NameNotFoundException("null_activity_info");
            }
        }
    }

    protected /* varargs */ void checkExistence(Class<?> ... arrclass) {
        if (arrclass != null && arrclass.length > 0) {
            for (Class<?> class_ : arrclass) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Found: ");
                stringBuilder.append(class_.getName());
                this.log(stringBuilder.toString());
            }
        }
    }

    protected j getSdk() {
        return this.mSdk;
    }

    protected void log(String string) {
        Log.i((String)this.mTag, (String)string);
    }

    protected void log(String string, Throwable throwable) {
        Log.i((String)this.mTag, (String)string, (Throwable)throwable);
    }
}

