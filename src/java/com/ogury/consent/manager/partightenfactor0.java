/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.ogury.consent.manager;

import com.ogury.consent.manager.tx5040;
import com.ogury.consent.manager.tx8640;

public final class partightenfactor0
extends tx8640 {
    public static final rtf1 b = new Object(null){
        {
            this();
        }
    };
    private static final partightenfactor0 c = new partightenfactor0(1, 0);

    public partightenfactor0(int n2, int n3) {
        super(n2, n3, 1);
    }

    @Override
    public final boolean d() {
        return this.a() > this.b();
    }

    @Override
    public final boolean equals(Object object) {
        partightenfactor0 partightenfactor02;
        int n2;
        return object instanceof partightenfactor0 && (this.d() && ((partightenfactor0)object).d() || (n2 = this.a()) == (partightenfactor02 = (partightenfactor0)object).a() && this.b() == partightenfactor02.b());
    }

    @Override
    public final int hashCode() {
        if (this.d()) {
            return -1;
        }
        return 31 * this.a() + this.b();
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.a());
        stringBuilder.append("..");
        stringBuilder.append(this.b());
        return stringBuilder.toString();
    }

}

