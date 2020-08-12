/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.moat.analytics.mobile.aer.bg
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.reflect.Field
 */
package com.moat.analytics.mobile.aer;

import com.moat.analytics.mobile.aer.base.asserts.a;
import com.moat.analytics.mobile.aer.bg;
import com.moat.analytics.mobile.aer.bh;
import java.lang.reflect.Field;

final class bj {
    final /* synthetic */ bg a;
    private final Field b;

    private bj(bg bg2, Field field) {
        this.a = bg2;
        a.a((Object)field);
        this.b = field;
    }

    /* synthetic */ bj(bg bg2, Field field, bh bh2) {
        this(bg2, field);
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object != null && this.getClass() == object.getClass()) {
            bj bj2 = (bj)object;
            return this.b.equals((Object)bj2.b);
        }
        return false;
    }

    public int hashCode() {
        return this.b.hashCode();
    }
}

