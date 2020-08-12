/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.applovin.impl.sdk.c;

public final class e {
    private long a;
    private long b;
    private boolean c;
    private long d;
    private long e;

    public void a() {
        this.c = true;
    }

    public void a(long l2) {
        this.a = l2 + this.a;
    }

    public void b(long l2) {
        this.b = l2 + this.b;
    }

    public boolean b() {
        return this.c;
    }

    public long c() {
        return this.a;
    }

    public long d() {
        return this.b;
    }

    public void e() {
        this.d = 1L + this.d;
    }

    public void f() {
        this.e = 1L + this.e;
    }

    public long g() {
        return this.d;
    }

    public long h() {
        return this.e;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CacheStatsTracker{totalDownloadedBytes=");
        stringBuilder.append(this.a);
        stringBuilder.append(", totalCachedBytes=");
        stringBuilder.append(this.b);
        stringBuilder.append(", isHTMLCachingCancelled=");
        stringBuilder.append(this.c);
        stringBuilder.append(", htmlResourceCacheSuccessCount=");
        stringBuilder.append(this.d);
        stringBuilder.append(", htmlResourceCacheFailureCount=");
        stringBuilder.append(this.e);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

