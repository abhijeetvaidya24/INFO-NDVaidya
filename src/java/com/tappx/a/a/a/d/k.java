/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.lang.Exception
 *  java.lang.NoClassDefFoundError
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 */
package com.tappx.a.a.a.d;

import android.content.Context;
import com.tappx.a.a.a.d.k;
import com.tappx.a.a.a.d.l;
import com.tappx.a.a.a.d.t;
import com.tappx.a.a.a.e.b;
import com.tappx.a.a.a.e.e;
import com.tappx.a.a.a.e.h;

public class k
extends t<e> {
    private t.b a;
    private e b;
    private l c;

    k(com.tappx.a.a.a.i.a.a a2) {
        super(a2);
    }

    static /* synthetic */ e a(k k2) {
        return k2.b;
    }

    @Override
    protected long a(e e2) {
        long l2 = e2.i();
        if (l2 > 0L) {
            return l2;
        }
        return super.a(e2);
    }

    @Override
    public void a() {
        l l2 = this.c;
        if (l2 != null) {
            try {
                l2.b();
                return;
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    @Override
    protected void a(Context context, t.b b2, e e2) {
        void var5_7;
        this.a = b2;
        String string = e2.h();
        this.b = e2;
        try {
            com.tappx.a.a.a.c.a.e("EecDzDUbtS5qsctGaW8eDzBBqoEJJw2EaiO9g7mmMkc", new Object[0]);
            this.c = l.a.a(context);
            this.c.a(string);
            this.c.a(b2, this, new Runnable(this){
                final /* synthetic */ k a;
                {
                    this.a = k2;
                }

                public void run() {
                    this.a.g().a(k.a(this.a).c());
                }
            });
            this.c.a();
            return;
        }
        catch (Exception exception) {
        }
        catch (NoClassDefFoundError noClassDefFoundError) {
            // empty catch block
        }
        var5_7.printStackTrace();
        b2.a(h.a);
    }

    @Override
    protected void b() {
        l l2 = this.c;
        if (l2 != null) {
            try {
                l2.c();
                return;
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

}

