/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.telephony.CellInfo
 *  android.telephony.CellSignalStrength
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.yandex.metrica.impl.ob;

import android.telephony.CellInfo;
import android.telephony.CellSignalStrength;

public final class dz {
    private Integer a;
    private final Integer b;
    private final Integer c;
    private final Integer d;
    private final Integer e;
    private final String f;
    private final String g;
    private final boolean h;
    private final int i;
    private final Integer j;

    public dz(Integer n2, Integer n3, Integer n4, Integer n5, String string2, String string3, Integer n6, boolean bl2, int n7, Integer n8) {
        this.b = n2;
        this.c = n3;
        this.d = n4;
        this.e = n5;
        this.f = string2;
        this.g = string3;
        this.a = n6;
        this.h = bl2;
        this.i = n7;
        this.j = n8;
    }

    public Integer a() {
        return this.a;
    }

    public void a(Integer n2) {
        this.a = n2;
    }

    public Integer b() {
        return this.b;
    }

    public Integer c() {
        return this.c;
    }

    public Integer d() {
        return this.d;
    }

    public Integer e() {
        return this.e;
    }

    public String f() {
        return this.f;
    }

    public String g() {
        return this.g;
    }

    public boolean h() {
        return this.h;
    }

    public int i() {
        return this.i;
    }

    public Integer j() {
        return this.j;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("CellDescription{mSignalStrength=");
        stringBuilder.append((Object)this.a);
        stringBuilder.append(", mMobileCountryCode=");
        stringBuilder.append((Object)this.b);
        stringBuilder.append(", mMobileNetworkCode=");
        stringBuilder.append((Object)this.c);
        stringBuilder.append(", mLocationAreaCode=");
        stringBuilder.append((Object)this.d);
        stringBuilder.append(", mCellId=");
        stringBuilder.append((Object)this.e);
        stringBuilder.append(", mOperatorName='");
        stringBuilder.append(this.f);
        stringBuilder.append('\'');
        stringBuilder.append(", mNetworkType='");
        stringBuilder.append(this.g);
        stringBuilder.append('\'');
        stringBuilder.append(", mConnected=");
        stringBuilder.append(this.h);
        stringBuilder.append(", mCellType=");
        stringBuilder.append(this.i);
        stringBuilder.append(", mPci=");
        stringBuilder.append((Object)this.j);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    static abstract class b {
        static final Integer a;
        static final Integer b;
        static final Integer c;
        static final Integer d;
        static final Integer e;

        static {
            Integer n2;
            a = n2 = Integer.valueOf((int)Integer.MAX_VALUE);
            b = n2;
            c = n2;
            d = n2;
            e = n2;
        }

        b() {
        }

        abstract dz a(CellInfo var1);

        protected dz a(Integer n2, Integer n3, CellSignalStrength cellSignalStrength, Integer n4, Integer n5, boolean bl2, int n6, Integer n7) {
            Integer n8;
            Integer n9;
            Integer n10;
            Integer n11;
            Integer n12 = n2;
            Integer n13 = n3;
            Integer n14 = n4;
            Integer n15 = n5;
            if (n12 != null) {
                if (n12 == a) {
                    n12 = null;
                }
                n10 = n12;
            } else {
                n10 = null;
            }
            if (n13 != null) {
                if (n13 == b) {
                    n13 = null;
                }
                n8 = n13;
            } else {
                n8 = null;
            }
            Integer n16 = cellSignalStrength != null ? Integer.valueOf((int)cellSignalStrength.getDbm()) : null;
            if (n15 != null) {
                if (n15 == c) {
                    n15 = null;
                }
                n11 = n15;
            } else {
                n11 = null;
            }
            if (n14 != null) {
                if (n14 == d) {
                    n14 = null;
                }
                n9 = n14;
            } else {
                n9 = null;
            }
            Integer n17 = n7 != null && n7 != e ? n7 : null;
            dz dz2 = new dz(n11, n9, n8, n10, null, null, n16, bl2, n6, n17);
            return dz2;
        }
    }

}

