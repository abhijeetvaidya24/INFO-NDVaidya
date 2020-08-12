/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.app.Activity
 *  android.content.Context
 *  android.webkit.WebSettings
 *  android.webkit.WebView
 *  io.presage.BleudAuvergnebio
 *  io.presage.OlivetCendre$CamembertdeNormandie
 *  io.presage.RaclettedeSavoie
 *  io.presage.RaclettedeSavoiefumee
 *  io.presage.j
 *  io.presage.k
 *  io.presage.l
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 */
package io.presage;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.webkit.WebSettings;
import android.webkit.WebView;
import io.presage.Abondance;
import io.presage.Beaufort;
import io.presage.BleudAuvergnebio;
import io.presage.BoulettedAvesnes;
import io.presage.Bouyssou;
import io.presage.BrillatSavarin;
import io.presage.Murol;
import io.presage.OlivetCendre;
import io.presage.RaclettedeSavoie;
import io.presage.RaclettedeSavoiefumee;
import io.presage.RegaldeBourgogne;
import io.presage.SableduBoulonnais;
import io.presage.SaintFelicien;
import io.presage.Salers;
import io.presage.StVincentauChablis;
import io.presage.VieuxLille;
import io.presage.cl;
import io.presage.j;
import io.presage.k;
import io.presage.l;

public final class OlivetCendre {
    public static final CamembertauCalvados a = new CamembertauCalvados(0);
    private final Context b;
    private j c;
    private BoulettedAvesnes d;
    private boolean e;
    private boolean f;
    private Abondance g;
    private SaintFelicien h;
    private final VieuxLille i;
    private final Salers[] j;
    private final RegaldeBourgogne k;

    private OlivetCendre(Context context, VieuxLille vieuxLille, Salers[] arrsalers, RegaldeBourgogne regaldeBourgogne) {
        this.i = vieuxLille;
        this.j = arrsalers;
        this.k = regaldeBourgogne;
        this.b = context.getApplicationContext();
        this.d = Bouyssou.a(context);
        this.g = Abondance.a;
        this.h = SaintFelicien.a;
    }

    public /* synthetic */ OlivetCendre(Context context, VieuxLille vieuxLille, Salers[] arrsalers, RegaldeBourgogne regaldeBourgogne, byte by) {
        this(context, vieuxLille, arrsalers, regaldeBourgogne);
    }

    public static final /* synthetic */ void a(OlivetCendre olivetCendre, BrillatSavarin brillatSavarin) {
        olivetCendre.c(brillatSavarin);
    }

    private final void a(j j2, BrillatSavarin brillatSavarin) {
        if (j2 != null) {
            j2.setClientAdapter((k)new CamembertdeNormandie(this, brillatSavarin));
        }
    }

    public static final /* synthetic */ boolean a(OlivetCendre olivetCendre) {
        return olivetCendre.e;
    }

    @SuppressLint(value={"SetJavaScriptEnabled"})
    private final void b() {
        WebSettings webSettings;
        j j2;
        j j3;
        j j4 = this.c;
        if (j4 != null) {
            j4.setMraidUrlHandler((Salers)new RaclettedeSavoie(this.j));
        }
        this.k.a(this.c);
        j j5 = this.c;
        if (j5 != null && (webSettings = j5.getSettings()) != null) {
            webSettings.setJavaScriptEnabled(true);
        }
        if ((j3 = this.c) != null) {
            Murol.c((WebView)j3);
        }
        if ((j2 = this.c) != null) {
            Murol.b((WebView)j2);
        }
    }

    private final void b(BrillatSavarin brillatSavarin) {
        j j2 = VieuxLille.b(brillatSavarin.a());
        boolean bl2 = j2 != null;
        this.f = bl2;
        if (j2 == null) {
            Context context = this.b;
            cl.a((Object)context, "context");
            j2 = l.a((Context)context, (BrillatSavarin)brillatSavarin);
        }
        if (j2 != null) {
            this.c = j2;
        }
    }

    public static final /* synthetic */ void b(OlivetCendre olivetCendre) {
        olivetCendre.e = true;
    }

    private final void c() {
        this.k.a();
    }

    private final void c(BrillatSavarin brillatSavarin) {
        boolean bl2 = ((CharSequence)brillatSavarin.d()).length() > 0;
        if (bl2) {
            this.d(brillatSavarin);
        } else {
            Abondance.a((Beaufort)new BleudAuvergnebio("shown", brillatSavarin));
        }
        SaintFelicien.a(new SableduBoulonnais(brillatSavarin.a(), "impression"));
    }

    public static final /* synthetic */ void c(OlivetCendre olivetCendre) {
        olivetCendre.c();
    }

    private final void d(BrillatSavarin brillatSavarin) {
        this.d.b(brillatSavarin.d());
    }

    public final j a(BrillatSavarin brillatSavarin) {
        this.b(brillatSavarin);
        this.b();
        this.a(this.c, brillatSavarin);
        if (!this.f) {
            j j2 = this.c;
            if (j2 != null) {
                l.a((j)j2, (BrillatSavarin)brillatSavarin);
            }
        } else {
            this.e = true;
            this.c();
            this.c(brillatSavarin);
        }
        return this.c;
    }

    public final void a() {
        this.k.c();
    }

    public static final class CamembertauCalvados {
        private CamembertauCalvados() {
        }

        public /* synthetic */ CamembertauCalvados(byte by) {
            this();
        }

        public static OlivetCendre a(Activity activity, StVincentauChablis stVincentauChablis) {
            Context context = activity.getApplicationContext();
            cl.a((Object)context, "activity.applicationContext");
            RegaldeBourgogne regaldeBourgogne = new RegaldeBourgogne(context);
            Salers[] arrsalers = new Salers[]{stVincentauChablis.a(), (Salers)new RaclettedeSavoiefumee(activity, regaldeBourgogne)};
            OlivetCendre olivetCendre = new OlivetCendre((Context)activity, VieuxLille.a, arrsalers, regaldeBourgogne, 0);
            return olivetCendre;
        }
    }

}

