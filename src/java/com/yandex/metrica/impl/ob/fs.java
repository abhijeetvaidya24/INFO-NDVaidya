/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.HandlerThread
 *  android.os.Looper
 *  android.os.Message
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Thread
 *  java.lang.Thread$State
 */
package com.yandex.metrica.impl.ob;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.yandex.metrica.impl.ob.fq;
import com.yandex.metrica.impl.ob.fr;
import com.yandex.metrica.impl.ob.ft;
import com.yandex.metrica.impl.ob.fu;

public class fs {
    private fq a;
    private HandlerThread b;
    private b c;
    private volatile Handler d;

    public fs(fq fq2) {
        this(fq2, null);
    }

    public fs(fq fq2, Handler handler) {
        this.a = fq2;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(fs.class.getSimpleName());
        stringBuilder.append('@');
        stringBuilder.append(Integer.toHexString((int)this.hashCode()));
        this.b = new HandlerThread(stringBuilder.toString());
        this.d = handler;
    }

    private void a() {
        fs fs2 = this;
        synchronized (fs2) {
            if (this.b.getState() == Thread.State.NEW) {
                this.b.start();
                Looper looper = this.b.getLooper();
                this.c = new b(looper, 0);
                if (this.d == null) {
                    this.d = new Handler(looper);
                }
            }
            return;
        }
    }

    public <T> void a(fu<T> fu2, fu.b<T> b2, fu.a a2) {
        this.a();
        fu2.a(b2);
        fu2.a(a2);
        this.c.a(fu2);
    }

    private static class a
    implements Runnable {
        private fu.a a;
        private fr b;

        private a(fu.a a2, fr fr2) {
            this.a = a2;
            this.b = fr2;
        }

        /* synthetic */ a(fu.a a2, fr fr2, byte by) {
            this(a2, fr2);
        }

        public void run() {
            fu.a a2 = this.a;
            if (a2 != null) {
                a2.a(this.b);
            }
        }
    }

    private class b
    extends Handler {
        private b(Looper looper) {
            super(looper);
        }

        /* synthetic */ b(Looper looper, byte by) {
            this(looper);
        }

        public <T> void a(fu<T> fu2) {
            Message message = new Message();
            message.obj = fu2;
            this.sendMessage(message);
        }

        public void handleMessage(Message message) {
            fu fu2 = (fu)message.obj;
            fu.b b2 = fu2.e();
            try {
                Object t2 = fu2.b(fs.this.a.a(fu2));
                fs.this.d.post(new c(b2, t2, 0));
                return;
            }
            catch (fr fr2) {
                fu.a a2 = fu2.f();
                fs.this.d.post((Runnable)new a(a2, fr2, 0));
                return;
            }
        }
    }

    private static class c<T>
    implements Runnable {
        private fu.b<T> a;
        private T b;

        private c(fu.b b2, T t2) {
            this.a = b2;
            this.b = t2;
        }

        /* synthetic */ c(fu.b b2, Object object, byte by) {
            this(b2, object);
        }

        public void run() {
            fu.b<T> b2 = this.a;
            if (b2 != null) {
                b2.a(this.b);
            }
        }
    }

}

