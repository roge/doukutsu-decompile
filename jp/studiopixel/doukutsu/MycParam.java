/*
 * Decompiled with CFR 0.152.
 */
package jp.studiopixel.doukutsu;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import jp.studiopixel.doukutsu.ArmsItem;
import jp.studiopixel.doukutsu.Caret;
import jp.studiopixel.doukutsu.Draw;
import jp.studiopixel.doukutsu.Game;
import jp.studiopixel.doukutsu.MyChar;
import jp.studiopixel.doukutsu.NpChar;
import jp.studiopixel.doukutsu.RECT;
import jp.studiopixel.doukutsu.Sound;
import jp.studiopixel.doukutsu.TextScr;
import jp.studiopixel.doukutsu.ValueView;

public class MycParam {
    public static final ARMS_LEVEL[] gArmsLevelTable = new ARMS_LEVEL[]{new ARMS_LEVEL(0, 0, 100), new ARMS_LEVEL(30, 40, 16), new ARMS_LEVEL(10, 20, 10), new ARMS_LEVEL(10, 20, 20), new ARMS_LEVEL(30, 40, 10), new ARMS_LEVEL(10, 20, 10), new ARMS_LEVEL(10, 20, 30), new ARMS_LEVEL(10, 20, 5), new ARMS_LEVEL(10, 20, 100), new ARMS_LEVEL(30, 60, 0), new ARMS_LEVEL(30, 60, 10), new ARMS_LEVEL(10, 20, 100), new ARMS_LEVEL(1, 1, 1), new ARMS_LEVEL(40, 60, 200)};
    private static char add_flash = '\u0000';
    private static final RECT[] rcAir = new RECT[]{new RECT(112, 72, 144, 80), new RECT(112, 80, 144, 88)};
    public static int time_count = 0;
    private static RECT[] rcTime = new RECT[]{new RECT(112, 104, 120, 112), new RECT(120, 104, 128, 112), new RECT(128, 104, 160, 112)};

    public static void AddExpMyChar(int x) {
        block4: {
            int lv;
            int arms_code;
            block3: {
                arms_code = ArmsItem.gArmsData[ArmsItem.gSelectedArms].code;
                ArmsItem.gArmsData[ArmsItem.gSelectedArms].exp += x;
                if (lv != 2) break block3;
                if (ArmsItem.gArmsData[ArmsItem.gSelectedArms].exp < MycParam.gArmsLevelTable[arms_code].exp[lv]) break block4;
                ArmsItem.gArmsData[ArmsItem.gSelectedArms].exp = MycParam.gArmsLevelTable[arms_code].exp[lv];
                if ((MyChar.gMC.equip & 0x80) == 0 || MyChar.gMC.star >= 3) break block4;
                MyChar.gMC.star = (short)(MyChar.gMC.star + 1);
                break block4;
            }
            for (lv = ArmsItem.gArmsData[ArmsItem.gSelectedArms].level - 1; lv < 2; ++lv) {
                if (ArmsItem.gArmsData[ArmsItem.gSelectedArms].exp < MycParam.gArmsLevelTable[arms_code].exp[lv]) continue;
                ++ArmsItem.gArmsData[ArmsItem.gSelectedArms].level;
                ArmsItem.gArmsData[ArmsItem.gSelectedArms].exp = 0;
                if (ArmsItem.gArmsData[ArmsItem.gSelectedArms].code == 13) continue;
                Sound.PlaySoundObject(27, 1);
                Caret.SetCaret(MyChar.gMC.x, MyChar.gMC.y, 10, 0);
            }
        }
        if (ArmsItem.gArmsData[ArmsItem.gSelectedArms].code != 13) {
            MyChar.gMC.exp_count += x;
            MyChar.gMC.exp_wait = 30;
        } else {
            MyChar.gMC.exp_wait = 10;
        }
    }

    public static void ZeroExpMyChar() {
        ArmsItem.gArmsData[ArmsItem.gSelectedArms].level = 1;
        ArmsItem.gArmsData[ArmsItem.gSelectedArms].exp = 0;
    }

    public static boolean IsMaxExpMyChar() {
        if (ArmsItem.gArmsData[ArmsItem.gSelectedArms].level == 3) {
            int arms_code = ArmsItem.gArmsData[ArmsItem.gSelectedArms].code;
            if (ArmsItem.gArmsData[ArmsItem.gSelectedArms].exp >= MycParam.gArmsLevelTable[arms_code].exp[2]) {
                return true;
            }
        }
        return false;
    }

    public static void DamageMyChar(int damage) {
        if (MyChar.gMC.shock != '\u0000') {
            return;
        }
        Sound.PlaySoundObject(16, 1);
        MyChar.gMC.cond = (char)(MyChar.gMC.cond & 0xFFFFFFFE);
        MyChar.gMC.shock = (char)128;
        if (MyChar.gMC.unit != 1) {
            MyChar.gMC.ym = -1024;
        }
        MyChar.gMC.life = (short)(MyChar.gMC.life - (short)damage);
        if ((MyChar.gMC.equip & 0x80) != 0 && MyChar.gMC.star > 0) {
            MyChar.gMC.star = (short)(MyChar.gMC.star - 1);
        }
        ArmsItem.gArmsData[ArmsItem.gSelectedArms].exp = (MyChar.gMC.equip & 4) != 0 ? (ArmsItem.gArmsData[ArmsItem.gSelectedArms].exp -= damage) : (ArmsItem.gArmsData[ArmsItem.gSelectedArms].exp -= damage * 2);
        while (ArmsItem.gArmsData[ArmsItem.gSelectedArms].exp < 0) {
            if (ArmsItem.gArmsData[ArmsItem.gSelectedArms].level > 1) {
                --ArmsItem.gArmsData[ArmsItem.gSelectedArms].level;
                int lv = ArmsItem.gArmsData[ArmsItem.gSelectedArms].level - 1;
                int arms_code = ArmsItem.gArmsData[ArmsItem.gSelectedArms].code;
                ArmsItem.gArmsData[ArmsItem.gSelectedArms].exp = MycParam.gArmsLevelTable[arms_code].exp[lv] + ArmsItem.gArmsData[ArmsItem.gSelectedArms].exp;
                if (MyChar.gMC.life <= 0 || ArmsItem.gArmsData[ArmsItem.gSelectedArms].code == 13) continue;
                Caret.SetCaret(MyChar.gMC.x, MyChar.gMC.y, 10, 2);
                continue;
            }
            ArmsItem.gArmsData[ArmsItem.gSelectedArms].exp = 0;
        }
        ValueView.SetValueView(() -> MyChar.gMC.x, () -> MyChar.gMC.y, -damage, MyChar.gMC.hashCode());
        if (MyChar.gMC.life <= 0) {
            Sound.PlaySoundObject(17, 1);
            MyChar.gMC.cond = '\u0000';
            NpChar.SetDestroyNpChar(MyChar.gMC.x, MyChar.gMC.y, 5120, 64);
            TextScr.StartTextScript(40);
        }
    }

    public static void ZeroArmsEnergy_All() {
        for (int a = 0; a < 8; ++a) {
            ArmsItem.gArmsData[a].level = 1;
            ArmsItem.gArmsData[a].exp = 0;
        }
    }

    public static void AddBulletMyChar(int no, int val) {
        int a;
        for (a = 0; a < 8 && ArmsItem.gArmsData[a].code != 5; ++a) {
        }
        if (a == 8) {
            for (a = 0; a < 8 && ArmsItem.gArmsData[a].code != 10; ++a) {
            }
            if (a == 8) {
                return;
            }
        }
        ArmsItem.gArmsData[a].num += val;
        if (ArmsItem.gArmsData[a].num > ArmsItem.gArmsData[a].max_num) {
            ArmsItem.gArmsData[a].num = ArmsItem.gArmsData[a].max_num;
        }
    }

    public static void AddLifeMyChar(int x) {
        MyChar.gMC.life = (short)(MyChar.gMC.life + (short)x);
        if (MyChar.gMC.life > MyChar.gMC.max_life) {
            MyChar.gMC.life = MyChar.gMC.max_life;
        }
        MyChar.gMC.lifeBr = MyChar.gMC.life;
    }

    public static void AddMaxLifeMyChar(int val) {
        MyChar.gMC.max_life = (short)(MyChar.gMC.max_life + (short)val);
        if (MyChar.gMC.max_life > 232) {
            MyChar.gMC.max_life = (short)232;
        }
        MyChar.gMC.life = (short)(MyChar.gMC.life + (short)val);
        MyChar.gMC.lifeBr = MyChar.gMC.life;
    }

    public static void PutArmsEnergy(boolean flash) {
        RECT rcPer = new RECT(72, 48, 80, 56);
        RECT rcLv = new RECT(80, 80, 96, 88);
        RECT rcView = new RECT(0, 0, 320, 240);
        RECT rcNone = new RECT(80, 48, 96, 56);
        if (ArmsItem.gArmsEnergyX > 16) {
            ArmsItem.gArmsEnergyX -= 2;
        }
        if (ArmsItem.gArmsEnergyX < 16) {
            ArmsItem.gArmsEnergyX += 2;
        }
        if (ArmsItem.gArmsData[ArmsItem.gSelectedArms].max_num != 0) {
            Game.PutNumber4(ArmsItem.gArmsEnergyX + 32, 16, ArmsItem.gArmsData[ArmsItem.gSelectedArms].num, false);
            Game.PutNumber4(ArmsItem.gArmsEnergyX + 32, 24, ArmsItem.gArmsData[ArmsItem.gSelectedArms].max_num, false);
        } else {
            Draw.PutBitmap3(rcView, ArmsItem.gArmsEnergyX + 48, 16, rcNone, 26);
            Draw.PutBitmap3(rcView, ArmsItem.gArmsEnergyX + 48, 24, rcNone, 26);
        }
        if (flash && MyChar.gMC.shock / 2 % 2 != 0) {
            return;
        }
        Draw.PutBitmap3(rcView, ArmsItem.gArmsEnergyX + 32, 24, rcPer, 26);
        Draw.PutBitmap3(rcView, ArmsItem.gArmsEnergyX, 32, rcLv, 26);
        Game.PutNumber4(ArmsItem.gArmsEnergyX - 8, 32, ArmsItem.gArmsData[ArmsItem.gSelectedArms].level, false);
        RECT rcExpBox = new RECT(0, 72, 40, 80);
        RECT rcExpVal = new RECT(0, 80, 0, 88);
        RECT rcExpMax = new RECT(40, 72, 80, 80);
        RECT rcExpFlash = new RECT(40, 80, 80, 88);
        int lv = ArmsItem.gArmsData[ArmsItem.gSelectedArms].level - 1;
        if (lv < 0) {
            lv = 0;
        }
        int arms_code = ArmsItem.gArmsData[ArmsItem.gSelectedArms].code;
        int exp_now = ArmsItem.gArmsData[ArmsItem.gSelectedArms].exp;
        int exp_next = MycParam.gArmsLevelTable[arms_code].exp[lv];
        Draw.PutBitmap3(rcView, ArmsItem.gArmsEnergyX + 24, 32, rcExpBox, 26);
        if (lv == 2 && ArmsItem.gArmsData[ArmsItem.gSelectedArms].exp == MycParam.gArmsLevelTable[arms_code].exp[lv]) {
            Draw.PutBitmap3(rcView, ArmsItem.gArmsEnergyX + 24, 32, rcExpMax, 26);
        } else {
            rcExpVal.right = exp_next != 0 ? (rcExpVal.right += exp_now * 40 / exp_next) : 0;
            Draw.PutBitmap3(rcView, ArmsItem.gArmsEnergyX + 24, 32, rcExpVal, 26);
        }
        if (MyChar.gMC.exp_wait != 0) {
            char c = add_flash;
            add_flash = (char)(c + '\u0001');
            if (c / 2 % 2 != 0) {
                Draw.PutBitmap3(rcView, ArmsItem.gArmsEnergyX + 24, 32, rcExpFlash, 26);
            }
        }
    }

    public static void PutActiveArmsList() {
        RECT rect = new RECT(0, 0, 0, 16);
        int arms_num = 0;
        while (ArmsItem.gArmsData[arms_num].code != 0) {
            ++arms_num;
        }
        if (arms_num == 0) {
            return;
        }
        for (int a = 0; a < arms_num; ++a) {
            int x = (a - ArmsItem.gSelectedArms) * 16 + ArmsItem.gArmsEnergyX;
            if (x < 8) {
                x += 48 + arms_num * 16;
            } else if (x >= 24) {
                x += 48;
            }
            if (x >= 72 + (arms_num - 1) * 16) {
                x -= 48 + arms_num * 16;
            }
            if (x < 72 && x >= 24) {
                x -= 48;
            }
            rect.left = ArmsItem.gArmsData[a].code * 16;
            rect.right = rect.left + 16;
            Draw.PutBitmap3(Draw.grcGame, x, 16, rect, 12);
        }
    }

    public static void PutMyLife(boolean flash) {
        RECT rcCase = new RECT(0, 40, 232, 48);
        RECT rcLife = new RECT(0, 24, 232, 32);
        RECT rcBr = new RECT(0, 32, 232, 40);
        if (flash && MyChar.gMC.shock / 2 % 2 != 0) {
            return;
        }
        if (MyChar.gMC.lifeBr < MyChar.gMC.life) {
            MyChar.gMC.lifeBr = MyChar.gMC.life;
        }
        if (MyChar.gMC.lifeBr > MyChar.gMC.life) {
            if (++MyChar.gMC.lifeBr_count > 30) {
                --MyChar.gMC.lifeBr;
            }
        } else {
            MyChar.gMC.lifeBr_count = 0;
        }
        rcCase.right = 64;
        rcLife.right = MyChar.gMC.life * 40 / MyChar.gMC.max_life - 1;
        rcBr.right = MyChar.gMC.lifeBr * 40 / MyChar.gMC.max_life - 1;
        Draw.PutBitmap3(Draw.grcGame, 16, 40, rcCase, 26);
        Draw.PutBitmap3(Draw.grcGame, 40, 40, rcBr, 26);
        Draw.PutBitmap3(Draw.grcGame, 40, 40, rcLife, 26);
        Game.PutNumber4(8, 40, MyChar.gMC.lifeBr, false);
    }

    public static void PutMyAir(int x, int y) {
        if ((MyChar.gMC.equip & 0x10) != 0) {
            return;
        }
        if (MyChar.gMC.air_get != 0) {
            if (MyChar.gMC.air_get % 6 < 4) {
                Game.PutNumber4(x + 32, y, MyChar.gMC.air / 10, false);
            }
            if (MyChar.gMC.air % 30 > 10) {
                Draw.PutBitmap3(Draw.grcGame, x, y, rcAir[0], 26);
            } else {
                Draw.PutBitmap3(Draw.grcGame, x, y, rcAir[1], 26);
            }
        }
    }

    public static void PutTimeCounter(int x, int y) {
        if ((MyChar.gMC.equip & 0x100) != 0) {
            if ((Game.g_GameFlags & 2) != 0) {
                if (time_count < 300000) {
                    ++time_count;
                }
                if (time_count % 30 > 10) {
                    Draw.PutBitmap3(Draw.grcGame, x, y, rcTime[0], 26);
                } else {
                    Draw.PutBitmap3(Draw.grcGame, x, y, rcTime[1], 26);
                }
            } else {
                Draw.PutBitmap3(Draw.grcGame, x, y, rcTime[0], 26);
            }
            Game.PutNumber4(x, y, time_count / 3000, false);
            Game.PutNumber4(x + 20, y, time_count / 50 % 60, true);
            Game.PutNumber4(x + 32, y, time_count / 5 % 10, false);
            Draw.PutBitmap3(Draw.grcGame, x + 30, y, rcTime[2], 26);
        } else {
            time_count = 0;
        }
    }

    public static boolean SaveTimeCounter() {
        if ((MyChar.gMC.equip & 0x100) == 0) {
            return true;
        }
        int[] counter = new int[4];
        byte[] random = new byte[4];
        byte[] p = new byte[4];
        try {
            File fp = new File("290.rec");
            if (fp.exists()) {
                ByteBuffer buf = ByteBuffer.allocate((int)fp.length());
                DataInputStream dis = new DataInputStream(Files.newInputStream(fp.toPath(), new OpenOption[0]));
                dis.readFully(buf.array());
                dis.close();
                buf.order(ByteOrder.LITTLE_ENDIAN);
                ((Buffer)buf).position(0);
                counter[0] = buf.getInt();
                counter[1] = buf.getInt();
                counter[2] = buf.getInt();
                counter[3] = buf.getInt();
                random[0] = buf.get();
                random[1] = buf.get();
                random[2] = buf.get();
                random[3] = buf.get();
                p[0] = (byte)(counter[0] - random[0] & 0xFF & 0xFF);
                p[1] = (byte)((counter[0] >>> 8) - random[0] & 0xFF & 0xFF);
                p[2] = (byte)((counter[0] >>> 16) - random[0] & 0xFF & 0xFF);
                p[3] = (byte)((counter[0] >>> 24) - (random[0] & 0xFF) / 2 & 0xFF);
                counter[0] = p[0] & 0xFF | (p[1] & 0xFF) << 8 | (p[2] & 0xFF) << 16 | (p[3] & 0xFF) << 24;
                if (counter[0] < time_count) {
                    return true;
                }
            }
            for (int i = 0; i < 4; ++i) {
                counter[i] = time_count;
                random[i] = (byte)(Game.Random(0, 250) + i);
                p[0] = (byte)(counter[i] + (random[i] & 0xFF) & 0xFF);
                p[1] = (byte)((counter[i] >>> 8) + (random[i] & 0xFF) & 0xFF);
                p[2] = (byte)((counter[i] >>> 16) + (random[i] & 0xFF) & 0xFF);
                p[3] = (byte)((counter[i] >>> 24) + (random[i] & 0xFF) / 2 & 0xFF);
                counter[i] = p[0] & 0xFF | (p[1] & 0xFF) << 8 | (p[2] & 0xFF) << 16 | (p[3] & 0xFF) << 24;
            }
            ByteBuffer buf = ByteBuffer.allocate(20);
            buf.order(ByteOrder.LITTLE_ENDIAN);
            buf.putInt(counter[0]);
            buf.putInt(counter[1]);
            buf.putInt(counter[2]);
            buf.putInt(counter[3]);
            buf.put(random[0]);
            buf.put(random[1]);
            buf.put(random[2]);
            buf.put(random[3]);
            DataOutputStream dos = new DataOutputStream(Files.newOutputStream(fp.toPath(), new OpenOption[0]));
            dos.write(buf.array());
            dos.close();
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static int LoadTimeCounter() {
        try {
            File fp = new File("290.rec");
            if (!fp.exists()) {
                return 0;
            }
            ByteBuffer buf = ByteBuffer.allocate((int)fp.length());
            DataInputStream dis = new DataInputStream(new FileInputStream(fp));
            dis.readFully(buf.array());
            dis.close();
            buf.order(ByteOrder.LITTLE_ENDIAN);
            ((Buffer)buf).position(0);
            int[] counter = new int[4];
            byte[] random = new byte[4];
            byte[] p = new byte[4];
            counter[0] = buf.getInt();
            counter[1] = buf.getInt();
            counter[2] = buf.getInt();
            counter[3] = buf.getInt();
            random[0] = buf.get();
            random[1] = buf.get();
            random[2] = buf.get();
            random[3] = buf.get();
            for (int i = 0; i < 4; ++i) {
                p[0] = (byte)(counter[i] - random[i] & 0xFF & 0xFF);
                p[1] = (byte)((counter[i] >>> 8) - random[i] & 0xFF & 0xFF);
                p[2] = (byte)((counter[i] >>> 16) - random[i] & 0xFF & 0xFF);
                p[3] = (byte)((counter[i] >>> 24) - (random[i] & 0xFF) / 2 & 0xFF);
                counter[i] = p[0] & 0xFF | (p[1] & 0xFF) << 8 | (p[2] & 0xFF) << 16 | (p[3] & 0xFF) << 24;
            }
            if (counter[0] != counter[1] || counter[0] != counter[2]) {
                System.err.printf("Invalid checksum: %08x %08x %08x %08x\n", counter[0], counter[1], counter[2], counter[3]);
                time_count = 0;
                return 0;
            }
            time_count = counter[0];
            return time_count;
        }
        catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static class ARMS_LEVEL {
        public int[] exp;

        public ARMS_LEVEL(int a, int b, int c) {
            this.exp = new int[]{a, b, c};
        }
    }
}
