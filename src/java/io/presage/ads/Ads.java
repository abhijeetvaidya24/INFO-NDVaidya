/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.Log
 *  java.lang.Class
 *  java.lang.Error
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.lang.reflect.Method
 */
package io.presage.ads;

import android.content.Context;
import android.util.Log;
import java.lang.reflect.Method;

public class Ads {
    public static void initialize(Context context, String string2) {
        try {
            Class.forName((String)"io.presage.common.PresageSdk").getMethod("init", new Class[]{Context.class, String.class}).invoke(null, new Object[]{context, string2});
            return;
        }
        catch (Error error) {
            Log.e((String)"Presage.Ads", (String)"An error occurred while initializing", (Throwable)error);
            return;
        }
        catch (Exception exception) {
            Log.e((String)"Presage.Ads", (String)"An error occurred while initializing", (Throwable)exception);
            return;
        }
    }
}

