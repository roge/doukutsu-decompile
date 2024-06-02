/*
 * Decompiled with CFR 0.152.
 */
package jp.studiopixel.doukutsu;

import jp.studiopixel.doukutsu.Boss;
import jp.studiopixel.doukutsu.Frame;
import jp.studiopixel.doukutsu.Game;
import jp.studiopixel.doukutsu.MyChar;
import jp.studiopixel.doukutsu.NpChar;
import jp.studiopixel.doukutsu.RECT;
import jp.studiopixel.doukutsu.Sound;
import jp.studiopixel.doukutsu.Triangle;

public class BossFrog {
    private static final RECT[] ActBossChar_Frog_rcLeft = new RECT[]{new RECT(0, 0, 0, 0), new RECT(0, 48, 80, 112), new RECT(0, 112, 80, 176), new RECT(0, 176, 80, 240), new RECT(160, 48, 240, 112), new RECT(160, 112, 240, 200), new RECT(200, 0, 240, 24), new RECT(80, 0, 120, 24), new RECT(120, 0, 160, 24)};
    private static final RECT[] ActBossChar_Frog_rcRight = new RECT[]{new RECT(0, 0, 0, 0), new RECT(80, 48, 160, 112), new RECT(80, 112, 160, 176), new RECT(80, 176, 160, 240), new RECT(240, 48, 320, 112), new RECT(240, 112, 320, 200), new RECT(200, 24, 240, 48), new RECT(80, 24, 120, 48), new RECT(120, 24, 160, 48)};

    private static void ActBossChar02_01() {
        int minus = Boss.gBoss[0].direct == 0 ? 1 : -1;
        NpChar.NPCHAR boss = Boss.gBoss[1];
        switch (Boss.gBoss[0].ani_no) {
            case 0: {
                boss.hit_voice = 52;
                boss.hit.front = 8192;
                boss.hit.top = 8192;
                boss.hit.back = 8192;
                boss.hit.bottom = 8192;
                boss.size = 3;
                boss.bits = (char)4;
                break;
            }
            case 1: {
                boss.x = Boss.gBoss[0].x + -12288 * minus;
                boss.y = Boss.gBoss[0].y - 12288;
                break;
            }
            case 2: {
                boss.x = Boss.gBoss[0].x + -12288 * minus;
                boss.y = Boss.gBoss[0].y - 10240;
                break;
            }
            case 3: 
            case 4: {
                boss.x = Boss.gBoss[0].x + -12288 * minus;
                boss.y = Boss.gBoss[0].y - 8192;
                break;
            }
            case 5: {
                boss.x = Boss.gBoss[0].x + -12288 * minus;
                boss.y = Boss.gBoss[0].y - 22016;
            }
        }
    }

    private static void ActBossChar02_02() {
        NpChar.NPCHAR boss = Boss.gBoss[2];
        switch (Boss.gBoss[0].ani_no) {
            case 0: {
                boss.hit_voice = 52;
                boss.hit.front = 12288;
                boss.hit.top = 8192;
                boss.hit.back = 12288;
                boss.hit.bottom = 8192;
                boss.size = 3;
                boss.bits = (char)4;
                break;
            }
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 5: {
                boss.x = Boss.gBoss[0].x;
                boss.y = Boss.gBoss[0].y;
            }
        }
    }

    public static void ActBossChar_Frog() {
        NpChar.NPCHAR boss = Boss.gBoss[0];
        switch (boss.act_no) {
            case 0: {
                boss.x = 49152;
                boss.y = 102400;
                boss.direct = 2;
                boss.view.front = 24576;
                boss.view.top = 24576;
                boss.view.back = 16384;
                boss.view.bottom = 8192;
                boss.hit_voice = 52;
                boss.hit.front = 12288;
                boss.hit.top = 8192;
                boss.hit.back = 12288;
                boss.hit.bottom = 8192;
                boss.size = 3;
                boss.exp = 1;
                boss.code_event = 1000;
                boss.bits = (char)(boss.bits | 0x8200);
                boss.life = 300;
                break;
            }
            case 10: {
                boss.act_no = 11;
                boss.ani_no = 3;
                boss.cond = (byte)-128;
                boss.rect.copyFrom(ActBossChar_Frog_rcRight[0]);
                Boss.gBoss[1].cond = (byte)-112;
                Boss.gBoss[1].code_event = 1000;
                Boss.gBoss[2].cond = (byte)-128;
                Boss.gBoss[1].damage = 5;
                Boss.gBoss[2].damage = 5;
                for (int i = 0; i < 8; ++i) {
                    NpChar.SetNpChar(4, boss.x + Game.Random(-12, 12) * 512, boss.y + Game.Random(-12, 12) * 512, Game.Random(-341, 341), Game.Random(-1536, 0), 0, null, 256);
                }
                break;
            }
            case 20: {
                boss.act_no = 21;
                boss.act_wait = 0;
            }
            case 21: {
                ++boss.act_wait;
                if (boss.act_wait / 2 % 2 != 0) {
                    boss.ani_no = 3;
                    break;
                }
                boss.ani_no = 0;
                break;
            }
            case 100: {
                boss.act_no = 101;
                boss.act_wait = 0;
                boss.ani_no = 1;
                boss.xm = 0;
            }
            case 101: {
                ++boss.act_wait;
                if (boss.act_wait <= 50) break;
                boss.act_no = 102;
                boss.ani_wait = 0;
                boss.ani_no = 2;
                break;
            }
            case 102: {
                ++boss.ani_wait;
                if (boss.ani_wait <= 10) break;
                boss.act_no = 103;
                boss.ani_wait = 0;
                boss.ani_no = 1;
                break;
            }
            case 103: {
                ++boss.ani_wait;
                if (boss.ani_wait <= 4) break;
                boss.act_no = 104;
                boss.ani_no = 5;
                boss.ym = -1024;
                Sound.PlaySoundObject(25, 1);
                boss.xm = boss.direct == 0 ? -512 : 512;
                boss.view.top = 32768;
                boss.view.bottom = 12288;
                break;
            }
            case 104: {
                if (boss.direct == 0 && (boss.flag & 1) != 0) {
                    boss.direct = 2;
                    boss.xm = 512;
                }
                if (boss.direct == 2 && (boss.flag & 4) != 0) {
                    boss.direct = 0;
                    boss.xm = -512;
                }
                if ((boss.flag & 8) == 0) break;
                Sound.PlaySoundObject(26, 1);
                Frame.SetQuake(30);
                boss.act_no = 100;
                boss.ani_no = 1;
                boss.view.top = 24576;
                boss.view.bottom = 8192;
                if (boss.direct == 0 && boss.x < MyChar.gMC.x) {
                    boss.direct = 2;
                    boss.act_no = 110;
                }
                if (boss.direct == 2 && boss.x > MyChar.gMC.x) {
                    boss.direct = 0;
                    boss.act_no = 110;
                }
                NpChar.SetNpChar(110, Game.Random(4, 16) * 8192, Game.Random(0, 4) * 8192, 0, 0, 4, null, 128);
                for (int i = 0; i < 4; ++i) {
                    NpChar.SetNpChar(4, boss.x + Game.Random(-12, 12) * 512, boss.y + boss.hit.bottom, Game.Random(-341, 341), Game.Random(-1536, 0), 0, null, 256);
                }
                break;
            }
            case 110: {
                boss.ani_no = 1;
                boss.act_wait = 0;
                boss.act_no = 111;
            }
            case 111: {
                ++boss.act_wait;
                boss.xm = boss.xm * 8 / 9;
                if (boss.act_wait <= 50) break;
                boss.ani_no = 2;
                boss.ani_wait = 0;
                boss.act_no = 112;
                break;
            }
            case 112: {
                ++boss.ani_wait;
                if (boss.ani_wait <= 4) break;
                boss.act_no = 113;
                boss.act_wait = 0;
                boss.ani_no = 3;
                boss.count1 = 16;
                Boss.gBoss[1].bits = (char)(Boss.gBoss[1].bits | 0x20);
                boss.tgt_x = boss.life;
                break;
            }
            case 113: {
                if (boss.shock != '\u0000') {
                    boss.ani_no = boss.count2++ / 2 % 2 != 0 ? 4 : 3;
                } else {
                    boss.count2 = 0;
                    boss.ani_no = 3;
                }
                boss.xm = boss.xm * 10 / 11;
                ++boss.act_wait;
                if (boss.act_wait <= 16) break;
                boss.act_wait = 0;
                --boss.count1;
                char deg = boss.direct == 0 ? (char)Triangle.GetArktan(boss.x - 16384 - MyChar.gMC.x, boss.y - 4096 - MyChar.gMC.y) : (char)Triangle.GetArktan(boss.x + 16384 - MyChar.gMC.x, boss.y - 4096 - MyChar.gMC.y);
                deg = (char)(deg + (char)Game.Random(-16, 16) & 0xFF);
                int ym = Triangle.GetSin(deg);
                int xm = Triangle.GetCos(deg);
                if (boss.direct == 0) {
                    NpChar.SetNpChar(108, boss.x - 16384, boss.y - 4096, xm, ym, 0, null, 256);
                } else {
                    NpChar.SetNpChar(108, boss.x + 16384, boss.y - 4096, xm, ym, 0, null, 256);
                }
                Sound.PlaySoundObject(39, 1);
                if (boss.count1 != 0 && boss.life >= boss.tgt_x - 90) break;
                boss.act_no = 114;
                boss.act_wait = 0;
                boss.ani_no = 2;
                boss.ani_wait = 0;
                Boss.gBoss[1].bits = (char)(Boss.gBoss[1].bits & 0xFFFFFFDF);
                break;
            }
            case 114: {
                ++boss.ani_wait;
                if (boss.ani_wait <= 10) break;
                if (++Boss.gBoss[1].count1 > 2) {
                    Boss.gBoss[1].count1 = 0;
                    boss.act_no = 120;
                } else {
                    boss.act_no = 100;
                }
                boss.ani_wait = 0;
                boss.ani_no = 1;
                break;
            }
            case 120: {
                boss.act_no = 121;
                boss.act_wait = 0;
                boss.ani_no = 1;
                boss.xm = 0;
            }
            case 121: {
                ++boss.act_wait;
                if (boss.act_wait <= 50) break;
                boss.act_no = 122;
                boss.ani_wait = 0;
                boss.ani_no = 2;
                break;
            }
            case 122: {
                ++boss.ani_wait;
                if (boss.ani_wait <= 20) break;
                boss.act_no = 123;
                boss.ani_wait = 0;
                boss.ani_no = 1;
                break;
            }
            case 123: {
                ++boss.ani_wait;
                if (boss.ani_wait <= 4) break;
                boss.act_no = 124;
                boss.ani_no = 5;
                boss.ym = -2560;
                boss.view.top = 32768;
                boss.view.bottom = 12288;
                Sound.PlaySoundObject(25, 1);
                break;
            }
            case 124: {
                int i;
                if ((boss.flag & 8) == 0) break;
                Sound.PlaySoundObject(26, 1);
                Frame.SetQuake(60);
                boss.act_no = 100;
                boss.ani_no = 1;
                boss.view.top = 24576;
                boss.view.bottom = 8192;
                for (i = 0; i < 2; ++i) {
                    NpChar.SetNpChar(104, Game.Random(4, 16) * 8192, Game.Random(0, 4) * 8192, 0, 0, 4, null, 128);
                }
                for (i = 0; i < 6; ++i) {
                    NpChar.SetNpChar(110, Game.Random(4, 16) * 8192, Game.Random(0, 4) * 8192, 0, 0, 4, null, 128);
                }
                for (i = 0; i < 8; ++i) {
                    NpChar.SetNpChar(4, boss.x + Game.Random(-12, 12) * 512, boss.y + boss.hit.bottom, Game.Random(-341, 341), Game.Random(-1536, 0), 0, null, 256);
                }
                if (boss.direct == 0 && boss.x < MyChar.gMC.x) {
                    boss.direct = 2;
                    boss.act_no = 110;
                }
                if (boss.direct != 2 || boss.x <= MyChar.gMC.x) break;
                boss.direct = 0;
                boss.act_no = 110;
                break;
            }
            case 130: {
                boss.act_no = 131;
                boss.ani_no = 3;
                boss.act_wait = 0;
                boss.xm = 0;
                Sound.PlaySoundObject(72, 1);
                for (int i = 0; i < 8; ++i) {
                    NpChar.SetNpChar(4, boss.x + Game.Random(-12, 12) * 512, boss.y + Game.Random(-12, 12) * 512, Game.Random(-341, 341), Game.Random(-1536, 0), 0, null, 256);
                }
                Boss.gBoss[1].cond = 0;
                Boss.gBoss[2].cond = 0;
            }
            case 131: {
                ++boss.act_wait;
                if (boss.act_wait % 5 == 0) {
                    NpChar.SetNpChar(4, boss.x + Game.Random(-12, 12) * 512, boss.y + Game.Random(-12, 12) * 512, Game.Random(-341, 341), Game.Random(-1536, 0), 0, null, 256);
                }
                boss.x = boss.act_wait / 2 % 2 != 0 ? (boss.x -= 512) : (boss.x += 512);
                if (boss.act_wait <= 100) break;
                boss.act_wait = 0;
                boss.act_no = 132;
                break;
            }
            case 132: {
                ++boss.act_wait;
                if (boss.act_wait / 2 % 2 != 0) {
                    boss.view.front = 10240;
                    boss.view.top = 6144;
                    boss.view.back = 10240;
                    boss.view.bottom = 6144;
                    boss.ani_no = 6;
                } else {
                    boss.view.front = 24576;
                    boss.view.top = 24576;
                    boss.view.back = 16384;
                    boss.view.bottom = 8192;
                    boss.ani_no = 3;
                }
                if (boss.act_wait % 9 == 0) {
                    NpChar.SetNpChar(4, boss.x + Game.Random(-12, 12) * 512, boss.y + Game.Random(-12, 12) * 512, Game.Random(-341, 341), Game.Random(-1536, 0), 0, null, 256);
                }
                if (boss.act_wait <= 150) break;
                boss.act_no = 140;
                boss.hit.bottom = 6144;
                break;
            }
            case 140: {
                boss.act_no = 141;
            }
            case 141: {
                if ((boss.flag & 8) == 0) break;
                boss.act_no = 142;
                boss.act_wait = 0;
                boss.ani_no = 7;
                break;
            }
            case 142: {
                ++boss.act_wait;
                if (boss.act_wait <= 30) break;
                boss.ani_no = 8;
                boss.ym = -2560;
                boss.bits = (char)(boss.bits | 8);
                boss.act_no = 143;
                break;
            }
            case 143: {
                boss.ym = -2560;
                if (boss.y >= 0) break;
                boss.cond = 0;
                Sound.PlaySoundObject(26, 1);
                Frame.SetQuake(30);
            }
        }
        boss.ym += 64;
        if (boss.ym > 1535) {
            boss.ym = 1535;
        }
        boss.x += boss.xm;
        boss.y += boss.ym;
        if (boss.direct == 0) {
            boss.rect.copyFrom(ActBossChar_Frog_rcLeft[boss.ani_no]);
        } else {
            boss.rect.copyFrom(ActBossChar_Frog_rcRight[boss.ani_no]);
        }
        BossFrog.ActBossChar02_01();
        BossFrog.ActBossChar02_02();
    }
}
