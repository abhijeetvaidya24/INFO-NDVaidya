/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.PackageManager
 *  co.ogury.crashreport.CrashReport
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 */
package io.presage;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import co.ogury.crashreport.CrashReport;

public final class BurratadesPouilles {
    public static final BurratadesPouilles a = new BurratadesPouilles();
    private static boolean b;

    private BurratadesPouilles() {
    }

    public static final void a(Context context) {
        int n2 = 2 & context.getPackageManager().getApplicationInfo((String)context.getPackageName(), (int)0).flags;
        boolean bl2 = false;
        if (n2 != 0) {
            bl2 = true;
        }
        b = bl2;
    }

    public static void a(Throwable throwable) {
        if (!b) {
            CrashReport.logException((Exception)((Exception)throwable));
            return;
        }
        throw throwable;
    }
}

