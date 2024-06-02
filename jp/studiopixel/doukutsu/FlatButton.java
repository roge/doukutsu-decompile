/*
 * Decompiled with CFR 0.152.
 */
package jp.studiopixel.doukutsu;

import javax.swing.BorderFactory;
import javax.swing.JButton;

public class FlatButton
extends JButton {
    public FlatButton(String label) {
        super(label);
        this.setBorder(BorderFactory.createEtchedBorder(1));
        this.setContentAreaFilled(false);
        this.setFocusPainted(false);
    }
}
