/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Map
 */
package com.tapjoy.internal;

import com.tapjoy.internal.bs;
import com.tapjoy.internal.ce;
import com.tapjoy.internal.fz;
import com.tapjoy.internal.gc;
import java.util.Map;

public abstract class hl
extends ce {
    @Override
    protected Object a(bs bs2) {
        bs2.s();
        return null;
    }

    @Override
    public final String b() {
        return "POST";
    }

    @Override
    public final String d() {
        return "application/json";
    }

    @Override
    public Map e() {
        Map map = super.e();
        gc gc2 = gc.a();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(gc2.m);
        stringBuilder.append("/Android");
        map.put((Object)"sdk_ver", (Object)stringBuilder.toString());
        map.put((Object)"api_key", (Object)gc2.l);
        if (fz.a) {
            map.put((Object)"debug", (Object)true);
        }
        return map;
    }

    @Override
    protected Object f() {
        try {
            Object object = super.f();
            return object;
        }
        catch (Exception exception) {
            new Object[1][0] = this;
            throw exception;
        }
    }
}

