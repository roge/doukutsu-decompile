/*
 * Decompiled with CFR 0.152.
 */
package jp.studiopixel.doukutsu;

import jp.studiopixel.doukutsu.Back;
import jp.studiopixel.doukutsu.Caret;
import jp.studiopixel.doukutsu.Flash;
import jp.studiopixel.doukutsu.Frame;
import jp.studiopixel.doukutsu.Game;
import jp.studiopixel.doukutsu.MyChar;
import jp.studiopixel.doukutsu.NpChar;
import jp.studiopixel.doukutsu.RECT;
import jp.studiopixel.doukutsu.Sound;
import jp.studiopixel.doukutsu.Triangle;

public class NpcAct080 {
    private static final RECT[] ActNpc080_rcLeft = new RECT[]{new RECT(0, 64, 24, 88), new RECT(24, 64, 48, 88), new RECT(0, 64, 24, 88), new RECT(48, 64, 72, 88), new RECT(72, 64, 96, 88), new RECT(96, 64, 120, 88), new RECT(120, 64, 144, 88)};
    private static final RECT[] ActNpc080_rcRight = new RECT[]{new RECT(0, 88, 24, 112), new RECT(24, 88, 48, 112), new RECT(0, 88, 24, 112), new RECT(48, 88, 72, 112), new RECT(72, 88, 96, 112), new RECT(96, 88, 120, 112), new RECT(120, 88, 144, 112)};
    private static final RECT[] ActNpc081_rcLeft = new RECT[]{new RECT(144, 64, 168, 88), new RECT(168, 64, 192, 88), new RECT(192, 64, 216, 88), new RECT(216, 64, 240, 88), new RECT(144, 64, 168, 88), new RECT(240, 64, 264, 88)};
    private static final RECT[] ActNpc081_rcRight = new RECT[]{new RECT(144, 88, 168, 112), new RECT(168, 88, 192, 112), new RECT(192, 88, 216, 112), new RECT(216, 88, 240, 112), new RECT(144, 88, 168, 112), new RECT(240, 88, 264, 112)};
    private static final RECT[] ActNpc082_rcLeft = new RECT[]{new RECT(80, 0, 96, 16), new RECT(96, 0, 112, 16), new RECT(112, 0, 128, 16), new RECT(128, 0, 144, 16), new RECT(144, 0, 160, 16), new RECT(160, 0, 176, 16), new RECT(176, 0, 192, 16), new RECT(144, 0, 160, 16), new RECT(208, 64, 224, 80)};
    private static final RECT[] ActNpc082_rcRight = new RECT[]{new RECT(80, 16, 96, 32), new RECT(96, 16, 112, 32), new RECT(112, 16, 128, 32), new RECT(128, 16, 144, 32), new RECT(144, 16, 160, 32), new RECT(160, 16, 176, 32), new RECT(176, 16, 192, 32), new RECT(144, 16, 160, 32), new RECT(208, 80, 224, 96)};
    private static final RECT[] ActNpc083_rcLeft = new RECT[]{new RECT(0, 0, 40, 40), new RECT(40, 0, 80, 40), new RECT(80, 0, 120, 40), new RECT(0, 0, 40, 40), new RECT(120, 0, 160, 40), new RECT(0, 0, 40, 40), new RECT(160, 0, 200, 40), new RECT(200, 0, 240, 40)};
    private static final RECT[] ActNpc083_rcRight = new RECT[]{new RECT(0, 40, 40, 80), new RECT(40, 40, 80, 80), new RECT(80, 40, 120, 80), new RECT(0, 40, 40, 80), new RECT(120, 40, 160, 80), new RECT(0, 40, 40, 80), new RECT(160, 40, 200, 80), new RECT(200, 40, 240, 80)};
    private static final RECT[] ActNpc084_rcLeft = new RECT[]{new RECT(48, 48, 64, 64), new RECT(64, 48, 80, 64), new RECT(48, 64, 64, 80), new RECT(64, 64, 80, 80)};
    private static final RECT[] ActNpc085_rcLeft = new RECT[]{new RECT(256, 96, 272, 120), new RECT(256, 96, 272, 120), new RECT(272, 96, 288, 120)};
    private static final RECT[] ActNpc085_rcRight = new RECT[]{new RECT(256, 96, 272, 120), new RECT(288, 96, 304, 120), new RECT(304, 96, 320, 120)};
    private static final RECT[] ActNpc086_rect1 = new RECT[]{new RECT(0, 80, 16, 96), new RECT(16, 80, 32, 96)};
    private static final RECT[] ActNpc086_rect3 = new RECT[]{new RECT(0, 112, 16, 128), new RECT(16, 112, 32, 128)};
    private static final RECT ActNpc086_rcLast = new RECT(16, 0, 32, 16);
    private static final RECT[] ActNpc087_rect2 = new RECT[]{new RECT(32, 80, 48, 96), new RECT(48, 80, 64, 96)};
    private static final RECT[] ActNpc087_rect6 = new RECT[]{new RECT(64, 80, 80, 96), new RECT(80, 80, 96, 96)};
    private static final RECT ActNpc087_rcLast = new RECT(16, 0, 32, 16);
    private static final RECT[] ActNpc088_rcLeft = new RECT[]{new RECT(0, 0, 40, 40), new RECT(40, 0, 80, 40), new RECT(80, 0, 120, 40), new RECT(0, 0, 40, 40), new RECT(120, 0, 160, 40), new RECT(0, 0, 40, 40), new RECT(160, 0, 200, 40), new RECT(200, 0, 240, 40), new RECT(0, 80, 40, 120), new RECT(40, 80, 80, 120), new RECT(240, 0, 280, 40), new RECT(280, 0, 320, 40)};
    private static final RECT[] ActNpc088_rcRight = new RECT[]{new RECT(0, 40, 40, 80), new RECT(40, 40, 80, 80), new RECT(80, 40, 120, 80), new RECT(0, 40, 40, 80), new RECT(120, 40, 160, 80), new RECT(0, 40, 40, 80), new RECT(160, 40, 200, 80), new RECT(200, 40, 240, 80), new RECT(120, 80, 160, 120), new RECT(160, 80, 200, 120), new RECT(240, 40, 280, 80), new RECT(280, 40, 320, 80)};
    private static final RECT[] ActNpc089_rcLeft = new RECT[]{new RECT(80, 80, 120, 120), new RECT(240, 80, 264, 104), new RECT(264, 80, 288, 104), new RECT(288, 80, 312, 104)};
    private static final RECT[] ActNpc089_rcRight = new RECT[]{new RECT(200, 80, 240, 120), new RECT(240, 104, 264, 128), new RECT(264, 104, 288, 128), new RECT(288, 104, 312, 128)};
    private static final RECT ActNpc090_rc = new RECT(280, 80, 296, 104);
    private static final RECT ActNpc091_rc = new RECT(96, 88, 128, 112);
    private static final RECT[] ActNpc092_rcLeft = new RECT[]{new RECT(272, 216, 288, 240), new RECT(288, 216, 304, 240), new RECT(304, 216, 320, 240)};
    private static final RECT[] ActNpc093_rcLeft = new RECT[]{new RECT(128, 0, 144, 16), new RECT(144, 0, 160, 16), new RECT(160, 0, 176, 16), new RECT(128, 0, 144, 16), new RECT(176, 0, 192, 16), new RECT(128, 0, 144, 16), new RECT(32, 32, 48, 48)};
    private static final RECT[] ActNpc093_rcRight = new RECT[]{new RECT(128, 16, 144, 32), new RECT(144, 16, 160, 32), new RECT(160, 16, 176, 32), new RECT(128, 16, 144, 32), new RECT(176, 16, 192, 32), new RECT(128, 16, 144, 32), new RECT(32, 32, 48, 48)};
    private static final RECT[] ActNpc094_rc = new RECT[]{new RECT(272, 0, 320, 24), new RECT(272, 24, 320, 48), new RECT(272, 48, 320, 72), new RECT(272, 72, 320, 96), new RECT(272, 96, 320, 120)};
    private static final RECT[] ActNpc095_rcLeft = new RECT[]{new RECT(208, 64, 224, 80), new RECT(224, 64, 240, 80), new RECT(240, 64, 256, 80), new RECT(256, 64, 272, 80)};
    private static final RECT[] ActNpc095_rcRight = new RECT[]{new RECT(208, 80, 224, 96), new RECT(224, 80, 240, 96), new RECT(240, 80, 256, 96), new RECT(256, 80, 272, 96)};
    private static final RECT[] ActNpc096_rc = new RECT[]{new RECT(272, 120, 288, 136), new RECT(288, 120, 304, 136), new RECT(304, 120, 320, 136)};
    private static final RECT[] ActNpc097_rc = new RECT[]{new RECT(272, 136, 288, 152), new RECT(288, 136, 304, 152), new RECT(304, 136, 320, 152)};
    private static final RECT[] ActNpc098_rc = new RECT[]{new RECT(272, 152, 288, 168), new RECT(288, 152, 304, 168), new RECT(304, 152, 320, 168)};
    private static final RECT[] ActNpc099_rc = new RECT[]{new RECT(272, 168, 288, 184), new RECT(288, 168, 304, 184), new RECT(304, 168, 320, 184)};

    public static void ActNpc080(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.bits = (char)(npc.bits & 0xFFFFFFDF);
                npc.act_no = 1;
                npc.damage = 0;
                npc.hit.front = 2048;
            }
            case 1: {
                npc.ani_no = 0;
                if (npc.x - 65536 < MyChar.gMC.x && npc.x + 65536 > MyChar.gMC.x && npc.y - 24576 < MyChar.gMC.y && npc.y + 16384 > MyChar.gMC.y) {
                    npc.ani_wait = 0;
                    npc.act_no = 2;
                }
                if (npc.shock != '\u0000') {
                    npc.ani_no = 1;
                    npc.ani_wait = 0;
                    npc.act_no = 2;
                    npc.bits = (char)(npc.bits & 0xFFFFFFDF);
                }
                if (MyChar.gMC.x < npc.x) {
                    npc.direct = 0;
                    break;
                }
                npc.direct = 2;
                break;
            }
            case 2: {
                if (++npc.ani_wait > 6) {
                    npc.ani_wait = 0;
                    ++npc.ani_no;
                }
                if (npc.ani_no > 3) {
                    npc.ani_no = 0;
                }
                if (npc.x - 8192 < MyChar.gMC.x && npc.x + 8192 > MyChar.gMC.x) {
                    npc.hit.front = 9216;
                    npc.act_wait = 0;
                    npc.act_no = 3;
                    npc.bits = (char)(npc.bits | 0x20);
                    Sound.PlaySoundObject(34, 1);
                    npc.xm = npc.direct == 0 ? -1024 : 1024;
                }
                if (MyChar.gMC.x < npc.x) {
                    npc.direct = 0;
                    npc.xm = -256;
                    break;
                }
                npc.direct = 2;
                npc.xm = 256;
                break;
            }
            case 3: {
                npc.xm = 0;
                if (++npc.act_wait > 40) {
                    npc.act_wait = 0;
                    npc.act_no = 4;
                    Sound.PlaySoundObject(106, 1);
                }
                npc.ani_no = 4;
                break;
            }
            case 4: {
                npc.damage = 10;
                if (++npc.act_wait > 2) {
                    npc.act_wait = 0;
                    npc.act_no = 5;
                }
                npc.ani_no = 5;
                break;
            }
            case 5: {
                npc.ani_no = 6;
                if (++npc.act_wait <= 60) break;
                npc.act_no = 0;
            }
        }
        if (npc.xm < 0 && (npc.flag & 1) != 0) {
            npc.xm = 0;
        }
        if (npc.xm > 0 && (npc.flag & 4) != 0) {
            npc.xm = 0;
        }
        npc.ym += 32;
        if (npc.xm > 1024) {
            npc.xm = 1024;
        }
        if (npc.xm < -1024) {
            npc.xm = -1024;
        }
        if (npc.ym > 1535) {
            npc.xm = 1535;
        }
        if (npc.ym < -1535) {
            npc.xm = -1535;
        }
        npc.x += npc.xm;
        npc.y += npc.ym;
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc080_rcLeft[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc080_rcRight[npc.ani_no]);
        }
    }

    public static void ActNpc081(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
                npc.ani_no = 0;
                npc.ani_wait = 0;
                npc.xm = 0;
            }
            case 1: {
                if (Game.Random(0, 100) == 1) {
                    npc.act_no = 2;
                    npc.act_wait = 0;
                    npc.ani_no = 1;
                    break;
                }
                if (Game.Random(0, 150) == 1) {
                    npc.direct = npc.direct == 0 ? 2 : 0;
                }
                if (Game.Random(0, 150) != 1) break;
                npc.act_no = 3;
                npc.act_wait = 50;
                npc.ani_no = 0;
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
                if (--npc.act_wait == 0) {
                    npc.act_no = 0;
                }
                if (++npc.ani_wait > 2) {
                    npc.ani_wait = 0;
                    ++npc.ani_no;
                }
                if (npc.ani_no > 4) {
                    npc.ani_no = 2;
                }
                if ((npc.flag & 1) != 0) {
                    npc.direct = 2;
                    npc.xm = 512;
                }
                if ((npc.flag & 4) != 0) {
                    npc.direct = 0;
                    npc.xm = -512;
                }
                if (npc.direct == 0) {
                    npc.xm = -256;
                    break;
                }
                npc.xm = 256;
                break;
            }
            case 5: {
                if ((npc.flag & 8) == 0) break;
                npc.act_no = 0;
            }
        }
        switch (npc.act_no) {
            case 1: 
            case 2: 
            case 4: {
                if (npc.shock == '\u0000') break;
                npc.ym = -512;
                npc.ani_no = 5;
                npc.act_no = 5;
                npc.xm = npc.x < MyChar.gMC.x ? 256 : -256;
            }
        }
        npc.ym += 64;
        if (npc.ym > 1535) {
            npc.ym = 1535;
        }
        npc.x += npc.xm;
        npc.y += npc.ym;
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc081_rcLeft[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc081_rcRight[npc.ani_no]);
        }
    }

    public static void ActNpc082(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
                npc.ani_no = 2;
            }
            case 1: {
                if (Game.Random(0, 120) != 10) break;
                npc.act_no = 2;
                npc.act_wait = 0;
                npc.ani_no = 3;
                break;
            }
            case 2: {
                if (++npc.act_wait <= 8) break;
                npc.act_no = 1;
                npc.ani_no = 2;
                break;
            }
            case 15: {
                npc.act_no = 16;
                npc.act_wait = 0;
                npc.ani_no = 4;
            }
            case 16: {
                if (++npc.act_wait == 30) {
                    Sound.PlaySoundObject(21, 1);
                    NpChar.SetNpChar(66, npc.x, npc.y - 8192, 0, 0, 0, npc, 0);
                }
                if (npc.act_wait != 50) break;
                npc.act_no = 14;
                break;
            }
            case 20: {
                npc.act_no = 21;
                npc.ani_no = 0;
                npc.ym = 0;
                npc.bits = (char)(npc.bits | 8);
            }
            case 21: {
                npc.ym -= 32;
                if (npc.y >= -4096) break;
                npc.cond = 0;
                break;
            }
            case 25: {
                npc.act_no = 26;
                npc.act_wait = 0;
                npc.ani_no = 5;
                npc.ani_wait = 0;
            }
            case 26: {
                if (++npc.ani_no > 7) {
                    npc.ani_no = 5;
                }
                if (++npc.act_wait != 30) break;
                Sound.PlaySoundObject(101, 1);
                Flash.SetFlash(0, 0, 2);
                npc.act_no = 27;
                npc.ani_no = 7;
                break;
            }
            case 27: {
                if (++npc.act_wait != 50) break;
                npc.act_no = 0;
                npc.ani_no = 0;
                break;
            }
            case 30: {
                npc.act_no = 31;
                npc.ani_no = 3;
                npc.ani_wait = 0;
            }
            case 31: {
                if (++npc.ani_wait <= 10) break;
                npc.act_no = 32;
                npc.ani_no = 4;
                npc.ani_wait = 0;
                break;
            }
            case 32: {
                if (++npc.ani_wait <= 100) break;
                npc.act_no = 1;
                npc.ani_no = 2;
                break;
            }
            case 40: {
                npc.act_no = 41;
                npc.act_wait = 0;
            }
            case 41: {
                npc.ani_no = 4;
                switch (++npc.act_wait) {
                    case 30: 
                    case 40: 
                    case 50: {
                        NpChar.SetNpChar(11, npc.x + 4096, npc.y - 4096, 1536, Game.Random(-512, 0), 0, null, 256);
                        Sound.PlaySoundObject(33, 1);
                    }
                }
                if (npc.act_wait <= 50) break;
                npc.act_no = 0;
                break;
            }
            case 50: {
                npc.ani_no = 8;
            }
        }
        npc.x += npc.xm;
        npc.y += npc.ym;
        if (npc.act_no == 11) {
            if (npc.ani_wait != 0) {
                --npc.ani_wait;
                npc.ani_no = 1;
            } else {
                if (Game.Random(0, 100) == 1) {
                    npc.ani_wait = 30;
                }
                npc.ani_no = 0;
            }
        }
        if (npc.act_no == 14) {
            if (npc.ani_wait != 0) {
                --npc.ani_wait;
                npc.ani_no = 3;
            } else {
                if (Game.Random(0, 100) == 1) {
                    npc.ani_wait = 30;
                }
                npc.ani_no = 2;
            }
        }
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc082_rcLeft[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc082_rcRight[npc.ani_no]);
        }
    }

    public static void ActNpc083(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.xm = 0;
                npc.act_no = 1;
                npc.ani_no = 0;
                npc.ani_wait = 0;
            }
            case 1: {
                if (++npc.ani_wait > 5) {
                    npc.ani_wait = 0;
                    ++npc.ani_no;
                }
                if (npc.ani_no <= 1) break;
                npc.ani_no = 0;
                break;
            }
            case 2: {
                npc.act_no = 3;
                npc.ani_no = 2;
                npc.ani_wait = 0;
            }
            case 3: {
                if (++npc.ani_wait > 3) {
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
            case 4: {
                npc.xm = 0;
                npc.act_no = 5;
                npc.act_wait = 0;
                npc.ani_no = 6;
            }
            case 5: {
                if (++npc.act_wait <= 10) break;
                npc.act_wait = 0;
                npc.act_no = 6;
                npc.ani_no = 7;
                Sound.PlaySoundObject(70, 1);
                break;
            }
            case 6: {
                if (++npc.act_wait <= 8) break;
                npc.act_no = 0;
                npc.ani_no = 0;
                break;
            }
            case 7: {
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
            npc.rect.copyFrom(ActNpc083_rcLeft[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc083_rcRight[npc.ani_no]);
        }
    }

    public static void ActNpc084(NpChar.NPCHAR npc) {
        if ((npc.flag & 0xFF) != 0) {
            Caret.SetCaret(npc.x, npc.y, 2, 0);
            npc.cond = 0;
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
        npc.rect.copyFrom(ActNpc084_rcLeft[npc.ani_no]);
        if (++npc.count1 > 300) {
            Caret.SetCaret(npc.x, npc.y, 2, 0);
            npc.cond = 0;
        }
    }

    public static void ActNpc085(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.ani_no = 0;
                if (npc.x - 4096 >= MyChar.gMC.x || npc.x + 4096 <= MyChar.gMC.x || npc.y - 8192 >= MyChar.gMC.y || npc.y + 4096 <= MyChar.gMC.y) break;
                Sound.PlaySoundObject(43, 1);
                npc.act_no = 1;
                break;
            }
            case 1: {
                if (++npc.ani_no <= 2) break;
                npc.ani_no = 1;
            }
        }
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc085_rcLeft[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc085_rcRight[npc.ani_no]);
        }
    }

    public static void ActNpc086(NpChar.NPCHAR npc) {
        if (npc.direct == 0) {
            if (++npc.ani_wait > 2) {
                npc.ani_wait = 0;
                ++npc.ani_no;
            }
            if (npc.ani_no > 1) {
                npc.ani_no = 0;
            }
        }
        if (Back.gBack.type == 5 || Back.gBack.type == 6) {
            if (npc.act_no == 0) {
                npc.act_no = 1;
                npc.ym = Game.Random(-32, 32);
                npc.xm = Game.Random(127, 256);
            }
            npc.xm -= 8;
            if (npc.x < 40960) {
                npc.cond = 0;
            }
            if (npc.x < -1536) {
                npc.x = -1536;
            }
            if ((npc.flag & 1) != 0) {
                npc.xm = 256;
            }
            if ((npc.flag & 2) != 0) {
                npc.ym = 64;
            }
            if ((npc.flag & 8) != 0) {
                npc.ym = -64;
            }
            npc.x += npc.xm;
            npc.y += npc.ym;
        }
        switch (npc.exp) {
            case 1: {
                npc.rect.copyFrom(ActNpc086_rect1[npc.ani_no]);
                break;
            }
            case 3: {
                npc.rect.copyFrom(ActNpc086_rect3[npc.ani_no]);
            }
        }
        if (npc.direct == 0) {
            ++npc.count1;
        }
        if (npc.count1 > 550) {
            npc.cond = 0;
        }
        if (npc.count1 > 500 && npc.count1 / 2 % 2 != 0) {
            npc.rect.right = 0;
        }
        if (npc.count1 > 547) {
            npc.rect.copyFrom(ActNpc086_rcLast);
        }
    }

    public static void ActNpc087(NpChar.NPCHAR npc) {
        if (npc.direct == 0) {
            if (++npc.ani_wait > 2) {
                npc.ani_wait = 0;
                ++npc.ani_no;
            }
            if (npc.ani_no > 1) {
                npc.ani_no = 0;
            }
        }
        if (Back.gBack.type == 5 || Back.gBack.type == 6) {
            if (npc.act_no == 0) {
                npc.act_no = 1;
                npc.ym = Game.Random(-32, 32);
                npc.xm = Game.Random(127, 256);
            }
            npc.xm -= 8;
            if (npc.x < 40960) {
                npc.cond = 0;
            }
            if (npc.x < -1536) {
                npc.x = -1536;
            }
            if ((npc.flag & 1) != 0) {
                npc.xm = 256;
            }
            if ((npc.flag & 2) != 0) {
                npc.ym = 64;
            }
            if ((npc.flag & 8) != 0) {
                npc.ym = -64;
            }
            npc.x += npc.xm;
            npc.y += npc.ym;
        }
        switch (npc.exp) {
            case 2: {
                npc.rect.copyFrom(ActNpc087_rect2[npc.ani_no]);
                break;
            }
            case 6: {
                npc.rect.copyFrom(ActNpc087_rect6[npc.ani_no]);
            }
        }
        if (npc.direct == 0) {
            ++npc.count1;
        }
        if (npc.count1 > 550) {
            npc.cond = 0;
        }
        if (npc.count1 > 500 && npc.count1 / 2 % 2 != 0) {
            npc.rect.right = 0;
        }
        if (npc.count1 > 547) {
            npc.rect.copyFrom(ActNpc087_rcLast);
        }
    }

    public static void ActNpc088(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.xm = 0;
                npc.act_no = 1;
                npc.ani_no = 0;
                npc.ani_wait = 0;
            }
            case 1: {
                if (++npc.ani_wait > 5) {
                    npc.ani_wait = 0;
                    ++npc.ani_no;
                }
                if (npc.ani_no > 1) {
                    npc.ani_no = 0;
                }
                if (++npc.act_wait <= 50) break;
                npc.act_no = 2;
                break;
            }
            case 2: {
                npc.act_no = 3;
                npc.act_wait = 0;
                npc.ani_no = 2;
                npc.ani_wait = 0;
                if (++npc.count1 < 3 || npc.life > 150) {
                    npc.count2 = 0;
                    npc.direct = MyChar.gMC.x < npc.x ? 0 : 2;
                } else {
                    npc.count2 = 1;
                    npc.direct = MyChar.gMC.x < npc.x ? 2 : 0;
                }
            }
            case 3: {
                ++npc.act_wait;
                if (++npc.ani_wait > 3) {
                    npc.ani_wait = 0;
                    ++npc.ani_no;
                }
                if (npc.ani_no > 5) {
                    npc.ani_no = 2;
                }
                npc.xm = npc.direct == 0 ? -512 : 512;
                if (npc.count2 != 0) {
                    if (npc.act_wait <= 16) break;
                    npc.act_no = 9;
                    npc.xm = 0;
                    npc.ani_no = 10;
                    break;
                }
                if (npc.act_wait > 50) {
                    npc.ani_no = 8;
                    npc.ym = -1024;
                    npc.act_no = 7;
                    npc.act_wait = 0;
                    npc.xm = npc.xm * 3 / 2;
                    npc.damage = 2;
                    break;
                }
                if (npc.direct == 0) {
                    if (npc.x - 12288 >= MyChar.gMC.x) break;
                    npc.act_no = 4;
                    break;
                }
                if (npc.x + 12288 <= MyChar.gMC.x) break;
                npc.act_no = 4;
                break;
            }
            case 4: {
                npc.xm = 0;
                npc.act_no = 5;
                npc.act_wait = 0;
                npc.ani_no = 6;
            }
            case 5: {
                if (++npc.act_wait <= 12) break;
                npc.act_wait = 0;
                npc.act_no = 6;
                npc.ani_no = 7;
                Sound.PlaySoundObject(70, 1);
                npc.damage = 5;
                npc.hit.front = 12288;
                npc.hit.top = 1;
                break;
            }
            case 6: {
                if (++npc.act_wait <= 10) break;
                npc.act_no = 0;
                npc.ani_no = 0;
                npc.damage = 0;
                npc.hit.front = 4096;
                npc.hit.top = 8192;
                break;
            }
            case 7: {
                if ((npc.flag & 8) == 0) break;
                npc.act_no = 8;
                npc.ani_no = 9;
                Sound.PlaySoundObject(26, 1);
                Frame.SetQuake(30);
                npc.damage = 0;
                for (int i = 0; i < 4; ++i) {
                    NpChar.SetNpChar(4, npc.x + Game.Random(-12, 12) * 512, npc.y + Game.Random(-12, 12) * 512, Game.Random(-341, 341), Game.Random(-1536, 0), 0, null, 256);
                }
                break;
            }
            case 8: {
                npc.xm = 0;
                if (++npc.act_wait <= 10) break;
                npc.act_no = 0;
                npc.ani_no = 0;
                npc.damage = 0;
                break;
            }
            case 9: {
                npc.act_no = 10;
                npc.act_wait = 0;
                npc.direct = MyChar.gMC.x < npc.x ? 0 : 2;
            }
            case 10: {
                if (++npc.act_wait > 100 && npc.act_wait % 6 == 1) {
                    char deg = npc.direct == 0 ? (char)'\u0088' : '\u00f8';
                    deg = (char)(deg + (char)Game.Random(-16, 16) & 0xFF & 0xFF);
                    int ym = Triangle.GetSin(deg) * 3;
                    int xm = Triangle.GetCos(deg) * 3;
                    NpChar.SetNpChar(11, npc.x, npc.y + 2048, xm, ym, 0, null, 256);
                    Sound.PlaySoundObject(12, 1);
                }
                npc.ani_no = npc.act_wait > 50 && npc.act_wait / 2 % 2 != 0 ? 11 : 10;
                if (npc.act_wait <= 132) break;
                npc.act_no = 0;
                npc.ani_no = 0;
                npc.count1 = 0;
            }
        }
        npc.ym += 64;
        if (npc.ym > 1535) {
            npc.ym = 1535;
        }
        npc.x += npc.xm;
        npc.y += npc.ym;
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc088_rcLeft[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc088_rcRight[npc.ani_no]);
        }
    }

    public static void ActNpc089(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                Sound.PlaySoundObject(72, 1);
                npc.direct = npc.x > MyChar.gMC.x ? 0 : 2;
                for (int i = 0; i < 8; ++i) {
                    NpChar.SetNpChar(4, npc.x + Game.Random(-12, 12) * 512, npc.y + Game.Random(-12, 12) * 512, Game.Random(-341, 341), Game.Random(-1536, 0), 0, null, 256);
                }
                npc.act_no = 1;
            }
            case 1: {
                if (++npc.act_wait > 100) {
                    npc.act_wait = 0;
                    npc.act_no = 2;
                }
                if (npc.act_wait % 5 == 0) {
                    NpChar.SetNpChar(4, npc.x + Game.Random(-12, 12) * 512, npc.y + Game.Random(-12, 12) * 512, Game.Random(-341, 341), Game.Random(-1536, 0), 0, null, 256);
                }
                if (npc.direct == 0) {
                    npc.rect.copyFrom(ActNpc089_rcLeft[0]);
                } else {
                    npc.rect.copyFrom(ActNpc089_rcRight[0]);
                }
                if (npc.act_wait / 2 % 2 == 0) break;
                --npc.rect.left;
                break;
            }
            case 2: {
                if (++npc.act_wait / 2 % 2 != 0 && npc.act_wait < 100) {
                    npc.ani_no = 0;
                    npc.view.back = 10240;
                    npc.view.front = 10240;
                    npc.view.top = 10240;
                } else {
                    npc.ani_no = 1;
                    npc.view.back = 6144;
                    npc.view.front = 6144;
                    npc.view.top = 4096;
                }
                if (npc.act_wait > 150) {
                    npc.act_wait = 0;
                    npc.act_no = 3;
                    npc.ani_no = 1;
                }
                if (npc.act_wait % 9 == 0) {
                    NpChar.SetNpChar(4, npc.x + Game.Random(-12, 12) * 512, npc.y + Game.Random(-12, 12) * 512, Game.Random(-341, 341), Game.Random(-1536, 0), 0, null, 256);
                }
                if (npc.direct == 0) {
                    npc.rect.copyFrom(ActNpc089_rcLeft[npc.ani_no]);
                    break;
                }
                npc.rect.copyFrom(ActNpc089_rcRight[npc.ani_no]);
                break;
            }
            case 3: {
                if (++npc.ani_wait > 50) {
                    npc.ani_wait = 0;
                    ++npc.ani_no;
                }
                if (npc.ani_no == 3) {
                    npc.act_no = 4;
                }
                if (npc.direct == 0) {
                    npc.rect.copyFrom(ActNpc089_rcLeft[npc.ani_no]);
                    break;
                }
                npc.rect.copyFrom(ActNpc089_rcRight[npc.ani_no]);
            }
        }
        npc.ym += 64;
        if (npc.ym > 1535) {
            npc.ym = 1535;
        }
        npc.x += npc.xm;
        npc.y += npc.ym;
    }

    public static void ActNpc090(NpChar.NPCHAR npc) {
        npc.rect.copyFrom(ActNpc090_rc);
    }

    public static void ActNpc091(NpChar.NPCHAR npc) {
        if (npc.act_no == 0) {
            ++npc.act_no;
            npc.y += 8192;
        }
        npc.rect.copyFrom(ActNpc091_rc);
    }

    public static void ActNpc092(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.x -= 2048;
                npc.y += 8192;
                npc.act_no = 1;
                npc.ani_no = 0;
                npc.ani_wait = 0;
            }
            case 1: {
                if (++npc.ani_wait > 2) {
                    npc.ani_wait = 0;
                    ++npc.ani_no;
                }
                if (npc.ani_no > 1) {
                    npc.ani_no = 0;
                }
                if (Game.Random(0, 80) == 1) {
                    npc.act_no = 2;
                    npc.act_wait = 0;
                    npc.ani_no = 1;
                }
                if (Game.Random(0, 120) != 10) break;
                npc.act_no = 3;
                npc.act_wait = 0;
                npc.ani_no = 2;
                break;
            }
            case 2: {
                if (++npc.act_wait <= 40) break;
                npc.act_no = 3;
                npc.act_wait = 0;
                npc.ani_no = 2;
                break;
            }
            case 3: {
                if (++npc.act_wait <= 80) break;
                npc.act_no = 1;
                npc.ani_no = 0;
            }
        }
        npc.rect.copyFrom(ActNpc092_rcLeft[npc.ani_no]);
    }

    public static void ActNpc093(NpChar.NPCHAR npc) {
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
            case 10: {
                npc.ani_no = 6;
                if (++npc.act_wait <= 200) break;
                npc.act_wait = 0;
                Caret.SetCaret(npc.x, npc.y, 5, 0);
            }
        }
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc093_rcLeft[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc093_rcRight[npc.ani_no]);
        }
    }

    public static void ActNpc094(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.ani_no = 4;
                if (npc.shock == '\u0000') break;
                npc.ani_no = 0;
                npc.act_no = 10;
                npc.act_wait = 0;
                break;
            }
            case 10: {
                npc.bits = (char)(npc.bits | 0x20);
                npc.bits = (char)(npc.bits & 0xFFFFFFFB);
                if (++npc.act_wait <= 40) break;
                npc.act_wait = 0;
                npc.ani_wait = 0;
                npc.act_no = 11;
                break;
            }
            case 11: {
                if (++npc.ani_wait > 5) {
                    npc.ani_wait = 0;
                    ++npc.ani_no;
                }
                if (npc.ani_no <= 2) break;
                npc.act_no = 12;
                npc.ani_no = 3;
                break;
            }
            case 12: {
                npc.ym = -341;
                if (++npc.act_wait <= 20) break;
                npc.act_wait = 0;
                npc.act_no = 10;
                npc.ani_no = 0;
                break;
            }
            case 20: {
                npc.xm /= 2;
                npc.ym += 32;
                if (npc.shock != '\u0000') break;
                npc.act_wait = 30;
                npc.act_no = 10;
                npc.ani_no = 0;
            }
        }
        if (npc.shock != '\u0000') {
            if (++npc.count2 > 12) {
                npc.act_no = 20;
                npc.ani_no = 4;
                npc.bits = (char)(npc.bits & 0xFFFFFFDF);
                npc.bits = (char)(npc.bits | 4);
            }
        } else {
            npc.count2 = 0;
        }
        if (npc.act_no >= 10) {
            if ((npc.flag & 1) != 0) {
                npc.count1 = 50;
                npc.direct = 2;
            }
            if ((npc.flag & 4) != 0) {
                npc.count1 = 50;
                npc.direct = 0;
            }
            if (npc.count1 != 0) {
                --npc.count1;
                npc.xm = npc.direct == 0 ? (npc.xm -= 128) : (npc.xm += 128);
            } else {
                npc.count1 = 50;
                npc.direct = npc.x > MyChar.gMC.x ? 0 : 2;
            }
            npc.ym += 16;
            if ((npc.flag & 8) != 0) {
                npc.ym = -1024;
            }
        }
        if (npc.xm > 256) {
            npc.xm = 256;
        }
        if (npc.xm < -256) {
            npc.xm = -256;
        }
        if (npc.ym > 768) {
            npc.ym = 768;
        }
        if (npc.ym < -768) {
            npc.ym = -768;
        }
        npc.x += npc.xm;
        npc.y += npc.ym;
        npc.rect.copyFrom(ActNpc094_rc[npc.ani_no]);
    }

    public static void ActNpc095(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
                npc.act_wait = Game.Random(0, 50);
                npc.tgt_y = npc.y;
                npc.tgt_x = npc.x;
                npc.xm = npc.direct == 0 ? 512 : -512;
            }
            case 1: {
                if (--npc.act_wait > 0) break;
                npc.act_no = 10;
            }
            case 10: {
                if (++npc.act_wait <= 10) break;
                npc.act_wait = 0;
                npc.ani_wait = 0;
                npc.act_no = 11;
                break;
            }
            case 11: {
                if (++npc.ani_wait > 5) {
                    npc.ani_wait = 0;
                    ++npc.ani_no;
                }
                if (npc.ani_no == 2) {
                    npc.xm = npc.direct == 0 ? (npc.xm -= 256) : (npc.xm += 256);
                    npc.ym -= 512;
                }
                if (npc.ani_no <= 2) break;
                npc.act_no = 12;
                npc.ani_no = 3;
                break;
            }
            case 12: {
                ++npc.act_wait;
                if (npc.y <= npc.tgt_y || npc.act_wait <= 10) break;
                npc.act_wait = 0;
                npc.act_no = 10;
                npc.ani_no = 0;
            }
        }
        npc.direct = npc.x > npc.tgt_x ? 0 : 2;
        if ((npc.flag & 1) != 0) {
            npc.count1 = 50;
            npc.direct = 2;
        }
        if ((npc.flag & 4) != 0) {
            npc.count1 = 50;
            npc.direct = 0;
        }
        npc.ym += 32;
        if ((npc.flag & 8) != 0) {
            npc.ym = -1024;
        }
        if (npc.xm > 256) {
            npc.xm = 256;
        }
        if (npc.xm < -256) {
            npc.xm = -256;
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
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc095_rcLeft[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc095_rcRight[npc.ani_no]);
        }
    }

    public static void ActNpc096(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                if (npc.direct == 2) {
                    npc.act_no = 2;
                } else {
                    npc.ani_no = 1;
                }
            }
            case 1: {
                npc.ani_no = 0;
                break;
            }
            case 2: {
                if (++npc.ani_wait > 0) {
                    npc.ani_wait = 0;
                    ++npc.ani_no;
                }
                if (npc.ani_no > 2) {
                    npc.ani_no = 0;
                }
                if (MyChar.gMC.x > npc.x - 163840 && MyChar.gMC.x < npc.x + 163840 && MyChar.gMC.y > npc.y - 122880 && MyChar.gMC.y < npc.y + 122880 && Game.Random(0, 5) == 1) {
                    NpChar.SetNpChar(199, npc.x, npc.y + Game.Random(-8, 8) * 512, 0, 0, 0, null, 256);
                }
                if (MyChar.gMC.y >= npc.y + 4096 || MyChar.gMC.y <= npc.y - 4096 || MyChar.gMC.x >= npc.x || MyChar.gMC.x <= npc.x - 49152) break;
                MyChar.gMC.xm -= 136;
                MyChar.gMC.cond = (char)(MyChar.gMC.cond | 0x20);
            }
        }
        npc.rect.copyFrom(ActNpc096_rc[npc.ani_no]);
    }

    public static void ActNpc097(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                if (npc.direct == 2) {
                    npc.act_no = 2;
                } else {
                    npc.ani_no = 1;
                }
            }
            case 1: {
                npc.ani_no = 0;
                break;
            }
            case 2: {
                if (++npc.ani_wait > 0) {
                    npc.ani_wait = 0;
                    ++npc.ani_no;
                }
                if (npc.ani_no > 2) {
                    npc.ani_no = 0;
                }
                if (MyChar.gMC.x > npc.x - 163840 && MyChar.gMC.x < npc.x + 163840 && MyChar.gMC.y > npc.y - 122880 && MyChar.gMC.y < npc.y + 122880 && Game.Random(0, 5) == 1) {
                    NpChar.SetNpChar(199, npc.x + Game.Random(-8, 8) * 512, npc.y, 0, 0, 1, null, 256);
                }
                if (MyChar.gMC.x >= npc.x + 4096 || MyChar.gMC.x <= npc.x - 4096 || MyChar.gMC.y >= npc.y || MyChar.gMC.y <= npc.y - 49152) break;
                MyChar.gMC.ym -= 136;
            }
        }
        npc.rect.copyFrom(ActNpc097_rc[npc.ani_no]);
    }

    public static void ActNpc098(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                if (npc.direct == 2) {
                    npc.act_no = 2;
                } else {
                    npc.ani_no = 1;
                }
            }
            case 1: {
                npc.ani_no = 0;
                break;
            }
            case 2: {
                if (++npc.ani_wait > 0) {
                    npc.ani_wait = 0;
                    ++npc.ani_no;
                }
                if (npc.ani_no > 2) {
                    npc.ani_no = 0;
                }
                if (MyChar.gMC.x > npc.x - 163840 && MyChar.gMC.x < npc.x + 163840 && MyChar.gMC.y > npc.y - 122880 && MyChar.gMC.y < npc.y + 122880 && Game.Random(0, 5) == 1) {
                    NpChar.SetNpChar(199, npc.x, npc.y + Game.Random(-8, 8) * 512, 0, 0, 2, null, 256);
                }
                if (MyChar.gMC.y >= npc.y + 4096 || MyChar.gMC.y <= npc.y - 4096 || MyChar.gMC.x >= npc.x + 49152 || MyChar.gMC.x <= npc.x) break;
                MyChar.gMC.xm += 136;
                MyChar.gMC.cond = (char)(MyChar.gMC.cond | 0x20);
            }
        }
        npc.rect.copyFrom(ActNpc098_rc[npc.ani_no]);
    }

    public static void ActNpc099(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                if (npc.direct == 2) {
                    npc.act_no = 2;
                } else {
                    npc.ani_no = 1;
                }
            }
            case 1: {
                npc.ani_no = 0;
                break;
            }
            case 2: {
                if (++npc.ani_wait > 0) {
                    npc.ani_wait = 0;
                    ++npc.ani_no;
                }
                if (npc.ani_no > 2) {
                    npc.ani_no = 0;
                }
                if (MyChar.gMC.x > npc.x - 163840 && MyChar.gMC.x < npc.x + 163840 && MyChar.gMC.y > npc.y - 122880 && MyChar.gMC.y < npc.y + 122880 && Game.Random(0, 5) == 1) {
                    NpChar.SetNpChar(199, npc.x + Game.Random(-8, 8) * 512, npc.y, 0, 0, 3, null, 256);
                }
                if (MyChar.gMC.x >= npc.x + 4096 || MyChar.gMC.x <= npc.x - 4096 || MyChar.gMC.y >= npc.y + 49152 || MyChar.gMC.y <= npc.y) break;
                MyChar.gMC.ym += 136;
            }
        }
        npc.rect.copyFrom(ActNpc099_rc[npc.ani_no]);
    }
}
