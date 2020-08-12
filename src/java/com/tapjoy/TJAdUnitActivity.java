/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.AlertDialog
 *  android.app.AlertDialog$Builder
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  android.content.Intent
 *  android.graphics.drawable.ColorDrawable
 *  android.graphics.drawable.Drawable
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Looper
 *  android.util.AttributeSet
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewParent
 *  android.view.Window
 *  android.widget.ProgressBar
 *  android.widget.RelativeLayout
 *  android.widget.RelativeLayout$LayoutParams
 *  android.widget.VideoView
 *  com.tapjoy.TapjoyErrorMessage
 *  com.tapjoy.TapjoyErrorMessage$ErrorType
 *  com.tapjoy.TapjoyLog
 *  com.tapjoy.internal.ep
 *  com.tapjoy.internal.et
 *  com.tapjoy.internal.ez
 *  com.tapjoy.internal.fq
 *  com.tapjoy.internal.gc
 *  com.tapjoy.mraid.view.BasicWebView
 *  com.tapjoy.mraid.view.MraidView
 *  java.io.Serializable
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Map
 */
package com.tapjoy;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.VideoView;
import com.tapjoy.TJAdUnit;
import com.tapjoy.TJAdUnitSaveStateData;
import com.tapjoy.TJCloseButton;
import com.tapjoy.TJCorePlacement;
import com.tapjoy.TJPlacement;
import com.tapjoy.TJPlacementData;
import com.tapjoy.TJPlacementListener;
import com.tapjoy.TJPlacementManager;
import com.tapjoy.TapjoyConnectCore;
import com.tapjoy.TapjoyErrorMessage;
import com.tapjoy.TapjoyLog;
import com.tapjoy.internal.ep;
import com.tapjoy.internal.et;
import com.tapjoy.internal.ez;
import com.tapjoy.internal.fq;
import com.tapjoy.internal.gc;
import com.tapjoy.mraid.view.BasicWebView;
import com.tapjoy.mraid.view.MraidView;
import java.io.Serializable;
import java.util.Map;

public class TJAdUnitActivity
extends Activity
implements View.OnClickListener {
    private static TJAdUnitActivity b;
    private final Handler a = new Handler(Looper.getMainLooper());
    private TJAdUnit c;
    private TJPlacementData d;
    private TJAdUnitSaveStateData e = new TJAdUnitSaveStateData();
    private RelativeLayout f = null;
    private TJCloseButton g;
    private ProgressBar h;
    private boolean i = false;

    static void a() {
        TJAdUnitActivity tJAdUnitActivity = b;
        if (tJAdUnitActivity != null) {
            tJAdUnitActivity.handleClose(true);
        }
    }

    public void handleClose() {
        this.handleClose(false);
    }

    public void handleClose(boolean bl) {
        if (!this.c.getCloseRequested()) {
            TapjoyLog.d((String)"TJAdUnitActivity", (String)"closeRequested");
            this.c.closeRequested(bl);
            this.a.postDelayed(new Runnable(){

                public final void run() {
                    if (TJAdUnitActivity.this.c.getCloseRequested()) {
                        TapjoyLog.d((String)"TJAdUnitActivity", (String)"Did not receive callback from content. Closing ad.");
                        TJAdUnitActivity.this.finish();
                    }
                }
            }, 1000L);
        }
    }

    protected void onActivityResult(int n2, int n3, Intent intent) {
        if (n2 == 327 && intent != null && intent.hasExtra("placement_data") && this.c != null) {
            TJPlacementData tJPlacementData = (TJPlacementData)intent.getSerializableExtra("placement_data");
            TJAdUnit tJAdUnit = this.c;
            String string = tJPlacementData.getCallbackID();
            Object[] arrobject = new Object[]{Boolean.TRUE};
            tJAdUnit.invokeBridgeCallback(string, arrobject);
        }
    }

    public void onBackPressed() {
        this.handleClose();
    }

    public void onClick(View view) {
        this.handleClose();
    }

    protected void onCreate(Bundle bundle) {
        TJAdUnitSaveStateData tJAdUnitSaveStateData;
        StringBuilder stringBuilder = new StringBuilder("TJAdUnitActivity onCreate: ");
        stringBuilder.append((Object)bundle);
        TapjoyLog.d((String)"TJAdUnitActivity", (String)stringBuilder.toString());
        super.onCreate(bundle);
        b = this;
        if (bundle != null && (tJAdUnitSaveStateData = (this.e = (TJAdUnitSaveStateData)bundle.getSerializable("ad_unit_bundle"))) != null && tJAdUnitSaveStateData.isVideoComplete) {
            TapjoyLog.d((String)"TJAdUnitActivity", (String)"finishing TJAdUnitActivity");
            this.finish();
            return;
        }
        Bundle bundle2 = this.getIntent().getExtras();
        if (bundle2 != null && bundle2.getSerializable("placement_data") != null) {
            this.d = (TJPlacementData)bundle2.getSerializable("placement_data");
            if (this.d.getContentViewId() != null) {
                TapjoyConnectCore.viewWillOpen(this.d.getContentViewId(), 1);
            }
            if (TJPlacementManager.a(this.d.getKey()) != null) {
                this.c = TJPlacementManager.a(this.d.getKey()).getAdUnit();
            } else {
                this.c = new TJAdUnit();
                ep ep2 = new ep(this.d.getPlacementName(), this.d.getPlacementType());
                this.c.setAdContentTracker(ep2);
            }
            if (!this.c.hasCalledLoad()) {
                TapjoyLog.d((String)"TJAdUnitActivity", (String)"No content loaded for ad unit -- loading now");
                this.c.load(this.d, false, (Context)this);
            }
            this.c.setAdUnitActivity(this);
            if (Build.VERSION.SDK_INT < 11) {
                this.setTheme(16973829);
            } else {
                this.requestWindowFeature(1);
                this.getWindow().setFlags(1024, 1024);
                this.getWindow().setFlags(16777216, 16777216);
            }
            this.getWindow().setBackgroundDrawable((Drawable)new ColorDrawable(0));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            this.f = new RelativeLayout((Context)this);
            this.f.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
            this.f.setBackgroundColor(0);
            BasicWebView basicWebView = this.c.getBackgroundWebView();
            basicWebView.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
            if (basicWebView.getParent() != null) {
                ((ViewGroup)basicWebView.getParent()).removeView((View)basicWebView);
            }
            MraidView mraidView = this.c.getWebView();
            mraidView.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
            if (mraidView.getParent() != null) {
                ((ViewGroup)mraidView.getParent()).removeView((View)mraidView);
            }
            VideoView videoView = this.c.getVideoView();
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams2.addRule(13);
            videoView.setLayoutParams((ViewGroup.LayoutParams)layoutParams2);
            if (videoView.getParent() != null) {
                ((ViewGroup)videoView.getParent()).removeView((View)videoView);
            }
            this.f.addView((View)basicWebView);
            this.f.addView((View)videoView);
            this.f.addView((View)mraidView);
            this.h = new ProgressBar((Context)this, null, 16842874);
            if (this.d.hasProgressSpinner()) {
                this.setProgressSpinnerVisibility(true);
            } else {
                this.setProgressSpinnerVisibility(false);
            }
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams3.addRule(13);
            this.h.setLayoutParams((ViewGroup.LayoutParams)layoutParams3);
            this.f.addView((View)this.h);
            if (!this.c.getWebView().isMraid()) {
                this.g = new TJCloseButton((Context)this);
                this.g.setOnClickListener((View.OnClickListener)this);
                this.f.addView((View)this.g);
            }
            this.setContentView((View)this.f);
            this.c.setVisible(true);
            TJCorePlacement tJCorePlacement = TJPlacementManager.a(this.d.getKey());
            if (tJCorePlacement != null) {
                String string = TJCorePlacement.a;
                StringBuilder stringBuilder2 = new StringBuilder("Content shown for placement ");
                stringBuilder2.append(tJCorePlacement.c.getPlacementName());
                TapjoyLog.i((String)string, (String)stringBuilder2.toString());
                tJCorePlacement.f.a();
                TJPlacement tJPlacement = tJCorePlacement.a("SHOW");
                if (tJPlacement != null && tJPlacement.getListener() != null) {
                    tJPlacement.getListener().onContentShow(tJPlacement);
                }
            }
            return;
        }
        TapjoyLog.e((String)"TJAdUnitActivity", (TapjoyErrorMessage)new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.SDK_ERROR, "Failed to launch AdUnit Activity"));
        this.finish();
    }

    protected void onDestroy() {
        TJPlacementData tJPlacementData;
        super.onDestroy();
        b = null;
        TapjoyLog.d((String)"TJAdUnitActivity", (String)"onDestroy");
        TJAdUnit tJAdUnit = this.c;
        if (tJAdUnit != null) {
            tJAdUnit.destroy();
        }
        if ((tJPlacementData = this.d) != null && tJPlacementData.isBaseActivity()) {
            TJPlacement tJPlacement;
            TJCorePlacement tJCorePlacement;
            if (this.d.getContentViewId() != null) {
                TapjoyConnectCore.viewDidClose(this.d.getContentViewId());
            }
            if ((tJCorePlacement = TJPlacementManager.a(this.d.getKey())) != null && (tJPlacement = tJCorePlacement.a("SHOW")) != null && tJPlacement.getListener() != null) {
                String string = TJCorePlacement.a;
                StringBuilder stringBuilder = new StringBuilder("Content dismissed for placement ");
                stringBuilder.append(tJCorePlacement.c.getPlacementName());
                TapjoyLog.i((String)string, (String)stringBuilder.toString());
                et et2 = tJCorePlacement.f.a;
                if (et2 != null) {
                    et2.b.clear();
                }
                if (tJPlacement != null && tJPlacement.a != null) {
                    tJPlacement.a.onContentDismiss(tJPlacement);
                }
            }
        }
    }

    protected void onPause() {
        super.onPause();
        TapjoyLog.d((String)"TJAdUnitActivity", (String)"onPause");
        this.c.pause();
    }

    protected void onResume() {
        TapjoyLog.d((String)"TJAdUnitActivity", (String)"onResume");
        super.onResume();
        if (this.c.isLockedOrientation()) {
            this.setRequestedOrientation(this.c.getOrientation());
        }
        this.c.resume(this.e);
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        TapjoyLog.d((String)"TJAdUnitActivity", (String)"onSaveInstanceState");
        this.e.seekTime = this.c.getVideoSeekTime();
        this.e.isVideoComplete = this.c.isVideoComplete();
        this.e.isVideoMuted = this.c.isMuted();
        bundle.putSerializable("ad_unit_bundle", (Serializable)this.e);
    }

    protected void onStart() {
        super.onStart();
        TapjoyLog.d((String)"TJAdUnitActivity", (String)"onStart");
        if (gc.a().n) {
            this.i = true;
            fq.a((Activity)this);
        }
        if (!this.d.isBaseActivity()) {
            this.setResult(-1, this.getIntent());
        }
    }

    protected void onStop() {
        if (this.i) {
            this.i = false;
            fq.b((Activity)this);
        }
        super.onStop();
        TapjoyLog.d((String)"TJAdUnitActivity", (String)"onStop");
    }

    public void setCloseButtonClickable(boolean bl) {
        this.g.setClickableRequested(bl);
    }

    public void setCloseButtonVisibility(boolean bl) {
        if (bl) {
            this.g.setVisibility(0);
            return;
        }
        this.g.setVisibility(4);
    }

    public void setProgressSpinnerVisibility(boolean bl) {
        if (bl) {
            this.h.setVisibility(0);
            return;
        }
        this.h.setVisibility(4);
    }

    public void showErrorDialog() {
        if (!this.isFinishing()) {
            new AlertDialog.Builder((Context)this).setMessage((CharSequence)"An error occured. Please try again later.").setPositiveButton((CharSequence)"OK", new DialogInterface.OnClickListener(){

                public final void onClick(DialogInterface dialogInterface, int n2) {
                    TJAdUnitActivity.this.handleClose();
                    dialogInterface.cancel();
                }
            }).create().show();
        }
    }

}

