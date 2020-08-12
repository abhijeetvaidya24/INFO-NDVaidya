/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.presage.cf
 *  io.presage.dk
 *  java.lang.Boolean
 *  java.lang.Byte
 *  java.lang.Character
 *  java.lang.Class
 *  java.lang.Double
 *  java.lang.Float
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.Short
 *  java.lang.String
 *  java.lang.Void
 */
package io.presage;

import io.presage.ak;
import io.presage.cf;
import io.presage.dk;

public final class ca {
    public static final <T> Class<T> a(dk<T> dk2) {
        Class<Short> class_ = ((cf)dk2).a();
        if (!class_.isPrimitive()) {
            if (class_ != null) {
                return class_;
            }
            throw new ak("null cannot be cast to non-null type java.lang.Class<T>");
        }
        String string2 = class_.getName();
        if (string2 != null) {
            switch (string2.hashCode()) {
                default: {
                    break;
                }
                case 109413500: {
                    if (!string2.equals((Object)"short")) break;
                    class_ = Short.class;
                    break;
                }
                case 97526364: {
                    if (!string2.equals((Object)"float")) break;
                    class_ = Float.class;
                    break;
                }
                case 64711720: {
                    if (!string2.equals((Object)"boolean")) break;
                    class_ = Boolean.class;
                    break;
                }
                case 3625364: {
                    if (!string2.equals((Object)"void")) break;
                    class_ = Void.class;
                    break;
                }
                case 3327612: {
                    if (!string2.equals((Object)"long")) break;
                    class_ = Long.class;
                    break;
                }
                case 3052374: {
                    if (!string2.equals((Object)"char")) break;
                    class_ = Character.class;
                    break;
                }
                case 3039496: {
                    if (!string2.equals((Object)"byte")) break;
                    class_ = Byte.class;
                    break;
                }
                case 104431: {
                    if (!string2.equals((Object)"int")) break;
                    class_ = Integer.class;
                    break;
                }
                case -1325958191: {
                    if (!string2.equals((Object)"double")) break;
                    class_ = Double.class;
                }
            }
        }
        if (class_ != null) {
            return class_;
        }
        throw new ak("null cannot be cast to non-null type java.lang.Class<T>");
    }
}

