/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.text.TextUtils
 *  com.applovin.impl.mediation.MaxAdapterParametersImpl
 *  com.applovin.impl.mediation.MediationServiceImpl$1
 *  com.applovin.impl.mediation.MediationServiceImpl$3
 *  com.applovin.impl.mediation.MediationServiceImpl$a
 *  com.applovin.impl.mediation.a.a
 *  com.applovin.impl.mediation.a.b
 *  com.applovin.impl.mediation.a.c
 *  com.applovin.impl.mediation.a.g
 *  com.applovin.impl.mediation.b.a
 *  com.applovin.impl.mediation.b.b
 *  com.applovin.impl.mediation.b.c
 *  com.applovin.impl.mediation.b.d
 *  com.applovin.impl.mediation.d
 *  com.applovin.impl.mediation.e
 *  com.applovin.impl.mediation.h
 *  com.applovin.impl.sdk.d.a
 *  com.applovin.impl.sdk.d.q
 *  com.applovin.impl.sdk.d.q$a
 *  com.applovin.impl.sdk.e.h
 *  com.applovin.impl.sdk.j
 *  com.applovin.impl.sdk.o
 *  com.applovin.impl.sdk.p
 *  com.applovin.mediation.MaxAd
 *  com.applovin.mediation.MaxAdFormat
 *  com.applovin.mediation.MaxAdListener
 *  com.applovin.mediation.adapter.listeners.MaxSignalCollectionListener
 *  com.applovin.mediation.adapter.parameters.MaxAdapterInitializationParameters
 *  com.applovin.mediation.adapter.parameters.MaxAdapterResponseParameters
 *  com.applovin.mediation.adapter.parameters.MaxAdapterSignalCollectionParameters
 *  com.applovin.sdk.AppLovinPrivacySettings
 *  com.applovin.sdk.AppLovinSdkUtils
 *  java.lang.CharSequence
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.HashMap
 *  java.util.LinkedHashSet
 *  java.util.List
 *  java.util.Map
 *  java.util.concurrent.atomic.AtomicBoolean
 */
package com.applovin.impl.mediation;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.applovin.impl.mediation.MaxAdapterParametersImpl;
import com.applovin.impl.mediation.MediationServiceImpl;
import com.applovin.impl.mediation.a.f;
import com.applovin.impl.mediation.b.b;
import com.applovin.impl.mediation.b.c;
import com.applovin.impl.mediation.b.d;
import com.applovin.impl.mediation.e;
import com.applovin.impl.mediation.f;
import com.applovin.impl.mediation.g;
import com.applovin.impl.mediation.h;
import com.applovin.impl.sdk.d.q;
import com.applovin.impl.sdk.j;
import com.applovin.impl.sdk.o;
import com.applovin.impl.sdk.p;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.adapter.listeners.MaxSignalCollectionListener;
import com.applovin.mediation.adapter.parameters.MaxAdapterInitializationParameters;
import com.applovin.mediation.adapter.parameters.MaxAdapterResponseParameters;
import com.applovin.mediation.adapter.parameters.MaxAdapterSignalCollectionParameters;
import com.applovin.sdk.AppLovinPrivacySettings;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/*
 * Exception performing whole class analysis.
 */
public class MediationServiceImpl {
    private final j a;
    private final p b;
    private final AtomicBoolean c;
    private final g d;
    private final LinkedHashSet<String> e;

    public MediationServiceImpl(j j2) {
        this.c = new AtomicBoolean(false);
        this.e = new LinkedHashSet();
        if (j2 != null) {
            this.a = j2;
            this.b = j2.u();
            this.d = new g(j2);
            return;
        }
        throw new IllegalArgumentException("No sdk specified");
    }

    private MaxAdapterParametersImpl.a a(Context context) {
        return new MaxAdapterParametersImpl.a().b(AppLovinPrivacySettings.hasUserConsent((Context)context)).a(AppLovinPrivacySettings.isAgeRestrictedUser((Context)context));
    }

    private void a(int n2, String string, com.applovin.impl.mediation.a.a a2) {
        long l2 = a2.e();
        p p2 = this.b;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Firing ad load failure postback with load time: ");
        stringBuilder.append(l2);
        p2.a("MediationService", stringBuilder.toString());
        HashMap hashMap = new HashMap(1);
        hashMap.put((Object)"{LOAD_TIME_MS}", (Object)String.valueOf((long)l2));
        this.a("mlerr", (Map<String, String>)hashMap, n2, string, (com.applovin.impl.mediation.a.e)a2);
    }

    static /* synthetic */ void a(MediationServiceImpl mediationServiceImpl, com.applovin.impl.mediation.a.a a2) {
        mediationServiceImpl.c(a2);
    }

    static /* synthetic */ void a(MediationServiceImpl mediationServiceImpl, com.applovin.impl.mediation.a.a a2, int n2, String string, MaxAdListener maxAdListener) {
        mediationServiceImpl.a(a2, n2, string, maxAdListener);
    }

    static /* synthetic */ void a(MediationServiceImpl mediationServiceImpl, String string, com.applovin.impl.mediation.a.g g2) {
        mediationServiceImpl.a(string, g2);
    }

    private void a(com.applovin.impl.mediation.a.a a2, int n2, String string, MaxAdListener maxAdListener) {
        this.a(n2, string, a2);
        this.destroyAd((MaxAd)a2);
        com.applovin.impl.sdk.e.h.a((MaxAdListener)maxAdListener, (String)a2.getAdUnitId(), (int)n2, (j)this.a);
    }

    private void a(String string, int n2, com.applovin.impl.mediation.a.e e2) {
        this.a(string, (Map<String, String>)Collections.EMPTY_MAP, n2, null, e2);
    }

    private void a(String string, int n2, String string2, com.applovin.impl.mediation.a.e e2) {
        this.a(string, (Map<String, String>)Collections.EMPTY_MAP, n2, string2, e2);
    }

    private void a(String string, com.applovin.impl.mediation.a.g g2) {
        this.a("serr", (Map<String, String>)Collections.EMPTY_MAP, 0, string, (com.applovin.impl.mediation.a.e)g2);
    }

    private void a(String string, Map<String, String> map, int n2, String string2, com.applovin.impl.mediation.a.e e2) {
        d d2 = new d(string, map, n2, string2, e2, this.a);
        this.a.C().a((com.applovin.impl.sdk.d.a)d2, q.a.m);
    }

    private boolean a(com.applovin.impl.mediation.a.e e2) {
        return this.e.contains((Object)e2.t());
    }

    private void b(int n2, String string, com.applovin.impl.mediation.a.a a2) {
        this.a("mierr", n2, string, (com.applovin.impl.mediation.a.e)a2);
    }

    static /* synthetic */ void b(MediationServiceImpl mediationServiceImpl, com.applovin.impl.mediation.a.a a2) {
        mediationServiceImpl.d(a2);
    }

    static /* synthetic */ void b(MediationServiceImpl mediationServiceImpl, com.applovin.impl.mediation.a.a a2, int n2, String string, MaxAdListener maxAdListener) {
        mediationServiceImpl.b(a2, n2, string, maxAdListener);
    }

    private void b(com.applovin.impl.mediation.a.a a2) {
        p p2 = this.b;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Firing ad preload postback for ");
        stringBuilder.append(a2.u());
        p2.a("MediationService", stringBuilder.toString());
        this.a("mpreload", 0, (com.applovin.impl.mediation.a.e)a2);
    }

    private void b(com.applovin.impl.mediation.a.a a2, int n2, String string, MaxAdListener maxAdListener) {
        this.b(n2, string, a2);
        com.applovin.impl.sdk.e.h.a((MaxAdListener)maxAdListener, (MaxAd)a2, (int)n2, (j)this.a);
    }

    private void c(com.applovin.impl.mediation.a.a a2) {
        long l2 = a2.e();
        p p2 = this.b;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Firing ad load success postback with load time: ");
        stringBuilder.append(l2);
        p2.a("MediationService", stringBuilder.toString());
        String string = a2.a() ? "boad" : "load";
        String string2 = string;
        HashMap hashMap = new HashMap(1);
        hashMap.put((Object)"{LOAD_TIME_MS}", (Object)String.valueOf((long)l2));
        this.a(string2, (Map<String, String>)hashMap, 0, null, (com.applovin.impl.mediation.a.e)a2);
    }

    private void d(com.applovin.impl.mediation.a.a a2) {
        this.a("mclick", 0, (com.applovin.impl.mediation.a.e)a2);
    }

    void a(com.applovin.impl.mediation.a.a a2) {
        p p2 = this.b;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Firing backup ad used to display for ");
        stringBuilder.append(a2.u());
        p2.a("MediationService", stringBuilder.toString());
        this.a("bimp", 0, (com.applovin.impl.mediation.a.e)a2);
    }

    void a(String string) {
        this.e.add((Object)string);
    }

    public void collectSignal(com.applovin.impl.mediation.a.g g2, Activity activity, f.a a2) {
        block0 : {
            block1 : {
                block2 : {
                    String string;
                    block7 : {
                        block3 : {
                            MaxAdapterParametersImpl maxAdapterParametersImpl;
                            StringBuilder stringBuilder;
                            3 var7_6;
                            String string2;
                            h h2;
                            p p2;
                            block6 : {
                                block4 : {
                                    block5 : {
                                        if (g2 == null) break block0;
                                        if (activity == null) break block1;
                                        if (a2 == null) break block2;
                                        h2 = this.d.a((com.applovin.impl.mediation.a.e)g2);
                                        if (h2 == null) break block3;
                                        maxAdapterParametersImpl = this.a(activity.getApplicationContext()).a((com.applovin.impl.mediation.a.e)g2, activity.getApplicationContext()).a();
                                        h2.a((MaxAdapterInitializationParameters)maxAdapterParametersImpl, activity);
                                        var7_6 = new 3(this, a2, g2, h2);
                                        if (!g2.b()) break block4;
                                        if (!this.a((com.applovin.impl.mediation.a.e)g2)) break block5;
                                        p2 = this.b;
                                        stringBuilder = new StringBuilder();
                                        string2 = "Collecting signal for now-initialized adapter: ";
                                        break block6;
                                    }
                                    p p3 = this.b;
                                    StringBuilder stringBuilder2 = new StringBuilder();
                                    stringBuilder2.append("Skip collecting signal for not-initialized adapter: ");
                                    stringBuilder2.append(h2.b());
                                    p3.d("MediationService", stringBuilder2.toString());
                                    string = "Adapter not initialized yet";
                                    break block7;
                                }
                                p2 = this.b;
                                stringBuilder = new StringBuilder();
                                string2 = "Collecting signal for adapter: ";
                            }
                            stringBuilder.append(string2);
                            stringBuilder.append(h2.b());
                            p2.a("MediationService", stringBuilder.toString());
                            h2.a((MaxAdapterSignalCollectionParameters)maxAdapterParametersImpl, g2, activity, (MaxSignalCollectionListener)var7_6);
                            return;
                        }
                        string = "Could not load adapter";
                    }
                    a2.a(com.applovin.impl.mediation.a.f.a(g2, string));
                    return;
                }
                throw new IllegalArgumentException("No callback specified");
            }
            throw new IllegalArgumentException("No activity specified");
        }
        throw new IllegalArgumentException("No spec specified");
    }

    public void destroyAd(MaxAd maxAd) {
        if (maxAd == null) {
            return;
        }
        p p2 = this.b;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Destroying ");
        stringBuilder.append((Object)maxAd);
        p2.b("MediationService", stringBuilder.toString());
        ArrayList arrayList = new ArrayList();
        if (maxAd instanceof e) {
            arrayList.addAll((Collection)((e)maxAd).b());
        } else if (maxAd instanceof com.applovin.impl.mediation.a.a) {
            arrayList.add((Object)((com.applovin.impl.mediation.a.a)maxAd));
        }
        for (com.applovin.impl.mediation.a.a a2 : arrayList) {
            h h2 = a2.b();
            if (h2 == null) continue;
            h2.g();
            a2.g();
        }
    }

    public Collection<String> getFailedAdapterClassnames() {
        return this.d.b();
    }

    public LinkedHashSet<String> getInitializedAdapterNames() {
        return this.e;
    }

    public Collection<String> getLoadedAdapterClassnames() {
        return this.d.a();
    }

    public void initializeAdapter(com.applovin.impl.mediation.a.e e2, Activity activity) {
        if (e2 != null) {
            if (activity != null) {
                h h2 = this.d.a(e2);
                if (h2 != null) {
                    p p2 = this.b;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Initializing adapter ");
                    stringBuilder.append((Object)e2);
                    p2.b("MediationService", stringBuilder.toString());
                    h2.a((MaxAdapterInitializationParameters)this.a(activity.getApplicationContext()).a(e2, activity.getApplicationContext()).a(), activity);
                }
                return;
            }
            throw new IllegalArgumentException("No activity specified");
        }
        throw new IllegalArgumentException("No spec specified");
    }

    public void loadAd(String string, MaxAdFormat maxAdFormat, f f2, Activity activity, MaxAdListener maxAdListener) {
        if (!TextUtils.isEmpty((CharSequence)string)) {
            if (activity != null) {
                if (maxAdListener != null) {
                    this.a.a();
                    if (f2 == null) {
                        f2 = new f.a().a();
                    }
                    f f3 = f2;
                    c c2 = new c(string, maxAdFormat, f3, activity, this.a, maxAdListener);
                    p p2 = this.b;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Scheduling signal collection before fetching next ad for ad unit '");
                    stringBuilder.append(string);
                    stringBuilder.append("'");
                    p2.b("MediationService", stringBuilder.toString());
                    q.a a2 = com.applovin.impl.mediation.c.c.a(maxAdFormat, this.a);
                    b b2 = new b(activity, this.a, (b.a)new 1(this, c2, string, a2));
                    this.a.C().a((com.applovin.impl.sdk.d.a)b2, a2);
                    return;
                }
                throw new IllegalArgumentException("No listener specified");
            }
            throw new IllegalArgumentException("No activity specified");
        }
        throw new IllegalArgumentException("No ad unit ID specified");
    }

    public void loadThirdPartyMediatedAd(String string, com.applovin.impl.mediation.a.a a2, Activity activity, MaxAdListener maxAdListener) {
        if (a2 != null) {
            p p2 = this.b;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Loading ");
            stringBuilder.append((Object)a2);
            stringBuilder.append("...");
            p2.a("MediationService", stringBuilder.toString());
            this.b(a2);
            h h2 = this.d.a((com.applovin.impl.mediation.a.e)a2);
            if (h2 != null) {
                MaxAdapterParametersImpl maxAdapterParametersImpl = this.a(activity.getApplicationContext()).a(a2, activity.getApplicationContext()).a();
                h2.a((MaxAdapterInitializationParameters)maxAdapterParametersImpl, activity);
                com.applovin.impl.mediation.a.a a3 = a2.a(h2);
                h2.a(string, a3);
                a3.f();
                h2.a(string, (MaxAdapterResponseParameters)maxAdapterParametersImpl, a3, activity, (com.applovin.impl.mediation.d)new /* Unavailable Anonymous Inner Class!! */);
                return;
            }
            p p3 = this.b;
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Failed to load ");
            stringBuilder2.append((Object)a2);
            stringBuilder2.append(": adapter not loaded");
            p3.c("MediationService", stringBuilder2.toString());
            this.a(a2, -5001, "", maxAdListener);
            return;
        }
        throw new IllegalArgumentException("No mediated ad specified");
    }

    public void maybeInitialize(Activity activity) {
        if (this.c.compareAndSet(false, true)) {
            com.applovin.impl.mediation.b.a a2 = new com.applovin.impl.mediation.b.a(activity, this.a);
            this.a.C().a((com.applovin.impl.sdk.d.a)a2, q.a.i);
        }
    }

    public void maybeScheduleBackupAdPromotedToPrimaryPostback(com.applovin.impl.mediation.a.a a2) {
        long l2 = a2.e();
        p p2 = this.b;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Firing ad load success postback with load time: ");
        stringBuilder.append(l2);
        p2.a("MediationService", stringBuilder.toString());
        HashMap hashMap = new HashMap(1);
        hashMap.put((Object)"{LOAD_TIME_MS}", (Object)String.valueOf((long)l2));
        this.a("load", (Map<String, String>)hashMap, 0, null, (com.applovin.impl.mediation.a.e)a2);
    }

    public void maybeScheduleCallbackAdImpressionPostback(com.applovin.impl.mediation.a.a a2) {
        this.a("mcimp", 0, (com.applovin.impl.mediation.a.e)a2);
    }

    public void maybeScheduleRawAdImpressionPostback(com.applovin.impl.mediation.a.a a2) {
        this.a("mimp", 0, (com.applovin.impl.mediation.a.e)a2);
    }

    public void maybeScheduleViewabilityAdImpressionPostback(com.applovin.impl.mediation.a.b b2, long l2) {
        HashMap hashMap = new HashMap(1);
        hashMap.put((Object)"{VIEWABILITY_FLAGS}", (Object)String.valueOf((long)l2));
        hashMap.put((Object)"{USED_VIEWABILITY_TIMER}", (Object)String.valueOf((boolean)b2.p()));
        this.a("mvimp", (Map<String, String>)hashMap, 0, null, (com.applovin.impl.mediation.a.e)b2);
    }

    public void showFullscreenAd(MaxAd maxAd, final Activity activity) {
        if (maxAd != null) {
            if (activity != null) {
                if (maxAd instanceof e) {
                    maxAd = ((e)maxAd).a(activity);
                }
                if (maxAd instanceof com.applovin.impl.mediation.a.c) {
                    this.a.R().a(true);
                    final com.applovin.impl.mediation.a.c c2 = (com.applovin.impl.mediation.a.c)maxAd;
                    final h h2 = c2.b();
                    if (h2 != null) {
                        long l2 = c2.B();
                        p p2 = this.b;
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Showing ad ");
                        stringBuilder.append(maxAd.getAdUnitId());
                        stringBuilder.append(" with delay of ");
                        stringBuilder.append(l2);
                        stringBuilder.append("ms...");
                        p2.b("MediationService", stringBuilder.toString());
                        AppLovinSdkUtils.runOnUiThreadDelayed((Runnable)new Runnable(){

                            public void run() {
                                h2.a((com.applovin.impl.mediation.a.a)c2, activity);
                                MediationServiceImpl.this.a.R().a(false);
                                MediationServiceImpl.this.b.a("MediationService", "Scheduling impression for ad manually...");
                                MediationServiceImpl.this.maybeScheduleRawAdImpressionPostback((com.applovin.impl.mediation.a.a)c2);
                            }
                        }, (long)l2);
                        return;
                    }
                    this.a.R().a(false);
                    p p3 = this.b;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Failed to show ");
                    stringBuilder.append((Object)maxAd);
                    stringBuilder.append(": adapter not found");
                    p3.c("MediationService", stringBuilder.toString());
                    p p4 = this.b;
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("There may be an integration problem with the adapter for ad unit id '");
                    stringBuilder2.append(c2.getAdUnitId());
                    stringBuilder2.append("'. Please check if you have a supported version of that SDK integrated into your project.");
                    p4.e("MediationService", stringBuilder2.toString());
                    throw new IllegalStateException("Could not find adapter for provided ad");
                }
                p p5 = this.b;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unable to show ad for '");
                stringBuilder.append(maxAd.getAdUnitId());
                stringBuilder.append("': only REWARDED or INTERSTITIAL ads are eligible for showFullscreenAd(). ");
                stringBuilder.append((Object)maxAd.getFormat());
                stringBuilder.append(" ad was provided.");
                p5.e("MediationService", stringBuilder.toString());
                throw new IllegalArgumentException("Provided ad is not a MediatedFullscreenAd");
            }
            throw new IllegalArgumentException("No activity specified");
        }
        throw new IllegalArgumentException("No ad specified");
    }

}

