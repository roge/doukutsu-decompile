/*
 * Decompiled with CFR 0.152.
 */
package jp.studiopixel.doukutsu;

import jp.studiopixel.doukutsu.Caret;
import jp.studiopixel.doukutsu.Frame;
import jp.studiopixel.doukutsu.Game;
import jp.studiopixel.doukutsu.MyChar;
import jp.studiopixel.doukutsu.NpChar;
import jp.studiopixel.doukutsu.RECT;
import jp.studiopixel.doukutsu.Sound;
import jp.studiopixel.doukutsu.Triangle;

public class NpcAct020 {
    private static final RECT ActNpc020_rcLeft = new RECT(288, 16, 320, 40);
    private static final RECT[] ActNpc020_rcRight = new RECT[]{new RECT(288, 40, 320, 64), new RECT(288, 40, 320, 64), new RECT(288, 64, 320, 88)};
    private static final RECT ActNpc021_rcLeft = new RECT(224, 40, 240, 48);
    private static final RECT[] ActNpc022_rc = new RECT[]{new RECT(240, 16, 264, 48), new RECT(248, 152, 272, 184)};
    private static final RECT[] ActNpc023_rc = new RECT[]{new RECT(264, 16, 288, 20), new RECT(264, 20, 288, 24), new RECT(264, 24, 288, 28), new RECT(264, 28, 288, 32), new RECT(264, 32, 288, 36), new RECT(264, 36, 288, 40), new RECT(264, 40, 288, 44), new RECT(264, 44, 288, 48)};
    private static final RECT[] ActNpc024_rcLeft = new RECT[]{new RECT(0, 0, 24, 24), new RECT(24, 0, 48, 24), new RECT(48, 0, 72, 24), new RECT(72, 0, 96, 24), new RECT(96, 0, 120, 24), new RECT(120, 0, 144, 24)};
    private static final RECT[] ActNpc024_rcRight = new RECT[]{new RECT(0, 24, 24, 48), new RECT(24, 24, 48, 48), new RECT(48, 24, 72, 48), new RECT(72, 24, 96, 48), new RECT(96, 24, 120, 48), new RECT(120, 24, 144, 48)};
    private static final RECT[] ActNpc025_rcLeft = new RECT[]{new RECT(256, 64, 288, 80), new RECT(256, 80, 288, 96)};
    private static final RECT[] ActNpc026_rcLeft = new RECT[]{new RECT(32, 80, 48, 96), new RECT(48, 80, 64, 96), new RECT(64, 80, 80, 96), new RECT(80, 80, 96, 96)};
    private static final RECT[] ActNpc026_rcRight = new RECT[]{new RECT(32, 96, 48, 112), new RECT(48, 96, 64, 112), new RECT(64, 96, 80, 112), new RECT(80, 96, 96, 112)};
    private static final RECT[] ActNpc027_rcLeft = new RECT[]{new RECT(96, 64, 128, 88)};
    private static final RECT[] ActNpc028_rcLeft = new RECT[]{new RECT(0, 48, 16, 64), new RECT(16, 48, 32, 64), new RECT(32, 48, 48, 64), new RECT(48, 48, 64, 64), new RECT(64, 48, 80, 64), new RECT(80, 48, 96, 64)};
    private static final RECT[] ActNpc028_rcRight = new RECT[]{new RECT(0, 64, 16, 80), new RECT(16, 64, 32, 80), new RECT(32, 64, 48, 80), new RECT(48, 64, 64, 80), new RECT(64, 64, 80, 80), new RECT(80, 64, 96, 80)};
    private static final RECT[] ActNpc029_rcLeft = new RECT[]{new RECT(0, 192, 16, 216), new RECT(16, 192, 32, 216)};
    private static final RECT[] ActNpc029_rcRight = new RECT[]{new RECT(0, 216, 16, 240), new RECT(16, 216, 32, 240)};
    private static final RECT[] ActNpc030_rc = new RECT[]{new RECT(48, 0, 64, 16), new RECT(48, 16, 64, 32), new RECT(0, 32, 16, 48)};
    private static final RECT[] ActNpc031_rcLeft = new RECT[]{new RECT(0, 80, 16, 96), new RECT(16, 80, 32, 96), new RECT(32, 80, 48, 96), new RECT(48, 80, 64, 96), new RECT(64, 80, 80, 96)};
    private static final RECT[] ActNpc031_rcRight = new RECT[]{new RECT(0, 96, 16, 112), new RECT(16, 96, 32, 112), new RECT(32, 96, 48, 112), new RECT(48, 96, 64, 112), new RECT(64, 96, 80, 112)};
    private static final RECT[] ActNpc032_rc = new RECT[]{new RECT(32, 96, 48, 112), new RECT(48, 96, 64, 112)};
    private static final RECT[] ActNpc033_rc = new RECT[]{new RECT(240, 64, 256, 80), new RECT(240, 80, 256, 96)};
    private static final RECT ActNpc034_rcLeft = new RECT(192, 48, 224, 64);
    private static final RECT ActNpc034_rcRight = new RECT(192, 184, 224, 200);
    private static final RECT[] ActNpc035_rcLeft = new RECT[]{new RECT(96, 64, 120, 96), new RECT(120, 64, 144, 96), new RECT(144, 64, 168, 96), new RECT(168, 64, 192, 96)};
    private static final RECT[] ActNpc035_rcRight = new RECT[]{new RECT(96, 96, 120, 128), new RECT(120, 96, 144, 128), new RECT(144, 96, 168, 128), new RECT(168, 96, 192, 128)};
    private static final RECT[] ActNpc036_rcLeft = new RECT[]{new RECT(0, 0, 40, 24), new RECT(40, 0, 80, 24), new RECT(80, 0, 120, 24), new RECT(120, 0, 160, 24), new RECT(160, 48, 200, 72), new RECT(200, 48, 240, 72)};
    private static final RECT[] ActNpc036_rcRight = new RECT[]{new RECT(0, 24, 40, 48), new RECT(40, 24, 80, 48), new RECT(80, 24, 120, 48), new RECT(120, 24, 160, 48), new RECT(160, 72, 200, 96), new RECT(200, 72, 240, 96)};
    private static final RECT[] ActNpc037_rc = new RECT[]{new RECT(192, 64, 208, 80), new RECT(208, 64, 224, 80)};
    private static final RECT[] ActNpc038_rc = new RECT[]{new RECT(128, 64, 144, 80), new RECT(144, 64, 160, 80), new RECT(160, 64, 176, 80), new RECT(176, 64, 192, 80)};
    private static final RECT[] ActNpc039_rc = new RECT[]{new RECT(224, 64, 240, 80), new RECT(240, 64, 256, 80)};

    public static void ActNpc020(NpChar.NPCHAR npc) {
        if (++npc.ani_wait > 3) {
            npc.ani_wait = 0;
            ++npc.ani_no;
        }
        if (npc.ani_no > 2) {
            npc.ani_no = 0;
        }
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc020_rcLeft);
        } else {
            npc.rect.copyFrom(ActNpc020_rcRight[npc.ani_no]);
        }
    }

    public static void ActNpc021(NpChar.NPCHAR npc) {
        if (npc.act_no == 0) {
            npc.act_no = 1;
            if (npc.direct == 2) {
                npc.y += 8192;
            }
        }
        npc.rect.copyFrom(ActNpc021_rcLeft);
    }

    public static void ActNpc022(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.ani_no = 0;
                break;
            }
            case 1: {
                if (++npc.ani_no <= 1) break;
                npc.ani_no = 0;
            }
        }
        npc.rect.copyFrom(ActNpc022_rc[npc.ani_no]);
    }

    public static void ActNpc023(NpChar.NPCHAR npc) {
        if (++npc.ani_wait > 1) {
            npc.ani_wait = 0;
            ++npc.ani_no;
        }
        if (npc.ani_no > 7) {
            npc.ani_no = 0;
        }
        npc.rect.copyFrom(ActNpc023_rc[npc.ani_no]);
    }

    public static void ActNpc024(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.y += 1536;
                npc.act_no = 1;
            }
            case 1: {
                if (npc.act_wait >= 8 && npc.x - 65536 < MyChar.gMC.x && npc.x + 65536 > MyChar.gMC.x && npc.y - 65536 < MyChar.gMC.y && npc.y + 24576 > MyChar.gMC.y) {
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
                if (npc.act_wait < 8 || npc.x - 49152 >= MyChar.gMC.x || npc.x + 49152 <= MyChar.gMC.x || npc.y - 49152 >= MyChar.gMC.y || npc.y + 24576 <= MyChar.gMC.y) break;
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
                Sound.PlaySoundObject(108, 1);
                npc.direct = npc.x > MyChar.gMC.x ? 0 : 2;
                if (npc.direct == 0) {
                    npc.xm = -256;
                    break;
                }
                npc.xm = 256;
                break;
            }
            case 3: {
                if (npc.ym <= 512) break;
                npc.tgt_y = npc.y;
                npc.act_no = 4;
                npc.ani_no = 3;
                npc.act_wait = 0;
                break;
            }
            case 4: {
                npc.direct = npc.x < MyChar.gMC.x ? 2 : 0;
                ++npc.act_wait;
                if ((npc.flag & 7) != 0 || npc.act_wait > 100) {
                    npc.damage = 12;
                    npc.act_no = 5;
                    npc.ani_no = 2;
                    npc.xm /= 2;
                    break;
                }
                if (npc.act_wait % 4 == 1) {
                    Sound.PlaySoundObject(110, 1);
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
                Sound.PlaySoundObject(26, 1);
                Frame.SetQuake(30);
            }
        }
        if (npc.act_no != 4) {
            npc.ym += 32;
            if (npc.ym > 1535) {
                npc.ym = 1535;
            }
        } else {
            npc.xm = npc.x < MyChar.gMC.x ? (npc.xm += 32) : (npc.xm -= 32);
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
            npc.rect.copyFrom(ActNpc024_rcLeft[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc024_rcRight[npc.ani_no]);
        }
    }

    public static void ActNpc025(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
                npc.ani_no = 0;
                npc.ani_wait = 0;
                npc.x += 4096;
            }
            case 1: {
                if (++npc.act_wait <= 150) break;
                npc.act_wait = 0;
                ++npc.act_no;
                break;
            }
            case 2: {
                if (++npc.act_wait <= 64) {
                    npc.y -= 512;
                    break;
                }
                npc.act_wait = 0;
                ++npc.act_no;
                break;
            }
            case 3: {
                if (++npc.act_wait <= 150) break;
                npc.act_wait = 0;
                ++npc.act_no;
                break;
            }
            case 4: {
                if (++npc.act_wait <= 64) {
                    npc.y -= 512;
                    break;
                }
                npc.act_wait = 0;
                ++npc.act_no;
                break;
            }
            case 5: {
                if (++npc.act_wait <= 150) break;
                npc.act_wait = 0;
                ++npc.act_no;
                break;
            }
            case 6: {
                if (++npc.act_wait <= 64) {
                    npc.y += 512;
                    break;
                }
                npc.act_wait = 0;
                ++npc.act_no;
                break;
            }
            case 7: {
                if (++npc.act_wait <= 150) break;
                npc.act_wait = 0;
                ++npc.act_no;
                break;
            }
            case 8: {
                if (++npc.act_wait <= 64) {
                    npc.y += 512;
                    break;
                }
                npc.act_wait = 0;
                npc.act_no = 1;
            }
        }
        switch (npc.act_no) {
            case 2: 
            case 4: 
            case 6: 
            case 8: {
                if (++npc.ani_wait > 1) {
                    npc.ani_wait = 0;
                    ++npc.ani_no;
                }
                if (npc.ani_no <= 1) break;
                npc.ani_no = 0;
            }
        }
        npc.rect.copyFrom(ActNpc025_rcLeft[npc.ani_no]);
    }

    public static void ActNpc026(NpChar.NPCHAR npc) {
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
                if (npc.count1 < 120) {
                    ++npc.count1;
                    break;
                }
                if (npc.x - 4096 >= MyChar.gMC.x || npc.x + 4096 <= MyChar.gMC.x || npc.y >= MyChar.gMC.y || npc.y + 49152 <= MyChar.gMC.y) break;
                npc.xm /= 2;
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
            npc.rect.copyFrom(ActNpc026_rcLeft[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc026_rcRight[npc.ani_no]);
        }
    }

    public static void ActNpc027(NpChar.NPCHAR npc) {
        npc.rect.copyFrom(ActNpc027_rcLeft[npc.ani_no]);
    }

    public static void ActNpc028(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.y += 1536;
                npc.act_no = 1;
            }
            case 1: {
                if (npc.act_wait >= 8 && npc.x - 65536 < MyChar.gMC.x && npc.x + 65536 > MyChar.gMC.x && npc.y - 65536 < MyChar.gMC.y && npc.y + 24576 > MyChar.gMC.y) {
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
                if (npc.act_wait < 8 || npc.x - 49152 >= MyChar.gMC.x || npc.x + 49152 <= MyChar.gMC.x || npc.y - 49152 >= MyChar.gMC.y || npc.y + 24576 <= MyChar.gMC.y) break;
                npc.act_no = 2;
                npc.ani_no = 0;
                npc.act_wait = 0;
                break;
            }
            case 2: {
                if (++npc.act_wait <= 8) break;
                npc.act_no = 3;
                npc.ani_no = 2;
                npc.ym = -1228;
                Sound.PlaySoundObject(30, 1);
                npc.direct = npc.x > MyChar.gMC.x ? 0 : 2;
                if (npc.direct == 0) {
                    npc.xm = -256;
                    break;
                }
                npc.xm = 256;
                break;
            }
            case 3: {
                if (npc.ym <= 256) break;
                npc.tgt_y = npc.y;
                npc.act_no = 4;
                npc.ani_no = 3;
                npc.act_wait = 0;
                npc.act_wait = 0;
                break;
            }
            case 4: {
                npc.direct = npc.x < MyChar.gMC.x ? 2 : 0;
                ++npc.act_wait;
                if ((npc.flag & 7) != 0 || npc.act_wait > 100) {
                    npc.damage = 3;
                    npc.act_no = 5;
                    npc.ani_no = 2;
                    npc.xm /= 2;
                    break;
                }
                if (npc.act_wait % 4 == 1) {
                    Sound.PlaySoundObject(109, 1);
                }
                if ((npc.flag & 8) != 0) {
                    npc.ym = -512;
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
            npc.ym += 64;
            if (npc.ym > 1535) {
                npc.ym = 1535;
            }
        } else {
            npc.xm = npc.x < MyChar.gMC.x ? (npc.xm += 32) : (npc.xm -= 32);
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
            npc.rect.copyFrom(ActNpc028_rcLeft[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc028_rcRight[npc.ani_no]);
        }
    }

    public static void ActNpc029(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
                npc.ani_no = 0;
                npc.ani_wait = 0;
            }
            case 1: {
                npc.ani_no = npc.x - 24576 < MyChar.gMC.x && npc.x + 24576 > MyChar.gMC.x && npc.y - 24576 < MyChar.gMC.y && npc.y + 8192 > MyChar.gMC.y ? 1 : 0;
            }
        }
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc029_rcLeft[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc029_rcRight[npc.ani_no]);
        }
    }

    public static void ActNpc030(NpChar.NPCHAR npc) {
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
        } else {
            if (npc.act_no == 0) {
                npc.act_no = 1;
                npc.y += 8192;
                npc.ani_no = 2;
            }
            if (++npc.act_wait > 100) {
                npc.act_wait = 0;
                Caret.SetCaret(npc.x, npc.y - 1024, 5, 0);
            }
        }
        npc.rect.copyFrom(ActNpc030_rc[npc.ani_no]);
    }

    public static void ActNpc031(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
            }
            case 1: {
                if (Game.Random(0, 120) == 10) {
                    npc.act_no = 2;
                    npc.act_wait = 0;
                    npc.ani_no = 1;
                }
                if (npc.x - 4096 >= MyChar.gMC.x || npc.x + 4096 <= MyChar.gMC.x || npc.y - 4096 >= MyChar.gMC.y || npc.y + 49152 <= MyChar.gMC.y) break;
                npc.ani_no = 0;
                npc.act_no = 3;
                break;
            }
            case 2: {
                if (++npc.act_wait <= 8) break;
                npc.act_no = 1;
                npc.ani_no = 0;
                break;
            }
            case 3: {
                npc.ani_no = 0;
                if (npc.shock == '\u0000' && npc.x - 10240 <= MyChar.gMC.x && npc.x + 10240 >= MyChar.gMC.x) break;
                npc.ani_no = 1;
                npc.ani_wait = 0;
                npc.act_no = 4;
                npc.act_wait = 0;
                break;
            }
            case 4: {
                npc.ym += 32;
                if (npc.ym > 1535) {
                    npc.ym = 1535;
                }
                if (++npc.act_wait < 20 && (npc.flag & 8) == 0 || (npc.flag & 8) == 0 && npc.y <= MyChar.gMC.y - 8192) break;
                npc.ani_wait = 0;
                npc.ani_no = 2;
                npc.act_no = 5;
                npc.tgt_y = npc.y;
                if ((npc.flag & 8) == 0) break;
                npc.ym = -512;
                break;
            }
            case 5: {
                if (++npc.ani_wait > 1) {
                    npc.ani_wait = 0;
                    ++npc.ani_no;
                }
                if (npc.ani_no > 4) {
                    npc.ani_no = 2;
                }
                npc.direct = MyChar.gMC.x < npc.x ? 0 : 2;
                if (MyChar.gMC.x < npc.x) {
                    npc.xm -= 16;
                }
                if (MyChar.gMC.x > npc.x) {
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
                if ((npc.flag & 8) != 0) {
                    npc.ym = -512;
                }
                if ((npc.flag & 2) == 0) break;
                npc.ym = 512;
            }
        }
        npc.x += npc.xm;
        npc.y += npc.ym;
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc031_rcLeft[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc031_rcRight[npc.ani_no]);
        }
    }

    public static void ActNpc032(NpChar.NPCHAR npc) {
        if (++npc.ani_wait > 2) {
            npc.ani_wait = 0;
            ++npc.ani_no;
        }
        if (npc.ani_no > 1) {
            npc.ani_no = 0;
        }
        npc.rect.copyFrom(ActNpc032_rc[npc.ani_no]);
    }

    public static void ActNpc033(NpChar.NPCHAR npc) {
        if ((npc.flag & 5) != 0) {
            Caret.SetCaret(npc.x, npc.y, 2, 0);
            npc.cond = 0;
        } else if ((npc.flag & 8) != 0) {
            npc.ym = -1024;
        }
        npc.ym += 42;
        npc.y += npc.ym;
        npc.x += npc.xm;
        if (++npc.ani_wait > 2) {
            npc.ani_wait = 0;
            if (++npc.ani_no > 1) {
                npc.ani_no = 0;
            }
        }
        npc.rect.copyFrom(ActNpc033_rc[npc.ani_no]);
        if (++npc.act_wait > 250) {
            Caret.SetCaret(npc.x, npc.y, 2, 0);
            npc.cond = 0;
        }
    }

    public static void ActNpc034(NpChar.NPCHAR npc) {
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc034_rcLeft);
        } else {
            npc.rect.copyFrom(ActNpc034_rcRight);
        }
    }

    public static void ActNpc035(NpChar.NPCHAR npc) {
        if (npc.act_no < 3 && npc.life < 90) {
            Sound.PlaySoundObject(71, 1);
            NpChar.SetDestroyNpChar(npc.x, npc.y, npc.view.back, 8);
            NpChar.SetExpObjects(npc.x, npc.y, npc.exp);
            npc.act_no = 3;
            npc.act_wait = 0;
            npc.ani_no = 2;
            npc.bits = (char)(npc.bits & 0xFFFFFFDF);
            npc.damage = 0;
        }
        switch (npc.act_no) {
            case 0: 
            case 1: {
                if (npc.shock == '\u0000') break;
                if (npc.direct == 0) {
                    NpChar.SetNpChar(103, npc.x - 4096, npc.y + 4096, 0, 0, npc.direct, null, 256);
                } else {
                    NpChar.SetNpChar(103, npc.x + 4096, npc.y + 4096, 0, 0, npc.direct, null, 256);
                }
                npc.ani_no = 1;
                npc.act_no = 2;
                npc.act_wait = 0;
                break;
            }
            case 2: {
                if (++npc.act_wait <= 20) break;
                npc.act_wait = 0;
                npc.act_no = 1;
                npc.ani_no = 0;
                break;
            }
            case 3: {
                if (++npc.act_wait == 50 || npc.act_wait == 60) {
                    npc.ani_no = 3;
                }
                if (npc.act_wait == 53 || npc.act_wait == 63) {
                    npc.ani_no = 2;
                }
                if (npc.act_wait <= 100) break;
                npc.act_no = 4;
            }
        }
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc035_rcLeft[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc035_rcRight[npc.ani_no]);
        }
    }

    public static void ActNpc036(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
            }
            case 1: {
                if (++npc.act_wait <= 12) break;
                npc.act_no = 2;
                npc.act_wait = 0;
                npc.count1 = 3;
                npc.ani_no = 1;
                break;
            }
            case 2: {
                if (++npc.act_wait <= 16) break;
                --npc.count1;
                npc.act_wait = 0;
                char deg = (char)Triangle.GetArktan(npc.x - MyChar.gMC.x, npc.y + 2048 - MyChar.gMC.y);
                deg = (char)(deg + (char)Game.Random(-16, 16));
                int ym = Triangle.GetSin(deg);
                int xm = Triangle.GetCos(deg);
                NpChar.SetNpChar(11, npc.x, npc.y + 2048, xm, ym, 0, null, 256);
                Sound.PlaySoundObject(39, 1);
                if (npc.count1 != 0) break;
                npc.act_no = 3;
                npc.act_wait = 0;
                break;
            }
            case 3: {
                if (++npc.act_wait <= 3) break;
                npc.act_no = 4;
                npc.act_wait = 0;
                npc.xm = (MyChar.gMC.x - npc.x) / 100;
                npc.ym = -1536;
                npc.ani_no = 3;
                break;
            }
            case 4: {
                if (npc.ym <= -512) break;
                if (npc.life > 60) {
                    npc.act_no = 5;
                    npc.ani_no = 4;
                    npc.ani_wait = 0;
                    npc.act_wait = 0;
                    npc.tgt_y = npc.y;
                    break;
                }
                npc.act_no = 6;
                break;
            }
            case 5: {
                if (++npc.ani_wait > 1) {
                    npc.ani_wait = 0;
                    ++npc.ani_no;
                }
                if (npc.ani_no > 5) {
                    npc.ani_no = 4;
                    Sound.PlaySoundObject(47, 1);
                }
                if (++npc.act_wait > 100) {
                    npc.act_no = 6;
                    npc.ani_no = 3;
                }
                npc.ym = npc.y < npc.tgt_y ? (npc.ym += 64) : (npc.ym -= 64);
                if (npc.ym < -512) {
                    npc.ym = -512;
                }
                if (npc.ym <= 512) break;
                npc.ym = 512;
                break;
            }
            case 6: {
                int i;
                npc.damage = npc.y + 8192 < MyChar.gMC.y ? 10 : 0;
                if ((npc.flag & 8) == 0) break;
                npc.act_no = 7;
                npc.act_wait = 0;
                npc.ani_no = 2;
                Sound.PlaySoundObject(26, 1);
                Sound.PlaySoundObject(25, 1);
                Frame.SetQuake(30);
                npc.damage = 0;
                for (i = 0; i < 8; ++i) {
                    NpChar.SetNpChar(4, npc.x + Game.Random(-12, 12) * 512, npc.y + Game.Random(-12, 12) * 512, Game.Random(-341, 341), Game.Random(-1536, 0), 0, null, 256);
                }
                for (i = 0; i < 8; ++i) {
                    NpChar.SetNpChar(33, npc.x + Game.Random(-12, 12) * 512, npc.y + Game.Random(-12, 12) * 512, Game.Random(-1024, 1024), Game.Random(-1024, 0), 0, null, 256);
                }
                break;
            }
            case 7: {
                npc.xm = 0;
                if (++npc.act_wait <= 3) break;
                npc.act_no = 1;
                npc.act_wait = 0;
            }
        }
        if (npc.act_no != 5) {
            npc.ym += 51;
            npc.direct = npc.x < MyChar.gMC.x ? 2 : 0;
        }
        if (npc.ym > 1535) {
            npc.ym = 1535;
        }
        npc.x += npc.xm;
        npc.y += npc.ym;
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc036_rcLeft[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc036_rcRight[npc.ani_no]);
        }
    }

    public static void ActNpc037(NpChar.NPCHAR npc) {
        if (++npc.ani_wait > 1) {
            npc.ani_wait = 0;
            ++npc.ani_no;
        }
        if (npc.ani_no > 1) {
            npc.ani_no = 0;
        }
        npc.rect.copyFrom(ActNpc037_rc[npc.ani_no]);
    }

    public static void ActNpc038(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                if (++npc.ani_wait > 3) {
                    npc.ani_wait = 0;
                    ++npc.ani_no;
                }
                if (npc.ani_no > 3) {
                    npc.ani_no = 0;
                }
                npc.rect.copyFrom(ActNpc038_rc[npc.ani_no]);
                break;
            }
            case 10: {
                npc.act_no = 11;
                NpChar.SetDestroyNpChar(npc.x, npc.y, npc.view.back, 8);
            }
            case 11: {
                npc.rect.left = 0;
                npc.rect.right = 0;
            }
        }
    }

    public static void ActNpc039(NpChar.NPCHAR npc) {
        npc.ani_no = npc.direct == 0 ? 0 : 1;
        npc.rect.copyFrom(ActNpc039_rc[npc.ani_no]);
    }
}
