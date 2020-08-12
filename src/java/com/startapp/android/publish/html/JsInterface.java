/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.PackageManager
 *  android.text.TextUtils
 *  android.webkit.JavascriptInterface
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Iterator
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.startapp.android.publish.html;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.startapp.android.publish.adsCommon.Utils.i;
import com.startapp.android.publish.adsCommon.c;
import com.startapp.android.publish.adsCommon.d.b;
import com.startapp.android.publish.adsCommon.f.d;
import com.startapp.android.publish.adsCommon.f.f;
import com.startapp.common.a.g;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class JsInterface {
    private Runnable clickCallback = null;
    private Runnable closeCallback = null;
    private Runnable enableScrollCallback = null;
    protected boolean inAppBrowserEnabled = true;
    protected Context mContext;
    private b params;
    private boolean processed = false;

    public JsInterface(Context context, Runnable runnable, b b2) {
        this.closeCallback = runnable;
        this.mContext = context;
        this.params = b2;
    }

    public JsInterface(Context context, Runnable runnable, b b2, boolean bl) {
        this(context, runnable, b2);
        this.inAppBrowserEnabled = bl;
    }

    public JsInterface(Context context, Runnable runnable, Runnable runnable2, b b2) {
        this(context, runnable, b2);
        this.clickCallback = runnable2;
    }

    public JsInterface(Context context, Runnable runnable, Runnable runnable2, Runnable runnable3, b b2, boolean bl) {
        this(context, runnable, b2, bl);
        this.clickCallback = runnable2;
        this.enableScrollCallback = runnable3;
    }

    @JavascriptInterface
    public void closeAd() {
        if (this.processed) {
            return;
        }
        this.processed = true;
        this.closeCallback.run();
    }

    @JavascriptInterface
    public void enableScroll(String string) {
        Runnable runnable = this.enableScrollCallback;
        if (runnable != null) {
            runnable.run();
        }
    }

    @JavascriptInterface
    public void externalLinks(String string) {
        if (this.inAppBrowserEnabled && i.a(256L)) {
            c.b(this.mContext, string, null);
            return;
        }
        c.c(this.mContext, string);
    }

    @JavascriptInterface
    public void openApp(String string, String string2, String string3) {
        if (string != null && !TextUtils.isEmpty((CharSequence)string)) {
            c.b(this.mContext, string, this.params);
        }
        Intent intent = this.mContext.getPackageManager().getLaunchIntentForPackage(string2);
        if (string3 != null) {
            try {
                JSONObject jSONObject = new JSONObject(string3);
                Iterator iterator = jSONObject.keys();
                while (iterator.hasNext()) {
                    String string4 = String.valueOf((Object)iterator.next());
                    intent.putExtra(string4, String.valueOf((Object)jSONObject.get(string4)));
                }
            }
            catch (JSONException jSONException) {
                g.a(6, "Couldn't parse intent details json!", jSONException);
            }
        }
        try {
            this.mContext.startActivity(intent);
        }
        catch (Exception exception) {
            String string5 = c.a(string, null);
            f.a(this.mContext, d.b, "JsInterface.openApp - Couldn't start activity", exception.getMessage(), string5);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Cannot find activity to handle url: [");
            stringBuilder.append(string);
            stringBuilder.append("]");
            g.a(6, stringBuilder.toString());
        }
        Runnable runnable = this.clickCallback;
        if (runnable != null) {
            runnable.run();
        }
    }
}

