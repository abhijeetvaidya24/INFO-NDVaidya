/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.util.HashMap
 *  java.util.Map
 */
package com.tappx.a.a.a.b.a;

import android.os.Handler;
import android.os.Looper;
import com.tappx.a.a.a.b.a.c;
import com.tappx.a.a.a.b.a.e;
import java.util.HashMap;
import java.util.Map;

class f {
    private final Map<e<?>, Runnable> a = new HashMap();
    private final Handler b;
    private c c;

    public f() {
        this(new Handler(Looper.getMainLooper()));
    }

    f(Handler handler) {
        this.b = handler;
    }

    public void a(c c2) {
        this.c = c2;
    }

    public void a(final e<?> e2, long l2) {
        Runnable runnable = new Runnable(){

            public void run() {
                if ((Runnable)f.this.a.remove((Object)e2) == null) {
                    return;
                }
                f.this.c.a(e2);
            }
        };
        this.a.put(e2, (Object)runnable);
        this.b.postDelayed(runnable, l2);
    }

    public boolean a(e<?> e2) {
        Runnable runnable = (Runnable)this.a.remove(e2);
        if (runnable == null) {
            return false;
        }
        this.b.removeCallbacks(runnable);
        return true;
    }

}

