/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.RectF
 *  java.lang.Object
 */
package com.github.barteksc.pdfviewer.model;

import android.graphics.Bitmap;
import android.graphics.RectF;

public class PagePart {
    private int cacheOrder;
    private float height;
    private int page;
    private RectF pageRelativeBounds;
    private Bitmap renderedBitmap;
    private boolean thumbnail;
    private int userPage;
    private float width;

    public PagePart(int n2, int n3, Bitmap bitmap, float f2, float f3, RectF rectF, boolean bl, int n4) {
        this.userPage = n2;
        this.page = n3;
        this.renderedBitmap = bitmap;
        this.pageRelativeBounds = rectF;
        this.thumbnail = bl;
        this.cacheOrder = n4;
    }

    public boolean equals(Object object) {
        if (!(object instanceof PagePart)) {
            return false;
        }
        PagePart pagePart = (PagePart)object;
        int n2 = pagePart.getPage();
        int n3 = this.page;
        boolean bl = false;
        if (n2 == n3) {
            int n4 = pagePart.getUserPage();
            int n5 = this.userPage;
            bl = false;
            if (n4 == n5) {
                float f2 = pagePart.getWidth() FCMPL this.width;
                bl = false;
                if (f2 == false) {
                    float f3 = pagePart.getHeight() FCMPL this.height;
                    bl = false;
                    if (f3 == false) {
                        float f4 = pagePart.getPageRelativeBounds().left FCMPL this.pageRelativeBounds.left;
                        bl = false;
                        if (f4 == false) {
                            float f5 = pagePart.getPageRelativeBounds().right FCMPL this.pageRelativeBounds.right;
                            bl = false;
                            if (f5 == false) {
                                float f6 = pagePart.getPageRelativeBounds().top FCMPL this.pageRelativeBounds.top;
                                bl = false;
                                if (f6 == false) {
                                    float f7 = pagePart.getPageRelativeBounds().bottom FCMPL this.pageRelativeBounds.bottom;
                                    bl = false;
                                    if (f7 == false) {
                                        bl = true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return bl;
    }

    public int getCacheOrder() {
        return this.cacheOrder;
    }

    public float getHeight() {
        return this.height;
    }

    public int getPage() {
        return this.page;
    }

    public RectF getPageRelativeBounds() {
        return this.pageRelativeBounds;
    }

    public Bitmap getRenderedBitmap() {
        return this.renderedBitmap;
    }

    public int getUserPage() {
        return this.userPage;
    }

    public float getWidth() {
        return this.width;
    }

    public boolean isThumbnail() {
        return this.thumbnail;
    }

    public void setCacheOrder(int n2) {
        this.cacheOrder = n2;
    }
}

