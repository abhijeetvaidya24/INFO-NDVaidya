/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Color
 *  android.media.AudioManager
 *  android.media.MediaPlayer
 *  android.media.MediaPlayer$OnCompletionListener
 *  android.media.MediaPlayer$OnErrorListener
 *  android.media.MediaPlayer$OnInfoListener
 *  android.media.MediaPlayer$OnPreparedListener
 *  android.media.MediaPlayer$OnSeekCompleteListener
 *  android.os.Handler
 *  android.os.Looper
 *  android.util.DisplayMetrics
 *  android.view.Display
 *  android.view.WindowManager
 *  android.widget.VideoView
 *  com.tapjoy.TJAdUnit$a
 *  com.tapjoy.TJAdUnitJSBridge
 *  com.tapjoy.TapjoyErrorMessage
 *  com.tapjoy.TapjoyErrorMessage$ErrorType
 *  com.tapjoy.TapjoyLog
 *  com.tapjoy.TapjoyUtil
 *  com.tapjoy.internal.ct
 *  com.tapjoy.internal.ep
 *  com.tapjoy.internal.et
 *  com.tapjoy.internal.fi
 *  com.tapjoy.internal.fi$a
 *  com.tapjoy.internal.gq
 *  com.tapjoy.mraid.listener.MraidViewListener
 *  com.tapjoy.mraid.view.BasicWebView
 *  com.tapjoy.mraid.view.MraidView
 *  java.lang.Boolean
 *  java.lang.Double
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Map
 *  java.util.concurrent.ScheduledExecutorService
 *  java.util.concurrent.ScheduledFuture
 *  java.util.concurrent.TimeUnit
 *  org.json.JSONObject
 */
package com.tapjoy;

import android.content.Context;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import android.widget.VideoView;
import com.tapjoy.TJAdUnit;
import com.tapjoy.TJAdUnitActivity;
import com.tapjoy.TJAdUnitJSBridge;
import com.tapjoy.TJAdUnitSaveStateData;
import com.tapjoy.TJPlacementData;
import com.tapjoy.TJPlacementManager;
import com.tapjoy.TJVideoListener;
import com.tapjoy.TapjoyConnectCore;
import com.tapjoy.TapjoyErrorMessage;
import com.tapjoy.TapjoyLog;
import com.tapjoy.TapjoyUtil;
import com.tapjoy.internal.ct;
import com.tapjoy.internal.ep;
import com.tapjoy.internal.et;
import com.tapjoy.internal.fi;
import com.tapjoy.internal.gq;
import com.tapjoy.mraid.listener.MraidViewListener;
import com.tapjoy.mraid.view.BasicWebView;
import com.tapjoy.mraid.view.MraidView;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

public class TJAdUnit
implements MediaPlayer.OnCompletionListener,
MediaPlayer.OnErrorListener,
MediaPlayer.OnInfoListener,
MediaPlayer.OnPreparedListener {
    public static TJVideoListener publisherVideoListener;
    private boolean A;
    private boolean B;
    private ep C;
    private final Runnable D = new Runnable(){

        public final void run() {
            int n2 = TJAdUnit.this.p.getStreamVolume(3);
            if (TJAdUnit.this.q != n2) {
                TJAdUnit.this.q = n2;
                TJAdUnit.this.a.onVolumeChanged();
            }
        }
    };
    private final Runnable E = new Runnable(){

        public final void run() {
            if (TJAdUnit.this.d.getCurrentPosition() != 0) {
                if (!TJAdUnit.this.m) {
                    TJAdUnit.this.m = true;
                }
                TJAdUnit.this.a.onVideoStarted(TJAdUnit.this.k);
                TJAdUnit.this.F.run();
                return;
            }
            if (!TJAdUnit.this.A) {
                TJAdUnit.this.f.postDelayed(TJAdUnit.this.E, 200L);
                return;
            }
            TJAdUnit.this.B = true;
        }
    };
    private final Runnable F = new Runnable(){

        public final void run() {
            TJAdUnit.this.a.onVideoProgress(TJAdUnit.this.d.getCurrentPosition());
            TJAdUnit.this.f.postDelayed(TJAdUnit.this.F, 500L);
        }
    };
    TJAdUnitJSBridge a;
    BasicWebView b;
    MraidView c;
    VideoView d;
    volatile boolean e;
    private final Handler f = new Handler(Looper.getMainLooper());
    private TJAdUnitWebViewListener g;
    private TJAdUnitVideoListener h;
    private TJAdUnitActivity i;
    private MediaPlayer j;
    private int k;
    private boolean l;
    private boolean m;
    private boolean n;
    private ScheduledFuture o;
    private AudioManager p;
    private int q = 0;
    private int r;
    private boolean s;
    private boolean t;
    private boolean u;
    private boolean v;
    private boolean w;
    private boolean x;
    private boolean y;
    private int z = -1;

    private void a() {
        TapjoyLog.d((String)"TJAdUnit", (String)"detachVolumeListener");
        ScheduledFuture scheduledFuture = this.o;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
            this.o = null;
        }
        this.p = null;
    }

    private static boolean a(int n2) {
        return n2 == 0 || n2 == 8 || n2 == 6 || n2 == 11;
        {
        }
    }

    private void b() {
        this.f.removeCallbacks(this.E);
        this.f.removeCallbacks(this.F);
    }

    private static boolean b(int n2) {
        if (n2 != 1 && n2 != 9 && n2 != 7) {
            return n2 == 12;
        }
        return true;
    }

    private void c() {
        ep ep2 = this.C;
        if (ep2 != null) {
            ep2.a("prerendered", (Object)this.x);
        }
    }

    static /* synthetic */ TJAdUnitActivity r(TJAdUnit tJAdUnit) {
        return tJAdUnit.i;
    }

    static /* synthetic */ void s(TJAdUnit tJAdUnit) {
        tJAdUnit.a();
    }

    static /* synthetic */ boolean t(TJAdUnit tJAdUnit) {
        tJAdUnit.y = true;
        return true;
    }

    static /* synthetic */ boolean u(TJAdUnit tJAdUnit) {
        return tJAdUnit.v;
    }

    static /* synthetic */ void v(TJAdUnit tJAdUnit) {
        tJAdUnit.a.display();
    }

    final void a(boolean bl) {
        MediaPlayer mediaPlayer = this.j;
        if (mediaPlayer != null) {
            if (bl) {
                mediaPlayer.setVolume(0.0f, 0.0f);
            } else {
                mediaPlayer.setVolume(1.0f, 1.0f);
            }
            if (this.t != bl) {
                this.t = bl;
                this.a.onVolumeChanged();
                return;
            }
        } else {
            this.s = bl;
        }
    }

    public void attachVolumeListener(boolean bl, int n2) {
        StringBuilder stringBuilder = new StringBuilder("attachVolumeListener: isAttached=");
        stringBuilder.append(bl);
        stringBuilder.append("; interval=");
        stringBuilder.append(n2);
        TapjoyLog.d((String)"TJAdUnit", (String)stringBuilder.toString());
        this.a();
        if (!bl) {
            return;
        }
        TJAdUnitActivity tJAdUnitActivity = this.i;
        if (tJAdUnitActivity != null) {
            this.p = (AudioManager)tJAdUnitActivity.getSystemService("audio");
            this.q = this.p.getStreamVolume(3);
            this.r = this.p.getStreamMaxVolume(3);
            ScheduledExecutorService scheduledExecutorService = gq.a;
            Runnable runnable = this.D;
            long l2 = n2;
            this.o = scheduledExecutorService.scheduleWithFixedDelay(runnable, l2, l2, TimeUnit.MILLISECONDS);
        }
    }

    public void clearVideo(final TJAdUnitJSBridge.AdUnitAsyncTaskListner adUnitAsyncTaskListner) {
        if (this.d != null) {
            this.b();
            TapjoyUtil.runOnMainThread((Runnable)new Runnable(){

                public final void run() {
                    TJAdUnit.this.d.setVisibility(4);
                    TJAdUnit.this.d.stopPlayback();
                    TJAdUnit.this.m = false;
                    TJAdUnit.this.l = false;
                    TJAdUnit.this.k = 0;
                    adUnitAsyncTaskListner.onComplete(true);
                }
            });
            return;
        }
        adUnitAsyncTaskListner.onComplete(false);
    }

    public void closeRequested(boolean bl) {
        MraidView mraidView = this.c;
        if (mraidView != null && mraidView.videoPlaying()) {
            this.c.videoViewCleanup();
            return;
        }
        this.a.closeRequested(Boolean.valueOf((boolean)bl));
    }

    public void destroy() {
        MraidView mraidView;
        this.a.destroy();
        BasicWebView basicWebView = this.b;
        if (basicWebView != null) {
            basicWebView.removeAllViews();
            this.b = null;
        }
        if ((mraidView = this.c) != null) {
            mraidView.removeAllViews();
            this.c = null;
        }
        this.b();
        this.e = false;
        this.v = false;
        this.setAdUnitActivity(null);
        this.a();
        this.j = null;
        TJAdUnitWebViewListener tJAdUnitWebViewListener = this.g;
        if (tJAdUnitWebViewListener != null) {
            tJAdUnitWebViewListener.onClosed();
        }
        this.resetContentLoadState();
    }

    public void endAdContentTracking(String string, JSONObject jSONObject) {
        if (this.C != null) {
            this.c();
            this.C.b(string, jSONObject);
        }
    }

    public void fireContentReady() {
        TJAdUnitWebViewListener tJAdUnitWebViewListener = this.g;
        if (tJAdUnitWebViewListener != null) {
            tJAdUnitWebViewListener.onContentReady();
        }
    }

    public void fireOnVideoComplete() {
        TJAdUnitVideoListener tJAdUnitVideoListener;
        TapjoyLog.v((String)"TJAdUnit", (String)"Firing onVideoComplete");
        if (this.getPublisherVideoListener() != null) {
            this.getPublisherVideoListener().onVideoComplete();
        }
        if ((tJAdUnitVideoListener = this.h) != null) {
            tJAdUnitVideoListener.onVideoCompleted();
        }
    }

    public void fireOnVideoError(String string) {
        TJAdUnitVideoListener tJAdUnitVideoListener;
        StringBuilder stringBuilder = new StringBuilder("Firing onVideoError with error: ");
        stringBuilder.append(string);
        TapjoyLog.e((String)"TJAdUnit", (String)stringBuilder.toString());
        if (this.getPublisherVideoListener() != null) {
            this.getPublisherVideoListener().onVideoError(3);
        }
        if ((tJAdUnitVideoListener = this.h) != null) {
            tJAdUnitVideoListener.onVideoError(string);
        }
    }

    public void fireOnVideoStart() {
        TJAdUnitVideoListener tJAdUnitVideoListener;
        TapjoyLog.v((String)"TJAdUnit", (String)"Firing onVideoStart");
        if (this.getPublisherVideoListener() != null) {
            this.getPublisherVideoListener().onVideoStart();
        }
        if ((tJAdUnitVideoListener = this.h) != null) {
            tJAdUnitVideoListener.onVideoStart();
        }
    }

    public BasicWebView getBackgroundWebView() {
        return this.b;
    }

    public boolean getCloseRequested() {
        return this.a.closeRequested;
    }

    public int getOrientation() {
        return this.z;
    }

    public TJVideoListener getPublisherVideoListener() {
        return publisherVideoListener;
    }

    public int getVideoSeekTime() {
        return this.k;
    }

    public VideoView getVideoView() {
        return this.d;
    }

    public String getVolume() {
        double d2 = this.q;
        double d3 = this.r;
        Double.isNaN((double)d2);
        Double.isNaN((double)d3);
        double d4 = d2 / d3;
        Object[] arrobject = new Object[]{d4};
        return String.format((String)"%.2f", (Object[])arrobject);
    }

    public MraidView getWebView() {
        return this.c;
    }

    public boolean hasCalledLoad() {
        return this.w;
    }

    public /* varargs */ void invokeBridgeCallback(String string, Object ... arrobject) {
        TJAdUnitJSBridge tJAdUnitJSBridge = this.a;
        if (tJAdUnitJSBridge != null && string != null) {
            tJAdUnitJSBridge.invokeJSCallback(string, arrobject);
        }
    }

    public boolean isLockedOrientation() {
        return this.u;
    }

    public boolean isMuted() {
        return this.t;
    }

    public boolean isPrerendered() {
        return this.x;
    }

    public boolean isVideoComplete() {
        return this.n;
    }

    public void load(TJPlacementData tJPlacementData, boolean bl, Context context) {
        this.w = false;
        TapjoyUtil.runOnMainThread((Runnable)new Runnable(this, context, tJPlacementData, bl){
            final /* synthetic */ Context a;
            final /* synthetic */ TJPlacementData b;
            final /* synthetic */ boolean c;
            final /* synthetic */ TJAdUnit d;
            {
                this.d = tJAdUnit;
                this.a = context;
                this.b = tJPlacementData;
                this.c = bl;
            }

            public final void run() {
                TJAdUnit tJAdUnit = this.d;
                Context context = this.a;
                if (Looper.myLooper() == Looper.getMainLooper() && !tJAdUnit.e && context != null) {
                    TapjoyLog.d((String)"TJAdUnit", (String)"Constructing ad unit");
                    tJAdUnit.e = true;
                    tJAdUnit.b = new BasicWebView(context);
                    tJAdUnit.b.loadDataWithBaseURL(null, "<!DOCTYPE html><html><head><title>Tapjoy Background Webview</title></head></html>", "text/html", "utf-8", null);
                    tJAdUnit.c = new MraidView(context);
                    tJAdUnit.c.setListener((MraidViewListener)new /* Unavailable Anonymous Inner Class!! */);
                    tJAdUnit.d = new VideoView(context);
                    tJAdUnit.d.setOnCompletionListener((MediaPlayer.OnCompletionListener)tJAdUnit);
                    tJAdUnit.d.setOnErrorListener((MediaPlayer.OnErrorListener)tJAdUnit);
                    tJAdUnit.d.setOnPreparedListener((MediaPlayer.OnPreparedListener)tJAdUnit);
                    tJAdUnit.d.setVisibility(4);
                    tJAdUnit.a = new TJAdUnitJSBridge(context, tJAdUnit);
                    if (context instanceof TJAdUnitActivity) {
                        tJAdUnit.setAdUnitActivity((TJAdUnitActivity)context);
                    }
                }
                if (!tJAdUnit.e) {
                    return;
                }
                TapjoyLog.i((String)"TJAdUnit", (String)"Loading ad unit content");
                this.d.w = true;
                if (!ct.c((String)this.b.getRedirectURL())) {
                    if (this.b.isPreloadDisabled()) {
                        this.d.c.postUrl(this.b.getRedirectURL(), null);
                    } else {
                        this.d.c.loadUrl(this.b.getRedirectURL());
                    }
                } else if (this.b.getBaseURL() != null && this.b.getHttpResponse() != null) {
                    this.d.c.loadDataWithBaseURL(this.b.getBaseURL(), this.b.getHttpResponse(), "text/html", "utf-8", null);
                } else {
                    TapjoyLog.e((String)"TJAdUnit", (TapjoyErrorMessage)new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.SDK_ERROR, "Error loading ad unit content"));
                    this.d.w = false;
                }
                TJAdUnit tJAdUnit2 = this.d;
                boolean bl = tJAdUnit2.w;
                boolean bl2 = false;
                if (bl) {
                    boolean bl3 = this.c;
                    bl2 = false;
                    if (bl3) {
                        bl2 = true;
                    }
                }
                tJAdUnit2.x = bl2;
            }
        });
    }

    public void loadVideoUrl(final String string, final TJAdUnitJSBridge.AdUnitAsyncTaskListner adUnitAsyncTaskListner) {
        TapjoyUtil.runOnMainThread((Runnable)new Runnable(){

            public final void run() {
                if (TJAdUnit.this.d != null) {
                    StringBuilder stringBuilder = new StringBuilder("loadVideoUrl: ");
                    stringBuilder.append(string);
                    TapjoyLog.i((String)"TJAdUnit", (String)stringBuilder.toString());
                    TJAdUnit.this.d.setVideoPath(string);
                    TJAdUnit.this.d.setVisibility(0);
                    TJAdUnit.this.d.seekTo(0);
                    adUnitAsyncTaskListner.onComplete(true);
                    return;
                }
                adUnitAsyncTaskListner.onComplete(false);
            }
        });
    }

    public void onCompletion(MediaPlayer mediaPlayer) {
        TapjoyLog.i((String)"TJAdUnit", (String)"video -- onCompletion");
        this.b();
        this.n = true;
        if (!this.l) {
            this.a.onVideoCompletion();
        }
        this.l = false;
    }

    public boolean onError(MediaPlayer mediaPlayer, int n2, int n3) {
        String string;
        TapjoyErrorMessage.ErrorType errorType = TapjoyErrorMessage.ErrorType.SDK_ERROR;
        StringBuilder stringBuilder = new StringBuilder("Error encountered when instantiating the VideoView: ");
        stringBuilder.append(n2);
        stringBuilder.append(" - ");
        stringBuilder.append(n3);
        TapjoyLog.e((String)"TJAdUnit", (TapjoyErrorMessage)new TapjoyErrorMessage(errorType, stringBuilder.toString()));
        int n4 = 1;
        this.l = n4;
        this.b();
        String string2 = n2 != 100 ? "MEDIA_ERROR_UNKNOWN" : "MEDIA_ERROR_SERVER_DIED";
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(string2);
        stringBuilder2.append(" -- ");
        String string3 = stringBuilder2.toString();
        if (n3 != -1010) {
            if (n3 != -1007) {
                if (n3 != -1004) {
                    if (n3 != -110) {
                        StringBuilder stringBuilder3 = new StringBuilder();
                        stringBuilder3.append(string3);
                        stringBuilder3.append("MEDIA_ERROR_EXTRA_UNKNOWN");
                        string = stringBuilder3.toString();
                    } else {
                        StringBuilder stringBuilder4 = new StringBuilder();
                        stringBuilder4.append(string3);
                        stringBuilder4.append("MEDIA_ERROR_TIMED_OUT");
                        string = stringBuilder4.toString();
                    }
                } else {
                    StringBuilder stringBuilder5 = new StringBuilder();
                    stringBuilder5.append(string3);
                    stringBuilder5.append("MEDIA_ERROR_IO");
                    string = stringBuilder5.toString();
                }
            } else {
                StringBuilder stringBuilder6 = new StringBuilder();
                stringBuilder6.append(string3);
                stringBuilder6.append("MEDIA_ERROR_MALFORMED");
                string = stringBuilder6.toString();
            }
        } else {
            StringBuilder stringBuilder7 = new StringBuilder();
            stringBuilder7.append(string3);
            stringBuilder7.append("MEDIA_ERROR_UNSUPPORTED");
            string = stringBuilder7.toString();
        }
        this.a.onVideoError(string);
        if (n2 != n4) {
            if (n3 == -1004) {
                return n4;
            }
            n4 = 0;
        }
        return n4;
    }

    public boolean onInfo(MediaPlayer mediaPlayer, int n2, int n3) {
        String string;
        if (n2 != 3) {
            if (n2 != 801) {
                switch (n2) {
                    default: {
                        string = "";
                        break;
                    }
                    case 702: {
                        string = "MEDIA_INFO_BUFFERING_END";
                        break;
                    }
                    case 701: {
                        string = "MEDIA_INFO_BUFFERING_START";
                        break;
                    }
                    case 700: {
                        string = "MEDIA_INFO_VIDEO_TRACK_LAGGING";
                        break;
                    }
                }
            } else {
                string = "MEDIA_INFO_NOT_SEEKABLE";
            }
        } else {
            string = "MEDIA_INFO_VIDEO_RENDERING_START";
        }
        this.a.onVideoInfo(string);
        return false;
    }

    public void onPrepared(MediaPlayer mediaPlayer) {
        TapjoyLog.i((String)"TJAdUnit", (String)"video -- onPrepared");
        final int n2 = this.d.getDuration();
        final int n3 = this.d.getMeasuredWidth();
        final int n4 = this.d.getMeasuredHeight();
        this.j = mediaPlayer;
        boolean bl = this.s;
        if (bl) {
            this.a(bl);
        }
        if (this.k > 0 && this.d.getCurrentPosition() != this.k) {
            this.j.setOnSeekCompleteListener(new MediaPlayer.OnSeekCompleteListener(){

                public final void onSeekComplete(MediaPlayer mediaPlayer) {
                    TJAdUnit.this.a.onVideoReady(n2, n3, n4);
                }
            });
        } else {
            this.a.onVideoReady(n2, n3, n4);
        }
        this.j.setOnInfoListener((MediaPlayer.OnInfoListener)this);
    }

    public void pause() {
        this.A = true;
        this.a.setEnabled(false);
        this.pauseVideo();
    }

    public boolean pauseVideo() {
        this.b();
        VideoView videoView = this.d;
        if (videoView != null && videoView.isPlaying()) {
            this.d.pause();
            this.k = this.d.getCurrentPosition();
            StringBuilder stringBuilder = new StringBuilder("Video paused at: ");
            stringBuilder.append(this.k);
            TapjoyLog.i((String)"TJAdUnit", (String)stringBuilder.toString());
            this.a.onVideoPaused(this.k);
            return true;
        }
        return false;
    }

    public boolean playVideo() {
        TapjoyLog.i((String)"TJAdUnit", (String)"playVideo");
        VideoView videoView = this.d;
        if (videoView == null) {
            return false;
        }
        videoView.start();
        this.n = false;
        this.f.postDelayed(this.E, 200L);
        return true;
    }

    public boolean preload(TJPlacementData tJPlacementData, Context context) {
        if (!this.w && tJPlacementData.isPrerenderingRequested() && TJPlacementManager.canPreRenderPlacement() && !TapjoyConnectCore.isViewOpen()) {
            StringBuilder stringBuilder = new StringBuilder("Pre-rendering ad unit for placement: ");
            stringBuilder.append(tJPlacementData.getPlacementName());
            TapjoyLog.i((String)"TJAdUnit", (String)stringBuilder.toString());
            TJPlacementManager.incrementPlacementPreRenderCount();
            this.load(tJPlacementData, true, context);
            return true;
        }
        this.fireContentReady();
        return false;
    }

    public void resetContentLoadState() {
        this.w = false;
        this.y = false;
        this.x = false;
        this.z = -1;
        this.u = false;
        this.s = false;
    }

    public void resume(TJAdUnitSaveStateData tJAdUnitSaveStateData) {
        if (this.a.didLaunchOtherActivity) {
            StringBuilder stringBuilder = new StringBuilder("onResume bridge.didLaunchOtherActivity callbackID: ");
            stringBuilder.append(this.a.otherActivityCallbackID);
            TapjoyLog.d((String)"TJAdUnit", (String)stringBuilder.toString());
            TJAdUnitJSBridge tJAdUnitJSBridge = this.a;
            String string = tJAdUnitJSBridge.otherActivityCallbackID;
            Object[] arrobject = new Object[]{Boolean.TRUE};
            tJAdUnitJSBridge.invokeJSCallback(string, arrobject);
            this.a.didLaunchOtherActivity = false;
        }
        this.A = false;
        this.a.setEnabled(true);
        if (tJAdUnitSaveStateData != null) {
            this.k = tJAdUnitSaveStateData.seekTime;
            this.d.seekTo(this.k);
            if (this.j != null) {
                this.s = tJAdUnitSaveStateData.isVideoMuted;
            }
        }
        if (this.B) {
            this.B = false;
            this.f.postDelayed(this.E, 200L);
        }
    }

    public void sendAdContentTracking(String string, JSONObject jSONObject) {
        if (this.C != null) {
            this.c();
            ep ep2 = this.C;
            Map map = ep.a((JSONObject)jSONObject);
            Map map2 = ep.b((JSONObject)jSONObject);
            fi.e((String)string).a(ep2.a).a(map).b(map2).c();
        }
    }

    public void setAdContentTracker(ep ep2) {
        this.C = ep2;
    }

    public void setAdUnitActivity(TJAdUnitActivity tJAdUnitActivity) {
        TJAdUnitJSBridge tJAdUnitJSBridge;
        this.i = tJAdUnitActivity;
        MraidView mraidView = this.c;
        if (mraidView != null) {
            mraidView.setContext((Context)this.i);
        }
        if ((tJAdUnitJSBridge = this.a) != null) {
            tJAdUnitJSBridge.setAdUnitActivity(this.i);
        }
    }

    public void setBackgroundColor(final String string, final TJAdUnitJSBridge.AdUnitAsyncTaskListner adUnitAsyncTaskListner) {
        TapjoyUtil.runOnMainThread((Runnable)new Runnable(){

            public final void run() {
                try {
                    StringBuilder stringBuilder = new StringBuilder("setBackgroundColor: ");
                    stringBuilder.append(string);
                    TapjoyLog.d((String)"TJAdUnit", (String)stringBuilder.toString());
                    TJAdUnit.this.b.setBackgroundColor(Color.parseColor((String)string));
                    adUnitAsyncTaskListner.onComplete(true);
                    return;
                }
                catch (Exception exception) {
                    StringBuilder stringBuilder = new StringBuilder("Error setting background color. backgroundWebView: ");
                    stringBuilder.append((Object)TJAdUnit.this.b);
                    stringBuilder.append(", hexColor: ");
                    stringBuilder.append(string);
                    TapjoyLog.d((String)"TJAdUnit", (String)stringBuilder.toString());
                    adUnitAsyncTaskListner.onComplete(false);
                    return;
                }
            }
        });
    }

    public void setBackgroundContent(final String string, final TJAdUnitJSBridge.AdUnitAsyncTaskListner adUnitAsyncTaskListner) {
        TapjoyUtil.runOnMainThread((Runnable)new Runnable(){

            public final void run() {
                try {
                    StringBuilder stringBuilder = new StringBuilder("setBackgroundContent: ");
                    stringBuilder.append(string);
                    TapjoyLog.d((String)"TJAdUnit", (String)stringBuilder.toString());
                    TJAdUnit.this.b.loadDataWithBaseURL(null, string, "text/html", "utf-8", null);
                    adUnitAsyncTaskListner.onComplete(true);
                    return;
                }
                catch (Exception exception) {
                    StringBuilder stringBuilder = new StringBuilder("Error setting background content. backgroundWebView: ");
                    stringBuilder.append((Object)TJAdUnit.this.b);
                    stringBuilder.append(", content: ");
                    stringBuilder.append(string);
                    TapjoyLog.d((String)"TJAdUnit", (String)stringBuilder.toString());
                    adUnitAsyncTaskListner.onComplete(false);
                    return;
                }
            }
        });
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public void setOrientation(int var1_1) {
        block7 : {
            block5 : {
                block8 : {
                    block6 : {
                        var2_2 = this.i;
                        if (var2_2 == null) return;
                        if (var2_2 == null) break block5;
                        var5_3 = var2_2.getWindowManager().getDefaultDisplay().getRotation();
                        var6_4 = new DisplayMetrics();
                        var2_2.getWindowManager().getDefaultDisplay().getMetrics(var6_4);
                        var7_5 = var6_4.widthPixels;
                        var8_6 = var6_4.heightPixels;
                        if ((var5_3 == 0 || var5_3 == 2) && var8_6 > var7_5 || (var5_3 == 1 || var5_3 == 3) && var7_5 > var8_6) break block6;
                        var3_7 = 0;
                        if (var5_3 == 0) break block7;
                        if (var5_3 == 1) ** GOTO lbl-1000
                        if (var5_3 == 2) ** GOTO lbl-1000
                        if (var5_3 == 3) break block8;
                        TapjoyLog.w((String)"TJAdUnit", (String)"Unknown screen orientation. Defaulting to landscape.");
                        var3_7 = 0;
                        break block7;
                    }
                    if (var5_3 == 0) ** GOTO lbl-1000
                    var3_7 = 0;
                    if (var5_3 == 1) break block7;
                    if (var5_3 != 2) {
                        ** if (var5_3 == 3) goto lbl-1000
                    }
                    break block8;
lbl-1000: // 3 sources:
                    {
                        var3_7 = 1;
                        ** GOTO lbl34
                    }
lbl-1000: // 2 sources:
                    {
                        var3_7 = 8;
                    }
                    break block7;
                }
                var3_7 = 9;
                break block7;
            }
            var3_7 = -1;
        }
        if ((var4_8 = this.z) == -1) {
            var4_8 = var3_7;
        }
        if (TJAdUnit.a(var4_8) && TJAdUnit.a(var1_1) || TJAdUnit.b(var4_8) && TJAdUnit.b(var1_1)) {
            var1_1 = this.z;
        }
        var2_2.setRequestedOrientation(var1_1);
        this.z = var1_1;
        this.u = true;
    }

    public void setVideoListener(TJAdUnitVideoListener tJAdUnitVideoListener) {
        this.h = tJAdUnitVideoListener;
    }

    public void setVisible(boolean bl) {
        this.v = bl;
        if (this.v && this.y) {
            this.a.display();
        }
    }

    public void setWebViewListener(TJAdUnitWebViewListener tJAdUnitWebViewListener) {
        this.g = tJAdUnitWebViewListener;
    }

    public void startAdContentTracking(String string, JSONObject jSONObject) {
        ep ep2 = this.C;
        if (ep2 != null) {
            ep2.a(string, jSONObject);
        }
    }

    public void unsetOrientation() {
        TJAdUnitActivity tJAdUnitActivity = this.i;
        if (tJAdUnitActivity != null) {
            tJAdUnitActivity.setRequestedOrientation(-1);
        }
        this.z = -1;
        this.u = false;
    }

    public static interface TJAdUnitVideoListener {
        public void onVideoCompleted();

        public void onVideoError(String var1);

        public void onVideoStart();
    }

    public static interface TJAdUnitWebViewListener {
        public void onClosed();

        public void onContentReady();
    }

}

