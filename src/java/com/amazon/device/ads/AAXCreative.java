/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 *  java.util.HashSet
 *  java.util.Iterator
 *  java.util.Set
 */
package com.amazon.device.ads;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

final class AAXCreative
extends Enum<AAXCreative> {
    private static final /* synthetic */ AAXCreative[] $VALUES;
    public static final /* enum */ AAXCreative CAN_EXPAND1;
    public static final /* enum */ AAXCreative CAN_EXPAND2;
    public static final /* enum */ AAXCreative CAN_PLAY_AUDIO1;
    public static final /* enum */ AAXCreative CAN_PLAY_AUDIO2;
    public static final /* enum */ AAXCreative CAN_PLAY_VIDEO;
    public static final /* enum */ AAXCreative HTML;
    public static final /* enum */ AAXCreative INTERSTITIAL;
    public static final /* enum */ AAXCreative MRAID1;
    public static final /* enum */ AAXCreative MRAID2;
    public static final /* enum */ AAXCreative REQUIRES_TRANSPARENCY;
    public static final /* enum */ AAXCreative VIDEO_INTERSTITIAL;
    private static final HashSet<AAXCreative> primaryCreativeTypes;
    private final int id;

    static {
        HTML = new AAXCreative(1007);
        MRAID1 = new AAXCreative(1016);
        MRAID2 = new AAXCreative(1017);
        INTERSTITIAL = new AAXCreative(1008);
        CAN_PLAY_AUDIO1 = new AAXCreative(1001);
        CAN_PLAY_AUDIO2 = new AAXCreative(1002);
        CAN_EXPAND1 = new AAXCreative(1003);
        CAN_EXPAND2 = new AAXCreative(1004);
        CAN_PLAY_VIDEO = new AAXCreative(1014);
        VIDEO_INTERSTITIAL = new AAXCreative(1030);
        REQUIRES_TRANSPARENCY = new AAXCreative(1031);
        AAXCreative[] arraAXCreative = new AAXCreative[]{HTML, MRAID1, MRAID2, INTERSTITIAL, CAN_PLAY_AUDIO1, CAN_PLAY_AUDIO2, CAN_EXPAND1, CAN_EXPAND2, CAN_PLAY_VIDEO, VIDEO_INTERSTITIAL, REQUIRES_TRANSPARENCY};
        $VALUES = arraAXCreative;
        primaryCreativeTypes = new HashSet();
        primaryCreativeTypes.add((Object)HTML);
        primaryCreativeTypes.add((Object)MRAID1);
        primaryCreativeTypes.add((Object)MRAID2);
        primaryCreativeTypes.add((Object)INTERSTITIAL);
        primaryCreativeTypes.add((Object)VIDEO_INTERSTITIAL);
    }

    private AAXCreative(int n2) {
        this.id = n2;
    }

    public static boolean containsPrimaryCreativeType(Set<AAXCreative> set) {
        Iterator iterator = primaryCreativeTypes.iterator();
        while (iterator.hasNext()) {
            if (!set.contains((Object)((AAXCreative)((Object)iterator.next())))) continue;
            return true;
        }
        return false;
    }

    public static AAXCreative getCreativeType(int n) {
        if (n != 1007) {
            if (n != 1008) {
                if (n != 1014) {
                    if (n != 1016) {
                        if (n != 1017) {
                            if (n != 1030) {
                                if (n != 1031) {
                                    switch (n) {
                                        default: {
                                            return null;
                                        }
                                        case 1004: {
                                            return CAN_EXPAND2;
                                        }
                                        case 1003: {
                                            return CAN_EXPAND1;
                                        }
                                        case 1002: {
                                            return CAN_PLAY_AUDIO2;
                                        }
                                        case 1001: 
                                    }
                                    return CAN_PLAY_AUDIO1;
                                }
                                return REQUIRES_TRANSPARENCY;
                            }
                            return VIDEO_INTERSTITIAL;
                        }
                        return MRAID2;
                    }
                    return MRAID1;
                }
                return CAN_PLAY_VIDEO;
            }
            return INTERSTITIAL;
        }
        return HTML;
    }

    static AAXCreative getTopCreative(Set<AAXCreative> set) {
        if (set.contains((Object)MRAID2)) {
            return MRAID2;
        }
        if (set.contains((Object)MRAID1)) {
            return MRAID1;
        }
        if (set.contains((Object)HTML)) {
            return HTML;
        }
        return null;
    }

    public static AAXCreative valueOf(String string) {
        return (AAXCreative)Enum.valueOf(AAXCreative.class, (String)string);
    }

    public static AAXCreative[] values() {
        return (AAXCreative[])$VALUES.clone();
    }

    public int getId() {
        return this.id;
    }
}

