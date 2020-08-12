/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Float
 *  java.lang.IllegalArgumentException
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.HashMap
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.applovin.impl.sdk.d;

import com.applovin.impl.sdk.ad.NativeAdImpl;
import com.applovin.impl.sdk.ad.d;
import com.applovin.impl.sdk.b.b;
import com.applovin.impl.sdk.c.i;
import com.applovin.impl.sdk.d.a;
import com.applovin.impl.sdk.e.g;
import com.applovin.impl.sdk.e.m;
import com.applovin.impl.sdk.j;
import com.applovin.nativeAds.AppLovinNativeAd;
import com.applovin.nativeAds.AppLovinNativeAdLoadListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class u
extends a {
    private final AppLovinNativeAdLoadListener a;
    private final JSONObject c;

    u(JSONObject jSONObject, j j2, AppLovinNativeAdLoadListener appLovinNativeAdLoadListener) {
        super("TaskRenderNativeAd", j2);
        this.a = appLovinNativeAdLoadListener;
        this.c = jSONObject;
    }

    private String a(String string, Map<String, String> map, String string2) {
        String string3 = (String)map.get((Object)string);
        if (string3 != null) {
            return string3.replace((CharSequence)"{CLCODE}", (CharSequence)string2);
        }
        return null;
    }

    private String a(Map<String, String> map, String string, String string2) {
        String string3 = (String)map.get((Object)"click_url");
        if (string2 == null) {
            string2 = "";
        }
        return string3.replace((CharSequence)"{CLCODE}", (CharSequence)string).replace((CharSequence)"{EVENT_ID}", (CharSequence)string2);
    }

    private void a(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = jSONObject;
        JSONArray jSONArray = jSONObject2.optJSONArray("native_ads");
        JSONObject jSONObject3 = jSONObject2.optJSONObject("native_settings");
        if (jSONArray != null && jSONArray.length() > 0) {
            List list = g.b(jSONArray);
            ArrayList arrayList = new ArrayList(list.size());
            HashMap hashMap = jSONObject3 != null ? g.a(jSONObject3) : new HashMap(0);
            HashMap hashMap2 = hashMap;
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                Map map = (Map)iterator.next();
                String string = (String)map.get((Object)"clcode");
                String string2 = g.a(jSONObject2, "zone_id", null, this.b);
                String string3 = (String)map.get((Object)"event_id");
                d d2 = d.b(string2, this.b);
                String string4 = this.a("simp_url", (Map<String, String>)hashMap2, string);
                String string5 = this.a((Map<String, String>)hashMap2, string, string3);
                List<com.applovin.impl.sdk.c.a> list2 = m.a("simp_urls", jSONObject3, string, string4, this.b);
                String string6 = g.a(jSONObject3, "should_post_click_url", true, this.b) != false ? string5 : null;
                j j2 = this.b;
                JSONObject jSONObject4 = jSONObject3;
                Iterator iterator2 = iterator;
                String string7 = string6;
                JSONObject jSONObject5 = jSONObject3;
                List<com.applovin.impl.sdk.c.a> list3 = m.a("click_tracking_urls", jSONObject4, string, string3, string7, j2);
                if (list2.size() != 0) {
                    if (list3.size() != 0) {
                        String string8 = (String)map.get((Object)"resource_cache_prefix");
                        List<String> list4 = string8 != null ? com.applovin.impl.sdk.e.d.a(string8) : this.b.b(b.bz);
                        NativeAdImpl nativeAdImpl = new Object(){
                            private d a;
                            private String b;
                            private String c;
                            private String d;
                            private String e;
                            private String f;
                            private String g;
                            private String h;
                            private String i;
                            private String j;
                            private String k;
                            private float l;
                            private String m;
                            private String n;
                            private String o;
                            private String p;
                            private String q;
                            private List<com.applovin.impl.sdk.c.a> r;
                            private List<com.applovin.impl.sdk.c.a> s;
                            private String t;
                            private String u;
                            private long v;
                            private List<String> w;
                            private j x;

                            public NativeAdImpl.a a(float f2) {
                                this.l = f2;
                                return this;
                            }

                            public NativeAdImpl.a a(long l2) {
                                this.v = l2;
                                return this;
                            }

                            public NativeAdImpl.a a(d d2) {
                                this.a = d2;
                                return this;
                            }

                            public NativeAdImpl.a a(j j2) {
                                this.x = j2;
                                return this;
                            }

                            public NativeAdImpl.a a(String string) {
                                this.c = string;
                                return this;
                            }

                            public NativeAdImpl.a a(List<com.applovin.impl.sdk.c.a> list) {
                                this.r = list;
                                return this;
                            }

                            public NativeAdImpl a() {
                                NativeAdImpl nativeAdImpl = new NativeAdImpl(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.p, this.q, this.r, this.s, this.t, this.u, this.v, this.w, this.x);
                                return nativeAdImpl;
                            }

                            public NativeAdImpl.a b(String string) {
                                this.d = string;
                                return this;
                            }

                            public NativeAdImpl.a b(List<com.applovin.impl.sdk.c.a> list) {
                                this.s = list;
                                return this;
                            }

                            public NativeAdImpl.a c(String string) {
                                this.e = string;
                                return this;
                            }

                            public NativeAdImpl.a c(List<String> list) {
                                this.w = list;
                                return this;
                            }

                            public NativeAdImpl.a d(String string) {
                                this.f = string;
                                return this;
                            }

                            public NativeAdImpl.a e(String string) {
                                this.b = string;
                                return this;
                            }

                            public NativeAdImpl.a f(String string) {
                                this.g = string;
                                return this;
                            }

                            public NativeAdImpl.a g(String string) {
                                this.h = string;
                                return this;
                            }

                            public NativeAdImpl.a h(String string) {
                                this.i = string;
                                return this;
                            }

                            public NativeAdImpl.a i(String string) {
                                this.j = string;
                                return this;
                            }

                            public NativeAdImpl.a j(String string) {
                                this.k = string;
                                return this;
                            }

                            public NativeAdImpl.a k(String string) {
                                this.m = string;
                                return this;
                            }

                            public NativeAdImpl.a l(String string) {
                                this.n = string;
                                return this;
                            }

                            public NativeAdImpl.a m(String string) {
                                this.o = string;
                                return this;
                            }

                            public NativeAdImpl.a n(String string) {
                                this.p = string;
                                return this;
                            }

                            public NativeAdImpl.a o(String string) {
                                this.q = string;
                                return this;
                            }

                            public NativeAdImpl.a p(String string) {
                                this.t = string;
                                return this;
                            }

                            public NativeAdImpl.a q(String string) {
                                this.u = string;
                                return this;
                            }
                        }.a(d2).e(string2).f((String)map.get((Object)"title")).g((String)map.get((Object)"description")).h((String)map.get((Object)"caption")).q((String)map.get((Object)"cta")).a((String)map.get((Object)"icon_url")).b((String)map.get((Object)"image_url")).d((String)map.get((Object)"video_url")).c((String)map.get((Object)"star_rating_url")).i((String)map.get((Object)"icon_url")).j((String)map.get((Object)"image_url")).k((String)map.get((Object)"video_url")).a(Float.parseFloat((String)((String)map.get((Object)"star_rating")))).p(string).l(string5).m(string4).n(this.a("video_start_url", (Map<String, String>)hashMap2, string)).o(this.a("video_end_url", (Map<String, String>)hashMap2, string)).a(list2).b(list3).a(Long.parseLong((String)((String)map.get((Object)"ad_id")))).c(list4).a(this.b).a();
                        arrayList.add((Object)nativeAdImpl);
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Prepared native ad: ");
                        stringBuilder.append(nativeAdImpl.getAdId());
                        this.a(stringBuilder.toString());
                        jSONObject2 = jSONObject;
                        jSONObject3 = jSONObject5;
                        iterator = iterator2;
                        continue;
                    }
                    throw new IllegalArgumentException("No click tracking URL available");
                }
                throw new IllegalArgumentException("No impression URL available");
            }
            AppLovinNativeAdLoadListener appLovinNativeAdLoadListener = this.a;
            if (appLovinNativeAdLoadListener != null) {
                appLovinNativeAdLoadListener.onNativeAdsLoaded((List<AppLovinNativeAd>)((List)arrayList));
                return;
            }
        } else {
            this.c("No ads were returned from the server");
            this.a.onNativeAdsFailedToLoad(204);
        }
    }

    @Override
    public i a() {
        return i.u;
    }

    void a(int n2) {
        try {
            if (this.a != null) {
                this.a.onNativeAdsFailedToLoad(n2);
                return;
            }
        }
        catch (Exception exception) {
            this.a("Unable to notify listener about failure.", exception);
        }
    }

    public void run() {
        try {
            if (this.c != null && this.c.length() != 0) {
                this.a(this.c);
                return;
            }
            this.a(-700);
            return;
        }
        catch (Exception exception) {
            this.a("Unable to render native ad.", exception);
            this.a(-700);
            this.b.E().a(this.a());
            return;
        }
    }
}

