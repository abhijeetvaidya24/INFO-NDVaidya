/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.Uri
 *  android.net.Uri$Builder
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.PowerManager
 *  android.os.StrictMode
 *  android.os.StrictMode$ThreadPolicy
 *  android.text.TextUtils
 *  com.applovin.impl.sdk.ad.g
 *  com.applovin.impl.sdk.ad.h
 *  com.applovin.impl.sdk.d
 *  com.applovin.impl.sdk.d.l
 *  com.applovin.impl.sdk.d.o
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Throwable
 *  java.util.Collection
 *  java.util.HashMap
 *  java.util.HashSet
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 *  java.util.concurrent.atomic.AtomicBoolean
 *  org.json.JSONArray
 *  org.json.JSONObject
 */
package com.applovin.impl.sdk;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.os.StrictMode;
import android.text.TextUtils;
import com.applovin.adview.AppLovinAdView;
import com.applovin.adview.AppLovinAdViewEventListener;
import com.applovin.impl.adview.AdViewControllerImpl;
import com.applovin.impl.sdk.AppLovinAdBase;
import com.applovin.impl.sdk.AppLovinAdServiceImpl;
import com.applovin.impl.sdk.ad.c;
import com.applovin.impl.sdk.ad.g;
import com.applovin.impl.sdk.ad.h;
import com.applovin.impl.sdk.ad.j;
import com.applovin.impl.sdk.c.i;
import com.applovin.impl.sdk.d.l;
import com.applovin.impl.sdk.d.o;
import com.applovin.impl.sdk.d.q;
import com.applovin.impl.sdk.d.r;
import com.applovin.impl.sdk.e.m;
import com.applovin.impl.sdk.k;
import com.applovin.impl.sdk.network.PostbackServiceImpl;
import com.applovin.impl.sdk.network.d;
import com.applovin.impl.sdk.network.e;
import com.applovin.impl.sdk.network.f;
import com.applovin.impl.sdk.p;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdService;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import com.applovin.sdk.AppLovinAdUpdateListener;
import com.applovin.sdk.AppLovinPostbackListener;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

public class AppLovinAdServiceImpl
implements AppLovinAdService {
    public static String URI_LOAD_URL = "/adservice/load_url";
    public static String URI_NO_OP = "/adservice/no_op";
    public static String URI_SKIP_AD = "/adservice/skip";
    public static String URI_TRACK_CLICK_IMMEDIATELY = "/adservice/track_click_now";
    private final com.applovin.impl.sdk.j a;
    private final p b;
    private Handler c;
    private final Map<com.applovin.impl.sdk.ad.d, b> d;
    private final Object e = new Object();

    AppLovinAdServiceImpl(com.applovin.impl.sdk.j j2) {
        if (j2 != null) {
            this.a = j2;
            this.b = j2.u();
            this.c = new Handler(Looper.getMainLooper());
            this.d = new HashMap(5);
            this.d.put((Object)com.applovin.impl.sdk.ad.d.c(j2), new Object(){
                final Object a = new Object();
                AppLovinAd b;
                long c;
                boolean d;
                private final Collection<AppLovinAdUpdateListener> e = new HashSet();
                private final Collection<AppLovinAdLoadListener> f = new HashSet();

                public String toString() {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("AdLoadState{loadedAd=");
                    stringBuilder.append((Object)this.b);
                    stringBuilder.append(", loadedAdExpiration=");
                    stringBuilder.append(this.c);
                    stringBuilder.append(", isWaitingForAd=");
                    stringBuilder.append(this.d);
                    stringBuilder.append(", updateListeners=");
                    stringBuilder.append(this.e);
                    stringBuilder.append(", pendingAdListeners=");
                    stringBuilder.append(this.f);
                    stringBuilder.append('}');
                    return stringBuilder.toString();
                }
            });
            this.d.put((Object)com.applovin.impl.sdk.ad.d.d(j2), new /* invalid duplicate definition of identical inner class */);
            this.d.put((Object)com.applovin.impl.sdk.ad.d.e(j2), new /* invalid duplicate definition of identical inner class */);
            this.d.put((Object)com.applovin.impl.sdk.ad.d.f(j2), new /* invalid duplicate definition of identical inner class */);
            this.d.put((Object)com.applovin.impl.sdk.ad.d.g(j2), new /* invalid duplicate definition of identical inner class */);
            return;
        }
        throw new IllegalArgumentException("No sdk specified");
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private b a(com.applovin.impl.sdk.ad.d d2) {
        Object object;
        Object object2 = object = this.e;
        synchronized (object2) {
            b b2 = this.d.get((Object)d2);
            if (b2 == null) {
                b2 = new /* invalid duplicate definition of identical inner class */;
                this.d.put((Object)d2, (Object)b2);
            }
            return b2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private String a(String string, int n2, String string2, boolean bl) {
        try {
            if (!com.applovin.impl.sdk.e.j.b(string)) {
                return null;
            }
            if (n2 >= 0) {
                if (n2 <= 100) return Uri.parse((String)string).buildUpon().appendQueryParameter("pv", Integer.toString((int)n2)).appendQueryParameter("vid_ts", string2).appendQueryParameter("uvs", Boolean.toString((boolean)bl)).build().toString();
            }
        }
        catch (Throwable throwable) {
            p p2 = this.b;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unknown error parsing the video end url: ");
            stringBuilder.append(string);
            p2.b("AppLovinAdService", stringBuilder.toString(), throwable);
            return null;
        }
        n2 = 0;
        return Uri.parse((String)string).buildUpon().appendQueryParameter("pv", Integer.toString((int)n2)).appendQueryParameter("vid_ts", string2).appendQueryParameter("uvs", Boolean.toString((boolean)bl)).build().toString();
    }

    private void a(int n2, AppLovinAdLoadListener appLovinAdLoadListener) {
        if (this.a.a(com.applovin.impl.sdk.b.b.fj).booleanValue()) {
            this.c.post(new Runnable(this, appLovinAdLoadListener, n2){
                final /* synthetic */ AppLovinAdLoadListener a;
                final /* synthetic */ int b;
                final /* synthetic */ AppLovinAdServiceImpl c;
                {
                    this.c = appLovinAdServiceImpl;
                    this.a = appLovinAdLoadListener;
                    this.b = n2;
                }

                public void run() {
                    try {
                        this.a.failedToReceiveAd(this.b);
                        return;
                    }
                    catch (Throwable throwable) {
                        AppLovinAdServiceImpl.a(this.c).c("AppLovinAdService", "Unable to notify listener about ad load failure", throwable);
                        return;
                    }
                }
            });
            return;
        }
        try {
            appLovinAdLoadListener.failedToReceiveAd(n2);
            return;
        }
        catch (Throwable throwable) {
            this.b.c("AppLovinAdService", "Unable to notify listener about ad load failure", throwable);
            return;
        }
    }

    private void a(Uri uri, g g2, AppLovinAdView appLovinAdView, AdViewControllerImpl adViewControllerImpl) {
        if (appLovinAdView != null) {
            adViewControllerImpl.removeClickTrackingOverlay();
            this.a((AppLovinAd)g2);
            if (m.a(appLovinAdView.getContext(), uri, this.a)) {
                com.applovin.impl.sdk.e.h.c(adViewControllerImpl.getAdViewEventListener(), (AppLovinAd)g2, appLovinAdView, this.a);
            }
            adViewControllerImpl.dismissInterstitialIfRequired();
            return;
        }
        this.b.d("AppLovinAdService", "Unable to launch click - adView has been prematurely destroyed");
    }

    static /* synthetic */ void a(AppLovinAdServiceImpl appLovinAdServiceImpl, Uri uri, g g2, AppLovinAdView appLovinAdView, AdViewControllerImpl adViewControllerImpl) {
        appLovinAdServiceImpl.a(uri, g2, appLovinAdView, adViewControllerImpl);
    }

    /*
     * Enabled aggressive block sorting
     */
    private void a(com.applovin.impl.sdk.ad.d d2, a a2) {
        AppLovinAd appLovinAd = (AppLovinAd)((Object)this.a.L().e(d2));
        if (appLovinAd != null) {
            p p2 = this.b;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Using pre-loaded ad: ");
            stringBuilder.append((Object)appLovinAd);
            stringBuilder.append(" for ");
            stringBuilder.append((Object)d2);
            p2.a("AppLovinAdService", stringBuilder.toString());
            a2.adReceived(appLovinAd);
        } else {
            this.a(new com.applovin.impl.sdk.d.m(d2, a2, this.a), (AppLovinAdLoadListener)a2);
        }
        if ((!d2.k() || appLovinAd != null) && (d2.l() || appLovinAd != null && d2.g() > 0)) {
            this.a.L().i(d2);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void a(com.applovin.impl.sdk.ad.d d2, AppLovinAdLoadListener appLovinAdLoadListener) {
        AppLovinAd appLovinAd;
        block11 : {
            Object object;
            block9 : {
                int n2;
                block8 : {
                    block7 : {
                        if (d2 == null) {
                            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("No zone specified");
                            throw illegalArgumentException;
                        }
                        if (appLovinAdLoadListener == null) throw new IllegalArgumentException("No callback specified");
                        if (com.applovin.impl.sdk.e.f.a(this.a.w(), this.a) || this.a.a(com.applovin.impl.sdk.b.b.dP).booleanValue()) break block7;
                        this.b.e("AppLovinAdService", "Failing ad load due to no internet connection.");
                        n2 = -103;
                        break block8;
                    }
                    if (!this.a.a(com.applovin.impl.sdk.b.b.ec).booleanValue() || d2.l() || !this.a.O().a() || this.a.O().a(d2)) break block9;
                    p p2 = this.b;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Failed to load ad for zone (");
                    stringBuilder.append(d2.a());
                    stringBuilder.append("). Please check that the zone has been added to your AppLovin account and given at least 30 minutes to fully propagate.");
                    p2.e("AppLovinAdService", stringBuilder.toString());
                    n2 = -7;
                }
                this.a(n2, appLovinAdLoadListener);
                return;
            }
            p p3 = this.a.u();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Loading next ad of zone {");
            stringBuilder.append((Object)d2);
            stringBuilder.append("}...");
            p3.a("AppLovinAdService", stringBuilder.toString());
            b b2 = this.a(d2);
            Object object2 = object = b2.a;
            synchronized (object2) {
                String string;
                String string2;
                p p4;
                block15 : {
                    block12 : {
                        a a2;
                        block16 : {
                            block13 : {
                                block14 : {
                                    block10 : {
                                        boolean bl = System.currentTimeMillis() > b2.c;
                                        if (b2.b == null || bl) break block10;
                                        appLovinAd = b2.b;
                                        break block11;
                                    }
                                    b2.f.add((Object)appLovinAdLoadListener);
                                    if (b2.d) break block12;
                                    this.b.a("AppLovinAdService", "Loading next ad...");
                                    b2.d = true;
                                    a2 = new a(b2);
                                    if (!d2.j()) break block13;
                                    if (!this.a.L().a(d2, (Object)a2)) break block14;
                                    p4 = this.b;
                                    string = "AppLovinAdService";
                                    string2 = "Attaching load listener to initial preload task...";
                                    break block15;
                                }
                                this.b.a("AppLovinAdService", "Skipped attach of initial preload callback.");
                                break block16;
                            }
                            this.b.a("AppLovinAdService", "Task merge not necessary.");
                        }
                        this.a(d2, a2);
                        appLovinAd = null;
                        break block11;
                    }
                    p4 = this.b;
                    string = "AppLovinAdService";
                    string2 = "Already waiting on an ad load...";
                }
                p4.a(string, string2);
                appLovinAd = null;
            }
        }
        if (appLovinAd == null) return;
        this.a(appLovinAd, appLovinAdLoadListener);
    }

    private void a(com.applovin.impl.sdk.c.a a2, String string) {
        if (com.applovin.impl.sdk.e.j.b(a2.a())) {
            String string2 = m.a(string, a2.a());
            String string3 = com.applovin.impl.sdk.e.j.b(a2.b()) ? m.a(string, a2.b()) : null;
            this.a.F().a(e.j().a(string2).b(string3).a(false).a());
            return;
        }
        this.b.c("AppLovinAdService", "Requested a postback dispatch for a null URL; nothing to do...");
    }

    private void a(com.applovin.impl.sdk.d.a a2, AppLovinAdLoadListener appLovinAdLoadListener) {
        if (!com.applovin.impl.sdk.e.f.a(this.a.w(), this.a) && !this.a.a(com.applovin.impl.sdk.b.b.dP).booleanValue()) {
            this.b.e("AppLovinAdService", "Failing ad load due to no internet connection.");
            this.a(-103, appLovinAdLoadListener);
            return;
        }
        this.a.a();
        p p2 = this.b;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Loading ad using '");
        stringBuilder.append(a2.c());
        stringBuilder.append("'...");
        p2.b("AppLovinAdService", stringBuilder.toString());
        this.a.C().a(a2, q.a.a);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void a(AppLovinAd appLovinAd) {
        if (appLovinAd == null) {
            throw new IllegalArgumentException("No ad specified");
        }
        if (appLovinAd instanceof AppLovinAdBase) {
            Object object;
            b b2 = this.a(((AppLovinAdBase)appLovinAd).getAdZone());
            Object object2 = object = b2.a;
            synchronized (object2) {
                b2.b = null;
                b2.c = 0L;
                return;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unknown ad type specified: ");
        stringBuilder.append(appLovinAd.getClass().getName());
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    private void a(AppLovinAd appLovinAd, AppLovinAdLoadListener appLovinAdLoadListener) {
        if (this.a.a(com.applovin.impl.sdk.b.b.fj).booleanValue()) {
            this.c.post(new Runnable(this, appLovinAdLoadListener, appLovinAd){
                final /* synthetic */ AppLovinAdLoadListener a;
                final /* synthetic */ AppLovinAd b;
                final /* synthetic */ AppLovinAdServiceImpl c;
                {
                    this.c = appLovinAdServiceImpl;
                    this.a = appLovinAdLoadListener;
                    this.b = appLovinAd;
                }

                public void run() {
                    try {
                        this.a.adReceived(this.b);
                        return;
                    }
                    catch (Throwable throwable) {
                        AppLovinAdServiceImpl.a(this.c).c("AppLovinAdService", "Unable to notify listener about a newly loaded ad", throwable);
                        return;
                    }
                }
            });
            return;
        }
        try {
            appLovinAdLoadListener.adReceived(appLovinAd);
            return;
        }
        catch (Throwable throwable) {
            this.b.c("AppLovinAdService", "Unable to notify listener about a newly loaded ad", throwable);
            return;
        }
    }

    private void a(AppLovinAd appLovinAd, AppLovinAdUpdateListener appLovinAdUpdateListener) {
        if (this.a.a(com.applovin.impl.sdk.b.b.fk).booleanValue()) {
            this.c.post(new Runnable(this, appLovinAdUpdateListener, appLovinAd){
                final /* synthetic */ AppLovinAdUpdateListener a;
                final /* synthetic */ AppLovinAd b;
                final /* synthetic */ AppLovinAdServiceImpl c;
                {
                    this.c = appLovinAdServiceImpl;
                    this.a = appLovinAdUpdateListener;
                    this.b = appLovinAd;
                }

                public void run() {
                    try {
                        this.a.adUpdated(this.b);
                        return;
                    }
                    catch (Throwable throwable) {
                        AppLovinAdServiceImpl.a(this.c).c("AppLovinAdService", "Unable to notify listener about an updated loaded ad", throwable);
                        return;
                    }
                }
            });
            return;
        }
        try {
            appLovinAdUpdateListener.adUpdated(appLovinAd);
            return;
        }
        catch (Throwable throwable) {
            this.b.c("AppLovinAdService", "Unable to notify listener about an updated loaded ad", throwable);
            return;
        }
    }

    private void a(String string, List<com.applovin.impl.sdk.c.a> list) {
        if (list != null && !list.isEmpty()) {
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                this.a((com.applovin.impl.sdk.c.a)iterator.next(), string);
            }
        }
    }

    private boolean a() {
        PowerManager powerManager = (PowerManager)this.a.w().getSystemService("power");
        if (powerManager != null) {
            return powerManager.isScreenOn();
        }
        return true;
    }

    private void b(com.applovin.impl.sdk.ad.d d2) {
        long l2 = d2.i();
        if (l2 > 0L) {
            c c2 = new c(d2);
            this.a.C().a(c2, q.a.a, 1000L * (l2 + 2L));
        }
    }

    @Override
    public void addAdUpdateListener(AppLovinAdUpdateListener appLovinAdUpdateListener) {
        this.addAdUpdateListener(appLovinAdUpdateListener, AppLovinAdSize.BANNER);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    @Override
    public void addAdUpdateListener(AppLovinAdUpdateListener appLovinAdUpdateListener, AppLovinAdSize appLovinAdSize) {
        Object object;
        if (appLovinAdUpdateListener == null) throw new IllegalArgumentException("No ad listener specified");
        if (appLovinAdSize == null) throw new IllegalArgumentException("No ad size specified");
        com.applovin.impl.sdk.ad.d d2 = com.applovin.impl.sdk.ad.d.a(appLovinAdSize, AppLovinAdType.REGULAR, this.a);
        b b2 = this.a(d2);
        Object object2 = object = b2.a;
        // MONITORENTER : object2
        long l2 = b2.c LCMP 0L;
        boolean bl = false;
        if (l2 > 0) {
            boolean bl2 = b2.e.contains((Object)appLovinAdUpdateListener);
            bl = false;
            if (!bl2) {
                b2.e.add((Object)appLovinAdUpdateListener);
                bl = true;
                p p2 = this.b;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Added update listener: ");
                stringBuilder.append((Object)appLovinAdUpdateListener);
                p2.a("AppLovinAdService", stringBuilder.toString());
            }
        }
        // MONITOREXIT : object2
        if (!bl) return;
        c c2 = new c(d2);
        this.a.C().a(c2, q.a.a);
    }

    public AppLovinAd dequeueAd(com.applovin.impl.sdk.ad.d d2) {
        AppLovinAd appLovinAd = (AppLovinAd)((Object)this.a.L().d(d2));
        p p2 = this.b;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Dequeued ad: ");
        stringBuilder.append((Object)appLovinAd);
        stringBuilder.append(" for zone: ");
        stringBuilder.append((Object)d2);
        stringBuilder.append("...");
        p2.a("AppLovinAdService", stringBuilder.toString());
        return appLovinAd;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    @Override
    public String getBidToken() {
        StrictMode.ThreadPolicy threadPolicy;
        Throwable throwable22;
        block6 : {
            com.applovin.impl.sdk.ad.f f2;
            block7 : {
                threadPolicy = StrictMode.allowThreadDiskReads();
                int n2 = this.a.a(com.applovin.impl.sdk.b.b.aH);
                f2 = this.a.G().a(n2);
                StrictMode.setThreadPolicy((StrictMode.ThreadPolicy)threadPolicy);
                break block7;
                {
                    catch (Throwable throwable22) {
                        break block6;
                    }
                    catch (Throwable throwable3) {}
                    {
                        this.b.b("AppLovinAdService", "Encountered error while generating bid token", throwable3);
                    }
                    StrictMode.setThreadPolicy((StrictMode.ThreadPolicy)threadPolicy);
                    f2 = null;
                }
            }
            if (f2 == null) return "";
            if (!TextUtils.isEmpty((CharSequence)f2.a())) {
                p p2 = this.b;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Generated bid token: ");
                stringBuilder.append((Object)f2);
                p2.a("AppLovinAdService", stringBuilder.toString());
            } else {
                this.b.d("AppLovinAdService", "Failed to generate bid token");
            }
            if (f2.b()) return f2.a();
            this.b.e("AppLovinAdService", "Bid token generated too early in session - please initialize the SDK first. Not doing so can negatively impact your eCPMs!");
            return f2.a();
        }
        StrictMode.setThreadPolicy((StrictMode.ThreadPolicy)threadPolicy);
        throw throwable22;
    }

    @Override
    public boolean hasPreloadedAd(AppLovinAdSize appLovinAdSize) {
        com.applovin.impl.sdk.ad.d d2 = com.applovin.impl.sdk.ad.d.a(appLovinAdSize, AppLovinAdType.REGULAR, this.a);
        return this.a.L().g(d2);
    }

    @Override
    public boolean hasPreloadedAdForZoneId(String string) {
        if (TextUtils.isEmpty((CharSequence)string)) {
            this.b.e("AppLovinAdService", "Unable to check if ad is preloaded - invalid zone id");
            return false;
        }
        com.applovin.impl.sdk.ad.d d2 = com.applovin.impl.sdk.ad.d.a(string, this.a);
        return this.a.L().g(d2);
    }

    @Override
    public void loadNextAd(AppLovinAdSize appLovinAdSize, AppLovinAdLoadListener appLovinAdLoadListener) {
        this.a(com.applovin.impl.sdk.ad.d.a(appLovinAdSize, AppLovinAdType.REGULAR, this.a), appLovinAdLoadListener);
    }

    public void loadNextAd(String string, AppLovinAdSize appLovinAdSize, AppLovinAdLoadListener appLovinAdLoadListener) {
        p p2 = this.b;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Loading next ad of zone {");
        stringBuilder.append(string);
        stringBuilder.append("} with size ");
        stringBuilder.append((Object)appLovinAdSize);
        p2.a("AppLovinAdService", stringBuilder.toString());
        this.a(com.applovin.impl.sdk.ad.d.a(appLovinAdSize, AppLovinAdType.REGULAR, string, this.a), appLovinAdLoadListener);
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public void loadNextAdForAdToken(String string, AppLovinAdLoadListener appLovinAdLoadListener) {
        block9 : {
            com.applovin.impl.sdk.ad.c c2;
            block7 : {
                block8 : {
                    void var25_8;
                    block6 : {
                        block5 : {
                            String string2 = string != null ? string.trim() : null;
                            if (TextUtils.isEmpty((CharSequence)string2)) {
                                this.b.e("AppLovinAdService", "Invalid ad token specified");
                                this.a(-8, appLovinAdLoadListener);
                                return;
                            }
                            c2 = new com.applovin.impl.sdk.ad.c(string2, this.a);
                            if (c2.b() != c.a.b) break block5;
                            p p2 = this.b;
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("Loading next ad for token: ");
                            stringBuilder.append((Object)c2);
                            p2.a("AppLovinAdService", stringBuilder.toString());
                            o o2 = new o(c2, appLovinAdLoadListener, this.a);
                            break block6;
                        }
                        if (c2.b() != c.a.c) break block7;
                        JSONObject jSONObject = c2.d();
                        if (jSONObject == null) break block8;
                        com.applovin.impl.sdk.e.f.f(jSONObject, this.a);
                        com.applovin.impl.sdk.e.f.d(jSONObject, this.a);
                        com.applovin.impl.sdk.e.f.c(jSONObject, this.a);
                        if (com.applovin.impl.sdk.e.g.a(jSONObject, "ads", new JSONArray(), this.a).length() <= 0) {
                            p p3 = this.b;
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("No ad returned from the server for token: ");
                            stringBuilder.append((Object)c2);
                            p3.d("AppLovinAdService", stringBuilder.toString());
                            appLovinAdLoadListener.failedToReceiveAd(204);
                            return;
                        }
                        p p4 = this.b;
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Rendering ad for token: ");
                        stringBuilder.append((Object)c2);
                        p4.a("AppLovinAdService", stringBuilder.toString());
                        com.applovin.impl.sdk.ad.d d2 = m.a(jSONObject, this.a);
                        com.applovin.impl.sdk.ad.b b2 = com.applovin.impl.sdk.ad.b.f;
                        com.applovin.impl.sdk.j j2 = this.a;
                        r r2 = new r(jSONObject, d2, b2, appLovinAdLoadListener, j2);
                    }
                    this.a((com.applovin.impl.sdk.d.a)var25_8, appLovinAdLoadListener);
                    return;
                }
                p p5 = this.b;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unable to retrieve ad response JSON from token: ");
                stringBuilder.append((Object)c2);
                p5.d("AppLovinAdService", stringBuilder.toString());
                break block9;
            }
            p p6 = this.b;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Invalid ad token specified: ");
            stringBuilder.append((Object)c2);
            p6.e("AppLovinAdService", stringBuilder.toString());
        }
        appLovinAdLoadListener.failedToReceiveAd(-8);
    }

    @Override
    public void loadNextAdForZoneId(String string, AppLovinAdLoadListener appLovinAdLoadListener) {
        if (!TextUtils.isEmpty((CharSequence)string)) {
            p p2 = this.b;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Loading next ad of zone {");
            stringBuilder.append(string);
            stringBuilder.append("}");
            p2.a("AppLovinAdService", stringBuilder.toString());
            this.a(com.applovin.impl.sdk.ad.d.a(string, this.a), appLovinAdLoadListener);
            return;
        }
        throw new IllegalArgumentException("No zone id specified");
    }

    @Override
    public void loadNextAdForZoneIds(List<String> list, AppLovinAdLoadListener appLovinAdLoadListener) {
        List<String> list2 = com.applovin.impl.sdk.e.d.a(list);
        if (list2 != null && !list2.isEmpty()) {
            p p2 = this.b;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Loading next ad for zones: ");
            stringBuilder.append(list2);
            p2.a("AppLovinAdService", stringBuilder.toString());
            this.a((com.applovin.impl.sdk.d.a)new l(list2, appLovinAdLoadListener, this.a), appLovinAdLoadListener);
            return;
        }
        this.b.e("AppLovinAdService", "No zones were provided");
        this.a(-7, appLovinAdLoadListener);
    }

    public void loadNextIncentivizedAd(String string, AppLovinAdLoadListener appLovinAdLoadListener) {
        p p2 = this.b;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Loading next incentivized ad of zone {");
        stringBuilder.append(string);
        stringBuilder.append("}");
        p2.a("AppLovinAdService", stringBuilder.toString());
        this.a(com.applovin.impl.sdk.ad.d.c(string, this.a), appLovinAdLoadListener);
    }

    @Override
    public void preloadAd(AppLovinAdSize appLovinAdSize) {
        this.a.a();
        com.applovin.impl.sdk.ad.d d2 = com.applovin.impl.sdk.ad.d.a(appLovinAdSize, AppLovinAdType.REGULAR, this.a);
        this.a.L().i(d2);
    }

    @Override
    public void preloadAdForZoneId(String string) {
        if (TextUtils.isEmpty((CharSequence)string)) {
            this.b.e("AppLovinAdService", "Unable to preload ad for invalid zone identifier");
            return;
        }
        com.applovin.impl.sdk.ad.d d2 = com.applovin.impl.sdk.ad.d.a(string, this.a);
        this.a.L().h(d2);
        this.a.L().i(d2);
    }

    public void preloadAds(com.applovin.impl.sdk.ad.d d2) {
        this.a.L().h(d2);
        int n2 = d2.g();
        if (n2 == 0 && this.a.L().b(d2)) {
            n2 = 1;
        }
        this.a.L().b(d2, n2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void removeAdUpdateListener(AppLovinAdUpdateListener appLovinAdUpdateListener, AppLovinAdSize appLovinAdSize) {
        Object object;
        if (appLovinAdSize == null) {
            throw new IllegalArgumentException("No ad size specified");
        }
        if (appLovinAdUpdateListener == null) {
            return;
        }
        b b2 = this.a(com.applovin.impl.sdk.ad.d.a(appLovinAdSize, AppLovinAdType.REGULAR, this.a));
        Object object2 = object = b2.a;
        synchronized (object2) {
            if (b2.e.contains((Object)appLovinAdUpdateListener)) {
                b2.e.remove((Object)appLovinAdUpdateListener);
                p p2 = this.b;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Removed update listener: ");
                stringBuilder.append((Object)appLovinAdUpdateListener);
                p2.a("AppLovinAdService", stringBuilder.toString());
            }
            return;
        }
    }

    public void trackAndLaunchClick(AppLovinAd appLovinAd, String string, AppLovinAdView appLovinAdView, AdViewControllerImpl adViewControllerImpl, Uri uri) {
        if (appLovinAd == null) {
            this.b.d("AppLovinAdService", "Unable to track ad view click. No ad specified");
            return;
        }
        this.b.a("AppLovinAdService", "Tracking click on an ad...");
        g g2 = (g)appLovinAd;
        this.a(string, (List<com.applovin.impl.sdk.c.a>)g2.ai());
        this.a(uri, g2, appLovinAdView, adViewControllerImpl);
    }

    public void trackAndLaunchForegroundClick(AppLovinAd appLovinAd, String string, final AppLovinAdView appLovinAdView, final AdViewControllerImpl adViewControllerImpl, final Uri uri) {
        if (appLovinAd == null) {
            this.b.d("AppLovinAdService", "Unable to track foreground click. No ad specified");
            return;
        }
        this.b.a("AppLovinAdService", "Tracking foreground click on an ad...");
        final g g2 = (g)appLovinAd;
        int n2 = this.a.a(com.applovin.impl.sdk.b.b.ci);
        int n3 = this.a.a(com.applovin.impl.sdk.b.b.cj);
        int n4 = this.a.a(com.applovin.impl.sdk.b.b.ck);
        List list = g2.ai();
        if (list != null && !list.isEmpty()) {
            AppLovinPostbackListener appLovinPostbackListener = new AppLovinPostbackListener(){
                private final AtomicBoolean f = new AtomicBoolean(false);
                private final AtomicBoolean g = new AtomicBoolean(false);

                static /* synthetic */ AtomicBoolean a(4 var0) {
                    return var0.f;
                }

                static /* synthetic */ AtomicBoolean b(4 var0) {
                    return var0.g;
                }

                @Override
                public void onPostbackFailure(String string, int n2) {
                    AppLovinAdServiceImpl.this.c.post(new Runnable(this){
                        final /* synthetic */ 4 a;
                        {
                            this.a = var1_1;
                        }

                        public void run() {
                            if (4.b(this.a).compareAndSet(false, true)) {
                                this.a.adViewControllerImpl.removeClickTrackingOverlay();
                            }
                        }
                    });
                }

                @Override
                public void onPostbackSuccess(String string) {
                    AppLovinAdServiceImpl.this.c.post(new Runnable(this){
                        final /* synthetic */ 4 a;
                        {
                            this.a = var1_1;
                        }

                        public void run() {
                            if (!this.a.adViewControllerImpl.isForegroundClickInvalidated() && 4.a(this.a).compareAndSet(false, true)) {
                                AppLovinAdServiceImpl.a(this.a.AppLovinAdServiceImpl.this, this.a.uri, this.a.g2, this.a.appLovinAdView, this.a.adViewControllerImpl);
                            }
                        }
                    });
                }
            };
            for (com.applovin.impl.sdk.c.a a2 : list) {
                if (com.applovin.impl.sdk.e.j.b(a2.a())) {
                    String string2 = m.a(string, a2.a());
                    String string3 = com.applovin.impl.sdk.e.j.b(a2.b()) ? m.a(string, a2.b()) : null;
                    f f2 = f.b(this.a).d(string2).f(string3).d(n2).f(n3).e(n4).b(false).b();
                    this.a.J().dispatchPostbackRequest(f2, appLovinPostbackListener);
                    continue;
                }
                this.b.c("AppLovinAdService", "Requested a postback dispatch for an empty click URL; nothing to do...");
            }
        } else {
            p p2 = this.b;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unable to submit postback for AD #");
            stringBuilder.append(appLovinAd.getAdIdNumber());
            stringBuilder.append(". Missing click tracking URL.");
            p2.c("AppLovinAdService", stringBuilder.toString());
        }
    }

    public void trackAndLaunchVideoClick(AppLovinAd appLovinAd, String string, AppLovinAdView appLovinAdView, Uri uri) {
        if (appLovinAd == null) {
            this.b.d("AppLovinAdService", "Unable to track video click. No ad specified");
            return;
        }
        this.b.a("AppLovinAdService", "Tracking VIDEO click on an ad...");
        this.a(string, (List<com.applovin.impl.sdk.c.a>)((g)appLovinAd).aj());
        m.a(appLovinAdView.getContext(), uri, this.a);
    }

    public void trackImpression(g g2, String string) {
        if (g2 == null) {
            this.b.d("AppLovinAdService", "Unable to track impression click. No ad specified");
            return;
        }
        this.b.a("AppLovinAdService", "Tracking impression on ad...");
        this.a(string, (List<com.applovin.impl.sdk.c.a>)g2.ak());
    }

    public void trackVideoEnd(g g2, String string, int n2, boolean bl) {
        if (g2 == null) {
            this.b.d("AppLovinAdService", "Unable to track video end. No ad specified");
            return;
        }
        this.b.a("AppLovinAdService", "Tracking video end on ad...");
        List list = g2.ah();
        if (list != null && !list.isEmpty()) {
            String string2 = Long.toString((long)System.currentTimeMillis());
            for (com.applovin.impl.sdk.c.a a2 : list) {
                if (com.applovin.impl.sdk.e.j.b(a2.a())) {
                    String string3 = this.a(a2.a(), n2, string2, bl);
                    String string4 = this.a(a2.b(), n2, string2, bl);
                    if (string3 != null) {
                        this.a(new com.applovin.impl.sdk.c.a(string3, string4), string);
                        continue;
                    }
                    p p2 = this.b;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Failed to parse url: ");
                    stringBuilder.append(a2.a());
                    p2.d("AppLovinAdService", stringBuilder.toString());
                    continue;
                }
                this.b.c("AppLovinAdService", "Requested a postback dispatch for an empty video end URL; nothing to do...");
            }
        } else {
            p p3 = this.b;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unable to submit persistent postback for AD #");
            stringBuilder.append(g2.getAdIdNumber());
            stringBuilder.append(". Missing video end tracking URL.");
            p3.c("AppLovinAdService", stringBuilder.toString());
        }
    }

    private class a
    implements AppLovinAdLoadListener {
        private final b b;

        private a(b b2) {
            this.b = b2;
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
        @Override
        public void adReceived(AppLovinAd appLovinAd) {
            Object object;
            com.applovin.impl.sdk.ad.d d2 = ((AppLovinAdBase)appLovinAd).getAdZone();
            if (!(appLovinAd instanceof h) && d2.k()) {
                AppLovinAdServiceImpl.this.a.L().adReceived(appLovinAd);
                appLovinAd = new h(d2, AppLovinAdServiceImpl.this.a);
            }
            Object object2 = object = this.b.a;
            // MONITORENTER : object2
            if (d2.h()) {
                long l2 = d2.i();
                if (l2 > 0L) {
                    this.b.c = System.currentTimeMillis() + l2 * 1000L;
                } else if (l2 == 0L) {
                    this.b.c = Long.MAX_VALUE;
                }
                this.b.b = appLovinAd;
            } else {
                this.b.b = null;
                this.b.c = 0L;
            }
            HashSet hashSet = new HashSet(this.b.f);
            this.b.f.clear();
            HashSet hashSet2 = new HashSet(this.b.e);
            this.b.d = false;
            // MONITOREXIT : object2
            AppLovinAdServiceImpl.this.b(d2);
            for (AppLovinAdLoadListener appLovinAdLoadListener : hashSet) {
                AppLovinAdServiceImpl.this.a(appLovinAd, appLovinAdLoadListener);
            }
            Iterator iterator = hashSet2.iterator();
            while (iterator.hasNext()) {
                AppLovinAdUpdateListener appLovinAdUpdateListener = (AppLovinAdUpdateListener)iterator.next();
                AppLovinAdServiceImpl.this.a(appLovinAd, appLovinAdUpdateListener);
            }
            return;
            {
                catch (Throwable throwable) {}
                {
                    // MONITOREXIT : object2
                    throw throwable;
                }
            }
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
        @Override
        public void failedToReceiveAd(int n2) {
            Object object;
            Object object2 = object = this.b.a;
            // MONITORENTER : object2
            HashSet hashSet = new HashSet(this.b.f);
            this.b.f.clear();
            this.b.d = false;
            // MONITOREXIT : object2
            Iterator iterator = hashSet.iterator();
            while (iterator.hasNext()) {
                AppLovinAdLoadListener appLovinAdLoadListener = (AppLovinAdLoadListener)iterator.next();
                AppLovinAdServiceImpl.this.a(n2, appLovinAdLoadListener);
            }
            return;
            {
                catch (Throwable throwable) {}
                {
                    // MONITOREXIT : object2
                    throw throwable;
                }
            }
        }
    }

    private class c
    extends com.applovin.impl.sdk.d.a {
        private final com.applovin.impl.sdk.ad.d c;

        private c(com.applovin.impl.sdk.ad.d d2) {
            super("UpdateAdTask", AppLovinAdServiceImpl.this.a);
            this.c = d2;
        }

        @Override
        public i a() {
            return i.y;
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        public void run() {
            Object object;
            p p2 = AppLovinAdServiceImpl.this.b;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Attempt update for spec: ");
            stringBuilder.append((Object)this.c);
            p2.a("AppLovinAdService", stringBuilder.toString());
            b b2 = AppLovinAdServiceImpl.this.a(this.c);
            Object object2 = object = b2.a;
            synchronized (object2) {
                boolean bl = this.c.h();
                boolean bl2 = AppLovinAdServiceImpl.this.a();
                boolean bl3 = !b2.e.isEmpty();
                long l2 = System.currentTimeMillis() LCMP b2.c;
                boolean bl4 = false;
                if (l2 > 0) {
                    bl4 = true;
                }
                p p3 = AppLovinAdServiceImpl.this.b;
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("Update ad states - isRefreshEnabled=");
                stringBuilder2.append(bl);
                stringBuilder2.append(" hasUpdateListeners=");
                stringBuilder2.append(bl3);
                stringBuilder2.append(" isCurrentAdExpired=");
                stringBuilder2.append(bl4);
                stringBuilder2.append(" isDeviceOn=");
                stringBuilder2.append(bl2);
                stringBuilder2.append(" isWaitingForAd=");
                stringBuilder2.append(b2.d);
                p3.a("AppLovinAdService", stringBuilder2.toString());
                if (bl && bl3 && bl4 && bl2 && !b2.d) {
                    AppLovinAdServiceImpl.this.b.a("AppLovinAdService", "Performing ad update...");
                    b2.d = true;
                    AppLovinAdServiceImpl.this.a(this.c, new a(b2));
                } else {
                    AppLovinAdServiceImpl.this.b.a("AppLovinAdService", "Ad update skipped");
                }
                return;
            }
        }
    }

}

