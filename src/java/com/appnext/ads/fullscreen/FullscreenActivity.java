/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Fragment
 *  android.app.FragmentManager
 *  android.app.FragmentTransaction
 *  android.content.Context
 *  android.content.Intent
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  android.graphics.drawable.Drawable
 *  android.net.Uri
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Handler
 *  android.util.DisplayMetrics
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.Window
 *  android.widget.RelativeLayout
 *  com.appnext.ads.fullscreen.FullScreenVideo
 *  com.appnext.ads.fullscreen.FullscreenAd
 *  com.appnext.ads.fullscreen.RewardedVideo
 *  com.appnext.core.AppnextAd
 *  java.io.File
 *  java.io.Serializable
 *  java.lang.Boolean
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Thread
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.Collections
 *  java.util.HashMap
 *  java.util.Locale
 *  java.util.Random
 */
package com.appnext.ads.fullscreen;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.RelativeLayout;
import com.appnext.R;
import com.appnext.ads.fullscreen.FullScreenVideo;
import com.appnext.ads.fullscreen.FullscreenActivity;
import com.appnext.ads.fullscreen.FullscreenAd;
import com.appnext.ads.fullscreen.RewardedVideo;
import com.appnext.ads.fullscreen.Video;
import com.appnext.ads.fullscreen.b;
import com.appnext.ads.fullscreen.c;
import com.appnext.ads.fullscreen.d;
import com.appnext.ads.fullscreen.e;
import com.appnext.ads.fullscreen.f;
import com.appnext.ads.fullscreen.g;
import com.appnext.ads.fullscreen.h;
import com.appnext.ads.fullscreen.i;
import com.appnext.ads.fullscreen.j;
import com.appnext.core.Ad;
import com.appnext.core.AppnextActivity;
import com.appnext.core.AppnextAd;
import com.appnext.core.callbacks.OnAdClicked;
import com.appnext.core.callbacks.OnAdClosed;
import com.appnext.core.callbacks.OnAdError;
import com.appnext.core.callbacks.OnAdOpened;
import com.appnext.core.callbacks.OnVideoEnded;
import com.appnext.core.e;
import com.appnext.core.p;
import com.appnext.core.q;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Random;

public class FullscreenActivity
extends AppnextActivity
implements h,
i,
j,
e.a {
    private p aB;
    private boolean aC = true;
    private AppnextAd aD;
    private AppnextAd aE;
    com.appnext.ads.b aF;
    private HashMap<String, Integer> aG;
    private Video aH;
    Runnable aI = new Runnable(this){
        final /* synthetic */ FullscreenActivity aK;
        {
            this.aK = fullscreenActivity;
        }

        public final void run() {
            if (FullscreenActivity.b(this.aK) != null) {
                FullscreenActivity.d(this.aK).e(FullscreenActivity.c(this.aK));
            }
            this.aK.report("impression_event", "S2");
        }
    };
    Runnable aJ = new Runnable(this){
        final /* synthetic */ FullscreenActivity aK;
        {
            this.aK = fullscreenActivity;
        }

        public final void run() {
            FullscreenActivity fullscreenActivity = this.aK;
            fullscreenActivity.a(FullscreenActivity.c(fullscreenActivity), null);
            this.aK.report("vta_event", "S2");
        }
    };
    private ArrayList<AppnextAd> ads;
    private boolean finished = false;
    private Handler mHandler;
    private int state = 0;
    private int type;

    private Uri a() {
        String string;
        String string2 = this.d().getVideoLength();
        String string3 = b.getVideoUrl(this.aD, string2);
        String string4 = b.c(string3);
        if (Video.getCacheVideo()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.getFilesDir().getAbsolutePath());
            stringBuilder.append("/data/appnext/videos/");
            string = stringBuilder.toString();
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.getFilesDir().getAbsolutePath());
            stringBuilder.append("/data/appnext/videos/");
            stringBuilder.append("tmp/vid");
            stringBuilder.append(this.d().rnd);
            stringBuilder.append("/");
            string = stringBuilder.toString();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append(string4);
        File file = new File(stringBuilder.toString());
        if (file.exists()) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(string);
            stringBuilder2.append(string4);
            Uri uri = Uri.parse((String)stringBuilder2.toString());
            new StringBuilder("playing video ").append(uri.getPath());
            return uri;
        }
        Uri uri = Uri.parse((String)string3);
        new StringBuilder("playing video from web: ").append(string3);
        new StringBuilder("file not found: ").append(file.getAbsolutePath());
        return uri;
    }

    private void a(AppnextAd appnextAd) {
        this.b(appnextAd, this);
    }

    protected static boolean a(String string, String string2) {
        return com.appnext.core.j.bh().o(string, string2);
    }

    static /* synthetic */ q b(FullscreenActivity fullscreenActivity) {
        return fullscreenActivity.userAction;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void b(String string, String string2) {
        try {
            String string3 = this.d().getTID();
            String string4 = this.d().getVID();
            String string5 = this.d().getAUID();
            String string6 = this.placementID;
            String string7 = this.d().getSessionId();
            AppnextAd appnextAd = this.aD;
            String string8 = appnextAd != null ? this.aD.getBannerID() : "";
            String string9 = this.aD != null ? this.aD.getCampaignID() : "";
            com.appnext.core.f.a(string3, string4, string5, string6, string7, string, string2, string8, string9);
            return;
        }
        catch (Throwable throwable) {}
    }

    private boolean b() {
        return this.d().isBackButtonCanClose();
    }

    private static boolean b(AppnextAd appnextAd) {
        return !appnextAd.getVideoUrlHigh().equals((Object)"") || !appnextAd.getVideoUrlHigh30Sec().equals((Object)"");
        {
        }
    }

    static /* synthetic */ AppnextAd c(FullscreenActivity fullscreenActivity) {
        return fullscreenActivity.aD;
    }

    private static void c() {
    }

    private Video d() {
        if (Video.currentAd != null) {
            return Video.currentAd;
        }
        return this.aH;
    }

    static /* synthetic */ q d(FullscreenActivity fullscreenActivity) {
        return fullscreenActivity.userAction;
    }

    static /* synthetic */ Video e(FullscreenActivity fullscreenActivity) {
        return fullscreenActivity.d();
    }

    static /* synthetic */ String f(FullscreenActivity fullscreenActivity) {
        return fullscreenActivity.placementID;
    }

    private void onClose() {
        try {
            b.j().a(this.aD.getBannerID(), (Ad)this.d());
            if (this.d() != null && this.d().getOnAdClosedCallback() != null) {
                this.d().getOnAdClosedCallback().onAdClosed();
            }
            Video.currentAd = null;
        }
        catch (Throwable throwable) {}
    }

    private void report(String string) {
        Resources resources = this.getResources();
        StringBuilder stringBuilder = new StringBuilder("S");
        stringBuilder.append(1 + this.state);
        this.b(string, resources.getResourceEntryName(this.getTemplate(stringBuilder.toString())));
    }

    protected final AppnextAd a(ArrayList<AppnextAd> arrayList, String string, String string2) {
        for (AppnextAd appnextAd : arrayList) {
            if (!FullscreenActivity.b(appnextAd) || FullscreenActivity.a(appnextAd.getBannerID(), string) || appnextAd.getBannerID().equals((Object)string2)) continue;
            return appnextAd;
        }
        com.appnext.core.j.bh().ac(string);
        for (AppnextAd appnextAd : arrayList) {
            if (!FullscreenActivity.b(appnextAd) || FullscreenActivity.a(appnextAd.getBannerID(), string)) continue;
            return appnextAd;
        }
        return null;
    }

    @Override
    protected final void a(AppnextAd appnextAd, e.a a2) {
        super.a(appnextAd, new e.a(){

            @Override
            public final void error(String string) {
            }

            @Override
            public final void onMarket(String string) {
            }
        });
    }

    @Override
    protected final void b(AppnextAd appnextAd, e.a a2) {
        if (appnextAd == null) {
            return;
        }
        this.aE = appnextAd;
        if (this.d().getOnAdClickedCallback() != null) {
            this.d().getOnAdClickedCallback().adClicked();
        }
        if (!this.finished && this.d() instanceof RewardedVideo) {
            return;
        }
        super.b(appnextAd, a2);
    }

    @Override
    public void closeClicked() {
        if (this.state == 1 && !this.isRewarded() && Integer.parseInt((String)this.getConfig().get("clickType_a")) > new Random(System.nanoTime()).nextInt(100)) {
            this.installClicked(this.getSelectedAd());
            return;
        }
        this.onClose();
        this.finish();
    }

    @Override
    public long closeDelay() {
        if (this.d() instanceof FullScreenVideo) {
            return ((FullScreenVideo)this.d()).getCloseDelay();
        }
        return 0L;
    }

    @Override
    public void error(String string) {
        this.aY();
        this.report("error_resolve_timeout");
    }

    @Override
    public int getCaptionTextTime() {
        return this.d().getRollCaptionTime();
    }

    @Override
    protected final p getConfig() {
        if (this.aB == null) {
            this.aB = this.type == 1 ? c.m() : f.q();
        }
        return this.aB;
    }

    @Override
    public p getConfigManager() {
        return this.getConfig();
    }

    @Override
    public String getCtaText() {
        String string = new FullscreenAd(this.aD).getButtonText();
        AppnextAd appnextAd = this.aD;
        String string2 = "existing";
        if (appnextAd != null && string.equals((Object)"")) {
            if (this.isInstalled()) {
                return com.appnext.core.a.b.bn().b(this.aH.getLanguage(), string2, "Open");
            }
            return com.appnext.core.a.b.bn().b(this.aH.getLanguage(), "new", "Install");
        }
        com.appnext.core.a.b b2 = com.appnext.core.a.b.bn();
        String string3 = this.aH.getLanguage();
        if (!this.isInstalled()) {
            string2 = "new";
        }
        return b2.b(string3, string2, string);
    }

    @Override
    public String getLanguage() {
        return this.aH.getLanguage();
    }

    @Override
    public boolean getMute() {
        return this.d().getMute();
    }

    @Override
    public ArrayList<AppnextAd> getPostRollAds() {
        return this.ads;
    }

    @Override
    public ArrayList<AppnextAd> getPreRollAds() {
        if (this.ads == null) {
            this.ads = b.j().f(this.d());
        }
        ArrayList arrayList = new ArrayList();
        AppnextAd appnextAd = this.a(this.ads, this.placementID, "");
        arrayList.add((Object)appnextAd);
        AppnextAd appnextAd2 = this.a(this.ads, this.placementID, appnextAd.getBannerID());
        if (appnextAd2 != null && !appnextAd2.getBannerID().equals((Object)((AppnextAd)arrayList.get(0)).getBannerID())) {
            arrayList.add((Object)appnextAd2);
        }
        return arrayList;
    }

    @Override
    public AppnextAd getSelectedAd() {
        return this.aD;
    }

    @Override
    public Uri getSelectedVideoUri() {
        String string;
        String string2 = this.d().getVideoLength();
        String string3 = b.getVideoUrl(this.aD, string2);
        String string4 = b.c(string3);
        if (Video.getCacheVideo()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.getFilesDir().getAbsolutePath());
            stringBuilder.append("/data/appnext/videos/");
            string = stringBuilder.toString();
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.getFilesDir().getAbsolutePath());
            stringBuilder.append("/data/appnext/videos/");
            stringBuilder.append("tmp/vid");
            stringBuilder.append(this.d().rnd);
            stringBuilder.append("/");
            string = stringBuilder.toString();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append(string4);
        File file = new File(stringBuilder.toString());
        if (file.exists()) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(string);
            stringBuilder2.append(string4);
            Uri uri = Uri.parse((String)stringBuilder2.toString());
            new StringBuilder("playing video ").append(uri.getPath());
            return uri;
        }
        Uri uri = Uri.parse((String)string3);
        new StringBuilder("playing video from web: ").append(string3);
        new StringBuilder("file not found: ").append(file.getAbsolutePath());
        return uri;
    }

    @Override
    public int getTemplate(String string) {
        if (this.aG == null) {
            this.aG = new HashMap();
        }
        if (!this.aG.containsKey((Object)string)) {
            String string2 = com.appnext.ads.c.a(this.getConfig().get(string));
            Resources resources = this.getResources();
            StringBuilder stringBuilder = new StringBuilder("apnxt_");
            stringBuilder.append(string2);
            int n2 = resources.getIdentifier(stringBuilder.toString(), "layout", this.getPackageName());
            if (n2 == 0) {
                Resources resources2 = this.getResources();
                StringBuilder stringBuilder2 = new StringBuilder("apnxt_");
                stringBuilder2.append(string.toLowerCase());
                stringBuilder2.append("t1");
                n2 = resources2.getIdentifier(stringBuilder2.toString(), "layout", this.getPackageName());
            }
            this.aG.put((Object)string, (Object)n2);
        }
        return (Integer)this.aG.get((Object)string);
    }

    @Override
    public void installClicked(AppnextAd appnextAd) {
        if (this.state == 1 && !this.isRewarded()) {
            this.a((ViewGroup)this.go, this.getResources().getDrawable(R.drawable.apnxt_loader));
        }
        this.b(appnextAd, this);
    }

    @Override
    public boolean isInstalled() {
        try {
            boolean bl = com.appnext.core.f.c((Context)this, this.aD.getAdPackage());
            return bl;
        }
        catch (Throwable throwable) {
            return false;
        }
    }

    @Override
    public boolean isRewarded() {
        return this.d() instanceof RewardedVideo;
    }

    public void onBackPressed() {
        if (this.d().isBackButtonCanClose()) {
            this.onClose();
            super.onBackPressed();
        }
    }

    @Override
    protected void onCreate(Bundle bundle) {
        if (bundle != null) {
            this.aG = (HashMap)bundle.getSerializable("templates");
            this.state = bundle.getInt("state");
        }
        if (Build.VERSION.SDK_INT >= 17) {
            Configuration configuration = this.getResources().getConfiguration();
            configuration.setLayoutDirection(new Locale("en"));
            this.getResources().updateConfiguration(configuration, this.getResources().getDisplayMetrics());
        }
        super.onCreate(bundle);
        if (Video.currentAd == null) {
            this.onError("No Ads");
            this.finish();
            return;
        }
        this.aH = Video.currentAd instanceof RewardedVideo ? new RewardedVideo((Context)this, (RewardedVideo)Video.currentAd) : new FullScreenVideo((Context)this, (FullScreenVideo)Video.currentAd);
        String string = this.d().getOrientation();
        int n2 = -1;
        switch (string.hashCode()) {
            default: {
                break;
            }
            case 2129065206: {
                if (!string.equals((Object)"not_set")) break;
                n2 = 0;
                break;
            }
            case 1673671211: {
                if (!string.equals((Object)"automatic")) break;
                n2 = 1;
                break;
            }
            case 1430647483: {
                if (!string.equals((Object)"landscape")) break;
                n2 = 2;
                break;
            }
            case 729267099: {
                if (!string.equals((Object)"portrait")) break;
                n2 = 3;
            }
        }
        if (n2 != 0 && n2 != 1) {
            if (n2 != 2) {
                if (n2 == 3) {
                    this.setRequestedOrientation(7);
                }
            } else {
                this.setRequestedOrientation(6);
            }
        } else if (this.getResources().getConfiguration().orientation == 2) {
            this.setRequestedOrientation(6);
        } else {
            this.setRequestedOrientation(7);
        }
        this.mHandler = new Handler();
        this.placementID = this.getIntent().getExtras().getString("id");
        this.type = this.getIntent().getExtras().getInt("type");
        this.aB = this.type == 1 ? c.m() : f.q();
        this.aC = Boolean.parseBoolean((String)this.aB.get("can_close"));
        if (this.d() instanceof FullScreenVideo) {
            this.aC = ((FullScreenVideo)this.d()).isBackButtonCanClose();
        }
        String string2 = "";
        if (bundle == null) {
            this.ads = b.j().f(this.d());
            ArrayList<AppnextAd> arrayList = this.ads;
            if (arrayList == null) {
                this.onError("No Ads");
                this.finish();
                return;
            }
            this.aD = this.a(arrayList, this.placementID, string2);
        } else {
            this.ads = (ArrayList)bundle.getSerializable("ads");
            this.aD = (AppnextAd)bundle.getSerializable("currentAd");
        }
        if (this.aD == null) {
            this.onError("No Ads");
            this.finish();
            return;
        }
        this.setContentView(R.layout.apnxt_video_activity);
        if (bundle == null) {
            Fragment fragment;
            Bundle bundle2 = new Bundle();
            if (this.d() instanceof RewardedVideo) {
                string2 = ((RewardedVideo)this.d()).getMode();
            }
            if (string2.equals((Object)"default")) {
                string2 = this.getConfig().get("default_mode");
            }
            if (this.type == 2 && string2.equals((Object)"multi")) {
                fragment = new e();
                bundle2.putInt("time", ((RewardedVideo)this.d()).getMultiTimerLength());
                this.report("multi");
            } else {
                if (this.type == 2) {
                    this.report("normal");
                }
                fragment = new g();
                bundle2.putBoolean("showCta", this.d().isShowCta());
                this.state = 1;
            }
            fragment.setArguments(bundle2);
            FragmentTransaction fragmentTransaction = this.getFragmentManager().beginTransaction();
            fragmentTransaction.add(R.id.ll, fragment, "fragment");
            try {
                fragmentTransaction.commit();
            }
            catch (Exception exception) {
                this.finish();
                return;
            }
        } else {
            this.finished = bundle.getBoolean("finished", true);
        }
        this.go = (RelativeLayout)this.findViewById(R.id.ll);
        this.userAction = new q((Context)this, new q.a(){

            @Override
            public final Ad e() {
                return Video.currentAd;
            }

            @Override
            public final AppnextAd f() {
                return FullscreenActivity.this.aE;
            }

            @Override
            public final p g() {
                return FullscreenActivity.this.getConfig();
            }

            @Override
            public final void report(String string) {
                FullscreenActivity.this.report(string);
            }
        });
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        try {
            var1_1 = new StringBuilder();
            var1_1.append(this.getFilesDir().getAbsolutePath());
            var1_1.append("/data/appnext/videos/");
            var1_1.append("tmp/vid");
            var1_1.append(this.d().rnd);
            var1_1.append("/");
            com.appnext.core.f.a(new File(var1_1.toString()));
        }
        catch (Throwable v0) {}
        try {
            if (this.mHandler != null) {
                this.mHandler.removeCallbacksAndMessages(null);
            }
            this.mHandler = null;
            this.aE = null;
            this.aD = null;
            ** GOTO lbl-1000
        }
        catch (Throwable v1) {
            try lbl-1000: // 2 sources:
            {
                if (this.aF != null) {
                    this.aF.a((Context)this);
                }
                this.aF = null;
                return;
            }
            catch (Throwable v2) {}
        }
    }

    @Override
    protected final void onError(String string) {
        if (this.d() != null && this.d().getOnAdErrorCallback() != null) {
            this.d().getOnAdErrorCallback().adError(string);
        }
    }

    @Override
    public void onMarket(String string) {
        this.aY();
        this.finished = true;
        Collections.shuffle(this.ads, (Random)new Random(System.nanoTime()));
        this.ads.remove((Object)this.aD);
        this.ads.add(0, (Object)this.aD);
        d d2 = new d();
        this.state = 2;
        FragmentTransaction fragmentTransaction = this.getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.ll, (Fragment)d2, "fragment");
        try {
            fragmentTransaction.commit();
            return;
        }
        catch (Exception exception) {
            this.finish();
            return;
        }
    }

    protected void onPause() {
        super.onPause();
        this.mHandler.removeCallbacks(this.aI);
        this.mHandler.removeCallbacks(this.aJ);
    }

    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.finished = bundle.getBoolean("finished", true);
        this.type = bundle.getInt("type");
        this.aG = (HashMap)bundle.getSerializable("templates");
    }

    protected void onResume() {
        super.onResume();
        int n2 = 2 | this.getWindow().getDecorView().getSystemUiVisibility();
        if (Build.VERSION.SDK_INT >= 16) {
            n2 |= 4;
        }
        if (Build.VERSION.SDK_INT >= 18) {
            n2 |= 4096;
        }
        this.getWindow().getDecorView().setSystemUiVisibility(n2);
    }

    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean("finished", this.finished);
        bundle.putInt("type", this.type);
        bundle.putSerializable("templates", this.aG);
        bundle.putSerializable("ads", this.ads);
        bundle.putInt("state", this.state);
        bundle.putSerializable("currentAd", (Serializable)this.aD);
        super.onSaveInstanceState(bundle);
    }

    @Override
    public void privacyClicked() {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse((String)com.appnext.core.f.g(this.aD)));
            intent.setFlags(268435456);
            this.startActivity(intent);
        }
        catch (Throwable throwable) {}
    }

    @Override
    public void report(String string, String string2) {
        this.b(string, this.getResources().getResourceEntryName(this.getTemplate(string2)));
    }

    @Override
    public boolean showClose() {
        return this.d() instanceof FullScreenVideo && ((FullScreenVideo)this.d()).isShowClose();
    }

    @Override
    public void videoEnded() {
        block4 : {
            AppnextAd appnextAd;
            this.state = 2;
            this.finished = true;
            if (this.d() != null && this.d().getOnVideoEndedCallback() != null) {
                this.d().getOnVideoEndedCallback().videoEnded();
            }
            new Thread(new Runnable(this){
                final /* synthetic */ FullscreenActivity aK;
                {
                    this.aK = fullscreenActivity;
                }

                /*
                 * Exception decompiling
                 */
                public final void run(}
        }
        java.lang.IllegalStateException: Parameters not created
        
        