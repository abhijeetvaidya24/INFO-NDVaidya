/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Boolean
 *  java.lang.Double
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.util.HashMap
 */
package com.amazon.device.ads;

import java.util.HashMap;

class ParameterMap {
    private final HashMap<String, Object> parameters = new HashMap();

    ParameterMap() {
    }

    public Boolean getBooleanParameter(String string) {
        return (Boolean)this.parameters.get((Object)string);
    }

    public Double getDoubleParameter(String string) {
        return (Double)this.parameters.get((Object)string);
    }

    public Integer getIntParameter(String string) {
        return (Integer)this.parameters.get((Object)string);
    }

    public Long getLongParameter(String string) {
        return (Long)this.parameters.get((Object)string);
    }

    public Object getParameter(String string) {
        return this.parameters.get((Object)string);
    }

    public String getStringParameter(String string) {
        return (String)this.parameters.get((Object)string);
    }

    public void setParameter(String string, Object object) {
        this.parameters.put((Object)string, object);
    }
}

