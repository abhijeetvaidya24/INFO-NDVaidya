/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Map
 */
package com.applovin.impl.sdk;

import java.util.Map;

public class l {
    private final String a;
    private final Map<String, String> b;
    private final long c;
    private final String d;

    public l(String string2, Map<String, String> map, long l2, String string3) {
        this.a = string2;
        this.b = map;
        this.c = l2;
        this.d = string3;
    }

    public String a() {
        return this.a;
    }

    public Map<String, String> b() {
        return this.b;
    }

    public long c() {
        return this.c;
    }

    public boolean equals(Object object) {
        block6 : {
            boolean bl;
            block8 : {
                block9 : {
                    l l2;
                    block7 : {
                        bl = true;
                        if (this == object) {
                            return bl;
                        }
                        if (object == null) break block6;
                        if (this.getClass() != object.getClass()) {
                            return false;
                        }
                        l2 = (l)object;
                        if (this.c != l2.c) {
                            return false;
                        }
                        String string2 = this.a;
                        if (string2 != null ? !string2.equals((Object)l2.a) : l2.a != null) {
                            return false;
                        }
                        Map<String, String> map = this.b;
                        if (map != null ? !map.equals(l2.b) : l2.b != null) {
                            return false;
                        }
                        String string3 = this.d;
                        if (string3 == null) break block7;
                        if (string3.equals((Object)l2.d)) break block8;
                        break block9;
                    }
                    if (l2.d == null) {
                        return bl;
                    }
                }
                bl = false;
            }
            return bl;
        }
        return false;
    }

    public int hashCode() {
        String string2 = this.a;
        int n2 = string2 != null ? string2.hashCode() : 0;
        int n3 = n2 * 31;
        Map<String, String> map = this.b;
        int n4 = map != null ? map.hashCode() : 0;
        int n5 = 31 * (n3 + n4);
        long l2 = this.c;
        int n6 = 31 * (n5 + (int)(l2 ^ l2 >>> 32));
        String string3 = this.d;
        int n7 = 0;
        if (string3 != null) {
            n7 = string3.hashCode();
        }
        return n6 + n7;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Event{eventType='");
        stringBuilder.append(this.a);
        stringBuilder.append('\'');
        stringBuilder.append(", parameters=");
        stringBuilder.append(this.b);
        stringBuilder.append(", creationTsMillis=");
        stringBuilder.append(this.c);
        stringBuilder.append(", uniqueIdentifier='");
        stringBuilder.append(this.d);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

