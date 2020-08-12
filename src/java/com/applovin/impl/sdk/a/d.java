/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.AlertDialog
 *  android.app.AlertDialog$Builder
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  com.applovin.impl.adview.k
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 */
package com.applovin.impl.sdk.a;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import com.applovin.impl.adview.k;
import com.applovin.impl.sdk.b.b;
import com.applovin.impl.sdk.j;

public class d {
    private final j a;
    private final k b;
    private AlertDialog c;

    public d(k k2, j j2) {
        this.a = j2;
        this.b = k2;
    }

    public void a() {
        this.b.runOnUiThread(new Runnable(){

            public void run() {
                if (d.this.c != null) {
                    d.this.c.dismiss();
                }
            }
        });
    }

    public void b() {
        this.b.runOnUiThread(new Runnable(){

            public void run() {
                AlertDialog.Builder builder = new AlertDialog.Builder((Context)d.this.b);
                builder.setTitle((CharSequence)d.this.a.a(b.bN));
                builder.setMessage((CharSequence)d.this.a.a(b.bO));
                builder.setCancelable(false);
                builder.setPositiveButton((CharSequence)d.this.a.a(b.bQ), new DialogInterface.OnClickListener(){

                    public void onClick(DialogInterface dialogInterface, int n2) {
                        d.this.b.continueVideo();
                        d.this.b.resumeReportRewardTask();
                    }
                });
                builder.setNegativeButton((CharSequence)d.this.a.a(b.bP), new DialogInterface.OnClickListener(){

                    public void onClick(DialogInterface dialogInterface, int n2) {
                        d.this.b.skipVideo();
                        d.this.b.resumeReportRewardTask();
                    }
                });
                d.this.c = builder.show();
            }

        });
    }

    public void c() {
        this.b.runOnUiThread(new Runnable(){

            public void run() {
                AlertDialog.Builder builder = new AlertDialog.Builder((Context)d.this.b);
                builder.setTitle((CharSequence)d.this.a.a(b.bS));
                builder.setMessage((CharSequence)d.this.a.a(b.bT));
                builder.setCancelable(false);
                builder.setPositiveButton((CharSequence)d.this.a.a(b.bV), null);
                builder.setNegativeButton((CharSequence)d.this.a.a(b.bU), new DialogInterface.OnClickListener(){

                    public void onClick(DialogInterface dialogInterface, int n2) {
                        d.this.b.dismiss();
                    }
                });
                d.this.c = builder.show();
            }

        });
    }

    public boolean d() {
        AlertDialog alertDialog = this.c;
        if (alertDialog != null) {
            return alertDialog.isShowing();
        }
        return false;
    }

}

