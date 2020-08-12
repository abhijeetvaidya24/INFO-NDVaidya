/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  com.applovin.impl.sdk.j
 *  com.applovin.impl.sdk.p
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.Collection
 *  java.util.HashSet
 *  java.util.Set
 *  java.util.concurrent.atomic.AtomicInteger
 */
package com.applovin.impl.adview;

import android.os.Handler;
import com.applovin.impl.sdk.j;
import com.applovin.impl.sdk.p;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public final class h {
    private final p a;
    private final Handler b;
    private final Set<b> c = new HashSet();
    private final AtomicInteger d = new AtomicInteger();

    public h(Handler handler, j j2) {
        if (handler != null) {
            if (j2 != null) {
                this.b = handler;
                this.a = j2.u();
                return;
            }
            throw new IllegalArgumentException("No sdk specified.");
        }
        throw new IllegalArgumentException("No handler specified.");
    }

    private void a(final b b2, final int n2) {
        this.b.postDelayed(new Runnable(){

            public void run() {
                a a2 = b2.c();
                if (a2.b()) {
                    if (h.this.d.get() == n2) {
                        try {
                            a2.a();
                        }
                        catch (Throwable throwable) {
                            p p2 = h.this.a;
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("Encountered error on countdown step for: ");
                            stringBuilder.append(b2.a());
                            p2.b("CountdownManager", stringBuilder.toString(), throwable);
                        }
                        h.this.a(b2, n2);
                        return;
                    }
                    p p3 = h.this.a;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Killing duplicate countdown from previous generation: ");
                    stringBuilder.append(b2.a());
                    p3.c("CountdownManager", stringBuilder.toString());
                    return;
                }
                p p4 = h.this.a;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Ending countdown for ");
                stringBuilder.append(b2.a());
                p4.a("CountdownManager", stringBuilder.toString());
            }
        }, b2.b());
    }

    public void a() {
        HashSet hashSet = new HashSet(this.c);
        p p2 = this.a;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Starting ");
        stringBuilder.append(hashSet.size());
        stringBuilder.append(" countdowns...");
        p2.a("CountdownManager", stringBuilder.toString());
        int n2 = this.d.incrementAndGet();
        for (b b2 : hashSet) {
            p p3 = this.a;
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Starting countdown: ");
            stringBuilder2.append(b2.a());
            stringBuilder2.append(" for generation ");
            stringBuilder2.append(n2);
            stringBuilder2.append("...");
            p3.a("CountdownManager", stringBuilder2.toString());
            this.a(b2, n2);
        }
    }

    public void a(String string, long l2, a a2) {
        if (l2 > 0L) {
            if (this.b != null) {
                p p2 = this.a;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Adding countdown: ");
                stringBuilder.append(string);
                p2.a("CountdownManager", stringBuilder.toString());
                b b2 = new b(string, l2, a2);
                this.c.add((Object)b2);
                return;
            }
            throw new IllegalArgumentException("No handler specified.");
        }
        throw new IllegalArgumentException("Invalid step specified.");
    }

    public void b() {
        this.a.a("CountdownManager", "Removing all countdowns...");
        this.c();
        this.c.clear();
    }

    public void c() {
        this.a.a("CountdownManager", "Stopping countdowns...");
        this.d.incrementAndGet();
        this.b.removeCallbacksAndMessages(null);
    }

    static interface a {
        public void a();

        public boolean b();
    }

    private static class b {
        private final String a;
        private final a b;
        private final long c;

        private b(String string, long l2, a a2) {
            this.a = string;
            this.c = l2;
            this.b = a2;
        }

        private String a() {
            return this.a;
        }

        private long b() {
            return this.c;
        }

        private a c() {
            return this.b;
        }

        public boolean equals(Object object) {
            if (this == object) {
                return true;
            }
            if (!(object instanceof b)) {
                return false;
            }
            b b2 = (b)object;
            String string = this.a;
            if (string != null) {
                return string.equalsIgnoreCase(b2.a);
            }
            return b2.a == null;
        }

        public int hashCode() {
            String string = this.a;
            if (string != null) {
                return string.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("CountdownProxy{identifier='");
            stringBuilder.append(this.a);
            stringBuilder.append('\'');
            stringBuilder.append(", countdownStepMillis=");
            stringBuilder.append(this.c);
            stringBuilder.append('}');
            return stringBuilder.toString();
        }
    }

}

