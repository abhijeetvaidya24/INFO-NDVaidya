/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.os.AsyncTask
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewParent
 *  android.widget.ProgressBar
 *  android.widget.RelativeLayout
 *  android.widget.TextView
 *  com.appsgeyser.multiTabApp.MainNavigationActivity
 *  com.appsgeyser.multiTabApp.pdfreader.PdfLoader$2
 *  com.appsgeyser.multiTabApp.pdfreader.PdfLoader$3
 *  com.appsgeyser.multiTabApp.pdfreader.PdfLoader$4
 *  com.github.barteksc.pdfviewer.PDFView
 *  com.github.barteksc.pdfviewer.PDFView$Configurator
 *  com.github.barteksc.pdfviewer.listener.OnDrawListener
 *  com.github.barteksc.pdfviewer.listener.OnErrorListener
 *  com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener
 *  com.github.barteksc.pdfviewer.listener.OnPageChangeListener
 *  com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle
 *  com.github.barteksc.pdfviewer.scroll.ScrollHandle
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Void
 *  java.net.URL
 */
package com.appsgeyser.multiTabApp.pdfreader;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.view.View;
import android.view.ViewParent;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.appsgeyser.multiTabApp.Factory;
import com.appsgeyser.multiTabApp.MainNavigationActivity;
import com.appsgeyser.multiTabApp.pdfreader.PdfLoader;
import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnDrawListener;
import com.github.barteksc.pdfviewer.listener.OnErrorListener;
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener;
import com.github.barteksc.pdfviewer.listener.OnPageChangeListener;
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;
import com.github.barteksc.pdfviewer.scroll.ScrollHandle;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class PdfLoader {
    private static String savedPageKey = "";
    private TextView errorTextView;
    private String initialTabId;
    private String pathFile;
    private PdfEventListener pdfEventListener;
    private PDFView pdfView;
    private ProgressBar progressBar;
    private SharedPreferences sharedPreferences;

    public PdfLoader(PDFView pDFView, String string2, PdfEventListener pdfEventListener, String string3) {
        this.pdfView = pDFView;
        this.pathFile = string2;
        this.initialTabId = string3;
        this.pdfEventListener = pdfEventListener;
    }

    static /* synthetic */ TextView access$300(PdfLoader pdfLoader) {
        return pdfLoader.errorTextView;
    }

    static /* synthetic */ String access$500() {
        return savedPageKey;
    }

    static /* synthetic */ String access$502(String string2) {
        savedPageKey = string2;
        return string2;
    }

    static /* synthetic */ SharedPreferences access$600(PdfLoader pdfLoader) {
        return pdfLoader.sharedPreferences;
    }

    private void loadConfigurator(PDFView.Configurator configurator) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("pdf_saved_page_");
        stringBuilder.append(this.initialTabId);
        savedPageKey = stringBuilder.toString();
        int n2 = this.sharedPreferences.getInt(savedPageKey, 0);
        this.pdfView.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                if (PdfLoader.this.pdfEventListener != null) {
                    PdfLoader.this.pdfEventListener.handleEvent();
                }
            }
        });
        configurator.enableSwipe(true).enableDoubletap(true).defaultPage(n2).onDraw(null).onLoad((OnLoadCompleteListener)new 4(this)).onPageChange((OnPageChangeListener)new 3(this)).onError((OnErrorListener)new 2(this)).scrollHandle((ScrollHandle)new DefaultScrollHandle(this.pdfView.getContext())).enableAnnotationRendering(false).password(null).load();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void loadPdfFile() {
        PDFView.Configurator configurator;
        RelativeLayout relativeLayout = (RelativeLayout)this.pdfView.getParent();
        this.errorTextView = (TextView)relativeLayout.findViewById(2131296408);
        this.progressBar = (ProgressBar)relativeLayout.findViewById(2131296534);
        this.sharedPreferences = Factory.getInstance().getMainNavigationActivity().getSharedPreferences("AppsgeyserPrefs", 0);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("pdf_saved_page_");
        stringBuilder.append(this.initialTabId);
        savedPageKey = stringBuilder.toString();
        if (this.pathFile.startsWith("file:///")) {
            String string2 = this.pathFile.replace((CharSequence)"file:///android_asset/", (CharSequence)"");
            configurator = this.pdfView.fromAsset(string2);
        } else {
            boolean bl = this.pathFile.startsWith("http");
            configurator = null;
            if (bl) {
                String string3 = this.pathFile;
                new LoaderPdf().execute((Object[])new String[]{string3});
            }
        }
        this.pdfView.useBestQuality(true);
        if (configurator == null) return;
        try {
            this.loadConfigurator(configurator);
            return;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            this.progressBar.setVisibility(8);
        }
    }

    private class LoaderPdf
    extends AsyncTask<String, Void, InputStream> {
        private LoaderPdf() {
        }

        protected /* varargs */ InputStream doInBackground(String ... arrstring) {
            try {
                InputStream inputStream = new URL(arrstring[0]).openStream();
                return inputStream;
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
                return null;
            }
        }

        protected void onPostExecute(InputStream inputStream) {
            super.onPostExecute((Object)inputStream);
            PDFView.Configurator configurator = PdfLoader.this.pdfView.fromStream(inputStream);
            PdfLoader.this.loadConfigurator(configurator);
        }

        protected void onPreExecute() {
            super.onPreExecute();
            PdfLoader.this.progressBar.setVisibility(0);
        }
    }

    public static interface PdfEventListener {
        public void handleEvent();
    }

}

