/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Locale
 */
package com.amazon.device.ads;

import java.util.Locale;

final class ForceOrientation
extends Enum<ForceOrientation> {
    private static final /* synthetic */ ForceOrientation[] $VALUES;
    public static final /* enum */ ForceOrientation LANDSCAPE;
    public static final /* enum */ ForceOrientation NONE;
    public static final /* enum */ ForceOrientation PORTRAIT;

    static {
        PORTRAIT = new ForceOrientation();
        LANDSCAPE = new ForceOrientation();
        NONE = new ForceOrientation();
        ForceOrientation[] arrforceOrientation = new ForceOrientation[]{PORTRAIT, LANDSCAPE, NONE};
        $VALUES = arrforceOrientation;
    }

    public static ForceOrientation valueOf(String string) {
        return (ForceOrientation)Enum.valueOf(ForceOrientation.class, (String)string);
    }

    public static ForceOrientation[] values() {
        return (ForceOrientation[])$VALUES.clone();
    }

    public String toString() {
        return this.name().toLowerCase(Locale.US);
    }
}

