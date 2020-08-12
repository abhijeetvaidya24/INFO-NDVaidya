/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.String
 */
package com.ironsource.sdk.data;

import com.ironsource.sdk.data.SSAObj;

public class AdUnitsReady
extends SSAObj {
    private static String FIRST_CAMPAIGN_CREDITS = "firstCampaignCredits";
    private static String NUM_OF_AD_UNITS = "numOfAdUnits";
    private static String PRODUCT_TYPE = "productType";
    private static String TOTAL_NUMBER_CREDITS = "totalNumberCredits";
    private static String TYPE = "type";
    private String mFirstCampaignCredits;
    private String mNumOfAdUnits;
    private boolean mNumOfAdUnitsExist;
    private String mProductType;
    private String mTotalNumberCredits;
    private String mType;

    public AdUnitsReady(String string) {
        super(string);
        if (this.containsKey(TYPE)) {
            this.setType(this.getString(TYPE));
        }
        if (this.containsKey(NUM_OF_AD_UNITS)) {
            this.setNumOfAdUnits(this.getString(NUM_OF_AD_UNITS));
            this.setNumOfAdUnitsExist(true);
        } else {
            this.setNumOfAdUnitsExist(false);
        }
        if (this.containsKey(FIRST_CAMPAIGN_CREDITS)) {
            this.setFirstCampaignCredits(this.getString(FIRST_CAMPAIGN_CREDITS));
        }
        if (this.containsKey(TOTAL_NUMBER_CREDITS)) {
            this.setTotalNumberCredits(this.getString(TOTAL_NUMBER_CREDITS));
        }
        if (this.containsKey(PRODUCT_TYPE)) {
            this.setProductType(this.getString(PRODUCT_TYPE));
        }
    }

    private void setNumOfAdUnitsExist(boolean bl) {
        this.mNumOfAdUnitsExist = bl;
    }

    public String getNumOfAdUnits() {
        return this.mNumOfAdUnits;
    }

    public String getProductType() {
        return this.mProductType;
    }

    public boolean isNumOfAdUnitsExist() {
        return this.mNumOfAdUnitsExist;
    }

    public void setFirstCampaignCredits(String string) {
        this.mFirstCampaignCredits = string;
    }

    public void setNumOfAdUnits(String string) {
        this.mNumOfAdUnits = string;
    }

    public void setProductType(String string) {
        this.mProductType = string;
    }

    public void setTotalNumberCredits(String string) {
        this.mTotalNumberCredits = string;
    }

    public void setType(String string) {
        this.mType = string;
    }
}

