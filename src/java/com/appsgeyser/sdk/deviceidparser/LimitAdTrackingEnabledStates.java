/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package com.appsgeyser.sdk.deviceidparser;

public final class LimitAdTrackingEnabledStates
extends Enum<LimitAdTrackingEnabledStates> {
    private static final /* synthetic */ LimitAdTrackingEnabledStates[] $VALUES;
    public static final /* enum */ LimitAdTrackingEnabledStates FALSE;
    public static final /* enum */ LimitAdTrackingEnabledStates TRUE;
    public static final /* enum */ LimitAdTrackingEnabledStates UNKNOWN;

    static {
        TRUE = new LimitAdTrackingEnabledStates();
        FALSE = new LimitAdTrackingEnabledStates();
        UNKNOWN = new LimitAdTrackingEnabledStates();
        LimitAdTrackingEnabledStates[] arrlimitAdTrackingEnabledStates = new LimitAdTrackingEnabledStates[]{TRUE, FALSE, UNKNOWN};
        $VALUES = arrlimitAdTrackingEnabledStates;
    }

    public static LimitAdTrackingEnabledStates valueOf(String string2) {
        return (LimitAdTrackingEnabledStates)Enum.valueOf(LimitAdTrackingEnabledStates.class, (String)string2);
    }

    public static LimitAdTrackingEnabledStates[] values() {
        return (LimitAdTrackingEnabledStates[])$VALUES.clone();
    }
}

