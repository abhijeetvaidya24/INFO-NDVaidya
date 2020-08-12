/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 *  java.util.HashMap
 *  java.util.Set
 */
package com.amazon.device.ads;

import java.util.HashMap;
import java.util.Set;

class SDKEvent {
    public static final String BRIDGE_NAME = "bridgeName";
    private final SDKEventType eventType;
    private final HashMap<String, String> parameters = new HashMap();

    public SDKEvent(SDKEventType sDKEventType) {
        this.eventType = sDKEventType;
    }

    public SDKEventType getEventType() {
        return this.eventType;
    }

    public String getParameter(String string) {
        return (String)this.parameters.get((Object)string);
    }

    public Set<String> getParameterNames() {
        return this.parameters.keySet();
    }

    public SDKEvent setParameter(String string, String string2) {
        this.parameters.put((Object)string, (Object)string2);
        return this;
    }

    public static final class SDKEventType
    extends Enum<SDKEventType> {
        private static final /* synthetic */ SDKEventType[] $VALUES;
        public static final /* enum */ SDKEventType BACK_BUTTON_PRESSED;
        public static final /* enum */ SDKEventType BRIDGE_ADDED;
        public static final /* enum */ SDKEventType CLOSED;
        public static final /* enum */ SDKEventType DESTROYED;
        public static final /* enum */ SDKEventType HIDDEN;
        public static final /* enum */ SDKEventType PLACED;
        public static final /* enum */ SDKEventType READY;
        public static final /* enum */ SDKEventType RENDERED;
        public static final /* enum */ SDKEventType RESIZED;
        public static final /* enum */ SDKEventType VIEWABLE;
        public static final /* enum */ SDKEventType VISIBLE;

        static {
            RENDERED = new SDKEventType();
            PLACED = new SDKEventType();
            VISIBLE = new SDKEventType();
            HIDDEN = new SDKEventType();
            DESTROYED = new SDKEventType();
            CLOSED = new SDKEventType();
            READY = new SDKEventType();
            RESIZED = new SDKEventType();
            BRIDGE_ADDED = new SDKEventType();
            BACK_BUTTON_PRESSED = new SDKEventType();
            VIEWABLE = new SDKEventType();
            SDKEventType[] arrsDKEventType = new SDKEventType[]{RENDERED, PLACED, VISIBLE, HIDDEN, DESTROYED, CLOSED, READY, RESIZED, BRIDGE_ADDED, BACK_BUTTON_PRESSED, VIEWABLE};
            $VALUES = arrsDKEventType;
        }

        public static SDKEventType valueOf(String string) {
            return (SDKEventType)Enum.valueOf(SDKEventType.class, (String)string);
        }

        public static SDKEventType[] values() {
            return (SDKEventType[])$VALUES.clone();
        }
    }

}

