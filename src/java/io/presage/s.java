/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.presage.s$CamembertauCalvados
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Map
 */
package io.presage;

import io.presage.cl;
import io.presage.r;
import io.presage.s;
import java.util.Map;

public final class s {
    private static final r a = (r)new CamembertauCalvados();

    public static final boolean a(r r2) {
        return cl.a((Object)((String)r2.a().get((Object)"Content-Encoding")), (Object)"gzip");
    }
}

