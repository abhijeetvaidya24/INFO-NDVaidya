/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  android.view.View
 *  com.moat.analytics.mobile.mpub.k
 *  java.lang.Class
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 */
package com.moat.analytics.mobile.mpub;

import android.util.Log;
import android.view.View;
import com.moat.analytics.mobile.mpub.MoatAnalytics;
import com.moat.analytics.mobile.mpub.k;
import com.moat.analytics.mobile.mpub.w;

class p {
    p() {
    }

    static String a(View view) {
        if (view != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(view.getClass().getSimpleName());
            stringBuilder.append("@");
            stringBuilder.append(view.hashCode());
            return stringBuilder.toString();
        }
        return "null";
    }

    private static String a(String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Moat");
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }

    static void a(int n2, String string2, Object object, String string3) {
        if (w.a().b) {
            String string4;
            String string5;
            if (object == null) {
                string5 = p.a(string2);
                string4 = String.format((String)"message = %s", (Object[])new Object[]{string3});
            } else {
                string5 = p.a(string2);
                Object[] arrobject = new Object[]{object.hashCode(), string3};
                string4 = String.format((String)"id = %s, message = %s", (Object[])arrobject);
            }
            Log.println((int)n2, (String)string5, (String)string4);
        }
    }

    static void a(String string2, int n2, String string3, Object object, String string4) {
        p.a(n2, string3, object, string4);
        p.a(string2, string4);
    }

    static void a(String string2, Object object, String string3, Throwable throwable) {
        if (w.a().b) {
            String string4 = p.a(string2);
            Object[] arrobject = new Object[]{object.hashCode(), string3};
            Log.e((String)string4, (String)String.format((String)"id = %s, message = %s", (Object[])arrobject), (Throwable)throwable);
        }
    }

    static void a(String string2, String string3) {
        if (!w.a().b && ((k)MoatAnalytics.getInstance()).a) {
            int n2 = 2;
            if (string2.equals((Object)"[ERROR] ")) {
                n2 = 6;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string2);
            stringBuilder.append(string3);
            Log.println((int)n2, (String)"MoatAnalytics", (String)stringBuilder.toString());
        }
    }

    static void b(int n2, String string2, Object object, String string3) {
        if (w.a().c) {
            String string4 = p.a(string2);
            Object[] arrobject = new Object[2];
            String string5 = object == null ? "null" : Integer.valueOf((int)object.hashCode());
            arrobject[0] = string5;
            arrobject[1] = string3;
            Log.println((int)n2, (String)string4, (String)String.format((String)"id = %s, message = %s", (Object[])arrobject));
        }
    }
}

