/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Boolean
 *  java.lang.Enum
 *  java.lang.Iterable
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 */
package com.amazon.device.ads;

import com.amazon.device.ads.DebugProperties;
import com.amazon.device.ads.Logger;
import com.amazon.device.ads.MobileAdsLogger;
import com.amazon.device.ads.Settings;
import com.amazon.device.ads.Version;
import java.util.ArrayList;

class MobileAdsLogger
implements Logger {
    private static final String DEFAULT_LOGTAG_PREFIX = "AmazonMobileAds";
    private static final int DEFAULT_MAX_LENGTH = 1000;
    static final String LOGGING_ENABLED = "loggingEnabled";
    private final DebugProperties debugProperties;
    private final Logger logger;
    private int maxLength = 1000;
    private final Settings settings;

    public MobileAdsLogger(Logger logger) {
        this(logger, DebugProperties.getInstance(), Settings.getInstance());
    }

    MobileAdsLogger(Logger logger, DebugProperties debugProperties, Settings settings) {
        this.logger = logger.withLogTag(DEFAULT_LOGTAG_PREFIX);
        this.debugProperties = debugProperties;
        this.settings = settings;
    }

    private /* varargs */ void doLog(boolean bl, Level level, String string, Object ... arrobject) {
        if (this.canLog() || bl) {
            for (String string2 : this.formatAndSplit(string, arrobject)) {
                int n2 = 1.$SwitchMap$com$amazon$device$ads$MobileAdsLogger$Level[level.ordinal()];
                if (n2 != 1) {
                    if (n2 != 2) {
                        if (n2 != 3) {
                            if (n2 != 4) {
                                if (n2 != 5) continue;
                                this.logger.w(string2);
                                continue;
                            }
                            this.logger.v(string2);
                            continue;
                        }
                        this.logger.i(string2);
                        continue;
                    }
                    this.logger.e(string2);
                    continue;
                }
                this.logger.d(string2);
            }
        }
    }

    private /* varargs */ Iterable<String> formatAndSplit(String string, Object ... arrobject) {
        if (arrobject != null && arrobject.length > 0) {
            string = String.format((String)string, (Object[])arrobject);
        }
        return this.split(string, this.maxLength);
    }

    private Iterable<String> split(String string, int n2) {
        ArrayList arrayList = new ArrayList();
        if (string != null) {
            if (string.length() == 0) {
                return arrayList;
            }
            int n3 = 0;
            while (n3 < string.length()) {
                int n4 = string.length();
                int n5 = n3 + n2;
                arrayList.add((Object)string.substring(n3, Math.min((int)n4, (int)n5)));
                n3 = n5;
            }
        }
        return arrayList;
    }

    public boolean canLog() {
        if (this.logger != null) {
            DebugProperties debugProperties = this.debugProperties;
            if (debugProperties == null) {
                return false;
            }
            return debugProperties.getDebugPropertyAsBoolean("debug.logging", this.settings.getBoolean(LOGGING_ENABLED, false));
        }
        return false;
    }

    @Override
    public void d(String string) {
        this.d(string, null);
    }

    public /* varargs */ void d(String string, Object ... arrobject) {
        this.log(Level.DEBUG, string, arrobject);
    }

    @Override
    public void e(String string) {
        this.e(string, null);
    }

    public /* varargs */ void e(String string, Object ... arrobject) {
        this.log(Level.ERROR, string, arrobject);
    }

    public void enableLogging(boolean bl) {
        this.settings.putTransientBoolean(LOGGING_ENABLED, bl);
    }

    public final void enableLoggingWithSetterNotification(boolean bl) {
        if (!bl) {
            this.logSetterNotification("Debug logging", bl);
        }
        this.enableLogging(bl);
        if (bl) {
            this.logSetterNotification("Debug logging", bl);
            Object[] arrobject = new Object[]{Version.getRawSDKVersion()};
            this.d("Amazon Mobile Ads API Version: %s", arrobject);
        }
    }

    public /* varargs */ void forceLog(Level level, String string, Object ... arrobject) {
        this.doLog(true, level, string, arrobject);
    }

    @Override
    public void i(String string) {
        this.i(string, null);
    }

    public /* varargs */ void i(String string, Object ... arrobject) {
        this.log(Level.INFO, string, arrobject);
    }

    public /* varargs */ void log(Level level, String string, Object ... arrobject) {
        this.doLog(false, level, string, arrobject);
    }

    public void logSetterNotification(String string, Object object) {
        if (!this.canLog()) {
            return;
        }
        if (object instanceof Boolean) {
            Object[] arrobject = new Object[2];
            arrobject[0] = string;
            String string2 = (Boolean)object != false ? "enabled" : "disabled";
            arrobject[1] = string2;
            this.d("%s has been %s.", arrobject);
            return;
        }
        Object[] arrobject = new Object[]{string, String.valueOf((Object)object)};
        this.d("%s has been set: %s", arrobject);
    }

    @Override
    public void v(String string) {
        this.v(string, null);
    }

    public /* varargs */ void v(String string, Object ... arrobject) {
        this.log(Level.VERBOSE, string, arrobject);
    }

    @Override
    public void w(String string) {
        this.w(string, null);
    }

    public /* varargs */ void w(String string, Object ... arrobject) {
        this.log(Level.WARN, string, arrobject);
    }

    @Override
    public MobileAdsLogger withLogTag(String string) {
        Logger logger = this.logger;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("AmazonMobileAds ");
        stringBuilder.append(string);
        logger.withLogTag(stringBuilder.toString());
        return this;
    }

    public MobileAdsLogger withMaxLength(int n2) {
        this.maxLength = n2;
        return this;
    }

}

