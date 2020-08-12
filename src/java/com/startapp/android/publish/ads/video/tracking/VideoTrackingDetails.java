/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.startapp.android.publish.ads.video.tracking.AbsoluteTrackingLink
 *  com.startapp.android.publish.ads.video.tracking.ActionTrackingLink
 *  com.startapp.android.publish.ads.video.tracking.FractionTrackingLink
 *  java.io.Serializable
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.HashMap
 *  java.util.List
 */
package com.startapp.android.publish.ads.video.tracking;

import com.startapp.android.publish.ads.video.c.a.a.c;
import com.startapp.android.publish.ads.video.c.a.b;
import com.startapp.android.publish.ads.video.c.a.e;
import com.startapp.android.publish.ads.video.tracking.AbsoluteTrackingLink;
import com.startapp.android.publish.ads.video.tracking.ActionTrackingLink;
import com.startapp.android.publish.ads.video.tracking.FractionTrackingLink;
import com.startapp.android.publish.ads.video.tracking.VideoTrackingLink;
import com.startapp.common.c.f;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class VideoTrackingDetails
implements Serializable {
    private static final long serialVersionUID = 1L;
    @f(b="Lcom/startapp/android/publish/ads/video/tracking/AbsoluteTrackingLink;")
    private AbsoluteTrackingLink[] absoluteTrackingUrls;
    @f(b="Lcom/startapp/android/publish/ads/video/tracking/ActionTrackingLink;")
    private ActionTrackingLink[] creativeViewUrls;
    @f(b="Lcom/startapp/android/publish/ads/video/tracking/FractionTrackingLink;")
    private FractionTrackingLink[] fractionTrackingUrls;
    @f(b="Lcom/startapp/android/publish/ads/video/tracking/ActionTrackingLink;")
    private ActionTrackingLink[] impressionUrls;
    @f(b="Lcom/startapp/android/publish/ads/video/tracking/ActionTrackingLink;")
    private ActionTrackingLink[] inlineErrorTrackingUrls;
    @f(b="Lcom/startapp/android/publish/ads/video/tracking/ActionTrackingLink;")
    private ActionTrackingLink[] soundMuteUrls;
    @f(b="Lcom/startapp/android/publish/ads/video/tracking/ActionTrackingLink;")
    private ActionTrackingLink[] soundUnmuteUrls;
    @f(b="Lcom/startapp/android/publish/ads/video/tracking/ActionTrackingLink;")
    private ActionTrackingLink[] videoClickTrackingUrls;
    @f(b="Lcom/startapp/android/publish/ads/video/tracking/ActionTrackingLink;")
    private ActionTrackingLink[] videoClosedUrls;
    @f(b="Lcom/startapp/android/publish/ads/video/tracking/ActionTrackingLink;")
    private ActionTrackingLink[] videoPausedUrls;
    @f(b="Lcom/startapp/android/publish/ads/video/tracking/ActionTrackingLink;")
    private ActionTrackingLink[] videoPostRollClosedUrls;
    @f(b="Lcom/startapp/android/publish/ads/video/tracking/ActionTrackingLink;")
    private ActionTrackingLink[] videoPostRollImpressionUrls;
    @f(b="Lcom/startapp/android/publish/ads/video/tracking/ActionTrackingLink;")
    private ActionTrackingLink[] videoResumedUrls;
    @f(b="Lcom/startapp/android/publish/ads/video/tracking/ActionTrackingLink;")
    private ActionTrackingLink[] videoRewardedUrls;
    @f(b="Lcom/startapp/android/publish/ads/video/tracking/ActionTrackingLink;")
    private ActionTrackingLink[] videoSkippedUrls;

    public VideoTrackingDetails() {
    }

    public VideoTrackingDetails(e e2) {
        if (e2 != null) {
            HashMap<b, List<c>> hashMap = e2.a();
            ArrayList arrayList = new ArrayList();
            VideoTrackingDetails.addFractionUrls((List<c>)((List)hashMap.get((Object)b.k)), 0, (List<FractionTrackingLink>)arrayList);
            VideoTrackingDetails.addFractionUrls((List<c>)((List)hashMap.get((Object)b.l)), 25, (List<FractionTrackingLink>)arrayList);
            VideoTrackingDetails.addFractionUrls((List<c>)((List)hashMap.get((Object)b.m)), 50, (List<FractionTrackingLink>)arrayList);
            VideoTrackingDetails.addFractionUrls((List<c>)((List)hashMap.get((Object)b.n)), 75, (List<FractionTrackingLink>)arrayList);
            VideoTrackingDetails.addFractionUrls((List<c>)((List)hashMap.get((Object)b.o)), 100, (List<FractionTrackingLink>)arrayList);
            this.fractionTrackingUrls = (FractionTrackingLink[])arrayList.toArray((Object[])new FractionTrackingLink[arrayList.size()]);
            this.impressionUrls = VideoTrackingDetails.urlToTrackingList(e2.d());
            this.soundMuteUrls = VideoTrackingDetails.trackingToTrackingList((List<c>)((List)hashMap.get((Object)b.a)));
            this.soundUnmuteUrls = VideoTrackingDetails.trackingToTrackingList((List<c>)((List)hashMap.get((Object)b.b)));
            this.videoPausedUrls = VideoTrackingDetails.trackingToTrackingList((List<c>)((List)hashMap.get((Object)b.c)));
            this.videoResumedUrls = VideoTrackingDetails.trackingToTrackingList((List<c>)((List)hashMap.get((Object)b.d)));
            this.videoSkippedUrls = VideoTrackingDetails.trackingToTrackingList((List<c>)((List)hashMap.get((Object)b.f)));
            this.videoPausedUrls = VideoTrackingDetails.trackingToTrackingList((List<c>)((List)hashMap.get((Object)b.c)));
            this.videoClosedUrls = VideoTrackingDetails.trackingToTrackingList((List<c>)((List)hashMap.get((Object)b.y)));
            this.inlineErrorTrackingUrls = VideoTrackingDetails.urlToTrackingList(e2.e());
            this.videoClickTrackingUrls = VideoTrackingDetails.urlToTrackingList(e2.c().b());
            this.absoluteTrackingUrls = this.toAbsoluteTrackingList((List<c>)((List)hashMap.get((Object)b.s)));
        }
    }

    private static void addFractionUrls(List<c> list, int n2, List<FractionTrackingLink> list2) {
        if (list != null) {
            for (c c2 : list) {
                FractionTrackingLink fractionTrackingLink = new FractionTrackingLink();
                fractionTrackingLink.setTrackingUrl(c2.a());
                fractionTrackingLink.setFraction(n2);
                fractionTrackingLink.setAppendReplayParameter(true);
                fractionTrackingLink.setReplayParameter("");
                list2.add((Object)fractionTrackingLink);
            }
        }
    }

    private String printTrackingLinks(VideoTrackingLink[] arrvideoTrackingLink) {
        if (arrvideoTrackingLink != null) {
            return Arrays.toString((Object[])arrvideoTrackingLink);
        }
        return "";
    }

    private AbsoluteTrackingLink[] toAbsoluteTrackingList(List<c> list) {
        if (list != null) {
            ArrayList arrayList = new ArrayList(list.size());
            for (c c2 : list) {
                AbsoluteTrackingLink absoluteTrackingLink = new AbsoluteTrackingLink();
                absoluteTrackingLink.setTrackingUrl(c2.a());
                if (c2.b() != -1) {
                    absoluteTrackingLink.setVideoOffsetMillis(c2.b());
                }
                arrayList.add((Object)absoluteTrackingLink);
            }
            return (AbsoluteTrackingLink[])arrayList.toArray((Object[])new AbsoluteTrackingLink[arrayList.size()]);
        }
        return new AbsoluteTrackingLink[0];
    }

    private static ActionTrackingLink[] trackingToTrackingList(List<c> list) {
        if (list != null) {
            ArrayList arrayList = new ArrayList(list.size());
            for (c c2 : list) {
                ActionTrackingLink actionTrackingLink = new ActionTrackingLink();
                actionTrackingLink.setTrackingUrl(c2.a());
                arrayList.add((Object)actionTrackingLink);
            }
            return (ActionTrackingLink[])arrayList.toArray((Object[])new ActionTrackingLink[arrayList.size()]);
        }
        return new ActionTrackingLink[0];
    }

    private static ActionTrackingLink[] urlToTrackingList(List<String> list) {
        if (list != null) {
            ArrayList arrayList = new ArrayList(list.size());
            for (String string : list) {
                ActionTrackingLink actionTrackingLink = new ActionTrackingLink();
                actionTrackingLink.setTrackingUrl(string);
                arrayList.add((Object)actionTrackingLink);
            }
            return (ActionTrackingLink[])arrayList.toArray((Object[])new ActionTrackingLink[arrayList.size()]);
        }
        return new ActionTrackingLink[0];
    }

    public AbsoluteTrackingLink[] getAbsoluteTrackingUrls() {
        return this.absoluteTrackingUrls;
    }

    public ActionTrackingLink[] getCreativeViewUrls() {
        return this.creativeViewUrls;
    }

    public FractionTrackingLink[] getFractionTrackingUrls() {
        return this.fractionTrackingUrls;
    }

    public ActionTrackingLink[] getImpressionUrls() {
        return this.impressionUrls;
    }

    public ActionTrackingLink[] getInlineErrorTrackingUrls() {
        return this.inlineErrorTrackingUrls;
    }

    public ActionTrackingLink[] getSoundMuteUrls() {
        return this.soundMuteUrls;
    }

    public ActionTrackingLink[] getSoundUnmuteUrls() {
        return this.soundUnmuteUrls;
    }

    public ActionTrackingLink[] getVideoClickTrackingUrls() {
        return this.videoClickTrackingUrls;
    }

    public ActionTrackingLink[] getVideoClosedUrls() {
        return this.videoClosedUrls;
    }

    public ActionTrackingLink[] getVideoPausedUrls() {
        return this.videoPausedUrls;
    }

    public ActionTrackingLink[] getVideoPostRollClosedUrls() {
        return this.videoPostRollClosedUrls;
    }

    public ActionTrackingLink[] getVideoPostRollImpressionUrls() {
        return this.videoPostRollImpressionUrls;
    }

    public ActionTrackingLink[] getVideoResumedUrls() {
        return this.videoResumedUrls;
    }

    public ActionTrackingLink[] getVideoRewardedUrls() {
        return this.videoRewardedUrls;
    }

    public ActionTrackingLink[] getVideoSkippedUrls() {
        return this.videoSkippedUrls;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("VideoTrackingDetails [fractionTrackingUrls=");
        stringBuilder.append(this.printTrackingLinks((VideoTrackingLink[])this.fractionTrackingUrls));
        stringBuilder.append(", absoluteTrackingUrls=");
        stringBuilder.append(this.printTrackingLinks((VideoTrackingLink[])this.absoluteTrackingUrls));
        stringBuilder.append(", impressionUrls=");
        stringBuilder.append(this.printTrackingLinks((VideoTrackingLink[])this.impressionUrls));
        stringBuilder.append(", creativeViewUrls=");
        stringBuilder.append(this.printTrackingLinks((VideoTrackingLink[])this.creativeViewUrls));
        stringBuilder.append(", soundMuteUrls=");
        stringBuilder.append(this.printTrackingLinks((VideoTrackingLink[])this.soundMuteUrls));
        stringBuilder.append(", soundUnmuteUrls=");
        stringBuilder.append(this.printTrackingLinks((VideoTrackingLink[])this.soundUnmuteUrls));
        stringBuilder.append(", videoPausedUrls=");
        stringBuilder.append(this.printTrackingLinks((VideoTrackingLink[])this.videoPausedUrls));
        stringBuilder.append(", videoResumedUrls=");
        stringBuilder.append(this.printTrackingLinks((VideoTrackingLink[])this.videoResumedUrls));
        stringBuilder.append(", videoSkippedUrls=");
        stringBuilder.append(this.printTrackingLinks((VideoTrackingLink[])this.videoSkippedUrls));
        stringBuilder.append(", videoClosedUrls=");
        stringBuilder.append(this.printTrackingLinks((VideoTrackingLink[])this.videoClosedUrls));
        stringBuilder.append(", videoPostRollImpressionUrls=");
        stringBuilder.append(this.printTrackingLinks((VideoTrackingLink[])this.videoPostRollImpressionUrls));
        stringBuilder.append(", videoPostRollClosedUrls=");
        stringBuilder.append(this.printTrackingLinks((VideoTrackingLink[])this.videoPostRollClosedUrls));
        stringBuilder.append(", videoRewardedUrls=");
        stringBuilder.append(this.printTrackingLinks((VideoTrackingLink[])this.videoRewardedUrls));
        stringBuilder.append(", videoClickTrackingUrls=");
        stringBuilder.append(this.printTrackingLinks((VideoTrackingLink[])this.videoClickTrackingUrls));
        stringBuilder.append(", inlineErrorTrackingUrls=");
        stringBuilder.append(this.printTrackingLinks((VideoTrackingLink[])this.inlineErrorTrackingUrls));
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}

