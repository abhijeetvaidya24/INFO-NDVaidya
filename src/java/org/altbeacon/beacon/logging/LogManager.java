/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 */
package org.altbeacon.beacon.logging;

import org.altbeacon.beacon.logging.Logger;
import org.altbeacon.beacon.logging.Loggers;

public final class LogManager {
    private static Logger sLogger = Loggers.infoLogger();
    private static boolean sVerboseLoggingEnabled = false;

    public static /* varargs */ void d(String string, String string2, Object ... arrobject) {
        sLogger.d(string, string2, arrobject);
    }

    public static /* varargs */ void e(String string, String string2, Object ... arrobject) {
        sLogger.e(string, string2, arrobject);
    }

    public static /* varargs */ void e(Throwable throwable, String string, String string2, Object ... arrobject) {
        sLogger.e(throwable, string, string2, arrobject);
    }

    public static /* varargs */ void i(String string, String string2, Object ... arrobject) {
        sLogger.i(string, string2, arrobject);
    }

    public static boolean isVerboseLoggingEnabled() {
        return sVerboseLoggingEnabled;
    }

    public static /* varargs */ void w(String string, String string2, Object ... arrobject) {
        sLogger.w(string, string2, arrobject);
    }

    public static /* varargs */ void w(Throwable throwable, String string, String string2, Object ... arrobject) {
        sLogger.w(throwable, string, string2, arrobject);
    }
}

