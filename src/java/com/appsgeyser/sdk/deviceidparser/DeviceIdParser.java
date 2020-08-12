/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.os.AsyncTask
 *  android.provider.Settings
 *  android.provider.Settings$Secure
 *  com.google.android.gms.ads.identifier.AdvertisingIdClient
 *  com.google.android.gms.ads.identifier.AdvertisingIdClient$Info
 *  com.google.android.gms.common.GooglePlayServicesNotAvailableException
 *  com.google.android.gms.common.GooglePlayServicesRepairableException
 *  java.io.IOException
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Void
 */
package com.appsgeyser.sdk.deviceidparser;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.Context;
import android.os.AsyncTask;
import android.provider.Settings;
import com.appsgeyser.sdk.deviceidparser.DeviceIdParameters;
import com.appsgeyser.sdk.deviceidparser.IDeviceIdParserListener;
import com.appsgeyser.sdk.deviceidparser.LimitAdTrackingEnabledStates;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import java.io.IOException;

public class DeviceIdParser {
    private static DeviceIdParser instance;
    private final DeviceIdParameters deviceIdParameters = new DeviceIdParameters();

    private DeviceIdParser() {
    }

    private DeviceIdParameters generateParametersCopy() {
        try {
            DeviceIdParameters deviceIdParameters = (DeviceIdParameters)this.deviceIdParameters.clone();
            return deviceIdParameters;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }

    private AdvertisingIdClient.Info getAdvertisingIdInfo(Context context) {
        try {
            AdvertisingIdClient.Info info = AdvertisingIdClient.getAdvertisingIdInfo((Context)context);
            return info;
        }
        catch (GooglePlayServicesRepairableException googlePlayServicesRepairableException) {
            googlePlayServicesRepairableException.printStackTrace();
            return null;
        }
        catch (GooglePlayServicesNotAvailableException googlePlayServicesNotAvailableException) {
            googlePlayServicesNotAvailableException.printStackTrace();
            return null;
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
            return null;
        }
    }

    @SuppressLint(value={"HardwareIds"})
    private String getAndroidId(Context context) {
        try {
            String string2 = Settings.Secure.getString((ContentResolver)context.getContentResolver(), (String)"android_id");
            return string2;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }

    public static DeviceIdParser getInstance() {
        if (instance == null) {
            instance = new DeviceIdParser();
        }
        return instance;
    }

    public DeviceIdParameters getDeviceIdParameters() {
        return this.deviceIdParameters;
    }

    public void rescan(Context context, IDeviceIdParserListener iDeviceIdParserListener) {
        new ParserThread(context, iDeviceIdParserListener).execute((Object[])new Context[]{context});
    }

    private class ParserThread
    extends AsyncTask<Context, Void, DeviceIdParameters> {
        private final Context context;
        private final IDeviceIdParserListener listener;

        ParserThread(Context context, IDeviceIdParserListener iDeviceIdParserListener) {
            this.listener = iDeviceIdParserListener;
            this.context = context;
        }

        protected /* varargs */ DeviceIdParameters doInBackground(Context ... arrcontext) {
            DeviceIdParser.this.deviceIdParameters.clear();
            AdvertisingIdClient.Info info = DeviceIdParser.this.getAdvertisingIdInfo(arrcontext[0]);
            if (info != null) {
                LimitAdTrackingEnabledStates limitAdTrackingEnabledStates = info.isLimitAdTrackingEnabled() ? LimitAdTrackingEnabledStates.TRUE : LimitAdTrackingEnabledStates.FALSE;
                DeviceIdParser.this.deviceIdParameters.setLimitAdTrackingEnabled(limitAdTrackingEnabledStates);
                DeviceIdParser.this.deviceIdParameters.setAdvId(info.getId());
            } else {
                DeviceIdParser.this.deviceIdParameters.setLimitAdTrackingEnabled(LimitAdTrackingEnabledStates.UNKNOWN);
                DeviceIdParser.this.deviceIdParameters.setAdvId(null);
                DeviceIdParser.this.deviceIdParameters.setaId(DeviceIdParser.this.getAndroidId(arrcontext[0]));
            }
            return DeviceIdParser.this.generateParametersCopy();
        }

        protected void onPostExecute(DeviceIdParameters deviceIdParameters) {
            IDeviceIdParserListener iDeviceIdParserListener = this.listener;
            if (iDeviceIdParserListener != null) {
                iDeviceIdParserListener.onDeviceIdParametersObtained(this.context, deviceIdParameters);
            }
        }
    }

}

