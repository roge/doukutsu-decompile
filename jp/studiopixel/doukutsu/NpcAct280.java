/*
 * Decompiled with CFR 0.152.
 */
package jp.studiopixel.doukutsu;

import jp.studiopixel.doukutsu.Boss;
import jp.studiopixel.doukutsu.Frame;
import jp.studiopixel.doukutsu.Game;
import jp.studiopixel.doukutsu.Map;
import jp.studiopixel.doukutsu.MyChar;
import jp.studiopixel.doukutsu.NpChar;
import jp.studiopixel.doukutsu.RECT;
import jp.studiopixel.doukutsu.Sound;
import jp.studiopixel.doukutsu.Triangle;

public class NpcAct280 {
    private static final RECT[] ActNpc280_rcLeft = new RECT[]{new RECT(112, 32, 128, 48), new RECT(144, 32, 160, 48)};
    private static final RECT[] ActNpc280_rcRight = new RECT[]{new RECT(112, 48, 128, 64), new RECT(144, 48, 160, 64)};
    private static final RECT ActNpc281_rc = new RECT(0, 0, 0, 0);
    private static final RECT[] ActNpc282_tc = new RECT[]{new RECT(256, 80, 320, 120), new RECT(256, 0, 320, 40), new RECT(256, 120, 320, 160)};
    private static final RECT[] ActNpc283_rcLeft = new RECT[]{new RECT(0, 64, 32, 96), new RECT(32, 64, 64, 96), new RECT(64, 64, 96, 96), new RECT(96, 64, 128, 96), new RECT(128, 64, 160, 96), new RECT(160, 64, 192, 96), new RECT(192, 64, 224, 96), new RECT(224, 64, 256, 96), new RECT(0, 0, 0, 0), new RECT(256, 64, 288, 96), new RECT(288, 64, 320, 96)};
    private static final RECT[] ActNpc283_rcRight = new RECT[]{new RECT(0, 96, 32, 128), new RECT(32, 96, 64, 128), new RECT(64, 96, 96, 128), new RECT(96, 96, 128, 128), new RECT(128, 96, 160, 128), new RECT(160, 96, 192, 128), new RECT(192, 96, 224, 128), new RECT(224, 96, 256, 128), new RECT(0, 0, 0, 0), new RECT(256, 96, 288, 128), new RECT(288, 96, 320, 128)};
    private static final RECT[] ActNpc284_rcLeft = new RECT[]{new RECT(0, 128, 32, 160), new RECT(32, 128, 64, 160), new RECT(64, 128, 96, 160), new RECT(96, 128, 128, 160), new RECT(128, 128, 160, 160), new RECT(160, 128, 192, 160), new RECT(192, 128, 224, 160), new RECT(224, 128, 256, 160), new RECT(0, 0, 0, 0), new RECT(256, 128, 288, 160), new RECT(288, 128, 320, 160), new RECT(224, 64, 256, 96), new RECT(208, 32, 224, 48)};
    private static final RECT[] ActNpc284_rcRight = new RECT[]{new RECT(0, 160, 32, 192), new RECT(32, 160, 64, 192), new RECT(64, 160, 96, 192), new RECT(96, 160, 128, 192), new RECT(128, 160, 160, 192), new RECT(160, 160, 192, 192), new RECT(192, 160, 224, 192), new RECT(224, 160, 256, 192), new RECT(0, 0, 0, 0), new RECT(256, 160, 288, 192), new RECT(288, 160, 320, 192), new RECT(224, 96, 256, 128), new RECT(208, 48, 224, 64)};
    private static final RECT ActNpc285_rc = new RECT(232, 104, 248, 120);
    private static final RECT[] ActNpc286_rc = new RECT[]{new RECT(232, 120, 248, 136), new RECT(232, 136, 248, 152), new RECT(232, 152, 248, 168)};
    private static final RECT[] ActNpc287_rcLeft = new RECT[]{new RECT(0, 224, 16, 240), new RECT(16, 224, 32, 240), new RECT(32, 224, 48, 240), new RECT(48, 224, 64, 240), new RECT(64, 224, 80, 240), new RECT(80, 224, 96, 240), new RECT(96, 224, 112, 240)};
    private static final RECT[] ActNpc288_rc = new RECT[]{new RECT(232, 72, 248, 88), new RECT(232, 88, 248, 104), new RECT(232, 0, 256, 24), new RECT(232, 24, 256, 48), new RECT(232, 48, 256, 72)};
    private static final RECT[] ActNpc289_rcLeft = new RECT[]{new RECT(160, 32, 176, 48), new RECT(176, 32, 192, 48), new RECT(192, 32, 208, 48)};
    private static final RECT[] ActNpc289_rcRight = new RECT[]{new RECT(160, 48, 176, 64), new RECT(176, 48, 192, 64), new RECT(192, 48, 208, 64)};
    private static final RECT[] ActNpc290_rcLeft = new RECT[]{new RECT(112, 32, 128, 48), new RECT(128, 32, 144, 48), new RECT(144, 32, 160, 48)};
    private static final RECT[] ActNpc290_rcRight = new RECT[]{new RECT(112, 48, 128, 64), new RECT(128, 48, 144, 64), new RECT(144, 48, 160, 64)};
    private static final RECT[] ActNpc291_tc = new RECT[]{new RECT(256, 80, 320, 120), new RECT(256, 0, 320, 40)};
    private static final RECT[] ActNpc293_rect = new RECT[]{new RECT(240, 200, 280, 240), new RECT(280, 200, 320, 240)};
    private static final RECT[] ActNpc295_rc = new RECT[]{new RECT(0, 0, 208, 64), new RECT(32, 64, 144, 96), new RECT(32, 96, 104, 128), new RECT(104, 96, 144, 128)};
    private static final RECT ActNpc297_rc = new RECT(112, 48, 128, 64);
    private static final RECT[] ActNpc298_rc = new RECT[]{new RECT(72, 128, 88, 160), new RECT(88, 128, 104, 160), new RECT(104, 128, 120, 160), new RECT(72, 128, 88, 160), new RECT(120, 128, 136, 160), new RECT(72, 128, 88, 160), new RECT(104, 160, 120, 192), new RECT(120, 160, 136, 192)};
    private static final RECT[] ActNpc299_rc = new RECT[]{new RECT(0, 0, 48, 48), new RECT(48, 0, 96, 48)};

    public static void ActNpc280(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
                npc.ani_no = 0;
                npc.ani_wait = 0;
                npc.x += 3072;
                npc.tgt_x = npc.x;
                Sound.PlaySoundObject(29, 1);
            }
            case 1: {
                if (++npc.act_wait != 64) break;
                npc.act_no = 2;
                npc.act_wait = 0;
                break;
            }
            case 2: {
                npc.ani_no = 0;
                if ((npc.flag & 8) == 0) break;
                npc.act_no = 4;
                npc.act_wait = 0;
                npc.ani_no = 1;
                Sound.PlaySoundObject(23, 1);
            }
        }
        if (npc.act_no > 1) {
            npc.ym += 32;
            if (npc.ym > 1535) {
                npc.ym = 1535;
            }
            npc.y += npc.ym;
        }
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc280_rcLeft[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc280_rcRight[npc.ani_no]);
        }
        if (npc.act_no == 1) {
            npc.rect.bottom = npc.rect.top + npc.act_wait / 4;
            npc.x = npc.act_wait / 2 % 2 != 0 ? npc.tgt_x : npc.tgt_x + 512;
        }
    }

    public static void ActNpc281(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
                break;
            }
            case 10: {
                npc.act_no = 11;
                npc.act_wait = 0;
            }
            case 11: {
                ++npc.act_wait;
                NpChar.SetNpChar(270, npc.x, npc.y + 65536, 0, 0, 2, npc, 256);
                if (npc.act_wait <= 150) break;
                npc.act_no = 12;
                break;
            }
            case 20: {
                npc.act_no = 21;
                npc.act_wait = 0;
            }
            case 21: {
                if (++npc.act_wait <= 250) break;
                NpChar.DeleteNpCharCode(270, false);
                npc.act_no = 22;
            }
        }
        npc.rect.copyFrom(ActNpc281_rc);
    }

    public static void ActNpc282(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 20;
                npc.tgt_y = npc.y;
                npc.ym = Game.Random(0, 100) % 2 != 0 ? -256 : 256;
            }
            case 20: {
                npc.xm = -512;
                if (npc.x < Short.MIN_VALUE) {
                    npc.cond = 0;
                }
                if (npc.tgt_y < npc.y) {
                    npc.ym -= 16;
                }
                if (npc.tgt_y > npc.y) {
                    npc.ym += 16;
                }
                if (npc.ym > 256) {
                    npc.ym = 256;
                }
                if (npc.ym < -256) {
                    npc.ym = -256;
                }
                if ((MyChar.gMC.flag & 8) != 0 && MyChar.gMC.y < npc.y - 2048 && MyChar.gMC.x > npc.x - 12288 && MyChar.gMC.x < npc.x + 12288) {
                    npc.tgt_y = 73728;
                    npc.ani_no = 2;
                } else if (npc.ani_no != 1) {
                    npc.ani_no = 0;
                }
                if ((MyChar.gMC.flag & 1) != 0 && MyChar.gMC.x < npc.x - npc.hit.back && MyChar.gMC.x > npc.x - npc.hit.back - 4096 && MyChar.gMC.y + MyChar.gMC.hit.bottom > npc.y - npc.hit.top && MyChar.gMC.y - MyChar.gMC.hit.top < npc.y + npc.hit.bottom) {
                    npc.bits = (char)(npc.bits & 0xFFFFFFBF);
                    npc.ani_no = 1;
                    break;
                }
                if ((MyChar.gMC.flag & 4) != 0 && MyChar.gMC.x > npc.x + npc.hit.back && MyChar.gMC.x < npc.x + npc.hit.back + 4096 && MyChar.gMC.y + MyChar.gMC.hit.bottom > npc.y - npc.hit.top && MyChar.gMC.y - MyChar.gMC.hit.top < npc.y + npc.hit.bottom) {
                    npc.bits = (char)(npc.bits & 0xFFFFFFBF);
                    npc.ani_no = 1;
                    break;
                }
                if ((MyChar.gMC.flag & 2) != 0 && MyChar.gMC.y < npc.y - npc.hit.top && MyChar.gMC.y > npc.y - npc.hit.top - 4096 && MyChar.gMC.x + MyChar.gMC.hit.front > npc.x - npc.hit.back && MyChar.gMC.x - MyChar.gMC.hit.back < npc.x + npc.hit.front) {
                    npc.bits = (char)(npc.bits & 0xFFFFFFBF);
                    npc.ani_no = 1;
                    break;
                }
                if ((MyChar.gMC.flag & 8) == 0 || MyChar.gMC.y <= npc.y + npc.hit.bottom - 2048 || MyChar.gMC.y >= npc.y + npc.hit.bottom + 6144 || MyChar.gMC.x + MyChar.gMC.hit.front <= npc.x - npc.hit.back - 2048 || MyChar.gMC.x - MyChar.gMC.hit.back >= npc.x + npc.hit.front + 2048) break;
                npc.bits = (char)(npc.bits & 0xFFFFFFBF);
                npc.ani_no = 1;
            }
        }
        npc.x += npc.xm;
        npc.y += npc.ym;
        npc.rect.copyFrom(ActNpc282_tc[npc.ani_no]);
    }

    public static void ActNpc283(NpChar.NPCHAR npc) {
        int direct = 0;
        if (npc.act_no < 100 && (Boss.gBoss[0].cond == 0 || npc.life < 400)) {
            npc.act_no = 100;
        }
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
                npc.y -= 4096;
                Sound.PlaySoundObject(29, 1);
            }
            case 1: {
                if (++npc.act_wait / 2 % 2 != 0) {
                    npc.ani_no = 9;
                    break;
                }
                npc.ani_no = 0;
                break;
            }
            case 10: {
                npc.act_no = 11;
                npc.ani_no = 9;
                break;
            }
            case 20: {
                NpChar.gSuperXpos = 0;
                npc.act_no = 21;
                npc.act_wait = 0;
                npc.ani_no = 0;
                npc.ani_wait = 0;
            }
            case 21: {
                npc.xm = 7 * npc.xm / 8;
                npc.ym = 7 * npc.ym / 8;
                if (++npc.ani_wait > 20) {
                    npc.ani_wait = 0;
                    ++npc.ani_no;
                }
                if (npc.ani_no > 1) {
                    npc.ani_no = 0;
                }
                if (++npc.act_wait > 100) {
                    npc.act_no = 30;
                }
                if (npc.x < MyChar.gMC.x) {
                    npc.direct = 2;
                    break;
                }
                npc.direct = 0;
                break;
            }
            case 30: {
                npc.act_no = 31;
                npc.act_wait = 0;
                npc.ani_no = 2;
                npc.count2 = npc.life;
            }
            case 31: {
                if (++npc.ani_wait > 1) {
                    npc.ani_wait = 0;
                    ++npc.ani_no;
                }
                if (npc.ani_no > 3) {
                    npc.ani_no = 2;
                }
                if ((npc.flag & 8) != 0) {
                    npc.ym = -512;
                }
                npc.xm = npc.x > Boss.gBoss[0].x ? (npc.xm -= 32) : (npc.xm += 32);
                npc.ym = npc.y > MyChar.gMC.y ? (npc.ym -= 16) : (npc.ym += 16);
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
                npc.direct = npc.x > MyChar.gMC.x ? 0 : 2;
                if (++npc.act_wait > 150 && (npc.life < npc.count2 - 20 || NpChar.gSuperXpos != 0)) {
                    NpChar.gSuperXpos = 0;
                    npc.act_no = 40;
                }
                if (Boss.gBoss[0].ani_no == 0 || npc.act_wait <= 250) break;
                npc.act_no = 50;
                break;
            }
            case 40: {
                npc.act_no = 41;
                npc.act_wait = 0;
                npc.xm = 0;
                npc.ym = 0;
                npc.direct = npc.x > MyChar.gMC.x ? 0 : 2;
                Sound.PlaySoundObject(103, 1);
                npc.count2 = MyChar.gMC.y < 81920 ? 290 : 289;
            }
            case 41: {
                npc.ani_no = ++npc.act_wait / 2 % 2 != 0 ? 4 : 5;
                if (npc.act_wait % 6 == 1) {
                    int y;
                    int x;
                    if (npc.count2 == 289) {
                        x = npc.x + Game.Random(-64, 64) * 512;
                        y = npc.y + Game.Random(-32, 32) * 512;
                    } else {
                        x = npc.x + Game.Random(-32, 32) * 512;
                        y = npc.y + Game.Random(-64, 64) * 512;
                    }
                    if (x < 16384) {
                        x = 16384;
                    }
                    if (x > (Map.gMap.width - 2) * 512 * 16) {
                        x = (Map.gMap.width - 2) * 512 * 16;
                    }
                    if (y < 16384) {
                        y = 16384;
                    }
                    if (y > (Map.gMap.length - 2) * 512 * 16) {
                        y = (Map.gMap.length - 2) * 512 * 16;
                    }
                    Sound.PlaySoundObject(39, 1);
                    NpChar.SetNpChar(npc.count2, x, y, 0, 0, 0, null, 256);
                }
                if (npc.act_wait <= 50) break;
                npc.act_no = 42;
                npc.act_wait = 0;
                if (npc.x > MyChar.gMC.x) {
                    npc.direct = 0;
                    break;
                }
                npc.direct = 2;
                break;
            }
            case 42: {
                ++npc.act_wait;
                npc.ani_no = 6;
                if (npc.act_wait <= 50) break;
                npc.ym = -512;
                npc.xm = npc.direct == 0 ? 512 : -512;
                npc.act_no = 30;
                break;
            }
            case 50: {
                npc.act_no = 51;
                npc.act_wait = 0;
                npc.xm = 0;
                npc.ym = 0;
                npc.direct = npc.x > MyChar.gMC.x ? 0 : 2;
                Sound.PlaySoundObject(103, 1);
            }
            case 51: {
                npc.ani_no = ++npc.act_wait / 2 % 2 != 0 ? 4 : 5;
                if ((MyChar.gMC.equip & 0x20) != 0) {
                    if (npc.act_wait % 10 == 1) {
                        int y;
                        int x;
                        if (npc.direct == 0) {
                            x = npc.x + 5120;
                            y = npc.y;
                            switch (npc.act_wait / 6 % 4) {
                                case 0: {
                                    direct = 216;
                                    break;
                                }
                                case 1: {
                                    direct = 236;
                                    break;
                                }
                                case 2: {
                                    direct = 20;
                                    break;
                                }
                                case 3: {
                                    direct = 40;
                                }
                            }
                        } else {
                            x = npc.x - 5120;
                            y = npc.y;
                            switch (npc.act_wait / 6 % 4) {
                                case 0: {
                                    direct = 88;
                                    break;
                                }
                                case 1: {
                                    direct = 108;
                                    break;
                                }
                                case 2: {
                                    direct = 148;
                                    break;
                                }
                                case 3: {
                                    direct = 168;
                                }
                            }
                        }
                        Sound.PlaySoundObject(39, 1);
                        NpChar.SetNpChar(301, x, y, 0, 0, direct, null, 256);
                    }
                } else if (npc.act_wait % 24 == 1) {
                    int y;
                    int x;
                    if (npc.direct == 0) {
                        x = npc.x + 5120;
                        y = npc.y;
                        switch (npc.act_wait / 6 % 4) {
                            case 0: {
                                direct = 216;
                                break;
                            }
                            case 1: {
                                direct = 236;
                                break;
                            }
                            case 2: {
                                direct = 20;
                                break;
                            }
                            case 3: {
                                direct = 40;
                            }
                        }
                    } else {
                        x = npc.x - 5120;
                        y = npc.y;
                        switch (npc.act_wait / 6 % 4) {
                            case 0: {
                                direct = 88;
                                break;
                            }
                            case 1: {
                                direct = 108;
                                break;
                            }
                            case 2: {
                                direct = 148;
                                break;
                            }
                            case 3: {
                                direct = 168;
                            }
                        }
                    }
                    Sound.PlaySoundObject(39, 1);
                    NpChar.SetNpChar(301, x, y, 0, 0, direct, null, 256);
                }
                if (npc.act_wait <= 50) break;
                npc.act_no = 42;
                npc.act_wait = 0;
                if (npc.x > MyChar.gMC.x) {
                    npc.direct = 0;
                    break;
                }
                npc.direct = 2;
                break;
            }
            case 99: {
                npc.xm = 0;
                npc.ym = 0;
                npc.ani_no = 9;
                npc.bits = (char)(npc.bits & 0xFFFFFFDF);
                break;
            }
            case 100: {
                npc.act_no = 101;
                npc.ani_no = 9;
                npc.damage = 0;
                npc.bits = (char)(npc.bits & 0xFFFFFFDF);
                npc.bits = (char)(npc.bits | 8);
                npc.ym = -512;
                npc.shock = (char)(npc.shock + 50);
                npc.hit.bottom = 6144;
                ++Boss.gBoss[0].ani_no;
            }
            case 101: {
                npc.ym += 32;
                if (npc.y <= 110592 - npc.hit.bottom) break;
                npc.y = 110592 - npc.hit.bottom;
                npc.act_no = 102;
                npc.ani_no = 10;
                npc.xm = 0;
                npc.ym = 0;
            }
        }
        npc.y += npc.ym;
        npc.x = npc.shock != '\u0000' ? (npc.x += npc.xm / 2) : (npc.x += npc.xm);
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc283_rcLeft[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc283_rcRight[npc.ani_no]);
        }
    }

    public static void ActNpc284(NpChar.NPCHAR npc) {
        if (npc.act_no < 100 && (Boss.gBoss[0].cond == 0 || npc.life < 500)) {
            npc.act_no = 100;
        }
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
                npc.y -= 2048;
                Sound.PlaySoundObject(29, 1);
                npc.count2 = npc.life;
            }
            case 1: {
                if (++npc.act_wait / 2 % 2 != 0) {
                    npc.view.top = 8192;
                    npc.view.back = 8192;
                    npc.view.front = 8192;
                    npc.ani_no = 11;
                } else {
                    npc.view.top = 1536;
                    npc.view.back = 4096;
                    npc.view.front = 4096;
                    npc.ani_no = 12;
                }
                if (npc.act_wait <= 50) break;
                npc.act_no = 10;
                break;
            }
            case 10: {
                npc.act_no = 11;
                npc.ani_no = 11;
                npc.view.top = 8192;
                npc.view.back = 8192;
                npc.view.front = 8192;
                NpChar.DeleteNpCharCode(257, true);
                break;
            }
            case 20: {
                npc.act_no = 21;
                npc.act_wait = 0;
                npc.ani_no = 0;
                npc.ani_wait = 0;
                npc.damage = 0;
                npc.bits = (char)(npc.bits | 0x20);
                npc.bits = (char)(npc.bits & 0xFFFFFFF7);
            }
            case 21: {
                npc.xm = npc.xm * 7 / 8;
                npc.ym = npc.ym * 7 / 8;
                if (++npc.ani_wait > 20) {
                    npc.ani_wait = 0;
                    ++npc.ani_no;
                }
                if (npc.ani_no > 1) {
                    npc.ani_no = 0;
                }
                if (++npc.act_wait > 80) {
                    npc.act_no = 30;
                }
                npc.direct = npc.x < MyChar.gMC.x ? 2 : 0;
                if (npc.life >= npc.count2 - 50) break;
                npc.count2 = npc.life;
                NpChar.gSuperXpos = 10;
                break;
            }
            case 30: {
                npc.act_no = 31;
                npc.act_wait = 0;
                npc.ani_no = 2;
                npc.xm = 0;
                npc.ym = 0;
            }
            case 31: {
                if (++npc.act_wait <= 16) break;
                ++npc.count1;
                npc.count1 %= 4;
                switch (npc.count1) {
                    case 1: 
                    case 3: {
                        npc.act_no = 34;
                        break;
                    }
                    case 0: {
                        npc.act_no = 32;
                        break;
                    }
                    case 2: {
                        npc.act_no = 32;
                    }
                }
                break;
            }
            case 32: {
                npc.act_no = 33;
                npc.act_wait = 0;
                npc.bits = (char)(npc.bits & 0xFFFFFFDF);
                npc.tgt_x = MyChar.gMC.x < npc.x ? MyChar.gMC.x - 81920 : MyChar.gMC.x + 81920;
                npc.tgt_y = MyChar.gMC.y;
                char deg = (char)Triangle.GetArktan(npc.x - npc.tgt_x, npc.y - npc.tgt_y);
                npc.xm = 3 * Triangle.GetCos(deg);
                npc.ym = 3 * Triangle.GetSin(deg);
                npc.bits = (char)(npc.bits & 0xFFFFFFF7);
                if (npc.x < Map.gMap.width * 512 * 16 / 2 && npc.xm > 0) {
                    if (npc.y < Map.gMap.length * 512 * 16 / 2 && npc.ym > 0) {
                        npc.bits = (char)(npc.bits | 8);
                    }
                    if (npc.y > Map.gMap.length * 512 * 16 / 2 && npc.ym < 0) {
                        npc.bits = (char)(npc.bits | 8);
                    }
                }
                if (npc.x > Map.gMap.width * 512 * 16 / 2 && npc.xm < 0) {
                    if (npc.y < Map.gMap.length * 512 * 16 / 2 && npc.ym > 0) {
                        npc.bits = (char)(npc.bits | 8);
                    }
                    if (npc.y > Map.gMap.length * 512 * 16 / 2 && npc.ym < 0) {
                        npc.bits = (char)(npc.bits | 8);
                    }
                }
                npc.direct = npc.xm > 0 ? 2 : 0;
            }
            case 33: {
                npc.ani_no = ++npc.act_wait / 2 % 2 != 0 ? 3 : 8;
                if (npc.act_wait <= 50 && (npc.flag & 5) == 0) break;
                npc.act_no = 20;
                break;
            }
            case 34: {
                npc.act_no = 35;
                npc.act_wait = 0;
                npc.damage = 4;
                npc.tgt_x = MyChar.gMC.x;
                npc.tgt_y = MyChar.gMC.y;
                char deg = (char)Triangle.GetArktan(npc.x - npc.tgt_x, npc.y - npc.tgt_y);
                npc.ym = 3 * Triangle.GetSin(deg);
                npc.xm = 3 * Triangle.GetCos(deg);
                npc.bits = (char)(npc.bits & 0xFFFFFFF7);
                if (npc.x < Map.gMap.width * 512 * 16 / 2 && npc.xm > 0) {
                    if (npc.y < Map.gMap.length * 512 * 16 / 2 && npc.ym > 0) {
                        npc.bits = (char)(npc.bits | 8);
                    }
                    if (npc.y > Map.gMap.length * 512 * 16 / 2 && npc.ym < 0) {
                        npc.bits = (char)(npc.bits | 8);
                    }
                }
                if (npc.x > Map.gMap.width * 512 * 16 / 2 && npc.xm < 0) {
                    if (npc.y < Map.gMap.length * 512 * 16 / 2 && npc.ym > 0) {
                        npc.bits = (char)(npc.bits | 8);
                    }
                    if (npc.y > Map.gMap.length * 512 * 16 / 2 && npc.ym < 0) {
                        npc.bits = (char)(npc.bits | 8);
                    }
                }
                npc.direct = npc.xm > 0 ? 2 : 0;
            }
            case 35: {
                if (++npc.act_wait > 20 && npc.shock != '\u0000') {
                    npc.act_no = 40;
                } else if (npc.act_wait > 50 || (npc.flag & 5) != 0) {
                    npc.act_no = 20;
                }
                if (++npc.ani_wait > 1) {
                    npc.ani_wait = 0;
                    ++npc.ani_no;
                }
                if (npc.ani_no > 7) {
                    npc.ani_no = 4;
                }
                if (npc.act_wait % 5 != 1) break;
                Sound.PlaySoundObject(109, 1);
                break;
            }
            case 40: {
                npc.act_no = 41;
                npc.act_wait = 0;
                npc.ani_no = 2;
                npc.damage = 0;
                npc.bits = (char)(npc.bits & 0xFFFFFFF7);
            }
            case 41: {
                npc.xm = npc.xm * 7 / 8;
                npc.ym = npc.ym * 7 / 8;
                if (++npc.act_wait <= 6) break;
                npc.act_no = 42;
                npc.act_wait = 0;
                npc.ym = -512;
                if (npc.direct == 0) {
                    npc.xm = 512;
                    break;
                }
                npc.xm = -512;
                break;
            }
            case 42: {
                npc.ani_no = 9;
                if ((npc.flag & 8) != 0) {
                    npc.act_no = 43;
                    npc.act_wait = 0;
                    npc.ani_no = 2;
                    npc.direct = npc.x < MyChar.gMC.x ? 2 : 0;
                }
                npc.ym += 32;
                if (npc.ym <= 1535) break;
                npc.ym = 1535;
                break;
            }
            case 43: {
                if (++npc.act_wait <= 16) break;
                npc.act_no = 20;
                break;
            }
            case 99: {
                npc.xm = 0;
                npc.ym = 0;
                npc.ani_no = 9;
                npc.bits = (char)(npc.bits & 0xFFFFFFDF);
                break;
            }
            case 100: {
                npc.act_no = 101;
                npc.ani_no = 9;
                npc.damage = 0;
                npc.bits = (char)(npc.bits & 0xFFFFFFDF);
                npc.bits = (char)(npc.bits | 8);
                npc.ym = -512;
                npc.shock = (char)(npc.shock + 50);
                ++Boss.gBoss[0].ani_no;
            }
            case 101: {
                npc.ym += 32;
                if (npc.y <= 110592 - npc.hit.bottom) break;
                npc.y = 110592 - npc.hit.bottom;
                npc.act_no = 102;
                npc.ani_no = 10;
                npc.xm = 0;
                npc.ym = 0;
            }
        }
        npc.y += npc.ym;
        npc.x = npc.shock != '\u0000' ? (npc.x += npc.xm / 2) : (npc.x += npc.xm);
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc284_rcLeft[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc284_rcRight[npc.ani_no]);
        }
    }

    public static void ActNpc285(NpChar.NPCHAR npc) {
        if (npc.x < 0 || npc.x > Map.gMap.width * 16 * 512) {
            NpChar.VanishNpChar(npc);
            return;
        }
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
                npc.tgt_x = npc.x;
                npc.tgt_y = npc.y;
                npc.count1 = npc.direct / 8;
                npc.direct %= 8;
            }
            case 1: {
                npc.count1 += 24;
                npc.count1 %= 256;
                char deg = (char)npc.count1;
                if (npc.act_wait < 128) {
                    ++npc.act_wait;
                }
                npc.xm = npc.direct == 0 ? (npc.xm -= 21) : (npc.xm += 21);
                npc.tgt_x += npc.xm;
                npc.x = npc.tgt_x + Triangle.GetCos(deg) * 4;
                npc.y = npc.tgt_y + Triangle.GetSin(deg) * 6;
                NpChar.SetNpChar(286, npc.x, npc.y, 0, 0, 0, null, 256);
            }
        }
        npc.rect.copyFrom(ActNpc285_rc);
    }

    public static void ActNpc286(NpChar.NPCHAR npc) {
        if (++npc.ani_wait > 0) {
            npc.ani_wait = 0;
            ++npc.ani_no;
        }
        if (npc.ani_no > 2) {
            npc.cond = 0;
        } else {
            npc.rect.copyFrom(ActNpc286_rc[npc.ani_no]);
        }
    }

    public static void ActNpc287(NpChar.NPCHAR npc) {
        if (npc.act_no == 0) {
            npc.xm = Game.Random(-4, 4) * 512;
            npc.act_no = 1;
        } else {
            npc.xm = npc.xm * 20 / 21;
            npc.ym = npc.ym * 20 / 21;
            npc.x += npc.xm;
            npc.y += npc.ym;
        }
        if (++npc.ani_wait > 1) {
            npc.ani_wait = 0;
            ++npc.ani_no;
        }
        if (npc.ani_no > 6) {
            npc.cond = 0;
        } else {
            npc.rect.copyFrom(ActNpc287_rcLeft[npc.ani_no]);
        }
    }

    public static void ActNpc288(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
                npc.xm = -512;
            }
            case 1: {
                if (npc.direct == 1) {
                    npc.ym -= 32;
                    if (npc.ym < -1535) {
                        npc.ym = -1535;
                    }
                    if ((npc.flag & 2) != 0) {
                        npc.act_no = 2;
                    }
                } else if (npc.direct == 3) {
                    npc.ym += 32;
                    if (npc.ym > 1535) {
                        npc.ym = 1535;
                    }
                    if ((npc.flag & 8) != 0) {
                        npc.act_no = 2;
                    }
                }
                if (++npc.ani_wait > 3) {
                    npc.ani_wait = 0;
                    ++npc.ani_no;
                }
                if (npc.ani_no <= 1) break;
                npc.ani_no = 0;
                break;
            }
            case 2: {
                Sound.PlaySoundObject(44, 1);
                npc.act_no = 3;
                npc.act_wait = 0;
                npc.bits = (char)(npc.bits | 8);
                npc.ym = 0;
                npc.xm = npc.x > MyChar.gMC.x ? -1024 : 1024;
                npc.view.back = 6144;
                npc.view.front = 6144;
                npc.view.top = 6144;
                npc.view.bottom = 6144;
            }
            case 3: {
                if (++npc.ani_no > 4) {
                    npc.ani_no = 2;
                }
                if (++npc.act_wait % 4 == 1) {
                    if (npc.direct == 1) {
                        NpChar.SetNpChar(287, npc.x, npc.y, 0, 1024, 0, null, 256);
                    } else {
                        NpChar.SetNpChar(287, npc.x, npc.y, 0, -1024, 0, null, 256);
                    }
                }
                if (npc.x >= 8192 && npc.x <= Map.gMap.width * 512 * 16 - 8192) break;
                npc.cond = 0;
            }
        }
        npc.x += npc.xm;
        npc.y += npc.ym;
        npc.rect.copyFrom(ActNpc288_rc[npc.ani_no]);
    }

    public static void ActNpc289(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
                npc.ani_no = 2;
                npc.direct = npc.x > MyChar.gMC.x ? 0 : 2;
            }
            case 1: {
                if (++npc.act_wait <= 16) break;
                npc.act_no = 10;
                npc.view.top = 4096;
                npc.view.bottom = 4096;
                npc.damage = 2;
                npc.bits = (char)(npc.bits | 0x20);
                break;
            }
            case 10: {
                if ((npc.flag & 8) == 0) break;
                npc.act_no = 11;
                npc.ani_no = 0;
                npc.act_wait = 0;
                npc.xm = 0;
                if (npc.x > MyChar.gMC.x) {
                    npc.direct = 0;
                    break;
                }
                npc.direct = 2;
                break;
            }
            case 11: {
                if (++npc.act_wait <= 10) break;
                npc.act_no = ++npc.count1 > 4 ? 12 : 10;
                Sound.PlaySoundObject(30, 1);
                npc.ym = -1536;
                npc.xm = npc.direct == 0 ? -512 : 512;
                npc.ani_no = 2;
                break;
            }
            case 12: {
                npc.bits = (char)(npc.bits | 8);
                if (npc.y <= Map.gMap.length * 512 * 16) break;
                NpChar.VanishNpChar(npc);
                return;
            }
        }
        if (npc.act_no >= 10) {
            npc.ym += 64;
        }
        if (npc.ym > 1535) {
            npc.ym = 1535;
        }
        npc.x += npc.xm;
        npc.y += npc.ym;
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc289_rcLeft[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc289_rcRight[npc.ani_no]);
        }
        if (npc.act_no == 1) {
            npc.rect.top += 8 - npc.act_wait / 2;
            npc.rect.bottom -= 8 + npc.act_wait / 2;
            npc.view.top = npc.act_wait * 512 / 2;
            npc.view.bottom = npc.act_wait * 512 / 2;
        }
    }

    public static void ActNpc290(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
                npc.ani_no = 2;
                npc.direct = npc.x > MyChar.gMC.x ? 0 : 2;
            }
            case 1: {
                if (++npc.act_wait <= 16) break;
                npc.act_no = 10;
                npc.view.top = 4096;
                npc.view.bottom = 4096;
                npc.damage = 2;
                npc.bits = (char)(npc.bits | 0x20);
                npc.tgt_y = npc.y;
                npc.ym = 1024;
                break;
            }
            case 10: {
                if (++npc.ani_wait > 2) {
                    npc.ani_wait = 0;
                    ++npc.ani_no;
                }
                if (npc.ani_no > 2) {
                    npc.ani_no = 0;
                }
                npc.ym = npc.y < npc.tgt_y ? (npc.ym += 64) : (npc.ym -= 64);
                npc.xm = npc.direct == 0 ? (npc.xm -= 16) : (npc.xm += 16);
                if (npc.x >= 0 && npc.y >= 0 && npc.x <= Map.gMap.width * 512 * 16 && npc.y <= Map.gMap.length * 512 * 16) break;
                NpChar.VanishNpChar(npc);
                return;
            }
        }
        npc.x += npc.xm;
        npc.y += npc.ym;
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc290_rcLeft[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc290_rcRight[npc.ani_no]);
        }
        if (npc.act_no == 1) {
            npc.rect.top += 8 - npc.act_wait / 2;
            npc.rect.bottom -= 8 + npc.act_wait / 2;
            npc.view.top = npc.act_wait * 512 / 2;
            npc.view.bottom = npc.act_wait * 512 / 2;
        }
    }

    public static void ActNpc291(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 20;
                if (npc.direct != 2) break;
                npc.bits = (char)(npc.bits & 0xFFFFFFBF);
                npc.ani_no = 1;
            }
        }
        npc.rect.copyFrom(ActNpc291_tc[npc.ani_no]);
    }

    public static void ActNpc292(NpChar.NPCHAR npc) {
        Frame.SetQuake(10);
    }

    public static void ActNpc293(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
            }
            case 1: {
                if (++npc.ani_no > 1) {
                    npc.ani_no = 0;
                }
                NpChar.SetNpChar(4, npc.x + Game.Random(0, 16) * 512, npc.y + Game.Random(-16, 16) * 512, 0, 0, 0, null, 256);
                npc.x -= 4096;
                if (npc.x >= -16384) break;
                npc.cond = 0;
            }
        }
        npc.rect.copyFrom(ActNpc293_rect[npc.ani_no]);
    }

    public static void ActNpc294(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                if (MyChar.gMC.x >= (Map.gMap.width - 6) * 512 * 16) break;
                npc.act_no = 1;
                npc.act_wait = 0;
                break;
            }
            case 1: {
                ++npc.act_wait;
                if ((MyChar.gMC.equip & 0x20) != 0) {
                    npc.x = MyChar.gMC.x + 32768;
                    if (npc.x < 212992) {
                        npc.x = 212992;
                    }
                } else {
                    npc.x = MyChar.gMC.x + 49152;
                    if (npc.x < 188416) {
                        npc.x = 188416;
                    }
                }
                if (npc.x > (Map.gMap.width - 10) * 512 * 16) {
                    npc.x = (Map.gMap.width - 10) * 512 * 16;
                }
                if (npc.act_wait <= 24) break;
                int x = (MyChar.gMC.equip & 0x20) != 0 ? npc.x + Game.Random(-14, 14) * 512 * 16 : npc.x + Game.Random(-11, 11) * 512 * 16;
                int y = MyChar.gMC.y - 114688;
                int dir = Game.Random(0, 10) % 2 != 0 ? 0 : 2;
                NpChar.SetNpChar(279, x, y, 0, 0, dir, null, 256);
                npc.act_wait = Game.Random(0, 15);
            }
        }
    }

    public static void ActNpc295(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
                npc.ani_no = npc.direct % 4;
                switch (npc.direct) {
                    case 0: {
                        npc.ym = -1000;
                        npc.view.back = 53248;
                        npc.view.front = 53248;
                        break;
                    }
                    case 1: {
                        npc.ym = -2048;
                        npc.view.back = 28672;
                        npc.view.front = 28672;
                        break;
                    }
                    case 2: {
                        npc.ym = -1024;
                        npc.view.back = 16384;
                        npc.view.front = 16384;
                        break;
                    }
                    case 3: {
                        npc.ym = -512;
                        npc.view.back = 10240;
                        npc.view.front = 10240;
                        break;
                    }
                    case 4: {
                        npc.xm = -1024;
                        npc.view.back = 53248;
                        npc.view.front = 53248;
                        break;
                    }
                    case 5: {
                        npc.xm = -512;
                        npc.view.back = 28672;
                        npc.view.front = 28672;
                        break;
                    }
                    case 6: {
                        npc.xm = -256;
                        npc.view.back = 16384;
                        npc.view.front = 16384;
                        break;
                    }
                    case 7: {
                        npc.xm = -128;
                        npc.view.back = 10240;
                        npc.view.front = 10240;
                    }
                }
                break;
            }
            case 1: {
                npc.x += npc.xm;
                npc.y += npc.ym;
                if (npc.x < Short.MIN_VALUE) {
                    npc.cond = 0;
                }
                if (npc.y >= -16384) break;
                npc.cond = 0;
            }
        }
        npc.rect.copyFrom(ActNpc295_rc[npc.ani_no]);
    }

    public static void ActNpc296(NpChar.NPCHAR npc) {
        int pri = 0;
        if (++npc.act_wait > 16) {
            npc.act_wait = Game.Random(0, 16);
            int dir = Game.Random(0, 100) % 4;
            if (npc.direct == 0) {
                switch (dir) {
                    case 0: {
                        pri = 384;
                        break;
                    }
                    case 1: {
                        pri = 128;
                        break;
                    }
                    case 2: {
                        pri = 64;
                        break;
                    }
                    case 3: {
                        pri = 0;
                    }
                }
                int x = Game.Random(-10, 10) * 512 * 16 + npc.x;
                int y = npc.y;
                NpChar.SetNpChar(295, x, y, 0, 0, dir, null, pri);
            } else {
                switch (dir) {
                    case 0: {
                        pri = 128;
                        break;
                    }
                    case 1: {
                        pri = 85;
                        break;
                    }
                    case 2: {
                        pri = 64;
                        break;
                    }
                    case 3: {
                        pri = 0;
                    }
                }
                int x = npc.x;
                int y = Game.Random(-7, 7) * 512 * 16 + npc.y;
                NpChar.SetNpChar(295, x, y, 0, 0, dir + 4, null, pri);
            }
        }
    }

    public static void ActNpc297(NpChar.NPCHAR npc) {
        npc.x = npc.pNpc.x + 8192;
        npc.y = npc.pNpc.y + 4096;
        npc.rect.copyFrom(ActNpc297_rc);
    }

    public static void ActNpc298(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
                npc.y -= 4096;
            }
            case 1: {
                npc.ani_no = 0;
                break;
            }
            case 10: {
                npc.act_no = 11;
                npc.ani_no = 0;
                npc.ani_wait = 0;
                npc.count1 = 0;
            }
            case 11: {
                if (++npc.ani_wait > 6) {
                    npc.ani_wait = 0;
                    ++npc.ani_no;
                }
                if (npc.ani_no <= 1) break;
                npc.ani_no = 0;
                if (++npc.count1 <= 7) break;
                npc.ani_no = 0;
                npc.act_no = 1;
                break;
            }
            case 20: {
                npc.act_no = 21;
                npc.ani_no = 2;
                npc.ani_wait = 0;
            }
            case 21: {
                if (++npc.ani_wait > 10) {
                    npc.ani_wait = 0;
                    ++npc.ani_no;
                }
                if (npc.ani_no > 5) {
                    npc.ani_no = 2;
                }
                npc.x += 256;
                break;
            }
            case 30: {
                npc.ani_no = 6;
                break;
            }
            case 40: {
                npc.act_no = 41;
                npc.ani_no = 6;
                npc.ani_wait = 0;
                npc.count1 = 0;
            }
            case 41: {
                if (++npc.ani_wait > 6) {
                    npc.ani_wait = 0;
                    ++npc.ani_no;
                }
                if (npc.ani_no <= 7) break;
                npc.ani_no = 6;
                if (++npc.count1 <= 7) break;
                npc.ani_no = 6;
                npc.act_no = 30;
            }
        }
        npc.rect.copyFrom(ActNpc298_rc[npc.ani_no]);
    }

    public static void ActNpc299(NpChar.NPCHAR npc) {
        if (npc.act_no == 0) {
            npc.act_no = 1;
            if (npc.direct == 0) {
                npc.ani_no = 1;
                npc.act_wait = 25;
                npc.y -= 1600;
            } else {
                npc.ani_no = 0;
                npc.act_wait = 0;
            }
        }
        npc.y = ++npc.act_wait / 50 % 2 != 0 ? (npc.y += 64) : (npc.y -= 64);
        npc.rect.copyFrom(ActNpc299_rc[npc.ani_no]);
    }
}
