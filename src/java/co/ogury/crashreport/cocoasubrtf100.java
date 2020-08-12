/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  co.ogury.crashreport.ii
 *  co.ogury.crashreport.viewh8400
 *  java.io.File
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.StackTraceElement
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Throwable
 *  org.json.JSONObject
 */
package co.ogury.crashreport;

import co.ogury.crashreport.Helvetica;
import co.ogury.crashreport.SdkInfo;
import co.ogury.crashreport.ansi;
import co.ogury.crashreport.blue255;
import co.ogury.crashreport.colortbl;
import co.ogury.crashreport.green255;
import co.ogury.crashreport.ii;
import co.ogury.crashreport.margl1440;
import co.ogury.crashreport.red255;
import co.ogury.crashreport.tx8640;
import co.ogury.crashreport.viewh8400;
import java.io.File;
import org.json.JSONObject;

public final class cocoasubrtf100 {
    private String a;
    private String b;
    private final SdkInfo c;

    static {
        new rtf1(0);
    }

    public cocoasubrtf100(SdkInfo sdkInfo) {
        tx8640.b(sdkInfo, "sdkInfo");
        this.c = sdkInfo;
    }

    public final ansi a(Throwable throwable, red255 red2552, co.ogury.crashreport.rtf1 rtf12, Helvetica helvetica) {
        margl1440 margl14402;
        block12 : {
            JSONObject jSONObject;
            String string;
            String string2;
            block11 : {
                boolean bl;
                block10 : {
                    tx8640.b((Object)throwable, "throwable");
                    tx8640.b(red2552, "phoneInfo");
                    tx8640.b(rtf12, "appInfo");
                    tx8640.b(helvetica, "fileStore");
                    File[] arrfile = helvetica.a();
                    Object[] arrobject = throwable.getStackTrace();
                    tx8640.a((Object)arrobject, "throwable.stackTrace");
                    this.a = viewh8400.a((Object[])arrobject, (CharSequence)"\n", null, null, (int)0, null, null, (int)62);
                    for (File file : arrfile) {
                        String string3 = this.a;
                        if (string3 == null) {
                            tx8640.a("stackTrace");
                        }
                        CharSequence charSequence = string3;
                        String string4 = file.getName();
                        tx8640.a((Object)string4, "file.name");
                        if (!ii.a((CharSequence)charSequence, (CharSequence)string4, (boolean)false, (int)2)) continue;
                        String string5 = file.getName();
                        tx8640.a((Object)string5, "file.name");
                        this.b = string5;
                        bl = false;
                        break block10;
                    }
                    bl = true;
                }
                if (bl) {
                    return colortbl.a;
                }
                jSONObject = new JSONObject();
                jSONObject.put("created_at", System.currentTimeMillis());
                jSONObject.put("sdk_version", (Object)this.c.getSdkVersion());
                jSONObject.put("api_key", (Object)this.c.getApiKey());
                jSONObject.put("aaid", (Object)this.c.getAaid());
                jSONObject.put("package_name", (Object)rtf12.b());
                jSONObject.put("package_version", (Object)rtf12.a());
                string2 = red2552.a();
                if (string2.length() <= 16) break block11;
                if (string2 == null) break block12;
                string2 = string2.substring(0, 16);
                tx8640.a((Object)string2, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
            }
            jSONObject.put("phone_model", (Object)string2);
            jSONObject.put("android_version", (Object)red2552.b());
            jSONObject.put("exception_type", (Object)throwable.getClass().getCanonicalName());
            green255 green2552 = red2552.c();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(throwable.getClass().getName());
            stringBuilder.append(" : ");
            stringBuilder.append(throwable.getMessage());
            if (green2552.d()) {
                StringBuilder stringBuilder2 = new StringBuilder(" : Free[");
                stringBuilder2.append(green2552.a());
                stringBuilder2.append("] Total[");
                stringBuilder2.append(green2552.b());
                stringBuilder2.append("] Max[");
                stringBuilder2.append(green2552.c());
                stringBuilder2.append("]");
                string = stringBuilder2.toString();
            } else {
                string = "";
            }
            stringBuilder.append(string);
            jSONObject.put("message", (Object)stringBuilder.toString());
            String string6 = this.a;
            if (string6 == null) {
                tx8640.a("stackTrace");
            }
            jSONObject.put("stacktrace", (Object)string6);
            String string7 = jSONObject.toString();
            tx8640.a((Object)string7, "jsonObject.toString()");
            String string8 = this.b;
            if (string8 == null) {
                tx8640.a("packageName");
            }
            return new blue255(string7, string8);
        }
        margl14402 = new margl1440("null cannot be cast to non-null type java.lang.String");
        throw margl14402;
    }

    public static final class rtf1 {
        private rtf1() {
        }

        public /* synthetic */ rtf1(byte by2) {
            this();
        }
    }

}

