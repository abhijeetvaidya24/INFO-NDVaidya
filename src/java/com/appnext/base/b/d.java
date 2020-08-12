/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package com.appnext.base.b;

public final class d {
    public static final String eS = "service_key";
    public static final String eT = "4.7.2";
    public static final String eU = "config.json";
    public static final String eV = "plist.json";
    public static final String eW = "/data/appnext/";
    public static final String eX = "videos/";
    public static final String eY = ".tmp";
    public static final String eZ = "http://cdn.appnext.com/tools/services/4.7.2/config.json";
    public static final String fa = "http://cdn.appnext.com/tools/services/4.7.2/plist.json";
    public static final int fb = 1024;
    public static final long fc = 0x100000L;
    public static final int fd = 15000;
    public static final String fe = "config_data_obj";
    public static final String ff = "second";
    public static final String fg = "minute";
    public static final String fh = "hour";
    public static final String fi = "day";
    public static final String fj = "time";
    public static final String fk = "once";
    public static final String fl = "interval";
    public static final String fm = "off";
    public static final String fn = "isAidDisabled";
    public static final String fo = "aidForSend";

    public static final String aL() {
        return "http://apis.appnxt.net:443";
    }

    public static final String aM() {
        return "https://api.appnxt.net";
    }

    public static final class a
    extends Enum<a> {
        private static final /* synthetic */ a[] $VALUES;
        public static final /* enum */ a ArrayList;
        public static final /* enum */ a Boolean;
        public static final /* enum */ a Double;
        public static final /* enum */ a HashMap;
        public static final /* enum */ a Integer;
        public static final /* enum */ a JSONArray;
        public static final /* enum */ a JSONObject;
        public static final /* enum */ a Long;
        public static final /* enum */ a Set;
        public static final /* enum */ a String;
        private String mDataType;

        static {
            String = new a("String");
            Long = new a("Long");
            Double = new a("Double");
            Integer = new a("Integer");
            HashMap = new a("HashMap");
            ArrayList = new a("ArrayList");
            Boolean = new a("Boolean");
            JSONArray = new a("JSONArray");
            JSONObject = new a("JSONObject");
            Set = new a("Set");
            a[] arra = new a[]{String, Long, Double, Integer, HashMap, ArrayList, Boolean, JSONArray, JSONObject, Set};
            $VALUES = arra;
        }

        private a(String string3) {
            this.mDataType = string3;
        }

        public static a valueOf(String string2) {
            return (a)Enum.valueOf(a.class, (String)string2);
        }

        public static a[] values() {
            return (a[])$VALUES.clone();
        }

        public final String getType() {
            return this.mDataType;
        }
    }

}

