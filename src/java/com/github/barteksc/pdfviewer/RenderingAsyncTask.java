/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.graphics.Matrix
 *  android.graphics.Rect
 *  android.graphics.RectF
 *  android.os.AsyncTask
 *  java.lang.Integer
 *  java.lang.InterruptedException
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.Void
 *  java.util.ArrayList
 *  java.util.Collections
 *  java.util.HashSet
 *  java.util.List
 *  java.util.Set
 */
package com.github.barteksc.pdfviewer;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.AsyncTask;
import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.model.PagePart;
import com.shockwave.pdfium.PdfDocument;
import com.shockwave.pdfium.PdfiumCore;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class RenderingAsyncTask
extends AsyncTask<Void, PagePart, Void> {
    private final Set<Integer> openedPages = new HashSet();
    private PdfDocument pdfDocument;
    private PDFView pdfView;
    private PdfiumCore pdfiumCore;
    private RectF renderBounds = new RectF();
    private Matrix renderMatrix = new Matrix();
    private final List<RenderingTask> renderingTasks;
    private Rect roundedRenderBounds = new Rect();

    public RenderingAsyncTask(PDFView pDFView, PdfiumCore pdfiumCore, PdfDocument pdfDocument) {
        this.pdfView = pDFView;
        this.pdfiumCore = pdfiumCore;
        this.pdfDocument = pdfDocument;
        this.renderingTasks = Collections.synchronizedList((List)new ArrayList());
    }

    private void calculateBounds(int n2, int n3, RectF rectF) {
        this.renderMatrix.reset();
        Matrix matrix = this.renderMatrix;
        float f2 = -rectF.left;
        float f3 = n2;
        float f4 = f2 * f3;
        float f5 = -rectF.top;
        float f6 = n3;
        matrix.postTranslate(f4, f5 * f6);
        this.renderMatrix.postScale(1.0f / rectF.width(), 1.0f / rectF.height());
        this.renderBounds.set(0.0f, 0.0f, f3, f6);
        this.renderMatrix.mapRect(this.renderBounds);
        this.renderBounds.round(this.roundedRenderBounds);
    }

    private PagePart proceed(RenderingTask renderingTask) {
        if (!this.openedPages.contains((Object)renderingTask.page)) {
            this.openedPages.add((Object)renderingTask.page);
            this.pdfiumCore.openPage(this.pdfDocument, renderingTask.page);
        }
        int n2 = Math.round((float)renderingTask.width);
        int n3 = Math.round((float)renderingTask.height);
        Bitmap bitmap = Bitmap.createBitmap((int)n2, (int)n3, (Bitmap.Config)Bitmap.Config.ARGB_8888);
        this.calculateBounds(n2, n3, renderingTask.bounds);
        if (!this.isCancelled()) {
            Bitmap bitmap2;
            this.pdfiumCore.renderPageBitmap(this.pdfDocument, bitmap, renderingTask.page, this.roundedRenderBounds.left, this.roundedRenderBounds.top, this.roundedRenderBounds.width(), this.roundedRenderBounds.height(), renderingTask.annotationRendering);
            if (!renderingTask.bestQuality) {
                Bitmap bitmap3 = bitmap.copy(Bitmap.Config.RGB_565, false);
                bitmap.recycle();
                bitmap2 = bitmap3;
            } else {
                bitmap2 = bitmap;
            }
            PagePart pagePart = new PagePart(renderingTask.userPage, renderingTask.page, bitmap2, renderingTask.width, renderingTask.height, renderingTask.bounds, renderingTask.thumbnail, renderingTask.cacheOrder);
            return pagePart;
        }
        bitmap.recycle();
        return null;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    private boolean waitForRenderingTasks() {
        try {
            List<RenderingTask> list;
            List<RenderingTask> list2 = list = this.renderingTasks;
            // MONITORENTER : list2
        }
        catch (InterruptedException interruptedException) {
            return false;
        }
        this.renderingTasks.wait();
        // MONITOREXIT : list2
        return true;
    }

    public void addRenderingTask(int n2, int n3, float f2, float f3, RectF rectF, boolean bl, int n4, boolean bl2, boolean bl3) {
        RenderingTask renderingTask = new RenderingTask(f2, f3, rectF, n2, n3, bl, n4, bl2, bl3);
        this.renderingTasks.add((Object)renderingTask);
        this.wakeUp();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    protected /* varargs */ Void doInBackground(Void ... arrvoid) {
        block4 : do {
            if (this.isCancelled()) {
                return null;
            }
            do {
                RenderingTask renderingTask;
                List<RenderingTask> list;
                List<RenderingTask> list2 = list = this.renderingTasks;
                synchronized (list2) {
                    if (this.renderingTasks.isEmpty()) break;
                    renderingTask = (RenderingTask)this.renderingTasks.get(0);
                    if (renderingTask == null) continue;
                }
                PagePart pagePart = this.proceed(renderingTask);
                if (pagePart == null) continue block4;
                if (this.renderingTasks.remove((Object)renderingTask)) {
                    this.publishProgress((Object[])new PagePart[]{pagePart});
                    continue;
                }
                pagePart.getRenderedBitmap().recycle();
            } while (true);
        } while (this.waitForRenderingTasks() && !this.isCancelled());
        return null;
    }

    protected /* varargs */ void onProgressUpdate(PagePart ... arrpagePart) {
        this.pdfView.onBitmapRendered(arrpagePart[0]);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void removeAllTasks() {
        List<RenderingTask> list;
        List<RenderingTask> list2 = list = this.renderingTasks;
        synchronized (list2) {
            this.renderingTasks.clear();
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void wakeUp() {
        List<RenderingTask> list;
        List<RenderingTask> list2 = list = this.renderingTasks;
        synchronized (list2) {
            this.renderingTasks.notify();
            return;
        }
    }

    private class RenderingTask {
        boolean annotationRendering;
        boolean bestQuality;
        RectF bounds;
        int cacheOrder;
        float height;
        int page;
        boolean thumbnail;
        int userPage;
        float width;

        public RenderingTask(float f2, float f3, RectF rectF, int n2, int n3, boolean bl, int n4, boolean bl2, boolean bl3) {
            this.page = n3;
            this.width = f2;
            this.height = f3;
            this.bounds = rectF;
            this.userPage = n2;
            this.thumbnail = bl;
            this.cacheOrder = n4;
            this.bestQuality = bl2;
            this.annotationRendering = bl3;
        }
    }

}

