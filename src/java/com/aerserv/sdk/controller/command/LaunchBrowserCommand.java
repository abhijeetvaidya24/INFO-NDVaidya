/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.net.Uri
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 */
package com.aerserv.sdk.controller.command;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.aerserv.sdk.controller.command.Command;
import com.aerserv.sdk.utils.AerServLog;

public class LaunchBrowserCommand
implements Command {
    private Context context;
    private String url;

    public LaunchBrowserCommand(Context context, String string) {
        this.context = context;
        this.url = string;
    }

    @Override
    public void execute() {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse((String)this.url));
            intent.setFlags(268435456);
            this.context.startActivity(intent);
            return;
        }
        catch (Exception exception) {
            AerServLog.d(this.getClass().getName(), "Exception caught while trying to launch a browser", exception);
            return;
        }
    }
}

