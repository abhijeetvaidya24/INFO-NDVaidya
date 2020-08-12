/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.preference.PreferenceManager
 *  android.util.TypedValue
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.appsgeyser.multiTabApp.utils;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.preference.PreferenceManager;
import android.util.TypedValue;
import com.appsgeyser.multiTabApp.configuration.WebWidgetConfiguration;
import com.appsgeyser.multiTabApp.utils.ThemePreset;

public class ThemeUtils {
    public static String getActivityThemeName(Context context) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(2130903564, typedValue, true);
        return typedValue.string.toString();
    }

    public static void initializeAppTheme(Activity activity, WebWidgetConfiguration webWidgetConfiguration) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences((Context)activity);
        if (webWidgetConfiguration.getApplicationTheme() == WebWidgetConfiguration.ApplicationThemes.ACTION_BAR) {
            String string2 = sharedPreferences.getString("AppThemeName", "AppThemeDefaultNoActionBar");
            if (string2.equals((Object)"AppThemeDefaultNoActionBar")) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("AppThemeName", "AppThemeDefaultNoActionBar");
                editor.apply();
            }
            if (!ThemeUtils.getActivityThemeName((Context)activity).equals((Object)string2)) {
                activity.setTheme(ThemePreset.findByNoActionBarName((String)string2).themeNoActionBarId);
            }
        }
    }

    public static void setCurrentThemeWithActionBar(Activity activity) {
        String string2 = PreferenceManager.getDefaultSharedPreferences((Context)activity).getString("AppThemeName", "AppThemeDefault");
        if (string2.contains((CharSequence)"NoActionBar")) {
            string2 = string2.replace((CharSequence)"NoActionBar", (CharSequence)"");
        }
        activity.setTheme(ThemePreset.findByName((String)string2).themeId);
    }

    public static void setCurrentThemeWithNoActionBar(Activity activity) {
        String string2 = PreferenceManager.getDefaultSharedPreferences((Context)activity).getString("AppThemeName", "AppThemeDefaultNoActionBar");
        if (!string2.contains((CharSequence)"NoActionBar")) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string2);
            stringBuilder.append("NoActionBar");
            string2 = stringBuilder.toString();
        }
        activity.setTheme(ThemePreset.findByNoActionBarName((String)string2).themeNoActionBarId);
    }
}

