/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  a.a.a.f
 *  a.a.b.b.h
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 *  org.jetbrains.annotations.NotNull
 */
package a.a.a;

import a.a.a.c;
import a.a.a.f;
import a.a.b.b.h;
import java.util.List;
import org.jetbrains.annotations.NotNull;

class d
extends c {
    @NotNull
    public static final <T> List<T> a(@NotNull T[] arrT) {
        h.b(arrT, (String)"$receiver");
        List list = f.a((Object[])arrT);
        h.a((Object)list, (String)"ArraysUtilJVM.asList(this)");
        return list;
    }
}

