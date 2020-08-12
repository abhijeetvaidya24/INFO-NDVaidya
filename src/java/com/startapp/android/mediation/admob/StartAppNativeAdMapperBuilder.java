/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.os.Bundle
 *  com.google.android.gms.ads.formats.NativeAd
 *  com.google.android.gms.ads.formats.NativeAd$Image
 *  com.google.android.gms.ads.mediation.NativeAdMapper
 *  com.startapp.android.mediation.admob.StartAppNativeAdImage
 *  com.startapp.android.mediation.admob.StartAppNativeAdMapperBuilder$AppInstallMapper
 *  com.startapp.android.mediation.admob.StartAppNativeAdMapperBuilder$ContentMapper
 *  com.startapp.android.publish.ads.nativead.NativeAdDetails
 *  com.startapp.android.publish.ads.nativead.StartAppNativeAd
 *  com.startapp.android.publish.ads.nativead.StartAppNativeAd$b
 *  java.lang.Boolean
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.List
 */
package com.startapp.android.mediation.admob;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.mediation.NativeAdMapper;
import com.startapp.android.mediation.admob.StartAppNativeAdImage;
import com.startapp.android.mediation.admob.StartAppNativeAdMapperBuilder;
import com.startapp.android.publish.ads.nativead.NativeAdDetails;
import com.startapp.android.publish.ads.nativead.StartAppNativeAd;
import java.util.ArrayList;
import java.util.List;

/*
 * Exception performing whole class analysis.
 */
public class StartAppNativeAdMapperBuilder {
    public static NativeAdMapper buildMapper(Context context, NativeAdDetails nativeAdDetails) {
        boolean bl2 = Boolean.TRUE.equals((Object)nativeAdDetails.isApp());
        Object object = bl2 ? new /* Unavailable Anonymous Inner Class!! */ : new /* Unavailable Anonymous Inner Class!! */;
        IMapper iMapper = (IMapper)object;
        iMapper.setHeadline(nativeAdDetails.getTitle());
        iMapper.setBody(nativeAdDetails.getDescription());
        iMapper.setCallToAction(StartAppNativeAdMapperBuilder.extractCallToAction(nativeAdDetails.getCampaignAction().name()));
        iMapper.setStore("Google Play");
        iMapper.setPrice("");
        iMapper.setStarRating(nativeAdDetails.getRating());
        if (nativeAdDetails.getImageUrl() != null) {
            iMapper.setIcon((NativeAd.Image)new StartAppNativeAdImage(context, nativeAdDetails.getImageBitmap(), nativeAdDetails.getImageUrl()));
        }
        if (nativeAdDetails.getSecondaryImageUrl() != null && !nativeAdDetails.getSecondaryImageUrl().equals((Object)nativeAdDetails.getImageUrl())) {
            ArrayList arrayList = new ArrayList(1);
            arrayList.add((Object)new StartAppNativeAdImage(context, nativeAdDetails.getSecondaryImageBitmap(), nativeAdDetails.getSecondaryImageUrl()));
            iMapper.setImages((List<NativeAd.Image>)arrayList);
        }
        NativeAdMapper nativeAdMapper = iMapper.asMapper();
        nativeAdMapper.setOverrideClickHandling(false);
        nativeAdMapper.setOverrideImpressionRecording(false);
        if (bl2) {
            Bundle bundle = new Bundle();
            bundle.putString("installs", nativeAdDetails.getInstalls());
            bundle.putString("category", nativeAdDetails.getCategory());
            nativeAdMapper.setExtras(bundle);
        }
        return nativeAdMapper;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static String extractCallToAction(String string2) {
        int n2 = string2.hashCode();
        if (n2 != 253992913) {
            if (n2 != 1032794997) return "Install";
            if (!string2.equals((Object)"LAUNCH_APP")) return "Install";
            return "Launch app";
        }
        if (!string2.equals((Object)"OPEN_MARKET")) return "Install";
        return "Install";
    }

    static interface IMapper {
        public NativeAdMapper asMapper();

        public void setBody(String var1);

        public void setCallToAction(String var1);

        public void setHeadline(String var1);

        public void setIcon(NativeAd.Image var1);

        public void setImages(List<NativeAd.Image> var1);

        public void setPrice(String var1);

        public void setStarRating(double var1);

        public void setStore(String var1);
    }

}

