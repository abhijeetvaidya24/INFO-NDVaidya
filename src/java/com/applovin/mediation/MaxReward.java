/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.applovin.mediation;

public class MaxReward {
    public static final int DEFAULT_AMOUNT = 0;
    public static final String DEFAULT_LABEL = "";
    private final String a;
    private final int b;

    private MaxReward(int n2, String string2) {
        if (n2 >= 0) {
            this.a = string2;
            this.b = n2;
            return;
        }
        throw new IllegalArgumentException("Reward amount must be greater than or equal to 0");
    }

    public static MaxReward create(int n2, String string2) {
        return new MaxReward(n2, string2);
    }

    public static MaxReward createDefault() {
        return MaxReward.create(0, DEFAULT_LABEL);
    }

    public final int getAmount() {
        return this.b;
    }

    public final String getLabel() {
        return this.a;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("MaxReward{amount='");
        stringBuilder.append(this.b);
        stringBuilder.append('\'');
        stringBuilder.append(", label=");
        stringBuilder.append(this.a);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

