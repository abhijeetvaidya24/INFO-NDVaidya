/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Color
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Parcelable
 *  android.util.AttributeSet
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.RelativeLayout
 *  android.widget.RelativeLayout$LayoutParams
 *  android.widget.TextView
 *  java.io.Serializable
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Random
 *  java.util.Timer
 *  java.util.TimerTask
 */
package com.startapp.android.publish.ads.banner;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.startapp.android.publish.ads.banner.BannerBase;
import com.startapp.android.publish.ads.banner.BannerOptions;
import com.startapp.android.publish.ads.banner.b;
import com.startapp.android.publish.ads.banner.c;
import com.startapp.android.publish.adsCommon.Utils.h;
import com.startapp.android.publish.adsCommon.a.e;
import com.startapp.android.publish.adsCommon.a.f;
import com.startapp.android.publish.adsCommon.i;
import com.startapp.android.publish.adsCommon.o;
import com.startapp.android.publish.common.model.AdPreferences;
import com.startapp.common.Constants;
import com.startapp.common.a.g;
import java.io.Serializable;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public abstract class BannerBase
extends RelativeLayout {
    private static final String TAG = "BannerLayout";
    protected AdPreferences adPreferences;
    protected f adRulesResult;
    protected String adTag = null;
    private boolean attachedToWindow = false;
    private boolean clicked = false;
    protected boolean drawn = false;
    private String error;
    private boolean firstLoad = true;
    protected int innerBanner3dId = 159868227 + new Random().nextInt(100000);
    protected int innerBannerStandardId = 1 + this.innerBanner3dId;
    protected int offset = 0;
    private boolean shouldReloadBanner = false;
    private a task = new TimerTask(){

        public void run() {
            BannerBase.this.post(new Runnable(){

                public void run() {
                    if (BannerBase.this.isShown() || BannerBase.this.adRulesResult != null && !BannerBase.this.adRulesResult.a()) {
                        g.a(BannerBase.TAG, 3, "REFRESH");
                        BannerBase.this.load();
                    }
                }
            });
        }

    };
    private Timer timer = new Timer();
    private o viewabilityChecker = new o();
    private Handler visibilityHandler = new Handler();

    public BannerBase(Context context) {
        super(context);
    }

    public BannerBase(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BannerBase(Context context, AttributeSet attributeSet, int n2) {
        super(context, attributeSet, n2);
        this.setBannerAttrs(context, attributeSet);
    }

    static /* synthetic */ Handler access$000(BannerBase bannerBase) {
        return bannerBase.visibilityHandler;
    }

    static /* synthetic */ void access$100(BannerBase bannerBase) {
        bannerBase.clearVisibilityHandler();
    }

    private void cancelReloadTask() {
        if (!this.isInEditMode()) {
            Timer timer;
            a a2 = this.task;
            if (a2 != null) {
                a2.cancel();
            }
            if ((timer = this.timer) != null) {
                timer.cancel();
            }
            this.task = null;
            this.timer = null;
        }
    }

    private void clearVisibilityHandler() {
        try {
            this.visibilityHandler.removeCallbacksAndMessages(null);
            return;
        }
        catch (Exception exception) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("BannerBase.reload - removeCallbacksAndMessages failed ");
            stringBuilder.append(exception.getMessage());
            g.a(TAG, 6, stringBuilder.toString());
            return;
        }
    }

    private void initDebug() {
        this.setMinimumWidth(h.a(this.getContext(), this.getWidthInDp()));
        this.setMinimumHeight(h.a(this.getContext(), this.getHeightInDp()));
        this.setBackgroundColor(Color.rgb((int)169, (int)169, (int)169));
        TextView textView = new TextView(this.getContext());
        textView.setText((CharSequence)this.getBannerName());
        textView.setTextColor(-16777216);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        this.addView((View)textView, (ViewGroup.LayoutParams)layoutParams);
    }

    private void scheduleReloadTask() {
        if (this.attachedToWindow) {
            Timer timer;
            if (this.isInEditMode()) {
                return;
            }
            a a2 = this.task;
            if (a2 != null) {
                a2.cancel();
            }
            if ((timer = this.timer) != null) {
                timer.cancel();
            }
            this.task = new /* invalid duplicate definition of identical inner class */;
            this.timer = new Timer();
            this.timer.scheduleAtFixedRate((TimerTask)this.task, (long)this.getRefreshRate(), (long)this.getRefreshRate());
        }
    }

    private void setBannerAttrs(Context context, AttributeSet attributeSet) {
        this.setAdTag(new b(context, attributeSet).a());
    }

    protected void addDisplayEventOnLoad() {
        if (this.isFirstLoad() || com.startapp.android.publish.adsCommon.a.g.a().b().a()) {
            this.setFirstLoad(false);
            com.startapp.android.publish.adsCommon.a.b.a().a(new com.startapp.android.publish.adsCommon.a.a(AdPreferences.Placement.INAPP_BANNER, this.getAdTag()));
        }
    }

    protected String getAdTag() {
        return this.adTag;
    }

    protected abstract int getBannerId();

    protected abstract String getBannerName();

    public String getErrorMessage() {
        return this.error;
    }

    protected abstract int getHeightInDp();

    protected int getMinViewabilityPercentage() {
        return c.a().b().q();
    }

    protected abstract int getOffset();

    protected abstract int getRefreshRate();

    protected abstract int getWidthInDp();

    protected void init() {
        if (!this.isInEditMode()) {
            this.initRuntime();
            return;
        }
        this.initDebug();
    }

    protected abstract void initRuntime();

    public boolean isClicked() {
        return this.clicked;
    }

    public boolean isFirstLoad() {
        return this.firstLoad;
    }

    protected boolean isVisible() {
        return this.viewabilityChecker.a((View)this, this.getMinViewabilityPercentage());
    }

    protected void load() {
        this.clearVisibilityHandler();
        if (this.adRulesResult != null && !com.startapp.android.publish.adsCommon.a.g.a().b().a()) {
            if (this.adRulesResult.a()) {
                this.reload();
                return;
            }
        } else {
            this.adRulesResult = com.startapp.android.publish.adsCommon.a.g.a().b().a(AdPreferences.Placement.INAPP_BANNER, this.getAdTag());
            if (this.adRulesResult.a()) {
                this.reload();
                return;
            }
            this.setVisibility(4);
            if (Constants.a().booleanValue()) {
                com.startapp.common.a.i.a().a(this.getContext(), this.adRulesResult.b());
            }
        }
    }

    protected void loadBanner() {
        this.scheduleReloadTask();
        this.load();
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        g.a("BannerLayout", 3, "onAttachedToWindow");
        this.attachedToWindow = true;
        this.scheduleReloadTask();
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        g.a("BannerLayout", 3, "onDetachedFromWindow");
        this.attachedToWindow = false;
        this.cancelReloadTask();
        this.clearVisibilityHandler();
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof Bundle)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        Bundle bundle = (Bundle)parcelable;
        this.setBannerId(bundle.getInt("bannerId"));
        this.adRulesResult = (f)bundle.getSerializable("adRulesResult");
        this.adPreferences = (AdPreferences)bundle.getSerializable("adPreferences");
        this.offset = bundle.getInt("offset");
        this.firstLoad = bundle.getBoolean("firstLoad");
        this.shouldReloadBanner = bundle.getBoolean("shouldReloadBanner");
        super.onRestoreInstanceState(bundle.getParcelable("upperState"));
    }

    protected Parcelable onSaveInstanceState() {
        if (this.isClicked()) {
            this.setClicked(false);
            this.shouldReloadBanner = true;
        }
        Parcelable parcelable = super.onSaveInstanceState();
        Bundle bundle = new Bundle();
        bundle.putInt("bannerId", this.getBannerId());
        bundle.putParcelable("upperState", parcelable);
        bundle.putSerializable("adRulesResult", (Serializable)this.adRulesResult);
        bundle.putSerializable("adPreferences", (Serializable)this.adPreferences);
        bundle.putInt("offset", this.offset);
        bundle.putBoolean("firstLoad", this.firstLoad);
        bundle.putBoolean("shouldReloadBanner", this.shouldReloadBanner);
        return bundle;
    }

    public void onWindowFocusChanged(boolean bl) {
        super.onWindowFocusChanged(bl);
        g.a("BannerLayout", 3, "onWindowFocusChanged");
        if (bl) {
            if (this.shouldReloadBanner) {
                this.shouldReloadBanner = false;
                this.load();
            }
            this.attachedToWindow = true;
            this.scheduleReloadTask();
            return;
        }
        this.attachedToWindow = false;
        this.cancelReloadTask();
    }

    protected abstract void reload();

    public abstract void setAdTag(String var1);

    protected abstract void setBannerId(int var1);

    public void setClicked(boolean bl) {
        this.clicked = bl;
    }

    public void setErrorMessage(String string) {
        this.error = string;
    }

    public void setFirstLoad(boolean bl) {
        this.firstLoad = bl;
    }

    protected void setHardwareAcceleration(AdPreferences adPreferences) {
        com.startapp.android.publish.adsCommon.Utils.i.a(adPreferences, "hardwareAccelerated", com.startapp.common.a.c.a((View)this, this.attachedToWindow));
    }

    protected boolean shouldSendImpression(i i2) {
        return i2 != null && !i2.c();
    }

    protected void startVisibilityRunnable(i i2) {
        if (!this.shouldSendImpression(i2)) {
            return;
        }
        g.a("BannerLayout", 3, "BannerBase.startVisibilityRunnable - run visibility check");
        new Runnable(this, i2){
            final /* synthetic */ i a;
            final /* synthetic */ BannerBase b;
            private boolean c;
            {
                this.b = bannerBase;
                this.a = i2;
                this.c = true;
            }

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            public void run() {
                try {
                    if (!this.b.shouldSendImpression(this.a)) {
                        BannerBase.access$100(this.b);
                        return;
                    }
                    boolean bl = this.b.isVisible();
                    if (bl && this.c) {
                        this.c = false;
                        this.a.a();
                    } else if (!bl && !this.c) {
                        this.c = true;
                        this.a.b();
                    }
                    BannerBase.access$000(this.b).postDelayed((Runnable)this, 100L);
                    return;
                }
                catch (Exception exception) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("BannerBase.startVisibilityRunnable.run - runnable error ");
                    stringBuilder.append(exception.getMessage());
                    g.a("BannerLayout", 6, stringBuilder.toString());
                    BannerBase.access$100(this.b);
                    return;
                }
            }
        }.run();
    }

}

