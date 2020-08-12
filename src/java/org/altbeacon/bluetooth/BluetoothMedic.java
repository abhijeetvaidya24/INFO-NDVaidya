/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Notification
 *  android.app.NotificationManager
 *  android.app.PendingIntent
 *  android.app.TaskStackBuilder
 *  android.bluetooth.BluetoothAdapter
 *  android.bluetooth.BluetoothManager
 *  android.bluetooth.le.AdvertiseCallback
 *  android.bluetooth.le.AdvertiseData
 *  android.bluetooth.le.AdvertiseData$Builder
 *  android.bluetooth.le.AdvertiseSettings
 *  android.bluetooth.le.AdvertiseSettings$Builder
 *  android.bluetooth.le.BluetoothLeAdvertiser
 *  android.bluetooth.le.BluetoothLeScanner
 *  android.bluetooth.le.ScanCallback
 *  android.bluetooth.le.ScanResult
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Handler
 *  androidx.core.app.NotificationCompat
 *  androidx.core.app.NotificationCompat$Builder
 *  androidx.localbroadcastmanager.content.LocalBroadcastManager
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.IllegalStateException
 *  java.lang.InterruptedException
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Thread
 *  java.util.List
 */
package org.altbeacon.bluetooth;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.bluetooth.le.AdvertiseCallback;
import android.bluetooth.le.AdvertiseData;
import android.bluetooth.le.AdvertiseSettings;
import android.bluetooth.le.BluetoothLeAdvertiser;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanResult;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import androidx.core.app.NotificationCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import java.util.List;
import org.altbeacon.beacon.logging.LogManager;

public class BluetoothMedic {
    private static final String TAG = "BluetoothMedic";
    private static BluetoothMedic sInstance;
    private BluetoothAdapter mAdapter;
    private BroadcastReceiver mBluetoothEventReceiver = new BroadcastReceiver(){

        public void onReceive(Context context, Intent intent) {
            LogManager.d(TAG, "Broadcast notification received.", new Object[0]);
            String string = intent.getAction();
            if (string != null) {
                if (string.equalsIgnoreCase("onScanFailed")) {
                    if (intent.getIntExtra("errorCode", -1) == 2) {
                        BluetoothMedic.this.sendNotification(context, "scan failed", "Power cycling bluetooth");
                        LogManager.d(TAG, "Detected a SCAN_FAILED_APPLICATION_REGISTRATION_FAILED.  We need to cycle bluetooth to recover", new Object[0]);
                        if (!BluetoothMedic.this.cycleBluetoothIfNotTooSoon()) {
                            BluetoothMedic.this.sendNotification(context, "scan failed", "Cannot power cycle bluetooth again");
                            return;
                        }
                    }
                } else if (string.equalsIgnoreCase("onStartFailed")) {
                    if (intent.getIntExtra("errorCode", -1) == 4) {
                        BluetoothMedic.this.sendNotification(context, "advertising failed", "Expected failure.  Power cycling.");
                        if (!BluetoothMedic.this.cycleBluetoothIfNotTooSoon()) {
                            BluetoothMedic.this.sendNotification(context, "advertising failed", "Cannot power cycle bluetooth again");
                            return;
                        }
                    }
                } else {
                    LogManager.d(TAG, "Unknown event.", new Object[0]);
                }
            }
        }
    };
    private Handler mHandler = new Handler();
    private long mLastBluetoothPowerCycleTime = 0L;
    private LocalBroadcastManager mLocalBroadcastManager;
    private int mNotificationIcon = 0;
    private boolean mNotificationsEnabled = false;
    private Boolean mScanTestResult = null;
    private int mTestType = 0;
    private Boolean mTransmitterTestResult = null;

    private BluetoothMedic() {
    }

    private void cycleBluetooth() {
        LogManager.d(TAG, "Power cycling bluetooth", new Object[0]);
        LogManager.d(TAG, "Turning Bluetooth off.", new Object[0]);
        BluetoothAdapter bluetoothAdapter = this.mAdapter;
        if (bluetoothAdapter != null) {
            bluetoothAdapter.disable();
            this.mHandler.postDelayed(new Runnable(){

                public void run() {
                    LogManager.d(TAG, "Turning Bluetooth back on.", new Object[0]);
                    if (BluetoothMedic.this.mAdapter != null) {
                        BluetoothMedic.this.mAdapter.enable();
                    }
                }
            }, 1000L);
            return;
        }
        LogManager.w(TAG, "Cannot cycle bluetooth.  Manager is null.", new Object[0]);
    }

    private boolean cycleBluetoothIfNotTooSoon() {
        long l2 = System.currentTimeMillis() - this.mLastBluetoothPowerCycleTime;
        if (l2 < 60000L) {
            String string = TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Not cycling bluetooth because we just did so ");
            stringBuilder.append(l2);
            stringBuilder.append(" milliseconds ago.");
            LogManager.d(string, stringBuilder.toString(), new Object[0]);
            return false;
        }
        this.mLastBluetoothPowerCycleTime = System.currentTimeMillis();
        LogManager.d(TAG, "Power cycling bluetooth", new Object[0]);
        this.cycleBluetooth();
        return true;
    }

    public static BluetoothMedic getInstance() {
        if (sInstance == null) {
            sInstance = new BluetoothMedic();
        }
        return sInstance;
    }

    private void initializeWithContext(Context context) {
        block3 : {
            block2 : {
                if (this.mAdapter != null && this.mLocalBroadcastManager != null) break block2;
                BluetoothManager bluetoothManager = (BluetoothManager)context.getSystemService("bluetooth");
                if (bluetoothManager == null) break block3;
                this.mAdapter = bluetoothManager.getAdapter();
                this.mLocalBroadcastManager = LocalBroadcastManager.getInstance((Context)context);
            }
            return;
        }
        throw new NullPointerException("Cannot get BluetoothManager");
    }

    private void sendNotification(Context context, String string, String string2) {
        this.initializeWithContext(context);
        if (this.mNotificationsEnabled) {
            NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "err");
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("BluetoothMedic: ");
            stringBuilder.append(string);
            NotificationCompat.Builder builder2 = builder.setContentTitle((CharSequence)stringBuilder.toString()).setSmallIcon(this.mNotificationIcon).setVibrate(new long[]{200L, 100L, 200L}).setContentText((CharSequence)string2);
            TaskStackBuilder taskStackBuilder = TaskStackBuilder.create((Context)context);
            taskStackBuilder.addNextIntent(new Intent("NoOperation"));
            builder2.setContentIntent(taskStackBuilder.getPendingIntent(0, 134217728));
            NotificationManager notificationManager = (NotificationManager)context.getSystemService("notification");
            if (notificationManager != null) {
                notificationManager.notify(1, builder2.build());
            }
        }
    }

    /*
     * Exception decompiling
     */
    public boolean runScanTest(Context var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl67 : GETSTATIC : trying to set 1 previously set to 0
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
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

    public boolean runTransmitterTest(final Context context) {
        this.initializeWithContext(context);
        this.mTransmitterTestResult = null;
        long l2 = System.currentTimeMillis();
        BluetoothAdapter bluetoothAdapter = this.mAdapter;
        if (bluetoothAdapter != null) {
            final BluetoothLeAdvertiser bluetoothLeAdvertiser = bluetoothAdapter.getBluetoothLeAdvertiser();
            if (bluetoothLeAdvertiser != null) {
                AdvertiseSettings advertiseSettings = new AdvertiseSettings.Builder().setAdvertiseMode(0).build();
                AdvertiseData advertiseData = new AdvertiseData.Builder().addManufacturerData(0, new byte[]{0}).build();
                LogManager.i(TAG, "Starting transmitter test", new Object[0]);
                bluetoothLeAdvertiser.startAdvertising(advertiseSettings, advertiseData, new AdvertiseCallback(){

                    public void onStartFailure(int n2) {
                        super.onStartFailure(n2);
                        Intent intent = new Intent("onStartFailed");
                        intent.putExtra("errorCode", n2);
                        String string = TAG;
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Sending onStartFailure broadcast with ");
                        stringBuilder.append((Object)BluetoothMedic.this.mLocalBroadcastManager);
                        LogManager.d(string, stringBuilder.toString(), new Object[0]);
                        if (BluetoothMedic.this.mLocalBroadcastManager != null) {
                            BluetoothMedic.this.mLocalBroadcastManager.sendBroadcast(intent);
                        }
                        if (n2 == 4) {
                            BluetoothMedic.this.mTransmitterTestResult = false;
                            LogManager.w(TAG, "Transmitter test failed in a way we consider a test failure", new Object[0]);
                            BluetoothMedic.this.sendNotification(context, "transmitter failed", "bluetooth not ok");
                            return;
                        }
                        BluetoothMedic.this.mTransmitterTestResult = true;
                        LogManager.i(TAG, "Transmitter test failed, but not in a way we consider a test failure", new Object[0]);
                    }

                    public void onStartSuccess(AdvertiseSettings advertiseSettings) {
                        super.onStartSuccess(advertiseSettings);
                        LogManager.i(TAG, "Transmitter test succeeded", new Object[0]);
                        bluetoothLeAdvertiser.stopAdvertising((AdvertiseCallback)this);
                        BluetoothMedic.this.mTransmitterTestResult = true;
                    }
                });
            } else {
                LogManager.d(TAG, "Cannot get advertiser", new Object[0]);
            }
            while (this.mTransmitterTestResult == null) {
                LogManager.d(TAG, "Waiting for transmitter test to complete...", new Object[0]);
                try {
                    Thread.sleep((long)1000L);
                }
                catch (InterruptedException interruptedException) {}
                if (System.currentTimeMillis() - l2 <= 5000L) continue;
                LogManager.d(TAG, "Timeout running transmitter test", new Object[0]);
                break;
            }
        }
        LogManager.d(TAG, "transmitter test complete", new Object[0]);
        Boolean bl2 = this.mTransmitterTestResult;
        return bl2 != null && bl2 != false;
    }

}

