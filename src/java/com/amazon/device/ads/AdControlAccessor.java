/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewTreeObserver
 *  android.view.ViewTreeObserver$OnGlobalLayoutListener
 *  com.amazon.device.ads.AdController
 *  java.lang.Object
 *  java.lang.String
 */
package com.amazon.device.ads;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.amazon.device.ads.AdController;
import com.amazon.device.ads.AdData;
import com.amazon.device.ads.AdEvent;
import com.amazon.device.ads.AdState;
import com.amazon.device.ads.Position;
import com.amazon.device.ads.PreloadCallback;
import com.amazon.device.ads.RelativePosition;
import com.amazon.device.ads.SDKEventListener;
import com.amazon.device.ads.Size;

class AdControlAccessor {
    private final AdController adController;

    public AdControlAccessor(AdController adController) {
        this.adController = adController;
    }

    public void addJavascriptInterface(Object object, boolean bl, String string) {
        this.adController.addJavascriptInterface(object, bl, string);
    }

    public void addOnGlobalLayoutListener(ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        this.adController.addOnGlobalLayoutListener(onGlobalLayoutListener);
    }

    public void addSDKEventListener(SDKEventListener sDKEventListener) {
        this.adController.addSDKEventListener(sDKEventListener);
    }

    public boolean closeAd() {
        return this.adController.closeAd();
    }

    public void deregisterViewabilityInterest() {
        this.adController.deregisterViewabilityInterest();
    }

    public void enableCloseButton(boolean bl) {
        this.enableCloseButton(bl, null);
    }

    public void enableCloseButton(boolean bl, RelativePosition relativePosition) {
        this.adController.enableNativeCloseButton(bl, relativePosition);
    }

    public void fireAdEvent(AdEvent adEvent) {
        this.adController.fireAdEvent(adEvent);
    }

    public Activity getAdActivity() {
        return this.adController.getAdActivity();
    }

    public int getAdHeight() {
        return this.adController.getAdData().getHeight();
    }

    public AdState getAdState() {
        return this.adController.getAdState();
    }

    public int getAdWidth() {
        return this.adController.getAdData().getWidth();
    }

    public Context getContext() {
        return this.adController.getContext();
    }

    public Position getCurrentPosition() {
        return this.adController.getAdPosition();
    }

    public String getInstrumentationPixelUrl() {
        return this.adController.getInstrumentationPixelUrl();
    }

    public Size getMaxSize() {
        return this.adController.getMaxExpandableSize();
    }

    public View getRootView() {
        return this.adController.getRootView();
    }

    public double getScalingMultiplier() {
        return this.adController.getScalingMultiplier();
    }

    public Size getScreenSize() {
        return this.adController.getScreenSize();
    }

    public String getSlotID() {
        return this.adController.getSlotID();
    }

    public int getViewHeight() {
        return this.adController.getViewHeight();
    }

    public ViewGroup getViewParentIfExpanded() {
        return this.adController.getViewParentIfExpanded();
    }

    public int getViewWidth() {
        return this.adController.getViewWidth();
    }

    public int getWindowHeight() {
        return this.adController.getWindowHeight();
    }

    public int getWindowWidth() {
        return this.adController.getWindowWidth();
    }

    public void injectJavascript(String string) {
        this.adController.injectJavascript(string, false);
    }

    public void injectJavascriptPreload(String string) {
        this.adController.injectJavascript(string, true);
    }

    public boolean isInterstitial() {
        return this.adController.isInterstitial();
    }

    public boolean isModal() {
        return this.adController.isModal();
    }

    public boolean isViewable() {
        return this.adController.isViewable();
    }

    public boolean isVisible() {
        return this.adController.isVisible();
    }

    public void loadHtml(String string, String string2) {
        this.adController.loadHtml(string, string2);
    }

    public void loadHtml(String string, String string2, boolean bl, PreloadCallback preloadCallback) {
        this.adController.loadHtml(string, string2, bl, preloadCallback);
    }

    public void loadUrl(String string) {
        this.adController.loadUrl(string);
    }

    public void moveViewBackToParent(ViewGroup.LayoutParams layoutParams) {
        this.adController.moveViewBackToParent(layoutParams);
    }

    public void moveViewToViewGroup(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, boolean bl) {
        this.adController.moveViewToViewGroup(viewGroup, layoutParams, bl);
    }

    public boolean onBackButtonPress() {
        return this.adController.onBackButtonPress();
    }

    public void openUrl(String string) {
        this.adController.openUrl(string);
    }

    public void orientationChangeAttemptedWhenNotAllowed() {
        this.adController.orientationChangeAttemptedWhenNotAllowed();
    }

    public void overrideBackButton(boolean bl) {
        this.adController.overrideBackButton(bl);
    }

    public boolean popView() {
        return this.adController.popView();
    }

    public void preloadHtml(String string, String string2, PreloadCallback preloadCallback) {
        this.adController.preloadHtml(string, string2, preloadCallback);
    }

    public void preloadUrl(String string, PreloadCallback preloadCallback) {
        this.adController.preloadUrl(string, preloadCallback);
    }

    public void registerViewabilityInterest() {
        this.adController.registerViewabilityInterest();
    }

    public void reload() {
        this.adController.reload();
    }

    public void removeCloseButton() {
        this.adController.removeNativeCloseButton();
    }

    public void removeOnGlobalLayoutListener(ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        this.adController.removeOnGlobalLayoutListener(onGlobalLayoutListener);
    }

    public void setAdActivity(Activity activity) {
        this.adController.setAdActivity(activity);
    }

    public void setExpanded(boolean bl) {
        this.adController.setExpanded(bl);
    }

    public void showNativeCloseButtonImage(boolean bl) {
        this.adController.showNativeCloseButtonImage(bl);
    }

    public void stashView() {
        this.adController.stashView();
    }
}

