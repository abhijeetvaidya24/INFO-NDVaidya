/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.Collections
 *  java.util.Comparator
 *  java.util.List
 */
package io.presage;

import io.presage.ay;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class az
extends ay {
    public static final <T> void a(List<T> list, Comparator<? super T> comparator) {
        if (list.size() > 1) {
            Collections.sort(list, comparator);
        }
    }
}

