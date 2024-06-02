/*
 * Decompiled with CFR 0.152.
 */
package jp.studiopixel.doukutsu;

import jp.studiopixel.doukutsu.Bullet;
import jp.studiopixel.doukutsu.Draw;
import jp.studiopixel.doukutsu.Game;
import jp.studiopixel.doukutsu.MyChar;
import jp.studiopixel.doukutsu.RECT;

public class Star {
    public static STAR[] star = new STAR[]{new STAR(), new STAR(), new STAR()};
    private static int a = 0;
    private static RECT[] rc = new RECT[]{new RECT(192, 0, 200, 8), new RECT(192, 8, 200, 16), new RECT(192, 16, 200, 24)};

    public static void InitStar() {
        star[0].clear();
        star[1].clear();
        star[2].clear();
        Star.star[0].x = MyChar.gMC.x;
        Star.star[0].y = MyChar.gMC.y;
        Star.star[1].x = MyChar.gMC.x;
        Star.star[1].y = MyChar.gMC.y;
        Star.star[2].x = MyChar.gMC.x;
        Star.star[2].y = MyChar.gMC.y;
        Star.star[0].xm = 1024;
        Star.star[0].ym = -512;
        Star.star[1].xm = -512;
        Star.star[1].ym = 1024;
        Star.star[2].xm = 512;
        Star.star[2].ym = 512;
    }

    public static void ActStar() {
        ++a;
        a %= 3;
        for (int i = 0; i < 3; ++i) {
            if (i != 0) {
                Star.star[i].xm = Star.star[i - 1].x < Star.star[i].x ? (Star.star[i].xm -= 128) : (Star.star[i].xm += 128);
                Star.star[i].ym = Star.star[i - 1].y < Star.star[i].y ? (Star.star[i].ym -= 170) : (Star.star[i].ym += 170);
            } else {
                Star.star[i].xm = MyChar.gMC.x < Star.star[i].x ? (Star.star[i].xm -= 128) : (Star.star[i].xm += 128);
                Star.star[i].ym = MyChar.gMC.y < Star.star[i].y ? (Star.star[i].ym -= 170) : (Star.star[i].ym += 170);
            }
            if (Star.star[i].xm > 2560) {
                Star.star[i].xm = 2560;
            }
            if (Star.star[i].xm < -2560) {
                Star.star[i].xm = -2560;
            }
            if (Star.star[i].ym > 2560) {
                Star.star[i].ym = 2560;
            }
            if (Star.star[i].ym < -2560) {
                Star.star[i].ym = -2560;
            }
            if (Star.star[i].xm > 2560) {
                Star.star[i].xm = 2560;
            }
            if (Star.star[i].xm < -2560) {
                Star.star[i].xm = -2560;
            }
            if (Star.star[i].ym > 2560) {
                Star.star[i].ym = 2560;
            }
            if (Star.star[i].ym < -2560) {
                Star.star[i].ym = -2560;
            }
            Star.star[i].x += Star.star[i].xm;
            Star.star[i].y += Star.star[i].ym;
            if (i >= MyChar.gMC.star || (MyChar.gMC.equip & 0x80) == 0 || (Game.g_GameFlags & 2) == 0 || a != i) continue;
            Bullet.SetBullet(45, Star.star[Star.a].x, Star.star[Star.a].y, 0);
        }
    }

    public static void PutStar(int fx, int fy) {
        if ((MyChar.gMC.cond & 2) != 0) {
            return;
        }
        if ((MyChar.gMC.equip & 0x80) == 0) {
            return;
        }
        for (int i = 0; i < 3; ++i) {
            if (i >= MyChar.gMC.star) continue;
            Draw.PutBitmap3(Draw.grcGame, Star.star[i].x / 512 - fx / 512 - 4, Star.star[i].y / 512 - fy / 512 - 4, rc[i], 16);
        }
    }

    public static class STAR {
        int cond;
        int code;
        int direct;
        int x;
        int y;
        int xm;
        int ym;
        int act_no;
        int act_wait;
        int ani_no;
        int ani_wait;
        int view_left;
        int view_top;
        RECT rect = new RECT();

        public void clear() {
            this.cond = 0;
            this.code = 0;
            this.direct = 0;
            this.x = 0;
            this.y = 0;
            this.xm = 0;
            this.ym = 0;
            this.act_no = 0;
            this.act_wait = 0;
            this.ani_no = 0;
            this.ani_wait = 0;
            this.view_left = 0;
            this.view_top = 0;
            this.rect.clear();
        }
    }
}
