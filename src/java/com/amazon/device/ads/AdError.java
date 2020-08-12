/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package com.amazon.device.ads;

public class AdError {
    private final ErrorCode code;
    private final String message;

    AdError(ErrorCode errorCode, String string) {
        this.code = errorCode;
        this.message = string;
    }

    public ErrorCode getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public static final class ErrorCode
    extends Enum<ErrorCode> {
        private static final /* synthetic */ ErrorCode[] $VALUES;
        public static final /* enum */ ErrorCode INTERNAL_ERROR;
        public static final /* enum */ ErrorCode NETWORK_ERROR;
        public static final /* enum */ ErrorCode NETWORK_TIMEOUT;
        public static final /* enum */ ErrorCode NO_FILL;
        public static final /* enum */ ErrorCode REQUEST_ERROR;

        static {
            NETWORK_ERROR = new ErrorCode();
            NETWORK_TIMEOUT = new ErrorCode();
            NO_FILL = new ErrorCode();
            INTERNAL_ERROR = new ErrorCode();
            REQUEST_ERROR = new ErrorCode();
            ErrorCode[] arrerrorCode = new ErrorCode[]{NETWORK_ERROR, NETWORK_TIMEOUT, NO_FILL, INTERNAL_ERROR, REQUEST_ERROR};
            $VALUES = arrerrorCode;
        }

        public static ErrorCode valueOf(String string) {
            return (ErrorCode)Enum.valueOf(ErrorCode.class, (String)string);
        }

        public static ErrorCode[] values() {
            return (ErrorCode[])$VALUES.clone();
        }
    }

}

