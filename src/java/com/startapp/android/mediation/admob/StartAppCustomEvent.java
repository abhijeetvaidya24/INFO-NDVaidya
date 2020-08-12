/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.location.Location
 *  android.text.TextUtils
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 *  com.google.ads.AdRequest
 *  com.google.ads.AdRequest$Gender
 *  com.google.ads.AdSize
 *  com.google.ads.mediation.MediationAdRequest
 *  com.google.ads.mediation.customevent.CustomEventBanner
 *  com.google.ads.mediation.customevent.CustomEventBannerListener
 *  com.google.ads.mediation.customevent.CustomEventInterstitial
 *  com.google.ads.mediation.customevent.CustomEventInterstitialListener
 *  com.startapp.android.publish.ads.banner.Mrec
 *  java.lang.CharSequence
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Set
 */
package com.startapp.android.mediation.admob;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.mediation.MediationAdRequest;
import com.google.ads.mediation.customevent.CustomEventBanner;
import com.google.ads.mediation.customevent.CustomEventBannerListener;
import com.google.ads.mediation.customevent.CustomEventInterstitial;
import com.google.ads.mediation.customevent.CustomEventInterstitialListener;
import com.startapp.android.mediation.admob.StartAppBannerExtras;
import com.startapp.android.mediation.admob.StartAppCustomEvent;
import com.startapp.android.mediation.admob.StartAppInterstitialExtras;
import com.startapp.android.publish.ads.banner.Banner;
import com.startapp.android.publish.ads.banner.BannerListener;
import com.startapp.android.publish.ads.banner.Mrec;
import com.startapp.android.publish.ads.banner.banner3d.Banner3D;
import com.startapp.android.publish.ads.banner.bannerstandard.BannerStandard;
import com.startapp.android.publish.adsCommon.SDKAdPreferences;
import com.startapp.android.publish.adsCommon.StartAppAd;
import com.startapp.android.publish.adsCommon.adListeners.AdDisplayListener;
import com.startapp.android.publish.adsCommon.adListeners.AdEventListener;
import com.startapp.android.publish.common.model.AdPreferences;
import java.util.Set;

public class StartAppCustomEvent
implements CustomEventBanner,
CustomEventInterstitial {
    private StartAppAd ad;
    private CustomEventInterstitialListener interstitialListener;

    static /* synthetic */ CustomEventInterstitialListener access$000(StartAppCustomEvent startAppCustomEvent) {
        return startAppCustomEvent.interstitialListener;
    }

    private AdPreferences extractAdPrefs(Activity activity, MediationAdRequest mediationAdRequest, Object object) {
        AdPreferences adPreferences = new AdPreferences();
        this.setGender(adPreferences, mediationAdRequest);
        this.setAge(adPreferences, mediationAdRequest);
        this.setKeywords(adPreferences, mediationAdRequest);
        this.setLocation(adPreferences, mediationAdRequest);
        return adPreferences;
    }

    private StartAppAd.AdMode getAdMode(String string, Object object) {
        StartAppAd.AdMode adMode;
        if (string != null) {
            if (string.equalsIgnoreCase("AdMode.FULLPAGE")) {
                return StartAppAd.AdMode.FULLPAGE;
            }
            if (string.equalsIgnoreCase("AdMode.OVERLAY")) {
                return StartAppAd.AdMode.OVERLAY;
            }
            if (string.equalsIgnoreCase("AdMode.OFFERWALL")) {
                return StartAppAd.AdMode.OFFERWALL;
            }
            if (string.equalsIgnoreCase("AdMode.AUTOMATIC")) {
                return StartAppAd.AdMode.AUTOMATIC;
            }
        }
        if (object instanceof StartAppInterstitialExtras && (adMode = ((StartAppInterstitialExtras)object).getAdMode()) != null) {
            return adMode;
        }
        return StartAppAd.AdMode.AUTOMATIC;
    }

    /*
     * Exception decompiling
     */
    private String getAdTag(String var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl17.1 : ACONST_NULL : trying to set 1 previously set to 0
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
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

    private void setAge(AdPreferences adPreferences, MediationAdRequest mediationAdRequest) {
        if (mediationAdRequest.getAgeInYears() != null) {
            adPreferences.setAge(mediationAdRequest.getAgeInYears());
        }
    }

    private void setGender(AdPreferences adPreferences, MediationAdRequest mediationAdRequest) {
        if (mediationAdRequest.getGender() != null) {
            if (mediationAdRequest.getGender() == AdRequest.Gender.MALE) {
                adPreferences.setGender(SDKAdPreferences.Gender.MALE);
                return;
            }
            if (mediationAdRequest.getGender() == AdRequest.Gender.FEMALE) {
                adPreferences.setGender(SDKAdPreferences.Gender.FEMALE);
            }
        }
    }

    private void setKeywords(AdPreferences adPreferences, MediationAdRequest mediationAdRequest) {
        if (mediationAdRequest.getKeywords() != null) {
            StringBuilder stringBuilder = new StringBuilder();
            for (String string : mediationAdRequest.getKeywords()) {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(string);
                stringBuilder2.append(",");
                stringBuilder.append(stringBuilder2.toString());
            }
            adPreferences.setKeywords(stringBuilder.substring(0, -1 + stringBuilder.length()));
        }
    }

    private void setLocation(AdPreferences adPreferences, MediationAdRequest mediationAdRequest) {
        if (mediationAdRequest.getLocation() != null) {
            adPreferences.setLongitude(mediationAdRequest.getLocation().getLongitude());
            adPreferences.setLatitude(mediationAdRequest.getLocation().getLatitude());
        }
    }

    public void destroy() {
    }

    public View getBanner(String string, Object object, Activity activity, AdPreferences adPreferences, BannerListener bannerListener, AdSize adSize) {
        String string2;
        Object object2 = adSize.getWidth() == AdSize.IAB_MRECT.getWidth() && adSize.getHeight() == AdSize.IAB_MRECT.getHeight() ? new Mrec(activity, adPreferences, bannerListener) : null;
        if (object2 == null && string != null) {
            if (string.equalsIgnoreCase("BannerMode.STANDARD")) {
                object2 = new BannerStandard(activity, adPreferences, bannerListener);
            } else if (string.equalsIgnoreCase("BannerMode.THREED")) {
                object2 = new Banner3D(activity, adPreferences, bannerListener);
            } else if (string.equalsIgnoreCase("BannerMode.AUTO")) {
                object2 = new Banner(activity, adPreferences, bannerListener);
            }
        }
        if (object2 == null && object instanceof StartAppBannerExtras) {
            int n2 = 4.$SwitchMap$com$startapp$android$mediation$admob$StartAppBannerExtras$BannerMode[((StartAppBannerExtras)object).getBannerMode().ordinal()];
            if (n2 != 1) {
                if (n2 != 2) {
                    if (n2 == 3) {
                        object2 = new Banner3D(activity, adPreferences, bannerListener);
                    }
                } else {
                    object2 = new BannerStandard(activity, adPreferences, bannerListener);
                }
            } else {
                object2 = new Banner(activity, adPreferences, bannerListener);
            }
        }
        if (object2 == null) {
            object2 = new Banner(activity, adPreferences, bannerListener);
        }
        if (!TextUtils.isEmpty((CharSequence)(string2 = this.getAdTag(string)))) {
            object2.setAdTag(string2);
        }
        return object2;
    }

    public void requestBannerAd(CustomEventBannerListener customEventBannerListener, Activity activity, String string, String string2, AdSize adSize, MediationAdRequest mediationAdRequest, Object object) {
        AdPreferences adPreferences = this.extractAdPrefs(activity, mediationAdRequest, object);
        FrameLayout frameLayout = new FrameLayout((Context)activity);
        frameLayout.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
        frameLayout.addView(this.getBanner(string2, object, activity, adPreferences, new BannerListener(this, customEventBannerListener, frameLayout){
            final /* synthetic */ StartAppCustomEvent this$0;
            final /* synthetic */ FrameLayout val$frameLayout;
            final /* synthetic */ CustomEventBannerListener val$listener;
            {
                this.this$0 = startAppCustomEvent;
                this.val$listener = customEventBannerListener;
                this.val$frameLayout = frameLayout;
            }

            public void onClick(View view) {
                this.val$listener.onClick();
                this.val$listener.onPresentScreen();
                this.val$listener.onLeaveApplication();
            }

            public void onFailedToReceiveAd(View view) {
                this.val$listener.onFailedToReceiveAd();
            }

            public void onReceiveAd(View view) {
                this.val$listener.onReceivedAd((View)this.val$frameLayout);
            }
        }, adSize), (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(adSize.getWidthInPixels((Context)activity), adSize.getHeightInPixels((Context)activity), 17));
    }

    public void requestInterstitialAd(CustomEventInterstitialListener customEventInterstitialListener, Activity activity, String string, String string2, MediationAdRequest mediationAdRequest, Object object) {
        this.interstitialListener = customEventInterstitialListener;
        this.ad = new StartAppAd((Context)activity);
        this.ad.loadAd(this.getAdMode(string2, object), this.extractAdPrefs(activity, mediationAdRequest, object), new AdEventListener(this, customEventInterstitialListener){
            final /* synthetic */ StartAppCustomEvent this$0;
            final /* synthetic */ CustomEventInterstitialListener val$listener;
            {
                this.this$0 = startAppCustomEvent;
                this.val$listener = customEventInterstitialListener;
            }

            public void onFailedToReceiveAd(com.startapp.android.publish.adsCommon.Ad ad2) {
                this.val$listener.onFailedToReceiveAd();
            }

            public void onReceiveAd(com.startapp.android.publish.adsCommon.Ad ad2) {
                this.val$listener.onReceivedAd();
            }
        });
    }

    public void showInterstitial() {
        this.ad.showAd(new AdDisplayListener(this){
            final /* synthetic */ StartAppCustomEvent this$0;
            {
                this.this$0 = startAppCustomEvent;
            }

            public void adClicked(com.startapp.android.publish.adsCommon.Ad ad2) {
                StartAppCustomEvent.access$000(this.this$0).onLeaveApplication();
            }

            public void adDisplayed(com.startapp.android.publish.adsCommon.Ad ad2) {
                StartAppCustomEvent.access$000(this.this$0).onPresentScreen();
            }

            public void adHidden(com.startapp.android.publish.adsCommon.Ad ad2) {
                StartAppCustomEvent.access$000(this.this$0).onDismissScreen();
            }

            public void adNotDisplayed(com.startapp.android.publish.adsCommon.Ad ad2) {
            }
        });
    }
}

