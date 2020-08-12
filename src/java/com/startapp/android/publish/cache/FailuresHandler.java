/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.Serializable
 *  java.lang.Integer
 *  java.lang.Object
 *  java.util.Arrays
 *  java.util.List
 */
package com.startapp.android.publish.cache;

import com.startapp.common.c.f;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class FailuresHandler
implements Serializable {
    private static final long serialVersionUID = 1L;
    private boolean infiniteLastRetry;
    @f(b="Ljava/util/ArrayList;", c="Ljava/lang/Integer;")
    private List<Integer> intervals;

    public FailuresHandler() {
        Object[] arrobject = new Integer[]{10, 30, 60, 300};
        this.intervals = Arrays.asList((Object[])arrobject);
        this.infiniteLastRetry = true;
    }

    public List<Integer> getIntervals() {
        return this.intervals;
    }

    public boolean isInfiniteLastRetry() {
        return this.infiniteLastRetry;
    }
}

