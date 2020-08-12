/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.ConnectivityManager
 *  android.net.NetworkInfo
 *  android.os.Process
 *  android.text.TextUtils
 *  com.appnext.core.f
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 */
package com.appnext.base.b;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Process;
import android.text.TextUtils;
import com.appnext.base.b.e;
import com.appnext.base.b.h;

public class f {
    public static final String TAG = "f";

    public static boolean a(Context context, String string2) {
        if (context != null) {
            if (TextUtils.isEmpty((CharSequence)string2)) {
                return false;
            }
            if (context.checkPermission(string2, Process.myPid(), Process.myUid()) == 0) {
                return true;
            }
        }
        return false;
    }

    public static NetworkInfo e(Context context) {
        return ((ConnectivityManager)context.getSystemService("connectivity")).getActiveNetworkInfo();
    }

    public static String getKey() {
        h.aO();
        return h.J(com.appnext.core.f.b((Context)e.getContext(), (boolean)false));
    }
}

