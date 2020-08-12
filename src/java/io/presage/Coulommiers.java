/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.presage.FourmedAmbert
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  org.json.JSONObject
 */
package io.presage;

import io.presage.Cheddar;
import io.presage.CoeurdeNeufchatel;
import io.presage.Comte18mois;
import io.presage.EmmentalGrandCru;
import io.presage.EpoissesdeBourgogne;
import io.presage.FourmedAmbert;
import io.presage.FourmedeHauteLoire;
import io.presage.Munster;
import io.presage.cl;
import org.json.JSONObject;

public final class Coulommiers {
    public static final CamembertauCalvados a = new CamembertauCalvados(0);
    private JSONObject b;
    private String c;
    private final String d;
    private final FourmedAmbert e;
    private final EmmentalGrandCru f;
    private final EpoissesdeBourgogne g;
    private final boolean h;

    public Coulommiers(CoeurdeNeufchatel coeurdeNeufchatel, EmmentalGrandCru emmentalGrandCru, EpoissesdeBourgogne epoissesdeBourgogne, boolean bl2) {
        this.f = emmentalGrandCru;
        this.g = epoissesdeBourgogne;
        this.h = bl2;
        this.b = coeurdeNeufchatel.a(this.f);
        String string2 = this.b.toString();
        cl.a((Object)string2, "generatedProfig.toString()");
        this.c = Cheddar.a(string2);
        this.d = this.g.d();
        this.e = FourmedeHauteLoire.a(this.d);
    }

    private final boolean c() {
        if (this.e != null) {
            return this.g.a() >= this.e.e();
        }
        return this.g.a() >= 10;
    }

    private final boolean d() {
        FourmedAmbert fourmedAmbert = this.e;
        if (fourmedAmbert != null) {
            return fourmedAmbert.a();
        }
        return true;
    }

    private final boolean e() {
        return cl.a((Object)this.g.g(), (Object)Munster.a());
    }

    private final boolean f() {
        FourmedAmbert fourmedAmbert = this.e;
        long l2 = fourmedAmbert != null ? fourmedAmbert.f() : 0L;
        return l2 + this.g.h() > System.currentTimeMillis();
    }

    private final boolean g() {
        return true ^ cl.a((Object)this.g.b(), (Object)this.c);
    }

    private final boolean h() {
        return true ^ cl.a((Object)this.g.c(), (Object)this.f.a());
    }

    private final JSONObject i() {
        if (!this.h && !this.g()) {
            return new JSONObject();
        }
        return this.b;
    }

    private final boolean j() {
        boolean bl2 = ((CharSequence)this.d).length() == 0;
        if (!bl2) {
            return cl.a((Object)this.d, (Object)"{}");
        }
        return true;
    }

    public final FourmedAmbert a() {
        return this.e;
    }

    public final Comte18mois b() {
        FourmedAmbert fourmedAmbert = this.e;
        long l2 = fourmedAmbert != null ? fourmedAmbert.f() : 43200000L;
        long l3 = l2;
        boolean bl2 = this.d();
        boolean bl3 = bl2 ^ true;
        boolean bl4 = this.c();
        boolean bl5 = this.f();
        boolean bl6 = true;
        boolean bl7 = bl5 ^ bl6;
        boolean bl8 = bl6 ^ this.e();
        boolean bl9 = bl3 && bl8;
        if (!(bl2 && !bl4 && bl7 && (this.h || this.g() || bl8 || bl7))) {
            bl6 = false;
        }
        if (this.j()) {
            Comte18mois comte18mois = new Comte18mois(true, l3, this.b, bl2, this.c);
            return comte18mois;
        }
        if (!(bl6 || bl9 || this.h())) {
            return new Comte18mois(l3, new JSONObject(), bl2);
        }
        boolean bl10 = this.g();
        String string2 = null;
        if (bl10) {
            string2 = this.c;
        }
        String string3 = string2;
        Comte18mois comte18mois = new Comte18mois(true, l3, this.i(), bl2, string3);
        return comte18mois;
    }

    public static final class CamembertauCalvados {
        private CamembertauCalvados() {
        }

        public /* synthetic */ CamembertauCalvados(byte by) {
            this();
        }
    }

}

