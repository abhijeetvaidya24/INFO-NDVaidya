/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Collections
 *  java.util.LinkedHashMap
 *  java.util.Map
 */
package io.presage;

import io.presage.SableduBoulonnais;
import io.presage.an;
import io.presage.cd;
import io.presage.cl;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public final class SaintFelicien {
    public static final SaintFelicien a = new SaintFelicien();
    private static final Map<String, cd<SableduBoulonnais, an>> b = Collections.synchronizedMap((Map)((Map)new LinkedHashMap()));

    private SaintFelicien() {
    }

    public static void a(SableduBoulonnais sableduBoulonnais) {
        cd cd2 = (cd)b.get((Object)sableduBoulonnais.a());
        if (cd2 != null) {
            cd2.a(sableduBoulonnais);
        }
    }

    public static void a(String string2) {
        b.remove((Object)string2);
    }

    public static void a(String string2, cd<? super SableduBoulonnais, an> cd2) {
        Map<String, cd<SableduBoulonnais, an>> map = b;
        cl.a(map, "listeners");
        map.put((Object)string2, cd2);
    }
}

