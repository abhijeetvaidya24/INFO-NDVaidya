/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.adcolony.sdk.a
 *  com.adcolony.sdk.ad
 *  com.adcolony.sdk.af
 *  com.adcolony.sdk.au
 *  com.adcolony.sdk.m$1
 *  com.adcolony.sdk.w
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  org.json.JSONObject
 */
package com.adcolony.sdk;

import com.adcolony.sdk.a;
import com.adcolony.sdk.ad;
import com.adcolony.sdk.af;
import com.adcolony.sdk.au;
import com.adcolony.sdk.m;
import com.adcolony.sdk.w;
import org.json.JSONObject;

class m
implements af {
    m() {
        a.a((String)"CustomMessage.controller_send", (af)this);
    }

    public void a(ad ad2) {
        JSONObject jSONObject = ad2.c();
        String string = w.b((JSONObject)jSONObject, (String)"type");
        au.a((Runnable)new 1(this, w.b((JSONObject)jSONObject, (String)"message"), string));
    }
}

