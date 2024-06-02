/*
 * Decompiled with CFR 0.152.
 */
package jp.studiopixel.doukutsu;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.SourceDataLine;
import jp.studiopixel.doukutsu.Organya;
import jp.studiopixel.doukutsu.PixTone;

public class Sound {
    public static final int SOUND_MODE_PLAY_LOOP = -1;
    public static final int SOUND_MODE_STOP = 0;
    public static final int SOUND_MODE_PLAY = 1;
    public static AtomicBoolean bRunSound = new AtomicBoolean(true);
    public static AudioBuffer[] audioBuffers = new AudioBuffer[160];
    public static AudioBuffer[] orgBuffers = new AudioBuffer[128];
    private static long organya_callback_timer = 0L;
    public static long organya_callback_timer_master = 0L;

    public static AudioBuffer getOrgBuffer(int track, int j, int k) {
        return orgBuffers[track * 8 * 2 + j * 2 + k];
    }

    public static void setOrgBuffer(int track, int j, int k, AudioBuffer buffer) {
        Sound.orgBuffers[track * 8 * 2 + j * 2 + k] = buffer;
    }

    private static void soundThread() {
        try {
            AudioFormat format = new AudioFormat(44100.0f, 16, 2, true, false);
            DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);
            SourceDataLine line = (SourceDataLine)AudioSystem.getLine(info);
            byte[] buffer = new byte[4096];
            ByteBuffer immBuffer = ByteBuffer.allocate(64);
            immBuffer.order(ByteOrder.LITTLE_ENDIAN);
            ShortBuffer samples = immBuffer.asShortBuffer();
            if (buffer.length % immBuffer.capacity() != 0) {
                throw new RuntimeException("Buffer size is not a multiple of immBuffer size");
            }
            line.open(format, buffer.length);
            line.start();
            while (bRunSound.get()) {
                for (int i = 0; i < buffer.length; i += immBuffer.capacity()) {
                    if (organya_callback_timer_master != 0L) {
                        if (organya_callback_timer <= 0L) {
                            organya_callback_timer = organya_callback_timer_master;
                            if (Organya.org_data != null) {
                                Organya.org_data.PlayData();
                            }
                        } else {
                            organya_callback_timer -= (long)immBuffer.capacity();
                        }
                    }
                    Arrays.fill(immBuffer.array(), (byte)0);
                    for (AudioBuffer ab : audioBuffers) {
                        if (ab == null) continue;
                        ab.renderTo(samples);
                    }
                    for (AudioBuffer ab : orgBuffers) {
                        if (ab == null) continue;
                        ab.renderTo(samples);
                    }
                    System.arraycopy(immBuffer.array(), 0, buffer, i, immBuffer.capacity());
                }
                line.write(buffer, 0, buffer.length);
            }
            line.drain();
            line.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean InitDirectSound() {
        Organya.StartOrganya();
        new Thread(Sound::soundThread, "Sound Thread").start();
        return true;
    }

    public static void EndDirectSound() {
    }

    public static boolean InitSoundObject(String resname, int no) {
        return true;
    }

    public static boolean LoadSoundObject(String file_name, int no) {
        return true;
    }

    public static void PlaySoundObject(int no, int mode) {
        if (audioBuffers[no] != null) {
            Sound.audioBuffers[no].mode = mode;
            Sound.audioBuffers[no].pos = 0.0f;
        }
    }

    public static void ChangeSoundFrequency(int no, long rate) {
        if (audioBuffers[no] != null) {
            audioBuffers[no].setFrequency((int)rate);
        }
    }

    public static void ChangeSoundVolume(int no, long volume) {
        if (audioBuffers[no] != null) {
            Sound.audioBuffers[no].volume = (float)volume / 300.0f;
        }
    }

    public static void ChangeSoundPan(int no, long pan) {
        if (audioBuffers[no] != null) {
            // empty if block
        }
    }

    public static int MakePixToneObject(PixTone.PIXTONEPARAMETER[] ptpTable, int ptp, int ptp_num, int no) {
        int i;
        int sample_count = 0;
        for (i = 0; i < ptp_num; ++i) {
            PixTone.PIXTONEPARAMETER ptp_pointer = ptpTable[ptp + i];
            if (ptp_pointer.size <= sample_count) continue;
            sample_count = ptp_pointer.size;
        }
        byte[] pcm_buffer = new byte[sample_count];
        byte[] mixed_pcm_buffer = new byte[sample_count];
        for (i = 0; i < ptp_num; ++i) {
            PixTone.PIXTONEPARAMETER ptp_pointer = ptpTable[ptp + i];
            if (!PixTone.MakePixelWaveData(ptp_pointer, pcm_buffer)) {
                return -1;
            }
            for (int j = 0; j < ptp_pointer.size; ++j) {
                if (pcm_buffer[j] + mixed_pcm_buffer[j] > 127) {
                    mixed_pcm_buffer[j] = 127;
                    continue;
                }
                if (pcm_buffer[j] + mixed_pcm_buffer[j] < -128) {
                    mixed_pcm_buffer[j] = -128;
                    continue;
                }
                int n = j;
                mixed_pcm_buffer[n] = (byte)(mixed_pcm_buffer[n] + pcm_buffer[j]);
            }
        }
        Sound.audioBuffers[no] = AudioBuffer.fromSignedChar(mixed_pcm_buffer, 22050);
        return sample_count;
    }

    public static class AudioBuffer {
        public final short[] data;
        public final int sampleRate;
        public float advance;
        public float volume = 1.0f;
        public float panL = 1.0f;
        public float panR = 1.0f;
        public float pos = 0.0f;
        public int mode = 0;

        private AudioBuffer(int size, int sampleRate) {
            this.data = new short[size];
            this.sampleRate = sampleRate;
            this.advance = (float)sampleRate / 44100.0f;
        }

        public void setFrequency(int frequency) {
            this.advance = (float)frequency / 44100.0f;
        }

        public void renderTo(ShortBuffer buffer) {
            if (this.mode == 0) {
                return;
            }
            int size = buffer.remaining() / 2;
            for (int i = 0; i < size; ++i) {
                int ipos = (int)this.pos;
                float fract = this.pos - (float)ipos;
                short s1 = this.data[ipos];
                short s2 = this.data[Math.min(ipos + 1, this.data.length - 1)];
                float fs = (float)s1 * (1.0f - fract) + (float)s2 * fract;
                int ssl = buffer.get(2 * i);
                int ssr = buffer.get(2 * i + 1);
                ssr += (int)(fs * this.volume * this.panR);
                if ((ssl += (int)(fs * this.volume * this.panL)) > Short.MAX_VALUE) {
                    ssl = Short.MAX_VALUE;
                } else if (ssl < Short.MIN_VALUE) {
                    ssl = Short.MIN_VALUE;
                }
                if (ssr > Short.MAX_VALUE) {
                    ssr = Short.MAX_VALUE;
                } else if (ssr < Short.MIN_VALUE) {
                    ssr = Short.MIN_VALUE;
                }
                buffer.put(2 * i, (short)ssl);
                buffer.put(2 * i + 1, (short)ssr);
                if (this.mode == -1) {
                    this.pos = (this.pos + this.advance) % (float)this.data.length;
                    continue;
                }
                this.pos += this.advance;
                if (!(this.pos >= (float)this.data.length)) continue;
                this.pos = 0.0f;
                this.mode = 0;
                return;
            }
        }

        public static AudioBuffer fromShortArray(short[] data, int sampleRate) {
            AudioBuffer buffer = new AudioBuffer(data.length, sampleRate);
            System.arraycopy(data, 0, buffer.data, 0, data.length);
            return buffer;
        }

        public static AudioBuffer fromSignedChar(byte[] data, int sampleRate) {
            AudioBuffer buffer = new AudioBuffer(data.length, sampleRate);
            for (int i = 0; i < data.length; ++i) {
                buffer.data[i] = (short)(data[i] * 256);
            }
            return buffer;
        }
    }
}
