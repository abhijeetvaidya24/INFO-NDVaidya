/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  co.ogury.crashreport.ansi
 *  co.ogury.crashreport.tx8640
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package co.ogury.crashreport;

import co.ogury.crashreport.ansi;
import co.ogury.crashreport.tx8640;

public final class blue255
extends ansi {
    private final String a;
    private final String b;

    public blue255(String string, String string2) {
        tx8640.b((Object)string, (String)"crash");
        tx8640.b((Object)string2, (String)"packageName");
        super((byte)0);
        this.a = string;
        this.b = string2;
    }

    public final String a() {
        return this.a;
    }

    public final String b() {
        return this.b;
    }

    public final boolean equals(Object object) {
        block2 : {
            block3 : {
                if (this == object) break block2;
                if (!(object instanceof blue255)) break block3;
                blue255 blue2552 = (blue255)((Object)object);
                if (tx8640.a((Object)this.a, (Object)blue2552.a) && tx8640.a((Object)this.b, (Object)blue2552.b)) break block2;
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        String string = this.a;
        int n2 = string != null ? string.hashCode() : 0;
        int n3 = n2 * 31;
        String string2 = this.b;
        int n4 = 0;
        if (string2 != null) {
            n4 = string2.hashCode();
        }
        return n3 + n4;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("PresageCrash(crash=");
        stringBuilder.append(this.a);
        stringBuilder.append(", packageName=");
        stringBuilder.append(this.b);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

