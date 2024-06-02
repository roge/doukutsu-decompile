/*
 * Decompiled with CFR 0.152.
 */
package jp.studiopixel.doukutsu;

import jp.studiopixel.doukutsu.Boss;
import jp.studiopixel.doukutsu.Bullet;
import jp.studiopixel.doukutsu.Caret;
import jp.studiopixel.doukutsu.Frame;
import jp.studiopixel.doukutsu.Game;
import jp.studiopixel.doukutsu.Map;
import jp.studiopixel.doukutsu.MyChar;
import jp.studiopixel.doukutsu.NpChar;
import jp.studiopixel.doukutsu.RECT;
import jp.studiopixel.doukutsu.Sound;
import jp.studiopixel.doukutsu.Triangle;

public class NpcAct300 {
    private static final RECT ActNpc300_rc = new RECT(192, 80, 208, 96);
    private static final RECT[] ActNpc301_rect = new RECT[]{new RECT(144, 0, 160, 16), new RECT(160, 0, 176, 16), new RECT(176, 0, 192, 16), new RECT(192, 0, 208, 16), new RECT(144, 16, 160, 32), new RECT(160, 16, 176, 32), new RECT(176, 16, 192, 32), new RECT(192, 16, 208, 32)};
    private static final RECT[] ActNpc303_rcLeft = new RECT[]{new RECT(216, 152, 232, 168), new RECT(232, 152, 248, 168)};
    private static final RECT[] ActNpc303_rcRight = new RECT[]{new RECT(216, 168, 232, 184), new RECT(232, 168, 248, 184)};
    private static final RECT[] ActNpc304_rc = new RECT[]{new RECT(0, 176, 24, 192), new RECT(24, 176, 48, 192), new RECT(48, 176, 72, 192), new RECT(72, 176, 96, 192)};
    private static final RECT[] ActNpc305_rcLeft = new RECT[]{new RECT(160, 144, 176, 160), new RECT(176, 144, 192, 160)};
    private static final RECT[] ActNpc305_rcRight = new RECT[]{new RECT(160, 160, 176, 176), new RECT(176, 160, 192, 176)};
    private static final RECT[] ActNpc306_rcLeft = new RECT[]{new RECT(240, 96, 280, 128), new RECT(280, 96, 320, 128)};
    private static final RECT[] ActNpc306_rcRight = new RECT[]{new RECT(160, 152, 200, 184), new RECT(200, 152, 240, 184)};
    private static final RECT[] ActNpc307_rcLeft = new RECT[]{new RECT(0, 32, 16, 48), new RECT(16, 32, 32, 48)};
    private static final RECT[] ActNpc307_rcRight = new RECT[]{new RECT(0, 48, 16, 64), new RECT(16, 48, 32, 64)};
    private static final RECT[] ActNpc308_rcLeft = new RECT[]{new RECT(128, 112, 144, 128), new RECT(144, 112, 160, 128)};
    private static final RECT[] ActNpc308_rcRight = new RECT[]{new RECT(128, 128, 144, 144), new RECT(144, 128, 160, 144)};
    private static final RECT[] ActNpc309_rcLeft = new RECT[]{new RECT(0, 0, 16, 16), new RECT(16, 0, 32, 16)};
    private static final RECT[] ActNpc309_rcRight = new RECT[]{new RECT(0, 16, 16, 32), new RECT(16, 16, 32, 32)};
    private static final RECT[] ActNpc310_rcLeft = new RECT[]{new RECT(32, 0, 56, 16), new RECT(56, 0, 80, 16), new RECT(80, 0, 104, 16), new RECT(104, 0, 128, 16), new RECT(128, 0, 152, 16)};
    private static final RECT[] ActNpc310_rcRight = new RECT[]{new RECT(32, 16, 56, 32), new RECT(56, 16, 80, 32), new RECT(80, 16, 104, 32), new RECT(104, 16, 128, 32), new RECT(128, 16, 152, 32)};
    private static final RECT[] ActNpc311_rcLeft = new RECT[]{new RECT(0, 32, 24, 56), new RECT(24, 32, 48, 56), new RECT(48, 32, 72, 56), new RECT(72, 32, 96, 56), new RECT(96, 32, 120, 56), new RECT(120, 32, 144, 56), new RECT(144, 32, 168, 56)};
    private static final RECT[] ActNpc311_rcRight = new RECT[]{new RECT(0, 56, 24, 80), new RECT(24, 56, 48, 80), new RECT(48, 56, 72, 80), new RECT(72, 56, 96, 80), new RECT(96, 56, 120, 80), new RECT(120, 56, 144, 80), new RECT(144, 56, 168, 80)};
    private static final RECT[] ActNpc312_rcLeft = new RECT[]{new RECT(0, 160, 16, 176), new RECT(16, 160, 32, 176), new RECT(32, 160, 48, 176), new RECT(48, 160, 64, 176), new RECT(64, 160, 80, 176)};
    private static final RECT[] ActNpc312_rcRight = new RECT[]{new RECT(0, 176, 16, 192), new RECT(16, 176, 32, 192), new RECT(32, 176, 48, 192), new RECT(48, 176, 64, 192), new RECT(64, 176, 80, 192)};
    private static final RECT[] ActNpc313_rcLeft = new RECT[]{new RECT(128, 0, 144, 16), new RECT(144, 0, 160, 16), new RECT(160, 0, 176, 16), new RECT(176, 0, 192, 16), new RECT(192, 0, 208, 16), new RECT(208, 0, 224, 16), new RECT(224, 0, 240, 16), new RECT(240, 0, 256, 16), new RECT(256, 0, 272, 16), new RECT(272, 0, 288, 16), new RECT(288, 0, 304, 16), new RECT(128, 0, 144, 16), new RECT(176, 0, 192, 16), new RECT(304, 0, 320, 16)};
    private static final RECT[] ActNpc313_rcRight = new RECT[]{new RECT(128, 16, 144, 32), new RECT(144, 16, 160, 32), new RECT(160, 16, 176, 32), new RECT(176, 16, 192, 32), new RECT(192, 16, 208, 32), new RECT(208, 16, 224, 32), new RECT(224, 16, 240, 32), new RECT(240, 16, 256, 32), new RECT(256, 16, 272, 32), new RECT(272, 16, 288, 32), new RECT(288, 16, 304, 32), new RECT(128, 16, 144, 32), new RECT(176, 16, 192, 32), new RECT(304, 16, 320, 32)};
    private static final RECT[] ActNpc314_rc = new RECT[]{new RECT(64, 64, 80, 80), new RECT(80, 64, 96, 80), new RECT(96, 64, 112, 80)};
    private static final RECT[] ActNpc315_rcLeft = new RECT[]{new RECT(128, 0, 144, 16), new RECT(160, 0, 176, 16), new RECT(176, 0, 192, 16), new RECT(192, 0, 208, 16)};
    private static final RECT[] ActNpc315_rcRight = new RECT[]{new RECT(128, 16, 144, 32), new RECT(160, 16, 176, 32), new RECT(176, 16, 192, 32), new RECT(192, 16, 208, 32)};
    private static final RECT[] ActNpc316_rcLeft = new RECT[]{new RECT(248, 32, 272, 56), new RECT(272, 32, 296, 56), new RECT(296, 32, 320, 56)};
    private static final RECT[] ActNpc316_rcRight = new RECT[]{new RECT(248, 56, 272, 80), new RECT(272, 56, 296, 80), new RECT(296, 56, 320, 80)};
    private static final RECT[] ActNpc317_rcLeft = new RECT[]{new RECT(0, 80, 32, 120), new RECT(32, 80, 64, 120), new RECT(64, 80, 96, 120), new RECT(96, 80, 128, 120)};
    private static final RECT[] ActNpc317_rcRight = new RECT[]{new RECT(0, 120, 32, 160), new RECT(32, 120, 64, 160), new RECT(64, 120, 96, 160), new RECT(96, 120, 128, 160)};
    private static final RECT[] ActNpc318_rcLeft = new RECT[]{new RECT(224, 80, 256, 120), new RECT(256, 80, 288, 120), new RECT(288, 80, 320, 120)};
    private static final RECT[] ActNpc318_rcRight = new RECT[]{new RECT(224, 120, 256, 160), new RECT(256, 120, 288, 160), new RECT(288, 120, 320, 160)};
    private static final RECT[] ActNpc319_rc = new RECT[]{new RECT(16, 0, 32, 16), new RECT(16, 0, 32, 16), new RECT(96, 80, 112, 96)};

    public static void ActNpc300(NpChar.NPCHAR npc) {
        if (npc.act_no == 0) {
            npc.act_no = 1;
            npc.y += 3072;
        }
        if (++npc.ani_wait % 8 == 1) {
            Caret.SetCaret(npc.x + Game.Random(-8, 8) * 512, npc.y + 4096, 13, 1);
        }
        npc.rect.copyFrom(ActNpc300_rc);
    }

    public static void ActNpc301(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
                npc.count1 = npc.direct;
            }
            case 1: {
                npc.xm = Triangle.GetCos((char)(npc.count1 & 0xFF)) * 2;
                npc.ym = Triangle.GetSin((char)(npc.count1 & 0xFF)) * 2;
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
        npc.rect.copyFrom(ActNpc301_rect[npc.ani_no]);
    }

    public static void ActNpc302(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 10: {
                npc.x = MyChar.gMC.x;
                npc.y = MyChar.gMC.y - 16384;
                break;
            }
            case 20: {
                switch (npc.direct) {
                    case 0: {
                        npc.x -= 1024;
                        break;
                    }
                    case 1: {
                        npc.y -= 1024;
                        break;
                    }
                    case 2: {
                        npc.x += 1024;
                        break;
                    }
                    case 3: {
                        npc.y += 1024;
                    }
                }
                MyChar.gMC.x = npc.x;
                MyChar.gMC.y = npc.y;
                break;
            }
            case 30: {
                npc.x = MyChar.gMC.x;
                npc.y = MyChar.gMC.y + 40960;
                break;
            }
            case 100: {
                npc.act_no = 101;
                if (npc.direct != 0) {
                    int n;
                    for (n = 170; n < NpChar.gNPC.length; ++n) {
                        if ((NpChar.gNPC[n].cond & 0x80) == 0 || NpChar.gNPC[n].code_event != npc.direct) continue;
                        npc.pNpc = NpChar.gNPC[n];
                        break;
                    }
                    if (n == NpChar.gNPC.length) {
                        npc.cond = 0;
                        break;
                    }
                } else {
                    npc.pNpc = Boss.gBoss[0];
                }
            }
            case 101: {
                npc.x = (MyChar.gMC.x + npc.pNpc.x) / 2;
                npc.y = (MyChar.gMC.y + npc.pNpc.y) / 2;
            }
        }
    }

    public static void ActNpc303(NpChar.NPCHAR npc) {
        if (npc.pNpc == null) {
            return;
        }
        if (npc.pNpc.direct == 0) {
            npc.direct = 0;
            npc.x = npc.pNpc.x - 4096;
        } else {
            npc.direct = 2;
            npc.x = npc.pNpc.x + 4096;
        }
        npc.y = npc.pNpc.y;
        npc.ani_no = 0;
        if (npc.pNpc.ani_no == 3 || npc.pNpc.ani_no == 5) {
            npc.y -= 512;
        }
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc303_rcLeft[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc303_rcRight[npc.ani_no]);
        }
    }

    public static void ActNpc304(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
                npc.y += 5120;
            }
            case 1: {
                npc.ani_no = 0;
                break;
            }
            case 10: {
                npc.ani_no = 1;
                break;
            }
            case 20: {
                npc.act_no = 21;
                npc.ani_no = 2;
            }
            case 21: {
                if (++npc.ani_wait > 10) {
                    npc.ani_wait = 0;
                    ++npc.ani_no;
                }
                if (npc.ani_no <= 3) break;
                npc.ani_no = 2;
            }
        }
        npc.rect.copyFrom(ActNpc304_rc[npc.ani_no]);
    }

    public static void ActNpc305(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
                npc.y -= 8192;
                npc.ani_wait = Game.Random(0, 6);
            }
            case 1: {
                if (++npc.ani_wait > 6) {
                    npc.ani_wait = 0;
                    ++npc.ani_no;
                }
                if (npc.ani_no <= 1) break;
                npc.ani_no = 0;
            }
        }
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc305_rcLeft[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc305_rcRight[npc.ani_no]);
        }
    }

    public static void ActNpc306(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
                npc.ani_no = 0;
                npc.ani_wait = 0;
                npc.y += 2048;
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
            npc.rect.copyFrom(ActNpc306_rcLeft[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc306_rcRight[npc.ani_no]);
        }
    }

    public static void ActNpc307(NpChar.NPCHAR npc) {
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
            }
        }
        npc.direct = MyChar.gMC.x < npc.x ? 0 : 2;
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc307_rcLeft[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc307_rcRight[npc.ani_no]);
        }
    }

    public static void ActNpc308(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
            }
            case 1: {
                if (MyChar.gMC.x >= npc.x + 122880 || MyChar.gMC.x <= npc.x - 122880 || MyChar.gMC.y >= npc.y + 98304 || MyChar.gMC.y <= npc.y - 98304) break;
                npc.act_no = 10;
                break;
            }
            case 10: {
                npc.act_no = 11;
                npc.act_wait = 0;
                npc.xm2 = 0;
                npc.ym2 = 0;
                npc.direct = npc.x > MyChar.gMC.x ? 0 : 2;
            }
            case 11: {
                if (++npc.act_wait > 50) {
                    npc.act_no = 20;
                }
                ++npc.ani_wait;
                if (npc.act_wait > 1) {
                    npc.ani_wait = 0;
                    if (++npc.ani_no > 1) {
                        npc.ani_no = 0;
                    }
                }
                if (MyChar.gMC.x <= npc.x + 163840 && MyChar.gMC.x >= npc.x - 163840 && MyChar.gMC.y <= npc.y + 122880 && MyChar.gMC.y >= npc.y - 122880) break;
                npc.act_no = 0;
                break;
            }
            case 20: {
                npc.act_no = 21;
                npc.act_wait = 0;
                char deg = (char)Triangle.GetArktan(npc.x - MyChar.gMC.x, npc.y - MyChar.gMC.y);
                deg = (char)(deg + (char)Game.Random(-3, 3) & 0xFF);
                npc.ym2 = Triangle.GetSin(deg) * 2;
                npc.xm2 = Triangle.GetCos(deg) * 2;
                npc.direct = npc.xm2 < 0 ? 0 : 2;
            }
            case 21: {
                if (npc.xm2 < 0 && (npc.flag & 1) != 0) {
                    npc.direct = 2;
                    npc.xm2 *= -1;
                }
                if (npc.xm2 > 0 && (npc.flag & 4) != 0) {
                    npc.direct = 0;
                    npc.xm2 *= -1;
                }
                if (npc.ym2 < 0 && (npc.flag & 2) != 0) {
                    npc.ym2 *= -1;
                }
                if (npc.ym2 > 0 && (npc.flag & 8) != 0) {
                    npc.ym2 *= -1;
                }
                if ((npc.flag & 0x100) != 0) {
                    npc.ym2 = -512;
                }
                npc.x += npc.xm2;
                npc.y += npc.ym2;
                if (++npc.act_wait > 50) {
                    npc.act_no = 10;
                }
                if (++npc.ani_no <= 1) break;
                npc.ani_no = 0;
            }
        }
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc308_rcLeft[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc308_rcRight[npc.ani_no]);
        }
    }

    public static void ActNpc309(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
            }
            case 1: {
                if (npc.direct == 0) {
                    if (MyChar.gMC.x > npc.x - 147456 && MyChar.gMC.x < npc.x - 139264) {
                        npc.act_no = 10;
                        break;
                    }
                } else if (MyChar.gMC.x < npc.x + 147456 && MyChar.gMC.x > npc.x + 139264) {
                    npc.act_no = 10;
                    break;
                }
                return;
            }
            case 10: {
                npc.act_no = 11;
                npc.bits = (char)(npc.bits | 0x20);
                npc.damage = 5;
            }
            case 11: {
                npc.direct = npc.x > MyChar.gMC.x ? 0 : 2;
                npc.xm2 = npc.direct == 0 ? (npc.xm2 -= 16) : (npc.xm2 += 16);
                npc.ym2 = npc.y > MyChar.gMC.y ? (npc.ym2 -= 16) : (npc.ym2 += 16);
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
                if (npc.xm2 < -1535) {
                    npc.xm2 = -1535;
                }
                if (npc.xm2 > 1535) {
                    npc.xm2 = 1535;
                }
                if (npc.ym2 < -1535) {
                    npc.ym2 = -1535;
                }
                if (npc.ym2 > 1535) {
                    npc.ym2 = 1535;
                }
                npc.x += npc.xm2;
                npc.y += npc.ym2;
                if (++npc.ani_wait > 1) {
                    npc.ani_wait = 0;
                    ++npc.ani_no;
                }
                if (npc.ani_no <= 1) break;
                npc.ani_no = 0;
            }
        }
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc309_rcLeft[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc309_rcRight[npc.ani_no]);
        }
        if (npc.life <= 996) {
            npc.code_char = 316;
            npc.act_no = 0;
        }
    }

    public static void ActNpc310(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
                npc.bits = (char)(npc.bits & 0xFFFFFFDF);
                npc.bits = (char)(npc.bits | 4);
                npc.damage = 0;
            }
            case 1: {
                npc.direct = npc.x > MyChar.gMC.x ? 0 : 2;
                npc.ani_no = 0;
                if (MyChar.gMC.x <= npc.x - 65536 || MyChar.gMC.x >= npc.x + 65536 || MyChar.gMC.y <= npc.y - 65536 || MyChar.gMC.y >= npc.y + 8192) break;
                npc.act_no = 10;
                break;
            }
            case 10: {
                npc.xm = 0;
                npc.act_no = 11;
                npc.act_wait = 0;
                npc.bits = (char)(npc.bits & 0xFFFFFFDF);
                npc.bits = (char)(npc.bits | 4);
                npc.damage = 0;
                npc.ani_no = 0;
            }
            case 11: {
                if (++npc.act_wait <= 30) break;
                npc.act_no = 20;
                break;
            }
            case 20: {
                npc.act_no = 21;
                npc.act_wait = 0;
                npc.bits = (char)(npc.bits & 0xFFFFFFFB);
                npc.bits = (char)(npc.bits | 0x20);
                npc.damage = 0;
                npc.direct = npc.x > MyChar.gMC.x ? 0 : 2;
            }
            case 21: {
                npc.xm = npc.direct == 0 ? -1024 : 1024;
                if (++npc.ani_wait > 3) {
                    npc.ani_wait = 0;
                    ++npc.ani_no;
                }
                if (npc.ani_no > 1) {
                    npc.ani_no = 0;
                }
                if (++npc.act_wait > 50) {
                    npc.act_no = 10;
                }
                if (npc.x >= MyChar.gMC.x + 20480 || npc.x <= MyChar.gMC.x - 20480) break;
                npc.ym = -768;
                npc.xm /= 2;
                npc.ani_no = 2;
                npc.act_no = 30;
                Sound.PlaySoundObject(30, 1);
                break;
            }
            case 30: {
                if (npc.ym <= -128) break;
                npc.act_no = 31;
                npc.ani_wait = 0;
                npc.ani_no = 3;
                npc.damage = 9;
                break;
            }
            case 31: {
                if (++npc.ani_wait > 2) {
                    npc.ani_wait = 0;
                    npc.ani_no = 4;
                }
                if ((npc.flag & 8) == 0) break;
                npc.act_no = 32;
                npc.act_wait = 0;
                npc.xm = 0;
                npc.damage = 3;
                break;
            }
            case 32: {
                if (++npc.act_wait <= 30) break;
                npc.act_no = 10;
                npc.damage = 0;
            }
        }
        npc.ym += 32;
        npc.x += npc.xm;
        npc.y += npc.ym;
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc310_rcLeft[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc310_rcRight[npc.ani_no]);
        }
        if (npc.life <= 996) {
            npc.code_char = 316;
            npc.act_no = 0;
        }
    }

    public static void ActNpc311(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
            }
            case 1: {
                if (npc.direct == 0) {
                    if (MyChar.gMC.x <= npc.x - 163840 || MyChar.gMC.x >= npc.x || MyChar.gMC.y <= npc.y - 81920 || MyChar.gMC.y >= npc.y + 81920) break;
                    npc.act_no = 10;
                    break;
                }
                if (MyChar.gMC.x <= npc.x || MyChar.gMC.x >= npc.x + 163840 || MyChar.gMC.y <= npc.y - 81920 || MyChar.gMC.y >= npc.y + 81920) break;
                npc.act_no = 10;
                break;
            }
            case 10: {
                npc.act_no = 11;
            }
            case 11: {
                npc.direct = npc.x > MyChar.gMC.x ? 0 : 2;
                if (MyChar.gMC.x > npc.x - 114688 && MyChar.gMC.x < npc.x + 114688 && MyChar.gMC.y > npc.y - 4096) {
                    npc.ani_no = 1;
                    npc.count1 = 0;
                } else {
                    npc.ani_no = 4;
                    npc.count1 = 1;
                }
                if (++npc.act_wait <= 10) break;
                npc.act_no = 20;
                break;
            }
            case 20: {
                npc.act_no = 21;
                npc.act_wait = 0;
            }
            case 21: {
                if (npc.count1 == 0) {
                    if (++npc.ani_no > 2) {
                        npc.ani_no = 1;
                    }
                } else if (++npc.ani_no > 5) {
                    npc.ani_no = 4;
                }
                if (++npc.act_wait <= 30) break;
                npc.act_no = 30;
                break;
            }
            case 30: {
                npc.act_no = 31;
                npc.act_wait = 0;
                if (npc.count1 == 0) {
                    if (npc.direct == 0) {
                        NpChar.SetNpChar(312, npc.x, npc.y, -1536, 0, 0, null, 256);
                    } else {
                        NpChar.SetNpChar(312, npc.x, npc.y, 1536, 0, 2, null, 256);
                    }
                    npc.ani_no = 3;
                } else {
                    if (npc.direct == 0) {
                        NpChar.SetNpChar(312, npc.x, npc.y, -1536, -1536, 0, null, 256);
                    } else {
                        NpChar.SetNpChar(312, npc.x, npc.y, 1536, -1536, 2, null, 256);
                    }
                    npc.ani_no = 6;
                }
            }
            case 31: {
                if (++npc.act_wait <= 30) break;
                npc.act_no = 40;
                npc.act_wait = Game.Random(0, 100);
                break;
            }
            case 40: {
                npc.ani_no = 0;
                if (++npc.act_wait > 150) {
                    npc.act_no = 10;
                }
                if (MyChar.gMC.x >= npc.x - 180224 && MyChar.gMC.x <= npc.x + 180224 && MyChar.gMC.y >= npc.y - 122880 && MyChar.gMC.y <= npc.y + 122880) break;
                npc.act_no = 40;
                npc.act_wait = 0;
            }
        }
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc311_rcLeft[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc311_rcRight[npc.ani_no]);
        }
        if (npc.life <= 992) {
            npc.code_char = 316;
            npc.act_no = 0;
        }
    }

    public static void ActNpc312(NpChar.NPCHAR npc) {
        if (npc.act_no > 0 && npc.act_no < 20 && (npc.flag & 0xFF) != 0) {
            npc.act_no = 20;
        }
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
                npc.act_wait = 0;
                npc.direct = npc.xm < 0 ? 0 : 2;
                npc.ani_no = npc.ym < 0 ? 0 : 2;
            }
            case 1: {
                ++npc.act_wait;
                if (npc.act_wait == 4) {
                    npc.bits = (char)(npc.bits & 0xFFFFFFF7);
                }
                if (npc.act_wait <= 10) break;
                npc.act_no = 10;
                break;
            }
            case 10: {
                npc.act_no = 11;
                npc.ani_wait = 0;
                npc.xm = 3 * npc.xm / 4;
                npc.ym = 3 * npc.ym / 4;
            }
            case 11: {
                npc.ym += 32;
                if (++npc.ani_wait > 10) {
                    npc.ani_wait = 0;
                    ++npc.ani_no;
                }
                if (npc.ani_no <= 4) break;
                npc.ani_no = 4;
                break;
            }
            case 20: {
                npc.act_no = 21;
                npc.act_wait = 0;
                npc.xm = 0;
                npc.ym = 0;
                npc.damage = 0;
            }
            case 21: {
                if (++npc.act_wait <= 30) break;
                npc.act_no = 30;
                break;
            }
            case 30: {
                npc.act_no = 31;
                npc.act_wait = 0;
            }
            case 31: {
                if (++npc.act_wait <= 30) break;
                npc.cond = 0;
                return;
            }
        }
        if (npc.ym > 1535) {
            npc.ym = 1535;
        }
        npc.x += npc.xm;
        npc.y += npc.ym;
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc312_rcLeft[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc312_rcRight[npc.ani_no]);
        }
        if (npc.act_no == 31 && npc.act_wait / 2 % 2 != 0) {
            npc.rect.left = 0;
            npc.rect.right = 0;
        }
    }

    public static void ActNpc313(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
                npc.ani_no = 0;
                npc.ani_wait = 0;
                npc.y += 2048;
            }
            case 1: {
                npc.ym += 64;
                if (Game.Random(0, 120) == 10) {
                    npc.act_no = 2;
                    npc.act_wait = 0;
                    npc.ani_no = 1;
                }
                if (npc.x - 16384 >= MyChar.gMC.x || npc.x + 16384 <= MyChar.gMC.x) break;
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
            case 100: {
                npc.act_no = 110;
                npc.act_wait = 0;
                npc.count1 = 0;
                npc.bits = (char)(npc.bits | 0x20);
            }
            case 110: {
                npc.damage = 1;
                npc.direct = npc.x > MyChar.gMC.x ? 0 : 2;
                npc.ani_no = 0;
                if (++npc.act_wait <= 4) break;
                npc.act_wait = 0;
                npc.act_no = 120;
                if (++npc.count2 <= 12) break;
                npc.count2 = 0;
                npc.act_no = 300;
                break;
            }
            case 120: {
                npc.ani_no = 2;
                if (++npc.act_wait <= 4) break;
                npc.act_no = 130;
                npc.ani_no = 3;
                npc.xm = 2 * Game.Random(-512, 512);
                npc.ym = -2048;
                Sound.PlaySoundObject(30, 1);
                ++npc.count1;
                break;
            }
            case 130: {
                npc.ym += 128;
                if (npc.y > 65536) {
                    npc.bits = (char)(npc.bits & 0xFFFFFFF7);
                }
                if (npc.xm < 0 && (npc.flag & 1) != 0) {
                    npc.xm *= -1;
                }
                if (npc.xm > 0 && (npc.flag & 4) != 0) {
                    npc.xm *= -1;
                }
                npc.direct = npc.x > MyChar.gMC.x ? 0 : 2;
                npc.ani_no = npc.ym < -512 ? 3 : (npc.ym > 512 ? 4 : 0);
                if ((npc.flag & 8) != 0) {
                    npc.act_no = 140;
                    npc.act_wait = 0;
                    npc.ani_no = 2;
                    npc.xm = 0;
                }
                if (npc.count1 <= 4 || MyChar.gMC.y >= npc.y + 2048) break;
                npc.act_no = 200;
                npc.act_wait = 0;
                npc.xm = 0;
                npc.ym = 0;
                break;
            }
            case 140: {
                npc.ani_no = 2;
                if (++npc.act_wait <= 4) break;
                npc.act_no = 110;
                break;
            }
            case 200: {
                npc.ani_no = 5;
                if (++npc.act_wait <= 10) break;
                npc.act_no = 210;
                npc.ani_no = 6;
                npc.xm = npc.direct == 0 ? -1535 : 1535;
                Sound.PlaySoundObject(25, 1);
                npc.bits = (char)(npc.bits & 0xFFFFFFDF);
                npc.bits = (char)(npc.bits | 4);
                npc.damage = 10;
                break;
            }
            case 210: {
                if (++npc.ani_no > 7) {
                    npc.ani_no = 6;
                }
                if (npc.xm < 0 && (npc.flag & 1) != 0) {
                    npc.act_no = 220;
                }
                if (npc.xm <= 0 || (npc.flag & 4) == 0) break;
                npc.act_no = 220;
                break;
            }
            case 220: {
                npc.act_no = 221;
                npc.act_wait = 0;
                Frame.SetQuake(16);
                Sound.PlaySoundObject(26, 1);
                npc.damage = 4;
            }
            case 221: {
                if (++npc.ani_no > 7) {
                    npc.ani_no = 6;
                }
                if (++npc.act_wait % 6 == 0) {
                    NpChar.SetNpChar(314, Game.Random(4, 16) * 512 * 16, 8192, 0, 0, 0, null, 256);
                }
                if (npc.act_wait <= 30) break;
                npc.count1 = 0;
                npc.act_no = 130;
                npc.bits = (char)(npc.bits | 0x20);
                npc.bits = (char)(npc.bits & 0xFFFFFFFB);
                npc.damage = 3;
                break;
            }
            case 300: {
                npc.act_no = 301;
                npc.ani_no = 9;
                npc.direct = npc.x > MyChar.gMC.x ? 0 : 2;
            }
            case 301: {
                if (++npc.ani_no > 11) {
                    npc.ani_no = 9;
                }
                npc.xm = npc.direct == 0 ? -1024 : 1024;
                if (MyChar.gMC.x <= npc.x - 2048 || MyChar.gMC.x >= npc.x + 2048) break;
                npc.act_no = 310;
                npc.act_wait = 0;
                npc.ani_no = 2;
                npc.xm = 0;
                break;
            }
            case 310: {
                npc.ani_no = 2;
                if (++npc.act_wait <= 4) break;
                npc.act_no = 320;
                npc.ani_no = 12;
                npc.ym = -2048;
                Sound.PlaySoundObject(25, 1);
                npc.bits = (char)(npc.bits | 8);
                npc.bits = (char)(npc.bits & 0xFFFFFFDF);
                npc.bits = (char)(npc.bits | 4);
                npc.damage = 10;
                break;
            }
            case 320: {
                if (++npc.ani_no > 13) {
                    npc.ani_no = 12;
                }
                if (npc.y >= 8192) break;
                npc.act_no = 330;
                break;
            }
            case 330: {
                npc.ym = 0;
                npc.act_no = 331;
                npc.act_wait = 0;
                Frame.SetQuake(16);
                Sound.PlaySoundObject(26, 1);
            }
            case 331: {
                if (++npc.ani_no > 13) {
                    npc.ani_no = 12;
                }
                if (++npc.act_wait % 6 == 0) {
                    NpChar.SetNpChar(315, Game.Random(4, 16) * 512 * 16, 0, 0, 0, 0, null, 256);
                }
                if (npc.act_wait <= 30) break;
                npc.count1 = 0;
                npc.act_no = 130;
                npc.bits = (char)(npc.bits | 0x20);
                npc.bits = (char)(npc.bits & 0xFFFFFFFB);
                npc.damage = 3;
                break;
            }
            case 500: {
                npc.bits = (char)(npc.bits & 0xFFFFFFDF);
                npc.act_no = 501;
                npc.act_wait = 0;
                npc.ani_no = 8;
                npc.tgt_x = npc.x;
                npc.damage = 0;
                NpChar.DeleteNpCharCode(315, true);
            }
            case 501: {
                npc.ym += 32;
                npc.x = ++npc.act_wait % 2 != 0 ? npc.tgt_x : npc.tgt_x + 512;
            }
        }
        if (npc.act_no > 100 && npc.act_no < 500 && npc.act_no != 210 && npc.act_no != 320) {
            if (Bullet.IsActiveSomeBullet()) {
                npc.bits = (char)(npc.bits & 0xFFFFFFDF);
                npc.bits = (char)(npc.bits | 4);
            } else {
                npc.bits = (char)(npc.bits | 0x20);
                npc.bits = (char)(npc.bits & 0xFFFFFFFB);
            }
        }
        if (npc.ym > 1535) {
            npc.ym = 1535;
        }
        npc.x += npc.xm;
        npc.y += npc.ym;
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc313_rcLeft[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc313_rcRight[npc.ani_no]);
        }
    }

    public static void ActNpc314(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.count2 = 0;
                npc.act_no = 100;
                npc.bits = (char)(npc.bits | 4);
                npc.ani_no = Game.Random(0, 2);
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
                Sound.PlaySoundObject(12, 1);
                Frame.SetQuake(10);
                for (int i = 0; i < 2; ++i) {
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
        if (++npc.ani_wait > 6) {
            ++npc.ani_wait;
            ++npc.ani_no;
        }
        if (npc.ani_no > 2) {
            npc.ani_no = 0;
        }
        npc.damage = MyChar.gMC.y > npc.y ? 10 : 0;
        npc.y += npc.ym;
        npc.rect.copyFrom(ActNpc314_rc[npc.ani_no]);
    }

    public static void ActNpc315(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.ani_no = 3;
                npc.ym += 128;
                if (npc.y <= 65536) break;
                npc.act_no = 130;
                npc.bits = (char)(npc.bits & 0xFFFFFFF7);
                break;
            }
            case 100: {
                npc.act_no = 110;
                npc.act_wait = 0;
                npc.count1 = 0;
                npc.bits = (char)(npc.bits | 0x20);
            }
            case 110: {
                npc.direct = npc.x > MyChar.gMC.x ? 0 : 2;
                npc.ani_no = 0;
                if (++npc.act_wait <= 4) break;
                npc.act_wait = 0;
                npc.act_no = 120;
                break;
            }
            case 120: {
                npc.ani_no = 1;
                if (++npc.act_wait <= 4) break;
                npc.act_no = 130;
                npc.ani_no = 3;
                npc.xm = 2 * Game.Random(-512, 512);
                npc.ym = -2048;
                Sound.PlaySoundObject(30, 1);
                break;
            }
            case 130: {
                npc.ym += 128;
                if (npc.xm < 0 && (npc.flag & 1) != 0) {
                    npc.xm *= -1;
                }
                if (npc.xm > 0 && (npc.flag & 4) != 0) {
                    npc.xm *= -1;
                }
                npc.direct = npc.x > MyChar.gMC.x ? 0 : 2;
                npc.ani_no = npc.ym < -512 ? 2 : (npc.ym > 512 ? 0 : 3);
                if ((npc.flag & 8) == 0) break;
                npc.act_no = 140;
                npc.act_wait = 0;
                npc.ani_no = 1;
                npc.xm = 0;
                break;
            }
            case 140: {
                npc.ani_no = 1;
                if (++npc.act_wait <= 4) break;
                npc.act_no = 110;
                npc.bits = (char)(npc.bits | 0x20);
            }
        }
        if (npc.act_no > 100) {
            if (Bullet.IsActiveSomeBullet()) {
                npc.bits = (char)(npc.bits & 0xFFFFFFDF);
                npc.bits = (char)(npc.bits | 4);
            } else {
                npc.bits = (char)(npc.bits | 0x20);
                npc.bits = (char)(npc.bits & 0xFFFFFFFB);
            }
        }
        if (++npc.count2 > 300) {
            NpChar.VanishNpChar(npc);
        } else {
            if (npc.ym > 1535) {
                npc.ym = 1535;
            }
            npc.x += npc.xm;
            npc.y += npc.ym;
            if (npc.direct == 0) {
                npc.rect.copyFrom(ActNpc315_rcLeft[npc.ani_no]);
            } else {
                npc.rect.copyFrom(ActNpc315_rcRight[npc.ani_no]);
            }
        }
    }

    public static void ActNpc316(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.bits = (char)(npc.bits & 0xFFFFFFDF);
                npc.bits = (char)(npc.bits & 0xFFFFFFF7);
                npc.damage = 0;
                npc.act_no = 1;
                npc.ani_no = 0;
                npc.view.front = 6144;
                npc.view.back = 6144;
                npc.view.top = 6144;
                npc.ym = -512;
                npc.xm = npc.direct == 0 ? 256 : -256;
                Sound.PlaySoundObject(50, 1);
                break;
            }
            case 1: {
                if ((npc.flag & 8) == 0) break;
                npc.ani_no = 1;
                npc.ani_wait = 0;
                npc.act_no = 2;
                npc.act_wait = 0;
                break;
            }
            case 2: {
                npc.xm = 8 * npc.xm / 9;
                if (++npc.ani_wait > 3) {
                    npc.ani_wait = 0;
                    ++npc.ani_no;
                }
                if (npc.ani_no > 2) {
                    npc.ani_no = 1;
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
            npc.rect.copyFrom(ActNpc316_rcLeft[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc316_rcRight[npc.ani_no]);
        }
    }

    public static void ActNpc317(NpChar.NPCHAR npc) {
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
                npc.count1 = 0;
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
                if (MyChar.gMC.x <= npc.x - 163840 || MyChar.gMC.x >= npc.x + 163840 || MyChar.gMC.y <= npc.y - 81920 || MyChar.gMC.y >= npc.y + 81920 || ++npc.count1 <= 50) break;
                npc.act_no = 10;
                break;
            }
            case 10: {
                npc.act_no = 11;
                npc.act_wait = 0;
                npc.ani_no = 2;
                NpChar.SetNpChar(319, npc.x, npc.y, 0, 0, 0, npc, 256);
            }
            case 11: {
                if (++npc.act_wait <= 50) break;
                npc.act_wait = 0;
                npc.act_no = 12;
                npc.ani_no = 3;
                Sound.PlaySoundObject(39, 1);
                break;
            }
            case 12: {
                if (++npc.act_wait <= 20) break;
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
            npc.rect.copyFrom(ActNpc317_rcLeft[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc317_rcRight[npc.ani_no]);
        }
        if (npc.life <= 936) {
            npc.code_char = 318;
            npc.act_no = 0;
        }
    }

    public static void ActNpc318(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.bits = (char)(npc.bits & 0xFFFFFFDF);
                npc.bits = (char)(npc.bits & 0xFFFFFFF7);
                npc.bits = (char)(npc.bits & 0xFFFFFFFE);
                npc.damage = 0;
                npc.act_no = 1;
                npc.ani_no = 0;
                npc.ym = -512;
                npc.xm = npc.direct == 0 ? 64 : -64;
                Sound.PlaySoundObject(54, 1);
                break;
            }
            case 1: {
                if ((npc.flag & 8) == 0) break;
                npc.ani_no = 1;
                npc.ani_wait = 0;
                npc.act_no = 2;
                npc.act_wait = 0;
                break;
            }
            case 2: {
                npc.xm = 8 * npc.xm / 9;
                if (++npc.ani_wait > 3) {
                    npc.ani_wait = 0;
                    ++npc.ani_no;
                }
                if (npc.ani_no > 2) {
                    npc.ani_no = 1;
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
            npc.rect.copyFrom(ActNpc318_rcLeft[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc318_rcRight[npc.ani_no]);
        }
    }

    public static void ActNpc319(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.y = npc.pNpc.y + 5120;
                npc.x = npc.pNpc.direct == 0 ? npc.pNpc.x + 3584 : npc.pNpc.x - 3584;
                if (npc.pNpc.code_char == 318) {
                    NpChar.SetDestroyNpChar(npc.x, npc.y, 0, 3);
                    npc.cond = 0;
                    return;
                }
                if (npc.pNpc.ani_no == 2) break;
                npc.act_no = 2;
                npc.act_wait = 0;
                npc.ym = -1024;
                npc.y = npc.pNpc.y - 2048;
                if (npc.pNpc.direct == 0) {
                    npc.xm = -1024;
                    break;
                }
                npc.xm = 1024;
                break;
            }
            case 2: {
                if (++npc.act_wait == 4) {
                    npc.bits = (char)(npc.bits & 0xFFFFFFF7);
                }
                npc.ym += 42;
                if (npc.ym > 1535) {
                    npc.ym = 1535;
                }
                npc.x += npc.xm;
                npc.y += npc.ym;
                if ((npc.flag & 8) == 0) break;
                Sound.PlaySoundObject(12, 1);
                NpChar.SetDestroyNpChar(npc.x, npc.y, 0, 3);
                npc.cond = 0;
            }
        }
        if (++npc.ani_no > 2) {
            npc.ani_no = 0;
        }
        npc.rect.copyFrom(ActNpc319_rc[npc.ani_no]);
    }
}
