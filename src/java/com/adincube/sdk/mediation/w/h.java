/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.adincube.sdk.h.a.e
 *  com.adincube.sdk.h.c.b
 *  java.io.File
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.Iterator
 *  java.util.List
 *  java.util.concurrent.ExecutorService
 *  java.util.concurrent.Executors
 *  java.util.concurrent.Future
 */
package com.adincube.sdk.mediation.w;

import android.content.Context;
import com.adincube.sdk.h.a.e;
import com.adincube.sdk.h.c.b;
import com.adincube.sdk.util.ErrorReportingHelper;
import com.adincube.sdk.util.f;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class h {
    private static h a;
    private ExecutorService b = Executors.newSingleThreadExecutor();
    private List<e> c = new ArrayList();

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static h a() {
        if (a != null) return a;
        Class<h> class_ = h.class;
        synchronized (h.class) {
            if (a != null) return a;
            a = new h();
            // ** MonitorExit[var1] (shouldn't be in output)
            return a;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void a(e e2) {
        List<e> list;
        List<e> list2 = list = this.c;
        synchronized (list2) {
            this.c.add((Object)e2);
            return;
        }
    }

    public final void b() {
        this.b.submit((Runnable)new a(0));
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void b(e e2) {
        List<e> list;
        List<e> list2 = list = this.c;
        synchronized (list2) {
            this.c.remove((Object)e2);
            return;
        }
    }

    private final class a
    implements Runnable {
        private a() {
        }

        /* synthetic */ a(byte by) {
            this();
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        private boolean a(File file) {
            List list;
            List list2 = list = h.this.c;
            synchronized (list2) {
                boolean bl = false;
                Iterator iterator = h.this.c.iterator();
                while (!bl) {
                    if (!iterator.hasNext()) return bl;
                    bl = file.getName().substring(8).startsWith(((e)iterator.next()).o);
                }
                return bl;
            }
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        public final void run() {
            ArrayList arrayList;
            int n2;
            String[] arrstring;
            int n3;
            Context context;
            try {
                context = f.a();
                arrayList = new ArrayList();
                arrstring = context.fileList();
                n3 = arrstring.length;
                n2 = 0;
            }
            catch (Throwable throwable) {
                ErrorReportingHelper.report("RTBInterstitialMediationAdapter.cleanResourcesOfPreviousRTBAd", b.a, throwable);
                com.adincube.sdk.util.a.c("RTBInterstitialMediationAdapter.cleanResourcesOfPreviousRTBAd", new Object[]{throwable});
                return;
            }
            do {
                if (n2 < n3) {
                    String string = arrstring[n2];
                    if (string.startsWith("AIC_RTB_")) {
                        arrayList.add((Object)context.getFileStreamPath(string));
                    }
                } else {
                    Iterator iterator = arrayList.iterator();
                    do {
                        if (!iterator.hasNext()) {
                            return;
                        }
                        File file = (File)iterator.next();
                        if (this.a(file)) continue;
                        file.delete();
                    } while (true);
                }
                ++n2;
            } while (true);
        }
    }

}

