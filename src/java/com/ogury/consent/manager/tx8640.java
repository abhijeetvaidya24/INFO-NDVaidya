/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.ogury.consent.manager.pardirnatural
 *  java.lang.Integer
 *  java.lang.Iterable
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Iterator
 */
package com.ogury.consent.manager;

import com.ogury.consent.manager.pard;
import com.ogury.consent.manager.pardirnatural;
import com.ogury.consent.manager.rtf1;
import com.ogury.consent.manager.tx5040;
import java.util.Iterator;

public class tx8640
implements Iterable<Integer> {
    public static final rtf1 a = new rtf1(null);
    private final int b;
    private final int c;
    private final int d;

    public tx8640(int n2, int n3, int n4) {
        this.b = n2;
        this.c = rtf1.rtf1.a(n2, n3, 1);
        this.d = 1;
    }

    public final int a() {
        return this.b;
    }

    public final int b() {
        return this.c;
    }

    public final int c() {
        return this.d;
    }

    public boolean d() {
        if (this.d > 0) {
            return this.b > this.c;
        }
        return this.b < this.c;
    }

    public boolean equals(Object object) {
        block2 : {
            block3 : {
                if (!(object instanceof tx8640)) break block2;
                if (this.d() && ((tx8640)object).d()) break block3;
                int n2 = this.b;
                tx8640 tx86402 = (tx8640)object;
                if (n2 != tx86402.b || this.c != tx86402.c || this.d != tx86402.d) break block2;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (this.d()) {
            return -1;
        }
        return 31 * (31 * this.b + this.c) + this.d;
    }

    public /* synthetic */ Iterator iterator() {
        return (pard)new pardirnatural(this.b, this.c, this.d);
    }

    /*
     * Enabled aggressive block sorting
     */
    public String toString() {
        StringBuilder stringBuilder;
        int n2;
        if (this.d > 0) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(this.b);
            stringBuilder.append("..");
            stringBuilder.append(this.c);
            stringBuilder.append(" step ");
            n2 = this.d;
        } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append(this.b);
            stringBuilder.append(" downTo ");
            stringBuilder.append(this.c);
            stringBuilder.append(" step ");
            n2 = -this.d;
        }
        stringBuilder.append(n2);
        return stringBuilder.toString();
    }

    public static final class rtf1 {
        private rtf1() {
        }

        public /* synthetic */ rtf1(tx5040 tx50402) {
            this();
        }
    }

}

