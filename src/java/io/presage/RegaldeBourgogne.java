/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.webkit.WebView
 *  io.presage.RegaldeBourgogne$CamembertauCalvados
 *  io.presage.RegaldeBourgogne$CamembertdeNormandie
 *  io.presage.j
 *  io.presage.l
 *  java.lang.Integer
 *  java.lang.Number
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package io.presage;

import android.content.Context;
import android.webkit.WebView;
import io.presage.Murol;
import io.presage.Piastrellou;
import io.presage.RegaldeBourgogne;
import io.presage.cc;
import io.presage.cd;
import io.presage.cl;
import io.presage.j;
import io.presage.l;

public final class RegaldeBourgogne {
    private transient j a;
    private cd<? super Integer, Integer> b;
    private final Piastrellou c;

    public RegaldeBourgogne(Context context) {
        this(new Piastrellou(context));
    }

    private RegaldeBourgogne(Piastrellou piastrellou) {
        this.c = piastrellou;
        this.b = (cd)CamembertdeNormandie.a;
    }

    public RegaldeBourgogne(j j2) {
        Context context = j2.getContext();
        cl.a((Object)context, "webView.context");
        this(new Piastrellou(context));
        this.a = j2;
    }

    private final void a(int n2) {
        j j2 = this.a;
        if (j2 != null) {
            StringBuilder stringBuilder = new StringBuilder("ogySdkMraidGateway.updateAudioVolume(");
            stringBuilder.append(n2);
            stringBuilder.append(')');
            l.a((j)j2, (String)stringBuilder.toString());
        }
    }

    private final void a(int n2, int n3) {
        j j2 = this.a;
        if (j2 != null) {
            StringBuilder stringBuilder = new StringBuilder("ogySdkMraidGateway.updateScreenSize({width: ");
            stringBuilder.append(n2);
            stringBuilder.append(", height: ");
            stringBuilder.append(n3);
            stringBuilder.append("})");
            l.a((j)j2, (String)stringBuilder.toString());
        }
    }

    private final void a(int n2, int n3, int n4, int n5) {
        j j2 = this.a;
        if (j2 != null) {
            StringBuilder stringBuilder = new StringBuilder("ogySdkMraidGateway.updateCurrentPosition({x: ");
            stringBuilder.append(n4);
            stringBuilder.append(", y: ");
            stringBuilder.append(n5);
            stringBuilder.append(", width: ");
            stringBuilder.append(n2);
            stringBuilder.append(", height: ");
            stringBuilder.append(n3);
            stringBuilder.append("})");
            l.a((j)j2, (String)stringBuilder.toString());
        }
    }

    private final void a(Piastrellou piastrellou) {
        String string2 = piastrellou.b();
        boolean bl2 = piastrellou.c();
        this.a(string2, bl2);
        if (!bl2) {
            string2 = "none";
        }
        this.a(bl2 ^ true, string2);
    }

    public static final /* synthetic */ void a(RegaldeBourgogne regaldeBourgogne) {
        regaldeBourgogne.d();
    }

    private final void a(String string2) {
        j j2 = this.a;
        if (j2 != null) {
            StringBuilder stringBuilder = new StringBuilder("ogySdkMraidGateway.updatePlacementType(\"");
            stringBuilder.append(string2);
            stringBuilder.append("\")");
            l.a((j)j2, (String)stringBuilder.toString());
        }
    }

    private final void a(String string2, boolean bl2) {
        j j2 = this.a;
        if (j2 != null) {
            StringBuilder stringBuilder = new StringBuilder("ogySdkMraidGateway.updateCurrentAppOrientation({orientation: \"");
            stringBuilder.append(string2);
            stringBuilder.append("\", locked: ");
            stringBuilder.append(bl2);
            stringBuilder.append("})");
            l.a((j)j2, (String)stringBuilder.toString());
        }
    }

    private final void a(boolean bl2) {
        j j2 = this.a;
        if (j2 != null) {
            StringBuilder stringBuilder = new StringBuilder("ogySdkMraidGateway.updateViewability(");
            stringBuilder.append(bl2);
            stringBuilder.append(')');
            l.a((j)j2, (String)stringBuilder.toString());
        }
    }

    private final void a(boolean bl2, String string2) {
        j j2 = this.a;
        if (j2 != null) {
            StringBuilder stringBuilder = new StringBuilder("ogySdkMraidGateway.updateOrientationProperties({allowOrientationChange: ");
            stringBuilder.append(bl2);
            stringBuilder.append(", forceOrientation: \"");
            stringBuilder.append(string2);
            stringBuilder.append("\"})");
            l.a((j)j2, (String)stringBuilder.toString());
        }
    }

    private final void b(int n2, int n3) {
        j j2 = this.a;
        if (j2 != null) {
            StringBuilder stringBuilder = new StringBuilder("ogySdkMraidGateway.updateMaxSize({width: ");
            stringBuilder.append(n2);
            stringBuilder.append(", height: ");
            stringBuilder.append(n3);
            stringBuilder.append("})");
            l.a((j)j2, (String)stringBuilder.toString());
        }
    }

    private final void b(int n2, int n3, int n4, int n5) {
        j j2 = this.a;
        if (j2 != null) {
            StringBuilder stringBuilder = new StringBuilder("ogySdkMraidGateway.updateResizeProperties({width: ");
            stringBuilder.append(n2);
            stringBuilder.append(", height: ");
            stringBuilder.append(n3);
            stringBuilder.append(", offsetX: ");
            stringBuilder.append(n4);
            stringBuilder.append(", offsetY: ");
            stringBuilder.append(n5);
            stringBuilder.append(", customClosePosition: \"right\", allowOffscreen: false})");
            l.a((j)j2, (String)stringBuilder.toString());
        }
    }

    private final void b(String string2) {
        j j2 = this.a;
        if (j2 != null) {
            StringBuilder stringBuilder = new StringBuilder("ogySdkMraidGateway.updateState(\"");
            stringBuilder.append(string2);
            stringBuilder.append("\")");
            l.a((j)j2, (String)stringBuilder.toString());
        }
    }

    private final void c(int n2, int n3) {
        j j2 = this.a;
        if (j2 != null) {
            StringBuilder stringBuilder = new StringBuilder("ogySdkMraidGateway.updateDefaultPosition({x: 0, y: 0, width: ");
            stringBuilder.append(n2);
            stringBuilder.append(", height: ");
            stringBuilder.append(n3);
            stringBuilder.append("})");
            l.a((j)j2, (String)stringBuilder.toString());
        }
    }

    private final void d() {
        j j2 = this.a;
        if (j2 == null) {
            return;
        }
        int n2 = ((Number)this.b.a((Integer)j2.getWidth())).intValue();
        int n3 = ((Number)this.b.a((Integer)j2.getHeight())).intValue();
        this.a(true);
        this.e(n2, n3);
    }

    private final void d(int n2, int n3) {
        j j2 = this.a;
        if (j2 != null) {
            StringBuilder stringBuilder = new StringBuilder("ogySdkMraidGateway.updateExpandProperties({width: ");
            stringBuilder.append(n2);
            stringBuilder.append(", height: ");
            stringBuilder.append(n3);
            stringBuilder.append(", useCustomClose: false, isModal: true})");
            l.a((j)j2, (String)stringBuilder.toString());
        }
    }

    private final void e() {
        j j2 = this.a;
        if (j2 != null) {
            l.a((j)j2, (String)"ogySdkMraidGateway.updateSupportFlags({sms: false, tel: false, calendar: false, storePicture: false, inlineVideo: false, vpaid: false, location: false})");
        }
    }

    private final void e(int n2, int n3) {
        j j2 = this.a;
        if (j2 != null) {
            StringBuilder stringBuilder = new StringBuilder("ogySdkMraidGateway.updateExposure({exposedPercentage: 100.0, visibleRectangle: {x: 0, y: 0, width: ");
            stringBuilder.append(n2);
            stringBuilder.append(", height: ");
            stringBuilder.append(n3);
            stringBuilder.append("}})");
            l.a((j)j2, (String)stringBuilder.toString());
        }
    }

    public final void a() {
        j j2 = this.a;
        if (j2 == null) {
            return;
        }
        Murol.a((WebView)j2, (cc)new CamembertauCalvados(this));
    }

    public final void a(j j2) {
        this.a = j2;
    }

    public final void a(String string2, String string3) {
        j j2 = this.a;
        if (j2 != null) {
            StringBuilder stringBuilder = new StringBuilder("ogySdkMraidGateway.callErrorListeners(\"");
            stringBuilder.append(string3);
            stringBuilder.append("\", \"");
            stringBuilder.append(string2);
            stringBuilder.append("\")");
            l.a((j)j2, (String)stringBuilder.toString());
        }
    }

    public final void b() {
        j j2 = this.a;
        if (j2 == null) {
            return;
        }
        int n2 = ((Number)this.b.a((Integer)j2.getWidth())).intValue();
        int n3 = ((Number)this.b.a((Integer)j2.getHeight())).intValue();
        int n4 = (int)j2.getX();
        int n5 = (int)j2.getY();
        this.a(n2, n3);
        this.a("interstitial");
        this.a(false);
        this.a(this.c.a());
        this.e();
        this.a(this.c);
        this.b(n2, n3);
        this.c(n2, n3);
        this.a(n2, n3, n4, n5);
        this.b(n2, n3, n4, n5);
        this.d(n2, n3);
        this.b("default");
    }

    public final void b(j j2) {
        this.a = j2;
        this.a();
    }

    public final void b(String string2, String string3) {
        j j2 = this.a;
        if (j2 != null) {
            StringBuilder stringBuilder = new StringBuilder("ogySdkMraidGateway.callPendingMethodCallback(\"");
            stringBuilder.append(string2);
            stringBuilder.append("\", null, ");
            stringBuilder.append(string3);
            stringBuilder.append(')');
            l.a((j)j2, (String)stringBuilder.toString());
        }
    }

    public final void c() {
        this.a(false);
        this.b("hidden");
    }
}

