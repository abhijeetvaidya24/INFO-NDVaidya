/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.HashSet
 *  java.util.List
 *  java.util.Locale
 *  java.util.Set
 */
package com.applovin.sdk;

import com.applovin.impl.sdk.e.d;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public class AppLovinAdSize {
    public static final AppLovinAdSize BANNER = new AppLovinAdSize(-1, 50, "BANNER");
    public static final AppLovinAdSize INTERSTITIAL;
    public static final AppLovinAdSize LEADER;
    public static final AppLovinAdSize MREC;
    public static final AppLovinAdSize NATIVE;
    public static final int SPAN = -1;
    private final int a;
    private final int b;
    private final String c;

    static {
        MREC = new AppLovinAdSize(300, 250, "MREC");
        LEADER = new AppLovinAdSize(-1, 90, "LEADER");
        INTERSTITIAL = new AppLovinAdSize(-1, -1, "INTER");
        NATIVE = new AppLovinAdSize("NATIVE");
    }

    protected AppLovinAdSize(int n2, int n3, String string2) {
        if (n2 < 0 && n2 != -1) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Ad width must be a positive number. Number provided: ");
            stringBuilder.append(n2);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        if (n2 <= 9999) {
            if (n3 < 0 && n3 != -1) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Ad height must be a positive number. Number provided: ");
                stringBuilder.append(n3);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            if (n3 <= 9999) {
                if (string2 != null) {
                    if (string2.length() <= 9) {
                        this.a = n2;
                        this.b = n3;
                        this.c = string2;
                        return;
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Provided label is too long. Label provided: ");
                    stringBuilder.append(string2);
                    throw new IllegalArgumentException(stringBuilder.toString());
                }
                throw new IllegalArgumentException("No label specified");
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Ad height must be less then 9999. Number provided: ");
            stringBuilder.append(n3);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Ad width must be less then 9999. Number provided: ");
        stringBuilder.append(n2);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public AppLovinAdSize(String string2) {
        this(0, 0, string2);
    }

    private static int a(String string2) {
        if ("span".equalsIgnoreCase(string2)) {
            return -1;
        }
        try {
            int n2 = Integer.parseInt((String)string2);
            return n2;
        }
        catch (NumberFormatException numberFormatException) {
            return 0;
        }
    }

    public static Set<AppLovinAdSize> allSizes() {
        HashSet hashSet = new HashSet(4);
        hashSet.add((Object)BANNER);
        hashSet.add((Object)MREC);
        hashSet.add((Object)INTERSTITIAL);
        hashSet.add((Object)LEADER);
        hashSet.add((Object)NATIVE);
        return hashSet;
    }

    public static AppLovinAdSize fromString(String string2) {
        if (string2 != null && string2.length() >= 1) {
            String string3 = string2.toLowerCase(Locale.ENGLISH);
            if (string3.equals((Object)"banner")) {
                return BANNER;
            }
            if (!string3.equals((Object)"interstitial") && !string3.equals((Object)"inter")) {
                if (string3.equals((Object)"mrec")) {
                    return MREC;
                }
                if (string3.equals((Object)"leader")) {
                    return LEADER;
                }
                List<String> list = d.a(string2, "x");
                if (list.size() == 2) {
                    return new AppLovinAdSize(AppLovinAdSize.a((String)list.get(0)), AppLovinAdSize.a((String)list.get(1)), string2);
                }
                return new AppLovinAdSize(0, 0, string2);
            }
            return INTERSTITIAL;
        }
        return null;
    }

    public int getHeight() {
        return this.b;
    }

    public String getLabel() {
        return this.c.toUpperCase(Locale.ENGLISH);
    }

    public int getWidth() {
        return this.a;
    }

    public String toString() {
        return this.getLabel();
    }
}

