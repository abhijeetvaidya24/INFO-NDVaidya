/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  android.os.Bundle
 *  android.view.KeyEvent
 *  android.view.Window
 *  java.lang.String
 */
package com.startapp.android.publish.adsCommon.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Window;
import com.startapp.android.publish.ads.a.b;
import com.startapp.android.publish.adsCommon.Utils.i;
import com.startapp.android.publish.adsCommon.c;
import com.startapp.android.publish.common.model.AdPreferences;
import com.startapp.common.a.g;

public class OverlayActivity
extends Activity {
    private b a;
    private boolean b;
    private int c;
    private boolean d;
    private Bundle e;
    private boolean f = false;
    private int g = -1;

    private void a() {
        int n2 = this.getIntent().getIntExtra("placement", 0);
        this.a = b.a(this, this.getIntent(), AdPreferences.Placement.getByIndex(n2));
        if (this.a == null) {
            this.finish();
        }
    }

    public void finish() {
        b b2 = this.a;
        if (b2 != null) {
            b2.q();
        }
        super.finish();
    }

    public void onBackPressed() {
        if (!this.a.r()) {
            super.onBackPressed();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.b) {
            this.a();
            this.a.a(this.e);
            this.a.u();
            this.b = false;
        }
        this.a.a(configuration);
    }

    protected void onCreate(Bundle bundle) {
        this.overridePendingTransition(0, 0);
        super.onCreate(bundle);
        boolean bl = this.getIntent().getBooleanExtra("videoAd", false);
        this.requestWindowFeature(1);
        if (this.getIntent().getBooleanExtra("fullscreen", false) || bl) {
            this.getWindow().setFlags(1024, 1024);
        }
        g.a("AppWallActivity", 2, "AppWallActivity::onCreate");
        this.d = this.getIntent().getBooleanExtra("activityShouldLockOrientation", true);
        if (bundle == null && !bl) {
            com.startapp.common.b.a((Context)this).a(new Intent("com.startapp.android.ShowDisplayBroadcastListener"));
        }
        if (bundle != null) {
            this.g = bundle.getInt("activityLockedOrientation", -1);
            this.d = bundle.getBoolean("activityShouldLockOrientation", true);
        }
        this.c = this.getIntent().getIntExtra("orientation", this.getResources().getConfiguration().orientation);
        int n2 = this.getResources().getConfiguration().orientation;
        int n3 = this.c;
        boolean bl2 = false;
        if (n2 != n3) {
            bl2 = true;
        }
        this.b = bl2;
        if (!this.b) {
            this.a();
            this.a.a(bundle);
            return;
        }
        this.e = bundle;
    }

    protected void onDestroy() {
        g.a("AppWallActivity", 2, "AppWallActivity::onDestroy");
        if (!this.b) {
            this.a.v();
            this.a = null;
            i.a(this, false);
        }
        super.onDestroy();
    }

    public boolean onKeyDown(int n2, KeyEvent keyEvent) {
        b b2 = this.a;
        if (b2 != null && !b2.a(n2, keyEvent)) {
            return super.onKeyDown(n2, keyEvent);
        }
        return true;
    }

    protected void onPause() {
        g.a("AppWallActivity", 2, "OverlayActivity::onPause");
        super.onPause();
        if (!this.b) {
            this.a.s();
            c.a((Context)this);
        }
        this.overridePendingTransition(0, 0);
    }

    protected void onResume() {
        int n2;
        g.a("AppWallActivity", 2, "AppWallActivity::onResume");
        super.onResume();
        if (this.f) {
            this.a.c();
        }
        if ((n2 = this.g) == -1) {
            this.g = i.a(this, this.c, this.d);
        } else {
            com.startapp.common.a.c.a(this, n2);
        }
        if (!this.b) {
            this.a.u();
        }
    }

    protected void onSaveInstanceState(Bundle bundle) {
        g.a("AppWallActivity", 2, "AppWallActivity::onSaveInstanceState");
        super.onSaveInstanceState(bundle);
        if (!this.b) {
            this.a.b(bundle);
            bundle.putInt("activityLockedOrientation", this.g);
            bundle.putBoolean("activityShouldLockOrientation", this.d);
        }
    }

    protected void onStop() {
        g.a("AppWallActivity", 2, "AppWallActivity::onStop");
        super.onStop();
        if (!this.b) {
            this.a.t();
        }
    }
}

