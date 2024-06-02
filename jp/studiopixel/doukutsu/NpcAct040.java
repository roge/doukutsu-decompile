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

public class NpcAct040 {
    private static final RECT[] ActNpc040_rcLeft = new RECT[]{new RECT(0, 32, 16, 48), new RECT(16, 32, 32, 48), new RECT(32, 32, 48, 48), new RECT(0, 32, 16, 48), new RECT(48, 32, 64, 48), new RECT(0, 32, 16, 48), new RECT(64, 32, 80, 48)};
    private static final RECT[] ActNpc040_rcRight = new RECT[]{new RECT(0, 48, 16, 64), new RECT(16, 48, 32, 64), new RECT(32, 48, 48, 64), new RECT(0, 48, 16, 64), new RECT(48, 48, 64, 64), new RECT(0, 48, 16, 64), new RECT(64, 48, 80, 64)};
    private static final RECT ActNpc041_rc = new RECT(0, 80, 48, 112);
    private static final RECT[] ActNpc042_rcLeft = new RECT[]{new RECT(0, 0, 16, 16), new RECT(16, 0, 32, 16), new RECT(32, 0, 48, 16), new RECT(0, 0, 16, 16), new RECT(48, 0, 64, 16), new RECT(0, 0, 16, 16), new RECT(64, 0, 80, 16), new RECT(80, 32, 96, 48), new RECT(96, 32, 112, 48), new RECT(128, 32, 144, 48), new RECT(0, 0, 16, 16), new RECT(112, 32, 128, 48), new RECT(160, 32, 176, 48)};
    private static final RECT[] ActNpc042_rcRight = new RECT[]{new RECT(0, 16, 16, 32), new RECT(16, 16, 32, 32), new RECT(32, 16, 48, 32), new RECT(0, 16, 16, 32), new RECT(48, 16, 64, 32), new RECT(0, 16, 16, 32), new RECT(64, 16, 80, 32), new RECT(80, 48, 96, 64), new RECT(96, 48, 112, 64), new RECT(128, 48, 144, 64), new RECT(0, 16, 16, 32), new RECT(112, 48, 128, 64), new RECT(160, 48, 176, 64)};
    private static final RECT ActNpc043_rcLeft = new RECT(128, 80, 168, 112);
    private static final RECT ActNpc043_rcRight = new RECT(168, 80, 208, 112);
    private static final RECT[] ActNpc044_rcLeft = new RECT[]{new RECT(0, 0, 32, 32), new RECT(96, 0, 128, 32), new RECT(128, 0, 160, 32)};
    private static final RECT[] ActNpc044_rcRight = new RECT[]{new RECT(0, 0, 32, 32), new RECT(32, 0, 64, 32), new RECT(64, 0, 96, 32)};
    private static final RECT[] ActNpc045_rect = new RECT[]{new RECT(0, 32, 16, 48), new RECT(16, 32, 32, 48), new RECT(32, 32, 48, 48)};
    private static final RECT ActNpc046_rect = new RECT(0, 0, 16, 16);
    private static final RECT[] ActNpc047_rect = new RECT[]{new RECT(0, 48, 48, 80), new RECT(48, 48, 96, 80), new RECT(96, 48, 144, 80), new RECT(144, 48, 192, 80), new RECT(192, 48, 240, 80)};
    private static final RECT[] ActNpc048_rcLeft = new RECT[]{new RECT(288, 88, 304, 104), new RECT(304, 88, 320, 104)};
    private static final RECT[] ActNpc048_rcRight = new RECT[]{new RECT(288, 104, 304, 120), new RECT(304, 104, 320, 120)};
    private static final RECT[] ActNpc049_rcLeft = new RECT[]{new RECT(0, 80, 32, 104), new RECT(32, 80, 64, 104), new RECT(64, 80, 96, 104)};
    private static final RECT[] ActNpc049_rcRight = new RECT[]{new RECT(0, 104, 32, 128), new RECT(32, 104, 64, 128), new RECT(64, 104, 96, 128)};
    private static final RECT[] ActNpc050_rc = new RECT[]{new RECT(48, 32, 64, 48), new RECT(64, 32, 80, 48), new RECT(80, 32, 96, 48), new RECT(96, 32, 112, 48)};
    private static final RECT[] ActNpc051_rcLeft = new RECT[]{new RECT(96, 80, 128, 112), new RECT(128, 80, 160, 112), new RECT(160, 80, 192, 112), new RECT(192, 80, 224, 112), new RECT(224, 80, 256, 112)};
    private static final RECT[] ActNpc051_rcRight = new RECT[]{new RECT(96, 112, 128, 144), new RECT(128, 112, 160, 144), new RECT(160, 112, 192, 144), new RECT(192, 112, 224, 144), new RECT(224, 112, 256, 144)};
    private static final RECT ActNpc052_rc = new RECT(240, 96, 256, 112);
    private static final RECT[] ActNpc053_rcLeft = new RECT[]{new RECT(0, 128, 24, 144), new RECT(24, 128, 48, 144)};
    private static final RECT[] ActNpc053_rcRight = new RECT[]{new RECT(48, 128, 72, 144), new RECT(72, 128, 96, 144)};
    private static final RECT[] ActNpc054_rcLeft = new RECT[]{new RECT(0, 80, 32, 104), new RECT(32, 80, 64, 104), new RECT(64, 80, 96, 104)};
    private static final RECT[] ActNpc054_rcRight = new RECT[]{new RECT(0, 104, 32, 128), new RECT(32, 104, 64, 128), new RECT(64, 104, 96, 128)};
    private static final RECT[] ActNpc055_rcLeft = new RECT[]{new RECT(192, 192, 208, 216), new RECT(208, 192, 224, 216), new RECT(192, 192, 208, 216), new RECT(224, 192, 240, 216), new RECT(192, 192, 208, 216), new RECT(240, 192, 256, 216)};
    private static final RECT[] ActNpc055_rcRight = new RECT[]{new RECT(192, 216, 208, 240), new RECT(208, 216, 224, 240), new RECT(192, 216, 208, 240), new RECT(224, 216, 240, 240), new RECT(192, 216, 208, 240), new RECT(240, 216, 256, 240)};
    private static final RECT[] ActNpc056_rcLeft = new RECT[]{new RECT(0, 144, 16, 160), new RECT(16, 144, 32, 160), new RECT(32, 144, 48, 160)};
    private static final RECT[] ActNpc056_rcRight = new RECT[]{new RECT(0, 160, 16, 176), new RECT(16, 160, 32, 176), new RECT(32, 160, 48, 176)};
    private static final RECT[] ActNpc057_rcLeft = new RECT[]{new RECT(96, 80, 128, 112), new RECT(128, 80, 160, 112), new RECT(160, 80, 192, 112), new RECT(192, 80, 224, 112), new RECT(224, 80, 256, 112)};
    private static final RECT[] ActNpc057_rcRight = new RECT[]{new RECT(96, 112, 128, 144), new RECT(128, 112, 160, 144), new RECT(160, 112, 192, 144), new RECT(192, 112, 224, 144), new RECT(224, 112, 256, 144)};
    private static final RECT[] ActNpc058_rcLeft = new RECT[]{new RECT(192, 0, 216, 24), new RECT(216, 0, 240, 24), new RECT(240, 0, 264, 24)};
    private static final RECT[] ActNpc058_rcRight = new RECT[]{new RECT(192, 24, 216, 48), new RECT(216, 24, 240, 48), new RECT(240, 24, 264, 48)};
    private static final RECT[] ActNpc059_rcLeft = new RECT[]{new RECT(224, 16, 240, 40), new RECT(208, 80, 224, 104), new RECT(224, 80, 240, 104), new RECT(240, 80, 256, 104)};

    public static void ActNpc040(NpChar.NPCHAR npc) {
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
            }
        }
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc040_rcLeft[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc040_rcRight[npc.ani_no]);
        }
    }

    public static void ActNpc041(NpChar.NPCHAR npc) {
        if (npc.act_no == 0) {
            ++npc.act_no;
            npc.y -= 8192;
        }
        npc.rect.copyFrom(ActNpc041_rc);
    }

    public static void ActNpc042(NpChar.NPCHAR npc) {
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
                    npc.xm = -512;
                    break;
                }
                npc.xm = 512;
                break;
            }
            case 5: {
                npc.ani_no = 6;
                npc.xm = 0;
                break;
            }
            case 6: {
                Sound.PlaySoundObject(50, 1);
                npc.act_wait = 0;
                npc.act_no = 7;
                npc.ani_no = 7;
            }
            case 7: {
                if (++npc.act_wait <= 10) break;
                npc.act_no = 0;
                break;
            }
            case 8: {
                Sound.PlaySoundObject(50, 1);
                npc.act_wait = 0;
                npc.act_no = 9;
                npc.ani_no = 7;
                npc.ym = -512;
                npc.xm = npc.direct == 0 ? 1024 : -1024;
            }
            case 9: {
                if (++npc.act_wait <= 3 || (npc.flag & 8) == 0) break;
                npc.act_no = 10;
                if (npc.direct == 0) {
                    npc.direct = 2;
                    break;
                }
                npc.direct = 0;
                break;
            }
            case 10: {
                npc.xm = 0;
                npc.ani_no = 8;
                break;
            }
            case 11: {
                npc.act_no = 12;
                npc.act_wait = 0;
                npc.ani_no = 9;
                npc.ani_wait = 0;
                npc.xm = 0;
            }
            case 12: {
                if (++npc.ani_wait > 8) {
                    npc.ani_wait = 0;
                    ++npc.ani_no;
                }
                if (npc.ani_no <= 10) break;
                npc.ani_no = 9;
                break;
            }
            case 13: {
                int n;
                npc.ani_no = 11;
                npc.xm = 0;
                npc.ym = 0;
                npc.act_no = 14;
                for (n = 0; n < NpChar.gNPC.length && NpChar.gNPC[n].code_event != 501; ++n) {
                }
                if (n == NpChar.gNPC.length) {
                    npc.act_no = 0;
                    break;
                }
                npc.pNpc = NpChar.gNPC[n];
            }
            case 14: {
                npc.direct = npc.pNpc.direct == 0 ? 2 : 0;
                npc.x = npc.pNpc.direct == 0 ? npc.pNpc.x - 3072 : npc.pNpc.x + 3072;
                npc.y = npc.pNpc.y + 2048;
                if (npc.pNpc.ani_no != 2 && npc.pNpc.ani_no != 4) break;
                npc.y -= 512;
                break;
            }
            case 15: {
                npc.act_no = 16;
                NpChar.SetNpChar(257, npc.x + 65536, npc.y, 0, 0, 0, null, 0);
                NpChar.SetNpChar(257, npc.x + 65536, npc.y, 0, 0, 2, null, 128);
                npc.xm = 0;
                npc.ani_no = 0;
            }
            case 16: {
                NpChar.gSuperXpos = npc.x - 12288;
                NpChar.gSuperYpos = npc.y - 4096;
                break;
            }
            case 17: {
                npc.xm = 0;
                npc.ani_no = 12;
                NpChar.gSuperXpos = npc.x;
                NpChar.gSuperYpos = npc.y - 4096;
                break;
            }
            case 20: {
                npc.act_no = 21;
                npc.ani_no = 2;
                npc.ani_wait = 0;
            }
            case 21: {
                if (++npc.ani_wait > 2) {
                    npc.ani_wait = 0;
                    ++npc.ani_no;
                }
                if (npc.ani_no > 5) {
                    npc.ani_no = 2;
                }
                npc.xm = npc.direct == 0 ? -1024 : 1024;
                if (npc.x >= MyChar.gMC.x - 4096) break;
                npc.direct = 2;
                npc.act_no = 0;
                break;
            }
            case 30: {
                npc.act_no = 31;
                npc.ani_no = 2;
                npc.ani_wait = 0;
            }
            case 31: {
                if (++npc.ani_wait > 2) {
                    npc.ani_wait = 0;
                    ++npc.ani_no;
                }
                if (npc.ani_no > 5) {
                    npc.ani_no = 2;
                }
                if (npc.direct == 0) {
                    npc.xm = -1024;
                    break;
                }
                npc.xm = 1024;
                break;
            }
            case 40: {
                npc.act_no = 41;
                npc.ani_no = 9;
                npc.ym = -1024;
            }
        }
        if (npc.act_no != 14) {
            npc.ym += 64;
            if (npc.xm > 1024) {
                npc.xm = 1024;
            }
            if (npc.xm < -1024) {
                npc.xm = -1024;
            }
            if (npc.ym > 1535) {
                npc.ym = 1535;
            }
            npc.x += npc.xm;
            npc.y += npc.ym;
        }
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc042_rcLeft[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc042_rcRight[npc.ani_no]);
        }
    }

    public static void ActNpc043(NpChar.NPCHAR npc) {
        if (npc.act_no == 0) {
            npc.act_no = 1;
            npc.y -= 8192;
        }
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc043_rcLeft);
        } else {
            npc.rect.copyFrom(ActNpc043_rcRight);
        }
    }

    public static void ActNpc044(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
            }
            case 1: {
                npc.ani_no = 0;
                npc.act_no = npc.direct == 0 ? 8 : 2;
            }
            case 2: {
                npc.ym += 32;
                if (npc.ym > 0 && (npc.flag & 8) != 0) {
                    npc.ym = -256;
                    npc.xm += 256;
                }
                if ((npc.flag & 4) == 0) break;
                npc.act_no = 3;
                break;
            }
            case 3: {
                npc.xm += 32;
                if (npc.xm > 0 && (npc.flag & 4) != 0) {
                    npc.xm = -256;
                    npc.ym -= 256;
                }
                if ((npc.flag & 2) == 0) break;
                npc.act_no = 4;
                break;
            }
            case 4: {
                npc.ym -= 32;
                if (npc.ym < 0 && (npc.flag & 2) != 0) {
                    npc.ym = 256;
                    npc.xm -= 256;
                }
                if ((npc.flag & 1) == 0) break;
                npc.act_no = 5;
                break;
            }
            case 5: {
                npc.xm -= 32;
                if (npc.xm < 0 && (npc.flag & 1) != 0) {
                    npc.xm = 256;
                    npc.ym += 256;
                }
                if ((npc.flag & 8) == 0) break;
                npc.act_no = 2;
                break;
            }
            case 6: {
                npc.ym += 32;
                if (npc.ym > 0 && (npc.flag & 8) != 0) {
                    npc.ym = -256;
                    npc.xm -= 256;
                }
                if ((npc.flag & 1) == 0) break;
                npc.act_no = 7;
                break;
            }
            case 7: {
                npc.xm -= 32;
                if (npc.xm < 0 && (npc.flag & 1) != 0) {
                    npc.xm = 256;
                    npc.ym -= 256;
                }
                if ((npc.flag & 2) == 0) break;
                npc.act_no = 8;
                break;
            }
            case 8: {
                npc.ym -= 32;
                if (npc.ym < 0 && (npc.flag & 2) != 0) {
                    npc.ym = 256;
                    npc.xm += 256;
                }
                if ((npc.flag & 4) == 0) break;
                npc.act_no = 9;
                break;
            }
            case 9: {
                npc.xm += 32;
                if (npc.xm > 0 && (npc.flag & 4) != 0) {
                    npc.xm = -256;
                    npc.ym += 256;
                }
                if ((npc.flag & 8) == 0) break;
                npc.act_no = 6;
            }
        }
        if (npc.life <= 100) {
            for (int i = 0; i < 10; ++i) {
                NpChar.SetNpChar(45, npc.x, npc.y, 0, 0, 0, null, 256);
            }
            NpChar.SetDestroyNpChar(npc.x, npc.y, npc.view.back, 8);
            Sound.PlaySoundObject(25, 1);
            npc.cond = 0;
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
        if (npc.shock != '\u0000') {
            npc.x += npc.xm / 2;
            npc.y += npc.ym / 2;
        } else {
            npc.x += npc.xm;
            npc.y += npc.ym;
        }
        if (npc.act_no >= 2 && npc.act_no <= 9 && ++npc.ani_no > 2) {
            npc.ani_no = 1;
        }
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc044_rcLeft[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc044_rcRight[npc.ani_no]);
        }
    }

    public static void ActNpc045(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 2;
                npc.xm = Game.Random(0, 1) != 0 ? Game.Random(-512, -256) : Game.Random(256, 512);
                npc.ym = Game.Random(0, 1) != 0 ? Game.Random(-512, -256) : Game.Random(256, 512);
                npc.xm2 = npc.xm;
                npc.ym2 = npc.ym;
            }
            case 1: 
            case 2: {
                if (++npc.ani_no <= 2) break;
                npc.ani_no = 1;
            }
        }
        if (npc.xm2 < 0 && (npc.flag & 1) != 0) {
            npc.xm2 *= -1;
        }
        if (npc.xm2 > 0 && (npc.flag & 4) != 0) {
            npc.xm2 *= -1;
        }
        if (npc.ym2 < 0 && (npc.flag & 2) != 0) {
            npc.ym2 *= -1;
        }
        if (npc.ym2 > 0 && (npc.flag & 8) != 0) {
            npc.ym2 *= -1;
        }
        if (npc.xm2 > 512) {
            npc.xm2 = 512;
        }
        if (npc.xm2 < -512) {
            npc.xm2 = -512;
        }
        if (npc.ym2 > 512) {
            npc.ym2 = 512;
        }
        if (npc.ym2 < -512) {
            npc.ym2 = -512;
        }
        if (npc.shock != '\u0000') {
            npc.x += npc.xm2 / 2;
            npc.y += npc.ym2 / 2;
        } else {
            npc.x += npc.xm2;
            npc.y += npc.ym2;
        }
        npc.rect.copyFrom(ActNpc045_rect[npc.ani_no]);
    }

    public static void ActNpc046(NpChar.NPCHAR npc) {
        npc.bits = (char)(npc.bits | 0x100);
        if (npc.direct == 0) {
            npc.x = npc.x < MyChar.gMC.x ? (npc.x += 1535) : (npc.x -= 1535);
        } else {
            npc.y = npc.y < MyChar.gMC.y ? (npc.y += 1535) : (npc.y -= 1535);
        }
        npc.rect.copyFrom(ActNpc046_rect);
    }

    public static void ActNpc047(NpChar.NPCHAR npc) {
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
                if (MyChar.gMC.x > npc.x - 4096 && MyChar.gMC.x < npc.x + 4096 && MyChar.gMC.y > npc.y && MyChar.gMC.y < npc.y + 4096) {
                    npc.act_no = 2;
                    npc.act_wait = 0;
                    Sound.PlaySoundObject(102, 1);
                }
                if (npc.x < MyChar.gMC.x) {
                    npc.x += 1024;
                }
                if (npc.x <= MyChar.gMC.x) break;
                npc.x -= 1024;
                break;
            }
            case 2: {
                if (++npc.ani_wait > 3) {
                    ++npc.ani_no;
                    npc.ani_wait = 0;
                }
                if (npc.ani_no == 3) {
                    npc.damage = 10;
                }
                if (npc.ani_no != 4) break;
                npc.bits = (char)(npc.bits | 0x20);
                npc.act_no = 3;
                npc.act_wait = 0;
                break;
            }
            case 3: {
                npc.bits = (char)(npc.bits | '\u0001');
                npc.damage = 0;
                ++npc.act_wait;
                if (npc.shock == '\u0000') break;
                npc.act_no = 4;
                npc.act_wait = 0;
                break;
            }
            case 4: {
                npc.bits = (char)(npc.bits | 8);
                npc.y += 512;
                if (++npc.act_wait != 32) break;
                npc.bits = (char)(npc.bits & 0xFFFFFFFE);
                npc.bits = (char)(npc.bits & 0xFFFFFFDF);
                npc.act_no = 5;
                npc.act_wait = 0;
                break;
            }
            case 5: {
                if (npc.act_wait < 100) {
                    ++npc.act_wait;
                    break;
                }
                npc.y = npc.tgt_y;
                npc.ani_no = 0;
                npc.act_no = 0;
            }
        }
        npc.rect.copyFrom(ActNpc047_rect[npc.ani_no]);
    }

    public static void ActNpc048(NpChar.NPCHAR npc) {
        if ((npc.flag & 1) != 0 && npc.xm < 0) {
            npc.xm *= -1;
        } else if ((npc.flag & 4) != 0 && npc.xm > 0) {
            npc.xm *= -1;
        } else if ((npc.flag & 8) != 0) {
            if (++npc.count1 > 2 || npc.direct == 2) {
                NpChar.VanishNpChar(npc);
                Caret.SetCaret(npc.x, npc.y, 2, 0);
            } else {
                npc.ym = -256;
            }
        }
        if (npc.direct == 2) {
            npc.bits = (char)(npc.bits & 0xFFFFFFDF);
            npc.bits = (char)(npc.bits | 4);
        }
        npc.ym += 5;
        npc.y += npc.ym;
        npc.x += npc.xm;
        if (++npc.ani_wait > 2) {
            npc.ani_wait = 0;
            if (++npc.ani_no > 1) {
                npc.ani_no = 0;
            }
        }
        if (++npc.act_wait > 750) {
            Caret.SetCaret(npc.x, npc.y, 2, 0);
            npc.cond = 0;
        }
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc048_rcLeft[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc048_rcRight[npc.ani_no]);
        }
    }

    public static void ActNpc049(NpChar.NPCHAR npc) {
        if (npc.act_no >= 10 && npc.pNpc.code_char == 3) {
            npc.act_no = 3;
            npc.xm = 0;
            npc.ym = 0;
            npc.count2 = 1;
        }
        if ((npc.flag & 1) != 0) {
            npc.direct = 2;
            npc.xm = 256;
        }
        if ((npc.flag & 4) != 0) {
            npc.direct = 0;
            npc.xm = -256;
        }
        switch (npc.act_no) {
            case 0: {
                npc.act_no = npc.pNpc != null ? 10 : 1;
            }
            case 1: {
                if (++npc.act_wait > 3) {
                    npc.ym = -1024;
                    npc.act_no = 3;
                    npc.ani_no = 2;
                    npc.xm = npc.count2 != 0 ? (npc.direct == 0 ? -512 : 512) : (npc.direct == 0 ? -256 : 256);
                }
                npc.ani_no = 1;
                break;
            }
            case 3: {
                if ((npc.flag & 8) != 0) {
                    npc.act_no = 1;
                    npc.act_wait = 0;
                    npc.xm = 0;
                }
                if ((npc.flag & 8) != 0 || npc.ym > 0) {
                    npc.ani_no = 1;
                    break;
                }
                npc.ani_no = 2;
                break;
            }
            case 10: {
                if (npc.count1 < 50) {
                    ++npc.count1;
                    break;
                }
                if (npc.x - 65536 >= MyChar.gMC.x || npc.x + 65536 <= MyChar.gMC.x || npc.y - 49152 >= MyChar.gMC.y || npc.y + 49152 <= MyChar.gMC.y) break;
                npc.act_no = 11;
                npc.act_wait = 0;
                npc.ani_no = 2;
                break;
            }
            case 11: {
                if (++npc.act_wait == 30 || npc.act_wait == 35) {
                    char deg = (char)Triangle.GetArktan(npc.x - MyChar.gMC.x, npc.y + 2048 - MyChar.gMC.y);
                    int ym = Triangle.GetSin(deg) * 2;
                    int xm = Triangle.GetCos(deg) * 2;
                    NpChar.SetNpChar(50, npc.x, npc.y, xm, ym, 0, null, 256);
                    Sound.PlaySoundObject(39, 1);
                }
                if (npc.act_wait <= 50) break;
                npc.count1 = 0;
                npc.act_no = 10;
                npc.ani_no = 1;
            }
        }
        if (npc.act_no >= 10) {
            npc.x = npc.pNpc.x;
            npc.y = npc.pNpc.y + 8192;
            npc.direct = npc.pNpc.direct;
            --npc.pNpc.count1;
        }
        npc.ym += 64;
        if (npc.ym > 1535) {
            npc.ym = 1535;
        }
        npc.x += npc.xm;
        npc.y += npc.ym;
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc049_rcLeft[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc049_rcRight[npc.ani_no]);
        }
    }

    public static void ActNpc050(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                if (npc.direct == 2) {
                    npc.act_no = 2;
                }
            }
            case 1: {
                npc.x += npc.xm;
                npc.y += npc.ym;
                if ((npc.flag & 1) != 0) {
                    npc.act_no = 2;
                    npc.xm = 512;
                    ++npc.count1;
                }
                if ((npc.flag & 4) != 0) {
                    npc.act_no = 2;
                    npc.xm = -512;
                    ++npc.count1;
                }
                if ((npc.flag & 2) != 0) {
                    npc.act_no = 2;
                    npc.ym = 512;
                    ++npc.count1;
                }
                if ((npc.flag & 8) == 0) break;
                npc.act_no = 2;
                npc.ym = -512;
                ++npc.count1;
                break;
            }
            case 2: {
                npc.ym += 64;
                npc.x += npc.xm;
                npc.y += npc.ym;
                if ((npc.flag & 8) == 0 || ++npc.count1 <= 1) break;
                Caret.SetCaret(npc.x, npc.y, 2, 0);
                npc.cond = 0;
            }
        }
        if (npc.ym > 1535) {
            npc.ym = 1535;
        }
        if (npc.ym < -1535) {
            npc.ym = -1535;
        }
        if (npc.direct == 0) {
            if (++npc.ani_wait > 1) {
                npc.ani_wait = 0;
                ++npc.ani_no;
            }
            if (npc.ani_no > 3) {
                npc.ani_no = 0;
            }
        } else {
            if (++npc.ani_wait > 1) {
                npc.ani_wait = 0;
                --npc.ani_no;
            }
            if (npc.ani_no < 0) {
                npc.ani_no = 3;
            }
        }
        npc.rect.copyFrom(ActNpc050_rc[npc.ani_no]);
    }

    public static void ActNpc051(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                if (npc.x - 163840 >= MyChar.gMC.x || npc.x + 163840 <= MyChar.gMC.x || npc.y - 163840 >= MyChar.gMC.y || npc.y + 163840 <= MyChar.gMC.y) break;
                npc.tgt_x = npc.x;
                npc.tgt_y = npc.y;
                npc.ym = npc.direct == 0 ? 1024 : 1024;
                npc.act_no = 1;
                NpChar.SetNpChar(49, 0, 0, 0, 0, 0, npc, 0);
            }
            case 1: {
                npc.direct = MyChar.gMC.x < npc.x ? 0 : 2;
                if (npc.tgt_y < npc.y) {
                    npc.ym -= 10;
                }
                if (npc.tgt_y > npc.y) {
                    npc.ym += 10;
                }
                if (npc.ym > 512) {
                    npc.ym = 512;
                }
                if (npc.ym < -512) {
                    npc.ym = -512;
                }
                if (npc.count1 < 10) {
                    ++npc.count1;
                    break;
                }
                npc.act_no = 2;
                break;
            }
            case 2: {
                npc.direct = MyChar.gMC.x < npc.x ? 0 : 2;
                if (npc.y > MyChar.gMC.y + 16384) {
                    if (MyChar.gMC.x < npc.x) {
                        npc.xm += 16;
                    }
                    if (MyChar.gMC.x > npc.x) {
                        npc.xm -= 16;
                    }
                } else {
                    if (MyChar.gMC.x < npc.x) {
                        npc.xm -= 16;
                    }
                    if (MyChar.gMC.x > npc.x) {
                        npc.xm += 16;
                    }
                }
                if (MyChar.gMC.y < npc.y) {
                    npc.ym -= 16;
                }
                if (MyChar.gMC.y > npc.y) {
                    npc.ym += 16;
                }
                if (npc.shock == '\u0000') break;
                npc.ym += 32;
                npc.xm = 0;
            }
        }
        if (npc.xm < 0 && (npc.flag & 1) != 0) {
            npc.xm = 256;
        }
        if (npc.xm > 0 && (npc.flag & 4) != 0) {
            npc.xm = -256;
        }
        if (npc.ym < 0 && (npc.flag & 2) != 0) {
            npc.ym = 256;
        }
        if (npc.ym > 0 && (npc.flag & 8) != 0) {
            npc.ym = -256;
        }
        if (npc.xm > 1024) {
            npc.xm = 1024;
        }
        if (npc.xm < -1024) {
            npc.xm = -1024;
        }
        if (npc.ym > 512) {
            npc.ym = 512;
        }
        if (npc.ym < -512) {
            npc.ym = -512;
        }
        npc.x += npc.xm;
        npc.y += npc.ym;
        if (npc.shock != '\u0000') {
            npc.ani_no = 4;
        } else if (npc.act_no == 2 && npc.y < MyChar.gMC.y - 16384) {
            npc.ani_no = 0;
        } else if (npc.act_no != 0) {
            if (++npc.ani_wait > 1) {
                npc.ani_wait = 0;
                ++npc.ani_no;
            }
            if (npc.ani_no > 1) {
                npc.ani_no = 0;
            }
        }
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc051_rcLeft[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc051_rcRight[npc.ani_no]);
        }
    }

    public static void ActNpc052(NpChar.NPCHAR npc) {
        npc.rect.copyFrom(ActNpc052_rc);
    }

    public static void ActNpc053(NpChar.NPCHAR npc) {
        char deg = '\u0000';
        if (npc.pNpc.code_char == 3) {
            NpChar.VanishNpChar(npc);
            NpChar.SetDestroyNpChar(npc.x, npc.y, npc.view.back, 4);
            return;
        }
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
                npc.count1 = 10;
            }
            case 1: {
                if (npc.direct == 0 && (npc.flag & 0x20) != 0) {
                    npc.pNpc.y -= 1024;
                    npc.pNpc.ym -= 256;
                }
                if (npc.direct == 2 && (npc.flag & 0x10) != 0) {
                    npc.pNpc.y -= 1024;
                    npc.pNpc.ym -= 256;
                }
                if ((npc.flag & 8) != 0) {
                    npc.pNpc.y -= 1024;
                    npc.pNpc.ym -= 256;
                    npc.pNpc.xm = npc.pNpc.direct == 0 ? (npc.pNpc.xm -= 128) : (npc.pNpc.xm += 128);
                }
                deg = (char)((char)npc.xm + (char)npc.pNpc.count2 & 0xFF);
                npc.x = npc.pNpc.x + npc.count1 * Triangle.GetCos(deg);
                npc.y = npc.pNpc.y + npc.count1 * Triangle.GetSin(deg);
                npc.direct = npc.pNpc.direct;
            }
        }
        npc.direct = npc.pNpc.direct;
        npc.ani_no = deg >= '\u0014' && deg <= 'l' ? 0 : 1;
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc053_rcLeft[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc053_rcRight[npc.ani_no]);
        }
    }

    public static void ActNpc054(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                NpChar.SetNpChar(53, 0, 0, 0, 0, npc.direct, npc, 256);
                NpChar.SetNpChar(53, 0, 0, 128, 0, npc.direct, npc, 0);
                npc.act_no = 1;
                npc.ani_no = 1;
            }
            case 1: {
                char deg = (char)npc.count2;
                deg = npc.direct == 0 ? (char)(deg - 6) : (char)(deg + 6);
                npc.count2 = deg;
                if ((npc.flag & 8) != 0) {
                    npc.xm = npc.xm * 3 / 4;
                    if (++npc.act_wait > 60) {
                        npc.act_no = 2;
                        npc.act_wait = 0;
                    }
                } else {
                    npc.act_wait = 0;
                }
                if (npc.direct == 0 && (npc.flag & 1) != 0) {
                    if (++npc.count1 <= 8) break;
                    npc.direct = 2;
                    npc.xm *= -1;
                    break;
                }
                if (npc.direct == 2 && (npc.flag & 4) != 0) {
                    if (++npc.count1 <= 8) break;
                    npc.direct = 0;
                    npc.xm *= -1;
                    break;
                }
                npc.count1 = 0;
                break;
            }
            case 2: {
                ++npc.act_wait;
                npc.shock = (char)(npc.shock + (char)(npc.act_wait & 0xFF));
                if (npc.act_wait <= 50) break;
                NpChar.VanishNpChar(npc);
                NpChar.SetDestroyNpChar(npc.x, npc.y, npc.view.back, 8);
                Sound.PlaySoundObject(25, 1);
            }
        }
        npc.ym += 128;
        if (npc.xm > 767) {
            npc.xm = 767;
        }
        if (npc.xm < -767) {
            npc.xm = -767;
        }
        if (npc.ym > 767) {
            npc.ym = 767;
        }
        if (npc.ym < -767) {
            npc.ym = -767;
        }
        npc.x += npc.xm;
        npc.y += npc.ym;
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc054_rcLeft[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc054_rcRight[npc.ani_no]);
        }
    }

    public static void ActNpc055(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
                npc.ani_no = 0;
                npc.ani_wait = 0;
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
                if (npc.direct == 0) {
                    npc.x -= 512;
                    break;
                }
                npc.x += 512;
                break;
            }
            case 5: {
                npc.ani_no = 5;
            }
        }
        npc.ym += 32;
        if (npc.ym > 1535) {
            npc.ym = 1535;
        }
        npc.y += npc.ym;
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc055_rcLeft[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc055_rcRight[npc.ani_no]);
        }
    }

    public static void ActNpc056(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
                if (npc.direct == 0) {
                    npc.act_no = 1;
                    break;
                }
                npc.act_no = 3;
                break;
            }
            case 1: {
                npc.xm -= 16;
                if (npc.xm < -1024) {
                    npc.xm = -1024;
                }
                npc.x = npc.shock != '\u0000' ? (npc.x += npc.xm / 2) : (npc.x += npc.xm);
                if (++npc.ani_wait > 1) {
                    npc.ani_wait = 0;
                    ++npc.ani_no;
                }
                if (npc.ani_no > 2) {
                    npc.ani_no = 1;
                }
                if ((npc.flag & 1) == 0) break;
                npc.act_no = 2;
                npc.act_wait = 0;
                npc.ani_no = 0;
                npc.xm = 0;
                npc.direct = 2;
                break;
            }
            case 2: {
                if (npc.x >= MyChar.gMC.x || npc.x <= MyChar.gMC.x - 131072 || npc.y >= MyChar.gMC.y + 4096 || npc.y <= MyChar.gMC.y - 4096) break;
                npc.act_no = 3;
                npc.ani_wait = 0;
                npc.ani_no = 1;
                break;
            }
            case 3: {
                npc.xm += 16;
                if (npc.xm > 1024) {
                    npc.xm = 1024;
                }
                npc.x = npc.shock != '\u0000' ? (npc.x += npc.xm / 2) : (npc.x += npc.xm);
                if (++npc.ani_wait > 1) {
                    npc.ani_wait = 0;
                    ++npc.ani_no;
                }
                if (npc.ani_no > 2) {
                    npc.ani_no = 1;
                }
                if ((npc.flag & 4) == 0) break;
                npc.act_no = 4;
                npc.act_wait = 0;
                npc.ani_no = 0;
                npc.xm = 0;
                npc.direct = 0;
                break;
            }
            case 4: {
                if (npc.x >= MyChar.gMC.x + 131072 || npc.x <= MyChar.gMC.x || npc.y >= MyChar.gMC.y + 4096 || npc.y <= MyChar.gMC.y - 4096) break;
                npc.act_no = 1;
                npc.ani_wait = 0;
                npc.ani_no = 1;
            }
        }
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc056_rcLeft[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc056_rcRight[npc.ani_no]);
        }
    }

    public static void ActNpc057(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                char deg = (char)Game.Random(0, 255);
                npc.xm = Triangle.GetCos(deg);
                deg = (char)(deg + 64);
                deg = (char)(deg & 0xFF);
                npc.tgt_x = npc.x + Triangle.GetCos(deg) * 8;
                deg = (char)Game.Random(0, 255);
                npc.ym = Triangle.GetSin(deg);
                deg = (char)(deg + 64);
                deg = (char)(deg & 0xFF);
                npc.tgt_y = npc.y + Triangle.GetSin(deg) * 8;
                npc.act_no = 1;
                npc.count1 = 120;
                npc.ani_no = Game.Random(0, 1);
                npc.ani_wait = Game.Random(0, 4);
            }
            case 1: {
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
                if (npc.shock == '\u0000') break;
                npc.act_no = 2;
                npc.act_wait = 0;
                npc.xm = npc.direct == 2 ? -512 : 512;
                npc.ym = 0;
                break;
            }
            case 2: {
                npc.direct = MyChar.gMC.x < npc.x ? 0 : 2;
                if (npc.y > MyChar.gMC.y + 24576) {
                    if (MyChar.gMC.x < npc.x) {
                        npc.xm += 16;
                    }
                    if (MyChar.gMC.x > npc.x) {
                        npc.xm -= 16;
                    }
                } else {
                    if (MyChar.gMC.x < npc.x) {
                        npc.xm -= 16;
                    }
                    if (MyChar.gMC.x > npc.x) {
                        npc.xm += 16;
                    }
                }
                if (MyChar.gMC.y < npc.y) {
                    npc.ym -= 16;
                }
                if (MyChar.gMC.y > npc.y) {
                    npc.ym += 16;
                }
                if (npc.shock != '\u0000') {
                    npc.ym += 32;
                    npc.xm = 0;
                }
                if (npc.xm < 0 && (npc.flag & 1) != 0) {
                    npc.xm = 512;
                }
                if (npc.xm > 0 && (npc.flag & 4) != 0) {
                    npc.xm = -512;
                }
                if (npc.ym < 0 && (npc.flag & 2) != 0) {
                    npc.ym = 512;
                }
                if (npc.ym > 0 && (npc.flag & 8) != 0) {
                    npc.ym = -512;
                }
                if (npc.xm > 1535) {
                    npc.xm = 1535;
                }
                if (npc.xm < -1535) {
                    npc.xm = -1535;
                }
                if (npc.ym > 1535) {
                    npc.ym = 1535;
                }
                if (npc.ym >= -1535) break;
                npc.ym = -1535;
            }
        }
        npc.x += npc.xm;
        npc.y += npc.ym;
        if (npc.shock != '\u0000') {
            npc.ani_no = 4;
        } else {
            if (++npc.ani_wait > 1) {
                npc.ani_wait = 0;
                ++npc.ani_no;
            }
            if (npc.ani_no > 1) {
                npc.ani_no = 0;
            }
        }
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc057_rcLeft[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc057_rcRight[npc.ani_no]);
        }
    }

    public static void ActNpc058(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                if (MyChar.gMC.x < npc.x + 8192 && MyChar.gMC.x > npc.x - 8192) {
                    npc.bits = (char)(npc.bits | 0x20);
                    npc.ym = -256;
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
                if (npc.ym > 256) {
                    npc.ym = 256;
                }
                if (npc.ym < -256) {
                    npc.ym = -256;
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
                    deg = (char)(deg + (Game.Random(-6, 6) & 0xFF) & 0xFF);
                    int ym = Triangle.GetSin(deg) * 2;
                    int xm = Triangle.GetCos(deg) * 2;
                    NpChar.SetNpChar(84, npc.x, npc.y, xm, ym, 0, null, 256);
                    Sound.PlaySoundObject(39, 1);
                }
                if (npc.count2 > 8) {
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
            npc.rect.copyFrom(ActNpc058_rcLeft[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc058_rcRight[npc.ani_no]);
        }
    }

    public static void ActNpc059(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
            }
            case 1: {
                if (npc.x - 32768 >= MyChar.gMC.x || npc.x + 32768 <= MyChar.gMC.x || npc.y - 32768 >= MyChar.gMC.y || npc.y + 32768 <= MyChar.gMC.y) break;
                npc.act_no = 2;
                npc.ani_wait = 0;
                break;
            }
            case 2: {
                if (++npc.ani_wait > 2) {
                    npc.ani_wait = 0;
                    ++npc.ani_no;
                }
                if (npc.ani_no != 2) break;
                npc.act_no = 3;
                break;
            }
            case 3: {
                if (npc.x - 32768 < MyChar.gMC.x && npc.x + 32768 > MyChar.gMC.x && npc.y - 32768 < MyChar.gMC.y && npc.y + 32768 > MyChar.gMC.y) break;
                npc.act_no = 4;
                npc.ani_wait = 0;
                break;
            }
            case 4: {
                if (++npc.ani_wait > 2) {
                    npc.ani_wait = 0;
                    --npc.ani_no;
                }
                if (npc.ani_no != 0) break;
                npc.act_no = 1;
            }
        }
        if (npc.shock != '\u0000') {
            npc.rect.copyFrom(ActNpc059_rcLeft[3]);
        } else {
            npc.rect.copyFrom(ActNpc059_rcLeft[npc.ani_no]);
        }
    }
}
