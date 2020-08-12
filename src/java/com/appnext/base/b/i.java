/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  android.security.keystore.KeyGenParameterSpec
 *  androidx.security.crypto.EncryptedSharedPreferences
 *  androidx.security.crypto.EncryptedSharedPreferences$PrefKeyEncryptionScheme
 *  androidx.security.crypto.EncryptedSharedPreferences$PrefValueEncryptionScheme
 *  androidx.security.crypto.MasterKeys
 *  java.io.IOException
 *  java.lang.Object
 *  java.lang.String
 *  java.security.GeneralSecurityException
 *  java.util.Set
 */
package com.appnext.base.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.security.keystore.KeyGenParameterSpec;
import androidx.security.crypto.EncryptedSharedPreferences;
import androidx.security.crypto.MasterKeys;
import com.appnext.base.b.e;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Set;

@SuppressLint(value={"CommitPrefEdits"})
public final class i {
    private static final String TAG = "LibrarySettings";
    public static final String fA = "_cycles";
    public static final String fB = "_hash";
    public static final String fC = "google_ads_id";
    public static final String fD = "generated";
    public static final String fE = "apps_category_saved";
    public static final String fF = "lat";
    public static final String fG = "lib_shared_preferences";
    @SuppressLint(value={"StaticFieldLeak"})
    private static final i fH = new i();
    public static final String fy = "_lastupdate";
    public static final String fz = "_lastcollectedtime";
    private SharedPreferences fx;
    private Context mContext = e.getContext();

    private i() {
        if (this.mContext != null) {
            try {
                this.fx = EncryptedSharedPreferences.create((String)"secret_shared_prefs", (String)MasterKeys.getOrCreate((KeyGenParameterSpec)MasterKeys.AES256_GCM_SPEC), (Context)this.mContext, (EncryptedSharedPreferences.PrefKeyEncryptionScheme)EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV, (EncryptedSharedPreferences.PrefValueEncryptionScheme)EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM);
                return;
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
                return;
            }
            catch (GeneralSecurityException generalSecurityException) {
                generalSecurityException.printStackTrace();
            }
        }
    }

    public static i aQ() {
        return fH;
    }

    public final void clear() {
        this.fx.edit().clear().apply();
    }

    public final boolean getBoolean(String string2, boolean bl) {
        SharedPreferences sharedPreferences = this.fx;
        if (sharedPreferences != null) {
            return sharedPreferences.getBoolean(string2, bl);
        }
        return bl;
    }

    public final int getInt(String string2, int n2) {
        SharedPreferences sharedPreferences = this.fx;
        if (sharedPreferences != null) {
            return sharedPreferences.getInt(string2, 0);
        }
        return 0;
    }

    public final long getLong(String string2, long l2) {
        SharedPreferences sharedPreferences = this.fx;
        if (sharedPreferences != null) {
            return sharedPreferences.getLong(string2, l2);
        }
        return l2;
    }

    public final String getString(String string2, String string3) {
        SharedPreferences sharedPreferences = this.fx;
        if (sharedPreferences != null) {
            return sharedPreferences.getString(string2, string3);
        }
        return string3;
    }

    public final Set<String> getStringSet(String string2, Set<String> set) {
        SharedPreferences sharedPreferences = this.fx;
        if (sharedPreferences != null) {
            return sharedPreferences.getStringSet(string2, set);
        }
        return set;
    }

    public final void init(Context context) {
        if (context == null) {
            return;
        }
        this.mContext = context;
        this.fx = this.mContext.getSharedPreferences(fG, 0);
    }

    public final void putBoolean(String string2, boolean bl) {
        SharedPreferences sharedPreferences = this.fx;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putBoolean(string2, true).apply();
        }
    }

    public final void putInt(String string2, int n2) {
        SharedPreferences sharedPreferences = this.fx;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putInt(string2, n2).apply();
        }
    }

    public final void putLong(String string2, long l2) {
        SharedPreferences sharedPreferences = this.fx;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putLong(string2, l2).apply();
        }
    }

    public final void putString(String string2, String string3) {
        SharedPreferences sharedPreferences = this.fx;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString(string2, string3).apply();
        }
    }

    public final void putStringSet(String string2, Set<String> set) {
        SharedPreferences sharedPreferences = this.fx;
        if (sharedPreferences != null) {
            sharedPreferences.edit().remove(string2);
            this.fx.edit().putStringSet(string2, set).apply();
        }
    }
}

