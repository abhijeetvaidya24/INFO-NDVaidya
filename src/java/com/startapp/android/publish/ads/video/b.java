/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.startapp.android.publish.ads.video.a
 *  com.startapp.android.publish.ads.video.e
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  java.lang.Throwable
 *  java.net.URL
 *  java.util.ArrayList
 *  java.util.Set
 */
package com.startapp.android.publish.ads.video;

import android.content.Context;
import com.startapp.android.publish.ads.video.VASTJson;
import com.startapp.android.publish.ads.video.VideoAdDetails;
import com.startapp.android.publish.ads.video.b;
import com.startapp.android.publish.ads.video.c;
import com.startapp.android.publish.ads.video.c.a.a;
import com.startapp.android.publish.ads.video.c.a.c;
import com.startapp.android.publish.ads.video.c.a.d;
import com.startapp.android.publish.ads.video.c.a.e;
import com.startapp.android.publish.ads.video.g;
import com.startapp.android.publish.ads.video.h;
import com.startapp.android.publish.ads.video.tracking.ActionTrackingLink;
import com.startapp.android.publish.ads.video.tracking.VideoTrackingDetails;
import com.startapp.android.publish.ads.video.tracking.VideoTrackingLink;
import com.startapp.android.publish.ads.video.tracking.VideoTrackingParams;
import com.startapp.android.publish.adsCommon.Ad;
import com.startapp.android.publish.adsCommon.StartAppAd;
import com.startapp.android.publish.adsCommon.Utils.i;
import com.startapp.android.publish.adsCommon.adListeners.AdEventListener;
import com.startapp.android.publish.adsCommon.f.f;
import com.startapp.android.publish.adsCommon.n;
import com.startapp.android.publish.common.metaData.MetaData;
import com.startapp.android.publish.common.model.AdPreferences;
import com.startapp.android.publish.common.model.GetAdRequest;
import com.startapp.common.a.h;
import java.net.URL;
import java.util.ArrayList;
import java.util.Set;

public class b
extends com.startapp.android.publish.html.a {
    private long i = System.currentTimeMillis();
    private volatile com.startapp.android.publish.cache.c j;
    private c k;
    private int l = 0;

    public b(Context context, Ad ad2, AdPreferences adPreferences, AdEventListener adEventListener) {
        super(context, ad2, adPreferences, adEventListener, AdPreferences.Placement.INAPP_OVERLAY, true);
        c c2 = com.startapp.android.publish.adsCommon.b.a().H().r() == 0 ? new c(context) : new d(context, com.startapp.android.publish.adsCommon.b.a().H().s());
        this.k = c2;
    }

    static /* synthetic */ Ad a(b b2) {
        return b2.b;
    }

    static /* synthetic */ void a(b b2, a a2) {
        b2.a(a2);
    }

    static /* synthetic */ void a(b b2, boolean bl) {
        b2.a(bl);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private void a(a var1_1) {
        block12 : {
            var3_2 = this.b();
            var4_3 = null;
            if (var3_2 != null) {
                var5_4 = this.b().getVideoTrackingDetails();
                var4_3 = null;
                if (var5_4 != null) {
                    var4_3 = this.b().getVideoTrackingDetails().getInlineErrorTrackingUrls();
                }
            }
            if (var4_3 == null) return;
            if (var4_3.length <= 0) return;
            if (var1_1 != a.K && var1_1 != (var15_5 = a.L)) ** GOTO lbl21
            try {
                var6_6 = new ArrayList();
                var9_7 = new URL(MetaData.getInstance().getAdPlatformHost()).getHost().split("\\.")[1].toLowerCase();
                var10_8 = var4_3.length;
                var11_9 = 0;
                break block12;
            }
            catch (Exception var7_12) {
                try {
                    f.a(this.a, com.startapp.android.publish.adsCommon.f.d.b, "GetVideoEnabledService.sendVideoErrorEvent filter sa links", var7_12.getMessage(), "");
lbl21: // 3 sources:
                    do {
                        var8_13 = new com.startapp.android.publish.ads.video.a.b(var4_3, new VideoTrackingParams("", 0, 0, "1"), this.b().getVideoUrl(), 0).a("error").a(var1_1).a();
                        h.a(this.a, var8_13);
                        return;
                        break;
                    } while (true);
                }
                catch (Exception var2_14) {
                    f.a(this.a, com.startapp.android.publish.adsCommon.f.d.b, "GetVideoEnabledService.sendVideoErrorEvent", var2_14.getMessage(), "");
                }
            }
            return;
        }
        do {
            if (var11_9 < var10_8) {
                var12_10 = var4_3[var11_9];
                if (var12_10.getTrackingUrl() != null && var12_10.getTrackingUrl().toLowerCase().contains((CharSequence)var9_7)) {
                    var6_6.add((Object)var12_10);
                }
            } else {
                if (var6_6.size() <= 0) return;
                var14_11 = (VideoTrackingLink[])var6_6.toArray((Object[])new VideoTrackingLink[var6_6.size()]);
                var4_3 = var14_11;
                ** continue;
            }
            ++var11_9;
        } while (true);
    }

    private boolean a(String string, Throwable throwable, boolean bl) {
        com.startapp.android.publish.adsCommon.g g2;
        com.startapp.common.a.g.a("GetVideoEnabledService", 6, string, throwable);
        if (bl) {
            Context context = this.a;
            com.startapp.android.publish.adsCommon.f.d d2 = com.startapp.android.publish.adsCommon.f.d.b;
            String string2 = throwable != null ? throwable.getMessage() : "";
            f.a(context, d2, string, string2, "");
        }
        if ((g2 = com.startapp.android.publish.cache.a.a().a(this.j)) instanceof com.startapp.android.publish.adsCommon.e) {
            h.a a2 = new h.a();
            a2.b("text/html");
            a2.a(((com.startapp.android.publish.adsCommon.e)((Object)g2)).f());
            return super.a(a2);
        }
        this.b.setErrorMessage(this.f);
        return false;
    }

    static /* synthetic */ AdEventListener b(b b2) {
        return b2.d;
    }

    static /* synthetic */ void b(b b2, Boolean bl) {
        super.b(bl);
    }

    static /* synthetic */ void b(b b2, boolean bl) {
        b2.a(bl);
    }

    private void b(boolean bl) {
        if (this.b.getType() != Ad.AdType.REWARDED_VIDEO && this.b.getType() != Ad.AdType.VIDEO || bl) {
            AdPreferences adPreferences = this.c == null ? new AdPreferences() : new AdPreferences(this.c);
            AdPreferences adPreferences2 = adPreferences;
            Ad.AdType adType = this.b.getType() != Ad.AdType.REWARDED_VIDEO && this.b.getType() != Ad.AdType.VIDEO ? Ad.AdType.NON_VIDEO : Ad.AdType.VIDEO_NO_VAST;
            adPreferences2.setType(adType);
            AdPreferences.Placement placement = this.e;
            com.startapp.android.publish.cache.c c2 = com.startapp.android.publish.cache.a.a().a(this.a, null, placement, adPreferences2, null);
            if (bl) {
                this.j = c2;
            }
        }
    }

    private boolean b(String string) {
        return i.a(string, "@videoJson@", "@videoJson@") != null;
    }

    private boolean h() {
        return this.b() != null;
    }

    @Override
    protected GetAdRequest a() {
        return this.b((GetAdRequest)new com.startapp.android.publish.ads.video.a());
    }

    @Override
    protected void a(Boolean bl) {
        super.a(bl);
        if (bl.booleanValue() && this.h()) {
            if (com.startapp.android.publish.adsCommon.b.a().H().i()) {
                b.super.b(bl);
            }
            this.b().setVideoMuted(this.c.isVideoMuted());
            g.a a2 = new g.a(this, bl){
                final /* synthetic */ Boolean a;
                final /* synthetic */ b b;
                {
                    this.b = b2;
                    this.a = bl;
                }

                public void a(String string) {
                    if (string != null) {
                        if (!string.equals((Object)"downloadInterrupted")) {
                            b.b(this.b, this.a);
                            this.b.b().setLocalVideoPath(string);
                        }
                        b.a(this.b, (boolean)this.a);
                        return;
                    }
                    b.b(this.b, false);
                    b.b(this.b).onFailedToReceiveAd(b.a(this.b));
                    b.a(this.b, a.p);
                }
            };
            c.a a3 = new c.a(this){
                final /* synthetic */ b a;
                {
                    this.a = b2;
                }

                public void a(String string) {
                    this.a.b().setLocalVideoPath(string);
                }
            };
            com.startapp.android.publish.ads.video.d.a().a(this.a.getApplicationContext(), this.b().getVideoUrl(), a2, a3);
            return;
        }
        this.a((boolean)bl);
    }

    @Override
    protected boolean a(GetAdRequest getAdRequest) {
        if (super.a(getAdRequest)) {
            h.a a2;
            if (getAdRequest.isAdTypeVideo() && (a2 = h.a(this.a)) != h.a.a) {
                this.f = a2.a();
                return false;
            }
            return true;
        }
        return false;
    }

    @Override
    protected boolean a(Object object) {
        h.a a2 = (h.a)object;
        if (a2 != null && a2.b().toLowerCase().contains((CharSequence)"json")) {
            VASTJson vASTJson;
            if (com.startapp.android.publish.adsCommon.b.a().H().h() && !this.h.hasCampaignExclude()) {
                this.b(true);
            }
            try {
                vASTJson = com.startapp.common.c.b.a(a2.a(), VASTJson.class);
            }
            catch (Exception exception) {
                return this.a("VAST json parsing", exception, true);
            }
            if (vASTJson != null && vASTJson.getVastTag() != null) {
                com.startapp.android.publish.ads.video.c.b.b b2 = new com.startapp.android.publish.ads.video.c.b.b(com.startapp.android.publish.adsCommon.b.a().H().n(), com.startapp.android.publish.adsCommon.b.a().H().o());
                a a3 = b2.a(this.a, vASTJson.getVastTag(), this.k);
                e e2 = b2.a();
                com.startapp.android.publish.ads.video.e e3 = (com.startapp.android.publish.ads.video.e)this.b;
                boolean bl = this.b.getType() != Ad.AdType.REWARDED_VIDEO;
                e3.a(e2, bl);
                if (vASTJson.getTtlSec() != null) {
                    ((com.startapp.android.publish.ads.video.e)this.b).d(vASTJson.getTtlSec());
                }
                if (a3 == a.a) {
                    this.a(a.L);
                    a2.a(vASTJson.getAdmTag());
                    a2.b("text/html");
                    return super.a(a2);
                }
                this.a(a3);
                if (vASTJson.getCampaignId() != null) {
                    this.g.add((Object)vASTJson.getCampaignId());
                }
                this.l = 1 + this.l;
                ((com.startapp.android.publish.ads.video.e)this.b).e();
                if (System.currentTimeMillis() - this.i >= (long)com.startapp.android.publish.adsCommon.b.a().H().p()) {
                    return this.a("VAST retry timeout", null, false);
                }
                if (this.l > com.startapp.android.publish.adsCommon.b.a().H().q()) {
                    return this.a("VAST too many excludes", null, false);
                }
                return this.d();
            }
            return this.a("no VAST wrapper in json", null, true);
        }
        String string = null;
        if (a2 != null) {
            string = a2.a();
        }
        if (com.startapp.android.publish.adsCommon.b.a().H().h() && this.b(string)) {
            this.b(false);
        }
        return super.a(object);
    }

    VideoAdDetails b() {
        return ((com.startapp.android.publish.ads.video.e)this.b).d();
    }

    @Override
    protected void b(Boolean bl) {
        if (!this.h()) {
            super.b(bl);
        }
    }
}

