/*
 * Decompiled with CFR 0.152.
 */
package jp.studiopixel.doukutsu;

import jp.studiopixel.doukutsu.Caret;
import jp.studiopixel.doukutsu.Game;
import jp.studiopixel.doukutsu.MyChar;
import jp.studiopixel.doukutsu.NpChar;
import jp.studiopixel.doukutsu.RECT;
import jp.studiopixel.doukutsu.Sound;
import jp.studiopixel.doukutsu.Triangle;

public class NpcAct220 {
    private static final RECT[] ActNpc220_rcLeft = new RECT[]{new RECT(0, 64, 16, 80), new RECT(16, 64, 32, 80)};
    private static final RECT[] ActNpc220_rcRight = new RECT[]{new RECT(0, 80, 16, 96), new RECT(16, 80, 32, 96)};
    private static final RECT[] ActNpc221_rcLeft = new RECT[]{new RECT(0, 64, 16, 80), new RECT(16, 64, 32, 80), new RECT(32, 64, 48, 80), new RECT(0, 64, 16, 80), new RECT(48, 64, 64, 80), new RECT(0, 64, 16, 80)};
    private static final RECT[] ActNpc221_rcRight = new RECT[]{new RECT(0, 80, 16, 96), new RECT(16, 80, 32, 96), new RECT(32, 80, 48, 96), new RECT(0, 80, 16, 96), new RECT(48, 80, 64, 96), new RECT(0, 80, 16, 96)};
    private static final RECT ActNpc222_rc = new RECT(96, 168, 112, 200);
    private static final RECT[] ActNpc223_rcLeft = new RECT[]{new RECT(80, 192, 96, 216), new RECT(96, 192, 112, 216), new RECT(112, 192, 128, 216)};
    private static final RECT[] ActNpc223_rcRight = new RECT[]{new RECT(80, 216, 96, 240), new RECT(96, 216, 112, 240), new RECT(112, 216, 128, 240)};
    private static final RECT[] ActNpc224_rcLeft = new RECT[]{new RECT(112, 32, 128, 48), new RECT(128, 32, 144, 48)};
    private static final RECT[] ActNpc224_rcRight = new RECT[]{new RECT(112, 48, 128, 64), new RECT(128, 48, 144, 64)};
    private static final RECT[] ActNpc225_rcLeft = new RECT[]{new RECT(64, 64, 80, 80), new RECT(80, 64, 96, 80)};
    private static final RECT[] ActNpc225_rcRight = new RECT[]{new RECT(64, 80, 80, 96), new RECT(80, 80, 96, 96)};
    private static final RECT[] ActNpc226_rcRight = new RECT[]{new RECT(256, 56, 272, 80), new RECT(272, 56, 288, 80), new RECT(288, 56, 304, 80), new RECT(256, 56, 272, 80), new RECT(304, 56, 320, 80), new RECT(256, 56, 272, 80), new RECT(240, 56, 256, 80)};
    private static final RECT ActNpc227_rc = new RECT(208, 32, 224, 48);
    private static final RECT[] ActNpc228_rcLeft = new RECT[]{new RECT(0, 0, 32, 40), new RECT(32, 0, 64, 40), new RECT(64, 0, 96, 40), new RECT(96, 0, 128, 40)};
    private static final RECT[] ActNpc228_rcRight = new RECT[]{new RECT(0, 40, 32, 80), new RECT(32, 40, 64, 80), new RECT(64, 40, 96, 80), new RECT(96, 40, 128, 80)};
    private static final RECT[] ActNpc229_rc = new RECT[]{new RECT(0, 96, 48, 112), new RECT(0, 112, 48, 128)};
    private static final RECT[] ActNpc230_rc = new RECT[]{new RECT(48, 96, 96, 128), new RECT(96, 96, 144, 128)};
    private static final RECT[] ActNpc231_rc = new RECT[]{new RECT(176, 32, 208, 48), new RECT(176, 48, 208, 64)};
    private static final RECT[] ActNpc232_rcLeft = new RECT[]{new RECT(128, 0, 160, 32), new RECT(160, 0, 192, 32), new RECT(192, 0, 224, 32)};
    private static final RECT[] ActNpc232_rcRight = new RECT[]{new RECT(128, 32, 160, 64), new RECT(160, 32, 192, 64), new RECT(192, 32, 224, 64)};
    private static final RECT[] ActNpc233_rcLeft = new RECT[]{new RECT(256, 0, 272, 16), new RECT(272, 0, 288, 16), new RECT(288, 0, 304, 16), new RECT(304, 0, 320, 16)};
    private static final RECT[] ActNpc233_rcRight = new RECT[]{new RECT(256, 16, 272, 32), new RECT(272, 16, 288, 32), new RECT(288, 16, 304, 32), new RECT(304, 16, 320, 32)};
    private static final RECT[] ActNpc234_rc = new RECT[]{new RECT(144, 96, 192, 112), new RECT(144, 112, 192, 128)};
    private static final RECT[] ActNpc235_rcLeft = new RECT[]{new RECT(192, 96, 208, 112), new RECT(208, 96, 224, 112), new RECT(224, 96, 240, 112), new RECT(192, 96, 208, 112)};
    private static final RECT[] ActNpc235_rcRight = new RECT[]{new RECT(192, 112, 208, 128), new RECT(208, 112, 224, 128), new RECT(224, 112, 240, 128), new RECT(192, 112, 208, 128)};
    private static final RECT[] ActNpc236_rcLeft = new RECT[]{new RECT(128, 64, 152, 88), new RECT(152, 64, 176, 88), new RECT(176, 64, 200, 88), new RECT(200, 64, 224, 88), new RECT(224, 64, 248, 88), new RECT(248, 64, 272, 88)};
    private static final RECT[] ActNpc236_rcRight = new RECT[]{new RECT(128, 88, 152, 112), new RECT(152, 88, 176, 112), new RECT(176, 88, 200, 112), new RECT(200, 88, 224, 112), new RECT(224, 88, 248, 112), new RECT(248, 88, 272, 112)};
    private static final RECT ActNpc237_rc = new RECT(312, 32, 320, 40);
    private static final RECT[] ActNpc238_rc = new RECT[]{new RECT(184, 200, 208, 216), new RECT(208, 200, 232, 216), new RECT(232, 200, 256, 216)};
    private static final RECT ActNpc239_rcLeft = new RECT(192, 48, 256, 80);
    private static final RECT ActNpc239_rcRight = new RECT(96, 112, 144, 144);

    public static void ActNpc220(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
                npc.ani_no = 0;
                npc.ani_wait = 0;
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
            }
        }
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc220_rcLeft[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc220_rcRight[npc.ani_no]);
        }
    }

    public static void ActNpc221(NpChar.NPCHAR npc) {
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
                npc.ani_no = 2;
                npc.ani_wait = 0;
                npc.direct = Game.Random(0, 9) % 2 != 0 ? 0 : 2;
            }
            case 11: {
                if (npc.direct == 0 && (npc.flag & 1) != 0) {
                    npc.direct = 2;
                } else if (npc.direct == 2 && (npc.flag & 4) != 0) {
                    npc.direct = 0;
                }
                npc.xm = npc.direct == 0 ? -512 : 512;
                if (++npc.ani_wait > 4) {
                    npc.ani_wait = 0;
                    ++npc.ani_no;
                }
                if (npc.ani_no > 5) {
                    npc.ani_no = 2;
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
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc221_rcLeft[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc221_rcRight[npc.ani_no]);
        }
    }

    public static void ActNpc222(NpChar.NPCHAR npc) {
        if (npc.act_no == 0) {
            ++npc.act_no;
            npc.y -= 4096;
        }
        npc.rect.copyFrom(ActNpc222_rc);
    }

    public static void ActNpc223(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
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
            case 3: {
                npc.ani_no = 2;
            }
        }
        if (npc.act_no < 2 && MyChar.gMC.y < npc.y + 8192 && MyChar.gMC.y > npc.y - 8192) {
            npc.direct = MyChar.gMC.x < npc.x ? 0 : 2;
        }
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc223_rcLeft[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc223_rcRight[npc.ani_no]);
        }
    }

    public static void ActNpc224(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
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
        if (npc.act_no < 2 && MyChar.gMC.y < npc.y + 8192 && MyChar.gMC.y > npc.y - 8192) {
            npc.direct = MyChar.gMC.x < npc.x ? 0 : 2;
        }
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc224_rcLeft[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc224_rcRight[npc.ani_no]);
        }
    }

    public static void ActNpc225(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
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
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc225_rcLeft[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc225_rcRight[npc.ani_no]);
        }
    }

    public static void ActNpc226(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
                npc.ani_no = 0;
                npc.ani_wait = 0;
                npc.xm = 0;
            }
            case 1: {
                if (Game.Random(0, 60) != 1) break;
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
                npc.act_no = 11;
                npc.ani_no = 2;
                npc.ani_wait = 0;
            }
            case 11: {
                npc.xm = 512;
                if (++npc.ani_wait > 4) {
                    npc.ani_wait = 0;
                    ++npc.ani_no;
                }
                if (npc.ani_no > 5) {
                    npc.ani_no = 2;
                }
                ++npc.act_wait;
                break;
            }
            case 20: {
                npc.xm = 0;
                npc.ani_no = 6;
            }
        }
        npc.ym += 32;
        if (npc.ym > 1535) {
            npc.ym = 1535;
        }
        npc.x += npc.xm;
        npc.y += npc.ym;
        npc.rect.copyFrom(ActNpc226_rcRight[npc.ani_no]);
    }

    public static void ActNpc227(NpChar.NPCHAR npc) {
        npc.rect.copyFrom(ActNpc227_rc);
    }

    public static void ActNpc228(NpChar.NPCHAR npc) {
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
                if (++npc.ani_wait > 50) {
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
                npc.act_wait = 0;
            }
            case 11: {
                if (++npc.act_wait <= 10) break;
                npc.act_no = 12;
                npc.ani_no = 3;
                npc.ym = -1536;
                if (npc.direct == 0) {
                    npc.xm = -512;
                    break;
                }
                npc.xm = 512;
                break;
            }
            case 12: {
                if ((npc.flag & 8) == 0) break;
                npc.ani_no = 2;
                npc.act_no = 13;
                npc.act_wait = 0;
                break;
            }
            case 13: {
                npc.xm /= 2;
                if (++npc.act_wait <= 10) break;
                npc.act_no = 1;
            }
        }
        npc.ym += 64;
        if (npc.ym > 1535) {
            npc.ym = 1535;
        }
        npc.x += npc.xm;
        npc.y += npc.ym;
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc228_rcLeft[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc228_rcRight[npc.ani_no]);
        }
    }

    public static void ActNpc229(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
                npc.y -= 8192;
            }
        }
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc229_rc[0]);
        } else {
            npc.rect.copyFrom(ActNpc229_rc[1]);
        }
    }

    public static void ActNpc230(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
                npc.x -= 8192;
                npc.y -= 8192;
            }
        }
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc230_rc[0]);
        } else {
            npc.rect.copyFrom(ActNpc230_rc[1]);
        }
    }

    public static void ActNpc231(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
            }
            case 1: {
                npc.ani_no = 0;
                break;
            }
            case 10: {
                npc.act_no = 11;
                npc.act_wait = 0;
            }
            case 11: {
                ++npc.act_wait;
                npc.ym += 8;
                if ((npc.flag & 8) == 0) break;
                if (npc.act_wait < 10) {
                    npc.act_no = 12;
                    break;
                }
                npc.act_no = 1;
                break;
            }
            case 12: {
                int i;
                npc.bits = (char)(npc.bits & 0xFFFFDFFF);
                npc.act_no = 13;
                npc.act_wait = 0;
                npc.ani_no = 1;
                for (i = 0; i < 10; ++i) {
                    NpChar.SetNpChar(4, npc.x + Game.Random(-16, 16) * 512, npc.y + Game.Random(-8, 8) * 512, 0, 0, 0, null, 256);
                    Sound.PlaySoundObject(12, 1);
                }
            }
            case 13: {
                int i;
                npc.ym -= 8;
                ++npc.act_wait;
                if (npc.act_wait % 2 == 0) {
                    Caret.SetCaret(npc.x - 5120, npc.y + 4096, 7, 3);
                }
                if (npc.act_wait % 2 == 1) {
                    Caret.SetCaret(npc.x + 5120, npc.y + 4096, 7, 3);
                }
                if (npc.act_wait % 4 == 1) {
                    Sound.PlaySoundObject(34, 1);
                }
                if ((npc.flag & 2) == 0 && (MyChar.gMC.flag & 2) == 0 && npc.act_wait <= 450) break;
                if ((npc.flag & 2) != 0 || (MyChar.gMC.flag & 2) != 0) {
                    npc.ym = 0;
                }
                npc.act_no = 15;
                for (i = 0; i < 6; ++i) {
                    NpChar.SetNpChar(4, npc.x + Game.Random(-16, 16) * 512, npc.y + Game.Random(-8, 8) * 512, 0, 0, 0, null, 256);
                    Sound.PlaySoundObject(12, 1);
                }
                break;
            }
            case 15: {
                npc.ym += 8;
                ++npc.act_wait;
                if (npc.ym < 0) {
                    if (npc.act_wait % 8 == 0) {
                        Caret.SetCaret(npc.x - 5120, npc.y + 4096, 7, 3);
                    }
                    if (npc.act_wait % 8 == 4) {
                        Caret.SetCaret(npc.x + 5120, npc.y + 4096, 7, 3);
                    }
                    if (npc.act_wait % 16 == 1) {
                        Sound.PlaySoundObject(34, 1);
                    }
                }
                if ((npc.flag & 8) == 0) break;
                npc.bits = (char)(npc.bits | 0x2000);
                npc.act_no = 1;
                npc.ani_no = 0;
            }
        }
        if (npc.ym < -1535) {
            npc.ym = -1535;
        }
        if (npc.ym > 1535) {
            npc.ym = 1535;
        }
        npc.y += npc.ym;
        npc.rect.copyFrom(ActNpc231_rc[npc.ani_no]);
    }

    public static void ActNpc232(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
                npc.tgt_x = npc.x;
                npc.tgt_y = npc.y;
                npc.ym = 512;
                for (int i = 0; i < 8; ++i) {
                    NpChar.SetNpChar(233, npc.x, npc.y, 0, 0, npc.direct, npc, 256);
                }
            }
            case 1: {
                if (npc.xm < 0 && (npc.flag & 1) != 0) {
                    npc.direct = 2;
                }
                if (npc.xm > 0 && (npc.flag & 4) != 0) {
                    npc.direct = 0;
                }
                npc.xm = npc.direct == 0 ? -256 : 256;
                npc.ym = npc.y < npc.tgt_y ? (npc.ym += 8) : (npc.ym -= 8);
                if (npc.ym > 512) {
                    npc.ym = 512;
                }
                if (npc.ym < -512) {
                    npc.ym = -512;
                }
                if (++npc.ani_wait > 5) {
                    npc.ani_wait = 0;
                    ++npc.ani_no;
                }
                if (npc.ani_no <= 2) break;
                npc.ani_no = 0;
            }
        }
        npc.y += npc.ym;
        npc.x += npc.xm;
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc232_rcLeft[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc232_rcRight[npc.ani_no]);
        }
    }

    public static void ActNpc233(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
                char deg = (char)Game.Random(0, 255);
                npc.xm = Triangle.GetCos(deg);
                deg = (char)Game.Random(0, 255);
                npc.ym = Triangle.GetSin(deg);
                npc.count1 = 120;
                npc.count2 = Game.Random(-32, 32) * 512;
            }
            case 1: {
                if (npc.pNpc.code_char == 232) {
                    npc.tgt_x = npc.pNpc.x;
                    npc.tgt_y = npc.pNpc.y;
                    npc.direct = npc.pNpc.direct;
                }
                if (npc.tgt_x < npc.x) {
                    npc.xm -= 8;
                }
                if (npc.tgt_x > npc.x) {
                    npc.xm += 8;
                }
                if (npc.tgt_y + npc.count2 < npc.y) {
                    npc.ym -= 32;
                }
                if (npc.tgt_y + npc.count2 > npc.y) {
                    npc.ym += 32;
                }
                if (npc.xm > 1024) {
                    npc.xm = 1024;
                }
                if (npc.xm < -1024) {
                    npc.xm = -1024;
                }
                if (npc.ym > 1024) {
                    npc.ym = 1024;
                }
                if (npc.ym < -1024) {
                    npc.ym = -1024;
                }
                if (npc.count1 < 120) {
                    ++npc.count1;
                    break;
                }
                if (npc.x - 4096 >= MyChar.gMC.x || npc.x + 4096 <= MyChar.gMC.x || npc.y >= MyChar.gMC.y || npc.y + 90112 <= MyChar.gMC.y) break;
                npc.xm /= 4;
                npc.ym = 0;
                npc.act_no = 3;
                npc.bits = (char)(npc.bits & 0xFFFFFFF7);
                break;
            }
            case 3: {
                npc.ym += 64;
                if (npc.ym > 1535) {
                    npc.ym = 1535;
                }
                if ((npc.flag & 8) == 0) break;
                npc.ym = 0;
                npc.xm *= 2;
                npc.count1 = 0;
                npc.act_no = 1;
                npc.bits = (char)(npc.bits | 8);
            }
        }
        npc.x += npc.xm;
        npc.y += npc.ym;
        if (npc.act_no == 3) {
            npc.ani_no = 3;
        } else {
            if (++npc.ani_wait > 1) {
                npc.ani_wait = 0;
                ++npc.ani_no;
            }
            if (npc.ani_no > 2) {
                npc.ani_no = 0;
            }
        }
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc233_rcLeft[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc233_rcRight[npc.ani_no]);
        }
    }

    public static void ActNpc234(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
                npc.y += 8192;
            }
        }
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc234_rc[0]);
        } else {
            npc.rect.copyFrom(ActNpc234_rc[1]);
        }
    }

    public static void ActNpc235(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
                npc.ani_no = 0;
                npc.ani_wait = 0;
                npc.xm = 0;
            }
            case 1: {
                if (Game.Random(0, 30) == 1) {
                    npc.act_no = 2;
                    npc.act_wait = 0;
                    npc.ani_no = 1;
                }
                if (Game.Random(0, 30) != 1) break;
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
                npc.ani_no = 2;
                npc.ani_wait = 0;
                npc.direct = Game.Random(0, 9) % 2 != 0 ? 0 : 2;
            }
            case 11: {
                if (npc.direct == 0 && (npc.flag & 1) != 0) {
                    npc.direct = 2;
                } else if (npc.direct == 2 && (npc.flag & 4) != 0) {
                    npc.direct = 0;
                }
                npc.xm = npc.direct == 0 ? -1024 : 1024;
                if (++npc.ani_wait > 1) {
                    npc.ani_wait = 0;
                    ++npc.ani_no;
                }
                if (npc.ani_no > 3) {
                    npc.ani_no = 2;
                }
                if (++npc.act_wait <= 64) break;
                npc.act_no = 0;
            }
        }
        npc.ym += 32;
        if (npc.ym > 1535) {
            npc.ym = 1535;
        }
        npc.x += npc.xm;
        npc.y += npc.ym;
        npc.hit.top = npc.ani_no == 2 ? 2560 : 2048;
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc235_rcLeft[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc235_rcRight[npc.ani_no]);
        }
    }

    public static void ActNpc236(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
                npc.act_wait = Game.Random(0, 50);
                npc.tgt_x = npc.x;
                npc.tgt_y = npc.y;
                npc.ym = 0;
            }
            case 1: {
                if (npc.act_wait != 0) {
                    --npc.act_wait;
                    break;
                }
                npc.ym = 512;
                npc.act_no = 2;
                break;
            }
            case 2: {
                npc.direct = npc.x < MyChar.gMC.x ? 2 : 0;
                if (MyChar.gMC.x < npc.x + 65536 && MyChar.gMC.x > npc.x - 65536 && MyChar.gMC.y < npc.y + 16384 && MyChar.gMC.y > npc.y - 81920) {
                    ++npc.act_wait;
                }
                if (npc.act_wait > 80) {
                    npc.act_no = 10;
                    npc.act_wait = 0;
                }
                if (++npc.ani_wait > 1) {
                    npc.ani_wait = 0;
                    ++npc.ani_no;
                }
                if (npc.ani_no <= 1) break;
                npc.ani_no = 0;
                break;
            }
            case 10: {
                if (++npc.act_wait > 20) {
                    npc.act_wait = 0;
                    npc.act_no = 20;
                }
                if (++npc.ani_wait > 1) {
                    npc.ani_wait = 0;
                    ++npc.ani_no;
                }
                if (npc.ani_no <= 3) break;
                npc.ani_no = 2;
                break;
            }
            case 20: {
                if (++npc.act_wait > 60) {
                    npc.act_wait = 0;
                    npc.act_no = 2;
                }
                if (npc.act_wait % 10 == 3) {
                    Sound.PlaySoundObject(39, 1);
                    if (npc.direct == 0) {
                        NpChar.SetNpChar(237, npc.x - 4096, npc.y - 4096, -1024, -1024, 0, null, 256);
                    } else {
                        NpChar.SetNpChar(237, npc.x + 4096, npc.y - 4096, 1024, -1024, 0, null, 256);
                    }
                }
                if (++npc.ani_wait > 1) {
                    npc.ani_wait = 0;
                    ++npc.ani_no;
                }
                if (npc.ani_no <= 5) break;
                npc.ani_no = 4;
            }
        }
        npc.ym = npc.y < npc.tgt_y ? (npc.ym += 16) : (npc.ym -= 16);
        if (npc.ym > 256) {
            npc.ym = 256;
        }
        if (npc.ym < -256) {
            npc.ym = -256;
        }
        npc.y += npc.ym;
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc236_rcLeft[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc236_rcRight[npc.ani_no]);
        }
    }

    public static void ActNpc237(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
            }
            case 1: {
                boolean bHit = false;
                ++npc.act_wait;
                if ((npc.flag & 0xFF) != 0) {
                    bHit = true;
                }
                if (npc.act_wait > 10 && (npc.flag & 0x100) != 0) {
                    bHit = true;
                }
                if (!bHit) break;
                for (int i = 0; i < 5; ++i) {
                    Caret.SetCaret(npc.x, npc.y, 1, 0);
                }
                Sound.PlaySoundObject(21, 1);
                npc.cond = 0;
                return;
            }
        }
        npc.ym += 32;
        if (npc.ym > 1535) {
            npc.ym = 1535;
        }
        npc.x += npc.xm;
        npc.y += npc.ym;
        npc.rect.copyFrom(ActNpc237_rc);
    }

    public static void ActNpc238(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
                npc.tgt_x = npc.x;
                npc.tgt_y = npc.y;
                npc.view.front = 8192;
                npc.view.back = 4096;
            }
            case 1: {
                if (npc.direct == 0 && MyChar.gMC.x < npc.x && MyChar.gMC.x > npc.x - 98304 && MyChar.gMC.y > npc.y - 2048 && MyChar.gMC.y < npc.y + 4096) {
                    npc.act_no = 10;
                    npc.act_wait = 0;
                    npc.ani_no = 2;
                }
                if (npc.direct != 2 || MyChar.gMC.x <= npc.x || MyChar.gMC.x >= npc.x + 98304 || MyChar.gMC.y <= npc.y - 2048 || MyChar.gMC.y >= npc.y + 4096) break;
                npc.act_no = 10;
                npc.act_wait = 0;
                npc.ani_no = 2;
                break;
            }
            case 10: {
                npc.damage = 127;
                npc.x = npc.direct == 0 ? (npc.x -= 3072) : (npc.x += 3072);
                if (++npc.act_wait != 8) break;
                npc.act_no = 20;
                npc.act_wait = 0;
                for (int i = 0; i < 4; ++i) {
                    NpChar.SetNpChar(4, npc.x + Game.Random(-16, 16) * 512, npc.y + Game.Random(-8, 8) * 512, 0, 0, 0, null, 256);
                    Sound.PlaySoundObject(12, 1);
                }
                break;
            }
            case 20: {
                npc.damage = 0;
                if (++npc.act_wait <= 50) break;
                npc.act_wait = 0;
                npc.act_no = 30;
                break;
            }
            case 30: {
                npc.damage = 0;
                npc.ani_no = 1;
                if (++npc.act_wait == 12) {
                    npc.act_no = 1;
                    npc.act_wait = 0;
                    npc.ani_no = 0;
                }
                if (npc.direct == 0) {
                    npc.x += 2048;
                    break;
                }
                npc.x -= 2048;
            }
        }
        npc.hit.back = npc.direct == 0 && MyChar.gMC.x < npc.x ? 8192 : (npc.direct == 2 && MyChar.gMC.x > npc.x ? 8192 : 4096);
        npc.rect.copyFrom(ActNpc238_rc[npc.ani_no]);
    }

    public static void ActNpc239(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
                if (npc.direct == 0) {
                    npc.x += 4096;
                    npc.y += 8192;
                    break;
                }
                npc.view.front = 12288;
                npc.view.back = 12288;
                npc.view.top = 4096;
                npc.view.back = 12288;
            }
        }
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc239_rcLeft);
        } else {
            npc.rect.copyFrom(ActNpc239_rcRight);
        }
    }
}
