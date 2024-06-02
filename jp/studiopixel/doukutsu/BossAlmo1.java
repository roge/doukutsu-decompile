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

public class BossAlmo1 {
    private static final RECT[] ActBossChar_Core_Face_rect = new RECT[]{new RECT(0, 0, 72, 112), new RECT(0, 112, 72, 224), new RECT(160, 0, 232, 112), new RECT(0, 0, 0, 0)};
    private static final RECT[] ActBossChar_Core_Tail_rect = new RECT[]{new RECT(72, 0, 160, 112), new RECT(72, 112, 160, 224), new RECT(0, 0, 0, 0)};
    private static final RECT[] ActBossChar_Core_Mini_rect = new RECT[]{new RECT(256, 0, 320, 40), new RECT(256, 40, 320, 80), new RECT(256, 80, 320, 120)};
    private static char flash = '\u0000';

    public static void ActBossChar_Core_Face(NpChar.NPCHAR npc) {
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
                if (npc.act_wait == 0) {
                    npc.act_no = 100;
                    npc.ani_no = 3;
                }
                npc.x = Boss.gBoss[0].x - 18432;
                npc.y = Boss.gBoss[0].y;
                break;
            }
            case 100: {
                npc.ani_no = 3;
            }
        }
        npc.rect.copyFrom(ActBossChar_Core_Face_rect[npc.ani_no]);
        if (npc.act_no == 51) {
            npc.rect.bottom = npc.rect.top + npc.act_wait;
        }
    }

    public static void ActBossChar_Core_Tail(NpChar.NPCHAR npc) {
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
                if (npc.act_wait == 0) {
                    npc.act_no = 100;
                    npc.ani_no = 2;
                }
                npc.x = Boss.gBoss[0].x + 22528;
                npc.y = Boss.gBoss[0].y;
                break;
            }
            case 100: {
                npc.ani_no = 2;
            }
        }
        npc.rect.copyFrom(ActBossChar_Core_Tail_rect[npc.ani_no]);
        if (npc.act_no == 51) {
            npc.rect.bottom = npc.rect.top + npc.act_wait;
        }
    }

    public static void ActBossChar_Core_Mini(NpChar.NPCHAR npc) {
        npc.life = 1000;
        switch (npc.act_no) {
            case 10: {
                npc.ani_no = 2;
                npc.bits = (char)(npc.bits & 0xFFFFFFDF);
                break;
            }
            case 100: {
                npc.act_no = 101;
                npc.ani_no = 2;
                npc.act_wait = 0;
                npc.tgt_x = Boss.gBoss[0].x + Game.Random(-128, 32) * 512;
                npc.tgt_y = Boss.gBoss[0].y + Game.Random(-64, 64) * 512;
                npc.bits = (char)(npc.bits | 0x20);
            }
            case 101: {
                npc.x += (npc.tgt_x - npc.x) / 16;
                npc.y += (npc.tgt_y - npc.y) / 16;
                ++npc.act_wait;
                if (npc.act_wait <= 50) break;
                npc.ani_no = 0;
                break;
            }
            case 120: {
                npc.act_no = 121;
                npc.act_wait = 0;
            }
            case 121: {
                ++npc.act_wait;
                npc.ani_no = npc.act_wait / 2 % 2 != 0 ? 0 : 1;
                if (npc.act_wait <= 20) break;
                npc.act_no = 130;
                break;
            }
            case 130: {
                npc.act_no = 131;
                npc.ani_no = 2;
                npc.act_wait = 0;
                npc.tgt_x = npc.x + Game.Random(24, 48) * 512;
                npc.tgt_y = npc.y + Game.Random(-4, 4) * 512;
            }
            case 131: {
                npc.x += (npc.tgt_x - npc.x) / 16;
                npc.y += (npc.tgt_y - npc.y) / 16;
                ++npc.act_wait;
                if (npc.act_wait > 50) {
                    npc.act_no = 140;
                    npc.ani_no = 0;
                }
                if (npc.act_wait != 1 && npc.act_wait != 3) break;
                char deg = (char)Triangle.GetArktan(npc.x - MyChar.gMC.x, npc.y - MyChar.gMC.y);
                deg = (char)(deg + (char)Game.Random(-2, 2) & 0xFF);
                int ym = Triangle.GetSin(deg) * 2;
                int xm = Triangle.GetCos(deg) * 2;
                NpChar.SetNpChar(178, npc.x, npc.y, xm, ym, 0, null, 256);
                Sound.PlaySoundObject(39, 1);
                break;
            }
            case 140: {
                npc.x += (npc.tgt_x - npc.x) / 16;
                npc.y += (npc.tgt_y - npc.y) / 16;
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
        if (npc.shock != '\u0000') {
            npc.tgt_x += 1024;
        }
        npc.rect.copyFrom(ActBossChar_Core_Mini_rect[npc.ani_no]);
    }

    public static void ActBossChar_Core_Hit(NpChar.NPCHAR npc) {
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

    public static void ActBossChar_Core() {
        int i;
        NpChar.NPCHAR npc = Boss.gBoss[0];
        boolean bShock = false;
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 10;
                npc.exp = 1;
                npc.cond = (byte)-128;
                npc.bits = (char)32780;
                npc.life = 650;
                npc.hit_voice = 114;
                npc.x = 630784;
                npc.y = 114688;
                npc.xm = 0;
                npc.ym = 0;
                npc.code_event = 1000;
                npc.bits = (char)(npc.bits | 0x200);
                Boss.gBoss[4].cond = (byte)-128;
                Boss.gBoss[4].act_no = 10;
                Boss.gBoss[5].cond = (byte)-128;
                Boss.gBoss[5].act_no = 10;
                Boss.gBoss[8].cond = (byte)-128;
                Boss.gBoss[8].bits = (char)12;
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
                Boss.gBoss[1].act_no = 10;
                Boss.gBoss[1].bits = (char)44;
                Boss.gBoss[1].life = 1000;
                Boss.gBoss[1].hit_voice = 54;
                Boss.gBoss[1].hit.back = 12288;
                Boss.gBoss[1].hit.top = 8192;
                Boss.gBoss[1].hit.bottom = 8192;
                Boss.gBoss[1].view.front = 16384;
                Boss.gBoss[1].view.top = 10240;
                Boss.gBoss[1].x = npc.x - 4096;
                Boss.gBoss[1].y = npc.y - 32768;
                Boss.gBoss[2].copyFrom(Boss.gBoss[1]);
                Boss.gBoss[2].x = npc.x + 8192;
                Boss.gBoss[2].y = npc.y;
                Boss.gBoss[3].copyFrom(Boss.gBoss[1]);
                Boss.gBoss[3].x = npc.x - 4096;
                Boss.gBoss[3].y = npc.y + 32768;
                Boss.gBoss[6].copyFrom(Boss.gBoss[1]);
                Boss.gBoss[6].x = npc.x - 24576;
                Boss.gBoss[6].y = npc.y - 16384;
                Boss.gBoss[7].copyFrom(Boss.gBoss[1]);
                Boss.gBoss[7].x = npc.x - 24576;
                Boss.gBoss[7].y = npc.y + 16384;
                break;
            }
            case 200: {
                npc.act_no = 201;
                npc.act_wait = 0;
                Boss.gBoss[11].bits = (char)(Boss.gBoss[11].bits & 0xFFFFFFDF);
                NpChar.gSuperYpos = 0;
                MyChar.CutNoise();
            }
            case 201: {
                npc.tgt_x = MyChar.gMC.x;
                npc.tgt_y = MyChar.gMC.y;
                ++npc.act_wait;
                if (npc.act_wait <= 400) break;
                ++npc.count1;
                Sound.PlaySoundObject(115, 1);
                if (npc.count1 > 3) {
                    npc.count1 = 0;
                    npc.act_no = 220;
                    Boss.gBoss[4].ani_no = 0;
                    Boss.gBoss[5].ani_no = 0;
                    bShock = true;
                    break;
                }
                npc.act_no = 210;
                Boss.gBoss[4].ani_no = 0;
                Boss.gBoss[5].ani_no = 0;
                bShock = true;
                break;
            }
            case 210: {
                npc.act_no = 211;
                npc.act_wait = 0;
                npc.count2 = npc.life;
                Boss.gBoss[11].bits = (char)(Boss.gBoss[11].bits | 0x20);
            }
            case 211: {
                npc.tgt_x = MyChar.gMC.x;
                npc.tgt_y = MyChar.gMC.y;
                if (npc.shock != '\u0000') {
                    if ((flash = (char)(flash + '\u0001')) / 2 % 2 != 0) {
                        Boss.gBoss[4].ani_no = 0;
                        Boss.gBoss[5].ani_no = 0;
                    } else {
                        Boss.gBoss[4].ani_no = 1;
                        Boss.gBoss[5].ani_no = 1;
                    }
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
                if (npc.act_wait < 200 && npc.act_wait % 20 == 1) {
                    NpChar.SetNpChar(179, npc.x + Game.Random(-48, -16) * 512, npc.y + Game.Random(-64, 64) * 512, 0, 0, 0, null, 256);
                }
                if (npc.act_wait <= 400 && npc.life >= npc.count2 - 200) break;
                npc.act_no = 200;
                Boss.gBoss[4].ani_no = 2;
                Boss.gBoss[5].ani_no = 0;
                bShock = true;
                break;
            }
            case 220: {
                npc.act_no = 221;
                npc.act_wait = 0;
                NpChar.gSuperYpos = 1;
                Boss.gBoss[11].bits = (char)(Boss.gBoss[11].bits | 0x20);
                Frame.SetQuake(100);
                MyChar.SetNoise(1, 1000);
            }
            case 221: {
                ++npc.act_wait;
                NpChar.SetNpChar(199, MyChar.gMC.x + Game.Random(-50, 150) * 512 * 2, MyChar.gMC.y + Game.Random(-160, 160) * 512, 0, 0, 0, null, 256);
                MyChar.gMC.xm -= 32;
                MyChar.gMC.cond = (char)(MyChar.gMC.cond | 0x20);
                if (npc.shock != '\u0000') {
                    if ((flash = (char)(flash + '\u0001')) / 2 % 2 != 0) {
                        Boss.gBoss[4].ani_no = 0;
                        Boss.gBoss[5].ani_no = 0;
                    } else {
                        Boss.gBoss[4].ani_no = 1;
                        Boss.gBoss[5].ani_no = 1;
                    }
                } else {
                    Boss.gBoss[4].ani_no = 0;
                    Boss.gBoss[5].ani_no = 0;
                }
                if (npc.act_wait == 300 || npc.act_wait == 350 || npc.act_wait == 400) {
                    char deg = (char)Triangle.GetArktan(npc.x - MyChar.gMC.x, npc.y - MyChar.gMC.y);
                    int ym = Triangle.GetSin(deg) * 3;
                    int xm = Triangle.GetCos(deg) * 3;
                    NpChar.SetNpChar(218, npc.x - 20480, npc.y, xm, ym, 0, null, 256);
                    Sound.PlaySoundObject(101, 1);
                }
                if (npc.act_wait <= 400) break;
                npc.act_no = 200;
                Boss.gBoss[4].ani_no = 2;
                Boss.gBoss[5].ani_no = 0;
                bShock = true;
                break;
            }
            case 500: {
                MyChar.CutNoise();
                npc.act_no = 501;
                npc.act_wait = 0;
                npc.xm = 0;
                npc.ym = 0;
                Boss.gBoss[4].ani_no = 2;
                Boss.gBoss[5].ani_no = 0;
                Boss.gBoss[1].act_no = 200;
                Boss.gBoss[2].act_no = 200;
                Boss.gBoss[3].act_no = 200;
                Boss.gBoss[6].act_no = 200;
                Boss.gBoss[7].act_no = 200;
                Frame.SetQuake(20);
                for (i = 0; i < 32; ++i) {
                    NpChar.SetNpChar(4, npc.x + Game.Random(-128, 128) * 512, npc.y + Game.Random(-64, 64) * 512, Game.Random(-128, 128) * 512, Game.Random(-128, 128) * 512, 0, null, 256);
                }
                for (i = 0; i < 12; ++i) {
                    Boss.gBoss[i].bits = (char)(Boss.gBoss[i].bits & 0xFFFFFFDB);
                }
            }
            case 501: {
                ++npc.act_wait;
                if (npc.act_wait % 16 != 0) {
                    NpChar.SetNpChar(4, npc.x + Game.Random(-64, 64) * 512, npc.y + Game.Random(-32, 32) * 512, Game.Random(-128, 128) * 512, Game.Random(-128, 128) * 512, 0, null, 256);
                }
                npc.x = npc.act_wait / 2 % 2 != 0 ? (npc.x -= 512) : (npc.x += 512);
                npc.x = npc.x < 516096 ? (npc.x += 128) : (npc.x -= 128);
                if (npc.y < 90112) {
                    npc.y += 128;
                    break;
                }
                npc.y -= 128;
                break;
            }
            case 600: {
                npc.act_no = 601;
                Boss.gBoss[4].act_no = 50;
                Boss.gBoss[5].act_no = 50;
                Boss.gBoss[8].bits = (char)(Boss.gBoss[8].bits & 0xFFFFFFFB);
                Boss.gBoss[9].bits = (char)(Boss.gBoss[9].bits & 0xFFFFFFFB);
                Boss.gBoss[10].bits = (char)(Boss.gBoss[10].bits & 0xFFFFFFFB);
                Boss.gBoss[11].bits = (char)(Boss.gBoss[11].bits & 0xFFFFFFFB);
            }
            case 601: {
                ++npc.act_wait;
                if (npc.act_wait / 2 % 2 != 0) {
                    npc.x -= 2048;
                    break;
                }
                npc.x += 2048;
            }
        }
        if (bShock) {
            Frame.SetQuake(20);
            Boss.gBoss[1].act_no = 100;
            Boss.gBoss[2].act_no = 100;
            Boss.gBoss[3].act_no = 100;
            Boss.gBoss[6].act_no = 100;
            Boss.gBoss[7].act_no = 100;
            Sound.PlaySoundObject(26, 1);
            for (i = 0; i < 8; ++i) {
                NpChar.SetNpChar(4, Boss.gBoss[4].x + Game.Random(-32, 16) * 512, Boss.gBoss[4].y, Game.Random(-512, 512), Game.Random(-256, 256), 0, null, 256);
            }
        }
        if (npc.act_no >= 200 && npc.act_no < 300) {
            switch (npc.act_wait) {
                case 80: {
                    Boss.gBoss[1].act_no = 120;
                    break;
                }
                case 110: {
                    Boss.gBoss[2].act_no = 120;
                    break;
                }
                case 140: {
                    Boss.gBoss[3].act_no = 120;
                    break;
                }
                case 170: {
                    Boss.gBoss[6].act_no = 120;
                    break;
                }
                case 200: {
                    Boss.gBoss[7].act_no = 120;
                }
            }
            if (npc.x < npc.tgt_x + 81920) {
                npc.xm += 4;
            }
            if (npc.x > npc.tgt_x + 81920) {
                npc.xm -= 4;
            }
            if (npc.y < npc.tgt_y) {
                npc.ym += 4;
            }
            if (npc.y > npc.tgt_y) {
                npc.ym -= 4;
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
        BossAlmo1.ActBossChar_Core_Face(Boss.gBoss[4]);
        BossAlmo1.ActBossChar_Core_Tail(Boss.gBoss[5]);
        BossAlmo1.ActBossChar_Core_Mini(Boss.gBoss[1]);
        BossAlmo1.ActBossChar_Core_Mini(Boss.gBoss[2]);
        BossAlmo1.ActBossChar_Core_Mini(Boss.gBoss[3]);
        BossAlmo1.ActBossChar_Core_Mini(Boss.gBoss[6]);
        BossAlmo1.ActBossChar_Core_Mini(Boss.gBoss[7]);
        BossAlmo1.ActBossChar_Core_Hit(Boss.gBoss[8]);
        BossAlmo1.ActBossChar_Core_Hit(Boss.gBoss[9]);
        BossAlmo1.ActBossChar_Core_Hit(Boss.gBoss[10]);
        BossAlmo1.ActBossChar_Core_Hit(Boss.gBoss[11]);
    }
}
