/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.view.Window
 */
package com.tappx.sdk.android;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import com.tappx.a.a.b.a.a;

public class BaseAdActivity
extends Activity {
    private a a;

    private void a() {
        if (Build.VERSION.SDK_INT >= 14) {
            this.getWindow().setFlags(16777216, 16777216);
        }
    }

    public void onBackPressed() {
        if (this.a.d()) {
            super.onBackPressed();
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.a = new a(this);
        this.a.a(bundle);
        this.a();
    }

    protected void onDestroy() {
        super.onDestroy();
        this.a.c();
    }

    protected void onPause() {
        super.onPause();
        this.a.a();
    }

    protected void onResume() {
        super.onResume();
        this.a.b();
    }
}

