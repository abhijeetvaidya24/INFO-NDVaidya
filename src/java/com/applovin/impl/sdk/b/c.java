/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Float
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Throwable
 *  java.lang.reflect.Field
 *  java.util.HashMap
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.applovin.impl.sdk.b;

import android.content.Context;
import android.content.SharedPreferences;
import com.applovin.impl.sdk.b.b;
import com.applovin.impl.sdk.e.d;
import com.applovin.impl.sdk.e.m;
import com.applovin.impl.sdk.j;
import com.applovin.impl.sdk.p;
import com.applovin.sdk.AppLovinAdType;
import com.applovin.sdk.AppLovinSdkSettings;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class c {
    protected final j a;
    protected final p b;
    protected final Context c;
    protected final SharedPreferences d;
    private final Map<String, Object> e = new HashMap();
    private Map<String, Object> f;

    public c(j j2) {
        this.a = j2;
        this.b = j2.u();
        this.c = j2.w();
        this.d = this.c.getSharedPreferences("com.applovin.sdk.1", 0);
        try {
            Field field = m.a(j2.l().getClass(), "localSettings");
            field.setAccessible(true);
            this.f = (HashMap)field.get((Object)j2.l());
        }
        catch (Throwable throwable) {}
    }

    private static Object a(String string2, JSONObject jSONObject, Object object) throws JSONException {
        if (object instanceof Boolean) {
            return jSONObject.getBoolean(string2);
        }
        if (object instanceof Float) {
            return Float.valueOf((float)((float)jSONObject.getDouble(string2)));
        }
        if (object instanceof Integer) {
            return jSONObject.getInt(string2);
        }
        if (object instanceof Long) {
            return jSONObject.getLong(string2);
        }
        if (object instanceof String) {
            return jSONObject.getString(string2);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SDK Error: unknown value type: ");
        stringBuilder.append((Object)object.getClass());
        throw new RuntimeException(stringBuilder.toString());
    }

    private <T> T c(b<T> b2) {
        T t2;
        try {
            t2 = b2.a(this.f.get((Object)b2.a()));
        }
        catch (Throwable throwable) {
            return null;
        }
        return t2;
    }

    private String e() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("com.applovin.sdk.");
        stringBuilder.append(m.a(this.a.s()));
        stringBuilder.append(".");
        return stringBuilder.toString();
    }

    public <ST> b<ST> a(String string2, b<ST> b2) {
        for (b b3 : b.c()) {
            if (!b3.a().equals((Object)string2)) continue;
            return b3;
        }
        return b2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public <T> T a(b<T> b2) {
        Map<String, Object> map;
        if (b2 == null) {
            throw new IllegalArgumentException("No setting type specified");
        }
        Map<String, Object> map2 = map = this.e;
        synchronized (map2) {
            try {
                block8 : {
                    T t2;
                    try {
                        t2 = this.c(b2);
                        if (t2 == null) break block8;
                    }
                    catch (Throwable throwable) {
                        p p2 = this.a.u();
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Unable to retrieve value for setting ");
                        stringBuilder.append(b2.a());
                        stringBuilder.append("; using default...");
                        p2.d("SettingsManager", stringBuilder.toString());
                        T t3 = b2.b();
                        return t3;
                    }
                    return t2;
                }
                Object object = this.e.get((Object)b2.a());
                if (object != null) {
                    T t4 = b2.a(object);
                    return t4;
                }
                T t5 = b2.b();
                return t5;
            }
            catch (Throwable throwable) {}
            throw throwable;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a() {
        Map<String, Object> map;
        if (this.c == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("No context specified");
            throw illegalArgumentException;
        }
        this.b.b("SettingsManager", "Saving settingsValues with the application...");
        String string2 = this.e();
        Map<String, Object> map2 = map = this.e;
        synchronized (map2) {
            SharedPreferences.Editor editor = this.d.edit();
            Iterator iterator = b.c().iterator();
            do {
                if (!iterator.hasNext()) {
                    editor.apply();
                    // MONITOREXIT [2, 3, 4] lbl13 : w: MONITOREXIT : var13_3
                    this.b.a("SettingsManager", "Settings saved with the application.");
                    return;
                }
                b b2 = (b)iterator.next();
                Object object = this.e.get((Object)b2.a());
                if (object == null) continue;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(string2);
                stringBuilder.append(b2.a());
                String string3 = stringBuilder.toString();
                this.a.a(string3, object, editor);
            } while (true);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public <T> void a(b<?> b2, Object object) {
        if (b2 == null) {
            throw new IllegalArgumentException("No setting type specified");
        }
        if (object != null) {
            Map<String, Object> map;
            Map<String, Object> map2 = map = this.e;
            synchronized (map2) {
                this.e.put((Object)b2.a(), object);
            }
            p p2 = this.b;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Setting update: ");
            stringBuilder.append(b2.a());
            stringBuilder.append(" set to \"");
            stringBuilder.append(object);
            stringBuilder.append("\"");
            p2.a("SettingsManager", stringBuilder.toString());
            return;
        }
        throw new IllegalArgumentException("No new value specified");
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public void a(AppLovinSdkSettings var1_1) {
        block25 : {
            block24 : {
                block28 : {
                    block27 : {
                        block26 : {
                            this.b.b("SettingsManager", "Loading user-defined settings");
                            if (var1_1 == null) {
                                return;
                            }
                            var26_3 = var2_2 = this.e;
                            // MONITORENTER : var26_3
                            if (this.a.a(b.U).booleanValue()) {
                                this.e.put((Object)b.U.a(), (Object)var1_1.isVerboseLoggingEnabled());
                            }
                            var4_4 = var1_1.getBannerAdRefreshSeconds();
                            var6_5 = 0L;
                            var8_6 = false;
                            if (var4_4 < var6_5) break block26;
                            if (var4_4 > var6_5) {
                                var6_5 = Math.max((long)30L, (long)var4_4);
                            }
                            this.e.put((Object)b.cy.a(), (Object)var6_5);
                            var9_7 = this.e;
                            var10_8 = b.cx.a();
                            var11_9 = true;
                            break block27;
                        }
                        if (var4_4 != -1L) break block28;
                        var9_7 = this.e;
                        var10_8 = b.cx.a();
                        var11_9 = false;
                    }
                    var9_7.put((Object)var10_8, (Object)var11_9);
                }
                if (this.a.a(b.bo).booleanValue()) {
                    var21_10 = var1_1.getAutoPreloadSizes();
                    if (!com.applovin.impl.sdk.e.j.b(var21_10)) {
                        var21_10 = "NONE";
                    }
                    if (var21_10.equals((Object)"NONE")) {
                        this.e.put((Object)b.aO.a(), (Object)"");
                    } else {
                        this.e.put((Object)b.aO.a(), (Object)var21_10);
                    }
                }
                if (this.a.a(b.bp).booleanValue()) {
                    var13_11 = var1_1.getAutoPreloadTypes();
                    if (!com.applovin.impl.sdk.e.j.b(var13_11)) {
                        var13_11 = "NONE";
                    }
                    if ("NONE".equals((Object)var13_11)) break block24;
                    var19_12 = d.a(var13_11).iterator();
                    var14_13 = false;
                    var15_14 = false;
                    break block25;
                }
                ** GOTO lbl70
            }
            var14_13 = false;
            var15_14 = false;
            var8_6 = false;
            ** GOTO lbl-1000
        }
        do {
            if (var19_12.hasNext()) {
                var20_15 = (String)var19_12.next();
                if (var20_15.equals((Object)AppLovinAdType.REGULAR.getLabel())) {
                    var8_6 = true;
                    continue;
                }
                if (!(var20_15.equals((Object)AppLovinAdType.INCENTIVIZED.getLabel()) || var20_15.contains((CharSequence)"INCENT") || var20_15.contains((CharSequence)"REWARD"))) {
                    if (!var20_15.equals((Object)AppLovinAdType.NATIVE.getLabel())) continue;
                    var15_14 = true;
                    continue;
                }
            } else lbl-1000: // 2 sources:
            {
                if (!var8_6) {
                    this.e.put((Object)b.aO.a(), (Object)"");
                }
                this.e.put((Object)b.aP.a(), (Object)var14_13);
                this.e.put((Object)b.aQ.a(), (Object)var15_14);
lbl70: // 2 sources:
                // MONITOREXIT : var26_3
                return;
            }
            var14_13 = true;
        } while (true);
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public void a(JSONObject jSONObject) {
        Map<String, Object> map;
        this.b.a("SettingsManager", "Loading settings...");
        Map<String, Object> map2 = map = this.e;
        // MONITORENTER : map2
        Iterator iterator = jSONObject.keys();
        do {
            int n2;
            if (!iterator.hasNext()) {
                // MONITOREXIT : map2
                return;
            }
            String string2 = (String)iterator.next();
            if (string2 == null || (n2 = string2.length()) <= 0) continue;
            try {
                b<ST> b2 = this.a(string2, null);
                if (b2 == null) continue;
                Object object = c.a(string2, jSONObject, b2.b());
                this.e.put((Object)b2.a(), object);
                if (b2 != b.eZ) continue;
                this.e.put((Object)b.fa.a(), (Object)System.currentTimeMillis());
                continue;
            }
            catch (Throwable throwable) {
                p p2;
                void var7_7;
                String string4;
                String string3;
                block8 : {
                    p2 = this.b;
                    string4 = "SettingsManager";
                    string3 = "Unable to convert setting object ";
                    break block8;
                    catch (JSONException jSONException) {
                        p2 = this.b;
                        string4 = "SettingsManager";
                        string3 = "Unable to parse JSON settingsValues array";
                    }
                }
                p2.b(string4, string3, (Throwable)var7_7);
                continue;
            }
            break;
        } while (true);
    }

    public List<String> b(b<String> b2) {
        return d.a(this.a(b2));
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void b() {
        Map<String, Object> map;
        if (this.c == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("No context specified");
            throw illegalArgumentException;
        }
        this.b.b("SettingsManager", "Loading settingsValues saved with the application...");
        String string2 = this.e();
        Map<String, Object> map2 = map = this.e;
        synchronized (map2) {
            Iterator iterator = b.c().iterator();
            while (iterator.hasNext()) {
                b b2 = (b)iterator.next();
                try {
                    Object t2;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(string2);
                    stringBuilder.append(b2.a());
                    String string3 = stringBuilder.toString();
                    Object var18_12 = this.a.a(string3, null, (t2 = b2.b()).getClass(), this.d);
                    if (var18_12 == null) continue;
                    this.e.put((Object)b2.a(), var18_12);
                }
                catch (Exception exception) {
                    p p2 = this.b;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Unable to load \"");
                    stringBuilder.append(b2.a());
                    stringBuilder.append("\"");
                    p2.b("SettingsManager", stringBuilder.toString(), exception);
                }
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void c() {
        Map<String, Object> map;
        Map<String, Object> map2 = map = this.e;
        synchronized (map2) {
            this.e.clear();
        }
        this.a.a(this.d);
    }

    public boolean d() {
        return this.a.l().isVerboseLoggingEnabled() || this.a(b.U).booleanValue();
        {
        }
    }
}

