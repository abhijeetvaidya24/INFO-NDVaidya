/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.webkit.WebView
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.net.MalformedURLException
 *  java.net.URL
 *  java.util.ArrayList
 *  java.util.List
 */
package com.startapp.android.publish.omsdk;

import android.content.Context;
import android.webkit.WebView;
import com.b.a.a.a.b.c;
import com.b.a.a.a.b.d;
import com.b.a.a.a.b.g;
import com.b.a.a.a.b.h;
import com.startapp.android.publish.adsCommon.f.f;
import com.startapp.android.publish.omsdk.AdVerification;
import com.startapp.android.publish.omsdk.VerificationDetails;
import com.startapp.android.publish.omsdk.b;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class a {
    public static com.b.a.a.a.b.b a(Context context, AdVerification adVerification) {
        if (!a.a(context)) {
            return null;
        }
        if (adVerification == null) {
            f.a(context, com.startapp.android.publish.adsCommon.f.d.b, "OMSDK: Verification details can't be null!", "", "");
            return null;
        }
        String string = b.a();
        List<VerificationDetails> list = adVerification.getAdVerification();
        ArrayList arrayList = new ArrayList(list.size());
        for (VerificationDetails verificationDetails : list) {
            URL uRL = a.a(context, verificationDetails.getVerificationScriptUrl());
            if (uRL == null) continue;
            arrayList.add((Object)h.a(verificationDetails.getVendorKey(), uRL, verificationDetails.getVerificationParameters()));
        }
        return a.a(d.a(a.b(), string, (List<h>)arrayList, a.a()), true);
    }

    public static com.b.a.a.a.b.b a(WebView webView) {
        if (!a.a(webView.getContext())) {
            return null;
        }
        return a.a(d.a(a.b(), webView, a.a()), false);
    }

    private static com.b.a.a.a.b.b a(d d2, boolean bl) {
        com.b.a.a.a.b.f f2 = com.b.a.a.a.b.f.a;
        com.b.a.a.a.b.f f3 = bl ? com.b.a.a.a.b.f.a : com.b.a.a.a.b.f.c;
        return com.b.a.a.a.b.b.a(c.a(f2, f3, false), d2);
    }

    private static String a() {
        return "";
    }

    private static URL a(Context context, String string) {
        try {
            URL uRL = new URL(string);
            return uRL;
        }
        catch (MalformedURLException malformedURLException) {
            com.startapp.android.publish.adsCommon.f.d d2 = com.startapp.android.publish.adsCommon.f.d.b;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("OMSDK: can't create URL - ");
            stringBuilder.append(string);
            f.a(context, d2, stringBuilder.toString(), malformedURLException.getMessage(), "");
            return null;
        }
    }

    private static boolean a(Context context) {
        try {
            if (!com.b.a.a.a.a.b() && !com.b.a.a.a.a.a(com.b.a.a.a.a.a(), context)) {
                f.a(context, com.startapp.android.publish.adsCommon.f.d.b, "OMSDK: Failed to activate sdk.", "", "");
                return false;
            }
            return true;
        }
        catch (Exception exception) {
            f.a(context, com.startapp.android.publish.adsCommon.f.d.b, "OMSDK: Failed to activate sdk.", exception.getMessage(), "");
            return false;
        }
    }

    private static g b() {
        return g.a("StartApp", "3.10.1");
    }
}

