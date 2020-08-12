/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.R
 *  android.R$drawable
 *  android.app.Activity
 *  android.app.AlertDialog
 *  android.app.AlertDialog$Builder
 *  android.app.Notification
 *  android.app.PendingIntent
 *  android.content.ContentValues
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnCancelListener
 *  android.content.DialogInterface$OnClickListener
 *  android.content.Intent
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.PackageManager
 *  android.content.res.Resources
 *  android.database.Cursor
 *  android.database.sqlite.SQLiteDatabase
 *  android.graphics.Bitmap
 *  android.graphics.BitmapFactory
 *  android.net.Uri
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.text.SpannableString
 *  android.text.style.StyleSpan
 *  android.widget.RemoteViews
 *  androidx.core.app.NotificationCompat
 *  androidx.core.app.NotificationCompat$Builder
 *  androidx.core.app.NotificationCompat$Extender
 *  androidx.core.app.NotificationCompat$InboxStyle
 *  androidx.core.app.NotificationCompat$Style
 *  androidx.core.app.NotificationManagerCompat
 *  com.onesignal.NotificationExtenderService
 *  java.io.InputStream
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.lang.reflect.Field
 *  java.math.BigInteger
 *  java.net.URL
 *  java.net.URLConnection
 *  java.security.SecureRandom
 *  java.util.ArrayList
 *  java.util.Iterator
 *  java.util.List
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.onesignal;

import android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import com.onesignal.ActivityLifecycleHandler;
import com.onesignal.AndroidSupportV4Compat;
import com.onesignal.NotificationExtenderService;
import com.onesignal.NotificationGenerationJob;
import com.onesignal.NotificationLimitManager;
import com.onesignal.NotificationOpenedActivity;
import com.onesignal.NotificationOpenedProcessor;
import com.onesignal.NotificationOpenedReceiver;
import com.onesignal.OSUtils;
import com.onesignal.OneSignal;
import com.onesignal.OneSignalDbHelper;
import com.onesignal.R;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.math.BigInteger;
import java.net.URL;
import java.net.URLConnection;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class GenerateNotification {
    private static Resources contextResources;
    private static Context currentContext;
    private static Class<?> notificationOpenedClass;
    private static boolean openerIsBroadcast;
    private static String packageName;

    private static void addAlertButtons(Context context, JSONObject jSONObject, List<String> list, List<String> list2) {
        try {
            GenerateNotification.addCustomAlertButtons(context, jSONObject, list, list2);
        }
        catch (Throwable throwable) {
            OneSignal.Log(OneSignal.LOG_LEVEL.ERROR, "Failed to parse JSON for custom buttons for alert dialog.", throwable);
        }
        if (list.size() == 0 || list.size() < 3) {
            list.add((Object)OSUtils.getResourceString(context, "onesignal_in_app_alert_ok_button_text", "Ok"));
            list2.add((Object)"__DEFAULT__");
        }
    }

    private static void addBackgroundImage(JSONObject jSONObject, NotificationCompat.Builder builder) throws Throwable {
        JSONObject jSONObject2;
        Bitmap bitmap;
        if (Build.VERSION.SDK_INT < 16) {
            return;
        }
        String string2 = jSONObject.optString("bg_img", null);
        if (string2 != null) {
            jSONObject2 = new JSONObject(string2);
            bitmap = GenerateNotification.getBitmap(jSONObject2.optString("img", null));
        } else {
            bitmap = null;
            jSONObject2 = null;
        }
        if (bitmap == null) {
            bitmap = GenerateNotification.getBitmapFromAssetsOrResourceName("onesignal_bgimage_default_image");
        }
        if (bitmap != null) {
            int n2;
            RemoteViews remoteViews = new RemoteViews(currentContext.getPackageName(), R.layout.onesignal_bgimage_notif_layout);
            remoteViews.setTextViewText(R.id.os_bgimage_notif_title, GenerateNotification.getTitle(jSONObject));
            remoteViews.setTextViewText(R.id.os_bgimage_notif_body, (CharSequence)jSONObject.optString("alert"));
            GenerateNotification.setTextColor(remoteViews, jSONObject2, R.id.os_bgimage_notif_title, "tc", "onesignal_bgimage_notif_title_color");
            GenerateNotification.setTextColor(remoteViews, jSONObject2, R.id.os_bgimage_notif_body, "bc", "onesignal_bgimage_notif_body_color");
            String string3 = jSONObject2 != null && jSONObject2.has("img_align") ? jSONObject2.getString("img_align") : ((n2 = contextResources.getIdentifier("onesignal_bgimage_notif_image_align", "string", packageName)) != 0 ? contextResources.getString(n2) : null);
            if ("right".equals((Object)string3)) {
                remoteViews.setViewPadding(R.id.os_bgimage_notif_bgimage_align_layout, -5000, 0, 0, 0);
                remoteViews.setImageViewBitmap(R.id.os_bgimage_notif_bgimage_right_aligned, bitmap);
                remoteViews.setViewVisibility(R.id.os_bgimage_notif_bgimage_right_aligned, 0);
                remoteViews.setViewVisibility(R.id.os_bgimage_notif_bgimage, 2);
            } else {
                remoteViews.setImageViewBitmap(R.id.os_bgimage_notif_bgimage, bitmap);
            }
            builder.setContent(remoteViews);
            builder.setStyle(null);
        }
    }

    private static void addCustomAlertButtons(Context context, JSONObject jSONObject, List<String> list, List<String> list2) throws JSONException {
        JSONObject jSONObject2 = new JSONObject(jSONObject.optString("custom"));
        if (!jSONObject2.has("a")) {
            return;
        }
        JSONObject jSONObject3 = jSONObject2.getJSONObject("a");
        if (!jSONObject3.has("actionButtons")) {
            return;
        }
        JSONArray jSONArray = jSONObject3.optJSONArray("actionButtons");
        for (int i2 = 0; i2 < jSONArray.length(); ++i2) {
            JSONObject jSONObject4 = jSONArray.getJSONObject(i2);
            list.add((Object)jSONObject4.optString("text"));
            list2.add((Object)jSONObject4.optString("id"));
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static void addNotificationActionButtons(JSONObject jSONObject, NotificationCompat.Builder builder, int n2, String string2) {
        JSONArray jSONArray;
        try {
            JSONObject jSONObject2 = new JSONObject(jSONObject.optString("custom"));
            if (!jSONObject2.has("a")) {
                return;
            }
            JSONObject jSONObject3 = jSONObject2.getJSONObject("a");
            if (!jSONObject3.has("actionButtons")) {
                return;
            }
            jSONArray = jSONObject3.getJSONArray("actionButtons");
        }
        catch (Throwable throwable) {
            throwable.printStackTrace();
            return;
        }
        for (int i2 = 0; i2 < jSONArray.length(); ++i2) {
            JSONObject jSONObject4 = jSONArray.optJSONObject(i2);
            JSONObject jSONObject5 = new JSONObject(jSONObject.toString());
            Intent intent = GenerateNotification.getNewBaseIntent(n2);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("");
            stringBuilder.append(i2);
            intent.setAction(stringBuilder.toString());
            intent.putExtra("action_button", true);
            jSONObject5.put("actionSelected", (Object)jSONObject4.optString("id"));
            intent.putExtra("onesignal_data", jSONObject5.toString());
            if (string2 != null) {
                intent.putExtra("summary", string2);
            } else if (jSONObject.has("grp")) {
                intent.putExtra("grp", jSONObject.optString("grp"));
            }
            PendingIntent pendingIntent = GenerateNotification.getNewActionPendingIntent(n2, intent);
            int n3 = jSONObject4.has("icon") ? GenerateNotification.getResourceIcon(jSONObject4.optString("icon")) : 0;
            builder.addAction(n3, (CharSequence)jSONObject4.optString("text"), pendingIntent);
        }
    }

    private static void addXiaomiSettings(OneSignalNotificationBuilder oneSignalNotificationBuilder, Notification notification) {
        if (!oneSignalNotificationBuilder.hasLargeIcon) {
            return;
        }
        try {
            Object object = Class.forName((String)"android.app.MiuiNotification").newInstance();
            Field field = object.getClass().getDeclaredField("customizedIcon");
            field.setAccessible(true);
            field.set(object, (Object)true);
            Field field2 = notification.getClass().getField("extraNotification");
            field2.setAccessible(true);
            field2.set((Object)notification, object);
        }
        catch (Throwable throwable) {}
    }

    private static void applyNotificationExtender(NotificationGenerationJob notificationGenerationJob, NotificationCompat.Builder builder) {
        if (notificationGenerationJob.overrideSettings != null) {
            if (notificationGenerationJob.overrideSettings.extender == null) {
                return;
            }
            try {
                Field field = NotificationCompat.Builder.class.getDeclaredField("mNotification");
                field.setAccessible(true);
                Notification notification = (Notification)field.get((Object)builder);
                notificationGenerationJob.orgFlags = notification.flags;
                notificationGenerationJob.orgSound = notification.sound;
                builder.extend(notificationGenerationJob.overrideSettings.extender);
                Notification notification2 = (Notification)field.get((Object)builder);
                Field field2 = NotificationCompat.Builder.class.getDeclaredField("mContentText");
                field2.setAccessible(true);
                CharSequence charSequence = (CharSequence)field2.get((Object)builder);
                Field field3 = NotificationCompat.Builder.class.getDeclaredField("mContentTitle");
                field3.setAccessible(true);
                CharSequence charSequence2 = (CharSequence)field3.get((Object)builder);
                notificationGenerationJob.overriddenBodyFromExtender = charSequence;
                notificationGenerationJob.overriddenTitleFromExtender = charSequence2;
                if (!notificationGenerationJob.restoring) {
                    notificationGenerationJob.overriddenFlags = notification2.flags;
                    notificationGenerationJob.overriddenSound = notification2.sound;
                    return;
                }
            }
            catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }
    }

    private static int convertOSToAndroidPriority(int n2) {
        if (n2 > 9) {
            return 2;
        }
        if (n2 > 7) {
            return 1;
        }
        if (n2 > 4) {
            return 0;
        }
        if (n2 > 2) {
            return -1;
        }
        return -2;
    }

    private static Intent createBaseSummaryIntent(int n2, JSONObject jSONObject, String string2) {
        return GenerateNotification.getNewBaseIntent(n2).putExtra("onesignal_data", jSONObject.toString()).putExtra("summary", string2);
    }

    private static Notification createSingleNotificationBeforeSummaryBuilder(NotificationGenerationJob notificationGenerationJob, NotificationCompat.Builder builder) {
        boolean bl2 = Build.VERSION.SDK_INT > 17 && Build.VERSION.SDK_INT < 24 && !notificationGenerationJob.restoring;
        if (bl2 && notificationGenerationJob.overriddenSound != null && !notificationGenerationJob.overriddenSound.equals((Object)notificationGenerationJob.orgSound)) {
            builder.setSound(null);
        }
        Notification notification = builder.build();
        if (bl2) {
            builder.setSound(notificationGenerationJob.overriddenSound);
        }
        return notification;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private static void createSummaryIdDatabaseEntry(OneSignalDbHelper var0, String var1_1, int var2_2) {
        block12 : {
            var3_3 = null;
            var7_4 = var0.getWritableDbWithRetries();
            var7_4.beginTransaction();
            var9_5 = new ContentValues();
            var9_5.put("android_notification_id", Integer.valueOf((int)var2_2));
            var9_5.put("group_id", var1_1);
            var9_5.put("is_summary", Integer.valueOf((int)1));
            var7_4.insertOrThrow("notification", null, var9_5);
            var7_4.setTransactionSuccessful();
            if (var7_4 == null) return;
            var7_4.endTransaction();
            return;
            catch (Throwable var6_6) {
                break block12;
            }
            catch (Throwable var4_9) {
                var3_3 = var7_4;
                ** GOTO lbl-1000
            }
            catch (Throwable var6_7) {
                var7_4 = var3_3;
                break block12;
            }
            catch (Throwable var4_10) {
                // empty catch block
            }
lbl-1000: // 2 sources:
            {
                OneSignal.Log(OneSignal.LOG_LEVEL.ERROR, "Error adding summary notification record! ", (Throwable)var4_11);
                if (var3_3 == null) return;
            }
            try {
                var3_3.endTransaction();
                return;
            }
            catch (Throwable var5_12) {
                OneSignal.Log(OneSignal.LOG_LEVEL.ERROR, "Error closing transaction! ", var5_12);
            }
            return;
        }
        if (var7_4 == null) throw var6_8;
        try {
            var7_4.endTransaction();
            throw var6_8;
        }
        catch (Throwable var8_13) {
            OneSignal.Log(OneSignal.LOG_LEVEL.ERROR, "Error closing transaction! ", var8_13);
        }
        throw var6_8;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private static void createSummaryNotification(NotificationGenerationJob var0, OneSignalNotificationBuilder var1_1) {
        block40 : {
            block39 : {
                block38 : {
                    block37 : {
                        block36 : {
                            var2_2 = "message";
                            var3_3 = "title";
                            var4_4 = "is_summary";
                            var5_5 = var0.restoring;
                            var6_6 = var0.jsonPayload;
                            var7_7 = null;
                            var8_8 = var6_6.optString("grp", null);
                            var9_9 = new SecureRandom();
                            var10_10 = GenerateNotification.getNewActionPendingIntent(var9_9.nextInt(), GenerateNotification.getNewBaseDeleteIntent(0).putExtra("summary", var8_8));
                            var11_11 = OneSignalDbHelper.getInstance(GenerateNotification.currentContext);
                            var13_12 = var11_11.getReadableDbWithRetries();
                            try {
                                var14_13 = new String[]{"android_notification_id", "full_data", var4_4, var3_3, var2_2};
                                var15_14 = "group_id = ? AND dismissed = 0 AND opened = 0";
                                var16_15 = new String[]{var8_8};
                                if (var5_5) break block36;
                                var17_16 = var0.getAndroidId();
                                var18_17 = var10_10;
                                if (var17_16 != -1) {
                                    var19_18 = new StringBuilder();
                                    var19_18.append(var15_14);
                                    var19_18.append(" AND android_notification_id <> ");
                                    var19_18.append((Object)var0.getAndroidId());
                                    var15_14 = var19_18.toString();
                                }
                                break block37;
                            }
                            catch (Throwable var12_57) {
                                var7_7 = null;
                                break block38;
                            }
                        }
                        var18_17 = var10_10;
                    }
                    var7_7 = var13_12.query("notification", var14_13, var15_14, var16_15, null, null, "_id DESC");
                    try {
                        var23_19 = var7_7.moveToFirst();
                        var24_20 = "";
                        if (var23_19) {
                            var26_21 = new ArrayList();
                            var67_22 = null;
                            var27_23 = null;
                            break block39;
                        }
                        var25_37 = var6_6;
                        var26_21 = null;
                        var27_23 = null;
                    }
                    catch (Throwable var12_58) {
                        // empty catch block
                    }
lbl45: // 3 sources:
                    while (var7_7 != null && !var7_7.isClosed()) {
                        var7_7.close();
                        break block40;
                    }
                    break block40;
                }
                if (var7_7 == null) throw var12_59;
                if (var7_7.isClosed() != false) throw var12_59;
                var7_7.close();
                throw var12_59;
            }
            do {
                block43 : {
                    block44 : {
                        var68_24 = var27_23;
                        var69_25 = var7_7.getInt(var7_7.getColumnIndex(var4_4));
                        var70_26 = var4_4;
                        if (var69_25 == 1) {
                            var71_27 = var7_7.getInt(var7_7.getColumnIndex("android_notification_id"));
                            var72_28 = var2_2;
                            var73_29 = var3_3;
                            var27_23 = var71_27;
                        } else {
                            var76_31 = var7_7.getString(var7_7.getColumnIndex(var3_3));
                            if (var76_31 == null) {
                                var80_33 = var24_20;
                            } else {
                                var77_32 = new StringBuilder();
                                var77_32.append(var76_31);
                                var77_32.append(" ");
                                var80_33 = var77_32.toString();
                            }
                            var81_34 = var7_7.getString(var7_7.getColumnIndex(var2_2));
                            var72_28 = var2_2;
                            var73_29 = var3_3;
                            var82_35 = new StringBuilder();
                            var82_35.append(var80_33);
                            var82_35.append(var81_34);
                            var85_36 = new SpannableString((CharSequence)var82_35.toString());
                            if (var80_33.length() > 0) {
                                var85_36.setSpan((Object)new StyleSpan(1), 0, var80_33.length(), 0);
                            }
                            var26_21.add((Object)var85_36);
                            if (var67_22 == null) {
                                var67_22 = var7_7.getString(var7_7.getColumnIndex("full_data"));
                            }
                            var27_23 = var68_24;
                        }
                        if (var74_30 = var7_7.moveToNext()) break block43;
                        if (!var5_5 || var67_22 == null) break block44;
                        try {
                            var25_37 = new JSONObject(var67_22);
                            ** GOTO lbl45
                        }
                        catch (JSONException var75_38) {
                            var75_38.printStackTrace();
                        }
                    }
                    var25_37 = var6_6;
                    ** GOTO lbl45
                }
                var4_4 = var70_26;
                var2_2 = var72_28;
                var3_3 = var73_29;
            } while (true);
        }
        if (var27_23 == null) {
            var27_23 = var9_9.nextInt();
            GenerateNotification.createSummaryIdDatabaseEntry(var11_11, var8_8, var27_23);
        }
        var28_39 = GenerateNotification.getNewActionPendingIntent(var9_9.nextInt(), GenerateNotification.createBaseSummaryIntent(var27_23, var25_37, var8_8));
        if (var26_21 != null && (var5_5 && var26_21.size() > 1 || !var5_5 && var26_21.size() > 0)) {
            var35_40 = var26_21.size() + (var5_5 ^ true);
            var36_41 = var25_37.optString("grp_msg", null);
            if (var36_41 == null) {
                var37_42 = new StringBuilder();
                var37_42.append(var35_40);
                var37_42.append(" new messages");
                var40_43 = var37_42.toString();
            } else {
                var64_44 = new StringBuilder();
                var64_44.append(var24_20);
                var64_44.append(var35_40);
                var40_43 = var36_41.replace((CharSequence)"$[notif_count]", (CharSequence)var64_44.toString());
            }
            var41_45 = GenerateNotification.getBaseOneSignalNotificationBuilder((NotificationGenerationJob)var0).compatBuilder;
            if (var5_5) {
                GenerateNotification.removeNotifyOptions(var41_45);
            } else {
                if (var0.overriddenSound != null) {
                    var41_45.setSound(var0.overriddenSound);
                }
                if (var0.overriddenFlags != null) {
                    var41_45.setDefaults(var0.overriddenFlags.intValue());
                }
            }
            var41_45.setContentIntent(var28_39).setDeleteIntent(var18_17).setContentTitle(GenerateNotification.currentContext.getPackageManager().getApplicationLabel(GenerateNotification.currentContext.getApplicationInfo())).setContentText((CharSequence)var40_43).setNumber(var35_40).setSmallIcon(GenerateNotification.getDefaultSmallIconId()).setLargeIcon(GenerateNotification.getDefaultLargeIcon()).setOnlyAlertOnce(var5_5).setGroup(var8_8).setGroupSummary(true);
            try {
                var41_45.setGroupAlertBehavior(1);
            }
            catch (Throwable v0) {}
            if (!var5_5) {
                var41_45.setTicker((CharSequence)var40_43);
            }
            var44_46 = new NotificationCompat.InboxStyle();
            if (!var5_5) {
                var49_47 = var0.getTitle();
                var50_48 = null;
                if (var49_47 != null) {
                    var50_48 = var0.getTitle().toString();
                }
                if (var50_48 != null) {
                    var51_49 = new StringBuilder();
                    var51_49.append(var50_48);
                    var51_49.append(" ");
                    var24_20 = var51_49.toString();
                }
                var54_50 = var0.getBody().toString();
                var55_51 = new StringBuilder();
                var55_51.append(var24_20);
                var55_51.append(var54_50);
                var58_52 = new SpannableString((CharSequence)var55_51.toString());
                if (var24_20.length() > 0) {
                    var58_52.setSpan((Object)new StyleSpan(1), 0, var24_20.length(), 0);
                }
                var44_46.addLine((CharSequence)var58_52);
            }
            var45_53 = var26_21.iterator();
            while (var45_53.hasNext()) {
                var44_46.addLine((CharSequence)((SpannableString)var45_53.next()));
            }
            var44_46.setBigContentTitle((CharSequence)var40_43);
            var41_45.setStyle((NotificationCompat.Style)var44_46);
            var33_54 = var41_45.build();
        } else {
            var29_55 = var18_17;
            var30_56 = var1_1.compatBuilder;
            var30_56.mActions.clear();
            GenerateNotification.addNotificationActionButtons(var25_37, var30_56, var27_23, var8_8);
            var30_56.setContentIntent(var28_39).setDeleteIntent(var29_55).setOnlyAlertOnce(var5_5).setGroup(var8_8).setGroupSummary(true);
            try {
                var30_56.setGroupAlertBehavior(1);
            }
            catch (Throwable v1) {}
            var33_54 = var30_56.build();
            GenerateNotification.addXiaomiSettings(var1_1, var33_54);
        }
        NotificationManagerCompat.from((Context)GenerateNotification.currentContext).notify(var27_23.intValue(), var33_54);
    }

    static void fromJsonPayload(NotificationGenerationJob notificationGenerationJob) {
        GenerateNotification.setStatics(notificationGenerationJob.context);
        if (!notificationGenerationJob.restoring && notificationGenerationJob.showAsAlert && ActivityLifecycleHandler.curActivity != null) {
            GenerateNotification.showNotificationAsAlert(notificationGenerationJob.jsonPayload, ActivityLifecycleHandler.curActivity, notificationGenerationJob.getAndroidId());
            return;
        }
        GenerateNotification.showNotification(notificationGenerationJob);
    }

    /*
     * Exception decompiling
     */
    private static BigInteger getAccentColor(JSONObject var0) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl30.1 : ACONST_NULL : trying to set 1 previously set to 0
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

    /*
     * Exception decompiling
     */
    private static OneSignalNotificationBuilder getBaseOneSignalNotificationBuilder(NotificationGenerationJob var0) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Underrun type stack
        // org.benf.cfr.reader.b.a.c.e.a(StackSim.java:35)
        // org.benf.cfr.reader.b.b.af.a(OperationFactoryPop.java:20)
        // org.benf.cfr.reader.b.b.e.a(JVMInstr.java:315)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:195)
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

    private static Bitmap getBitmap(String string2) {
        if (string2 == null) {
            return null;
        }
        String string3 = string2.trim();
        if (!string3.startsWith("http://") && !string3.startsWith("https://")) {
            return GenerateNotification.getBitmapFromAssetsOrResourceName(string2);
        }
        return GenerateNotification.getBitmapFromURL(string3);
    }

    /*
     * Exception decompiling
     */
    private static Bitmap getBitmapFromAssetsOrResourceName(String var0) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl84.1 : ACONST_NULL : trying to set 1 previously set to 0
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

    private static Bitmap getBitmapFromURL(String string2) {
        try {
            Bitmap bitmap = BitmapFactory.decodeStream((InputStream)new URL(string2).openConnection().getInputStream());
            return bitmap;
        }
        catch (Throwable throwable) {
            OneSignal.Log(OneSignal.LOG_LEVEL.WARN, "Could not download image!", throwable);
            return null;
        }
    }

    private static Bitmap getDefaultLargeIcon() {
        return GenerateNotification.resizeBitmapForLargeIconArea(GenerateNotification.getBitmapFromAssetsOrResourceName("ic_onesignal_large_icon_default"));
    }

    private static int getDefaultSmallIconId() {
        int n2 = GenerateNotification.getDrawableId("ic_stat_onesignal_default");
        if (n2 != 0) {
            return n2;
        }
        int n3 = GenerateNotification.getDrawableId("corona_statusbar_icon_default");
        if (n3 != 0) {
            return n3;
        }
        int n4 = GenerateNotification.getDrawableId("ic_os_notification_fallback_white_24dp");
        if (n4 != 0) {
            return n4;
        }
        return 17301598;
    }

    private static int getDrawableId(String string2) {
        return contextResources.getIdentifier(string2, "drawable", packageName);
    }

    private static Bitmap getLargeIcon(JSONObject jSONObject) {
        Bitmap bitmap = GenerateNotification.getBitmap(jSONObject.optString("licon"));
        if (bitmap == null) {
            bitmap = GenerateNotification.getBitmapFromAssetsOrResourceName("ic_onesignal_large_icon_default");
        }
        if (bitmap == null) {
            return null;
        }
        return GenerateNotification.resizeBitmapForLargeIconArea(bitmap);
    }

    private static PendingIntent getNewActionPendingIntent(int n2, Intent intent) {
        if (openerIsBroadcast) {
            return PendingIntent.getBroadcast((Context)currentContext, (int)n2, (Intent)intent, (int)134217728);
        }
        return PendingIntent.getActivity((Context)currentContext, (int)n2, (Intent)intent, (int)134217728);
    }

    private static Intent getNewBaseDeleteIntent(int n2) {
        Intent intent = new Intent(currentContext, notificationOpenedClass).putExtra("notificationId", n2).putExtra("dismissed", true);
        if (openerIsBroadcast) {
            return intent;
        }
        return intent.addFlags(402718720);
    }

    private static Intent getNewBaseIntent(int n2) {
        Intent intent = new Intent(currentContext, notificationOpenedClass).putExtra("notificationId", n2);
        if (openerIsBroadcast) {
            return intent;
        }
        return intent.addFlags(603979776);
    }

    private static int getResourceIcon(String string2) {
        if (string2 == null) {
            return 0;
        }
        String string3 = string2.trim();
        if (!OSUtils.isValidResourceName(string3)) {
            return 0;
        }
        int n2 = GenerateNotification.getDrawableId(string3);
        if (n2 != 0) {
            return n2;
        }
        try {
            int n3 = R.drawable.class.getField(string2).getInt(null);
            return n3;
        }
        catch (Throwable throwable) {
            return 0;
        }
    }

    private static int getSmallIconId(JSONObject jSONObject) {
        int n2 = GenerateNotification.getResourceIcon(jSONObject.optString("sicon", null));
        if (n2 != 0) {
            return n2;
        }
        return GenerateNotification.getDefaultSmallIconId();
    }

    private static CharSequence getTitle(JSONObject jSONObject) {
        String string2 = jSONObject.optString("title", null);
        if (string2 != null) {
            return string2;
        }
        return currentContext.getPackageManager().getApplicationLabel(currentContext.getApplicationInfo());
    }

    private static boolean isSoundEnabled(JSONObject jSONObject) {
        String string2 = jSONObject.optString("sound", null);
        if (!"null".equals((Object)string2) && !"nil".equals((Object)string2)) {
            return OneSignal.getSoundEnabled(currentContext);
        }
        return false;
    }

    private static void removeNotifyOptions(NotificationCompat.Builder builder) {
        builder.setOnlyAlertOnce(true).setDefaults(0).setSound(null).setVibrate(null).setTicker(null);
    }

    /*
     * Exception decompiling
     */
    private static Bitmap resizeBitmapForLargeIconArea(Bitmap var0) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Underrun type stack
        // org.benf.cfr.reader.b.a.c.e.a(StackSim.java:35)
        // org.benf.cfr.reader.b.b.af.a(OperationFactoryPop.java:20)
        // org.benf.cfr.reader.b.b.e.a(JVMInstr.java:315)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:195)
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

    /*
     * Exception decompiling
     */
    private static Integer safeGetColorFromHex(JSONObject var0, String var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl19.1 : ACONST_NULL : trying to set 1 previously set to 0
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

    /*
     * Exception decompiling
     */
    private static void setAlertnessOptions(JSONObject var0, NotificationCompat.Builder var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl51.1 : GETSTATIC : trying to set 1 previously set to 0
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

    private static void setStatics(Context context) {
        currentContext = context;
        packageName = currentContext.getPackageName();
        contextResources = currentContext.getResources();
        PackageManager packageManager = currentContext.getPackageManager();
        Intent intent = new Intent(currentContext, NotificationOpenedReceiver.class);
        intent.setPackage(currentContext.getPackageName());
        if (packageManager.queryBroadcastReceivers(intent, 0).size() > 0) {
            openerIsBroadcast = true;
            notificationOpenedClass = NotificationOpenedReceiver.class;
            return;
        }
        notificationOpenedClass = NotificationOpenedActivity.class;
    }

    private static void setTextColor(RemoteViews remoteViews, JSONObject jSONObject, int n2, String string2, String string3) {
        Integer n3 = GenerateNotification.safeGetColorFromHex(jSONObject, string2);
        if (n3 != null) {
            remoteViews.setTextColor(n2, n3.intValue());
            return;
        }
        int n4 = contextResources.getIdentifier(string3, "color", packageName);
        if (n4 != 0) {
            remoteViews.setTextColor(n2, AndroidSupportV4Compat.ContextCompat.getColor(currentContext, n4));
        }
    }

    private static void showNotification(NotificationGenerationJob notificationGenerationJob) {
        Notification notification;
        SecureRandom secureRandom = new SecureRandom();
        int n2 = notificationGenerationJob.getAndroidId();
        JSONObject jSONObject = notificationGenerationJob.jsonPayload;
        String string2 = jSONObject.optString("grp", null);
        OneSignalNotificationBuilder oneSignalNotificationBuilder = GenerateNotification.getBaseOneSignalNotificationBuilder(notificationGenerationJob);
        NotificationCompat.Builder builder = oneSignalNotificationBuilder.compatBuilder;
        GenerateNotification.addNotificationActionButtons(jSONObject, builder, n2, null);
        try {
            GenerateNotification.addBackgroundImage(jSONObject, builder);
        }
        catch (Throwable throwable) {
            OneSignal.Log(OneSignal.LOG_LEVEL.ERROR, "Could not set background notification image!", throwable);
        }
        GenerateNotification.applyNotificationExtender(notificationGenerationJob, builder);
        if (notificationGenerationJob.restoring) {
            GenerateNotification.removeNotifyOptions(builder);
        }
        int n3 = string2 != null ? 2 : 1;
        NotificationLimitManager.clearOldestOverLimit(currentContext, n3);
        if (string2 != null) {
            builder.setContentIntent(GenerateNotification.getNewActionPendingIntent(secureRandom.nextInt(), GenerateNotification.getNewBaseIntent(n2).putExtra("onesignal_data", jSONObject.toString()).putExtra("grp", string2)));
            builder.setDeleteIntent(GenerateNotification.getNewActionPendingIntent(secureRandom.nextInt(), GenerateNotification.getNewBaseDeleteIntent(n2).putExtra("grp", string2)));
            builder.setGroup(string2);
            try {
                builder.setGroupAlertBehavior(1);
            }
            catch (Throwable throwable) {}
            notification = GenerateNotification.createSingleNotificationBeforeSummaryBuilder(notificationGenerationJob, builder);
            GenerateNotification.createSummaryNotification(notificationGenerationJob, oneSignalNotificationBuilder);
        } else {
            builder.setContentIntent(GenerateNotification.getNewActionPendingIntent(secureRandom.nextInt(), GenerateNotification.getNewBaseIntent(n2).putExtra("onesignal_data", jSONObject.toString())));
            builder.setDeleteIntent(GenerateNotification.getNewActionPendingIntent(secureRandom.nextInt(), GenerateNotification.getNewBaseDeleteIntent(n2)));
            notification = builder.build();
        }
        if (string2 == null || Build.VERSION.SDK_INT > 17) {
            GenerateNotification.addXiaomiSettings(oneSignalNotificationBuilder, notification);
            NotificationManagerCompat.from((Context)currentContext).notify(n2, notification);
        }
    }

    private static void showNotificationAsAlert(final JSONObject jSONObject, final Activity activity, final int n2) {
        activity.runOnUiThread(new Runnable(){

            public void run() {
                AlertDialog.Builder builder = new AlertDialog.Builder((Context)activity);
                builder.setTitle(GenerateNotification.getTitle(jSONObject));
                builder.setMessage((CharSequence)jSONObject.optString("alert"));
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                GenerateNotification.addAlertButtons((Context)activity, jSONObject, (List<String>)((List)arrayList), (List<String>)((List)arrayList2));
                final Intent intent = GenerateNotification.getNewBaseIntent(n2);
                intent.putExtra("action_button", true);
                intent.putExtra("from_alert", true);
                intent.putExtra("onesignal_data", jSONObject.toString());
                if (jSONObject.has("grp")) {
                    intent.putExtra("grp", jSONObject.optString("grp"));
                }
                DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener((List)arrayList2, intent){
                    final /* synthetic */ List val$finalButtonIds;
                    final /* synthetic */ Intent val$finalButtonIntent;
                    {
                        this.val$finalButtonIds = list;
                        this.val$finalButtonIntent = intent;
                    }

                    /*
                     * Enabled aggressive block sorting
                     * Enabled unnecessary exception pruning
                     * Enabled aggressive exception aggregation
                     */
                    public void onClick(DialogInterface dialogInterface, int n2) {
                        int n3 = n2 + 3;
                        if (this.val$finalButtonIds.size() <= 1) {
                            NotificationOpenedProcessor.processIntent((Context)activity, this.val$finalButtonIntent);
                            return;
                        }
                        try {
                            JSONObject jSONObject = new JSONObject(jSONObject.toString());
                            jSONObject.put("actionSelected", this.val$finalButtonIds.get(n3));
                            this.val$finalButtonIntent.putExtra("onesignal_data", jSONObject.toString());
                            NotificationOpenedProcessor.processIntent((Context)activity, this.val$finalButtonIntent);
                            return;
                        }
                        catch (Throwable throwable) {}
                    }
                };
                builder.setOnCancelListener(new DialogInterface.OnCancelListener(){

                    public void onCancel(DialogInterface dialogInterface) {
                        NotificationOpenedProcessor.processIntent((Context)activity, intent);
                    }
                });
                for (int i2 = 0; i2 < arrayList.size(); ++i2) {
                    if (i2 == 0) {
                        builder.setNeutralButton((CharSequence)arrayList.get(i2), onClickListener);
                        continue;
                    }
                    if (i2 == 1) {
                        builder.setNegativeButton((CharSequence)arrayList.get(i2), onClickListener);
                        continue;
                    }
                    if (i2 != 2) continue;
                    builder.setPositiveButton((CharSequence)arrayList.get(i2), onClickListener);
                }
                AlertDialog alertDialog = builder.create();
                alertDialog.setCanceledOnTouchOutside(false);
                alertDialog.show();
            }

        });
    }

    static void updateSummaryNotification(NotificationGenerationJob notificationGenerationJob) {
        GenerateNotification.setStatics(notificationGenerationJob.context);
        GenerateNotification.createSummaryNotification(notificationGenerationJob, null);
    }

    private static class OneSignalNotificationBuilder {
        NotificationCompat.Builder compatBuilder;
        boolean hasLargeIcon;

        private OneSignalNotificationBuilder() {
        }
    }

}

