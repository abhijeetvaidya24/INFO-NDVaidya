/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 *  java.util.HashMap
 *  java.util.Map
 */
package com.aerserv.sdk;

import java.util.HashMap;
import java.util.Map;

public final class AerServEvent
extends Enum<AerServEvent> {
    private static final /* synthetic */ AerServEvent[] $VALUES;
    public static final /* enum */ AerServEvent AD_ATTEMPT;
    public static final /* enum */ AerServEvent AD_CLICKED;
    public static final /* enum */ AerServEvent AD_COMPLETED;
    public static final /* enum */ AerServEvent AD_DISMISSED;
    public static final /* enum */ AerServEvent AD_FAILED;
    public static final /* enum */ AerServEvent AD_IMPRESSION;
    public static final /* enum */ AerServEvent AD_LOADED;
    public static final /* enum */ AerServEvent INTERNAL_AD_FAILED_TO_RENDER;
    public static final /* enum */ AerServEvent INTERNAL_BANNER_RENDERED;
    public static final /* enum */ AerServEvent INTERNAL_END_CARD_VIDEO_CLICKED;
    public static final /* enum */ AerServEvent INTERNAL_PRECACHE_READY;
    public static final /* enum */ AerServEvent INTERNAL_SHOW_ATTEMPTED;
    public static final /* enum */ AerServEvent LOAD_TRANSACTION;
    public static final /* enum */ AerServEvent MRAID_CLOSE;
    public static final /* enum */ AerServEvent MRAID_CREATE_CALENDAR_EVENT;
    public static final /* enum */ AerServEvent MRAID_EXPAND;
    public static final /* enum */ AerServEvent MRAID_OPEN;
    public static final /* enum */ AerServEvent MRAID_PLAY_VIDEO;
    public static final /* enum */ AerServEvent MRAID_READY;
    public static final /* enum */ AerServEvent MRAID_RESIZE;
    public static final /* enum */ AerServEvent MRAID_STORE_PICTURE;
    public static final /* enum */ AerServEvent PRELOAD_READY;
    public static final /* enum */ AerServEvent SHOW_TRANSACTION;
    public static final /* enum */ AerServEvent VC_READY;
    public static final /* enum */ AerServEvent VC_REWARDED;
    public static final /* enum */ AerServEvent VIDEO_25;
    public static final /* enum */ AerServEvent VIDEO_50;
    public static final /* enum */ AerServEvent VIDEO_75;
    public static final /* enum */ AerServEvent VIDEO_COMPLETED;
    public static final /* enum */ AerServEvent VIDEO_START;
    public static final Map<String, AerServEvent> translate;
    private boolean isInternal;

    static {
        VIDEO_START = new AerServEvent();
        VIDEO_25 = new AerServEvent();
        VIDEO_50 = new AerServEvent();
        VIDEO_75 = new AerServEvent();
        VIDEO_COMPLETED = new AerServEvent();
        PRELOAD_READY = new AerServEvent();
        INTERNAL_PRECACHE_READY = new AerServEvent(true);
        AD_ATTEMPT = new AerServEvent();
        AD_LOADED = new AerServEvent();
        AD_IMPRESSION = new AerServEvent();
        AD_CLICKED = new AerServEvent();
        AD_COMPLETED = new AerServEvent();
        AD_DISMISSED = new AerServEvent();
        AD_FAILED = new AerServEvent();
        VC_READY = new AerServEvent();
        VC_REWARDED = new AerServEvent();
        LOAD_TRANSACTION = new AerServEvent();
        SHOW_TRANSACTION = new AerServEvent();
        MRAID_READY = new AerServEvent();
        MRAID_CREATE_CALENDAR_EVENT = new AerServEvent();
        MRAID_CLOSE = new AerServEvent();
        MRAID_EXPAND = new AerServEvent();
        MRAID_OPEN = new AerServEvent();
        MRAID_PLAY_VIDEO = new AerServEvent();
        MRAID_RESIZE = new AerServEvent();
        MRAID_STORE_PICTURE = new AerServEvent();
        INTERNAL_AD_FAILED_TO_RENDER = new AerServEvent(true);
        INTERNAL_END_CARD_VIDEO_CLICKED = new AerServEvent(true);
        INTERNAL_SHOW_ATTEMPTED = new AerServEvent(true);
        INTERNAL_BANNER_RENDERED = new AerServEvent(true);
        AerServEvent[] arraerServEvent = new AerServEvent[]{VIDEO_START, VIDEO_25, VIDEO_50, VIDEO_75, VIDEO_COMPLETED, PRELOAD_READY, INTERNAL_PRECACHE_READY, AD_ATTEMPT, AD_LOADED, AD_IMPRESSION, AD_CLICKED, AD_COMPLETED, AD_DISMISSED, AD_FAILED, VC_READY, VC_REWARDED, LOAD_TRANSACTION, SHOW_TRANSACTION, MRAID_READY, MRAID_CREATE_CALENDAR_EVENT, MRAID_CLOSE, MRAID_EXPAND, MRAID_OPEN, MRAID_PLAY_VIDEO, MRAID_RESIZE, MRAID_STORE_PICTURE, INTERNAL_AD_FAILED_TO_RENDER, INTERNAL_END_CARD_VIDEO_CLICKED, INTERNAL_SHOW_ATTEMPTED, INTERNAL_BANNER_RENDERED};
        $VALUES = arraerServEvent;
        translate = new HashMap();
        translate.put((Object)"sdk_attempt", (Object)AD_ATTEMPT);
        translate.put((Object)"sdk_impression", (Object)AD_IMPRESSION);
        translate.put((Object)"sdk_failure", (Object)AD_FAILED);
        translate.put((Object)"banner_rendered", (Object)INTERNAL_BANNER_RENDERED);
        translate.put((Object)"vast_impression", (Object)AD_IMPRESSION);
        translate.put((Object)"click", (Object)INTERNAL_END_CARD_VIDEO_CLICKED);
        translate.put((Object)"video0", (Object)VIDEO_START);
        translate.put((Object)"video100", (Object)VIDEO_COMPLETED);
        translate.put((Object)"preloadUrl", (Object)PRELOAD_READY);
        translate.put((Object)"showAttemptUrl", (Object)INTERNAL_SHOW_ATTEMPTED);
    }

    private AerServEvent() {
        this(false);
    }

    private AerServEvent(boolean bl) {
        this.isInternal = bl;
    }

    public static AerServEvent valueOf(String string) {
        return (AerServEvent)Enum.valueOf(AerServEvent.class, (String)string);
    }

    public static AerServEvent[] values() {
        return (AerServEvent[])$VALUES.clone();
    }

    public boolean isInternal() {
        return this.isInternal;
    }
}

