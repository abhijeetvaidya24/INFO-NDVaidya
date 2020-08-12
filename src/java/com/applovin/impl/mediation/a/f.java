/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.applovin.impl.mediation.a.g
 *  com.applovin.impl.mediation.h
 *  java.lang.IllegalArgumentException
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.applovin.impl.mediation.a;

import com.applovin.impl.mediation.a.g;
import com.applovin.impl.mediation.h;

public class f {
    private final g a;
    private final String b;
    private final String c;
    private final String d;
    private final String e;

    private f(g g2, h h2, String string, String string2) {
        this.a = g2;
        this.e = string2;
        if (string != null) {
            int n2 = g2.a();
            this.d = string.substring(0, Math.min((int)string.length(), (int)n2));
        } else {
            this.d = null;
        }
        if (h2 != null) {
            this.b = h2.e();
            this.c = h2.f();
            return;
        }
        this.b = null;
        this.c = null;
    }

    public static f a(g g2, h h2, String string) {
        if (g2 != null) {
            if (h2 != null) {
                return new f(g2, h2, string, null);
            }
            throw new IllegalArgumentException("No adapterWrapper specified");
        }
        throw new IllegalArgumentException("No spec specified");
    }

    public static f a(g g2, String string) {
        return f.b(g2, null, string);
    }

    public static f b(g g2, h h2, String string) {
        if (g2 != null) {
            return new f(g2, h2, null, string);
        }
        throw new IllegalArgumentException("No spec specified");
    }

    public g a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    public String c() {
        return this.c;
    }

    public String d() {
        return this.d;
    }

    public String e() {
        return this.e;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SignalCollectionResult{mSignalProviderSpec=");
        stringBuilder.append((Object)this.a);
        stringBuilder.append(", mSdkVersion='");
        stringBuilder.append(this.b);
        stringBuilder.append('\'');
        stringBuilder.append(", mAdapterVersion='");
        stringBuilder.append(this.c);
        stringBuilder.append('\'');
        stringBuilder.append(", mSignalDataLength='");
        String string = this.d;
        int n2 = string != null ? string.length() : 0;
        stringBuilder.append(n2);
        stringBuilder.append('\'');
        stringBuilder.append(", mErrorMessage=");
        stringBuilder.append(this.e);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public static interface a {
        public void a(f var1);
    }

}

