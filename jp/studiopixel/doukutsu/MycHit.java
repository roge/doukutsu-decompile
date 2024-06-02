/*
 * Decompiled with CFR 0.152.
 */
package jp.studiopixel.doukutsu;

import jp.studiopixel.doukutsu.Back;
import jp.studiopixel.doukutsu.Boss;
import jp.studiopixel.doukutsu.Caret;
import jp.studiopixel.doukutsu.Game;
import jp.studiopixel.doukutsu.KeyControl;
import jp.studiopixel.doukutsu.Map;
import jp.studiopixel.doukutsu.MyChar;
import jp.studiopixel.doukutsu.MycParam;
import jp.studiopixel.doukutsu.NpChar;
import jp.studiopixel.doukutsu.Sound;
import jp.studiopixel.doukutsu.TextScr;

public class MycHit {
    public static void ResetMyCharFlag() {
        MyChar.gMC.flag = 0;
    }

    private static void PutlittleStar() {
        if ((MyChar.gMC.cond & 2) == 0 && MyChar.gMC.ym < -512) {
            Sound.PlaySoundObject(3, 1);
            Caret.SetCaret(MyChar.gMC.x, MyChar.gMC.y - MyChar.gMC.hit.top, 13, 0);
            Caret.SetCaret(MyChar.gMC.x, MyChar.gMC.y - MyChar.gMC.hit.top, 13, 0);
        }
    }

    public static int JudgeHitMyCharBlock(int x, int y) {
        int hit = 0;
        if (MyChar.gMC.y - MyChar.gMC.hit.top < (y * 16 + 4) * 512 && MyChar.gMC.y + MyChar.gMC.hit.bottom > (y * 16 - 4) * 512 && MyChar.gMC.x - MyChar.gMC.hit.back < (x * 16 + 8) * 512 && MyChar.gMC.x - MyChar.gMC.hit.back > x * 16 * 512) {
            MyChar.gMC.x = (x * 16 + 8) * 512 + MyChar.gMC.hit.back;
            if (MyChar.gMC.xm < -384) {
                MyChar.gMC.xm = -384;
            }
            if ((KeyControl.gKey & KeyControl.gKeyLeft) == 0 && MyChar.gMC.xm < 0) {
                MyChar.gMC.xm = 0;
            }
            hit |= 1;
        }
        if (MyChar.gMC.y - MyChar.gMC.hit.top < (y * 16 + 4) * 512 && MyChar.gMC.y + MyChar.gMC.hit.bottom > (y * 16 - 4) * 512 && MyChar.gMC.x + MyChar.gMC.hit.back > (x * 16 - 8) * 512 && MyChar.gMC.x + MyChar.gMC.hit.back < x * 16 * 512) {
            MyChar.gMC.x = (x * 16 - 8) * 512 - MyChar.gMC.hit.back;
            if (MyChar.gMC.xm > 384) {
                MyChar.gMC.xm = 384;
            }
            if ((KeyControl.gKey & KeyControl.gKeyRight) == 0 && MyChar.gMC.xm > 0) {
                MyChar.gMC.xm = 0;
            }
            hit |= 4;
        }
        if (MyChar.gMC.x - MyChar.gMC.hit.back < (x * 16 + 5) * 512 && MyChar.gMC.x + MyChar.gMC.hit.back > (x * 16 - 5) * 512 && MyChar.gMC.y - MyChar.gMC.hit.top < (y * 16 + 8) * 512 && MyChar.gMC.y - MyChar.gMC.hit.top > y * 16 * 512) {
            MyChar.gMC.y = (y * 16 + 8) * 512 + MyChar.gMC.hit.top;
            if ((MyChar.gMC.cond & 2) == 0 && MyChar.gMC.ym < -512) {
                MycHit.PutlittleStar();
            }
            if (MyChar.gMC.ym < 0) {
                MyChar.gMC.ym = 0;
            }
            hit |= 2;
        }
        if (MyChar.gMC.x - MyChar.gMC.hit.back < (x * 16 + 5) * 512 && MyChar.gMC.x + MyChar.gMC.hit.back > (x * 16 - 5) * 512 && MyChar.gMC.y + MyChar.gMC.hit.bottom > (y * 16 - 8) * 512 && MyChar.gMC.y + MyChar.gMC.hit.bottom < y * 16 * 512) {
            MyChar.gMC.y = (y * 16 - 8) * 512 - MyChar.gMC.hit.bottom;
            if (MyChar.gMC.ym > 1024) {
                Sound.PlaySoundObject(23, 1);
            }
            if (MyChar.gMC.ym > 0) {
                MyChar.gMC.ym = 0;
            }
            hit |= 8;
        }
        return hit;
    }

    public static int JudgeHitMyCharTriangleA(int x, int y) {
        int hit = 0;
        if (MyChar.gMC.x < (x * 16 + 8) * 512 && MyChar.gMC.x > (x * 16 - 8) * 512 && MyChar.gMC.y - MyChar.gMC.hit.top < y * 16 * 512 - (MyChar.gMC.x - x * 16 * 512) / 2 + 2048 && MyChar.gMC.y + MyChar.gMC.hit.bottom > (y * 16 - 8) * 512) {
            MyChar.gMC.y = y * 16 * 512 - (MyChar.gMC.x - x * 16 * 512) / 2 + 2048 + MyChar.gMC.hit.top;
            if ((MyChar.gMC.cond & 2) == 0 && MyChar.gMC.ym < -512) {
                MycHit.PutlittleStar();
            }
            if (MyChar.gMC.ym < 0) {
                MyChar.gMC.ym = 0;
            }
            hit |= 2;
        }
        return hit;
    }

    public static int JudgeHitMyCharTriangleB(int x, int y) {
        int hit = 0;
        if (MyChar.gMC.x < (x * 16 + 8) * 512 && MyChar.gMC.x > (x * 16 - 8) * 512 && MyChar.gMC.y - MyChar.gMC.hit.top < y * 16 * 512 - (MyChar.gMC.x - x * 16 * 512) / 2 - 2048 && MyChar.gMC.y + MyChar.gMC.hit.bottom > (y * 16 - 8) * 512) {
            MyChar.gMC.y = y * 16 * 512 - (MyChar.gMC.x - x * 16 * 512) / 2 - 2048 + MyChar.gMC.hit.top;
            if ((MyChar.gMC.cond & 2) == 0 && MyChar.gMC.ym < -512) {
                MycHit.PutlittleStar();
            }
            if (MyChar.gMC.ym < 0) {
                MyChar.gMC.ym = 0;
            }
            hit |= 2;
        }
        return hit;
    }

    public static int JudgeHitMyCharTriangleC(int x, int y) {
        int hit = 0;
        if (MyChar.gMC.x < (x * 16 + 8) * 512 && MyChar.gMC.x > (x * 16 - 8) * 512 && MyChar.gMC.y - MyChar.gMC.hit.top < y * 16 * 512 + (MyChar.gMC.x - x * 16 * 512) / 2 - 2048 && MyChar.gMC.y + MyChar.gMC.hit.bottom > (y * 16 - 8) * 512) {
            MyChar.gMC.y = y * 16 * 512 + (MyChar.gMC.x - x * 16 * 512) / 2 - 2048 + MyChar.gMC.hit.top;
            if ((MyChar.gMC.cond & 2) == 0 && MyChar.gMC.ym < -512) {
                MycHit.PutlittleStar();
            }
            if (MyChar.gMC.ym < 0) {
                MyChar.gMC.ym = 0;
            }
            hit |= 2;
        }
        return hit;
    }

    public static int JudgeHitMyCharTriangleD(int x, int y) {
        int hit = 0;
        if (MyChar.gMC.x < (x * 16 + 8) * 512 && MyChar.gMC.x > (x * 16 - 8) * 512 && MyChar.gMC.y - MyChar.gMC.hit.top < y * 16 * 512 + (MyChar.gMC.x - x * 16 * 512) / 2 + 2048 && MyChar.gMC.y + MyChar.gMC.hit.bottom > (y * 16 - 8) * 512) {
            MyChar.gMC.y = y * 16 * 512 + (MyChar.gMC.x - x * 16 * 512) / 2 + 2048 + MyChar.gMC.hit.top;
            if ((MyChar.gMC.cond & 2) == 0 && MyChar.gMC.ym < -512) {
                MycHit.PutlittleStar();
            }
            if (MyChar.gMC.ym < 0) {
                MyChar.gMC.ym = 0;
            }
            hit |= 2;
        }
        return hit;
    }

    public static int JudgeHitMyCharTriangleE(int x, int y) {
        int hit = 0;
        hit |= 0x10000;
        if (MyChar.gMC.x < (x * 16 + 8) * 512 && MyChar.gMC.x > (x * 16 - 8) * 512 && MyChar.gMC.y + MyChar.gMC.hit.bottom > y * 16 * 512 + (MyChar.gMC.x - x * 16 * 512) / 2 - 2048 && MyChar.gMC.y - MyChar.gMC.hit.top < (y * 16 + 8) * 512) {
            MyChar.gMC.y = y * 16 * 512 + (MyChar.gMC.x - x * 16 * 512) / 2 - 2048 - MyChar.gMC.hit.bottom;
            if (MyChar.gMC.ym > 1024) {
                Sound.PlaySoundObject(23, 1);
            }
            if (MyChar.gMC.ym > 0) {
                MyChar.gMC.ym = 0;
            }
            hit |= 0x28;
        }
        return hit;
    }

    public static int JudgeHitMyCharTriangleF(int x, int y) {
        int hit = 0;
        hit |= 0x20000;
        if (MyChar.gMC.x < (x * 16 + 8) * 512 && MyChar.gMC.x > (x * 16 - 8) * 512 && MyChar.gMC.y + MyChar.gMC.hit.bottom > y * 16 * 512 + (MyChar.gMC.x - x * 16 * 512) / 2 + 2048 && MyChar.gMC.y - MyChar.gMC.hit.top < (y * 16 + 8) * 512) {
            MyChar.gMC.y = y * 16 * 512 + (MyChar.gMC.x - x * 16 * 512) / 2 + 2048 - MyChar.gMC.hit.bottom;
            if (MyChar.gMC.ym > 1024) {
                Sound.PlaySoundObject(23, 1);
            }
            if (MyChar.gMC.ym > 0) {
                MyChar.gMC.ym = 0;
            }
            hit |= 0x28;
        }
        return hit;
    }

    public static int JudgeHitMyCharTriangleG(int x, int y) {
        int hit = 0;
        hit |= 0x40000;
        if (MyChar.gMC.x < (x * 16 + 8) * 512 && MyChar.gMC.x > (x * 16 - 8) * 512 && MyChar.gMC.y + MyChar.gMC.hit.bottom > y * 16 * 512 - (MyChar.gMC.x - x * 16 * 512) / 2 + 2048 && MyChar.gMC.y - MyChar.gMC.hit.top < (y * 16 + 8) * 512) {
            MyChar.gMC.y = y * 16 * 512 - (MyChar.gMC.x - x * 16 * 512) / 2 + 2048 - MyChar.gMC.hit.bottom;
            if (MyChar.gMC.ym > 1024) {
                Sound.PlaySoundObject(23, 1);
            }
            if (MyChar.gMC.ym > 0) {
                MyChar.gMC.ym = 0;
            }
            hit |= 0x18;
        }
        return hit;
    }

    public static int JudgeHitMyCharTriangleH(int x, int y) {
        int hit = 0;
        hit |= 0x80000;
        if (MyChar.gMC.x < (x * 16 + 8) * 512 && MyChar.gMC.x > (x * 16 - 8) * 512 && MyChar.gMC.y + MyChar.gMC.hit.bottom > y * 16 * 512 - (MyChar.gMC.x - x * 16 * 512) / 2 - 2048 && MyChar.gMC.y - MyChar.gMC.hit.top < (y * 16 + 8) * 512) {
            MyChar.gMC.y = y * 16 * 512 - (MyChar.gMC.x - x * 16 * 512) / 2 - 2048 - MyChar.gMC.hit.bottom;
            if (MyChar.gMC.ym > 1024) {
                Sound.PlaySoundObject(23, 1);
            }
            if (MyChar.gMC.ym > 0) {
                MyChar.gMC.ym = 0;
            }
            hit |= 0x18;
        }
        return hit;
    }

    public static int JudgeHitMyCharWater(int x, int y) {
        int hit = 0;
        if (MyChar.gMC.x - MyChar.gMC.hit.back < (x * 16 + 5) * 512 && MyChar.gMC.x + MyChar.gMC.hit.back > (x * 16 - 5) * 512 && MyChar.gMC.y - MyChar.gMC.hit.top < (y * 16 + 5) * 512 && MyChar.gMC.y + MyChar.gMC.hit.bottom > y * 16 * 512) {
            hit |= 0x100;
        }
        return hit;
    }

    public static int JudgeHitMyCharDamage(int x, int y) {
        int hit = 0;
        if (MyChar.gMC.x - 2048 < (x * 16 + 4) * 512 && MyChar.gMC.x + 2048 > (x * 16 - 4) * 512 && MyChar.gMC.y - 2048 < (y * 16 + 3) * 512 && MyChar.gMC.y + 2048 > (y * 16 - 3) * 512) {
            hit |= 0x400;
        }
        return hit;
    }

    public static int JudgeHitMyCharDamageW(int x, int y) {
        int hit = 0;
        if (MyChar.gMC.x - 2048 < (x * 16 + 4) * 512 && MyChar.gMC.x + 2048 > (x * 16 - 4) * 512 && MyChar.gMC.y - 2048 < (y * 16 + 3) * 512 && MyChar.gMC.y + 2048 > (y * 16 - 3) * 512) {
            hit |= 0xD00;
        }
        return hit;
    }

    public static int JudgeHitMyCharVectLeft(int x, int y) {
        int hit = 0;
        if (MyChar.gMC.x - MyChar.gMC.hit.back < (x * 16 + 6) * 512 && MyChar.gMC.x + MyChar.gMC.hit.back > (x * 16 - 6) * 512 && MyChar.gMC.y - MyChar.gMC.hit.top < (y * 16 + 6) * 512 && MyChar.gMC.y + MyChar.gMC.hit.bottom > (y * 16 - 6) * 512) {
            hit |= 0x1000;
        }
        return hit;
    }

    public static int JudgeHitMyCharVectUp(int x, int y) {
        int hit = 0;
        if (MyChar.gMC.x - MyChar.gMC.hit.back < (x * 16 + 6) * 512 && MyChar.gMC.x + MyChar.gMC.hit.back > (x * 16 - 6) * 512 && MyChar.gMC.y - MyChar.gMC.hit.top < (y * 16 + 6) * 512 && MyChar.gMC.y + MyChar.gMC.hit.bottom > (y * 16 - 6) * 512) {
            hit |= 0x2000;
        }
        return hit;
    }

    public static int JudgeHitMyCharVectRight(int x, int y) {
        int hit = 0;
        if (MyChar.gMC.x - MyChar.gMC.hit.back < (x * 16 + 6) * 512 && MyChar.gMC.x + MyChar.gMC.hit.back > (x * 16 - 6) * 512 && MyChar.gMC.y - MyChar.gMC.hit.top < (y * 16 + 6) * 512 && MyChar.gMC.y + MyChar.gMC.hit.bottom > (y * 16 - 6) * 512) {
            hit |= 0x4000;
        }
        return hit;
    }

    public static int JudgeHitMyCharVectDown(int x, int y) {
        int hit = 0;
        if (MyChar.gMC.x - MyChar.gMC.hit.back < (x * 16 + 6) * 512 && MyChar.gMC.x + MyChar.gMC.hit.back > (x * 16 - 6) * 512 && MyChar.gMC.y - MyChar.gMC.hit.top < (y * 16 + 6) * 512 && MyChar.gMC.y + MyChar.gMC.hit.bottom > (y * 16 - 6) * 512) {
            hit |= 0x8000;
        }
        return hit;
    }

    public static void HitMyCharMap() {
        char[] atrb = new char[4];
        int x = MyChar.gMC.x / 16 / 512;
        int y = MyChar.gMC.y / 16 / 512;
        int[] offx = new int[4];
        int[] offy = new int[4];
        offx[0] = 0;
        offx[1] = 1;
        offx[2] = 0;
        offx[3] = 1;
        offy[0] = 0;
        offy[1] = 0;
        offy[2] = 1;
        offy[3] = 1;
        block32: for (int i = 0; i < 4; ++i) {
            atrb[i] = Map.GetAttribute(x + offx[i], y + offy[i]);
            switch (atrb[i]) {
                case '\u0005': 
                case 'A': 
                case 'C': 
                case 'F': {
                    MyChar.gMC.flag |= MycHit.JudgeHitMyCharBlock(x + offx[i], y + offy[i]);
                    continue block32;
                }
                case 'P': {
                    MyChar.gMC.flag |= MycHit.JudgeHitMyCharTriangleA(x + offx[i], y + offy[i]);
                    continue block32;
                }
                case 'Q': {
                    MyChar.gMC.flag |= MycHit.JudgeHitMyCharTriangleB(x + offx[i], y + offy[i]);
                    continue block32;
                }
                case 'R': {
                    MyChar.gMC.flag |= MycHit.JudgeHitMyCharTriangleC(x + offx[i], y + offy[i]);
                    continue block32;
                }
                case 'S': {
                    MyChar.gMC.flag |= MycHit.JudgeHitMyCharTriangleD(x + offx[i], y + offy[i]);
                    continue block32;
                }
                case 'T': {
                    MyChar.gMC.flag |= MycHit.JudgeHitMyCharTriangleE(x + offx[i], y + offy[i]);
                    continue block32;
                }
                case 'U': {
                    MyChar.gMC.flag |= MycHit.JudgeHitMyCharTriangleF(x + offx[i], y + offy[i]);
                    continue block32;
                }
                case 'V': {
                    MyChar.gMC.flag |= MycHit.JudgeHitMyCharTriangleG(x + offx[i], y + offy[i]);
                    continue block32;
                }
                case 'W': {
                    MyChar.gMC.flag |= MycHit.JudgeHitMyCharTriangleH(x + offx[i], y + offy[i]);
                    continue block32;
                }
                case 'B': {
                    MyChar.gMC.flag |= MycHit.JudgeHitMyCharDamage(x + offx[i], y + offy[i]);
                    continue block32;
                }
                case 'b': {
                    MyChar.gMC.flag |= MycHit.JudgeHitMyCharDamageW(x + offx[i], y + offy[i]);
                    continue block32;
                }
                case '\u0080': {
                    MyChar.gMC.flag |= MycHit.JudgeHitMyCharVectLeft(x + offx[i], y + offy[i]);
                    continue block32;
                }
                case '\u0081': {
                    MyChar.gMC.flag |= MycHit.JudgeHitMyCharVectUp(x + offx[i], y + offy[i]);
                    continue block32;
                }
                case '\u0082': {
                    MyChar.gMC.flag |= MycHit.JudgeHitMyCharVectRight(x + offx[i], y + offy[i]);
                    continue block32;
                }
                case '\u0083': {
                    MyChar.gMC.flag |= MycHit.JudgeHitMyCharVectDown(x + offx[i], y + offy[i]);
                    continue block32;
                }
                case '\u0002': {
                    MyChar.gMC.flag |= MycHit.JudgeHitMyCharWater(x + offx[i], y + offy[i]);
                    continue block32;
                }
                case '`': {
                    MyChar.gMC.flag |= MycHit.JudgeHitMyCharWater(x + offx[i], y + offy[i]);
                    continue block32;
                }
                case 'a': {
                    MyChar.gMC.flag |= MycHit.JudgeHitMyCharBlock(x + offx[i], y + offy[i]);
                    MyChar.gMC.flag |= MycHit.JudgeHitMyCharWater(x + offx[i], y + offy[i]);
                    continue block32;
                }
                case 'p': {
                    MyChar.gMC.flag |= MycHit.JudgeHitMyCharTriangleA(x + offx[i], y + offy[i]);
                    MyChar.gMC.flag |= MycHit.JudgeHitMyCharWater(x + offx[i], y + offy[i]);
                    continue block32;
                }
                case 'q': {
                    MyChar.gMC.flag |= MycHit.JudgeHitMyCharTriangleB(x + offx[i], y + offy[i]);
                    MyChar.gMC.flag |= MycHit.JudgeHitMyCharWater(x + offx[i], y + offy[i]);
                    continue block32;
                }
                case 'r': {
                    MyChar.gMC.flag |= MycHit.JudgeHitMyCharTriangleC(x + offx[i], y + offy[i]);
                    MyChar.gMC.flag |= MycHit.JudgeHitMyCharWater(x + offx[i], y + offy[i]);
                    continue block32;
                }
                case 's': {
                    MyChar.gMC.flag |= MycHit.JudgeHitMyCharTriangleD(x + offx[i], y + offy[i]);
                    MyChar.gMC.flag |= MycHit.JudgeHitMyCharWater(x + offx[i], y + offy[i]);
                    continue block32;
                }
                case 't': {
                    MyChar.gMC.flag |= MycHit.JudgeHitMyCharTriangleE(x + offx[i], y + offy[i]);
                    MyChar.gMC.flag |= MycHit.JudgeHitMyCharWater(x + offx[i], y + offy[i]);
                    continue block32;
                }
                case 'u': {
                    MyChar.gMC.flag |= MycHit.JudgeHitMyCharTriangleF(x + offx[i], y + offy[i]);
                    MyChar.gMC.flag |= MycHit.JudgeHitMyCharWater(x + offx[i], y + offy[i]);
                    continue block32;
                }
                case 'v': {
                    MyChar.gMC.flag |= MycHit.JudgeHitMyCharTriangleG(x + offx[i], y + offy[i]);
                    MyChar.gMC.flag |= MycHit.JudgeHitMyCharWater(x + offx[i], y + offy[i]);
                    continue block32;
                }
                case 'w': {
                    MyChar.gMC.flag |= MycHit.JudgeHitMyCharTriangleH(x + offx[i], y + offy[i]);
                    MyChar.gMC.flag |= MycHit.JudgeHitMyCharWater(x + offx[i], y + offy[i]);
                    continue block32;
                }
                case '\u00a0': {
                    MyChar.gMC.flag |= MycHit.JudgeHitMyCharVectLeft(x + offx[i], y + offy[i]);
                    MyChar.gMC.flag |= MycHit.JudgeHitMyCharWater(x + offx[i], y + offy[i]);
                    continue block32;
                }
                case '\u00a1': {
                    MyChar.gMC.flag |= MycHit.JudgeHitMyCharVectUp(x + offx[i], y + offy[i]);
                    MyChar.gMC.flag |= MycHit.JudgeHitMyCharWater(x + offx[i], y + offy[i]);
                    continue block32;
                }
                case '\u00a2': {
                    MyChar.gMC.flag |= MycHit.JudgeHitMyCharVectRight(x + offx[i], y + offy[i]);
                    MyChar.gMC.flag |= MycHit.JudgeHitMyCharWater(x + offx[i], y + offy[i]);
                    continue block32;
                }
                case '\u00a3': {
                    MyChar.gMC.flag |= MycHit.JudgeHitMyCharVectDown(x + offx[i], y + offy[i]);
                    MyChar.gMC.flag |= MycHit.JudgeHitMyCharWater(x + offx[i], y + offy[i]);
                }
            }
        }
        if (MyChar.gMC.y > Back.gWaterY + 2048) {
            MyChar.gMC.flag |= 0x100;
        }
    }

    public static int JudgeHitMyCharNPC(NpChar.NPCHAR npc) {
        int hit = 0;
        if (MyChar.gMC.y - MyChar.gMC.hit.top < npc.y + npc.hit.bottom - 1536 && MyChar.gMC.y + MyChar.gMC.hit.bottom > npc.y - npc.hit.top + 1536 && MyChar.gMC.x - MyChar.gMC.hit.back < npc.x + npc.hit.back && MyChar.gMC.x - MyChar.gMC.hit.back > npc.x) {
            if (MyChar.gMC.xm < 512) {
                MyChar.gMC.xm += 512;
            }
            hit |= 1;
        }
        if (MyChar.gMC.y - MyChar.gMC.hit.top < npc.y + npc.hit.bottom - 1536 && MyChar.gMC.y + MyChar.gMC.hit.bottom > npc.y - npc.hit.top + 1536 && MyChar.gMC.x + MyChar.gMC.hit.back - 512 > npc.x - npc.hit.back && MyChar.gMC.x + MyChar.gMC.hit.back - 512 < npc.x) {
            if (MyChar.gMC.xm > -512) {
                MyChar.gMC.xm -= 512;
            }
            hit |= 4;
        }
        if (MyChar.gMC.x - MyChar.gMC.hit.back < npc.x + npc.hit.back - 1536 && MyChar.gMC.x + MyChar.gMC.hit.back > npc.x - npc.hit.back + 1536 && MyChar.gMC.y - MyChar.gMC.hit.top < npc.y + npc.hit.bottom && MyChar.gMC.y - MyChar.gMC.hit.top > npc.y) {
            if (MyChar.gMC.ym < 0) {
                MyChar.gMC.ym = 0;
            }
            hit |= 2;
        }
        if (MyChar.gMC.x - MyChar.gMC.hit.back < npc.x + npc.hit.back - 1536 && MyChar.gMC.x + MyChar.gMC.hit.back > npc.x - npc.hit.back + 1536 && MyChar.gMC.y + MyChar.gMC.hit.bottom > npc.y - npc.hit.top && MyChar.gMC.hit.bottom + MyChar.gMC.y < npc.y + 1536) {
            if ((npc.bits & 0x10) != 0) {
                MyChar.gMC.ym = npc.ym - 512;
                hit |= 8;
            } else if ((MyChar.gMC.flag & 8) == 0 && MyChar.gMC.ym > npc.ym) {
                MyChar.gMC.y = npc.y - npc.hit.top - MyChar.gMC.hit.bottom + 512;
                MyChar.gMC.ym = npc.ym;
                MyChar.gMC.x += npc.xm;
                hit |= 8;
            }
        }
        return hit;
    }

    public static int JudgeHitMyCharNPC3(NpChar.NPCHAR npc) {
        if (npc.direct == 0 ? MyChar.gMC.x + 1024 > npc.x - npc.hit.front && MyChar.gMC.x - 1024 < npc.x + npc.hit.back && MyChar.gMC.y + 1024 > npc.y - npc.hit.top && MyChar.gMC.y - 1024 < npc.y + npc.hit.bottom : MyChar.gMC.x + 1024 > npc.x - npc.hit.back && MyChar.gMC.x - 1024 < npc.x + npc.hit.front && MyChar.gMC.y + 1024 > npc.y - npc.hit.top && MyChar.gMC.y - 1024 < npc.y + npc.hit.bottom) {
            return 1;
        }
        return 0;
    }

    public static int JudgeHitMyCharNPC4(NpChar.NPCHAR npc) {
        int hit = 0;
        float fx1 = npc.x > MyChar.gMC.x ? (float)(npc.x - MyChar.gMC.x) : (float)(MyChar.gMC.x - npc.x);
        float fy1 = npc.y > MyChar.gMC.y ? (float)(npc.y - MyChar.gMC.y) : (float)(MyChar.gMC.y - npc.y);
        float fx2 = npc.hit.back;
        float fy2 = npc.hit.top;
        if (fx1 == 0.0f) {
            fx1 = 1.0f;
        }
        if (fx2 == 0.0f) {
            fx2 = 1.0f;
        }
        if (fy1 / fx1 > fy2 / fx2) {
            if (MyChar.gMC.x - MyChar.gMC.hit.back < npc.x + npc.hit.back && MyChar.gMC.x + MyChar.gMC.hit.back > npc.x - npc.hit.back) {
                if (MyChar.gMC.y - MyChar.gMC.hit.top < npc.y + npc.hit.bottom && MyChar.gMC.y - MyChar.gMC.hit.top > npc.y) {
                    if (MyChar.gMC.ym < npc.ym) {
                        MyChar.gMC.y = npc.y + npc.hit.bottom + MyChar.gMC.hit.top + 512;
                        MyChar.gMC.ym = npc.ym;
                    } else if (MyChar.gMC.ym < 0) {
                        MyChar.gMC.ym = 0;
                    }
                    hit |= 2;
                }
                if (MyChar.gMC.y + MyChar.gMC.hit.bottom > npc.y - npc.hit.top && MyChar.gMC.hit.bottom + MyChar.gMC.y < npc.y + 1536) {
                    if (MyChar.gMC.ym - npc.ym > 1024) {
                        Sound.PlaySoundObject(23, 1);
                    }
                    if (MyChar.gMC.unit == 1) {
                        MyChar.gMC.y = npc.y - npc.hit.top - MyChar.gMC.hit.bottom + 512;
                        hit |= 8;
                    } else if ((npc.bits & 0x10) != 0) {
                        MyChar.gMC.ym = npc.ym - 512;
                        hit |= 8;
                    } else if ((MyChar.gMC.flag & 8) == 0 && MyChar.gMC.ym > npc.ym) {
                        MyChar.gMC.y = npc.y - npc.hit.top - MyChar.gMC.hit.bottom + 512;
                        MyChar.gMC.ym = npc.ym;
                        MyChar.gMC.x += npc.xm;
                        hit |= 8;
                    }
                }
            }
        } else if (MyChar.gMC.y - MyChar.gMC.hit.top < npc.y + npc.hit.bottom && MyChar.gMC.y + MyChar.gMC.hit.bottom > npc.y - npc.hit.top) {
            if (MyChar.gMC.x - MyChar.gMC.hit.back < npc.x + npc.hit.back && MyChar.gMC.x - MyChar.gMC.hit.back > npc.x) {
                if (MyChar.gMC.xm < npc.xm) {
                    MyChar.gMC.xm = npc.xm;
                }
                MyChar.gMC.x = npc.x + npc.hit.back + MyChar.gMC.hit.back;
                hit |= 1;
            }
            if (MyChar.gMC.x + MyChar.gMC.hit.back > npc.x - npc.hit.back && MyChar.gMC.hit.back + MyChar.gMC.x < npc.x) {
                if (MyChar.gMC.xm > npc.xm) {
                    MyChar.gMC.xm = npc.xm;
                }
                MyChar.gMC.x = npc.x - npc.hit.back - MyChar.gMC.hit.back;
                hit |= 4;
            }
        }
        return hit;
    }

    public static void HitMyCharNpChar() {
        int hit = 0;
        if ((MyChar.gMC.cond & 0x80) == 0 || (MyChar.gMC.cond & 2) != 0) {
            return;
        }
        for (int i = 0; i < NpChar.gNPC.length; ++i) {
            if ((NpChar.gNPC[i].cond & 0x80) == 0) continue;
            hit = 0;
            if ((NpChar.gNPC[i].bits & '\u0001') != 0) {
                hit = MycHit.JudgeHitMyCharNPC(NpChar.gNPC[i]);
                MyChar.gMC.flag |= hit;
            } else if ((NpChar.gNPC[i].bits & 0x40) != 0) {
                hit = MycHit.JudgeHitMyCharNPC4(NpChar.gNPC[i]);
                MyChar.gMC.flag |= hit;
            } else {
                hit = MycHit.JudgeHitMyCharNPC3(NpChar.gNPC[i]);
            }
            if (hit != 0 && NpChar.gNPC[i].code_char == 1) {
                Sound.PlaySoundObject(14, 1);
                MycParam.AddExpMyChar(NpChar.gNPC[i].exp);
                NpChar.gNPC[i].cond = 0;
            }
            if (hit != 0 && NpChar.gNPC[i].code_char == 86) {
                Sound.PlaySoundObject(42, 1);
                MycParam.AddBulletMyChar(NpChar.gNPC[i].code_event, NpChar.gNPC[i].exp);
                NpChar.gNPC[i].cond = 0;
            }
            if (hit != 0 && NpChar.gNPC[i].code_char == 87) {
                Sound.PlaySoundObject(20, 1);
                MycParam.AddLifeMyChar(NpChar.gNPC[i].exp);
                NpChar.gNPC[i].cond = 0;
            }
            if ((Game.g_GameFlags & 4) == 0 && hit != 0 && (NpChar.gNPC[i].bits & 0x100) != 0) {
                TextScr.StartTextScript(NpChar.gNPC[i].code_event);
            }
            if ((Game.g_GameFlags & 2) != 0 && (NpChar.gNPC[i].bits & 0x2000) == 0) {
                if ((NpChar.gNPC[i].bits & 0x80) != 0) {
                    if ((hit & 4) != 0 && NpChar.gNPC[i].xm < 0) {
                        MycParam.DamageMyChar(NpChar.gNPC[i].damage);
                    }
                    if ((hit & 1) != 0 && NpChar.gNPC[i].xm > 0) {
                        MycParam.DamageMyChar(NpChar.gNPC[i].damage);
                    }
                    if ((hit & 8) != 0 && NpChar.gNPC[i].ym < 0) {
                        MycParam.DamageMyChar(NpChar.gNPC[i].damage);
                    }
                    if ((hit & 2) != 0 && NpChar.gNPC[i].ym > 0) {
                        MycParam.DamageMyChar(NpChar.gNPC[i].damage);
                    }
                } else if (hit != 0 && NpChar.gNPC[i].damage != 0 && (Game.g_GameFlags & 4) == 0) {
                    MycParam.DamageMyChar(NpChar.gNPC[i].damage);
                }
            }
            if ((Game.g_GameFlags & 4) != 0 || hit == 0 || (MyChar.gMC.cond & '\u0001') == 0 || (NpChar.gNPC[i].bits & 0x2000) == 0) continue;
            TextScr.StartTextScript(NpChar.gNPC[i].code_event);
            MyChar.gMC.xm = 0;
            MyChar.gMC.ques = 0;
        }
        if (MyChar.gMC.ques != 0) {
            Caret.SetCaret(MyChar.gMC.x, MyChar.gMC.y, 9, 0);
        }
    }

    public static void HitMyCharBoss() {
        int hit = 0;
        if ((MyChar.gMC.cond & 0x80) == 0 || (MyChar.gMC.cond & 2) != 0) {
            return;
        }
        for (int b = 0; b < Boss.gBoss.length; ++b) {
            if ((Boss.gBoss[b].cond & 0x80) == 0) continue;
            hit = 0;
            if ((Boss.gBoss[b].bits & '\u0001') != 0) {
                hit = MycHit.JudgeHitMyCharNPC(Boss.gBoss[b]);
                MyChar.gMC.flag |= hit;
            } else if ((Boss.gBoss[b].bits & 0x40) != 0) {
                hit = MycHit.JudgeHitMyCharNPC4(Boss.gBoss[b]);
                MyChar.gMC.flag |= hit;
            } else {
                hit = MycHit.JudgeHitMyCharNPC3(Boss.gBoss[b]);
            }
            if ((Game.g_GameFlags & 4) == 0 && hit != 0 && (Boss.gBoss[b].bits & 0x100) != 0) {
                TextScr.StartTextScript(Boss.gBoss[b].code_event);
                MyChar.gMC.ques = 0;
            }
            if ((Boss.gBoss[b].bits & 0x80) != 0) {
                if ((hit & 4) != 0 && Boss.gBoss[b].xm < 0) {
                    MycParam.DamageMyChar(Boss.gBoss[b].damage);
                }
                if ((hit & 1) != 0 && Boss.gBoss[b].xm > 0) {
                    MycParam.DamageMyChar(Boss.gBoss[b].damage);
                }
            } else if (hit != 0 && Boss.gBoss[b].damage != 0 && (Game.g_GameFlags & 4) == 0) {
                MycParam.DamageMyChar(Boss.gBoss[b].damage);
            }
            if ((Game.g_GameFlags & 4) != 0 || hit == 0 || (MyChar.gMC.cond & '\u0001') == 0 || (Boss.gBoss[b].bits & 0x2000) == 0) continue;
            TextScr.StartTextScript(Boss.gBoss[b].code_event);
            MyChar.gMC.xm = 0;
            MyChar.gMC.ques = 0;
        }
        if (MyChar.gMC.ques != 0) {
            Caret.SetCaret(MyChar.gMC.x, MyChar.gMC.y, 9, 0);
        }
    }
}
