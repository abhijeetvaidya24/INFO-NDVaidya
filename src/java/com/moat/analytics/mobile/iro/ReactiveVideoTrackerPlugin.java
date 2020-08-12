/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.view.View
 *  com.moat.analytics.mobile.iro.w
 *  java.lang.Double
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Map
 */
package com.moat.analytics.mobile.iro;

import android.app.Activity;
import android.view.View;
import com.moat.analytics.mobile.iro.MoatAdEvent;
import com.moat.analytics.mobile.iro.ReactiveVideoTracker;
import com.moat.analytics.mobile.iro.TrackerListener;
import com.moat.analytics.mobile.iro.VideoTrackerListener;
import com.moat.analytics.mobile.iro.base.functional.Optional;
import com.moat.analytics.mobile.iro.m;
import com.moat.analytics.mobile.iro.o;
import com.moat.analytics.mobile.iro.s;
import com.moat.analytics.mobile.iro.w;
import java.util.Map;

public class ReactiveVideoTrackerPlugin
implements m<ReactiveVideoTracker> {
    private final String \u02cb;

    public ReactiveVideoTrackerPlugin(String string) {
        this.\u02cb = string;
    }

    @Override
    public ReactiveVideoTracker create() throws o {
        return s.\u02ca(new s.a<ReactiveVideoTracker>(this){
            private /* synthetic */ ReactiveVideoTrackerPlugin \u02ce;
            {
                this.\u02ce = reactiveVideoTrackerPlugin;
            }

            @Override
            public final Optional<ReactiveVideoTracker> \u02cf() {
                com.moat.analytics.mobile.iro.b.\u02ce("[INFO] ", "Attempting to create ReactiveVideoTracker");
                return Optional.of(new w(this.\u02ce.\u02cb));
            }
        }, ReactiveVideoTracker.class);
    }

    @Override
    public ReactiveVideoTracker createNoOp() {
        return new b();
    }

    static final class b
    implements ReactiveVideoTracker {
        b() {
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

