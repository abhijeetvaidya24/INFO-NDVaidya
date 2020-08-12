/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 */
package com.ironsource.mediationsdk.config;

public class ConfigFile {
    private static ConfigFile mInstance;
    private String mPluginFrameworkVersion;
    private String mPluginType;
    private String mPluginVersion;
    private String[] mSupportedPlugins = new String[]{"Unity", "AdobeAir", "Xamarin", "Corona", "AdMob", "MoPub"};

    public static ConfigFile getConfigFile() {
        Class<ConfigFile> class_ = ConfigFile.class;
        synchronized (ConfigFile.class) {
            if (mInstance == null) {
                mInstance = new ConfigFile();
            }
            ConfigFile configFile = mInstance;
            // ** MonitorExit[var2] (shouldn't be in output)
            return configFile;
        }
    }

    public String getPluginFrameworkVersion() {
        return this.mPluginFrameworkVersion;
    }

    public String getPluginType() {
        return this.mPluginType;
    }

    public String getPluginVersion() {
        return this.mPluginVersion;
    }
}

