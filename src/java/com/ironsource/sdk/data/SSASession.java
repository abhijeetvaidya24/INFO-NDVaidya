/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package com.ironsource.sdk.data;

import android.content.Context;
import com.ironsource.environment.ConnectivityService;
import com.ironsource.sdk.utils.SDKUtils;

public class SSASession {
    public final String CONNECTIVITY = "connectivity";
    public final String SESSION_END_TIME = "sessionEndTime";
    public final String SESSION_START_TIME = "sessionStartTime";
    public final String SESSION_TYPE = "sessionType";
    private String connectivity;
    private long sessionEndTime;
    private long sessionStartTime;
    private SessionType sessionType;

    public SSASession(Context context, SessionType sessionType) {
        this.setSessionStartTime(SDKUtils.getCurrentTimeMillis());
        this.setSessionType(sessionType);
        this.setConnectivity(ConnectivityService.getConnectionType(context));
    }

    public void endSession() {
        this.setSessionEndTime(SDKUtils.getCurrentTimeMillis());
    }

    public String getConnectivity() {
        return this.connectivity;
    }

    public long getSessionEndTime() {
        return this.sessionEndTime;
    }

    public long getSessionStartTime() {
        return this.sessionStartTime;
    }

    public SessionType getSessionType() {
        return this.sessionType;
    }

    public void setConnectivity(String string) {
        this.connectivity = string;
    }

    public void setSessionEndTime(long l2) {
        this.sessionEndTime = l2;
    }

    public void setSessionStartTime(long l2) {
        this.sessionStartTime = l2;
    }

    public void setSessionType(SessionType sessionType) {
        this.sessionType = sessionType;
    }

    public static final class SessionType
    extends Enum<SessionType> {
        private static final /* synthetic */ SessionType[] $VALUES;
        public static final /* enum */ SessionType backFromBG;
        public static final /* enum */ SessionType launched;

        static {
            launched = new SessionType();
            backFromBG = new SessionType();
            SessionType[] arrsessionType = new SessionType[]{launched, backFromBG};
            $VALUES = arrsessionType;
        }

        public static SessionType valueOf(String string) {
            return (SessionType)Enum.valueOf(SessionType.class, (String)string);
        }

        public static SessionType[] values() {
            return (SessionType[])$VALUES.clone();
        }
    }

}

