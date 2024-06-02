/*
 * Decompiled with CFR 0.152.
 */
package jp.studiopixel.doukutsu;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import javax.swing.JOptionPane;
import jp.studiopixel.doukutsu.ArmsItem;
import jp.studiopixel.doukutsu.BossLife;
import jp.studiopixel.doukutsu.Fade;
import jp.studiopixel.doukutsu.Flags;
import jp.studiopixel.doukutsu.Frame;
import jp.studiopixel.doukutsu.Game;
import jp.studiopixel.doukutsu.MiniMap;
import jp.studiopixel.doukutsu.MyChar;
import jp.studiopixel.doukutsu.NpChar;
import jp.studiopixel.doukutsu.SelStage;
import jp.studiopixel.doukutsu.Stage;
import jp.studiopixel.doukutsu.Star;
import jp.studiopixel.doukutsu.ValueView;

public class Profile {
    public static final String gDefaultName = "Profile.dat";
    public static final byte[] gProfileCode = new byte[]{68, 111, 48, 52, 49, 50, 50, 48};
    private static final byte[] FLAG = new byte[]{70, 76, 65, 71};

    public static boolean IsProfile() {
        return new File(gDefaultName).exists();
    }

    public static boolean SaveProfile(String name) {
        try {
            int i;
            if (name == null) {
                name = gDefaultName;
            }
            File fp = new File(name);
            ByteBuffer buffer = ByteBuffer.allocate(4096);
            buffer.order(ByteOrder.LITTLE_ENDIAN);
            PROFILEDATA profile = new PROFILEDATA();
            System.arraycopy(gProfileCode, 0, profile.code, 0, gProfileCode.length);
            System.arraycopy(FLAG, 0, profile.FLAG, 0, FLAG.length);
            profile.stage = Stage.gStageNo;
            profile.music = Stage.gMusicNo;
            profile.x = MyChar.gMC.x;
            profile.y = MyChar.gMC.y;
            profile.direct = MyChar.gMC.direct;
            profile.max_life = MyChar.gMC.max_life;
            profile.life = MyChar.gMC.life;
            profile.star = MyChar.gMC.star;
            profile.select_arms = ArmsItem.gSelectedArms;
            profile.select_item = ArmsItem.gSelectedItem;
            profile.equip = MyChar.gMC.equip;
            profile.unit = MyChar.gMC.unit;
            profile.counter = Game.gCounter;
            for (i = 0; i < profile.arms.length; ++i) {
                profile.arms[i].copyFrom(ArmsItem.gArmsData[i]);
            }
            for (i = 0; i < profile.items.length; ++i) {
                profile.items[i].copyFrom(ArmsItem.gItemData[i]);
            }
            for (i = 0; i < profile.permitstage.length; ++i) {
                profile.permitstage[i].copyFrom(SelStage.gPermitStage[i]);
            }
            System.arraycopy(MiniMap.gMapping, 0, profile.permit_mapping, 0, MiniMap.gMapping.length);
            System.arraycopy(Flags.gFlagNPC, 0, profile.flags, 0, Flags.gFlagNPC.length);
            buffer.put(profile.code);
            buffer.putInt(profile.stage);
            buffer.putInt(profile.music);
            buffer.putInt(profile.x);
            buffer.putInt(profile.y);
            buffer.putInt(profile.direct);
            buffer.putShort(profile.max_life);
            buffer.putShort(profile.star);
            buffer.putShort(profile.life);
            buffer.putShort(profile.a);
            buffer.putInt(profile.select_arms);
            buffer.putInt(profile.select_item);
            buffer.putInt(profile.equip);
            buffer.putInt(profile.unit);
            buffer.putInt(profile.counter);
            for (i = 0; i < profile.arms.length; ++i) {
                buffer.putInt(profile.arms[i].code);
                buffer.putInt(profile.arms[i].level);
                buffer.putInt(profile.arms[i].exp);
                buffer.putInt(profile.arms[i].max_num);
                buffer.putInt(profile.arms[i].num);
            }
            for (i = 0; i < profile.items.length; ++i) {
                buffer.putInt(profile.items[i].code);
            }
            for (i = 0; i < profile.permitstage.length; ++i) {
                buffer.putInt(profile.permitstage[i].index);
                buffer.putInt(profile.permitstage[i].event);
            }
            buffer.put(profile.permit_mapping);
            buffer.put(profile.FLAG);
            buffer.put(profile.flags);
            try (FileOutputStream fos = new FileOutputStream(fp);){
                fos.write(buffer.array(), 0, buffer.position());
            }
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean LoadProfile(String name) {
        try {
            int i;
            File fp;
            if (name == null) {
                name = gDefaultName;
            }
            if (!(fp = new File(name)).exists()) {
                return false;
            }
            ByteBuffer buf = ByteBuffer.allocate((int)fp.length());
            DataInputStream dis = new DataInputStream(new FileInputStream(fp));
            dis.readFully(buf.array());
            dis.close();
            buf.order(ByteOrder.LITTLE_ENDIAN);
            ((Buffer)buf).position(0);
            PROFILEDATA profile = new PROFILEDATA();
            buf.get(profile.code);
            if (!Arrays.equals(profile.code, gProfileCode)) {
                System.out.println("Invalid profile code");
                return false;
            }
            profile.stage = buf.getInt();
            profile.music = buf.getInt();
            profile.x = buf.getInt();
            profile.y = buf.getInt();
            profile.direct = buf.getInt();
            profile.max_life = buf.getShort();
            profile.star = buf.getShort();
            profile.life = buf.getShort();
            profile.a = buf.getShort();
            profile.select_arms = buf.getInt();
            profile.select_item = buf.getInt();
            profile.equip = buf.getInt();
            profile.unit = buf.getInt();
            profile.counter = buf.getInt();
            for (i = 0; i < profile.arms.length; ++i) {
                profile.arms[i].code = buf.getInt();
                profile.arms[i].level = buf.getInt();
                profile.arms[i].exp = buf.getInt();
                profile.arms[i].max_num = buf.getInt();
                profile.arms[i].num = buf.getInt();
            }
            for (i = 0; i < profile.items.length; ++i) {
                profile.items[i].code = buf.getInt();
            }
            for (i = 0; i < profile.permitstage.length; ++i) {
                profile.permitstage[i].index = buf.getInt();
                profile.permitstage[i].event = buf.getInt();
            }
            buf.get(profile.permit_mapping);
            buf.get(profile.FLAG);
            buf.get(profile.flags);
            ArmsItem.gSelectedArms = profile.select_arms;
            ArmsItem.gSelectedItem = profile.select_item;
            Game.gCounter = profile.counter;
            for (i = 0; i < profile.arms.length; ++i) {
                ArmsItem.gArmsData[i].copyFrom(profile.arms[i]);
            }
            for (i = 0; i < profile.items.length; ++i) {
                ArmsItem.gItemData[i].copyFrom(profile.items[i]);
            }
            for (i = 0; i < profile.permitstage.length; ++i) {
                SelStage.gPermitStage[i].copyFrom(profile.permitstage[i]);
            }
            System.arraycopy(profile.permit_mapping, 0, MiniMap.gMapping, 0, profile.permit_mapping.length);
            System.arraycopy(profile.flags, 0, Flags.gFlagNPC, 0, profile.flags.length);
            Stage.ChangeMusic(profile.music);
            MyChar.InitMyChar();
            if (!Stage.TransferStage(profile.stage, 0, 0, 1)) {
                return false;
            }
            MyChar.gMC.equip = profile.equip;
            MyChar.gMC.unit = profile.unit;
            MyChar.gMC.max_life = profile.max_life;
            MyChar.gMC.life = profile.life;
            MyChar.gMC.star = profile.star;
            MyChar.gMC.cond = (char)128;
            MyChar.gMC.air = 1000;
            MyChar.gMC.lifeBr = profile.life;
            MyChar.gMC.x = profile.x;
            MyChar.gMC.y = profile.y;
            MyChar.gMC.rect_arms.left = ArmsItem.gArmsData[ArmsItem.gSelectedArms].code % 10 * 24;
            MyChar.gMC.rect_arms.right = MyChar.gMC.rect_arms.left + 24;
            MyChar.gMC.rect_arms.top = ArmsItem.gArmsData[ArmsItem.gSelectedArms].code / 10 * 32;
            MyChar.gMC.rect_arms.bottom = MyChar.gMC.rect_arms.top + 16;
            Fade.ClearFade();
            Frame.SetFrameMyChar();
            Frame.SetFrameTargetMyChar(16);
            BossLife.InitBossLife();
            MyChar.CutNoise();
            Star.InitStar();
            ValueView.ClearValueView();
            NpChar.gCurlyShoot_wait = 0;
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean InitializeGame() {
        MyChar.InitMyChar();
        ArmsItem.gSelectedArms = 0;
        ArmsItem.gSelectedItem = 0;
        Game.gCounter = 0;
        ArmsItem.ClearArmsData();
        ArmsItem.ClearItemData();
        SelStage.ClearPermitStage();
        MiniMap.StartMapping();
        Flags.InitFlags();
        if (!Stage.TransferStage(13, 200, 10, 8)) {
            JOptionPane.showMessageDialog(null, "\u30b9\u30c6\u30fc\u30b8\u306e\u8aad\u307f\u8fbc\u307f\u306b\u5931\u6557", "\u30a8\u30e9\u30fc", 0);
            return false;
        }
        Fade.ClearFade();
        Frame.SetFrameMyChar();
        Frame.SetFrameTargetMyChar(16);
        BossLife.InitBossLife();
        MyChar.CutNoise();
        ValueView.ClearValueView();
        NpChar.gCurlyShoot_wait = 0;
        Fade.SetFadeMask();
        Frame.SetFrameTargetMyChar(16);
        return true;
    }

    public static class PROFILEDATA {
        byte[] code = new byte[8];
        int stage;
        int music;
        int x;
        int y;
        int direct;
        short max_life;
        short star;
        short life;
        short a;
        int select_arms;
        int select_item;
        int equip;
        int unit;
        int counter;
        final ArmsItem.ARMS[] arms = new ArmsItem.ARMS[8];
        final ArmsItem.ITEM[] items = new ArmsItem.ITEM[32];
        final SelStage.PERMIT_STAGE[] permitstage = new SelStage.PERMIT_STAGE[8];
        final byte[] permit_mapping = new byte[128];
        final byte[] FLAG = new byte[4];
        final byte[] flags = new byte[1000];

        public PROFILEDATA() {
            int i;
            for (i = 0; i < this.arms.length; ++i) {
                this.arms[i] = new ArmsItem.ARMS();
            }
            for (i = 0; i < this.items.length; ++i) {
                this.items[i] = new ArmsItem.ITEM();
            }
            for (i = 0; i < this.permitstage.length; ++i) {
                this.permitstage[i] = new SelStage.PERMIT_STAGE();
            }
        }
    }
}
