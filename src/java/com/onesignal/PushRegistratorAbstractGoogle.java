/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.io.IOException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Thread
 *  java.lang.Throwable
 */
package com.onesignal;

import android.content.Context;
import com.onesignal.GooglePlayServicesUpgradePrompt;
import com.onesignal.OneSignal;
import com.onesignal.PushRegistrator;
import com.onesignal.PushRegistratorAbstractGoogle;
import java.io.IOException;

abstract class PushRegistratorAbstractGoogle
implements PushRegistrator {
    private static int REGISTRATION_RETRY_BACKOFF_MS = 10000;
    private static int REGISTRATION_RETRY_COUNT = 5;
    private boolean firedCallback;
    private Thread registerThread;
    private PushRegistrator.RegisteredHandler registeredHandler;

    PushRegistratorAbstractGoogle() {
    }

    static /* synthetic */ int access$000() {
        return REGISTRATION_RETRY_COUNT;
    }

    static /* synthetic */ boolean access$100(PushRegistratorAbstractGoogle pushRegistratorAbstractGoogle, String string, int n2) {
        return pushRegistratorAbstractGoogle.attemptRegistration(string, n2);
    }

    static /* synthetic */ int access$200() {
        return REGISTRATION_RETRY_BACKOFF_MS;
    }

    private boolean attemptRegistration(String string, int n2) {
        try {
            String string2 = this.getToken(string);
            OneSignal.LOG_LEVEL lOG_LEVEL = OneSignal.LOG_LEVEL.INFO;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Device registered, push token = ");
            stringBuilder.append(string2);
            OneSignal.Log(lOG_LEVEL, stringBuilder.toString());
            this.registeredHandler.complete(string2, 1);
            return true;
        }
        catch (Throwable throwable) {
            OneSignal.LOG_LEVEL lOG_LEVEL = OneSignal.LOG_LEVEL.ERROR;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unknown error getting ");
            stringBuilder.append(this.getProviderName());
            stringBuilder.append(" Token");
            OneSignal.Log(lOG_LEVEL, stringBuilder.toString(), throwable);
            this.registeredHandler.complete(null, -12);
            return true;
        }
        catch (IOException iOException) {
            if (!"SERVICE_NOT_AVAILABLE".equals((Object)iOException.getMessage())) {
                OneSignal.LOG_LEVEL lOG_LEVEL = OneSignal.LOG_LEVEL.ERROR;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Error Getting ");
                stringBuilder.append(this.getProviderName());
                stringBuilder.append(" Token");
                OneSignal.Log(lOG_LEVEL, stringBuilder.toString(), iOException);
                if (!this.firedCallback) {
                    this.registeredHandler.complete(null, -11);
                }
                return true;
            }
            if (n2 >= REGISTRATION_RETRY_COUNT - 1) {
                OneSignal.LOG_LEVEL lOG_LEVEL = OneSignal.LOG_LEVEL.ERROR;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Retry count of ");
                stringBuilder.append(REGISTRATION_RETRY_COUNT);
                stringBuilder.append(" exceed! Could not get a ");
                stringBuilder.append(this.getProviderName());
                stringBuilder.append(" Token.");
                OneSignal.Log(lOG_LEVEL, stringBuilder.toString(), iOException);
            } else {
                OneSignal.LOG_LEVEL lOG_LEVEL = OneSignal.LOG_LEVEL.INFO;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("'Google Play services' returned SERVICE_NOT_AVAILABLE error. Current retry count: ");
                stringBuilder.append(n2);
                OneSignal.Log(lOG_LEVEL, stringBuilder.toString(), iOException);
                if (n2 == 2) {
                    this.registeredHandler.complete(null, -9);
                    this.firedCallback = true;
                    return true;
                }
            }
            return false;
        }
    }

    private void internalRegisterForPush(String string) {
        try {
            if (GooglePlayServicesUpgradePrompt.isGMSInstalledAndEnabled()) {
                this.registerInBackground(string);
                return;
            }
            GooglePlayServicesUpgradePrompt.ShowUpdateGPSDialog();
            OneSignal.Log(OneSignal.LOG_LEVEL.ERROR, "'Google Play services' app not installed or disabled on the device.");
            this.registeredHandler.complete(null, -7);
            return;
        }
        catch (Throwable throwable) {
            OneSignal.LOG_LEVEL lOG_LEVEL = OneSignal.LOG_LEVEL.ERROR;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Could not register with ");
            stringBuilder.append(this.getProviderName());
            stringBuilder.append(" due to an issue with your AndroidManifest.xml or with 'Google Play services'.");
            OneSignal.Log(lOG_LEVEL, stringBuilder.toString(), throwable);
            this.registeredHandler.complete(null, -8);
            return;
        }
    }

    /*
     * Exception decompiling
     */
    private boolean isValidProjectNumber(String var1, PushRegistrator.RegisteredHandler var2) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl9 : ILOAD_3 : trying to set 1 previously set to 0
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

    private void registerInBackground(String string) {
        PushRegistratorAbstractGoogle pushRegistratorAbstractGoogle = this;
        synchronized (pushRegistratorAbstractGoogle) {
            block4 : {
                boolean bl2;
                if (this.registerThread == null || !(bl2 = this.registerThread.isAlive())) break block4;
                return;
            }
            this.registerThread = new Thread(new Runnable(this, string){
                final /* synthetic */ PushRegistratorAbstractGoogle this$0;
                final /* synthetic */ String val$senderId;
                {
                    this.this$0 = pushRegistratorAbstractGoogle;
                    this.val$senderId = string;
                }

                public void run() {
                    int n2 = 0;
                    while (n2 < PushRegistratorAbstractGoogle.access$000()) {
                        if (PushRegistratorAbstractGoogle.access$100(this.this$0, this.val$senderId, n2)) {
                            return;
                        }
                        int n3 = PushRegistratorAbstractGoogle.access$200();
                        com.onesignal.OSUtils.sleep(n3 * ++n2);
                    }
                }
            });
            this.registerThread.start();
            return;
        }
    }

    abstract String getProviderName();

    abstract String getToken(String var1) throws Throwable;

    @Override
    public void registerForPush(Context context, String string, PushRegistrator.RegisteredHandler registeredHandler) {
        this.registeredHandler = registeredHandler;
        if (this.isValidProjectNumber(string, registeredHandler)) {
            this.internalRegisterForPush(string);
        }
    }
}

