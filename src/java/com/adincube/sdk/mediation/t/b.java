/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.presage.Presage
 *  java.lang.NoClassDefFoundError
 *  java.lang.Object
 *  java.lang.String
 */
package com.adincube.sdk.mediation.t;

import io.presage.Presage;

public final class b {
    public static boolean a() {
        try {
            Presage.class.getSimpleName();
            return true;
        }
        catch (NoClassDefFoundError noClassDefFoundError) {
            return false;
        }
    }
}

