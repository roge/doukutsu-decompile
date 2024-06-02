/*
 * Decompiled with CFR 0.152.
 */
package jp.studiopixel.doukutsu;

import jp.studiopixel.doukutsu.Boss;
import jp.studiopixel.doukutsu.Flash;
import jp.studiopixel.doukutsu.Frame;
import jp.studiopixel.doukutsu.Game;
import jp.studiopixel.doukutsu.Map;
import jp.studiopixel.doukutsu.MyChar;
import jp.studiopixel.doukutsu.NpChar;
import jp.studiopixel.doukutsu.RECT;
import jp.studiopixel.doukutsu.Sound;
import jp.studiopixel.doukutsu.Triangle;

public class BossAlmo2 {
    private static final RECT[] ActBossCharA_Head_rect = new RECT[]{new RECT(0, 0, 72, 112), new RECT(0, 112, 72, 224), new RECT(160, 0, 232, 112), new RECT(0, 0, 0, 0)};
    private static final RECT[] ActBossCharA_Tail_rect = new RECT[]{new RECT(72, 0, 160, 112), new RECT(72, 112, 160, 224), new RECT(0, 0, 0, 0)};
    private static final RECT[] ActBossCharA_Face_rect = new RECT[]{new RECT(0, 0, 0, 0), new RECT(160, 112, 232, 152), new RECT(160, 152, 232, 192), new RECT(160, 192, 232, 232), new RECT(248, 160, 320, 200)};
    private static final RECT[] ActBossCharA_Mini_rect = new RECT[]{new RECT(256, 0, 320, 40), new RECT(256, 40, 320, 80), new RECT(256, 80, 320, 120)};
    private static char flash = '\u0000';
    private static int life = 0;

    private static void ActBossCharA_Head(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 10: {
                npc.act_no = 11;
                npc.ani_no = 2;
                npc.bits = (char)8;
                npc.view.front = 18432;
                npc.view.top = 28672;
            }
            case 11: {
                npc.x = Boss.gBoss[0].x - 18432;
                npc.y = Boss.gBoss[0].y;
                break;
            }
            case 50: {
                npc.act_no = 51;
                npc.act_wait = 112;
            }
            case 51: {
                --npc.act_wait;
                if (npc.act_wait != 0) break;
                npc.act_no = 100;
                npc.ani_no = 3;
                break;
            }
            case 100: {
                npc.ani_no = 3;
            }
        }
        npc.rect.copyFrom(ActBossCharA_Head_rect[npc.ani_no]);
        if (npc.act_no == 51) {
            npc.rect.bottom = npc.rect.top + npc.act_wait;
        }
    }

    private static void ActBossCharA_Tail(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 10: {
                npc.act_no = 11;
                npc.ani_no = 0;
                npc.bits = (char)8;
                npc.view.front = 22528;
                npc.view.top = 28672;
            }
            case 11: {
                npc.x = Boss.gBoss[0].x + 22528;
                npc.y = Boss.gBoss[0].y;
                break;
            }
            case 50: {
                npc.act_no = 51;
                npc.act_wait = 112;
            }
            case 51: {
                --npc.act_wait;
                if (npc.act_wait != 0) break;
                npc.act_no = 100;
                npc.ani_no = 2;
                break;
            }
            case 100: {
                npc.ani_no = 2;
            }
        }
        npc.rect.copyFrom(ActBossCharA_Tail_rect[npc.ani_no]);
        if (npc.act_no == 51) {
            npc.rect.bottom = npc.rect.top + npc.act_wait;
        }
    }

    private static void ActBossCharA_Face(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.ani_no = 0;
                break;
            }
            case 10: {
                npc.ani_no = 1;
                break;
            }
            case 20: {
                npc.ani_no = 2;
                break;
            }
            case 30: {
                npc.act_no = 31;
                npc.ani_no = 3;
                npc.act_wait = 100;
            }
            case 31: {
                ++npc.act_wait;
                if (npc.act_wait > 300) {
                    npc.act_wait = 0;
                }
                if (npc.act_wait > 250 && npc.act_wait % 16 == 1) {
                    Sound.PlaySoundObject(26, 1);
                }
                if (npc.act_wait > 250 && npc.act_wait % 16 == 7) {
                    NpChar.SetNpChar(293, npc.x, npc.y, 0, 0, 0, null, 128);
                    Sound.PlaySoundObject(101, 1);
                }
                if (npc.act_wait == 200) {
                    Sound.PlaySoundObject(116, 1);
                }
                npc.ani_no = npc.act_wait > 200 && npc.act_wait % 2 != 0 ? 4 : 3;
            }
        }
        npc.view.back = 18432;
        npc.view.front = 18432;
        npc.view.top = 10240;
        npc.x = Boss.gBoss[0].x - 18432;
        npc.y = Boss.gBoss[0].y + 2048;
        npc.bits = (char)8;
        npc.rect.copyFrom(ActBossCharA_Face_rect[npc.ani_no]);
    }

    private static void ActBossCharA_Mini(NpChar.NPCHAR npc) {
        if (npc.cond == 0) {
            return;
        }
        npc.life = 1000;
        switch (npc.act_no) {
            case 0: {
                npc.bits = (char)(npc.bits & 0xFFFFFFDF);
                break;
            }
            case 5: {
                npc.ani_no = 0;
                npc.bits = (char)(npc.bits & 0xFFFFFFDF);
                ++npc.count2;
                npc.count2 %= 256;
                break;
            }
            case 10: {
                npc.ani_no = 0;
                npc.bits = (char)(npc.bits & 0xFFFFFFDF);
                npc.count2 += 2;
                npc.count2 %= 256;
                break;
            }
            case 20: {
                npc.ani_no = 1;
                npc.bits = (char)(npc.bits & 0xFFFFFFDF);
                npc.count2 += 2;
                npc.count2 %= 256;
                break;
            }
            case 30: {
                npc.ani_no = 0;
                npc.bits = (char)(npc.bits & 0xFFFFFFDF);
                npc.count2 += 4;
                npc.count2 %= 256;
                break;
            }
            case 200: {
                npc.act_no = 201;
                npc.ani_no = 2;
                npc.xm = 0;
                npc.ym = 0;
            }
            case 201: {
                npc.xm += 32;
                npc.x += npc.xm;
                if (npc.x <= Map.gMap.width * 512 * 16 + 16384) break;
                npc.cond = 0;
            }
        }
        if (npc.act_no < 50) {
            int deg = npc.count1 != 0 ? npc.count2 + 128 : npc.count2 + 384;
            npc.x = npc.pNpc.x - 4096 + Triangle.GetCos((char)(deg / 2)) * 48;
            npc.y = npc.pNpc.y + Triangle.GetSin((char)(deg / 2)) * 80;
        }
        npc.rect.copyFrom(ActBossCharA_Mini_rect[npc.ani_no]);
    }

    private static void ActBossCharA_Hit(NpChar.NPCHAR npc) {
        switch (npc.count1) {
            case 0: {
                npc.x = Boss.gBoss[0].x;
                npc.y = Boss.gBoss[0].y - 16384;
                break;
            }
            case 1: {
                npc.x = Boss.gBoss[0].x + 14336;
                npc.y = Boss.gBoss[0].y;
                break;
            }
            case 2: {
                npc.x = Boss.gBoss[0].x + 2048;
                npc.y = Boss.gBoss[0].y + 16384;
                break;
            }
            case 3: {
                npc.x = Boss.gBoss[0].x - 14336;
                npc.y = Boss.gBoss[0].y + 2048;
            }
        }
    }

    public static void ActBossChar_Undead() {
        int i;
        NpChar.NPCHAR npc = Boss.gBoss[0];
        boolean bShock = false;
        int x = 0;
        int y = 0;
        switch (npc.act_no) {
            case 1: {
                npc.act_no = 10;
                npc.exp = 1;
                npc.cond = (byte)-128;
                npc.bits = (char)32780;
                npc.life = 700;
                npc.hit_voice = 114;
                npc.x = 303104;
                npc.y = 61440;
                npc.xm = 0;
                npc.ym = 0;
                npc.code_event = 1000;
                npc.bits = (char)(npc.bits | 0x200);
                Boss.gBoss[3].cond = (byte)-128;
                Boss.gBoss[3].act_no = 0;
                Boss.gBoss[4].cond = (byte)-128;
                Boss.gBoss[4].act_no = 10;
                Boss.gBoss[5].cond = (byte)-128;
                Boss.gBoss[5].act_no = 10;
                Boss.gBoss[8].cond = (byte)-128;
                Boss.gBoss[8].bits = (char)8;
                Boss.gBoss[8].view.front = 0;
                Boss.gBoss[8].view.top = 0;
                Boss.gBoss[8].hit.back = 20480;
                Boss.gBoss[8].hit.top = 8192;
                Boss.gBoss[8].hit.bottom = 8192;
                Boss.gBoss[8].count1 = 0;
                Boss.gBoss[9].copyFrom(Boss.gBoss[8]);
                Boss.gBoss[9].hit.back = 18432;
                Boss.gBoss[9].hit.top = 12288;
                Boss.gBoss[9].hit.bottom = 12288;
                Boss.gBoss[9].count1 = 1;
                Boss.gBoss[10].copyFrom(Boss.gBoss[8]);
                Boss.gBoss[10].hit.back = 22528;
                Boss.gBoss[10].hit.top = 4096;
                Boss.gBoss[10].hit.bottom = 4096;
                Boss.gBoss[10].count1 = 2;
                Boss.gBoss[11].copyFrom(Boss.gBoss[8]);
                Boss.gBoss[11].cond = (byte)(Boss.gBoss[11].cond | 0x10);
                Boss.gBoss[11].hit.back = 10240;
                Boss.gBoss[11].hit.top = 10240;
                Boss.gBoss[11].hit.bottom = 10240;
                Boss.gBoss[11].count1 = 3;
                Boss.gBoss[1].cond = (byte)-128;
                Boss.gBoss[1].act_no = 0;
                Boss.gBoss[1].bits = (char)40;
                Boss.gBoss[1].life = 1000;
                Boss.gBoss[1].hit_voice = 54;
                Boss.gBoss[1].hit.back = 12288;
                Boss.gBoss[1].hit.top = 8192;
                Boss.gBoss[1].hit.bottom = 8192;
                Boss.gBoss[1].view.front = 16384;
                Boss.gBoss[1].view.top = 10240;
                Boss.gBoss[1].pNpc = npc;
                Boss.gBoss[2].copyFrom(Boss.gBoss[1]);
                Boss.gBoss[2].count2 = 128;
                Boss.gBoss[6].copyFrom(Boss.gBoss[1]);
                Boss.gBoss[6].count1 = 1;
                Boss.gBoss[7].copyFrom(Boss.gBoss[1]);
                Boss.gBoss[7].count1 = 1;
                Boss.gBoss[7].count2 = 128;
                life = npc.life;
                break;
            }
            case 15: {
                npc.act_no = 16;
                bShock = true;
                npc.direct = 0;
                Boss.gBoss[3].act_no = 10;
                Boss.gBoss[4].ani_no = 0;
                break;
            }
            case 20: {
                npc.act_no = 210;
                bShock = true;
                npc.direct = 0;
                Boss.gBoss[1].act_no = 5;
                Boss.gBoss[2].act_no = 5;
                Boss.gBoss[6].act_no = 5;
                Boss.gBoss[7].act_no = 5;
                break;
            }
            case 200: {
                npc.act_no = 201;
                npc.act_wait = 0;
                Boss.gBoss[3].act_no = 0;
                Boss.gBoss[4].ani_no = 2;
                Boss.gBoss[5].ani_no = 0;
                Boss.gBoss[8].bits = (char)(Boss.gBoss[8].bits & 0xFFFFFFFB);
                Boss.gBoss[9].bits = (char)(Boss.gBoss[9].bits & 0xFFFFFFFB);
                Boss.gBoss[10].bits = (char)(Boss.gBoss[10].bits & 0xFFFFFFFB);
                Boss.gBoss[11].bits = (char)(Boss.gBoss[11].bits & 0xFFFFFFDF);
                NpChar.gSuperYpos = 0;
                MyChar.CutNoise();
                bShock = true;
            }
            case 201: {
                ++npc.act_wait;
                if (npc.direct != 2 && npc.ani_no <= 0 && npc.life >= 200 || npc.act_wait <= 200) break;
                ++npc.count1;
                Sound.PlaySoundObject(115, 1);
                if (npc.life < 200) {
                    npc.act_no = 230;
                    break;
                }
                if (npc.count1 > 2) {
                    npc.act_no = 220;
                    break;
                }
                npc.act_no = 210;
                break;
            }
            case 210: {
                npc.act_no = 211;
                npc.act_wait = 0;
                Boss.gBoss[3].act_no = 10;
                Boss.gBoss[8].bits = (char)(Boss.gBoss[8].bits | 4);
                Boss.gBoss[9].bits = (char)(Boss.gBoss[9].bits | 4);
                Boss.gBoss[10].bits = (char)(Boss.gBoss[10].bits | 4);
                Boss.gBoss[11].bits = (char)(Boss.gBoss[11].bits | 0x20);
                life = npc.life;
                bShock = true;
            }
            case 211: {
                flash = (char)(flash + '\u0001');
                if (npc.shock != '\u0000' && flash / 2 % 2 != 0) {
                    Boss.gBoss[4].ani_no = 1;
                    Boss.gBoss[5].ani_no = 1;
                } else {
                    Boss.gBoss[4].ani_no = 0;
                    Boss.gBoss[5].ani_no = 0;
                }
                ++npc.act_wait;
                if (npc.act_wait % 100 == 1) {
                    NpChar.gCurlyShoot_wait = Game.Random(80, 100);
                    NpChar.gCurlyShoot_x = Boss.gBoss[11].x;
                    NpChar.gCurlyShoot_y = Boss.gBoss[11].y;
                }
                if (npc.act_wait < 300) {
                    if (npc.act_wait % 120 == 1) {
                        NpChar.SetNpChar(288, npc.x - 16384, npc.y - 8192, 0, 0, 1, null, 32);
                    }
                    if (npc.act_wait % 120 == 61) {
                        NpChar.SetNpChar(288, npc.x - 16384, npc.y + 8192, 0, 0, 3, null, 32);
                    }
                }
                if (npc.life >= life - 50 && npc.act_wait <= 400) break;
                npc.act_no = 200;
                break;
            }
            case 220: {
                npc.act_no = 221;
                npc.act_wait = 0;
                npc.count1 = 0;
                NpChar.gSuperYpos = 1;
                Boss.gBoss[3].act_no = 20;
                Boss.gBoss[8].bits = (char)(Boss.gBoss[8].bits | 4);
                Boss.gBoss[9].bits = (char)(Boss.gBoss[9].bits | 4);
                Boss.gBoss[10].bits = (char)(Boss.gBoss[10].bits | 4);
                Boss.gBoss[11].bits = (char)(Boss.gBoss[11].bits | 0x20);
                Frame.SetQuake(100);
                life = npc.life;
                bShock = true;
            }
            case 221: {
                ++npc.act_wait;
                if (npc.act_wait % 40 == 1) {
                    switch (Game.Random(0, 3)) {
                        case 0: {
                            x = Boss.gBoss[1].x;
                            y = Boss.gBoss[1].y;
                            break;
                        }
                        case 1: {
                            x = Boss.gBoss[2].x;
                            y = Boss.gBoss[2].y;
                            break;
                        }
                        case 2: {
                            x = Boss.gBoss[6].x;
                            y = Boss.gBoss[6].y;
                            break;
                        }
                        case 3: {
                            x = Boss.gBoss[7].x;
                            y = Boss.gBoss[7].y;
                        }
                    }
                    Sound.PlaySoundObject(25, 1);
                    NpChar.SetNpChar(285, x - 8192, y, 0, 0, 0, null, 256);
                    NpChar.SetNpChar(285, x - 8192, y, 0, 0, 1024, null, 256);
                }
                flash = (char)(flash + '\u0001');
                if (npc.shock != '\u0000' && flash / 2 % 2 != 0) {
                    Boss.gBoss[4].ani_no = 1;
                    Boss.gBoss[5].ani_no = 1;
                } else {
                    Boss.gBoss[4].ani_no = 0;
                    Boss.gBoss[5].ani_no = 0;
                }
                if (npc.life >= life - 150 && npc.act_wait <= 400 && npc.life >= 200) break;
                npc.act_no = 200;
                break;
            }
            case 230: {
                npc.act_no = 231;
                npc.act_wait = 0;
                Boss.gBoss[3].act_no = 30;
                Boss.gBoss[8].bits = (char)(Boss.gBoss[8].bits | 4);
                Boss.gBoss[9].bits = (char)(Boss.gBoss[9].bits | 4);
                Boss.gBoss[10].bits = (char)(Boss.gBoss[10].bits | 4);
                Boss.gBoss[11].bits = (char)(Boss.gBoss[11].bits | 0x20);
                Sound.PlaySoundObject(25, 1);
                NpChar.SetNpChar(285, Boss.gBoss[3].x - 8192, Boss.gBoss[3].y, 0, 0, 0, null, 256);
                NpChar.SetNpChar(285, Boss.gBoss[3].x - 8192, Boss.gBoss[3].y, 0, 0, 1024, null, 256);
                NpChar.SetNpChar(285, Boss.gBoss[3].x, Boss.gBoss[3].y - 8192, 0, 0, 0, null, 256);
                NpChar.SetNpChar(285, Boss.gBoss[3].x, Boss.gBoss[3].y - 8192, 0, 0, 1024, null, 256);
                NpChar.SetNpChar(285, Boss.gBoss[3].x, Boss.gBoss[3].y + 8192, 0, 0, 0, null, 256);
                NpChar.SetNpChar(285, Boss.gBoss[3].x, Boss.gBoss[3].y + 8192, 0, 0, 1024, null, 256);
                life = npc.life;
                bShock = true;
            }
            case 231: {
                flash = (char)(flash + '\u0001');
                if (npc.shock != '\u0000' && flash / 2 % 2 != 0) {
                    Boss.gBoss[4].ani_no = 1;
                    Boss.gBoss[5].ani_no = 1;
                } else {
                    Boss.gBoss[4].ani_no = 0;
                    Boss.gBoss[5].ani_no = 0;
                }
                if (++npc.act_wait % 100 == 1) {
                    NpChar.gCurlyShoot_wait = Game.Random(80, 100);
                    NpChar.gCurlyShoot_x = Boss.gBoss[11].x;
                    NpChar.gCurlyShoot_y = Boss.gBoss[11].y;
                }
                if (npc.act_wait % 120 == 1) {
                    NpChar.SetNpChar(288, npc.x - 16384, npc.y - 8192, 0, 0, 1, null, 32);
                }
                if (npc.act_wait % 120 != 61) break;
                NpChar.SetNpChar(288, npc.x - 16384, npc.y + 8192, 0, 0, 3, null, 32);
                break;
            }
            case 500: {
                MyChar.CutNoise();
                npc.act_no = 501;
                npc.act_wait = 0;
                npc.xm = 0;
                npc.ym = 0;
                Boss.gBoss[3].act_no = 0;
                Boss.gBoss[4].ani_no = 2;
                Boss.gBoss[5].ani_no = 0;
                Boss.gBoss[1].act_no = 5;
                Boss.gBoss[2].act_no = 5;
                Boss.gBoss[6].act_no = 5;
                Boss.gBoss[7].act_no = 5;
                Frame.SetQuake(20);
                for (i = 0; i < 100; ++i) {
                    NpChar.SetNpChar(4, npc.x + Game.Random(-128, 128) * 512, npc.y + Game.Random(-64, 64) * 512, Game.Random(-128, 128) * 512, Game.Random(-128, 128) * 512, 0, null, 0);
                }
                NpChar.DeleteNpCharCode(282, true);
                Boss.gBoss[11].bits = (char)(Boss.gBoss[11].bits & 0xFFFFFFDF);
                for (i = 0; i < 12; ++i) {
                    Boss.gBoss[i].bits = (char)(Boss.gBoss[i].bits & 0xFFFFFFFB);
                }
            }
            case 501: {
                ++npc.act_wait;
                if (npc.act_wait % 16 != 0) {
                    NpChar.SetNpChar(4, npc.x + Game.Random(-64, 64) * 512, npc.y + Game.Random(-32, 32) * 512, Game.Random(-128, 128) * 512, Game.Random(-128, 128) * 512, 0, null, 256);
                }
                npc.x += 64;
                npc.y += 128;
                if (npc.act_wait <= 200) break;
                npc.act_wait = 0;
                npc.act_no = 1000;
                break;
            }
            case 1000: {
                Frame.SetQuake(100);
                ++Boss.gBoss[0].act_wait;
                if (Boss.gBoss[0].act_wait % 8 == 0) {
                    Sound.PlaySoundObject(44, 1);
                }
                NpChar.SetDestroyNpChar(Boss.gBoss[0].x + Game.Random(-72, 72) * 512, Boss.gBoss[0].y + Game.Random(-64, 64) * 512, 1, 1);
                if (Boss.gBoss[0].act_wait <= 100) break;
                Boss.gBoss[0].act_wait = 0;
                Boss.gBoss[0].act_no = 1001;
                Flash.SetFlash(Boss.gBoss[0].x, Boss.gBoss[0].y, 1);
                Sound.PlaySoundObject(35, 1);
                break;
            }
            case 1001: {
                Frame.SetQuake(40);
                ++Boss.gBoss[0].act_wait;
                if (Boss.gBoss[0].act_wait <= 50) break;
                for (i = 0; i < 20; ++i) {
                    Boss.gBoss[i].cond = 0;
                }
                NpChar.DeleteNpCharCode(158, true);
                NpChar.DeleteNpCharCode(301, true);
            }
        }
        if (bShock) {
            Frame.SetQuake(20);
            if (npc.act_no == 201) {
                Boss.gBoss[7].act_no = 10;
                Boss.gBoss[6].act_no = 10;
                Boss.gBoss[2].act_no = 10;
                Boss.gBoss[1].act_no = 10;
            }
            if (npc.act_no == 221) {
                Boss.gBoss[7].act_no = 20;
                Boss.gBoss[6].act_no = 20;
                Boss.gBoss[2].act_no = 20;
                Boss.gBoss[1].act_no = 20;
            }
            if (npc.act_no == 231) {
                Boss.gBoss[7].act_no = 30;
                Boss.gBoss[6].act_no = 30;
                Boss.gBoss[2].act_no = 30;
                Boss.gBoss[1].act_no = 30;
            }
            Sound.PlaySoundObject(26, 1);
            for (i = 0; i < 8; ++i) {
                NpChar.SetNpChar(4, Boss.gBoss[4].x + Game.Random(-32, 16) * 512, Boss.gBoss[4].y, Game.Random(-512, 512), Game.Random(-256, 256), 0, null, 256);
            }
        }
        if (npc.act_no >= 200 && npc.act_no < 300) {
            if (npc.x < 98304) {
                npc.direct = 2;
            }
            if (npc.x > (Map.gMap.width - 4) * 8192) {
                npc.direct = 0;
            }
            npc.xm = npc.direct == 0 ? (npc.xm -= 4) : (npc.xm += 4);
        }
        switch (npc.act_no) {
            case 201: 
            case 211: 
            case 221: 
            case 231: {
                ++npc.count2;
                if (npc.count2 == 150) {
                    npc.count2 = 0;
                    NpChar.SetNpChar(282, Map.gMap.width * 512 * 16 + 64, (Game.Random(-1, 3) + 10) * 8192, 0, 0, 0, null, 48);
                    break;
                }
                if (npc.count2 != 75) break;
                NpChar.SetNpChar(282, Map.gMap.width * 512 * 16 + 64, (Game.Random(-3, 0) + 3) * 8192, 0, 0, 0, null, 48);
            }
        }
        if (npc.xm > 128) {
            npc.xm = 128;
        }
        if (npc.xm < -128) {
            npc.xm = -128;
        }
        if (npc.ym > 128) {
            npc.ym = 128;
        }
        if (npc.ym < -128) {
            npc.ym = -128;
        }
        npc.x += npc.xm;
        npc.y += npc.ym;
        BossAlmo2.ActBossCharA_Face(Boss.gBoss[3]);
        BossAlmo2.ActBossCharA_Head(Boss.gBoss[4]);
        BossAlmo2.ActBossCharA_Tail(Boss.gBoss[5]);
        BossAlmo2.ActBossCharA_Mini(Boss.gBoss[1]);
        BossAlmo2.ActBossCharA_Mini(Boss.gBoss[2]);
        BossAlmo2.ActBossCharA_Mini(Boss.gBoss[6]);
        BossAlmo2.ActBossCharA_Mini(Boss.gBoss[7]);
        BossAlmo2.ActBossCharA_Hit(Boss.gBoss[8]);
        BossAlmo2.ActBossCharA_Hit(Boss.gBoss[9]);
        BossAlmo2.ActBossCharA_Hit(Boss.gBoss[10]);
        BossAlmo2.ActBossCharA_Hit(Boss.gBoss[11]);
    }
}
