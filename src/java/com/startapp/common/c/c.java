/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Boolean
 *  java.lang.Byte
 *  java.lang.Character
 *  java.lang.Class
 *  java.lang.Double
 *  java.lang.Float
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.Short
 *  java.lang.String
 *  java.lang.annotation.Annotation
 *  java.lang.reflect.Field
 *  java.util.List
 *  java.util.Map
 *  java.util.Set
 */
package com.startapp.common.c;

import com.startapp.common.c.f;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class c {
    public static String a(Field field) {
        f f2;
        Annotation annotation;
        Annotation[] arrannotation = field.getDeclaredAnnotations();
        if (arrannotation != null && arrannotation.length > 0 && (annotation = field.getDeclaredAnnotations()[0]).annotationType().equals(f.class) && !"".equals((Object)(f2 = (f)annotation).f())) {
            return f2.f();
        }
        return field.getName();
    }

    public static boolean a(Object object) {
        Class class_ = object.getClass();
        return class_.equals(Boolean.class) || class_.equals(Integer.class) || class_.equals(Character.class) || class_.equals(Byte.class) || class_.equals(Short.class) || class_.equals(Double.class) || class_.equals(Long.class) || class_.equals(Float.class) || class_.equals(String.class);
        {
        }
    }

    public static boolean b(Field field) {
        return Map.class.isAssignableFrom(field.getType());
    }

    public static boolean c(Field field) {
        return List.class.isAssignableFrom(field.getType());
    }

    public static boolean d(Field field) {
        return Set.class.isAssignableFrom(field.getType());
    }

    public static boolean e(Field field) {
        Annotation[] arrannotation = field.getDeclaredAnnotations();
        if (arrannotation != null) {
            if (arrannotation.length == 0) {
                return false;
            }
            Annotation annotation = field.getDeclaredAnnotations()[0];
            if (!annotation.annotationType().equals(f.class)) {
                return false;
            }
            return ((f)annotation).a();
        }
        return false;
    }
}

