/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  org.altbeacon.beacon.logging.AbstractAndroidLogger
 */
package org.altbeacon.beacon.logging;

import android.util.Log;
import org.altbeacon.beacon.logging.AbstractAndroidLogger;

final class VerboseAndroidLogger
extends AbstractAndroidLogger {
    VerboseAndroidLogger() {
    }

    public /* varargs */ void d(String string, String string2, Object ... arrobject) {
        Log.d((String)string, (String)this.formatString(string2, arrobject));
    }

    public /* varargs */ void e(String string, String string2, Object ... arrobject) {
        Log.e((String)string, (String)this.formatString(string2, arrobject));
    }

    public /* varargs */ void e(Throwable throwable, String string, String string2, Object ... arrobject) {
        Log.e((String)string, (String)this.formatString(string2, arrobject), (Throwable)throwable);
    }

    public /* varargs */ void i(String string, String string2, Object ... arrobject) {
        Log.i((String)string, (String)this.formatString(string2, arrobject));
    }

    public /* varargs */ void w(String string, String string2, Object ... arrobject) {
        Log.w((String)string, (String)this.formatString(string2, arrobject));
    }

    public /* varargs */ void w(Throwable throwable, String string, String string2, Object ... arrobject) {
        Log.w((String)string, (String)this.formatString(string2, arrobject), (Throwable)throwable);
    }
}

