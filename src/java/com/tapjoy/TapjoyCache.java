/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  android.os.Environment
 *  android.text.TextUtils
 *  com.tapjoy.TapjoyLog
 *  com.tapjoy.TapjoyUtil
 *  java.io.File
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Iterable
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Thread
 *  java.net.MalformedURLException
 *  java.net.URL
 *  java.util.ArrayList
 *  java.util.Iterator
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 *  java.util.Vector
 *  java.util.concurrent.Callable
 *  java.util.concurrent.ExecutorService
 *  java.util.concurrent.Executors
 *  java.util.concurrent.Future
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.tapjoy;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import android.text.TextUtils;
import com.tapjoy.TJCacheListener;
import com.tapjoy.TapjoyCacheMap;
import com.tapjoy.TapjoyCachedAssetData;
import com.tapjoy.TapjoyLog;
import com.tapjoy.TapjoyUtil;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TapjoyCache {
    public static final String CACHE_DIRECTORY_NAME = "Tapjoy/Cache/";
    public static final int CACHE_LIMIT = -1;
    private static TapjoyCache a;
    public static boolean unit_test_mode;
    private Context b;
    private TapjoyCacheMap c;
    private Vector d;
    private ExecutorService e;
    private File f;

    public TapjoyCache(Context context) {
        if (a == null || unit_test_mode) {
            a = this;
            this.b = context;
            this.c = new TapjoyCacheMap(context, -1);
            this.d = new Vector();
            this.e = Executors.newFixedThreadPool((int)5);
            if (Environment.getExternalStorageDirectory() != null) {
                TapjoyUtil.deleteFileOrDirectory((File)new File(Environment.getExternalStorageDirectory(), "tapjoy"));
                TapjoyUtil.deleteFileOrDirectory((File)new File(Environment.getExternalStorageDirectory(), "tjcache/tmp/"));
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append((Object)this.b.getFilesDir());
            stringBuilder.append("/Tapjoy/Cache/");
            this.f = new File(stringBuilder.toString());
            if (!this.f.exists()) {
                if (this.f.mkdirs()) {
                    StringBuilder stringBuilder2 = new StringBuilder("Created directory at: ");
                    stringBuilder2.append(this.f.getPath());
                    TapjoyLog.d((String)"TapjoyCache", (String)stringBuilder2.toString());
                } else {
                    TapjoyLog.e((String)"TapjoyCache", (String)"Error initalizing cache");
                    a = null;
                }
            }
            this.a();
        }
    }

    private void a() {
        SharedPreferences sharedPreferences = this.b.getSharedPreferences("tapjoyCacheData", 0);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        for (Map.Entry entry : sharedPreferences.getAll().entrySet()) {
            File file = new File((String)entry.getKey());
            if (file.exists() && file.isFile()) {
                TapjoyCachedAssetData tapjoyCachedAssetData = TapjoyCachedAssetData.fromRawJSONString(entry.getValue().toString());
                if (tapjoyCachedAssetData != null) {
                    StringBuilder stringBuilder = new StringBuilder("Loaded Asset: ");
                    stringBuilder.append(tapjoyCachedAssetData.getAssetURL());
                    TapjoyLog.d((String)"TapjoyCache", (String)stringBuilder.toString());
                    String string = TapjoyCache.b(tapjoyCachedAssetData.getAssetURL());
                    if (string != null && !"".equals((Object)string) && string.length() > 0) {
                        if (tapjoyCachedAssetData.getTimeOfDeathInSeconds() < System.currentTimeMillis() / 1000L) {
                            StringBuilder stringBuilder2 = new StringBuilder("Asset expired, removing from cache: ");
                            stringBuilder2.append(tapjoyCachedAssetData.getAssetURL());
                            TapjoyLog.d((String)"TapjoyCache", (String)stringBuilder2.toString());
                            if (tapjoyCachedAssetData.getLocalFilePath() == null || tapjoyCachedAssetData.getLocalFilePath().length() <= 0) continue;
                            TapjoyUtil.deleteFileOrDirectory((File)new File(tapjoyCachedAssetData.getLocalFilePath()));
                            continue;
                        }
                        this.c.put(string, tapjoyCachedAssetData);
                        continue;
                    }
                    TapjoyLog.e((String)"TapjoyCache", (String)"Removing asset because deserialization failed.");
                    editor.remove((String)entry.getKey()).commit();
                    continue;
                }
                TapjoyLog.e((String)"TapjoyCache", (String)"Removing asset because deserialization failed.");
                editor.remove((String)entry.getKey()).commit();
                continue;
            }
            StringBuilder stringBuilder = new StringBuilder("Removing reference to missing asset: ");
            stringBuilder.append((String)entry.getKey());
            TapjoyLog.d((String)"TapjoyCache", (String)stringBuilder.toString());
            editor.remove((String)entry.getKey()).commit();
        }
    }

    static /* synthetic */ TapjoyCacheMap b(TapjoyCache tapjoyCache) {
        return tapjoyCache.c;
    }

    private static String b(String string) {
        if (string.startsWith("//")) {
            StringBuilder stringBuilder = new StringBuilder("http:");
            stringBuilder.append(string);
            string = stringBuilder.toString();
        }
        try {
            String string2 = new URL(string).getFile();
            return string2;
        }
        catch (MalformedURLException malformedURLException) {
            StringBuilder stringBuilder = new StringBuilder("Invalid URL ");
            stringBuilder.append(string);
            TapjoyLog.e((String)"TapjoyCache", (String)stringBuilder.toString());
            return "";
        }
    }

    static /* synthetic */ File c(TapjoyCache tapjoyCache) {
        return tapjoyCache.f;
    }

    public static TapjoyCache getInstance() {
        return a;
    }

    public static void setInstance(TapjoyCache tapjoyCache) {
        a = tapjoyCache;
    }

    public Future cacheAssetFromJSONObject(JSONObject jSONObject) {
        try {
            String string = jSONObject.getString("url");
            Long.valueOf((long)86400L);
            Future future = this.cacheAssetFromURL(string, jSONObject.optString("offerId"), jSONObject.optLong("timeToLive"));
            return future;
        }
        catch (JSONException jSONException) {
            TapjoyLog.e((String)"TapjoyCache", (String)"Required parameters to cache an asset from JSON is not present");
            return null;
        }
    }

    public Future cacheAssetFromURL(String string, String string2, long l2) {
        URL uRL;
        try {
            uRL = new URL(string);
        }
        catch (MalformedURLException malformedURLException) {
            TapjoyLog.d((String)"TapjoyCache", (String)"Invalid cache assetURL");
            return null;
        }
        String string3 = TapjoyCache.b(string);
        if (this.d.contains((Object)string3)) {
            StringBuilder stringBuilder = new StringBuilder("URL is already in the process of being cached: ");
            stringBuilder.append(string);
            TapjoyLog.d((String)"TapjoyCache", (String)stringBuilder.toString());
            return null;
        }
        return this.startCachingThread(uRL, string2, l2);
    }

    public void cacheAssetGroup(final JSONArray jSONArray, final TJCacheListener tJCacheListener) {
        if (jSONArray != null && jSONArray.length() > 0) {
            new Thread(){

                /*
                 * Exception decompiling
                 */
                public final void run() {
                    // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
                    // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl47 : IINC : trying to set 1 previously set to 0
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
            }.start();
            return;
        }
        if (tJCacheListener != null) {
            tJCacheListener.onCachingComplete(1);
        }
    }

    public String cachedAssetsToJSON() {
        Iterator iterator = this.c.entrySet().iterator();
        JSONObject jSONObject = new JSONObject();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry)iterator.next();
            try {
                jSONObject.put(((String)entry.getKey()).toString(), (Object)((TapjoyCachedAssetData)entry.getValue()).toRawJSONString());
            }
            catch (JSONException jSONException) {
                jSONException.printStackTrace();
            }
        }
        return jSONObject.toString();
    }

    public void clearTapjoyCache() {
        TapjoyLog.d((String)"TapjoyCache", (String)"Cleaning Tapjoy cache!");
        TapjoyUtil.deleteFileOrDirectory((File)this.f);
        if (this.f.mkdirs()) {
            StringBuilder stringBuilder = new StringBuilder("Created new cache directory at: ");
            stringBuilder.append(this.f.getPath());
            TapjoyLog.d((String)"TapjoyCache", (String)stringBuilder.toString());
        }
        this.c = new TapjoyCacheMap(this.b, -1);
    }

    public TapjoyCacheMap getCachedData() {
        return this.c;
    }

    public TapjoyCachedAssetData getCachedDataForURL(String string) {
        String string2 = TapjoyCache.b(string);
        if (string2 != "") {
            return (TapjoyCachedAssetData)this.c.get((Object)string2);
        }
        return null;
    }

    public String getCachedOfferIDs() {
        ArrayList arrayList = new ArrayList();
        TapjoyCacheMap tapjoyCacheMap = this.c;
        if (tapjoyCacheMap != null) {
            Iterator iterator = tapjoyCacheMap.entrySet().iterator();
            while (iterator.hasNext()) {
                String string = ((TapjoyCachedAssetData)((Map.Entry)iterator.next()).getValue()).getOfferId();
                if (string == null || string.length() == 0 || arrayList.contains((Object)string)) continue;
                arrayList.add((Object)string);
            }
            return TextUtils.join((CharSequence)",", (Iterable)arrayList);
        }
        return "";
    }

    public String getPathOfCachedURL(String string) {
        String string2 = TapjoyCache.b(string);
        if (string2 != "" && this.c.containsKey((Object)string2)) {
            TapjoyCachedAssetData tapjoyCachedAssetData = (TapjoyCachedAssetData)this.c.get((Object)string2);
            if (new File(tapjoyCachedAssetData.getLocalFilePath()).exists()) {
                return tapjoyCachedAssetData.getLocalURL();
            }
            TapjoyCache.getInstance().removeAssetFromCache(string);
        }
        return string;
    }

    public boolean isURLCached(String string) {
        return this.c.get((Object)TapjoyCache.b(string)) != null;
    }

    public boolean isURLDownloading(String string) {
        String string2;
        return this.d != null && (string2 = TapjoyCache.b(string)) != "" && this.d.contains((Object)string2);
    }

    public void printCacheInformation() {
        TapjoyLog.d((String)"TapjoyCache", (String)"------------- Cache Data -------------");
        StringBuilder stringBuilder = new StringBuilder("Number of files in cache: ");
        stringBuilder.append(this.c.size());
        TapjoyLog.d((String)"TapjoyCache", (String)stringBuilder.toString());
        StringBuilder stringBuilder2 = new StringBuilder("Cache Size: ");
        stringBuilder2.append(TapjoyUtil.fileOrDirectorySize((File)this.f));
        TapjoyLog.d((String)"TapjoyCache", (String)stringBuilder2.toString());
        TapjoyLog.d((String)"TapjoyCache", (String)"--------------------------------------");
    }

    public boolean removeAssetFromCache(String string) {
        String string2 = TapjoyCache.b(string);
        return string2 != "" && this.c.remove(string2) != null;
    }

    public Future startCachingThread(URL uRL, String string, long l2) {
        if (uRL != null) {
            ExecutorService executorService = this.e;
            CacheAssetThread cacheAssetThread = new CacheAssetThread(uRL, string, l2);
            return executorService.submit((Callable)cacheAssetThread);
        }
        return null;
    }

    public class CacheAssetThread
    implements Callable {
        private URL b;
        private String c;
        private long d;

        public CacheAssetThread(URL uRL, String string, long l2) {
            this.b = uRL;
            this.c = string;
            this.d = l2;
            if (this.d <= 0L) {
                this.d = 86400L;
            }
            TapjoyCache.this.d.add((Object)TapjoyCache.b(this.b.toString()));
        }

        /*
         * Exception decompiling
         */
        public Boolean call() {
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
    }

}

