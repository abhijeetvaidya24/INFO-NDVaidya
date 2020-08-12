/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 *  android.widget.RelativeLayout
 *  com.aerserv.sdk.model.ad.MraidProviderAd
 *  com.aerserv.sdk.view.ASWebviewInterstitialActivity
 *  com.aerserv.sdk.view.component.ASMraidWebView
 *  java.lang.Exception
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 */
package com.aerserv.sdk.strategy;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.aerserv.sdk.AerServEvent;
import com.aerserv.sdk.AerServTransactionInformation;
import com.aerserv.sdk.AerServVirtualCurrency;
import com.aerserv.sdk.adapter.asaerserv.mraid.MraidState;
import com.aerserv.sdk.controller.listener.AerServEventListenerLocator;
import com.aerserv.sdk.controller.listener.MraidInterstitialJavascriptInterfaceListener;
import com.aerserv.sdk.controller.listener.MraidJavascriptInterfaceListener;
import com.aerserv.sdk.controller.listener.OnCloseListener;
import com.aerserv.sdk.controller.listener.OnSetOrientationPropertiesListener;
import com.aerserv.sdk.controller.listener.ProviderListener;
import com.aerserv.sdk.controller.listener.SetVisibilityListener;
import com.aerserv.sdk.model.ad.MraidProviderAd;
import com.aerserv.sdk.strategy.InterstitialStrategy;
import com.aerserv.sdk.strategy.MraidInterstitialStrategy;
import com.aerserv.sdk.utils.AerServLog;
import com.aerserv.sdk.view.ASWebviewInterstitialActivity;
import com.aerserv.sdk.view.component.ASMraidWebView;
import com.aerserv.sdk.view.component.CloseButton;

public final class MraidInterstitialStrategy
implements InterstitialStrategy {
    private static final String LOG_TAG = "com.aerserv.sdk.strategy.MraidInterstitialStrategy";
    private ASWebviewInterstitialActivity activity;
    private MraidProviderAd ad;
    private CloseButton closeButton;
    private String controllerId;
    private boolean firstOnResume = true;
    private ProviderListener providerListener;
    private RelativeLayout relativeLayout;
    private Long showAdTimeout = null;
    private boolean useCustomClose;
    private ASMraidWebView webView;
    private RelativeLayout webViewContainer;

    public MraidInterstitialStrategy(ASWebviewInterstitialActivity aSWebviewInterstitialActivity, ProviderListener providerListener, MraidProviderAd mraidProviderAd, Bundle bundle) {
        this.activity = aSWebviewInterstitialActivity;
        this.controllerId = bundle.getString("controllerId");
        if (bundle.containsKey("showAdTimeout")) {
            this.showAdTimeout = bundle.getLong("showAdTimeout", 8000L);
        }
        this.providerListener = providerListener;
        this.ad = mraidProviderAd;
        this.useCustomClose = bundle.getBoolean("mraidExpandCustomClose", false);
    }

    static /* synthetic */ ASWebviewInterstitialActivity access$300(MraidInterstitialStrategy mraidInterstitialStrategy) {
        return mraidInterstitialStrategy.activity;
    }

    static /* synthetic */ String access$400() {
        return LOG_TAG;
    }

    private void close() {
        try {
            this.webView.updateMraidState(MraidState.HIDDEN);
            AerServEventListenerLocator.fireEvent(this.controllerId, AerServEvent.AD_DISMISSED);
        }
        catch (Exception exception) {
            AerServLog.e(LOG_TAG, "Exception caught", exception);
        }
        this.activity.finish();
    }

    private void setOrientationProperties(boolean bl, String string) {
        this.activity.runOnUiThread(new Runnable(this, bl, string){
            final /* synthetic */ MraidInterstitialStrategy this$0;
            final /* synthetic */ boolean val$allowOrientationChange;
            final /* synthetic */ String val$forceOrientation;
            {
                this.this$0 = mraidInterstitialStrategy;
                this.val$allowOrientationChange = bl;
                this.val$forceOrientation = string;
            }

            public void run() {
                try {
                    if (this.val$allowOrientationChange) {
                        MraidInterstitialStrategy.access$300(this.this$0).setRequestedOrientation(10);
                    }
                    if (this.val$forceOrientation.equals((Object)"landscape")) {
                        MraidInterstitialStrategy.access$300(this.this$0).setRequestedOrientation(6);
                    } else if (this.val$forceOrientation.equals((Object)"portrait")) {
                        MraidInterstitialStrategy.access$300(this.this$0).setRequestedOrientation(7);
                    }
                    if (!this.val$allowOrientationChange) {
                        MraidInterstitialStrategy.access$300(this.this$0).setRequestedOrientation(14);
                        return;
                    }
                }
                catch (Exception exception) {
                    AerServLog.e(MraidInterstitialStrategy.access$400(), "Exception caught", exception);
                }
            }
        });
    }

    @Override
    public void buildInterstitialPlayer() {
        ASMraidWebView aSMraidWebView;
        this.relativeLayout = new RelativeLayout((Context)this.activity);
        this.relativeLayout.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
        this.relativeLayout.setBackgroundColor(-16777216);
        this.webViewContainer = new RelativeLayout((Context)this.activity);
        this.webViewContainer.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
        this.webViewContainer.setBackgroundColor(-16777216);
        this.webViewContainer.setGravity(17);
        OnCloseListener onCloseListener = new OnCloseListener(){

            @Override
            public void onClose() {
                MraidInterstitialStrategy.this.close();
            }
        };
        this.closeButton = new CloseButton((Context)this.activity);
        SetVisibilityListener setVisibilityListener = new SetVisibilityListener(){

            @Override
            public void setVisibility(boolean bl) {
                MraidInterstitialStrategy.this.closeButton.setVisibility(bl);
            }
        };
        MraidInterstitialJavascriptInterfaceListener mraidInterstitialJavascriptInterfaceListener = new MraidInterstitialJavascriptInterfaceListener((Context)this.activity, this.providerListener, onCloseListener, this.ad, this.controllerId, setVisibilityListener);
        this.webView = aSMraidWebView = new ASMraidWebView((Context)this.activity, (MraidJavascriptInterfaceListener)mraidInterstitialJavascriptInterfaceListener, this.providerListener, this.controllerId, this.showAdTimeout, this.ad.getVirtualCurrency().getAerServTransactionInformation());
        this.webView.registerProviderListener(this.providerListener);
        this.webView.setBackgroundColor(-16777216);
        this.webView.setOnSetOrientationPropertiesListener(new OnSetOrientationPropertiesListener(){

            @Override
            public void onSetOrientationProperties(boolean bl, String string) {
                MraidInterstitialStrategy.this.setOrientationProperties(bl, string);
            }
        });
        boolean bl = this.useCustomClose;
        if (bl) {
            this.closeButton.setVisibility(bl ^ true);
        }
        this.webViewContainer.addView((View)this.webView);
        this.relativeLayout.addView((View)this.webViewContainer);
        this.relativeLayout.addView((View)this.closeButton);
        this.activity.setContentView((View)this.relativeLayout);
    }

    /*
     * Exception decompiling
     */
    @Override
    public void onDestroy() {
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

    @Override
    public void onPause() {
        try {
            this.webView.fireViewableChange(false);
            this.webView.pause();
            return;
        }
        catch (Exception exception) {
            AerServLog.e(LOG_TAG, "Exception caught", exception);
            return;
        }
    }

    @Override
    public void onResume() {
        try {
            if (this.firstOnResume) {
                this.firstOnResume = false;
            } else {
                this.webView.fireViewableChange(true);
            }
            this.webView.resume();
            return;
        }
        catch (Exception exception) {
            AerServLog.e(LOG_TAG, "Exception caught", exception);
            return;
        }
    }

    @Override
    public void playInterstitial() {
        this.providerListener.onProviderAttempt();
        this.providerListener.onProviderImpression();
        this.webView.loadData(this.ad.getHTML());
    }

    @Override
    public void registerEvents() {
        this.closeButton.setOnClickListener(new View.OnClickListener(this){
            final /* synthetic */ MraidInterstitialStrategy this$0;
            {
                this.this$0 = mraidInterstitialStrategy;
            }

            public void onClick(View view) {
                MraidInterstitialStrategy.access$000(this.this$0);
            }
        });
    }

}

