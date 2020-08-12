/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.List
 *  org.json.JSONArray
 *  org.json.JSONObject
 */
package io.presage;

import io.presage.BrillatSavarin;
import io.presage.CantalEntreDeux;
import io.presage.CapGrisNez;
import io.presage.cl;
import io.presage.common.network.models.RewardItem;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class Camembertbio {
    public static final Camembertbio a = new Camembertbio();

    private Camembertbio() {
    }

    public static CantalEntreDeux a(String string2, String string3) {
        JSONObject jSONObject = new JSONObject(string2);
        List list = (List)new ArrayList();
        JSONArray jSONArray = jSONObject.optJSONArray("ad");
        if (jSONArray == null) {
            jSONArray = new JSONArray();
        }
        int n2 = jSONArray.length();
        for (int i2 = 0; i2 < n2; ++i2) {
            String string4;
            String string5;
            String string6;
            BrillatSavarin brillatSavarin = new BrillatSavarin();
            JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
            JSONObject jSONObject3 = jSONObject2.optJSONObject("format");
            String string7 = jSONObject2.optString("ad_content");
            cl.a((Object)string7, "adJson.optString(\"ad_content\")");
            brillatSavarin.b(string7);
            String string8 = jSONObject2.toString();
            cl.a((Object)string8, "adJson.toString()");
            brillatSavarin.c(string8);
            String string9 = jSONObject2.optString("impression_url");
            cl.a((Object)string9, "adJson.optString(\"impression_url\")");
            brillatSavarin.e(string9);
            String string10 = jSONObject2.optString("id");
            cl.a((Object)string10, "adJson.optString(\"id\")");
            brillatSavarin.a(string10);
            JSONObject jSONObject4 = jSONObject2.optJSONObject("advertiser");
            if (jSONObject4 == null || (string4 = jSONObject4.optString("id")) == null) {
                string4 = "";
            }
            brillatSavarin.f(string4);
            String string11 = jSONObject2.optString("campaign_id");
            cl.a((Object)string11, "adJson.optString(\"campaign_id\")");
            brillatSavarin.g(string11);
            if (jSONObject3 == null || (string5 = jSONObject3.optString("webview_base_url")) == null) {
                string5 = "";
            }
            brillatSavarin.h(string5);
            if (jSONObject3 == null || (string6 = jSONObject3.optString("mraid_download_url")) == null) {
                string6 = "";
            }
            brillatSavarin.k(string6);
            brillatSavarin.b(jSONObject2.optBoolean("moat", false));
            brillatSavarin.a(Camembertbio.a(jSONObject2.optJSONObject("ad_unit"), jSONObject2.optString("id")));
            cl.a((Object)jSONObject2, "adJson");
            brillatSavarin.d(Camembertbio.a("orientation", jSONObject2));
            JSONObject jSONObject5 = jSONObject2.optJSONObject("format");
            JSONArray jSONArray2 = jSONObject5 != null ? jSONObject5.optJSONArray("params") : null;
            brillatSavarin.j(Camembertbio.a(jSONArray2));
            brillatSavarin.i(Camembertbio.a(jSONObject2));
            brillatSavarin.a(jSONObject2.optBoolean("has_transparency", false));
            String string12 = jSONObject2.optString("sdk_close_button_url", "");
            cl.a((Object)string12, "adJson.optString(\"sdk_close_button_url\", \"\")");
            brillatSavarin.l(string12);
            String string13 = jSONObject2.optString("landing_page_prefetch_url", "");
            cl.a((Object)string13, "adJson.optString(\"landing_page_prefetch_url\", \"\")");
            brillatSavarin.m(string13);
            brillatSavarin.c(jSONObject2.optBoolean("landing_page_disable_javascript", false));
            String string14 = jSONObject2.optString("landing_page_prefetch_whitelist", "");
            cl.a((Object)string14, "adJson.optString(\"landin\u2026_prefetch_whitelist\", \"\")");
            brillatSavarin.n(string14);
            if (!cl.a((Object)brillatSavarin.k().c(), (Object)string3)) continue;
            list.add((Object)brillatSavarin);
        }
        return new CantalEntreDeux((List<BrillatSavarin>)list);
    }

    private static CapGrisNez a(JSONObject jSONObject, String string2) {
        CapGrisNez capGrisNez = new CapGrisNez();
        if (jSONObject == null) {
            return capGrisNez;
        }
        String string3 = jSONObject.optString("id");
        if (string3 == null) {
            string3 = "";
        }
        capGrisNez.a(string3);
        if (string2 == null) {
            string2 = "";
        }
        capGrisNez.b(string2);
        String string4 = jSONObject.optString("type");
        if (string4 == null) {
            string4 = "";
        }
        capGrisNez.c(string4);
        if (cl.a((Object)capGrisNez.c(), (Object)"optin_video")) {
            String string5 = jSONObject.optString("app_user_id");
            if (string5 == null) {
                string5 = "";
            }
            capGrisNez.e(string5);
            String string6 = jSONObject.optString("reward_launch");
            if (string6 == null) {
                string6 = "";
            }
            capGrisNez.d(string6);
            RewardItem rewardItem = capGrisNez.e();
            String string7 = jSONObject.optString("reward_name");
            if (string7 == null) {
                string7 = "";
            }
            rewardItem.setName(string7);
            RewardItem rewardItem2 = capGrisNez.e();
            String string8 = jSONObject.optString("reward_value");
            if (string8 == null) {
                string8 = "";
            }
            rewardItem2.setValue(string8);
        }
        return capGrisNez;
    }

    private static String a(String string2, JSONObject jSONObject) {
        JSONArray jSONArray = jSONObject.optJSONArray("params");
        if (jSONArray == null) {
            return "";
        }
        int n2 = jSONArray.length();
        for (int i2 = 0; i2 < n2; ++i2) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
            if (!cl.a((Object)jSONObject2.getString("name"), (Object)string2)) continue;
            String string3 = jSONObject2.getString("value");
            cl.a((Object)string3, "paramElement.getString(\"value\")");
            return string3;
        }
        return "";
    }

    private static String a(JSONArray jSONArray) {
        if (jSONArray == null) {
            return "";
        }
        for (int i2 = -1 + jSONArray.length(); i2 >= 0; --i2) {
            String string2;
            JSONObject jSONObject;
            JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
            if (!cl.a((Object)jSONObject2.getString("name"), (Object)"zones")) continue;
            JSONArray jSONArray2 = jSONObject2.optJSONArray("value");
            if (jSONArray2 == null || (jSONObject = jSONArray2.optJSONObject(0)) == null || (string2 = jSONObject.optString("name")) == null) {
                string2 = "";
            }
            return string2;
        }
        return "";
    }

    private static String a(JSONObject jSONObject) {
        String string2 = jSONObject.optString("client_tracker_pattern", "");
        if (cl.a((Object)string2, (Object)"null")) {
            string2 = "";
        }
        cl.a((Object)string2, "clientTrackerPattern");
        return string2;
    }
}

