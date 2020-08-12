/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.amazon.device.ads.AAXParameterGroup$PublisherExtraParametersAAXParameterGroup
 *  com.amazon.device.ads.AAXParameterGroup$UserIdAAXParameterGroup
 *  java.lang.Object
 *  org.json.JSONObject
 */
package com.amazon.device.ads;

import com.amazon.device.ads.AAXParameter;
import com.amazon.device.ads.AAXParameterGroup;
import org.json.JSONObject;

/*
 * Exception performing whole class analysis.
 */
abstract class AAXParameterGroup {
    public static final PublisherExtraParametersAAXParameterGroup PUBLISHER_EXTRA_PARAMETERS;
    public static final UserIdAAXParameterGroup USER_ID;

    static {
        USER_ID = new /* Unavailable Anonymous Inner Class!! */;
        PUBLISHER_EXTRA_PARAMETERS = new /* Unavailable Anonymous Inner Class!! */;
    }

    AAXParameterGroup() {
    }

    public abstract void evaluate(AAXParameter.ParameterData var1, JSONObject var2);
}

