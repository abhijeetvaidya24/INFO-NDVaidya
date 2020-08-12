/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageManager
 *  android.provider.Settings
 *  android.provider.Settings$Secure
 *  co.ogury.crashreport.CrashReport
 *  io.presage.at
 *  io.presage.ds
 *  java.lang.Exception
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.nio.charset.Charset
 *  java.util.ArrayList
 *  java.util.Comparator
 *  java.util.List
 *  java.util.UUID
 */
package io.presage;

import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.provider.Settings;
import co.ogury.crashreport.CrashReport;
import io.presage.CureNantais;
import io.presage.DelicedesFiouves;
import io.presage.EmmentalGrandCru;
import io.presage.ak;
import io.presage.at;
import io.presage.cl;
import io.presage.ds;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

public final class CremeuxduJura {
    public static final CremeuxduJura a = new CremeuxduJura();

    private CremeuxduJura() {
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static EmmentalGrandCru a(Context context) {
        String string2;
        boolean bl2;
        try {
            CureNantais cureNantais = DelicedesFiouves.a(context);
            string2 = cureNantais.a();
            if (string2 == null) throw (Throwable)new IllegalStateException("androidAdvertisingId is null");
            if (!cureNantais.b()) {
                bl2 = true;
                return new EmmentalGrandCru(string2, bl2, false);
            }
        }
        catch (Exception exception) {
            CrashReport.logException((Exception)exception);
            try {
                return CremeuxduJura.b(context);
            }
            catch (Exception exception2) {
                CrashReport.logException((Exception)exception2);
                return new EmmentalGrandCru(CremeuxduJura.c(context), true, true);
            }
        }
        bl2 = false;
        return new EmmentalGrandCru(string2, bl2, false);
    }

    private static String a(Context context, ApplicationInfo applicationInfo) {
        long l2;
        try {
            l2 = context.getPackageManager().getPackageInfo((String)applicationInfo.packageName, (int)128).firstInstallTime;
        }
        catch (Exception exception) {
            CrashReport.logException((Exception)exception);
            return "00000000-0000-0000-0000-000000000000";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.valueOf((long)l2));
        String string2 = stringBuilder.toString();
        Charset charset = ds.a;
        if (string2 != null) {
            byte[] arrby = string2.getBytes(charset);
            cl.a((Object)arrby, "(this as java.lang.String).getBytes(charset)");
            String string3 = UUID.nameUUIDFromBytes((byte[])arrby).toString();
            cl.a((Object)string3, "UUID.nameUUIDFromBytes((\u2026toByteArray()).toString()");
            return string3;
        }
        throw new ak("null cannot be cast to non-null type java.lang.String");
    }

    private static EmmentalGrandCru b(Context context) {
        ContentResolver contentResolver = context.getContentResolver();
        String string2 = Settings.Secure.getString((ContentResolver)contentResolver, (String)"advertising_id");
        boolean bl2 = Settings.Secure.getInt((ContentResolver)contentResolver, (String)"limit_ad_tracking") == 0;
        if (string2 != null) {
            return new EmmentalGrandCru(string2, bl2, false);
        }
        throw (Throwable)new IllegalStateException("Amazon Fire TV aaid is null");
    }

    private static String c(Context context) {
        ApplicationInfo applicationInfo = CremeuxduJura.d(context);
        if (applicationInfo == null) {
            return "00000000-0000-0000-0000-000000000000";
        }
        return CremeuxduJura.a(context, applicationInfo);
    }

    private static ApplicationInfo d(Context context) {
        try {
            ApplicationInfo applicationInfo = CremeuxduJura.e(context);
            return applicationInfo;
        }
        catch (Exception exception) {
            return null;
        }
    }

    private static ApplicationInfo e(Context context) {
        if (context != null) {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return null;
            }
            List list = packageManager.getInstalledApplications(128);
            ArrayList arrayList = new ArrayList();
            if (list.size() == 0) {
                return null;
            }
            cl.a((Object)list, "apps");
            for (int i2 = 0; i2 < list.size(); ++i2) {
                ApplicationInfo applicationInfo = (ApplicationInfo)list.get(i2);
                if ((1 & applicationInfo.flags) == 0 || applicationInfo.packageName == null) continue;
                arrayList.add((Object)applicationInfo);
            }
            at.a((List)((List)arrayList), (Comparator)CamembertauCalvados.a);
            return (ApplicationInfo)arrayList.get(0);
        }
        return null;
    }

}

