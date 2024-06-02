/*
 * Decompiled with CFR 0.152.
 */
package jp.studiopixel.doukutsu;

public class KeyControl {
    public static int gKey = 0;
    public static int gKeyTrg = 0;
    public static int gKeyJump = 64;
    public static int gKeyShot = 32;
    public static int gKeyArms = 128;
    public static int gKeyArmsRev = 256;
    public static int gKeyItem = 4096;
    public static int gKeyMap = 16;
    public static int gKeyOk = 64;
    public static int gKeyCancel = 32;
    public static int gKeyLeft = 1;
    public static int gKeyUp = 4;
    public static int gKeyRight = 2;
    public static int gKeyDown = 8;
    private static int key_old = 0;

    public static void GetTrg() {
        gKeyTrg = gKey ^ key_old;
        gKeyTrg = gKey & gKeyTrg;
        key_old = gKey;
    }

    public static class KeyBind {
        public static final int KEY_LEFT = 1;
        public static final int KEY_RIGHT = 2;
        public static final int KEY_UP = 4;
        public static final int KEY_DOWN = 8;
        public static final int KEY_MAP = 16;
        public static final int KEY_X = 32;
        public static final int KEY_Z = 64;
        public static final int KEY_ARMS = 128;
        public static final int KEY_ARMSREV = 256;
        public static final int KEY_SHIFT = 512;
        public static final int KEY_F1 = 1024;
        public static final int KEY_F2 = 2048;
        public static final int KEY_ITEM = 4096;
        public static final int KEY_ESCAPE = 32768;
        public static final int KEY_ALT_LEFT = 65536;
        public static final int KEY_ALT_DOWN = 131072;
        public static final int KEY_ALT_RIGHT = 262144;
        public static final int KEY_ALT_UP = 0x180000;
        public static final int KEY_L = 524288;
        public static final int KEY_PLUS = 0x100000;
    }
}
