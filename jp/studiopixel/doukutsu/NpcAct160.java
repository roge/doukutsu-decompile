/*
 * Decompiled with CFR 0.152.
 */
package jp.studiopixel.doukutsu;

import jp.studiopixel.doukutsu.Caret;
import jp.studiopixel.doukutsu.Frame;
import jp.studiopixel.doukutsu.Game;
import jp.studiopixel.doukutsu.MyChar;
import jp.studiopixel.doukutsu.MycParam;
import jp.studiopixel.doukutsu.NpChar;
import jp.studiopixel.doukutsu.NpcHit;
import jp.studiopixel.doukutsu.RECT;
import jp.studiopixel.doukutsu.Sound;
import jp.studiopixel.doukutsu.Triangle;

public class NpcAct160 {
    private static final RECT[] ActNpc160_rect_left = new RECT[]{new RECT(0, 0, 40, 24), new RECT(40, 0, 80, 24), new RECT(80, 0, 120, 24), new RECT(120, 0, 160, 24)};
    private static final RECT[] ActNpc160_rect_right = new RECT[]{new RECT(0, 24, 40, 48), new RECT(40, 24, 80, 48), new RECT(80, 24, 120, 48), new RECT(120, 24, 160, 48)};
    private static final RECT[] ActNpc161_rect = new RECT[]{new RECT(0, 48, 16, 64), new RECT(16, 48, 32, 64), new RECT(32, 48, 48, 64)};
    private static final RECT ActNpc162_rect_left = new RECT(40, 0, 80, 24);
    private static final RECT ActNpc162_rect_right = new RECT(40, 24, 80, 48);
    private static final RECT ActNpc162_rect_end = new RECT(0, 0, 0, 0);
    private static final RECT[] ActNpc163_rcLeft = new RECT[]{new RECT(192, 0, 208, 16), new RECT(208, 0, 224, 16)};
    private static final RECT[] ActNpc163_rcRight = new RECT[]{new RECT(192, 16, 208, 32), new RECT(208, 16, 224, 32)};
    private static final RECT[] ActNpc164_rcLeft = new RECT[]{new RECT(224, 0, 240, 16), new RECT(240, 0, 256, 16)};
    private static final RECT[] ActNpc164_rcRight = new RECT[]{new RECT(224, 16, 240, 32), new RECT(240, 16, 256, 32)};
    private static final RECT[] ActNpc165_rcRight = new RECT[]{new RECT(192, 96, 208, 112), new RECT(208, 96, 224, 112)};
    private static final RECT ActNpc165_rcLeft = new RECT(144, 96, 160, 112);
    private static final RECT[] ActNpc166_rcLeft = new RECT[]{new RECT(144, 104, 184, 128), new RECT(184, 104, 224, 128)};
    private static final RECT[] ActNpc167_rect = new RECT[]{new RECT(304, 0, 320, 16), new RECT(304, 16, 320, 32), new RECT(0, 0, 0, 0)};
    private static final RECT ActNpc168_rect = new RECT(264, 56, 320, 96);
    private static final RECT[] ActNpc169_rect_left = new RECT[]{new RECT(0, 0, 40, 24), new RECT(0, 48, 40, 72), new RECT(0, 0, 40, 24), new RECT(40, 48, 80, 72), new RECT(0, 0, 40, 24), new RECT(80, 48, 120, 72), new RECT(120, 48, 160, 72), new RECT(120, 0, 160, 24), new RECT(80, 0, 120, 24)};
    private static final RECT[] ActNpc169_rect_right = new RECT[]{new RECT(0, 24, 40, 48), new RECT(0, 72, 40, 96), new RECT(0, 24, 40, 48), new RECT(40, 72, 80, 96), new RECT(0, 24, 40, 48), new RECT(80, 72, 120, 96), new RECT(120, 72, 160, 96), new RECT(120, 24, 160, 48), new RECT(80, 24, 120, 48)};
    private static final RECT[] ActNpc170_rcLeft = new RECT[]{new RECT(112, 96, 128, 104), new RECT(128, 96, 144, 104)};
    private static final RECT[] ActNpc170_rcRight = new RECT[]{new RECT(112, 104, 128, 112), new RECT(128, 104, 144, 112)};
    private static final RECT[] ActNpc171_rcLeft = new RECT[]{new RECT(120, 48, 152, 80), new RECT(152, 48, 184, 80)};
    private static final RECT[] ActNpc171_rcRight = new RECT[]{new RECT(184, 48, 216, 80), new RECT(216, 48, 248, 80)};
    private static final RECT[] ActNpc172_rect = new RECT[]{new RECT(248, 48, 264, 80), new RECT(264, 48, 280, 80), new RECT(280, 48, 296, 80)};
    private static final RECT[] ActNpc173_rcLeft = new RECT[]{new RECT(0, 128, 24, 152), new RECT(24, 128, 48, 152), new RECT(48, 128, 72, 152), new RECT(72, 128, 96, 152)};
    private static final RECT[] ActNpc173_rcRight = new RECT[]{new RECT(0, 152, 24, 176), new RECT(24, 152, 48, 176), new RECT(48, 152, 72, 176), new RECT(72, 152, 96, 176)};
    private static final RECT[] ActNpc174_rect_left = new RECT[]{new RECT(120, 80, 136, 96), new RECT(136, 80, 152, 96), new RECT(152, 80, 168, 96)};
    private static final RECT[] ActNpc175_rcLeft = new RECT[]{new RECT(168, 80, 192, 104), new RECT(192, 80, 216, 104)};
    private static final RECT[] ActNpc175_rcRight = new RECT[]{new RECT(216, 80, 240, 104), new RECT(240, 80, 264, 104)};
    private static final RECT[] ActNpc176_rcLeft = new RECT[]{new RECT(96, 128, 128, 144), new RECT(128, 128, 160, 144), new RECT(160, 128, 192, 144)};
    private static final RECT[] ActNpc176_rcRight = new RECT[]{new RECT(96, 144, 128, 160), new RECT(128, 144, 160, 160), new RECT(160, 144, 192, 160)};
    private static final RECT[] ActNpc177_rc = new RECT[]{new RECT(192, 128, 208, 144), new RECT(208, 128, 224, 144)};
    private static final RECT[] ActNpc178_rect_left = new RECT[]{new RECT(0, 224, 16, 240), new RECT(16, 224, 32, 240), new RECT(32, 224, 48, 240)};
    private static final RECT[] ActNpc179_rect_left = new RECT[]{new RECT(48, 224, 72, 240), new RECT(72, 224, 96, 240), new RECT(96, 224, 120, 240)};

    public static void ActNpc160(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.bits = (char)(npc.bits & 0xFFFFFFFE);
                npc.act_no = 1;
            }
            case 1: {
                npc.direct = npc.x < MyChar.gMC.x ? 2 : 0;
                npc.ym = 2560;
                if (npc.y < 65536) {
                    ++npc.count1;
                    break;
                }
                npc.bits = (char)(npc.bits & 0xFFFFFFF7);
                npc.act_no = 2;
                break;
            }
            case 2: {
                npc.ym = 2560;
                if ((npc.flag & 8) != 0) {
                    NpChar.DeleteNpCharCode(161, true);
                    for (int i = 0; i < 4; ++i) {
                        NpChar.SetNpChar(4, npc.x + Game.Random(-12, 12) * 512, npc.y + Game.Random(-12, 12) * 512, Game.Random(-341, 341), Game.Random(-1536, 0), 0, null, 256);
                    }
                    npc.act_no = 3;
                    npc.act_wait = 0;
                    Frame.SetQuake(30);
                    Sound.PlaySoundObject(26, 1);
                    Sound.PlaySoundObject(72, 1);
                }
                if (npc.y < MyChar.gMC.y && (MyChar.gMC.flag & 8) != 0) {
                    npc.damage = 20;
                    break;
                }
                npc.damage = 0;
                break;
            }
            case 3: {
                npc.damage = 20;
                npc.damage = 0;
                if (++npc.act_wait <= 24) break;
                npc.act_no = 4;
                npc.count1 = 0;
                npc.count2 = 0;
                break;
            }
            case 4: {
                NpChar.gSuperXpos = npc.x;
                NpChar.gSuperYpos = npc.y;
                if (npc.shock % 2 != 1) break;
                NpChar.SetNpChar(161, npc.x + Game.Random(-12, 12) * 512, npc.y + Game.Random(-12, 12) * 512, Game.Random(-1536, 1536), Game.Random(-1536, 1536), 0, null, 256);
                if (++npc.count1 <= 30) break;
                npc.count1 = 0;
                npc.act_no = 5;
                npc.ym = -3072;
                npc.bits = (char)(npc.bits | 8);
                break;
            }
            case 5: {
                NpChar.gSuperXpos = npc.x;
                NpChar.gSuperYpos = npc.y;
                if (++npc.count1 <= 60) break;
                npc.count1 = 0;
                npc.act_no = 6;
                break;
            }
            case 6: {
                NpChar.gSuperXpos = MyChar.gMC.x;
                NpChar.gSuperYpos = 0x320000;
                if (++npc.count1 <= 110) break;
                npc.count1 = 10;
                npc.x = MyChar.gMC.x;
                npc.y = 0;
                npc.ym = 1535;
                npc.act_no = 1;
            }
        }
        npc.y += npc.ym;
        switch (npc.act_no) {
            case 0: 
            case 1: {
                npc.ani_no = 3;
                break;
            }
            case 2: {
                npc.ani_no = 3;
                break;
            }
            case 3: {
                npc.ani_no = 2;
                break;
            }
            case 4: {
                npc.ani_no = 0;
                break;
            }
            case 5: {
                npc.ani_no = 3;
                break;
            }
            case 6: {
                npc.ani_no = 3;
            }
        }
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc160_rect_left[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc160_rect_right[npc.ani_no]);
        }
    }

    public static void ActNpc161(NpChar.NPCHAR npc) {
        npc.exp = 0;
        npc.xm = npc.x < NpChar.gSuperXpos ? (npc.xm += 64) : (npc.xm -= 64);
        npc.ym = npc.y < NpChar.gSuperYpos ? (npc.ym += 64) : (npc.ym -= 64);
        if (npc.xm < -4605) {
            npc.xm = -4605;
        }
        if (npc.xm > 4605) {
            npc.xm = 4605;
        }
        if (npc.ym < -4605) {
            npc.ym = -4605;
        }
        if (npc.ym > 4605) {
            npc.ym = 4605;
        }
        if (npc.life < 100) {
            npc.bits = (char)(npc.bits & 0xFFFFFFDF);
            npc.bits = (char)(npc.bits & 0xFFFFFFFB);
            npc.damage = 0;
            npc.ani_no = 2;
        }
        npc.x += npc.xm;
        npc.y += npc.ym;
        if (npc.ani_no < 2) {
            npc.ani_no = Game.Random(0, 10) == 2 ? 0 : 1;
        }
        npc.rect.copyFrom(ActNpc161_rect[npc.ani_no]);
    }

    public static void ActNpc162(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                NpChar.DeleteNpCharCode(161, true);
                Sound.PlaySoundObject(72, 1);
                for (int i = 0; i < 10; ++i) {
                    NpChar.SetNpChar(4, npc.x + Game.Random(-12, 12) * 512, npc.y + Game.Random(-12, 12) * 512, Game.Random(-1536, 1536), Game.Random(-1536, 1536), 0, null, 256);
                }
                npc.direct = npc.x > MyChar.gMC.x ? 0 : 2;
                if (npc.direct == 0) {
                    npc.rect.copyFrom(ActNpc162_rect_left);
                } else {
                    npc.rect.copyFrom(ActNpc162_rect_right);
                }
                npc.count1 = 0;
                npc.act_no = 1;
            }
            case 1: {
                ++npc.count1;
                if (npc.count1 % 4 == 0) {
                    NpChar.SetNpChar(161, npc.x + Game.Random(-12, 12) * 512, npc.y + Game.Random(-12, 12) * 512, 0, 0, 0, null, 256);
                }
                if (npc.count1 <= 160) break;
                npc.count1 = 0;
                npc.act_no = 2;
                npc.tgt_y = npc.y;
                break;
            }
            case 2: {
                Frame.SetQuake(2);
                ++npc.count1;
                if (npc.count1 <= 240) {
                    if (npc.direct == 0) {
                        npc.rect.copyFrom(ActNpc162_rect_left);
                    } else {
                        npc.rect.copyFrom(ActNpc162_rect_right);
                    }
                    npc.rect.top += npc.count1 / 8;
                    npc.y = npc.tgt_y + npc.count1 / 8 * 512;
                    npc.rect.left -= npc.count1 / 2 % 2;
                } else {
                    npc.rect.copyFrom(ActNpc162_rect_end);
                    npc.count1 = 0;
                    npc.act_no = 3;
                }
                if (npc.count1 % 3 == 2) {
                    NpChar.SetNpChar(161, npc.x + Game.Random(-12, 12) * 512, npc.y - 6144, Game.Random(-512, 512), 256, 0, null, 256);
                }
                if (npc.count1 % 4 != 2) break;
                Sound.PlaySoundObject(21, 1);
                break;
            }
            case 3: {
                if (++npc.count1 < 60) break;
                NpChar.DeleteNpCharCode(161, true);
                npc.cond = 0;
            }
        }
        NpChar.gSuperXpos = npc.x;
        NpChar.gSuperYpos = -512000;
    }

    public static void ActNpc163(NpChar.NPCHAR npc) {
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
            npc.rect.copyFrom(ActNpc163_rcLeft[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc163_rcRight[npc.ani_no]);
        }
    }

    public static void ActNpc164(NpChar.NPCHAR npc) {
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
            npc.rect.copyFrom(ActNpc164_rcLeft[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc164_rcRight[npc.ani_no]);
        }
    }

    public static void ActNpc165(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
                npc.y += 5120;
            }
            case 1: {
                npc.ani_no = npc.direct == 2 && MyChar.gMC.x > npc.x - 16384 && MyChar.gMC.x < npc.x + 16384 && MyChar.gMC.y > npc.y - 8192 && MyChar.gMC.y < npc.y + 8192 ? 1 : 0;
            }
        }
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc165_rcLeft);
        } else {
            npc.rect.copyFrom(ActNpc165_rcRight[npc.ani_no]);
        }
    }

    public static void ActNpc166(NpChar.NPCHAR npc) {
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
        npc.rect.copyFrom(ActNpc166_rcLeft[npc.ani_no]);
    }

    public static void ActNpc167(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
                npc.ani_no = 1;
                break;
            }
            case 10: {
                npc.ani_no = 0;
                npc.ym += 64;
                if (npc.ym > 1535) {
                    npc.ym = 1535;
                }
                npc.y += npc.ym;
                break;
            }
            case 20: {
                npc.act_no = 21;
                npc.act_wait = 0;
                npc.ani_no = 0;
                Sound.PlaySoundObject(29, 1);
            }
            case 21: {
                if (++npc.ani_no > 2) {
                    npc.ani_no = 1;
                }
                if (++npc.act_wait <= 100) break;
                for (int i = 0; i < 4; ++i) {
                    NpChar.SetNpChar(4, npc.x + Game.Random(-12, 12) * 512, npc.y + Game.Random(-12, 12) * 512, Game.Random(-341, 341), Game.Random(-1536, 0), 0, null, 256);
                }
                npc.cond = 0;
            }
        }
        npc.rect.copyFrom(ActNpc167_rect[npc.ani_no]);
    }

    public static void ActNpc168(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
                break;
            }
            case 10: {
                npc.act_no = 11;
                npc.act_wait = 0;
                npc.tgt_x = npc.x;
            }
            case 11: {
                ++npc.act_wait;
                npc.x = npc.tgt_x;
                if (npc.act_wait / 3 % 2 == 0) break;
                npc.x += 512;
                break;
            }
            case 20: {
                npc.act_no = 21;
                npc.act_wait = 0;
                npc.ym = -1024;
                npc.xm = 256;
                Sound.PlaySoundObject(25, 1);
            }
            case 21: {
                npc.ym += 16;
                npc.x += npc.xm;
                npc.y += npc.ym;
                if (npc.act_wait != 0 && (npc.flag & 8) != 0) {
                    Sound.PlaySoundObject(35, 1);
                    Frame.SetQuake(40);
                    npc.act_no = 0;
                }
                if (npc.act_wait != 0) break;
                ++npc.act_wait;
            }
        }
        npc.rect.copyFrom(ActNpc168_rect);
    }

    public static void ActNpc169(NpChar.NPCHAR npc) {
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
                ++npc.ani_wait;
                if (npc.ani_wait > 3) {
                    npc.ani_wait = 0;
                    ++npc.ani_no;
                    if (npc.ani_no == 2 || npc.ani_no == 4) {
                        Sound.PlaySoundObject(23, 1);
                    }
                }
                if (npc.ani_no > 4) {
                    npc.ani_no = 1;
                }
                npc.xm = npc.direct == 0 ? (npc.xm -= 32) : (npc.xm += 32);
                if (npc.act_wait >= 8 && npc.x - 6144 < MyChar.gMC.x && npc.x + 6144 > MyChar.gMC.x && npc.y - 6144 < MyChar.gMC.y && npc.y + 4096 > MyChar.gMC.y) {
                    npc.act_no = 10;
                    npc.ani_no = 5;
                    MyChar.gMC.cond = (char)(MyChar.gMC.cond | 2);
                    MycParam.DamageMyChar(5);
                    break;
                }
                ++npc.act_wait;
                if (npc.act_wait > 75) {
                    npc.act_no = 9;
                    npc.ani_no = 0;
                    break;
                }
                if ((npc.flag & 5) != 0) {
                    if (npc.count2 < 5) {
                        ++npc.count2;
                    } else {
                        npc.act_no = 4;
                        npc.act_wait = 0;
                        npc.ani_no = 7;
                        npc.ym = -1535;
                    }
                } else {
                    npc.count2 = 0;
                }
                if (npc.count1 % 2 != 0 || npc.act_wait <= 25) break;
                npc.act_no = 4;
                npc.act_wait = 0;
                npc.ani_no = 7;
                npc.ym = -1535;
                break;
            }
            case 4: {
                npc.direct = npc.x > MyChar.gMC.x ? 0 : 2;
                ++npc.act_wait;
                if (npc.act_wait < 30 && npc.act_wait % 6 == 1) {
                    Sound.PlaySoundObject(39, 1);
                    NpChar.SetNpChar(170, npc.x, npc.y, 0, 0, npc.direct, null, 256);
                }
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
                MycParam.DamageMyChar(10);
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
                ++npc.ani_wait;
                if (npc.ani_wait > 2) {
                    npc.ani_wait = 0;
                    ++npc.ani_no;
                }
                if (npc.ani_no > 6) {
                    npc.ani_no = 5;
                }
                ++npc.act_wait;
                if (npc.act_wait <= 100) break;
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
                ++npc.act_wait;
                if (npc.act_wait < 50) break;
                npc.act_no = 0;
            }
        }
        npc.ym += 32;
        if (npc.xm < -768) {
            npc.xm = -768;
        }
        if (npc.xm > 768) {
            npc.xm = 768;
        }
        if (npc.ym > 1535) {
            npc.ym = 1535;
        }
        npc.x += npc.xm;
        npc.y += npc.ym;
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc169_rect_left[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc169_rect_right[npc.ani_no]);
        }
    }

    public static void ActNpc170(NpChar.NPCHAR npc) {
        boolean bHit = false;
        if (npc.direct == 0 && (npc.flag & 1) != 0) {
            bHit = true;
        }
        if (npc.direct == 2 && (npc.flag & 4) != 0) {
            bHit = true;
        }
        if (bHit) {
            Sound.PlaySoundObject(44, 1);
            NpChar.SetDestroyNpChar(npc.x, npc.y, 0, 3);
            NpChar.VanishNpChar(npc);
            return;
        }
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
                npc.xm = npc.direct == 0 ? Game.Random(1, 2) * 512 : Game.Random(-2, -1) * 512;
                npc.ym = Game.Random(-2, 0) * 512;
            }
            case 1: {
                ++npc.count1;
                if (npc.direct == 0) {
                    npc.xm -= 32;
                    if (npc.count1 % 3 == 1) {
                        Caret.SetCaret(npc.x + 4096, npc.y, 7, 2);
                    }
                } else {
                    npc.xm += 32;
                    if (npc.count1 % 3 == 1) {
                        Caret.SetCaret(npc.x - 4096, npc.y, 7, 0);
                    }
                }
                npc.ym = npc.count1 < 50 ? (npc.y < MyChar.gMC.y ? (npc.ym += 32) : (npc.ym -= 32)) : 0;
                if (++npc.ani_no <= 1) break;
                npc.ani_no = 0;
            }
        }
        if (npc.xm < -1024) {
            npc.xm = -1536;
        }
        if (npc.xm > 1024) {
            npc.xm = 1536;
        }
        npc.x += npc.xm;
        npc.y += npc.ym;
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc170_rcLeft[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc170_rcRight[npc.ani_no]);
        }
    }

    public static void ActNpc171(NpChar.NPCHAR npc) {
        npc.direct = npc.x > MyChar.gMC.x ? 0 : 2;
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
                npc.act_wait = Game.Random(0, 50);
                npc.tgt_y = npc.y;
            }
            case 1: {
                if (npc.act_wait != 0) {
                    --npc.act_wait;
                } else {
                    npc.act_no = 10;
                    npc.ym = 512;
                }
            }
            case 10: {
                if (++npc.ani_wait > 0) {
                    npc.ani_wait = 0;
                    ++npc.ani_no;
                }
                if (npc.ani_no > 1) {
                    npc.ani_no = 0;
                }
                npc.ym = npc.y < npc.tgt_y ? (npc.ym += 16) : (npc.ym -= 16);
                if (npc.ym > 512) {
                    npc.ym = 512;
                }
                if (npc.ym < -512) {
                    npc.ym = -512;
                }
                npc.y += npc.ym;
                if (npc.direct == 0) {
                    if (MyChar.gMC.y < npc.y + 40960 && MyChar.gMC.y > npc.y - 40960 && MyChar.gMC.x < npc.x && MyChar.gMC.x > npc.x - 81920) {
                        ++npc.count1;
                    }
                } else if (MyChar.gMC.y < npc.y + 40960 && MyChar.gMC.y > npc.y - 40960 && MyChar.gMC.x < npc.x + 81920 && MyChar.gMC.x > npc.x) {
                    ++npc.count1;
                }
                if (npc.count1 <= 20) break;
                NpChar.SetNpChar(172, npc.x, npc.y, 0, 0, npc.direct, null, 256);
                npc.count1 = -100;
                NpChar.gCurlyShoot_wait = Game.Random(80, 100);
                NpChar.gCurlyShoot_x = npc.x;
                NpChar.gCurlyShoot_y = npc.y;
            }
        }
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc171_rcLeft[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc171_rcRight[npc.ani_no]);
        }
    }

    public static void ActNpc172(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
            }
            case 1: {
                if (++npc.ani_wait > 1) {
                    npc.ani_wait = 0;
                    ++npc.ani_no;
                }
                if (npc.ani_no > 2) {
                    npc.ani_no = 0;
                }
                npc.x = npc.direct == 0 ? (npc.x -= 512) : (npc.x += 512);
                if ((npc.flag & 1) == 0 && (npc.flag & 4) == 0) break;
                Caret.SetCaret(npc.x, npc.y, 2, 0);
                NpChar.VanishNpChar(npc);
                return;
            }
        }
        npc.rect.copyFrom(ActNpc172_rect[npc.ani_no]);
    }

    public static void ActNpc173(NpChar.NPCHAR npc) {
        if (npc.x > MyChar.gMC.x + 163840 || npc.x < MyChar.gMC.x - 163840 || npc.y > MyChar.gMC.y + 122880 || npc.y < MyChar.gMC.y - 122880) {
            return;
        }
        switch (npc.act_no) {
            case 0: {
                npc.tgt_x = npc.x;
                npc.act_no = 1;
            }
            case 1: {
                npc.ani_no = 0;
                npc.xm = 0;
                if (npc.act_wait < 5) {
                    ++npc.act_wait;
                    break;
                }
                if (npc.x - 98304 >= MyChar.gMC.x || npc.x + 98304 <= MyChar.gMC.x || npc.y - 81920 >= MyChar.gMC.y || npc.y + 81920 <= MyChar.gMC.y) break;
                npc.act_no = 10;
                npc.act_wait = 0;
                npc.ani_no = 1;
                break;
            }
            case 10: {
                if (++npc.act_wait <= 3) break;
                if (++npc.count1 == 3) {
                    Sound.PlaySoundObject(30, 1);
                    npc.count1 = 0;
                    npc.act_no = 25;
                    npc.act_wait = 0;
                    npc.ani_no = 2;
                    npc.ym = -1536;
                    if (npc.x < npc.tgt_x) {
                        npc.xm = 128;
                        break;
                    }
                    npc.xm = -128;
                    break;
                }
                Sound.PlaySoundObject(30, 1);
                npc.act_no = 20;
                npc.ani_no = 2;
                npc.ym = -512;
                if (npc.x < npc.tgt_x) {
                    npc.xm = 512;
                    break;
                }
                npc.xm = -512;
                break;
            }
            case 20: {
                ++npc.act_wait;
                if ((npc.flag & 8) == 0) break;
                Sound.PlaySoundObject(23, 1);
                npc.ani_no = 1;
                npc.act_no = 30;
                npc.act_wait = 0;
                break;
            }
            case 25: {
                if (++npc.act_wait == 30 || npc.act_wait == 40) {
                    char deg = (char)Triangle.GetArktan(npc.x - MyChar.gMC.x, npc.y - MyChar.gMC.y);
                    deg = (char)(deg + Game.Random(-6, 6) & 0xFF & 0xFF);
                    int ym = Triangle.GetSin(deg) * 3;
                    int xm = Triangle.GetCos(deg) * 3;
                    NpChar.SetNpChar(174, npc.x, npc.y, xm, ym, 0, null, 256);
                    Sound.PlaySoundObject(39, 1);
                    npc.ani_no = 3;
                    NpChar.gCurlyShoot_wait = Game.Random(80, 100);
                    NpChar.gCurlyShoot_x = npc.x;
                    NpChar.gCurlyShoot_y = npc.y;
                }
                if (npc.act_wait == 35 || npc.act_wait == 45) {
                    npc.ani_no = 2;
                }
                if ((npc.flag & 8) == 0) break;
                Sound.PlaySoundObject(23, 1);
                npc.ani_no = 1;
                npc.act_no = 30;
                npc.act_wait = 0;
                break;
            }
            case 30: {
                npc.xm = 7 * npc.xm / 8;
                if (++npc.act_wait <= 3) break;
                npc.ani_no = 0;
                npc.act_no = 1;
                npc.act_wait = 0;
            }
        }
        npc.ym += 51;
        npc.direct = MyChar.gMC.x < npc.x ? 0 : 2;
        if (npc.ym > 1535) {
            npc.ym = 1535;
        }
        if (npc.ym < -1535) {
            npc.ym = 1535;
        }
        npc.x += npc.xm;
        npc.y += npc.ym;
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc173_rcLeft[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc173_rcRight[npc.ani_no]);
        }
        if (npc.life <= 985) {
            NpChar.SetDestroyNpChar(npc.x, npc.y, 0, 2);
            npc.code_char = 154;
            npc.act_no = 0;
        }
    }

    public static void ActNpc174(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                if (npc.direct == 2) {
                    npc.act_no = 2;
                }
            }
            case 1: {
                npc.x += npc.xm;
                npc.y += npc.ym;
                boolean bHit = false;
                if ((npc.flag & 1) != 0) {
                    bHit = true;
                    npc.xm = 512;
                }
                if ((npc.flag & 4) != 0) {
                    bHit = true;
                    npc.xm = -512;
                }
                if ((npc.flag & 2) != 0) {
                    bHit = true;
                    npc.ym = 512;
                }
                if ((npc.flag & 8) != 0) {
                    bHit = true;
                    npc.ym = -512;
                }
                if (!bHit) break;
                npc.act_no = 2;
                ++npc.count1;
                Sound.PlaySoundObject(31, 1);
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
        if (++npc.ani_no > 2) {
            npc.ani_no = 0;
        }
        npc.rect.copyFrom(ActNpc174_rect_left[npc.ani_no]);
    }

    public static void ActNpc175(NpChar.NPCHAR npc) {
        if (npc.act_no < 3 && npc.life < 90) {
            NpcHit.LoseNpChar(npc, false);
            npc.act_no = 10;
            npc.ani_no = 1;
            npc.bits = (char)(npc.bits & 0xFFFFFFDF);
            npc.damage = 0;
        }
        switch (npc.act_no) {
            case 0: {
                npc.ani_no = 0;
                npc.act_no = 1;
            }
        }
        npc.ym = npc.direct == 0 ? (npc.ym += 32) : (npc.ym -= 32);
        if (npc.ym < -1535) {
            npc.ym = -1535;
        }
        if (npc.ym > 1535) {
            npc.ym = 1535;
        }
        npc.y += npc.ym;
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc175_rcLeft[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc175_rcRight[npc.ani_no]);
        }
    }

    public static void ActNpc176(NpChar.NPCHAR npc) {
        if (npc.act_no < 3 && npc.life < 940) {
            NpcHit.LoseNpChar(npc, false);
            npc.act_no = 10;
            npc.ani_no = 2;
            npc.bits = (char)(npc.bits & 0xFFFFFFDF);
            npc.damage = 0;
        }
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
                npc.ani_no = 0;
                npc.ani_wait = 0;
            }
            case 1: {
                if (npc.direct == 0) {
                    if (npc.x < MyChar.gMC.x + 81920 && npc.x > MyChar.gMC.x - 81920 && npc.y < MyChar.gMC.y + 81920 && npc.y > MyChar.gMC.y - 8192) {
                        ++npc.count1;
                    }
                } else if (npc.x < MyChar.gMC.x + 81920 && npc.x > MyChar.gMC.x - 81920 && npc.y < MyChar.gMC.y + 8192 && npc.y > MyChar.gMC.y - 81920) {
                    ++npc.count1;
                }
                if (npc.count1 <= 10) break;
                npc.act_no = 2;
                npc.act_wait = 0;
                break;
            }
            case 2: {
                if (++npc.ani_wait > 3) {
                    npc.ani_wait = 0;
                    ++npc.ani_no;
                }
                if (npc.ani_no > 1) {
                    npc.ani_no = 0;
                }
                if (++npc.act_wait <= 10) break;
                if (++npc.count2 > 2) {
                    npc.count2 = 0;
                    npc.count1 = -90;
                } else {
                    npc.count1 = -10;
                }
                if (npc.direct == 0) {
                    NpChar.SetNpChar(177, npc.x, npc.y - 4096, 0, 0, 0, null, 256);
                } else {
                    NpChar.SetNpChar(177, npc.x, npc.y + 4096, 0, 0, 2, null, 256);
                }
                Sound.PlaySoundObject(39, 1);
                npc.act_no = 0;
                npc.ani_no = 0;
                NpChar.gCurlyShoot_wait = Game.Random(80, 100);
                NpChar.gCurlyShoot_x = npc.x;
                NpChar.gCurlyShoot_y = npc.y;
            }
        }
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc176_rcLeft[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc176_rcRight[npc.ani_no]);
        }
    }

    public static void ActNpc177(NpChar.NPCHAR npc) {
        if ((npc.flag & 0xFF) != 0) {
            Caret.SetCaret(npc.x, npc.y, 3, 0);
            npc.cond = 0;
            return;
        }
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
                npc.ym = npc.direct == 0 ? -1536 : 1536;
            }
            case 1: {
                if (npc.y >= MyChar.gMC.y + 8192 || npc.y <= MyChar.gMC.y - 8192) break;
                npc.act_no = 10;
                npc.tgt_x = npc.x;
                npc.tgt_y = npc.y;
                npc.direct = npc.x > MyChar.gMC.x ? 0 : 2;
                npc.xm = (Game.Random(0, 1) * 512 - 256) * 2;
                npc.ym = (Game.Random(0, 1) * 512 - 256) * 2;
                break;
            }
            case 10: {
                npc.xm = npc.x < npc.tgt_x ? (npc.xm += 32) : (npc.xm -= 32);
                npc.ym = npc.y < npc.tgt_y ? (npc.ym += 32) : (npc.ym -= 32);
                if (++npc.act_wait > 300) {
                    Caret.SetCaret(npc.x, npc.y, 3, 0);
                    npc.cond = 0;
                    return;
                }
                if (npc.direct == 0) {
                    npc.tgt_x -= 512;
                    break;
                }
                npc.tgt_x += 512;
            }
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
        npc.x += npc.xm;
        npc.y += npc.ym;
        if (++npc.ani_wait > 6) {
            npc.ani_wait = 0;
            ++npc.ani_no;
        }
        if (npc.ani_no > 1) {
            npc.ani_no = 0;
        }
        npc.rect.copyFrom(ActNpc177_rc[npc.ani_no]);
    }

    public static void ActNpc178(NpChar.NPCHAR npc) {
        if ((npc.flag & 0xFF) != 0) {
            Caret.SetCaret(npc.x, npc.y, 2, 0);
            npc.cond = 0;
        }
        if ((npc.flag & 0x100) != 0) {
            npc.y += npc.ym / 2;
            npc.x += npc.xm / 2;
        } else {
            npc.y += npc.ym;
            npc.x += npc.xm;
        }
        if (++npc.ani_wait > 1) {
            npc.ani_wait = 0;
            ++npc.ani_no;
        }
        if (npc.ani_no > 2) {
            npc.ani_no = 0;
        }
        npc.rect.copyFrom(ActNpc178_rect_left[npc.ani_no]);
        if (++npc.count1 > 150) {
            NpChar.VanishNpChar(npc);
            Caret.SetCaret(npc.x, npc.y, 2, 0);
        }
    }

    public static void ActNpc179(NpChar.NPCHAR npc) {
        if ((npc.flag & 0xFF) != 0) {
            npc.cond = 0;
            Caret.SetCaret(npc.x, npc.y, 2, 0);
        }
        npc.xm -= 32;
        npc.ym = 0;
        if (npc.xm < -1024) {
            npc.xm = -1024;
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
        npc.rect.copyFrom(ActNpc179_rect_left[npc.ani_no]);
        if (++npc.count1 > 300) {
            NpChar.VanishNpChar(npc);
            Caret.SetCaret(npc.x, npc.y, 2, 0);
        }
    }
}
