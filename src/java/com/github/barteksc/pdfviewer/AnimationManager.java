/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.animation.TimeInterpolator
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 *  android.content.Context
 *  android.graphics.PointF
 *  android.view.animation.DecelerateInterpolator
 *  android.view.animation.Interpolator
 *  android.widget.Scroller
 *  java.lang.Float
 *  java.lang.Object
 */
package com.github.barteksc.pdfviewer;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.PointF;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.scroll.ScrollHandle;

class AnimationManager {
    private ValueAnimator animation;
    private ValueAnimator flingAnimation;
    private PDFView pdfView;
    private Scroller scroller;

    public AnimationManager(PDFView pDFView) {
        this.pdfView = pDFView;
        this.scroller = new Scroller(pDFView.getContext(), null, true);
    }

    private void hideHandle() {
        if (this.pdfView.getScrollHandle() != null) {
            this.pdfView.getScrollHandle().hideDelayed();
        }
    }

    public void startFlingAnimation(int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9) {
        this.stopAll();
        this.flingAnimation = ValueAnimator.ofFloat((float[])new float[]{0.0f, 1.0f});
        FlingAnimation flingAnimation = new FlingAnimation();
        this.flingAnimation.addUpdateListener((ValueAnimator.AnimatorUpdateListener)flingAnimation);
        this.flingAnimation.addListener((Animator.AnimatorListener)flingAnimation);
        this.scroller.fling(n2, n3, n4, n5, n6, n7, n8, n9);
        this.flingAnimation.setDuration((long)this.scroller.getDuration());
        this.flingAnimation.start();
    }

    public void startXAnimation(float f2, float f3) {
        this.stopAll();
        this.animation = ValueAnimator.ofFloat((float[])new float[]{f2, f3});
        this.animation.setInterpolator((TimeInterpolator)new DecelerateInterpolator());
        this.animation.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new XAnimation());
        this.animation.setDuration(400L);
        this.animation.start();
    }

    public void startYAnimation(float f2, float f3) {
        this.stopAll();
        this.animation = ValueAnimator.ofFloat((float[])new float[]{f2, f3});
        this.animation.setInterpolator((TimeInterpolator)new DecelerateInterpolator());
        this.animation.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new YAnimation());
        this.animation.setDuration(400L);
        this.animation.start();
    }

    public void startZoomAnimation(float f2, float f3, float f4, float f5) {
        this.stopAll();
        this.animation = ValueAnimator.ofFloat((float[])new float[]{f4, f5});
        this.animation.setInterpolator((TimeInterpolator)new DecelerateInterpolator());
        ZoomAnimation zoomAnimation = new ZoomAnimation(f2, f3);
        this.animation.addUpdateListener((ValueAnimator.AnimatorUpdateListener)zoomAnimation);
        this.animation.addListener((Animator.AnimatorListener)zoomAnimation);
        this.animation.setDuration(400L);
        this.animation.start();
    }

    public void stopAll() {
        ValueAnimator valueAnimator = this.animation;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.animation = null;
        }
        this.stopFling();
    }

    public void stopFling() {
        if (this.flingAnimation != null) {
            this.scroller.forceFinished(true);
            this.flingAnimation.cancel();
            this.flingAnimation = null;
        }
    }

    class FlingAnimation
    implements Animator.AnimatorListener,
    ValueAnimator.AnimatorUpdateListener {
        FlingAnimation() {
        }

        public void onAnimationCancel(Animator animator) {
        }

        public void onAnimationEnd(Animator animator) {
            AnimationManager.this.pdfView.loadPages();
            AnimationManager.this.hideHandle();
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationStart(Animator animator) {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (!AnimationManager.this.scroller.isFinished()) {
                AnimationManager.this.scroller.computeScrollOffset();
                AnimationManager.this.pdfView.moveTo(AnimationManager.this.scroller.getCurrX(), AnimationManager.this.scroller.getCurrY());
                AnimationManager.this.pdfView.loadPageByOffset();
            }
        }
    }

    class XAnimation
    implements ValueAnimator.AnimatorUpdateListener {
        XAnimation() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float f2 = ((Float)valueAnimator.getAnimatedValue()).floatValue();
            AnimationManager.this.pdfView.moveTo(f2, AnimationManager.this.pdfView.getCurrentYOffset());
        }
    }

    class YAnimation
    implements ValueAnimator.AnimatorUpdateListener {
        YAnimation() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float f2 = ((Float)valueAnimator.getAnimatedValue()).floatValue();
            AnimationManager.this.pdfView.moveTo(AnimationManager.this.pdfView.getCurrentXOffset(), f2);
        }
    }

    class ZoomAnimation
    implements Animator.AnimatorListener,
    ValueAnimator.AnimatorUpdateListener {
        private final float centerX;
        private final float centerY;

        public ZoomAnimation(float f2, float f3) {
            this.centerX = f2;
            this.centerY = f3;
        }

        public void onAnimationCancel(Animator animator) {
        }

        public void onAnimationEnd(Animator animator) {
            AnimationManager.this.pdfView.loadPages();
            AnimationManager.this.hideHandle();
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationStart(Animator animator) {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float f2 = ((Float)valueAnimator.getAnimatedValue()).floatValue();
            AnimationManager.this.pdfView.zoomCenteredTo(f2, new PointF(this.centerX, this.centerY));
        }
    }

}

