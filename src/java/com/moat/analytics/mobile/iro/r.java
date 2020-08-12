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
 *  java.util.Iterator
 *  java.util.LinkedHashMap
 *  java.util.Map
 *  java.util.Set
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.moat.analytics.mobile.iro;

import android.graphics.Rect;
import android.view.View;
import android.webkit.WebView;
import com.moat.analytics.mobile.iro.NativeDisplayTracker;
import com.moat.analytics.mobile.iro.b;
import com.moat.analytics.mobile.iro.c;
import com.moat.analytics.mobile.iro.f;
import com.moat.analytics.mobile.iro.j;
import com.moat.analytics.mobile.iro.o;
import com.moat.analytics.mobile.iro.y;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

final class r
extends c
implements NativeDisplayTracker {
    private final Set<NativeDisplayTracker.MoatUserInteractionType> \u02bb = new HashSet();
    private final Map<String, String> \u02bc;

    r(View view, Map<String, String> map) {
        super(view, true, false);
        b.\u02cf(3, "NativeDisplayTracker", this, "Initializing.");
        this.\u02bc = map;
        if (view == null) {
            StringBuilder stringBuilder = new StringBuilder("NativeDisplayTracker initialization not successful, ");
            stringBuilder.append("Target view is null");
            String string = stringBuilder.toString();
            b.\u02cf(3, "NativeDisplayTracker", this, string);
            b.\u02ce("[ERROR] ", string);
            this.\u02cb = new o("Target view is null");
            return;
        }
        if (map != null && !map.isEmpty()) {
            b b2 = ((j)j.getInstance()).\u02ca;
            if (b2 == null) {
                StringBuilder stringBuilder = new StringBuilder("NativeDisplayTracker initialization not successful, ");
                stringBuilder.append("prepareNativeDisplayTracking was not called successfully");
                String string = stringBuilder.toString();
                b.\u02cf(3, "NativeDisplayTracker", this, string);
                b.\u02ce("[ERROR] ", string);
                this.\u02cb = new o("prepareNativeDisplayTracking was not called successfully");
                return;
            }
            this.\u02cf = b2.\u02cb;
            try {
                super.\u02cb(b2.\u02cf);
                if (this.\u02cf != null) {
                    this.\u02cf.\u02ca(this.\u141d());
                }
                StringBuilder stringBuilder = new StringBuilder("NativeDisplayTracker created for ");
                stringBuilder.append(this.\u02bd());
                stringBuilder.append(", with adIds:");
                stringBuilder.append(map.toString());
                b.\u02ce("[SUCCESS] ", stringBuilder.toString());
                return;
            }
            catch (o o2) {
                this.\u02cb = o2;
                return;
            }
        }
        StringBuilder stringBuilder = new StringBuilder("NativeDisplayTracker initialization not successful, ");
        stringBuilder.append("AdIds is null or empty");
        String string = stringBuilder.toString();
        b.\u02cf(3, "NativeDisplayTracker", this, string);
        b.\u02ce("[ERROR] ", string);
        this.\u02cb = new o("AdIds is null or empty");
    }

    private String \u02ca\u0971() {
        try {
            Rect rect = y.\u02cf(super.\u02bb());
            int n2 = rect.width();
            int n3 = rect.height();
            HashMap hashMap = new HashMap();
            hashMap.put((Object)"width", (Object)Integer.toString((int)n2));
            hashMap.put((Object)"height", (Object)Integer.toString((int)n3));
            String string = new JSONObject((Map)hashMap).toString();
            return string;
        }
        catch (Exception exception) {
            o.\u0971(exception);
            return null;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private String \u141d() {
        int n2;
        LinkedHashMap linkedHashMap;
        int n3;
        Map<String, String> map;
        try {
            map = this.\u02bc;
            linkedHashMap = new LinkedHashMap();
            n2 = 0;
        }
        catch (Exception exception) {
            o.\u0971(exception);
            return "";
        }
        do {
            n3 = 0;
            if (n2 >= 8) break;
            StringBuilder stringBuilder = new StringBuilder("moatClientLevel");
            stringBuilder.append(n2);
            String string = stringBuilder.toString();
            if (map.containsKey((Object)string)) {
                linkedHashMap.put((Object)string, map.get((Object)string));
            }
            ++n2;
        } while (true);
        do {
            if (n3 < 8) {
                StringBuilder stringBuilder = new StringBuilder("moatClientSlicer");
                stringBuilder.append(n3);
                String string = stringBuilder.toString();
                if (map.containsKey((Object)string)) {
                    linkedHashMap.put((Object)string, map.get((Object)string));
                }
            } else {
                Iterator iterator = map.keySet().iterator();
                do {
                    if (!iterator.hasNext()) {
                        String string = new JSONObject((Map)linkedHashMap).toString();
                        StringBuilder stringBuilder = new StringBuilder("Parsed ad ids = ");
                        stringBuilder.append(string);
                        b.\u02cf(3, "NativeDisplayTracker", this, stringBuilder.toString());
                        StringBuilder stringBuilder2 = new StringBuilder("{\"adIds\":");
                        stringBuilder2.append(string);
                        stringBuilder2.append(", \"adKey\":\"");
                        stringBuilder2.append(this.\u02ce);
                        stringBuilder2.append("\", \"adSize\":");
                        stringBuilder2.append(this.\u02ca\u0971());
                        stringBuilder2.append("}");
                        return stringBuilder2.toString();
                    }
                    String string = (String)iterator.next();
                    if (linkedHashMap.containsKey((Object)string)) continue;
                    linkedHashMap.put((Object)string, (Object)((String)map.get((Object)string)));
                } while (true);
            }
            ++n3;
        } while (true);
    }

    @Override
    public final void reportUserInteractionEvent(NativeDisplayTracker.MoatUserInteractionType moatUserInteractionType) {
        JSONException jSONException2;
        block5 : {
            try {
                StringBuilder stringBuilder = new StringBuilder("reportUserInteractionEvent:");
                stringBuilder.append(moatUserInteractionType.name());
                b.\u02cf(3, "NativeDisplayTracker", this, stringBuilder.toString());
                if (!this.\u02bb.contains((Object)moatUserInteractionType)) {
                    this.\u02bb.add((Object)moatUserInteractionType);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.accumulate("adKey", (Object)this.\u02ce);
                    jSONObject.accumulate("event", (Object)moatUserInteractionType.name().toLowerCase());
                    if (this.\u02cf != null) {
                        this.\u02cf.\u02cb(jSONObject.toString());
                    }
                }
                return;
            }
            catch (Exception exception) {
            }
            catch (JSONException jSONException2) {
                break block5;
            }
            o.\u0971(exception);
            return;
        }
        b.\u02cf("NativeDisplayTracker", this, "Got JSON exception");
        o.\u0971((Exception)((Object)jSONException2));
    }

    @Override
    final String \u02ca() {
        return "NativeDisplayTracker";
    }
}

