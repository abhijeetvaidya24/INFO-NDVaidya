/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.Serializable
 *  java.lang.Object
 *  java.lang.String
 */
package com.appnext.core;

import java.io.Serializable;

public class g
implements Serializable {
    private static final long serialVersionUID = 8086013010302241826L;
    private int adID = -1;
    private String adJSON = "";
    private String placementID = "";
    private String sid = "";

    protected int getAdID() {
        return this.adID;
    }

    protected String getAdJSON() {
        return this.adJSON;
    }

    protected String getPlacementID() {
        return this.placementID;
    }

    protected String getSession() {
        return this.sid;
    }

    protected void setAdID(int n2) {
        this.adID = n2;
    }

    protected void setAdJSON(String string2) {
        this.adJSON = string2;
    }

    protected void setPlacementID(String string2) {
        this.placementID = string2;
    }

    protected void setSession(String string2) {
        this.sid = string2;
    }
}

