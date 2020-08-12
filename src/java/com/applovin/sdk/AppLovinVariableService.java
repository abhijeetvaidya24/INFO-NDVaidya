/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  java.lang.Object
 *  java.lang.String
 */
package com.applovin.sdk;

import android.os.Bundle;

public interface AppLovinVariableService {
    public boolean getBoolean(String var1);

    public boolean getBoolean(String var1, boolean var2);

    public String getString(String var1);

    public String getString(String var1, String var2);

    public void setOnVariablesUpdateListener(OnVariablesUpdateListener var1);

    public static interface OnVariablesUpdateListener {
        public void onVariablesUpdate(Bundle var1);
    }

}

