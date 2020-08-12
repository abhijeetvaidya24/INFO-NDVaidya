/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.PointF
 *  android.view.GestureDetector
 *  android.view.GestureDetector$OnDoubleTapListener
 *  android.view.GestureDetector$OnGestureListener
 *  android.view.MotionEvent
 *  android.view.ScaleGestureDetector
 *  android.view.ScaleGestureDetector$OnScaleGestureListener
 *  android.view.View
 *  android.view.View$OnTouchListener
 *  java.lang.Object
 */
package com.github.barteksc.pdfviewer;

import android.content.Context;
import android.graphics.PointF;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import com.github.barteksc.pdfviewer.AnimationManager;
import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.scroll.ScrollHandle;

class DragPinchManager
implements GestureDetector.OnDoubleTapListener,
GestureDetector.OnGestureListener,
ScaleGestureDetector.OnScaleGestureListener,
View.OnTouchListener {
    private AnimationManager animationManager;
    private GestureDetector gestureDetector;
    private boolean isSwipeEnabled;
    private PDFView pdfView;
    private ScaleGestureDetector scaleGestureDetector;
    private boolean scrolling = false;
    private boolean swipeVertical;

    public DragPinchManager(PDFView pDFView, AnimationManager animationManager) {
        this.pdfView = pDFView;
        this.animationManager = animationManager;
        this.isSwipeEnabled = false;
        this.swipeVertical = pDFView.isSwipeVertical();
        this.gestureDetector = new GestureDetector(pDFView.getContext(), (GestureDetector.OnGestureListener)this);
        this.scaleGestureDetector = new ScaleGestureDetector(pDFView.getContext(), (ScaleGestureDetector.OnScaleGestureListener)this);
        pDFView.setOnTouchListener((View.OnTouchListener)this);
    }

    private void hideHandle() {
        if (this.pdfView.getScrollHandle() != null && this.pdfView.getScrollHandle().shown()) {
            this.pdfView.getScrollHandle().hideDelayed();
        }
    }

    public void enableDoubletap(boolean bl) {
        if (bl) {
            this.gestureDetector.setOnDoubleTapListener((GestureDetector.OnDoubleTapListener)this);
            return;
        }
        this.gestureDetector.setOnDoubleTapListener(null);
    }

    public boolean isZooming() {
        return this.pdfView.isZooming();
    }

    public boolean onDoubleTap(MotionEvent motionEvent) {
        if (this.pdfView.getZoom() < this.pdfView.getMidZoom()) {
            this.pdfView.zoomWithAnimation(motionEvent.getX(), motionEvent.getY(), this.pdfView.getMidZoom());
        } else if (this.pdfView.getZoom() < this.pdfView.getMaxZoom()) {
            this.pdfView.zoomWithAnimation(motionEvent.getX(), motionEvent.getY(), this.pdfView.getMaxZoom());
        } else {
            this.pdfView.resetZoomWithAnimation();
        }
        return true;
    }

    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        return false;
    }

    public boolean onDown(MotionEvent motionEvent) {
        this.animationManager.stopFling();
        return true;
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        int n2 = (int)this.pdfView.getCurrentXOffset();
        int n3 = (int)this.pdfView.getCurrentYOffset();
        AnimationManager animationManager = this.animationManager;
        int n4 = (int)f2;
        int n5 = (int)f3;
        boolean bl = this.swipeVertical;
        int n6 = 2;
        int n7 = bl ? 2 : this.pdfView.getPageCount();
        int n8 = n2 * n7;
        if (this.swipeVertical) {
            n6 = this.pdfView.getPageCount();
        }
        animationManager.startFlingAnimation(n2, n3, n4, n5, n8, 0, n3 * n6, 0);
        return true;
    }

    public void onLongPress(MotionEvent motionEvent) {
    }

    /*
     * Enabled aggressive block sorting
     */
    public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
        float f2;
        block4 : {
            float f3;
            float f4;
            block3 : {
                float f5;
                block2 : {
                    f2 = scaleGestureDetector.getScaleFactor();
                    f5 = f2 * this.pdfView.getZoom();
                    if (!(f5 < (f3 = 1.0f))) break block2;
                    f4 = this.pdfView.getZoom();
                    break block3;
                }
                f3 = 10.0f;
                if (!(f5 > f3)) break block4;
                f4 = this.pdfView.getZoom();
            }
            f2 = f3 / f4;
        }
        this.pdfView.zoomCenteredRelativeTo(f2, new PointF(scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY()));
        return true;
    }

    public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
        return true;
    }

    public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
        this.pdfView.loadPages();
        this.hideHandle();
    }

    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        this.scrolling = true;
        if (this.isZooming() || this.isSwipeEnabled) {
            this.pdfView.moveRelativeTo(-f2, -f3);
        }
        this.pdfView.loadPageByOffset();
        return true;
    }

    public void onScrollEnd(MotionEvent motionEvent) {
        this.pdfView.loadPages();
        this.hideHandle();
    }

    public void onShowPress(MotionEvent motionEvent) {
    }

    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        ScrollHandle scrollHandle = this.pdfView.getScrollHandle();
        if (scrollHandle != null && !this.pdfView.documentFitsView()) {
            if (!scrollHandle.shown()) {
                scrollHandle.show();
            } else {
                scrollHandle.hide();
            }
        }
        this.pdfView.performClick();
        return true;
    }

    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean bl = this.scaleGestureDetector.onTouchEvent(motionEvent);
        boolean bl2 = this.gestureDetector.onTouchEvent(motionEvent) || bl;
        if (motionEvent.getAction() == 1 && this.scrolling) {
            this.scrolling = false;
            this.onScrollEnd(motionEvent);
        }
        return bl2;
    }

    public void setSwipeEnabled(boolean bl) {
        this.isSwipeEnabled = bl;
    }

    public void setSwipeVertical(boolean bl) {
        this.swipeVertical = bl;
    }
}

