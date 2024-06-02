/*
 * Decompiled with CFR 0.152.
 */
package jp.studiopixel.doukutsu;

import jp.studiopixel.doukutsu.Bullet;
import jp.studiopixel.doukutsu.Caret;
import jp.studiopixel.doukutsu.Flash;
import jp.studiopixel.doukutsu.Frame;
import jp.studiopixel.doukutsu.Game;
import jp.studiopixel.doukutsu.MyChar;
import jp.studiopixel.doukutsu.NpChar;
import jp.studiopixel.doukutsu.RECT;
import jp.studiopixel.doukutsu.Sound;
import jp.studiopixel.doukutsu.Triangle;

public class NpcAct140 {
    private static final RECT[] ActNpc140_rcLeft = new RECT[]{new RECT(0, 0, 32, 32), new RECT(32, 0, 64, 32), new RECT(64, 0, 96, 32), new RECT(96, 0, 128, 32), new RECT(128, 0, 160, 32), new RECT(160, 0, 192, 32), new RECT(192, 0, 224, 32), new RECT(224, 0, 256, 32), new RECT(0, 64, 32, 96), new RECT(32, 64, 64, 96), new RECT(64, 64, 96, 96), new RECT(96, 64, 128, 96), new RECT(128, 64, 160, 96), new RECT(0, 0, 0, 0)};
    private static final RECT[] ActNpc140_rcRight = new RECT[]{new RECT(0, 32, 32, 64), new RECT(32, 32, 64, 64), new RECT(64, 32, 96, 64), new RECT(96, 32, 128, 64), new RECT(128, 32, 160, 64), new RECT(160, 32, 192, 64), new RECT(192, 32, 224, 64), new RECT(224, 32, 256, 64), new RECT(0, 96, 32, 128), new RECT(32, 96, 64, 128), new RECT(64, 96, 96, 128), new RECT(96, 96, 128, 128), new RECT(128, 96, 160, 128), new RECT(0, 0, 0, 0)};
    private static final RECT[] ActNpc141_rect = new RECT[]{new RECT(288, 32, 304, 48), new RECT(304, 32, 320, 48)};
    private static final RECT[] ActNpc142_rect = new RECT[]{new RECT(0, 128, 16, 144), new RECT(16, 128, 32, 144), new RECT(32, 128, 48, 144), new RECT(48, 128, 64, 144), new RECT(64, 128, 80, 144)};
    private static final RECT[] ActNpc143_rcLeft = new RECT[]{new RECT(208, 32, 224, 48)};
    private static final RECT[] ActNpc143_rcRight = new RECT[]{new RECT(208, 48, 224, 64)};
    private static final RECT[] ActNpc144_rcLeft = new RECT[]{new RECT(0, 64, 16, 80), new RECT(16, 64, 32, 80), new RECT(32, 64, 48, 80), new RECT(16, 64, 32, 80), new RECT(128, 64, 144, 80)};
    private static final RECT[] ActNpc144_rcRight = new RECT[]{new RECT(0, 80, 16, 96), new RECT(16, 80, 32, 96), new RECT(32, 80, 48, 96), new RECT(16, 80, 32, 96), new RECT(128, 80, 144, 96)};
    private static final RECT[] ActNpc145_rcLeft = new RECT[]{new RECT(96, 32, 112, 48)};
    private static final RECT[] ActNpc145_rcRight = new RECT[]{new RECT(112, 32, 128, 48)};
    private static final RECT[] ActNpc146_rect = new RECT[]{new RECT(0, 0, 0, 0), new RECT(256, 0, 272, 240), new RECT(272, 0, 288, 240), new RECT(288, 0, 304, 240), new RECT(304, 0, 320, 240)};
    private static final RECT[] ActNpc147_rcLeft = new RECT[]{new RECT(0, 96, 16, 112), new RECT(16, 96, 32, 112), new RECT(32, 96, 48, 112), new RECT(48, 96, 64, 112), new RECT(64, 96, 80, 112), new RECT(80, 96, 96, 112)};
    private static final RECT[] ActNpc147_rcRight = new RECT[]{new RECT(0, 112, 16, 128), new RECT(16, 112, 32, 128), new RECT(32, 112, 48, 128), new RECT(48, 112, 64, 128), new RECT(64, 112, 80, 128), new RECT(80, 112, 96, 128)};
    private static final RECT[] ActNpc148_rect_left = new RECT[]{new RECT(96, 96, 104, 104), new RECT(104, 96, 112, 104)};
    private static final RECT ActNpc149_rect = new RECT(16, 0, 48, 32);
    private static final RECT[] ActNpc150_rcLeft = new RECT[]{new RECT(0, 0, 16, 16), new RECT(48, 0, 64, 16), new RECT(144, 0, 160, 16), new RECT(16, 0, 32, 16), new RECT(0, 0, 16, 16), new RECT(32, 0, 48, 16), new RECT(0, 0, 16, 16), new RECT(160, 0, 176, 16), new RECT(112, 0, 128, 16)};
    private static final RECT[] ActNpc150_rcRight = new RECT[]{new RECT(0, 16, 16, 32), new RECT(48, 16, 64, 32), new RECT(144, 16, 160, 32), new RECT(16, 16, 32, 32), new RECT(0, 16, 16, 32), new RECT(32, 16, 48, 32), new RECT(0, 16, 16, 32), new RECT(160, 16, 176, 32), new RECT(112, 16, 128, 32)};
    private static final RECT[] ActNpc151_rcLeft = new RECT[]{new RECT(192, 0, 208, 16), new RECT(208, 0, 224, 16)};
    private static final RECT[] ActNpc151_rcRight = new RECT[]{new RECT(192, 16, 208, 32), new RECT(208, 16, 224, 32)};
    private static final RECT ActNpc152_rc = new RECT(0, 0, 0, 0);
    private static final RECT[] grcKitL = new RECT[]{new RECT(0, 0, 24, 24), new RECT(24, 0, 48, 24), new RECT(48, 0, 72, 24), new RECT(0, 0, 24, 24), new RECT(72, 0, 96, 24), new RECT(0, 0, 24, 24), new RECT(96, 0, 120, 24), new RECT(120, 0, 144, 24), new RECT(144, 0, 168, 24), new RECT(168, 0, 192, 24), new RECT(192, 0, 216, 24), new RECT(216, 0, 240, 24), new RECT(240, 0, 264, 24), new RECT(264, 0, 288, 24), new RECT(0, 48, 24, 72), new RECT(24, 48, 48, 72), new RECT(48, 48, 72, 72), new RECT(72, 48, 96, 72), new RECT(288, 0, 312, 24), new RECT(24, 48, 48, 72), new RECT(96, 48, 120, 72)};
    private static final RECT[] grcKitR = new RECT[]{new RECT(0, 24, 24, 48), new RECT(24, 24, 48, 48), new RECT(48, 24, 72, 48), new RECT(0, 24, 24, 48), new RECT(72, 24, 96, 48), new RECT(0, 24, 24, 48), new RECT(96, 24, 120, 48), new RECT(120, 24, 144, 48), new RECT(144, 24, 168, 48), new RECT(168, 24, 192, 48), new RECT(192, 24, 216, 48), new RECT(216, 24, 240, 48), new RECT(240, 24, 264, 48), new RECT(264, 24, 288, 48), new RECT(0, 72, 24, 96), new RECT(24, 72, 48, 96), new RECT(48, 72, 72, 96), new RECT(72, 72, 96, 96), new RECT(288, 24, 312, 48), new RECT(24, 72, 48, 96), new RECT(96, 72, 120, 96)};
    private static final RECT[] ActNpc156_rect_left = new RECT[]{new RECT(96, 112, 112, 128), new RECT(112, 112, 128, 128), new RECT(128, 112, 144, 128)};
    private static final RECT ActNpc157_rect = new RECT(16, 0, 48, 32);
    private static final RECT[] ActNpc158_rect = new RECT[]{new RECT(0, 224, 16, 240), new RECT(16, 224, 32, 240), new RECT(32, 224, 48, 240), new RECT(48, 224, 64, 240), new RECT(64, 224, 80, 240), new RECT(80, 224, 96, 240), new RECT(96, 224, 112, 240), new RECT(112, 224, 128, 240)};
    private static final RECT ActNpc159_rect = new RECT(144, 128, 192, 200);

    public static void ActNpc140(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
                npc.ani_no = 9;
                npc.act_wait = 0;
                npc.bits = (char)(npc.bits & 0xFFFFDFFF);
            }
            case 1: {
                if (++npc.act_wait <= 50) break;
                npc.act_no = 2;
                npc.act_wait = 0;
                npc.ani_no = 8;
                break;
            }
            case 2: {
                if (++npc.ani_no > 10) {
                    npc.ani_no = 9;
                }
                if (++npc.act_wait <= 50) break;
                npc.act_no = 3;
                npc.act_wait = 0;
                npc.ani_no = 0;
                break;
            }
            case 3: {
                if (++npc.act_wait <= 50) break;
                npc.act_no = 10;
                npc.bits = (char)(npc.bits | 0x20);
                break;
            }
            case 10: {
                npc.act_no = 11;
                npc.ani_no = 0;
                npc.ani_wait = 0;
                npc.act_wait = Game.Random(20, 130);
                npc.xm = 0;
            }
            case 11: {
                npc.direct = npc.x > MyChar.gMC.x ? 0 : 2;
                if (++npc.ani_wait > 4) {
                    npc.ani_wait = 0;
                    ++npc.ani_no;
                }
                if (npc.ani_no > 1) {
                    npc.ani_no = 0;
                }
                if (Bullet.CountArmsBullet(6) != 0 || Bullet.CountArmsBullet(3) > 3) {
                    npc.act_no = 20;
                }
                if (npc.act_wait != 0) {
                    --npc.act_wait;
                    break;
                }
                if (Game.Random(0, 99) % 2 != 0) {
                    npc.act_no = 20;
                    break;
                }
                npc.act_no = 50;
                break;
            }
            case 20: {
                npc.act_no = 21;
                npc.ani_no = 2;
                npc.act_wait = 0;
            }
            case 21: {
                if (++npc.act_wait <= 10) break;
                npc.act_no = 22;
                npc.act_wait = 0;
                npc.ani_no = 3;
                npc.ym = -1535;
                if (npc.direct == 0) {
                    npc.xm = -512;
                    break;
                }
                npc.xm = 512;
                break;
            }
            case 22: {
                if (++npc.act_wait <= 10) break;
                npc.act_no = 23;
                npc.act_wait = 0;
                npc.ani_no = 6;
                NpChar.SetNpChar(141, 0, 0, 0, 0, 0, npc, 0);
                break;
            }
            case 23: {
                if (++npc.act_wait > 30) {
                    npc.act_no = 24;
                    npc.act_wait = 0;
                    npc.ani_no = 7;
                }
                if (npc.x > MyChar.gMC.x) {
                    npc.direct = 0;
                    break;
                }
                npc.direct = 2;
                break;
            }
            case 24: {
                if (++npc.act_wait <= 3) break;
                npc.act_no = 25;
                npc.ani_no = 3;
                break;
            }
            case 25: {
                if ((npc.flag & 8) == 0) break;
                npc.act_no = 26;
                npc.act_wait = 0;
                npc.ani_no = 2;
                Sound.PlaySoundObject(26, 1);
                Frame.SetQuake(20);
                break;
            }
            case 26: {
                npc.xm = npc.xm * 8 / 9;
                if (++npc.act_wait <= 20) break;
                npc.act_no = 10;
                npc.ani_no = 0;
                break;
            }
            case 50: {
                npc.act_no = 51;
                npc.act_wait = 0;
                npc.ani_no = 4;
                NpChar.SetNpChar(141, 0, 0, 0, 0, 0, npc, 0);
            }
            case 51: {
                if (++npc.act_wait > 30) {
                    npc.act_no = 52;
                    npc.act_wait = 0;
                    npc.ani_no = 5;
                }
                if (npc.x > MyChar.gMC.x) {
                    npc.direct = 0;
                    break;
                }
                npc.direct = 2;
                break;
            }
            case 52: {
                if (++npc.act_wait <= 3) break;
                npc.act_no = 10;
                npc.ani_no = 0;
                break;
            }
            case 100: {
                npc.ani_no = 3;
                npc.act_no = 101;
                npc.bits = (char)(npc.bits & 0xFFFFFFDF);
                npc.damage = 0;
                for (int i = 0; i < 8; ++i) {
                    NpChar.SetNpChar(4, npc.x + Game.Random(-12, 12) * 512, npc.y + Game.Random(-12, 12) * 512, Game.Random(-341, 341), Game.Random(-1536, 0), 0, null, 256);
                }
                break;
            }
            case 101: {
                if ((npc.flag & 8) == 0) break;
                npc.act_no = 102;
                npc.act_wait = 0;
                npc.ani_no = 2;
                Sound.PlaySoundObject(26, 1);
                Frame.SetQuake(20);
                break;
            }
            case 102: {
                npc.xm = npc.xm * 8 / 9;
                if (++npc.act_wait <= 50) break;
                npc.act_no = 103;
                npc.act_wait = 0;
                npc.ani_no = 10;
                break;
            }
            case 103: {
                if (++npc.act_wait <= 50) break;
                npc.ani_no = 9;
                npc.act_no = 104;
                npc.act_wait = 0;
                break;
            }
            case 104: {
                if (++npc.ani_no > 10) {
                    npc.ani_no = 9;
                }
                if (++npc.act_wait <= 100) break;
                npc.act_wait = 0;
                npc.ani_no = 9;
                npc.act_no = 105;
                break;
            }
            case 105: {
                if (++npc.act_wait <= 50) break;
                npc.ani_wait = 0;
                npc.act_no = 106;
                npc.ani_no = 11;
                break;
            }
            case 106: {
                if (++npc.ani_wait > 50) {
                    npc.ani_wait = 0;
                    ++npc.ani_no;
                }
                if (npc.ani_no <= 12) break;
                npc.ani_no = 12;
                break;
            }
            case 140: {
                npc.act_no = 141;
                npc.act_wait = 0;
                npc.ani_no = 12;
                Sound.PlaySoundObject(29, 1);
            }
            case 141: {
                if (++npc.ani_no > 13) {
                    npc.ani_no = 12;
                }
                if (++npc.act_wait <= 100) break;
                for (int i = 0; i < 4; ++i) {
                    NpChar.SetNpChar(4, npc.x + Game.Random(-12, 12) * 512, npc.y + Game.Random(-12, 12) * 512, Game.Random(-341, 341), Game.Random(-1536, 0), 0, null, 256);
                }
                npc.cond = 0;
            }
        }
        if (npc.act_no > 100 && npc.act_no < 105 && npc.act_wait % 9 == 0) {
            NpChar.SetNpChar(4, npc.x + Game.Random(-12, 12) * 512, npc.y + Game.Random(-12, 12) * 512, Game.Random(-341, 341), Game.Random(-1536, 0), 0, null, 256);
        }
        npc.ym += 32;
        if (npc.ym > 1535) {
            npc.ym = 1535;
        }
        if (npc.ym < -1535) {
            npc.ym = -1535;
        }
        npc.x += npc.xm;
        npc.y += npc.ym;
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc140_rcLeft[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc140_rcRight[npc.ani_no]);
        }
    }

    public static void ActNpc141(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
                npc.act_wait = 0;
            }
            case 1: {
                npc.x = npc.pNpc.direct == 0 ? npc.pNpc.x + 5120 : npc.pNpc.x - 5120;
                npc.y = npc.pNpc.y - 4096;
                if (npc.pNpc.act_no != 24 && npc.pNpc.act_no != 52) break;
                npc.act_no = 10;
                npc.x = npc.pNpc.direct == 0 ? npc.pNpc.x - 8192 : npc.pNpc.x + 8192;
                npc.y = npc.pNpc.y;
                char deg = (char)Triangle.GetArktan(npc.x - MyChar.gMC.x, npc.y - MyChar.gMC.y);
                npc.ym = Triangle.GetSin(deg) * 4;
                npc.xm = Triangle.GetCos(deg) * 4;
                Sound.PlaySoundObject(39, 1);
                break;
            }
            case 10: {
                if ((npc.flag & 0xF) != 0) {
                    npc.act_no = 20;
                    npc.act_wait = 0;
                    Caret.SetCaret(npc.x, npc.y, 2, 0);
                    Sound.PlaySoundObject(12, 1);
                    for (int i = 0; i < 4; ++i) {
                        NpChar.SetNpChar(4, npc.x, npc.y, Game.Random(-512, 512), Game.Random(-512, 512), 0, null, 256);
                    }
                    break;
                }
                npc.x += npc.xm;
                npc.y += npc.ym;
                break;
            }
            case 20: {
                npc.x += npc.xm;
                npc.y += npc.ym;
                if (++npc.act_wait <= 4) break;
                for (int i = 0; i < 4; ++i) {
                    NpChar.SetNpChar(4, npc.x, npc.y, Game.Random(-512, 512), Game.Random(-512, 512), 0, null, 256);
                }
                npc.code_char = 142;
                npc.ani_no = 0;
                npc.act_no = 20;
                npc.xm = 0;
                npc.bits = (char)(npc.bits & 0xFFFFFFFB);
                npc.bits = (char)(npc.bits | 0x20);
                npc.damage = 1;
            }
        }
        if (++npc.ani_no > 1) {
            npc.ani_no = 0;
        }
        npc.rect.copyFrom(ActNpc141_rect[npc.ani_no]);
    }

    public static void ActNpc142(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 10: {
                npc.act_no = 11;
                npc.ani_no = 0;
                npc.act_wait = 0;
            }
            case 11: {
                if (++npc.act_wait <= 30) break;
                npc.act_no = 12;
                npc.ani_no = 1;
                npc.ani_wait = 0;
                break;
            }
            case 12: {
                if (++npc.ani_wait > 8) {
                    npc.ani_wait = 0;
                    ++npc.ani_no;
                }
                if (npc.ani_no != 3) break;
                npc.act_no = 20;
                npc.ym = -512;
                if (MyChar.gMC.x < npc.x) {
                    npc.xm = -512;
                    break;
                }
                npc.xm = 512;
                break;
            }
            case 20: {
                npc.ani_no = npc.ym > -128 ? 4 : 3;
                if ((npc.flag & 8) == 0) break;
                npc.ani_no = 2;
                npc.act_no = 21;
                npc.act_wait = 0;
                npc.xm = 0;
                Sound.PlaySoundObject(23, 1);
                break;
            }
            case 21: {
                if (++npc.act_wait <= 10) break;
                npc.act_no = 10;
                npc.ani_no = 0;
            }
        }
        npc.ym += 64;
        if (npc.ym > 1535) {
            npc.ym = 1535;
        }
        if (npc.ym < -1535) {
            npc.ym = -1535;
        }
        npc.x += npc.xm;
        npc.y += npc.ym;
        npc.rect.copyFrom(ActNpc142_rect[npc.ani_no]);
    }

    public static void ActNpc143(NpChar.NPCHAR npc) {
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc143_rcLeft[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc143_rcRight[npc.ani_no]);
        }
    }

    public static void ActNpc144(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
                npc.ani_no = 0;
                npc.ani_wait = 0;
                npc.tgt_x = npc.x;
                Sound.PlaySoundObject(29, 1);
            }
            case 1: {
                if (++npc.act_wait != 64) break;
                npc.act_no = 2;
                npc.act_wait = 0;
                break;
            }
            case 2: {
                if (++npc.ani_wait > 2) {
                    npc.ani_wait = 0;
                    ++npc.ani_no;
                }
                if (npc.ani_no > 3) {
                    npc.ani_no = 2;
                }
                if ((npc.flag & 8) == 0) break;
                npc.act_no = 4;
                npc.act_wait = 0;
                npc.ani_no = 4;
                Sound.PlaySoundObject(23, 1);
                break;
            }
            case 10: {
                npc.act_no = 11;
                npc.ani_no = 0;
                npc.ani_wait = 0;
            }
            case 11: {
                if (Game.Random(0, 120) != 10) break;
                npc.act_no = 12;
                npc.act_wait = 0;
                npc.ani_no = 1;
                break;
            }
            case 12: {
                if (++npc.act_wait <= 8) break;
                npc.act_no = 11;
                npc.ani_no = 0;
            }
        }
        if (npc.act_no > 1) {
            npc.ym += 32;
            if (npc.ym > 1535) {
                npc.ym = 1535;
            }
            npc.y += npc.ym;
        }
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc144_rcLeft[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc144_rcRight[npc.ani_no]);
        }
        if (npc.act_no == 1) {
            npc.rect.bottom = npc.rect.top + npc.act_wait / 4;
            npc.x = npc.act_wait / 2 % 2 != 0 ? npc.tgt_x : npc.tgt_x + 512;
        }
    }

    public static void ActNpc145(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.direct = npc.pNpc.count2 == 0 ? (npc.pNpc.direct == 0 ? 0 : 2) : (npc.pNpc.direct == 0 ? 2 : 0);
                npc.x = npc.direct == 0 ? npc.pNpc.x - 5120 : npc.pNpc.x + 5120;
                npc.y = npc.pNpc.y;
            }
        }
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc145_rcLeft[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc145_rcRight[npc.ani_no]);
        }
    }

    public static void ActNpc146(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
                if (npc.direct == 2) {
                    Flash.SetFlash(0, 0, 2);
                }
            }
            case 1: {
                if (++npc.act_wait <= 10) break;
                npc.act_no = 2;
                Sound.PlaySoundObject(101, 1);
                break;
            }
            case 2: {
                if (++npc.ani_wait > 2) {
                    npc.ani_wait = 0;
                    ++npc.ani_no;
                }
                if (npc.ani_no == 2) {
                    npc.damage = 10;
                }
                if (npc.ani_no <= 4) break;
                NpChar.SetDestroyNpChar(npc.x, npc.y, 4096, 8);
                npc.cond = 0;
                return;
            }
        }
        npc.rect.copyFrom(ActNpc146_rect[npc.ani_no]);
    }

    public static void ActNpc147(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.y += 1536;
                npc.act_no = 1;
            }
            case 1: {
                if (npc.act_wait >= 8 && npc.x - 49152 < MyChar.gMC.x && npc.x + 49152 > MyChar.gMC.x && npc.y - 49152 < MyChar.gMC.y && npc.y + 16384 > MyChar.gMC.y) {
                    npc.direct = npc.x > MyChar.gMC.x ? 0 : 2;
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
                if (npc.act_wait < 8 || npc.x - 24576 >= MyChar.gMC.x || npc.x + 24576 <= MyChar.gMC.x || npc.y - 49152 >= MyChar.gMC.y || npc.y + 16384 <= MyChar.gMC.y) break;
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
                Sound.PlaySoundObject(30, 1);
                if (npc.x > MyChar.gMC.x) {
                    npc.direct = 0;
                    break;
                }
                npc.direct = 2;
                break;
            }
            case 3: {
                if (npc.ym <= 256) break;
                npc.tgt_y = npc.y;
                npc.act_no = 4;
                npc.ani_no = 3;
                npc.act_wait = 0;
                break;
            }
            case 4: {
                npc.direct = npc.x < MyChar.gMC.x ? 2 : 0;
                ++npc.act_wait;
                if ((npc.flag & 7) != 0 || npc.act_wait > 60) {
                    npc.damage = 3;
                    npc.act_no = 5;
                    npc.ani_no = 2;
                    break;
                }
                if (npc.act_wait % 4 == 1) {
                    Sound.PlaySoundObject(109, 1);
                }
                if ((npc.flag & 8) != 0) {
                    npc.ym = -512;
                }
                if (npc.act_wait % 30 == 6) {
                    char deg = (char)Triangle.GetArktan(npc.x - MyChar.gMC.x, npc.y - MyChar.gMC.y);
                    deg = (char)(deg + (char)Game.Random(-6, 6) & 0xFF);
                    int ym = Triangle.GetSin(deg) * 3;
                    int xm = Triangle.GetCos(deg) * 3;
                    NpChar.SetNpChar(148, npc.x, npc.y, xm, ym, 0, null, 256);
                    Sound.PlaySoundObject(39, 1);
                }
                if (++npc.ani_wait > 0) {
                    npc.ani_wait = 0;
                    ++npc.ani_no;
                }
                if (npc.ani_no <= 5) break;
                npc.ani_no = 3;
                break;
            }
            case 5: {
                if ((npc.flag & 8) == 0) break;
                npc.damage = 2;
                npc.xm = 0;
                npc.act_wait = 0;
                npc.ani_no = 0;
                npc.act_no = 1;
                Sound.PlaySoundObject(23, 1);
            }
        }
        if (npc.act_no != 4) {
            npc.ym += 32;
            if (npc.ym > 1535) {
                npc.ym = 1535;
            }
        } else {
            npc.ym = npc.y > npc.tgt_y ? (npc.ym -= 16) : (npc.ym += 16);
            if (npc.ym > 512) {
                npc.ym = 512;
            }
            if (npc.ym < -512) {
                npc.ym = -512;
            }
            if (npc.xm > 512) {
                npc.xm = 512;
            }
            if (npc.xm < -512) {
                npc.xm = -512;
            }
        }
        npc.x += npc.xm;
        npc.y += npc.ym;
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc147_rcLeft[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc147_rcRight[npc.ani_no]);
        }
    }

    public static void ActNpc148(NpChar.NPCHAR npc) {
        if ((npc.flag & 0xFF) != 0) {
            Caret.SetCaret(npc.x, npc.y, 2, 0);
            npc.cond = 0;
        }
        npc.y += npc.ym;
        npc.x += npc.xm;
        if (++npc.ani_no > 1) {
            npc.ani_no = 0;
        }
        npc.rect.copyFrom(ActNpc148_rect_left[npc.ani_no]);
        if (++npc.count1 > 300) {
            Caret.SetCaret(npc.x, npc.y, 2, 0);
            npc.cond = 0;
        }
    }

    public static void ActNpc149(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.x += 4096;
                npc.y += 4096;
                npc.act_no = npc.direct == 0 ? 10 : 20;
                npc.xm = 0;
                npc.ym = 0;
                npc.bits = (char)(npc.bits | 0x40);
                break;
            }
            case 10: {
                npc.bits = (char)(npc.bits & 0xFFFFFF7F);
                npc.damage = 0;
                if (MyChar.gMC.x >= npc.x + 12800 || MyChar.gMC.x <= npc.x - 204800 || MyChar.gMC.y >= npc.y + 12800 || MyChar.gMC.y <= npc.y - 12800) break;
                npc.act_no = 11;
                npc.act_wait = 0;
                break;
            }
            case 11: {
                if (++npc.act_wait % 10 == 6) {
                    Sound.PlaySoundObject(107, 1);
                }
                if ((npc.flag & 1) != 0) {
                    npc.xm = 0;
                    npc.direct = 2;
                    npc.act_no = 20;
                    Frame.SetQuake(10);
                    Sound.PlaySoundObject(26, 1);
                    for (int i = 0; i < 4; ++i) {
                        NpChar.SetNpChar(4, npc.x - 8192, npc.y + Game.Random(-12, 12) * 512, Game.Random(-341, 341), Game.Random(-1536, 0), 0, null, 256);
                    }
                    break;
                }
                if ((MyChar.gMC.flag & 1) != 0) {
                    npc.bits = (char)(npc.bits | 0x80);
                    npc.damage = 100;
                } else {
                    npc.bits = (char)(npc.bits & 0xFFFFFF7F);
                    npc.damage = 0;
                }
                npc.xm -= 32;
                break;
            }
            case 20: {
                npc.bits = (char)(npc.bits & 0xFFFFFF7F);
                npc.damage = 0;
                if (MyChar.gMC.x <= npc.x - 12800 || MyChar.gMC.x >= npc.x + 204800 || MyChar.gMC.y >= npc.y + 12800 || MyChar.gMC.y <= npc.y - 12800) break;
                npc.act_no = 21;
                npc.act_wait = 0;
                break;
            }
            case 21: {
                if (++npc.act_wait % 10 == 6) {
                    Sound.PlaySoundObject(107, 1);
                }
                if ((npc.flag & 4) != 0) {
                    npc.xm = 0;
                    npc.direct = 0;
                    npc.act_no = 10;
                    Frame.SetQuake(10);
                    Sound.PlaySoundObject(26, 1);
                    for (int i = 0; i < 4; ++i) {
                        NpChar.SetNpChar(4, npc.x + 8192, npc.y + Game.Random(-12, 12) * 512, Game.Random(-341, 341), Game.Random(-1536, 0), 0, null, 256);
                    }
                    break;
                }
                if ((MyChar.gMC.flag & 4) != 0) {
                    npc.bits = (char)(npc.bits | 0x80);
                    npc.damage = 100;
                } else {
                    npc.bits = (char)(npc.bits & 0xFFFFFF7F);
                    npc.damage = 0;
                }
                npc.xm += 32;
            }
        }
        if (npc.xm > 512) {
            npc.xm = 512;
        }
        if (npc.xm < -512) {
            npc.xm = -512;
        }
        npc.x += npc.xm;
        npc.rect.copyFrom(ActNpc149_rect);
    }

    public static void ActNpc150(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
                npc.ani_no = 0;
                if (npc.direct <= 10) break;
                npc.x = MyChar.gMC.x;
                npc.y = MyChar.gMC.y;
                npc.direct -= 10;
                break;
            }
            case 2: {
                npc.ani_no = 1;
                break;
            }
            case 10: {
                npc.act_no = 11;
                for (int i = 0; i < 4; ++i) {
                    NpChar.SetNpChar(4, npc.x, npc.y, Game.Random(-341, 341), Game.Random(-1536, 0), 0, null, 256);
                }
                Sound.PlaySoundObject(71, 1);
            }
            case 11: {
                npc.ani_no = 2;
                break;
            }
            case 20: {
                npc.act_no = 21;
                npc.act_wait = 64;
                Sound.PlaySoundObject(29, 1);
            }
            case 21: {
                if (--npc.act_wait != 0) break;
                npc.cond = 0;
                break;
            }
            case 50: {
                npc.act_no = 51;
                npc.ani_no = 3;
                npc.ani_wait = 0;
            }
            case 51: {
                if (++npc.ani_wait > 4) {
                    npc.ani_wait = 0;
                    ++npc.ani_no;
                }
                if (npc.ani_no > 6) {
                    npc.ani_no = 3;
                }
                if (npc.direct == 0) {
                    npc.x -= 512;
                    break;
                }
                npc.x += 512;
                break;
            }
            case 60: {
                npc.act_no = 61;
                npc.ani_no = 7;
                npc.tgt_x = npc.x;
                npc.tgt_y = npc.y;
            }
            case 61: {
                npc.tgt_y += 256;
                npc.x = npc.tgt_x + Game.Random(-1, 1) * 512;
                npc.y = npc.tgt_y + Game.Random(-1, 1) * 512;
                break;
            }
            case 70: {
                npc.act_no = 71;
                npc.act_wait = 0;
                npc.ani_no = 3;
                npc.ani_wait = 0;
            }
            case 71: {
                npc.x = npc.direct == 0 ? (npc.x += 256) : (npc.x -= 256);
                if (++npc.ani_wait > 8) {
                    npc.ani_wait = 0;
                    ++npc.ani_no;
                }
                if (npc.ani_no <= 6) break;
                npc.ani_no = 3;
                break;
            }
            case 80: {
                npc.ani_no = 8;
                break;
            }
            case 99: 
            case 100: {
                npc.act_no = 101;
                npc.ani_no = 3;
                npc.ani_wait = 0;
            }
            case 101: {
                npc.ym += 64;
                if (npc.ym > 1535) {
                    npc.ym = 1535;
                }
                if ((npc.flag & 8) != 0) {
                    npc.ym = 0;
                    npc.act_no = 102;
                }
                npc.y += npc.ym;
                break;
            }
            case 102: {
                if (++npc.ani_wait > 8) {
                    npc.ani_wait = 0;
                    ++npc.ani_no;
                }
                if (npc.ani_no <= 6) break;
                npc.ani_no = 3;
            }
        }
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc150_rcLeft[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc150_rcRight[npc.ani_no]);
        }
        if (npc.act_no == 21) {
            npc.rect.bottom = npc.rect.top + npc.act_wait / 4;
            if (npc.act_wait / 2 % 2 != 0) {
                ++npc.rect.left;
            }
        }
        if ((MyChar.gMC.equip & 0x40) != 0) {
            npc.rect.top += 32;
            npc.rect.bottom += 32;
        }
    }

    public static void ActNpc151(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
                npc.ani_no = 0;
                npc.ani_wait = 0;
            }
            case 1: {
                if (Game.Random(0, 100) != 0) break;
                npc.act_no = 2;
                npc.act_wait = 0;
                npc.ani_no = 1;
                break;
            }
            case 2: {
                if (++npc.act_wait <= 16) break;
                npc.act_no = 1;
                npc.ani_no = 0;
            }
        }
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc151_rcLeft[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc151_rcRight[npc.ani_no]);
        }
    }

    public static void ActNpc152(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                if (npc.direct == 2) {
                    npc.y += 8192;
                }
                npc.act_no = 1;
            }
        }
        npc.rect.copyFrom(ActNpc152_rc);
    }

    public static void ActNpc153(NpChar.NPCHAR npc) {
        if (npc.x > MyChar.gMC.x + 163840 || npc.x < MyChar.gMC.x - 163840 || npc.y > MyChar.gMC.y + 122880 || npc.y < MyChar.gMC.y - 122880) {
            return;
        }
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
                npc.xm = 0;
                npc.ani_no = 0;
                npc.y += 1536;
            }
            case 1: {
                if (Game.Random(0, 100) == 1) {
                    npc.act_no = 2;
                    npc.ani_no = 1;
                    npc.act_wait = 0;
                }
                if (Game.Random(0, 100) == 1) {
                    npc.direct = npc.direct == 0 ? 2 : 0;
                }
                if (Game.Random(0, 100) != 1) break;
                npc.act_no = 10;
                break;
            }
            case 2: {
                if (++npc.act_wait <= 20) break;
                npc.act_no = 1;
                npc.ani_no = 0;
                break;
            }
            case 10: {
                npc.act_no = 11;
                npc.act_wait = Game.Random(25, 100);
                npc.ani_no = 2;
                npc.ani_wait = 0;
            }
            case 11: {
                if (++npc.ani_wait > 3) {
                    npc.ani_wait = 0;
                    ++npc.ani_no;
                }
                if (npc.ani_no > 5) {
                    npc.ani_no = 2;
                }
                npc.xm = npc.direct == 0 ? -512 : 512;
                if (npc.act_wait != 0) {
                    --npc.act_wait;
                } else {
                    npc.act_no = 1;
                    npc.ani_no = 0;
                    npc.xm = 0;
                }
                if (npc.direct == 0 && (npc.flag & 1) != 0) {
                    npc.ani_no = 2;
                    npc.ym = -1535;
                    npc.act_no = 20;
                    if ((MyChar.gMC.cond & 2) != 0) break;
                    Sound.PlaySoundObject(30, 1);
                    break;
                }
                if (npc.direct != 2 || (npc.flag & 4) == 0) break;
                npc.ani_no = 2;
                npc.ym = -1535;
                npc.act_no = 20;
                if ((MyChar.gMC.cond & 2) != 0) break;
                Sound.PlaySoundObject(30, 1);
                break;
            }
            case 20: {
                npc.count1 = npc.direct == 0 && (npc.flag & 1) != 0 ? ++npc.count1 : (npc.direct == 2 && (npc.flag & 4) != 0 ? ++npc.count1 : 0);
                if (npc.count1 > 10) {
                    npc.direct = npc.direct == 0 ? 2 : 0;
                }
                npc.xm = npc.direct == 0 ? -256 : 256;
                if ((npc.flag & 8) == 0) break;
                npc.act_no = 21;
                npc.ani_no = 20;
                npc.act_wait = 0;
                npc.xm = 0;
                if ((MyChar.gMC.cond & 2) != 0) break;
                Sound.PlaySoundObject(23, 1);
                break;
            }
            case 21: {
                if (++npc.act_wait <= 10) break;
                npc.act_no = 1;
                npc.ani_no = 0;
            }
        }
        npc.ym += 64;
        if (npc.ym > 1535) {
            npc.ym = 1535;
        }
        npc.x += npc.xm;
        npc.y += npc.ym;
        if (npc.direct == 0) {
            npc.rect.copyFrom(grcKitL[npc.ani_no]);
        } else {
            npc.rect.copyFrom(grcKitR[npc.ani_no]);
        }
        if (npc.life <= 985) {
            npc.code_char = 154;
            npc.act_no = 0;
        }
    }

    public static void ActNpc154(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.bits = (char)(npc.bits & 0xFFFFFFDF);
                npc.bits = (char)(npc.bits & 0xFFFFFFF7);
                npc.damage = 0;
                npc.act_no = 1;
                npc.ani_no = 9;
                npc.ym = -512;
                npc.xm = npc.direct == 0 ? 256 : -256;
                Sound.PlaySoundObject(53, 1);
                break;
            }
            case 1: {
                if ((npc.flag & 8) == 0) break;
                npc.ani_no = 10;
                npc.ani_wait = 0;
                npc.act_no = 2;
                npc.act_wait = 0;
                break;
            }
            case 2: {
                npc.xm = npc.xm * 8 / 9;
                if (++npc.ani_wait > 3) {
                    npc.ani_wait = 0;
                    ++npc.ani_no;
                }
                if (npc.ani_no > 11) {
                    npc.ani_no = 10;
                }
                if (++npc.act_wait <= 50) break;
                npc.cond = (byte)(npc.cond | 8);
            }
        }
        npc.ym += 32;
        if (npc.ym > 1535) {
            npc.ym = 1535;
        }
        npc.x += npc.xm;
        npc.y += npc.ym;
        if (npc.direct == 0) {
            npc.rect.copyFrom(grcKitL[npc.ani_no]);
        } else {
            npc.rect.copyFrom(grcKitR[npc.ani_no]);
        }
    }

    public static void ActNpc155(NpChar.NPCHAR npc) {
        if (npc.x > MyChar.gMC.x + 163840 || npc.x < MyChar.gMC.x - 163840 || npc.y > MyChar.gMC.y + 122880 || npc.y < MyChar.gMC.y - 122880) {
            return;
        }
        switch (npc.act_no) {
            case 0: {
                char deg = (char)Game.Random(0, 255);
                npc.xm = Triangle.GetCos(deg);
                deg = (char)(deg + 64);
                npc.tgt_x = npc.x + Triangle.GetCos(deg) * 8;
                deg = (char)Game.Random(0, 255);
                npc.ym = Triangle.GetSin(deg);
                deg = (char)(deg + 64);
                npc.tgt_y = npc.y + Triangle.GetSin(deg) * 8;
                npc.act_no = 1;
                npc.count1 = 120;
                npc.act_wait = Game.Random(70, 150);
                npc.ani_no = 14;
            }
            case 1: {
                if (++npc.ani_no > 15) {
                    npc.ani_no = 14;
                }
                if (npc.act_wait != 0) {
                    --npc.act_wait;
                    break;
                }
                npc.act_no = 2;
                npc.ani_no = 18;
                break;
            }
            case 2: {
                if (++npc.ani_no > 19) {
                    npc.ani_no = 18;
                }
                if (++npc.act_wait <= 30) break;
                char deg = (char)Triangle.GetArktan(npc.x - MyChar.gMC.x, npc.y - MyChar.gMC.y);
                deg = (char)(deg + Game.Random(-6, 6) & 0xFF & 0xFF);
                int ym = Triangle.GetSin(deg) * 3;
                int xm = Triangle.GetCos(deg) * 3;
                NpChar.SetNpChar(156, npc.x, npc.y, xm, ym, 0, null, 256);
                if ((MyChar.gMC.cond & 2) == 0) {
                    Sound.PlaySoundObject(39, 1);
                }
                npc.act_no = 1;
                npc.act_wait = Game.Random(70, 150);
                npc.ani_no = 14;
                npc.ani_wait = 0;
            }
        }
        npc.direct = MyChar.gMC.x < npc.x ? 0 : 2;
        if (npc.tgt_x < npc.x) {
            npc.xm -= 16;
        }
        if (npc.tgt_x > npc.x) {
            npc.xm += 16;
        }
        if (npc.tgt_y < npc.y) {
            npc.ym -= 16;
        }
        if (npc.tgt_y > npc.y) {
            npc.ym += 16;
        }
        if (npc.xm > 512) {
            npc.xm = 512;
        }
        if (npc.xm < -512) {
            npc.xm = -512;
        }
        if (npc.ym > 512) {
            npc.ym = 512;
        }
        if (npc.ym < -512) {
            npc.ym = -512;
        }
        npc.x += npc.xm;
        npc.y += npc.ym;
        if (npc.direct == 0) {
            npc.rect.copyFrom(grcKitL[npc.ani_no]);
        } else {
            npc.rect.copyFrom(grcKitR[npc.ani_no]);
        }
        if (npc.life <= 985) {
            npc.code_char = 154;
            npc.act_no = 0;
        }
    }

    public static void ActNpc156(NpChar.NPCHAR npc) {
        if ((npc.flag & 0xFF) != 0) {
            Caret.SetCaret(npc.x, npc.y, 2, 0);
            npc.cond = 0;
        }
        npc.y += npc.ym;
        npc.x += npc.xm;
        if (++npc.ani_no > 2) {
            npc.ani_no = 0;
        }
        npc.rect.copyFrom(ActNpc156_rect_left[npc.ani_no]);
        if (++npc.count1 > 300) {
            Caret.SetCaret(npc.x, npc.y, 2, 0);
            npc.cond = 0;
        }
    }

    public static void ActNpc157(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.x += 4096;
                npc.y += 4096;
                npc.act_no = npc.direct == 0 ? 10 : 20;
                npc.xm = 0;
                npc.ym = 0;
                npc.bits = (char)(npc.bits | 0x40);
                break;
            }
            case 10: {
                npc.bits = (char)(npc.bits & 0xFFFFFF7F);
                npc.damage = 0;
                if (MyChar.gMC.y >= npc.y + 12800 || MyChar.gMC.y <= npc.y - 204800 || MyChar.gMC.x >= npc.x + 12800 || MyChar.gMC.x <= npc.x - 12800) break;
                npc.act_no = 11;
                npc.act_wait = 0;
                break;
            }
            case 11: {
                if (++npc.act_wait % 10 == 6) {
                    Sound.PlaySoundObject(107, 1);
                }
                if ((npc.flag & 2) != 0) {
                    npc.ym = 0;
                    npc.direct = 2;
                    npc.act_no = 20;
                    Frame.SetQuake(10);
                    Sound.PlaySoundObject(26, 1);
                    for (int i = 0; i < 4; ++i) {
                        NpChar.SetNpChar(4, npc.x + Game.Random(-12, 12) * 512, npc.y - 8192, Game.Random(-341, 341), Game.Random(-1536, 0), 0, null, 256);
                    }
                    break;
                }
                if ((MyChar.gMC.flag & 2) != 0) {
                    npc.bits = (char)(npc.bits | 0x80);
                    npc.damage = 100;
                } else {
                    npc.bits = (char)(npc.bits & 0xFFFFFF7F);
                    npc.damage = 0;
                }
                npc.ym -= 32;
                break;
            }
            case 20: {
                npc.bits = (char)(npc.bits & 0xFFFFFF7F);
                npc.damage = 0;
                if (MyChar.gMC.y <= npc.y - 12800 || MyChar.gMC.y >= npc.y + 204800 || MyChar.gMC.x >= npc.x + 12800 || MyChar.gMC.x <= npc.x - 12800) break;
                npc.act_no = 21;
                npc.act_wait = 0;
                break;
            }
            case 21: {
                if (++npc.act_wait % 10 == 6) {
                    Sound.PlaySoundObject(107, 1);
                }
                if ((npc.flag & 8) != 0) {
                    npc.ym = 0;
                    npc.direct = 0;
                    npc.act_no = 10;
                    Frame.SetQuake(10);
                    Sound.PlaySoundObject(26, 1);
                    for (int i = 0; i < 4; ++i) {
                        NpChar.SetNpChar(4, npc.x + Game.Random(-12, 12) * 512, npc.y + 8192, Game.Random(-341, 341), Game.Random(-1536, 0), 0, null, 256);
                    }
                    break;
                }
                if ((MyChar.gMC.flag & 8) != 0) {
                    npc.bits = (char)(npc.bits | 0x80);
                    npc.damage = 100;
                } else {
                    npc.bits = (char)(npc.bits & 0xFFFFFF7F);
                    npc.damage = 0;
                }
                npc.ym += 32;
            }
        }
        if (npc.ym > 512) {
            npc.ym = 512;
        }
        if (npc.ym < -512) {
            npc.ym = -512;
        }
        npc.y += npc.ym;
        npc.rect.copyFrom(ActNpc157_rect);
    }

    public static void ActNpc158(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
                switch (npc.direct) {
                    case 0: {
                        npc.count1 = 160;
                        break;
                    }
                    case 1: {
                        npc.count1 = 224;
                        break;
                    }
                    case 2: {
                        npc.count1 = 32;
                        break;
                    }
                    case 3: {
                        npc.count1 = 96;
                    }
                }
            }
            case 1: {
                npc.xm = 2 * Triangle.GetCos((char)(npc.count1 & 0xFF));
                npc.ym = 2 * Triangle.GetSin((char)(npc.count1 & 0xFF));
                npc.y += npc.ym;
                npc.x += npc.xm;
                int dir = Triangle.GetArktan(npc.x - MyChar.gMC.x, npc.y - MyChar.gMC.y);
                npc.count1 = dir < npc.count1 ? (npc.count1 - dir < 128 ? --npc.count1 : ++npc.count1) : (dir - npc.count1 < 128 ? ++npc.count1 : --npc.count1);
                if (npc.count1 > 255) {
                    npc.count1 -= 256;
                }
                if (npc.count1 >= 0) break;
                npc.count1 += 256;
            }
        }
        if (++npc.ani_wait > 2) {
            npc.ani_wait = 0;
            Caret.SetCaret(npc.x, npc.y, 7, 4);
        }
        npc.ani_no = (npc.count1 + 16) / 32;
        if (npc.ani_no > 7) {
            npc.ani_no = 7;
        }
        npc.rect.copyFrom(ActNpc158_rect[npc.ani_no]);
    }

    public static void ActNpc159(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
                for (int i = 0; i < 8; ++i) {
                    NpChar.SetNpChar(4, npc.x + Game.Random(-16, 16) * 512, npc.y + Game.Random(-16, 16) * 512, Game.Random(-341, 341), Game.Random(-341, 341), 0, null, 256);
                }
            }
            case 1: {
                if (++npc.act_wait > 50) {
                    npc.act_no = 2;
                    npc.xm = -256;
                }
                if (npc.act_wait / 2 % 2 != 0) {
                    npc.x += 512;
                    break;
                }
                npc.x -= 512;
                break;
            }
            case 2: {
                ++npc.act_wait;
                npc.ym += 64;
                if (npc.y <= 327680) break;
                npc.cond = 0;
            }
        }
        npc.y += npc.ym;
        npc.x += npc.xm;
        npc.rect.copyFrom(ActNpc159_rect);
        if (npc.act_wait % 8 == 1) {
            NpChar.SetNpChar(4, npc.x + Game.Random(-16, 16) * 512, npc.y + Game.Random(-16, 16) * 512, Game.Random(-341, 341), Game.Random(-341, 341), 0, null, 256);
        }
    }
}
