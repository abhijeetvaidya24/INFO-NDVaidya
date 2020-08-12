/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.LocaleList
 *  android.telephony.TelephonyManager
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.Locale
 *  java.util.MissingResourceException
 */
package io.presage;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.LocaleList;
import android.telephony.TelephonyManager;
import io.presage.EpoissesdeBourgogne;
import io.presage.Mascare;
import io.presage.ak;
import io.presage.cl;
import java.util.Locale;
import java.util.MissingResourceException;

public final class Chaource {
    public static final CamembertauCalvados a = new CamembertauCalvados(0);
    private final EpoissesdeBourgogne b;
    private final Context c;

    public Chaource(Context context) {
        this.c = context;
        this.b = EpoissesdeBourgogne.CamembertauCalvados.a(this.c);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private final String e() {
        Object object;
        try {
            object = this.c.getSystemService("phone");
            if (object == null) throw new ak("null cannot be cast to non-null type android.telephony.TelephonyManager");
        }
        catch (Throwable throwable) {
            return null;
        }
        return new Locale("", ((TelephonyManager)object).getNetworkCountryIso()).getISO3Country();
    }

    private final String f() {
        block4 : {
            try {
                int n2 = Build.VERSION.SDK_INT;
                if (n2 < 24) break block4;
            }
            catch (MissingResourceException missingResourceException) {
                return "ZZZ";
            }
            Resources resources = this.c.getResources();
            cl.a((Object)resources, "context.resources");
            Configuration configuration = resources.getConfiguration();
            cl.a((Object)configuration, "context.resources.configuration");
            Locale locale = configuration.getLocales().get(0);
            cl.a((Object)locale, "context.resources.configuration.locales[0]");
            String string2 = locale.getISO3Country();
            cl.a((Object)string2, "context.resources.config\u2026on.locales[0].isO3Country");
            return string2;
        }
        Resources resources = this.c.getResources();
        cl.a((Object)resources, "context.resources");
        Locale locale = resources.getConfiguration().locale;
        cl.a((Object)locale, "context.resources.configuration.locale");
        String string3 = locale.getISO3Country();
        cl.a((Object)string3, "context.resources.configuration.locale.isO3Country");
        return string3;
    }

    public final String a() {
        return this.b.i();
    }

    public final boolean a(String string2) {
        return Mascare.a(this.c, string2);
    }

    public final String b() {
        if (Build.VERSION.SDK_INT >= 24) {
            Resources resources = this.c.getResources();
            cl.a((Object)resources, "context.resources");
            Configuration configuration = resources.getConfiguration();
            cl.a((Object)configuration, "context.resources.configuration");
            Locale locale = configuration.getLocales().get(0);
            cl.a((Object)locale, "context.resources.configuration.locales[0]");
            String string2 = locale.getLanguage();
            cl.a((Object)string2, "context.resources.config\u2026ation.locales[0].language");
            return string2;
        }
        Resources resources = this.c.getResources();
        cl.a((Object)resources, "context.resources");
        Locale locale = resources.getConfiguration().locale;
        cl.a((Object)locale, "context.resources.configuration.locale");
        String string3 = locale.getLanguage();
        cl.a((Object)string3, "context.resources.configuration.locale.language");
        return string3;
    }

    public final String c() {
        String string2 = this.e();
        if (string2 != null && string2.length() == 3) {
            return string2;
        }
        return this.f();
    }

    public final String d() {
        StringBuilder stringBuilder = new StringBuilder("3.0.36-moat/");
        stringBuilder.append(this.a());
        stringBuilder.append("/");
        stringBuilder.append(Build.VERSION.RELEASE);
        return stringBuilder.toString();
    }

    public static final class CamembertauCalvados {
        private CamembertauCalvados() {
        }

        public /* synthetic */ CamembertauCalvados(byte by) {
            this();
        }
    }

}

