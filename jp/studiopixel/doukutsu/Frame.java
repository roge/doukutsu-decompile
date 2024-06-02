/*
 * Decompiled with CFR 0.152.
 */
package jp.studiopixel.doukutsu;

import jp.studiopixel.doukutsu.Boss;
import jp.studiopixel.doukutsu.Game;
import jp.studiopixel.doukutsu.Map;
import jp.studiopixel.doukutsu.MyChar;
import jp.studiopixel.doukutsu.NpChar;

public class Frame {
    public static final FRAME gFrame = new FRAME();

    public static void MoveFrame3() {
        short map_w = Map.gMap.width;
        short map_l = Map.gMap.length;
        Frame.gFrame.x += (Frame.gFrame.tgt.getTargetX() - 81920 - Frame.gFrame.x) / Frame.gFrame.wait;
        Frame.gFrame.y += (Frame.gFrame.tgt.getTargetY() - 61440 - Frame.gFrame.y) / Frame.gFrame.wait;
        if (Frame.gFrame.x / 512 < 0) {
            Frame.gFrame.x = 0;
        }
        if (Frame.gFrame.y / 512 < 0) {
            Frame.gFrame.y = 0;
        }
        if (Frame.gFrame.x > ((map_w - 1) * 16 - 320) * 512) {
            Frame.gFrame.x = ((map_w - 1) * 16 - 320) * 512;
        }
        if (Frame.gFrame.y > ((map_l - 1) * 16 - 240) * 512) {
            Frame.gFrame.y = ((map_l - 1) * 16 - 240) * 512;
        }
        if (Frame.gFrame.quake2 != 0) {
            Frame.gFrame.x += Game.Random(-5, 5) * 512;
            Frame.gFrame.y += Game.Random(-3, 3) * 512;
            --Frame.gFrame.quake2;
        } else if (Frame.gFrame.quake != 0) {
            Frame.gFrame.x += Game.Random(-1, 1) * 512;
            Frame.gFrame.y += Game.Random(-1, 1) * 512;
            --Frame.gFrame.quake;
        }
    }

    public static void SetFramePosition(int fx, int fy) {
        Frame.gFrame.quake = 0;
        Frame.gFrame.quake2 = 0;
        short map_w = Map.gMap.width;
        short map_l = Map.gMap.length;
        Frame.gFrame.x = fx;
        Frame.gFrame.y = fy;
        if (Frame.gFrame.x / 512 < 0) {
            Frame.gFrame.x = 0;
        }
        if (Frame.gFrame.y / 512 < 0) {
            Frame.gFrame.y = 0;
        }
        if (Frame.gFrame.x > ((map_w - 1) * 16 - 320) * 512) {
            Frame.gFrame.x = ((map_w - 1) * 16 - 320) * 512;
        }
        if (Frame.gFrame.y > ((map_l - 1) * 16 - 240) * 512) {
            Frame.gFrame.y = ((map_l - 1) * 16 - 240) * 512;
        }
    }

    public static void SetFrameMyChar() {
        int mc_x = MyChar.gMC.x;
        int mc_y = MyChar.gMC.y;
        short map_w = Map.gMap.width;
        short map_l = Map.gMap.length;
        Frame.gFrame.x = mc_x - 81920;
        Frame.gFrame.y = mc_y - 61440;
        if (Frame.gFrame.x / 512 < 0) {
            Frame.gFrame.x = 0;
        }
        if (Frame.gFrame.y / 512 < 0) {
            Frame.gFrame.y = 0;
        }
        if (Frame.gFrame.x > ((map_w - 1) * 16 - 320) * 512) {
            Frame.gFrame.x = ((map_w - 1) * 16 - 320) * 512;
        }
        if (Frame.gFrame.y > ((map_l - 1) * 16 - 240) * 512) {
            Frame.gFrame.y = ((map_l - 1) * 16 - 240) * 512;
        }
    }

    public static void SetFrameTargetMyChar(int wait) {
        Frame.gFrame.tgt = new MyCharTargetAccessor();
        Frame.gFrame.wait = wait;
    }

    public static void SetFrameTargetNpChar(int event, int wait) {
        int i;
        for (i = 0; i < NpChar.gNPC.length && NpChar.gNPC[i].code_event != event; ++i) {
        }
        if (i == NpChar.gNPC.length) {
            return;
        }
        Frame.gFrame.tgt = new NpCharTargetAccessor(i);
        Frame.gFrame.wait = wait;
    }

    public static void SetFrameTargetBoss(int no, int wait) {
        Frame.gFrame.tgt = new BossTargetAccessor(no);
        Frame.gFrame.wait = wait;
    }

    public static void SetQuake(int time) {
        Frame.gFrame.quake = time;
    }

    public static void SetQuake2(int time) {
        Frame.gFrame.quake2 = time;
    }

    public static void ResetQuake() {
        Frame.gFrame.quake = 0;
        Frame.gFrame.quake2 = 0;
    }

    public static class FRAME {
        int x;
        int y;
        TargetAccessor tgt;
        int wait;
        int quake;
        int quake2;
    }

    public static interface TargetAccessor {
        public int getTargetX();

        public int getTargetY();
    }

    private static class MyCharTargetAccessor
    implements TargetAccessor {
        private MyCharTargetAccessor() {
        }

        @Override
        public int getTargetX() {
            return MyChar.gMC.tgt_x;
        }

        @Override
        public int getTargetY() {
            return MyChar.gMC.tgt_y;
        }
    }

    private static class NpCharTargetAccessor
    implements TargetAccessor {
        private final int npc_idx;

        public NpCharTargetAccessor(int npc_idx) {
            this.npc_idx = npc_idx;
        }

        @Override
        public int getTargetX() {
            return NpChar.gNPC[this.npc_idx].x;
        }

        @Override
        public int getTargetY() {
            return NpChar.gNPC[this.npc_idx].y;
        }
    }

    private static class BossTargetAccessor
    implements TargetAccessor {
        private final int npc_idx;

        public BossTargetAccessor(int npc_idx) {
            this.npc_idx = npc_idx;
        }

        @Override
        public int getTargetX() {
            return Boss.gBoss[this.npc_idx].x;
        }

        @Override
        public int getTargetY() {
            return Boss.gBoss[this.npc_idx].y;
        }
    }
}
