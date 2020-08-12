/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.RectF
 *  java.lang.Object
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Comparator
 *  java.util.Iterator
 *  java.util.List
 *  java.util.PriorityQueue
 */
package com.github.barteksc.pdfviewer;

import android.graphics.Bitmap;
import android.graphics.RectF;
import com.github.barteksc.pdfviewer.model.PagePart;
import com.github.barteksc.pdfviewer.util.Constants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

class CacheManager {
    private final PriorityQueue<PagePart> activeCache = new PriorityQueue(Constants.Cache.CACHE_SIZE, (Comparator)this.comparator);
    private final PagePartComparator comparator = new PagePartComparator();
    private final Object passiveActiveLock = new Object();
    private final PriorityQueue<PagePart> passiveCache = new PriorityQueue(Constants.Cache.CACHE_SIZE, (Comparator)this.comparator);
    private final List<PagePart> thumbnails = new ArrayList();

    private static PagePart find(PriorityQueue<PagePart> priorityQueue, PagePart pagePart) {
        for (PagePart pagePart2 : priorityQueue) {
            if (!pagePart2.equals(pagePart)) continue;
            return pagePart2;
        }
        return null;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void makeAFreeSpace() {
        Object object;
        Object object2 = object = this.passiveActiveLock;
        synchronized (object2) {
            while (this.activeCache.size() + this.passiveCache.size() >= Constants.Cache.CACHE_SIZE && !this.passiveCache.isEmpty()) {
                ((PagePart)this.passiveCache.poll()).getRenderedBitmap().recycle();
            }
            while (this.activeCache.size() + this.passiveCache.size() >= Constants.Cache.CACHE_SIZE) {
                if (this.activeCache.isEmpty()) return;
                ((PagePart)this.activeCache.poll()).getRenderedBitmap().recycle();
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void cachePart(PagePart pagePart) {
        Object object;
        Object object2 = object = this.passiveActiveLock;
        synchronized (object2) {
            this.makeAFreeSpace();
            this.activeCache.offer((Object)pagePart);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void cacheThumbnail(PagePart pagePart) {
        List<PagePart> list;
        List<PagePart> list2 = list = this.thumbnails;
        synchronized (list2) {
            if (this.thumbnails.size() >= 6) {
                ((PagePart)this.thumbnails.remove(0)).getRenderedBitmap().recycle();
            }
            this.thumbnails.add((Object)pagePart);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean containsThumbnail(int n2, int n3, float f2, float f3, RectF rectF) {
        List<PagePart> list;
        PagePart pagePart = new PagePart(n2, n3, null, f2, f3, rectF, true, 0);
        List<PagePart> list2 = list = this.thumbnails;
        synchronized (list2) {
            Iterator iterator = this.thumbnails.iterator();
            do {
                if (!iterator.hasNext()) return false;
            } while (!((PagePart)iterator.next()).equals(pagePart));
            return true;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public List<PagePart> getPageParts() {
        Object object;
        Object object2 = object = this.passiveActiveLock;
        synchronized (object2) {
            ArrayList arrayList = new ArrayList(this.passiveCache);
            arrayList.addAll(this.activeCache);
            return arrayList;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public List<PagePart> getThumbnails() {
        List<PagePart> list;
        List<PagePart> list2 = list = this.thumbnails;
        synchronized (list2) {
            return this.thumbnails;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void makeANewSet() {
        Object object;
        Object object2 = object = this.passiveActiveLock;
        synchronized (object2) {
            this.passiveCache.addAll(this.activeCache);
            this.activeCache.clear();
            return;
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public void recycle() {
        List<PagePart> list;
        Object object;
        Object object2 = object = this.passiveActiveLock;
        // MONITORENTER : object2
        Iterator iterator = this.passiveCache.iterator();
        while (iterator.hasNext()) {
            ((PagePart)iterator.next()).getRenderedBitmap().recycle();
        }
        this.passiveCache.clear();
        Iterator iterator2 = this.activeCache.iterator();
        while (iterator2.hasNext()) {
            ((PagePart)iterator2.next()).getRenderedBitmap().recycle();
        }
        this.activeCache.clear();
        // MONITOREXIT : object2
        List<PagePart> list2 = list = this.thumbnails;
        Iterator iterator3 = this.thumbnails.iterator();
        do {
            if (!iterator3.hasNext()) {
                this.thumbnails.clear();
                // MONITOREXIT : list2
                return;
            }
            ((PagePart)iterator3.next()).getRenderedBitmap().recycle();
        } while (true);
        finally {
            // MONITORENTER : list2
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean upPartIfContained(int n2, int n3, float f2, float f3, RectF rectF, int n4) {
        Object object;
        PagePart pagePart = new PagePart(n2, n3, null, f2, f3, rectF, false, 0);
        Object object2 = object = this.passiveActiveLock;
        synchronized (object2) {
            PagePart pagePart2 = CacheManager.find(this.passiveCache, pagePart);
            boolean bl = true;
            if (pagePart2 != null) {
                this.passiveCache.remove((Object)pagePart2);
                pagePart2.setCacheOrder(n4);
                this.activeCache.offer((Object)pagePart2);
                return bl;
            }
            if (CacheManager.find(this.activeCache, pagePart) != null) return bl;
            return false;
        }
    }

    class PagePartComparator
    implements Comparator<PagePart> {
        PagePartComparator() {
        }

        public int compare(PagePart pagePart, PagePart pagePart2) {
            if (pagePart.getCacheOrder() == pagePart2.getCacheOrder()) {
                return 0;
            }
            if (pagePart.getCacheOrder() > pagePart2.getCacheOrder()) {
                return 1;
            }
            return -1;
        }
    }

}

