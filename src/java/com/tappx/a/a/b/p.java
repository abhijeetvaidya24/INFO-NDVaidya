/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 *  android.os.Bundle
 *  android.util.SparseArray
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 */
package com.tappx.a.a.b;

import android.content.Intent;
import android.os.Bundle;
import android.util.SparseArray;

public class p {
    public static final int a = 0;
    private static final String b = "ipc_aavc_bkN4RpcYmIsYuf4eZQOt";
    private static final String c = "aavc_5orHkZouKDEIkayJNWLC";
    private static final int d = 262144;
    private static SparseArray<String> e = new SparseArray();
    private static int f = Integer.MIN_VALUE;

    public static int a() {
        Class<p> class_ = p.class;
        synchronized (p.class) {
            try {
                while ((f = 1 + f) == 0) {
                }
                int n2 = f;
                // ** MonitorExit[var2] (shouldn't be in output)
                return n2;
            }
            catch (Throwable throwable) {
                // ** MonitorExit[var2] (shouldn't be in output)
                throw throwable;
            }
        }
    }

    private static int a(String string2) {
        int n2 = p.a();
        e.put(n2, (Object)string2);
        return n2;
    }

    public static String a(Intent intent) {
        Bundle bundle = intent.getExtras();
        if (bundle.containsKey(b)) {
            return bundle.getString(b);
        }
        int n2 = bundle.getInt(c);
        return (String)e.get(n2);
    }

    public static void a(Intent intent, String string2) {
        if (string2.length() > 262144) {
            intent.putExtra(c, p.a(string2));
            return;
        }
        intent.putExtra(b, string2);
    }
}

