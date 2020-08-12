/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  org.altbeacon.beacon.logging.EmptyLogger
 *  org.altbeacon.beacon.logging.InfoAndroidLogger
 *  org.altbeacon.beacon.logging.VerboseAndroidLogger
 *  org.altbeacon.beacon.logging.WarningAndroidLogger
 */
package org.altbeacon.beacon.logging;

import org.altbeacon.beacon.logging.EmptyLogger;
import org.altbeacon.beacon.logging.InfoAndroidLogger;
import org.altbeacon.beacon.logging.Logger;
import org.altbeacon.beacon.logging.VerboseAndroidLogger;
import org.altbeacon.beacon.logging.WarningAndroidLogger;

public final class Loggers {
    private static final Logger EMPTY_LOGGER = new EmptyLogger();
    private static final Logger INFO_ANDROID_LOGGER;
    private static final Logger VERBOSE_ANDROID_LOGGER;
    private static final Logger WARNING_ANDROID_LOGGER;

    static {
        VERBOSE_ANDROID_LOGGER = new VerboseAndroidLogger();
        INFO_ANDROID_LOGGER = new InfoAndroidLogger();
        WARNING_ANDROID_LOGGER = new WarningAndroidLogger();
    }

    public static Logger infoLogger() {
        return INFO_ANDROID_LOGGER;
    }
}

