/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.media.AudioManager
 *  android.media.AudioManager$OnAudioFocusChangeListener
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Parcelable
 *  android.text.TextUtils
 *  android.view.KeyEvent
 *  android.view.View
 *  android.view.View$OnSystemUiVisibilityChangeListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewParent
 *  android.view.Window
 *  android.widget.FrameLayout
 *  android.widget.RelativeLayout
 *  android.widget.RelativeLayout$LayoutParams
 *  com.ironsource.sdk.agent.IronSourceAdsPublisherAgent
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.ironsource.sdk.controller;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.ironsource.environment.DeviceStatus;
import com.ironsource.sdk.agent.IronSourceAdsPublisherAgent;
import com.ironsource.sdk.controller.ControllerActivity;
import com.ironsource.sdk.controller.IronSourceWebView;
import com.ironsource.sdk.controller.VideoEventsListener;
import com.ironsource.sdk.data.AdUnitsState;
import com.ironsource.sdk.data.SSAEnums;
import com.ironsource.sdk.handlers.BackButtonHandler;
import com.ironsource.sdk.listeners.OnWebViewChangeListener;
import com.ironsource.sdk.utils.Logger;

public class ControllerActivity
extends Activity
implements VideoEventsListener,
OnWebViewChangeListener {
    private static final String TAG = "ControllerActivity";
    final RelativeLayout.LayoutParams MATCH_PARENT_LAYOUT_PARAMS = new RelativeLayout.LayoutParams(-1, -1);
    private boolean calledFromOnCreate = false;
    public int currentRequestedRotation = -1;
    private final Runnable decorViewSettings = new Runnable(this){
        final /* synthetic */ ControllerActivity this$0;
        {
            this.this$0 = controllerActivity;
        }

        public void run() {
            this.this$0.getWindow().getDecorView().setSystemUiVisibility(com.ironsource.sdk.utils.SDKUtils.getActivityUIFlags(ControllerActivity.access$000(this.this$0)));
        }
    };
    private RelativeLayout mContainer;
    private boolean mIsImmersive = false;
    private String mProductType;
    private AdUnitsState mState;
    private Handler mUiThreadHandler = new Handler();
    private IronSourceWebView mWebViewController;
    private FrameLayout mWebViewFrameContainer;

    static /* synthetic */ boolean access$000(ControllerActivity controllerActivity) {
        return controllerActivity.mIsImmersive;
    }

    static /* synthetic */ Runnable access$100(ControllerActivity controllerActivity) {
        return controllerActivity.decorViewSettings;
    }

    static /* synthetic */ Handler access$200(ControllerActivity controllerActivity) {
        return controllerActivity.mUiThreadHandler;
    }

    private void cancelScreenOn() {
        this.runOnUiThread(new Runnable(this){
            final /* synthetic */ ControllerActivity this$0;
            {
                this.this$0 = controllerActivity;
            }

            public void run() {
                this.this$0.getWindow().clearFlags(128);
            }
        });
    }

    private void handleOrientationState(String string, int n2) {
        if (string != null) {
            if ("landscape".equalsIgnoreCase(string)) {
                this.setInitiateLandscapeOrientation();
                return;
            }
            if ("portrait".equalsIgnoreCase(string)) {
                this.setInitiatePortraitOrientation();
                return;
            }
            if ("device".equalsIgnoreCase(string)) {
                if (DeviceStatus.isDeviceOrientationLocked((Context)this)) {
                    this.setRequestedOrientation(1);
                    return;
                }
            } else if (this.getRequestedOrientation() == -1) {
                this.setRequestedOrientation(4);
            }
        }
    }

    private void hideActivityTitle() {
        this.requestWindowFeature(1);
    }

    private void hideActivtiyStatusBar() {
        this.getWindow().setFlags(1024, 1024);
    }

    private void initOrientationState() {
        Intent intent = this.getIntent();
        this.handleOrientationState(intent.getStringExtra("orientation_set_flag"), intent.getIntExtra("rotation_set_flag", 0));
    }

    private void keepScreenOn() {
        this.runOnUiThread(new Runnable(this){
            final /* synthetic */ ControllerActivity this$0;
            {
                this.this$0 = controllerActivity;
            }

            public void run() {
                this.this$0.getWindow().addFlags(128);
            }
        });
    }

    private void removeWebViewContainerView() {
        ViewGroup viewGroup;
        if (this.mContainer != null && (viewGroup = (ViewGroup)this.mWebViewFrameContainer.getParent()).findViewById(1) != null) {
            viewGroup.removeView((View)this.mWebViewFrameContainer);
        }
    }

    private void setInitiateLandscapeOrientation() {
        int n2 = DeviceStatus.getApplicationRotation((Context)this);
        Logger.i(TAG, "setInitiateLandscapeOrientation");
        if (n2 == 0) {
            Logger.i(TAG, "ROTATION_0");
            this.setRequestedOrientation(0);
            return;
        }
        if (n2 == 2) {
            Logger.i(TAG, "ROTATION_180");
            this.setRequestedOrientation(8);
            return;
        }
        if (n2 == 3) {
            Logger.i(TAG, "ROTATION_270 Right Landscape");
            this.setRequestedOrientation(8);
            return;
        }
        if (n2 == 1) {
            Logger.i(TAG, "ROTATION_90 Left Landscape");
            this.setRequestedOrientation(0);
            return;
        }
        Logger.i(TAG, "No Rotation");
    }

    private void setInitiatePortraitOrientation() {
        int n2 = DeviceStatus.getApplicationRotation((Context)this);
        Logger.i(TAG, "setInitiatePortraitOrientation");
        if (n2 == 0) {
            Logger.i(TAG, "ROTATION_0");
            this.setRequestedOrientation(1);
            return;
        }
        if (n2 == 2) {
            Logger.i(TAG, "ROTATION_180");
            this.setRequestedOrientation(9);
            return;
        }
        if (n2 == 1) {
            Logger.i(TAG, "ROTATION_270 Right Landscape");
            this.setRequestedOrientation(1);
            return;
        }
        if (n2 == 3) {
            Logger.i(TAG, "ROTATION_90 Left Landscape");
            this.setRequestedOrientation(1);
            return;
        }
        Logger.i(TAG, "No Rotation");
    }

    @Override
    public boolean onBackButtonPressed() {
        this.onBackPressed();
        return true;
    }

    public void onBackPressed() {
        Logger.i(TAG, "onBackPressed");
        if (!BackButtonHandler.getInstance().handleBackButton(this)) {
            super.onBackPressed();
        }
    }

    @Override
    public void onCloseRequested() {
        this.finish();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            Logger.i(TAG, "onCreate");
            this.hideActivityTitle();
            this.hideActivtiyStatusBar();
            this.mWebViewController = IronSourceAdsPublisherAgent.getInstance((Activity)this).getWebViewController();
            this.mWebViewController.setId(1);
            this.mWebViewController.setOnWebViewControllerChangeListener(this);
            this.mWebViewController.setVideoEventsListener(this);
            Intent intent = this.getIntent();
            this.mProductType = intent.getStringExtra("productType");
            this.mIsImmersive = intent.getBooleanExtra("immersive", false);
            if (this.mIsImmersive) {
                this.getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener(this){
                    final /* synthetic */ ControllerActivity this$0;
                    {
                        this.this$0 = controllerActivity;
                    }

                    public void onSystemUiVisibilityChange(int n2) {
                        if ((n2 & 4098) == 0) {
                            ControllerActivity.access$200(this.this$0).removeCallbacks(ControllerActivity.access$100(this.this$0));
                            ControllerActivity.access$200(this.this$0).postDelayed(ControllerActivity.access$100(this.this$0), 500L);
                        }
                    }
                });
                this.runOnUiThread(this.decorViewSettings);
            }
            if (!TextUtils.isEmpty((CharSequence)this.mProductType) && SSAEnums.ProductType.OfferWall.toString().equalsIgnoreCase(this.mProductType)) {
                if (bundle != null) {
                    AdUnitsState adUnitsState = (AdUnitsState)bundle.getParcelable("state");
                    if (adUnitsState != null) {
                        this.mState = adUnitsState;
                        this.mWebViewController.restoreState(adUnitsState);
                    }
                    this.finish();
                } else {
                    this.mState = this.mWebViewController.getSavedState();
                }
            }
            this.mContainer = new RelativeLayout((Context)this);
            this.setContentView((View)this.mContainer, (ViewGroup.LayoutParams)this.MATCH_PARENT_LAYOUT_PARAMS);
            this.mWebViewFrameContainer = this.mWebViewController.getLayout();
            if (this.mContainer.findViewById(1) == null && this.mWebViewFrameContainer.getParent() != null) {
                this.calledFromOnCreate = true;
                this.finish();
            }
            this.initOrientationState();
            return;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            this.finish();
            return;
        }
    }

    protected void onDestroy() {
        IronSourceWebView ironSourceWebView;
        super.onDestroy();
        Logger.i(TAG, "onDestroy");
        if (this.calledFromOnCreate) {
            this.removeWebViewContainerView();
        }
        if ((ironSourceWebView = this.mWebViewController) != null) {
            ironSourceWebView.setState(IronSourceWebView.State.Gone);
            this.mWebViewController.removeVideoEventsListener();
            this.mWebViewController.notifyLifeCycle(this.mProductType, "onDestroy");
        }
    }

    public boolean onKeyDown(int n2, KeyEvent keyEvent) {
        if (n2 == 4 && this.mWebViewController.inCustomView()) {
            this.mWebViewController.hideCustomView();
            return true;
        }
        if (this.mIsImmersive && (n2 == 25 || n2 == 24)) {
            this.mUiThreadHandler.removeCallbacks(this.decorViewSettings);
            this.mUiThreadHandler.postDelayed(this.decorViewSettings, 500L);
        }
        return super.onKeyDown(n2, keyEvent);
    }

    @Override
    public void onOrientationChanged(String string, int n2) {
        this.handleOrientationState(string, n2);
    }

    protected void onPause() {
        super.onPause();
        Logger.i(TAG, "onPause");
        ((AudioManager)this.getSystemService("audio")).abandonAudioFocus(null);
        IronSourceWebView ironSourceWebView = this.mWebViewController;
        if (ironSourceWebView != null) {
            ironSourceWebView.unregisterConnectionReceiver((Context)this);
            this.mWebViewController.pause();
            this.mWebViewController.viewableChange(false, "main");
        }
        this.removeWebViewContainerView();
    }

    protected void onResume() {
        super.onResume();
        Logger.i(TAG, "onResume");
        this.mContainer.addView((View)this.mWebViewFrameContainer, (ViewGroup.LayoutParams)this.MATCH_PARENT_LAYOUT_PARAMS);
        IronSourceWebView ironSourceWebView = this.mWebViewController;
        if (ironSourceWebView != null) {
            ironSourceWebView.registerConnectionReceiver((Context)this);
            this.mWebViewController.resume();
            this.mWebViewController.viewableChange(true, "main");
        }
        ((AudioManager)this.getSystemService("audio")).requestAudioFocus(null, 3, 2);
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (!TextUtils.isEmpty((CharSequence)this.mProductType) && SSAEnums.ProductType.OfferWall.toString().equalsIgnoreCase(this.mProductType)) {
            this.mState.setShouldRestore(true);
            bundle.putParcelable("state", (Parcelable)this.mState);
        }
    }

    protected void onUserLeaveHint() {
        super.onUserLeaveHint();
        Logger.i(TAG, "onUserLeaveHint");
    }

    @Override
    public void onVideoEnded() {
        this.toggleKeepScreen(false);
    }

    @Override
    public void onVideoPaused() {
        this.toggleKeepScreen(false);
    }

    @Override
    public void onVideoResumed() {
        this.toggleKeepScreen(true);
    }

    @Override
    public void onVideoStarted() {
        this.toggleKeepScreen(true);
    }

    @Override
    public void onVideoStopped() {
        this.toggleKeepScreen(false);
    }

    public void onWindowFocusChanged(boolean bl) {
        super.onWindowFocusChanged(bl);
        if (this.mIsImmersive && bl) {
            this.runOnUiThread(this.decorViewSettings);
        }
    }

    public void setRequestedOrientation(int n2) {
        if (this.currentRequestedRotation != n2) {
            String string = TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Rotation: Req = ");
            stringBuilder.append(n2);
            stringBuilder.append(" Curr = ");
            stringBuilder.append(this.currentRequestedRotation);
            Logger.i(string, stringBuilder.toString());
            this.currentRequestedRotation = n2;
            super.setRequestedOrientation(n2);
        }
    }

    public void toggleKeepScreen(boolean bl) {
        if (bl) {
            this.keepScreenOn();
            return;
        }
        this.cancelScreenOn();
    }
}

