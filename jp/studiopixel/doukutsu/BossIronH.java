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

public class BossIronH {
    private static final RECT[] ActBossChar_Ironhead_rc = new RECT[]{new RECT(0, 0, 64, 24), new RECT(64, 0, 128, 24), new RECT(128, 0, 192, 24), new RECT(64, 0, 128, 24), new RECT(0, 0, 64, 24), new RECT(192, 0, 256, 24), new RECT(256, 0, 320, 24), new RECT(192, 0, 256, 24), new RECT(256, 48, 320, 72)};
    private static final RECT[] ActBossChar_Ironhead_rcDamage = new RECT[]{new RECT(0, 24, 64, 48), new RECT(64, 24, 128, 48), new RECT(128, 24, 192, 48), new RECT(64, 24, 128, 48), new RECT(0, 24, 64, 48), new RECT(192, 24, 256, 48), new RECT(256, 24, 320, 48), new RECT(192, 24, 256, 48), new RECT(256, 48, 320, 72)};
    private static char flash = '\u0000';

    public static void ActBossChar_Ironhead() {
        NpChar.NPCHAR npc = Boss.gBoss[0];
        switch (npc.act_no) {
            case 0: {
                npc.cond = (byte)-128;
                npc.exp = 1;
                npc.direct = 2;
                npc.act_no = 100;
                npc.x = 81920;
                npc.y = 65536;
                npc.view.front = 20480;
                npc.view.top = 6144;
                npc.view.back = 12288;
                npc.view.bottom = 6144;
                npc.hit_voice = 54;
                npc.hit.front = 8192;
                npc.hit.top = 5120;
                npc.hit.back = 8192;
                npc.hit.bottom = 5120;
                npc.bits = (char)33320;
                npc.size = 3;
                npc.damage = 10;
                npc.code_event = 1000;
                npc.life = 400;
                break;
            }
            case 100: {
                npc.act_no = 101;
                npc.bits = (char)(npc.bits & 0xFFFFFFDF);
                npc.act_wait = 0;
            }
            case 101: {
                ++npc.act_wait;
                if (npc.act_wait > 50) {
                    npc.act_no = 250;
                    npc.act_wait = 0;
                }
                if (npc.act_wait % 4 != 0) break;
                NpChar.SetNpChar(197, Game.Random(15, 18) * 8192, Game.Random(2, 13) * 8192, 0, 0, 0, null, 256);
                break;
            }
            case 250: {
                npc.act_no = 251;
                if (npc.direct == 2) {
                    npc.x = 122880;
                    npc.y = MyChar.gMC.y;
                } else {
                    npc.x = 368640;
                    npc.y = Game.Random(2, 13) * 8192;
                }
                npc.tgt_x = npc.x;
                npc.tgt_y = npc.y;
                npc.ym = Game.Random(-512, 512);
                npc.xm = Game.Random(-512, 512);
                npc.bits = (char)(npc.bits | 0x20);
            }
            case 251: {
                if (npc.direct == 2) {
                    npc.tgt_x += 1024;
                } else {
                    npc.tgt_x -= 512;
                    npc.tgt_y = npc.tgt_y < MyChar.gMC.y ? (npc.tgt_y += 512) : (npc.tgt_y -= 512);
                }
                npc.xm = npc.x < npc.tgt_x ? (npc.xm += 8) : (npc.xm -= 8);
                npc.ym = npc.y < npc.tgt_y ? (npc.ym += 8) : (npc.ym -= 8);
                if (npc.ym > 512) {
                    npc.ym = 512;
                }
                if (npc.ym < -512) {
                    npc.ym = -512;
                }
                npc.x += npc.xm;
                npc.y += npc.ym;
                if (npc.direct == 2) {
                    if (npc.x > 368640) {
                        npc.direct = 0;
                        npc.act_no = 100;
                    }
                } else if (npc.x < 139264) {
                    npc.direct = 2;
                    npc.act_no = 100;
                }
                if (npc.direct == 0) {
                    ++npc.act_wait;
                    if (npc.act_wait == 300 || npc.act_wait == 310 || npc.act_wait == 320) {
                        Sound.PlaySoundObject(39, 1);
                        NpChar.SetNpChar(198, npc.x + 5120, npc.y + 512, Game.Random(-3, 0) * 512, Game.Random(-3, 3) * 512, 2, null, 256);
                    }
                }
                ++npc.ani_wait;
                if (npc.ani_wait > 2) {
                    npc.ani_wait = 0;
                    ++npc.ani_no;
                }
                if (npc.ani_no <= 7) break;
                npc.ani_no = 0;
                break;
            }
            case 1000: {
                npc.bits = (char)(npc.bits & 0xFFFFFFDF);
                npc.ani_no = 8;
                npc.damage = 0;
                npc.act_no = 1001;
                npc.tgt_x = npc.x;
                npc.tgt_y = npc.y;
                Frame.SetQuake(20);
                for (int i = 0; i < 32; ++i) {
                    NpChar.SetNpChar(4, npc.x + Game.Random(-128, 128) * 512, npc.y + Game.Random(-64, 64) * 512, Game.Random(-128, 128) * 512, Game.Random(-128, 128) * 512, 0, null, 256);
                }
                NpChar.DeleteNpCharCode(197, true);
                NpChar.DeleteNpCharCode(271, true);
                NpChar.DeleteNpCharCode(272, true);
            }
            case 1001: {
                npc.tgt_x -= 512;
                npc.x = npc.tgt_x + Game.Random(-1, 1) * 512;
                npc.y = npc.tgt_y + Game.Random(-1, 1) * 512;
                if (++npc.act_wait % 4 != 0) break;
                NpChar.SetNpChar(4, npc.x + Game.Random(-128, 128) * 512, npc.y + Game.Random(-64, 64) * 512, Game.Random(-128, 128) * 512, Game.Random(-128, 128) * 512, 0, null, 256);
            }
        }
        if (npc.shock != '\u0000') {
            if ((flash = (char)(flash + '\u0001')) / 2 % 2 != 0) {
                npc.rect.copyFrom(ActBossChar_Ironhead_rc[npc.ani_no]);
            } else {
                npc.rect.copyFrom(ActBossChar_Ironhead_rcDamage[npc.ani_no]);
            }
        } else {
            npc.rect.copyFrom(ActBossChar_Ironhead_rc[npc.ani_no]);
        }
    }
}
