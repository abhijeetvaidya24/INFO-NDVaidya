/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  java.io.File
 *  java.io.FileNotFoundException
 *  java.io.FileOutputStream
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.OutputStream
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.net.URL
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.Comparator
 *  java.util.HashMap
 *  java.util.Iterator
 *  java.util.LinkedList
 *  java.util.List
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 *  java.util.concurrent.BlockingQueue
 *  java.util.concurrent.ExecutorService
 *  java.util.concurrent.Future
 *  java.util.concurrent.LinkedBlockingQueue
 *  java.util.concurrent.ThreadPoolExecutor
 *  java.util.concurrent.TimeUnit
 */
package com.tapjoy.internal;

import android.content.Context;
import android.content.SharedPreferences;
import com.tapjoy.internal.da;
import com.tapjoy.internal.y;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class gw {
    public static final gw a = new gw();
    public Context b;
    public SharedPreferences c = null;
    public SharedPreferences d = null;
    ExecutorService e;
    private File f;

    private gw() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 1L, TimeUnit.SECONDS, (BlockingQueue)new LinkedBlockingQueue());
        this.e = threadPoolExecutor;
    }

    public static boolean a(long l2) {
        return l2 >= 3600L;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void c() {
        gw gw2 = this;
        synchronized (gw2) {
            boolean bl2;
            SharedPreferences.Editor editor;
            SharedPreferences.Editor editor2;
            block13 : {
                long l2 = y.b();
                File[] arrfile = this.b().listFiles();
                HashMap hashMap = new HashMap();
                if (arrfile != null) {
                    for (File file : arrfile) {
                        hashMap.put((Object)file.getName(), (Object)file);
                    }
                }
                editor = this.c.edit();
                editor2 = this.d.edit();
                HashMap hashMap2 = new HashMap(this.c.getAll());
                HashMap hashMap3 = new HashMap(this.d.getAll());
                Iterator iterator = hashMap2.entrySet().iterator();
                bl2 = false;
                while (iterator.hasNext()) {
                    String string2 = (String)((Map.Entry)iterator.next()).getKey();
                    if (hashMap3.containsKey((Object)string2)) continue;
                    iterator.remove();
                    editor.remove(string2);
                    new Object[1][0] = string2;
                    bl2 = true;
                }
                Iterator iterator2 = hashMap3.entrySet().iterator();
                while (iterator2.hasNext()) {
                    String string3 = (String)((Map.Entry)iterator2.next()).getKey();
                    if (hashMap2.containsKey((Object)string3)) continue;
                    iterator2.remove();
                    editor2.remove(string3);
                    new Object[1][0] = string3;
                    bl2 = true;
                }
                Iterator iterator3 = hashMap2.entrySet().iterator();
                while (iterator3.hasNext()) {
                    Map.Entry entry = (Map.Entry)iterator3.next();
                    String string4 = (String)entry.getKey();
                    if ((Long)entry.getValue() < l2) {
                        iterator3.remove();
                        editor.remove(string4);
                        editor2.remove(string4);
                        bl2 = true;
                        continue;
                    }
                    hashMap.remove((Object)string4);
                }
                Iterator iterator4 = hashMap.entrySet().iterator();
                while (iterator4.hasNext()) {
                    File file = (File)((Map.Entry)iterator4.next()).getValue();
                    file.delete();
                    new Object[1][0] = file;
                }
                if (hashMap2.size() <= 30) break block13;
                int n2 = hashMap2.size() - 30;
                LinkedList linkedList = new LinkedList((Collection)hashMap2.entrySet());
                Collections.sort((List)linkedList, (Comparator)new Comparator(){

                    public final /* synthetic */ int compare(Object object, Object object2) {
                        Map.Entry entry = (Map.Entry)object;
                        Map.Entry entry2 = (Map.Entry)object2;
                        return ((Long)entry.getValue()).compareTo((Long)entry2.getValue());
                    }
                });
                Iterator iterator5 = linkedList.iterator();
                for (int i2 = 0; i2 < n2 && iterator5.hasNext(); ++i2) {
                    Map.Entry entry = (Map.Entry)iterator5.next();
                    String string5 = (String)entry.getKey();
                    Long l3 = (Long)entry.getValue();
                    editor.remove(string5);
                    editor2.remove(string5);
                    File file = this.a(string5);
                    file.delete();
                    Object[] arrobject = new Object[]{file, l3};
                }
                bl2 = true;
            }
            if (!bl2) return;
            editor.commit();
            editor2.commit();
            return;
        }
    }

    final File a(String string2) {
        return new File(this.b(), string2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final File a(URL uRL) {
        if (this.b == null) {
            return null;
        }
        gw gw2 = this;
        synchronized (gw2) {
            String string2 = this.b(uRL);
            File file = this.a(string2);
            if (!file.exists()) {
                return null;
            }
            long l2 = y.b();
            long l3 = this.c.getLong(string2, 0L);
            if (l3 >= l2) {
                Object[] arrobject = new Object[]{string2, uRL};
                return file;
            }
            Object[] arrobject = new Object[]{string2, l2, l3};
            if (l3 != 0L) {
                this.c.edit().remove(string2).commit();
                this.d.edit().remove(string2).commit();
            }
            file.delete();
            return null;
        }
    }

    public final void a() {
        this.e.submit(new Runnable(){

            public final void run() {
                if (gw.this.b == null) {
                    return;
                }
                gw.this.c();
            }
        });
    }

    final File b() {
        File file = this.f;
        if (file == null) {
            this.f = file = new File(this.b.getCacheDir(), "tapjoy_mm_cache");
        }
        if (!file.isDirectory()) {
            file.delete();
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    /*
     * Exception decompiling
     */
    final String b(URL var1_1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [4[DOLOOP]], but top level block is 1[TRYBLOCK]
        // org.benf.cfr.reader.b.a.a.j.a(Op04StructuredStatement.java:432)
        // org.benf.cfr.reader.b.a.a.j.d(Op04StructuredStatement.java:484)
        // org.benf.cfr.reader.b.a.a.i.a(Op03SimpleStatement.java:607)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:692)
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

}

