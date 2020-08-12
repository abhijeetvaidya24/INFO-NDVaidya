/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.Serializable
 *  java.lang.Object
 *  java.lang.String
 *  java.util.HashMap
 */
package com.appnext.ads.fullscreen;

import java.io.Serializable;
import java.util.HashMap;

public class RewardedServerSidePostback
implements Serializable {
    private static final long serialVersionUID = 1L;
    private String bo = "";
    private String bp = "";
    private String bq = "";
    private String br = "";
    private String bs = "";

    public RewardedServerSidePostback() {
    }

    public RewardedServerSidePostback(String string2, String string3, String string4, String string5, String string6) {
        this.bo = string2;
        this.bp = string3;
        this.bq = string4;
        this.br = string5;
        this.bs = string6;
    }

    public String getRewardsAmountRewarded() {
        return this.br;
    }

    public String getRewardsCustomParameter() {
        return this.bs;
    }

    public String getRewardsRewardTypeCurrency() {
        return this.bq;
    }

    public String getRewardsTransactionId() {
        return this.bo;
    }

    public String getRewardsUserId() {
        return this.bp;
    }

    protected final HashMap<String, String> p() {
        HashMap hashMap = new HashMap();
        hashMap.put((Object)"rewardsTransactionId", (Object)this.bo);
        hashMap.put((Object)"rewardsUserId", (Object)this.bp);
        hashMap.put((Object)"rewardsRewardTypeCurrency", (Object)this.bq);
        hashMap.put((Object)"rewardsAmountRewarded", (Object)this.br);
        hashMap.put((Object)"rewardsCustomParameter", (Object)this.bs);
        return hashMap;
    }

    public void setRewardsAmountRewarded(String string2) {
        this.br = string2;
    }

    public void setRewardsCustomParameter(String string2) {
        this.bs = string2;
    }

    public void setRewardsRewardTypeCurrency(String string2) {
        this.bq = string2;
    }

    public void setRewardsTransactionId(String string2) {
        this.bo = string2;
    }

    public void setRewardsUserId(String string2) {
        this.bp = string2;
    }
}

