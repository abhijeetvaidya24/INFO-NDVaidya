/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  com.amazon.device.ads.MobileAdsLogger
 *  com.amazon.device.ads.Settings$TransientValue
 *  java.lang.Boolean
 *  java.lang.Class
 *  java.lang.Integer
 *  java.lang.InterruptedException
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 *  java.util.concurrent.ConcurrentHashMap
 *  java.util.concurrent.CountDownLatch
 *  java.util.concurrent.LinkedBlockingQueue
 *  java.util.concurrent.locks.ReentrantLock
 *  org.json.JSONObject
 */
package com.amazon.device.ads;

import android.content.Context;
import android.content.SharedPreferences;
import com.amazon.device.ads.DebugProperties;
import com.amazon.device.ads.JSONUtils;
import com.amazon.device.ads.MobileAdsLogger;
import com.amazon.device.ads.MobileAdsLoggerFactory;
import com.amazon.device.ads.Settings;
import com.amazon.device.ads.ThreadUtils;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONObject;

/*
 * Exception performing whole class analysis.
 */
class Settings {
    private static final String LOGTAG = "Settings";
    private static final String PREFS_NAME = "AmazonMobileAds";
    public static final String SETTING_ENABLE_WEBVIEW_PAUSE_LOGIC = "shouldPauseWebViewTimersInWebViewRelatedActivities";
    protected static final String SETTING_TESTING_ENABLED = "testingEnabled";
    protected static final String SETTING_TLS_ENABLED = "tlsEnabled";
    private static Settings instance;
    private final ConcurrentHashMap<String, Value> cache;
    private DebugProperties debugProperties;
    private JSONUtils.JSONUtilities jsonUtilities;
    private LinkedBlockingQueue<SettingsListener> listeners;
    private final MobileAdsLogger logger;
    private final CountDownLatch settingsLoadedLatch;
    private SharedPreferences sharedPreferences;
    private final ReentrantLock writeToSharedPreferencesLock;

    static {
        instance = new Settings();
    }

    public Settings() {
        this(new JSONUtils.JSONUtilities(), DebugProperties.getInstance());
    }

    Settings(JSONUtils.JSONUtilities jSONUtilities, DebugProperties debugProperties) {
        this.logger = new MobileAdsLoggerFactory().createMobileAdsLogger(LOGTAG);
        this.listeners = new LinkedBlockingQueue();
        this.writeToSharedPreferencesLock = new ReentrantLock();
        this.settingsLoadedLatch = new CountDownLatch(1);
        this.cache = new ConcurrentHashMap();
        this.jsonUtilities = jSONUtilities;
        this.debugProperties = debugProperties;
    }

    private void commit(SharedPreferences.Editor editor) {
        editor.apply();
    }

    public static Settings getInstance() {
        return instance;
    }

    private void putSetting(String string, Value value) {
        if (value.value == null) {
            this.logger.w("Could not set null value for setting: %s", new Object[]{string});
            return;
        }
        this.putSettingWithNoFlush(string, value);
        if (!value.isTransientData && this.isSettingsLoaded()) {
            this.flush();
        }
    }

    private void putSettingWithNoFlush(String string, Value value) {
        if (value.value == null) {
            this.logger.w("Could not set null value for setting: %s", new Object[]{string});
            return;
        }
        this.cache.put((Object)string, (Object)value);
    }

    private void writeCacheToSharedPreferences() {
        this.writeCacheToSharedPreferences(this.sharedPreferences);
    }

    void beginFetch(final Context context) {
        ThreadUtils.scheduleRunnable(new Runnable(){

            public void run() {
                Settings.this.fetchSharedPreferences(context);
            }
        });
    }

    void cacheAdditionalEntries(Map<String, ?> map) {
        for (Map.Entry entry : map.entrySet()) {
            String string = (String)entry.getKey();
            if (string == null || this.cache.containsKey((Object)string)) continue;
            Object object = entry.getValue();
            if (object != null) {
                this.cache.put((Object)string, (Object)new Value(object.getClass(), object));
                continue;
            }
            this.logger.w("Could not cache null value for SharedPreferences setting: %s", new Object[]{string});
        }
    }

    public boolean containsKey(String string) {
        return this.cache.containsKey((Object)string);
    }

    void contextReceived(Context context) {
        if (context == null) {
            return;
        }
        this.beginFetch(context);
    }

    void fetchSharedPreferences(Context context) {
        if (!this.isSettingsLoaded()) {
            SharedPreferences sharedPreferences = this.getSharedPreferencesFromContext(context);
            this.readSharedPreferencesIntoCache(sharedPreferences);
            this.sharedPreferences = sharedPreferences;
            this.writeCacheToSharedPreferences(sharedPreferences);
        }
        this.settingsLoadedLatch.countDown();
        this.notifySettingsListeners();
    }

    void flush() {
        this.writeCacheToSharedPreferences();
    }

    public Boolean getBoolean(String string, Boolean bl) {
        Value value = (Value)this.cache.get((Object)string);
        if (value == null) {
            return bl;
        }
        return (Boolean)value.value;
    }

    public boolean getBoolean(String string, boolean bl) {
        Boolean bl2 = this.getBoolean(string, null);
        if (bl2 == null) {
            return bl;
        }
        return bl2;
    }

    ConcurrentHashMap<String, Value> getCache() {
        return this.cache;
    }

    public int getInt(String string, int n) {
        Value value = (Value)this.cache.get((Object)string);
        if (value == null) {
            return n;
        }
        return (Integer)value.value;
    }

    public JSONObject getJSONObject(String string, JSONObject jSONObject) {
        Value value = (Value)this.cache.get((Object)string);
        if (value == null) {
            return jSONObject;
        }
        JSONObject jSONObject2 = this.jsonUtilities.getJSONObjectFromString((String)value.value);
        if (jSONObject2 != null) {
            return jSONObject2;
        }
        return jSONObject;
    }

    public long getLong(String string, long l2) {
        Value value = (Value)this.cache.get((Object)string);
        if (value == null) {
            return l2;
        }
        return (Long)value.value;
    }

    public <T> T getObject(String string, T t2, Class<T> class_) {
        Value value = (Value)this.cache.get((Object)string);
        if (value != null && class_.isInstance(value.value)) {
            return (T)value.value;
        }
        return t2;
    }

    SharedPreferences getSharedPreferences() {
        return this.sharedPreferences;
    }

    SharedPreferences getSharedPreferencesFromContext(Context context) {
        return context.getSharedPreferences(PREFS_NAME, 0);
    }

    public String getString(String string, String string2) {
        Value value = (Value)this.cache.get((Object)string);
        if (value == null) {
            return string2;
        }
        return (String)value.value;
    }

    public boolean getWrittenBoolean(String string, boolean bl) {
        if (this.isSettingsLoaded()) {
            return this.sharedPreferences.getBoolean(string, bl);
        }
        return bl;
    }

    public int getWrittenInt(String string, int n) {
        if (this.isSettingsLoaded()) {
            return this.sharedPreferences.getInt(string, n);
        }
        return n;
    }

    public JSONObject getWrittenJSONObject(String string, JSONObject jSONObject) {
        if (this.isSettingsLoaded()) {
            String string2 = this.sharedPreferences.getString(string, jSONObject.toString());
            return this.jsonUtilities.getJSONObjectFromString(string2);
        }
        return jSONObject;
    }

    public long getWrittenLong(String string, long l2) {
        if (this.isSettingsLoaded()) {
            return this.sharedPreferences.getLong(string, l2);
        }
        return l2;
    }

    public String getWrittenString(String string, String string2) {
        if (this.isSettingsLoaded()) {
            return this.sharedPreferences.getString(string, string2);
        }
        return string2;
    }

    public boolean isSettingsLoaded() {
        return this.sharedPreferences != null;
    }

    public void listenForSettings(SettingsListener settingsListener) {
        if (this.isSettingsLoaded()) {
            settingsListener.settingsLoaded();
            return;
        }
        try {
            this.listeners.put((Object)settingsListener);
            return;
        }
        catch (InterruptedException interruptedException) {
            MobileAdsLogger mobileAdsLogger = this.logger;
            Object[] arrobject = new Object[]{interruptedException.getMessage()};
            mobileAdsLogger.e("Interrupted exception while adding listener: %s", arrobject);
            return;
        }
    }

    void notifySettingsListeners() {
        SettingsListener settingsListener;
        while ((settingsListener = (SettingsListener)this.listeners.poll()) != null) {
            settingsListener.settingsLoaded();
        }
    }

    void putBoolean(String string, boolean bl) {
        this.putSetting(string, new Value(Boolean.class, bl));
    }

    void putBooleanWithNoFlush(String string, boolean bl) {
        this.putSettingWithNoFlush(string, new Value(Boolean.class, bl));
    }

    void putInt(String string, int n) {
        this.putSetting(string, new Value(Integer.class, n));
    }

    void putIntWithNoFlush(String string, int n) {
        this.putSettingWithNoFlush(string, new Value(Integer.class, n));
    }

    public void putJSONObject(String string, JSONObject jSONObject) {
        this.putSetting(string, new Value(String.class, jSONObject.toString()));
    }

    public void putJSONObjectWithNoFlush(String string, JSONObject jSONObject) {
        this.putSettingWithNoFlush(string, new Value(String.class, jSONObject.toString()));
    }

    void putLong(String string, long l2) {
        this.putSetting(string, new Value(Long.class, l2));
    }

    void putLongWithNoFlush(String string, long l2) {
        this.putSettingWithNoFlush(string, new Value(Long.class, l2));
    }

    void putString(String string, String string2) {
        this.putSetting(string, new Value(String.class, string2));
    }

    void putStringWithNoFlush(String string, String string2) {
        this.putSettingWithNoFlush(string, new Value(String.class, string2));
    }

    void putTransientBoolean(String string, boolean bl) {
        this.putSettingWithNoFlush(string, (Value)new /* Unavailable Anonymous Inner Class!! */);
    }

    void putTransientInt(String string, int n) {
        this.putSettingWithNoFlush(string, (Value)new /* Unavailable Anonymous Inner Class!! */);
    }

    public void putTransientJSONObject(String string, JSONObject jSONObject) {
        this.putSettingWithNoFlush(string, (Value)new /* Unavailable Anonymous Inner Class!! */);
    }

    void putTransientLong(String string, long l2) {
        this.putSettingWithNoFlush(string, (Value)new /* Unavailable Anonymous Inner Class!! */);
    }

    public void putTransientObject(String string, Object object) {
        this.putSettingWithNoFlush(string, (Value)new /* Unavailable Anonymous Inner Class!! */);
    }

    void putTransientString(String string, String string2) {
        this.putSettingWithNoFlush(string, (Value)new /* Unavailable Anonymous Inner Class!! */);
    }

    void readSharedPreferencesIntoCache(SharedPreferences sharedPreferences) {
        this.cacheAdditionalEntries(sharedPreferences.getAll());
    }

    void remove(String string) {
        Value value = (Value)this.cache.remove((Object)string);
        if (value != null && !value.isTransientData && this.isSettingsLoaded()) {
            this.flush();
        }
    }

    void removeWithNoFlush(String string) {
        this.cache.remove((Object)string);
    }

    void writeCacheToSharedPreferences(final SharedPreferences sharedPreferences) {
        ThreadUtils.scheduleRunnable(new Runnable(){

            public void run() {
                Settings.this.writeToSharedPreferencesLock.lock();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                for (Map.Entry entry : Settings.this.cache.entrySet()) {
                    Value value = (Value)entry.getValue();
                    if (value.isTransientData) continue;
                    if (value.clazz == String.class) {
                        editor.putString((String)entry.getKey(), (String)value.value);
                        continue;
                    }
                    if (value.clazz == Long.class) {
                        editor.putLong((String)entry.getKey(), ((Long)value.value).longValue());
                        continue;
                    }
                    if (value.clazz == Integer.class) {
                        editor.putInt((String)entry.getKey(), ((Integer)value.value).intValue());
                        continue;
                    }
                    if (value.clazz != Boolean.class) continue;
                    editor.putBoolean((String)entry.getKey(), ((Boolean)value.value).booleanValue());
                }
                Settings.this.commit(editor);
                Settings.this.writeToSharedPreferencesLock.unlock();
            }
        });
    }

    public static interface SettingsListener {
        public void settingsLoaded();
    }

    static final class SettingsStatics {
        static final String IU_SERVICE_LAST_CHECKIN = "amzn-ad-iu-last-checkin";
        static final String IU_SERVICE_LAST_CHECKIN_USING_SESSIONID = "amzn-ad-iu-last-checkin-using-sessionid";
        static final String VIEWABLE_JS_SETTINGS_NAME = "viewableJSSettingsNameAmazonAdSDK";
        static final String VIEWABLE_JS_VERSION_STORED = "viewableJSVersionStored";

        SettingsStatics() {
        }
    }

    class Value {
        public Class<?> clazz;
        public boolean isTransientData;
        public Object value;

        public Value(Class<?> class_, Object object) {
            this.clazz = class_;
            this.value = object;
        }
    }

}

