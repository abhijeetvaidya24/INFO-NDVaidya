/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  com.appnext.core.AppnextAd
 *  java.io.File
 *  java.lang.Boolean
 *  java.lang.Class
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Thread
 *  java.lang.Throwable
 *  java.util.HashMap
 *  java.util.Random
 */
package com.appnext.ads.fullscreen;

import android.content.Context;
import android.content.Intent;
import com.appnext.ads.fullscreen.FullscreenActivity;
import com.appnext.ads.fullscreen.Video;
import com.appnext.ads.fullscreen.VideoConfig;
import com.appnext.ads.fullscreen.b;
import com.appnext.ads.fullscreen.c;
import com.appnext.ads.fullscreen.f;
import com.appnext.core.Ad;
import com.appnext.core.AppnextAd;
import com.appnext.core.AppnextAdCreativeType;
import com.appnext.core.ECPM;
import com.appnext.core.callbacks.OnAdClicked;
import com.appnext.core.callbacks.OnAdClosed;
import com.appnext.core.callbacks.OnAdError;
import com.appnext.core.callbacks.OnAdLoaded;
import com.appnext.core.callbacks.OnAdOpened;
import com.appnext.core.callbacks.OnECPMLoaded;
import com.appnext.core.callbacks.OnVideoEnded;
import com.appnext.core.d;
import com.appnext.core.j;
import com.appnext.core.p;
import java.io.File;
import java.util.HashMap;
import java.util.Random;

public abstract class Video
extends Ad {
    protected static final int FULL_SCREEN_VIDEO = 1;
    protected static final int REWARDED_VIDEO = 2;
    protected static final String TID = "301";
    protected static final String VID = "2.5.0.472";
    public static final String VIDEO_LENGTH_LONG = "30";
    public static final String VIDEO_LENGTH_SHORT = "15";
    private static boolean cacheVideo = true;
    protected static Video currentAd;
    private static boolean init;
    private static boolean streamingEnable;
    private boolean canClose;
    private String language;
    protected long rnd;
    private int rollCaptionTime;
    private boolean showCta;
    private int type;
    private OnAdError userOnAdError;
    private OnVideoEnded videoEnded;
    private String videoLength = "15";

    public Video(Context context, int n2, String string2) {
        super(context, string2);
        this.showCta = true;
        this.rollCaptionTime = -2;
        this.language = "";
        this.canClose = true;
        this.type = n2;
        this.rnd = new Random(System.currentTimeMillis()).nextInt(Integer.MAX_VALUE);
        this.init();
    }

    public Video(Context context, int n2, String string2, VideoConfig videoConfig) {
        boolean bl;
        super(context, string2);
        this.showCta = bl = true;
        this.rollCaptionTime = -2;
        this.language = "";
        this.canClose = bl;
        this.type = n2;
        this.rnd = new Random(System.currentTimeMillis()).nextInt(Integer.MAX_VALUE);
        this.init();
        if (videoConfig != null) {
            this.setPostback(videoConfig.getPostback());
            this.setCategories(videoConfig.getCategories());
            this.setOrientation(videoConfig.getOrientation());
            boolean bl2 = videoConfig.showCta != null;
            if (bl2) {
                this.setShowCta(videoConfig.isShowCta());
            }
            this.setRollCaptionTime(videoConfig.getRollCaptionTime());
            this.setVideoLength(videoConfig.getVideoLength());
            if (videoConfig.mute == null) {
                bl = false;
            }
            if (bl) {
                this.setMute(videoConfig.getMute());
            }
            this.setMinVideoLength(videoConfig.getMinVideoLength());
            this.setMaxVideoLength(videoConfig.getMaxVideoLength());
            this.setLanguage(videoConfig.getLanguage());
        }
    }

    protected Video(Context context, Video video) {
        super(context, video.getPlacementID());
        this.showCta = true;
        this.rollCaptionTime = -2;
        this.language = "";
        this.canClose = true;
        this.type = video.type;
        this.rnd = video.rnd;
        this.setPostback(video.getPostback());
        this.setCategories(video.getCategories());
        this.setOrientation(video.getOrientation());
        this.setVideoLength(video.getVideoLength());
        this.setMute(video.getMute());
        this.setMinVideoLength(video.getMinVideoLength());
        this.setMaxVideoLength(video.getMaxVideoLength());
        this.setRollCaptionTime(video.getRollCaptionTime());
        this.setShowCta(video.isShowCta());
        this.setLanguage(video.getLanguage());
        this.setOnVideoEndedCallback(video.getOnVideoEndedCallback());
        this.setOnAdClosedCallback(video.getOnAdClosedCallback());
        this.setOnAdErrorCallback(video.getOnAdErrorCallback());
        this.setOnAdClickedCallback(video.getOnAdClickedCallback());
        this.setOnAdOpenedCallback(video.getOnAdOpenedCallback());
        this.setOnAdLoadedCallback(video.getOnAdLoadedCallback());
        this.setSessionId(video.getSessionId());
    }

    static /* synthetic */ boolean access$000() {
        return init;
    }

    static /* synthetic */ boolean access$002(boolean bl) {
        init = bl;
        return bl;
    }

    static /* synthetic */ Context access$100(Video video) {
        return video.context;
    }

    static /* synthetic */ int access$200(Video video) {
        return video.type;
    }

    static /* synthetic */ OnAdError access$300(Video video) {
        return video.userOnAdError;
    }

    public static boolean getCacheVideo() {
        return cacheVideo;
    }

    private void init() {
        this.getConfig().q("tid", this.getTID());
        this.getConfig().a(this.context, new p.a(){

            @Override
            public final void b(HashMap<String, Object> hashMap) {
                j.bh().b(Integer.parseInt((String)Video.this.getConfig().get("banner_expiration_time")));
            }

            @Override
            public final void error(String string2) {
                j.bh().b(Integer.parseInt((String)Video.this.getConfig().get("banner_expiration_time")));
            }
        });
        new Thread(new Runnable(this){
            final /* synthetic */ Video bJ;
            {
                this.bJ = video;
            }

            public final void run() {
                if (Video.access$000()) {
                    return;
                }
                Video.access$002(true);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(Video.access$100(this.bJ).getFilesDir().getAbsolutePath());
                stringBuilder.append("/data/appnext/videos/");
                stringBuilder.append("tmp/");
                com.appnext.core.f.a(new File(stringBuilder.toString()));
            }
        }).start();
        super.setOnAdErrorCallback(new OnAdError(){

            /*
             * Unable to fully structure code
             * Enabled aggressive block sorting
             * Lifted jumps to return sites
             */
            @Override
            public final void adError(String var1_1) {
                block18 : {
                    switch (var1_1.hashCode()) {
                        default: {
                            break;
                        }
                        case 844170097: {
                            if (!var1_1.equals((Object)"Too Slow Connection")) break;
                            var2_2 = 4;
                            break block18;
                        }
                        case 350741825: {
                            if (!var1_1.equals((Object)"Timeout")) break;
                            var2_2 = 5;
                            break block18;
                        }
                        case 297538105: {
                            if (!var1_1.equals((Object)"Ad Not Ready")) break;
                            var2_2 = 6;
                            break block18;
                        }
                        case -507110949: {
                            if (!var1_1.equals((Object)"No market installed on the device")) break;
                            var2_2 = 3;
                            break block18;
                        }
                        case -1477010874: {
                            if (!var1_1.equals((Object)"Connection Error")) break;
                            var2_2 = 0;
                            break block18;
                        }
                        case -1958363695: {
                            if (!var1_1.equals((Object)"No Ads")) break;
                            var2_2 = 2;
                            break block18;
                        }
                        case -2026653947: {
                            if (!var1_1.equals((Object)"Internal error")) break;
                            var2_2 = 1;
                            break block18;
                        }
                    }
                    var2_2 = -1;
                }
                switch (var2_2) {
                    default: {
                        var3_3 = "";
                        break;
                    }
                    case 6: {
                        var3_3 = "error_ad_not_ready";
                        break;
                    }
                    case 5: {
                        var3_3 = "error_timeout";
                        break;
                    }
                    case 4: {
                        var3_3 = "error_slow_connection";
                        break;
                    }
                    case 3: {
                        var3_3 = "error_no_market";
                        break;
                    }
                    case 2: {
                        var3_3 = "error_no_ads";
                        break;
                    }
                    case 1: {
                        var3_3 = "error_internal_error";
                        break;
                    }
                    case 0: {
                        var3_3 = "error_connection_error";
                    }
                }
                var4_4 = var3_3;
                ** break;
lbl60: // 1 sources:
                var5_5 = Video.this.getTID();
                var6_6 = Video.this.getVID();
                var7_7 = Video.this.getAUID();
                var8_8 = Video.this.getPlacementID();
                var9_9 = Video.this.getSessionId();
                var10_10 = Video.access$200(Video.this) == 1 ? "fullscreen" : "rewarded";
                com.appnext.core.f.a(var5_5, var6_6, var7_7, var8_8, var9_9, var4_4, var10_10, "", "");
                if (Video.access$300(Video.this) == null) return;
                Video.access$300(Video.this).adError(var1_1);
            }
        });
    }

    public static boolean isStreamingModeEnabled() {
        return streamingEnable;
    }

    private void load() {
        b.j().a(this.context, (Ad)this, this.getPlacementID(), new d.a(){

            @Override
            public final <T> void a(T t2) {
                AppnextAd appnextAd = b.j().b(Video.this.context, Video.this);
                if (Video.this.getOnAdLoadedCallback() != null) {
                    if (appnextAd != null) {
                        Video.this.getOnAdLoadedCallback().adLoaded(appnextAd.getBannerID(), appnextAd.getCreativeType());
                        return;
                    }
                    if (Video.this.getOnAdErrorCallback() != null) {
                        Video.this.getOnAdErrorCallback().adError("No Ads");
                    }
                }
            }

            @Override
            public final void error(String string2) {
                if (Video.this.getOnAdErrorCallback() != null) {
                    Video.this.getOnAdErrorCallback().adError(string2);
                }
            }
        });
    }

    public static void setCacheVideo(boolean bl) {
        cacheVideo = bl;
    }

    public static void setStreamingMode(boolean bl) {
        streamingEnable = bl;
    }

    @Override
    public void destroy() {
        super.destroy();
        this.videoEnded = null;
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.context.getFilesDir().getAbsolutePath());
            stringBuilder.append("/data/appnext/videos/");
            stringBuilder.append("tmp/vid");
            stringBuilder.append(this.rnd);
            stringBuilder.append("/");
            com.appnext.core.f.a(new File(stringBuilder.toString()));
        }
        catch (Throwable throwable) {}
    }

    protected void finalize() throws Throwable {
        try {
            this.destroy();
        }
        catch (Throwable throwable) {
            Object.super.finalize();
            throw throwable;
        }
        finally {
            Object.super.finalize();
            return;
        }
    }

    protected p getConfig() {
        int n2 = this.type;
        if (n2 == 2) {
            return f.q();
        }
        if (n2 == 1) {
            return c.m();
        }
        return null;
    }

    @Override
    public void getECPM(final OnECPMLoaded onECPMLoaded) {
        if (onECPMLoaded != null) {
            b.j().a(this.context, this, this.getPlacementID(), new d.a(){

                @Override
                public final <T> void a(T t2) {
                    AppnextAd appnextAd = b.j().b(Video.this.context, Video.this);
                    if (appnextAd != null) {
                        onECPMLoaded.ecpm(new ECPM(appnextAd.getECPM(), appnextAd.getPPR(), appnextAd.getBannerID()));
                        return;
                    }
                    onECPMLoaded.error("No Ads");
                }

                @Override
                public final void error(String string2) {
                    onECPMLoaded.error(string2);
                }
            }, false);
            return;
        }
        throw new IllegalArgumentException("Callback cannot be null");
    }

    public String getLanguage() {
        return this.language;
    }

    @Override
    public OnAdError getOnAdErrorCallback() {
        return super.getOnAdErrorCallback();
    }

    public OnVideoEnded getOnVideoEndedCallback() {
        return this.videoEnded;
    }

    public int getRollCaptionTime() {
        return this.rollCaptionTime;
    }

    @Override
    protected String getSessionId() {
        return super.getSessionId();
    }

    @Override
    public String getTID() {
        return TID;
    }

    @Override
    public String getVID() {
        return VID;
    }

    public String getVideoLength() {
        return this.videoLength;
    }

    @Override
    public boolean isAdLoaded() {
        if (this.getPlacementID().equals((Object)"")) {
            return false;
        }
        return b.j().b(this);
    }

    public boolean isBackButtonCanClose() {
        return this.canClose;
    }

    public boolean isShowCta() {
        return this.showCta;
    }

    @Override
    public void loadAd() {
        if (!this.getPlacementID().equals((Object)"")) {
            if (!com.appnext.core.f.a(this.context, "android.permission.INTERNET")) {
                if (this.getOnAdErrorCallback() != null) {
                    this.getOnAdErrorCallback().adError("Connection Error");
                }
                return;
            }
            this.getConfig().a(this.context, new p.a(){

                @Override
                public final void b(HashMap<String, Object> hashMap) {
                    Video.this.load();
                }

                @Override
                public final void error(String string2) {
                    Video.this.load();
                }
            });
            return;
        }
        throw new IllegalArgumentException("Placement ID cannot be empty");
    }

    public void setBackButtonCanClose(boolean bl) {
        this.canClose = bl;
    }

    public void setLanguage(String string2) {
        this.language = string2;
    }

    @Override
    public void setOnAdErrorCallback(OnAdError onAdError) {
        this.userOnAdError = onAdError;
    }

    public void setOnVideoEndedCallback(OnVideoEnded onVideoEnded) {
        this.videoEnded = onVideoEnded;
    }

    public void setParams(String string2, String string3) {
        this.getConfig().s(string2, string3);
    }

    public void setRollCaptionTime(int n2) {
        if (n2 == -1 || n2 >= 3 && n2 <= 10) {
            this.rollCaptionTime = n2;
        }
    }

    public void setShowCta(boolean bl) {
        this.showCta = bl;
    }

    public void setVideoLength(String string2) {
        if (!string2.equals((Object)VIDEO_LENGTH_SHORT) && !string2.equals((Object)VIDEO_LENGTH_LONG)) {
            throw new IllegalArgumentException("Wrong video length");
        }
        this.videoLength = string2;
    }

    @Override
    public void showAd() {
        if (!this.getPlacementID().equals((Object)"")) {
            if (!com.appnext.core.f.a(this.context, "android.permission.INTERNET")) {
                if (this.getOnAdErrorCallback() != null) {
                    this.getOnAdErrorCallback().adError("Connection Error");
                }
                return;
            }
            int n2 = com.appnext.core.f.aa(this.getConfig().get("min_internet_connection_video"));
            int n3 = com.appnext.core.f.aa(com.appnext.core.f.o(this.context));
            if (n3 == -1) {
                if (this.getOnAdErrorCallback() != null) {
                    this.getOnAdErrorCallback().adError("Connection Error");
                }
                return;
            }
            if (n3 < n2) {
                if (this.getOnAdErrorCallback() != null) {
                    this.getOnAdErrorCallback().adError("Too Slow Connection");
                }
                return;
            }
            String string2 = this.getTID();
            String string3 = this.getVID();
            String string4 = this.getAUID();
            String string5 = this.getPlacementID();
            String string6 = this.getSessionId();
            String string7 = this.type == 1 ? "fullscreen" : "rewarded";
            com.appnext.core.f.a(string2, string3, string4, string5, string6, "show_request", string7, "", "");
            if (b.j().b(this)) {
                Intent intent = new Intent(this.context, FullscreenActivity.class);
                intent.setFlags(268435456);
                intent.putExtra("id", this.getPlacementID());
                intent.putExtra("type", this.type);
                currentAd = this;
                this.context.startActivity(intent);
                return;
            }
            if (this.getOnAdErrorCallback() != null) {
                this.getOnAdErrorCallback().adError("Ad Not Ready");
            }
            b.j().a(this.context, (Ad)this, this.getPlacementID(), (d.a)null);
            String string8 = this.getTID();
            String string9 = this.getVID();
            String string10 = this.getAUID();
            String string11 = this.getPlacementID();
            String string12 = this.getSessionId();
            String string13 = this.type == 1 ? "fullscreen" : "rewarded";
            com.appnext.core.f.a(string8, string9, string10, string11, string12, "ad_not_ready", string13, "", "");
            return;
        }
        throw new IllegalArgumentException("Placement ID cannot be empty");
    }

}

