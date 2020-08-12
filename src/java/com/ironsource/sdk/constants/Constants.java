/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package com.ironsource.sdk.constants;

import com.ironsource.sdk.data.SSAEnums;

public class Constants {

    public static class JSMethods {
        public String failureCallbackName;
        public String methodName;
        public String successCallbackName;

        public static JSMethods getInitMethodByProduct(SSAEnums.ProductType productType) {
            JSMethods jSMethods = new JSMethods();
            if (productType == SSAEnums.ProductType.RewardedVideo) {
                jSMethods.methodName = "initRewardedVideo";
                jSMethods.successCallbackName = "onInitRewardedVideoSuccess";
                jSMethods.failureCallbackName = "onInitRewardedVideoFail";
                return jSMethods;
            }
            if (productType == SSAEnums.ProductType.Interstitial) {
                jSMethods.methodName = "initInterstitial";
                jSMethods.successCallbackName = "onInitInterstitialSuccess";
                jSMethods.failureCallbackName = "onInitInterstitialFail";
                return jSMethods;
            }
            if (productType == SSAEnums.ProductType.OfferWall) {
                jSMethods.methodName = "initOfferWall";
                jSMethods.successCallbackName = "onInitOfferWallSuccess";
                jSMethods.failureCallbackName = "onInitOfferWallFail";
            }
            return jSMethods;
        }

        public static JSMethods getShowMethodByProduct(SSAEnums.ProductType productType) {
            JSMethods jSMethods = new JSMethods();
            if (productType == SSAEnums.ProductType.RewardedVideo) {
                jSMethods.methodName = "showRewardedVideo";
                jSMethods.successCallbackName = "onShowRewardedVideoSuccess";
                jSMethods.failureCallbackName = "onShowRewardedVideoFail";
                return jSMethods;
            }
            if (productType == SSAEnums.ProductType.Interstitial) {
                jSMethods.methodName = "showInterstitial";
                jSMethods.successCallbackName = "onShowInterstitialSuccess";
                jSMethods.failureCallbackName = "onShowInterstitialFail";
                return jSMethods;
            }
            if (productType == SSAEnums.ProductType.OfferWall) {
                jSMethods.methodName = "showOfferWall";
                jSMethods.successCallbackName = "onShowOfferWallSuccess";
                jSMethods.failureCallbackName = "onInitOfferWallFail";
            }
            return jSMethods;
        }
    }

}

