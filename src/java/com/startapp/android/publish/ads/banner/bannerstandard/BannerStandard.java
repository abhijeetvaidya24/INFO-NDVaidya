/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.graphics.Point
 *  android.os.Handler
 *  android.util.AttributeSet
 *  android.view.View
 *  android.view.View$OnLongClickListener
 *  android.view.View$OnTouchListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewTreeObserver
 *  android.view.ViewTreeObserver$OnGlobalLayoutListener
 *  android.webkit.WebSettings
 *  android.webkit.WebView
 *  android.webkit.WebViewClient
 *  android.widget.RelativeLayout
 *  android.widget.RelativeLayout$LayoutParams
 *  com.startapp.android.publish.ads.banner.bannerstandard.a
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Deprecated
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.concurrent.TimeUnit
 */
package com.startapp.android.publish.ads.banner.bannerstandard;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;
import com.b.a.a.a.b.b;
import com.startapp.android.publish.ads.banner.BannerBase;
import com.startapp.android.publish.ads.banner.BannerInterface;
import com.startapp.android.publish.ads.banner.BannerListener;
import com.startapp.android.publish.ads.banner.BannerOptions;
import com.startapp.android.publish.ads.banner.bannerstandard.BannerStandard;
import com.startapp.android.publish.ads.banner.bannerstandard.a;
import com.startapp.android.publish.ads.banner.c;
import com.startapp.android.publish.ads.banner.d;
import com.startapp.android.publish.adsCommon.Ad;
import com.startapp.android.publish.adsCommon.Utils.h;
import com.startapp.android.publish.adsCommon.adListeners.AdEventListener;
import com.startapp.android.publish.adsCommon.f.f;
import com.startapp.android.publish.adsCommon.i;
import com.startapp.android.publish.common.metaData.MetaData;
import com.startapp.android.publish.common.model.AdPreferences;
import com.startapp.android.publish.html.JsInterface;
import com.startapp.common.a.g;
import java.util.concurrent.TimeUnit;

public class BannerStandard
extends BannerBase
implements BannerInterface,
AdEventListener {
    private static final int ID_WEBVIEW = 159868225;
    private static final String TAG = "BannerHtml";
    protected a adHtml;
    private RelativeLayout adInformationContatiner = null;
    private com.startapp.android.publish.adsCommon.adinformation.b adInformationLayout = null;
    protected AdPreferences adPreferences;
    private b adSession;
    private boolean callbackSent = false;
    private boolean defaultLoad = true;
    private boolean initBannerCalled = false;
    private boolean jsTag = false;
    protected BannerListener listener;
    private boolean loaded = false;
    private BannerOptions options;
    private i scheduledImpression;
    private d size;
    private boolean visible = true;
    protected WebView webView;
    private boolean webViewTouched = true;

    public BannerStandard(Activity activity) {
        this((Context)activity);
    }

    public BannerStandard(Activity activity, AttributeSet attributeSet) {
        this((Context)activity, attributeSet);
    }

    public BannerStandard(Activity activity, AttributeSet attributeSet, int n2) {
        this((Context)activity, attributeSet, n2);
    }

    public BannerStandard(Activity activity, BannerListener bannerListener) {
        this((Context)activity, bannerListener);
    }

    public BannerStandard(Activity activity, AdPreferences adPreferences) {
        this((Context)activity, adPreferences);
    }

    public BannerStandard(Activity activity, AdPreferences adPreferences, BannerListener bannerListener) {
        this((Context)activity, adPreferences, bannerListener);
    }

    public BannerStandard(Activity activity, boolean bl) {
        this((Context)activity, bl);
    }

    public BannerStandard(Activity activity, boolean bl, AdPreferences adPreferences) {
        this((Context)activity, bl, adPreferences);
    }

    @Deprecated
    public BannerStandard(Context context) {
        this(context, true, null);
    }

    @Deprecated
    public BannerStandard(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Deprecated
    public BannerStandard(Context context, AttributeSet attributeSet, int n2) {
        super(context, attributeSet, n2);
        try {
            this.init();
            return;
        }
        catch (Exception exception) {
            f.a(context, com.startapp.android.publish.adsCommon.f.d.b, "BannerStandard.constructor - unexpected error occurd", exception.getMessage(), "");
            return;
        }
    }

    @Deprecated
    public BannerStandard(Context context, BannerListener bannerListener) {
        this(context, true, null);
        this.setBannerListener(bannerListener);
    }

    @Deprecated
    public BannerStandard(Context context, AdPreferences adPreferences) {
        this(context, true, adPreferences);
    }

    @Deprecated
    public BannerStandard(Context context, AdPreferences adPreferences, BannerListener bannerListener) {
        this(context, true, adPreferences);
        this.setBannerListener(bannerListener);
    }

    @Deprecated
    public BannerStandard(Context context, boolean bl) {
        this(context, bl, null);
    }

    @Deprecated
    public BannerStandard(Context context, boolean bl, AdPreferences adPreferences) {
        super(context);
        try {
            this.defaultLoad = bl;
            this.adPreferences = adPreferences;
            this.init();
            return;
        }
        catch (Exception exception) {
            f.a(context, com.startapp.android.publish.adsCommon.f.d.b, "BannerStandard.constructor - unexpected error occurd", exception.getMessage(), "");
            return;
        }
    }

    static /* synthetic */ boolean access$002(BannerStandard bannerStandard, boolean bl) {
        bannerStandard.webViewTouched = bl;
        return bl;
    }

    static /* synthetic */ void access$100(BannerStandard bannerStandard, AdPreferences adPreferences) {
        bannerStandard.setHardwareAcceleration(adPreferences);
    }

    /*
     * Exception decompiling
     */
    private void addAdInformationLayout() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Underrun type stack
        // org.benf.cfr.reader.b.a.c.e.a(StackSim.java:35)
        // org.benf.cfr.reader.b.b.af.a(OperationFactoryPop.java:20)
        // org.benf.cfr.reader.b.b.e.a(JVMInstr.java:315)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:195)
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

    private void determineSizeByScreen(Point point, View view) {
        this.setPointWidthIfNotSet(point, h.b(this.getContext(), view.getMeasuredWidth()));
        this.setPointHeightIfNotSet(point, h.b(this.getContext(), view.getMeasuredHeight()));
    }

    /*
     * Exception decompiling
     */
    private Point getAvailableSize() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl210 : NEW : trying to set 1 previously set to 0
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

    private long getImpressionDelayMillis() {
        if (this.adHtml.p() != null) {
            return TimeUnit.SECONDS.toMillis(this.adHtml.p().longValue());
        }
        return TimeUnit.SECONDS.toMillis(MetaData.getInstance().getIABDisplayImpressionDelayInSeconds());
    }

    private void loadHtml() {
        com.startapp.android.publish.adsCommon.Utils.i.a(this.getContext(), this.webView, this.adHtml.f());
    }

    private void onFailedToReceiveBanner(String string) {
        this.setErrorMessage(string);
        BannerListener bannerListener = this.listener;
        if (bannerListener != null && !this.callbackSent) {
            this.callbackSent = true;
            bannerListener.onFailedToReceiveAd((View)this);
        }
    }

    private void onPause() {
        WebView webView = this.webView;
        if (webView != null) {
            com.startapp.common.a.c.b(webView);
        }
    }

    private void onResume() {
        WebView webView = this.webView;
        if (webView != null) {
            com.startapp.common.a.c.c(webView);
        }
    }

    private void setPointHeightIfNotSet(Point point, int n2) {
        if (point.y <= 0) {
            point.y = n2;
        }
    }

    private void setPointWidthIfNotSet(Point point, int n2) {
        if (point.x <= 0) {
            point.x = n2;
        }
    }

    private boolean setSize(int n2, int n3) {
        Point point = this.getAvailableSize();
        if (point.x >= n2 && point.y >= n3) {
            this.size.a(n2, n3);
            int n4 = h.a(this.getContext(), this.size.a());
            int n5 = h.a(this.getContext(), this.size.b());
            this.setMinimumWidth(n4);
            this.setMinimumHeight(n5);
            ViewGroup.LayoutParams layoutParams = this.webView.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new RelativeLayout.LayoutParams(n4, n5);
            } else {
                layoutParams.width = n4;
                layoutParams.height = n5;
            }
            this.webView.setLayoutParams(layoutParams);
            return true;
        }
        Point point2 = new Point(0, 0);
        ViewGroup.LayoutParams layoutParams = this.webView.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new RelativeLayout.LayoutParams(point2.x, point2.y);
        } else {
            layoutParams.width = point2.x;
            layoutParams.height = point2.y;
        }
        this.webView.setLayoutParams(layoutParams);
        return false;
    }

    protected void cancelScheduledImpression(boolean bl) {
        i i2 = this.scheduledImpression;
        if (i2 != null) {
            i2.a(bl);
        }
    }

    @Override
    protected int getBannerId() {
        return this.innerBannerStandardId;
    }

    @Override
    protected String getBannerName() {
        return "StartApp Banner";
    }

    protected int getBannerType() {
        return 0;
    }

    @Override
    protected int getHeightInDp() {
        return 50;
    }

    @Override
    protected int getOffset() {
        a a2 = this.adHtml;
        if (a2 == null) {
            return 0;
        }
        return a2.a();
    }

    @Override
    protected int getRefreshRate() {
        return this.options.i();
    }

    @Override
    protected int getWidthInDp() {
        return 300;
    }

    @Override
    public void hideBanner() {
        this.visible = false;
        this.setVisibility(8);
    }

    protected void initBanner() {
        if (!this.initBannerCalled) {
            if (this.webView == null) {
                return;
            }
            g.a(TAG, 3, "Initializing BannerHtml");
            this.initBannerCalled = true;
            int n2 = h.a(this.getContext(), this.size.a());
            int n3 = h.a(this.getContext(), this.size.b());
            this.setMinimumWidth(n2);
            this.setMinimumHeight(n3);
            this.webView.addJavascriptInterface((Object)new JsInterface(this.getContext(), new Runnable(this){
                final /* synthetic */ BannerStandard this$0;
                {
                    this.this$0 = bannerStandard;
                }

                public void run() {
                }
            }, new com.startapp.android.publish.adsCommon.d.b(this.getAdTag()), this.adHtml.e(0)), "startappwall");
            this.webView.setWebViewClient(new WebViewClient(){
                private boolean callbackSent = false;

                public void onPageFinished(WebView webView, String string) {
                    if (MetaData.getInstance().isOmsdkEnabled()) {
                        BannerStandard bannerStandard = BannerStandard.this;
                        bannerStandard.adSession = com.startapp.android.publish.omsdk.a.a(bannerStandard.webView);
                        if (BannerStandard.this.adSession != null && BannerStandard.this.webView != null) {
                            if (BannerStandard.this.adInformationContatiner != null) {
                                BannerStandard.this.adSession.b((View)BannerStandard.this.adInformationContatiner);
                            }
                            BannerStandard.this.adSession.a((View)BannerStandard.this.webView);
                            BannerStandard.this.adSession.a();
                            com.b.a.a.a.b.a.a(BannerStandard.this.adSession).a();
                        }
                    }
                }

                /*
                 * Enabled aggressive block sorting
                 * Enabled unnecessary exception pruning
                 * Enabled aggressive exception aggregation
                 */
                public boolean shouldOverrideUrlLoading(WebView webView, String string) {
                    if (BannerStandard.this.jsTag && !BannerStandard.this.webViewTouched) {
                        return false;
                    }
                    if (!this.callbackSent) {
                        this.callbackSent = true;
                        if (BannerStandard.this.listener != null) {
                            BannerStandard.this.listener.onClick((View)BannerStandard.this);
                        }
                    }
                    BannerStandard.this.cancelScheduledImpression(true);
                    boolean bl = com.startapp.android.publish.adsCommon.c.a(BannerStandard.this.getContext(), AdPreferences.Placement.INAPP_BANNER);
                    if (!BannerStandard.this.jsTag && string.contains((CharSequence)"index=")) {
                        try {
                            int n2 = com.startapp.android.publish.adsCommon.c.a(string);
                            if (BannerStandard.this.adHtml.d(n2) && !bl) {
                                Context context = BannerStandard.this.getContext();
                                String string2 = n2 < BannerStandard.this.adHtml.m().length ? BannerStandard.this.adHtml.m()[n2] : null;
                                int n3 = BannerStandard.this.adHtml.o().length;
                                String string3 = null;
                                if (n2 < n3) {
                                    string3 = BannerStandard.this.adHtml.o()[n2];
                                }
                                String string4 = string3;
                                com.startapp.android.publish.adsCommon.d.b b2 = new com.startapp.android.publish.adsCommon.d.b(BannerStandard.this.getAdTag());
                                long l2 = com.startapp.android.publish.adsCommon.b.a().A();
                                long l3 = com.startapp.android.publish.adsCommon.b.a().B();
                                boolean bl2 = BannerStandard.this.adHtml.e(n2);
                                Boolean bl3 = BannerStandard.this.adHtml.f(n2);
                                com.startapp.android.publish.adsCommon.c.a(context, string, string2, string4, b2, l2, l3, bl2, bl3, false);
                            }
                            Context context = BannerStandard.this.getContext();
                            int n4 = BannerStandard.this.adHtml.m().length;
                            String string5 = null;
                            if (n2 < n4) {
                                string5 = BannerStandard.this.adHtml.m()[n2];
                            }
                            com.startapp.android.publish.adsCommon.d.b b3 = new com.startapp.android.publish.adsCommon.d.b(BannerStandard.this.getAdTag());
                            boolean bl4 = BannerStandard.this.adHtml.e(n2) && !bl;
                            com.startapp.android.publish.adsCommon.c.a(context, string, string5, b3, bl4, false);
                        }
                        catch (Exception exception) {
                            g.a(BannerStandard.TAG, 6, "Error while trying parsing index from url");
                            return false;
                        }
                    } else if (BannerStandard.this.adHtml.d(0) && !bl) {
                        com.startapp.android.publish.adsCommon.c.a(BannerStandard.this.getContext(), string, BannerStandard.this.adHtml.m()[0], BannerStandard.this.adHtml.o()[0], new com.startapp.android.publish.adsCommon.d.b(BannerStandard.this.getAdTag()), com.startapp.android.publish.adsCommon.b.a().A(), com.startapp.android.publish.adsCommon.b.a().B(), BannerStandard.this.adHtml.e(0), BannerStandard.this.adHtml.f(0), false);
                    } else {
                        Context context = BannerStandard.this.getContext();
                        String string6 = BannerStandard.this.adHtml.m()[0];
                        com.startapp.android.publish.adsCommon.d.b b4 = new com.startapp.android.publish.adsCommon.d.b(BannerStandard.this.getAdTag());
                        boolean bl5 = BannerStandard.this.adHtml.e(0) && !bl;
                        com.startapp.android.publish.adsCommon.c.a(context, string, string6, b4, bl5, false);
                    }
                    BannerStandard.this.webView.stopLoading();
                    BannerStandard.this.setClicked(true);
                    return true;
                }
            });
            if (!this.loaded) {
                if (this.defaultLoad) {
                    this.loadBanner();
                }
            } else {
                g.a(TAG, 3, "BannerHTML already Loaded");
                this.onReceiveAd((Ad)this.adHtml);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(n2, n3);
            layoutParams.addRule(13);
            RelativeLayout relativeLayout = new RelativeLayout(this.getContext());
            relativeLayout.addView((View)this.webView, (ViewGroup.LayoutParams)layoutParams);
            if (this.getLayoutParams() != null) {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(this.getLayoutParams().width, this.getLayoutParams().height);
                layoutParams2.addRule(13);
                this.addView((View)relativeLayout, (ViewGroup.LayoutParams)layoutParams2);
                return;
            }
            this.addView((View)relativeLayout);
        }
    }

    @Override
    protected void initRuntime() {
        try {
            this.options = new BannerOptions();
            this.adHtml = new a(this.getContext(), this.getOffset());
            if (this.adPreferences == null) {
                this.adPreferences = new AdPreferences();
            }
            this.size = new d(this.getWidthInDp(), this.getHeightInDp());
            this.webView = new WebView(this.getContext());
            if (this.getId() == -1) {
                this.setId(this.getBannerId());
            }
            this.webView.setId(159868225);
            this.setVisibility(8);
            this.webView.setBackgroundColor(0);
            this.webView.setHorizontalScrollBarEnabled(false);
            this.webView.getSettings().setJavaScriptEnabled(true);
            this.webView.setVerticalScrollBarEnabled(false);
            this.webView.setOnTouchListener(new View.OnTouchListener(this){
                final /* synthetic */ BannerStandard this$0;
                {
                    this.this$0 = bannerStandard;
                }

                public boolean onTouch(View view, android.view.MotionEvent motionEvent) {
                    BannerStandard.access$002(this.this$0, true);
                    return motionEvent.getAction() == 2;
                }
            });
            this.webView.setOnLongClickListener(new View.OnLongClickListener(this){
                final /* synthetic */ BannerStandard this$0;
                {
                    this.this$0 = bannerStandard;
                }

                public boolean onLongClick(View view) {
                    return true;
                }
            });
            this.webView.setLongClickable(false);
            this.options = c.a().c();
            this.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener(this){
                final /* synthetic */ BannerStandard this$0;
                {
                    this.this$0 = bannerStandard;
                }

                public void onGlobalLayout() {
                    com.startapp.common.a.c.a(this.this$0.getViewTreeObserver(), this);
                    BannerStandard bannerStandard = this.this$0;
                    BannerStandard.access$100(bannerStandard, bannerStandard.adPreferences);
                    this.this$0.initBanner();
                }
            });
            return;
        }
        catch (Exception exception) {
            f.a(this.getContext(), com.startapp.android.publish.adsCommon.f.d.b, "BannerStandard.init - webview failed", exception.getMessage(), "");
            g.a(TAG, 6, "webVIew exception");
            this.hideBanner();
            this.onFailedToReceiveBanner("BannerStandard.init - webview failed");
            return;
        }
    }

    protected void makeImpression() {
        i i2;
        g.a(TAG, 3, "BannerStandard Scheduling visibility check");
        this.scheduledImpression = i2 = new i(this.getContext(), this.adHtml.l(), new com.startapp.android.publish.adsCommon.d.b(this.getAdTag()), this.getImpressionDelayMillis());
        this.startVisibilityRunnable(this.scheduledImpression);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.onResume();
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.onPause();
        this.cancelScheduledImpression(false);
        b b2 = this.adSession;
        if (b2 != null) {
            b2.b();
            this.adSession = null;
            com.startapp.android.publish.adsCommon.Utils.i.a((Object)this.webView, 1000L);
        }
    }

    @Override
    public void onFailedToReceiveAd(Ad ad) {
        this.onFailedToReceiveBanner(ad.getErrorMessage());
    }

    @Override
    public void onReceiveAd(Ad ad) {
        g.a(TAG, 3, " Html Ad Recievied OK");
        this.webViewTouched = false;
        this.removeView((View)this.adInformationContatiner);
        a a2 = this.adHtml;
        if (a2 != null && a2.f() != null && this.adHtml.f().compareTo("") != 0) {
            this.jsTag = "true".equals((Object)com.startapp.android.publish.adsCommon.Utils.i.a(this.adHtml.f(), "@jsTag@", "@jsTag@"));
            this.loadHtml();
            String string = com.startapp.android.publish.adsCommon.Utils.i.a(this.adHtml.f(), "@width@", "@width@");
            String string2 = com.startapp.android.publish.adsCommon.Utils.i.a(this.adHtml.f(), "@height@", "@height@");
            try {
                if (this.setSize(Integer.parseInt((String)string), Integer.parseInt((String)string2))) {
                    this.loaded = true;
                    this.addAdInformationLayout();
                    this.makeImpression();
                    this.addDisplayEventOnLoad();
                    if (this.listener != null && !this.callbackSent) {
                        this.callbackSent = true;
                        this.listener.onReceiveAd((View)this);
                    }
                    if (this.visible) {
                        this.setVisibility(0);
                    }
                    g.a(TAG, 3, "Done Loading HTML Banner");
                    return;
                }
                this.onFailedToReceiveBanner("Banner cannot be displayed (not enough room)");
                return;
            }
            catch (Exception exception) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unknown error occurred ");
                stringBuilder.append(exception.getMessage());
                g.a(TAG, 6, stringBuilder.toString());
                this.onFailedToReceiveBanner(exception.getMessage());
                return;
            }
            catch (NumberFormatException numberFormatException) {
                g.a(TAG, 6, "Error Casting width & height from HTML");
                this.onFailedToReceiveBanner("Error Casting width & height from HTML");
                return;
            }
        }
        g.a(TAG, 6, "No Banner recieved");
        this.onFailedToReceiveBanner("No Banner received");
    }

    @Override
    public void onWindowFocusChanged(boolean bl) {
        super.onWindowFocusChanged(bl);
        if (bl) {
            this.onResume();
            return;
        }
        this.onPause();
    }

    @Override
    protected void reload() {
        g.a(TAG, 3, "Loading from network");
        b b2 = this.adSession;
        if (b2 != null) {
            b2.b();
            this.adSession = null;
        }
        if (this.adPreferences == null) {
            this.adPreferences = new AdPreferences();
        }
        Point point = this.getAvailableSize();
        this.adHtml.setState(Ad.AdState.UN_INITIALIZED);
        this.adHtml.a(point.x, point.y);
        this.adHtml.a(this.getBannerType());
        this.adHtml.load(this.adPreferences, (AdEventListener)this);
    }

    @Override
    public void setAdTag(String string) {
        this.adTag = string;
    }

    @Override
    protected void setBannerId(int n2) {
        this.innerBannerStandardId = n2;
    }

    @Override
    public void setBannerListener(BannerListener bannerListener) {
        this.listener = bannerListener;
    }

    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        super.setLayoutParams(layoutParams);
        if (layoutParams.width > 0 && layoutParams.height > 0) {
            new Handler().post(new Runnable(this){
                final /* synthetic */ BannerStandard this$0;
                {
                    this.this$0 = bannerStandard;
                }

                public void run() {
                    this.this$0.initBanner();
                }
            });
        }
    }

    @Override
    public void showBanner() {
        this.visible = true;
        this.setVisibility(0);
    }

}

