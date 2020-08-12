/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 *  java.util.EnumSet
 *  java.util.HashMap
 */
package com.aerserv.sdk.model.vast;

import java.util.EnumSet;
import java.util.HashMap;

public final class DeliveryMethod
extends Enum<DeliveryMethod> {
    private static final /* synthetic */ DeliveryMethod[] $VALUES;
    public static final /* enum */ DeliveryMethod PROGRESSIVE;
    public static final /* enum */ DeliveryMethod STREAMING;
    private static HashMap<String, DeliveryMethod> deliveryMethodHashMap;
    private String methodString;

    static {
        STREAMING = new DeliveryMethod("streaming");
        PROGRESSIVE = new DeliveryMethod("progressive");
        DeliveryMethod[] arrdeliveryMethod = new DeliveryMethod[]{STREAMING, PROGRESSIVE};
        $VALUES = arrdeliveryMethod;
        deliveryMethodHashMap = new HashMap();
        for (DeliveryMethod deliveryMethod : EnumSet.allOf(DeliveryMethod.class)) {
            deliveryMethodHashMap.put((Object)deliveryMethod.getMethodString(), (Object)deliveryMethod);
        }
    }

    private DeliveryMethod(String string2) {
        this.methodString = string2;
    }

    public static DeliveryMethod get(String string) {
        return (DeliveryMethod)((Object)deliveryMethodHashMap.get((Object)string));
    }

    public static DeliveryMethod valueOf(String string) {
        return (DeliveryMethod)Enum.valueOf(DeliveryMethod.class, (String)string);
    }

    public static DeliveryMethod[] values() {
        return (DeliveryMethod[])$VALUES.clone();
    }

    public String getMethodString() {
        return this.methodString;
    }
}

