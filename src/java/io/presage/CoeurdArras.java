/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.content.Context
 *  io.presage.Entrammes
 *  io.presage.EtivazGruyereSuisse
 *  io.presage.FourmedAmbert
 *  io.presage.Goudaaucumin
 *  io.presage.Livarot
 *  io.presage.p
 *  io.presage.y
 *  io.presage.z
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Throwable
 *  java.util.concurrent.TimeUnit
 *  org.json.JSONObject
 */
package io.presage;

import android.annotation.SuppressLint;
import android.content.Context;
import io.presage.BoulettedAvesnes;
import io.presage.Bouyssou;
import io.presage.Chambertin;
import io.presage.Chaource;
import io.presage.CoeurdeNeufchatel;
import io.presage.Comte18mois;
import io.presage.Coulommiers;
import io.presage.CremeuxduJura;
import io.presage.EmmentalGrandCru;
import io.presage.Entrammes;
import io.presage.EpoissesdeBourgogne;
import io.presage.EtivazGruyereSuisse;
import io.presage.FourmedAmbert;
import io.presage.FourmedAmbertBio;
import io.presage.FourmedeHauteLoire;
import io.presage.FourmedeRochefort;
import io.presage.GorgonzolaPiccante;
import io.presage.Goudaaucumin;
import io.presage.Langres;
import io.presage.Livarot;
import io.presage.Montbriac;
import io.presage.Munster;
import io.presage.cl;
import io.presage.p;
import io.presage.y;
import io.presage.z;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

public final class CoeurdArras {
    public static final CamembertauCalvados a = new CamembertauCalvados(0);
    @SuppressLint(value={"StaticFieldLeak"})
    private static CoeurdArras l;
    private boolean b;
    private long c;
    private EmmentalGrandCru d;
    private final Context e;
    private final EpoissesdeBourgogne f;
    private final CoeurdeNeufchatel g;
    private final CremeuxduJura h;
    private final BoulettedAvesnes i;
    private final GorgonzolaPiccante j;
    private final Langres k;

    private CoeurdArras(Context context, EpoissesdeBourgogne epoissesdeBourgogne, CoeurdeNeufchatel coeurdeNeufchatel, CremeuxduJura cremeuxduJura, BoulettedAvesnes boulettedAvesnes, GorgonzolaPiccante gorgonzolaPiccante, Langres langres) {
        this.e = context;
        this.f = epoissesdeBourgogne;
        this.g = coeurdeNeufchatel;
        this.h = cremeuxduJura;
        this.i = boulettedAvesnes;
        this.j = gorgonzolaPiccante;
        this.k = langres;
        this.c = TimeUnit.SECONDS.toMillis(7200L);
        this.d = CremeuxduJura.a(this.e);
    }

    public /* synthetic */ CoeurdArras(Context context, EpoissesdeBourgogne epoissesdeBourgogne, CoeurdeNeufchatel coeurdeNeufchatel, CremeuxduJura cremeuxduJura, BoulettedAvesnes boulettedAvesnes, GorgonzolaPiccante gorgonzolaPiccante, Langres langres, byte by) {
        this(context, epoissesdeBourgogne, coeurdeNeufchatel, cremeuxduJura, boulettedAvesnes, gorgonzolaPiccante, langres);
    }

    private final Coulommiers a(boolean bl2) {
        this.d = CremeuxduJura.a(this.e);
        return new Coulommiers(this.g, this.d, this.f, bl2);
    }

    public static /* synthetic */ void a(CoeurdArras coeurdArras) {
        coeurdArras.b(false);
    }

    private final void a(Comte18mois comte18mois) {
        new StringBuilder("making profig api call ").append((Object)comte18mois);
        try {
            y y2 = this.i.a(comte18mois.c());
            if (y2 instanceof z) {
                this.a(comte18mois, new JSONObject(((z)y2).a()));
                return;
            }
            if (y2 instanceof p) {
                this.a(((p)y2).a());
            }
            return;
        }
        catch (Exception exception) {
            this.a(exception);
            return;
        }
    }

    private final void a(Comte18mois comte18mois, FourmedeRochefort fourmedeRochefort, JSONObject jSONObject) {
        if (fourmedeRochefort instanceof FourmedAmbert) {
            FourmedAmbert fourmedAmbert = (FourmedAmbert)fourmedeRochefort;
            FourmedAmbertBio.a(fourmedAmbert);
            EpoissesdeBourgogne epoissesdeBourgogne = this.f;
            String string2 = jSONObject.toString();
            cl.a((Object)string2, "profigJsonResponse.toString()");
            epoissesdeBourgogne.c(string2);
            this.a(fourmedAmbert.a(), fourmedAmbert.f());
            return;
        }
        if (fourmedeRochefort instanceof Entrammes) {
            this.b(true);
            return;
        }
        if (fourmedeRochefort instanceof EtivazGruyereSuisse) {
            this.a(comte18mois.d(), comte18mois.b());
        }
    }

    private final void a(Comte18mois comte18mois, JSONObject jSONObject) {
        this.d();
        this.e();
        this.a(comte18mois.e());
        this.f.b(this.d.a());
        this.f.a(System.currentTimeMillis());
        this.a(comte18mois, FourmedeHauteLoire.a(jSONObject), jSONObject);
    }

    private final void a(String string2) {
        if (string2 != null) {
            this.f.a(string2);
        }
    }

    private final void a(Throwable throwable) {
        if (Montbriac.a(throwable)) {
            this.d();
            this.e();
        }
    }

    private final void a(boolean bl2, long l2) {
        if (bl2) {
            this.j.a(this.e, l2);
            return;
        }
        this.j.a(this.e);
    }

    private final void b() {
        if (this.c()) {
            this.f.a(0);
            this.f.e();
        }
    }

    public static final /* synthetic */ void b(CoeurdArras coeurdArras) {
        l = coeurdArras;
    }

    private void b(boolean bl2) {
        if (this.b && !bl2) {
            return;
        }
        this.b = true;
        this.b();
        Coulommiers coulommiers = this.a(bl2);
        Comte18mois comte18mois = coulommiers.b();
        StringBuilder stringBuilder = new StringBuilder("Profig - profigRequest ");
        stringBuilder.append(bl2);
        stringBuilder.append(' ');
        stringBuilder.append((Object)comte18mois);
        FourmedAmbert fourmedAmbert = coulommiers.a();
        if (fourmedAmbert != null) {
            this.c = fourmedAmbert.d();
        }
        if (!this.k.a(this.e)) {
            this.j.a(this.e, this.c);
            this.b = false;
            return;
        }
        if (comte18mois.d()) {
            this.j.a(this.e, comte18mois.b());
        } else {
            this.j.a(this.e);
        }
        if (comte18mois.a()) {
            this.a(comte18mois);
        }
        this.b = false;
    }

    private final boolean c() {
        return this.f.f() != System.currentTimeMillis() / TimeUnit.DAYS.toMillis(1L);
    }

    private final void d() {
        int n2 = 1 + this.f.a();
        this.f.a(n2);
    }

    private final void e() {
        this.f.d(Munster.a());
    }

    public static final class CamembertauCalvados {
        private CamembertauCalvados() {
        }

        public /* synthetic */ CamembertauCalvados(byte by) {
            this();
        }

        private static CoeurdArras b(Context context) {
            EpoissesdeBourgogne epoissesdeBourgogne = EpoissesdeBourgogne.CamembertauCalvados.a(context);
            CoeurdeNeufchatel coeurdeNeufchatel = new CoeurdeNeufchatel(new Chambertin(context), new Chaource(context));
            BoulettedAvesnes boulettedAvesnes = Bouyssou.a(context);
            CoeurdArras coeurdArras = new CoeurdArras(context, epoissesdeBourgogne, coeurdeNeufchatel, CremeuxduJura.a, boulettedAvesnes, (GorgonzolaPiccante)Goudaaucumin.a, (Langres)new Livarot(), 0);
            return coeurdArras;
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        public final CoeurdArras a(Context context) {
            Montbriac.a("Profig.getInstance");
            CamembertauCalvados camembertauCalvados = this;
            synchronized (camembertauCalvados) {
                CoeurdArras coeurdArras;
                if (l == null) {
                    Context context2 = context.getApplicationContext();
                    cl.a((Object)context2, "context.applicationContext");
                    CoeurdArras.b(CamembertauCalvados.b(context2));
                }
                if ((coeurdArras = l) == null) {
                    cl.a();
                }
                return coeurdArras;
            }
        }
    }

}

