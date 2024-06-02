/*
 * Decompiled with CFR 0.152.
 */
package jp.studiopixel.doukutsu;

import jp.studiopixel.doukutsu.Draw;
import jp.studiopixel.doukutsu.Game;
import jp.studiopixel.doukutsu.KeyControl;
import jp.studiopixel.doukutsu.RECT;

public class Escape {
    public static int Call_Escape() {
        RECT rc = new RECT(0, 128, 208, 144);
        do {
            KeyControl.GetTrg();
            if ((KeyControl.gKeyTrg & 0x8000) != 0) {
                KeyControl.gKeyTrg = 0;
                return 0;
            }
            if ((KeyControl.gKeyTrg & 0x400) != 0) {
                KeyControl.gKeyTrg = 0;
                return 1;
            }
            if ((KeyControl.gKeyTrg & 0x800) != 0) {
                KeyControl.gKeyTrg = 0;
                return 2;
            }
            Draw.CortBox(Draw.grcFull, 0);
            Draw.PutBitmap3(Draw.grcFull, 56, 112, rc, 26);
            Game.PutFramePerSecound();
        } while (Draw.Flip_SystemTask());
        KeyControl.gKeyTrg = 0;
        return 0;
    }
}
