/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.Collections
 *  java.util.List
 *  org.jetbrains.annotations.NotNull
 */
package a.a.a;

import java.util.Collections;
import java.util.List;
import org.jetbrains.annotations.NotNull;

class h {
    @NotNull
    public static final <T> List<T> a(T t2) {
        List list = Collections.singletonList(t2);
        a.a.b.b.h.a((Object)list, "java.util.Collections.singletonList(element)");
        return list;
    }
}

