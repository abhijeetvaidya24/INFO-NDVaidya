/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.util.HashSet
 *  java.util.Locale
 *  java.util.Set
 */
package com.applovin.sdk;

import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class AppLovinAdType {
    public static final AppLovinAdType INCENTIVIZED;
    public static final AppLovinAdType NATIVE;
    public static final AppLovinAdType REGULAR;
    private final String a;

    static {
        REGULAR = new AppLovinAdType("REGULAR");
        INCENTIVIZED = new AppLovinAdType("VIDEOA");
        NATIVE = new AppLovinAdType("NATIVE");
    }

    public AppLovinAdType(String string2) {
        this.a = string2;
    }

    public static Set<AppLovinAdType> allTypes() {
        HashSet hashSet = new HashSet(2);
        hashSet.add((Object)REGULAR);
        hashSet.add((Object)INCENTIVIZED);
        return hashSet;
    }

    public static AppLovinAdType fromString(String string2) {
        if (string2.toUpperCase(Locale.ENGLISH).equals((Object)INCENTIVIZED.getLabel())) {
            return INCENTIVIZED;
        }
        return REGULAR;
    }

    public boolean equals(Object object) {
        block3 : {
            boolean bl;
            block5 : {
                block6 : {
                    AppLovinAdType appLovinAdType;
                    block4 : {
                        bl = true;
                        if (this == object) {
                            return bl;
                        }
                        if (object == null) break block3;
                        if (this.getClass() != object.getClass()) {
                            return false;
                        }
                        appLovinAdType = (AppLovinAdType)object;
                        String string2 = this.a;
                        if (string2 == null) break block4;
                        if (string2.equals((Object)appLovinAdType.a)) break block5;
                        break block6;
                    }
                    if (appLovinAdType.a == null) {
                        return bl;
                    }
                }
                bl = false;
            }
            return bl;
        }
        return false;
    }

    public String getLabel() {
        return this.a.toUpperCase(Locale.ENGLISH);
    }

    public int hashCode() {
        String string2 = this.a;
        if (string2 != null) {
            return string2.hashCode();
        }
        return 0;
    }

    public String toString() {
        return this.getLabel();
    }
}

