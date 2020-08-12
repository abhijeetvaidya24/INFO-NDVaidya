/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 */
package com.aerserv.sdk.controller.command;

import com.aerserv.sdk.controller.command.Command;
import com.aerserv.sdk.controller.listener.FetchAdListener;
import com.aerserv.sdk.proxy.AdProxy;
import java.util.List;

public class FetchAdCommand
implements Command {
    private String fallback;
    private FetchAdListener fetchAdListener;
    private List<String> keyWords;
    private boolean skipMediation;

    public FetchAdCommand(String string, List<String> list, FetchAdListener fetchAdListener, boolean bl) {
        this.fallback = string;
        this.keyWords = list;
        this.fetchAdListener = fetchAdListener;
        this.skipMediation = bl;
    }

    @Override
    public void execute() {
        new AdProxy().getAd(this.fallback, this.keyWords, this.fetchAdListener, this.skipMediation);
    }
}

