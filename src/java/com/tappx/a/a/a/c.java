/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.animation.Interpolator
 *  java.lang.Double
 *  java.lang.Math
 *  java.lang.Object
 */
package com.tappx.a.a.a;

import android.view.animation.Interpolator;

public class c {

    public static class a
    implements Interpolator {
        private final float a;

        public a() {
            this.a = 0.0f;
        }

        public a(float f2) {
            this.a = f2;
        }

        public float getInterpolation(float f2) {
            float f3 = this.a;
            if (f3 == 0.0f) {
                f3 = 1.70158f;
            }
            return f2 * f2 * (f2 * (1.0f + f3) - f3);
        }
    }

    public static class aa
    implements Interpolator {
        public float getInterpolation(float f2) {
            float f3 = f2 * 2.0f;
            if (f3 < 1.0f) {
                return f3 * (f3 * (f3 * (f3 * (0.5f * f3))));
            }
            float f4 = f3 - 2.0f;
            return 0.5f * (2.0f + f4 * (f4 * (f4 * (f4 * f4))));
        }
    }

    public static class ab
    implements Interpolator {
        public float getInterpolation(float f2) {
            float f3 = f2 - 1.0f;
            return 1.0f + f3 * (f3 * (f3 * (f3 * f3)));
        }
    }

    public static class ac
    implements Interpolator {
        public float getInterpolation(float f2) {
            double d2 = f2;
            Double.isNaN((double)d2);
            return 1.0f + -((float)Math.cos((double)(d2 * 1.5707963267948966)));
        }
    }

    public static class ad
    implements Interpolator {
        public float getInterpolation(float f2) {
            double d2 = f2;
            Double.isNaN((double)d2);
            return -0.5f * (float)(Math.cos((double)(d2 * 3.141592653589793)) - 1.0);
        }
    }

    public static class ae
    implements Interpolator {
        public float getInterpolation(float f2) {
            double d2 = f2;
            Double.isNaN((double)d2);
            return (float)Math.sin((double)(d2 * 1.5707963267948966));
        }
    }

    public static class b
    implements Interpolator {
        private final float a;

        public b() {
            this.a = 0.0f;
        }

        public b(float f2) {
            this.a = f2;
        }

        public float getInterpolation(float f2) {
            float f3;
            float f4 = this.a;
            if (f4 == 0.0f) {
                f4 = 1.70158f;
            }
            if ((f3 = f2 * 2.0f) < 1.0f) {
                double d2 = f4;
                Double.isNaN((double)d2);
                float f5 = (float)(d2 * 1.525);
                return 0.5f * (f3 * f3 * (f3 * (1.0f + f5) - f5));
            }
            float f6 = f3 - 2.0f;
            double d3 = f4;
            Double.isNaN((double)d3);
            float f7 = (float)(d3 * 1.525);
            return 0.5f * (2.0f + f6 * f6 * (f7 + f6 * (1.0f + f7)));
        }
    }

    public static class c
    implements Interpolator {
        private final float a;

        public c() {
            this.a = 0.0f;
        }

        public c(float f2) {
            this.a = f2;
        }

        public float getInterpolation(float f2) {
            float f3 = this.a;
            if (f3 == 0.0f) {
                f3 = 1.70158f;
            }
            float f4 = f2 - 1.0f;
            return 1.0f + f4 * f4 * (f3 + f4 * (f3 + 1.0f));
        }
    }

    public static class d
    implements Interpolator {
        public float getInterpolation(float f2) {
            return 1.0f - new f().getInterpolation(1.0f - f2);
        }
    }

    public static class e
    implements Interpolator {
        public float getInterpolation(float f2) {
            if (f2 < 0.5f) {
                return 0.5f * new d().getInterpolation(f2 * 2.0f);
            }
            return 0.5f + 0.5f * new f().getInterpolation(f2 * 2.0f - 1.0f);
        }
    }

    public static class f
    implements Interpolator {
        public float getInterpolation(float f2) {
            double d2 = f2;
            if (d2 < 0.36363636363636365) {
                return f2 * (7.5625f * f2);
            }
            if (d2 < 0.7272727272727273) {
                Double.isNaN((double)d2);
                float f3 = (float)(d2 - 0.5454545454545454);
                return 0.75f + f3 * (7.5625f * f3);
            }
            if (d2 < 0.9090909090909091) {
                Double.isNaN((double)d2);
                float f4 = (float)(d2 - 0.8181818181818182);
                return 0.9375f + f4 * (7.5625f * f4);
            }
            Double.isNaN((double)d2);
            float f5 = (float)(d2 - 0.9545454545454546);
            return 0.984375f + f5 * (7.5625f * f5);
        }
    }

    public static class g
    implements Interpolator {
        public float getInterpolation(float f2) {
            return -((float)(Math.sqrt((double)(1.0f - f2 * f2)) - 1.0));
        }
    }

    public static class h
    implements Interpolator {
        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        public float getInterpolation(float f2) {
            float f3;
            double d2;
            float f4 = f2 * 2.0f;
            if (f4 < 1.0f) {
                f3 = -0.5f;
                d2 = Math.sqrt((double)(1.0f - f4 * f4)) - 1.0;
                do {
                    return f3 * (float)d2;
                    break;
                } while (true);
            }
            float f5 = f4 - 2.0f;
            f3 = 0.5f;
            d2 = 1.0 + Math.sqrt((double)(1.0f - f5 * f5));
            return f3 * (float)d2;
        }
    }

    public static class i
    implements Interpolator {
        public float getInterpolation(float f2) {
            float f3 = f2 - 1.0f;
            return (float)Math.sqrt((double)(1.0f - f3 * f3));
        }
    }

    public static class j
    implements Interpolator {
        public float getInterpolation(float f2) {
            return f2 * (f2 * f2);
        }
    }

    public static class k
    implements Interpolator {
        public float getInterpolation(float f2) {
            float f3 = f2 * 2.0f;
            if (f3 < 1.0f) {
                return f3 * (f3 * (0.5f * f3));
            }
            float f4 = f3 - 2.0f;
            return 0.5f * (2.0f + f4 * (f4 * f4));
        }
    }

    public static class l
    implements Interpolator {
        public float getInterpolation(float f2) {
            float f3 = f2 - 1.0f;
            return 1.0f + f3 * (f3 * f3);
        }
    }

    public static class m
    implements Interpolator {
        private final float a;
        private final float b;

        public m() {
            this.a = 0.0f;
            this.b = 0.0f;
        }

        public m(float f2, float f3) {
            this.a = f2;
            this.b = f3;
        }

        public float getInterpolation(float f2) {
            float f3;
            float f4 = this.b;
            float f5 = this.a;
            if (f2 == 0.0f) {
                return 0.0f;
            }
            if (f2 == 1.0f) {
                return 1.0f;
            }
            if (f4 == 0.0f) {
                f4 = 0.3f;
            }
            if (f5 != 0.0f && !(f5 < 1.0f)) {
                double d2 = f4;
                Double.isNaN((double)d2);
                f3 = (float)(d2 / 6.283185307179586 * Math.asin((double)(1.0f / f5)));
            } else {
                f3 = f4 / 4.0f;
                f5 = 1.0f;
            }
            float f6 = f2 - 1.0f;
            double d3 = f5;
            double d4 = Math.pow((double)2.0, (double)(10.0f * f6));
            Double.isNaN((double)d3);
            double d5 = d3 * d4;
            double d6 = f6 - f3;
            Double.isNaN((double)d6);
            double d7 = d6 * 6.283185307179586;
            double d8 = f4;
            Double.isNaN((double)d8);
            return -((float)(d5 * Math.sin((double)(d7 / d8))));
        }
    }

    public static class n
    implements Interpolator {
        private final float a;
        private final float b;

        public n() {
            this.a = 0.0f;
            this.b = 0.0f;
        }

        public n(float f2, float f3) {
            this.a = f2;
            this.b = f3;
        }

        public float getInterpolation(float f2) {
            float f3;
            float f4 = this.b;
            float f5 = this.a;
            if (f2 == 0.0f) {
                return 0.0f;
            }
            float f6 = f2 / 0.5f;
            if (f6 == 2.0f) {
                return 1.0f;
            }
            if (f4 == 0.0f) {
                f4 = 0.45000002f;
            }
            if (f5 != 0.0f && !(f5 < 1.0f)) {
                double d2 = f4;
                Double.isNaN((double)d2);
                f3 = (float)(d2 / 6.283185307179586 * Math.asin((double)(1.0f / f5)));
            } else {
                f3 = f4 / 4.0f;
                f5 = 1.0f;
            }
            if (f6 < 1.0f) {
                float f7 = f6 - 1.0f;
                double d3 = f5;
                double d4 = Math.pow((double)2.0, (double)(10.0f * f7));
                Double.isNaN((double)d3);
                double d5 = d3 * d4;
                double d6 = f7 - f3;
                Double.isNaN((double)d6);
                double d7 = d6 * 6.283185307179586;
                double d8 = f4;
                Double.isNaN((double)d8);
                return -0.5f * (float)(d5 * Math.sin((double)(d7 / d8)));
            }
            float f8 = f6 - 1.0f;
            double d9 = f5;
            double d10 = Math.pow((double)2.0, (double)(-10.0f * f8));
            Double.isNaN((double)d9);
            double d11 = d9 * d10;
            double d12 = f8 - f3;
            Double.isNaN((double)d12);
            double d13 = d12 * 6.283185307179586;
            double d14 = f4;
            Double.isNaN((double)d14);
            return (float)(1.0 + 0.5 * (d11 * Math.sin((double)(d13 / d14))));
        }
    }

    public static class o
    implements Interpolator {
        private final float a;
        private final float b;

        public o() {
            this.a = 0.0f;
            this.b = 0.0f;
        }

        public o(float f2, float f3) {
            this.a = f2;
            this.b = f3;
        }

        public float getInterpolation(float f2) {
            float f3;
            float f4 = this.b;
            float f5 = this.a;
            if (f2 == 0.0f) {
                return 0.0f;
            }
            if (f2 == 1.0f) {
                return 1.0f;
            }
            if (f4 == 0.0f) {
                f4 = 0.3f;
            }
            if (f5 != 0.0f && !(f5 < 1.0f)) {
                double d2 = f4;
                Double.isNaN((double)d2);
                f3 = (float)(d2 / 6.283185307179586 * Math.asin((double)(1.0f / f5)));
            } else {
                f3 = f4 / 4.0f;
                f5 = 1.0f;
            }
            double d3 = f5;
            double d4 = Math.pow((double)2.0, (double)(-10.0f * f2));
            Double.isNaN((double)d3);
            double d5 = d3 * d4;
            double d6 = f2 - f3;
            Double.isNaN((double)d6);
            double d7 = d6 * 6.283185307179586;
            double d8 = f4;
            Double.isNaN((double)d8);
            return (float)(1.0 + d5 * Math.sin((double)(d7 / d8)));
        }
    }

    public static class p
    implements Interpolator {
        public float getInterpolation(float f2) {
            if (f2 == 0.0f) {
                return 0.0f;
            }
            return (float)Math.pow((double)2.0, (double)(10.0f * (f2 - 1.0f)));
        }
    }

    public static class q
    implements Interpolator {
        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        public float getInterpolation(float f2) {
            float f3;
            if (f2 == 0.0f) {
                return 0.0f;
            }
            if (f2 == 1.0f) {
                return 1.0f;
            }
            float f4 = f2 * 2.0f;
            if (f4 < 1.0f) {
                f3 = (float)Math.pow((double)2.0, (double)(10.0f * (f4 - 1.0f)));
                do {
                    return f3 * 0.5f;
                    break;
                } while (true);
            }
            f3 = (float)(2.0 + -Math.pow((double)2.0, (double)(-10.0f * (f4 - 1.0f))));
            return f3 * 0.5f;
        }
    }

    public static class r
    implements Interpolator {
        public float getInterpolation(float f2) {
            if (f2 == 1.0f) {
                return 1.0f;
            }
            return (float)(1.0 + -Math.pow((double)2.0, (double)(f2 * -10.0f)));
        }
    }

    public static class s
    implements Interpolator {
        public float getInterpolation(float f2) {
            return f2;
        }
    }

    public static class t
    implements Interpolator {
        public float getInterpolation(float f2) {
            return f2 * f2;
        }
    }

    public static class u
    implements Interpolator {
        public float getInterpolation(float f2) {
            float f3 = f2 * 2.0f;
            if (f3 < 1.0f) {
                return f3 * (0.5f * f3);
            }
            float f4 = f3 - 1.0f;
            return -0.5f * (f4 * (f4 - 2.0f) - 1.0f);
        }
    }

    public static class v
    implements Interpolator {
        public float getInterpolation(float f2) {
            return -f2 * (f2 - 2.0f);
        }
    }

    public static class w
    implements Interpolator {
        public float getInterpolation(float f2) {
            return f2 * (f2 * (f2 * f2));
        }
    }

    public static class x
    implements Interpolator {
        public float getInterpolation(float f2) {
            float f3 = f2 * 2.0f;
            if (f3 < 1.0f) {
                return f3 * (f3 * (f3 * (0.5f * f3)));
            }
            float f4 = f3 - 2.0f;
            return -0.5f * (f4 * (f4 * (f4 * f4)) - 2.0f);
        }
    }

    public static class y
    implements Interpolator {
        public float getInterpolation(float f2) {
            float f3 = f2 - 1.0f;
            return -(f3 * (f3 * (f3 * f3)) - 1.0f);
        }
    }

    public static class z
    implements Interpolator {
        public float getInterpolation(float f2) {
            return f2 * (f2 * (f2 * (f2 * f2)));
        }
    }

}

