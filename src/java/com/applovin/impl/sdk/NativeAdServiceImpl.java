/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  com.applovin.impl.sdk.d
 *  com.applovin.impl.sdk.d.e
 *  com.applovin.impl.sdk.d.g
 *  com.applovin.impl.sdk.d.n
 *  com.applovin.impl.sdk.q
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.List
 */
package com.applovin.impl.sdk;

import android.text.TextUtils;
import com.applovin.impl.sdk.ad.NativeAdImpl;
import com.applovin.impl.sdk.ad.d;
import com.applovin.impl.sdk.ad.j;
import com.applovin.impl.sdk.b.b;
import com.applovin.impl.sdk.d.a;
import com.applovin.impl.sdk.d.e;
import com.applovin.impl.sdk.d.g;
import com.applovin.impl.sdk.d.n;
import com.applovin.impl.sdk.d.q;
import com.applovin.impl.sdk.p;
import com.applovin.impl.sdk.q;
import com.applovin.nativeAds.AppLovinNativeAd;
import com.applovin.nativeAds.AppLovinNativeAdLoadListener;
import com.applovin.nativeAds.AppLovinNativeAdPrecacheListener;
import com.applovin.nativeAds.AppLovinNativeAdService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class NativeAdServiceImpl
implements AppLovinNativeAdService {
    private final com.applovin.impl.sdk.j a;
    private final p b;

    NativeAdServiceImpl(com.applovin.impl.sdk.j j2) {
        this.a = j2;
        this.b = j2.u();
    }

    private void a(AppLovinNativeAd appLovinNativeAd, final AppLovinNativeAdPrecacheListener appLovinNativeAdPrecacheListener) {
        if (appLovinNativeAd.isVideoPrecached()) {
            appLovinNativeAdPrecacheListener.onNativeAdVideoPreceached(appLovinNativeAd);
            return;
        }
        Object[] arrobject = new NativeAdImpl[]{(NativeAdImpl)appLovinNativeAd};
        g g2 = new g(Arrays.asList((Object[])arrobject), this.a, new AppLovinNativeAdPrecacheListener(){

            @Override
            public void onNativeAdImagePrecachingFailed(AppLovinNativeAd appLovinNativeAd, int n2) {
            }

            @Override
            public void onNativeAdImagesPrecached(AppLovinNativeAd appLovinNativeAd) {
            }

            @Override
            public void onNativeAdVideoPrecachingFailed(AppLovinNativeAd appLovinNativeAd, int n2) {
                NativeAdServiceImpl.this.a(appLovinNativeAdPrecacheListener, appLovinNativeAd, n2, true);
            }

            @Override
            public void onNativeAdVideoPreceached(AppLovinNativeAd appLovinNativeAd) {
                NativeAdServiceImpl.this.a(appLovinNativeAdPrecacheListener, appLovinNativeAd, true);
            }
        });
        this.a.C().a((a)g2, q.a.g);
    }

    private void a(AppLovinNativeAdLoadListener appLovinNativeAdLoadListener, int n2) {
        if (appLovinNativeAdLoadListener != null) {
            try {
                appLovinNativeAdLoadListener.onNativeAdsFailedToLoad(n2);
                return;
            }
            catch (Exception exception) {
                this.b.c("NativeAdService", "Encountered exception whilst notifying user callback", exception);
            }
        }
    }

    private void a(AppLovinNativeAdLoadListener appLovinNativeAdLoadListener, List<AppLovinNativeAd> list) {
        if (appLovinNativeAdLoadListener != null) {
            try {
                appLovinNativeAdLoadListener.onNativeAdsLoaded(list);
                return;
            }
            catch (Exception exception) {
                this.b.c("NativeAdService", "Encountered exception whilst notifying user callback", exception);
            }
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private void a(AppLovinNativeAdPrecacheListener var1_1, AppLovinNativeAd var2_2, int var3_3, boolean var4_4) {
        if (var1_1 == null) return;
        if (!var4_4) ** GOTO lbl6
        try {
            var1_1.onNativeAdVideoPrecachingFailed(var2_2, var3_3);
            return;
lbl6: // 1 sources:
            var1_1.onNativeAdImagePrecachingFailed(var2_2, var3_3);
            return;
        }
        catch (Exception var5_5) {
            this.b.c("NativeAdService", "Encountered exception whilst notifying user callback", var5_5);
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private void a(AppLovinNativeAdPrecacheListener var1_1, AppLovinNativeAd var2_2, boolean var3_3) {
        if (var1_1 == null) return;
        if (!var3_3) ** GOTO lbl6
        try {
            var1_1.onNativeAdVideoPreceached(var2_2);
            return;
lbl6: // 1 sources:
            var1_1.onNativeAdImagesPrecached(var2_2);
            return;
        }
        catch (Exception var4_4) {
            this.b.c("NativeAdService", "Encountered exception whilst notifying user callback", var4_4);
        }
    }

    private void a(String string, int n2, final AppLovinNativeAdLoadListener appLovinNativeAdLoadListener) {
        n n3 = new n(string, n2, this.a, new AppLovinNativeAdLoadListener(){

            @Override
            public void onNativeAdsFailedToLoad(int n2) {
                NativeAdServiceImpl.this.a(appLovinNativeAdLoadListener, n2);
            }

            @Override
            public void onNativeAdsLoaded(List<AppLovinNativeAd> list) {
                NativeAdServiceImpl.this.a((List<AppLovinNativeAd>)list, appLovinNativeAdLoadListener);
            }
        });
        this.a.C().a((a)n3, q.a.a);
    }

    private void a(List<AppLovinNativeAd> list, final AppLovinNativeAdLoadListener appLovinNativeAdLoadListener) {
        int n2 = this.a.a(b.dE);
        if (n2 <= 0) {
            if (appLovinNativeAdLoadListener != null) {
                appLovinNativeAdLoadListener.onNativeAdsLoaded(list);
                return;
            }
        } else {
            List<AppLovinNativeAd> list2 = list;
            int n3 = list2.size();
            if (n3 == 0) {
                if (appLovinNativeAdLoadListener != null) {
                    appLovinNativeAdLoadListener.onNativeAdsFailedToLoad(-700);
                }
                return;
            }
            int n4 = Math.min((int)n2, (int)n3);
            final List list3 = list2.subList(0, n4);
            this.b((List<NativeAdImpl>)list3, new AppLovinNativeAdLoadListener(list2.subList(n4, n3)){
                final /* synthetic */ List c;
                {
                    this.c = list2;
                }

                @Override
                public void onNativeAdsFailedToLoad(int n2) {
                    AppLovinNativeAdLoadListener appLovinNativeAdLoadListener2 = appLovinNativeAdLoadListener;
                    if (appLovinNativeAdLoadListener2 != null) {
                        appLovinNativeAdLoadListener2.onNativeAdsFailedToLoad(n2);
                    }
                }

                @Override
                public void onNativeAdsLoaded(List<AppLovinNativeAd> list) {
                    NativeAdServiceImpl.this.c((List<NativeAdImpl>)list3, new AppLovinNativeAdLoadListener(){

                        @Override
                        public void onNativeAdsFailedToLoad(int n2) {
                            if (appLovinNativeAdLoadListener != null) {
                                appLovinNativeAdLoadListener.onNativeAdsFailedToLoad(n2);
                            }
                        }

                        @Override
                        public void onNativeAdsLoaded(List<AppLovinNativeAd> list) {
                            if (appLovinNativeAdLoadListener != null) {
                                ArrayList arrayList = new ArrayList();
                                arrayList.addAll((Collection)list3);
                                arrayList.addAll((Collection)4.this.c);
                                appLovinNativeAdLoadListener.onNativeAdsLoaded((List<AppLovinNativeAd>)arrayList);
                            }
                        }
                    });
                }

            });
        }
    }

    private void b(List<NativeAdImpl> list, final AppLovinNativeAdLoadListener appLovinNativeAdLoadListener) {
        e e2 = new e(list, this.a, new AppLovinNativeAdLoadListener(){

            @Override
            public void onNativeAdsFailedToLoad(int n2) {
                AppLovinNativeAdLoadListener appLovinNativeAdLoadListener2 = appLovinNativeAdLoadListener;
                if (appLovinNativeAdLoadListener2 != null) {
                    appLovinNativeAdLoadListener2.onNativeAdsFailedToLoad(n2);
                }
            }

            @Override
            public void onNativeAdsLoaded(List<AppLovinNativeAd> list) {
                AppLovinNativeAdLoadListener appLovinNativeAdLoadListener2 = appLovinNativeAdLoadListener;
                if (appLovinNativeAdLoadListener2 != null) {
                    appLovinNativeAdLoadListener2.onNativeAdsLoaded(list);
                }
            }
        });
        this.a.C().a((a)e2, q.a.g);
    }

    private void c(List<NativeAdImpl> list, final AppLovinNativeAdLoadListener appLovinNativeAdLoadListener) {
        g g2 = new g(list, this.a, new AppLovinNativeAdLoadListener(){

            @Override
            public void onNativeAdsFailedToLoad(int n2) {
                NativeAdServiceImpl.this.a(appLovinNativeAdLoadListener, n2);
            }

            @Override
            public void onNativeAdsLoaded(List<AppLovinNativeAd> list) {
                NativeAdServiceImpl.this.a(appLovinNativeAdLoadListener, (List<AppLovinNativeAd>)list);
            }
        });
        this.a.C().a((a)g2, q.a.g);
    }

    @Override
    public boolean hasPreloadedAdForZoneId(String string) {
        if (TextUtils.isEmpty((CharSequence)string)) {
            this.b.e("NativeAdService", "Unable to check if ad is preloaded - invalid zone id.");
            return false;
        }
        d d2 = d.a(string, this.a);
        return this.a.M().g(d2);
    }

    @Override
    public void loadNativeAds(int n2, AppLovinNativeAdLoadListener appLovinNativeAdLoadListener) {
        this.loadNativeAds(n2, null, appLovinNativeAdLoadListener);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public void loadNativeAds(int n2, String string, AppLovinNativeAdLoadListener appLovinNativeAdLoadListener) {
        if (n2 > 0) {
            this.a.a();
            if (n2 == 1) {
                d d2 = d.b(string, this.a);
                AppLovinNativeAd appLovinNativeAd = (AppLovinNativeAd)((Object)this.a.M().e(d2));
                if (appLovinNativeAd != null) {
                    this.a(appLovinNativeAdLoadListener, (List<AppLovinNativeAd>)Arrays.asList((Object[])new AppLovinNativeAd[]{appLovinNativeAd}));
                } else {
                    this.a(string, 1, appLovinNativeAdLoadListener);
                }
                if (!this.a.a(b.aR).booleanValue()) return;
                this.a.M().i(d2);
                return;
            }
            this.a(string, n2, appLovinNativeAdLoadListener);
            return;
        }
        p p2 = this.b;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Requested invalid number of native ads: ");
        stringBuilder.append(n2);
        p2.e("NativeAdService", stringBuilder.toString());
    }

    @Override
    public void loadNextAd(AppLovinNativeAdLoadListener appLovinNativeAdLoadListener) {
        this.loadNativeAds(1, appLovinNativeAdLoadListener);
    }

    @Override
    public void precacheResources(AppLovinNativeAd appLovinNativeAd, final AppLovinNativeAdPrecacheListener appLovinNativeAdPrecacheListener) {
        this.a.a();
        if (appLovinNativeAd.isImagePrecached()) {
            appLovinNativeAdPrecacheListener.onNativeAdImagesPrecached(appLovinNativeAd);
            this.a(appLovinNativeAd, appLovinNativeAdPrecacheListener);
            return;
        }
        Object[] arrobject = new NativeAdImpl[]{(NativeAdImpl)appLovinNativeAd};
        e e2 = new e(Arrays.asList((Object[])arrobject), this.a, new AppLovinNativeAdPrecacheListener(){

            @Override
            public void onNativeAdImagePrecachingFailed(AppLovinNativeAd appLovinNativeAd, int n2) {
                NativeAdServiceImpl.this.a(appLovinNativeAdPrecacheListener, appLovinNativeAd, n2, false);
            }

            @Override
            public void onNativeAdImagesPrecached(AppLovinNativeAd appLovinNativeAd) {
                NativeAdServiceImpl.this.a(appLovinNativeAdPrecacheListener, appLovinNativeAd, false);
                NativeAdServiceImpl.this.a(appLovinNativeAd, appLovinNativeAdPrecacheListener);
            }

            @Override
            public void onNativeAdVideoPrecachingFailed(AppLovinNativeAd appLovinNativeAd, int n2) {
            }

            @Override
            public void onNativeAdVideoPreceached(AppLovinNativeAd appLovinNativeAd) {
            }
        });
        this.a.C().a((a)e2, q.a.g);
    }

    @Override
    public void preloadAdForZoneId(String string) {
        if (TextUtils.isEmpty((CharSequence)string)) {
            this.b.e("NativeAdService", "Unable to preload zone for invalid zone id.");
            return;
        }
        this.a.a();
        d d2 = d.a(string, this.a);
        this.a.L().h(d2);
        this.a.L().i(d2);
    }

    public void preloadAds(d d2) {
        this.a.L().h(d2);
        int n2 = d2.g();
        if (n2 == 0 && this.a.L().b(d2)) {
            n2 = 1;
        }
        this.a.L().b(d2, n2);
    }

}

