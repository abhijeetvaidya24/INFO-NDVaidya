/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.content.res.Resources
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.view.View
 *  android.view.Window
 *  java.io.Serializable
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 */
package com.adincube.sdk.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import com.adincube.sdk.util.ErrorReportingHelper;
import com.adincube.sdk.util.a;
import com.adincube.sdk.util.k;
import java.io.Serializable;

public final class b {
    private Activity a = null;

    public b(Context context) {
        if (context instanceof Activity) {
            this.a = (Activity)context;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static int a(Context context) {
        int n2 = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (n2 <= 0) return 0;
        try {
            return context.getResources().getDimensionPixelSize(n2);
        }
        catch (Throwable throwable) {
            a.c("ActivityThemeHelper.getStatusBarHeightInPixels", new Object[]{throwable});
            ErrorReportingHelper.report("ActivityThemeHelper.getStatusBarHeightInPixels", throwable);
        }
        return 0;
    }

    public final void a(Intent intent) {
        Integer n2;
        intent.putExtra("fs", k.b((Context)this.a));
        intent.putExtra("wt", k.c((Context)this.a));
        intent.putExtra("suf", k.d((Context)this.a));
        Integer n3 = k.f((Context)this.a);
        if (n3 != null) {
            intent.putExtra("sbc", (Serializable)n3);
        }
        if ((n2 = k.g((Context)this.a)) != null) {
            intent.putExtra("snc", (Serializable)n2);
        }
    }

    @TargetApi(value=21)
    public final void a(Bundle bundle) {
        this.a.getWindow().addFlags(128);
        if (bundle.containsKey("wt") && bundle.getBoolean("wt")) {
            this.a.requestWindowFeature(1);
        }
        if (bundle.containsKey("fs") && bundle.getBoolean("fs")) {
            this.a.getWindow().addFlags(1024);
        }
        if (Build.VERSION.SDK_INT >= 21) {
            if (bundle.containsKey("sbc") || bundle.containsKey("snc")) {
                this.a.getWindow().addFlags(Integer.MIN_VALUE);
            }
            if (bundle.containsKey("sbc")) {
                this.a.getWindow().setStatusBarColor(bundle.getInt("sbc"));
            }
            if (bundle.containsKey("snc")) {
                this.a.getWindow().setNavigationBarColor(bundle.getInt("snc"));
            }
        }
    }

    @TargetApi(value=19)
    public final void b(Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 19 && bundle.containsKey("suf")) {
            int n2 = bundle.getInt("suf");
            if ((n2 & 2048) != 0) {
                n2 = 4096 | n2 & -2049;
            }
            this.a.getWindow().getDecorView().setSystemUiVisibility(n2);
        }
    }
}

