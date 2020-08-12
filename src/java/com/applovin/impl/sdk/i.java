/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  java.lang.Boolean
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.ref.WeakReference
 *  java.util.concurrent.atomic.AtomicBoolean
 */
package com.applovin.impl.sdk;

import android.app.Activity;
import android.content.Context;
import com.applovin.impl.sdk.b.b;
import com.applovin.impl.sdk.e.a;
import com.applovin.impl.sdk.e.e;
import com.applovin.impl.sdk.e.f;
import com.applovin.impl.sdk.e.j;
import com.applovin.impl.sdk.h;
import com.applovin.impl.sdk.i;
import com.applovin.impl.sdk.p;
import com.applovin.sdk.AppLovinPrivacySettings;
import com.applovin.sdk.AppLovinSdkUtils;
import com.applovin.sdk.AppLovinUserService;
import com.applovin.sdk.AppLovinWebViewActivity;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;

public class i
implements h.a,
AppLovinWebViewActivity.EventListener {
    private static final AtomicBoolean a = new AtomicBoolean();
    private static WeakReference<AppLovinWebViewActivity> b;
    private final com.applovin.impl.sdk.j c;
    private final p d;
    private AppLovinUserService.OnConsentDialogDismissListener e;
    private h f;
    private WeakReference<Activity> g = new WeakReference(null);
    private a h;

    i(com.applovin.impl.sdk.j j2) {
        this.c = j2;
        this.d = j2.u();
        if (j2.y() != null) {
            this.g = new WeakReference((Object)j2.y());
        }
        j2.S().a(new a(){

            @Override
            public void onActivityStarted(Activity activity) {
                i.this.g = new WeakReference((Object)activity);
            }
        });
        this.f = new h(this, j2);
    }

    static /* synthetic */ a a(i i2, a a2) {
        i2.h = a2;
        return a2;
    }

    static /* synthetic */ com.applovin.impl.sdk.j a(i i2) {
        return i2.c;
    }

    static /* synthetic */ AppLovinUserService.OnConsentDialogDismissListener a(i i2, AppLovinUserService.OnConsentDialogDismissListener onConsentDialogDismissListener) {
        i2.e = onConsentDialogDismissListener;
        return onConsentDialogDismissListener;
    }

    static /* synthetic */ WeakReference a(WeakReference weakReference) {
        b = weakReference;
        return weakReference;
    }

    private void a(boolean bl, long l2) {
        this.f();
        if (bl) {
            this.a(l2);
        }
    }

    static /* synthetic */ boolean a(i i2, com.applovin.impl.sdk.j j2) {
        return i2.a(j2);
    }

    private boolean a(com.applovin.impl.sdk.j j2) {
        if (!e.a(AppLovinWebViewActivity.class, j2.w())) {
            this.d.e("AppLovinSdk", "Unable to show consent dialog. Please add <activity android:name=\"com.applovin.sdk.AppLovinWebViewActivity\" android:configChanges=\"keyboardHidden|orientation|screenSize\"/> to your AndroidManifest.xml file.");
            return false;
        }
        if (this.c()) {
            this.d.e("AppLovinSdk", "Consent dialog already showing");
            return false;
        }
        if (!f.a(j2.w(), j2)) {
            this.d.e("AppLovinSdk", "No internet available, skip showing of consent dialog");
            return false;
        }
        if (!j2.a(b.ah).booleanValue()) {
            this.d.d("ConsentDialogManager", "Blocked publisher from showing consent dialog");
            return false;
        }
        if (!j.b(j2.a(b.ai))) {
            this.d.d("ConsentDialogManager", "AdServer returned empty consent dialog URL");
            return false;
        }
        return true;
    }

    static /* synthetic */ a b(i i2) {
        return i2.h;
    }

    static /* synthetic */ p c(i i2) {
        return i2.d;
    }

    static /* synthetic */ h d(i i2) {
        return i2.f;
    }

    static /* synthetic */ AtomicBoolean d() {
        return a;
    }

    static /* synthetic */ WeakReference e() {
        return b;
    }

    private void f() {
        this.c.S().b(this.h);
        if (this.c()) {
            AppLovinWebViewActivity appLovinWebViewActivity = (AppLovinWebViewActivity)((Object)b.get());
            b = null;
            if (appLovinWebViewActivity != null) {
                appLovinWebViewActivity.finish();
                AppLovinUserService.OnConsentDialogDismissListener onConsentDialogDismissListener = this.e;
                if (onConsentDialogDismissListener != null) {
                    onConsentDialogDismissListener.onDismiss();
                    this.e = null;
                }
            }
        }
    }

    @Override
    public void a() {
        this.d.a("ConsentDialogManager", "User accepted consent alert");
        if (this.g.get() != null) {
            Activity activity = (Activity)this.g.get();
            long l2 = this.c.a(b.ak);
            AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable(this, activity){
                final /* synthetic */ Activity a;
                final /* synthetic */ i b;
                {
                    this.b = i2;
                    this.a = activity;
                }

                public void run() {
                    this.b.a(this.a, null);
                }
            }, l2);
        }
    }

    public void a(long l2) {
        AppLovinSdkUtils.runOnUiThread(new Runnable(this, l2){
            final /* synthetic */ long a;
            final /* synthetic */ i b;
            {
                this.b = i2;
                this.a = l2;
            }

            public void run() {
                i.c(this.b).a("ConsentDialogManager", "Scheduling repeating consent alert");
                i.d(this.b).a(this.a, i.a(this.b), this.b);
            }
        });
    }

    public void a(Activity activity, AppLovinUserService.OnConsentDialogDismissListener onConsentDialogDismissListener) {
        activity.runOnUiThread(new Runnable(this, onConsentDialogDismissListener, activity){
            final /* synthetic */ AppLovinUserService.OnConsentDialogDismissListener a;
            final /* synthetic */ Activity b;
            final /* synthetic */ i c;
            {
                this.c = i2;
                this.a = onConsentDialogDismissListener;
                this.b = activity;
            }

            public void run() {
                i i2 = this.c;
                if (i.a(i2, i.a(i2)) && !i.d().getAndSet(true)) {
                    i.a(this.c, new WeakReference((Object)this.b));
                    i.a(this.c, this.a);
                    i.a(this.c, new a(this){
                        final /* synthetic */ 2 a;
                        {
                            this.a = var1_1;
                        }

                        public void onActivityStarted(Activity activity) {
                            if (activity instanceof AppLovinWebViewActivity) {
                                if (!this.a.c.c() || i.e().get() != activity) {
                                    AppLovinWebViewActivity appLovinWebViewActivity = (AppLovinWebViewActivity)activity;
                                    i.a(new WeakReference((Object)((Object)appLovinWebViewActivity)));
                                    appLovinWebViewActivity.loadUrl(i.a(this.a.c).a(b.ai), this.a.c);
                                }
                                i.d().set(false);
                            }
                        }
                    });
                    i.a(this.c).S().a(i.b(this.c));
                    android.content.Intent intent = new android.content.Intent((Context)this.b, AppLovinWebViewActivity.class);
                    intent.putExtra("sdk_key", i.a(this.c).s());
                    intent.putExtra("immersive_mode_on", (java.io.Serializable)i.a(this.c).a(b.aj));
                    this.b.startActivity(intent);
                    return;
                }
                AppLovinUserService.OnConsentDialogDismissListener onConsentDialogDismissListener = this.a;
                if (onConsentDialogDismissListener != null) {
                    onConsentDialogDismissListener.onDismiss();
                }
            }
        });
    }

    @Override
    public void b() {
        this.d.a("ConsentDialogManager", "User rejected consent alert");
    }

    boolean c() {
        WeakReference<AppLovinWebViewActivity> weakReference = b;
        return weakReference != null && weakReference.get() != null;
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public void onReceivedEvent(String string) {
        com.applovin.impl.sdk.j j2;
        b<Long> b2;
        boolean bl;
        p p2 = this.d;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Received event: ");
        stringBuilder.append(string);
        p2.a("ConsentDialogManager", stringBuilder.toString());
        if ("accepted".equalsIgnoreCase(string)) {
            AppLovinPrivacySettings.setHasUserConsent(true, this.c.w());
            this.f();
            return;
        }
        if ("rejected".equalsIgnoreCase(string)) {
            AppLovinPrivacySettings.setHasUserConsent(false, this.c.w());
            bl = this.c.a(b.al);
            j2 = this.c;
            b2 = b.aq;
        } else if ("closed".equalsIgnoreCase(string)) {
            bl = this.c.a(b.am);
            j2 = this.c;
            b2 = b.ar;
        } else {
            if (!"dismissed_via_back_button".equalsIgnoreCase(string)) {
                return;
            }
            bl = this.c.a(b.an);
            j2 = this.c;
            b2 = b.as;
        }
        this.a(bl, j2.a(b2));
    }

}

