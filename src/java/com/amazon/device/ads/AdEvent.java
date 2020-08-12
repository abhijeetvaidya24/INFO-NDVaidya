/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package com.amazon.device.ads;

import com.amazon.device.ads.ParameterMap;

class AdEvent {
    public static final String POSITION_ON_SCREEN = "positionOnScreen";
    private final AdEventType adEventType;
    private String customType;
    private final ParameterMap parameters = new ParameterMap();

    public AdEvent(AdEventType adEventType) {
        this.adEventType = adEventType;
    }

    AdEventType getAdEventType() {
        return this.adEventType;
    }

    public String getCustomType() {
        return this.customType;
    }

    public ParameterMap getParameters() {
        return this.parameters;
    }

    void setCustomType(String string) {
        this.customType = string;
    }

    AdEvent setParameter(String string, Object object) {
        this.parameters.setParameter(string, object);
        return this;
    }

    public static final class AdEventType
    extends Enum<AdEventType> {
        private static final /* synthetic */ AdEventType[] $VALUES;
        public static final /* enum */ AdEventType CLICKED;
        public static final /* enum */ AdEventType CLOSED;
        public static final /* enum */ AdEventType EXPANDED;
        public static final /* enum */ AdEventType OTHER;
        public static final /* enum */ AdEventType RESIZED;

        static {
            EXPANDED = new AdEventType();
            CLOSED = new AdEventType();
            CLICKED = new AdEventType();
            RESIZED = new AdEventType();
            OTHER = new AdEventType();
            AdEventType[] arradEventType = new AdEventType[]{EXPANDED, CLOSED, CLICKED, RESIZED, OTHER};
            $VALUES = arradEventType;
        }

        public static AdEventType valueOf(String string) {
            return (AdEventType)Enum.valueOf(AdEventType.class, (String)string);
        }

        public static AdEventType[] values() {
            return (AdEventType[])$VALUES.clone();
        }
    }

}

