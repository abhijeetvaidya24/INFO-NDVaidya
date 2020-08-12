/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  io.presage.AbbayedeCiteauxentiere
 *  io.presage.Bethmale$AbbayedeTamie
 *  io.presage.Bethmale$AbbayedeTimadeuc
 *  io.presage.Bethmale$AbbayeduMontdesCats
 *  io.presage.Bethmale$AffideliceauChablis
 *  io.presage.Bethmale$CamembertdeNormandie
 *  io.presage.Bethmale$EcirdelAubrac
 *  io.presage.BleudAuvergne
 *  io.presage.BleudAuvergnebio
 *  io.presage.EcirdelAubrac
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  org.json.JSONObject
 */
package io.presage;

import android.content.Context;
import io.presage.AbbayedeCiteauxentiere;
import io.presage.Beaufort;
import io.presage.Bethmale;
import io.presage.BleudAuvergne;
import io.presage.BleudAuvergnebio;
import io.presage.BleudeLaqueuille;
import io.presage.BoulettedAvesnes;
import io.presage.Bouyssou;
import io.presage.BrillatSavarin;
import io.presage.CapGrisNez;
import io.presage.Maroilles;
import io.presage.cc;
import io.presage.cd;
import org.json.JSONObject;

public final class Bethmale {
    public static final CamembertauCalvados a = new CamembertauCalvados(0);
    private final BoulettedAvesnes b;
    private final BleudeLaqueuille c;

    private Bethmale(BoulettedAvesnes boulettedAvesnes, BleudeLaqueuille bleudeLaqueuille) {
        this.b = boulettedAvesnes;
        this.c = bleudeLaqueuille;
    }

    public /* synthetic */ Bethmale(BoulettedAvesnes boulettedAvesnes, BleudeLaqueuille bleudeLaqueuille, byte by) {
        this(boulettedAvesnes, bleudeLaqueuille);
    }

    private final void a(AbbayedeCiteauxentiere abbayedeCiteauxentiere) {
        JSONObject jSONObject = this.b(abbayedeCiteauxentiere);
        this.b.c(jSONObject).a((cd)new CamembertdeNormandie(Maroilles.a)).a((cc)EcirdelAubrac.a);
    }

    private final void a(BleudAuvergne bleudAuvergne) {
        String string2 = Bethmale.b(bleudAuvergne);
        this.b.a(string2).a((cd)new AbbayedeTamie(Maroilles.a)).a((cc)AbbayedeTimadeuc.a);
    }

    private final void a(BleudAuvergnebio bleudAuvergnebio) {
        JSONObject jSONObject = this.b(bleudAuvergnebio);
        this.b.b(jSONObject).a((cd)new AbbayeduMontdesCats(Maroilles.a)).a((cc)AffideliceauChablis.a);
    }

    private static String b(BleudAuvergne bleudAuvergne) {
        StringBuilder stringBuilder = new StringBuilder("{\"content\":[{\"type\":\"");
        stringBuilder.append(bleudAuvergne.f());
        stringBuilder.append("\",\"timestamp_diff\":0}]}");
        return stringBuilder.toString();
    }

    private final JSONObject b(AbbayedeCiteauxentiere abbayedeCiteauxentiere) {
        BrillatSavarin brillatSavarin = abbayedeCiteauxentiere.a();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("campaign_id", (Object)brillatSavarin.f());
        jSONObject.put("advert_id", (Object)brillatSavarin.a());
        jSONObject.put("advertiser_id", (Object)brillatSavarin.e());
        jSONObject.put("ad_unit_id", (Object)brillatSavarin.k().a());
        jSONObject.put("url", (Object)abbayedeCiteauxentiere.b());
        jSONObject.put("source", (Object)abbayedeCiteauxentiere.c());
        if (abbayedeCiteauxentiere.d() != null) {
            jSONObject.put("tracker_pattern", (Object)abbayedeCiteauxentiere.d());
        }
        if (abbayedeCiteauxentiere.e() != null) {
            jSONObject.put("tracker_url", (Object)abbayedeCiteauxentiere.e());
        }
        JSONObject jSONObject2 = this.c.a();
        jSONObject2.put("content", (Object)jSONObject);
        return jSONObject2;
    }

    private final JSONObject b(BleudAuvergnebio bleudAuvergnebio) {
        BrillatSavarin brillatSavarin = bleudAuvergnebio.a();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("event", (Object)bleudAuvergnebio.f());
        jSONObject.put("campaign", (Object)brillatSavarin.f());
        jSONObject.put("advertiser", (Object)brillatSavarin.e());
        jSONObject.put("advert", (Object)brillatSavarin.a());
        jSONObject.put("ad_unit_id", (Object)brillatSavarin.k().a());
        JSONObject jSONObject2 = this.c.a();
        jSONObject2.put("content", (Object)jSONObject);
        return jSONObject2;
    }

    public final void a(Beaufort beaufort) {
        if (beaufort instanceof BleudAuvergne) {
            this.a((BleudAuvergne)beaufort);
            return;
        }
        if (beaufort instanceof BleudAuvergnebio) {
            this.a((BleudAuvergnebio)beaufort);
            return;
        }
        if (beaufort instanceof AbbayedeCiteauxentiere) {
            this.a((AbbayedeCiteauxentiere)beaufort);
        }
    }

    public static final class CamembertauCalvados {
        private CamembertauCalvados() {
        }

        public /* synthetic */ CamembertauCalvados(byte by) {
            this();
        }

        public static Bethmale a(Context context) {
            return new Bethmale(Bouyssou.a(context), new BleudeLaqueuille(context), 0);
        }
    }

}

