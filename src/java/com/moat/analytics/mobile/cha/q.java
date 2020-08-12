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
package com.moat.analytics.mobile.cha;

import android.graphics.Rect;
import android.view.View;
import android.webkit.WebView;
import com.moat.analytics.mobile.cha.NativeDisplayTracker;
import com.moat.analytics.mobile.cha.a;
import com.moat.analytics.mobile.cha.d;
import com.moat.analytics.mobile.cha.f;
import com.moat.analytics.mobile.cha.j;
import com.moat.analytics.mobile.cha.o;
import com.moat.analytics.mobile.cha.u;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

final class q
extends d
implements NativeDisplayTracker {
    private final Map<String, String> \u02ca\u0971;
    private final Set<NativeDisplayTracker.MoatUserInteractionType> \u141d = new HashSet();

    q(View view, Map<String, String> map) {
        super(view, true, false);
        a.\u02cf(3, "NativeDisplayTracker", this, "Initializing.");
        this.\u02ca\u0971 = map;
        if (view == null) {
            StringBuilder stringBuilder = new StringBuilder("NativeDisplayTracker initialization not successful, ");
            stringBuilder.append("Target view is null");
            String string = stringBuilder.toString();
            a.\u02cf(3, "NativeDisplayTracker", this, string);
            a.\u02ca("[ERROR] ", string);
            this.\u0971 = new o("Target view is null");
            return;
        }
        if (map != null && !map.isEmpty()) {
            a a2 = ((f)f.getInstance()).\u0971;
            if (a2 == null) {
                StringBuilder stringBuilder = new StringBuilder("NativeDisplayTracker initialization not successful, ");
                stringBuilder.append("prepareNativeDisplayTracking was not called successfully");
                String string = stringBuilder.toString();
                a.\u02cf(3, "NativeDisplayTracker", this, string);
                a.\u02ca("[ERROR] ", string);
                this.\u0971 = new o("prepareNativeDisplayTracking was not called successfully");
                return;
            }
            this.\u02ce = a2.\u02cf;
            try {
                super.\u0971(a2.\u02cb);
                if (this.\u02ce != null) {
                    this.\u02ce.\u02cf(this.\u02ca\u0971());
                }
                StringBuilder stringBuilder = new StringBuilder("NativeDisplayTracker created for ");
                stringBuilder.append(this.\u02bb());
                stringBuilder.append(", with adIds:");
                stringBuilder.append(map.toString());
                a.\u02ca("[SUCCESS] ", stringBuilder.toString());
                return;
            }
            catch (o o2) {
                this.\u0971 = o2;
                return;
            }
        }
        StringBuilder stringBuilder = new StringBuilder("NativeDisplayTracker initialization not successful, ");
        stringBuilder.append("AdIds is null or empty");
        String string = stringBuilder.toString();
        a.\u02cf(3, "NativeDisplayTracker", this, string);
        a.\u02ca("[ERROR] ", string);
        this.\u0971 = new o("AdIds is null or empty");
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private String \u02ca\u0971() {
        int n2;
        LinkedHashMap linkedHashMap;
        int n3;
        Map<String, String> map;
        try {
            map = this.\u02ca\u0971;
            linkedHashMap = new LinkedHashMap();
            n2 = 0;
        }
        catch (Exception exception) {
            o.\u02ce(exception);
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
                        a.\u02cf(3, "NativeDisplayTracker", this, stringBuilder.toString());
                        StringBuilder stringBuilder2 = new StringBuilder("{\"adIds\":");
                        stringBuilder2.append(string);
                        stringBuilder2.append(", \"adKey\":\"");
                        stringBuilder2.append(this.\u02cb);
                        stringBuilder2.append("\", \"adSize\":");
                        stringBuilder2.append(this.\u141d());
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

    private String \u141d() {
        try {
            Rect rect = u.\u02cb(super.\u02bc());
            int n2 = rect.width();
            int n3 = rect.height();
            HashMap hashMap = new HashMap();
            hashMap.put((Object)"width", (Object)Integer.toString((int)n2));
            hashMap.put((Object)"height", (Object)Integer.toString((int)n3));
            String string = new JSONObject((Map)hashMap).toString();
            return string;
        }
        catch (Exception exception) {
            o.\u02ce(exception);
            return null;
        }
    }

    @Override
    public final void reportUserInteractionEvent(NativeDisplayTracker.MoatUserInteractionType moatUserInteractionType) {
        JSONException jSONException2;
        block5 : {
            try {
                StringBuilder stringBuilder = new StringBuilder("reportUserInteractionEvent:");
                stringBuilder.append(moatUserInteractionType.name());
                a.\u02cf(3, "NativeDisplayTracker", this, stringBuilder.toString());
                if (!this.\u141d.contains((Object)moatUserInteractionType)) {
                    this.\u141d.add((Object)moatUserInteractionType);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.accumulate("adKey", (Object)this.\u02cb);
                    jSONObject.accumulate("event", (Object)moatUserInteractionType.name().toLowerCase());
                    if (this.\u02ce != null) {
                        this.\u02ce.\u0971(jSONObject.toString());
                    }
                }
                return;
            }
            catch (Exception exception) {
            }
            catch (JSONException jSONException2) {
                break block5;
            }
            o.\u02ce(exception);
            return;
        }
        a.\u02cf("NativeDisplayTracker", this, "Got JSON exception");
        o.\u02ce((Exception)((Object)jSONException2));
    }

    @Override
    final String \u02cb() {
        return "NativeDisplayTracker";
    }
}

