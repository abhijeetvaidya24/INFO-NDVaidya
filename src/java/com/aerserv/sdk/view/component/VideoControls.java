/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.graphics.Paint$Style
 *  android.graphics.RectF
 *  android.graphics.drawable.Drawable
 *  android.os.Handler
 *  android.os.Looper
 *  android.util.DisplayMetrics
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.Button
 *  android.widget.RelativeLayout
 *  android.widget.RelativeLayout$LayoutParams
 *  android.widget.TextView
 *  java.lang.CharSequence
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.text.Format
 *  java.text.SimpleDateFormat
 */
package com.aerserv.sdk.view.component;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.aerserv.sdk.controller.listener.VolumeControlListener;
import java.text.Format;
import java.text.SimpleDateFormat;

public class VideoControls
extends RelativeLayout {
    private static final float BAR_TO_CONTAINER_SIZE_RATIO = 0.1f;
    private static final float HEIGHT = 36.0f;
    private static final float MIN_BAR_HEIGHT = 15.0f;
    private static final float MIN_CONTAINER_SIZE = 150.0f;
    private int adCount = 1;
    private int adSequence = 1;
    private Bar bar = null;
    private float barHeight;
    private CountdownTimer countdownTimer;
    private final float density;
    private MuteButton muteButton = null;
    private MuteIcon muteIcon;
    private boolean showMuteButton = true;
    private VolumeControlListener volumeControlListener = null;

    public VideoControls(Context context, int n2, int n3, int n4, boolean bl, VolumeControlListener volumeControlListener) {
        this(context, n4, bl, volumeControlListener);
        this.adSequence = n2;
        this.adCount = n3;
    }

    public VideoControls(Context context, int n2, boolean bl, VolumeControlListener volumeControlListener) {
        super(context);
        this.showMuteButton = bl;
        this.volumeControlListener = volumeControlListener;
        this.setVisibility(4);
        this.density = context.getResources().getDisplayMetrics().density;
        float f2 = n2 < 0 ? 2.14748365E9f : (float)n2 / this.density;
        new RelativeLayout.LayoutParams(-1, this.toPx(36.0f)).addRule(12);
        this.bar = new Bar(context, f2);
        this.addView((View)this.bar);
        if (bl && f2 >= 150.0f) {
            this.muteButton = new MuteButton(context);
            this.addView((View)this.muteButton);
        }
    }

    private int toPx(float f2) {
        return Math.round((float)(f2 * this.density));
    }

    public void cleanup() {
        this.bar.cleanup();
        this.bar = null;
        this.muteButton = null;
        this.volumeControlListener = null;
        this.removeAllViews();
    }

    public void onTime(int n2, int n3) {
        CountdownTimer countdownTimer = this.countdownTimer;
        if (countdownTimer != null) {
            countdownTimer.onTime(n2, n3);
        }
    }

    class Bar
    extends RelativeLayout {
        public Bar(Context context, float f2) {
            super(context);
            VideoControls.this.barHeight = 0.1f * f2;
            VideoControls.this.barHeight = Math.max((float)VideoControls.this.barHeight, (float)15.0f);
            VideoControls.this.barHeight = Math.min((float)VideoControls.this.barHeight, (float)36.0f);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, VideoControls.this.toPx(VideoControls.this.barHeight));
            layoutParams.addRule(12);
            this.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
            this.setPadding(VideoControls.this.toPx(5.0f), 0, VideoControls.this.toPx(5.0f), 0);
            VideoControls.this.countdownTimer = new CountdownTimer(context, VideoControls.this.barHeight);
            this.addView((View)VideoControls.this.countdownTimer);
            if (VideoControls.this.showMuteButton && f2 >= 150.0f) {
                VideoControls.this.muteIcon = new MuteIcon(context);
                this.addView((View)VideoControls.this.muteIcon);
            }
        }

        public void cleanup() {
            VideoControls.this.countdownTimer = null;
            VideoControls.this.muteIcon = null;
            this.removeAllViews();
        }
    }

    class CountdownTimer
    extends TextView {
        private final Format timeFormat;
        private int value;

        public CountdownTimer(Context context, float f2) {
            super(context);
            this.value = Integer.MAX_VALUE;
            this.timeFormat = new SimpleDateFormat("mm:ss");
            this.setTextColor(-1);
            this.setBackgroundColor(1711276032);
            this.setPadding(VideoControls.this.toPx(3.0f), VideoControls.this.toPx(2.0f), VideoControls.this.toPx(3.0f), VideoControls.this.toPx(2.0f));
            float f3 = f2 * 0.6f;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, VideoControls.this.toPx(f3));
            layoutParams.addRule(9);
            layoutParams.addRule(15);
            this.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
            this.setGravity(15);
            this.setTextSize(2, f3 * 0.6f);
            this.setText((CharSequence)this.getText(0));
        }

        private String getText(int n2) {
            int n3 = VideoControls.this.adCount;
            String string = "Ad:";
            if (n3 > 0 && VideoControls.this.adSequence > 0 && VideoControls.this.adSequence <= VideoControls.this.adCount) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(string);
                stringBuilder.append(" ");
                stringBuilder.append(VideoControls.this.adSequence);
                stringBuilder.append(" of ");
                stringBuilder.append(VideoControls.this.adCount);
                string = stringBuilder.toString();
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string);
            stringBuilder.append(" (");
            stringBuilder.append(this.timeFormat.format((Object)n2));
            stringBuilder.append(")");
            return stringBuilder.toString();
        }

        public void onTime(int n2, int n3) {
            int n4 = n3 - n2;
            final int n5 = Math.round((float)((float)n4 / 1000.0f));
            if (n3 <= 1000) {
                return;
            }
            if (n4 == 1000) {
                return;
            }
            if (n2 >= n3) {
                return;
            }
            if (n5 < this.value && n3 > 0 && n5 >= 0) {
                this.value = n5;
                Runnable runnable = new Runnable(){

                    public void run() {
                        if (n5 > 0) {
                            VideoControls.this.setVisibility(0);
                        }
                        CountdownTimer.this.setShadowLayer(0.01f, -2.0f, 2.0f, -16777216);
                        CountdownTimer countdownTimer = CountdownTimer.this;
                        countdownTimer.setText((CharSequence)countdownTimer.getText(1000 * n5));
                    }
                };
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    runnable.run();
                    return;
                }
                new Handler(Looper.getMainLooper()).post(runnable);
            }
        }

    }

    class MuteButton
    extends Button {
        float buttonSize;

        public MuteButton(Context context) {
            super(context);
            this.setPadding(VideoControls.this.toPx(3.0f), VideoControls.this.toPx(2.0f), VideoControls.this.toPx(3.0f), VideoControls.this.toPx(3.0f));
            this.buttonSize = 36.0f;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(VideoControls.this.toPx(this.buttonSize), VideoControls.this.toPx(this.buttonSize));
            layoutParams.addRule(11);
            layoutParams.addRule(12);
            this.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
            this.setBackground(null);
            this.setOnClickListener(new View.OnClickListener(){

                public void onClick(View view) {
                    VideoControls.this.showMuteButton = true ^ VideoControls.this.showMuteButton;
                    VideoControls.this.muteIcon.invalidate();
                    if (VideoControls.this.showMuteButton) {
                        VideoControls.this.volumeControlListener.onMuted();
                        return;
                    }
                    VideoControls.this.volumeControlListener.onUnmuted();
                }
            });
        }

    }

    class MuteIcon
    extends View {
        private float iconHeight;

        public MuteIcon(Context context) {
            super(context);
            this.setBackgroundColor(1711276032);
            this.iconHeight = 0.55f * VideoControls.this.barHeight + (float)VideoControls.this.toPx(1.0f);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(VideoControls.this.toPx(this.iconHeight), VideoControls.this.toPx(this.iconHeight));
            layoutParams.addRule(11);
            layoutParams.addRule(15);
            this.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
        }

        private int scale(float f2) {
            VideoControls videoControls = VideoControls.this;
            float f3 = this.iconHeight;
            return videoControls.toPx(f2 * (f3 - 0.3f * f3) / 100.0f + f3 * 0.15f);
        }

        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setColor(-1);
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(3.0f);
            canvas.drawRect((float)this.scale(0.0f), (float)this.scale(25.0f), (float)this.scale(25.0f), (float)this.scale(75.0f), paint);
            canvas.drawLine((float)this.scale(25.0f), (float)this.scale(25.0f), (float)this.scale(50.0f), (float)this.scale(0.0f), paint);
            canvas.drawLine((float)this.scale(50.0f), (float)this.scale(0.0f), (float)this.scale(50.0f), (float)this.scale(100.0f), paint);
            canvas.drawLine((float)this.scale(50.0f), (float)this.scale(100.0f), (float)this.scale(25.0f), (float)this.scale(75.0f), paint);
            if (VideoControls.this.showMuteButton) {
                canvas.drawLine((float)this.scale(70.0f), (float)this.scale(35.0f), (float)this.scale(100.0f), (float)this.scale(65.0f), paint);
                canvas.drawLine((float)this.scale(70.0f), (float)this.scale(65.0f), (float)this.scale(100.0f), (float)this.scale(35.0f), paint);
                return;
            }
            canvas.drawArc(new RectF((float)this.scale(50.0f), (float)this.scale(40.0f), (float)this.scale(70.0f), (float)this.scale(60.0f)), 70.0f, -140.0f, false, paint);
            canvas.drawArc(new RectF((float)this.scale(35.0f), (float)this.scale(25.0f), (float)this.scale(85.0f), (float)this.scale(75.0f)), 70.0f, -140.0f, false, paint);
            canvas.drawArc(new RectF((float)this.scale(20.0f), (float)this.scale(10.0f), (float)this.scale(100.0f), (float)this.scale(90.0f)), 70.0f, -140.0f, false, paint);
        }
    }

}

