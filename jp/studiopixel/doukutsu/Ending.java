/*
 * Decompiled with CFR 0.152.
 */
package jp.studiopixel.doukutsu;

import java.util.Arrays;
import jp.studiopixel.doukutsu.CUtils;
import jp.studiopixel.doukutsu.DataLoader;
import jp.studiopixel.doukutsu.Draw;
import jp.studiopixel.doukutsu.Escape;
import jp.studiopixel.doukutsu.Flags;
import jp.studiopixel.doukutsu.Game;
import jp.studiopixel.doukutsu.KeyControl;
import jp.studiopixel.doukutsu.MycParam;
import jp.studiopixel.doukutsu.Organya;
import jp.studiopixel.doukutsu.RECT;
import jp.studiopixel.doukutsu.Stage;
import jp.studiopixel.doukutsu.TextScr;

public class Ending {
    public static final int CREDIT_MODE_STOP = 0;
    public static final int CREDIT_MODE_SCROLL_READ = 1;
    public static final int CREDIT_MODE_SCROLL_WAIT = 2;
    public static final int ILLUSTRATION_ACTION_IDLE = 0;
    public static final int ILLUSTRATION_ACTION_SLIDE_IN = 1;
    public static final int ILLUSTRATION_ACTION_SLIDE_OUT = 2;
    private static final CREDIT Credit = new CREDIT();
    private static final STRIP[] Strip = new STRIP[16];
    private static final ILLUSTRATION Illust = new ILLUSTRATION();
    private static final RECT rc;
    private static final RECT rcIllust;
    private static final String credit_script = "Credit.tsc";
    private static final RECT rc_frame;
    private static final RECT rc_sky;
    private static final RECT rc_ground;
    private static final RECT rc_sprite;

    public static void ActionStripper() {
        for (int s = 0; s < Strip.length; ++s) {
            if ((Ending.Strip[s].flag & 0x80) != 0 && Ending.Credit.mode != 0) {
                Ending.Strip[s].y -= 256;
            }
            if (Ending.Strip[s].y > -8192) continue;
            Ending.Strip[s].flag = 0;
        }
    }

    public static void PutStripper() {
        for (int s = 0; s < Strip.length; ++s) {
            if ((Ending.Strip[s].flag & 0x80) == 0) continue;
            Ending.rc.left = 0;
            Ending.rc.right = 320;
            Ending.rc.top = s * 16;
            Ending.rc.bottom = Ending.rc.top + 16;
            Draw.PutBitmap3(Draw.grcFull, Ending.Strip[s].x / 512, Ending.Strip[s].y / 512, rc, 35);
            Ending.rc.left = Ending.Strip[s].cast % 13 * 24;
            Ending.rc.right = Ending.rc.left + 24;
            Ending.rc.top = Ending.Strip[s].cast / 13 * 24;
            Ending.rc.bottom = Ending.rc.top + 24;
            Draw.PutBitmap3(Draw.grcFull, Ending.Strip[s].x / 512 - 24, Ending.Strip[s].y / 512 - 8, rc, 37);
        }
    }

    public static void SetStripper(int x, int y, String text, int cast) {
        int s;
        for (s = 0; s < Strip.length && (Ending.Strip[s].flag & 0x80) != 0; ++s) {
        }
        if (s == Strip.length) {
            return;
        }
        Ending.Strip[s].flag = 128;
        Ending.Strip[s].x = x;
        Ending.Strip[s].y = y;
        Ending.Strip[s].cast = cast;
        Arrays.fill(Ending.Strip[s].str, '\u0000');
        System.arraycopy(text.toCharArray(), 0, Ending.Strip[s].str, 0, text.length());
        Ending.rc.left = 0;
        Ending.rc.right = 320;
        Ending.rc.top = s * 16;
        Ending.rc.bottom = Ending.rc.top + 16;
        Draw.CortBox2(rc, 0, 35);
        Draw.PutText2(0, Ending.rc.top, text, 0xFFFFFE, 35);
    }

    public static void RestoreStripper() {
        for (int s = 0; s < Strip.length; ++s) {
            if ((Ending.Strip[s].flag & 0x80) == 0) continue;
            Ending.rc.left = 0;
            Ending.rc.right = 320;
            Ending.rc.top = s * 16;
            Ending.rc.bottom = Ending.rc.top + 16;
            Draw.CortBox2(rc, 0, 35);
            Draw.PutText2(0, Ending.rc.top, CUtils.nullTermToString(Ending.Strip[s].str), 0xFFFFFE, 35);
        }
    }

    public static void ActionIllust() {
        switch (Ending.Illust.act_no) {
            case 0: {
                Ending.Illust.x = -81920;
                break;
            }
            case 1: {
                Ending.Illust.x += 20480;
                if (Ending.Illust.x <= 0) break;
                Ending.Illust.x = 0;
                break;
            }
            case 2: {
                Ending.Illust.x -= 20480;
                if (Ending.Illust.x >= -81920) break;
                Ending.Illust.x = -81920;
            }
        }
    }

    public static void PutIllust() {
        Draw.PutBitmap3(Draw.grcFull, Ending.Illust.x / 512, 0, rcIllust, 36);
    }

    public static void ReloadIllust(int a) {
        String name = String.format("CREDIT%02d", a);
        Draw.ReloadBitmap_Resource(name, 36);
    }

    public static void InitCreditScript() {
        Credit.clear();
        for (int i = 0; i < Strip.length; ++i) {
            Strip[i].clear();
        }
    }

    public static void ReleaseCreditScript() {
        Ending.Credit.pData = null;
    }

    public static boolean StartCreditScript() {
        String path = "/Credit.tsc";
        try {
            byte[] data = DataLoader.load(path).readAllBytes();
            TextScr.EncryptionBinaryData2(data, data.length);
            String s = new String(data, "Shift_JIS");
            Ending.Credit.pData = s.toCharArray();
            Ending.Credit.size = Ending.Credit.pData.length;
            Ending.Credit.offset = 0;
            Ending.Credit.wait = 0;
            Ending.Credit.mode = 1;
            Ending.Illust.x = -81920;
            Ending.Illust.act_no = 0;
            Draw.grcGame.left = 160;
            if (!Draw.ReloadBitmap_File("casts", 37)) {
                return false;
            }
            for (int i = 0; i < Strip.length; ++i) {
                Strip[i].clear();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    private static int GetScriptNumber(int a) {
        int b = 0;
        b += (Ending.Credit.pData[a++] - 48) * 1000;
        b += (Ending.Credit.pData[a++] - 48) * 100;
        b += (Ending.Credit.pData[a++] - 48) * 10;
        return b += Ending.Credit.pData[a] - 48;
    }

    private static void ActionCredit_Read() {
        char[] text = new char[40];
        while (Ending.Credit.offset < Ending.Credit.size) {
            switch (Ending.Credit.pData[Ending.Credit.offset]) {
                case '[': {
                    ++Ending.Credit.offset;
                    int a = Ending.Credit.offset;
                    while (Ending.Credit.pData[a] != ']') {
                        ++a;
                    }
                    int len = a - Ending.Credit.offset;
                    System.arraycopy(Ending.Credit.pData, Ending.Credit.offset, text, 0, len);
                    text[len] = '\u0000';
                    Ending.Credit.offset = a;
                    ++Ending.Credit.offset;
                    len = Ending.GetScriptNumber(Ending.Credit.offset);
                    Ending.SetStripper(Ending.Credit.start_x, 126976, CUtils.nullTermToString(text), len);
                    Ending.Credit.offset += 4;
                    return;
                }
                case '-': {
                    ++Ending.Credit.offset;
                    Ending.Credit.wait = Ending.GetScriptNumber(Ending.Credit.offset);
                    Ending.Credit.offset += 4;
                    Ending.Credit.mode = 2;
                    return;
                }
                case '+': {
                    ++Ending.Credit.offset;
                    Ending.Credit.start_x = Ending.GetScriptNumber(Ending.Credit.offset) * 512;
                    Ending.Credit.offset += 4;
                    return;
                }
                case '/': {
                    Ending.Credit.mode = 0;
                    return;
                }
                case '!': {
                    ++Ending.Credit.offset;
                    int a = Ending.GetScriptNumber(Ending.Credit.offset);
                    Ending.Credit.offset += 4;
                    Stage.ChangeMusic(a);
                    return;
                }
                case '~': {
                    ++Ending.Credit.offset;
                    Organya.SetOrganyaFadeout();
                    return;
                }
                case 'j': {
                    ++Ending.Credit.offset;
                    int b = Ending.GetScriptNumber(Ending.Credit.offset);
                    Ending.Credit.offset += 4;
                    while (Ending.Credit.offset < Ending.Credit.size) {
                        if (Ending.Credit.pData[Ending.Credit.offset] == 'l') {
                            ++Ending.Credit.offset;
                            int a = Ending.GetScriptNumber(Ending.Credit.offset);
                            Ending.Credit.offset += 4;
                            if (b != a) continue;
                            break;
                        }
                        ++Ending.Credit.offset;
                    }
                    return;
                }
                case 'f': {
                    ++Ending.Credit.offset;
                    int a = Ending.GetScriptNumber(Ending.Credit.offset);
                    Ending.Credit.offset += 5;
                    int b = Ending.GetScriptNumber(Ending.Credit.offset);
                    Ending.Credit.offset += 4;
                    if (Flags.GetNPCFlag(a)) {
                        while (Ending.Credit.offset < Ending.Credit.size) {
                            if (Ending.Credit.pData[Ending.Credit.offset] == 'l') {
                                ++Ending.Credit.offset;
                                a = Ending.GetScriptNumber(Ending.Credit.offset);
                                Ending.Credit.offset += 4;
                                if (b != a) continue;
                                break;
                            }
                            ++Ending.Credit.offset;
                        }
                    }
                    return;
                }
            }
            ++Ending.Credit.offset;
        }
    }

    public static void ActionCredit() {
        if (Ending.Credit.offset >= Ending.Credit.size) {
            return;
        }
        switch (Ending.Credit.mode) {
            case 1: {
                Ending.ActionCredit_Read();
                break;
            }
            case 2: {
                if (--Ending.Credit.wait > 0) break;
                Ending.Credit.mode = 1;
            }
        }
    }

    public static void SetCreditIllust(int a) {
        Ending.ReloadIllust(a);
        Ending.Illust.act_no = 1;
    }

    public static void CutCreditIllust() {
        Ending.Illust.act_no = 2;
    }

    public static int Scene_DownIsland(int mode) {
        ISLAND_SPRITE sprite = new ISLAND_SPRITE();
        sprite.x = 86016;
        sprite.y = 32768;
        for (int wait = 0; wait < 900; ++wait) {
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
            switch (mode) {
                case 0: {
                    sprite.y += 51;
                    break;
                }
                case 1: {
                    if (wait < 350) {
                        sprite.y += 51;
                        break;
                    }
                    if (wait < 500) {
                        sprite.y += 25;
                        break;
                    }
                    if (wait < 600) {
                        sprite.y += 12;
                        break;
                    }
                    if (wait != 750) break;
                    wait = 900;
                }
            }
            Draw.CortBox(Draw.grcFull, 0);
            Draw.PutBitmap3(rc_frame, 80, 80, rc_sky, 21);
            Draw.PutBitmap3(rc_frame, sprite.x / 512 - 20, sprite.y / 512 - 12, rc_sprite, 21);
            Draw.PutBitmap3(rc_frame, 80, 128, rc_ground, 21);
            MycParam.PutTimeCounter(16, 8);
            Game.PutFramePerSecound();
            if (Draw.Flip_SystemTask()) continue;
            return 0;
        }
        return 1;
    }

    static {
        for (int i = 0; i < Strip.length; ++i) {
            Ending.Strip[i] = new STRIP();
        }
        rc = new RECT();
        rcIllust = new RECT(0, 0, 160, 240);
        rc_frame = new RECT(80, 80, 240, 160);
        rc_sky = new RECT(0, 0, 160, 80);
        rc_ground = new RECT(160, 48, 320, 80);
        rc_sprite = new RECT(160, 0, 200, 24);
    }

    public static class STRIP {
        int flag;
        int x;
        int y;
        int cast;
        final char[] str = new char[64];

        public void clear() {
            this.flag = 0;
            this.x = 0;
            this.y = 0;
            this.cast = 0;
            Arrays.fill(this.str, '\u0000');
        }
    }

    public static class CREDIT {
        int size;
        char[] pData;
        int offset;
        int wait;
        int mode;
        int start_x;

        public void clear() {
            this.size = 0;
            this.pData = null;
            this.offset = 0;
            this.wait = 0;
            this.mode = 0;
            this.start_x = 0;
        }
    }

    public static class ILLUSTRATION {
        int act_no;
        int x;
    }

    public static class ISLAND_SPRITE {
        int x;
        int y;
    }
}
