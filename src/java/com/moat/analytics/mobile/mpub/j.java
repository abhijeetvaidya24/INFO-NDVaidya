/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentFilter
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.view.View
 *  android.webkit.ValueCallback
 *  android.webkit.WebSettings
 *  android.webkit.WebView
 *  androidx.localbroadcastmanager.content.LocalBroadcastManager
 *  com.moat.analytics.mobile.mpub.k
 *  java.lang.Enum
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.ref.WeakReference
 *  java.util.ArrayList
 *  java.util.HashMap
 *  java.util.Iterator
 *  java.util.LinkedList
 *  java.util.List
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 *  java.util.WeakHashMap
 *  java.util.concurrent.atomic.AtomicBoolean
 *  org.json.JSONObject
 */
package com.moat.analytics.mobile.mpub;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.view.View;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.moat.analytics.mobile.mpub.MoatAnalytics;
import com.moat.analytics.mobile.mpub.b;
import com.moat.analytics.mobile.mpub.i;
import com.moat.analytics.mobile.mpub.k;
import com.moat.analytics.mobile.mpub.m;
import com.moat.analytics.mobile.mpub.p;
import com.moat.analytics.mobile.mpub.s;
import com.moat.analytics.mobile.mpub.w;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

class j {
    private int a = 0;
    private boolean b = false;
    private boolean c = false;
    private final AtomicBoolean d = new AtomicBoolean(false);
    private boolean e = false;
    private boolean f = false;
    private boolean g = false;
    private final WeakReference<WebView> h;
    private final Map<b, String> i;
    private final LinkedList<String> j;
    private final long k;
    private final String l;
    private final List<String> m;
    private final a n;
    private final BroadcastReceiver o = new BroadcastReceiver(){

        public void onReceive(Context context, Intent intent) {
            try {
                j.this.d();
            }
            catch (Exception exception) {
                m.a(exception);
            }
            if (System.currentTimeMillis() - j.this.k > 30000L) {
                j.this.i();
            }
        }
    };
    private final BroadcastReceiver p = new BroadcastReceiver(){

        public void onReceive(Context context, Intent intent) {
            try {
                j.this.e();
                return;
            }
            catch (Exception exception) {
                m.a(exception);
                return;
            }
        }
    };

    j(WebView webView, a a2) {
        this.h = new WeakReference((Object)webView);
        this.n = a2;
        this.j = new LinkedList();
        this.m = new ArrayList();
        this.i = new WeakHashMap();
        this.k = System.currentTimeMillis();
        this.l = String.format((String)"javascript:(function(d,k){function l(){function d(a,b){var c=ipkn[b]||ipkn[kuea];if(c){var h=function(b){var c=b.b;c.ts=b.i;c.ticks=b.g;c.buffered=!0;a(c)};h(c.first);c.a.forEach(function(a){h(a)})}}function e(a){var b=a.a,c=a.c,h=a.b;a=a.f;var d=[];if(c)b[c]&&d.push(b[c].fn[0]);else for(key in b)if(b[key])for(var g=0,e=b[key].fn.length;g<e;g++)d.push(b[key].fn[g]);g=0;for(e=d.length;g<e;g++){var f=d[g];if('function'===typeof f)try{h?f(h):f()}catch(k){}a&&delete b[c]}}function f(a,b,c){'function'===typeof a&& (b===kuea&&c[b]?c[b].fn.push(a):c[b]={ts:+new Date,fn:[a]},c===yhgt&&d(a,b))}kuea=+new Date;iymv={};briz=!1;ewat=+new Date;bnkr=[];bjmk={};dptk={};uqaj={};ryup={};yhgt={};ipkn={};csif={};this.h=function(a){this.namespace=a.namespace;this.version=a.version;this.appName=a.appName;this.deviceOS=a.deviceOS;this.isNative=a.isNative;this.versionHash=a.versionHash;this.aqzx=a.aqzx;this.appId=a.appId;this.metadata=a};this.nvsj=function(a){briz||(f(a,ewat,iymv),briz=!0)};this.bpsy=function(a,b){var c=b||kuea; c!==kuea&&bjmk[c]||f(a,c,bjmk)};this.qmrv=function(a,b){var c=b||kuea;c!==kuea&&uqaj[c]||f(a,c,uqaj)};this.lgpr=function(a,b){f(a,b||kuea,yhgt)};this.hgen=function(a,b){f(a,b||kuea,csif)};this.xrnk=function(a){delete yhgt[a||kuea]};this.vgft=function(a){return dptk[a||kuea]||!1};this.lkpu=function(a){return ryup[a||kuea]||!1};this.crts=function(a){var b={a:iymv,b:a,c:ewat};briz?e(b):bnkr.push(a)};this.mqjh=function(a){var b=a||kuea;dptk[b]=!0;var c={a:bjmk,f:!0};b!==kuea&&(c.b=a,c.c=a);e(c)};this.egpw= function(a){var b=a||kuea;ryup[b]=!0;var c={a:uqaj,f:!0};b!==kuea&&(c.b=a,c.c=a);e(c)};this.sglu=function(a){var b=a.adKey||kuea,c={a:yhgt,b:a.event||a,g:1,i:+new Date,f:!1};b!==kuea&&(c.c=a.adKey);a=0<Object.keys(yhgt).length;if(!a||!this.isNative)if(ipkn[b]){var d=ipkn[b].a.slice(-1)[0]||ipkn[b].first;JSON.stringify(c.b)==JSON.stringify(d.b)?d.g+=1:(5<=ipkn[b].a.length&&ipkn[b].a.shift(),ipkn[b].a.push(c))}else ipkn[b]={first:c,a:[]};a&&e(c);return a};this.ucbx=function(a){e({c:a.adKey||kuea,a:csif, b:a.event,f:!1})}}'undefined'===typeof d.MoatMAK&&(d.MoatMAK=new l,d.MoatMAK.h(k),d.__zMoatInit__=!0)})(window,%s);", (Object[])new Object[]{this.h()});
        if (this.d("Initialize")) {
            IntentFilter intentFilter = new IntentFilter("UPDATE_METADATA");
            IntentFilter intentFilter2 = new IntentFilter("UPDATE_VIEW_INFO");
            LocalBroadcastManager.getInstance((Context)s.c()).registerReceiver(this.o, intentFilter);
            LocalBroadcastManager.getInstance((Context)s.c()).registerReceiver(this.p, intentFilter2);
            this.d();
            i.a().a(s.c(), this);
            p.a(3, "JavaScriptBridge", this, "bridge initialization succeeded");
        }
    }

    private boolean a(WebView webView) {
        return webView.getSettings().getJavaScriptEnabled();
    }

    static /* synthetic */ int b(j j2) {
        int n2 = j2.a;
        j2.a = n2 + 1;
        return n2;
    }

    private void c() {
        Iterator iterator = this.i.entrySet().iterator();
        while (iterator.hasNext()) {
            b b2 = (b)((Map.Entry)iterator.next()).getKey();
            if (!b2.e()) continue;
            Object[] arrobject = new Object[]{b2.e};
            this.g(String.format((String)"javascript: if(typeof MoatMAK !== 'undefined'){MoatMAK.mqjh(\"%s\");}", (Object[])arrobject));
        }
    }

    private void d() {
        w w2 = w.a();
        try {
            if (w2.a == w.d.a) {
                return;
            }
            if (!this.c) {
                p.a(3, "JavaScriptBridge", this, "Attempting to establish communication (setting environment variables).");
                this.c = true;
            }
            this.g(this.l);
            return;
        }
        catch (Exception exception) {
            p.a("JavaScriptBridge", this, "Attempt failed to establish communication (did not set environment variables).", exception);
            return;
        }
    }

    private void d(b b2) {
        p.a(3, "JavaScriptBridge", this, "Stopping view update loop");
        if (b2 != null) {
            i.a().a(b2);
        }
    }

    private boolean d(String string2) {
        WebView webView = this.g();
        if (webView != null) {
            if (this.a(webView)) {
                return true;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("JavaScript is not enabled in the given WebView. Can't ");
            stringBuilder.append(string2);
            p.a(6, "JavaScriptBridge", this, stringBuilder.toString());
            throw new m("JavaScript is not enabled in the WebView");
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("WebView is null. Can't ");
        stringBuilder.append(string2);
        p.a(6, "JavaScriptBridge", this, stringBuilder.toString());
        throw new m("WebView is null");
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @TargetApi(value=19)
    private void e() {
        Iterator iterator;
        try {
            if (w.a().a == w.d.a) {
                return;
            }
            boolean bl2 = this.g;
            if (bl2) {
                p.a(3, "JavaScriptBridge", this, "Can't send info, already cleaned up");
                return;
            }
            if (this.f() && (!this.b || this.g().getUrl() != null)) {
                if (this.g().getUrl() != null) {
                    this.b = true;
                }
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("WebView became null");
                String string2 = this.g() == null ? "" : "based on null url";
                stringBuilder.append(string2);
                stringBuilder.append(", stopping tracking loop");
                p.a(3, "JavaScriptBridge", this, stringBuilder.toString());
                this.b();
                return;
            }
            iterator = this.i.entrySet().iterator();
        }
        catch (Exception exception) {
            m.a(exception);
            this.b();
            return;
        }
        while (iterator.hasNext()) {
            b b2;
            block15 : {
                block14 : {
                    b2 = (b)((Map.Entry)iterator.next()).getKey();
                    if (b2 != null && b2.f() != null) break block14;
                    p.a(3, "JavaScriptBridge", this, "Tracker has no subject");
                    if (b2 == null || !b2.f) break block15;
                }
                if (!b2.e()) continue;
                if (!this.d.get()) {
                    Object[] arrobject = new Object[]{b2.e};
                    this.g(String.format((String)"javascript: if(typeof MoatMAK !== 'undefined'){MoatMAK.mqjh(\"%s\");}", (Object[])arrobject));
                }
                String string3 = String.format((String)"javascript: if(typeof MoatMAK !== 'undefined'){MoatMAK.sglu(%s);}", (Object[])new Object[]{b2.h()});
                if (Build.VERSION.SDK_INT >= 19) {
                    this.g().evaluateJavascript(string3, (ValueCallback)new ValueCallback<String>(){

                        public void a(String string2) {
                            String string3 = "null";
                            if (string2 != null && !string2.equalsIgnoreCase(string3) && !string2.equalsIgnoreCase("false")) {
                                if (string2.equalsIgnoreCase("true")) {
                                    if (!j.this.f) {
                                        j.this.f = true;
                                        p.a(3, "JavaScriptBridge", j.this, "Javascript has found ad");
                                        j.this.a();
                                    }
                                    j.this.a = 0;
                                    return;
                                }
                                j j2 = j.this;
                                StringBuilder stringBuilder = new StringBuilder();
                                stringBuilder.append("Received unusual value from Javascript:");
                                stringBuilder.append(string2);
                                p.a(3, "JavaScriptBridge", j2, stringBuilder.toString());
                                return;
                            }
                            j j3 = j.this;
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("Received value is:");
                            if (string2 != null) {
                                StringBuilder stringBuilder2 = new StringBuilder();
                                stringBuilder2.append("(String)");
                                stringBuilder2.append(string2);
                                string3 = stringBuilder2.toString();
                            }
                            stringBuilder.append(string3);
                            p.a(3, "JavaScriptBridge", j3, stringBuilder.toString());
                            if (j.this.a >= 150) {
                                p.a(3, "JavaScriptBridge", j.this, "Giving up on finding ad");
                                j.this.b();
                            }
                            j.b(j.this);
                            if (string2 != null && string2.equalsIgnoreCase("false") && !j.this.e) {
                                j.this.e = true;
                                p.a(3, "JavaScriptBridge", j.this, "Bridge connection established");
                            }
                        }

                        public /* synthetic */ void onReceiveValue(Object object) {
                            this.a((String)object);
                        }
                    });
                    continue;
                }
                this.g().loadUrl(string3);
                continue;
            }
            this.c(b2);
        }
    }

    private void e(String string2) {
        if (this.m.size() >= 50) {
            this.m.subList(0, 25).clear();
        }
        this.m.add((Object)string2);
    }

    private void f(String string2) {
        if (this.d.get()) {
            this.g(string2);
            return;
        }
        this.e(string2);
    }

    private boolean f() {
        return this.g() != null;
    }

    private WebView g() {
        return (WebView)this.h.get();
    }

    private void g(String string2) {
        if (this.g) {
            p.a(3, "JavaScriptBridge", this, "Can't send, already cleaned up");
            return;
        }
        if (this.f()) {
            p.b(2, "JavaScriptBridge", this, string2);
            if (Build.VERSION.SDK_INT >= 19) {
                this.g().evaluateJavascript(string2, null);
                return;
            }
            this.g().loadUrl(string2);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private String h() {
        String string2;
        s.b b2;
        String string3;
        String string4;
        String string5;
        String string6;
        HashMap hashMap;
        String string7;
        String string8;
        String string9;
        String string10;
        block4 : {
            block3 : {
                try {
                    s.a a2 = s.d();
                    b2 = s.e();
                    hashMap = new HashMap();
                    string3 = a2.a();
                    string10 = a2.b();
                    string2 = a2.c();
                    string5 = Integer.toString((int)Build.VERSION.SDK_INT);
                    string8 = s.b();
                    a a3 = this.n;
                    a a4 = a.a;
                    string6 = "0";
                    string4 = a3 == a4 ? string6 : "1";
                    string7 = b2.e ? "1" : string6;
                    string9 = b2.d ? "1" : string6;
                    if (!((k)MoatAnalytics.getInstance()).b()) break block3;
                    break block4;
                }
                catch (Exception exception) {
                    return "{}";
                }
            }
            string6 = "1";
        }
        hashMap.put((Object)"versionHash", (Object)"9d24c90729bf464dce5d8fd1ace14a60656dbb2d");
        hashMap.put((Object)"appName", (Object)string3);
        hashMap.put((Object)"namespace", (Object)"MPUB");
        hashMap.put((Object)"version", (Object)"2.4.5");
        hashMap.put((Object)"deviceOS", (Object)string5);
        hashMap.put((Object)"isNative", (Object)string4);
        hashMap.put((Object)"appId", (Object)string10);
        hashMap.put((Object)"source", (Object)string2);
        hashMap.put((Object)"carrier", (Object)b2.b);
        hashMap.put((Object)"sim", (Object)b2.a);
        hashMap.put((Object)"phone", (Object)String.valueOf((Object)b2.c));
        hashMap.put((Object)"buildFp", (Object)Build.FINGERPRINT);
        hashMap.put((Object)"buildModel", (Object)Build.MODEL);
        hashMap.put((Object)"buildMfg", (Object)Build.MANUFACTURER);
        hashMap.put((Object)"buildBrand", (Object)Build.BRAND);
        hashMap.put((Object)"buildProduct", (Object)Build.PRODUCT);
        hashMap.put((Object)"buildTags", (Object)Build.TAGS);
        hashMap.put((Object)"f1", (Object)string9);
        hashMap.put((Object)"f2", (Object)string7);
        hashMap.put((Object)"locationEnabled", (Object)string6);
        if (string8 == null) return new JSONObject((Map)hashMap).toString();
        hashMap.put((Object)"aqzx", (Object)string8);
        return new JSONObject((Map)hashMap).toString();
    }

    private void i() {
        p.a(3, "JavaScriptBridge", this, "Stopping metadata reporting loop");
        i.a().a(this);
        LocalBroadcastManager.getInstance((Context)s.c()).unregisterReceiver(this.o);
    }

    void a() {
        p.a(3, "JavaScriptBridge", this, "webViewReady");
        if (this.d.compareAndSet(false, true)) {
            p.a(3, "JavaScriptBridge", this, "webViewReady first time");
            this.i();
            Iterator iterator = this.m.iterator();
            while (iterator.hasNext()) {
                this.g((String)iterator.next());
            }
            this.m.clear();
        }
        this.c();
    }

    void a(b b2) {
        if (b2 != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("adding tracker");
            stringBuilder.append(b2.e);
            p.a(3, "JavaScriptBridge", this, stringBuilder.toString());
            this.i.put((Object)b2, (Object)"");
        }
    }

    void a(String string2) {
        this.f(String.format((String)"javascript: if(typeof MoatMAK !== 'undefined'){MoatMAK.crts(%s);}", (Object[])new Object[]{string2}));
    }

    void a(String string2, JSONObject jSONObject) {
        if (this.g) {
            p.a(3, "JavaScriptBridge", this, "Can't dispatch, already cleaned up");
            return;
        }
        String string3 = jSONObject.toString();
        if (this.d.get() && this.f()) {
            this.g(String.format((String)"javascript:%s.dispatchEvent(%s);", (Object[])new Object[]{string2, string3}));
            return;
        }
        this.j.add((Object)string3);
    }

    void b() {
        p.a(3, "JavaScriptBridge", this, "Cleaning up");
        this.g = true;
        this.i();
        Iterator iterator = this.i.entrySet().iterator();
        while (iterator.hasNext()) {
            this.d((b)((Map.Entry)iterator.next()).getKey());
        }
        this.i.clear();
        LocalBroadcastManager.getInstance((Context)s.c()).unregisterReceiver(this.p);
    }

    void b(b b2) {
        if (this.d("startTracking")) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Starting tracking on tracker");
            stringBuilder.append(b2.e);
            p.a(3, "JavaScriptBridge", this, stringBuilder.toString());
            Object[] arrobject = new Object[]{b2.e};
            this.g(String.format((String)"javascript: if(typeof MoatMAK !== 'undefined'){MoatMAK.mqjh(\"%s\");}", (Object[])arrobject));
            i.a().a(s.c(), b2);
        }
    }

    void b(String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("markUserInteractionEvent:");
        stringBuilder.append(string2);
        p.a(3, "JavaScriptBridge", this, stringBuilder.toString());
        this.f(String.format((String)"javascript: if(typeof MoatMAK !== 'undefined'){MoatMAK.ucbx(%s);}", (Object[])new Object[]{string2}));
    }

    void c(b b2) {
        boolean bl2 = this.g;
        m m2 = null;
        if (!bl2) {
            block9 : {
                boolean bl3 = this.d("stopTracking");
                m2 = null;
                if (!bl3) break block9;
                try {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Ending tracking on tracker");
                    stringBuilder.append(b2.e);
                    p.a(3, "JavaScriptBridge", this, stringBuilder.toString());
                    Object[] arrobject = new Object[]{b2.e};
                    this.g(String.format((String)"javascript: if(typeof MoatMAK !== 'undefined'){MoatMAK.egpw(\"%s\");}", (Object[])arrobject));
                    m2 = null;
                }
                catch (Exception exception) {
                    try {
                        p.a("JavaScriptBridge", this, "Failed to end impression.", exception);
                        m2 = null;
                    }
                    catch (m m3) {
                        m2 = m3;
                    }
                }
            }
            if (this.n == a.b) {
                this.d(b2);
            } else {
                this.b();
            }
            this.i.remove((Object)b2);
        }
        if (m2 == null) {
            return;
        }
        throw m2;
    }

    void c(String string2) {
        p.a(3, "JavaScriptBridge", this, "flushDispatchQueue");
        if (this.j.size() >= 200) {
            LinkedList linkedList = new LinkedList();
            for (int i2 = 0; i2 < 10; ++i2) {
                linkedList.addFirst((Object)((String)this.j.removeFirst()));
            }
            int n2 = Math.min((int)(200 + Math.min((int)(this.j.size() / 200), (int)10)), (int)this.j.size());
            for (int i3 = 0; i3 < n2; ++i3) {
                this.j.removeFirst();
            }
            for (String string3 : linkedList) {
                this.j.addFirst((Object)string3);
            }
        }
        if (!this.j.isEmpty()) {
            StringBuilder stringBuilder = new StringBuilder();
            String string4 = "";
            for (int i4 = 1; !this.j.isEmpty() && i4 < 200; ++i4) {
                String string5 = (String)this.j.removeFirst();
                if (stringBuilder.length() + string5.length() > 2000) break;
                stringBuilder.append(string4);
                stringBuilder.append(string5);
                string4 = ",";
            }
            Object[] arrobject = new Object[]{string2, stringBuilder.toString()};
            this.g(String.format((String)"javascript:%s.dispatchMany([%s])", (Object[])arrobject));
        }
        this.j.clear();
    }

    protected void finalize() {
        try {
            super.finalize();
            p.a(3, "JavaScriptBridge", this, "finalize");
            this.b();
            return;
        }
        catch (Exception exception) {
            m.a(exception);
            return;
        }
    }

    static final class a
    extends Enum<a> {
        public static final /* enum */ a a = new a();
        public static final /* enum */ a b = new a();
        public static final /* enum */ a c = new a();
        private static final /* synthetic */ a[] d;

        static {
            a[] arra = new a[]{a, b, c};
            d = arra;
        }

        public static a valueOf(String string2) {
            return (a)Enum.valueOf(a.class, (String)string2);
        }

        public static a[] values() {
            return (a[])d.clone();
        }
    }

}

