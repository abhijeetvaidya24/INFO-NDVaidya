/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package com.ironsource.sdk.data;

public class SSAEnums {

    public static final class BackButtonState
    extends Enum<BackButtonState> {
        private static final /* synthetic */ BackButtonState[] $VALUES;
        public static final /* enum */ BackButtonState Controller;
        public static final /* enum */ BackButtonState Device;
        public static final /* enum */ BackButtonState None;

        static {
            None = new BackButtonState();
            Device = new BackButtonState();
            Controller = new BackButtonState();
            BackButtonState[] arrbackButtonState = new BackButtonState[]{None, Device, Controller};
            $VALUES = arrbackButtonState;
        }

        public static BackButtonState valueOf(String string) {
            return (BackButtonState)Enum.valueOf(BackButtonState.class, (String)string);
        }

        public static BackButtonState[] values() {
            return (BackButtonState[])$VALUES.clone();
        }
    }

    public static final class ControllerState
    extends Enum<ControllerState> {
        private static final /* synthetic */ ControllerState[] $VALUES;
        public static final /* enum */ ControllerState Failed;
        public static final /* enum */ ControllerState FailedToDownload;
        public static final /* enum */ ControllerState FailedToLoad;
        public static final /* enum */ ControllerState Loaded;
        public static final /* enum */ ControllerState None;
        public static final /* enum */ ControllerState Ready;

        static {
            None = new ControllerState();
            FailedToDownload = new ControllerState();
            FailedToLoad = new ControllerState();
            Loaded = new ControllerState();
            Ready = new ControllerState();
            Failed = new ControllerState();
            ControllerState[] arrcontrollerState = new ControllerState[]{None, FailedToDownload, FailedToLoad, Loaded, Ready, Failed};
            $VALUES = arrcontrollerState;
        }

        public static ControllerState valueOf(String string) {
            return (ControllerState)Enum.valueOf(ControllerState.class, (String)string);
        }

        public static ControllerState[] values() {
            return (ControllerState[])$VALUES.clone();
        }
    }

    public static final class DebugMode
    extends Enum<DebugMode> {
        private static final /* synthetic */ DebugMode[] $VALUES;
        public static final /* enum */ DebugMode MODE_0 = new DebugMode(0);
        public static final /* enum */ DebugMode MODE_1 = new DebugMode(1);
        public static final /* enum */ DebugMode MODE_2 = new DebugMode(2);
        public static final /* enum */ DebugMode MODE_3 = new DebugMode(3);
        private int value;

        static {
            DebugMode[] arrdebugMode = new DebugMode[]{MODE_0, MODE_1, MODE_2, MODE_3};
            $VALUES = arrdebugMode;
        }

        private DebugMode(int n3) {
            this.value = n3;
        }

        public static DebugMode valueOf(String string) {
            return (DebugMode)Enum.valueOf(DebugMode.class, (String)string);
        }

        public static DebugMode[] values() {
            return (DebugMode[])$VALUES.clone();
        }

        public int getValue() {
            return this.value;
        }
    }

    public static final class ProductType
    extends Enum<ProductType> {
        private static final /* synthetic */ ProductType[] $VALUES;
        public static final /* enum */ ProductType Interstitial;
        public static final /* enum */ ProductType OfferWall;
        public static final /* enum */ ProductType OfferWallCredits;
        public static final /* enum */ ProductType RewardedVideo;

        static {
            OfferWall = new ProductType();
            Interstitial = new ProductType();
            OfferWallCredits = new ProductType();
            RewardedVideo = new ProductType();
            ProductType[] arrproductType = new ProductType[]{OfferWall, Interstitial, OfferWallCredits, RewardedVideo};
            $VALUES = arrproductType;
        }

        public static ProductType valueOf(String string) {
            return (ProductType)Enum.valueOf(ProductType.class, (String)string);
        }

        public static ProductType[] values() {
            return (ProductType[])$VALUES.clone();
        }
    }

}

