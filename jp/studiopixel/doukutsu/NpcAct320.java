/*
 * Decompiled with CFR 0.152.
 */
package jp.studiopixel.doukutsu;

import jp.studiopixel.doukutsu.Bullet;
import jp.studiopixel.doukutsu.Caret;
import jp.studiopixel.doukutsu.Frame;
import jp.studiopixel.doukutsu.Game;
import jp.studiopixel.doukutsu.KeyControl;
import jp.studiopixel.doukutsu.Map;
import jp.studiopixel.doukutsu.MyChar;
import jp.studiopixel.doukutsu.NpChar;
import jp.studiopixel.doukutsu.RECT;
import jp.studiopixel.doukutsu.Sound;

public class NpcAct320 {
    private static final RECT[] ActNpc320_rcLeft = new RECT[]{new RECT(16, 96, 32, 112), new RECT(48, 96, 64, 112), new RECT(96, 96, 112, 112)};
    private static final RECT[] ActNpc320_rcRight = new RECT[]{new RECT(16, 112, 32, 128), new RECT(48, 112, 64, 128), new RECT(96, 112, 112, 128)};
    private static final RECT[] ActNpc321_rcLeft = new RECT[]{new RECT(136, 152, 152, 168), new RECT(152, 152, 168, 168), new RECT(168, 152, 184, 168)};
    private static final RECT[] ActNpc321_rcRight = new RECT[]{new RECT(136, 168, 152, 184), new RECT(152, 168, 168, 184), new RECT(168, 168, 184, 184)};
    private static final RECT[] ActNpc322_rc = new RECT[]{new RECT(272, 216, 296, 240), new RECT(296, 216, 320, 240), new RECT(160, 216, 184, 240)};
    private static final RECT[] ActNpc323_rc = new RECT[]{new RECT(216, 32, 232, 56), new RECT(232, 32, 248, 56), new RECT(216, 56, 232, 80), new RECT(232, 56, 248, 80)};
    private static final RECT[] ActNpc325_rc = new RECT[]{new RECT(240, 96, 272, 128), new RECT(272, 96, 304, 128), new RECT(240, 128, 272, 160), new RECT(240, 0, 256, 96), new RECT(256, 0, 272, 96), new RECT(272, 0, 288, 96), new RECT(288, 0, 304, 96)};
    private static final RECT[] ActNpc326_rcItoh = new RECT[]{new RECT(0, 128, 16, 152), new RECT(16, 128, 32, 152), new RECT(32, 128, 48, 152), new RECT(48, 128, 64, 152), new RECT(64, 128, 80, 152), new RECT(80, 128, 96, 152), new RECT(96, 128, 112, 152), new RECT(112, 128, 128, 152)};
    private static final RECT[] ActNpc326_rcSu = new RECT[]{new RECT(128, 128, 144, 152), new RECT(144, 128, 160, 152), new RECT(160, 128, 176, 152), new RECT(176, 128, 192, 152), new RECT(192, 128, 208, 152), new RECT(208, 128, 224, 152), new RECT(224, 128, 240, 152), new RECT(32, 152, 48, 176)};
    private static final RECT[] ActNpc327_rc = new RECT[]{new RECT(240, 80, 256, 96), new RECT(256, 80, 272, 96)};
    private static final RECT ActNpc328_rc = new RECT(96, 0, 128, 48);
    private static final RECT[] ActNpc329_rc = new RECT[]{new RECT(48, 0, 64, 16), new RECT(64, 0, 80, 16)};
    private static final RECT[] ActNpc330_rc = new RECT[]{new RECT(144, 136, 160, 152), new RECT(160, 136, 176, 152), new RECT(176, 136, 192, 152)};
    private static final RECT[] ActNpc331_rc = new RECT[]{new RECT(288, 80, 304, 96), new RECT(304, 80, 320, 96), new RECT(288, 96, 304, 112), new RECT(304, 96, 320, 112)};
    private static final RECT[] ActNpc332_rc = new RECT[]{new RECT(144, 96, 168, 120), new RECT(168, 96, 192, 120), new RECT(192, 96, 216, 120)};
    private static final RECT[] ActNpc333_rc = new RECT[]{new RECT(80, 120, 104, 144), new RECT(104, 120, 128, 144)};
    private static final RECT[] ActNpc334_rcLeft = new RECT[]{new RECT(160, 184, 168, 200), new RECT(168, 184, 176, 200)};
    private static final RECT[] ActNpc334_rcRight = new RECT[]{new RECT(176, 184, 184, 200), new RECT(184, 184, 192, 200)};
    private static final RECT[] ActNpc335_rc = new RECT[]{new RECT(0, 16, 16, 32), new RECT(16, 16, 32, 32), new RECT(32, 16, 48, 32)};
    private static final RECT[] ActNpc337_rcLeft = new RECT[]{new RECT(256, 112, 288, 152), new RECT(288, 112, 320, 152)};
    private static final RECT[] ActNpc338_rcLeft = new RECT[]{new RECT(288, 0, 304, 16), new RECT(304, 0, 320, 16)};
    private static final RECT[] ActNpc338_rcRight = new RECT[]{new RECT(288, 16, 304, 32), new RECT(304, 16, 320, 32)};

    public static void ActNpc320(NpChar.NPCHAR npc) {
        if (npc.act_no == 0) {
            npc.act_no = 1;
            npc.x = MyChar.gMC.x;
            npc.y = MyChar.gMC.y;
            NpChar.SetNpChar(321, 0, 0, 0, 0, 0, npc, 256);
        }
        if ((MyChar.gMC.flag & 8) != 0) {
            if (MyChar.gMC.up) {
                npc.tgt_x = MyChar.gMC.x;
                npc.tgt_y = MyChar.gMC.y - 5120;
                npc.ani_no = 1;
            } else {
                npc.ani_no = 0;
                if (MyChar.gMC.direct == 0) {
                    npc.tgt_x = MyChar.gMC.x + 3584;
                    npc.tgt_y = MyChar.gMC.y - 1536;
                } else {
                    npc.tgt_x = MyChar.gMC.x - 3584;
                    npc.tgt_y = MyChar.gMC.y - 1536;
                }
            }
        } else if (MyChar.gMC.up) {
            npc.tgt_x = MyChar.gMC.x;
            npc.tgt_y = MyChar.gMC.y + 4096;
            npc.ani_no = 2;
        } else if (MyChar.gMC.down) {
            npc.tgt_x = MyChar.gMC.x;
            npc.tgt_y = MyChar.gMC.y - 4096;
            npc.ani_no = 1;
        } else {
            npc.ani_no = 0;
            if (MyChar.gMC.direct == 0) {
                npc.tgt_x = MyChar.gMC.x + 3584;
                npc.tgt_y = MyChar.gMC.y - 1536;
            } else {
                npc.tgt_x = MyChar.gMC.x - 3584;
                npc.tgt_y = MyChar.gMC.y - 1536;
            }
        }
        npc.x += (npc.tgt_x - npc.x) / 2;
        npc.y += (npc.tgt_y - npc.y) / 2;
        if (MyChar.gMC.ani_no % 2 != 0) {
            npc.y -= 512;
        }
        if (MyChar.gMC.direct == 0) {
            npc.rect.copyFrom(ActNpc320_rcRight[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc320_rcLeft[npc.ani_no]);
        }
    }

    public static void ActNpc321(NpChar.NPCHAR npc) {
        int direct = 0;
        if (npc.pNpc == null) {
            return;
        }
        switch (npc.pNpc.ani_no) {
            case 0: {
                if (MyChar.gMC.direct == 0) {
                    npc.x = npc.pNpc.x + 4096;
                    direct = 2;
                } else {
                    npc.x = npc.pNpc.x - 4096;
                    direct = 0;
                }
                npc.y = npc.pNpc.y;
                break;
            }
            case 1: {
                npc.x = MyChar.gMC.direct == 0 ? npc.pNpc.x : npc.pNpc.x;
                direct = 1;
                npc.y = npc.pNpc.y - 5120;
                break;
            }
            case 2: {
                npc.x = MyChar.gMC.direct == 0 ? npc.pNpc.x : npc.pNpc.x;
                direct = 3;
                npc.y = npc.pNpc.y + 5120;
            }
        }
        npc.ani_no = npc.pNpc.ani_no;
        if ((Game.g_GameFlags & 2) != 0 && Bullet.CountBulletNum(43) < 2 && (KeyControl.gKeyTrg & KeyControl.gKeyShot) != 0) {
            Bullet.SetBullet(43, npc.pNpc.x, npc.pNpc.y, direct);
            Caret.SetCaret(npc.pNpc.x, npc.pNpc.y, 3, 0);
            Sound.PlaySoundObject(117, 1);
        }
        if (MyChar.gMC.direct == 0) {
            npc.rect.copyFrom(ActNpc321_rcRight[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc321_rcLeft[npc.ani_no]);
        }
    }

    public static void ActNpc322(NpChar.NPCHAR npc) {
        if (npc.act_no < 2 && npc.life <= 968) {
            npc.act_no = 2;
            npc.act_wait = 0;
            npc.bits = (char)(npc.bits & 0xFFFFFFDF);
            npc.bits = (char)(npc.bits | 4);
            Sound.PlaySoundObject(22, 1);
        }
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
                if (npc.direct == 0) {
                    npc.y += 4096;
                } else {
                    npc.x += 4096;
                }
            }
            case 1: {
                npc.count1 = npc.shock != '\u0000' ? ++npc.count1 : 0;
                npc.rect.copyFrom(ActNpc322_rc[npc.count1 / 2 % 2]);
                break;
            }
            case 2: {
                npc.ani_no = 2;
                switch (npc.act_wait) {
                    case 0: {
                        NpChar.SetNpChar(207, npc.x + 2048, npc.y, 0, 0, 0, null, 384);
                        break;
                    }
                    case 50: {
                        NpChar.SetNpChar(207, npc.x + 2048, npc.y, 0, 0, 1, null, 384);
                        break;
                    }
                    case 100: {
                        NpChar.SetNpChar(207, npc.x + 2048, npc.y, 0, 0, 2, null, 384);
                        break;
                    }
                    case 150: {
                        NpChar.SetNpChar(207, npc.x + 2048, npc.y, 0, 0, 3, null, 384);
                        break;
                    }
                    case 200: {
                        NpChar.SetNpChar(207, npc.x + 2048, npc.y, 0, 0, 4, null, 384);
                        break;
                    }
                    case 250: {
                        npc.hit.back = 24576;
                        npc.hit.front = 24576;
                        npc.hit.top = 24576;
                        npc.hit.bottom = 24576;
                        npc.damage = 12;
                        Sound.PlaySoundObject(26, 1);
                        NpChar.SetDestroyNpChar(npc.x, npc.y, 24576, 40);
                        Frame.SetQuake(10);
                        if (npc.direct == 0) {
                            Map.DeleteMapParts(npc.x / 512 / 16, (npc.y - 4096) / 512 / 16);
                            Map.DeleteMapParts(npc.x / 512 / 16, (npc.y + 4096) / 512 / 16);
                        } else {
                            Map.DeleteMapParts((npc.x - 4096) / 512 / 16, npc.y / 512 / 16);
                            Map.DeleteMapParts((npc.x + 4096) / 512 / 16, npc.y / 512 / 16);
                        }
                        npc.cond = (byte)(npc.cond | 8);
                    }
                }
                ++npc.act_wait;
                npc.rect.copyFrom(ActNpc322_rc[2]);
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public static void ActNpc323(NpChar.NPCHAR npc) {
        if (++npc.ani_wait > 3) {
            npc.ani_wait = 0;
            if (++npc.ani_no > 3) {
                npc.ani_no = 0;
            }
        }
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
                switch (npc.direct) {
                    case 0: {
                        npc.xm = -1536;
                        break;
                    }
                    case 2: {
                        npc.xm = 1536;
                        break;
                    }
                    case 1: {
                        npc.ym = -1536;
                        break;
                    }
                    case 3: {
                        npc.ym = 1536;
                        break;
                    }
                }
            }
            case 1: {
                if (++npc.act_wait == 16) {
                    npc.bits = (char)(npc.bits & 0xFFFFFFF7);
                }
                npc.x += npc.xm;
                npc.y += npc.ym;
                if ((npc.flag & 0xFF) != 0) {
                    npc.act_no = 10;
                }
                if (npc.act_wait <= 20) break;
                switch (npc.direct) {
                    case 0: {
                        if (npc.x > MyChar.gMC.x + 16384) break;
                        npc.act_no = 10;
                        break;
                    }
                    case 2: {
                        if (npc.x < MyChar.gMC.x - 16384) break;
                        npc.act_no = 10;
                        break;
                    }
                    case 1: {
                        if (npc.y > MyChar.gMC.y + 16384) break;
                        npc.act_no = 10;
                        break;
                    }
                    case 3: {
                        if (npc.y < MyChar.gMC.y - 16384) break;
                        npc.act_no = 10;
                    }
                }
                break;
            }
        }
        if (npc.act_no == 10) {
            npc.code_char = 309;
            npc.ani_no = 0;
            npc.act_no = 11;
            npc.bits = (char)(npc.bits | 0x20);
            npc.bits = (char)(npc.bits & 0xFFFFFFF7);
            npc.damage = 5;
            npc.view.top = 4096;
        }
        npc.rect.copyFrom(ActNpc323_rc[npc.ani_no]);
    }

    public static void ActNpc324(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 10: {
                npc.act_no = 11;
                npc.act_wait = 0;
            }
            case 11: {
                if (++npc.act_wait % 50 == 1) {
                    NpChar.SetNpChar(323, npc.x, npc.y, 0, 0, npc.direct, null, 256);
                }
                if (npc.act_wait <= 351) break;
                npc.act_no = 0;
            }
        }
    }

    public static void ActNpc325(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
                Sound.PlaySoundObject(29, 1);
            }
            case 1: {
                if (++npc.ani_wait > 0) {
                    npc.ani_wait = 0;
                    ++npc.ani_no;
                }
                if (npc.ani_no > 2) {
                    npc.ani_no = 0;
                }
                if (++npc.act_wait <= 50) break;
                npc.act_no = 10;
                npc.ani_wait = 0;
                npc.ani_no = 3;
                npc.damage = 10;
                npc.view.front = 4096;
                npc.view.top = 6144;
                Sound.PlaySoundObject(101, 1);
                NpChar.SetDestroyNpChar(npc.x, npc.y + 43008, 0, 3);
                break;
            }
            case 10: {
                if (++npc.ani_wait > 2) {
                    npc.ani_wait = 0;
                    ++npc.ani_no;
                }
                if (npc.ani_no <= 6) break;
                npc.cond = 0;
                return;
            }
        }
        npc.rect.copyFrom(ActNpc325_rc[npc.ani_no]);
    }

    public static void ActNpc326(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
                npc.y -= 4096;
                npc.x += 8192;
                npc.ani_no = 0;
            }
            case 1: {
                if (++npc.act_wait > 80) {
                    npc.act_no = 10;
                    npc.act_wait = 0;
                    break;
                }
                if (npc.direct == 0) {
                    if (npc.act_wait == 30) {
                        npc.ani_no = 1;
                    }
                    if (npc.act_wait != 40) break;
                    npc.ani_no = 0;
                    break;
                }
                if (npc.act_wait == 50) {
                    npc.ani_no = 1;
                }
                if (npc.act_wait != 60) break;
                npc.ani_no = 0;
                break;
            }
            case 10: {
                if (++npc.act_wait > 50) {
                    npc.act_no = 15;
                    npc.ani_no = 4;
                    if (npc.direct == 0) {
                        npc.act_wait = 0;
                        break;
                    }
                    npc.act_wait = -20;
                    break;
                }
                if (npc.act_wait / 2 % 2 != 0) {
                    npc.ani_no = 2;
                    break;
                }
                npc.ani_no = 3;
                break;
            }
            case 15: {
                if (++npc.act_wait <= 40) break;
                npc.act_wait = 0;
                npc.act_no = 20;
                break;
            }
            case 20: {
                npc.ym += 64;
                if (npc.ym > 1535) {
                    npc.ym = 1535;
                }
                npc.y += npc.ym;
                if (++npc.act_wait <= 50) break;
                npc.act_no = 30;
                npc.act_wait = 0;
                npc.ani_no = 6;
                if (npc.direct == 0) {
                    NpChar.SetNpChar(327, npc.x, npc.y - 8192, 0, 0, 0, npc, 256);
                    break;
                }
                NpChar.SetNpChar(327, npc.x, npc.y - 4096, 0, 0, 0, npc, 256);
                break;
            }
            case 30: {
                if (++npc.act_wait == 30) {
                    npc.ani_no = 7;
                }
                if (npc.act_wait != 40) break;
                npc.act_no = 40;
                break;
            }
            case 40: {
                npc.act_no = 41;
                npc.act_wait = 0;
                npc.ani_no = 0;
            }
            case 41: {
                if (++npc.act_wait == 30) {
                    npc.ani_no = 1;
                }
                if (npc.act_wait != 40) break;
                npc.ani_no = 0;
            }
        }
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc326_rcItoh[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc326_rcSu[npc.ani_no]);
        }
    }

    public static void ActNpc327(NpChar.NPCHAR npc) {
        ++npc.act_wait;
        switch (npc.act_no) {
            case 0: {
                if (npc.act_wait < 4) {
                    npc.y -= 1024;
                }
                if (npc.pNpc.ani_no != 7) break;
                npc.ani_no = 1;
                npc.act_no = 1;
                npc.tgt_x = npc.x;
                npc.tgt_y = npc.y;
                break;
            }
            case 1: {
                if (npc.act_wait < 48) {
                    npc.x = npc.tgt_x + Game.Random(-1, 1) * 512;
                    npc.y = npc.tgt_y + Game.Random(-1, 1) * 512;
                    break;
                }
                npc.x = npc.tgt_x;
                npc.y = npc.tgt_y;
            }
        }
        if (npc.act_wait > 70) {
            npc.cond = 0;
        }
        npc.rect.copyFrom(ActNpc327_rc[npc.ani_no]);
    }

    public static void ActNpc328(NpChar.NPCHAR npc) {
        npc.rect.copyFrom(ActNpc328_rc);
    }

    public static void ActNpc329(NpChar.NPCHAR npc) {
        if (++npc.ani_wait / 2 % 2 != 0) {
            npc.rect.copyFrom(ActNpc329_rc[0]);
        } else {
            npc.rect.copyFrom(ActNpc329_rc[1]);
        }
    }

    public static void ActNpc330(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                Map.ChangeMapParts(npc.x / 512 / 16, npc.y / 512 / 16, (byte)0);
                if (npc.direct == 0) {
                    npc.act_no = 10;
                    break;
                }
                npc.act_no = 30;
                break;
            }
            case 10: {
                npc.xm -= 64;
                npc.ym = 0;
                if ((npc.flag & 1) == 0) break;
                npc.act_no = 20;
                break;
            }
            case 20: {
                npc.xm = 0;
                npc.ym -= 64;
                if ((npc.flag & 2) == 0) break;
                npc.act_no = 30;
                break;
            }
            case 30: {
                npc.xm += 64;
                npc.ym = 0;
                if ((npc.flag & 4) == 0) break;
                npc.act_no = 40;
                break;
            }
            case 40: {
                npc.xm = 0;
                npc.ym += 64;
                if ((npc.flag & 8) == 0) break;
                npc.act_no = 10;
            }
        }
        if (npc.xm < -1024) {
            npc.xm = -1024;
        }
        if (npc.xm > 1024) {
            npc.xm = 1024;
        }
        if (npc.ym < -1024) {
            npc.ym = -1024;
        }
        if (npc.ym > 1024) {
            npc.ym = 1024;
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
        npc.rect.copyFrom(ActNpc330_rc[npc.ani_no]);
    }

    public static void ActNpc331(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
            }
            case 1: {
                if ((npc.flag & 8) == 0) break;
                npc.ym = -512;
                npc.act_no = 10;
                break;
            }
            case 10: {
                if ((npc.flag & 8) == 0) break;
                npc.cond = 0;
                Caret.SetCaret(npc.x, npc.y, 2, 0);
            }
        }
        npc.ym += 64;
        if (npc.ym > 1535) {
            npc.ym = 1535;
        }
        npc.y += npc.ym;
        npc.x += npc.xm;
        if (++npc.ani_wait > 3) {
            npc.ani_wait = 0;
            npc.ani_no = npc.direct == 0 ? ++npc.ani_no : --npc.ani_no;
            if (npc.ani_no < 0) {
                npc.ani_no += 4;
            }
            if (npc.ani_no > 3) {
                npc.ani_no -= 4;
            }
        }
        npc.rect.copyFrom(ActNpc331_rc[npc.ani_no]);
    }

    public static void ActNpc332(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                Sound.PlaySoundObject(44, 1);
                npc.act_no = 1;
                npc.xm = npc.direct == 0 ? -1024 : 1024;
            }
            case 1: {
                if (++npc.ani_wait > 1) {
                    npc.ani_wait = 0;
                    if (++npc.ani_no > 2) {
                        npc.ani_no = 0;
                    }
                }
                if (++npc.act_wait % 6 != 1) break;
                int xm = npc.direct == 0 ? Game.Random(-16, -4) * 512 / 8 : Game.Random(4, 16) * 512 / 8;
                NpChar.SetNpChar(331, npc.x, npc.y, xm, -1024, 0, null, 256);
                Sound.PlaySoundObject(12, 1);
            }
        }
        if ((npc.flag & 1) != 0) {
            npc.cond = 0;
        }
        if ((npc.flag & 4) != 0) {
            npc.cond = 0;
        }
        npc.x += npc.xm;
        npc.rect.copyFrom(ActNpc332_rc[npc.ani_no]);
    }

    public static void ActNpc333(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
                npc.tgt_x = npc.x;
                npc.tgt_y = npc.y;
                Sound.PlaySoundObject(103, 1);
                npc.y = MyChar.gMC.y;
            }
            case 1: {
                npc.ani_no = ++npc.act_wait / 2 % 2 != 0 ? 0 : 1;
                if (npc.direct == 0 && npc.act_wait == 20) {
                    NpChar.SetNpChar(146, npc.tgt_x, npc.tgt_y, 0, 0, 0, null, 256);
                }
                if (npc.act_wait <= 40) break;
                npc.cond = 0;
            }
        }
        npc.rect.copyFrom(ActNpc333_rc[npc.ani_no]);
    }

    public static void ActNpc334(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 10;
                if (npc.direct == 0) {
                    npc.x += 5120;
                    npc.y -= 9216;
                } else {
                    npc.x = MyChar.gMC.x - 5120;
                    npc.y = MyChar.gMC.y - 1024;
                }
            }
            case 10: {
                npc.ani_no = ++npc.act_wait / 8 % 2 != 0 ? 0 : 1;
                if (npc.act_wait < 64) break;
                npc.cond = 0;
            }
        }
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc334_rcLeft[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc334_rcRight[npc.ani_no]);
        }
    }

    public static void ActNpc335(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
                npc.act_wait = Game.Random(3, 20);
            }
            case 1: {
                if (--npc.act_wait > 0) break;
                npc.act_no = 2;
                npc.act_wait = Game.Random(10, 50);
                npc.ani_no = 1;
                npc.xm = 1536;
                break;
            }
            case 2: {
                if (--npc.act_wait > 0) break;
                npc.act_no = 3;
                npc.act_wait = Game.Random(40, 50);
                npc.ani_no = 2;
                npc.ym = Game.Random(-256, 256);
                break;
            }
            case 3: {
                if (--npc.act_wait > 0) break;
                npc.act_no = 1;
                npc.act_wait = 0;
                npc.ani_no = 0;
            }
        }
        npc.xm -= 16;
        npc.x += npc.xm;
        npc.y += npc.ym;
        npc.rect.copyFrom(ActNpc335_rc[npc.ani_no]);
    }

    public static void ActNpc336(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                if (MyChar.gMC.shock == '\u0000') break;
                npc.cond = 0;
                break;
            }
            case 10: {
                if (++npc.act_wait % 4 != 1) break;
                int y = npc.y + Game.Random(0, 13) * 512 * 16;
                NpChar.SetNpChar(335, npc.x, y, 0, 0, 0, null, 0);
            }
        }
    }

    public static void ActNpc337(NpChar.NPCHAR npc) {
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
                if (++npc.ani_wait > 50) {
                    npc.ani_wait = 0;
                    ++npc.ani_no;
                }
                if (npc.ani_no <= 1) break;
                npc.ani_no = 0;
            }
        }
        npc.ym += 64;
        if (npc.ym > 1535) {
            npc.ym = 1535;
        }
        npc.x += npc.xm;
        npc.y += npc.ym;
        npc.rect.copyFrom(ActNpc337_rcLeft[npc.ani_no]);
    }

    public static void ActNpc338(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
                npc.view.top = 4096;
                npc.view.bottom = 4096;
                npc.damage = 3;
                npc.bits = (char)(npc.bits | 0x20);
                npc.tgt_y = npc.y;
                npc.ym = Game.Random(-10, 10) * 512 / 2;
            }
            case 1: {
                if (++npc.ani_wait > 2) {
                    npc.ani_wait = 0;
                    ++npc.ani_no;
                }
                if (npc.ani_no > 1) {
                    npc.ani_no = 0;
                }
                npc.ym = npc.y < npc.tgt_y ? (npc.ym += 128) : (npc.ym -= 128);
                npc.xm = npc.direct == 0 ? (npc.xm -= 32) : (npc.xm += 32);
                if (npc.xm > 1024) {
                    npc.xm = 1024;
                }
                if (npc.xm < -1024) {
                    npc.xm = -1024;
                }
                if (npc.x >= 0 && npc.y >= 0 && npc.x <= Map.gMap.width * 512 * 16 && npc.y <= Map.gMap.length * 512 * 16) break;
                NpChar.VanishNpChar(npc);
                return;
            }
        }
        npc.x += npc.xm;
        npc.y += npc.ym;
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc338_rcLeft[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc338_rcRight[npc.ani_no]);
        }
    }

    public static void ActNpc339(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
                npc.act_wait = Game.Random(0, 40);
            }
            case 1: {
                if (npc.act_wait != 0) {
                    --npc.act_wait;
                    break;
                }
                npc.act_no = 0;
                NpChar.SetNpChar(338, npc.x, npc.y + Game.Random(-16, 16) * 512, 0, 0, npc.direct, null, 256);
            }
        }
    }
}
