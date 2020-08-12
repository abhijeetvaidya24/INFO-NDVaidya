/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.Serializable
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.math.BigDecimal
 *  org.json.JSONObject
 */
package com.aerserv.sdk;

import com.aerserv.sdk.utils.AerServLog;
import java.io.Serializable;
import java.math.BigDecimal;
import org.json.JSONObject;

public class AerServTransactionInformation
implements Serializable {
    private static final String LOG_TAG = "AerServTransactionInformation";
    private String buyerName = "";
    private BigDecimal buyerPrice = null;

    public String getBuyerName() {
        return this.buyerName;
    }

    public BigDecimal getBuyerPrice() {
        return this.buyerPrice;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("AerServTransactionInformation(buyerName: \"");
        stringBuilder.append(this.buyerName);
        stringBuilder.append("\", buyerPrice: ");
        stringBuilder.append((Object)this.buyerPrice);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void updateInformation(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.buyerName = jSONObject.optString("buyerName");
        try {
            this.buyerPrice = new BigDecimal(jSONObject.optString("buyerPrice"));
            return;
        }
        catch (NumberFormatException numberFormatException) {
            String string = LOG_TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Error reading buyerPrice: ");
            stringBuilder.append(numberFormatException.getMessage());
            stringBuilder.append(".  Setting buyerPrice to null.");
            AerServLog.w(string, stringBuilder.toString());
            this.buyerPrice = null;
            return;
        }
    }
}

