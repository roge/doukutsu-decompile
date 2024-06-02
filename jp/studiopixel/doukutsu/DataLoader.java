/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package jp.studiopixel.doukutsu;

import java.io.ByteArrayOutputStream;
import java.io.DataInput;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import org.jetbrains.annotations.NotNull;

public class DataLoader {
    public static final int SEEK_SET = 0;
    public static final int SEEK_CUR = 1;
    public static final int SEEK_END = 2;

    public static InputStream stream(String path) {
        Path p;
        File f;
        InputStream stream = DataLoader.class.getResourceAsStream(path);
        if (stream == null && (f = (p = FileSystems.getDefault().getPath(System.getProperty("user.dir"), "data", path)).toFile()).exists()) {
            try {
                stream = new FileInputStream(f);
            }
            catch (FileNotFoundException e) {
                return null;
            }
        }
        return stream;
    }

    public static DataFile load(String path) throws IOException {
        InputStream in = DataLoader.stream(path);
        if (in == null) {
            throw new FileNotFoundException("Could not find file " + path);
        }
        return new DataFile(in);
    }

    public static class DataFile
    implements DataInput {
        private byte[] data;
        private long pos;

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public DataFile(InputStream is) {
            try (ByteArrayOutputStream buffer = new ByteArrayOutputStream();){
                int nRead;
                byte[] data = new byte[16384];
                while ((nRead = is.read(data, 0, data.length)) != -1) {
                    buffer.write(data, 0, nRead);
                }
                buffer.flush();
                this.data = buffer.toByteArray();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            finally {
                try {
                    is.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        public void seek(long pos) {
            this.pos = pos;
        }

        public void cSeek(int origin, int offset) {
            switch (origin) {
                case 0: {
                    this.pos = offset;
                    break;
                }
                case 1: {
                    this.pos += (long)offset;
                    break;
                }
                case 2: {
                    this.pos = this.data.length + offset;
                }
            }
        }

        public long cTell() {
            return this.pos;
        }

        @Override
        public void readFully(@NotNull byte[] b) throws IOException {
            System.arraycopy(this.data, (int)this.pos, b, 0, b.length);
            this.pos += (long)b.length;
        }

        @Override
        public void readFully(@NotNull byte[] b, int off, int len) throws IOException {
            System.arraycopy(this.data, (int)this.pos, b, off, len);
            this.pos += (long)len;
        }

        public byte[] readAllBytes() {
            byte[] b = new byte[this.data.length - (int)this.pos];
            System.arraycopy(this.data, (int)this.pos, b, 0, b.length);
            this.pos += (long)b.length;
            return b;
        }

        @Override
        public int skipBytes(int n) throws IOException {
            if (n < 0) {
                throw new IllegalArgumentException("n < 0");
            }
            if (this.pos + (long)n > (long)this.data.length) {
                throw new EOFException();
            }
            this.pos += (long)n;
            return n;
        }

        @Override
        public boolean readBoolean() throws IOException {
            return this.readByte() != 0;
        }

        @Override
        public byte readByte() throws IOException {
            return this.data[(int)this.pos++];
        }

        @Override
        public int readUnsignedByte() throws IOException {
            return this.readByte() & 0xFF;
        }

        @Override
        public short readShort() throws IOException {
            return (short)(this.readByte() & 0xFF | (this.readByte() & 0xFF) << 8);
        }

        @Override
        public int readUnsignedShort() throws IOException {
            return this.readShort() & 0xFFFF;
        }

        @Override
        public char readChar() throws IOException {
            return (char)this.readUnsignedShort();
        }

        @Override
        public int readInt() throws IOException {
            return this.readByte() & 0xFF | (this.readByte() & 0xFF) << 8 | (this.readByte() & 0xFF) << 16 | (this.readByte() & 0xFF) << 24;
        }

        @Override
        public long readLong() throws IOException {
            return (long)this.readByte() & 0xFFL | ((long)this.readByte() & 0xFFL) << 8 | ((long)this.readByte() & 0xFFL) << 16 | ((long)this.readByte() & 0xFFL) << 24 | ((long)this.readByte() & 0xFFL) << 32 | ((long)this.readByte() & 0xFFL) << 40 | ((long)this.readByte() & 0xFFL) << 48 | ((long)this.readByte() & 0xFFL) << 56;
        }

        @Override
        public float readFloat() throws IOException {
            return Float.intBitsToFloat(this.readInt());
        }

        @Override
        public double readDouble() throws IOException {
            return Double.longBitsToDouble(this.readLong());
        }

        @Override
        public String readLine() throws IOException {
            throw new UnsupportedOperationException();
        }

        @Override
        @NotNull
        public String readUTF() throws IOException {
            throw new UnsupportedOperationException();
        }
    }
}
