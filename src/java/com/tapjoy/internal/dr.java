/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.Serializable
 *  java.lang.Object
 *  java.util.AbstractList
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.List
 *  java.util.RandomAccess
 */
package com.tapjoy.internal;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

final class dr
extends AbstractList
implements Serializable,
RandomAccess {
    private final ArrayList a;

    dr(List list) {
        this.a = new ArrayList((Collection)list);
    }

    public final Object get(int n2) {
        return this.a.get(n2);
    }

    public final int size() {
        return this.a.size();
    }

    public final Object[] toArray() {
        return this.a.toArray();
    }
}

