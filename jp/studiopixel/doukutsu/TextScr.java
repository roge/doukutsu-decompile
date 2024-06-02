/*
 * Decompiled with CFR 0.152.
 */
package jp.studiopixel.doukutsu;

import java.util.Arrays;
import javax.swing.JOptionPane;
import jp.studiopixel.doukutsu.ArmsItem;
import jp.studiopixel.doukutsu.Boss;
import jp.studiopixel.doukutsu.BossLife;
import jp.studiopixel.doukutsu.CUtils;
import jp.studiopixel.doukutsu.DataLoader;
import jp.studiopixel.doukutsu.Draw;
import jp.studiopixel.doukutsu.Ending;
import jp.studiopixel.doukutsu.Fade;
import jp.studiopixel.doukutsu.Flags;
import jp.studiopixel.doukutsu.Flash;
import jp.studiopixel.doukutsu.Frame;
import jp.studiopixel.doukutsu.Game;
import jp.studiopixel.doukutsu.KeyControl;
import jp.studiopixel.doukutsu.Map;
import jp.studiopixel.doukutsu.MapName;
import jp.studiopixel.doukutsu.MiniMap;
import jp.studiopixel.doukutsu.MyChar;
import jp.studiopixel.doukutsu.MycParam;
import jp.studiopixel.doukutsu.NpChar;
import jp.studiopixel.doukutsu.Organya;
import jp.studiopixel.doukutsu.Profile;
import jp.studiopixel.doukutsu.RECT;
import jp.studiopixel.doukutsu.SelStage;
import jp.studiopixel.doukutsu.Sound;
import jp.studiopixel.doukutsu.Stage;
import jp.studiopixel.doukutsu.WcWidth;

public class TextScr {
    public static final TEXT_SCRIPT gTS = new TEXT_SCRIPT();
    public static final RECT gRect_line = new RECT(0, 0, 216, 16);
    private static final char[][] text = new char[][]{new char[64], new char[64], new char[64], new char[64]};
    public static final String TSC_ENCODING = "Shift_JIS";
    public static int[] gNumberTextScript = new int[4];

    public static boolean InitTextScript2() {
        int i;
        TextScr.gTS.mode = 0;
        Game.g_GameFlags &= 0xFFFFFFFB;
        for (i = 0; i < 4; ++i) {
            Draw.MakeSurface_Generic(TextScr.gRect_line.right, TextScr.gRect_line.bottom, 30 + i, false, true);
        }
        for (i = 0; i < 4; ++i) {
            Arrays.fill(text[i], '\u0000');
        }
        TextScr.gTS.data = new char[20480];
        return true;
    }

    public static void EndTextScript() {
        TextScr.gTS.data = null;
        Draw.ReleaseSurface(26);
        for (int i = 0; i < 4; ++i) {
            Draw.ReleaseSurface(30 + i);
        }
    }

    public static void EncryptionBinaryData2(byte[] pData, long size) {
        int half = (int)(size / 2L);
        int val1 = pData[half] == 0 ? -7 : pData[half] % 256 * -1;
        int i = 0;
        while ((long)i < size) {
            int work = pData[i];
            work += val1;
            if (i != half) {
                pData[i] = (byte)(work & 0xFF);
            }
            ++i;
        }
    }

    public static boolean LoadTextScript2(String name) {
        String path = "/" + name;
        try {
            byte[] data = DataLoader.load(path).readAllBytes();
            TextScr.EncryptionBinaryData2(data, data.length);
            String s = new String(data, TSC_ENCODING);
            TextScr.gTS.path = name;
            char[] cdata = s.toCharArray();
            System.arraycopy(cdata, 0, TextScr.gTS.data, 0, cdata.length);
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static boolean LoadTextScript_Stage(String name) {
        String path = "/" + name;
        try {
            byte[] head_data = DataLoader.load("/Head.tsc").readAllBytes();
            byte[] body_data = DataLoader.load(path).readAllBytes();
            TextScr.EncryptionBinaryData2(head_data, head_data.length);
            TextScr.EncryptionBinaryData2(body_data, body_data.length);
            String s = new String(head_data, TSC_ENCODING) + new String(body_data, TSC_ENCODING);
            TextScr.gTS.path = name;
            char[] cdata = s.toCharArray();
            System.arraycopy(cdata, 0, TextScr.gTS.data, 0, cdata.length);
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static String GetTextScriptPath() {
        return TextScr.gTS.path;
    }

    public static int GetTextScriptNo(int a) {
        int b = 0;
        b += (TextScr.gTS.data[a++] - 48) * 1000;
        b += (TextScr.gTS.data[a++] - 48) * 100;
        b += (TextScr.gTS.data[a++] - 48) * 10;
        return b += TextScr.gTS.data[a] - 48;
    }

    public static boolean StartTextScript(int no) {
        TextScr.gTS.mode = 1;
        Game.g_GameFlags |= 5;
        TextScr.gTS.line = 0;
        TextScr.gTS.p_write = 0;
        TextScr.gTS.wait = 4;
        TextScr.gTS.flags = 0;
        TextScr.gTS.wait_beam = '\u0000';
        TextScr.gTS.face = 0;
        TextScr.gTS.item = 0;
        TextScr.gTS.offsetY = 0;
        MyChar.gMC.shock = '\u0000';
        TextScr.gTS.rcText.left = 52;
        TextScr.gTS.rcText.top = 184;
        TextScr.gTS.rcText.right = 268;
        TextScr.gTS.rcText.bottom = TextScr.gTS.rcText.top + 48;
        TextScr.gTS.p_read = 0;
        while (true) {
            if (TextScr.gTS.data[TextScr.gTS.p_read] == '\u0000') {
                return false;
            }
            if (TextScr.gTS.data[TextScr.gTS.p_read] == '#') {
                int event_no;
                if (no == (event_no = TextScr.GetTextScriptNo(++TextScr.gTS.p_read))) break;
                if (no < event_no) {
                    return false;
                }
            }
            ++TextScr.gTS.p_read;
        }
        while (TextScr.gTS.data[TextScr.gTS.p_read] != '\n') {
            ++TextScr.gTS.p_read;
        }
        ++TextScr.gTS.p_read;
        return true;
    }

    public static boolean JumpTextScript(int no) {
        TextScr.gTS.mode = 1;
        Game.g_GameFlags |= 4;
        TextScr.gTS.line = 0;
        TextScr.gTS.p_write = 0;
        TextScr.gTS.wait = 4;
        TextScr.gTS.wait_beam = '\u0000';
        for (int i = 0; i < 4; ++i) {
            TextScr.gTS.ypos_line[i] = i * 16;
            Draw.CortBox2(gRect_line, 0, 30 + i);
            Arrays.fill(text[i], '\u0000');
        }
        TextScr.gTS.p_read = 0;
        while (true) {
            if (TextScr.gTS.data[TextScr.gTS.p_read] == '\u0000') {
                return false;
            }
            if (TextScr.gTS.data[TextScr.gTS.p_read] == '#') {
                int event_no;
                if (no == (event_no = TextScr.GetTextScriptNo(++TextScr.gTS.p_read))) break;
                if (no < event_no) {
                    return false;
                }
            }
            ++TextScr.gTS.p_read;
        }
        while (TextScr.gTS.data[TextScr.gTS.p_read] != '\n') {
            ++TextScr.gTS.p_read;
        }
        ++TextScr.gTS.p_read;
        return true;
    }

    public static void StopTextScript() {
        TextScr.gTS.mode = 0;
        Game.g_GameFlags &= 0xFFFFFFFB;
        Game.g_GameFlags |= 3;
        TextScr.gTS.flags = 0;
    }

    public static void CheckNewLine() {
        if (TextScr.gTS.ypos_line[TextScr.gTS.line % 4] == 48) {
            TextScr.gTS.mode = (byte)3;
            Game.g_GameFlags |= 4;
            Draw.CortBox2(gRect_line, 0, 30 + TextScr.gTS.line % 4);
            Arrays.fill(text[TextScr.gTS.line % 4], '\u0000');
        }
    }

    public static void SetNumberTextScript(int index) {
        char[] str = new char[5];
        int[] table = new int[]{1000, 100, 10};
        int a = gNumberTextScript[index];
        boolean bZero = false;
        int offset = 0;
        for (int i = 0; i < 3; ++i) {
            if (a / table[i] == 0 && !bZero) continue;
            int b = a / table[i];
            str[offset] = (char)(48 + (char)b);
            bZero = true;
            a -= b * table[i];
            ++offset;
        }
        str[offset] = (char)(48 + (char)a);
        str[offset + 1] = '\u0000';
        Draw.PutText2(TextScr.gTS.p_write * 6, 0, CUtils.nullTermToString(str), 0xFFFFFE, 30 + TextScr.gTS.line % 4);
        CUtils.strcat(text[TextScr.gTS.line % 4], str);
        Sound.PlaySoundObject(2, 1);
        TextScr.gTS.wait_beam = '\u0000';
        TextScr.gTS.p_write += CUtils.strlen(str);
        if (TextScr.gTS.p_write >= 35) {
            TextScr.gTS.p_write = 0;
            ++TextScr.gTS.line;
            TextScr.CheckNewLine();
        }
    }

    public static void ClearTextLine() {
        TextScr.gTS.line = 0;
        TextScr.gTS.p_write = 0;
        TextScr.gTS.offsetY = 0;
        for (int i = 0; i < 4; ++i) {
            TextScr.gTS.ypos_line[i] = i * 16;
            Draw.CortBox2(gRect_line, 0, 30 + i);
            Arrays.fill(text[i], '\u0000');
        }
    }

    public static void PutTextScript() {
        int i;
        RECT rect = new RECT();
        if (TextScr.gTS.mode == 0) {
            return;
        }
        if ((TextScr.gTS.flags & 1) == 0) {
            return;
        }
        if ((TextScr.gTS.flags & 0x20) != 0) {
            TextScr.gTS.rcText.top = 32;
            TextScr.gTS.rcText.bottom = TextScr.gTS.rcText.top + 48;
        } else {
            TextScr.gTS.rcText.top = 184;
            TextScr.gTS.rcText.bottom = TextScr.gTS.rcText.top + 48;
        }
        if ((TextScr.gTS.flags & 2) != 0) {
            RECT rcFrame1 = new RECT(0, 0, 244, 8);
            RECT rcFrame2 = new RECT(0, 8, 244, 16);
            RECT rcFrame3 = new RECT(0, 16, 244, 24);
            Draw.PutBitmap3(Draw.grcFull, 38, TextScr.gTS.rcText.top - 10, rcFrame1, 26);
            for (i = 1; i < 7; ++i) {
                Draw.PutBitmap3(Draw.grcFull, 38, i * 8 + TextScr.gTS.rcText.top - 10, rcFrame2, 26);
            }
            Draw.PutBitmap3(Draw.grcFull, 38, i * 8 + TextScr.gTS.rcText.top - 10, rcFrame3, 26);
        }
        RECT rcFace = new RECT();
        rcFace.left = TextScr.gTS.face % 6 * 48;
        rcFace.top = TextScr.gTS.face / 6 * 48;
        rcFace.right = rcFace.left + 48;
        rcFace.bottom = rcFace.top + 48;
        if (TextScr.gTS.face_x < 26624) {
            TextScr.gTS.face_x += 4096;
        }
        Draw.PutBitmap3(TextScr.gTS.rcText, TextScr.gTS.face_x / 512, TextScr.gTS.rcText.top - 3, rcFace, 27);
        int text_offset = TextScr.gTS.face != 0 ? 56 : 0;
        for (i = 0; i < 4; ++i) {
            Draw.PutBitmap3(TextScr.gTS.rcText, 52 + text_offset, TextScr.gTS.offsetY + TextScr.gTS.ypos_line[i] + TextScr.gTS.rcText.top, gRect_line, 30 + i);
        }
        char c = TextScr.gTS.wait_beam;
        TextScr.gTS.wait_beam = (char)(c + '\u0001');
        if (c % 20 > 12 && TextScr.gTS.mode == 2) {
            rect.left = 52 + TextScr.gTS.p_write * 6 + text_offset;
            rect.top = TextScr.gTS.ypos_line[TextScr.gTS.line % 4] + TextScr.gTS.rcText.top + TextScr.gTS.offsetY;
            rect.right = rect.left + 5;
            rect.bottom = rect.top + 11;
            Draw.CortBox(rect, 0xFFFFFE);
        }
        RECT rcItemBox1 = new RECT(0, 0, 72, 16);
        RECT rcItemBox2 = new RECT(0, 8, 72, 24);
        RECT rcItemBox3 = new RECT(240, 0, 244, 8);
        RECT rcItemBox4 = new RECT(240, 8, 244, 16);
        RECT rcItemBox5 = new RECT(240, 16, 244, 24);
        if (TextScr.gTS.item != 0) {
            Draw.PutBitmap3(Draw.grcFull, 120, 128, rcItemBox1, 26);
            Draw.PutBitmap3(Draw.grcFull, 120, 144, rcItemBox2, 26);
            Draw.PutBitmap3(Draw.grcFull, 192, 128, rcItemBox3, 26);
            Draw.PutBitmap3(Draw.grcFull, 192, 136, rcItemBox4, 26);
            Draw.PutBitmap3(Draw.grcFull, 192, 144, rcItemBox4, 26);
            Draw.PutBitmap3(Draw.grcFull, 192, 152, rcItemBox5, 26);
            if (TextScr.gTS.item_y < 136) {
                ++TextScr.gTS.item_y;
            }
            if (TextScr.gTS.item < 1000) {
                rect.left = TextScr.gTS.item % 16 * 16;
                rect.right = rect.left + 16;
                rect.top = TextScr.gTS.item / 16 * 16;
                rect.bottom = rect.top + 16;
                Draw.PutBitmap3(Draw.grcFull, 148, TextScr.gTS.item_y, rect, 12);
            } else {
                rect.left = 32 * ((TextScr.gTS.item - 1000) % 8);
                rect.right = rect.left + 32;
                rect.top = 16 * ((TextScr.gTS.item - 1000) / 8);
                rect.bottom = rect.top + 16;
                Draw.PutBitmap3(Draw.grcFull, 140, TextScr.gTS.item_y, rect, 8);
            }
        }
        RECT rect_yesno = new RECT(152, 48, 244, 80);
        RECT rect_cur = new RECT(112, 88, 128, 104);
        if (TextScr.gTS.mode == 6) {
            i = TextScr.gTS.wait < 2 ? 144 + (2 - TextScr.gTS.wait) * 4 : 144;
            Draw.PutBitmap3(Draw.grcFull, 216, i, rect_yesno, 26);
            if (TextScr.gTS.wait == 16) {
                Draw.PutBitmap3(Draw.grcFull, TextScr.gTS.select * 41 + 160 + 51, 154, rect_cur, 26);
            }
        }
    }

    public static int TextScriptProc() {
        int i = 0;
        char[] c = new char[3];
        char[] str = new char[72];
        int w = 0;
        int x = 0;
        int y = 0;
        int z = 0;
        RECT rcSymbol = new RECT(64, 48, 72, 56);
        switch (TextScr.gTS.mode) {
            case 1: {
                ++TextScr.gTS.wait;
                if ((Game.g_GameFlags & 2) == 0 && (KeyControl.gKey & (KeyControl.gKeyOk | KeyControl.gKeyCancel)) != 0) {
                    TextScr.gTS.wait += 4;
                }
                if (TextScr.gTS.wait < 4) break;
                TextScr.gTS.wait = 0;
                boolean bExit = false;
                while (!bExit) {
                    if (TextScr.gTS.data[TextScr.gTS.p_read] == '<') {
                        if (TextScr.gTS.data[TextScr.gTS.p_read + 1] == 'E' && TextScr.gTS.data[TextScr.gTS.p_read + 2] == 'N' && TextScr.gTS.data[TextScr.gTS.p_read + 3] == 'D') {
                            TextScr.gTS.mode = 0;
                            MyChar.gMC.cond = (char)(MyChar.gMC.cond & 0xFFFFFFFE);
                            Game.g_GameFlags |= 3;
                            TextScr.gTS.face = 0;
                            bExit = true;
                            continue;
                        }
                        if (TextScr.gTS.data[TextScr.gTS.p_read + 1] == 'L' && TextScr.gTS.data[TextScr.gTS.p_read + 2] == 'I' && TextScr.gTS.data[TextScr.gTS.p_read + 3] == '+') {
                            x = TextScr.GetTextScriptNo(TextScr.gTS.p_read + 4);
                            MycParam.AddLifeMyChar(x);
                            TextScr.gTS.p_read += 8;
                            continue;
                        }
                        if (TextScr.gTS.data[TextScr.gTS.p_read + 1] == 'M' && TextScr.gTS.data[TextScr.gTS.p_read + 2] == 'L' && TextScr.gTS.data[TextScr.gTS.p_read + 3] == '+') {
                            z = TextScr.GetTextScriptNo(TextScr.gTS.p_read + 4);
                            MycParam.AddMaxLifeMyChar(z);
                            TextScr.gTS.p_read += 8;
                            continue;
                        }
                        if (TextScr.gTS.data[TextScr.gTS.p_read + 1] == 'A' && TextScr.gTS.data[TextScr.gTS.p_read + 2] == 'E' && TextScr.gTS.data[TextScr.gTS.p_read + 3] == '+') {
                            ArmsItem.FullArmsEnergy();
                            TextScr.gTS.p_read += 4;
                            continue;
                        }
                        if (TextScr.gTS.data[TextScr.gTS.p_read + 1] == 'I' && TextScr.gTS.data[TextScr.gTS.p_read + 2] == 'T' && TextScr.gTS.data[TextScr.gTS.p_read + 3] == '+') {
                            x = TextScr.GetTextScriptNo(TextScr.gTS.p_read + 4);
                            Sound.PlaySoundObject(38, 1);
                            ArmsItem.AddItemData(x);
                            TextScr.gTS.p_read += 8;
                            continue;
                        }
                        if (TextScr.gTS.data[TextScr.gTS.p_read + 1] == 'I' && TextScr.gTS.data[TextScr.gTS.p_read + 2] == 'T' && TextScr.gTS.data[TextScr.gTS.p_read + 3] == '-') {
                            z = TextScr.GetTextScriptNo(TextScr.gTS.p_read + 4);
                            ArmsItem.SubItemData(z);
                            TextScr.gTS.p_read += 8;
                            continue;
                        }
                        if (TextScr.gTS.data[TextScr.gTS.p_read + 1] == 'E' && TextScr.gTS.data[TextScr.gTS.p_read + 2] == 'Q' && TextScr.gTS.data[TextScr.gTS.p_read + 3] == '+') {
                            z = TextScr.GetTextScriptNo(TextScr.gTS.p_read + 4);
                            MyChar.EquipItem(z, true);
                            TextScr.gTS.p_read += 8;
                            continue;
                        }
                        if (TextScr.gTS.data[TextScr.gTS.p_read + 1] == 'E' && TextScr.gTS.data[TextScr.gTS.p_read + 2] == 'Q' && TextScr.gTS.data[TextScr.gTS.p_read + 3] == '-') {
                            z = TextScr.GetTextScriptNo(TextScr.gTS.p_read + 4);
                            MyChar.EquipItem(z, false);
                            TextScr.gTS.p_read += 8;
                            continue;
                        }
                        if (TextScr.gTS.data[TextScr.gTS.p_read + 1] == 'A' && TextScr.gTS.data[TextScr.gTS.p_read + 2] == 'M' && TextScr.gTS.data[TextScr.gTS.p_read + 3] == '+') {
                            w = TextScr.GetTextScriptNo(TextScr.gTS.p_read + 4);
                            TextScr.gNumberTextScript[0] = x = TextScr.GetTextScriptNo(TextScr.gTS.p_read + 9);
                            TextScr.gNumberTextScript[1] = z;
                            Sound.PlaySoundObject(38, 1);
                            ArmsItem.AddArmsData(w, x);
                            TextScr.gTS.p_read += 13;
                            continue;
                        }
                        if (TextScr.gTS.data[TextScr.gTS.p_read + 1] == 'A' && TextScr.gTS.data[TextScr.gTS.p_read + 2] == 'M' && TextScr.gTS.data[TextScr.gTS.p_read + 3] == '-') {
                            z = TextScr.GetTextScriptNo(TextScr.gTS.p_read + 4);
                            ArmsItem.SubArmsData(z);
                            TextScr.gTS.p_read += 8;
                            continue;
                        }
                        if (TextScr.gTS.data[TextScr.gTS.p_read + 1] == 'Z' && TextScr.gTS.data[TextScr.gTS.p_read + 2] == 'A' && TextScr.gTS.data[TextScr.gTS.p_read + 3] == 'M') {
                            MycParam.ZeroArmsEnergy_All();
                            TextScr.gTS.p_read += 4;
                            continue;
                        }
                        if (TextScr.gTS.data[TextScr.gTS.p_read + 1] == 'T' && TextScr.gTS.data[TextScr.gTS.p_read + 2] == 'A' && TextScr.gTS.data[TextScr.gTS.p_read + 3] == 'M') {
                            x = TextScr.GetTextScriptNo(TextScr.gTS.p_read + 4);
                            y = TextScr.GetTextScriptNo(TextScr.gTS.p_read + 9);
                            z = TextScr.GetTextScriptNo(TextScr.gTS.p_read + 14);
                            ArmsItem.TradeArms(x, y, z);
                            TextScr.gTS.p_read += 18;
                            continue;
                        }
                        if (TextScr.gTS.data[TextScr.gTS.p_read + 1] == 'P' && TextScr.gTS.data[TextScr.gTS.p_read + 2] == 'S' && TextScr.gTS.data[TextScr.gTS.p_read + 3] == '+') {
                            x = TextScr.GetTextScriptNo(TextScr.gTS.p_read + 4);
                            y = TextScr.GetTextScriptNo(TextScr.gTS.p_read + 9);
                            SelStage.AddPermitStage(x, y);
                            TextScr.gTS.p_read += 13;
                            continue;
                        }
                        if (TextScr.gTS.data[TextScr.gTS.p_read + 1] == 'M' && TextScr.gTS.data[TextScr.gTS.p_read + 2] == 'P' && TextScr.gTS.data[TextScr.gTS.p_read + 3] == '+') {
                            x = TextScr.GetTextScriptNo(TextScr.gTS.p_read + 4);
                            MiniMap.SetMapping(x);
                            TextScr.gTS.p_read += 8;
                            continue;
                        }
                        if (TextScr.gTS.data[TextScr.gTS.p_read + 1] == 'U' && TextScr.gTS.data[TextScr.gTS.p_read + 2] == 'N' && TextScr.gTS.data[TextScr.gTS.p_read + 3] == 'I') {
                            z = TextScr.GetTextScriptNo(TextScr.gTS.p_read + 4);
                            MyChar.ChangeMyUnit((char)z);
                            TextScr.gTS.p_read += 8;
                            continue;
                        }
                        if (TextScr.gTS.data[TextScr.gTS.p_read + 1] == 'S' && TextScr.gTS.data[TextScr.gTS.p_read + 2] == 'T' && TextScr.gTS.data[TextScr.gTS.p_read + 3] == 'C') {
                            MycParam.SaveTimeCounter();
                            TextScr.gTS.p_read += 4;
                            continue;
                        }
                        if (TextScr.gTS.data[TextScr.gTS.p_read + 1] == 'T' && TextScr.gTS.data[TextScr.gTS.p_read + 2] == 'R' && TextScr.gTS.data[TextScr.gTS.p_read + 3] == 'A') {
                            z = TextScr.GetTextScriptNo(TextScr.gTS.p_read + 4);
                            if (Stage.TransferStage(z, w = TextScr.GetTextScriptNo(TextScr.gTS.p_read + 9), x = TextScr.GetTextScriptNo(TextScr.gTS.p_read + 14), y = TextScr.GetTextScriptNo(TextScr.gTS.p_read + 19))) continue;
                            JOptionPane.showMessageDialog(null, "\u30b9\u30c6\u30fc\u30b8\u306e\u8aad\u307f\u8fbc\u307f\u306b\u5931\u6557", "\u30a8\u30e9\u30fc", 0);
                            return 0;
                        }
                        if (TextScr.gTS.data[TextScr.gTS.p_read + 1] == 'M' && TextScr.gTS.data[TextScr.gTS.p_read + 2] == 'O' && TextScr.gTS.data[TextScr.gTS.p_read + 3] == 'V') {
                            x = TextScr.GetTextScriptNo(TextScr.gTS.p_read + 4);
                            y = TextScr.GetTextScriptNo(TextScr.gTS.p_read + 9);
                            MyChar.SetMyCharPosition(x * 512 * 16, y * 512 * 16);
                            TextScr.gTS.p_read += 13;
                            continue;
                        }
                        if (TextScr.gTS.data[TextScr.gTS.p_read + 1] == 'H' && TextScr.gTS.data[TextScr.gTS.p_read + 2] == 'M' && TextScr.gTS.data[TextScr.gTS.p_read + 3] == 'C') {
                            MyChar.ShowMyChar(false);
                            TextScr.gTS.p_read += 4;
                            continue;
                        }
                        if (TextScr.gTS.data[TextScr.gTS.p_read + 1] == 'S' && TextScr.gTS.data[TextScr.gTS.p_read + 2] == 'M' && TextScr.gTS.data[TextScr.gTS.p_read + 3] == 'C') {
                            MyChar.ShowMyChar(true);
                            TextScr.gTS.p_read += 4;
                            continue;
                        }
                        if (TextScr.gTS.data[TextScr.gTS.p_read + 1] == 'F' && TextScr.gTS.data[TextScr.gTS.p_read + 2] == 'L' && TextScr.gTS.data[TextScr.gTS.p_read + 3] == '+') {
                            z = TextScr.GetTextScriptNo(TextScr.gTS.p_read + 4);
                            Flags.SetNPCFlag(z);
                            TextScr.gTS.p_read += 8;
                            continue;
                        }
                        if (TextScr.gTS.data[TextScr.gTS.p_read + 1] == 'F' && TextScr.gTS.data[TextScr.gTS.p_read + 2] == 'L' && TextScr.gTS.data[TextScr.gTS.p_read + 3] == '-') {
                            z = TextScr.GetTextScriptNo(TextScr.gTS.p_read + 4);
                            Flags.CutNPCFlag(z);
                            TextScr.gTS.p_read += 8;
                            continue;
                        }
                        if (TextScr.gTS.data[TextScr.gTS.p_read + 1] == 'S' && TextScr.gTS.data[TextScr.gTS.p_read + 2] == 'K' && TextScr.gTS.data[TextScr.gTS.p_read + 3] == '+') {
                            z = TextScr.GetTextScriptNo(TextScr.gTS.p_read + 4);
                            Flags.SetSkipFlag(z);
                            TextScr.gTS.p_read += 8;
                            continue;
                        }
                        if (TextScr.gTS.data[TextScr.gTS.p_read + 1] == 'S' && TextScr.gTS.data[TextScr.gTS.p_read + 2] == 'K' && TextScr.gTS.data[TextScr.gTS.p_read + 3] == '-') {
                            z = TextScr.GetTextScriptNo(TextScr.gTS.p_read + 4);
                            Flags.CutSkipFlag(z);
                            TextScr.gTS.p_read += 8;
                            continue;
                        }
                        if (TextScr.gTS.data[TextScr.gTS.p_read + 1] == 'K' && TextScr.gTS.data[TextScr.gTS.p_read + 2] == 'E' && TextScr.gTS.data[TextScr.gTS.p_read + 3] == 'Y') {
                            Game.g_GameFlags &= 0xFFFFFFFD;
                            Game.g_GameFlags |= 1;
                            MyChar.gMC.up = false;
                            MyChar.gMC.shock = '\u0000';
                            TextScr.gTS.p_read += 4;
                            continue;
                        }
                        if (TextScr.gTS.data[TextScr.gTS.p_read + 1] == 'P' && TextScr.gTS.data[TextScr.gTS.p_read + 2] == 'R' && TextScr.gTS.data[TextScr.gTS.p_read + 3] == 'I') {
                            Game.g_GameFlags &= 0xFFFFFFFC;
                            MyChar.gMC.shock = '\u0000';
                            TextScr.gTS.p_read += 4;
                            continue;
                        }
                        if (TextScr.gTS.data[TextScr.gTS.p_read + 1] == 'F' && TextScr.gTS.data[TextScr.gTS.p_read + 2] == 'R' && TextScr.gTS.data[TextScr.gTS.p_read + 3] == 'E') {
                            Game.g_GameFlags |= 3;
                            TextScr.gTS.p_read += 4;
                            continue;
                        }
                        if (TextScr.gTS.data[TextScr.gTS.p_read + 1] == 'N' && TextScr.gTS.data[TextScr.gTS.p_read + 2] == 'O' && TextScr.gTS.data[TextScr.gTS.p_read + 3] == 'D') {
                            TextScr.gTS.mode = (byte)2;
                            TextScr.gTS.p_read += 4;
                            bExit = true;
                            continue;
                        }
                        if (TextScr.gTS.data[TextScr.gTS.p_read + 1] == 'C' && TextScr.gTS.data[TextScr.gTS.p_read + 2] == 'L' && TextScr.gTS.data[TextScr.gTS.p_read + 3] == 'R') {
                            TextScr.ClearTextLine();
                            TextScr.gTS.p_read += 4;
                            continue;
                        }
                        if (TextScr.gTS.data[TextScr.gTS.p_read + 1] == 'M' && TextScr.gTS.data[TextScr.gTS.p_read + 2] == 'S' && TextScr.gTS.data[TextScr.gTS.p_read + 3] == 'G') {
                            TextScr.ClearTextLine();
                            TextScr.gTS.flags = (byte)(TextScr.gTS.flags | 3);
                            TextScr.gTS.flags = (byte)(TextScr.gTS.flags & 0xFFFFFFCF);
                            if ((TextScr.gTS.flags & 0x40) != 0) {
                                TextScr.gTS.flags = (byte)(TextScr.gTS.flags | 0x10);
                            }
                            TextScr.gTS.p_read += 4;
                            bExit = true;
                            continue;
                        }
                        if (TextScr.gTS.data[TextScr.gTS.p_read + 1] == 'M' && TextScr.gTS.data[TextScr.gTS.p_read + 2] == 'S' && TextScr.gTS.data[TextScr.gTS.p_read + 3] == '2') {
                            TextScr.ClearTextLine();
                            TextScr.gTS.flags = (byte)(TextScr.gTS.flags & 0xFFFFFFED);
                            TextScr.gTS.flags = (byte)(TextScr.gTS.flags | 0x21);
                            if ((TextScr.gTS.flags & 0x40) != 0) {
                                TextScr.gTS.flags = (byte)(TextScr.gTS.flags | 0x10);
                            }
                            TextScr.gTS.face = 0;
                            TextScr.gTS.p_read += 4;
                            bExit = true;
                            continue;
                        }
                        if (TextScr.gTS.data[TextScr.gTS.p_read + 1] == 'M' && TextScr.gTS.data[TextScr.gTS.p_read + 2] == 'S' && TextScr.gTS.data[TextScr.gTS.p_read + 3] == '3') {
                            TextScr.ClearTextLine();
                            TextScr.gTS.flags = (byte)(TextScr.gTS.flags & 0xFFFFFFEF);
                            TextScr.gTS.flags = (byte)(TextScr.gTS.flags | 0x23);
                            if ((TextScr.gTS.flags & 0x40) != 0) {
                                TextScr.gTS.flags = (byte)(TextScr.gTS.flags | 0x10);
                            }
                            TextScr.gTS.p_read += 4;
                            bExit = true;
                            continue;
                        }
                        if (TextScr.gTS.data[TextScr.gTS.p_read + 1] == 'W' && TextScr.gTS.data[TextScr.gTS.p_read + 2] == 'A' && TextScr.gTS.data[TextScr.gTS.p_read + 3] == 'I') {
                            TextScr.gTS.mode = (byte)4;
                            TextScr.gTS.wait_next = TextScr.GetTextScriptNo(TextScr.gTS.p_read + 4);
                            TextScr.gTS.p_read += 8;
                            bExit = true;
                            continue;
                        }
                        if (TextScr.gTS.data[TextScr.gTS.p_read + 1] == 'W' && TextScr.gTS.data[TextScr.gTS.p_read + 2] == 'A' && TextScr.gTS.data[TextScr.gTS.p_read + 3] == 'S') {
                            TextScr.gTS.mode = (byte)7;
                            TextScr.gTS.p_read += 4;
                            bExit = true;
                            continue;
                        }
                        if (TextScr.gTS.data[TextScr.gTS.p_read + 1] == 'T' && TextScr.gTS.data[TextScr.gTS.p_read + 2] == 'U' && TextScr.gTS.data[TextScr.gTS.p_read + 3] == 'R') {
                            TextScr.gTS.p_read += 4;
                            TextScr.gTS.flags = (byte)(TextScr.gTS.flags | 0x10);
                            continue;
                        }
                        if (TextScr.gTS.data[TextScr.gTS.p_read + 1] == 'S' && TextScr.gTS.data[TextScr.gTS.p_read + 2] == 'A' && TextScr.gTS.data[TextScr.gTS.p_read + 3] == 'T') {
                            TextScr.gTS.p_read += 4;
                            TextScr.gTS.flags = (byte)(TextScr.gTS.flags | 0x40);
                            continue;
                        }
                        if (TextScr.gTS.data[TextScr.gTS.p_read + 1] == 'C' && TextScr.gTS.data[TextScr.gTS.p_read + 2] == 'A' && TextScr.gTS.data[TextScr.gTS.p_read + 3] == 'T') {
                            TextScr.gTS.p_read += 4;
                            TextScr.gTS.flags = (byte)(TextScr.gTS.flags | 0x40);
                            continue;
                        }
                        if (TextScr.gTS.data[TextScr.gTS.p_read + 1] == 'C' && TextScr.gTS.data[TextScr.gTS.p_read + 2] == 'L' && TextScr.gTS.data[TextScr.gTS.p_read + 3] == 'O') {
                            TextScr.gTS.flags = (byte)(TextScr.gTS.flags & 0xFFFFFFCC);
                            TextScr.gTS.p_read += 4;
                            continue;
                        }
                        if (TextScr.gTS.data[TextScr.gTS.p_read + 1] == 'E' && TextScr.gTS.data[TextScr.gTS.p_read + 2] == 'V' && TextScr.gTS.data[TextScr.gTS.p_read + 3] == 'E') {
                            z = TextScr.GetTextScriptNo(TextScr.gTS.p_read + 4);
                            TextScr.JumpTextScript(z);
                            continue;
                        }
                        if (TextScr.gTS.data[TextScr.gTS.p_read + 1] == 'Y' && TextScr.gTS.data[TextScr.gTS.p_read + 2] == 'N' && TextScr.gTS.data[TextScr.gTS.p_read + 3] == 'J') {
                            TextScr.gTS.next_event = TextScr.GetTextScriptNo(TextScr.gTS.p_read + 4);
                            TextScr.gTS.p_read += 8;
                            TextScr.gTS.mode = (byte)6;
                            Sound.PlaySoundObject(5, 1);
                            TextScr.gTS.wait = 0;
                            TextScr.gTS.select = 0;
                            bExit = true;
                            continue;
                        }
                        if (TextScr.gTS.data[TextScr.gTS.p_read + 1] == 'F' && TextScr.gTS.data[TextScr.gTS.p_read + 2] == 'L' && TextScr.gTS.data[TextScr.gTS.p_read + 3] == 'J') {
                            x = TextScr.GetTextScriptNo(TextScr.gTS.p_read + 4);
                            z = TextScr.GetTextScriptNo(TextScr.gTS.p_read + 9);
                            if (Flags.GetNPCFlag(x)) {
                                TextScr.JumpTextScript(z);
                                continue;
                            }
                            TextScr.gTS.p_read += 13;
                            continue;
                        }
                        if (TextScr.gTS.data[TextScr.gTS.p_read + 1] == 'S' && TextScr.gTS.data[TextScr.gTS.p_read + 2] == 'K' && TextScr.gTS.data[TextScr.gTS.p_read + 3] == 'J') {
                            x = TextScr.GetTextScriptNo(TextScr.gTS.p_read + 4);
                            z = TextScr.GetTextScriptNo(TextScr.gTS.p_read + 9);
                            if (Flags.GetSkipFlag(x)) {
                                TextScr.JumpTextScript(z);
                                continue;
                            }
                            TextScr.gTS.p_read += 13;
                            continue;
                        }
                        if (TextScr.gTS.data[TextScr.gTS.p_read + 1] == 'I' && TextScr.gTS.data[TextScr.gTS.p_read + 2] == 'T' && TextScr.gTS.data[TextScr.gTS.p_read + 3] == 'J') {
                            x = TextScr.GetTextScriptNo(TextScr.gTS.p_read + 4);
                            z = TextScr.GetTextScriptNo(TextScr.gTS.p_read + 9);
                            if (ArmsItem.CheckItem(x)) {
                                TextScr.JumpTextScript(z);
                                continue;
                            }
                            TextScr.gTS.p_read += 13;
                            continue;
                        }
                        if (TextScr.gTS.data[TextScr.gTS.p_read + 1] == 'A' && TextScr.gTS.data[TextScr.gTS.p_read + 2] == 'M' && TextScr.gTS.data[TextScr.gTS.p_read + 3] == 'J') {
                            x = TextScr.GetTextScriptNo(TextScr.gTS.p_read + 4);
                            z = TextScr.GetTextScriptNo(TextScr.gTS.p_read + 9);
                            if (ArmsItem.CheckArms(x)) {
                                TextScr.JumpTextScript(z);
                                continue;
                            }
                            TextScr.gTS.p_read += 13;
                            continue;
                        }
                        if (TextScr.gTS.data[TextScr.gTS.p_read + 1] == 'U' && TextScr.gTS.data[TextScr.gTS.p_read + 2] == 'N' && TextScr.gTS.data[TextScr.gTS.p_read + 3] == 'J') {
                            x = TextScr.GetTextScriptNo(TextScr.gTS.p_read + 4);
                            z = TextScr.GetTextScriptNo(TextScr.gTS.p_read + 9);
                            if (MyChar.GetUnitMyChar() == x) {
                                TextScr.JumpTextScript(z);
                                continue;
                            }
                            TextScr.gTS.p_read += 13;
                            continue;
                        }
                        if (TextScr.gTS.data[TextScr.gTS.p_read + 1] == 'E' && TextScr.gTS.data[TextScr.gTS.p_read + 2] == 'C' && TextScr.gTS.data[TextScr.gTS.p_read + 3] == 'J') {
                            x = TextScr.GetTextScriptNo(TextScr.gTS.p_read + 4);
                            z = TextScr.GetTextScriptNo(TextScr.gTS.p_read + 9);
                            if (NpChar.GetNpCharAlive(x)) {
                                TextScr.JumpTextScript(z);
                                continue;
                            }
                            TextScr.gTS.p_read += 13;
                            continue;
                        }
                        if (TextScr.gTS.data[TextScr.gTS.p_read + 1] == 'N' && TextScr.gTS.data[TextScr.gTS.p_read + 2] == 'C' && TextScr.gTS.data[TextScr.gTS.p_read + 3] == 'J') {
                            x = TextScr.GetTextScriptNo(TextScr.gTS.p_read + 4);
                            z = TextScr.GetTextScriptNo(TextScr.gTS.p_read + 9);
                            if (NpChar.IsNpCharCode(x)) {
                                TextScr.JumpTextScript(z);
                                continue;
                            }
                            TextScr.gTS.p_read += 13;
                            continue;
                        }
                        if (TextScr.gTS.data[TextScr.gTS.p_read + 1] == 'M' && TextScr.gTS.data[TextScr.gTS.p_read + 2] == 'P' && TextScr.gTS.data[TextScr.gTS.p_read + 3] == 'J') {
                            x = TextScr.GetTextScriptNo(TextScr.gTS.p_read + 4);
                            if (MiniMap.IsMapping()) {
                                TextScr.JumpTextScript(x);
                                continue;
                            }
                            TextScr.gTS.p_read += 8;
                            continue;
                        }
                        if (TextScr.gTS.data[TextScr.gTS.p_read + 1] == 'S' && TextScr.gTS.data[TextScr.gTS.p_read + 2] == 'S' && TextScr.gTS.data[TextScr.gTS.p_read + 3] == 'S') {
                            x = TextScr.GetTextScriptNo(TextScr.gTS.p_read + 4);
                            MyChar.SetNoise(1, x);
                            TextScr.gTS.p_read += 8;
                            continue;
                        }
                        if (TextScr.gTS.data[TextScr.gTS.p_read + 1] == 'C' && TextScr.gTS.data[TextScr.gTS.p_read + 2] == 'S' && TextScr.gTS.data[TextScr.gTS.p_read + 3] == 'S') {
                            MyChar.CutNoise();
                            TextScr.gTS.p_read += 4;
                            continue;
                        }
                        if (TextScr.gTS.data[TextScr.gTS.p_read + 1] == 'S' && TextScr.gTS.data[TextScr.gTS.p_read + 2] == 'P' && TextScr.gTS.data[TextScr.gTS.p_read + 3] == 'S') {
                            MyChar.SetNoise(2, x);
                            TextScr.gTS.p_read += 4;
                            continue;
                        }
                        if (TextScr.gTS.data[TextScr.gTS.p_read + 1] == 'C' && TextScr.gTS.data[TextScr.gTS.p_read + 2] == 'P' && TextScr.gTS.data[TextScr.gTS.p_read + 3] == 'S') {
                            MyChar.CutNoise();
                            TextScr.gTS.p_read += 4;
                            continue;
                        }
                        if (TextScr.gTS.data[TextScr.gTS.p_read + 1] == 'Q' && TextScr.gTS.data[TextScr.gTS.p_read + 2] == 'U' && TextScr.gTS.data[TextScr.gTS.p_read + 3] == 'A') {
                            z = TextScr.GetTextScriptNo(TextScr.gTS.p_read + 4);
                            Frame.SetQuake(z);
                            TextScr.gTS.p_read += 8;
                            continue;
                        }
                        if (TextScr.gTS.data[TextScr.gTS.p_read + 1] == 'F' && TextScr.gTS.data[TextScr.gTS.p_read + 2] == 'L' && TextScr.gTS.data[TextScr.gTS.p_read + 3] == 'A') {
                            Flash.SetFlash(0, 0, 2);
                            TextScr.gTS.p_read += 4;
                            continue;
                        }
                        if (TextScr.gTS.data[TextScr.gTS.p_read + 1] == 'F' && TextScr.gTS.data[TextScr.gTS.p_read + 2] == 'A' && TextScr.gTS.data[TextScr.gTS.p_read + 3] == 'I') {
                            z = TextScr.GetTextScriptNo(TextScr.gTS.p_read + 4);
                            Fade.StartFadeIn((byte)z);
                            TextScr.gTS.mode = (byte)5;
                            TextScr.gTS.p_read += 8;
                            bExit = true;
                            continue;
                        }
                        if (TextScr.gTS.data[TextScr.gTS.p_read + 1] == 'F' && TextScr.gTS.data[TextScr.gTS.p_read + 2] == 'A' && TextScr.gTS.data[TextScr.gTS.p_read + 3] == 'O') {
                            z = TextScr.GetTextScriptNo(TextScr.gTS.p_read + 4);
                            Fade.StartFadeOut((byte)z);
                            TextScr.gTS.mode = (byte)5;
                            TextScr.gTS.p_read += 8;
                            bExit = true;
                            continue;
                        }
                        if (TextScr.gTS.data[TextScr.gTS.p_read + 1] == 'M' && TextScr.gTS.data[TextScr.gTS.p_read + 2] == 'N' && TextScr.gTS.data[TextScr.gTS.p_read + 3] == 'A') {
                            MapName.StartMapName();
                            TextScr.gTS.p_read += 4;
                            continue;
                        }
                        if (TextScr.gTS.data[TextScr.gTS.p_read + 1] == 'F' && TextScr.gTS.data[TextScr.gTS.p_read + 2] == 'O' && TextScr.gTS.data[TextScr.gTS.p_read + 3] == 'M') {
                            z = TextScr.GetTextScriptNo(TextScr.gTS.p_read + 4);
                            Frame.SetFrameTargetMyChar(z);
                            TextScr.gTS.p_read += 8;
                            continue;
                        }
                        if (TextScr.gTS.data[TextScr.gTS.p_read + 1] == 'F' && TextScr.gTS.data[TextScr.gTS.p_read + 2] == 'O' && TextScr.gTS.data[TextScr.gTS.p_read + 3] == 'N') {
                            x = TextScr.GetTextScriptNo(TextScr.gTS.p_read + 4);
                            y = TextScr.GetTextScriptNo(TextScr.gTS.p_read + 9);
                            Frame.SetFrameTargetNpChar(x, y);
                            TextScr.gTS.p_read += 13;
                            continue;
                        }
                        if (TextScr.gTS.data[TextScr.gTS.p_read + 1] == 'F' && TextScr.gTS.data[TextScr.gTS.p_read + 2] == 'O' && TextScr.gTS.data[TextScr.gTS.p_read + 3] == 'B') {
                            x = TextScr.GetTextScriptNo(TextScr.gTS.p_read + 4);
                            y = TextScr.GetTextScriptNo(TextScr.gTS.p_read + 9);
                            Frame.SetFrameTargetBoss(x, y);
                            TextScr.gTS.p_read += 13;
                            continue;
                        }
                        if (TextScr.gTS.data[TextScr.gTS.p_read + 1] == 'S' && TextScr.gTS.data[TextScr.gTS.p_read + 2] == 'O' && TextScr.gTS.data[TextScr.gTS.p_read + 3] == 'U') {
                            z = TextScr.GetTextScriptNo(TextScr.gTS.p_read + 4);
                            Sound.PlaySoundObject(z, 1);
                            TextScr.gTS.p_read += 8;
                            continue;
                        }
                        if (TextScr.gTS.data[TextScr.gTS.p_read + 1] == 'C' && TextScr.gTS.data[TextScr.gTS.p_read + 2] == 'M' && TextScr.gTS.data[TextScr.gTS.p_read + 3] == 'U') {
                            z = TextScr.GetTextScriptNo(TextScr.gTS.p_read + 4);
                            Stage.ChangeMusic(z);
                            TextScr.gTS.p_read += 8;
                            continue;
                        }
                        if (TextScr.gTS.data[TextScr.gTS.p_read + 1] == 'F' && TextScr.gTS.data[TextScr.gTS.p_read + 2] == 'M' && TextScr.gTS.data[TextScr.gTS.p_read + 3] == 'U') {
                            Organya.SetOrganyaFadeout();
                            TextScr.gTS.p_read += 4;
                            continue;
                        }
                        if (TextScr.gTS.data[TextScr.gTS.p_read + 1] == 'R' && TextScr.gTS.data[TextScr.gTS.p_read + 2] == 'M' && TextScr.gTS.data[TextScr.gTS.p_read + 3] == 'U') {
                            Stage.ReCallMusic();
                            TextScr.gTS.p_read += 4;
                            continue;
                        }
                        if (TextScr.gTS.data[TextScr.gTS.p_read + 1] == 'M' && TextScr.gTS.data[TextScr.gTS.p_read + 2] == 'L' && TextScr.gTS.data[TextScr.gTS.p_read + 3] == 'P') {
                            TextScr.gTS.p_read += 4;
                            bExit = true;
                            switch (MiniMap.MiniMapLoop()) {
                                case 0: {
                                    return 0;
                                }
                                case 2: {
                                    return 2;
                                }
                            }
                            continue;
                        }
                        if (TextScr.gTS.data[TextScr.gTS.p_read + 1] == 'S' && TextScr.gTS.data[TextScr.gTS.p_read + 2] == 'L' && TextScr.gTS.data[TextScr.gTS.p_read + 3] == 'P') {
                            bExit = true;
                            int[] pz = new int[1];
                            switch (SelStage.StageSelectLoop(pz)) {
                                case 0: {
                                    return 0;
                                }
                                case 2: {
                                    return 2;
                                }
                            }
                            z = pz[0];
                            TextScr.JumpTextScript(z);
                            Game.g_GameFlags &= 0xFFFFFFFC;
                            continue;
                        }
                        if (TextScr.gTS.data[TextScr.gTS.p_read + 1] == 'D' && TextScr.gTS.data[TextScr.gTS.p_read + 2] == 'N' && TextScr.gTS.data[TextScr.gTS.p_read + 3] == 'P') {
                            z = TextScr.GetTextScriptNo(TextScr.gTS.p_read + 4);
                            NpChar.DeleteNpCharEvent(z);
                            TextScr.gTS.p_read += 8;
                            continue;
                        }
                        if (TextScr.gTS.data[TextScr.gTS.p_read + 1] == 'D' && TextScr.gTS.data[TextScr.gTS.p_read + 2] == 'N' && TextScr.gTS.data[TextScr.gTS.p_read + 3] == 'A') {
                            z = TextScr.GetTextScriptNo(TextScr.gTS.p_read + 4);
                            NpChar.DeleteNpCharCode(z, true);
                            TextScr.gTS.p_read += 8;
                            continue;
                        }
                        if (TextScr.gTS.data[TextScr.gTS.p_read + 1] == 'B' && TextScr.gTS.data[TextScr.gTS.p_read + 2] == 'O' && TextScr.gTS.data[TextScr.gTS.p_read + 3] == 'A') {
                            z = TextScr.GetTextScriptNo(TextScr.gTS.p_read + 4);
                            Boss.SetBossCharActNo(z);
                            TextScr.gTS.p_read += 8;
                            continue;
                        }
                        if (TextScr.gTS.data[TextScr.gTS.p_read + 1] == 'C' && TextScr.gTS.data[TextScr.gTS.p_read + 2] == 'N' && TextScr.gTS.data[TextScr.gTS.p_read + 3] == 'P') {
                            x = TextScr.GetTextScriptNo(TextScr.gTS.p_read + 4);
                            y = TextScr.GetTextScriptNo(TextScr.gTS.p_read + 9);
                            z = TextScr.GetTextScriptNo(TextScr.gTS.p_read + 14);
                            NpChar.ChangeNpCharByEvent(x, y, z);
                            TextScr.gTS.p_read += 18;
                            continue;
                        }
                        if (TextScr.gTS.data[TextScr.gTS.p_read + 1] == 'A' && TextScr.gTS.data[TextScr.gTS.p_read + 2] == 'N' && TextScr.gTS.data[TextScr.gTS.p_read + 3] == 'P') {
                            x = TextScr.GetTextScriptNo(TextScr.gTS.p_read + 4);
                            y = TextScr.GetTextScriptNo(TextScr.gTS.p_read + 9);
                            z = TextScr.GetTextScriptNo(TextScr.gTS.p_read + 14);
                            NpChar.SetNpCharActionNo(x, y, z);
                            TextScr.gTS.p_read += 18;
                            continue;
                        }
                        if (TextScr.gTS.data[TextScr.gTS.p_read + 1] == 'I' && TextScr.gTS.data[TextScr.gTS.p_read + 2] == 'N' && TextScr.gTS.data[TextScr.gTS.p_read + 3] == 'P') {
                            x = TextScr.GetTextScriptNo(TextScr.gTS.p_read + 4);
                            y = TextScr.GetTextScriptNo(TextScr.gTS.p_read + 9);
                            z = TextScr.GetTextScriptNo(TextScr.gTS.p_read + 14);
                            NpChar.ChangeCheckableNpCharByEvent(x, y, z);
                            TextScr.gTS.p_read += 18;
                            continue;
                        }
                        if (TextScr.gTS.data[TextScr.gTS.p_read + 1] == 'S' && TextScr.gTS.data[TextScr.gTS.p_read + 2] == 'N' && TextScr.gTS.data[TextScr.gTS.p_read + 3] == 'P') {
                            w = TextScr.GetTextScriptNo(TextScr.gTS.p_read + 4);
                            x = TextScr.GetTextScriptNo(TextScr.gTS.p_read + 9);
                            y = TextScr.GetTextScriptNo(TextScr.gTS.p_read + 14);
                            z = TextScr.GetTextScriptNo(TextScr.gTS.p_read + 19);
                            NpChar.SetNpChar(w, x * 512 * 16, y * 512 * 16, 0, 0, z, null, 256);
                            TextScr.gTS.p_read += 23;
                            continue;
                        }
                        if (TextScr.gTS.data[TextScr.gTS.p_read + 1] == 'M' && TextScr.gTS.data[TextScr.gTS.p_read + 2] == 'N' && TextScr.gTS.data[TextScr.gTS.p_read + 3] == 'P') {
                            w = TextScr.GetTextScriptNo(TextScr.gTS.p_read + 4);
                            x = TextScr.GetTextScriptNo(TextScr.gTS.p_read + 9);
                            y = TextScr.GetTextScriptNo(TextScr.gTS.p_read + 14);
                            z = TextScr.GetTextScriptNo(TextScr.gTS.p_read + 19);
                            NpChar.MoveNpChar(w, x * 512 * 16, y * 512 * 16, z);
                            TextScr.gTS.p_read += 23;
                            continue;
                        }
                        if (TextScr.gTS.data[TextScr.gTS.p_read + 1] == 'S' && TextScr.gTS.data[TextScr.gTS.p_read + 2] == 'M' && TextScr.gTS.data[TextScr.gTS.p_read + 3] == 'P') {
                            x = TextScr.GetTextScriptNo(TextScr.gTS.p_read + 4);
                            y = TextScr.GetTextScriptNo(TextScr.gTS.p_read + 9);
                            Map.ShiftMapParts(x, y);
                            TextScr.gTS.p_read += 13;
                            continue;
                        }
                        if (TextScr.gTS.data[TextScr.gTS.p_read + 1] == 'C' && TextScr.gTS.data[TextScr.gTS.p_read + 2] == 'M' && TextScr.gTS.data[TextScr.gTS.p_read + 3] == 'P') {
                            x = TextScr.GetTextScriptNo(TextScr.gTS.p_read + 4);
                            y = TextScr.GetTextScriptNo(TextScr.gTS.p_read + 9);
                            z = TextScr.GetTextScriptNo(TextScr.gTS.p_read + 14);
                            Map.ChangeMapParts(x, y, (byte)z);
                            TextScr.gTS.p_read += 18;
                            continue;
                        }
                        if (TextScr.gTS.data[TextScr.gTS.p_read + 1] == 'B' && TextScr.gTS.data[TextScr.gTS.p_read + 2] == 'S' && TextScr.gTS.data[TextScr.gTS.p_read + 3] == 'L') {
                            z = TextScr.GetTextScriptNo(TextScr.gTS.p_read + 4);
                            if (z != 0) {
                                BossLife.StartBossLife(z);
                            } else {
                                BossLife.StartBossLife2();
                            }
                            TextScr.gTS.p_read += 8;
                            continue;
                        }
                        if (TextScr.gTS.data[TextScr.gTS.p_read + 1] == 'M' && TextScr.gTS.data[TextScr.gTS.p_read + 2] == 'Y' && TextScr.gTS.data[TextScr.gTS.p_read + 3] == 'D') {
                            z = TextScr.GetTextScriptNo(TextScr.gTS.p_read + 4);
                            MyChar.SetMyCharDirect((char)z);
                            TextScr.gTS.p_read += 8;
                            continue;
                        }
                        if (TextScr.gTS.data[TextScr.gTS.p_read + 1] == 'M' && TextScr.gTS.data[TextScr.gTS.p_read + 2] == 'Y' && TextScr.gTS.data[TextScr.gTS.p_read + 3] == 'B') {
                            z = TextScr.GetTextScriptNo(TextScr.gTS.p_read + 4);
                            NpChar.BackStepMyChar(z);
                            TextScr.gTS.p_read += 8;
                            continue;
                        }
                        if (TextScr.gTS.data[TextScr.gTS.p_read + 1] == 'M' && TextScr.gTS.data[TextScr.gTS.p_read + 2] == 'M' && TextScr.gTS.data[TextScr.gTS.p_read + 3] == '0') {
                            MyChar.ZeroMyCharXMove();
                            TextScr.gTS.p_read += 4;
                            continue;
                        }
                        if (TextScr.gTS.data[TextScr.gTS.p_read + 1] == 'I' && TextScr.gTS.data[TextScr.gTS.p_read + 2] == 'N' && TextScr.gTS.data[TextScr.gTS.p_read + 3] == 'I') {
                            Profile.InitializeGame();
                            TextScr.gTS.p_read += 4;
                            continue;
                        }
                        if (TextScr.gTS.data[TextScr.gTS.p_read + 1] == 'S' && TextScr.gTS.data[TextScr.gTS.p_read + 2] == 'V' && TextScr.gTS.data[TextScr.gTS.p_read + 3] == 'P') {
                            Profile.SaveProfile(null);
                            TextScr.gTS.p_read += 4;
                            continue;
                        }
                        if (TextScr.gTS.data[TextScr.gTS.p_read + 1] == 'L' && TextScr.gTS.data[TextScr.gTS.p_read + 2] == 'D' && TextScr.gTS.data[TextScr.gTS.p_read + 3] == 'P') {
                            if (Profile.LoadProfile(null)) continue;
                            Profile.InitializeGame();
                            continue;
                        }
                        if (TextScr.gTS.data[TextScr.gTS.p_read + 1] == 'F' && TextScr.gTS.data[TextScr.gTS.p_read + 2] == 'A' && TextScr.gTS.data[TextScr.gTS.p_read + 3] == 'C') {
                            z = TextScr.GetTextScriptNo(TextScr.gTS.p_read + 4);
                            if (TextScr.gTS.face != z) {
                                TextScr.gTS.face = z;
                                TextScr.gTS.face_x = 2048;
                            }
                            TextScr.gTS.p_read += 8;
                            continue;
                        }
                        if (TextScr.gTS.data[TextScr.gTS.p_read + 1] == 'F' && TextScr.gTS.data[TextScr.gTS.p_read + 2] == 'A' && TextScr.gTS.data[TextScr.gTS.p_read + 3] == 'C') {
                            z = TextScr.GetTextScriptNo(TextScr.gTS.p_read + 4);
                            if (TextScr.gTS.face != z) {
                                TextScr.gTS.face = z;
                                TextScr.gTS.face_x = 2048;
                            }
                            TextScr.gTS.p_read += 8;
                            continue;
                        }
                        if (TextScr.gTS.data[TextScr.gTS.p_read + 1] == 'G' && TextScr.gTS.data[TextScr.gTS.p_read + 2] == 'I' && TextScr.gTS.data[TextScr.gTS.p_read + 3] == 'T') {
                            TextScr.gTS.item = z = TextScr.GetTextScriptNo(TextScr.gTS.p_read + 4);
                            TextScr.gTS.item_y = 128;
                            TextScr.gTS.p_read += 8;
                            continue;
                        }
                        if (TextScr.gTS.data[TextScr.gTS.p_read + 1] == 'N' && TextScr.gTS.data[TextScr.gTS.p_read + 2] == 'U' && TextScr.gTS.data[TextScr.gTS.p_read + 3] == 'M') {
                            z = TextScr.GetTextScriptNo(TextScr.gTS.p_read + 4);
                            TextScr.SetNumberTextScript(z);
                            TextScr.gTS.p_read += 8;
                            continue;
                        }
                        if (TextScr.gTS.data[TextScr.gTS.p_read + 1] == 'C' && TextScr.gTS.data[TextScr.gTS.p_read + 2] == 'R' && TextScr.gTS.data[TextScr.gTS.p_read + 3] == 'E') {
                            Game.g_GameFlags |= 8;
                            Ending.StartCreditScript();
                            TextScr.gTS.p_read += 4;
                            continue;
                        }
                        if (TextScr.gTS.data[TextScr.gTS.p_read + 1] == 'S' && TextScr.gTS.data[TextScr.gTS.p_read + 2] == 'I' && TextScr.gTS.data[TextScr.gTS.p_read + 3] == 'L') {
                            z = TextScr.GetTextScriptNo(TextScr.gTS.p_read + 4);
                            Ending.SetCreditIllust(z);
                            TextScr.gTS.p_read += 8;
                            continue;
                        }
                        if (TextScr.gTS.data[TextScr.gTS.p_read + 1] == 'C' && TextScr.gTS.data[TextScr.gTS.p_read + 2] == 'I' && TextScr.gTS.data[TextScr.gTS.p_read + 3] == 'L') {
                            Ending.CutCreditIllust();
                            TextScr.gTS.p_read += 4;
                            continue;
                        }
                        if (TextScr.gTS.data[TextScr.gTS.p_read + 1] == 'X' && TextScr.gTS.data[TextScr.gTS.p_read + 2] == 'X' && TextScr.gTS.data[TextScr.gTS.p_read + 3] == '1') {
                            bExit = true;
                            z = TextScr.GetTextScriptNo(TextScr.gTS.p_read + 4);
                            switch (Ending.Scene_DownIsland(z)) {
                                case 0: {
                                    return 0;
                                }
                                case 2: {
                                    return 2;
                                }
                            }
                            TextScr.gTS.p_read += 8;
                            continue;
                        }
                        if (TextScr.gTS.data[TextScr.gTS.p_read + 1] == 'E' && TextScr.gTS.data[TextScr.gTS.p_read + 2] == 'S' && TextScr.gTS.data[TextScr.gTS.p_read + 3] == 'C') {
                            return 2;
                        }
                        String str_0 = String.format("\u4e0d\u660e\u306e\u30b3\u30fc\u30c9:<%c%c%c", Character.valueOf(TextScr.gTS.data[TextScr.gTS.p_read + 1]), Character.valueOf(TextScr.gTS.data[TextScr.gTS.p_read + 2]), Character.valueOf(TextScr.gTS.data[TextScr.gTS.p_read + 3]));
                        JOptionPane.showMessageDialog(null, str_0, "\u30a8\u30e9\u30fc", 0);
                        return 0;
                    }
                    if (TextScr.gTS.data[TextScr.gTS.p_read] == '\r') {
                        TextScr.gTS.p_read += 2;
                        TextScr.gTS.p_write = 0;
                        if ((TextScr.gTS.flags & 1) == 0) continue;
                        ++TextScr.gTS.line;
                        TextScr.CheckNewLine();
                        continue;
                    }
                    if ((TextScr.gTS.flags & 0x10) != 0) {
                        x = TextScr.gTS.p_read;
                        while (TextScr.gTS.data[x] != '<' && TextScr.gTS.data[x] != '\r') {
                            ++x;
                        }
                        y = x - TextScr.gTS.p_read;
                        System.arraycopy(TextScr.gTS.data, TextScr.gTS.p_read, str, 0, y);
                        str[y] = '\u0000';
                        TextScr.gTS.p_write = x;
                        Draw.PutText2(0, 0, CUtils.nullTermToString(str), 0xFFFFFE, 30 + TextScr.gTS.line % 4);
                        CUtils.strcpy(text[TextScr.gTS.line % 4], str);
                        TextScr.gTS.p_read += y;
                        if (TextScr.gTS.p_write >= 35) {
                            TextScr.CheckNewLine();
                        }
                        bExit = true;
                        continue;
                    }
                    c[0] = TextScr.gTS.data[TextScr.gTS.p_read];
                    if (c[0] == '=') {
                        Draw.Surface2Surface(TextScr.gTS.p_write * 6, 2, rcSymbol, 30 + TextScr.gTS.line % 4, 26);
                    } else {
                        Draw.PutText2(TextScr.gTS.p_write * 6, 0, CUtils.nullTermToString(c), 0xFFFFFE, 30 + TextScr.gTS.line % 4);
                    }
                    CUtils.strcat(text[TextScr.gTS.line % 4], c);
                    Sound.PlaySoundObject(2, 1);
                    TextScr.gTS.wait_beam = '\u0000';
                    ++TextScr.gTS.p_read;
                    TextScr.gTS.p_write += WcWidth.of(c[0]);
                    if (TextScr.gTS.p_write >= 35) {
                        TextScr.CheckNewLine();
                        TextScr.gTS.p_write = 0;
                        ++TextScr.gTS.line;
                        TextScr.CheckNewLine();
                    }
                    bExit = true;
                }
                break;
            }
            case 2: {
                if ((KeyControl.gKeyTrg & (KeyControl.gKeyOk | KeyControl.gKeyCancel)) == 0) break;
                TextScr.gTS.mode = 1;
                break;
            }
            case 3: {
                for (i = 0; i < 4; ++i) {
                    int n = i;
                    TextScr.gTS.ypos_line[n] = TextScr.gTS.ypos_line[n] - 4;
                    if (TextScr.gTS.ypos_line[i] == 0) {
                        TextScr.gTS.mode = 1;
                    }
                    if (TextScr.gTS.ypos_line[i] != -16) continue;
                    TextScr.gTS.ypos_line[i] = 48;
                }
                break;
            }
            case 4: {
                if (TextScr.gTS.wait_next == 9999) break;
                if (TextScr.gTS.wait != 9999) {
                    ++TextScr.gTS.wait;
                }
                if (TextScr.gTS.wait < TextScr.gTS.wait_next) break;
                TextScr.gTS.mode = 1;
                TextScr.gTS.wait_beam = '\u0000';
                break;
            }
            case 5: {
                if (Fade.GetFadeActive()) break;
                TextScr.gTS.mode = 1;
                TextScr.gTS.wait_beam = '\u0000';
                break;
            }
            case 7: {
                if ((MyChar.gMC.flag & 8) == 0) break;
                TextScr.gTS.mode = 1;
                TextScr.gTS.wait_beam = '\u0000';
                break;
            }
            case 6: {
                if (TextScr.gTS.wait < 16) {
                    ++TextScr.gTS.wait;
                    break;
                }
                if ((KeyControl.gKeyTrg & KeyControl.gKeyOk) != 0) {
                    Sound.PlaySoundObject(18, 1);
                    if (TextScr.gTS.select == 1) {
                        TextScr.JumpTextScript(TextScr.gTS.next_event);
                        break;
                    }
                    TextScr.gTS.mode = 1;
                    TextScr.gTS.wait_beam = '\u0000';
                    break;
                }
                if ((KeyControl.gKeyTrg & KeyControl.gKeyLeft) != 0) {
                    TextScr.gTS.select = 0;
                    Sound.PlaySoundObject(1, 1);
                    break;
                }
                if ((KeyControl.gKeyTrg & KeyControl.gKeyRight) == 0) break;
                TextScr.gTS.select = 1;
                Sound.PlaySoundObject(1, 1);
            }
        }
        Game.g_GameFlags = TextScr.gTS.mode == 0 ? (Game.g_GameFlags &= 0xFFFFFFFB) : (Game.g_GameFlags |= 4);
        return 1;
    }

    public static void RestoreTextScript() {
        for (int i = 0; i < 4; ++i) {
            Draw.CortBox2(gRect_line, 0, 30 + i);
            Draw.PutText2(0, 0, CUtils.nullTermToString(text[i]), 0xFFFFFE, 30 + i);
        }
    }

    public static class TEXT_SCRIPT {
        String path = "";
        long size = 0L;
        char[] data = null;
        byte mode = 0;
        byte flags = 0;
        int p_read = 0;
        int p_write = 0;
        int line = 0;
        int[] ypos_line = new int[4];
        int wait = 0;
        int wait_next = 0;
        int next_event = 0;
        byte select = 0;
        int face = 0;
        int face_x = 0;
        int item = 0;
        int item_y = 0;
        RECT rcText = new RECT();
        int offsetY = 0;
        char wait_beam;
    }
}
