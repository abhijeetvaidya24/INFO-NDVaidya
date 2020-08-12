/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package com.aerserv.sdk.notification;

public final class NotificationType
extends Enum<NotificationType> {
    private static final /* synthetic */ NotificationType[] $VALUES;
    public static final /* enum */ NotificationType AD_REQUESTED_FOR_PLC = new NotificationType();
    public static final /* enum */ NotificationType SHOW_ATTEMPTED_FOR_PLC = new NotificationType();

    static {
        NotificationType[] arrnotificationType = new NotificationType[]{AD_REQUESTED_FOR_PLC, SHOW_ATTEMPTED_FOR_PLC};
        $VALUES = arrnotificationType;
    }

    public static NotificationType valueOf(String string) {
        return (NotificationType)Enum.valueOf(NotificationType.class, (String)string);
    }

    public static NotificationType[] values() {
        return (NotificationType[])$VALUES.clone();
    }
}

