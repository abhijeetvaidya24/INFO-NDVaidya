/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Rect
 *  android.graphics.drawable.Drawable
 *  android.location.Location
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.IBinder
 *  android.util.DisplayMetrics
 *  android.view.Display
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewParent
 *  android.view.WindowManager
 *  java.lang.Class
 *  java.lang.Double
 *  java.lang.Exception
 *  java.lang.Float
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.ref.WeakReference
 *  java.util.ArrayDeque
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.Comparator
 *  java.util.HashMap
 *  java.util.HashSet
 *  java.util.List
 *  java.util.Locale
 *  java.util.Map
 *  java.util.Set
 *  org.json.JSONObject
 */
package com.moat.analytics.mobile.mpub;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.os.Build;
import android.os.IBinder;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import com.moat.analytics.mobile.mpub.m;
import com.moat.analytics.mobile.mpub.o;
import com.moat.analytics.mobile.mpub.p;
import com.moat.analytics.mobile.mpub.s;
import com.moat.analytics.mobile.mpub.w;
import java.lang.ref.WeakReference;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

class z {
    String a = "{}";
    private c b = new c();
    private JSONObject c;
    private Rect d;
    private Rect e;
    private JSONObject f;
    private JSONObject g;
    private Location h;
    private Map<String, Object> i = new HashMap();

    z() {
    }

    static int a(Rect rect, Set<Rect> set) {
        boolean bl2 = set.isEmpty();
        int n2 = 0;
        if (!bl2) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(set);
            Collections.sort((List)arrayList, (Comparator)new Comparator<Rect>(){

                public int a(Rect rect, Rect rect2) {
                    return Integer.valueOf((int)rect.top).compareTo(Integer.valueOf((int)rect2.top));
                }

                public /* synthetic */ int compare(Object object, Object object2) {
                    return this.a((Rect)object, (Rect)object2);
                }
            });
            ArrayList arrayList2 = new ArrayList();
            for (Rect rect2 : arrayList) {
                arrayList2.add((Object)rect2.left);
                arrayList2.add((Object)rect2.right);
            }
            Collections.sort((List)arrayList2);
            int n3 = 0;
            while (n2 < -1 + arrayList2.size()) {
                int n4;
                Integer n5 = (Integer)arrayList2.get(n2);
                if (!n5.equals(arrayList2.get(n4 = n2 + 1))) {
                    Rect rect3 = new Rect(((Integer)arrayList2.get(n2)).intValue(), rect.top, ((Integer)arrayList2.get(n4)).intValue(), rect.bottom);
                    int n6 = rect.top;
                    for (Rect rect4 : arrayList) {
                        if (!Rect.intersects((Rect)rect4, (Rect)rect3)) continue;
                        if (rect4.bottom > n6) {
                            n3 += rect3.width() * (rect4.bottom - Math.max((int)n6, (int)rect4.top));
                            n6 = rect4.bottom;
                        }
                        if (rect4.bottom != rect3.bottom) continue;
                    }
                }
                n2 = n4;
            }
            n2 = n3;
        }
        return n2;
    }

    private static Rect a(DisplayMetrics displayMetrics) {
        return new Rect(0, 0, displayMetrics.widthPixels, displayMetrics.heightPixels);
    }

    static Rect a(View view) {
        if (view != null) {
            return z.k(view);
        }
        return new Rect(0, 0, 0, 0);
    }

    static a a(Rect rect, View view) {
        a a2;
        block12 : {
            block10 : {
                b b2;
                ArrayDeque<View> arrayDeque;
                block11 : {
                    a2 = new a();
                    arrayDeque = z.i(view);
                    if (arrayDeque == null) break block10;
                    if (!arrayDeque.isEmpty()) break block11;
                    return a2;
                }
                try {
                    p.b(2, "VisibilityInfo", (Object)view, "starting covering rect search");
                    b2 = null;
                }
                catch (Exception exception) {
                    m.a(exception);
                }
                do {
                    b b3;
                    block13 : {
                        if (arrayDeque.isEmpty()) break block12;
                        View view2 = (View)arrayDeque.pollLast();
                        b3 = new b(view2, b2);
                        if (view2.getParent() == null || !(view2.getParent() instanceof ViewGroup)) break block13;
                        ViewGroup viewGroup = (ViewGroup)view2.getParent();
                        int n2 = viewGroup.getChildCount();
                        boolean bl2 = false;
                        for (int i2 = 0; i2 < n2; ++i2) {
                            View view3;
                            block15 : {
                                block14 : {
                                    if (a2.a < 500) break block14;
                                    p.a(3, "VisibilityInfo", null, "Short-circuiting cover retrieval, reached max");
                                    return a2;
                                }
                                view3 = viewGroup.getChildAt(i2);
                                if (view3 != view2) break block15;
                                bl2 = true;
                                continue;
                            }
                            a2.a = 1 + a2.a;
                            if (!z.a(view3, view2, bl2)) continue;
                            z.b(new b(view3, b2), rect, a2);
                            boolean bl3 = a2.c;
                            if (!bl3) continue;
                            return a2;
                        }
                    }
                    b2 = b3;
                } while (true);
            }
            return a2;
        }
        return a2;
    }

    private static c a(View view, Rect rect, boolean bl2, boolean bl3, boolean bl4) {
        Rect rect2;
        c c2 = new c();
        int n2 = z.b(rect);
        if (view != null && bl2 && bl3 && !bl4 && n2 > 0 && z.a(view, rect2 = new Rect(0, 0, 0, 0))) {
            int n3 = z.b(rect2);
            if (n3 < n2) {
                p.b(2, "VisibilityInfo", null, "Ad is clipped");
            }
            if (view.getRootView() instanceof ViewGroup) {
                c2.a = rect2;
                a a2 = z.a(rect2, view);
                if (a2.c) {
                    c2.c = 1.0;
                    return c2;
                }
                int n4 = z.a(rect2, a2.b);
                if (n4 > 0) {
                    double d2 = n4;
                    double d3 = n3;
                    Double.isNaN((double)d3);
                    double d4 = d3 * 1.0;
                    Double.isNaN((double)d2);
                    c2.c = d2 / d4;
                }
                double d5 = n3 - n4;
                double d6 = n2;
                Double.isNaN((double)d6);
                double d7 = d6 * 1.0;
                Double.isNaN((double)d5);
                c2.b = d5 / d7;
            }
        }
        return c2;
    }

    private static Map<String, String> a(Rect rect) {
        HashMap hashMap = new HashMap();
        hashMap.put((Object)"x", (Object)String.valueOf((int)rect.left));
        hashMap.put((Object)"y", (Object)String.valueOf((int)rect.top));
        hashMap.put((Object)"w", (Object)String.valueOf((int)(rect.right - rect.left)));
        hashMap.put((Object)"h", (Object)String.valueOf((int)(rect.bottom - rect.top)));
        return hashMap;
    }

    private static Map<String, String> a(Rect rect, DisplayMetrics displayMetrics) {
        return z.a(z.b(rect, displayMetrics));
    }

    private static JSONObject a(Location location) {
        Map<String, String> map = z.b(location);
        if (map == null) {
            return null;
        }
        return new JSONObject(map);
    }

    private static void a(b b2, Rect rect, a a2) {
        Rect rect2 = b2.b;
        if (rect2.setIntersect(rect, rect2)) {
            if (Build.VERSION.SDK_INT >= 22) {
                Rect rect3 = new Rect(0, 0, 0, 0);
                if (z.a(b2.a, rect3)) {
                    Rect rect4 = b2.b;
                    if (!rect4.setIntersect(rect3, rect4)) {
                        return;
                    }
                    rect2 = rect4;
                } else {
                    return;
                }
            }
            if (w.a().c) {
                View view = b2.a;
                Locale locale = Locale.ROOT;
                Object[] arrobject = new Object[]{b2.a.getClass().getName(), rect2.toString(), Float.valueOf((float)b2.a.getAlpha())};
                p.b(2, "VisibilityInfo", (Object)view, String.format((Locale)locale, (String)"Covered by %s-%s alpha=%f", (Object[])arrobject));
            }
            a2.b.add((Object)rect2);
            if (rect2.contains(rect)) {
                a2.c = true;
            }
        }
    }

    private static boolean a(View view, Rect rect) {
        boolean bl2 = view.getGlobalVisibleRect(rect);
        int n2 = 0;
        if (bl2) {
            int[] arrn = new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE};
            view.getLocationInWindow(arrn);
            int[] arrn2 = new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE};
            view.getLocationOnScreen(arrn2);
            int n3 = arrn2[0] - arrn[0];
            n2 = 1;
            rect.offset(n3, arrn2[n2] - arrn[n2]);
        }
        return (boolean)n2;
    }

    private static boolean a(View view, View view2, boolean bl2) {
        boolean bl3 = true;
        if (bl2) {
            if (Build.VERSION.SDK_INT >= 21) {
                if (view.getZ() >= view2.getZ()) {
                    return bl3;
                }
                bl3 = false;
            }
            return bl3;
        }
        if (Build.VERSION.SDK_INT >= 21 && view.getZ() > view2.getZ()) {
            return bl3;
        }
        return false;
    }

    private static int b(Rect rect) {
        return rect.width() * rect.height();
    }

    private static Rect b(Rect rect, DisplayMetrics displayMetrics) {
        float f2 = displayMetrics.density;
        if (f2 == 0.0f) {
            return rect;
        }
        int n2 = Math.round((float)((float)rect.left / f2));
        int n3 = Math.round((float)((float)rect.right / f2));
        return new Rect(n2, Math.round((float)((float)rect.top / f2)), n3, Math.round((float)((float)rect.bottom / f2)));
    }

    private static Rect b(View view, int n2, int n3) {
        int n4 = n2 + view.getLeft();
        int n5 = n3 + view.getTop();
        return new Rect(n4, n5, n4 + view.getWidth(), n5 + view.getHeight());
    }

    private static Map<String, String> b(Location location) {
        if (location == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put((Object)"latitude", (Object)Double.toString((double)location.getLatitude()));
        hashMap.put((Object)"longitude", (Object)Double.toString((double)location.getLongitude()));
        hashMap.put((Object)"timestamp", (Object)Long.toString((long)location.getTime()));
        hashMap.put((Object)"horizontalAccuracy", (Object)Float.toString((float)location.getAccuracy()));
        return hashMap;
    }

    private static void b(b b2, Rect rect, a a2) {
        boolean bl2;
        if (!z.h(b2.a)) {
            return;
        }
        if (b2.a instanceof ViewGroup) {
            boolean bl3 = ViewGroup.class.equals((Object)b2.a.getClass().getSuperclass());
            boolean bl4 = z.j(b2.a);
            bl2 = !bl3 || !bl4;
            ViewGroup viewGroup = (ViewGroup)b2.a;
            int n2 = viewGroup.getChildCount();
            for (int i2 = 0; i2 < n2; ++i2) {
                int n3;
                a2.a = n3 = 1 + a2.a;
                if (n3 > 500) {
                    return;
                }
                z.b(new b(viewGroup.getChildAt(i2), b2), rect, a2);
                if (!a2.c) continue;
                return;
            }
        } else {
            bl2 = true;
        }
        if (bl2) {
            z.a(b2, rect, a2);
        }
    }

    private static boolean c(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            return view != null && view.isAttachedToWindow();
        }
        return view != null && view.getWindowToken() != null;
    }

    private static boolean d(View view) {
        return view != null && view.hasWindowFocus();
    }

    private static boolean e(View view) {
        return view == null || !view.isShown();
        {
        }
    }

    private static float f(View view) {
        if (view == null) {
            return 0.0f;
        }
        return z.g(view);
    }

    private static float g(View view) {
        float f2 = view.getAlpha();
        while (view != null && view.getParent() != null) {
            if ((double)f2 == 0.0) {
                return f2;
            }
            if (!(view.getParent() instanceof View)) break;
            f2 *= ((View)view.getParent()).getAlpha();
            view = (View)view.getParent();
        }
        return f2;
    }

    private static boolean h(View view) {
        return view.isShown() && (double)view.getAlpha() > 0.0;
    }

    private static ArrayDeque<View> i(View view) {
        ArrayDeque arrayDeque = new ArrayDeque();
        int n2 = 0;
        for (View view2 = view; view2.getParent() != null || view2 == view.getRootView(); view2 = (View)view2.getParent()) {
            if (++n2 > 50) {
                p.a(3, "VisibilityInfo", null, "Short-circuiting chain retrieval, reached max");
                return arrayDeque;
            }
            arrayDeque.add((Object)view2);
            if (!(view2.getParent() instanceof View)) break;
        }
        return arrayDeque;
    }

    private static boolean j(View view) {
        int n2 = Build.VERSION.SDK_INT;
        boolean bl2 = true;
        if (n2 >= 19 && view.getBackground() != null) {
            if (view.getBackground().getAlpha() == 0) {
                return bl2;
            }
            bl2 = false;
        }
        return bl2;
    }

    private static Rect k(View view) {
        int[] arrn = new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE};
        view.getLocationOnScreen(arrn);
        int n2 = arrn[0];
        int n3 = arrn[1];
        return new Rect(n2, n3, n2 + view.getWidth(), n3 + view.getHeight());
    }

    private static DisplayMetrics l(View view) {
        Activity activity;
        if (Build.VERSION.SDK_INT >= 17 && com.moat.analytics.mobile.mpub.a.a != null && (activity = (Activity)com.moat.analytics.mobile.mpub.a.a.get()) != null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            activity.getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);
            return displayMetrics;
        }
        return view.getContext().getResources().getDisplayMetrics();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    void a(String string2, View view) {
        HashMap hashMap = new HashMap();
        String string3 = "{}";
        if (view == null) return;
        try {
            c c2;
            Rect rect;
            boolean bl2;
            DisplayMetrics displayMetrics;
            Rect rect2;
            Location location;
            block12 : {
                block11 : {
                    displayMetrics = z.l(view);
                    boolean bl3 = z.c(view);
                    boolean bl4 = z.d(view);
                    boolean bl5 = z.e(view);
                    float f2 = z.f(view);
                    hashMap.put((Object)"dr", (Object)Float.valueOf((float)displayMetrics.density));
                    hashMap.put((Object)"dv", (Object)s.a());
                    hashMap.put((Object)"adKey", (Object)string2);
                    int n2 = bl3 ? 1 : 0;
                    hashMap.put((Object)"isAttached", (Object)n2);
                    int n3 = bl4 ? 1 : 0;
                    hashMap.put((Object)"inFocus", (Object)n3);
                    int n4 = bl5 ? 1 : 0;
                    hashMap.put((Object)"isHidden", (Object)n4);
                    hashMap.put((Object)"opacity", (Object)Float.valueOf((float)f2));
                    rect = z.a(displayMetrics);
                    rect2 = z.a(view);
                    c2 = z.a(view, rect2, bl3, bl4, bl5);
                    if (this.c == null || c2.b != this.b.b || !c2.a.equals((Object)this.b.a)) break block11;
                    double d2 = c2.c DCMPL this.b.c;
                    bl2 = false;
                    if (d2 == false) break block12;
                }
                this.b = c2;
                this.c = new JSONObject(z.a(this.b.a, displayMetrics));
                bl2 = true;
            }
            hashMap.put((Object)"coveredPercent", (Object)c2.c);
            if (this.g == null || !rect.equals((Object)this.e)) {
                this.e = rect;
                this.g = new JSONObject(z.a(rect, displayMetrics));
                bl2 = true;
            }
            if (this.f == null || !rect2.equals((Object)this.d)) {
                this.d = rect2;
                this.f = new JSONObject(z.a(rect2, displayMetrics));
                bl2 = true;
            }
            if (this.i == null || !hashMap.equals(this.i)) {
                this.i = hashMap;
                bl2 = true;
            }
            if (!o.a(location = o.a().b(), this.h)) {
                this.h = location;
                bl2 = true;
            }
            if (!bl2) {
                return;
            }
            JSONObject jSONObject = new JSONObject(this.i);
            jSONObject.accumulate("screen", (Object)this.g);
            jSONObject.accumulate("view", (Object)this.f);
            jSONObject.accumulate("visible", (Object)this.c);
            jSONObject.accumulate("maybe", (Object)this.c);
            jSONObject.accumulate("visiblePercent", (Object)this.b.b);
            if (location != null) {
                jSONObject.accumulate("location", (Object)z.a(location));
            }
            this.a = string3 = jSONObject.toString();
            return;
        }
        catch (Exception exception) {
            m.a(exception);
            this.a = string3;
        }
    }

    static class a {
        int a = 0;
        final Set<Rect> b = new HashSet();
        boolean c = false;

        a() {
        }
    }

    private static class b {
        final View a;
        final Rect b;

        b(View view, b b2) {
            this.a = view;
            Rect rect = b2 != null ? z.b(view, b2.b.left, b2.b.top) : z.k(view);
            this.b = rect;
        }
    }

    private static class c {
        Rect a = new Rect(0, 0, 0, 0);
        double b = 0.0;
        double c = 0.0;

        c() {
        }
    }

}

