/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.Pair
 *  java.lang.Object
 *  java.lang.String
 */
package com.startapp.android.publish.ads.video;

import android.content.Context;
import android.util.Pair;
import com.startapp.android.publish.ads.video.h;
import com.startapp.android.publish.adsCommon.Ad;
import com.startapp.android.publish.adsCommon.Utils.d;
import com.startapp.android.publish.adsCommon.Utils.e;
import com.startapp.android.publish.adsCommon.Utils.i;
import com.startapp.android.publish.common.model.AdPreferences;
import com.startapp.android.publish.common.model.GetAdRequest;

public class a
extends GetAdRequest {
    private GetAdRequest.VideoRequestType a;
    private GetAdRequest.VideoRequestMode b = GetAdRequest.VideoRequestMode.INTERSTITIAL;

    private void a() {
        if (this.getType() == Ad.AdType.REWARDED_VIDEO) {
            this.b = GetAdRequest.VideoRequestMode.REWARDED;
        }
        if (this.getType() == Ad.AdType.VIDEO) {
            this.b = GetAdRequest.VideoRequestMode.INTERSTITIAL;
        }
    }

    private void a(Context context) {
        if (this.getType() != null) {
            if (this.getType() == Ad.AdType.NON_VIDEO) {
                this.a = GetAdRequest.VideoRequestType.DISABLED;
                return;
            }
            if (this.getType() == Ad.AdType.VIDEO_NO_VAST) {
                this.a = GetAdRequest.VideoRequestType.FORCED_NONVAST;
                return;
            }
            if (this.isAdTypeVideo()) {
                this.a = GetAdRequest.VideoRequestType.FORCED;
                return;
            }
        } else {
            if (h.a(context) == h.a.a) {
                if (!i.a(2L)) {
                    this.a = GetAdRequest.VideoRequestType.FORCED;
                    return;
                }
                this.a = GetAdRequest.VideoRequestType.ENABLED;
                return;
            }
            this.a = GetAdRequest.VideoRequestType.DISABLED;
        }
    }

    @Override
    public void fillAdPreferences(Context context, AdPreferences adPreferences, AdPreferences.Placement placement, Pair<String, String> pair) {
        super.fillAdPreferences(context, adPreferences, placement, pair);
        this.a(context);
        this.a();
    }

    @Override
    public e getNameValueMap() {
        e e2 = super.getNameValueMap();
        if (e2 == null) {
            e2 = new d();
        }
        e2.a("video", (Object)this.a, false);
        e2.a("videoMode", (Object)this.b, false);
        return e2;
    }
}

