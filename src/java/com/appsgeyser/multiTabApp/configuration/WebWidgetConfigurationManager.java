/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.io.IOException
 *  java.lang.ClassNotFoundException
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.Thread
 */
package com.appsgeyser.multiTabApp.configuration;

import android.content.Context;
import com.appsgeyser.multiTabApp.Factory;
import com.appsgeyser.multiTabApp.configuration.ObjectSerializer;
import com.appsgeyser.multiTabApp.configuration.WebWidgetConfiguration;
import com.appsgeyser.multiTabApp.configuration.XMLConfigurationParser;
import com.appsgeyser.multiTabApp.controllers.WidgetsController;
import java.io.IOException;

public class WebWidgetConfigurationManager {
    private static WebWidgetConfigurationManager instance;
    private WebWidgetConfiguration config;
    private XMLConfigurationParser parser;

    private WebWidgetConfigurationManager(Context context) {
        this.parser = new XMLConfigurationParser(context);
    }

    public static WebWidgetConfigurationManager getInstance(Context context) {
        if (instance == null) {
            instance = new WebWidgetConfigurationManager(context);
        }
        return instance;
    }

    private WebWidgetConfiguration loadFromCurrentConfig(Context context) {
        try {
            WebWidgetConfiguration webWidgetConfiguration = this.parser.parse();
            this.saveConfiguration(webWidgetConfiguration, Factory.getInstance().getWidgetsController(), context);
            return webWidgetConfiguration;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }

    /*
     * Exception decompiling
     */
    public WebWidgetConfiguration loadConfiguration(Context var1) throws Exception {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl31 : ALOAD_0 : trying to set 1 previously set to 0
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

    public WebWidgetConfiguration loadSerializedConfiguration(Context context) throws IOException, ClassNotFoundException {
        ObjectSerializer objectSerializer = new ObjectSerializer(context);
        WidgetsController widgetsController = (WidgetsController)new ObjectSerializer(context).loadSerializedObject("widgetsController");
        Factory.getInstance().setWidgetsController(widgetsController);
        return (WebWidgetConfiguration)objectSerializer.loadSerializedObject("webWidgetConfiguration");
    }

    public void saveConfiguration(final WebWidgetConfiguration webWidgetConfiguration, final WidgetsController widgetsController, final Context context) {
        new Thread(new Runnable(){

            public void run() {
                try {
                    ObjectSerializer<WebWidgetConfiguration> objectSerializer = new ObjectSerializer<WebWidgetConfiguration>(context);
                    ObjectSerializer<WidgetsController> objectSerializer2 = new ObjectSerializer<WidgetsController>(context);
                    objectSerializer.serializeAndSaveObject(webWidgetConfiguration, "webWidgetConfiguration");
                    objectSerializer2.serializeAndSaveObject(widgetsController, "widgetsController");
                    return;
                }
                catch (IOException iOException) {
                    iOException.printStackTrace();
                    return;
                }
            }
        }).run();
    }

}

