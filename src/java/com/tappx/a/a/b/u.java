/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.app.Activity
 *  android.content.BroadcastReceiver
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentFilter
 *  android.content.pm.ActivityInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  android.graphics.Rect
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Handler
 *  android.os.Looper
 *  android.util.DisplayMetrics
 *  android.view.Display
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$OnTouchListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewTreeObserver
 *  android.view.ViewTreeObserver$OnPreDrawListener
 *  android.view.WindowManager
 *  android.webkit.ConsoleMessage
 *  android.webkit.JsResult
 *  android.webkit.WebView
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 *  com.tappx.a.a.b.ah
 *  com.tappx.a.a.b.u$1
 *  com.tappx.a.a.b.u$3
 *  com.tappx.a.a.b.u$4
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Deprecated
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.ref.WeakReference
 *  java.net.URI
 */
package com.tappx.a.a.b;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.webkit.ConsoleMessage;
import android.webkit.JsResult;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.tappx.a.a.b.aa;
import com.tappx.a.a.b.ab;
import com.tappx.a.a.b.ac;
import com.tappx.a.a.b.ae;
import com.tappx.a.a.b.ah;
import com.tappx.a.a.b.ai;
import com.tappx.a.a.b.al;
import com.tappx.a.a.b.am;
import com.tappx.a.a.b.an;
import com.tappx.a.a.b.ao;
import com.tappx.a.a.b.g;
import com.tappx.a.a.b.h;
import com.tappx.a.a.b.s;
import com.tappx.a.a.b.t;
import com.tappx.a.a.b.u;
import com.tappx.a.a.b.w;
import java.lang.ref.WeakReference;
import java.net.URI;

public class u {
    public static final String a = "vnd.android.cursor.item/event";
    private final WeakReference<Activity> b;
    private final Context c;
    private final s d;
    private final FrameLayout e;
    private final g f;
    private ViewGroup g;
    private final c h;
    private final ae i;
    private am j = am.a;
    private a k;
    private d l;
    private ai m;
    private ah n;
    private ah o;
    private final t p;
    private final t q;
    private b r = new b();
    private Integer s;
    private boolean t = true;
    private ac u = ac.c;
    private final ab v;
    private boolean w;
    private boolean x = false;
    private final t.a y = new 3(this);
    private final t.a z = new 4(this);

    public u(Context context, s s2) {
        this(context, s2, new t(s2), new t(s.b), new c());
    }

    u(Context context, s s2, t t2, t t3, c c2) {
        this.c = context.getApplicationContext();
        this.b = context instanceof Activity ? new WeakReference((Object)((Activity)context)) : new WeakReference(null);
        this.d = s2;
        this.p = t2;
        this.q = t3;
        this.h = c2;
        this.j = am.a;
        DisplayMetrics displayMetrics = this.c.getResources().getDisplayMetrics();
        this.i = new ae(this.c, displayMetrics.density);
        this.e = new FrameLayout(this.c);
        this.f = new g(this.c);
        this.f.setCloseListener((g.c)new 1(this));
        View view = new View(this.c);
        view.setOnTouchListener(new View.OnTouchListener(){

            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
        this.f.addView(view, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
        this.r.a(this.c);
        this.p.a(this.y);
        this.q.a(this.z);
        this.v = new ab();
    }

    public static int a(Activity activity) {
        return h.a(activity.getWindowManager().getDefaultDisplay().getRotation(), activity.getResources().getConfiguration().orientation);
    }

    static /* synthetic */ a a(u u2) {
        return u2.k;
    }

    private void a(am am2, Runnable runnable) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("MRAID state set to ");
        stringBuilder.append((Object)am2);
        aa.c(stringBuilder.toString());
        am am3 = this.j;
        this.j = am2;
        this.p.a(am2);
        if (this.q.f()) {
            this.q.a(am2);
        }
        if (this.k != null) {
            if (am2 == am.d) {
                this.k.b();
            } else if (am3 == am.d && am2 == am.b) {
                this.k.d();
            } else if (am2 == am.e) {
                this.k.d();
            }
        }
        this.a(runnable);
    }

    private void a(final Runnable runnable) {
        this.h.a();
        final View view = this.r();
        if (view == null) {
            return;
        }
        c c2 = this.h;
        View[] arrview = new View[]{this.e, view};
        c2.a(arrview).a(new Runnable(){

            public void run() {
                Runnable runnable2;
                DisplayMetrics displayMetrics = u.this.c.getResources().getDisplayMetrics();
                u.this.i.a(displayMetrics.widthPixels, displayMetrics.heightPixels);
                int[] arrn = new int[2];
                ViewGroup viewGroup = u.this.t();
                viewGroup.getLocationOnScreen(arrn);
                u.this.i.a(arrn[0], arrn[1], viewGroup.getWidth(), viewGroup.getHeight());
                u.this.e.getLocationOnScreen(arrn);
                u.this.i.c(arrn[0], arrn[1], u.this.e.getWidth(), u.this.e.getHeight());
                view.getLocationOnScreen(arrn);
                u.this.i.b(arrn[0], arrn[1], view.getWidth(), view.getHeight());
                u.this.p.a(u.this.i);
                if (u.this.q.e()) {
                    u.this.q.a(u.this.i);
                }
                if ((runnable2 = runnable) != null) {
                    runnable2.run();
                }
            }
        });
    }

    private void b(am am2) {
        this.a(am2, null);
    }

    static /* synthetic */ void b(u u2) {
        u2.p();
    }

    private void p() {
        if (this.x) {
            this.x = false;
            this.a((Runnable)null);
        }
    }

    private int q() {
        return ((WindowManager)this.c.getSystemService("window")).getDefaultDisplay().getRotation();
    }

    private View r() {
        if (this.q.e()) {
            return this.o;
        }
        return this.n;
    }

    private boolean s() {
        Activity activity = (Activity)this.b.get();
        if (activity != null && this.r() != null) {
            return this.v.a(activity, this.r());
        }
        return false;
    }

    @TargetApi(value=19)
    private ViewGroup t() {
        ViewGroup viewGroup = this.g;
        if (viewGroup != null) {
            return viewGroup;
        }
        View view = an.a((Context)this.b.get(), (View)this.e);
        if (view instanceof ViewGroup) {
            return (ViewGroup)view;
        }
        return this.e;
    }

    int a(int n2, int n3, int n4) {
        return Math.max((int)n2, (int)Math.min((int)n3, (int)n4));
    }

    void a() {
        this.a(am.b, new Runnable(){

            public void run() {
                u.this.p.a(u.this.v.d(u.this.c), u.this.v.c(u.this.c), u.this.v.a(u.this.c), u.this.v.b(u.this.c), u.this.s());
                u.this.p.a(u.this.d);
                u.this.p.a(u.this.p.d());
                u.this.p.b();
            }
        });
        a a2 = this.k;
        if (a2 != null) {
            a2.a((View)this.e);
        }
    }

    void a(int n2) {
        this.a((Runnable)null);
    }

    @Deprecated
    void a(int n2, int n3) {
        this.i.a(0, 0, n2, n3);
    }

    void a(int n2, int n3, int n4, int n5, g.a a2, boolean bl) {
        if (this.n != null) {
            if (this.j != am.a) {
                if (this.j == am.e) {
                    return;
                }
                if (this.j != am.d) {
                    int n6 = h.d(n2, this.c);
                    int n7 = h.d(n3, this.c);
                    int n8 = h.d(n4, this.c);
                    int n9 = h.d(n5, this.c);
                    int n10 = n8 + this.i.h().left;
                    int n11 = n9 + this.i.h().top;
                    Rect rect = new Rect(n10, n11, n6 + n10, n7 + n11);
                    if (!bl) {
                        Rect rect2 = this.i.d();
                        if (rect.width() <= rect2.width() && rect.height() <= rect2.height()) {
                            rect.offsetTo(this.a(rect2.left, rect.left, rect2.right - rect.width()), this.a(rect2.top, rect.top, rect2.bottom - rect.height()));
                        } else {
                            throw new w("Resize invalid)");
                        }
                    }
                    this.f.setInvisibleClose(true);
                    this.f.setClosePosition(a2);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(rect.width(), rect.height());
                    layoutParams.leftMargin = rect.left - this.i.d().left;
                    layoutParams.topMargin = rect.top - this.i.d().top;
                    if (this.j == am.b) {
                        this.e.removeView((View)this.n);
                        this.e.setVisibility(4);
                        this.f.a((View)this.n, new FrameLayout.LayoutParams(-1, -1));
                        this.t().addView((View)this.f, (ViewGroup.LayoutParams)layoutParams);
                    } else if (this.j == am.c) {
                        this.f.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
                    }
                    this.f.setClosePosition(a2);
                    this.b(am.c);
                    return;
                }
                throw new w("Invalid status change");
            }
            return;
        }
        throw new w("View destroyed, ignoring");
    }

    @Deprecated
    void a(FrameLayout frameLayout) {
        this.g = frameLayout;
    }

    public void a(ai ai2) {
        this.m = ai2;
    }

    @Deprecated
    void a(am am2) {
        this.j = am2;
    }

    public void a(a a2) {
        this.k = a2;
    }

    @Deprecated
    void a(b b2) {
        this.r = b2;
    }

    public void a(d d2) {
        this.l = d2;
    }

    public void a(String string2) {
        this.n = new ah(this.c);
        this.p.a(this.n);
        this.e.addView((View)this.n, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
        this.p.a(string2);
    }

    void a(URI uRI, boolean bl) {
        if (this.n != null) {
            if (this.j != am.b && this.j != am.c) {
                return;
            }
            this.f();
            boolean bl2 = uRI != null;
            if (bl2) {
                this.o = new ah(this.c);
                this.q.a(this.o);
                this.q.b(uRI.toString());
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            if (this.j == am.b) {
                if (bl2) {
                    this.f.a((View)this.o, layoutParams);
                } else {
                    this.e.removeView((View)this.n);
                    this.e.setVisibility(4);
                    this.f.a((View)this.n, layoutParams);
                }
                this.t().addView((View)this.f, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
            } else if (this.j == am.c && bl2) {
                this.f.removeView((View)this.n);
                this.e.addView((View)this.n, (ViewGroup.LayoutParams)layoutParams);
                this.e.setVisibility(4);
                this.f.a((View)this.o, layoutParams);
            }
            this.f.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
            this.b(bl);
            this.b(am.d);
            return;
        }
        throw new w("View destroyed, ignoring");
    }

    public void a(boolean bl) {
        ah ah2;
        this.w = true;
        ah ah3 = this.n;
        if (ah3 != null) {
            ao.a((WebView)ah3, bl);
        }
        if ((ah2 = this.o) != null) {
            ao.a((WebView)ah2, bl);
        }
    }

    void a(boolean bl, ac ac2) {
        if (this.a(ac2)) {
            this.t = bl;
            this.u = ac2;
            if (this.j == am.d || this.d == s.b) {
                this.f();
            }
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unable to force orientation to ");
        stringBuilder.append((Object)ac2);
        throw new w(stringBuilder.toString());
    }

    boolean a(ConsoleMessage consoleMessage) {
        ai ai2 = this.m;
        if (ai2 != null) {
            return ai2.a(consoleMessage);
        }
        return true;
    }

    @TargetApi(value=13)
    boolean a(ac ac2) {
        ActivityInfo activityInfo;
        block6 : {
            int n2;
            if (ac2 == ac.c) {
                return true;
            }
            Activity activity = (Activity)this.b.get();
            if (activity == null) {
                return false;
            }
            try {
                activityInfo = activity.getPackageManager().getActivityInfo(new ComponentName((Context)activity, activity.getClass()), 0);
                n2 = activityInfo.screenOrientation;
                if (n2 == -1) break block6;
            }
            catch (PackageManager.NameNotFoundException nameNotFoundException) {
                return false;
            }
            return n2 == ac2.a();
        }
        boolean bl = al.a(activityInfo.configChanges, 128);
        if (Build.VERSION.SDK_INT >= 13) {
            if (bl && al.a(activityInfo.configChanges, 1024)) {
                return true;
            }
            bl = false;
        }
        return bl;
    }

    boolean a(String string2, JsResult jsResult) {
        ai ai2 = this.m;
        if (ai2 != null) {
            return ai2.a(string2, jsResult);
        }
        jsResult.confirm();
        return true;
    }

    void b() {
        this.a(new Runnable(){

            public void run() {
                u.this.q.a(u.this.v.d(u.this.c), u.this.v.c(u.this.c), u.this.v.a(u.this.c), u.this.v.b(u.this.c), u.this.s());
                u.this.q.a(u.this.j);
                u.this.q.a(u.this.d);
                u.this.q.a(u.this.q.d());
                u.this.q.b();
            }
        });
    }

    void b(int n2) {
        Activity activity = (Activity)this.b.get();
        if (activity != null && this.a(this.u)) {
            if (this.s == null) {
                this.s = activity.getRequestedOrientation();
            }
            activity.setRequestedOrientation(n2);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Invalid vale: ");
        stringBuilder.append(this.u.name());
        throw new w(stringBuilder.toString());
    }

    public void b(String string2) {
        this.p.c(string2);
    }

    void b(boolean bl) {
        if (bl == (true ^ this.f.b())) {
            return;
        }
        this.f.setCloseEnabled(bl ^ true);
        d d2 = this.l;
        if (d2 != null) {
            d2.a(bl);
        }
    }

    public void c() {
        ah ah2;
        this.w = false;
        ah ah3 = this.n;
        if (ah3 != null) {
            ao.a((WebView)ah3);
        }
        if ((ah2 = this.o) != null) {
            ao.a((WebView)ah2);
        }
    }

    public void d() {
        IllegalArgumentException illegalArgumentException2;
        block5 : {
            this.h.a();
            try {
                this.r.a();
            }
            catch (IllegalArgumentException illegalArgumentException2) {
                if (!illegalArgumentException2.getMessage().contains((CharSequence)"Receiver not registered")) break block5;
            }
            if (!this.w) {
                this.a(true);
            }
            an.a((View)this.f);
            this.p.a();
            ah ah2 = this.n;
            if (ah2 != null) {
                ah2.destroy();
                this.n = null;
            }
            this.q.a();
            ah ah3 = this.o;
            if (ah3 != null) {
                ah3.destroy();
                this.o = null;
            }
            return;
        }
        throw illegalArgumentException2;
    }

    void e() {
        if (this.n == null) {
            return;
        }
        if (this.j != am.a) {
            if (this.j == am.e) {
                return;
            }
            if (this.j == am.d || this.d == s.b) {
                this.g();
            }
            if (this.j != am.c && this.j != am.d) {
                if (this.j == am.b) {
                    this.e.setVisibility(4);
                    this.b(am.e);
                    return;
                }
            } else {
                ah ah2;
                if (this.q.e() && (ah2 = this.o) != null) {
                    this.f.removeView((View)ah2);
                    this.q.a();
                } else {
                    this.f.removeView((View)this.n);
                    this.e.addView((View)this.n, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
                    this.e.setVisibility(0);
                }
                this.t().removeView((View)this.f);
                this.b(am.b);
            }
        }
    }

    void f() {
        if (this.u == ac.c) {
            if (this.t) {
                this.g();
                return;
            }
            Activity activity = (Activity)this.b.get();
            if (activity != null) {
                this.b(u.a(activity));
                return;
            }
            throw new w("Context is not an Activity");
        }
        this.b(this.u.a());
    }

    void g() {
        Integer n2;
        Activity activity = (Activity)this.b.get();
        if (activity != null && (n2 = this.s) != null) {
            activity.setRequestedOrientation(n2.intValue());
        }
        this.s = null;
    }

    public FrameLayout h() {
        return this.e;
    }

    public Context i() {
        return this.c;
    }

    @Deprecated
    am j() {
        return this.j;
    }

    @Deprecated
    Integer k() {
        return this.s;
    }

    @Deprecated
    boolean l() {
        return this.t;
    }

    @Deprecated
    ac m() {
        return this.u;
    }

    @Deprecated
    ah n() {
        return this.n;
    }

    @Deprecated
    ah o() {
        return this.o;
    }

    public static interface a {
        public void a();

        public void a(View var1);

        public void b();

        public void c();

        public void d();
    }

    class b
    extends BroadcastReceiver {
        private Context b;
        private int c = -1;

        b() {
        }

        public void a() {
            Context context = this.b;
            if (context != null) {
                context.unregisterReceiver((BroadcastReceiver)this);
                this.b = null;
            }
        }

        public void a(Context context) {
            this.b = context.getApplicationContext();
            Context context2 = this.b;
            if (context2 != null) {
                context2.registerReceiver((BroadcastReceiver)this, new IntentFilter("android.intent.action.CONFIGURATION_CHANGED"));
            }
        }

        public void onReceive(Context context, Intent intent) {
            int n2;
            if (this.b == null) {
                return;
            }
            if ("android.intent.action.CONFIGURATION_CHANGED".equals((Object)intent.getAction()) && (n2 = u.this.q()) != this.c) {
                u.this.x = true;
                this.c = n2;
                u.this.a(this.c);
            }
        }
    }

    static class c {
        private final Handler a = new Handler(Looper.getMainLooper());
        private a b;

        c() {
        }

        /* varargs */ a a(View ... arrview) {
            this.b = new a(this.a, arrview);
            return this.b;
        }

        void a() {
            a a2 = this.b;
            if (a2 != null) {
                a2.a();
                this.b = null;
            }
        }

        static class a {
            int a;
            private final View[] b;
            private final Handler c;
            private Runnable d;
            private final Runnable e = new Runnable(){

                public void run() {
                    for (final View view : a.this.b) {
                        if (view.getHeight() <= 0 && view.getWidth() <= 0) {
                            view.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener(){

                                public boolean onPreDraw() {
                                    view.getViewTreeObserver().removeOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)this);
                                    a.this.b();
                                    return true;
                                }
                            });
                            continue;
                        }
                        a.this.b();
                    }
                }

            };

            private a(Handler handler, View[] arrview) {
                this.c = handler;
                this.b = arrview;
            }

            private void b() {
                Runnable runnable;
                this.a = -1 + this.a;
                if (this.a == 0 && (runnable = this.d) != null) {
                    runnable.run();
                    this.d = null;
                }
            }

            void a() {
                this.c.removeCallbacks(this.e);
                this.d = null;
            }

            void a(Runnable runnable) {
                this.d = runnable;
                this.a = this.b.length;
                this.c.post(this.e);
            }

        }

    }

    public static interface d {
        public void a(boolean var1);
    }

}

