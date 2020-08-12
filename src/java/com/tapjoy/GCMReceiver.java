/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Bundle
 *  com.tapjoy.internal.ge
 *  java.lang.String
 */
package com.tapjoy;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tapjoy.internal.ge;

public class GCMReceiver
extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        boolean bl = ge.b((Context)context).a(intent);
        if (this.isOrderedBroadcast()) {
            this.setResult(-1, null, null);
            if (bl) {
                this.abortBroadcast();
            }
        }
    }
}

