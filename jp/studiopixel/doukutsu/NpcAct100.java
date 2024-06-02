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

public class NpcAct100 {
    private static final RECT[] ActNpc100_rc = new RECT[]{new RECT(272, 48, 288, 64), new RECT(272, 48, 288, 64)};
    private static final RECT[] ActNpc101_rc = new RECT[]{new RECT(240, 136, 256, 152), new RECT(240, 136, 256, 152), new RECT(256, 136, 272, 152)};
    private static final RECT[] ActNpc102_rect = new RECT[]{new RECT(208, 120, 224, 136), new RECT(224, 120, 240, 136), new RECT(240, 120, 256, 136), new RECT(256, 120, 272, 136)};
    private static final RECT[] ActNpc103_rcLeft = new RECT[]{new RECT(192, 96, 208, 120), new RECT(208, 96, 224, 120), new RECT(224, 96, 240, 120)};
    private static final RECT[] ActNpc103_rcRight = new RECT[]{new RECT(192, 120, 208, 144), new RECT(208, 120, 224, 144), new RECT(224, 120, 240, 144)};
    private static final RECT[] ActNpc104_rcLeft = new RECT[]{new RECT(0, 112, 32, 144), new RECT(32, 112, 64, 144), new RECT(64, 112, 96, 144)};
    private static final RECT[] ActNpc104_rcRight = new RECT[]{new RECT(0, 144, 32, 176), new RECT(32, 144, 64, 176), new RECT(64, 144, 96, 176)};
    private static final RECT[] ActNpc105_rect = new RECT[]{new RECT(128, 32, 144, 48), new RECT(128, 32, 128, 32)};
    private static final RECT[] ActNpc107_rcPoweron = new RECT[]{new RECT(144, 0, 160, 24), new RECT(160, 0, 176, 24), new RECT(176, 0, 192, 24), new RECT(192, 0, 208, 24), new RECT(208, 0, 224, 24), new RECT(224, 0, 240, 24), new RECT(176, 0, 192, 24), new RECT(192, 0, 208, 24), new RECT(208, 0, 224, 24), new RECT(192, 0, 208, 24)};
    private static final RECT[] ActNpc108_rcLeft = new RECT[]{new RECT(96, 48, 112, 64), new RECT(112, 48, 128, 64), new RECT(128, 48, 144, 64)};
    private static final RECT[] ActNpc109_rcLeft = new RECT[]{new RECT(240, 0, 256, 24), new RECT(256, 0, 272, 24)};
    private static final RECT[] ActNpc109_rcRight = new RECT[]{new RECT(240, 24, 256, 48), new RECT(256, 24, 272, 48)};
    private static final RECT[] ActNpc110_rcLeft = new RECT[]{new RECT(96, 128, 112, 144), new RECT(112, 128, 128, 144), new RECT(128, 128, 144, 144)};
    private static final RECT[] ActNpc110_rcRight = new RECT[]{new RECT(96, 144, 112, 160), new RECT(112, 144, 128, 160), new RECT(128, 144, 144, 160)};
    private static final RECT[] ActNpc111_rcLeft = new RECT[]{new RECT(0, 0, 16, 16), new RECT(16, 0, 32, 16)};
    private static final RECT[] ActNpc111_rcRight = new RECT[]{new RECT(0, 16, 16, 32), new RECT(16, 16, 32, 32)};
    private static final RECT[] ActNpc112_rcLeft = new RECT[]{new RECT(0, 0, 16, 16), new RECT(16, 0, 32, 16)};
    private static final RECT[] ActNpc112_rcRight = new RECT[]{new RECT(0, 16, 16, 32), new RECT(16, 16, 32, 32)};
    private static final RECT[] ActNpc113_rcLeft = new RECT[]{new RECT(224, 0, 240, 16), new RECT(240, 0, 256, 16), new RECT(256, 0, 272, 16), new RECT(224, 0, 240, 16), new RECT(272, 0, 288, 16), new RECT(224, 0, 240, 16), new RECT(288, 0, 304, 16)};
    private static final RECT[] ActNpc113_rcRight = new RECT[]{new RECT(224, 16, 240, 32), new RECT(240, 16, 256, 32), new RECT(256, 16, 272, 32), new RECT(224, 16, 240, 32), new RECT(272, 16, 288, 32), new RECT(224, 16, 240, 32), new RECT(288, 16, 304, 32)};
    private static final RECT[] ActNpc114_rcLeft = new RECT[]{new RECT(144, 112, 160, 136), new RECT(160, 112, 176, 136), new RECT(176, 112, 192, 136)};
    private static final RECT[] ActNpc115_rcLeft = new RECT[]{new RECT(0, 120, 24, 144), new RECT(24, 120, 48, 144), new RECT(48, 120, 72, 144), new RECT(72, 120, 96, 144), new RECT(96, 120, 120, 144), new RECT(120, 120, 144, 144)};
    private static final RECT[] ActNpc115_rcRight = new RECT[]{new RECT(0, 144, 24, 168), new RECT(24, 144, 48, 168), new RECT(48, 144, 72, 168), new RECT(72, 144, 96, 168), new RECT(96, 144, 120, 168), new RECT(120, 144, 144, 168)};
    private static final RECT ActNpc116_rc = new RECT(272, 184, 320, 200);
    private static final RECT[] ActNpc117_rcLeft = new RECT[]{new RECT(0, 96, 16, 112), new RECT(16, 96, 32, 112), new RECT(0, 96, 16, 112), new RECT(32, 96, 48, 112), new RECT(0, 96, 16, 112), new RECT(176, 96, 192, 112), new RECT(112, 96, 128, 112), new RECT(160, 96, 176, 112), new RECT(144, 96, 160, 112), new RECT(48, 96, 64, 112)};
    private static final RECT[] ActNpc117_rcRight = new RECT[]{new RECT(0, 112, 16, 128), new RECT(16, 112, 32, 128), new RECT(0, 112, 16, 128), new RECT(32, 112, 48, 128), new RECT(0, 112, 16, 128), new RECT(176, 112, 192, 128), new RECT(112, 112, 128, 128), new RECT(160, 112, 176, 128), new RECT(144, 112, 160, 128), new RECT(48, 112, 64, 128)};
    private static final RECT[] ActNpc118_rcLeft = new RECT[]{new RECT(0, 32, 32, 56), new RECT(32, 32, 64, 56), new RECT(64, 32, 96, 56), new RECT(96, 32, 128, 56), new RECT(0, 32, 32, 56), new RECT(128, 32, 160, 56), new RECT(0, 32, 32, 56), new RECT(0, 32, 32, 56), new RECT(160, 32, 192, 56)};
    private static final RECT[] ActNpc118_rcRight = new RECT[]{new RECT(0, 56, 32, 80), new RECT(32, 56, 64, 80), new RECT(64, 56, 96, 80), new RECT(96, 56, 128, 80), new RECT(0, 56, 32, 80), new RECT(128, 56, 160, 80), new RECT(0, 56, 32, 80), new RECT(0, 56, 32, 80), new RECT(160, 56, 192, 80)};
    private static final RECT ActNpc119_rc = new RECT(248, 184, 272, 200);

    public static void ActNpc100(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.y += 8192;
                npc.act_no = 1;
            }
        }
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc100_rc[0]);
        } else {
            npc.rect.copyFrom(ActNpc100_rc[1]);
        }
    }

    public static void ActNpc101(NpChar.NPCHAR npc) {
        if (++npc.ani_wait > 3) {
            npc.ani_wait = 0;
            ++npc.ani_no;
        }
        if (npc.ani_no > 2) {
            npc.ani_no = 0;
        }
        npc.rect.copyFrom(ActNpc101_rc[npc.ani_no]);
    }

    public static void ActNpc102(NpChar.NPCHAR npc) {
        if (npc.act_no == 0) {
            npc.act_no = 1;
            npc.y += 4096;
        }
        if (++npc.ani_wait > 0) {
            npc.ani_wait = 0;
            ++npc.ani_no;
        }
        if (npc.ani_no > 3) {
            npc.ani_no = 0;
        }
        npc.rect.copyFrom(ActNpc102_rect[npc.ani_no]);
    }

    public static void ActNpc103(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
            }
            case 1: {
                npc.xm = npc.direct == 0 ? (npc.xm -= 32) : (npc.xm += 32);
                if (++npc.ani_wait > 0) {
                    npc.ani_wait = 0;
                    ++npc.ani_no;
                }
                if (npc.ani_no <= 2) break;
                npc.ani_no = 0;
            }
        }
        npc.x += npc.xm;
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc103_rcLeft[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc103_rcRight[npc.ani_no]);
        }
        if (++npc.count1 > 100) {
            npc.cond = 0;
        }
        if (npc.count1 % 4 == 1) {
            Sound.PlaySoundObject(46, 1);
        }
    }

    public static void ActNpc104(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
                npc.act_wait = 0;
                npc.xm = 0;
                npc.ym = 0;
                if (npc.direct == 4) {
                    npc.direct = Game.Random(0, 1) != 0 ? 0 : 2;
                    npc.bits = (char)(npc.bits | 8);
                    npc.ani_no = 2;
                    npc.act_no = 3;
                    break;
                }
                npc.bits = (char)(npc.bits & 0xFFFFFFF7);
            }
            case 1: {
                ++npc.act_wait;
                if (Game.Random(0, 50) != 1) break;
                npc.act_no = 2;
                npc.act_wait = 0;
                npc.ani_no = 0;
                npc.ani_wait = 0;
                break;
            }
            case 2: {
                ++npc.act_wait;
                if (++npc.ani_wait > 2) {
                    npc.ani_wait = 0;
                    ++npc.ani_no;
                }
                if (npc.ani_no > 1) {
                    npc.ani_no = 0;
                }
                if (npc.act_wait <= 18) break;
                npc.act_no = 1;
                break;
            }
            case 3: {
                if (++npc.act_wait > 40) {
                    npc.bits = (char)(npc.bits & 0xFFFFFFF7);
                }
                if ((npc.flag & 8) == 0) break;
                npc.act_no = 0;
                npc.ani_no = 0;
                npc.act_wait = 0;
                break;
            }
            case 10: {
                npc.act_no = 11;
            }
            case 11: {
                if ((npc.flag & 1) != 0 && npc.xm < 0) {
                    npc.xm *= -1;
                    npc.direct = 2;
                }
                if ((npc.flag & 4) != 0 && npc.xm > 0) {
                    npc.xm *= -1;
                    npc.direct = 0;
                }
                if ((npc.flag & 8) == 0) break;
                npc.act_no = 0;
                npc.ani_no = 0;
                npc.act_wait = 0;
            }
        }
        boolean bJump = false;
        if (npc.act_no < 10 && npc.act_no != 3 && npc.act_wait > 10) {
            if (npc.shock != '\u0000') {
                bJump = true;
            }
            if (npc.x >= MyChar.gMC.x - 81920 && npc.x <= MyChar.gMC.x + 81920 && npc.y >= MyChar.gMC.y - 32768 && npc.y <= MyChar.gMC.y + 32768 && Game.Random(0, 50) == 2) {
                bJump = true;
            }
        }
        if (bJump) {
            npc.direct = npc.x < MyChar.gMC.x ? 2 : 0;
            npc.act_no = 10;
            npc.ani_no = 2;
            npc.ym = -1535;
            if ((MyChar.gMC.cond & 2) == 0) {
                Sound.PlaySoundObject(30, 1);
            }
            npc.xm = npc.direct == 0 ? -512 : 512;
        }
        npc.ym += 128;
        if (npc.ym > 1535) {
            npc.ym = 1535;
        }
        npc.x += npc.xm;
        npc.y += npc.ym;
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc104_rcLeft[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc104_rcRight[npc.ani_no]);
        }
    }

    public static void ActNpc105(NpChar.NPCHAR npc) {
        if (++npc.act_wait > 30) {
            npc.cond = 0;
        }
        if (npc.act_wait < 5) {
            npc.y -= 512;
        }
        npc.rect.copyFrom(ActNpc105_rect[npc.ani_no]);
    }

    public static void ActNpc106(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                NpChar.SetNpChar(105, npc.x, npc.y - 4096, 0, 0, 0, null, 384);
                npc.act_no = 1;
            }
        }
    }

    public static void ActNpc107(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
                if (npc.direct != 2) break;
                npc.ani_no = 5;
                break;
            }
            case 10: {
                npc.act_no = 11;
                npc.act_wait = 0;
                npc.ani_wait = 0;
                for (int i = 0; i < 4; ++i) {
                    NpChar.SetNpChar(4, npc.x, npc.y, Game.Random(-341, 341), Game.Random(-1536, 0), 0, null, 256);
                }
            }
            case 11: {
                if (++npc.ani_wait > 1) {
                    Sound.PlaySoundObject(43, 1);
                    npc.ani_wait = 0;
                    ++npc.ani_no;
                }
                if (npc.ani_no > 1) {
                    npc.ani_no = 0;
                }
                if (++npc.act_wait <= 100) break;
                npc.act_no = 12;
                break;
            }
            case 12: {
                npc.act_no = 13;
                npc.act_wait = 0;
                npc.ani_no = 1;
            }
            case 13: {
                if (++npc.act_wait <= 50) break;
                npc.act_no = 14;
                break;
            }
            case 14: {
                npc.act_no = 15;
                npc.act_wait = 0;
            }
            case 15: {
                if (npc.act_wait / 2 % 2 != 0) {
                    npc.x += 512;
                    Sound.PlaySoundObject(11, 1);
                } else {
                    npc.x -= 512;
                }
                if (++npc.act_wait <= 50) break;
                npc.act_no = 16;
                break;
            }
            case 16: {
                npc.act_no = 17;
                npc.act_wait = 0;
                npc.ani_no = 2;
                Sound.PlaySoundObject(12, 1);
                for (int i = 0; i < 8; ++i) {
                    NpChar.SetNpChar(4, npc.x, npc.y, Game.Random(-341, 341), Game.Random(-1536, 0), 0, null, 256);
                }
            }
            case 17: {
                if (++npc.act_wait <= 150) break;
                npc.act_no = 18;
                break;
            }
            case 18: {
                npc.act_no = 19;
                npc.act_wait = 0;
                npc.ani_no = 3;
                npc.ani_wait = 0;
            }
            case 19: {
                if (++npc.ani_wait > 3) {
                    npc.ani_wait = 0;
                    ++npc.ani_no;
                }
                if (npc.ani_no > 4) {
                    Sound.PlaySoundObject(11, 1);
                    npc.ani_no = 3;
                }
                if (++npc.act_wait <= 100) break;
                npc.act_no = 20;
                Sound.PlaySoundObject(12, 1);
                for (int i = 0; i < 4; ++i) {
                    NpChar.SetNpChar(4, npc.x, npc.y, Game.Random(-341, 341), Game.Random(-1536, 0), 0, null, 256);
                }
                break;
            }
            case 20: {
                npc.ani_no = 4;
                break;
            }
            case 21: {
                npc.act_no = 22;
                npc.ani_no = 5;
                Sound.PlaySoundObject(51, 1);
                break;
            }
            case 100: {
                npc.act_no = 101;
                npc.ani_no = 6;
                npc.ani_wait = 0;
            }
            case 101: {
                if (++npc.ani_wait > 4) {
                    npc.ani_wait = 0;
                    ++npc.ani_no;
                }
                if (npc.ani_no <= 9) break;
                npc.ani_no = 6;
                break;
            }
            case 110: {
                NpChar.SetDestroyNpChar(npc.x, npc.y, 8192, 16);
                npc.cond = 0;
            }
        }
        npc.rect.copyFrom(ActNpc107_rcPoweron[npc.ani_no]);
    }

    public static void ActNpc108(NpChar.NPCHAR npc) {
        if ((npc.flag & 0xFF) != 0) {
            Caret.SetCaret(npc.x, npc.y, 2, 0);
            npc.cond = 0;
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
        npc.rect.copyFrom(ActNpc108_rcLeft[npc.ani_no]);
        if (++npc.count1 > 300) {
            Caret.SetCaret(npc.x, npc.y, 2, 0);
            npc.cond = 0;
        }
    }

    public static void ActNpc109(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                if (--npc.act_wait != 0) {
                    npc.act_no = 1;
                }
                npc.ani_no = 0;
                npc.ani_wait = 0;
            }
            case 1: {
                if (Game.Random(0, 120) == 10) {
                    npc.act_no = 2;
                    npc.act_wait = 0;
                    npc.ani_no = 1;
                }
                if (npc.x - 16384 >= MyChar.gMC.x || npc.x + 16384 <= MyChar.gMC.x || npc.y - 16384 >= MyChar.gMC.y || npc.y + 8192 <= MyChar.gMC.y) break;
                if (npc.x > MyChar.gMC.x) {
                    npc.direct = 0;
                    break;
                }
                npc.direct = 2;
                break;
            }
            case 2: {
                if (++npc.act_wait <= 8) break;
                npc.act_no = 1;
                npc.ani_no = 0;
                break;
            }
            case 10: {
                npc.act_no = 0;
                Sound.PlaySoundObject(12, 1);
                for (int i = 0; i < 8; ++i) {
                    NpChar.SetNpChar(4, npc.x, npc.y, Game.Random(-341, 341), Game.Random(-1536, 0), 0, null, 256);
                }
                break;
            }
        }
        npc.ym += 64;
        if (npc.ym > 1535) {
            npc.ym = 1535;
        }
        npc.y += npc.ym;
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc109_rcLeft[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc109_rcRight[npc.ani_no]);
        }
    }

    public static void ActNpc110(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
                npc.act_wait = 0;
                npc.xm = 0;
                npc.ym = 0;
                if (npc.direct == 4) {
                    npc.direct = Game.Random(0, 1) != 0 ? 0 : 2;
                    npc.bits = (char)(npc.bits | 8);
                    npc.ani_no = 2;
                    npc.act_no = 3;
                    break;
                }
                npc.bits = (char)(npc.bits & 0xFFFFFFF7);
            }
            case 1: {
                ++npc.act_wait;
                if (Game.Random(0, 50) != 1) break;
                npc.act_no = 2;
                npc.act_wait = 0;
                npc.ani_no = 0;
                npc.ani_wait = 0;
                break;
            }
            case 2: {
                ++npc.act_wait;
                if (++npc.ani_wait > 2) {
                    npc.ani_wait = 0;
                    ++npc.ani_no;
                }
                if (npc.ani_no > 1) {
                    npc.ani_no = 0;
                }
                if (npc.act_wait <= 18) break;
                npc.act_no = 1;
                break;
            }
            case 3: {
                if (++npc.act_wait > 40) {
                    npc.bits = (char)(npc.bits & 0xFFFFFFF7);
                }
                if ((npc.flag & 8) == 0) break;
                npc.act_no = 0;
                npc.ani_no = 0;
                npc.act_wait = 0;
                break;
            }
            case 10: {
                npc.act_no = 11;
            }
            case 11: {
                if ((npc.flag & 1) != 0 && npc.xm < 0) {
                    npc.xm *= -1;
                    npc.direct = 2;
                }
                if ((npc.flag & 4) != 0 && npc.xm > 0) {
                    npc.xm *= -1;
                    npc.direct = 0;
                }
                if ((npc.flag & 8) == 0) break;
                npc.act_no = 0;
                npc.ani_no = 0;
                npc.act_wait = 0;
            }
        }
        boolean bJump = false;
        if (npc.act_no < 10 && npc.act_no != 3 && npc.act_wait > 10) {
            if (npc.shock != '\u0000') {
                bJump = true;
            }
            if (npc.x >= MyChar.gMC.x - 81920 && npc.x <= MyChar.gMC.x + 81920 && npc.y >= MyChar.gMC.y - 32768 && npc.y <= MyChar.gMC.y + 32768 && Game.Random(0, 50) == 2) {
                bJump = true;
            }
        }
        if (bJump) {
            npc.direct = npc.x < MyChar.gMC.x ? 2 : 0;
            npc.act_no = 10;
            npc.ani_no = 2;
            npc.ym = -767;
            Sound.PlaySoundObject(6, 1);
            npc.xm = npc.direct == 0 ? -256 : 256;
        }
        npc.ym += 128;
        if (npc.ym > 1535) {
            npc.ym = 1535;
        }
        npc.x += npc.xm;
        npc.y += npc.ym;
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc110_rcLeft[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc110_rcRight[npc.ani_no]);
        }
    }

    public static void ActNpc111(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
                npc.ani_no = 0;
                npc.y -= 8192;
                break;
            }
            case 1: {
                if (++npc.act_wait <= 20) break;
                npc.act_wait = 0;
                npc.act_no = 2;
                npc.ani_no = 1;
                npc.ym = -767;
                break;
            }
            case 2: {
                if (npc.ym > 0) {
                    npc.hit.bottom = 8192;
                }
                if ((npc.flag & 8) == 0) break;
                npc.act_no = 3;
                npc.act_wait = 0;
                npc.ani_no = 0;
                break;
            }
            case 3: {
                if (++npc.act_wait <= 40) break;
                npc.act_no = 4;
                npc.act_wait = 64;
                Sound.PlaySoundObject(29, 1);
                break;
            }
            case 4: {
                --npc.act_wait;
                npc.ani_no = 0;
                if (npc.act_wait != 0) break;
                npc.cond = 0;
            }
        }
        npc.ym += 64;
        npc.y += npc.ym;
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc111_rcLeft[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc111_rcRight[npc.ani_no]);
        }
        if ((MyChar.gMC.equip & 0x40) != 0) {
            npc.rect.top += 32;
            npc.rect.bottom += 32;
        }
        if (npc.act_no == 4) {
            npc.rect.bottom = npc.rect.top + npc.act_wait / 4;
            if (npc.act_wait / 2 % 2 != 0) {
                ++npc.rect.left;
            }
        }
    }

    public static void ActNpc112(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
                npc.ani_no = 0;
                npc.ani_wait = 0;
                npc.x += 8192;
                npc.y += 4096;
                Sound.PlaySoundObject(29, 1);
            }
            case 1: {
                if (++npc.act_wait != 64) break;
                npc.act_no = 2;
                npc.act_wait = 0;
                break;
            }
            case 2: {
                if (++npc.act_wait <= 20) break;
                npc.act_no = 3;
                npc.ani_no = 1;
                npc.hit.bottom = 4096;
                break;
            }
            case 3: {
                if ((npc.flag & 8) == 0) break;
                npc.act_no = 4;
                npc.act_wait = 0;
                npc.ani_no = 0;
            }
        }
        npc.ym += 64;
        npc.y += npc.ym;
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc112_rcLeft[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc112_rcRight[npc.ani_no]);
        }
        if ((MyChar.gMC.equip & 0x40) != 0) {
            npc.rect.top += 32;
            npc.rect.bottom += 32;
        }
        if (npc.act_no == 1) {
            npc.rect.bottom = npc.rect.top + npc.act_wait / 4;
            if (npc.act_wait / 2 % 2 != 0) {
                ++npc.rect.left;
            }
        }
    }

    public static void ActNpc113(NpChar.NPCHAR npc) {
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
                break;
            }
            case 3: {
                npc.act_no = 4;
                npc.ani_no = 2;
                npc.ani_wait = 0;
            }
            case 4: {
                if (++npc.ani_wait > 4) {
                    npc.ani_wait = 0;
                    ++npc.ani_no;
                }
                if (npc.ani_no > 5) {
                    npc.ani_no = 2;
                }
                if (npc.direct == 0) {
                    npc.x -= 512;
                    break;
                }
                npc.x += 512;
                break;
            }
            case 5: {
                npc.ani_no = 6;
                break;
            }
            case 30: {
                npc.act_no = 31;
                npc.ani_no = 0;
                npc.ani_wait = 0;
                npc.hit.bottom = 8192;
                npc.x -= 8192;
                npc.y += 4096;
                Sound.PlaySoundObject(29, 1);
            }
            case 31: {
                if (++npc.act_wait != 64) break;
                npc.act_no = 32;
                npc.act_wait = 0;
                break;
            }
            case 32: {
                if (++npc.act_wait <= 20) break;
                npc.act_no = 33;
                npc.ani_no = 1;
                npc.hit.bottom = 4096;
                break;
            }
            case 33: {
                if ((npc.flag & 8) == 0) break;
                npc.act_no = 34;
                npc.act_wait = 0;
                npc.ani_no = 0;
            }
        }
        npc.ym += 64;
        npc.y += npc.ym;
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc113_rcLeft[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc113_rcRight[npc.ani_no]);
        }
        if (npc.act_no == 31) {
            npc.rect.bottom = npc.rect.top + npc.act_wait / 4;
            if (npc.act_wait / 2 % 2 != 0) {
                ++npc.rect.left;
            }
        }
    }

    public static void ActNpc114(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
                npc.y -= 2048;
            }
            case 1: {
                if ((npc.flag & 8) != 0) break;
                npc.act_no = 10;
                npc.ani_wait = 0;
                npc.ani_no = 1;
                break;
            }
            case 10: {
                if (++npc.ani_wait > 2) {
                    npc.ani_wait = 0;
                    ++npc.ani_no;
                }
                if (npc.ani_no > 2) {
                    npc.ani_no = 2;
                }
                if (MyChar.gMC.y > npc.y) {
                    npc.bits = (char)(npc.bits & 0xFFFFFFBF);
                    npc.damage = 127;
                } else {
                    npc.bits = (char)(npc.bits | 0x40);
                    npc.damage = 0;
                }
                if ((npc.flag & 8) == 0) break;
                if (npc.ani_no > 1) {
                    for (int i = 0; i < 4; ++i) {
                        NpChar.SetNpChar(4, npc.x, npc.y, Game.Random(-341, 341), Game.Random(-1536, 0), 0, null, 256);
                    }
                    Sound.PlaySoundObject(26, 1);
                    Frame.SetQuake(10);
                }
                npc.act_no = 1;
                npc.ani_no = 0;
                npc.damage = 0;
                npc.bits = (char)(npc.bits | 0x40);
            }
        }
        npc.ym += 32;
        if (npc.ym > 1535) {
            npc.ym = 1535;
        }
        npc.y += npc.ym;
        npc.rect.copyFrom(ActNpc114_rcLeft[npc.ani_no]);
    }

    public static void ActNpc115(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.xm = 0;
                npc.act_no = 1;
                npc.act_wait = 0;
                npc.count1 = 0;
            }
            case 1: {
                if (MyChar.gMC.x < npc.x + 49152 && MyChar.gMC.x > npc.x - 49152 && MyChar.gMC.y < npc.y + 16384 && MyChar.gMC.y > npc.y - 49152) {
                    npc.act_no = 10;
                }
                if (npc.shock == '\u0000') break;
                npc.act_no = 10;
                break;
            }
            case 10: {
                npc.direct = MyChar.gMC.x < npc.x ? 0 : 2;
                npc.ani_no = 1;
                if (++npc.act_wait <= 20) break;
                npc.act_wait = 0;
                npc.act_no = 20;
                break;
            }
            case 20: {
                npc.damage = 0;
                npc.xm = 0;
                if (++npc.ani_wait > 2) {
                    npc.ani_wait = 0;
                    ++npc.ani_no;
                }
                if (npc.ani_no <= 2) break;
                npc.direct = npc.x > MyChar.gMC.x ? 0 : 2;
                npc.xm = npc.direct == 0 ? -512 : 512;
                if (++npc.count1 > 2) {
                    npc.count1 = 0;
                    npc.ani_no = 4;
                    npc.act_no = 21;
                    npc.ym = -1024;
                    npc.xm *= 2;
                    npc.damage = 5;
                    Sound.PlaySoundObject(102, 1);
                    break;
                }
                npc.act_no = 21;
                npc.ym = -1024;
                Sound.PlaySoundObject(30, 1);
                break;
            }
            case 21: {
                if ((npc.flag & 8) == 0) break;
                Sound.PlaySoundObject(23, 1);
                npc.act_no = 20;
                npc.ani_no = 1;
                npc.ani_wait = 0;
                npc.damage = 0;
                if (MyChar.gMC.x <= npc.x + 73728 && MyChar.gMC.x >= npc.x - 73728 && MyChar.gMC.y <= npc.y + 24576 && MyChar.gMC.y >= npc.y - 73728) break;
                npc.act_no = 0;
                break;
            }
            case 30: {
                for (int i = 0; i < 8; ++i) {
                    NpChar.SetNpChar(4, npc.x + Game.Random(-12, 12) * 512, npc.y + Game.Random(-12, 12) * 512, Game.Random(-341, 341), Game.Random(-1536, 0), 0, null, 256);
                }
                npc.ani_no = 0;
                npc.act_no = 0;
                break;
            }
            case 50: {
                npc.act_no = 51;
                npc.ani_no = 4;
                npc.damage = 0;
                npc.ym = -512;
                npc.bits = (char)(npc.bits & 0xFFFFFFDE);
                Sound.PlaySoundObject(51, 1);
            }
            case 51: {
                if ((npc.flag & 8) == 0) break;
                Sound.PlaySoundObject(23, 1);
                npc.act_no = 52;
                npc.ani_no = 5;
                npc.xm = 0;
            }
        }
        npc.ym = npc.act_no > 50 ? (npc.ym += 32) : (npc.ym += 64);
        if (npc.ym > 1535) {
            npc.ym = 1535;
        }
        npc.x += npc.xm;
        npc.y += npc.ym;
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc115_rcLeft[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc115_rcRight[npc.ani_no]);
        }
    }

    public static void ActNpc116(NpChar.NPCHAR npc) {
        npc.rect.copyFrom(ActNpc116_rc);
    }

    public static void ActNpc117(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                if (npc.direct == 4) {
                    npc.direct = npc.x > MyChar.gMC.x ? 0 : 2;
                }
                npc.act_no = 1;
                npc.ani_no = 0;
                npc.ani_wait = 0;
            }
            case 1: {
                npc.xm = 0;
                npc.ym += 64;
                break;
            }
            case 3: {
                npc.act_no = 4;
                npc.ani_no = 1;
                npc.ani_wait = 0;
            }
            case 4: {
                if (++npc.ani_wait > 4) {
                    npc.ani_wait = 0;
                    ++npc.ani_no;
                }
                if (npc.ani_no > 4) {
                    npc.ani_no = 1;
                }
                npc.ym += 64;
                if (npc.direct == 0) {
                    npc.xm = -512;
                    break;
                }
                npc.xm = 512;
                break;
            }
            case 5: {
                npc.act_no = 6;
                npc.ani_no = 5;
                NpChar.SetDestroyNpChar(npc.x, npc.y, npc.view.back, 8);
                break;
            }
            case 6: {
                npc.ani_no = 5;
                break;
            }
            case 10: {
                npc.act_no = 11;
                npc.ani_no = 1;
                npc.ani_wait = 0;
                npc.direct = npc.x > MyChar.gMC.x ? 0 : 2;
            }
            case 11: {
                if (++npc.ani_wait > 4) {
                    npc.ani_wait = 0;
                    ++npc.ani_no;
                }
                if (npc.ani_no > 4) {
                    npc.ani_no = 1;
                }
                npc.x = npc.direct == 0 ? (npc.x -= 512) : (npc.x += 512);
                if (MyChar.gMC.x >= npc.x + 10240 || MyChar.gMC.x <= npc.x - 10240) break;
                npc.act_no = 0;
                break;
            }
            case 20: {
                npc.xm = 0;
                npc.ani_no = 6;
                break;
            }
            case 21: {
                npc.xm = 0;
                npc.ani_no = 9;
                break;
            }
            case 30: {
                npc.act_no = 31;
                npc.act_wait = 0;
                npc.ym = -1024;
            }
            case 31: {
                npc.ani_no = 7;
                npc.xm = npc.direct == 0 ? 512 : -512;
                npc.ym += 64;
                if (npc.act_wait++ == 0 || (npc.flag & 8) == 0) break;
                npc.act_no = 32;
                break;
            }
            case 32: {
                npc.ym += 64;
                npc.ani_no = 8;
                npc.xm = 0;
                break;
            }
            case 70: {
                npc.act_no = 71;
                npc.act_wait = 0;
                npc.ani_no = 1;
                npc.ani_wait = 0;
            }
            case 71: {
                npc.x = npc.direct == 0 ? (npc.x += 256) : (npc.x -= 256);
                if (++npc.ani_wait > 8) {
                    npc.ani_wait = 0;
                    ++npc.ani_no;
                }
                if (npc.ani_no <= 4) break;
                npc.ani_no = 1;
            }
        }
        if (npc.ym > 1535) {
            npc.ym = 1535;
        }
        npc.x += npc.xm;
        npc.y += npc.ym;
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc117_rcLeft[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc117_rcRight[npc.ani_no]);
        }
    }

    public static void ActNpc118(NpChar.NPCHAR npc) {
        boolean bUpper = false;
        if (npc.direct == 0 && npc.x < MyChar.gMC.x) {
            bUpper = true;
        }
        if (npc.direct == 2 && npc.x > MyChar.gMC.x) {
            bUpper = true;
        }
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
                npc.ani_no = 0;
                npc.ani_wait = 0;
                break;
            }
            case 10: {
                npc.act_no = 11;
                npc.act_wait = Game.Random(50, 100);
                npc.ani_no = 0;
                npc.direct = npc.x > MyChar.gMC.x ? 0 : 2;
                npc.bits = (char)(npc.bits | 0x20);
                npc.bits = (char)(npc.bits & 0xFFFFFFFB);
            }
            case 11: {
                if (npc.act_wait != 0) {
                    --npc.act_wait;
                    break;
                }
                npc.act_no = 13;
                break;
            }
            case 13: {
                npc.act_no = 14;
                npc.ani_no = 3;
                npc.act_wait = Game.Random(50, 100);
                npc.direct = npc.x > MyChar.gMC.x ? 0 : 2;
            }
            case 14: {
                if (++npc.ani_wait > 2) {
                    npc.ani_wait = 0;
                    ++npc.ani_no;
                }
                if (npc.ani_no > 6) {
                    npc.ani_no = 3;
                }
                npc.xm = npc.direct == 0 ? (npc.xm -= 64) : (npc.xm += 64);
                if (npc.act_wait != 0) {
                    --npc.act_wait;
                    break;
                }
                npc.bits = (char)(npc.bits | 0x20);
                npc.act_no = 20;
                npc.act_wait = 0;
                Sound.PlaySoundObject(103, 1);
                break;
            }
            case 20: {
                npc.direct = npc.x > MyChar.gMC.x ? 0 : 2;
                npc.xm = npc.xm * 8 / 9;
                if (++npc.ani_no > 1) {
                    npc.ani_no = 0;
                }
                if (++npc.act_wait <= 50) break;
                npc.act_no = 21;
                npc.act_wait = 0;
                break;
            }
            case 21: {
                if (++npc.act_wait % 4 == 1) {
                    if (npc.direct == 0) {
                        if (bUpper) {
                            npc.ani_no = 2;
                            NpChar.SetNpChar(123, npc.x, npc.y - 4096, 0, 0, 1, null, 256);
                        } else {
                            npc.ani_no = 0;
                            NpChar.SetNpChar(123, npc.x - 4096, npc.y + 2048, 0, 0, 0, null, 256);
                            npc.x += 512;
                        }
                    } else if (bUpper) {
                        npc.ani_no = 2;
                        NpChar.SetNpChar(123, npc.x, npc.y - 4096, 0, 0, 1, null, 256);
                    } else {
                        npc.ani_no = 0;
                        NpChar.SetNpChar(123, npc.x + 4096, npc.y + 2048, 0, 0, 2, null, 256);
                        npc.x -= 512;
                    }
                }
                if (npc.act_wait <= 30) break;
                npc.act_no = 10;
                break;
            }
            case 30: {
                if (++npc.ani_no > 8) {
                    npc.ani_no = 7;
                }
                if (++npc.act_wait <= 30) break;
                npc.act_no = 10;
                npc.ani_no = 0;
            }
        }
        if (npc.act_no > 10 && npc.act_no < 30 && Bullet.CountArmsBullet(6) != 0) {
            npc.act_wait = 0;
            npc.act_no = 30;
            npc.ani_no = 7;
            npc.bits = (char)(npc.bits & 0xFFFFFFDF);
            npc.bits = (char)(npc.bits | 4);
            npc.xm = 0;
        }
        npc.ym += 32;
        if (npc.xm > 511) {
            npc.xm = 511;
        }
        if (npc.xm < -511) {
            npc.xm = -511;
        }
        if (npc.ym > 1535) {
            npc.ym = 1535;
        }
        npc.y += npc.ym;
        npc.x += npc.xm;
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc118_rcLeft[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc118_rcRight[npc.ani_no]);
        }
    }

    public static void ActNpc119(NpChar.NPCHAR npc) {
        npc.rect.copyFrom(ActNpc119_rc);
    }
}
