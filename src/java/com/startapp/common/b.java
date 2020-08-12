/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentFilter
 *  android.net.Uri
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.Message
 *  android.util.Log
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.HashMap
 *  java.util.Set
 */
package com.startapp.common;

import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class b {
    private static final Object f = new Object();
    private static b g;
    private final Context a;
    private final HashMap<BroadcastReceiver, ArrayList<IntentFilter>> b = new HashMap();
    private final HashMap<String, ArrayList<b>> c = new HashMap();
    private final ArrayList<a> d = new ArrayList();
    private final Handler e;

    private b(Context context) {
        this.a = context;
        this.e = new Handler(context.getMainLooper()){

            public void handleMessage(Message message) {
                if (message.what != 1) {
                    super.handleMessage(message);
                    return;
                }
                b.this.a();
            }
        };
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static b a(Context context) {
        Object object;
        Object object2 = object = f;
        synchronized (object2) {
            if (g != null) return g;
            g = new b(context.getApplicationContext());
            return g;
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    protected void a() {
        block4 : do {
            HashMap<BroadcastReceiver, ArrayList<IntentFilter>> hashMap;
            HashMap<BroadcastReceiver, ArrayList<IntentFilter>> hashMap2 = hashMap = this.b;
            // MONITORENTER : hashMap2
            int n2 = this.d.size();
            if (n2 <= 0) {
                // MONITOREXIT : hashMap2
                return;
            }
            Object[] arrobject = new a[n2];
            this.d.toArray(arrobject);
            this.d.clear();
            // MONITOREXIT : hashMap2
            int n3 = 0;
            do {
                if (n3 >= arrobject.length) continue block4;
                Object object = arrobject[n3];
                for (int i2 = 0; i2 < ((a)object).b.size(); ++i2) {
                    ((b)object.b.get((int)i2)).b.onReceive(this.a, ((a)object).a);
                }
                ++n3;
            } while (true);
            break;
        } while (true);
        {
            catch (Throwable throwable) {}
            {
                // MONITOREXIT : hashMap2
                throw throwable;
            }
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(BroadcastReceiver var1_1) {
        var13_3 = var2_2 = this.b;
        synchronized (var13_3) {
            block12 : {
                var4_4 = (ArrayList)this.b.remove((Object)var1_1);
                if (var4_4 == null) {
                    return;
                }
                var5_5 = 0;
                block4 : while (var5_5 < var4_4.size()) {
                    var6_6 = (IntentFilter)var4_4.get(var5_5);
                    var7_7 = 0;
lbl11: // 2 sources:
                    do {
                        if (var7_7 < var6_6.countActions()) {
                            var8_8 = var6_6.getAction(var7_7);
                            var9_9 = (ArrayList)this.c.get((Object)var8_8);
                            if (var9_9 == null) break block12;
                            var10_10 = 0;
                            ** break block13
                        }
                        ++var5_5;
                        continue block4;
                        break;
                    } while (true);
                }
                return;
lbl-1000: // 1 sources:
                {
                    
lbl22: // 2 sources:
                    do {
                        if (var10_10 < var9_9.size()) {
                            if (((b)var9_9.get((int)var10_10)).b == var1_1) {
                                var9_9.remove(var10_10);
                                --var10_10;
                            }
                            break;
                        }
                        if (var9_9.size() <= 0) {
                            this.c.remove((Object)var8_8);
                        }
                        break block12;
                        break;
                    } while (true);
                }
                ++var10_10;
                ** continue;
            }
            ++var7_7;
            ** continue;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        HashMap<BroadcastReceiver, ArrayList<IntentFilter>> hashMap;
        HashMap<BroadcastReceiver, ArrayList<IntentFilter>> hashMap2 = hashMap = this.b;
        synchronized (hashMap2) {
            b b2 = new b(intentFilter, broadcastReceiver);
            ArrayList arrayList = (ArrayList)this.b.get((Object)broadcastReceiver);
            if (arrayList == null) {
                arrayList = new ArrayList(1);
                this.b.put((Object)broadcastReceiver, (Object)arrayList);
            }
            arrayList.add((Object)intentFilter);
            for (int i2 = 0; i2 < intentFilter.countActions(); ++i2) {
                String string = intentFilter.getAction(i2);
                ArrayList arrayList2 = (ArrayList)this.c.get((Object)string);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList(1);
                    this.c.put((Object)string, (Object)arrayList2);
                }
                arrayList2.add((Object)b2);
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean a(Intent intent) {
        HashMap<BroadcastReceiver, ArrayList<IntentFilter>> hashMap;
        HashMap<BroadcastReceiver, ArrayList<IntentFilter>> hashMap2 = hashMap = this.b;
        synchronized (hashMap2) {
            ArrayList arrayList;
            String string = intent.getAction();
            String string2 = intent.resolveTypeIfNeeded(this.a.getContentResolver());
            Uri uri = intent.getData();
            String string3 = intent.getScheme();
            Set set = intent.getCategories();
            boolean bl = (8 & intent.getFlags()) != 0;
            if (bl) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Resolving type ");
                stringBuilder.append(string2);
                stringBuilder.append(" scheme ");
                stringBuilder.append(string3);
                stringBuilder.append(" of intent ");
                stringBuilder.append((Object)intent);
                Log.v((String)"LocalBroadcastManager", (String)stringBuilder.toString());
            }
            if ((arrayList = (ArrayList)this.c.get((Object)intent.getAction())) == null) return false;
            if (bl) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Action list: ");
                stringBuilder.append((Object)arrayList);
                Log.v((String)"LocalBroadcastManager", (String)stringBuilder.toString());
            }
            ArrayList arrayList2 = null;
            int n2 = 0;
            while (n2 < arrayList.size()) {
                int n3;
                String string4;
                ArrayList arrayList3;
                String string5;
                block15 : {
                    ArrayList arrayList4;
                    block16 : {
                        int n4;
                        block14 : {
                            block13 : {
                                b b2;
                                block12 : {
                                    b2 = (b)arrayList.get(n2);
                                    if (bl) {
                                        StringBuilder stringBuilder = new StringBuilder();
                                        stringBuilder.append("Matching against filter ");
                                        stringBuilder.append((Object)b2.a);
                                        Log.v((String)"LocalBroadcastManager", (String)stringBuilder.toString());
                                    }
                                    if (!b2.c) break block12;
                                    if (bl) {
                                        Log.v((String)"LocalBroadcastManager", (String)"  Filter's target already added");
                                    }
                                    break block13;
                                }
                                IntentFilter intentFilter = b2.a;
                                String string6 = string;
                                String string7 = string2;
                                string5 = string;
                                arrayList4 = arrayList2;
                                n3 = n2;
                                arrayList3 = arrayList;
                                string4 = string2;
                                n4 = intentFilter.match(string6, string7, string3, uri, set, "LocalBroadcastManager");
                                if (n4 < 0) break block14;
                                if (bl) {
                                    StringBuilder stringBuilder = new StringBuilder();
                                    stringBuilder.append("  Filter matched!  match=0x");
                                    stringBuilder.append(Integer.toHexString((int)n4));
                                    Log.v((String)"LocalBroadcastManager", (String)stringBuilder.toString());
                                }
                                arrayList2 = arrayList4 == null ? new ArrayList() : arrayList4;
                                arrayList2.add((Object)b2);
                                b2.c = true;
                                break block15;
                            }
                            n3 = n2;
                            arrayList3 = arrayList;
                            string5 = string;
                            string4 = string2;
                            arrayList4 = arrayList2;
                            break block16;
                        }
                        if (bl) {
                            String string8 = n4 != -4 ? (n4 != -3 ? (n4 != -2 ? (n4 != -1 ? "unknown reason" : "type") : "data") : "action") : "category";
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("  Filter did not match: ");
                            stringBuilder.append(string8);
                            Log.v((String)"LocalBroadcastManager", (String)stringBuilder.toString());
                        }
                    }
                    arrayList2 = arrayList4;
                }
                n2 = n3 + 1;
                string = string5;
                arrayList = arrayList3;
                string2 = string4;
            }
            ArrayList arrayList5 = arrayList2;
            if (arrayList5 == null) return false;
            for (int i2 = 0; i2 < arrayList5.size(); ++i2) {
                ((b)arrayList5.get((int)i2)).c = false;
            }
            this.d.add((Object)new a(intent, arrayList5));
            if (this.e.hasMessages(1)) return true;
            this.e.sendEmptyMessage(1);
            return true;
        }
    }

    private static class a {
        final Intent a;
        final ArrayList<b> b;

        a(Intent intent, ArrayList<b> arrayList) {
            this.a = intent;
            this.b = arrayList;
        }
    }

    private static class b {
        final IntentFilter a;
        final BroadcastReceiver b;
        boolean c;

        b(IntentFilter intentFilter, BroadcastReceiver broadcastReceiver) {
            this.a = intentFilter;
            this.b = broadcastReceiver;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder(128);
            stringBuilder.append("Receiver{");
            stringBuilder.append((Object)this.b);
            stringBuilder.append(" filter=");
            stringBuilder.append((Object)this.a);
            stringBuilder.append("}");
            return stringBuilder.toString();
        }
    }

}

