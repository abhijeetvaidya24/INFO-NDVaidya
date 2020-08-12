/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.reflect.Type
 */
package co.ogury.crashreport;

import co.ogury.crashreport.tx7920;
import java.lang.reflect.Type;

public class expandedcolortbl {
    public String a(tx7920 tx79202) {
        String string = tx79202.getClass().getGenericInterfaces()[0].toString();
        if (string.startsWith("kotlin.jvm.functions.")) {
            string = string.substring(21);
        }
        return string;
    }
}

