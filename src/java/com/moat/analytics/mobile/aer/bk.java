/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.moat.analytics.mobile.aer.bg
 *  java.lang.Class
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.reflect.Field
 *  java.util.Arrays
 *  java.util.Iterator
 *  java.util.List
 */
package com.moat.analytics.mobile.aer;

import com.moat.analytics.mobile.aer.bg;
import com.moat.analytics.mobile.aer.bh;
import com.moat.analytics.mobile.aer.bj;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

final class bk<T> {
    final /* synthetic */ bg a;
    private final List<Field> b;

    private bk(Class<T> class_, Field[] arrfield) {
        this.a = var1_1;
        if (arrfield.length != 0) {
            if (class_.isAssignableFrom(arrfield[-1 + arrfield.length].getType())) {
                this.b = Arrays.asList((Object[])arrfield);
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Last field must be of type ");
            stringBuilder.append(class_.getSimpleName());
            stringBuilder.append(".");
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        throw new IllegalArgumentException("Must have at least one field in the chain.");
    }

    /* synthetic */ bk(bg bg2, Class class_, Field[] arrfield, bh bh2) {
        this(bg2, class_, arrfield);
    }

    public Object a(Object object) {
        Field field;
        Iterator iterator = this.b.iterator();
        while (iterator.hasNext() && (object = bg.a((bg)this.a, (Object)object, (Field)(field = (Field)iterator.next()))) != null && !(object instanceof bj)) {
        }
        return object;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object != null && this.getClass() == object.getClass()) {
            bk bk2 = (bk)object;
            return this.b.equals(bk2.b);
        }
        return false;
    }

    public int hashCode() {
        return this.b.hashCode();
    }
}

