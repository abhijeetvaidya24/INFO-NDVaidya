/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.os.Handler
 *  java.lang.Boolean
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.startapp.android.publish.ads.nativead;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import com.startapp.android.publish.ads.nativead.NativeAdDetails;
import com.startapp.android.publish.ads.nativead.NativeAdInterface;
import com.startapp.android.publish.ads.nativead.NativeAdPreferences;
import com.startapp.android.publish.ads.nativead.StartAppNativeAd;
import com.startapp.android.publish.adsCommon.b;
import com.startapp.android.publish.adsCommon.c;
import com.startapp.android.publish.common.model.AdDetails;
import com.startapp.android.publish.common.model.AdPreferences;
import com.startapp.common.a;
import com.startapp.common.a.g;

public class NativeAdDetails
implements NativeAdInterface {
    int a;
    a b;
    private AdDetails c;
    private Bitmap d;
    private Bitmap e;
    private boolean f = false;
    private String g;

    public NativeAdDetails(AdDetails adDetails, NativeAdPreferences nativeAdPreferences, int n2, a a2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Initializiang SingleAd [");
        stringBuilder.append(n2);
        stringBuilder.append("]");
        g.a("StartAppNativeAd", 3, stringBuilder.toString());
        this.c = adDetails;
        this.a = n2;
        this.b = a2;
        if (nativeAdPreferences.isAutoBitmapDownload()) {
            new com.startapp.common.a(this.getImageUrl(), new a.a(){

                @Override
                public void a(Bitmap bitmap, int n2) {
                    NativeAdDetails.this.a(bitmap);
                    new com.startapp.common.a(NativeAdDetails.this.getSecondaryImageUrl(), new a.a(){

                        @Override
                        public void a(Bitmap bitmap, int n2) {
                            NativeAdDetails.this.b(bitmap);
                            NativeAdDetails.this.a();
                        }
                    }, n2).a();
                }

            }, n2).a();
            return;
        }
        this.a();
    }

    void a() {
        new Handler().post(new Runnable(this){
            final /* synthetic */ NativeAdDetails a;
            {
                this.a = nativeAdDetails;
            }

            public void run() {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("SingleAd [");
                stringBuilder.append(this.a.a);
                stringBuilder.append("] Loaded");
                g.a("StartAppNativeAd", 3, stringBuilder.toString());
                if (this.a.b != null) {
                    this.a.b.onNativeAdDetailsLoaded(this.a.a);
                }
            }
        });
    }

    void a(Bitmap bitmap) {
        this.d = bitmap;
    }

    protected void a(String string) {
        this.g = string;
    }

    protected AdDetails b() {
        return this.c;
    }

    void b(Bitmap bitmap) {
        this.e = bitmap;
    }

    @Override
    public StartAppNativeAd.b getCampaignAction() {
        StartAppNativeAd.b b2 = StartAppNativeAd.b.b;
        AdDetails adDetails = this.c;
        if (adDetails != null && adDetails.isCPE()) {
            b2 = StartAppNativeAd.b.a;
        }
        return b2;
    }

    @Override
    public String getCategory() {
        AdDetails adDetails = this.c;
        if (adDetails != null) {
            return adDetails.getCategory();
        }
        return "";
    }

    @Override
    public String getDescription() {
        AdDetails adDetails = this.c;
        if (adDetails != null) {
            return adDetails.getDescription();
        }
        return "";
    }

    @Override
    public Bitmap getImageBitmap() {
        return this.d;
    }

    @Override
    public String getImageUrl() {
        AdDetails adDetails = this.c;
        if (adDetails != null) {
            return adDetails.getImageUrl();
        }
        return "";
    }

    @Override
    public String getInstalls() {
        AdDetails adDetails = this.c;
        if (adDetails != null) {
            return adDetails.getInstalls();
        }
        return "";
    }

    @Override
    public String getPackacgeName() {
        AdDetails adDetails = this.c;
        if (adDetails != null) {
            return adDetails.getPackageName();
        }
        return "";
    }

    @Override
    public float getRating() {
        AdDetails adDetails = this.c;
        if (adDetails != null) {
            return adDetails.getRating();
        }
        return 5.0f;
    }

    @Override
    public Bitmap getSecondaryImageBitmap() {
        return this.e;
    }

    @Override
    public String getSecondaryImageUrl() {
        AdDetails adDetails = this.c;
        if (adDetails != null) {
            return adDetails.getSecondaryImageUrl();
        }
        return "";
    }

    @Override
    public String getTitle() {
        AdDetails adDetails = this.c;
        if (adDetails != null) {
            return adDetails.getTitle();
        }
        return "";
    }

    @Override
    public Boolean isApp() {
        Boolean bl = true;
        AdDetails adDetails = this.c;
        if (adDetails != null) {
            bl = adDetails.isApp();
        }
        return bl;
    }

    @Override
    public void sendClick(Context context) {
        if (this.c != null) {
            int n2 = 3.a[this.getCampaignAction().ordinal()];
            if (n2 != 1) {
                if (n2 != 2) {
                    return;
                }
                c.a(this.getPackacgeName(), this.c.getIntentDetails(), this.c.getClickUrl(), context, new com.startapp.android.publish.adsCommon.d.b(this.g));
                return;
            }
            boolean bl = c.a(context, AdPreferences.Placement.INAPP_NATIVE);
            if (this.c.isSmartRedirect() && !bl) {
                c.a(context, this.c.getClickUrl(), this.c.getTrackingClickUrl(), this.c.getPackageName(), new com.startapp.android.publish.adsCommon.d.b(this.g), b.a().A(), b.a().B(), this.c.isStartappBrowserEnabled(), this.c.shouldSendRedirectHops(), false);
                return;
            }
            String string = this.c.getClickUrl();
            String string2 = this.c.getTrackingClickUrl();
            com.startapp.android.publish.adsCommon.d.b b2 = new com.startapp.android.publish.adsCommon.d.b(this.g);
            boolean bl2 = this.c.isStartappBrowserEnabled() && !bl;
            c.a(context, string, string2, b2, bl2, false);
        }
    }

    @Override
    public void sendImpression(Context context) {
        if (!this.f) {
            this.f = true;
            if (this.c == null) {
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Sending Impression for [");
            stringBuilder.append(this.a);
            stringBuilder.append("]");
            g.a("StartAppNativeAd", 3, stringBuilder.toString());
            c.a(context, this.c.getTrackingUrl(), new com.startapp.android.publish.adsCommon.d.b(this.g));
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Already sent impression for [");
        stringBuilder.append(this.a);
        stringBuilder.append("]");
        g.a("StartAppNativeAd", 3, stringBuilder.toString());
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("         Title: [");
        stringBuilder.append(this.getTitle());
        stringBuilder.append("]\n");
        stringBuilder.append("         Description: [");
        stringBuilder.append(this.getDescription().substring(0, 30));
        stringBuilder.append("]...\n");
        stringBuilder.append("         Rating: [");
        stringBuilder.append(this.getRating());
        stringBuilder.append("]\n");
        stringBuilder.append("         Installs: [");
        stringBuilder.append(this.getInstalls());
        stringBuilder.append("]\n");
        stringBuilder.append("         Category: [");
        stringBuilder.append(this.getCategory());
        stringBuilder.append("]\n");
        stringBuilder.append("         PackageName: [");
        stringBuilder.append(this.getPackacgeName());
        stringBuilder.append("]\n");
        stringBuilder.append("         CampaginAction: [");
        stringBuilder.append((Object)this.getCampaignAction());
        stringBuilder.append("]\n");
        return stringBuilder.toString();
    }

}

