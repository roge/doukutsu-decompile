/*
 * Decompiled with CFR 0.152.
 */
package jp.studiopixel.doukutsu;

import jp.studiopixel.doukutsu.Draw;
import jp.studiopixel.doukutsu.RECT;

public class Fade {
    public static final FADE gFade = new FADE();
    public static int mask_color = 0;

    public static void InitFade() {
        gFade.clear();
        mask_color = 32;
    }

    public static void SetFadeMask() {
        Fade.gFade.bMask = true;
    }

    public static void ClearFade() {
        Fade.gFade.bMask = false;
        Fade.gFade.mode = 0;
    }

    public static void StartFadeOut(byte dir) {
        Fade.gFade.mode = 2;
        Fade.gFade.count = 0;
        Fade.gFade.dir = dir;
        Fade.gFade.bMask = false;
        for (int y = 0; y < 15; ++y) {
            for (int x = 0; x < 20; ++x) {
                Fade.gFade.ani_no[y][x] = 0;
                Fade.gFade.flag[y][x] = 0;
            }
        }
    }

    public static void StartFadeIn(byte dir) {
        Fade.gFade.mode = 1;
        Fade.gFade.count = 0;
        Fade.gFade.dir = dir;
        Fade.gFade.bMask = true;
        for (int y = 0; y < 15; ++y) {
            for (int x = 0; x < 20; ++x) {
                Fade.gFade.ani_no[y][x] = 15;
                Fade.gFade.flag[y][x] = 0;
            }
        }
    }

    public static void ProcFade() {
        switch (Fade.gFade.mode) {
            case 2: {
                int x;
                int y;
                switch (Fade.gFade.dir) {
                    case 0: {
                        for (y = 0; y < 15; ++y) {
                            for (x = 0; x < 20; ++x) {
                                if (19 - Fade.gFade.count != x) continue;
                                Fade.gFade.flag[y][x] = 1;
                            }
                        }
                        break;
                    }
                    case 2: {
                        for (y = 0; y < 15; ++y) {
                            for (x = 0; x < 20; ++x) {
                                if (Fade.gFade.count != x) continue;
                                Fade.gFade.flag[y][x] = 1;
                            }
                        }
                        break;
                    }
                    case 1: {
                        for (y = 0; y < 15; ++y) {
                            for (x = 0; x < 20; ++x) {
                                if (14 - Fade.gFade.count != y) continue;
                                Fade.gFade.flag[y][x] = 1;
                            }
                        }
                        break;
                    }
                    case 3: {
                        for (y = 0; y < 15; ++y) {
                            for (x = 0; x < 20; ++x) {
                                if (Fade.gFade.count != y) continue;
                                Fade.gFade.flag[y][x] = 1;
                            }
                        }
                        break;
                    }
                    case 4: {
                        for (y = 0; y < 7; ++y) {
                            for (x = 0; x < 10; ++x) {
                                if (Fade.gFade.count != x + y) continue;
                                Fade.gFade.flag[y][x] = 1;
                            }
                        }
                        for (y = 0; y < 7; ++y) {
                            for (x = 10; x < 20; ++x) {
                                if (Fade.gFade.count != y + (19 - x)) continue;
                                Fade.gFade.flag[y][x] = 1;
                            }
                        }
                        for (y = 7; y < 15; ++y) {
                            for (x = 0; x < 10; ++x) {
                                if (Fade.gFade.count != x + (14 - y)) continue;
                                Fade.gFade.flag[y][x] = 1;
                            }
                        }
                        for (y = 7; y < 15; ++y) {
                            for (x = 10; x < 20; ++x) {
                                if (Fade.gFade.count != 19 - x + (14 - y)) continue;
                                Fade.gFade.flag[y][x] = 1;
                            }
                        }
                        break;
                    }
                }
                for (y = 0; y < 15; ++y) {
                    for (x = 0; x < 20; ++x) {
                        if (Fade.gFade.ani_no[y][x] >= 15 || Fade.gFade.flag[y][x] == 0) continue;
                        byte[] byArray = Fade.gFade.ani_no[y];
                        int n = x;
                        byArray[n] = (byte)(byArray[n] + 1);
                    }
                }
                if (++Fade.gFade.count <= Math.max(20, 15) + 16) break;
                Fade.gFade.bMask = true;
                Fade.gFade.mode = 0;
                break;
            }
            case 1: {
                int x;
                int y;
                Fade.gFade.bMask = false;
                switch (Fade.gFade.dir) {
                    case 0: {
                        for (y = 0; y < 15; ++y) {
                            for (x = 0; x < 20; ++x) {
                                if (19 - Fade.gFade.count != x) continue;
                                Fade.gFade.flag[y][x] = 1;
                            }
                        }
                        break;
                    }
                    case 2: {
                        for (y = 0; y < 15; ++y) {
                            for (x = 0; x < 20; ++x) {
                                if (Fade.gFade.count != x) continue;
                                Fade.gFade.flag[y][x] = 1;
                            }
                        }
                        break;
                    }
                    case 1: {
                        for (y = 0; y < 15; ++y) {
                            for (x = 0; x < 20; ++x) {
                                if (14 - Fade.gFade.count != y) continue;
                                Fade.gFade.flag[y][x] = 1;
                            }
                        }
                        break;
                    }
                    case 3: {
                        for (y = 0; y < 15; ++y) {
                            for (x = 0; x < 20; ++x) {
                                if (Fade.gFade.count != y) continue;
                                Fade.gFade.flag[y][x] = 1;
                            }
                        }
                        break;
                    }
                    case 4: {
                        for (y = 0; y < 7; ++y) {
                            for (x = 0; x < 10; ++x) {
                                if (19 - Fade.gFade.count != x + y) continue;
                                Fade.gFade.flag[y][x] = 1;
                            }
                        }
                        for (y = 0; y < 7; ++y) {
                            for (x = 10; x < 20; ++x) {
                                if (19 - Fade.gFade.count != y + (19 - x)) continue;
                                Fade.gFade.flag[y][x] = 1;
                            }
                        }
                        for (y = 7; y < 15; ++y) {
                            for (x = 0; x < 10; ++x) {
                                if (19 - Fade.gFade.count != x + (14 - y)) continue;
                                Fade.gFade.flag[y][x] = 1;
                            }
                        }
                        for (y = 7; y < 15; ++y) {
                            for (x = 10; x < 20; ++x) {
                                if (19 - Fade.gFade.count != 19 - x + (14 - y)) continue;
                                Fade.gFade.flag[y][x] = 1;
                            }
                        }
                        break;
                    }
                }
                for (y = 0; y < 15; ++y) {
                    for (x = 0; x < 20; ++x) {
                        if (Fade.gFade.ani_no[y][x] <= 0 || Fade.gFade.flag[y][x] == 0) continue;
                        byte[] byArray = Fade.gFade.ani_no[y];
                        int n = x;
                        byArray[n] = (byte)(byArray[n] - 1);
                    }
                }
                if (++Fade.gFade.count <= Math.max(20, 15) + 16) break;
                Fade.gFade.mode = 0;
            }
        }
    }

    public static void PutFade() {
        RECT rect = new RECT();
        rect.top = 0;
        rect.bottom = 16;
        if (Fade.gFade.bMask) {
            Draw.CortBox(Draw.grcGame, mask_color);
            return;
        }
        if (Fade.gFade.mode == 0) {
            return;
        }
        for (int y = 0; y < 15; ++y) {
            for (int x = 0; x < 20; ++x) {
                rect.left = Fade.gFade.ani_no[y][x] * 16;
                rect.right = rect.left + 16;
                Draw.PutBitmap3(Draw.grcGame, x * 16, y * 16, rect, 6);
            }
        }
    }

    public static boolean GetFadeActive() {
        return Fade.gFade.mode != 0;
    }

    public static class FADE {
        int mode;
        boolean bMask;
        int count;
        byte[][] ani_no = new byte[15][20];
        byte[][] flag = new byte[15][20];
        byte dir;

        public FADE() {
            this.clear();
        }

        public void clear() {
            this.mode = 0;
            this.bMask = false;
            this.count = 0;
            this.dir = 0;
            for (int i = 0; i < 15; ++i) {
                for (int j = 0; j < 20; ++j) {
                    this.ani_no[i][j] = 0;
                    this.flag[i][j] = 0;
                }
            }
        }
    }
}
