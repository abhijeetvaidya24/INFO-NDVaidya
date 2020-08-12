/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  java.lang.Enum
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 */
package com.adincube.sdk;

import android.app.Activity;
import android.content.Context;
import com.adincube.sdk.AdinCubeInterstitialEventListener;
import com.adincube.sdk.BannerView;
import com.adincube.sdk.g.b.b.b;
import com.adincube.sdk.util.ErrorReportingHelper;
import com.adincube.sdk.util.a;
import com.adincube.sdk.util.d;

public final class AdinCube {
    public static void setAppKey(String string) {
        try {
            d.a(string);
            return;
        }
        catch (Throwable throwable) {
            a.c("AdinCube.setAppKey", new Object[]{throwable});
            ErrorReportingHelper.report("AdinCube.setAppKey", throwable);
            return;
        }
    }

    public static final class Banner {
        public static BannerView createView(Context context, Size size) {
            if (size != null) {
                return new BannerView(context, size);
            }
            throw new IllegalArgumentException("size must not be null");
        }

        public static final class Size
        extends Enum<Size> {
            private static final /* synthetic */ Size[] $VALUES;
            public static final /* enum */ Size BANNER_300x250;
            public static final /* enum */ Size BANNER_320x50;
            public static final /* enum */ Size BANNER_728x90;
            public static final /* enum */ Size BANNER_AUTO;

            static {
                BANNER_AUTO = new Size();
                BANNER_320x50 = new Size();
                BANNER_728x90 = new Size();
                BANNER_300x250 = new Size();
                Size[] arrsize = new Size[]{BANNER_AUTO, BANNER_320x50, BANNER_728x90, BANNER_300x250};
                $VALUES = arrsize;
            }

            public static Size valueOf(String string) {
                return (Size)Enum.valueOf(Size.class, (String)string);
            }

            public static Size[] values() {
                return (Size[])$VALUES.clone();
            }
        }

    }

    public static final class Interstitial {
        public static void init(Activity activity) {
            com.adincube.sdk.e.a.a().a(activity);
        }

        public static boolean isReady(Activity activity) {
            return com.adincube.sdk.e.a.a().b(activity);
        }

        public static void setEventListener(AdinCubeInterstitialEventListener adinCubeInterstitialEventListener) {
            try {
                b.b().a = adinCubeInterstitialEventListener;
                return;
            }
            catch (Throwable throwable) {
                a.c("AdinCube.Interstitial.setEventListener", new Object[]{throwable});
                ErrorReportingHelper.report("AdinCube.Interstitial.setEventListener", throwable);
                return;
            }
        }

        public static void show(Activity activity) {
            com.adincube.sdk.e.a.a().c(activity);
        }
    }

    public static final class UserConsent {

        public static final class Answer
        extends Enum<Answer> {
            private static final /* synthetic */ Answer[] $VALUES;
            public static final /* enum */ Answer FULL_APPROVAL = new Answer();
            public static final /* enum */ Answer NO_ANSWER;
            public static final /* enum */ Answer PARTIAL_APPROVAL;
            public static final /* enum */ Answer REFUSAL;

            static {
                PARTIAL_APPROVAL = new Answer();
                REFUSAL = new Answer();
                NO_ANSWER = new Answer();
                Answer[] arranswer = new Answer[]{FULL_APPROVAL, PARTIAL_APPROVAL, REFUSAL, NO_ANSWER};
                $VALUES = arranswer;
            }

            public static Answer valueOf(String string) {
                return (Answer)Enum.valueOf(Answer.class, (String)string);
            }

            public static Answer[] values() {
                return (Answer[])$VALUES.clone();
            }
        }

        public static final class Purpose
        extends Enum<Purpose> {
            private static final /* synthetic */ Purpose[] $VALUES;
            public static final /* enum */ Purpose AD;
            public static final /* enum */ Purpose CONTENT;
            public static final /* enum */ Purpose INFORMATION;
            public static final /* enum */ Purpose MEASUREMENT;
            public static final /* enum */ Purpose PERSONALISATION;

            static {
                INFORMATION = new Purpose();
                PERSONALISATION = new Purpose();
                AD = new Purpose();
                CONTENT = new Purpose();
                MEASUREMENT = new Purpose();
                Purpose[] arrpurpose = new Purpose[]{INFORMATION, PERSONALISATION, AD, CONTENT, MEASUREMENT};
                $VALUES = arrpurpose;
            }

            public static Purpose valueOf(String string) {
                return (Purpose)Enum.valueOf(Purpose.class, (String)string);
            }

            public static Purpose[] values() {
                return (Purpose[])$VALUES.clone();
            }
        }

    }

}

