/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 *  android.text.TextUtils
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Throwable
 *  java.util.HashMap
 *  java.util.List
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 *  java.util.UUID
 *  org.json.JSONObject
 */
package com.applovin.impl.sdk;

import android.content.Intent;
import android.text.TextUtils;
import com.applovin.impl.sdk.b.b;
import com.applovin.impl.sdk.b.d;
import com.applovin.impl.sdk.d.a;
import com.applovin.impl.sdk.d.i;
import com.applovin.impl.sdk.d.q;
import com.applovin.impl.sdk.e.j;
import com.applovin.impl.sdk.e.m;
import com.applovin.impl.sdk.k;
import com.applovin.impl.sdk.l;
import com.applovin.impl.sdk.network.PostbackServiceImpl;
import com.applovin.impl.sdk.network.e;
import com.applovin.impl.sdk.network.f;
import com.applovin.impl.sdk.p;
import com.applovin.sdk.AppLovinEventService;
import com.applovin.sdk.AppLovinPostbackListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import org.json.JSONObject;

public class EventServiceImpl
implements AppLovinEventService {
    private final com.applovin.impl.sdk.j a;
    private final List<String> b;

    public EventServiceImpl(com.applovin.impl.sdk.j j2) {
        this.a = j2;
        this.b = com.applovin.impl.sdk.e.d.a(j2.a(b.aK));
    }

    private String a() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.a.a(b.aF));
        stringBuilder.append("4.0/pix");
        return stringBuilder.toString();
    }

    private HashMap<String, String> a(l l2, k.a a2) {
        String string;
        k.c c2;
        Boolean bl;
        String string2;
        k k2 = this.a.G();
        k.d d2 = k2.a();
        k.b b2 = k2.c();
        boolean bl2 = this.b.contains((Object)l2.a());
        HashMap hashMap = new HashMap();
        String string3 = bl2 ? j.e(l2.a()) : "postinstall";
        hashMap.put((Object)"event", (Object)string3);
        hashMap.put((Object)"ts", (Object)Long.toString((long)l2.c()));
        hashMap.put((Object)"platform", (Object)j.e(d2.c));
        hashMap.put((Object)"model", (Object)j.e(d2.a));
        hashMap.put((Object)"package_name", (Object)j.e(b2.c));
        hashMap.put((Object)"installer_name", (Object)j.e(b2.d));
        hashMap.put((Object)"ia", (Object)Long.toString((long)b2.f));
        hashMap.put((Object)"api_did", (Object)this.a.a(b.R));
        hashMap.put((Object)"brand", (Object)j.e(d2.d));
        hashMap.put((Object)"brand_name", (Object)j.e(d2.e));
        hashMap.put((Object)"hardware", (Object)j.e(d2.f));
        hashMap.put((Object)"revision", (Object)j.e(d2.g));
        hashMap.put((Object)"sdk_version", (Object)"9.2.1");
        hashMap.put((Object)"os", (Object)j.e(d2.b));
        hashMap.put((Object)"orientation_lock", (Object)d2.l);
        hashMap.put((Object)"app_version", (Object)j.e(b2.b));
        hashMap.put((Object)"country_code", (Object)j.e(d2.i));
        hashMap.put((Object)"carrier", (Object)j.e(d2.j));
        hashMap.put((Object)"tz_offset", (Object)String.valueOf((double)d2.o));
        boolean bl3 = d2.q;
        String string4 = "1";
        String string5 = bl3 ? string4 : "0";
        hashMap.put((Object)"adr", (Object)string5);
        hashMap.put((Object)"volume", (Object)String.valueOf((int)d2.s));
        if (!d2.u) {
            string4 = "0";
        }
        hashMap.put((Object)"sim", (Object)string4);
        hashMap.put((Object)"gy", (Object)String.valueOf((boolean)d2.v));
        hashMap.put((Object)"tv", (Object)String.valueOf((boolean)d2.w));
        hashMap.put((Object)"tg", (Object)b2.e);
        hashMap.put((Object)"fs", (Object)String.valueOf((long)d2.y));
        if (!this.a.a(b.eX).booleanValue()) {
            hashMap.put((Object)"sdk_key", (Object)this.a.s());
        }
        this.a(a2, (Map<String, String>)hashMap);
        Boolean bl4 = d2.z;
        if (bl4 != null) {
            hashMap.put((Object)"huc", (Object)bl4.toString());
        }
        if ((bl = d2.A) != null) {
            hashMap.put((Object)"aru", (Object)bl.toString());
        }
        if ((c2 = d2.r) != null) {
            hashMap.put((Object)"act", (Object)String.valueOf((int)c2.a));
            hashMap.put((Object)"acm", (Object)String.valueOf((int)c2.b));
        }
        if (j.b(string2 = d2.t)) {
            hashMap.put((Object)"ua", (Object)j.e(string2));
        }
        if (!TextUtils.isEmpty((CharSequence)(string = d2.x))) {
            hashMap.put((Object)"so", (Object)j.e(string));
        }
        if (!bl2) {
            hashMap.put((Object)"sub_event", (Object)j.e(l2.a()));
        }
        hashMap.put((Object)"sc", (Object)j.e(this.a.a(b.V)));
        hashMap.put((Object)"sc2", (Object)j.e(this.a.a(b.W)));
        hashMap.put((Object)"server_installed_at", (Object)j.e(this.a.a(b.X)));
        m.a("persisted_data", j.e(this.a.a(d.r)), (Map<String, String>)hashMap);
        return hashMap;
    }

    private Map<String, String> a(Map<String, String> map) {
        HashMap hashMap = new HashMap();
        if (map != null) {
            for (Map.Entry entry : map.entrySet()) {
                String string;
                String string2;
                Object object = entry.getKey();
                Object object2 = entry.getValue();
                if (object instanceof String && object2 instanceof String) {
                    string = (String)object;
                    string2 = (String)object2;
                } else {
                    p p2 = this.a.u();
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Unexpected class type in trackEvent(); all keys and values passed as parameters must be String. Encountered ");
                    stringBuilder.append(object.getClass().getCanonicalName());
                    stringBuilder.append("/");
                    stringBuilder.append(object2.getClass().getCanonicalName());
                    stringBuilder.append("; will use toString() value instead, which may be unexpected...");
                    p2.c("EventServiceImpl", stringBuilder.toString());
                    string = object.toString();
                    string2 = object2.toString();
                }
                hashMap.put((Object)string, (Object)string2);
            }
        }
        return hashMap;
    }

    private void a(i.a a2) {
        i i2 = new i(this.a, a2);
        this.a.C().a(i2, q.a.c);
    }

    private void a(k.a a2, Map<String, String> map) {
        String string = a2.b;
        if (j.b(string)) {
            map.put((Object)"idfa", (Object)string);
        }
        map.put((Object)"dnt", (Object)Boolean.toString((boolean)a2.a));
    }

    private void a(final l l2, final boolean bl) {
        if (!this.a.a(b.aL).booleanValue()) {
            return;
        }
        p p2 = this.a.u();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Tracking event: ");
        stringBuilder.append((Object)l2);
        p2.a("EventServiceImpl", stringBuilder.toString());
        this.a(new i.a(){

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            @Override
            public void a(k.a a2) {
                HashMap hashMap;
                JSONObject jSONObject;
                try {
                    hashMap = EventServiceImpl.this.a(l2, a2);
                    Map<String, String> map = l2.b();
                    if (bl) {
                        EventServiceImpl.this.a.F().a(e.j().a(EventServiceImpl.this.a()).b(EventServiceImpl.this.b()).a((Map<String, String>)hashMap).b(map).a(EventServiceImpl.this.a.a(b.eX)).a());
                        return;
                    }
                    jSONObject = map != null ? new JSONObject(map) : null;
                }
                catch (Throwable throwable) {
                    p p2 = EventServiceImpl.this.a.u();
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Unable to track event due to failure to convert event parameters into JSONObject for event: ");
                    stringBuilder.append((Object)l2);
                    p2.b("EventServiceImpl", stringBuilder.toString(), throwable);
                    return;
                }
                f f2 = f.b(EventServiceImpl.this.a).d(EventServiceImpl.this.a()).f(EventServiceImpl.this.b()).b((Map<String, String>)hashMap).b(jSONObject).b(EventServiceImpl.this.a.a(b.eX)).b();
                EventServiceImpl.this.a.J().dispatchPostbackRequest(f2, null);
            }
        });
    }

    private void a(String string, Map<String, String> map, boolean bl) {
        l l2 = new l(string, this.a(map), System.currentTimeMillis(), j.f(UUID.randomUUID().toString()));
        this.a(l2, bl);
    }

    private String b() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.a.a(b.aG));
        stringBuilder.append("4.0/pix");
        return stringBuilder.toString();
    }

    void a(String string, boolean bl) {
        this.a(string, (Map<String, String>)new HashMap(), bl);
    }

    @Override
    public void trackCheckout(String string, Map<String, String> map) {
        HashMap hashMap = map != null ? new HashMap(map) : new HashMap(1);
        hashMap.put((Object)"transaction_id", (Object)string);
        this.trackEvent("checkout", (Map<String, String>)hashMap);
    }

    @Override
    public void trackEvent(String string) {
        this.trackEvent(string, (Map<String, String>)new HashMap());
    }

    @Override
    public void trackEvent(String string, Map<String, String> map) {
        this.a(string, map, true);
    }

    @Override
    public void trackInAppPurchase(Intent intent, Map<String, String> map) {
        HashMap hashMap = map != null ? new HashMap(map) : new HashMap();
        try {
            hashMap.put((Object)"receipt_data", (Object)intent.getStringExtra("INAPP_PURCHASE_DATA"));
            hashMap.put((Object)"receipt_data_signature", (Object)intent.getStringExtra("INAPP_DATA_SIGNATURE"));
        }
        catch (Exception exception) {
            this.a.u().c("EventServiceImpl", "Unable to track in app purchase; invalid purchanse intent", exception);
        }
        this.trackEvent("iap", (Map<String, String>)hashMap);
    }

}

