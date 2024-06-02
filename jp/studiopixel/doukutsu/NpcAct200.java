/*
 * Decompiled with CFR 0.152.
 */
package jp.studiopixel.doukutsu;

import jp.studiopixel.doukutsu.Bullet;
import jp.studiopixel.doukutsu.Caret;
import jp.studiopixel.doukutsu.Frame;
import jp.studiopixel.doukutsu.Game;
import jp.studiopixel.doukutsu.MyChar;
import jp.studiopixel.doukutsu.NpChar;
import jp.studiopixel.doukutsu.RECT;
import jp.studiopixel.doukutsu.Sound;
import jp.studiopixel.doukutsu.Triangle;

public class NpcAct200 {
    private static final RECT[] ActNpc200_rcLeft = new RECT[]{new RECT(0, 0, 40, 40), new RECT(40, 0, 80, 40), new RECT(80, 0, 120, 40), new RECT(120, 0, 160, 40), new RECT(160, 0, 200, 40), new RECT(200, 0, 240, 40)};
    private static final RECT[] ActNpc200_rcRight = new RECT[]{new RECT(0, 40, 40, 80), new RECT(40, 40, 80, 80), new RECT(80, 40, 120, 80), new RECT(120, 40, 160, 80), new RECT(160, 40, 200, 80), new RECT(200, 40, 240, 80)};
    private static final RECT[] ActNpc201_rcLeft = new RECT[]{new RECT(200, 0, 240, 40)};
    private static final RECT[] ActNpc201_rcRight = new RECT[]{new RECT(200, 40, 240, 80)};
    private static final RECT[] ActNpc202_rect_left = new RECT[]{new RECT(184, 216, 200, 240), new RECT(200, 216, 216, 240), new RECT(216, 216, 232, 240)};
    private static final RECT[] ActNpc203_rcLeft = new RECT[]{new RECT(0, 80, 16, 96), new RECT(16, 80, 32, 96), new RECT(32, 80, 48, 96)};
    private static final RECT[] ActNpc203_rcRight = new RECT[]{new RECT(0, 96, 16, 112), new RECT(16, 96, 32, 112), new RECT(32, 96, 48, 112)};
    private static final RECT[] ActNpc204_rc = new RECT[]{new RECT(240, 80, 256, 96), new RECT(240, 144, 256, 160)};
    private static final RECT[] ActNpc205_rc = new RECT[]{new RECT(112, 80, 128, 112), new RECT(128, 80, 144, 112)};
    private static final RECT[] ActNpc206_rect_left = new RECT[]{new RECT(80, 80, 120, 120), new RECT(120, 80, 160, 120), new RECT(160, 80, 200, 120)};
    private static final RECT[] ActNpc207_rc = new RECT[]{new RECT(0, 144, 16, 160), new RECT(16, 144, 32, 160), new RECT(32, 144, 48, 160), new RECT(48, 144, 64, 160), new RECT(64, 144, 80, 160)};
    private static final RECT[] ActNpc208_rcLeft = new RECT[]{new RECT(248, 80, 272, 104), new RECT(272, 80, 296, 104), new RECT(296, 80, 320, 104)};
    private static final RECT[] ActNpc208_rcRight = new RECT[]{new RECT(248, 104, 272, 128), new RECT(272, 104, 296, 128), new RECT(296, 104, 320, 128)};
    private static final RECT[] ActNpc209_rect_left = new RECT[]{new RECT(232, 96, 248, 112), new RECT(200, 112, 216, 128), new RECT(216, 112, 232, 128), new RECT(232, 112, 248, 128)};
    private static final RECT[] ActNpc210_rcLeft = new RECT[]{new RECT(0, 112, 16, 128), new RECT(16, 112, 32, 128)};
    private static final RECT[] ActNpc210_rcRight = new RECT[]{new RECT(32, 112, 48, 128), new RECT(48, 112, 64, 128)};
    private static final RECT[] ActNpc211_rects = new RECT[]{new RECT(256, 200, 272, 216), new RECT(272, 200, 288, 216), new RECT(288, 200, 304, 216), new RECT(304, 200, 320, 216)};
    private static final RECT[] ActNpc212_rcRight = new RECT[]{new RECT(160, 152, 200, 192), new RECT(200, 152, 240, 192), new RECT(240, 112, 280, 152), new RECT(280, 112, 320, 152)};
    private static final RECT[] ActNpc213_rect = new RECT[]{new RECT(0, 0, 0, 0), new RECT(0, 0, 48, 48), new RECT(48, 0, 96, 48), new RECT(96, 0, 144, 48), new RECT(144, 0, 192, 48), new RECT(192, 0, 240, 48), new RECT(240, 0, 288, 48), new RECT(0, 48, 48, 96), new RECT(48, 48, 96, 96), new RECT(96, 48, 144, 96)};
    private static final RECT[] ActNpc214_rect = new RECT[]{new RECT(144, 48, 176, 64), new RECT(176, 48, 208, 64), new RECT(208, 48, 240, 64)};
    private static final RECT[] ActNpc215_rect = new RECT[]{new RECT(0, 0, 0, 0), new RECT(0, 96, 48, 128), new RECT(48, 96, 96, 128), new RECT(96, 96, 144, 128), new RECT(144, 96, 192, 128)};
    private static final RECT ActNpc216_rect = new RECT(256, 192, 272, 216);
    private static final RECT[] ActNpc217_rect = new RECT[]{new RECT(144, 64, 160, 80), new RECT(160, 64, 176, 80), new RECT(176, 64, 192, 80), new RECT(192, 64, 208, 80), new RECT(144, 80, 160, 96), new RECT(160, 80, 176, 96), new RECT(144, 80, 160, 96), new RECT(176, 80, 192, 96)};
    private static final RECT[] ActNpc218_rc = new RECT[]{new RECT(256, 120, 288, 152), new RECT(288, 120, 320, 152)};
    private static final RECT ActNpc219_rc = new RECT(0, 0, 0, 0);

    public static void ActNpc200(NpChar.NPCHAR npc) {
        if (npc.act_no < 100 && npc.life < 950) {
            Sound.PlaySoundObject(72, 1);
            NpChar.SetDestroyNpChar(npc.x, npc.y, npc.view.back, 8);
            NpChar.SetExpObjects(npc.x, npc.y, npc.exp);
            npc.act_no = 100;
            npc.bits = (char)(npc.bits & 0xFFFFFFDF);
            npc.damage = 0;
        }
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 10;
                npc.count1 = 0;
            }
            case 10: {
                if (++npc.ani_wait > 30) {
                    npc.ani_wait = 0;
                    ++npc.ani_no;
                }
                if (npc.ani_no > 1) {
                    npc.ani_no = 0;
                }
                if (npc.count1 != 0) {
                    --npc.count1;
                }
                if (npc.count1 != 0 || MyChar.gMC.x <= npc.x - 57344 || MyChar.gMC.x >= npc.x + 57344) break;
                npc.act_no = 20;
                break;
            }
            case 20: {
                npc.act_no = 21;
                npc.act_wait = 0;
            }
            case 21: {
                npc.ani_no = ++npc.act_wait / 2 % 2 != 0 ? 2 : 3;
                if (npc.act_wait > 30) {
                    npc.act_no = 30;
                }
                if (MyChar.gMC.x < npc.x) {
                    npc.direct = 0;
                    break;
                }
                npc.direct = 2;
                break;
            }
            case 30: {
                npc.act_no = 31;
                npc.act_wait = 0;
                npc.ani_no = 4;
                npc.tgt_x = MyChar.gMC.x;
                npc.tgt_y = MyChar.gMC.y;
            }
            case 31: {
                if (++npc.act_wait < 40 && npc.act_wait % 8 == 1) {
                    char deg = npc.direct == 0 ? (char)Triangle.GetArktan(npc.x - 7168 - npc.tgt_x, npc.y - npc.tgt_y) : (char)Triangle.GetArktan(npc.x + 7168 - npc.tgt_x, npc.y - npc.tgt_y);
                    deg = (char)(deg + (char)Game.Random(-6, 6) & 0xFF);
                    int ym = Triangle.GetSin(deg) * 3;
                    int xm = Triangle.GetCos(deg) * 3;
                    if (npc.direct == 0) {
                        NpChar.SetNpChar(202, npc.x - 7168, npc.y, xm, ym, 0, null, 256);
                    } else {
                        NpChar.SetNpChar(202, npc.x + 7168, npc.y, xm, ym, 0, null, 256);
                    }
                    if ((MyChar.gMC.cond & 2) == 0) {
                        Sound.PlaySoundObject(33, 1);
                    }
                }
                if (npc.act_wait <= 60) break;
                npc.act_no = 10;
                npc.count1 = Game.Random(100, 200);
                npc.ani_wait = 0;
                break;
            }
            case 100: {
                npc.ani_no = 5;
            }
        }
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc200_rcLeft[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc200_rcRight[npc.ani_no]);
        }
    }

    public static void ActNpc201(NpChar.NPCHAR npc) {
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc201_rcLeft[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc201_rcRight[npc.ani_no]);
        }
    }

    public static void ActNpc202(NpChar.NPCHAR npc) {
        if ((npc.flag & 0xFF) != 0) {
            npc.cond = 0;
            Caret.SetCaret(npc.x, npc.y, 2, 0);
        }
        npc.y += npc.ym;
        npc.x += npc.xm;
        if (++npc.ani_wait > 1) {
            npc.ani_wait = 0;
            ++npc.ani_no;
        }
        if (npc.ani_no > 2) {
            npc.ani_no = 0;
        }
        npc.rect.copyFrom(ActNpc202_rect_left[npc.ani_no]);
        if (++npc.count1 > 300) {
            npc.cond = 0;
            Caret.SetCaret(npc.x, npc.y, 2, 0);
        }
    }

    public static void ActNpc203(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.y += 1536;
                npc.act_no = 1;
            }
            case 1: {
                npc.direct = npc.x > MyChar.gMC.x ? 0 : 2;
                if (npc.act_wait >= 8 && npc.x - 57344 < MyChar.gMC.x && npc.x + 57344 > MyChar.gMC.x && npc.y - 40960 < MyChar.gMC.y && npc.y + 40960 > MyChar.gMC.y) {
                    npc.ani_no = 1;
                } else {
                    if (npc.act_wait < 8) {
                        ++npc.act_wait;
                    }
                    npc.ani_no = 0;
                }
                if (npc.shock != '\u0000') {
                    npc.act_no = 2;
                    npc.ani_no = 0;
                    npc.act_wait = 0;
                }
                if (npc.act_wait < 8 || npc.x - 24576 >= MyChar.gMC.x || npc.x + 24576 <= MyChar.gMC.x || npc.y - 40960 >= MyChar.gMC.y || npc.y + 24576 <= MyChar.gMC.y) break;
                npc.act_no = 2;
                npc.ani_no = 0;
                npc.act_wait = 0;
                break;
            }
            case 2: {
                if (++npc.act_wait <= 8) break;
                npc.act_no = 3;
                npc.ani_no = 2;
                npc.ym = -1535;
                if ((MyChar.gMC.cond & 2) == 0) {
                    Sound.PlaySoundObject(30, 1);
                }
                if (npc.direct == 0) {
                    npc.xm = -256;
                    break;
                }
                npc.xm = 256;
                break;
            }
            case 3: {
                if ((npc.flag & 8) == 0) break;
                npc.xm = 0;
                npc.act_wait = 0;
                npc.ani_no = 0;
                npc.act_no = 1;
                if ((MyChar.gMC.cond & 2) != 0) break;
                Sound.PlaySoundObject(23, 1);
            }
        }
        npc.ym += 64;
        if (npc.ym > 1535) {
            npc.ym = 1535;
        }
        npc.x += npc.xm;
        npc.y += npc.ym;
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc203_rcLeft[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc203_rcRight[npc.ani_no]);
        }
    }

    public static void ActNpc204(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
                npc.tgt_x = npc.x;
            }
            case 1: {
                if (MyChar.gMC.x <= npc.x - 6144 || MyChar.gMC.x >= npc.x + 6144 || MyChar.gMC.y <= npc.y) break;
                npc.act_no = 2;
                break;
            }
            case 2: {
                npc.x = ++npc.act_wait / 6 % 2 != 0 ? npc.tgt_x - 512 : npc.tgt_x;
                if (npc.act_wait <= 30) break;
                npc.act_no = 3;
                npc.ani_no = 1;
                break;
            }
            case 3: {
                npc.ym += 32;
                if ((npc.flag & 0xFF) == 0) break;
                if ((MyChar.gMC.cond & 2) == 0) {
                    Sound.PlaySoundObject(12, 1);
                }
                NpChar.SetDestroyNpChar(npc.x, npc.y, npc.view.back, 4);
                npc.cond = 0;
                return;
            }
        }
        if (npc.ym > 3072) {
            npc.ym = 3072;
        }
        npc.y += npc.ym;
        npc.rect.copyFrom(ActNpc204_rc[npc.ani_no]);
    }

    public static void ActNpc205(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
                npc.tgt_x = npc.x;
                npc.y += 2048;
            }
            case 1: {
                if (MyChar.gMC.x <= npc.x - 6144 || MyChar.gMC.x >= npc.x + 6144 || MyChar.gMC.y <= npc.y) break;
                npc.act_no = 2;
                break;
            }
            case 2: {
                npc.x = ++npc.act_wait / 6 % 2 != 0 ? npc.tgt_x - 512 : npc.tgt_x;
                if (npc.act_wait <= 30) break;
                npc.act_no = 3;
                npc.ani_no = 1;
                npc.act_wait = 0;
                break;
            }
            case 3: {
                npc.ym += 32;
                if (MyChar.gMC.y > npc.y) {
                    npc.bits = (char)(npc.bits & 0xFFFFFFBF);
                    npc.damage = 127;
                } else {
                    npc.bits = (char)(npc.bits | 0x40);
                    npc.damage = 0;
                }
                if (++npc.act_wait <= 8 || (npc.flag & 0xFF) == 0) break;
                npc.bits = (char)(npc.bits | 0x40);
                npc.act_no = 4;
                npc.act_wait = 0;
                npc.ym = 0;
                npc.damage = 0;
                Sound.PlaySoundObject(12, 1);
                NpChar.SetDestroyNpChar(npc.x, npc.y, npc.view.back, 4);
                Bullet.SetBullet(24, npc.x, npc.y, 0);
                return;
            }
            case 4: {
                if (++npc.act_wait <= 4) break;
                npc.act_no = 5;
                npc.bits = (char)(npc.bits | 0x20);
            }
        }
        if (npc.ym > 3072) {
            npc.ym = 3072;
        }
        npc.y += npc.ym;
        npc.rect.copyFrom(ActNpc205_rc[npc.ani_no]);
    }

    public static void ActNpc206(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
                npc.tgt_x = npc.x;
                npc.tgt_y = npc.y;
                npc.count1 = 120;
                npc.act_wait = Game.Random(0, 50);
            }
            case 1: {
                if (++npc.act_wait < 50) break;
                npc.act_wait = 0;
                npc.act_no = 2;
                npc.ym = 768;
                break;
            }
            case 2: {
                if (MyChar.gMC.x > npc.x - 40960 && MyChar.gMC.x < npc.x + 40960) {
                    npc.act_wait = 0;
                    npc.act_no = 3;
                }
                if (npc.shock == '\u0000') break;
                npc.act_wait = 0;
                npc.act_no = 3;
                break;
            }
            case 3: {
                switch (npc.act_wait) {
                    case 0: {
                        NpChar.SetNpChar(207, npc.x + 8192, npc.y + 2048, 0, 0, 0, null, 256);
                        break;
                    }
                    case 60: {
                        NpChar.SetNpChar(207, npc.x + 8192, npc.y + 2048, 0, 0, 1, null, 256);
                        break;
                    }
                    case 120: {
                        NpChar.SetNpChar(207, npc.x + 8192, npc.y + 2048, 0, 0, 2, null, 256);
                        break;
                    }
                    case 180: {
                        NpChar.SetNpChar(207, npc.x + 8192, npc.y + 2048, 0, 0, 3, null, 256);
                        break;
                    }
                    case 240: {
                        NpChar.SetNpChar(207, npc.x + 8192, npc.y + 2048, 0, 0, 4, null, 256);
                        break;
                    }
                    case 300: {
                        npc.hit.back = 65536;
                        npc.hit.front = 65536;
                        npc.hit.top = 51200;
                        npc.hit.bottom = 51200;
                        npc.damage = 30;
                        Sound.PlaySoundObject(35, 1);
                        NpChar.SetDestroyNpChar(npc.x, npc.y, 65536, 100);
                        Frame.SetQuake(20);
                        npc.cond = (byte)(npc.cond | 8);
                    }
                }
                ++npc.act_wait;
            }
        }
        if (npc.act_no > 1) {
            if (npc.tgt_y < npc.y) {
                npc.ym -= 16;
            }
            if (npc.tgt_y > npc.y) {
                npc.ym += 16;
            }
            if (npc.ym > 256) {
                npc.ym = 256;
            }
            if (npc.ym < -256) {
                npc.ym = -256;
            }
        }
        npc.x += npc.xm;
        npc.y += npc.ym;
        if (++npc.ani_wait > 4) {
            npc.ani_wait = 0;
            ++npc.ani_no;
        }
        if (npc.ani_no > 2) {
            npc.ani_no = 0;
        }
        npc.rect.copyFrom(ActNpc206_rect_left[npc.ani_no]);
    }

    public static void ActNpc207(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
                npc.ani_no = npc.direct;
                Sound.PlaySoundObject(43, 1);
            }
            case 1: {
                npc.x += 512;
                if (++npc.act_wait <= 8) break;
                npc.act_wait = 0;
                npc.act_no = 2;
                break;
            }
            case 2: {
                if (++npc.act_wait <= 30) break;
                npc.cond = 0;
                return;
            }
        }
        npc.rect.copyFrom(ActNpc207_rc[npc.ani_no]);
    }

    public static void ActNpc208(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                if (MyChar.gMC.x < npc.x + 8192 && MyChar.gMC.x > npc.x - 8192) {
                    npc.bits = (char)(npc.bits | 0x20);
                    npc.ym = -512;
                    npc.tgt_x = npc.x;
                    npc.tgt_y = npc.y;
                    npc.act_no = 1;
                    npc.act_wait = 0;
                    npc.count1 = npc.direct;
                    npc.count2 = 0;
                    npc.damage = 6;
                    if (npc.direct == 0) {
                        npc.x = MyChar.gMC.x + 131072;
                        npc.xm = -767;
                    } else {
                        npc.x = MyChar.gMC.x - 131072;
                        npc.xm = 767;
                    }
                    return;
                }
                npc.rect.right = 0;
                npc.damage = 0;
                npc.xm = 0;
                npc.ym = 0;
                npc.bits = (char)(npc.bits & 0xFFFFFFDF);
                return;
            }
            case 1: {
                if (npc.x > MyChar.gMC.x) {
                    npc.direct = 0;
                    npc.xm -= 16;
                } else {
                    npc.direct = 2;
                    npc.xm += 16;
                }
                if ((npc.flag & 1) != 0) {
                    npc.xm = 512;
                }
                if ((npc.flag & 4) != 0) {
                    npc.xm = -512;
                }
                npc.ym = npc.y < npc.tgt_y ? (npc.ym += 8) : (npc.ym -= 8);
                if (npc.xm > 767) {
                    npc.xm = 767;
                }
                if (npc.xm < -767) {
                    npc.xm = -767;
                }
                if (npc.ym > 512) {
                    npc.ym = 512;
                }
                if (npc.ym < -512) {
                    npc.ym = -512;
                }
                if (npc.shock != '\u0000') {
                    npc.x += npc.xm / 2;
                    npc.y += npc.ym / 2;
                } else {
                    npc.x += npc.xm;
                    npc.y += npc.ym;
                }
                if (MyChar.gMC.x <= npc.x + 204800 && MyChar.gMC.x >= npc.x - 204800) break;
                npc.act_no = 0;
                npc.xm = 0;
                npc.direct = npc.count1;
                npc.x = npc.tgt_x;
                npc.rect.right = 0;
                npc.damage = 0;
                return;
            }
        }
        if (npc.act_no != 0) {
            if (npc.act_wait < 150) {
                ++npc.act_wait;
            }
            if (npc.act_wait == 150) {
                if (++npc.count2 % 8 == 0 && npc.x < MyChar.gMC.x + 81920 && npc.x > MyChar.gMC.x - 81920) {
                    char deg = (char)Triangle.GetArktan(npc.x - MyChar.gMC.x, npc.y - MyChar.gMC.y);
                    deg = (char)(deg + (char)Game.Random(-6, 6) & 0xFF);
                    int ym = Triangle.GetSin(deg) * 3;
                    int xm = Triangle.GetCos(deg) * 3;
                    NpChar.SetNpChar(209, npc.x, npc.y, xm, ym, 0, null, 256);
                    Sound.PlaySoundObject(39, 1);
                }
                if (npc.count2 > 16) {
                    npc.act_wait = 0;
                    npc.count2 = 0;
                }
            }
        }
        if (++npc.ani_wait > 1) {
            npc.ani_wait = 0;
            ++npc.ani_no;
        }
        if (npc.ani_no > 1) {
            npc.ani_no = 0;
        }
        if (npc.act_wait > 120 && npc.act_wait / 2 % 2 == 1 && npc.ani_no == 1) {
            npc.ani_no = 2;
        }
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc208_rcLeft[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc208_rcRight[npc.ani_no]);
        }
    }

    public static void ActNpc209(NpChar.NPCHAR npc) {
        if ((npc.flag & 0xFF) != 0) {
            npc.cond = 0;
            Caret.SetCaret(npc.x, npc.y, 2, 0);
        }
        npc.y += npc.ym;
        npc.x += npc.xm;
        if (++npc.ani_wait > 2) {
            npc.ani_wait = 0;
            ++npc.ani_no;
        }
        if (npc.ani_no > 3) {
            npc.ani_no = 0;
        }
        npc.rect.copyFrom(ActNpc209_rect_left[npc.ani_no]);
        if (++npc.count1 > 300) {
            npc.cond = 0;
            Caret.SetCaret(npc.x, npc.y, 2, 0);
        }
    }

    public static void ActNpc210(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                if (MyChar.gMC.x < npc.x + 8192 && MyChar.gMC.x > npc.x - 8192) {
                    npc.bits = (char)(npc.bits | 0x20);
                    npc.ym = -512;
                    npc.tgt_y = npc.y;
                    npc.act_no = 1;
                    npc.damage = 2;
                    if (npc.direct == 0) {
                        npc.x = MyChar.gMC.x + 131072;
                        npc.xm = -767;
                        break;
                    }
                    npc.x = MyChar.gMC.x - 131072;
                    npc.xm = 767;
                    break;
                }
                npc.bits = (char)(npc.bits & 0xFFFFFFDF);
                npc.rect.right = 0;
                npc.damage = 0;
                npc.xm = 0;
                npc.ym = 0;
                return;
            }
            case 1: {
                if (npc.x > MyChar.gMC.x) {
                    npc.direct = 0;
                    npc.xm -= 16;
                } else {
                    npc.direct = 2;
                    npc.xm += 16;
                }
                if (npc.xm > 767) {
                    npc.xm = 767;
                }
                if (npc.xm < -767) {
                    npc.xm = -767;
                }
                npc.ym = npc.y < npc.tgt_y ? (npc.ym += 8) : (npc.ym -= 8);
                if (npc.ym > 512) {
                    npc.ym = 512;
                }
                if (npc.ym < -512) {
                    npc.ym = -512;
                }
                if (npc.shock != '\u0000') {
                    npc.x += npc.xm / 2;
                    npc.y += npc.ym / 2;
                    break;
                }
                npc.x += npc.xm;
                npc.y += npc.ym;
            }
        }
        if (++npc.ani_wait > 1) {
            npc.ani_wait = 0;
            ++npc.ani_no;
        }
        if (npc.ani_no > 1) {
            npc.ani_no = 0;
        }
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc210_rcLeft[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc210_rcRight[npc.ani_no]);
        }
    }

    public static void ActNpc211(NpChar.NPCHAR npc) {
        npc.rect.copyFrom(ActNpc211_rects[npc.code_event]);
    }

    public static void ActNpc212(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
                npc.y -= 2048;
            }
            case 1: {
                if (++npc.ani_wait > 30) {
                    npc.ani_wait = 0;
                    ++npc.ani_no;
                }
                if (npc.ani_no <= 1) break;
                npc.ani_no = 0;
                break;
            }
            case 10: {
                npc.act_no = 11;
                npc.ani_no = 2;
                npc.ani_wait = 0;
                npc.tgt_y = npc.y - 8192;
                npc.tgt_x = npc.x - 3072;
                npc.ym = 0;
                npc.bits = (char)(npc.bits | 8);
            }
            case 11: {
                npc.xm = npc.x < npc.tgt_x ? (npc.xm += 8) : (npc.xm -= 8);
                npc.ym = npc.y < npc.tgt_y ? (npc.ym += 8) : (npc.ym -= 8);
                npc.x += npc.xm;
                npc.y += npc.ym;
                if (++npc.ani_wait > 5) {
                    npc.ani_wait = 0;
                    ++npc.ani_no;
                }
                if (npc.ani_no <= 3) break;
                npc.ani_no = 2;
                break;
            }
            case 20: {
                npc.act_no = 21;
                npc.bits = (char)(npc.bits | 8);
            }
            case 21: {
                npc.ym = npc.y < npc.tgt_y ? (npc.ym += 16) : (npc.ym -= 16);
                npc.xm += 32;
                if (npc.xm > 1536) {
                    npc.xm = 1536;
                }
                if (npc.xm < -1536) {
                    npc.xm = -1536;
                }
                npc.x += npc.xm;
                npc.y += npc.ym;
                if (++npc.ani_wait > 2) {
                    npc.ani_wait = 0;
                    ++npc.ani_no;
                }
                if (npc.ani_no <= 3) break;
                npc.ani_no = 2;
                break;
            }
            case 30: {
                npc.act_no = 31;
                NpChar.SetNpChar(297, 0, 0, 0, 0, 0, npc, 256);
            }
        }
        npc.rect.copyFrom(ActNpc212_rcRight[npc.ani_no]);
        if ((MyChar.gMC.equip & 0x40) != 0 && npc.ani_no > 1) {
            npc.rect.top += 40;
            npc.rect.bottom += 40;
        }
    }

    public static void ActNpc213(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.ani_no = 0;
                npc.tgt_x = npc.x;
                npc.tgt_y = npc.y;
            }
            case 1: {
                if (MyChar.gMC.y <= npc.y - 4096 || MyChar.gMC.y >= npc.y + 4096) break;
                npc.y = npc.direct == 0 ? (npc.y -= 122880) : (npc.y += 122880);
                npc.act_no = 10;
                npc.act_wait = 0;
                npc.ani_no = 1;
                npc.ym = 0;
                npc.bits = (char)(npc.bits | 0x20);
                break;
            }
            case 10: {
                if (++npc.ani_wait > 2) {
                    npc.ani_wait = 0;
                    ++npc.ani_no;
                }
                if (npc.ani_no > 3) {
                    npc.ani_no = 1;
                }
                if (++npc.act_wait <= 200) break;
                npc.act_no = 20;
                npc.act_wait = 0;
                npc.ani_no = 4;
                break;
            }
            case 20: {
                if (++npc.ani_wait > 2) {
                    npc.ani_wait = 0;
                    ++npc.ani_no;
                }
                if (npc.ani_no > 6) {
                    npc.ani_no = 4;
                }
                if (++npc.act_wait <= 50) break;
                npc.act_no = 30;
                npc.act_wait = 0;
                npc.ani_no = 7;
                break;
            }
            case 30: {
                if (++npc.ani_wait > 2) {
                    npc.ani_wait = 0;
                    ++npc.ani_no;
                }
                if (npc.ani_no > 9) {
                    npc.ani_no = 7;
                }
                if (++npc.act_wait % 5 == 1) {
                    NpChar.SetNpChar(214, npc.x, npc.y, Game.Random(2, 12) * 512 / 4, Game.Random(-512, 512), 0, null, 256);
                    Sound.PlaySoundObject(21, 1);
                }
                if (npc.act_wait <= 50) break;
                npc.act_no = 10;
                npc.act_wait = 0;
                npc.ani_no = 1;
                break;
            }
            case 40: {
                npc.ym = npc.y < npc.tgt_y ? (npc.ym += 64) : (npc.ym -= 64);
                if (npc.ym < -1024) {
                    npc.ym = -1024;
                }
                if (npc.ym > 1024) {
                    npc.ym = 1024;
                }
                npc.y = npc.shock != '\u0000' ? (npc.y += npc.ym / 2) : (npc.y += npc.ym);
                if (++npc.ani_wait > 2) {
                    npc.ani_wait = 0;
                    ++npc.ani_no;
                }
                if (npc.ani_no > 6) {
                    npc.ani_no = 4;
                }
                if (MyChar.gMC.y >= npc.tgt_y + 122880 || MyChar.gMC.y <= npc.tgt_y - 122880) break;
                npc.act_no = 20;
                npc.act_wait = 0;
                npc.ani_no = 4;
            }
        }
        if (npc.act_no >= 10 && npc.act_no <= 30) {
            npc.ym = npc.y < MyChar.gMC.y ? (npc.ym += 25) : (npc.ym -= 25);
            if (npc.ym < -1024) {
                npc.ym = -1024;
            }
            if (npc.ym > 1024) {
                npc.ym = 1024;
            }
            if ((npc.flag & 2) != 0) {
                npc.ym = 512;
            }
            if ((npc.flag & 8) != 0) {
                npc.ym = -512;
            }
            npc.y = npc.shock != '\u0000' ? (npc.y += npc.ym / 2) : (npc.y += npc.ym);
            if (MyChar.gMC.y > npc.tgt_y + 122880 || MyChar.gMC.y < npc.tgt_y - 122880) {
                npc.act_no = 40;
            }
        }
        npc.rect.copyFrom(ActNpc213_rect[npc.ani_no]);
    }

    public static void ActNpc214(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
                npc.bits = (char)(npc.bits | 8);
            }
            case 1: {
                if (++npc.ani_wait > 2) {
                    npc.ani_wait = 0;
                    ++npc.ani_no;
                }
                if (npc.ani_no > 2) {
                    npc.ani_no = 0;
                }
                npc.xm -= 25;
                npc.x += npc.xm;
                npc.y += npc.ym;
                if (npc.xm < 0) {
                    npc.bits = (char)(npc.bits & 0xFFFFFFF7);
                }
                if ((npc.flag & 0xFF) == 0) break;
                NpChar.SetDestroyNpChar(npc.x, npc.y, npc.view.back, 4);
                Sound.PlaySoundObject(28, 1);
                npc.cond = 0;
            }
        }
        npc.rect.copyFrom(ActNpc214_rect[npc.ani_no]);
    }

    public static void ActNpc215(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.ani_no = 0;
                npc.act_no = 1;
                npc.act_wait = 0;
                npc.tgt_y = npc.y;
                npc.bits = (char)(npc.bits & 0xFFFFFFDF);
                npc.bits = (char)(npc.bits & 0xFFFFFFFB);
                npc.bits = (char)(npc.bits & 0xFFFFFFFE);
                npc.bits = (char)(npc.bits & 0xFFFFFFF7);
            }
            case 1: {
                if (MyChar.gMC.x <= npc.x - 6144 || MyChar.gMC.x >= npc.x + 6144 || MyChar.gMC.y <= npc.y || MyChar.gMC.y >= npc.y + 4096) break;
                npc.act_no = 15;
                npc.act_wait = 0;
                break;
            }
            case 15: {
                if (++npc.act_wait <= 10) break;
                Sound.PlaySoundObject(102, 1);
                npc.act_no = 20;
                break;
            }
            case 20: {
                if (++npc.ani_wait > 3) {
                    ++npc.ani_no;
                    npc.ani_wait = 0;
                }
                if (npc.ani_no == 3) {
                    npc.damage = 15;
                }
                if (npc.ani_no != 4) break;
                npc.bits = (char)(npc.bits | 0x20);
                npc.act_no = 30;
                npc.act_wait = 0;
                break;
            }
            case 30: {
                npc.bits = (char)(npc.bits | '\u0001');
                npc.damage = 0;
                ++npc.act_wait;
                if (npc.shock == '\u0000') break;
                npc.act_no = 40;
                npc.act_wait = 0;
                break;
            }
            case 40: {
                npc.bits = (char)(npc.bits | 8);
                npc.y += 512;
                if (++npc.act_wait != 32) break;
                npc.bits = (char)(npc.bits & 0xFFFFFFFE);
                npc.bits = (char)(npc.bits & 0xFFFFFFDF);
                npc.act_no = 50;
                npc.act_wait = 0;
                break;
            }
            case 50: {
                if (npc.act_wait < 100) {
                    ++npc.act_wait;
                    break;
                }
                npc.y = npc.tgt_y;
                npc.ani_no = 0;
                npc.act_no = 0;
            }
        }
        npc.rect.copyFrom(ActNpc215_rect[npc.ani_no]);
    }

    public static void ActNpc216(NpChar.NPCHAR npc) {
        npc.rect.copyFrom(ActNpc216_rect);
    }

    public static void ActNpc217(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
                npc.ani_no = 0;
                npc.ani_wait = 0;
                npc.xm = 0;
            }
            case 1: {
                if (Game.Random(0, 120) != 10) break;
                npc.act_no = 2;
                npc.act_wait = 0;
                npc.ani_no = 1;
                break;
            }
            case 2: {
                if (++npc.act_wait <= 8) break;
                npc.act_no = 1;
                npc.ani_no = 0;
                break;
            }
            case 10: {
                npc.ani_no = 2;
                npc.xm = 0;
                break;
            }
            case 20: {
                npc.act_no = 21;
                npc.ani_no = 2;
                npc.xm += 512;
                npc.ym -= 1024;
                break;
            }
            case 21: {
                if ((npc.flag & 8) == 0) break;
                npc.ani_no = 3;
                npc.act_no = 30;
                npc.act_wait = 0;
                npc.xm = 0;
                npc.tgt_x = npc.x;
                break;
            }
            case 30: {
                npc.ani_no = 3;
                if (++npc.act_wait / 2 % 2 != 0) {
                    npc.x = npc.tgt_x + 512;
                    break;
                }
                npc.x = npc.tgt_x;
                break;
            }
            case 40: {
                npc.act_no = 41;
                npc.ym = -512;
                npc.ani_no = 2;
            }
            case 41: {
                if ((npc.flag & 8) == 0) break;
                npc.act_no = 42;
                npc.ani_no = 4;
                break;
            }
            case 42: {
                npc.xm = 0;
                npc.ani_no = 4;
                break;
            }
            case 50: {
                npc.act_no = 51;
                npc.act_wait = 0;
            }
            case 51: {
                if (++npc.act_wait > 32) {
                    npc.act_no = 42;
                }
                npc.xm = 512;
                if (++npc.ani_wait > 3) {
                    npc.ani_wait = 0;
                    ++npc.ani_no;
                }
                if (npc.ani_no <= 7) break;
                npc.ani_no = 4;
            }
        }
        npc.ym += 64;
        if (npc.ym > 1535) {
            npc.ym = 1535;
        }
        npc.x += npc.xm;
        npc.y += npc.ym;
        npc.rect.copyFrom(ActNpc217_rect[npc.ani_no]);
    }

    public static void ActNpc218(NpChar.NPCHAR npc) {
        npc.x += npc.xm;
        npc.y += npc.ym;
        if (++npc.act_wait > 200) {
            npc.cond = 0;
        }
        if (++npc.ani_wait > 2) {
            npc.ani_wait = 0;
            ++npc.ani_no;
        }
        if (npc.ani_no > 1) {
            npc.ani_no = 0;
        }
        npc.rect.copyFrom(ActNpc218_rc[npc.ani_no]);
    }

    public static void ActNpc219(NpChar.NPCHAR npc) {
        if (npc.direct == 0) {
            if (Game.Random(0, 40) == 1) {
                NpChar.SetNpChar(4, npc.x + Game.Random(-20, 20) * 512, npc.y, 0, -512, 0, null, 256);
            }
        } else {
            NpChar.SetNpChar(199, npc.x + Game.Random(-160, 160) * 512, npc.y + Game.Random(-128, 128) * 512, 0, 0, 2, null, 256);
        }
        npc.rect.copyFrom(ActNpc219_rc);
    }
}
