/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.InputStream
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.net.URI
 *  java.util.Collections
 *  java.util.LinkedHashMap
 *  java.util.Map
 *  java.util.concurrent.ExecutorService
 *  java.util.concurrent.Future
 */
package com.tapjoy.internal;

import com.tapjoy.internal.ch;
import com.tapjoy.internal.ci;
import com.tapjoy.internal.ck;
import java.io.InputStream;
import java.net.URI;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public abstract class cf {
    public static ExecutorService a;
    public static ci b;
    private Future c;

    public abstract Object a(URI var1, InputStream var2);

    public Map a() {
        return Collections.emptyMap();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void a(ck ck2, ExecutorService executorService) {
        cf cf2 = this;
        synchronized (cf2) {
            boolean bl2 = this.c == null || this.c.isDone();
            if (bl2) {
                this.c = executorService.submit((Runnable)new ch(this, ck2));
                return;
            }
            throw new IllegalStateException("Call has not completed");
        }
    }

    public abstract String b();

    public abstract String c();

    public String d() {
        return null;
    }

    public Map e() {
        return new LinkedHashMap();
    }

    public Object f() {
        return b.a(this);
    }
}

