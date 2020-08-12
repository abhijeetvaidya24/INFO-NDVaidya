/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  io.presage.FourmedAmbert
 *  java.lang.Object
 *  java.lang.String
 */
package io.presage;

import android.content.Context;
import io.presage.CoeurdArras;
import io.presage.EpoissesdeBourgogne;
import io.presage.FourmedAmbert;
import io.presage.FourmedeHauteLoire;

public final class FourmedAmbertBio {
    public static final FourmedAmbertBio a = new FourmedAmbertBio();
    private static FourmedAmbert b;

    private FourmedAmbertBio() {
    }

    public static FourmedAmbert a(Context context) {
        if (b == null) {
            String string2 = EpoissesdeBourgogne.CamembertauCalvados.a(context).d();
            b = FourmedeHauteLoire.a(string2);
        }
        return b;
    }

    public static void a(FourmedAmbert fourmedAmbert) {
        b = fourmedAmbert;
    }

    public static void b(Context context) {
        CoeurdArras.a(CoeurdArras.a.a(context));
    }
}

