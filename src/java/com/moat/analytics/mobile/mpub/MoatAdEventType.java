/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package com.moat.analytics.mobile.mpub;

public final class MoatAdEventType
extends Enum<MoatAdEventType> {
    public static final /* enum */ MoatAdEventType AD_EVT_COMPLETE;
    public static final /* enum */ MoatAdEventType AD_EVT_ENTER_FULLSCREEN;
    public static final /* enum */ MoatAdEventType AD_EVT_EXIT_FULLSCREEN;
    public static final /* enum */ MoatAdEventType AD_EVT_FIRST_QUARTILE;
    public static final /* enum */ MoatAdEventType AD_EVT_MID_POINT;
    public static final /* enum */ MoatAdEventType AD_EVT_PAUSED;
    public static final /* enum */ MoatAdEventType AD_EVT_PLAYING;
    public static final /* enum */ MoatAdEventType AD_EVT_SKIPPED;
    public static final /* enum */ MoatAdEventType AD_EVT_START;
    public static final /* enum */ MoatAdEventType AD_EVT_STOPPED;
    public static final /* enum */ MoatAdEventType AD_EVT_THIRD_QUARTILE;
    public static final /* enum */ MoatAdEventType AD_EVT_VOLUME_CHANGE;
    private static final /* synthetic */ MoatAdEventType[] b;
    private final String a;

    static {
        AD_EVT_FIRST_QUARTILE = new MoatAdEventType("AdVideoFirstQuartile");
        AD_EVT_MID_POINT = new MoatAdEventType("AdVideoMidpoint");
        AD_EVT_THIRD_QUARTILE = new MoatAdEventType("AdVideoThirdQuartile");
        AD_EVT_COMPLETE = new MoatAdEventType("AdVideoComplete");
        AD_EVT_PAUSED = new MoatAdEventType("AdPaused");
        AD_EVT_PLAYING = new MoatAdEventType("AdPlaying");
        AD_EVT_START = new MoatAdEventType("AdVideoStart");
        AD_EVT_STOPPED = new MoatAdEventType("AdStopped");
        AD_EVT_SKIPPED = new MoatAdEventType("AdSkipped");
        AD_EVT_VOLUME_CHANGE = new MoatAdEventType("AdVolumeChange");
        AD_EVT_ENTER_FULLSCREEN = new MoatAdEventType("fullScreen");
        AD_EVT_EXIT_FULLSCREEN = new MoatAdEventType("exitFullscreen");
        MoatAdEventType[] arrmoatAdEventType = new MoatAdEventType[]{AD_EVT_FIRST_QUARTILE, AD_EVT_MID_POINT, AD_EVT_THIRD_QUARTILE, AD_EVT_COMPLETE, AD_EVT_PAUSED, AD_EVT_PLAYING, AD_EVT_START, AD_EVT_STOPPED, AD_EVT_SKIPPED, AD_EVT_VOLUME_CHANGE, AD_EVT_ENTER_FULLSCREEN, AD_EVT_EXIT_FULLSCREEN};
        b = arrmoatAdEventType;
    }

    private MoatAdEventType(String string3) {
        this.a = string3;
    }

    public static MoatAdEventType fromString(String string2) {
        if (string2 != null) {
            for (MoatAdEventType moatAdEventType : MoatAdEventType.values()) {
                if (!string2.equalsIgnoreCase(moatAdEventType.toString())) continue;
                return moatAdEventType;
            }
        }
        return null;
    }

    public static MoatAdEventType valueOf(String string2) {
        return (MoatAdEventType)Enum.valueOf(MoatAdEventType.class, (String)string2);
    }

    public static MoatAdEventType[] values() {
        return (MoatAdEventType[])b.clone();
    }

    public String toString() {
        return this.a;
    }
}

