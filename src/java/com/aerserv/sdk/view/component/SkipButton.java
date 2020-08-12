/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.os.Handler
 *  android.os.Looper
 *  android.util.DisplayMetrics
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.RelativeLayout
 *  android.widget.RelativeLayout$LayoutParams
 *  android.widget.TextView
 *  java.lang.CharSequence
 *  java.lang.Enum
 *  java.lang.Long
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 */
package com.aerserv.sdk.view.component;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.aerserv.sdk.controller.listener.SkipVideoListener;

public class SkipButton
extends TextView {
    private final float DENSITY;
    private boolean canSkip = false;
    private String doneText = "";
    private String runningText = "";
    private final Long skipOffsetMillis;
    private SkipVideoListener skipVideoListener = null;
    private final Long videoLengthMillis;

    public SkipButton(Context context, Long l2, Long l3, int n2, SkipVideoListener skipVideoListener) {
        this(context, l2, l3, n2, Position.TOP_RIGHT, "You can skip\nthis ad in %s", "Skip Ad >>", skipVideoListener);
    }

    public SkipButton(Context context, Long l2, Long l3, int n2, Position position, String string, String string2, SkipVideoListener skipVideoListener) {
        super(context);
        this.DENSITY = context.getResources().getDisplayMetrics().density;
        this.skipOffsetMillis = l2;
        this.videoLengthMillis = l3;
        this.skipVideoListener = skipVideoListener;
        this.runningText = string;
        this.doneText = string2;
        this.setVisibility(4);
        this.setTextColor(-1);
        this.setPadding(this.toPx(20.0f), this.toPx(5.0f), this.toPx(20.0f), this.toPx(5.0f));
        this.setGravity(17);
        float f2 = (float)n2 / this.DENSITY;
        if (f2 < 0.0f) {
            f2 = 2.14748365E9f;
        }
        float f3 = 0.6f * (0.6f * Math.min((float)Math.max((float)(f2 * 0.1f), (float)15.0f), (float)32.0f));
        this.setTextSize(2, f3);
        this.setBackgroundColor(1711276032);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        if (position == Position.BOTTOM_LEFT) {
            layoutParams.addRule(9);
            layoutParams.addRule(12);
        } else {
            layoutParams.addRule(11);
            layoutParams.addRule(10);
        }
        layoutParams.setMargins(0, this.toPx(f3 * 3.0f), 0, 0);
        this.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
        this.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                if (SkipButton.this.canSkip) {
                    SkipButton.this.canSkip = false;
                    if (SkipButton.this.skipVideoListener != null) {
                        SkipButton.this.skipVideoListener.onSkip();
                    }
                }
            }
        });
    }

    private int toPx(float f2) {
        return Math.round((float)(f2 * this.DENSITY));
    }

    public void cleanup() {
        this.skipVideoListener = null;
        this.setOnClickListener(null);
    }

    public void onTime(final long l2) {
        if (this.skipOffsetMillis != null) {
            if (this.videoLengthMillis == null) {
                return;
            }
            new Handler(this.getContext().getMainLooper()).post(new Runnable(){

                public void run() {
                    SkipButton.this.setVisibility(0);
                    long l22 = Math.round((float)((float)(SkipButton.this.skipOffsetMillis - l2) / 1000.0f));
                    if (l22 <= 0L) {
                        SkipButton.this.canSkip = true;
                        SkipButton skipButton = SkipButton.this;
                        skipButton.setText((CharSequence)skipButton.doneText);
                    } else {
                        SkipButton.this.canSkip = false;
                        SkipButton skipButton = SkipButton.this;
                        String string = skipButton.runningText;
                        Object[] arrobject = new Object[]{l22};
                        skipButton.setText((CharSequence)String.format((String)string, (Object[])arrobject));
                    }
                    SkipButton skipButton = SkipButton.this;
                    skipButton.setMinimumWidth(skipButton.getWidth());
                    SkipButton skipButton2 = SkipButton.this;
                    skipButton2.setMinimumHeight(skipButton2.getHeight());
                }
            });
        }
    }

    public static final class Position
    extends Enum<Position> {
        private static final /* synthetic */ Position[] $VALUES;
        public static final /* enum */ Position BOTTOM_LEFT;
        public static final /* enum */ Position TOP_RIGHT;

        static {
            TOP_RIGHT = new Position();
            BOTTOM_LEFT = new Position();
            Position[] arrposition = new Position[]{TOP_RIGHT, BOTTOM_LEFT};
            $VALUES = arrposition;
        }

        public static Position valueOf(String string) {
            return (Position)Enum.valueOf(Position.class, (String)string);
        }

        public static Position[] values() {
            return (Position[])$VALUES.clone();
        }
    }

}

