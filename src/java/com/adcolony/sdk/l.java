/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Application
 *  android.app.Application$ActivityLifecycleCallbacks
 *  android.content.Context
 *  android.os.Build
 *  android.os.Build$VERSION
 *  com.adcolony.sdk.AdColony
 *  com.adcolony.sdk.AdColonyAppOptions
 *  com.adcolony.sdk.AdColonyCustomMessageListener
 *  com.adcolony.sdk.AdColonyEventTracker
 *  com.adcolony.sdk.AdColonyInterstitial
 *  com.adcolony.sdk.AdColonyInterstitialListener
 *  com.adcolony.sdk.AdColonyRewardListener
 *  com.adcolony.sdk.AdColonyZone
 *  com.adcolony.sdk.a
 *  com.adcolony.sdk.aa
 *  com.adcolony.sdk.ad
 *  com.adcolony.sdk.ae
 *  com.adcolony.sdk.af
 *  com.adcolony.sdk.ag
 *  com.adcolony.sdk.ah
 *  com.adcolony.sdk.aj
 *  com.adcolony.sdk.am
 *  com.adcolony.sdk.ap
 *  com.adcolony.sdk.ar
 *  com.adcolony.sdk.au
 *  com.adcolony.sdk.ax
 *  com.adcolony.sdk.c
 *  com.adcolony.sdk.d
 *  com.adcolony.sdk.l$10
 *  com.adcolony.sdk.l$3$1
 *  com.adcolony.sdk.l$5
 *  com.adcolony.sdk.l$6
 *  com.adcolony.sdk.l$7
 *  com.adcolony.sdk.l$8
 *  com.adcolony.sdk.l$9
 *  com.adcolony.sdk.n
 *  com.adcolony.sdk.o
 *  com.adcolony.sdk.p
 *  com.adcolony.sdk.p$a
 *  com.adcolony.sdk.t
 *  com.adcolony.sdk.w
 *  com.adcolony.sdk.y
 *  com.adcolony.sdk.y$a
 *  java.io.File
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Thread
 *  java.lang.Throwable
 *  java.util.HashMap
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 *  java.util.concurrent.ConcurrentHashMap
 *  java.util.concurrent.ExecutorService
 *  org.json.JSONArray
 *  org.json.JSONObject
 */
package com.adcolony.sdk;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import com.adcolony.sdk.AdColony;
import com.adcolony.sdk.AdColonyAppOptions;
import com.adcolony.sdk.AdColonyCustomMessageListener;
import com.adcolony.sdk.AdColonyEventTracker;
import com.adcolony.sdk.AdColonyInterstitial;
import com.adcolony.sdk.AdColonyInterstitialListener;
import com.adcolony.sdk.AdColonyRewardListener;
import com.adcolony.sdk.AdColonyZone;
import com.adcolony.sdk.a;
import com.adcolony.sdk.aa;
import com.adcolony.sdk.ad;
import com.adcolony.sdk.ae;
import com.adcolony.sdk.af;
import com.adcolony.sdk.ag;
import com.adcolony.sdk.ah;
import com.adcolony.sdk.aj;
import com.adcolony.sdk.am;
import com.adcolony.sdk.ap;
import com.adcolony.sdk.ar;
import com.adcolony.sdk.au;
import com.adcolony.sdk.aw;
import com.adcolony.sdk.ax;
import com.adcolony.sdk.c;
import com.adcolony.sdk.d;
import com.adcolony.sdk.l;
import com.adcolony.sdk.m;
import com.adcolony.sdk.n;
import com.adcolony.sdk.o;
import com.adcolony.sdk.p;
import com.adcolony.sdk.q;
import com.adcolony.sdk.t;
import com.adcolony.sdk.w;
import com.adcolony.sdk.y;
import com.integralads.avid.library.adcolony.session.ExternalAvidAdSessionContext;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import org.json.JSONArray;
import org.json.JSONObject;

class l
implements p.a {
    private static volatile String H = "";
    static String e = "https://adc3-launch.adcolony.com/v4/launch";
    private HashMap<String, AdColonyZone> A = new HashMap();
    private HashMap<Integer, aw> B = new HashMap();
    private String C;
    private String D;
    private String E;
    private String F;
    private String G = "";
    private boolean I;
    private boolean J;
    private boolean K;
    private boolean L;
    private boolean M;
    private boolean N;
    private boolean O;
    private boolean P;
    private boolean Q;
    private boolean R;
    private int S;
    private int T = 1;
    private final int U = 120;
    private Application.ActivityLifecycleCallbacks V;
    private ExternalAvidAdSessionContext W;
    n c;
    ah d;
    boolean f;
    private m g;
    private ae h;
    private q i;
    private am j;
    private d k;
    private o l;
    private t m;
    private ar n;
    private ap o;
    private aa p;
    private c q;
    private ax r;
    private AdColonyInterstitial s;
    private AdColonyRewardListener t;
    private HashMap<String, AdColonyCustomMessageListener> u = new HashMap();
    private AdColonyAppOptions v;
    private ad w;
    private boolean x;
    private ad y;
    private JSONObject z;

    l() {
    }

    static String B() {
        return H;
    }

    private void D() {
        JSONObject jSONObject = w.a();
        w.a((JSONObject)jSONObject, (String)"type", (String)"AdColony.on_configuration_completed");
        JSONArray jSONArray = new JSONArray();
        Iterator iterator = this.f().keySet().iterator();
        while (iterator.hasNext()) {
            jSONArray.put((Object)((String)iterator.next()));
        }
        JSONObject jSONObject2 = w.a();
        w.a((JSONObject)jSONObject2, (String)"zone_ids", (JSONArray)jSONArray);
        w.a((JSONObject)jSONObject, (String)"message", (JSONObject)jSONObject2);
        new ad("CustomMessage.controller_send", 0, jSONObject).b();
    }

    private void E() {
        new Thread((Runnable)new 5(this)).start();
    }

    private void F() {
        if (a.a().k().e()) {
            this.S = 1 + this.S;
            int n2 = this.T;
            int n3 = this.S;
            int n4 = n2 * n3;
            int n5 = 120;
            if (n4 <= n5) {
                n5 = n2 * n3;
            }
            this.T = n5;
            au.a((Runnable)new 7(this));
            return;
        }
        new y.a().a("Max launch server download attempts hit, or AdColony is no longer").a(" active.").a(y.f);
    }

    private boolean G() {
        this.h.a();
        return true;
    }

    private void H() {
        Context context = a.c();
        if (context != null && this.V == null && Build.VERSION.SDK_INT > 14) {
            this.V = new 10(this);
            Application application = context instanceof Application ? (Application)context : ((Activity)context).getApplication();
            application.registerActivityLifecycleCallbacks(this.V);
        }
    }

    private boolean a(JSONObject jSONObject) {
        if (!this.M) {
            new y.a().a("Non-standard launch. Downloading new controller.").a(y.f);
            return true;
        }
        JSONObject jSONObject2 = this.z;
        if (jSONObject2 != null && w.b((JSONObject)w.f((JSONObject)jSONObject2, (String)"controller"), (String)"sha1").equals((Object)w.b((JSONObject)w.f((JSONObject)jSONObject, (String)"controller"), (String)"sha1"))) {
            return false;
        }
        new y.a().a("Controller sha1 does not match, downloading new controller.").a(y.f);
        return true;
    }

    private boolean a(boolean bl, boolean bl2) {
        if (!a.d()) {
            return false;
        }
        this.P = bl2;
        this.M = bl;
        if (bl && !bl2 && !this.G()) {
            return false;
        }
        this.E();
        return true;
    }

    private void b(JSONObject jSONObject) {
        if (!aw.a) {
            JSONObject jSONObject2 = w.f((JSONObject)jSONObject, (String)"logging");
            aa.k = w.a((JSONObject)jSONObject2, (String)"send_level", (int)1);
            aa.a = w.d((JSONObject)jSONObject2, (String)"log_private");
            aa.i = w.a((JSONObject)jSONObject2, (String)"print_level", (int)3);
            this.p.a(w.g((JSONObject)jSONObject2, (String)"modules"));
        }
        this.c.a(w.f((JSONObject)jSONObject, (String)"metadata"));
        this.G = w.b((JSONObject)w.f((JSONObject)jSONObject, (String)"controller"), (String)"version");
    }

    private boolean b(String string) {
        Context context = a.c();
        if (context != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(context.getFilesDir().getAbsolutePath());
            stringBuilder.append("/adc3/");
            stringBuilder.append("7bf3a1e7bbd31e612eda3310c2cdb8075c43c6b5");
            File file = new File(stringBuilder.toString());
            if (file.exists()) {
                return au.a((String)string, (File)file);
            }
        }
        return false;
    }

    static /* synthetic */ ad c(l l2, ad ad2) {
        l2.w = ad2;
        return ad2;
    }

    static /* synthetic */ boolean c(l l2, boolean bl) {
        l2.J = bl;
        return bl;
    }

    /*
     * Exception decompiling
     */
    private boolean c(JSONObject var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl64.1 : ALOAD_0 : trying to set 1 previously set to 0
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

    static /* synthetic */ ap e(l l2) {
        return l2.o;
    }

    private boolean e(boolean bl) {
        return this.a(bl, false);
    }

    static /* synthetic */ ae f(l l2) {
        return l2.h;
    }

    private void f(ad ad2) {
        this.a(w.c((JSONObject)ad2.c(), (String)"id"));
    }

    static /* synthetic */ HashMap g(l l2) {
        return l2.B;
    }

    private void g(ad ad2) {
        JSONObject jSONObject = this.v.d;
        w.a((JSONObject)jSONObject, (String)"app_id", (String)this.v.a);
        w.a((JSONObject)jSONObject, (String)"zone_ids", (JSONArray)this.v.c);
        JSONObject jSONObject2 = w.a();
        w.a((JSONObject)jSONObject2, (String)"options", (JSONObject)jSONObject);
        ad2.a(jSONObject2).b();
    }

    static /* synthetic */ void h(l l2) {
        l2.E();
    }

    static /* synthetic */ int i(l l2) {
        return l2.T;
    }

    static /* synthetic */ boolean j(l l2) {
        return l2.G();
    }

    static /* synthetic */ AdColonyRewardListener k(l l2) {
        return l2.t;
    }

    static /* synthetic */ am l(l l2) {
        return l2.j;
    }

    static /* synthetic */ ad m(l l2) {
        return l2.w;
    }

    static /* synthetic */ o n(l l2) {
        return l2.l;
    }

    static /* synthetic */ AdColonyAppOptions o(l l2) {
        return l2.v;
    }

    boolean A() {
        return this.L;
    }

    ExternalAvidAdSessionContext C() {
        if (this.W == null) {
            this.W = new ExternalAvidAdSessionContext("3.3.7", true);
        }
        return this.W;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    void a(AdColonyAppOptions adColonyAppOptions) {
        ConcurrentHashMap concurrentHashMap;
        ConcurrentHashMap concurrentHashMap2 = concurrentHashMap = this.k.c();
        // MONITORENTER : concurrentHashMap2
        Iterator iterator = this.k.c().entrySet().iterator();
        while (iterator.hasNext()) {
            AdColonyInterstitial adColonyInterstitial = (AdColonyInterstitial)((Map.Entry)iterator.next()).getValue();
            AdColonyInterstitialListener adColonyInterstitialListener = adColonyInterstitial.getListener();
            adColonyInterstitial.a(true);
            if (adColonyInterstitialListener == null) continue;
            adColonyInterstitialListener.onExpiring(adColonyInterstitial);
        }
        this.k.c().clear();
        // MONITOREXIT : concurrentHashMap2
        {
            catch (Throwable throwable) {}
            {
                // MONITOREXIT : concurrentHashMap2
                throw throwable;
            }
        }
        this.L = false;
        this.a(1);
        this.A.clear();
        this.v = adColonyAppOptions;
        this.h.a();
        this.a(true, true);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    void a(AdColonyAppOptions var1_1, boolean var2_2) {
        block4 : {
            this.K = var2_2;
            this.v = var1_1;
            this.h = new ae();
            this.g = new m();
            this.i = new q();
            this.i.a();
            this.j = new am();
            this.j.a();
            this.k = new d();
            this.k.a();
            this.l = new o();
            this.m = new t();
            this.m.a();
            this.p = new aa();
            aa.c();
            this.o = new ap();
            this.o.a();
            this.n = new ar();
            this.n.a();
            this.c = new n();
            this.c.e();
            this.d = new ah();
            this.C = this.d.c();
            AdColony.a((Context)a.c(), (AdColonyAppOptions)var1_1);
            if (var2_2) break block4;
            var5_3 = new StringBuilder();
            var5_3.append(this.o.g());
            var5_3.append("026ae9c9824b3e483fa6c71fa88f57ae27816141");
            this.N = new File(var5_3.toString()).exists();
            var8_4 = new StringBuilder();
            var8_4.append(this.o.g());
            var8_4.append("7bf3a1e7bbd31e612eda3310c2cdb8075c43c6b5");
            this.O = new File(var8_4.toString()).exists();
            if (!this.N || !this.O) ** GOTO lbl-1000
            var19_5 = new StringBuilder();
            var19_5.append(this.o.g());
            var19_5.append("026ae9c9824b3e483fa6c71fa88f57ae27816141");
            if (w.b((JSONObject)w.c((String)var19_5.toString()), (String)"sdkVersion").equals((Object)this.c.D())) {
                var11_6 = true;
            } else lbl-1000: // 2 sources:
            {
                var11_6 = false;
            }
            this.M = var11_6;
            if (this.N) {
                var12_7 = new StringBuilder();
                var12_7.append(this.o.g());
                var12_7.append("026ae9c9824b3e483fa6c71fa88f57ae27816141");
                this.z = w.c((String)var12_7.toString());
                this.b(this.z);
            }
            this.e(this.M);
            this.H();
        }
        a.a((String)"Module.load", (af)new af(){

            public void a(ad ad2) {
                l.this.a(ad2);
            }
        });
        a.a((String)"Module.unload", (af)new af(){

            public void a(ad ad2) {
                l.this.f(ad2);
            }
        });
        a.a((String)"AdColony.on_configured", (af)new af(){

            public void a(ad ad2) {
                int n2;
                l.this.L = true;
                if (l.this.Q) {
                    JSONObject jSONObject = w.a();
                    JSONObject jSONObject2 = w.a();
                    w.a((JSONObject)jSONObject2, (String)"app_version", (String)au.b());
                    w.a((JSONObject)jSONObject, (String)"app_bundle_info", (JSONObject)jSONObject2);
                    new ad("AdColony.on_update", 1, jSONObject).b();
                    l.this.Q = false;
                }
                if (l.this.R) {
                    new ad("AdColony.on_install", 1).b();
                }
                if (aa.l != null) {
                    String string = w.b((JSONObject)ad2.c(), (String)"app_session_id");
                    aa.l.b(string);
                }
                if (AdColonyEventTracker.b()) {
                    AdColonyEventTracker.a();
                }
                if ((n2 = w.a((JSONObject)ad2.c(), (String)"concurrent_requests", (int)4)) != l.this.i.b()) {
                    l.this.i.a(n2);
                }
                l.this.D();
            }
        });
        a.a((String)"AdColony.get_app_info", (af)new af(){

            public void a(ad ad2) {
                l.this.g(ad2);
            }
        });
        a.a((String)"AdColony.v4vc_reward", (af)new af(){

            public void a(ad ad2) {
                l.this.d(ad2);
            }
        });
        a.a((String)"AdColony.zone_info", (af)new af(){

            public void a(ad ad2) {
                l.this.e(ad2);
            }
        });
        a.a((String)"AdColony.probe_launch_server", (af)new af(){

            public void a(ad ad2) {
                l.this.a(true, true);
            }
        });
        a.a((String)"Crypto.sha1", (af)new af(){

            public void a(ad ad2) {
                JSONObject jSONObject = w.a();
                w.a((JSONObject)jSONObject, (String)"sha1", (String)au.c((String)w.b((JSONObject)ad2.c(), (String)"data")));
                ad2.a(jSONObject).b();
            }
        });
        a.a((String)"Crypto.crc32", (af)new af(){

            public void a(ad ad2) {
                JSONObject jSONObject = w.a();
                w.b((JSONObject)jSONObject, (String)"crc32", (int)au.b((String)w.b((JSONObject)ad2.c(), (String)"data")));
                ad2.a(jSONObject).b();
            }
        });
        a.a((String)"Crypto.uuid", (af)new af(){

            public void a(ad ad2) {
                int n2 = w.c((JSONObject)ad2.c(), (String)"number");
                JSONObject jSONObject = w.a();
                w.a((JSONObject)jSONObject, (String)"uuids", (JSONArray)au.a((int)n2));
                ad2.a(jSONObject).b();
            }
        });
        a.a((String)"Device.query_advertiser_info", (af)new af(){

            public void a(ad ad2) {
                Context context = a.c();
                if (context != null) {
                    au.b.execute((Runnable)new 1(this, context, ad2));
                }
            }
        });
        a.a((String)"AdColony.controller_version", (af)new af(){

            public void a(ad ad2) {
                l.this.c.g = w.b((JSONObject)ad2.c(), (String)"version");
                if (aa.l != null) {
                    aa.l.a(l.this.c.g);
                }
                new y.a().a("Controller version: ").a(l.this.c.g).a(y.d);
            }
        });
        var16_8 = au.a((ap)this.o);
        var17_9 = var16_8 == 1;
        this.Q = var17_9;
        var18_10 = false;
        if (var16_8 == 2) {
            var18_10 = true;
        }
        this.R = var18_10;
    }

    void a(AdColonyInterstitial adColonyInterstitial) {
        this.s = adColonyInterstitial;
    }

    void a(AdColonyRewardListener adColonyRewardListener) {
        this.t = adColonyRewardListener;
    }

    void a(ax ax2) {
        this.r = ax2;
    }

    void a(c c2) {
        this.q = c2;
    }

    public void a(p p2, ad ad2, Map<String, List<String>> map) {
        if (p2.a.equals((Object)e)) {
            if (p2.c) {
                new y.a().a("Launch: ").a(p2.b).a(y.b);
                JSONObject jSONObject = w.a((String)p2.b, (String)"Parsing launch response");
                w.a((JSONObject)jSONObject, (String)"sdkVersion", (String)this.c.D());
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(this.o.g());
                stringBuilder.append("026ae9c9824b3e483fa6c71fa88f57ae27816141");
                w.h((JSONObject)jSONObject, (String)stringBuilder.toString());
                if (!this.c(jSONObject)) {
                    if (!this.M) {
                        new y.a().a("Incomplete or disabled launch server response. ").a("Disabling AdColony until next launch.").a(y.g);
                        this.a(true);
                    }
                    return;
                }
                if (this.a(jSONObject)) {
                    new y.a().a("Controller missing or out of date. Downloading controller").a(y.d);
                    JSONObject jSONObject2 = w.a();
                    w.a((JSONObject)jSONObject2, (String)"url", (String)this.D);
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(this.o.g());
                    stringBuilder2.append("7bf3a1e7bbd31e612eda3310c2cdb8075c43c6b5");
                    w.a((JSONObject)jSONObject2, (String)"filepath", (String)stringBuilder2.toString());
                    this.i.a(new p(new ad("WebServices.download", 0, jSONObject2), (p.a)this));
                }
                this.z = jSONObject;
                return;
            }
            this.F();
            return;
        }
        if (p2.a.equals((Object)this.D)) {
            if (!this.b(this.E) && !aw.a) {
                new y.a().a("Downloaded controller sha1 does not match, retrying.").a(y.e);
                this.F();
                return;
            }
            if (!this.M && !this.P) {
                au.a((Runnable)new 8(this));
            }
        }
    }

    void a(String string) {
        this.C = string;
    }

    void a(boolean bl) {
        this.K = bl;
    }

    boolean a(int n2) {
        ad ad2;
        if (this.h.a(n2) == null) {
            return false;
        }
        if (this.B.containsKey((Object)n2)) {
            aw aw2 = (aw)((Object)this.B.get((Object)n2));
            if (aw2.h()) {
                aw2.loadUrl("about:blank");
                aw2.clearCache(true);
                aw2.removeAllViews();
                aw2.a(true);
            }
            this.B.remove((Object)n2);
        }
        if ((ad2 = this.y) != null) {
            ad2.b();
            this.y = null;
            this.x = false;
        }
        new y.a().a("Destroying module with id = ").a(n2).a(y.d);
        return true;
    }

    /*
     * Exception decompiling
     */
    boolean a(Context var1, ad var2) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl40 : ALOAD_3 : trying to set 1 previously set to 0
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

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    boolean a(ad ad2) {
        Context context = a.c();
        if (context == null) {
            return false;
        }
        try {
            int n2 = ad2.c().has("id") ? w.c((JSONObject)ad2.c(), (String)"id") : 0;
            if (n2 <= 0) {
                n2 = this.h.d();
            }
            this.a(n2);
            au.a((Runnable)new 6(this, context, w.d((JSONObject)ad2.c(), (String)"is_display_module"), ad2));
            return true;
        }
        catch (RuntimeException runtimeException) {
            new y.a().a("Failed to create AdUnit file://").a(w.b((JSONObject)ad2.c(), (String)"filepath")).a(y.h);
            new y.a().a(runtimeException.toString()).a(y.h);
            runtimeException.printStackTrace();
            return false;
        }
    }

    String b() {
        return this.G;
    }

    void b(ad ad2) {
        this.w = ad2;
    }

    void b(boolean bl) {
        this.J = bl;
    }

    void c(boolean bl) {
        this.I = bl;
    }

    AdColonyAppOptions d() {
        if (this.v == null) {
            this.v = new AdColonyAppOptions();
        }
        return this.v;
    }

    void d(boolean bl) {
        this.x = bl;
    }

    boolean d(ad ad2) {
        if (this.t != null) {
            au.a((Runnable)new 9(this, ad2));
            return true;
        }
        return false;
    }

    void e(ad ad2) {
        AdColonyZone adColonyZone;
        if (this.K) {
            new y.a().a("AdColony is disabled. Ignoring zone_info message.").a(y.f);
            return;
        }
        String string = w.b((JSONObject)ad2.c(), (String)"zone_id");
        if (this.A.containsKey((Object)string)) {
            adColonyZone = (AdColonyZone)this.A.get((Object)string);
        } else {
            AdColonyZone adColonyZone2 = new AdColonyZone(string);
            this.A.put((Object)string, (Object)adColonyZone2);
            adColonyZone = adColonyZone2;
        }
        adColonyZone.a(ad2);
    }

    boolean e() {
        return this.v != null;
    }

    HashMap<String, AdColonyZone> f() {
        return this.A;
    }

    boolean g() {
        return this.J;
    }

    boolean h() {
        return this.K;
    }

    AdColonyRewardListener i() {
        return this.t;
    }

    t j() {
        if (this.m == null) {
            this.m = new t();
            this.m.a();
        }
        return this.m;
    }

    am k() {
        if (this.j == null) {
            this.j = new am();
            this.j.a();
        }
        return this.j;
    }

    d l() {
        if (this.k == null) {
            this.k = new d();
            this.k.a();
        }
        return this.k;
    }

    n m() {
        if (this.c == null) {
            this.c = new n();
            this.c.e();
        }
        return this.c;
    }

    ap n() {
        if (this.o == null) {
            this.o = new ap();
            this.o.a();
        }
        return this.o;
    }

    ah o() {
        if (this.d == null) {
            this.d = new ah();
        }
        return this.d;
    }

    ae p() {
        if (this.h == null) {
            this.h = new ae();
            this.h.a();
        }
        return this.h;
    }

    o q() {
        if (this.l == null) {
            this.l = new o();
        }
        return this.l;
    }

    q r() {
        if (this.i == null) {
            this.i = new q();
        }
        return this.i;
    }

    c s() {
        return this.q;
    }

    ax t() {
        return this.r;
    }

    AdColonyInterstitial u() {
        return this.s;
    }

    String v() {
        return this.C;
    }

    boolean w() {
        return this.I;
    }

    HashMap<Integer, aw> x() {
        return this.B;
    }

    HashMap<String, AdColonyCustomMessageListener> z() {
        return this.u;
    }

}

