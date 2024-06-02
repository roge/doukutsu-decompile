/*
 * Decompiled with CFR 0.152.
 */
package jp.studiopixel.doukutsu;

import jp.studiopixel.doukutsu.Boss;
import jp.studiopixel.doukutsu.Flash;
import jp.studiopixel.doukutsu.Frame;
import jp.studiopixel.doukutsu.Game;
import jp.studiopixel.doukutsu.MyChar;
import jp.studiopixel.doukutsu.NpChar;
import jp.studiopixel.doukutsu.RECT;
import jp.studiopixel.doukutsu.Sound;
import jp.studiopixel.doukutsu.Triangle;

public class BossX {
    private static final RECT[] ActBossChar03_01_rcUp = new RECT[]{new RECT(0, 0, 72, 32), new RECT(0, 32, 72, 64), new RECT(72, 0, 144, 32), new RECT(144, 0, 216, 32), new RECT(72, 32, 144, 64), new RECT(144, 32, 216, 64)};
    private static final RECT[] ActBossChar03_01_rcDown = new RECT[]{new RECT(0, 64, 72, 96), new RECT(0, 96, 72, 128), new RECT(72, 64, 144, 96), new RECT(144, 64, 216, 96), new RECT(72, 96, 144, 128), new RECT(144, 96, 216, 128)};
    private static final RECT[] ActBossChar03_02_rect = new RECT[]{new RECT(0, 128, 72, 160), new RECT(72, 128, 144, 160), new RECT(0, 160, 72, 192), new RECT(72, 160, 144, 192)};
    private static final RECT ActBossChar03_03_rcLeft = new RECT(216, 96, 264, 144);
    private static final RECT ActBossChar03_03_rcRight = new RECT(264, 96, 312, 144);
    private static final RECT[] ActBossChar03_04_rect = new RECT[]{new RECT(0, 192, 16, 208), new RECT(16, 192, 32, 208), new RECT(32, 192, 48, 208), new RECT(48, 192, 64, 208), new RECT(0, 208, 16, 224), new RECT(16, 208, 32, 224), new RECT(32, 208, 48, 224), new RECT(48, 208, 64, 224)};
    private static final RECT[] ActBossChar03_face_rect = new RECT[]{new RECT(216, 0, 320, 48), new RECT(216, 48, 320, 96), new RECT(216, 144, 320, 192)};
    private static char flash = '\u0000';

    private static void ActBossChar03_01(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 10: {
                npc.ani_no = 0;
                npc.bits = (char)(npc.bits & 0xFFFFFFEF);
                break;
            }
            case 100: {
                npc.bits = (char)(npc.bits | 0x10);
                npc.act_no = 101;
                npc.act_wait = 0;
                npc.ani_no = 2;
                npc.ani_wait = 0;
            }
            case 101: {
                if (++npc.act_wait > 30) {
                    npc.act_no = 102;
                }
                if (++npc.ani_wait > 0) {
                    npc.ani_wait = 0;
                    ++npc.ani_no;
                }
                if (npc.ani_no > 3) {
                    npc.ani_no = 2;
                }
                npc.xm -= 32;
                break;
            }
            case 102: {
                npc.bits = (char)(npc.bits & 0xFFFFFFEF);
                npc.act_no = 103;
                npc.ani_no = 0;
                npc.ani_wait = 0;
            }
            case 103: {
                ++npc.act_wait;
                if (++npc.ani_wait > 1) {
                    npc.ani_wait = 0;
                    ++npc.ani_no;
                }
                if (npc.ani_no > 1) {
                    npc.ani_no = 0;
                }
                npc.xm -= 32;
                break;
            }
            case 200: {
                npc.bits = (char)(npc.bits | 0x10);
                npc.bits = (char)(npc.bits | 0x80);
                npc.act_no = 201;
                npc.act_wait = 0;
                npc.ani_no = 4;
                npc.ani_wait = 0;
            }
            case 201: {
                if (++npc.act_wait > 30) {
                    npc.act_no = 202;
                }
                if (++npc.ani_wait > 0) {
                    npc.ani_wait = 0;
                    ++npc.ani_no;
                }
                if (npc.ani_no > 5) {
                    npc.ani_no = 4;
                }
                npc.xm += 32;
                break;
            }
            case 202: {
                npc.bits = (char)(npc.bits & 0xFFFFFFEF);
                npc.act_no = 203;
                npc.ani_no = 0;
                npc.ani_wait = 0;
            }
            case 203: {
                ++npc.act_wait;
                if (++npc.ani_wait > 1) {
                    npc.ani_wait = 0;
                    ++npc.ani_no;
                }
                if (npc.ani_no > 1) {
                    npc.ani_no = 0;
                }
                npc.xm += 32;
                break;
            }
            case 300: {
                npc.act_no = 301;
                npc.ani_no = 4;
                npc.ani_wait = 0;
                npc.bits = (char)(npc.bits | 0x10);
            }
            case 301: {
                if (++npc.ani_wait > 0) {
                    npc.ani_wait = 0;
                    ++npc.ani_no;
                }
                if (npc.ani_no > 5) {
                    npc.ani_no = 4;
                }
                npc.xm += 32;
                if (npc.xm <= 0) break;
                npc.xm = 0;
                npc.act_no = 10;
                break;
            }
            case 400: {
                npc.act_no = 401;
                npc.ani_no = 2;
                npc.ani_wait = 0;
                npc.bits = (char)(npc.bits | 0x10);
            }
            case 401: {
                if (++npc.ani_wait > 0) {
                    npc.ani_wait = 0;
                    ++npc.ani_no;
                }
                if (npc.ani_no > 3) {
                    npc.ani_no = 2;
                }
                npc.xm -= 32;
                if (npc.xm >= 0) break;
                npc.xm = 0;
                npc.act_no = 10;
            }
        }
        if ((npc.act_no == 101 || npc.act_no == 201 || npc.act_no == 301 || npc.act_no == 401) && npc.act_wait % 2 == 1) {
            Sound.PlaySoundObject(112, 1);
        }
        if ((npc.act_no == 103 || npc.act_no == 203) && npc.act_wait % 4 == 1) {
            Sound.PlaySoundObject(111, 1);
        }
        if (npc.act_no >= 100 && MyChar.gMC.y < npc.y + 2048 && MyChar.gMC.y > npc.y - 2048) {
            npc.damage = 10;
            npc.bits = (char)(npc.bits | 0x80);
        } else {
            npc.damage = 0;
            npc.bits = (char)(npc.bits & 0xFFFFFF7F);
        }
        if (npc.xm > 1024) {
            npc.xm = 1024;
        }
        if (npc.xm < -1024) {
            npc.xm = -1024;
        }
        npc.x += npc.xm;
        if (npc.direct == 1) {
            npc.rect.copyFrom(ActBossChar03_01_rcUp[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActBossChar03_01_rcDown[npc.ani_no]);
        }
    }

    private static void ActBossChar03_02(NpChar.NPCHAR npc) {
        int direct = 0;
        int x = 0;
        int y = 0;
        switch (npc.act_no) {
            case 10: {
                npc.act_no = 11;
                npc.act_wait = npc.ani_no * 30 + 30;
            }
            case 11: {
                if (npc.act_wait != 0) {
                    --npc.act_wait;
                    break;
                }
                switch (npc.ani_no) {
                    case 0: {
                        direct = 3;
                        x = -15360;
                        y = 3072;
                        break;
                    }
                    case 1: {
                        direct = 2;
                        x = 15360;
                        y = 3072;
                        break;
                    }
                    case 2: {
                        direct = 0;
                        x = -15360;
                        y = -3072;
                        break;
                    }
                    case 3: {
                        direct = 1;
                        x = 15360;
                        y = -3072;
                    }
                }
                NpChar.SetNpChar(158, npc.x + x, npc.y + y, 0, 0, direct, null, 256);
                Sound.PlaySoundObject(39, 1);
                npc.act_wait = 120;
            }
        }
        npc.x = (Boss.gBoss[0].x + Boss.gBoss[npc.count1].x) / 2;
        npc.y = (Boss.gBoss[0].y + Boss.gBoss[npc.count1].y) / 2;
        npc.rect.copyFrom(ActBossChar03_02_rect[npc.ani_no]);
    }

    private static void ActBossChar03_03(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 10: {
                npc.tgt_x += 512;
                if (npc.tgt_x <= 16384) break;
                npc.tgt_x = 16384;
                npc.act_no = 0;
                Boss.gBoss[3].act_no = 10;
                Boss.gBoss[4].act_no = 10;
                Boss.gBoss[5].act_no = 10;
                Boss.gBoss[6].act_no = 10;
                break;
            }
            case 20: {
                npc.tgt_x -= 512;
                if (npc.tgt_x >= 0) break;
                npc.tgt_x = 0;
                npc.act_no = 0;
                Boss.gBoss[3].act_no = 0;
                Boss.gBoss[4].act_no = 0;
                Boss.gBoss[5].act_no = 0;
                Boss.gBoss[6].act_no = 0;
                break;
            }
            case 30: {
                npc.tgt_x += 512;
                if (npc.tgt_x <= 10240) break;
                npc.tgt_x = 10240;
                npc.act_no = 0;
                Boss.gBoss[7].act_no = 10;
                Boss.gBoss[13].act_no = 10;
                Boss.gBoss[14].act_no = 10;
                Boss.gBoss[15].act_no = 10;
                Boss.gBoss[16].act_no = 10;
                break;
            }
            case 40: {
                npc.tgt_x -= 512;
                if (npc.tgt_x >= 0) break;
                npc.tgt_x = 0;
                npc.act_no = 0;
                Boss.gBoss[7].act_no = 0;
                Boss.gBoss[13].act_no = 0;
                Boss.gBoss[14].act_no = 0;
                Boss.gBoss[15].act_no = 0;
                Boss.gBoss[16].act_no = 0;
            }
        }
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActBossChar03_03_rcLeft);
            npc.x = Boss.gBoss[0].x - 12288 - npc.tgt_x;
            npc.y = Boss.gBoss[0].y;
        } else {
            npc.rect.copyFrom(ActBossChar03_03_rcRight);
            npc.x = Boss.gBoss[0].x + 12288 + npc.tgt_x;
            npc.y = Boss.gBoss[0].y;
        }
    }

    private static void ActBossChar03_04(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.bits = (char)(npc.bits & 0xFFFFFFDF);
                npc.ani_no = 0;
                break;
            }
            case 10: {
                npc.act_no = 11;
                npc.act_wait = npc.tgt_x * 10 + 40;
                npc.bits = (char)(npc.bits | 0x20);
            }
            case 11: {
                npc.ani_no = npc.act_wait < 16 && npc.act_wait / 2 % 2 != 0 ? 1 : 0;
                if (npc.act_wait != 0) {
                    --npc.act_wait;
                    break;
                }
                char deg = (char)Triangle.GetArktan(npc.x - MyChar.gMC.x, npc.y - MyChar.gMC.y);
                deg = (char)(deg + (char)Game.Random(-2, 2) & 0xFF);
                int ym = Triangle.GetSin(deg) * 3;
                int xm = Triangle.GetCos(deg) * 3;
                NpChar.SetNpChar(156, npc.x, npc.y, xm, ym, 0, null, 256);
                Sound.PlaySoundObject(39, 1);
                npc.act_wait = 40;
            }
        }
        switch (npc.tgt_x) {
            case 0: {
                npc.x = Boss.gBoss[0].x - 11264;
                npc.y = Boss.gBoss[0].y - 8192;
                break;
            }
            case 1: {
                npc.x = Boss.gBoss[0].x + 14336;
                npc.y = Boss.gBoss[0].y - 8192;
                break;
            }
            case 2: {
                npc.x = Boss.gBoss[0].x - 7680;
                npc.y = Boss.gBoss[0].y + 7168;
                break;
            }
            case 3: {
                npc.x = Boss.gBoss[0].x + 8704;
                npc.y = Boss.gBoss[0].y + 7168;
            }
        }
        npc.rect.copyFrom(ActBossChar03_04_rect[npc.tgt_x + 4 * npc.ani_no]);
    }

    private static void ActBossChar03_face(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                Boss.gBoss[0].bits = (char)(Boss.gBoss[0].bits & 0xFFFFFFDF);
                npc.ani_no = 0;
                break;
            }
            case 10: {
                npc.act_no = 11;
                npc.act_wait = npc.tgt_x * 10 + 40;
                Boss.gBoss[0].bits = (char)(Boss.gBoss[0].bits | 0x20);
            }
            case 11: {
                if (Boss.gBoss[0].shock != '\u0000') {
                    char c = flash;
                    flash = (char)(c + '\u0001');
                    if (c / 2 % 2 != 0) {
                        npc.ani_no = 1;
                        break;
                    }
                    npc.ani_no = 0;
                    break;
                }
                npc.ani_no = 0;
            }
        }
        Boss.gBoss[7].x = Boss.gBoss[0].x;
        Boss.gBoss[7].y = Boss.gBoss[0].y;
        if (Boss.gBoss[0].act_no <= 10) {
            npc.ani_no = 2;
        }
        npc.rect.copyFrom(ActBossChar03_face_rect[npc.ani_no]);
    }

    public static void ActBossChar_MonstX() {
        NpChar.NPCHAR npc = Boss.gBoss[0];
        switch (npc.act_no) {
            case 0: {
                npc.life = 1;
                npc.x = -163840;
                break;
            }
            case 1: {
                npc.life = 700;
                npc.exp = 1;
                npc.act_no = 1;
                npc.x = 0x100000;
                npc.y = 102400;
                npc.hit_voice = 54;
                npc.hit.front = 12288;
                npc.hit.top = 12288;
                npc.hit.back = 12288;
                npc.hit.bottom = 12288;
                npc.bits = (char)33288;
                npc.size = 3;
                npc.code_event = 1000;
                npc.ani_no = 0;
                Boss.gBoss[1].cond = (byte)-128;
                Boss.gBoss[1].size = 3;
                Boss.gBoss[1].direct = 0;
                Boss.gBoss[1].view.front = 12288;
                Boss.gBoss[1].view.top = 12288;
                Boss.gBoss[1].view.back = 12288;
                Boss.gBoss[1].view.bottom = 12288;
                Boss.gBoss[1].bits = (char)8;
                Boss.gBoss[2].copyFrom(Boss.gBoss[1]);
                Boss.gBoss[2].direct = 2;
                Boss.gBoss[3].cond = (byte)-128;
                Boss.gBoss[3].life = 60;
                Boss.gBoss[3].size = 3;
                Boss.gBoss[3].hit_voice = 54;
                Boss.gBoss[3].destroy_voice = 71;
                Boss.gBoss[3].size = 2;
                Boss.gBoss[3].view.front = 4096;
                Boss.gBoss[3].view.top = 4096;
                Boss.gBoss[3].view.back = 4096;
                Boss.gBoss[3].view.bottom = 4096;
                Boss.gBoss[3].hit.front = 2560;
                Boss.gBoss[3].hit.back = 2560;
                Boss.gBoss[3].hit.top = 2560;
                Boss.gBoss[3].hit.bottom = 2560;
                Boss.gBoss[3].bits = (char)8;
                Boss.gBoss[3].tgt_x = 0;
                Boss.gBoss[4].copyFrom(Boss.gBoss[3]);
                Boss.gBoss[4].tgt_x = 1;
                Boss.gBoss[5].copyFrom(Boss.gBoss[3]);
                Boss.gBoss[5].tgt_x = 2;
                Boss.gBoss[5].life = 100;
                Boss.gBoss[6].copyFrom(Boss.gBoss[3]);
                Boss.gBoss[6].tgt_x = 3;
                Boss.gBoss[6].life = 100;
                Boss.gBoss[7].cond = (byte)-128;
                Boss.gBoss[7].x = 0x100000;
                Boss.gBoss[7].y = 102400;
                Boss.gBoss[7].view.front = 26624;
                Boss.gBoss[7].view.top = 12288;
                Boss.gBoss[7].view.back = 26624;
                Boss.gBoss[7].view.bottom = 12288;
                Boss.gBoss[7].hit_voice = 52;
                Boss.gBoss[7].hit.front = 4096;
                Boss.gBoss[7].hit.top = 12288;
                Boss.gBoss[7].hit.back = 4096;
                Boss.gBoss[7].hit.bottom = 8192;
                Boss.gBoss[7].bits = (char)8;
                Boss.gBoss[7].size = 3;
                Boss.gBoss[7].ani_no = 0;
                Boss.gBoss[9].cond = (byte)-128;
                Boss.gBoss[9].act_no = 0;
                Boss.gBoss[9].direct = 1;
                Boss.gBoss[9].x = 1015808;
                Boss.gBoss[9].y = 73728;
                Boss.gBoss[9].view.front = 18432;
                Boss.gBoss[9].view.top = 4096;
                Boss.gBoss[9].view.back = 18432;
                Boss.gBoss[9].view.bottom = 12288;
                Boss.gBoss[9].hit_voice = 52;
                Boss.gBoss[9].hit.front = 14336;
                Boss.gBoss[9].hit.top = 4096;
                Boss.gBoss[9].hit.back = 14336;
                Boss.gBoss[9].hit.bottom = 8192;
                Boss.gBoss[9].bits = (char)141;
                Boss.gBoss[9].size = 3;
                Boss.gBoss[10].copyFrom(Boss.gBoss[9]);
                Boss.gBoss[10].x = 0x108000;
                Boss.gBoss[11].copyFrom(Boss.gBoss[9]);
                Boss.gBoss[11].direct = 3;
                Boss.gBoss[11].x = 1015808;
                Boss.gBoss[11].y = 131072;
                Boss.gBoss[11].view.top = 12288;
                Boss.gBoss[11].view.bottom = 4096;
                Boss.gBoss[11].hit.top = 8192;
                Boss.gBoss[11].hit.bottom = 4096;
                Boss.gBoss[12].copyFrom(Boss.gBoss[11]);
                Boss.gBoss[12].x = 0x108000;
                Boss.gBoss[13].copyFrom(Boss.gBoss[9]);
                Boss.gBoss[13].cond = (byte)-128;
                Boss.gBoss[13].view.top = 8192;
                Boss.gBoss[13].view.bottom = 8192;
                Boss.gBoss[13].view.front = 15360;
                Boss.gBoss[13].view.back = 21504;
                Boss.gBoss[13].count1 = 9;
                Boss.gBoss[13].ani_no = 0;
                Boss.gBoss[13].bits = (char)8;
                Boss.gBoss[14] = Boss.gBoss[13];
                Boss.gBoss[14].view.front = 21504;
                Boss.gBoss[14].view.back = 15360;
                Boss.gBoss[14].count1 = 10;
                Boss.gBoss[14].ani_no = 1;
                Boss.gBoss[14].bits = (char)8;
                Boss.gBoss[15] = Boss.gBoss[13];
                Boss.gBoss[15].view.top = 8192;
                Boss.gBoss[15].view.bottom = 8192;
                Boss.gBoss[15].count1 = 11;
                Boss.gBoss[15].ani_no = 2;
                Boss.gBoss[15].bits = (char)8;
                Boss.gBoss[16] = Boss.gBoss[15];
                Boss.gBoss[16].view.front = 21504;
                Boss.gBoss[16].view.back = 15360;
                Boss.gBoss[16].count1 = 12;
                Boss.gBoss[16].ani_no = 3;
                Boss.gBoss[16].bits = (char)8;
                npc.act_no = 2;
                break;
            }
            case 10: {
                npc.act_no = 11;
                npc.act_wait = 0;
                npc.count1 = 0;
            }
            case 11: {
                ++npc.act_wait;
                if (npc.act_wait <= 100) break;
                npc.act_wait = 0;
                if (npc.x > MyChar.gMC.x) {
                    npc.act_no = 100;
                    break;
                }
                npc.act_no = 200;
                break;
            }
            case 100: {
                npc.act_wait = 0;
                npc.act_no = 101;
                ++npc.count1;
            }
            case 101: {
                ++npc.act_wait;
                if (npc.act_wait == 4) {
                    Boss.gBoss[9].act_no = 100;
                }
                if (npc.act_wait == 8) {
                    Boss.gBoss[10].act_no = 100;
                }
                if (npc.act_wait == 10) {
                    Boss.gBoss[11].act_no = 100;
                }
                if (npc.act_wait == 12) {
                    Boss.gBoss[12].act_no = 100;
                }
                if (npc.act_wait > 120 && npc.count1 > 2) {
                    npc.act_no = 300;
                }
                if (npc.act_wait <= 121 || MyChar.gMC.x <= npc.x) break;
                npc.act_no = 200;
                break;
            }
            case 200: {
                npc.act_wait = 0;
                npc.act_no = 201;
                ++npc.count1;
            }
            case 201: {
                ++npc.act_wait;
                if (npc.act_wait == 4) {
                    Boss.gBoss[9].act_no = 200;
                }
                if (npc.act_wait == 8) {
                    Boss.gBoss[10].act_no = 200;
                }
                if (npc.act_wait == 10) {
                    Boss.gBoss[11].act_no = 200;
                }
                if (npc.act_wait == 12) {
                    Boss.gBoss[12].act_no = 200;
                }
                if (npc.act_wait > 120 && npc.count1 > 2) {
                    npc.act_no = 400;
                }
                if (npc.act_wait <= 121 || MyChar.gMC.x >= npc.x) break;
                npc.act_no = 100;
                break;
            }
            case 300: {
                npc.act_wait = 0;
                npc.act_no = 301;
            }
            case 301: {
                ++npc.act_wait;
                if (npc.act_wait == 4) {
                    Boss.gBoss[9].act_no = 300;
                }
                if (npc.act_wait == 8) {
                    Boss.gBoss[10].act_no = 300;
                }
                if (npc.act_wait == 10) {
                    Boss.gBoss[11].act_no = 300;
                }
                if (npc.act_wait == 12) {
                    Boss.gBoss[12].act_no = 300;
                }
                if (npc.act_wait <= 50) break;
                if (Boss.gBoss[3].cond == 0 && Boss.gBoss[4].cond == 0 && Boss.gBoss[5].cond == 0 && Boss.gBoss[6].cond == 0) {
                    npc.act_no = 600;
                    break;
                }
                npc.act_no = 500;
                break;
            }
            case 400: {
                npc.act_wait = 0;
                npc.act_no = 401;
            }
            case 401: {
                ++npc.act_wait;
                if (npc.act_wait == 4) {
                    Boss.gBoss[9].act_no = 400;
                }
                if (npc.act_wait == 8) {
                    Boss.gBoss[10].act_no = 400;
                }
                if (npc.act_wait == 10) {
                    Boss.gBoss[11].act_no = 400;
                }
                if (npc.act_wait == 12) {
                    Boss.gBoss[12].act_no = 400;
                }
                if (npc.act_wait <= 50) break;
                if (Boss.gBoss[3].cond == 0 && Boss.gBoss[4].cond == 0 && Boss.gBoss[5].cond == 0 && Boss.gBoss[6].cond == 0) {
                    npc.act_no = 600;
                    break;
                }
                npc.act_no = 500;
                break;
            }
            case 500: {
                npc.act_no = 501;
                npc.act_wait = 0;
                Boss.gBoss[1].act_no = 10;
                Boss.gBoss[2].act_no = 10;
            }
            case 501: {
                ++npc.act_wait;
                if (npc.act_wait > 300) {
                    npc.act_no = 502;
                    npc.act_wait = 0;
                }
                if (Boss.gBoss[3].cond != 0 || Boss.gBoss[4].cond != 0 || Boss.gBoss[5].cond != 0 || Boss.gBoss[6].cond != 0) break;
                npc.act_no = 502;
                npc.act_wait = 0;
                break;
            }
            case 502: {
                npc.act_no = 503;
                npc.act_wait = 0;
                npc.count1 = 0;
                Boss.gBoss[1].act_no = 20;
                Boss.gBoss[2].act_no = 20;
            }
            case 503: {
                ++npc.act_wait;
                if (npc.act_wait <= 50) break;
                if (npc.x > MyChar.gMC.x) {
                    npc.act_no = 100;
                    break;
                }
                npc.act_no = 200;
                break;
            }
            case 600: {
                npc.act_no = 601;
                npc.act_wait = 0;
                npc.count2 = npc.life;
                Boss.gBoss[1].act_no = 30;
                Boss.gBoss[2].act_no = 30;
            }
            case 601: {
                ++npc.act_wait;
                if (npc.life >= npc.count2 - 200 && npc.act_wait <= 300) break;
                npc.act_no = 602;
                npc.act_wait = 0;
                break;
            }
            case 602: {
                npc.act_no = 603;
                npc.act_wait = 0;
                npc.count1 = 0;
                Boss.gBoss[1].act_no = 40;
                Boss.gBoss[2].act_no = 40;
            }
            case 603: {
                ++npc.act_wait;
                if (npc.act_wait <= 50) break;
                if (npc.x > MyChar.gMC.x) {
                    npc.act_no = 100;
                    break;
                }
                npc.act_no = 200;
                break;
            }
            case 1000: {
                Frame.SetQuake(2);
                if (++npc.act_wait % 8 == 0) {
                    Sound.PlaySoundObject(52, 1);
                }
                NpChar.SetDestroyNpChar(npc.x + Game.Random(-72, 72) * 512, npc.y + Game.Random(-64, 64) * 512, 1, 1);
                if (npc.act_wait <= 100) break;
                npc.act_wait = 0;
                npc.act_no = 1001;
                Flash.SetFlash(npc.x, npc.y, 1);
                Sound.PlaySoundObject(35, 1);
                break;
            }
            case 1001: {
                Frame.SetQuake(40);
                ++npc.act_wait;
                if (npc.act_wait <= 50) break;
                for (int i = 0; i < 20; ++i) {
                    Boss.gBoss[i].cond = 0;
                }
                NpChar.DeleteNpCharCode(158, true);
                NpChar.SetNpChar(159, npc.x, npc.y - 12288, 0, 0, 0, null, 0);
            }
        }
        BossX.ActBossChar03_01(Boss.gBoss[9]);
        BossX.ActBossChar03_01(Boss.gBoss[10]);
        BossX.ActBossChar03_01(Boss.gBoss[11]);
        BossX.ActBossChar03_01(Boss.gBoss[12]);
        npc.x += ((Boss.gBoss[11].x + Boss.gBoss[10].x + Boss.gBoss[9].x + Boss.gBoss[12].x) / 4 - npc.x) / 16;
        BossX.ActBossChar03_face(Boss.gBoss[7]);
        BossX.ActBossChar03_02(Boss.gBoss[13]);
        BossX.ActBossChar03_02(Boss.gBoss[14]);
        BossX.ActBossChar03_02(Boss.gBoss[15]);
        BossX.ActBossChar03_02(Boss.gBoss[16]);
        BossX.ActBossChar03_03(Boss.gBoss[1]);
        BossX.ActBossChar03_03(Boss.gBoss[2]);
        if (Boss.gBoss[3].cond != 0) {
            BossX.ActBossChar03_04(Boss.gBoss[3]);
        }
        if (Boss.gBoss[4].cond != 0) {
            BossX.ActBossChar03_04(Boss.gBoss[4]);
        }
        if (Boss.gBoss[5].cond != 0) {
            BossX.ActBossChar03_04(Boss.gBoss[5]);
        }
        if (Boss.gBoss[6].cond != 0) {
            BossX.ActBossChar03_04(Boss.gBoss[6]);
        }
        if (npc.life == 0 && npc.act_no < 1000) {
            npc.act_no = 1000;
            npc.act_wait = 0;
            npc.shock = (char)150;
            Boss.gBoss[9].act_no = 300;
            Boss.gBoss[10].act_no = 300;
            Boss.gBoss[11].act_no = 300;
            Boss.gBoss[12].act_no = 300;
        }
    }
}
