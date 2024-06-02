/*
 * Decompiled with CFR 0.152.
 */
package jp.studiopixel.doukutsu;

import jp.studiopixel.doukutsu.Boss;
import jp.studiopixel.doukutsu.Flash;
import jp.studiopixel.doukutsu.Frame;
import jp.studiopixel.doukutsu.Game;
import jp.studiopixel.doukutsu.MyChar;
import jp.studiopixel.doukutsu.MycParam;
import jp.studiopixel.doukutsu.NpChar;
import jp.studiopixel.doukutsu.RECT;
import jp.studiopixel.doukutsu.Sound;

public class BossBallos {
    private static final RECT[] ActBossChar_Eye_rcLeft = new RECT[]{new RECT(272, 0, 296, 16), new RECT(272, 16, 296, 32), new RECT(272, 32, 296, 48), new RECT(0, 0, 0, 0), new RECT(240, 16, 264, 32)};
    private static final RECT[] ActBossChar_Eye_rcRight = new RECT[]{new RECT(296, 0, 320, 16), new RECT(296, 16, 320, 32), new RECT(296, 32, 320, 48), new RECT(0, 0, 0, 0), new RECT(240, 32, 264, 48)};
    private static final RECT[] ActBossChar_Body_rc = new RECT[]{new RECT(0, 0, 120, 120), new RECT(120, 0, 240, 120), new RECT(0, 120, 120, 240), new RECT(120, 120, 240, 240)};
    private static char flash = '\u0000';

    private static void ActBossChar_Eye(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 100: {
                npc.act_no = 101;
                npc.ani_no = 0;
                npc.ani_wait = 0;
            }
            case 101: {
                ++npc.ani_wait;
                if (npc.ani_wait > 2) {
                    npc.ani_wait = 0;
                    ++npc.ani_no;
                }
                if (npc.ani_no <= 2) break;
                npc.act_no = 102;
                break;
            }
            case 102: {
                npc.ani_no = 3;
                break;
            }
            case 200: {
                npc.act_no = 201;
                npc.ani_no = 3;
                npc.ani_wait = 0;
            }
            case 201: {
                ++npc.ani_wait;
                if (npc.ani_wait > 2) {
                    npc.ani_wait = 0;
                    --npc.ani_no;
                }
                if (npc.ani_no > 0) break;
                npc.act_no = 202;
                break;
            }
            case 300: {
                npc.act_no = 301;
                npc.ani_no = 4;
                if (npc.direct == 0) {
                    NpChar.SetDestroyNpChar(npc.x - 2048, npc.y, 2048, 10);
                    break;
                }
                NpChar.SetDestroyNpChar(npc.x + 2048, npc.y, 2048, 10);
            }
        }
        npc.x = npc.direct == 0 ? Boss.gBoss[0].x - 12288 : Boss.gBoss[0].x + 12288;
        npc.y = Boss.gBoss[0].y - 18432;
        if (npc.act_no >= 0 && npc.act_no < 300) {
            npc.bits = npc.ani_no != 3 ? (char)(npc.bits & 0xFFFFFFDF) : (char)(npc.bits | 0x20);
        }
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActBossChar_Eye_rcLeft[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActBossChar_Eye_rcRight[npc.ani_no]);
        }
    }

    private static void ActBossChar_Body(NpChar.NPCHAR npc) {
        npc.x = Boss.gBoss[0].x;
        npc.y = Boss.gBoss[0].y;
        npc.rect.copyFrom(ActBossChar_Body_rc[npc.ani_no]);
    }

    private static void ActBossChar_HITAI(NpChar.NPCHAR npc) {
        npc.x = Boss.gBoss[0].x;
        npc.y = Boss.gBoss[0].y - 22528;
    }

    private static void ActBossChar_HARA(NpChar.NPCHAR npc) {
        npc.x = Boss.gBoss[0].x;
        npc.y = Boss.gBoss[0].y;
    }

    public static void ActBossChar_Ballos() {
        int y;
        int x;
        int i;
        NpChar.NPCHAR npc = Boss.gBoss[0];
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
                npc.cond = (byte)-128;
                npc.exp = 1;
                npc.direct = 0;
                npc.x = 163840;
                npc.y = Short.MIN_VALUE;
                npc.hit_voice = 54;
                npc.hit.front = 16384;
                npc.hit.top = 24576;
                npc.hit.back = 16384;
                npc.hit.bottom = 24576;
                npc.bits = (char)33352;
                npc.size = 3;
                npc.damage = 0;
                npc.code_event = 1000;
                npc.life = 800;
                Boss.gBoss[1].cond = (byte)-112;
                Boss.gBoss[1].direct = 0;
                Boss.gBoss[1].bits = (char)8;
                Boss.gBoss[1].life = 10000;
                Boss.gBoss[1].view.front = 6144;
                Boss.gBoss[1].view.top = 0;
                Boss.gBoss[1].view.back = 6144;
                Boss.gBoss[1].view.bottom = 8192;
                Boss.gBoss[1].hit.front = 6144;
                Boss.gBoss[1].hit.top = 0;
                Boss.gBoss[1].hit.back = 6144;
                Boss.gBoss[1].hit.bottom = 8192;
                Boss.gBoss[2].copyFrom(Boss.gBoss[1]);
                Boss.gBoss[2].direct = 2;
                Boss.gBoss[3].cond = (byte)-112;
                Boss.gBoss[3].bits = (char)13;
                Boss.gBoss[3].view.front = 30720;
                Boss.gBoss[3].view.top = 30720;
                Boss.gBoss[3].view.back = 30720;
                Boss.gBoss[3].view.bottom = 30720;
                Boss.gBoss[3].hit.front = 24576;
                Boss.gBoss[3].hit.top = 12288;
                Boss.gBoss[3].hit.back = 24576;
                Boss.gBoss[3].hit.bottom = 16384;
                Boss.gBoss[4].cond = (byte)-112;
                Boss.gBoss[4].bits = (char)13;
                Boss.gBoss[4].hit.front = 16384;
                Boss.gBoss[4].hit.top = 4096;
                Boss.gBoss[4].hit.back = 16384;
                Boss.gBoss[4].hit.bottom = 4096;
                Boss.gBoss[5].cond = (byte)-112;
                Boss.gBoss[5].bits = (char)76;
                Boss.gBoss[5].hit.front = 16384;
                Boss.gBoss[5].hit.top = 0;
                Boss.gBoss[5].hit.back = 16384;
                Boss.gBoss[5].hit.bottom = 24576;
                break;
            }
            case 100: {
                npc.act_no = 101;
                npc.ani_no = 0;
                npc.x = MyChar.gMC.x;
                NpChar.SetNpChar(333, MyChar.gMC.x, 155648, 0, 0, 2, null, 256);
                npc.act_wait = 0;
            }
            case 101: {
                ++npc.act_wait;
                if (npc.act_wait <= 30) break;
                npc.act_no = 102;
                break;
            }
            case 102: {
                npc.ym += 64;
                if (npc.ym > 3072) {
                    npc.ym = 3072;
                }
                npc.y += npc.ym;
                if (npc.y <= 155648 - npc.hit.bottom) break;
                npc.y = 155648 - npc.hit.bottom;
                npc.ym = 0;
                npc.act_no = 103;
                npc.act_wait = 0;
                Frame.SetQuake2(30);
                Sound.PlaySoundObject(44, 1);
                if (MyChar.gMC.y > npc.y + 24576 && MyChar.gMC.x < npc.x + 12288 && MyChar.gMC.x > npc.x - 12288) {
                    MycParam.DamageMyChar(16);
                }
                for (i = 0; i < 16; ++i) {
                    x = npc.x + Game.Random(-40, 40) * 512;
                    NpChar.SetNpChar(4, x, npc.y + 20480, 0, 0, 0, null, 256);
                }
                if ((MyChar.gMC.flag & 8) == 0) break;
                MyChar.gMC.ym = -512;
                break;
            }
            case 103: {
                ++npc.act_wait;
                if (npc.act_wait != 50) break;
                npc.act_no = 104;
                Boss.gBoss[1].act_no = 100;
                Boss.gBoss[2].act_no = 100;
                break;
            }
            case 200: {
                npc.act_no = 201;
                npc.count1 = 0;
            }
            case 201: {
                npc.act_no = 203;
                npc.xm = 0;
                ++npc.count1;
                npc.hit.bottom = 24576;
                npc.damage = 0;
                npc.act_wait = npc.count1 % 3 == 0 ? 150 : 50;
            }
            case 203: {
                --npc.act_wait;
                if (npc.act_wait > 0) break;
                npc.act_no = 204;
                npc.ym = -3072;
                if (npc.x < MyChar.gMC.x) {
                    npc.xm = 512;
                    break;
                }
                npc.xm = -512;
                break;
            }
            case 204: {
                if (npc.x < 40960) {
                    npc.xm = 512;
                }
                if (npc.x > 278528) {
                    npc.xm = -512;
                }
                npc.ym += 85;
                if (npc.ym > 3072) {
                    npc.ym = 3072;
                }
                npc.x += npc.xm;
                npc.y += npc.ym;
                if (npc.y <= 155648 - npc.hit.bottom) break;
                npc.y = 155648 - npc.hit.bottom;
                npc.ym = 0;
                npc.act_no = 201;
                npc.act_wait = 0;
                if (MyChar.gMC.y > npc.y + 28672) {
                    MycParam.DamageMyChar(16);
                }
                if ((MyChar.gMC.flag & 8) != 0) {
                    MyChar.gMC.ym = -512;
                }
                Frame.SetQuake2(30);
                Sound.PlaySoundObject(26, 1);
                NpChar.SetNpChar(332, npc.x - 6144, npc.y + 26624, 0, 0, 0, null, 256);
                NpChar.SetNpChar(332, npc.x + 6144, npc.y + 26624, 0, 0, 2, null, 256);
                Sound.PlaySoundObject(44, 1);
                for (i = 0; i < 16; ++i) {
                    x = npc.x + Game.Random(-40, 40) * 512;
                    NpChar.SetNpChar(4, x, npc.y + 20480, 0, 0, 0, null, 256);
                }
                break;
            }
            case 220: {
                npc.act_no = 221;
                npc.life = 1200;
                Boss.gBoss[1].act_no = 200;
                Boss.gBoss[2].act_no = 200;
                npc.xm = 0;
                npc.ani_no = 0;
                npc.shock = '\u0000';
                flash = '\u0000';
            }
            case 221: {
                npc.ym += 64;
                if (npc.ym > 3072) {
                    npc.ym = 3072;
                }
                npc.y += npc.ym;
                if (npc.y <= 155648 - npc.hit.bottom) break;
                npc.y = 155648 - npc.hit.bottom;
                npc.ym = 0;
                npc.act_no = 222;
                npc.act_wait = 0;
                Frame.SetQuake2(30);
                Sound.PlaySoundObject(26, 1);
                for (i = 0; i < 16; ++i) {
                    x = npc.x + Game.Random(-40, 40) * 512;
                    NpChar.SetNpChar(4, x, npc.y + 20480, 0, 0, 0, null, 256);
                }
                if ((MyChar.gMC.flag & 8) == 0) break;
                MyChar.gMC.ym = -512;
                break;
            }
            case 300: {
                npc.act_no = 301;
                npc.act_wait = 0;
                for (i = 0; i < 256; i += 64) {
                    NpChar.SetNpChar(342, npc.x, npc.y, 0, 0, i, npc, 90);
                    NpChar.SetNpChar(342, npc.x, npc.y, 0, 0, i + 544, npc, 90);
                }
                NpChar.SetNpChar(343, npc.x, npc.y, 0, 0, 0, npc, 24);
                NpChar.SetNpChar(344, npc.x - 12288, npc.y - 18432, 0, 0, 0, npc, 32);
                NpChar.SetNpChar(344, npc.x + 12288, npc.y - 18432, 0, 0, 2, npc, 32);
            }
            case 301: {
                npc.y += (115200 - npc.y) / 8;
                ++npc.act_wait;
                if (npc.act_wait <= 50) break;
                npc.act_no = 310;
                npc.act_wait = 0;
                break;
            }
            case 311: {
                npc.direct = 0;
                npc.xm = -938;
                npc.ym = 0;
                npc.x += npc.xm;
                if (npc.x >= 56832) break;
                npc.x = 56832;
                npc.act_no = 312;
                break;
            }
            case 312: {
                npc.direct = 1;
                npc.ym = -938;
                npc.xm = 0;
                npc.y += npc.ym;
                if (npc.y >= 56832) break;
                npc.y = 56832;
                npc.act_no = 313;
                break;
            }
            case 313: {
                npc.direct = 2;
                npc.xm = 938;
                npc.ym = 0;
                npc.x += npc.xm;
                if (npc.x > 262656) {
                    npc.x = 262656;
                    npc.act_no = 314;
                }
                if (npc.count1 != 0) {
                    --npc.count1;
                }
                if (npc.count1 != 0 || npc.x <= 155648 || npc.x >= 172032) break;
                npc.act_no = 400;
                break;
            }
            case 314: {
                npc.direct = 3;
                npc.ym = 938;
                npc.xm = 0;
                npc.y += npc.ym;
                if (npc.y <= 115200) break;
                npc.y = 115200;
                npc.act_no = 311;
                break;
            }
            case 400: {
                npc.act_no = 401;
                npc.act_wait = 0;
                npc.xm = 0;
                npc.ym = 0;
                NpChar.DeleteNpCharCode(339, false);
            }
            case 401: {
                npc.y += (81408 - npc.y) / 8;
                ++npc.act_wait;
                if (npc.act_wait <= 50) break;
                npc.act_wait = 0;
                npc.act_no = 410;
                for (i = 0; i < 256; i += 32) {
                    NpChar.SetNpChar(346, npc.x, npc.y, 0, 0, i, npc, 80);
                }
                NpChar.SetNpChar(343, npc.x, npc.y, 0, 0, 0, npc, 24);
                NpChar.SetNpChar(344, npc.x - 12288, npc.y - 18432, 0, 0, 0, npc, 32);
                NpChar.SetNpChar(344, npc.x + 12288, npc.y - 18432, 0, 0, 2, npc, 32);
                break;
            }
            case 410: {
                ++npc.act_wait;
                if (npc.act_wait <= 50) break;
                npc.act_wait = 0;
                npc.act_no = 411;
                break;
            }
            case 411: {
                ++npc.act_wait;
                if (npc.act_wait % 30 == 1) {
                    x = (npc.act_wait / 30 * 2 + 2) * 16 * 512;
                    NpChar.SetNpChar(348, x, 172032, 0, 0, 0, null, 384);
                }
                if (npc.act_wait / 3 % 2 != 0) {
                    Sound.PlaySoundObject(26, 1);
                }
                if (npc.act_wait <= 540) break;
                npc.act_no = 420;
                break;
            }
            case 420: {
                npc.act_no = 421;
                npc.act_wait = 0;
                npc.ani_wait = 0;
                Frame.SetQuake2(30);
                Sound.PlaySoundObject(35, 1);
                Boss.gBoss[1].act_no = 102;
                Boss.gBoss[2].act_no = 102;
                for (i = 0; i < 256; ++i) {
                    x = npc.x + Game.Random(-60, 60) * 512;
                    y = npc.y + Game.Random(-60, 60) * 512;
                    NpChar.SetNpChar(4, x, y, 0, 0, 0, null, 0);
                }
            }
            case 421: {
                ++npc.ani_wait;
                if (npc.ani_wait <= 500) break;
                npc.ani_wait = 0;
                npc.act_no = 422;
                break;
            }
            case 422: {
                ++npc.ani_wait;
                if (npc.ani_wait <= 200) break;
                npc.ani_wait = 0;
                npc.act_no = 423;
                break;
            }
            case 423: {
                ++npc.ani_wait;
                if (npc.ani_wait <= 20) break;
                npc.ani_wait = 0;
                npc.act_no = 424;
                break;
            }
            case 424: {
                ++npc.ani_wait;
                if (npc.ani_wait <= 200) break;
                npc.ani_wait = 0;
                npc.act_no = 425;
                break;
            }
            case 425: {
                ++npc.ani_wait;
                if (npc.ani_wait <= 500) break;
                npc.ani_wait = 0;
                npc.act_no = 426;
                break;
            }
            case 426: {
                ++npc.ani_wait;
                if (npc.ani_wait <= 200) break;
                npc.ani_wait = 0;
                npc.act_no = 427;
                break;
            }
            case 427: {
                ++npc.ani_wait;
                if (npc.ani_wait <= 20) break;
                npc.ani_wait = 0;
                npc.act_no = 428;
                break;
            }
            case 428: {
                ++npc.ani_wait;
                if (npc.ani_wait <= 200) break;
                npc.ani_wait = 0;
                npc.act_no = 421;
                break;
            }
            case 1000: {
                npc.act_no = 1001;
                npc.act_wait = 0;
                Boss.gBoss[1].act_no = 300;
                Boss.gBoss[2].act_no = 300;
                Boss.gBoss[0].bits = (char)(Boss.gBoss[0].bits & 0xFFFFFFBE);
                Boss.gBoss[3].bits = (char)(Boss.gBoss[3].bits & 0xFFFFFFBE);
                Boss.gBoss[4].bits = (char)(Boss.gBoss[4].bits & 0xFFFFFFBE);
                Boss.gBoss[5].bits = (char)(Boss.gBoss[5].bits & 0xFFFFFFBE);
            }
            case 1001: {
                ++Boss.gBoss[0].act_wait;
                if (Boss.gBoss[0].act_wait % 12 == 0) {
                    Sound.PlaySoundObject(44, 1);
                }
                NpChar.SetDestroyNpChar(Boss.gBoss[0].x + Game.Random(-60, 60) * 512, Boss.gBoss[0].y + Game.Random(-60, 60) * 512, 1, 1);
                if (Boss.gBoss[0].act_wait <= 150) break;
                Boss.gBoss[0].act_wait = 0;
                Boss.gBoss[0].act_no = 1002;
                Flash.SetFlash(Boss.gBoss[0].x, Boss.gBoss[0].y, 1);
                Sound.PlaySoundObject(35, 1);
                break;
            }
            case 1002: {
                Frame.SetQuake2(40);
                ++Boss.gBoss[0].act_wait;
                if (Boss.gBoss[0].act_wait != 50) break;
                Boss.gBoss[0].cond = 0;
                Boss.gBoss[1].cond = 0;
                Boss.gBoss[2].cond = 0;
                Boss.gBoss[3].cond = 0;
                Boss.gBoss[4].cond = 0;
                Boss.gBoss[5].cond = 0;
                NpChar.DeleteNpCharCode(350, true);
                NpChar.DeleteNpCharCode(348, true);
            }
        }
        if (npc.act_no > 420 && npc.act_no < 500) {
            Boss.gBoss[3].bits = (char)(Boss.gBoss[3].bits | 0x20);
            Boss.gBoss[4].bits = (char)(Boss.gBoss[4].bits | 0x20);
            Boss.gBoss[5].bits = (char)(Boss.gBoss[5].bits | 0x20);
            ++npc.act_wait;
            if (npc.act_wait > 300) {
                npc.act_wait = 0;
                if (MyChar.gMC.x > npc.x) {
                    for (i = 0; i < 8; ++i) {
                        x = (156 + Game.Random(-4, 4)) * 512 * 16 / 4;
                        y = Game.Random(8, 68) * 512 * 16 / 4;
                        NpChar.SetNpChar(350, x, y, 0, 0, 0, null, 256);
                    }
                } else {
                    for (i = 0; i < 8; ++i) {
                        x = Game.Random(-4, 4) * 512 * 16 / 4;
                        y = Game.Random(8, 68) * 512 * 16 / 4;
                        NpChar.SetNpChar(350, x, y, 0, 0, 2, null, 256);
                    }
                }
            }
            if (npc.act_wait == 270 || npc.act_wait == 280 || npc.act_wait == 290) {
                NpChar.SetNpChar(353, npc.x, npc.y - 26624, 0, 0, 1, null, 256);
                Sound.PlaySoundObject(39, 1);
                for (i = 0; i < 4; ++i) {
                    NpChar.SetNpChar(4, npc.x, npc.y - 26624, 0, 0, 0, null, 256);
                }
            }
            if (npc.life > 500) {
                if (Game.Random(0, 10) == 2) {
                    x = npc.x + Game.Random(-40, 40) * 512;
                    y = npc.y + Game.Random(0, 40) * 512;
                    NpChar.SetNpChar(270, x, y, 0, 0, 3, null, 0);
                }
            } else if (Game.Random(0, 4) == 2) {
                x = npc.x + Game.Random(-40, 40) * 512;
                y = npc.y + Game.Random(0, 40) * 512;
                NpChar.SetNpChar(270, x, y, 0, 0, 3, null, 0);
            }
        }
        Boss.gBoss[3].ani_no = npc.shock != '\u0000' ? ((flash = (char)(flash + '\u0001')) / 2 % 2 != 0 ? 1 : 0) : 0;
        if (npc.act_no > 420) {
            Boss.gBoss[3].ani_no += 2;
        }
        BossBallos.ActBossChar_Eye(Boss.gBoss[1]);
        BossBallos.ActBossChar_Eye(Boss.gBoss[2]);
        BossBallos.ActBossChar_Body(Boss.gBoss[3]);
        BossBallos.ActBossChar_HITAI(Boss.gBoss[4]);
        BossBallos.ActBossChar_HARA(Boss.gBoss[5]);
    }
}
