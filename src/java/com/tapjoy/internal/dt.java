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

final class dt
extends AbstractList
implements Serializable,
RandomAccess {
    List a;
    private final List b;

    dt(List list) {
        this.b = list;
        this.a = list;
    }

    public final void add(int n2, Object object) {
        List list = this.a;
        List list2 = this.b;
        if (list == list2) {
            this.a = new ArrayList((Collection)list2);
        }
        this.a.add(n2, object);
    }

    public final Object get(int n2) {
        return this.a.get(n2);
    }

    public final Object remove(int n2) {
        List list = this.a;
        List list2 = this.b;
        if (list == list2) {
            this.a = new ArrayList((Collection)list2);
        }
        return this.a.remove(n2);
    }

    public final Object set(int n2, Object object) {
        List list = this.a;
        List list2 = this.b;
        if (list == list2) {
            this.a = new ArrayList((Collection)list2);
        }
        return this.a.set(n2, object);
    }

    public final int size() {
        return this.a.size();
    }
}

