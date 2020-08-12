/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  com.startapp.android.publish.ads.video.tracking.VideoTrackingParams
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.security.SecureRandom
 *  java.text.SimpleDateFormat
 *  java.util.ArrayList
 *  java.util.Date
 *  java.util.List
 *  java.util.Locale
 *  java.util.concurrent.TimeUnit
 */
package com.startapp.android.publish.ads.video.a;

import android.text.TextUtils;
import com.startapp.android.publish.ads.video.a.a;
import com.startapp.android.publish.ads.video.tracking.VideoTrackingLink;
import com.startapp.android.publish.ads.video.tracking.VideoTrackingParams;
import com.startapp.android.publish.adsCommon.c;
import com.startapp.common.a.g;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class b {
    private VideoTrackingLink[] a;
    private VideoTrackingParams b;
    private String c;
    private int d;
    private String e = "";
    private com.startapp.android.publish.ads.video.c.a.a f;

    public b(VideoTrackingLink[] arrvideoTrackingLink, VideoTrackingParams videoTrackingParams, String string, int n2) {
        this.a = arrvideoTrackingLink;
        this.b = videoTrackingParams;
        this.c = string;
        this.d = n2;
    }

    private static String a(int n2) {
        long l2 = TimeUnit.SECONDS.convert((long)n2, TimeUnit.MILLISECONDS);
        long l3 = l2 % 60L;
        long l4 = l2 / 3600L;
        long l5 = l2 % 3600L / 60L;
        long l6 = n2 % 1000;
        Locale locale = Locale.US;
        Object[] arrobject = new Object[]{l4, l5, l3, l6};
        return String.format((Locale)locale, (String)"%02d:%02d:%02d.%03d", (Object[])arrobject);
    }

    private String a(VideoTrackingLink videoTrackingLink) {
        StringBuilder stringBuilder = new StringBuilder();
        VideoTrackingParams videoTrackingParams = this.b(videoTrackingLink);
        String string = videoTrackingLink.getTrackingUrl();
        stringBuilder.append(this.b(string));
        stringBuilder.append(videoTrackingParams.getQueryString());
        if (videoTrackingParams.getInternalTrackingParamsIndicator()) {
            stringBuilder.append(com.startapp.common.a.a.a(c.e(string)));
        }
        return stringBuilder.toString();
    }

    private VideoTrackingParams b(VideoTrackingLink videoTrackingLink) {
        VideoTrackingLink.TrackingSource trackingSource = videoTrackingLink.getTrackingSource();
        VideoTrackingParams videoTrackingParams = this.b;
        boolean bl = trackingSource != null && trackingSource == VideoTrackingLink.TrackingSource.STARTAPP;
        return videoTrackingParams.setInternalTrackingParamsIndicator(bl).setShouldAppendOffset(videoTrackingLink.shouldAppendReplay()).setReplayParameter(videoTrackingLink.getReplayParameter());
    }

    private String b(String string) {
        String string2 = this.c;
        String string3 = string2 != null ? TextUtils.htmlEncode((String)string2) : "";
        String string4 = string.replace((CharSequence)"[ASSETURI]", (CharSequence)string3).replace((CharSequence)"[CONTENTPLAYHEAD]", (CharSequence)TextUtils.htmlEncode((String)b.a(this.d))).replace((CharSequence)"[CACHEBUSTING]", (CharSequence)TextUtils.htmlEncode((String)b.c())).replace((CharSequence)"[TIMESTAMP]", (CharSequence)TextUtils.htmlEncode((String)b.d()));
        com.startapp.android.publish.ads.video.c.a.a a2 = this.f;
        if (a2 != null) {
            string4 = string4.replace((CharSequence)"[ERRORCODE]", (CharSequence)String.valueOf((int)a2.a()));
        }
        return string4;
    }

    private boolean b() {
        return this.a != null && this.b != null;
    }

    private static String c() {
        return String.valueOf((int)(10000000 + new SecureRandom().nextInt(90000000)));
    }

    private static String d() {
        String string = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.US).format(new Date());
        int n2 = -2 + string.length();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string.substring(0, n2));
        stringBuilder.append(":");
        stringBuilder.append(string.substring(n2));
        return stringBuilder.toString();
    }

    public a a() {
        if (!this.b()) {
            g.a("VideoEventBuilder", 3, "Some fields have illegal values");
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (VideoTrackingLink videoTrackingLink : this.a) {
            if (videoTrackingLink.getTrackingUrl() == null) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Ignoring tracking link - tracking url is null: tracking link = ");
                stringBuilder.append((Object)videoTrackingLink);
                g.a("VideoEventBuilder", 5, stringBuilder.toString());
                continue;
            }
            if (this.b.getOffset() > 0 && !videoTrackingLink.shouldAppendReplay()) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Ignoring tracking link - external replay event: tracking link = ");
                stringBuilder.append((Object)videoTrackingLink);
                g.a("VideoEventBuilder", 3, stringBuilder.toString());
                continue;
            }
            arrayList.add((Object)this.a(videoTrackingLink));
        }
        return new a((List<String>)arrayList, this.e);
    }

    public b a(com.startapp.android.publish.ads.video.c.a.a a2) {
        this.f = a2;
        return this;
    }

    public b a(String string) {
        this.e = string;
        return this;
    }
}

