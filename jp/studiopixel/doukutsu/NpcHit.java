/*
 * Decompiled with CFR 0.152.
 */
package jp.studiopixel.doukutsu;

import jp.studiopixel.doukutsu.Back;
import jp.studiopixel.doukutsu.Bullet;
import jp.studiopixel.doukutsu.Caret;
import jp.studiopixel.doukutsu.Flags;
import jp.studiopixel.doukutsu.Game;
import jp.studiopixel.doukutsu.Map;
import jp.studiopixel.doukutsu.MyChar;
import jp.studiopixel.doukutsu.NpChar;
import jp.studiopixel.doukutsu.Sound;
import jp.studiopixel.doukutsu.TextScr;
import jp.studiopixel.doukutsu.ValueView;

public class NpcHit {
    private static final int[] offx = new int[]{0, 1, 0, 1, 2, 2, 2, 0, 1};
    private static final int[] offy = new int[]{0, 0, 1, 1, 0, 1, 2, 2, 2};

    public static void JadgeHitNpCharBlock(NpChar.NPCHAR npc, int x, int y) {
        int hit = 0;
        if (npc.y - npc.hit.top < (y * 16 + 5) * 512 && npc.y + npc.hit.bottom > (y * 16 - 5) * 512 && npc.x - npc.hit.back < (x * 16 + 8) * 512 && npc.x - npc.hit.back > x * 16 * 512) {
            npc.x = (x * 16 + 8) * 512 + npc.hit.back;
            hit |= 1;
        }
        if (npc.y - npc.hit.top < (y * 16 + 5) * 512 && npc.y + npc.hit.bottom > (y * 16 - 5) * 512 && npc.x + npc.hit.back > (x * 16 - 8) * 512 && npc.x + npc.hit.back < x * 16 * 512) {
            npc.x = (x * 16 - 8) * 512 - npc.hit.back;
            hit |= 4;
        }
        if (npc.x - npc.hit.back < (x * 16 + 5) * 512 && npc.x + npc.hit.back > (x * 16 - 5) * 512 && npc.y - npc.hit.top < (y * 16 + 8) * 512 && npc.y - npc.hit.top > y * 16 * 512) {
            npc.y = (y * 16 + 8) * 512 + npc.hit.top;
            npc.ym = 0;
            hit |= 2;
        }
        if (npc.x - npc.hit.back < (x * 16 + 5) * 512 && npc.x + npc.hit.back > (x * 16 - 5) * 512 && npc.y + npc.hit.bottom > (y * 16 - 8) * 512 && npc.y + npc.hit.bottom < y * 16 * 512) {
            npc.y = (y * 16 - 8) * 512 - npc.hit.bottom;
            npc.ym = 0;
            hit |= 8;
        }
        npc.flag |= hit;
    }

    public static void JudgeHitNpCharTriangleA(NpChar.NPCHAR npc, int x, int y) {
        int hit = 0;
        if (npc.x < (x * 16 + 8) * 512 && npc.x > (x * 16 - 8) * 512 && npc.y - npc.hit.top < y * 16 * 512 - (npc.x - x * 16 * 512) / 2 + 2048 && npc.y + npc.hit.bottom > (y * 16 - 8) * 512) {
            npc.y = y * 16 * 512 - (npc.x - x * 16 * 512) / 2 + 2048 + npc.hit.top;
            if (npc.ym < 0) {
                npc.ym = 0;
            }
            hit |= 2;
        }
        npc.flag |= hit;
    }

    public static void JudgeHitNpCharTriangleB(NpChar.NPCHAR npc, int x, int y) {
        int hit = 0;
        if (npc.x < (x * 16 + 8) * 512 && npc.x > (x * 16 - 8) * 512 && npc.y - npc.hit.top < y * 16 * 512 - (npc.x - x * 16 * 512) / 2 - 2048 && npc.y + npc.hit.bottom > (y * 16 - 8) * 512) {
            npc.y = y * 16 * 512 - (npc.x - x * 16 * 512) / 2 - 2048 + npc.hit.top;
            if (npc.ym < 0) {
                npc.ym = 0;
            }
            hit |= 2;
        }
        npc.flag |= hit;
    }

    public static void JudgeHitNpCharTriangleC(NpChar.NPCHAR npc, int x, int y) {
        int hit = 0;
        if (npc.x < (x * 16 + 8) * 512 && npc.x > (x * 16 - 8) * 512 && npc.y - npc.hit.top < y * 16 * 512 + (npc.x - x * 16 * 512) / 2 - 2048 && npc.y + npc.hit.bottom > (y * 16 - 8) * 512) {
            npc.y = y * 16 * 512 + (npc.x - x * 16 * 512) / 2 - 2048 + npc.hit.top;
            if (npc.ym < 0) {
                npc.ym = 0;
            }
            hit |= 2;
        }
        npc.flag |= hit;
    }

    public static void JudgeHitNpCharTriangleD(NpChar.NPCHAR npc, int x, int y) {
        int hit = 0;
        if (npc.x < (x * 16 + 8) * 512 && npc.x > (x * 16 - 8) * 512 && npc.y - npc.hit.top < y * 16 * 512 + (npc.x - x * 16 * 512) / 2 + 2048 && npc.y + npc.hit.bottom > (y * 16 - 8) * 512) {
            npc.y = y * 16 * 512 + (npc.x - x * 16 * 512) / 2 + 2048 + npc.hit.top;
            if (npc.ym < 0) {
                npc.ym = 0;
            }
            hit |= 2;
        }
        npc.flag |= hit;
    }

    public static void JudgeHitNpCharTriangleE(NpChar.NPCHAR npc, int x, int y) {
        int hit = 0;
        hit |= 0x10000;
        if (npc.x < (x * 16 + 8) * 512 && npc.x > (x * 16 - 8) * 512 && npc.y + npc.hit.bottom > y * 16 * 512 + (npc.x - x * 16 * 512) / 2 - 2048 && npc.y - npc.hit.top < (y * 16 + 8) * 512) {
            npc.y = y * 16 * 512 + (npc.x - x * 16 * 512) / 2 - 2048 - npc.hit.bottom;
            if (npc.ym > 0) {
                npc.ym = 0;
            }
            hit |= 0x28;
        }
        npc.flag |= hit;
    }

    public static void JudgeHitNpCharTriangleF(NpChar.NPCHAR npc, int x, int y) {
        int hit = 0;
        hit |= 0x20000;
        if (npc.x < (x * 16 + 8) * 512 && npc.x >= (x * 16 - 8) * 512 && npc.y + npc.hit.bottom > y * 16 * 512 + (npc.x - x * 16 * 512) / 2 + 2048 && npc.y - npc.hit.top < (y * 16 + 8) * 512) {
            npc.y = y * 16 * 512 + (npc.x - x * 16 * 512) / 2 + 2048 - npc.hit.bottom;
            if (npc.ym > 0) {
                npc.ym = 0;
            }
            hit |= 0x28;
        }
        npc.flag |= hit;
    }

    public static void JudgeHitNpCharTriangleG(NpChar.NPCHAR npc, int x, int y) {
        int hit = 0;
        hit |= 0x40000;
        if (npc.x < (x * 16 + 8) * 512 && npc.x > (x * 16 - 8) * 512 && npc.y + npc.hit.bottom > y * 16 * 512 - (npc.x - x * 16 * 512) / 2 + 2048 && npc.y - npc.hit.top < (y * 16 + 8) * 512) {
            npc.y = y * 16 * 512 - (npc.x - x * 16 * 512) / 2 + 2048 - npc.hit.bottom;
            if (npc.ym > 0) {
                npc.ym = 0;
            }
            hit |= 0x18;
        }
        npc.flag |= hit;
    }

    public static void JudgeHitNpCharTriangleH(NpChar.NPCHAR npc, int x, int y) {
        int hit = 0;
        hit |= 0x80000;
        if (npc.x < (x * 16 + 8) * 512 && npc.x > (x * 16 - 8) * 512 && npc.y + npc.hit.bottom > y * 16 * 512 - (npc.x - x * 16 * 512) / 2 - 2048 && npc.y - npc.hit.top < (y * 16 + 8) * 512) {
            npc.y = y * 16 * 512 - (npc.x - x * 16 * 512) / 2 - 2048 - npc.hit.bottom;
            if (npc.ym > 0) {
                npc.ym = 0;
            }
            hit |= 0x18;
        }
        npc.flag |= hit;
    }

    public static void JudgeHitNpCharWater(NpChar.NPCHAR npc, int x, int y) {
        int hit = 0;
        if (npc.x - npc.hit.back < (x * 16 + 6) * 512 && npc.x + npc.hit.back > (x * 16 - 6) * 512 && npc.y - npc.hit.top < (y * 16 + 6) * 512 && npc.y + npc.hit.bottom > (y * 16 - 6) * 512) {
            hit |= 0x100;
        }
        npc.flag |= hit;
    }

    public static void HitNpCharMap() {
        for (int i = 0; i < 512; ++i) {
            int y;
            int x;
            int judg;
            if ((NpChar.gNPC[i].cond & 0x80) == 0 || (NpChar.gNPC[i].bits & 8) != 0) continue;
            if (NpChar.gNPC[i].size >= 3) {
                judg = 9;
                x = (NpChar.gNPC[i].x - 4096) / 16 / 512;
                y = (NpChar.gNPC[i].y - 4096) / 16 / 512;
            } else {
                judg = 4;
                x = NpChar.gNPC[i].x / 16 / 512;
                y = NpChar.gNPC[i].y / 16 / 512;
            }
            NpChar.gNPC[i].flag = 0;
            for (int j = 0; j < judg; ++j) {
                switch (Map.GetAttribute(x + offx[j], y + offy[j])) {
                    case 'D': {
                        if ((NpChar.gNPC[i].bits & 2) != 0) break;
                    }
                    case '\u0003': 
                    case '\u0005': 
                    case 'A': 
                    case 'C': {
                        NpcHit.JadgeHitNpCharBlock(NpChar.gNPC[i], x + offx[j], y + offy[j]);
                        break;
                    }
                    case 'P': {
                        NpcHit.JudgeHitNpCharTriangleA(NpChar.gNPC[i], x + offx[j], y + offy[j]);
                        break;
                    }
                    case 'Q': {
                        NpcHit.JudgeHitNpCharTriangleB(NpChar.gNPC[i], x + offx[j], y + offy[j]);
                        break;
                    }
                    case 'R': {
                        NpcHit.JudgeHitNpCharTriangleC(NpChar.gNPC[i], x + offx[j], y + offy[j]);
                        break;
                    }
                    case 'S': {
                        NpcHit.JudgeHitNpCharTriangleD(NpChar.gNPC[i], x + offx[j], y + offy[j]);
                        break;
                    }
                    case 'T': {
                        NpcHit.JudgeHitNpCharTriangleE(NpChar.gNPC[i], x + offx[j], y + offy[j]);
                        break;
                    }
                    case 'U': {
                        NpcHit.JudgeHitNpCharTriangleF(NpChar.gNPC[i], x + offx[j], y + offy[j]);
                        break;
                    }
                    case 'V': {
                        NpcHit.JudgeHitNpCharTriangleG(NpChar.gNPC[i], x + offx[j], y + offy[j]);
                        break;
                    }
                    case 'W': {
                        NpcHit.JudgeHitNpCharTriangleH(NpChar.gNPC[i], x + offx[j], y + offy[j]);
                        break;
                    }
                    case '\u0002': 
                    case '`': 
                    case 'b': {
                        NpcHit.JudgeHitNpCharWater(NpChar.gNPC[i], x + offx[j], y + offy[j]);
                        break;
                    }
                    case '\u0004': 
                    case 'a': 
                    case 'd': {
                        NpcHit.JadgeHitNpCharBlock(NpChar.gNPC[i], x + offx[j], y + offy[j]);
                        NpcHit.JudgeHitNpCharWater(NpChar.gNPC[i], x + offx[j], y + offy[j]);
                        break;
                    }
                    case 'p': {
                        NpcHit.JudgeHitNpCharTriangleA(NpChar.gNPC[i], x + offx[j], y + offy[j]);
                        NpcHit.JudgeHitNpCharWater(NpChar.gNPC[i], x + offx[j], y + offy[j]);
                        break;
                    }
                    case 'q': {
                        NpcHit.JudgeHitNpCharTriangleB(NpChar.gNPC[i], x + offx[j], y + offy[j]);
                        NpcHit.JudgeHitNpCharWater(NpChar.gNPC[i], x + offx[j], y + offy[j]);
                        break;
                    }
                    case 'r': {
                        NpcHit.JudgeHitNpCharTriangleC(NpChar.gNPC[i], x + offx[j], y + offy[j]);
                        NpcHit.JudgeHitNpCharWater(NpChar.gNPC[i], x + offx[j], y + offy[j]);
                        break;
                    }
                    case 's': {
                        NpcHit.JudgeHitNpCharTriangleD(NpChar.gNPC[i], x + offx[j], y + offy[j]);
                        NpcHit.JudgeHitNpCharWater(NpChar.gNPC[i], x + offx[j], y + offy[j]);
                        break;
                    }
                    case 't': {
                        NpcHit.JudgeHitNpCharTriangleE(NpChar.gNPC[i], x + offx[j], y + offy[j]);
                        NpcHit.JudgeHitNpCharWater(NpChar.gNPC[i], x + offx[j], y + offy[j]);
                        break;
                    }
                    case 'u': {
                        NpcHit.JudgeHitNpCharTriangleF(NpChar.gNPC[i], x + offx[j], y + offy[j]);
                        NpcHit.JudgeHitNpCharWater(NpChar.gNPC[i], x + offx[j], y + offy[j]);
                        break;
                    }
                    case 'v': {
                        NpcHit.JudgeHitNpCharTriangleG(NpChar.gNPC[i], x + offx[j], y + offy[j]);
                        NpcHit.JudgeHitNpCharWater(NpChar.gNPC[i], x + offx[j], y + offy[j]);
                        break;
                    }
                    case 'w': {
                        NpcHit.JudgeHitNpCharTriangleH(NpChar.gNPC[i], x + offx[j], y + offy[j]);
                        NpcHit.JudgeHitNpCharWater(NpChar.gNPC[i], x + offx[j], y + offy[j]);
                        break;
                    }
                    case '\u00a0': {
                        NpChar.gNPC[i].flag |= 0x100;
                    }
                    case '\u0080': {
                        NpChar.gNPC[i].flag |= 0x1000;
                        break;
                    }
                    case '\u00a1': {
                        NpChar.gNPC[i].flag |= 0x100;
                    }
                    case '\u0081': {
                        NpChar.gNPC[i].flag |= 0x2000;
                        break;
                    }
                    case '\u00a2': {
                        NpChar.gNPC[i].flag |= 0x100;
                    }
                    case '\u0082': {
                        NpChar.gNPC[i].flag |= 0x4000;
                        break;
                    }
                    case '\u00a3': {
                        NpChar.gNPC[i].flag |= 0x100;
                    }
                    case '\u0083': {
                        NpChar.gNPC[i].flag |= 0x8000;
                    }
                }
                if (NpChar.gNPC[i].y <= Back.gWaterY + 2048) continue;
                NpChar.gNPC[i].flag |= 0x100;
            }
        }
    }

    public static void LoseNpChar(NpChar.NPCHAR npc, boolean bVanish) {
        Sound.PlaySoundObject(npc.destroy_voice, 1);
        switch (npc.size) {
            case 1: {
                NpChar.SetDestroyNpChar(npc.x, npc.y, npc.view.back, 3);
                break;
            }
            case 2: {
                NpChar.SetDestroyNpChar(npc.x, npc.y, npc.view.back, 7);
                break;
            }
            case 3: {
                NpChar.SetDestroyNpChar(npc.x, npc.y, npc.view.back, 12);
            }
        }
        if (npc.exp != 0) {
            switch (Game.Random(1, 5)) {
                case 1: {
                    int val = npc.exp > 6 ? 6 : 2;
                    NpChar.SetLifeObject(npc.x, npc.y, val);
                    break;
                }
                case 2: {
                    int val = npc.exp > 6 ? 3 : 1;
                    if (NpChar.SetBulletObject(npc.x, npc.y, val)) break;
                }
                default: {
                    NpChar.SetExpObjects(npc.x, npc.y, npc.exp);
                }
            }
        }
        Flags.SetNPCFlag(npc.code_flag);
        if ((npc.bits & 0x8000) != 0) {
            if ((npc.bits & 0x8000) != 0 && npc.damage_view != 0) {
                ValueView.SetValueView(() -> npc.x, () -> npc.y, npc.damage_view, npc.hashCode());
            }
            if (bVanish) {
                NpChar.VanishNpChar(npc);
            }
        } else {
            npc.cond = 0;
        }
    }

    public static void HitNpCharBullet() {
        for (int n = 0; n < NpChar.gNPC.length; ++n) {
            if ((NpChar.gNPC[n].cond & 0x80) == 0 || (NpChar.gNPC[n].bits & 0x20) != 0 && (NpChar.gNPC[n].bits & 0x2000) != 0) continue;
            for (int b = 0; b < 64; ++b) {
                block12: {
                    block10: {
                        block11: {
                            if ((Bullet.gBul[b].cond & 0x80) == 0 || Bullet.gBul[b].damage == -1) continue;
                            boolean bHit = false;
                            if ((NpChar.gNPC[n].bits & 0x20) != 0 && NpChar.gNPC[n].x - NpChar.gNPC[n].hit.back < Bullet.gBul[b].x + Bullet.gBul[b].enemyXL && NpChar.gNPC[n].x + NpChar.gNPC[n].hit.back > Bullet.gBul[b].x - Bullet.gBul[b].enemyXL && NpChar.gNPC[n].y - NpChar.gNPC[n].hit.top < Bullet.gBul[b].y + Bullet.gBul[b].enemyYL && NpChar.gNPC[n].y + NpChar.gNPC[n].hit.bottom > Bullet.gBul[b].y - Bullet.gBul[b].enemyYL) {
                                bHit = true;
                            } else if ((NpChar.gNPC[n].bits & 4) != 0 && NpChar.gNPC[n].x - NpChar.gNPC[n].hit.back < Bullet.gBul[b].x + Bullet.gBul[b].blockXL && NpChar.gNPC[n].x + NpChar.gNPC[n].hit.back > Bullet.gBul[b].x - Bullet.gBul[b].blockXL && NpChar.gNPC[n].y - NpChar.gNPC[n].hit.top < Bullet.gBul[b].y + Bullet.gBul[b].blockYL && NpChar.gNPC[n].y + NpChar.gNPC[n].hit.bottom > Bullet.gBul[b].y - Bullet.gBul[b].blockYL) {
                                bHit = true;
                            }
                            if (!bHit) continue;
                            if ((NpChar.gNPC[n].bits & 0x20) == 0) break block10;
                            NpChar.gNPC[n].life -= Bullet.gBul[b].damage;
                            if (NpChar.gNPC[n].life >= 1) break block11;
                            NpChar.gNPC[n].life = 0;
                            if ((NpChar.gNPC[n].bits & 0x8000) != 0) {
                                NpChar.gNPC[n].damage_view -= Bullet.gBul[b].damage;
                            }
                            if ((MyChar.gMC.cond & 0x80) != 0 && (NpChar.gNPC[n].bits & 0x200) != 0) {
                                TextScr.StartTextScript(NpChar.gNPC[n].code_event);
                            } else {
                                NpChar.gNPC[n].cond = (byte)(NpChar.gNPC[n].cond | 8);
                            }
                            break block12;
                        }
                        if (NpChar.gNPC[n].shock < '\u000e') {
                            Caret.SetCaret((Bullet.gBul[b].x + NpChar.gNPC[n].x) / 2, (Bullet.gBul[b].y + NpChar.gNPC[n].y) / 2, 11, 0);
                            Caret.SetCaret((Bullet.gBul[b].x + NpChar.gNPC[n].x) / 2, (Bullet.gBul[b].y + NpChar.gNPC[n].y) / 2, 11, 0);
                            Caret.SetCaret((Bullet.gBul[b].x + NpChar.gNPC[n].x) / 2, (Bullet.gBul[b].y + NpChar.gNPC[n].y) / 2, 11, 0);
                            Sound.PlaySoundObject(NpChar.gNPC[n].hit_voice, 1);
                            NpChar.gNPC[n].shock = (char)16;
                        }
                        if ((NpChar.gNPC[n].bits & 0x8000) == 0) break block12;
                        NpChar.gNPC[n].damage_view -= Bullet.gBul[b].damage;
                        break block12;
                    }
                    if (Bullet.gBul[b].code_bullet != 13 && Bullet.gBul[b].code_bullet != 14 && Bullet.gBul[b].code_bullet != 15 && Bullet.gBul[b].code_bullet != 28 && Bullet.gBul[b].code_bullet != 29 && Bullet.gBul[b].code_bullet != 30 && (Bullet.gBul[b].bbits & 0x10) == 0) {
                        Caret.SetCaret((Bullet.gBul[b].x + NpChar.gNPC[n].x) / 2, (Bullet.gBul[b].y + NpChar.gNPC[n].y) / 2, 2, 2);
                        Sound.PlaySoundObject(31, 1);
                        Bullet.gBul[b].life = 0;
                        continue;
                    }
                }
                --Bullet.gBul[b].life;
            }
            if ((NpChar.gNPC[n].cond & 8) == 0) continue;
            NpcHit.LoseNpChar(NpChar.gNPC[n], true);
        }
    }
}
