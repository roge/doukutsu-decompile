/*
 * Decompiled with CFR 0.152.
 */
package jp.studiopixel.doukutsu;

import java.util.Arrays;
import jp.studiopixel.doukutsu.ArmsItem;
import jp.studiopixel.doukutsu.Caret;
import jp.studiopixel.doukutsu.DataLoader;
import jp.studiopixel.doukutsu.Draw;
import jp.studiopixel.doukutsu.Flags;
import jp.studiopixel.doukutsu.Game;
import jp.studiopixel.doukutsu.MyChar;
import jp.studiopixel.doukutsu.NpcTbl;
import jp.studiopixel.doukutsu.RECT;
import jp.studiopixel.doukutsu.Sound;
import jp.studiopixel.doukutsu.ValueView;

public class NpChar {
    public static final int NPC_SOLID_SOFT = 1;
    public static final int NPC_IGNORE_TILE_44 = 2;
    public static final int NPC_INVULNERABLE = 4;
    public static final int NPC_IGNORE_SOLIDITY = 8;
    public static final int NPC_BOUNCY = 16;
    public static final int NPC_SHOOTABLE = 32;
    public static final int NPC_SOLID_HARD = 64;
    public static final int NPC_REAR_AND_TOP_DONT_HURT = 128;
    public static final int NPC_EVENT_WHEN_TOUCHED = 256;
    public static final int NPC_EVENT_WHEN_KILLED = 512;
    public static final int NPC_APPEAR_WHEN_FLAG_SET = 2048;
    public static final int NPC_SPAWN_IN_OTHER_DIRECTION = 4096;
    public static final int NPC_INTERACTABLE = 8192;
    public static final int NPC_HIDE_WHEN_FLAG_SET = 16384;
    public static final int NPC_SHOW_DAMAGE = 32768;
    public static NPCHAR[] gNPC = new NPCHAR[512];
    public static int gCurlyShoot_wait;
    public static int gCurlyShoot_x;
    public static int gCurlyShoot_y;
    public static int gSuperXpos;
    public static int gSuperYpos;
    private static final byte[] gPassPixEve;

    public static void SetUniqueParameter(NPCHAR npc) {
        int code = npc.code_char;
        npc.surf = NpcTbl.gNpcTable[code].surf;
        npc.hit_voice = NpcTbl.gNpcTable[code].hit_voice;
        npc.destroy_voice = NpcTbl.gNpcTable[code].destroy_voice;
        npc.damage = NpcTbl.gNpcTable[code].damage;
        npc.size = NpcTbl.gNpcTable[code].size;
        npc.life = NpcTbl.gNpcTable[code].life;
        npc.hit.front = NpcTbl.gNpcTable[code].hit.front * 512;
        npc.hit.back = NpcTbl.gNpcTable[code].hit.back * 512;
        npc.hit.top = NpcTbl.gNpcTable[code].hit.top * 512;
        npc.hit.bottom = NpcTbl.gNpcTable[code].hit.bottom * 512;
        npc.view.front = NpcTbl.gNpcTable[code].view.front * 512;
        npc.view.back = NpcTbl.gNpcTable[code].view.back * 512;
        npc.view.top = NpcTbl.gNpcTable[code].view.top * 512;
        npc.view.bottom = NpcTbl.gNpcTable[code].view.bottom * 512;
    }

    public static void InitNpChar() {
        for (int i = 0; i < gNPC.length; ++i) {
            gNPC[i].clear();
        }
    }

    public static boolean LoadEvent(String path_event) {
        String path = "/" + path_event;
        try {
            DataLoader.DataFile file = DataLoader.load(path);
            byte[] code = new byte[4];
            file.readFully(code);
            if (!Arrays.equals(code, gPassPixEve)) {
                return false;
            }
            int count = file.readInt();
            NpChar.InitNpChar();
            EVENT eve = new EVENT();
            int n = 170;
            for (int i = 0; i < count; ++i) {
                eve.x = file.readShort();
                eve.y = file.readShort();
                eve.code_flag = file.readShort();
                eve.code_event = file.readShort();
                eve.code_char = file.readShort();
                eve.bits = (char)file.readUnsignedShort();
                NpChar.gNPC[n].direct = (eve.bits & 0x1000) != 0 ? 2 : 0;
                NpChar.gNPC[n].code_char = eve.code_char;
                NpChar.gNPC[n].code_event = eve.code_event;
                NpChar.gNPC[n].code_flag = eve.code_flag;
                NpChar.gNPC[n].x = eve.x * 16 * 512;
                NpChar.gNPC[n].y = eve.y * 16 * 512;
                NpChar.gNPC[n].bits = eve.bits;
                NpChar.gNPC[n].bits = (char)(NpChar.gNPC[n].bits | NpcTbl.gNpcTable[NpChar.gNPC[n].code_char].bits);
                NpChar.gNPC[n].exp = NpcTbl.gNpcTable[NpChar.gNPC[n].code_char].exp;
                NpChar.SetUniqueParameter(gNPC[n]);
                if ((NpChar.gNPC[n].bits & 0x800) != 0) {
                    if (Flags.GetNPCFlag(NpChar.gNPC[n].code_flag)) {
                        NpChar.gNPC[n].cond = (byte)(NpChar.gNPC[n].cond | 0x80);
                    }
                } else if ((NpChar.gNPC[n].bits & 0x4000) != 0) {
                    if (!Flags.GetNPCFlag(NpChar.gNPC[n].code_flag)) {
                        NpChar.gNPC[n].cond = (byte)(NpChar.gNPC[n].cond | 0x80);
                    }
                } else {
                    NpChar.gNPC[n].cond = (byte)-128;
                }
                ++n;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static void SetNpChar(int code_char, int x, int y, int xm, int ym, int dir, NPCHAR npc, int start_index) {
        int n;
        for (n = start_index; n < gNPC.length && NpChar.gNPC[n].cond != 0; ++n) {
        }
        if (n == gNPC.length) {
            return;
        }
        gNPC[n].clear();
        NpChar.gNPC[n].cond = (byte)(NpChar.gNPC[n].cond | 0x80);
        NpChar.gNPC[n].direct = dir;
        NpChar.gNPC[n].code_char = code_char;
        NpChar.gNPC[n].x = x;
        NpChar.gNPC[n].y = y;
        NpChar.gNPC[n].xm = xm;
        NpChar.gNPC[n].ym = ym;
        NpChar.gNPC[n].pNpc = npc;
        NpChar.gNPC[n].bits = NpcTbl.gNpcTable[NpChar.gNPC[n].code_char].bits;
        NpChar.gNPC[n].exp = NpcTbl.gNpcTable[NpChar.gNPC[n].code_char].exp;
        NpChar.SetUniqueParameter(gNPC[n]);
    }

    public static void SetDestroyNpChar(int x, int y, int w, int num) {
        w /= 512;
        for (int i = 0; i < num; ++i) {
            int offset_x = Game.Random(-w, w) * 512;
            int offset_y = Game.Random(-w, w) * 512;
            NpChar.SetNpChar(4, x + offset_x, y + offset_y, 0, 0, 0, null, 256);
        }
        Caret.SetCaret(x, y, 12, 0);
    }

    public static void SetDestroyNpCharUp(int x, int y, int w, int num) {
        w /= 512;
        for (int i = 0; i < num; ++i) {
            int offset_x = Game.Random(-w, w) * 512;
            int offset_y = Game.Random(-w, w) * 512;
            NpChar.SetNpChar(4, x + offset_x, y + offset_y, 0, 0, 1, null, 256);
        }
        Caret.SetCaret(x, y, 12, 0);
    }

    public static void SetExpObjects(int x, int y, int exp) {
        int sub_exp = 0;
        int n = 256;
        while (exp != 0) {
            while (n < gNPC.length && NpChar.gNPC[n].cond != 0) {
                ++n;
            }
            if (n == gNPC.length) break;
            gNPC[n].clear();
            if (exp >= 20) {
                exp -= 20;
                sub_exp = 20;
            } else if (exp >= 5) {
                exp -= 5;
                sub_exp = 5;
            } else if (exp >= 1) {
                --exp;
                sub_exp = 1;
            }
            NpChar.gNPC[n].cond = (byte)(NpChar.gNPC[n].cond | 0x80);
            NpChar.gNPC[n].direct = 0;
            NpChar.gNPC[n].code_char = 1;
            NpChar.gNPC[n].x = x;
            NpChar.gNPC[n].y = y;
            NpChar.gNPC[n].bits = NpcTbl.gNpcTable[NpChar.gNPC[n].code_char].bits;
            NpChar.gNPC[n].exp = sub_exp;
            NpChar.SetUniqueParameter(gNPC[n]);
        }
    }

    public static boolean SetBulletObject(int x, int y, int val) {
        int n;
        int[] tamakazu_ari = new int[10];
        int t = 0;
        block4: for (n = 0; n < 8; ++n) {
            switch (ArmsItem.gArmsData[n].code) {
                case 5: {
                    tamakazu_ari[t++] = 0;
                    continue block4;
                }
                case 10: {
                    tamakazu_ari[t++] = 1;
                    continue block4;
                }
                default: {
                    tamakazu_ari[t] = 0;
                }
            }
        }
        if (t == 0) {
            return false;
        }
        n = Game.Random(1, 10 * t);
        int bullet_no = tamakazu_ari[n % t];
        for (n = 256; n < gNPC.length && NpChar.gNPC[n].cond != 0; ++n) {
        }
        if (n == gNPC.length) {
            return false;
        }
        gNPC[n].clear();
        NpChar.gNPC[n].cond = (byte)(NpChar.gNPC[n].cond | 0x80);
        NpChar.gNPC[n].direct = 0;
        NpChar.gNPC[n].code_event = bullet_no;
        NpChar.gNPC[n].code_char = 86;
        NpChar.gNPC[n].x = x;
        NpChar.gNPC[n].y = y;
        NpChar.gNPC[n].bits = NpcTbl.gNpcTable[NpChar.gNPC[n].code_char].bits;
        NpChar.gNPC[n].exp = val;
        NpChar.SetUniqueParameter(gNPC[n]);
        return true;
    }

    public static boolean SetLifeObject(int x, int y, int val) {
        int n;
        for (n = 256; n < gNPC.length && NpChar.gNPC[n].cond != 0; ++n) {
        }
        if (n == gNPC.length) {
            return false;
        }
        gNPC[n].clear();
        NpChar.gNPC[n].cond = (byte)(NpChar.gNPC[n].cond | 0x80);
        NpChar.gNPC[n].direct = 0;
        NpChar.gNPC[n].code_char = 87;
        NpChar.gNPC[n].x = x;
        NpChar.gNPC[n].y = y;
        NpChar.gNPC[n].bits = NpcTbl.gNpcTable[NpChar.gNPC[n].code_char].bits;
        NpChar.gNPC[n].exp = val;
        NpChar.SetUniqueParameter(gNPC[n]);
        return true;
    }

    public static void VanishNpChar(NPCHAR npc) {
        int x = npc.x;
        int y = npc.y;
        npc.clear();
        npc.count1 = 0;
        npc.x = x;
        npc.y = y;
        npc.cond = (byte)(npc.cond | 0x80);
        npc.direct = 0;
        npc.code_char = 3;
        npc.bits = NpcTbl.gNpcTable[npc.code_char].bits;
        npc.exp = NpcTbl.gNpcTable[npc.code_char].exp;
        NpChar.SetUniqueParameter(npc);
    }

    public static void PutNpChar(int fx, int fy) {
        byte a = 0;
        for (int n = 0; n < gNPC.length; ++n) {
            if ((NpChar.gNPC[n].cond & 0x80) == 0) continue;
            if (NpChar.gNPC[n].shock != '\u0000') {
                a = (byte)(2 * (NpChar.gNPC[n].shock / 2 % 2) - 1);
            } else {
                a = 0;
                if ((NpChar.gNPC[n].bits & 0x8000) != 0 && NpChar.gNPC[n].damage_view != 0) {
                    int nn = n;
                    ValueView.SetValueView(() -> NpChar.gNPC[nn].x, () -> NpChar.gNPC[nn].y, NpChar.gNPC[n].damage_view, gNPC[nn].hashCode());
                    NpChar.gNPC[n].damage_view = 0;
                }
            }
            int side = NpChar.gNPC[n].direct == 0 ? NpChar.gNPC[n].view.front : NpChar.gNPC[n].view.back;
            Draw.PutBitmap3(Draw.grcGame, (NpChar.gNPC[n].x - side) / 512 - fx / 512 + a, (NpChar.gNPC[n].y - NpChar.gNPC[n].view.top) / 512 - fy / 512, NpChar.gNPC[n].rect, NpChar.gNPC[n].surf);
        }
    }

    public static void ActNpChar() {
        for (int i = 0; i < gNPC.length; ++i) {
            if ((NpChar.gNPC[i].cond & 0x80) == 0) continue;
            int code_char = NpChar.gNPC[i].code_char;
            if (NpcTbl.gpNpcFuncTbl.length > code_char) {
                NpcTbl.gpNpcFuncTbl[code_char].proc(gNPC[i]);
            }
            if (NpChar.gNPC[i].shock == '\u0000') continue;
            NpChar.gNPC[i].shock = (char)(NpChar.gNPC[i].shock - '\u0001');
        }
    }

    public static void ChangeNpCharByEvent(int code_event, int code_char, int dir) {
        for (int n = 0; n < gNPC.length; ++n) {
            if ((NpChar.gNPC[n].cond & 0x80) == 0 || NpChar.gNPC[n].code_event != code_event) continue;
            NpChar.gNPC[n].bits = (char)(NpChar.gNPC[n].bits & 0xFFFF7F00);
            NpChar.gNPC[n].code_char = code_char;
            NpChar.gNPC[n].bits = (char)(NpChar.gNPC[n].bits | NpcTbl.gNpcTable[NpChar.gNPC[n].code_char].bits);
            NpChar.gNPC[n].exp = NpcTbl.gNpcTable[NpChar.gNPC[n].code_char].exp;
            NpChar.SetUniqueParameter(gNPC[n]);
            NpChar.gNPC[n].cond = (byte)(NpChar.gNPC[n].cond | 0x80);
            NpChar.gNPC[n].act_no = 0;
            NpChar.gNPC[n].act_wait = 0;
            NpChar.gNPC[n].count1 = 0;
            NpChar.gNPC[n].count2 = 0;
            NpChar.gNPC[n].ani_no = 0;
            NpChar.gNPC[n].ani_wait = 0;
            NpChar.gNPC[n].xm = 0;
            NpChar.gNPC[n].ym = 0;
            if (dir != 5) {
                NpChar.gNPC[n].direct = dir == 4 ? (NpChar.gNPC[n].x < MyChar.gMC.x ? 2 : 0) : dir;
            }
            if (NpcTbl.gpNpcFuncTbl.length <= code_char) continue;
            NpcTbl.gpNpcFuncTbl[code_char].proc(gNPC[n]);
        }
    }

    public static void ChangeCheckableNpCharByEvent(int code_event, int code_char, int dir) {
        for (int n = 0; n < gNPC.length; ++n) {
            if ((NpChar.gNPC[n].cond & 0x80) != 0 || NpChar.gNPC[n].code_event != code_event) continue;
            NpChar.gNPC[n].bits = (char)(NpChar.gNPC[n].bits & 0xFFFF7F00);
            NpChar.gNPC[n].bits = (char)(NpChar.gNPC[n].bits | 0x2000);
            NpChar.gNPC[n].code_char = code_char;
            NpChar.gNPC[n].bits = (char)(NpChar.gNPC[n].bits | NpcTbl.gNpcTable[NpChar.gNPC[n].code_char].bits);
            NpChar.gNPC[n].exp = NpcTbl.gNpcTable[NpChar.gNPC[n].code_char].exp;
            NpChar.SetUniqueParameter(gNPC[n]);
            NpChar.gNPC[n].cond = (byte)(NpChar.gNPC[n].cond | 0x80);
            NpChar.gNPC[n].act_no = 0;
            NpChar.gNPC[n].act_wait = 0;
            NpChar.gNPC[n].count1 = 0;
            NpChar.gNPC[n].count2 = 0;
            NpChar.gNPC[n].ani_no = 0;
            NpChar.gNPC[n].ani_wait = 0;
            NpChar.gNPC[n].xm = 0;
            NpChar.gNPC[n].ym = 0;
            if (dir != 5) {
                NpChar.gNPC[n].direct = dir == 4 ? (NpChar.gNPC[n].x < MyChar.gMC.x ? 2 : 0) : (int)((byte)dir);
            }
            if (NpcTbl.gpNpcFuncTbl.length <= code_char) continue;
            NpcTbl.gpNpcFuncTbl[code_char].proc(gNPC[n]);
        }
    }

    public static void SetNpCharActionNo(int code_event, int act_no, int dir) {
        int n;
        for (n = 0; n < gNPC.length && ((NpChar.gNPC[n].cond & 0x80) == 0 || NpChar.gNPC[n].code_event != code_event); ++n) {
        }
        if (n == gNPC.length) {
            return;
        }
        NpChar.gNPC[n].act_no = act_no;
        if (dir != 5) {
            NpChar.gNPC[n].direct = dir == 4 ? (NpChar.gNPC[n].x < MyChar.gMC.x ? 2 : 0) : dir;
        }
    }

    public static void MoveNpChar(int code_event, int x, int y, int dir) {
        int n;
        for (n = 0; n < gNPC.length && ((NpChar.gNPC[n].cond & 0x80) == 0 || NpChar.gNPC[n].code_event != code_event); ++n) {
        }
        if (n == gNPC.length) {
            return;
        }
        NpChar.gNPC[n].x = x;
        NpChar.gNPC[n].y = y;
        if (dir != 5) {
            NpChar.gNPC[n].direct = dir == 4 ? (NpChar.gNPC[n].x < MyChar.gMC.x ? 2 : 0) : (int)((byte)dir);
        }
    }

    public static void BackStepMyChar(int code_event) {
        MyChar.gMC.cond = (char)(MyChar.gMC.cond & 0xFFFFFFFE);
        MyChar.gMC.ym = -512;
        if (code_event == 0) {
            MyChar.gMC.direct = 0;
            MyChar.gMC.xm = 512;
        } else if (code_event == 2) {
            MyChar.gMC.direct = 2;
            MyChar.gMC.xm = -512;
        } else {
            int n;
            for (n = 0; n < gNPC.length && ((NpChar.gNPC[n].cond & 0x80) == 0 || NpChar.gNPC[n].code_event != code_event); ++n) {
            }
            if (n == gNPC.length) {
                return;
            }
            if (NpChar.gNPC[n].x < MyChar.gMC.x) {
                MyChar.gMC.direct = 0;
                MyChar.gMC.xm = 512;
            } else {
                MyChar.gMC.direct = 2;
                MyChar.gMC.xm = -512;
            }
        }
    }

    public static void DeleteNpCharEvent(int code) {
        for (int i = 0; i < gNPC.length; ++i) {
            if ((NpChar.gNPC[i].cond & 0x80) == 0 || NpChar.gNPC[i].code_event != code) continue;
            NpChar.gNPC[i].cond = 0;
            Flags.SetNPCFlag(NpChar.gNPC[i].code_flag);
        }
    }

    public static void DeleteNpCharCode(int code, boolean bSmoke) {
        block5: for (int n = 0; n < gNPC.length; ++n) {
            if ((NpChar.gNPC[n].cond & 0x80) == 0 || NpChar.gNPC[n].code_char != code) continue;
            NpChar.gNPC[n].cond = 0;
            Flags.SetNPCFlag(NpChar.gNPC[n].code_flag);
            if (!bSmoke) continue;
            Sound.PlaySoundObject(NpChar.gNPC[n].destroy_voice, 1);
            switch (NpChar.gNPC[n].size) {
                case 1: {
                    NpChar.SetDestroyNpChar(NpChar.gNPC[n].x, NpChar.gNPC[n].y, NpChar.gNPC[n].view.back, 4);
                    continue block5;
                }
                case 2: {
                    NpChar.SetDestroyNpChar(NpChar.gNPC[n].x, NpChar.gNPC[n].y, NpChar.gNPC[n].view.back, 8);
                    continue block5;
                }
                case 3: {
                    NpChar.SetDestroyNpChar(NpChar.gNPC[n].x, NpChar.gNPC[n].y, NpChar.gNPC[n].view.back, 16);
                }
            }
        }
    }

    public static boolean IsNpCharCode(int code) {
        for (int i = 0; i < gNPC.length; ++i) {
            if ((NpChar.gNPC[i].cond & 0x80) == 0 || NpChar.gNPC[i].code_char != code) continue;
            return true;
        }
        return false;
    }

    public static boolean GetNpCharAlive(int code_event) {
        int i;
        for (i = 0; i < gNPC.length && ((NpChar.gNPC[i].cond & 0x80) == 0 || NpChar.gNPC[i].code_event != code_event); ++i) {
        }
        return i < gNPC.length;
    }

    public static int CountAliveNpChar() {
        int count = 0;
        for (int n = 0; n < gNPC.length; ++n) {
            if ((NpChar.gNPC[n].cond & 0x80) == 0) continue;
            ++count;
        }
        return count;
    }

    static {
        for (int i = 0; i < gNPC.length; ++i) {
            NpChar.gNPC[i] = new NPCHAR();
        }
        gPassPixEve = new byte[]{80, 88, 69, 0};
    }

    public static class NPCHAR {
        byte cond;
        int flag;
        int x;
        int y;
        int xm;
        int ym;
        int xm2;
        int ym2;
        int tgt_x;
        int tgt_y;
        int code_char;
        int code_flag;
        int code_event;
        int surf;
        int hit_voice;
        int destroy_voice;
        int life;
        int exp;
        int size;
        int direct;
        char bits;
        final RECT rect = new RECT();
        int ani_wait;
        int ani_no;
        int count1;
        int count2;
        int act_no;
        int act_wait;
        final OTHER_RECT hit = new OTHER_RECT();
        final OTHER_RECT view = new OTHER_RECT();
        char shock;
        int damage_view;
        int damage;
        NPCHAR pNpc = null;

        public NPCHAR() {
            this.clear();
        }

        public void clear() {
            this.cond = 0;
            this.flag = 0;
            this.x = 0;
            this.y = 0;
            this.xm = 0;
            this.ym = 0;
            this.xm2 = 0;
            this.ym2 = 0;
            this.tgt_x = 0;
            this.tgt_y = 0;
            this.code_char = 0;
            this.code_flag = 0;
            this.code_event = 0;
            this.surf = 0;
            this.hit_voice = 0;
            this.destroy_voice = 0;
            this.life = 0;
            this.exp = 0;
            this.size = 0;
            this.direct = 0;
            this.bits = '\u0000';
            this.rect.clear();
            this.ani_wait = 0;
            this.ani_no = 0;
            this.count1 = 0;
            this.count2 = 0;
            this.act_no = 0;
            this.act_wait = 0;
            this.hit.clear();
            this.view.clear();
            this.shock = '\u0000';
            this.damage_view = 0;
            this.damage = 0;
            this.pNpc = null;
        }

        public void copyFrom(NPCHAR other) {
            this.cond = other.cond;
            this.flag = other.flag;
            this.x = other.x;
            this.y = other.y;
            this.xm = other.xm;
            this.ym = other.ym;
            this.xm2 = other.xm2;
            this.ym2 = other.ym2;
            this.tgt_x = other.tgt_x;
            this.tgt_y = other.tgt_y;
            this.code_char = other.code_char;
            this.code_flag = other.code_flag;
            this.code_event = other.code_event;
            this.surf = other.surf;
            this.hit_voice = other.hit_voice;
            this.destroy_voice = other.destroy_voice;
            this.life = other.life;
            this.exp = other.exp;
            this.size = other.size;
            this.direct = other.direct;
            this.bits = other.bits;
            this.rect.copyFrom(other.rect);
            this.ani_wait = other.ani_wait;
            this.ani_no = other.ani_no;
            this.count1 = other.count1;
            this.count2 = other.count2;
            this.act_no = other.act_no;
            this.act_wait = other.act_wait;
            this.hit.copyFrom(other.hit);
            this.view.copyFrom(other.view);
            this.shock = other.shock;
            this.damage_view = other.damage_view;
            this.damage = other.damage;
            this.pNpc = other.pNpc;
        }
    }

    public static class OTHER_RECT {
        public int front;
        public int top;
        public int back;
        public int bottom;

        public OTHER_RECT() {
            this.clear();
        }

        public void clear() {
            this.front = 0;
            this.top = 0;
            this.back = 0;
            this.bottom = 0;
        }

        public void copyFrom(OTHER_RECT rect) {
            this.front = rect.front;
            this.top = rect.top;
            this.back = rect.back;
            this.bottom = rect.bottom;
        }
    }

    public static class EVENT {
        short x;
        short y;
        short code_flag;
        short code_event;
        short code_char;
        char bits;
    }
}
