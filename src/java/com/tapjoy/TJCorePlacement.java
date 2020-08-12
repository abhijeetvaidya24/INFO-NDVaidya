/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.tapjoy.TJCorePlacement$1
 *  com.tapjoy.TJCorePlacement$2
 *  com.tapjoy.TapjoyErrorMessage
 *  com.tapjoy.TapjoyErrorMessage$ErrorType
 *  com.tapjoy.TapjoyException
 *  com.tapjoy.TapjoyLog
 *  com.tapjoy.TapjoyUtil
 *  com.tapjoy.internal.cg
 *  com.tapjoy.internal.ct
 *  com.tapjoy.internal.d
 *  com.tapjoy.internal.el
 *  com.tapjoy.internal.ep
 *  com.tapjoy.internal.et
 *  com.tapjoy.internal.ex
 *  com.tapjoy.internal.ey
 *  com.tapjoy.internal.ez
 *  com.tapjoy.internal.fd
 *  com.tapjoy.internal.fi
 *  com.tapjoy.internal.fi$a
 *  com.tapjoy.internal.fl
 *  com.tapjoy.internal.fy
 *  com.tapjoy.internal.fz
 *  com.tapjoy.internal.gc
 *  com.tapjoy.internal.gd
 *  com.tapjoy.internal.gh
 *  com.tapjoy.internal.gj
 *  com.tapjoy.internal.gl
 *  com.tapjoy.internal.hm
 *  com.tapjoy.internal.hm$a
 *  com.tapjoy.internal.q
 *  java.io.ByteArrayInputStream
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.Boolean
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Thread
 *  java.net.URI
 *  java.util.HashMap
 *  java.util.Map
 *  java.util.UUID
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.tapjoy;

import android.content.Context;
import com.tapjoy.TJAdUnit;
import com.tapjoy.TJCorePlacement;
import com.tapjoy.TJError;
import com.tapjoy.TJPlacement;
import com.tapjoy.TJPlacementData;
import com.tapjoy.TJPlacementListener;
import com.tapjoy.TapjoyConnectCore;
import com.tapjoy.TapjoyErrorMessage;
import com.tapjoy.TapjoyException;
import com.tapjoy.TapjoyLog;
import com.tapjoy.TapjoyUtil;
import com.tapjoy.internal.cg;
import com.tapjoy.internal.ct;
import com.tapjoy.internal.d;
import com.tapjoy.internal.el;
import com.tapjoy.internal.ep;
import com.tapjoy.internal.et;
import com.tapjoy.internal.ex;
import com.tapjoy.internal.ey;
import com.tapjoy.internal.ez;
import com.tapjoy.internal.fd;
import com.tapjoy.internal.fi;
import com.tapjoy.internal.fl;
import com.tapjoy.internal.fy;
import com.tapjoy.internal.fz;
import com.tapjoy.internal.gc;
import com.tapjoy.internal.gd;
import com.tapjoy.internal.gh;
import com.tapjoy.internal.gj;
import com.tapjoy.internal.gl;
import com.tapjoy.internal.hm;
import com.tapjoy.internal.q;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

public class TJCorePlacement {
    static final String a = "TJCorePlacement";
    Context b = d.c();
    TJPlacementData c;
    String d;
    long e;
    final ez f = new ez();
    TJAdUnit g;
    boolean h = false;
    gj i = null;
    boolean j;
    volatile boolean k = false;
    volatile boolean l = false;
    volatile boolean m = false;
    String n;
    String o;
    String p;
    String q;
    private Map r = new HashMap();
    private Map s;
    private ep t;
    private boolean u = false;
    private hm v = null;
    private volatile boolean w = false;
    private TJAdUnit.TJAdUnitWebViewListener x = new 1(this);
    private TJAdUnit.TJAdUnitVideoListener y = new 2(this);

    TJCorePlacement(String string, String string2) {
        if (this.b == null) {
            TapjoyLog.d((String)a, (String)"getVisibleActivity() is NULL. Activity can be explicitly set via `Tapjoy.setActivity(Activity)`");
        }
        this.c = new TJPlacementData(string2, this.getPlacementContentUrl());
        this.c.setPlacementName(string);
        this.d = UUID.randomUUID().toString();
        this.g = new TJAdUnit();
        this.g.setWebViewListener(this.x);
        this.g.setVideoListener(this.y);
    }

    static /* synthetic */ long a(TJCorePlacement tJCorePlacement, long l2) {
        tJCorePlacement.e = l2;
        return l2;
    }

    static /* synthetic */ hm a(TJCorePlacement tJCorePlacement, hm hm2) {
        tJCorePlacement.v = hm2;
        return hm2;
    }

    static /* synthetic */ void a(TJCorePlacement tJCorePlacement) {
        tJCorePlacement.c();
    }

    static /* synthetic */ void a(TJCorePlacement tJCorePlacement, TJPlacement tJPlacement) {
        tJCorePlacement.a(tJPlacement);
    }

    static /* synthetic */ void a(TJCorePlacement tJCorePlacement, String string) {
        if (string != null) {
            try {
                String string2 = a;
                StringBuilder stringBuilder = new StringBuilder("Disable preload flag is set for placement ");
                stringBuilder.append(tJCorePlacement.c.getPlacementName());
                TapjoyLog.d((String)string2, (String)stringBuilder.toString());
                JSONObject jSONObject = new JSONObject(string);
                tJCorePlacement.c.setRedirectURL(jSONObject.getString("redirect_url"));
                tJCorePlacement.c.setPreloadDisabled(true);
                tJCorePlacement.c.setHasProgressSpinner(true);
                String string3 = a;
                StringBuilder stringBuilder2 = new StringBuilder("redirect_url:");
                stringBuilder2.append(tJCorePlacement.c.getRedirectURL());
                TapjoyLog.d((String)string3, (String)stringBuilder2.toString());
                return;
            }
            catch (JSONException jSONException) {
                throw new TapjoyException("TJPlacement request failed, malformed server response");
            }
        }
        throw new TapjoyException("TJPlacement request failed due to null response");
    }

    static /* synthetic */ boolean a(TJCorePlacement tJCorePlacement, boolean bl) {
        tJCorePlacement.u = bl;
        return bl;
    }

    static /* synthetic */ boolean b(TJCorePlacement tJCorePlacement) {
        return tJCorePlacement.h;
    }

    static /* synthetic */ boolean b(TJCorePlacement tJCorePlacement, String string) {
        return tJCorePlacement.b(string);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean b(String string) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(string.getBytes());
        try {
            ex ex2;
            hm.a a2 = (hm.a)this.v.a(URI.create((String)this.c.getUrl()), (InputStream)byteArrayInputStream);
            this.i = a2.a;
            a2.a.b();
            if (!a2.a.c()) {
                TapjoyLog.e((String)a, (String)"Failed to load fiverocks placement");
                return false;
            }
            if (this.i instanceof gh) {
                ex2 = new ex(this.c.getPlacementName(), this.c.getPlacementType(), this.t);
            } else {
                boolean bl = this.i instanceof fy;
                ex2 = null;
                if (bl) {
                    ex2 = new ey(this.c.getPlacementName(), this.c.getPlacementType(), this.t);
                }
            }
            this.f.a = ex2;
            return true;
        }
        catch (cg cg2) {
            TapjoyLog.e((String)a, (String)cg2.toString());
            cg2.printStackTrace();
            return false;
        }
        catch (IOException iOException) {
            TapjoyLog.e((String)a, (String)iOException.toString());
            iOException.printStackTrace();
            return false;
        }
    }

    static /* synthetic */ boolean c(TJCorePlacement tJCorePlacement) {
        tJCorePlacement.h = false;
        return false;
    }

    static /* synthetic */ String d() {
        return a;
    }

    static /* synthetic */ boolean d(TJCorePlacement tJCorePlacement) {
        return tJCorePlacement.u;
    }

    static /* synthetic */ String f(TJCorePlacement tJCorePlacement) {
        return tJCorePlacement.c.getPlacementName();
    }

    static /* synthetic */ Context g(TJCorePlacement tJCorePlacement) {
        return tJCorePlacement.b;
    }

    static /* synthetic */ TJPlacementData h(TJCorePlacement tJCorePlacement) {
        return tJCorePlacement.c;
    }

    static /* synthetic */ void i(TJCorePlacement tJCorePlacement) {
        tJCorePlacement.t = new ep(tJCorePlacement.c.getPlacementName(), tJCorePlacement.c.getPlacementType());
        tJCorePlacement.g.setAdContentTracker(tJCorePlacement.t);
    }

    static /* synthetic */ ep j(TJCorePlacement tJCorePlacement) {
        return tJCorePlacement.t;
    }

    static /* synthetic */ void k(TJCorePlacement tJCorePlacement) {
        tJCorePlacement.l = true;
        tJCorePlacement.a(tJCorePlacement.a("REQUEST"));
    }

    static /* synthetic */ boolean l(TJCorePlacement tJCorePlacement) {
        tJCorePlacement.w = false;
        return false;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    final TJPlacement a(String string) {
        Map map;
        Map map2 = map = this.r;
        synchronized (map2) {
            TJPlacement tJPlacement = (TJPlacement)this.r.get((Object)string);
            if (tJPlacement != null) {
                String string2 = a;
                StringBuilder stringBuilder = new StringBuilder("Returning ");
                stringBuilder.append(string);
                stringBuilder.append(" placement: ");
                stringBuilder.append(tJPlacement.getGUID());
                TapjoyLog.d((String)string2, (String)stringBuilder.toString());
            }
            return tJPlacement;
        }
    }

    final void a() {
        TJCorePlacement tJCorePlacement = this;
        synchronized (tJCorePlacement) {
            String string = this.c.getUrl();
            if (ct.c((String)string)) {
                string = this.getPlacementContentUrl();
                if (ct.c((String)string)) {
                    fi.b((String)"TJPlacement.requestContent").a("TJPlacement is missing APP_ID").c();
                    this.a(TapjoyErrorMessage.ErrorType.SDK_ERROR, new TJError(0, "TJPlacement is missing APP_ID"));
                    return;
                }
                this.c.updateUrl(string);
            }
            String string2 = a;
            StringBuilder stringBuilder = new StringBuilder("sendContentRequest -- URL: ");
            stringBuilder.append(string);
            stringBuilder.append(" name: ");
            stringBuilder.append(this.c.getPlacementName());
            TapjoyLog.d((String)string2, (String)stringBuilder.toString());
            this.a(string, (Map)null);
            return;
        }
    }

    final void a(TJPlacement tJPlacement) {
        ez ez2 = this.f;
        String string = this.c.getPlacementName();
        String string2 = this.c.getPlacementType();
        String string3 = this.b();
        ez2.c = 0;
        ez2.b = fi.e((String)"PlacementContent.funnel").a().a("placement", (Object)string).a("placement_type", (Object)string2).a("content_type", (Object)string3).a("state", (Object)ez2.c);
        ez2.b.c();
        if (!"none".equals((Object)string3)) {
            ez2.e = fi.e((String)"PlacementContent.ready").a().a("placement", (Object)string).a("placement_type", (Object)string2).a("content_type", (Object)string3);
        }
        if (tJPlacement != null && tJPlacement.getListener() != null) {
            String string4 = a;
            StringBuilder stringBuilder = new StringBuilder("Content request delivered successfully for placement ");
            stringBuilder.append(this.c.getPlacementName());
            stringBuilder.append(", contentAvailable: ");
            stringBuilder.append(this.isContentAvailable());
            stringBuilder.append(", mediationAgent: ");
            stringBuilder.append(this.p);
            TapjoyLog.i((String)string4, (String)stringBuilder.toString());
            tJPlacement.getListener().onRequestSuccess(tJPlacement);
        }
    }

    final void a(TJPlacement tJPlacement, TapjoyErrorMessage.ErrorType errorType, TJError tJError) {
        String string = a;
        StringBuilder stringBuilder = new StringBuilder("Content request failed for placement ");
        stringBuilder.append(this.c.getPlacementName());
        stringBuilder.append("; Reason= ");
        stringBuilder.append(tJError.message);
        TapjoyLog.e((String)string, (TapjoyErrorMessage)new TapjoyErrorMessage(errorType, stringBuilder.toString()));
        if (tJPlacement != null && tJPlacement.getListener() != null) {
            tJPlacement.getListener().onRequestFailure(tJPlacement, tJError);
        }
    }

    final void a(TapjoyErrorMessage.ErrorType errorType, TJError tJError) {
        this.a(this.a("REQUEST"), errorType, tJError);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    final void a(String string, TJPlacement tJPlacement) {
        Map map;
        Map map2 = map = this.r;
        synchronized (map2) {
            this.r.put((Object)string, (Object)tJPlacement);
            if (tJPlacement != null) {
                String string2 = a;
                StringBuilder stringBuilder = new StringBuilder("Setting ");
                stringBuilder.append(string);
                stringBuilder.append(" placement: ");
                stringBuilder.append(tJPlacement.getGUID());
                TapjoyLog.d((String)string2, (String)stringBuilder.toString());
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    final void a(final String string, Map map) {
        TJCorePlacement tJCorePlacement = this;
        synchronized (tJCorePlacement) {
            String string2;
            if (this.w) {
                String string3 = a;
                StringBuilder stringBuilder = new StringBuilder("Placement ");
                stringBuilder.append(this.c.getPlacementName());
                stringBuilder.append(" is already requesting content");
                TapjoyLog.i((String)string3, (String)stringBuilder.toString());
                fi.b((String)"TJPlacement.requestContent").b("already doing").c();
                return;
            }
            this.c.resetPlacementRequestData();
            ez ez2 = this.f;
            ez2.b = null;
            ez2.d = null;
            ez2.a = null;
            this.g.resetContentLoadState();
            this.w = false;
            this.k = false;
            this.l = false;
            this.m = false;
            this.i = null;
            this.v = null;
            this.w = true;
            final TJPlacement tJPlacement = this.a("REQUEST");
            this.s = TapjoyConnectCore.getGenericURLParams();
            this.s.putAll(TapjoyConnectCore.getTimeStampAndVerifierParams());
            TapjoyUtil.safePut((Map)this.s, (String)"event_name", (String)this.c.getPlacementName(), (boolean)true);
            TapjoyUtil.safePut((Map)this.s, (String)"event_preload", (String)"true", (boolean)true);
            TapjoyUtil.safePut((Map)this.s, (String)"debug", (String)Boolean.toString((boolean)fz.a), (boolean)true);
            gc gc2 = gc.a();
            Map map2 = this.s;
            if (gc2.b == null) {
                string2 = null;
            } else {
                gl gl2 = gc2.b;
                gl2.b();
                string2 = gl2.b.a();
            }
            TapjoyUtil.safePut((Map)map2, (String)"action_id_exclusion", string2, (boolean)true);
            TapjoyUtil.safePut((Map)this.s, (String)"system_placement", (String)String.valueOf((boolean)this.j), (boolean)true);
            TapjoyUtil.safePut((Map)this.s, (String)"push_id", (String)tJPlacement.pushId, (boolean)true);
            TapjoyUtil.safePut((Map)this.s, (String)"mediation_source", (String)this.n, (boolean)true);
            TapjoyUtil.safePut((Map)this.s, (String)"adapter_version", (String)this.o, (boolean)true);
            if (map != null) {
                this.s.putAll(map);
            }
            final el el2 = new el(fd.b().c("placement_request_content_retry_timeout"));
            final fl fl2 = fd.b().d("placement_request_content_retry_backoff");
            final fi.a a2 = fi.d((String)"TJPlacement.requestContent");
            Thread thread = new Thread(){

                /*
                 * Exception decompiling
                 */
                private boolean a() {
                    // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
                    // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl519 : ALOAD_0 : trying to set 1 previously set to 0
                    // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
                    // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
                    // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
                    // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
                    // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
                    // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
                    // org.benf.cfr.reader.entities.g.p(Method.java:396)
                    // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
                    // org.benf.cfr.reader.entities.d.c(ClassFile.java:773)
                    // org.benf.cfr.reader.entities.d.e(ClassFile.java:870)
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

                public final void run() {
                    fi.a((String)"TJPlacement.requestContent", (fi.a)a2);
                    int n2 = 0;
                    while (!this.a()) {
                        Map map = TJCorePlacement.this.s;
                        map.put((Object)"retry", (Object)Integer.toString((int)(++n2)));
                        if (n2 == 1) {
                            a2.a("retry_timeout", (Object)el2.b);
                        }
                        a2.a("retry_count", (long)n2);
                    }
                }
            };
            thread.start();
            return;
        }
    }

    final String b() {
        if (this.i != null) {
            return "mm";
        }
        if (this.l) {
            return "ad";
        }
        return "none";
    }

    final void c() {
        if (!this.k) {
            TJPlacement tJPlacement;
            this.m = true;
            String string = a;
            StringBuilder stringBuilder = new StringBuilder("Content is ready for placement ");
            stringBuilder.append(this.c.getPlacementName());
            TapjoyLog.i((String)string, (String)stringBuilder.toString());
            if (this.g.isPrerendered()) {
                fi.a a2;
                ez ez2 = this.f;
                Boolean bl = true;
                fi.a a3 = ez2.b;
                if (a3 != null) {
                    a3.a("prerendered", (Object)bl);
                }
                if ((a2 = ez2.e) != null) {
                    a2.a("prerendered", (Object)bl);
                }
            }
            ez ez3 = this.f;
            fi.a a4 = ez3.e;
            if (a4 != null) {
                ez3.e = null;
                a4.b().c();
            }
            if ((tJPlacement = this.a("REQUEST")) != null && tJPlacement.getListener() != null) {
                tJPlacement.getListener().onContentReady(tJPlacement);
                this.k = true;
            }
        }
    }

    public TJAdUnit getAdUnit() {
        return this.g;
    }

    public Context getContext() {
        return this.b;
    }

    public String getPlacementContentUrl() {
        String string = TapjoyConnectCore.getAppID();
        if (!ct.c((String)string)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(TapjoyConnectCore.getPlacementURL());
            stringBuilder.append("v1/apps/");
            stringBuilder.append(string);
            stringBuilder.append("/content?");
            return stringBuilder.toString();
        }
        return "";
    }

    public TJPlacementData getPlacementData() {
        return this.c;
    }

    public boolean isContentAvailable() {
        return this.l;
    }

    public boolean isContentReady() {
        return this.m;
    }

    public void setContext(Context context) {
        this.b = context;
    }

}

