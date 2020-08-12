/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Iterator
 *  java.util.List
 */
package com.tappx.a.a.a.h;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class e {
    private final List<Runnable> a = new ArrayList();
    private boolean b;

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    private void d() {
        List<Runnable> list;
        List<Runnable> list2 = list = this.a;
        // MONITORENTER : list2
        ArrayList arrayList = new ArrayList(this.a);
        this.a.clear();
        // MONITOREXIT : list2
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            ((Runnable)iterator.next()).run();
        }
        return;
        {
            catch (Throwable throwable) {}
            {
                // MONITOREXIT : list2
                throw throwable;
            }
        }
    }

    public void a(Runnable runnable) {
        if (this.b) {
            this.a.add((Object)runnable);
            return;
        }
        runnable.run();
    }

    public boolean a() {
        return this.b;
    }

    public void b() {
        if (this.b) {
            return;
        }
        this.b = true;
    }

    public void c() {
        this.b = false;
        this.d();
    }
}

