/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.AttributeSet
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.widget.FrameLayout
 *  android.widget.TextView
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 */
package com.tappx.sdk.android;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tappx.a.a.a.h.g;
import com.tappx.a.a.a.h.h;
import com.tappx.sdk.android.R;

public class PrivacyView
extends FrameLayout {
    private View a;
    private View b;
    private boolean c;
    private g d;

    public PrivacyView(Context context) {
        super(context);
        this.a();
    }

    public PrivacyView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a();
    }

    public PrivacyView(Context context, AttributeSet attributeSet, int n2) {
        super(context, attributeSet, n2);
        this.a();
    }

    private void a() {
        LayoutInflater.from((Context)this.getContext()).inflate(R.layout.tappx_privacy_message, (ViewGroup)this, true);
        this.d = h.a(this.getContext()).a();
        this.b();
        this.a = this.findViewById(R.id.tappx_privacy_container_content);
        this.b = this.findViewById(R.id.tappx_privacy_container_expand_switch);
        View view = this.findViewById(R.id.tappx_privacy_button_yes);
        this.findViewById(R.id.tappx_privacy_button_no).setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                PrivacyView.this.setCollapsed(true);
            }
        });
        view.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                PrivacyView.this.d.a(view.getContext());
                PrivacyView.this.setCollapsed(true);
            }
        });
        this.b.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                PrivacyView privacyView = PrivacyView.this;
                privacyView.setCollapsed(true ^ privacyView.c);
            }
        });
        this.setCollapsed(true);
    }

    private void b() {
        TextView textView = (TextView)this.findViewById(R.id.tappx_privacy_text_message);
        String string2 = this.d.i();
        if (string2 != null) {
            textView.setText((CharSequence)string2);
        }
    }

    private void setCollapsed(boolean bl) {
        this.c = bl;
        View view = this.a;
        int n2 = bl ? 8 : 0;
        view.setVisibility(n2);
    }

}

