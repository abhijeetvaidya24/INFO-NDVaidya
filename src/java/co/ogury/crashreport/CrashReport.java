/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Thread
 *  java.lang.Thread$UncaughtExceptionHandler
 *  java.lang.Throwable
 */
package co.ogury.crashreport;

import android.content.Context;
import co.ogury.crashreport.CrashConfig;
import co.ogury.crashreport.Helvetica;
import co.ogury.crashreport.SdkInfo;
import co.ogury.crashreport.cocoartf1671;
import co.ogury.crashreport.cocoasubrtf100;
import co.ogury.crashreport.fcharset0;
import co.ogury.crashreport.fonttbl;
import co.ogury.crashreport.fswiss;
import co.ogury.crashreport.tx1440;
import co.ogury.crashreport.tx6480;
import co.ogury.crashreport.tx8640;
import co.ogury.crashreport.vieww10800;

public final class CrashReport {
    private static boolean a;
    private static cocoartf1671 b;

    static {
        new CrashReport();
    }

    private CrashReport() {
    }

    public static final void logException(Exception exception) {
        tx8640.b((Object)exception, "e");
        cocoartf1671 cocoartf16712 = b;
        if (cocoartf16712 != null) {
            cocoartf16712.a((Throwable)exception);
        }
    }

    public static final void register(Context context, SdkInfo sdkInfo, CrashConfig crashConfig) {
        cocoartf1671 cocoartf16712;
        tx8640.b((Object)context, "context");
        tx8640.b(sdkInfo, "sdkInfo");
        tx8640.b(crashConfig, "crashConfig");
        fonttbl fonttbl2 = new fonttbl(context);
        cocoasubrtf100 cocoasubrtf1002 = new cocoasubrtf100(sdkInfo);
        Helvetica helvetica = new Helvetica(context);
        b = cocoartf16712 = new cocoartf1671(context, cocoasubrtf1002, helvetica);
        helvetica.a(crashConfig.getPackageName());
        fonttbl2.a(crashConfig.getPackageName(), crashConfig.getUrl());
        tx1440.a(true, false, null, null, -1, new tx6480<vieww10800>(new fswiss(cocoartf16712, fonttbl2)){
            private /* synthetic */ fswiss a;
            {
                this.a = fswiss2;
                super(0);
            }
        });
        if (!a) {
            tx8640.b(cocoartf16712, "crashFileStore");
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
            if (!(uncaughtExceptionHandler instanceof fcharset0)) {
                Thread.setDefaultUncaughtExceptionHandler((Thread.UncaughtExceptionHandler)new fcharset0(cocoartf16712, uncaughtExceptionHandler));
            }
        }
        a = true;
    }
}

