/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Application
 *  android.webkit.WebView
 *  com.chartboost.sdk.impl.r
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.HashMap
 *  java.util.HashSet
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Set
 *  org.json.JSONArray
 */
package com.chartboost.sdk.impl;

import android.app.Application;
import android.webkit.WebView;
import com.chartboost.sdk.impl.p;
import com.chartboost.sdk.impl.r;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;

public class o {
    static List<String> a = new ArrayList();
    static HashMap<String, p> b = new HashMap();

    public static String a(HashSet<String> hashSet) {
        JSONArray jSONArray = new JSONArray();
        for (String string : hashSet) {
            if ((p)b.get((Object)string) == null) continue;
            jSONArray.put((Object)string);
        }
        return jSONArray.toString();
    }

    public static void a() {
        a.clear();
        if (o.b()) {
            a.add((Object)"moat");
        }
    }

    public static void a(Application application, boolean bl, boolean bl2, boolean bl3) {
        for (String string : b.keySet()) {
            if (!string.contains((CharSequence)"moat")) continue;
            if (b.get((Object)string) != null) {
                ((p)b.get((Object)string)).b();
            }
            r r2 = new r();
            r2.a(application, bl, bl2, bl3);
            b.put((Object)"moat", (Object)r2);
        }
    }

    public static void a(WebView webView, HashSet<String> hashSet) {
        for (String string : hashSet) {
            p p2 = (p)b.get((Object)string);
            if (p2 == null) continue;
            p2.a(webView);
        }
    }

    public static void a(List<String> list) {
        for (String string : list) {
            if (!a.contains((Object)string) || b.containsKey((Object)string)) continue;
            b.put((Object)string, null);
        }
    }

    static boolean b() {
        return true;
    }

    public static void c() {
        for (p p2 : b.values()) {
            if (p2 == null) continue;
            p2.a();
        }
    }

    public static void d() {
        for (String string : b.keySet()) {
            p p2 = (p)b.get((Object)string);
            if (p2 == null) continue;
            p2.b();
        }
    }

    public static JSONArray e() {
        JSONArray jSONArray = new JSONArray();
        List<String> list = a;
        if (list != null) {
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                jSONArray.put((Object)((String)iterator.next()));
            }
        }
        return jSONArray;
    }

    public static JSONArray f() {
        JSONArray jSONArray = new JSONArray();
        HashMap<String, p> hashMap = b;
        if (hashMap != null) {
            Iterator iterator = hashMap.keySet().iterator();
            while (iterator.hasNext()) {
                jSONArray.put((Object)((String)iterator.next()));
            }
        }
        return jSONArray;
    }
}

