/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  com.adincube.sdk.g.a
 *  com.adincube.sdk.h.b.b
 *  com.adincube.sdk.h.c.a
 *  com.adincube.sdk.h.c.b
 *  java.lang.Class
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.HashMap
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 *  java.util.concurrent.ExecutorService
 *  java.util.concurrent.Executors
 *  java.util.concurrent.Future
 *  java.util.concurrent.locks.Lock
 *  java.util.concurrent.locks.ReadWriteLock
 *  java.util.concurrent.locks.ReentrantLock
 *  java.util.concurrent.locks.ReentrantReadWriteLock
 *  org.json.JSONArray
 *  org.json.JSONObject
 */
package com.adincube.sdk.util.e;

import android.content.SharedPreferences;
import com.adincube.sdk.util.ErrorReportingHelper;
import com.adincube.sdk.util.a;
import com.adincube.sdk.util.f;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.json.JSONArray;
import org.json.JSONObject;

public class b {
    private static b a;
    private com.adincube.sdk.g.a b;
    private ExecutorService c;
    private Map<String, List<Long>> d = new HashMap();
    private ReadWriteLock e = new ReentrantReadWriteLock();
    private Lock f = this.e.writeLock();
    private Lock g = this.e.readLock();
    private Lock h = new ReentrantLock();

    private b(com.adincube.sdk.g.a a2) {
        this.b = a2;
        this.c = Executors.newSingleThreadExecutor();
        this.c.submit(new Runnable(){

            /*
             * Exception decompiling
             */
            public final void run() {
                // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
                // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl47.3 : FAKE_TRY : trying to set 1 previously set to 0
                // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
                // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
                // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
                // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
                // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
                // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
                // org.benf.cfr.reader.entities.g.p(Method.java:396)
                // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
                // org.benf.cfr.reader.entities.d.c(ClassFile.java:773)
                // org.benf.cfr.reader.entities.d.e(ClassFile.java:870)
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
        });
    }

    private static long a(Map<String, List<Long>> map, com.adincube.sdk.h.c.b b2) {
        String string = b.c(b2);
        Iterator iterator = map.entrySet().iterator();
        long l2 = 0L;
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry)iterator.next();
            if (!((String)entry.getKey()).startsWith(string)) continue;
            l2 += (long)((List)entry.getValue()).size();
        }
        return l2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static b a() {
        if (a != null) return a;
        Class<b> class_ = b.class;
        synchronized (b.class) {
            a = new b(com.adincube.sdk.g.a.a());
            // ** MonitorExit[var1] (shouldn't be in output)
            return a;
        }
    }

    static /* synthetic */ Lock a(b b2) {
        return b2.f;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    private void a(com.adincube.sdk.h.c.b b2, com.adincube.sdk.h.c.a a2) {
        Map<String, List<Long>> map;
        String string = b.c(b2);
        HashMap hashMap = new HashMap();
        Map<String, List<Long>> map2 = map = this.d;
        // MONITORENTER : map2
        for (Map.Entry entry : this.d.entrySet()) {
            if (!((String)entry.getKey()).startsWith(string)) continue;
            hashMap.put(entry.getKey(), (Object)new ArrayList((Collection)entry.getValue()));
        }
        // MONITOREXIT : map2
        {
            catch (Throwable throwable) {}
            {
                // MONITOREXIT : map2
                throw throwable;
            }
        }
        this.c.submit(new Runnable((Map)hashMap, b2, a2){
            final /* synthetic */ Map a;
            final /* synthetic */ com.adincube.sdk.h.c.b b;
            final /* synthetic */ com.adincube.sdk.h.c.a c;
            {
                this.a = map;
                this.b = b3;
                this.c = a2;
            }

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            public final void run() {
                try {
                    SharedPreferences.Editor editor = b.c().edit();
                    Iterator iterator = this.a.entrySet().iterator();
                    do {
                        JSONArray jSONArray;
                        Map.Entry entry;
                        if (iterator.hasNext()) {
                            entry = (Map.Entry)iterator.next();
                            if (((List)entry.getValue()).size() == 0) {
                                editor.remove((String)entry.getKey());
                                continue;
                            }
                            jSONArray = new JSONArray();
                        } else {
                            editor.apply();
                            return;
                        }
                        for (int i2 = 0; i2 < ((List)entry.getValue()).size(); ++i2) {
                            jSONArray.put(((List)entry.getValue()).get(i2));
                        }
                        editor.putString((String)entry.getKey(), jSONArray.toString());
                    } while (true);
                }
                catch (Throwable throwable) {
                    a.c("ImpressionCounter.saveImpressionTimestampsForNetworkInSharedPreferences", new Object[]{throwable});
                    ErrorReportingHelper.report("ImpressionCounter.saveImpressionTimestampsForNetworkInSharedPreferences", this.b, this.c, throwable);
                    return;
                }
            }
        });
    }

    static /* synthetic */ Lock b(b b2) {
        return b2.h;
    }

    private static void b(Map<String, List<Long>> map, com.adincube.sdk.h.c.b b2) {
        String string = b.c(b2);
        Iterator iterator = map.entrySet().iterator();
        long l2 = Long.MAX_VALUE;
        List list = null;
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry)iterator.next();
            if (!((String)entry.getKey()).startsWith(string) || ((List)entry.getValue()).size() <= 0 || (Long)((List)entry.getValue()).get(0) >= l2) continue;
            l2 = (Long)((List)entry.getValue()).get(0);
            list = (List)entry.getValue();
        }
        if (list != null) {
            list.remove(0);
        }
    }

    static /* synthetic */ SharedPreferences c() {
        return f.a().getSharedPreferences("NPB-impr", 0);
    }

    private static String c(com.adincube.sdk.h.c.b b2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(b2.g);
        stringBuilder.append("-");
        return stringBuilder.toString();
    }

    static /* synthetic */ Map c(b b2) {
        return b2.d;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public final JSONObject a(com.adincube.sdk.h.c.b b2) {
        Map<String, List<Long>> map;
        this.g.lock();
        JSONObject jSONObject = new JSONObject();
        String string = b.c(b2);
        Map<String, List<Long>> map2 = map = this.d;
        // MONITORENTER : map2
        Iterator iterator = this.d.entrySet().iterator();
        do {
            JSONArray jSONArray;
            Map.Entry entry;
            if (iterator.hasNext()) {
                entry = (Map.Entry)iterator.next();
                if (!((String)entry.getKey()).startsWith(string)) continue;
                jSONArray = new JSONArray();
            } else {
                this.g.unlock();
                return jSONObject;
            }
            for (int i2 = 0; i2 < ((List)entry.getValue()).size(); ++i2) {
                jSONArray.put(((List)entry.getValue()).get(i2));
            }
            jSONObject.put(((String)entry.getKey()).substring(string.length()), (Object)jSONArray);
        } while (true);
        {
            catch (Throwable throwable) {}
            {
                // MONITOREXIT : map2
                throw throwable;
            }
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public final void a(String string, com.adincube.sdk.h.c.b b2, com.adincube.sdk.h.c.a a2) {
        Map<String, List<Long>> map;
        this.h.lock();
        long l2 = System.currentTimeMillis();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(b.c(b2));
        stringBuilder.append(string);
        String string2 = stringBuilder.toString();
        Map<String, List<Long>> map2 = map = this.d;
        // MONITORENTER : map2
        List list = (List)this.d.get((Object)string2);
        if (list == null) {
            list = new ArrayList();
            this.d.put((Object)string2, (Object)list);
        }
        list.add((Object)l2);
        long l3 = this.b.a((boolean)true, (boolean)true).e;
        for (long i2 = b.a(this.d, (com.adincube.sdk.h.c.b)b2); i2 > l3; --i2) {
            b.b(this.d, b2);
        }
        {
            catch (Throwable throwable) {}
            {
                // MONITOREXIT : map2
                throw throwable;
            }
        }
        this.a(b2, a2);
        this.h.unlock();
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public final long b(com.adincube.sdk.h.c.b b2) {
        Map<String, List<Long>> map;
        this.g.lock();
        String string = b.c(b2);
        Map<String, List<Long>> map2 = map = this.d;
        // MONITORENTER : map2
        Iterator iterator = this.d.entrySet().iterator();
        long l2 = 0L;
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry)iterator.next();
            if (!((String)entry.getKey()).startsWith(string)) continue;
            for (Long l3 : (List)entry.getValue()) {
                if (l3 <= l2) continue;
                l2 = l3;
            }
        }
        // MONITOREXIT : map2
        {
            catch (Throwable throwable) {}
            {
                // MONITOREXIT : map2
                throw throwable;
            }
        }
        this.g.unlock();
        return l2;
    }

    public final void b() {
        this.h.lock();
        this.d.clear();
        this.h.unlock();
        this.c.submit(new Runnable(){

            public final void run() {
                try {
                    b.c().edit().clear().apply();
                    return;
                }
                catch (Throwable throwable) {
                    a.c("ImpressionCounter.cleanAll", new Object[]{throwable});
                    ErrorReportingHelper.report("ImpressionCounter.cleanAll", throwable);
                    return;
                }
            }
        });
    }

}

