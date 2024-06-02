/*
 * Decompiled with CFR 0.152.
 */
package jp.studiopixel.doukutsu;

import java.io.File;
import javax.swing.JOptionPane;
import jp.studiopixel.doukutsu.ArmsItem;
import jp.studiopixel.doukutsu.Back;
import jp.studiopixel.doukutsu.Boss;
import jp.studiopixel.doukutsu.BossLife;
import jp.studiopixel.doukutsu.BulHit;
import jp.studiopixel.doukutsu.Bullet;
import jp.studiopixel.doukutsu.Caret;
import jp.studiopixel.doukutsu.Config;
import jp.studiopixel.doukutsu.Draw;
import jp.studiopixel.doukutsu.Ending;
import jp.studiopixel.doukutsu.Escape;
import jp.studiopixel.doukutsu.Fade;
import jp.studiopixel.doukutsu.Flags;
import jp.studiopixel.doukutsu.Flash;
import jp.studiopixel.doukutsu.Frame;
import jp.studiopixel.doukutsu.GenericLoad;
import jp.studiopixel.doukutsu.KeyControl;
import jp.studiopixel.doukutsu.Map;
import jp.studiopixel.doukutsu.MapName;
import jp.studiopixel.doukutsu.MiniMap;
import jp.studiopixel.doukutsu.MyChar;
import jp.studiopixel.doukutsu.MycHit;
import jp.studiopixel.doukutsu.MycParam;
import jp.studiopixel.doukutsu.NpChar;
import jp.studiopixel.doukutsu.NpcHit;
import jp.studiopixel.doukutsu.NpcTbl;
import jp.studiopixel.doukutsu.Organya;
import jp.studiopixel.doukutsu.Profile;
import jp.studiopixel.doukutsu.RECT;
import jp.studiopixel.doukutsu.SelStage;
import jp.studiopixel.doukutsu.Shoot;
import jp.studiopixel.doukutsu.Sound;
import jp.studiopixel.doukutsu.Stage;
import jp.studiopixel.doukutsu.Star;
import jp.studiopixel.doukutsu.TextScr;
import jp.studiopixel.doukutsu.Triangle;
import jp.studiopixel.doukutsu.ValueView;

public class Game {
    public static final int DIR_LEFT = 0;
    public static final int DIR_UP = 1;
    public static final int DIR_RIGHT = 2;
    public static final int DIR_DOWN = 3;
    public static final int DIR_AUTO = 4;
    public static final int DIR_OTHER = 5;
    public static int[] gJoystickButtonTable = new int[8];
    private static boolean bFPS = false;
    public static boolean bActive = true;
    public static int g_GameFlags = 0;
    public static int gCounter = 0;
    private static long next = 1L;
    private static boolean CountFramePerSecound_first = true;
    private static int CountFramePerSecound_max_count = 0;
    private static int CountFramePerSecound_count = 0;
    private static long CountFramePerSecound_wait = 0L;
    private static final RECT PutNumber4_rcClient = new RECT(0, 0, 320, 240);
    private static final RECT[] PutNumber4_rect = new RECT[]{new RECT(0, 56, 8, 64), new RECT(8, 56, 16, 64), new RECT(16, 56, 24, 64), new RECT(24, 56, 32, 64), new RECT(32, 56, 40, 64), new RECT(40, 56, 48, 64), new RECT(48, 56, 56, 64), new RECT(56, 56, 64, 64), new RECT(64, 56, 72, 64), new RECT(72, 56, 80, 64)};
    private static final int[] PutNumber4_tbl = new int[]{1000, 100, 10, 1};
    private static boolean bContinue = false;
    private static int mainWidth;
    private static int mainHeight;
    private static int mainMag;

    public static int msvc_rand() {
        next = next * 214013L + 2531011L;
        return (int)(next >>> 16 & 0x7FFFL);
    }

    public static void msvc_srand(int seed) {
        next = (long)seed & 0xFFFFFFFFL;
    }

    public static int Random(int min, int max) {
        int range = max - min + 1;
        return Game.msvc_rand() % range + min;
    }

    public static void WindowFocusCallback(boolean focus) {
        if (focus) {
            Game.ActiveWindow();
        } else {
            Game.InactiveWindow();
        }
    }

    public static void InactiveWindow() {
        if (bActive) {
            bActive = false;
            Organya.StopOrganyaMusic();
            MyChar.SleepNoise();
        }
        Sound.PlaySoundObject(7, 0);
    }

    public static void ActiveWindow() {
        if (!bActive) {
            bActive = true;
            Organya.StopOrganyaMusic();
            Organya.PlayOrganyaMusic();
            MyChar.ResetNoise();
        }
        Sound.PlaySoundObject(7, -1);
    }

    private static int CountFramePerSecound() {
        if (CountFramePerSecound_first) {
            CountFramePerSecound_wait = System.nanoTime();
            CountFramePerSecound_first = false;
        }
        long current_tick = System.nanoTime();
        ++CountFramePerSecound_count;
        if (CountFramePerSecound_wait + 1000000000L <= current_tick) {
            CountFramePerSecound_wait += 1000000000L;
            CountFramePerSecound_max_count = CountFramePerSecound_count;
            CountFramePerSecound_count = 0;
        }
        return CountFramePerSecound_max_count;
    }

    public static void PutFramePerSecound() {
        if (bFPS) {
            int fps = Game.CountFramePerSecound();
            Game.PutNumber4(280, 8, fps, false);
        }
    }

    public static void PutNumber4(int x, int y, int value, boolean bZero) {
        if (value > 9999) {
            value = 9999;
        }
        int sw = 0;
        for (int offset = 0; offset < 4; ++offset) {
            int a = 0;
            while (value >= PutNumber4_tbl[offset]) {
                value -= PutNumber4_tbl[offset];
                ++a;
                ++sw;
            }
            if ((!bZero || offset != 2) && sw == 0 && offset != 3) continue;
            Draw.PutBitmap3(PutNumber4_rcClient, x + 8 * offset, y, PutNumber4_rect[a], 26);
        }
    }

    public static int ModeOpening() {
        NpChar.InitNpChar();
        Caret.InitCaret();
        Star.InitStar();
        Fade.InitFade();
        Flash.InitFlash();
        BossLife.InitBossLife();
        Stage.ChangeMusic(0);
        Stage.TransferStage(72, 100, 3, 3);
        Frame.SetFrameTargetMyChar(16);
        Fade.SetFadeMask();
        Draw.grcGame.left = 0;
        g_GameFlags = 3;
        MyChar.CutNoise();
        long wait = 0L;
        while (wait < 500L) {
            ++wait;
            KeyControl.GetTrg();
            if ((KeyControl.gKey & 0x8000) != 0) {
                switch (Escape.Call_Escape()) {
                    case 0: {
                        return 0;
                    }
                    case 2: {
                        return 1;
                    }
                }
            }
            if ((KeyControl.gKey & KeyControl.gKeyOk) != 0) break;
            NpChar.ActNpChar();
            Boss.ActBossChar();
            Back.ActBack();
            MycHit.ResetMyCharFlag();
            MycHit.HitMyCharMap();
            MycHit.HitMyCharNpChar();
            MycHit.HitMyCharBoss();
            NpcHit.HitNpCharMap();
            Boss.HitBossMap();
            Boss.HitBossBullet();
            Caret.ActCaret();
            Frame.MoveFrame3();
            Fade.ProcFade();
            Draw.CortBox(Draw.grcFull, 0);
            int frame_x = Frame.gFrame.x;
            int frame_y = Frame.gFrame.y;
            Back.PutBack(frame_x, frame_y);
            Map.PutStage_Back(frame_x, frame_y);
            Boss.PutBossChar(frame_x, frame_y);
            NpChar.PutNpChar(frame_x, frame_y);
            Map.PutMapDataVector(frame_x, frame_y);
            Map.PutStage_Front(frame_x, frame_y);
            Back.PutFront(frame_x, frame_y);
            Caret.PutCaret(frame_x, frame_y);
            Fade.PutFade();
            switch (TextScr.TextScriptProc()) {
                case 0: {
                    return 0;
                }
                case 2: {
                    return 1;
                }
            }
            MapName.PutMapName(false);
            TextScr.PutTextScript();
            Game.PutFramePerSecound();
            if (!Draw.Flip_SystemTask()) {
                return 0;
            }
            ++gCounter;
        }
        wait = System.nanoTime();
        while (System.nanoTime() < wait + 500000000L) {
            Draw.CortBox(Draw.grcGame, 0);
            Game.PutFramePerSecound();
            if (Draw.Flip_SystemTask()) continue;
            return 0;
        }
        return 2;
    }

    public static int ModeTitle() {
        long wait;
        block30: {
            RECT rcTitle = new RECT(0, 0, 144, 40);
            RECT rcPixel = new RECT(0, 0, 160, 16);
            RECT rcNew = new RECT(144, 0, 192, 16);
            RECT rcContinue = new RECT(144, 16, 192, 32);
            RECT rcVersion = new RECT(152, 80, 208, 88);
            RECT rcPeriod = new RECT(152, 88, 208, 96);
            RECT[] rcMyChar = new RECT[]{new RECT(0, 16, 16, 32), new RECT(16, 16, 32, 32), new RECT(0, 16, 16, 32), new RECT(32, 16, 48, 32)};
            RECT[] rcCurly = new RECT[]{new RECT(0, 112, 16, 128), new RECT(16, 112, 32, 128), new RECT(0, 112, 16, 128), new RECT(32, 112, 48, 128)};
            RECT[] rcToroko = new RECT[]{new RECT(64, 80, 80, 96), new RECT(80, 80, 96, 96), new RECT(64, 80, 80, 96), new RECT(96, 80, 112, 96)};
            RECT[] rcKing = new RECT[]{new RECT(224, 48, 240, 64), new RECT(288, 48, 304, 64), new RECT(224, 48, 240, 64), new RECT(304, 48, 320, 64)};
            RECT[] rcSu = new RECT[]{new RECT(0, 16, 16, 32), new RECT(32, 16, 48, 32), new RECT(0, 16, 16, 32), new RECT(48, 16, 64, 32)};
            wait = 0L;
            int anime = 0;
            int char_type = 0;
            int time_counter = 0;
            int back_color = 0x202020;
            Caret.InitCaret();
            Star.InitStar();
            MyChar.CutNoise();
            RECT char_rc = new RECT();
            int char_y = 0;
            int char_surf = 0;
            int v1 = 1;
            int v2 = 0;
            int v3 = 0;
            int v4 = 6;
            bContinue = Profile.IsProfile();
            time_counter = MycParam.LoadTimeCounter();
            if (time_counter != 0 && time_counter < 18000) {
                char_type = 1;
            }
            if (time_counter != 0 && time_counter < 15000) {
                char_type = 2;
            }
            if (time_counter != 0 && time_counter < 12000) {
                char_type = 3;
            }
            if (time_counter != 0 && time_counter < 9000) {
                char_type = 4;
            }
            if (char_type == 1) {
                Stage.ChangeMusic(36);
            } else if (char_type == 2) {
                Stage.ChangeMusic(40);
            } else if (char_type == 3) {
                Stage.ChangeMusic(41);
            } else if (char_type == 4) {
                Stage.ChangeMusic(2);
            } else {
                Stage.ChangeMusic(24);
            }
            Draw.grcGame.left = 0;
            g_GameFlags = 0;
            MyChar.gMC.equip |= 0x100;
            do {
                if (wait < 10L) {
                    ++wait;
                }
                KeyControl.GetTrg();
                if (wait >= 10L && (KeyControl.gKeyTrg & KeyControl.gKeyOk) != 0) break block30;
                if ((KeyControl.gKey & 0x8000) != 0) {
                    switch (Escape.Call_Escape()) {
                        case 0: {
                            return 0;
                        }
                        case 2: {
                            return 1;
                        }
                    }
                }
                if ((KeyControl.gKeyTrg & (KeyControl.gKeyUp | KeyControl.gKeyDown)) != 0) {
                    Sound.PlaySoundObject(1, 1);
                    bContinue = !bContinue;
                }
                Caret.ActCaret();
                if (++anime >= 40) {
                    anime = 0;
                }
                Draw.CortBox(Draw.grcGame, back_color);
                Draw.PutBitmap3(Draw.grcGame, 100, 216, rcVersion, 26);
                Draw.PutBitmap3(Draw.grcGame, 156, 216, rcPeriod, 26);
                Game.PutNumber4(140, 216, v1, false);
                Game.PutNumber4(156, 216, v2, false);
                Game.PutNumber4(172, 216, v3, false);
                Game.PutNumber4(188, 216, v4, false);
                Draw.PutBitmap3(Draw.grcGame, 88, 40, rcTitle, 0);
                Draw.PutBitmap3(Draw.grcGame, 136, 128, rcNew, 0);
                Draw.PutBitmap3(Draw.grcGame, 136, 148, rcContinue, 0);
                Draw.PutBitmap3(Draw.grcGame, 80, 192, rcPixel, 1);
                switch (char_type) {
                    case 0: {
                        char_rc = rcMyChar[anime / 10 % 4];
                        char_surf = 16;
                        break;
                    }
                    case 1: {
                        char_rc = rcCurly[anime / 10 % 4];
                        char_surf = 23;
                        break;
                    }
                    case 2: {
                        char_rc = rcToroko[anime / 10 % 4];
                        char_surf = 23;
                        break;
                    }
                    case 3: {
                        char_rc = rcKing[anime / 10 % 4];
                        char_surf = 23;
                        break;
                    }
                    case 4: {
                        char_rc = rcSu[anime / 10 % 4];
                        char_surf = 23;
                    }
                }
                char_y = !bContinue ? 127 : 147;
                Draw.PutBitmap3(Draw.grcGame, 116, char_y, char_rc, char_surf);
                Caret.PutCaret(0, 0);
                if (time_counter != 0) {
                    MycParam.PutTimeCounter(16, 8);
                }
                Game.PutFramePerSecound();
            } while (Draw.Flip_SystemTask());
            return 0;
        }
        Sound.PlaySoundObject(18, 1);
        Stage.ChangeMusic(0);
        wait = System.nanoTime();
        while (System.nanoTime() < wait + 1000000000L) {
            Draw.CortBox(Draw.grcGame, 0);
            Game.PutFramePerSecound();
            if (Draw.Flip_SystemTask()) continue;
            return 0;
        }
        return 3;
    }

    public static int ModeAction() {
        int frame_x = 0;
        int frame_y = 0;
        int swPlay = 1;
        int color = 32;
        gCounter = 0;
        Draw.grcGame.left = 0;
        g_GameFlags = 3;
        MyChar.InitMyChar();
        NpChar.InitNpChar();
        Bullet.InitBullet();
        Caret.InitCaret();
        Star.InitStar();
        Fade.InitFade();
        Flash.InitFlash();
        ArmsItem.ClearArmsData();
        ArmsItem.ClearItemData();
        SelStage.ClearPermitStage();
        MiniMap.StartMapping();
        Flags.InitFlags();
        BossLife.InitBossLife();
        if (bContinue ? !Profile.LoadProfile(null) && !Profile.InitializeGame() : !Profile.InitializeGame()) {
            return 0;
        }
        while (true) {
            KeyControl.GetTrg();
            if ((KeyControl.gKey & 0x8000) != 0) {
                switch (Escape.Call_Escape()) {
                    case 0: {
                        return 0;
                    }
                    case 2: {
                        return 1;
                    }
                }
            }
            if (swPlay % 2 != 0 && (g_GameFlags & 1) != 0) {
                if ((g_GameFlags & 2) != 0) {
                    MyChar.ActMyChar(true);
                } else {
                    MyChar.ActMyChar(false);
                }
                Star.ActStar();
                NpChar.ActNpChar();
                Boss.ActBossChar();
                ValueView.ActValueView();
                Back.ActBack();
                MycHit.ResetMyCharFlag();
                MycHit.HitMyCharMap();
                MycHit.HitMyCharNpChar();
                MycHit.HitMyCharBoss();
                NpcHit.HitNpCharMap();
                Boss.HitBossMap();
                BulHit.HitBulletMap();
                NpcHit.HitNpCharBullet();
                Boss.HitBossBullet();
                if ((g_GameFlags & 2) != 0) {
                    Shoot.ShootBullet();
                }
                Bullet.ActBullet();
                Caret.ActCaret();
                Frame.MoveFrame3();
                Flash.ActFlash(frame_x, frame_y);
                if ((g_GameFlags & 2) != 0) {
                    MyChar.AnimationMyChar(true);
                } else {
                    MyChar.AnimationMyChar(false);
                }
            }
            if ((g_GameFlags & 8) != 0) {
                Ending.ActionCredit();
                Ending.ActionIllust();
                Ending.ActionStripper();
            }
            Fade.ProcFade();
            Draw.CortBox(Draw.grcFull, color);
            frame_x = Frame.gFrame.x;
            frame_y = Frame.gFrame.y;
            Back.PutBack(frame_x, frame_y);
            Map.PutStage_Back(frame_x, frame_y);
            Boss.PutBossChar(frame_x, frame_y);
            NpChar.PutNpChar(frame_x, frame_y);
            Bullet.PutBullet(frame_x, frame_y);
            MyChar.PutMyChar(frame_x, frame_y);
            Star.PutStar(frame_x, frame_y);
            Map.PutMapDataVector(frame_x, frame_y);
            Map.PutStage_Front(frame_x, frame_y);
            Back.PutFront(frame_x, frame_y);
            Flash.PutFlash();
            Caret.PutCaret(frame_x, frame_y);
            ValueView.PutValueView(frame_x, frame_y);
            BossLife.PutBossLife();
            Fade.PutFade();
            if ((g_GameFlags & 4) == 0) {
                if ((KeyControl.gKeyTrg & KeyControl.gKeyItem) != 0) {
                    Draw.BackupSurface(10, Draw.grcGame);
                    switch (ArmsItem.CampLoop()) {
                        case 0: {
                            return 0;
                        }
                        case 2: {
                            return 1;
                        }
                    }
                    MyChar.gMC.cond = (char)(MyChar.gMC.cond & 0xFFFFFFFE);
                } else if ((MyChar.gMC.equip & 2) != 0 && (KeyControl.gKeyTrg & KeyControl.gKeyMap) != 0) {
                    Draw.BackupSurface(10, Draw.grcGame);
                    switch (MiniMap.MiniMapLoop()) {
                        case 0: {
                            return 0;
                        }
                        case 2: {
                            return 1;
                        }
                    }
                }
            }
            if ((g_GameFlags & 2) != 0) {
                if ((KeyControl.gKeyTrg & KeyControl.gKeyArms) != 0) {
                    ArmsItem.RotationArms();
                } else if ((KeyControl.gKeyTrg & KeyControl.gKeyArmsRev) != 0) {
                    ArmsItem.RotationArmsRev();
                }
            }
            if (swPlay % 2 != 0) {
                switch (TextScr.TextScriptProc()) {
                    case 0: {
                        return 0;
                    }
                    case 2: {
                        return 1;
                    }
                }
            }
            MapName.PutMapName(false);
            MycParam.PutTimeCounter(16, 8);
            if ((g_GameFlags & 2) != 0) {
                MycParam.PutMyLife(true);
                MycParam.PutArmsEnergy(true);
                MycParam.PutMyAir(120, 104);
                MycParam.PutActiveArmsList();
            }
            if ((g_GameFlags & 8) != 0) {
                Ending.PutIllust();
                Ending.PutStripper();
            }
            TextScr.PutTextScript();
            Game.PutFramePerSecound();
            if (!Draw.Flip_SystemTask()) {
                return 0;
            }
            ++gCounter;
        }
    }

    public static boolean Game() {
        if (!GenericLoad.LoadGenericData()) {
            JOptionPane.showMessageDialog(null, "\u6c4e\u7528\u30d5\u30a1\u30a4\u30eb\u304c\u8aad\u3081\u306a\u3044", "\u30a8\u30e9\u30fc", 0);
            return false;
        }
        Sound.PlaySoundObject(7, -1);
        if (!NpcTbl.LoadNpcTable("/npc.tbl")) {
            JOptionPane.showMessageDialog(null, "NPC\u30c6\u30fc\u30d6\u30eb\u304c\u8aad\u3081\u306a\u3044", "\u30a8\u30e9\u30fc", 0);
            return false;
        }
        TextScr.InitTextScript2();
        Flags.InitSkipFlags();
        Map.InitMapData2();
        Ending.InitCreditScript();
        int mode = 1;
        while (mode != 0) {
            if (mode == 1) {
                mode = Game.ModeOpening();
            }
            if (mode == 2) {
                mode = Game.ModeTitle();
            }
            if (mode != 3) continue;
            mode = Game.ModeAction();
        }
        Sound.PlaySoundObject(7, 0);
        return true;
    }

    public static void main() {
        try {
            Draw.StartDirectDraw("Cave Story", mainWidth, mainHeight, mainMag);
            switch (Config.gConfig.attack_button_mode) {
                case 0: {
                    KeyControl.gKeyJump = 64;
                    KeyControl.gKeyShot = 32;
                    break;
                }
                case 1: {
                    KeyControl.gKeyJump = 32;
                    KeyControl.gKeyShot = 64;
                }
            }
            switch (Config.gConfig.ok_button_mode) {
                case 0: {
                    KeyControl.gKeyOk = KeyControl.gKeyJump;
                    KeyControl.gKeyCancel = KeyControl.gKeyShot;
                    break;
                }
                case 1: {
                    KeyControl.gKeyOk = KeyControl.gKeyShot;
                    KeyControl.gKeyCancel = KeyControl.gKeyJump;
                }
            }
            if (new File("s_reverse").exists()) {
                KeyControl.gKeyArms = 256;
                KeyControl.gKeyArmsRev = 128;
            }
            switch (Config.gConfig.move_button_mode) {
                case 0: {
                    KeyControl.gKeyLeft = 1;
                    KeyControl.gKeyUp = 4;
                    KeyControl.gKeyRight = 2;
                    KeyControl.gKeyDown = 8;
                    break;
                }
                case 1: {
                    KeyControl.gKeyLeft = 65536;
                    KeyControl.gKeyUp = 0x180000;
                    KeyControl.gKeyRight = 262144;
                    KeyControl.gKeyDown = 131072;
                }
            }
            block22: for (int i = 0; i < 8; ++i) {
                switch (Config.gConfig.joystick_button[i]) {
                    case 1: {
                        Game.gJoystickButtonTable[i] = KeyControl.gKeyJump;
                        continue block22;
                    }
                    case 2: {
                        Game.gJoystickButtonTable[i] = KeyControl.gKeyShot;
                        continue block22;
                    }
                    case 3: {
                        Game.gJoystickButtonTable[i] = KeyControl.gKeyArms;
                        continue block22;
                    }
                    case 6: {
                        Game.gJoystickButtonTable[i] = KeyControl.gKeyArmsRev;
                        continue block22;
                    }
                    case 4: {
                        Game.gJoystickButtonTable[i] = KeyControl.gKeyItem;
                        continue block22;
                    }
                    case 5: {
                        Game.gJoystickButtonTable[i] = KeyControl.gKeyMap;
                    }
                }
            }
            if (new File("fps").exists()) {
                bFPS = true;
            }
            RECT rcLoading = new RECT(0, 0, 64, 8);
            RECT rcFull = new RECT(0, 0, 320, 240);
            boolean b = Draw.MakeSurface_File("Loading", 15);
            Draw.CortBox(rcFull, 0);
            Draw.PutBitmap3(rcFull, 128, 116, rcLoading, 15);
            if (!Draw.Flip_SystemTask()) {
                return;
            }
            Sound.InitDirectSound();
            Draw.InitTextObject(Config.gConfig.font_name);
            Triangle.InitTriangleTable();
            Game.Game();
            Draw.EndTextObject();
            Sound.EndDirectSound();
            Draw.EndDirectDraw();
            System.exit(0);
        }
        catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public static void startMainThread(int width, int height, int mag) {
        mainWidth = width;
        mainHeight = height;
        mainMag = mag;
        new Thread(Game::main, "Game Main").start();
    }
}
