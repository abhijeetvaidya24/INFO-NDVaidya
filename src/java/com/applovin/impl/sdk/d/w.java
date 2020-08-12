/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  java.lang.CharSequence
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.concurrent.TimeUnit
 *  org.json.JSONObject
 */
package com.applovin.impl.sdk.d;

import android.text.TextUtils;
import com.applovin.impl.sdk.b.b;
import com.applovin.impl.sdk.b.c;
import com.applovin.impl.sdk.c.i;
import com.applovin.impl.sdk.d.a;
import com.applovin.impl.sdk.d.q;
import com.applovin.impl.sdk.j;
import com.applovin.impl.sdk.network.a;
import com.applovin.impl.sdk.p;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

public abstract class w<T>
extends a
implements a.b<T> {
    private final com.applovin.impl.sdk.network.b<T> a;
    private final a.b<T> c;
    protected a.a d;
    private q.a e = q.a.c;
    private b<String> f = null;
    private b<String> g = null;

    public w(com.applovin.impl.sdk.network.b<T> b2, j j2) {
        this(b2, j2, false);
    }

    public w(com.applovin.impl.sdk.network.b<T> b2, final j j2, boolean bl) {
        super("TaskRepeatRequest", j2, bl);
        if (b2 != null) {
            this.a = b2;
            this.d = new a.a();
            this.c = new a.b<T>(){

                @Override
                public void a(int n2) {
                    boolean bl = n2 < 200 || n2 >= 500;
                    boolean bl2 = false;
                    if (n2 != -103) {
                        bl2 = true;
                    }
                    if (bl && bl2) {
                        b b2;
                        w w2;
                        String string = w.this.a.e();
                        if (w.this.a.i() > 0) {
                            w w3 = w.this;
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("Unable to send request due to server failure (code ");
                            stringBuilder.append(n2);
                            stringBuilder.append("). ");
                            stringBuilder.append(w.this.a.i());
                            stringBuilder.append(" attempts left, retrying in ");
                            stringBuilder.append(TimeUnit.MILLISECONDS.toSeconds((long)w.this.a.k()));
                            stringBuilder.append(" seconds...");
                            w3.c(stringBuilder.toString());
                            int n3 = w.this.a.i() - 1;
                            w.this.a.a(n3);
                            if (n3 == 0) {
                                w w4 = w.this;
                                w4.c(w4.f);
                                if (com.applovin.impl.sdk.e.j.b(string) && string.length() >= 4) {
                                    w.this.a.a(string);
                                    w w5 = w.this;
                                    StringBuilder stringBuilder2 = new StringBuilder();
                                    stringBuilder2.append("Switching to backup endpoint ");
                                    stringBuilder2.append(string);
                                    w5.b(stringBuilder2.toString());
                                }
                            }
                            q q2 = j2.C();
                            w w6 = w.this;
                            q2.a(w6, w6.e, w.this.a.k());
                            return;
                        }
                        if (string != null && string.equals((Object)w.this.a.a())) {
                            w2 = w.this;
                            b2 = w2.g;
                        } else {
                            w2 = w.this;
                            b2 = w2.f;
                        }
                        w2.c(b2);
                    }
                    w.this.a(n2);
                }

                @Override
                public void a(T t2, int n2) {
                    w.this.a.a(0);
                    w.this.a(t2, n2);
                }
            };
            return;
        }
        throw new IllegalArgumentException("No request specified");
    }

    private <ST> void c(b<ST> b2) {
        if (b2 != null) {
            c c2 = this.b().v();
            c2.a(b2, b2.b());
            c2.a();
        }
    }

    @Override
    public i a() {
        return i.e;
    }

    @Override
    public void a(int n2) {
    }

    public void a(b<String> b2) {
        this.f = b2;
    }

    public void a(q.a a2) {
        this.e = a2;
    }

    @Override
    public void a(T t2, int n2) {
    }

    public void b(b<String> b2) {
        this.g = b2;
    }

    public void run() {
        int n2;
        com.applovin.impl.sdk.network.a a2 = this.b().B();
        if (!this.b().c() && !this.b().d()) {
            this.d("AppLovin SDK is disabled: please check your connection");
            this.b().u().e("AppLovinSdk", "AppLovin SDK is disabled: please check your connection");
            n2 = -22;
        } else {
            if (com.applovin.impl.sdk.e.j.b(this.a.a()) && this.a.a().length() >= 4) {
                if (TextUtils.isEmpty((CharSequence)this.a.c())) {
                    String string = this.a.d() != null ? "POST" : "GET";
                    this.a.b(string);
                }
                a2.a(this.a, this.d, this.c);
                return;
            }
            this.d("Task has an invalid or null request endpoint.");
            n2 = -900;
        }
        this.a(n2);
    }

}

