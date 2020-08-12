/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Rect
 *  android.util.AttributeSet
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.FrameLayout
 *  com.tappx.a.a.a.g.b
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package com.tappx.sdk.android;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tappx.a.a.a.g.b;
import com.tappx.a.a.a.j.b;
import com.tappx.a.a.b.an;
import com.tappx.sdk.android.AdRequest;
import com.tappx.sdk.android.ITappxBanner;
import com.tappx.sdk.android.TappxBannerListener;

public final class TappxBanner
extends FrameLayout
implements b.b,
ITappxBanner {
    boolean a;
    boolean b;
    boolean c;
    private com.tappx.a.a.a.j.b d;
    private b e;
    private final Rect f = new Rect();
    private boolean g;

    public TappxBanner(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a();
        this.a(context, attributeSet);
    }

    public TappxBanner(Context context, AttributeSet attributeSet, int n2) {
        this(context, attributeSet);
    }

    public TappxBanner(Context context, String string) {
        super(context);
        this.a();
        this.setAppKey(string);
    }

    private AdSize a(String string) {
        int n2;
        block9 : {
            String string2 = string.toLowerCase();
            switch (string2.hashCode()) {
                default: {
                    break;
                }
                case 1622564786: {
                    if (!string2.equals((Object)"728x90")) break;
                    n2 = 1;
                    break block9;
                }
                case 1507809730: {
                    if (!string2.equals((Object)"320x50")) break;
                    n2 = 0;
                    break block9;
                }
                case 109549001: {
                    if (!string2.equals((Object)"smart")) break;
                    n2 = 3;
                    break block9;
                }
                case -559799608: {
                    if (!string2.equals((Object)"300x250")) break;
                    n2 = 2;
                    break block9;
                }
            }
            n2 = -1;
        }
        if (n2 != 0) {
            if (n2 != 1) {
                if (n2 != 2) {
                    return AdSize.SMART_BANNER;
                }
                return AdSize.BANNER_300x250;
            }
            return AdSize.BANNER_728x90;
        }
        return AdSize.BANNER_320x50;
    }

    private void a() {
        this.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        this.e = b.a.a().a(this);
        this.d = b.a.a().a(this.getContext());
        this.d.a(this);
        this.setAdSize(AdSize.BANNER_320x50);
    }

    /*
     * Exception decompiling
     */
    private void a(Context var1, AttributeSet var2) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl55.1 : ALOAD_3 : trying to set 1 previously set to 0
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
        // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
        // org.benf.cfr.reader.b.a(Driver.java:128)
        // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
        // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
        // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
        // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1167)
        // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:641)
        // java.lang.Thread.run(Thread.java:919)
        throw new IllegalStateException("Decompilation failed");
    }

    private void b() {
        if (!this.a) {
            return;
        }
        this.a = false;
        this.loadAd();
    }

    private void c() {
        int n2 = this.getVisibility();
        boolean bl = true;
        boolean bl2 = n2 == 0;
        boolean bl3 = this.getWindowVisibility() == 0;
        boolean bl4 = this.d.a();
        boolean bl5 = this.c && this.g && bl2 && bl3 && bl4;
        if (!(this.c && bl2 && bl3 && bl4)) {
            bl = false;
        }
        if (bl5 != this.b) {
            this.b = bl5;
            this.e.b(bl5);
        }
        if (bl) {
            this.b();
        }
    }

    private void setAdSizeFromString(String string) {
        this.setAdSize(this.a(string));
    }

    @Override
    public void destroy() {
        this.e.b();
        this.d.b();
    }

    @Override
    public void loadAd() {
        this.loadAd(null);
    }

    @Override
    public void loadAd(AdRequest adRequest) {
        this.a = false;
        this.e.a(adRequest);
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.c = true;
        this.c();
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.c = false;
        this.c();
    }

    @Override
    public void onDeviceScreenStateChanged(boolean bl) {
        this.c();
    }

    protected void onLayout(boolean bl, int n2, int n3, int n4, int n5) {
        super.onLayout(bl, n2, n3, n4, n5);
        boolean bl2 = this.getLocalVisibleRect(this.f);
        int n6 = !bl2 ? 0 : an.a((View)this, this.f);
        this.e.b(n6);
        this.setVisibleOnScreen(bl2);
    }

    protected void onVisibilityChanged(View view, int n2) {
        super.onVisibilityChanged(view, n2);
        this.c();
    }

    protected void onWindowVisibilityChanged(int n2) {
        super.onWindowVisibilityChanged(n2);
        this.c();
    }

    public void setAdSize(AdSize adSize) {
        this.e.a(adSize);
    }

    @Override
    public void setAppKey(String string) {
        this.e.a(string);
    }

    @Override
    public void setEnableAutoRefresh(boolean bl) {
        this.e.a(bl);
    }

    @Override
    public void setListener(TappxBannerListener tappxBannerListener) {
        this.e.a(tappxBannerListener);
    }

    @Override
    public void setRefreshTimeSeconds(int n2) {
        this.e.a(n2 * 1000);
    }

    void setVisibleOnScreen(boolean bl) {
        if (bl == this.g) {
            return;
        }
        this.g = bl;
        this.c();
    }

}

