/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  org.json.JSONObject
 */
package com.adcolony.sdk;

import com.adcolony.sdk.ad;
import com.adcolony.sdk.w;
import org.json.JSONObject;

public class AdColonyReward {
    private int a;
    private String b;
    private String c;
    private boolean d;

    AdColonyReward(ad ad2) {
        JSONObject jSONObject = ad2.c();
        this.a = w.c(jSONObject, "reward_amount");
        this.b = w.b(jSONObject, "reward_name");
        this.d = w.d(jSONObject, "success");
        this.c = w.b(jSONObject, "zone_id");
    }

    public int getRewardAmount() {
        return this.a;
    }

    public String getRewardName() {
        return this.b;
    }
}

