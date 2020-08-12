/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.presage.BleudAuvergnebio
 *  io.presage.y
 *  io.presage.z
 *  java.lang.CharSequence
 *  java.lang.Iterable
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Thread
 *  java.lang.Throwable
 *  java.util.List
 */
package io.presage;

import io.presage.Abondance;
import io.presage.Beaufort;
import io.presage.BleudAuvergnebio;
import io.presage.BoulettedAvesnes;
import io.presage.BrillatSavarin;
import io.presage.CarreMirabelle;
import io.presage.CarreNormand;
import io.presage.cl;
import io.presage.y;
import io.presage.z;
import java.util.List;

public final class CendreduBeauzac {
    public static final CendreduBeauzac a = new CendreduBeauzac();

    private CendreduBeauzac() {
    }

    private static BrillatSavarin a(List<BrillatSavarin> list) {
        Object object2;
        block1 : {
            for (Object object2 : (Iterable)list) {
                boolean bl2 = ((CharSequence)((BrillatSavarin)object2).j()).length() > 0;
                if (!bl2) continue;
                break block1;
            }
            object2 = null;
        }
        return (BrillatSavarin)object2;
    }

    private final void a(String string2, boolean bl2, CarreMirabelle carreMirabelle, BoulettedAvesnes boulettedAvesnes) throws CarreNormand {
        y y2 = boulettedAvesnes.c(string2);
        if (y2 instanceof z) {
            carreMirabelle.a(((z)y2).a());
            carreMirabelle.b(string2);
            return;
        }
        if (bl2) {
            Thread.sleep((long)400L);
            this.a(string2, false, carreMirabelle, boulettedAvesnes);
            return;
        }
        throw (Throwable)((Object)new CarreNormand());
    }

    public final void a(List<BrillatSavarin> list, CarreMirabelle carreMirabelle, BoulettedAvesnes boulettedAvesnes) throws CarreNormand {
        BrillatSavarin brillatSavarin = CendreduBeauzac.a(list);
        if (brillatSavarin != null && true ^ cl.a((Object)brillatSavarin.j(), (Object)carreMirabelle.a())) {
            try {
                this.a(brillatSavarin.j(), true, carreMirabelle, boulettedAvesnes);
                return;
            }
            catch (CarreNormand carreNormand) {
                Abondance.a((Beaufort)new BleudAuvergnebio("loaded_error", brillatSavarin));
                throw (Throwable)((Object)carreNormand);
            }
        }
    }
}

