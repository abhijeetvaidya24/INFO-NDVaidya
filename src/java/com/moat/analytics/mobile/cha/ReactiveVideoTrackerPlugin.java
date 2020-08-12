/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.view.View
 *  com.moat.analytics.mobile.cha.w
 *  java.lang.Double
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Map
 */
package com.moat.analytics.mobile.cha;

import android.app.Activity;
import android.view.View;
import com.moat.analytics.mobile.cha.MoatAdEvent;
import com.moat.analytics.mobile.cha.ReactiveVideoTracker;
import com.moat.analytics.mobile.cha.TrackerListener;
import com.moat.analytics.mobile.cha.VideoTrackerListener;
import com.moat.analytics.mobile.cha.a;
import com.moat.analytics.mobile.cha.base.functional.Optional;
import com.moat.analytics.mobile.cha.l;
import com.moat.analytics.mobile.cha.o;
import com.moat.analytics.mobile.cha.p;
import com.moat.analytics.mobile.cha.w;
import java.util.Map;

public class ReactiveVideoTrackerPlugin
implements l<ReactiveVideoTracker> {
    private final String \u02ca;

    public ReactiveVideoTrackerPlugin(String string) {
        this.\u02ca = string;
    }

    @Override
    public ReactiveVideoTracker create() throws o {
        return p.\u02cb(new p.c<ReactiveVideoTracker>(this){
            private /* synthetic */ ReactiveVideoTrackerPlugin \u02ca;
            {
                this.\u02ca = reactiveVideoTrackerPlugin;
            }

            @Override
            public final Optional<ReactiveVideoTracker> \u02cb() {
                a.\u02ca("[INFO] ", "Attempting to create ReactiveVideoTracker");
                return Optional.of(new w(this.\u02ca.\u02ca));
            }
        }, ReactiveVideoTracker.class);
    }

    @Override
    public ReactiveVideoTracker createNoOp() {
        return new d();
    }

    static final class d
    implements ReactiveVideoTracker {
        d() {
        }

        @Override
        public final void changeTargetView(View view) {
        }

        @Override
        public final void dispatchEvent(MoatAdEvent moatAdEvent) {
        }

        @Override
        public final void removeListener() {
        }

        @Override
        public final void removeVideoListener() {
        }

        @Override
        public final void setActivity(Activity activity) {
        }

        @Override
        public final void setListener(TrackerListener trackerListener) {
        }

        @Override
        public final void setPlayerVolume(Double d2) {
        }

        @Override
        public final void setVideoListener(VideoTrackerListener videoTrackerListener) {
        }

        @Override
        public final void stopTracking() {
        }

        @Override
        public final boolean trackVideoAd(Map<String, String> map, Integer n2, View view) {
            return false;
        }
    }

}

