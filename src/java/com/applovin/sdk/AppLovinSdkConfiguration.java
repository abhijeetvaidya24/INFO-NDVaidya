/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package com.applovin.sdk;

public interface AppLovinSdkConfiguration {
    public ConsentDialogState getConsentDialogState();

    public static final class ConsentDialogState
    extends Enum<ConsentDialogState> {
        public static final /* enum */ ConsentDialogState APPLIES;
        public static final /* enum */ ConsentDialogState DOES_NOT_APPLY;
        public static final /* enum */ ConsentDialogState UNKNOWN;
        private static final /* synthetic */ ConsentDialogState[] a;

        static {
            UNKNOWN = new ConsentDialogState();
            APPLIES = new ConsentDialogState();
            DOES_NOT_APPLY = new ConsentDialogState();
            ConsentDialogState[] arrconsentDialogState = new ConsentDialogState[]{UNKNOWN, APPLIES, DOES_NOT_APPLY};
            a = arrconsentDialogState;
        }

        public static ConsentDialogState valueOf(String string2) {
            return (ConsentDialogState)Enum.valueOf(ConsentDialogState.class, (String)string2);
        }

        public static ConsentDialogState[] values() {
            return (ConsentDialogState[])a.clone();
        }
    }

}

