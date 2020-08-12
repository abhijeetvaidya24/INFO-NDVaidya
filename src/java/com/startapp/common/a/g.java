/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuffer
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 */
package com.startapp.common.a;

import android.util.Log;
import com.startapp.common.Constants;

public class g {
    public static void a(int n2, String string) {
        if (Constants.a().booleanValue()) {
            g.a(n2, string, null);
        }
    }

    public static void a(int n2, String string, Throwable throwable) {
        g.a(null, n2, string, throwable);
    }

    public static void a(String string, int n2, String string2) {
        if (Constants.a().booleanValue()) {
            g.a(string, n2, string2, null);
        }
    }

    public static void a(String string, int n2, String string2, Throwable throwable) {
        String string3;
        if (string == null) {
            string3 = "";
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(".");
            stringBuilder.append(string);
            string3 = stringBuilder.toString();
        }
        if (Constants.a().booleanValue()) {
            StringBuffer stringBuffer = new StringBuffer(string2);
            if (stringBuffer.length() > 4000) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("startapp");
                stringBuilder.append(string3);
                String string4 = stringBuilder.toString();
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("sb.length = ");
                stringBuilder2.append(stringBuffer.length());
                g.b(string4, n2, stringBuilder2.toString(), throwable);
                int n3 = stringBuffer.length() / 4000;
                int n4 = 0;
                while (n4 <= n3) {
                    int n5 = n4 + 1;
                    int n6 = n5 * 4000;
                    if (n6 >= stringBuffer.length()) {
                        StringBuilder stringBuilder3 = new StringBuilder();
                        stringBuilder3.append("startapp");
                        stringBuilder3.append(string3);
                        String string5 = stringBuilder3.toString();
                        StringBuilder stringBuilder4 = new StringBuilder();
                        stringBuilder4.append(n4);
                        stringBuilder4.append("/");
                        stringBuilder4.append(n3);
                        stringBuilder4.append(":");
                        stringBuilder4.append(stringBuffer.substring(n4 * 4000));
                        g.b(string5, n2, stringBuilder4.toString(), null);
                    } else {
                        StringBuilder stringBuilder5 = new StringBuilder();
                        stringBuilder5.append("startapp");
                        stringBuilder5.append(string3);
                        String string6 = stringBuilder5.toString();
                        StringBuilder stringBuilder6 = new StringBuilder();
                        stringBuilder6.append(n4);
                        stringBuilder6.append("/");
                        stringBuilder6.append(n3);
                        stringBuilder6.append(":");
                        stringBuilder6.append(stringBuffer.substring(n4 * 4000, n6));
                        g.b(string6, n2, stringBuilder6.toString(), null);
                    }
                    n4 = n5;
                }
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("startapp");
                stringBuilder.append(string3);
                g.b(stringBuilder.toString(), n2, string2, throwable);
            }
        }
    }

    private static void b(String string, int n2, String string2, Throwable throwable) {
        if (n2 != 2) {
            if (n2 != 3) {
                if (n2 != 4) {
                    if (n2 != 5) {
                        if (n2 != 6) {
                            return;
                        }
                        Log.e((String)string, (String)string2, (Throwable)throwable);
                        return;
                    }
                    Log.w((String)string, (String)string2, (Throwable)throwable);
                    return;
                }
                Log.i((String)string, (String)string2, (Throwable)throwable);
                return;
            }
            Log.d((String)string, (String)string2, (Throwable)throwable);
            return;
        }
        Log.v((String)string, (String)string2, (Throwable)throwable);
    }
}

