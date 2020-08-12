/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.b.a.a.a.c.e
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.b.a.a.a;

import android.content.Context;
import com.b.a.a.a.c.b;
import com.b.a.a.a.c.e;

public class c {
    private boolean a;

    private void b(String string2, Context context) {
        this.c(string2);
        com.b.a.a.a.e.e.a((Object)context, "Application Context cannot be null");
    }

    private void c(String string2) {
        com.b.a.a.a.e.e.a((Object)string2, "Version cannot be null");
        if (string2.matches("[0-9]+\\.[0-9]+\\.[0-9]+.*")) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Invalid version format : ");
        stringBuilder.append(string2);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    String a() {
        return "1.2.0-Startapp";
    }

    void a(boolean bl) {
        this.a = bl;
    }

    boolean a(String string2) {
        return this.b(this.a()) == this.b(string2);
    }

    boolean a(String string2, Context context) {
        this.b(string2, context);
        if (this.a(string2)) {
            if (!this.b()) {
                this.a(true);
                e.a().a(context);
                b.a().a(context);
                com.b.a.a.a.e.b.a(context);
                com.b.a.a.a.c.c.a().a(context);
            }
            return true;
        }
        return false;
    }

    int b(String string2) {
        this.c(string2);
        return Integer.parseInt((String)string2.split("\\.", 2)[0]);
    }

    boolean b() {
        return this.a;
    }
}

