/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.adincube.sdk.util.u$b
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.Iterator
 *  java.util.LinkedList
 *  java.util.List
 */
package com.adincube.sdk.util;

import com.adincube.sdk.util.u;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/*
 * Exception performing whole class analysis.
 */
public final class u {
    public boolean a;
    private List<a> b;

    public u() {
        this.a = false;
        this.b = new LinkedList();
        this.a = false;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void a(String string, a a2) {
        u u2 = this;
        synchronized (u2) {
            if (string != null) {
                this.a(string);
            }
            this.b.add((Object)a2);
            return;
        }
    }

    public final void a() {
        u u2 = this;
        synchronized (u2) {
            try {
                Iterator iterator = this.b.iterator();
                while (iterator.hasNext()) {
                    ((a)iterator.next()).run();
                    iterator.remove();
                }
                return;
            }
            catch (Throwable throwable) {
                throw throwable;
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void a(String string) {
        u u2 = this;
        synchronized (u2) {
            Iterator iterator = this.b.iterator();
            while (iterator.hasNext()) {
                a a2 = (a)iterator.next();
                if ((string != null || a2.a != null) && (string == null || !string.equals((Object)a2.a))) continue;
                iterator.remove();
            }
            return;
        }
    }

    public final <T> void a(String string, T t2, com.adincube.sdk.util.c.a<T> a2) {
        this.a(string, (a)new /* Unavailable Anonymous Inner Class!! */);
        if (this.a) {
            this.a();
        }
    }

    private static abstract class a
    implements Runnable {
        String a;

        protected a(String string) {
            this.a = string;
        }
    }

}

