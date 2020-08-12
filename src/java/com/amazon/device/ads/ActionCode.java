/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package com.amazon.device.ads;

final class ActionCode
extends Enum<ActionCode> {
    private static final /* synthetic */ ActionCode[] $VALUES;
    public static final /* enum */ ActionCode DISPLAY;
    public static final /* enum */ ActionCode HANDLED;
    public static final /* enum */ ActionCode REJECT;

    static {
        REJECT = new ActionCode();
        DISPLAY = new ActionCode();
        HANDLED = new ActionCode();
        ActionCode[] arractionCode = new ActionCode[]{REJECT, DISPLAY, HANDLED};
        $VALUES = arractionCode;
    }

    public static ActionCode valueOf(String string) {
        return (ActionCode)Enum.valueOf(ActionCode.class, (String)string);
    }

    public static ActionCode[] values() {
        return (ActionCode[])$VALUES.clone();
    }
}

