/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 */
package com.tappx.b.a;

import android.os.Handler;
import android.os.Looper;
import com.tappx.b.b;
import com.tappx.b.k;
import com.tappx.b.n;
import com.tappx.b.p;

public class g
extends n<Object> {
    private final b a;
    private final Runnable b;

    public g(b b2, Runnable runnable) {
        super(0, null, null);
        this.a = b2;
        this.b = runnable;
    }

    @Override
    protected p<Object> a(k k2) {
        return null;
    }

    @Override
    protected void a(Object object) {
    }

    @Override
    public n.c e() {
        return n.c.d;
    }

    @Override
    public boolean o() {
        this.a.b();
        if (this.b != null) {
            new Handler(Looper.getMainLooper()).postAtFrontOfQueue(this.b);
        }
        return true;
    }
}

