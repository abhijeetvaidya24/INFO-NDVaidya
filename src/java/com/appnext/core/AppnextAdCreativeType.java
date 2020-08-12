/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package com.appnext.core;

public final class AppnextAdCreativeType
extends Enum<AppnextAdCreativeType> {
    private static final /* synthetic */ AppnextAdCreativeType[] $VALUES;
    public static final /* enum */ AppnextAdCreativeType STATIC = new AppnextAdCreativeType();
    public static final /* enum */ AppnextAdCreativeType VIDEO = new AppnextAdCreativeType();

    static {
        AppnextAdCreativeType[] arrappnextAdCreativeType = new AppnextAdCreativeType[]{STATIC, VIDEO};
        $VALUES = arrappnextAdCreativeType;
    }

    public static AppnextAdCreativeType valueOf(String string2) {
        return (AppnextAdCreativeType)Enum.valueOf(AppnextAdCreativeType.class, (String)string2);
    }

    public static AppnextAdCreativeType[] values() {
        return (AppnextAdCreativeType[])$VALUES.clone();
    }
}

