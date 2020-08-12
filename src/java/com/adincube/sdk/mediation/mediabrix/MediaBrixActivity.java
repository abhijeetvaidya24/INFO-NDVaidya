/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Bundle
 *  com.adincube.sdk.h.c.b
 *  com.adincube.sdk.mediation.mediabrix.MediaBrixActivity$1
 *  com.adincube.sdk.mediation.n.a
 *  com.adincube.sdk.mediation.n.b
 *  com.adincube.sdk.mediation.v.a
 *  com.adincube.sdk.mediation.v.b
 *  com.mediabrix.android.api.MediabrixAPI
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.Set
 */
package com.adincube.sdk.mediation.mediabrix;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.adincube.sdk.mediation.j;
import com.adincube.sdk.mediation.mediabrix.MediaBrixActivity;
import com.adincube.sdk.mediation.mediabrix.a;
import com.adincube.sdk.mediation.mediabrix.b;
import com.adincube.sdk.util.ErrorReportingHelper;
import com.mediabrix.android.api.MediabrixAPI;
import java.util.Set;

public class MediaBrixActivity
extends Activity {
    private b a = b.a();
    private a b = a.a();
    private com.adincube.sdk.h.c.b c = null;
    private String d = null;
    private boolean e = true;
    private final b.a f = new 1(this);

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private void a(Throwable var1_1) {
        this.finish();
        if (this.d == null) return;
        var3_2 = this.a;
        var4_3 = this.d;
        {
            catch (Throwable var2_7) {
                com.adincube.sdk.util.a.c("MediaBrixActivity.finishWithError", new Object[]{var2_7});
                ErrorReportingHelper.report("MediaBrixActivity.finishWithError", this.c, var2_7);
                return;
            }
        }
        try {
            if (var3_2.c != null && var3_2.c.equals((Object)var4_3)) {
                var8_4 = new j((com.adincube.sdk.mediation.b)var3_2.a, j.a.d, var1_1);
                if (var3_2.g != null) {
                    var3_2.g.a(var3_2.a, var8_4);
                }
            }
            if (var3_2.d != null && var3_2.d.equals((Object)var4_3)) {
                var7_5 = new j((com.adincube.sdk.mediation.b)var3_2.a, j.a.d, var1_1);
                if (var3_2.h != null) {
                    var3_2.h.a(var3_2.b, var7_5);
                }
            }
            ** GOTO lbl24
        }
        catch (Throwable var5_6) {
            new Object[1][0] = var5_6;
            ErrorReportingHelper.report("MediaBrixEventListenerAdapter.onAdDisplayError", var5_6);
lbl24: // 2 sources:
            this.a.onAdClosed(this.d);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    protected void onCreate(Bundle bundle) {
        b.a a2;
        b b2;
        super.onCreate(bundle);
        try {
            Set<b.a> set;
            this.c = com.adincube.sdk.h.c.b.a((String)this.getIntent().getStringExtra("at"));
            this.d = this.getIntent().getStringExtra("t");
            if (this.d == null) throw new Exception("target must not be null.");
            if (bundle != null) {
                this.e = bundle.getBoolean("fs");
            }
            new com.adincube.sdk.util.b((Context)this).a(this.getIntent().getExtras());
            b2 = this.a;
            a2 = this.f;
            Set<b.a> set2 = set = b2.j;
            // MONITORENTER : set2
        }
        catch (Throwable throwable) {
            com.adincube.sdk.util.a.c("MediaBrixActivity.onCreate", new Object[]{throwable});
            ErrorReportingHelper.report("MediaBrixActivity.onCreate", this.c, throwable);
            this.a(throwable);
            return;
        }
        b2.j.add((Object)a2);
        // MONITOREXIT : set2
    }

    protected void onPause() {
        super.onPause();
        try {
            this.b.b((Context)this);
            return;
        }
        catch (Throwable throwable) {
            com.adincube.sdk.util.a.c("MediaBrixActivity.onPause", new Object[]{throwable});
            ErrorReportingHelper.report("MediaBrixActivity.onPause", this.c, throwable);
            this.a(throwable);
            return;
        }
    }

    protected void onResume() {
        super.onResume();
        try {
            this.b.a((Context)this);
            if (this.e) {
                this.e = false;
                MediabrixAPI.getInstance().show((Context)this, this.d);
            }
            return;
        }
        catch (Throwable throwable) {
            com.adincube.sdk.util.a.c("MediaBrixActivity.onResume", new Object[]{throwable});
            ErrorReportingHelper.report("MediaBrixActivity.onResume", this.c, throwable);
            this.a(throwable);
            return;
        }
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        try {
            bundle.putBoolean("fs", this.e);
            return;
        }
        catch (Throwable throwable) {
            com.adincube.sdk.util.a.c("MediaBrixActivity.onSaveInstanceState", new Object[]{throwable});
            ErrorReportingHelper.report("MediaBrixActivity.onSaveInstanceState", this.c, throwable);
            this.a(throwable);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    protected void onStop() {
        b b2;
        b.a a2;
        super.onStop();
        try {
            Set<b.a> set;
            if (!this.isFinishing()) return;
            b2 = this.a;
            a2 = this.f;
            Set<b.a> set2 = set = b2.j;
            // MONITORENTER : set2
        }
        catch (Throwable throwable) {
            com.adincube.sdk.util.a.c("MediaBrixActivity.onStop", new Object[]{throwable});
            ErrorReportingHelper.report("MediaBrixActivity.onStop", this.c, throwable);
            this.a(throwable);
            return;
        }
        b2.j.remove((Object)a2);
        // MONITOREXIT : set2
    }
}

