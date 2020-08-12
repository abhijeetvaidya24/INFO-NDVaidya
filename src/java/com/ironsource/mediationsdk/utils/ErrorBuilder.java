/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.ironsource.mediationsdk.utils;

import android.text.TextUtils;
import com.ironsource.mediationsdk.logger.IronSourceError;

public class ErrorBuilder {
    public static IronSourceError buildCappedPerPlacementError(String string, String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append(" Show Fail - ");
        stringBuilder.append(string2);
        return new IronSourceError(524, stringBuilder.toString());
    }

    public static IronSourceError buildGenericError(String string) {
        if (TextUtils.isEmpty((CharSequence)string)) {
            string = "An error occurred";
        }
        return new IronSourceError(510, string);
    }

    public static IronSourceError buildInitFailedError(String string, String string2) {
        String string3;
        if (TextUtils.isEmpty((CharSequence)string)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string2);
            stringBuilder.append(" init failed due to an unknown error");
            string3 = stringBuilder.toString();
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string2);
            stringBuilder.append(" - ");
            stringBuilder.append(string);
            string3 = stringBuilder.toString();
        }
        return new IronSourceError(508, string3);
    }

    public static IronSourceError buildInvalidCredentialsError(String string, String string2, String string3) {
        String string4;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Init Fail - ");
        stringBuilder.append(string);
        stringBuilder.append(" value ");
        stringBuilder.append(string2);
        stringBuilder.append(" is not valid");
        if (!TextUtils.isEmpty((CharSequence)string3)) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(" - ");
            stringBuilder2.append(string3);
            string4 = stringBuilder2.toString();
        } else {
            string4 = "";
        }
        stringBuilder.append(string4);
        return new IronSourceError(506, stringBuilder.toString());
    }

    public static IronSourceError buildInvalidKeyValueError(String string, String string2, String string3) {
        if (!TextUtils.isEmpty((CharSequence)string) && !TextUtils.isEmpty((CharSequence)string2)) {
            String string4;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Mediation - ");
            stringBuilder.append(string);
            stringBuilder.append(" value is not valid for ");
            stringBuilder.append(string2);
            if (!TextUtils.isEmpty((CharSequence)string3)) {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(" - ");
                stringBuilder2.append(string3);
                string4 = stringBuilder2.toString();
            } else {
                string4 = "";
            }
            stringBuilder.append(string4);
            return new IronSourceError(506, stringBuilder.toString());
        }
        return ErrorBuilder.getGenericErrorForMissingParams();
    }

    public static IronSourceError buildLoadFailedError(String string) {
        String string2;
        if (TextUtils.isEmpty((CharSequence)string)) {
            string2 = "Load failed due to an unknown error";
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Load failed - ");
            stringBuilder.append(string);
            string2 = stringBuilder.toString();
        }
        return new IronSourceError(510, string2);
    }

    public static IronSourceError buildNoAdsToShowError(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append(" Show Fail - No ads to show");
        return new IronSourceError(509, stringBuilder.toString());
    }

    public static IronSourceError buildNoInternetConnectionShowFailError(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("");
        stringBuilder.append(string);
        stringBuilder.append(" Show Fail - No Internet connection");
        return new IronSourceError(520, stringBuilder.toString());
    }

    public static IronSourceError buildNonExistentInstanceError(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append(" The requested instance does not exist");
        return new IronSourceError(527, stringBuilder.toString());
    }

    public static IronSourceError buildShowFailedError(String string, String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append(" Show Fail - ");
        stringBuilder.append(string2);
        return new IronSourceError(509, stringBuilder.toString());
    }

    public static IronSourceError buildUsingCachedConfigurationError(String string, String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Mediation - Unable to retrieve configurations from IronSource server, using cached configurations with appKey:");
        stringBuilder.append(string);
        stringBuilder.append(" and userId:");
        stringBuilder.append(string2);
        return new IronSourceError(502, stringBuilder.toString());
    }

    private static IronSourceError getGenericErrorForMissingParams() {
        return ErrorBuilder.buildGenericError("Mediation - wrong configuration");
    }
}

