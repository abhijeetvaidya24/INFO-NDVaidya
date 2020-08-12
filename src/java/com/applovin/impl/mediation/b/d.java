/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 *  java.util.concurrent.atomic.AtomicInteger
 */
package com.applovin.impl.mediation.b;

import com.applovin.impl.sdk.b.b;
import com.applovin.impl.sdk.c.i;
import com.applovin.impl.sdk.d.a;
import com.applovin.impl.sdk.d.q;
import com.applovin.impl.sdk.e.j;
import com.applovin.impl.sdk.network.PostbackServiceImpl;
import com.applovin.impl.sdk.network.e;
import com.applovin.impl.sdk.network.f;
import com.applovin.sdk.AppLovinPostbackListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class d
extends a {
    private final String a;
    private final String c;
    private final com.applovin.impl.mediation.a.e d;
    private final Map<String, String> e;
    private final String f;
    private final String g;
    private final boolean h;

    public d(String string, Map<String, String> map, int n2, String string2, com.applovin.impl.mediation.a.e e2, com.applovin.impl.sdk.j j2) {
        super("TaskFireMediationPostbacks", j2);
        this.a = string;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append("_urls");
        this.c = stringBuilder.toString();
        this.e = map;
        this.f = String.valueOf((int)n2);
        this.g = j.c(string2);
        this.d = e2;
        this.h = e2.d(this.c);
    }

    private f a(String string, String string2, String string3) {
        String string4 = this.c(string, string2, string3);
        return f.b(this.b()).d(string4).b(false).b();
    }

    private e b(String string, String string2, String string3) {
        String string4 = this.c(string, string2, string3);
        return e.j().a(string4).a(false).a();
    }

    private String c(String string, String string2, String string3) {
        return string.replace((CharSequence)"{ERROR_CODE}", (CharSequence)string2).replace((CharSequence)"{ERROR_MESSAGE}", (CharSequence)j.e(string3));
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void f() {
        try {
            final List<String> list = this.d.b(this.c, this.e);
            if (list != null && !list.isEmpty()) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Firing ");
                stringBuilder.append(list.size());
                stringBuilder.append(" '");
                stringBuilder.append(this.a);
                stringBuilder.append("' postback(s)");
                this.a(stringBuilder.toString());
                final AtomicInteger atomicInteger = new AtomicInteger();
                Iterator iterator = list.iterator();
                while (iterator.hasNext()) {
                    f f2 = this.a((String)iterator.next(), this.f, this.g);
                    this.b().J().dispatchPostbackRequest(f2, q.a.m, new AppLovinPostbackListener(){

                        @Override
                        public void onPostbackFailure(String string, int n2) {
                            d d2 = d.this;
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("Failed to fire postback: ");
                            stringBuilder.append(string);
                            d2.d(stringBuilder.toString());
                        }

                        @Override
                        public void onPostbackSuccess(String string) {
                            d d2 = d.this;
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("Successfully fired postback: ");
                            stringBuilder.append(string);
                            d2.a(stringBuilder.toString());
                            if (atomicInteger.incrementAndGet() == list.size()) {
                                d.this.h();
                            }
                        }
                    });
                }
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("No postbacks to fire for event: ");
            stringBuilder.append(this.a);
            this.a(stringBuilder.toString());
            return;
        }
        catch (Throwable throwable) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unable to create postback URL for mediated '");
            stringBuilder.append(this.a);
            stringBuilder.append("'");
            this.a(stringBuilder.toString(), throwable);
        }
    }

    private void g() {
        block5 : {
            try {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(this.d.b(this.c, this.e));
                if (this.h) {
                    arrayList.addAll(this.d.a(this.c, this.e));
                }
                if (!arrayList.isEmpty()) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Firing ");
                    stringBuilder.append(arrayList.size());
                    stringBuilder.append(" '");
                    stringBuilder.append(this.a);
                    stringBuilder.append("' persistent postback(s)");
                    this.a(stringBuilder.toString());
                    Iterator iterator = arrayList.iterator();
                    while (iterator.hasNext()) {
                        e e2 = this.b((String)iterator.next(), this.f, this.g);
                        this.b().F().a(e2);
                    }
                    break block5;
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("No persistent postbacks to fire for event: ");
                stringBuilder.append(this.a);
                this.a(stringBuilder.toString());
                return;
            }
            catch (Throwable throwable) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unable to create persistent postback URL for mediated '");
                stringBuilder.append(this.a);
                stringBuilder.append("'");
                this.a(stringBuilder.toString(), throwable);
            }
        }
    }

    private void h() {
        if (this.h) {
            List<String> list = this.d.a(this.c, this.e);
            if (list != null && !list.isEmpty()) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Firing ");
                stringBuilder.append(list.size());
                stringBuilder.append(" '");
                stringBuilder.append(this.a);
                stringBuilder.append("' successive postback(s)");
                this.a(stringBuilder.toString());
                Iterator iterator = list.iterator();
                while (iterator.hasNext()) {
                    f f2 = this.a((String)iterator.next(), this.f, this.g);
                    this.b().J().dispatchPostbackRequest(f2, q.a.m, null);
                }
            } else {
                this.a("Skip firing of successive urls - none found");
            }
        }
    }

    @Override
    public i a() {
        return i.I;
    }

    public void run() {
        if (this.b().a(com.applovin.impl.sdk.b.a.i).booleanValue()) {
            this.g();
            return;
        }
        this.f();
    }

}

