/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.presage.j
 *  java.lang.Object
 *  java.lang.System
 *  java.lang.ref.WeakReference
 */
package io.presage;

import io.presage.BrillatSavarin;
import io.presage.c;
import io.presage.j;
import java.lang.ref.WeakReference;

public final class TrouduCru {
    private final WeakReference<c> a;
    private final j b;
    private final BrillatSavarin c;
    private final long d;

    public /* synthetic */ TrouduCru(WeakReference weakReference, j j2, BrillatSavarin brillatSavarin) {
        this((WeakReference<c>)weakReference, j2, brillatSavarin, System.currentTimeMillis());
    }

    private TrouduCru(WeakReference<c> weakReference, j j2, BrillatSavarin brillatSavarin, long l2) {
        this.a = weakReference;
        this.b = j2;
        this.c = brillatSavarin;
        this.d = l2;
    }

    public final WeakReference<c> a() {
        return this.a;
    }

    public final j b() {
        return this.b;
    }

    public final BrillatSavarin c() {
        return this.c;
    }

    public final long d() {
        return this.d;
    }
}

