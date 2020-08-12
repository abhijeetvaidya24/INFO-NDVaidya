/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.chartboost.sdk.Tracking.a
 *  com.chartboost.sdk.i
 *  com.chartboost.sdk.impl.bh
 *  com.chartboost.sdk.impl.s
 *  java.io.File
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Throwable
 *  java.util.Iterator
 *  java.util.List
 *  java.util.concurrent.TimeUnit
 *  java.util.concurrent.atomic.AtomicReference
 *  org.json.JSONArray
 *  org.json.JSONObject
 */
package com.chartboost.sdk.Libraries;

import android.content.Context;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Libraries.e;
import com.chartboost.sdk.Libraries.g;
import com.chartboost.sdk.Tracking.a;
import com.chartboost.sdk.i;
import com.chartboost.sdk.impl.bh;
import com.chartboost.sdk.impl.s;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONArray;
import org.json.JSONObject;

public class f {
    public final File a;
    public final File b;
    private final AtomicReference<com.chartboost.sdk.Model.e> c;
    private final g d;
    private final AtomicReference<g> e;
    private s f;

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public f(s var1_1, Context var2_2, AtomicReference<com.chartboost.sdk.Model.e> var3_3) {
        var4_4 = this;
        super();
        var4_4.f = var1_1;
        var4_4.d = new g(var2_2.getCacheDir());
        var4_4.e = new AtomicReference();
        var4_4.c = var3_3;
        try {
            var39_5 = var1_1.b();
            if (var39_5 != null) {
                var4_4.e.set((Object)new g(var39_5));
            }
        }
        catch (Exception var5_6) {
            var5_6.printStackTrace();
        }
        var4_4.b = new File(var4_4.d.a, "track");
        var4_4.a = new File(var4_4.d.a, "session");
        var6_7 = new g[]{var4_4.d, (g)var4_4.e.get()};
        var7_8 = var6_7.length;
        var8_9 = 0;
        while (var8_9 < var7_8) {
            block17 : {
                block15 : {
                    block16 : {
                        var9_10 = var6_7[var8_9];
                        try {
                            var15_16 = var9_10 == var4_4.d;
                            if (var9_10 != null && (var15_16 || this.a())) {
                                var16_17 = System.currentTimeMillis() - TimeUnit.DAYS.toMillis((long)((com.chartboost.sdk.Model.e)var3_3.get()).w);
                                var18_18 = new File(var9_10.a, "templates");
                                var19_19 = var18_18.exists();
                                if (!var19_19 || (var24_22 = var18_18.listFiles()) == null) break block15;
                                var25_23 = var24_22.length;
                                break block16;
                            }
                            var11_14 = var6_7;
                            break block17;
                        }
                        catch (Exception var10_13) {
                            var11_14 = var6_7;
                            ** GOTO lbl58
                        }
                    }
                    for (var26_24 = 0; var26_24 < var25_23; ++var26_24) {
                        block22 : {
                            block20 : {
                                block21 : {
                                    block19 : {
                                        var27_25 = var24_22[var26_24];
                                        if (!var27_25.isDirectory()) break block19;
                                        var28_26 = var27_25.listFiles();
                                        if (var28_26 == null) break block20;
                                        var29_27 = var28_26.length;
                                        break block21;
                                    }
                                    var11_14 = var6_7;
                                    break block22;
                                }
                                for (var30_28 = 0; var30_28 < var29_27; ++var30_28) {
                                    block18 : {
                                        block23 : {
                                            var31_29 = var28_26[var30_28];
                                            if (!var15_16 && var31_29.lastModified() >= var16_17 || var31_29.delete()) break block23;
                                            var32_30 = new StringBuilder();
                                            var32_30.append("Unable to delete ");
                                            var11_14 = var6_7;
                                            try {
                                                var32_30.append(var31_29.getPath());
                                                CBLogging.b("FileCache", var32_30.toString());
                                                break block18;
                                            }
                                            catch (Exception var10_12) {}
lbl58: // 2 sources:
                                            var12_15 = new StringBuilder();
                                            var12_15.append("Exception while cleaning up templates directory at ");
                                            var12_15.append(var9_10.f.getPath());
                                            CBLogging.a("FileCache", var12_15.toString(), (Throwable)var10_11);
                                            var10_11.printStackTrace();
                                            break block17;
                                        }
                                        var11_14 = var6_7;
                                    }
                                    var6_7 = var11_14;
                                }
                            }
                            var11_14 = var6_7;
                            var35_31 = var27_25.listFiles();
                            if (var35_31 != null && var35_31.length == 0 && !var27_25.delete()) {
                                var36_32 = new StringBuilder();
                                var36_32.append("Unable to delete ");
                                var36_32.append(var27_25.getPath());
                                CBLogging.b("FileCache", var36_32.toString());
                            }
                        }
                        var6_7 = var11_14;
                    }
                }
                var11_14 = var6_7;
                var20_20 = new File(var9_10.a, ".adId");
                if (var20_20.exists() && (var15_16 || var20_20.lastModified() < var16_17) && !var20_20.delete()) {
                    var21_21 = new StringBuilder();
                    var21_21.append("Unable to delete ");
                    var21_21.append(var20_20.getPath());
                    CBLogging.b("FileCache", var21_21.toString());
                }
            }
            ++var8_9;
            var4_4 = this;
            var6_7 = var11_14;
        }
    }

    public String a(String string2) {
        File file = new File(this.d().g, string2);
        if (file.exists()) {
            return file.getPath();
        }
        return null;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean a() {
        try {
            boolean bl;
            String string2 = this.f.c();
            if (string2 != null && string2.equals((Object)"mounted") && !(bl = i.n)) {
                return true;
            }
        }
        catch (Exception exception) {
            a.a((Class)this.getClass(), (String)"isExternalStorageAvailable", (Exception)exception);
        }
        CBLogging.e("FileCache", "External Storage unavailable");
        return false;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public byte[] a(File file) {
        f f2 = this;
        synchronized (f2) {
            byte[] arrby = null;
            if (file == null) {
                return null;
            }
            try {
                try {
                    return bh.b((File)file);
                }
                catch (Exception exception) {
                    CBLogging.a("FileCache", "Error loading cache from disk", exception);
                    a.a((Class)this.getClass(), (String)"readByteArrayFromDisk", (Exception)exception);
                }
                return arrby;
            }
            catch (Throwable throwable2) {}
            throw throwable2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public long b(File file) {
        Exception exception2;
        long l2;
        block7 : {
            int n2;
            File[] arrfile;
            int n3;
            block6 : {
                block5 : {
                    l2 = 0L;
                    if (file != null) {
                        if (!file.isDirectory()) break block5;
                        arrfile = file.listFiles();
                        if (arrfile == null) return l2;
                        n3 = arrfile.length;
                        n2 = 0;
                        break block6;
                    }
                }
                if (file == null) return l2;
                try {
                    return file.length();
                }
                catch (Exception exception2) {}
                break block7;
            }
            while (n2 < n3) {
                l2 += this.b(arrfile[n2]);
                ++n2;
            }
            return l2;
        }
        a.a(f.class, (String)"getFolderSize", (Exception)exception2);
        return l2;
    }

    public JSONArray b() {
        JSONArray jSONArray = new JSONArray();
        String[] arrstring = this.d().g.list();
        if (arrstring != null) {
            for (String string2 : arrstring) {
                if (string2.equals((Object)".nomedia") || string2.endsWith(".tmp")) continue;
                jSONArray.put((Object)string2);
            }
        }
        return jSONArray;
    }

    public boolean b(String string2) {
        if (this.d().d != null && string2 != null) {
            return new File(this.d().d, string2).exists();
        }
        return false;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public JSONObject c() {
        block4 : {
            block5 : {
                var1_1 = new JSONObject();
                try {
                    var3_2 = this.d().a;
                    var4_3 = ((com.chartboost.sdk.Model.e)this.c.get()).x.iterator();
lbl5: // 2 sources:
                    do {
                        if (var4_3.hasNext() == false) return var1_1;
                        var5_4 = (String)var4_3.next();
                        if (var5_4.equals((Object)"templates")) continue;
                        var6_5 = new File(var3_2, var5_4);
                        var7_6 = new JSONArray();
                        if (!var6_5.exists() || (var8_7 = var6_5.list()) == null) break block4;
                        var9_8 = var8_7.length;
                        break block5;
                        break;
                    } while (true);
                }
                catch (Exception var2_11) {
                    a.a((Class)this.getClass(), (String)"getWebViewCacheAssets", (Exception)var2_11);
                }
                return var1_1;
            }
            for (var10_9 = 0; var10_9 < var9_8; ++var10_9) {
                var11_10 = var8_7[var10_9];
                if (var11_10.equals((Object)".nomedia") || var11_10.endsWith(".tmp")) continue;
                var7_6.put((Object)var11_10);
            }
        }
        e.a(var1_1, var5_4, (Object)var7_6);
        ** while (true)
    }

    /*
     * Exception decompiling
     */
    public void c(File var1) {
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

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public g d() {
        if (this.a()) {
            g g2 = (g)this.e.get();
            if (g2 == null) {
                try {
                    File file = this.f.b();
                    if (file != null) {
                        g g3;
                        this.e.compareAndSet(null, (Object)new g(file));
                        g2 = g3 = (g)this.e.get();
                    }
                }
                catch (Exception exception) {
                    a.a((Class)this.getClass(), (String)"currentLocations", (Exception)exception);
                }
            }
            if (g2 != null) {
                return g2;
            }
        }
        return this.d;
    }

    public JSONObject e() {
        JSONObject jSONObject = new JSONObject();
        g g2 = (g)this.e.get();
        if (g2 != null) {
            e.a(jSONObject, ".chartboost-external-folder-size", this.b(g2.a));
        }
        e.a(jSONObject, ".chartboost-internal-folder-size", this.b(this.d.a));
        File file = this.d().a;
        String[] arrstring = file.list();
        if (arrstring != null && arrstring.length > 0) {
            int n2 = arrstring.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                File file2 = new File(file, arrstring[i2]);
                JSONObject jSONObject2 = new JSONObject();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(file2.getName());
                stringBuilder.append("-size");
                e.a(jSONObject2, stringBuilder.toString(), this.b(file2));
                String[] arrstring2 = file2.list();
                if (arrstring2 != null) {
                    e.a(jSONObject2, "count", arrstring2.length);
                }
                e.a(jSONObject, file2.getName(), (Object)jSONObject2);
            }
        }
        return jSONObject;
    }
}

