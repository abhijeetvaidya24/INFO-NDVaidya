/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuffer
 *  java.lang.Throwable
 *  java.util.HashMap
 *  java.util.Map
 */
package com.tapjoy.internal;

import android.util.Log;
import com.tapjoy.internal.ij;
import com.tapjoy.internal.ik;
import java.util.HashMap;
import java.util.Map;

public final class ac {
    public static void a(int n2, String string2, String string3, Throwable throwable) {
        if (string3 != null) {
            Log.println((int)n2, (String)string2, (String)string3);
        }
        if (throwable != null) {
            Log.println((int)n2, (String)string2, (String)Log.getStackTraceString((Throwable)throwable));
        }
    }

    public static /* varargs */ void a(int n2, String string2, String string3, Object ... arrobject) {
        ij ij2;
        block4 : {
            Throwable throwable;
            int n3;
            block6 : {
                block5 : {
                    Object object;
                    throwable = arrobject != null && arrobject.length != 0 && (object = arrobject[arrobject.length - 1]) instanceof Throwable ? (Throwable)object : null;
                    if (string3 != null) break block5;
                    ij2 = new ij(null, arrobject, throwable);
                    break block4;
                }
                if (arrobject != null) break block6;
                ij2 = new ij(string3);
                break block4;
            }
            StringBuffer stringBuffer = new StringBuffer(50 + string3.length());
            int n4 = 0;
            for (n3 = 0; n3 < arrobject.length; ++n3) {
                int n5;
                block9 : {
                    int n6;
                    block10 : {
                        block7 : {
                            block8 : {
                                n6 = string3.indexOf("{}", n4);
                                if (n6 == -1) {
                                    if (n4 == 0) {
                                        ij2 = new ij(string3, arrobject, throwable);
                                    } else {
                                        stringBuffer.append(string3.substring(n4, string3.length()));
                                        ij2 = new ij(stringBuffer.toString(), arrobject, throwable);
                                    }
                                    break block4;
                                }
                                boolean bl2 = n6 != 0 && string3.charAt(n6 - 1) == '\\';
                                if (!bl2) break block7;
                                boolean bl3 = n6 >= 2 && string3.charAt(n6 - 2) == '\\';
                                if (bl3) break block8;
                                --n3;
                                stringBuffer.append(string3.substring(n4, n6 - 1));
                                stringBuffer.append('{');
                                n5 = n6 + 1;
                                break block9;
                            }
                            stringBuffer.append(string3.substring(n4, n6 - 1));
                            ik.a(stringBuffer, arrobject[n3], (Map)new HashMap());
                            break block10;
                        }
                        stringBuffer.append(string3.substring(n4, n6));
                        ik.a(stringBuffer, arrobject[n3], (Map)new HashMap());
                    }
                    n5 = n6 + 2;
                }
                n4 = n5;
            }
            stringBuffer.append(string3.substring(n4, string3.length()));
            ij2 = n3 < arrobject.length - 1 ? new ij(stringBuffer.toString(), arrobject, throwable) : new ij(stringBuffer.toString(), arrobject, null);
        }
        ac.a(n2, string2, ij2.b, ij2.c);
    }

    public static /* varargs */ void a(String string2, String string3, Object ... arrobject) {
        ac.a(6, string2, string3, arrobject);
    }
}

