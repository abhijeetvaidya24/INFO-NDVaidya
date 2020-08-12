/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Runnable
 *  java.lang.String
 */
package com.applovin.impl.sdk.d;

import com.applovin.impl.sdk.c.i;
import com.applovin.impl.sdk.d.a;
import com.applovin.impl.sdk.j;

public class aa
extends a {
    private final Runnable a;

    public aa(j j2, Runnable runnable) {
        super("TaskRunnable", j2);
        this.a = runnable;
    }

    @Override
    public i a() {
        return i.f;
    }

    public void run() {
        this.a.run();
    }
}

