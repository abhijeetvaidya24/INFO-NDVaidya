/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.chartboost.sdk.Tracking.a
 *  com.chartboost.sdk.impl.k
 *  java.io.File
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.Comparator
 *  java.util.List
 *  java.util.Map
 *  java.util.PriorityQueue
 *  java.util.concurrent.Executor
 *  java.util.concurrent.TimeUnit
 *  java.util.concurrent.atomic.AtomicInteger
 *  java.util.concurrent.atomic.AtomicReference
 *  org.json.JSONObject
 */
package com.chartboost.sdk.impl;

import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Libraries.CBUtility;
import com.chartboost.sdk.Libraries.f;
import com.chartboost.sdk.Libraries.g;
import com.chartboost.sdk.Libraries.i;
import com.chartboost.sdk.Model.CBError;
import com.chartboost.sdk.Model.b;
import com.chartboost.sdk.Model.e;
import com.chartboost.sdk.Tracking.a;
import com.chartboost.sdk.impl.ad;
import com.chartboost.sdk.impl.ag;
import com.chartboost.sdk.impl.ah;
import com.chartboost.sdk.impl.ai;
import com.chartboost.sdk.impl.h;
import com.chartboost.sdk.impl.j;
import com.chartboost.sdk.impl.k;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONObject;

public class l {
    int a = 1;
    private final Executor b;
    private final ah c;
    private final ai d;
    private final AtomicReference<e> e;
    private final i f;
    private final a g;
    private final f h;
    private k i = null;
    private final PriorityQueue<j> j;

    public l(Executor executor, f f2, ah ah2, ai ai2, AtomicReference<e> atomicReference, i i2, a a2) {
        this.b = executor;
        this.h = f2;
        this.c = ah2;
        this.d = ai2;
        this.e = atomicReference;
        this.f = i2;
        this.g = a2;
        this.j = new PriorityQueue();
    }

    private void d() {
        j j2;
        j j3;
        if (this.i != null && (j3 = (j)this.j.peek()) != null && this.i.a.a > j3.a && this.i.b()) {
            this.j.add((Object)this.i.a);
            this.i = null;
        }
        while (this.i == null && (j2 = (j)this.j.poll()) != null) {
            if (j2.e.get() <= 0) continue;
            File file = new File(this.h.d().a, j2.d);
            if (!(file.exists() || file.mkdirs() || file.isDirectory())) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unable to create directory ");
                stringBuilder.append(file.getPath());
                CBLogging.b("Downloader", stringBuilder.toString());
                j2.a(this.b, false);
                continue;
            }
            File file2 = new File(file, j2.b);
            if (file2.exists()) {
                this.h.c(file2);
                j2.a(this.b, true);
                continue;
            }
            this.i = new k(this, this.d, j2, file2);
            this.c.a(this.i);
            this.g.a(j2.c, j2.b);
        }
        if (this.i != null) {
            if (this.a != 2) {
                CBLogging.a("Downloader", "Change state to DOWNLOADING");
                this.a = 2;
                return;
            }
        } else if (this.a != 1) {
            CBLogging.a("Downloader", "Change state to IDLE");
            this.a = 1;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a() {
        l l2 = this;
        synchronized (l2) {
            int n2 = this.a;
            if (n2 != 1) {
                if (n2 == 2) {
                    if (this.i.b()) {
                        this.j.add((Object)this.i.a);
                        this.i = null;
                        CBLogging.a("Downloader", "Change state to PAUSED");
                        this.a = 4;
                    } else {
                        CBLogging.a("Downloader", "Change state to PAUSING");
                        this.a = 3;
                    }
                }
            } else {
                CBLogging.a("Downloader", "Change state to PAUSED");
                this.a = 4;
            }
            return;
        }
    }

    public void a(int n2, Map<String, b> map, AtomicInteger atomicInteger, h h2) {
        l l2 = this;
        synchronized (l2) {
            AtomicInteger atomicInteger2;
            i i2;
            String string;
            long l3;
            long l4;
            long l5;
            String string2;
            AtomicReference atomicReference;
            String string3;
            try {
                l4 = this.f.b();
                atomicInteger2 = new AtomicInteger();
                atomicReference = new AtomicReference((Object)h2);
                for (b b2 : map.values()) {
                    i2 = this.f;
                    string2 = b2.b;
                    string3 = b2.c;
                    string = b2.a;
                    l3 = l4;
                    l5 = l4;
                }
            }
            catch (Throwable throwable) {}
            {
                throw throwable;
            }
            {
                j j2 = new j(i2, n2, string2, string3, string, atomicInteger, (AtomicReference<h>)atomicReference, l3, atomicInteger2);
                this.j.add((Object)j2);
                l4 = l5;
                continue;
            }
            if (this.a == 1 || this.a == 2) {
                this.d();
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    void a(k k2, CBError cBError, ag ag2) {
        l l2 = this;
        synchronized (l2) {
            boolean bl = this.a;
            boolean bl2 = true;
            if (bl != bl2 && (bl || bl)) {
                k k3 = this.i;
                if (k2 != k3) {
                    return;
                }
                j j2 = k2.a;
                this.i = null;
                long l3 = TimeUnit.NANOSECONDS.toMillis(k2.g);
                j2.f.addAndGet((int)l3);
                Executor executor = this.b;
                if (cBError != null) {
                    bl2 = false;
                }
                j2.a(executor, bl2);
                long l4 = TimeUnit.NANOSECONDS.toMillis(k2.h);
                long l5 = TimeUnit.NANOSECONDS.toMillis(k2.i);
                if (cBError == null) {
                    this.g.a(j2.c, l3, l4, l5);
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Downloaded ");
                    stringBuilder.append(j2.c);
                    CBLogging.a("Downloader", stringBuilder.toString());
                } else {
                    String string;
                    String string2;
                    String string3 = cBError.b();
                    this.g.a(j2.c, string3, l3, l4, l5);
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Failed to download ");
                    stringBuilder.append(j2.c);
                    if (ag2 != null) {
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append(" Status code=");
                        stringBuilder2.append(ag2.a);
                        string2 = stringBuilder2.toString();
                    } else {
                        string2 = "";
                    }
                    stringBuilder.append(string2);
                    if (string3 != null) {
                        StringBuilder stringBuilder3 = new StringBuilder();
                        stringBuilder3.append(" Error message=");
                        stringBuilder3.append(string3);
                        string = stringBuilder3.toString();
                    } else {
                        string = "";
                    }
                    stringBuilder.append(string);
                    CBLogging.a("Downloader", stringBuilder.toString());
                }
                if (this.a == 3) {
                    CBLogging.a("Downloader", "Change state to PAUSED");
                    this.a = 4;
                } else {
                    this.d();
                }
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(AtomicInteger atomicInteger) {
        l l2 = this;
        synchronized (l2) {
            atomicInteger.set(-10000);
            int n2 = this.a;
            int n3 = 1;
            if (n2 == n3) return;
            if (n2 == 2) {
                if (this.i.a.e != atomicInteger) {
                    return;
                }
                if (n3 == 0) return;
                if (!this.i.b()) return;
                this.i = null;
                this.d();
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void b() {
        l l2 = this;
        synchronized (l2) {
            int n2 = this.a;
            if (n2 != 1 && n2 != 2) {
                if (n2 != 3) {
                    if (n2 == 4) {
                        CBLogging.a("Downloader", "Change state to IDLE");
                        this.a = 1;
                        this.d();
                    }
                } else {
                    CBLogging.a("Downloader", "Change state to DOWNLOADING");
                    this.a = 2;
                }
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void c() {
        l l2 = this;
        synchronized (l2) {
            block16 : {
                ArrayList arrayList;
                block14 : {
                    File file;
                    int n2;
                    String[] arrstring;
                    block13 : {
                        int n3 = this.a;
                        if (n3 == 1) break block13;
                        return;
                    }
                    try {
                        CBLogging.a("Downloader", "########### Trimming the disk cache");
                        file = this.h.d().a;
                        arrayList = new ArrayList();
                        arrstring = file.list();
                        if (arrstring == null || arrstring.length <= 0) break block14;
                        n2 = arrstring.length;
                    }
                    catch (Exception exception) {
                        a.a((Class)this.getClass(), (String)"reduceCacheSize", (Exception)exception);
                        break block16;
                    }
                    for (int i2 = 0; i2 < n2; ++i2) {
                        String string = arrstring[i2];
                        if (string.equalsIgnoreCase("requests") || string.equalsIgnoreCase("track") || string.equalsIgnoreCase("session") || string.equalsIgnoreCase("videoCompletionEvents") || string.contains((CharSequence)".")) continue;
                        arrayList.addAll(CBUtility.a(new File(file, string), true));
                    }
                }
                Object[] arrobject = new File[arrayList.size()];
                arrayList.toArray(arrobject);
                if (arrobject.length > 1) {
                    Arrays.sort((Object[])arrobject, (Comparator)new Comparator<File>(){

                        public int a(File file, File file2) {
                            return Long.valueOf((long)file.lastModified()).compareTo(Long.valueOf((long)file2.lastModified()));
                        }

                        public /* synthetic */ int compare(Object object, Object object2) {
                            return this.a((File)object, (File)object2);
                        }
                    });
                }
                if (arrobject.length > 0) {
                    e e2 = (e)this.e.get();
                    long l3 = e2.u;
                    long l4 = this.h.b(this.h.d().g);
                    long l5 = this.f.a();
                    List<String> list = e2.d;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Total local file count:");
                    stringBuilder.append(arrobject.length);
                    CBLogging.a("Downloader", stringBuilder.toString());
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("Video Folder Size in bytes :");
                    stringBuilder2.append(l4);
                    CBLogging.a("Downloader", stringBuilder2.toString());
                    StringBuilder stringBuilder3 = new StringBuilder();
                    stringBuilder3.append("Max Bytes allowed:");
                    stringBuilder3.append(l3);
                    CBLogging.a("Downloader", stringBuilder3.toString());
                    int n4 = arrobject.length;
                    long l6 = l4;
                    for (int i3 = 0; i3 < n4; ++i3) {
                        Object object = arrobject[i3];
                        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                        long l7 = object.lastModified();
                        long l8 = l3;
                        long l9 = timeUnit.toDays(l5 - l7);
                        int n5 = e2.w;
                        e e3 = e2;
                        boolean bl = l9 >= (long)n5;
                        boolean bl2 = object.getName().endsWith(".tmp");
                        File file = object.getParentFile();
                        boolean bl3 = file.getAbsolutePath().contains((CharSequence)"/videos");
                        boolean bl4 = l6 > l8 && bl3;
                        boolean bl5 = object.length() == 0L || bl2 || bl || list.contains((Object)file.getName()) || bl4;
                        if (bl5) {
                            if (bl3) {
                                l6 -= object.length();
                            }
                            StringBuilder stringBuilder4 = new StringBuilder();
                            stringBuilder4.append("Deleting file at path:");
                            stringBuilder4.append(object.getPath());
                            CBLogging.a("Downloader", stringBuilder4.toString());
                            if (!object.delete()) {
                                StringBuilder stringBuilder5 = new StringBuilder();
                                stringBuilder5.append("Unable to delete ");
                                stringBuilder5.append(object.getPath());
                                CBLogging.b("Downloader", stringBuilder5.toString());
                            }
                        }
                        e2 = e3;
                        l3 = l8;
                    }
                }
                JSONObject jSONObject = this.h.e();
                this.g.a(jSONObject);
            }
            return;
        }
    }

}

