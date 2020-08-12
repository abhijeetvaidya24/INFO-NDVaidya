/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  io.presage.Aveyronnais
 *  io.presage.BleudeGex$CamembertdeNormandie
 *  java.lang.Object
 *  java.lang.String
 */
package io.presage;

import android.content.Context;
import io.presage.Aveyronnais;
import io.presage.BleudeGex;
import io.presage.BoulettedAvesnes;
import io.presage.Bouyssou;
import io.presage.CantalEntreDeux;
import io.presage.CarreMirabelle;
import io.presage.cc;
import io.presage.common.AdConfig;

public final class BleudeGex {
    public static final CamembertauCalvados a = new CamembertauCalvados(0);
    private final BoulettedAvesnes b;
    private final CarreMirabelle c;

    public BleudeGex(Context context) {
        BoulettedAvesnes boulettedAvesnes = Bouyssou.a(context);
        this(boulettedAvesnes, CarreMirabelle.CamembertauCalvados.a(context));
    }

    private BleudeGex(BoulettedAvesnes boulettedAvesnes, CarreMirabelle carreMirabelle) {
        this.b = boulettedAvesnes;
        this.c = carreMirabelle;
    }

    public static final /* synthetic */ BoulettedAvesnes a(BleudeGex bleudeGex) {
        return bleudeGex.b;
    }

    public static final /* synthetic */ CarreMirabelle b(BleudeGex bleudeGex) {
        return bleudeGex.c;
    }

    public final Aveyronnais<CantalEntreDeux> a(String string2, AdConfig adConfig, String string3) {
        return Aveyronnais.CamembertauCalvados.a((cc)new CamembertdeNormandie(this, string2, adConfig, string3));
    }

    public static final class CamembertauCalvados {
        private CamembertauCalvados() {
        }

        public /* synthetic */ CamembertauCalvados(byte by) {
            this();
        }
    }

}

