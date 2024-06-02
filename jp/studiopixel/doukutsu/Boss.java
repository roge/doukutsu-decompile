/*
 * Decompiled with CFR 0.152.
 */
package jp.studiopixel.doukutsu;

import jp.studiopixel.doukutsu.BossAlmo1;
import jp.studiopixel.doukutsu.BossAlmo2;
import jp.studiopixel.doukutsu.BossBallos;
import jp.studiopixel.doukutsu.BossFrog;
import jp.studiopixel.doukutsu.BossIronH;
import jp.studiopixel.doukutsu.BossOhm;
import jp.studiopixel.doukutsu.BossPress;
import jp.studiopixel.doukutsu.BossTwinD;
import jp.studiopixel.doukutsu.BossX;
import jp.studiopixel.doukutsu.Bullet;
import jp.studiopixel.doukutsu.Caret;
import jp.studiopixel.doukutsu.Draw;
import jp.studiopixel.doukutsu.Map;
import jp.studiopixel.doukutsu.MyChar;
import jp.studiopixel.doukutsu.NpChar;
import jp.studiopixel.doukutsu.NpcHit;
import jp.studiopixel.doukutsu.Sound;
import jp.studiopixel.doukutsu.TextScr;
import jp.studiopixel.doukutsu.ValueView;

public class Boss {
    public static NpChar.NPCHAR[] gBoss = new NpChar.NPCHAR[20];
    public static final Runnable[] gpBossFuncTbl = new Runnable[]{Boss::ActBossChar_0, BossOhm::ActBossChar_Omega, BossFrog::ActBossChar_Frog, BossX::ActBossChar_MonstX, BossAlmo1::ActBossChar_Core, BossIronH::ActBossChar_Ironhead, BossTwinD::ActBossChar_Twin, BossAlmo2::ActBossChar_Undead, BossPress::ActBossChar_Press, BossBallos::ActBossChar_Ballos};
    private static final int[] offx = new int[]{0, 1, 0, 1, 2, 2, 2, 0, 1, -1, -1, -1, -1, 0, 1, 2};
    private static final int[] offy = new int[]{0, 0, 1, 1, 0, 1, 2, 2, 2, -1, 0, 1, 2, -1, -1, -1};
    private static final char[] atrb = new char[16];

    public static void InitBossChar(int code) {
        for (int i = 0; i < gBoss.length; ++i) {
            Boss.gBoss[i] = new NpChar.NPCHAR();
        }
        Boss.gBoss[0].cond = (byte)-128;
        Boss.gBoss[0].code_char = code;
    }

    public static void PutBossChar(int fx, int fy) {
        byte a = 0;
        for (int b = gBoss.length - 1; b >= 0; --b) {
            if ((Boss.gBoss[b].cond & 0x80) == 0) continue;
            if (Boss.gBoss[b].shock != '\u0000') {
                a = (byte)(Boss.gBoss[b].shock / 2 % 2 * 2 - 1);
            } else {
                a = 0;
                if ((Boss.gBoss[b].bits & 0x8000) != 0 && Boss.gBoss[b].damage_view != 0) {
                    int bb = b;
                    ValueView.SetValueView(() -> Boss.gBoss[bb].x, () -> Boss.gBoss[bb].y, Boss.gBoss[b].damage_view, gBoss[bb].hashCode());
                    Boss.gBoss[b].damage_view = 0;
                }
            }
            int side = Boss.gBoss[b].direct == 0 ? Boss.gBoss[b].view.front : Boss.gBoss[b].view.back;
            Draw.PutBitmap3(Draw.grcGame, (Boss.gBoss[b].x - side) / 512 - fx / 512 + a, (Boss.gBoss[b].y - Boss.gBoss[b].view.top) / 512 - fy / 512, Boss.gBoss[b].rect, 22);
        }
    }

    public static void SetBossCharActNo(int a) {
        Boss.gBoss[0].act_no = a;
    }

    public static void HitBossBullet() {
        for (int bos = 0; bos < gBoss.length; ++bos) {
            if ((Boss.gBoss[bos].cond & 0x80) == 0) continue;
            for (int bul = 0; bul < Bullet.gBul.length; ++bul) {
                if ((Bullet.gBul[bul].cond & 0x80) == 0 || Bullet.gBul[bul].damage == -1) continue;
                boolean bHit = false;
                if ((Boss.gBoss[bos].bits & 0x20) != 0 && Boss.gBoss[bos].x - Boss.gBoss[bos].hit.back < Bullet.gBul[bul].x + Bullet.gBul[bul].enemyXL && Boss.gBoss[bos].x + Boss.gBoss[bos].hit.back > Bullet.gBul[bul].x - Bullet.gBul[bul].enemyXL && Boss.gBoss[bos].y - Boss.gBoss[bos].hit.top < Bullet.gBul[bul].y + Bullet.gBul[bul].enemyYL && Boss.gBoss[bos].y + Boss.gBoss[bos].hit.bottom > Bullet.gBul[bul].y - Bullet.gBul[bul].enemyYL) {
                    bHit = true;
                } else if ((Boss.gBoss[bos].bits & 4) != 0 && Boss.gBoss[bos].x - Boss.gBoss[bos].hit.back < Bullet.gBul[bul].x + Bullet.gBul[bul].blockXL && Boss.gBoss[bos].x + Boss.gBoss[bos].hit.back > Bullet.gBul[bul].x - Bullet.gBul[bul].blockXL && Boss.gBoss[bos].y - Boss.gBoss[bos].hit.top < Bullet.gBul[bul].y + Bullet.gBul[bul].blockYL && Boss.gBoss[bos].y + Boss.gBoss[bos].hit.bottom > Bullet.gBul[bul].y - Bullet.gBul[bul].blockYL) {
                    bHit = true;
                }
                if (!bHit) continue;
                if ((Boss.gBoss[bos].bits & 0x20) != 0) {
                    int bos_ = (Boss.gBoss[bos].cond & 0x10) != 0 ? 0 : bos;
                    Boss.gBoss[bos_].life -= Bullet.gBul[bul].damage;
                    if (Boss.gBoss[bos_].life < 1) {
                        Boss.gBoss[bos_].life = bos_;
                        if ((MyChar.gMC.cond & 0x80) != 0 && (Boss.gBoss[bos_].bits & 0x200) != 0) {
                            TextScr.StartTextScript(Boss.gBoss[bos_].code_event);
                        } else {
                            Sound.PlaySoundObject(Boss.gBoss[bos_].destroy_voice, 1);
                            switch (Boss.gBoss[bos_].size) {
                                case 1: {
                                    NpChar.SetDestroyNpChar(Boss.gBoss[bos_].x, Boss.gBoss[bos_].y, Boss.gBoss[bos_].view.back, 4);
                                    break;
                                }
                                case 2: {
                                    NpChar.SetDestroyNpChar(Boss.gBoss[bos_].x, Boss.gBoss[bos_].y, Boss.gBoss[bos_].view.back, 8);
                                    break;
                                }
                                case 3: {
                                    NpChar.SetDestroyNpChar(Boss.gBoss[bos_].x, Boss.gBoss[bos_].y, Boss.gBoss[bos_].view.back, 16);
                                }
                            }
                            Boss.gBoss[bos_].cond = 0;
                        }
                    } else {
                        if (Boss.gBoss[bos].shock < '\u000e') {
                            Caret.SetCaret(Bullet.gBul[bul].x, Bullet.gBul[bul].y, 11, 0);
                            Caret.SetCaret(Bullet.gBul[bul].x, Bullet.gBul[bul].y, 11, 0);
                            Caret.SetCaret(Bullet.gBul[bul].x, Bullet.gBul[bul].y, 11, 0);
                            Sound.PlaySoundObject(Boss.gBoss[bos_].hit_voice, 1);
                        }
                        Boss.gBoss[bos].shock = (char)8;
                        Boss.gBoss[bos_].shock = (char)8;
                        Boss.gBoss[bos_].damage_view -= Bullet.gBul[bul].damage;
                    }
                    --Bullet.gBul[bul].life;
                    if (Bullet.gBul[bul].life >= 1) continue;
                    Bullet.gBul[bul].cond = 0;
                    continue;
                }
                if (Bullet.gBul[bul].code_bullet == 13 || Bullet.gBul[bul].code_bullet == 14 || Bullet.gBul[bul].code_bullet == 15 || Bullet.gBul[bul].code_bullet == 28 || Bullet.gBul[bul].code_bullet == 29 || Bullet.gBul[bul].code_bullet == 30) {
                    --Bullet.gBul[bul].life;
                    continue;
                }
                if ((Bullet.gBul[bul].bbits & 0x10) != 0) continue;
                Caret.SetCaret(Bullet.gBul[bul].x, Bullet.gBul[bul].y, 2, 2);
                Sound.PlaySoundObject(31, 1);
                Bullet.gBul[bul].cond = 0;
            }
        }
    }

    public static void ActBossChar_0() {
    }

    public static void ActBossChar() {
        if ((Boss.gBoss[0].cond & 0x80) == 0) {
            return;
        }
        int code_char = Boss.gBoss[0].code_char;
        gpBossFuncTbl[code_char].run();
        for (int bos = 0; bos < gBoss.length; ++bos) {
            if (Boss.gBoss[bos].shock == '\u0000') continue;
            Boss.gBoss[bos].shock = (char)(Boss.gBoss[bos].shock - '\u0001');
        }
    }

    public static void HitBossMap() {
        for (int b = 0; b < gBoss.length; ++b) {
            int y;
            int x;
            int judg;
            if ((Boss.gBoss[b].cond & 0x80) == 0 || (Boss.gBoss[b].bits & 8) != 0) continue;
            if (Boss.gBoss[b].size >= 3) {
                judg = 16;
                x = Boss.gBoss[b].x / 16 / 512;
                y = Boss.gBoss[b].y / 16 / 512;
            } else {
                judg = 4;
                x = Boss.gBoss[b].x / 16 / 512;
                y = Boss.gBoss[b].y / 16 / 512;
            }
            Boss.gBoss[b].flag = 0;
            block22: for (int j = 0; j < judg; ++j) {
                Boss.atrb[j] = Map.GetAttribute(x + offx[j], y + offy[j]);
                switch (atrb[j]) {
                    case 'D': {
                        if ((Boss.gBoss[b].bits & 2) != 0) continue block22;
                    }
                    case '\u0005': 
                    case 'A': 
                    case 'C': {
                        NpcHit.JadgeHitNpCharBlock(gBoss[b], x + offx[j], y + offy[j]);
                        continue block22;
                    }
                    case 'P': {
                        NpcHit.JudgeHitNpCharTriangleA(gBoss[b], x + offx[j], y + offy[j]);
                        continue block22;
                    }
                    case 'Q': {
                        NpcHit.JudgeHitNpCharTriangleB(gBoss[b], x + offx[j], y + offy[j]);
                        continue block22;
                    }
                    case 'R': {
                        NpcHit.JudgeHitNpCharTriangleC(gBoss[b], x + offx[j], y + offy[j]);
                        continue block22;
                    }
                    case 'S': {
                        NpcHit.JudgeHitNpCharTriangleD(gBoss[b], x + offx[j], y + offy[j]);
                        continue block22;
                    }
                    case 'T': {
                        NpcHit.JudgeHitNpCharTriangleE(gBoss[b], x + offx[j], y + offy[j]);
                        continue block22;
                    }
                    case 'U': {
                        NpcHit.JudgeHitNpCharTriangleF(gBoss[b], x + offx[j], y + offy[j]);
                        continue block22;
                    }
                    case 'V': {
                        NpcHit.JudgeHitNpCharTriangleG(gBoss[b], x + offx[j], y + offy[j]);
                        continue block22;
                    }
                    case 'W': {
                        NpcHit.JudgeHitNpCharTriangleH(gBoss[b], x + offx[j], y + offy[j]);
                        continue block22;
                    }
                    case '\u0002': 
                    case '`': 
                    case 'a': 
                    case 'd': {
                        NpcHit.JadgeHitNpCharBlock(gBoss[b], x + offx[j], y + offy[j]);
                        NpcHit.JudgeHitNpCharWater(gBoss[b], x + offx[j], y + offy[j]);
                        continue block22;
                    }
                    case 'p': {
                        NpcHit.JudgeHitNpCharTriangleA(gBoss[b], x + offx[j], y + offy[j]);
                        NpcHit.JudgeHitNpCharWater(gBoss[b], x + offx[j], y + offy[j]);
                        continue block22;
                    }
                    case 'q': {
                        NpcHit.JudgeHitNpCharTriangleB(gBoss[b], x + offx[j], y + offy[j]);
                        NpcHit.JudgeHitNpCharWater(gBoss[b], x + offx[j], y + offy[j]);
                        continue block22;
                    }
                    case 'r': {
                        NpcHit.JudgeHitNpCharTriangleC(gBoss[b], x + offx[j], y + offy[j]);
                        NpcHit.JudgeHitNpCharWater(gBoss[b], x + offx[j], y + offy[j]);
                        continue block22;
                    }
                    case 's': {
                        NpcHit.JudgeHitNpCharTriangleD(gBoss[b], x + offx[j], y + offy[j]);
                        NpcHit.JudgeHitNpCharWater(gBoss[b], x + offx[j], y + offy[j]);
                        continue block22;
                    }
                    case 't': {
                        NpcHit.JudgeHitNpCharTriangleE(gBoss[b], x + offx[j], y + offy[j]);
                        NpcHit.JudgeHitNpCharWater(gBoss[b], x + offx[j], y + offy[j]);
                        continue block22;
                    }
                    case 'u': {
                        NpcHit.JudgeHitNpCharTriangleF(gBoss[b], x + offx[j], y + offy[j]);
                        NpcHit.JudgeHitNpCharWater(gBoss[b], x + offx[j], y + offy[j]);
                        continue block22;
                    }
                    case 'v': {
                        NpcHit.JudgeHitNpCharTriangleG(gBoss[b], x + offx[j], y + offy[j]);
                        NpcHit.JudgeHitNpCharWater(gBoss[b], x + offx[j], y + offy[j]);
                        continue block22;
                    }
                    case 'w': {
                        NpcHit.JudgeHitNpCharTriangleH(gBoss[b], x + offx[j], y + offy[j]);
                        NpcHit.JudgeHitNpCharWater(gBoss[b], x + offx[j], y + offy[j]);
                    }
                }
            }
        }
    }
}
