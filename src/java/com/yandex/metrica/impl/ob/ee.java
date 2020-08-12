/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.telephony.SubscriptionInfo
 *  java.lang.CharSequence
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 */
package com.yandex.metrica.impl.ob;

import android.telephony.SubscriptionInfo;

public final class ee {
    private final Integer a;
    private final Integer b;
    private final boolean c;
    private final String d;
    private final String e;

    public ee(SubscriptionInfo subscriptionInfo) {
        this.a = subscriptionInfo.getMcc();
        this.b = subscriptionInfo.getMnc();
        int n2 = subscriptionInfo.getDataRoaming();
        int n3 = 1;
        if (n2 != n3) {
            n3 = 0;
        }
        this.c = n3;
        this.d = subscriptionInfo.getCarrierName().toString();
        this.e = subscriptionInfo.getIccId();
    }

    public ee(Integer n2, Integer n3, boolean bl2, String string2, String string3) {
        this.a = n2;
        this.b = n3;
        this.c = bl2;
        this.d = string2;
        this.e = string3;
    }

    public Integer a() {
        return this.a;
    }

    public Integer b() {
        return this.b;
    }

    public boolean c() {
        return this.c;
    }

    public String d() {
        return this.d;
    }

    public String e() {
        return this.e;
    }
}

