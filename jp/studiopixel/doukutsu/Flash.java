/*
 * Decompiled with CFR 0.152.
 */
package jp.studiopixel.doukutsu;

import jp.studiopixel.doukutsu.Draw;
import jp.studiopixel.doukutsu.RECT;

public class Flash {
    public static final int FLASH_MODE_EXPLOSION = 1;
    public static final int FLASH_MODE_FLASH = 2;
    private static final FLASH flash = new FLASH();
    public static int gFlashColor;

    public static void InitFlash() {
        gFlashColor = 0xFFFFFE;
    }

    public static void SetFlash(int x, int y, int mode) {
        Flash.flash.act_no = 0;
        Flash.flash.flag = true;
        Flash.flash.x = x;
        Flash.flash.y = y;
        Flash.flash.mode = mode;
        Flash.flash.cnt = 0;
        Flash.flash.width = 0;
    }

    public static void ActFlash_Explosion(int flx, int fly) {
        switch (Flash.flash.act_no) {
            case 0: {
                Flash.flash.cnt += 512;
                Flash.flash.width += Flash.flash.cnt;
                int left = (Flash.flash.x - flx - Flash.flash.width) / 512;
                int top = (Flash.flash.y - fly - Flash.flash.width) / 512;
                int right = (Flash.flash.x - flx + Flash.flash.width) / 512;
                int bottom = (Flash.flash.y - fly + Flash.flash.width) / 512;
                if (left < 0) {
                    left = 0;
                }
                if (top < 0) {
                    top = 0;
                }
                if (right > 320) {
                    right = 320;
                }
                if (bottom > 240) {
                    bottom = 240;
                }
                Flash.flash.rect1.left = left;
                Flash.flash.rect1.right = right;
                Flash.flash.rect1.top = 0;
                Flash.flash.rect1.bottom = 240;
                Flash.flash.rect2.left = 0;
                Flash.flash.rect2.right = 320;
                Flash.flash.rect2.top = top;
                Flash.flash.rect2.bottom = bottom;
                if (Flash.flash.width <= 655360) break;
                Flash.flash.act_no = 1;
                Flash.flash.cnt = 0;
                Flash.flash.width = 122880;
                break;
            }
            case 1: {
                int bottom;
                int top;
                Flash.flash.width -= Flash.flash.width / 8;
                if (Flash.flash.width / 256 == 0) {
                    Flash.flash.flag = false;
                }
                if ((top = (Flash.flash.y - fly - Flash.flash.width) / 512) < 0) {
                    top = 0;
                }
                if ((bottom = (Flash.flash.y - fly + Flash.flash.width) / 512) > 240) {
                    bottom = 240;
                }
                Flash.flash.rect1.left = 0;
                Flash.flash.rect1.right = 0;
                Flash.flash.rect1.top = 0;
                Flash.flash.rect1.bottom = 0;
                Flash.flash.rect2.top = top;
                Flash.flash.rect2.bottom = bottom;
                Flash.flash.rect2.left = 0;
                Flash.flash.rect2.right = 320;
            }
        }
    }

    public static void ActFlash_Flash() {
        ++Flash.flash.cnt;
        Flash.flash.rect1.left = 0;
        Flash.flash.rect1.right = 0;
        Flash.flash.rect1.top = 0;
        Flash.flash.rect1.bottom = 0;
        if (Flash.flash.cnt / 2 % 2 != 0) {
            Flash.flash.rect2.top = 0;
            Flash.flash.rect2.bottom = 240;
            Flash.flash.rect2.left = 0;
            Flash.flash.rect2.right = 320;
        } else {
            Flash.flash.rect2.left = 0;
            Flash.flash.rect2.right = 0;
            Flash.flash.rect2.top = 0;
            Flash.flash.rect2.bottom = 0;
        }
        if (Flash.flash.cnt > 20) {
            Flash.flash.flag = false;
        }
    }

    public static void ActFlash(int flx, int fly) {
        if (!Flash.flash.flag) {
            return;
        }
        switch (Flash.flash.mode) {
            case 1: {
                Flash.ActFlash_Explosion(flx, fly);
                break;
            }
            case 2: {
                Flash.ActFlash_Flash();
            }
        }
    }

    public static void PutFlash() {
        if (!Flash.flash.flag) {
            return;
        }
        Draw.CortBox(Flash.flash.rect1, gFlashColor);
        Draw.CortBox(Flash.flash.rect2, gFlashColor);
    }

    public static void ResetFlash() {
        Flash.flash.flag = false;
    }

    public static class FLASH {
        int mode;
        int act_no;
        boolean flag;
        int cnt;
        int width;
        int x;
        int y;
        RECT rect1 = new RECT();
        RECT rect2 = new RECT();
    }
}
