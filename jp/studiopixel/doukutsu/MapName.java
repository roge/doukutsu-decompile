/*
 * Decompiled with CFR 0.152.
 */
package jp.studiopixel.doukutsu;

import jp.studiopixel.doukutsu.Draw;
import jp.studiopixel.doukutsu.RECT;
import jp.studiopixel.doukutsu.WcWidth;

public class MapName {
    private static final RECT rc = new RECT(0, 0, 160, 12);
    public static MAP_NAME gMapName = new MAP_NAME();

    public static void ReadyMapName(String str) {
        MapName.gMapName.flag = false;
        MapName.gMapName.wait = 0;
        MapName.gMapName.name = str.equals("u") ? "  Studio Pixel presents" : str;
        int a = WcWidth.ofString(MapName.gMapName.name);
        Draw.CortBox2(rc, 0, 13);
        Draw.PutText2((160 - a * 6) / 2 + 6, 1, MapName.gMapName.name, 0x110022, 13);
        Draw.PutText2((160 - a * 6) / 2 + 6, 0, MapName.gMapName.name, 0xFFFFFE, 13);
    }

    public static void PutMapName(boolean bMini) {
        if (bMini) {
            RECT rcBack = new RECT();
            rcBack.left = 0;
            rcBack.right = 320;
            rcBack.top = 7;
            rcBack.bottom = 24;
            Draw.CortBox(rcBack, 0);
            Draw.PutBitmap3(Draw.grcGame, 74, 10, rc, 13);
        } else if (MapName.gMapName.flag) {
            Draw.PutBitmap3(Draw.grcGame, 74, 80, rc, 13);
            if (++MapName.gMapName.wait > 160) {
                MapName.gMapName.flag = false;
            }
        }
    }

    public static void StartMapName() {
        MapName.gMapName.flag = true;
        MapName.gMapName.wait = 0;
    }

    public static void RestoreMapName() {
        int a = WcWidth.ofString(MapName.gMapName.name);
        Draw.CortBox2(rc, 0, 13);
        Draw.PutText2((160 - a * 6) / 2 + 6, 1, MapName.gMapName.name, 0x110022, 13);
        Draw.PutText2((160 - a * 6) / 2 + 6, 0, MapName.gMapName.name, 0xFFFFFE, 13);
    }

    public static class MAP_NAME {
        boolean flag = false;
        int wait = 0;
        String name;
    }
}
