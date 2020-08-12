/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.UnsupportedEncodingException
 *  java.lang.Deprecated
 *  java.lang.Object
 *  java.lang.String
 */
package com.tappx.b.a;

import com.tappx.b.k;
import com.tappx.b.n;
import com.tappx.b.p;
import com.tappx.b.v;
import java.io.UnsupportedEncodingException;

public abstract class r<T>
extends n<T> {
    protected static final String a = "utf-8";
    private static final String b = String.format((String)"application/json; charset=%s", (Object[])new Object[]{"utf-8"});
    private final Object c = new Object();
    private p.b<T> d;
    private final String e;

    public r(int n2, String string, String string2, p.b<T> b2, p.a a2) {
        super(n2, string, a2);
        this.d = b2;
        this.e = string2;
    }

    @Deprecated
    public r(String string, String string2, p.b<T> b2, p.a a2) {
        this(-1, string, string2, b2, a2);
    }

    @Override
    protected abstract p<T> a(k var1);

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    @Override
    protected void a(T t2) {
        Object object;
        Object object2 = object = this.c;
        // MONITORENTER : object2
        p.b<T> b2 = this.d;
        // MONITOREXIT : object2
        if (b2 == null) return;
        b2.a(t2);
    }

    @Override
    public byte[] a() {
        block3 : {
            try {
                if (this.e != null) break block3;
                return null;
            }
            catch (UnsupportedEncodingException unsupportedEncodingException) {
                Object[] arrobject = new Object[]{this.e, "utf-8"};
                v.d("Unsupported Encoding while trying to get the bytes of %s using %s", arrobject);
                return null;
            }
        }
        byte[] arrby = this.e.getBytes("utf-8");
        return arrby;
    }

    @Deprecated
    @Override
    public byte[] b() {
        return this.a();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void n() {
        Object object;
        super.n();
        Object object2 = object = this.c;
        synchronized (object2) {
            this.d = null;
            return;
        }
    }

    @Deprecated
    @Override
    public String r() {
        return this.u();
    }

    @Override
    public String u() {
        return b;
    }
}

