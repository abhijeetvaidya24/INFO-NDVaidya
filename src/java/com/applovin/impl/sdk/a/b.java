/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.widget.Toast
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.Throwable
 */
package com.applovin.impl.sdk.a;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import com.applovin.adview.AppLovinConfirmationActivity;
import com.applovin.impl.sdk.e.e;
import com.applovin.impl.sdk.j;
import com.applovin.impl.sdk.p;
import com.applovin.sdk.AppLovinSdkUtils;

public class b {
    private final j a;
    private final String b;
    private final Context c;

    public b(j j2, Context context, String string2) {
        this.a = j2;
        this.b = string2;
        this.c = context;
    }

    private void a(String string2, Throwable throwable) {
        this.a.u().c("IncentivizedConfirmationManager", "Unable to show incentivized ad reward dialog. Have you defined com.applovin.adview.AppLovinConfirmationActivity in your manifest?", throwable);
        Toast.makeText((Context)this.c, (CharSequence)string2, (int)1).show();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private String b() {
        com.applovin.impl.sdk.b.b<String> b2;
        j j2;
        if (this.b.equals((Object)"accepted")) {
            j2 = this.a;
            b2 = com.applovin.impl.sdk.b.b.bH;
            do {
                return j2.a(b2);
                break;
            } while (true);
        }
        if (this.b.equals((Object)"quota_exceeded")) {
            j2 = this.a;
            b2 = com.applovin.impl.sdk.b.b.bI;
            return j2.a(b2);
        }
        if (this.b.equals((Object)"rejected")) {
            j2 = this.a;
            b2 = com.applovin.impl.sdk.b.b.bJ;
            return j2.a(b2);
        }
        j2 = this.a;
        b2 = com.applovin.impl.sdk.b.b.bK;
        return j2.a(b2);
    }

    void a() {
        AppLovinSdkUtils.runOnUiThread(new Runnable(){

            public void run() {
                String string2 = b.this.a.a(com.applovin.impl.sdk.b.b.bG);
                String string3 = b.this.b();
                String string4 = b.this.a.a(com.applovin.impl.sdk.b.b.bL);
                if (e.a(AppLovinConfirmationActivity.class, b.this.c)) {
                    try {
                        Intent intent = new Intent(b.this.c, AppLovinConfirmationActivity.class);
                        intent.putExtra("dialog_title", string2);
                        intent.putExtra("dialog_body", string3);
                        intent.putExtra("dialog_button_text", string4);
                        b.this.c.startActivity(intent);
                        return;
                    }
                    catch (Throwable throwable) {
                        b.this.a(string3, throwable);
                        return;
                    }
                }
                b.this.a(string3, null);
            }
        });
    }

}

