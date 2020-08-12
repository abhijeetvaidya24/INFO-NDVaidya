/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.util.regex.Matcher
 *  java.util.regex.Pattern
 */
package com.tappx.a.a.b;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class af {
    static String a = "<script\\s+[^>]*\\bsrc\\s*=\\s*([\\\"\\'])mraid\\.js\\1[^>]*>\\s*</script>\\n*";
    static String b = "<script src=\"mraid.js\"></script>";

    public static boolean a(String string2) {
        return Pattern.compile((String)a, (int)2).matcher((CharSequence)string2).find();
    }
}

