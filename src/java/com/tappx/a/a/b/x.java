/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.webkit.WebView
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.tappx.a.a.b;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.webkit.WebView;
import com.tappx.a.a.b.af;
import com.tappx.a.a.b.z;

public class x {
    public static final int a;
    private static final String b;
    private static int c;

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(af.b);
        stringBuilder.append(z.b);
        b = stringBuilder.toString();
        c = 0;
    }

    public x(Context context) {
        c = this.a(context);
    }

    private int a(Context context) {
        int n2 = c;
        if (n2 != 0) {
            return n2;
        }
        try {
            int n3;
            c = n3 = context.getPackageManager().getPackageInfo((String)context.getPackageName(), (int)0).applicationInfo.targetSdkVersion;
            return n3;
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            nameNotFoundException.printStackTrace();
            return 0;
        }
    }

    private boolean a() {
        return this.b();
    }

    private boolean b() {
        return c >= 24;
    }

    public String a(String string2) {
        if (this.a()) {
            string2 = string2.replaceFirst(af.a, b);
        }
        return string2;
    }

    public void a(WebView webView) {
        if (this.a()) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("javascript:");
        stringBuilder.append(z.a);
        webView.loadUrl(stringBuilder.toString());
    }
}

