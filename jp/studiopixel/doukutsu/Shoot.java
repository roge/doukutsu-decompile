/*
 * Decompiled with CFR 0.152.
 */
package jp.studiopixel.doukutsu;

import jp.studiopixel.doukutsu.ArmsItem;
import jp.studiopixel.doukutsu.Bullet;
import jp.studiopixel.doukutsu.Caret;
import jp.studiopixel.doukutsu.KeyControl;
import jp.studiopixel.doukutsu.MyChar;
import jp.studiopixel.doukutsu.MycParam;
import jp.studiopixel.doukutsu.Sound;

public class Shoot {
    private static int empty;
    private static int Machinegun1_wait;
    private static int Bubblin1_wait;
    private static int Bubblin2_wait;
    public static int spur_charge;
    private static boolean Spur_bMax;
    private static int ShootBullet_soft_rensha;

    public static void ShootBullet_Frontia1(int level) {
        int bul_no = 0;
        switch (level) {
            case 1: {
                bul_no = 1;
                break;
            }
            case 2: {
                bul_no = 2;
                break;
            }
            case 3: {
                bul_no = 3;
            }
        }
        if (Bullet.CountArmsBullet(1) > 3) {
            return;
        }
        if ((KeyControl.gKeyTrg & KeyControl.gKeyShot) != 0) {
            if (!ArmsItem.UseArmsEnergy(1)) {
                ArmsItem.ChangeToFirstArms();
            } else {
                if (MyChar.gMC.up) {
                    if (MyChar.gMC.direct == 0) {
                        Bullet.SetBullet(bul_no, MyChar.gMC.x - 1536, MyChar.gMC.y - 5120, 1);
                        Caret.SetCaret(MyChar.gMC.x - 1536, MyChar.gMC.y - 5120, 3, 0);
                    } else {
                        Bullet.SetBullet(bul_no, MyChar.gMC.x + 1536, MyChar.gMC.y - 5120, 1);
                        Caret.SetCaret(MyChar.gMC.x + 1536, MyChar.gMC.y - 5120, 3, 0);
                    }
                } else if (MyChar.gMC.down) {
                    if (MyChar.gMC.direct == 0) {
                        Bullet.SetBullet(bul_no, MyChar.gMC.x - 1536, MyChar.gMC.y + 5120, 3);
                        Caret.SetCaret(MyChar.gMC.x - 1536, MyChar.gMC.y + 5120, 3, 0);
                    } else {
                        Bullet.SetBullet(bul_no, MyChar.gMC.x + 1536, MyChar.gMC.y + 5120, 3);
                        Caret.SetCaret(MyChar.gMC.x + 1536, MyChar.gMC.y + 5120, 3, 0);
                    }
                } else if (MyChar.gMC.direct == 0) {
                    Bullet.SetBullet(bul_no, MyChar.gMC.x - 3072, MyChar.gMC.y + 1024, 0);
                    Caret.SetCaret(MyChar.gMC.x - 6144, MyChar.gMC.y + 1024, 3, 0);
                } else {
                    Bullet.SetBullet(bul_no, MyChar.gMC.x + 3072, MyChar.gMC.y + 1024, 2);
                    Caret.SetCaret(MyChar.gMC.x + 6144, MyChar.gMC.y + 1024, 3, 0);
                }
                Sound.PlaySoundObject(33, 1);
            }
        }
    }

    public static void ShootBullet_PoleStar(int level) {
        int bul_no = 0;
        switch (level) {
            case 1: {
                bul_no = 4;
                break;
            }
            case 2: {
                bul_no = 5;
                break;
            }
            case 3: {
                bul_no = 6;
            }
        }
        if (Bullet.CountArmsBullet(2) > 1) {
            return;
        }
        if ((KeyControl.gKeyTrg & KeyControl.gKeyShot) != 0) {
            if (!ArmsItem.UseArmsEnergy(1)) {
                Sound.PlaySoundObject(37, 1);
            } else {
                if (MyChar.gMC.up) {
                    if (MyChar.gMC.direct == 0) {
                        Bullet.SetBullet(bul_no, MyChar.gMC.x - 512, MyChar.gMC.y - 4096, 1);
                        Caret.SetCaret(MyChar.gMC.x - 512, MyChar.gMC.y - 4096, 3, 0);
                    } else {
                        Bullet.SetBullet(bul_no, MyChar.gMC.x + 512, MyChar.gMC.y - 4096, 1);
                        Caret.SetCaret(MyChar.gMC.x + 512, MyChar.gMC.y - 4096, 3, 0);
                    }
                } else if (MyChar.gMC.down) {
                    if (MyChar.gMC.direct == 0) {
                        Bullet.SetBullet(bul_no, MyChar.gMC.x - 512, MyChar.gMC.y + 4096, 3);
                        Caret.SetCaret(MyChar.gMC.x - 512, MyChar.gMC.y + 4096, 3, 0);
                    } else {
                        Bullet.SetBullet(bul_no, MyChar.gMC.x + 512, MyChar.gMC.y + 4096, 3);
                        Caret.SetCaret(MyChar.gMC.x + 512, MyChar.gMC.y + 4096, 3, 0);
                    }
                } else if (MyChar.gMC.direct == 0) {
                    Bullet.SetBullet(bul_no, MyChar.gMC.x - 3072, MyChar.gMC.y + 1536, 0);
                    Caret.SetCaret(MyChar.gMC.x - 6144, MyChar.gMC.y + 1536, 3, 0);
                } else {
                    Bullet.SetBullet(bul_no, MyChar.gMC.x + 3072, MyChar.gMC.y + 1536, 2);
                    Caret.SetCaret(MyChar.gMC.x + 6144, MyChar.gMC.y + 1536, 3, 0);
                }
                if (level == 3) {
                    Sound.PlaySoundObject(49, 1);
                } else {
                    Sound.PlaySoundObject(32, 1);
                }
            }
        }
    }

    public static void ShootBullet_FireBall(int level) {
        int bul_no = 0;
        switch (level) {
            case 1: {
                if (Bullet.CountArmsBullet(3) > 1) {
                    return;
                }
                bul_no = 7;
                break;
            }
            case 2: {
                if (Bullet.CountArmsBullet(3) > 2) {
                    return;
                }
                bul_no = 8;
                break;
            }
            case 3: {
                if (Bullet.CountArmsBullet(3) > 3) {
                    return;
                }
                bul_no = 9;
            }
        }
        if ((KeyControl.gKeyTrg & KeyControl.gKeyShot) != 0) {
            if (!ArmsItem.UseArmsEnergy(1)) {
                ArmsItem.ChangeToFirstArms();
            } else {
                if (MyChar.gMC.up) {
                    if (MyChar.gMC.direct == 0) {
                        Bullet.SetBullet(bul_no, MyChar.gMC.x - 2048, MyChar.gMC.y - 4096, 1);
                        Caret.SetCaret(MyChar.gMC.x - 2048, MyChar.gMC.y - 4096, 3, 0);
                    } else {
                        Bullet.SetBullet(bul_no, MyChar.gMC.x + 2048, MyChar.gMC.y - 4096, 1);
                        Caret.SetCaret(MyChar.gMC.x + 2048, MyChar.gMC.y - 4096, 3, 0);
                    }
                } else if (MyChar.gMC.down) {
                    if (MyChar.gMC.direct == 0) {
                        Bullet.SetBullet(bul_no, MyChar.gMC.x - 2048, MyChar.gMC.y + 4096, 3);
                        Caret.SetCaret(MyChar.gMC.x - 2048, MyChar.gMC.y + 4096, 3, 0);
                    } else {
                        Bullet.SetBullet(bul_no, MyChar.gMC.x + 2048, MyChar.gMC.y + 4096, 3);
                        Caret.SetCaret(MyChar.gMC.x + 2048, MyChar.gMC.y + 4096, 3, 0);
                    }
                } else if (MyChar.gMC.direct == 0) {
                    Bullet.SetBullet(bul_no, MyChar.gMC.x - 3072, MyChar.gMC.y + 1024, 0);
                    Caret.SetCaret(MyChar.gMC.x - 6144, MyChar.gMC.y + 1024, 3, 0);
                } else {
                    Bullet.SetBullet(bul_no, MyChar.gMC.x + 3072, MyChar.gMC.y + 1024, 2);
                    Caret.SetCaret(MyChar.gMC.x + 6144, MyChar.gMC.y + 1024, 3, 0);
                }
                Sound.PlaySoundObject(34, 1);
            }
        }
    }

    public static void ShootBullet_Machinegun1(int level) {
        int bul_no = 0;
        if (Bullet.CountArmsBullet(4) > 4) {
            return;
        }
        switch (level) {
            case 1: {
                bul_no = 10;
                break;
            }
            case 2: {
                bul_no = 11;
                break;
            }
            case 3: {
                bul_no = 12;
            }
        }
        if ((KeyControl.gKey & KeyControl.gKeyShot) == 0) {
            MyChar.gMC.rensha = (char)6;
        }
        if ((KeyControl.gKey & KeyControl.gKeyShot) != 0) {
            MyChar.gMC.rensha = (char)(MyChar.gMC.rensha + '\u0001');
            if (MyChar.gMC.rensha < '\u0006') {
                return;
            }
            MyChar.gMC.rensha = '\u0000';
            if (!ArmsItem.UseArmsEnergy(1)) {
                Sound.PlaySoundObject(37, 1);
                if (empty == 0) {
                    Caret.SetCaret(MyChar.gMC.x, MyChar.gMC.y, 16, 0);
                    empty = 50;
                }
                return;
            }
            if (MyChar.gMC.up) {
                if (level == 3) {
                    MyChar.gMC.ym += 256;
                }
                if (MyChar.gMC.direct == 0) {
                    Bullet.SetBullet(bul_no, MyChar.gMC.x - 1536, MyChar.gMC.y - 4096, 1);
                    Caret.SetCaret(MyChar.gMC.x - 1536, MyChar.gMC.y - 4096, 3, 0);
                } else {
                    Bullet.SetBullet(bul_no, MyChar.gMC.x + 1536, MyChar.gMC.y - 4096, 1);
                    Caret.SetCaret(MyChar.gMC.x + 1536, MyChar.gMC.y - 4096, 3, 0);
                }
            } else if (MyChar.gMC.down) {
                if (level == 3) {
                    if (MyChar.gMC.ym > 0) {
                        MyChar.gMC.ym /= 2;
                    }
                    if (MyChar.gMC.ym > -1024) {
                        MyChar.gMC.ym -= 512;
                        if (MyChar.gMC.ym < -1024) {
                            MyChar.gMC.ym = -1024;
                        }
                    }
                }
                if (MyChar.gMC.direct == 0) {
                    Bullet.SetBullet(bul_no, MyChar.gMC.x - 1536, MyChar.gMC.y + 4096, 3);
                    Caret.SetCaret(MyChar.gMC.x - 1536, MyChar.gMC.y + 4096, 3, 0);
                } else {
                    Bullet.SetBullet(bul_no, MyChar.gMC.x + 1536, MyChar.gMC.y + 4096, 3);
                    Caret.SetCaret(MyChar.gMC.x + 1536, MyChar.gMC.y + 4096, 3, 0);
                }
            } else if (MyChar.gMC.direct == 0) {
                Bullet.SetBullet(bul_no, MyChar.gMC.x - 6144, MyChar.gMC.y + 1536, 0);
                Caret.SetCaret(MyChar.gMC.x - 6144, MyChar.gMC.y + 1536, 3, 0);
            } else {
                Bullet.SetBullet(bul_no, MyChar.gMC.x + 6144, MyChar.gMC.y + 1536, 2);
                Caret.SetCaret(MyChar.gMC.x + 6144, MyChar.gMC.y + 1536, 3, 0);
            }
            if (level == 3) {
                Sound.PlaySoundObject(49, 1);
            } else {
                Sound.PlaySoundObject(32, 1);
            }
        } else {
            ++Machinegun1_wait;
            if ((MyChar.gMC.equip & 8) != 0) {
                if (Machinegun1_wait > 1) {
                    Machinegun1_wait = 0;
                    ArmsItem.ChargeArmsEnergy(1);
                }
            } else if (Machinegun1_wait > 4) {
                Machinegun1_wait = 0;
                ArmsItem.ChargeArmsEnergy(1);
            }
        }
    }

    public static void ShootBullet_Missile(int level, boolean bSuper) {
        int bul_no = 0;
        if (bSuper) {
            switch (level) {
                case 1: {
                    bul_no = 28;
                    break;
                }
                case 2: {
                    bul_no = 29;
                    break;
                }
                case 3: {
                    bul_no = 30;
                }
            }
            switch (level) {
                case 1: {
                    if (Bullet.CountArmsBullet(10) > 0) {
                        return;
                    }
                    if (Bullet.CountArmsBullet(11) <= 0) break;
                    return;
                }
                case 2: {
                    if (Bullet.CountArmsBullet(10) > 1) {
                        return;
                    }
                    if (Bullet.CountArmsBullet(11) <= 1) break;
                    return;
                }
                case 3: {
                    if (Bullet.CountArmsBullet(10) > 3) {
                        return;
                    }
                    if (Bullet.CountArmsBullet(11) <= 3) break;
                    return;
                }
            }
        } else {
            switch (level) {
                case 1: {
                    bul_no = 13;
                    break;
                }
                case 2: {
                    bul_no = 14;
                    break;
                }
                case 3: {
                    bul_no = 15;
                }
            }
            switch (level) {
                case 1: {
                    if (Bullet.CountArmsBullet(5) > 0) {
                        return;
                    }
                    if (Bullet.CountArmsBullet(6) <= 0) break;
                    return;
                }
                case 2: {
                    if (Bullet.CountArmsBullet(5) > 1) {
                        return;
                    }
                    if (Bullet.CountArmsBullet(6) <= 1) break;
                    return;
                }
                case 3: {
                    if (Bullet.CountArmsBullet(5) > 3) {
                        return;
                    }
                    if (Bullet.CountArmsBullet(6) <= 3) break;
                    return;
                }
            }
        }
        if ((KeyControl.gKeyTrg & KeyControl.gKeyShot) != 0) {
            if (level < 3) {
                if (!ArmsItem.UseArmsEnergy(1)) {
                    Sound.PlaySoundObject(37, 1);
                    if (empty == 0) {
                        Caret.SetCaret(MyChar.gMC.x, MyChar.gMC.y, 16, 0);
                        empty = 50;
                    }
                    return;
                }
                if (MyChar.gMC.up) {
                    if (MyChar.gMC.direct == 0) {
                        Bullet.SetBullet(bul_no, MyChar.gMC.x - 512, MyChar.gMC.y - 4096, 1);
                        Caret.SetCaret(MyChar.gMC.x - 512, MyChar.gMC.y - 4096, 3, 0);
                    } else {
                        Bullet.SetBullet(bul_no, MyChar.gMC.x + 512, MyChar.gMC.y - 4096, 1);
                        Caret.SetCaret(MyChar.gMC.x + 512, MyChar.gMC.y - 4096, 3, 0);
                    }
                } else if (MyChar.gMC.down) {
                    if (MyChar.gMC.direct == 0) {
                        Bullet.SetBullet(bul_no, MyChar.gMC.x - 512, MyChar.gMC.y + 4096, 3);
                        Caret.SetCaret(MyChar.gMC.x - 512, MyChar.gMC.y + 4096, 3, 0);
                    } else {
                        Bullet.SetBullet(bul_no, MyChar.gMC.x + 512, MyChar.gMC.y + 4096, 3);
                        Caret.SetCaret(MyChar.gMC.x + 512, MyChar.gMC.y + 4096, 3, 0);
                    }
                } else if (MyChar.gMC.direct == 0) {
                    Bullet.SetBullet(bul_no, MyChar.gMC.x - 3072, MyChar.gMC.y, 0);
                    Caret.SetCaret(MyChar.gMC.x - 6144, MyChar.gMC.y, 3, 0);
                } else {
                    Bullet.SetBullet(bul_no, MyChar.gMC.x + 3072, MyChar.gMC.y, 2);
                    Caret.SetCaret(MyChar.gMC.x + 6144, MyChar.gMC.y, 3, 0);
                }
            } else {
                if (!ArmsItem.UseArmsEnergy(1)) {
                    Sound.PlaySoundObject(37, 1);
                    if (empty == 0) {
                        Caret.SetCaret(MyChar.gMC.x, MyChar.gMC.y, 16, 0);
                        empty = 50;
                    }
                    return;
                }
                if (MyChar.gMC.up) {
                    if (MyChar.gMC.direct == 0) {
                        Bullet.SetBullet(bul_no, MyChar.gMC.x - 512, MyChar.gMC.y - 4096, 1);
                        Caret.SetCaret(MyChar.gMC.x - 512, MyChar.gMC.y - 4096, 3, 0);
                        Bullet.SetBullet(bul_no, MyChar.gMC.x + 1536, MyChar.gMC.y, 1);
                        Bullet.SetBullet(bul_no, MyChar.gMC.x - 1536, MyChar.gMC.y, 1);
                    } else {
                        Bullet.SetBullet(bul_no, MyChar.gMC.x + 512, MyChar.gMC.y - 4096, 1);
                        Caret.SetCaret(MyChar.gMC.x + 512, MyChar.gMC.y - 4096, 3, 0);
                        Bullet.SetBullet(bul_no, MyChar.gMC.x + 1536, MyChar.gMC.y, 1);
                        Bullet.SetBullet(bul_no, MyChar.gMC.x - 1536, MyChar.gMC.y, 1);
                    }
                } else if (MyChar.gMC.down) {
                    if (MyChar.gMC.direct == 0) {
                        Bullet.SetBullet(bul_no, MyChar.gMC.x - 512, MyChar.gMC.y + 4096, 3);
                        Caret.SetCaret(MyChar.gMC.x - 512, MyChar.gMC.y + 4096, 3, 0);
                        Bullet.SetBullet(bul_no, MyChar.gMC.x + 1536, MyChar.gMC.y, 3);
                        Bullet.SetBullet(bul_no, MyChar.gMC.x - 1536, MyChar.gMC.y, 3);
                    } else {
                        Bullet.SetBullet(bul_no, MyChar.gMC.x + 512, MyChar.gMC.y + 4096, 3);
                        Caret.SetCaret(MyChar.gMC.x + 512, MyChar.gMC.y + 4096, 3, 0);
                        Bullet.SetBullet(bul_no, MyChar.gMC.x - 1536, MyChar.gMC.y, 3);
                        Bullet.SetBullet(bul_no, MyChar.gMC.x + 1536, MyChar.gMC.y, 3);
                    }
                } else if (MyChar.gMC.direct == 0) {
                    Bullet.SetBullet(bul_no, MyChar.gMC.x - 3072, MyChar.gMC.y + 512, 0);
                    Caret.SetCaret(MyChar.gMC.x - 6144, MyChar.gMC.y + 512, 3, 0);
                    Bullet.SetBullet(bul_no, MyChar.gMC.x, MyChar.gMC.y - 4096, 0);
                    Bullet.SetBullet(bul_no, MyChar.gMC.x + 2048, MyChar.gMC.y - 512, 0);
                } else {
                    Bullet.SetBullet(bul_no, MyChar.gMC.x + 3072, MyChar.gMC.y + 512, 2);
                    Caret.SetCaret(MyChar.gMC.x + 6144, MyChar.gMC.y + 512, 3, 0);
                    Bullet.SetBullet(bul_no, MyChar.gMC.x, MyChar.gMC.y - 4096, 2);
                    Bullet.SetBullet(bul_no, MyChar.gMC.x - 2048, MyChar.gMC.y - 512, 2);
                }
            }
            Sound.PlaySoundObject(32, 1);
        }
    }

    public static void ShootBullet_Bubblin1() {
        if (Bullet.CountArmsBullet(7) > 3) {
            return;
        }
        if ((KeyControl.gKeyTrg & KeyControl.gKeyShot) != 0) {
            if (!ArmsItem.UseArmsEnergy(1)) {
                Sound.PlaySoundObject(37, 1);
                if (empty == 0) {
                    Caret.SetCaret(MyChar.gMC.x, MyChar.gMC.y, 16, 0);
                    empty = 50;
                }
                return;
            }
            if (MyChar.gMC.up) {
                if (MyChar.gMC.direct == 0) {
                    Bullet.SetBullet(19, MyChar.gMC.x - 512, MyChar.gMC.y - 1024, 1);
                    Caret.SetCaret(MyChar.gMC.x - 512, MyChar.gMC.y - 1024, 3, 0);
                } else {
                    Bullet.SetBullet(19, MyChar.gMC.x + 512, MyChar.gMC.y - 1024, 1);
                    Caret.SetCaret(MyChar.gMC.x + 512, MyChar.gMC.y - 1024, 3, 0);
                }
            } else if (MyChar.gMC.down) {
                if (MyChar.gMC.direct == 0) {
                    Bullet.SetBullet(19, MyChar.gMC.x - 512, MyChar.gMC.y + 1024, 3);
                    Caret.SetCaret(MyChar.gMC.x - 512, MyChar.gMC.y + 1024, 3, 0);
                } else {
                    Bullet.SetBullet(19, MyChar.gMC.x + 512, MyChar.gMC.y + 1024, 3);
                    Caret.SetCaret(MyChar.gMC.x + 512, MyChar.gMC.y + 1024, 3, 0);
                }
            } else if (MyChar.gMC.direct == 0) {
                Bullet.SetBullet(19, MyChar.gMC.x - 3072, MyChar.gMC.y + 1536, 0);
                Caret.SetCaret(MyChar.gMC.x - 6144, MyChar.gMC.y + 1536, 3, 0);
            } else {
                Bullet.SetBullet(19, MyChar.gMC.x + 3072, MyChar.gMC.y + 1536, 2);
                Caret.SetCaret(MyChar.gMC.x + 6144, MyChar.gMC.y + 1536, 3, 0);
            }
            Sound.PlaySoundObject(48, 1);
        } else if (++Bubblin1_wait > 20) {
            Bubblin1_wait = 0;
            ArmsItem.ChargeArmsEnergy(1);
        }
    }

    public static void ShootBullet_Bubblin2(int level) {
        if (Bullet.CountArmsBullet(7) > 15) {
            return;
        }
        level += 18;
        if ((KeyControl.gKey & KeyControl.gKeyShot) == 0) {
            MyChar.gMC.rensha = (char)6;
        }
        if ((KeyControl.gKey & KeyControl.gKeyShot) != 0) {
            MyChar.gMC.rensha = (char)(MyChar.gMC.rensha + '\u0001');
            if (MyChar.gMC.rensha < '\u0007') {
                return;
            }
            MyChar.gMC.rensha = '\u0000';
            if (!ArmsItem.UseArmsEnergy(1)) {
                Sound.PlaySoundObject(37, 1);
                if (empty == 0) {
                    Caret.SetCaret(MyChar.gMC.x, MyChar.gMC.y, 16, 0);
                    empty = 50;
                }
                return;
            }
            if (MyChar.gMC.up) {
                if (MyChar.gMC.direct == 0) {
                    Bullet.SetBullet(level, MyChar.gMC.x - 1536, MyChar.gMC.y - 4096, 1);
                    Caret.SetCaret(MyChar.gMC.x - 1536, MyChar.gMC.y - 8192, 3, 0);
                } else {
                    Bullet.SetBullet(level, MyChar.gMC.x + 1536, MyChar.gMC.y - 4096, 1);
                    Caret.SetCaret(MyChar.gMC.x + 1536, MyChar.gMC.y - 8192, 3, 0);
                }
            } else if (MyChar.gMC.down) {
                if (MyChar.gMC.direct == 0) {
                    Bullet.SetBullet(level, MyChar.gMC.x - 1536, MyChar.gMC.y + 4096, 3);
                    Caret.SetCaret(MyChar.gMC.x - 1536, MyChar.gMC.y + 8192, 3, 0);
                } else {
                    Bullet.SetBullet(level, MyChar.gMC.x + 1536, MyChar.gMC.y + 4096, 3);
                    Caret.SetCaret(MyChar.gMC.x + 1536, MyChar.gMC.y + 8192, 3, 0);
                }
            } else if (MyChar.gMC.direct == 0) {
                Bullet.SetBullet(level, MyChar.gMC.x - 3072, MyChar.gMC.y + 1536, 0);
                Caret.SetCaret(MyChar.gMC.x - 6144, MyChar.gMC.y + 1536, 3, 0);
            } else {
                Bullet.SetBullet(level, MyChar.gMC.x + 3072, MyChar.gMC.y + 1536, 2);
                Caret.SetCaret(MyChar.gMC.x + 6144, MyChar.gMC.y + 1536, 3, 0);
            }
            Sound.PlaySoundObject(48, 1);
        } else if (++Bubblin2_wait > 1) {
            Bubblin2_wait = 0;
            ArmsItem.ChargeArmsEnergy(1);
        }
    }

    public static void ShootBullet_Sword(int level) {
        int bul_no = 0;
        if (Bullet.CountArmsBullet(9) > 0) {
            return;
        }
        switch (level) {
            case 1: {
                bul_no = 25;
                break;
            }
            case 2: {
                bul_no = 26;
                break;
            }
            case 3: {
                bul_no = 27;
            }
        }
        if ((KeyControl.gKeyTrg & KeyControl.gKeyShot) != 0) {
            if (MyChar.gMC.up) {
                if (MyChar.gMC.direct == 0) {
                    Bullet.SetBullet(bul_no, MyChar.gMC.x - 512, MyChar.gMC.y + 2048, 1);
                } else {
                    Bullet.SetBullet(bul_no, MyChar.gMC.x + 512, MyChar.gMC.y + 2048, 1);
                }
            } else if (MyChar.gMC.down) {
                if (MyChar.gMC.direct == 0) {
                    Bullet.SetBullet(bul_no, MyChar.gMC.x - 512, MyChar.gMC.y - 3072, 3);
                } else {
                    Bullet.SetBullet(bul_no, MyChar.gMC.x + 512, MyChar.gMC.y - 3072, 3);
                }
            } else if (MyChar.gMC.direct == 0) {
                Bullet.SetBullet(bul_no, MyChar.gMC.x + 3072, MyChar.gMC.y - 1536, 0);
            } else {
                Bullet.SetBullet(bul_no, MyChar.gMC.x - 3072, MyChar.gMC.y - 1536, 2);
            }
            Sound.PlaySoundObject(34, 1);
        }
    }

    public static void ShootBullet_Nemesis(int level) {
        int bul_no = 0;
        switch (level) {
            case 1: {
                bul_no = 34;
                break;
            }
            case 2: {
                bul_no = 35;
                break;
            }
            case 3: {
                bul_no = 36;
            }
        }
        if (Bullet.CountArmsBullet(12) > 1) {
            return;
        }
        if ((KeyControl.gKeyTrg & KeyControl.gKeyShot) != 0) {
            if (!ArmsItem.UseArmsEnergy(1)) {
                Sound.PlaySoundObject(37, 1);
            } else {
                if (MyChar.gMC.up) {
                    if (MyChar.gMC.direct == 0) {
                        Bullet.SetBullet(bul_no, MyChar.gMC.x - 512, MyChar.gMC.y - 6144, 1);
                        Caret.SetCaret(MyChar.gMC.x - 512, MyChar.gMC.y - 6144, 3, 0);
                    } else {
                        Bullet.SetBullet(bul_no, MyChar.gMC.x + 512, MyChar.gMC.y - 6144, 1);
                        Caret.SetCaret(MyChar.gMC.x + 512, MyChar.gMC.y - 6144, 3, 0);
                    }
                } else if (MyChar.gMC.down) {
                    if (MyChar.gMC.direct == 0) {
                        Bullet.SetBullet(bul_no, MyChar.gMC.x - 512, MyChar.gMC.y + 6144, 3);
                        Caret.SetCaret(MyChar.gMC.x - 512, MyChar.gMC.y + 6144, 3, 0);
                    } else {
                        Bullet.SetBullet(bul_no, MyChar.gMC.x + 512, MyChar.gMC.y + 6144, 3);
                        Caret.SetCaret(MyChar.gMC.x + 512, MyChar.gMC.y + 6144, 3, 0);
                    }
                } else if (MyChar.gMC.direct == 0) {
                    Bullet.SetBullet(bul_no, MyChar.gMC.x - 11264, MyChar.gMC.y + 1536, 0);
                    Caret.SetCaret(MyChar.gMC.x - 8192, MyChar.gMC.y + 1536, 3, 0);
                } else {
                    Bullet.SetBullet(bul_no, MyChar.gMC.x + 11264, MyChar.gMC.y + 1536, 2);
                    Caret.SetCaret(MyChar.gMC.x + 8192, MyChar.gMC.y + 1536, 3, 0);
                }
                switch (level) {
                    case 1: {
                        Sound.PlaySoundObject(117, 1);
                        break;
                    }
                    case 2: {
                        Sound.PlaySoundObject(49, 1);
                        break;
                    }
                    case 3: {
                        Sound.PlaySoundObject(60, 1);
                    }
                }
            }
        }
    }

    public static void ResetSpurCharge() {
        spur_charge = 0;
        if (ArmsItem.gArmsData[ArmsItem.gSelectedArms].code == 13) {
            MycParam.ZeroExpMyChar();
        }
    }

    public static void ShootBullet_Spur(int level) {
        int bul_no = 0;
        boolean bShot = false;
        if ((KeyControl.gKey & KeyControl.gKeyShot) != 0) {
            if ((MyChar.gMC.equip & 8) != 0) {
                MycParam.AddExpMyChar(3);
            } else {
                MycParam.AddExpMyChar(2);
            }
            if (++spur_charge / 2 % 2 != 0) {
                switch (level) {
                    case 1: {
                        Sound.PlaySoundObject(59, 1);
                        break;
                    }
                    case 2: {
                        Sound.PlaySoundObject(60, 1);
                        break;
                    }
                    case 3: {
                        if (MycParam.IsMaxExpMyChar()) break;
                        Sound.PlaySoundObject(61, 1);
                    }
                }
            }
        } else {
            if (spur_charge != 0) {
                bShot = true;
            }
            spur_charge = 0;
        }
        if (MycParam.IsMaxExpMyChar()) {
            if (!Spur_bMax) {
                Spur_bMax = true;
                Sound.PlaySoundObject(65, 1);
            }
        } else {
            Spur_bMax = false;
        }
        if ((KeyControl.gKey & KeyControl.gKeyShot) == 0) {
            MycParam.ZeroExpMyChar();
        }
        switch (level) {
            case 1: {
                bul_no = 6;
                bShot = false;
                break;
            }
            case 2: {
                bul_no = 37;
                break;
            }
            case 3: {
                bul_no = Spur_bMax ? 39 : 38;
            }
        }
        if (Bullet.CountArmsBullet(13) > 0 || Bullet.CountArmsBullet(14) > 0) {
            return;
        }
        if ((KeyControl.gKeyTrg & KeyControl.gKeyShot) != 0 || bShot) {
            if (!ArmsItem.UseArmsEnergy(1)) {
                Sound.PlaySoundObject(37, 1);
            } else {
                if (MyChar.gMC.up) {
                    if (MyChar.gMC.direct == 0) {
                        Bullet.SetBullet(bul_no, MyChar.gMC.x - 512, MyChar.gMC.y - 4096, 1);
                        Caret.SetCaret(MyChar.gMC.x - 512, MyChar.gMC.y - 4096, 3, 0);
                    } else {
                        Bullet.SetBullet(bul_no, MyChar.gMC.x + 512, MyChar.gMC.y - 4096, 1);
                        Caret.SetCaret(MyChar.gMC.x + 512, MyChar.gMC.y - 4096, 3, 0);
                    }
                } else if (MyChar.gMC.down) {
                    if (MyChar.gMC.direct == 0) {
                        Bullet.SetBullet(bul_no, MyChar.gMC.x - 512, MyChar.gMC.y + 4096, 3);
                        Caret.SetCaret(MyChar.gMC.x - 512, MyChar.gMC.y + 4096, 3, 0);
                    } else {
                        Bullet.SetBullet(bul_no, MyChar.gMC.x + 512, MyChar.gMC.y + 4096, 3);
                        Caret.SetCaret(MyChar.gMC.x + 512, MyChar.gMC.y + 4096, 3, 0);
                    }
                } else if (MyChar.gMC.direct == 0) {
                    Bullet.SetBullet(bul_no, MyChar.gMC.x - 3072, MyChar.gMC.y + 1536, 0);
                    Caret.SetCaret(MyChar.gMC.x - 6144, MyChar.gMC.y + 1536, 3, 0);
                } else {
                    Bullet.SetBullet(bul_no, MyChar.gMC.x + 3072, MyChar.gMC.y + 1536, 2);
                    Caret.SetCaret(MyChar.gMC.x + 6144, MyChar.gMC.y + 1536, 3, 0);
                }
                switch (bul_no) {
                    case 6: {
                        Sound.PlaySoundObject(49, 1);
                        break;
                    }
                    case 37: {
                        Sound.PlaySoundObject(62, 1);
                        break;
                    }
                    case 38: {
                        Sound.PlaySoundObject(63, 1);
                        break;
                    }
                    case 39: {
                        Sound.PlaySoundObject(64, 1);
                    }
                }
            }
        }
    }

    public static void ShootBullet() {
        if (empty != 0) {
            --empty;
        }
        if (ShootBullet_soft_rensha != 0) {
            --ShootBullet_soft_rensha;
        }
        if ((KeyControl.gKeyTrg & KeyControl.gKeyShot) != 0) {
            if (ShootBullet_soft_rensha != 0) {
                return;
            }
            ShootBullet_soft_rensha = 4;
        }
        if ((MyChar.gMC.cond & 2) != 0) {
            return;
        }
        switch (ArmsItem.gArmsData[ArmsItem.gSelectedArms].code) {
            case 1: {
                Shoot.ShootBullet_Frontia1(ArmsItem.gArmsData[ArmsItem.gSelectedArms].level);
                break;
            }
            case 2: {
                Shoot.ShootBullet_PoleStar(ArmsItem.gArmsData[ArmsItem.gSelectedArms].level);
                break;
            }
            case 3: {
                Shoot.ShootBullet_FireBall(ArmsItem.gArmsData[ArmsItem.gSelectedArms].level);
                break;
            }
            case 4: {
                Shoot.ShootBullet_Machinegun1(ArmsItem.gArmsData[ArmsItem.gSelectedArms].level);
                break;
            }
            case 5: {
                Shoot.ShootBullet_Missile(ArmsItem.gArmsData[ArmsItem.gSelectedArms].level, false);
                break;
            }
            case 7: {
                switch (ArmsItem.gArmsData[ArmsItem.gSelectedArms].level) {
                    case 1: {
                        Shoot.ShootBullet_Bubblin1();
                        break;
                    }
                    case 2: {
                        Shoot.ShootBullet_Bubblin2(2);
                        break;
                    }
                    case 3: {
                        Shoot.ShootBullet_Bubblin2(3);
                    }
                }
                break;
            }
            case 9: {
                switch (ArmsItem.gArmsData[ArmsItem.gSelectedArms].level) {
                    case 1: {
                        Shoot.ShootBullet_Sword(1);
                        break;
                    }
                    case 2: {
                        Shoot.ShootBullet_Sword(2);
                        break;
                    }
                    case 3: {
                        Shoot.ShootBullet_Sword(3);
                    }
                }
                break;
            }
            case 10: {
                Shoot.ShootBullet_Missile(ArmsItem.gArmsData[ArmsItem.gSelectedArms].level, true);
                break;
            }
            case 12: {
                Shoot.ShootBullet_Nemesis(ArmsItem.gArmsData[ArmsItem.gSelectedArms].level);
                break;
            }
            case 13: {
                Shoot.ShootBullet_Spur(ArmsItem.gArmsData[ArmsItem.gSelectedArms].level);
            }
        }
    }

    static {
        Machinegun1_wait = 0;
        spur_charge = 0;
    }
}
