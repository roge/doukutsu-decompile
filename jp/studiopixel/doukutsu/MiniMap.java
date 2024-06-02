/*
 * Decompiled with CFR 0.152.
 */
package jp.studiopixel.doukutsu;

import java.util.Arrays;
import jp.studiopixel.doukutsu.Draw;
import jp.studiopixel.doukutsu.Escape;
import jp.studiopixel.doukutsu.Game;
import jp.studiopixel.doukutsu.KeyControl;
import jp.studiopixel.doukutsu.Map;
import jp.studiopixel.doukutsu.MapName;
import jp.studiopixel.doukutsu.MyChar;
import jp.studiopixel.doukutsu.RECT;
import jp.studiopixel.doukutsu.Stage;

public class MiniMap {
    private static final RECT[] rcLevel = new RECT[]{new RECT(240, 24, 241, 25), new RECT(241, 24, 242, 25), new RECT(242, 24, 243, 25), new RECT(243, 24, 244, 25)};
    public static byte[] gMapping = new byte[128];

    public static void WriteMiniMapLine(int line) {
        for (int x = 0; x < Map.gMap.width; ++x) {
            char a = Map.GetAttribute(x, line);
            if (a == '\u0000') {
                Draw.Surface2Surface(x, line, rcLevel[0], 9, 26);
                continue;
            }
            if (a == 'D' || a == '\u0001' || a == '@' || a == '\u0080' || a == '\u0081' || a == '\u0082' || a == '\u0083' || a == 'Q' || a == 'R' || a == 'U' || a == 'V' || a == '\u0002' || a == '`' || a == 'q' || a == 'r' || a == 'u' || a == 'v' || a == '\u00a0' || a == '\u00a1' || a == '\u00a2' || a == '\u00a3') {
                Draw.Surface2Surface(x, line, rcLevel[1], 9, 26);
                continue;
            }
            if (a == 'C' || a == 'c' || a == 'P' || a == 'S' || a == 'T' || a == 'W' || a == 'p' || a == 's' || a == 't' || a == 'w') {
                Draw.Surface2Surface(x, line, rcLevel[2], 9, 26);
                continue;
            }
            Draw.Surface2Surface(x, line, rcLevel[3], 9, 26);
        }
    }

    public static int MiniMapLoop() {
        int f;
        RECT rcView;
        block21: {
            rcView = new RECT();
            RECT rcMiniMap = new RECT();
            RECT my_rect = new RECT(0, 57, 1, 58);
            int my_x = (MyChar.gMC.x / 512 + 8) / 16;
            int my_y = (MyChar.gMC.y / 512 + 8) / 16;
            for (f = 0; f <= 8; ++f) {
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
                Draw.PutBitmap4(Draw.grcGame, 0, 0, Draw.grcGame, 10);
                rcView.left = 160 - Map.gMap.width * f / 8 / 2;
                rcView.right = 160 + Map.gMap.width * f / 8 / 2;
                rcView.top = 120 - Map.gMap.length * f / 8 / 2;
                rcView.bottom = 120 + Map.gMap.length * f / 8 / 2;
                MapName.PutMapName(true);
                Draw.CortBox(rcView, 0);
                Game.PutFramePerSecound();
                if (Draw.Flip_SystemTask()) continue;
                return 0;
            }
            rcMiniMap.left = 0;
            rcMiniMap.right = Map.gMap.width;
            rcMiniMap.top = 0;
            rcMiniMap.bottom = Map.gMap.length;
            --rcView.left;
            rcView.right = rcView.left + Map.gMap.width + 2;
            --rcView.top;
            rcView.bottom = rcView.top + Map.gMap.length + 2;
            Draw.CortBox2(rcMiniMap, 0, 9);
            int line = 0;
            int my_wait = 0;
            do {
                KeyControl.GetTrg();
                if ((KeyControl.gKeyTrg & (KeyControl.gKeyOk | KeyControl.gKeyCancel)) != 0) break block21;
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
                Draw.PutBitmap4(Draw.grcGame, 0, 0, Draw.grcGame, 10);
                Draw.CortBox(rcView, 0);
                if (line < Map.gMap.length) {
                    MiniMap.WriteMiniMapLine(line);
                    ++line;
                }
                if (line < Map.gMap.length) {
                    MiniMap.WriteMiniMapLine(line);
                    ++line;
                }
                Draw.PutBitmap3(Draw.grcGame, rcView.left + 1, rcView.top + 1, rcMiniMap, 9);
                MapName.PutMapName(true);
                my_wait = (char)(my_wait + 1);
                if (my_wait / 8 % 2 != 0) {
                    Draw.PutBitmap3(Draw.grcGame, my_x + rcView.left + 1, my_y + rcView.top + 1, my_rect, 26);
                }
                Game.PutFramePerSecound();
            } while (Draw.Flip_SystemTask());
            return 0;
        }
        for (f = 8; f >= -1; --f) {
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
            Draw.PutBitmap4(Draw.grcGame, 0, 0, Draw.grcGame, 10);
            rcView.left = 160 - Map.gMap.width * f / 8 / 2;
            rcView.right = 160 + Map.gMap.width * f / 8 / 2;
            rcView.top = 120 - Map.gMap.length * f / 8 / 2;
            rcView.bottom = 120 + Map.gMap.length * f / 8 / 2;
            MapName.PutMapName(true);
            Draw.CortBox(rcView, 0);
            Game.PutFramePerSecound();
            if (Draw.Flip_SystemTask()) continue;
            return 0;
        }
        return 1;
    }

    public static boolean IsMapping() {
        return gMapping[Stage.gStageNo] != 0;
    }

    public static void StartMapping() {
        Arrays.fill(gMapping, (byte)0);
    }

    public static void SetMapping(int a) {
        MiniMap.gMapping[a] = 1;
    }
}
