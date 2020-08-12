/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.app.Activity
 *  android.app.Application
 *  android.app.Application$ActivityLifecycleCallbacks
 *  android.content.Context
 *  android.content.Intent
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.view.Display
 *  android.view.Window
 *  android.view.WindowManager
 *  android.view.WindowManager$LayoutParams
 *  com.adincube.sdk.h.c.b
 *  com.adincube.sdk.h.d
 *  com.adincube.sdk.mediation.chartboost.ChartboostActivity$2
 *  com.adincube.sdk.mediation.chartboost.a
 *  com.chartboost.sdk.CBImpressionActivity
 *  com.chartboost.sdk.Chartboost
 *  java.lang.Exception
 *  java.lang.IllegalStateException
 *  java.lang.NoSuchFieldError
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 */
package com.adincube.sdk.mediation.chartboost;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;
import com.adincube.sdk.h.c.b;
import com.adincube.sdk.h.d;
import com.adincube.sdk.mediation.chartboost.ChartboostActivity;
import com.adincube.sdk.mediation.chartboost.i;
import com.adincube.sdk.util.ErrorReportingHelper;
import com.adincube.sdk.util.b.c;
import com.chartboost.sdk.CBImpressionActivity;
import com.chartboost.sdk.Chartboost;

@TargetApi(value=14)
public class ChartboostActivity
extends Activity {
    private String a = null;
    private String b = null;
    private String c = null;
    private b d = null;
    private boolean e = true;
    private Application.ActivityLifecycleCallbacks f = new Application.ActivityLifecycleCallbacks(){

        public final void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public final void onActivityDestroyed(Activity activity) {
        }

        public final void onActivityPaused(Activity activity) {
        }

        public final void onActivityResumed(Activity activity) {
        }

        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public final void onActivityStarted(Activity activity) {
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        public final void onActivityStopped(Activity activity) {
            try {
                if (activity instanceof CBImpressionActivity && activity.isFinishing()) {
                    int n2 = 3.a[ChartboostActivity.this.d.ordinal()];
                    if (n2 != 1) {
                        if (n2 != 2) {
                            return;
                        }
                        com.adincube.sdk.mediation.chartboost.a.a().didCloseRewardedVideo(ChartboostActivity.this.a);
                        return;
                    }
                    com.adincube.sdk.mediation.chartboost.a.a().didCloseInterstitial(ChartboostActivity.this.a);
                }
                return;
            }
            catch (Throwable throwable) {
                ErrorReportingHelper.report("ChartboostActivity#ActivityLifecycleCallbacks.onActivityStopped", throwable);
                com.adincube.sdk.util.a.c("ChartboostActivity#ActivityLifecycleCallbacks.onActivityStopped", new Object[]{throwable});
                return;
            }
        }
    };
    private a g = new 2(this);

    static /* synthetic */ Application.ActivityLifecycleCallbacks c(ChartboostActivity chartboostActivity) {
        return chartboostActivity.f;
    }

    public void onBackPressed() {
        try {
            if (!Chartboost.onBackPressed()) {
                super.onBackPressed();
            }
            return;
        }
        catch (Throwable throwable) {
            ErrorReportingHelper.report("ChartboostActivity.onBackPressed", throwable);
            com.adincube.sdk.util.a.c("ChartboostActivity.onBackPressed() Exception : ", new Object[]{throwable});
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    protected void onCreate(Bundle bundle) {
        boolean bl;
        block17 : {
            block15 : {
                block16 : {
                    try {
                        block13 : {
                            boolean bl2;
                            block14 : {
                                super.onCreate(bundle);
                                try {
                                    this.a = this.getIntent().getStringExtra("location");
                                    this.b = this.getIntent().getStringExtra("appId");
                                    this.c = this.getIntent().getStringExtra("appSignature");
                                    this.d = b.a((String)this.getIntent().getStringExtra("adType"));
                                    if (this.a == null || this.b == null || this.c == null) break block13;
                                    if (bundle == null) break block14;
                                    this.e = bundle.getBoolean("firstStart", true);
                                }
                                catch (Exception exception) {
                                    this.finish();
                                    return;
                                }
                            }
                            new com.adincube.sdk.util.b((Context)this).a(this.getIntent().getExtras());
                            if (Build.VERSION.SDK_INT < 27 || (bl2 = (1024 & this.getWindow().getAttributes().flags) != 0) && !this.isInMultiWindowMode()) break block15;
                            break block16;
                        }
                        throw new IllegalStateException();
                    }
                    catch (Throwable throwable) {
                        ErrorReportingHelper.report("ChartboostActivity.onCreate", throwable);
                        com.adincube.sdk.util.a.c("ChartboostActivity.onCreate() Exception : ", new Object[]{throwable});
                        this.finish();
                        return;
                    }
                }
                bl = false;
                break block17;
            }
            bl = true;
        }
        if (bl) {
            int n2;
            int[] arrn = c.1.a;
            Display display = ((WindowManager)this.getSystemService("window")).getDefaultDisplay();
            d d2 = display.getWidth() >= display.getHeight() && (display.getWidth() > display.getHeight() || (n2 = this.getResources().getConfiguration().orientation) != 1 && n2 == 2) ? d.b : d.a;
            int n3 = arrn[d2.ordinal()];
            if (n3 != 1) {
                if (n3 == 2) {
                    if (!c.a((Context)this)) {
                        this.setRequestedOrientation(0);
                    } else {
                        this.setRequestedOrientation(8);
                    }
                }
            } else if (!c.a((Context)this)) {
                this.setRequestedOrientation(1);
            } else {
                this.setRequestedOrientation(9);
            }
        }
        i.a(this, this.b, this.c);
        Chartboost.onCreate((Activity)this);
    }

    protected void onDestroy() {
        try {
            super.onDestroy();
            Chartboost.onDestroy((Activity)this);
            return;
        }
        catch (Throwable throwable) {
            ErrorReportingHelper.report("ChartboostActivity.onDestroy", throwable);
            com.adincube.sdk.util.a.c("ChartboostActivity.onDestroy() Exception : ", new Object[]{throwable});
            return;
        }
    }

    protected void onPause() {
        try {
            super.onPause();
            Chartboost.onPause((Activity)this);
            return;
        }
        catch (Throwable throwable) {
            ErrorReportingHelper.report("ChartboostActivity.onPause", throwable);
            com.adincube.sdk.util.a.c("ChartboostActivity.onPause() Exception : ", new Object[]{throwable});
            return;
        }
    }

    protected void onResume() {
        try {
            super.onResume();
            Chartboost.onResume((Activity)this);
            return;
        }
        catch (Throwable throwable) {
            ErrorReportingHelper.report("ChartboostActivity.onResume", throwable);
            com.adincube.sdk.util.a.c("ChartboostActivity.onResume() Exception : ", new Object[]{throwable});
            return;
        }
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        try {
            bundle.putBoolean("firstStart", this.e);
            return;
        }
        catch (Throwable throwable) {
            ErrorReportingHelper.report("ChartboostActivity.onSaveInstanceState", throwable);
            com.adincube.sdk.util.a.c("ChartboostActivity.onSaveInstanceState() Exception : ", new Object[]{throwable});
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    protected void onStart() {
        try {
            super.onStart();
            Chartboost.onStart((Activity)this);
            new com.adincube.sdk.util.b((Context)this).b(this.getIntent().getExtras());
            if (this.e) {
                this.e = false;
                com.adincube.sdk.mediation.chartboost.a.a().a(this.g);
                int n2 = 3.a[this.d.ordinal()];
                if (n2 != 1) {
                    if (n2 == 2) {
                        Chartboost.showRewardedVideo((String)this.a);
                    }
                } else {
                    Chartboost.showInterstitial((String)this.a);
                }
                this.getApplication().registerActivityLifecycleCallbacks(this.f);
            }
            return;
        }
        catch (Throwable throwable) {
            ErrorReportingHelper.report("ChartboostActivity.onStart", throwable);
            com.adincube.sdk.util.a.c("ChartboostActivity.onStart() Exception : ", new Object[]{throwable});
            this.finish();
            return;
        }
    }

    protected void onStop() {
        try {
            super.onStop();
            Chartboost.onStop((Activity)this);
            return;
        }
        catch (Throwable throwable) {
            ErrorReportingHelper.report("ChartboostActivity.onStop", throwable);
            com.adincube.sdk.util.a.c("ChartboostActivity.onStop() Exception : ", new Object[]{throwable});
            return;
        }
    }

    public static interface a {
        public void a(b var1);
    }

}

