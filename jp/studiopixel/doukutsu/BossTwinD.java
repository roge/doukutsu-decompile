/*
 * Decompiled with CFR 0.152.
 */
package jp.studiopixel.doukutsu;

import jp.studiopixel.doukutsu.Boss;
import jp.studiopixel.doukutsu.Flash;
import jp.studiopixel.doukutsu.Game;
import jp.studiopixel.doukutsu.MyChar;
import jp.studiopixel.doukutsu.NpChar;
import jp.studiopixel.doukutsu.RECT;
import jp.studiopixel.doukutsu.Sound;
import jp.studiopixel.doukutsu.Triangle;

public class BossTwinD {
    private static final RECT[] ActBossCharT_DragonBody_rcLeft = new RECT[]{new RECT(0, 0, 40, 40), new RECT(40, 0, 80, 40), new RECT(80, 0, 120, 40)};
    private static final RECT[] ActBossCharT_DragonBody_rcRight = new RECT[]{new RECT(0, 40, 40, 80), new RECT(40, 40, 80, 80), new RECT(80, 40, 120, 80)};
    private static final RECT[] ActBossCharT_DragonHead_rcLeft = new RECT[]{new RECT(0, 80, 40, 112), new RECT(40, 80, 80, 112), new RECT(80, 80, 120, 112), new RECT(120, 80, 160, 112)};
    private static final RECT[] ActBossCharT_DragonHead_rcRight = new RECT[]{new RECT(0, 112, 40, 144), new RECT(40, 112, 80, 144), new RECT(80, 112, 120, 144), new RECT(120, 112, 160, 144)};
    private static final RECT ActBossChar_Twin_rc = new RECT(0, 0, 0, 0);

    private static void ActBossCharT_DragonBody(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                char deg = (char)(npc.pNpc.count1 / 4 + npc.count1 & 0xFF);
                npc.act_no = 10;
                npc.x += npc.pNpc.x + Triangle.GetCos(deg) * npc.pNpc.tgt_x;
                npc.y += npc.pNpc.y + Triangle.GetSin(deg) * npc.pNpc.tgt_y;
            }
            case 10: {
                if (npc.x > MyChar.gMC.x) {
                    npc.direct = 0;
                    break;
                }
                npc.direct = 2;
                break;
            }
            case 100: {
                char deg = (char)(npc.pNpc.count1 / 4 + npc.count1 & 0xFF);
                npc.tgt_x = npc.pNpc.x + Triangle.GetCos(deg) * npc.pNpc.tgt_x;
                npc.tgt_y = npc.pNpc.y + Triangle.GetSin(deg) * npc.pNpc.tgt_y;
                npc.x += (npc.tgt_x - npc.x) / 8;
                npc.y += (npc.tgt_y - npc.y) / 8;
                if (npc.x > MyChar.gMC.x) {
                    npc.direct = 0;
                    break;
                }
                npc.direct = 2;
                break;
            }
            case 1000: {
                npc.act_no = 1001;
                npc.bits = (char)(npc.bits & 0xFFFFFFDF);
            }
            case 1001: {
                char deg = (char)(npc.pNpc.count1 / 4 + npc.count1 & 0xFF);
                npc.tgt_x = npc.pNpc.x + Triangle.GetCos(deg) * npc.pNpc.tgt_x;
                npc.tgt_y = npc.pNpc.y + Triangle.GetSin(deg) * npc.pNpc.tgt_y;
                npc.x += (npc.tgt_x - npc.x) / 8;
                npc.y += (npc.tgt_y - npc.y) / 8;
                npc.direct = npc.x > npc.pNpc.x ? 0 : 2;
            }
        }
        if (++npc.ani_wait > 2) {
            npc.ani_wait = 0;
            ++npc.ani_no;
        }
        if (npc.ani_no > 2) {
            npc.ani_no = 0;
        }
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActBossCharT_DragonBody_rcLeft[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActBossCharT_DragonBody_rcRight[npc.ani_no]);
        }
    }

    private static void ActBossCharT_DragonHead(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
                break;
            }
            case 100: {
                npc.act_no = 200;
            }
            case 200: {
                npc.bits = (char)(npc.bits & 0xFFFFFFDF);
                npc.ani_no = 0;
                npc.hit.front = 8192;
                npc.act_no = 201;
                npc.count1 = Game.Random(100, 200);
            }
            case 201: {
                if (npc.count1 != 0) {
                    --npc.count1;
                    break;
                }
                npc.act_no = 210;
                npc.act_wait = 0;
                npc.count2 = 0;
                break;
            }
            case 210: {
                ++npc.act_wait;
                if (npc.act_wait == 3) {
                    npc.ani_no = 1;
                }
                if (npc.act_wait == 6) {
                    npc.ani_no = 2;
                    npc.hit.front = 4096;
                    npc.bits = (char)(npc.bits | 0x20);
                    npc.count2 = 0;
                }
                if (npc.act_wait > 150) {
                    npc.act_no = 220;
                    npc.act_wait = 0;
                }
                if (npc.shock != '\u0000') {
                    ++npc.count2;
                }
                if (npc.count2 <= 10) break;
                Sound.PlaySoundObject(51, 1);
                NpChar.SetDestroyNpChar(npc.x, npc.y, npc.view.back, 4);
                npc.act_no = 300;
                npc.act_wait = 0;
                npc.ani_no = 3;
                npc.hit.front = 8192;
                break;
            }
            case 220: {
                ++npc.act_wait;
                if (npc.act_wait % 8 == 1) {
                    char deg = (char)Triangle.GetArktan(npc.x - MyChar.gMC.x, npc.y - MyChar.gMC.y);
                    deg = (char)(deg + (Game.Random(-6, 6) & 0xFF) & 0xFF);
                    int ym = Triangle.GetSin(deg);
                    int xm = Triangle.GetCos(deg);
                    if (npc.direct == 0) {
                        NpChar.SetNpChar(202, npc.x - 4096, npc.y, xm, ym, 0, null, 256);
                    } else {
                        NpChar.SetNpChar(202, npc.x + 4096, npc.y, xm, ym, 0, null, 256);
                    }
                    Sound.PlaySoundObject(33, 1);
                }
                if (npc.act_wait <= 50) break;
                npc.act_no = 200;
                break;
            }
            case 300: {
                ++npc.act_wait;
                if (npc.act_wait <= 100) break;
                npc.act_no = 200;
                break;
            }
            case 400: {
                npc.act_no = 401;
                npc.act_wait = 0;
                npc.ani_no = 0;
                npc.hit.front = 8192;
                npc.bits = (char)(npc.bits & 0xFFFFFFDF);
            }
            case 401: {
                ++npc.act_wait;
                if (npc.act_wait == 3) {
                    npc.ani_no = 1;
                }
                if (npc.act_wait == 6) {
                    npc.ani_no = 2;
                    npc.hit.front = 4096;
                    npc.bits = (char)(npc.bits | 0x20);
                    npc.count2 = 0;
                }
                if (npc.act_wait <= 20 || npc.act_wait % 32 != 1) break;
                char deg = (char)Triangle.GetArktan(npc.x - MyChar.gMC.x, npc.y - MyChar.gMC.y);
                deg = (char)(deg + (Game.Random(-6, 6) & 0xFF) & 0xFF);
                int ym = Triangle.GetSin(deg);
                int xm = Triangle.GetCos(deg);
                if (npc.direct == 0) {
                    NpChar.SetNpChar(202, npc.x - 4096, npc.y, xm, ym, 0, null, 256);
                } else {
                    NpChar.SetNpChar(202, npc.x + 4096, npc.y, xm, ym, 0, null, 256);
                }
                Sound.PlaySoundObject(33, 1);
                break;
            }
            case 1000: {
                npc.bits = (char)(npc.bits & 0xFFFFFFDF);
                npc.ani_no = 3;
            }
        }
        npc.direct = npc.pNpc.direct;
        npc.x = npc.direct == 0 ? npc.pNpc.x - 2048 : npc.pNpc.x + 2048;
        npc.y = npc.pNpc.y - 4096;
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActBossCharT_DragonHead_rcLeft[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActBossCharT_DragonHead_rcRight[npc.ani_no]);
        }
    }

    public static void ActBossChar_Twin() {
        NpChar.NPCHAR npc = Boss.gBoss[0];
        switch (npc.act_no) {
            case 0: {
                npc.cond = (byte)-128;
                npc.direct = 0;
                npc.act_no = 10;
                npc.exp = 0;
                npc.x = 81920;
                npc.y = 65536;
                npc.view.front = 4096;
                npc.view.top = 4096;
                npc.view.back = 65536;
                npc.view.bottom = 4096;
                npc.hit_voice = 54;
                npc.hit.front = 4096;
                npc.hit.top = 4096;
                npc.hit.back = 4096;
                npc.hit.bottom = 4096;
                npc.bits = (char)8;
                npc.bits = (char)(npc.bits | 0x200);
                npc.size = 3;
                npc.damage = 0;
                npc.code_event = 1000;
                npc.life = 500;
                npc.count2 = Game.Random(700, 1200);
                npc.tgt_x = 180;
                npc.tgt_y = 61;
                Boss.gBoss[2].cond = (byte)-128;
                Boss.gBoss[2].view.back = 10240;
                Boss.gBoss[2].view.front = 10240;
                Boss.gBoss[2].view.top = 8192;
                Boss.gBoss[2].view.bottom = 8192;
                Boss.gBoss[2].hit.back = 6144;
                Boss.gBoss[2].hit.front = 6144;
                Boss.gBoss[2].hit.top = 5120;
                Boss.gBoss[2].hit.bottom = 5120;
                Boss.gBoss[2].bits = (char)12;
                Boss.gBoss[2].pNpc = Boss.gBoss[3];
                Boss.gBoss[2].cond = (byte)(Boss.gBoss[2].cond | 0x10);
                Boss.gBoss[2].damage = 10;
                Boss.gBoss[3].cond = (byte)-128;
                Boss.gBoss[3].view.back = 10240;
                Boss.gBoss[3].view.front = 10240;
                Boss.gBoss[3].view.top = 10240;
                Boss.gBoss[3].view.bottom = 10240;
                Boss.gBoss[3].hit.back = 6144;
                Boss.gBoss[3].hit.front = 6144;
                Boss.gBoss[3].hit.top = 1024;
                Boss.gBoss[3].hit.bottom = 8192;
                Boss.gBoss[3].bits = (char)8;
                Boss.gBoss[3].pNpc = npc;
                Boss.gBoss[3].damage = 10;
                Boss.gBoss[4].copyFrom(Boss.gBoss[2]);
                Boss.gBoss[4].pNpc = Boss.gBoss[5];
                Boss.gBoss[5].copyFrom(Boss.gBoss[3]);
                Boss.gBoss[5].count1 = 128;
                break;
            }
            case 20: {
                if (--npc.tgt_x > 112) break;
                npc.act_no = 100;
                npc.act_wait = 0;
                Boss.gBoss[2].act_no = 100;
                Boss.gBoss[4].act_no = 100;
                Boss.gBoss[3].act_no = 100;
                Boss.gBoss[5].act_no = 100;
                break;
            }
            case 100: {
                ++npc.act_wait;
                if (npc.act_wait < 100) {
                    ++npc.count1;
                } else if (npc.act_wait < 120) {
                    npc.count1 += 2;
                } else if (npc.act_wait < npc.count2) {
                    npc.count1 += 4;
                } else if (npc.act_wait < npc.count2 + 40) {
                    npc.count1 += 2;
                } else if (npc.act_wait < npc.count2 + 60) {
                    ++npc.count1;
                } else {
                    npc.act_wait = 0;
                    npc.act_no = 110;
                    npc.count2 = Game.Random(400, 700);
                    break;
                }
                if (npc.count1 <= 1023) break;
                npc.count1 -= 1024;
                break;
            }
            case 110: {
                ++npc.act_wait;
                if (npc.act_wait < 20) {
                    --npc.count1;
                } else if (npc.act_wait < 60) {
                    npc.count1 -= 2;
                } else if (npc.act_wait < npc.count2) {
                    npc.count1 -= 4;
                } else if (npc.act_wait < npc.count2 + 40) {
                    npc.count1 -= 2;
                } else if (npc.act_wait < npc.count2 + 60) {
                    --npc.count1;
                } else {
                    if (npc.life < 300) {
                        npc.act_wait = 0;
                        npc.act_no = 400;
                        Boss.gBoss[2].act_no = 400;
                        Boss.gBoss[4].act_no = 400;
                        break;
                    }
                    npc.act_wait = 0;
                    npc.act_no = 100;
                    npc.count2 = Game.Random(400, 700);
                    break;
                }
                if (npc.count1 > 0) break;
                npc.count1 += 1024;
                break;
            }
            case 400: {
                ++npc.act_wait;
                if (npc.act_wait <= 100) break;
                npc.act_wait = 0;
                npc.act_no = 401;
                break;
            }
            case 401: {
                ++npc.act_wait;
                if (npc.act_wait < 100) {
                    ++npc.count1;
                } else if (npc.act_wait < 120) {
                    npc.count1 += 2;
                } else if (npc.act_wait < 500) {
                    npc.count1 += 4;
                } else if (npc.act_wait < 540) {
                    npc.count1 += 2;
                } else if (npc.act_wait < 560) {
                    ++npc.count1;
                } else {
                    npc.act_no = 100;
                    npc.act_wait = 0;
                    Boss.gBoss[2].act_no = 100;
                    Boss.gBoss[4].act_no = 100;
                    break;
                }
                if (npc.count1 <= 1023) break;
                npc.count1 -= 1024;
                break;
            }
            case 1000: {
                npc.act_no = 1001;
                npc.act_wait = 0;
                Boss.gBoss[2].act_no = 1000;
                Boss.gBoss[3].act_no = 1000;
                Boss.gBoss[4].act_no = 1000;
                Boss.gBoss[5].act_no = 1000;
                NpChar.SetDestroyNpChar(npc.x, npc.y, npc.view.back, 40);
            }
            case 1001: {
                ++npc.act_wait;
                if (npc.act_wait > 100) {
                    npc.act_no = 1010;
                }
                NpChar.SetNpChar(4, npc.x + Game.Random(-128, 128) * 512, npc.y + Game.Random(-70, 70) * 512, 0, 0, 0, null, 256);
                break;
            }
            case 1010: {
                npc.count1 += 4;
                if (npc.count1 > 1023) {
                    npc.count1 -= 1024;
                }
                if (npc.tgt_x > 8) {
                    --npc.tgt_x;
                }
                if (npc.tgt_y > 0) {
                    --npc.tgt_y;
                }
                if (npc.tgt_x < -8) {
                    ++npc.tgt_x;
                }
                if (npc.tgt_y < 0) {
                    ++npc.tgt_y;
                }
                if (npc.tgt_y != 0) break;
                npc.act_no = 1020;
                npc.act_wait = 0;
                Flash.SetFlash(Boss.gBoss[0].x, Boss.gBoss[0].y, 1);
                Sound.PlaySoundObject(35, 1);
                break;
            }
            case 1020: {
                if (++Boss.gBoss[0].act_wait <= 50) break;
                NpChar.DeleteNpCharCode(211, true);
                Boss.gBoss[0].cond = 0;
                Boss.gBoss[1].cond = 0;
                Boss.gBoss[2].cond = 0;
                Boss.gBoss[3].cond = 0;
                Boss.gBoss[4].cond = 0;
                Boss.gBoss[5].cond = 0;
                Boss.gBoss[0].act_no = 0;
            }
        }
        BossTwinD.ActBossCharT_DragonHead(Boss.gBoss[2]);
        BossTwinD.ActBossCharT_DragonBody(Boss.gBoss[3]);
        BossTwinD.ActBossCharT_DragonHead(Boss.gBoss[4]);
        BossTwinD.ActBossCharT_DragonBody(Boss.gBoss[5]);
        npc.rect.copyFrom(ActBossChar_Twin_rc);
    }
}
