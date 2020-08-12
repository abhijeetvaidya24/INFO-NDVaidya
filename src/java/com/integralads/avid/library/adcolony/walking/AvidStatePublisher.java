/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.integralads.avid.library.adcolony.walking.async.AvidEmptyPublishAsyncTask
 *  com.integralads.avid.library.adcolony.walking.async.AvidPublishAsyncTask
 *  java.lang.Object
 *  java.lang.String
 *  java.util.HashSet
 *  org.json.JSONObject
 */
package com.integralads.avid.library.adcolony.walking;

import com.integralads.avid.library.adcolony.registration.AvidAdSessionRegistry;
import com.integralads.avid.library.adcolony.walking.async.AvidAsyncTask;
import com.integralads.avid.library.adcolony.walking.async.AvidAsyncTaskQueue;
import com.integralads.avid.library.adcolony.walking.async.AvidCleanupAsyncTask;
import com.integralads.avid.library.adcolony.walking.async.AvidEmptyPublishAsyncTask;
import com.integralads.avid.library.adcolony.walking.async.AvidPublishAsyncTask;
import java.util.HashSet;
import org.json.JSONObject;

public class AvidStatePublisher
implements AvidAsyncTask.StateProvider {
    private final AvidAdSessionRegistry a;
    private JSONObject b;
    private final AvidAsyncTaskQueue c;

    public AvidStatePublisher(AvidAdSessionRegistry avidAdSessionRegistry, AvidAsyncTaskQueue avidAsyncTaskQueue) {
        this.a = avidAdSessionRegistry;
        this.c = avidAsyncTaskQueue;
    }

    public void cleanupCache() {
        this.c.submitTask(new AvidCleanupAsyncTask(this));
    }

    @Override
    public JSONObject getPreviousState() {
        return this.b;
    }

    public void publishEmptyState(JSONObject jSONObject, HashSet<String> hashSet, double d2) {
        AvidAsyncTaskQueue avidAsyncTaskQueue = this.c;
        AvidEmptyPublishAsyncTask avidEmptyPublishAsyncTask = new AvidEmptyPublishAsyncTask((AvidAsyncTask.StateProvider)this, this.a, hashSet, jSONObject, d2);
        avidAsyncTaskQueue.submitTask((AvidAsyncTask)avidEmptyPublishAsyncTask);
    }

    public void publishState(JSONObject jSONObject, HashSet<String> hashSet, double d2) {
        AvidAsyncTaskQueue avidAsyncTaskQueue = this.c;
        AvidPublishAsyncTask avidPublishAsyncTask = new AvidPublishAsyncTask((AvidAsyncTask.StateProvider)this, this.a, hashSet, jSONObject, d2);
        avidAsyncTaskQueue.submitTask((AvidAsyncTask)avidPublishAsyncTask);
    }

    @Override
    public void setPreviousState(JSONObject jSONObject) {
        this.b = jSONObject;
    }
}

