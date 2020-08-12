/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Collections
 *  java.util.Iterator
 *  java.util.List
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.adcolony.sdk;

import com.adcolony.sdk.a;
import com.adcolony.sdk.ad;
import com.adcolony.sdk.aw;
import com.adcolony.sdk.l;
import com.adcolony.sdk.w;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class AdColonyEventTracker {
    private static final List<JSONObject> a = Collections.synchronizedList((List)new ArrayList());

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static void a() {
        List<JSONObject> list;
        if (l.B().equals((Object)"")) {
            return;
        }
        List<JSONObject> list2 = list = a;
        synchronized (list2) {
            Iterator iterator = a.iterator();
            do {
                if (!iterator.hasNext()) {
                    a.clear();
                    return;
                }
                AdColonyEventTracker.b((JSONObject)iterator.next());
            } while (true);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static void a(JSONObject jSONObject) {
        List<JSONObject> list;
        List<JSONObject> list2 = list = a;
        synchronized (list2) {
            if (200 > a.size()) {
                a.add((Object)jSONObject);
            }
            return;
        }
    }

    private static void b(JSONObject jSONObject) {
        a.a();
        if (l.B().equals((Object)"")) {
            AdColonyEventTracker.a(jSONObject);
            return;
        }
        AdColonyEventTracker.c(jSONObject);
        new ad("AdColony.log_event", 1, jSONObject).b();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static boolean b() {
        List<JSONObject> list;
        List<JSONObject> list2 = list = a;
        synchronized (list2) {
            if (a.size() == 0) return false;
            return true;
        }
    }

    private static void c(JSONObject jSONObject) {
        JSONObject jSONObject2 = w.f(jSONObject, "payload");
        if (aw.a) {
            w.a(jSONObject2, "api_key", "bb2cf0647ba654d7228dd3f9405bbc6a");
        } else {
            w.a(jSONObject2, "api_key", l.B());
        }
        try {
            jSONObject.remove("payload");
            jSONObject.put("payload", (Object)jSONObject2);
            return;
        }
        catch (JSONException jSONException) {
            jSONException.printStackTrace();
            return;
        }
    }
}

