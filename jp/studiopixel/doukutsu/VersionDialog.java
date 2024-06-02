/*
 * Decompiled with CFR 0.152.
 */
package jp.studiopixel.doukutsu;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.InputStream;
import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import jp.studiopixel.doukutsu.FlatButton;

public class VersionDialog
extends JDialog {
    public VersionDialog(JFrame parent) {
        super(parent);
        this.initComponents();
    }

    private void initComponents() {
        this.setUndecorated(true);
        this.setResizable(false);
        this.setModal(true);
        this.setSize(246, 150);
        this.setLocationRelativeTo(this.getParent());
        JLabel label = new JLabel("version.1.0.0.6");
        JLabel label2 = new JLabel("2004/12/20 - 2005/06/12");
        JLabel label3 = new JLabel("Studio Pixel");
        label.setHorizontalAlignment(0);
        label2.setHorizontalAlignment(0);
        label3.setHorizontalAlignment(0);
        FlatButton button = new FlatButton("OK");
        button.addActionListener(e -> this.dispose());
        button.setPreferredSize(new Dimension(100, 28));
        try {
            InputStream stream = this.getClass().getResourceAsStream("/vgasys.ttf");
            Font font = Font.createFont(0, stream).deriveFont(0, 8.0f);
            label.setFont(font);
            label2.setFont(font);
            label3.setFont(font);
            button.setFont(font);
        }
        catch (Exception stream) {
            // empty catch block
        }
        Container pane = this.getContentPane();
        pane.setLayout(new BorderLayout());
        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(3, 1));
        panel1.setBorder(BorderFactory.createEmptyBorder(28, 0, 0, 0));
        JPanel panel2 = new JPanel();
        panel2.setBorder(BorderFactory.createEmptyBorder(8, 0, 8, 0));
        panel1.add(label);
        panel1.add(label2);
        panel1.add(label3);
        panel2.add(button);
        pane.add((Component)panel1, "North");
        pane.add((Component)panel2, "South");
    }
}
