/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.ActivityInfo
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.ResolveInfo
 *  android.os.SystemClock
 *  android.util.Base64
 *  com.yandex.metrica.impl.am
 *  com.yandex.metrica.impl.bi
 *  com.yandex.metrica.impl.bk
 *  java.io.File
 *  java.io.UnsupportedEncodingException
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  java.util.HashSet
 *  java.util.Iterator
 *  java.util.List
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.yandex.metrica.impl;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.SystemClock;
import android.util.Base64;
import com.yandex.metrica.impl.am;
import com.yandex.metrica.impl.bi;
import com.yandex.metrica.impl.bk;
import com.yandex.metrica.impl.utils.b;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class t {
    JSONObject a;

    public t(String string2) {
        try {
            this.a = new JSONObject(string2);
            return;
        }
        catch (Exception exception) {
            this.a = new JSONObject();
            return;
        }
    }

    static <T> T a(JSONObject jSONObject, String string2, T t2) throws JSONException {
        if (!jSONObject.has(string2)) {
            jSONObject.put(string2, t2);
        }
        return (T)jSONObject.get(string2);
    }

    public t a() {
        try {
            this.c();
            this.b();
        }
        catch (Exception exception) {}
        return this;
    }

    t a(Context context) throws JSONException {
        JSONObject jSONObject = t.a(t.a(this.a, "dfid", new JSONObject()), "apps", new JSONObject());
        JSONArray jSONArray = t.a(jSONObject, "names", new JSONArray());
        JSONArray jSONArray2 = t.a(jSONObject, "system_flags", new JSONArray());
        JSONArray jSONArray3 = t.a(jSONObject, "disabled_flags", new JSONArray());
        JSONArray jSONArray4 = t.a(jSONObject, "first_install_time", new JSONArray());
        JSONArray jSONArray5 = t.a(jSONObject, "last_update_time", new JSONArray());
        jSONObject.put("version", 0);
        for (PackageInfo packageInfo : context.getPackageManager().getInstalledPackages(0)) {
            jSONArray.put((Object)packageInfo.packageName);
            boolean bl2 = (1 & packageInfo.applicationInfo.flags) == 1;
            jSONArray2.put(bl2);
            jSONArray3.put(true ^ packageInfo.applicationInfo.enabled);
            jSONArray4.put(packageInfo.firstInstallTime / 1000L);
            jSONArray5.put(packageInfo.lastUpdateTime / 1000L);
        }
        return this;
    }

    t a(Context context, boolean bl2) throws JSONException, UnsupportedEncodingException {
        JSONObject jSONObject = t.a(t.a(this.a, "dfid", new JSONObject()), "au", new JSONObject());
        JSONArray jSONArray = t.a(jSONObject, "aun", new JSONArray());
        JSONArray jSONArray2 = t.a(jSONObject, "ausf", new JSONArray());
        JSONArray jSONArray3 = t.a(jSONObject, "audf", new JSONArray());
        JSONArray jSONArray4 = t.a(jSONObject, "aulu", new JSONArray());
        JSONArray jSONArray5 = new JSONArray();
        if (bl2) {
            t.a(jSONObject, "aufi", jSONArray5);
        }
        HashSet hashSet = new HashSet();
        Iterator iterator = bk.a((Context)context, (String)new String(Base64.decode((String)"YW5kcm9pZC5pbnRlbnQuYWN0aW9uLk1BSU4=", (int)0), "UTF-8"), (String)new String(Base64.decode((String)"YW5kcm9pZC5pbnRlbnQuY2F0ZWdvcnkuTEFVTkNIRVI=", (int)0), "UTF-8")).iterator();
        while (iterator.hasNext()) {
            ApplicationInfo applicationInfo = ((ResolveInfo)iterator.next()).activityInfo.applicationInfo;
            if (!hashSet.add((Object)applicationInfo.packageName)) continue;
            jSONArray.put((Object)applicationInfo.packageName);
            boolean bl3 = (1 & applicationInfo.flags) == 1;
            jSONArray2.put(bl3);
            jSONArray4.put(new File(applicationInfo.sourceDir).lastModified());
            jSONArray3.put(true ^ applicationInfo.enabled);
            if (!bl2) continue;
            if (bl3) {
                jSONArray5.put(0);
                continue;
            }
            if (bk.c((Context)context, (String)applicationInfo.packageName) == null) {
                jSONArray5.put(0);
                continue;
            }
            jSONArray5.put(bk.c((Context)context, (String)applicationInfo.packageName).firstInstallTime / 1000L);
        }
        return this;
    }

    t b() throws JSONException {
        t.a(this.a, "dfid", new JSONObject()).put("boot_time", (System.currentTimeMillis() - SystemClock.elapsedRealtime()) / 1000L);
        return this;
    }

    t c() throws JSONException {
        JSONObject jSONObject = t.a(this.a, "dfid", new JSONObject());
        long l2 = am.a((boolean)true);
        long l3 = am.a((boolean)false);
        long l4 = am.c((boolean)true);
        long l5 = am.c((boolean)false);
        jSONObject.put("tds", l2 + l3);
        jSONObject.put("fds", l4 + l5);
        return this;
    }

    public String d() {
        return Base64.encodeToString((byte[])new b().a(bi.c((String)this.a.toString())), (int)0);
    }

    public String toString() {
        return this.a.toString();
    }
}

