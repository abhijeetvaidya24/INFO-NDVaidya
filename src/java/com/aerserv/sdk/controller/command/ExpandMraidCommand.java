/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Properties
 *  org.json.JSONException
 */
package com.aerserv.sdk.controller.command;

import com.aerserv.sdk.adapter.asaerserv.ASAerServInterstitialProvider;
import com.aerserv.sdk.adapter.asaerserv.mraid.MraidAction;
import com.aerserv.sdk.controller.command.Command;
import com.aerserv.sdk.controller.listener.MraidJavascriptInterfaceListener;
import com.aerserv.sdk.utils.AerServLog;
import java.util.Properties;
import org.json.JSONException;

public class ExpandMraidCommand
implements Command {
    private Properties properties;

    public ExpandMraidCommand(Properties properties) {
        this.properties = properties;
    }

    @Override
    public void execute() {
        try {
            AerServLog.d(this.getClass().getName(), "MRAID expanding");
            new ASAerServInterstitialProvider(this.properties).requestAd();
            return;
        }
        catch (JSONException jSONException) {
            AerServLog.e(this.getClass().getSimpleName(), "Exception caught while trying to expand MRAID", (Exception)((Object)jSONException));
            if (this.properties.contains((Object)"mraidJavascriptInterfaceListener")) {
                ((MraidJavascriptInterfaceListener)this.properties.get((Object)"mraidJavascriptInterfaceListener")).onError(MraidAction.EXPAND, (Exception)((Object)jSONException));
            }
            return;
        }
    }
}

