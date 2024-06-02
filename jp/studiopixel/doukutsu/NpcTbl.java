/*
 * Decompiled with CFR 0.152.
 */
package jp.studiopixel.doukutsu;

import jp.studiopixel.doukutsu.DataLoader;
import jp.studiopixel.doukutsu.NpChar;
import jp.studiopixel.doukutsu.NpcAct000;
import jp.studiopixel.doukutsu.NpcAct020;
import jp.studiopixel.doukutsu.NpcAct040;
import jp.studiopixel.doukutsu.NpcAct060;
import jp.studiopixel.doukutsu.NpcAct080;
import jp.studiopixel.doukutsu.NpcAct100;
import jp.studiopixel.doukutsu.NpcAct120;
import jp.studiopixel.doukutsu.NpcAct140;
import jp.studiopixel.doukutsu.NpcAct160;
import jp.studiopixel.doukutsu.NpcAct180;
import jp.studiopixel.doukutsu.NpcAct200;
import jp.studiopixel.doukutsu.NpcAct220;
import jp.studiopixel.doukutsu.NpcAct240;
import jp.studiopixel.doukutsu.NpcAct260;
import jp.studiopixel.doukutsu.NpcAct280;
import jp.studiopixel.doukutsu.NpcAct300;
import jp.studiopixel.doukutsu.NpcAct320;
import jp.studiopixel.doukutsu.NpcAct340;

public class NpcTbl {
    public static final NPCProc[] gpNpcFuncTbl = new NPCProc[]{NpcAct000::ActNpc000, NpcAct000::ActNpc001, NpcAct000::ActNpc002, NpcAct000::ActNpc003, NpcAct000::ActNpc004, NpcAct000::ActNpc005, NpcAct000::ActNpc006, NpcAct000::ActNpc007, NpcAct000::ActNpc008, NpcAct000::ActNpc009, NpcAct000::ActNpc010, NpcAct000::ActNpc011, NpcAct000::ActNpc012, NpcAct000::ActNpc013, NpcAct000::ActNpc014, NpcAct000::ActNpc015, NpcAct000::ActNpc016, NpcAct000::ActNpc017, NpcAct000::ActNpc018, NpcAct000::ActNpc019, NpcAct020::ActNpc020, NpcAct020::ActNpc021, NpcAct020::ActNpc022, NpcAct020::ActNpc023, NpcAct020::ActNpc024, NpcAct020::ActNpc025, NpcAct020::ActNpc026, NpcAct020::ActNpc027, NpcAct020::ActNpc028, NpcAct020::ActNpc029, NpcAct020::ActNpc030, NpcAct020::ActNpc031, NpcAct020::ActNpc032, NpcAct020::ActNpc033, NpcAct020::ActNpc034, NpcAct020::ActNpc035, NpcAct020::ActNpc036, NpcAct020::ActNpc037, NpcAct020::ActNpc038, NpcAct020::ActNpc039, NpcAct040::ActNpc040, NpcAct040::ActNpc041, NpcAct040::ActNpc042, NpcAct040::ActNpc043, NpcAct040::ActNpc044, NpcAct040::ActNpc045, NpcAct040::ActNpc046, NpcAct040::ActNpc047, NpcAct040::ActNpc048, NpcAct040::ActNpc049, NpcAct040::ActNpc050, NpcAct040::ActNpc051, NpcAct040::ActNpc052, NpcAct040::ActNpc053, NpcAct040::ActNpc054, NpcAct040::ActNpc055, NpcAct040::ActNpc056, NpcAct040::ActNpc057, NpcAct040::ActNpc058, NpcAct040::ActNpc059, NpcAct060::ActNpc060, NpcAct060::ActNpc061, NpcAct060::ActNpc062, NpcAct060::ActNpc063, NpcAct060::ActNpc064, NpcAct060::ActNpc065, NpcAct060::ActNpc066, NpcAct060::ActNpc067, NpcAct060::ActNpc068, NpcAct060::ActNpc069, NpcAct060::ActNpc070, NpcAct060::ActNpc071, NpcAct060::ActNpc072, NpcAct060::ActNpc073, NpcAct060::ActNpc074, NpcAct060::ActNpc075, NpcAct060::ActNpc076, NpcAct060::ActNpc077, NpcAct060::ActNpc078, NpcAct060::ActNpc079, NpcAct080::ActNpc080, NpcAct080::ActNpc081, NpcAct080::ActNpc082, NpcAct080::ActNpc083, NpcAct080::ActNpc084, NpcAct080::ActNpc085, NpcAct080::ActNpc086, NpcAct080::ActNpc087, NpcAct080::ActNpc088, NpcAct080::ActNpc089, NpcAct080::ActNpc090, NpcAct080::ActNpc091, NpcAct080::ActNpc092, NpcAct080::ActNpc093, NpcAct080::ActNpc094, NpcAct080::ActNpc095, NpcAct080::ActNpc096, NpcAct080::ActNpc097, NpcAct080::ActNpc098, NpcAct080::ActNpc099, NpcAct100::ActNpc100, NpcAct100::ActNpc101, NpcAct100::ActNpc102, NpcAct100::ActNpc103, NpcAct100::ActNpc104, NpcAct100::ActNpc105, NpcAct100::ActNpc106, NpcAct100::ActNpc107, NpcAct100::ActNpc108, NpcAct100::ActNpc109, NpcAct100::ActNpc110, NpcAct100::ActNpc111, NpcAct100::ActNpc112, NpcAct100::ActNpc113, NpcAct100::ActNpc114, NpcAct100::ActNpc115, NpcAct100::ActNpc116, NpcAct100::ActNpc117, NpcAct100::ActNpc118, NpcAct100::ActNpc119, NpcAct120::ActNpc120, NpcAct120::ActNpc121, NpcAct120::ActNpc122, NpcAct120::ActNpc123, NpcAct120::ActNpc124, NpcAct120::ActNpc125, NpcAct120::ActNpc126, NpcAct120::ActNpc127, NpcAct120::ActNpc128, NpcAct120::ActNpc129, NpcAct120::ActNpc130, NpcAct120::ActNpc131, NpcAct120::ActNpc132, NpcAct120::ActNpc133, NpcAct120::ActNpc134, NpcAct120::ActNpc135, NpcAct120::ActNpc136, NpcAct120::ActNpc137, NpcAct120::ActNpc138, NpcAct120::ActNpc139, NpcAct140::ActNpc140, NpcAct140::ActNpc141, NpcAct140::ActNpc142, NpcAct140::ActNpc143, NpcAct140::ActNpc144, NpcAct140::ActNpc145, NpcAct140::ActNpc146, NpcAct140::ActNpc147, NpcAct140::ActNpc148, NpcAct140::ActNpc149, NpcAct140::ActNpc150, NpcAct140::ActNpc151, NpcAct140::ActNpc152, NpcAct140::ActNpc153, NpcAct140::ActNpc154, NpcAct140::ActNpc155, NpcAct140::ActNpc156, NpcAct140::ActNpc157, NpcAct140::ActNpc158, NpcAct140::ActNpc159, NpcAct160::ActNpc160, NpcAct160::ActNpc161, NpcAct160::ActNpc162, NpcAct160::ActNpc163, NpcAct160::ActNpc164, NpcAct160::ActNpc165, NpcAct160::ActNpc166, NpcAct160::ActNpc167, NpcAct160::ActNpc168, NpcAct160::ActNpc169, NpcAct160::ActNpc170, NpcAct160::ActNpc171, NpcAct160::ActNpc172, NpcAct160::ActNpc173, NpcAct160::ActNpc174, NpcAct160::ActNpc175, NpcAct160::ActNpc176, NpcAct160::ActNpc177, NpcAct160::ActNpc178, NpcAct160::ActNpc179, NpcAct180::ActNpc180, NpcAct180::ActNpc181, NpcAct180::ActNpc182, NpcAct180::ActNpc183, NpcAct180::ActNpc184, NpcAct180::ActNpc185, NpcAct180::ActNpc186, NpcAct180::ActNpc187, NpcAct180::ActNpc188, NpcAct180::ActNpc189, NpcAct180::ActNpc190, NpcAct180::ActNpc191, NpcAct180::ActNpc192, NpcAct180::ActNpc193, NpcAct180::ActNpc194, NpcAct180::ActNpc195, NpcAct180::ActNpc196, NpcAct180::ActNpc197, NpcAct180::ActNpc198, NpcAct180::ActNpc199, NpcAct200::ActNpc200, NpcAct200::ActNpc201, NpcAct200::ActNpc202, NpcAct200::ActNpc203, NpcAct200::ActNpc204, NpcAct200::ActNpc205, NpcAct200::ActNpc206, NpcAct200::ActNpc207, NpcAct200::ActNpc208, NpcAct200::ActNpc209, NpcAct200::ActNpc210, NpcAct200::ActNpc211, NpcAct200::ActNpc212, NpcAct200::ActNpc213, NpcAct200::ActNpc214, NpcAct200::ActNpc215, NpcAct200::ActNpc216, NpcAct200::ActNpc217, NpcAct200::ActNpc218, NpcAct200::ActNpc219, NpcAct220::ActNpc220, NpcAct220::ActNpc221, NpcAct220::ActNpc222, NpcAct220::ActNpc223, NpcAct220::ActNpc224, NpcAct220::ActNpc225, NpcAct220::ActNpc226, NpcAct220::ActNpc227, NpcAct220::ActNpc228, NpcAct220::ActNpc229, NpcAct220::ActNpc230, NpcAct220::ActNpc231, NpcAct220::ActNpc232, NpcAct220::ActNpc233, NpcAct220::ActNpc234, NpcAct220::ActNpc235, NpcAct220::ActNpc236, NpcAct220::ActNpc237, NpcAct220::ActNpc238, NpcAct220::ActNpc239, NpcAct240::ActNpc240, NpcAct240::ActNpc241, NpcAct240::ActNpc242, NpcAct240::ActNpc243, NpcAct240::ActNpc244, NpcAct240::ActNpc245, NpcAct240::ActNpc246, NpcAct240::ActNpc247, NpcAct240::ActNpc248, NpcAct240::ActNpc249, NpcAct240::ActNpc250, NpcAct240::ActNpc251, NpcAct240::ActNpc252, NpcAct240::ActNpc253, NpcAct240::ActNpc254, NpcAct240::ActNpc255, NpcAct240::ActNpc256, NpcAct240::ActNpc257, NpcAct240::ActNpc258, NpcAct240::ActNpc259, NpcAct260::ActNpc260, NpcAct260::ActNpc261, NpcAct260::ActNpc262, NpcAct260::ActNpc263, NpcAct260::ActNpc264, NpcAct260::ActNpc265, NpcAct260::ActNpc266, NpcAct260::ActNpc267, NpcAct260::ActNpc268, NpcAct260::ActNpc269, NpcAct260::ActNpc270, NpcAct260::ActNpc271, NpcAct260::ActNpc272, NpcAct260::ActNpc273, NpcAct260::ActNpc274, NpcAct260::ActNpc275, NpcAct260::ActNpc276, NpcAct260::ActNpc277, NpcAct260::ActNpc278, NpcAct260::ActNpc279, NpcAct280::ActNpc280, NpcAct280::ActNpc281, NpcAct280::ActNpc282, NpcAct280::ActNpc283, NpcAct280::ActNpc284, NpcAct280::ActNpc285, NpcAct280::ActNpc286, NpcAct280::ActNpc287, NpcAct280::ActNpc288, NpcAct280::ActNpc289, NpcAct280::ActNpc290, NpcAct280::ActNpc291, NpcAct280::ActNpc292, NpcAct280::ActNpc293, NpcAct280::ActNpc294, NpcAct280::ActNpc295, NpcAct280::ActNpc296, NpcAct280::ActNpc297, NpcAct280::ActNpc298, NpcAct280::ActNpc299, NpcAct300::ActNpc300, NpcAct300::ActNpc301, NpcAct300::ActNpc302, NpcAct300::ActNpc303, NpcAct300::ActNpc304, NpcAct300::ActNpc305, NpcAct300::ActNpc306, NpcAct300::ActNpc307, NpcAct300::ActNpc308, NpcAct300::ActNpc309, NpcAct300::ActNpc310, NpcAct300::ActNpc311, NpcAct300::ActNpc312, NpcAct300::ActNpc313, NpcAct300::ActNpc314, NpcAct300::ActNpc315, NpcAct300::ActNpc316, NpcAct300::ActNpc317, NpcAct300::ActNpc318, NpcAct300::ActNpc319, NpcAct320::ActNpc320, NpcAct320::ActNpc321, NpcAct320::ActNpc322, NpcAct320::ActNpc323, NpcAct320::ActNpc324, NpcAct320::ActNpc325, NpcAct320::ActNpc326, NpcAct320::ActNpc327, NpcAct320::ActNpc328, NpcAct320::ActNpc329, NpcAct320::ActNpc330, NpcAct320::ActNpc331, NpcAct320::ActNpc332, NpcAct320::ActNpc333, NpcAct320::ActNpc334, NpcAct320::ActNpc335, NpcAct320::ActNpc336, NpcAct320::ActNpc337, NpcAct320::ActNpc338, NpcAct320::ActNpc339, NpcAct340::ActNpc340, NpcAct340::ActNpc341, NpcAct340::ActNpc342, NpcAct340::ActNpc343, NpcAct340::ActNpc344, NpcAct340::ActNpc345, NpcAct340::ActNpc346, NpcAct340::ActNpc347, NpcAct340::ActNpc348, NpcAct340::ActNpc349, NpcAct340::ActNpc350, NpcAct340::ActNpc351, NpcAct340::ActNpc352, NpcAct340::ActNpc353, NpcAct340::ActNpc354, NpcAct340::ActNpc355, NpcAct340::ActNpc356, NpcAct340::ActNpc357, NpcAct340::ActNpc358, NpcAct340::ActNpc359, NpcAct340::ActNpc360};
    public static NPC_TABLE[] gNpcTable;

    public static boolean LoadNpcTable(String path) {
        try {
            int n;
            DataLoader.DataFile file = DataLoader.load(path);
            file.cSeek(2, 0);
            long size = file.cTell();
            int num = (int)(size / 24L);
            file.cSeek(0, 0);
            gNpcTable = new NPC_TABLE[num];
            for (int i = 0; i < num; ++i) {
                NpcTbl.gNpcTable[i] = new NPC_TABLE();
            }
            for (n = 0; n < num; ++n) {
                NpcTbl.gNpcTable[n].bits = (char)file.readUnsignedShort();
            }
            for (n = 0; n < num; ++n) {
                NpcTbl.gNpcTable[n].life = (char)file.readUnsignedShort();
            }
            for (n = 0; n < num; ++n) {
                NpcTbl.gNpcTable[n].surf = (char)file.readUnsignedByte();
            }
            for (n = 0; n < num; ++n) {
                NpcTbl.gNpcTable[n].destroy_voice = (char)file.readUnsignedByte();
            }
            for (n = 0; n < num; ++n) {
                NpcTbl.gNpcTable[n].hit_voice = (char)file.readUnsignedByte();
            }
            for (n = 0; n < num; ++n) {
                NpcTbl.gNpcTable[n].size = (char)file.readUnsignedByte();
            }
            for (n = 0; n < num; ++n) {
                NpcTbl.gNpcTable[n].exp = file.readInt();
            }
            for (n = 0; n < num; ++n) {
                NpcTbl.gNpcTable[n].damage = file.readInt();
            }
            for (n = 0; n < num; ++n) {
                NpcTbl.gNpcTable[n].hit.front = (char)file.readUnsignedByte();
                NpcTbl.gNpcTable[n].hit.top = (char)file.readUnsignedByte();
                NpcTbl.gNpcTable[n].hit.back = (char)file.readUnsignedByte();
                NpcTbl.gNpcTable[n].hit.bottom = (char)file.readUnsignedByte();
            }
            for (n = 0; n < num; ++n) {
                NpcTbl.gNpcTable[n].view.front = (char)file.readUnsignedByte();
                NpcTbl.gNpcTable[n].view.top = (char)file.readUnsignedByte();
                NpcTbl.gNpcTable[n].view.back = (char)file.readUnsignedByte();
                NpcTbl.gNpcTable[n].view.bottom = (char)file.readUnsignedByte();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static class NPC_TABLE {
        char bits;
        char life;
        char surf;
        char hit_voice;
        char destroy_voice;
        char size;
        int exp;
        int damage;
        NPC_TBL_RECT hit = new NPC_TBL_RECT();
        NPC_TBL_RECT view = new NPC_TBL_RECT();
    }

    public static class NPC_TBL_RECT {
        char front;
        char top;
        char back;
        char bottom;

        public NPC_TBL_RECT() {
            this.clear();
        }

        public void clear() {
            this.front = '\u0000';
            this.top = '\u0000';
            this.back = '\u0000';
            this.bottom = '\u0000';
        }
    }

    @FunctionalInterface
    public static interface NPCProc {
        public void proc(NpChar.NPCHAR var1);
    }
}
