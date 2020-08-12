/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  io.presage.BleudeSassenage
 *  io.presage.BrieauPoivre
 *  io.presage.o
 *  java.lang.Object
 */
package io.presage;

import android.content.Context;
import io.presage.BleudeSassenage;
import io.presage.Bofavre;
import io.presage.BoulettedAvesnes;
import io.presage.BrieauPoivre;
import io.presage.Chambertin;
import io.presage.Chaource;
import io.presage.FourmedAmbertBio;
import io.presage.FourmedeMontbrison;
import io.presage.cl;
import io.presage.o;

public final class Bouyssou {
    public static final Bouyssou a = new Bouyssou();
    private static BoulettedAvesnes b;

    private Bouyssou() {
    }

    public static BoulettedAvesnes a(Context context) {
        BoulettedAvesnes boulettedAvesnes;
        if (b == null) {
            Context context2 = context.getApplicationContext();
            cl.a((Object)context2, "appContext");
            Bofavre bofavre = Bofavre.CamembertauCalvados.a(context2);
            int n2 = FourmedeMontbrison.a(3);
            b = (BoulettedAvesnes)new BrieauPoivre(bofavre, new Chaource(context2), new Chambertin(context2), (o)new BleudeSassenage(FourmedAmbertBio.a, context2, n2));
        }
        if ((boulettedAvesnes = b) == null) {
            cl.a();
        }
        return boulettedAvesnes;
    }
}

