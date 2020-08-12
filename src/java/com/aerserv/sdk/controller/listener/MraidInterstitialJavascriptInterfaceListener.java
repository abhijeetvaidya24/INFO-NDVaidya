/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Point
 *  android.graphics.Rect
 *  android.view.OrientationEventListener
 *  android.view.View
 *  android.view.ViewParent
 *  com.aerserv.sdk.model.ad.MraidProviderAd
 *  com.aerserv.sdk.view.component.ASMraidWebView
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.List
 *  java.util.Properties
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.aerserv.sdk.controller.listener;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.OrientationEventListener;
import android.view.View;
import android.view.ViewParent;
import com.aerserv.sdk.AerServEvent;
import com.aerserv.sdk.adapter.asaerserv.mraid.MraidAction;
import com.aerserv.sdk.adapter.asaerserv.mraid.MraidEvent;
import com.aerserv.sdk.adapter.asaerserv.mraid.MraidPlacementType;
import com.aerserv.sdk.adapter.asaerserv.mraid.MraidState;
import com.aerserv.sdk.controller.command.FireEventCommand;
import com.aerserv.sdk.controller.command.LaunchBrowserCommand;
import com.aerserv.sdk.controller.command.PlayVideoCommand;
import com.aerserv.sdk.controller.listener.AerServEventListenerLocator;
import com.aerserv.sdk.controller.listener.MraidInterstitialJavascriptInterfaceListener;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import org.json.JSONException;
import org.json.JSONObject;

public class MraidInterstitialJavascriptInterfaceListener
implements MraidJavascriptInterfaceListener {
    private MraidProviderAd ad;
    private ASMraidWebView adView;
    private Context context;
    private String controllerId;
    private Rect lastSize;
    private OnCloseListener onCloseListener;
    private OrientationEventListener orientationEventListener;
    private ProviderListener providerListener;
    private SetVisibilityListener setVisibilityListener;

    public MraidInterstitialJavascriptInterfaceListener(Context context, ProviderListener providerListener, OnCloseListener onCloseListener, MraidProviderAd mraidProviderAd, String string, SetVisibilityListener setVisibilityListener) {
        this.context = context;
        this.ad = mraidProviderAd;
        this.providerListener = providerListener;
        this.onCloseListener = onCloseListener;
        this.setVisibilityListener = setVisibilityListener;
        this.controllerId = string;
        this.orientationEventListener = new OrientationEventListener(this, context){
            final /* synthetic */ MraidInterstitialJavascriptInterfaceListener this$0;
            {
                this.this$0 = mraidInterstitialJavascriptInterfaceListener;
                super(context);
            }

            public void onOrientationChanged(int n2) {
                this.this$0.onSizeChange();
            }
        };
        this.orientationEventListener.enable();
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
        this.adView = null;
        this.context = null;
        this.ad = null;
        this.providerListener = null;
        this.setVisibilityListener = null;
        this.onCloseListener = null;
    }

    @Override
    public void close() {
        this.onCloseListener.onClose();
    }

    @Override
    public void expand(JSONObject jSONObject, String string) throws JSONException {
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
        this.fireImpPixel(aerServEvent);
        if (aerServEvent != AerServEvent.AD_IMPRESSION) {
            AerServEventListenerLocator.fireEvent(this.controllerId, aerServEvent, list);
        }
    }

    @Override
    public Rect getCurrentPosition() {
        return DisplayUtils.convertRectToDip(this.context, DisplayUtils.getViewSize((View)this.adView.getParent()));
    }

    @Override
    public Point getMaxSize() {
        Context context = this.context;
        return DisplayUtils.convertPointToDip(context, DisplayUtils.getActivitySize(context));
    }

    @Override
    public MraidPlacementType getPlacementType() {
        return MraidPlacementType.INTERSTITIAL;
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
        Properties properties = new Properties();
        properties.put((Object)"context", (Object)this.context);
        properties.put((Object)"controllerId", (Object)this.controllerId);
        properties.put((Object)"providerAd", (Object)AdFactory.buildVideoMraidProviderAd(this.ad.getPlacement()));
        properties.setProperty("mraidPlayVideoUrl", string);
        new PlayVideoCommand(properties).execute();
    }

    @Override
    public void resize(JSONObject jSONObject) throws JSONException {
    }

    @Override
    public void setAdView(ASMraidWebView aSMraidWebView) {
        this.adView = aSMraidWebView;
    }

    @Override
    public void setOrientationProperties(JSONObject jSONObject) throws JSONException {
        this.adView.setOrientationProperties(jSONObject);
    }

    @Override
    public void useCustomClose(boolean bl) {
        this.setVisibilityListener.setVisibility(bl ^ true);
    }
}

