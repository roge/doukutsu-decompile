/*
 * Decompiled with CFR 0.152.
 */
package jp.studiopixel.doukutsu;

import jp.studiopixel.doukutsu.Boss;
import jp.studiopixel.doukutsu.Bullet;
import jp.studiopixel.doukutsu.Flash;
import jp.studiopixel.doukutsu.Frame;
import jp.studiopixel.doukutsu.Game;
import jp.studiopixel.doukutsu.MyChar;
import jp.studiopixel.doukutsu.NpChar;
import jp.studiopixel.doukutsu.RECT;
import jp.studiopixel.doukutsu.Sound;

public class BossOhm {
    private static final RECT[] ActBoss01_12_rcLeft = new RECT[]{new RECT(80, 56, 104, 72)};
    private static final RECT[] ActBoss01_12_rcRight = new RECT[]{new RECT(104, 56, 128, 72)};
    private static final RECT[] ActBoss01_34_rcLeft = new RECT[]{new RECT(0, 56, 40, 88), new RECT(40, 56, 80, 88)};
    private static final RECT[] ActBoss01_34_rcRight = new RECT[]{new RECT(0, 88, 40, 120), new RECT(40, 88, 80, 120)};
    private static final RECT[] ActBossChar_Omega_rect = new RECT[]{new RECT(0, 0, 80, 56), new RECT(80, 0, 160, 56), new RECT(160, 0, 240, 56), new RECT(80, 0, 160, 56)};

    private static void ActBoss01_12() {
        for (int i = 1; i < 3; ++i) {
            Boss.gBoss[i].y = (Boss.gBoss[0].y + Boss.gBoss[i + 2].y - 4096) / 2;
            if (Boss.gBoss[i].direct == 0) {
                Boss.gBoss[i].x = Boss.gBoss[0].x - 8192;
                Boss.gBoss[i].rect.copyFrom(ActBoss01_12_rcLeft[Boss.gBoss[i].ani_no]);
                continue;
            }
            Boss.gBoss[i].rect.copyFrom(ActBoss01_12_rcRight[Boss.gBoss[i].ani_no]);
            Boss.gBoss[i].x = Boss.gBoss[0].x + 8192;
        }
    }

    private static void ActBoss01_34() {
        for (int i = 3; i < 5; ++i) {
            switch (Boss.gBoss[i].act_no) {
                case 0: {
                    Boss.gBoss[i].act_no = 1;
                }
                case 1: {
                    Boss.gBoss[i].y = Boss.gBoss[0].y;
                    if (i == 3) {
                        Boss.gBoss[i].x = Boss.gBoss[0].x - 8192;
                    }
                    if (i != 4) break;
                    Boss.gBoss[i].x = Boss.gBoss[0].x + 8192;
                    break;
                }
                case 3: {
                    Boss.gBoss[i].tgt_y = Boss.gBoss[0].y + 12288;
                    if (i == 3) {
                        Boss.gBoss[i].x = Boss.gBoss[0].x - 8192;
                    }
                    if (i == 4) {
                        Boss.gBoss[i].x = Boss.gBoss[0].x + 8192;
                    }
                    Boss.gBoss[i].y += (Boss.gBoss[i].tgt_y - Boss.gBoss[i].y) / 2;
                }
            }
            Boss.gBoss[i].ani_no = (Boss.gBoss[i].flag & 8) != 0 || Boss.gBoss[i].y <= Boss.gBoss[i].tgt_y ? 0 : 1;
            if (Boss.gBoss[i].direct == 0) {
                Boss.gBoss[i].rect.copyFrom(ActBoss01_34_rcLeft[Boss.gBoss[i].ani_no]);
                continue;
            }
            Boss.gBoss[i].rect.copyFrom(ActBoss01_34_rcRight[Boss.gBoss[i].ani_no]);
        }
    }

    private static void ActBoss01_5() {
        switch (Boss.gBoss[5].act_no) {
            case 0: {
                Boss.gBoss[5].bits = (char)(Boss.gBoss[5].bits | 9);
                Boss.gBoss[5].hit.front = 10240;
                Boss.gBoss[5].hit.top = 18432;
                Boss.gBoss[5].hit.back = 10240;
                Boss.gBoss[5].hit.bottom = 8192;
                Boss.gBoss[5].act_no = 1;
            }
            case 1: {
                Boss.gBoss[5].x = Boss.gBoss[0].x;
                Boss.gBoss[5].y = Boss.gBoss[0].y;
            }
        }
    }

    public static void ActBossChar_Omega() {
        switch (Boss.gBoss[0].act_no) {
            case 0: {
                Boss.gBoss[0].x = 1794048;
                Boss.gBoss[0].y = 131072;
                Boss.gBoss[0].view.front = 20480;
                Boss.gBoss[0].view.top = 20480;
                Boss.gBoss[0].view.back = 20480;
                Boss.gBoss[0].view.bottom = 8192;
                Boss.gBoss[0].tgt_x = Boss.gBoss[0].x;
                Boss.gBoss[0].tgt_y = Boss.gBoss[0].y;
                Boss.gBoss[0].hit_voice = 52;
                Boss.gBoss[0].hit.front = 4096;
                Boss.gBoss[0].hit.top = 12288;
                Boss.gBoss[0].hit.back = 4096;
                Boss.gBoss[0].hit.bottom = 8192;
                Boss.gBoss[0].bits = (char)33288;
                Boss.gBoss[0].size = 3;
                Boss.gBoss[0].exp = 1;
                Boss.gBoss[0].code_event = 210;
                Boss.gBoss[0].life = 400;
                Boss.gBoss[1].cond = (byte)-128;
                Boss.gBoss[1].view.front = 6144;
                Boss.gBoss[1].view.top = 4096;
                Boss.gBoss[1].view.back = 6144;
                Boss.gBoss[1].view.bottom = 4096;
                Boss.gBoss[1].bits = (char)8;
                Boss.gBoss[2].copyFrom(Boss.gBoss[1]);
                Boss.gBoss[1].direct = 0;
                Boss.gBoss[2].direct = 2;
                Boss.gBoss[3].cond = (byte)-128;
                Boss.gBoss[3].view.front = 12288;
                Boss.gBoss[3].view.top = 8192;
                Boss.gBoss[3].view.back = 8192;
                Boss.gBoss[3].view.bottom = 8192;
                Boss.gBoss[3].hit_voice = 52;
                Boss.gBoss[3].hit.front = 4096;
                Boss.gBoss[3].hit.top = 4096;
                Boss.gBoss[3].hit.back = 4096;
                Boss.gBoss[3].hit.bottom = 4096;
                Boss.gBoss[3].bits = (char)8;
                Boss.gBoss[3].x = Boss.gBoss[0].x - 8192;
                Boss.gBoss[3].y = Boss.gBoss[0].y;
                Boss.gBoss[3].direct = 0;
                Boss.gBoss[4].copyFrom(Boss.gBoss[3]);
                Boss.gBoss[4].direct = 2;
                Boss.gBoss[3].x = Boss.gBoss[0].x + 8192;
                Boss.gBoss[5].cond = (byte)-128;
                break;
            }
            case 20: {
                Boss.gBoss[0].act_no = 30;
                Boss.gBoss[0].act_wait = 0;
                Boss.gBoss[0].ani_no = 0;
            }
            case 30: {
                Frame.SetQuake(2);
                Boss.gBoss[0].y -= 512;
                if (++Boss.gBoss[0].act_wait % 4 == 0) {
                    Sound.PlaySoundObject(26, 1);
                }
                if (Boss.gBoss[0].act_wait != 48) break;
                Boss.gBoss[0].act_wait = 0;
                Boss.gBoss[0].act_no = 40;
                if (Boss.gBoss[0].life > 280) break;
                Boss.gBoss[0].act_no = 110;
                Boss.gBoss[0].bits = (char)(Boss.gBoss[0].bits | 0x20);
                Boss.gBoss[0].bits = (char)(Boss.gBoss[0].bits & 0xFFFFFFF7);
                Boss.gBoss[3].bits = (char)(Boss.gBoss[3].bits & 0xFFFFFFF7);
                Boss.gBoss[4].bits = (char)(Boss.gBoss[4].bits & 0xFFFFFFF7);
                Boss.gBoss[3].act_no = 3;
                Boss.gBoss[4].act_no = 3;
                Boss.gBoss[5].hit.top = 8192;
                break;
            }
            case 40: {
                ++Boss.gBoss[0].act_wait;
                if (Boss.gBoss[0].act_wait != 48) break;
                Boss.gBoss[0].act_wait = 0;
                Boss.gBoss[0].act_no = 50;
                Boss.gBoss[0].count1 = 0;
                Boss.gBoss[5].hit.top = 8192;
                Sound.PlaySoundObject(102, 1);
                break;
            }
            case 50: {
                ++Boss.gBoss[0].count1;
                if (Boss.gBoss[0].count1 > 2) {
                    Boss.gBoss[0].count1 = 0;
                    ++Boss.gBoss[0].count2;
                }
                if (Boss.gBoss[0].count2 != 3) break;
                Boss.gBoss[0].act_no = 60;
                Boss.gBoss[0].act_wait = 0;
                Boss.gBoss[0].bits = (char)(Boss.gBoss[0].bits | 0x20);
                Boss.gBoss[0].hit.front = 8192;
                Boss.gBoss[0].hit.back = 8192;
                break;
            }
            case 60: {
                ++Boss.gBoss[0].act_wait;
                if (Boss.gBoss[0].act_wait > 20 && Boss.gBoss[0].act_wait < 80 && Boss.gBoss[0].act_wait % 3 == 0) {
                    if (Game.Random(0, 9) < 8) {
                        NpChar.SetNpChar(48, Boss.gBoss[0].x, Boss.gBoss[0].y - 8192, Game.Random(-256, 256), -819, 0, null, 256);
                    } else {
                        NpChar.SetNpChar(48, Boss.gBoss[0].x, Boss.gBoss[0].y - 8192, Game.Random(-256, 256), -819, 2, null, 256);
                    }
                    Sound.PlaySoundObject(39, 1);
                }
                if (Boss.gBoss[0].act_wait != 200 && Bullet.CountArmsBullet(6) == 0) break;
                Boss.gBoss[0].count1 = 0;
                Boss.gBoss[0].act_no = 70;
                Sound.PlaySoundObject(102, 1);
                break;
            }
            case 70: {
                ++Boss.gBoss[0].count1;
                if (Boss.gBoss[0].count1 > 2) {
                    Boss.gBoss[0].count1 = 0;
                    --Boss.gBoss[0].count2;
                }
                if (Boss.gBoss[0].count2 == 1) {
                    Boss.gBoss[0].damage = 20;
                }
                if (Boss.gBoss[0].count2 != 0) break;
                Sound.PlaySoundObject(102, 0);
                Sound.PlaySoundObject(12, 1);
                Boss.gBoss[0].act_no = 80;
                Boss.gBoss[0].act_wait = 0;
                Boss.gBoss[0].bits = (char)(Boss.gBoss[0].bits & 0xFFFFFFDF);
                Boss.gBoss[0].hit.front = 12288;
                Boss.gBoss[0].hit.back = 12288;
                Boss.gBoss[5].hit.top = 18432;
                Boss.gBoss[0].damage = 0;
                break;
            }
            case 80: {
                ++Boss.gBoss[0].act_wait;
                if (Boss.gBoss[0].act_wait != 48) break;
                Boss.gBoss[0].act_wait = 0;
                Boss.gBoss[0].act_no = 90;
                break;
            }
            case 90: {
                Frame.SetQuake(2);
                Boss.gBoss[0].y += 512;
                ++Boss.gBoss[0].act_wait;
                if (Boss.gBoss[0].act_wait % 4 == 0) {
                    Sound.PlaySoundObject(26, 1);
                }
                if (Boss.gBoss[0].act_wait != 48) break;
                Boss.gBoss[0].act_wait = 0;
                Boss.gBoss[0].act_no = 100;
                break;
            }
            case 100: {
                ++Boss.gBoss[0].act_wait;
                if (Boss.gBoss[0].act_wait != 120) break;
                Boss.gBoss[0].act_wait = 0;
                Boss.gBoss[0].act_no = 30;
                Boss.gBoss[0].x = Boss.gBoss[0].tgt_x + Game.Random(-64, 64) * 512;
                Boss.gBoss[0].y = Boss.gBoss[0].tgt_y;
                break;
            }
            case 110: {
                ++Boss.gBoss[0].count1;
                if (Boss.gBoss[0].count1 > 2) {
                    Boss.gBoss[0].count1 = 0;
                    ++Boss.gBoss[0].count2;
                }
                if (Boss.gBoss[0].count2 != 3) break;
                Boss.gBoss[0].act_no = 120;
                Boss.gBoss[0].act_wait = 0;
                Boss.gBoss[0].hit.front = 8192;
                Boss.gBoss[0].hit.back = 8192;
                break;
            }
            case 120: {
                ++Boss.gBoss[0].act_wait;
                if (Boss.gBoss[0].act_wait == 50 || Bullet.CountArmsBullet(6) != 0) {
                    Boss.gBoss[0].act_no = 130;
                    Sound.PlaySoundObject(102, 1);
                    Boss.gBoss[0].act_wait = 0;
                    Boss.gBoss[0].count1 = 0;
                }
                if (Boss.gBoss[0].act_wait >= 30 || Boss.gBoss[0].act_wait % 5 != 0) break;
                NpChar.SetNpChar(48, Boss.gBoss[0].x, Boss.gBoss[0].y - 8192, Game.Random(-341, 341), -819, 0, null, 256);
                Sound.PlaySoundObject(39, 1);
                break;
            }
            case 130: {
                ++Boss.gBoss[0].count1;
                if (Boss.gBoss[0].count1 > 2) {
                    Boss.gBoss[0].count1 = 0;
                    --Boss.gBoss[0].count2;
                }
                if (Boss.gBoss[0].count2 == 1) {
                    Boss.gBoss[0].damage = 20;
                }
                if (Boss.gBoss[0].count2 != 0) break;
                Boss.gBoss[0].act_no = 140;
                Boss.gBoss[0].bits = (char)(Boss.gBoss[0].bits | 0x20);
                Boss.gBoss[0].hit.front = 8192;
                Boss.gBoss[0].hit.back = 8192;
                Boss.gBoss[0].ym = -1535;
                Sound.PlaySoundObject(102, 0);
                Sound.PlaySoundObject(12, 1);
                Sound.PlaySoundObject(25, 1);
                if (Boss.gBoss[0].x < MyChar.gMC.x) {
                    Boss.gBoss[0].xm = 256;
                }
                if (Boss.gBoss[0].x > MyChar.gMC.x) {
                    Boss.gBoss[0].xm = -256;
                }
                Boss.gBoss[0].damage = 0;
                Boss.gBoss[5].hit.top = 18432;
                break;
            }
            case 140: {
                Boss.gBoss[5].damage = (MyChar.gMC.flag & 8) != 0 && Boss.gBoss[0].ym > 0 ? 20 : 0;
                Boss.gBoss[0].ym += 36;
                if (Boss.gBoss[0].ym > 1535) {
                    Boss.gBoss[0].ym = 1535;
                }
                Boss.gBoss[0].x += Boss.gBoss[0].xm;
                Boss.gBoss[0].y += Boss.gBoss[0].ym;
                if ((Boss.gBoss[0].flag & 8) == 0) break;
                Boss.gBoss[0].act_no = 110;
                Boss.gBoss[0].act_wait = 0;
                Boss.gBoss[0].count1 = 0;
                Boss.gBoss[5].hit.top = 8192;
                Boss.gBoss[5].damage = 0;
                Sound.PlaySoundObject(26, 1);
                Sound.PlaySoundObject(12, 1);
                Frame.SetQuake(30);
                break;
            }
            case 150: {
                Frame.SetQuake(2);
                ++Boss.gBoss[0].act_wait;
                if (Boss.gBoss[0].act_wait % 12 == 0) {
                    Sound.PlaySoundObject(52, 1);
                }
                NpChar.SetDestroyNpChar(Boss.gBoss[0].x + Game.Random(-48, 48) * 512, Boss.gBoss[0].y + Game.Random(-48, 24) * 512, 1, 1);
                if (Boss.gBoss[0].act_wait <= 100) break;
                Boss.gBoss[0].act_wait = 0;
                Boss.gBoss[0].act_no = 160;
                Flash.SetFlash(Boss.gBoss[0].x, Boss.gBoss[0].y, 1);
                Sound.PlaySoundObject(35, 1);
                break;
            }
            case 160: {
                Frame.SetQuake(40);
                ++Boss.gBoss[0].act_wait;
                if (Boss.gBoss[0].act_wait <= 50) break;
                Boss.gBoss[0].cond = 0;
                Boss.gBoss[1].cond = 0;
                Boss.gBoss[2].cond = 0;
                Boss.gBoss[3].cond = 0;
                Boss.gBoss[4].cond = 0;
                Boss.gBoss[5].cond = 0;
            }
        }
        Boss.gBoss[0].rect.copyFrom(ActBossChar_Omega_rect[Boss.gBoss[0].count2]);
        Boss.gBoss[1].shock = Boss.gBoss[0].shock;
        Boss.gBoss[2].shock = Boss.gBoss[0].shock;
        Boss.gBoss[3].shock = Boss.gBoss[0].shock;
        Boss.gBoss[4].shock = Boss.gBoss[0].shock;
        BossOhm.ActBoss01_34();
        BossOhm.ActBoss01_12();
        BossOhm.ActBoss01_5();
        if (Boss.gBoss[0].life == 0 && Boss.gBoss[0].act_no < 150) {
            Boss.gBoss[0].act_no = 150;
            Boss.gBoss[0].act_wait = 0;
            Boss.gBoss[0].damage = 0;
            Boss.gBoss[5].damage = 0;
            NpChar.DeleteNpCharCode(48, true);
        }
    }
}
