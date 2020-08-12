/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  java.lang.IllegalStateException
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Thread
 *  java.util.Collection
 *  java.util.HashSet
 *  java.util.Iterator
 *  java.util.LinkedList
 *  java.util.List
 *  java.util.Queue
 *  java.util.Set
 *  java.util.concurrent.atomic.AtomicBoolean
 */
package com.aerserv.sdk.adapter;

import android.app.Activity;
import com.aerserv.sdk.adapter.Adapter;
import com.aerserv.sdk.model.Asplc;
import com.aerserv.sdk.utils.AerServLog;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public class AdapterAdRefresher {
    private static final int FAILURE_THRESHOLD = 3;
    private static AtomicBoolean INITTED;
    private static boolean IS_ENABLED = false;
    private static final Set<String> KEYSET;
    private static final String LOG_TAG = "AdapterAdRefresher";
    private static final Queue<Tuple> QUEUE;
    private static long SLEEP_TIME_IN_MILLISECONDS = 1200000L;

    static {
        QUEUE = new LinkedList();
        KEYSET = new HashSet();
        INITTED = new AtomicBoolean();
    }

    static /* synthetic */ String access$000() {
        return LOG_TAG;
    }

    static /* synthetic */ long access$100() {
        return SLEEP_TIME_IN_MILLISECONDS;
    }

    static /* synthetic */ Queue access$200() {
        return QUEUE;
    }

    static /* synthetic */ boolean access$300() {
        return IS_ENABLED;
    }

    static /* synthetic */ void access$400(Tuple tuple) {
        AdapterAdRefresher.remove(tuple);
    }

    static /* synthetic */ Set access$500() {
        return KEYSET;
    }

    static /* synthetic */ String access$600(Tuple tuple) {
        return AdapterAdRefresher.getKey(tuple);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public static void addAdapter(Adapter adapter, Activity activity, Asplc asplc, String string, boolean bl, boolean bl2) {
        String string2;
        try {
            Set<String> set;
            string2 = AdapterAdRefresher.getKey(adapter);
            Set<String> set2 = set = KEYSET;
            // MONITORENTER : set2
        }
        catch (IllegalStateException illegalStateException) {
            String string3 = LOG_TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Failed to add adapter: ");
            stringBuilder.append((Object)illegalStateException);
            AerServLog.e(string3, stringBuilder.toString());
            return;
        }
        if (KEYSET.contains((Object)string2)) {
            String string4 = LOG_TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("asplcid: ");
            stringBuilder.append(asplc.getAsplcId());
            stringBuilder.append(" of plc: ");
            stringBuilder.append(string);
            stringBuilder.append(" already in queue, skip.");
            AerServLog.d(string4, stringBuilder.toString());
            // MONITOREXIT : set2
            return;
        }
        Queue<Tuple> queue = QUEUE;
        Tuple tuple = new Tuple(adapter, activity, asplc, string, bl, bl2);
        queue.add((Object)tuple);
        KEYSET.add((Object)string2);
        // MONITOREXIT : set2
        String string5 = LOG_TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Add asplcid: ");
        stringBuilder.append(asplc.getAsplcId());
        stringBuilder.append(" of plc: ");
        stringBuilder.append(string);
        AerServLog.d(string5, stringBuilder.toString());
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static final void checkAllAdapters(String string, List<Asplc> list, List<Integer> list2) {
        Set<String> set;
        HashSet hashSet = new HashSet();
        if (list != null) {
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                hashSet.add((Object)((Asplc)iterator.next()).getAsplcId());
            }
        }
        if (list2 != null) {
            hashSet.addAll(list2);
        }
        Set<String> set2 = set = KEYSET;
        synchronized (set2) {
            Iterator iterator = QUEUE.iterator();
            while (iterator.hasNext()) {
                Tuple tuple = (Tuple)iterator.next();
                if (!tuple.getPlc().equals((Object)string) || hashSet.contains((Object)tuple.getAsplc().getAsplcId())) continue;
                String string2 = LOG_TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Not in the step1 response, remove asplcid: ");
                stringBuilder.append(tuple.getAsplc().getAsplcId());
                stringBuilder.append(" of plc: ");
                stringBuilder.append(string);
                AerServLog.d(string2, stringBuilder.toString());
                iterator.remove();
                KEYSET.remove((Object)AdapterAdRefresher.getKey(tuple));
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static boolean containsAdapter(Adapter adapter) {
        Set<String> set;
        String string = AdapterAdRefresher.getKey(adapter);
        Set<String> set2 = set = KEYSET;
        synchronized (set2) {
            return KEYSET.contains((Object)string);
        }
    }

    private static String getKey(Adapter adapter) {
        return Integer.toString((int)adapter.hashCode());
    }

    private static String getKey(Tuple tuple) {
        return AdapterAdRefresher.getKey(tuple.getAdapter());
    }

    public static void init() {
        if (INITTED.compareAndSet(false, true)) {
            new Thread(new Runnable(){

                /*
                 * Exception decompiling
                 */
                public void run() {
                    // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
                    // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [2[TRYBLOCK]], but top level block is 4[TRYBLOCK]
                    // org.benf.cfr.reader.b.a.a.j.a(Op04StructuredStatement.java:432)
                    // org.benf.cfr.reader.b.a.a.j.d(Op04StructuredStatement.java:484)
                    // org.benf.cfr.reader.b.a.a.i.a(Op03SimpleStatement.java:607)
                    // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:692)
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
            }).start();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static void remove(Tuple tuple) {
        Set<String> set;
        Set<String> set2 = set = KEYSET;
        synchronized (set2) {
            QUEUE.remove((Object)tuple);
            KEYSET.remove((Object)AdapterAdRefresher.getKey(tuple));
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static final void removeAdapter(String string, int n2) {
        Set<String> set;
        Set<String> set2 = set = KEYSET;
        synchronized (set2) {
            Iterator iterator = QUEUE.iterator();
            while (iterator.hasNext()) {
                Tuple tuple = (Tuple)iterator.next();
                if (!tuple.getPlc().equals((Object)string) || n2 != tuple.getAsplc().getAsplcId()) continue;
                String string2 = LOG_TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("remove asplcid: ");
                stringBuilder.append(tuple.getAsplc().getAsplcId());
                stringBuilder.append(" of plc: ");
                stringBuilder.append(string);
                AerServLog.d(string2, stringBuilder.toString());
                iterator.remove();
                KEYSET.remove((Object)AdapterAdRefresher.getKey(tuple));
            }
            return;
        }
    }

    public static void setEnableFlag(boolean bl) {
        IS_ENABLED = bl;
        String string = LOG_TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Set enabled flag: ");
        stringBuilder.append(IS_ENABLED);
        AerServLog.d(string, stringBuilder.toString());
    }

    public static void setSleepTimeInMilliseconds(long l2) {
        SLEEP_TIME_IN_MILLISECONDS = l2;
        String string = LOG_TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Set expiration time: ");
        stringBuilder.append(SLEEP_TIME_IN_MILLISECONDS);
        AerServLog.d(string, stringBuilder.toString());
    }

    private static class Tuple {
        private final Activity activity;
        private Adapter adapter;
        private final Asplc asplc;
        private boolean debugFlag;
        private int failureCount;
        private long lastRefreshTime;
        private final String plc;
        private boolean rewardedAd;

        public Tuple(Adapter adapter, Activity activity, Asplc asplc, String string, boolean bl, boolean bl2) {
            this.adapter = adapter;
            this.activity = activity;
            this.asplc = asplc;
            this.plc = string;
            this.failureCount = 0;
            this.lastRefreshTime = System.currentTimeMillis();
            this.rewardedAd = bl;
            this.debugFlag = bl2;
        }

        public Activity getActivity() {
            return this.activity;
        }

        public Adapter getAdapter() {
            return this.adapter;
        }

        public Asplc getAsplc() {
            return this.asplc;
        }

        public int getFailureCount() {
            return this.failureCount;
        }

        public long getLastRefreshTime() {
            return this.lastRefreshTime;
        }

        public String getPlc() {
            return this.plc;
        }

        public void incrementFailureCount() {
            this.failureCount = 1 + this.failureCount;
        }

        public boolean isDebug() {
            return this.debugFlag;
        }

        public boolean isRewardedAd() {
            return this.rewardedAd;
        }

        public void resetLastRefreshTime() {
            this.lastRefreshTime = System.currentTimeMillis();
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.asplc.getAsplcId());
            stringBuilder.append(" ");
            stringBuilder.append(this.asplc.getAdapterName());
            stringBuilder.append(" ");
            stringBuilder.append(this.adapter.hashCode());
            return stringBuilder.toString();
        }
    }

}

