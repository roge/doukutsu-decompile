/*
 * Decompiled with CFR 0.152.
 */
package jp.studiopixel.doukutsu;

import jp.studiopixel.doukutsu.Caret;
import jp.studiopixel.doukutsu.Flags;
import jp.studiopixel.doukutsu.Flash;
import jp.studiopixel.doukutsu.Frame;
import jp.studiopixel.doukutsu.Game;
import jp.studiopixel.doukutsu.Map;
import jp.studiopixel.doukutsu.MyChar;
import jp.studiopixel.doukutsu.NpChar;
import jp.studiopixel.doukutsu.RECT;
import jp.studiopixel.doukutsu.Sound;
import jp.studiopixel.doukutsu.Triangle;

public class NpcAct340 {
    private static final RECT[] ActNpc340_rcLeft = new RECT[]{new RECT(0, 0, 48, 40), new RECT(48, 0, 96, 40), new RECT(96, 0, 144, 40), new RECT(144, 0, 192, 40), new RECT(192, 0, 240, 40), new RECT(240, 0, 288, 40), new RECT(0, 80, 48, 120), new RECT(48, 80, 96, 120), new RECT(96, 80, 144, 120), new RECT(144, 80, 192, 120), new RECT(192, 80, 240, 120)};
    private static final RECT[] ActNpc340_rcRight = new RECT[]{new RECT(0, 40, 48, 80), new RECT(48, 40, 96, 80), new RECT(96, 40, 144, 80), new RECT(144, 40, 192, 80), new RECT(192, 40, 240, 80), new RECT(240, 40, 288, 80), new RECT(0, 120, 48, 160), new RECT(48, 120, 96, 160), new RECT(96, 120, 144, 160), new RECT(144, 120, 192, 160), new RECT(192, 120, 240, 160)};
    private static final RECT[] ActNpc341_rc = new RECT[]{new RECT(288, 32, 320, 48), new RECT(288, 48, 320, 64), new RECT(288, 64, 320, 80)};
    private static final RECT[] ActNpc342_rc = new RECT[]{new RECT(240, 48, 280, 88), new RECT(240, 88, 280, 128), new RECT(280, 48, 320, 88)};
    private static int ActNpc342_flash = 0;
    private static final RECT ActNpc343_rc = new RECT(0, 0, 120, 120);
    private static final RECT[] ActNpc344_rc = new RECT[]{new RECT(272, 0, 296, 16), new RECT(296, 0, 320, 16)};
    private static final RECT[] ActNpc345_rc = new RECT[]{new RECT(128, 176, 144, 192), new RECT(144, 176, 160, 192), new RECT(160, 176, 176, 192), new RECT(176, 176, 192, 192)};
    private static final RECT ActNpc346_rc = new RECT(240, 0, 272, 16);
    private static final RECT[] ActNpc347_rc = new RECT[]{new RECT(256, 48, 272, 64), new RECT(272, 48, 288, 64), new RECT(288, 48, 304, 64), new RECT(304, 48, 320, 64)};
    private static final RECT[] ActNpc348_rc = new RECT[]{new RECT(128, 152, 160, 176), new RECT(160, 152, 192, 176)};
    private static final RECT ActNpc349_rect = new RECT(0, 0, 16, 16);
    private static final RECT[] ActNpc350_rcLeft = new RECT[]{new RECT(0, 160, 24, 184), new RECT(24, 160, 48, 184), new RECT(48, 160, 72, 184), new RECT(72, 160, 96, 184), new RECT(96, 160, 120, 184), new RECT(120, 160, 144, 184), new RECT(144, 160, 168, 184)};
    private static final RECT[] ActNpc350_rcRight = new RECT[]{new RECT(0, 184, 24, 208), new RECT(24, 184, 48, 208), new RECT(48, 184, 72, 208), new RECT(72, 184, 96, 208), new RECT(96, 184, 120, 208), new RECT(120, 184, 144, 208), new RECT(144, 184, 168, 208)};
    private static final RECT[] ActNpc351_rc = new RECT[]{new RECT(0, 96, 32, 136), new RECT(32, 96, 64, 136), new RECT(64, 96, 96, 136), new RECT(96, 96, 128, 136), new RECT(128, 96, 160, 136), new RECT(0, 176, 32, 216), new RECT(32, 176, 64, 216), new RECT(64, 176, 96, 216), new RECT(96, 176, 128, 216)};
    private static final RECT[] ActNpc352_rc = new RECT[]{new RECT(304, 48, 320, 64), new RECT(224, 48, 240, 64), new RECT(32, 80, 48, 96), new RECT(0, 80, 16, 96), new RECT(224, 216, 240, 240), new RECT(192, 216, 208, 240), new RECT(48, 16, 64, 32), new RECT(0, 16, 16, 32), new RECT(112, 192, 128, 216), new RECT(80, 192, 96, 216), new RECT(304, 0, 320, 16), new RECT(224, 0, 240, 16), new RECT(176, 32, 192, 48), new RECT(176, 32, 192, 48), new RECT(240, 16, 256, 32), new RECT(224, 16, 240, 32), new RECT(208, 16, 224, 32), new RECT(192, 16, 208, 32), new RECT(280, 128, 320, 152), new RECT(280, 152, 320, 176), new RECT(32, 112, 48, 128), new RECT(0, 112, 16, 128), new RECT(80, 0, 96, 16), new RECT(112, 0, 128, 16), new RECT(16, 152, 32, 176), new RECT(0, 152, 16, 176), new RECT(48, 16, 64, 32), new RECT(48, 0, 64, 16)};
    private static final RECT[] ActNpc353_rc = new RECT[]{new RECT(168, 160, 184, 184), new RECT(184, 160, 200, 184), new RECT(168, 184, 184, 208), new RECT(184, 184, 200, 208)};
    private static final RECT[] ActNpc353_rcLeft = new RECT[]{new RECT(200, 160, 216, 176), new RECT(216, 160, 232, 176)};
    private static final RECT[] ActNpc353_rcRight = new RECT[]{new RECT(200, 176, 216, 192), new RECT(216, 176, 232, 192)};
    private static final RECT[] ActNpc355_rc = new RECT[]{new RECT(80, 16, 96, 32), new RECT(80, 96, 96, 112), new RECT(128, 16, 144, 32), new RECT(208, 96, 224, 112)};
    private static final RECT[] ActNpc356_rcRight = new RECT[]{new RECT(240, 128, 280, 152), new RECT(240, 152, 280, 176)};
    private static final RECT ActNpc357_rc = new RECT(224, 136, 240, 152);
    private static final RECT[] ActNpc358_rc = new RECT[]{new RECT(208, 8, 224, 32), new RECT(224, 8, 240, 32), new RECT(240, 8, 256, 32), new RECT(256, 8, 272, 32), new RECT(272, 8, 288, 32)};
    private static final RECT ActNpc360_rc = new RECT(0, 176, 48, 184);

    public static void ActNpc340(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
                npc.cond = (byte)-128;
                npc.exp = 1;
                npc.direct = 0;
                npc.y -= 3072;
                npc.damage = 0;
                NpChar.SetNpChar(341, npc.x, npc.y - 8192, 0, 0, 0, npc, 256);
                break;
            }
            case 10: {
                npc.act_no = 11;
                npc.act_wait = 0;
            }
            case 11: {
                if (++npc.act_wait <= 100) break;
                npc.act_no = 100;
                break;
            }
            case 100: {
                npc.act_no = 110;
                npc.act_wait = 0;
                npc.ani_no = 1;
                npc.ani_wait = 0;
                npc.damage = 4;
                npc.bits = (char)(npc.bits | 0x20);
            }
            case 110: {
                npc.act_no = 111;
                npc.damage = 3;
                npc.tgt_x = npc.life;
            }
            case 111: {
                if (++npc.ani_wait > 10) {
                    npc.ani_wait = 0;
                    ++npc.ani_no;
                }
                if (npc.ani_no > 2) {
                    npc.ani_no = 1;
                }
                ++npc.act_wait;
                if (npc.life < npc.tgt_x - 50 || npc.act_wait > 150) {
                    switch (npc.count2 % 5) {
                        case 0: 
                        case 1: 
                        case 2: 
                        case 3: {
                            npc.act_no = 200;
                            break;
                        }
                        case 4: {
                            npc.act_no = 300;
                        }
                    }
                    ++npc.count2;
                }
                if (MyChar.gMC.x < npc.x) {
                    npc.direct = 0;
                    break;
                }
                npc.direct = 2;
                break;
            }
            case 200: {
                npc.act_no = 201;
                npc.count1 = 0;
            }
            case 201: {
                npc.act_no = npc.xm == 0 ? 202 : 203;
                npc.act_wait = 0;
                npc.ani_no = 3;
                npc.damage = 3;
                ++npc.count1;
            }
            case 202: {
                npc.direct = MyChar.gMC.x < npc.x ? 0 : 2;
                npc.xm = 8 * npc.xm / 9;
                npc.ym = 8 * npc.ym / 9;
                if (++npc.act_wait <= 20) break;
                npc.act_no = 210;
                break;
            }
            case 203: {
                npc.xm = 8 * npc.xm / 9;
                npc.ym = 8 * npc.ym / 9;
                if (++npc.act_wait <= 20) break;
                if (MyChar.gMC.y < npc.y + 6144) {
                    npc.act_no = 220;
                    break;
                }
                npc.act_no = 230;
                break;
            }
            case 210: {
                npc.act_no = 211;
                npc.act_wait = 0;
                npc.ani_no = 6;
                npc.ani_wait = 0;
                npc.ym = 0;
                npc.damage = 10;
                npc.direct = MyChar.gMC.x < npc.x ? 0 : 2;
                Sound.PlaySoundObject(25, 1);
            }
            case 211: {
                npc.xm = npc.direct == 0 ? -2048 : 2048;
                npc.ani_no = ++npc.act_wait / 2 % 2 != 0 ? 6 : 7;
                if (npc.direct == 0 && (npc.flag & 1) != 0) {
                    npc.act_no = 212;
                    npc.act_wait = 0;
                    npc.damage = 3;
                    Frame.SetQuake2(10);
                    Sound.PlaySoundObject(26, 1);
                }
                if (npc.direct == 2 && (npc.flag & 4) != 0) {
                    npc.act_no = 212;
                    npc.act_wait = 0;
                    npc.damage = 3;
                    Frame.SetQuake2(10);
                    Sound.PlaySoundObject(26, 1);
                }
                if (npc.count1 >= 4 || MyChar.gMC.x <= npc.x - 8192 || MyChar.gMC.x >= npc.x + 8192) break;
                npc.act_no = 201;
                break;
            }
            case 212: {
                ++npc.act_wait;
                npc.xm = 0;
                npc.ani_no = 6;
                if (npc.act_wait <= 30) break;
                if (npc.count1 > 3) {
                    npc.act_no = 240;
                    break;
                }
                npc.act_no = 201;
                break;
            }
            case 220: {
                npc.act_no = 221;
                npc.act_wait = 0;
                npc.ani_no = 8;
                npc.ani_wait = 0;
                npc.xm = 0;
                npc.damage = 10;
                npc.direct = 0;
                Sound.PlaySoundObject(25, 1);
            }
            case 221: {
                npc.ym = -2048;
                npc.ani_no = ++npc.act_wait / 2 % 2 != 0 ? 8 : 9;
                if (npc.y < 24576) {
                    npc.y = 24576;
                    npc.ym = 0;
                    npc.act_no = 222;
                    npc.act_wait = 0;
                    npc.damage = 3;
                    for (int i = 0; i < 8; ++i) {
                        int x = npc.x + Game.Random(-16, 16) * 512;
                        NpChar.SetNpChar(4, x, npc.y - 5120, 0, 0, 0, null, 256);
                    }
                    NpChar.SetNpChar(332, npc.x - 6144, npc.y - 6144, 0, 0, 0, null, 256);
                    NpChar.SetNpChar(332, npc.x + 6144, npc.y - 6144, 0, 0, 2, null, 256);
                    Frame.SetQuake2(10);
                    Sound.PlaySoundObject(26, 1);
                }
                if (npc.count1 >= 4 || MyChar.gMC.y <= npc.y - 8192 || MyChar.gMC.y >= npc.y + 8192) break;
                npc.act_no = 201;
                break;
            }
            case 222: {
                ++npc.act_wait;
                npc.xm = 0;
                npc.ani_no = 8;
                if (npc.act_wait <= 30) break;
                if (npc.count1 > 3) {
                    npc.act_no = 240;
                    break;
                }
                npc.act_no = 201;
                break;
            }
            case 230: {
                npc.act_no = 231;
                npc.act_wait = 0;
                npc.ani_no = 8;
                npc.ani_wait = 0;
                npc.xm = 0;
                npc.damage = 10;
                npc.direct = 2;
                Sound.PlaySoundObject(25, 1);
            }
            case 231: {
                npc.ym = 2048;
                npc.ani_no = ++npc.act_wait / 2 % 2 != 0 ? 8 : 9;
                if ((npc.flag & 8) != 0) {
                    npc.act_no = 232;
                    npc.act_wait = 0;
                    npc.damage = 3;
                    npc.direct = MyChar.gMC.x < npc.x ? 0 : 2;
                    for (int i = 0; i < 8; ++i) {
                        int x = npc.x + Game.Random(-16, 16) * 512;
                        NpChar.SetNpChar(4, x, npc.y + 5120, 0, 0, 0, null, 256);
                    }
                    NpChar.SetNpChar(332, npc.x - 6144, npc.y + 6144, 0, 0, 0, null, 256);
                    NpChar.SetNpChar(332, npc.x + 6144, npc.y + 6144, 0, 0, 2, null, 256);
                    Frame.SetQuake2(10);
                    Sound.PlaySoundObject(26, 1);
                }
                if (npc.count1 >= 4 || MyChar.gMC.y <= npc.y - 8192 || MyChar.gMC.y >= npc.y + 8192) break;
                npc.act_no = 201;
                break;
            }
            case 232: {
                ++npc.act_wait;
                npc.xm = 0;
                npc.ani_no = 3;
                if (npc.act_wait <= 30) break;
                if (npc.count1 > 3) {
                    npc.act_no = 242;
                    break;
                }
                npc.act_no = 201;
                break;
            }
            case 240: {
                npc.act_no = 241;
                npc.direct = 0;
            }
            case 241: {
                npc.ym += 128;
                if (npc.ym > 1535) {
                    npc.ym = 1535;
                }
                npc.ani_no = ++npc.ani_wait / 2 % 2 != 0 ? 4 : 5;
                if ((npc.flag & 8) == 0) break;
                npc.act_no = 242;
                npc.act_wait = 0;
                npc.ani_no = 3;
                if (MyChar.gMC.x < npc.x) {
                    npc.direct = 0;
                    break;
                }
                npc.direct = 2;
                break;
            }
            case 242: {
                npc.xm = 3 * npc.xm / 4;
                npc.ani_no = 3;
                if (++npc.act_wait <= 10) break;
                npc.act_no = 110;
                break;
            }
            case 300: {
                npc.act_no = 310;
                npc.act_wait = 0;
                npc.ym = -1536;
                if (npc.x > 163840) {
                    npc.direct = 2;
                    npc.tgt_x = MyChar.gMC.x;
                    npc.tgt_y = 90112;
                } else {
                    npc.direct = 0;
                    npc.tgt_x = MyChar.gMC.x;
                    npc.tgt_y = 90112;
                }
                npc.ani_wait = 0;
            }
            case 310: {
                ++npc.ani_wait;
                npc.direct = ++npc.act_wait > 200 && npc.ani_wait < 20 ? 2 : 0;
                npc.ani_no = npc.ani_wait / 2 % 2 != 0 ? 4 : 5;
                npc.xm = npc.x < npc.tgt_x ? (npc.xm += 64) : (npc.xm -= 64);
                npc.ym = npc.y < npc.tgt_y ? (npc.ym += 64) : (npc.ym -= 64);
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
                if (npc.act_wait > 200 && npc.act_wait % 40 == 1) {
                    npc.ani_wait = 0;
                    NpChar.SetNpChar(333, MyChar.gMC.x, 155648, 0, 0, 0, null, 256);
                }
                if (npc.act_wait <= 480) break;
                npc.act_no = 320;
                npc.act_wait = 0;
                break;
            }
            case 320: {
                npc.xm = 0;
                npc.ym = 0;
                npc.direct = 2;
                if (++npc.act_wait == 40) {
                    Flash.SetFlash(0, 0, 2);
                }
                if (npc.act_wait > 50 && npc.act_wait % 10 == 1) {
                    int x = ((4 * npc.act_wait - 200) / 10 + 2) * 512 * 16;
                    NpChar.SetNpChar(333, x, 155648, 0, 0, 0, null, 256);
                }
                if (npc.act_wait > 140) {
                    npc.act_no = 240;
                }
                if (++npc.ani_wait / 2 % 2 != 0) {
                    npc.ani_no = 4;
                    break;
                }
                npc.ani_no = 5;
                break;
            }
            case 1000: {
                npc.act_no = 1001;
                npc.act_wait = 0;
                npc.ani_no = 10;
                npc.tgt_x = npc.x;
                npc.xm = 0;
                npc.bits = (char)(npc.bits & 0xFFFFFFDF);
                NpChar.SetDestroyNpChar(npc.x, npc.y, 16, 16);
                Sound.PlaySoundObject(72, 1);
            }
            case 1001: {
                npc.ym += 32;
                if (npc.ym > 1535) {
                    npc.ym = 1535;
                }
                npc.x = ++npc.act_wait / 2 % 2 != 0 ? npc.tgt_x + 512 : npc.tgt_x - 512;
                if ((npc.flag & 8) == 0) break;
                npc.act_no = 1002;
                npc.act_wait = 0;
                break;
            }
            case 1002: {
                if (++npc.act_wait > 150) {
                    npc.act_wait = 0;
                    npc.act_no = 1003;
                    npc.ani_no = 3;
                }
                if (npc.act_wait / 2 % 2 != 0) {
                    npc.x = npc.tgt_x + 512;
                    break;
                }
                npc.x = npc.tgt_x - 512;
                break;
            }
            case 1003: {
                if (++npc.act_wait <= 30) break;
                npc.act_wait = 0;
                npc.act_no = 1004;
                npc.ani_no = 3;
                npc.ym -= 2560;
                npc.direct = 0;
                npc.bits = (char)(npc.bits | 8);
                break;
            }
            case 1004: {
                if (npc.y < 0) {
                    npc.xm = 0;
                    npc.ym = 0;
                    npc.act_no = 1005;
                    npc.act_wait = 0;
                    Flash.SetFlash(0, 0, 2);
                    Sound.PlaySoundObject(29, 1);
                }
                npc.ani_no = ++npc.act_wait / 2 % 2 != 0 ? 8 : 9;
            }
        }
        npc.x += npc.xm;
        npc.y += npc.ym;
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc340_rcLeft[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc340_rcRight[npc.ani_no]);
        }
    }

    public static void ActNpc341(NpChar.NPCHAR npc) {
        if (npc.pNpc.act_no == 11 && npc.pNpc.act_wait > 50) {
            ++npc.ani_wait;
        }
        if (npc.ani_wait > 4) {
            npc.ani_wait = 0;
            if (npc.ani_no < 2) {
                ++npc.ani_no;
            }
        }
        if (npc.pNpc.ani_no != 0) {
            npc.cond = 0;
        }
        npc.rect.copyFrom(ActNpc341_rc[npc.ani_no]);
    }

    public static void ActNpc342(NpChar.NPCHAR npc) {
        if (npc.act_no < 1000 && npc.pNpc.act_no >= 1000) {
            npc.act_no = 1000;
        }
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 10;
                npc.count1 = (npc.direct & 0xFF) * 2;
                npc.direct >>>= 8;
                npc.count2 = 192;
                npc.damage = 14;
            }
            case 10: {
                if (npc.count2 < 320) {
                    npc.count2 += 8;
                    break;
                }
                npc.act_no = 11;
                break;
            }
            case 11: {
                if (npc.count2 > 304) {
                    npc.count2 -= 4;
                    break;
                }
                npc.act_no = 12;
                break;
            }
            case 12: {
                if (npc.pNpc.act_no != 311) break;
                npc.act_no = 20;
                break;
            }
            case 20: {
                npc.act_no = 21;
                npc.bits = (char)(npc.bits | 0x20);
                npc.life = 1000;
            }
            case 21: {
                npc.count1 -= 2;
                if (npc.count1 < 0) {
                    npc.count1 += 512;
                }
                npc.ani_no = npc.shock != '\u0000' ? (++ActNpc342_flash / 2 % 2 != 0 ? 1 : 0) : 0;
                if (npc.life < 900) {
                    npc.act_no = 22;
                    npc.bits = (char)(npc.bits & 0xFFFFFFDF);
                    NpChar.SetDestroyNpChar(npc.x, npc.y, 8192, 32);
                    Sound.PlaySoundObject(71, 1);
                }
                npc.pNpc.count1 = 4;
                if (npc.pNpc.act_no != 401) break;
                npc.act_no = 23;
                break;
            }
            case 22: {
                npc.ani_no = 2;
                npc.count1 -= 2;
                if (npc.count1 < 0) {
                    npc.count1 += 512;
                }
                if (npc.pNpc.act_no != 401) break;
                npc.act_no = 23;
                break;
            }
            case 23: {
                npc.ani_no = 2;
                npc.count1 -= 4;
                if (npc.count1 < 0) {
                    npc.count1 += 512;
                }
                if (npc.pNpc.act_no != 420) break;
                npc.act_no = 30;
                break;
            }
            case 30: {
                npc.act_no = 31;
                npc.life = 1000;
                npc.damage = 10;
                if (npc.direct == 0) {
                    npc.bits = (char)(npc.bits | 0x20);
                }
                npc.ym = 0;
            }
            case 31: {
                ++npc.count1;
                npc.count1 %= 512;
                if (npc.count2 > 256) {
                    --npc.count2;
                }
                npc.ani_no = (npc.bits & 0x20) != 0 ? (npc.shock != '\u0000' ? (++ActNpc342_flash / 2 % 2 != 0 ? 1 : 0) : 0) : 2;
                if (npc.life >= 900) break;
                npc.act_no = 40;
                break;
            }
            case 40: {
                npc.act_no = 41;
                npc.xm = 0;
                npc.ym = 0;
                npc.ani_no = 2;
                npc.damage = 5;
                npc.bits = (char)(npc.bits & 0xFFFFFFD7);
                NpChar.SetDestroyNpChar(npc.x, npc.y, 8192, 32);
                Sound.PlaySoundObject(71, 1);
            }
            case 41: {
                if ((npc.flag & 1) != 0) {
                    npc.xm = 256;
                }
                if ((npc.flag & 4) != 0) {
                    npc.xm = -256;
                }
                if ((npc.flag & 8) != 0) {
                    if (npc.xm == 0) {
                        npc.xm = MyChar.gMC.x < npc.x ? 256 : -256;
                    }
                    npc.ym = -2048;
                    Sound.PlaySoundObject(26, 1);
                }
                npc.ym += 32;
                if (npc.ym <= 1535) break;
                npc.ym = 1535;
                break;
            }
            case 1000: {
                npc.act_no = 1001;
                npc.xm = 0;
                npc.ym = 0;
                npc.ani_no = 2;
                npc.bits = (char)(npc.bits & 0xFFFFFFD7);
                npc.damage = 0;
                npc.count1 /= 4;
                npc.exp = 0;
            }
            case 1001: {
                if (npc.count1 > 0) {
                    if (--npc.count1 / 2 % 2 != 0) {
                        npc.ani_no = 1;
                        break;
                    }
                    npc.ani_no = 0;
                    break;
                }
                NpChar.SetDestroyNpChar(npc.x, npc.y, 8192, 32);
                Sound.PlaySoundObject(71, 1);
                NpChar.VanishNpChar(npc);
                return;
            }
        }
        if (npc.act_no == 21 || npc.act_no == 22) {
            switch (npc.pNpc.direct) {
                case 0: {
                    if (npc.count1 != 140) break;
                    NpChar.SetNpChar(4, npc.x + 4096, npc.y + 6144, 0, 0, 0, null, 256);
                    NpChar.SetNpChar(4, npc.x - 4096, npc.y + 6144, 0, 0, 0, null, 256);
                    Sound.PlaySoundObject(26, 1);
                    break;
                }
                case 1: {
                    if (npc.count1 != 268) break;
                    NpChar.SetNpChar(4, npc.x - 6144, npc.y + 4096, 0, 0, 0, null, 256);
                    NpChar.SetNpChar(4, npc.x - 6144, npc.y - 4096, 0, 0, 0, null, 256);
                    Sound.PlaySoundObject(26, 1);
                    break;
                }
                case 2: {
                    if (npc.count1 != 396) break;
                    NpChar.SetNpChar(4, npc.x + 4096, npc.y - 6144, 0, 0, 0, null, 256);
                    NpChar.SetNpChar(4, npc.x - 4096, npc.y - 6144, 0, 0, 0, null, 256);
                    NpChar.SetNpChar(345, npc.x - 4096, npc.y - 6144, 0, 0, 0, null, 256);
                    Sound.PlaySoundObject(26, 1);
                    break;
                }
                case 3: {
                    if (npc.count1 != 12) break;
                    NpChar.SetNpChar(4, npc.x + 6144, npc.y + 4096, 0, 0, 0, null, 256);
                    NpChar.SetNpChar(4, npc.x + 6144, npc.y - 4096, 0, 0, 0, null, 256);
                    Sound.PlaySoundObject(26, 1);
                }
            }
        }
        if (npc.act_no < 40) {
            char deg = (char)(npc.count1 / 2);
            npc.tgt_x = npc.pNpc.x + npc.count2 * Triangle.GetCos(deg) / 4;
            npc.tgt_y = npc.pNpc.y + npc.count2 * Triangle.GetSin(deg) / 4;
            npc.xm = npc.tgt_x - npc.x;
            npc.ym = npc.tgt_y - npc.y;
        }
        npc.x += npc.xm;
        npc.y += npc.ym;
        npc.rect.copyFrom(ActNpc342_rc[npc.ani_no]);
    }

    public static void ActNpc343(NpChar.NPCHAR npc) {
        npc.rect.copyFrom(ActNpc343_rc);
        if (++npc.act_wait > 100) {
            npc.cond = 0;
        }
        npc.x = npc.pNpc.x;
        npc.y = npc.pNpc.y;
    }

    public static void ActNpc344(NpChar.NPCHAR npc) {
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc344_rc[0]);
            npc.x = npc.pNpc.x - 12288;
        } else {
            npc.rect.copyFrom(ActNpc344_rc[1]);
            npc.x = npc.pNpc.x + 12288;
        }
        if (++npc.act_wait > 100) {
            npc.cond = 0;
        }
        npc.y = npc.pNpc.y - 18432;
    }

    public static void ActNpc345(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 100;
                npc.ani_no = Game.Random(0, 16) % 4;
            }
            case 100: {
                npc.ym += 64;
                if (npc.ym > 1792) {
                    npc.ym = 1792;
                }
                if (npc.y > 65536) {
                    npc.bits = (char)(npc.bits & 0xFFFFFFF7);
                }
                if (npc.act_wait++ / 2 % 2 != 0) {
                    NpChar.SetNpChar(4, npc.x, npc.y, 0, 0, 0, null, 256);
                }
                if ((npc.flag & 8) == 0) break;
                npc.ym = -512;
                npc.act_no = 110;
                npc.bits = (char)(npc.bits | 8);
                Sound.PlaySoundObject(12, 1);
                Frame.SetQuake(10);
                for (int i = 0; i < 4; ++i) {
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
        if (++npc.ani_wait > 8) {
            npc.ani_wait = 0;
            ++npc.ani_no;
        }
        if (npc.ani_no > 3) {
            npc.ani_no = 0;
        }
        npc.y += npc.ym;
        npc.rect.copyFrom(ActNpc345_rc[npc.ani_no]);
    }

    public static void ActNpc346(NpChar.NPCHAR npc) {
        if (npc.act_no < 1000 && npc.pNpc.act_no >= 1000) {
            npc.act_no = 1000;
        }
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 10;
                npc.count1 = npc.direct * 4;
                npc.count2 = 192;
                npc.ani_no = 0;
            }
            case 10: {
                if (npc.count2 < 448) {
                    npc.count2 += 8;
                    break;
                }
                npc.act_no = 11;
                break;
            }
            case 11: {
                if (npc.pNpc.act_no != 411) break;
                npc.act_no = 20;
                break;
            }
            case 20: {
                if (--npc.count1 < 0) {
                    npc.count1 += 1024;
                }
                if (npc.pNpc.act_no == 421) {
                    npc.act_no = 40;
                }
                if (npc.pNpc.act_no != 423) break;
                npc.act_no = 100;
                break;
            }
            case 30: {
                ++npc.count1;
                npc.count1 %= 1024;
                if (npc.pNpc.act_no == 425) {
                    npc.act_no = 50;
                }
                if (npc.pNpc.act_no != 427) break;
                npc.act_no = 100;
                break;
            }
            case 40: {
                npc.count1 -= 2;
                if (npc.count1 < 0) {
                    npc.count1 += 1024;
                }
                if (npc.pNpc.act_no != 422) break;
                npc.act_no = 20;
                break;
            }
            case 50: {
                npc.count1 += 2;
                npc.count1 %= 1024;
                if (npc.pNpc.act_no != 426) break;
                npc.act_no = 30;
                break;
            }
            case 100: {
                npc.ani_no = 0;
                if (npc.pNpc.act_no == 424) {
                    npc.act_no = 30;
                }
                if (npc.pNpc.act_no != 428) break;
                npc.act_no = 20;
                break;
            }
            case 1000: {
                npc.act_no = 1001;
                npc.xm = 0;
                npc.ym = 0;
                npc.bits = (char)(npc.bits & 0xFFFFFFBF);
            }
            case 1001: {
                npc.ym += 64;
                if (npc.y <= Map.gMap.length * 16 * 512) break;
                npc.cond = 0;
            }
        }
        if (npc.act_no < 1000) {
            npc.bits = MyChar.gMC.y > npc.y - 4096 && MyChar.gMC.ym < 0 ? (char)(npc.bits & 0xFFFFFFBF) : (char)(npc.bits | 0x40);
            char deg = (char)(npc.count1 / 4);
            npc.tgt_x = npc.pNpc.x + npc.count2 * Triangle.GetCos(deg) / 4;
            npc.tgt_y = npc.pNpc.y + 8192 + npc.count2 * Triangle.GetSin(deg) / 4;
            npc.xm = npc.tgt_x - npc.x;
            if (npc.act_no == 20 || npc.act_no == 30) {
                if (npc.count1 % 4 == 0) {
                    npc.ani_no = (npc.tgt_y - npc.y) / 4;
                }
            } else if (npc.act_no == 40 || npc.act_no == 50) {
                if (npc.count1 / 2 % 2 == 0) {
                    npc.ani_no = (npc.tgt_y - npc.y) / 2;
                }
            } else {
                npc.ani_no = npc.tgt_y - npc.y;
            }
            npc.ym = npc.ani_no;
        }
        npc.x += npc.xm;
        npc.y += npc.ym;
        npc.rect.copyFrom(ActNpc346_rc);
    }

    public static void ActNpc347(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
            }
            case 1: {
                npc.ani_no = 0;
                if (MyChar.gMC.y >= npc.y + 65536 || MyChar.gMC.y <= npc.y - 65536) break;
                npc.act_no = 10;
                npc.act_wait = 0;
                npc.ani_no = 1;
                break;
            }
            case 10: {
                if (++npc.act_wait == 4) {
                    npc.ani_no = 2;
                }
                if (npc.act_wait <= 12) break;
                npc.act_no = 12;
                npc.xm = 1792;
                Sound.PlaySoundObject(6, 1);
                npc.ani_no = 3;
                break;
            }
            case 12: {
                npc.ym = MyChar.gMC.y < npc.y ? -170 : 170;
                if ((npc.flag & 1) != 0) {
                    npc.act_no = 13;
                    npc.act_wait = 0;
                    npc.ani_no = 2;
                    npc.xm = 0;
                    npc.ym = 0;
                    break;
                }
                npc.xm -= 42;
                if (npc.xm < -1535) {
                    npc.xm = -1535;
                }
                npc.x += npc.xm;
                npc.y += npc.ym;
                break;
            }
            case 13: {
                ++npc.act_wait;
                if (npc.act_wait == 2) {
                    npc.ani_no = 1;
                }
                if (npc.act_wait == 6) {
                    npc.ani_no = 0;
                }
                if (npc.act_wait <= 16) break;
                npc.act_no = 1;
            }
        }
        npc.rect.copyFrom(ActNpc347_rc[npc.ani_no]);
    }

    public static void ActNpc348(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
            }
            case 1: {
                if (++npc.act_wait < 128) {
                    npc.y -= 128;
                    if (npc.act_wait / 2 % 2 != 0) {
                        npc.ani_no = 1;
                        break;
                    }
                    npc.ani_no = 0;
                    break;
                }
                npc.act_no = 10;
                npc.ani_no = 0;
                npc.damage = 2;
            }
        }
        npc.rect.copyFrom(ActNpc348_rc[npc.ani_no]);
    }

    public static void ActNpc349(NpChar.NPCHAR npc) {
        if (npc.act_no == 0) {
            npc.act_no = 1;
            if (npc.direct == 0) {
                npc.x += 4096;
            }
            if (npc.direct == 2) {
                npc.y += 8192;
            }
        }
        npc.rect.copyFrom(ActNpc349_rect);
    }

    public static void ActNpc350(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
                npc.tgt_x = npc.direct == 0 ? npc.x - 65536 : npc.x + 65536;
                npc.tgt_y = npc.y;
                npc.ym = Game.Random(-512, 512) * 2;
                npc.xm = Game.Random(-512, 512) * 2;
            }
            case 1: {
                if (++npc.ani_wait > 1) {
                    npc.ani_wait = 0;
                    if (++npc.ani_no > 1) {
                        npc.ani_no = 0;
                    }
                }
                if (npc.direct == 0) {
                    if (npc.x >= npc.tgt_x) break;
                    npc.act_no = 20;
                    break;
                }
                if (npc.x <= npc.tgt_x) break;
                npc.act_no = 20;
                break;
            }
            case 20: {
                npc.act_no = 21;
                npc.act_wait = Game.Random(0, 150);
                npc.ani_no = 2;
                npc.ani_wait = 0;
            }
            case 21: {
                if (++npc.ani_wait > 2) {
                    npc.ani_wait = 0;
                    if (++npc.ani_no > 3) {
                        npc.ani_no = 2;
                    }
                }
                if (++npc.act_wait > 300) {
                    npc.act_no = 30;
                }
                if (MyChar.gMC.x >= npc.x + 57344 || MyChar.gMC.x <= npc.x - 57344 || MyChar.gMC.y >= npc.y + 8192 || MyChar.gMC.y <= npc.y - 8192) break;
                npc.act_no = 30;
                break;
            }
            case 30: {
                npc.act_no = 31;
                npc.act_wait = 0;
                npc.ani_wait = 0;
            }
            case 31: {
                npc.ani_no = ++npc.ani_wait / 2 % 2 != 0 ? 3 : 4;
                if (++npc.act_wait <= 30) break;
                npc.act_no = 40;
                npc.ani_no = 5;
                if (npc.direct == 0) {
                    NpChar.SetNpChar(312, npc.x, npc.y, -2048, 0, 0, null, 409);
                    break;
                }
                NpChar.SetNpChar(312, npc.x, npc.y, 2048, 0, 2, null, 409);
                break;
            }
            case 40: {
                npc.act_no = 41;
                npc.act_wait = 0;
                npc.ani_wait = 0;
            }
            case 41: {
                if (++npc.ani_wait > 2) {
                    npc.ani_wait = 0;
                    if (++npc.ani_no > 6) {
                        npc.ani_no = 5;
                    }
                }
                if (++npc.act_wait <= 40) break;
                npc.act_no = 50;
                npc.ani_no = 0;
                npc.xm = 0;
                npc.ym = 0;
                break;
            }
            case 50: {
                if (++npc.ani_wait > 1) {
                    npc.ani_wait = 0;
                    if (++npc.ani_no > 1) {
                        npc.ani_no = 0;
                    }
                }
                npc.xm = npc.direct == 0 ? (npc.xm -= 32) : (npc.xm += 32);
                if (npc.x >= 0 && npc.x <= Map.gMap.width * 512 * 16) break;
                NpChar.VanishNpChar(npc);
                return;
            }
        }
        if (npc.act_no < 50) {
            if (npc.x < npc.tgt_x) {
                npc.xm += 42;
            }
            if (npc.x > npc.tgt_x) {
                npc.xm -= 42;
            }
            if (npc.y < npc.tgt_y) {
                npc.ym += 42;
            }
            if (npc.y > npc.tgt_y) {
                npc.ym -= 42;
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
        }
        npc.x += npc.xm;
        npc.y += npc.ym;
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc350_rcLeft[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc350_rcRight[npc.ani_no]);
        }
    }

    public static void ActNpc351(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
                npc.ani_no = npc.direct / 10;
                npc.x += 4096;
                npc.y += 6144;
                break;
            }
            case 10: {
                if (Flags.GetNPCFlag(npc.code_flag)) {
                    npc.act_no = 20;
                } else {
                    npc.act_no = 11;
                    npc.bits = (char)(npc.bits | 0x20);
                }
            }
            case 11: {
                if (npc.life > 900) break;
                NpChar.SetNpChar(351, npc.x - 4096, npc.y - 6144, 0, 0, (npc.ani_no + 4) * 10, null, 0);
                npc.cond = (byte)(npc.cond | 8);
                break;
            }
            case 20: {
                npc.ani_no += 4;
                npc.act_no = 1;
            }
        }
        npc.rect.copyFrom(ActNpc351_rc[npc.ani_no]);
    }

    public static void ActNpc352(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
                npc.ani_no = 0;
                npc.count1 = npc.direct / 100;
                npc.direct %= 100;
                switch (npc.count1) {
                    case 7: 
                    case 8: 
                    case 9: 
                    case 12: 
                    case 13: {
                        npc.surf = 21;
                    }
                }
                switch (npc.count1) {
                    case 2: 
                    case 4: 
                    case 9: 
                    case 12: {
                        npc.view.top = 8192;
                    }
                }
                if (npc.count1 == 9) {
                    npc.view.back = 10240;
                    npc.view.front = 10240;
                    npc.x -= 512;
                }
                if (npc.count1 == 0) {
                    NpChar.SetNpChar(145, 0, 0, 0, 0, 2, npc, 256);
                }
            }
            case 1: {
                npc.ym += 64;
                if (npc.ym > 1535) {
                    npc.ym = 1535;
                }
                if ((npc.flag & 8) != 0) {
                    npc.ym = 0;
                    npc.act_no = 2;
                    npc.ani_no = 1;
                }
                npc.y += npc.ym;
            }
        }
        npc.rect.copyFrom(ActNpc352_rc[npc.ani_no + npc.count1 * 2]);
    }

    public static void ActNpc353(NpChar.NPCHAR npc) {
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
                    }
                }
            }
            case 1: {
                ++npc.act_wait;
                if (npc.act_wait == 8) {
                    npc.bits = (char)(npc.bits & 0xFFFFFFF7);
                }
                npc.x += npc.xm;
                npc.y += npc.ym;
                if (npc.act_wait == 16) {
                    npc.act_no = 10;
                }
                if (++npc.ani_wait > 2) {
                    npc.ani_wait = 0;
                    if (++npc.ani_no > 3) {
                        npc.ani_no = 0;
                    }
                }
                npc.rect.copyFrom(ActNpc353_rc[npc.ani_no]);
                break;
            }
            case 10: {
                npc.act_no = 11;
                npc.ani_no = 0;
                npc.bits = (char)(npc.bits | 0x20);
                npc.bits = (char)(npc.bits & 0xFFFFFFF7);
                npc.damage = 5;
                npc.view.top = 4096;
            }
            case 11: {
                npc.direct = npc.x > MyChar.gMC.x ? 0 : 2;
                npc.xm2 = MyChar.gMC.y - 12288 > npc.y ? (npc.direct == 0 ? (npc.xm2 += 16) : (npc.xm2 -= 16)) : (npc.direct == 0 ? (npc.xm2 -= 16) : (npc.xm2 += 16));
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
                    if (++npc.ani_no > 1) {
                        npc.ani_no = 0;
                    }
                }
                if (npc.direct == 0) {
                    npc.rect.copyFrom(ActNpc353_rcLeft[npc.ani_no]);
                    break;
                }
                npc.rect.copyFrom(ActNpc353_rcRight[npc.ani_no]);
            }
        }
    }

    public static void ActNpc354(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.hit.bottom = 143360;
                break;
            }
            case 10: {
                npc.act_no = 11;
                npc.act_wait = 0;
                npc.x = npc.direct == 0 ? (npc.x += 8192) : (npc.x -= 8192);
            }
            case 11: {
                if (++npc.act_wait <= 100) break;
                npc.act_wait = 0;
                Frame.SetQuake(20);
                Sound.PlaySoundObject(26, 1);
                Sound.PlaySoundObject(12, 1);
                npc.x = npc.direct == 0 ? (npc.x -= 8192) : (npc.x += 8192);
                for (int i = 0; i < 20; ++i) {
                    int x = npc.x / 512 / 16;
                    int y = npc.y / 512 / 16 + i;
                    Map.ChangeMapParts(x, y, (byte)109);
                }
                break;
            }
        }
    }

    public static void ActNpc355(NpChar.NPCHAR npc) {
        block0 : switch (npc.act_no) {
            case 0: {
                switch (npc.direct) {
                    case 0: {
                        npc.surf = 16;
                        npc.ani_no = 0;
                        npc.x = npc.pNpc.x - 7168;
                        npc.y = npc.pNpc.y + 5120;
                        break block0;
                    }
                    case 1: {
                        npc.surf = 23;
                        npc.ani_no = 1;
                        npc.x = npc.pNpc.x + 7168;
                        npc.y = npc.pNpc.y + 5120;
                        break block0;
                    }
                    case 2: {
                        npc.surf = 16;
                        npc.ani_no = 2;
                        npc.x = npc.pNpc.x - 3584;
                        npc.y = npc.pNpc.y - 9728;
                        break block0;
                    }
                    case 3: {
                        npc.surf = 23;
                        npc.ani_no = 3;
                        npc.x = npc.pNpc.x + 2048;
                        npc.y = npc.pNpc.y - 9728;
                    }
                }
            }
        }
        npc.rect.copyFrom(ActNpc355_rc[npc.ani_no]);
    }

    public static void ActNpc356(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 11;
                npc.ani_wait = 0;
                npc.tgt_y = npc.y - 8192;
                npc.tgt_x = npc.x - 3072;
                npc.ym = 0;
                NpChar.SetNpChar(355, 0, 0, 0, 0, 3, npc, 170);
                NpChar.SetNpChar(355, 0, 0, 0, 0, 2, npc, 170);
            }
            case 11: {
                npc.xm = npc.x < npc.tgt_x ? (npc.xm += 8) : (npc.xm -= 8);
                npc.ym = npc.y < npc.tgt_y ? (npc.ym += 8) : (npc.ym -= 8);
                npc.x += npc.xm;
                npc.y += npc.ym;
                break;
            }
            case 20: {
                npc.act_no = 21;
                npc.xm = -1024;
                npc.ym = 512;
            }
            case 21: {
                ++npc.ani_wait;
                npc.xm += 16;
                npc.ym -= 8;
                npc.x += npc.xm;
                npc.y += npc.ym;
                if (npc.x <= 491520) break;
                npc.act_no = 22;
                break;
            }
            case 22: {
                npc.xm = 0;
                npc.ym = 0;
            }
        }
        if (++npc.ani_wait > 4) {
            npc.ani_wait = 0;
            ++npc.ani_no;
        }
        if (npc.ani_no > 1) {
            npc.ani_no = 0;
        }
        npc.rect.copyFrom(ActNpc356_rcRight[npc.ani_no]);
    }

    public static void ActNpc357(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.rect.copyFrom(ActNpc357_rc);
                ++npc.act_wait;
                break;
            }
            case 10: {
                npc.act_wait = 0;
                npc.act_no = 11;
                Sound.PlaySoundObject(29, 1);
            }
            case 11: {
                ++npc.act_wait;
                npc.rect.copyFrom(ActNpc357_rc);
                if (npc.act_wait / 2 % 2 != 0) {
                    npc.rect.right = npc.rect.left;
                }
                if (npc.act_wait <= 50) break;
                npc.cond = 0;
            }
        }
        if (npc.act_wait % 8 == 1) {
            Caret.SetCaret(npc.x + Game.Random(-8, 8) * 512, npc.y + 4096, 13, 1);
        }
    }

    public static void ActNpc358(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                if (++npc.ani_wait > 6) {
                    npc.ani_wait = 0;
                    ++npc.ani_no;
                }
                if (npc.ani_no <= 1) break;
                npc.ani_no = 0;
                break;
            }
            case 10: {
                if (++npc.ani_wait > 6) {
                    npc.ani_wait = 0;
                    ++npc.ani_no;
                }
                if (npc.ani_no <= 4) break;
                npc.ani_no = 3;
            }
        }
        npc.rect.copyFrom(ActNpc358_rc[npc.ani_no]);
    }

    public static void ActNpc359(NpChar.NPCHAR npc) {
        if (MyChar.gMC.x < npc.x + 163840 && MyChar.gMC.x > npc.x - 163840 && MyChar.gMC.y < npc.y + 163840 && MyChar.gMC.y > npc.y - 81920 && Game.Random(0, 100) == 2) {
            int x = npc.x + Game.Random(-6, 6) * 512;
            NpChar.SetNpChar(73, x, npc.y - 3584, 0, 0, 0, null, 0);
        }
    }

    public static void ActNpc360(NpChar.NPCHAR npc) {
        if (npc.act_no == 0) {
            ++npc.act_no;
            npc.x -= 4096;
            npc.y -= 4096;
        }
        npc.rect.copyFrom(ActNpc360_rc);
    }
}
