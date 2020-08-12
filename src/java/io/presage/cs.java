/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.presage.cg
 *  io.presage.ck
 *  io.presage.cm
 *  io.presage.cn
 *  io.presage.cp
 *  io.presage.dk
 *  io.presage.dm
 *  io.presage.do
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.reflect.Type
 */
package io.presage;

import io.presage.cg;
import io.presage.cj;
import io.presage.ck;
import io.presage.cm;
import io.presage.cn;
import io.presage.cp;
import io.presage.dk;
import io.presage.dl;
import io.presage.dm;
import io.presage.do;
import java.lang.reflect.Type;

public final class cs {
    public static dk a(Class class_) {
        return new cg(class_);
    }

    public static dl a(Class class_, String string) {
        return new cn(class_, string);
    }

    public static dm a(ck ck2) {
        return ck2;
    }

    public static do a(cp cp2) {
        return cp2;
    }

    private static String a(cj cj2) {
        String string = cj2.getClass().getGenericInterfaces()[0].toString();
        if (string.startsWith("kotlin.jvm.functions.")) {
            string = string.substring(21);
        }
        return string;
    }

    public static String a(cm cm2) {
        return cs.a((cj)cm2);
    }
}

