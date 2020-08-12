/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.util.concurrent.Executor
 */
package com.tappx.b;

import android.os.Handler;
import com.tappx.b.f;
import com.tappx.b.n;
import com.tappx.b.p;
import com.tappx.b.q;
import com.tappx.b.u;
import java.util.concurrent.Executor;

public class f
implements q {
    private final Executor a;

    public f(Handler handler) {
        this.a = new Executor(this, handler){
            final /* synthetic */ Handler a;
            final /* synthetic */ f b;
            {
                this.b = f2;
                this.a = handler;
            }

            public void execute(Runnable runnable) {
                this.a.post(runnable);
            }
        };
    }

    public f(Executor executor) {
        this.a = executor;
    }

    @Override
    public void a(n<?> n2, p<?> p2) {
        this.a(n2, p2, null);
    }

    @Override
    public void a(n<?> n2, p<?> p2, Runnable runnable) {
        n2.z();
        n2.a("post-response");
        this.a.execute(new Runnable(n2, p2, runnable){
            private final n b;
            private final p c;
            private final Runnable d;
            {
                this.b = n2;
                this.c = p2;
                this.d = runnable;
            }

            public void run() {
                if (this.b.o()) {
                    this.b.b("canceled-at-delivery");
                    return;
                }
                if (this.c.a()) {
                    this.b.a(this.c.a);
                } else {
                    this.b.c(this.c.c);
                }
                if (this.c.d) {
                    this.b.a("intermediate-response");
                } else {
                    this.b.b("done");
                }
                Runnable runnable = this.d;
                if (runnable != null) {
                    runnable.run();
                }
            }
        });
    }

    @Override
    public void a(n<?> n2, u u2) {
        n2.a("post-error");
        p p2 = p.a(u2);
        this.a.execute(new /* invalid duplicate definition of identical inner class */);
    }

}

