/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.graphics.Point
 *  android.graphics.Rect
 *  android.os.Handler
 *  android.os.Looper
 *  android.view.OrientationEventListener
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewParent
 *  android.widget.RelativeLayout
 *  android.widget.RelativeLayout$LayoutParams
 *  com.aerserv.sdk.model.ad.MraidProviderAd
 *  com.aerserv.sdk.view.component.ASMraidWebView
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.List
 *  java.util.Properties
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.aerserv.sdk.controller.listener;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.view.OrientationEventListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import com.aerserv.sdk.AerServEvent;
import com.aerserv.sdk.adapter.asaerserv.mraid.MraidAction;
import com.aerserv.sdk.adapter.asaerserv.mraid.MraidEvent;
import com.aerserv.sdk.adapter.asaerserv.mraid.MraidPlacementType;
import com.aerserv.sdk.adapter.asaerserv.mraid.MraidState;
import com.aerserv.sdk.controller.command.FireEventCommand;
import com.aerserv.sdk.controller.command.LaunchBrowserCommand;
import com.aerserv.sdk.controller.command.PlayVideoCommand;
import com.aerserv.sdk.controller.listener.AerServEventListenerLocator;
import com.aerserv.sdk.controller.listener.MraidBannerJavascriptInterfaceListener;
import com.aerserv.sdk.controller.listener.MraidJavascriptInterfaceListener;
import com.aerserv.sdk.controller.listener.OnCloseListener;
import com.aerserv.sdk.controller.listener.ProviderListener;
import com.aerserv.sdk.controller.listener.SetVisibilityListener;
import com.aerserv.sdk.factory.AdFactory;
import com.aerserv.sdk.model.Placement;
import com.aerserv.sdk.model.ad.MraidProviderAd;
import com.aerserv.sdk.utils.AerServLog;
import com.aerserv.sdk.utils.DeviceInfo;
import com.aerserv.sdk.utils.DisplayUtils;
import com.aerserv.sdk.view.component.ASMraidWebView;
import com.aerserv.sdk.view.component.CloseButton;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import org.json.JSONException;
import org.json.JSONObject;

public class MraidBannerJavascriptInterfaceListener
implements MraidJavascriptInterfaceListener {
    private static final String LOG_TAG = "com.aerserv.sdk.controller.listener.MraidBannerJavascriptInterfaceListener";
    private MraidProviderAd ad;
    private ASMraidWebView adView;
    private CloseButton closeButton;
    private Context context;
    private String controllerId;
    private Rect defaultPosition;
    private OnCloseListener lastOnCloseListener;
    private Rect lastSize;
    private OnCloseListener onCloseListener;
    private OrientationEventListener orientationEventListener;
    private Properties properties;
    private ProviderListener providerListener;
    private SetVisibilityListener setVisibilityListener;

    public MraidBannerJavascriptInterfaceListener(Context context, Properties properties, ProviderListener providerListener, SetVisibilityListener setVisibilityListener) {
        this.context = context;
        this.properties = properties;
        this.providerListener = providerListener;
        this.setVisibilityListener = setVisibilityListener;
        String string = this.controllerId = properties.getProperty("controllerId");
        if (string != null && !string.isEmpty()) {
            this.ad = (MraidProviderAd)properties.get((Object)"providerAd");
            if (this.ad != null) {
                this.properties.put((Object)"mraidJavascriptInterfaceListener", (Object)this);
                this.orientationEventListener = new OrientationEventListener(this, context){
                    final /* synthetic */ MraidBannerJavascriptInterfaceListener this$0;
                    {
                        this.this$0 = mraidBannerJavascriptInterfaceListener;
                        super(context);
                    }

                    public void onOrientationChanged(int n2) {
                        this.this$0.onSizeChange();
                    }
                };
                this.orientationEventListener.enable();
                return;
            }
            throw new IllegalArgumentException("providerAd not found in properties");
        }
        throw new IllegalArgumentException("controllerId not found in properties");
    }

    static /* synthetic */ CloseButton access$000(MraidBannerJavascriptInterfaceListener mraidBannerJavascriptInterfaceListener) {
        return mraidBannerJavascriptInterfaceListener.closeButton;
    }

    static /* synthetic */ CloseButton access$002(MraidBannerJavascriptInterfaceListener mraidBannerJavascriptInterfaceListener, CloseButton closeButton) {
        mraidBannerJavascriptInterfaceListener.closeButton = closeButton;
        return closeButton;
    }

    static /* synthetic */ ASMraidWebView access$100(MraidBannerJavascriptInterfaceListener mraidBannerJavascriptInterfaceListener) {
        return mraidBannerJavascriptInterfaceListener.adView;
    }

    static /* synthetic */ String access$200() {
        return LOG_TAG;
    }

    static /* synthetic */ String access$300(MraidBannerJavascriptInterfaceListener mraidBannerJavascriptInterfaceListener) {
        return mraidBannerJavascriptInterfaceListener.controllerId;
    }

    private void fireImpPixel(AerServEvent aerServEvent) {
        if (aerServEvent == AerServEvent.AD_IMPRESSION && this.adView.mraidImpressionUriStr != null) {
            new FireEventCommand(this.adView.mraidImpressionUriStr).execute();
        }
    }

    private MraidState getMraidState() {
        return this.adView.getMraidState();
    }

    @Override
    public void checkReady() {
        this.adView.checkReady();
    }

    @Override
    public void cleanup() {
        this.orientationEventListener.disable();
        this.orientationEventListener = null;
        this.context = null;
        this.adView = null;
        this.ad = null;
        this.providerListener = null;
    }

    @Override
    public void close() {
        if (this.getMraidState() == MraidState.EXPANDED || this.getMraidState() == MraidState.RESIZED) {
            this.onCloseListener.onClose();
        }
    }

    public void closeResizedBanner() {
        RelativeLayout relativeLayout = (RelativeLayout)this.adView.getParent();
        ViewGroup.LayoutParams layoutParams = relativeLayout.getLayoutParams();
        layoutParams.height = DisplayUtils.convertDipToPx(this.context, this.defaultPosition.height());
        Runnable runnable = new Runnable(this, relativeLayout, layoutParams){
            final /* synthetic */ MraidBannerJavascriptInterfaceListener this$0;
            final /* synthetic */ ViewGroup.LayoutParams val$params;
            final /* synthetic */ RelativeLayout val$parentLayout;
            {
                this.this$0 = mraidBannerJavascriptInterfaceListener;
                this.val$parentLayout = relativeLayout;
                this.val$params = layoutParams;
            }

            public void run() {
                try {
                    this.val$parentLayout.setLayoutParams(this.val$params);
                    this.val$parentLayout.removeView((View)MraidBannerJavascriptInterfaceListener.access$000(this.this$0));
                    MraidBannerJavascriptInterfaceListener.access$002(this.this$0, null);
                    this.this$0.setOnCloseListener(null);
                    MraidBannerJavascriptInterfaceListener.access$100(this.this$0).updateMraidState(MraidState.DEFAULT);
                    return;
                }
                catch (Exception exception) {
                    AerServLog.e(MraidBannerJavascriptInterfaceListener.access$200(), "Exception caught", exception);
                    return;
                }
            }
        };
        new Handler(Looper.getMainLooper()).post(runnable);
    }

    @Override
    public void expand(JSONObject jSONObject, String string) throws JSONException {
        if (this.getMraidState() == MraidState.DEFAULT || this.getMraidState() == MraidState.RESIZED) {
            this.properties.put((Object)"providerAd", (Object)AdFactory.buildExpandedMraidProviderAd(this.ad.getPlacement()));
            this.properties.put((Object)"mraidExpandCustomClose", (Object)jSONObject.getBoolean("useCustomClose"));
            this.providerListener.onExpand(this.properties, string);
        }
    }

    @Override
    public void fireEvent(AerServEvent aerServEvent) {
        this.fireEvent(aerServEvent, (List<Object>)new ArrayList());
    }

    @Override
    public void fireEvent(AerServEvent aerServEvent, Object object) {
        this.fireImpPixel(aerServEvent);
        if (aerServEvent != AerServEvent.AD_IMPRESSION) {
            AerServEventListenerLocator.fireEvent(this.controllerId, aerServEvent, object);
        }
    }

    @Override
    public void fireEvent(AerServEvent aerServEvent, List<Object> list) {
        Context context;
        this.fireImpPixel(aerServEvent);
        if (aerServEvent != AerServEvent.AD_IMPRESSION) {
            AerServEventListenerLocator.fireEvent(this.controllerId, aerServEvent, list);
        }
        if (aerServEvent == AerServEvent.VIDEO_COMPLETED && (context = this.context) instanceof Activity) {
            ((Activity)context).runOnUiThread(new Runnable(this){
                final /* synthetic */ MraidBannerJavascriptInterfaceListener this$0;
                {
                    this.this$0 = mraidBannerJavascriptInterfaceListener;
                }

                public void run() {
                    com.aerserv.sdk.utils.MoatUtils.cleanup(MraidBannerJavascriptInterfaceListener.access$300(this.this$0));
                }
            });
        }
    }

    @Override
    public Rect getCurrentPosition() {
        Rect rect = DisplayUtils.convertRectToDip(this.context, DisplayUtils.getViewSize((View)this.adView.getParent()));
        if (this.defaultPosition == null) {
            this.defaultPosition = rect;
        }
        return rect;
    }

    @Override
    public Point getMaxSize() {
        Context context = this.context;
        return DisplayUtils.convertPointToDip(context, DisplayUtils.getActivitySize(context));
    }

    @Override
    public MraidPlacementType getPlacementType() {
        return MraidPlacementType.INLINE;
    }

    @Override
    public Point getScreenSize() {
        Context context = this.context;
        return DisplayUtils.convertPointToDip(context, DeviceInfo.getScreenSize(context));
    }

    @Override
    public MraidState getState() {
        return this.getMraidState();
    }

    @Override
    public void isReady() {
        this.adView.isReady();
        this.fireEvent(AerServEvent.MRAID_READY);
    }

    @Override
    public void onError(MraidAction mraidAction, Exception exception) {
        String string = this.getClass().getName();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Exception caught while attempting ");
        stringBuilder.append(mraidAction.getName());
        AerServLog.w(string, stringBuilder.toString(), exception);
        String string2 = exception.getMessage();
        String string3 = string2 == null ? "unknown error" : string2.replaceAll("'", "\"");
        ASMraidWebView aSMraidWebView = this.adView;
        MraidEvent mraidEvent = MraidEvent.ERROR;
        Object[] arrobject = new Object[]{mraidAction.getName(), string3};
        aSMraidWebView.fireEvent(mraidEvent, arrobject);
    }

    /*
     * Exception decompiling
     */
    @Override
    public void onSizeChange() {
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
    public void open(String string) {
        new LaunchBrowserCommand(this.context, string).execute();
    }

    @Override
    public void playVideo(String string) {
        this.properties.put((Object)"context", (Object)this.context);
        this.properties.put((Object)"providerAd", (Object)AdFactory.buildVideoMraidProviderAd(this.ad.getPlacement()));
        this.properties.setProperty("mraidPlayVideoUrl", string);
        new PlayVideoCommand(this.properties).execute();
    }

    @Override
    public void resize(JSONObject jSONObject) throws JSONException {
        int n2 = 7.$SwitchMap$com$aerserv$sdk$adapter$asaerserv$mraid$MraidState[this.getMraidState().ordinal()];
        if (n2 != 1 && n2 != 2) {
            if (n2 != 3) {
                int n3 = jSONObject.getInt("height");
                String string = jSONObject.getString("customClosePosition");
                boolean bl = jSONObject.getBoolean("allowOffscreen");
                Point point = this.getMaxSize();
                if (n3 >= 50) {
                    if (!bl && n3 > point.y) {
                        throw new IllegalArgumentException("The height value is too big for the screen");
                    }
                    int n4 = DisplayUtils.convertDipToPx(this.context, n3);
                    boolean bl2 = this.closeButton == null;
                    if (bl2) {
                        this.closeButton = new CloseButton(this.context);
                    }
                    this.closeButton.setVisibility(false);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.closeButton.size, this.closeButton.size);
                    if (string.equals((Object)"center")) {
                        layoutParams.addRule(13);
                    } else {
                        if (string.contains((CharSequence)"bottom")) {
                            layoutParams.addRule(12);
                        } else {
                            layoutParams.addRule(10);
                        }
                        if (string.contains((CharSequence)"left")) {
                            layoutParams.addRule(9);
                        } else if (string.contains((CharSequence)"center")) {
                            layoutParams.addRule(14);
                        } else {
                            layoutParams.addRule(11);
                        }
                    }
                    this.closeButton.setOnClickListener(new View.OnClickListener(this){
                        final /* synthetic */ MraidBannerJavascriptInterfaceListener this$0;
                        {
                            this.this$0 = mraidBannerJavascriptInterfaceListener;
                        }

                        public void onClick(View view) {
                            this.this$0.close();
                        }
                    });
                    this.setOnCloseListener(new OnCloseListener(){

                        @Override
                        public void onClose() {
                            MraidBannerJavascriptInterfaceListener.this.closeResizedBanner();
                        }
                    });
                    RelativeLayout relativeLayout = (RelativeLayout)this.adView.getParent();
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams)relativeLayout.getLayoutParams();
                    layoutParams2.height = n4;
                    Runnable runnable = new Runnable(this, relativeLayout, layoutParams2, layoutParams, bl2){
                        final /* synthetic */ MraidBannerJavascriptInterfaceListener this$0;
                        final /* synthetic */ RelativeLayout.LayoutParams val$buttonParams;
                        final /* synthetic */ boolean val$newCloseButton;
                        final /* synthetic */ RelativeLayout.LayoutParams val$params;
                        final /* synthetic */ RelativeLayout val$parentLayout;
                        {
                            this.this$0 = mraidBannerJavascriptInterfaceListener;
                            this.val$parentLayout = relativeLayout;
                            this.val$params = layoutParams;
                            this.val$buttonParams = layoutParams2;
                            this.val$newCloseButton = bl;
                        }

                        public void run() {
                            try {
                                this.val$parentLayout.setLayoutParams((ViewGroup.LayoutParams)this.val$params);
                                MraidBannerJavascriptInterfaceListener.access$000(this.this$0).setLayoutParams((ViewGroup.LayoutParams)this.val$buttonParams);
                                if (this.val$newCloseButton) {
                                    this.val$parentLayout.addView((View)MraidBannerJavascriptInterfaceListener.access$000(this.this$0));
                                }
                                MraidBannerJavascriptInterfaceListener.access$100(this.this$0).updateMraidState(MraidState.RESIZED);
                                return;
                            }
                            catch (Exception exception) {
                                AerServLog.e(MraidBannerJavascriptInterfaceListener.access$200(), "Exception caught", exception);
                                return;
                            }
                        }
                    };
                    new Handler(Looper.getMainLooper()).post(runnable);
                    return;
                }
                throw new IllegalArgumentException("Resized creatives must be at least 50x50 to fit the close region");
            }
            throw new IllegalStateException("Cannot call mraid.resize() while banner is in state EXPANDED");
        }
    }

    public void revertOnCloseListener() {
        this.onCloseListener = this.lastOnCloseListener;
    }

    @Override
    public void setAdView(ASMraidWebView aSMraidWebView) {
        this.adView = aSMraidWebView;
        this.properties.setProperty("mraidBannerViewId", aSMraidWebView.VIEW_ID);
    }

    public void setOnCloseListener(OnCloseListener onCloseListener) {
        this.lastOnCloseListener = this.onCloseListener;
        this.onCloseListener = onCloseListener;
    }

    @Override
    public void setOrientationProperties(JSONObject jSONObject) throws JSONException {
        this.adView.setOrientationProperties(jSONObject);
    }

    @Override
    public void useCustomClose(boolean bl) {
        SetVisibilityListener setVisibilityListener = this.setVisibilityListener;
        if (setVisibilityListener != null) {
            setVisibilityListener.setVisibility(bl ^ true);
        }
    }

}

