/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.AsyncTask
 *  android.os.Build
 *  android.os.Build$VERSION
 *  java.lang.Object
 *  java.lang.Void
 *  java.util.concurrent.Executor
 */
package com.tappx.a.a.a.b;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Build;
import com.tappx.a.a.a.d.ac;
import com.tappx.a.a.a.d.b;
import com.tappx.a.a.a.d.f;
import com.tappx.a.a.a.d.w;
import com.tappx.a.a.a.d.y;
import java.util.concurrent.Executor;

public class a {
    private final Context a;

    public a(Context context) {
        this.a = context.getApplicationContext();
    }

    public void a() {
        a a2 = new a(this.a);
        if (Build.VERSION.SDK_INT >= 11) {
            a2.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, (Object[])new Void[0]);
            return;
        }
        a2.execute((Object[])new Void[0]);
    }

    private static final class a
    extends AsyncTask<Void, Void, Void> {
        private final Context a;

        public a(Context context) {
            this.a = context;
        }

        protected /* varargs */ Void a(Void ... arrvoid) {
            f.a.a(this.a).a();
            ac.a.a(this.a).a();
            y.a.a(this.a).a();
            b.a.a(this.a).a();
            w.b.a(this.a).a();
            return null;
        }

        protected /* synthetic */ Object doInBackground(Object[] arrobject) {
            return this.a((Void[])arrobject);
        }
    }

}

