/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.NoSuchFieldError
 *  java.lang.Object
 *  java.lang.String
 */
package com.chartboost.sdk.Model;

public final class CBError {
    private final a a;
    private final String b;
    private boolean c;

    public CBError(a a2, String string2) {
        this.a = a2;
        this.b = string2;
        this.c = true;
    }

    public a a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    public CBImpressionError c() {
        int n2 = 1.a[this.a.ordinal()];
        if (n2 != 1 && n2 != 2 && n2 != 3) {
            if (n2 != 4) {
                if (n2 != 5) {
                    return CBImpressionError.NETWORK_FAILURE;
                }
                return CBImpressionError.NO_AD_FOUND;
            }
            return CBImpressionError.INTERNET_UNAVAILABLE;
        }
        return CBImpressionError.INTERNAL;
    }

    public static final class CBClickError
    extends Enum<CBClickError> {
        public static final /* enum */ CBClickError AGE_GATE_FAILURE;
        public static final /* enum */ CBClickError INTERNAL;
        public static final /* enum */ CBClickError NO_HOST_ACTIVITY;
        public static final /* enum */ CBClickError URI_INVALID;
        public static final /* enum */ CBClickError URI_UNRECOGNIZED;
        private static final /* synthetic */ CBClickError[] a;

        static {
            URI_INVALID = new CBClickError();
            URI_UNRECOGNIZED = new CBClickError();
            AGE_GATE_FAILURE = new CBClickError();
            NO_HOST_ACTIVITY = new CBClickError();
            INTERNAL = new CBClickError();
            CBClickError[] arrcBClickError = new CBClickError[]{URI_INVALID, URI_UNRECOGNIZED, AGE_GATE_FAILURE, NO_HOST_ACTIVITY, INTERNAL};
            a = arrcBClickError;
        }

        public static CBClickError valueOf(String string2) {
            return (CBClickError)Enum.valueOf(CBClickError.class, (String)string2);
        }

        public static CBClickError[] values() {
            return (CBClickError[])a.clone();
        }
    }

    public static final class CBImpressionError
    extends Enum<CBImpressionError> {
        public static final /* enum */ CBImpressionError ACTIVITY_MISSING_IN_MANIFEST;
        public static final /* enum */ CBImpressionError ASSETS_DOWNLOAD_FAILURE;
        public static final /* enum */ CBImpressionError ASSET_MISSING;
        public static final /* enum */ CBImpressionError ASSET_PREFETCH_IN_PROGRESS;
        public static final /* enum */ CBImpressionError EMPTY_LOCAL_VIDEO_LIST;
        public static final /* enum */ CBImpressionError END_POINT_DISABLED;
        public static final /* enum */ CBImpressionError ERROR_CREATING_VIEW;
        public static final /* enum */ CBImpressionError ERROR_DISPLAYING_VIEW;
        public static final /* enum */ CBImpressionError ERROR_LOADING_WEB_VIEW;
        public static final /* enum */ CBImpressionError ERROR_PLAYING_VIDEO;
        public static final /* enum */ CBImpressionError FIRST_SESSION_INTERSTITIALS_DISABLED;
        public static final /* enum */ CBImpressionError HARDWARE_ACCELERATION_DISABLED;
        public static final /* enum */ CBImpressionError IMPRESSION_ALREADY_VISIBLE;
        public static final /* enum */ CBImpressionError INCOMPATIBLE_API_VERSION;
        public static final /* enum */ CBImpressionError INTERNAL;
        public static final /* enum */ CBImpressionError INTERNET_UNAVAILABLE;
        public static final /* enum */ CBImpressionError INTERNET_UNAVAILABLE_AT_SHOW;
        public static final /* enum */ CBImpressionError INVALID_LOCATION;
        public static final /* enum */ CBImpressionError INVALID_RESPONSE;
        public static final /* enum */ CBImpressionError NETWORK_FAILURE;
        public static final /* enum */ CBImpressionError NO_AD_FOUND;
        public static final /* enum */ CBImpressionError NO_HOST_ACTIVITY;
        public static final /* enum */ CBImpressionError PENDING_IMPRESSION_ERROR;
        public static final /* enum */ CBImpressionError SESSION_NOT_STARTED;
        public static final /* enum */ CBImpressionError TOO_MANY_CONNECTIONS;
        public static final /* enum */ CBImpressionError USER_CANCELLATION;
        public static final /* enum */ CBImpressionError VIDEO_ID_MISSING;
        public static final /* enum */ CBImpressionError VIDEO_UNAVAILABLE;
        public static final /* enum */ CBImpressionError VIDEO_UNAVAILABLE_FOR_CURRENT_ORIENTATION;
        public static final /* enum */ CBImpressionError WEB_VIEW_CLIENT_RECEIVED_ERROR;
        public static final /* enum */ CBImpressionError WEB_VIEW_PAGE_LOAD_TIMEOUT;
        public static final /* enum */ CBImpressionError WRONG_ORIENTATION;
        private static final /* synthetic */ CBImpressionError[] a;

        static {
            INTERNAL = new CBImpressionError();
            INTERNET_UNAVAILABLE = new CBImpressionError();
            TOO_MANY_CONNECTIONS = new CBImpressionError();
            WRONG_ORIENTATION = new CBImpressionError();
            FIRST_SESSION_INTERSTITIALS_DISABLED = new CBImpressionError();
            NETWORK_FAILURE = new CBImpressionError();
            NO_AD_FOUND = new CBImpressionError();
            SESSION_NOT_STARTED = new CBImpressionError();
            IMPRESSION_ALREADY_VISIBLE = new CBImpressionError();
            NO_HOST_ACTIVITY = new CBImpressionError();
            USER_CANCELLATION = new CBImpressionError();
            INVALID_LOCATION = new CBImpressionError();
            VIDEO_UNAVAILABLE = new CBImpressionError();
            VIDEO_ID_MISSING = new CBImpressionError();
            ERROR_PLAYING_VIDEO = new CBImpressionError();
            INVALID_RESPONSE = new CBImpressionError();
            ASSETS_DOWNLOAD_FAILURE = new CBImpressionError();
            ERROR_CREATING_VIEW = new CBImpressionError();
            ERROR_DISPLAYING_VIEW = new CBImpressionError();
            INCOMPATIBLE_API_VERSION = new CBImpressionError();
            ERROR_LOADING_WEB_VIEW = new CBImpressionError();
            ASSET_PREFETCH_IN_PROGRESS = new CBImpressionError();
            ACTIVITY_MISSING_IN_MANIFEST = new CBImpressionError();
            EMPTY_LOCAL_VIDEO_LIST = new CBImpressionError();
            END_POINT_DISABLED = new CBImpressionError();
            HARDWARE_ACCELERATION_DISABLED = new CBImpressionError();
            PENDING_IMPRESSION_ERROR = new CBImpressionError();
            VIDEO_UNAVAILABLE_FOR_CURRENT_ORIENTATION = new CBImpressionError();
            ASSET_MISSING = new CBImpressionError();
            WEB_VIEW_PAGE_LOAD_TIMEOUT = new CBImpressionError();
            WEB_VIEW_CLIENT_RECEIVED_ERROR = new CBImpressionError();
            INTERNET_UNAVAILABLE_AT_SHOW = new CBImpressionError();
            CBImpressionError[] arrcBImpressionError = new CBImpressionError[]{INTERNAL, INTERNET_UNAVAILABLE, TOO_MANY_CONNECTIONS, WRONG_ORIENTATION, FIRST_SESSION_INTERSTITIALS_DISABLED, NETWORK_FAILURE, NO_AD_FOUND, SESSION_NOT_STARTED, IMPRESSION_ALREADY_VISIBLE, NO_HOST_ACTIVITY, USER_CANCELLATION, INVALID_LOCATION, VIDEO_UNAVAILABLE, VIDEO_ID_MISSING, ERROR_PLAYING_VIDEO, INVALID_RESPONSE, ASSETS_DOWNLOAD_FAILURE, ERROR_CREATING_VIEW, ERROR_DISPLAYING_VIEW, INCOMPATIBLE_API_VERSION, ERROR_LOADING_WEB_VIEW, ASSET_PREFETCH_IN_PROGRESS, ACTIVITY_MISSING_IN_MANIFEST, EMPTY_LOCAL_VIDEO_LIST, END_POINT_DISABLED, HARDWARE_ACCELERATION_DISABLED, PENDING_IMPRESSION_ERROR, VIDEO_UNAVAILABLE_FOR_CURRENT_ORIENTATION, ASSET_MISSING, WEB_VIEW_PAGE_LOAD_TIMEOUT, WEB_VIEW_CLIENT_RECEIVED_ERROR, INTERNET_UNAVAILABLE_AT_SHOW};
            a = arrcBImpressionError;
        }

        public static CBImpressionError valueOf(String string2) {
            return (CBImpressionError)Enum.valueOf(CBImpressionError.class, (String)string2);
        }

        public static CBImpressionError[] values() {
            return (CBImpressionError[])a.clone();
        }
    }

    public static final class a
    extends Enum<a> {
        public static final /* enum */ a a = new a();
        public static final /* enum */ a b = new a();
        public static final /* enum */ a c = new a();
        public static final /* enum */ a d = new a();
        public static final /* enum */ a e = new a();
        public static final /* enum */ a f = new a();
        public static final /* enum */ a g = new a();
        private static final /* synthetic */ a[] h;

        static {
            a[] arra = new a[]{a, b, c, d, e, f, g};
            h = arra;
        }

        public static a valueOf(String string2) {
            return (a)Enum.valueOf(a.class, (String)string2);
        }

        public static a[] values() {
            return (a[])h.clone();
        }
    }

}

