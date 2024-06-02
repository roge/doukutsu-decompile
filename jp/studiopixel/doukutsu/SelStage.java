/*
 * Decompiled with CFR 0.152.
 */
package jp.studiopixel.doukutsu;

import jp.studiopixel.doukutsu.Draw;
import jp.studiopixel.doukutsu.Escape;
import jp.studiopixel.doukutsu.Game;
import jp.studiopixel.doukutsu.KeyControl;
import jp.studiopixel.doukutsu.RECT;
import jp.studiopixel.doukutsu.Sound;
import jp.studiopixel.doukutsu.TextScr;

public class SelStage {
    public static PERMIT_STAGE[] gPermitStage = new PERMIT_STAGE[8];
    public static int gSelectedStage;
    public static int gStageSelectTitleY;
    private static int flash;

    public static void ClearPermitStage() {
        for (PERMIT_STAGE s : gPermitStage) {
            s.clear();
        }
    }

    public static boolean AddPermitStage(int index, int event) {
        int i;
        for (i = 0; i < 8 && SelStage.gPermitStage[i].index != index && SelStage.gPermitStage[i].index != 0; ++i) {
        }
        if (i == 8) {
            return false;
        }
        SelStage.gPermitStage[i].index = index;
        SelStage.gPermitStage[i].event = event;
        return true;
    }

    public static boolean SubPermitStage(int index) {
        int i;
        for (i = 0; i < 8 && SelStage.gPermitStage[i].index != index; ++i) {
        }
        if (i == 8) {
            return false;
        }
        ++i;
        while (i < 8) {
            SelStage.gPermitStage[i - 1] = gPermitStage[i];
            ++i;
        }
        SelStage.gPermitStage[i - 1].index = 0;
        SelStage.gPermitStage[i - 1].event = 0;
        return true;
    }

    public static void MoveStageSelectCursor() {
        int stage_num = 0;
        while (SelStage.gPermitStage[stage_num].index != 0) {
            ++stage_num;
        }
        if (stage_num == 0) {
            return;
        }
        if ((KeyControl.gKeyTrg & KeyControl.gKeyLeft) != 0) {
            --gSelectedStage;
        }
        if ((KeyControl.gKeyTrg & KeyControl.gKeyRight) != 0) {
            ++gSelectedStage;
        }
        if (gSelectedStage < 0) {
            gSelectedStage = stage_num - 1;
        }
        if (gSelectedStage > stage_num - 1) {
            gSelectedStage = 0;
        }
        if ((KeyControl.gKeyTrg & (KeyControl.gKeyLeft | KeyControl.gKeyRight)) != 0) {
            TextScr.StartTextScript(SelStage.gPermitStage[SelStage.gSelectedStage].index + 1000);
        }
        if ((KeyControl.gKeyTrg & (KeyControl.gKeyLeft | KeyControl.gKeyRight)) != 0) {
            Sound.PlaySoundObject(1, 1);
        }
    }

    public static void PutStageSelectObject() {
        int i = 0;
        RECT rcStage = new RECT();
        RECT rcView = new RECT(0, 0, 320, 240);
        RECT[] rcCur = new RECT[]{new RECT(80, 88, 112, 104), new RECT(80, 104, 112, 120)};
        RECT rcTitle1 = new RECT(80, 64, 144, 72);
        int stage_x = 0;
        if (gStageSelectTitleY > 46) {
            --gStageSelectTitleY;
        }
        Draw.PutBitmap3(rcView, 128, gStageSelectTitleY, rcTitle1, 26);
        int stage_num = 0;
        while (SelStage.gPermitStage[stage_num].index != 0) {
            ++stage_num;
        }
        ++flash;
        if (stage_num != 0) {
            stage_x = (320 - stage_num * 40) / 2;
            Draw.PutBitmap3(rcView, stage_x + gSelectedStage * 40, 64, rcCur[flash / 2 % 2], 26);
            for (i = 0; i < 8 && SelStage.gPermitStage[i].index != 0; ++i) {
                rcStage.left = SelStage.gPermitStage[i].index % 8 * 32;
                rcStage.right = rcStage.left + 32;
                rcStage.top = SelStage.gPermitStage[i].index / 8 * 16;
                rcStage.bottom = rcStage.top + 16;
                Draw.PutBitmap3(rcView, stage_x + i * 40, 64, rcStage, 14);
            }
        }
    }

    public static int StageSelectLoop(int[] p_event) {
        String old_script_path;
        block11: {
            RECT rcView = new RECT(0, 0, 320, 240);
            gSelectedStage = 0;
            Draw.BackupSurface(10, Draw.grcFull);
            old_script_path = TextScr.GetTextScriptPath();
            TextScr.LoadTextScript2("StageSelect.tsc");
            gStageSelectTitleY = 54;
            TextScr.StartTextScript(SelStage.gPermitStage[SelStage.gSelectedStage].index + 1000);
            do {
                KeyControl.GetTrg();
                if ((KeyControl.gKey & 0x8000) != 0) {
                    switch (Escape.Call_Escape()) {
                        case 0: {
                            return 0;
                        }
                        case 2: {
                            return 2;
                        }
                    }
                }
                SelStage.MoveStageSelectCursor();
                switch (TextScr.TextScriptProc()) {
                    case 0: {
                        return 0;
                    }
                    case 2: {
                        return 2;
                    }
                }
                Draw.PutBitmap3(rcView, 0, 0, rcView, 10);
                SelStage.PutStageSelectObject();
                TextScr.PutTextScript();
                if ((KeyControl.gKeyTrg & KeyControl.gKeyOk) != 0) break block11;
                if ((KeyControl.gKeyTrg & KeyControl.gKeyCancel) != 0) {
                    TextScr.StopTextScript();
                    TextScr.LoadTextScript_Stage(old_script_path);
                    p_event[0] = 0;
                    return 1;
                }
                Game.PutFramePerSecound();
            } while (Draw.Flip_SystemTask());
            return 0;
        }
        TextScr.StopTextScript();
        TextScr.LoadTextScript_Stage(old_script_path);
        p_event[0] = SelStage.gPermitStage[SelStage.gSelectedStage].event;
        return 1;
    }

    static {
        for (int i = 0; i < gPermitStage.length; ++i) {
            SelStage.gPermitStage[i] = new PERMIT_STAGE();
        }
        gSelectedStage = 0;
        gStageSelectTitleY = 0;
        flash = 0;
    }

    public static class PERMIT_STAGE {
        int index;
        int event;

        public void clear() {
            this.index = 0;
            this.event = 0;
        }

        public void copyFrom(PERMIT_STAGE other) {
            this.index = other.index;
            this.event = other.event;
        }
    }
}
