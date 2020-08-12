/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
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
 *  org.jetbrains.annotations.NotNull
 */
package a.a.b;

import a.a.b.b.b;
import a.a.h;
import org.jetbrains.annotations.NotNull;

public final class a {
    @NotNull
    public static final <T> Class<T> a(@NotNull a.a.d.b<T> b2) {
        a.a.b.b.h.b(b2, "$receiver");
        Object object = ((b)((Object)b2)).a();
        if (!object.isPrimitive()) {
            if (object != null) {
                return object;
            }
            throw new h("null cannot be cast to non-null type java.lang.Class<T>");
        }
        String string = object.getName();
        if (string != null) {
            switch (string.hashCode()) {
                default: {
                    break;
                }
                case 109413500: {
                    if (!string.equals((Object)"short")) break;
                    object = Short.class;
                    break;
                }
                case 97526364: {
                    if (!string.equals((Object)"float")) break;
                    object = Float.class;
                    break;
                }
                case 64711720: {
                    if (!string.equals((Object)"boolean")) break;
                    object = Boolean.class;
                    break;
                }
                case 3625364: {
                    if (!string.equals((Object)"void")) break;
                    object = Void.class;
                    break;
                }
                case 3327612: {
                    if (!string.equals((Object)"long")) break;
                    object = Long.class;
                    break;
                }
                case 3052374: {
                    if (!string.equals((Object)"char")) break;
                    object = Character.class;
                    break;
                }
                case 3039496: {
                    if (!string.equals((Object)"byte")) break;
                    object = Byte.class;
                    break;
                }
                case 104431: {
                    if (!string.equals((Object)"int")) break;
                    object = Integer.class;
                    break;
                }
                case -1325958191: {
                    if (!string.equals((Object)"double")) break;
                    object = Double.class;
                }
            }
        }
        if (object != null) {
            return object;
        }
        throw new h("null cannot be cast to non-null type java.lang.Class<T>");
    }
}

