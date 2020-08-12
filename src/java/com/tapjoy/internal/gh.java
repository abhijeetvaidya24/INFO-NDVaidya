/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnCancelListener
 *  android.content.DialogInterface$OnDismissListener
 *  android.graphics.Bitmap
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.SystemClock
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.Window
 *  android.view.WindowManager
 *  android.view.WindowManager$LayoutParams
 *  android.view.animation.Animation
 *  android.view.animation.ScaleAnimation
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 *  com.tapjoy.internal.hs
 *  java.lang.Boolean
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Map
 */
package com.tapjoy.internal;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import com.tapjoy.TapjoyErrorMessage;
import com.tapjoy.TapjoyLog;
import com.tapjoy.internal.ai;
import com.tapjoy.internal.aj;
import com.tapjoy.internal.ak;
import com.tapjoy.internal.al;
import com.tapjoy.internal.am;
import com.tapjoy.internal.ct;
import com.tapjoy.internal.e;
import com.tapjoy.internal.ep;
import com.tapjoy.internal.et;
import com.tapjoy.internal.ex;
import com.tapjoy.internal.ez;
import com.tapjoy.internal.fi;
import com.tapjoy.internal.fo;
import com.tapjoy.internal.fv;
import com.tapjoy.internal.gc;
import com.tapjoy.internal.gd;
import com.tapjoy.internal.gh;
import com.tapjoy.internal.gj;
import com.tapjoy.internal.gv;
import com.tapjoy.internal.gx;
import com.tapjoy.internal.gy;
import com.tapjoy.internal.ha;
import com.tapjoy.internal.hs;
import com.tapjoy.internal.ht;
import java.util.Map;

public class gh
extends gj {
    private static final String h = "gh";
    private static gh i;
    final String a;
    final gx b;
    private final gc j;
    private e k;
    private boolean l;
    private long m;
    private Context n;
    private boolean o = false;

    public gh(gc gc2, String string, gx gx2, Context context) {
        this.j = gc2;
        this.a = string;
        this.b = gx2;
        this.n = context;
    }

    /*
     * Exception decompiling
     */
    private static Boolean a(Context var0) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl23.1 : ACONST_NULL : trying to set 1 previously set to 0
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

    public static void a() {
        gh gh2 = i;
        if (gh2 != null) {
            gh2.e();
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private void a(final Activity var1_1, final gd var2_2, ez var3_3) {
        block15 : {
            if (this.l) {
                TapjoyLog.e(gh.h, new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.INTEGRATION_ERROR, "Content is already displayed"));
                return;
            }
            this.l = true;
            gh.i = this;
            this.g = var3_3.a;
            this.k = new e((Context)var1_1);
            this.k.setOnCancelListener(new DialogInterface.OnCancelListener(this, var2_2){
                final /* synthetic */ gd a;
                final /* synthetic */ gh b;
                {
                    this.b = gh2;
                    this.a = gd2;
                }

                public final void onCancel(DialogInterface dialogInterface) {
                    this.a.d(this.b.a);
                }
            });
            this.k.setOnDismissListener(new DialogInterface.OnDismissListener(this, var1_1, var2_2){
                final /* synthetic */ Activity a;
                final /* synthetic */ gd b;
                final /* synthetic */ gh c;
                {
                    this.c = gh2;
                    this.a = activity;
                    this.b = gd2;
                }

                public final void onDismiss(DialogInterface dialogInterface) {
                    Activity activity;
                    String string;
                    gh.d();
                    gj.a((Context)this.a, this.c.b.g);
                    gh.c(this.c).a(this.c.b.k, SystemClock.elapsedRealtime() - gh.b(this.c));
                    if (!this.c.d) {
                        this.b.a(this.c.a, this.c.f, this.c.b.h);
                    }
                    if (gh.d(this.c) && this.c.b.k != null && this.c.b.k.containsKey((Object)"action_id") && (string = this.c.b.k.get((Object)"action_id").toString()) != null && string.length() > 0) {
                        gc gc2 = gh.c(this.c);
                        if (gc2.b != null) {
                            String string2;
                            com.tapjoy.internal.gl gl2 = gc2.b;
                            String string3 = com.tapjoy.internal.gl.a();
                            String string4 = gl2.b.a();
                            String string5 = gl2.a.a();
                            if (string5 != null && string3.equals((Object)string5)) {
                                string2 = string4;
                            } else {
                                gl2.a.a(string3);
                                string2 = "";
                            }
                            boolean bl = string2.length() == 0;
                            if (!bl) {
                                if (!string2.contains((java.lang.CharSequence)string)) {
                                    java.lang.StringBuilder stringBuilder = new java.lang.StringBuilder(",");
                                    stringBuilder.append(string);
                                    string = string2.concat(stringBuilder.toString());
                                } else {
                                    string = string2;
                                }
                            }
                            gl2.b.a(string);
                        }
                    }
                    if ((activity = this.a) instanceof com.tapjoy.TJContentActivity) {
                        activity.finish();
                    }
                }
            });
            this.k.setCanceledOnTouchOutside(false);
            var4_4 = new ht((Context)var1_1, this.b, new ht.a(){

                @Override
                public final void a() {
                    gh.this.k.cancel();
                }

                @Override
                public final void a(gv gv2) {
                    ex ex2;
                    if (gh.this.g instanceof ex && (ex2 = (ex)gh.this.g) != null && ex2.c != null) {
                        ex2.c.a();
                    }
                    gh.this.j.a(gh.this.b.k, gv2.b);
                    gj.a((Context)var1_1, gv2.d);
                    if (!ct.c(gv2.e)) {
                        gh.this.e.a((Context)var1_1, gv2.e, ct.b(gv2.f));
                        gh.this.d = true;
                    }
                    var2_2.a(gh.this.a, gv2.g);
                    if (gv2.c) {
                        gh.this.k.dismiss();
                    }
                }

                @Override
                public final void b() {
                    gh gh2 = gh.this;
                    gh2.o = true ^ gh2.o;
                }
            });
            var5_5 = new hs((Context)var1_1, this.b, var4_4);
            var6_6 = new FrameLayout((Context)var1_1);
            var6_6.addView((View)var5_5, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-2, -2, 17));
            this.k.setContentView((View)var6_6);
            if (!Boolean.FALSE.booleanValue()) break block15;
            var10_7 = this.k.getWindow();
            if (Build.VERSION.SDK_INT != 16 || !"4.1.2".equals((Object)Build.VERSION.RELEASE)) ** GOTO lbl23
            if (Boolean.FALSE.equals((Object)gh.a(var10_7.getContext()))) {
                var11_8 = false;
            } else {
                var10_7.setFlags(16777216, 16777216);
lbl23: // 2 sources:
                var11_8 = true;
            }
            if (var11_8) {
                var12_9 = ai.a.b;
                var13_10 = new aj();
                var14_11 = ai.1.a[var12_9 - 1];
                if (var14_11 != 1) {
                    if (var14_11 != 2) {
                        if (var14_11 != 3) {
                            if (var14_11 == 4) {
                                var21_12 = new al();
                                var21_12.a = true;
                                var21_12.b = 60.0f;
                                var13_10.a(var21_12.a()).a((Animation)new ScaleAnimation(0.4f, 1.0f, 0.4f, 1.0f)).a(new am().a(0.3f).b(-0.4f).a());
                            }
                        } else {
                            var19_13 = new al();
                            var19_13.a = true;
                            var19_13.b = -60.0f;
                            var13_10.a(var19_13.a()).a((Animation)new ScaleAnimation(0.4f, 1.0f, 0.4f, 1.0f)).a(new am().a(0.3f).b(1.0f).a());
                        }
                    } else {
                        var17_14 = new al();
                        var17_14.a = false;
                        var17_14.b = -60.0f;
                        var13_10.a(var17_14.a()).a((Animation)new ScaleAnimation(0.4f, 1.0f, 0.4f, 1.0f)).a(new am().a(-0.4f).b(0.3f).a());
                    }
                } else {
                    var15_15 = new al();
                    var15_15.a = false;
                    var15_15.b = 60.0f;
                    var13_10.a(var15_15.a()).a((Animation)new ScaleAnimation(0.4f, 1.0f, 0.4f, 1.0f)).a(new am().a(1.0f).b(0.3f).a());
                }
                var5_5.startAnimation(var13_10.b().a());
            }
        }
        this.k.show();
        this.k.getWindow().setLayout(-1, -1);
        if ((1024 & var1_1.getWindow().getAttributes().flags) != 0) {
            this.k.getWindow().setFlags(1024, 1024);
        }
        this.m = SystemClock.elapsedRealtime();
        this.j.a(this.b.k);
        var3_3.a();
        var8_16 = this.g;
        if (var8_16 != null) {
            var8_16.b();
        }
        var2_2.c(this.a);
    }

    static /* synthetic */ void a(gh gh2) {
        gh2.e();
    }

    static /* synthetic */ void a(gh gh2, Activity activity, gd gd2, ez ez2) {
        gh2.a(activity, gd2, ez2);
    }

    static /* synthetic */ long b(gh gh2) {
        return gh2.m;
    }

    static /* synthetic */ gh d() {
        i = null;
        return null;
    }

    private void e() {
        e e2 = this.k;
        if (e2 != null) {
            e2.dismiss();
        }
    }

    /*
     * Exception decompiling
     */
    @Override
    public final void a(gd var1, ez var2) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl22.1 : INVOKESTATIC : trying to set 0 previously set to 1
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

    @Override
    public final void b() {
        gx gx2 = this.b;
        if (gx2.a != null) {
            gx2.a.b();
        }
        if (gx2.b != null) {
            gx2.b.b();
        }
        gx2.c.b();
        if (gx2.e != null) {
            gx2.e.b();
        }
        if (gx2.f != null) {
            gx2.f.b();
        }
        if (gx2.m != null && gx2.m.a != null) {
            gx2.m.a.b();
        }
    }

    @Override
    public final boolean c() {
        gx gx2 = this.b;
        return gx2.c != null && gx2.c.b != null && (gx2.m == null || gx2.m.a == null || gx2.m.a.b != null) && (gx2.b != null && gx2.f != null && gx2.b.b != null && gx2.f.b != null || gx2.a != null && gx2.e != null && gx2.a.b != null && gx2.e.b != null);
    }

}

