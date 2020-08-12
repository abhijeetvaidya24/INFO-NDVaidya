/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.drawable.BitmapDrawable
 *  android.graphics.drawable.Drawable
 *  android.util.DisplayMetrics
 *  android.view.Display
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.View$OnTouchListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewParent
 *  android.view.WindowManager
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 *  android.widget.ImageView
 *  android.widget.ImageView$ScaleType
 *  android.widget.RelativeLayout
 *  android.widget.RelativeLayout$LayoutParams
 *  com.amazon.device.ads.ImageButtonFactory
 *  com.amazon.device.ads.NativeCloseButton$1
 *  java.lang.NoSuchFieldError
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.Void
 */
package com.amazon.device.ads;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.amazon.device.ads.AdCloser;
import com.amazon.device.ads.Assets;
import com.amazon.device.ads.ImageButtonFactory;
import com.amazon.device.ads.ImageViewFactory;
import com.amazon.device.ads.LayoutFactory;
import com.amazon.device.ads.NativeCloseButton;
import com.amazon.device.ads.RelativePosition;
import com.amazon.device.ads.ThreadUtils;

class NativeCloseButton {
    private static final int CLOSE_BUTTON_SIZE_DP = 60;
    private static final int CLOSE_BUTTON_TAP_TARGET_SIZE_DP = 80;
    private static final String CONTENT_DESCRIPTION_NATIVE_CLOSE_BUTTON = "nativeCloseButton";
    private static final String CONTENT_DESCRIPTION_NATIVE_CLOSE_BUTTON_CONTAINER = "nativeCloseButtonContainer";
    private static final String CONTENT_DESCRIPTION_NATIVE_CLOSE_BUTTON_IMAGE = "nativeCloseButtonImage";
    private final AdCloser adCloser;
    private ViewGroup closeButton;
    private ViewGroup closeButtonContainer;
    private ImageView closeButtonImage;
    private boolean hasNativeCloseButton = false;
    private final ImageViewFactory imageViewFactory;
    private final LayoutFactory layoutFactory;
    private final ThreadUtils.ThreadRunner threadRunner;
    private final ViewGroup viewGroup;

    public NativeCloseButton(ViewGroup viewGroup, AdCloser adCloser) {
        this(viewGroup, adCloser, ThreadUtils.getThreadRunner(), new LayoutFactory(), (ImageViewFactory)new ImageButtonFactory());
    }

    NativeCloseButton(ViewGroup viewGroup, AdCloser adCloser, ThreadUtils.ThreadRunner threadRunner, LayoutFactory layoutFactory, ImageViewFactory imageViewFactory) {
        this.viewGroup = viewGroup;
        this.adCloser = adCloser;
        this.threadRunner = threadRunner;
        this.layoutFactory = layoutFactory;
        this.imageViewFactory = imageViewFactory;
    }

    static /* synthetic */ void access$000(NativeCloseButton nativeCloseButton, int n) {
        nativeCloseButton.createButtonIfNeeded(n);
    }

    static /* synthetic */ void access$100(NativeCloseButton nativeCloseButton, boolean bl, RelativePosition relativePosition, int n, int n2) {
        nativeCloseButton.addCloseButtonToTapTargetIfNeeded(bl, relativePosition, n, n2);
    }

    @SuppressLint(value={"InlinedApi"})
    private void addCloseButtonToTapTargetIfNeeded(boolean bl, RelativePosition relativePosition, int n, int n2) {
        if (bl && !this.closeButton.equals((Object)this.closeButtonImage.getParent())) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(n, n);
            layoutParams.addRule(13);
            this.closeButton.addView((View)this.closeButtonImage, (ViewGroup.LayoutParams)layoutParams);
        } else if (!bl && this.closeButton.equals((Object)this.closeButtonImage.getParent())) {
            this.closeButton.removeView((View)this.closeButtonImage);
        }
        if (!this.viewGroup.equals((Object)this.closeButtonContainer.getParent())) {
            this.viewGroup.addView((View)this.closeButtonContainer, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(n2, n2);
        if (relativePosition == null) {
            relativePosition = RelativePosition.TOP_RIGHT;
        }
        switch (6.$SwitchMap$com$amazon$device$ads$RelativePosition[relativePosition.ordinal()]) {
            default: {
                layoutParams.addRule(10);
                layoutParams.addRule(11);
                break;
            }
            case 7: {
                layoutParams.addRule(10);
                layoutParams.addRule(11);
                break;
            }
            case 6: {
                layoutParams.addRule(10);
                layoutParams.addRule(9);
                break;
            }
            case 5: {
                layoutParams.addRule(10);
                layoutParams.addRule(14);
                break;
            }
            case 4: {
                layoutParams.addRule(13);
                break;
            }
            case 3: {
                layoutParams.addRule(12);
                layoutParams.addRule(11);
                break;
            }
            case 2: {
                layoutParams.addRule(12);
                layoutParams.addRule(9);
                break;
            }
            case 1: {
                layoutParams.addRule(12);
                layoutParams.addRule(14);
            }
        }
        this.closeButton.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
        this.closeButtonContainer.bringToFront();
    }

    private void animateCloseButton(MotionEvent motionEvent, BitmapDrawable bitmapDrawable, BitmapDrawable bitmapDrawable2) {
        int n = motionEvent.getAction();
        if (n != 0) {
            if (n != 1) {
                return;
            }
            this.closeButtonImage.setImageDrawable((Drawable)bitmapDrawable);
            return;
        }
        this.closeButtonImage.setImageDrawable((Drawable)bitmapDrawable2);
    }

    private void closeAd() {
        this.adCloser.closeAd();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void createButtonIfNeeded(int n) {
        boolean bl;
        NativeCloseButton nativeCloseButton = this;
        synchronized (nativeCloseButton) {
            if (this.closeButton != null) return;
            this.closeButton = this.layoutFactory.createLayout(this.getContext(), LayoutFactory.LayoutType.RELATIVE_LAYOUT, CONTENT_DESCRIPTION_NATIVE_CLOSE_BUTTON);
            this.closeButtonImage = this.imageViewFactory.createImageView(this.getContext(), CONTENT_DESCRIPTION_NATIVE_CLOSE_BUTTON_IMAGE);
            bl = true;
        }
        if (!bl) return;
        final BitmapDrawable bitmapDrawable = this.imageViewFactory.createBitmapDrawable(this.getContext().getResources(), Assets.getInstance().getFilePath("amazon_ads_close_normal.png"));
        final BitmapDrawable bitmapDrawable2 = this.imageViewFactory.createBitmapDrawable(this.getContext().getResources(), Assets.getInstance().getFilePath("amazon_ads_close_pressed.png"));
        this.closeButtonImage.setImageDrawable((Drawable)bitmapDrawable);
        this.closeButtonImage.setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.closeButtonImage.setBackgroundDrawable(null);
        View.OnClickListener onClickListener = new View.OnClickListener(){

            public void onClick(View view) {
                NativeCloseButton.this.closeAd();
            }
        };
        this.closeButtonImage.setOnClickListener(onClickListener);
        this.closeButton.setOnClickListener(onClickListener);
        View.OnTouchListener onTouchListener = new View.OnTouchListener(){

            @SuppressLint(value={"ClickableViewAccessibility"})
            public boolean onTouch(View view, MotionEvent motionEvent) {
                NativeCloseButton.this.animateCloseButton(motionEvent, bitmapDrawable, bitmapDrawable2);
                return false;
            }
        };
        this.closeButton.setOnTouchListener(onTouchListener);
        this.closeButtonImage.setOnTouchListener(onTouchListener);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(n, n);
        layoutParams.addRule(11);
        layoutParams.addRule(10);
        this.closeButtonContainer = this.layoutFactory.createLayout(this.getContext(), LayoutFactory.LayoutType.RELATIVE_LAYOUT, CONTENT_DESCRIPTION_NATIVE_CLOSE_BUTTON_CONTAINER);
        this.closeButtonContainer.addView((View)this.closeButton, (ViewGroup.LayoutParams)layoutParams);
    }

    private Context getContext() {
        return this.viewGroup.getContext();
    }

    private void hideImage() {
        this.threadRunner.execute(new Runnable(){

            public void run() {
                NativeCloseButton.this.hideImageOnMainThread();
            }
        }, ThreadUtils.ExecutionStyle.RUN_ASAP, ThreadUtils.ExecutionThread.MAIN_THREAD);
    }

    private void hideImageOnMainThread() {
        this.closeButton.removeAllViews();
    }

    private void removeNativeCloseButtonOnMainThread() {
        this.viewGroup.removeView((View)this.closeButtonContainer);
    }

    public void enable(boolean bl, RelativePosition relativePosition) {
        this.hasNativeCloseButton = true;
        ViewGroup viewGroup = this.closeButton;
        if (viewGroup != null && this.closeButtonImage != null && this.viewGroup.equals((Object)viewGroup.getParent()) && (this.closeButton.equals((Object)this.closeButtonImage.getParent()) || !bl)) {
            if (!bl) {
                this.hideImage();
            }
            return;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager)this.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        int n = (int)(0.5f + 60.0f * displayMetrics.density);
        int n2 = (int)(0.5f + 80.0f * displayMetrics.density);
        1 var7_7 = new 1(this, n2, bl, relativePosition, n);
        this.threadRunner.executeAsyncTask(var7_7, (T[])new Void[0]);
    }

    public void remove() {
        this.hasNativeCloseButton = false;
        this.threadRunner.execute(new Runnable(){

            public void run() {
                NativeCloseButton.this.removeNativeCloseButtonOnMainThread();
            }
        }, ThreadUtils.ExecutionStyle.RUN_ASAP, ThreadUtils.ExecutionThread.MAIN_THREAD);
    }

    public void showImage(boolean bl) {
        if (this.hasNativeCloseButton && this.closeButton != null) {
            if (bl) {
                this.enable(true, null);
                return;
            }
            this.hideImage();
        }
    }

}

