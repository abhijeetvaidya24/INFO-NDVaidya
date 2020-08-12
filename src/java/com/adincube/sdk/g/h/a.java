/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Rect
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.IBinder
 *  android.view.View
 *  android.view.ViewParent
 *  java.lang.Class
 *  java.lang.Double
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.Throwable
 *  java.lang.ref.WeakReference
 *  java.util.HashSet
 *  java.util.Iterator
 *  java.util.Set
 */
package com.adincube.sdk.g.h;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.os.IBinder;
import android.view.View;
import android.view.ViewParent;
import com.adincube.sdk.g.h.a;
import com.adincube.sdk.util.ErrorReportingHelper;
import com.adincube.sdk.util.a.b;
import com.adincube.sdk.util.o;
import com.adincube.sdk.util.t;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class a {
    private static a g;
    private Context a = null;
    private Set<a> b = new HashSet();
    private Set<b> c = new HashSet();
    private boolean d = false;
    private boolean e = false;
    private com.adincube.sdk.util.a.b f;
    private b.a h = new b.a(this){
        final /* synthetic */ a a;
        {
            this.a = a2;
        }

        /*
         * Unable to fully structure code
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         * Lifted jumps to return sites
         */
        public final void a(boolean var1_1) {
            if (var1_1) ** GOTO lbl5
            try {
                a.b(this.a);
                return;
lbl5: // 1 sources:
                a.c(this.a);
                return;
            }
            catch (Throwable var2_2) {
                new Object[1][0] = var2_2;
                ErrorReportingHelper.report("ViewVisibilityTrackingManager#OnScreenStateChangedListener.onScreenStateChanged", com.adincube.sdk.h.c.b.c, var2_2);
                return;
            }
        }
    };

    private a(Context context) {
        this.a = context.getApplicationContext();
        this.f = new com.adincube.sdk.util.a.b(this.a, com.adincube.sdk.h.c.b.c, null);
        this.f.b = this.h;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static a a(Context context) {
        if (g != null) return g;
        Class<a> class_ = a.class;
        synchronized (a.class) {
            if (g != null) return g;
            g = new a(context);
            // ** MonitorExit[var2_1] (shouldn't be in output)
            return g;
        }
    }

    private void a() {
        a a2 = this;
        synchronized (a2) {
            if (!this.d) {
                this.d = true;
                this.e = true;
                this.f.a();
            }
            this.b();
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void a(a a2, boolean bl) {
        a a3 = this;
        synchronized (a3) {
            View view = (View)a2.a.get();
            if (view == null) {
                return;
            }
            Iterator iterator = this.c.iterator();
            while (iterator.hasNext()) {
                b b2 = (b)iterator.next();
                try {
                    b2.a(view, bl);
                }
                catch (Throwable throwable) {
                    com.adincube.sdk.util.a.c("ViewVisibilityTrackingManager.notifyVisibilityChanged", new Object[]{throwable});
                    ErrorReportingHelper.report("ViewVisibilityTrackingManager.notifyVisibilityChanged", throwable);
                }
            }
            return;
        }
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    private void a(boolean bl) {
        block11 : {
            block10 : {
                a a2 = this;
                // MONITORENTER : a2
                boolean bl2 = this.d;
                if (bl2) break block10;
                // MONITOREXIT : a2
                return;
            }
            boolean bl3 = this.e;
            if (!bl3) break block11;
            // MONITOREXIT : a2
            return;
        }
        Rect rect = new Rect();
        Iterator iterator = this.b.iterator();
        while (iterator.hasNext()) {
            if (this.a((a)iterator.next(), rect)) continue;
            iterator.remove();
        }
        if (!bl) {
            if (this.b.size() > 0) {
                o.a(new Runnable(){

                    public final void run() {
                        a.this.a(false);
                    }
                }, 500L);
                // MONITOREXIT : a2
                return;
            }
            this.d();
        }
        // MONITOREXIT : a2
        return;
        catch (Throwable throwable3) {
            com.adincube.sdk.util.a.c("ViewVisibilityTrackingManager.refreshTrackedViewsVisibility", new Object[]{throwable3});
            ErrorReportingHelper.report("ViewVisibilityTrackingManager.refreshTrackedViewsVisibility", throwable3);
            // MONITOREXIT : a2
            return;
        }
    }

    private static boolean a(View view, double d2, Rect rect) {
        block15 : {
            block14 : {
                block13 : {
                    block12 : {
                        block11 : {
                            block10 : {
                                block9 : {
                                    try {
                                        if (view.getParent() != null) break block9;
                                        return false;
                                    }
                                    catch (Throwable throwable) {
                                        com.adincube.sdk.util.a.c("ViewVisibilityTrackingManager.isVisible", new Object[]{throwable});
                                        ErrorReportingHelper.report("ViewVisibilityTrackingManager.isVisible", throwable);
                                        return false;
                                    }
                                }
                                if (view.getWindowToken() != null) break block10;
                                return false;
                            }
                            if (view.getVisibility() == 0) break block11;
                            return false;
                        }
                        if (view.getWindowVisibility() == 0) break block12;
                        return false;
                    }
                    if (Build.VERSION.SDK_INT < 11 || !(view.getAlpha() < 0.9f)) break block13;
                    return false;
                }
                if (view.getMeasuredHeight() != 0 || view.getMeasuredWidth() != 0) break block14;
                return false;
            }
            if (view.getGlobalVisibleRect(rect)) break block15;
            return false;
        }
        long l2 = rect.width() * rect.height();
        int n2 = view.getWidth();
        int n3 = view.getHeight();
        double d3 = n2 * n3;
        Double.isNaN((double)d3);
        return l2 >= (long)(d3 * d2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean a(a a2, Rect rect) {
        a a3 = this;
        synchronized (a3) {
            View view;
            block5 : {
                view = (View)a2.a.get();
                if (view != null) break block5;
                return false;
            }
            boolean bl = a.a(view, a2.c, rect);
            if (bl != a2.b) {
                this.a(a2, bl);
            }
            a2.b = bl;
            return true;
        }
    }

    private a b(View view) {
        a a2 = this;
        synchronized (a2) {
            a a32;
            try {
                for (a a32 : this.b) {
                    Object object = a32.a.get();
                    if (object != view) continue;
                }
            }
            catch (Throwable throwable) {}
            {
                throw throwable;
            }
            return a32;
            return null;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void b() {
        a a2 = this;
        synchronized (a2) {
            boolean bl = this.d;
            if (!bl) {
                return;
            }
            if (this.e) {
                boolean bl2 = t.a(this.f.a);
                if (!bl2) {
                    return;
                }
                this.e = false;
                this.a(false);
            }
            return;
        }
    }

    static /* synthetic */ void b(a a2) {
        a2.c();
    }

    public static boolean b(View view, double d2) {
        return a.a(view, d2, new Rect());
    }

    private void c() {
        a a2 = this;
        synchronized (a2) {
            if (!this.e) {
                this.a(true);
                this.e = true;
            }
            return;
        }
    }

    static /* synthetic */ void c(a a2) {
        a2.b();
    }

    private void d() {
        a a2 = this;
        synchronized (a2) {
            if (this.d) {
                this.a(true);
                this.f.b();
                this.d = false;
                this.e = false;
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void a(View view) {
        a a2 = this;
        synchronized (a2) {
            a a3 = this.b(view);
            if (a3 != null) {
                this.b.remove((Object)a3);
                if (this.b.size() == 0) {
                    this.d();
                }
            }
            return;
        }
    }

    public final void a(View view, double d2) {
        a a2 = this;
        synchronized (a2) {
            block4 : {
                a a3 = this.b(view);
                if (a3 == null) break block4;
                return;
            }
            a a4 = new a(0);
            a4.a = new WeakReference((Object)view);
            a4.c = d2;
            a4.b = a.a(view, d2, new Rect());
            this.b.add((Object)a4);
            this.a(a4, a4.b);
            this.a();
            return;
        }
    }

    public final void a(b b2) {
        a a2 = this;
        synchronized (a2) {
            this.c.add((Object)b2);
            return;
        }
    }

    public final void b(b b2) {
        a a2 = this;
        synchronized (a2) {
            this.c.remove((Object)b2);
            return;
        }
    }

    private final class a {
        public WeakReference<View> a;
        public boolean b;
        public double c;

        private a() {
        }

        /* synthetic */ a(byte by2) {
            this();
        }
    }

    public static interface b {
        public void a(View var1, boolean var2);
    }

}

