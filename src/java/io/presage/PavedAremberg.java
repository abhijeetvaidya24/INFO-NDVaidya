/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.app.Activity
 *  android.app.Application
 *  android.content.Context
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.webkit.WebView
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 *  io.presage.FourmedAmbert
 *  io.presage.at
 *  io.presage.interstitial.ui.InterstitialActivity
 *  io.presage.interstitial.ui.InterstitialActivity$CamembertauCalvados
 *  io.presage.j
 *  java.lang.CharSequence
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.List
 */
package io.presage;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout;
import io.presage.Bouyssou;
import io.presage.BrillatSavarin;
import io.presage.FourmedAmbert;
import io.presage.FourmedAmbertBio;
import io.presage.OlivetCendre;
import io.presage.ParmigianoReggiano;
import io.presage.PasdelEscalette;
import io.presage.PersilledumontBlanc;
import io.presage.RacletteSuisse;
import io.presage.RegaldeBourgogne;
import io.presage.SableduBoulonnais;
import io.presage.SaintFelicien;
import io.presage.StVincentauChablis;
import io.presage.at;
import io.presage.cl;
import io.presage.interstitial.ui.InterstitialActivity;
import io.presage.j;
import java.util.ArrayList;
import java.util.List;

public final class PavedAremberg {
    public static final CamembertauCalvados a = new CamembertauCalvados(0);
    private j b;
    private OlivetCendre c;
    private boolean d;
    private boolean e;
    private StVincentauChablis f;
    private BrillatSavarin g;
    private List<BrillatSavarin> h;
    private ParmigianoReggiano i;
    private final InterstitialActivity j;
    private final StVincentauChablis.CamembertauCalvados k;
    private final OlivetCendre.CamembertauCalvados l;
    private final FourmedAmbertBio m;
    private final PersilledumontBlanc n;
    private final Bouyssou o;
    private final PasdelEscalette p;
    private final InterstitialActivity.CamembertauCalvados q;
    private final SaintFelicien r;

    public PavedAremberg(InterstitialActivity interstitialActivity) {
        this(interstitialActivity, StVincentauChablis.a, OlivetCendre.a, FourmedAmbertBio.a, new PersilledumontBlanc(), Bouyssou.a, PasdelEscalette.a, InterstitialActivity.a, SaintFelicien.a);
    }

    private PavedAremberg(InterstitialActivity interstitialActivity, StVincentauChablis.CamembertauCalvados camembertauCalvados, OlivetCendre.CamembertauCalvados camembertauCalvados2, FourmedAmbertBio fourmedAmbertBio, PersilledumontBlanc persilledumontBlanc, Bouyssou bouyssou, PasdelEscalette pasdelEscalette, InterstitialActivity.CamembertauCalvados camembertauCalvados3, SaintFelicien saintFelicien) {
        this.j = interstitialActivity;
        this.k = camembertauCalvados;
        this.l = camembertauCalvados2;
        this.m = fourmedAmbertBio;
        this.n = persilledumontBlanc;
        this.o = bouyssou;
        this.p = pasdelEscalette;
        this.q = camembertauCalvados3;
        this.r = saintFelicien;
        this.e = true;
        this.h = (List)new ArrayList();
    }

    private final void a(FourmedAmbert fourmedAmbert, BrillatSavarin brillatSavarin) {
        this.d = fourmedAmbert.h();
        this.e = fourmedAmbert.i();
        this.b(fourmedAmbert, brillatSavarin);
        ParmigianoReggiano parmigianoReggiano = this.i;
        if (parmigianoReggiano != null) {
            parmigianoReggiano.a(fourmedAmbert.l());
        }
    }

    @SuppressLint(value={"RtlHardcoded"})
    private final void a(RacletteSuisse racletteSuisse) {
        String string2;
        BrillatSavarin brillatSavarin = this.g;
        if (brillatSavarin == null || (string2 = brillatSavarin.n()) == null) {
            string2 = "";
        }
        this.i = PasdelEscalette.a(this, racletteSuisse, Bouyssou.a((Context)this.j), string2);
    }

    private final void a(j j2) {
        if (!j2.getShowSdkCloseButton()) {
            this.b();
        }
    }

    private final void b(FourmedAmbert fourmedAmbert, BrillatSavarin brillatSavarin) {
        if (fourmedAmbert.c() && brillatSavarin.m()) {
            PersilledumontBlanc persilledumontBlanc = this.n;
            Application application = this.j.getApplication();
            cl.a((Object)application, "activity.application");
            persilledumontBlanc.a(application);
            PersilledumontBlanc persilledumontBlanc2 = this.n;
            j j2 = this.b;
            if (j2 == null) {
                cl.a("webView");
            }
            persilledumontBlanc2.a((WebView)j2);
        }
    }

    private final BrillatSavarin h() {
        return (BrillatSavarin)at.c(this.h);
    }

    private final boolean i() {
        StVincentauChablis stVincentauChablis = this.f;
        if (stVincentauChablis != null) {
            return stVincentauChablis.b();
        }
        return true;
    }

    public final void a() {
        ParmigianoReggiano parmigianoReggiano = this.i;
        if (parmigianoReggiano != null) {
            parmigianoReggiano.a();
        }
    }

    public final void a(RacletteSuisse racletteSuisse, List<BrillatSavarin> list) {
        this.h = list;
        this.g = this.h();
        BrillatSavarin brillatSavarin = this.g;
        if (brillatSavarin != null) {
            j j2;
            StVincentauChablis stVincentauChablis;
            this.j.a(brillatSavarin);
            this.a(racletteSuisse);
            InterstitialActivity interstitialActivity = this.j;
            Activity activity = (Activity)interstitialActivity;
            Context context = interstitialActivity.getApplicationContext();
            cl.a((Object)context, "activity.applicationContext");
            this.f = stVincentauChablis = StVincentauChablis.CamembertauCalvados.a(activity, brillatSavarin, new RegaldeBourgogne(context), racletteSuisse);
            OlivetCendre olivetCendre = this.c = OlivetCendre.CamembertauCalvados.a((Activity)this.j, stVincentauChablis);
            if (olivetCendre == null) {
                cl.a("webViewGateway");
            }
            if ((j2 = olivetCendre.a(brillatSavarin)) != null) {
                this.b = j2;
                boolean bl2 = ((CharSequence)brillatSavarin.i()).length() > 0;
                String string2 = bl2 ? brillatSavarin.i() : "controller";
                stVincentauChablis.a(string2, j2);
                FourmedAmbert fourmedAmbert = FourmedAmbertBio.a((Context)this.j);
                if (fourmedAmbert != null) {
                    this.a(fourmedAmbert, brillatSavarin);
                    this.a(j2);
                    racletteSuisse.addView((View)j2, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
                    this.n.a();
                    return;
                }
                throw (Throwable)new IllegalStateException("Profig must not be null");
            }
            throw (Throwable)new IllegalStateException("WebView must not be null");
        }
        throw (Throwable)new IllegalStateException("Ad must not be null");
    }

    public final void b() {
        ParmigianoReggiano parmigianoReggiano = this.i;
        if (parmigianoReggiano != null) {
            parmigianoReggiano.b();
        }
    }

    public final void c() {
        if (this.h.size() > 1) {
            this.h.remove(0);
            InterstitialActivity.CamembertauCalvados.a((Context)((Context)this.j), this.h);
        }
    }

    public final void d() {
        OlivetCendre olivetCendre = this.c;
        if (olivetCendre == null) {
            cl.a("webViewGateway");
        }
        olivetCendre.a();
        this.c();
        this.j.finish();
    }

    public final void e() {
        if (this.i() && this.e) {
            this.j.finish();
        }
    }

    public final void f() {
        BrillatSavarin brillatSavarin;
        ParmigianoReggiano parmigianoReggiano;
        String string2;
        StVincentauChablis stVincentauChablis = this.f;
        if (stVincentauChablis != null) {
            stVincentauChablis.d();
        }
        if ((parmigianoReggiano = this.i) != null) {
            parmigianoReggiano.c();
        }
        if ((brillatSavarin = this.g) == null || (string2 = brillatSavarin.a()) == null) {
            string2 = "";
        }
        SaintFelicien.a(new SableduBoulonnais(string2, "adClosed"));
        SaintFelicien.a(string2);
        this.n.b();
    }

    public final boolean g() {
        StVincentauChablis stVincentauChablis = this.f;
        if (stVincentauChablis != null) {
            stVincentauChablis.c();
        }
        return this.d;
    }

    public static final class CamembertauCalvados {
        private CamembertauCalvados() {
        }

        public /* synthetic */ CamembertauCalvados(byte by) {
            this();
        }
    }

}

