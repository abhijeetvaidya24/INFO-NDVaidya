/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.graphics.Rect
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewParent
 *  android.widget.ListView
 *  com.amazon.device.ads.AdController
 *  com.amazon.device.ads.MobileAdsLogger
 *  java.lang.Comparable
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.Collections
 *  java.util.List
 */
package com.amazon.device.ads;

import android.annotation.TargetApi;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ListView;
import com.amazon.device.ads.AdController;
import com.amazon.device.ads.AndroidTargetUtils;
import com.amazon.device.ads.MobileAdsLogger;
import com.amazon.device.ads.MobileAdsLoggerFactory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class ViewabilityOverlapCalculator {
    private static final String LOGTAG = "ViewabilityOverlapCalculator";
    private final AdController adController;
    private final MobileAdsLogger logger;
    private View rootView;
    private Rect visibleAdRectangle;

    public ViewabilityOverlapCalculator(AdController adController) {
        this(adController, new MobileAdsLoggerFactory());
    }

    ViewabilityOverlapCalculator(AdController adController, MobileAdsLoggerFactory mobileAdsLoggerFactory) {
        this.adController = adController;
        this.logger = mobileAdsLoggerFactory.createMobileAdsLogger(LOGTAG);
    }

    private int computeArea(Range range, List<Range> list) {
        int n = range.high - range.low;
        int n2 = 0;
        for (int i2 = 0; i2 < list.size(); ++i2) {
            Range range2 = (Range)list.get(i2);
            n2 += n * (range2.high - range2.low);
        }
        return n2;
    }

    @TargetApi(value=11)
    private void findOverlapppingViews(Rectangle rectangle, int n, ViewGroup viewGroup, List<Rectangle> list, boolean bl) {
        if (viewGroup != null && bl && AndroidTargetUtils.isAdTransparent((View)viewGroup)) {
            list.add((Object)new Rectangle(this.visibleAdRectangle));
            return;
        }
        for (int i2 = n; i2 < viewGroup.getChildCount(); ++i2) {
            Rectangle rectangle2;
            View view = viewGroup.getChildAt(i2);
            boolean bl2 = view != null && view instanceof ListView;
            if (!view.isShown() || AndroidTargetUtils.isAtLeastAndroidAPI(11) && view.getAlpha() == 0.0f || !(rectangle2 = this.getViewRectangle(view)).intersect(rectangle)) continue;
            if (!bl2 && view instanceof ViewGroup) {
                this.findOverlapppingViews(rectangle, 0, (ViewGroup)view, list, false);
                continue;
            }
            this.logger.d("Overlap found with View: %s", new Object[]{view});
            list.add((Object)rectangle2);
        }
        if (!bl) {
            return;
        }
        if (this.rootView.equals((Object)viewGroup)) {
            return;
        }
        ViewParent viewParent = viewGroup.getParent();
        if (viewParent != null) {
            if (!(viewParent instanceof ViewGroup)) {
                return;
            }
            ViewGroup viewGroup2 = (ViewGroup)viewParent;
            this.findOverlapppingViews(rectangle, 1 + viewGroup2.indexOfChild((View)viewGroup), viewGroup2, list, true);
        }
    }

    private Rectangle getViewRectangle(View view) {
        int[] arrn = new int[2];
        view.getLocationOnScreen(arrn);
        Rectangle rectangle = new Rectangle(arrn[0], arrn[1], view.getWidth() + arrn[0], view.getHeight() + arrn[1]);
        return rectangle;
    }

    public float calculateViewablePercentage(View view, Rect rect) {
        int n = view.getWidth() * view.getHeight();
        float f2 = n;
        if (f2 == 0.0f) {
            return 0.0f;
        }
        this.visibleAdRectangle = rect;
        if (this.rootView == null) {
            this.rootView = this.adController.getRootView();
        }
        ArrayList arrayList = new ArrayList();
        ViewGroup viewGroup = (ViewGroup)view.getParent();
        if (viewGroup == null) {
            this.logger.d("AdContainer is null");
            return 0.0f;
        }
        int n2 = viewGroup.indexOfChild(view);
        this.findOverlapppingViews(new Rectangle(rect), n2 + 1, viewGroup, (List<Rectangle>)arrayList, true);
        int n3 = this.getTotalAreaOfSetOfRectangles((List<Rectangle>)arrayList);
        int n4 = rect.width() * rect.height() - n3;
        MobileAdsLogger mobileAdsLogger = this.logger;
        Object[] arrobject = new Object[]{n4, n};
        mobileAdsLogger.d("Visible area: %s , Total area: %s", arrobject);
        return 100.0f * ((float)n4 / f2);
    }

    protected int getTotalAreaOfSetOfRectangles(List<Rectangle> list) {
        int[] arrn = new int[2 * list.size()];
        int n = 0;
        for (int i2 = 0; i2 < list.size(); ++i2) {
            Rectangle rectangle = (Rectangle)list.get(i2);
            int n2 = i2 * 2;
            arrn[n2] = rectangle.getLeft();
            arrn[n2 + 1] = rectangle.getRight();
        }
        Arrays.sort((int[])arrn);
        Collections.sort(list);
        int n3 = 0;
        while (n < -1 + arrn.length) {
            int n4;
            int n5 = arrn[n];
            if (n5 == (n4 = arrn[++n])) continue;
            Range range = new Range(n5, n4);
            n3 += this.computeArea(range, this.getYRanges(range, list));
        }
        return n3;
    }

    protected List<Range> getYRanges(Range range, List<Rectangle> list) {
        ArrayList arrayList = new ArrayList();
        Range range2 = null;
        for (int i2 = 0; i2 < list.size(); ++i2) {
            Rectangle rectangle = (Rectangle)list.get(i2);
            if (range.low >= rectangle.getRight() || range.high <= rectangle.getLeft()) continue;
            Range range3 = new Range(rectangle.getTop(), rectangle.getBottom());
            if (range2 == null) {
                arrayList.add((Object)range3);
            } else {
                if (range3.isOverlap(range2)) {
                    range2.mergeRange(range3);
                    continue;
                }
                arrayList.add((Object)range3);
            }
            range2 = range3;
        }
        return arrayList;
    }

    class Range {
        int high;
        int low;

        public Range(int n, int n2) {
            this.low = n;
            this.high = n2;
        }

        public boolean isOverlap(Range range) {
            return this.low <= range.high && this.high >= range.low;
        }

        public void mergeRange(Range range) {
            int n = this.low;
            int n2 = range.low;
            if (n > n2) {
                n = n2;
            }
            this.low = n;
            int n3 = this.high;
            int n4 = range.high;
            if (n3 >= n4) {
                n4 = n3;
            }
            this.high = n4;
        }
    }

    class Rectangle
    implements Comparable<Rectangle> {
        private final Rect rect;

        public Rectangle(int n, int n2, int n3, int n4) {
            Rect rect = this.rect = new Rect();
            rect.left = n;
            rect.top = n2;
            rect.right = n3;
            rect.bottom = n4;
        }

        public Rectangle(Rect rect) {
            this.rect = rect;
        }

        public int compareTo(Rectangle rectangle) {
            if (this.rect.top < rectangle.rect.top) {
                return 1;
            }
            if (this.rect.top == rectangle.rect.top) {
                return 0;
            }
            return -1;
        }

        public boolean contains(Rectangle rectangle) {
            return this.rect.contains(rectangle.rect);
        }

        public int getBottom() {
            return this.rect.bottom;
        }

        public int getHeight() {
            return this.rect.height();
        }

        public int getLeft() {
            return this.rect.left;
        }

        public int getRight() {
            return this.rect.right;
        }

        public int getTop() {
            return this.rect.top;
        }

        public int getWidth() {
            return this.rect.width();
        }

        public boolean intersect(Rectangle rectangle) {
            if (this.rect.width() != 0 && this.rect.height() != 0) {
                return this.rect.intersect(rectangle.rect);
            }
            return false;
        }
    }

}

