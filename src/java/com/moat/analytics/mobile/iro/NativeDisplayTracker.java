/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  java.lang.Deprecated
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package com.moat.analytics.mobile.iro;

import android.app.Activity;
import com.moat.analytics.mobile.iro.TrackerListener;

public interface NativeDisplayTracker {
    public void removeListener();

    public void reportUserInteractionEvent(MoatUserInteractionType var1);

    @Deprecated
    public void setActivity(Activity var1);

    public void setListener(TrackerListener var1);

    public void startTracking();

    public void stopTracking();

    public static final class MoatUserInteractionType
    extends Enum<MoatUserInteractionType> {
        public static final /* enum */ MoatUserInteractionType CLICK;
        public static final /* enum */ MoatUserInteractionType TOUCH;
        private static final /* synthetic */ MoatUserInteractionType[] \u02cb;

        static {
            TOUCH = new MoatUserInteractionType();
            CLICK = new MoatUserInteractionType();
            MoatUserInteractionType[] arrmoatUserInteractionType = new MoatUserInteractionType[]{TOUCH, CLICK};
            \u02cb = arrmoatUserInteractionType;
        }

        public static MoatUserInteractionType valueOf(String string) {
            return (MoatUserInteractionType)Enum.valueOf(MoatUserInteractionType.class, (String)string);
        }

        public static MoatUserInteractionType[] values() {
            return (MoatUserInteractionType[])\u02cb.clone();
        }
    }

}

