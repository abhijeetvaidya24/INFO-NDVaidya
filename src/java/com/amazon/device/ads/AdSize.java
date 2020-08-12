/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.amazon.device.ads.MobileAdsLogger
 *  java.lang.Enum
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.NoSuchFieldError
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.amazon.device.ads;

import com.amazon.device.ads.MobileAdsLogger;
import com.amazon.device.ads.MobileAdsLoggerFactory;
import com.amazon.device.ads.NumberUtils;

public class AdSize {
    private static final String LOGTAG = "AdSize";
    public static final AdSize SIZE_1024x50;
    public static final AdSize SIZE_300x250;
    public static final AdSize SIZE_320x50;
    public static final AdSize SIZE_600x90;
    public static final AdSize SIZE_728x90;
    public static final AdSize SIZE_AUTO;
    public static final AdSize SIZE_AUTO_NO_SCALE;
    static final AdSize SIZE_INTERSTITIAL;
    static final AdSize SIZE_MODELESS_INTERSTITIAL;
    private int gravity = 17;
    private int height;
    private final MobileAdsLogger logger = new MobileAdsLoggerFactory().createMobileAdsLogger(LOGTAG);
    private int maxWidth;
    private Modality modality = Modality.MODELESS;
    private Scaling scaling = Scaling.CAN_UPSCALE;
    private SizeType type = SizeType.EXPLICIT;
    private int width;

    static {
        SIZE_320x50 = new AdSize(320, 50);
        SIZE_300x250 = new AdSize(300, 250);
        SIZE_600x90 = new AdSize(600, 90);
        SIZE_728x90 = new AdSize(728, 90);
        SIZE_1024x50 = new AdSize(1024, 50);
        SIZE_AUTO = new AdSize(SizeType.AUTO);
        SIZE_AUTO_NO_SCALE = new AdSize(SizeType.AUTO, Scaling.NO_UPSCALE);
        SIZE_INTERSTITIAL = new AdSize(SizeType.INTERSTITIAL, Modality.MODAL);
        SIZE_MODELESS_INTERSTITIAL = new AdSize(SizeType.INTERSTITIAL);
    }

    public AdSize(int n, int n2) {
        this.initialize(n, n2);
    }

    AdSize(SizeType sizeType) {
        this.type = sizeType;
    }

    AdSize(SizeType sizeType, Modality modality) {
        this(sizeType);
        this.modality = modality;
    }

    AdSize(SizeType sizeType, Scaling scaling) {
        this(sizeType);
        this.scaling = scaling;
    }

    AdSize(String string, String string2) {
        this.initialize(NumberUtils.parseInt(string, 0), NumberUtils.parseInt(string2, 0));
    }

    private AdSize deepClone() {
        AdSize adSize = new AdSize(this.type);
        adSize.width = this.width;
        adSize.height = this.height;
        adSize.gravity = this.gravity;
        adSize.modality = this.modality;
        adSize.scaling = this.scaling;
        adSize.maxWidth = this.maxWidth;
        return adSize;
    }

    static String getAsSizeString(int n, int n2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Integer.toString((int)n));
        stringBuilder.append("x");
        stringBuilder.append(Integer.toString((int)n2));
        return stringBuilder.toString();
    }

    private void initialize(int n, int n2) {
        if (n > 0 && n2 > 0) {
            this.width = n;
            this.height = n2;
            this.type = SizeType.EXPLICIT;
            return;
        }
        this.logger.e("The width and height must be positive integers.");
        throw new IllegalArgumentException("The width and height must be positive integers.");
    }

    public boolean canUpscale() {
        return Scaling.CAN_UPSCALE.equals((Object)this.scaling);
    }

    public AdSize disableScaling() {
        AdSize adSize = this.deepClone();
        adSize.scaling = Scaling.NO_UPSCALE;
        return adSize;
    }

    public boolean equals(Object object) {
        boolean bl = object instanceof AdSize;
        boolean bl2 = false;
        if (bl) {
            AdSize adSize = (AdSize)object;
            boolean bl3 = this.type.equals((Object)adSize.type);
            bl2 = false;
            if (bl3) {
                if (this.type.equals((Object)SizeType.EXPLICIT) && (this.width != adSize.width || this.height != adSize.height)) {
                    return false;
                }
                int n = this.gravity;
                int n2 = adSize.gravity;
                bl2 = false;
                if (n == n2) {
                    int n3 = this.maxWidth;
                    int n4 = adSize.maxWidth;
                    bl2 = false;
                    if (n3 == n4) {
                        Scaling scaling = this.scaling;
                        Scaling scaling2 = adSize.scaling;
                        bl2 = false;
                        if (scaling == scaling2) {
                            Modality modality = this.modality;
                            Modality modality2 = adSize.modality;
                            bl2 = false;
                            if (modality == modality2) {
                                bl2 = true;
                            }
                        }
                    }
                }
            }
        }
        return bl2;
    }

    public int getGravity() {
        return this.gravity;
    }

    public int getHeight() {
        return this.height;
    }

    int getMaxWidth() {
        return this.maxWidth;
    }

    SizeType getSizeType() {
        return this.type;
    }

    public int getWidth() {
        return this.width;
    }

    public boolean isAuto() {
        return this.type == SizeType.AUTO;
    }

    boolean isModal() {
        return Modality.MODAL.equals((Object)this.modality);
    }

    public AdSize newGravity(int n) {
        AdSize adSize = this.deepClone();
        adSize.gravity = n;
        return adSize;
    }

    AdSize newMaxWidth(int n) {
        AdSize adSize = this.deepClone();
        adSize.maxWidth = n;
        return adSize;
    }

    public String toString() {
        int n = 1.$SwitchMap$com$amazon$device$ads$AdSize$SizeType[this.type.ordinal()];
        if (n != 1) {
            if (n != 2) {
                if (n != 3) {
                    return null;
                }
                return "interstitial";
            }
            return "auto";
        }
        return AdSize.getAsSizeString(this.width, this.height);
    }

    private static final class Modality
    extends Enum<Modality> {
        private static final /* synthetic */ Modality[] $VALUES;
        public static final /* enum */ Modality MODAL = new Modality();
        public static final /* enum */ Modality MODELESS = new Modality();

        static {
            Modality[] arrmodality = new Modality[]{MODAL, MODELESS};
            $VALUES = arrmodality;
        }

        public static Modality valueOf(String string) {
            return (Modality)Enum.valueOf(Modality.class, (String)string);
        }

        public static Modality[] values() {
            return (Modality[])$VALUES.clone();
        }
    }

    private static final class Scaling
    extends Enum<Scaling> {
        private static final /* synthetic */ Scaling[] $VALUES;
        public static final /* enum */ Scaling CAN_UPSCALE = new Scaling();
        public static final /* enum */ Scaling NO_UPSCALE = new Scaling();

        static {
            Scaling[] arrscaling = new Scaling[]{CAN_UPSCALE, NO_UPSCALE};
            $VALUES = arrscaling;
        }

        public static Scaling valueOf(String string) {
            return (Scaling)Enum.valueOf(Scaling.class, (String)string);
        }

        public static Scaling[] values() {
            return (Scaling[])$VALUES.clone();
        }
    }

    static final class SizeType
    extends Enum<SizeType> {
        private static final /* synthetic */ SizeType[] $VALUES;
        public static final /* enum */ SizeType AUTO;
        public static final /* enum */ SizeType EXPLICIT;
        public static final /* enum */ SizeType INTERSTITIAL;

        static {
            EXPLICIT = new SizeType();
            AUTO = new SizeType();
            INTERSTITIAL = new SizeType();
            SizeType[] arrsizeType = new SizeType[]{EXPLICIT, AUTO, INTERSTITIAL};
            $VALUES = arrsizeType;
        }

        public static SizeType valueOf(String string) {
            return (SizeType)Enum.valueOf(SizeType.class, (String)string);
        }

        public static SizeType[] values() {
            return (SizeType[])$VALUES.clone();
        }
    }

}

