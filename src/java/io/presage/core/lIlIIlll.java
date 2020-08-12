/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.Context
 *  io.presage.core.lIlIlIIl
 *  java.lang.Class
 *  java.lang.Object
 */
package io.presage.core;

import android.content.ComponentName;
import android.content.Context;
import io.presage.core.lIlIlIIl;
import io.presage.core.receiver.NextAlarmClockChangedReceiver;

public final class lIlIIlll
extends lIlIlIIl {
    public lIlIIlll(Context context, boolean bl2, Object[] arrobject) {
        super(context, bl2, arrobject);
    }

    public final int IIIIIIII() {
        return 3;
    }

    protected final ComponentName IIIIIIll() {
        return new ComponentName(this.IIIIIIIl, NextAlarmClockChangedReceiver.class);
    }
}

