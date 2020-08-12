/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.AssetFileDescriptor
 *  android.media.MediaPlayer
 *  android.media.MediaPlayer$OnCompletionListener
 *  android.media.MediaPlayer$OnErrorListener
 *  android.media.MediaPlayer$OnPreparedListener
 *  android.net.Uri
 *  android.webkit.JavascriptInterface
 *  android.webkit.WebView
 *  java.io.FileDescriptor
 *  java.io.IOException
 *  java.lang.CharSequence
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.SecurityException
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.appsgeyser.multiTabApp.media;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.net.Uri;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.appsgeyser.multiTabApp.utils.UrlConverter;
import java.io.FileDescriptor;
import java.io.IOException;

public class WebViewJsAudioPlayer {
    public static String JS_INTERFACE_NAME = "AudioPlayer";
    private String _onLoadListener;
    private String _onTrackFinishedListener;
    private WebView _parentWebView;
    private MediaPlayer _player;

    public WebViewJsAudioPlayer(WebView webView) {
        this._parentWebView = webView;
        this._player = new MediaPlayer();
    }

    @JavascriptInterface
    private void _callFunction(String string2, String[] arrstring) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("javascript:");
        stringBuilder.append(string2);
        stringBuilder.append("(");
        if (arrstring != null) {
            int n2 = arrstring.length;
            int n3 = 0;
            for (int i2 = 0; i2 < n2; ++i2) {
                String string3 = arrstring[i2];
                if (n3 > 0) {
                    stringBuilder.append(",");
                }
                stringBuilder.append("'");
                stringBuilder.append(string3.replace((CharSequence)"'", (CharSequence)"'"));
                stringBuilder.append("'");
                ++n3;
            }
        }
        stringBuilder.append(");");
        final String string4 = stringBuilder.toString();
        this._parentWebView.post(new Runnable(){

            public void run() {
                WebViewJsAudioPlayer.this._parentWebView.loadUrl(string4);
            }
        });
    }

    @JavascriptInterface
    private void _playInternet(String string2) {
        Uri uri = Uri.parse((String)string2);
        try {
            this._player.setDataSource(this._parentWebView.getContext(), uri);
            this._player.setAudioStreamType(3);
            this._player.prepareAsync();
            return;
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
            return;
        }
        catch (IllegalStateException illegalStateException) {
            illegalStateException.printStackTrace();
            return;
        }
        catch (SecurityException securityException) {
            securityException.printStackTrace();
            return;
        }
        catch (IllegalArgumentException illegalArgumentException) {
            illegalArgumentException.printStackTrace();
            return;
        }
    }

    @JavascriptInterface
    private void _playLocal(String string2) {
        UrlConverter urlConverter = new UrlConverter(this._parentWebView);
        if (string2.contains((CharSequence)"file://")) {
            try {
                AssetFileDescriptor assetFileDescriptor = urlConverter.toFileDescriptor(string2);
                this._player.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
                this._player.setAudioStreamType(3);
                this._player.prepareAsync();
                return;
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
                return;
            }
            catch (IllegalStateException illegalStateException) {
                illegalStateException.printStackTrace();
                return;
            }
            catch (SecurityException securityException) {
                securityException.printStackTrace();
                return;
            }
            catch (IllegalArgumentException illegalArgumentException) {
                illegalArgumentException.printStackTrace();
            }
        }
    }

    @JavascriptInterface
    private void _setPlayerEvenets() {
        this._player.setOnPreparedListener(new MediaPlayer.OnPreparedListener(){

            public void onPrepared(MediaPlayer mediaPlayer) {
                if (WebViewJsAudioPlayer.this._onLoadListener != null && WebViewJsAudioPlayer.this._onLoadListener.length() != 0) {
                    WebViewJsAudioPlayer webViewJsAudioPlayer = WebViewJsAudioPlayer.this;
                    webViewJsAudioPlayer._callFunction(webViewJsAudioPlayer._onLoadListener, null);
                }
                mediaPlayer.start();
            }
        });
        this._player.setOnCompletionListener(new MediaPlayer.OnCompletionListener(){

            public void onCompletion(MediaPlayer mediaPlayer) {
                if (mediaPlayer.isPlaying() && WebViewJsAudioPlayer.this._onTrackFinishedListener != null && WebViewJsAudioPlayer.this._onTrackFinishedListener.length() != 0) {
                    WebViewJsAudioPlayer webViewJsAudioPlayer = WebViewJsAudioPlayer.this;
                    webViewJsAudioPlayer._callFunction(webViewJsAudioPlayer._onTrackFinishedListener, null);
                }
            }
        });
        this._player.setOnErrorListener(new MediaPlayer.OnErrorListener(){

            public boolean onError(MediaPlayer mediaPlayer, int n2, int n3) {
                WebViewJsAudioPlayer.this._player.reset();
                return false;
            }
        });
    }

    @JavascriptInterface
    public int getCurrentPosition() {
        MediaPlayer mediaPlayer = this._player;
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            return this._player.getCurrentPosition();
        }
        return 0;
    }

    @JavascriptInterface
    public int getDuration() {
        MediaPlayer mediaPlayer = this._player;
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            return this._player.getDuration();
        }
        return 0;
    }

    @JavascriptInterface
    public void pause() {
        MediaPlayer mediaPlayer = this._player;
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            this._player.pause();
        }
    }

    @JavascriptInterface
    public void play(String string2) {
        String string3 = new UrlConverter(this._parentWebView).toAbsolute(string2);
        this.stop();
        this._setPlayerEvenets();
        if (string3.contains((CharSequence)"file://")) {
            this._playLocal(string3);
            return;
        }
        this._playInternet(string3);
    }

    @JavascriptInterface
    public void resume() {
        MediaPlayer mediaPlayer = this._player;
        if (mediaPlayer != null && !mediaPlayer.isPlaying()) {
            this._player.start();
        }
    }

    @JavascriptInterface
    public void setOnLoadListener(String string2) {
        this._onLoadListener = string2;
    }

    @JavascriptInterface
    public void setOnTrackFinishedListener(String string2) {
        this._onTrackFinishedListener = string2;
    }

    @JavascriptInterface
    public void stop() {
        MediaPlayer mediaPlayer = this._player;
        if (mediaPlayer != null) {
            if (mediaPlayer.isPlaying()) {
                this._player.stop();
            }
            this._player.reset();
        }
    }

}

