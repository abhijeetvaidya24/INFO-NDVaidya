/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Handler
 *  android.os.Looper
 *  android.util.AttributeSet
 *  android.view.View
 *  android.widget.RelativeLayout
 *  com.aerserv.sdk.adapter.AbstractCustomBannerProvider
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.System
 *  java.lang.Thread
 *  java.util.HashSet
 *  java.util.Set
 *  java.util.Timer
 *  java.util.TimerTask
 *  java.util.UUID
 */
package com.aerserv.sdk;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.aerserv.sdk.AerServAd;
import com.aerserv.sdk.AerServAdType;
import com.aerserv.sdk.AerServBanner;
import com.aerserv.sdk.AerServConfig;
import com.aerserv.sdk.adapter.AbstractCustomBannerProvider;
import com.aerserv.sdk.controller.listener.AerServEventListenerLocator;
import com.aerserv.sdk.controller.listener.PlayPauseListener;
import com.aerserv.sdk.controller.listener.ProviderListenerLocator;
import com.aerserv.sdk.controller.listener.ShowListener;
import com.aerserv.sdk.model.Placement;
import com.aerserv.sdk.utils.AerServLog;
import com.aerserv.sdk.utils.MoatUtils;
import com.aerserv.sdk.view.View;
import com.aerserv.sdk.view.ViewLocator;
import com.aerserv.sdk.view.component.ASWebView;
import java.util.HashSet;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;

public class AerServBanner
extends RelativeLayout
implements AerServAd,
View {
    private static final String LOG_TAG = "com.aerserv.sdk.AerServBanner";
    private Set<String> asWebViewIds = new HashSet();
    private AerServConfig config;
    private String controllerId = null;
    private boolean isKilled = false;
    private boolean isPaused = false;
    private boolean isPreloading = false;
    private long lastShowAttemptTime = System.currentTimeMillis();
    private Placement placement;
    private PlayPauseListener playPauseListener;
    private ShowListener showListener;
    private Timer timer = null;
    private final String viewId = UUID.randomUUID().toString();

    public AerServBanner(Context context) {
        super(context);
    }

    public AerServBanner(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    static /* synthetic */ PlayPauseListener access$002(AerServBanner aerServBanner, PlayPauseListener playPauseListener) {
        aerServBanner.playPauseListener = playPauseListener;
        return playPauseListener;
    }

    static /* synthetic */ boolean access$1000(AerServBanner aerServBanner) {
        return aerServBanner.isKilled;
    }

    static /* synthetic */ Placement access$102(AerServBanner aerServBanner, Placement placement) {
        aerServBanner.placement = placement;
        return placement;
    }

    static /* synthetic */ boolean access$1100(AerServBanner aerServBanner) {
        return aerServBanner.isPreloading;
    }

    static /* synthetic */ void access$1200(AerServBanner aerServBanner, boolean bl) {
        aerServBanner.show(bl);
    }

    static /* synthetic */ Set access$1300(AerServBanner aerServBanner) {
        return aerServBanner.asWebViewIds;
    }

    static /* synthetic */ String access$202(AerServBanner aerServBanner, String string) {
        aerServBanner.controllerId = string;
        return string;
    }

    static /* synthetic */ ShowListener access$300(AerServBanner aerServBanner) {
        return aerServBanner.showListener;
    }

    static /* synthetic */ ShowListener access$302(AerServBanner aerServBanner, ShowListener showListener) {
        aerServBanner.showListener = showListener;
        return showListener;
    }

    static /* synthetic */ String access$400(AerServBanner aerServBanner) {
        return aerServBanner.viewId;
    }

    static /* synthetic */ String access$500() {
        return LOG_TAG;
    }

    static /* synthetic */ AerServConfig access$600(AerServBanner aerServBanner) {
        return aerServBanner.config;
    }

    static /* synthetic */ long access$700(AerServBanner aerServBanner) {
        return aerServBanner.lastShowAttemptTime;
    }

    static /* synthetic */ long access$800(AerServBanner aerServBanner) {
        return aerServBanner.getRefreshInterval();
    }

    static /* synthetic */ boolean access$900(AerServBanner aerServBanner) {
        return aerServBanner.isPaused;
    }

    private void cleanup() {
        ViewLocator.getInstance().unregisterView(this.viewId);
        MoatUtils.startTracking(this.controllerId);
        MoatUtils.cleanup(this.controllerId);
        this.showListener = null;
        this.playPauseListener = null;
        String string = this.controllerId;
        if (string != null) {
            AerServEventListenerLocator.unregister(string);
            ProviderListenerLocator.unregister(this.controllerId);
            AbstractCustomBannerProvider.killBanner((String)this.controllerId);
        }
        this.config = null;
        new Handler(Looper.getMainLooper()).post(new Runnable(this){
            final /* synthetic */ AerServBanner this$0;
            {
                this.this$0 = aerServBanner;
            }

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            public void run() {
                try {
                    java.util.Iterator iterator = AerServBanner.access$1300(this.this$0).iterator();
                    do {
                        if (!iterator.hasNext()) {
                            AerServBanner.access$1300(this.this$0).clear();
                            this.this$0.removeAllViews();
                            return;
                        }
                        String string = (String)iterator.next();
                        View view = ViewLocator.getInstance().locateView(string);
                        if (view != null && view instanceof ASWebView) {
                            ASWebView aSWebView = (ASWebView)view;
                            aSWebView.cleanup();
                            ((RelativeLayout)aSWebView.getParent()).removeView((android.view.View)aSWebView);
                            aSWebView.destroy();
                        }
                        ViewLocator.getInstance().unregisterView(string);
                    } while (true);
                }
                catch (Exception exception) {
                    AerServLog.e(AerServBanner.access$500(), "Exception caught in cleanup()", exception);
                    return;
                }
            }
        });
    }

    /*
     * Enabled aggressive block sorting
     */
    private long getRefreshInterval() {
        int n2;
        long l2;
        Placement placement = this.placement;
        if (placement != null && placement.getBannerRefresh() != null && (this.placement.getBannerRefresh() >= 10 || this.placement.getBannerRefresh() == 0)) {
            n2 = this.placement.getBannerRefresh();
        } else {
            AerServConfig aerServConfig = this.config;
            if (aerServConfig == null) {
                l2 = 0L;
                return l2 * 1000L;
            }
            n2 = aerServConfig.getRefreshInterval();
        }
        l2 = n2;
        return l2 * 1000L;
    }

    private void show(boolean bl) {
        this.isPreloading = false;
        this.lastShowAttemptTime = System.currentTimeMillis();
        if (this.config == null) {
            AerServLog.d(LOG_TAG, "You must call config() before calling show()");
            return;
        }
        new Thread(new Runnable(this, bl){
            final /* synthetic */ AerServBanner this$0;
            final /* synthetic */ boolean val$isRefresh;
            {
                this.this$0 = aerServBanner;
                this.val$isRefresh = bl;
            }

            public void run() {
                try {
                    long l2 = System.currentTimeMillis();
                    while (AerServBanner.access$300(this.this$0) == null) {
                        if (System.currentTimeMillis() - l2 > (long)com.aerserv.sdk.AerServSettings.getLoadAdTimeout(AerServBanner.access$600(this.this$0).getPlc())) {
                            AerServLog.d(AerServBanner.access$500(), "Timed out trying to show banner");
                            return;
                        }
                        Thread.sleep((long)100L);
                    }
                    if (this.val$isRefresh) {
                        AerServBanner.access$300(this.this$0).onShow(com.aerserv.sdk.RequestType.BANNER_REFRESH);
                    } else if (AerServBanner.access$600(this.this$0).isPreload()) {
                        AerServBanner.access$300(this.this$0).onShow(com.aerserv.sdk.RequestType.SHOW);
                    } else {
                        AerServBanner.access$300(this.this$0).onShow(com.aerserv.sdk.RequestType.LOAD_AND_SHOW);
                    }
                    AerServBanner.access$302(this.this$0, null);
                    return;
                }
                catch (Exception exception) {
                    AerServLog.e(AerServBanner.access$500(), "Exception caught in banner show()", exception);
                    return;
                }
            }
        }).start();
    }

    private void startRefreshTimer() {
        this.timer = new Timer();
        this.timer.schedule(new TimerTask(this){
            final /* synthetic */ AerServBanner this$0;
            {
                this.this$0 = aerServBanner;
            }

            public void run() {
                long l2 = System.currentTimeMillis() - AerServBanner.access$700(this.this$0);
                long l3 = AerServBanner.access$800(this.this$0);
                if (!(AerServBanner.access$600(this.this$0) == null || AerServBanner.access$900(this.this$0) || AerServBanner.access$1000(this.this$0) || AerServBanner.access$1100(this.this$0) || l3 <= 0L)) {
                    if (l2 < l3) {
                        return;
                    }
                    new Handler(this.this$0.getContext().getMainLooper()).post(new Runnable(this){
                        final /* synthetic */ 3 this$1;
                        {
                            this.this$1 = var1_1;
                        }

                        public void run() {
                            if (AerServBanner.access$600(this.this$1.this$0) == null) {
                                return;
                            }
                            AerServLog.d(AerServBanner.access$500(), "Refreshing banner");
                            this.this$1.this$0.configure(AerServBanner.access$600(this.this$1.this$0).setPreload(false));
                            AerServBanner.access$1200(this.this$1.this$0, true);
                        }
                    });
                }
            }
        }, 10000L, 500L);
    }

    public void addView(android.view.View view) {
        super.addView(view);
        if (view instanceof ASWebView) {
            this.asWebViewIds.add((Object)((ASWebView)view).VIEW_ID);
        }
    }

    public AerServBanner configure(AerServConfig aerServConfig) {
        this.cleanup();
        if (this.timer == null) {
            this.startRefreshTimer();
        }
        this.isKilled = false;
        this.isPaused = false;
        this.isPreloading = aerServConfig.isPreload();
        this.config = aerServConfig;
        ViewLocator.getInstance().registerView(this.viewId, this);
        new Thread(new Runnable(this, this, aerServConfig){
            final /* synthetic */ AerServBanner this$0;
            final /* synthetic */ AerServConfig val$config;
            final /* synthetic */ AerServBanner val$self;
            {
                this.this$0 = aerServBanner;
                this.val$self = aerServBanner2;
                this.val$config = aerServConfig;
            }

            public void run() {
                try {
                    com.aerserv.sdk.controller.listener.ExecutePlacementListener executePlacementListener = new com.aerserv.sdk.controller.listener.ExecutePlacementListener(this){
                        final /* synthetic */ 1 this$1;
                        {
                            this.this$1 = var1_1;
                        }

                        public void onAdManagerCreated(String string) {
                            AerServBanner.access$202(this.this$1.val$self, string);
                        }

                        public void onPlacementAvailable(Placement placement) {
                            AerServBanner.access$102(this.this$1.val$self, placement);
                        }

                        public void onPlayPauseListenerCreated(PlayPauseListener playPauseListener) {
                            AerServBanner.access$002(this.this$1.val$self, playPauseListener);
                        }

                        public void removeOnPlayPauseListener() {
                            AerServBanner.access$002(this.this$1.val$self, null);
                        }
                    };
                    com.aerserv.sdk.controller.listener.SaveShowListener saveShowListener = new com.aerserv.sdk.controller.listener.SaveShowListener(this){
                        final /* synthetic */ 1 this$1;
                        {
                            this.this$1 = var1_1;
                        }

                        public void onSaveShow(ShowListener showListener) {
                            AerServBanner.access$302(this.this$1.val$self, showListener);
                        }
                    };
                    com.aerserv.sdk.controller.command.ExecutePlacementCommand executePlacementCommand = new com.aerserv.sdk.controller.command.ExecutePlacementCommand(this.val$config, this.this$0.getAerServAdType(), executePlacementListener, saveShowListener, AerServBanner.access$400(this.this$0));
                    executePlacementCommand.execute();
                    return;
                }
                catch (Exception exception) {
                    AerServLog.e(AerServBanner.access$500(), "Exception configuring banner", exception);
                    return;
                }
            }
        }).start();
        return this;
    }

    @Override
    public AerServAdType getAerServAdType() {
        return AerServAdType.BANNER;
    }

    @Override
    public void kill() {
        this.isKilled = true;
        Timer timer = this.timer;
        if (timer != null) {
            timer.cancel();
            this.timer = null;
        }
        this.cleanup();
    }

    public void onWindowFocusChanged(boolean bl) {
        super.onWindowFocusChanged(bl);
        if (bl) {
            AerServLog.d(LOG_TAG, "Window is in focus. Resuming banner.");
            this.play();
            return;
        }
        AerServLog.d(LOG_TAG, "Window was out of focus. Pausing banner.");
        this.pause();
    }

    @Override
    public void pause() {
        try {
            this.isPaused = true;
            if (this.playPauseListener != null) {
                this.playPauseListener.onPause();
                return;
            }
        }
        catch (Exception exception) {
            AerServLog.e(LOG_TAG, "Exception caught in pause()", exception);
        }
    }

    @Override
    public void play() {
        try {
            this.isPaused = false;
            if (this.playPauseListener != null) {
                this.playPauseListener.onPlay();
                return;
            }
        }
        catch (Exception exception) {
            AerServLog.e(LOG_TAG, "Exception caught in play()", exception);
        }
    }

    @Override
    public void show() {
        this.show(false);
    }
}

