/*
 * Decompiled with CFR 0.152.
 */
package jp.studiopixel.doukutsu;

import java.awt.Container;
import java.awt.Font;
import java.io.InputStream;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import jp.studiopixel.doukutsu.FlatButton;

public class QuitDialog
extends JDialog {
    public QuitDialog(JFrame parent) {
        super(parent);
        this.initComponents();
    }

    private void initComponents() {
        this.setUndecorated(true);
        this.setResizable(false);
        this.setModal(true);
        this.setSize(238, 98);
        this.setLocationRelativeTo(this.getParent());
        JLabel label = new JLabel();
        label.setText("Quit?");
        label.setHorizontalAlignment(0);
        label.setVerticalAlignment(0);
        label.setBounds(14, 16, 210, 30);
        FlatButton yesButton = new FlatButton("Yes");
        yesButton.setBounds(14, 56, 100, 28);
        yesButton.addActionListener(e -> {
            this.dispose();
            System.exit(0);
        });
        FlatButton noButton = new FlatButton("No");
        noButton.setBounds(124, 56, 100, 28);
        noButton.addActionListener(e -> this.dispose());
        try {
            InputStream stream = this.getClass().getResourceAsStream("/vgasys.ttf");
            Font font = Font.createFont(0, stream).deriveFont(0, 8.0f);
            label.setFont(font);
            yesButton.setFont(font);
            noButton.setFont(font);
        }
        catch (Exception stream) {
            // empty catch block
        }
        Container pane = this.getContentPane();
        pane.setLayout(null);
        pane.add(label);
        pane.add(yesButton);
        pane.add(noButton);
    }
}
