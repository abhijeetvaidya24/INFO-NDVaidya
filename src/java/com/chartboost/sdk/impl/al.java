/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.File
 *  java.lang.Object
 *  java.lang.String
 *  java.util.HashMap
 *  java.util.Map
 */
package com.chartboost.sdk.impl;

import com.chartboost.sdk.Libraries.f;
import com.chartboost.sdk.Libraries.g;
import com.chartboost.sdk.Libraries.h;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class al {
    private final f a;
    private final Map<String, h.a> b;

    public al(f f2) {
        this.a = f2;
        this.b = new HashMap();
    }

    private boolean b(String string) {
        return this.a.b(String.format((String)"%s%s", (Object[])new Object[]{string, ".png"}));
    }

    public h.a a(String string) {
        if (this.b(string)) {
            if (this.b.containsKey((Object)string)) {
                return (h.a)this.b.get((Object)string);
            }
            h.a a2 = new h.a(string, new File(this.a.d().d, String.format((String)"%s%s", (Object[])new Object[]{string, ".png"})), this.a);
            this.b.put((Object)string, (Object)a2);
            return a2;
        }
        if (this.b.containsKey((Object)string)) {
            this.b.remove((Object)string);
        }
        return null;
    }
}

