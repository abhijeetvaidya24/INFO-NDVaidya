/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.ViewGroup
 *  android.widget.FrameLayout
 *  android.widget.LinearLayout
 *  android.widget.RelativeLayout
 *  java.lang.CharSequence
 *  java.lang.Enum
 *  java.lang.NoSuchFieldError
 *  java.lang.Object
 *  java.lang.String
 */
package com.amazon.device.ads;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

class LayoutFactory {
    LayoutFactory() {
    }

    public ViewGroup createLayout(Context context, LayoutType layoutType, String string) {
        int n = 1.$SwitchMap$com$amazon$device$ads$LayoutFactory$LayoutType[layoutType.ordinal()];
        Object object = n != 1 ? (n != 2 ? new LinearLayout(context) : new FrameLayout(context)) : new RelativeLayout(context);
        object.setContentDescription((CharSequence)string);
        return object;
    }

    static final class LayoutType
    extends Enum<LayoutType> {
        private static final /* synthetic */ LayoutType[] $VALUES;
        public static final /* enum */ LayoutType FRAME_LAYOUT;
        public static final /* enum */ LayoutType LINEAR_LAYOUT;
        public static final /* enum */ LayoutType RELATIVE_LAYOUT;

        static {
            RELATIVE_LAYOUT = new LayoutType();
            LINEAR_LAYOUT = new LayoutType();
            FRAME_LAYOUT = new LayoutType();
            LayoutType[] arrlayoutType = new LayoutType[]{RELATIVE_LAYOUT, LINEAR_LAYOUT, FRAME_LAYOUT};
            $VALUES = arrlayoutType;
        }

        public static LayoutType valueOf(String string) {
            return (LayoutType)Enum.valueOf(LayoutType.class, (String)string);
        }

        public static LayoutType[] values() {
            return (LayoutType[])$VALUES.clone();
        }
    }

}

