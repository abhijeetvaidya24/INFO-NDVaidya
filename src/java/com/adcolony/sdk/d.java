/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.AlertDialog
 *  android.content.Context
 *  android.content.Intent
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.VideoView
 *  java.lang.Boolean
 *  java.lang.Class
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.HashMap
 *  java.util.concurrent.ConcurrentHashMap
 *  org.json.JSONObject
 */
package com.adcolony.sdk;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.VideoView;
import com.adcolony.sdk.AdColonyAdOptions;
import com.adcolony.sdk.AdColonyAdViewActivity;
import com.adcolony.sdk.AdColonyInterstitial;
import com.adcolony.sdk.AdColonyInterstitialListener;
import com.adcolony.sdk.AdColonyNativeAdView;
import com.adcolony.sdk.AdColonyNativeAdViewListener;
import com.adcolony.sdk.AdColonyZone;
import com.adcolony.sdk.a;
import com.adcolony.sdk.ad;
import com.adcolony.sdk.af;
import com.adcolony.sdk.as;
import com.adcolony.sdk.au;
import com.adcolony.sdk.av;
import com.adcolony.sdk.aw;
import com.adcolony.sdk.ax;
import com.adcolony.sdk.ay;
import com.adcolony.sdk.c;
import com.adcolony.sdk.d;
import com.adcolony.sdk.e;
import com.adcolony.sdk.f;
import com.adcolony.sdk.g;
import com.adcolony.sdk.l;
import com.adcolony.sdk.n;
import com.adcolony.sdk.o;
import com.adcolony.sdk.r;
import com.adcolony.sdk.u;
import com.adcolony.sdk.w;
import com.adcolony.sdk.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

class d {
    private HashMap<String, c> a;
    private ConcurrentHashMap<String, AdColonyInterstitial> b;
    private HashMap<String, ay> c;
    private HashMap<String, AdColonyNativeAdViewListener> d;
    private HashMap<String, ax> e;
    private HashMap<String, f> f;

    d() {
    }

    static /* synthetic */ boolean a(d d2, ad ad2) {
        return d2.j(ad2);
    }

    static /* synthetic */ ConcurrentHashMap b(d d2) {
        return d2.b;
    }

    static /* synthetic */ boolean b(d d2, ad ad2) {
        return d2.k(ad2);
    }

    static /* synthetic */ boolean c(d d2, ad ad2) {
        return d2.l(ad2);
    }

    private boolean d(final ad ad2) {
        final JSONObject jSONObject = ad2.c();
        final String string = w.b(jSONObject, "id");
        final ay ay2 = (ay)this.c.remove((Object)string);
        final AdColonyNativeAdViewListener adColonyNativeAdViewListener = (AdColonyNativeAdViewListener)this.d.remove((Object)string);
        if (ay2 == null && adColonyNativeAdViewListener == null) {
            this.a(ad2.d(), string);
            return false;
        }
        final Context context = a.c();
        if (context == null) {
            return false;
        }
        Runnable runnable = new Runnable(){

            public void run() {
                ax ax2;
                ay ay22 = ay2;
                if (ay22 != null) {
                    ax2 = new ax(context, ad2, ay22);
                    d.this.e.put((Object)string, (Object)ax2);
                } else {
                    ax2 = new AdColonyNativeAdView(context, ad2, adColonyNativeAdViewListener);
                    d.this.e.put((Object)string, (Object)ax2);
                }
                ax2.setAdvertiserName(w.b(jSONObject, "name"));
                ax2.setTitle(w.b(jSONObject, "title"));
                ax2.setDescription(w.b(jSONObject, "description"));
                ax2.setImageFilepath(w.b(jSONObject, "thumb_filepath"));
                ax2.b();
                ay ay3 = ay2;
                if (ay3 != null) {
                    ay3.a(ax2);
                    return;
                }
                adColonyNativeAdViewListener.onRequestFilled((AdColonyNativeAdView)ax2);
            }
        };
        au.a(runnable);
        return true;
    }

    static /* synthetic */ boolean d(d d2, ad ad2) {
        return d2.m(ad2);
    }

    private boolean e(ad ad2) {
        String string = w.b(ad2.c(), "id");
        final ay ay2 = (ay)this.c.remove((Object)string);
        final AdColonyNativeAdViewListener adColonyNativeAdViewListener = (AdColonyNativeAdViewListener)this.d.remove((Object)string);
        if (ay2 == null && adColonyNativeAdViewListener == null) {
            this.a(ad2.d(), string);
            return false;
        }
        au.a(new Runnable(){

            public void run() {
                boolean bl = ay2 == null;
                String string = bl ? adColonyNativeAdViewListener.a : ay2.a;
                AdColonyZone adColonyZone = (AdColonyZone)a.a().f().get((Object)string);
                if (adColonyZone == null) {
                    adColonyZone = new AdColonyZone(string);
                    adColonyZone.b(6);
                }
                if (bl) {
                    adColonyNativeAdViewListener.onRequestNotFilled(adColonyZone);
                    return;
                }
                ay2.a(adColonyZone);
            }
        });
        return true;
    }

    static /* synthetic */ boolean e(d d2, ad ad2) {
        return d2.i(ad2);
    }

    private boolean f(ad ad2) {
        String string = w.b(ad2.c(), "id");
        JSONObject jSONObject = w.a();
        w.a(jSONObject, "id", string);
        Context context = a.c();
        if (context == null) {
            w.a(jSONObject, "has_audio", false);
            ad2.a(jSONObject).b();
            return false;
        }
        boolean bl = au.a(au.a(context));
        double d2 = au.b(au.a(context));
        w.a(jSONObject, "has_audio", bl);
        w.a(jSONObject, "volume", d2);
        ad2.a(jSONObject).b();
        return bl;
    }

    static /* synthetic */ boolean f(d d2, ad ad2) {
        return d2.h(ad2);
    }

    private boolean g(ad ad2) {
        String string = w.b(ad2.c(), "id");
        final AdColonyInterstitial adColonyInterstitial = (AdColonyInterstitial)this.b.get((Object)string);
        final AdColonyInterstitialListener adColonyInterstitialListener = adColonyInterstitial == null ? null : adColonyInterstitial.getListener();
        if (adColonyInterstitialListener == null) {
            this.a(ad2.d(), string);
            return false;
        }
        if (!a.d()) {
            return false;
        }
        adColonyInterstitial.a(w.f(ad2.c(), "ias"));
        adColonyInterstitial.a(w.b(ad2.c(), "ad_id"));
        adColonyInterstitial.b(w.b(ad2.c(), "creative_id"));
        if (adColonyInterstitial.g()) {
            adColonyInterstitial.h().b();
        }
        au.a(new Runnable(){

            public void run() {
                adColonyInterstitialListener.onRequestFilled(adColonyInterstitial);
            }
        });
        return true;
    }

    static /* synthetic */ boolean g(d d2, ad ad2) {
        return d2.d(ad2);
    }

    private boolean h(ad ad2) {
        Context context = a.c();
        if (context == null) {
            return false;
        }
        JSONObject jSONObject = ad2.c();
        l l2 = a.a();
        String string = w.b(jSONObject, "id");
        AdColonyInterstitial adColonyInterstitial = (AdColonyInterstitial)this.b.get((Object)string);
        ax ax2 = (ax)((Object)this.e.get((Object)string));
        int n2 = w.a(jSONObject, "orientation", -1);
        boolean bl = ax2 != null;
        if (adColonyInterstitial == null && !bl) {
            this.a(ad2.d(), string);
            return false;
        }
        JSONObject jSONObject2 = w.a();
        w.a(jSONObject2, "id", string);
        if (adColonyInterstitial != null) {
            adColonyInterstitial.a(w.c(jSONObject2, "module_id"));
            adColonyInterstitial.b(n2);
            adColonyInterstitial.a();
            return true;
        }
        if (bl) {
            ax2.b = n2;
            l2.a(ax2.getExpandedContainer());
            l2.a(ax2);
            context.startActivity(new Intent(context, AdColonyAdViewActivity.class));
        }
        return true;
    }

    static /* synthetic */ boolean h(d d2, ad ad2) {
        return d2.e(ad2);
    }

    private boolean i(ad ad2) {
        JSONObject jSONObject = ad2.c();
        int n2 = w.c(jSONObject, "status");
        if (n2 != 5 && n2 != 1 && n2 != 0) {
            if (n2 == 6) {
                return false;
            }
            String string = w.b(jSONObject, "id");
            final AdColonyInterstitial adColonyInterstitial = (AdColonyInterstitial)this.b.remove((Object)string);
            final AdColonyInterstitialListener adColonyInterstitialListener = adColonyInterstitial == null ? null : adColonyInterstitial.getListener();
            if (adColonyInterstitialListener == null) {
                this.a(ad2.d(), string);
                return false;
            }
            au.a(new Runnable(){

                public void run() {
                    a.a().c(false);
                    adColonyInterstitialListener.onClosed(adColonyInterstitial);
                }
            });
            adColonyInterstitial.a((c)null);
            return true;
        }
        return false;
    }

    static /* synthetic */ boolean i(d d2, ad ad2) {
        return d2.n(ad2);
    }

    private boolean j(ad ad2) {
        Context context = a.c();
        if (context == null) {
            return false;
        }
        JSONObject jSONObject = ad2.c();
        String string = w.b(jSONObject, "ad_session_id");
        c c2 = new c(context, string);
        c2.b(ad2);
        if (this.a.containsKey((Object)string)) {
            ax ax2 = (ax)((Object)this.e.get((Object)string));
            if (ax2 == null) {
                return false;
            }
            ax2.setExpandedContainer(c2);
            return true;
        }
        new y.a().a("Inserting container into hash map tied to ad session id: ").a(string).a(y.b);
        this.a.put((Object)string, (Object)c2);
        if (w.c(jSONObject, "width") == 0) {
            if ((AdColonyInterstitial)this.b.get((Object)string) == null) {
                this.a(ad2.d(), string);
                return false;
            }
            ((AdColonyInterstitial)this.b.get((Object)string)).a(c2);
        } else {
            c2.a(false);
        }
        JSONObject jSONObject2 = w.a();
        w.a(jSONObject2, "success", true);
        ad2.a(jSONObject2).b();
        return true;
    }

    static /* synthetic */ boolean j(d d2, ad ad2) {
        return d2.o(ad2);
    }

    private boolean k(ad ad2) {
        String string = w.b(ad2.c(), "ad_session_id");
        c c2 = (c)((Object)this.a.get((Object)string));
        if (c2 == null) {
            this.a(ad2.d(), string);
            return false;
        }
        this.a(c2);
        return true;
    }

    static /* synthetic */ boolean k(d d2, ad ad2) {
        return d2.p(ad2);
    }

    private boolean l(ad ad2) {
        JSONObject jSONObject = ad2.c();
        String string = ad2.d();
        String string2 = w.b(jSONObject, "ad_session_id");
        int n2 = w.c(jSONObject, "view_id");
        c c2 = (c)((Object)this.a.get((Object)string2));
        View view = (View)c2.l().get((Object)n2);
        if (c2 == null) {
            this.a(string, string2);
            return false;
        }
        if (view == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("");
            stringBuilder.append(n2);
            this.a(string, stringBuilder.toString());
            return false;
        }
        view.bringToFront();
        return true;
    }

    static /* synthetic */ boolean l(d d2, ad ad2) {
        return d2.q(ad2);
    }

    private boolean m(ad ad2) {
        View view;
        ax ax2;
        JSONObject jSONObject = ad2.c();
        String string = ad2.d();
        String string2 = w.b(jSONObject, "ad_session_id");
        int n2 = w.c(jSONObject, "view_id");
        c c2 = (c)((Object)this.a.get((Object)string2));
        if (c2 == null) {
            this.a(string, string2);
            return false;
        }
        if (c2.d() == 0 && w.c(jSONObject, "id") == 1 && (ax2 = (ax)((Object)this.e.get((Object)string2))) != null && ax2.getExpandedContainer() != null) {
            c2 = ax2.getExpandedContainer();
        }
        if ((view = (View)c2.l().get((Object)n2)) == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("");
            stringBuilder.append(n2);
            this.a(string, stringBuilder.toString());
            return false;
        }
        c2.removeView(view);
        c2.addView(view, view.getLayoutParams());
        return true;
    }

    static /* synthetic */ boolean m(d d2, ad ad2) {
        return d2.r(ad2);
    }

    private boolean n(ad ad2) {
        String string = w.b(ad2.c(), "ad_session_id");
        c c2 = (c)((Object)this.a.get((Object)string));
        if (c2 == null) {
            this.a(ad2.d(), string);
            return false;
        }
        f f2 = (f)this.f.get((Object)string);
        if (f2 == null) {
            f2 = new f(string, c2.c());
            this.f.put((Object)string, (Object)f2);
        }
        f2.a(ad2);
        return true;
    }

    static /* synthetic */ boolean n(d d2, ad ad2) {
        return d2.g(ad2);
    }

    private boolean o(ad ad2) {
        String string = w.b(ad2.c(), "ad_session_id");
        f f2 = (f)this.f.get((Object)string);
        if (f2 == null) {
            this.a(ad2.d(), string);
            return false;
        }
        f2.d(ad2);
        return true;
    }

    static /* synthetic */ boolean o(d d2, ad ad2) {
        return d2.f(ad2);
    }

    private boolean p(ad ad2) {
        String string = w.b(ad2.c(), "ad_session_id");
        f f2 = (f)this.f.get((Object)string);
        if (f2 == null) {
            this.a(ad2.d(), string);
            return false;
        }
        f2.c(ad2);
        return true;
    }

    private boolean q(ad ad2) {
        String string = w.b(ad2.c(), "ad_session_id");
        f f2 = (f)this.f.get((Object)string);
        if (f2 == null) {
            this.a(ad2.d(), string);
            return false;
        }
        f2.b(ad2);
        return true;
    }

    private boolean r(ad ad2) {
        String string = w.b(ad2.c(), "ad_session_id");
        f f2 = (f)this.f.get((Object)string);
        if (f2 == null) {
            this.a(ad2.d(), string);
            return false;
        }
        f2.e(ad2);
        return true;
    }

    void a() {
        this.a = new HashMap();
        this.b = new ConcurrentHashMap();
        this.c = new HashMap();
        this.d = new HashMap();
        this.e = new HashMap();
        this.f = new HashMap();
        a.a("AdContainer.create", new af(this){
            final /* synthetic */ d a;
            {
                this.a = d2;
            }

            public void a(ad ad2) {
                d.a(this.a, ad2);
            }
        });
        a.a("AdContainer.destroy", new af(this){
            final /* synthetic */ d a;
            {
                this.a = d2;
            }

            public void a(ad ad2) {
                d.b(this.a, ad2);
            }
        });
        a.a("AdContainer.move_view_to_index", new af(this){
            final /* synthetic */ d a;
            {
                this.a = d2;
            }

            public void a(ad ad2) {
                d.c(this.a, ad2);
            }
        });
        a.a("AdContainer.move_view_to_front", new af(this){
            final /* synthetic */ d a;
            {
                this.a = d2;
            }

            public void a(ad ad2) {
                d.d(this.a, ad2);
            }
        });
        a.a("AdSession.finish_fullscreen_ad", new af(this){
            final /* synthetic */ d a;
            {
                this.a = d2;
            }

            public void a(ad ad2) {
                d.e(this.a, ad2);
            }
        });
        a.a("AdSession.start_fullscreen_ad", new af(this){
            final /* synthetic */ d a;
            {
                this.a = d2;
            }

            public void a(ad ad2) {
                d.f(this.a, ad2);
            }
        });
        a.a("AdSession.native_ad_view_available", new af(this){
            final /* synthetic */ d a;
            {
                this.a = d2;
            }

            public void a(ad ad2) {
                d.g(this.a, ad2);
            }
        });
        a.a("AdSession.native_ad_view_unavailable", new af(this){
            final /* synthetic */ d a;
            {
                this.a = d2;
            }

            public void a(ad ad2) {
                d.h(this.a, ad2);
            }
        });
        a.a("AdSession.expiring", new af(this){
            final /* synthetic */ d a;
            {
                this.a = d2;
            }

            public void a(ad ad2) {
                this.a.a(ad2);
            }
        });
        a.a("AdSession.audio_stopped", new af(this){
            final /* synthetic */ d a;
            {
                this.a = d2;
            }

            public void a(ad ad2) {
                au.a(new Runnable(this, ad2){
                    final /* synthetic */ ad a;
                    final /* synthetic */ 4 b;
                    {
                        this.b = var1_1;
                        this.a = ad2;
                    }

                    public void run() {
                        AdColonyInterstitial adColonyInterstitial = (AdColonyInterstitial)d.b(this.b.a).get((Object)w.b(this.a.c(), "id"));
                        if (adColonyInterstitial != null && adColonyInterstitial.getListener() != null) {
                            adColonyInterstitial.getListener().onAudioStopped(adColonyInterstitial);
                        }
                    }
                });
            }
        });
        a.a("AdSession.audio_started", new af(this){
            final /* synthetic */ d a;
            {
                this.a = d2;
            }

            public void a(ad ad2) {
                au.a(new Runnable(this, ad2){
                    final /* synthetic */ ad a;
                    final /* synthetic */ 5 b;
                    {
                        this.b = var1_1;
                        this.a = ad2;
                    }

                    public void run() {
                        AdColonyInterstitial adColonyInterstitial = (AdColonyInterstitial)d.b(this.b.a).get((Object)w.b(this.a.c(), "id"));
                        if (adColonyInterstitial != null && adColonyInterstitial.getListener() != null) {
                            adColonyInterstitial.getListener().onAudioStarted(adColonyInterstitial);
                        }
                    }
                });
            }
        });
        a.a("AudioPlayer.create", new af(this){
            final /* synthetic */ d a;
            {
                this.a = d2;
            }

            public void a(ad ad2) {
                d.i(this.a, ad2);
            }
        });
        a.a("AudioPlayer.destroy", new af(this){
            final /* synthetic */ d a;
            {
                this.a = d2;
            }

            public void a(ad ad2) {
                if (this.a.c(ad2)) {
                    d.j(this.a, ad2);
                }
            }
        });
        a.a("AudioPlayer.play", new af(this){
            final /* synthetic */ d a;
            {
                this.a = d2;
            }

            public void a(ad ad2) {
                if (this.a.c(ad2)) {
                    d.k(this.a, ad2);
                }
            }
        });
        a.a("AudioPlayer.pause", new af(this){
            final /* synthetic */ d a;
            {
                this.a = d2;
            }

            public void a(ad ad2) {
                if (this.a.c(ad2)) {
                    d.l(this.a, ad2);
                }
            }
        });
        a.a("AudioPlayer.stop", new af(this){
            final /* synthetic */ d a;
            {
                this.a = d2;
            }

            public void a(ad ad2) {
                if (this.a.c(ad2)) {
                    d.m(this.a, ad2);
                }
            }
        });
        a.a("AdSession.interstitial_available", new af(this){
            final /* synthetic */ d a;
            {
                this.a = d2;
            }

            public void a(ad ad2) {
                d.n(this.a, ad2);
            }
        });
        a.a("AdSession.interstitial_unavailable", new af(this){
            final /* synthetic */ d a;
            {
                this.a = d2;
            }

            public void a(ad ad2) {
                this.a.b(ad2);
            }
        });
        a.a("AdSession.has_audio", new af(this){
            final /* synthetic */ d a;
            {
                this.a = d2;
            }

            public void a(ad ad2) {
                d.o(this.a, ad2);
            }
        });
        a.a("WebView.prepare", new af(this){
            final /* synthetic */ d a;
            {
                this.a = d2;
            }

            public void a(ad ad2) {
                JSONObject jSONObject = w.a();
                w.a(jSONObject, "success", true);
                ad2.a(jSONObject).b();
            }
        });
        a.a("AdSession.iap_event", new af(this){
            final /* synthetic */ d a;
            {
                this.a = d2;
            }

            public void a(ad ad2) {
                JSONObject jSONObject = ad2.c();
                if (w.c(jSONObject, "type") != 2) {
                    return;
                }
                ax ax2 = (ax)((Object)d.a(this.a).get((Object)w.b(jSONObject, "id")));
                JSONObject jSONObject2 = w.f(jSONObject, "v4iap");
                org.json.JSONArray jSONArray = w.g(jSONObject2, "product_ids");
                if (ax2 != null && jSONObject2 != null && jSONArray.length() > 0) {
                    ((AdColonyNativeAdViewListener)ax2.getListener()).onIAPEvent((AdColonyNativeAdView)ax2, w.c(jSONArray, 0), w.c(jSONObject2, "engagement_type"));
                }
            }
        });
        a.a("AdSession.native_ad_view_finished", new af(this){
            final /* synthetic */ d a;
            {
                this.a = d2;
            }

            public void a(ad ad2) {
                au.a(new Runnable(this, ad2){
                    final /* synthetic */ ad a;
                    final /* synthetic */ 17 b;
                    {
                        this.b = var1_1;
                        this.a = ad2;
                    }

                    public void run() {
                        ax ax2 = (ax)((Object)d.a(this.b.a).get((Object)w.b(this.a.c(), "id")));
                        if (ax2 != null && ax2.getListener() != null && ax2 instanceof AdColonyNativeAdView) {
                            ((AdColonyNativeAdViewListener)ax2.getListener()).onNativeVideoFinished((AdColonyNativeAdView)ax2);
                        }
                    }
                });
            }
        });
        a.a("AdSession.native_ad_view_started", new af(this){
            final /* synthetic */ d a;
            {
                this.a = d2;
            }

            public void a(ad ad2) {
                au.a(new Runnable(this, ad2){
                    final /* synthetic */ ad a;
                    final /* synthetic */ 18 b;
                    {
                        this.b = var1_1;
                        this.a = ad2;
                    }

                    public void run() {
                        ax ax2 = (ax)((Object)d.a(this.b.a).get((Object)w.b(this.a.c(), "id")));
                        if (ax2 != null && ax2.getListener() != null && ax2 instanceof AdColonyNativeAdView) {
                            ((AdColonyNativeAdViewListener)ax2.getListener()).onNativeVideoStarted((AdColonyNativeAdView)ax2);
                        }
                    }
                });
            }
        });
        a.a("AdSession.destroy_native_ad_view", new af(this){
            final /* synthetic */ d a;
            {
                this.a = d2;
            }

            public void a(ad ad2) {
                au.a(new Runnable(this, ad2){
                    final /* synthetic */ ad a;
                    final /* synthetic */ 19 b;
                    {
                        this.b = var1_1;
                        this.a = ad2;
                    }

                    public void run() {
                        JSONObject jSONObject = this.a.c();
                        ax ax2 = (ax)((Object)d.a(this.b.a).get((Object)w.b(jSONObject, "id")));
                        if (ax2 != null) {
                            ax2.a();
                            this.a.a(jSONObject).b();
                        }
                    }
                });
            }
        });
        a.a("AdSession.expanded", new af(this){
            final /* synthetic */ d a;
            {
                this.a = d2;
            }

            public void a(ad ad2) {
                au.a(new Runnable(this, ad2){
                    final /* synthetic */ ad a;
                    final /* synthetic */ 20 b;
                    {
                        this.b = var1_1;
                        this.a = ad2;
                    }

                    public void run() {
                        ad ad2 = this.a;
                        ad2.a(ad2.c()).b();
                    }
                });
            }
        });
        a.a("AdSession.native_ad_muted", new af(this){
            final /* synthetic */ d a;
            {
                this.a = d2;
            }

            public void a(ad ad2) {
                au.a(new Runnable(this, ad2){
                    final /* synthetic */ ad a;
                    final /* synthetic */ 21 b;
                    {
                        this.b = var1_1;
                        this.a = ad2;
                    }

                    public void run() {
                        JSONObject jSONObject = this.a.c();
                        ax ax2 = (ax)((Object)d.a(this.b.a).get((Object)w.b(jSONObject, "id")));
                        boolean bl = w.d(jSONObject, "muted");
                        e e2 = ax2 != null ? ax2.getListener() : null;
                        if (ax2 instanceof AdColonyNativeAdView && e2 != null) {
                            if (bl) {
                                ((AdColonyNativeAdViewListener)e2).onAudioStopped((AdColonyNativeAdView)ax2);
                                return;
                            }
                            ((AdColonyNativeAdViewListener)e2).onAudioStarted((AdColonyNativeAdView)ax2);
                        }
                    }
                });
            }
        });
    }

    void a(final c c2) {
        au.a(new Runnable(){

            public void run() {
                for (int i2 = 0; i2 < c2.m().size(); ++i2) {
                    a.b((String)c2.n().get(i2), (af)c2.m().get(i2));
                }
                c2.n().clear();
                c2.m().clear();
                c2.removeAllViews();
                c c22 = c2;
                c22.d = null;
                c22.c = null;
                new y.a().a("Destroying container tied to ad_session_id = ").a(c2.b()).a(y.d);
                for (aw aw2 : c2.g().values()) {
                    if (aw2.h()) continue;
                    a.a().a(aw2.a());
                    aw2.loadUrl("about:blank");
                    aw2.clearCache(true);
                    aw2.removeAllViews();
                    aw2.a(true);
                }
                new y.a().a("Stopping and releasing all media players associated with ").a("VideoViews tied to ad_session_id = ").a(c2.b()).a(y.d);
                for (av av2 : c2.e().values()) {
                    av2.d();
                    av2.g();
                }
                c2.e().clear();
                c2.f().clear();
                c2.g().clear();
                c2.j().clear();
                c2.l().clear();
                c2.i().clear();
                c2.k().clear();
                c2.a = true;
            }
        });
        ax ax2 = (ax)((Object)this.e.get((Object)c2.b()));
        if (ax2 == null || ax2.c()) {
            new y.a().a("Removing ad 4").a(y.b);
            this.a.remove((Object)c2.b());
            c2.c = null;
        }
    }

    void a(String string, AdColonyInterstitialListener adColonyInterstitialListener, AdColonyAdOptions adColonyAdOptions) {
        String string2 = au.e();
        l l2 = a.a();
        JSONObject jSONObject = w.a();
        w.a(jSONObject, "zone_id", string);
        w.a(jSONObject, "fullscreen", true);
        w.b(jSONObject, "width", l2.c.p());
        w.b(jSONObject, "height", l2.c.q());
        w.b(jSONObject, "type", 0);
        w.a(jSONObject, "id", string2);
        new y.a().a("AdSession request with id = ").a(string2).a(y.b);
        AdColonyInterstitial adColonyInterstitial = new AdColonyInterstitial(string2, adColonyInterstitialListener, string);
        this.b.put((Object)string2, (Object)adColonyInterstitial);
        if (adColonyAdOptions != null && adColonyAdOptions.d != null) {
            adColonyInterstitial.a(adColonyAdOptions);
            w.a(jSONObject, "options", adColonyAdOptions.d);
        }
        new y.a().a("Requesting AdColony interstitial advertisement.").a(y.a);
        new ad("AdSession.on_request", 1, jSONObject).b();
    }

    void a(String string, String string2) {
        new y.a().a("Message '").a(string).a("' sent with invalid id: ").a(string2).a(y.g);
    }

    boolean a(ad ad2) {
        JSONObject jSONObject = ad2.c();
        String string = w.b(jSONObject, "id");
        if (w.c(jSONObject, "type") == 0) {
            final AdColonyInterstitial adColonyInterstitial = (AdColonyInterstitial)this.b.remove((Object)string);
            final AdColonyInterstitialListener adColonyInterstitialListener = adColonyInterstitial == null ? null : adColonyInterstitial.getListener();
            if (adColonyInterstitialListener == null) {
                this.a(ad2.d(), string);
                return false;
            }
            if (!a.d()) {
                return false;
            }
            au.a(new Runnable(){

                public void run() {
                    adColonyInterstitial.a(true);
                    adColonyInterstitialListener.onExpiring(adColonyInterstitial);
                    o o2 = a.a().q();
                    if (o2.b() != null) {
                        o2.b().dismiss();
                        o2.a((AlertDialog)null);
                    }
                }
            });
        }
        return true;
    }

    HashMap<String, c> b() {
        return this.a;
    }

    boolean b(ad ad2) {
        String string = w.b(ad2.c(), "id");
        final AdColonyInterstitial adColonyInterstitial = (AdColonyInterstitial)this.b.remove((Object)string);
        final AdColonyInterstitialListener adColonyInterstitialListener = adColonyInterstitial == null ? null : adColonyInterstitial.getListener();
        if (adColonyInterstitialListener == null) {
            this.a(ad2.d(), string);
            return false;
        }
        if (!a.d()) {
            return false;
        }
        au.a(new Runnable(){

            public void run() {
                AdColonyZone adColonyZone = (AdColonyZone)a.a().f().get((Object)adColonyInterstitial.getZoneID());
                if (adColonyZone == null) {
                    adColonyZone = new AdColonyZone(adColonyInterstitial.getZoneID());
                    adColonyZone.b(6);
                }
                adColonyInterstitialListener.onRequestNotFilled(adColonyZone);
            }
        });
        return true;
    }

    ConcurrentHashMap<String, AdColonyInterstitial> c() {
        return this.b;
    }

    boolean c(ad ad2) {
        String string = w.b(ad2.c(), "ad_session_id");
        c c2 = (c)((Object)this.a.get((Object)string));
        f f2 = (f)this.f.get((Object)string);
        if (c2 != null && f2 != null) {
            return true;
        }
        new y.a().a("Invalid AudioPlayer message!").a(y.g);
        return false;
    }

    HashMap<String, ax> f() {
        return this.e;
    }

    HashMap<String, f> g() {
        return this.f;
    }

}

