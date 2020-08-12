/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.lang.Boolean
 *  java.lang.Exception
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Arrays
 *  java.util.List
 */
package com.startapp.android.publish.adsCommon;

import android.content.Context;
import com.startapp.android.publish.ads.splash.SplashConfig;
import com.startapp.android.publish.adsCommon.Ad;
import com.startapp.android.publish.adsCommon.Utils.i;
import com.startapp.android.publish.adsCommon.adinformation.AdInformationPositions;
import com.startapp.android.publish.adsCommon.adinformation.c;
import com.startapp.android.publish.adsCommon.f.d;
import com.startapp.android.publish.adsCommon.f.f;
import com.startapp.android.publish.adsCommon.g.d.a;
import com.startapp.android.publish.common.metaData.MetaData;
import com.startapp.android.publish.common.model.AdPreferences;
import com.startapp.android.publish.omsdk.b;
import com.startapp.common.a.g;
import java.util.Arrays;
import java.util.List;

public abstract class e
extends Ad {
    protected static String a;
    private static final long serialVersionUID = 1L;
    private String adId = null;
    private List<com.startapp.android.publish.adsCommon.b.a> apps;
    private String[] closingUrl = new String[]{""};
    private Long delayImpressionInSeconds;
    private int height;
    private String htmlUuid = "";
    public boolean[] inAppBrowserEnabled = new boolean[]{true};
    private boolean isMraidAd = false;
    private int orientation = 0;
    private String[] packageNames = new String[]{""};
    private Boolean[] sendRedirectHops = null;
    public boolean[] smartRedirect = new boolean[]{false};
    private String[] trackingClickUrls = new String[]{""};
    public String[] trackingUrls = new String[]{""};
    private int width;

    public e(Context context, AdPreferences.Placement placement) {
        super(context, placement);
        if (a == null) {
            this.a();
        }
    }

    private void a() {
        a = i.c(this.getContext());
    }

    private String f(String string) {
        try {
            String string2 = com.b.a.a.a.b.a(b.a(), string);
            return string2;
        }
        catch (Exception exception) {
            g.a(6, exception.getMessage());
            f.a(this.context, d.b, "OMSDK: Failed to inject js to html ad.", exception.getMessage(), "");
            return string;
        }
    }

    private void g(String string) {
        if (Arrays.asList((Object[])string.split(",")).contains((Object)"false")) {
            this.belowMinCPM = false;
            return;
        }
        this.belowMinCPM = true;
    }

    private void h(String string) {
        String[] arrstring = string.split(",");
        this.inAppBrowserEnabled = new boolean[arrstring.length];
        for (int i2 = 0; i2 < arrstring.length; ++i2) {
            this.inAppBrowserEnabled[i2] = arrstring[i2].compareTo("false") != 0;
        }
    }

    private void i(String string) {
        String[] arrstring = string.split(",");
        this.smartRedirect = new boolean[arrstring.length];
        for (int i2 = 0; i2 < arrstring.length; ++i2) {
            this.smartRedirect[i2] = arrstring[i2].compareTo("true") == 0;
        }
    }

    private void j(String string) {
        this.trackingUrls = string.split(",");
    }

    private void k(String string) {
        this.trackingClickUrls = string.split(",");
    }

    private void l(String string) {
        this.packageNames = string.split(",");
    }

    private void m(String string) {
        boolean bl = Boolean.parseBoolean((String)string);
        this.getAdInfoOverride().a(bl);
    }

    private void n(String string) {
        this.getAdInfoOverride().a(AdInformationPositions.Position.getByName(string));
    }

    /*
     * Exception decompiling
     */
    private void o(String var1) {
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

    protected String a(String string, String string2) {
        return i.a(string, string2, string2);
    }

    public void a(int n2, int n3) {
        this.b(n2);
        this.c(n3);
    }

    protected void a(SplashConfig.Orientation orientation) {
        this.orientation = 0;
        boolean bl = i.a(8L);
        if (orientation != null) {
            if (bl && orientation.equals((Object)SplashConfig.Orientation.PORTRAIT)) {
                this.orientation = 1;
                return;
            }
            if (bl && orientation.equals((Object)SplashConfig.Orientation.LANDSCAPE)) {
                this.orientation = 2;
            }
        }
    }

    public void a(List<com.startapp.android.publish.adsCommon.b.a> list) {
        this.apps = list;
    }

    protected String a_() {
        return a;
    }

    public void b(int n2) {
        this.width = n2;
    }

    public void b(String string) {
        String string2;
        String string3;
        String string4;
        String string5;
        String string6;
        String string7;
        String string8;
        String string9;
        String string10;
        String string11;
        String string12;
        String string13;
        String string14;
        if (MetaData.getInstance().isOmsdkEnabled()) {
            string = this.f(string);
        }
        if (i.a(512L)) {
            this.htmlUuid = com.startapp.android.publish.cache.a.a().a(string);
        }
        if ((string9 = this.a(string, "@smartRedirect@")) != null) {
            this.i(string9);
        }
        if ((string3 = this.a(string, "@trackingClickUrl@")) != null) {
            this.k(string3);
        }
        if ((string5 = this.a(string, "@closeUrl@")) != null) {
            this.c(string5);
        }
        if ((string14 = this.a(string, "@tracking@")) != null) {
            this.j(string14);
        }
        if ((string2 = this.a(string, "@packageName@")) != null) {
            this.l(string2);
        }
        if ((string7 = this.a(string, "@startappBrowserEnabled@")) != null) {
            this.h(string7);
        }
        if ((string12 = this.a(string, "@orientation@")) != null && i.a(8L)) {
            this.a(SplashConfig.Orientation.getByName(string12));
        }
        if ((string4 = this.a(string, "@adInfoEnable@")) != null) {
            this.m(string4);
        }
        if ((string11 = this.a(string, "@adInfoPosition@")) != null) {
            this.n(string11);
        }
        if ((string8 = this.a(string, "@ttl@")) != null) {
            this.d(string8);
        }
        if ((string6 = this.a(string, "@belowMinCPM@")) != null) {
            this.g(string6);
        }
        if ((string10 = this.a(string, "@delayImpressionInSeconds@")) != null) {
            this.o(string10);
        }
        if ((string13 = this.a(string, "@sendRedirectHops@")) != null) {
            this.e(string13);
        }
        if (this.smartRedirect.length < this.trackingUrls.length) {
            boolean[] arrbl;
            int n2;
            g.a(6, "Error in smartRedirect array in HTML");
            boolean[] arrbl2 = new boolean[this.trackingUrls.length];
            for (n2 = 0; n2 < (arrbl = this.smartRedirect).length; ++n2) {
                arrbl2[n2] = arrbl[n2];
            }
            while (n2 < this.trackingUrls.length) {
                arrbl2[n2] = false;
                ++n2;
            }
            this.smartRedirect = arrbl2;
        }
        this.b(a.b(string));
    }

    public void b(boolean bl) {
        this.isMraidAd = bl;
    }

    public void c(int n2) {
        this.height = n2;
    }

    public void c(String string) {
        this.closingUrl = string.split(",");
    }

    /*
     * Exception decompiling
     */
    public void d(String var1) {
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

    public boolean d(int n2) {
        boolean[] arrbl;
        if (n2 >= 0 && n2 < (arrbl = this.smartRedirect).length) {
            return arrbl[n2];
        }
        return false;
    }

    public void e(String string) {
        if (string != null && !string.equals((Object)"")) {
            String[] arrstring = string.split(",");
            this.sendRedirectHops = new Boolean[arrstring.length];
            for (int i2 = 0; i2 < arrstring.length; ++i2) {
                this.sendRedirectHops[i2] = arrstring[i2].compareTo("true") == 0 ? Boolean.valueOf((boolean)true) : (arrstring[i2].compareTo("false") == 0 ? Boolean.valueOf((boolean)false) : null);
            }
        }
    }

    public boolean e(int n2) {
        boolean[] arrbl = this.inAppBrowserEnabled;
        if (arrbl != null && n2 >= 0 && n2 < arrbl.length) {
            return arrbl[n2];
        }
        return true;
    }

    public Boolean f(int n2) {
        Boolean[] arrboolean = this.sendRedirectHops;
        if (arrboolean != null && n2 >= 0 && n2 < arrboolean.length) {
            return arrboolean[n2];
        }
        return null;
    }

    public String f() {
        return com.startapp.android.publish.cache.a.a().b(this.htmlUuid);
    }

    public String g() {
        return this.htmlUuid;
    }

    public int h() {
        return this.width;
    }

    public String[] i() {
        return this.closingUrl;
    }

    public int j() {
        return this.height;
    }

    public boolean[] k() {
        return this.inAppBrowserEnabled;
    }

    public String[] l() {
        return this.trackingUrls;
    }

    public String[] m() {
        return this.trackingClickUrls;
    }

    public int n() {
        return this.orientation;
    }

    public String[] o() {
        return this.packageNames;
    }

    public Long p() {
        return this.delayImpressionInSeconds;
    }

    public Boolean[] q() {
        return this.sendRedirectHops;
    }

    public boolean r() {
        return this.isMraidAd;
    }
}

