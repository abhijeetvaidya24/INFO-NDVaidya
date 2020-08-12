/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package com.aerserv.sdk.adapter.asaerserv.mraid;

public final class MraidAction
extends Enum<MraidAction> {
    private static final /* synthetic */ MraidAction[] $VALUES;
    public static final /* enum */ MraidAction ADD_EVENT_LISTENER = new MraidAction("addEventListener");
    public static final /* enum */ MraidAction CLOSE;
    public static final /* enum */ MraidAction CREATE_CALENDAR_EVENT;
    public static final /* enum */ MraidAction EXPAND;
    public static final /* enum */ MraidAction GET_CURRENT_POSITION;
    public static final /* enum */ MraidAction GET_DEFAULT_POSITION;
    public static final /* enum */ MraidAction GET_EXPAND_PROPERTIES;
    public static final /* enum */ MraidAction GET_MAX_SIZE;
    public static final /* enum */ MraidAction GET_PLACEMENT_TYPE;
    public static final /* enum */ MraidAction GET_RESIZE_PROPERTIES;
    public static final /* enum */ MraidAction GET_SCREEN_SIZE;
    public static final /* enum */ MraidAction GET_STATE;
    public static final /* enum */ MraidAction GET_VERSION;
    public static final /* enum */ MraidAction IS_VIEWABLE;
    public static final /* enum */ MraidAction OPEN;
    public static final /* enum */ MraidAction PLAY_VIDEO;
    public static final /* enum */ MraidAction REMOVE_EVENT_LISTENER;
    public static final /* enum */ MraidAction RESIZE;
    public static final /* enum */ MraidAction SET_EXPAND_PROPERTIES;
    public static final /* enum */ MraidAction SET_ORIENTATION_PROPERTIES;
    public static final /* enum */ MraidAction SET_RESIZE_PROPERTIES;
    public static final /* enum */ MraidAction STORE_PICTURE;
    public static final /* enum */ MraidAction SUPPORTS;
    public static final /* enum */ MraidAction USE_CUSTOM_CLOSE;
    private String name;

    static {
        CREATE_CALENDAR_EVENT = new MraidAction("createCalendarEvent");
        CLOSE = new MraidAction("close");
        EXPAND = new MraidAction("expand");
        GET_CURRENT_POSITION = new MraidAction("getCurrentPosition");
        GET_DEFAULT_POSITION = new MraidAction("getDefaultPosition");
        GET_EXPAND_PROPERTIES = new MraidAction("getExpandProperties");
        GET_MAX_SIZE = new MraidAction("getMaxSize");
        GET_PLACEMENT_TYPE = new MraidAction("getPlacementType");
        GET_RESIZE_PROPERTIES = new MraidAction("getResizeProperties");
        GET_SCREEN_SIZE = new MraidAction("getScreenSize");
        GET_STATE = new MraidAction("getState");
        GET_VERSION = new MraidAction("getVersion");
        IS_VIEWABLE = new MraidAction("isViewable");
        OPEN = new MraidAction("open");
        PLAY_VIDEO = new MraidAction("playVideo");
        REMOVE_EVENT_LISTENER = new MraidAction("removeEventListener");
        RESIZE = new MraidAction("resize");
        SET_EXPAND_PROPERTIES = new MraidAction("setExpandProperties");
        SET_RESIZE_PROPERTIES = new MraidAction("setResizeProperties");
        STORE_PICTURE = new MraidAction("storePicture");
        SUPPORTS = new MraidAction("supports");
        USE_CUSTOM_CLOSE = new MraidAction("useCustomClose");
        SET_ORIENTATION_PROPERTIES = new MraidAction("setOrientationProperties");
        MraidAction[] arrmraidAction = new MraidAction[]{ADD_EVENT_LISTENER, CREATE_CALENDAR_EVENT, CLOSE, EXPAND, GET_CURRENT_POSITION, GET_DEFAULT_POSITION, GET_EXPAND_PROPERTIES, GET_MAX_SIZE, GET_PLACEMENT_TYPE, GET_RESIZE_PROPERTIES, GET_SCREEN_SIZE, GET_STATE, GET_VERSION, IS_VIEWABLE, OPEN, PLAY_VIDEO, REMOVE_EVENT_LISTENER, RESIZE, SET_EXPAND_PROPERTIES, SET_RESIZE_PROPERTIES, STORE_PICTURE, SUPPORTS, USE_CUSTOM_CLOSE, SET_ORIENTATION_PROPERTIES};
        $VALUES = arrmraidAction;
    }

    private MraidAction(String string2) {
        this.name = string2;
    }

    public static MraidAction valueOf(String string) {
        return (MraidAction)Enum.valueOf(MraidAction.class, (String)string);
    }

    public static MraidAction[] values() {
        return (MraidAction[])$VALUES.clone();
    }

    public String getName() {
        return this.name;
    }
}

