/*
 * Decompiled with CFR 0.152.
 */
package jp.studiopixel.doukutsu;

import jp.studiopixel.doukutsu.Caret;
import jp.studiopixel.doukutsu.Frame;
import jp.studiopixel.doukutsu.Game;
import jp.studiopixel.doukutsu.Map;
import jp.studiopixel.doukutsu.MyChar;
import jp.studiopixel.doukutsu.NpChar;
import jp.studiopixel.doukutsu.RECT;
import jp.studiopixel.doukutsu.Sound;
import jp.studiopixel.doukutsu.Triangle;

public class NpcAct240 {
    private static final RECT[] ActNpc240_rcLeft = new RECT[]{new RECT(160, 64, 176, 80), new RECT(176, 64, 192, 80), new RECT(192, 64, 208, 80), new RECT(160, 64, 176, 80), new RECT(208, 64, 224, 80), new RECT(160, 64, 176, 80)};
    private static final RECT[] ActNpc240_rcRight = new RECT[]{new RECT(160, 80, 176, 96), new RECT(176, 80, 192, 96), new RECT(192, 80, 208, 96), new RECT(160, 80, 176, 96), new RECT(208, 80, 224, 96), new RECT(160, 80, 176, 96)};
    private static final RECT[] ActNpc241_rcLeft = new RECT[]{new RECT(0, 0, 16, 16), new RECT(16, 0, 32, 16), new RECT(32, 0, 48, 16)};
    private static final RECT[] ActNpc241_rcRight = new RECT[]{new RECT(0, 16, 16, 32), new RECT(16, 16, 32, 32), new RECT(32, 16, 48, 32)};
    private static final RECT[] ActNpc242_rect_left = new RECT[]{new RECT(32, 32, 48, 48), new RECT(48, 32, 64, 48), new RECT(64, 32, 80, 48), new RECT(80, 32, 96, 48)};
    private static final RECT[] ActNpc242_rect_right = new RECT[]{new RECT(32, 48, 48, 64), new RECT(48, 48, 64, 64), new RECT(64, 48, 80, 64), new RECT(80, 48, 96, 64)};
    private static final RECT ActNpc244_rc = new RECT(96, 0, 104, 16);
    private static final RECT[] ActNpc245_rc = new RECT[]{new RECT(0, 0, 0, 0), new RECT(104, 0, 112, 16), new RECT(112, 0, 120, 16), new RECT(120, 0, 128, 16)};
    private static final RECT[] ActNpc246_rcLeft = new RECT[]{new RECT(144, 112, 160, 136), new RECT(160, 112, 176, 136), new RECT(176, 112, 192, 136)};
    private static final RECT[] ActNpc247_rcLeft = new RECT[]{new RECT(0, 0, 16, 16), new RECT(16, 0, 32, 16), new RECT(32, 0, 48, 16), new RECT(48, 0, 64, 16), new RECT(64, 0, 80, 16), new RECT(80, 0, 96, 16), new RECT(96, 0, 112, 16), new RECT(0, 0, 0, 0), new RECT(112, 0, 128, 16)};
    private static final RECT[] ActNpc247_rcRight = new RECT[]{new RECT(0, 16, 16, 32), new RECT(16, 16, 32, 32), new RECT(32, 16, 48, 32), new RECT(48, 16, 64, 32), new RECT(64, 16, 80, 32), new RECT(80, 16, 96, 32), new RECT(96, 16, 112, 32), new RECT(0, 0, 0, 0), new RECT(112, 16, 128, 32)};
    private static final RECT[] ActNpc248_rect_left = new RECT[]{new RECT(0, 48, 16, 64), new RECT(16, 48, 32, 64), new RECT(32, 48, 48, 64)};
    private static final RECT[] ActNpc249_rc = new RECT[]{new RECT(48, 48, 64, 64), new RECT(64, 48, 80, 64)};
    private static final RECT[] ActNpc250_rc = new RECT[]{new RECT(0, 32, 16, 48), new RECT(16, 32, 32, 48), new RECT(32, 32, 48, 48)};
    private static final RECT[] ActNpc251_rc = new RECT[]{new RECT(80, 32, 96, 64), new RECT(96, 32, 112, 64)};
    private static final RECT[] ActNpc252_rcLeft = new RECT[]{new RECT(48, 32, 64, 48), new RECT(112, 32, 128, 48), new RECT(128, 32, 144, 48), new RECT(144, 32, 160, 48)};
    private static final RECT[] ActNpc252_rcRight = new RECT[]{new RECT(48, 32, 64, 48), new RECT(112, 48, 128, 64), new RECT(128, 48, 144, 64), new RECT(144, 48, 160, 64)};
    private static final RECT[] ActNpc253_rc = new RECT[]{new RECT(0, 64, 16, 80), new RECT(16, 64, 32, 80)};
    private static final RECT[] ActNpc254_rc = new RECT[]{new RECT(0, 0, 128, 64), new RECT(0, 64, 128, 128)};
    private static final RECT[] ActNpc255_rcLeft = new RECT[]{new RECT(128, 0, 240, 16), new RECT(128, 16, 240, 32), new RECT(128, 32, 240, 48), new RECT(128, 16, 240, 32)};
    private static final RECT[] ActNpc255_rcRight = new RECT[]{new RECT(240, 0, 320, 16), new RECT(240, 16, 320, 32), new RECT(240, 32, 320, 48), new RECT(240, 16, 320, 32)};
    private static final RECT[] ActNpc256_rcLeft = new RECT[]{new RECT(48, 160, 72, 192), new RECT(72, 160, 96, 192), new RECT(0, 128, 24, 160), new RECT(24, 128, 48, 160), new RECT(0, 160, 24, 192), new RECT(24, 160, 48, 192)};
    private static final RECT[] ActNpc257_rc = new RECT[]{new RECT(176, 32, 184, 48), new RECT(184, 32, 192, 48), new RECT(0, 0, 0, 0)};
    private static final RECT ActNpc258_rc = new RECT(48, 32, 64, 48);
    private static final RECT ActNpc259_rcLeft = new RECT(224, 96, 240, 112);
    private static final RECT ActNpc259_rcRight = new RECT(224, 112, 240, 128);

    public static void ActNpc240(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
                npc.ani_no = 0;
                npc.ani_wait = 0;
                npc.xm = 0;
            }
            case 1: {
                if (Game.Random(0, 60) == 1) {
                    npc.act_no = 2;
                    npc.act_wait = 0;
                    npc.ani_no = 1;
                }
                if (Game.Random(0, 60) != 1) break;
                npc.act_no = 10;
                npc.act_wait = 0;
                npc.ani_no = 1;
                break;
            }
            case 2: {
                if (++npc.act_wait <= 8) break;
                npc.act_no = 1;
                npc.ani_no = 0;
                break;
            }
            case 10: {
                npc.act_no = 11;
                npc.act_wait = Game.Random(0, 16);
                npc.ani_no = 2;
                npc.ani_wait = 0;
                npc.direct = Game.Random(0, 9) % 2 != 0 ? 0 : 2;
            }
            case 11: {
                if (npc.direct == 0 && (npc.flag & 1) != 0) {
                    npc.direct = 2;
                } else if (npc.direct == 2 && (npc.flag & 4) != 0) {
                    npc.direct = 0;
                }
                npc.xm = npc.direct == 0 ? -512 : 512;
                if (++npc.ani_wait > 4) {
                    npc.ani_wait = 0;
                    ++npc.ani_no;
                }
                if (npc.ani_no > 5) {
                    npc.ani_no = 2;
                }
                if (++npc.act_wait <= 32) break;
                npc.act_no = 0;
            }
        }
        npc.ym += 32;
        if (npc.ym > 1535) {
            npc.ym = 1535;
        }
        npc.x += npc.xm;
        npc.y += npc.ym;
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc240_rcLeft[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc240_rcRight[npc.ani_no]);
        }
    }

    public static void ActNpc241(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.y += 1536;
                npc.act_no = 1;
            }
            case 1: {
                npc.direct = npc.x > MyChar.gMC.x ? 0 : 2;
                if (npc.act_wait >= 8 && npc.x - 73728 < MyChar.gMC.x && npc.x + 73728 > MyChar.gMC.x && npc.y - 40960 < MyChar.gMC.y && npc.y + 40960 > MyChar.gMC.y) {
                    npc.ani_no = 1;
                } else {
                    if (npc.act_wait < 8) {
                        ++npc.act_wait;
                    }
                    npc.ani_no = 0;
                }
                if (npc.shock != '\u0000') {
                    npc.act_no = 2;
                    npc.ani_no = 0;
                    npc.act_wait = 0;
                }
                if (npc.act_wait < 8 || npc.x - 49152 >= MyChar.gMC.x || npc.x + 49152 <= MyChar.gMC.x || npc.y - 40960 >= MyChar.gMC.y || npc.y + 49152 <= MyChar.gMC.y) break;
                npc.act_no = 2;
                npc.ani_no = 0;
                npc.act_wait = 0;
                break;
            }
            case 2: {
                if (++npc.act_wait <= 8) break;
                npc.act_no = 3;
                npc.ani_no = 2;
                npc.ym = -1535;
                Sound.PlaySoundObject(30, 1);
                if (npc.direct == 0) {
                    npc.xm = -512;
                    break;
                }
                npc.xm = 512;
                break;
            }
            case 3: {
                if ((npc.flag & 8) == 0) break;
                npc.xm = 0;
                npc.act_wait = 0;
                npc.ani_no = 0;
                npc.act_no = 1;
                Sound.PlaySoundObject(23, 1);
            }
        }
        npc.ym += 85;
        if (npc.ym > 1535) {
            npc.ym = 1535;
        }
        npc.x += npc.xm;
        npc.y += npc.ym;
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc241_rcLeft[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc241_rcRight[npc.ani_no]);
        }
    }

    public static void ActNpc242(NpChar.NPCHAR npc) {
        if (npc.x < 0 || npc.x > Map.gMap.width * 16 * 512) {
            NpChar.VanishNpChar(npc);
            return;
        }
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
                npc.tgt_x = npc.x;
                npc.tgt_y = npc.y;
                npc.act_wait = Game.Random(0, 50);
            }
            case 1: {
                if (npc.act_wait != 0) {
                    --npc.act_wait;
                    break;
                }
                npc.act_no = 2;
                npc.ym = 1024;
            }
            case 2: {
                npc.xm = npc.direct == 0 ? -256 : 256;
                if (npc.tgt_y < npc.y) {
                    npc.ym -= 16;
                }
                if (npc.tgt_y > npc.y) {
                    npc.ym += 16;
                }
                if (npc.ym > 768) {
                    npc.ym = 768;
                }
                if (npc.ym >= -768) break;
                npc.ym = -768;
            }
        }
        npc.x += npc.xm;
        npc.y += npc.ym;
        if (++npc.ani_wait > 1) {
            npc.ani_wait = 0;
            ++npc.ani_no;
        }
        if (npc.ani_no > 2) {
            npc.ani_no = 0;
        }
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc242_rect_left[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc242_rect_right[npc.ani_no]);
        }
    }

    public static void ActNpc243(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
                npc.act_wait = Game.Random(0, 500);
            }
            case 1: {
                if (npc.act_wait != 0) {
                    --npc.act_wait;
                    break;
                }
                npc.act_no = 0;
                NpChar.SetNpChar(242, npc.x, npc.y + Game.Random(-32, 32) * 512, 0, 0, npc.direct, null, 256);
            }
        }
    }

    public static void ActNpc244(NpChar.NPCHAR npc) {
        npc.ym += 64;
        boolean bHit = false;
        if ((npc.flag & 0xFF) != 0) {
            bHit = true;
        }
        if (npc.act_wait > 10 && (npc.flag & 0x100) != 0) {
            bHit = true;
        }
        if (bHit) {
            for (int i = 0; i < 3; ++i) {
                Caret.SetCaret(npc.x, npc.y + 2048, 1, 2);
            }
            if (npc.x > MyChar.gMC.x - 131072 && npc.x < MyChar.gMC.x + 131072 && npc.y > MyChar.gMC.y - 81920 && npc.y < MyChar.gMC.y + 81920) {
                Sound.PlaySoundObject(21, 1);
            }
            npc.cond = 0;
        } else {
            if (npc.ym > 1535) {
                npc.ym = 1535;
            }
            npc.y += npc.ym;
            npc.rect.copyFrom(ActNpc244_rc);
        }
    }

    public static void ActNpc245(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
                npc.tgt_x = npc.x;
                npc.act_wait = npc.code_event;
            }
            case 1: {
                npc.ani_no = 0;
                if (npc.act_wait != 0) {
                    --npc.act_wait;
                    return;
                }
                npc.act_no = 10;
                npc.ani_wait = 0;
                break;
            }
            case 10: {
                if (++npc.ani_wait > 10) {
                    npc.ani_wait = 0;
                    ++npc.ani_no;
                }
                if (npc.ani_no <= 3) break;
                npc.ani_no = 0;
                npc.act_no = 1;
                npc.act_wait = npc.code_flag;
                NpChar.SetNpChar(244, npc.x, npc.y, 0, 0, 0, null, 256);
            }
        }
        npc.x = npc.ani_wait / 2 % 2 != 0 ? npc.tgt_x : npc.tgt_x + 512;
        npc.rect.copyFrom(ActNpc245_rc[npc.ani_no]);
    }

    public static void ActNpc246(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
                npc.y -= 2048;
            }
            case 1: {
                if (MyChar.gMC.x >= npc.x + 4096 || MyChar.gMC.x <= npc.x - 4096 || MyChar.gMC.y <= npc.y + 4096 || MyChar.gMC.y >= npc.y + 65536) break;
                npc.act_no = 5;
                break;
            }
            case 5: {
                if ((npc.flag & 8) != 0) break;
                npc.act_no = 10;
                npc.ani_wait = 0;
                npc.ani_no = 1;
                break;
            }
            case 10: {
                if (++npc.ani_wait > 2) {
                    npc.ani_wait = 0;
                    ++npc.ani_no;
                }
                if (npc.ani_no > 2) {
                    npc.ani_no = 2;
                }
                if (MyChar.gMC.y > npc.y) {
                    npc.bits = (char)(npc.bits & 0xFFFFFFBF);
                    npc.damage = 127;
                } else {
                    npc.bits = (char)(npc.bits | 0x40);
                    npc.damage = 0;
                }
                if ((npc.flag & 8) == 0) break;
                if (npc.ani_no > 1) {
                    for (int i = 0; i < 4; ++i) {
                        NpChar.SetNpChar(4, npc.x, npc.y, Game.Random(-341, 341), Game.Random(-1536, 0), 0, null, 256);
                    }
                    Sound.PlaySoundObject(26, 1);
                    Frame.SetQuake(10);
                }
                npc.act_no = 20;
                npc.ani_no = 0;
                npc.ani_wait = 0;
                npc.bits = (char)(npc.bits | 0x40);
                npc.damage = 0;
            }
        }
        if (npc.act_no >= 5) {
            npc.ym += 128;
            if (npc.ym > 1535) {
                npc.ym = 1535;
            }
            npc.y += npc.ym;
        }
        npc.rect.copyFrom(ActNpc246_rcLeft[npc.ani_no]);
    }

    public static void ActNpc247(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
                npc.y += 3072;
                npc.tgt_y = 32768;
            }
            case 1: {
                if (Game.Random(0, 120) != 10) break;
                npc.act_no = 2;
                npc.act_wait = 0;
                npc.ani_no = 1;
                break;
            }
            case 2: {
                if (++npc.act_wait <= 8) break;
                npc.act_no = 1;
                npc.ani_no = 0;
                break;
            }
            case 20: {
                npc.xm = 0;
                npc.ym += 64;
                if ((npc.flag & 8) == 0) break;
                npc.act_no = 21;
                npc.ani_no = 2;
                break;
            }
            case 21: {
                if (Game.Random(0, 120) != 10) break;
                npc.act_no = 22;
                npc.act_wait = 0;
                npc.ani_no = 3;
                break;
            }
            case 22: {
                if (++npc.act_wait <= 8) break;
                npc.act_no = 21;
                npc.ani_no = 2;
                break;
            }
            case 100: {
                npc.act_no = 101;
                npc.act_wait = 0;
                npc.ani_no = 0;
                npc.xm = 0;
                npc.bits = (char)(npc.bits | 0x20);
                npc.count2 = npc.life;
            }
            case 101: {
                npc.direct = MyChar.gMC.x < npc.x ? 0 : 2;
                npc.ym = npc.y < npc.tgt_y ? (npc.ym += 32) : (npc.ym -= 32);
                if (npc.ym < -512) {
                    npc.ym = -512;
                }
                if (npc.ym > 512) {
                    npc.ym = 512;
                }
                if (++npc.act_wait <= 200 && npc.life > npc.count2 - 80) break;
                npc.act_wait = 0;
                npc.act_no = 110;
                break;
            }
            case 110: {
                npc.act_no = 111;
                npc.act_wait = 0;
                npc.xm = 0;
                npc.ym = 0;
                npc.bits = (char)(npc.bits & 0xFFFFFFDF);
            }
            case 111: {
                npc.ani_no = ++npc.act_wait % 2 != 0 ? 5 : 6;
                if (npc.act_wait <= 30) break;
                npc.act_wait = 0;
                npc.act_no = ++npc.count1 % 3 == 0 ? 113 : 112;
                npc.ani_no = 4;
                break;
            }
            case 112: {
                if (++npc.act_wait % 6 == 0) {
                    char deg = (char)Triangle.GetArktan(npc.x - MyChar.gMC.x, npc.y - MyChar.gMC.y);
                    deg = (char)(deg + (char)Game.Random(-4, 4) & 0xFF);
                    int ym = Triangle.GetSin(deg) * 4;
                    int xm = Triangle.GetCos(deg) * 4;
                    NpChar.SetNpChar(248, npc.x, npc.y + 2048, xm, ym, 0, null, 256);
                    Sound.PlaySoundObject(34, 1);
                }
                if (npc.act_wait <= 30) break;
                npc.act_wait = 0;
                npc.act_no = 150;
                break;
            }
            case 113: {
                if (++npc.act_wait == 10) {
                    int ym = MyChar.gMC.y - 32768;
                    NpChar.SetNpChar(279, MyChar.gMC.x, ym, 0, 0, 1, null, 256);
                }
                if (npc.act_wait <= 30) break;
                npc.act_wait = 0;
                npc.act_no = 150;
                break;
            }
            case 150: {
                npc.act_no = 151;
                npc.act_wait = 0;
                npc.ani_no = 7;
                NpChar.SetNpChar(249, npc.x, npc.y, 0, 0, 0, null, 256);
                NpChar.SetNpChar(249, npc.x, npc.y, 0, 0, 2, null, 256);
                npc.tgt_x = Game.Random(9, 31) * 512 * 16;
                npc.tgt_y = Game.Random(5, 7) * 512 * 16;
                Sound.PlaySoundObject(29, 1);
            }
            case 151: {
                if (++npc.act_wait == 42) {
                    NpChar.SetNpChar(249, npc.tgt_x + 8192, npc.tgt_y, 0, 0, 0, null, 256);
                    NpChar.SetNpChar(249, npc.tgt_x - 8192, npc.tgt_y, 0, 0, 2, null, 256);
                }
                if (npc.act_wait <= 50) break;
                npc.act_wait = 0;
                npc.ym = -512;
                npc.bits = (char)(npc.bits | 0x20);
                npc.x = npc.tgt_x;
                npc.y = npc.tgt_y;
                if (npc.life < 340) {
                    NpChar.SetNpChar(252, 0, 0, 0, 0, 0, npc, 256);
                    NpChar.SetNpChar(252, 0, 0, 0, 0, 128, npc, 256);
                }
                if (npc.life < 180) {
                    NpChar.SetNpChar(252, 0, 0, 0, 0, 64, npc, 256);
                    NpChar.SetNpChar(252, 0, 0, 0, 0, 192, npc, 256);
                }
                if (MyChar.gMC.x < npc.x - 57344 || MyChar.gMC.x > npc.x + 57344) {
                    npc.act_no = 160;
                    break;
                }
                npc.act_no = 100;
                break;
            }
            case 160: {
                npc.act_no = 161;
                npc.act_wait = 0;
                npc.ani_no = 4;
                npc.direct = MyChar.gMC.x < npc.x ? 0 : 2;
            }
            case 161: {
                npc.ym = npc.y < npc.tgt_y ? (npc.ym += 32) : (npc.ym -= 32);
                if (npc.ym < -512) {
                    npc.ym = -512;
                }
                if (npc.ym > 512) {
                    npc.ym = 512;
                }
                if (++npc.act_wait % 24 == 0) {
                    NpChar.SetNpChar(250, npc.x, npc.y + 2048, 0, 0, 0, null, 256);
                    Sound.PlaySoundObject(34, 1);
                }
                if (npc.act_wait <= 72) break;
                npc.act_wait = 0;
                npc.act_no = 100;
                break;
            }
            case 1000: {
                npc.bits = (char)(npc.bits & 0xFFFFFFDF);
                npc.act_no = 1001;
                npc.act_wait = 0;
                npc.ani_no = 4;
                npc.tgt_x = npc.x;
                npc.tgt_y = npc.y;
                npc.xm = 0;
                npc.ym = 0;
                NpChar.DeleteNpCharCode(252, true);
                NpChar.SetNpChar(4, npc.x, npc.y, 0, 0, 0, null, 256);
                NpChar.SetNpChar(4, npc.x, npc.y, 0, 0, 0, null, 256);
                NpChar.SetNpChar(4, npc.x, npc.y, 0, 0, 0, null, 256);
            }
            case 1001: {
                if (++npc.act_wait / 2 % 2 != 0) {
                    npc.x = npc.tgt_x + 512;
                    break;
                }
                npc.x = npc.tgt_x;
                break;
            }
            case 1010: {
                npc.ym += 16;
                if ((npc.flag & 8) == 0) break;
                npc.act_no = 1020;
                npc.ani_no = 8;
            }
        }
        if (npc.xm < -512) {
            npc.xm = -512;
        }
        if (npc.xm > 512) {
            npc.xm = 512;
        }
        if (npc.ym < -1024) {
            npc.ym = -1024;
        }
        if (npc.ym > 1024) {
            npc.ym = 1024;
        }
        npc.x += npc.xm;
        npc.y += npc.ym;
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc247_rcLeft[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc247_rcRight[npc.ani_no]);
        }
    }

    public static void ActNpc248(NpChar.NPCHAR npc) {
        if ((npc.flag & 0xFF) != 0) {
            npc.cond = 0;
            Caret.SetCaret(npc.x, npc.y, 2, 0);
        }
        npc.y += npc.ym;
        npc.x += npc.xm;
        if (++npc.ani_wait > 1) {
            npc.ani_wait = 0;
            if (++npc.ani_no > 2) {
                npc.ani_no = 0;
            }
        }
        npc.rect.copyFrom(ActNpc248_rect_left[npc.ani_no]);
        if (++npc.count1 > 300) {
            npc.cond = 0;
            Caret.SetCaret(npc.x, npc.y, 2, 0);
        }
    }

    public static void ActNpc249(NpChar.NPCHAR npc) {
        if (++npc.act_wait > 8) {
            npc.cond = 0;
        }
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc249_rc[0]);
            npc.x -= 1024;
        } else {
            npc.rect.copyFrom(ActNpc249_rc[1]);
            npc.x += 1024;
        }
    }

    public static void ActNpc250(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
                npc.tgt_y = npc.y;
                npc.xm = 0;
                npc.ym = -512;
            }
            case 1: {
                npc.xm = npc.x < MyChar.gMC.x ? (npc.xm += 16) : (npc.xm -= 16);
                npc.ym = npc.y < npc.tgt_y ? (npc.ym += 32) : (npc.ym -= 32);
                if (npc.xm > 512) {
                    npc.xm = 512;
                }
                if (npc.xm < -512) {
                    npc.xm = -512;
                }
                if (npc.ym > 512) {
                    npc.ym = 512;
                }
                if (npc.ym < -512) {
                    npc.ym = -512;
                }
                npc.x += npc.xm;
                npc.y += npc.ym;
                if (++npc.ani_wait > 2) {
                    npc.ani_wait = 0;
                    ++npc.ani_no;
                }
                if (npc.ani_no > 1) {
                    npc.ani_no = 0;
                }
                if (MyChar.gMC.x <= npc.x - 4096 || MyChar.gMC.x >= npc.x + 4096 || MyChar.gMC.y <= npc.y) break;
                npc.act_no = 10;
                break;
            }
            case 10: {
                npc.act_no = 11;
                npc.act_wait = 0;
            }
            case 11: {
                if (++npc.act_wait > 10) {
                    NpChar.SetNpChar(251, npc.x, npc.y, 0, 0, 0, null, 256);
                    Sound.PlaySoundObject(101, 1);
                    npc.cond = 0;
                    return;
                }
                npc.ani_no = npc.act_wait / 2 % 2 != 0 ? 2 : 1;
            }
        }
        npc.rect.copyFrom(ActNpc250_rc[npc.ani_no]);
    }

    public static void ActNpc251(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
            }
            case 1: {
                if (++npc.ani_no > 1) {
                    npc.ani_no = 0;
                }
                npc.y += 4096;
                if ((npc.flag & 0xFF) == 0) break;
                NpChar.SetDestroyNpChar(npc.x, npc.y, npc.view.back, 3);
                npc.cond = 0;
            }
        }
        npc.rect.copyFrom(ActNpc251_rc[npc.ani_no]);
    }

    public static void ActNpc252(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
                npc.act_wait = 0;
                npc.count1 = npc.direct;
            }
            case 1: {
                npc.count1 += 2;
                npc.count1 %= 256;
                char deg = (char)(npc.count1 & 0xFF);
                if (npc.act_wait < 192) {
                    ++npc.act_wait;
                }
                npc.x = npc.pNpc.x + Triangle.GetCos(deg) * npc.act_wait / 4;
                npc.y = npc.pNpc.y + Triangle.GetSin(deg) * npc.act_wait / 4;
                if (npc.pNpc.act_no != 151) break;
                npc.act_no = 10;
                npc.ani_no = 0;
                break;
            }
            case 10: {
                npc.act_no = 11;
                npc.bits = (char)(npc.bits | 0x20);
                npc.bits = (char)(npc.bits & 0xFFFFFFFB);
                npc.bits = (char)(npc.bits & 0xFFFFFFF7);
                char deg = (char)Triangle.GetArktan(npc.x - MyChar.gMC.x, npc.y - MyChar.gMC.y);
                deg = (char)(deg + (char)Game.Random(-3, 3) & 0xFF);
                npc.xm = Triangle.GetCos(deg);
                npc.ym = Triangle.GetSin(deg);
                npc.ani_no = 1;
                npc.ani_wait = 0;
                npc.direct = npc.x > MyChar.gMC.x ? 0 : 2;
            }
            case 11: {
                npc.x += npc.xm;
                npc.y += npc.ym;
                if ((npc.flag & 0xFF) != 0) {
                    NpChar.SetNpChar(4, npc.x, npc.y, 0, 0, 0, null, 256);
                    NpChar.SetNpChar(4, npc.x, npc.y, 0, 0, 0, null, 256);
                    NpChar.SetNpChar(4, npc.x, npc.y, 0, 0, 0, null, 256);
                    npc.cond = 0;
                }
                if (++npc.ani_wait > 4) {
                    npc.ani_wait = 0;
                    ++npc.ani_no;
                }
                if (npc.ani_no <= 3) break;
                npc.ani_no = 1;
            }
        }
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc252_rcLeft[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc252_rcRight[npc.ani_no]);
        }
    }

    public static void ActNpc253(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
            }
            case 1: {
                if (++npc.ani_wait > 4) {
                    npc.ani_wait = 0;
                    ++npc.ani_no;
                }
                if (npc.ani_no <= 1) break;
                npc.ani_no = 0;
            }
        }
        if (npc.life <= 100) {
            NpChar.SetExpObjects(npc.x, npc.y, npc.code_flag);
            NpChar.SetDestroyNpChar(npc.x, npc.y, npc.view.back, 8);
            Sound.PlaySoundObject(25, 1);
            npc.cond = 0;
        }
        npc.rect.copyFrom(ActNpc253_rc[npc.ani_no]);
    }

    public static void ActNpc254(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
                NpChar.SetNpChar(255, npc.x + 9216, npc.y - 29184, 0, 0, 0, npc, 256);
                NpChar.SetNpChar(255, npc.x - 16384, npc.y - 26624, 0, 0, 2, npc, 256);
                break;
            }
            case 20: {
                npc.act_wait = 0;
                npc.count1 = 60;
                npc.act_no = 21;
                break;
            }
            case 30: {
                npc.act_no = 21;
                NpChar.SetNpChar(223, npc.x - 5632, npc.y - 7168, 0, 0, 0, null, 256);
                break;
            }
            case 40: {
                npc.act_no = 21;
                NpChar.SetNpChar(223, npc.x - 4608, npc.y - 7168, 0, 0, 0, null, 256);
                NpChar.SetNpChar(40, npc.x - 11264, npc.y - 7168, 0, 0, 0, null, 256);
                NpChar.SetNpChar(93, npc.x - 17920, npc.y - 7168, 0, 0, 0, null, 256);
            }
        }
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc254_rc[0]);
        } else {
            npc.rect.copyFrom(ActNpc254_rc[1]);
        }
    }

    public static void ActNpc255(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
                if (npc.direct == 0) {
                    npc.view.front = 28672;
                    npc.view.back = 28672;
                } else {
                    npc.view.front = 20480;
                    npc.view.back = 20480;
                }
            }
            case 1: {
                if (npc.pNpc.act_no < 20) break;
                npc.act_no = 10;
                break;
            }
            case 10: {
                npc.act_no = 11;
            }
            case 11: {
                if (++npc.ani_no <= 3) break;
                npc.ani_no = 0;
            }
        }
        if (npc.direct == 0) {
            npc.x = npc.pNpc.x + 9216;
            npc.y = npc.pNpc.y - 29184;
        } else {
            npc.x = npc.pNpc.x - 16384;
            npc.y = npc.pNpc.y - 26624;
        }
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc255_rcLeft[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc255_rcRight[npc.ani_no]);
        }
    }

    public static void ActNpc256(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                NpChar.gSuperXpos = 0;
                npc.act_no = 1;
                npc.y -= 4096;
            }
            case 1: {
                npc.ani_no = 0;
                break;
            }
            case 10: {
                npc.act_no = 11;
                npc.ani_wait = 0;
                npc.ani_no = 0;
                npc.count1 = 0;
            }
            case 11: {
                if (++npc.ani_wait > 5) {
                    npc.ani_wait = 0;
                    ++npc.ani_no;
                }
                if (npc.ani_no > 1) {
                    npc.ani_no = 0;
                    ++npc.count1;
                }
                if (npc.count1 <= 5) break;
                npc.act_no = 1;
                break;
            }
            case 20: {
                npc.act_no = 21;
            }
            case 21: {
                npc.ani_no = 2;
                break;
            }
            case 40: {
                npc.act_no = 41;
                NpChar.SetNpChar(257, npc.x - 7168, npc.y - 8192, 0, 0, 0, null, 256);
                NpChar.SetNpChar(257, npc.x - 7168, npc.y - 8192, 0, 0, 2, null, 170);
            }
            case 41: {
                npc.ani_no = 4;
                break;
            }
            case 50: {
                npc.act_no = 51;
                npc.ani_wait = 0;
                npc.ani_no = 4;
                npc.count1 = 0;
            }
            case 51: {
                if (++npc.ani_wait > 5) {
                    npc.ani_wait = 0;
                    ++npc.ani_no;
                }
                if (npc.ani_no > 5) {
                    npc.ani_no = 4;
                    ++npc.count1;
                }
                if (npc.count1 <= 5) break;
                npc.act_no = 41;
            }
        }
        npc.rect.copyFrom(ActNpc256_rcLeft[npc.ani_no]);
    }

    public static void ActNpc257(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
            }
            case 1: {
                if (NpChar.gSuperXpos == 0) break;
                npc.act_no = 10;
                break;
            }
            case 10: {
                if (npc.x < NpChar.gSuperXpos) {
                    npc.xm += 85;
                }
                if (npc.x > NpChar.gSuperXpos) {
                    npc.xm -= 85;
                }
                if (npc.y < NpChar.gSuperYpos) {
                    npc.ym += 85;
                }
                if (npc.y > NpChar.gSuperYpos) {
                    npc.ym -= 85;
                }
                if (npc.xm > 1024) {
                    npc.xm = 1024;
                }
                if (npc.xm < -1024) {
                    npc.xm = -1024;
                }
                if (npc.ym > 1024) {
                    npc.ym = 1024;
                }
                if (npc.ym < -1024) {
                    npc.ym = -1024;
                }
                npc.x += npc.xm;
                npc.y += npc.ym;
            }
        }
        if (++npc.ani_wait > 3) {
            npc.ani_wait = 0;
            ++npc.ani_no;
        }
        if (npc.ani_no > 1) {
            npc.ani_no = 0;
        }
        if (npc.direct == 0 && npc.xm > 0) {
            npc.ani_no = 2;
        }
        if (npc.direct == 2 && npc.xm < 0) {
            npc.ani_no = 2;
        }
        npc.rect.copyFrom(ActNpc257_rc[npc.ani_no]);
    }

    public static void ActNpc258(NpChar.NPCHAR npc) {
        npc.rect.copyFrom(ActNpc258_rc);
    }

    public static void ActNpc259(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.bits = (char)(npc.bits & 0xFFFFDFFF);
                npc.act_no = 1;
            }
            case 1: {
                npc.direct = MyChar.gMC.direct == 0 ? 0 : 2;
                npc.y = MyChar.gMC.y - 2048;
                if (npc.direct == 0) {
                    npc.x = MyChar.gMC.x + 1536;
                    npc.rect.copyFrom(ActNpc259_rcLeft);
                } else {
                    npc.x = MyChar.gMC.x - 1536;
                    npc.rect.copyFrom(ActNpc259_rcRight);
                }
                if (MyChar.gMC.ani_no % 2 == 0) break;
                ++npc.rect.top;
                break;
            }
            case 10: {
                npc.act_no = 11;
                npc.xm = 64;
                npc.ym = -32;
                npc.rect.copyFrom(ActNpc259_rcLeft);
                break;
            }
            case 11: {
                if (npc.y < 32768) {
                    npc.ym = 32;
                }
                npc.x += npc.xm;
                npc.y += npc.ym;
                break;
            }
            case 20: {
                NpChar.VanishNpChar(npc);
                NpChar.SetDestroyNpCharUp(npc.x, npc.y, 8192, 64);
            }
        }
    }
}
