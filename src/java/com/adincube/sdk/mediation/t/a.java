/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.presage.common.PresageSdk
 *  java.lang.NoClassDefFoundError
 *  java.lang.Object
 *  java.lang.String
 */
package com.adincube.sdk.mediation.t;

import io.presage.common.PresageSdk;

public final class a {
    public static boolean a() {
        try {
            PresageSdk.class.getSimpleName();
            return true;
        }
        catch (NoClassDefFoundError noClassDefFoundError) {
            return false;
        }
    }
}

