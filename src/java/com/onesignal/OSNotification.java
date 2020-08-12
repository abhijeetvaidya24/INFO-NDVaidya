/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 */
package com.onesignal;

import com.onesignal.OSNotificationPayload;
import java.util.List;

public class OSNotification {
    public int androidNotificationId;
    public DisplayType displayType;
    public List<OSNotificationPayload> groupedNotifications;
    public boolean isAppInFocus;
    public OSNotificationPayload payload;
    public boolean shown;

    public static final class DisplayType
    extends Enum<DisplayType> {
        private static final /* synthetic */ DisplayType[] $VALUES;
        public static final /* enum */ DisplayType InAppAlert;
        public static final /* enum */ DisplayType None;
        public static final /* enum */ DisplayType Notification;

        static {
            Notification = new DisplayType();
            InAppAlert = new DisplayType();
            None = new DisplayType();
            DisplayType[] arrdisplayType = new DisplayType[]{Notification, InAppAlert, None};
            $VALUES = arrdisplayType;
        }

        public static DisplayType valueOf(String string2) {
            return (DisplayType)Enum.valueOf(DisplayType.class, (String)string2);
        }

        public static DisplayType[] values() {
            return (DisplayType[])$VALUES.clone();
        }
    }

}

