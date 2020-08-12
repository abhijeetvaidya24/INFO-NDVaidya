/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.view.View
 *  com.moat.analytics.mobile.ogury.y
 *  java.lang.Double
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Map
 */
package com.moat.analytics.mobile.ogury;

import android.app.Activity;
import android.view.View;
import com.moat.analytics.mobile.ogury.MoatAdEvent;
import com.moat.analytics.mobile.ogury.ReactiveVideoTracker;
import com.moat.analytics.mobile.ogury.TrackerListener;
import com.moat.analytics.mobile.ogury.VideoTrackerListener;
import com.moat.analytics.mobile.ogury.base.functional.Optional;
import com.moat.analytics.mobile.ogury.e;
import com.moat.analytics.mobile.ogury.l;
import com.moat.analytics.mobile.ogury.n;
import com.moat.analytics.mobile.ogury.p;
import com.moat.analytics.mobile.ogury.y;
import java.util.Map;

public class ReactiveVideoTrackerPlugin
implements n<ReactiveVideoTracker> {
    private final String \u02ce;

    public ReactiveVideoTrackerPlugin(String string) {
        this.\u02ce = string;
    }

    @Override
    public ReactiveVideoTracker create() throws l {
        return p.\u02cb(new p.b<ReactiveVideoTracker>(this){
            private /* synthetic */ ReactiveVideoTrackerPlugin \u02cf;
            {
                this.\u02cf = reactiveVideoTrackerPlugin;
            }

            @Override
            public final Optional<ReactiveVideoTracker> \u02cf() {
                e.1.\u0971("[INFO] ", "Attempting to create ReactiveVideoTracker");
                return Optional.of(new y(this.\u02cf.\u02ce));
            }
        }, ReactiveVideoTracker.class);
    }

    @Override
    public ReactiveVideoTracker createNoOp() {
        return new c();
    }

    static final class c
    implements ReactiveVideoTracker {
        c() {
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

