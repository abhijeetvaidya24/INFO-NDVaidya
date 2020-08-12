/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.Collections
 *  java.util.List
 */
package io.presage;

import io.presage.cl;
import java.util.Collections;
import java.util.List;

class au {
    public static final <T> List<T> a(T t2) {
        List list = Collections.singletonList(t2);
        cl.a((Object)list, "java.util.Collections.singletonList(element)");
        return list;
    }
}

