/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.AsyncTask
 *  java.io.IOException
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.lang.Void
 *  java.net.HttpRetryException
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.HashMap
 *  java.util.Iterator
 *  java.util.Map
 *  java.util.Set
 *  java.util.concurrent.Executor
 *  org.json.JSONException
 */
package com.appnext.core;

import android.content.Context;
import android.os.AsyncTask;
import com.appnext.core.f;
import java.io.IOException;
import java.net.HttpRetryException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import org.json.JSONException;

public abstract class p {
    protected static final String hF = "https://cdn.appnext.com/tools/sdk/confign";
    protected HashMap<String, String> aR = null;
    protected HashMap<String, Object> hG = null;
    private ArrayList<a> hH;
    private int state = 0;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static /* synthetic */ void a(p p2, String string2) {
        String string3 = hF;
        synchronized (hF) {
            Iterator iterator = new ArrayList(p2.hH).iterator();
            do {
                if (!iterator.hasNext()) {
                    p2.hH.clear();
                    // ** MonitorExit[var5_2] (shouldn't be in output)
                    return;
                }
                a a2 = (a)iterator.next();
                if (a2 == null) continue;
                a2.error(string2);
            } while (true);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static /* synthetic */ void a(p p2, HashMap hashMap) {
        String string2 = hF;
        synchronized (hF) {
            Iterator iterator = new ArrayList(p2.hH).iterator();
            do {
                if (!iterator.hasNext()) {
                    p2.hH.clear();
                    // ** MonitorExit[var4_2] (shouldn't be in output)
                    return;
                }
                ((a)iterator.next()).b((HashMap<String, Object>)hashMap);
            } while (true);
        }
    }

    private String ae(String string2) {
        HashMap<String, String> hashMap = this.aR;
        if (hashMap == null) {
            return string2;
        }
        for (String string3 : hashMap.keySet()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string2);
            String string4 = "?";
            if (string2.contains((CharSequence)string4)) {
                string4 = "&";
            }
            stringBuilder.append(string4);
            stringBuilder.append(string3);
            stringBuilder.append("=");
            stringBuilder.append((String)this.aR.get((Object)string3));
            string2 = stringBuilder.toString();
        }
        return string2;
    }

    /*
     * Exception decompiling
     */
    protected static HashMap<String, Object> af(String var0) throws JSONException {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl13 : ALOAD_3 : trying to set 1 previously set to 0
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

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void ag(String string2) {
        String string3 = hF;
        synchronized (hF) {
            Iterator iterator = new ArrayList(this.hH).iterator();
            do {
                if (!iterator.hasNext()) {
                    this.hH.clear();
                    // ** MonitorExit[var5_2] (shouldn't be in output)
                    return;
                }
                a a2 = (a)iterator.next();
                if (a2 == null) continue;
                a2.error(string2);
            } while (true);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void e(HashMap<String, Object> hashMap) {
        String string2 = hF;
        synchronized (hF) {
            Iterator iterator = new ArrayList(this.hH).iterator();
            do {
                if (!iterator.hasNext()) {
                    this.hH.clear();
                    // ** MonitorExit[var4_2] (shouldn't be in output)
                    return;
                }
                ((a)iterator.next()).b(hashMap);
            } while (true);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void a(Context context, a a2) {
        p p2 = this;
        synchronized (p2) {
            if (this.hH == null) {
                this.hH = new ArrayList();
            }
            if (this.state == 2) {
                if (a2 != null) {
                    a2.b(this.hG);
                    return;
                }
            } else {
                if (this.state == 0) {
                    this.state = 1;
                    String string2 = this.getUrl();
                    if (context != null) {
                        this.q("pck", context.getPackageName());
                    }
                    this.q("vid", f.bg());
                    new StringBuilder("start loading config from ").append(string2);
                    b b2 = new b();
                    Executor executor = AsyncTask.THREAD_POOL_EXECUTOR;
                    Object[] arrobject = new Object[]{string2, this.n()};
                    b2.executeOnExecutor(executor, arrobject);
                }
                if (a2 != null) {
                    this.hH.add((Object)a2);
                }
            }
            return;
        }
    }

    public final void a(a a2) {
        p p2 = this;
        synchronized (p2) {
            this.a(null, a2);
            return;
        }
    }

    public void a(HashMap<String, String> hashMap) {
        this.aR = hashMap;
    }

    public final HashMap<String, Object> bl() {
        return this.hG;
    }

    public final String get(String string2) {
        String string3 = this.getValue(string2);
        if (string3 != null) {
            return string3;
        }
        if (this.o().containsKey((Object)string2)) {
            return (String)this.o().get((Object)string2);
        }
        return null;
    }

    public final String get(String string2, String string3) {
        if (this.getValue(string2) == null) {
            return string3;
        }
        return this.getValue(string2);
    }

    protected abstract String getUrl();

    public final String getValue(String string2) {
        HashMap<String, Object> hashMap = this.hG;
        if (hashMap == null) {
            return null;
        }
        if (hashMap.containsKey((Object)string2)) {
            return (String)this.hG.get((Object)string2);
        }
        return null;
    }

    public final boolean isLoaded() {
        return this.state == 2;
    }

    protected abstract HashMap<String, String> n();

    protected abstract HashMap<String, String> o();

    public final void q(String string2, String string3) {
        if (this.aR == null) {
            this.aR = new HashMap();
        }
        this.aR.put((Object)string2, (Object)string3);
    }

    public final void r(String string2, String string3) {
        if (this.aR == null) {
            this.aR = new HashMap();
        }
        if (!this.aR.containsKey((Object)string2)) {
            this.aR.put((Object)string2, (Object)string3);
        }
    }

    public final void s(String string2, String string3) {
        if (this.hG == null) {
            this.hG = new HashMap();
        }
        this.hG.put((Object)string2, (Object)string3);
    }

    public static interface a {
        public void b(HashMap<String, Object> var1);

        public void error(String var1);
    }

    private final class b
    extends AsyncTask<Object, Void, String> {
        private b() {
        }

        protected static /* varargs */ String a(Object ... arrobject) {
            try {
                String string2 = f.a((String)arrobject[0], (HashMap<String, String>)((HashMap)arrobject[1]));
                return string2;
            }
            catch (Throwable throwable) {
                return "error: Internal error";
            }
            catch (IOException iOException) {
                return "error: network problem";
            }
            catch (HttpRetryException httpRetryException) {
                StringBuilder stringBuilder = new StringBuilder("error: ");
                stringBuilder.append(httpRetryException.getReason());
                return stringBuilder.toString();
            }
        }

        protected final void ah(String string2) {
            super.onPostExecute((Object)string2);
            if (string2 == null) {
                p.this.state = 0;
                p.a(p.this, "unknown error");
                return;
            }
            if (string2.startsWith("error:")) {
                p.this.state = 0;
                p.a(p.this, string2.substring(7));
                return;
            }
            try {
                HashMap<String, Object> hashMap = p.af(string2);
                if (p.this.hG == null) {
                    p.this.hG = hashMap;
                } else {
                    p.this.hG.putAll(hashMap);
                }
                p.this.state = 2;
                p.a(p.this, p.this.hG);
                return;
            }
            catch (Throwable throwable) {
                new StringBuilder("error ").append(throwable.getMessage());
                p.this.state = 0;
                p.a(p.this, "parsing error");
                return;
            }
        }

        protected final /* synthetic */ Object doInBackground(Object[] arrobject) {
            return b.a(arrobject);
        }

        protected final /* synthetic */ void onPostExecute(Object object) {
            String string2 = (String)object;
            super.onPostExecute((Object)string2);
            if (string2 == null) {
                p.this.state = 0;
                p.a(p.this, "unknown error");
                return;
            }
            if (string2.startsWith("error:")) {
                p.this.state = 0;
                p.a(p.this, string2.substring(7));
                return;
            }
            try {
                HashMap<String, Object> hashMap = p.af(string2);
                if (p.this.hG == null) {
                    p.this.hG = hashMap;
                } else {
                    p.this.hG.putAll(hashMap);
                }
                p.this.state = 2;
                p.a(p.this, p.this.hG);
                return;
            }
            catch (Throwable throwable) {
                new StringBuilder("error ").append(throwable.getMessage());
                p.this.state = 0;
                p.a(p.this, "parsing error");
                return;
            }
        }
    }

}

