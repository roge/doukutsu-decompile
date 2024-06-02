/*
 * Decompiled with CFR 0.152.
 */
package jp.studiopixel.doukutsu;

import jp.studiopixel.doukutsu.Draw;
import jp.studiopixel.doukutsu.Escape;
import jp.studiopixel.doukutsu.Game;
import jp.studiopixel.doukutsu.KeyControl;
import jp.studiopixel.doukutsu.RECT;
import jp.studiopixel.doukutsu.Shoot;
import jp.studiopixel.doukutsu.Sound;
import jp.studiopixel.doukutsu.TextScr;

public class ArmsItem {
    public static ARMS[] gArmsData;
    public static ITEM[] gItemData;
    private static char PutCampObject_flash;
    private static final RECT PutCampObject_rcPer;
    private static final RECT PutCampObject_rcNone;
    private static final RECT PutCampObject_rcLv;
    private static final RECT PutCampObject_rcView;
    private static final RECT[] PutCampObject_rcCur1;
    private static final RECT[] PutCampObject_rcCur2;
    private static final RECT PutCampObject_rcTitle1;
    private static final RECT PutCampObject_rcTitle2;
    private static final RECT PutCampObject_rcBoxTop;
    private static final RECT PutCampObject_rcBoxBody;
    private static final RECT PutCampObject_rcBoxBottom;
    private static final RECT CampLoop_rcView;
    public static int gSelectedArms;
    public static int gSelectedItem;
    public static int gCampTitleY;
    public static boolean gCampActive;
    public static int gArmsEnergyX;

    public static void ClearArmsData() {
        gArmsEnergyX = 32;
        for (int i = 0; i < gArmsData.length; ++i) {
            gArmsData[i].clear();
        }
    }

    public static void ClearItemData() {
        for (int i = 0; i < gItemData.length; ++i) {
            gItemData[i].clear();
        }
    }

    public static boolean AddArmsData(int code, int max_num) {
        int i;
        for (i = 0; i < gArmsData.length && ArmsItem.gArmsData[i].code != code && ArmsItem.gArmsData[i].code != 0; ++i) {
        }
        if (i == gArmsData.length) {
            return false;
        }
        if (ArmsItem.gArmsData[i].code == 0) {
            gArmsData[i].clear();
            ArmsItem.gArmsData[i].level = 1;
        }
        ArmsItem.gArmsData[i].code = code;
        ArmsItem.gArmsData[i].max_num += max_num;
        ArmsItem.gArmsData[i].num += max_num;
        if (ArmsItem.gArmsData[i].num > ArmsItem.gArmsData[i].max_num) {
            ArmsItem.gArmsData[i].num = ArmsItem.gArmsData[i].max_num;
        }
        return true;
    }

    public static boolean SubArmsData(int code) {
        int i;
        for (i = 0; i < gArmsData.length && ArmsItem.gArmsData[i].code != code; ++i) {
        }
        if (i == gArmsData.length) {
            return false;
        }
        ++i;
        while (i < gArmsData.length) {
            ArmsItem.gArmsData[i - 1] = gArmsData[i];
            ++i;
        }
        ArmsItem.gArmsData[i - 1].code = 0;
        gSelectedArms = 0;
        return true;
    }

    public static boolean TradeArms(int code1, int code2, int max_num) {
        int i;
        for (i = 0; i < gArmsData.length && ArmsItem.gArmsData[i].code != code1; ++i) {
        }
        if (i == gArmsData.length) {
            return false;
        }
        ArmsItem.gArmsData[i].level = 1;
        ArmsItem.gArmsData[i].code = code2;
        ArmsItem.gArmsData[i].max_num += max_num;
        ArmsItem.gArmsData[i].num += max_num;
        ArmsItem.gArmsData[i].exp = 0;
        return true;
    }

    public static boolean AddItemData(int code) {
        int i;
        for (i = 0; i < gItemData.length && ArmsItem.gItemData[i].code != code && ArmsItem.gItemData[i].code != 0; ++i) {
        }
        if (i == gItemData.length) {
            return false;
        }
        ArmsItem.gItemData[i].code = code;
        return true;
    }

    public static boolean SubItemData(int code) {
        int i;
        for (i = 0; i < gItemData.length && ArmsItem.gItemData[i].code != code; ++i) {
        }
        if (i == gItemData.length) {
            return false;
        }
        ++i;
        while (i < gItemData.length) {
            ArmsItem.gItemData[i - 1] = gItemData[i];
            ++i;
        }
        ArmsItem.gItemData[i - 1].code = 0;
        gSelectedItem = 0;
        return true;
    }

    public static void MoveCampCursor() {
        int arms_num = 0;
        int item_num = 0;
        while (ArmsItem.gArmsData[arms_num].code != 0) {
            ++arms_num;
        }
        while (ArmsItem.gItemData[item_num].code != 0) {
            ++item_num;
        }
        if (arms_num == 0 && item_num == 0) {
            return;
        }
        boolean bChange = false;
        if (!gCampActive) {
            if ((KeyControl.gKeyTrg & KeyControl.gKeyLeft) != 0) {
                --gSelectedArms;
                bChange = true;
            }
            if ((KeyControl.gKeyTrg & KeyControl.gKeyRight) != 0) {
                ++gSelectedArms;
                bChange = true;
            }
            if ((KeyControl.gKeyTrg & (KeyControl.gKeyUp | KeyControl.gKeyDown)) != 0) {
                if (item_num != 0) {
                    gCampActive = true;
                }
                bChange = true;
            }
            if (gSelectedArms < 0) {
                gSelectedArms = arms_num - 1;
            }
            if (gSelectedArms > arms_num - 1) {
                gSelectedArms = 0;
            }
        } else {
            if ((KeyControl.gKeyTrg & KeyControl.gKeyLeft) != 0) {
                gSelectedItem = gSelectedItem % 6 == 0 ? (gSelectedItem += 5) : --gSelectedItem;
                bChange = true;
            }
            if ((KeyControl.gKeyTrg & KeyControl.gKeyRight) != 0) {
                gSelectedItem = gSelectedItem == item_num - 1 ? gSelectedItem / 6 * 6 : (gSelectedItem % 6 == 5 ? (gSelectedItem -= 5) : ++gSelectedItem);
                bChange = true;
            }
            if ((KeyControl.gKeyTrg & KeyControl.gKeyUp) != 0) {
                if (gSelectedItem / 6 == 0) {
                    gCampActive = false;
                } else {
                    gSelectedItem -= 6;
                }
                bChange = true;
            }
            if ((KeyControl.gKeyTrg & KeyControl.gKeyDown) != 0) {
                if (gSelectedItem / 6 == (item_num - 1) / 6) {
                    gCampActive = false;
                } else {
                    gSelectedItem += 6;
                }
                bChange = true;
            }
            if (gSelectedItem >= item_num) {
                gSelectedItem = item_num - 1;
            }
            if (gCampActive && (KeyControl.gKeyTrg & KeyControl.gKeyOk) != 0) {
                TextScr.StartTextScript(6000 + ArmsItem.gItemData[ArmsItem.gSelectedItem].code);
            }
        }
        if (bChange) {
            if (!gCampActive) {
                Sound.PlaySoundObject(4, 1);
                if (arms_num != 0) {
                    TextScr.StartTextScript(1000 + ArmsItem.gArmsData[ArmsItem.gSelectedArms].code);
                } else {
                    TextScr.StartTextScript(1000);
                }
            } else {
                Sound.PlaySoundObject(1, 1);
                if (item_num != 0) {
                    TextScr.StartTextScript(5000 + ArmsItem.gItemData[ArmsItem.gSelectedItem].code);
                } else {
                    TextScr.StartTextScript(5000);
                }
            }
        }
    }

    public static void PutCampObject() {
        int i;
        RECT rcArms = new RECT();
        RECT rcItem = new RECT();
        Draw.PutBitmap3(PutCampObject_rcView, 38, 8, PutCampObject_rcBoxTop, 26);
        for (i = 1; i < 18; ++i) {
            Draw.PutBitmap3(PutCampObject_rcView, 38, 0 + (i + 1) * 8, PutCampObject_rcBoxBody, 26);
        }
        Draw.PutBitmap3(PutCampObject_rcView, 38, 0 + (i + 1) * 8, PutCampObject_rcBoxBottom, 26);
        if (gCampTitleY > 16) {
            --gCampTitleY;
        }
        Draw.PutBitmap3(PutCampObject_rcView, 48, gCampTitleY, PutCampObject_rcTitle1, 26);
        Draw.PutBitmap3(PutCampObject_rcView, 48, gCampTitleY + 52, PutCampObject_rcTitle2, 26);
        PutCampObject_flash = (char)(PutCampObject_flash + '\u0001');
        if (!gCampActive) {
            Draw.PutBitmap3(PutCampObject_rcView, gSelectedArms * 40 + 160 - 112, 24, PutCampObject_rcCur1[PutCampObject_flash / 2 % 2], 26);
        } else {
            Draw.PutBitmap3(PutCampObject_rcView, gSelectedArms * 40 + 160 - 112, 24, PutCampObject_rcCur1[1], 26);
        }
        for (i = 0; i < gArmsData.length && ArmsItem.gArmsData[i].code != 0; ++i) {
            rcArms.left = ArmsItem.gArmsData[i].code % 16 * 16;
            rcArms.right = rcArms.left + 16;
            rcArms.top = ArmsItem.gArmsData[i].code / 16 * 16;
            rcArms.bottom = rcArms.top + 16;
            Draw.PutBitmap3(PutCampObject_rcView, i * 40 + 160 - 112, 24, rcArms, 12);
            Draw.PutBitmap3(PutCampObject_rcView, i * 40 + 160 - 112, 56, PutCampObject_rcPer, 26);
            Draw.PutBitmap3(PutCampObject_rcView, i * 40 + 160 - 112, 40, PutCampObject_rcLv, 26);
            Game.PutNumber4(i * 40 + 160 - 112, 40, ArmsItem.gArmsData[i].level, false);
            if (ArmsItem.gArmsData[i].max_num != 0) {
                Game.PutNumber4(i * 40 + 160 - 112, 48, ArmsItem.gArmsData[i].num, false);
                Game.PutNumber4(i * 40 + 160 - 112, 56, ArmsItem.gArmsData[i].max_num, false);
                continue;
            }
            Draw.PutBitmap3(PutCampObject_rcView, i * 40 + 64, 48, PutCampObject_rcNone, 26);
            Draw.PutBitmap3(PutCampObject_rcView, i * 40 + 64, 56, PutCampObject_rcNone, 26);
        }
        if (gCampActive) {
            Draw.PutBitmap3(PutCampObject_rcView, gSelectedItem % 6 * 32 + 160 - 112, gSelectedItem / 6 * 16 + 120 - 44, PutCampObject_rcCur2[PutCampObject_flash / 2 % 2], 26);
        } else {
            Draw.PutBitmap3(PutCampObject_rcView, gSelectedItem % 6 * 32 + 160 - 112, gSelectedItem / 6 * 16 + 120 - 44, PutCampObject_rcCur2[1], 26);
        }
        for (i = 0; i < gItemData.length && ArmsItem.gItemData[i].code != 0; ++i) {
            rcItem.left = ArmsItem.gItemData[i].code % 8 * 32;
            rcItem.right = rcItem.left + 32;
            rcItem.top = ArmsItem.gItemData[i].code / 8 * 16;
            rcItem.bottom = rcItem.top + 16;
            Draw.PutBitmap3(PutCampObject_rcView, i % 6 * 32 + 160 - 112, i / 6 * 16 + 120 - 44, rcItem, 8);
        }
    }

    public static int CampLoop() {
        String old_script_path;
        block16: {
            old_script_path = TextScr.GetTextScriptPath();
            TextScr.LoadTextScript2("ArmsItem.tsc");
            gCampTitleY = 24;
            gCampActive = false;
            gSelectedItem = 0;
            int arms_num = 0;
            while (ArmsItem.gArmsData[arms_num].code != 0) {
                ++arms_num;
            }
            if (arms_num != 0) {
                TextScr.StartTextScript(1000 + ArmsItem.gArmsData[ArmsItem.gSelectedArms].code);
            } else {
                TextScr.StartTextScript(5000 + ArmsItem.gItemData[ArmsItem.gSelectedItem].code);
            }
            do {
                KeyControl.GetTrg();
                if ((KeyControl.gKeyTrg & 0x8000) != 0) {
                    switch (Escape.Call_Escape()) {
                        case 0: {
                            return 0;
                        }
                        case 2: {
                            return 2;
                        }
                    }
                }
                if ((Game.g_GameFlags & 2) != 0) {
                    ArmsItem.MoveCampCursor();
                }
                switch (TextScr.TextScriptProc()) {
                    case 0: {
                        return 0;
                    }
                    case 2: {
                        return 2;
                    }
                }
                Draw.PutBitmap4(CampLoop_rcView, 0, 0, CampLoop_rcView, 10);
                ArmsItem.PutCampObject();
                TextScr.PutTextScript();
                Game.PutFramePerSecound();
                if (gCampActive) {
                    if ((Game.g_GameFlags & 2) == 0 || (KeyControl.gKeyTrg & (KeyControl.gKeyCancel | KeyControl.gKeyItem)) == 0) continue;
                    TextScr.StopTextScript();
                } else {
                    if ((KeyControl.gKeyTrg & (KeyControl.gKeyOk | KeyControl.gKeyCancel | KeyControl.gKeyItem)) == 0) continue;
                    TextScr.StopTextScript();
                }
                break block16;
            } while (Draw.Flip_SystemTask());
            return 0;
        }
        TextScr.LoadTextScript_Stage(old_script_path);
        gArmsEnergyX = 32;
        return 1;
    }

    public static boolean CheckItem(int a) {
        for (int i = 0; i < 32; ++i) {
            if (ArmsItem.gItemData[i].code != a) continue;
            return true;
        }
        return false;
    }

    public static boolean CheckArms(int a) {
        for (int i = 0; i < 8; ++i) {
            if (ArmsItem.gArmsData[i].code != a) continue;
            return true;
        }
        return false;
    }

    public static boolean UseArmsEnergy(int num) {
        if (ArmsItem.gArmsData[ArmsItem.gSelectedArms].max_num == 0) {
            return true;
        }
        if (ArmsItem.gArmsData[ArmsItem.gSelectedArms].num == 0) {
            return false;
        }
        ArmsItem.gArmsData[ArmsItem.gSelectedArms].num -= num;
        if (ArmsItem.gArmsData[ArmsItem.gSelectedArms].num < 0) {
            ArmsItem.gArmsData[ArmsItem.gSelectedArms].num = 0;
        }
        return true;
    }

    public static boolean ChargeArmsEnergy(int num) {
        ArmsItem.gArmsData[ArmsItem.gSelectedArms].num += num;
        if (ArmsItem.gArmsData[ArmsItem.gSelectedArms].num > ArmsItem.gArmsData[ArmsItem.gSelectedArms].max_num) {
            ArmsItem.gArmsData[ArmsItem.gSelectedArms].num = ArmsItem.gArmsData[ArmsItem.gSelectedArms].max_num;
        }
        return true;
    }

    public static void FullArmsEnergy() {
        for (int a = 0; a < 8; ++a) {
            if (ArmsItem.gArmsData[a].code == 0) continue;
            ArmsItem.gArmsData[a].num = ArmsItem.gArmsData[a].max_num;
        }
    }

    public static int RotationArms() {
        int arms_num = 0;
        while (ArmsItem.gArmsData[arms_num].code != 0) {
            ++arms_num;
        }
        if (arms_num == 0) {
            return 0;
        }
        Shoot.ResetSpurCharge();
        ++gSelectedArms;
        while (gSelectedArms < arms_num && ArmsItem.gArmsData[ArmsItem.gSelectedArms].code == 0) {
            ++gSelectedArms;
        }
        if (gSelectedArms == arms_num) {
            gSelectedArms = 0;
        }
        gArmsEnergyX = 32;
        Sound.PlaySoundObject(4, 1);
        return ArmsItem.gArmsData[ArmsItem.gSelectedArms].code;
    }

    public static int RotationArmsRev() {
        int arms_num = 0;
        while (ArmsItem.gArmsData[arms_num].code != 0) {
            ++arms_num;
        }
        if (arms_num == 0) {
            return 0;
        }
        Shoot.ResetSpurCharge();
        if (--gSelectedArms < 0) {
            gSelectedArms = arms_num - 1;
        }
        while (gSelectedArms < arms_num && ArmsItem.gArmsData[ArmsItem.gSelectedArms].code == 0) {
            --gSelectedArms;
        }
        gArmsEnergyX = 0;
        Sound.PlaySoundObject(4, 1);
        return ArmsItem.gArmsData[ArmsItem.gSelectedArms].code;
    }

    public static void ChangeToFirstArms() {
        gSelectedArms = 0;
        gArmsEnergyX = 32;
        Sound.PlaySoundObject(4, 1);
    }

    static {
        int i;
        gArmsData = new ARMS[8];
        gItemData = new ITEM[32];
        for (i = 0; i < gArmsData.length; ++i) {
            ArmsItem.gArmsData[i] = new ARMS();
        }
        for (i = 0; i < gItemData.length; ++i) {
            ArmsItem.gItemData[i] = new ITEM();
        }
        PutCampObject_rcPer = new RECT(72, 48, 80, 56);
        PutCampObject_rcNone = new RECT(80, 48, 96, 56);
        PutCampObject_rcLv = new RECT(80, 80, 96, 88);
        PutCampObject_rcView = new RECT(0, 0, 320, 240);
        PutCampObject_rcCur1 = new RECT[]{new RECT(0, 88, 40, 128), new RECT(40, 88, 80, 128)};
        PutCampObject_rcCur2 = new RECT[]{new RECT(80, 88, 112, 104), new RECT(80, 104, 112, 120)};
        PutCampObject_rcTitle1 = new RECT(80, 48, 144, 56);
        PutCampObject_rcTitle2 = new RECT(80, 56, 144, 64);
        PutCampObject_rcBoxTop = new RECT(0, 0, 244, 8);
        PutCampObject_rcBoxBody = new RECT(0, 8, 244, 16);
        PutCampObject_rcBoxBottom = new RECT(0, 16, 244, 24);
        CampLoop_rcView = new RECT(0, 0, 320, 240);
        gSelectedArms = 0;
        gSelectedItem = 0;
        gCampTitleY = 0;
        gCampActive = false;
        gArmsEnergyX = 16;
    }

    public static class ARMS {
        int code;
        int level;
        int exp;
        int max_num;
        int num;

        public ARMS() {
            this.clear();
        }

        public ARMS(int code, int level, int exp, int max_num, int num) {
            this.code = code;
            this.level = level;
            this.exp = exp;
            this.max_num = max_num;
            this.num = num;
        }

        public void clear() {
            this.code = 0;
            this.level = 0;
            this.exp = 0;
            this.max_num = 0;
            this.num = 0;
        }

        public void copyFrom(ARMS other) {
            this.code = other.code;
            this.level = other.level;
            this.exp = other.exp;
            this.max_num = other.max_num;
            this.num = other.num;
        }
    }

    public static class ITEM {
        int code;

        public ITEM() {
            this.clear();
        }

        public ITEM(int code) {
            this.code = code;
        }

        public void clear() {
            this.code = 0;
        }

        public void copyFrom(ITEM other) {
            this.code = other.code;
        }
    }
}
