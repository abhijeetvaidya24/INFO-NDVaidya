/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  com.applovin.impl.mediation.a.c
 *  com.applovin.impl.mediation.ads.MaxInterstitialImpl
 *  com.applovin.impl.mediation.ads.a.b$a
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.concurrent.TimeUnit
 *  java.util.concurrent.atomic.AtomicBoolean
 */
package com.applovin.impl.mediation.ads.a;

import android.app.Activity;
import com.applovin.impl.mediation.MediationServiceImpl;
import com.applovin.impl.mediation.a.c;
import com.applovin.impl.mediation.ads.MaxInterstitialImpl;
import com.applovin.impl.mediation.ads.a.b;
import com.applovin.impl.mediation.e;
import com.applovin.impl.mediation.f;
import com.applovin.impl.sdk.b;
import com.applovin.impl.sdk.j;
import com.applovin.impl.sdk.p;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdListener;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/*
 * Exception performing whole class analysis.
 */
public abstract class b
extends com.applovin.impl.mediation.ads.a.a
implements b.a {
    private final com.applovin.impl.sdk.b a;
    private final com.applovin.impl.mediation.b b;
    private final Object c;
    private MaxAd d;
    private b e;
    private final AtomicBoolean f;
    protected final a listenerWrapper;

    protected b(String string, String string2, j j2) {
        super(string, string2, j2);
        this.c = new Object();
        this.d = null;
        this.e = b.a;
        this.f = new AtomicBoolean();
        this.listenerWrapper = new /* Unavailable Anonymous Inner Class!! */;
        this.a = new com.applovin.impl.sdk.b(j2, this);
        this.b = new com.applovin.impl.mediation.b(j2, (MaxAdListener)this.listenerWrapper);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private MaxAd a() {
        Object object;
        Object object2 = object = this.c;
        synchronized (object2) {
            MaxAd maxAd = this.d;
            this.d = null;
            return maxAd;
        }
    }

    static /* synthetic */ MaxAd a(b b2) {
        return b2.a();
    }

    static /* synthetic */ void a(b b2, MaxAd maxAd) {
        b2.b(maxAd);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void a(MaxAd maxAd) {
        Object object;
        Object object2 = object = this.c;
        synchronized (object2) {
            this.d = maxAd;
            return;
        }
    }

    static /* synthetic */ AtomicBoolean b(b b2) {
        return b2.f;
    }

    private void b() {
        MaxAd maxAd = this.a();
        this.sdk.a(this.getActivity()).destroyAd(maxAd);
    }

    private void b(MaxAd maxAd) {
        this.a(maxAd);
        this.c(maxAd);
    }

    static /* synthetic */ void c(b b2) {
        b2.b();
    }

    private void c(MaxAd maxAd) {
        long l2 = maxAd instanceof c ? ((c)maxAd).h() : (maxAd instanceof e ? ((e)maxAd).d() : -1L);
        if (l2 >= 0L) {
            p p2 = this.logger;
            String string = this.tag;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Scheduling ad expiration ");
            stringBuilder.append(TimeUnit.MILLISECONDS.toMinutes(l2));
            stringBuilder.append(" minutes from now for ");
            stringBuilder.append(this.getAdUnitId());
            stringBuilder.append(" ...");
            p2.a(string, stringBuilder.toString());
            this.a.a(l2);
        }
    }

    static /* synthetic */ com.applovin.impl.sdk.b d(b b2) {
        return b2.a;
    }

    static /* synthetic */ MaxAd e(b b2) {
        return b2.d;
    }

    static /* synthetic */ com.applovin.impl.mediation.b f(b b2) {
        return b2.b;
    }

    public void destroy() {
        this.transitionToState(b.e, new Runnable(this){
            final /* synthetic */ b a;
            {
                this.a = b2;
            }

            public void run() {
                MaxAd maxAd = b.a(this.a);
                p p2 = this.a.logger;
                String string = this.a.tag;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Destroying ad for '");
                stringBuilder.append(this.a.adUnitId);
                stringBuilder.append("'; current ad: ");
                stringBuilder.append((Object)maxAd);
                stringBuilder.append("...");
                p2.a(string, stringBuilder.toString());
                this.a.sdk.a(this.a.getActivity()).destroyAd(maxAd);
            }
        });
    }

    protected abstract Activity getActivity();

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    protected MaxAd getLoadedAd() {
        Object object;
        Object object2 = object = this.c;
        synchronized (object2) {
            return this.d;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean isReady() {
        Object object;
        Object object2 = object = this.c;
        synchronized (object2) {
            if (this.d == null) return false;
            if (!this.d.isReady()) return false;
            if (this.e != b.c) return false;
            return true;
        }
    }

    @Override
    public void onAdExpired() {
        p p2 = this.logger;
        String string = this.tag;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Ad expired ");
        stringBuilder.append(this.getAdUnitId());
        p2.a(string, stringBuilder.toString());
        this.f.set(true);
        this.loadRequestBuilder.a("expired_ad_ad_unit_id", this.getAdUnitId());
        MediationServiceImpl mediationServiceImpl = this.sdk.a(this.getActivity());
        String string2 = this.adUnitId;
        MaxAdFormat maxAdFormat = this instanceof MaxInterstitialImpl ? MaxAdFormat.INTERSTITIAL : MaxAdFormat.REWARDED;
        mediationServiceImpl.loadAd(string2, maxAdFormat, this.loadRequestBuilder.a(), this.getActivity(), (MaxAdListener)this.listenerWrapper);
    }

    protected void onTransitionedToState(b b2, b b3) {
    }

    protected void showFullscreenAd(Activity activity) {
        MaxAd maxAd = this.getLoadedAd();
        if (maxAd instanceof e) {
            maxAd = ((e)maxAd).a(activity);
        }
        c c2 = (c)maxAd;
        this.b.b(c2);
        p p2 = this.logger;
        String string = this.tag;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Showing ad for '");
        stringBuilder.append(this.adUnitId);
        stringBuilder.append("'; loaded ad: ");
        stringBuilder.append((Object)c2);
        stringBuilder.append("...");
        p2.a(string, stringBuilder.toString());
        this.sdk.a(activity).showFullscreenAd((MaxAd)c2, activity);
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    protected void transitionToState(b var1_1, Runnable var2_2) {
        block8 : {
            block22 : {
                block10 : {
                    block18 : {
                        block21 : {
                            block20 : {
                                block19 : {
                                    block15 : {
                                        block17 : {
                                            block16 : {
                                                block12 : {
                                                    block14 : {
                                                        block13 : {
                                                            block9 : {
                                                                block11 : {
                                                                    var3_3 = this.e;
                                                                    var50_5 = var4_4 = this.c;
                                                                    // MONITORENTER : var50_5
                                                                    var6_6 = this.logger;
                                                                    var7_7 = this.tag;
                                                                    var8_8 = new StringBuilder();
                                                                    var8_8.append("Attempting state transition from ");
                                                                    var8_8.append((Object)var3_3);
                                                                    var8_8.append(" to ");
                                                                    var8_8.append((Object)var1_1);
                                                                    var6_6.a(var7_7, var8_8.toString());
                                                                    if (var3_3 != b.a) break block9;
                                                                    if (var1_1 == b.b || var1_1 == b.e) break block10;
                                                                    if (var1_1 != b.d) break block11;
                                                                    var35_9 = this.logger;
                                                                    var36_10 = this.tag;
                                                                    var37_11 = "No ad is loading or loaded";
                                                                    ** GOTO lbl109
                                                                }
                                                                var13_13 = this.logger;
                                                                var14_14 = this.tag;
                                                                var47_15 = new StringBuilder();
                                                                var47_15.append("Unable to transition to: ");
                                                                var47_15.append((Object)var1_1);
                                                                var18_16 = var47_15.toString();
                                                                ** GOTO lbl118
                                                            }
                                                            if (var3_3 != b.b) break block12;
                                                            if (var1_1 == b.a) break block10;
                                                            if (var1_1 != b.b) break block13;
                                                            var35_9 = this.logger;
                                                            var36_10 = this.tag;
                                                            var37_11 = "An ad is already loading";
                                                            ** GOTO lbl109
                                                        }
                                                        if (var1_1 == b.c) break block10;
                                                        if (var1_1 != b.d) break block14;
                                                        var35_9 = this.logger;
                                                        var36_10 = this.tag;
                                                        var37_11 = "An ad is not ready to be shown yet";
                                                        ** GOTO lbl109
                                                    }
                                                    if (var1_1 == b.e) break block10;
                                                    var13_13 = this.logger;
                                                    var14_14 = this.tag;
                                                    var44_17 = new StringBuilder();
                                                    var44_17.append("Unable to transition to: ");
                                                    var44_17.append((Object)var1_1);
                                                    var18_16 = var44_17.toString();
                                                    ** GOTO lbl118
                                                }
                                                if (var3_3 != b.c) break block15;
                                                if (var1_1 == b.a) break block10;
                                                if (var1_1 != b.b) break block16;
                                                var35_9 = this.logger;
                                                var36_10 = this.tag;
                                                var37_11 = "An ad is already loaded";
                                                ** GOTO lbl109
                                            }
                                            if (var1_1 != b.c) break block17;
                                            var13_13 = this.logger;
                                            var14_14 = this.tag;
                                            var18_16 = "An ad is already marked as ready";
                                            ** GOTO lbl118
                                        }
                                        if (var1_1 == b.d || var1_1 == b.e) break block10;
                                        var13_13 = this.logger;
                                        var14_14 = this.tag;
                                        var41_18 = new StringBuilder();
                                        var41_18.append("Unable to transition to: ");
                                        var41_18.append((Object)var1_1);
                                        var18_16 = var41_18.toString();
                                        ** GOTO lbl118
                                    }
                                    if (var3_3 != b.d) break block18;
                                    if (var1_1 == b.a) break block10;
                                    if (var1_1 != b.b) break block19;
                                    var35_9 = this.logger;
                                    var36_10 = this.tag;
                                    var37_11 = "Can not load another interstitial while the ad is showing";
                                    ** GOTO lbl109
                                }
                                if (var1_1 != b.c) break block20;
                                var13_13 = this.logger;
                                var14_14 = this.tag;
                                var18_16 = "An ad is already showing, ignoring";
                                ** GOTO lbl118
                            }
                            if (var1_1 != b.d) break block21;
                            var35_9 = this.logger;
                            var36_10 = this.tag;
                            var37_11 = "The ad is already showing, not showing another one";
                            ** GOTO lbl109
                        }
                        if (var1_1 == b.e) break block10;
                        var13_13 = this.logger;
                        var14_14 = this.tag;
                        var38_19 = new StringBuilder();
                        var38_19.append("Unable to transition to: ");
                        var38_19.append((Object)var1_1);
                        var18_16 = var38_19.toString();
                        ** GOTO lbl118
                    }
                    if (var3_3 == b.e) {
                        var35_9 = this.logger;
                        var36_10 = this.tag;
                        var37_11 = "No operations are allowed on a destroyed instance";
lbl109: // 7 sources:
                        var35_9.e(var36_10, var37_11);
                        var19_12 = false;
                    } else {
                        var13_13 = this.logger;
                        var14_14 = this.tag;
                        var15_20 = new StringBuilder();
                        var15_20.append("Unknown state: ");
                        var15_20.append((Object)this.e);
                        var18_16 = var15_20.toString();
lbl118: // 7 sources:
                        var13_13.d(var14_14, var18_16);
                        var19_12 = false;
                    }
                    break block22;
                }
                var19_12 = true;
            }
            if (var19_12) {
                var20_21 = this.logger;
                var21_22 = this.tag;
                var22_23 = new StringBuilder();
                var22_23.append("Transitioning from ");
                var22_23.append((Object)this.e);
                var22_23.append(" to ");
                var22_23.append((Object)var1_1);
                var22_23.append("...");
                var20_21.a(var21_22, var22_23.toString());
                this.e = var1_1;
            } else {
                var28_24 = this.logger;
                var29_25 = this.tag;
                var30_26 = new StringBuilder();
                var30_26.append("Not allowed transition from ");
                var30_26.append((Object)this.e);
                var30_26.append(" to ");
                var30_26.append((Object)var1_1);
                var28_24.c(var29_25, var30_26.toString());
            }
            // MONITOREXIT : var50_5
            if (var19_12 == false) return;
            if (var2_2 == null) break block8;
            {
                catch (Throwable var5_27) {}
                {
                    // MONITOREXIT : var50_5
                    throw var5_27;
                }
            }
            var2_2.run();
        }
        this.onTransitionedToState(var3_3, var1_1);
    }

}

