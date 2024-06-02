/*
 * Decompiled with CFR 0.152.
 */
package jp.studiopixel.doukutsu;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import jp.studiopixel.doukutsu.Config;
import jp.studiopixel.doukutsu.MainWindow;

class Main {
    Main() {
    }

    public static void main(String[] args) {
        if (!Config.LoadConfigData(Config.gConfig)) {
            Config.DefaultConfigData(Config.gConfig);
        }
        System.setProperty("java.awt.headless", "false");
        System.setProperty("sun.java2d.accthreshold", "0");
        System.setProperty("sun.java2d.xrender", "false");
        if (Config.gConfig.display_mode == 1 || Config.gConfig.display_mode == 2) {
            System.setProperty("sun.java2d.opengl", "true");
            System.setProperty("sun.java2d.d3d", "false");
            System.setProperty("sun.java2d.pmoffscreen", "false");
            System.setProperty("sun.java2d.ddscale", "false");
        }
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        SwingUtilities.invokeLater(MainWindow::new);
    }
}
