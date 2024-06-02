/*
 * Decompiled with CFR 0.152.
 */
package jp.studiopixel.doukutsu;

import jp.studiopixel.doukutsu.Back;
import jp.studiopixel.doukutsu.Boss;
import jp.studiopixel.doukutsu.Bullet;
import jp.studiopixel.doukutsu.Caret;
import jp.studiopixel.doukutsu.Draw;
import jp.studiopixel.doukutsu.Flash;
import jp.studiopixel.doukutsu.Frame;
import jp.studiopixel.doukutsu.Map;
import jp.studiopixel.doukutsu.MapName;
import jp.studiopixel.doukutsu.MyChar;
import jp.studiopixel.doukutsu.NpChar;
import jp.studiopixel.doukutsu.Organya;
import jp.studiopixel.doukutsu.TextScr;
import jp.studiopixel.doukutsu.ValueView;

public class Stage {
    public static final STAGE_TABLE[] gTMT = new STAGE_TABLE[]{Stage.STAGE_ENTRY("0", "0", 4, "bk0", "Guest", "0", 0, "Null"), Stage.STAGE_ENTRY("Pens", "Pens1", 1, "bkBlue", "Guest", "0", 0, "Arthur's House"), Stage.STAGE_ENTRY("Eggs", "Eggs", 1, "bkGreen", "Eggs1", "Ravil", 0, "Egg Corridor"), Stage.STAGE_ENTRY("EggX", "EggX", 4, "bk0", "Eggs1", "0", 0, "Egg No. 00"), Stage.STAGE_ENTRY("EggIn", "Egg6", 4, "bk0", "Eggs1", "0", 0, "Egg No. 06"), Stage.STAGE_ENTRY("Store", "EggR", 4, "bk0", "Eggs1", "0", 0, "Egg Observation Room"), Stage.STAGE_ENTRY("Weed", "Weed", 1, "bkBlue", "Weed", "0", 0, "Grasstown"), Stage.STAGE_ENTRY("Barr", "Santa", 4, "bk0", "Weed", "0", 0, "Santa's House"), Stage.STAGE_ENTRY("Barr", "Chako", 1, "bkBlue", "Guest", "0", 0, "Chaco's House"), Stage.STAGE_ENTRY("Maze", "MazeI", 4, "bk0", "Maze", "0", 0, "Labyrinth I"), Stage.STAGE_ENTRY("Sand", "Sand", 1, "bkGreen", "Sand", "Omg", 1, "Sand Zone"), Stage.STAGE_ENTRY("Mimi", "Mimi", 1, "bkBlue", "Guest", "0", 0, "Mimiga Village"), Stage.STAGE_ENTRY("Cave", "Cave", 4, "bk0", "Cemet", "0", 0, "First Cave"), Stage.STAGE_ENTRY("Cave", "Start", 4, "bk0", "Cemet", "0", 0, "Start Point"), Stage.STAGE_ENTRY("Mimi", "Barr", 4, "bk0", "Cemet", "Bllg", 0, "Shack"), Stage.STAGE_ENTRY("Mimi", "Pool", 1, "bkBlue", "Guest", "0", 0, "Reservoir"), Stage.STAGE_ENTRY("Mimi", "Cemet", 4, "bk0", "Cemet", "0", 0, "Graveyard"), Stage.STAGE_ENTRY("Mimi", "Plant", 1, "bkGreen", "Plant", "0", 0, "Yamashita Farm"), Stage.STAGE_ENTRY("Store", "Shelt", 4, "bk0", "Eggs1", "0", 0, "Shelter"), Stage.STAGE_ENTRY("Pens", "Comu", 1, "bkBlue", "Guest", "0", 0, "Assembly Hall"), Stage.STAGE_ENTRY("Mimi", "MiBox", 4, "bk0", "0", "0", 0, "Save Point"), Stage.STAGE_ENTRY("Store", "EgEnd1", 4, "bk0", "0", "0", 0, "Side Room"), Stage.STAGE_ENTRY("Store", "Cthu", 4, "bk0", "0", "0", 0, "Cthulhu's Abode"), Stage.STAGE_ENTRY("EggIn", "Egg1", 4, "bk0", "Eggs1", "0", 0, "Egg No. 01"), Stage.STAGE_ENTRY("Pens", "Pens2", 1, "bkBlue", "Guest", "0", 0, "Arthur's House"), Stage.STAGE_ENTRY("Barr", "Malco", 1, "bkBlue", "Weed", "Bllg", 0, "Power Room"), Stage.STAGE_ENTRY("Barr", "WeedS", 1, "bkBlue", "0", "0", 0, "Save Point"), Stage.STAGE_ENTRY("Store", "WeedD", 1, "bkBlue", "0", "0", 0, "Execution Chamber"), Stage.STAGE_ENTRY("Weed", "Frog", 2, "bkGreen", "Weed", "Frog", 2, "Gum"), Stage.STAGE_ENTRY("Sand", "Curly", 4, "bk0", "Sand", "Curly", 0, "Sand Zone Residence"), Stage.STAGE_ENTRY("Pens", "WeedB", 1, "bkBlue", "Ravil", "0", 0, "Grasstown Hut"), Stage.STAGE_ENTRY("River", "Stream", 5, "bkBlue", "Stream", "IronH", 5, "Main Artery"), Stage.STAGE_ENTRY("Pens", "CurlyS", 4, "bk0", "Sand", "Curly", 0, "Small Room"), Stage.STAGE_ENTRY("Barr", "Jenka1", 4, "bk0", "Sand", "Bllg", 0, "Jenka's House"), Stage.STAGE_ENTRY("Sand", "Dark", 1, "bkBlack", "Sand", "0", 0, "Deserted House"), Stage.STAGE_ENTRY("Gard", "Gard", 1, "bkGard", "Toro", "Bllg", 0, "Sand Zone Storehouse"), Stage.STAGE_ENTRY("Barr", "Jenka2", 4, "bk0", "Sand", "Bllg", 0, "Jenka's House"), Stage.STAGE_ENTRY("Sand", "SandE", 1, "bkGreen", "Sand", "Bllg", 0, "Sand Zone"), Stage.STAGE_ENTRY("Maze", "MazeH", 4, "bk0", "Maze", "0", 0, "Labyrinth H"), Stage.STAGE_ENTRY("Maze", "MazeW", 1, "bkMaze", "Maze", "X", 3, "Labyrinth W"), Stage.STAGE_ENTRY("Maze", "MazeO", 4, "bk0", "Guest", "0", 0, "Camp"), Stage.STAGE_ENTRY("Maze", "MazeD", 4, "bk0", "Guest", "Dark", 0, "Clinic Ruins"), Stage.STAGE_ENTRY("Store", "MazeA", 4, "bk0", "Maze", "0", 0, "Labyrinth Shop"), Stage.STAGE_ENTRY("Maze", "MazeB", 1, "bkBlue", "Maze", "0", 0, "Labyrinth B"), Stage.STAGE_ENTRY("Maze", "MazeS", 2, "bkGray", "Maze", "Bllg", 0, "Boulder Chamber"), Stage.STAGE_ENTRY("Maze", "MazeM", 1, "bkRed", "Maze", "0", 0, "Labyrinth M"), Stage.STAGE_ENTRY("Cave", "Drain", 3, "bkWater", "Cemet", "0", 0, "Dark Place"), Stage.STAGE_ENTRY("Almond", "Almond", 3, "bkWater", "Cemet", "Almo1", 4, "Core"), Stage.STAGE_ENTRY("River", "River", 2, "bkGreen", "Weed", "0", 0, "Waterway"), Stage.STAGE_ENTRY("Eggs", "Eggs2", 1, "bkGreen", "Eggs2", "0", 0, "Egg Corridor?"), Stage.STAGE_ENTRY("Store", "Cthu2", 4, "bk0", "Eggs1", "0", 0, "Cthulhu's Abode?"), Stage.STAGE_ENTRY("Store", "EggR2", 4, "bk0", "Eggs1", "TwinD", 6, "Egg Observation Room?"), Stage.STAGE_ENTRY("EggX", "EggX2", 4, "bk0", "Eggs1", "0", 0, "Egg No. 00"), Stage.STAGE_ENTRY("Oside", "Oside", 6, "bkMoon", "Moon", "0", 0, "Outer Wall"), Stage.STAGE_ENTRY("Store", "EgEnd2", 4, "bk0", "Eggs1", "0", 0, "Side Room"), Stage.STAGE_ENTRY("Store", "Itoh", 2, "bkBlue", "Guest", "0", 0, "Storehouse"), Stage.STAGE_ENTRY("Cent", "Cent", 1, "bkGreen", "Guest", "Cent", 0, "Plantation"), Stage.STAGE_ENTRY("Jail", "Jail1", 4, "bk0", "Guest", "Cent", 0, "Jail No. 1"), Stage.STAGE_ENTRY("Jail", "Momo", 4, "bk0", "Guest", "0", 0, "Hideout"), Stage.STAGE_ENTRY("Jail", "Lounge", 4, "bk0", "Guest", "0", 0, "Rest Area"), Stage.STAGE_ENTRY("Store", "CentW", 4, "bk0", "Guest", "Cent", 0, "Teleporter"), Stage.STAGE_ENTRY("Store", "Jail2", 4, "bk0", "Guest", "Cent", 0, "Jail No. 2"), Stage.STAGE_ENTRY("White", "Blcny1", 7, "bkFog", "Ravil", "Heri", 0, "Balcony"), Stage.STAGE_ENTRY("Jail", "Priso1", 4, "bkGray", "Red", "0", 0, "Final Cave"), Stage.STAGE_ENTRY("White", "Ring1", 7, "bkFog", "Guest", "Miza", 0, "Throne Room"), Stage.STAGE_ENTRY("White", "Ring2", 7, "bkFog", "Guest", "Dr", 0, "The King's Table"), Stage.STAGE_ENTRY("Pens", "Prefa1", 4, "bk0", "0", "0", 0, "Prefab Building"), Stage.STAGE_ENTRY("Jail", "Priso2", 4, "bkGray", "Red", "0", 0, "Last Cave (Hidden)"), Stage.STAGE_ENTRY("White", "Ring3", 4, "bk0", "Miza", "Almo2", 7, "Black Space"), Stage.STAGE_ENTRY("Pens", "Little", 2, "bkBlue", "Guest", "0", 0, "Little House"), Stage.STAGE_ENTRY("White", "Blcny2", 7, "bkFog", "Ravil", "Heri", 0, "Balcony"), Stage.STAGE_ENTRY("Fall", "Fall", 1, "bkFall", "Guest", "Heri", 0, "Fall"), Stage.STAGE_ENTRY("White", "Kings", 4, "bk0", "Kings", "0", 0, "u"), Stage.STAGE_ENTRY("Pens", "Pixel", 1, "bkBlue", "Guest", "0", 0, "Waterway Cabin"), Stage.STAGE_ENTRY("Maze", "e_Maze", 1, "bkMaze", "Guest", "Maze", 3, ""), Stage.STAGE_ENTRY("Barr", "e_Jenk", 4, "bk0", "Sand", "Bllg", 0, ""), Stage.STAGE_ENTRY("Barr", "e_Malc", 1, "bkBlue", "Weed", "Bllg", 0, ""), Stage.STAGE_ENTRY("Mimi", "e_Ceme", 4, "bk0", "Plant", "0", 0, ""), Stage.STAGE_ENTRY("Fall", "e_Sky", 1, "bkFall", "Guest", "Heri", 0, ""), Stage.STAGE_ENTRY("Pens", "Prefa2", 4, "bk0", "0", "0", 0, "Prefab House"), Stage.STAGE_ENTRY("Hell", "Hell1", 2, "bkRed", "Hell", "0", 0, "Sacred Ground - B1"), Stage.STAGE_ENTRY("Hell", "Hell2", 2, "bkRed", "Hell", "0", 0, "Sacred Ground - B2"), Stage.STAGE_ENTRY("Hell", "Hell3", 1, "bkRed", "Hell", "Press", 8, "Sacred Ground - B3"), Stage.STAGE_ENTRY("Cave", "Mapi", 2, "bk0", "Cemet", "0", 0, "Storage"), Stage.STAGE_ENTRY("Hell", "Hell4", 4, "bk0", "Hell", "0", 0, "Passage?"), Stage.STAGE_ENTRY("Hell", "Hell42", 4, "bk0", "Hell", "Press", 8, "Passage?"), Stage.STAGE_ENTRY("Hell", "Statue", 1, "bkBlue", "0", "Cent", 0, "Statue Chamber"), Stage.STAGE_ENTRY("Hell", "Ballo1", 2, "bkBlue", "Priest", "Ballos", 9, "Seal Chamber"), Stage.STAGE_ENTRY("White", "Ostep", 7, "bkFog", "0", "0", 0, "Corridor"), Stage.STAGE_ENTRY("Labo", "e_Labo", 4, "bk0", "Guest", "0", 0, ""), Stage.STAGE_ENTRY("Cave", "Pole", 4, "bk0", "Guest", "0", 0, "Hermit Gunsmith"), Stage.STAGE_ENTRY("0", "Island", 4, "bk0", "Island", "0", 0, ""), Stage.STAGE_ENTRY("Hell", "Ballo2", 2, "bkBlue", "Priest", "Bllg", 9, "Seal Chamber"), Stage.STAGE_ENTRY("White", "e_Blcn", 7, "bkFog", "Miza", "0", 9, ""), Stage.STAGE_ENTRY("Oside", "Clock", 6, "bkMoon", "Moon", "0", 0, "Clock Room")};
    public static final String[] gMusicTable = new String[]{"XXXX", "WANPAKU", "ANZEN", "GAMEOVER", "GRAVITY", "WEED", "MDOWN2", "FIREEYE", "VIVI", "MURA", "FANFALE1", "GINSUKE", "CEMETERY", "PLANT", "KODOU", "FANFALE3", "FANFALE2", "DR", "ESCAPE", "JENKA", "MAZE", "ACCESS", "IRONH", "GRAND", "CURLY", "OSIDE", "REQUIEM", "WANPAK2", "QUIET", "LASTCAVE", "BALCONY", "LASTBTL", "LASTBT3", "ENDING", "ZONBIE", "BDOWN", "HELL", "JENKA2", "MARINE", "BALLOS", "TOROKO", "WHITE"};
    public static int gStageNo = 0;
    public static int gMusicNo = 0;
    public static int gOldPos = 0;
    public static int gOldNo = 0;

    private static STAGE_TABLE STAGE_ENTRY(String parts, String map, int bkType, String back, String npc, String boss, int boss_no, String name) {
        STAGE_TABLE entry = new STAGE_TABLE();
        entry.parts = parts;
        entry.map = map;
        entry.bkType = bkType;
        entry.back = back;
        entry.npc = npc;
        entry.boss = boss;
        entry.boss_no = (byte)boss_no;
        entry.name = name;
        return entry;
    }

    public static boolean TransferStage(int no, int w, int x, int y) {
        boolean bError = false;
        MyChar.SetMyCharPosition(x * 16 * 512, y * 16 * 512);
        String path_dir = "Stage";
        String path = path_dir + "/Prt" + Stage.gTMT[no].parts;
        if (!Draw.ReloadBitmap_File(path, 2)) {
            bError = true;
        }
        if (!Map.LoadAttributeData(path = path_dir + '/' + Stage.gTMT[no].parts + ".pxa")) {
            bError = true;
        }
        if (!Map.LoadMapData2(path = path_dir + '/' + Stage.gTMT[no].map + ".pxm")) {
            bError = true;
        }
        if (!NpChar.LoadEvent(path = path_dir + '/' + Stage.gTMT[no].map + ".pxe")) {
            bError = true;
        }
        if (!TextScr.LoadTextScript_Stage(path = path_dir + '/' + Stage.gTMT[no].map + ".tsc")) {
            bError = true;
        }
        if (!Back.InitBack(path = Stage.gTMT[no].back, Stage.gTMT[no].bkType)) {
            bError = true;
        }
        if (!Draw.ReloadBitmap_File(path = (path_dir = "Npc") + "/Npc" + Stage.gTMT[no].npc, 21)) {
            bError = true;
        }
        if (!Draw.ReloadBitmap_File(path = path_dir + "/Npc" + Stage.gTMT[no].boss, 22)) {
            bError = true;
        }
        if (bError) {
            return false;
        }
        MapName.ReadyMapName(Stage.gTMT[no].name);
        TextScr.StartTextScript(w);
        Frame.SetFrameMyChar();
        Bullet.ClearBullet();
        Caret.InitCaret();
        ValueView.ClearValueView();
        Frame.ResetQuake();
        Boss.InitBossChar(Stage.gTMT[no].boss_no);
        Flash.ResetFlash();
        gStageNo = no;
        return true;
    }

    public static void ChangeMusic(int no) {
        if (no != 0 && no == gMusicNo) {
            return;
        }
        gOldPos = Organya.GetOrganyaPosition();
        gOldNo = gMusicNo;
        Organya.StopOrganyaMusic();
        Organya.LoadOrganya(gMusicTable[no].toLowerCase() + ".org");
        Organya.ChangeOrganyaVolume(100);
        Organya.SetOrganyaPosition(0);
        Organya.PlayOrganyaMusic();
        gMusicNo = no;
    }

    public static void ReCallMusic() {
        Organya.StopOrganyaMusic();
        Organya.LoadOrganya(gMusicTable[gOldNo].toLowerCase() + ".org");
        Organya.SetOrganyaPosition(gOldPos);
        Organya.ChangeOrganyaVolume(100);
        Organya.PlayOrganyaMusic();
        gMusicNo = gOldNo;
    }

    public static class STAGE_TABLE {
        String parts;
        String map;
        int bkType;
        String back;
        String npc;
        String boss;
        byte boss_no;
        String name;
    }
}
