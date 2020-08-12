/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.BaseBundle
 *  android.os.Bundle
 *  android.os.PersistableBundle
 *  java.lang.Class
 *  java.lang.Double
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.Iterator
 *  java.util.Set
 */
package com.appnext.base.b;

import android.os.BaseBundle;
import android.os.Bundle;
import android.os.PersistableBundle;
import java.util.Iterator;
import java.util.Set;

public final class a {
    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static PersistableBundle a(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        try {
            PersistableBundle persistableBundle = new PersistableBundle();
            Iterator iterator = bundle.keySet().iterator();
            do {
                if (!iterator.hasNext()) {
                    return persistableBundle;
                }
                String string2 = (String)iterator.next();
                Object object = bundle.get(string2);
                boolean bl = object instanceof PersistableBundle || object instanceof Integer || object instanceof int[] || object instanceof Long || object instanceof long[] || object instanceof Double || object instanceof double[] || object instanceof String || object instanceof String[];
                if (!bl) continue;
                if (object == null) {
                    throw new IllegalArgumentException("Unable to determine type of null values");
                }
                if (object instanceof Integer) {
                    persistableBundle.putInt(string2, ((Integer)object).intValue());
                    continue;
                }
                if (object instanceof int[]) {
                    persistableBundle.putIntArray(string2, (int[])object);
                    continue;
                }
                if (object instanceof Long) {
                    persistableBundle.putLong(string2, ((Long)object).longValue());
                    continue;
                }
                if (object instanceof long[]) {
                    persistableBundle.putLongArray(string2, (long[])object);
                    continue;
                }
                if (object instanceof Double) {
                    persistableBundle.putDouble(string2, ((Double)object).doubleValue());
                    continue;
                }
                if (object instanceof double[]) {
                    persistableBundle.putDoubleArray(string2, (double[])object);
                    continue;
                }
                if (object instanceof String) {
                    persistableBundle.putString(string2, (String)object);
                    continue;
                }
                if (object instanceof String[]) {
                    persistableBundle.putStringArray(string2, (String[])object);
                    continue;
                }
                if (!(object instanceof PersistableBundle)) {
                    StringBuilder stringBuilder = new StringBuilder("Objects of type ");
                    stringBuilder.append(object.getClass().getSimpleName());
                    stringBuilder.append(" can not be put into a ");
                    stringBuilder.append(BaseBundle.class.getSimpleName());
                    throw new IllegalArgumentException(stringBuilder.toString());
                }
                persistableBundle.putAll((PersistableBundle)object);
            } while (true);
        }
        catch (Throwable throwable) {
            return null;
        }
    }

    private static void a(PersistableBundle persistableBundle, String string2, Object object) throws IllegalArgumentException {
        if (object != null) {
            if (object instanceof Integer) {
                persistableBundle.putInt(string2, ((Integer)object).intValue());
                return;
            }
            if (object instanceof int[]) {
                persistableBundle.putIntArray(string2, (int[])object);
                return;
            }
            if (object instanceof Long) {
                persistableBundle.putLong(string2, ((Long)object).longValue());
                return;
            }
            if (object instanceof long[]) {
                persistableBundle.putLongArray(string2, (long[])object);
                return;
            }
            if (object instanceof Double) {
                persistableBundle.putDouble(string2, ((Double)object).doubleValue());
                return;
            }
            if (object instanceof double[]) {
                persistableBundle.putDoubleArray(string2, (double[])object);
                return;
            }
            if (object instanceof String) {
                persistableBundle.putString(string2, (String)object);
                return;
            }
            if (object instanceof String[]) {
                persistableBundle.putStringArray(string2, (String[])object);
                return;
            }
            if (object instanceof PersistableBundle) {
                persistableBundle.putAll((PersistableBundle)object);
                return;
            }
            StringBuilder stringBuilder = new StringBuilder("Objects of type ");
            stringBuilder.append(object.getClass().getSimpleName());
            stringBuilder.append(" can not be put into a ");
            stringBuilder.append(BaseBundle.class.getSimpleName());
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        throw new IllegalArgumentException("Unable to determine type of null values");
    }

    private static boolean b(Object object) {
        return object instanceof PersistableBundle || object instanceof Integer || object instanceof int[] || object instanceof Long || object instanceof long[] || object instanceof Double || object instanceof double[] || object instanceof String || object instanceof String[];
        {
        }
    }
}

