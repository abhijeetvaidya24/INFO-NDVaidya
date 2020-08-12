/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Notification
 *  android.app.NotificationManager
 *  android.app.PendingIntent
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.content.res.Resources
 *  android.graphics.Bitmap
 *  android.graphics.BitmapFactory
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.text.Html
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 */
package com.tapjoy.internal;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import com.tapjoy.TapjoyReceiver;
import com.tapjoy.internal.a;
import com.tapjoy.internal.ct;
import com.tapjoy.internal.dy;
import com.tapjoy.internal.eb;
import com.tapjoy.internal.ef;
import com.tapjoy.internal.gb;
import com.tapjoy.internal.gc;
import com.tapjoy.internal.ge;
import com.tapjoy.internal.gf;
import com.tapjoy.internal.r;
import com.tapjoy.internal.t;

public final class ge
extends r {
    private static ge c;

    private ge(Context context) {
        super(context, new t(){

            public final String a(Context context) {
                return com.tapjoy.internal.gm.a((Context)context).b.getString("gcm.senderIds", "");
            }

            public final void a(Context context, int n2) {
                com.tapjoy.internal.p.a(com.tapjoy.internal.gm.a((Context)context).b, "gcm.appVersion", n2);
            }

            public final void a(Context context, long l2) {
                android.content.SharedPreferences$Editor editor = com.tapjoy.internal.gm.a((Context)context).b.edit();
                editor.putLong("gcm.onServerExpirationTime", l2);
                editor.commit();
            }

            public final void a(Context context, String string) {
                com.tapjoy.internal.p.a(com.tapjoy.internal.gm.a((Context)context).b, "gcm.senderIds", string);
            }

            public final void a(Context context, boolean bl) {
                com.tapjoy.internal.p.a(com.tapjoy.internal.gm.a((Context)context).b, "gcm.stale", bl);
            }

            public final String b(Context context) {
                return com.tapjoy.internal.gm.a((Context)context).b.getString("gcm.regId", "");
            }

            public final void b(Context context, int n2) {
                com.tapjoy.internal.p.a(com.tapjoy.internal.gm.a((Context)context).b, "gcm.backoff", n2);
            }

            public final void b(Context context, String string) {
                com.tapjoy.internal.p.a(com.tapjoy.internal.gm.a((Context)context).b, "gcm.regId", string);
            }

            public final void b(Context context, boolean bl) {
                com.tapjoy.internal.gm.a(context).a(bl);
            }

            public final boolean c(Context context) {
                return com.tapjoy.internal.gm.a((Context)context).b.getBoolean("gcm.stale", true);
            }

            public final int d(Context context) {
                return com.tapjoy.internal.gm.a((Context)context).b.getInt("gcm.appVersion", Integer.MIN_VALUE);
            }

            public final boolean e(Context context) {
                return com.tapjoy.internal.gm.a((Context)context).b.getBoolean("gcm.onServer", false);
            }

            public final long f(Context context) {
                return com.tapjoy.internal.gm.a((Context)context).b.getLong("gcm.onServerExpirationTime", 0L);
            }

            public final int g(Context context) {
                return com.tapjoy.internal.gm.a((Context)context).b.getInt("gcm.backoff", 0);
            }
        });
    }

    /*
     * Exception decompiling
     */
    private static int a(Bundle var0, String var1, Context var2) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl25.1 : ALOAD_3 : trying to set 1 previously set to 0
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

    private static Notification a(Context context, String string, String string2, String string3, boolean bl, boolean bl2, String string4, String string5, int n2) {
        PendingIntent pendingIntent;
        ApplicationInfo applicationInfo;
        int n3;
        Intent intent = new Intent(context.getApplicationContext(), TapjoyReceiver.class);
        intent.setAction("com.tapjoy.PUSH_CLICK");
        intent.putExtra("com.tapjoy.PUSH_ID", string);
        if (string4 != null) {
            intent.putExtra("com.tapjoy.PUSH_PAYLOAD", string4);
        }
        if (string5 != null) {
            intent.putExtra("com.tapjoy.PUSH_PLACEMENT", string5);
        }
        int n4 = 134217728;
        if (Build.VERSION.SDK_INT == 19) {
            n4 = 268435456;
        }
        if ((pendingIntent = PendingIntent.getBroadcast((Context)context.getApplicationContext(), (int)n2, (Intent)intent, (int)n4)) == null) {
            return null;
        }
        PackageManager packageManager = context.getPackageManager();
        String string6 = context.getPackageName();
        try {
            applicationInfo = packageManager.getApplicationInfo(string6, 128);
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            return null;
        }
        if (string2.length() == 0) {
            string2 = packageManager.getApplicationLabel(applicationInfo);
        } else if (bl) {
            string2 = Html.fromHtml((String)string2);
        }
        if (bl) {
            string3 = Html.fromHtml((String)string3);
        }
        if ((n3 = ge.a(applicationInfo.metaData, "com.tapjoy.notification.icon", context)) == 0) {
            n3 = applicationInfo.icon != 0 ? applicationInfo.icon : 17301651;
        }
        int n5 = ge.a(applicationInfo.metaData, "com.tapjoy.notification.icon.large", context);
        Bitmap bitmap = null;
        if (n5 != 0) {
            bitmap = BitmapFactory.decodeResource((Resources)context.getResources(), (int)n5);
        }
        a.d d2 = new a.d(context);
        d2.r.icon = n3;
        d2.r.tickerText = string2;
        d2.b = string2;
        d2.c = string3;
        d2.d = pendingIntent;
        Notification notification = d2.r;
        notification.flags = 16 | notification.flags;
        a.l l2 = new a.l(){
            public CharSequence a;
        };
        l2.e = string2;
        l2.a = string3;
        a.d d3 = d2.a(l2);
        if (bl2) {
            d3.r.defaults = 1;
        }
        if (bitmap != null) {
            d3.g = bitmap;
        }
        return a.a().a(d3);
    }

    private static boolean a(Object object) {
        return Boolean.TRUE.equals(object) || "true".equals(object);
        {
        }
    }

    /*
     * Exception decompiling
     */
    private static int b(Object var0) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl17.1 : ICONST_0 : trying to set 0 previously set to 1
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

    public static ge b(Context context) {
        Class<ge> class_ = ge.class;
        synchronized (ge.class) {
            if (c == null) {
                c = new ge(context);
            }
            ge ge2 = c;
            // ** MonitorExit[var3_1] (shouldn't be in output)
            return ge2;
        }
    }

    @Override
    protected final void a(int n2) {
        new Object[1][0] = n2;
    }

    @Override
    protected final void a(Context context, String string) {
        new Object[1][0] = string;
        gc.a(context).a(string);
    }

    @Override
    protected final boolean a(Context context, Intent intent) {
        Object[] arrobject = new Object[]{intent, intent.getExtras()};
        String string = intent.getStringExtra("fiverocks");
        if (string != null) {
            if (gf.a(context).f()) {
                gb gb2 = gc.a((Context)context).g;
                dy.a a2 = gb2.a(eb.APP, "push_ignore");
                a2.s = new ef(null, null, string);
                gb2.a(a2);
                return true;
            }
            String string2 = intent.getStringExtra("title");
            String string3 = intent.getStringExtra("message");
            if (string3 != null) {
                Bundle bundle = intent.getExtras();
                Object object = bundle.get("rich");
                Object object2 = bundle.get("sound");
                Object object3 = bundle.get("important");
                String string4 = bundle.getString("payload");
                Object object4 = bundle.get("always");
                boolean bl = "true".equals(object4) || Boolean.TRUE.equals(object4);
                Object object5 = bundle.get("repeatable");
                boolean bl2 = "true".equals(object5) || Boolean.TRUE.equals(object5);
                String string5 = bundle.getString("placement");
                int n2 = ge.b(bundle.get("nid"));
                if (bl || !gc.a(context).d()) {
                    String string6 = ct.a(string2);
                    boolean bl3 = ge.a(object);
                    boolean bl4 = ge.a(object2);
                    ge.a(object3);
                    Notification notification = ge.a(context, string, string6, string3, bl3, bl4, string4, string5, n2);
                    gc gc2 = gc.a(context);
                    long l2 = System.currentTimeMillis();
                    gc2.b(context);
                    boolean bl5 = gc2.f.a(string, l2, bl2);
                    boolean bl6 = false;
                    if (bl5) {
                        gb gb3 = gc2.g;
                        dy.a a3 = gb3.a(eb.APP, "push_show");
                        a3.s = new ef(null, null, string);
                        gb3.a(a3);
                        bl6 = true;
                    }
                    if (bl6) {
                        ((NotificationManager)context.getSystemService("notification")).notify(n2, notification);
                    }
                }
            }
            return true;
        }
        return false;
    }

    @Override
    protected final void b(String string) {
        new Object[1][0] = string;
        this.a();
    }

    @Override
    protected final boolean c(String string) {
        new Object[1][0] = string;
        return true;
    }

    @Override
    protected final boolean d(String string) {
        new Object[1][0] = string;
        return false;
    }

    final void e(String string) {
        if (string != null && string.length() > 0) {
            String[] arrstring = new String[]{string};
            super.a(this.a);
            super.a(arrstring[0]);
        }
    }
}

