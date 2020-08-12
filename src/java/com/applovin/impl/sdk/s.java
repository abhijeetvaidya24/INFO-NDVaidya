/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Exception
 *  java.lang.Object
 *  java.util.LinkedList
 *  java.util.Queue
 */
package com.applovin.impl.sdk;

import com.applovin.impl.sdk.ad.j;
import java.util.LinkedList;
import java.util.Queue;

class s {
    private int a;
    private final Queue<j> b;
    private final Object c;

    s(int n2) {
        this.a(n2);
        this.b = new LinkedList();
        this.c = new Object();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    int a() {
        Object object;
        Object object2 = object = this.c;
        synchronized (object2) {
            return this.b.size();
        }
    }

    void a(int n2) {
        if (n2 > 25) {
            n2 = 25;
        }
        this.a = n2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    void a(j j2) {
        Object object;
        Object object2 = object = this.c;
        synchronized (object2) {
            if (this.a() <= 25) {
                this.b.offer((Object)j2);
            }
            return;
        }
    }

    int b() {
        return this.a;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    boolean c() {
        Object object;
        Object object2 = object = this.c;
        synchronized (object2) {
            if (this.a() < this.a) return false;
            return true;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    boolean d() {
        Object object;
        Object object2 = object = this.c;
        synchronized (object2) {
            if (this.a() != 0) return false;
            return true;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    j e() {
        try {
            Object object;
            Object object2 = object = this.c;
            // MONITORENTER : object2
        }
        catch (Exception exception) {
            return null;
        }
        if (this.d()) return null;
        j j2 = (j)this.b.poll();
        // MONITOREXIT : object2
        return j2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    j f() {
        Object object;
        Object object2 = object = this.c;
        synchronized (object2) {
            return (j)this.b.peek();
        }
    }
}

