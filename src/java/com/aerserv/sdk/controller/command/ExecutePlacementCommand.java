/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.aerserv.sdk.controller.command;

import com.aerserv.sdk.AerServAdType;
import com.aerserv.sdk.AerServConfig;
import com.aerserv.sdk.controller.AdManager;
import com.aerserv.sdk.controller.command.Command;
import com.aerserv.sdk.controller.listener.ExecutePlacementListener;
import com.aerserv.sdk.controller.listener.SaveShowListener;
import com.aerserv.sdk.utils.AerServLog;

public class ExecutePlacementCommand
implements Command {
    private static final String LOG_TAG = "ExecutePlacementCommand";
    private AerServConfig config;
    private ExecutePlacementListener executePlacementListener;
    private SaveShowListener saveShowListener;
    private AerServAdType type;
    private String viewId;

    public ExecutePlacementCommand(AerServConfig aerServConfig, AerServAdType aerServAdType, ExecutePlacementListener executePlacementListener, SaveShowListener saveShowListener) {
        this(aerServConfig, aerServAdType, executePlacementListener, saveShowListener, null);
    }

    public ExecutePlacementCommand(AerServConfig aerServConfig, AerServAdType aerServAdType, ExecutePlacementListener executePlacementListener, SaveShowListener saveShowListener, String string) {
        this.config = aerServConfig;
        this.type = aerServAdType;
        this.executePlacementListener = executePlacementListener;
        this.viewId = string;
        this.saveShowListener = saveShowListener;
        String string2 = LOG_TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ExecutePlacementCommand constructed with type ");
        stringBuilder.append((Object)aerServAdType);
        AerServLog.d(string2, stringBuilder.toString());
    }

    @Override
    public void execute() {
        try {
            AerServLog.d(LOG_TAG, "Executing ExecutePlacementCommand");
            new AdManager(this.config, this.type, this.executePlacementListener, this.saveShowListener, this.viewId);
            return;
        }
        catch (Exception exception) {
            AerServLog.e(LOG_TAG, "Exception caught", exception);
            return;
        }
    }
}

