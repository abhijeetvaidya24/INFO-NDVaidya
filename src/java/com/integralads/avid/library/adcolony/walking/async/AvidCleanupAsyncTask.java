/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  org.json.JSONObject
 */
package com.integralads.avid.library.adcolony.walking.async;

import com.integralads.avid.library.adcolony.walking.async.AvidAsyncTask;
import org.json.JSONObject;

public class AvidCleanupAsyncTask
extends AvidAsyncTask {
    public AvidCleanupAsyncTask(AvidAsyncTask.StateProvider stateProvider) {
        super(stateProvider);
    }

    protected /* varargs */ String doInBackground(Object ... arrobject) {
        this.stateProvider.setPreviousState(null);
        return null;
    }
}

