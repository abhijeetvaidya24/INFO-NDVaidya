/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Arrays
 *  java.util.HashMap
 *  java.util.Map
 */
package com.startapp.android.publish.adsCommon.g.d;

import com.startapp.common.a.g;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class b {
    public static Map<String, String> a(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("parseCommandUrl ");
        stringBuilder.append(string);
        g.a("MraidParser", 3, stringBuilder.toString());
        String string2 = string.substring(8);
        HashMap hashMap = new HashMap();
        int n2 = string2.indexOf(63);
        if (n2 != -1) {
            String string3 = string2.substring(0, n2);
            for (String string4 : string2.substring(n2 + 1).split("&")) {
                int n3 = string4.indexOf(61);
                hashMap.put((Object)string4.substring(0, n3), (Object)string4.substring(n3 + 1));
            }
            string2 = string3;
        }
        if (!b.b(string2)) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("command ");
            stringBuilder2.append(string2);
            stringBuilder2.append(" is unknown");
            g.a(5, stringBuilder2.toString());
            return null;
        }
        if (!b.a(string2, (Map<String, String>)hashMap)) {
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append("command URL ");
            stringBuilder3.append(string);
            stringBuilder3.append(" is missing parameters");
            g.a(5, stringBuilder3.toString());
            return null;
        }
        HashMap hashMap2 = new HashMap();
        hashMap2.put((Object)"command", (Object)string2);
        hashMap2.putAll((Map)hashMap);
        return hashMap2;
    }

    private static boolean a(String string, Map<String, String> map) {
        if (string.equals((Object)"createCalendarEvent")) {
            return map.containsKey((Object)"eventJSON");
        }
        if (!(string.equals((Object)"open") || string.equals((Object)"playVideo") || string.equals((Object)"storePicture"))) {
            if (string.equals((Object)"setOrientationProperties")) {
                boolean bl = map.containsKey((Object)"allowOrientationChange");
                boolean bl2 = false;
                if (bl) {
                    boolean bl3 = map.containsKey((Object)"forceOrientation");
                    bl2 = false;
                    if (bl3) {
                        bl2 = true;
                    }
                }
                return bl2;
            }
            if (string.equals((Object)"setResizeProperties")) {
                boolean bl = map.containsKey((Object)"width");
                boolean bl4 = false;
                if (bl) {
                    boolean bl5 = map.containsKey((Object)"height");
                    bl4 = false;
                    if (bl5) {
                        boolean bl6 = map.containsKey((Object)"offsetX");
                        bl4 = false;
                        if (bl6) {
                            boolean bl7 = map.containsKey((Object)"offsetY");
                            bl4 = false;
                            if (bl7) {
                                boolean bl8 = map.containsKey((Object)"customClosePosition");
                                bl4 = false;
                                if (bl8) {
                                    boolean bl9 = map.containsKey((Object)"allowOffscreen");
                                    bl4 = false;
                                    if (bl9) {
                                        bl4 = true;
                                    }
                                }
                            }
                        }
                    }
                }
                return bl4;
            }
            if (string.equals((Object)"useCustomClose")) {
                return map.containsKey((Object)"useCustomClose");
            }
            return true;
        }
        return map.containsKey((Object)"url");
    }

    public static boolean b(String string) {
        return Arrays.asList((Object[])new String[]{"close", "createCalendarEvent", "expand", "open", "playVideo", "resize", "setOrientationProperties", "setResizeProperties", "storePicture", "useCustomClose"}).contains((Object)string);
    }
}

