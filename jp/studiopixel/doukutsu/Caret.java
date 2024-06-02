/*
 * Decompiled with CFR 0.152.
 */
package jp.studiopixel.doukutsu;

import jp.studiopixel.doukutsu.Draw;
import jp.studiopixel.doukutsu.Game;
import jp.studiopixel.doukutsu.RECT;
import jp.studiopixel.doukutsu.Triangle;

public class Caret {
    public static final int CARET_NULL = 0;
    public static final int CARET_BUBBLE = 1;
    public static final int CARET_PROJECTILE_DISSIPATION = 2;
    public static final int CARET_SHOOT = 3;
    public static final int CARET_SNAKE_AFTERIMAGE = 4;
    public static final int CARET_ZZZ = 5;
    public static final int CARET_SNAKE_AFTERIMAGE_DUPLICATE = 6;
    public static final int CARET_EXHAUST = 7;
    public static final int CARET_DROWNED_QUOTE = 8;
    public static final int CARET_QUESTION_MARK = 9;
    public static final int CARET_LEVEL_UP = 10;
    public static final int CARET_HURT_PARTICLES = 11;
    public static final int CARET_EXPLOSION = 12;
    public static final int CARET_TINY_PARTICLES = 13;
    public static final int CARET_UNKNOWN = 14;
    public static final int CARET_PROJECTILE_DISSIPATION_TINY = 15;
    public static final int CARET_EMPTY = 16;
    public static final int CARET_PUSH_JUMP_KEY = 17;
    public static final CARET[] gCrt = new CARET[64];
    public static final CARET_TABLE[] gCaretTable = new CARET_TABLE[]{new CARET_TABLE(0, 0), new CARET_TABLE(2048, 2048), new CARET_TABLE(4096, 4096), new CARET_TABLE(4096, 4096), new CARET_TABLE(4096, 4096), new CARET_TABLE(2048, 2048), new CARET_TABLE(4096, 4096), new CARET_TABLE(2048, 2048), new CARET_TABLE(4096, 4096), new CARET_TABLE(4096, 4096), new CARET_TABLE(14336, 4096), new CARET_TABLE(2048, 2048), new CARET_TABLE(8192, 8192), new CARET_TABLE(2048, 2048), new CARET_TABLE(10240, 10240), new CARET_TABLE(2048, 2048), new CARET_TABLE(10240, 0), new CARET_TABLE(26624, 0)};
    private static final RECT[] Caret01_rcLeft;
    private static final RECT[] Caret01_rcRight;
    private static final RECT[] Caret02_rect_left;
    private static final RECT[] Caret02_rect_right;
    private static final RECT[] Caret02_rect_up;
    private static final RECT[] Caret03_rect;
    private static final RECT[] Caret04_rect;
    private static final RECT[] Caret05_rect;
    private static final RECT[] Caret07_rcLeft;
    private static final RECT Caret08_rcLeft;
    private static final RECT Caret08_rcRight;
    private static final RECT Caret09_rcLeft;
    private static final RECT Caret09_rcRight;
    private static final RECT[] Caret10_rcLeft;
    private static final RECT[] Caret10_rcRight;
    private static final RECT[] Caret11_rcRight;
    private static final RECT[] Caret12_rcLeft;
    private static final RECT[] Caret13_rcLeft;
    private static final RECT[] Caret14_rcLeft;
    private static final RECT[] Caret15_rcLeft;
    private static final RECT[] Caret16_rcLeft;
    private static final RECT[] Caret17_rcLeft;
    public static final CaretFunction[] gpCaretFuncTbl;

    public static void InitCaret() {
        for (int i = 0; i < gCrt.length; ++i) {
            gCrt[i].clear();
        }
    }

    public static void ActCaret00(CARET crt) {
    }

    public static void ActCaret01(CARET crt) {
        if (crt.act_no == 0) {
            crt.act_no = 1;
            crt.xm = Game.Random(-1024, 1024);
            crt.ym = Game.Random(-1024, 0);
        }
        crt.ym += 64;
        crt.x += crt.xm;
        crt.y += crt.ym;
        if (++crt.ani_wait > 5) {
            crt.ani_wait = 0;
            if (++crt.ani_no > 3) {
                crt.cond = 0;
                return;
            }
        }
        if (crt.direct == 0) {
            crt.rect.copyFrom(Caret01_rcLeft[crt.ani_no]);
        } else {
            crt.rect.copyFrom(Caret01_rcRight[crt.ani_no]);
        }
    }

    public static void ActCaret02(CARET crt) {
        switch (crt.direct) {
            case 0: {
                crt.ym -= 16;
                crt.y += crt.ym;
                if (++crt.ani_wait > 5) {
                    crt.ani_wait = 0;
                    ++crt.ani_no;
                }
                if (crt.ani_no > 3) {
                    crt.cond = 0;
                    return;
                }
                crt.rect.copyFrom(Caret02_rect_left[crt.ani_no]);
                break;
            }
            case 2: {
                if (++crt.ani_wait > 2) {
                    crt.ani_wait = 0;
                    ++crt.ani_no;
                }
                if (crt.ani_no > 3) {
                    crt.cond = 0;
                    return;
                }
                crt.rect.copyFrom(Caret02_rect_right[crt.ani_no]);
                break;
            }
            case 1: {
                crt.rect.copyFrom(Caret02_rect_up[++crt.ani_wait / 2 % 3]);
                if (crt.ani_wait <= 24) break;
                crt.cond = 0;
            }
        }
    }

    public static void ActCaret03(CARET crt) {
        if (++crt.ani_wait > 2) {
            crt.ani_wait = 0;
            if (++crt.ani_no > 3) {
                crt.cond = 0;
                return;
            }
        }
        crt.rect.copyFrom(Caret03_rect[crt.ani_no]);
    }

    public static void ActCaret04(CARET crt) {
        if (++crt.ani_wait > 1) {
            crt.ani_wait = 0;
            if (++crt.ani_no > 2) {
                crt.cond = 0;
                return;
            }
        }
        crt.rect.copyFrom(Caret04_rect[crt.direct * 3 + crt.ani_no]);
    }

    public static void ActCaret05(CARET crt) {
        if (++crt.ani_wait > 4) {
            crt.ani_wait = 0;
            ++crt.ani_no;
        }
        if (crt.ani_no > 6) {
            crt.cond = 0;
            return;
        }
        crt.x += 128;
        crt.y -= 128;
        crt.rect.copyFrom(Caret05_rect[crt.ani_no]);
    }

    public static void ActCaret07(CARET crt) {
        if (++crt.ani_wait > 1) {
            crt.ani_wait = 0;
            if (++crt.ani_no > 6) {
                crt.cond = 0;
                return;
            }
        }
        crt.rect.copyFrom(Caret07_rcLeft[crt.ani_no]);
        switch (crt.direct) {
            case 0: {
                crt.x -= 1024;
                break;
            }
            case 1: {
                crt.y -= 1024;
                break;
            }
            case 2: {
                crt.x += 1024;
                break;
            }
            case 3: {
                crt.y += 1024;
            }
        }
    }

    public static void ActCaret08(CARET crt) {
        if (crt.direct == 0) {
            crt.rect.copyFrom(Caret08_rcLeft);
        } else {
            crt.rect.copyFrom(Caret08_rcRight);
        }
    }

    public static void ActCaret09(CARET crt) {
        if (++crt.ani_wait < 5) {
            crt.y -= 2048;
        }
        if (crt.ani_wait == 32) {
            crt.cond = 0;
        }
        if (crt.direct == 0) {
            crt.rect.copyFrom(Caret09_rcLeft);
        } else {
            crt.rect.copyFrom(Caret09_rcRight);
        }
    }

    public static void ActCaret10(CARET crt) {
        ++crt.ani_wait;
        if (crt.direct == 0) {
            if (crt.ani_wait < 20) {
                crt.y -= 1024;
            }
            if (crt.ani_wait == 80) {
                crt.cond = 0;
            }
        } else {
            if (crt.ani_wait < 20) {
                crt.y -= 512;
            }
            if (crt.ani_wait == 80) {
                crt.cond = 0;
            }
        }
        if (crt.direct == 0) {
            crt.rect.copyFrom(Caret10_rcLeft[crt.ani_wait / 2 % 2]);
        } else {
            crt.rect.copyFrom(Caret10_rcRight[crt.ani_wait / 2 % 2]);
        }
    }

    public static void ActCaret11(CARET crt) {
        if (crt.act_no == 0) {
            crt.act_no = 1;
            char deg = (char)Game.Random(0, 255);
            crt.xm = Triangle.GetCos(deg) * 2;
            crt.ym = Triangle.GetSin(deg) * 2;
        }
        crt.x += crt.xm;
        crt.y += crt.ym;
        if (++crt.ani_wait > 2) {
            crt.ani_wait = 0;
            if (++crt.ani_no > 6) {
                crt.cond = 0;
                return;
            }
        }
        crt.rect.copyFrom(Caret11_rcRight[crt.ani_no]);
    }

    public static void ActCaret12(CARET crt) {
        if (++crt.ani_wait > 2) {
            crt.ani_wait = 0;
            if (++crt.ani_no > 1) {
                crt.cond = 0;
                return;
            }
        }
        crt.rect.copyFrom(Caret12_rcLeft[crt.ani_no]);
    }

    public static void ActCaret13(CARET crt) {
        if (crt.act_no == 0) {
            crt.act_no = 1;
            switch (crt.direct) {
                case 0: {
                    crt.xm = Game.Random(-1536, 1536);
                    crt.ym = Game.Random(-512, 512);
                    break;
                }
                case 1: {
                    crt.ym = -512 * Game.Random(1, 3);
                }
            }
        }
        switch (crt.direct) {
            case 0: {
                crt.xm = crt.xm * 4 / 5;
                crt.ym = crt.ym * 4 / 5;
            }
        }
        crt.x += crt.xm;
        crt.y += crt.ym;
        if (++crt.ani_wait > 20) {
            crt.cond = 0;
        }
        crt.rect.copyFrom(Caret13_rcLeft[crt.ani_wait / 2 % 2]);
        if (crt.direct == 5) {
            crt.x -= 2048;
        }
    }

    public static void ActCaret14(CARET crt) {
        if (++crt.ani_wait > 1) {
            crt.ani_wait = 0;
            if (++crt.ani_no > 4) {
                crt.cond = 0;
                return;
            }
        }
        crt.rect.copyFrom(Caret14_rcLeft[crt.ani_no]);
    }

    public static void ActCaret15(CARET crt) {
        if (++crt.ani_wait > 2) {
            crt.ani_wait = 0;
            if (++crt.ani_no > 3) {
                crt.cond = 0;
                return;
            }
        }
        crt.rect.copyFrom(Caret15_rcLeft[crt.ani_no]);
    }

    public static void ActCaret16(CARET crt) {
        if (++crt.ani_wait < 10) {
            crt.y -= 1024;
        }
        if (crt.ani_wait == 40) {
            crt.cond = 0;
        }
        crt.rect.copyFrom(Caret16_rcLeft[crt.ani_wait / 2 % 2]);
    }

    public static void ActCaret17(CARET crt) {
        if (++crt.ani_wait >= 40) {
            crt.ani_wait = 0;
        }
        crt.rect.copyFrom(Caret17_rcLeft[crt.ani_wait < 30 ? 0 : 1]);
    }

    public static void ActCaret() {
        for (int i = 0; i < gCrt.length; ++i) {
            if ((Caret.gCrt[i].cond & 0x80) == 0) continue;
            int code = Caret.gCrt[i].code;
            gpCaretFuncTbl[code].act(gCrt[i]);
        }
    }

    public static void PutCaret(int fx, int fy) {
        for (int i = 0; i < gCrt.length; ++i) {
            if ((Caret.gCrt[i].cond & 0x80) == 0) continue;
            Draw.PutBitmap3(Draw.grcGame, (Caret.gCrt[i].x - Caret.gCrt[i].view_left) / 512 - fx / 512, (Caret.gCrt[i].y - Caret.gCrt[i].view_top) / 512 - fy / 512, Caret.gCrt[i].rect, 19);
        }
    }

    public static void SetCaret(int x, int y, int code, int dir) {
        int c;
        for (c = 0; c < gCrt.length && Caret.gCrt[c].cond != 0; ++c) {
        }
        if (c == gCrt.length) {
            return;
        }
        gCrt[c].clear();
        Caret.gCrt[c].cond = 128;
        Caret.gCrt[c].code = code;
        Caret.gCrt[c].x = x;
        Caret.gCrt[c].y = y;
        Caret.gCrt[c].view_left = Caret.gCaretTable[code].view_left;
        Caret.gCrt[c].view_top = Caret.gCaretTable[code].view_top;
        Caret.gCrt[c].direct = dir;
    }

    static {
        for (int i = 0; i < gCrt.length; ++i) {
            Caret.gCrt[i] = new CARET();
        }
        Caret01_rcLeft = new RECT[]{new RECT(0, 64, 8, 72), new RECT(8, 64, 16, 72), new RECT(16, 64, 24, 72), new RECT(24, 64, 32, 72)};
        Caret01_rcRight = new RECT[]{new RECT(64, 24, 72, 32), new RECT(72, 24, 80, 32), new RECT(80, 24, 88, 32), new RECT(88, 24, 96, 32)};
        Caret02_rect_left = new RECT[]{new RECT(0, 32, 16, 48), new RECT(16, 32, 32, 48), new RECT(32, 32, 48, 48), new RECT(48, 32, 64, 48)};
        Caret02_rect_right = new RECT[]{new RECT(176, 0, 192, 16), new RECT(192, 0, 208, 16), new RECT(208, 0, 224, 16), new RECT(224, 0, 240, 16)};
        Caret02_rect_up = new RECT[]{new RECT(0, 32, 16, 48), new RECT(32, 32, 48, 48), new RECT(16, 32, 32, 48)};
        Caret03_rect = new RECT[]{new RECT(0, 48, 16, 64), new RECT(16, 48, 32, 64), new RECT(32, 48, 48, 64), new RECT(48, 48, 64, 64)};
        Caret04_rect = new RECT[]{new RECT(64, 32, 80, 48), new RECT(80, 32, 96, 48), new RECT(96, 32, 112, 48), new RECT(64, 48, 80, 64), new RECT(80, 48, 96, 64), new RECT(96, 48, 112, 64), new RECT(64, 64, 80, 80), new RECT(80, 64, 96, 80), new RECT(96, 64, 112, 80)};
        Caret05_rect = new RECT[]{new RECT(32, 64, 40, 72), new RECT(32, 72, 40, 80), new RECT(40, 64, 48, 72), new RECT(40, 72, 48, 80), new RECT(40, 64, 48, 72), new RECT(40, 72, 48, 80), new RECT(40, 64, 48, 72)};
        Caret07_rcLeft = new RECT[]{new RECT(56, 0, 64, 8), new RECT(64, 0, 72, 8), new RECT(72, 0, 80, 8), new RECT(80, 0, 88, 8), new RECT(88, 0, 96, 8), new RECT(96, 0, 104, 8), new RECT(104, 0, 112, 8)};
        Caret08_rcLeft = new RECT(16, 80, 32, 96);
        Caret08_rcRight = new RECT(32, 80, 48, 96);
        Caret09_rcLeft = new RECT(0, 80, 16, 96);
        Caret09_rcRight = new RECT(48, 64, 64, 80);
        Caret10_rcLeft = new RECT[]{new RECT(0, 0, 56, 16), new RECT(0, 16, 56, 32)};
        Caret10_rcRight = new RECT[]{new RECT(0, 96, 56, 112), new RECT(0, 112, 56, 128)};
        Caret11_rcRight = new RECT[]{new RECT(56, 8, 64, 16), new RECT(64, 8, 72, 16), new RECT(72, 8, 80, 16), new RECT(80, 8, 88, 16), new RECT(88, 8, 96, 16), new RECT(96, 8, 104, 16), new RECT(104, 8, 112, 16)};
        Caret12_rcLeft = new RECT[]{new RECT(112, 0, 144, 32), new RECT(144, 0, 176, 32)};
        Caret13_rcLeft = new RECT[]{new RECT(56, 24, 64, 32), new RECT(0, 0, 0, 0)};
        Caret14_rcLeft = new RECT[]{new RECT(0, 96, 40, 136), new RECT(40, 96, 80, 136), new RECT(80, 96, 120, 136), new RECT(120, 96, 160, 136), new RECT(160, 96, 200, 136)};
        Caret15_rcLeft = new RECT[]{new RECT(0, 72, 8, 80), new RECT(8, 72, 16, 80), new RECT(16, 72, 24, 80), new RECT(24, 72, 32, 80)};
        Caret16_rcLeft = new RECT[]{new RECT(104, 96, 144, 104), new RECT(104, 104, 144, 112)};
        Caret17_rcLeft = new RECT[]{new RECT(0, 144, 144, 152), new RECT(0, 0, 0, 0)};
        gpCaretFuncTbl = new CaretFunction[]{Caret::ActCaret00, Caret::ActCaret01, Caret::ActCaret02, Caret::ActCaret03, Caret::ActCaret04, Caret::ActCaret05, Caret::ActCaret04, Caret::ActCaret07, Caret::ActCaret08, Caret::ActCaret09, Caret::ActCaret10, Caret::ActCaret11, Caret::ActCaret12, Caret::ActCaret13, Caret::ActCaret14, Caret::ActCaret15, Caret::ActCaret16, Caret::ActCaret17};
    }

    public static class CARET {
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
        final RECT rect = new RECT();

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

    public static interface CaretFunction {
        public void act(CARET var1);
    }

    public static class CARET_TABLE {
        int view_left;
        int view_top;

        public CARET_TABLE(int view_left, int view_top) {
            this.view_left = view_left;
            this.view_top = view_top;
        }
    }
}
