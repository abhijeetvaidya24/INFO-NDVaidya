/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources
 *  android.util.DisplayMetrics
 *  io.presage.cz
 *  java.lang.Object
 */
package io.presage;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import io.presage.cl;
import io.presage.cz;

public final class Mimolette24mois {
    public static final int a(int n2) {
        return cz.a((float)Mimolette24mois.c(n2));
    }

    public static final int b(int n2) {
        float f2 = n2;
        Resources resources = Resources.getSystem();
        cl.a((Object)resources, "Resources.getSystem()");
        return cz.a((float)(f2 * resources.getDisplayMetrics().density));
    }

    private static float c(int n2) {
        float f2 = n2;
        Resources resources = Resources.getSystem();
        cl.a((Object)resources, "Resources.getSystem()");
        return f2 / resources.getDisplayMetrics().density;
    }
}

