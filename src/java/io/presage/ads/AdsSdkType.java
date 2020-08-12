/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.Log
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.lang.reflect.Constructor
 *  java.lang.reflect.Method
 */
package io.presage.ads;

import android.content.Context;
import android.util.Log;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class AdsSdkType {
    private Context IIIIIIII;

    public AdsSdkType(Context context) {
        this.IIIIIIII = context;
    }

    public void setType(int n2) {
        try {
            Class class_ = Class.forName((String)"io.presage.common.SdkType");
            Constructor constructor = class_.getConstructor(new Class[]{Context.class});
            Object[] arrobject = new Object[]{this.IIIIIIII};
            Object object = constructor.newInstance(arrobject);
            Class[] arrclass = new Class[]{Integer.TYPE};
            Method method = class_.getMethod("setType", arrclass);
            Object[] arrobject2 = new Object[]{n2};
            method.invoke(object, arrobject2);
            return;
        }
        catch (Exception exception) {
            Log.e((String)"Presage.Ads", (String)"An error occurred while initializing", (Throwable)exception);
            return;
        }
    }
}

