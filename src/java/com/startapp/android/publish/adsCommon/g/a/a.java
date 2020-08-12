/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.net.URLDecoder
 *  java.util.Map
 */
package com.startapp.android.publish.adsCommon.g.a;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import com.startapp.android.publish.adsCommon.f.d;
import com.startapp.android.publish.adsCommon.f.f;
import com.startapp.android.publish.adsCommon.g.a.b;
import com.startapp.common.a.c;
import com.startapp.common.a.g;
import java.net.URLDecoder;
import java.util.Map;

public abstract class a
implements b {
    private static final String TAG = "BaseMraidController";
    protected a openListener;

    public a(a a2) {
        this.openListener = a2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    protected void applyOrientationProperties(Activity activity, com.startapp.android.publish.adsCommon.g.c.a a2) {
        try {
            int n2 = activity.getResources().getConfiguration().orientation == 1 ? 1 : 0;
            int n3 = a2.b == 0 ? 1 : (a2.b == 1 ? 0 : (a2.a ? -1 : n2));
            c.a(activity, n3);
            return;
        }
        catch (Exception exception) {
            f.a((Context)activity, d.b, "BaseMraidController.applyOrientationProperties", exception.getMessage(), "");
            return;
        }
    }

    public abstract void close();

    public void createCalendarEvent(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("createCalendarEvent ");
        stringBuilder.append(string);
        g.a("BaseMraidController", 3, stringBuilder.toString());
        this.isFeatureSupported("calendar");
    }

    public void expand(String string) {
        g.a("BaseMraidController", 3, "expand");
    }

    public abstract boolean isFeatureSupported(String var1);

    @Override
    public boolean open(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("open ");
        stringBuilder.append(string);
        g.a("BaseMraidController", 3, stringBuilder.toString());
        try {
            string = URLDecoder.decode((String)string, (String)"UTF-8").trim();
            if (string.startsWith("sms")) {
                return this.openSMS(string);
            }
            if (string.startsWith("tel")) {
                return this.openTel(string);
            }
            boolean bl = this.openListener.a(string);
            return bl;
        }
        catch (Exception exception) {
            g.a("BaseMraidController", 6, exception.getMessage());
            return this.openListener.a(string);
        }
    }

    public boolean openSMS(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("openSMS ");
        stringBuilder.append(string);
        g.a("BaseMraidController", 3, stringBuilder.toString());
        this.isFeatureSupported("sms");
        return true;
    }

    public boolean openTel(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("openTel ");
        stringBuilder.append(string);
        g.a("BaseMraidController", 3, stringBuilder.toString());
        this.isFeatureSupported("tel");
        return true;
    }

    public void playVideo(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("playVideo ");
        stringBuilder.append(string);
        g.a("BaseMraidController", 3, stringBuilder.toString());
        this.isFeatureSupported("inlineVideo");
    }

    public void resize() {
        g.a("BaseMraidController", 3, "resize");
    }

    public abstract void setOrientationProperties(Map<String, String> var1);

    public void setResizeProperties(Map<String, String> map) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("setResizeProperties ");
        stringBuilder.append(map);
        g.a("BaseMraidController", 3, stringBuilder.toString());
    }

    public void storePicture(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("storePicture ");
        stringBuilder.append(string);
        g.a("BaseMraidController", 3, stringBuilder.toString());
        this.isFeatureSupported("storePicture");
    }

    public abstract void useCustomClose(String var1);

}

