/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package com.ironsource.mediationsdk.model;

import com.ironsource.mediationsdk.model.ApplicationLogger;
import com.ironsource.mediationsdk.model.ServerSegmetData;

public class ApplicationConfigurations {
    private boolean mIsIntegration;
    private ApplicationLogger mLogger;
    private ServerSegmetData mSegmetData;

    public ApplicationConfigurations() {
        this.mLogger = new ApplicationLogger();
    }

    public ApplicationConfigurations(ApplicationLogger applicationLogger, ServerSegmetData serverSegmetData, boolean bl2) {
        this.mLogger = applicationLogger;
        this.mSegmetData = serverSegmetData;
        this.mIsIntegration = bl2;
    }

    public boolean getIntegration() {
        return this.mIsIntegration;
    }

    public ApplicationLogger getLoggerConfigurations() {
        return this.mLogger;
    }

    public ServerSegmetData getSegmetData() {
        return this.mSegmetData;
    }
}

