/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  com.applovin.impl.mediation.b.f$1
 *  com.applovin.impl.mediation.b.f$b$1
 *  java.lang.Boolean
 *  java.lang.Enum
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.concurrent.atomic.AtomicBoolean
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.applovin.impl.mediation.b;

import android.app.Activity;
import com.applovin.impl.mediation.MediationServiceImpl;
import com.applovin.impl.mediation.b.e;
import com.applovin.impl.mediation.b.f;
import com.applovin.impl.mediation.c.c;
import com.applovin.impl.sdk.c.g;
import com.applovin.impl.sdk.c.i;
import com.applovin.impl.sdk.c.j;
import com.applovin.impl.sdk.d.q;
import com.applovin.impl.sdk.e.h;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdListener;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class f
extends com.applovin.impl.sdk.d.a {
    private final String a;
    private final MaxAdFormat c;
    private final JSONObject d;
    private final JSONArray e;
    private final com.applovin.impl.mediation.f f;
    private final MaxAdListener g;
    private final Activity h;
    private final AtomicBoolean i;
    private final com.applovin.impl.mediation.e j;
    private final Object k;
    private a l;
    private int m;

    f(String string, MaxAdFormat maxAdFormat, JSONObject jSONObject, com.applovin.impl.mediation.f f2, Activity activity, com.applovin.impl.sdk.j j2, MaxAdListener maxAdListener) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("TaskProcessMediationWaterfall ");
        stringBuilder.append(string);
        super(stringBuilder.toString(), j2);
        this.a = string;
        this.c = maxAdFormat;
        this.d = jSONObject;
        this.f = f2;
        this.g = maxAdListener;
        this.h = activity;
        this.e = this.d.optJSONArray("ads");
        this.j = new com.applovin.impl.mediation.e(jSONObject, j2);
        this.i = new AtomicBoolean();
        this.k = new Object();
        this.l = a.a;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private a a(a a2) {
        Object object;
        Object object2 = object = this.k;
        synchronized (object2) {
            a a3 = this.l;
            this.l = a2;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Backup ad state changed from ");
            stringBuilder.append((Object)a3);
            stringBuilder.append(" to ");
            stringBuilder.append((Object)a2);
            this.b(stringBuilder.toString());
            return a3;
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    private void a(int n2) {
        g g2;
        com.applovin.impl.sdk.c.h h2;
        if (n2 == 204) {
            h2 = this.b.D();
            g2 = g.r;
        } else if (n2 == -5001) {
            h2 = this.b.D();
            g2 = g.s;
        } else {
            h2 = this.b.D();
            g2 = g.t;
        }
        h2.a(g2);
        if (this.i.compareAndSet(false, true)) {
            this.b("Notifying parent of ad load failure...");
            h.a(this.g, this.a, n2, this.b);
        }
    }

    static /* synthetic */ void a(f f2) {
        f2.g();
    }

    static /* synthetic */ void a(f f2, MaxAd maxAd) {
        f2.b(maxAd);
    }

    private void a(MaxAd maxAd) {
        if (maxAd instanceof com.applovin.impl.mediation.a.a) {
            this.j.a((com.applovin.impl.mediation.a.a)maxAd);
            this.h();
            return;
        }
        this.a(-5201);
    }

    static /* synthetic */ void b(f f2, MaxAd maxAd) {
        f2.a(maxAd);
    }

    private void b(MaxAd maxAd) {
        if (maxAd instanceof com.applovin.impl.mediation.a.a) {
            this.b("Backup ad loaded");
            com.applovin.impl.mediation.a.a a2 = (com.applovin.impl.mediation.a.a)maxAd;
            if (this.a(a.d) == a.c) {
                this.b.a(this.h).maybeScheduleBackupAdPromotedToPrimaryPostback(a2);
                this.j.a(a2);
            } else {
                this.j.b(a2);
            }
            this.h();
            return;
        }
        this.a(-5201);
    }

    private static boolean b(JSONObject jSONObject) {
        return jSONObject.optBoolean("is_backup");
    }

    private void f() throws JSONException {
        JSONObject jSONObject;
        block3 : {
            for (int i2 = 0; i2 < this.e.length(); ++i2) {
                jSONObject = this.e.getJSONObject(i2);
                if (!f.b(jSONObject)) {
                    continue;
                }
                break block3;
            }
            jSONObject = null;
        }
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject2 != null) {
            this.b("Loading backup ad...");
            this.a(a.b);
            q q2 = this.b.C();
            e e2 = new e(this.a, this.f, jSONObject2, this.d, this.b, this.h, (MaxAdListener)new 1(this, this.g, this.b));
            q2.a(e2, q.a.l);
        }
    }

    private void g() {
        this.d("Backup ad failed to load...");
        if (this.a(a.e) == a.c) {
            new b(this.m, this.e).h();
        }
    }

    private void h() {
        if (this.i.compareAndSet(false, true)) {
            this.b("Notifying parent of ad load success...");
            h.a(this.g, this.j, this.b);
        }
    }

    private void i() {
        this.a(-5001);
    }

    @Override
    public i a() {
        return i.E;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void run() {
        int n2;
        try {
            this.a("Processing ad response...");
            n2 = this.e != null ? this.e.length() : 0;
        }
        catch (Throwable throwable) {
            this.a("Encountered error while processing ad response", throwable);
            this.i();
            this.b.E().a(this.a());
            return;
        }
        if (n2 > 0) {
            this.f();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Loading the first out of ");
            stringBuilder.append(n2);
            stringBuilder.append(" ads...");
            this.a(stringBuilder.toString());
            b b2 = new b(0, this.e);
            this.b.C().a(b2);
            return;
        }
        this.c("No ads were returned from the server");
        this.a(204);
    }

    private class b
    extends com.applovin.impl.sdk.d.a {
        private final JSONArray c;
        private final int d;

        b(int n2, JSONArray jSONArray) {
            super("TaskProcessNextWaterfallAd", f.this.b);
            if (n2 >= 0 && n2 < jSONArray.length()) {
                this.c = jSONArray;
                this.d = n2;
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Invalid ad index specified: ");
            stringBuilder.append(n2);
            throw new IllegalArgumentException(stringBuilder.toString());
        }

        /*
         * Exception decompiling
         */
        private String a(int var1) {
            // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
            // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl25 : LDC : trying to set 0 previously set to 1
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

        private void f() throws JSONException {
            f.this.m = this.d;
            JSONObject jSONObject = this.c.getJSONObject(this.d);
            if (f.b(jSONObject)) {
                this.g();
                return;
            }
            String string = this.a(this.d);
            if ("adapter".equalsIgnoreCase(string)) {
                this.a("Starting task for adapter ad...");
                q q2 = this.b.C();
                e e2 = new e(f.this.a, f.this.f, jSONObject, f.this.d, this.b, f.this.h, (MaxAdListener)new 1(this, f.this.g, this.b));
                q2.a(e2);
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unable to process ad of unknown type: ");
            stringBuilder.append(string);
            this.d(stringBuilder.toString());
            f.this.a(-800);
        }

        private void g() {
            String string;
            a a2 = f.this.a(a.c);
            if (a2 == a.b) {
                return;
            }
            if (a2 == a.d) {
                if (f.this.j.b(f.this.h)) {
                    this.b("Backup ad was promoted to primary");
                    return;
                }
                string = "Failed to promote backup ad to primary: nothing promoted";
            } else {
                if (a2 == a.e) {
                    this.h();
                    return;
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unknown state of loading the backup ad: ");
                stringBuilder.append((Object)a2);
                string = stringBuilder.toString();
            }
            this.d(string);
            f.this.a(-5201);
        }

        private void h() {
            if (f.this.j.c()) {
                this.c("Not loading next waterfall ad because returned ad was already displayed");
                return;
            }
            if (this.d < -1 + this.c.length()) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Attempting to load next ad (");
                stringBuilder.append(this.d);
                stringBuilder.append(") after failure...");
                this.b(stringBuilder.toString());
                b b2 = new b(1 + this.d, this.c);
                q.a a2 = this.b.a(com.applovin.impl.sdk.b.a.F) != false ? q.a.a : q.a.c;
                q.a a3 = c.a(f.this.c, a2, this.b);
                this.b.C().a(b2, a3);
                return;
            }
            f.this.i();
        }

        @Override
        public i a() {
            return i.F;
        }

        public void run() {
            try {
                this.f();
                return;
            }
            catch (Throwable throwable) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Encountered error while processing ad number ");
                stringBuilder.append(this.d);
                this.a(stringBuilder.toString(), throwable);
                this.b.E().a(this.a());
                f.this.i();
                return;
            }
        }
    }

}

