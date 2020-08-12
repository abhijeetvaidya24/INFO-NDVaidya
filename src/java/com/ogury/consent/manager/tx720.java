/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.ClassLoader
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Thread
 */
package com.ogury.consent.manager;

import com.ogury.consent.manager.tx4320;
import com.ogury.consent.manager.tx6480;
import com.ogury.consent.manager.viewkind0;

public final class tx720 {
    private final String a;
    private final boolean b;

    public tx720(String string2, boolean bl2) {
        tx6480.b(string2, "id");
        this.a = string2;
        this.b = bl2;
    }

    public static final Thread a(boolean bl2, boolean bl3, ClassLoader classLoader, String string2, int n2, final tx4320<viewkind0> tx43202) {
        tx6480.b(tx43202, "block");
        Thread thread = new Thread(){

            public final void run() {
                tx43202.a();
            }
        };
        thread.start();
        return thread;
    }

    public final String a() {
        return this.a;
    }

}

