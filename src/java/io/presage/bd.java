/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.List
 *  java.util.NoSuchElementException
 */
package io.presage;

import io.presage.at;
import io.presage.bc;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;

public class bd
extends bc {
    public static final <T> List<T> a(Collection<? extends T> collection) {
        return (List)new ArrayList(collection);
    }

    public static final <T> T b(List<? extends T> list) {
        if (!list.isEmpty()) {
            return (T)list.get(0);
        }
        throw (Throwable)new NoSuchElementException("List is empty.");
    }

    public static final <T> T c(List<? extends T> list) {
        if (list.isEmpty()) {
            return null;
        }
        return (T)list.get(0);
    }

    public static final <T> T d(List<? extends T> list) {
        if (!list.isEmpty()) {
            return (T)list.get(at.a(list));
        }
        throw (Throwable)new NoSuchElementException("List is empty.");
    }
}

