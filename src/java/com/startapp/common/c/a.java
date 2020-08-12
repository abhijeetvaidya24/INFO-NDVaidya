/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Build
 *  android.os.Build$VERSION
 *  java.io.InputStream
 *  java.lang.Boolean
 *  java.lang.Byte
 *  java.lang.Character
 *  java.lang.Class
 *  java.lang.ClassNotFoundException
 *  java.lang.Deprecated
 *  java.lang.Double
 *  java.lang.Enum
 *  java.lang.Exception
 *  java.lang.Float
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Number
 *  java.lang.Object
 *  java.lang.Short
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Throwable
 *  java.lang.Void
 *  java.lang.annotation.Annotation
 *  java.lang.reflect.Array
 *  java.lang.reflect.Constructor
 *  java.lang.reflect.Field
 *  java.lang.reflect.Modifier
 *  java.net.HttpCookie
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.EnumSet
 *  java.util.HashMap
 *  java.util.HashSet
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 *  java.util.Set
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.startapp.common.c;

import android.os.Build;
import com.startapp.common.Constants;
import com.startapp.common.a.g;
import com.startapp.common.c.c;
import com.startapp.common.c.d;
import com.startapp.common.c.e;
import com.startapp.common.c.f;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.net.HttpCookie;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class a
extends InputStream {
    public static Map<String, Class> a = new HashMap();
    private InputStream b;
    private String c;

    static {
        a.put((Object)"int[]", Integer.class);
        a.put((Object)"long[]", Long.class);
        a.put((Object)"double[]", Double.class);
        a.put((Object)"float[]", Float.class);
        a.put((Object)"bool[]", Boolean.class);
        a.put((Object)"char[]", Character.class);
        a.put((Object)"byte[]", Byte.class);
        a.put((Object)"void[]", Void.class);
        a.put((Object)"short[]", Short.class);
    }

    public a(String string) {
        this.c = string;
        this.b = null;
    }

    private Enum<?> a(String string, Class class_) {
        return Enum.valueOf((Class)class_, (String)string);
    }

    private static Object a(Object object, Class<?> class_) {
        if (object.getClass().equals(class_)) {
            return object;
        }
        if (class_.equals(Integer.class)) {
            if (object.getClass().equals(Double.class)) {
                return ((Double)object).intValue();
            }
            if (object.getClass().equals(Long.class)) {
                return ((Long)object).intValue();
            }
        } else if (class_.equals(Long.class) && object.getClass().equals(Integer.class)) {
            object = ((Integer)object).longValue();
        }
        return object;
    }

    private <T> Object a(JSONObject jSONObject, Class<T> class_, Field field) {
        if (class_ != null) {
            return this.b(jSONObject, class_, field);
        }
        return this.a(jSONObject, field);
    }

    private Object a(JSONObject jSONObject, Field field) {
        JSONArray jSONArray = jSONObject.getJSONArray(c.a(field));
        int n2 = jSONArray.length();
        Class class_ = field.getType();
        Class class_2 = (Class)a.get((Object)class_.getSimpleName());
        Object object = Array.newInstance((Class)((Class)class_2.getField("TYPE").get(null)), (int)n2);
        for (int i2 = 0; i2 < n2; ++i2) {
            Object object2;
            String string = jSONArray.getString(i2);
            Class class_3 = String.class;
            if (class_2.equals(Character.class)) {
                class_3 = Character.TYPE;
            }
            Constructor constructor = class_2.getConstructor(new Class[]{class_3});
            if (class_2.equals(Character.class)) {
                Object[] arrobject = new Object[]{Character.valueOf((char)string.charAt(0))};
                object2 = constructor.newInstance(arrobject);
            } else {
                object2 = constructor.newInstance(new Object[]{string});
            }
            Array.set((Object)object, (int)i2, (Object)object2);
        }
        return object;
    }

    private static Object a(JSONObject jSONObject, Field field, Object object, Class<?> class_) {
        if (object.getClass().equals(class_)) {
            return object;
        }
        if (object.getClass().equals(String.class)) {
            if (class_.equals((Object)Integer.TYPE)) {
                return jSONObject.getInt(c.a(field));
            }
        } else {
            if (class_.equals((Object)Integer.TYPE)) {
                return ((Number)object).intValue();
            }
            if (class_.equals((Object)Float.TYPE)) {
                return Float.valueOf((float)((Number)object).floatValue());
            }
            if (class_.equals((Object)Long.TYPE)) {
                return ((Number)object).longValue();
            }
            if (class_.equals((Object)Double.TYPE)) {
                object = ((Number)object).doubleValue();
            }
        }
        return object;
    }

    /*
     * Exception decompiling
     */
    private static String a(InputStream var0, String var1_1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [6[SIMPLE_IF_TAKEN]], but top level block is 0[TRYBLOCK]
        // org.benf.cfr.reader.b.a.a.j.a(Op04StructuredStatement.java:432)
        // org.benf.cfr.reader.b.a.a.j.d(Op04StructuredStatement.java:484)
        // org.benf.cfr.reader.b.a.a.i.a(Op03SimpleStatement.java:607)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:692)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
        // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
        // org.benf.cfr.reader.b.a(Driver.java:128)
        // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
        // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
        // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
        // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1167)
        // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:641)
        // java.lang.Thread.run(Thread.java:919)
        throw new IllegalStateException("Decompilation failed");
    }

    private <K, V> Map<K, V> a(Class<K> class_, Class<V> class_2, Class class_3, Field field, JSONObject jSONObject, Iterator<K> iterator) {
        HashMap hashMap = new HashMap();
        while (iterator.hasNext()) {
            JSONObject jSONObject2;
            String string;
            Enum<?> enum_ = iterator.next();
            Object object = class_.equals(Integer.class) ? class_.cast((Object)Integer.parseInt((String)((String)((Object)enum_)))) : enum_;
            if (class_.isEnum()) {
                object = this.a(object.toString(), class_);
            }
            if ((jSONObject2 = jSONObject.optJSONObject(string = (String)((Object)enum_))) == null) {
                JSONArray jSONArray = jSONObject.optJSONArray(string);
                if (jSONArray == null) {
                    if (class_2.isEnum()) {
                        hashMap.put(object, this.a((String)jSONObject.get(string), class_2));
                        continue;
                    }
                    hashMap.put(object, jSONObject.get(string));
                    continue;
                }
                hashMap.put(object, this.a(class_3, jSONArray));
                continue;
            }
            hashMap.put(object, this.b(class_2, jSONObject2));
        }
        return hashMap;
    }

    private <V> Set a(Class<V> class_, Field field, JSONArray jSONArray) {
        HashSet hashSet = new HashSet();
        for (int i2 = 0; i2 < jSONArray.length(); ++i2) {
            hashSet.add(this.a(jSONArray.getString(i2), class_));
        }
        return hashSet;
    }

    private <V> Set<V> a(Class<V> class_, JSONArray jSONArray) {
        HashSet hashSet = new HashSet();
        for (int i2 = 0; i2 < jSONArray.length(); ++i2) {
            JSONObject jSONObject = jSONArray.optJSONObject(i2);
            if (jSONObject == null) {
                hashSet.add(jSONArray.get(i2));
                continue;
            }
            hashSet.add(this.b(class_, jSONObject));
        }
        return hashSet;
    }

    private <T> Field[] a(Class<T> class_, Field[] arrfield) {
        int n2 = arrfield.length;
        Field[] arrfield2 = class_.getSuperclass().getDeclaredFields();
        int n3 = arrfield2.length;
        Field[] arrfield3 = new Field[n2 + n3];
        System.arraycopy((Object)arrfield, (int)0, (Object)arrfield3, (int)0, (int)n2);
        System.arraycopy((Object)arrfield2, (int)0, (Object)arrfield3, (int)n2, (int)n3);
        return arrfield3;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private <T> T b(Class<T> var1_1, JSONObject var2_2) {
        block43 : {
            block42 : {
                if (this.b == null) {
                    if (this.c == null) throw new d("Can't read object, the input is null.");
                }
                if (this.c == null) {
                    try {
                        this.c = a.a(this.b, null);
                    }
                    catch (Exception var66_3) {
                        throw new d("Can't read input stream.", var66_3);
                    }
                }
                if (var2_2 == null) {
                    try {
                        var3_5 = var64_4 = new JSONObject(this.c);
                    }
                    catch (JSONException var65_6) {
                        throw new d("Can't deserialize the object. Failed to create JSON object.", var65_6);
                    }
                } else {
                    var3_5 = var2_2;
                }
                try {
                    var6_7 = (e)var1_1.getAnnotation(e.class);
                    var7_8 = Build.VERSION.SDK_INT;
                    var8_9 = true;
                    if (var7_8 >= 9 && var1_1.equals(HttpCookie.class)) {
                        var62_10 = var1_1.getDeclaredConstructors()[0];
                        var62_10.setAccessible(var8_9);
                        var63_11 = new Object[2];
                        var63_11[0] = "name";
                        var63_11[var8_9] = "value";
                        var10_12 = var62_10.newInstance(var63_11);
                    } else {
                        if (var1_1.isPrimitive()) {
                            return (T)var1_1.newInstance();
                        }
                        if (var1_1.getAnnotation(e.class) != null && !var6_7.c()) {
                            var52_13 = var6_7.c();
                            if (!var52_13) {
                                try {
                                    var55_14 = var3_5.getString(var6_7.a());
                                    var56_15 = var6_7.b();
                                    var57_16 = new StringBuilder();
                                    var57_16.append(var56_15);
                                    var57_16.append(".");
                                    var57_16.append(var55_14);
                                    var61_17 = this.b(Class.forName((String)var57_16.toString()), var3_5);
                                }
                                catch (JSONException var54_18) {
                                    throw new d("Problem instantiating object class ", var54_18);
                                }
                                catch (ClassNotFoundException var53_19) {
                                    throw new d("Problem instantiating object class ", var53_19);
                                }
                                return var61_17;
                            }
                            break block42;
                        }
                        var9_20 = var1_1.getDeclaredConstructor(new Class[0]);
                        var9_20.setAccessible(var8_9);
                        var10_12 = var9_20.newInstance(new Object[0]);
                    }
                    var11_21 = var10_12;
                    break block43;
                }
                catch (Exception var4_61) {
                    var5_62 = new d("Can't deserialize the object. Failed to instantiate object.", var4_61);
                    throw var5_62;
                }
            }
            var11_21 = null;
        }
        var12_22 = var1_1.getDeclaredFields();
        if (var6_7 != null && var6_7.c()) {
            var12_22 = this.a(var1_1, var12_22);
        }
        var13_23 = var12_22;
        var14_24 = var13_23.length;
        var15_25 = 0;
        while (var15_25 < var14_24) {
            block44 : {
                block45 : {
                    var16_26 = var13_23[var15_25];
                    var17_27 = var16_26.getModifiers();
                    if (Modifier.isStatic((int)var17_27) || Modifier.isTransient((int)var17_27)) break block45;
                    var22_32 = c.a(var16_26);
                    try {
                        try {
                            if (!var3_5.has(var22_32)) ** GOTO lbl-1000
                            var16_26.setAccessible(var8_9);
                            if (var16_26.getDeclaredAnnotations().length <= 0 || !(var48_56 = var16_26.getDeclaredAnnotations()[0]).annotationType().equals(f.class)) ** GOTO lbl92
                            var49_57 = (f)var48_56;
                            var28_39 = var49_57.b();
                            var29_40 = var49_57.d();
                            var50_58 = var49_57.c();
                            var31_42 = var49_57.a();
                            var51_59 = var49_57.e();
                            var32_43 = var50_58;
                            var30_41 = var51_59;
                            var27_38 = true;
                            ** GOTO lbl98
lbl-1000: // 1 sources:
                            {
                                var24_36 = var22_32;
                                var18_28 = var15_25;
                                var19_29 = var14_24;
                                var20_30 = var13_23;
                                var21_31 = var11_21;
                                if (Constants.a().booleanValue()) {
                                    g.a("JSONInputStream", 4, String.format((String)"Field [%s] doesn't exist. Keeping default value.", (Object[])new Object[]{var24_36}));
                                }
                                break block44;
lbl92: // 1 sources:
                                var27_38 = false;
                                var28_39 = null;
                                var29_40 = null;
                                var30_41 = null;
                                var31_42 = false;
                                var32_43 = null;
lbl98: // 2 sources:
                                if (var16_26.getType().getAnnotation(e.class) != null) {
                                    var41_52 = (e)var16_26.getType().getAnnotation(e.class);
                                    var42_53 = var3_5.getJSONObject(var22_32).getString(var41_52.a());
                                    var43_54 = var41_52.b();
                                    var44_55 = new StringBuilder();
                                    var44_55.append(var43_54);
                                    var44_55.append(".");
                                    var44_55.append(var42_53);
                                    var16_26.set(var11_21, this.b(Class.forName((String)var44_55.toString()), var3_5.getJSONObject(var22_32)));
                                    break block45;
                                }
                                if (var31_42) {
                                    var16_26.set(var11_21, this.b(var16_26.getType(), var3_5.getJSONObject(var22_32)));
                                    break block45;
                                }
                                if (!var27_38 || !Map.class.isAssignableFrom(var28_39) && !Collection.class.isAssignableFrom(var28_39)) break block46;
                                if (!var28_39.equals(HashMap.class)) break block47;
                                var35_46 = var3_5.getJSONObject(var22_32);
                                var36_47 = var35_46.keys();
                                var37_48 = var29_40;
                                var24_36 = var22_32;
                                var38_49 = var32_43;
                                var18_28 = var15_25;
                                var39_50 = var30_41;
                                var19_29 = var14_24;
                                var20_30 = var13_23;
                                var21_31 = var11_21;
                            }
                        }
                        catch (Exception var23_35) {
                            var24_36 = var22_32;
                            var18_28 = var15_25;
                            var19_29 = var14_24;
                            var20_30 = var13_23;
                            var21_31 = var11_21;
                        }
                        {
                            block46 : {
                                block47 : {
                                    ** try [egrp 6[TRYBLOCK] [23 : 812->1194)] { 
lbl131: // 1 sources:
                                    var16_26.set(var21_31, this.a(var37_48, var38_49, var39_50, var16_26, var35_46, var36_47));
                                    break block44;
                                }
                                var24_36 = var22_32;
                                var18_28 = var15_25;
                                var19_29 = var14_24;
                                var20_30 = var13_23;
                                var21_31 = var11_21;
                                if (var28_39.equals(ArrayList.class)) {
                                    var34_45 = var3_5.getJSONArray(var24_36);
                                    var16_26.set(var21_31, this.b(var32_43, var16_26, var34_45));
                                } else {
                                    var33_44 = var32_43;
                                    if (var28_39.equals(HashSet.class)) {
                                        var16_26.set(var21_31, this.a(var33_44, var3_5.getJSONArray(var24_36)));
                                    } else if (var28_39.equals(EnumSet.class)) {
                                        var16_26.set(var21_31, (Object)this.a(var33_44, var16_26, var3_5.getJSONArray(var24_36)));
                                    }
                                }
                                break block44;
                            }
                            var24_36 = var22_32;
                            var18_28 = var15_25;
                            var19_29 = var14_24;
                            var20_30 = var13_23;
                            var21_31 = var11_21;
                            if (var16_26.getType().isEnum()) {
                                var16_26.set(var21_31, this.a((String)var3_5.get(var24_36), var28_39));
                            } else if (var16_26.getType().isPrimitive()) {
                                var16_26.set(var21_31, a.a(var3_5, var16_26, var3_5.get(var24_36), var16_26.getType()));
                            } else if (var16_26.getType().isArray()) {
                                var16_26.set(var21_31, this.a(var3_5, var28_39, var16_26));
                            } else {
                                var40_51 = a.a(var3_5.get(var24_36), var16_26.getType());
                                if (var40_51.equals(null)) {
                                    var16_26.set(var21_31, null);
                                } else {
                                    var16_26.set(var21_31, var40_51);
                                }
                            }
                            break block44;
                        }
lbl171: // 1 sources:
                        catch (Exception var23_34) {
                        }
                    }
                    catch (Throwable var26_60) {
                        throw new d("Unknown error occurred ", var26_60);
                    }
                    var25_37 = new Object[]{var24_36, var23_33.toString()};
                    g.a("JSONInputStream", 6, String.format((String)"Failed to get field [%s] %s", (Object[])var25_37));
                    break block44;
                }
                var18_28 = var15_25;
                var19_29 = var14_24;
                var20_30 = var13_23;
                var21_31 = var11_21;
            }
            var15_25 = var18_28 + 1;
            var11_21 = var21_31;
            var14_24 = var19_29;
            var13_23 = var20_30;
            var8_9 = true;
        }
        return (T)var11_21;
    }

    private <V> List<V> b(Class<V> class_, Field field, JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < jSONArray.length(); ++i2) {
            JSONObject jSONObject = jSONArray.optJSONObject(i2);
            if (jSONObject == null) {
                arrayList.add(jSONArray.get(i2));
                continue;
            }
            arrayList.add(this.b(class_, jSONObject));
        }
        return arrayList;
    }

    private <T> T[] b(JSONObject jSONObject, Class<T> class_, Field field) {
        JSONArray jSONArray = jSONObject.getJSONArray(c.a(field));
        int n2 = jSONArray.length();
        Object object = Array.newInstance(class_, (int)n2);
        for (int i2 = 0; i2 < n2; ++i2) {
            Array.set((Object)object, (int)i2, this.b(class_, jSONArray.getJSONObject(i2)));
        }
        return (Object[])object;
    }

    public final <T> T a(Class<T> class_, JSONObject jSONObject) {
        T t;
        try {
            t = this.b(class_, jSONObject);
        }
        catch (d d2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Error while trying to parse object ");
            stringBuilder.append(class_.toString());
            g.a("JSONInputStream", 6, stringBuilder.toString(), (Throwable)((Object)d2));
            return null;
        }
        return t;
    }

    public void close() {
        super.close();
        InputStream inputStream = this.b;
        if (inputStream != null) {
            inputStream.close();
        }
    }

    @Deprecated
    public final int read() {
        return 0;
    }
}

