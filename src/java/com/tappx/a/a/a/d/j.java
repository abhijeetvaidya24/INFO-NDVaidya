/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.View
 *  java.lang.Exception
 *  java.lang.NoClassDefFoundError
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 */
package com.tappx.a.a.a.d;

import android.content.Context;
import android.view.View;
import com.tappx.a.a.a.d.c;
import com.tappx.a.a.a.d.g;
import com.tappx.a.a.a.d.j;
import com.tappx.a.a.a.e.b;
import com.tappx.a.a.a.e.e;
import com.tappx.a.a.a.e.h;
import com.tappx.a.a.b.an;

public class j
extends c<e> {
    private c.b a;
    private e b;
    private g c;

    j(com.tappx.a.a.a.i.a.a a2) {
        super(a2);
    }

    static /* synthetic */ e a(j j2) {
        return j2.b;
    }

    protected void a(Context context, c.b b2, e e2) {
        void var7_9;
        com.tappx.a.a.a.c.a.e("7qjY7245E0dfSy30XptPQ/SJdTfZfiiWf+eZ42wqMQY", new Object[0]);
        this.a = b2;
        this.b = e2;
        String string = e2.h();
        int n2 = e2.k();
        int n3 = e2.j();
        try {
            this.c = g.a.a(context);
            this.c.a(string, n2, n3);
            this.c.a(b2, new Runnable(this){
                final /* synthetic */ j a;
                {
                    this.a = j2;
                }

                public void run() {
                    this.a.a().a(j.a(this.a).c());
                }
            });
            this.c.b();
            return;
        }
        catch (Exception exception) {
        }
        catch (NoClassDefFoundError noClassDefFoundError) {
            // empty catch block
        }
        var7_9.printStackTrace();
        b2.a(h.a);
    }

    @Override
    protected /* synthetic */ void b(Context context, c.b b2, b b3) {
        this.a(context, b2, (e)b3);
    }

    @Override
    protected void c() {
        g g2 = this.c;
        if (g2 != null) {
            an.a(g2.c());
            try {
                this.c.a(null, null);
                this.c.a();
                return;
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

}

