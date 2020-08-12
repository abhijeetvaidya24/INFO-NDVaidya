/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.util.HashMap
 *  java.util.Map
 */
package com.yandex.metrica.impl.ob;

import com.yandex.metrica.impl.utils.g;
import java.util.HashMap;
import java.util.Map;

public class dt {
    private final Map<String, Integer> a = new HashMap();

    public String a() {
        return g.a(this.a);
    }

    public void a(String string2, int n2) {
        this.a.put((Object)string2, (Object)n2);
    }
}

