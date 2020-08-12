/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.content.Context
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$OnKeyListener
 *  android.view.ViewGroup
 *  android.webkit.WebView
 *  android.webkit.WebViewClient
 *  android.widget.FrameLayout
 *  java.lang.CharSequence
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.amazon.device.ads;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import com.amazon.device.ads.AdCloser;
import com.amazon.device.ads.AdWebViewClient;
import com.amazon.device.ads.Destroyable;
import com.amazon.device.ads.NativeCloseButton;
import com.amazon.device.ads.PreloadCallback;
import com.amazon.device.ads.RelativePosition;
import com.amazon.device.ads.ViewManager;
import com.amazon.device.ads.ViewManagerFactory;

@SuppressLint(value={"ViewConstructor"})
class AdContainer
extends FrameLayout
implements Destroyable {
    private static final String CONTENT_DESCRIPTION_AD_CONTAINER = "adContainerObject";
    private boolean allowClicks = true;
    private String baseUrl;
    private boolean disableHardwareAcceleration = false;
    private String html;
    private final NativeCloseButton nativeCloseButton;
    private PreloadCallback preloadCallback;
    private boolean shouldPreload;
    private ViewManager viewManager;

    public AdContainer(Context context, AdCloser adCloser) {
        this(context, adCloser, new ViewManagerFactory(), null);
    }

    AdContainer(Context context, AdCloser adCloser, ViewManagerFactory viewManagerFactory, NativeCloseButton nativeCloseButton) {
        super(context);
        this.viewManager = viewManagerFactory.withViewGroup((ViewGroup)this).createViewManager();
        this.setContentDescription((CharSequence)CONTENT_DESCRIPTION_AD_CONTAINER);
        if (nativeCloseButton == null) {
            this.nativeCloseButton = new NativeCloseButton((ViewGroup)this, adCloser);
            return;
        }
        this.nativeCloseButton = nativeCloseButton;
    }

    public void addJavascriptInterface(Object object, boolean bl, String string) {
        this.viewManager.addJavascriptInterface(object, bl, string);
    }

    public boolean canShowViews() {
        return this.viewManager.canShowViews();
    }

    @Override
    public void destroy() {
        this.viewManager.destroy();
    }

    public void disableHardwareAcceleration(boolean bl) {
        this.disableHardwareAcceleration = bl;
        ViewManager viewManager = this.viewManager;
        if (viewManager != null) {
            viewManager.disableHardwareAcceleration(this.disableHardwareAcceleration);
        }
    }

    public void enableNativeCloseButton(boolean bl, RelativePosition relativePosition) {
        this.nativeCloseButton.enable(bl, relativePosition);
    }

    public WebView getCurrentAdView() {
        return this.viewManager.getCurrentAdView();
    }

    public int getViewHeight() {
        return this.viewManager.getHeight();
    }

    public void getViewLocationOnScreen(int[] arrn) {
        this.viewManager.getLocationOnScreen(arrn);
    }

    public int getViewWidth() {
        return this.viewManager.getWidth();
    }

    public void initialize() throws IllegalStateException {
        this.viewManager.disableHardwareAcceleration(this.disableHardwareAcceleration);
        this.viewManager.initialize();
    }

    public void injectJavascript(String string, boolean bl) {
        ViewManager viewManager = this.viewManager;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("javascript:");
        stringBuilder.append(string);
        viewManager.loadUrl(stringBuilder.toString(), bl, null);
    }

    public boolean isCurrentView(View view) {
        return this.viewManager.isCurrentView(view);
    }

    public void listenForKey(View.OnKeyListener onKeyListener) {
        this.viewManager.listenForKey(onKeyListener);
    }

    public void loadHtml(String string, String string2, boolean bl, PreloadCallback preloadCallback) {
        this.baseUrl = string;
        this.html = string2;
        this.shouldPreload = bl;
        this.preloadCallback = preloadCallback;
        this.viewManager.loadDataWithBaseURL(string, string2, "text/html", "UTF-8", null, bl, preloadCallback);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true ^ this.allowClicks;
    }

    public boolean popView() {
        return this.viewManager.popView();
    }

    public void reload() {
        this.loadHtml(this.baseUrl, this.html, this.shouldPreload, this.preloadCallback);
    }

    public void removeNativeCloseButton() {
        this.nativeCloseButton.remove();
    }

    public void removePreviousInterfaces() {
        this.viewManager.removePreviousInterfaces();
    }

    public void setAdWebViewClient(AdWebViewClient adWebViewClient) {
        this.viewManager.setWebViewClient(adWebViewClient);
    }

    public void setAllowClicks(boolean bl) {
        this.allowClicks = bl;
    }

    public void setViewHeight(int n2) {
        this.viewManager.setHeight(n2);
    }

    public void setViewLayoutParams(int n2, int n3, int n4) {
        this.viewManager.setLayoutParams(n2, n3, n4);
    }

    public void showNativeCloseButtonImage(boolean bl) {
        this.nativeCloseButton.showImage(bl);
    }

    public void stashView() {
        this.viewManager.stashView();
    }

}

