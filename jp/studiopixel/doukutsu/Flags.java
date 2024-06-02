/*
 * Decompiled with CFR 0.152.
 */
package jp.studiopixel.doukutsu;

import java.util.Arrays;

public class Flags {
    public static byte[] gFlagNPC = new byte[1000];
    public static byte[] gSkipFlag = new byte[8];

    public static void InitFlags() {
        Arrays.fill(gFlagNPC, (byte)0);
    }

    public static void InitSkipFlags() {
        Arrays.fill(gSkipFlag, (byte)0);
    }

    public static void SetNPCFlag(int no) {
        int n = no / 8;
        gFlagNPC[n] = (byte)(gFlagNPC[n] | 1 << no % 8);
    }

    public static void CutNPCFlag(int no) {
        int n = no / 8;
        gFlagNPC[n] = (byte)(gFlagNPC[n] & ~(1 << no % 8));
    }

    public static boolean GetNPCFlag(int no) {
        return (gFlagNPC[no / 8] & 1 << no % 8) != 0;
    }

    public static void SetSkipFlag(int no) {
        int n = no / 8;
        gSkipFlag[n] = (byte)(gSkipFlag[n] | 1 << no % 8);
    }

    public static void CutSkipFlag(int no) {
        int n = no / 8;
        gSkipFlag[n] = (byte)(gSkipFlag[n] & ~(1 << no % 8));
    }

    public static boolean GetSkipFlag(int no) {
        return (gSkipFlag[no / 8] & 1 << no % 8) != 0;
    }
}
