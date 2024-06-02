/*
 * Decompiled with CFR 0.152.
 */
package jp.studiopixel.doukutsu;

import jp.studiopixel.doukutsu.Boss;
import jp.studiopixel.doukutsu.Game;
import jp.studiopixel.doukutsu.Map;
import jp.studiopixel.doukutsu.NpChar;
import jp.studiopixel.doukutsu.RECT;
import jp.studiopixel.doukutsu.Sound;

public class BossPress {
    private static final RECT[] ActBossChar_Press_rc = new RECT[]{new RECT(0, 0, 80, 120), new RECT(80, 0, 160, 120), new RECT(160, 0, 240, 120)};
    private static final RECT[] ActBossChar_Press_rcDamage = new RECT[]{new RECT(0, 120, 80, 240), new RECT(80, 120, 160, 240), new RECT(160, 120, 240, 240)};
    private static char flash = '\u0000';

    public static void ActBossChar_Press() {
        NpChar.NPCHAR npc = Boss.gBoss[0];
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 10;
                npc.cond = (byte)-128;
                npc.exp = 1;
                npc.direct = 2;
                npc.x = 0;
                npc.y = 0;
                npc.view.front = 20480;
                npc.view.top = 30720;
                npc.view.back = 20480;
                npc.view.bottom = 30720;
                npc.hit_voice = 54;
                npc.hit.front = 25088;
                npc.hit.top = 30720;
                npc.hit.back = 20480;
                npc.hit.bottom = 24576;
                npc.bits = (char)33352;
                npc.size = 3;
                npc.damage = 10;
                npc.code_event = 1000;
                npc.life = 700;
                break;
            }
            case 5: {
                npc.act_no = 6;
                npc.x = 0;
                npc.y = 0;
                Boss.gBoss[1].cond = 0;
                Boss.gBoss[2].cond = 0;
                break;
            }
            case 10: {
                npc.act_no = 11;
                npc.x = 81920;
                npc.y = 37888;
                break;
            }
            case 20: {
                npc.damage = 0;
                npc.act_no = 21;
                npc.x = 81920;
                npc.y = 211456;
                npc.bits = (char)(npc.bits & 0xFFFFFFBF);
                Boss.gBoss[1].cond = 0;
                Boss.gBoss[2].cond = 0;
            }
            case 21: {
                if (++npc.act_wait % 16 != 0) break;
                NpChar.SetDestroyNpChar(npc.x + Game.Random(-40, 40) * 512, npc.y + Game.Random(-60, 60) * 512, 1, 1);
                break;
            }
            case 30: {
                npc.act_no = 31;
                npc.ani_no = 2;
                npc.x = 81920;
                npc.y = 32768;
            }
            case 31: {
                npc.y += 2048;
                if (npc.y < 211456) break;
                npc.y = 211456;
                npc.ani_no = 0;
                npc.act_no = 20;
                Sound.PlaySoundObject(44, 1);
                for (int i = 0; i < 5; ++i) {
                    int x = npc.x + Game.Random(-40, 40) * 512;
                    NpChar.SetNpChar(4, x, npc.y + 30720, 0, 0, 0, null, 256);
                }
                break;
            }
            case 100: {
                npc.act_no = 101;
                npc.count2 = 9;
                npc.act_wait = -100;
                Boss.gBoss[1].cond = (byte)-128;
                Boss.gBoss[1].hit.front = 7168;
                Boss.gBoss[1].hit.back = 7168;
                Boss.gBoss[1].hit.top = 4096;
                Boss.gBoss[1].hit.bottom = 4096;
                Boss.gBoss[1].bits = (char)12;
                Boss.gBoss[2].copyFrom(Boss.gBoss[1]);
                Boss.gBoss[3].cond = (byte)-112;
                Boss.gBoss[3].bits = (char)(Boss.gBoss[3].bits | 0x20);
                Boss.gBoss[3].hit.front = 3072;
                Boss.gBoss[3].hit.back = 3072;
                Boss.gBoss[3].hit.top = 4096;
                Boss.gBoss[3].hit.bottom = 4096;
                NpChar.SetNpChar(325, npc.x, npc.y + 30720, 0, 0, 0, null, 256);
            }
            case 101: {
                if (npc.count2 > 1 && npc.life < npc.count2 * 70) {
                    --npc.count2;
                    for (int i = 0; i < 5; ++i) {
                        Map.ChangeMapParts(i + 8, npc.count2, (byte)0);
                        NpChar.SetDestroyNpChar((i + 8) * 512 * 16, npc.count2 * 512 * 16, 0, 4);
                        Sound.PlaySoundObject(12, 1);
                    }
                }
                if (++npc.act_wait == 81 || npc.act_wait == 241) {
                    NpChar.SetNpChar(323, 24576, 122880, 0, 0, 1, null, 256);
                }
                if (npc.act_wait == 1 || npc.act_wait == 161) {
                    NpChar.SetNpChar(323, 139264, 122880, 0, 0, 1, null, 256);
                }
                if (npc.act_wait < 300) break;
                npc.act_wait = 0;
                NpChar.SetNpChar(325, npc.x, npc.y + 30720, 0, 0, 0, null, 256);
                break;
            }
            case 500: {
                Boss.gBoss[3].bits = (char)(Boss.gBoss[3].bits & 0xFFFFFFDF);
                npc.act_no = 501;
                npc.act_wait = 0;
                npc.count1 = 0;
                NpChar.DeleteNpCharCode(325, true);
                NpChar.DeleteNpCharCode(330, true);
            }
            case 501: {
                if (++npc.act_wait % 16 == 0) {
                    Sound.PlaySoundObject(12, 1);
                    NpChar.SetDestroyNpChar(npc.x + Game.Random(-40, 40) * 512, npc.y + Game.Random(-60, 60) * 512, 1, 1);
                }
                if (npc.act_wait == 95) {
                    npc.ani_no = 1;
                }
                if (npc.act_wait == 98) {
                    npc.ani_no = 2;
                }
                if (npc.act_wait <= 100) break;
                npc.act_no = 510;
                break;
            }
            case 510: {
                npc.ym += 64;
                npc.damage = 127;
                npc.y += npc.ym;
                if (npc.count1 == 0 && npc.y > 81920) {
                    npc.count1 = 1;
                    npc.ym = -512;
                    npc.damage = 0;
                    for (int i = 0; i < 7; ++i) {
                        Map.ChangeMapParts(i + 7, 14, (byte)0);
                        NpChar.SetDestroyNpChar((i + 7) * 512 * 16, 114688, 0, 0);
                        Sound.PlaySoundObject(12, 1);
                    }
                }
                if (npc.y <= 245760) break;
                npc.act_no = 520;
            }
        }
        Boss.gBoss[1].x = npc.x - 12288;
        Boss.gBoss[1].y = npc.y + 26624;
        Boss.gBoss[2].x = npc.x + 12288;
        Boss.gBoss[2].y = npc.y + 26624;
        Boss.gBoss[3].x = npc.x;
        Boss.gBoss[3].y = npc.y + 20480;
        if (npc.shock != '\u0000') {
            if ((flash = (char)(flash + '\u0001')) / 2 % 2 != 0) {
                npc.rect.copyFrom(ActBossChar_Press_rc[npc.ani_no]);
            } else {
                npc.rect.copyFrom(ActBossChar_Press_rcDamage[npc.ani_no]);
            }
        } else {
            npc.rect.copyFrom(ActBossChar_Press_rc[npc.ani_no]);
        }
    }
}
