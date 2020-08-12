/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.tappx.sdk.android.AdRequest
 *  com.tappx.sdk.android.AdRequest$Gender
 *  com.tappx.sdk.android.AdRequest$MaritalStatus
 *  java.lang.NoSuchFieldError
 *  java.lang.Object
 *  java.lang.String
 */
package com.tappx.a.a.a.d;

import com.tappx.a.a.a.e.c;
import com.tappx.a.a.a.e.i;
import com.tappx.sdk.android.AdRequest;

public class a {
    private static final String a = "M";
    private static final String b = "F";
    private static final String c = "O";
    private static final String d;
    private static final String e = "S";
    private static final String f = "L";
    private static final String g = "M";
    private static final String h = "D";
    private static final String i = "W";
    private static final String j;

    private String a(AdRequest.Gender gender) {
        if (gender == null) {
            return null;
        }
        int n2 = 1.a[gender.ordinal()];
        if (n2 != 1) {
            if (n2 != 2) {
                if (n2 != 3) {
                    return d;
                }
                return c;
            }
            return b;
        }
        return "M";
    }

    private String a(AdRequest.MaritalStatus maritalStatus) {
        if (maritalStatus == null) {
            return null;
        }
        int n2 = 1.b[maritalStatus.ordinal()];
        if (n2 != 1) {
            if (n2 != 2) {
                if (n2 != 3) {
                    if (n2 != 4) {
                        if (n2 != 5) {
                            return j;
                        }
                        return i;
                    }
                    return h;
                }
                return "M";
            }
            return f;
        }
        return e;
    }

    public i a(String string2, c c2, String string3, AdRequest adRequest) {
        i i2 = new i();
        i2.a(string3);
        i2.b(c2.a());
        i2.c(string2);
        i2.h(adRequest.getSdkType());
        i2.g(adRequest.getMediator());
        i2.f(adRequest.getKeywords());
        i2.b(adRequest.getYearOfBirth());
        i2.a(adRequest.getAge());
        i2.d(this.a(adRequest.getGender()));
        i2.e(this.a(adRequest.getMaritalStatus()));
        i2.a(adRequest.isUseTestAds());
        return i2;
    }

}

