/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package com.amazon.device.ads;

final class AdState
extends Enum<AdState> {
    private static final /* synthetic */ AdState[] $VALUES;
    public static final /* enum */ AdState DESTROYED;
    public static final /* enum */ AdState DRAWING;
    public static final /* enum */ AdState EXPANDED;
    public static final /* enum */ AdState HIDDEN;
    public static final /* enum */ AdState INVALID;
    public static final /* enum */ AdState LOADED;
    public static final /* enum */ AdState LOADING;
    public static final /* enum */ AdState READY_TO_LOAD;
    public static final /* enum */ AdState RENDERED;
    public static final /* enum */ AdState RENDERING;
    public static final /* enum */ AdState SHOWING;

    static {
        READY_TO_LOAD = new AdState();
        LOADING = new AdState();
        LOADED = new AdState();
        RENDERING = new AdState();
        RENDERED = new AdState();
        DRAWING = new AdState();
        SHOWING = new AdState();
        EXPANDED = new AdState();
        HIDDEN = new AdState();
        INVALID = new AdState();
        DESTROYED = new AdState();
        AdState[] arradState = new AdState[]{READY_TO_LOAD, LOADING, LOADED, RENDERING, RENDERED, DRAWING, SHOWING, EXPANDED, HIDDEN, INVALID, DESTROYED};
        $VALUES = arradState;
    }

    public static AdState valueOf(String string) {
        return (AdState)Enum.valueOf(AdState.class, (String)string);
    }

    public static AdState[] values() {
        return (AdState[])$VALUES.clone();
    }
}

