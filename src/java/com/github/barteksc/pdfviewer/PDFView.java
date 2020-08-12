/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.graphics.Paint$Style
 *  android.graphics.PointF
 *  android.graphics.Rect
 *  android.graphics.RectF
 *  android.graphics.drawable.Drawable
 *  android.os.AsyncTask
 *  android.util.AttributeSet
 *  android.util.Log
 *  android.widget.RelativeLayout
 *  com.github.barteksc.pdfviewer.source.AssetSource
 *  com.github.barteksc.pdfviewer.source.InputStreamSource
 *  java.io.InputStream
 *  java.lang.Enum
 *  java.lang.IllegalStateException
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.lang.Void
 *  java.util.ArrayList
 *  java.util.Iterator
 *  java.util.List
 *  java.util.concurrent.Executor
 */
package com.github.barteksc.pdfviewer;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.RelativeLayout;
import com.github.barteksc.pdfviewer.AnimationManager;
import com.github.barteksc.pdfviewer.CacheManager;
import com.github.barteksc.pdfviewer.DecodingAsyncTask;
import com.github.barteksc.pdfviewer.DragPinchManager;
import com.github.barteksc.pdfviewer.PagesLoader;
import com.github.barteksc.pdfviewer.RenderingAsyncTask;
import com.github.barteksc.pdfviewer.listener.OnDrawListener;
import com.github.barteksc.pdfviewer.listener.OnErrorListener;
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener;
import com.github.barteksc.pdfviewer.listener.OnPageChangeListener;
import com.github.barteksc.pdfviewer.listener.OnPageScrollListener;
import com.github.barteksc.pdfviewer.model.PagePart;
import com.github.barteksc.pdfviewer.scroll.ScrollHandle;
import com.github.barteksc.pdfviewer.source.AssetSource;
import com.github.barteksc.pdfviewer.source.DocumentSource;
import com.github.barteksc.pdfviewer.source.InputStreamSource;
import com.github.barteksc.pdfviewer.util.ArrayUtils;
import com.github.barteksc.pdfviewer.util.MathUtils;
import com.shockwave.pdfium.PdfDocument;
import com.shockwave.pdfium.PdfiumCore;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

public class PDFView
extends RelativeLayout {
    private static final String TAG = "PDFView";
    private AnimationManager animationManager;
    private boolean annotationRendering = false;
    private boolean bestQuality = false;
    CacheManager cacheManager;
    private int currentFilteredPage;
    private int currentPage;
    private float currentXOffset = 0.0f;
    private float currentYOffset = 0.0f;
    private Paint debugPaint;
    private DecodingAsyncTask decodingAsyncTask;
    private int defaultPage = 0;
    private int documentPageCount;
    private DragPinchManager dragPinchManager;
    private int[] filteredUserPageIndexes;
    private int[] filteredUserPages;
    private boolean isScrollHandleInit = false;
    private float maxZoom = 3.0f;
    private float midZoom = 1.75f;
    private float minZoom = 1.0f;
    private OnDrawListener onDrawListener;
    private OnErrorListener onErrorListener;
    private OnLoadCompleteListener onLoadCompleteListener;
    private OnPageChangeListener onPageChangeListener;
    private OnPageScrollListener onPageScrollListener;
    private float optimalPageHeight;
    private float optimalPageWidth;
    private int[] originalUserPages;
    private int pageHeight;
    private int pageWidth;
    private PagesLoader pagesLoader;
    private Paint paint;
    private PdfDocument pdfDocument;
    private PdfiumCore pdfiumCore;
    private boolean recycled = true;
    RenderingAsyncTask renderingAsyncTask;
    private ScrollDir scrollDir = ScrollDir.NONE;
    private ScrollHandle scrollHandle;
    private State state = State.DEFAULT;
    private boolean swipeVertical = true;
    private float zoom = 1.0f;

    public PDFView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        if (this.isInEditMode()) {
            return;
        }
        this.cacheManager = new CacheManager();
        this.animationManager = new AnimationManager(this);
        this.dragPinchManager = new DragPinchManager(this, this.animationManager);
        this.paint = new Paint();
        this.debugPaint = new Paint();
        this.debugPaint.setStyle(Paint.Style.STROKE);
        this.pdfiumCore = new PdfiumCore(context);
        this.setWillNotDraw(false);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private float calculateCenterOffsetForPage(int n2) {
        float f2;
        float f3;
        float f4;
        if (this.swipeVertical) {
            f3 = -((float)n2 * this.optimalPageHeight);
            f4 = this.getHeight() / 2;
            f2 = this.optimalPageHeight;
            do {
                return f3 + (f4 - f2 / 2.0f);
                break;
            } while (true);
        }
        f3 = -((float)n2 * this.optimalPageWidth);
        f4 = this.getWidth() / 2;
        f2 = this.optimalPageWidth;
        return f3 + (f4 - f2 / 2.0f);
    }

    private void calculateOptimalWidthAndHeight() {
        if (this.state != State.DEFAULT) {
            if (this.getWidth() == 0) {
                return;
            }
            float f2 = this.getWidth();
            float f3 = this.getHeight();
            float f4 = (float)this.pageWidth / (float)this.pageHeight;
            float f5 = (float)Math.floor((double)(f2 / f4));
            if (f5 > f3) {
                f2 = (float)Math.floor((double)(f4 * f3));
            } else {
                f3 = f5;
            }
            this.optimalPageWidth = f2;
            this.optimalPageHeight = f3;
        }
    }

    private int determineValidPageNumberFrom(int n2) {
        if (n2 <= 0) {
            return 0;
        }
        int[] arrn = this.originalUserPages;
        if (arrn != null) {
            if (n2 >= arrn.length) {
                return -1 + arrn.length;
            }
        } else {
            int n3 = this.documentPageCount;
            if (n2 >= n3) {
                return n3 - 1;
            }
        }
        return n2;
    }

    private void drawPart(Canvas canvas, PagePart pagePart) {
        float f2;
        float f3;
        RectF rectF = pagePart.getPageRelativeBounds();
        Bitmap bitmap = pagePart.getRenderedBitmap();
        if (bitmap.isRecycled()) {
            return;
        }
        if (this.swipeVertical) {
            f3 = this.toCurrentScale((float)pagePart.getUserPage() * this.optimalPageHeight);
            f2 = 0.0f;
        } else {
            f2 = this.toCurrentScale((float)pagePart.getUserPage() * this.optimalPageWidth);
            f3 = 0.0f;
        }
        canvas.translate(f2, f3);
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        float f4 = this.toCurrentScale(rectF.left * this.optimalPageWidth);
        float f5 = this.toCurrentScale(rectF.top * this.optimalPageHeight);
        float f6 = this.toCurrentScale(rectF.width() * this.optimalPageWidth);
        float f7 = this.toCurrentScale(rectF.height() * this.optimalPageHeight);
        RectF rectF2 = new RectF((float)((int)f4), (float)((int)f5), (float)((int)(f4 + f6)), (float)((int)(f5 + f7)));
        float f8 = f2 + this.currentXOffset;
        float f9 = f3 + this.currentYOffset;
        if (!(f8 + rectF2.left >= (float)this.getWidth() || f8 + rectF2.right <= 0.0f || f9 + rectF2.top >= (float)this.getHeight() || f9 + rectF2.bottom <= 0.0f)) {
            canvas.drawBitmap(bitmap, rect, rectF2, this.paint);
            canvas.translate(-f2, -f3);
            return;
        }
        canvas.translate(-f2, -f3);
    }

    private void load(DocumentSource documentSource, String string, OnLoadCompleteListener onLoadCompleteListener, OnErrorListener onErrorListener) {
        this.load(documentSource, string, onLoadCompleteListener, onErrorListener, null);
    }

    private void load(DocumentSource documentSource, String string, OnLoadCompleteListener onLoadCompleteListener, OnErrorListener onErrorListener, int[] arrn) {
        if (this.recycled) {
            if (arrn != null) {
                this.originalUserPages = arrn;
                this.filteredUserPages = ArrayUtils.deleteDuplicatedPages(this.originalUserPages);
                this.filteredUserPageIndexes = ArrayUtils.calculateIndexesInDuplicateArray(this.originalUserPages);
            }
            this.onLoadCompleteListener = onLoadCompleteListener;
            this.onErrorListener = onErrorListener;
            this.recycled = false;
            this.decodingAsyncTask = new DecodingAsyncTask(documentSource, string, this, this.pdfiumCore);
            this.decodingAsyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, (Object[])new Void[0]);
            return;
        }
        throw new IllegalStateException("Don't call load on a PDF View without recycling it first.");
    }

    private void setDefaultPage(int n2) {
        this.defaultPage = n2;
    }

    private void setOnDrawListener(OnDrawListener onDrawListener) {
        this.onDrawListener = onDrawListener;
    }

    private void setOnPageChangeListener(OnPageChangeListener onPageChangeListener) {
        this.onPageChangeListener = onPageChangeListener;
    }

    private void setOnPageScrollListener(OnPageScrollListener onPageScrollListener) {
        this.onPageScrollListener = onPageScrollListener;
    }

    private void setScrollHandle(ScrollHandle scrollHandle) {
        this.scrollHandle = scrollHandle;
    }

    public boolean documentFitsView() {
        if (this.swipeVertical) {
            return (float)this.getPageCount() * this.optimalPageHeight < (float)this.getHeight();
        }
        return (float)this.getPageCount() * this.optimalPageWidth < (float)this.getWidth();
    }

    public void enableAnnotationRendering(boolean bl) {
        this.annotationRendering = bl;
    }

    public void enableDoubletap(boolean bl) {
        this.dragPinchManager.enableDoubletap(bl);
    }

    public void enableSwipe(boolean bl) {
        this.dragPinchManager.setSwipeEnabled(bl);
    }

    public Configurator fromAsset(String string) {
        return new Configurator((DocumentSource)new AssetSource(string));
    }

    public Configurator fromStream(InputStream inputStream) {
        return new Configurator((DocumentSource)new InputStreamSource(inputStream));
    }

    public int getCurrentPage() {
        return this.currentPage;
    }

    public float getCurrentXOffset() {
        return this.currentXOffset;
    }

    public float getCurrentYOffset() {
        return this.currentYOffset;
    }

    public PdfDocument.Meta getDocumentMeta() {
        PdfDocument pdfDocument = this.pdfDocument;
        if (pdfDocument == null) {
            return null;
        }
        return this.pdfiumCore.getDocumentMeta(pdfDocument);
    }

    int getDocumentPageCount() {
        return this.documentPageCount;
    }

    int[] getFilteredUserPages() {
        return this.filteredUserPages;
    }

    public float getMaxZoom() {
        return this.maxZoom;
    }

    public float getMidZoom() {
        return this.midZoom;
    }

    public float getMinZoom() {
        return this.minZoom;
    }

    OnPageChangeListener getOnPageChangeListener() {
        return this.onPageChangeListener;
    }

    OnPageScrollListener getOnPageScrollListener() {
        return this.onPageScrollListener;
    }

    public float getOptimalPageHeight() {
        return this.optimalPageHeight;
    }

    public float getOptimalPageWidth() {
        return this.optimalPageWidth;
    }

    public int getPageCount() {
        int[] arrn = this.originalUserPages;
        if (arrn != null) {
            return arrn.length;
        }
        return this.documentPageCount;
    }

    public float getPositionOffset() {
        float f2;
        int n2;
        float f3;
        if (this.swipeVertical) {
            f2 = -this.currentYOffset;
            f3 = (float)this.getPageCount() * this.toCurrentScale(this.optimalPageHeight);
            n2 = this.getHeight();
        } else {
            f2 = -this.currentXOffset;
            f3 = (float)this.getPageCount() * this.toCurrentScale(this.optimalPageWidth);
            n2 = this.getWidth();
        }
        return MathUtils.limit(f2 / (f3 - (float)n2), 0.0f, 1.0f);
    }

    ScrollDir getScrollDir() {
        return this.scrollDir;
    }

    ScrollHandle getScrollHandle() {
        return this.scrollHandle;
    }

    public List<PdfDocument.Bookmark> getTableOfContents() {
        PdfDocument pdfDocument = this.pdfDocument;
        if (pdfDocument == null) {
            return new ArrayList();
        }
        return this.pdfiumCore.getTableOfContents(pdfDocument);
    }

    public float getZoom() {
        return this.zoom;
    }

    public boolean isAnnotationRendering() {
        return this.annotationRendering;
    }

    public boolean isBestQuality() {
        return this.bestQuality;
    }

    public boolean isSwipeVertical() {
        return this.swipeVertical;
    }

    public boolean isZooming() {
        return this.zoom != this.minZoom;
    }

    public void jumpTo(int n2, boolean bl) {
        if (this.swipeVertical) {
            float f2 = (float)(-n2) * this.toCurrentScale(this.optimalPageHeight);
            if (bl) {
                this.animationManager.startYAnimation(this.currentYOffset, f2);
            } else {
                this.moveTo(this.currentXOffset, f2);
            }
        } else {
            float f3 = (float)(-n2) * this.toCurrentScale(this.optimalPageWidth);
            if (bl) {
                this.animationManager.startXAnimation(this.currentXOffset, f3);
            } else {
                this.moveTo(f3, this.currentYOffset);
            }
        }
        this.showPage(n2);
    }

    public void loadComplete(PdfDocument pdfDocument) {
        this.state = State.LOADED;
        this.documentPageCount = this.pdfiumCore.getPageCount(pdfDocument);
        int[] arrn = this.originalUserPages;
        int n2 = arrn != null ? arrn[0] : 0;
        this.pdfDocument = pdfDocument;
        this.pdfiumCore.openPage(pdfDocument, n2);
        this.pageWidth = this.pdfiumCore.getPageWidth(pdfDocument, n2);
        this.pageHeight = this.pdfiumCore.getPageHeight(pdfDocument, n2);
        this.calculateOptimalWidthAndHeight();
        this.pagesLoader = new PagesLoader(this);
        this.renderingAsyncTask = new RenderingAsyncTask(this, this.pdfiumCore, pdfDocument);
        this.renderingAsyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, (Object[])new Void[0]);
        ScrollHandle scrollHandle = this.scrollHandle;
        if (scrollHandle != null) {
            scrollHandle.setupLayout(this);
            this.isScrollHandleInit = true;
        }
        this.jumpTo(this.defaultPage, false);
        OnLoadCompleteListener onLoadCompleteListener = this.onLoadCompleteListener;
        if (onLoadCompleteListener != null) {
            onLoadCompleteListener.loadComplete(this.documentPageCount);
        }
    }

    public void loadError(Throwable throwable) {
        this.state = State.ERROR;
        this.recycle();
        this.invalidate();
        OnErrorListener onErrorListener = this.onErrorListener;
        if (onErrorListener != null) {
            onErrorListener.onError(throwable);
            return;
        }
        Log.e((String)TAG, (String)"load pdf error", (Throwable)throwable);
    }

    void loadPageByOffset() {
        float f2;
        float f3;
        if (this.swipeVertical) {
            f2 = this.currentYOffset;
            f3 = this.optimalPageHeight;
        } else {
            f2 = this.currentXOffset;
            f3 = this.optimalPageWidth;
        }
        int n2 = (int)Math.floor((double)((Math.abs((float)f2) + (float)(this.getHeight() / 5)) / this.toCurrentScale(f3)));
        if (n2 >= 0 && n2 <= -1 + this.getPageCount() && n2 != this.getCurrentPage()) {
            this.showPage(n2);
            return;
        }
        this.loadPages();
    }

    public void loadPages() {
        if (this.optimalPageWidth != 0.0f) {
            if (this.optimalPageHeight == 0.0f) {
                return;
            }
            this.renderingAsyncTask.removeAllTasks();
            this.cacheManager.makeANewSet();
            this.pagesLoader.loadPages();
            this.redraw();
        }
    }

    public void moveRelativeTo(float f2, float f3) {
        this.moveTo(f2 + this.currentXOffset, f3 + this.currentYOffset);
    }

    public void moveTo(float f2, float f3) {
        this.moveTo(f2, f3, true);
    }

    /*
     * Enabled aggressive block sorting
     */
    public void moveTo(float f2, float f3, boolean bl) {
        OnPageScrollListener onPageScrollListener;
        block23 : {
            block27 : {
                float f4;
                float f5;
                block25 : {
                    block26 : {
                        block24 : {
                            block18 : {
                                block22 : {
                                    float f6;
                                    float f7;
                                    block20 : {
                                        block21 : {
                                            block19 : {
                                                if (!this.swipeVertical) break block18;
                                                if (!(this.toCurrentScale(this.optimalPageWidth) < (float)this.getWidth())) break block19;
                                                f7 = this.getWidth() / 2;
                                                f6 = this.toCurrentScale(this.optimalPageWidth) / 2.0f;
                                                break block20;
                                            }
                                            if (!(f2 > 0.0f)) break block21;
                                            f2 = 0.0f;
                                            break block22;
                                        }
                                        if (!(f2 + this.toCurrentScale(this.optimalPageWidth) < (float)this.getWidth())) break block22;
                                        f7 = this.getWidth();
                                        f6 = this.toCurrentScale(this.optimalPageWidth);
                                    }
                                    f2 = f7 - f6;
                                }
                                if ((float)this.getPageCount() * this.toCurrentScale(this.optimalPageHeight) < (float)this.getHeight()) {
                                    f3 = ((float)this.getHeight() - (float)this.getPageCount() * this.toCurrentScale(this.optimalPageHeight)) / 2.0f;
                                } else if (f3 > 0.0f) {
                                    f3 = 0.0f;
                                } else if (f3 + this.toCurrentScale((float)this.getPageCount() * this.optimalPageHeight) < (float)this.getHeight()) {
                                    f3 = -this.toCurrentScale((float)this.getPageCount() * this.optimalPageHeight) + (float)this.getHeight();
                                }
                                float f8 = this.currentYOffset;
                                this.scrollDir = f3 < f8 ? ScrollDir.END : (f3 > f8 ? ScrollDir.START : ScrollDir.NONE);
                                break block23;
                            }
                            if (!(this.toCurrentScale(this.optimalPageHeight) < (float)this.getHeight())) break block24;
                            f5 = this.getHeight() / 2;
                            f4 = this.toCurrentScale(this.optimalPageHeight) / 2.0f;
                            break block25;
                        }
                        if (!(f3 > 0.0f)) break block26;
                        f3 = 0.0f;
                        break block27;
                    }
                    if (!(f3 + this.toCurrentScale(this.optimalPageHeight) < (float)this.getHeight())) break block27;
                    f5 = this.getHeight();
                    f4 = this.toCurrentScale(this.optimalPageHeight);
                }
                f3 = f5 - f4;
            }
            if ((float)this.getPageCount() * this.toCurrentScale(this.optimalPageWidth) < (float)this.getWidth()) {
                f2 = ((float)this.getWidth() - (float)this.getPageCount() * this.toCurrentScale(this.optimalPageWidth)) / 2.0f;
            } else if (f2 > 0.0f) {
                f2 = 0.0f;
            } else if (f2 + this.toCurrentScale((float)this.getPageCount() * this.optimalPageWidth) < (float)this.getWidth()) {
                f2 = -this.toCurrentScale((float)this.getPageCount() * this.optimalPageWidth) + (float)this.getWidth();
            }
            float f9 = this.currentXOffset;
            this.scrollDir = f2 < f9 ? ScrollDir.END : (f2 > f9 ? ScrollDir.START : ScrollDir.NONE);
        }
        this.currentXOffset = f2;
        this.currentYOffset = f3;
        float f10 = this.getPositionOffset();
        if (bl && this.scrollHandle != null && !this.documentFitsView()) {
            this.scrollHandle.setScroll(f10);
        }
        if ((onPageScrollListener = this.onPageScrollListener) != null) {
            onPageScrollListener.onPageScrolled(this.getCurrentPage(), f10);
        }
        this.redraw();
    }

    public void onBitmapRendered(PagePart pagePart) {
        if (pagePart.isThumbnail()) {
            this.cacheManager.cacheThumbnail(pagePart);
        } else {
            this.cacheManager.cachePart(pagePart);
        }
        this.redraw();
    }

    protected void onDetachedFromWindow() {
        this.recycle();
        super.onDetachedFromWindow();
    }

    protected void onDraw(Canvas canvas) {
        if (this.isInEditMode()) {
            return;
        }
        Drawable drawable2 = this.getBackground();
        if (drawable2 == null) {
            canvas.drawColor(-1);
        } else {
            drawable2.draw(canvas);
        }
        if (this.recycled) {
            return;
        }
        if (this.state != State.SHOWN) {
            return;
        }
        float f2 = this.currentXOffset;
        float f3 = this.currentYOffset;
        canvas.translate(f2, f3);
        Iterator iterator = this.cacheManager.getThumbnails().iterator();
        while (iterator.hasNext()) {
            this.drawPart(canvas, (PagePart)iterator.next());
        }
        Iterator iterator2 = this.cacheManager.getPageParts().iterator();
        while (iterator2.hasNext()) {
            this.drawPart(canvas, (PagePart)iterator2.next());
        }
        if (this.onDrawListener != null) {
            canvas.translate(this.toCurrentScale((float)this.currentFilteredPage * this.optimalPageWidth), 0.0f);
            this.onDrawListener.onLayerDrawn(canvas, this.toCurrentScale(this.optimalPageWidth), this.toCurrentScale(this.optimalPageHeight), this.currentPage);
            canvas.translate(-this.toCurrentScale((float)this.currentFilteredPage * this.optimalPageWidth), 0.0f);
        }
        canvas.translate(-f2, -f3);
    }

    protected void onSizeChanged(int n2, int n3, int n4, int n5) {
        if (this.isInEditMode()) {
            return;
        }
        this.animationManager.stopAll();
        this.calculateOptimalWidthAndHeight();
        this.loadPages();
        if (this.swipeVertical) {
            this.moveTo(this.currentXOffset, this.calculateCenterOffsetForPage(this.currentFilteredPage));
            return;
        }
        this.moveTo(this.calculateCenterOffsetForPage(this.currentFilteredPage), this.currentYOffset);
    }

    public void recycle() {
        PdfiumCore pdfiumCore;
        PdfDocument pdfDocument;
        DecodingAsyncTask decodingAsyncTask;
        this.animationManager.stopAll();
        RenderingAsyncTask renderingAsyncTask = this.renderingAsyncTask;
        if (renderingAsyncTask != null) {
            renderingAsyncTask.cancel(true);
        }
        if ((decodingAsyncTask = this.decodingAsyncTask) != null) {
            decodingAsyncTask.cancel(true);
        }
        this.cacheManager.recycle();
        ScrollHandle scrollHandle = this.scrollHandle;
        if (scrollHandle != null && this.isScrollHandleInit) {
            scrollHandle.destroyLayout();
        }
        if ((pdfiumCore = this.pdfiumCore) != null && (pdfDocument = this.pdfDocument) != null) {
            pdfiumCore.closeDocument(pdfDocument);
        }
        this.originalUserPages = null;
        this.filteredUserPages = null;
        this.filteredUserPageIndexes = null;
        this.pdfDocument = null;
        this.scrollHandle = null;
        this.isScrollHandleInit = false;
        this.currentYOffset = 0.0f;
        this.currentXOffset = 0.0f;
        this.zoom = 1.0f;
        this.recycled = true;
        this.state = State.DEFAULT;
    }

    void redraw() {
        this.invalidate();
    }

    public void resetZoomWithAnimation() {
        this.zoomWithAnimation(this.minZoom);
    }

    public void setMaxZoom(float f2) {
        this.maxZoom = f2;
    }

    public void setMidZoom(float f2) {
        this.midZoom = f2;
    }

    public void setMinZoom(float f2) {
        this.minZoom = f2;
    }

    public void setPositionOffset(float f2) {
        this.setPositionOffset(f2, true);
    }

    public void setPositionOffset(float f2, boolean bl) {
        if (this.swipeVertical) {
            this.moveTo(this.currentXOffset, f2 * ((float)(-this.getPageCount()) * this.toCurrentScale(this.optimalPageHeight) + (float)this.getHeight()), bl);
        } else {
            this.moveTo(f2 * ((float)(-this.getPageCount()) * this.toCurrentScale(this.optimalPageWidth) + (float)this.getWidth()), this.currentYOffset, bl);
        }
        this.loadPageByOffset();
    }

    public void setSwipeVertical(boolean bl) {
        this.swipeVertical = bl;
    }

    void showPage(int n2) {
        OnPageChangeListener onPageChangeListener;
        int n3;
        if (this.recycled) {
            return;
        }
        this.state = State.SHOWN;
        this.currentPage = n3 = this.determineValidPageNumberFrom(n2);
        this.currentFilteredPage = n3;
        int[] arrn = this.filteredUserPageIndexes;
        if (arrn != null && n3 >= 0 && n3 < arrn.length) {
            this.currentFilteredPage = arrn[n3];
        }
        this.loadPages();
        if (this.scrollHandle != null && !this.documentFitsView()) {
            this.scrollHandle.setPageNum(1 + this.currentPage);
        }
        if ((onPageChangeListener = this.onPageChangeListener) != null) {
            onPageChangeListener.onPageChanged(this.currentPage, this.getPageCount());
        }
    }

    public void stopFling() {
        this.animationManager.stopFling();
    }

    public float toCurrentScale(float f2) {
        return f2 * this.zoom;
    }

    public void useBestQuality(boolean bl) {
        this.bestQuality = bl;
    }

    public void zoomCenteredRelativeTo(float f2, PointF pointF) {
        this.zoomCenteredTo(f2 * this.zoom, pointF);
    }

    public void zoomCenteredTo(float f2, PointF pointF) {
        float f3 = f2 / this.zoom;
        this.zoomTo(f2);
        float f4 = f3 * this.currentXOffset;
        float f5 = f3 * this.currentYOffset;
        this.moveTo(f4 + (pointF.x - f3 * pointF.x), f5 + (pointF.y - f3 * pointF.y));
    }

    public void zoomTo(float f2) {
        this.zoom = f2;
    }

    public void zoomWithAnimation(float f2) {
        this.animationManager.startZoomAnimation(this.getWidth() / 2, this.getHeight() / 2, this.zoom, f2);
    }

    public void zoomWithAnimation(float f2, float f3, float f4) {
        this.animationManager.startZoomAnimation(f2, f3, this.zoom, f4);
    }

    public class Configurator {
        private boolean annotationRendering = false;
        private int defaultPage = 0;
        private final DocumentSource documentSource;
        private boolean enableDoubletap = true;
        private boolean enableSwipe = true;
        private OnDrawListener onDrawListener;
        private OnErrorListener onErrorListener;
        private OnLoadCompleteListener onLoadCompleteListener;
        private OnPageChangeListener onPageChangeListener;
        private OnPageScrollListener onPageScrollListener;
        private int[] pageNumbers = null;
        private String password = null;
        private ScrollHandle scrollHandle = null;
        private boolean swipeHorizontal = false;

        private Configurator(DocumentSource documentSource) {
            this.documentSource = documentSource;
        }

        public Configurator defaultPage(int n2) {
            this.defaultPage = n2;
            return this;
        }

        public Configurator enableAnnotationRendering(boolean bl) {
            this.annotationRendering = bl;
            return this;
        }

        public Configurator enableDoubletap(boolean bl) {
            this.enableDoubletap = bl;
            return this;
        }

        public Configurator enableSwipe(boolean bl) {
            this.enableSwipe = bl;
            return this;
        }

        public void load() {
            PDFView.this.recycle();
            PDFView.this.setOnDrawListener(this.onDrawListener);
            PDFView.this.setOnPageChangeListener(this.onPageChangeListener);
            PDFView.this.setOnPageScrollListener(this.onPageScrollListener);
            PDFView.this.enableSwipe(this.enableSwipe);
            PDFView.this.enableDoubletap(this.enableDoubletap);
            PDFView.this.setDefaultPage(this.defaultPage);
            PDFView.this.setSwipeVertical(true ^ this.swipeHorizontal);
            PDFView.this.enableAnnotationRendering(this.annotationRendering);
            PDFView.this.setScrollHandle(this.scrollHandle);
            PDFView.this.dragPinchManager.setSwipeVertical(PDFView.this.swipeVertical);
            int[] arrn = this.pageNumbers;
            if (arrn != null) {
                PDFView.this.load(this.documentSource, this.password, this.onLoadCompleteListener, this.onErrorListener, arrn);
                return;
            }
            PDFView.this.load(this.documentSource, this.password, this.onLoadCompleteListener, this.onErrorListener);
        }

        public Configurator onDraw(OnDrawListener onDrawListener) {
            this.onDrawListener = onDrawListener;
            return this;
        }

        public Configurator onError(OnErrorListener onErrorListener) {
            this.onErrorListener = onErrorListener;
            return this;
        }

        public Configurator onLoad(OnLoadCompleteListener onLoadCompleteListener) {
            this.onLoadCompleteListener = onLoadCompleteListener;
            return this;
        }

        public Configurator onPageChange(OnPageChangeListener onPageChangeListener) {
            this.onPageChangeListener = onPageChangeListener;
            return this;
        }

        public Configurator password(String string) {
            this.password = string;
            return this;
        }

        public Configurator scrollHandle(ScrollHandle scrollHandle) {
            this.scrollHandle = scrollHandle;
            return this;
        }
    }

    static final class ScrollDir
    extends Enum<ScrollDir> {
        private static final /* synthetic */ ScrollDir[] $VALUES;
        public static final /* enum */ ScrollDir END;
        public static final /* enum */ ScrollDir NONE;
        public static final /* enum */ ScrollDir START;

        static {
            NONE = new ScrollDir();
            START = new ScrollDir();
            END = new ScrollDir();
            ScrollDir[] arrscrollDir = new ScrollDir[]{NONE, START, END};
            $VALUES = arrscrollDir;
        }

        public static ScrollDir valueOf(String string) {
            return (ScrollDir)Enum.valueOf(ScrollDir.class, (String)string);
        }

        public static ScrollDir[] values() {
            return (ScrollDir[])$VALUES.clone();
        }
    }

    private static final class State
    extends Enum<State> {
        private static final /* synthetic */ State[] $VALUES;
        public static final /* enum */ State DEFAULT = new State();
        public static final /* enum */ State ERROR;
        public static final /* enum */ State LOADED;
        public static final /* enum */ State SHOWN;

        static {
            LOADED = new State();
            SHOWN = new State();
            ERROR = new State();
            State[] arrstate = new State[]{DEFAULT, LOADED, SHOWN, ERROR};
            $VALUES = arrstate;
        }

        public static State valueOf(String string) {
            return (State)Enum.valueOf(State.class, (String)string);
        }

        public static State[] values() {
            return (State[])$VALUES.clone();
        }
    }

}

