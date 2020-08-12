/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.integralads.avid.library.mopub.walking.async.AvidEmptyPublishAsyncTask
 *  com.integralads.avid.library.mopub.walking.async.AvidPublishAsyncTask
 *  java.lang.Object
 *  java.lang.String
 *  java.util.HashSet
 *  org.json.JSONObject
 */
package com.integralads.avid.library.mopub.walking;

import com.integralads.avid.library.mopub.registration.AvidAdSessionRegistry;
import com.integralads.avid.library.mopub.walking.async.AvidAsyncTask;
import com.integralads.avid.library.mopub.walking.async.AvidAsyncTaskQueue;
import com.integralads.avid.library.mopub.walking.async.AvidCleanupAsyncTask;
import com.integralads.avid.library.mopub.walking.async.AvidEmptyPublishAsyncTask;
import com.integralads.avid.library.mopub.walking.async.AvidPublishAsyncTask;
import java.util.HashSet;
import org.json.JSONObject;

public class AvidStatePublisher
implements AvidAsyncTask.StateProvider {
    private final AvidAdSessionRegistry adSessionRegistry;
    private JSONObject previousState;
    private final AvidAsyncTaskQueue taskQueue;

    public AvidStatePublisher(AvidAdSessionRegistry avidAdSessionRegistry, AvidAsyncTaskQueue avidAsyncTaskQueue) {
        this.adSessionRegistry = avidAdSessionRegistry;
        this.taskQueue = avidAsyncTaskQueue;
    }

    public void cleanupCache() {
        this.taskQueue.submitTask(new AvidCleanupAsyncTask(this));
    }

    @Override
    public JSONObject getPreviousState() {
        return this.previousState;
    }

    public void publishEmptyState(JSONObject jSONObject, HashSet<String> hashSet, double d2) {
        AvidAsyncTaskQueue avidAsyncTaskQueue = this.taskQueue;
        AvidEmptyPublishAsyncTask avidEmptyPublishAsyncTask = new AvidEmptyPublishAsyncTask((AvidAsyncTask.StateProvider)this, this.adSessionRegistry, hashSet, jSONObject, d2);
        avidAsyncTaskQueue.submitTask((AvidAsyncTask)avidEmptyPublishAsyncTask);
    }

    public void publishState(JSONObject jSONObject, HashSet<String> hashSet, double d2) {
        AvidAsyncTaskQueue avidAsyncTaskQueue = this.taskQueue;
        AvidPublishAsyncTask avidPublishAsyncTask = new AvidPublishAsyncTask((AvidAsyncTask.StateProvider)this, this.adSessionRegistry, hashSet, jSONObject, d2);
        avidAsyncTaskQueue.submitTask((AvidAsyncTask)avidPublishAsyncTask);
    }

    @Override
    public void setPreviousState(JSONObject jSONObject) {
        this.previousState = jSONObject;
    }
}

