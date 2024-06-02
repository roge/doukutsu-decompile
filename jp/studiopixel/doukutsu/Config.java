/*
 * Decompiled with CFR 0.152.
 */
package jp.studiopixel.doukutsu;

import java.io.DataInputStream;
import java.io.File;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.util.Arrays;

public class Config {
    private static final String gConfigName = "Config.dat";
    private static final byte[] gProof = new byte[]{68, 79, 85, 75, 85, 84, 83, 85, 50, 48, 48, 52, 49, 50, 48, 54};
    public static final CONFIGDATA gConfig = new CONFIGDATA();

    public static boolean LoadConfigData(CONFIGDATA conf) {
        conf.clear();
        try {
            File fp = new File(gConfigName);
            if (!fp.exists()) {
                return false;
            }
            ByteBuffer buf = ByteBuffer.allocate((int)fp.length());
            DataInputStream dis = new DataInputStream(Files.newInputStream(fp.toPath(), new OpenOption[0]));
            dis.readFully(buf.array());
            dis.close();
            buf.order(ByteOrder.LITTLE_ENDIAN);
            ((Buffer)buf).position(0);
            buf.get(conf.proof);
            byte[] font_name = new byte[64];
            buf.get(font_name);
            int len = 0;
            for (byte b : font_name) {
                if (b == 0) break;
                ++len;
            }
            conf.font_name = new String(font_name, 0, len);
            conf.move_button_mode = buf.getInt();
            conf.attack_button_mode = buf.getInt();
            conf.ok_button_mode = buf.getInt();
            conf.display_mode = buf.getInt();
            conf.bJoystick = buf.get() != 0;
            for (int i = 0; i < conf.joystick_button.length; ++i) {
                conf.joystick_button[i] = buf.getInt();
            }
            byte[] subproof = new byte[gProof.length];
            System.arraycopy(conf.proof, 0, subproof, 0, gProof.length);
            if (!Arrays.equals(subproof, gProof)) {
                conf.clear();
                return false;
            }
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void DefaultConfigData(CONFIGDATA conf) {
        conf.clear();
        conf.display_mode = 1;
        conf.bJoystick = true;
        conf.joystick_button[0] = 2;
        conf.joystick_button[1] = 1;
        conf.joystick_button[2] = 5;
        conf.joystick_button[3] = 6;
        conf.joystick_button[4] = 3;
        conf.joystick_button[5] = 4;
        conf.joystick_button[6] = 6;
        conf.joystick_button[7] = 3;
    }

    public static class CONFIGDATA {
        byte[] proof = new byte[32];
        String font_name;
        int move_button_mode;
        int attack_button_mode;
        int ok_button_mode;
        int display_mode;
        boolean bJoystick;
        final int[] joystick_button = new int[8];

        public void clear() {
            Arrays.fill(this.proof, (byte)0);
            this.font_name = null;
            this.move_button_mode = 0;
            this.attack_button_mode = 0;
            this.ok_button_mode = 0;
            this.display_mode = 0;
            this.bJoystick = false;
            Arrays.fill(this.joystick_button, 0);
        }
    }
}
