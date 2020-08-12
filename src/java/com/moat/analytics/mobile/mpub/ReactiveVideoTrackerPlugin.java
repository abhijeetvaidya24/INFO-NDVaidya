/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.view.View
 *  com.moat.analytics.mobile.mpub.y
 *  java.lang.Double
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Map
 */
package com.moat.analytics.mobile.mpub;

import android.app.Activity;
import android.view.View;
import com.moat.analytics.mobile.mpub.MoatAdEvent;
import com.moat.analytics.mobile.mpub.MoatPlugin;
import com.moat.analytics.mobile.mpub.ReactiveVideoTracker;
import com.moat.analytics.mobile.mpub.TrackerListener;
import com.moat.analytics.mobile.mpub.VideoTrackerListener;
import com.moat.analytics.mobile.mpub.p;
import com.moat.analytics.mobile.mpub.x;
import com.moat.analytics.mobile.mpub.y;
import java.util.Map;

public class ReactiveVideoTrackerPlugin
implements MoatPlugin<ReactiveVideoTracker> {
    private final String a;

    public ReactiveVideoTrackerPlugin(String string) {
        this.a = string;
    }

    @Override
    public /* synthetic */ Object a() {
        return this.c();
    }

    @Override
    public /* synthetic */ Object b() {
        return this.d();
    }

    public ReactiveVideoTracker c() {
        return x.a(new x.a<ReactiveVideoTracker>(){

            @Override
            public com.moat.analytics.mobile.mpub.a.b.a<ReactiveVideoTracker> a() {
                p.a("[INFO] ", "Attempting to create ReactiveVideoTracker");
                return com.moat.analytics.mobile.mpub.a.b.a.a(new y(ReactiveVideoTrackerPlugin.this.a));
            }
        }, ReactiveVideoTracker.class);
    }

    public ReactiveVideoTracker d() {
        return new a();
    }

    static class a
    implements ReactiveVideoTracker {
        a() {
        }

        @Override
        public void changeTargetView(View view) {
        }

        @Override
        public void dispatchEvent(MoatAdEvent moatAdEvent) {
        }

        @Override
        public void removeListener() {
        }

        @Override
        public void removeVideoListener() {
        }

        @Override
        public void setActivity(Activity activity) {
        }

        @Override
        public void setListener(TrackerListener trackerListener) {
        }

        @Override
        public void setPlayerVolume(Double d2) {
        }

        @Override
        public void setVideoListener(VideoTrackerListener videoTrackerListener) {
        }

        @Override
        public void stopTracking() {
        }

        @Override
        public boolean trackVideoAd(Map<String, String> map, Integer n2, View view) {
            return false;
        }
    }

}

