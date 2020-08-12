/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.os.Handler
 *  android.os.Looper
 *  android.view.View
 *  com.applovin.impl.mediation.a.a
 *  com.applovin.impl.mediation.a.g
 *  com.applovin.impl.mediation.d
 *  com.applovin.impl.mediation.h$a
 *  com.applovin.mediation.adapter.listeners.MaxInterstitialAdapterListener
 *  com.applovin.mediation.adapter.listeners.MaxRewardedAdapterListener
 *  com.applovin.mediation.adapter.parameters.MaxAdapterInitializationParameters
 *  com.applovin.mediation.adapter.parameters.MaxAdapterResponseParameters
 *  com.applovin.mediation.adapter.parameters.MaxAdapterSignalCollectionParameters
 *  java.lang.Class
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.concurrent.atomic.AtomicBoolean
 */
package com.applovin.impl.mediation;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.applovin.impl.mediation.a.e;
import com.applovin.impl.mediation.a.g;
import com.applovin.impl.mediation.d;
import com.applovin.impl.mediation.h;
import com.applovin.impl.sdk.j;
import com.applovin.impl.sdk.p;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.adapter.MaxAdViewAdapter;
import com.applovin.mediation.adapter.MaxAdapter;
import com.applovin.mediation.adapter.MaxInterstitialAdapter;
import com.applovin.mediation.adapter.MaxRewardedAdapter;
import com.applovin.mediation.adapter.MaxSignalProvider;
import com.applovin.mediation.adapter.listeners.MaxInterstitialAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxRewardedAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxSignalCollectionListener;
import com.applovin.mediation.adapter.parameters.MaxAdapterInitializationParameters;
import com.applovin.mediation.adapter.parameters.MaxAdapterResponseParameters;
import com.applovin.mediation.adapter.parameters.MaxAdapterSignalCollectionParameters;
import java.util.concurrent.atomic.AtomicBoolean;

/*
 * Exception performing whole class analysis.
 * Exception performing whole class analysis ignored.
 */
public class h {
    private final Handler a;
    private final j b;
    private final p c;
    private final String d;
    private final e e;
    private final String f;
    private MaxAdapter g;
    private String h;
    private com.applovin.impl.mediation.a.a i;
    private View j;
    private final a k;
    private MaxAdapterResponseParameters l;
    private final AtomicBoolean m;
    private final AtomicBoolean n;
    private final AtomicBoolean o;
    private final AtomicBoolean p;

    h(e e2, MaxAdapter maxAdapter, j j2) {
        this.a = new Handler(Looper.getMainLooper());
        this.k = new /* Unavailable Anonymous Inner Class!! */;
        this.m = new AtomicBoolean(true);
        this.n = new AtomicBoolean(false);
        this.o = new AtomicBoolean(false);
        this.p = new AtomicBoolean(false);
        if (e2 != null) {
            if (maxAdapter != null) {
                if (j2 != null) {
                    this.d = e2.u();
                    this.g = maxAdapter;
                    this.b = j2;
                    this.c = j2.u();
                    this.e = e2;
                    this.f = maxAdapter.getClass().getSimpleName();
                    return;
                }
                throw new IllegalArgumentException("No sdk specified");
            }
            throw new IllegalArgumentException("No adapter specified");
        }
        throw new IllegalArgumentException("No adapter name specified");
    }

    static /* synthetic */ View a(h h2, View view) {
        h2.j = view;
        return view;
    }

    static /* synthetic */ e a(h h2) {
        return h2.e;
    }

    static /* synthetic */ MaxAdapter a(h h2, MaxAdapter maxAdapter) {
        h2.g = maxAdapter;
        return maxAdapter;
    }

    static /* synthetic */ void a(h h2, String string2) {
        h2.a(string2);
    }

    static /* synthetic */ void a(h h2, String string2, b b2) {
        h2.a(string2, b2);
    }

    private void a(String string2) {
        p p2 = this.c;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Marking ");
        stringBuilder.append(this.f);
        stringBuilder.append(" as disabled due to: ");
        stringBuilder.append(string2);
        p2.b("MediationAdapterWrapper", stringBuilder.toString());
        this.m.set(false);
    }

    private void a(String string2, b b2) {
        if (b2.c.compareAndSet(false, true) && b2.b != null) {
            b2.b.onSignalCollected(string2);
        }
    }

    private void a(String string2, Runnable runnable) {
        Runnable runnable2 = new Runnable(this, string2, runnable){
            final /* synthetic */ String a;
            final /* synthetic */ Runnable b;
            final /* synthetic */ h c;
            {
                this.c = h2;
                this.a = string2;
                this.b = runnable;
            }

            public void run() {
                try {
                    p p2 = h.h(this.c);
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(h.k(this.c));
                    stringBuilder.append(": running ");
                    stringBuilder.append(this.a);
                    stringBuilder.append("...");
                    p2.a("MediationAdapterWrapper", stringBuilder.toString());
                    this.b.run();
                    p p3 = h.h(this.c);
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(h.k(this.c));
                    stringBuilder2.append(": finished ");
                    stringBuilder2.append(this.a);
                    stringBuilder2.append("");
                    p3.a("MediationAdapterWrapper", stringBuilder2.toString());
                    return;
                }
                catch (Throwable throwable) {
                    p p4 = h.h(this.c);
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Unable to run adapter operation ");
                    stringBuilder.append(this.a);
                    stringBuilder.append(", marking ");
                    stringBuilder.append(h.k(this.c));
                    stringBuilder.append(" as disabled");
                    p4.b("MediationAdapterWrapper", stringBuilder.toString(), throwable);
                    h h2 = this.c;
                    StringBuilder stringBuilder3 = new StringBuilder();
                    stringBuilder3.append("fail_");
                    stringBuilder3.append(this.a);
                    h.a(h2, stringBuilder3.toString());
                    return;
                }
            }
        };
        if (this.e.w()) {
            this.a.post(runnable2);
            return;
        }
        runnable2.run();
    }

    static /* synthetic */ j b(h h2) {
        return h2.b;
    }

    static /* synthetic */ void b(h h2, String string2, b b2) {
        h2.b(string2, b2);
    }

    private void b(String string2, b b2) {
        if (b2.c.compareAndSet(false, true) && b2.b != null) {
            b2.b.onSignalCollectionFailed(string2);
        }
    }

    static /* synthetic */ Handler c(h h2) {
        return h2.a;
    }

    static /* synthetic */ AtomicBoolean f(h h2) {
        return h2.p;
    }

    static /* synthetic */ com.applovin.impl.mediation.a.a g(h h2) {
        return h2.i;
    }

    static /* synthetic */ p h(h h2) {
        return h2.c;
    }

    static /* synthetic */ AtomicBoolean i(h h2) {
        return h2.n;
    }

    static /* synthetic */ String k(h h2) {
        return h2.f;
    }

    static /* synthetic */ AtomicBoolean l(h h2) {
        return h2.o;
    }

    static /* synthetic */ String m(h h2) {
        return h2.h;
    }

    public View a() {
        return this.j;
    }

    void a(com.applovin.impl.mediation.a.a a2, final Activity activity) {
        block5 : {
            block6 : {
                block7 : {
                    block11 : {
                        block12 : {
                            Object object;
                            block10 : {
                                block8 : {
                                    block9 : {
                                        if (a2 == null) break block5;
                                        if (a2.b() != this) break block6;
                                        if (activity == null) break block7;
                                        if (!this.m.get()) {
                                            p p2 = this.c;
                                            StringBuilder stringBuilder = new StringBuilder();
                                            stringBuilder.append("Mediation adapter '");
                                            stringBuilder.append(this.f);
                                            stringBuilder.append("' is disabled. Showing ads with this adapter is disabled.");
                                            p2.e("MediationAdapterWrapper", stringBuilder.toString());
                                            a.b(this.k, (String)"ad_show", (int)-5103);
                                            return;
                                        }
                                        if (!this.d()) {
                                            p p3 = this.c;
                                            StringBuilder stringBuilder = new StringBuilder();
                                            stringBuilder.append("Mediation adapter '");
                                            stringBuilder.append(this.f);
                                            stringBuilder.append("' does not have an ad loaded. Please load an ad first");
                                            p3.e("MediationAdapterWrapper", stringBuilder.toString());
                                            a.b(this.k, (String)"ad_show", (int)-5002);
                                            return;
                                        }
                                        if (a2.getFormat() != MaxAdFormat.INTERSTITIAL) break block8;
                                        if (!(this.g instanceof MaxInterstitialAdapter)) break block9;
                                        object = new Runnable(){

                                            public void run() {
                                                ((MaxInterstitialAdapter)((Object)h.this.g)).showInterstitialAd(h.this.l, activity, (MaxInterstitialAdapterListener)h.this.k);
                                            }
                                        };
                                        break block10;
                                    }
                                    p p4 = this.c;
                                    StringBuilder stringBuilder = new StringBuilder();
                                    stringBuilder.append("Mediation adapter '");
                                    stringBuilder.append(this.f);
                                    stringBuilder.append("' is not an interstitial adapter.");
                                    p4.e("MediationAdapterWrapper", stringBuilder.toString());
                                    a.b(this.k, (String)"showFullscreenAd", (int)-5104);
                                    return;
                                }
                                if (a2.getFormat() != MaxAdFormat.REWARDED) break block11;
                                if (!(this.g instanceof MaxRewardedAdapter)) break block12;
                                object = new Runnable(){

                                    public void run() {
                                        ((MaxRewardedAdapter)((Object)h.this.g)).showRewardedAd(h.this.l, activity, (MaxRewardedAdapterListener)h.this.k);
                                    }
                                };
                            }
                            this.a("ad_render", new Runnable(this, (Runnable)object, a2){
                                final /* synthetic */ Runnable a;
                                final /* synthetic */ com.applovin.impl.mediation.a.a b;
                                final /* synthetic */ h c;
                                {
                                    this.c = h2;
                                    this.a = runnable;
                                    this.b = a2;
                                }

                                public void run() {
                                    try {
                                        this.a.run();
                                        return;
                                    }
                                    catch (Throwable throwable) {
                                        p p2 = h.h(this.c);
                                        StringBuilder stringBuilder = new StringBuilder();
                                        stringBuilder.append("Failed to start displaying ad");
                                        stringBuilder.append((Object)this.b);
                                        p2.b("MediationAdapterWrapper", stringBuilder.toString(), throwable);
                                        a.b(h.e(this.c), (String)"ad_render", (int)-5200);
                                        return;
                                    }
                                }
                            });
                            return;
                        }
                        p p5 = this.c;
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Mediation adapter '");
                        stringBuilder.append(this.f);
                        stringBuilder.append("' is not an incentivized adapter.");
                        p5.e("MediationAdapterWrapper", stringBuilder.toString());
                        a.b(this.k, (String)"showFullscreenAd", (int)-5104);
                        return;
                    }
                    p p6 = this.c;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Failed to show ");
                    stringBuilder.append((Object)a2);
                    stringBuilder.append(": ");
                    stringBuilder.append((Object)a2.getFormat());
                    stringBuilder.append(" is not a supported ad format");
                    p6.e("MediationAdapterWrapper", stringBuilder.toString());
                    a.b(this.k, (String)"showFullscreenAd", (int)-5104);
                    return;
                }
                throw new IllegalArgumentException("No activity specified");
            }
            throw new IllegalArgumentException("Mediated ad belongs to a different adapter");
        }
        throw new IllegalArgumentException("No mediated ad specified");
    }

    void a(MaxAdapterInitializationParameters maxAdapterInitializationParameters, Activity activity) {
        this.a("initialize", new Runnable(this, maxAdapterInitializationParameters, activity){
            final /* synthetic */ MaxAdapterInitializationParameters a;
            final /* synthetic */ Activity b;
            final /* synthetic */ h c;
            {
                this.c = h2;
                this.a = maxAdapterInitializationParameters;
                this.b = activity;
            }

            public void run() {
                h.d(this.c).initialize(this.a, this.b, (com.applovin.mediation.adapter.MaxAdapter$OnCompletionListener)new com.applovin.impl.mediation.h$1$1(this));
            }
        });
    }

    void a(MaxAdapterSignalCollectionParameters maxAdapterSignalCollectionParameters, g g2, Activity activity, MaxSignalCollectionListener maxSignalCollectionListener) {
        if (maxSignalCollectionListener != null) {
            if (!this.m.get()) {
                p p2 = this.c;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Mediation adapter '");
                stringBuilder.append(this.f);
                stringBuilder.append("' is disabled. Signal collection ads with this adapter is disabled.");
                p2.e("MediationAdapterWrapper", stringBuilder.toString());
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("The adapter (");
                stringBuilder2.append(this.f);
                stringBuilder2.append(") is disabled");
                maxSignalCollectionListener.onSignalCollectionFailed(stringBuilder2.toString());
                return;
            }
            b b2 = new b(g2, maxSignalCollectionListener);
            MaxAdapter maxAdapter = this.g;
            if (maxAdapter instanceof MaxSignalProvider) {
                MaxSignalProvider maxSignalProvider = (MaxSignalProvider)((Object)maxAdapter);
                Runnable runnable = new Runnable(this, maxSignalProvider, maxAdapterSignalCollectionParameters, activity, b2, g2){
                    final /* synthetic */ MaxSignalProvider a;
                    final /* synthetic */ MaxAdapterSignalCollectionParameters b;
                    final /* synthetic */ Activity c;
                    final /* synthetic */ b d;
                    final /* synthetic */ g e;
                    final /* synthetic */ h f;
                    {
                        this.f = h2;
                        this.a = maxSignalProvider;
                        this.b = maxAdapterSignalCollectionParameters;
                        this.c = activity;
                        this.d = b2;
                        this.e = g2;
                    }

                    public void run() {
                        this.a.collectSignal(this.b, this.c, (MaxSignalCollectionListener)new com.applovin.impl.mediation.h$11$1(this));
                        if (!b.a(this.d).get()) {
                            if (this.e.y() == 0L) {
                                p p2 = h.h(this.f);
                                StringBuilder stringBuilder = new StringBuilder();
                                stringBuilder.append("Failing signal collection ");
                                stringBuilder.append((Object)this.e);
                                stringBuilder.append(" since it has 0 timeout");
                                p2.a("MediationAdapterWrapper", stringBuilder.toString());
                                h h2 = this.f;
                                StringBuilder stringBuilder2 = new StringBuilder();
                                stringBuilder2.append("The adapter (");
                                stringBuilder2.append(h.k(this.f));
                                stringBuilder2.append(") has 0 timeout");
                                h.b(h2, stringBuilder2.toString(), this.d);
                                return;
                            }
                            if (this.e.y() > 0L) {
                                p p3 = h.h(this.f);
                                StringBuilder stringBuilder = new StringBuilder();
                                stringBuilder.append("Setting timeout ");
                                stringBuilder.append(this.e.y());
                                stringBuilder.append("ms. for ");
                                stringBuilder.append((Object)this.e);
                                p3.a("MediationAdapterWrapper", stringBuilder.toString());
                                long l2 = this.e.y();
                                h.b(this.f).C().a((com.applovin.impl.sdk.d.a)new /* Unavailable Anonymous Inner Class!! */, com.applovin.impl.sdk.d.q$a.j, l2);
                                return;
                            }
                            p p4 = h.h(this.f);
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("Negative timeout set for ");
                            stringBuilder.append((Object)this.e);
                            stringBuilder.append(", not scheduling a timeout");
                            p4.a("MediationAdapterWrapper", stringBuilder.toString());
                        }
                    }
                };
                this.a("collect_signal", runnable);
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("The adapter (");
            stringBuilder.append(this.f);
            stringBuilder.append(") does not support signal collection");
            this.b(stringBuilder.toString(), b2);
            return;
        }
        throw new IllegalArgumentException("No callback specified");
    }

    void a(String string2, com.applovin.impl.mediation.a.a a2) {
        this.h = string2;
        this.i = a2;
    }

    void a(String string2, MaxAdapterResponseParameters maxAdapterResponseParameters, com.applovin.impl.mediation.a.a a2, Activity activity, d d2) {
        block5 : {
            block11 : {
                Object object;
                block8 : {
                    block9 : {
                        block10 : {
                            block6 : {
                                block7 : {
                                    if (a2 == null) break block5;
                                    if (!this.m.get()) {
                                        p p2 = this.c;
                                        StringBuilder stringBuilder = new StringBuilder();
                                        stringBuilder.append("Mediation adapter '");
                                        stringBuilder.append(this.f);
                                        stringBuilder.append("' was disabled due to earlier failures. Loading ads with this adapter is disabled.");
                                        p2.e("MediationAdapterWrapper", stringBuilder.toString());
                                        d2.onAdLoadFailed(string2, -5103);
                                        return;
                                    }
                                    this.l = maxAdapterResponseParameters;
                                    a.a(this.k, (d)d2);
                                    if (a2.getFormat() != MaxAdFormat.INTERSTITIAL) break block6;
                                    if (!(this.g instanceof MaxInterstitialAdapter)) break block7;
                                    object = new Runnable(this, maxAdapterResponseParameters, activity){
                                        final /* synthetic */ MaxAdapterResponseParameters a;
                                        final /* synthetic */ Activity b;
                                        final /* synthetic */ h c;
                                        {
                                            this.c = h2;
                                            this.a = maxAdapterResponseParameters;
                                            this.b = activity;
                                        }

                                        public void run() {
                                            ((MaxInterstitialAdapter)((Object)h.d(this.c))).loadInterstitialAd(this.a, this.b, (MaxInterstitialAdapterListener)h.e(this.c));
                                        }
                                    };
                                    break block8;
                                }
                                p p3 = this.c;
                                StringBuilder stringBuilder = new StringBuilder();
                                stringBuilder.append("Mediation adapter '");
                                stringBuilder.append(this.f);
                                stringBuilder.append("' is not an interstitial adapter.");
                                p3.e("MediationAdapterWrapper", stringBuilder.toString());
                                a.a(this.k, (String)"loadAd", (int)-5104);
                                return;
                            }
                            if (a2.getFormat() != MaxAdFormat.REWARDED) break block9;
                            if (!(this.g instanceof MaxRewardedAdapter)) break block10;
                            object = new Runnable(this, maxAdapterResponseParameters, activity){
                                final /* synthetic */ MaxAdapterResponseParameters a;
                                final /* synthetic */ Activity b;
                                final /* synthetic */ h c;
                                {
                                    this.c = h2;
                                    this.a = maxAdapterResponseParameters;
                                    this.b = activity;
                                }

                                public void run() {
                                    ((MaxRewardedAdapter)((Object)h.d(this.c))).loadRewardedAd(this.a, this.b, (MaxRewardedAdapterListener)h.e(this.c));
                                }
                            };
                            break block8;
                        }
                        p p4 = this.c;
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Mediation adapter '");
                        stringBuilder.append(this.f);
                        stringBuilder.append("' is not an incentivized adapter.");
                        p4.e("MediationAdapterWrapper", stringBuilder.toString());
                        a.a(this.k, (String)"loadAd", (int)-5104);
                        return;
                    }
                    if (a2.getFormat() != MaxAdFormat.BANNER && a2.getFormat() != MaxAdFormat.LEADER && a2.getFormat() != MaxAdFormat.MREC) {
                        p p5 = this.c;
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Failed to load ");
                        stringBuilder.append((Object)a2);
                        stringBuilder.append(": ");
                        stringBuilder.append((Object)a2.getFormat());
                        stringBuilder.append(" is not a supported ad format");
                        p5.e("MediationAdapterWrapper", stringBuilder.toString());
                        a.a(this.k, (String)"loadAd", (int)-5501);
                        return;
                    }
                    if (!(this.g instanceof MaxAdViewAdapter)) break block11;
                    object = new Runnable(this, maxAdapterResponseParameters, a2, activity){
                        final /* synthetic */ MaxAdapterResponseParameters a;
                        final /* synthetic */ com.applovin.impl.mediation.a.a b;
                        final /* synthetic */ Activity c;
                        final /* synthetic */ h d;
                        {
                            this.d = h2;
                            this.a = maxAdapterResponseParameters;
                            this.b = a2;
                            this.c = activity;
                        }

                        public void run() {
                            ((MaxAdViewAdapter)((Object)h.d(this.d))).loadAdViewAd(this.a, this.b.getFormat(), this.c, (com.applovin.mediation.adapter.listeners.MaxAdViewAdapterListener)h.e(this.d));
                        }
                    };
                }
                this.a("ad_load", new Runnable(this, (Runnable)object, a2){
                    final /* synthetic */ Runnable a;
                    final /* synthetic */ com.applovin.impl.mediation.a.a b;
                    final /* synthetic */ h c;
                    {
                        this.c = h2;
                        this.a = runnable;
                        this.b = a2;
                    }

                    /*
                     * Enabled aggressive block sorting
                     * Enabled unnecessary exception pruning
                     * Enabled aggressive exception aggregation
                     */
                    public void run() {
                        try {
                            com.applovin.impl.sdk.c.h h2;
                            com.applovin.impl.sdk.c.g g2;
                            if (h.f(this.c).compareAndSet(false, true)) {
                                if (h.g(this.c).getFormat() == MaxAdFormat.INTERSTITIAL) {
                                    h2 = h.b(this.c).D();
                                    g2 = com.applovin.impl.sdk.c.g.u;
                                } else if (h.g(this.c).getFormat() == MaxAdFormat.REWARDED) {
                                    h2 = h.b(this.c).D();
                                    g2 = com.applovin.impl.sdk.c.g.v;
                                } else {
                                    h2 = h.b(this.c).D();
                                    g2 = com.applovin.impl.sdk.c.g.w;
                                }
                            } else if (h.g(this.c).getFormat() == MaxAdFormat.INTERSTITIAL) {
                                h2 = h.b(this.c).D();
                                g2 = com.applovin.impl.sdk.c.g.x;
                            } else if (h.g(this.c).getFormat() == MaxAdFormat.REWARDED) {
                                h2 = h.b(this.c).D();
                                g2 = com.applovin.impl.sdk.c.g.y;
                            } else {
                                h2 = h.b(this.c).D();
                                g2 = com.applovin.impl.sdk.c.g.z;
                            }
                            h2.a(g2);
                            this.a.run();
                        }
                        catch (Throwable throwable) {
                            p p2 = h.h(this.c);
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("Failed start loading ");
                            stringBuilder.append((Object)this.b);
                            p2.b("MediationAdapterWrapper", stringBuilder.toString(), throwable);
                            a.a(h.e(this.c), (String)"loadAd", (int)-1);
                        }
                        if (!h.i(this.c).get()) {
                            if (h.a(this.c).y() == 0L) {
                                p p3 = h.h(this.c);
                                StringBuilder stringBuilder = new StringBuilder();
                                stringBuilder.append("Failing ad ");
                                stringBuilder.append((Object)this.b);
                                stringBuilder.append(" since it has 0 timeout");
                                p3.a("MediationAdapterWrapper", stringBuilder.toString());
                                a.a(h.e(this.c), (String)"loadAd", (int)-5102);
                                return;
                            }
                            if (h.a(this.c).y() > 0L) {
                                p p4 = h.h(this.c);
                                StringBuilder stringBuilder = new StringBuilder();
                                stringBuilder.append("Setting timeout ");
                                stringBuilder.append(h.a(this.c).y());
                                stringBuilder.append("ms. for ");
                                stringBuilder.append((Object)this.b);
                                p4.a("MediationAdapterWrapper", stringBuilder.toString());
                                long l2 = h.a(this.c).y();
                                h.b(this.c).C().a((com.applovin.impl.sdk.d.a)new /* Unavailable Anonymous Inner Class!! */, com.applovin.impl.sdk.d.q$a.j, l2);
                                return;
                            }
                            p p5 = h.h(this.c);
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("Negative timeout set for ");
                            stringBuilder.append((Object)this.b);
                            stringBuilder.append(", not scheduling a timeout");
                            p5.a("MediationAdapterWrapper", stringBuilder.toString());
                        }
                    }
                });
                return;
            }
            p p6 = this.c;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Mediation adapter '");
            stringBuilder.append(this.f);
            stringBuilder.append("' is not an adview-based adapter.");
            p6.e("MediationAdapterWrapper", stringBuilder.toString());
            a.a(this.k, (String)"loadAd", (int)-5104);
            return;
        }
        throw new IllegalArgumentException("No mediated ad specified");
    }

    public String b() {
        return this.d;
    }

    public boolean c() {
        return this.m.get();
    }

    public boolean d() {
        return this.n.get() && this.o.get();
    }

    public String e() {
        MaxAdapter maxAdapter = this.g;
        if (maxAdapter != null) {
            try {
                String string2 = maxAdapter.getSdkVersion();
                return string2;
            }
            catch (Throwable throwable) {
                p p2 = this.c;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unable to get adapter's SDK version, marking ");
                stringBuilder.append((Object)this);
                stringBuilder.append(" as disabled");
                p2.b("MediationAdapterWrapper", stringBuilder.toString(), throwable);
                this.a("fail_version");
            }
        }
        return null;
    }

    public String f() {
        MaxAdapter maxAdapter = this.g;
        if (maxAdapter != null) {
            try {
                String string2 = maxAdapter.getAdapterVersion();
                return string2;
            }
            catch (Throwable throwable) {
                p p2 = this.c;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unable to get adapter version, marking ");
                stringBuilder.append((Object)this);
                stringBuilder.append(" as disabled");
                p2.b("MediationAdapterWrapper", stringBuilder.toString(), throwable);
                this.a("fail_version");
            }
        }
        return null;
    }

    void g() {
        this.a("destroy", new Runnable(this){
            final /* synthetic */ h a;
            {
                this.a = h2;
            }

            public void run() {
                h.a(this.a, "destroy");
                h.d(this.a).onDestroy();
                h.a(this.a, null);
            }
        });
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[MediationAdapterWrapper - ");
        stringBuilder.append(this.f);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    private static class b {
        private final g a;
        private final MaxSignalCollectionListener b;
        private final AtomicBoolean c = new AtomicBoolean();

        b(g g2, MaxSignalCollectionListener maxSignalCollectionListener) {
            this.a = g2;
            this.b = maxSignalCollectionListener;
        }

        static /* synthetic */ g c(b b2) {
            return b2.a;
        }
    }

}

