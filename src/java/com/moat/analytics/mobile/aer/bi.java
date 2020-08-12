/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.moat.analytics.mobile.aer.bg
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.System
 *  java.lang.reflect.Field
 */
package com.moat.analytics.mobile.aer;

import com.moat.analytics.mobile.aer.bg;
import java.lang.reflect.Field;

class bi {
    final Field[] a;
    final Object b;
    final /* synthetic */ bg c;

    bi(bg bg2, Field[] arrfield, Object object) {
        this.c = bg2;
        this.a = arrfield;
        this.b = object;
    }

    bi(bg bg2, Field[] arrfield, Field field, Object object) {
        this.c = bg2;
        Field[] arrfield2 = new Field[1 + arrfield.length];
        System.arraycopy((Object)arrfield, (int)0, (Object)arrfield2, (int)0, (int)arrfield.length);
        arrfield2[arrfield.length] = field;
        this.a = arrfield2;
        this.b = object;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object != null && this.getClass() == object.getClass()) {
            bi bi2 = (bi)object;
            return this.b.equals(bi2.b);
        }
        return false;
    }

    public int hashCode() {
        return this.b.hashCode();
    }
}

