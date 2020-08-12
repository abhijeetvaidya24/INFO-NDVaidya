/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 */
package com.ironsource.mediationsdk.logger;

public abstract class IronSourceLogger {
    int mDebugLevel;
    private String mLoggerName;

    IronSourceLogger(String string) {
        this.mLoggerName = string;
        this.mDebugLevel = 0;
    }

    IronSourceLogger(String string, int n2) {
        this.mLoggerName = string;
        this.mDebugLevel = n2;
    }

    public boolean equals(Object object) {
        boolean bl2 = false;
        if (object != null) {
            boolean bl3 = object instanceof IronSourceLogger;
            bl2 = false;
            if (bl3) {
                IronSourceLogger ironSourceLogger = (IronSourceLogger)object;
                String string = this.mLoggerName;
                bl2 = false;
                if (string != null) {
                    boolean bl4 = string.equals((Object)ironSourceLogger.mLoggerName);
                    bl2 = false;
                    if (bl4) {
                        bl2 = true;
                    }
                }
            }
        }
        return bl2;
    }

    int getDebugLevel() {
        return this.mDebugLevel;
    }

    String getLoggerName() {
        return this.mLoggerName;
    }

    public abstract void log(IronSourceTag var1, String var2, int var3);

    public abstract void logException(IronSourceTag var1, String var2, Throwable var3);

    public void setDebugLevel(int n2) {
        this.mDebugLevel = n2;
    }

    public static final class IronSourceTag
    extends Enum<IronSourceTag> {
        private static final /* synthetic */ IronSourceTag[] $VALUES;
        public static final /* enum */ IronSourceTag ADAPTER_API;
        public static final /* enum */ IronSourceTag ADAPTER_CALLBACK;
        public static final /* enum */ IronSourceTag API;
        public static final /* enum */ IronSourceTag CALLBACK;
        public static final /* enum */ IronSourceTag EVENT;
        public static final /* enum */ IronSourceTag INTERNAL;
        public static final /* enum */ IronSourceTag NATIVE;
        public static final /* enum */ IronSourceTag NETWORK;

        static {
            API = new IronSourceTag();
            ADAPTER_API = new IronSourceTag();
            CALLBACK = new IronSourceTag();
            ADAPTER_CALLBACK = new IronSourceTag();
            NETWORK = new IronSourceTag();
            INTERNAL = new IronSourceTag();
            NATIVE = new IronSourceTag();
            EVENT = new IronSourceTag();
            IronSourceTag[] arrironSourceTag = new IronSourceTag[]{API, ADAPTER_API, CALLBACK, ADAPTER_CALLBACK, NETWORK, INTERNAL, NATIVE, EVENT};
            $VALUES = arrironSourceTag;
        }

        public static IronSourceTag valueOf(String string) {
            return (IronSourceTag)Enum.valueOf(IronSourceTag.class, (String)string);
        }

        public static IronSourceTag[] values() {
            return (IronSourceTag[])$VALUES.clone();
        }
    }

}

