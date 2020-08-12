/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.ProgressDialog
 *  android.app.WallpaperManager
 *  android.content.Context
 *  android.content.Intent
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  android.content.res.Resources
 *  android.database.Cursor
 *  android.graphics.Bitmap
 *  android.graphics.BitmapFactory
 *  android.graphics.BitmapFactory$Options
 *  android.net.Uri
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Parcelable
 *  android.view.View
 *  android.webkit.JavascriptInterface
 *  android.webkit.WebView
 *  android.widget.Toast
 *  com.appsgeyser.multiTabApp.MainNavigationActivity
 *  com.appsgeyser.multiTabApp.controllers.WebContentController
 *  com.appsgeyser.multiTabApp.javascriptinterface.JavascriptInterface$1
 *  com.appsgeyser.multiTabApp.javascriptinterface.JavascriptInterface$14
 *  com.appsgeyser.multiTabApp.javascriptinterface.JavascriptInterface$2$2
 *  com.appsgeyser.multiTabApp.ui.views.PdfActivity
 *  com.google.android.youtube.player.YouTubeStandalonePlayer
 *  java.io.File
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Thread
 *  java.util.HashMap
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.appsgeyser.multiTabApp.javascriptinterface;

import android.app.Activity;
import android.app.ProgressDialog;
import android.app.WallpaperManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Parcelable;
import android.view.View;
import android.webkit.WebView;
import android.widget.Toast;
import com.appsgeyser.multiTabApp.Factory;
import com.appsgeyser.multiTabApp.MainNavigationActivity;
import com.appsgeyser.multiTabApp.configuration.WebWidgetConfiguration;
import com.appsgeyser.multiTabApp.controllers.INavigationController;
import com.appsgeyser.multiTabApp.controllers.WebContentController;
import com.appsgeyser.multiTabApp.controllers.WidgetsController;
import com.appsgeyser.multiTabApp.inline.StringEscapeUtils;
import com.appsgeyser.multiTabApp.javascriptinterface.-$$Lambda$JavascriptInterface$1g6uWEKq52RmZKOG-mBRZ7n9sfQ;
import com.appsgeyser.multiTabApp.javascriptinterface.JavascriptInterface;
import com.appsgeyser.multiTabApp.model.WidgetEntity;
import com.appsgeyser.multiTabApp.server.BaseServerClient;
import com.appsgeyser.multiTabApp.storage.BookmarksManager;
import com.appsgeyser.multiTabApp.ui.navigationwidget.INavigationWidget;
import com.appsgeyser.multiTabApp.ui.navigationwidget.NavigationWidgetCustomIcon;
import com.appsgeyser.multiTabApp.ui.views.PdfActivity;
import com.appsgeyser.multiTabApp.utils.FileManager;
import com.appsgeyser.multiTabApp.utils.ImageReader;
import com.appsgeyser.multiTabApp.utils.UrlConverter;
import com.appsgeyser.multiTabApp.utils.WebViewScreenShooter;
import com.appsgeyser.sdk.AppsgeyserSDK;
import com.appsgeyser.sdk.ads.fastTrack.adapters.FastTrackBaseAdapter;
import com.google.android.youtube.player.YouTubeStandalonePlayer;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JavascriptInterface {
    private ProgressDialog _currentProgressDialog;
    private MainNavigationActivity _mainActivity;
    private WebContentController _webController;
    private int mFinalHeight;
    private int mFinalWidth;

    public JavascriptInterface(WebContentController webContentController) {
        if (webContentController != null) {
            this._mainActivity = webContentController.getMainNavigationActivity();
            this._webController = webContentController;
        }
    }

    private void XmlHttpRequestDone(String string2, String string3) {
        String string4 = StringEscapeUtils.escapeJavaScript(string2);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("javascript:window.");
        stringBuilder.append(string3);
        stringBuilder.append("('");
        stringBuilder.append(string4);
        stringBuilder.append("');");
        final String string5 = stringBuilder.toString();
        this._mainActivity.runOnUiThread(new Runnable(){

            public void run() {
                JavascriptInterface.this._webController.getWebView().loadUrl(string5);
            }
        });
    }

    @android.webkit.JavascriptInterface
    private void _scaleBitmapAndSetWallpaper(Bitmap bitmap) throws IOException {
        WallpaperManager wallpaperManager = WallpaperManager.getInstance((Context)this._mainActivity);
        new BitmapFactory.Options().inScaled = false;
        wallpaperManager.setBitmap(bitmap);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private String getBookmarksFromCursor(Cursor cursor) {
        JSONArray jSONArray = new JSONArray();
        if (cursor != null) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                JSONObject jSONObject = new JSONObject();
                for (int i2 = 0; i2 < cursor.getColumnCount(); ++i2) {
                    try {
                        Long l2 = cursor.getLong(i2);
                        String string2 = cursor.getString(i2);
                        if (string2 != null && string2.length() != 0) {
                            jSONObject.put(cursor.getColumnName(i2), (Object)string2);
                            continue;
                        }
                        jSONObject.put(cursor.getColumnName(i2), (Object)l2);
                        continue;
                    }
                    catch (JSONException jSONException) {
                        jSONException.printStackTrace();
                    }
                }
                jSONArray.put((Object)jSONObject);
                cursor.moveToNext();
            }
        }
        return jSONArray.toString();
    }

    @android.webkit.JavascriptInterface
    public void addBookmark(String string2, String string3, String string4) {
        Factory.getInstance().getBookmarkManager(string4).addBookmark(string2, string3);
    }

    @android.webkit.JavascriptInterface
    public void addToHomePage(String string2, String string3) {
        Factory.getInstance().getHomePageManager().addBookmark(string2, string3);
    }

    @android.webkit.JavascriptInterface
    public void clearUpdateCheckers() {
    }

    @android.webkit.JavascriptInterface
    public void downloadFile(String string2) {
        FileManager.downloadFile(new UrlConverter(this._webController.getWebView()).toAbsolute(string2), "", (Context)this._mainActivity);
    }

    @android.webkit.JavascriptInterface
    public String getAppId() {
        return Integer.toString((int)this._mainActivity.getConfig().getApplicationId());
    }

    @android.webkit.JavascriptInterface
    public String getAppName() {
        try {
            String string2 = Factory.getInstance().getMainNavigationActivity().getConfig().getWidgetName();
            return string2;
        }
        catch (Exception exception) {
            return null;
        }
    }

    @android.webkit.JavascriptInterface
    public String getAppPackageName() {
        try {
            String string2 = this._mainActivity.getApplicationContext().getPackageName();
            return string2;
        }
        catch (Exception exception) {
            return null;
        }
    }

    @android.webkit.JavascriptInterface
    public void getBase64FromImageUrl(String string2, String string3) {
        new BaseServerClient(this._mainActivity).sendRequestAsync(string2, 0, (BaseServerClient.OnRequestDoneListener)new 14(this, string3));
    }

    @android.webkit.JavascriptInterface
    public String getBookmarks(String string2) {
        return this.getBookmarksFromCursor(Factory.getInstance().getBookmarkManager(string2).getBookmarks());
    }

    @android.webkit.JavascriptInterface
    public String getBookmarks(String string2, String string3, String string4) {
        Integer n2 = Integer.parseInt((String)string2);
        Integer n3 = Integer.parseInt((String)string3);
        return this.getBookmarksFromCursor(Factory.getInstance().getBookmarkManager(string4).getBookmarks(n2, n3));
    }

    @android.webkit.JavascriptInterface
    public String getFileContents(String string2) {
        return FileManager.getStringFromAssetsFileWithFileName(string2, (Context)this._mainActivity);
    }

    @android.webkit.JavascriptInterface
    public String getHomePageItems() {
        return this.getBookmarksFromCursor(Factory.getInstance().getHomePageManager().getBookmarks());
    }

    @android.webkit.JavascriptInterface
    public String getHomePageItems(String string2, String string3) {
        Integer n2 = Integer.parseInt((String)string2);
        Integer n3 = Integer.parseInt((String)string3);
        return this.getBookmarksFromCursor(Factory.getInstance().getHomePageManager().getBookmarks(n2, n3));
    }

    @android.webkit.JavascriptInterface
    public String getItem(String string2) {
        SharedPreferences sharedPreferences = this._mainActivity.getSharedPreferences("JS-PREFERENCE", 0);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("JS-Preference-");
        stringBuilder.append(string2);
        return sharedPreferences.getString(stringBuilder.toString(), null);
    }

    @android.webkit.JavascriptInterface
    public String getTabContentType(String string2) {
        WidgetEntity widgetEntity = Factory.getInstance().getWidgetsController().getWidgetByTabId(string2);
        if (widgetEntity != null) {
            return widgetEntity.getTabType();
        }
        return "";
    }

    @android.webkit.JavascriptInterface
    public String getTabUrl(String string2) {
        WidgetEntity widgetEntity = Factory.getInstance().getWidgetsController().getWidgetByTabId(string2);
        if (widgetEntity != null) {
            return widgetEntity.getLink();
        }
        return "";
    }

    @android.webkit.JavascriptInterface
    public void getWeeklyHistory(final String string2) {
        this._mainActivity.runOnUiThread(new Runnable(){

            /*
             * Exception decompiling
             */
            public void run() {
                // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
                // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl61 : FAKE_TRY : trying to set 1 previously set to 0
                // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
                // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
                // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
                // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
                // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
                // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
                // org.benf.cfr.reader.entities.g.p(Method.java:396)
                // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
                // org.benf.cfr.reader.entities.d.c(ClassFile.java:773)
                // org.benf.cfr.reader.entities.d.e(ClassFile.java:870)
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
        });
    }

    @android.webkit.JavascriptInterface
    public void hideLoadingDialog() {
        this._mainActivity.runOnUiThread(new Runnable(){

            public void run() {
                if (JavascriptInterface.this._currentProgressDialog != null) {
                    JavascriptInterface.this._currentProgressDialog.hide();
                    JavascriptInterface.this._currentProgressDialog = null;
                }
            }
        });
    }

    public /* synthetic */ void lambda$showRewardedVideo$0$JavascriptInterface(String string2) {
        1 var2_2 = new 1(this, string2);
        AppsgeyserSDK.getFastTrackAdsController().showRewardedVideo((FastTrackBaseAdapter.RewardedVideoListener)var2_2, this._mainActivity.getResources().getString(2131755059));
    }

    @android.webkit.JavascriptInterface
    public void overrideRefreshAction(String string2) {
        this._webController.setPageRefreshJsCode(string2);
    }

    @android.webkit.JavascriptInterface
    public boolean playYouTubeVideo(String string2, String string3, int n2, boolean bl, boolean bl2) {
        try {
            Intent intent = YouTubeStandalonePlayer.createVideoIntent((Activity)this._mainActivity, (String)string3, (String)string2, (int)n2, (boolean)bl, (boolean)bl2);
            this._mainActivity.startActivity(intent);
            return true;
        }
        catch (Exception exception) {
            return false;
        }
    }

    @android.webkit.JavascriptInterface
    public void redirect(final String string2) {
        try {
            if (this._mainActivity == null) {
                return;
            }
            this._mainActivity.runOnUiThread(new Runnable(){

                public void run() {
                    Factory.getInstance().getTabsController().getSelectedTab().getWebView().loadUrl(string2);
                }
            });
            return;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return;
        }
    }

    @android.webkit.JavascriptInterface
    public void registerUpdateChecker(String string2, int n2) {
    }

    @android.webkit.JavascriptInterface
    public void removeBookmark(String string2, String string3) {
        Integer n2 = Integer.parseInt((String)string2);
        Factory.getInstance().getBookmarkManager(string3).removeBookmark(n2);
    }

    @android.webkit.JavascriptInterface
    public void removeFromHomepage(String string2) {
        Integer n2 = Integer.parseInt((String)string2);
        Factory.getInstance().getHomePageManager().removeBookmark(n2);
    }

    @android.webkit.JavascriptInterface
    public void removeHistoryAllItem() {
        this._mainActivity.runOnUiThread(new Runnable(){

            public void run() {
                JavascriptInterface.this._mainActivity.removeHistoryAllItem();
            }
        });
    }

    @android.webkit.JavascriptInterface
    public void removeHistoryItem(final long l2) {
        this._mainActivity.runOnUiThread(new Runnable(){

            public void run() {
                JavascriptInterface.this._mainActivity.removeHistoryItem(l2);
            }
        });
    }

    @android.webkit.JavascriptInterface
    public void removeUpdateChecker(String string2) {
    }

    @android.webkit.JavascriptInterface
    public String saveImageFromBase64(String string2, String string3) {
        Bitmap bitmap;
        File file;
        if (string3 == null) {
            string3 = "IMG";
        }
        if ((bitmap = ImageReader.createBitmapFromBase64(string2)) != null && (file = FileManager.saveBitmapToGallery(string3, bitmap, (Context)this._mainActivity)) != null) {
            this.showInfo("Image saved to gallery...");
            return file.toString();
        }
        return null;
    }

    @android.webkit.JavascriptInterface
    public void sendXMLHTTPRequest(final String string2, final String string3) {
        this._mainActivity.runOnUiThread(new Runnable(){

            public void run() {
                final String string22 = new UrlConverter(JavascriptInterface.this._webController.getWebView()).toAbsolute(string2);
                if (string22.startsWith("file:///")) {
                    new Thread(){

                        public void run() {
                            String string2 = "";
                            try {
                                string2 = FileManager.getStringFromAssetsFileWithFileName(string22.replace((CharSequence)"file:///android_asset/", (CharSequence)string2).replaceFirst("#.*", string2), (Context)JavascriptInterface.this._mainActivity);
                            }
                            catch (Exception exception) {
                                exception.printStackTrace();
                            }
                            JavascriptInterface.this.XmlHttpRequestDone(string2, string3);
                        }
                    }.start();
                    return;
                }
                new BaseServerClient(JavascriptInterface.this._mainActivity).sendRequestAsync(string22, 0, (BaseServerClient.OnRequestDoneListener)new 2(this));
            }

        });
    }

    @android.webkit.JavascriptInterface
    public void setItem(String string2, String string3) {
        SharedPreferences.Editor editor = this._mainActivity.getSharedPreferences("JS-PREFERENCE", 0).edit();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("JS-Preference-");
        stringBuilder.append(string2);
        editor.putString(stringBuilder.toString(), string3).commit();
    }

    @android.webkit.JavascriptInterface
    public void setMenuItemVisible(String string2, boolean bl) {
        if (string2 != null && !string2.equals((Object)"undefined") && !string2.isEmpty()) {
            this._mainActivity.setMenuItemVisible(string2.hashCode(), bl);
        }
    }

    @android.webkit.JavascriptInterface
    public void setScaleForPageWithSize(int n2, int n3) {
        this.mFinalHeight = n2;
        this.mFinalWidth = n3;
        MainNavigationActivity mainNavigationActivity = this._mainActivity;
        if (mainNavigationActivity != null) {
            mainNavigationActivity.runOnUiThread(new Runnable(){

                public void run() {
                    JavascriptInterface.this._webController.setScaleForPageWithSize(JavascriptInterface.this.mFinalHeight, JavascriptInterface.this.mFinalWidth);
                }
            });
        }
    }

    @android.webkit.JavascriptInterface
    public void setUrlBarVisibility(boolean bl) {
        int n2 = bl ? 0 : 8;
        this._mainActivity.setUrlBarVisibility(n2);
    }

    @android.webkit.JavascriptInterface
    public void setWallpaper(final String string2) {
        this._webController.getWebView().post(new Runnable(){

            public void run() {
                InputStream inputStream = new UrlConverter(JavascriptInterface.this._webController.getWebView()).toStream(string2);
                if (inputStream != null) {
                    Bitmap bitmap = BitmapFactory.decodeStream((InputStream)inputStream);
                    try {
                        JavascriptInterface.this._scaleBitmapAndSetWallpaper(bitmap);
                    }
                    catch (IOException iOException) {
                        iOException.printStackTrace();
                    }
                    bitmap.recycle();
                }
            }
        });
    }

    @android.webkit.JavascriptInterface
    public void sharePicture(String string2, String string3) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND");
        intent.setType("image/png");
        File file = new File(string2);
        if (file.exists()) {
            intent.putExtra("android.intent.extra.STREAM", (Parcelable)Uri.fromFile((File)file));
            this._mainActivity.startActivity(Intent.createChooser((Intent)intent, (CharSequence)string3));
            return;
        }
        if (Build.VERSION.SDK_INT < 23) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Error! Can't find ");
            stringBuilder.append(string2);
            stringBuilder.append("!");
            this.showInfo(stringBuilder.toString());
        }
    }

    @android.webkit.JavascriptInterface
    public void shareText(String string2, String string3) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.TEXT", string3);
        intent.putExtra("android.intent.extra.SUBJECT", string2);
        Factory.getInstance().getMainNavigationActivity().startActivity(Intent.createChooser((Intent)intent, (CharSequence)"Share using"));
    }

    @android.webkit.JavascriptInterface
    public void showInfo(String string2) {
        MainNavigationActivity mainNavigationActivity = this._mainActivity;
        if (mainNavigationActivity != null) {
            Toast.makeText((Context)mainNavigationActivity, (CharSequence)string2, (int)0).show();
        }
    }

    @android.webkit.JavascriptInterface
    public void showLoadingDialog(final String string2) {
        this._mainActivity.runOnUiThread(new Runnable(){

            public void run() {
                JavascriptInterface javascriptInterface = JavascriptInterface.this;
                javascriptInterface._currentProgressDialog = ProgressDialog.show((Context)javascriptInterface._mainActivity, (CharSequence)"", (CharSequence)string2, (boolean)true);
            }
        });
    }

    @android.webkit.JavascriptInterface
    public void showPdfView(final String string2, final String string3) {
        this._mainActivity.runOnUiThread(new Runnable(){

            public void run() {
                Intent intent = new Intent((Context)JavascriptInterface.this._mainActivity, PdfActivity.class);
                intent.putExtra("path_file", string2);
                intent.putExtra("widget_id", string3);
                JavascriptInterface.this._mainActivity.startActivity(intent);
            }
        });
    }

    @android.webkit.JavascriptInterface
    public void showPopup(String string2) {
    }

    @android.webkit.JavascriptInterface
    public void showRewardedVideo(String string2) {
        this._mainActivity.runOnUiThread((Runnable)new -$$Lambda$JavascriptInterface$1g6uWEKq52RmZKOG-mBRZ7n9sfQ(this, string2));
    }

    @android.webkit.JavascriptInterface
    public void showTabs() {
        this._mainActivity.runOnUiThread(new Runnable(){

            public void run() {
                JavascriptInterface.this._mainActivity.findViewById(2131296619).setVisibility(0);
            }
        });
    }

    @android.webkit.JavascriptInterface
    public String takeScreenShot() {
        return WebViewScreenShooter.takeScreenShotInBase64(Factory.getInstance().getTabsController().getSelectedTab().getWebView());
    }

    @android.webkit.JavascriptInterface
    public void updateIcon(final String string2, final String string3) {
        final HashMap<String, NavigationWidgetCustomIcon> hashMap = Factory.getInstance().getNavigationWidget().getCustomIcons();
        if (hashMap.containsKey((Object)string2)) {
            this._mainActivity.runOnUiThread(new Runnable(){

                public void run() {
                    ((NavigationWidgetCustomIcon)hashMap.get((Object)string2)).updateIcon(string3);
                }
            });
        }
    }

    @android.webkit.JavascriptInterface
    public void updateIconBadge(final String string2, final String string3) {
        final HashMap<String, NavigationWidgetCustomIcon> hashMap = Factory.getInstance().getNavigationWidget().getCustomIcons();
        if (hashMap.containsKey((Object)string2)) {
            this._mainActivity.runOnUiThread(new Runnable(){

                public void run() {
                    ((NavigationWidgetCustomIcon)hashMap.get((Object)string2)).updateBadge(string3);
                }
            });
        }
    }

    @android.webkit.JavascriptInterface
    public void zoomIn() {
        MainNavigationActivity mainNavigationActivity = this._mainActivity;
        if (mainNavigationActivity != null) {
            mainNavigationActivity.runOnUiThread(new Runnable(){

                public void run() {
                    JavascriptInterface.this._webController.zoomIn();
                }
            });
        }
    }

}

