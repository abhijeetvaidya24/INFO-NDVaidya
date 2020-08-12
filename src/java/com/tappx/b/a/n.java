/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.os.Handler
 *  android.os.Looper
 *  android.widget.ImageView
 *  android.widget.ImageView$ScaleType
 *  com.tappx.b.a.n$1
 *  com.tappx.b.a.n$2
 *  com.tappx.b.a.n$3
 *  com.tappx.b.a.n$d
 *  com.tappx.b.a.o
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Collection
 *  java.util.HashMap
 *  java.util.LinkedList
 */
package com.tappx.b.a;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;
import com.tappx.b.a.n;
import com.tappx.b.a.o;
import com.tappx.b.p;
import com.tappx.b.u;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;

public class n {
    private final com.tappx.b.o a;
    private int b = 100;
    private final b c;
    private final HashMap<String, a> d = new HashMap();
    private final HashMap<String, a> e = new HashMap();
    private final Handler f = new Handler(Looper.getMainLooper());
    private Runnable g;

    public n(com.tappx.b.o o2, b b2) {
        this.a = o2;
        this.c = b2;
    }

    public static d a(ImageView imageView, int n2, int n3) {
        return new 1(n3, imageView, n2);
    }

    private void a() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return;
        }
        throw new IllegalStateException("ImageLoader must be invoked from the main thread.");
    }

    private void a(String string2, a a2) {
        this.e.put((Object)string2, (Object)a2);
        if (this.g == null) {
            this.g = new Runnable(){

                public void run() {
                    for (a a2 : n.this.e.values()) {
                        for (c c2 : a2.e) {
                            if (c2.c == null) continue;
                            if (a2.a() == null) {
                                c2.b = a2.c;
                                c2.c.a(c2, false);
                                continue;
                            }
                            c2.c.a(a2.a());
                        }
                    }
                    n.this.e.clear();
                    n.this.g = null;
                }
            };
            this.f.postDelayed(this.g, (long)this.b);
        }
    }

    private static String b(String string2, int n2, int n3, ImageView.ScaleType scaleType) {
        StringBuilder stringBuilder = new StringBuilder(12 + string2.length());
        stringBuilder.append("#W");
        stringBuilder.append(n2);
        stringBuilder.append("#H");
        stringBuilder.append(n3);
        stringBuilder.append("#S");
        stringBuilder.append(scaleType.ordinal());
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }

    public c a(String string2, d d2) {
        return this.a(string2, d2, 0, 0);
    }

    public c a(String string2, d d2, int n2, int n3) {
        return this.a(string2, d2, n2, n3, ImageView.ScaleType.CENTER_INSIDE);
    }

    public c a(String string2, d d2, int n2, int n3, ImageView.ScaleType scaleType) {
        this.a();
        String string3 = n.b(string2, n2, n3, scaleType);
        Bitmap bitmap = this.c.a(string3);
        if (bitmap != null) {
            c c2 = new c(bitmap, string2, null, null);
            d2.a(c2, true);
            return c2;
        }
        c c3 = new c(null, string2, string3, d2);
        d2.a(c3, true);
        a a2 = (a)this.d.get((Object)string3);
        if (a2 != null) {
            a2.a(c3);
            return c3;
        }
        com.tappx.b.n<Bitmap> n4 = this.a(string2, n2, n3, scaleType, string3);
        this.a.a(n4);
        this.d.put((Object)string3, (Object)new a(n4, c3));
        return c3;
    }

    protected com.tappx.b.n<Bitmap> a(String string2, int n2, int n3, ImageView.ScaleType scaleType, String string3) {
        o o2 = new o(string2, (p.b)new 2(this, string3), n2, n3, scaleType, Bitmap.Config.RGB_565, (p.a)new 3(this, string3));
        return o2;
    }

    public void a(int n2) {
        this.b = n2;
    }

    protected void a(String string2, Bitmap bitmap) {
        this.c.a(string2, bitmap);
        a a2 = (a)this.d.remove((Object)string2);
        if (a2 != null) {
            a2.c = bitmap;
            this.a(string2, a2);
        }
    }

    protected void a(String string2, u u2) {
        a a2 = (a)this.d.remove((Object)string2);
        if (a2 != null) {
            a2.a(u2);
            this.a(string2, a2);
        }
    }

    public boolean a(String string2, int n2, int n3) {
        return this.a(string2, n2, n3, ImageView.ScaleType.CENTER_INSIDE);
    }

    public boolean a(String string2, int n2, int n3, ImageView.ScaleType scaleType) {
        this.a();
        String string3 = n.b(string2, n2, n3, scaleType);
        return this.c.a(string3) != null;
    }

    private class a {
        private final com.tappx.b.n<?> b;
        private Bitmap c;
        private u d;
        private final LinkedList<c> e = new LinkedList();

        public a(com.tappx.b.n<?> n3, c c2) {
            this.b = n3;
            this.e.add((Object)c2);
        }

        public u a() {
            return this.d;
        }

        public void a(c c2) {
            this.e.add((Object)c2);
        }

        public void a(u u2) {
            this.d = u2;
        }

        public boolean b(c c2) {
            this.e.remove((Object)c2);
            if (this.e.size() == 0) {
                this.b.n();
                return true;
            }
            return false;
        }
    }

    public static interface b {
        public Bitmap a(String var1);

        public void a(String var1, Bitmap var2);
    }

    public class c {
        private Bitmap b;
        private final d c;
        private final String d;
        private final String e;

        public c(Bitmap bitmap, String string2, String string3, d d2) {
            this.b = bitmap;
            this.e = string2;
            this.d = string3;
            this.c = d2;
        }

        public void a() {
            if (this.c == null) {
                return;
            }
            a a2 = (a)n.this.d.get((Object)this.d);
            if (a2 != null) {
                if (a2.b(this)) {
                    n.this.d.remove((Object)this.d);
                    return;
                }
            } else {
                a a3 = (a)n.this.e.get((Object)this.d);
                if (a3 != null) {
                    a3.b(this);
                    if (a3.e.size() == 0) {
                        n.this.e.remove((Object)this.d);
                    }
                }
            }
        }

        public Bitmap b() {
            return this.b;
        }

        public String c() {
            return this.e;
        }
    }

}

