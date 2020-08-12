/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.net.Uri
 *  com.adincube.sdk.g.e.b.a
 *  com.adincube.sdk.g.e.b.a$a
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 */
package com.adincube.sdk.util.f.a;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.adincube.sdk.g.e.b.a;
import com.adincube.sdk.mediation.w.f;
import com.adincube.sdk.util.ErrorReportingHelper;
import com.adincube.sdk.util.f.b;

public final class a
implements a.a {
    private Context a = null;
    private f b = null;
    private b c = null;
    private com.adincube.sdk.g.e.b.a d = null;

    public a(Context context, f f2, b b2, com.adincube.sdk.g.e.b.a a2) {
        this.a = context;
        this.b = f2;
        this.c = b2;
        this.d = a2;
        this.d.a = this;
    }

    private boolean a(Uri uri, Intent intent) {
        if (this.d.a(uri, intent)) {
            return !this.b.q;
        }
        return true;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private void b(Intent var1_1) {
        this.c.d();
        {
            catch (Exception var2_3) {
                com.adincube.sdk.util.a.c("MRAIDActionHelper.performIntent", new Object[]{var2_3});
                ErrorReportingHelper.report("MRAIDActionHelper.performIntent", var2_3);
                return;
            }
        }
        try {
            this.a.startActivity(var1_1);
            ** GOTO lbl13
        }
        catch (Exception var3_2) {
            com.adincube.sdk.util.a.c("MRAIDActionHelper.performIntent", new Object[]{var3_2});
lbl13: // 2 sources:
            this.c.e();
            return;
        }
    }

    private boolean b() {
        if (!this.c.b()) {
            return false;
        }
        return this.c.c();
    }

    public final void a() {
        new Object[1][0] = this.b.r;
    }

    public final void a(Intent intent) {
        this.b(intent);
    }

    public final void a(Uri uri) {
        Object[] arrobject = new Object[]{uri.toString()};
        com.adincube.sdk.util.a.a("Auto redirection has been detected and prevented. Target url: %s", arrobject);
    }

    public final void b(Uri uri) {
        Intent intent = new Intent("android.intent.action.VIEW", uri);
        if (!this.b()) {
            return;
        }
        if (!this.a(uri, intent)) {
            return;
        }
        this.b(intent);
    }

    public final void c(Uri uri) {
        Intent intent = new Intent("android.intent.action.VIEW", uri);
        intent.setDataAndType(uri, "video/mp4");
        if (!this.b()) {
            return;
        }
        if (!this.a(uri, intent)) {
            return;
        }
        this.b(intent);
    }
}

