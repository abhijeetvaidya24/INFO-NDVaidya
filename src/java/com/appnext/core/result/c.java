/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.appnext.core.AppnextAd
 *  java.lang.Object
 *  java.lang.String
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.appnext.core.result;

import com.appnext.core.Ad;
import com.appnext.core.AppnextAd;
import com.appnext.core.p;
import com.appnext.core.result.a;
import org.json.JSONException;
import org.json.JSONObject;

public interface c {
    public String A();

    public String B();

    public p C();

    public Ad D();

    public a E();

    public JSONObject getConfigParams() throws JSONException;

    public String getPlacementId();

    public AppnextAd getSelectedAd();

    public String z();
}

