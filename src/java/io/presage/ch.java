/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.OutOfMemoryError
 *  java.lang.String
 *  java.lang.Throwable
 *  java.lang.reflect.Array
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.Iterator
 */
package io.presage;

import io.presage.ak;
import io.presage.cl;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public final class ch {
    private static final Object[] a = new Object[0];

    public static final Object[] a(Collection<?> collection) {
        int n2 = collection.size();
        if (n2 == 0) {
            return a;
        }
        Iterator iterator = collection.iterator();
        if (!iterator.hasNext()) {
            return a;
        }
        Object[] arrobject = new Object[n2];
        int n3 = 0;
        do {
            int n4 = n3 + 1;
            arrobject[n3] = iterator.next();
            if (n4 >= arrobject.length) {
                if (!iterator.hasNext()) {
                    return arrobject;
                }
                int n5 = 1 + n4 * 3 >>> 1;
                if (n5 <= n4) {
                    if (n4 < 2147483645) {
                        n5 = 2147483645;
                    } else {
                        throw (Throwable)new OutOfMemoryError();
                    }
                }
                arrobject = Arrays.copyOf((Object[])arrobject, (int)n5);
                cl.a((Object)arrobject, "Arrays.copyOf(result, newSize)");
            } else if (!iterator.hasNext()) {
                Object[] arrobject2 = Arrays.copyOf((Object[])arrobject, (int)n4);
                cl.a((Object)arrobject2, "Arrays.copyOf(result, size)");
                return arrobject2;
            }
            n3 = n4;
        } while (true);
    }

    public static final Object[] a(Collection<?> collection, Object[] arrobject) {
        Throwable throwable;
        block16 : {
            block19 : {
                Object[] arrobject2;
                int n2;
                Iterator iterator;
                block18 : {
                    int n3;
                    block17 : {
                        if (arrobject == null) break block16;
                        n3 = collection.size();
                        n2 = 0;
                        if (n3 == 0) {
                            if (arrobject.length > 0) {
                                arrobject[0] = null;
                            }
                            return arrobject;
                        }
                        iterator = collection.iterator();
                        if (!iterator.hasNext()) {
                            if (arrobject.length > 0) {
                                arrobject[0] = null;
                            }
                            return arrobject;
                        }
                        if (n3 > arrobject.length) break block17;
                        arrobject2 = arrobject;
                        n2 = 0;
                        break block18;
                    }
                    Object object = Array.newInstance((Class)arrobject.getClass().getComponentType(), (int)n3);
                    if (object == null) break block19;
                    arrobject2 = (Object[])object;
                }
                do {
                    int n4 = n2 + 1;
                    arrobject2[n2] = iterator.next();
                    if (n4 >= arrobject2.length) {
                        if (!iterator.hasNext()) {
                            return arrobject2;
                        }
                        int n5 = 1 + n4 * 3 >>> 1;
                        if (n5 <= n4) {
                            if (n4 < 2147483645) {
                                n5 = 2147483645;
                            } else {
                                throw (Throwable)new OutOfMemoryError();
                            }
                        }
                        arrobject2 = Arrays.copyOf((Object[])arrobject2, (int)n5);
                        cl.a((Object)arrobject2, "Arrays.copyOf(result, newSize)");
                    } else if (!iterator.hasNext()) {
                        if (arrobject2 == arrobject) {
                            arrobject[n4] = null;
                            return arrobject;
                        }
                        Object[] arrobject3 = Arrays.copyOf((Object[])arrobject2, (int)n4);
                        cl.a((Object)arrobject3, "Arrays.copyOf(result, size)");
                        return arrobject3;
                    }
                    n2 = n4;
                } while (true);
            }
            throw new ak("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        }
        throwable = (Throwable)new NullPointerException();
        throw throwable;
    }
}

