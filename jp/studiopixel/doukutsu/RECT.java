/*
 * Decompiled with CFR 0.152.
 */
package jp.studiopixel.doukutsu;

public class RECT {
    public int left;
    public int top;
    public int right;
    public int bottom;

    public RECT(int left, int top, int right, int bottom) {
        this.left = left;
        this.top = top;
        this.right = right;
        this.bottom = bottom;
    }

    public RECT() {
        this(0, 0, 0, 0);
    }

    public void clear() {
        this.left = 0;
        this.top = 0;
        this.right = 0;
        this.bottom = 0;
    }

    public void copyFrom(RECT rect) {
        this.left = rect.left;
        this.top = rect.top;
        this.right = rect.right;
        this.bottom = rect.bottom;
    }

    public RECT clone() {
        return new RECT(this.left, this.top, this.right, this.bottom);
    }
}
