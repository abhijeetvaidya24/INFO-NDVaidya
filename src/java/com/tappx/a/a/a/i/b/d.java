/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.net.Uri
 *  android.os.Bundle
 *  android.util.Base64
 *  java.io.BufferedReader
 *  java.io.InputStream
 *  java.io.InputStreamReader
 *  java.io.Reader
 *  java.io.UnsupportedEncodingException
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Double
 *  java.lang.Enum
 *  java.lang.Exception
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.net.HttpURLConnection
 *  java.net.URL
 *  java.net.URLConnection
 *  java.net.URLDecoder
 *  java.net.URLEncoder
 *  org.json.JSONObject
 */
package com.tappx.a.a.a.i.b;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Base64;
import com.tappx.a.a.a.d.ac;
import com.tappx.a.a.a.h;
import com.tappx.a.a.a.i.b.b;
import com.tappx.a.a.a.i.b.c;
import com.tappx.a.a.a.i.b.d;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.net.URLEncoder;
import org.json.JSONObject;

public class d
implements c {
    private static volatile c a;
    private static final String b = "Native";
    private static final String c = "2";
    private static final String d = "2";
    private final Context e;
    private final ac.a f;
    private a g;
    private String h;
    private String i;
    private String j;
    private String k = "";

    d(Context context, ac.a a2) {
        this.e = context.getApplicationContext();
        this.f = a2;
        this.g = a.a;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static final c a(Context context) {
        if (a != null) return a;
        Class<d> class_ = d.class;
        synchronized (d.class) {
            if (a != null) return a;
            a = new d(context.getApplicationContext(), ac.a.a(context));
            // ** MonitorExit[var2_1] (shouldn't be in output)
            return a;
        }
    }

    public static String a(int n2) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i2 = 0; i2 < n2; ++i2) {
            double d2 = Math.random();
            double d3 = 62;
            Double.isNaN((double)d3);
            stringBuilder.append("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890".charAt((int)(d2 * d3)));
        }
        return stringBuilder.toString();
    }

    private String a(CharSequence charSequence, String string) {
        if (charSequence != null) {
            return charSequence.toString();
        }
        return string;
    }

    private String a(String string, int n2) {
        String string2 = "";
        if (!string2.equals((Object)string)) {
            boolean bl = this.g != a.a;
            String string3 = d.a(string, bl);
            if (!string2.equals((Object)string3)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(d.a(3));
                stringBuilder.append(string3);
                string2 = stringBuilder.toString();
            } else {
                string2 = string3;
            }
        }
        if (n2 > 1) {
            return this.a(string2, n2 - 1);
        }
        return string2;
    }

    private String a(String string, int n2, int n3) {
        String string2 = this.a(string);
        for (int i2 = 0; i2 < n2; ++i2) {
            string2 = d.b(string2.substring(n3), false);
        }
        return string2;
    }

    public static String a(String string, boolean bl) {
        try {
            String string2 = Base64.encodeToString((byte[])string.getBytes("UTF-8"), (int)0);
            return string2;
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            if (bl) {
                unsupportedEncodingException.printStackTrace();
            }
            return "";
        }
    }

    static /* synthetic */ void a(d d2, String string) {
        d2.f(string);
    }

    static /* synthetic */ void a(d d2, boolean bl) {
        d2.b(bl);
    }

    private void a(String string, String string2) {
        if (this.g == a.a) {
            com.tappx.a.a.a.i.b.a.b(this.e, string, string2);
        }
    }

    private void a(boolean bl) {
        b.b(new Runnable(this, bl){
            final /* synthetic */ boolean a;
            final /* synthetic */ d b;
            {
                this.b = d2;
                this.a = bl;
            }

            public void run() {
                d.a(this.b, this.a);
            }
        });
    }

    /*
     * Exception decompiling
     */
    private String b() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Underrun type stack
        // org.benf.cfr.reader.b.a.c.e.a(StackSim.java:35)
        // org.benf.cfr.reader.b.b.af.a(OperationFactoryPop.java:20)
        // org.benf.cfr.reader.b.b.e.a(JVMInstr.java:315)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:195)
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

    private static String b(String string, boolean bl) {
        byte[] arrby = Base64.decode((String)string, (int)0);
        try {
            String string2 = new String(arrby, "UTF-8");
            return string2;
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            if (bl) {
                unsupportedEncodingException.printStackTrace();
            }
            return "";
        }
    }

    private JSONObject b(String string, int n2, int n3) {
        return new JSONObject(this.a(string, n2, n3));
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void b(Intent intent) {
        try {
            String string = intent.getStringExtra("token");
            if (string == null) {
                string = "";
            }
            int n2 = -1;
            switch (string.hashCode()) {
                case 471550256: {
                    if (!string.equals((Object)"TAPPX_AUX")) break;
                    n2 = 3;
                    break;
                }
                case 149971738: {
                    if (!string.equals((Object)"TAPPX_INSTALL_GETCLASS")) break;
                    n2 = 0;
                    break;
                }
                case 210735: {
                    if (!string.equals((Object)"TAPPX_INSTALL_TESTMODE_APP")) break;
                    n2 = 1;
                    break;
                }
                case -1982207016: {
                    if (!string.equals((Object)"TAPPX_INSTALL_TESTMODE_MANUAL")) break;
                    n2 = 2;
                    break;
                }
                default: {
                    break;
                }
            }
            if (n2 == 0) {
                this.g = a.b;
                return;
            }
            if (n2 == 1) {
                this.g = a.c;
                return;
            }
            if (n2 == 2) {
                this.g = a.d;
                return;
            }
            if (n2 != 3) {
                this.g = a.a;
                return;
            }
            this.g = a.b;
            return;
        }
        catch (Exception exception) {
            this.b("no string token");
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("ERROR01: ");
            stringBuilder.append(exception.getMessage());
            com.tappx.a.a.a.c.a.b(stringBuilder.toString(), new Object[0]);
            exception.printStackTrace();
            return;
        }
    }

    private void b(String string) {
        if (this.g != a.a && this.g != a.c) {
            com.tappx.a.a.a.c.a.d(string, new Object[0]);
        }
    }

    private void b(boolean bl) {
        if (this.g != a.a) {
            return;
        }
        if (!"1".equals((Object)com.tappx.a.a.a.i.b.a.a(this.e, "sp_tappx_referrer_send", "NotFound"))) {
            String string = com.tappx.a.a.a.i.b.a.a(this.e, "sp_tappx_install_id", "NotFound");
            if (!"NotFound".equals((Object)string) && !"".equals((Object)string)) {
                String string2;
                if (!bl) {
                    com.tappx.a.a.a.c.a.a("Trying to Track Install", new Object[0]);
                } else {
                    com.tappx.a.a.a.c.a.a("Re-Trying to Track PENDING Install", new Object[0]);
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(string);
                stringBuilder.append(":");
                stringBuilder.append(System.currentTimeMillis() / 1000L);
                string2 = this.a(stringBuilder.toString(), 2);
                try {
                    string2 = URLEncoder.encode((String)string2, (String)"UTF-8");
                }
                catch (UnsupportedEncodingException unsupportedEncodingException) {}
                com.tappx.a.a.a.c.a.a("ti->snd", new Object[0]);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(this.d());
                stringBuilder.append(string2);
                Bundle bundle = this.g(stringBuilder.toString());
                if (bundle != null) {
                    if (this.a(bundle.getCharSequence("HTML"), "").trim().equals((Object)"1")) {
                        com.tappx.a.a.a.i.b.a.b(this.e, "sp_tappx_referrer_send", "1");
                        com.tappx.a.a.a.c.a.a("ti->ok", new Object[0]);
                        com.tappx.a.a.a.c.a.a("Install Tracked", new Object[0]);
                        return;
                    }
                    com.tappx.a.a.a.c.a.a("ti->ko", new Object[0]);
                    com.tappx.a.a.a.c.a.c("Install NOT Tracked", new Object[0]);
                    return;
                }
            } else {
                com.tappx.a.a.a.i.b.a.b(this.e, "sp_tappx_referrer_send", "0");
            }
        }
    }

    private String c() {
        if (!"".equals((Object)this.k)) {
            return this.k;
        }
        try {
            String string = this.e();
            if (!string.isEmpty() && string.contains((CharSequence)"tappx.com")) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(string);
                stringBuilder.append("ts");
                this.k = this.b(stringBuilder.toString(), 2, 6).getString("ts");
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        if ("".equals((Object)this.k)) {
            com.tappx.a.a.a.c.a.c("Using device timestamp!", new Object[0]);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("");
            stringBuilder.append(System.currentTimeMillis() / 1000L);
            return stringBuilder.toString();
        }
        return this.k;
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private String c(Intent intent) {
        String string;
        void var2_9;
        block8 : {
            block7 : {
                string = intent.getStringExtra("referrer");
                if (string != null) break block7;
                string = "";
            }
            if (string.length() != 0) return string;
            Uri uri = intent.getData();
            if (uri == null) return string;
            {
                catch (Exception exception) {}
            }
            try {
                String string2 = uri.getQuery();
                if (string2 != null) return string2;
                return "";
            }
            catch (Exception exception) {
                this.b("02. no URI referrer");
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("ERROR02: ");
                stringBuilder.append(exception.getMessage());
                com.tappx.a.a.a.c.a.b(stringBuilder.toString(), new Object[0]);
                return string;
            }
            break block8;
            catch (Exception exception) {
                string = "";
            }
        }
        this.b("01. No string referrer");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ERROR01: ");
        stringBuilder.append(var2_9.getMessage());
        com.tappx.a.a.a.c.a.b(stringBuilder.toString(), new Object[0]);
        return string;
    }

    private void c(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SavedReferrer = ");
        stringBuilder.append(com.tappx.a.a.a.i.b.a.a(this.e, "sp_tappx_referrer", "NotFound"));
        this.b(stringBuilder.toString());
        if (string != null && string.length() > 0) {
            String[] arrstring;
            int n2 = string.indexOf("referrer=");
            if (n2 > 0) {
                string = string.substring(n2 + 9);
            }
            if ((arrstring = URLDecoder.decode((String)string, (String)"UTF-8").split("&")) != null) {
                int n3 = arrstring.length;
                for (int i2 = 0; i2 < n3; ++i2) {
                    String[] arrstring2 = arrstring[i2].split("=");
                    if (arrstring2.length <= 1) continue;
                    if ("tappxs".equalsIgnoreCase(arrstring2[0])) {
                        this.h = arrstring2[1];
                    } else if ("tappxp".equalsIgnoreCase(arrstring2[0])) {
                        this.i = arrstring2[1];
                    } else if ("ord".equalsIgnoreCase(arrstring2[0])) {
                        this.j = arrstring2[1];
                    }
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(arrstring2[0]);
                    stringBuilder2.append("=");
                    stringBuilder2.append(arrstring2[1]);
                    this.b(stringBuilder2.toString());
                }
                StringBuilder stringBuilder3 = new StringBuilder();
                stringBuilder3.append("Referrer = ");
                stringBuilder3.append(string);
                this.b(stringBuilder3.toString());
            }
        }
    }

    private String d() {
        return h.a("wB98799JR2eOU8JQBj+AirJiMR1odQqWWeVt5DvdwLDbO/6GMnE3dISVriMmbsHg");
    }

    private void d(String string) {
        String string2 = this.g == a.a ? com.tappx.a.a.a.i.b.a.a(this.e, "sp_tappx_referrer", "NotFound") : "NotFound";
        if ("NotFound".equals((Object)string2)) {
            boolean bl;
            this.a("sp_tappx_referrer", string);
            String string3 = this.h;
            String string4 = "";
            if (!string4.equals((Object)string3) && !string4.equals((Object)this.i)) {
                string4 = this.b();
                this.a("sp_tappx_install_id", string4);
                bl = true;
            } else {
                this.a("sp_tappx_referrer_send", "0");
                bl = false;
            }
            if (bl) {
                if (this.g == a.a) {
                    this.a(false);
                    return;
                }
                this.e(string4);
                return;
            }
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("old_referrer = ");
            stringBuilder.append(string2);
            this.b(stringBuilder.toString());
            this.a(false);
        }
    }

    private String e() {
        return h.a("L6AMiu9M3Gzzgb1DcC9zrNWKirwrdRZWS7ho5031f9E0pLEIRwh4cyjVdbI6wKX/");
    }

    private void e(String string) {
        b.b(new Runnable(this, string){
            final /* synthetic */ String a;
            final /* synthetic */ d b;
            {
                this.b = d2;
                this.a = string;
            }

            public void run() {
                d.a(this.b, this.a);
            }
        });
    }

    private void f(String string) {
        String string2;
        com.tappx.a.a.a.c.a.a("Trying to Track Install", new Object[0]);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("-");
        stringBuilder.append(string);
        stringBuilder.append(":");
        stringBuilder.append(System.currentTimeMillis() / 1000L);
        string2 = this.a(stringBuilder.toString(), 2);
        try {
            string2 = URLEncoder.encode((String)string2, (String)"UTF-8");
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {}
        com.tappx.a.a.a.c.a.a("ti->snd", new Object[0]);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.d());
        stringBuilder.append(string2);
        Bundle bundle = this.g(stringBuilder.toString());
        if (bundle != null) {
            String string3 = this.f.b();
            String string4 = this.a(bundle.getCharSequence("HTML"), "");
            String string5 = this.a(bundle.getCharSequence("ERROR"), "");
            if (this.g != a.a) {
                if (string5 != null && string5.length() > 0) {
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("TrackInstall Error: ");
                    stringBuilder2.append(string5);
                    com.tappx.a.a.a.c.a.b(stringBuilder2.toString(), new Object[0]);
                    return;
                }
                StringBuilder stringBuilder3 = new StringBuilder();
                stringBuilder3.append("TrackInstall result: ");
                stringBuilder3.append(string4);
                com.tappx.a.a.a.c.a.a(stringBuilder3.toString(), new Object[0]);
                if (this.a(bundle.getCharSequence("HTML"), "").trim().equals((Object)"1")) {
                    com.tappx.a.a.a.c.a.a("ti->ok", new Object[0]);
                    com.tappx.a.a.a.c.a.a("Install Tracked", new Object[0]);
                } else {
                    com.tappx.a.a.a.c.a.a("ti->ko", new Object[0]);
                    com.tappx.a.a.a.c.a.c("Install NOT Tracked", new Object[0]);
                }
                if (a.c.equals((Object)this.g)) {
                    try {
                        Intent intent = new Intent();
                        intent.addFlags(268435456);
                        intent.setPackage("com.tappx.TrackingTestApp");
                        intent.setAction("com.tappx.TrackingTestApp.TEST_INSTALL");
                        intent.setType("text/plain");
                        StringBuilder stringBuilder4 = new StringBuilder();
                        stringBuilder4.append(string3);
                        stringBuilder4.append("|");
                        stringBuilder4.append(this.c());
                        stringBuilder4.append("|");
                        stringBuilder4.append(this.e.getApplicationContext().getPackageName());
                        intent.putExtra("android.intent.extra.TEXT", stringBuilder4.toString());
                        this.e.startActivity(intent);
                        return;
                    }
                    catch (Exception exception) {
                        StringBuilder stringBuilder5 = new StringBuilder();
                        stringBuilder5.append("Error sending to TestApp: ");
                        stringBuilder5.append(exception.getMessage());
                        com.tappx.a.a.a.c.a.a(stringBuilder5.toString(), new Object[0]);
                    }
                }
            }
        }
    }

    private Bundle g(String string) {
        String string2;
        String string3;
        String string4 = "";
        try {
            string3 = this.a(string);
            string2 = string4;
        }
        catch (Exception exception) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string4);
            stringBuilder.append(exception.getMessage());
            stringBuilder.append("\n");
            string2 = stringBuilder.toString();
            string3 = string4;
        }
        Bundle bundle = new Bundle();
        if (string3 == null) {
            string3 = string4;
        }
        bundle.putString("HTML", string3);
        if (string2 != null) {
            string4 = string2;
        }
        bundle.putString("ERROR", string4);
        return bundle;
    }

    public String a(String string) {
        HttpURLConnection httpURLConnection = (HttpURLConnection)new URL(string).openConnection();
        httpURLConnection.setDoInput(true);
        httpURLConnection.setDoOutput(false);
        httpURLConnection.setAllowUserInteraction(false);
        httpURLConnection.setUseCaches(true);
        httpURLConnection.connect();
        InputStreamReader inputStreamReader = new InputStreamReader((InputStream)httpURLConnection.getContent());
        BufferedReader bufferedReader = new BufferedReader((Reader)inputStreamReader);
        String string2 = "";
        do {
            String string3;
            if ((string3 = bufferedReader.readLine()) == null) {
                try {
                    bufferedReader.close();
                    inputStreamReader.close();
                    httpURLConnection.disconnect();
                }
                catch (Exception exception) {}
                return string2;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string2);
            stringBuilder.append(string3);
            string2 = stringBuilder.toString();
        } while (true);
    }

    @Override
    public void a() {
        this.a(true);
    }

    @Override
    public void a(Intent intent) {
        this.b(intent);
        this.h = "";
        this.i = "";
        this.j = "";
        this.k = "";
        if (this.g == a.b) {
            return;
        }
        String string = this.c(intent);
        if (string != null && string.length() > 0) {
            try {
                this.c(string);
                this.d(string);
                return;
            }
            catch (UnsupportedEncodingException unsupportedEncodingException) {
                this.b("No string referrer");
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("ERROR: ");
                stringBuilder.append(unsupportedEncodingException.getMessage());
                com.tappx.a.a.a.c.a.b(stringBuilder.toString(), new Object[0]);
                return;
            }
        }
        if ("NotFound".equals((Object)com.tappx.a.a.a.i.b.a.a(this.e, "sp_tappx_referrer", "NotFound"))) {
            this.a("sp_tappx_referrer", string);
            if ("NotFound".equals((Object)com.tappx.a.a.a.i.b.a.a(this.e, "sp_tappx_referrer_send", "NotFound"))) {
                this.a("sp_tappx_referrer_send", "0");
            }
        } else if (this.g == a.a) {
            this.a(false);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Mode: ");
        stringBuilder.append((Object)this.g);
        this.b(stringBuilder.toString());
        this.b("Not referrer INFO received.");
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("SavedReferrer = ");
        stringBuilder2.append(com.tappx.a.a.a.i.b.a.a(this.e, "sp_tappx_referrer", "NotFound"));
        this.b(stringBuilder2.toString());
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append("InstallSend   = ");
        stringBuilder3.append(com.tappx.a.a.a.i.b.a.a(this.e, "sp_tappx_referrer_send", "NotFound"));
        this.b(stringBuilder3.toString());
    }

}

