/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 */
package com.startapp.a.a.f;

import com.startapp.a.a.d.e;
import com.startapp.a.a.e.b;
import com.startapp.a.a.g.c;

public class a {
    private final b a;
    private final c b;

    public a(b b2, c c2) {
        this.b = c2;
        this.a = b2;
    }

    public String a(com.startapp.a.a.g.a a2, com.startapp.a.a.a.c c2, long l2) {
        try {
            String string2 = this.a.a(c2);
            e e2 = this.b.b(a2);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(l2);
            stringBuilder.append("-");
            stringBuilder.append(a2.a());
            stringBuilder.append("-");
            stringBuilder.append(e2.a(string2));
            String string3 = stringBuilder.toString();
            return string3;
        }
        catch (Throwable throwable) {
            return null;
        }
    }
}

