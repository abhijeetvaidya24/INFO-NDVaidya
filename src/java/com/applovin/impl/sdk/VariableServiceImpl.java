/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.text.TextUtils
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.concurrent.atomic.AtomicBoolean
 *  org.json.JSONObject
 */
package com.applovin.impl.sdk;

import android.os.Bundle;
import android.text.TextUtils;
import com.applovin.impl.sdk.VariableServiceImpl;
import com.applovin.impl.sdk.b.d;
import com.applovin.impl.sdk.e.g;
import com.applovin.impl.sdk.e.j;
import com.applovin.impl.sdk.p;
import com.applovin.sdk.AppLovinSdkUtils;
import com.applovin.sdk.AppLovinVariableService;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public class VariableServiceImpl
implements AppLovinVariableService {
    private final com.applovin.impl.sdk.j a;
    private final AtomicBoolean b = new AtomicBoolean();
    private AppLovinVariableService.OnVariablesUpdateListener c;
    private Bundle d;
    private final Object e = new Object();

    VariableServiceImpl(com.applovin.impl.sdk.j j2) {
        this.a = j2;
        String string = j2.a(d.d);
        if (j.b(string)) {
            this.updateVariables(g.a(string, j2));
        }
    }

    static /* synthetic */ AppLovinVariableService.OnVariablesUpdateListener a(VariableServiceImpl variableServiceImpl) {
        return variableServiceImpl.c;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private Object a(String string, Object object, Class<?> class_) {
        Object object2;
        if (TextUtils.isEmpty((CharSequence)string)) {
            this.a.u().e("AppLovinVariableService", "Unable to retrieve variable value for empty name");
            return object;
        }
        Object object3 = object2 = this.e;
        synchronized (object3) {
            if (this.d == null) {
                this.a.u().e("AppLovinVariableService", "Unable to retrieve variable value, none retrieved from server yet. Please set a listener to be notified when values are retrieved from the server.");
                return object;
            }
            if (class_.equals(String.class)) {
                return this.d.getString(string, (String)object);
            }
            if (class_.equals(Boolean.class)) {
                return this.d.getBoolean(string, ((Boolean)object).booleanValue());
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unable to retrieve variable value for ");
            stringBuilder.append(string);
            throw new IllegalStateException(stringBuilder.toString());
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void a() {
        Object object;
        Object object2 = object = this.e;
        synchronized (object2) {
            if (this.c != null && this.d != null) {
                AppLovinSdkUtils.runOnUiThread(true, new Runnable(this, (Bundle)this.d.clone()){
                    final /* synthetic */ Bundle a;
                    final /* synthetic */ VariableServiceImpl b;
                    {
                        this.b = variableServiceImpl;
                        this.a = bundle;
                    }

                    public void run() {
                        VariableServiceImpl.a(this.b).onVariablesUpdate(this.a);
                    }
                });
                return;
            }
            return;
        }
    }

    @Override
    public boolean getBoolean(String string) {
        return this.getBoolean(string, false);
    }

    @Override
    public boolean getBoolean(String string, boolean bl) {
        return (Boolean)this.a(string, bl, Boolean.class);
    }

    @Override
    public String getString(String string) {
        return this.getString(string, null);
    }

    @Override
    public String getString(String string, String string2) {
        return (String)this.a(string, string2, String.class);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void setOnVariablesUpdateListener(AppLovinVariableService.OnVariablesUpdateListener onVariablesUpdateListener) {
        Object object;
        this.c = onVariablesUpdateListener;
        Object object2 = object = this.e;
        synchronized (object2) {
            if (onVariablesUpdateListener != null && this.d != null && this.b.compareAndSet(false, true)) {
                this.a.u().a("AppLovinVariableService", "Setting initial listener");
                this.a();
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void updateVariables(JSONObject jSONObject) {
        Object object;
        this.a.u().a("AppLovinVariableService", "Updating variables...");
        Object object2 = object = this.e;
        synchronized (object2) {
            this.d = g.b(jSONObject);
            this.a();
            this.a.a(d.d, jSONObject.toString());
            return;
        }
    }
}

