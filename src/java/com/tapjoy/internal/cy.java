/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.HashSet
 *  java.util.Iterator
 */
package com.tapjoy.internal;

import java.util.HashSet;
import java.util.Iterator;

public final class cy {
    public static HashSet a(Iterator iterator) {
        HashSet hashSet = new HashSet();
        while (iterator.hasNext()) {
            hashSet.add(iterator.next());
        }
        return hashSet;
    }
}

