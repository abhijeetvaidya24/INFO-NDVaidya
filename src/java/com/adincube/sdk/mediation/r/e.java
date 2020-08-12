/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.adincube.sdk.h.b
 *  com.adincube.sdk.h.c
 *  com.adincube.sdk.h.g
 *  java.lang.Integer
 *  java.lang.NoSuchFieldError
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.HashMap
 *  java.util.Map$Entry
 *  java.util.Set
 */
package com.adincube.sdk.mediation.r;

import com.adincube.sdk.h.b;
import com.adincube.sdk.h.c;
import com.adincube.sdk.h.g;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public final class e {
    g a;
    private String b = null;

    public final String a() {
        HashMap hashMap;
        block8 : {
            String string;
            block10 : {
                block9 : {
                    g g2;
                    block5 : {
                        String string2;
                        block7 : {
                            block6 : {
                                g2 = this.a;
                                if (g2 == null) {
                                    return null;
                                }
                                hashMap = new HashMap();
                                if (g2.d != null) {
                                    hashMap.put((Object)"m_age", (Object)g2.d.toString());
                                }
                                if (g2.a == null) break block5;
                                int n2 = 1.a[g2.a.ordinal()];
                                if (n2 == 1) break block6;
                                if (n2 != 2) break block5;
                                string2 = "f";
                                break block7;
                            }
                            string2 = "m";
                        }
                        hashMap.put((Object)"m_gender", (Object)string2);
                    }
                    if (g2.b == null) break block8;
                    int n3 = 1.b[g2.b.ordinal()];
                    if (n3 == 1) break block9;
                    if (n3 != 2) break block8;
                    string = "married";
                    break block10;
                }
                string = "single";
            }
            hashMap.put((Object)"m_marital", (Object)string);
        }
        if (hashMap.isEmpty()) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry entry : hashMap.entrySet()) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append(";");
            }
            Object[] arrobject = new Object[]{entry.getKey(), entry.getValue()};
            stringBuilder.append(String.format((String)"%s:%s", (Object[])arrobject));
        }
        return stringBuilder.toString();
    }

}

