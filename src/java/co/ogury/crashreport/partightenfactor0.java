/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Iterable
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.Iterator
 */
package co.ogury.crashreport;

import co.ogury.crashreport.fs24;
import co.ogury.crashreport.rtf1;
import java.util.Iterator;

public class partightenfactor0
implements Iterable<Integer> {
    public static final rtf1 a = new rtf1(0);
    private final int b;
    private final int c;
    private final int d;

    public partightenfactor0(int n2, int n3, int n4) {
        if (n4 != 0) {
            this.b = n2;
            this.c = rtf1.rtf1.a(n2, n3, n4);
            this.d = n4;
            return;
        }
        throw (Throwable)new IllegalArgumentException("Step must be non-zero");
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
                if (!(object instanceof partightenfactor0)) break block2;
                if (this.d() && ((partightenfactor0)object).d()) break block3;
                int n2 = this.b;
                partightenfactor0 partightenfactor02 = (partightenfactor0)object;
                if (n2 != partightenfactor02.b || this.c != partightenfactor02.c || this.d != partightenfactor02.d) break block2;
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
        return new fs24(this.b, this.c, this.d);
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

        public /* synthetic */ rtf1(byte by2) {
            this();
        }
    }

}

