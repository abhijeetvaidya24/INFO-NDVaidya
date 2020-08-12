/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.app.AlertDialog
 *  android.app.AlertDialog$Builder
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnCancelListener
 *  android.content.DialogInterface$OnClickListener
 *  android.os.Build
 *  android.os.Build$VERSION
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  org.json.JSONObject
 */
package com.adcolony.sdk;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import com.adcolony.sdk.a;
import com.adcolony.sdk.ad;
import com.adcolony.sdk.af;
import com.adcolony.sdk.au;
import com.adcolony.sdk.o;
import com.adcolony.sdk.w;
import org.json.JSONObject;

class o {
    private ad b;
    private AlertDialog c;
    private boolean d;

    o() {
        a.a("Alert.show", new af(this){
            final /* synthetic */ o a;
            {
                this.a = o2;
            }

            public void a(ad ad2) {
                if (a.d() && a.c() instanceof android.app.Activity) {
                    if (w.d(ad2.c(), "on_resume")) {
                        o.a(this.a, ad2);
                        return;
                    }
                    this.a.a(ad2);
                    return;
                }
                new com.adcolony.sdk.y$a().a("Missing Activity reference, can't build AlertDialog.").a(com.adcolony.sdk.y.g);
            }
        });
    }

    static /* synthetic */ ad a(o o2, ad ad2) {
        o2.b = ad2;
        return ad2;
    }

    void a() {
        ad ad2 = this.b;
        if (ad2 != null) {
            this.a(ad2);
            this.b = null;
        }
    }

    void a(AlertDialog alertDialog) {
        this.c = alertDialog;
    }

    @SuppressLint(value={"InlinedApi"})
    void a(final ad ad2) {
        Context context = a.c();
        if (context == null) {
            return;
        }
        final AlertDialog.Builder builder = Build.VERSION.SDK_INT >= 21 ? new AlertDialog.Builder(context, 16974374) : new AlertDialog.Builder(context, 16974126);
        JSONObject jSONObject = ad2.c();
        String string = w.b(jSONObject, "message");
        String string2 = w.b(jSONObject, "title");
        String string3 = w.b(jSONObject, "positive");
        String string4 = w.b(jSONObject, "negative");
        builder.setMessage((CharSequence)string);
        builder.setTitle((CharSequence)string2);
        builder.setPositiveButton((CharSequence)string3, new DialogInterface.OnClickListener(){

            public void onClick(DialogInterface dialogInterface, int n2) {
                o.this.c = null;
                dialogInterface.dismiss();
                JSONObject jSONObject = w.a();
                w.a(jSONObject, "positive", true);
                o.this.d = false;
                ad2.a(jSONObject).b();
            }
        });
        if (!string4.equals((Object)"")) {
            builder.setNegativeButton((CharSequence)string4, new DialogInterface.OnClickListener(){

                public void onClick(DialogInterface dialogInterface, int n2) {
                    o.this.c = null;
                    dialogInterface.dismiss();
                    JSONObject jSONObject = w.a();
                    w.a(jSONObject, "positive", false);
                    o.this.d = false;
                    ad2.a(jSONObject).b();
                }
            });
        }
        builder.setOnCancelListener(new DialogInterface.OnCancelListener(){

            public void onCancel(DialogInterface dialogInterface) {
                o.this.c = null;
                o.this.d = false;
                JSONObject jSONObject = w.a();
                w.a(jSONObject, "positive", false);
                ad2.a(jSONObject).b();
            }
        });
        au.a(new Runnable(){

            public void run() {
                o.this.d = true;
                o.this.c = builder.show();
            }
        });
    }

    AlertDialog b() {
        return this.c;
    }

    boolean c() {
        return this.d;
    }

}

