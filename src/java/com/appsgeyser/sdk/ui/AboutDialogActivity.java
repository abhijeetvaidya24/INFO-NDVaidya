/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.content.res.Resources
 *  android.graphics.drawable.Drawable
 *  android.net.Uri
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.text.Html
 *  android.text.method.LinkMovementMethod
 *  android.text.method.MovementMethod
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.Button
 *  android.widget.ImageView
 *  android.widget.TextView
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.appsgeyser.sdk.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.appsgeyser.sdk.R;
import com.appsgeyser.sdk.configuration.Configuration;
import com.appsgeyser.sdk.configuration.models.ConfigPhp;
import com.appsgeyser.sdk.server.implementation.AppsgeyserServerClient;

public class AboutDialogActivity
extends Activity {
    private TextView appName;
    private TextView appVersion;
    private ImageView appsgeyserDescriptionLogoImageView;
    private ImageView closeScreenImageView;
    private Configuration config;
    private ConfigPhp configPhp;
    private String description;
    private TextView descriptionTextView;
    private String descriptionType;
    private ImageView logoImageView;
    private Button privacy;
    private TextView templateVersion;
    private Button tos;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void init() {
        try {
            this.config = Configuration.getInstance((Context)this);
            String string2 = this.config.getApplicationId();
            this.logoImageView = (ImageView)this.findViewById(R.id.logo);
            this.appsgeyserDescriptionLogoImageView = (ImageView)this.findViewById(R.id.appsgeysersdk_about_appsgeyser_logo);
            this.closeScreenImageView = (ImageView)this.findViewById(R.id.close_about_screen);
            this.descriptionTextView = (TextView)this.findViewById(R.id.description);
            this.appName = (TextView)this.findViewById(R.id.about_app_name);
            this.appVersion = (TextView)this.findViewById(R.id.app_version);
            this.templateVersion = (TextView)this.findViewById(R.id.template_version);
            this.tos = (Button)this.findViewById(R.id.app_tos);
            this.privacy = (Button)this.findViewById(R.id.app_privacy);
            try {
                PackageManager packageManager = this.getPackageManager();
                String string3 = (String)packageManager.getApplicationLabel(packageManager.getApplicationInfo(this.getPackageName(), 128));
                TextView textView = this.appVersion;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Version ");
                stringBuilder.append(this.getPackageManager().getPackageInfo((String)this.getPackageName(), (int)0).versionName);
                textView.setText((CharSequence)stringBuilder.toString());
                this.appName.setText((CharSequence)string3);
            }
            catch (PackageManager.NameNotFoundException nameNotFoundException) {
                nameNotFoundException.printStackTrace();
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("http://www.appsgeyser.com?pn=");
            stringBuilder.append(this.getPackageName());
            final String string4 = stringBuilder.toString();
            this.logoImageView.setImageDrawable(this.getPackageManager().getApplicationIcon(this.getPackageName()));
            this.logoImageView.setOnClickListener(new View.OnClickListener(){

                public void onClick(View view) {
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse((String)string4));
                    intent.setFlags(268435456);
                    AboutDialogActivity.this.startActivity(intent);
                    AppsgeyserServerClient.getInstance().sendAboutDialogVisitSite(AboutDialogActivity.this.getApplicationContext());
                }
            });
            this.closeScreenImageView.setOnClickListener(new View.OnClickListener(){

                public void onClick(View view) {
                    AboutDialogActivity.this.finish();
                }
            });
            this.templateVersion.setText((CharSequence)this.getString(R.string.appsgeysersdk_build, new Object[]{"2.14.s"}));
            String string5 = this.getResources().getString(R.string.appsgeysersdk_description_with_publish_name);
            if (this.config.getPublisherName().length() == 0) {
                string5 = this.getResources().getString(R.string.appsgeysersdk_description_without_publish_name);
            }
            if (this.descriptionType != null) {
                String string6 = this.descriptionType;
                int n2 = -1;
                int n3 = string6.hashCode();
                if (n3 != -1349088399) {
                    if (n3 != 1502878931) {
                        if (n3 == 1503108181 && string6.equals((Object)"appsgeyser_text")) {
                            n2 = 0;
                        }
                    } else if (string6.equals((Object)"appsgeyser_logo")) {
                        n2 = 1;
                    }
                } else if (string6.equals((Object)"custom")) {
                    n2 = 2;
                }
                if (n2 != 0) {
                    if (n2 != 1) {
                        if (n2 != 2) {
                            this.appsgeyserDescriptionLogoImageView.setVisibility(8);
                            this.descriptionTextView.setVisibility(0);
                        } else {
                            string5 = this.description;
                            this.appsgeyserDescriptionLogoImageView.setVisibility(8);
                            this.descriptionTextView.setVisibility(0);
                        }
                    } else {
                        this.appsgeyserDescriptionLogoImageView.setVisibility(0);
                        this.descriptionTextView.setVisibility(8);
                    }
                } else {
                    this.appsgeyserDescriptionLogoImageView.setVisibility(8);
                    this.descriptionTextView.setVisibility(0);
                }
            }
            String string7 = string5.replace((CharSequence)"PUB_NAME", (CharSequence)this.config.getPublisherName()).replace((CharSequence)"APPSGEYSER_URL", (CharSequence)string4).replace((CharSequence)"APP_VERSION", (CharSequence)"").replace((CharSequence)"APP_ID", (CharSequence)string2);
            this.descriptionTextView.setText((CharSequence)Html.fromHtml((String)string7));
            this.descriptionTextView.setLinksClickable(true);
            this.descriptionTextView.setMovementMethod(LinkMovementMethod.getInstance());
            this.tos.setOnClickListener(new View.OnClickListener(){

                public void onClick(View view) {
                    Intent intent = new Intent("android.intent.action.VIEW");
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("http://www.appsgeyser.com/tos/?pn=");
                    stringBuilder.append(AboutDialogActivity.this.getPackageName());
                    Intent intent2 = intent.setData(Uri.parse((String)stringBuilder.toString()));
                    intent2.setFlags(268435456);
                    AboutDialogActivity.this.startActivity(intent2);
                }
            });
            this.privacy.setOnClickListener(new View.OnClickListener(){

                public void onClick(View view) {
                    Intent intent = new Intent("android.intent.action.VIEW");
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("http://www.appsgeyser.com/privacy/app/?pn=");
                    stringBuilder.append(AboutDialogActivity.this.getPackageName());
                    Intent intent2 = intent.setData(Uri.parse((String)stringBuilder.toString()));
                    intent2.setFlags(268435456);
                    AboutDialogActivity.this.startActivity(intent2);
                }
            });
            return;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return;
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.setContentView(R.layout.appsgeysersdk_about_dialog);
        if (bundle != null) {
            this.configPhp = (ConfigPhp)bundle.getParcelable("config_php_key");
        } else {
            Intent intent = this.getIntent();
            if (intent != null) {
                this.configPhp = (ConfigPhp)intent.getParcelableExtra("config_php_key");
            }
        }
        ConfigPhp configPhp = this.configPhp;
        if (configPhp != null) {
            this.descriptionType = configPhp.getAboutScreenDescriptionType();
            this.description = this.configPhp.getAboutScreenDescription();
        }
        this.init();
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putParcelable("config_php_key", (Parcelable)this.configPhp);
        super.onSaveInstanceState(bundle);
    }

}

