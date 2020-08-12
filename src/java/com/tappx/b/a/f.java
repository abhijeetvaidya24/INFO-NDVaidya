/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.Collections
 *  java.util.Comparator
 *  java.util.LinkedList
 *  java.util.List
 */
package com.tappx.b.a;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class f {
    protected static final Comparator<byte[]> a = new Comparator<byte[]>(){

        public int a(byte[] arrby, byte[] arrby2) {
            return arrby.length - arrby2.length;
        }

        public /* synthetic */ int compare(Object object, Object object2) {
            return this.a((byte[])object, (byte[])object2);
        }
    };
    private final List<byte[]> b = new LinkedList();
    private final List<byte[]> c = new ArrayList(64);
    private int d = 0;
    private final int e;

    public f(int n2) {
        this.e = n2;
    }

    private void a() {
        f f2 = this;
        synchronized (f2) {
            try {
                while (this.d > this.e) {
                    byte[] arrby = (byte[])this.b.remove(0);
                    this.c.remove((Object)arrby);
                    this.d -= arrby.length;
                }
                return;
            }
            catch (Throwable throwable) {
                throw throwable;
            }
        }
    }

    public void a(byte[] arrby) {
        f f2 = this;
        synchronized (f2) {
            block5 : {
                if (arrby != null) {
                    int n2;
                    block6 : {
                        if (arrby.length > this.e) break block5;
                        this.b.add((Object)arrby);
                        n2 = Collections.binarySearch(this.c, (Object)arrby, a);
                        if (n2 >= 0) break block6;
                        n2 = -1 + -n2;
                    }
                    this.c.add(n2, (Object)arrby);
                    this.d += arrby.length;
                    this.a();
                    return;
                }
            }
            return;
        }
    }

    public byte[] a(int n2) {
        f f2 = this;
        synchronized (f2) {
            int n3 = 0;
            do {
                block5 : {
                    if (n3 >= this.c.size()) break;
                    byte[] arrby = (byte[])this.c.get(n3);
                    if (arrby.length < n2) break block5;
                    this.d -= arrby.length;
                    this.c.remove(n3);
                    this.b.remove((Object)arrby);
                    return arrby;
                }
                ++n3;
            } while (true);
            try {
                byte[] arrby = new byte[n2];
                return arrby;
            }
            catch (Throwable throwable) {
                throw throwable;
            }
        }
    }

}

