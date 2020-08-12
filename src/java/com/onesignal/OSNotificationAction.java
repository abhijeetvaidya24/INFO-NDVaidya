/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package com.onesignal;

public class OSNotificationAction {
    public String actionID;
    public ActionType type;

    public static final class ActionType
    extends Enum<ActionType> {
        private static final /* synthetic */ ActionType[] $VALUES;
        public static final /* enum */ ActionType ActionTaken;
        public static final /* enum */ ActionType Opened;

        static {
            Opened = new ActionType();
            ActionTaken = new ActionType();
            ActionType[] arractionType = new ActionType[]{Opened, ActionTaken};
            $VALUES = arractionType;
        }

        public static ActionType valueOf(String string2) {
            return (ActionType)Enum.valueOf(ActionType.class, (String)string2);
        }

        public static ActionType[] values() {
            return (ActionType[])$VALUES.clone();
        }
    }

}

