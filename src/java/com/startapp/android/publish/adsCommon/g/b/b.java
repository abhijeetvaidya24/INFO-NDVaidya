/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Build
 *  android.os.Build$VERSION
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.List
 */
package com.startapp.android.publish.adsCommon.g.b;

import android.content.Context;
import android.os.Build;
import com.startapp.common.a.c;
import com.startapp.common.a.g;
import java.util.ArrayList;
import java.util.List;

public class b {
    private Context a;
    private List<String> b;

    public b(Context context) {
        this.a = context.getApplicationContext();
        this.b = new ArrayList();
    }

    public boolean a() {
        boolean bl = this.b.contains((Object)"calendar") && Build.VERSION.SDK_INT >= 14 && c.a(this.a, "android.permission.WRITE_CALENDAR");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("isCalendarSupported ");
        stringBuilder.append(bl);
        g.a("MraidNativeFeatureManager", 3, stringBuilder.toString());
        return bl;
    }

    public boolean a(String string) {
        return this.f().contains((Object)string);
    }

    public boolean b() {
        boolean bl = this.b.contains((Object)"inlineVideo");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("isInlineVideoSupported ");
        stringBuilder.append(bl);
        g.a("MraidNativeFeatureManager", 3, stringBuilder.toString());
        return bl;
    }

    public boolean c() {
        boolean bl = this.b.contains((Object)"sms") && c.a(this.a, "android.permission.SEND_SMS");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("isSmsSupported ");
        stringBuilder.append(bl);
        g.a("MraidNativeFeatureManager", 3, stringBuilder.toString());
        return bl;
    }

    public boolean d() {
        boolean bl = this.b.contains((Object)"storePicture");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("isStorePictureSupported ");
        stringBuilder.append(bl);
        g.a("MraidNativeFeatureManager", 3, stringBuilder.toString());
        return bl;
    }

    public boolean e() {
        boolean bl = this.b.contains((Object)"tel") && c.a(this.a, "android.permission.CALL_PHONE");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("isTelSupported ");
        stringBuilder.append(bl);
        g.a("MraidNativeFeatureManager", 3, stringBuilder.toString());
        return bl;
    }

    public List<String> f() {
        return this.b;
    }
}

