/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.content.Context
 *  android.webkit.JavascriptInterface
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.tapjoy.mraid.controller;

import android.annotation.TargetApi;
import android.content.Context;
import android.webkit.JavascriptInterface;
import com.tapjoy.TapjoyLog;
import com.tapjoy.mraid.controller.Abstract;
import com.tapjoy.mraid.controller.Assets;
import com.tapjoy.mraid.controller.Display;
import com.tapjoy.mraid.controller.MraidSensor;
import com.tapjoy.mraid.controller.Network;
import com.tapjoy.mraid.view.MraidView;

@TargetApi(value=14)
public class Utility
extends Abstract {
    private Assets c;
    private Display d;
    private Network e;
    private MraidSensor f;

    public Utility(MraidView mraidView, Context context) {
        super(mraidView, context);
        this.c = new Assets(mraidView, context);
        this.d = new Display(mraidView, context);
        this.e = new Network(mraidView, context);
        this.f = new MraidSensor(mraidView, context);
        mraidView.addJavascriptInterface((Object)this.c, "MRAIDAssetsControllerBridge");
        mraidView.addJavascriptInterface((Object)this.d, "MRAIDDisplayControllerBridge");
        mraidView.addJavascriptInterface((Object)this.e, "MRAIDNetworkControllerBridge");
        mraidView.addJavascriptInterface((Object)this.f, "MRAIDSensorControllerBridge");
    }

    @JavascriptInterface
    public void activate(String string) {
        StringBuilder stringBuilder = new StringBuilder("activate: ");
        stringBuilder.append(string);
        TapjoyLog.d("MRAID Utility", stringBuilder.toString());
        if (string.equalsIgnoreCase("networkChange")) {
            this.e.startNetworkListener();
            return;
        }
        if (string.equalsIgnoreCase("shake")) {
            this.f.startShakeListener();
            return;
        }
        if (string.equalsIgnoreCase("tiltChange")) {
            this.f.startTiltListener();
            return;
        }
        if (string.equalsIgnoreCase("headingChange")) {
            this.f.startHeadingListener();
            return;
        }
        if (string.equalsIgnoreCase("orientationChange")) {
            this.d.startConfigurationListener();
        }
    }

    public String copyTextFromJarIntoAssetDir(String string, String string2) {
        return this.c.copyTextFromJarIntoAssetDir(string, string2);
    }

    @JavascriptInterface
    public void deactivate(String string) {
        StringBuilder stringBuilder = new StringBuilder("deactivate: ");
        stringBuilder.append(string);
        TapjoyLog.d("MRAID Utility", stringBuilder.toString());
        if (string.equalsIgnoreCase("networkChange")) {
            this.e.stopNetworkListener();
            return;
        }
        if (string.equalsIgnoreCase("shake")) {
            this.f.stopShakeListener();
            return;
        }
        if (string.equalsIgnoreCase("tiltChange")) {
            this.f.stopTiltListener();
            return;
        }
        if (string.equalsIgnoreCase("headingChange")) {
            this.f.stopHeadingListener();
            return;
        }
        if (string.equalsIgnoreCase("orientationChange")) {
            this.d.stopConfigurationListener();
        }
    }

    public void deleteOldAds() {
        this.c.deleteOldAds();
    }

    public void fireReadyEvent() {
        this.a.injectMraidJavaScript("mraid.signalReady();");
    }

    public void fireViewableChange(boolean bl) {
        MraidView mraidView = this.a;
        StringBuilder stringBuilder = new StringBuilder("window.mraidview.fireChangeEvent({viewable:");
        stringBuilder.append(bl);
        stringBuilder.append("});");
        mraidView.injectMraidJavaScript(stringBuilder.toString());
    }

    public void init(float f2) {
        StringBuilder stringBuilder = new StringBuilder("window.mraidview.fireChangeEvent({ state: 'default', network: '");
        stringBuilder.append(this.e.getNetwork());
        stringBuilder.append("', size: ");
        stringBuilder.append(this.d.getSize());
        stringBuilder.append(", placement: '");
        stringBuilder.append((Object)this.a.getPlacementType());
        stringBuilder.append("', maxSize: ");
        stringBuilder.append(this.d.getMaxSize());
        stringBuilder.append(",expandProperties: ");
        stringBuilder.append(this.d.getMaxSize());
        stringBuilder.append(", screenSize: ");
        stringBuilder.append(this.d.getScreenSize());
        stringBuilder.append(", defaultPosition: { x:");
        stringBuilder.append((int)((float)this.a.getLeft() / f2));
        stringBuilder.append(", y: ");
        stringBuilder.append((int)((float)this.a.getTop() / f2));
        stringBuilder.append(", width: ");
        stringBuilder.append((int)((float)this.a.getWidth() / f2));
        stringBuilder.append(", height: ");
        stringBuilder.append((int)((float)this.a.getHeight() / f2));
        stringBuilder.append(" }, orientation:");
        stringBuilder.append(this.d.getOrientation());
        stringBuilder.append(",");
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("supports: [ 'level-1', 'level-2', 'screen', 'orientation', 'network'");
        stringBuilder2.append(", 'video'");
        String string = stringBuilder2.toString();
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append(string);
        stringBuilder3.append(", 'audio'");
        String string2 = stringBuilder3.toString();
        StringBuilder stringBuilder4 = new StringBuilder();
        stringBuilder4.append(string2);
        stringBuilder4.append(", 'map' ]");
        String string3 = stringBuilder4.toString();
        StringBuilder stringBuilder5 = new StringBuilder("getSupports: ");
        stringBuilder5.append(string3);
        TapjoyLog.d("MRAID Utility", stringBuilder5.toString());
        stringBuilder.append(string3);
        stringBuilder.append(",viewable:true });");
        String string4 = stringBuilder.toString();
        StringBuilder stringBuilder6 = new StringBuilder("init: injection: ");
        stringBuilder6.append(string4);
        TapjoyLog.d("MRAID Utility", stringBuilder6.toString());
        this.a.injectMraidJavaScript(string4);
        this.fireReadyEvent();
        this.fireViewableChange(true);
    }

    public void setMaxSize(int n2, int n3) {
        this.d.setMaxSize(n2, n3);
    }

    @JavascriptInterface
    public void showAlert(String string) {
        TapjoyLog.e("MRAID Utility", string);
    }

    @Override
    public void stopAllListeners() {
        try {
            this.c.stopAllListeners();
            this.d.stopAllListeners();
            this.e.stopAllListeners();
            this.f.stopAllListeners();
        }
        catch (Exception exception) {}
    }
}

