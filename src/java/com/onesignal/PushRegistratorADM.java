/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.Thread
 */
package com.onesignal;

import android.content.Context;
import com.onesignal.PushRegistrator;
import com.onesignal.PushRegistratorADM;

public class PushRegistratorADM
implements PushRegistrator {
    private static boolean callbackSuccessful;
    private static PushRegistrator.RegisteredHandler registeredCallback;

    static /* synthetic */ boolean access$000() {
        return callbackSuccessful;
    }

    public static void fireCallback(String string) {
        PushRegistrator.RegisteredHandler registeredHandler = registeredCallback;
        if (registeredHandler == null) {
            return;
        }
        callbackSuccessful = true;
        registeredHandler.complete(string, 1);
    }

    @Override
    public void registerForPush(Context context, String string, PushRegistrator.RegisteredHandler registeredHandler) {
        registeredCallback = registeredHandler;
        new Thread(new Runnable(this, context, registeredHandler){
            final /* synthetic */ PushRegistratorADM this$0;
            final /* synthetic */ PushRegistrator.RegisteredHandler val$callback;
            final /* synthetic */ Context val$context;
            {
                this.this$0 = pushRegistratorADM;
                this.val$context = context;
                this.val$callback = registeredHandler;
            }

            public void run() {
                com.amazon.device.messaging.ADM aDM = new com.amazon.device.messaging.ADM(this.val$context);
                String string = aDM.getRegistrationId();
                if (string == null) {
                    aDM.startRegister();
                } else {
                    com.onesignal.OneSignal$LOG_LEVEL lOG_LEVEL = com.onesignal.OneSignal$LOG_LEVEL.DEBUG;
                    java.lang.StringBuilder stringBuilder = new java.lang.StringBuilder();
                    stringBuilder.append("ADM Already registered with ID:");
                    stringBuilder.append(string);
                    com.onesignal.OneSignal.Log(lOG_LEVEL, stringBuilder.toString());
                    this.val$callback.complete(string, 1);
                }
                try {
                    Thread.sleep((long)30000L);
                }
                catch (java.lang.InterruptedException interruptedException) {}
                if (!PushRegistratorADM.access$000()) {
                    com.onesignal.OneSignal.Log(com.onesignal.OneSignal$LOG_LEVEL.ERROR, "com.onesignal.ADMMessageHandler timed out, please check that your have the receiver, service, and your package name matches(NOTE: Case Sensitive) per the OneSignal instructions.");
                    PushRegistratorADM.fireCallback(null);
                }
            }
        }).start();
    }
}

