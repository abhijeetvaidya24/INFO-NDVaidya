/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.webkit.WebView
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.util.HashMap
 *  java.util.Iterator
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 *  org.json.JSONArray
 *  org.json.JSONObject
 */
package com.adcolony.sdk;

import android.app.Activity;
import android.content.Context;
import android.webkit.WebView;
import com.adcolony.sdk.AdColony;
import com.adcolony.sdk.AdColonyCustomMessageListener;
import com.adcolony.sdk.a;
import com.adcolony.sdk.ad;
import com.adcolony.sdk.au;
import com.adcolony.sdk.aw;
import com.adcolony.sdk.c;
import com.adcolony.sdk.g;
import com.adcolony.sdk.l;
import com.adcolony.sdk.w;
import com.integralads.avid.library.adcolony.deferred.AvidDeferredAdSessionListener;
import com.integralads.avid.library.adcolony.session.AvidAdSessionManager;
import com.integralads.avid.library.adcolony.session.AvidDisplayAdSession;
import com.integralads.avid.library.adcolony.session.AvidManagedVideoAdSession;
import com.integralads.avid.library.adcolony.session.AvidVideoAdSession;
import com.integralads.avid.library.adcolony.session.ExternalAvidAdSessionContext;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

class g {
    private AvidDisplayAdSession a;
    private AvidVideoAdSession b;
    private AvidManagedVideoAdSession c;
    private AdColonyCustomMessageListener d;
    private JSONArray e;
    private int f = -1;
    private String g = "";
    private int h;
    private boolean i;
    private boolean j;
    private boolean k;

    g(JSONObject jSONObject) {
        this.f = this.a(jSONObject);
        this.e = w.g(jSONObject, "js_resources");
    }

    int a(JSONObject jSONObject) {
        int n2 = this.f;
        if (n2 == -1) {
            this.h = w.c(jSONObject, "ad_unit_type");
            String string = w.b(jSONObject, "ad_type");
            int n3 = this.h;
            if (n3 == 0) {
                return 2;
            }
            if (n3 == 1) {
                if (string.equals((Object)"video")) {
                    return 2;
                }
                return 1;
            }
            return !string.equals((Object)"video");
        }
        return n2;
    }

    void a(c c2) {
        if (this.k) {
            return;
        }
        int n2 = this.f;
        if (n2 >= 0) {
            if (n2 == 2) {
                this.c();
            }
            this.b(c2);
            int n3 = this.f;
            if (n3 != 0) {
                if (n3 != 1) {
                    if (n3 == 2) {
                        this.c.getAvidDeferredAdSessionListener().recordReadyEvent();
                    }
                } else {
                    this.a.getAvidDeferredAdSessionListener().recordReadyEvent();
                }
            } else {
                this.b.getAvidDeferredAdSessionListener().recordReadyEvent();
            }
            this.k = true;
            this.a("record_ready");
        }
    }

    void a(String string) {
        JSONObject jSONObject = w.a();
        JSONObject jSONObject2 = w.a();
        w.b(jSONObject2, "session_type", this.f);
        w.a(jSONObject2, "session_id", this.g);
        w.a(jSONObject2, "event", string);
        w.a(jSONObject, "type", "ias_hook");
        w.a(jSONObject, "message", jSONObject2.toString());
        new ad("CustomMessage.controller_send", 0, jSONObject).b();
    }

    void b() {
        Context context;
        if (this.f >= 0 && (context = a.c()) != null) {
            au.a(new Runnable(){

                /*
                 * Enabled aggressive block sorting
                 */
                public void run() {
                    l l2 = a.a();
                    int n2 = g.this.d();
                    if (n2 != 0) {
                        if (n2 == 1) {
                            g.this.a = AvidAdSessionManager.startAvidDisplayAdSession(context, l2.C());
                            g g2 = g.this;
                            g2.g = g2.a.getAvidAdSessionId();
                            g.this.a("start_session");
                            return;
                        }
                        if (n2 != 2) {
                            return;
                        }
                        g.this.c = AvidAdSessionManager.startAvidManagedVideoAdSession(context, l2.C());
                        g g3 = g.this;
                        g3.g = g3.c.getAvidAdSessionId();
                        g.this.a("start_session");
                        for (int i2 = 0; i2 < g.this.e.length(); ++i2) {
                            g.this.c.injectJavaScriptResource(w.c(g.this.e, i2));
                            g.this.a("inject_javascript");
                        }
                        return;
                    } else {
                        g.this.b = AvidAdSessionManager.startAvidVideoAdSession(context, l2.C());
                        g g4 = g.this;
                        g4.g = g4.b.getAvidAdSessionId();
                        g.this.a("start_session");
                    }
                }
            });
        }
    }

    void b(c c2) {
        Context context = a.c();
        if (context != null) {
            AvidVideoAdSession avidVideoAdSession;
            if (!(context instanceof Activity)) {
                return;
            }
            this.a("register_ad_view");
            WebView webView = (WebView)a.a().x().get((Object)c2.c());
            if (webView == null && !c2.g().isEmpty()) {
                webView = (WebView)((Map.Entry)c2.g().entrySet().iterator().next()).getValue();
            }
            if ((avidVideoAdSession = this.b) != null && webView != null) {
                avidVideoAdSession.registerAdView(webView, (Activity)context);
                return;
            }
            AvidDisplayAdSession avidDisplayAdSession = this.a;
            if (avidDisplayAdSession != null && webView != null) {
                avidDisplayAdSession.registerAdView(webView, (Activity)context);
                if (this.h == 1 && c2 != null) {
                    JSONObject jSONObject = w.a();
                    w.a(jSONObject, "id", this.a.getAvidAdSessionId());
                    new ad("AdSession.send_avid_id", c2.c(), jSONObject).b();
                    return;
                }
            } else {
                AvidManagedVideoAdSession avidManagedVideoAdSession = this.c;
                if (avidManagedVideoAdSession != null) {
                    avidManagedVideoAdSession.registerAdView(c2, (Activity)context);
                    c2.a(this.c);
                    this.a("register_obstructions");
                }
            }
        }
    }

    /*
     * Exception decompiling
     */
    void b(String var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl280 : RETURN : trying to set 1 previously set to 0
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
        // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
        // org.benf.cfr.reader.b.a(Driver.java:128)
        // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
        // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
        // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
        // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1167)
        // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:641)
        // java.lang.Thread.run(Thread.java:919)
        throw new IllegalStateException("Decompilation failed");
    }

    void c() {
        this.d = new AdColonyCustomMessageListener(this){
            final /* synthetic */ g a;
            {
                this.a = g2;
            }

            public void onAdColonyCustomMessage(com.adcolony.sdk.AdColonyCustomMessage adColonyCustomMessage) {
                JSONObject jSONObject = w.a(adColonyCustomMessage.getMessage());
                String string = w.b(jSONObject, "event_type");
                boolean bl = w.d(jSONObject, "replay");
                boolean bl2 = w.b(jSONObject, "skip_type").equals((Object)"dec");
                if (string.equals((Object)"skip") && bl2) {
                    return;
                }
                if (!(bl && (string.equals((Object)"start") || string.equals((Object)"first_quartile") || string.equals((Object)"midpoint") || string.equals((Object)"third_quartile") || string.equals((Object)"complete")))) {
                    this.a.b(string);
                }
            }
        };
        AdColony.addCustomMessageListener(this.d, "ias_ad_event");
    }

    int d() {
        return this.f;
    }

    AvidManagedVideoAdSession e() {
        return this.c;
    }

    void f() {
        this.j = true;
    }

}

