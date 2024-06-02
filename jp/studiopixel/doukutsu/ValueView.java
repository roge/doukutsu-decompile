/*
 * Decompiled with CFR 0.152.
 */
package jp.studiopixel.doukutsu;

import jp.studiopixel.doukutsu.Draw;
import jp.studiopixel.doukutsu.IntSupplier;
import jp.studiopixel.doukutsu.RECT;

public class ValueView {
    public static final VALUEVIEW[] gVV = new VALUEVIEW[16];
    public static int gVVIndex;
    private static final RECT[] digitRects;
    private static final RECT rcPlus;
    private static final RECT rcMinus;
    private static final int[] dig;

    public static void ClearValueView() {
        for (VALUEVIEW valueview : gVV) {
            valueview.clear();
        }
    }

    public static void SetValueView(IntSupplier px, IntSupplier py, int value, int uid) {
        boolean minus;
        int index;
        int i;
        for (i = 0; !(i >= gVV.length || ValueView.gVV[i].flag && ValueView.gVV[i].uid == uid && (ValueView.gVV[i].value < 0 && value < 0 || ValueView.gVV[i].value > 0 && value > 0)); ++i) {
        }
        if (i == gVV.length) {
            index = gVVIndex++;
            if (gVVIndex == gVV.length) {
                gVVIndex = 0;
            }
            ValueView.gVV[index].count = 0;
            ValueView.gVV[index].offset_y = 0;
            ValueView.gVV[index].value = value;
        } else {
            index = i;
            ValueView.gVV[index].count = 32;
            ValueView.gVV[index].value += value;
            value = ValueView.gVV[index].value;
        }
        if (value < 0) {
            value *= -1;
            minus = true;
        } else {
            minus = false;
        }
        int v = value;
        int width = value > 999 ? 40 : (value > 99 ? 32 : (value > 9 ? 24 : 16));
        ValueView.gVV[index].flag = true;
        ValueView.gVV[index].uid = uid;
        ValueView.gVV[index].px = px;
        ValueView.gVV[index].py = py;
        ValueView.gVV[index].rect.left = 40 - width;
        ValueView.gVV[index].rect.top = 8 * index;
        ValueView.gVV[index].rect.right = 40;
        ValueView.gVV[index].rect.bottom = 8 * (index + 1);
        int[] fig = new int[4];
        for (i = 3; i >= 0; --i) {
            fig[i] = 0;
            while (v >= dig[i]) {
                v -= dig[i];
                int n = i;
                fig[n] = fig[n] + 1;
            }
        }
        boolean sw = false;
        Draw.CortBox2(ValueView.gVV[index].rect, 0, 29);
        if (minus) {
            Draw.Surface2Surface(ValueView.gVV[index].rect.left, ValueView.gVV[index].rect.top, rcMinus, 29, 26);
        } else {
            Draw.Surface2Surface(ValueView.gVV[index].rect.left, ValueView.gVV[index].rect.top, rcPlus, 29, 26);
        }
        for (i = 3; i >= 0; --i) {
            if (!sw && i != 0 && fig[i] == 0) continue;
            sw = true;
            if (minus) {
                int n = i;
                fig[n] = fig[n] + 10;
            }
            Draw.Surface2Surface((3 - i) * 8 + 8, ValueView.gVV[index].rect.top, digitRects[fig[i]], 29, 26);
        }
    }

    public static void ActValueView() {
        for (int v = 0; v < gVV.length; ++v) {
            if (!ValueView.gVV[v].flag) continue;
            if (++ValueView.gVV[v].count < 32) {
                ValueView.gVV[v].offset_y -= 256;
            }
            if (ValueView.gVV[v].count > 72) {
                ++ValueView.gVV[v].rect.top;
            }
            if (ValueView.gVV[v].count <= 80) continue;
            ValueView.gVV[v].flag = false;
        }
    }

    public static void PutValueView(int flx, int fly) {
        for (int v = 0; v < gVV.length; ++v) {
            if (!ValueView.gVV[v].flag) continue;
            int offset_x = (ValueView.gVV[v].rect.right - ValueView.gVV[v].rect.left) / 2;
            Draw.PutBitmap3(Draw.grcGame, ValueView.gVV[v].px.get() / 512 - offset_x - flx / 512, ValueView.gVV[v].py.get() / 512 + ValueView.gVV[v].offset_y / 512 - 4 - fly / 512, ValueView.gVV[v].rect, 29);
        }
    }

    static {
        for (int i = 0; i < gVV.length; ++i) {
            ValueView.gVV[i] = new VALUEVIEW();
        }
        gVVIndex = 0;
        digitRects = new RECT[]{new RECT(0, 56, 8, 64), new RECT(8, 56, 16, 64), new RECT(16, 56, 24, 64), new RECT(24, 56, 32, 64), new RECT(32, 56, 40, 64), new RECT(40, 56, 48, 64), new RECT(48, 56, 56, 64), new RECT(56, 56, 64, 64), new RECT(64, 56, 72, 64), new RECT(72, 56, 80, 64), new RECT(0, 64, 8, 72), new RECT(8, 64, 16, 72), new RECT(16, 64, 24, 72), new RECT(24, 64, 32, 72), new RECT(32, 64, 40, 72), new RECT(40, 64, 48, 72), new RECT(48, 64, 56, 72), new RECT(56, 64, 64, 72), new RECT(64, 64, 72, 72), new RECT(72, 64, 80, 72)};
        rcPlus = new RECT(32, 48, 40, 56);
        rcMinus = new RECT(40, 48, 48, 56);
        dig = new int[]{1, 10, 100, 1000};
    }

    public static class VALUEVIEW {
        boolean flag;
        IntSupplier px = null;
        IntSupplier py = null;
        int uid;
        int offset_y;
        int value;
        int count;
        final RECT rect = new RECT();

        public void clear() {
            this.flag = false;
            this.px = null;
            this.py = null;
            this.offset_y = 0;
            this.value = 0;
            this.count = 0;
            this.rect.clear();
        }
    }
}
