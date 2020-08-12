/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.PackageManager
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Message
 *  android.os.Messenger
 *  android.os.RemoteException
 *  java.lang.Boolean
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.List
 *  java.util.Set
 *  java.util.concurrent.ConcurrentHashMap
 *  java.util.concurrent.ConcurrentMap
 *  java.util.concurrent.CopyOnWriteArrayList
 *  java.util.concurrent.CopyOnWriteArraySet
 *  org.altbeacon.beacon.AltBeaconParser
 *  org.altbeacon.beacon.service.RunningAverageRssiFilter
 */
package org.altbeacon.beacon;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import org.altbeacon.beacon.AltBeaconParser;
import org.altbeacon.beacon.BeaconParser;
import org.altbeacon.beacon.MonitorNotifier;
import org.altbeacon.beacon.RangeNotifier;
import org.altbeacon.beacon.Region;
import org.altbeacon.beacon.logging.LogManager;
import org.altbeacon.beacon.service.BeaconService;
import org.altbeacon.beacon.service.MonitoringStatus;
import org.altbeacon.beacon.service.RunningAverageRssiFilter;
import org.altbeacon.beacon.service.ScanJobScheduler;
import org.altbeacon.beacon.service.SettingsData;
import org.altbeacon.beacon.service.StartRMData;
import org.altbeacon.beacon.service.scanner.NonBeaconLeScanCallback;
import org.altbeacon.beacon.simulator.BeaconSimulator;
import org.altbeacon.beacon.utils.ProcessUtils;

public class BeaconManager {
    private static final Object SINGLETON_LOCK = new Object();
    protected static BeaconSimulator beaconSimulator;
    protected static String distanceModelUpdateUrl;
    protected static Class rssiFilterImplClass;
    private static boolean sAndroidLScanningDisabled;
    private static long sExitRegionPeriod;
    protected static volatile BeaconManager sInstance;
    private static boolean sManifestCheckingDisabled;
    private long backgroundBetweenScanPeriod;
    private long backgroundScanPeriod;
    private final List<BeaconParser> beaconParsers = new CopyOnWriteArrayList();
    private final ConcurrentMap<Object, Object> consumers = new ConcurrentHashMap();
    protected RangeNotifier dataRequestNotifier = null;
    private long foregroundBetweenScanPeriod;
    private long foregroundScanPeriod;
    private boolean mBackgroundMode;
    private boolean mBackgroundModeUninitialized;
    private final Context mContext;
    private boolean mMainProcess;
    private NonBeaconLeScanCallback mNonBeaconLeScanCallback;
    private boolean mRegionStatePersistenceEnabled;
    private Boolean mScannerInSameProcess;
    private boolean mScheduledScanJobsEnabled;
    protected final Set<MonitorNotifier> monitorNotifiers = new CopyOnWriteArraySet();
    protected final Set<RangeNotifier> rangeNotifiers = new CopyOnWriteArraySet();
    private final ArrayList<Region> rangedRegions = new ArrayList();
    private Messenger serviceMessenger = null;

    static {
        sExitRegionPeriod = 10000L;
        distanceModelUpdateUrl = "http://data.altbeacon.org/android-distance.json";
        rssiFilterImplClass = RunningAverageRssiFilter.class;
    }

    protected BeaconManager(Context context) {
        boolean bl2;
        this.mRegionStatePersistenceEnabled = bl2 = true;
        this.mBackgroundMode = false;
        this.mBackgroundModeUninitialized = bl2;
        this.mMainProcess = false;
        this.mScannerInSameProcess = null;
        this.mScheduledScanJobsEnabled = false;
        this.foregroundScanPeriod = 1100L;
        this.foregroundBetweenScanPeriod = 0L;
        this.backgroundScanPeriod = 10000L;
        this.backgroundBetweenScanPeriod = 300000L;
        this.mContext = context.getApplicationContext();
        this.checkIfMainProcess();
        if (!sManifestCheckingDisabled) {
            this.verifyServiceDeclaration();
        }
        this.beaconParsers.add((Object)new AltBeaconParser());
        if (Build.VERSION.SDK_INT < 26) {
            bl2 = false;
        }
        this.mScheduledScanJobsEnabled = bl2;
    }

    @TargetApi(value=18)
    private void applyChangesToServices(int n2, Region region) throws RemoteException {
        if (this.mScheduledScanJobsEnabled) {
            ScanJobScheduler.getInstance().applySettingsToScheduledJob(this.mContext, this);
            return;
        }
        if (this.serviceMessenger != null) {
            Message message = Message.obtain(null, (int)n2, (int)0, (int)0);
            if (n2 == 6) {
                StartRMData startRMData = new StartRMData(this.getScanPeriod(), this.getBetweenScanPeriod(), this.mBackgroundMode);
                message.setData(startRMData.toBundle());
            } else if (n2 == 7) {
                message.setData(new SettingsData().collect(this.mContext).toBundle());
            } else {
                StartRMData startRMData = new StartRMData(region, this.callbackPackageName(), this.getScanPeriod(), this.getBetweenScanPeriod(), this.mBackgroundMode);
                message.setData(startRMData.toBundle());
            }
            this.serviceMessenger.send(message);
            return;
        }
        throw new RemoteException("The BeaconManager is not bound to the service.  Call beaconManager.bind(BeaconConsumer consumer) and wait for a callback to onBeaconServiceConnect()");
    }

    private String callbackPackageName() {
        String string = this.mContext.getPackageName();
        LogManager.d("BeaconManager", "callback packageName: %s", string);
        return string;
    }

    private boolean determineIfCalledFromSeparateScannerProcess() {
        if (this.isScannerInDifferentProcess() && !this.isMainProcess()) {
            LogManager.w("BeaconManager", "Ranging/Monitoring may not be controlled from a separate BeaconScanner process.  To remove this warning, please wrap this call in: if (beaconManager.isMainProcess())", new Object[0]);
            return true;
        }
        return false;
    }

    public static BeaconSimulator getBeaconSimulator() {
        return beaconSimulator;
    }

    private long getBetweenScanPeriod() {
        if (this.mBackgroundMode) {
            return this.backgroundBetweenScanPeriod;
        }
        return this.foregroundBetweenScanPeriod;
    }

    public static String getDistanceModelUpdateUrl() {
        return distanceModelUpdateUrl;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static BeaconManager getInstanceForApplication(Context context) {
        Object object;
        BeaconManager beaconManager = sInstance;
        if (beaconManager != null) {
            return beaconManager;
        }
        Object object2 = object = SINGLETON_LOCK;
        synchronized (object2) {
            BeaconManager beaconManager2 = sInstance;
            if (beaconManager2 == null) {
                sInstance = beaconManager2 = new BeaconManager(context);
            }
            return beaconManager2;
        }
    }

    public static long getRegionExitPeriod() {
        return sExitRegionPeriod;
    }

    public static Class getRssiFilterImplClass() {
        return rssiFilterImplClass;
    }

    private long getScanPeriod() {
        if (this.mBackgroundMode) {
            return this.backgroundScanPeriod;
        }
        return this.foregroundScanPeriod;
    }

    public static boolean isAndroidLScanningDisabled() {
        return sAndroidLScanningDisabled;
    }

    public static void setAndroidLScanningDisabled(boolean bl2) {
        sAndroidLScanningDisabled = bl2;
        BeaconManager beaconManager = sInstance;
        if (beaconManager != null) {
            beaconManager.applySettings();
        }
    }

    public static void setRegionExitPeriod(long l2) {
        sExitRegionPeriod = l2;
        BeaconManager beaconManager = sInstance;
        if (beaconManager != null) {
            beaconManager.applySettings();
        }
    }

    private void verifyServiceDeclaration() {
        List list = this.mContext.getPackageManager().queryIntentServices(new Intent(this.mContext, BeaconService.class), 65536);
        if (list != null) {
            if (!list.isEmpty()) {
                return;
            }
            throw new ServiceNotDeclaredException();
        }
    }

    public void applySettings() {
        if (this.determineIfCalledFromSeparateScannerProcess()) {
            return;
        }
        if (!this.isAnyConsumerBound()) {
            LogManager.d("BeaconManager", "Not synchronizing settings to service, as it has not started up yet", new Object[0]);
            return;
        }
        if (this.isScannerInDifferentProcess()) {
            LogManager.d("BeaconManager", "Synchronizing settings to service", new Object[0]);
            this.syncSettingsToService();
            return;
        }
        LogManager.d("BeaconManager", "Not synchronizing settings to service, as it is in the same process", new Object[0]);
    }

    protected void checkIfMainProcess() {
        ProcessUtils processUtils = new ProcessUtils(this.mContext);
        String string = processUtils.getProcessName();
        String string2 = processUtils.getPackageName();
        int n2 = processUtils.getPid();
        this.mMainProcess = processUtils.isMainProcess();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("BeaconManager started up on pid ");
        stringBuilder.append(n2);
        stringBuilder.append(" named '");
        stringBuilder.append(string);
        stringBuilder.append("' for application package '");
        stringBuilder.append(string2);
        stringBuilder.append("'.  isMainProcess=");
        stringBuilder.append(this.mMainProcess);
        LogManager.i("BeaconManager", stringBuilder.toString(), new Object[0]);
    }

    public long getBackgroundBetweenScanPeriod() {
        return this.backgroundBetweenScanPeriod;
    }

    public boolean getBackgroundMode() {
        return this.mBackgroundMode;
    }

    public long getBackgroundScanPeriod() {
        return this.backgroundScanPeriod;
    }

    public List<BeaconParser> getBeaconParsers() {
        return this.beaconParsers;
    }

    protected RangeNotifier getDataRequestNotifier() {
        return this.dataRequestNotifier;
    }

    public long getForegroundBetweenScanPeriod() {
        return this.foregroundBetweenScanPeriod;
    }

    public long getForegroundScanPeriod() {
        return this.foregroundScanPeriod;
    }

    public Collection<Region> getMonitoredRegions() {
        return MonitoringStatus.getInstanceForApplication(this.mContext).regions();
    }

    public Set<MonitorNotifier> getMonitoringNotifiers() {
        return Collections.unmodifiableSet(this.monitorNotifiers);
    }

    public NonBeaconLeScanCallback getNonBeaconLeScanCallback() {
        return this.mNonBeaconLeScanCallback;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Collection<Region> getRangedRegions() {
        ArrayList<Region> arrayList;
        ArrayList<Region> arrayList2 = arrayList = this.rangedRegions;
        synchronized (arrayList2) {
            return new ArrayList(this.rangedRegions);
        }
    }

    public Set<RangeNotifier> getRangingNotifiers() {
        return Collections.unmodifiableSet(this.rangeNotifiers);
    }

    public boolean getScheduledScanJobsEnabled() {
        return this.mScheduledScanJobsEnabled;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean isAnyConsumerBound() {
        ConcurrentMap<Object, Object> concurrentMap;
        ConcurrentMap<Object, Object> concurrentMap2 = concurrentMap = this.consumers;
        synchronized (concurrentMap2) {
            if (!this.consumers.isEmpty()) return false;
            if (this.serviceMessenger == null) return false;
            return true;
        }
    }

    public boolean isMainProcess() {
        return this.mMainProcess;
    }

    public boolean isRegionStatePersistenceEnabled() {
        return this.mRegionStatePersistenceEnabled;
    }

    public boolean isScannerInDifferentProcess() {
        Boolean bl2 = this.mScannerInSameProcess;
        return bl2 != null && bl2 == false;
    }

    public void setScannerInSameProcess(boolean bl2) {
        this.mScannerInSameProcess = bl2;
    }

    protected void syncSettingsToService() {
        if (this.mScheduledScanJobsEnabled) {
            ScanJobScheduler.getInstance().applySettingsToScheduledJob(this.mContext, this);
            return;
        }
        try {
            this.applyChangesToServices(7, null);
            return;
        }
        catch (RemoteException remoteException) {
            LogManager.e("BeaconManager", "Failed to sync settings to service", new Object[]{remoteException});
            return;
        }
    }

    public class ServiceNotDeclaredException
    extends RuntimeException {
        public ServiceNotDeclaredException() {
            super("The BeaconService is not properly declared in AndroidManifest.xml.  If using Eclipse, please verify that your project.properties has manifestmerger.enabled=true");
        }
    }

}

