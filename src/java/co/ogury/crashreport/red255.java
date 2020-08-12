/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package co.ogury.crashreport;

import co.ogury.crashreport.green255;
import co.ogury.crashreport.tx8640;

public final class red255 {
    public static final rtf1 a = new rtf1(0);
    private final String b;
    private final String c;
    private final green255 d;

    public red255(String string, String string2, green255 green2552) {
        tx8640.b(string, "phoneModel");
        tx8640.b(string2, "androidVersion");
        tx8640.b(green2552, "memory");
        this.b = string;
        this.c = string2;
        this.d = green2552;
    }

    public final String a() {
        return this.b;
    }

    public final String b() {
        return this.c;
    }

    public final green255 c() {
        return this.d;
    }

    public static final class rtf1 {
        private rtf1() {
        }

        public /* synthetic */ rtf1(byte by2) {
            this();
        }
    }

}

