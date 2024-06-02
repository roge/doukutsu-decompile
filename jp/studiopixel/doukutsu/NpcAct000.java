/*
 * Decompiled with CFR 0.152.
 */
package jp.studiopixel.doukutsu;

import jp.studiopixel.doukutsu.Back;
import jp.studiopixel.doukutsu.Caret;
import jp.studiopixel.doukutsu.Frame;
import jp.studiopixel.doukutsu.Game;
import jp.studiopixel.doukutsu.Map;
import jp.studiopixel.doukutsu.MyChar;
import jp.studiopixel.doukutsu.NpChar;
import jp.studiopixel.doukutsu.RECT;
import jp.studiopixel.doukutsu.Sound;
import jp.studiopixel.doukutsu.Triangle;

public class NpcAct000 {
    private static final RECT[] ActNpc001_rect = new RECT[]{new RECT(0, 16, 16, 32), new RECT(16, 16, 32, 32), new RECT(32, 16, 48, 32), new RECT(48, 16, 64, 32), new RECT(64, 16, 80, 32), new RECT(80, 16, 96, 32)};
    private static final RECT ActNpc001_rcNo = new RECT(0, 0, 0, 0);
    private static final RECT[] ActNpc002_rcLeft = new RECT[]{new RECT(32, 0, 64, 24), new RECT(0, 0, 32, 24), new RECT(32, 0, 64, 24), new RECT(64, 0, 96, 24), new RECT(96, 0, 128, 24), new RECT(128, 0, 160, 24), new RECT(160, 0, 192, 24)};
    private static final RECT[] ActNpc002_rcRight = new RECT[]{new RECT(32, 24, 64, 48), new RECT(0, 24, 32, 48), new RECT(32, 24, 64, 48), new RECT(64, 24, 96, 48), new RECT(96, 24, 128, 48), new RECT(128, 24, 160, 48), new RECT(160, 24, 192, 48)};
    private static final RECT[] ActNpc004_rcLeft = new RECT[]{new RECT(16, 0, 17, 1), new RECT(16, 0, 32, 16), new RECT(32, 0, 48, 16), new RECT(48, 0, 64, 16), new RECT(64, 0, 80, 16), new RECT(80, 0, 96, 16), new RECT(96, 0, 112, 16), new RECT(112, 0, 128, 16)};
    private static final RECT[] ActNpc004_rcUp = new RECT[]{new RECT(16, 0, 17, 1), new RECT(80, 48, 96, 64), new RECT(0, 128, 16, 144), new RECT(16, 128, 32, 144), new RECT(32, 128, 48, 144), new RECT(48, 128, 64, 144), new RECT(64, 128, 80, 144), new RECT(80, 128, 96, 144)};
    private static final RECT[] ActNpc005_rcLeft = new RECT[]{new RECT(0, 48, 16, 64), new RECT(16, 48, 32, 64), new RECT(32, 48, 48, 64)};
    private static final RECT[] ActNpc005_rcRight = new RECT[]{new RECT(0, 64, 16, 80), new RECT(16, 64, 32, 80), new RECT(32, 64, 48, 80)};
    private static final RECT[] ActNpc006_rcLeft = new RECT[]{new RECT(0, 80, 16, 96), new RECT(16, 80, 32, 96), new RECT(32, 80, 48, 96), new RECT(48, 80, 64, 96), new RECT(64, 80, 80, 96)};
    private static final RECT[] ActNpc006_rcRight = new RECT[]{new RECT(0, 96, 16, 112), new RECT(16, 96, 32, 112), new RECT(32, 96, 48, 112), new RECT(48, 96, 64, 112), new RECT(64, 96, 80, 112)};
    private static final RECT[] ActNpc007_rcLeft = new RECT[]{new RECT(256, 64, 288, 80), new RECT(256, 80, 288, 96), new RECT(256, 96, 288, 112)};
    private static final RECT[] ActNpc007_rcRight = new RECT[]{new RECT(288, 64, 320, 80), new RECT(288, 80, 320, 96), new RECT(288, 96, 320, 112)};
    private static final RECT[] ActNpc008_rcLeft = new RECT[]{new RECT(80, 80, 96, 96), new RECT(96, 80, 112, 96)};
    private static final RECT[] ActNpc008_rcRight = new RECT[]{new RECT(80, 96, 96, 112), new RECT(96, 96, 112, 112)};
    private static final RECT[] ActNpc009_rcLeft = new RECT[]{new RECT(0, 0, 40, 24), new RECT(80, 0, 120, 24), new RECT(120, 0, 160, 24)};
    private static final RECT[] ActNpc009_rcRight = new RECT[]{new RECT(0, 24, 40, 48), new RECT(80, 24, 120, 48), new RECT(120, 24, 160, 48)};
    private static final RECT[] ActNpc010_rcLeft = new RECT[]{new RECT(0, 0, 40, 24), new RECT(40, 0, 80, 24), new RECT(80, 0, 120, 24), new RECT(120, 0, 160, 24)};
    private static final RECT[] ActNpc010_rcRight = new RECT[]{new RECT(0, 24, 40, 48), new RECT(40, 24, 80, 48), new RECT(80, 24, 120, 48), new RECT(120, 24, 160, 48)};
    private static final RECT[] ActNpc011_rcLeft = new RECT[]{new RECT(208, 104, 224, 120), new RECT(224, 104, 240, 120), new RECT(240, 104, 256, 120)};
    private static final RECT[] ActNpc012_rcLeft = new RECT[]{new RECT(0, 0, 40, 24), new RECT(160, 0, 200, 24), new RECT(80, 0, 120, 24), new RECT(120, 0, 160, 24), new RECT(240, 0, 280, 24), new RECT(200, 0, 240, 24), new RECT(280, 0, 320, 24), new RECT(0, 0, 0, 0), new RECT(80, 48, 120, 72), new RECT(0, 48, 40, 72), new RECT(0, 0, 40, 24), new RECT(40, 48, 80, 72), new RECT(0, 0, 40, 24), new RECT(280, 0, 320, 24)};
    private static final RECT[] ActNpc012_rcRight = new RECT[]{new RECT(0, 24, 40, 48), new RECT(160, 24, 200, 48), new RECT(80, 24, 120, 48), new RECT(120, 24, 160, 48), new RECT(240, 24, 280, 48), new RECT(200, 24, 240, 48), new RECT(280, 24, 320, 48), new RECT(0, 0, 0, 0), new RECT(80, 72, 120, 96), new RECT(0, 72, 40, 96), new RECT(0, 24, 40, 48), new RECT(40, 72, 80, 96), new RECT(0, 24, 40, 48), new RECT(280, 24, 320, 48)};
    private static final RECT[] ActNpc013_rect = new RECT[]{new RECT(128, 0, 144, 16), new RECT(144, 0, 160, 16), new RECT(160, 0, 176, 16), new RECT(176, 0, 192, 16)};
    private static final RECT[] ActNpc014_rect = new RECT[]{new RECT(192, 0, 208, 16), new RECT(208, 0, 224, 16), new RECT(224, 0, 240, 16)};
    private static final RECT[] ActNpc015_rcLeft = new RECT[]{new RECT(240, 0, 256, 16), new RECT(256, 0, 272, 16), new RECT(272, 0, 288, 16)};
    private static final RECT[] ActNpc016_rcLeft = new RECT[]{new RECT(96, 16, 112, 32), new RECT(112, 16, 128, 32), new RECT(128, 16, 144, 32), new RECT(144, 16, 160, 32), new RECT(160, 16, 176, 32), new RECT(176, 16, 192, 32), new RECT(192, 16, 208, 32), new RECT(208, 16, 224, 32)};
    private static final RECT[] ActNpc017_rcLeft = new RECT[]{new RECT(288, 0, 304, 16), new RECT(304, 0, 320, 16)};
    private static final RECT[] ActNpc018_rect = new RECT[]{new RECT(224, 16, 240, 40), new RECT(192, 112, 208, 136)};
    private static final RECT[] ActNpc019_rect_left = new RECT[]{new RECT(0, 0, 40, 24), new RECT(160, 0, 200, 24), new RECT(80, 0, 120, 24), new RECT(120, 0, 160, 24)};
    private static final RECT[] ActNpc019_rect_right = new RECT[]{new RECT(0, 24, 40, 48), new RECT(160, 24, 200, 48), new RECT(80, 24, 120, 48), new RECT(120, 24, 160, 48)};

    public static void ActNpc000(NpChar.NPCHAR npc) {
        RECT rect = new RECT(0, 0, 16, 16);
        if (npc.act_no == 0) {
            npc.act_no = 1;
            if (npc.direct == 2) {
                npc.y += 8192;
            }
        }
        npc.rect.copyFrom(rect);
    }

    public static void ActNpc001(NpChar.NPCHAR npc) {
        if (Back.gBack.type == 5 || Back.gBack.type == 6) {
            if (npc.act_no == 0) {
                npc.act_no = 1;
                npc.ym = Game.Random(-128, 128);
                npc.xm = Game.Random(127, 256);
            }
            npc.xm -= 8;
            if (npc.x < 40960) {
                npc.cond = 0;
            }
            if (npc.x < -1536) {
                npc.x = -1536;
            }
            if ((npc.flag & 1) != 0) {
                npc.xm = 256;
            }
            if ((npc.flag & 2) != 0) {
                npc.ym = 64;
            }
            if ((npc.flag & 8) != 0) {
                npc.ym = -64;
            }
        } else {
            if (npc.act_no == 0) {
                npc.act_no = 1;
                npc.ani_no = Game.Random(0, 4);
                npc.xm = Game.Random(-512, 512);
                npc.ym = Game.Random(-1024, 0);
                npc.direct = Game.Random(0, 1) != 0 ? 0 : 2;
            }
            npc.ym = (npc.flag & 0x100) != 0 ? (npc.ym += 21) : (npc.ym += 42);
            if ((npc.flag & 1) != 0 && npc.xm < 0) {
                npc.xm *= -1;
            }
            if ((npc.flag & 4) != 0 && npc.xm > 0) {
                npc.xm *= -1;
            }
            if ((npc.flag & 2) != 0 && npc.ym < 0) {
                npc.ym *= -1;
            }
            if ((npc.flag & 8) != 0) {
                Sound.PlaySoundObject(45, 1);
                npc.ym = -640;
                npc.xm = 2 * npc.xm / 3;
            }
            if ((npc.flag & 0xD) != 0) {
                Sound.PlaySoundObject(45, 1);
                if (++npc.count2 > 2) {
                    npc.y -= 512;
                }
            } else {
                npc.count2 = 0;
            }
            if (npc.xm < -1535) {
                npc.xm = -1535;
            }
            if (npc.xm > 1535) {
                npc.xm = 1535;
            }
            if (npc.ym < -1535) {
                npc.ym = -1535;
            }
            if (npc.ym > 1535) {
                npc.ym = 1535;
            }
        }
        npc.y += npc.ym;
        npc.x += npc.xm;
        ++npc.ani_wait;
        if (npc.direct == 0) {
            if (npc.ani_wait > 2) {
                npc.ani_wait = 0;
                if (++npc.ani_no > 5) {
                    npc.ani_no = 0;
                }
            }
        } else if (npc.ani_wait > 2) {
            npc.ani_wait = 0;
            if (--npc.ani_no < 0) {
                npc.ani_no = 5;
            }
        }
        npc.rect.copyFrom(ActNpc001_rect[npc.ani_no]);
        if (npc.act_no != 0) {
            switch (npc.exp) {
                case 5: {
                    npc.rect.top += 16;
                    npc.rect.bottom += 16;
                    break;
                }
                case 20: {
                    npc.rect.top += 32;
                    npc.rect.bottom += 32;
                }
            }
            npc.act_no = 1;
        }
        if (++npc.count1 > 500 && npc.ani_no == 5 && npc.ani_wait == 2) {
            npc.cond = 0;
        }
        if (npc.count1 > 400 && npc.count1 / 2 % 2 != 0) {
            npc.rect.copyFrom(ActNpc001_rcNo);
        }
    }

    public static void ActNpc002(NpChar.NPCHAR npc) {
        if ((npc.flag & 1) != 0) {
            npc.direct = 2;
        } else if ((npc.flag & 4) != 0) {
            npc.direct = 0;
        }
        switch (npc.act_no) {
            case 0: {
                npc.xm = npc.direct == 0 ? -256 : 256;
                if (++npc.ani_wait > 8) {
                    npc.ani_wait = 0;
                    ++npc.ani_no;
                }
                if (npc.ani_no > 3) {
                    npc.ani_no = 0;
                }
                if (npc.shock == '\u0000') break;
                npc.count1 = 0;
                npc.act_no = 1;
                npc.ani_no = 4;
                break;
            }
            case 1: {
                npc.xm = npc.xm * 7 / 8;
                if (++npc.count1 <= 40) break;
                if (npc.shock != '\u0000') {
                    npc.count1 = 0;
                    npc.act_no = 2;
                    npc.ani_no = 6;
                    npc.ani_wait = 0;
                    npc.damage = 5;
                    break;
                }
                npc.act_no = 0;
                npc.ani_wait = 0;
                break;
            }
            case 2: {
                npc.xm = npc.direct == 0 ? -1024 : 1024;
                if (++npc.count1 > 200) {
                    npc.act_no = 0;
                    npc.damage = 1;
                }
                if (++npc.ani_wait > 5) {
                    npc.ani_wait = 0;
                    ++npc.ani_no;
                }
                if (npc.ani_no <= 6) break;
                npc.ani_no = 5;
                Sound.PlaySoundObject(26, 1);
                NpChar.SetNpChar(4, npc.x, npc.y + 1536, 0, 0, 0, null, 256);
                Frame.SetQuake(8);
            }
        }
        npc.ym += 64;
        if (npc.ym > 1535) {
            npc.ym = 1535;
        }
        npc.x += npc.xm;
        npc.y += npc.ym;
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc002_rcLeft[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc002_rcRight[npc.ani_no]);
        }
    }

    public static void ActNpc003(NpChar.NPCHAR npc) {
        if (++npc.count1 > 100) {
            npc.cond = 0;
        }
        npc.rect.copyFrom(new RECT(0, 0, 0, 0));
    }

    public static void ActNpc004(NpChar.NPCHAR npc) {
        if (npc.act_no == 0) {
            if (npc.direct == 0 || npc.direct == 1) {
                int deg = Game.Random(0, 255);
                npc.xm = Triangle.GetCos((char)deg) * Game.Random(512, 1535) / 512;
                npc.ym = Triangle.GetSin((char)deg) * Game.Random(512, 1535) / 512;
            }
            npc.ani_no = Game.Random(0, 4);
            npc.ani_wait = Game.Random(0, 3);
            npc.act_no = 1;
        } else {
            npc.xm = npc.xm * 20 / 21;
            npc.ym = npc.ym * 20 / 21;
            npc.x += npc.xm;
            npc.y += npc.ym;
        }
        if (++npc.ani_wait > 4) {
            npc.ani_wait = 0;
            ++npc.ani_no;
        }
        if (npc.ani_no > 7) {
            npc.cond = 0;
        } else {
            if (npc.direct == 1) {
                npc.rect.copyFrom(ActNpc004_rcUp[npc.ani_no]);
            }
            if (npc.direct == 0) {
                npc.rect.copyFrom(ActNpc004_rcLeft[npc.ani_no]);
            }
            if (npc.direct == 2) {
                npc.rect.copyFrom(ActNpc004_rcLeft[npc.ani_no]);
            }
        }
    }

    public static void ActNpc005(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.y += 1536;
                npc.act_no = 1;
            }
            case 1: {
                npc.direct = npc.x > MyChar.gMC.x ? 0 : 2;
                if (npc.act_wait >= 8 && npc.x - 57344 < MyChar.gMC.x && npc.x + 57344 > MyChar.gMC.x && npc.y - 40960 < MyChar.gMC.y && npc.y + 40960 > MyChar.gMC.y) {
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
                if (npc.act_wait < 8 || npc.x - 24576 >= MyChar.gMC.x || npc.x + 24576 <= MyChar.gMC.x || npc.y - 40960 >= MyChar.gMC.y || npc.y + 24576 <= MyChar.gMC.y) break;
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
                    npc.xm = -256;
                    break;
                }
                npc.xm = 256;
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
        npc.ym += 64;
        if (npc.ym > 1535) {
            npc.ym = 1535;
        }
        npc.x += npc.xm;
        npc.y += npc.ym;
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc005_rcLeft[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc005_rcRight[npc.ani_no]);
        }
    }

    public static void ActNpc006(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                if (npc.direct == 0) {
                    npc.act_no = 1;
                    break;
                }
                npc.act_no = 3;
                break;
            }
            case 1: {
                npc.xm -= 16;
                if (npc.xm < -1024) {
                    npc.xm = -1024;
                }
                npc.x = npc.shock != '\u0000' ? (npc.x += npc.xm / 2) : (npc.x += npc.xm);
                if (++npc.ani_wait > 1) {
                    npc.ani_wait = 0;
                    ++npc.ani_no;
                }
                if (npc.ani_no > 2) {
                    npc.ani_no = 1;
                }
                if ((npc.flag & 1) == 0) break;
                npc.act_no = 2;
                npc.act_wait = 0;
                npc.ani_no = 0;
                npc.xm = 0;
                npc.direct = 2;
                break;
            }
            case 2: {
                if (++npc.act_wait <= 60) break;
                npc.act_no = 3;
                npc.ani_wait = 0;
                npc.ani_no = 1;
                break;
            }
            case 3: {
                npc.xm += 16;
                if (npc.xm > 1024) {
                    npc.xm = 1024;
                }
                npc.x = npc.shock != '\u0000' ? (npc.x += npc.xm / 2) : (npc.x += npc.xm);
                if (++npc.ani_wait > 1) {
                    npc.ani_wait = 0;
                    ++npc.ani_no;
                }
                if (npc.ani_no > 2) {
                    npc.ani_no = 1;
                }
                if ((npc.flag & 4) == 0) break;
                npc.act_no = 4;
                npc.act_wait = 0;
                npc.ani_no = 0;
                npc.xm = 0;
                npc.direct = 0;
                break;
            }
            case 4: {
                if (++npc.act_wait <= 60) break;
                npc.act_no = 1;
                npc.ani_wait = 0;
                npc.ani_no = 1;
            }
        }
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc006_rcLeft[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc006_rcRight[npc.ani_no]);
        }
    }

    public static void ActNpc007(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.x = MyChar.gMC.x;
                if (npc.direct == 0) {
                    npc.act_no = 1;
                    break;
                }
                npc.act_no = 2;
                break;
            }
            case 1: {
                npc.xm -= 64;
                if (npc.x < MyChar.gMC.x - 98304) {
                    npc.act_no = 2;
                }
                if ((npc.flag & 1) == 0) break;
                npc.xm = 0;
                npc.act_no = 2;
                break;
            }
            case 2: {
                npc.xm += 64;
                if (npc.x > MyChar.gMC.x + 98304) {
                    npc.act_no = 1;
                }
                if ((npc.flag & 4) == 0) break;
                npc.xm = 0;
                npc.act_no = 1;
            }
        }
        npc.direct = npc.xm < 0 ? 0 : 2;
        if (npc.xm > 1535) {
            npc.xm = 1535;
        }
        if (npc.xm < -1535) {
            npc.xm = -1535;
        }
        npc.x += npc.xm;
        if (++npc.ani_wait > 1) {
            npc.ani_wait = 0;
            ++npc.ani_no;
        }
        if (npc.ani_no > 2) {
            npc.ani_no = 0;
        }
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc007_rcLeft[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc007_rcRight[npc.ani_no]);
        }
    }

    public static void ActNpc008(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                if (MyChar.gMC.x < npc.x + 8192 && MyChar.gMC.x > npc.x - 8192) {
                    npc.bits = (char)(npc.bits | 0x20);
                    npc.ym = -256;
                    npc.tgt_y = npc.y;
                    npc.act_no = 1;
                    npc.damage = 2;
                    if (npc.direct == 0) {
                        npc.x = MyChar.gMC.x + 131072;
                        npc.xm = -767;
                        break;
                    }
                    npc.x = MyChar.gMC.x - 131072;
                    npc.xm = 767;
                    break;
                }
                npc.bits = (char)(npc.bits & 0xFFFFFFDF);
                npc.rect.right = 0;
                npc.damage = 0;
                npc.xm = 0;
                npc.ym = 0;
                return;
            }
            case 1: {
                if (npc.x > MyChar.gMC.x) {
                    npc.direct = 0;
                    npc.xm -= 16;
                } else {
                    npc.direct = 2;
                    npc.xm += 16;
                }
                if (npc.xm > 767) {
                    npc.xm = 767;
                }
                if (npc.xm < -767) {
                    npc.xm = -767;
                }
                npc.ym = npc.y < npc.tgt_y ? (npc.ym += 8) : (npc.ym -= 8);
                if (npc.ym > 256) {
                    npc.ym = 256;
                }
                if (npc.ym < -256) {
                    npc.ym = -256;
                }
                if (npc.shock != '\u0000') {
                    npc.x += npc.xm / 2;
                    npc.y += npc.ym / 2;
                    break;
                }
                npc.x += npc.xm;
                npc.y += npc.ym;
            }
        }
        if (++npc.ani_wait > 1) {
            npc.ani_wait = 0;
            ++npc.ani_no;
        }
        if (npc.ani_no > 1) {
            npc.ani_no = 0;
        }
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc008_rcLeft[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc008_rcRight[npc.ani_no]);
        }
    }

    public static void ActNpc009(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
                npc.ani_no = 2;
            }
            case 1: {
                npc.ym += 32;
                if (npc.count1 < 40) {
                    ++npc.count1;
                } else {
                    npc.bits = (char)(npc.bits & 0xFFFFFFF7);
                    npc.bits = (char)(npc.bits | '\u0001');
                }
                if ((npc.flag & 8) == 0) break;
                for (int i = 0; i < 4; ++i) {
                    NpChar.SetNpChar(4, npc.x + Game.Random(-12, 12) * 512, npc.y + Game.Random(-12, 12) * 512, Game.Random(-341, 341), Game.Random(-1536, 0), 0, null, 256);
                }
                npc.act_no = 2;
                npc.ani_no = 1;
                npc.act_wait = 0;
                Sound.PlaySoundObject(26, 1);
                Frame.SetQuake(30);
                break;
            }
            case 2: {
                if (++npc.act_wait <= 16) break;
                npc.act_no = 3;
                npc.ani_no = 0;
                npc.ani_wait = 0;
            }
        }
        if (npc.ym > 1535) {
            npc.ym = 1535;
        }
        if (npc.ym < -1535) {
            npc.ym = -1535;
        }
        npc.x += npc.xm;
        npc.y += npc.ym;
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc009_rcLeft[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc009_rcRight[npc.ani_no]);
        }
    }

    public static void ActNpc010(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
            }
            case 1: {
                if (++npc.act_wait <= 12) break;
                npc.act_no = 2;
                npc.act_wait = 0;
                npc.count1 = 3;
                npc.ani_no = 1;
                break;
            }
            case 2: {
                if (++npc.act_wait <= 16) break;
                --npc.count1;
                npc.act_wait = 0;
                int deg = Triangle.GetArktan(npc.x - MyChar.gMC.x, npc.y + 2048 - MyChar.gMC.y);
                int ym = Triangle.GetSin((char)(deg += Game.Random(-16, 16)));
                int xm = Triangle.GetCos((char)deg);
                NpChar.SetNpChar(11, npc.x, npc.y + 2048, xm, ym, 0, null, 256);
                Sound.PlaySoundObject(39, 1);
                if (npc.count1 != 0) break;
                npc.act_no = 3;
                npc.act_wait = 0;
                break;
            }
            case 3: {
                if (++npc.act_wait <= 3) break;
                npc.act_no = 4;
                npc.act_wait = 0;
                npc.xm = (MyChar.gMC.x - npc.x) / 100;
                npc.ym = -1536;
                npc.ani_no = 3;
                break;
            }
            case 4: {
                if ((npc.flag & 5) != 0) {
                    npc.xm = 0;
                }
                npc.damage = npc.y + 8192 < MyChar.gMC.y ? 5 : 0;
                if ((npc.flag & 8) == 0) break;
                npc.act_no = 5;
                npc.act_wait = 0;
                npc.ani_no = 2;
                Sound.PlaySoundObject(26, 1);
                Frame.SetQuake(30);
                npc.damage = 0;
                break;
            }
            case 5: {
                npc.xm = 0;
                if (++npc.act_wait <= 3) break;
                npc.act_no = 1;
                npc.act_wait = 0;
            }
        }
        npc.ym += 32;
        if (npc.ym > 1535) {
            npc.ym = 1535;
        }
        npc.x += npc.xm;
        npc.y += npc.ym;
        npc.direct = npc.x < MyChar.gMC.x ? 2 : 0;
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc010_rcLeft[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc010_rcRight[npc.ani_no]);
        }
    }

    public static void ActNpc011(NpChar.NPCHAR npc) {
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
        npc.rect.copyFrom(ActNpc011_rcLeft[npc.ani_no]);
        if (++npc.count1 > 150) {
            Caret.SetCaret(npc.x, npc.y, 2, 0);
            npc.cond = 0;
        }
    }

    public static void ActNpc012(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                if (npc.direct == 4) {
                    npc.direct = npc.x > MyChar.gMC.x ? 0 : 2;
                }
                npc.act_no = 1;
                npc.ani_no = 0;
            }
            case 1: {
                if (Game.Random(0, 100) != 0) break;
                npc.act_no = 2;
                npc.act_wait = 0;
                npc.ani_no = 1;
                break;
            }
            case 2: {
                if (++npc.act_wait <= 16) break;
                npc.act_no = 1;
                npc.ani_no = 0;
                break;
            }
            case 10: {
                if (npc.direct == 4) {
                    npc.direct = npc.x > MyChar.gMC.x ? 0 : 2;
                }
                npc.act_no = 11;
                npc.ani_no = 2;
                npc.act_wait = 0;
                npc.tgt_x = 0;
            }
            case 11: {
                if (++npc.act_wait <= 30) break;
                npc.act_no = 12;
                npc.act_wait = 0;
                npc.ani_no = 3;
                npc.ym = -2048;
                npc.bits = (char)(npc.bits | 8);
                break;
            }
            case 12: {
                if ((npc.flag & 5) != 0) {
                    npc.xm = 0;
                }
                if (npc.y >= 0) break;
                npc.code_char = 0;
                Sound.PlaySoundObject(26, 1);
                Frame.SetQuake(30);
                break;
            }
            case 20: {
                if (npc.direct == 4) {
                    npc.direct = npc.x > MyChar.gMC.x ? 0 : 2;
                }
                npc.act_no = 21;
                npc.ani_no = 5;
                npc.act_wait = 0;
                npc.count1 = 0;
                for (int i = 0; i < 4; ++i) {
                    NpChar.SetNpChar(4, npc.x + Game.Random(-12, 12) * 512, npc.y + Game.Random(-12, 12) * 512, Game.Random(-341, 341), Game.Random(-1536, 0), 0, null, 256);
                }
                Sound.PlaySoundObject(72, 1);
            }
            case 21: {
                npc.tgt_x = 1;
                if ((npc.flag & 8) != 0) {
                    ++npc.act_wait;
                }
                npc.x = ++npc.count1 / 2 % 2 != 0 ? (npc.x += 512) : (npc.x -= 512);
                if (npc.act_wait > 100) {
                    npc.act_no = 11;
                    npc.act_wait = 0;
                    npc.ani_no = 2;
                }
                npc.ym += 32;
                if (npc.ym <= 1535) break;
                npc.ym = 1535;
                break;
            }
            case 30: {
                npc.ani_no = 4;
                if (++npc.act_wait <= 100) break;
                npc.act_no = 0;
                npc.ani_no = 0;
                break;
            }
            case 40: {
                if (npc.direct == 4) {
                    npc.direct = npc.x > MyChar.gMC.x ? 0 : 2;
                }
                npc.act_no = 41;
                npc.act_wait = 0;
                npc.ani_no = 5;
            }
            case 41: {
                if (++npc.ani_wait / 2 % 2 != 0) {
                    npc.ani_no = 5;
                    break;
                }
                npc.ani_no = 6;
                break;
            }
            case 42: {
                if (npc.direct == 4) {
                    npc.direct = npc.x > MyChar.gMC.x ? 0 : 2;
                }
                npc.act_no = 43;
                npc.act_wait = 0;
                npc.ani_no = 6;
            }
            case 43: {
                if (++npc.ani_wait / 2 % 2 != 0) {
                    npc.ani_no = 7;
                    break;
                }
                npc.ani_no = 6;
                break;
            }
            case 50: {
                npc.ani_no = 8;
                npc.xm = 0;
                break;
            }
            case 60: {
                npc.act_no = 61;
                npc.ani_no = 9;
                npc.ani_wait = 0;
            }
            case 61: {
                if (++npc.ani_wait > 3) {
                    npc.ani_wait = 0;
                    if (++npc.ani_no == 10 || npc.ani_no == 11) {
                        Sound.PlaySoundObject(23, 1);
                    }
                }
                if (npc.ani_no > 12) {
                    npc.ani_no = 9;
                }
                if (npc.direct == 0) {
                    npc.xm = -512;
                    break;
                }
                npc.xm = 512;
                break;
            }
            case 70: {
                npc.act_no = 71;
                npc.act_wait = 64;
                Sound.PlaySoundObject(29, 1);
                npc.ani_no = 13;
            }
            case 71: {
                if (--npc.act_wait != 0) break;
                npc.cond = 0;
                break;
            }
            case 80: {
                npc.count1 = 0;
                npc.act_no = 81;
            }
            case 81: {
                npc.x = ++npc.count1 / 2 % 2 != 0 ? (npc.x += 512) : (npc.x -= 512);
                npc.ani_no = 5;
                npc.xm = 0;
                npc.ym += 32;
                break;
            }
            case 100: {
                npc.act_no = 101;
                npc.act_wait = 0;
                npc.ani_no = 2;
            }
            case 101: {
                if (++npc.act_wait <= 20) break;
                npc.act_no = 102;
                npc.act_wait = 0;
                npc.ani_no = 3;
                npc.ym = -2048;
                npc.bits = (char)(npc.bits | 8);
                NpChar.DeleteNpCharCode(150, false);
                NpChar.DeleteNpCharCode(117, false);
                NpChar.SetNpChar(355, 0, 0, 0, 0, 0, npc, 256);
                NpChar.SetNpChar(355, 0, 0, 0, 0, 1, npc, 256);
                break;
            }
            case 102: {
                int x = npc.x / 512 / 16;
                int y = npc.y / 512 / 16;
                if (y >= 0 && y < 35 && Map.ChangeMapParts(x, y, (byte)0)) {
                    Map.ChangeMapParts(x - 1, y, (byte)0);
                    Map.ChangeMapParts(x + 1, y, (byte)0);
                    Sound.PlaySoundObject(44, 1);
                    Frame.SetQuake2(10);
                }
                if (npc.y >= -16384) break;
                npc.code_char = 0;
                Frame.SetQuake(30);
            }
        }
        if (npc.tgt_x != 0 && Game.Random(0, 10) == 0) {
            NpChar.SetNpChar(4, npc.x + Game.Random(-12, 12) * 512, npc.y + Game.Random(-12, 12) * 512, Game.Random(-341, 341), Game.Random(-1536, 0), 0, null, 256);
        }
        if (npc.ym > 1535) {
            npc.ym = 1535;
        }
        npc.x += npc.xm;
        npc.y += npc.ym;
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc012_rcLeft[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc012_rcRight[npc.ani_no]);
        }
        if (npc.act_no == 71) {
            npc.rect.bottom = npc.rect.top + npc.act_wait / 2;
            if (npc.act_wait % 2 != 0) {
                ++npc.rect.left;
            }
        }
    }

    public static void ActNpc013(NpChar.NPCHAR npc) {
        if (++npc.ani_wait > 0) {
            npc.ani_wait = 0;
            ++npc.ani_no;
        }
        if (npc.ani_no > 3) {
            npc.ani_no = 0;
        }
        npc.rect.copyFrom(ActNpc013_rect[npc.ani_no]);
    }

    public static void ActNpc014(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
                if (npc.direct != 2) break;
                npc.ym = -512;
                for (int i = 0; i < 4; ++i) {
                    NpChar.SetNpChar(4, npc.x + Game.Random(-12, 12) * 512, npc.y + Game.Random(-12, 12) * 512, Game.Random(-341, 341), Game.Random(-1536, 0), 0, null, 256);
                }
                break;
            }
        }
        if (++npc.ani_wait > 1) {
            npc.ani_wait = 0;
            ++npc.ani_no;
        }
        if (npc.ani_no > 2) {
            npc.ani_no = 0;
        }
        npc.ym += 64;
        if (npc.ym > 1535) {
            npc.ym = 1535;
        }
        npc.y += npc.ym;
        npc.rect.copyFrom(ActNpc014_rect[npc.ani_no]);
    }

    public static void ActNpc015(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
                npc.bits = (char)(npc.bits | 0x2000);
                if (npc.direct == 2) {
                    npc.ym = -512;
                    for (int i = 0; i < 4; ++i) {
                        NpChar.SetNpChar(4, npc.x + Game.Random(-12, 12) * 512, npc.y + Game.Random(-12, 12) * 512, Game.Random(-341, 341), Game.Random(-1536, 0), 0, null, 256);
                    }
                }
            }
            case 1: {
                npc.ani_no = 0;
                if (Game.Random(0, 30) != 0) break;
                npc.act_no = 2;
                break;
            }
            case 2: {
                if (++npc.ani_wait > 1) {
                    npc.ani_wait = 0;
                    ++npc.ani_no;
                }
                if (npc.ani_no <= 2) break;
                npc.ani_no = 0;
                npc.act_no = 1;
            }
        }
        npc.ym += 64;
        if (npc.ym > 1535) {
            npc.ym = 1535;
        }
        npc.y += npc.ym;
        npc.rect.copyFrom(ActNpc015_rcLeft[npc.ani_no]);
    }

    public static void ActNpc016(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.bits = (char)(npc.bits | 0x2000);
                npc.act_no = 1;
                if (npc.direct == 2) {
                    npc.bits = (char)(npc.bits & 0xFFFFDFFF);
                    npc.ym = -512;
                    for (int i = 0; i < 4; ++i) {
                        NpChar.SetNpChar(4, npc.x + Game.Random(-12, 12) * 512, npc.y + Game.Random(-12, 12) * 512, Game.Random(-341, 341), Game.Random(-1536, 0), 0, null, 256);
                    }
                }
            }
            case 1: {
                if ((npc.flag & 8) == 0) break;
                npc.bits = (char)(npc.bits | 0x2000);
            }
        }
        if (++npc.ani_wait > 2) {
            npc.ani_wait = 0;
            ++npc.ani_no;
        }
        if (npc.ani_no > 7) {
            npc.ani_no = 0;
        }
        npc.ym += 64;
        if (npc.ym > 1535) {
            npc.ym = 1535;
        }
        npc.y += npc.ym;
        npc.rect.copyFrom(ActNpc016_rcLeft[npc.ani_no]);
    }

    public static void ActNpc017(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                npc.act_no = 1;
                if (npc.direct == 2) {
                    npc.ym = -512;
                    for (int i = 0; i < 4; ++i) {
                        NpChar.SetNpChar(4, npc.x + Game.Random(-12, 12) * 512, npc.y + Game.Random(-12, 12) * 512, Game.Random(-341, 341), Game.Random(-1536, 0), 0, null, 256);
                    }
                }
            }
            case 1: {
                int a = Game.Random(0, 30);
                npc.act_no = a < 10 ? 2 : (a < 25 ? 3 : 4);
                npc.act_wait = Game.Random(16, 64);
                npc.ani_wait = 0;
                break;
            }
            case 2: {
                npc.rect.copyFrom(ActNpc017_rcLeft[0]);
                if (--npc.act_wait != 0) break;
                npc.act_no = 1;
                break;
            }
            case 3: {
                if (++npc.ani_wait % 2 != 0) {
                    npc.rect.copyFrom(ActNpc017_rcLeft[0]);
                } else {
                    npc.rect.copyFrom(ActNpc017_rcLeft[1]);
                }
                if (--npc.act_wait != 0) break;
                npc.act_no = 1;
                break;
            }
            case 4: {
                npc.rect.copyFrom(ActNpc017_rcLeft[1]);
                if (--npc.act_wait != 0) break;
                npc.act_no = 1;
            }
        }
        npc.ym += 64;
        if (npc.ym > 1535) {
            npc.ym = 1535;
        }
        npc.y += npc.ym;
    }

    public static void ActNpc018(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                if (npc.direct == 0) {
                    npc.rect.copyFrom(ActNpc018_rect[0]);
                    break;
                }
                npc.rect.copyFrom(ActNpc018_rect[1]);
                break;
            }
            case 1: {
                for (int i = 0; i < 4; ++i) {
                    NpChar.SetNpChar(4, npc.x, npc.y, Game.Random(-341, 341), Game.Random(-1536, 0), 0, null, 256);
                }
                npc.act_no = 0;
                npc.rect.copyFrom(ActNpc018_rect[0]);
            }
        }
    }

    public static void ActNpc019(NpChar.NPCHAR npc) {
        switch (npc.act_no) {
            case 0: {
                for (int i = 0; i < 16; ++i) {
                    NpChar.SetNpChar(4, npc.x + Game.Random(-12, 12) * 512, npc.y + Game.Random(-12, 12) * 512, Game.Random(-341, 341), Game.Random(-1536, 0), 0, null, 256);
                }
                npc.y += 5120;
                npc.act_no = 1;
                npc.ani_no = 3;
                npc.ym = -256;
                Sound.PlaySoundObject(12, 1);
                Sound.PlaySoundObject(26, 1);
                Frame.SetQuake(30);
            }
            case 1: {
                npc.ym += 16;
                if (npc.ym <= 0 || (npc.flag & 8) == 0) break;
                npc.act_no = 2;
                npc.ani_no = 2;
                npc.act_wait = 0;
                Sound.PlaySoundObject(26, 1);
                Frame.SetQuake(30);
                break;
            }
            case 2: {
                if (++npc.act_wait <= 16) break;
                npc.act_no = 3;
                npc.ani_no = 0;
                npc.ani_wait = 0;
                break;
            }
            case 3: {
                if (Game.Random(0, 100) != 0) break;
                npc.act_no = 4;
                npc.act_wait = 0;
                npc.ani_no = 1;
                break;
            }
            case 4: {
                if (++npc.act_wait <= 16) break;
                npc.act_no = 3;
                npc.ani_no = 0;
            }
        }
        if (npc.ym > 1535) {
            npc.ym = 1535;
        }
        if (npc.ym < -1535) {
            npc.ym = -1535;
        }
        npc.x += npc.xm;
        npc.y += npc.ym;
        if (npc.direct == 0) {
            npc.rect.copyFrom(ActNpc019_rect_left[npc.ani_no]);
        } else {
            npc.rect.copyFrom(ActNpc019_rect_right[npc.ani_no]);
        }
    }
}
