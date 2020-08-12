/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.amazon.device.ads.DefaultFileHandlerFactory
 *  com.amazon.device.ads.FileInputHandler
 *  com.amazon.device.ads.FileOutputHandler
 *  com.amazon.device.ads.MobileAdsLogger
 *  java.io.File
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.util.Collections
 *  java.util.HashSet
 *  java.util.Set
 *  org.json.JSONArray
 *  org.json.JSONObject
 */
package com.amazon.device.ads;

import com.amazon.device.ads.AppEvent;
import com.amazon.device.ads.DefaultFileHandlerFactory;
import com.amazon.device.ads.FileHandlerFactory;
import com.amazon.device.ads.FileInputHandler;
import com.amazon.device.ads.FileOutputHandler;
import com.amazon.device.ads.JSONUtils;
import com.amazon.device.ads.MobileAdsInfoStore;
import com.amazon.device.ads.MobileAdsLogger;
import com.amazon.device.ads.MobileAdsLoggerFactory;
import com.amazon.device.ads.RegistrationInfo;
import com.amazon.device.ads.SISRegistration;
import com.amazon.device.ads.ThreadUtils;
import java.io.File;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

class AppEventRegistrationHandler {
    protected static final String APP_EVENTS_FILE = "AppEventsJsonFile";
    protected static final long APP_EVENTS_FILE_MAX_SIZE = 0x100000L;
    protected static final String APP_EVENT_NAME_KEY = "evtName";
    protected static final String APP_EVENT_TIMESTAMP_KEY = "ts";
    protected static final String INSTALL_REFERRER_EVENT_NAME = "INSTALL_REFERRER";
    private static final String LOGTAG = "AppEventRegistrationHandler";
    protected static AppEventRegistrationHandler instance = new AppEventRegistrationHandler(MobileAdsInfoStore.getInstance(), (FileHandlerFactory)new DefaultFileHandlerFactory());
    protected final Object appEventsFileLock;
    protected final Set<String> eventsSent;
    private final FileHandlerFactory fileHandlerFactory;
    private FileInputHandler fileInputHandler;
    private FileOutputHandler fileOutputHandler;
    private final MobileAdsInfoStore infoStore;
    private final MobileAdsLogger logger = new MobileAdsLoggerFactory().createMobileAdsLogger(LOGTAG);
    protected final Set<String> newEventsToSave;

    protected AppEventRegistrationHandler(MobileAdsInfoStore mobileAdsInfoStore, FileHandlerFactory fileHandlerFactory) {
        this.infoStore = mobileAdsInfoStore;
        this.fileHandlerFactory = fileHandlerFactory;
        this.appEventsFileLock = new Object();
        this.newEventsToSave = Collections.synchronizedSet((Set)new HashSet());
        this.eventsSent = Collections.synchronizedSet((Set)new HashSet());
    }

    private boolean createFileInputHandlerIfNeeded() {
        if (this.fileInputHandler == null) {
            File file = this.infoStore.getFilesDir();
            if (file == null) {
                this.logger.e("No files directory has been set.");
                return false;
            }
            this.fileInputHandler = this.fileHandlerFactory.createFileInputHandler(file, APP_EVENTS_FILE);
        }
        FileInputHandler fileInputHandler = this.fileInputHandler;
        boolean bl = false;
        if (fileInputHandler != null) {
            bl = true;
        }
        return bl;
    }

    private boolean createFileOutputHandlerIfNeeded() {
        if (this.fileOutputHandler == null) {
            File file = this.infoStore.getFilesDir();
            if (file == null) {
                this.logger.e("No files directory has been set.");
                return false;
            }
            this.fileOutputHandler = this.fileHandlerFactory.createFileOutputHandler(file, APP_EVENTS_FILE);
        }
        FileOutputHandler fileOutputHandler = this.fileOutputHandler;
        boolean bl = false;
        if (fileOutputHandler != null) {
            bl = true;
        }
        return bl;
    }

    public static AppEventRegistrationHandler getInstance() {
        return instance;
    }

    public void addEventToAppEventsCacheFile(final AppEvent appEvent) {
        ThreadUtils.scheduleRunnable(new Runnable(){

            public void run() {
                AppEventRegistrationHandler.this.appendAppEventToFile(appEvent);
                if (appEvent.getEventName().equals((Object)AppEventRegistrationHandler.INSTALL_REFERRER_EVENT_NAME) && AppEventRegistrationHandler.this.infoStore.getRegistrationInfo().isRegisteredWithSIS()) {
                    AppEventRegistrationHandler.this.infoStore.getSISRegistration().registerEvents();
                }
            }
        });
    }

    /*
     * Exception decompiling
     */
    protected void appendAppEventToFile(AppEvent var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl144 : ALOAD_0 : trying to set 1 previously set to 0
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
    public JSONArray getAppEventsJSONArray() {
        Object object;
        if (!this.createFileInputHandlerIfNeeded()) {
            this.logger.e("Error creating file input handler.");
            return null;
        }
        Object object2 = object = this.appEventsFileLock;
        synchronized (object2) {
            if (!this.fileInputHandler.doesFileExist()) {
                return null;
            }
            if (!this.fileInputHandler.open()) {
                this.logger.e("App Events File could not be opened.");
                return null;
            }
            JSONArray jSONArray = new JSONArray();
            do {
                String string;
                if ((string = this.fileInputHandler.readLine()) == null) {
                    this.fileInputHandler.close();
                    if (jSONArray.length() <= 0) return null;
                    return jSONArray;
                }
                JSONObject jSONObject = JSONUtils.getJSONObjectFromString(string);
                if (jSONObject == null) {
                    this.onAppEventsRegistered();
                    this.fileInputHandler.close();
                    return null;
                }
                jSONArray.put((Object)jSONObject);
                this.eventsSent.add((Object)jSONObject.toString());
            } while (true);
        }
    }

    /*
     * Exception decompiling
     */
    public void onAppEventsRegistered() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl80 : ALOAD_0 : trying to set 1 previously set to 0
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

}

