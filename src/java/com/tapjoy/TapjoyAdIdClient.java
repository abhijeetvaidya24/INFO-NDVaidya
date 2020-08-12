/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.android.gms.ads.identifier.AdvertisingIdClient
 *  com.google.android.gms.ads.identifier.AdvertisingIdClient$Info
 *  com.tapjoy.TapjoyLog
 *  java.lang.Boolean
 *  java.lang.Class
 *  java.lang.Error
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.reflect.Method
 */
package com.tapjoy;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.tapjoy.TapjoyLog;
import java.lang.reflect.Method;

public class TapjoyAdIdClient {
    private Context a;
    private String b;
    private boolean c;

    public TapjoyAdIdClient(Context context) {
        this.a = context;
    }

    public String getAdvertisingId() {
        return this.b;
    }

    public boolean isAdTrackingEnabled() {
        return this.c;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean setupAdIdInfo() {
        try {
            AdvertisingIdClient.Info info = AdvertisingIdClient.getAdvertisingIdInfo((Context)this.a);
            this.b = info.getId();
            boolean bl = !info.isLimitAdTrackingEnabled();
            this.c = bl;
            return true;
        }
        catch (Error | Exception throwable) {
            return false;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean setupAdIdInfoReflection() {
        try {
            Class class_ = Class.forName((String)"com.google.android.gms.ads.identifier.AdvertisingIdClient");
            Method method = class_.getMethod("getAdvertisingIdInfo", new Class[]{Context.class});
            StringBuilder stringBuilder = new StringBuilder("Found method: ");
            stringBuilder.append((Object)method);
            TapjoyLog.d((String)"TapjoyAdIdClient", (String)stringBuilder.toString());
            Object[] arrobject = new Object[]{this.a};
            Object object = method.invoke((Object)class_, arrobject);
            Method method2 = object.getClass().getMethod("isLimitAdTrackingEnabled", new Class[0]);
            Method method3 = object.getClass().getMethod("getId", new Class[0]);
            boolean bl = (Boolean)method2.invoke(object, new Object[0]) == false;
            this.c = bl;
            this.b = (String)method3.invoke(object, new Object[0]);
            return true;
        }
        catch (Exception exception) {
            return false;
        }
    }
}

