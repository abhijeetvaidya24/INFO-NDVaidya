/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.lang.Object
 */
package io.presage;

import android.content.Context;
import io.presage.Beaufort;
import io.presage.Bethmale;

public final class Abondance {
    public static final Abondance a = new Abondance();
    private static Bethmale b;

    private Abondance() {
    }

    public static void a(Context context) {
        if (b == null) {
            b = Bethmale.CamembertauCalvados.a(context);
        }
    }

    public static void a(Beaufort beaufort) {
        Bethmale bethmale = b;
        if (bethmale != null) {
            bethmale.a(beaufort);
        }
    }
}

