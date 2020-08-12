/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.applovin.impl.sdk.e.j
 *  com.applovin.impl.sdk.e.n
 *  com.applovin.impl.sdk.j
 *  com.applovin.impl.sdk.p
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.Map
 */
package com.applovin.impl.a;

import com.applovin.impl.sdk.e.j;
import com.applovin.impl.sdk.e.n;
import com.applovin.impl.sdk.p;
import java.util.Map;

public class f {
    private String a;
    private String b;

    private f() {
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static f a(n var0, f var1_1, com.applovin.impl.sdk.j var2_2) {
        if (var0 == null) throw new IllegalArgumentException("No node specified.");
        if (var2_2 == null) throw new IllegalArgumentException("No sdk specified.");
        if (var1_1 != null) ** GOTO lbl6
        try {
            var1_1 = new f();
lbl6: // 2 sources:
            if (!j.b((String)var1_1.a) && j.b((String)(var5_3 = var0.c()))) {
                var1_1.a = var5_3;
            }
            if (j.b((String)var1_1.b) != false) return var1_1;
            var4_4 = (String)var0.b().get((Object)"version");
            if (j.b((String)var4_4) == false) return var1_1;
            var1_1.b = var4_4;
            return var1_1;
        }
        catch (Throwable var3_5) {
            var2_2.u().b("VastSystemInfo", "Error occurred while initializing", var3_5);
            return null;
        }
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof f)) {
            return false;
        }
        f f2 = (f)object;
        String string = this.a;
        if (string != null ? !string.equals((Object)f2.a) : f2.a != null) {
            return false;
        }
        String string2 = this.b;
        if (string2 != null) {
            return string2.equals((Object)f2.b);
        }
        return f2.b == null;
    }

    public int hashCode() {
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

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("VastSystemInfo{name='");
        stringBuilder.append(this.a);
        stringBuilder.append('\'');
        stringBuilder.append(", version='");
        stringBuilder.append(this.b);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

