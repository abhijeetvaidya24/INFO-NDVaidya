/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.AlertDialog
 *  android.app.AlertDialog$Builder
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.util.Timer
 *  java.util.TimerTask
 */
package com.applovin.impl.sdk.a;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import com.applovin.impl.sdk.b.b;
import com.applovin.impl.sdk.c.g;
import com.applovin.impl.sdk.c.h;
import com.applovin.impl.sdk.j;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdRewardListener;
import java.util.Timer;
import java.util.TimerTask;

class c {
    private final j a;
    private final com.applovin.impl.sdk.a.a b;
    private final Activity c;
    private final Runnable d;
    private final AppLovinAdRewardListener e;
    private final Timer f;

    private c(a a2) {
        this.a = a2.a;
        this.b = a2.b;
        this.c = a2.c;
        this.d = a2.e;
        this.e = a2.d;
        this.f = new Timer("IncentivizedAdLauncher");
    }

    static a a() {
        return new a();
    }

    void a(final AppLovinAd appLovinAd) {
        this.c.runOnUiThread(new Runnable(){

            public void run() {
                AlertDialog.Builder builder = new AlertDialog.Builder((Context)c.this.c);
                builder.setTitle((CharSequence)c.this.a.a(b.bC));
                builder.setMessage((CharSequence)c.this.a.a(b.bD));
                builder.setCancelable(false);
                builder.setPositiveButton((CharSequence)c.this.a.a(b.bE), new DialogInterface.OnClickListener(){

                    public void onClick(DialogInterface dialogInterface, int n2) {
                        dialogInterface.dismiss();
                        c.this.a.D().a(g.k);
                        c.this.f.schedule(new TimerTask(){

                            public void run() {
                                c.this.c.runOnUiThread(c.this.d);
                            }
                        }, 200L);
                    }

                });
                builder.setNegativeButton((CharSequence)c.this.a.a(b.bF), new DialogInterface.OnClickListener(){

                    public void onClick(DialogInterface dialogInterface, int n2) {
                        dialogInterface.dismiss();
                        c.this.a.D().a(g.l);
                        c.this.b.a(appLovinAd, c.this.e);
                    }
                });
                builder.show();
            }

        });
    }

    static class a {
        private j a;
        private com.applovin.impl.sdk.a.a b;
        private Activity c;
        private AppLovinAdRewardListener d;
        private Runnable e;

        private a() {
        }

        a a(Activity activity) {
            this.c = activity;
            return this;
        }

        a a(com.applovin.impl.sdk.a.a a2) {
            this.b = a2;
            return this;
        }

        a a(j j2) {
            this.a = j2;
            return this;
        }

        a a(AppLovinAdRewardListener appLovinAdRewardListener) {
            this.d = appLovinAdRewardListener;
            return this;
        }

        a a(Runnable runnable) {
            this.e = runnable;
            return this;
        }

        c a() {
            return new c(this);
        }
    }

}

