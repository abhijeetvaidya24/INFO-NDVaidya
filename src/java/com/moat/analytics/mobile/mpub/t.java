/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  android.view.View
 *  android.webkit.WebView
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.HashMap
 *  java.util.HashSet
 *  java.util.LinkedHashMap
 *  java.util.Map
 *  java.util.Set
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.moat.analytics.mobile.mpub;

import android.graphics.Rect;
import android.view.View;
import android.webkit.WebView;
import com.moat.analytics.mobile.mpub.NativeDisplayTracker;
import com.moat.analytics.mobile.mpub.b;
import com.moat.analytics.mobile.mpub.g;
import com.moat.analytics.mobile.mpub.j;
import com.moat.analytics.mobile.mpub.k;
import com.moat.analytics.mobile.mpub.m;
import com.moat.analytics.mobile.mpub.p;
import com.moat.analytics.mobile.mpub.z;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

class t
extends b
implements NativeDisplayTracker {
    private final Map<String, String> g;
    private final Set<NativeDisplayTracker.MoatUserInteractionType> h;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    t(View view, Map<String, String> map) {
        m m2;
        block8 : {
            block6 : {
                g g2;
                block7 : {
                    m m3;
                    block5 : {
                        block4 : {
                            super(view, true, false);
                            this.h = new HashSet();
                            p.a(3, "NativeDisplayTracker", this, "Initializing.");
                            this.g = map;
                            if (view != null) break block4;
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("NativeDisplayTracker initialization not successful, ");
                            stringBuilder.append("Target view is null");
                            p.a("[ERROR] ", 3, "NativeDisplayTracker", this, stringBuilder.toString());
                            m3 = new m("Target view is null");
                            break block5;
                        }
                        if (map == null || map.isEmpty()) break block6;
                        g2 = ((k)k.getInstance()).d;
                        if (g2 != null) break block7;
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("NativeDisplayTracker initialization not successful, ");
                        stringBuilder.append("prepareNativeDisplayTracking was not called successfully");
                        p.a("[ERROR] ", 3, "NativeDisplayTracker", this, stringBuilder.toString());
                        m3 = new m("prepareNativeDisplayTracking was not called successfully");
                    }
                    this.a = m3;
                    return;
                }
                super.a(g2.b);
                try {
                    super.a(g2.a);
                    this.i();
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(this.a());
                    stringBuilder.append(" created for ");
                    stringBuilder.append(this.g());
                    stringBuilder.append(", with adIds:");
                    stringBuilder.append(map.toString());
                    p.a("[SUCCESS] ", stringBuilder.toString());
                    return;
                }
                catch (m m4) {}
                break block8;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("NativeDisplayTracker initialization not successful, ");
            stringBuilder.append("AdIds is null or empty");
            p.a("[ERROR] ", 3, "NativeDisplayTracker", this, stringBuilder.toString());
            m2 = new m("AdIds is null or empty");
        }
        this.a = m2;
    }

    private static String a(Map<String, String> map) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int n2 = 0;
        do {
            if (n2 >= 8) break;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("moatClientLevel");
            stringBuilder.append(n2);
            String string = stringBuilder.toString();
            if (map.containsKey((Object)string)) {
                linkedHashMap.put((Object)string, map.get((Object)string));
            }
            ++n2;
        } while (true);
        for (int i2 = 0; i2 < 8; ++i2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("moatClientSlicer");
            stringBuilder.append(i2);
            String string = stringBuilder.toString();
            if (!map.containsKey((Object)string)) continue;
            linkedHashMap.put((Object)string, map.get((Object)string));
        }
        for (String string : map.keySet()) {
            if (linkedHashMap.containsKey((Object)string)) continue;
            linkedHashMap.put((Object)string, (Object)((String)map.get((Object)string)));
        }
        return new JSONObject((Map)linkedHashMap).toString();
    }

    private void i() {
        if (this.c != null) {
            this.c.a(this.j());
        }
    }

    private String j() {
        try {
            String string = t.a(this.g);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Parsed ad ids = ");
            stringBuilder.append(string);
            p.a(3, "NativeDisplayTracker", this, stringBuilder.toString());
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("{\"adIds\":");
            stringBuilder2.append(string);
            stringBuilder2.append(", \"adKey\":\"");
            stringBuilder2.append(this.e);
            stringBuilder2.append("\", \"adSize\":");
            stringBuilder2.append(this.k());
            stringBuilder2.append("}");
            String string2 = stringBuilder2.toString();
            return string2;
        }
        catch (Exception exception) {
            m.a(exception);
            return "";
        }
    }

    private String k() {
        try {
            Rect rect = z.a(super.f());
            int n2 = rect.width();
            int n3 = rect.height();
            HashMap hashMap = new HashMap();
            hashMap.put((Object)"width", (Object)Integer.toString((int)n2));
            hashMap.put((Object)"height", (Object)Integer.toString((int)n3));
            String string = new JSONObject((Map)hashMap).toString();
            return string;
        }
        catch (Exception exception) {
            m.a(exception);
            return null;
        }
    }

    @Override
    String a() {
        return "NativeDisplayTracker";
    }

    @Override
    public void reportUserInteractionEvent(NativeDisplayTracker.MoatUserInteractionType moatUserInteractionType) {
        block5 : {
            void var3_6;
            try {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("reportUserInteractionEvent:");
                stringBuilder.append(moatUserInteractionType.name());
                p.a(3, "NativeDisplayTracker", this, stringBuilder.toString());
                if (!this.h.contains((Object)moatUserInteractionType)) {
                    this.h.add((Object)moatUserInteractionType);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.accumulate("adKey", (Object)this.e);
                    jSONObject.accumulate("event", (Object)moatUserInteractionType.name().toLowerCase());
                    if (this.c != null) {
                        this.c.b(jSONObject.toString());
                        return;
                    }
                }
                break block5;
            }
            catch (Exception exception) {
            }
            catch (JSONException jSONException) {
                p.b(2, "NativeDisplayTracker", this, "Got JSON exception");
            }
            m.a((Exception)var3_6);
        }
    }
}

