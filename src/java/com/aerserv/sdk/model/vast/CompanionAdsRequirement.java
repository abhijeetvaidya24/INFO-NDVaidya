/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 *  java.util.EnumSet
 *  java.util.HashMap
 */
package com.aerserv.sdk.model.vast;

import java.util.EnumSet;
import java.util.HashMap;

public final class CompanionAdsRequirement
extends Enum<CompanionAdsRequirement> {
    private static final /* synthetic */ CompanionAdsRequirement[] $VALUES;
    public static final /* enum */ CompanionAdsRequirement ALL = new CompanionAdsRequirement("all");
    public static final /* enum */ CompanionAdsRequirement ANY = new CompanionAdsRequirement("any");
    public static final /* enum */ CompanionAdsRequirement NONE = new CompanionAdsRequirement("none");
    private static HashMap<String, CompanionAdsRequirement> requirementValueHashMap;
    private String requirementValue;

    static {
        CompanionAdsRequirement[] arrcompanionAdsRequirement = new CompanionAdsRequirement[]{ALL, ANY, NONE};
        $VALUES = arrcompanionAdsRequirement;
        requirementValueHashMap = new HashMap();
        for (CompanionAdsRequirement companionAdsRequirement : EnumSet.allOf(CompanionAdsRequirement.class)) {
            requirementValueHashMap.put((Object)companionAdsRequirement.requirementValue, (Object)companionAdsRequirement);
        }
    }

    private CompanionAdsRequirement(String string2) {
        this.requirementValue = string2;
    }

    public static CompanionAdsRequirement get(String string) {
        return (CompanionAdsRequirement)((Object)requirementValueHashMap.get((Object)string));
    }

    public static CompanionAdsRequirement valueOf(String string) {
        return (CompanionAdsRequirement)Enum.valueOf(CompanionAdsRequirement.class, (String)string);
    }

    public static CompanionAdsRequirement[] values() {
        return (CompanionAdsRequirement[])$VALUES.clone();
    }

    public String getRequirementValue() {
        return this.requirementValue;
    }
}

