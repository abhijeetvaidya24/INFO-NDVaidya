/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.integralads.avid.library.mopub.processing.AvidSceenProcessor
 *  com.integralads.avid.library.mopub.processing.AvidViewProcessor
 *  java.lang.Object
 */
package com.integralads.avid.library.mopub.processing;

import com.integralads.avid.library.mopub.processing.AvidSceenProcessor;
import com.integralads.avid.library.mopub.processing.AvidViewProcessor;
import com.integralads.avid.library.mopub.processing.IAvidNodeProcessor;

public class AvidProcessorFactory {
    private AvidSceenProcessor screenProcessor = new AvidSceenProcessor((IAvidNodeProcessor)this.viewProcessor);
    private AvidViewProcessor viewProcessor = new AvidViewProcessor();

    public IAvidNodeProcessor getRootProcessor() {
        return this.screenProcessor;
    }
}

