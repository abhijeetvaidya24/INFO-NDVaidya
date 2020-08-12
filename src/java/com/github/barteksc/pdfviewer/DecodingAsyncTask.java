/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.AsyncTask
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.lang.Void
 */
package com.github.barteksc.pdfviewer;

import android.content.Context;
import android.os.AsyncTask;
import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.source.DocumentSource;
import com.shockwave.pdfium.PdfDocument;
import com.shockwave.pdfium.PdfiumCore;

class DecodingAsyncTask
extends AsyncTask<Void, Void, Throwable> {
    private boolean cancelled;
    private Context context;
    private DocumentSource docSource;
    private String password;
    private PdfDocument pdfDocument;
    private PDFView pdfView;
    private PdfiumCore pdfiumCore;

    public DecodingAsyncTask(DocumentSource documentSource, String string, PDFView pDFView, PdfiumCore pdfiumCore) {
        this.docSource = documentSource;
        this.cancelled = false;
        this.pdfView = pDFView;
        this.password = string;
        this.pdfiumCore = pdfiumCore;
        this.context = pDFView.getContext();
    }

    protected /* varargs */ Throwable doInBackground(Void ... arrvoid) {
        try {
            this.pdfDocument = this.docSource.createDocument(this.context, this.pdfiumCore, this.password);
            return null;
        }
        catch (Throwable throwable) {
            return throwable;
        }
    }

    protected void onCancelled() {
        this.cancelled = true;
    }

    protected void onPostExecute(Throwable throwable) {
        if (throwable != null) {
            this.pdfView.loadError(throwable);
            return;
        }
        if (!this.cancelled) {
            this.pdfView.loadComplete(this.pdfDocument);
        }
    }
}

