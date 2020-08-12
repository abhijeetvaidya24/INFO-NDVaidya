/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.integralads.avid.library.adcolony.processing.AvidSceenProcessor
 *  com.integralads.avid.library.adcolony.processing.AvidViewProcessor
 *  java.lang.Object
 */
package com.integralads.avid.library.adcolony.processing;

import com.integralads.avid.library.adcolony.processing.AvidSceenProcessor;
import com.integralads.avid.library.adcolony.processing.AvidViewProcessor;
import com.integralads.avid.library.adcolony.processing.IAvidNodeProcessor;

public class AvidProcessorFactory {
    private AvidSceenProcessor a = new AvidSceenProcessor((IAvidNodeProcessor)this.b);
    private AvidViewProcessor b = new AvidViewProcessor();

    public IAvidNodeProcessor getRootProcessor() {
        return this.a;
    }
}

