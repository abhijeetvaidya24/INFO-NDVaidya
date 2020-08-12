/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.regex.Matcher
 *  java.util.regex.Pattern
 */
package com.aerserv.sdk.utils;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtils {
    public static ArrayList<String> findStringWithPattern(String string, String string2) {
        ArrayList arrayList = new ArrayList();
        Matcher matcher = Pattern.compile((String)string2).matcher((CharSequence)string);
        while (matcher.find()) {
            arrayList.add((Object)matcher.group());
        }
        return arrayList;
    }
}

