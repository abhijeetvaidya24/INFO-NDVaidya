/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Handler
 *  android.os.Looper
 *  android.util.Log
 *  android.webkit.WebView
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.tapjoy;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.webkit.WebView;
import com.tapjoy.TapjoyAppSettings;
import com.tapjoy.TapjoyErrorMessage;
import com.tapjoy.internal.fz;
import com.tapjoy.internal.ga;
import com.tapjoy.internal.gc;

public class TapjoyLog {
    private static final String a = "TapjoyLog";
    private static int b = 6;
    private static int c = 4;
    private static int d = 2;
    private static boolean e;
    private static int f;

    static {
        f = b;
    }

    private static void a(int n2, String string2, String string3) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(a);
        stringBuilder.append(":");
        stringBuilder.append(string2);
        String string4 = stringBuilder.toString();
        if (f <= n2) {
            if (string3.length() > 4096) {
                int n3 = 0;
                while (n3 <= string3.length() / 4096) {
                    int n4;
                    int n5 = n3 * 4096;
                    if ((n4 = ++n3 * 4096) > string3.length()) {
                        n4 = string3.length();
                    }
                    Log.println((int)n2, (String)string4, (String)string3.substring(n5, n4));
                }
                return;
            }
            Log.println((int)n2, (String)string4, (String)string3);
        }
    }

    @TargetApi(value=19)
    static void a(String string2, boolean bl2) {
        if (!bl2 && TapjoyAppSettings.getInstance() != null && TapjoyAppSettings.getInstance().a != null) {
            TapjoyLog.d(a, "setLoggingLevel -- log setting already persisted");
            return;
        }
        if (string2.equals((Object)"internal")) {
            f = d;
            if (Build.VERSION.SDK_INT >= 19) {
                new Handler(Looper.getMainLooper()).post(new Runnable(){

                    public final void run() {
                        TapjoyLog.d(a, "Enabling WebView debugging");
                        WebView.setWebContentsDebuggingEnabled((boolean)true);
                    }
                });
            }
        } else if (string2.equals((Object)"debug_on")) {
            f = c;
        } else if (string2.equals((Object)"debug_off")) {
            f = b;
        } else {
            String string3 = a;
            StringBuilder stringBuilder = new StringBuilder("unrecognized loggingLevel: ");
            stringBuilder.append(string2);
            TapjoyLog.d(string3, stringBuilder.toString());
            f = b;
        }
        String string4 = a;
        StringBuilder stringBuilder = new StringBuilder("logThreshold=");
        stringBuilder.append(f);
        TapjoyLog.d(string4, stringBuilder.toString());
    }

    public static void d(String string2, String string3) {
        TapjoyLog.a(3, string2, string3);
    }

    public static void e(String string2, TapjoyErrorMessage tapjoyErrorMessage) {
        if (tapjoyErrorMessage != null && (f == d || tapjoyErrorMessage.getType() != TapjoyErrorMessage.ErrorType.INTERNAL_ERROR)) {
            TapjoyLog.a(6, string2, tapjoyErrorMessage.toString());
        }
    }

    public static void e(String string2, String string3) {
        TapjoyLog.e(string2, new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.INTERNAL_ERROR, string3));
    }

    public static void i(String string2, String string3) {
        TapjoyLog.a(4, string2, string3);
    }

    public static boolean isLoggingEnabled() {
        return e;
    }

    public static void setDebugEnabled(boolean bl2) {
        boolean bl3;
        e = bl2;
        gc gc2 = gc.a();
        if (fz.a != bl2) {
            fz.a = bl2;
            if (bl2) {
                fz.a("The debug mode has been enabled");
            } else {
                fz.a("The debug mode has been disabled");
            }
            bl3 = true;
        } else {
            bl3 = false;
        }
        if (bl3 && bl2 && gc2.k) {
            gc2.i.a();
        }
        if (e) {
            TapjoyLog.a("debug_on", false);
            return;
        }
        TapjoyLog.a("debug_off", false);
    }

    public static void setInternalLogging(boolean bl2) {
        if (bl2) {
            TapjoyLog.a("internal", true);
        }
    }

    public static void v(String string2, String string3) {
        TapjoyLog.a(2, string2, string3);
    }

    public static void w(String string2, String string3) {
        TapjoyLog.a(5, string2, string3);
    }

}

