/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  com.tapjoy.TapjoyLog
 *  com.tapjoy.TapjoyUtil
 *  java.io.File
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.UnsupportedOperationException
 *  java.util.Iterator
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 *  java.util.concurrent.ConcurrentHashMap
 */
package com.tapjoy;

import android.content.Context;
import android.content.SharedPreferences;
import com.tapjoy.TapjoyCachedAssetData;
import com.tapjoy.TapjoyLog;
import com.tapjoy.TapjoyUtil;
import java.io.File;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class TapjoyCacheMap
extends ConcurrentHashMap {
    private Context a;
    private int b = -1;

    public TapjoyCacheMap(Context context, int n2) {
        this.a = context;
        this.b = n2;
    }

    private String a() {
        Iterator iterator = this.entrySet().iterator();
        long l2 = -1L;
        String string = "";
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry)iterator.next();
            long l3 = ((TapjoyCachedAssetData)entry.getValue()).getTimestampInSeconds();
            if (l2 != 0L && l3 >= l2) continue;
            string = (String)entry.getKey();
            l2 = l3;
        }
        return string;
    }

    public void clear() {
        throw new UnsupportedOperationException();
    }

    public TapjoyCachedAssetData put(String string, TapjoyCachedAssetData tapjoyCachedAssetData) {
        StringBuilder stringBuilder = new StringBuilder("TapjoyCacheMap::put() -- key: ");
        stringBuilder.append(string);
        stringBuilder.append(" assetURL: ");
        stringBuilder.append(tapjoyCachedAssetData.getAssetURL());
        TapjoyLog.d((String)"TapjoyCacheMap", (String)stringBuilder.toString());
        if (tapjoyCachedAssetData == null) {
            return null;
        }
        if (tapjoyCachedAssetData.getTimeOfDeathInSeconds() <= System.currentTimeMillis() / 1000L) {
            return null;
        }
        if (this.size() == this.b) {
            this.remove(this.a());
        }
        SharedPreferences.Editor editor = this.a.getSharedPreferences("tapjoyCacheData", 0).edit();
        editor.putString(tapjoyCachedAssetData.getLocalFilePath(), tapjoyCachedAssetData.toRawJSONString());
        editor.commit();
        return (TapjoyCachedAssetData)super.put((Object)string, (Object)tapjoyCachedAssetData);
    }

    public TapjoyCachedAssetData remove(Object object) {
        if (this.containsKey(object)) {
            SharedPreferences.Editor editor = this.a.getSharedPreferences("tapjoyCacheData", 0).edit();
            editor.remove(((TapjoyCachedAssetData)this.get(object)).getLocalFilePath());
            editor.commit();
            String string = ((TapjoyCachedAssetData)this.get(object)).getLocalFilePath();
            if (string != null && string.length() > 0) {
                TapjoyUtil.deleteFileOrDirectory((File)new File(string));
            }
            StringBuilder stringBuilder = new StringBuilder("TapjoyCacheMap::remove() -- key: ");
            stringBuilder.append(object);
            TapjoyLog.d((String)"TapjoyCacheMap", (String)stringBuilder.toString());
            return (TapjoyCachedAssetData)super.remove(object);
        }
        return null;
    }

    public TapjoyCachedAssetData replace(String string, TapjoyCachedAssetData tapjoyCachedAssetData) {
        throw new UnsupportedOperationException();
    }

    public boolean replace(String string, TapjoyCachedAssetData tapjoyCachedAssetData, TapjoyCachedAssetData tapjoyCachedAssetData2) {
        throw new UnsupportedOperationException();
    }
}

