/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package com.integralads.avid.library.adcolony.walking;

public final class ViewType
extends Enum<ViewType> {
    public static final /* enum */ ViewType OBSTRUCTION_VIEW;
    public static final /* enum */ ViewType ROOT_VIEW;
    public static final /* enum */ ViewType UNDERLYING_VIEW;
    private static final /* synthetic */ ViewType[] a;

    static {
        ROOT_VIEW = new ViewType();
        OBSTRUCTION_VIEW = new ViewType();
        UNDERLYING_VIEW = new ViewType();
        ViewType[] arrviewType = new ViewType[]{ROOT_VIEW, OBSTRUCTION_VIEW, UNDERLYING_VIEW};
        a = arrviewType;
    }

    public static ViewType valueOf(String string) {
        return (ViewType)Enum.valueOf(ViewType.class, (String)string);
    }

    public static ViewType[] values() {
        return (ViewType[])a.clone();
    }
}

