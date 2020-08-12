/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  a.a.b.b.c
 *  a.a.b.b.g
 *  a.a.b.b.k
 *  a.a.d.f
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.reflect.Type
 */
package a.a.b.b;

import a.a.b.b.c;
import a.a.b.b.g;
import a.a.b.b.i;
import a.a.b.b.k;
import a.a.d.b;
import a.a.d.d;
import a.a.d.f;
import java.lang.reflect.Type;

public class o {
    public b a(Class class_) {
        return new c(class_);
    }

    public d a(g g2) {
        return g2;
    }

    public f a(k k2) {
        return k2;
    }

    public String a(i i2) {
        String string = i2.getClass().getGenericInterfaces()[0].toString();
        if (string.startsWith("truenet.kotlin.jvm.functions.")) {
            string = string.substring(29);
        }
        return string;
    }
}

