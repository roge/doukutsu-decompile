/*
 * Decompiled with CFR 0.152.
 */
package jp.studiopixel.doukutsu;

import java.util.Arrays;
import jp.studiopixel.doukutsu.DataLoader;
import jp.studiopixel.doukutsu.Draw;
import jp.studiopixel.doukutsu.NpChar;
import jp.studiopixel.doukutsu.RECT;

public class Map {
    public static MAP_DATA gMap = new MAP_DATA();
    private static final byte[] code_pxma = new byte[]{80, 88, 77};
    private static final RECT rect = new RECT();
    private static final RECT rcSnack = new RECT(256, 48, 272, 64);
    private static char count = '\u0000';

    public static boolean InitMapData2() {
        Map.gMap.data = new byte[307200];
        return true;
    }

    public static boolean LoadMapData2(String path_map) {
        String path = "/" + path_map;
        try {
            DataLoader.DataFile f = DataLoader.load(path);
            byte[] check = new byte[3];
            f.readFully(check);
            if (!Arrays.equals(check, code_pxma)) {
                return false;
            }
            byte _dum = f.readByte();
            Map.gMap.width = f.readShort();
            Map.gMap.length = f.readShort();
            f.readFully(Map.gMap.data, 0, Map.gMap.width * Map.gMap.length);
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static boolean LoadAttributeData(String path_atrb) {
        try {
            DataLoader.DataFile f = DataLoader.load("/" + path_atrb);
            try {
                f.readFully(Map.gMap.atrb);
            }
            catch (Exception exception) {}
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static void EndMapData() {
        Map.gMap.data = null;
    }

    public static void ReleasePartsImage() {
        Draw.ReleaseSurface(2);
    }

    public static char GetAttribute(int x, int y) {
        if (x < 0 || x >= Map.gMap.width || y < 0 || y >= Map.gMap.length) {
            return '\u0000';
        }
        int a = Map.gMap.data[x + y * Map.gMap.width] & 0xFF;
        return (char)(Map.gMap.atrb[a] & 0xFF);
    }

    public static void DeleteMapParts(int x, int y) {
        if (x < 0 || x >= Map.gMap.width || y < 0 || y >= Map.gMap.length) {
            return;
        }
        Map.gMap.data[x + y * Map.gMap.width] = 0;
    }

    public static void ShiftMapParts(int x, int y) {
        if (x < 0 || x >= Map.gMap.width || y < 0 || y >= Map.gMap.length) {
            return;
        }
        int n = x + y * Map.gMap.width;
        Map.gMap.data[n] = (byte)(Map.gMap.data[n] - 1);
    }

    public static boolean ChangeMapParts(int x, int y, byte no) {
        if (Map.gMap.data[x + y * Map.gMap.width] == no) {
            return false;
        }
        Map.gMap.data[x + y * Map.gMap.width] = no;
        for (int i = 0; i < 3; ++i) {
            NpChar.SetNpChar(4, x * 512 * 16, y * 512 * 16, 0, 0, 0, null, 0);
        }
        return true;
    }

    public static void PutStage_Back(int fx, int fy) {
        int put_y;
        int num_x = 21;
        int num_y = 16;
        int put_x = (fx / 512 + 8) / 16;
        for (int j = put_y = (fy / 512 + 8) / 16; j < put_y + num_y; ++j) {
            for (int i = put_x; i < put_x + num_x; ++i) {
                int offset = j * Map.gMap.width + i;
                char atrb = Map.GetAttribute(i, j);
                if (atrb >= ' ') continue;
                int data = Map.gMap.data[offset] & 0xFF;
                Map.rect.left = data % 16 * 16;
                Map.rect.top = data / 16 * 16;
                Map.rect.right = Map.rect.left + 16;
                Map.rect.bottom = Map.rect.top + 16;
                Draw.PutBitmap3(Draw.grcGame, i * 16 - 8 - fx / 512, j * 16 - 8 - fy / 512, rect, 2);
            }
        }
    }

    public static void PutStage_Front(int fx, int fy) {
        int put_y;
        int num_x = 21;
        int num_y = 16;
        int put_x = (fx / 512 + 8) / 16;
        for (int j = put_y = (fy / 512 + 8) / 16; j < put_y + num_y; ++j) {
            for (int i = put_x; i < put_x + num_x; ++i) {
                int offset = j * Map.gMap.width + i;
                char atrb = Map.GetAttribute(i, j);
                if (atrb < '@' || atrb >= '\u0080') continue;
                int data = Map.gMap.data[offset] & 0xFF;
                Map.rect.left = data % 16 * 16;
                Map.rect.top = data / 16 * 16;
                Map.rect.right = Map.rect.left + 16;
                Map.rect.bottom = Map.rect.top + 16;
                Draw.PutBitmap3(Draw.grcGame, i * 16 - 8 - fx / 512, j * 16 - 8 - fy / 512, rect, 2);
                if (atrb != 'C') continue;
                Draw.PutBitmap3(Draw.grcGame, i * 16 - 8 - fx / 512, j * 16 - 8 - fy / 512, rcSnack, 20);
            }
        }
    }

    public static void PutMapDataVector(int fx, int fy) {
        int put_y;
        count = (char)(count + 2);
        int num_x = 21;
        int num_y = 16;
        int put_x = (fx / 512 + 8) / 16;
        for (int j = put_y = (fy / 512 + 8) / 16; j < put_y + num_y; ++j) {
            for (int i = put_x; i < put_x + num_x; ++i) {
                int offset = j * Map.gMap.width + i;
                char atrb = Map.GetAttribute(i, j);
                if (atrb != '\u0080' && atrb != '\u0081' && atrb != '\u0082' && atrb != '\u0083' && atrb != '\u00a0' && atrb != '\u00a1' && atrb != '\u00a2' && atrb != '\u00a3') continue;
                switch (atrb) {
                    case '\u0080': 
                    case '\u00a0': {
                        Map.rect.left = 224 + count % 16;
                        Map.rect.right = Map.rect.left + 16;
                        Map.rect.top = 48;
                        Map.rect.bottom = Map.rect.top + 16;
                        break;
                    }
                    case '\u0081': 
                    case '\u00a1': {
                        Map.rect.left = 224;
                        Map.rect.right = Map.rect.left + 16;
                        Map.rect.top = 48 + count % 16;
                        Map.rect.bottom = Map.rect.top + 16;
                        break;
                    }
                    case '\u0082': 
                    case '\u00a2': {
                        Map.rect.left = 240 - count % 16;
                        Map.rect.right = Map.rect.left + 16;
                        Map.rect.top = 48;
                        Map.rect.bottom = Map.rect.top + 16;
                        break;
                    }
                    case '\u0083': 
                    case '\u00a3': {
                        Map.rect.left = 224;
                        Map.rect.right = Map.rect.left + 16;
                        Map.rect.top = 64 - count % 16;
                        Map.rect.bottom = Map.rect.top + 16;
                    }
                }
                Draw.PutBitmap3(Draw.grcGame, i * 16 - 8 - fx / 512, j * 16 - 8 - fy / 512, rect, 19);
            }
        }
    }

    public static class MAP_DATA {
        public byte[] data;
        public byte[] atrb = new byte[256];
        public short width;
        public short length;
    }
}
