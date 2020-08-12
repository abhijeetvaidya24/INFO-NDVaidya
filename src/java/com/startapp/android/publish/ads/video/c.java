/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Handler
 *  android.os.Looper
 *  java.io.DataInputStream
 *  java.io.File
 *  java.io.FileOutputStream
 *  java.io.InputStream
 *  java.lang.Double
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.net.URL
 *  java.net.URLConnection
 */
package com.startapp.android.publish.ads.video;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.startapp.android.publish.ads.video.b.c;
import com.startapp.android.publish.ads.video.h;
import com.startapp.android.publish.adsCommon.n;
import com.startapp.common.a.g;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class c {
    private boolean a = true;
    private c.c b = null;
    private String c = null;

    private c() {
    }

    public static c a() {
        return b.a;
    }

    private void a(final int n2) {
        if (this.b != null) {
            new Handler(Looper.getMainLooper()).post(new Runnable(){

                public void run() {
                    if (c.this.b != null) {
                        c.this.b.a(n2);
                    }
                }
            });
        }
    }

    /*
     * Exception decompiling
     */
    private void a(Context var1, File var2, File var3) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl63 : ALOAD : trying to set 1 previously set to 0
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

    private void a(final a a2, final String string) {
        new Handler(Looper.getMainLooper()).post(new Runnable(){

            public void run() {
                a2.a(string);
            }
        });
    }

    /*
     * Unable to fully structure code
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public String a(Context var1_1, URL var2_2, String var3_3, a var4_4) {
        block39 : {
            block41 : {
                block44 : {
                    block43 : {
                        block46 : {
                            block45 : {
                                block38 : {
                                    var5_5 = new StringBuilder();
                                    var5_5.append("Downloading video from ");
                                    var5_5.append((Object)var2_2);
                                    g.a("StartAppWall.ProgressiveVideoManager", 3, var5_5.toString());
                                    this.c = var2_2.toString();
                                    this.a = true;
                                    var8_6 = com.startapp.android.publish.adsCommon.b.a().H().l();
                                    var21_7 = h.a(var1_1, var3_3);
                                    var22_8 = new File(var21_7);
                                    var23_9 = var22_8.exists();
                                    if (!var23_9) break block38;
                                    try {
                                        this.c = null;
                                        null.close();
                                        null.close();
                                        null.close();
                                        return var21_7;
                                    }
                                    catch (Exception v0) {}
                                    return var21_7;
                                }
                                var24_10 = var2_2.openConnection();
                                var24_10.connect();
                                var25_11 = var24_10.getContentLength();
                                var12_12 = var24_10.getInputStream();
                                var13_13 = new DataInputStream(var12_12);
                                try {
                                    var26_14 = new byte[4096];
                                    var27_15 = new StringBuilder();
                                    var27_15.append(var3_3);
                                    var27_15.append(".temp");
                                    var11_16 = var27_15.toString();
                                    var30_17 = new StringBuilder();
                                    var30_17.append(var21_7);
                                    var30_17.append(".temp");
                                    var33_18 = var30_17.toString();
                                    var10_19 = var1_1.openFileOutput(var11_16, 0);
                                    var34_20 = 0;
                                    var35_21 = false;
                                    var36_22 = 0;
                                }
                                catch (Throwable var15_39) {
                                    var10_19 = null;
                                    break block44;
                                }
lbl45: // 2 sources:
                                do {
                                    block40 : {
                                        var37_23 = var13_13.read(var26_14);
                                        if (var37_23 <= 0) break block39;
                                        var38_24 = var21_7;
                                        if (!this.a) break block40;
                                        var10_19.write(var26_14, 0, var37_23);
                                        var43_25 = var34_20 + var37_23;
                                        var44_26 = var22_8;
                                        var45_27 = var43_25;
                                        Double.isNaN((double)var45_27);
                                        var48_28 = var45_27 * 100.0;
                                        var50_29 = var26_14;
                                        var51_30 = var25_11;
                                        Double.isNaN((double)var51_30);
                                        var54_31 = (int)(var48_28 / var51_30);
                                        if (var54_31 >= var8_6) {
                                            if (!var35_21 && var4_4 != null) {
                                                this.a(var4_4, var33_18);
                                                var35_21 = true;
                                            }
                                            if (var54_31 >= var36_22 + 1) {
                                                this.a(var54_31);
                                                var36_22 = var54_31;
                                            }
                                        }
                                        break block41;
                                    }
lbl73: // 2 sources:
                                    do {
                                        block42 : {
                                            var39_32 = var22_8;
                                            if (this.a || var37_23 <= 0) break block42;
                                            g.a("StartAppWall.ProgressiveVideoManager", 3, "Video downloading disabled");
                                            new File(h.a(var1_1, var11_16)).delete();
                                            try {
                                                this.c = null;
                                                var12_12.close();
                                                var13_13.close();
                                                var10_19.close();
                                                return "downloadInterrupted";
                                            }
                                            catch (Exception v1) {}
                                            return "downloadInterrupted";
                                        }
                                        this.a(var1_1, new File(h.a(var1_1, var11_16)), var39_32);
                                        try {
                                            this.c = null;
                                            var12_12.close();
                                            var13_13.close();
                                            var10_19.close();
                                            return var38_24;
                                        }
                                        catch (Exception v2) {}
                                        return var38_24;
                                        catch (Exception var9_33) {
                                            break block43;
                                        }
                                        break;
                                    } while (true);
                                    break;
                                } while (true);
                                {
                                    catch (Exception var9_34) {
                                        var10_19 = null;
                                        break block43;
                                    }
                                }
                                {
                                    catch (Exception var9_35) {
                                        var10_19 = null;
                                        var11_16 = null;
                                        break block43;
                                    }
                                }
                                catch (Throwable var15_40) {
                                    break block45;
                                }
                                catch (Exception var9_36) {
                                    var10_19 = null;
                                    var11_16 = null;
                                    break block46;
                                }
                                catch (Throwable var15_41) {
                                    var12_12 = null;
                                }
                            }
                            var10_19 = null;
                            var13_13 = null;
                            break block44;
                            catch (Exception var9_37) {
                                var10_19 = null;
                                var11_16 = null;
                                var12_12 = null;
                            }
                        }
                        var13_13 = null;
                    }
                    var14_44 = new StringBuilder();
                    var14_44.append("Error downloading video from ");
                    var14_44.append((Object)var2_2);
                    g.a("StartAppWall.ProgressiveVideoManager", 6, var14_44.toString(), (Throwable)var9_38);
                    new File(h.a(var1_1, var11_16)).delete();
                    try {
                        this.c = null;
                        var12_12.close();
                        var13_13.close();
                        var10_19.close();
                        return null;
                    }
                    catch (Exception v3) {}
                    return null;
                    catch (Throwable var15_43) {
                        // empty catch block
                    }
                }
                try {
                    this.c = null;
                    var12_12.close();
                    var13_13.close();
                    var10_19.close();
                    throw var15_42;
                }
                catch (Exception v4) {}
                throw var15_42;
            }
            var22_8 = var44_26;
            var21_7 = var38_24;
            var26_14 = var50_29;
            var34_20 = var43_25;
            ** while (true)
        }
        var38_24 = var21_7;
        ** while (true)
    }

    public void a(c.c c2) {
        this.b = c2;
    }

    public void a(String string) {
        if (string != null && string.equals((Object)this.c)) {
            this.a = false;
        }
    }

    public boolean b(String string) {
        return string != null && string.endsWith(".temp");
    }

    public void c(String string) {
        if (this.b(string)) {
            new File(string).delete();
        }
    }

    public static interface a {
        public void a(String var1);
    }

    private static class b {
        private static final c a = new c();
    }

}

