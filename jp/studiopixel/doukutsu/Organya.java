/*
 * Decompiled with CFR 0.152.
 */
package jp.studiopixel.doukutsu;

import java.io.IOException;
import java.util.Arrays;
import jp.studiopixel.doukutsu.DataLoader;
import jp.studiopixel.doukutsu.Sound;

public class Organya {
    public static final int SETALL = -1;
    public static final int SETWAIT = 1;
    public static final int SETGRID = 2;
    public static final int SETALLOC = 4;
    public static final int SETREPEAT = 8;
    public static final int SETFREQ = 16;
    public static final int SETWAVE = 32;
    public static final int SETPIPI = 64;
    private static boolean[] g_mute = new boolean[16];
    private static short[] pan_tbl = new short[]{0, 43, 86, 129, 172, 215, 256, 297, 340, 383, 426, 469, 512};
    private static char[] old_key = new char[]{'\u00ff', '\u00ff', '\u00ff', '\u00ff', '\u00ff', '\u00ff', '\u00ff', '\u00ff', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000'};
    private static char[] key_on = new char[16];
    private static char[] key_twin = new char[16];
    private static int PlayPos = 0;
    private static NOTELIST[] np = new NOTELIST[16];
    private static int[] now_leng = new int[8];
    private static int Volume = 100;
    private static int[] TrackVol = new int[16];
    private static boolean bFadeout = false;
    private static final short[] freq_tbl = new short[]{262, 277, 294, 311, 330, 349, 370, 392, 415, 440, 466, 494};
    private static final OCTWAVE[] oct_wave = new OCTWAVE[]{new OCTWAVE(256, 1, 4), new OCTWAVE(256, 2, 8), new OCTWAVE(128, 4, 12), new OCTWAVE(128, 8, 16), new OCTWAVE(64, 16, 20), new OCTWAVE(32, 32, 24), new OCTWAVE(16, 64, 28), new OCTWAVE(8, 128, 32)};
    private static byte[][] wave_data = new byte[100][256];
    public static OrgData org_data = new OrgData();

    private static void ChangeOrganFrequency(char key, byte track, int a) {
        for (int j = 0; j < 8; ++j) {
            for (int i = 0; i < 2; ++i) {
                Sound.getOrgBuffer(track, j, i).setFrequency(Organya.oct_wave[j].wave_size * freq_tbl[key] * Organya.oct_wave[j].oct_par / 8 + (a - 1000));
            }
        }
    }

    private static float MillibelToScale(int vol) {
        vol = Math.max(-10000, Math.min(0, vol));
        return (float)Math.pow(10.0, (double)vol / 2000.0);
    }

    public static void ChangeOrganPan(char key, char pan, byte track) {
        if (old_key[track] != '\u00ff') {
            int panv = (pan_tbl[pan] - 256) * 10;
            float panL = Organya.MillibelToScale(-panv);
            float panR = Organya.MillibelToScale(panv);
            Sound.AudioBuffer buffer = Sound.getOrgBuffer(track, old_key[track] / 12, key_twin[track]);
            buffer.panL = panL;
            buffer.panR = panR;
        }
    }

    public static void ChangeOrganVolume(char key, int volume, byte track) {
        int vol = (volume - 255) * 8;
        float fvolume = Organya.MillibelToScale(vol);
        if (old_key[track] != '\u00ff') {
            Sound.getOrgBuffer((int)track, (int)(Organya.old_key[track] / 12), (int)Organya.key_twin[track]).volume = fvolume;
        }
    }

    public static void PlayOrganObject(char key, int mode, byte track, int freq) {
        Sound.AudioBuffer buffer = Sound.getOrgBuffer(track, key / 12, key_twin[track]);
        if (buffer == null) {
            return;
        }
        switch (mode) {
            case 0: {
                if (old_key[track] == '\u00ff') break;
                Sound.AudioBuffer oldBuffer = Sound.getOrgBuffer(track, old_key[track] / 12, key_twin[track]);
                oldBuffer.mode = 0;
                oldBuffer.pos = 0.0f;
                break;
            }
            case 1: {
                break;
            }
            case 2: {
                if (old_key[track] == '\u00ff') break;
                Sound.AudioBuffer oldBuffer = Sound.getOrgBuffer(track, old_key[track] / 12, key_twin[track]);
                oldBuffer.mode = 1;
                Organya.old_key[track] = 255;
                break;
            }
            case -1: {
                if (old_key[track] == '\u00ff') {
                    Organya.ChangeOrganFrequency((char)(key % 12), track, freq);
                    Sound.AudioBuffer oldBuffer = Sound.getOrgBuffer(track, key / 12, key_twin[track]);
                    oldBuffer.mode = -1;
                    Organya.old_key[track] = key;
                    Organya.key_on[track] = '\u0001';
                    break;
                }
                if (key_on[track] == '\u0001' && old_key[track] == key) {
                    Sound.AudioBuffer oldBuffer = Sound.getOrgBuffer(track, old_key[track] / 12, key_twin[track]);
                    oldBuffer.mode = 1;
                    byte by = track;
                    key_twin[by] = (char)(key_twin[by] + '\u0001');
                    if (key_twin[track] > '\u0001') {
                        Organya.key_twin[track] = '\u0000';
                    }
                    oldBuffer = Sound.getOrgBuffer(track, key / 12, key_twin[track]);
                    oldBuffer.mode = -1;
                    break;
                }
                Sound.AudioBuffer oldBuffer = Sound.getOrgBuffer(track, old_key[track] / 12, key_twin[track]);
                oldBuffer.mode = 1;
                byte by = track;
                key_twin[by] = (char)(key_twin[by] + '\u0001');
                if (key_twin[track] > '\u0001') {
                    Organya.key_twin[track] = '\u0000';
                }
                Organya.ChangeOrganFrequency((char)(key % 12), track, freq);
                oldBuffer = Sound.getOrgBuffer(track, key / 12, key_twin[track]);
                oldBuffer.mode = -1;
                Organya.old_key[track] = key;
            }
        }
    }

    public static void ChangeDramFrequency(char key, byte track) {
        Sound.audioBuffers[150 + track].setFrequency(key * 800 + 100);
    }

    public static void ChangeDramPan(char pan, byte track) {
    }

    public static void ChangeDramVolume(int volume, byte track) {
        float fvolume;
        int vol = (volume - 255) * 8;
        vol = Math.max(-10000, Math.min(0, vol));
        Sound.audioBuffers[150 + track].volume = fvolume = (float)Math.pow(10.0, (double)vol / 2000.0);
    }

    public static void PlayDramObject(char key, int mode, byte track) {
        Sound.AudioBuffer buffer = Sound.audioBuffers[150 + track];
        if (buffer == null) {
            return;
        }
        switch (mode) {
            case 0: {
                buffer.mode = 0;
                buffer.pos = 0.0f;
                break;
            }
            case 1: {
                buffer.mode = 0;
                buffer.pos = 0.0f;
                Organya.ChangeDramFrequency(key, track);
                buffer.mode = 1;
                break;
            }
            case 2: {
                break;
            }
        }
    }

    public static boolean MakeSoundObject8(byte[] wavep, byte track, byte pipi) {
        for (int j = 0; j < 8; ++j) {
            for (int k = 0; k < 2; ++k) {
                int wave_size = Organya.oct_wave[j].wave_size;
                int data_size = pipi != 0 ? wave_size * Organya.oct_wave[j].oct_size : wave_size;
                byte[] wp = new byte[data_size];
                int wav_tp = 0;
                int wp_sub = 0;
                for (int i = 0; i < data_size; ++i) {
                    byte work = wavep[wav_tp];
                    wp[wp_sub] = work;
                    if ((wav_tp += 256 / wave_size) > 255) {
                        wav_tp -= 256;
                    }
                    ++wp_sub;
                }
                Sound.AudioBuffer buf = Sound.AudioBuffer.fromSignedChar(wp, 22050);
                Sound.setOrgBuffer(track, j, k, buf);
            }
        }
        return true;
    }

    public static void ReleaseOrganyaObject(byte track) {
        for (int i = 0; i < 8; ++i) {
            Sound.setOrgBuffer(track, i, 0, null);
            Sound.setOrgBuffer(track, i, 1, null);
        }
    }

    public static boolean InitWaveData100() {
        try {
            DataLoader.DataFile f = DataLoader.load("/WAVE/Wave.dat");
            for (int i = 0; i < 100; ++i) {
                f.readFully(wave_data[i]);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static boolean MakeOrganyaWave(byte track, byte wave_no, byte pipi) {
        if (wave_no >= 100) {
            return false;
        }
        Organya.ReleaseOrganyaObject(track);
        Organya.MakeSoundObject8(wave_data[wave_no], track, pipi);
        return true;
    }

    public static boolean StartOrganya() {
        if (!Organya.InitWaveData100()) {
            return false;
        }
        org_data.InitOrgData();
        return true;
    }

    public static boolean LoadOrganya(String filename) {
        if (!org_data.InitMusicData(filename)) {
            return false;
        }
        Volume = 100;
        bFadeout = false;
        return true;
    }

    public static void SetOrganyaPosition(int x) {
        org_data.SetPlayPointer(x);
        Volume = 100;
        bFadeout = false;
    }

    public static int GetOrganyaPosition() {
        return PlayPos;
    }

    public static void PlayOrganyaMusic() {
        Sound.organya_callback_timer_master = (long)Organya.org_data.info.wait * 44100L * 4L / 1000L;
    }

    public static boolean ChangeOrganyaVolume(int volume) {
        if (volume < 0 || volume > 100) {
            return false;
        }
        Volume = volume;
        return true;
    }

    public static void StopOrganyaMusic() {
        Sound.organya_callback_timer_master = 0L;
        for (int i = 0; i < 8; ++i) {
            Organya.PlayOrganObject('\u0000', 2, (byte)i, 0);
        }
        Arrays.fill(old_key, '\u00ff');
        Arrays.fill(key_on, '\u0000');
        Arrays.fill(key_twin, '\u0000');
        try {
            Thread.sleep(100L);
        }
        catch (InterruptedException interruptedException) {
            // empty catch block
        }
    }

    public static void SetOrganyaFadeout() {
        bFadeout = true;
    }

    public static class NOTELIST {
        NOTELIST from;
        NOTELIST to;
        int x;
        char length;
        char y;
        char volume;
        char pan;
    }

    private static class OCTWAVE {
        short wave_size;
        short oct_par;
        short oct_size;

        public OCTWAVE(int wave_size, int oct_par, int oct_size) {
            this.wave_size = (short)wave_size;
            this.oct_par = (short)oct_par;
            this.oct_size = (short)oct_size;
        }
    }

    public static class OrgData {
        public MUSICINFO info = new MUSICINFO();
        byte track;
        boolean[] mute = new boolean[16];
        char def_pan;
        char def_volume;
        private static final byte[] pass = new byte[]{79, 114, 103, 45, 48, 49};
        private static final byte[] pass2 = new byte[]{79, 114, 103, 45, 48, 50};

        public void InitOrgData() {
            this.track = 0;
            this.info.alloc_note = (char)4096;
            this.info.dot = (char)4;
            this.info.line = (char)4;
            this.info.wait = (char)128;
            this.info.repeat_x = this.info.dot * this.info.line * 0;
            this.info.end_x = this.info.dot * this.info.line * 255;
            for (int i = 0; i < 16; ++i) {
                this.info.tdata[i].freq = (char)1000;
                this.info.tdata[i].wave_no = '\u0000';
                this.info.tdata[i].pipi = 0;
            }
            this.NoteAlloc(this.info.alloc_note);
            this.SetMusicInfo(this.info, -1);
            this.def_pan = (char)6;
            this.def_volume = (char)200;
        }

        public void GetMusicInfo(MUSICINFO mi) {
            mi.dot = this.info.dot;
            mi.line = this.info.line;
            mi.alloc_note = this.info.alloc_note;
            mi.wait = this.info.wait;
            mi.repeat_x = this.info.repeat_x;
            mi.end_x = this.info.end_x;
            for (int i = 0; i < 16; ++i) {
                mi.tdata[i].freq = this.info.tdata[i].freq;
                mi.tdata[i].wave_no = this.info.tdata[i].wave_no;
                mi.tdata[i].pipi = this.info.tdata[i].pipi;
            }
        }

        public boolean SetMusicInfo(MUSICINFO mi, int flag) {
            int i;
            if ((flag & 2) != 0) {
                this.info.dot = mi.dot;
                this.info.line = mi.line;
            }
            if ((flag & 1) != 0) {
                this.info.wait = mi.wait;
            }
            if ((flag & 8) != 0) {
                this.info.repeat_x = mi.repeat_x;
                this.info.end_x = mi.end_x;
            }
            if ((flag & 0x10) != 0) {
                for (i = 0; i < 8; ++i) {
                    this.info.tdata[i].freq = mi.tdata[i].freq;
                    this.info.tdata[i].pipi = this.info.tdata[i].pipi;
                }
            }
            if ((flag & 0x20) != 0) {
                for (i = 0; i < 16; ++i) {
                    this.info.tdata[i].wave_no = mi.tdata[i].wave_no;
                }
            }
            if ((flag & 0x40) != 0) {
                for (i = 0; i < 16; ++i) {
                    this.info.tdata[i].pipi = mi.tdata[i].pipi;
                }
            }
            return true;
        }

        public boolean NoteAlloc(int alloc) {
            int j;
            for (j = 0; j < 16; ++j) {
                int i;
                this.info.tdata[j].wave_no = '\u0000';
                this.info.tdata[j].note_list = null;
                this.info.tdata[j].note_p = new NOTELIST[alloc];
                for (i = 0; i < alloc; ++i) {
                    this.info.tdata[j].note_p[i] = new NOTELIST();
                }
                if (this.info.tdata[j].note_p == null) {
                    for (i = 0; i < 16; ++i) {
                        if (this.info.tdata[i].note_p == null) continue;
                        this.info.tdata[i].note_p = null;
                    }
                    return false;
                }
                for (i = 0; i < alloc; ++i) {
                    this.info.tdata[j].note_p[i].from = null;
                    this.info.tdata[j].note_p[i].to = null;
                    this.info.tdata[j].note_p[i].length = '\u0000';
                    this.info.tdata[j].note_p[i].pan = (char)255;
                    this.info.tdata[j].note_p[i].volume = (char)255;
                    this.info.tdata[j].note_p[i].y = (char)255;
                }
            }
            for (j = 0; j < 8; ++j) {
                Organya.MakeOrganyaWave((byte)j, (byte)this.info.tdata[j].wave_no, this.info.tdata[j].pipi);
            }
            this.track = 0;
            return false;
        }

        public void ReleaseNote() {
            for (int i = 0; i < 16; ++i) {
                this.info.tdata[i].note_p = null;
            }
        }

        public void PlayData() {
            int i;
            if (bFadeout && Volume != 0) {
                Volume -= 2;
            }
            if (Volume < 0) {
                Volume = 0;
            }
            for (i = 0; i < 8; ++i) {
                if (np[i] != null && PlayPos == np[i].x) {
                    if (!g_mute[i] && np[i].y != '\u00ff') {
                        Organya.PlayOrganObject(np[i].y, -1, (byte)i, this.info.tdata[i].freq);
                        now_leng[i] = np[i].length;
                    }
                    if (np[i].pan != '\u00ff') {
                        Organya.ChangeOrganPan(np[i].y, np[i].pan, (byte)i);
                    }
                    if (np[i].volume != '\u00ff') {
                        TrackVol[i] = np[i].volume;
                    }
                    np[i] = np[i].to;
                }
                if (now_leng[i] == 0) {
                    Organya.PlayOrganObject('\u0000', 2, (byte)i, this.info.tdata[i].freq);
                }
                if (now_leng[i] > 0) {
                    int[] nArray = now_leng;
                    int n = i;
                    nArray[n] = nArray[n] - 1;
                }
                if (np[i] == null) continue;
                Organya.ChangeOrganVolume(np[i].y, TrackVol[i] * Volume / 127, (byte)i);
            }
            for (i = 8; i < 16; ++i) {
                if (np[i] != null && PlayPos == np[i].x) {
                    if (np[i].y != '\u00ff' && !g_mute[i]) {
                        Organya.PlayDramObject(np[i].y, 1, (byte)(i - 8));
                    }
                    if (np[i].pan != '\u00ff') {
                        Organya.ChangeDramPan(np[i].pan, (byte)(i - 8));
                    }
                    if (np[i].volume != '\u00ff') {
                        TrackVol[i] = np[i].volume;
                    }
                    np[i] = np[i].to;
                }
                if (np[i] == null) continue;
                Organya.ChangeDramVolume(TrackVol[i] * Volume / 127, (byte)(i - 8));
            }
            PlayPos++;
            if (PlayPos >= this.info.end_x) {
                PlayPos = this.info.repeat_x;
                this.SetPlayPointer(PlayPos);
            }
        }

        public void SetPlayPointer(int x) {
            for (int i = 0; i < 16; ++i) {
                np[i] = this.info.tdata[i].note_list;
                while (np[i] != null && np[i].x < x) {
                    np[i] = np[i].to;
                }
            }
            PlayPos = x;
        }

        public boolean InitMusicData(String path) {
            try {
                int j;
                int i;
                DataLoader.DataFile f = DataLoader.load("/ORG/" + path);
                byte[] pass_check = new byte[6];
                int ver = 0;
                char[] note_num = new char[16];
                f.readFully(pass_check);
                if (Arrays.equals(pass_check, pass)) {
                    ver = 1;
                } else if (Arrays.equals(pass_check, pass2)) {
                    ver = 2;
                }
                if (ver == 0) {
                    return false;
                }
                this.info.wait = f.readChar();
                this.info.line = (char)f.readUnsignedByte();
                this.info.dot = (char)f.readUnsignedByte();
                this.info.repeat_x = f.readInt();
                this.info.end_x = f.readInt();
                for (i = 0; i < 16; ++i) {
                    this.info.tdata[i].freq = f.readChar();
                    this.info.tdata[i].wave_no = (char)f.readUnsignedByte();
                    this.info.tdata[i].pipi = ver == 1 ? (byte)0 : f.readByte();
                    note_num[i] = f.readChar();
                }
                for (j = 0; j < 16; ++j) {
                    if (note_num[j] == '\u0000') {
                        this.info.tdata[j].note_list = null;
                        continue;
                    }
                    int np = 0;
                    this.info.tdata[j].note_list = this.info.tdata[j].note_p[0];
                    NOTELIST npp = this.info.tdata[j].note_p[np];
                    npp.from = null;
                    npp.to = this.info.tdata[j].note_p[np + 1];
                    ++np;
                    for (i = 1; i < note_num[j]; ++i) {
                        npp = this.info.tdata[j].note_p[np];
                        npp.from = this.info.tdata[j].note_p[np - 1];
                        npp.to = this.info.tdata[j].note_p[np + 1];
                        ++np;
                    }
                    npp = this.info.tdata[j].note_p[--np];
                    npp.to = null;
                    np = 0;
                    for (i = 0; i < note_num[j]; ++i) {
                        npp = this.info.tdata[j].note_p[np];
                        npp.x = f.readInt();
                        ++np;
                    }
                    np = 0;
                    for (i = 0; i < note_num[j]; ++i) {
                        npp = this.info.tdata[j].note_p[np];
                        npp.y = (char)f.readUnsignedByte();
                        ++np;
                    }
                    np = 0;
                    for (i = 0; i < note_num[j]; ++i) {
                        npp = this.info.tdata[j].note_p[np];
                        npp.length = (char)f.readUnsignedByte();
                        ++np;
                    }
                    np = 0;
                    for (i = 0; i < note_num[j]; ++i) {
                        npp = this.info.tdata[j].note_p[np];
                        npp.volume = (char)f.readUnsignedByte();
                        ++np;
                    }
                    np = 0;
                    for (i = 0; i < note_num[j]; ++i) {
                        npp = this.info.tdata[j].note_p[np];
                        npp.pan = (char)f.readUnsignedByte();
                        ++np;
                    }
                }
                for (j = 0; j < 8; ++j) {
                    Organya.MakeOrganyaWave((byte)j, (byte)this.info.tdata[j].wave_no, this.info.tdata[j].pipi);
                }
                this.SetPlayPointer(0);
            }
            catch (IOException e) {
                e.printStackTrace();
                return false;
            }
            return true;
        }
    }

    public static class MUSICINFO {
        char wait;
        char line;
        char dot;
        char alloc_note;
        int repeat_x;
        int end_x;
        TRACKDATA[] tdata = new TRACKDATA[16];

        public MUSICINFO() {
            for (int i = 0; i < 16; ++i) {
                this.tdata[i] = new TRACKDATA();
            }
        }
    }

    public static class TRACKDATA {
        char freq;
        char wave_no;
        byte pipi;
        NOTELIST[] note_p;
        NOTELIST note_list;
    }
}
