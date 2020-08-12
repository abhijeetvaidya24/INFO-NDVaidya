/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.os.Bundle
 */
package com.tappx.sdk.android;

import android.app.Activity;
import android.os.Bundle;
import com.tappx.a.a.a.h.d;

public class PrivacyConsentActivity
extends Activity {
    private d a;

    public void onBackPressed() {
        if (!this.a.a()) {
            super.onBackPressed();
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.a = new d(this);
        this.a.a(bundle);
    }

    protected void onStop() {
        super.onStop();
        this.a.b();
    }
}

