/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Build
 *  java.io.BufferedReader
 *  java.io.File
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.InputStreamReader
 *  java.io.Reader
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.Process
 *  java.lang.Runtime
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.HashMap
 *  java.util.List
 *  java.util.NoSuchElementException
 *  java.util.Scanner
 *  java.util.Set
 */
package com.startapp.android.b;

import android.content.Context;
import android.os.Build;
import com.startapp.android.b.b;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Set;

public class a {
    private final Context a;

    public a(Context context) {
        this.a = context;
    }

    /*
     * Exception decompiling
     */
    private boolean a(List<String> var1) {
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

    private String[] i() {
        void var2_5;
        String[] arrstring = new String[]{};
        try {
            String[] arrstring2 = new Scanner(Runtime.getRuntime().exec("getprop").getInputStream()).useDelimiter("\\A").next().split("\n");
            return arrstring2;
        }
        catch (NoSuchElementException noSuchElementException) {
        }
        catch (IOException iOException) {
            // empty catch block
        }
        var2_5.printStackTrace();
        return arrstring;
    }

    private String[] j() {
        void var2_5;
        String[] arrstring = new String[]{};
        try {
            String[] arrstring2 = new Scanner(Runtime.getRuntime().exec("mount").getInputStream()).useDelimiter("\\A").next().split("\n");
            return arrstring2;
        }
        catch (NoSuchElementException noSuchElementException) {
        }
        catch (IOException iOException) {
            // empty catch block
        }
        var2_5.printStackTrace();
        return arrstring;
    }

    public boolean a() {
        return this.c() || this.d() || this.a("su") || this.a("busybox") || this.f() || this.g() || this.b() || this.h() || this.e();
        {
        }
    }

    public boolean a(String string2) {
        String[] arrstring = b.d;
        int n2 = arrstring.length;
        boolean bl2 = false;
        for (int i2 = 0; i2 < n2; ++i2) {
            String string3 = arrstring[i2];
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string3);
            stringBuilder.append(string2);
            stringBuilder.toString();
            if (!new File(string3, string2).exists()) continue;
            bl2 = true;
        }
        return bl2;
    }

    public boolean a(String[] arrstring) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll((Collection)Arrays.asList((Object[])b.a));
        if (arrstring != null && arrstring.length > 0) {
            arrayList.addAll((Collection)Arrays.asList((Object[])arrstring));
        }
        return this.a((List<String>)arrayList);
    }

    public boolean b() {
        String string2 = Build.TAGS;
        return string2 != null && string2.contains((CharSequence)"test-keys");
    }

    public boolean b(String[] arrstring) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll((Collection)Arrays.asList((Object[])b.b));
        if (arrstring != null && arrstring.length > 0) {
            arrayList.addAll((Collection)Arrays.asList((Object[])arrstring));
        }
        return this.a((List<String>)arrayList);
    }

    public boolean c() {
        return this.a((String[])null);
    }

    public boolean d() {
        return this.b(null);
    }

    public boolean e() {
        return this.a("magisk");
    }

    public boolean f() {
        HashMap hashMap = new HashMap();
        hashMap.put((Object)"ro.debuggable", (Object)"1");
        hashMap.put((Object)"ro.secure", (Object)"0");
        String[] arrstring = this.i();
        int n2 = arrstring.length;
        boolean bl2 = false;
        for (int i2 = 0; i2 < n2; ++i2) {
            String string2 = arrstring[i2];
            for (String string3 : hashMap.keySet()) {
                if (!string2.contains((CharSequence)string3)) continue;
                String string4 = (String)hashMap.get((Object)string3);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("[");
                stringBuilder.append(string4);
                stringBuilder.append("]");
                if (!string2.contains((CharSequence)stringBuilder.toString())) continue;
                bl2 = true;
            }
        }
        return bl2;
    }

    public boolean g() {
        String[] arrstring = this.j();
        int n2 = arrstring.length;
        boolean bl2 = false;
        for (int i2 = 0; i2 < n2; ++i2) {
            String[] arrstring2 = arrstring[i2].split(" ");
            if (arrstring2.length < 4) continue;
            String string2 = arrstring2[1];
            String string3 = arrstring2[3];
            String[] arrstring3 = b.e;
            int n3 = arrstring3.length;
            boolean bl3 = bl2;
            block1 : for (int i3 = 0; i3 < n3; ++i3) {
                if (!string2.equalsIgnoreCase(arrstring3[i3])) continue;
                String[] arrstring4 = string3.split(",");
                int n4 = arrstring4.length;
                for (int i4 = 0; i4 < n4; ++i4) {
                    if (!arrstring4[i4].equalsIgnoreCase("rw")) continue;
                    bl3 = true;
                    continue block1;
                }
            }
            bl2 = bl3;
        }
        return bl2;
    }

    public boolean h() {
        boolean bl2;
        block6 : {
            Process process = null;
            try {
                process = Runtime.getRuntime().exec(new String[]{"which", "su"});
                String string2 = new BufferedReader((Reader)new InputStreamReader(process.getInputStream())).readLine();
                bl2 = false;
                if (string2 != null) {
                    bl2 = true;
                }
                if (process == null) break block6;
            }
            catch (Throwable throwable) {
                if (process != null) {
                    process.destroy();
                }
                throw throwable;
            }
            catch (Throwable throwable) {
                if (process != null) {
                    process.destroy();
                }
                return false;
            }
            process.destroy();
        }
        return bl2;
    }
}

