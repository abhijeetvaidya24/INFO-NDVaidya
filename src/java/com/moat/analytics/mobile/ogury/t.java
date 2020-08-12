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
package com.moat.analytics.mobile.ogury;

import android.graphics.Rect;
import android.view.View;
import android.webkit.WebView;
import com.moat.analytics.mobile.ogury.NativeDisplayTracker;
import com.moat.analytics.mobile.ogury.c;
import com.moat.analytics.mobile.ogury.d;
import com.moat.analytics.mobile.ogury.e;
import com.moat.analytics.mobile.ogury.f;
import com.moat.analytics.mobile.ogury.i;
import com.moat.analytics.mobile.ogury.l;
import com.moat.analytics.mobile.ogury.v;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

final class t
extends c
implements NativeDisplayTracker {
    private final Map<String, String> \u02bc;
    private final Set<NativeDisplayTracker.MoatUserInteractionType> \u0971\u0971 = new HashSet();

    t(View view, Map<String, String> map) {
        super(view, true, false);
        e.1.\u02cb(3, "NativeDisplayTracker", this, "Initializing.");
        this.\u02bc = map;
        if (view == null) {
            String string = "NativeDisplayTracker initialization not successful, ".concat("Target view is null");
            e.1.\u02cb(3, "NativeDisplayTracker", this, string);
            e.1.\u0971("[ERROR] ", string);
            this.\u02ce = new l("Target view is null");
            return;
        }
        if (map != null && !map.isEmpty()) {
            d d2 = ((i)i.getInstance()).\u02ca;
            if (d2 == null) {
                String string = "NativeDisplayTracker initialization not successful, ".concat("prepareNativeDisplayTracking was not called successfully");
                e.1.\u02cb(3, "NativeDisplayTracker", this, string);
                e.1.\u0971("[ERROR] ", string);
                this.\u02ce = new l("prepareNativeDisplayTracking was not called successfully");
                return;
            }
            this.\u02cb = d2.\u02cb;
            try {
                super.\u02cb(d2.\u02ce);
                if (this.\u02cb != null) {
                    this.\u02cb.\u0971(this.\u141d());
                }
                StringBuilder stringBuilder = new StringBuilder("NativeDisplayTracker created for ");
                stringBuilder.append(this.\u02bb());
                stringBuilder.append(", with adIds:");
                stringBuilder.append(map.toString());
                e.1.\u0971("[SUCCESS] ", stringBuilder.toString());
                return;
            }
            catch (l l2) {
                this.\u02ce = l2;
                return;
            }
        }
        String string = "NativeDisplayTracker initialization not successful, ".concat("AdIds is null or empty");
        e.1.\u02cb(3, "NativeDisplayTracker", this, string);
        e.1.\u0971("[ERROR] ", string);
        this.\u02ce = new l("AdIds is null or empty");
    }

    private String \u02bc() {
        try {
            Rect rect = v.\u0971(super.\u0971\u0971());
            int n2 = rect.width();
            int n3 = rect.height();
            HashMap hashMap = new HashMap();
            hashMap.put((Object)"width", (Object)Integer.toString((int)n2));
            hashMap.put((Object)"height", (Object)Integer.toString((int)n3));
            String string = new JSONObject((Map)hashMap).toString();
            return string;
        }
        catch (Exception exception) {
            l.\u0971(exception);
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
            l.\u0971(exception);
            return "";
        }
        do {
            n3 = 0;
            if (n2 >= 8) break;
            String string = "moatClientLevel".concat(String.valueOf((int)n2));
            if (map.containsKey((Object)string)) {
                linkedHashMap.put((Object)string, map.get((Object)string));
            }
            ++n2;
        } while (true);
        do {
            if (n3 < 8) {
                String string = "moatClientSlicer".concat(String.valueOf((int)n3));
                if (map.containsKey((Object)string)) {
                    linkedHashMap.put((Object)string, map.get((Object)string));
                }
            } else {
                Iterator iterator = map.keySet().iterator();
                do {
                    if (!iterator.hasNext()) {
                        String string = new JSONObject((Map)linkedHashMap).toString();
                        e.1.\u02cb(3, "NativeDisplayTracker", this, "Parsed ad ids = ".concat(String.valueOf((Object)string)));
                        StringBuilder stringBuilder = new StringBuilder("{\"adIds\":");
                        stringBuilder.append(string);
                        stringBuilder.append(", \"adKey\":\"");
                        stringBuilder.append(this.\u0971);
                        stringBuilder.append("\", \"adSize\":");
                        stringBuilder.append(this.\u02bc());
                        stringBuilder.append("}");
                        return stringBuilder.toString();
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
                e.1.\u02cb(3, "NativeDisplayTracker", this, stringBuilder.toString());
                if (!this.\u0971\u0971.contains((Object)moatUserInteractionType)) {
                    this.\u0971\u0971.add((Object)moatUserInteractionType);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.accumulate("adKey", (Object)this.\u0971);
                    jSONObject.accumulate("event", (Object)moatUserInteractionType.name().toLowerCase());
                    if (this.\u02cb != null) {
                        this.\u02cb.\u02cb(jSONObject.toString());
                    }
                }
                return;
            }
            catch (Exception exception) {
            }
            catch (JSONException jSONException2) {
                break block5;
            }
            l.\u0971(exception);
            return;
        }
        e.1.\u02ce("NativeDisplayTracker", this, "Got JSON exception");
        l.\u0971((Exception)((Object)jSONException2));
    }

    @Override
    final String \u02cf() {
        return "NativeDisplayTracker";
    }
}

