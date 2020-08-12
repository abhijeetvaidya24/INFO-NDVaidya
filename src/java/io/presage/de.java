/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.presage.dc
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package io.presage;

import io.presage.dc;

public final class de
extends dc {
    public static final CamembertauCalvados b = new Object(0){
        {
            this();
        }
    };
    private static final de c = new de(1, 0);

    public de(int n2, int n3) {
        super(n2, n3);
    }

    public final boolean d() {
        return this.a() > this.b();
    }

    public final boolean equals(Object object) {
        de de2;
        int n2;
        return object instanceof de && (this.d() && ((de)((Object)object)).d() || (n2 = this.a()) == (de2 = (de)((Object)object)).a() && this.b() == de2.b());
    }

    public final int hashCode() {
        if (this.d()) {
            return -1;
        }
        return 31 * this.a() + this.b();
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.a());
        stringBuilder.append("..");
        stringBuilder.append(this.b());
        return stringBuilder.toString();
    }

}

