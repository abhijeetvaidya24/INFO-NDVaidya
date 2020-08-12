/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.tapjoy.internal.df$a
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.concurrent.locks.ReentrantLock
 */
package com.tapjoy.internal;

import com.tapjoy.internal.cs;
import com.tapjoy.internal.df;
import com.tapjoy.internal.dh;
import com.tapjoy.internal.di;
import java.util.concurrent.locks.ReentrantLock;

/*
 * Exception performing whole class analysis.
 */
public abstract class df
implements di {
    private final ReentrantLock a;
    private final a b;
    private final a c;
    private di.a d;
    private boolean e;

    public df() {
        this.a = new ReentrantLock();
        this.b = new /* Unavailable Anonymous Inner Class!! */;
        this.c = new /* Unavailable Anonymous Inner Class!! */;
        this.d = di.a.a;
        this.e = false;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private dh g() {
        this.a.lock();
        try {
            try {
                if (this.d == di.a.a) {
                    this.d = di.a.e;
                    this.b.a((Object)di.a.e);
                    this.c.a((Object)di.a.e);
                } else if (this.d == di.a.b) {
                    this.e = true;
                    this.b.a((Object)di.a.d);
                } else if (this.d == di.a.c) {
                    this.d = di.a.d;
                    this.b();
                }
            }
            catch (Throwable throwable3) {
                this.a(throwable3);
            }
        }
        catch (Throwable throwable2) {}
        this.a.unlock();
        return this.c;
        this.a.unlock();
        throw throwable2;
    }

    protected abstract void a();

    protected final void a(Throwable throwable) {
        cs.a((Object)((Object)throwable));
        this.a.lock();
        try {
            block10 : {
                block7 : {
                    block9 : {
                        block8 : {
                            block6 : {
                                if (this.d != di.a.b) break block6;
                                this.b.a(throwable);
                                this.c.a((Throwable)new Exception("Service failed to start.", throwable));
                                break block7;
                            }
                            if (this.d != di.a.d) break block8;
                            this.c.a(throwable);
                            break block7;
                        }
                        if (this.d != di.a.c) break block9;
                        this.c.a((Throwable)new Exception("Service failed while running", throwable));
                        break block7;
                    }
                    if (this.d == di.a.a || this.d == di.a.e) break block10;
                }
                this.d = di.a.f;
                return;
            }
            StringBuilder stringBuilder = new StringBuilder("Failed while in state:");
            stringBuilder.append((Object)((Object)this.d));
            throw new IllegalStateException(stringBuilder.toString(), throwable);
        }
        finally {
            this.a.unlock();
        }
    }

    protected abstract void b();

    protected final void c() {
        this.a.lock();
        try {
            if (this.d == di.a.b) {
                this.d = di.a.c;
                if (this.e) {
                    this.g();
                } else {
                    this.b.a((Object)((Object)di.a.c));
                }
                return;
            }
            StringBuilder stringBuilder = new StringBuilder("Cannot notifyStarted() when the service is ");
            stringBuilder.append((Object)((Object)this.d));
            IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.toString());
            this.a((Throwable)illegalStateException);
            throw illegalStateException;
        }
        finally {
            this.a.unlock();
        }
    }

    protected final void d() {
        this.a.lock();
        try {
            if (this.d != di.a.d && this.d != di.a.c) {
                StringBuilder stringBuilder = new StringBuilder("Cannot notifyStopped() when the service is ");
                stringBuilder.append((Object)((Object)this.d));
                IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.toString());
                this.a((Throwable)illegalStateException);
                throw illegalStateException;
            }
            this.d = di.a.e;
            this.c.a((Object)((Object)di.a.e));
            return;
        }
        finally {
            this.a.unlock();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public final dh e() {
        this.a.lock();
        try {
            try {
                if (this.d == di.a.a) {
                    this.d = di.a.b;
                    this.a();
                }
            }
            catch (Throwable throwable3) {
                this.a(throwable3);
            }
        }
        catch (Throwable throwable2) {}
        this.a.unlock();
        return this.b;
        this.a.unlock();
        throw throwable2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public final di.a f() {
        this.a.lock();
        try {
            di.a a2 = !this.e || this.d != di.a.b ? this.d : di.a.d;
            return a2;
        }
        finally {
            this.a.unlock();
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getClass().getSimpleName());
        stringBuilder.append(" [");
        stringBuilder.append((Object)((Object)this.f()));
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}

