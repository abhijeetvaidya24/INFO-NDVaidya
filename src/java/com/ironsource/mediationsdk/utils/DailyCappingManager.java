/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.ironsource.mediationsdk.logger.IronSourceLoggerManager
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.text.SimpleDateFormat
 *  java.util.Date
 *  java.util.GregorianCalendar
 *  java.util.HashMap
 *  java.util.Iterator
 *  java.util.Locale
 *  java.util.Map
 *  java.util.Random
 *  java.util.Set
 *  java.util.TimeZone
 *  java.util.Timer
 *  java.util.TimerTask
 */
package com.ironsource.mediationsdk.utils;

import android.content.Context;
import com.ironsource.mediationsdk.AbstractSmash;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.utils.DailyCappingListener;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TimeZone;
import java.util.Timer;
import java.util.TimerTask;

public class DailyCappingManager {
    private String mAdUnitName;
    private Context mContext;
    private DailyCappingListener mListener;
    private IronSourceLoggerManager mLogger;
    private Map<String, Integer> mSmashIdToCounter;
    private Map<String, String> mSmashIdToCounterDate;
    private Map<String, Integer> mSmashIdToMaxShowsPerDay;
    private Timer mTimer = null;

    public DailyCappingManager(String string, DailyCappingListener dailyCappingListener) {
        this.mAdUnitName = string;
        this.mListener = dailyCappingListener;
        this.mSmashIdToMaxShowsPerDay = new HashMap();
        this.mSmashIdToCounter = new HashMap();
        this.mSmashIdToCounterDate = new HashMap();
        this.mLogger = IronSourceLoggerManager.getLogger();
        this.scheduleTimer();
    }

    private int getCounter(String string) {
        if (this.mSmashIdToCounter.containsKey((Object)string)) {
            return (Integer)this.mSmashIdToCounter.get((Object)string);
        }
        int n2 = IronSourceUtils.getIntFromSharedPrefs(this.mContext, this.getCounterKeyName(string), 0);
        this.mSmashIdToCounter.put((Object)string, (Object)n2);
        return n2;
    }

    private String getCounterDate(String string) {
        if (this.mSmashIdToCounterDate.containsKey((Object)string)) {
            return (String)this.mSmashIdToCounterDate.get((Object)string);
        }
        String string2 = IronSourceUtils.getStringFromSharedPrefs(this.mContext, this.getDayKeyName(string), this.getTodayDate());
        this.mSmashIdToCounterDate.put((Object)string, (Object)string2);
        return string2;
    }

    private String getCounterKeyName(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append("_counter");
        return stringBuilder.toString();
    }

    private String getDayKeyName(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append("_day");
        return stringBuilder.toString();
    }

    private String getTodayDate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone((String)"UTC"));
        return simpleDateFormat.format(new Date());
    }

    private int getTodayShowCount(String string) {
        if (!this.getTodayDate().equalsIgnoreCase(this.getCounterDate(string))) {
            this.zeroCounter(string);
        }
        return this.getCounter(string);
    }

    private String getUniqueId(AbstractSmash abstractSmash) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.mAdUnitName);
        stringBuilder.append("_");
        stringBuilder.append(abstractSmash.getSubProviderId());
        stringBuilder.append("_");
        stringBuilder.append(abstractSmash.getName());
        return stringBuilder.toString();
    }

    private Date getUtcMidnight() {
        Random random = new Random();
        GregorianCalendar gregorianCalendar = new GregorianCalendar(TimeZone.getTimeZone((String)"UTC"), Locale.US);
        gregorianCalendar.set(11, 0);
        gregorianCalendar.set(12, random.nextInt(10));
        gregorianCalendar.set(13, random.nextInt(60));
        gregorianCalendar.set(14, random.nextInt(1000));
        gregorianCalendar.add(5, 1);
        return gregorianCalendar.getTime();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void onTimerTick() {
        DailyCappingManager dailyCappingManager = this;
        synchronized (dailyCappingManager) {
            try {
                try {
                    Iterator iterator = this.mSmashIdToMaxShowsPerDay.keySet().iterator();
                    while (iterator.hasNext()) {
                        this.zeroCounter((String)iterator.next());
                    }
                    this.mListener.onDailyCapReleased();
                    this.scheduleTimer();
                }
                catch (Exception exception) {
                    this.mLogger.logException(IronSourceLogger.IronSourceTag.INTERNAL, "onTimerTick", (Throwable)exception);
                }
                return;
            }
            catch (Throwable throwable2) {}
            throw throwable2;
        }
    }

    private void saveCounter(String string, int n2) {
        this.mSmashIdToCounter.put((Object)string, (Object)n2);
        this.mSmashIdToCounterDate.put((Object)string, (Object)this.getTodayDate());
        IronSourceUtils.saveIntToSharedPrefs(this.mContext, this.getCounterKeyName(string), n2);
        IronSourceUtils.saveStringToSharedPrefs(this.mContext, this.getDayKeyName(string), this.getTodayDate());
    }

    private void scheduleTimer() {
        Timer timer = this.mTimer;
        if (timer != null) {
            timer.cancel();
        }
        this.mTimer = new Timer();
        this.mTimer.schedule(new TimerTask(){

            public void run() {
                DailyCappingManager.this.onTimerTick();
            }
        }, this.getUtcMidnight());
    }

    private void zeroCounter(String string) {
        this.mSmashIdToCounter.put((Object)string, (Object)0);
        this.mSmashIdToCounterDate.put((Object)string, (Object)this.getTodayDate());
        IronSourceUtils.saveIntToSharedPrefs(this.mContext, this.getCounterKeyName(string), 0);
        IronSourceUtils.saveStringToSharedPrefs(this.mContext, this.getDayKeyName(string), this.getTodayDate());
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void addSmash(AbstractSmash abstractSmash) {
        DailyCappingManager dailyCappingManager = this;
        synchronized (dailyCappingManager) {
            try {
                try {
                    if (abstractSmash.getMaxAdsPerDay() != 99) {
                        this.mSmashIdToMaxShowsPerDay.put((Object)this.getUniqueId(abstractSmash), (Object)abstractSmash.getMaxAdsPerDay());
                    }
                }
                catch (Exception exception) {
                    this.mLogger.logException(IronSourceLogger.IronSourceTag.INTERNAL, "addSmash", (Throwable)exception);
                }
                return;
            }
            catch (Throwable throwable2) {}
            throw throwable2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void increaseShowCounter(AbstractSmash abstractSmash) {
        DailyCappingManager dailyCappingManager = this;
        synchronized (dailyCappingManager) {
            try {
                String string;
                block6 : {
                    string = this.getUniqueId(abstractSmash);
                    boolean bl2 = this.mSmashIdToMaxShowsPerDay.containsKey((Object)string);
                    if (bl2) break block6;
                    return;
                }
                try {
                    this.saveCounter(string, 1 + this.getTodayShowCount(string));
                }
                catch (Exception exception) {
                    this.mLogger.logException(IronSourceLogger.IronSourceTag.INTERNAL, "increaseShowCounter", (Throwable)exception);
                }
                return;
            }
            catch (Throwable throwable2) {}
            throw throwable2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean isCapped(AbstractSmash abstractSmash) {
        DailyCappingManager dailyCappingManager = this;
        synchronized (dailyCappingManager) {
            try {
                String string;
                block6 : {
                    try {
                        string = this.getUniqueId(abstractSmash);
                        boolean bl2 = this.mSmashIdToMaxShowsPerDay.containsKey((Object)string);
                        if (bl2) break block6;
                    }
                    catch (Exception exception) {
                        this.mLogger.logException(IronSourceLogger.IronSourceTag.INTERNAL, "isCapped", (Throwable)exception);
                        return false;
                    }
                    return false;
                }
                int n2 = (Integer)this.mSmashIdToMaxShowsPerDay.get((Object)string);
                int n3 = this.getTodayShowCount(string);
                boolean bl3 = false;
                if (n2 > n3) return bl3;
                return true;
            }
            catch (Throwable throwable) {}
            throw throwable;
        }
    }

    public void setContext(Context context) {
        this.mContext = context;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean shouldSendCapReleasedEvent(AbstractSmash abstractSmash) {
        DailyCappingManager dailyCappingManager = this;
        synchronized (dailyCappingManager) {
            try {
                String string;
                block8 : {
                    block7 : {
                        try {
                            string = this.getUniqueId(abstractSmash);
                            boolean bl2 = this.mSmashIdToMaxShowsPerDay.containsKey((Object)string);
                            if (bl2) break block7;
                        }
                        catch (Exception exception) {
                            this.mLogger.logException(IronSourceLogger.IronSourceTag.INTERNAL, "shouldSendCapReleasedEvent", (Throwable)exception);
                            return false;
                        }
                        return false;
                    }
                    boolean bl3 = this.getTodayDate().equalsIgnoreCase(this.getCounterDate(string));
                    if (!bl3) break block8;
                    return false;
                }
                int n2 = (Integer)this.mSmashIdToMaxShowsPerDay.get((Object)string);
                int n3 = this.getCounter(string);
                boolean bl4 = false;
                if (n2 > n3) return bl4;
                return true;
            }
            catch (Throwable throwable) {}
            throw throwable;
        }
    }

}

