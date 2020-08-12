/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.Serializable
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.List
 */
package com.startapp.android.publish.ads.video;

import com.startapp.android.publish.ads.video.c.a.a.b;
import com.startapp.android.publish.ads.video.c.a.e;
import com.startapp.android.publish.ads.video.tracking.VideoTrackingDetails;
import com.startapp.android.publish.omsdk.AdVerification;
import com.startapp.android.publish.omsdk.VerificationDetails;
import com.startapp.common.c.f;
import java.io.Serializable;
import java.util.List;

public class VideoAdDetails
implements Serializable {
    private static final long serialVersionUID = 1L;
    @f(b="Lcom/startapp/android/publish/omsdk/VerificationDetails;", f="adVerifications")
    private VerificationDetails[] adVerifications;
    private String clickUrl;
    private boolean clickable;
    private boolean closeable;
    private boolean isVideoMuted;
    private String localVideoPath;
    @f(b="Lcom/startapp/android/publish/ads/video/VideoAdDetails$PostRollType;")
    private PostRollType postRoll;
    private boolean skippable;
    private int skippableAfter;
    @f(a=true)
    private VideoTrackingDetails videoTrackingDetails;
    private String videoUrl;

    public VideoAdDetails() {
    }

    public VideoAdDetails(e e2, boolean bl) {
        if (e2 != null) {
            this.videoTrackingDetails = new VideoTrackingDetails(e2);
            if (e2.g() != null) {
                this.videoUrl = e2.g().a();
            }
            boolean bl2 = true;
            if (bl) {
                this.skippableAfter = e2.f();
                boolean bl3 = this.skippableAfter != Integer.MAX_VALUE;
                this.skippable = bl3;
            } else {
                this.skippable = false;
            }
            this.clickUrl = e2.c().a();
            if (this.clickUrl == null) {
                bl2 = false;
            }
            this.clickable = bl2;
            this.postRoll = PostRollType.NONE;
            this.setAdVerifications(e2.h());
        }
    }

    public AdVerification getAdVerifications() {
        return new AdVerification(this.adVerifications);
    }

    public String getClickUrl() {
        return this.clickUrl;
    }

    public String getLocalVideoPath() {
        return this.localVideoPath;
    }

    public PostRollType getPostRollType() {
        return this.postRoll;
    }

    public int getSkippableAfter() {
        return this.skippableAfter;
    }

    public VideoTrackingDetails getVideoTrackingDetails() {
        return this.videoTrackingDetails;
    }

    public String getVideoUrl() {
        return this.videoUrl;
    }

    public boolean isClickable() {
        return this.clickable;
    }

    public boolean isCloseable() {
        return this.closeable;
    }

    public boolean isSkippable() {
        return this.skippable;
    }

    public boolean isVideoMuted() {
        return this.isVideoMuted;
    }

    public void setAdVerifications(AdVerification adVerification) {
        if (adVerification != null && adVerification.getAdVerification() != null) {
            this.adVerifications = (VerificationDetails[])adVerification.getAdVerification().toArray((Object[])new VerificationDetails[adVerification.getAdVerification().size()]);
        }
    }

    public void setLocalVideoPath(String string) {
        this.localVideoPath = string;
    }

    public void setVideoMuted(boolean bl) {
        this.isVideoMuted = bl;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("VideoAdDetails [videoUrl=");
        stringBuilder.append(this.videoUrl);
        stringBuilder.append(", localVideoPath=");
        stringBuilder.append(this.localVideoPath);
        stringBuilder.append(", postRoll=");
        stringBuilder.append((Object)this.postRoll);
        stringBuilder.append(", closeable=");
        stringBuilder.append(this.closeable);
        stringBuilder.append(", skippable=");
        stringBuilder.append(this.skippable);
        stringBuilder.append(", skippableAfter=");
        stringBuilder.append(this.skippableAfter);
        stringBuilder.append(", videoTrackingDetails= ");
        stringBuilder.append((Object)this.videoTrackingDetails);
        stringBuilder.append(", isVideoMuted= ");
        stringBuilder.append(this.isVideoMuted);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public static final class PostRollType
    extends Enum<PostRollType> {
        private static final /* synthetic */ PostRollType[] $VALUES;
        public static final /* enum */ PostRollType IMAGE = new PostRollType();
        public static final /* enum */ PostRollType LAST_FRAME = new PostRollType();
        public static final /* enum */ PostRollType NONE = new PostRollType();

        static {
            PostRollType[] arrpostRollType = new PostRollType[]{IMAGE, LAST_FRAME, NONE};
            $VALUES = arrpostRollType;
        }

        public static PostRollType valueOf(String string) {
            return (PostRollType)Enum.valueOf(PostRollType.class, (String)string);
        }

        public static PostRollType[] values() {
            return (PostRollType[])$VALUES.clone();
        }
    }

}

