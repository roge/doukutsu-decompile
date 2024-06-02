/*
 * Decompiled with CFR 0.152.
 */
package jp.studiopixel.doukutsu;

import jp.studiopixel.doukutsu.Caret;
import jp.studiopixel.doukutsu.Draw;
import jp.studiopixel.doukutsu.Game;
import jp.studiopixel.doukutsu.KeyControl;
import jp.studiopixel.doukutsu.MyChar;
import jp.studiopixel.doukutsu.NpChar;
import jp.studiopixel.doukutsu.RECT;
import jp.studiopixel.doukutsu.Sound;

public class Bullet {
    public static final BULLET_TABLE[] gBulTbl = new BULLET_TABLE[]{new BULLET_TABLE(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0), new BULLET_TABLE(4, 1, 20, 36, 4, 4, 2, 2, 8, 8, 8, 8), new BULLET_TABLE(6, 1, 23, 36, 4, 4, 2, 2, 8, 8, 8, 8), new BULLET_TABLE(8, 1, 30, 36, 4, 4, 2, 2, 8, 8, 8, 8), new BULLET_TABLE(1, 1, 8, 32, 6, 6, 2, 2, 8, 8, 8, 8), new BULLET_TABLE(2, 1, 12, 32, 6, 6, 2, 2, 8, 8, 8, 8), new BULLET_TABLE(4, 1, 16, 32, 6, 6, 2, 2, 8, 8, 8, 8), new BULLET_TABLE(2, 2, 100, 8, 8, 16, 4, 2, 8, 8, 8, 8), new BULLET_TABLE(3, 2, 100, 8, 4, 4, 4, 2, 8, 8, 8, 8), new BULLET_TABLE(3, 2, 100, 8, 4, 4, 4, 2, 8, 8, 8, 8), new BULLET_TABLE(2, 1, 20, 32, 2, 2, 2, 2, 8, 8, 8, 8), new BULLET_TABLE(4, 1, 20, 32, 2, 2, 2, 2, 8, 8, 8, 8), new BULLET_TABLE(6, 1, 20, 32, 2, 2, 2, 2, 8, 8, 8, 8), new BULLET_TABLE(0, 10, 50, 40, 2, 2, 2, 2, 8, 8, 8, 8), new BULLET_TABLE(0, 10, 70, 40, 4, 4, 4, 4, 8, 8, 8, 8), new BULLET_TABLE(0, 10, 90, 40, 4, 4, 0, 0, 8, 8, 8, 8), new BULLET_TABLE(1, 100, 100, 20, 16, 16, 0, 0, 0, 0, 0, 0), new BULLET_TABLE(1, 100, 100, 20, 16, 16, 0, 0, 0, 0, 0, 0), new BULLET_TABLE(1, 100, 100, 20, 16, 16, 0, 0, 0, 0, 0, 0), new BULLET_TABLE(1, 1, 20, 8, 2, 2, 2, 2, 4, 4, 4, 4), new BULLET_TABLE(2, 1, 20, 8, 2, 2, 2, 2, 4, 4, 4, 4), new BULLET_TABLE(2, 1, 20, 8, 4, 4, 4, 4, 4, 4, 4, 4), new BULLET_TABLE(3, 1, 32, 32, 2, 2, 2, 2, 4, 4, 4, 4), new BULLET_TABLE(0, 100, 0, 36, 8, 8, 8, 8, 12, 12, 12, 12), new BULLET_TABLE(127, 1, 2, 4, 8, 4, 8, 4, 0, 0, 0, 0), new BULLET_TABLE(15, 1, 30, 36, 8, 8, 4, 2, 8, 8, 8, 8), new BULLET_TABLE(6, 3, 18, 36, 10, 10, 4, 2, 12, 12, 12, 12), new BULLET_TABLE(1, 100, 30, 36, 6, 6, 4, 4, 12, 12, 12, 12), new BULLET_TABLE(0, 10, 30, 40, 2, 2, 2, 2, 8, 8, 8, 8), new BULLET_TABLE(0, 10, 40, 40, 4, 4, 4, 4, 8, 8, 8, 8), new BULLET_TABLE(0, 10, 40, 40, 4, 4, 0, 0, 8, 8, 8, 8), new BULLET_TABLE(2, 100, 100, 20, 12, 12, 0, 0, 0, 0, 0, 0), new BULLET_TABLE(2, 100, 100, 20, 12, 12, 0, 0, 0, 0, 0, 0), new BULLET_TABLE(2, 100, 100, 20, 12, 12, 0, 0, 0, 0, 0, 0), new BULLET_TABLE(4, 4, 20, 32, 4, 4, 3, 3, 8, 8, 24, 8), new BULLET_TABLE(4, 2, 20, 32, 2, 2, 2, 2, 8, 8, 24, 8), new BULLET_TABLE(1, 1, 20, 32, 2, 2, 2, 2, 8, 8, 24, 8), new BULLET_TABLE(4, 4, 30, 64, 6, 6, 3, 3, 8, 8, 8, 8), new BULLET_TABLE(8, 8, 30, 64, 6, 6, 3, 3, 8, 8, 8, 8), new BULLET_TABLE(12, 12, 30, 64, 6, 6, 3, 3, 8, 8, 8, 8), new BULLET_TABLE(3, 100, 30, 32, 6, 6, 3, 3, 4, 4, 4, 4), new BULLET_TABLE(6, 100, 30, 32, 6, 6, 3, 3, 4, 4, 4, 4), new BULLET_TABLE(11, 100, 30, 32, 6, 6, 3, 3, 4, 4, 4, 4), new BULLET_TABLE(4, 4, 20, 32, 4, 4, 3, 3, 8, 8, 24, 8), new BULLET_TABLE(0, 4, 4, 4, 0, 0, 0, 0, 0, 0, 0, 0), new BULLET_TABLE(1, 1, 1, 36, 1, 1, 1, 1, 1, 1, 1, 1)};
    public static final BULLET[] gBul = new BULLET[64];
    private static final RECT[] Frontia1_rcLeft;
    private static final RECT[] Frontia1_rcRight;
    private static final RECT[] Frontia2_rect;
    private static char Frontia2_inc;
    private static final RECT[] PoleStar_rect1;
    private static final RECT[] PoleStar_rect2;
    private static final RECT[] PoleStar_rect3;
    private static final RECT[] FireBall_rect_left1;
    private static final RECT[] FireBall_rect_right1;
    private static final RECT[] FireBall_rect_left2;
    private static final RECT[] FireBall_rect_right2;
    private static final RECT[] MachineGun_rect1;
    private static final RECT[] MachineGun_rect2;
    private static final RECT[] MachineGun_rect3;
    private static final RECT[] Missile_rect1;
    private static final RECT[] Missile_rect2;
    private static final RECT[] Missile_rect3;
    private static int Missile_inc;
    private static final RECT[] Bubblin1_rect;
    private static final RECT[] Bubblin2_rect;
    private static final RECT[] Bubblin3_rect;
    private static final RECT[] Spine_rcLeft;
    private static final RECT[] Spine_rcRight;
    private static final RECT[] Spine_rcDown;
    private static final RECT[] Sword1_rcLeft;
    private static final RECT[] Sword1_rcRight;
    private static final RECT[] Sword2_rcLeft;
    private static final RECT[] Sword2_rcRight;
    private static final RECT[] Sword3_rcLeft;
    private static final RECT[] Sword3_rcUp;
    private static final RECT[] Sword3_rcRight;
    private static final RECT[] Sword3_rcDown;
    private static final RECT[] Edge_rcLeft;
    private static final RECT[] Edge_rcRight;
    private static final RECT Drop_rc;
    private static final RECT[] SuperMissile_rect1;
    private static final RECT[] SuperMissile_rect2;
    private static char SuperMissile_inc;
    private static final RECT[] Nemesis_rcL;
    private static final RECT[] Nemesis_rcU;
    private static final RECT[] Nemesis_rcR;
    private static final RECT[] Nemesis_rcD;
    private static final RECT[] Spur_rect1;
    private static final RECT[] Spur_rect2;
    private static final RECT[] Spur_rect3;
    private static final RECT[] SpurTail_rc_h_lv1;
    private static final RECT[] SpurTail_rc_v_lv1;
    private static final RECT[] SpurTail_rc_h_lv2;
    private static final RECT[] SpurTail_rc_v_lv2;
    private static final RECT[] SpurTail_rc_h_lv3;
    private static final RECT[] SpurTail_rc_v_lv3;

    public static void InitBullet() {
        Bullet.ClearBullet();
    }

    public static int CountArmsBullet(int arms_code) {
        int count = 0;
        for (int i = 0; i < gBul.length; ++i) {
            if ((Bullet.gBul[i].cond & 0x80) == 0 || (Bullet.gBul[i].code_bullet + 2) / 3 != arms_code) continue;
            ++count;
        }
        return count;
    }

    public static int CountBulletNum(int bullet_code) {
        int count = 0;
        for (int i = 0; i < gBul.length; ++i) {
            if ((Bullet.gBul[i].cond & 0x80) == 0 || Bullet.gBul[i].code_bullet != bullet_code) continue;
            ++count;
        }
        return count;
    }

    public static void DeleteBullet(int code) {
        boolean count = false;
        for (int i = 0; i < gBul.length; ++i) {
            if ((Bullet.gBul[i].cond & 0x80) == 0 || (Bullet.gBul[i].code_bullet + 2) / 3 != code) continue;
            Bullet.gBul[i].cond = 0;
        }
    }

    public static void ClearBullet() {
        for (int i = 0; i < gBul.length; ++i) {
            Bullet.gBul[i].cond = 0;
        }
    }

    public static void PutBullet(int fx, int fy) {
        int x = 0;
        int y = 0;
        for (int i = 0; i < gBul.length; ++i) {
            if ((Bullet.gBul[i].cond & 0x80) == 0) continue;
            switch (Bullet.gBul[i].direct) {
                case 0: {
                    x = Bullet.gBul[i].x - Bullet.gBul[i].view.front;
                    y = Bullet.gBul[i].y - Bullet.gBul[i].view.top;
                    break;
                }
                case 1: {
                    x = Bullet.gBul[i].x - Bullet.gBul[i].view.top;
                    y = Bullet.gBul[i].y - Bullet.gBul[i].view.front;
                    break;
                }
                case 2: {
                    x = Bullet.gBul[i].x - Bullet.gBul[i].view.back;
                    y = Bullet.gBul[i].y - Bullet.gBul[i].view.top;
                    break;
                }
                case 3: {
                    x = Bullet.gBul[i].x - Bullet.gBul[i].view.top;
                    y = Bullet.gBul[i].y - Bullet.gBul[i].view.back;
                }
            }
            Draw.PutBitmap3(Draw.grcGame, x / 512 - fx / 512, y / 512 - fy / 512, Bullet.gBul[i].rect, 17);
        }
    }

    public static void SetBullet(int no, int x, int y, int dir) {
        int i;
        for (i = 0; i < gBul.length && (Bullet.gBul[i].cond & 0x80) != 0; ++i) {
        }
        if (i >= gBul.length) {
            return;
        }
        gBul[i].clear();
        Bullet.gBul[i].code_bullet = no;
        Bullet.gBul[i].cond = 128;
        Bullet.gBul[i].direct = (byte)dir;
        Bullet.gBul[i].damage = Bullet.gBulTbl[no].damage;
        Bullet.gBul[i].life = Bullet.gBulTbl[no].life;
        Bullet.gBul[i].life_count = Bullet.gBulTbl[no].life_count;
        Bullet.gBul[i].bbits = Bullet.gBulTbl[no].bbits;
        Bullet.gBul[i].enemyXL = Bullet.gBulTbl[no].enemyXL * 512;
        Bullet.gBul[i].enemyYL = Bullet.gBulTbl[no].enemyYL * 512;
        Bullet.gBul[i].blockXL = Bullet.gBulTbl[no].blockXL * 512;
        Bullet.gBul[i].blockYL = Bullet.gBulTbl[no].blockYL * 512;
        Bullet.gBul[i].view.back = Bullet.gBulTbl[no].view.back * 512;
        Bullet.gBul[i].view.front = Bullet.gBulTbl[no].view.front * 512;
        Bullet.gBul[i].view.top = Bullet.gBulTbl[no].view.top * 512;
        Bullet.gBul[i].view.bottom = Bullet.gBulTbl[no].view.bottom * 512;
        Bullet.gBul[i].x = x;
        Bullet.gBul[i].y = y;
    }

    public static void ActBullet_Frontia1(BULLET bul) {
        if (++bul.count1 > bul.life_count) {
            bul.cond = 0;
            Caret.SetCaret(bul.x, bul.y, 3, 0);
            return;
        }
        if (bul.act_no == 0) {
            bul.ani_no = Game.Random(0, 2);
            bul.act_no = 1;
            switch (bul.direct) {
                case 0: {
                    bul.xm = -1536;
                    break;
                }
                case 1: {
                    bul.ym = -1536;
                    break;
                }
                case 2: {
                    bul.xm = 1536;
                    break;
                }
                case 3: {
                    bul.ym = 1536;
                }
            }
        } else {
            bul.x += bul.xm;
            bul.y += bul.ym;
        }
        if (++bul.ani_wait > 0) {
            bul.ani_wait = 0;
            ++bul.ani_no;
        }
        if (bul.ani_no > 3) {
            bul.ani_no = 0;
        }
        if (bul.direct == 0) {
            bul.rect.copyFrom(Frontia1_rcLeft[bul.ani_no]);
        } else {
            bul.rect.copyFrom(Frontia1_rcRight[bul.ani_no]);
        }
    }

    public static void ActBullet_Frontia2(BULLET bul, int level) {
        if (++bul.count1 > bul.life_count) {
            bul.cond = 0;
            Caret.SetCaret(bul.x, bul.y, 3, 0);
            return;
        }
        if (bul.act_no == 0) {
            bul.ani_no = Game.Random(0, 2);
            bul.act_no = 1;
            switch (bul.direct) {
                case 0: {
                    bul.xm = -512;
                    break;
                }
                case 1: {
                    bul.ym = -512;
                    break;
                }
                case 2: {
                    bul.xm = 512;
                    break;
                }
                case 3: {
                    bul.ym = 512;
                }
            }
            Frontia2_inc = (char)(Frontia2_inc + '\u0001');
            switch (bul.direct) {
                case 0: 
                case 2: {
                    if (Frontia2_inc % 2 != 0) {
                        bul.ym = 1024;
                        break;
                    }
                    bul.ym = -1024;
                    break;
                }
                case 1: 
                case 3: {
                    bul.xm = Frontia2_inc % 2 != 0 ? 1024 : -1024;
                }
            }
        } else {
            switch (bul.direct) {
                case 0: {
                    bul.xm -= 128;
                    break;
                }
                case 1: {
                    bul.ym -= 128;
                    break;
                }
                case 2: {
                    bul.xm += 128;
                    break;
                }
                case 3: {
                    bul.ym += 128;
                }
            }
            switch (bul.direct) {
                case 0: 
                case 2: {
                    if (bul.count1 % 5 != 2) break;
                    if (bul.ym < 0) {
                        bul.ym = 1024;
                        break;
                    }
                    bul.ym = -1024;
                    break;
                }
                case 1: 
                case 3: {
                    if (bul.count1 % 5 != 2) break;
                    bul.xm = bul.xm < 0 ? 1024 : -1024;
                }
            }
            bul.x += bul.xm;
            bul.y += bul.ym;
        }
        if (++bul.ani_wait > 0) {
            bul.ani_wait = 0;
            ++bul.ani_no;
        }
        if (bul.ani_no > 2) {
            bul.ani_no = 0;
        }
        bul.rect.copyFrom(Frontia2_rect[bul.ani_no]);
        if (level == 2) {
            NpChar.SetNpChar(129, bul.x, bul.y, 0, -512, bul.ani_no, null, 256);
        } else {
            NpChar.SetNpChar(129, bul.x, bul.y, 0, -512, bul.ani_no + 3, null, 256);
        }
    }

    public static void ActBullet_PoleStar(BULLET bul, int level) {
        if (++bul.count1 > bul.life_count) {
            bul.cond = 0;
            Caret.SetCaret(bul.x, bul.y, 3, 0);
            return;
        }
        if (bul.act_no == 0) {
            bul.act_no = 1;
            switch (bul.direct) {
                case 0: {
                    bul.xm = -4096;
                    break;
                }
                case 1: {
                    bul.ym = -4096;
                    break;
                }
                case 2: {
                    bul.xm = 4096;
                    break;
                }
                case 3: {
                    bul.ym = 4096;
                }
            }
            block6 : switch (level) {
                case 1: {
                    switch (bul.direct) {
                        case 0: {
                            bul.enemyYL = 1024;
                            break block6;
                        }
                        case 1: {
                            bul.enemyXL = 1024;
                            break block6;
                        }
                        case 2: {
                            bul.enemyYL = 1024;
                            break block6;
                        }
                        case 3: {
                            bul.enemyXL = 1024;
                        }
                    }
                    break;
                }
                case 2: {
                    switch (bul.direct) {
                        case 0: {
                            bul.enemyYL = 2048;
                            break block6;
                        }
                        case 1: {
                            bul.enemyXL = 2048;
                            break block6;
                        }
                        case 2: {
                            bul.enemyYL = 2048;
                            break block6;
                        }
                        case 3: {
                            bul.enemyXL = 2048;
                        }
                    }
                }
            }
        } else {
            bul.x += bul.xm;
            bul.y += bul.ym;
        }
        switch (level) {
            case 1: {
                if (bul.direct == 1 || bul.direct == 3) {
                    bul.rect.copyFrom(PoleStar_rect1[1]);
                    break;
                }
                bul.rect.copyFrom(PoleStar_rect1[0]);
                break;
            }
            case 2: {
                if (bul.direct == 1 || bul.direct == 3) {
                    bul.rect.copyFrom(PoleStar_rect2[1]);
                    break;
                }
                bul.rect.copyFrom(PoleStar_rect2[0]);
                break;
            }
            case 3: {
                if (bul.direct == 1 || bul.direct == 3) {
                    bul.rect.copyFrom(PoleStar_rect3[1]);
                    break;
                }
                bul.rect.copyFrom(PoleStar_rect3[0]);
            }
        }
    }

    public static void ActBullet_FireBall(BULLET bul, int level) {
        if (++bul.count1 > bul.life_count) {
            bul.cond = 0;
            Caret.SetCaret(bul.x, bul.y, 3, 0);
            return;
        }
        boolean bBreak = false;
        if ((bul.flag & 2) != 0 && (bul.flag & 8) != 0) {
            bBreak = true;
        }
        if ((bul.flag & 1) != 0 && (bul.flag & 4) != 0) {
            bBreak = true;
        }
        if (bul.direct == 0 && (bul.flag & 1) != 0) {
            bul.direct = (byte)2;
        }
        if (bul.direct == 2 && (bul.flag & 4) != 0) {
            bul.direct = 0;
        }
        if (bBreak) {
            bul.cond = 0;
            Caret.SetCaret(bul.x, bul.y, 2, 0);
            Sound.PlaySoundObject(28, 1);
            return;
        }
        if (bul.act_no == 0) {
            bul.act_no = 1;
            switch (bul.direct) {
                case 0: {
                    bul.xm = -1024;
                    break;
                }
                case 1: {
                    bul.xm = MyChar.gMC.xm;
                    bul.direct = MyChar.gMC.xm < 0 ? (byte)0 : (byte)2;
                    bul.xm = MyChar.gMC.direct == 0 ? (bul.xm -= 128) : (bul.xm += 128);
                    bul.ym = -1535;
                    break;
                }
                case 2: {
                    bul.xm = 1024;
                    break;
                }
                case 3: {
                    bul.xm = MyChar.gMC.xm;
                    bul.direct = MyChar.gMC.xm < 0 ? (byte)0 : (byte)2;
                    bul.ym = 1535;
                }
            }
        } else {
            if ((bul.flag & 8) != 0) {
                bul.ym = -1024;
            } else if ((bul.flag & 1) != 0) {
                bul.xm = 1024;
            } else if ((bul.flag & 4) != 0) {
                bul.xm = -1024;
            }
            bul.ym += 85;
            if (bul.ym > 1023) {
                bul.ym = 1023;
            }
            bul.x += bul.xm;
            bul.y += bul.ym;
            if ((bul.flag & 0xD) != 0) {
                Sound.PlaySoundObject(34, 1);
            }
        }
        ++bul.ani_no;
        if (level == 1) {
            if (bul.ani_no > 3) {
                bul.ani_no = 0;
            }
            if (bul.direct == 0) {
                bul.rect.copyFrom(FireBall_rect_left1[bul.ani_no]);
            } else {
                bul.rect.copyFrom(FireBall_rect_right1[bul.ani_no]);
            }
        } else {
            if (bul.ani_no > 2) {
                bul.ani_no = 0;
            }
            if (bul.direct == 0) {
                bul.rect.copyFrom(FireBall_rect_left2[bul.ani_no]);
            } else {
                bul.rect.copyFrom(FireBall_rect_right2[bul.ani_no]);
            }
            if (level == 2) {
                NpChar.SetNpChar(129, bul.x, bul.y, 0, -512, bul.ani_no, null, 256);
            } else {
                NpChar.SetNpChar(129, bul.x, bul.y, 0, -512, bul.ani_no + 3, null, 256);
            }
        }
    }

    public static void ActBullet_MachineGun(BULLET bul, int level) {
        int move = 0;
        if (++bul.count1 > bul.life_count) {
            bul.cond = 0;
            Caret.SetCaret(bul.x, bul.y, 3, 0);
            return;
        }
        if (bul.act_no == 0) {
            switch (level) {
                case 1: {
                    move = 4096;
                    break;
                }
                case 2: {
                    move = 4096;
                    break;
                }
                case 3: {
                    move = 4096;
                }
            }
            bul.act_no = 1;
            switch (bul.direct) {
                case 0: {
                    bul.xm = -move;
                    bul.ym = Game.Random(-170, 170);
                    break;
                }
                case 1: {
                    bul.ym = -move;
                    bul.xm = Game.Random(-170, 170);
                    break;
                }
                case 2: {
                    bul.xm = move;
                    bul.ym = Game.Random(-170, 170);
                    break;
                }
                case 3: {
                    bul.ym = move;
                    bul.xm = Game.Random(-170, 170);
                }
            }
        } else {
            bul.x += bul.xm;
            bul.y += bul.ym;
            switch (level) {
                case 1: {
                    bul.rect.copyFrom(MachineGun_rect1[bul.direct]);
                    break;
                }
                case 2: {
                    bul.rect.copyFrom(MachineGun_rect2[bul.direct]);
                    if (bul.direct == 1 || bul.direct == 3) {
                        NpChar.SetNpChar(127, bul.x, bul.y, 0, 0, 1, null, 256);
                        break;
                    }
                    NpChar.SetNpChar(127, bul.x, bul.y, 0, 0, 0, null, 256);
                    break;
                }
                case 3: {
                    bul.rect.copyFrom(MachineGun_rect3[bul.direct]);
                    NpChar.SetNpChar(128, bul.x, bul.y, 0, 0, bul.direct, null, 256);
                }
            }
        }
    }

    public static void ActBullet_Missile(BULLET bul, int level) {
        boolean bHit = false;
        if (++bul.count1 > bul.life_count) {
            bul.cond = 0;
            Caret.SetCaret(bul.x, bul.y, 3, 0);
            return;
        }
        if (bul.life != 10) {
            bHit = true;
        }
        if (bul.direct == 0 && (bul.flag & 1) != 0) {
            bHit = true;
        }
        if (bul.direct == 2 && (bul.flag & 4) != 0) {
            bHit = true;
        }
        if (bul.direct == 1 && (bul.flag & 2) != 0) {
            bHit = true;
        }
        if (bul.direct == 3 && (bul.flag & 8) != 0) {
            bHit = true;
        }
        if (bul.direct == 0 && (bul.flag & 0x80) != 0) {
            bHit = true;
        }
        if (bul.direct == 0 && (bul.flag & 0x20) != 0) {
            bHit = true;
        }
        if (bul.direct == 2 && (bul.flag & 0x40) != 0) {
            bHit = true;
        }
        if (bul.direct == 2 && (bul.flag & 0x10) != 0) {
            bHit = true;
        }
        if (bHit) {
            Bullet.SetBullet(level + 15, bul.x, bul.y, 0);
            bul.cond = 0;
        }
        switch (bul.act_no) {
            case 0: {
                bul.act_no = 1;
                switch (bul.direct) {
                    case 0: 
                    case 2: {
                        bul.tgt_y = bul.y;
                        break;
                    }
                    case 1: 
                    case 3: {
                        bul.tgt_x = bul.x;
                    }
                }
                if (level == 3) {
                    switch (bul.direct) {
                        case 0: 
                        case 2: {
                            bul.ym = bul.y > MyChar.gMC.y ? 256 : -256;
                            bul.xm = Game.Random(-512, 512);
                            break;
                        }
                        case 1: 
                        case 3: {
                            bul.xm = bul.x > MyChar.gMC.x ? 256 : -256;
                            bul.ym = Game.Random(-512, 512);
                        }
                    }
                    switch (++Missile_inc % 3) {
                        case 0: {
                            bul.ani_no = 128;
                            break;
                        }
                        case 1: {
                            bul.ani_no = 64;
                            break;
                        }
                        case 2: {
                            bul.ani_no = 51;
                        }
                    }
                } else {
                    bul.ani_no = 128;
                }
            }
            case 1: {
                switch (bul.direct) {
                    case 0: {
                        bul.xm -= bul.ani_no;
                        break;
                    }
                    case 1: {
                        bul.ym -= bul.ani_no;
                        break;
                    }
                    case 2: {
                        bul.xm += bul.ani_no;
                        break;
                    }
                    case 3: {
                        bul.ym += bul.ani_no;
                    }
                }
                if (level == 3) {
                    switch (bul.direct) {
                        case 0: 
                        case 2: {
                            if (bul.y < bul.tgt_y) {
                                bul.ym += 32;
                                break;
                            }
                            bul.ym -= 32;
                            break;
                        }
                        case 1: 
                        case 3: {
                            if (bul.x < bul.tgt_x) {
                                bul.xm += 32;
                                break;
                            }
                            bul.xm -= 32;
                        }
                    }
                }
                if (bul.xm < -2560) {
                    bul.xm = -2560;
                }
                if (bul.xm > 2560) {
                    bul.xm = 2560;
                }
                if (bul.ym < -2560) {
                    bul.ym = -2560;
                }
                if (bul.ym > 2560) {
                    bul.ym = 2560;
                }
                bul.x += bul.xm;
                bul.y += bul.ym;
            }
        }
        if (++bul.count2 > 2) {
            bul.count2 = 0;
            switch (bul.direct) {
                case 0: {
                    Caret.SetCaret(bul.x + 4096, bul.y, 7, 2);
                    break;
                }
                case 1: {
                    Caret.SetCaret(bul.x, bul.y + 4096, 7, 3);
                    break;
                }
                case 2: {
                    Caret.SetCaret(bul.x - 4096, bul.y, 7, 0);
                    break;
                }
                case 3: {
                    Caret.SetCaret(bul.x, bul.y - 4096, 7, 1);
                }
            }
        }
        switch (level) {
            case 1: {
                bul.rect.copyFrom(Missile_rect1[bul.direct]);
                break;
            }
            case 2: {
                bul.rect.copyFrom(Missile_rect2[bul.direct]);
                break;
            }
            case 3: {
                bul.rect.copyFrom(Missile_rect3[bul.direct]);
            }
        }
    }

    public static void ActBullet_Bom(BULLET bul, int level) {
        switch (bul.act_no) {
            case 0: {
                bul.act_no = 1;
                switch (level) {
                    case 1: {
                        bul.act_wait = 10;
                        break;
                    }
                    case 2: {
                        bul.act_wait = 15;
                        break;
                    }
                    case 3: {
                        bul.act_wait = 5;
                    }
                }
                Sound.PlaySoundObject(44, 1);
            }
            case 1: {
                switch (level) {
                    case 1: {
                        if (bul.act_wait % 3 != 0) break;
                        NpChar.SetDestroyNpCharUp(bul.x + Game.Random(-16, 16) * 512, bul.y + Game.Random(-16, 16) * 512, bul.enemyXL, 2);
                        break;
                    }
                    case 2: {
                        if (bul.act_wait % 3 != 0) break;
                        NpChar.SetDestroyNpCharUp(bul.x + Game.Random(-32, 32) * 512, bul.y + Game.Random(-32, 32) * 512, bul.enemyXL, 2);
                        break;
                    }
                    case 3: {
                        if (bul.act_wait % 3 != 0) break;
                        NpChar.SetDestroyNpCharUp(bul.x + Game.Random(-40, 40) * 512, bul.y + Game.Random(-40, 40) * 512, bul.enemyXL, 2);
                    }
                }
                if (--bul.act_wait >= 0) break;
                bul.cond = 0;
            }
        }
    }

    public static void ActBullet_Bubblin1(BULLET bul) {
        if ((bul.flag & 0x2FF) != 0) {
            bul.cond = 0;
            Caret.SetCaret(bul.x, bul.y, 2, 0);
            return;
        }
        block0 : switch (bul.act_no) {
            case 0: {
                bul.act_no = 1;
                switch (bul.direct) {
                    case 0: {
                        bul.xm = -1536;
                        break block0;
                    }
                    case 2: {
                        bul.xm = 1536;
                        break block0;
                    }
                    case 1: {
                        bul.ym = -1536;
                        break block0;
                    }
                    case 3: {
                        bul.ym = 1536;
                    }
                }
            }
        }
        switch (bul.direct) {
            case 0: {
                bul.xm += 42;
                break;
            }
            case 2: {
                bul.xm -= 42;
                break;
            }
            case 1: {
                bul.ym += 42;
                break;
            }
            case 3: {
                bul.ym -= 42;
            }
        }
        bul.x += bul.xm;
        bul.y += bul.ym;
        if (++bul.act_wait > 40) {
            bul.cond = 0;
            Caret.SetCaret(bul.x, bul.y, 15, 0);
        }
        if (++bul.ani_wait > 3) {
            bul.ani_wait = 0;
            ++bul.ani_no;
        }
        if (bul.ani_no > 3) {
            bul.ani_no = 3;
        }
        bul.rect.copyFrom(Bubblin1_rect[bul.ani_no]);
    }

    public static void ActBullet_Bubblin2(BULLET bul) {
        boolean bDelete = false;
        if (bul.direct == 0 && (bul.flag & 1) != 0) {
            bDelete = true;
        }
        if (bul.direct == 2 && (bul.flag & 4) != 0) {
            bDelete = true;
        }
        if (bul.direct == 1 && (bul.flag & 2) != 0) {
            bDelete = true;
        }
        if (bul.direct == 3 && (bul.flag & 8) != 0) {
            bDelete = true;
        }
        if (bDelete) {
            bul.cond = 0;
            Caret.SetCaret(bul.x, bul.y, 2, 0);
            return;
        }
        block0 : switch (bul.act_no) {
            case 0: {
                bul.act_no = 1;
                switch (bul.direct) {
                    case 0: {
                        bul.xm = -1536;
                        bul.ym = Game.Random(-256, 256);
                        break block0;
                    }
                    case 2: {
                        bul.xm = 1536;
                        bul.ym = Game.Random(-256, 256);
                        break block0;
                    }
                    case 1: {
                        bul.ym = -1536;
                        bul.xm = Game.Random(-256, 256);
                        break block0;
                    }
                    case 3: {
                        bul.ym = 1536;
                        bul.xm = Game.Random(-256, 256);
                    }
                }
            }
        }
        switch (bul.direct) {
            case 0: {
                bul.xm += 16;
                break;
            }
            case 2: {
                bul.xm -= 16;
                break;
            }
            case 1: {
                bul.ym += 16;
                break;
            }
            case 3: {
                bul.ym -= 16;
            }
        }
        bul.x += bul.xm;
        bul.y += bul.ym;
        if (++bul.act_wait > 60) {
            bul.cond = 0;
            Caret.SetCaret(bul.x, bul.y, 15, 0);
        }
        if (++bul.ani_wait > 3) {
            bul.ani_wait = 0;
            ++bul.ani_no;
        }
        if (bul.ani_no > 3) {
            bul.ani_no = 3;
        }
        bul.rect.copyFrom(Bubblin2_rect[bul.ani_no]);
    }

    public static void ActBullet_Bubblin3(BULLET bul) {
        if (++bul.act_wait > 100 || (KeyControl.gKey & KeyControl.gKeyShot) == 0) {
            bul.cond = 0;
            Caret.SetCaret(bul.x, bul.y, 2, 0);
            Sound.PlaySoundObject(100, 1);
            if (MyChar.gMC.up) {
                Bullet.SetBullet(22, bul.x, bul.y, 1);
            } else if (MyChar.gMC.down) {
                Bullet.SetBullet(22, bul.x, bul.y, 3);
            } else {
                Bullet.SetBullet(22, bul.x, bul.y, MyChar.gMC.direct);
            }
            return;
        }
        block0 : switch (bul.act_no) {
            case 0: {
                bul.act_no = 1;
                switch (bul.direct) {
                    case 0: {
                        bul.xm = Game.Random(-1024, -512);
                        bul.ym = Game.Random(-4, 4) * 512 / 2;
                        break block0;
                    }
                    case 2: {
                        bul.xm = Game.Random(512, 1024);
                        bul.ym = Game.Random(-4, 4) * 512 / 2;
                        break block0;
                    }
                    case 1: {
                        bul.ym = Game.Random(-1024, -512);
                        bul.xm = Game.Random(-4, 4) * 512 / 2;
                        break block0;
                    }
                    case 3: {
                        bul.ym = Game.Random(128, 256);
                        bul.xm = Game.Random(-4, 4) * 512 / 2;
                    }
                }
            }
        }
        if (bul.x < MyChar.gMC.x) {
            bul.xm += 32;
        }
        if (bul.x > MyChar.gMC.x) {
            bul.xm -= 32;
        }
        if (bul.y < MyChar.gMC.y) {
            bul.ym += 32;
        }
        if (bul.y > MyChar.gMC.y) {
            bul.ym -= 32;
        }
        if (bul.xm < 0 && (bul.flag & 1) != 0) {
            bul.xm = 1024;
        }
        if (bul.xm > 0 && (bul.flag & 4) != 0) {
            bul.xm = -1024;
        }
        if (bul.ym < 0 && (bul.flag & 2) != 0) {
            bul.ym = 1024;
        }
        if (bul.ym > 0 && (bul.flag & 8) != 0) {
            bul.ym = -1024;
        }
        bul.x += bul.xm;
        bul.y += bul.ym;
        if (++bul.ani_wait > 3) {
            bul.ani_wait = 0;
            ++bul.ani_no;
        }
        if (bul.ani_no > 3) {
            bul.ani_no = 3;
        }
        bul.rect.copyFrom(Bubblin3_rect[bul.ani_no]);
    }

    public static void ActBullet_Spine(BULLET bul) {
        if (++bul.count1 > bul.life_count || (bul.flag & 8) != 0) {
            bul.cond = 0;
            Caret.SetCaret(bul.x, bul.y, 3, 0);
            return;
        }
        if (bul.act_no == 0) {
            bul.act_no = 1;
            switch (bul.direct) {
                case 0: {
                    bul.xm = -Game.Random(10, 16) * 512 / 2;
                    break;
                }
                case 1: {
                    bul.ym = -Game.Random(10, 16) * 512 / 2;
                    break;
                }
                case 2: {
                    bul.xm = Game.Random(10, 16) * 512 / 2;
                    break;
                }
                case 3: {
                    bul.ym = Game.Random(10, 16) * 512 / 2;
                }
            }
        } else {
            bul.x += bul.xm;
            bul.y += bul.ym;
        }
        if (++bul.ani_wait > 1) {
            bul.ani_wait = 0;
            ++bul.ani_no;
        }
        if (bul.ani_no > 1) {
            bul.ani_no = 0;
        }
        switch (bul.direct) {
            case 0: {
                bul.rect.copyFrom(Spine_rcLeft[bul.ani_no]);
                break;
            }
            case 1: {
                bul.rect.copyFrom(Spine_rcDown[bul.ani_no]);
                break;
            }
            case 2: {
                bul.rect.copyFrom(Spine_rcRight[bul.ani_no]);
                break;
            }
            case 3: {
                bul.rect.copyFrom(Spine_rcDown[bul.ani_no]);
            }
        }
    }

    public static void ActBullet_Sword1(BULLET bul) {
        if (++bul.count1 > bul.life_count) {
            bul.cond = 0;
            Caret.SetCaret(bul.x, bul.y, 3, 0);
            return;
        }
        if (bul.count1 == 3) {
            bul.bbits &= 0xFFFFFFFB;
        }
        if (bul.count1 % 5 == 1) {
            Sound.PlaySoundObject(34, 1);
        }
        if (bul.act_no == 0) {
            bul.act_no = 1;
            switch (bul.direct) {
                case 0: {
                    bul.xm = -2048;
                    break;
                }
                case 1: {
                    bul.ym = -2048;
                    break;
                }
                case 2: {
                    bul.xm = 2048;
                    break;
                }
                case 3: {
                    bul.ym = 2048;
                }
            }
        } else {
            bul.x += bul.xm;
            bul.y += bul.ym;
        }
        if (++bul.ani_wait > 1) {
            bul.ani_wait = 0;
            ++bul.ani_no;
        }
        if (bul.ani_no > 3) {
            bul.ani_no = 0;
        }
        if (bul.direct == 0) {
            bul.rect.copyFrom(Sword1_rcLeft[bul.ani_no]);
        } else {
            bul.rect.copyFrom(Sword1_rcRight[bul.ani_no]);
        }
    }

    public static void ActBullet_Sword2(BULLET bul) {
        if (++bul.count1 > bul.life_count) {
            bul.cond = 0;
            Caret.SetCaret(bul.x, bul.y, 3, 0);
            return;
        }
        if (bul.count1 == 3) {
            bul.bbits &= 0xFFFFFFFB;
        }
        if (bul.count1 % 7 == 1) {
            Sound.PlaySoundObject(106, 1);
        }
        if (bul.act_no == 0) {
            bul.act_no = 1;
            switch (bul.direct) {
                case 0: {
                    bul.xm = -2048;
                    break;
                }
                case 1: {
                    bul.ym = -2048;
                    break;
                }
                case 2: {
                    bul.xm = 2048;
                    break;
                }
                case 3: {
                    bul.ym = 2048;
                }
            }
        } else {
            bul.x += bul.xm;
            bul.y += bul.ym;
        }
        if (++bul.ani_wait > 1) {
            bul.ani_wait = 0;
            ++bul.ani_no;
        }
        if (bul.ani_no > 3) {
            bul.ani_no = 0;
        }
        if (bul.direct == 0) {
            bul.rect.copyFrom(Sword2_rcLeft[bul.ani_no]);
        } else {
            bul.rect.copyFrom(Sword2_rcRight[bul.ani_no]);
        }
    }

    public static void ActBullet_Sword3(BULLET bul) {
        switch (bul.act_no) {
            case 0: {
                bul.act_no = 1;
                bul.xm = 0;
                bul.ym = 0;
            }
            case 1: {
                switch (bul.direct) {
                    case 0: {
                        bul.xm = -2048;
                        break;
                    }
                    case 1: {
                        bul.ym = -2048;
                        break;
                    }
                    case 2: {
                        bul.xm = 2048;
                        break;
                    }
                    case 3: {
                        bul.ym = 2048;
                    }
                }
                if (bul.life != 100) {
                    bul.act_no = 2;
                    bul.ani_no = 1;
                    bul.damage = -1;
                    bul.act_wait = 0;
                }
                if (++bul.act_wait % 4 == 1) {
                    Sound.PlaySoundObject(106, 1);
                    if (++bul.count1 % 2 != 0) {
                        Bullet.SetBullet(23, bul.x, bul.y, 0);
                    } else {
                        Bullet.SetBullet(23, bul.x, bul.y, 2);
                    }
                }
                if (++bul.count1 == 5) {
                    bul.bbits &= 0xFFFFFFFB;
                }
                if (bul.count1 <= bul.life_count) break;
                bul.cond = 0;
                Caret.SetCaret(bul.x, bul.y, 3, 0);
                return;
            }
            case 2: {
                bul.xm = 0;
                bul.ym = 0;
                ++bul.act_wait;
                if (Game.Random(-1, 1) == 0) {
                    Sound.PlaySoundObject(106, 1);
                    if (Game.Random(0, 1) % 2 != 0) {
                        Bullet.SetBullet(23, bul.x + Game.Random(-64, 64) * 512, bul.y + Game.Random(-64, 64) * 512, 0);
                    } else {
                        Bullet.SetBullet(23, bul.x + Game.Random(-64, 64) * 512, bul.y + Game.Random(-64, 64) * 512, 2);
                    }
                }
                if (bul.act_wait <= 50) break;
                bul.cond = 0;
            }
        }
        bul.x += bul.xm;
        bul.y += bul.ym;
        switch (bul.direct) {
            case 0: {
                bul.rect.copyFrom(Sword3_rcLeft[bul.ani_no]);
                break;
            }
            case 1: {
                bul.rect.copyFrom(Sword3_rcUp[bul.ani_no]);
                break;
            }
            case 2: {
                bul.rect.copyFrom(Sword3_rcRight[bul.ani_no]);
                break;
            }
            case 3: {
                bul.rect.copyFrom(Sword3_rcDown[bul.ani_no]);
            }
        }
        if (bul.act_wait % 2 != 0) {
            bul.rect.right = 0;
        }
    }

    public static void ActBullet_Edge(BULLET bul) {
        switch (bul.act_no) {
            case 0: {
                bul.act_no = 1;
                bul.y -= 6144;
                bul.x = bul.direct == 0 ? (bul.x += 8192) : (bul.x -= 8192);
            }
            case 1: {
                if (++bul.ani_wait > 2) {
                    bul.ani_wait = 0;
                    ++bul.ani_no;
                }
                bul.x = bul.direct == 0 ? (bul.x -= 1024) : (bul.x += 1024);
                bul.y += 1024;
                bul.damage = bul.ani_no == 1 ? 2 : 1;
                if (bul.ani_no <= 4) break;
                bul.cond = 0;
                return;
            }
        }
        if (bul.direct == 0) {
            bul.rect.copyFrom(Edge_rcLeft[bul.ani_no]);
        } else {
            bul.rect.copyFrom(Edge_rcRight[bul.ani_no]);
        }
    }

    public static void ActBullet_Drop(BULLET bul) {
        if (++bul.act_wait > 2) {
            bul.cond = 0;
        }
        bul.rect.copyFrom(Drop_rc);
    }

    public static void ActBullet_SuperMissile(BULLET bul, int level) {
        boolean bHit = false;
        if (++bul.count1 > bul.life_count) {
            bul.cond = 0;
            Caret.SetCaret(bul.x, bul.y, 3, 0);
            return;
        }
        if (bul.life != 10) {
            bHit = true;
        }
        if (bul.direct == 0 && (bul.flag & 1) != 0) {
            bHit = true;
        }
        if (bul.direct == 2 && (bul.flag & 4) != 0) {
            bHit = true;
        }
        if (bul.direct == 1 && (bul.flag & 2) != 0) {
            bHit = true;
        }
        if (bul.direct == 3 && (bul.flag & 8) != 0) {
            bHit = true;
        }
        if (bul.direct == 0 && (bul.flag & 0x80) != 0) {
            bHit = true;
        }
        if (bul.direct == 0 && (bul.flag & 0x20) != 0) {
            bHit = true;
        }
        if (bul.direct == 2 && (bul.flag & 0x40) != 0) {
            bHit = true;
        }
        if (bul.direct == 2 && (bul.flag & 0x10) != 0) {
            bHit = true;
        }
        if (bHit) {
            Bullet.SetBullet(level + 30, bul.x, bul.y, 0);
            bul.cond = 0;
        }
        switch (bul.act_no) {
            case 0: {
                bul.act_no = 1;
                switch (bul.direct) {
                    case 0: 
                    case 2: {
                        bul.tgt_y = bul.y;
                        bul.enemyXL = 4096;
                        bul.blockXL = 4096;
                        break;
                    }
                    case 1: 
                    case 3: {
                        bul.tgt_x = bul.x;
                        bul.enemyYL = 4096;
                        bul.blockYL = 4096;
                    }
                }
                if (level == 3) {
                    switch (bul.direct) {
                        case 0: 
                        case 2: {
                            bul.ym = bul.y > MyChar.gMC.y ? 256 : -256;
                            bul.xm = Game.Random(-512, 512);
                            break;
                        }
                        case 1: 
                        case 3: {
                            bul.xm = bul.x > MyChar.gMC.x ? 256 : -256;
                            bul.ym = Game.Random(-512, 512);
                        }
                    }
                    SuperMissile_inc = (char)(SuperMissile_inc + '\u0001');
                    switch (SuperMissile_inc % 3) {
                        case 0: {
                            bul.ani_no = 512;
                            break;
                        }
                        case 1: {
                            bul.ani_no = 256;
                            break;
                        }
                        case 2: {
                            bul.ani_no = 170;
                        }
                    }
                } else {
                    bul.ani_no = 512;
                }
            }
            case 1: {
                switch (bul.direct) {
                    case 0: {
                        bul.xm += -bul.ani_no;
                        break;
                    }
                    case 1: {
                        bul.ym += -bul.ani_no;
                        break;
                    }
                    case 2: {
                        bul.xm += bul.ani_no;
                        break;
                    }
                    case 3: {
                        bul.ym += bul.ani_no;
                    }
                }
                if (level == 3) {
                    switch (bul.direct) {
                        case 0: 
                        case 2: {
                            if (bul.y < bul.tgt_y) {
                                bul.ym += 64;
                                break;
                            }
                            bul.ym -= 64;
                            break;
                        }
                        case 1: 
                        case 3: {
                            if (bul.x < bul.tgt_x) {
                                bul.xm += 64;
                                break;
                            }
                            bul.xm -= 64;
                        }
                    }
                }
                if (bul.xm < -5120) {
                    bul.xm = -5120;
                }
                if (bul.xm > 5120) {
                    bul.xm = 5120;
                }
                if (bul.ym < -5120) {
                    bul.ym = -5120;
                }
                if (bul.ym > 5120) {
                    bul.ym = 5120;
                }
                bul.x += bul.xm;
                bul.y += bul.ym;
            }
        }
        if (++bul.count2 > 2) {
            bul.count2 = 0;
            switch (bul.direct) {
                case 0: {
                    Caret.SetCaret(bul.x + 4096, bul.y, 7, 2);
                    break;
                }
                case 1: {
                    Caret.SetCaret(bul.x, bul.y + 4096, 7, 3);
                    break;
                }
                case 2: {
                    Caret.SetCaret(bul.x - 4096, bul.y, 7, 0);
                    break;
                }
                case 3: {
                    Caret.SetCaret(bul.x, bul.y - 4096, 7, 1);
                }
            }
        }
        switch (level) {
            case 1: 
            case 3: {
                bul.rect.copyFrom(SuperMissile_rect1[bul.direct]);
                break;
            }
            case 2: {
                bul.rect.copyFrom(SuperMissile_rect2[bul.direct]);
            }
        }
    }

    public static void ActBullet_SuperBom(BULLET bul, int level) {
        switch (bul.act_no) {
            case 0: {
                bul.act_no = 1;
                switch (level) {
                    case 1: {
                        bul.act_wait = 10;
                        break;
                    }
                    case 2: {
                        bul.act_wait = 14;
                        break;
                    }
                    case 3: {
                        bul.act_wait = 6;
                    }
                }
                Sound.PlaySoundObject(44, 1);
            }
            case 1: {
                switch (level) {
                    case 1: {
                        if (bul.act_wait % 3 != 0) break;
                        NpChar.SetDestroyNpCharUp(bul.x + Game.Random(-16, 16) * 512, bul.y + Game.Random(-16, 16) * 512, bul.enemyXL, 2);
                        break;
                    }
                    case 2: {
                        if (bul.act_wait % 3 != 0) break;
                        NpChar.SetDestroyNpCharUp(bul.x + Game.Random(-32, 32) * 512, bul.y + Game.Random(-32, 32) * 512, bul.enemyXL, 2);
                        break;
                    }
                    case 3: {
                        if (bul.act_wait % 3 != 0) break;
                        NpChar.SetDestroyNpCharUp(bul.x + Game.Random(-40, 40) * 512, bul.y + Game.Random(-40, 40) * 512, bul.enemyXL, 2);
                    }
                }
                if (--bul.act_wait >= 0) break;
                bul.cond = 0;
            }
        }
    }

    public static void ActBullet_Nemesis(BULLET bul, int level) {
        if (++bul.count1 > bul.life_count) {
            bul.cond = 0;
            Caret.SetCaret(bul.x, bul.y, 3, 0);
            return;
        }
        if (bul.act_no == 0) {
            bul.act_no = 1;
            bul.count1 = 0;
            switch (bul.direct) {
                case 0: {
                    bul.xm = -4096;
                    break;
                }
                case 1: {
                    bul.ym = -4096;
                    break;
                }
                case 2: {
                    bul.xm = 4096;
                    break;
                }
                case 3: {
                    bul.ym = 4096;
                }
            }
            switch (level) {
                case 3: {
                    bul.xm /= 3;
                    bul.ym /= 3;
                }
            }
        } else {
            if (level == 1 && bul.count1 % 4 == 1) {
                switch (bul.direct) {
                    case 0: {
                        NpChar.SetNpChar(4, bul.x, bul.y, -512, Game.Random(-512, 512), 2, null, 256);
                        break;
                    }
                    case 1: {
                        NpChar.SetNpChar(4, bul.x, bul.y, Game.Random(-512, 512), -512, 2, null, 256);
                        break;
                    }
                    case 2: {
                        NpChar.SetNpChar(4, bul.x, bul.y, 512, Game.Random(-512, 512), 2, null, 256);
                        break;
                    }
                    case 3: {
                        NpChar.SetNpChar(4, bul.x, bul.y, Game.Random(-512, 512), 512, 2, null, 256);
                    }
                }
            }
            bul.x += bul.xm;
            bul.y += bul.ym;
        }
        if (++bul.ani_no > 1) {
            bul.ani_no = 0;
        }
        switch (bul.direct) {
            case 0: {
                bul.rect.copyFrom(Nemesis_rcL[bul.ani_no]);
                break;
            }
            case 1: {
                bul.rect.copyFrom(Nemesis_rcU[bul.ani_no]);
                break;
            }
            case 2: {
                bul.rect.copyFrom(Nemesis_rcR[bul.ani_no]);
                break;
            }
            case 3: {
                bul.rect.copyFrom(Nemesis_rcD[bul.ani_no]);
            }
        }
        bul.rect.top += (level - 1) / 2 * 32;
        bul.rect.bottom += (level - 1) / 2 * 32;
        bul.rect.left += (level - 1) % 2 * 128;
        bul.rect.right += (level - 1) % 2 * 128;
    }

    public static void ActBullet_Spur(BULLET bul, int level) {
        if (++bul.count1 > bul.life_count) {
            bul.cond = 0;
            Caret.SetCaret(bul.x, bul.y, 3, 0);
            return;
        }
        if (bul.damage != 0 && bul.life != 100) {
            bul.damage = 0;
        }
        if (bul.act_no == 0) {
            bul.act_no = 1;
            switch (bul.direct) {
                case 0: {
                    bul.xm = -4096;
                    break;
                }
                case 1: {
                    bul.ym = -4096;
                    break;
                }
                case 2: {
                    bul.xm = 4096;
                    break;
                }
                case 3: {
                    bul.ym = 4096;
                }
            }
            block6 : switch (level) {
                case 1: {
                    switch (bul.direct) {
                        case 0: {
                            bul.enemyYL = 1024;
                            break block6;
                        }
                        case 1: {
                            bul.enemyXL = 1024;
                            break block6;
                        }
                        case 2: {
                            bul.enemyYL = 1024;
                            break block6;
                        }
                        case 3: {
                            bul.enemyXL = 1024;
                        }
                    }
                    break;
                }
                case 2: {
                    switch (bul.direct) {
                        case 0: {
                            bul.enemyYL = 2048;
                            break block6;
                        }
                        case 1: {
                            bul.enemyXL = 2048;
                            break block6;
                        }
                        case 2: {
                            bul.enemyYL = 2048;
                            break block6;
                        }
                        case 3: {
                            bul.enemyXL = 2048;
                        }
                    }
                }
            }
        } else {
            bul.x += bul.xm;
            bul.y += bul.ym;
        }
        bul.damage = bul.life;
        switch (level) {
            case 1: {
                if (bul.direct == 1 || bul.direct == 3) {
                    bul.rect.copyFrom(Spur_rect1[1]);
                    break;
                }
                bul.rect.copyFrom(Spur_rect1[0]);
                break;
            }
            case 2: {
                if (bul.direct == 1 || bul.direct == 3) {
                    bul.rect.copyFrom(Spur_rect2[1]);
                    break;
                }
                bul.rect.copyFrom(Spur_rect2[0]);
                break;
            }
            case 3: {
                if (bul.direct == 1 || bul.direct == 3) {
                    bul.rect.copyFrom(Spur_rect3[1]);
                    break;
                }
                bul.rect.copyFrom(Spur_rect3[0]);
            }
        }
        Bullet.SetBullet(39 + level, bul.x, bul.y, bul.direct);
    }

    public static void ActBullet_SpurTail(BULLET bul, int level) {
        if (++bul.count1 > 20) {
            bul.ani_no = bul.count1 - 20;
        }
        if (bul.ani_no > 2) {
            bul.cond = 0;
            return;
        }
        if (bul.damage != 0 && bul.life != 100) {
            bul.damage = 0;
        }
        switch (level) {
            case 1: {
                if (bul.direct == 0 || bul.direct == 2) {
                    bul.rect.copyFrom(SpurTail_rc_h_lv1[bul.ani_no]);
                    break;
                }
                bul.rect.copyFrom(SpurTail_rc_v_lv1[bul.ani_no]);
                break;
            }
            case 2: {
                if (bul.direct == 0 || bul.direct == 2) {
                    bul.rect.copyFrom(SpurTail_rc_h_lv2[bul.ani_no]);
                    break;
                }
                bul.rect.copyFrom(SpurTail_rc_v_lv2[bul.ani_no]);
                break;
            }
            case 3: {
                if (bul.direct == 0 || bul.direct == 2) {
                    bul.rect.copyFrom(SpurTail_rc_h_lv3[bul.ani_no]);
                    break;
                }
                bul.rect.copyFrom(SpurTail_rc_v_lv3[bul.ani_no]);
            }
        }
    }

    public static void ActBullet_EnemyClear(BULLET bul) {
        if (++bul.count1 > bul.life_count) {
            bul.cond = 0;
            return;
        }
        bul.damage = 10000;
        bul.enemyXL = 819200;
        bul.enemyYL = 819200;
    }

    public static void ActBullet_Star(BULLET bul) {
        if (++bul.count1 > bul.life_count) {
            bul.cond = 0;
        }
    }

    public static void ActBullet() {
        block47: for (int i = 0; i < gBul.length; ++i) {
            if ((Bullet.gBul[i].cond & 0x80) == 0) continue;
            if (Bullet.gBul[i].life < 1) {
                Bullet.gBul[i].cond = 0;
                continue;
            }
            switch (Bullet.gBul[i].code_bullet) {
                case 1: {
                    Bullet.ActBullet_Frontia1(gBul[i]);
                    continue block47;
                }
                case 2: {
                    Bullet.ActBullet_Frontia2(gBul[i], 2);
                    continue block47;
                }
                case 3: {
                    Bullet.ActBullet_Frontia2(gBul[i], 3);
                    continue block47;
                }
                case 4: {
                    Bullet.ActBullet_PoleStar(gBul[i], 1);
                    continue block47;
                }
                case 5: {
                    Bullet.ActBullet_PoleStar(gBul[i], 2);
                    continue block47;
                }
                case 6: {
                    Bullet.ActBullet_PoleStar(gBul[i], 3);
                    continue block47;
                }
                case 7: {
                    Bullet.ActBullet_FireBall(gBul[i], 1);
                    continue block47;
                }
                case 8: {
                    Bullet.ActBullet_FireBall(gBul[i], 2);
                    continue block47;
                }
                case 9: {
                    Bullet.ActBullet_FireBall(gBul[i], 3);
                    continue block47;
                }
                case 10: {
                    Bullet.ActBullet_MachineGun(gBul[i], 1);
                    continue block47;
                }
                case 11: {
                    Bullet.ActBullet_MachineGun(gBul[i], 2);
                    continue block47;
                }
                case 12: {
                    Bullet.ActBullet_MachineGun(gBul[i], 3);
                    continue block47;
                }
                case 13: {
                    Bullet.ActBullet_Missile(gBul[i], 1);
                    continue block47;
                }
                case 14: {
                    Bullet.ActBullet_Missile(gBul[i], 2);
                    continue block47;
                }
                case 15: {
                    Bullet.ActBullet_Missile(gBul[i], 3);
                    continue block47;
                }
                case 16: {
                    Bullet.ActBullet_Bom(gBul[i], 1);
                    continue block47;
                }
                case 17: {
                    Bullet.ActBullet_Bom(gBul[i], 2);
                    continue block47;
                }
                case 18: {
                    Bullet.ActBullet_Bom(gBul[i], 3);
                    continue block47;
                }
                case 19: {
                    Bullet.ActBullet_Bubblin1(gBul[i]);
                    continue block47;
                }
                case 20: {
                    Bullet.ActBullet_Bubblin2(gBul[i]);
                    continue block47;
                }
                case 21: {
                    Bullet.ActBullet_Bubblin3(gBul[i]);
                    continue block47;
                }
                case 22: {
                    Bullet.ActBullet_Spine(gBul[i]);
                    continue block47;
                }
                case 23: {
                    Bullet.ActBullet_Edge(gBul[i]);
                    continue block47;
                }
                case 24: {
                    Bullet.ActBullet_Drop(gBul[i]);
                    continue block47;
                }
                case 25: {
                    Bullet.ActBullet_Sword1(gBul[i]);
                    continue block47;
                }
                case 26: {
                    Bullet.ActBullet_Sword2(gBul[i]);
                    continue block47;
                }
                case 27: {
                    Bullet.ActBullet_Sword3(gBul[i]);
                    continue block47;
                }
                case 28: {
                    Bullet.ActBullet_SuperMissile(gBul[i], 1);
                    continue block47;
                }
                case 29: {
                    Bullet.ActBullet_SuperMissile(gBul[i], 2);
                    continue block47;
                }
                case 30: {
                    Bullet.ActBullet_SuperMissile(gBul[i], 3);
                    continue block47;
                }
                case 31: {
                    Bullet.ActBullet_SuperBom(gBul[i], 1);
                    continue block47;
                }
                case 32: {
                    Bullet.ActBullet_SuperBom(gBul[i], 2);
                    continue block47;
                }
                case 33: {
                    Bullet.ActBullet_SuperBom(gBul[i], 3);
                    continue block47;
                }
                case 34: {
                    Bullet.ActBullet_Nemesis(gBul[i], 1);
                    continue block47;
                }
                case 35: {
                    Bullet.ActBullet_Nemesis(gBul[i], 2);
                    continue block47;
                }
                case 36: {
                    Bullet.ActBullet_Nemesis(gBul[i], 3);
                    continue block47;
                }
                case 37: {
                    Bullet.ActBullet_Spur(gBul[i], 1);
                    continue block47;
                }
                case 38: {
                    Bullet.ActBullet_Spur(gBul[i], 2);
                    continue block47;
                }
                case 39: {
                    Bullet.ActBullet_Spur(gBul[i], 3);
                    continue block47;
                }
                case 40: {
                    Bullet.ActBullet_SpurTail(gBul[i], 1);
                    continue block47;
                }
                case 41: {
                    Bullet.ActBullet_SpurTail(gBul[i], 2);
                    continue block47;
                }
                case 42: {
                    Bullet.ActBullet_SpurTail(gBul[i], 3);
                    continue block47;
                }
                case 43: {
                    Bullet.ActBullet_Nemesis(gBul[i], 1);
                    continue block47;
                }
                case 44: {
                    Bullet.ActBullet_EnemyClear(gBul[i]);
                    continue block47;
                }
                case 45: {
                    Bullet.ActBullet_Star(gBul[i]);
                }
            }
        }
    }

    public static boolean IsActiveSomeBullet() {
        for (int i = 0; i < gBul.length; ++i) {
            if ((Bullet.gBul[i].cond & 0x80) == 0) continue;
            switch (Bullet.gBul[i].code_bullet) {
                case 13: 
                case 14: 
                case 15: 
                case 16: 
                case 17: 
                case 18: 
                case 23: 
                case 25: 
                case 26: 
                case 27: 
                case 28: 
                case 29: 
                case 30: 
                case 31: 
                case 32: 
                case 33: {
                    return true;
                }
            }
        }
        return false;
    }

    static {
        for (int i = 0; i < gBul.length; ++i) {
            Bullet.gBul[i] = new BULLET();
        }
        Frontia1_rcLeft = new RECT[]{new RECT(136, 80, 152, 80), new RECT(120, 80, 136, 96), new RECT(136, 64, 152, 80), new RECT(120, 64, 136, 80)};
        Frontia1_rcRight = new RECT[]{new RECT(120, 64, 136, 80), new RECT(136, 64, 152, 80), new RECT(120, 80, 136, 96), new RECT(136, 80, 152, 80)};
        Frontia2_rect = new RECT[]{new RECT(192, 16, 208, 32), new RECT(208, 16, 224, 32), new RECT(224, 16, 240, 32)};
        Frontia2_inc = '\u0000';
        PoleStar_rect1 = new RECT[]{new RECT(128, 32, 144, 48), new RECT(144, 32, 160, 48)};
        PoleStar_rect2 = new RECT[]{new RECT(160, 32, 176, 48), new RECT(176, 32, 192, 48)};
        PoleStar_rect3 = new RECT[]{new RECT(128, 48, 144, 64), new RECT(144, 48, 160, 64)};
        FireBall_rect_left1 = new RECT[]{new RECT(128, 0, 144, 16), new RECT(144, 0, 160, 16), new RECT(160, 0, 176, 16), new RECT(176, 0, 192, 16)};
        FireBall_rect_right1 = new RECT[]{new RECT(128, 16, 144, 32), new RECT(144, 16, 160, 32), new RECT(160, 16, 176, 32), new RECT(176, 16, 192, 32)};
        FireBall_rect_left2 = new RECT[]{new RECT(192, 16, 208, 32), new RECT(208, 16, 224, 32), new RECT(224, 16, 240, 32)};
        FireBall_rect_right2 = new RECT[]{new RECT(224, 16, 240, 32), new RECT(208, 16, 224, 32), new RECT(192, 16, 208, 32)};
        MachineGun_rect1 = new RECT[]{new RECT(64, 0, 80, 16), new RECT(80, 0, 96, 16), new RECT(96, 0, 112, 16), new RECT(112, 0, 128, 16)};
        MachineGun_rect2 = new RECT[]{new RECT(64, 16, 80, 32), new RECT(80, 16, 96, 32), new RECT(96, 16, 112, 32), new RECT(112, 16, 128, 32)};
        MachineGun_rect3 = new RECT[]{new RECT(64, 32, 80, 48), new RECT(80, 32, 96, 48), new RECT(96, 32, 112, 48), new RECT(112, 32, 128, 48)};
        Missile_rect1 = new RECT[]{new RECT(0, 0, 16, 16), new RECT(16, 0, 32, 16), new RECT(32, 0, 48, 16), new RECT(48, 0, 64, 16)};
        Missile_rect2 = new RECT[]{new RECT(0, 16, 16, 32), new RECT(16, 16, 32, 32), new RECT(32, 16, 48, 32), new RECT(48, 16, 64, 32)};
        Missile_rect3 = new RECT[]{new RECT(0, 32, 16, 48), new RECT(16, 32, 32, 48), new RECT(32, 32, 48, 48), new RECT(48, 32, 64, 48)};
        Missile_inc = 0;
        Bubblin1_rect = new RECT[]{new RECT(192, 0, 200, 8), new RECT(200, 0, 208, 8), new RECT(208, 0, 216, 8), new RECT(216, 0, 224, 8)};
        Bubblin2_rect = new RECT[]{new RECT(192, 8, 200, 16), new RECT(200, 8, 208, 16), new RECT(208, 8, 216, 16), new RECT(216, 8, 224, 16)};
        Bubblin3_rect = new RECT[]{new RECT(240, 16, 248, 24), new RECT(248, 16, 256, 24), new RECT(240, 24, 248, 32), new RECT(248, 24, 256, 32)};
        Spine_rcLeft = new RECT[]{new RECT(224, 0, 232, 8), new RECT(232, 0, 240, 8)};
        Spine_rcRight = new RECT[]{new RECT(224, 0, 232, 8), new RECT(232, 0, 240, 8)};
        Spine_rcDown = new RECT[]{new RECT(224, 8, 232, 16), new RECT(232, 8, 240, 16)};
        Sword1_rcLeft = new RECT[]{new RECT(0, 48, 16, 64), new RECT(16, 48, 32, 64), new RECT(32, 48, 48, 64), new RECT(48, 48, 64, 64)};
        Sword1_rcRight = new RECT[]{new RECT(64, 48, 80, 64), new RECT(80, 48, 96, 64), new RECT(96, 48, 112, 64), new RECT(112, 48, 128, 64)};
        Sword2_rcLeft = new RECT[]{new RECT(160, 48, 184, 72), new RECT(184, 48, 208, 72), new RECT(208, 48, 232, 72), new RECT(232, 48, 256, 72)};
        Sword2_rcRight = new RECT[]{new RECT(160, 72, 184, 96), new RECT(184, 72, 208, 96), new RECT(208, 72, 232, 96), new RECT(232, 72, 256, 96)};
        Sword3_rcLeft = new RECT[]{new RECT(272, 0, 296, 24), new RECT(296, 0, 320, 24)};
        Sword3_rcUp = new RECT[]{new RECT(272, 48, 296, 72), new RECT(296, 0, 320, 24)};
        Sword3_rcRight = new RECT[]{new RECT(272, 24, 296, 48), new RECT(296, 24, 320, 48)};
        Sword3_rcDown = new RECT[]{new RECT(296, 48, 320, 72), new RECT(296, 24, 320, 48)};
        Edge_rcLeft = new RECT[]{new RECT(0, 64, 24, 88), new RECT(24, 64, 48, 88), new RECT(48, 64, 72, 88), new RECT(72, 64, 96, 88), new RECT(96, 64, 120, 88)};
        Edge_rcRight = new RECT[]{new RECT(0, 88, 24, 112), new RECT(24, 88, 48, 112), new RECT(48, 88, 72, 112), new RECT(72, 88, 96, 112), new RECT(96, 88, 120, 112)};
        Drop_rc = new RECT(0, 0, 0, 0);
        SuperMissile_rect1 = new RECT[]{new RECT(120, 96, 136, 112), new RECT(136, 96, 152, 112), new RECT(152, 96, 168, 112), new RECT(168, 96, 184, 112)};
        SuperMissile_rect2 = new RECT[]{new RECT(184, 96, 200, 112), new RECT(200, 96, 216, 112), new RECT(216, 96, 232, 112), new RECT(232, 96, 248, 112)};
        SuperMissile_inc = '\u0000';
        Nemesis_rcL = new RECT[]{new RECT(0, 112, 32, 128), new RECT(0, 128, 32, 144)};
        Nemesis_rcU = new RECT[]{new RECT(32, 112, 48, 144), new RECT(48, 112, 64, 144)};
        Nemesis_rcR = new RECT[]{new RECT(64, 112, 96, 128), new RECT(64, 128, 96, 144)};
        Nemesis_rcD = new RECT[]{new RECT(96, 112, 112, 144), new RECT(112, 112, 128, 144)};
        Spur_rect1 = new RECT[]{new RECT(128, 32, 144, 48), new RECT(144, 32, 160, 48)};
        Spur_rect2 = new RECT[]{new RECT(160, 32, 176, 48), new RECT(176, 32, 192, 48)};
        Spur_rect3 = new RECT[]{new RECT(128, 48, 144, 64), new RECT(144, 48, 160, 64)};
        SpurTail_rc_h_lv1 = new RECT[]{new RECT(192, 32, 200, 40), new RECT(200, 32, 208, 40), new RECT(208, 32, 216, 40)};
        SpurTail_rc_v_lv1 = new RECT[]{new RECT(192, 40, 200, 48), new RECT(200, 40, 208, 48), new RECT(208, 40, 216, 48)};
        SpurTail_rc_h_lv2 = new RECT[]{new RECT(216, 32, 224, 40), new RECT(224, 32, 232, 40), new RECT(232, 32, 240, 40)};
        SpurTail_rc_v_lv2 = new RECT[]{new RECT(216, 40, 224, 48), new RECT(224, 40, 232, 48), new RECT(232, 40, 240, 48)};
        SpurTail_rc_h_lv3 = new RECT[]{new RECT(240, 32, 248, 40), new RECT(248, 32, 256, 40), new RECT(256, 32, 264, 40)};
        SpurTail_rc_v_lv3 = new RECT[]{new RECT(240, 32, 248, 40), new RECT(248, 32, 256, 40), new RECT(256, 32, 264, 40)};
    }

    public static class BULLET {
        public int flag;
        public int code_bullet;
        public int bbits;
        public int cond;
        public int x;
        public int y;
        public int xm;
        public int ym;
        public int tgt_x;
        public int tgt_y;
        public int act_no;
        public int act_wait;
        public int ani_wait;
        public int ani_no;
        public byte direct;
        public final RECT rect = new RECT();
        public int count1;
        public int count2;
        public int life_count;
        public int damage;
        public int life;
        public int enemyXL;
        public int enemyYL;
        public int blockXL;
        public int blockYL;
        public final NpChar.OTHER_RECT view = new NpChar.OTHER_RECT();

        public void clear() {
            this.flag = 0;
            this.code_bullet = 0;
            this.bbits = 0;
            this.cond = 0;
            this.x = 0;
            this.y = 0;
            this.xm = 0;
            this.ym = 0;
            this.tgt_x = 0;
            this.tgt_y = 0;
            this.act_no = 0;
            this.act_wait = 0;
            this.ani_wait = 0;
            this.ani_no = 0;
            this.direct = 0;
            this.rect.clear();
            this.count1 = 0;
            this.count2 = 0;
            this.life_count = 0;
            this.damage = 0;
            this.life = 0;
            this.enemyXL = 0;
            this.enemyYL = 0;
            this.blockXL = 0;
            this.blockYL = 0;
            this.view.clear();
        }
    }

    public static class BULLET_TABLE {
        public byte damage;
        public byte life;
        public int life_count;
        public int bbits;
        public int enemyXL;
        public int enemyYL;
        public int blockXL;
        public int blockYL;
        public final NpChar.OTHER_RECT view = new NpChar.OTHER_RECT();

        public BULLET_TABLE(int damage, int life, int life_count, int bbits, int enemyXL, int enemyYL, int blockXL, int blockYL, int view_front, int view_top, int view_back, int view_bottom) {
            this.damage = (byte)damage;
            this.life = (byte)life;
            this.life_count = life_count;
            this.bbits = bbits;
            this.enemyXL = enemyXL;
            this.enemyYL = enemyYL;
            this.blockXL = blockXL;
            this.blockYL = blockYL;
            this.view.front = (byte)view_front;
            this.view.top = (byte)view_top;
            this.view.back = (byte)view_back;
            this.view.bottom = (byte)view_bottom;
        }
    }
}
