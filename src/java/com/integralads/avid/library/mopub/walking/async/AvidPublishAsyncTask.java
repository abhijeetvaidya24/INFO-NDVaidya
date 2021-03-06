/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Collection
 *  java.util.HashSet
 *  org.json.JSONObject
 */
package com.integralads.avid.library.mopub.walking.async;

import android.text.TextUtils;
import com.integralads.avid.library.mopub.registration.AvidAdSessionRegistry;
import com.integralads.avid.library.mopub.session.internal.InternalAvidAdSession;
import com.integralads.avid.library.mopub.utils.AvidCommand;
import com.integralads.avid.library.mopub.utils.AvidJSONUtil;
import com.integralads.avid.library.mopub.walking.async.AbstractAvidPublishAsyncTask;
import com.integralads.avid.library.mopub.walking.async.AvidAsyncTask;
import java.util.Collection;
import java.util.HashSet;
import org.json.JSONObject;

public class AvidPublishAsyncTask
extends AbstractAvidPublishAsyncTask {
    public AvidPublishAsyncTask(AvidAsyncTask.StateProvider stateProvider, AvidAdSessionRegistry avidAdSessionRegistry, HashSet<String> hashSet, JSONObject jSONObject, double d2) {
        super(stateProvider, avidAdSessionRegistry, hashSet, jSONObject, d2);
    }

    private void injectCommand(String string) {
        for (InternalAvidAdSession internalAvidAdSession : this.adSessionRegistry.getInternalAvidAdSessions()) {
            if (!this.sessionIds.contains((Object)internalAvidAdSession.getAvidAdSessionId())) continue;
            internalAvidAdSession.publishNativeViewStateCommand(string, this.timestamp);
        }
    }

    protected /* varargs */ String doInBackground(Object ... arrobject) {
        if (AvidJSONUtil.equalStates(this.state, this.stateProvider.getPreviousState())) {
            return null;
        }
        this.stateProvider.setPreviousState(this.state);
        return AvidCommand.setNativeViewState(AvidJSONUtil.getTreeJSONObject(this.state, this.timestamp).toString());
    }

    @Override
    protected void onPostExecute(String string) {
        if (!TextUtils.isEmpty((CharSequence)string)) {
            this.injectCommand(string);
        }
        super.onPostExecute(string);
    }
}

