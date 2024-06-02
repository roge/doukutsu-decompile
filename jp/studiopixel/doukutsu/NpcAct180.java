/*
 * Decompiled with CFR 0.152.
 */
package jp.studiopixel.doukutsu;

import jp.studiopixel.doukutsu.Back;
import jp.studiopixel.doukutsu.Bullet;
import jp.studiopixel.doukutsu.Caret;
import jp.studiopixel.doukutsu.Flags;
import jp.studiopixel.doukutsu.Frame;
import jp.studiopixel.doukutsu.Game;
import jp.studiopixel.doukutsu.MyChar;
import jp.studiopixel.doukutsu.NpChar;
import jp.studiopixel.doukutsu.NpcHit;
import jp.studiopixel.doukutsu.RECT;
import jp.studiopixel.doukutsu.Sound;
import jp.studiopixel.doukutsu.Triangle;

public class NpcAct180 {
    private static final RECT[] ActNpc180_rcLeft = new RECT[]{new RECT(0, 96, 16, 112), new RECT(16, 96, 32, 112), new RECT(0, 96, 16, 112), new RECT(32, 96, 48, 112), new RECT(0, 96, 16, 112), new RECT(48, 96, 64, 112), new RECT(64, 96, 80, 112), new RECT(48, 96, 64, 112), new RECT(80, 96, 96, 112), new RECT(48, 96, 64, 112), new RECT(144, 96, 160, 112)};
    private static final RECT[] ActNpc180_rcRight = new RECT[]{new RECT(0, 112, 16, 128), new RECT(16, 112, 32, 128), new RECT(0, 112, 16, 128), new RECT(32, 112, 48, 128), new RECT(0, 112, 16, 128), new RECT(48, 112, 64, 128), new RECT(64, 112, 80, 128), new RECT(48, 112, 64, 128), new RECT(80, 112, 96, 128), new RECT(48, 112, 64, 128), new RECT(144, 112, 160, 128)};
    private static final RECT[] ActNpc181_rcLeft = new RECT[]{new RECT(216, 152, 232, 168), new RECT(232, 152, 248, 168)};
    private static final RECT[] ActNpc181_rcRight = new RECT[]{new RECT(216, 168, 232, 184), new RECT(232, 168, 248, 184)};
    private static final RECT[] ActNpc182_rcLeft = new RECT[]{new RECT(184, 152, 200, 168), new RECT(200, 152, 216, 168)};
    private static final RECT[] ActNpc182_rcRight = new RECT[]{new RECT(184, 168, 200, 184), new RECT(200, 168, 216, 184)};
    private static final RECT[] ActNpc183_rect = new RECT[]{new RECT(56, 96, 80, 120), new RECT(80, 96, 104, 120)};
    private static final RECT[] ActNpc184_rc = new RECT[]{new RECT(0, 64, 32, 96), new RECT(32, 64, 64, 96), new RECT(64, 64, 96, 96), new RECT(32, 64, 64, 96)};
    private static final RECT ActNpc185_rc = new RECT(96, 64, 112, 96);
    private static final RECT[] ActNpc186_rc = new RECT[]{new RECT(48, 48, 64, 64), new RECT(64, 48, 80, 64), new RECT(80, 48, 96, 64), new RECT(64, 48, 80, 64)};
    private static final RECT[] ActNpc187_rect_left = new RECT[]{new RECT(224, 104, 256, 136), new RECT(256, 104, 288, 136)};
    private static final RECT[] ActNpc187_rect_right = new RECT[]{new RECT(224, 136, 256, 168), new RECT(256, 136, 288, 168)};
    private static final RECT[] ActNpc188_rect_left = new RECT[]{new RECT(288, 104, 304, 120), new RECT(304, 104, 320, 120)};
    private static final RECT[] ActNpc188_rect_right = new RECT[]{new RECT(288, 120, 304, 136), new RECT(304, 120, 320, 136)};
    private static final RECT[] ActNpc189_rect = new RECT[]{new RECT(224, 184, 232, 200), new RECT(232, 184, 240, 200), new RECT(240, 184, 248, 200)};
    private static final RECT[] ActNpc190_rect = new RECT[]{new RECT(192, 32, 208, 48), new RECT(208, 32, 224, 48)};
    private static final RECT[] ActNpc192_rcLeft = new RECT[]{new RECT(224, 64, 256, 80), new RECT(256, 64, 288, 96)};
    private static final RECT[] ActNpc192_rcRight = new RECT[]{new RECT(224, 80, 256, 96), new RECT(288, 64, 320, 96)};
    private static final RECT ActNpc193_rc = new RECT(256, 96, 320, 112);
    private static final RECT ActNpc194_rc = new RECT(192, 120, 224, 128);
    private static final RECT ActNpc195_rc = new RECT(112, 64, 128, 80);
    private static final RECT ActNpc196_rcLeft = new RECT(112, 64, 144, 80);
    private static final RECT ActNpc196_rcRight = new RECT(112, 80, 144, 96);
    private static final RECT[] ActNpc197_rc = new RECT[]{new RECT(0, 0, 16, 16), new RECT(16, 0, 32, 16), new RECT(32, 0, 48, 16), new RECT(48, 0, 64, 16)};
    private static final RECT[] ActNpc198_rcRight = new RECT[]{new RECT(208, 48, 224, 72), new RECT(224, 48, 240, 72), new RECT(240, 48, 256, 72)};
    private static final RECT[] ActNpc199_rect = new RECT[]{new RECT(72, 16, 74, 18), new RECT(74, 16, 76, 18), new RECT(76, 16, 78, 18), new RECT(78, 16, 80, 18), new RECT(80, 16, 82, 18)};

    public static void ActNpc180(NpChar.NPCHAR npc) {
        if (npc.y < MyChar.gMC.y - 81920) {
            if (npc.y < 131072) {
                npc.tgt_x = 0x280000;
                npc.tgt_y = npc.y;
            } else {
                npc.tgt_x = 0;
                npc.tgt_y = npc.y;
            }
        } else if (NpChar.gCurlyShoot_wait != 0) {
            npc.tgt_x = NpChar.gCurlyShoot_x;
            npc.tgt_y = NpChar.gCurlyShoot_y;
        } else {
            npc.tgt_x = MyChar.gMC.x;
            npc.tgt_y = MyChar.gMC.y;
        }
        if (npc.xm < 0 && (npc.flag & 1) != 0) {
            npc.xm = 0;
        }
        if (npc.xm > 0 && (npc.flag & 4) != 0) {
            npc.xm = 0;
        }
        switch (npc.act_no) {
            case 20: {
                npc.x = MyChar.gMC.x;
                npc.y = MyChar.gMC.y;
                npc.act_no = 100;
                npc.ani_no = 0;
                NpChar.SetNpChar(183, 0, 0, 0, 0, 0, npc, 256);
                if (Flags.GetNPCFlag(563)) {
                    NpChar.SetNpChar(182, 0, 0, 0, 0, 0, npc, 256);
                    break;
                }
                NpChar.SetNpChar(181, 0, 0, 0, 0, 0, npc, 256);
                break;
            }
            case 40: {
                npc.act_no = 41;
                npc.act_wait = 0;
                npc.ani_no = 10;
            }
            case 41: {
                if (++npc.act_wait == 750) {
                    npc.bits = (char)(npc.bits & 0xFFFFDFFF);
                    npc.ani_no = 0;
                }
                if (npc.act_wait <= 1000) break;
                npc.act_no = 100;
                npc.ani_no = 0;
                NpChar.SetNpChar(183, 0, 0, 0, 0, 0, npc, 256);
                if (Flags.GetNPCFlag(563)) {
                    NpChar.SetNpChar(182, 0, 0, 0, 0, 0, npc, 256);
                    break;
                }
                NpChar.SetNpChar(181, 0, 0, 0, 0, 0, npc, 256);
                break;
            }
            case 100: {
                npc.ani_no = 0;
                npc.xm = npc.xm * 7 / 8;
                npc.count1 = 0;
                if (npc.x > npc.tgt_x + 8192) {
                    npc.act_no = 200;
                    npc.ani_no = 1;
                    npc.direct = 0;
                    npc.act_wait = Game.Random(20, 60);
                    break;
                }
                if (npc.x >= npc.tgt_x - 8192) break;
                npc.act_no = 300;
                npc.ani_no = 1;
                npc.direct = 2;
                npc.act_wait = Game.Random(20, 60);
                break;
            }
            case 200: {
                npc.xm -= 32;
                npc.direct = 0;
                if ((npc.flag & 1) != 0) {
                    ++npc.count1;
                    break;
                }
                npc.count1 = 0;
                break;
            }
            case 210: {
                npc.xm -= 32;
                npc.direct = 0;
                if ((npc.flag & 8) == 0) break;
                npc.act_no = 100;
                break;
            }
            case 300: {
                npc.xm += 32;
                npc.direct = 2;
                if ((npc.flag & 4) != 0) {
                    ++npc.count1;
                    break;
                }
                npc.count1 = 0;
                break;
            }
            case 310: {
                npc.xm += 32;
                npc.direct = 2;
                if ((npc.flag & 8) == 0) break;
                npc.act_no = 100;
            }
        }
        if (NpChar.gCurlyShoot_wait != 0) {
            --NpChar.gCurlyShoot_wait;
        }
        if (NpChar.gCurlyShoot_wait == 70) {
            npc.count2 = 10;
        }
        if (NpChar.gCurlyShoot_wait == 60 && (npc.flag & 8) != 0 && Game.Random(0, 2) != 0) {
            npc.count1 = 0;
            npc.ym = -1536;
            npc.ani_no = 1;
            Sound.PlaySoundObject(15, 1);
            npc.act_no = npc.x > npc.tgt_x ? 210 : 310;
        }
        int xx = npc.x - npc.tgt_x;
        int yy = npc.y - npc.tgt_y;
        if (xx < 0) {
            xx *= -1;
        }
        if (npc.act_no == 100) {
            npc.ani_no = xx + 1024 < yy ? 5 : 0;
        }
        if (npc.act_no == 210 || npc.act_no == 310) {
            npc.ani_no = xx + 1024 < yy ? 6 : 1;
        }
        if (npc.act_no == 200 || npc.act_no == 300) {
            ++npc.ani_wait;
            npc.ani_no = xx + 1024 < yy ? 6 + npc.ani_wait / 4 % 4 : 1 + npc.ani_wait / 4 % 4;
            if (npc.act_wait != 0) {
                --npc.act_wait;
                if (npc.flag != 0 && npc.count1 > 10) {
                    npc.count1 = 0;
                    npc.ym = -1536;
                    npc.act_no += 10;
                    npc.ani_no = 1;
                    Sound.PlaySoundObject(15, 1);
                }
            } else {
                npc.act_no = 100;
                npc.ani_no = 0;
            }
        }
        if (npc.act_no >= 100 && npc.act_no < 500) {
            npc.ym = npc.x < MyChar.gMC.x - 40960 || npc.x > MyChar.gMC.x + 40960 ? (npc.flag != 0 ? (npc.ym += 16) : (npc.ym += 51)) : (npc.ym += 51);
        }
        if (npc.xm > 768) {
            npc.xm = 768;
        }
        if (npc.xm < -768) {
            npc.xm = -768;
        }
        if (npc.ym > 1535) {
            npc.ym = 1535;
        }
        npc.x += npc.xm;
        npc.y += npc.ym;
        if (npc.act_no >= 100 && (npc.flag & 8) == 0) {
            switch (npc.ani_no) {
                case 1000: {
                    break;
                }
                default: {
                    npc.ani_no = xx + 1024 < yy ? 6 : 1;
                }
            }
        }
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc180_rcLeft[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc180_rcRight[npc.ani_no]);
        }
    }

    public static void ActNpc181(NpChar.NPCHAR npc) {
        if (npc.pNpc == null) {
            return;
        }
        if (npc.pNpc.ani_no < 5) {
            if (npc.pNpc.direct == 0) {
                npc.direct = 0;
                npc.x = npc.pNpc.x - 4096;
            } else {
                npc.direct = 2;
                npc.x = npc.pNpc.x + 4096;
            }
            npc.y = npc.pNpc.y;
            npc.ani_no = 0;
        } else {
            if (npc.pNpc.direct == 0) {
                npc.direct = 0;
                npc.x = npc.pNpc.x;
            } else {
                npc.direct = 2;
                npc.x = npc.pNpc.x;
            }
            npc.y = npc.pNpc.y - 5120;
            npc.ani_no = 1;
        }
        if (npc.pNpc.ani_no == 1 || npc.pNpc.ani_no == 3 || npc.pNpc.ani_no == 6 || npc.pNpc.ani_no == 8) {
            npc.y -= 512;
        }
        switch (npc.act_no) {
            case 0: {
                if (npc.pNpc.count2 != 10) break;
                npc.pNpc.count2 = 0;
                npc.act_no = 10;
                npc.act_wait = 0;
                break;
            }
            case 10: {
                if (++npc.act_wait % 6 == 1) {
                    if (npc.ani_no == 0) {
                        if (npc.direct == 0) {
                            Bullet.SetBullet(12, npc.x - 2048, npc.y + 1536, 0);
                            Caret.SetCaret(npc.x - 2048, npc.y + 1536, 3, 0);
                        } else {
                            Bullet.SetBullet(12, npc.x + 2048, npc.y + 1536, 2);
                            Caret.SetCaret(npc.x + 2048, npc.y + 1536, 3, 0);
                        }
                    } else if (npc.direct == 0) {
                        Bullet.SetBullet(12, npc.x - 1024, npc.y - 2048, 1);
                        Caret.SetCaret(npc.x - 1024, npc.y - 2048, 3, 0);
                    } else {
                        Bullet.SetBullet(12, npc.x + 1024, npc.y - 2048, 1);
                        Caret.SetCaret(npc.x + 1024, npc.y - 2048, 3, 0);
                    }
                }
                if (npc.act_wait != 60) break;
                npc.act_no = 0;
            }
        }
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc181_rcLeft[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc181_rcRight[npc.ani_no]);
        }
    }

    public static void ActNpc182(NpChar.NPCHAR npc) {
        if (npc.pNpc == null) {
            return;
        }
        if (npc.pNpc.ani_no < 5) {
            if (npc.pNpc.direct == 0) {
                npc.direct = 0;
                npc.x = npc.pNpc.x - 4096;
            } else {
                npc.direct = 2;
                npc.x = npc.pNpc.x + 4096;
            }
            npc.y = npc.pNpc.y;
            npc.ani_no = 0;
        } else {
            if (npc.pNpc.direct == 0) {
                npc.direct = 0;
                npc.x = npc.pNpc.x;
            } else {
                npc.direct = 2;
                npc.x = npc.pNpc.x;
            }
            npc.y = npc.pNpc.y - 5120;
            npc.ani_no = 1;
        }
        if (npc.pNpc.ani_no == 1 || npc.pNpc.ani_no == 3 || npc.pNpc.ani_no == 6 || npc.pNpc.ani_no == 8) {
            npc.y -= 512;
        }
        switch (npc.act_no) {
            case 0: {
                if (npc.pNpc.count2 != 10) break;
                npc.pNpc.count2 = 0;
                npc.act_no = 10;
                npc.act_wait = 0;
                break;
            }
            case 10: {
                if (++npc.act_wait % 12 == 1) {
                    if (npc.ani_no == 0) {
                        if (npc.direct == 0) {
                            Bullet.SetBullet(6, npc.x - 2048, npc.y + 1536, 0);
                            Caret.SetCaret(npc.x - 2048, npc.y + 1536, 3, 0);
                        } else {
                            Bullet.SetBullet(6, npc.x + 2048, npc.y + 1536, 2);
                            Caret.SetCaret(npc.x + 2048, npc.y + 1536, 3, 0);
                        }
                    } else if (npc.direct == 0) {
                        Bullet.SetBullet(6, npc.x - 1024, npc.y - 2048, 1);
                        Caret.SetCaret(npc.x - 1024, npc.y - 2048, 3, 0);
                    } else {
                        Bullet.SetBullet(6, npc.x + 1024, npc.y - 2048, 1);
                        Caret.SetCaret(npc.x + 1024, npc.y - 2048, 3, 0);
                    }
                }
                if (npc.act_wait != 60) break;
                npc.act_no = 0;
            }
        }
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc182_rcLeft[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc182_rcRight[npc.ani_no]);
        }
    }

    public static void ActNpc183(NpChar.NPCHAR npc) {
        if (npc.pNpc == null) {
            return;
        }
        switch (npc.act_no) {
            case 0: {
                npc.x = npc.pNpc.x;
                npc.y = npc.pNpc.y;
                npc.act_no = 1;
            }
        }
        npc.x += (npc.pNpc.x - npc.x) / 2;
        npc.y += (npc.pNpc.y - npc.y) / 2;
        if (++npc.ani_wait > 1) {
            npc.ani_wait = 0;
            ++npc.ani_no;
        }
        if (npc.ani_no > 1) {
            npc.ani_no = 0;
        }
        if ((npc.pNpc.flag & 0x100) != 0) {
            npc.rect.copyFrom(ActNpc183_rect[npc.ani_no]);
        } else {
            npc.rect.right = 0;
        }
    }

    public static void ActNpc184(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
                npc.x += 4096;
                npc.y += 4096;
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
                break;
            }
            case 20: {
                for (int i = 0; i < 4; ++i) {
                    NpChar.SetNpChar(4, npc.x + Game.Random(-12, 12) * 512, npc.y + 8192, Game.Random(-341, 341), Game.Random(-1536, 0), 0, null, 256);
                }
                npc.act_no = 1;
            }
        }
        if (++npc.ani_wait > 10) {
            npc.ani_wait = 0;
            ++npc.ani_no;
        }
        if (npc.ani_no > 3) {
            npc.ani_no = 0;
        }
        npc.rect.copyFrom(ActNpc184_rc[npc.ani_no]);
    }

    public static void ActNpc185(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
                npc.y += 4096;
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
                ++npc.act_wait;
                break;
            }
            case 20: {
                npc.y -= 12288;
                npc.act_no = 1;
            }
        }
        npc.rect.copyFrom(ActNpc185_rc);
    }

    public static void ActNpc186(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
            }
            case 1: {
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
                ++npc.act_wait;
            }
        }
        if (++npc.ani_wait > 10) {
            npc.ani_wait = 0;
            ++npc.ani_no;
        }
        if (npc.ani_no > 3) {
            npc.ani_no = 0;
        }
        npc.rect.copyFrom(ActNpc186_rc[npc.ani_no]);
    }

    public static void ActNpc187(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
                npc.tgt_x = npc.x;
                npc.tgt_y = npc.y;
                npc.count1 = 120;
                npc.act_wait = Game.Random(0, 50);
                for (int i = 0; i < 5; ++i) {
                    NpChar.SetNpChar(188, 0, 0, 0, 0, 51 * i, npc, 256);
                }
            }
            case 1: {
                if (++npc.act_wait < 50) break;
                npc.act_wait = 0;
                npc.act_no = 2;
                npc.ym = 768;
                break;
            }
            case 2: {
                npc.count1 += 4;
                npc.direct = MyChar.gMC.x < npc.x ? 0 : 2;
                if (npc.tgt_y < npc.y) {
                    npc.ym -= 16;
                }
                if (npc.tgt_y > npc.y) {
                    npc.ym += 16;
                }
                if (npc.ym > 853) {
                    npc.ym = 853;
                }
                if (npc.ym >= -853) break;
                npc.ym = -853;
            }
        }
        npc.x += npc.xm;
        npc.y += npc.ym;
        if (++npc.ani_wait > 2) {
            npc.ani_wait = 0;
            ++npc.ani_no;
        }
        if (npc.ani_no > 1) {
            npc.ani_no = 0;
        }
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc187_rect_left[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc187_rect_right[npc.ani_no]);
        }
    }

    public static void ActNpc188(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
                npc.count1 = npc.direct;
            }
            case 1: {
                if (npc.pNpc.code_char == 187 && (npc.pNpc.cond & 0x80) != 0) {
                    char deg = (char)((npc.pNpc.count1 + npc.count1) % 256);
                    npc.x = npc.pNpc.x + Triangle.GetSin(deg) * 20;
                    npc.y = npc.pNpc.y + Triangle.GetCos(deg) * 32;
                    break;
                }
                npc.xm = Game.Random(-512, 512);
                npc.ym = Game.Random(-512, 512);
                npc.act_no = 10;
                break;
            }
            case 10: {
                npc.xm = MyChar.gMC.x < npc.x ? (npc.xm -= 32) : (npc.xm += 32);
                npc.ym = MyChar.gMC.y < npc.y ? (npc.ym -= 32) : (npc.ym += 32);
                if (npc.xm > 2048) {
                    npc.xm = 2048;
                }
                if (npc.xm < -2048) {
                    npc.xm = -2048;
                }
                if (npc.ym > 512) {
                    npc.ym = 512;
                }
                if (npc.ym < -512) {
                    npc.ym = -512;
                }
                npc.x += npc.xm;
                npc.y += npc.ym;
            }
        }
        npc.direct = MyChar.gMC.x < npc.x ? 0 : 2;
        if (++npc.ani_wait > 2) {
            npc.ani_wait = 0;
            ++npc.ani_no;
        }
        if (npc.ani_no > 1) {
            npc.ani_no = 0;
        }
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc188_rect_left[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc188_rect_right[npc.ani_no]);
        }
    }

    public static void ActNpc189(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
                npc.xm = -64;
            }
            case 1: {
                npc.y += npc.ym;
                if (++npc.act_wait <= 256) break;
                npc.act_no = 10;
                break;
            }
            case 10: {
                npc.xm = MyChar.gMC.x < npc.x ? (npc.xm -= 8) : (npc.xm += 8);
                npc.ym = MyChar.gMC.y < npc.y ? (npc.ym -= 8) : (npc.ym += 8);
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
            }
        }
        npc.direct = MyChar.gMC.x < npc.x ? 0 : 2;
        if (++npc.ani_wait > 2) {
            npc.ani_wait = 0;
            ++npc.ani_no;
        }
        if (npc.ani_no > 2) {
            npc.ani_no = 0;
        }
        npc.rect.copyFrom(ActNpc189_rect[npc.ani_no]);
    }

    public static void ActNpc190(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.ani_no = 0;
                break;
            }
            case 10: {
                Sound.PlaySoundObject(72, 1);
                for (int i = 0; i < 8; ++i) {
                    NpChar.SetNpChar(4, npc.x, npc.y + Game.Random(-8, 8) * 512, Game.Random(-8, -2) * 512, Game.Random(-3, 3) * 512, 0, null, 256);
                }
                npc.cond = 0;
                break;
            }
            case 20: {
                if (++npc.ani_wait > 10) {
                    npc.ani_wait = 0;
                    ++npc.ani_no;
                }
                if (npc.ani_no <= 1) break;
                npc.ani_no = 0;
            }
        }
        npc.rect.copyFrom(ActNpc190_rect[npc.ani_no]);
    }

    public static void ActNpc191(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 10;
                npc.tgt_y = npc.y;
                npc.ym = 512;
            }
            case 10: {
                npc.ym = npc.y < npc.tgt_y ? (npc.ym += 4) : (npc.ym -= 4);
                if (npc.ym < -256) {
                    npc.ym = -256;
                }
                if (npc.ym > 256) {
                    npc.ym = 256;
                }
                npc.y += npc.ym;
                break;
            }
            case 20: {
                npc.act_no = 21;
                npc.act_wait = 0;
            }
            case 21: {
                npc.ym = npc.y < npc.tgt_y ? (npc.ym += 4) : (npc.ym -= 4);
                if (npc.ym < -512) {
                    npc.ym = -512;
                }
                if (npc.ym > 512) {
                    npc.ym = 512;
                }
                npc.y += npc.ym;
                if (++npc.act_wait <= 1000) break;
                npc.act_no = 22;
                break;
            }
            case 22: {
                npc.ym = npc.y < 0 ? (npc.ym += 4) : (npc.ym -= 4);
                if (npc.ym < -512) {
                    npc.ym = -512;
                }
                if (npc.ym > 512) {
                    npc.ym = 512;
                }
                npc.y += npc.ym;
                if (npc.y >= 32768 && NpChar.gSuperYpos == 0) break;
                npc.act_no = 21;
                npc.act_wait = 0;
                break;
            }
            case 30: {
                npc.ym = npc.y < 0 ? (npc.ym += 4) : (npc.ym -= 4);
                if (npc.ym < -512) {
                    npc.ym = -512;
                }
                if (npc.ym > 256) {
                    npc.ym = 256;
                }
                npc.y += npc.ym;
            }
        }
        Back.gWaterY = npc.y;
        npc.rect.right = 0;
        npc.rect.bottom = 0;
    }

    public static void ActNpc192(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
                npc.view.back = 8192;
                npc.view.front = 8192;
                npc.view.top = 4096;
                npc.view.bottom = 4096;
                break;
            }
            case 10: {
                npc.act_no = 11;
                npc.ani_no = 1;
                npc.view.top = 8192;
                npc.view.bottom = 8192;
                npc.y -= 2560;
                break;
            }
            case 20: {
                npc.act_no = 21;
                npc.act_wait = 1;
                npc.tgt_x = npc.x;
                npc.tgt_y = npc.y;
            }
            case 21: {
                npc.x = npc.tgt_x + Game.Random(-1, 1) * 512;
                npc.y = npc.tgt_y + Game.Random(-1, 1) * 512;
                if (++npc.act_wait <= 30) break;
                npc.act_no = 30;
                break;
            }
            case 30: {
                npc.act_no = 31;
                npc.act_wait = 1;
                npc.xm = -2048;
                npc.x = npc.tgt_x;
                npc.y = npc.tgt_y;
                Sound.PlaySoundObject(44, 1);
            }
            case 31: {
                npc.xm += 32;
                npc.x += npc.xm;
                ++npc.act_wait;
                npc.y = npc.tgt_y + Game.Random(-1, 1) * 512;
                if (npc.act_wait > 10) {
                    npc.direct = 2;
                }
                if (npc.act_wait <= 200) break;
                npc.act_no = 40;
                break;
            }
            case 40: {
                npc.act_no = 41;
                npc.act_wait = 2;
                npc.direct = 0;
                npc.y -= 24576;
                npc.xm = -4096;
            }
            case 41: {
                npc.x += npc.xm;
                npc.y += npc.ym;
                npc.act_wait += 2;
                if (npc.act_wait <= 1200) break;
                npc.cond = 0;
            }
        }
        if (npc.act_wait % 4 == 0 && npc.act_no >= 20) {
            Sound.PlaySoundObject(34, 1);
            if (npc.direct == 0) {
                Caret.SetCaret(npc.x + 5120, npc.y + 5120, 7, 2);
            } else {
                Caret.SetCaret(npc.x - 5120, npc.y + 5120, 7, 0);
            }
        }
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc192_rcLeft[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc192_rcRight[npc.ani_no]);
        }
    }

    public static void ActNpc193(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
                npc.y = npc.y;
                npc.x += 12288;
            }
        }
        npc.rect.copyFrom(ActNpc193_rc);
    }

    public static void ActNpc194(NpChar.NPCHAR npc) {
        if (npc.act_no == 0) {
            npc.act_no = 1;
            npc.y += 2048;
        }
        npc.rect.copyFrom(ActNpc194_rc);
    }

    public static void ActNpc195(NpChar.NPCHAR npc) {
        npc.rect.copyFrom(ActNpc195_rc);
    }

    public static void ActNpc196(NpChar.NPCHAR npc) {
        npc.x -= 3072;
        if (npc.x <= 155648) {
            npc.x += 180224;
        }
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc196_rcLeft);
        } else {
            npc.rect.copyFrom(ActNpc196_rcRight);
        }
    }

    public static void ActNpc197(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 10;
                npc.ani_wait = 0;
                npc.ym = Game.Random(-512, 512);
                npc.xm = 2048;
            }
            case 10: {
                if (++npc.ani_wait > 2) {
                    npc.ani_wait = 0;
                    ++npc.ani_no;
                }
                if (npc.ani_no > 1) {
                    npc.ani_no = 0;
                }
                if (npc.xm >= 0) break;
                npc.damage = 3;
                npc.act_no = 20;
                break;
            }
            case 20: {
                npc.damage = 3;
                if (++npc.ani_wait > 0) {
                    npc.ani_wait = 0;
                    ++npc.ani_no;
                }
                if (npc.ani_no > 3) {
                    npc.ani_no = 2;
                }
                if (npc.x >= 24576) break;
                npc.destroy_voice = 0;
                NpcHit.LoseNpChar(npc, true);
            }
        }
        if ((npc.flag & 2) != 0) {
            npc.ym = 512;
        }
        if ((npc.flag & 8) != 0) {
            npc.ym = -512;
        }
        npc.xm -= 12;
        npc.x += npc.xm;
        npc.y += npc.ym;
        npc.rect.copyFrom(ActNpc197_rc[npc.ani_no]);
    }

    public static void ActNpc198(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                if (++npc.act_wait <= 20) break;
                npc.act_no = 1;
                npc.xm = 0;
                npc.ym = 0;
                npc.count1 = 0;
                break;
            }
            case 1: {
                npc.xm += 32;
            }
        }
        if (++npc.ani_wait > 0) {
            npc.ani_wait = 0;
            ++npc.ani_no;
        }
        if (npc.ani_no > 2) {
            npc.ani_no = 0;
        }
        npc.x += npc.xm;
        npc.y += npc.ym;
        npc.rect.copyFrom(ActNpc198_rcRight[npc.ani_no]);
        if (++npc.count1 > 100) {
            npc.cond = 0;
        }
        if (npc.count1 % 4 == 1) {
            Sound.PlaySoundObject(46, 1);
        }
    }

    public static void ActNpc199(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
                npc.ani_no = Game.Random(0, 2);
                switch (npc.direct) {
                    case 0: {
                        npc.xm = -1;
                        break;
                    }
                    case 1: {
                        npc.ym = -1;
                        break;
                    }
                    case 2: {
                        npc.xm = 1;
                        break;
                    }
                    case 3: {
                        npc.ym = 1;
                    }
                }
                npc.xm *= Game.Random(4, 8) * 512 / 2;
                npc.ym *= Game.Random(4, 8) * 512 / 2;
            }
        }
        if (++npc.ani_wait > 6) {
            npc.ani_wait = 0;
            ++npc.ani_no;
        }
        if (npc.ani_no > 4) {
            npc.cond = 0;
            return;
        }
        npc.x += npc.xm;
        npc.y += npc.ym;
        npc.rect.copyFrom(ActNpc199_rect[npc.ani_no]);
    }
}
