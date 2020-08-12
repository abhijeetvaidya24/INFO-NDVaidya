/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.Writer
 *  java.lang.Object
 *  java.lang.String
 */
package com.tapjoy.internal;

import com.tapjoy.internal.bq;
import java.io.Writer;

public final class br
implements bq {
    public final String a;

    public br(String string) {
        this.a = string;
    }

    @Override
    public final void a(Writer writer) {
        writer.write(this.a);
    }

    public final boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object instanceof br) {
            br br2 = (br)object;
            return this.a.equals((Object)br2.a);
        }
        return false;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return this.a;
    }
}

