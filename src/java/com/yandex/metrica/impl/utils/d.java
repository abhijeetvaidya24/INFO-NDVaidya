/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.Collection
 *  java.util.HashSet
 *  java.util.Iterator
 */
package com.yandex.metrica.impl.utils;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class d {
    public static boolean a(Collection<?> collection, Collection<?> collection2) {
        if (collection == null && collection2 == null) {
            return true;
        }
        if (collection != null) {
            if (collection2 == null) {
                return false;
            }
            if (collection.size() == collection2.size()) {
                HashSet hashSet;
                if (collection instanceof HashSet) {
                    hashSet = (HashSet)collection;
                } else if (collection2 instanceof HashSet) {
                    HashSet hashSet2 = (HashSet)collection2;
                    collection2 = collection;
                    hashSet = hashSet2;
                } else {
                    hashSet = new HashSet(collection);
                }
                Iterator iterator = collection2.iterator();
                while (iterator.hasNext()) {
                    if (hashSet.contains(iterator.next())) continue;
                    return false;
                }
                return true;
            }
        }
        return false;
    }
}

