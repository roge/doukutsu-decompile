/*
 * Decompiled with CFR 0.152.
 */
package jp.studiopixel.doukutsu;

import jp.studiopixel.doukutsu.ArmsItem;
import jp.studiopixel.doukutsu.Caret;
import jp.studiopixel.doukutsu.Draw;
import jp.studiopixel.doukutsu.Flags;
import jp.studiopixel.doukutsu.Game;
import jp.studiopixel.doukutsu.KeyControl;
import jp.studiopixel.doukutsu.MycParam;
import jp.studiopixel.doukutsu.NpChar;
import jp.studiopixel.doukutsu.RECT;
import jp.studiopixel.doukutsu.Sound;
import jp.studiopixel.doukutsu.Star;
import jp.studiopixel.doukutsu.TextScr;
import jp.studiopixel.doukutsu.ValueView;

public class MyChar {
    public static final int EQUIP_BOOSTER_0_8 = 1;
    public static final int EQUIP_MAP = 2;
    public static final int EQUIP_ARMS_BARRIER = 4;
    public static final int EQUIP_TURBOCHARGE = 8;
    public static final int EQUIP_AIR_TANK = 16;
    public static final int EQUIP_BOOSTER_2_0 = 32;
    public static final int EQUIP_MIMIGA_MASK = 64;
    public static final int EQUIP_WHIMSICAL_STAR = 128;
    public static final int EQUIP_NIKUMARU_COUNTER = 256;
    public static MYCHAR gMC = new MYCHAR();
    private static final RECT[] rcLeft = new RECT[]{new RECT(0, 0, 16, 16), new RECT(16, 0, 32, 16), new RECT(0, 0, 16, 16), new RECT(32, 0, 48, 16), new RECT(0, 0, 16, 16), new RECT(48, 0, 64, 16), new RECT(64, 0, 80, 16), new RECT(48, 0, 64, 16), new RECT(80, 0, 96, 16), new RECT(48, 0, 64, 16), new RECT(96, 0, 112, 16), new RECT(112, 0, 128, 16)};
    private static final RECT[] rcRight = new RECT[]{new RECT(0, 16, 16, 32), new RECT(16, 16, 32, 32), new RECT(0, 16, 16, 32), new RECT(32, 16, 48, 32), new RECT(0, 16, 16, 32), new RECT(48, 16, 64, 32), new RECT(64, 16, 80, 32), new RECT(48, 16, 64, 32), new RECT(80, 16, 96, 32), new RECT(48, 16, 64, 32), new RECT(96, 16, 112, 32), new RECT(112, 16, 128, 32)};
    static int noise_no = 0;
    static int noise_freq = 0;

    public static void AnimationMyChar(boolean bKey) {
        if ((MyChar.gMC.cond & 2) != 0) {
            return;
        }
        if ((MyChar.gMC.flag & 8) != 0) {
            if ((MyChar.gMC.cond & '\u0001') != 0) {
                MyChar.gMC.ani_no = 11;
            } else if ((KeyControl.gKey & KeyControl.gKeyUp) != 0 && (KeyControl.gKey & (KeyControl.gKeyLeft | KeyControl.gKeyRight)) != 0 && bKey) {
                MyChar.gMC.cond = (char)(MyChar.gMC.cond | 4);
                if (++MyChar.gMC.ani_wait > 4) {
                    MyChar.gMC.ani_wait = 0;
                    if (++MyChar.gMC.ani_no == 7 || MyChar.gMC.ani_no == 9) {
                        Sound.PlaySoundObject(24, 1);
                    }
                }
                if (MyChar.gMC.ani_no > 9 || MyChar.gMC.ani_no < 6) {
                    MyChar.gMC.ani_no = 6;
                }
            } else if ((KeyControl.gKey & (KeyControl.gKeyLeft | KeyControl.gKeyRight)) != 0 && bKey) {
                MyChar.gMC.cond = (char)(MyChar.gMC.cond | 4);
                if (++MyChar.gMC.ani_wait > 4) {
                    MyChar.gMC.ani_wait = 0;
                    if (++MyChar.gMC.ani_no == 2 || MyChar.gMC.ani_no == 4) {
                        Sound.PlaySoundObject(24, 1);
                    }
                }
                if (MyChar.gMC.ani_no > 4 || MyChar.gMC.ani_no < 1) {
                    MyChar.gMC.ani_no = 1;
                }
            } else if ((KeyControl.gKey & KeyControl.gKeyUp) != 0 && bKey) {
                if ((MyChar.gMC.cond & 4) != 0) {
                    Sound.PlaySoundObject(24, 1);
                }
                MyChar.gMC.cond = (char)(MyChar.gMC.cond & 0xFFFFFFFB);
                MyChar.gMC.ani_no = 5;
            } else {
                if ((MyChar.gMC.cond & 4) != 0) {
                    Sound.PlaySoundObject(24, 1);
                }
                MyChar.gMC.cond = (char)(MyChar.gMC.cond & 0xFFFFFFFB);
                MyChar.gMC.ani_no = 0;
            }
        } else {
            MyChar.gMC.ani_no = MyChar.gMC.up ? 6 : (MyChar.gMC.down ? 10 : (MyChar.gMC.ym > 0 ? 1 : 3));
        }
        if (MyChar.gMC.direct == 0) {
            MyChar.gMC.rect.copyFrom(rcLeft[MyChar.gMC.ani_no]);
        } else {
            MyChar.gMC.rect.copyFrom(rcRight[MyChar.gMC.ani_no]);
        }
    }

    public static void ShowMyChar(boolean bShow) {
        MyChar.gMC.cond = bShow ? (char)(MyChar.gMC.cond & 0xFFFFFFFD) : (char)(MyChar.gMC.cond | 2);
    }

    public static void PutMyChar(int fx, int fy) {
        int arms_offset_y;
        if ((MyChar.gMC.cond & 0x80) == 0 || (MyChar.gMC.cond & 2) != 0) {
            return;
        }
        MyChar.gMC.rect_arms.left = ArmsItem.gArmsData[ArmsItem.gSelectedArms].code % 13 * 24;
        MyChar.gMC.rect_arms.right = MyChar.gMC.rect_arms.left + 24;
        MyChar.gMC.rect_arms.top = ArmsItem.gArmsData[ArmsItem.gSelectedArms].code / 13 * 96;
        MyChar.gMC.rect_arms.bottom = MyChar.gMC.rect_arms.top + 16;
        if (MyChar.gMC.direct == 2) {
            MyChar.gMC.rect_arms.top += 16;
            MyChar.gMC.rect_arms.bottom += 16;
        }
        if (MyChar.gMC.up) {
            arms_offset_y = -4;
            MyChar.gMC.rect_arms.top += 32;
            MyChar.gMC.rect_arms.bottom += 32;
        } else if (MyChar.gMC.down) {
            arms_offset_y = 4;
            MyChar.gMC.rect_arms.top += 64;
            MyChar.gMC.rect_arms.bottom += 64;
        } else {
            arms_offset_y = 0;
        }
        if (MyChar.gMC.ani_no == 1 || MyChar.gMC.ani_no == 3 || MyChar.gMC.ani_no == 6 || MyChar.gMC.ani_no == 8) {
            ++MyChar.gMC.rect_arms.top;
        }
        if (MyChar.gMC.direct == 0) {
            Draw.PutBitmap3(Draw.grcGame, (MyChar.gMC.x - MyChar.gMC.view.front) / 512 - fx / 512 - 8, (MyChar.gMC.y - MyChar.gMC.view.top) / 512 - fy / 512 + arms_offset_y, MyChar.gMC.rect_arms, 11);
        } else {
            Draw.PutBitmap3(Draw.grcGame, (MyChar.gMC.x - MyChar.gMC.view.front) / 512 - fx / 512, (MyChar.gMC.y - MyChar.gMC.view.top) / 512 - fy / 512 + arms_offset_y, MyChar.gMC.rect_arms, 11);
        }
        if (MyChar.gMC.shock / 2 % 2 != 0) {
            return;
        }
        RECT rect = MyChar.gMC.rect.clone();
        if ((MyChar.gMC.equip & 0x40) != 0) {
            rect.top += 32;
            rect.bottom += 32;
        }
        Draw.PutBitmap3(Draw.grcGame, (MyChar.gMC.x - MyChar.gMC.view.front) / 512 - fx / 512, (MyChar.gMC.y - MyChar.gMC.view.top) / 512 - fy / 512, rect, 16);
        RECT[] rcBubble = new RECT[]{new RECT(56, 96, 80, 120), new RECT(80, 96, 104, 120)};
        MyChar.gMC.bubble = (char)(MyChar.gMC.bubble + '\u0001');
        if ((MyChar.gMC.equip & 0x10) != 0 && (MyChar.gMC.flag & 0x100) != 0) {
            Draw.PutBitmap3(Draw.grcGame, MyChar.gMC.x / 512 - 12 - fx / 512, MyChar.gMC.y / 512 - 12 - fy / 512, rcBubble[MyChar.gMC.bubble / 2 % 2], 19);
        } else if (MyChar.gMC.unit == 1) {
            Draw.PutBitmap3(Draw.grcGame, MyChar.gMC.x / 512 - 12 - fx / 512, MyChar.gMC.y / 512 - 12 - fy / 512, rcBubble[MyChar.gMC.bubble / 2 % 2], 19);
        }
    }

    public static void ActMyChar_Normal(boolean bKey) {
        int resist;
        int dash2;
        int dash1;
        int jump;
        int gravity2;
        int gravity1;
        int max_move;
        int max_dash;
        if ((MyChar.gMC.cond & 2) != 0) {
            return;
        }
        if ((MyChar.gMC.flag & 0x100) != 0) {
            max_dash = 406;
            max_move = 767;
            gravity1 = 40;
            gravity2 = 16;
            jump = 640;
            dash1 = 42;
            dash2 = 16;
            resist = 25;
        } else {
            max_dash = 812;
            max_move = 1535;
            gravity1 = 80;
            gravity2 = 32;
            jump = 1280;
            dash1 = 85;
            dash2 = 32;
            resist = 51;
        }
        MyChar.gMC.ques = 0;
        if (!bKey) {
            MyChar.gMC.boost_sw = 0;
        }
        if ((MyChar.gMC.flag & 8) != 0 || (MyChar.gMC.flag & 0x10) != 0 || (MyChar.gMC.flag & 0x20) != 0) {
            MyChar.gMC.boost_sw = 0;
            MyChar.gMC.boost_cnt = (MyChar.gMC.equip & 1) != 0 ? 50 : ((MyChar.gMC.equip & 0x20) != 0 ? 50 : 0);
            if (bKey) {
                if (KeyControl.gKeyTrg == KeyControl.gKeyDown && KeyControl.gKey == KeyControl.gKeyDown && (MyChar.gMC.cond & '\u0001') == 0 && (Game.g_GameFlags & 4) == 0) {
                    MyChar.gMC.cond = (char)(MyChar.gMC.cond | '\u0001');
                    MyChar.gMC.ques = 1;
                } else if (KeyControl.gKey != KeyControl.gKeyDown) {
                    if ((KeyControl.gKey & KeyControl.gKeyLeft) != 0 && MyChar.gMC.xm > -max_dash) {
                        MyChar.gMC.xm -= dash1;
                    }
                    if ((KeyControl.gKey & KeyControl.gKeyRight) != 0 && MyChar.gMC.xm < max_dash) {
                        MyChar.gMC.xm += dash1;
                    }
                    if ((KeyControl.gKey & KeyControl.gKeyLeft) != 0) {
                        MyChar.gMC.direct = 0;
                    }
                    if ((KeyControl.gKey & KeyControl.gKeyRight) != 0) {
                        MyChar.gMC.direct = 2;
                    }
                }
            }
            if ((MyChar.gMC.cond & 0x20) == 0) {
                if (MyChar.gMC.xm < 0) {
                    MyChar.gMC.xm = MyChar.gMC.xm > -resist ? 0 : (MyChar.gMC.xm += resist);
                }
                if (MyChar.gMC.xm > 0) {
                    MyChar.gMC.xm = MyChar.gMC.xm < resist ? 0 : (MyChar.gMC.xm -= resist);
                }
            }
        } else {
            if (bKey) {
                if ((MyChar.gMC.equip & 0x21) != 0 && (KeyControl.gKeyTrg & KeyControl.gKeyJump) != 0 && MyChar.gMC.boost_cnt != 0) {
                    if ((MyChar.gMC.equip & 1) != 0) {
                        MyChar.gMC.boost_sw = 1;
                        if (MyChar.gMC.ym > 256) {
                            MyChar.gMC.ym /= 2;
                        }
                    }
                    if ((MyChar.gMC.equip & 0x20) != 0) {
                        if ((KeyControl.gKey & KeyControl.gKeyUp) != 0) {
                            MyChar.gMC.boost_sw = (byte)2;
                            MyChar.gMC.xm = 0;
                            MyChar.gMC.ym = -1535;
                        } else if ((KeyControl.gKey & KeyControl.gKeyLeft) != 0) {
                            MyChar.gMC.boost_sw = 1;
                            MyChar.gMC.ym = 0;
                            MyChar.gMC.xm = -1535;
                        } else if ((KeyControl.gKey & KeyControl.gKeyRight) != 0) {
                            MyChar.gMC.boost_sw = 1;
                            MyChar.gMC.ym = 0;
                            MyChar.gMC.xm = 1535;
                        } else if ((KeyControl.gKey & KeyControl.gKeyDown) != 0) {
                            MyChar.gMC.boost_sw = (byte)3;
                            MyChar.gMC.xm = 0;
                            MyChar.gMC.ym = 1535;
                        } else {
                            MyChar.gMC.boost_sw = (byte)2;
                            MyChar.gMC.xm = 0;
                            MyChar.gMC.ym = -1535;
                        }
                    }
                }
                if ((KeyControl.gKey & KeyControl.gKeyLeft) != 0 && MyChar.gMC.xm > -max_dash) {
                    MyChar.gMC.xm -= dash2;
                }
                if ((KeyControl.gKey & KeyControl.gKeyRight) != 0 && MyChar.gMC.xm < max_dash) {
                    MyChar.gMC.xm += dash2;
                }
                if ((KeyControl.gKey & KeyControl.gKeyLeft) != 0) {
                    MyChar.gMC.direct = 0;
                }
                if ((KeyControl.gKey & KeyControl.gKeyRight) != 0) {
                    MyChar.gMC.direct = 2;
                }
            }
            if ((MyChar.gMC.equip & 0x20) != 0 && MyChar.gMC.boost_sw != 0 && ((KeyControl.gKey & KeyControl.gKeyJump) == 0 || MyChar.gMC.boost_cnt == 0)) {
                if (MyChar.gMC.boost_sw == 1) {
                    MyChar.gMC.xm /= 2;
                } else if (MyChar.gMC.boost_sw == 2) {
                    MyChar.gMC.ym /= 2;
                }
            }
            if (MyChar.gMC.boost_cnt == 0 || (KeyControl.gKey & KeyControl.gKeyJump) == 0) {
                MyChar.gMC.boost_sw = 0;
            }
        }
        if (bKey) {
            MyChar.gMC.up = (KeyControl.gKey & KeyControl.gKeyUp) != 0;
            boolean bl = MyChar.gMC.down = (KeyControl.gKey & KeyControl.gKeyDown) != 0 && (MyChar.gMC.flag & 8) == 0;
            if ((KeyControl.gKeyTrg & KeyControl.gKeyJump) != 0 && ((MyChar.gMC.flag & 8) != 0 || (MyChar.gMC.flag & 0x10) != 0 || (MyChar.gMC.flag & 0x20) != 0) && (MyChar.gMC.flag & 0x2000) == 0) {
                MyChar.gMC.ym = -jump;
                Sound.PlaySoundObject(15, 1);
            }
        }
        if (bKey && (KeyControl.gKey & (KeyControl.gKeyLeft | KeyControl.gKeyRight | KeyControl.gKeyUp | KeyControl.gKeyJump | KeyControl.gKeyShot)) != 0) {
            MyChar.gMC.cond = (char)(MyChar.gMC.cond & 0xFFFFFFFE);
        }
        if (MyChar.gMC.boost_sw != 0 && MyChar.gMC.boost_cnt != 0) {
            --MyChar.gMC.boost_cnt;
        }
        if ((MyChar.gMC.flag & 0x1000) != 0) {
            MyChar.gMC.xm -= 136;
        }
        if ((MyChar.gMC.flag & 0x2000) != 0) {
            MyChar.gMC.ym -= 128;
        }
        if ((MyChar.gMC.flag & 0x4000) != 0) {
            MyChar.gMC.xm += 136;
        }
        if ((MyChar.gMC.flag & 0x8000) != 0) {
            MyChar.gMC.ym += 85;
        }
        if ((MyChar.gMC.equip & 0x20) != 0 && MyChar.gMC.boost_sw != 0) {
            if (MyChar.gMC.boost_sw == 1) {
                if ((MyChar.gMC.flag & 5) != 0) {
                    MyChar.gMC.ym = -256;
                }
                if (MyChar.gMC.direct == 0) {
                    MyChar.gMC.xm -= 32;
                }
                if (MyChar.gMC.direct == 2) {
                    MyChar.gMC.xm += 32;
                }
                if ((KeyControl.gKeyTrg & KeyControl.gKeyJump) != 0 || MyChar.gMC.boost_cnt % 3 == 1) {
                    if (MyChar.gMC.direct == 0) {
                        Caret.SetCaret(MyChar.gMC.x + 1024, MyChar.gMC.y + 1024, 7, 2);
                    }
                    if (MyChar.gMC.direct == 2) {
                        Caret.SetCaret(MyChar.gMC.x - 1024, MyChar.gMC.y + 1024, 7, 0);
                    }
                    Sound.PlaySoundObject(113, 1);
                }
            } else if (MyChar.gMC.boost_sw == 2) {
                MyChar.gMC.ym -= 32;
                if ((KeyControl.gKeyTrg & KeyControl.gKeyJump) != 0 || MyChar.gMC.boost_cnt % 3 == 1) {
                    Caret.SetCaret(MyChar.gMC.x, MyChar.gMC.y + 3072, 7, 3);
                    Sound.PlaySoundObject(113, 1);
                }
            } else if (MyChar.gMC.boost_sw == 3 && ((KeyControl.gKeyTrg & KeyControl.gKeyJump) != 0 || MyChar.gMC.boost_cnt % 3 == 1)) {
                Caret.SetCaret(MyChar.gMC.x, MyChar.gMC.y - 3072, 7, 1);
                Sound.PlaySoundObject(113, 1);
            }
        } else if ((MyChar.gMC.flag & 0x2000) != 0) {
            MyChar.gMC.ym += gravity1;
        } else if ((MyChar.gMC.equip & 1) != 0 && MyChar.gMC.boost_sw != 0 && MyChar.gMC.ym > -1024) {
            MyChar.gMC.ym -= 32;
            if (MyChar.gMC.boost_cnt % 3 == 0) {
                Caret.SetCaret(MyChar.gMC.x, MyChar.gMC.y + MyChar.gMC.hit.bottom / 2, 7, 3);
                Sound.PlaySoundObject(113, 1);
            }
            if ((MyChar.gMC.flag & 2) != 0) {
                MyChar.gMC.ym = 512;
            }
        } else {
            MyChar.gMC.ym = MyChar.gMC.ym < 0 && bKey && (KeyControl.gKey & KeyControl.gKeyJump) != 0 ? (MyChar.gMC.ym += gravity2) : (MyChar.gMC.ym += gravity1);
        }
        if (!bKey || (KeyControl.gKeyTrg & KeyControl.gKeyJump) == 0) {
            if ((MyChar.gMC.flag & 0x10) != 0 && MyChar.gMC.xm < 0) {
                MyChar.gMC.ym = -MyChar.gMC.xm;
            }
            if ((MyChar.gMC.flag & 0x20) != 0 && MyChar.gMC.xm > 0) {
                MyChar.gMC.ym = MyChar.gMC.xm;
            }
            if ((MyChar.gMC.flag & 8) != 0 && (MyChar.gMC.flag & 0x80000) != 0 && MyChar.gMC.xm < 0) {
                MyChar.gMC.ym = 1024;
            }
            if ((MyChar.gMC.flag & 8) != 0 && (MyChar.gMC.flag & 0x10000) != 0 && MyChar.gMC.xm > 0) {
                MyChar.gMC.ym = 1024;
            }
            if ((MyChar.gMC.flag & 8) != 0 && (MyChar.gMC.flag & 0x20000) != 0 && (MyChar.gMC.flag & 0x40000) != 0) {
                MyChar.gMC.ym = 1024;
            }
        }
        if ((MyChar.gMC.flag & 0x100) != 0 && (MyChar.gMC.flag & 0xF000) == 0) {
            if (MyChar.gMC.xm < -767) {
                MyChar.gMC.xm = -767;
            }
            if (MyChar.gMC.xm > 767) {
                MyChar.gMC.xm = 767;
            }
            if (MyChar.gMC.ym < -767) {
                MyChar.gMC.ym = -767;
            }
            if (MyChar.gMC.ym > 767) {
                MyChar.gMC.ym = 767;
            }
        } else {
            if (MyChar.gMC.xm < -1535) {
                MyChar.gMC.xm = -1535;
            }
            if (MyChar.gMC.xm > 1535) {
                MyChar.gMC.xm = 1535;
            }
            if (MyChar.gMC.ym < -1535) {
                MyChar.gMC.ym = -1535;
            }
            if (MyChar.gMC.ym > 1535) {
                MyChar.gMC.ym = 1535;
            }
        }
        if (MyChar.gMC.sprash == 0 && (MyChar.gMC.flag & 0x100) != 0) {
            int dir = (MyChar.gMC.flag & 0x800) != 0 ? 2 : 0;
            if ((MyChar.gMC.flag & 8) == 0 && MyChar.gMC.ym > 512) {
                for (int a = 0; a < 8; ++a) {
                    int x = MyChar.gMC.x + Game.Random(-8, 8) * 512;
                    NpChar.SetNpChar(73, x, MyChar.gMC.y, MyChar.gMC.xm + Game.Random(-512, 512), Game.Random(-512, 128) - MyChar.gMC.ym / 2, dir, null, 0);
                }
                Sound.PlaySoundObject(56, 1);
            } else if (MyChar.gMC.xm > 512 || MyChar.gMC.xm < -512) {
                for (int a = 0; a < 8; ++a) {
                    int x = MyChar.gMC.x + Game.Random(-8, 8) * 512;
                    NpChar.SetNpChar(73, x, MyChar.gMC.y, MyChar.gMC.xm + Game.Random(-512, 512), Game.Random(-512, 128), dir, null, 0);
                }
                Sound.PlaySoundObject(56, 1);
            }
            MyChar.gMC.sprash = 1;
        }
        if ((MyChar.gMC.flag & 0x100) == 0) {
            MyChar.gMC.sprash = 0;
        }
        if ((MyChar.gMC.flag & 0x400) != 0) {
            MycParam.DamageMyChar(10);
        }
        if (MyChar.gMC.direct == 0) {
            MyChar.gMC.index_x -= 512;
            if (MyChar.gMC.index_x < Short.MIN_VALUE) {
                MyChar.gMC.index_x = Short.MIN_VALUE;
            }
        } else {
            MyChar.gMC.index_x += 512;
            if (MyChar.gMC.index_x > 32768) {
                MyChar.gMC.index_x = 32768;
            }
        }
        if ((KeyControl.gKey & KeyControl.gKeyUp) != 0 && bKey) {
            MyChar.gMC.index_y -= 512;
            if (MyChar.gMC.index_y < Short.MIN_VALUE) {
                MyChar.gMC.index_y = Short.MIN_VALUE;
            }
        } else if ((KeyControl.gKey & KeyControl.gKeyDown) != 0 && bKey) {
            MyChar.gMC.index_y += 512;
            if (MyChar.gMC.index_y > 32768) {
                MyChar.gMC.index_y = 32768;
            }
        } else {
            if (MyChar.gMC.index_y > 512) {
                MyChar.gMC.index_y -= 512;
            }
            if (MyChar.gMC.index_y < -512) {
                MyChar.gMC.index_y += 512;
            }
        }
        MyChar.gMC.tgt_x = MyChar.gMC.x + MyChar.gMC.index_x;
        MyChar.gMC.tgt_y = MyChar.gMC.y + MyChar.gMC.index_y;
        if (MyChar.gMC.xm > resist || MyChar.gMC.xm < -resist) {
            MyChar.gMC.x += MyChar.gMC.xm;
        }
        MyChar.gMC.y += MyChar.gMC.ym;
    }

    public static void ActMyChar_Stream(boolean bKey) {
        MyChar.gMC.up = false;
        MyChar.gMC.down = false;
        if (bKey) {
            if ((KeyControl.gKey & (KeyControl.gKeyLeft | KeyControl.gKeyRight)) != 0) {
                if ((KeyControl.gKey & KeyControl.gKeyLeft) != 0) {
                    MyChar.gMC.xm -= 256;
                }
                if ((KeyControl.gKey & KeyControl.gKeyRight) != 0) {
                    MyChar.gMC.xm += 256;
                }
            } else if (MyChar.gMC.xm < 128 && MyChar.gMC.xm > -128) {
                MyChar.gMC.xm = 0;
            } else if (MyChar.gMC.xm > 0) {
                MyChar.gMC.xm -= 128;
            } else if (MyChar.gMC.xm < 0) {
                MyChar.gMC.xm += 128;
            }
            if ((KeyControl.gKey & (KeyControl.gKeyUp | KeyControl.gKeyDown)) != 0) {
                if ((KeyControl.gKey & KeyControl.gKeyUp) != 0) {
                    MyChar.gMC.ym -= 256;
                }
                if ((KeyControl.gKey & KeyControl.gKeyDown) != 0) {
                    MyChar.gMC.ym += 256;
                }
            } else if (MyChar.gMC.ym < 128 && MyChar.gMC.ym > -128) {
                MyChar.gMC.ym = 0;
            } else if (MyChar.gMC.ym > 0) {
                MyChar.gMC.ym -= 128;
            } else if (MyChar.gMC.ym < 0) {
                MyChar.gMC.ym += 128;
            }
        } else {
            if (MyChar.gMC.xm < 128 && MyChar.gMC.xm > -64) {
                MyChar.gMC.xm = 0;
            } else if (MyChar.gMC.xm > 0) {
                MyChar.gMC.xm -= 128;
            } else if (MyChar.gMC.xm < 0) {
                MyChar.gMC.xm += 128;
            }
            if (MyChar.gMC.ym < 128 && MyChar.gMC.ym > -64) {
                MyChar.gMC.ym = 0;
            } else if (MyChar.gMC.ym > 0) {
                MyChar.gMC.ym -= 128;
            } else if (MyChar.gMC.ym < 0) {
                MyChar.gMC.ym += 128;
            }
        }
        if (MyChar.gMC.ym < -512 && (MyChar.gMC.flag & 2) != 0) {
            Caret.SetCaret(MyChar.gMC.x, MyChar.gMC.y - MyChar.gMC.hit.top, 13, 5);
        }
        if (MyChar.gMC.ym > 512 && (MyChar.gMC.flag & 8) != 0) {
            Caret.SetCaret(MyChar.gMC.x, MyChar.gMC.y + MyChar.gMC.hit.bottom, 13, 5);
        }
        if (MyChar.gMC.xm > 1024) {
            MyChar.gMC.xm = 1024;
        }
        if (MyChar.gMC.xm < -1024) {
            MyChar.gMC.xm = -1024;
        }
        if (MyChar.gMC.ym > 1024) {
            MyChar.gMC.ym = 1024;
        }
        if (MyChar.gMC.ym < -1024) {
            MyChar.gMC.ym = -1024;
        }
        if ((KeyControl.gKey & (KeyControl.gKeyLeft | KeyControl.gKeyUp)) == (KeyControl.gKeyLeft | KeyControl.gKeyUp)) {
            if (MyChar.gMC.xm < -780) {
                MyChar.gMC.xm = -780;
            }
            if (MyChar.gMC.ym < -780) {
                MyChar.gMC.ym = -780;
            }
        }
        if ((KeyControl.gKey & (KeyControl.gKeyRight | KeyControl.gKeyUp)) == (KeyControl.gKeyRight | KeyControl.gKeyUp)) {
            if (MyChar.gMC.xm > 780) {
                MyChar.gMC.xm = 780;
            }
            if (MyChar.gMC.ym < -780) {
                MyChar.gMC.ym = -780;
            }
        }
        if ((KeyControl.gKey & (KeyControl.gKeyLeft | KeyControl.gKeyDown)) == (KeyControl.gKeyLeft | KeyControl.gKeyDown)) {
            if (MyChar.gMC.xm < -780) {
                MyChar.gMC.xm = -780;
            }
            if (MyChar.gMC.ym > 780) {
                MyChar.gMC.ym = 780;
            }
        }
        if ((KeyControl.gKey & (KeyControl.gKeyRight | KeyControl.gKeyDown)) == (KeyControl.gKeyRight | KeyControl.gKeyDown)) {
            if (MyChar.gMC.xm > 780) {
                MyChar.gMC.xm = 780;
            }
            if (MyChar.gMC.ym > 780) {
                MyChar.gMC.ym = 780;
            }
        }
        MyChar.gMC.x += MyChar.gMC.xm;
        MyChar.gMC.y += MyChar.gMC.ym;
    }

    public static void AirProcess() {
        if ((MyChar.gMC.equip & 0x10) != 0) {
            MyChar.gMC.air = 1000;
            MyChar.gMC.air_get = 0;
        } else {
            if ((MyChar.gMC.flag & 0x100) == 0) {
                MyChar.gMC.air = 1000;
            } else if (--MyChar.gMC.air <= 0) {
                if (Flags.GetNPCFlag(4000)) {
                    TextScr.StartTextScript(1100);
                } else {
                    TextScr.StartTextScript(41);
                    if (MyChar.gMC.direct == 0) {
                        Caret.SetCaret(MyChar.gMC.x, MyChar.gMC.y, 8, 0);
                    } else {
                        Caret.SetCaret(MyChar.gMC.x, MyChar.gMC.y, 8, 2);
                    }
                    MyChar.gMC.cond = (char)(MyChar.gMC.cond & 0xFFFFFF7F);
                }
            }
            if ((MyChar.gMC.flag & 0x100) != 0) {
                MyChar.gMC.air_get = 60;
            } else if (MyChar.gMC.air_get != 0) {
                --MyChar.gMC.air_get;
            }
        }
    }

    public static void ActMyChar(boolean bKey) {
        if ((MyChar.gMC.cond & 0x80) == 0) {
            return;
        }
        if (MyChar.gMC.exp_wait != 0) {
            --MyChar.gMC.exp_wait;
        }
        if (MyChar.gMC.shock != '\u0000') {
            MyChar.gMC.shock = (char)(MyChar.gMC.shock - '\u0001');
        } else if (MyChar.gMC.exp_count != 0) {
            ValueView.SetValueView(() -> MyChar.gMC.x, () -> MyChar.gMC.y, MyChar.gMC.exp_count, gMC.hashCode());
            MyChar.gMC.exp_count = 0;
        }
        switch (MyChar.gMC.unit) {
            case 0: {
                if ((Game.g_GameFlags & 4) == 0 && bKey) {
                    MyChar.AirProcess();
                }
                MyChar.ActMyChar_Normal(bKey);
                break;
            }
            case 1: {
                MyChar.ActMyChar_Stream(bKey);
            }
        }
        MyChar.gMC.cond = (char)(MyChar.gMC.cond & 0xFFFFFFDF);
    }

    public static void InitMyChar() {
        gMC.clear();
        MyChar.gMC.cond = (char)128;
        MyChar.gMC.direct = 2;
        MyChar.gMC.view.back = 4096;
        MyChar.gMC.view.top = 4096;
        MyChar.gMC.view.front = 4096;
        MyChar.gMC.view.bottom = 4096;
        MyChar.gMC.hit.back = 2560;
        MyChar.gMC.hit.top = 4096;
        MyChar.gMC.hit.front = 2560;
        MyChar.gMC.hit.bottom = 4096;
        MyChar.gMC.life = (short)3;
        MyChar.gMC.max_life = (short)3;
        MyChar.gMC.unit = 0;
    }

    public static void SetMyCharPosition(int x, int y) {
        MyChar.gMC.x = x;
        MyChar.gMC.y = y;
        MyChar.gMC.tgt_x = MyChar.gMC.x;
        MyChar.gMC.tgt_y = MyChar.gMC.y;
        MyChar.gMC.index_x = 0;
        MyChar.gMC.index_y = 0;
        MyChar.gMC.xm = 0;
        MyChar.gMC.ym = 0;
        MyChar.gMC.cond = (char)(MyChar.gMC.cond & 0xFFFFFFFE);
        Star.InitStar();
    }

    public static void MoveMyChar(int x, int y) {
        MyChar.gMC.x = x;
        MyChar.gMC.y = y;
    }

    public static void ZeroMyCharXMove() {
        MyChar.gMC.xm = 0;
    }

    public static int GetUnitMyChar() {
        return MyChar.gMC.unit;
    }

    public static void SetMyCharDirect(char dir) {
        if (dir == '\u0003') {
            MyChar.gMC.cond = (char)(MyChar.gMC.cond | '\u0001');
        } else {
            MyChar.gMC.cond = (char)(MyChar.gMC.cond & 0xFFFFFFFE);
            if (dir < '\n') {
                MyChar.gMC.direct = dir;
            } else {
                int i;
                for (i = 0; i < NpChar.gNPC.length && NpChar.gNPC[i].code_event != dir; ++i) {
                }
                if (i == NpChar.gNPC.length) {
                    return;
                }
                MyChar.gMC.direct = MyChar.gMC.x > NpChar.gNPC[i].x ? 0 : 2;
            }
        }
        MyChar.gMC.xm = 0;
        MyChar.AnimationMyChar(false);
    }

    public static void ChangeMyUnit(char a) {
        MyChar.gMC.unit = a;
    }

    public static void PitMyChar() {
        MyChar.gMC.y += 16384;
    }

    public static void EquipItem(int flag, boolean b) {
        MyChar.gMC.equip = b ? (MyChar.gMC.equip |= flag) : (MyChar.gMC.equip &= ~flag);
    }

    public static void ResetCheck() {
        MyChar.gMC.cond = (char)(MyChar.gMC.cond & 0xFFFFFFFE);
    }

    public static void SetNoise(int no, int freq) {
        noise_freq = freq;
        noise_no = no;
        switch (noise_no) {
            case 1: {
                Sound.ChangeSoundFrequency(40, noise_freq);
                Sound.ChangeSoundFrequency(41, noise_freq + 100);
                Sound.PlaySoundObject(40, -1);
                Sound.PlaySoundObject(41, -1);
                break;
            }
            case 2: {
                Sound.PlaySoundObject(58, -1);
            }
        }
    }

    public static void CutNoise() {
        noise_no = 0;
        Sound.PlaySoundObject(40, 0);
        Sound.PlaySoundObject(41, 0);
        Sound.PlaySoundObject(58, 0);
    }

    public static void ResetNoise() {
        switch (noise_no) {
            case 1: {
                Sound.ChangeSoundFrequency(40, noise_freq);
                Sound.ChangeSoundFrequency(41, noise_freq + 100);
                Sound.PlaySoundObject(40, -1);
                Sound.PlaySoundObject(41, -1);
                break;
            }
            case 2: {
                Sound.PlaySoundObject(58, -1);
            }
        }
    }

    public static void SleepNoise() {
        Sound.PlaySoundObject(40, 0);
        Sound.PlaySoundObject(41, 0);
        Sound.PlaySoundObject(58, 0);
    }

    public static class MYCHAR {
        char cond;
        int flag;
        int direct;
        boolean up;
        boolean down;
        int unit;
        int equip;
        int x;
        int y;
        int tgt_x;
        int tgt_y;
        int index_x;
        int index_y;
        int xm;
        int ym;
        int ani_wait;
        int ani_no;
        final NpChar.OTHER_RECT hit = new NpChar.OTHER_RECT();
        final NpChar.OTHER_RECT view = new NpChar.OTHER_RECT();
        final RECT rect = new RECT();
        final RECT rect_arms = new RECT();
        int level;
        int exp_wait;
        int exp_count;
        char shock;
        char no_life;
        char rensha;
        char bubble;
        short life;
        short star;
        short max_life;
        short a;
        int lifeBr;
        int lifeBr_count;
        int air;
        int air_get;
        byte sprash;
        byte ques;
        byte boost_sw;
        int boost_cnt;

        public MYCHAR() {
            this.clear();
        }

        public void clear() {
            this.cond = '\u0000';
            this.flag = 0;
            this.direct = 0;
            this.up = false;
            this.down = false;
            this.unit = 0;
            this.equip = 0;
            this.x = 0;
            this.y = 0;
            this.tgt_x = 0;
            this.tgt_y = 0;
            this.index_x = 0;
            this.index_y = 0;
            this.xm = 0;
            this.ym = 0;
            this.ani_wait = 0;
            this.ani_no = 0;
            this.hit.clear();
            this.view.clear();
            this.rect.clear();
            this.rect_arms.clear();
            this.level = 0;
            this.exp_wait = 0;
            this.exp_count = 0;
            this.shock = '\u0000';
            this.no_life = '\u0000';
            this.rensha = '\u0000';
            this.bubble = '\u0000';
            this.life = 0;
            this.star = 0;
            this.max_life = 0;
            this.a = 0;
            this.lifeBr = 0;
            this.lifeBr_count = 0;
            this.air = 0;
            this.air_get = 0;
            this.sprash = 0;
            this.ques = 0;
            this.boost_sw = 0;
            this.boost_cnt = 0;
        }
    }
}
