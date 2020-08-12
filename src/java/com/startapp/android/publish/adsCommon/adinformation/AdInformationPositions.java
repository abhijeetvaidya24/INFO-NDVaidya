/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.widget.RelativeLayout
 *  android.widget.RelativeLayout$LayoutParams
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package com.startapp.android.publish.adsCommon.adinformation;

import android.widget.RelativeLayout;

public class AdInformationPositions {
    protected static final String a = Position.BOTTOM_LEFT.name();

    public static final class Position
    extends Enum<Position> {
        private static final /* synthetic */ Position[] $VALUES;
        public static final /* enum */ Position BOTTOM_LEFT;
        public static final /* enum */ Position BOTTOM_RIGHT;
        public static final /* enum */ Position TOP_LEFT;
        public static final /* enum */ Position TOP_RIGHT;
        private int animationMultiplier;
        private int index;
        private int[] rules;

        static {
            Position position;
            Position position2;
            Position position3;
            Position position4;
            TOP_LEFT = position2 = new Position(1, new int[]{10, 9}, -1);
            TOP_RIGHT = position = new Position(2, new int[]{10, 11}, 1);
            BOTTOM_LEFT = position3 = new Position(3, new int[]{12, 9}, -1);
            BOTTOM_RIGHT = position4 = new Position(4, new int[]{12, 11}, 1);
            Position[] arrposition = new Position[]{TOP_LEFT, TOP_RIGHT, BOTTOM_LEFT, BOTTOM_RIGHT};
            $VALUES = arrposition;
        }

        private Position(int n3, int[] arrn, int n4) {
            this.rules = arrn;
            this.animationMultiplier = n4;
            this.index = n3;
        }

        public static Position getByIndex(long l2) {
            Position position = BOTTOM_LEFT;
            Position[] arrposition = Position.values();
            for (int j = 0; j < arrposition.length; ++j) {
                if ((long)arrposition[j].getIndex() != l2) continue;
                position = arrposition[j];
            }
            return position;
        }

        public static Position getByName(String string) {
            Position position = BOTTOM_LEFT;
            Position[] arrposition = Position.values();
            for (int j = 0; j < arrposition.length; ++j) {
                if (arrposition[j].name().toLowerCase().compareTo(string.toLowerCase()) != 0) continue;
                position = arrposition[j];
            }
            return position;
        }

        public static Position valueOf(String string) {
            return (Position)Enum.valueOf(Position.class, (String)string);
        }

        public static Position[] values() {
            return (Position[])$VALUES.clone();
        }

        public void addRules(RelativeLayout.LayoutParams layoutParams) {
            int[] arrn;
            for (int j = 0; j < (arrn = this.rules).length; ++j) {
                layoutParams.addRule(arrn[j]);
            }
        }

        public int getAnimationStartMultiplier() {
            return this.animationMultiplier;
        }

        public int getIndex() {
            return this.index;
        }
    }

}

