/*
 * Decompiled with CFR 0.152.
 */
package jp.studiopixel.doukutsu;

import jp.studiopixel.doukutsu.Bullet;
import jp.studiopixel.doukutsu.Caret;
import jp.studiopixel.doukutsu.Game;
import jp.studiopixel.doukutsu.Map;
import jp.studiopixel.doukutsu.NpChar;
import jp.studiopixel.doukutsu.Sound;

public class BulHit {
    private static final int[] offx = new int[]{0, 1, 0, 1};
    private static final int[] offy = new int[]{0, 0, 1, 1};
    private static final char[] atrb = new char[4];

    private static void Vanish(Bullet.BULLET bul) {
        if (bul.code_bullet != 37 && bul.code_bullet != 38 && bul.code_bullet != 39) {
            Sound.PlaySoundObject(28, 1);
        } else {
            Caret.SetCaret(bul.x, bul.y, 2, 1);
        }
        bul.cond = 0;
        Caret.SetCaret(bul.x, bul.y, 2, 2);
    }

    public static int JudgeHitBulletBlock(int x, int y, Bullet.BULLET bul) {
        int hit = 0;
        if (bul.x - bul.blockXL < (x * 16 + 8) * 512 && bul.x + bul.blockXL > (x * 16 - 8) * 512 && bul.y - bul.blockYL < (y * 16 + 8) * 512 && bul.y + bul.blockYL > (y * 16 - 8) * 512) {
            hit |= 0x200;
        }
        if (hit != 0 && (bul.bbits & 0x60) != 0 && Map.GetAttribute(x, y) == 'C') {
            if ((bul.bbits & 0x40) == 0) {
                bul.cond = 0;
            }
            Caret.SetCaret(bul.x, bul.y, 2, 0);
            Sound.PlaySoundObject(12, 1);
            for (int i = 0; i < 4; ++i) {
                NpChar.SetNpChar(4, x * 512 * 16, y * 512 * 16, Game.Random(-512, 512), Game.Random(-512, 512), 0, null, 256);
            }
            Map.ShiftMapParts(x, y);
        }
        return hit;
    }

    public static int JudgeHitBulletBlock2(int x, int y, char[] atrb, Bullet.BULLET bul) {
        boolean[] block = new boolean[4];
        int hit = 0;
        int ap = 0;
        if ((bul.bbits & 0x40) != 0) {
            for (int i = 0; i < 4; ++i) {
                block[i] = atrb[ap] == 'A' || atrb[ap] == 'a';
                ++ap;
            }
        } else {
            for (int i = 0; i < 4; ++i) {
                block[i] = atrb[ap] == 'A' || atrb[ap] == 'C' || atrb[ap] == 'a';
                ++ap;
            }
        }
        int workX = (x * 16 + 8) * 512;
        int workY = (y * 16 + 8) * 512;
        if (block[0] && block[2]) {
            if (bul.x - bul.blockXL < workX) {
                hit |= 1;
            }
        } else if (block[0] && !block[2]) {
            if (bul.x - bul.blockXL < workX && bul.y - bul.blockYL < workY - 1536) {
                hit |= 1;
            }
        } else if (!block[0] && block[2] && bul.x - bul.blockXL < workX && bul.y + bul.blockYL > workY + 1536) {
            hit |= 1;
        }
        if (block[1] && block[3]) {
            if (bul.x + bul.blockXL > workX) {
                hit |= 4;
            }
        } else if (block[1] && !block[3]) {
            if (bul.x + bul.blockXL > workX && bul.y - bul.blockYL < workY - 1536) {
                hit |= 4;
            }
        } else if (!block[1] && block[3] && bul.x + bul.blockXL > workX && bul.y + bul.blockYL > workY + 1536) {
            hit |= 4;
        }
        if (block[0] && block[1]) {
            if (bul.y - bul.blockYL < workY) {
                hit |= 2;
            }
        } else if (block[0] && !block[1]) {
            if (bul.y - bul.blockYL < workY && bul.x - bul.blockXL < workX - 1536) {
                hit |= 2;
            }
        } else if (!block[0] && block[1] && bul.y - bul.blockYL < workY && bul.x + bul.blockXL > workX + 1536) {
            hit |= 2;
        }
        if (block[2] && block[3]) {
            if (bul.y + bul.blockYL > workY) {
                hit |= 8;
            }
        } else if (block[2] && !block[3]) {
            if (bul.y + bul.blockYL > workY && bul.x - bul.blockXL < workX - 1536) {
                hit |= 8;
            }
        } else if (!block[2] && block[3] && bul.y + bul.blockYL > workY && bul.x + bul.blockXL > workX + 1536) {
            hit |= 8;
        }
        if ((bul.bbits & 8) != 0) {
            if ((hit & 1) != 0) {
                bul.x = workX + bul.blockXL;
            } else if ((hit & 4) != 0) {
                bul.x = workX - bul.blockXL;
            } else if ((hit & 2) != 0) {
                bul.y = workY + bul.blockYL;
            } else if ((hit & 8) != 0) {
                bul.y = workY - bul.blockYL;
            }
        } else if ((hit & 0xF) != 0) {
            BulHit.Vanish(bul);
        }
        return hit;
    }

    public static int JudgeHitBulletTriangleA(int x, int y, Bullet.BULLET bul) {
        int hit = 0;
        if (bul.x < (x * 16 + 8) * 512 && bul.x > (x * 16 - 8) * 512 && bul.y - 1024 < y * 16 * 512 - (bul.x - x * 16 * 512) / 2 + 2048 && bul.y + 1024 > (y * 16 - 8) * 512) {
            if ((bul.bbits & 8) != 0) {
                bul.y = y * 16 * 512 - (bul.x - x * 16 * 512) / 2 + 3072;
            } else {
                BulHit.Vanish(bul);
            }
            hit |= 0x82;
        }
        return hit;
    }

    public static int JudgeHitBulletTriangleB(int x, int y, Bullet.BULLET bul) {
        int hit = 0;
        if (bul.x < (x * 16 + 8) * 512 && bul.x > (x * 16 - 8) * 512 && bul.y - 1024 < y * 16 * 512 - (bul.x - x * 16 * 512) / 2 - 2048 && bul.y + 1024 > (y * 16 - 8) * 512) {
            if ((bul.bbits & 8) != 0) {
                bul.y = y * 16 * 512 - (bul.x - x * 16 * 512) / 2 - 1024;
            } else {
                BulHit.Vanish(bul);
            }
            hit |= 0x82;
        }
        return hit;
    }

    public static int JudgeHitBulletTriangleC(int x, int y, Bullet.BULLET bul) {
        int hit = 0;
        if (bul.x < (x * 16 + 8) * 512 && bul.x > (x * 16 - 8) * 512 && bul.y - 1024 < y * 16 * 512 + (bul.x - x * 16 * 512) / 2 - 2048 && bul.y + 1024 > (y * 16 - 8) * 512) {
            if ((bul.bbits & 8) != 0) {
                bul.y = y * 16 * 512 + (bul.x - x * 16 * 512) / 2 - 1024;
            } else {
                BulHit.Vanish(bul);
            }
            hit |= 0x42;
        }
        return hit;
    }

    public static int JudgeHitBulletTriangleD(int x, int y, Bullet.BULLET bul) {
        int hit = 0;
        if (bul.x < (x * 16 + 8) * 512 && bul.x > (x * 16 - 8) * 512 && bul.y - 1024 < y * 16 * 512 + (bul.x - x * 16 * 512) / 2 + 2048 && bul.y + 1024 > (y * 16 - 8) * 512) {
            if ((bul.bbits & 8) != 0) {
                bul.y = y * 16 * 512 + (bul.x - x * 16 * 512) / 2 + 3072;
            } else {
                BulHit.Vanish(bul);
            }
            hit |= 0x42;
        }
        return hit;
    }

    public static int JudgeHitBulletTriangleE(int x, int y, Bullet.BULLET bul) {
        int hit = 0;
        if (bul.x < (x * 16 + 8) * 512 && bul.x - 512 > (x * 16 - 8) * 512 && bul.y + 1024 > y * 16 * 512 + (bul.x - x * 16 * 512) / 2 - 2048 && bul.y - 1024 < (y * 16 + 8) * 512) {
            if ((bul.bbits & 8) != 0) {
                bul.y = y * 16 * 512 + (bul.x - x * 16 * 512) / 2 - 3072;
            } else {
                BulHit.Vanish(bul);
            }
            hit |= 0x28;
        }
        return hit;
    }

    public static int JudgeHitBulletTriangleF(int x, int y, Bullet.BULLET bul) {
        int hit = 0;
        if (bul.x < (x * 16 + 8) * 512 && bul.x > (x * 16 - 8) * 512 && bul.y + 1024 > y * 16 * 512 + (bul.x - x * 16 * 512) / 2 + 2048 && bul.y - 1024 < (y * 16 + 8) * 512) {
            if ((bul.bbits & 8) != 0) {
                bul.y = y * 16 * 512 + (bul.x - x * 16 * 512) / 2 + 1024;
            } else {
                BulHit.Vanish(bul);
            }
            hit |= 0x28;
        }
        return hit;
    }

    public static int JudgeHitBulletTriangleG(int x, int y, Bullet.BULLET bul) {
        int hit = 0;
        if (bul.x < (x * 16 + 8) * 512 && bul.x > (x * 16 - 8) * 512 && bul.y + 1024 > y * 16 * 512 - (bul.x - x * 16 * 512) / 2 + 2048 && bul.y - 1024 < (y * 16 + 8) * 512) {
            if ((bul.bbits & 8) != 0) {
                bul.y = y * 16 * 512 - (bul.x - x * 16 * 512) / 2 + 1024;
            } else {
                BulHit.Vanish(bul);
            }
            hit |= 0x18;
        }
        return hit;
    }

    public static int JudgeHitBulletTriangleH(int x, int y, Bullet.BULLET bul) {
        int hit = 0;
        if (bul.x < (x * 16 + 8) * 512 && bul.x > (x * 16 - 8) * 512 && bul.y + 1024 > y * 16 * 512 - (bul.x - x * 16 * 512) / 2 - 2048 && bul.y - 1024 < (y * 16 + 8) * 512) {
            if ((bul.bbits & 8) != 0) {
                bul.y = y * 16 * 512 - (bul.x - x * 16 * 512) / 2 - 3072;
            } else {
                BulHit.Vanish(bul);
            }
            hit |= 0x18;
        }
        return hit;
    }

    public static void HitBulletMap() {
        for (int i = 0; i < Bullet.gBul.length; ++i) {
            if ((Bullet.gBul[i].cond & 0x80) == 0) continue;
            int x = Bullet.gBul[i].x / 16 / 512;
            int y = Bullet.gBul[i].y / 16 / 512;
            BulHit.atrb[0] = Map.GetAttribute(x, y);
            BulHit.atrb[1] = Map.GetAttribute(x + 1, y);
            BulHit.atrb[2] = Map.GetAttribute(x, y + 1);
            BulHit.atrb[3] = Map.GetAttribute(x + 1, y + 1);
            Bullet.gBul[i].flag = 0;
            if ((Bullet.gBul[i].bbits & 4) != 0) continue;
            block12: for (int j = 0; j < 4; ++j) {
                if ((Bullet.gBul[i].cond & 0x80) == 0) continue;
                switch (atrb[j]) {
                    case 'A': 
                    case 'C': 
                    case 'D': 
                    case 'a': 
                    case 'd': {
                        Bullet.gBul[i].flag |= BulHit.JudgeHitBulletBlock(x + offx[j], y + offy[j], Bullet.gBul[i]);
                        continue block12;
                    }
                    case 'P': 
                    case 'p': {
                        Bullet.gBul[i].flag |= BulHit.JudgeHitBulletTriangleA(x + offx[j], y + offy[j], Bullet.gBul[i]);
                        continue block12;
                    }
                    case 'Q': 
                    case 'q': {
                        Bullet.gBul[i].flag |= BulHit.JudgeHitBulletTriangleB(x + offx[j], y + offy[j], Bullet.gBul[i]);
                        continue block12;
                    }
                    case 'R': 
                    case 'r': {
                        Bullet.gBul[i].flag |= BulHit.JudgeHitBulletTriangleC(x + offx[j], y + offy[j], Bullet.gBul[i]);
                        continue block12;
                    }
                    case 'S': 
                    case 's': {
                        Bullet.gBul[i].flag |= BulHit.JudgeHitBulletTriangleD(x + offx[j], y + offy[j], Bullet.gBul[i]);
                        continue block12;
                    }
                    case 'T': 
                    case 't': {
                        Bullet.gBul[i].flag |= BulHit.JudgeHitBulletTriangleE(x + offx[j], y + offy[j], Bullet.gBul[i]);
                        continue block12;
                    }
                    case 'U': 
                    case 'u': {
                        Bullet.gBul[i].flag |= BulHit.JudgeHitBulletTriangleF(x + offx[j], y + offy[j], Bullet.gBul[i]);
                        continue block12;
                    }
                    case 'V': 
                    case 'v': {
                        Bullet.gBul[i].flag |= BulHit.JudgeHitBulletTriangleG(x + offx[j], y + offy[j], Bullet.gBul[i]);
                        continue block12;
                    }
                    case 'W': 
                    case 'w': {
                        Bullet.gBul[i].flag |= BulHit.JudgeHitBulletTriangleH(x + offx[j], y + offy[j], Bullet.gBul[i]);
                    }
                }
            }
            Bullet.gBul[i].flag |= BulHit.JudgeHitBulletBlock2(x, y, atrb, Bullet.gBul[i]);
        }
    }
}
