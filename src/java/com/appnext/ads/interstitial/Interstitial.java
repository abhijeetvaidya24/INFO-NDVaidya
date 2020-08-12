/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.graphics.Color
 *  android.os.Handler
 *  android.os.Looper
 *  com.appnext.core.AppnextAd
 *  java.lang.Boolean
 *  java.lang.Class
 *  java.lang.Deprecated
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Thread
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.HashMap
 */
package com.appnext.ads.interstitial;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import com.appnext.ads.interstitial.Interstitial;
import com.appnext.ads.interstitial.InterstitialActivity;
import com.appnext.ads.interstitial.InterstitialConfig;
import com.appnext.ads.interstitial.a;
import com.appnext.ads.interstitial.b;
import com.appnext.ads.interstitial.c;
import com.appnext.core.Ad;
import com.appnext.core.AppnextAd;
import com.appnext.core.ECPM;
import com.appnext.core.callbacks.OnAdError;
import com.appnext.core.callbacks.OnECPMLoaded;
import com.appnext.core.d;
import com.appnext.core.f;
import com.appnext.core.j;
import com.appnext.core.p;
import com.appnext.core.webview.AppnextWebView;
import java.util.ArrayList;
import java.util.HashMap;

public class Interstitial
extends Ad {
    private static final String JS_URL = "https://cdn.appnext.com/tools/sdk/interstitial/v75/script.min.js";
    protected static final String TID = "301";
    public static final String TYPE_MANAGED = "managed";
    public static final String TYPE_STATIC = "static";
    public static final String TYPE_VIDEO = "video";
    protected static final String VID = "2.5.0.472";
    protected static Interstitial currentAd;
    private boolean autoPlay;
    private String buttonColor;
    private boolean calledShow;
    private Boolean canClose;
    private boolean configLoaded;
    private String creativeType = "managed";
    private String language;
    private boolean setAutoPlay;
    private boolean setCanClose;
    private String skipText = "";
    private String titleText = "";
    private OnAdError userOnAdError;

    public Interstitial(Context context, String string2) {
        super(context, string2);
        this.autoPlay = true;
        this.setAutoPlay = false;
        this.setCanClose = false;
        this.configLoaded = false;
        this.calledShow = false;
        this.buttonColor = "";
        this.language = "";
        this.init();
    }

    public Interstitial(Context context, String string2, InterstitialConfig interstitialConfig) {
        boolean bl;
        super(context, string2);
        this.autoPlay = bl = true;
        this.setAutoPlay = false;
        this.setCanClose = false;
        this.configLoaded = false;
        this.calledShow = false;
        this.buttonColor = "";
        this.language = "";
        this.init();
        if (interstitialConfig != null) {
            this.setPostback(interstitialConfig.getPostback());
            this.setCategories(interstitialConfig.getCategories());
            this.setButtonColor(interstitialConfig.getButtonColor());
            boolean bl2 = interstitialConfig.backButtonCanClose != null;
            if (bl2) {
                this.setBackButtonCanClose(interstitialConfig.isBackButtonCanClose());
            }
            this.setSkipText(interstitialConfig.getSkipText());
            boolean bl3 = interstitialConfig.autoPlay != null;
            if (bl3) {
                this.setAutoPlay(interstitialConfig.isAutoPlay());
            }
            this.setCreativeType(interstitialConfig.getCreativeType());
            this.setOrientation(interstitialConfig.getOrientation());
            if (interstitialConfig.mute == null) {
                bl = false;
            }
            if (bl) {
                this.setMute(interstitialConfig.getMute());
            }
            this.setMinVideoLength(interstitialConfig.getMinVideoLength());
            this.setMaxVideoLength(interstitialConfig.getMaxVideoLength());
            this.setLanguage(interstitialConfig.getLanguage());
        }
    }

    protected Interstitial(Interstitial interstitial) {
        super(interstitial);
        this.autoPlay = true;
        this.setAutoPlay = false;
        this.setCanClose = false;
        this.configLoaded = false;
        this.calledShow = false;
        this.buttonColor = "";
        this.language = "";
        this.creativeType = interstitial.creativeType;
        this.titleText = interstitial.titleText;
        this.skipText = interstitial.skipText;
        this.autoPlay = interstitial.autoPlay;
        this.setAutoPlay = interstitial.setAutoPlay;
        this.setCanClose = interstitial.setCanClose;
        this.configLoaded = interstitial.configLoaded;
        this.calledShow = interstitial.calledShow;
        this.canClose = interstitial.canClose;
        this.buttonColor = interstitial.buttonColor;
        this.language = interstitial.language;
        this.userOnAdError = interstitial.userOnAdError;
    }

    static /* synthetic */ OnAdError access$000(Interstitial interstitial) {
        return interstitial.userOnAdError;
    }

    static /* synthetic */ Context access$100(Interstitial interstitial) {
        return interstitial.context;
    }

    static /* synthetic */ Context access$200(Interstitial interstitial) {
        return interstitial.context;
    }

    static /* synthetic */ Context access$300(Interstitial interstitial) {
        return interstitial.context;
    }

    static /* synthetic */ void access$400(Interstitial interstitial) {
        interstitial.load();
    }

    static /* synthetic */ Context access$500(Interstitial interstitial) {
        return interstitial.context;
    }

    private String getCreative() {
        int n2 = f.aa(this.getConfig().get("min_internet_connection"));
        int n3 = f.aa(this.getConfig().get("min_internet_connection_video"));
        int n4 = f.aa(f.o(this.context));
        if (n4 >= n2 && n4 < n3) {
            return TYPE_STATIC;
        }
        return this.getCreativeType();
    }

    private boolean hasVideo(AppnextAd appnextAd) {
        return !appnextAd.getVideoUrl().equals((Object)"") || !appnextAd.getVideoUrlHigh().equals((Object)"") || !appnextAd.getVideoUrl30Sec().equals((Object)"") || !appnextAd.getVideoUrlHigh30Sec().equals((Object)"");
        {
        }
    }

    private void init() {
        this.loadConfig();
        AppnextWebView.u(this.context).a(this.getPageUrl(), null);
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
                f.a(Interstitial.this.getTID(), Interstitial.this.getVID(), Interstitial.this.getAUID(), Interstitial.this.getPlacementID(), Interstitial.this.getSessionId(), var4_4, "current_interstitial", "", "");
                if (Interstitial.access$000(Interstitial.this) == null) return;
                Interstitial.access$000(Interstitial.this).adError(var1_1);
            }
        });
    }

    private void load() {
        a.G().a(this.context, this, this.getPlacementID(), new d.a(){

            /*
             * Exception decompiling
             */
            @Override
            public final <T> void a(T var1) {
                // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
                // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl26 : ALOAD_2 : trying to set 1 previously set to 0
                // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
                // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
                // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
                // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
                // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
                // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
                // org.benf.cfr.reader.entities.g.p(Method.java:396)
                // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
                // org.benf.cfr.reader.entities.d.c(ClassFile.java:773)
                // org.benf.cfr.reader.entities.d.e(ClassFile.java:870)
                // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
                // org.benf.cfr.reader.b.a(Driver.java:128)
                // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
                // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
                // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
                // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
                // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
                // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1167)
                // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:641)
                // java.lang.Thread.run(Thread.java:919)
                throw new IllegalStateException("Decompilation failed");
            }

            @Override
            public final void error(String string2) {
                if (Interstitial.this.getOnAdErrorCallback() != null) {
                    Interstitial.this.getOnAdErrorCallback().adError(string2);
                }
            }
        }, this.getCreative());
    }

    private void loadConfig() {
        this.getConfig().q("tid", this.getTID());
        this.getConfig().a(this.context, new p.a(){

            @Override
            public final void b(HashMap<String, Object> hashMap) {
                Interstitial.this.configLoaded = true;
                j.bh().b(Integer.parseInt((String)Interstitial.this.getConfig().get("banner_expiration_time")));
                if (Interstitial.this.calledShow) {
                    Interstitial.this.showAd();
                }
            }

            @Override
            public final void error(String string2) {
                Interstitial.this.configLoaded = true;
                j.bh().b(Integer.parseInt((String)Interstitial.this.getConfig().get("banner_expiration_time")));
                if (Interstitial.this.calledShow) {
                    Interstitial.this.showAd();
                }
            }
        });
    }

    private void startInterstitialActivity() {
        Intent intent = this.getActivityIntent();
        if (intent != null) {
            this.context.startActivity(intent);
            return;
        }
        throw new IllegalArgumentException("null intent");
    }

    @Override
    public void destroy() {
        super.destroy();
        currentAd = null;
    }

    @Override
    public String getAUID() {
        return "600";
    }

    protected Intent getActivityIntent() {
        Intent intent = new Intent(this.context, InterstitialActivity.class);
        intent.setFlags(268435456);
        intent.addFlags(67108864);
        intent.putExtra("id", this.getPlacementID());
        if (this.setAutoPlay) {
            intent.putExtra("auto_play", this.autoPlay);
        }
        if (this.setCanClose) {
            intent.putExtra("can_close", this.isBackButtonCanClose());
        }
        if (this.setMute) {
            intent.putExtra("mute", this.getMute());
        }
        intent.putExtra("cat", this.getCategories());
        intent.putExtra("pbk", this.getPostback());
        intent.putExtra("b_color", this.getButtonColor());
        intent.putExtra("skip_title", this.getSkipText());
        intent.putExtra("creative", this.getCreative());
        return intent;
    }

    public String getButtonColor() {
        return this.buttonColor;
    }

    protected p getConfig() {
        return c.K();
    }

    public String getCreativeType() {
        return this.creativeType;
    }

    @Override
    public void getECPM(final OnECPMLoaded onECPMLoaded) {
        if (onECPMLoaded != null) {
            a.G().a(this.context, this, this.getPlacementID(), new d.a(){

                @Override
                public final <T> void a(T t2) {
                    AppnextAd appnextAd = a.G().a(Interstitial.this.context, (ArrayList<AppnextAd>)((ArrayList)t2), Interstitial.this.getCreative(), Interstitial.this);
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

    protected com.appnext.core.webview.a getFallback() {
        return new b();
    }

    public String getLanguage() {
        return this.language;
    }

    @Override
    public OnAdError getOnAdErrorCallback() {
        return super.getOnAdErrorCallback();
    }

    protected String getPageUrl() {
        return JS_URL;
    }

    @Override
    protected String getSessionId() {
        return super.getSessionId();
    }

    public String getSkipText() {
        return this.skipText;
    }

    @Override
    public String getTID() {
        return TID;
    }

    @Override
    public String getVID() {
        return VID;
    }

    @Override
    public boolean isAdLoaded() {
        return !this.getPlacementID().equals((Object)"") && a.G().d(this);
    }

    public boolean isAutoPlay() {
        return this.autoPlay;
    }

    @Deprecated
    public boolean isBackButtonCanClose() {
        Boolean bl = this.canClose;
        if (bl == null) {
            return true;
        }
        return bl;
    }

    @Override
    public void loadAd() {
        if (!this.getPlacementID().equals((Object)"")) {
            if (!f.a(this.context, "android.permission.INTERNET")) {
                if (this.getOnAdErrorCallback() != null) {
                    this.getOnAdErrorCallback().adError("Connection Error");
                }
                return;
            }
            new Thread(new Runnable(this){
                final /* synthetic */ Interstitial bL;
                {
                    this.bL = interstitial;
                }

                public final void run() {
                    block6 : {
                        block5 : {
                            android.net.NetworkInfo networkInfo;
                            try {
                                if (Interstitial.access$100(this.bL).checkPermission("android.permission.ACCESS_NETWORK_STATE", android.os.Process.myPid(), android.os.Process.myUid()) != 0) {
                                    f.a("http://www.appnext.com/myid.html", null);
                                    break block5;
                                }
                                networkInfo = ((android.net.ConnectivityManager)Interstitial.access$200(this.bL).getSystemService("connectivity")).getActiveNetworkInfo();
                                if (networkInfo == null) break block6;
                            }
                            catch (Throwable throwable) {
                                new Handler(Looper.getMainLooper()).post(new Runnable(this){
                                    final /* synthetic */ 2 bM;
                                    {
                                        this.bM = var1_1;
                                    }

                                    public final void run() {
                                        if (this.bM.bL.getOnAdErrorCallback() != null) {
                                            this.bM.bL.getOnAdErrorCallback().adError("Connection Error");
                                        }
                                    }
                                });
                                return;
                            }
                            boolean bl = networkInfo.isConnected();
                            if (!bl) break block6;
                        }
                        this.bL.getConfig().a(Interstitial.access$300(this.bL), new p.a(this){
                            final /* synthetic */ 2 bM;
                            {
                                this.bM = var1_1;
                            }

                            public final void b(HashMap<String, Object> hashMap) {
                                Interstitial.access$400(this.bM.bL);
                            }

                            public final void error(String string2) {
                                Interstitial.access$400(this.bM.bL);
                            }
                        });
                        return;
                    }
                    throw new java.io.IOException();
                }
            }).start();
            return;
        }
        throw new IllegalArgumentException("Placement ID cannot be empty");
    }

    public void setAutoPlay(boolean bl) {
        this.setAutoPlay = true;
        this.autoPlay = bl;
    }

    @Deprecated
    public void setBackButtonCanClose(boolean bl) {
        this.setCanClose = true;
        this.canClose = bl;
    }

    public void setButtonColor(String string2) {
        if (string2 != null && !string2.equals((Object)"")) {
            if (!string2.startsWith("#")) {
                StringBuilder stringBuilder = new StringBuilder("#");
                stringBuilder.append(string2);
                string2 = stringBuilder.toString();
            }
            try {
                Color.parseColor((String)string2);
                this.buttonColor = string2;
                return;
            }
            catch (Throwable throwable) {
                throw new IllegalArgumentException("Unknown color");
            }
        }
        this.buttonColor = "";
    }

    public void setCreativeType(String string2) {
        if (string2 != null) {
            if (!(string2.equals((Object)TYPE_MANAGED) || string2.equals((Object)TYPE_STATIC) || string2.equals((Object)TYPE_VIDEO))) {
                throw new IllegalArgumentException("Wrong creative type");
            }
            this.creativeType = string2;
            return;
        }
        throw new IllegalArgumentException("Wrong creative type");
    }

    public void setLanguage(String string2) {
        this.language = string2;
    }

    @Override
    public void setOnAdErrorCallback(OnAdError onAdError) {
        this.userOnAdError = onAdError;
    }

    @Deprecated
    @Override
    public void setOrientation(String string2) {
    }

    public void setParams(String string2, String string3) {
        this.getConfig().s(string2, string3);
    }

    public void setSkipText(String string2) {
        if (string2 == null) {
            string2 = "";
        }
        this.skipText = string2;
    }

    @Override
    public void showAd() {
        if (!this.getPlacementID().equals((Object)"")) {
            if (!f.a(this.context, "android.permission.INTERNET")) {
                if (this.getOnAdErrorCallback() != null) {
                    this.getOnAdErrorCallback().adError("Connection Error");
                }
                return;
            }
            int n2 = f.aa(this.getConfig().get("min_internet_connection"));
            int n3 = f.aa(f.o(this.context));
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
            currentAd = this;
            if (a.G().d(this)) {
                this.startInterstitialActivity();
                return;
            }
            a.G().a(this.context, this, this.getPlacementID(), new d.a(){

                @Override
                public final <T> void a(T t2) {
                    Interstitial.this.startInterstitialActivity();
                }

                @Override
                public final void error(String string2) {
                    new Handler(Looper.getMainLooper()).post(new Runnable(this, string2){
                        final /* synthetic */ String bN;
                        final /* synthetic */ 4 bO;
                        {
                            this.bO = var1_1;
                            this.bN = string2;
                        }

                        public final void run() {
                            if (this.bO.Interstitial.this.getOnAdErrorCallback() != null) {
                                this.bO.Interstitial.this.getOnAdErrorCallback().adError(this.bN);
                            }
                        }
                    });
                }
            }, this.getCreative());
            return;
        }
        throw new IllegalArgumentException("Placement ID cannot be empty");
    }

}

