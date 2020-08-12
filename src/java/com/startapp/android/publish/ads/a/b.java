/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentFilter
 *  android.content.res.Configuration
 *  android.net.Uri
 *  android.os.Bundle
 *  android.view.KeyEvent
 *  android.widget.RelativeLayout
 *  com.startapp.android.publish.ads.a.a
 *  com.startapp.android.publish.ads.a.d
 *  com.startapp.android.publish.ads.a.e
 *  com.startapp.android.publish.ads.a.f
 *  com.startapp.android.publish.ads.splash.g
 *  com.startapp.android.publish.ads.video.f
 *  com.startapp.android.publish.adsCommon.Ad
 *  com.startapp.android.publish.adsCommon.AdsConstants
 *  com.startapp.android.publish.adsCommon.Utils.i
 *  com.startapp.android.publish.adsCommon.adinformation.b
 *  com.startapp.android.publish.adsCommon.adinformation.b$b
 *  com.startapp.android.publish.adsCommon.adinformation.c
 *  com.startapp.android.publish.cache.a
 *  com.startapp.android.publish.common.model.AdPreferences
 *  com.startapp.android.publish.common.model.AdPreferences$Placement
 *  com.startapp.android.publish.inappbrowser.a
 *  com.startapp.common.a.g
 *  com.startapp.common.b
 *  java.io.Serializable
 *  java.lang.Boolean
 *  java.lang.Long
 *  java.lang.NoSuchFieldError
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.startapp.android.publish.ads.a;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.RelativeLayout;
import com.startapp.android.publish.ads.a.a;
import com.startapp.android.publish.ads.a.d;
import com.startapp.android.publish.ads.a.e;
import com.startapp.android.publish.ads.a.f;
import com.startapp.android.publish.adsCommon.Ad;
import com.startapp.android.publish.adsCommon.AdsConstants;
import com.startapp.android.publish.adsCommon.Utils.i;
import com.startapp.android.publish.adsCommon.adinformation.b;
import com.startapp.android.publish.adsCommon.adinformation.c;
import com.startapp.android.publish.common.model.AdPreferences;
import com.startapp.common.a.g;
import java.io.Serializable;

public abstract class b {
    protected com.startapp.android.publish.adsCommon.adinformation.b a = null;
    protected AdPreferences.Placement b;
    protected boolean c = false;
    private Intent d;
    private Activity e;
    private BroadcastReceiver f = new BroadcastReceiver(){

        public void onReceive(Context context, Intent intent) {
            b.this.p();
        }
    };
    private String[] g;
    private boolean[] h;
    private boolean[] i = new boolean[]{true};
    private String j;
    private String[] k;
    private String[] l;
    private String[] m;
    private Ad n;
    private String o;
    private boolean p;
    private c q;
    private String r;
    private Long s;
    private Boolean[] t = null;

    public static b a(Activity activity, Intent intent, AdPreferences.Placement placement) {
        a a2;
        switch (3.a[placement.ordinal()]) {
            default: {
                a2 = new a();
                break;
            }
            case 5: 
            case 6: {
                boolean bl2 = i.a((long)256L);
                a2 = null;
                if (!bl2) break;
                Uri uri = intent.getData();
                if (uri == null) {
                    return null;
                }
                a2 = new com.startapp.android.publish.inappbrowser.a(uri.toString());
                break;
            }
            case 4: {
                boolean bl3 = i.a((long)8L);
                a2 = null;
                if (!bl3) break;
                a2 = new com.startapp.android.publish.ads.splash.g();
                break;
            }
            case 2: 
            case 3: {
                if (i.a((long)4L) && intent.getBooleanExtra("videoAd", false)) {
                    a2 = new com.startapp.android.publish.ads.video.f();
                    break;
                }
                if (intent.getBooleanExtra("mraidAd", false)) {
                    a2 = new d();
                    break;
                }
                a2 = new f();
                break;
            }
            case 1: {
                if (!i.a((long)128L)) {
                    boolean bl4 = i.a((long)64L);
                    a2 = null;
                    if (!bl4) break;
                }
                a2 = new e();
            }
        }
        b.super.a(intent);
        b.super.a(activity);
        b.super.c(intent.getStringExtra("position"));
        b.super.b(intent.getStringArrayExtra("tracking"));
        b.super.c(intent.getStringArrayExtra("trackingClickUrl"));
        b.super.d(intent.getStringArrayExtra("packageNames"));
        b.super.a(intent.getStringArrayExtra("closingUrl"));
        a2.a(intent.getBooleanArrayExtra("smartRedirect"));
        a2.b(intent.getBooleanArrayExtra("browserEnabled"));
        String string2 = intent.getStringExtra("htmlUuid");
        if (string2 != null) {
            if (AdsConstants.OVERRIDE_NETWORK.booleanValue()) {
                a2.a(com.startapp.android.publish.cache.a.a().b(string2));
            } else {
                a2.a(com.startapp.android.publish.cache.a.a().c(string2));
            }
        }
        b.super.a(intent.getBooleanExtra("isSplash", false));
        b.super.a((c)intent.getSerializableExtra("adInfoOverride"));
        b.super.b(intent.getStringExtra("adTag"));
        b.super.a(placement);
        b.super.a(intent.getStringArrayExtra("closingUrl"));
        if (a2.d() == null) {
            a2.a(new boolean[]{true});
        }
        if (a2.e() == null) {
            a2.b(new boolean[]{true});
        }
        a2.a((Ad)intent.getSerializableExtra("ad"));
        long l2 = intent.getLongExtra("delayImpressionSeconds", -1L);
        if (l2 != -1L) {
            b.super.a(l2);
        }
        a2.a((Boolean[])intent.getSerializableExtra("sendRedirectHops"));
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Placement=[");
        stringBuilder.append((Object)a2.k());
        stringBuilder.append("]");
        g.a((String)"GenericMode", (int)3, (String)stringBuilder.toString());
        return a2;
    }

    private void a(Activity activity) {
        this.e = activity;
    }

    private void a(Intent intent) {
        this.d = intent;
    }

    private void a(c c2) {
        this.q = c2;
    }

    private void a(AdPreferences.Placement placement) {
        this.b = placement;
    }

    private void a(Long l2) {
        this.s = l2;
    }

    private void a(boolean bl2) {
        this.p = bl2;
    }

    private void a(String[] arrstring) {
        this.g = arrstring;
    }

    private void b(String string2) {
        this.r = string2;
    }

    private void b(String[] arrstring) {
        this.k = arrstring;
    }

    private void c(String string2) {
        this.j = string2;
    }

    private void c(String[] arrstring) {
        this.l = arrstring;
    }

    private void d(String[] arrstring) {
        this.m = arrstring;
    }

    public Intent a() {
        return this.d;
    }

    public void a(Configuration configuration) {
    }

    public void a(Bundle bundle) {
        com.startapp.common.b.a((Context)this.b()).a(this.f, new IntentFilter("com.startapp.android.CloseAdActivity"));
    }

    protected void a(RelativeLayout relativeLayout) {
        this.a = new com.startapp.android.publish.adsCommon.adinformation.b((Context)this.b(), b.b.b, this.k(), this.m());
        this.a.a(relativeLayout);
    }

    public void a(Ad ad2) {
        this.n = ad2;
    }

    protected void a(String string2) {
        this.o = string2;
    }

    public void a(Boolean[] arrboolean) {
        this.t = arrboolean;
    }

    protected void a(boolean[] arrbl) {
        this.h = arrbl;
    }

    protected boolean a(int n2) {
        boolean[] arrbl = this.i;
        if (arrbl != null && n2 >= 0 && n2 < arrbl.length) {
            return arrbl[n2];
        }
        return true;
    }

    public boolean a(int n2, KeyEvent keyEvent) {
        return false;
    }

    public Activity b() {
        return this.e;
    }

    public Boolean b(int n2) {
        Boolean[] arrboolean = this.t;
        if (arrboolean != null && n2 >= 0 && n2 < arrboolean.length) {
            return arrboolean[n2];
        }
        return null;
    }

    public void b(Bundle bundle) {
    }

    protected void b(boolean[] arrbl) {
        this.i = arrbl;
    }

    public void c() {
        this.c = true;
    }

    public void c(Bundle bundle) {
    }

    protected boolean[] d() {
        return this.h;
    }

    public boolean[] e() {
        return this.i;
    }

    protected String f() {
        return this.o;
    }

    protected String g() {
        return this.j;
    }

    protected String[] h() {
        return this.k;
    }

    protected String[] i() {
        return this.l;
    }

    protected String[] j() {
        return this.m;
    }

    protected AdPreferences.Placement k() {
        return this.b;
    }

    protected String[] l() {
        return this.g;
    }

    protected c m() {
        return this.q;
    }

    protected String n() {
        return this.r;
    }

    public Long o() {
        return this.s;
    }

    public void p() {
        this.b().runOnUiThread(new Runnable(){

            public void run() {
                b.this.b().finish();
            }
        });
    }

    public void q() {
        Intent intent = new Intent("com.startapp.android.HideDisplayBroadcastListener");
        com.startapp.common.b.a((Context)this.b()).a(intent);
    }

    public boolean r() {
        return false;
    }

    public void s() {
        this.p();
    }

    public void t() {
    }

    public abstract void u();

    public void v() {
        if (this.f != null) {
            com.startapp.common.b.a((Context)this.b()).a(this.f);
        }
        this.f = null;
    }

    public Ad w() {
        return this.n;
    }

}

