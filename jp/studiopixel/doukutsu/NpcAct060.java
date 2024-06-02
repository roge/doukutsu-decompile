/*
 * Decompiled with CFR 0.152.
 */
package jp.studiopixel.doukutsu;

import jp.studiopixel.doukutsu.Flash;
import jp.studiopixel.doukutsu.Frame;
import jp.studiopixel.doukutsu.Game;
import jp.studiopixel.doukutsu.Map;
import jp.studiopixel.doukutsu.MyChar;
import jp.studiopixel.doukutsu.MycParam;
import jp.studiopixel.doukutsu.NpChar;
import jp.studiopixel.doukutsu.RECT;
import jp.studiopixel.doukutsu.Sound;
import jp.studiopixel.doukutsu.Triangle;

public class NpcAct060 {
    private static final RECT[] ActNpc060_rcLeft = new RECT[]{new RECT(0, 64, 16, 80), new RECT(16, 64, 32, 80), new RECT(32, 64, 48, 80), new RECT(16, 64, 32, 80), new RECT(48, 64, 64, 80), new RECT(16, 64, 32, 80), new RECT(112, 64, 128, 80), new RECT(128, 64, 144, 80)};
    private static final RECT[] ActNpc060_rcRight = new RECT[]{new RECT(0, 80, 16, 96), new RECT(16, 80, 32, 96), new RECT(32, 80, 48, 96), new RECT(16, 80, 32, 96), new RECT(48, 80, 64, 96), new RECT(16, 80, 32, 96), new RECT(112, 80, 128, 96), new RECT(128, 80, 144, 96)};
    private static final RECT[] ActNpc061_rcLeft = new RECT[]{new RECT(224, 32, 240, 48), new RECT(240, 32, 256, 48), new RECT(256, 32, 272, 48), new RECT(272, 32, 288, 48), new RECT(288, 32, 304, 48), new RECT(224, 32, 240, 48), new RECT(304, 32, 320, 48), new RECT(224, 32, 240, 48), new RECT(272, 32, 288, 48), new RECT(0, 0, 0, 0), new RECT(112, 32, 128, 48)};
    private static final RECT[] ActNpc061_rcRight = new RECT[]{new RECT(224, 48, 240, 64), new RECT(240, 48, 256, 64), new RECT(256, 48, 272, 64), new RECT(272, 48, 288, 64), new RECT(288, 48, 304, 64), new RECT(224, 48, 240, 64), new RECT(304, 48, 320, 64), new RECT(224, 48, 240, 64), new RECT(272, 48, 288, 64), new RECT(0, 0, 0, 0), new RECT(112, 32, 128, 48)};
    private static final RECT[] ActNpc062_rcLeft = new RECT[]{new RECT(272, 192, 288, 216), new RECT(288, 192, 304, 216), new RECT(304, 192, 320, 216)};
    private static final RECT[] ActNpc063_rcLeft = new RECT[]{new RECT(64, 64, 80, 80), new RECT(80, 64, 96, 80), new RECT(64, 64, 80, 80), new RECT(96, 64, 112, 80), new RECT(112, 64, 128, 80), new RECT(128, 64, 144, 80)};
    private static final RECT[] ActNpc063_rcRight = new RECT[]{new RECT(64, 80, 80, 96), new RECT(80, 80, 96, 96), new RECT(64, 80, 80, 96), new RECT(96, 80, 112, 96), new RECT(112, 80, 128, 96), new RECT(128, 80, 144, 96)};
    private static final RECT[] rcLeft = new RECT[]{new RECT(0, 0, 16, 16), new RECT(16, 0, 32, 16), new RECT(32, 0, 48, 16)};
    private static final RECT[] rcRight = new RECT[]{new RECT(0, 16, 16, 32), new RECT(16, 16, 32, 32), new RECT(32, 16, 48, 32)};
    private static final RECT[] ActNpc065_rcLeft = new RECT[]{new RECT(32, 32, 48, 48), new RECT(48, 32, 64, 48), new RECT(64, 32, 80, 48), new RECT(80, 32, 96, 48)};
    private static final RECT[] ActNpc065_rcRight = new RECT[]{new RECT(32, 48, 48, 64), new RECT(48, 48, 64, 64), new RECT(64, 48, 80, 64), new RECT(80, 48, 96, 64)};
    private static final RECT[] ActNpc066_rect = new RECT[]{new RECT(32, 192, 56, 216), new RECT(56, 192, 80, 216), new RECT(32, 216, 56, 240), new RECT(56, 216, 80, 240)};
    private static final RECT[] ActNpc067_rcLeft = new RECT[]{new RECT(80, 0, 96, 16), new RECT(96, 0, 112, 16), new RECT(112, 0, 128, 16), new RECT(128, 0, 144, 16), new RECT(144, 0, 160, 16), new RECT(160, 0, 176, 16), new RECT(176, 0, 192, 16), new RECT(144, 0, 160, 16)};
    private static final RECT[] ActNpc067_rcRight = new RECT[]{new RECT(80, 16, 96, 32), new RECT(96, 16, 112, 32), new RECT(112, 16, 128, 32), new RECT(128, 16, 144, 32), new RECT(144, 16, 160, 32), new RECT(160, 16, 176, 32), new RECT(176, 16, 192, 32), new RECT(144, 16, 160, 32)};
    private static final RECT[] ActNpc068_rcLeft = new RECT[]{new RECT(0, 0, 40, 24), new RECT(0, 48, 40, 72), new RECT(0, 0, 40, 24), new RECT(40, 48, 80, 72), new RECT(0, 0, 40, 24), new RECT(80, 48, 120, 72), new RECT(120, 48, 160, 72), new RECT(120, 0, 160, 24), new RECT(80, 0, 120, 24)};
    private static final RECT[] ActNpc068_rcRight = new RECT[]{new RECT(0, 24, 40, 48), new RECT(0, 72, 40, 96), new RECT(0, 24, 40, 48), new RECT(40, 72, 80, 96), new RECT(0, 24, 40, 48), new RECT(80, 72, 120, 96), new RECT(120, 72, 160, 96), new RECT(120, 24, 160, 48), new RECT(80, 24, 120, 48)};
    private static final RECT[] ActNpc069_rcLeft = new RECT[]{new RECT(48, 0, 64, 16), new RECT(64, 0, 80, 16), new RECT(80, 0, 96, 16), new RECT(96, 0, 112, 16), new RECT(48, 0, 64, 16), new RECT(112, 0, 128, 16)};
    private static final RECT[] ActNpc069_rcRight = new RECT[]{new RECT(48, 16, 64, 32), new RECT(64, 16, 80, 32), new RECT(80, 16, 96, 32), new RECT(96, 16, 112, 32), new RECT(48, 16, 64, 32), new RECT(112, 16, 128, 32)};
    private static final RECT[] ActNpc070_rect = new RECT[]{new RECT(96, 48, 112, 64), new RECT(112, 48, 128, 64), new RECT(128, 48, 144, 64), new RECT(144, 48, 160, 64)};
    private static final RECT[] ActNpc071_rcLeft = new RECT[]{new RECT(64, 32, 80, 48), new RECT(80, 32, 96, 48), new RECT(96, 32, 112, 48)};
    private static final RECT[] ActNpc071_rcRight = new RECT[]{new RECT(64, 48, 80, 64), new RECT(80, 48, 96, 64), new RECT(96, 48, 112, 64)};
    private static final RECT[] ActNpc072_rect = new RECT[]{new RECT(224, 48, 240, 64), new RECT(240, 48, 256, 64)};
    private static final RECT[] ActNpc073_rect = new RECT[]{new RECT(72, 16, 74, 18), new RECT(74, 16, 76, 18), new RECT(76, 16, 78, 18), new RECT(78, 16, 80, 18), new RECT(80, 16, 82, 18)};
    private static final RECT[] ActNpc074_rcLeft = new RECT[]{new RECT(64, 0, 80, 16), new RECT(80, 0, 96, 16), new RECT(96, 0, 112, 16), new RECT(64, 0, 80, 16), new RECT(112, 0, 128, 16), new RECT(64, 0, 80, 16)};
    private static final RECT[] ActNpc074_rcRight = new RECT[]{new RECT(64, 16, 80, 32), new RECT(80, 16, 96, 32), new RECT(96, 16, 112, 32), new RECT(64, 16, 80, 32), new RECT(112, 16, 128, 32), new RECT(64, 16, 80, 32)};
    private static final RECT[] ActNpc075_rcLeft = new RECT[]{new RECT(272, 32, 296, 56), new RECT(296, 32, 320, 56)};
    private static final RECT[] ActNpc077_rc = new RECT[]{new RECT(0, 16, 48, 48), new RECT(48, 16, 96, 48), new RECT(96, 16, 144, 48)};
    private static final RECT[] ActNpc078_rc = new RECT[]{new RECT(160, 48, 176, 64), new RECT(176, 48, 192, 64)};
    private static final RECT[] ActNpc079_rcLeft = new RECT[]{new RECT(0, 0, 16, 16), new RECT(16, 0, 32, 16), new RECT(32, 0, 48, 16)};
    private static final RECT[] ActNpc079_rcRight = new RECT[]{new RECT(0, 16, 16, 32), new RECT(16, 16, 32, 32), new RECT(32, 16, 48, 32)};

    public static void ActNpc060(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
                npc.ani_no = 0;
                npc.ani_wait = 0;
                npc.xm = 0;
            }
            case 1: {
                if (Game.Random(0, 120) == 10) {
                    npc.act_no = 2;
                    npc.act_wait = 0;
                    npc.ani_no = 1;
                }
                if (npc.x - 8192 >= MyChar.gMC.x || npc.x + 8192 <= MyChar.gMC.x || npc.y - 8192 >= MyChar.gMC.y || npc.y + 8192 <= MyChar.gMC.y) break;
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
                npc.ani_no = 1;
                npc.ani_wait = 0;
            }
            case 4: {
                if (++npc.ani_wait > 2) {
                    npc.ani_wait = 0;
                    ++npc.ani_no;
                }
                if (npc.ani_no > 4) {
                    npc.ani_no = 1;
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
                    npc.xm = -1024;
                    break;
                }
                npc.xm = 1024;
                break;
            }
            case 6: {
                npc.act_no = 7;
                npc.act_wait = 0;
                npc.ani_no = 1;
                npc.ani_wait = 0;
                npc.ym = -1024;
            }
            case 7: {
                if (++npc.ani_wait > 2) {
                    npc.ani_wait = 0;
                    ++npc.ani_no;
                }
                if (npc.ani_no > 4) {
                    npc.ani_no = 1;
                }
                npc.xm = npc.direct == 0 ? -256 : 256;
                if (npc.act_wait++ == 0 || (npc.flag & 8) == 0) break;
                npc.act_no = 3;
                break;
            }
            case 8: {
                npc.ani_no = 1;
                npc.act_wait = 0;
                npc.act_no = 9;
                npc.ym = -512;
            }
            case 9: {
                if (npc.act_wait++ == 0 || (npc.flag & 8) == 0) break;
                npc.act_no = 0;
                break;
            }
            case 10: {
                npc.act_no = 11;
                npc.ani_no = 6;
                npc.ym = -1024;
                Sound.PlaySoundObject(50, 1);
                if (npc.direct == 0) {
                    npc.xm = -256;
                    break;
                }
                npc.xm = 256;
                break;
            }
            case 11: {
                if (npc.act_wait++ == 0 || (npc.flag & 8) == 0) break;
                npc.act_no = 12;
                npc.ani_no = 7;
                npc.bits = (char)(npc.bits | 0x2000);
                break;
            }
            case 12: {
                npc.xm = 0;
            }
        }
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
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc060_rcLeft[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc060_rcRight[npc.ani_no]);
        }
    }

    public static void ActNpc061(NpChar.NPCHAR npc) {
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
            case 5: {
                npc.ani_no = 3;
                npc.xm = 0;
                break;
            }
            case 6: {
                npc.act_no = 7;
                npc.act_wait = 0;
                npc.ani_wait = 0;
                npc.ym = -1024;
            }
            case 7: {
                npc.ani_no = 2;
                npc.xm = npc.direct == 0 ? -512 : 512;
                if (npc.act_wait++ == 0 || (npc.flag & 8) == 0) break;
                npc.act_no = 5;
                break;
            }
            case 8: {
                npc.act_no = 9;
                npc.ani_no = 4;
                npc.ani_wait = 0;
            }
            case 9: {
                if (++npc.ani_wait > 4) {
                    npc.ani_wait = 0;
                    ++npc.ani_no;
                }
                if (npc.ani_no > 7) {
                    npc.ani_no = 4;
                }
                if (npc.direct == 0) {
                    npc.xm = -512;
                    break;
                }
                npc.xm = 512;
                break;
            }
            case 10: {
                npc.act_no = 11;
                npc.ani_no = 4;
                npc.ani_wait = 0;
            }
            case 11: {
                if (++npc.ani_wait > 2) {
                    npc.ani_wait = 0;
                    ++npc.ani_no;
                }
                if (npc.ani_no > 7) {
                    npc.ani_no = 4;
                }
                if (npc.direct == 0) {
                    npc.xm = -1024;
                    break;
                }
                npc.xm = 1024;
                break;
            }
            case 20: {
                NpChar.SetNpChar(145, 0, 0, 0, 0, 2, npc, 256);
                npc.ani_no = 0;
                npc.act_no = 0;
                break;
            }
            case 30: {
                npc.act_no = 31;
                npc.act_wait = 0;
                npc.ani_wait = 0;
                npc.ym = 0;
            }
            case 31: {
                npc.ani_no = 2;
                npc.xm = npc.direct == 0 ? -1536 : 1536;
                if ((npc.flag & 1) == 0) break;
                npc.direct = 2;
                npc.act_no = 7;
                npc.act_wait = 0;
                npc.ani_wait = 0;
                npc.ym = -1024;
                npc.xm = 512;
                Sound.PlaySoundObject(71, 1);
                NpChar.SetDestroyNpChar(npc.x, npc.y, 2048, 4);
                break;
            }
            case 40: {
                npc.act_no = 42;
                npc.act_wait = 0;
                npc.ani_no = 8;
                Sound.PlaySoundObject(29, 1);
            }
            case 42: {
                if (++npc.ani_no > 9) {
                    npc.ani_no = 8;
                }
                if (++npc.act_wait <= 100) break;
                for (int i = 0; i < 4; ++i) {
                    NpChar.SetNpChar(4, npc.x + Game.Random(-12, 12) * 512, npc.y + Game.Random(-12, 12) * 512, Game.Random(-341, 341), Game.Random(-1536, 0), 0, null, 256);
                }
                npc.act_no = 50;
                npc.surf = 20;
                npc.ani_no = 10;
                break;
            }
            case 60: {
                npc.ani_no = 6;
                npc.act_no = 61;
                npc.ym = -1535;
                npc.xm = 1024;
                npc.count2 = 1;
                break;
            }
            case 61: {
                npc.ym += 64;
                if ((npc.flag & 8) == 0) break;
                npc.act_no = 0;
                npc.count2 = 0;
                npc.xm = 0;
            }
        }
        if (npc.act_no < 30 || npc.act_no >= 40) {
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
        }
        npc.x += npc.xm;
        npc.y += npc.ym;
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc061_rcLeft[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc061_rcRight[npc.ani_no]);
        }
    }

    public static void ActNpc062(NpChar.NPCHAR npc) {
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
        npc.rect.copyFrom(ActNpc062_rcLeft[npc.ani_no]);
    }

    public static void ActNpc063(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
                npc.act_wait = 0;
                npc.ani_wait = 0;
                npc.ym = -1024;
            }
            case 1: {
                if (npc.ym > 0) {
                    npc.bits = (char)(npc.bits & 0xFFFFFFF7);
                }
                if (++npc.ani_wait > 2) {
                    npc.ani_wait = 0;
                    ++npc.ani_no;
                }
                if (npc.ani_no > 3) {
                    npc.ani_no = 0;
                }
                npc.xm = npc.direct == 0 ? -256 : 256;
                if (npc.act_wait++ == 0 || (npc.flag & 8) == 0) break;
                npc.act_no = 2;
                break;
            }
            case 2: {
                npc.act_no = 3;
                npc.act_wait = 0;
                npc.ani_no = 0;
                npc.ani_wait = 0;
            }
            case 3: {
                if (++npc.ani_wait > 2) {
                    npc.ani_wait = 0;
                    ++npc.ani_no;
                }
                if (npc.ani_no > 3) {
                    npc.ani_no = 0;
                }
                if (++npc.act_wait > 50) {
                    npc.act_wait = 40;
                    npc.xm *= -1;
                    npc.direct = npc.direct == 0 ? 2 : 0;
                }
                if (npc.act_wait > 35) {
                    npc.bits = (char)(npc.bits | 0x20);
                }
                npc.xm = npc.direct == 0 ? (npc.xm -= 64) : (npc.xm += 64);
                if (npc.shock == '\u0000') break;
                npc.act_no = 4;
                npc.ani_no = 4;
                npc.ym = -1024;
                npc.bits = (char)(npc.bits & 0xFFFFFFDF);
                npc.damage = 0;
                break;
            }
            case 4: {
                npc.xm = npc.direct == 0 ? -256 : 256;
                if (npc.act_wait++ == 0 || (npc.flag & 8) == 0) break;
                npc.act_no = 5;
                npc.bits = (char)(npc.bits | 0x2000);
                break;
            }
            case 5: {
                npc.xm = 0;
                npc.ani_no = 5;
            }
        }
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
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc063_rcLeft[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc063_rcRight[npc.ani_no]);
        }
    }

    public static void ActNpc064(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.y += 1536;
                npc.act_no = 1;
            }
            case 1: {
                npc.direct = npc.x > MyChar.gMC.x ? 0 : 2;
                if (npc.tgt_x < 100) {
                    ++npc.tgt_x;
                }
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
                if (npc.act_wait < 8 || npc.tgt_x < 100 || npc.x - 32768 >= MyChar.gMC.x || npc.x + 32768 <= MyChar.gMC.x || npc.y - 40960 >= MyChar.gMC.y || npc.y + 24576 <= MyChar.gMC.y) break;
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
            npc.rect.copyFrom(rcLeft[npc.ani_no]);
        } else {
            npc.rect.copyFrom(rcRight[npc.ani_no]);
        }
    }

    public static void ActNpc065(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.tgt_x = npc.x;
                npc.tgt_y = npc.y;
                npc.count1 = 120;
                npc.act_no = 1;
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
                npc.direct = MyChar.gMC.x < npc.x ? 0 : 2;
                if (npc.tgt_y < npc.y) {
                    npc.ym -= 16;
                }
                if (npc.tgt_y > npc.y) {
                    npc.ym += 16;
                }
                if (npc.ym > 768) {
                    npc.ym = 768;
                }
                if (npc.ym >= -768) break;
                npc.ym = -768;
            }
        }
        npc.x += npc.xm;
        npc.y += npc.ym;
        if (++npc.ani_wait > 1) {
            npc.ani_wait = 0;
            ++npc.ani_no;
        }
        if (npc.ani_no > 2) {
            npc.ani_no = 0;
        }
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc065_rcLeft[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc065_rcRight[npc.ani_no]);
        }
    }

    public static void ActNpc066(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                int a;
                for (a = 0; a < NpChar.gNPC.length && NpChar.gNPC[a].code_event != 1000; ++a) {
                }
                if (a == NpChar.gNPC.length) break;
                npc.tgt_x = NpChar.gNPC[a].x;
                npc.tgt_y = NpChar.gNPC[a].y;
                npc.count1 = a;
                char deg = (char)(Triangle.GetArktan(npc.x - npc.tgt_x, npc.y - npc.tgt_y) & 0xFF);
                npc.xm = Triangle.GetCos(deg) * 2;
                npc.ym = Triangle.GetSin(deg) * 2;
                npc.act_no = 1;
            }
            case 1: {
                if (++npc.ani_wait > 1) {
                    npc.ani_wait = 0;
                    ++npc.ani_no;
                }
                if (npc.ani_no > 1) {
                    npc.ani_no = 0;
                }
                if (npc.x - 1536 >= npc.tgt_x || npc.x + 1536 <= npc.tgt_x || npc.y - 1536 >= npc.tgt_y || npc.y + 1536 <= npc.tgt_y) break;
                npc.act_no = 2;
                npc.ani_no = 2;
                NpChar.gNPC[npc.count1].cond = 0;
                Sound.PlaySoundObject(21, 1);
                break;
            }
            case 2: {
                npc.xm -= 32;
                npc.ym -= 32;
                if (npc.xm < -1535) {
                    npc.xm = -1535;
                }
                if (npc.ym < -1535) {
                    npc.ym = -1535;
                }
                if (npc.y < -4096) {
                    npc.cond = 0;
                }
                if (++npc.ani_wait > 3) {
                    npc.ani_wait = 0;
                    ++npc.ani_no;
                }
                if (npc.ani_no <= 3) break;
                npc.ani_no = 2;
            }
        }
        npc.x += npc.xm;
        npc.y += npc.ym;
        npc.rect.copyFrom(ActNpc066_rect[npc.ani_no]);
    }

    public static void ActNpc067(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
                npc.tgt_x = npc.x;
                npc.tgt_y = npc.y;
                npc.ani_no = 0;
                Sound.PlaySoundObject(29, 1);
            }
            case 1: {
                npc.x = npc.tgt_x + Game.Random(-1, 1) * 512;
                if (++npc.act_wait != 32) break;
                npc.act_no = 10;
                break;
            }
            case 10: {
                npc.act_no = 11;
                npc.act_wait = 0;
                npc.ani_no = 0;
                npc.ym = 512;
            }
            case 11: {
                if (npc.tgt_y < npc.y) {
                    npc.ym -= 16;
                }
                if (npc.tgt_y > npc.y) {
                    npc.ym += 16;
                }
                if (npc.ym > 256) {
                    npc.ym = 256;
                }
                if (npc.ym >= -256) break;
                npc.ym = -256;
                break;
            }
            case 13: {
                npc.ani_no = 1;
                npc.ym += 64;
                if (npc.ym > 1535) {
                    npc.ym = 1535;
                }
                if ((npc.flag & 8) == 0) break;
                Sound.PlaySoundObject(23, 1);
                npc.ym = 0;
                npc.act_no = 14;
                npc.bits = (char)(npc.bits | 8);
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
                npc.act_no = 14;
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
            npc.rect.copyFrom(ActNpc067_rcLeft[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc067_rcRight[npc.ani_no]);
        }
        if (npc.act_no == 1 && npc.ani_wait < 32) {
            npc.rect.bottom = ++npc.ani_wait / 2 + npc.rect.bottom - 16;
        }
    }

    public static void ActNpc068(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
                npc.ani_no = 0;
                npc.act_wait = 30;
                npc.direct = npc.x > MyChar.gMC.x ? 0 : 2;
            }
            case 1: {
                if (--npc.act_wait != 0) break;
                npc.act_no = 2;
                ++npc.count1;
                break;
            }
            case 2: {
                npc.act_no = 3;
                npc.act_wait = 0;
                npc.ani_no = 1;
                npc.ani_wait = 0;
            }
            case 3: {
                if (++npc.ani_wait > 3) {
                    npc.ani_wait = 0;
                    if (++npc.ani_no == 2 || npc.ani_no == 4) {
                        Sound.PlaySoundObject(23, 1);
                    }
                }
                if (npc.ani_no > 4) {
                    npc.ani_no = 1;
                }
                npc.xm = npc.direct == 0 ? (npc.xm -= 16) : (npc.xm += 16);
                if (npc.act_wait >= 8 && npc.x - 6144 < MyChar.gMC.x && npc.x + 6144 > MyChar.gMC.x && npc.y - 6144 < MyChar.gMC.y && npc.y + 4096 > MyChar.gMC.y) {
                    npc.act_no = 10;
                    npc.ani_no = 5;
                    MyChar.gMC.cond = (char)(MyChar.gMC.cond | 2);
                    MycParam.DamageMyChar(2);
                    break;
                }
                ++npc.act_wait;
                if ((npc.flag & 5) != 0 || npc.act_wait > 75) {
                    npc.act_no = 9;
                    npc.ani_no = 0;
                    break;
                }
                if (npc.count1 % 3 != 0 || npc.act_wait <= 25) break;
                npc.act_no = 4;
                npc.ani_no = 7;
                npc.ym = -1024;
                break;
            }
            case 4: {
                if ((npc.flag & 8) != 0) {
                    npc.act_no = 9;
                    npc.ani_no = 8;
                    Frame.SetQuake(30);
                    Sound.PlaySoundObject(26, 1);
                }
                if (npc.act_wait < 8 || npc.x - 6144 >= MyChar.gMC.x || npc.x + 6144 <= MyChar.gMC.x || npc.y - 6144 >= MyChar.gMC.y || npc.y + 4096 <= MyChar.gMC.y) break;
                npc.act_no = 10;
                npc.ani_no = 5;
                MyChar.gMC.cond = (char)(MyChar.gMC.cond | 2);
                MycParam.DamageMyChar(2);
                break;
            }
            case 9: {
                npc.xm = npc.xm * 4 / 5;
                if (npc.xm != 0) break;
                npc.act_no = 0;
                break;
            }
            case 10: {
                MyChar.gMC.x = npc.x;
                MyChar.gMC.y = npc.y;
                npc.xm = npc.xm * 4 / 5;
                if (npc.xm != 0) break;
                npc.act_no = 11;
                npc.act_wait = 0;
                npc.ani_no = 5;
                npc.ani_wait = 0;
                break;
            }
            case 11: {
                MyChar.gMC.x = npc.x;
                MyChar.gMC.y = npc.y;
                if (++npc.ani_wait > 2) {
                    npc.ani_wait = 0;
                    ++npc.ani_no;
                }
                if (npc.ani_no > 6) {
                    npc.ani_no = 5;
                }
                if (++npc.act_wait <= 100) break;
                npc.act_no = 20;
                break;
            }
            case 20: {
                Sound.PlaySoundObject(25, 1);
                MyChar.gMC.cond = (char)(MyChar.gMC.cond & 0xFFFFFFFD);
                if (npc.direct == 0) {
                    MyChar.gMC.x += 2048;
                    MyChar.gMC.y -= 4096;
                    MyChar.gMC.xm = 1535;
                    MyChar.gMC.ym = -512;
                    MyChar.gMC.direct = 2;
                    npc.direct = 2;
                } else {
                    MyChar.gMC.x -= 2048;
                    MyChar.gMC.y -= 4096;
                    MyChar.gMC.xm = -1535;
                    MyChar.gMC.ym = -512;
                    MyChar.gMC.direct = 0;
                    npc.direct = 0;
                }
                npc.act_no = 21;
                npc.act_wait = 0;
                npc.ani_no = 7;
            }
            case 21: {
                if (++npc.act_wait < 50) break;
                npc.act_no = 0;
            }
        }
        npc.ym += 32;
        if (npc.xm < -1024) {
            npc.xm = -1024;
        }
        if (npc.xm > 1024) {
            npc.xm = 1024;
        }
        if (npc.ym > 1535) {
            npc.ym = 1535;
        }
        npc.x += npc.xm;
        npc.y += npc.ym;
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc068_rcLeft[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc068_rcRight[npc.ani_no]);
        }
    }

    public static void ActNpc069(NpChar.NPCHAR npc) {
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
            }
        }
        npc.ym += 64;
        if (npc.ym > 1535) {
            npc.ym = 1535;
        }
        npc.x += npc.xm;
        npc.y += npc.ym;
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc069_rcLeft[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc069_rcRight[npc.ani_no]);
        }
    }

    public static void ActNpc070(NpChar.NPCHAR npc) {
        if (++npc.ani_wait > 3) {
            npc.ani_wait = 0;
            ++npc.ani_no;
        }
        if (npc.ani_no > 3) {
            npc.ani_no = 0;
        }
        npc.rect.copyFrom(ActNpc070_rect[npc.ani_no]);
    }

    public static void ActNpc071(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
                npc.tgt_x = npc.x;
                npc.tgt_y = npc.y;
                npc.ym = 128;
            }
            case 1: {
                if (npc.tgt_y < npc.y) {
                    npc.ym -= 8;
                }
                if (npc.tgt_y > npc.y) {
                    npc.ym += 8;
                }
                if (npc.ym > 256) {
                    npc.ym = 256;
                }
                if (npc.ym >= -256) break;
                npc.ym = -256;
            }
        }
        npc.x += npc.xm;
        npc.y += npc.ym;
        if (++npc.ani_wait > 4) {
            npc.ani_wait = 0;
            ++npc.ani_no;
        }
        if (npc.ani_no > 1) {
            npc.ani_no = 0;
        }
        if (npc.shock != '\u0000') {
            npc.ani_no = 2;
        }
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc071_rcLeft[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc071_rcRight[npc.ani_no]);
        }
    }

    public static void ActNpc072(NpChar.NPCHAR npc) {
        if (npc.direct == 0) {
            if (++npc.ani_wait > 1) {
                npc.ani_wait = 0;
                ++npc.ani_no;
            }
            if (npc.ani_no > 1) {
                npc.ani_no = 0;
                return;
            }
            if (MyChar.gMC.x < npc.x + 163840 && MyChar.gMC.x > npc.x - 163840 && MyChar.gMC.y < npc.y + 122880 && MyChar.gMC.y > npc.y - 122880) {
                if (++npc.act_no % 2 != 0) {
                    NpChar.SetNpChar(73, npc.x, npc.y, Game.Random(-512, 512) * 2, Game.Random(-512, 128) * 3, 0, null, 256);
                }
                NpChar.SetNpChar(73, npc.x, npc.y, Game.Random(-512, 512) * 2, Game.Random(-512, 128) * 3, 0, null, 256);
            }
        }
        npc.rect.copyFrom(ActNpc072_rect[npc.ani_no]);
    }

    public static void ActNpc073(NpChar.NPCHAR npc) {
        npc.ym += 32;
        npc.ani_no = Game.Random(0, 4);
        if (npc.ym > 1535) {
            npc.ym = 1535;
        }
        npc.x += npc.xm;
        npc.y += npc.ym;
        npc.rect.copyFrom(ActNpc073_rect[npc.ani_no]);
        if (npc.direct == 2) {
            npc.rect.top += 2;
            npc.rect.bottom += 2;
        }
        if (++npc.act_wait > 10) {
            if ((npc.flag & 1) != 0) {
                npc.cond = 0;
            }
            if ((npc.flag & 4) != 0) {
                npc.cond = 0;
            }
            if ((npc.flag & 8) != 0) {
                npc.cond = 0;
            }
            if ((npc.flag & 0x100) != 0) {
                npc.cond = 0;
            }
        }
        if (npc.y > Map.gMap.length * 512 * 16) {
            npc.cond = 0;
        }
    }

    public static void ActNpc074(NpChar.NPCHAR npc) {
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
            case 8: {
                npc.act_no = 9;
                npc.ani_no = 2;
                npc.ani_wait = 0;
            }
            case 9: {
                if (++npc.ani_wait > 4) {
                    npc.ani_wait = 0;
                    ++npc.ani_no;
                }
                if (npc.ani_no > 5) {
                    npc.ani_no = 2;
                }
                npc.xm = npc.direct == 0 ? -512 : 512;
            }
        }
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
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc074_rcLeft[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc074_rcRight[npc.ani_no]);
        }
    }

    public static void ActNpc075(NpChar.NPCHAR npc) {
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
        npc.rect.copyFrom(ActNpc075_rcLeft[npc.ani_no]);
    }

    public static void ActNpc076(NpChar.NPCHAR npc) {
        npc.rect.left = npc.code_event * 16;
        npc.rect.top = 0;
        npc.rect.right = npc.rect.left + 16;
        npc.rect.bottom = 16;
    }

    public static void ActNpc077(NpChar.NPCHAR npc) {
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
            npc.rect.copyFrom(ActNpc077_rc[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc077_rc[2]);
        }
    }

    public static void ActNpc078(NpChar.NPCHAR npc) {
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc078_rc[0]);
        } else {
            npc.rect.copyFrom(ActNpc078_rc[1]);
        }
    }

    public static void ActNpc079(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
                npc.ani_no = 2;
                npc.ani_wait = 0;
                break;
            }
            case 2: {
                npc.ani_no = 0;
                if (Game.Random(0, 120) == 10) {
                    npc.act_no = 3;
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
            case 3: {
                if (++npc.act_wait <= 8) break;
                npc.act_no = 2;
                npc.ani_no = 0;
            }
        }
        npc.ym += 64;
        if (npc.ym > 1535) {
            npc.ym = 1535;
        }
        npc.y += npc.ym;
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc079_rcLeft[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc079_rcRight[npc.ani_no]);
        }
    }
}
