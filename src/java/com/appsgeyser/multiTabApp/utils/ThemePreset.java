/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 *  java.util.HashMap
 *  java.util.Map
 */
package com.appsgeyser.multiTabApp.utils;

import java.util.HashMap;
import java.util.Map;

public final class ThemePreset
extends Enum<ThemePreset> {
    private static final /* synthetic */ ThemePreset[] $VALUES;
    public static final /* enum */ ThemePreset BLACK;
    public static final /* enum */ ThemePreset BLUE;
    public static final /* enum */ ThemePreset BROWN;
    public static final /* enum */ ThemePreset DEFAULT;
    public static final /* enum */ ThemePreset GREEN;
    public static final /* enum */ ThemePreset GREY;
    public static final /* enum */ ThemePreset INDIGO;
    public static final /* enum */ ThemePreset ORANGE;
    public static final /* enum */ ThemePreset PINK;
    public static final /* enum */ ThemePreset PURPLE;
    public static final /* enum */ ThemePreset RED;
    public static final /* enum */ ThemePreset TEAL;
    public static final /* enum */ ThemePreset YELLOW;
    private static final Map<String, ThemePreset> themeMap;
    private static final Map<String, ThemePreset> themeMapNoActionBar;
    public final int themeColorAccentId;
    public final int themeColorPrimaryDarkId;
    public final int themeColorPrimaryId;
    public final int themeId;
    public final String themeName;
    public final int themeNoActionBarId;
    public final String themeNoActionBarName;
    public final int themeTitleId;

    static {
        ThemePreset themePreset;
        ThemePreset themePreset2;
        ThemePreset themePreset3;
        ThemePreset themePreset4;
        ThemePreset themePreset5;
        ThemePreset themePreset6;
        ThemePreset themePreset7;
        ThemePreset themePreset8;
        ThemePreset themePreset9;
        ThemePreset themePreset10;
        ThemePreset themePreset11;
        ThemePreset themePreset12;
        ThemePreset themePreset13;
        DEFAULT = themePreset6 = new ThemePreset(2131820553, 2131820569, "AppThemeDefault", "AppThemeDefaultNoActionBar", 2131755291, 2131034179, 2131034180, 2131034181);
        BLUE = themePreset5 = new ThemePreset(2131820559, 2131820560, "AppThemeBlue", "AppThemeBlueNoActionBar", 2131755289, 2131034156, 2131034157, 2131034158);
        RED = themePreset3 = new ThemePreset(2131820576, 2131820577, "AppThemeRed", "AppThemeRedNoActionBar", 2131755300, 2131034303, 2131034304, 2131034305);
        PINK = themePreset12 = new ThemePreset(2131820572, 2131820573, "AppThemePink", "AppThemePinkNoActionBar", 2131755296, 2131034289, 2131034290, 2131034291);
        PURPLE = themePreset9 = new ThemePreset(2131820574, 2131820575, "AppThemePurple", "AppThemePurpleNoActionBar", 2131755299, 2131034300, 2131034301, 2131034302);
        INDIGO = themePreset4 = new ThemePreset(2131820567, 2131820568, "AppThemeIndigo", "AppThemeIndigoNoActionBar", 2131755294, 2131034234, 2131034235, 2131034236);
        TEAL = themePreset10 = new ThemePreset(2131820578, 2131820579, "AppThemeTeal", "AppThemeTealNoActionBar", 2131755301, 2131034321, 2131034322, 2131034323);
        GREEN = themePreset11 = new ThemePreset(2131820563, 2131820564, "AppThemeGreen", "AppThemeGreenNoActionBar", 2131755292, 2131034223, 2131034224, 2131034225);
        YELLOW = themePreset = new ThemePreset(2131820580, 2131820581, "AppThemeYellow", "AppThemeYellowNoActionBar", 2131755302, 2131034335, 2131034336, 2131034337);
        ORANGE = themePreset8 = new ThemePreset(2131820570, 2131820571, "AppThemeOrange", "AppThemeOrangeNoActionBar", 2131755295, 2131034286, 2131034287, 2131034288);
        BROWN = themePreset7 = new ThemePreset(2131820561, 2131820562, "AppThemeBrown", "AppThemeBrownNoActionBar", 2131755290, 2131034166, 2131034167, 2131034168);
        GREY = themePreset13 = new ThemePreset(2131820565, 2131820566, "AppThemeGrey", "AppThemeGreyNoActionBar", 2131755293, 2131034226, 2131034227, 2131034228);
        BLACK = themePreset2 = new ThemePreset(2131820557, 2131820558, "AppThemeBlack", "AppThemeBlackNoActionBar", 2131755288, 2131034153, 2131034154, 2131034155);
        ThemePreset[] arrthemePreset = new ThemePreset[13];
        ThemePreset themePreset14 = DEFAULT;
        int n2 = 0;
        arrthemePreset[0] = themePreset14;
        arrthemePreset[1] = BLUE;
        arrthemePreset[2] = RED;
        arrthemePreset[3] = PINK;
        arrthemePreset[4] = PURPLE;
        arrthemePreset[5] = INDIGO;
        arrthemePreset[6] = TEAL;
        arrthemePreset[7] = GREEN;
        arrthemePreset[8] = YELLOW;
        arrthemePreset[9] = ORANGE;
        arrthemePreset[10] = BROWN;
        arrthemePreset[11] = GREY;
        arrthemePreset[12] = BLACK;
        $VALUES = arrthemePreset;
        themeMap = new HashMap();
        for (ThemePreset themePreset15 : ThemePreset.values()) {
            themeMap.put((Object)themePreset15.themeName, (Object)themePreset15);
        }
        themeMapNoActionBar = new HashMap();
        ThemePreset[] arrthemePreset2 = ThemePreset.values();
        int n3 = arrthemePreset2.length;
        while (n2 < n3) {
            ThemePreset themePreset16 = arrthemePreset2[n2];
            themeMapNoActionBar.put((Object)themePreset16.themeNoActionBarName, (Object)themePreset16);
            ++n2;
        }
    }

    private ThemePreset(int n3, int n4, String string3, String string4, int n5, int n6, int n7, int n8) {
        this.themeId = n3;
        this.themeNoActionBarId = n4;
        this.themeName = string3;
        this.themeNoActionBarName = string4;
        this.themeTitleId = n5;
        this.themeColorAccentId = n6;
        this.themeColorPrimaryId = n7;
        this.themeColorPrimaryDarkId = n8;
    }

    public static ThemePreset findByName(String string2) {
        return (ThemePreset)((Object)themeMap.get((Object)string2));
    }

    public static ThemePreset findByNoActionBarName(String string2) {
        return (ThemePreset)((Object)themeMapNoActionBar.get((Object)string2));
    }

    public static ThemePreset valueOf(String string2) {
        return (ThemePreset)Enum.valueOf(ThemePreset.class, (String)string2);
    }

    public static ThemePreset[] values() {
        return (ThemePreset[])$VALUES.clone();
    }
}

