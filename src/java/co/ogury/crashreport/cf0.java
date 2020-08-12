/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  co.ogury.crashreport.cf0$rtf1
 *  co.ogury.crashreport.partightenfactor0
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package co.ogury.crashreport;

import co.ogury.crashreport.cf0;
import co.ogury.crashreport.partightenfactor0;

/*
 * Exception performing whole class analysis.
 */
public final class cf0
extends partightenfactor0 {
    static {
        new /* Unavailable Anonymous Inner Class!! */;
        new cf0(1, 0);
    }

    public cf0(int n2, int n3) {
        super(n2, n3, 1);
    }

    public final boolean d() {
        return this.a() > this.b();
    }

    public final boolean equals(Object object) {
        cf0 cf02;
        int n2;
        return object instanceof cf0 && (this.d() && ((cf0)((Object)object)).d() || (n2 = this.a()) == (cf02 = (cf0)((Object)object)).a() && this.b() == cf02.b());
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

