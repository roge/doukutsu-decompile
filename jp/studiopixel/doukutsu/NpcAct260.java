/*
 * Decompiled with CFR 0.152.
 */
package jp.studiopixel.doukutsu;

import jp.studiopixel.doukutsu.Caret;
import jp.studiopixel.doukutsu.Frame;
import jp.studiopixel.doukutsu.Game;
import jp.studiopixel.doukutsu.Map;
import jp.studiopixel.doukutsu.MyChar;
import jp.studiopixel.doukutsu.MycParam;
import jp.studiopixel.doukutsu.NpChar;
import jp.studiopixel.doukutsu.RECT;
import jp.studiopixel.doukutsu.Sound;
import jp.studiopixel.doukutsu.Triangle;

public class NpcAct260 {
    private static final RECT[] ActNpc260_rcLeft = new RECT[]{new RECT(128, 64, 144, 80), new RECT(144, 64, 160, 80), new RECT(224, 64, 240, 80)};
    private static final RECT[] ActNpc260_rcRight = new RECT[]{new RECT(128, 80, 144, 96), new RECT(144, 80, 160, 96), new RECT(224, 80, 240, 96)};
    private static final RECT[] ActNpc261_rcLeft = new RECT[]{new RECT(112, 32, 128, 48), new RECT(128, 32, 144, 48)};
    private static final RECT[] ActNpc261_rcRight = new RECT[]{new RECT(112, 48, 128, 64), new RECT(128, 48, 144, 64)};
    private static final RECT[] ActNpc262_rcLeft = new RECT[]{new RECT(128, 0, 144, 16), new RECT(144, 0, 160, 16)};
    private static final RECT[] ActNpc262_rcRight = new RECT[]{new RECT(128, 16, 144, 32), new RECT(144, 16, 160, 32)};
    private static final RECT[] ActNpc263_rcLeft = new RECT[]{new RECT(0, 0, 24, 32), new RECT(24, 0, 48, 32), new RECT(48, 0, 72, 32), new RECT(0, 0, 0, 0), new RECT(72, 0, 96, 32), new RECT(96, 0, 120, 32), new RECT(120, 0, 144, 32), new RECT(144, 0, 168, 32), new RECT(264, 0, 288, 32)};
    private static final RECT[] ActNpc263_rcRight = new RECT[]{new RECT(0, 32, 24, 64), new RECT(24, 32, 48, 64), new RECT(48, 32, 72, 64), new RECT(0, 0, 0, 0), new RECT(72, 32, 96, 64), new RECT(96, 32, 120, 64), new RECT(120, 32, 144, 64), new RECT(144, 32, 168, 64), new RECT(264, 32, 288, 64)};
    private static final RECT ActNpc264_rc = new RECT(288, 0, 304, 16);
    private static final RECT[] ActNpc265_rc = new RECT[]{new RECT(288, 16, 304, 32), new RECT(288, 32, 304, 48), new RECT(288, 48, 304, 64)};
    private static final RECT[] ActNpc266_rc = new RECT[]{new RECT(304, 16, 320, 32), new RECT(304, 32, 320, 48)};
    private static final RECT[] ActNpc267_rcLeft = new RECT[]{new RECT(0, 0, 0, 0), new RECT(0, 64, 40, 112), new RECT(40, 64, 80, 112), new RECT(80, 64, 120, 112), new RECT(120, 64, 160, 112), new RECT(160, 64, 200, 112), new RECT(200, 64, 240, 112), new RECT(240, 64, 280, 112), new RECT(280, 64, 320, 112), new RECT(0, 160, 40, 208)};
    private static final RECT[] ActNpc267_rcRight = new RECT[]{new RECT(0, 0, 0, 0), new RECT(0, 112, 40, 160), new RECT(40, 112, 80, 160), new RECT(80, 112, 120, 160), new RECT(120, 112, 160, 160), new RECT(160, 112, 200, 160), new RECT(200, 112, 240, 160), new RECT(240, 112, 280, 160), new RECT(280, 112, 320, 160), new RECT(40, 160, 80, 208)};
    private static final RECT[] ActNpc268_rcLeft = new RECT[]{new RECT(0, 0, 40, 40), new RECT(40, 0, 80, 40), new RECT(80, 0, 120, 40), new RECT(0, 0, 40, 40), new RECT(120, 0, 160, 40), new RECT(0, 0, 40, 40), new RECT(40, 80, 80, 120), new RECT(0, 80, 40, 120), new RECT(240, 0, 280, 40), new RECT(280, 0, 320, 40)};
    private static final RECT[] ActNpc268_rcRight = new RECT[]{new RECT(0, 40, 40, 80), new RECT(40, 40, 80, 80), new RECT(80, 40, 120, 80), new RECT(0, 40, 40, 80), new RECT(120, 40, 160, 80), new RECT(0, 40, 40, 80), new RECT(160, 80, 200, 120), new RECT(120, 80, 160, 120), new RECT(240, 40, 280, 80), new RECT(280, 40, 320, 80)};
    private static final RECT[] ActNpc269_rcLeft = new RECT[]{new RECT(232, 0, 248, 16), new RECT(248, 0, 264, 16), new RECT(248, 16, 264, 32)};
    private static final RECT[] ActNpc269_rcRight = new RECT[]{new RECT(232, 32, 248, 48), new RECT(248, 32, 264, 48), new RECT(248, 48, 264, 64)};
    private static final RECT[] ActNpc270_rc = new RECT[]{new RECT(170, 34, 174, 38), new RECT(170, 42, 174, 46)};
    private static final RECT[] ActNpc273_rc = new RECT[]{new RECT(248, 40, 272, 64), new RECT(272, 40, 296, 64), new RECT(296, 40, 320, 64)};
    private static final RECT[] ActNpc274_rcLeft = new RECT[]{new RECT(0, 0, 32, 40), new RECT(32, 0, 64, 40), new RECT(64, 0, 96, 40), new RECT(64, 80, 96, 120), new RECT(96, 80, 128, 120), new RECT(96, 0, 128, 40)};
    private static final RECT[] ActNpc274_rcRight = new RECT[]{new RECT(0, 40, 32, 80), new RECT(32, 40, 64, 80), new RECT(64, 40, 96, 80), new RECT(64, 120, 96, 160), new RECT(96, 120, 128, 160), new RECT(96, 40, 128, 80)};
    private static final RECT[] ActNpc275_rcRight = new RECT[]{new RECT(272, 80, 288, 96), new RECT(288, 80, 304, 96), new RECT(272, 80, 288, 96), new RECT(304, 80, 320, 96)};
    private static final RECT[] ActNpc276_rcLeft = new RECT[]{new RECT(0, 64, 32, 104), new RECT(32, 64, 64, 104), new RECT(64, 64, 96, 104), new RECT(96, 64, 128, 104), new RECT(128, 64, 160, 104), new RECT(160, 64, 192, 104), new RECT(192, 64, 224, 104), new RECT(224, 64, 256, 104), new RECT(256, 64, 288, 104)};
    private static final RECT[] ActNpc276_rcRight = new RECT[]{new RECT(0, 104, 32, 144), new RECT(32, 104, 64, 144), new RECT(64, 104, 96, 144), new RECT(96, 104, 128, 144), new RECT(128, 104, 160, 144), new RECT(160, 104, 192, 144), new RECT(192, 104, 224, 144), new RECT(224, 104, 256, 144), new RECT(256, 104, 288, 144)};
    private static final RECT[] ActNpc277_rc = new RECT[]{new RECT(128, 0, 152, 24), new RECT(152, 0, 176, 24), new RECT(176, 0, 200, 24)};
    private static final RECT[] ActNpc278_rcPapa = new RECT[]{new RECT(0, 120, 8, 128), new RECT(8, 120, 16, 128)};
    private static final RECT[] ActNpc278_rcMama = new RECT[]{new RECT(16, 120, 24, 128), new RECT(24, 120, 32, 128)};
    private static final RECT[] ActNpc278_rcKodomo = new RECT[]{new RECT(32, 120, 40, 128), new RECT(40, 120, 48, 128)};
    private static final RECT[] ActNpc279_rc = new RECT[]{new RECT(0, 16, 32, 48), new RECT(16, 0, 32, 16)};

    public static void ActNpc260(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.x += 512;
                npc.y -= 1024;
                npc.act_no = 1;
                npc.ani_no = 0;
                npc.ani_wait = 0;
            }
            case 1: {
                if (Game.Random(0, 160) != 1) break;
                npc.act_no = 2;
                npc.act_wait = 0;
                npc.ani_no = 1;
                break;
            }
            case 2: {
                if (++npc.act_wait <= 12) break;
                npc.act_no = 1;
                npc.ani_no = 0;
                break;
            }
            case 10: {
                npc.act_no = 11;
                npc.ani_no = 2;
                NpChar.SetNpChar(87, npc.x, npc.y - 8192, 0, 0, 0, null, 256);
            }
        }
        npc.direct = MyChar.gMC.x < npc.x ? 0 : 2;
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc260_rcLeft[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc260_rcRight[npc.ani_no]);
        }
    }

    public static void ActNpc261(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.x -= 512;
                npc.y -= 1024;
                npc.act_no = 1;
                npc.ani_no = 0;
                npc.ani_wait = 0;
            }
            case 1: {
                if (Game.Random(0, 160) != 1) break;
                npc.act_no = 2;
                npc.act_wait = 0;
                npc.ani_no = 1;
                break;
            }
            case 2: {
                if (++npc.act_wait <= 12) break;
                npc.act_no = 1;
                npc.ani_no = 0;
            }
        }
        npc.direct = MyChar.gMC.x < npc.x ? 0 : 2;
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc261_rcLeft[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc261_rcRight[npc.ani_no]);
        }
    }

    public static void ActNpc262(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.x -= 512;
                npc.y -= 1024;
                npc.act_no = 1;
                npc.ani_no = 0;
                npc.ani_wait = 0;
            }
            case 1: {
                if (Game.Random(0, 160) != 1) break;
                npc.act_no = 2;
                npc.act_wait = 0;
                npc.ani_no = 1;
                break;
            }
            case 2: {
                if (++npc.act_wait <= 12) break;
                npc.act_no = 1;
                npc.ani_no = 0;
            }
        }
        npc.direct = MyChar.gMC.x < npc.x ? 0 : 2;
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc262_rcLeft[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc262_rcRight[npc.ani_no]);
        }
    }

    public static void ActNpc263(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
                npc.y += 4096;
                npc.ani_no = 3;
                break;
            }
            case 2: {
                npc.ani_no = ++npc.act_wait / 2 % 2 != 0 ? 0 : 3;
                if (npc.act_wait <= 50) break;
                npc.act_no = 10;
                break;
            }
            case 10: {
                npc.ym += 128;
                npc.bits = (char)(npc.bits | 0x20);
                npc.damage = 3;
                if ((npc.flag & 8) == 0) break;
                npc.act_no = 20;
                npc.act_wait = 0;
                npc.ani_no = 0;
                npc.count2 = npc.life;
                if (npc.x > MyChar.gMC.x) {
                    npc.direct = 0;
                    break;
                }
                npc.direct = 2;
                break;
            }
            case 20: {
                if (++npc.act_wait < 50 && npc.life < npc.count2 - 20) {
                    npc.act_wait = 50;
                }
                if (npc.act_wait == 50) {
                    npc.direct = npc.x > MyChar.gMC.x ? 0 : 2;
                    npc.ani_no = 4;
                }
                if (npc.act_wait == 80) {
                    npc.ani_no = 5;
                    Sound.PlaySoundObject(25, 1);
                    if (npc.direct == 0) {
                        NpChar.SetNpChar(264, npc.x - 8192, npc.y, 0, 0, 0, null, 256);
                        NpChar.SetNpChar(264, npc.x - 8192, npc.y, 0, 0, 1024, null, 256);
                    } else {
                        NpChar.SetNpChar(264, npc.x + 8192, npc.y, 0, 0, 2, null, 256);
                        NpChar.SetNpChar(264, npc.x + 8192, npc.y, 0, 0, 1026, null, 256);
                    }
                }
                if (npc.act_wait == 120) {
                    npc.ani_no = 0;
                }
                if (npc.act_wait > 130 && npc.life < npc.count2 - 50) {
                    npc.act_wait = 161;
                }
                if (npc.act_wait <= 160) break;
                npc.act_no = 100;
                npc.ani_no = 0;
                break;
            }
            case 30: {
                npc.act_no = 31;
                npc.act_wait = 0;
                npc.ani_no = 6;
                npc.tgt_x = npc.x;
                npc.bits = (char)(npc.bits | 0x20);
            }
            case 31: {
                npc.x = ++npc.act_wait / 2 % 2 != 0 ? npc.tgt_x : npc.tgt_x + 512;
                if (npc.act_wait <= 50) break;
                npc.act_no = 32;
                npc.act_wait = 0;
                npc.ani_no = 7;
                Sound.PlaySoundObject(101, 1);
                for (int deg = 8; deg < 256; deg += 16) {
                    int xm = Triangle.GetCos((char)deg) * 2;
                    int ym = Triangle.GetSin((char)deg) * 2;
                    NpChar.SetNpChar(266, npc.x, npc.y, xm, ym, 0, null, 256);
                }
                break;
            }
            case 32: {
                if (++npc.act_wait <= 50) break;
                npc.act_no = 100;
                break;
            }
            case 100: {
                npc.act_no = 101;
                npc.bits = (char)(npc.bits & 0xFFFFFFDF);
                npc.damage = 0;
                npc.act_wait = 0;
                Sound.PlaySoundObject(29, 1);
            }
            case 101: {
                npc.act_wait += 2;
                if (npc.act_wait <= 16) break;
                npc.act_no = 102;
                npc.act_wait = 0;
                npc.ani_no = 3;
                npc.tgt_x = Game.Random(5, 35) * 512 * 16;
                npc.tgt_y = Game.Random(5, 7) * 512 * 16;
                break;
            }
            case 102: {
                if (++npc.act_wait <= 40) break;
                npc.act_no = 103;
                npc.act_wait = 16;
                npc.ani_no = 2;
                npc.ym = 0;
                npc.x = npc.tgt_x;
                npc.y = npc.tgt_y;
                if (npc.x > MyChar.gMC.x) {
                    npc.direct = 0;
                    break;
                }
                npc.direct = 2;
                break;
            }
            case 103: {
                npc.act_wait -= 2;
                if (npc.act_wait > 0) break;
                npc.bits = (char)(npc.bits | 0x20);
                npc.damage = 3;
                if (npc.count1 < 3) {
                    ++npc.count1;
                    npc.act_no = 10;
                    break;
                }
                npc.count1 = 0;
                npc.act_no = 30;
                break;
            }
            case 500: {
                npc.bits = (char)(npc.bits & 0xFFFFFFDF);
                npc.ani_no = 6;
                npc.ym += 16;
                if ((npc.flag & 8) == 0) break;
                npc.act_no = 501;
                npc.act_wait = 0;
                npc.tgt_x = npc.x;
                if (npc.x > MyChar.gMC.x) {
                    npc.direct = 0;
                    break;
                }
                npc.direct = 2;
                break;
            }
            case 501: {
                npc.direct = npc.x > MyChar.gMC.x ? 0 : 2;
                npc.ani_no = 8;
                npc.x = ++npc.act_wait / 2 % 2 != 0 ? npc.tgt_x : npc.tgt_x + 512;
            }
        }
        if (npc.act_no >= 10) {
            if (npc.act_no == 102) {
                NpChar.gSuperXpos = npc.tgt_x;
                NpChar.gSuperYpos = npc.tgt_y;
            } else {
                NpChar.gSuperXpos = npc.x;
                NpChar.gSuperYpos = npc.y;
            }
        }
        if (npc.ym > 1535) {
            npc.ym = 1535;
        }
        npc.x += npc.xm;
        npc.y += npc.ym;
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc263_rcLeft[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc263_rcRight[npc.ani_no]);
        }
        if (npc.act_no == 101 || npc.act_no == 103) {
            npc.rect.top += npc.act_wait;
            npc.rect.bottom -= npc.act_wait;
            npc.view.top = (16 - npc.act_wait) * 512;
        } else {
            npc.view.top = 8192;
        }
    }

    public static void ActNpc264(NpChar.NPCHAR npc) {
        if (npc.x < 0 || npc.x > Map.gMap.width * 16 * 512) {
            NpChar.VanishNpChar(npc);
            return;
        }
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
                npc.tgt_x = npc.x;
                npc.tgt_y = npc.y;
                npc.count1 = npc.direct / 8;
                npc.direct %= 8;
            }
            case 1: {
                npc.count1 += 6;
                npc.count1 %= 256;
                char deg = (char)npc.count1;
                if (npc.act_wait < 128) {
                    ++npc.act_wait;
                }
                npc.xm = npc.direct == 0 ? (npc.xm -= 21) : (npc.xm += 21);
                npc.tgt_x += npc.xm;
                npc.x = npc.tgt_x + Triangle.GetCos(deg) * npc.act_wait / 2 / 4;
                npc.y = npc.tgt_y + Triangle.GetSin(deg) * npc.act_wait / 2;
                NpChar.SetNpChar(265, npc.x, npc.y, 0, 0, 0, null, 256);
            }
        }
        npc.rect.copyFrom(ActNpc264_rc);
    }

    public static void ActNpc265(NpChar.NPCHAR npc) {
        if (++npc.ani_wait > 3) {
            npc.ani_wait = 0;
            ++npc.ani_no;
        }
        if (npc.ani_no > 2) {
            npc.cond = 0;
        } else {
            npc.rect.copyFrom(ActNpc265_rc[npc.ani_no]);
        }
    }

    public static void ActNpc266(NpChar.NPCHAR npc) {
        if ((npc.flag & 1) != 0) {
            npc.xm *= -1;
        }
        if ((npc.flag & 4) != 0) {
            npc.xm *= -1;
        }
        if ((npc.flag & 2) != 0) {
            npc.ym = 512;
        }
        if ((npc.flag & 8) != 0) {
            npc.ym = -512;
        }
        npc.x += npc.xm;
        npc.y += npc.ym;
        if (++npc.ani_no > 1) {
            npc.ani_no = 0;
        }
        npc.rect.copyFrom(ActNpc266_rc[npc.ani_no]);
        if (++npc.act_wait % 4 == 1) {
            NpChar.SetNpChar(265, npc.x, npc.y, 0, 0, 0, null, 256);
        }
        if (npc.act_wait > 250) {
            NpChar.VanishNpChar(npc);
        }
    }

    public static void ActNpc267(NpChar.NPCHAR npc) {
        block0 : switch (npc.act_no) {
            case 0: {
                npc.direct = NpChar.gSuperXpos > MyChar.gMC.x ? 0 : 2;
                npc.x = npc.direct == 0 ? NpChar.gSuperXpos - 3072 : NpChar.gSuperXpos + 3072;
                npc.y = NpChar.gSuperYpos;
            }
            case 1: {
                npc.act_no = 2;
            }
            case 2: {
                npc.ym += 128;
                if (++npc.act_wait / 2 % 2 != 0) {
                    npc.ani_no = 0;
                    break;
                }
                npc.ani_no = 3;
                break;
            }
            case 5: {
                npc.act_no = 6;
                npc.ani_no = 1;
                npc.ani_wait = 0;
            }
            case 6: {
                npc.ym += 128;
                if (++npc.ani_wait > 40) {
                    npc.ani_wait = 0;
                    ++npc.ani_no;
                }
                if (npc.ani_no <= 2) break;
                npc.ani_no = 1;
                break;
            }
            case 7: {
                npc.act_no = 8;
                npc.act_wait = 0;
                npc.ani_no = 3;
            }
            case 8: {
                npc.ym += 64;
                if (++npc.act_wait <= 40) break;
                npc.act_no = 10;
                break;
            }
            case 10: {
                npc.bits = (char)(npc.bits | 4);
                npc.xm = 0;
                npc.act_no = 11;
                npc.act_wait = 0;
                npc.ani_no = 1;
                npc.ani_wait = 0;
                npc.count2 = npc.life;
            }
            case 11: {
                npc.ym += 128;
                npc.direct = npc.x > MyChar.gMC.x ? 0 : 2;
                if ((npc.flag & 8) != 0) {
                    if (npc.life < npc.count2 - 20) {
                        if ((MyChar.gMC.flag & 8) != 0 && MyChar.gMC.x > npc.x - 24576 && MyChar.gMC.x < npc.x + 24576 && npc.ani_no != 6) {
                            npc.ani_no = 6;
                            MycParam.DamageMyChar(5);
                            Frame.SetQuake(10);
                            Sound.PlaySoundObject(26, 1);
                            MyChar.gMC.ym = -1024;
                            MyChar.gMC.xm = npc.x > MyChar.gMC.x ? -1535 : 1535;
                            for (int i = 0; i < 100; ++i) {
                                NpChar.SetNpChar(270, npc.x + Game.Random(-16, 16) * 512, npc.y + Game.Random(-16, 16) * 512, Game.Random(-512, 512) * 3, Game.Random(-512, 512) * 3, 3, null, 170);
                            }
                        }
                    } else if (++npc.ani_wait > 10) {
                        npc.ani_wait = 0;
                        if (++npc.ani_no > 2) {
                            npc.ani_no = 1;
                        }
                    }
                } else {
                    npc.ani_no = 4;
                }
                if (++npc.act_wait <= 30 && npc.life >= npc.count2 - 20) break;
                if (++npc.count1 > 10) {
                    npc.count1 = 0;
                }
                switch (npc.count1) {
                    case 8: {
                        npc.act_no = 20;
                        break block0;
                    }
                    case 2: 
                    case 7: {
                        npc.act_no = 100;
                        break block0;
                    }
                    case 3: 
                    case 6: {
                        npc.act_no = 30;
                        break block0;
                    }
                    case 1: 
                    case 9: {
                        npc.act_no = 40;
                        break block0;
                    }
                }
                npc.act_no = 15;
                npc.act_wait = 0;
                break;
            }
            case 15: {
                npc.ani_no = 3;
                ++npc.act_wait;
                npc.direct = npc.x > MyChar.gMC.x ? 0 : 2;
                if (npc.act_wait <= 20) break;
                npc.act_no = 16;
                npc.ani_no = 4;
                npc.ani_wait = 0;
                npc.ym = -1536;
                if (npc.direct == 0) {
                    npc.xm = -1024;
                    break;
                }
                npc.xm = 1024;
                break;
            }
            case 16: {
                npc.ym += 64;
                if (++npc.ani_wait > 1) {
                    npc.ani_wait = 0;
                    ++npc.ani_no;
                }
                if (npc.ani_no > 5) {
                    npc.ani_no = 4;
                }
                npc.direct = npc.x > MyChar.gMC.x ? 0 : 2;
                if (npc.ym <= 0 || (npc.flag & 8) == 0) break;
                npc.act_no = 17;
                break;
            }
            case 17: {
                npc.act_no = 18;
                npc.act_wait = 0;
                Frame.SetQuake(10);
                Sound.PlaySoundObject(26, 1);
            }
            case 18: {
                npc.ani_no = 3;
                ++npc.act_wait;
                npc.xm = npc.xm * 7 / 8;
                npc.ym += 128;
                if (npc.act_wait <= 10) break;
                npc.act_no = 10;
                break;
            }
            case 20: {
                npc.act_no = 21;
                npc.act_wait = 0;
            }
            case 21: {
                ++npc.act_wait;
                npc.ani_no = 6;
                if (npc.act_wait > 20 && npc.act_wait % 3 == 1) {
                    int ym = Game.Random(-512, 512);
                    int xm = Game.Random(256, 512) * 4;
                    if (npc.direct == 0) {
                        NpChar.SetNpChar(269, npc.x - 4096, npc.y - 2048, -xm, ym, 0, null, 256);
                    } else {
                        NpChar.SetNpChar(269, npc.x + 4096, npc.y - 2048, xm, ym, 2, null, 256);
                    }
                    Sound.PlaySoundObject(39, 1);
                }
                if (npc.act_wait <= 90) break;
                npc.act_no = 10;
                break;
            }
            case 30: {
                npc.act_no = 31;
                npc.act_wait = 0;
                npc.bits = (char)(npc.bits | '\u0001');
                npc.bits = (char)(npc.bits & 0xFFFFFFDF);
            }
            case 31: {
                npc.ani_no = 3;
                if (++npc.act_wait <= 20) break;
                npc.act_no = 32;
                npc.act_wait = 0;
                npc.ani_no = 7;
                npc.bits = (char)(npc.bits | 0x80);
                npc.damage = 10;
                Sound.PlaySoundObject(25, 1);
                if (npc.direct == 0) {
                    npc.xm = -1535;
                    break;
                }
                npc.xm = 1535;
                break;
            }
            case 32: {
                ++npc.act_wait;
                npc.ym = 0;
                npc.ani_no = npc.act_wait / 2 % 2 != 0 ? 7 : 8;
                if (npc.act_wait > 30) {
                    npc.act_wait = 0;
                    npc.act_no = 18;
                    npc.damage = 5;
                    npc.bits = (char)(npc.bits & 0xFFFFFF7E);
                    npc.bits = (char)(npc.bits | 0x20);
                }
                if ((npc.flag & 1) == 0 && (npc.flag & 4) == 0) break;
                npc.act_no = 15;
                npc.act_wait = 0;
                npc.damage = 5;
                npc.bits = (char)(npc.bits & 0xFFFFFF7E);
                npc.bits = (char)(npc.bits | 0x20);
                break;
            }
            case 40: {
                npc.ani_no = 3;
                ++npc.act_wait;
                npc.direct = npc.x > MyChar.gMC.x ? 0 : 2;
                if (npc.act_wait <= 20) break;
                npc.act_no = 41;
                npc.ani_no = 4;
                npc.ani_wait = 0;
                npc.ym = -2048;
                if (npc.direct == 0) {
                    npc.xm = -1024;
                    break;
                }
                npc.xm = 1024;
                break;
            }
            case 41: {
                npc.ym += 64;
                if (++npc.ani_wait > 1) {
                    npc.ani_wait = 0;
                    ++npc.ani_no;
                }
                if (npc.ani_no > 5) {
                    npc.ani_no = 4;
                }
                if (MyChar.gMC.y > npc.y && MyChar.gMC.x > npc.x - 4096 && MyChar.gMC.x < npc.x + 4096) {
                    npc.act_no = 16;
                    npc.ym = 1535;
                    npc.xm = 0;
                }
                if (npc.ym <= 0 || (npc.flag & 8) == 0) break;
                npc.act_no = 17;
                break;
            }
            case 100: {
                npc.act_no = 101;
                npc.act_wait = 0;
                npc.bits = (char)(npc.bits & 0xFFFFFFDB);
                npc.damage = 0;
                Sound.PlaySoundObject(29, 1);
            }
            case 101: {
                npc.act_wait += 2;
                if (npc.act_wait <= 28) break;
                npc.act_no = 102;
                npc.act_wait = 0;
                npc.ani_no = 0;
                npc.tgt_x = MyChar.gMC.x;
                npc.tgt_y = MyChar.gMC.y - 16384;
                if (npc.tgt_y < 32768) {
                    npc.tgt_y = 32768;
                }
                if (npc.tgt_x < 32768) {
                    npc.tgt_x = 32768;
                }
                if (npc.tgt_x <= 294912) break;
                npc.tgt_x = 294912;
                break;
            }
            case 102: {
                if (++npc.act_wait <= 40) break;
                npc.act_no = 103;
                npc.act_wait = 28;
                npc.ani_no = 4;
                npc.ym = 0;
                npc.x = npc.tgt_x;
                npc.y = npc.tgt_y;
                if (npc.x > MyChar.gMC.x) {
                    npc.direct = 0;
                    break;
                }
                npc.direct = 2;
                break;
            }
            case 103: {
                npc.act_wait -= 2;
                if (npc.act_wait > 0) break;
                npc.bits = (char)(npc.bits | 0x24);
                npc.damage = 5;
                npc.act_no = 16;
                npc.ym = -512;
                npc.xm = 0;
                break;
            }
            case 500: {
                NpChar.DeleteNpCharCode(269, true);
                npc.bits = (char)(npc.bits & 0xFFFFFFDF);
                npc.ani_no = 4;
                npc.ym += 32;
                npc.xm = 0;
                if ((npc.flag & 8) == 0) break;
                npc.act_no = 501;
                npc.act_wait = 0;
                npc.tgt_x = npc.x;
                if (npc.x > MyChar.gMC.x) {
                    npc.direct = 0;
                    break;
                }
                npc.direct = 2;
                break;
            }
            case 501: {
                npc.ani_no = 9;
                if (++npc.act_wait / 2 % 2 != 0) {
                    npc.x = npc.tgt_x;
                    break;
                }
                npc.x = npc.tgt_x + 512;
                break;
            }
            case 510: {
                npc.act_no = 511;
                npc.act_wait = 0;
                npc.ani_no = 9;
                npc.tgt_x = npc.x;
                npc.y += 8192;
                npc.bits = (char)(npc.bits | 8);
            }
            case 511: {
                Frame.SetQuake(2);
                if (++npc.act_wait % 6 == 3) {
                    Sound.PlaySoundObject(25, 1);
                }
                npc.x = npc.act_wait / 2 % 2 != 0 ? npc.tgt_x : npc.tgt_x + 512;
                if (npc.act_wait <= 352) break;
                npc.ani_no = 0;
                npc.act_no = 512;
                break;
            }
            case 520: {
                npc.damage = 0;
                NpChar.gSuperYpos = -16384;
            }
        }
        if (npc.act_no >= 11 && npc.act_no < 501) {
            if (npc.act_no == 102) {
                NpChar.gSuperXpos = npc.tgt_x;
                NpChar.gSuperYpos = npc.tgt_y;
            } else {
                NpChar.gSuperXpos = npc.x;
                NpChar.gSuperYpos = npc.y;
            }
        }
        if (npc.ym > 1535) {
            npc.ym = 1535;
        }
        npc.x += npc.xm;
        npc.y += npc.ym;
        if (npc.act_no < 512) {
            if (npc.act_no < 510) {
                if (npc.act_no != 102 && npc.act_no != 103 && Game.Random(0, 3) == 2) {
                    NpChar.SetNpChar(270, npc.x + Game.Random(-16, 16) * 512, npc.y + Game.Random(-8, 4) * 512, npc.xm, 0, 3, null, 256);
                }
            } else {
                NpChar.SetNpChar(270, npc.x + Game.Random(-16, 16) * 512, npc.y - (336 - npc.act_wait) / 8 * 512, Game.Random(-512, 512), Game.Random(-512, 0) * 2, 3, null, 170);
                NpChar.SetNpChar(270, npc.x + Game.Random(-16, 16) * 512, npc.y - (336 - npc.act_wait) / 8 * 512, Game.Random(-512, 512), Game.Random(-512, 0) * 2, 3, null, 170);
                NpChar.SetNpChar(270, npc.x + Game.Random(-16, 16) * 512, npc.y - (336 - npc.act_wait) / 8 * 512, 0, 2 * Game.Random(-512, 0), 3, null, 170);
                NpChar.SetNpChar(270, npc.x + Game.Random(-16, 16) * 512, npc.y - (336 - npc.act_wait) / 8 * 512, 0, 2 * Game.Random(-512, 0), 3, null, 170);
            }
        }
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc267_rcLeft[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc267_rcRight[npc.ani_no]);
        }
        if (npc.act_no == 511) {
            npc.rect.top += npc.act_wait / 8;
            npc.view.top = (44 - npc.act_wait / 8) * 512;
            npc.view.bottom = 2048;
        } else if (npc.act_no == 101 || npc.act_no == 103) {
            npc.rect.top += npc.act_wait;
            npc.rect.bottom -= npc.act_wait;
            npc.view.top = (28 - npc.act_wait) * 512;
        } else {
            npc.view.top = 14336;
        }
    }

    public static void ActNpc268(NpChar.NPCHAR npc) {
        if (npc.x < MyChar.gMC.x - 163840 || npc.x > MyChar.gMC.x + 163840 || npc.y < MyChar.gMC.y - 122880 || npc.y > MyChar.gMC.y + 122880) {
            npc.act_no = 1;
        }
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
                npc.y += 4096;
            }
            case 1: {
                if (++npc.ani_wait > 20) {
                    npc.ani_wait = 0;
                    ++npc.ani_no;
                }
                if (npc.ani_no > 1) {
                    npc.ani_no = 0;
                }
                if (npc.x < MyChar.gMC.x + 57344 && npc.x > MyChar.gMC.x - 57344 && npc.x < MyChar.gMC.x + 24576 && npc.x > MyChar.gMC.x - 57344) {
                    npc.act_no = 10;
                }
                if (npc.shock == '\u0000') break;
                npc.act_no = 10;
                break;
            }
            case 10: {
                npc.act_no = 11;
                npc.act_wait = 0;
                npc.ani_no = 0;
                npc.ani_wait = 0;
                npc.direct = MyChar.gMC.x < npc.x ? 0 : 2;
            }
            case 11: {
                npc.xm = npc.direct == 0 ? -512 : 512;
                if (npc.x < MyChar.gMC.x + 32768 && npc.x > MyChar.gMC.x - 32768) {
                    npc.act_no = 20;
                    npc.act_wait = 0;
                }
                if (npc.xm < 0 && (npc.flag & 1) != 0) {
                    npc.act_no = 20;
                    npc.act_wait = 0;
                }
                if (npc.xm > 0 && (npc.flag & 4) != 0) {
                    npc.act_no = 20;
                    npc.act_wait = 0;
                }
                if (++npc.ani_wait > 4) {
                    npc.ani_wait = 0;
                    ++npc.ani_no;
                }
                if (npc.ani_no <= 5) break;
                npc.ani_no = 2;
                break;
            }
            case 20: {
                npc.xm = 0;
                npc.ani_no = 6;
                if (++npc.act_wait <= 10) break;
                npc.act_no = 30;
                npc.ym = -1535;
                npc.xm = npc.direct == 0 ? -512 : 512;
                Sound.PlaySoundObject(108, 1);
                break;
            }
            case 30: {
                npc.ani_no = 7;
                if ((npc.flag & 8) == 0) break;
                npc.act_no = 40;
                npc.act_wait = 0;
                Frame.SetQuake(20);
                Sound.PlaySoundObject(26, 1);
                break;
            }
            case 40: {
                npc.xm = 0;
                npc.ani_no = 6;
                if (++npc.act_wait <= 30) break;
                npc.act_no = 50;
                break;
            }
            case 50: {
                npc.act_no = 51;
                npc.act_wait = 0;
                npc.direct = MyChar.gMC.x < npc.x ? 0 : 2;
            }
            case 51: {
                if (++npc.act_wait > 30 && npc.act_wait % 4 == 1) {
                    char deg = npc.direct == 0 ? (char)'\u0088' : '\u00f8';
                    deg = (char)(deg + (char)Game.Random(-16, 16) & 0xFF);
                    int ym = Triangle.GetSin(deg) * 5;
                    int xm = Triangle.GetCos(deg) * 5;
                    NpChar.SetNpChar(11, npc.x, npc.y + 2048, xm, ym, 0, null, 256);
                    Sound.PlaySoundObject(12, 1);
                }
                npc.ani_no = npc.act_wait < 50 && npc.act_wait / 2 % 2 != 0 ? 9 : 8;
                if (npc.act_wait <= 82) break;
                npc.act_no = 10;
                npc.direct = MyChar.gMC.x < npc.x ? 0 : 2;
            }
        }
        npc.ym += 51;
        if (npc.ym > 1535) {
            npc.ym = 1535;
        }
        npc.x += npc.xm;
        npc.y += npc.ym;
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc268_rcLeft[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc268_rcRight[npc.ani_no]);
        }
    }

    public static void ActNpc269(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
                npc.xm2 = npc.xm;
                npc.ym2 = npc.ym;
            }
            case 1: {
                if (npc.xm2 < 0 && (npc.flag & 1) != 0) {
                    npc.direct = 2;
                    npc.xm2 *= -1;
                } else if (npc.xm2 > 0 && (npc.flag & 4) != 0) {
                    npc.direct = 0;
                    npc.xm2 *= -1;
                } else if (npc.ym2 < 0 && (npc.flag & 2) != 0) {
                    npc.ym2 *= -1;
                } else if (npc.ym2 > 0 && (npc.flag & 8) != 0) {
                    npc.ym2 *= -1;
                }
                npc.x += npc.xm2;
                npc.y += npc.ym2;
                if (++npc.ani_wait > 2) {
                    npc.ani_wait = 0;
                    ++npc.ani_no;
                }
                if (npc.ani_no <= 2) break;
                npc.ani_no = 0;
            }
        }
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc269_rcLeft[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc269_rcRight[npc.ani_no]);
        }
    }

    public static void ActNpc270(NpChar.NPCHAR npc) {
        if (npc.direct == 3 || npc.direct == 1) {
            if (npc.direct == 3) {
                npc.ym += 64;
            }
            if (npc.direct == 1) {
                npc.ym -= 64;
            }
            ++npc.act_wait;
            if (npc.ym > 1535) {
                npc.ym = 1535;
            }
            npc.x += npc.xm;
            npc.y += npc.ym;
            if (npc.act_wait > 50) {
                npc.cond = 0;
            }
            if ((npc.flag & 0xFF) != 0) {
                npc.cond = 0;
            }
        } else if (npc.direct == 2) {
            switch (npc.act_no) {
                case 0: {
                    npc.act_no = 1;
                    npc.bits = (char)(npc.bits | 8);
                    npc.xm = Game.Random(-512, 512) * 3;
                    npc.ym = Game.Random(-512, 512) * 3;
                    npc.count1 = Game.Random(16, 51);
                    npc.count2 = Game.Random(128, 256);
                }
            }
            if (npc.x < npc.pNpc.x) {
                npc.xm += 512 / npc.count1;
            }
            if (npc.x > npc.pNpc.x) {
                npc.xm -= 512 / npc.count1;
            }
            if (npc.y < npc.pNpc.y) {
                npc.ym += 512 / npc.count1;
            }
            if (npc.y > npc.pNpc.y) {
                npc.ym -= 512 / npc.count1;
            }
            if (npc.xm > npc.count2 * 2) {
                npc.xm = npc.count2 * 2;
            }
            if (npc.xm < -npc.count2 * 2) {
                npc.xm = -npc.count2 * 2;
            }
            if (npc.ym > npc.count2 * 3) {
                npc.ym = npc.count2 * 3;
            }
            if (npc.ym < -npc.count2 * 3) {
                npc.ym = -npc.count2 * 3;
            }
            npc.x += npc.xm;
            npc.y += npc.ym;
        }
        npc.rect.copyFrom(ActNpc270_rc[Game.Random(0, 1)]);
    }

    public static void ActNpc271(NpChar.NPCHAR npc) {
        if (npc.xm < 0 && npc.x < -8192) {
            NpChar.VanishNpChar(npc);
            return;
        }
        if (npc.xm > 0 && npc.x > Map.gMap.width * 512 * 16 + 8192) {
            NpChar.VanishNpChar(npc);
            return;
        }
        if (npc.act_no == 0) {
            npc.act_no = 1;
            int a = Game.Random(0, 9);
            if (a == 9) {
                npc.rect.left = 0;
                npc.rect.right = 32;
                npc.rect.top = 64;
                npc.rect.bottom = 96;
                npc.view.front = 8192;
                npc.view.back = 8192;
                npc.view.top = 8192;
                npc.view.bottom = 8192;
                npc.hit.front = 6144;
                npc.hit.back = 6144;
                npc.hit.top = 6144;
                npc.hit.bottom = 6144;
            } else {
                npc.rect.left = a % 3 * 16 + 112;
                npc.rect.top = a / 3 * 16;
                npc.rect.right = npc.rect.left + 16;
                npc.rect.bottom = npc.rect.top + 16;
            }
            npc.xm = npc.direct == 0 ? Game.Random(256, 512) * -2 : Game.Random(256, 512) * 2;
            npc.ym = Game.Random(-512, 512);
        }
        if (npc.ym < 0 && npc.y - npc.hit.top < 4096) {
            npc.ym *= -1;
            Caret.SetCaret(npc.x, npc.y - 4096, 13, 0);
            Caret.SetCaret(npc.x, npc.y - 4096, 13, 0);
        }
        if (npc.ym > 0 && npc.y + npc.hit.bottom > 118784) {
            npc.ym *= -1;
            Caret.SetCaret(npc.x, npc.y + 4096, 13, 0);
            Caret.SetCaret(npc.x, npc.y + 4096, 13, 0);
        }
        npc.x += npc.xm;
        npc.y += npc.ym;
    }

    public static void ActNpc272(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
                npc.act_wait = Game.Random(0, 200);
            }
            case 1: {
                if (npc.act_wait != 0) {
                    --npc.act_wait;
                    break;
                }
                npc.act_no = 0;
                NpChar.SetNpChar(271, npc.x, npc.y + Game.Random(-32, 32) * 512, 0, 0, npc.direct, null, 256);
            }
        }
    }

    public static void ActNpc273(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
            }
            case 1: {
                npc.x += npc.xm;
                npc.y += npc.ym;
                if ((npc.flag & 0xFF) != 0) {
                    NpChar.SetNpChar(4, npc.x, npc.y, 0, 0, 0, null, 256);
                    NpChar.SetNpChar(4, npc.x, npc.y, 0, 0, 0, null, 256);
                    NpChar.SetNpChar(4, npc.x, npc.y, 0, 0, 0, null, 256);
                    NpChar.VanishNpChar(npc);
                    return;
                }
                if (++npc.act_wait % 5 == 0) {
                    Sound.PlaySoundObject(110, 1);
                }
                if (++npc.ani_no <= 2) break;
                npc.ani_no = 0;
            }
        }
        npc.rect.copyFrom(ActNpc273_rc[npc.ani_no]);
    }

    public static void ActNpc274(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
                npc.y -= 4096;
                npc.tgt_x = npc.x;
            }
            case 1: {
                npc.xm = 0;
                npc.act_no = 2;
                npc.ani_no = 0;
            }
            case 2: {
                npc.direct = npc.x > MyChar.gMC.x ? 0 : 2;
                if (++npc.ani_wait > 40) {
                    npc.ani_wait = 0;
                    ++npc.ani_no;
                }
                if (npc.ani_no > 1) {
                    npc.ani_no = 0;
                }
                if (npc.shock == '\u0000') break;
                npc.act_no = 10;
                break;
            }
            case 10: {
                npc.act_no = 11;
                npc.ani_no = 2;
                npc.act_wait = 0;
            }
            case 11: {
                if (++npc.act_wait <= 10) break;
                npc.act_no = 12;
                npc.ani_no = 3;
                npc.ym = -1536;
                npc.count1 = 0;
                if (npc.tgt_x > npc.x) {
                    npc.xm = 512;
                    break;
                }
                npc.xm = -512;
                break;
            }
            case 12: {
                if (npc.ym > 0) {
                    npc.ani_no = 4;
                    if (npc.count1 == 0) {
                        ++npc.count1;
                        char deg = (char)Triangle.GetArktan(npc.x - MyChar.gMC.x, npc.y - 5120 - MyChar.gMC.y);
                        int ym = Triangle.GetSin(deg) * 4;
                        int xm = Triangle.GetCos(deg) * 4;
                        NpChar.SetNpChar(273, npc.x, npc.y - 5120, xm, ym, 0, null, 256);
                        Sound.PlaySoundObject(39, 1);
                    }
                }
                if (npc.ym > 512) {
                    npc.ani_no = 5;
                }
                if ((npc.flag & 8) == 0) break;
                npc.ani_no = 2;
                npc.act_no = 13;
                npc.act_wait = 0;
                npc.xm = 0;
                break;
            }
            case 13: {
                npc.xm /= 2;
                if (++npc.act_wait <= 10) break;
                npc.act_no = 1;
            }
        }
        npc.ym += 85;
        if (npc.ym > 1535) {
            npc.ym = 1535;
        }
        npc.x += npc.xm;
        npc.y += npc.ym;
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc274_rcLeft[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc274_rcRight[npc.ani_no]);
        }
    }

    public static void ActNpc275(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
                npc.ani_no = 0;
                npc.ani_wait = 0;
            }
            case 1: {
                if (Game.Random(0, 120) == 10) {
                    npc.act_no = 2;
                    npc.act_wait = 0;
                    npc.ani_no = 1;
                }
                if (npc.x - 32768 >= MyChar.gMC.x || npc.x + 32768 <= MyChar.gMC.x || npc.y - 16384 >= MyChar.gMC.y || npc.y + 8192 <= MyChar.gMC.y) break;
                if (++npc.ani_wait > 3) {
                    npc.ani_wait = 0;
                    ++npc.ani_no;
                }
                if (npc.ani_no <= 3) break;
                npc.ani_no = 2;
                break;
            }
            case 2: {
                if (++npc.act_wait <= 8) break;
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
        npc.rect.copyFrom(ActNpc275_rcRight[npc.ani_no]);
    }

    public static void ActNpc276(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
                npc.y -= 4096;
            }
            case 1: {
                npc.xm = 0;
                npc.act_no = 2;
                npc.ani_no = 0;
            }
            case 2: {
                npc.direct = npc.x > MyChar.gMC.x ? 0 : 2;
                if (++npc.ani_wait > 20) {
                    npc.ani_wait = 0;
                    ++npc.ani_no;
                }
                if (npc.ani_no > 1) {
                    npc.ani_no = 0;
                }
                if (npc.shock == '\u0000') break;
                npc.act_no = 10;
                break;
            }
            case 10: {
                npc.act_no = 11;
                npc.act_wait = 0;
                npc.ani_no = 3;
                npc.bits = (char)(npc.bits | 0x20);
            }
            case 11: {
                switch (++npc.act_wait) {
                    case 30: 
                    case 40: 
                    case 50: {
                        npc.ani_no = 4;
                        char deg = (char)Triangle.GetArktan(npc.x - MyChar.gMC.x, npc.y - MyChar.gMC.y);
                        int ym = Triangle.GetSin(deg) * 4;
                        int xm = Triangle.GetCos(deg) * 4;
                        NpChar.SetNpChar(277, npc.x, npc.y, xm, ym, 0, null, 256);
                        Sound.PlaySoundObject(39, 1);
                        break;
                    }
                    case 34: 
                    case 44: 
                    case 54: {
                        npc.ani_no = 3;
                    }
                }
                if (npc.act_wait <= 60) break;
                npc.act_no = 20;
                npc.act_wait = 0;
                npc.ani_no = 2;
                break;
            }
            case 20: {
                if (++npc.act_wait <= 20) break;
                npc.act_no = 21;
                npc.act_wait = 0;
                npc.ani_no = 5;
                npc.ym = -1535;
                if (npc.x < MyChar.gMC.x) {
                    npc.xm = 256;
                    break;
                }
                npc.xm = -256;
                break;
            }
            case 21: {
                switch (++npc.act_wait) {
                    case 30: 
                    case 40: 
                    case 50: {
                        npc.ani_no = 6;
                        char deg = (char)Triangle.GetArktan(npc.x - MyChar.gMC.x, npc.y - 5120 - MyChar.gMC.y);
                        int ym = Triangle.GetSin(deg) * 4;
                        int xm = Triangle.GetCos(deg) * 4;
                        NpChar.SetNpChar(277, npc.x, npc.y - 5120, xm, ym, 0, null, 256);
                        Sound.PlaySoundObject(39, 1);
                        break;
                    }
                    case 34: 
                    case 44: {
                        npc.ani_no = 5;
                    }
                }
                if (npc.act_wait > 53) {
                    npc.ani_no = 7;
                }
                if ((npc.flag & 8) == 0) break;
                npc.act_no = 22;
                npc.act_wait = 0;
                npc.ani_no = 2;
                Frame.SetQuake(10);
                Sound.PlaySoundObject(26, 1);
                break;
            }
            case 22: {
                npc.xm /= 2;
                if (++npc.act_wait <= 22) break;
                npc.act_no = 10;
                break;
            }
            case 50: {
                npc.bits = (char)(npc.bits & 0xFFFFFFDF);
                npc.damage = 0;
                if ((npc.flag & 8) == 0) break;
                npc.act_no = 51;
                npc.ani_no = 2;
                Frame.SetQuake(10);
                NpChar.SetExpObjects(npc.x, npc.y, 19);
                NpChar.SetDestroyNpChar(npc.x, npc.y, npc.view.back, 8);
                Sound.PlaySoundObject(72, 1);
                break;
            }
            case 51: {
                npc.xm = npc.xm * 7 / 8;
                npc.ani_no = 8;
            }
        }
        npc.ym += 32;
        if (npc.ym > 1535) {
            npc.ym = 1535;
        }
        npc.x += npc.xm;
        npc.y += npc.ym;
        if (npc.act_no < 50) {
            npc.direct = npc.x < MyChar.gMC.x ? 2 : 0;
        }
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc276_rcLeft[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc276_rcRight[npc.ani_no]);
        }
    }

    public static void ActNpc277(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
            }
            case 1: {
                npc.x += npc.xm;
                npc.y += npc.ym;
                if ((npc.flag & 0xFF) != 0) {
                    NpChar.SetNpChar(4, npc.x, npc.y, 0, 0, 0, null, 256);
                    NpChar.SetNpChar(4, npc.x, npc.y, 0, 0, 0, null, 256);
                    NpChar.SetNpChar(4, npc.x, npc.y, 0, 0, 0, null, 256);
                    NpChar.VanishNpChar(npc);
                    return;
                }
                if (++npc.act_wait % 5 == 0) {
                    Sound.PlaySoundObject(110, 1);
                }
                if (++npc.ani_no <= 2) break;
                npc.ani_no = 0;
            }
        }
        npc.rect.copyFrom(ActNpc277_rc[npc.ani_no]);
    }

    public static void ActNpc278(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
                npc.ani_no = 0;
                npc.ani_wait = 0;
                npc.xm = 0;
            }
            case 1: {
                if (Game.Random(0, 60) == 1) {
                    npc.act_no = 2;
                    npc.act_wait = 0;
                    npc.ani_no = 1;
                }
                if (Game.Random(0, 60) != 1) break;
                npc.act_no = 10;
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
                npc.act_no = 11;
                npc.act_wait = Game.Random(0, 16);
                npc.ani_no = 0;
                npc.ani_wait = 0;
                npc.direct = Game.Random(0, 9) % 2 != 0 ? 0 : 2;
            }
            case 11: {
                if (npc.direct == 0 && (npc.flag & 1) != 0) {
                    npc.direct = 2;
                } else if (npc.direct == 2 && (npc.flag & 4) != 0) {
                    npc.direct = 0;
                }
                npc.xm = npc.direct == 0 ? -256 : 256;
                if (++npc.ani_wait > 4) {
                    npc.ani_wait = 0;
                    ++npc.ani_no;
                }
                if (npc.ani_no > 1) {
                    npc.ani_no = 0;
                }
                if (++npc.act_wait <= 32) break;
                npc.act_no = 0;
            }
        }
        npc.ym += 32;
        if (npc.ym > 1535) {
            npc.ym = 1535;
        }
        npc.x += npc.xm;
        npc.y += npc.ym;
        switch (npc.code_event) {
            case 200: {
                npc.rect.copyFrom(ActNpc278_rcPapa[npc.ani_no]);
                break;
            }
            case 210: {
                npc.rect.copyFrom(ActNpc278_rcMama[npc.ani_no]);
                break;
            }
            default: {
                npc.rect.copyFrom(ActNpc278_rcKodomo[npc.ani_no]);
            }
        }
    }

    public static void ActNpc279(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                switch (npc.direct) {
                    case 0: {
                        npc.act_no = 100;
                        npc.bits = (char)(npc.bits | 4);
                        npc.ani_no = 0;
                        break;
                    }
                    case 2: {
                        npc.act_no = 100;
                        npc.bits = (char)(npc.bits | 4);
                        npc.ani_no = 1;
                        npc.view.back = 4096;
                        npc.view.front = 4096;
                        npc.view.top = 4096;
                        npc.view.bottom = 4096;
                        npc.hit.back = 4096;
                        npc.hit.front = 4096;
                        npc.hit.top = 4096;
                        npc.hit.bottom = 4096;
                        break;
                    }
                    case 1: {
                        npc.ani_no = 0;
                        npc.act_no = 10;
                    }
                }
                if (npc.direct != 1) break;
            }
            case 10: {
                npc.act_no = 11;
                npc.act_wait = 16;
            }
            case 11: {
                npc.act_wait -= 2;
                if (npc.act_wait > 0) break;
                npc.act_no = 100;
                npc.bits = (char)(npc.bits | 4);
                break;
            }
            case 100: {
                npc.ym += 64;
                if (npc.ym > 1792) {
                    npc.ym = 1792;
                }
                if (npc.y > 65536) {
                    npc.bits = (char)(npc.bits & 0xFFFFFFF7);
                }
                if ((npc.flag & 8) == 0) break;
                npc.ym = -512;
                npc.act_no = 110;
                npc.bits = (char)(npc.bits | 8);
                Sound.PlaySoundObject(26, 1);
                Frame.SetQuake(10);
                for (int i = 0; i < 4; ++i) {
                    NpChar.SetNpChar(4, npc.x + Game.Random(-12, 12) * 512, npc.y + 8192, Game.Random(-341, 341), Game.Random(-1536, 0), 0, null, 256);
                }
                break;
            }
            case 110: {
                npc.ym += 64;
                if (npc.y <= Map.gMap.length * 512 * 16 + 16384) break;
                npc.cond = 0;
                return;
            }
        }
        npc.damage = MyChar.gMC.y > npc.y ? 10 : 0;
        npc.y += npc.ym;
        npc.rect.copyFrom(ActNpc279_rc[npc.ani_no]);
        if (npc.act_no == 11) {
            npc.rect.top += npc.act_wait;
            npc.rect.bottom -= npc.act_wait;
            npc.view.top = (16 - npc.act_wait) * 512;
        }
    }
}
