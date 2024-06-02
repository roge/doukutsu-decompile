/*
 * Decompiled with CFR 0.152.
 */
package jp.studiopixel.doukutsu;

import jp.studiopixel.doukutsu.Bullet;
import jp.studiopixel.doukutsu.Caret;
import jp.studiopixel.doukutsu.Frame;
import jp.studiopixel.doukutsu.Game;
import jp.studiopixel.doukutsu.KeyControl;
import jp.studiopixel.doukutsu.MyChar;
import jp.studiopixel.doukutsu.NpChar;
import jp.studiopixel.doukutsu.RECT;
import jp.studiopixel.doukutsu.Sound;
import jp.studiopixel.doukutsu.Triangle;

public class NpcAct120 {
    private static final RECT[] ActNpc120_rect = new RECT[]{new RECT(64, 0, 80, 16), new RECT(64, 16, 80, 32)};
    private static final RECT[] ActNpc121_rect = new RECT[]{new RECT(0, 0, 16, 16), new RECT(16, 0, 32, 16), new RECT(112, 0, 128, 16)};
    private static final RECT[] ActNpc122_rcLeft = new RECT[]{new RECT(0, 0, 16, 16), new RECT(16, 0, 32, 16), new RECT(32, 0, 48, 16), new RECT(0, 0, 16, 16), new RECT(48, 0, 64, 16), new RECT(0, 0, 16, 16), new RECT(80, 0, 96, 16), new RECT(96, 0, 112, 16), new RECT(112, 0, 128, 16), new RECT(128, 0, 144, 16)};
    private static final RECT[] ActNpc122_rcRight = new RECT[]{new RECT(0, 16, 16, 32), new RECT(16, 16, 32, 32), new RECT(32, 16, 48, 32), new RECT(0, 16, 16, 32), new RECT(48, 16, 64, 32), new RECT(0, 16, 16, 32), new RECT(80, 16, 96, 32), new RECT(96, 16, 112, 32), new RECT(112, 16, 128, 32), new RECT(128, 16, 144, 32)};
    private static final RECT[] ActNpc123_rect = new RECT[]{new RECT(192, 0, 208, 16), new RECT(208, 0, 224, 16), new RECT(224, 0, 240, 16), new RECT(240, 0, 256, 16)};
    private static final RECT[] ActNpc124_rect = new RECT[]{new RECT(160, 0, 192, 32), new RECT(192, 0, 224, 32)};
    private static final RECT[] ActNpc125_rc = new RECT[]{new RECT(0, 96, 16, 112), new RECT(16, 96, 32, 112)};
    private static final RECT[] ActNpc126_rcLeft = new RECT[]{new RECT(48, 144, 64, 160), new RECT(64, 144, 80, 160), new RECT(48, 144, 64, 160), new RECT(80, 144, 96, 160), new RECT(96, 144, 112, 160), new RECT(112, 144, 128, 160)};
    private static final RECT[] ActNpc126_rcRight = new RECT[]{new RECT(48, 160, 64, 176), new RECT(64, 160, 80, 176), new RECT(48, 160, 64, 176), new RECT(80, 160, 96, 176), new RECT(96, 160, 112, 176), new RECT(112, 160, 128, 176)};
    private static final RECT[] ActNpc127_rcV = new RECT[]{new RECT(112, 48, 128, 64), new RECT(112, 64, 128, 80), new RECT(112, 80, 128, 96)};
    private static final RECT[] ActNpc127_rcH = new RECT[]{new RECT(64, 80, 80, 96), new RECT(80, 80, 96, 96), new RECT(96, 80, 112, 96)};
    private static final RECT[] ActNpc128_rcLeft = new RECT[]{new RECT(0, 0, 0, 0), new RECT(176, 16, 184, 32), new RECT(184, 16, 192, 32), new RECT(192, 16, 200, 32), new RECT(200, 16, 208, 32)};
    private static final RECT[] ActNpc128_rcRight = new RECT[]{new RECT(0, 0, 0, 0), new RECT(232, 16, 240, 32), new RECT(224, 16, 232, 32), new RECT(216, 16, 224, 32), new RECT(208, 16, 216, 32)};
    private static final RECT[] ActNpc128_rcUp = new RECT[]{new RECT(0, 0, 0, 0), new RECT(176, 32, 192, 40), new RECT(176, 40, 192, 48), new RECT(192, 32, 208, 40), new RECT(192, 40, 208, 48)};
    private static final RECT[] ActNpc128_rcDown = new RECT[]{new RECT(0, 0, 0, 0), new RECT(208, 32, 224, 40), new RECT(208, 40, 224, 48), new RECT(224, 32, 232, 40), new RECT(224, 40, 232, 48)};
    private static final RECT[] ActNpc129_rect = new RECT[]{new RECT(128, 48, 144, 64), new RECT(144, 48, 160, 64), new RECT(160, 48, 176, 64), new RECT(128, 64, 144, 80), new RECT(144, 64, 160, 80), new RECT(160, 64, 176, 80), new RECT(128, 80, 144, 96), new RECT(144, 80, 160, 96), new RECT(160, 80, 176, 96), new RECT(176, 48, 192, 64), new RECT(192, 48, 208, 64), new RECT(208, 48, 224, 64), new RECT(176, 64, 192, 80), new RECT(192, 64, 208, 80), new RECT(208, 64, 224, 80), new RECT(176, 80, 192, 96), new RECT(192, 80, 208, 96), new RECT(208, 80, 224, 96)};
    private static final RECT[] ActNpc130_rcLeft = new RECT[]{new RECT(48, 144, 64, 160), new RECT(64, 144, 80, 160), new RECT(48, 144, 64, 160), new RECT(80, 144, 96, 160)};
    private static final RECT[] ActNpc130_rcRight = new RECT[]{new RECT(48, 160, 64, 176), new RECT(64, 160, 80, 176), new RECT(48, 160, 64, 176), new RECT(80, 160, 96, 176)};
    private static final RECT[] ActNpc131_rcLeft = new RECT[]{new RECT(144, 144, 160, 160)};
    private static final RECT[] ActNpc131_rcRight = new RECT[]{new RECT(144, 160, 160, 176)};
    private static final RECT[] ActNpc132_rcLeft = new RECT[]{new RECT(48, 144, 64, 160), new RECT(64, 144, 80, 160), new RECT(96, 144, 112, 160), new RECT(96, 144, 112, 160), new RECT(128, 144, 144, 160)};
    private static final RECT[] ActNpc132_rcRight = new RECT[]{new RECT(48, 160, 64, 176), new RECT(64, 160, 80, 176), new RECT(96, 160, 112, 176), new RECT(96, 160, 112, 176), new RECT(128, 160, 144, 176)};
    private static final RECT[] ActNpc133_rcLeft = new RECT[]{new RECT(176, 32, 192, 48), new RECT(192, 32, 208, 48)};
    private static final RECT[] ActNpc133_rcRight = new RECT[]{new RECT(176, 48, 192, 64), new RECT(192, 48, 208, 64)};
    private static final RECT[] ActNpc134_rcLeft = new RECT[]{new RECT(224, 0, 256, 16), new RECT(256, 0, 288, 16), new RECT(288, 0, 320, 16)};
    private static final RECT[] ActNpc134_rcRight = new RECT[]{new RECT(224, 16, 256, 32), new RECT(256, 16, 288, 32), new RECT(288, 16, 320, 32)};
    private static final RECT[] ActNpc135_rcLeft = new RECT[]{new RECT(256, 32, 288, 64), new RECT(288, 32, 320, 64)};
    private static final RECT[] ActNpc135_rcRight = new RECT[]{new RECT(256, 64, 288, 96), new RECT(288, 64, 320, 96)};
    private static final RECT[] ActNpc136_rcLeft = new RECT[]{new RECT(48, 144, 64, 160), new RECT(64, 144, 80, 160)};
    private static final RECT[] ActNpc136_rcRight = new RECT[]{new RECT(48, 160, 64, 176), new RECT(64, 160, 80, 176)};
    private static final RECT ActNpc137_rc = new RECT(96, 136, 128, 188);
    private static final RECT ActNpc138_rcLeft = new RECT(96, 112, 112, 136);
    private static final RECT ActNpc138_rcRight = new RECT(112, 112, 128, 136);
    private static final RECT[] ActNpc139_rcLeft = new RECT[]{new RECT(0, 128, 24, 160), new RECT(24, 128, 48, 160), new RECT(48, 128, 72, 160)};
    private static final RECT[] ActNpc139_rcRight = new RECT[]{new RECT(0, 160, 24, 192), new RECT(24, 160, 48, 192), new RECT(48, 160, 72, 192)};

    public static void ActNpc120(NpChar.NPCHAR npc) {
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc120_rect[0]);
        } else {
            npc.rect.copyFrom(ActNpc120_rect[1]);
        }
    }

    public static void ActNpc121(NpChar.NPCHAR npc) {
        if (npc.direct == 0) {
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
            npc.rect.copyFrom(ActNpc121_rect[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc121_rect[2]);
            if (++npc.act_wait > 100) {
                npc.act_wait = 0;
                Caret.SetCaret(npc.x, npc.y, 5, 0);
            }
        }
    }

    public static void ActNpc122(NpChar.NPCHAR npc) {
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
            case 10: {
                npc.life = 1000;
                npc.act_no = 11;
                npc.act_wait = Game.Random(0, 50);
                npc.ani_no = 0;
                npc.damage = 0;
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
                npc.act_wait = Game.Random(0, 50);
                npc.direct = npc.x > MyChar.gMC.x ? 0 : 2;
            }
            case 14: {
                if (++npc.ani_wait > 2) {
                    npc.ani_wait = 0;
                    ++npc.ani_no;
                }
                if (npc.ani_no > 5) {
                    npc.ani_no = 2;
                }
                npc.xm = npc.direct == 0 ? (npc.xm -= 64) : (npc.xm += 64);
                if (npc.act_wait != 0) {
                    --npc.act_wait;
                    break;
                }
                npc.bits = (char)(npc.bits | 0x20);
                npc.act_no = 15;
                npc.ani_no = 2;
                npc.ym = -512;
                npc.damage = 2;
                break;
            }
            case 15: {
                if ((npc.flag & 8) == 0) break;
                npc.bits = (char)(npc.bits | 0x20);
                npc.xm = 0;
                npc.act_no = 10;
                npc.damage = 0;
                break;
            }
            case 20: {
                if ((npc.flag & 8) == 0) break;
                npc.xm = 0;
                npc.act_no = 21;
                npc.damage = 0;
                npc.ani_no = npc.ani_no == 6 ? 8 : 9;
                npc.act_wait = Game.Random(300, 400);
                break;
            }
            case 21: {
                if (npc.act_wait != 0) {
                    --npc.act_wait;
                    break;
                }
                npc.bits = (char)(npc.bits | 0x20);
                npc.life = 1000;
                npc.act_no = 11;
                npc.act_wait = Game.Random(0, 50);
                npc.ani_no = 0;
            }
        }
        if (npc.act_no > 10 && npc.act_no < 20 && npc.life != 1000) {
            npc.act_no = 20;
            npc.ym = -512;
            npc.ani_no = Game.Random(6, 7);
            npc.bits = (char)(npc.bits & 0xFFFFFFDF);
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
            npc.rect.copyFrom(ActNpc122_rcLeft[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc122_rcRight[npc.ani_no]);
        }
    }

    public static void ActNpc123(NpChar.NPCHAR npc) {
        boolean bBreak = false;
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
                Caret.SetCaret(npc.x, npc.y, 3, 0);
                Sound.PlaySoundObject(32, 1);
                switch (npc.direct) {
                    case 0: {
                        npc.xm = -4096;
                        npc.ym = Game.Random(-128, 128);
                        break;
                    }
                    case 1: {
                        npc.ym = -4096;
                        npc.xm = Game.Random(-128, 128);
                        break;
                    }
                    case 2: {
                        npc.xm = 4096;
                        npc.ym = Game.Random(-128, 128);
                        break;
                    }
                    case 3: {
                        npc.ym = 4096;
                        npc.xm = Game.Random(-128, 128);
                    }
                }
                break;
            }
            case 1: {
                switch (npc.direct) {
                    case 0: {
                        if ((npc.flag & 1) == 0) break;
                        bBreak = true;
                        break;
                    }
                    case 1: {
                        if ((npc.flag & 2) == 0) break;
                        bBreak = true;
                        break;
                    }
                    case 2: {
                        if ((npc.flag & 4) == 0) break;
                        bBreak = true;
                        break;
                    }
                    case 3: {
                        if ((npc.flag & 8) == 0) break;
                        bBreak = true;
                    }
                }
                npc.x += npc.xm;
                npc.y += npc.ym;
            }
        }
        if (bBreak) {
            Caret.SetCaret(npc.x, npc.y, 2, 2);
            Sound.PlaySoundObject(28, 1);
            npc.cond = 0;
        }
        npc.rect.copyFrom(ActNpc123_rect[npc.direct]);
    }

    public static void ActNpc124(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
                npc.x += 4096;
                npc.y += 4096;
            }
            case 1: {
                npc.bits = (char)(npc.bits & 0xFFFFFFF7);
                npc.ani_no = 0;
                break;
            }
            case 10: {
                npc.act_no = 11;
                npc.ani_no = 1;
                npc.act_wait = 0;
                npc.bits = (char)(npc.bits | 8);
            }
            case 11: {
                switch (npc.direct) {
                    case 0: {
                        npc.x -= 128;
                        break;
                    }
                    case 1: {
                        npc.y -= 128;
                        break;
                    }
                    case 2: {
                        npc.x += 128;
                        break;
                    }
                    case 3: {
                        npc.y += 128;
                    }
                }
                if (++npc.act_wait % 8 == 0) {
                    Sound.PlaySoundObject(26, 1);
                }
                Frame.SetQuake(20);
            }
        }
        npc.rect.copyFrom(ActNpc124_rect[npc.ani_no]);
    }

    public static void ActNpc125(NpChar.NPCHAR npc) {
        if (npc.life < 990) {
            NpChar.SetDestroyNpChar(npc.x, npc.y, npc.view.back, 8);
            Sound.PlaySoundObject(70, 1);
            if (npc.direct == 0) {
                NpChar.SetNpChar(87, npc.x, npc.y, 0, 0, 2, null, 0);
            } else {
                NpChar.SetNpChar(86, npc.x, npc.y, 0, 0, 2, null, 0);
            }
            npc.cond = 0;
        }
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc125_rc[0]);
        } else {
            npc.rect.copyFrom(ActNpc125_rc[1]);
        }
    }

    public static void ActNpc126(NpChar.NPCHAR npc) {
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
                if (npc.x - 49152 < MyChar.gMC.x && npc.x + 49152 > MyChar.gMC.x && npc.y - 16384 < MyChar.gMC.y && npc.y + 8192 > MyChar.gMC.y) {
                    npc.direct = npc.x > MyChar.gMC.x ? 0 : 2;
                }
                if (npc.x - 16384 >= MyChar.gMC.x || npc.x + 16384 <= MyChar.gMC.x || npc.y - 16384 >= MyChar.gMC.y || npc.y + 8192 <= MyChar.gMC.y) break;
                npc.direct = npc.x > MyChar.gMC.x ? 2 : 0;
                npc.act_no = 10;
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
                npc.ani_no = 4;
                npc.ani_wait = 0;
            }
            case 11: {
                if ((npc.flag & 8) != 0) {
                    if (++npc.ani_wait > 2) {
                        npc.ani_wait = 0;
                        ++npc.ani_no;
                    }
                    if (npc.ani_no > 5) {
                        npc.ani_no = 4;
                    }
                } else {
                    npc.ani_no = 5;
                    npc.ani_wait = 0;
                }
                if (npc.xm < 0 && (npc.flag & 1) != 0) {
                    npc.xm /= -2;
                    npc.direct = 2;
                }
                if (npc.xm > 0 && (npc.flag & 4) != 0) {
                    npc.xm /= -2;
                    npc.direct = 0;
                }
                npc.xm = npc.direct == 0 ? (npc.xm -= 64) : (npc.xm += 64);
                if (npc.xm > 1535) {
                    npc.xm = 1024;
                }
                if (npc.xm >= -1535) break;
                npc.xm = -1024;
            }
        }
        npc.bits = (KeyControl.gKeyTrg & KeyControl.gKeyDown) != 0 ? (char)(npc.bits | 0x2000) : (char)(npc.bits & 0xFFFFDFFF);
        npc.ym += 64;
        if (npc.ym > 1535) {
            npc.ym = 1535;
        }
        npc.x += npc.xm;
        npc.y += npc.ym;
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc126_rcLeft[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc126_rcRight[npc.ani_no]);
        }
    }

    public static void ActNpc127(NpChar.NPCHAR npc) {
        if (++npc.ani_wait > 0) {
            npc.ani_wait = 0;
            if (++npc.ani_no > 2) {
                npc.cond = 0;
                return;
            }
        }
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc127_rcH[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc127_rcV[npc.ani_no]);
        }
    }

    public static void ActNpc128(NpChar.NPCHAR npc) {
        if (npc.act_no == 0) {
            npc.act_no = 1;
            if (npc.direct == 0 || npc.direct == 2) {
                npc.view.front = 2048;
                npc.view.top = 4096;
            } else {
                npc.view.front = 4096;
                npc.view.top = 2048;
            }
        }
        if (++npc.ani_no > 4) {
            npc.cond = 0;
            return;
        }
        switch (npc.direct) {
            case 0: {
                npc.rect.copyFrom(ActNpc128_rcLeft[npc.ani_no]);
                break;
            }
            case 1: {
                npc.rect.copyFrom(ActNpc128_rcUp[npc.ani_no]);
                break;
            }
            case 2: {
                npc.rect.copyFrom(ActNpc128_rcRight[npc.ani_no]);
                break;
            }
            case 3: {
                npc.rect.copyFrom(ActNpc128_rcDown[npc.ani_no]);
            }
        }
    }

    public static void ActNpc129(NpChar.NPCHAR npc) {
        if (++npc.ani_wait > 1) {
            npc.ani_wait = 0;
            if (++npc.ani_no > 2) {
                npc.cond = 0;
                return;
            }
        }
        npc.y += npc.ym;
        npc.rect.copyFrom(ActNpc129_rect[npc.direct * 3 + npc.ani_no]);
    }

    public static void ActNpc130(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
                npc.ani_no = 0;
                npc.ani_wait = 0;
                npc.bits = (char)(npc.bits | 0x2000);
            }
            case 1: {
                if (Game.Random(0, 120) == 10) {
                    npc.act_no = 2;
                    npc.act_wait = 0;
                    npc.ani_no = 1;
                }
                if (npc.x - 32768 < MyChar.gMC.x && npc.x + 32768 > MyChar.gMC.x && npc.y - 16384 < MyChar.gMC.y && npc.y + 8192 > MyChar.gMC.y) {
                    if (++npc.ani_wait > 3) {
                        npc.ani_wait = 0;
                        ++npc.ani_no;
                    }
                    if (npc.ani_no > 3) {
                        npc.ani_no = 2;
                    }
                }
                if (npc.x - 49152 >= MyChar.gMC.x || npc.x + 49152 <= MyChar.gMC.x || npc.y - 16384 >= MyChar.gMC.y || npc.y + 8192 <= MyChar.gMC.y) break;
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
            }
        }
        npc.ym += 64;
        if (npc.ym > 1535) {
            npc.ym = 1535;
        }
        npc.x += npc.xm;
        npc.y += npc.ym;
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc130_rcLeft[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc130_rcRight[npc.ani_no]);
        }
    }

    public static void ActNpc131(NpChar.NPCHAR npc) {
        if (++npc.act_wait > 100) {
            npc.act_wait = 0;
            Caret.SetCaret(npc.x, npc.y, 5, 0);
        }
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc131_rcLeft[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc131_rcRight[npc.ani_no]);
        }
    }

    public static void ActNpc132(NpChar.NPCHAR npc) {
        if (npc.act_no < 100) {
            npc.direct = MyChar.gMC.x < npc.x ? 0 : 2;
        }
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
                if (npc.x - 32768 < MyChar.gMC.x && npc.x + 32768 > MyChar.gMC.x && npc.y - 8192 < MyChar.gMC.y && npc.y + 8192 > MyChar.gMC.y) {
                    if (++npc.ani_wait > 4) {
                        npc.ani_wait = 0;
                        ++npc.ani_no;
                    }
                    if (npc.ani_no > 4) {
                        npc.ani_no = 2;
                    }
                    if (npc.ani_no != 4 || npc.ani_wait != 0) break;
                    Sound.PlaySoundObject(105, 1);
                    break;
                }
                if (npc.ani_no != 4) break;
                npc.ani_no = 2;
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
                break;
            }
            case 100: {
                npc.act_no = 101;
                npc.count1 = 0;
            }
            case 101: {
                if (++npc.ani_wait > 4) {
                    npc.ani_wait = 0;
                    ++npc.ani_no;
                }
                if (npc.ani_no > 4) {
                    if (npc.count1 < 3) {
                        npc.ani_no = 2;
                        ++npc.count1;
                    } else {
                        npc.ani_no = 0;
                        npc.count1 = 0;
                    }
                }
                if (npc.ani_no != 4 || npc.ani_wait != 0) break;
                Sound.PlaySoundObject(105, 1);
                break;
            }
            case 120: {
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
            npc.rect.copyFrom(ActNpc132_rcLeft[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc132_rcRight[npc.ani_no]);
        }
    }

    public static void ActNpc133(NpChar.NPCHAR npc) {
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
            npc.rect.copyFrom(ActNpc133_rcLeft[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc133_rcRight[npc.ani_no]);
        }
    }

    public static void ActNpc134(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
                npc.ani_no = 2;
                npc.bits = (char)(npc.bits & 0xFFFFFFDF);
                npc.bits = (char)(npc.bits | 4);
            }
            case 1: {
                if (MyChar.gMC.x <= npc.x - 163840 || MyChar.gMC.x >= npc.x + 163840 || MyChar.gMC.y <= npc.y - 81920 || MyChar.gMC.y >= npc.y + 32768) break;
                npc.act_no = 10;
                npc.bits = (char)(npc.bits | 0x20);
                npc.bits = (char)(npc.bits & 0xFFFFFFFB);
                break;
            }
            case 10: {
                if (++npc.ani_wait > 4) {
                    npc.ani_wait = 0;
                    ++npc.ani_no;
                }
                if (npc.ani_no > 1) {
                    npc.ani_no = 0;
                }
                if (npc.direct == 0 && (npc.flag & 1) != 0) {
                    npc.direct = 2;
                }
                if (npc.direct == 2 && (npc.flag & 4) != 0) {
                    npc.direct = 0;
                }
                npc.x = npc.direct == 0 ? (npc.x -= 256) : (npc.x += 256);
                if (Bullet.CountArmsBullet(6) == 0) break;
                npc.act_no = 20;
                npc.act_wait = 0;
                npc.ani_no = 2;
                npc.bits = (char)(npc.bits & 0xFFFFFFDF);
                npc.bits = (char)(npc.bits | 4);
                break;
            }
            case 20: {
                if (++npc.act_wait <= 100) break;
                npc.act_no = 10;
                npc.ani_no = 0;
                npc.ani_wait = 0;
                npc.bits = (char)(npc.bits | 0x20);
                npc.bits = (char)(npc.bits & 0xFFFFFFFB);
            }
        }
        npc.ym += 64;
        if (npc.ym > 1535) {
            npc.ym = 1535;
        }
        npc.y += npc.ym;
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc134_rcLeft[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc134_rcRight[npc.ani_no]);
        }
    }

    public static void ActNpc135(NpChar.NPCHAR npc) {
        if (MyChar.gMC.x < npc.x - 180224 || MyChar.gMC.x > npc.x + 180224 || MyChar.gMC.y < npc.y - 81920 || MyChar.gMC.y > npc.y + 32768) {
            npc.act_no = 0;
        }
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
                npc.xm = 0;
            }
            case 1: {
                if (MyChar.gMC.x > npc.x - 163840 && MyChar.gMC.x < npc.x + 163840 && MyChar.gMC.y > npc.y - 81920 && MyChar.gMC.y < npc.y + 32768) {
                    npc.act_no = 10;
                }
                if ((npc.flag & 8) == 0) break;
                npc.ani_no = 0;
                break;
            }
            case 10: {
                npc.xm = 0;
                npc.act_no = 11;
                npc.act_wait = 0;
                npc.ani_no = 0;
            }
            case 11: {
                if (++npc.act_wait < 5 || (npc.flag & 8) == 0) break;
                npc.act_no = 20;
                npc.ani_no = 1;
                npc.count1 = 0;
                npc.ym = -512 * Game.Random(1, 3);
                if (npc.shock != '\u0000') {
                    if (npc.x < MyChar.gMC.x) {
                        npc.xm -= 256;
                        break;
                    }
                    npc.xm += 256;
                    break;
                }
                if (npc.x < MyChar.gMC.x) {
                    npc.xm += 256;
                    break;
                }
                npc.xm -= 256;
                break;
            }
            case 20: {
                if (npc.ym > 0 && npc.count1 == 0) {
                    ++npc.count1;
                    char deg = (char)Triangle.GetArktan(npc.x - MyChar.gMC.x, npc.y + 2048 - MyChar.gMC.y);
                    int ym = Triangle.GetSin(deg) * 2;
                    int xm = Triangle.GetCos(deg) * 2;
                    NpChar.SetNpChar(50, npc.x, npc.y, xm, ym, 0, null, 384);
                    Sound.PlaySoundObject(39, 1);
                }
                if ((npc.flag & 8) == 0) break;
                npc.act_no = 10;
                npc.ani_no = 0;
            }
        }
        if (npc.act_no >= 10) {
            npc.direct = npc.x > MyChar.gMC.x ? 0 : 2;
        }
        npc.ym += 51;
        if (npc.ym > 1535) {
            npc.ym = 1535;
        }
        if (npc.xm > 1535) {
            npc.xm = 1535;
        }
        if (npc.xm < -1535) {
            npc.xm = -1535;
        }
        npc.y += npc.ym;
        npc.x += npc.xm;
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc135_rcLeft[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc135_rcRight[npc.ani_no]);
        }
    }

    public static void ActNpc136(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.bits = (char)(npc.bits & 0xFFFFDFFF);
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
        npc.direct = MyChar.gMC.direct == 0 ? 0 : 2;
        npc.y = MyChar.gMC.y - 5120;
        if (npc.direct == 0) {
            npc.x = MyChar.gMC.x + 2048;
            npc.rect.copyFrom(ActNpc136_rcLeft[npc.ani_no]);
        } else {
            npc.x = MyChar.gMC.x - 2048;
            npc.rect.copyFrom(ActNpc136_rcRight[npc.ani_no]);
        }
        if (MyChar.gMC.ani_no % 2 != 0) {
            ++npc.rect.top;
        }
    }

    public static void ActNpc137(NpChar.NPCHAR npc) {
        npc.rect.copyFrom(ActNpc137_rc);
    }

    public static void ActNpc138(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
                if (npc.direct == 0) {
                    npc.rect.copyFrom(ActNpc138_rcLeft);
                    npc.x += 4096;
                } else {
                    npc.rect.copyFrom(ActNpc138_rcRight);
                    npc.x -= 4096;
                }
                npc.tgt_x = npc.x;
                break;
            }
            case 10: {
                npc.act_no = 11;
                npc.ani_no = 1;
                npc.act_wait = 0;
                npc.bits = (char)(npc.bits | 8);
            }
            case 11: {
                if (++npc.act_wait % 8 == 0) {
                    Sound.PlaySoundObject(26, 1);
                }
                if (npc.direct == 0) {
                    npc.rect.copyFrom(ActNpc138_rcLeft);
                    npc.rect.left += npc.act_wait / 8;
                } else {
                    npc.x = npc.tgt_x + npc.act_wait / 8 * 512;
                    npc.rect.copyFrom(ActNpc138_rcRight);
                    npc.rect.right -= npc.act_wait / 8;
                }
                if (npc.act_wait != 104) break;
                npc.cond = 0;
            }
        }
    }

    public static void ActNpc139(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
                npc.xm = 0;
                npc.ym = 0;
                npc.y -= 4096;
            }
            case 1: {
                npc.ani_no = (npc.flag & 8) != 0 ? 0 : 2;
                npc.ym += 64;
                break;
            }
            case 10: {
                npc.act_no = 11;
                npc.ani_no = 1;
                npc.ani_wait = 0;
                npc.count1 = 0;
            }
            case 11: {
                if (++npc.ani_wait > 6) {
                    npc.ani_wait = 0;
                    ++npc.ani_no;
                }
                if (npc.ani_no > 1) {
                    npc.ani_no = 0;
                    ++npc.count1;
                }
                if (npc.count1 <= 8) break;
                npc.ani_no = 0;
                npc.act_no = 1;
                break;
            }
            case 20: {
                npc.act_no = 21;
                npc.act_wait = 0;
                npc.ani_no = 2;
                npc.tgt_y = npc.y - 16384;
            }
            case 21: {
                npc.ym = npc.y < npc.tgt_y ? (npc.ym += 32) : (npc.ym -= 32);
                if (npc.ym > 512) {
                    npc.ym = 512;
                }
                if (npc.ym >= -512) break;
                npc.ym = -512;
                break;
            }
            case 30: {
                npc.act_no = 31;
                npc.xm = 0;
                npc.ym = 0;
                npc.act_wait = (npc.rect.bottom - npc.rect.top) * 2;
                Sound.PlaySoundObject(29, 1);
            }
            case 31: {
                --npc.act_wait;
                npc.ani_no = 0;
                if (npc.act_wait != 0) break;
                npc.cond = 0;
                break;
            }
            case 40: {
                npc.act_no = 41;
                npc.act_wait = 0;
                npc.xm = 0;
                npc.ym = 0;
                Sound.PlaySoundObject(29, 1);
            }
            case 41: {
                npc.ani_no = 2;
                if (++npc.act_wait < 64) break;
                npc.act_no = 20;
            }
        }
        npc.x += npc.xm;
        npc.y += npc.ym;
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc139_rcLeft[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc139_rcRight[npc.ani_no]);
        }
        if (npc.act_no == 31 || npc.act_no == 41) {
            npc.rect.bottom = npc.rect.top + npc.act_wait / 2;
            if (npc.act_wait / 2 % 2 != 0) {
                ++npc.rect.left;
            }
        }
    }
}
