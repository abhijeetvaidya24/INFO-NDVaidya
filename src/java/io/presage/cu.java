/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.presage.cy
 *  java.lang.Class
 *  java.lang.ClassCastException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.List
 */
package io.presage;

import io.presage.cl;
import io.presage.cv;
import io.presage.cy;
import java.util.List;

public class cu {
    private static ClassCastException a(ClassCastException classCastException) {
        throw cu.a(classCastException);
    }

    private static <T extends Throwable> T a(T t2) {
        return cl.a(t2, cu.class.getName());
    }

    public static List a(Object object) {
        if (object instanceof cv && !(object instanceof cy)) {
            cu.a(object, "kotlin.collections.MutableList");
        }
        return cu.b(object);
    }

    private static void a(Object object, String string) {
        String string2 = object == null ? "null" : object.getClass().getName();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append(" cannot be cast to ");
        stringBuilder.append(string);
        cu.a(stringBuilder.toString());
    }

    private static void a(String string) {
        throw cu.a(new ClassCastException(string));
    }

    private static List b(Object object) {
        try {
            List list = (List)object;
            return list;
        }
        catch (ClassCastException classCastException) {
            throw cu.a(classCastException);
        }
    }
}

