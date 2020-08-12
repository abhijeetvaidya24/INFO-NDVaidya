/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.Iterator
 */
package com.ironsource.mediationsdk.logger;

import com.ironsource.mediationsdk.logger.ConsoleLogger;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.LogListener;
import java.util.ArrayList;
import java.util.Iterator;

public class IronSourceLoggerManager
extends IronSourceLogger
implements LogListener {
    private static IronSourceLoggerManager mInstance;
    private boolean mIsDebugEnabled = false;
    private ArrayList<IronSourceLogger> mLoggers = new ArrayList();

    private IronSourceLoggerManager(String string) {
        super(string);
        this.initSubLoggers();
    }

    private IronSourceLogger findLoggerByName(String string) {
        for (IronSourceLogger ironSourceLogger : this.mLoggers) {
            if (!ironSourceLogger.getLoggerName().equals((Object)string)) continue;
            return ironSourceLogger;
        }
        return null;
    }

    public static IronSourceLoggerManager getLogger() {
        Class<IronSourceLoggerManager> class_ = IronSourceLoggerManager.class;
        synchronized (IronSourceLoggerManager.class) {
            if (mInstance == null) {
                mInstance = new IronSourceLoggerManager(IronSourceLoggerManager.class.getSimpleName());
            }
            IronSourceLoggerManager ironSourceLoggerManager = mInstance;
            // ** MonitorExit[var2] (shouldn't be in output)
            return ironSourceLoggerManager;
        }
    }

    public static IronSourceLoggerManager getLogger(int n2) {
        Class<IronSourceLoggerManager> class_ = IronSourceLoggerManager.class;
        synchronized (IronSourceLoggerManager.class) {
            if (mInstance == null) {
                mInstance = new IronSourceLoggerManager(IronSourceLoggerManager.class.getSimpleName());
            } else {
                IronSourceLoggerManager.mInstance.mDebugLevel = n2;
            }
            IronSourceLoggerManager ironSourceLoggerManager = mInstance;
            // ** MonitorExit[var3_1] (shouldn't be in output)
            return ironSourceLoggerManager;
        }
    }

    private void initSubLoggers() {
        this.mLoggers.add((Object)new ConsoleLogger(1));
    }

    public void addLogger(IronSourceLogger ironSourceLogger) {
        this.mLoggers.add((Object)ironSourceLogger);
    }

    public boolean isDebugEnabled() {
        return this.mIsDebugEnabled;
    }

    @Override
    public void log(IronSourceLogger.IronSourceTag ironSourceTag, String string, int n2) {
        IronSourceLoggerManager ironSourceLoggerManager = this;
        synchronized (ironSourceLoggerManager) {
            block5 : {
                int n3 = this.mDebugLevel;
                if (n2 >= n3) break block5;
                return;
            }
            try {
                for (IronSourceLogger ironSourceLogger : this.mLoggers) {
                    if (ironSourceLogger.getDebugLevel() > n2) continue;
                    ironSourceLogger.log(ironSourceTag, string, n2);
                }
                return;
            }
            catch (Throwable throwable) {
                throw throwable;
            }
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    @Override
    public void logException(IronSourceLogger.IronSourceTag var1_1, String var2_2, Throwable var3_3) {
        var7_4 = this;
        // MONITORENTER : var7_4
        if (var3_3 != null) ** GOTO lbl10
        var6_5 = this.mLoggers.iterator();
        while (var6_5.hasNext()) {
            ((IronSourceLogger)var6_5.next()).log(var1_1, var2_2, 3);
        }
        return;
lbl10: // 1 sources:
        var5_6 = this.mLoggers.iterator();
        while (var5_6.hasNext()) {
            ((IronSourceLogger)var5_6.next()).logException(var1_1, var2_2, var3_3);
        }
        return;
    }

    @Override
    public void onLog(IronSourceLogger.IronSourceTag ironSourceTag, String string, int n2) {
        IronSourceLoggerManager ironSourceLoggerManager = this;
        synchronized (ironSourceLoggerManager) {
            this.log(ironSourceTag, string, n2);
            return;
        }
    }

    public void setAdaptersDebug(boolean bl) {
        this.mIsDebugEnabled = bl;
    }

    public void setLoggerDebugLevel(String string, int n2) {
        if (string == null) {
            return;
        }
        IronSourceLogger ironSourceLogger = this.findLoggerByName(string);
        if (ironSourceLogger != null) {
            if (n2 >= 0 && n2 <= 3) {
                IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.NATIVE;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("setLoggerDebugLevel(loggerName:");
                stringBuilder.append(string);
                stringBuilder.append(" ,debugLevel:");
                stringBuilder.append(n2);
                stringBuilder.append(")");
                this.log(ironSourceTag, stringBuilder.toString(), 0);
                ironSourceLogger.setDebugLevel(n2);
                return;
            }
            this.mLoggers.remove((Object)ironSourceLogger);
            return;
        }
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.NATIVE;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Failed to find logger:setLoggerDebugLevel(loggerName:");
        stringBuilder.append(string);
        stringBuilder.append(" ,debugLevel:");
        stringBuilder.append(n2);
        stringBuilder.append(")");
        this.log(ironSourceTag, stringBuilder.toString(), 0);
    }
}

