/*
 * Decompiled with CFR 0.152.
 */
package jp.studiopixel.doukutsu;

public class Triangle {
    public static int[] gSin = new int[256];
    public static short[] gTan = new short[33];

    public static void InitTriangleTable() {
        int i;
        for (i = 0; i < 256; ++i) {
            Triangle.gSin[i] = (int)(Math.sin((double)i * 6.2831998 / 256.0) * 512.0);
        }
        for (i = 0; i < 33; ++i) {
            float a = (float)i * ((float)Math.PI * 2) / 256.0f;
            float b = (float)Math.sin(a) / (float)Math.cos(a);
            Triangle.gTan[i] = (short)(b * 8192.0f);
        }
    }

    public static int GetSin(char deg) {
        return gSin[deg & 0xFF];
    }

    public static int GetCos(char deg) {
        deg = (char)(deg + 64);
        return gSin[deg & 0xFF];
    }

    public static int GetArktan(int x, int y) {
        y *= -1;
        int a = 0;
        if ((x *= -1) > 0) {
            if (y > 0) {
                if (x > y) {
                    short k = (short)(y * 8192 / x);
                    while (k > gTan[a]) {
                        a = (char)(a + 1 & 0xFF);
                    }
                } else {
                    short k = (short)(x * 8192 / y);
                    while (k > gTan[a]) {
                        a = (char)(a + 1 & 0xFF);
                    }
                    a = (char)(64 - a);
                }
            } else if (x > -y) {
                short k = (short)(-y * 8192 / x);
                while (k > gTan[a]) {
                    a = (char)(a + 1 & 0xFF);
                }
                a = (char)(256 - a);
            } else {
                short k = (short)(x * 8192 / -y);
                while (k > gTan[a]) {
                    a = (char)(a + 1 & 0xFF);
                }
                a = (char)(192 + a);
            }
        } else if (y > 0) {
            if (-x > y) {
                short k = (short)(y * 8192 / -x);
                while (k > gTan[a]) {
                    a = (char)(a + 1 & 0xFF);
                }
                a = (char)(128 - a & 0xFF);
            } else {
                short k = (short)(-x * 8192 / y);
                while (k > gTan[a]) {
                    a = (char)(a + 1 & 0xFF);
                }
                a = (char)(64 + a & 0xFF);
            }
        } else if (-x > -y) {
            short k = (short)(-y * 8192 / -x);
            while (k > gTan[a]) {
                a = (char)(a + 1 & 0xFF);
            }
            a = (char)(128 + a & 0xFF);
        } else {
            short k = (short)(-x * 8192 / -y);
            while (k > gTan[a]) {
                a = (char)(a + 1 & 0xFF);
            }
            a = (char)(192 - a);
        }
        return a & 0xFF;
    }
}
