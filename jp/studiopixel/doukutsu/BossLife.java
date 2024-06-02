/*
 * Decompiled with CFR 0.152.
 */
package jp.studiopixel.doukutsu;

import jp.studiopixel.doukutsu.Boss;
import jp.studiopixel.doukutsu.Draw;
import jp.studiopixel.doukutsu.IntSupplier;
import jp.studiopixel.doukutsu.NpChar;
import jp.studiopixel.doukutsu.RECT;

public class BossLife {
    public static BOSSLIFE gBL = new BOSSLIFE();
    private static final RECT rcText = new RECT(0, 48, 32, 56);
    private static final RECT rcBox1 = new RECT(0, 0, 244, 8);
    private static final RECT rcBox2 = new RECT(0, 16, 244, 24);
    private static final RECT rcLife = new RECT(0, 24, 0, 32);
    private static final RECT rcBr = new RECT(0, 32, 232, 40);

    public static void InitBossLife() {
        BossLife.gBL.flag = false;
    }

    public static boolean StartBossLife(int code_event) {
        int i;
        for (i = 0; i < NpChar.gNPC.length && NpChar.gNPC[i].code_event != code_event; ++i) {
        }
        if (i == NpChar.gNPC.length) {
            return false;
        }
        int ii = i;
        BossLife.gBL.flag = true;
        BossLife.gBL.max = NpChar.gNPC[i].life;
        BossLife.gBL.br = NpChar.gNPC[i].life;
        BossLife.gBL.pLife = () -> NpChar.gNPC[ii].life;
        return true;
    }

    public static boolean StartBossLife2() {
        BossLife.gBL.flag = true;
        BossLife.gBL.max = Boss.gBoss[0].life;
        BossLife.gBL.br = Boss.gBoss[0].life;
        BossLife.gBL.pLife = () -> Boss.gBoss[0].life;
        return true;
    }

    public static void PutBossLife() {
        if (!BossLife.gBL.flag) {
            return;
        }
        if (BossLife.gBL.pLife.get() < 1) {
            BossLife.gBL.flag = false;
            return;
        }
        BossLife.rcLife.right = BossLife.gBL.pLife.get() * 198 / BossLife.gBL.max;
        if (BossLife.gBL.br > BossLife.gBL.pLife.get()) {
            if (++BossLife.gBL.count > 30) {
                --BossLife.gBL.br;
            }
        } else {
            BossLife.gBL.count = 0;
        }
        BossLife.rcBr.right = BossLife.gBL.br * 198 / BossLife.gBL.max;
        Draw.PutBitmap3(Draw.grcGame, 32, 220, rcBox1, 26);
        Draw.PutBitmap3(Draw.grcGame, 32, 228, rcBox2, 26);
        Draw.PutBitmap3(Draw.grcGame, 72, 224, rcBr, 26);
        Draw.PutBitmap3(Draw.grcGame, 72, 224, rcLife, 26);
        Draw.PutBitmap3(Draw.grcGame, 40, 224, rcText, 26);
    }

    public static class BOSSLIFE {
        boolean flag;
        IntSupplier pLife;
        int max;
        int br;
        int count;
    }
}
