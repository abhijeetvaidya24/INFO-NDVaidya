/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.os.Bundle
 *  android.os.Handler
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.Window
 *  android.widget.LinearLayout
 *  android.widget.LinearLayout$LayoutParams
 *  java.lang.Object
 *  java.lang.Runnable
 */
package io.presage.core.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;

public class ABActivity
extends Activity {
    private Handler IIIIIIII;

    protected void onCreate(Bundle bundle) {
        this.requestWindowFeature(1);
        this.getWindow().setFlags(1024, 1024);
        super.onCreate(bundle);
        this.IIIIIIII = new Handler();
        LinearLayout linearLayout = new LinearLayout((Context)this);
        linearLayout.setLayoutParams((ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -1));
        linearLayout.setBackgroundColor(0);
        linearLayout.setClickable(true);
        linearLayout.setOnClickListener(new View.OnClickListener(){

            public final void onClick(View view) {
                ABActivity.this.finish();
            }
        });
        this.setContentView((View)linearLayout);
    }

    protected void onResume() {
        super.onResume();
        this.IIIIIIII.postDelayed(new Runnable(){

            public final void run() {
                ABActivity.this.finish();
            }
        }, 100L);
    }

    protected void onStart() {
        super.onStart();
    }

}

