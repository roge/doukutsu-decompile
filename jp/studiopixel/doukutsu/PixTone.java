/*
 * Decompiled with CFR 0.152.
 */
package jp.studiopixel.doukutsu;

import jp.studiopixel.doukutsu.Game;

public class PixTone {
    private static byte[][] gWaveModelTable = new byte[6][256];
    private static boolean gWaveModelTableInitialized = false;

    public static void MakeWaveTables() {
        int i;
        for (i = 0; i < 256; ++i) {
            PixTone.gWaveModelTable[0][i] = (byte)(Math.sin((double)i * 6.283184 / 256.0) * 64.0);
        }
        int a = 0;
        for (i = 0; i < 64; ++i) {
            PixTone.gWaveModelTable[1][i] = (byte)(a * 64 / 64);
            ++a;
        }
        a = 0;
        while (i < 192) {
            PixTone.gWaveModelTable[1][i] = (byte)(64 - a * 64 / 64);
            ++a;
            ++i;
        }
        a = 0;
        while (i < 256) {
            PixTone.gWaveModelTable[1][i] = (byte)(a * 64 / 64 - 64);
            ++a;
            ++i;
        }
        for (i = 0; i < 256; ++i) {
            PixTone.gWaveModelTable[2][i] = (byte)(i / 2 - 64);
        }
        for (i = 0; i < 256; ++i) {
            PixTone.gWaveModelTable[3][i] = (byte)(64 - i / 2);
        }
        for (i = 0; i < 128; ++i) {
            PixTone.gWaveModelTable[4][i] = 64;
        }
        while (i < 256) {
            PixTone.gWaveModelTable[4][i] = -64;
            ++i;
        }
        Game.msvc_srand(0);
        for (i = 0; i < 256; ++i) {
            PixTone.gWaveModelTable[5][i] = (byte)((byte)(Game.msvc_rand() & 0xFF) / 2);
        }
    }

    public static boolean MakePixelWaveData(PIXTONEPARAMETER ptp, byte[] pData) {
        int i;
        byte[] envelopeTable = new byte[256];
        if (!gWaveModelTableInitialized) {
            PixTone.MakeWaveTables();
            gWaveModelTableInitialized = true;
        }
        double dEnvelope = ptp.initial;
        for (i = 0; i < ptp.pointAx; ++i) {
            envelopeTable[i] = (byte)dEnvelope;
            dEnvelope = ((double)ptp.pointAy - (double)ptp.initial) / (double)ptp.pointAx + dEnvelope;
        }
        dEnvelope = ptp.pointAy;
        while (i < ptp.pointBx) {
            envelopeTable[i] = (byte)dEnvelope;
            dEnvelope = ((double)ptp.pointBy - (double)ptp.pointAy) / (double)(ptp.pointBx - ptp.pointAx) + dEnvelope;
            ++i;
        }
        dEnvelope = ptp.pointBy;
        while (i < ptp.pointCx) {
            envelopeTable[i] = (byte)dEnvelope;
            dEnvelope = ((double)ptp.pointCy - (double)ptp.pointBy) / (double)(ptp.pointCx - ptp.pointBx) + dEnvelope;
            ++i;
        }
        dEnvelope = ptp.pointCy;
        while (i < 256) {
            envelopeTable[i] = (byte)dEnvelope;
            dEnvelope -= (double)ptp.pointCy / (double)(256 - ptp.pointCx);
            ++i;
        }
        double dPitch = ptp.oPitch.offset;
        double dMain = ptp.oMain.offset;
        double dVolume = ptp.oVolume.offset;
        double d1 = ptp.oMain.num == 0.0 ? 0.0 : 256.0 / ((double)ptp.size / ptp.oMain.num);
        double d2 = ptp.oPitch.num == 0.0 ? 0.0 : 256.0 / ((double)ptp.size / ptp.oPitch.num);
        double d3 = ptp.oVolume.num == 0.0 ? 0.0 : 256.0 / ((double)ptp.size / ptp.oVolume.num);
        for (i = 0; i < ptp.size; ++i) {
            int a = (int)dMain % 256;
            int b = (int)dPitch % 256;
            int c = (int)dVolume % 256;
            int d = (int)((double)(i * 256) / (double)ptp.size);
            int s = gWaveModelTable[ptp.oMain.model][a] * ptp.oMain.top / 64 * (gWaveModelTable[ptp.oVolume.model][c] * ptp.oVolume.top / 64 + 64) / 64 * envelopeTable[d] / 64;
            pData[i] = (byte)s;
            dMain = gWaveModelTable[ptp.oPitch.model][b] < 0 ? (dMain += d1 - d1 * 0.5 * (double)(-gWaveModelTable[ptp.oPitch.model][b]) * (double)ptp.oPitch.top / 64.0 / 64.0) : (dMain += d1 + d1 * 2.0 * (double)gWaveModelTable[ptp.oPitch.model][b] * (double)ptp.oPitch.top / 64.0 / 64.0);
            dPitch += d2;
            dVolume += d3;
        }
        return true;
    }

    public static class PIXTONEPARAMETER {
        int use = 0;
        int size = 0;
        PIXTONEPARAMETER2 oMain = new PIXTONEPARAMETER2();
        PIXTONEPARAMETER2 oPitch = new PIXTONEPARAMETER2();
        PIXTONEPARAMETER2 oVolume = new PIXTONEPARAMETER2();
        int initial = 0;
        int pointAx = 0;
        int pointAy = 0;
        int pointBx = 0;
        int pointBy = 0;
        int pointCx = 0;
        int pointCy = 0;

        public PIXTONEPARAMETER() {
        }

        public PIXTONEPARAMETER(int use, int size, PIXTONEPARAMETER2 oMain, PIXTONEPARAMETER2 oPitch, PIXTONEPARAMETER2 oVolume, int initial, int pointAx, int pointAy, int pointBx, int pointBy, int pointCx, int pointCy) {
            this.use = use;
            this.size = size;
            this.oMain = oMain;
            this.oPitch = oPitch;
            this.oVolume = oVolume;
            this.initial = initial;
            this.pointAx = pointAx;
            this.pointAy = pointAy;
            this.pointBx = pointBx;
            this.pointBy = pointBy;
            this.pointCx = pointCx;
            this.pointCy = pointCy;
        }
    }

    public static class PIXTONEPARAMETER2 {
        int model = 0;
        double num = 0.0;
        int top = 0;
        int offset = 0;

        public PIXTONEPARAMETER2() {
        }

        public PIXTONEPARAMETER2(int model, double num, int top, int offset) {
            this.model = model;
            this.num = num;
            this.top = top;
            this.offset = offset;
        }
    }
}
