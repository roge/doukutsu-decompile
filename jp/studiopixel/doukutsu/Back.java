/*
 * Decompiled with CFR 0.152.
 */
package jp.studiopixel.doukutsu;

import jp.studiopixel.doukutsu.DataLoader;
import jp.studiopixel.doukutsu.Draw;
import jp.studiopixel.doukutsu.RECT;

public class Back {
    public static final int BACKGROUND_TYPE_STATIONARY = 0;
    public static final int BACKGROUND_TYPE_MOVE_DISTANT = 1;
    public static final int BACKGROUND_TYPE_MOVE_NEAR = 2;
    public static final int BACKGROUND_TYPE_WATER = 3;
    public static final int BACKGROUND_TYPE_BLACK = 4;
    public static final int BACKGROUND_TYPE_AUTOSCROLL = 5;
    public static final int BACKGROUND_TYPE_CLOUDS_WINDY = 6;
    public static final int BACKGROUND_TYPE_CLOUDS = 7;
    public static BACK gBack = new BACK();
    public static int gWaterY = 0;
    private static final RECT[] rcWater = new RECT[]{new RECT(0, 0, 32, 16), new RECT(0, 16, 32, 48)};

    public static boolean InitBack(String fName, int type) {
        try {
            DataLoader.DataFile file = DataLoader.load("/" + fName + ".pbm");
            if (file.readByte() != 66 || file.readByte() != 77) {
                return false;
            }
            file.cSeek(0, 18);
            Back.gBack.partsW = file.readInt();
            Back.gBack.partsH = file.readInt();
            Back.gBack.flag = true;
            if (!Draw.ReloadBitmap_File(fName, 28)) {
                return false;
            }
            Back.gBack.type = type;
            gWaterY = 0x1E0000;
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void ActBack() {
        switch (Back.gBack.type) {
            case 5: {
                Back.gBack.fx += 3072;
                break;
            }
            case 6: 
            case 7: {
                ++Back.gBack.fx;
                Back.gBack.fx %= 640;
            }
        }
    }

    public static void PutBack(int fx, int fy) {
        RECT rect = new RECT(0, 0, Back.gBack.partsW, Back.gBack.partsH);
        switch (Back.gBack.type) {
            case 0: {
                for (int y = 0; y < 240; y += Back.gBack.partsH) {
                    for (int x = 0; x < 320; x += Back.gBack.partsW) {
                        Draw.PutBitmap4(Draw.grcGame, x, y, rect, 28);
                    }
                }
                break;
            }
            case 1: {
                for (int y = -(fy / 2 / 512 % Back.gBack.partsH); y < 240; y += Back.gBack.partsH) {
                    for (int x = -(fx / 2 / 512 % Back.gBack.partsW); x < 320; x += Back.gBack.partsW) {
                        Draw.PutBitmap4(Draw.grcGame, x, y, rect, 28);
                    }
                }
                break;
            }
            case 2: {
                for (int y = -(fy / 512 % Back.gBack.partsH); y < 240; y += Back.gBack.partsH) {
                    for (int x = -(fx / 512 % Back.gBack.partsW); x < 320; x += Back.gBack.partsW) {
                        Draw.PutBitmap4(Draw.grcGame, x, y, rect, 28);
                    }
                }
                break;
            }
            case 5: {
                for (int y = -Back.gBack.partsH; y < 240; y += Back.gBack.partsH) {
                    for (int x = -(Back.gBack.fx / 512 % Back.gBack.partsW); x < 320; x += Back.gBack.partsW) {
                        Draw.PutBitmap4(Draw.grcGame, x, y, rect, 28);
                    }
                }
                break;
            }
            case 6: 
            case 7: {
                rect.top = 0;
                rect.bottom = 88;
                rect.left = 0;
                rect.right = 320;
                Draw.PutBitmap4(Draw.grcGame, 0, 0, rect, 28);
                rect.top = 88;
                rect.bottom = 123;
                rect.left = Back.gBack.fx / 2;
                rect.right = 320;
                Draw.PutBitmap4(Draw.grcGame, 0, 88, rect, 28);
                rect.left = 0;
                Draw.PutBitmap4(Draw.grcGame, 320 - Back.gBack.fx / 2 % 320, 88, rect, 28);
                rect.top = 123;
                rect.bottom = 146;
                rect.left = Back.gBack.fx % 320;
                rect.right = 320;
                Draw.PutBitmap4(Draw.grcGame, 0, 123, rect, 28);
                rect.left = 0;
                Draw.PutBitmap4(Draw.grcGame, 320 - Back.gBack.fx % 320, 123, rect, 28);
                rect.top = 146;
                rect.bottom = 176;
                rect.left = 2 * Back.gBack.fx % 320;
                rect.right = 320;
                Draw.PutBitmap4(Draw.grcGame, 0, 146, rect, 28);
                rect.left = 0;
                Draw.PutBitmap4(Draw.grcGame, 320 - Back.gBack.fx * 2 % 320, 146, rect, 28);
                rect.top = 176;
                rect.bottom = 240;
                rect.left = 4 * Back.gBack.fx % 320;
                rect.right = 320;
                Draw.PutBitmap4(Draw.grcGame, 0, 176, rect, 28);
                rect.left = 0;
                Draw.PutBitmap4(Draw.grcGame, 320 - Back.gBack.fx * 4 % 320, 176, rect, 28);
            }
        }
    }

    public static void PutFront(int fx, int fy) {
        block0 : switch (Back.gBack.type) {
            case 3: {
                int x_1 = fx / 16384;
                int x_2 = x_1 + 11;
                int y_1 = 0;
                int y_2 = y_1 + 32;
                for (int y = y_1; y < y_2; ++y) {
                    int ypos = y * 32 * 512 / 512 - fy / 512 + gWaterY / 512;
                    if (ypos < -32) continue;
                    if (ypos > 240) break block0;
                    for (int x = x_1; x < x_2; ++x) {
                        int xpos = x * 32 * 512 / 512 - fx / 512;
                        Draw.PutBitmap3(Draw.grcGame, xpos, ypos, rcWater[1], 28);
                        if (y != 0) continue;
                        Draw.PutBitmap3(Draw.grcGame, xpos, ypos, rcWater[0], 28);
                    }
                }
                break;
            }
        }
    }

    public static class BACK {
        boolean flag = false;
        int partsW = 0;
        int partsH = 0;
        int numX = 0;
        int numY = 0;
        int type = 0;
        int fx = 0;
    }
}
