/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Point
 *  android.view.View
 *  android.view.ViewParent
 *  com.startapp.android.publish.ads.banner.banner3d.Banner3D
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.startapp.android.publish.ads.banner.banner3d;

import android.content.Context;
import android.graphics.Point;
import android.view.View;
import android.view.ViewParent;
import com.startapp.android.publish.ads.banner.BannerOptions;
import com.startapp.android.publish.ads.banner.banner3d.Banner3D;
import com.startapp.android.publish.ads.banner.d;
import com.startapp.android.publish.adsCommon.Utils.h;
import com.startapp.common.a.g;

public class Banner3DSize {
    /*
     * Exception decompiling
     */
    private static d a(Context var0, ViewParent var1, BannerOptions var2, Banner3D var3) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl177 : NEW : trying to set 1 previously set to 0
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
        // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
        // org.benf.cfr.reader.b.a(Driver.java:128)
        // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
        // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
        // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
        // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1167)
        // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:641)
        // java.lang.Thread.run(Thread.java:919)
        throw new IllegalStateException("Decompilation failed");
    }

    private static void a(Context context, Point point, View view) {
        point.y = h.b(context, view.getMeasuredHeight() - view.getPaddingBottom() - view.getPaddingTop());
    }

    public static boolean a(Context context, ViewParent viewParent, BannerOptions bannerOptions, Banner3D banner3D, d d2) {
        g.a("Banner3DSize", 3, "============== Optimize Size ==========");
        d d3 = Banner3DSize.a(context, viewParent, bannerOptions, banner3D);
        d2.a(d3.a(), d3.b());
        Size[] arrsize = Size.values();
        int n2 = arrsize.length;
        boolean bl = false;
        for (int j = 0; j < n2; ++j) {
            Size size = arrsize[j];
            if (size.getSize().a() > d3.a() || size.getSize().b() > d3.b()) continue;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("BannerSize [");
            stringBuilder.append(size.getSize().a());
            stringBuilder.append(",");
            stringBuilder.append(size.getSize().b());
            stringBuilder.append("]");
            g.a("Banner3DSize", 3, stringBuilder.toString());
            bannerOptions.a(size.getSize().a(), size.getSize().b());
            bl = true;
        }
        if (!bl) {
            bannerOptions.a(0, 0);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("============== Optimize Size [");
        stringBuilder.append(bl);
        stringBuilder.append("] ==========");
        g.a("Banner3DSize", 3, stringBuilder.toString());
        return bl;
    }

    private static void b(Context context, Point point, View view) {
        point.x = h.b(context, view.getMeasuredWidth() - view.getPaddingLeft() - view.getPaddingRight());
    }

    private static void c(Context context, Point point, View view) {
        point.x = h.b(context, view.getMeasuredWidth());
        point.y = h.b(context, view.getMeasuredHeight());
    }

    public static final class Size
    extends Enum<Size> {
        private static final /* synthetic */ Size[] $VALUES;
        public static final /* enum */ Size LARGE;
        public static final /* enum */ Size MEDIUM;
        public static final /* enum */ Size SMALL;
        public static final /* enum */ Size XLARGE;
        public static final /* enum */ Size XSMALL;
        public static final /* enum */ Size XXSMALL;
        private d size;

        static {
            XXSMALL = new Size(new d(280, 50));
            XSMALL = new Size(new d(300, 50));
            SMALL = new Size(new d(320, 50));
            MEDIUM = new Size(new d(468, 60));
            LARGE = new Size(new d(728, 90));
            XLARGE = new Size(new d(1024, 90));
            Size[] arrsize = new Size[]{XXSMALL, XSMALL, SMALL, MEDIUM, LARGE, XLARGE};
            $VALUES = arrsize;
        }

        private Size(d d2) {
            this.size = d2;
        }

        public static Size valueOf(String string) {
            return (Size)Enum.valueOf(Size.class, (String)string);
        }

        public static Size[] values() {
            return (Size[])$VALUES.clone();
        }

        public d getSize() {
            return this.size;
        }
    }

}

