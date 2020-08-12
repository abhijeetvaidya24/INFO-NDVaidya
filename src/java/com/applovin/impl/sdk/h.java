/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.AlertDialog
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.concurrent.atomic.AtomicBoolean
 */
package com.applovin.impl.sdk;

import android.app.AlertDialog;
import com.applovin.impl.sdk.e.k;
import com.applovin.impl.sdk.h;
import com.applovin.impl.sdk.i;
import com.applovin.impl.sdk.j;
import com.applovin.impl.sdk.p;
import com.applovin.impl.sdk.t;
import java.util.concurrent.atomic.AtomicBoolean;

class h
implements t.a {
    private static AlertDialog b;
    private static final AtomicBoolean c;
    private final i a;
    private k d;

    static {
        c = new AtomicBoolean();
    }

    h(i i2, j j2) {
        this.a = i2;
        j2.Q().a(this);
    }

    static /* synthetic */ AlertDialog a(AlertDialog alertDialog) {
        b = alertDialog;
        return alertDialog;
    }

    static /* synthetic */ i a(h h2) {
        return h2.a;
    }

    static /* synthetic */ AtomicBoolean a() {
        return c;
    }

    static /* synthetic */ AlertDialog d() {
        return b;
    }

    public void a(long l2, j j2, a a2) {
        if (l2 <= 0L) {
            return;
        }
        AlertDialog alertDialog = b;
        if (alertDialog != null && alertDialog.isShowing()) {
            return;
        }
        if (c.getAndSet(true)) {
            if (l2 < this.d.a()) {
                p p2 = j2.u();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Scheduling consent alert earlier (");
                stringBuilder.append(l2);
                stringBuilder.append("ms) than remaining scheduled time (");
                stringBuilder.append(this.d.a());
                stringBuilder.append("ms)");
                p2.a("ConsentAlertManager", stringBuilder.toString());
                this.d.d();
            } else {
                p p3 = j2.u();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Skip scheduling consent alert - one scheduled already with remaining time of ");
                stringBuilder.append(this.d.a());
                stringBuilder.append(" milliseconds");
                p3.c("ConsentAlertManager", stringBuilder.toString());
                return;
            }
        }
        p p4 = j2.u();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Scheduling consent alert for ");
        stringBuilder.append(l2);
        stringBuilder.append(" milliseconds");
        p4.a("ConsentAlertManager", stringBuilder.toString());
        this.d = k.a(l2, j2, new Runnable(this, j2, a2){
            final /* synthetic */ j a;
            final /* synthetic */ a b;
            final /* synthetic */ h c;
            {
                this.c = h2;
                this.a = j2;
                this.b = a2;
            }

            public void run() {
                p p2;
                String string;
                if (h.a(this.c).c()) {
                    this.a.u().d("ConsentAlertManager", "Consent dialog already showing, skip showing of consent alert");
                    return;
                }
                android.app.Activity activity = this.a.S().a();
                if (activity != null && com.applovin.impl.sdk.e.f.a(this.a.w(), this.a)) {
                    com.applovin.sdk.AppLovinSdkUtils.runOnUiThread(new Runnable(this){
                        final /* synthetic */ 1 a;
                        {
                            this.a = var1_1;
                        }

                        public void run() {
                            h.a(new android.app.AlertDialog$Builder((android.content.Context)this.a.a.S().a()).setTitle((java.lang.CharSequence)this.a.a.a(com.applovin.impl.sdk.b.b.av)).setMessage((java.lang.CharSequence)this.a.a.a(com.applovin.impl.sdk.b.b.aw)).setCancelable(false).setPositiveButton((java.lang.CharSequence)this.a.a.a(com.applovin.impl.sdk.b.b.ax), new android.content.DialogInterface$OnClickListener(this){
                                final /* synthetic */ com.applovin.impl.sdk.h$1$1 a;
                                {
                                    this.a = var1_1;
                                }

                                public void onClick(android.content.DialogInterface dialogInterface, int n2) {
                                    this.a.a.b.a();
                                    dialogInterface.dismiss();
                                    h.a().set(false);
                                }
                            }).setNegativeButton((java.lang.CharSequence)this.a.a.a(com.applovin.impl.sdk.b.b.ay), new android.content.DialogInterface$OnClickListener(this){
                                final /* synthetic */ com.applovin.impl.sdk.h$1$1 a;
                                {
                                    this.a = var1_1;
                                }

                                public void onClick(android.content.DialogInterface dialogInterface, int n2) {
                                    this.a.a.b.b();
                                    dialogInterface.dismiss();
                                    h.a().set(false);
                                    long l2 = this.a.a.a.a(com.applovin.impl.sdk.b.b.at);
                                    this.a.a.c.a(l2, this.a.a.a, this.a.a.b);
                                }
                            }).create());
                            h.d().show();
                        }
                    });
                    return;
                }
                if (activity == null) {
                    p2 = this.a.u();
                    string = "No parent Activity found - rescheduling consent alert...";
                } else {
                    p2 = this.a.u();
                    string = "No internet available - rescheduling consent alert...";
                }
                p2.d("ConsentAlertManager", string);
                h.a().set(false);
                long l2 = this.a.a(com.applovin.impl.sdk.b.b.au);
                this.c.a(l2, this.a, this.b);
            }
        });
    }

    @Override
    public void b() {
        k k2 = this.d;
        if (k2 != null) {
            k2.b();
        }
    }

    @Override
    public void c() {
        k k2 = this.d;
        if (k2 != null) {
            k2.c();
        }
    }

}

