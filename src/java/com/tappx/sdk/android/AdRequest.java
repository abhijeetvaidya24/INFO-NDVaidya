/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package com.tappx.sdk.android;

public final class AdRequest {
    private String a = "native";
    private String b = null;
    private String c = null;
    private int d = -1;
    private int e = -1;
    private Gender f = Gender.UNKNOWN;
    private MaritalStatus g = MaritalStatus.UNKNOWN;
    private boolean h;

    public AdRequest age(int n2) {
        this.e = n2;
        return this;
    }

    public AdRequest gender(Gender gender) {
        this.f = gender;
        return this;
    }

    public int getAge() {
        return this.e;
    }

    public Gender getGender() {
        return this.f;
    }

    public String getKeywords() {
        return this.c;
    }

    public MaritalStatus getMaritalStatus() {
        return this.g;
    }

    public String getMediator() {
        return this.b;
    }

    public String getSdkType() {
        return this.a;
    }

    public int getYearOfBirth() {
        return this.d;
    }

    public boolean isUseTestAds() {
        return this.h;
    }

    public AdRequest keywords(String string2) {
        this.c = string2;
        return this;
    }

    public AdRequest maritalStatus(MaritalStatus maritalStatus) {
        this.g = maritalStatus;
        return this;
    }

    public AdRequest mediator(String string2) {
        this.b = string2;
        return this;
    }

    public AdRequest sdkType(String string2) {
        this.a = string2;
        return this;
    }

    public AdRequest useTestAds(boolean bl) {
        this.h = bl;
        return this;
    }

    public AdRequest yearOfBirth(int n2) {
        this.d = n2;
        return this;
    }

    public static final class Gender
    extends Enum<Gender> {
        public static final /* enum */ Gender FEMALE;
        public static final /* enum */ Gender MALE;
        public static final /* enum */ Gender OTHER;
        public static final /* enum */ Gender UNKNOWN;
        private static final /* synthetic */ Gender[] a;

        static {
            MALE = new Gender();
            FEMALE = new Gender();
            OTHER = new Gender();
            UNKNOWN = new Gender();
            Gender[] arrgender = new Gender[]{MALE, FEMALE, OTHER, UNKNOWN};
            a = arrgender;
        }

        public static Gender valueOf(String string2) {
            return (Gender)Enum.valueOf(Gender.class, (String)string2);
        }

        public static Gender[] values() {
            return (Gender[])a.clone();
        }
    }

    public static final class MaritalStatus
    extends Enum<MaritalStatus> {
        public static final /* enum */ MaritalStatus DIVORCED;
        public static final /* enum */ MaritalStatus LIVING_COMMON;
        public static final /* enum */ MaritalStatus MARRIED;
        public static final /* enum */ MaritalStatus SINGLE;
        public static final /* enum */ MaritalStatus UNKNOWN;
        public static final /* enum */ MaritalStatus WIDOWED;
        private static final /* synthetic */ MaritalStatus[] a;

        static {
            SINGLE = new MaritalStatus();
            LIVING_COMMON = new MaritalStatus();
            MARRIED = new MaritalStatus();
            DIVORCED = new MaritalStatus();
            WIDOWED = new MaritalStatus();
            UNKNOWN = new MaritalStatus();
            MaritalStatus[] arrmaritalStatus = new MaritalStatus[]{SINGLE, LIVING_COMMON, MARRIED, DIVORCED, WIDOWED, UNKNOWN};
            a = arrmaritalStatus;
        }

        public static MaritalStatus valueOf(String string2) {
            return (MaritalStatus)Enum.valueOf(MaritalStatus.class, (String)string2);
        }

        public static MaritalStatus[] values() {
            return (MaritalStatus[])a.clone();
        }
    }

}

