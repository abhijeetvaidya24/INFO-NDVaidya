/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Collection
 *  java.util.HashSet
 *  org.json.JSONObject
 */
package com.integralads.avid.library.adcolony.walking.async;

import com.integralads.avid.library.adcolony.registration.AvidAdSessionRegistry;
import com.integralads.avid.library.adcolony.session.internal.InternalAvidAdSession;
import com.integralads.avid.library.adcolony.utils.AvidCommand;
import com.integralads.avid.library.adcolony.utils.AvidJSONUtil;
import com.integralads.avid.library.adcolony.walking.async.AbstractAvidPublishAsyncTask;
import com.integralads.avid.library.adcolony.walking.async.AvidAsyncTask;
import java.util.Collection;
import java.util.HashSet;
import org.json.JSONObject;

public class AvidEmptyPublishAsyncTask
extends AbstractAvidPublishAsyncTask {
    public AvidEmptyPublishAsyncTask(AvidAsyncTask.StateProvider stateProvider, AvidAdSessionRegistry avidAdSessionRegistry, HashSet<String> hashSet, JSONObject jSONObject, double d2) {
        super(stateProvider, avidAdSessionRegistry, hashSet, jSONObject, d2);
    }

    protected /* varargs */ String doInBackground(Object ... arrobject) {
        return AvidCommand.setNativeViewState(AvidJSONUtil.getTreeJSONObject(this.state, this.timestamp).toString());
    }

    @Override
    protected void onPostExecute(String string) {
        for (InternalAvidAdSession internalAvidAdSession : this.adSessionRegistry.getInternalAvidAdSessions()) {
            if (!this.sessionIds.contains((Object)internalAvidAdSession.getAvidAdSessionId())) continue;
            internalAvidAdSession.publishEmptyNativeViewStateCommand(string, this.timestamp);
        }
        super.onPostExecute(string);
    }
}

