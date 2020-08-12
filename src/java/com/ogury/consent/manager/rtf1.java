/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.ConnectivityManager
 *  android.net.NetworkInfo
 *  android.os.Handler
 *  android.os.Looper
 *  co.ogury.crashreport.CrashConfig
 *  co.ogury.crashreport.CrashReport
 *  co.ogury.crashreport.SdkInfo
 *  com.ogury.consent.manager.rtf1$ansi
 *  com.ogury.consent.manager.rtf1$ansicpg1252
 *  com.ogury.consent.manager.rtf1$f0
 *  com.ogury.consent.manager.rtf1$fonttbl
 *  java.io.Reader
 *  java.io.Writer
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.util.Date
 *  org.json.JSONObject
 */
package com.ogury.consent.manager;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Looper;
import co.ogury.crashreport.CrashConfig;
import co.ogury.crashreport.CrashReport;
import co.ogury.crashreport.SdkInfo;
import com.ogury.consent.manager.ConsentListener;
import com.ogury.consent.manager.ConsentManager;
import com.ogury.consent.manager.Helvetica;
import com.ogury.consent.manager.blue255;
import com.ogury.consent.manager.colortbl;
import com.ogury.consent.manager.expandedcolortbl;
import com.ogury.consent.manager.fs24;
import com.ogury.consent.manager.fswiss;
import com.ogury.consent.manager.margl1440;
import com.ogury.consent.manager.rtf1;
import com.ogury.consent.manager.tx4320;
import com.ogury.consent.manager.tx5040;
import com.ogury.consent.manager.tx6480;
import com.ogury.consent.manager.tx720;
import com.ogury.consent.manager.tx7200;
import com.ogury.consent.manager.util.consent.ConsentException;
import com.ogury.consent.manager.vieww10800;
import java.io.Reader;
import java.io.Writer;
import java.util.Date;
import org.json.JSONObject;

public final class rtf1 {
    public static final rtf1 a = new rtf1(null);
    private tx7200 b = new tx7200();
    private final com.ogury.consent.manager.fonttbl c = new com.ogury.consent.manager.fonttbl();
    private String d = "";
    private final Handler e = new Handler(Looper.getMainLooper());
    private com.ogury.consent.manager.util.consent.rtf1 f;
    private boolean g;

    public static final /* synthetic */ String a(rtf1 rtf12) {
        return rtf12.d;
    }

    private final void a(Context context) {
        boolean bl2;
        if (!tx7200.a(context)) {
            com.ogury.consent.manager.util.consent.rtf1 rtf12 = this.f;
            if (rtf12 == null) {
                tx6480.a("consentCallback");
            }
            rtf12.a(new ConsentException("no-internet-connection", ""));
            bl2 = false;
        } else {
            boolean bl3 = ((CharSequence)com.ogury.consent.manager.util.consent.ansi.b().a()).length() == 0;
            if (bl3) {
                com.ogury.consent.manager.util.consent.rtf1 rtf13 = this.f;
                if (rtf13 == null) {
                    tx6480.a("consentCallback");
                }
                rtf13.a(new ConsentException("system-error", ""));
                com.ogury.consent.manager.util.consent.cocoasubrtf100.a("missing consent configuration");
                bl2 = false;
            } else {
                bl2 = true;
            }
        }
        if (bl2) {
            com.ogury.consent.manager.util.consent.rtf1 rtf14 = this.f;
            if (rtf14 == null) {
                tx6480.a("consentCallback");
            }
            com.ogury.consent.manager.ansicpg1252.a(context, rtf14);
        }
    }

    public static void a(Context context, String string2) {
        tx6480.b((Object)context, "context");
        tx6480.b(string2, "bundle");
        margl1440 margl14402 = com.ogury.consent.manager.util.consent.ansi.c();
        Context context2 = context.getApplicationContext();
        tx6480.a((Object)context2, "context.applicationContext");
        String string3 = context2.getPackageName();
        tx6480.a((Object)string3, "context.applicationContext.packageName");
        margl14402.a(string3);
    }

    public static final /* synthetic */ void a(rtf1 rtf12, Context context, String string2) {
        try {
            SdkInfo sdkInfo = new SdkInfo("1.1.4", string2, com.ogury.consent.manager.util.consent.ansi.c().b());
            CrashReport.register((Context)context, (SdkInfo)sdkInfo, (CrashConfig)new CrashConfig(com.ogury.consent.manager.util.consent.ansi.c().c(), context.getPackageName()));
            return;
        }
        catch (Exception exception) {
            com.ogury.consent.manager.util.consent.cocoasubrtf100.a("crash report init failed");
            return;
        }
    }

    public static final /* synthetic */ void a(rtf1 rtf12, String string2, Context context) {
        if (tx6480.a((Object)string2, (Object)"edit")) {
            rtf12.a(context);
            return;
        }
        boolean bl2 = ((CharSequence)com.ogury.consent.manager.util.consent.ansi.b().b()).length() > 0;
        if (bl2) {
            rtf12.a(context);
            return;
        }
        rtf12.c();
    }

    public static final /* synthetic */ void a(rtf1 rtf12, String string2, String string3) {
        rtf12.a(string2, string3);
    }

    public static final /* synthetic */ void a(final rtf1 rtf12, String string2, final String string3, final Context context) {
        boolean bl2 = ((CharSequence)string2).length() == 0;
        if (bl2) {
            rtf12.e.post(new Runnable(){

                public final void run() {
                    rtf1.a(rtf12, string3, context);
                }
            });
            new fswiss();
            fswiss.a(rtf12.d, context);
            return;
        }
        rtf12.a("", string2);
    }

    public static void a(String string2) {
        tx6480.b(string2, "showFormat");
    }

    private final void a(String string2, Context context) {
        com.ogury.consent.manager.util.consent.ansi.f();
        ansicpg1252 ansicpg12522 = new ansicpg1252(this, string2, context);
        expandedcolortbl expandedcolortbl2 = new expandedcolortbl();
        new com.ogury.consent.manager.f0();
        tx720.a(true, false, null, null, -1, (tx4320)new ansi(this, new blue255(expandedcolortbl2.b(com.ogury.consent.manager.f0.a(context, this.d)).a("POST").c("https://consent-manager-events.ogury.io/v1/".concat(String.valueOf((Object)string2))).a((com.ogury.consent.manager.util.consent.rtf1)ansicpg12522))));
    }

    private final void a(final String string2, final String string3) {
        this.e.post(new Runnable(){

            public final void run() {
                com.ogury.consent.manager.util.consent.rtf1 rtf12 = rtf1.c(this);
                String string22 = string3;
                String string32 = string2;
                if (string32 == null) {
                    string32 = "";
                }
                rtf12.a(new ConsentException(string22, string32));
            }
        });
    }

    public static boolean a(ConsentManager.Purpose purpose) {
        tx6480.b((Object)purpose, "purpose");
        if (com.ogury.consent.manager.util.consent.ansi.a().c() == ConsentManager.Answer.FULL_APPROVAL) {
            return true;
        }
        if (com.ogury.consent.manager.util.consent.ansi.a().c() == ConsentManager.Answer.REFUSAL) {
            return false;
        }
        return fs24.a((CharSequence)com.ogury.consent.manager.util.consent.ansi.a().e(), (CharSequence)String.valueOf((int)(1 + purpose.ordinal())), false, 2, null);
    }

    public static final /* synthetic */ com.ogury.consent.manager.fonttbl b(rtf1 rtf12) {
        return rtf12.c;
    }

    public static String b() {
        boolean bl2 = ((CharSequence)com.ogury.consent.manager.util.consent.ansi.a().d()).length() > 0;
        if (bl2) {
            return com.ogury.consent.manager.util.consent.ansi.a().d();
        }
        return "";
    }

    public static final /* synthetic */ void b(rtf1 rtf12, Context context, String string2) {
        new fswiss();
        fswiss.b(string2, context);
        rtf12.d = string2;
    }

    public static final /* synthetic */ void b(rtf1 rtf12, String string2, Context context) {
        if (tx6480.a((Object)string2, (Object)"edit")) {
            rtf12.a("edit", context);
            return;
        }
        if (!com.ogury.consent.manager.util.consent.ansi.d().after(new Date())) {
            rtf12.a("ask", context);
            return;
        }
        rtf12.c();
    }

    public static boolean b(String string2) {
        tx6480.b(string2, "vendor");
        if (com.ogury.consent.manager.util.consent.ansi.a().c() == ConsentManager.Answer.FULL_APPROVAL) {
            return true;
        }
        if (com.ogury.consent.manager.util.consent.ansi.a().c() != ConsentManager.Answer.REFUSAL) {
            boolean bl2 = ((CharSequence)com.ogury.consent.manager.util.consent.ansi.a().a()).length() > 0;
            if (bl2 && true ^ tx6480.a((Object)com.ogury.consent.manager.util.consent.ansi.a().a(), (Object)"null")) {
                return fs24.a((CharSequence)com.ogury.consent.manager.util.consent.ansi.a().a(), (CharSequence)string2, false, 2, null);
            }
            if (!fs24.a((CharSequence)com.ogury.consent.manager.util.consent.ansi.a().b(), (CharSequence)string2, false, 2, null)) {
                return true;
            }
        }
        return false;
    }

    public static final /* synthetic */ com.ogury.consent.manager.util.consent.rtf1 c(rtf1 rtf12) {
        com.ogury.consent.manager.util.consent.rtf1 rtf13 = rtf12.f;
        if (rtf13 == null) {
            tx6480.a("consentCallback");
        }
        return rtf13;
    }

    private final void c() {
        if (com.ogury.consent.manager.util.consent.ansi.a().c() != ConsentManager.Answer.NO_ANSWER) {
            com.ogury.consent.manager.util.consent.rtf1 rtf12 = this.f;
            if (rtf12 == null) {
                tx6480.a("consentCallback");
            }
            rtf12.a(com.ogury.consent.manager.util.consent.ansi.a().c().toString());
            return;
        }
        com.ogury.consent.manager.util.consent.rtf1 rtf13 = this.f;
        if (rtf13 == null) {
            tx6480.a("consentCallback");
        }
        rtf13.a(new ConsentException("consent-not-received", ""));
    }

    public static final /* synthetic */ Handler d(rtf1 rtf12) {
        return rtf12.e;
    }

    public final void a(Context context, String string2, String string3) {
        tx6480.b((Object)context, "context");
        tx6480.b(string2, "assetKey");
        tx6480.b(string3, "requestType");
        this.g = true;
        if (tx7200.a(context)) {
            colortbl.a(context, (Helvetica)new fonttbl(this, context, string2, string3));
            return;
        }
        com.ogury.consent.manager.util.consent.rtf1 rtf12 = this.f;
        if (rtf12 == null) {
            tx6480.a("consentCallback");
        }
        rtf12.a(new ConsentException("no-internet-connection", ""));
    }

    public final void a(ConsentListener consentListener) {
        tx6480.b(consentListener, "listener");
        this.f = (com.ogury.consent.manager.util.consent.rtf1)new f0(this, consentListener);
    }

    public final void a(boolean bl2) {
        this.g = false;
    }

    public final boolean a() {
        return this.g;
    }

    public static final class rtf1 {
        private rtf1() {
        }

        public /* synthetic */ rtf1(tx5040 tx50402) {
            this();
        }

        private static int a(int n2, int n3) {
            int n4 = n2 % 1;
            if (n4 >= 0) {
                return n4;
            }
            return n4 + 1;
        }

        public static int a(int n2, int n3, int n4) {
            if (n2 >= n3) {
                return n3;
            }
            return n3 - rtf1.a(rtf1.a(n3, 1) - rtf1.a(n2, 1), 1);
        }

        public static long a(Reader reader, Writer writer, int n2) {
            tx6480.b((Object)reader, "$receiver");
            tx6480.b((Object)writer, "out");
            char[] arrc = new char[8192];
            int n3 = reader.read(arrc);
            long l2 = 0L;
            while (n3 >= 0) {
                writer.write(arrc, 0, n3);
                l2 += (long)n3;
                n3 = reader.read(arrc);
            }
            return l2;
        }

        public static NetworkInfo a(Context context) {
            tx6480.b((Object)context, "$receiver");
            tx6480.b((Object)context, "$receiver");
            tx6480.b("android.permission.ACCESS_NETWORK_STATE", "permission");
            boolean bl2 = context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0;
            if (bl2) {
                Object object = context.getSystemService("connectivity");
                if (object != null) {
                    return ((ConnectivityManager)object).getActiveNetworkInfo();
                }
                throw new vieww10800("null cannot be cast to non-null type android.net.ConnectivityManager");
            }
            return null;
        }

        public static JSONObject a(String string2) {
            tx6480.b(string2, "$receiver");
            try {
                JSONObject jSONObject = new JSONObject(string2);
                return jSONObject;
            }
            catch (Exception exception) {
                return null;
            }
        }

        public static ConsentManager.Answer b(String string2) {
            tx6480.b(string2, "$receiver");
            if (tx6480.a((Object)string2, (Object)ConsentManager.Answer.FULL_APPROVAL.toString())) {
                return ConsentManager.Answer.FULL_APPROVAL;
            }
            if (tx6480.a((Object)string2, (Object)ConsentManager.Answer.PARTIAL_APPROVAL.toString())) {
                return ConsentManager.Answer.PARTIAL_APPROVAL;
            }
            if (tx6480.a((Object)string2, (Object)ConsentManager.Answer.REFUSAL.toString())) {
                return ConsentManager.Answer.REFUSAL;
            }
            return ConsentManager.Answer.NO_ANSWER;
        }

        public static boolean b(Context context) {
            tx6480.b((Object)context, "$receiver");
            NetworkInfo networkInfo = rtf1.a(context);
            return networkInfo != null && networkInfo.isConnected();
        }
    }

}

