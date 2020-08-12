/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.util.HashMap
 *  java.util.Map
 */
package com.ironsource.sdk.controller;

import com.ironsource.sdk.data.ProductParameters;
import com.ironsource.sdk.data.SSAEnums;
import java.util.HashMap;
import java.util.Map;

public class ProductParametersCollection {
    private Map<SSAEnums.ProductType, ProductParameters> mProductParameters = new HashMap();

    public ProductParameters getProductParameters(SSAEnums.ProductType productType) {
        if (productType != null) {
            return (ProductParameters)this.mProductParameters.get((Object)productType);
        }
        return null;
    }

    public ProductParameters setProductParameters(SSAEnums.ProductType productType, String string, String string2) {
        ProductParameters productParameters = new ProductParameters(string, string2);
        this.mProductParameters.put((Object)productType, (Object)productParameters);
        return productParameters;
    }
}

