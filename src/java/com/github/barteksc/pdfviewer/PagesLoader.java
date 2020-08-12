/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.RectF
 *  android.util.Pair
 *  java.lang.Integer
 *  java.lang.Math
 *  java.lang.Object
 */
package com.github.barteksc.pdfviewer;

import android.graphics.RectF;
import android.util.Pair;
import com.github.barteksc.pdfviewer.CacheManager;
import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.RenderingAsyncTask;
import com.github.barteksc.pdfviewer.util.Constants;
import com.github.barteksc.pdfviewer.util.MathUtils;

class PagesLoader {
    private int cacheOrder;
    private float colWidth;
    private Pair<Integer, Integer> colsRows;
    private float pageRelativePartHeight;
    private float pageRelativePartWidth;
    private float partRenderHeight;
    private float partRenderWidth;
    private PDFView pdfView;
    private float rowHeight;
    private float scaledHeight;
    private float scaledWidth;
    private int thumbnailHeight;
    private final RectF thumbnailRect = new RectF(0.0f, 0.0f, 1.0f, 1.0f);
    private int thumbnailWidth;
    private float xOffset;
    private float yOffset;

    public PagesLoader(PDFView pDFView) {
        this.pdfView = pDFView;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private int documentPage(int n2) {
        int n3;
        if (this.pdfView.getFilteredUserPages() != null) {
            if (n2 < 0) return -1;
            if (n2 >= this.pdfView.getFilteredUserPages().length) {
                return -1;
            }
            n3 = this.pdfView.getFilteredUserPages()[n2];
        } else {
            n3 = n2;
        }
        if (n3 < 0) return -1;
        if (n2 < this.pdfView.getDocumentPageCount()) return n3;
        return -1;
    }

    private Holder getPageAndCoordsByOffset(float f2) {
        Holder holder = new Holder();
        float f3 = -MathUtils.max(f2, 0.0f);
        if (this.pdfView.isSwipeVertical()) {
            holder.page = MathUtils.floor(f3 / this.scaledHeight);
            holder.row = MathUtils.floor(Math.abs((float)(f3 - this.scaledHeight * (float)holder.page)) / this.rowHeight);
            holder.col = MathUtils.floor(this.xOffset / this.colWidth);
            return holder;
        }
        holder.page = MathUtils.floor(f3 / this.scaledWidth);
        holder.col = MathUtils.floor(Math.abs((float)(f3 - this.scaledWidth * (float)holder.page)) / this.colWidth);
        holder.row = MathUtils.floor(this.yOffset / this.rowHeight);
        return holder;
    }

    private Pair<Integer, Integer> getPageColsRows() {
        float f2 = 1.0f / this.pdfView.getOptimalPageWidth();
        float f3 = 256.0f * (1.0f / this.pdfView.getOptimalPageHeight()) / this.pdfView.getZoom();
        float f4 = f2 * 256.0f / this.pdfView.getZoom();
        int n2 = MathUtils.ceil(1.0f / f3);
        return new Pair((Object)MathUtils.ceil(1.0f / f4), (Object)n2);
    }

    private boolean loadCell(int n2, int n3, int n4, int n5, float f2, float f3) {
        float f4 = f2 * (float)n5;
        float f5 = f3 * (float)n4;
        float f6 = this.partRenderWidth;
        float f7 = this.partRenderHeight;
        float f8 = f4 + f2 > 1.0f ? 1.0f - f4 : f2;
        float f9 = f5 + f3 > 1.0f ? 1.0f - f5 : f3;
        float f10 = f6 * f8;
        float f11 = f7 * f9;
        RectF rectF = new RectF(f4, f5, f8 + f4, f9 + f5);
        if (f10 > 0.0f && f11 > 0.0f) {
            if (!this.pdfView.cacheManager.upPartIfContained(n2, n3, f10, f11, rectF, this.cacheOrder)) {
                this.pdfView.renderingAsyncTask.addRenderingTask(n2, n3, f10, f11, rectF, false, this.cacheOrder, this.pdfView.isBestQuality(), this.pdfView.isAnnotationRendering());
            }
            this.cacheOrder = 1 + this.cacheOrder;
            return true;
        }
        return false;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private int loadRelative(int var1_1, int var2_2, boolean var3_3) {
        block11 : {
            block10 : {
                var4_4 = this.pdfView.isSwipeVertical();
                var5_5 = 0;
                if (!var4_4) break block10;
                var6_6 = 1.0f + this.rowHeight * (float)var1_1;
                var7_7 = this.pdfView.getCurrentYOffset();
                if (!var3_3) ** GOTO lbl-1000
                var8_8 = this.pdfView.getHeight();
                break block11;
            }
            var6_6 = this.colWidth * (float)var1_1;
            var7_7 = this.pdfView.getCurrentXOffset();
            if (var3_3) {
                var8_8 = this.pdfView.getWidth();
            } else lbl-1000: // 2 sources:
            {
                var8_8 = 0;
            }
        }
        var9_9 = this.getPageAndCoordsByOffset(var7_7 - (float)var8_8 - var6_6);
        var10_10 = this.documentPage(var9_9.page);
        if (var10_10 < 0) {
            return 0;
        }
        this.loadThumbnail(var9_9.page, var10_10);
        if (this.pdfView.isSwipeVertical()) {
            var17_11 = MathUtils.min(-1 + MathUtils.floor(this.xOffset / this.colWidth), 0);
            var18_12 = MathUtils.max(1 + MathUtils.ceil((this.xOffset + (float)this.pdfView.getWidth()) / this.colWidth), (Integer)this.colsRows.first);
            while (var17_11 <= var18_12) {
                var19_13 = var9_9.page;
                var20_14 = var9_9.row;
                var21_15 = this.pageRelativePartWidth;
                var22_16 = this.pageRelativePartHeight;
                if (this.loadCell(var19_13, var10_10, var20_14, var17_11, var21_15, var22_16)) {
                    ++var5_5;
                }
                if (var5_5 >= var2_2) {
                    return var5_5;
                }
                ++var17_11;
            }
            return var5_5;
        }
        var11_17 = MathUtils.min(-1 + MathUtils.floor(this.yOffset / this.rowHeight), 0);
        var12_18 = MathUtils.max(1 + MathUtils.ceil((this.yOffset + (float)this.pdfView.getHeight()) / this.rowHeight), (Integer)this.colsRows.second);
        while (var11_17 <= var12_18) {
            var13_19 = var9_9.page;
            var14_20 = var9_9.col;
            var15_21 = this.pageRelativePartWidth;
            var16_22 = this.pageRelativePartHeight;
            if (this.loadCell(var13_19, var10_10, var11_17, var14_20, var15_21, var16_22)) {
                ++var5_5;
            }
            if (var5_5 >= var2_2) {
                return var5_5;
            }
            ++var11_17;
        }
        return var5_5;
    }

    private void loadThumbnail(int n2, int n3) {
        if (!this.pdfView.cacheManager.containsThumbnail(n2, n3, this.thumbnailWidth, this.thumbnailHeight, this.thumbnailRect)) {
            this.pdfView.renderingAsyncTask.addRenderingTask(n2, n3, this.thumbnailWidth, this.thumbnailHeight, this.thumbnailRect, true, 0, this.pdfView.isBestQuality(), this.pdfView.isAnnotationRendering());
        }
    }

    public void loadPages() {
        PDFView pDFView = this.pdfView;
        this.scaledHeight = pDFView.toCurrentScale(pDFView.getOptimalPageHeight());
        PDFView pDFView2 = this.pdfView;
        this.scaledWidth = pDFView2.toCurrentScale(pDFView2.getOptimalPageWidth());
        this.thumbnailWidth = (int)(0.3f * this.pdfView.getOptimalPageWidth());
        this.thumbnailHeight = (int)(0.3f * this.pdfView.getOptimalPageHeight());
        this.colsRows = this.getPageColsRows();
        this.xOffset = -MathUtils.max(this.pdfView.getCurrentXOffset(), 0.0f);
        this.yOffset = -MathUtils.max(this.pdfView.getCurrentYOffset(), 0.0f);
        this.rowHeight = this.scaledHeight / (float)((Integer)this.colsRows.second).intValue();
        this.colWidth = this.scaledWidth / (float)((Integer)this.colsRows.first).intValue();
        this.pageRelativePartWidth = 1.0f / (float)((Integer)this.colsRows.first).intValue();
        this.pageRelativePartHeight = 1.0f / (float)((Integer)this.colsRows.second).intValue();
        this.partRenderWidth = 256.0f / this.pageRelativePartWidth;
        this.partRenderHeight = 256.0f / this.pageRelativePartHeight;
        this.cacheOrder = 1;
        int n2 = this.loadVisible();
        boolean bl = this.pdfView.getScrollDir().equals((Object)PDFView.ScrollDir.END);
        if (bl) {
            for (int i2 = 0; i2 < 7 && n2 < Constants.Cache.CACHE_SIZE; n2 += this.loadRelative((int)i2, (int)n2, (boolean)true), ++i2) {
            }
        } else {
            for (int i3 = 0; i3 > -7 && n2 < Constants.Cache.CACHE_SIZE; n2 += this.loadRelative((int)i3, (int)n2, (boolean)false), --i3) {
            }
        }
    }

    public int loadVisible() {
        Holder holder;
        int n2;
        int n3;
        int n4;
        if (this.pdfView.isSwipeVertical()) {
            int n5;
            holder = this.getPageAndCoordsByOffset(this.pdfView.getCurrentYOffset());
            Holder holder2 = this.getPageAndCoordsByOffset(1.0f + (this.pdfView.getCurrentYOffset() - (float)this.pdfView.getHeight()));
            if (holder.page == holder2.page) {
                n5 = 1 + (holder2.row - holder.row);
            } else {
                int n6 = 0 + ((Integer)this.colsRows.second - holder.row);
                int n7 = holder.page;
                while (++n7 < holder2.page) {
                    n6 += ((Integer)this.colsRows.second).intValue();
                }
                n5 = n6 + (1 + holder2.row);
            }
            int n8 = 0;
            for (n4 = 0; n8 < n5 && n4 < Constants.Cache.CACHE_SIZE; n4 += this.loadRelative((int)n8, (int)(Constants.Cache.CACHE_SIZE - n4), (boolean)false), ++n8) {
            }
        } else {
            int n9;
            holder = this.getPageAndCoordsByOffset(this.pdfView.getCurrentXOffset());
            Holder holder3 = this.getPageAndCoordsByOffset(1.0f + (this.pdfView.getCurrentXOffset() - (float)this.pdfView.getWidth()));
            if (holder.page == holder3.page) {
                n9 = 1 + (holder3.col - holder.col);
            } else {
                int n10 = 0 + ((Integer)this.colsRows.first - holder.col);
                int n11 = holder.page;
                while (++n11 < holder3.page) {
                    n10 += ((Integer)this.colsRows.first).intValue();
                }
                n9 = n10 + (1 + holder3.col);
            }
            int n12 = 0;
            for (n4 = 0; n12 < n9 && n4 < Constants.Cache.CACHE_SIZE; n4 += this.loadRelative((int)n12, (int)(Constants.Cache.CACHE_SIZE - n4), (boolean)false), ++n12) {
            }
        }
        if ((n3 = this.documentPage(-1 + holder.page)) >= 0) {
            this.loadThumbnail(-1 + holder.page, n3);
        }
        if ((n2 = this.documentPage(1 + holder.page)) >= 0) {
            this.loadThumbnail(1 + holder.page, n2);
        }
        return n4;
    }

    private class Holder {
        int col;
        int page;
        int row;

        private Holder() {
        }
    }

}

