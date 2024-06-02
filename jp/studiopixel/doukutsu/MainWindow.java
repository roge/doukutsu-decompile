/*
 * Decompiled with CFR 0.152.
 */
package jp.studiopixel.doukutsu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.DisplayMode;
import java.awt.Graphics;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import jp.studiopixel.doukutsu.Config;
import jp.studiopixel.doukutsu.Game;
import jp.studiopixel.doukutsu.KeyControl;
import jp.studiopixel.doukutsu.QuitDialog;
import jp.studiopixel.doukutsu.VersionDialog;

public class MainWindow
extends JFrame {
    private Cursor cursor;
    private static Canvas canvas = null;
    private static final AtomicBoolean waitRepaint = new AtomicBoolean(false);

    public MainWindow() {
        this.setTitle("Cave Story ~ Doukutsu Monogatari");
        this.setDefaultCloseOperation(3);
        int width = 640;
        int height = 480;
        int mag = 1;
        switch (Config.gConfig.display_mode) {
            case 1: {
                width = 320;
                height = 240;
                mag = 0;
                break;
            }
            case 2: {
                width = 640;
                height = 480;
                mag = 1;
                break;
            }
            case 0: 
            case 3: 
            case 4: {
                width = 640;
                height = 480;
                mag = 2;
            }
        }
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        DisplayMode dm = null;
        for (DisplayMode mode : gd.getDisplayModes()) {
            if (mode.getWidth() != width || mode.getHeight() != height) continue;
            dm = mode;
            break;
        }
        this.loadIcons();
        this.setLayout(new BorderLayout());
        this.setResizable(false);
        GameMenuBar menuBar = new GameMenuBar();
        Canvas canvas = new Canvas();
        if (mag != 2) {
            canvas.setCursor(this.cursor);
            this.add((Component)menuBar, "North");
        } else {
            canvas.setCursor(this.getToolkit().createCustomCursor(new BufferedImage(1, 1, 2), new Point(), null));
        }
        if (mag == 2) {
            this.setUndecorated(true);
            this.setExtendedState(this.getExtendedState() | 6);
            gd.setFullScreenWindow(this);
            if (dm != null) {
                gd.setDisplayMode(dm);
            }
        }
        this.add((Component)canvas, "Center");
        this.setVisible(true);
        if (mag != 2) {
            Insets insets = this.getInsets();
            int borderX = insets.left + insets.right;
            int borderY = insets.top + insets.bottom;
            int windowWidth = width + borderX;
            int windowHeight = height + borderY + menuBar.getHeight();
            this.setSize(windowWidth, windowHeight);
        }
        this.setLocationRelativeTo(null);
        Game.startMainThread(width, height, mag);
        this.addWindowFocusListener(new WindowAdapter(){

            @Override
            public void windowGainedFocus(WindowEvent evt) {
                Game.WindowFocusCallback(true);
            }

            @Override
            public void windowLostFocus(WindowEvent evt) {
                Game.WindowFocusCallback(false);
            }
        });
    }

    private void loadIcons() {
        try {
            ArrayList<Image> icons = new ArrayList<Image>();
            icons.add(new ImageIcon(Objects.requireNonNull(this.getClass().getResource("/ICON/16x16.png"))).getImage());
            icons.add(new ImageIcon(Objects.requireNonNull(this.getClass().getResource("/ICON/32x32.png"))).getImage());
            this.setIconImages(icons);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Image cursorImage = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("/CURSOR/CURSOR_NORMAL.png"))).getImage();
            this.cursor = Toolkit.getDefaultToolkit().createCustomCursor(cursorImage, new Point(0, 0), "douNormal");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void handleKeyEvent(KeyEvent e) {
        if (e.getID() == 401) {
            switch (e.getKeyCode()) {
                case 38: {
                    KeyControl.gKey |= 4;
                    break;
                }
                case 40: {
                    KeyControl.gKey |= 8;
                    break;
                }
                case 37: {
                    KeyControl.gKey |= 1;
                    break;
                }
                case 39: {
                    KeyControl.gKey |= 2;
                    break;
                }
                case 90: {
                    KeyControl.gKey |= 0x40;
                    break;
                }
                case 88: {
                    KeyControl.gKey |= 0x20;
                    break;
                }
                case 16: {
                    KeyControl.gKey |= 0x200;
                    break;
                }
                case 65: {
                    KeyControl.gKey |= 0x100;
                    break;
                }
                case 83: {
                    KeyControl.gKey |= 0x80;
                    break;
                }
                case 81: {
                    KeyControl.gKey |= 0x1000;
                    break;
                }
                case 87: {
                    KeyControl.gKey |= 0x10;
                    break;
                }
                case 27: {
                    KeyControl.gKey |= 0x8000;
                    break;
                }
                case 112: {
                    KeyControl.gKey |= 0x400;
                    break;
                }
                case 113: {
                    KeyControl.gKey |= 0x800;
                    break;
                }
                case 44: {
                    KeyControl.gKey |= 0x10000;
                    break;
                }
                case 46: {
                    KeyControl.gKey |= 0x20000;
                    break;
                }
                case 47: {
                    KeyControl.gKey |= 0x40000;
                    break;
                }
                case 76: {
                    KeyControl.gKey |= 0x80000;
                    break;
                }
                case 521: {
                    KeyControl.gKey |= 0x100000;
                }
            }
        } else if (e.getID() == 402) {
            switch (e.getKeyCode()) {
                case 38: {
                    KeyControl.gKey &= 0xFFFFFFFB;
                    break;
                }
                case 40: {
                    KeyControl.gKey &= 0xFFFFFFF7;
                    break;
                }
                case 37: {
                    KeyControl.gKey &= 0xFFFFFFFE;
                    break;
                }
                case 39: {
                    KeyControl.gKey &= 0xFFFFFFFD;
                    break;
                }
                case 90: {
                    KeyControl.gKey &= 0xFFFFFFBF;
                    break;
                }
                case 88: {
                    KeyControl.gKey &= 0xFFFFFFDF;
                    break;
                }
                case 16: {
                    KeyControl.gKey &= 0xFFFFFDFF;
                    break;
                }
                case 65: {
                    KeyControl.gKey &= 0xFFFFFEFF;
                    break;
                }
                case 83: {
                    KeyControl.gKey &= 0xFFFFFF7F;
                    break;
                }
                case 81: {
                    KeyControl.gKey &= 0xFFFFEFFF;
                    break;
                }
                case 87: {
                    KeyControl.gKey &= 0xFFFFFFEF;
                    break;
                }
                case 27: {
                    KeyControl.gKey &= 0xFFFF7FFF;
                    break;
                }
                case 112: {
                    KeyControl.gKey &= 0xFFFFFBFF;
                    break;
                }
                case 113: {
                    KeyControl.gKey &= 0xFFFFF7FF;
                    break;
                }
                case 44: {
                    KeyControl.gKey &= 0xFFFEFFFF;
                    break;
                }
                case 46: {
                    KeyControl.gKey &= 0xFFFDFFFF;
                    break;
                }
                case 47: {
                    KeyControl.gKey &= 0xFFFBFFFF;
                    break;
                }
                case 76: {
                    KeyControl.gKey &= 0xFFF7FFFF;
                    break;
                }
                case 521: {
                    KeyControl.gKey &= 0xFFEFFFFF;
                }
            }
        }
    }

    @Override
    protected void processKeyEvent(KeyEvent e) {
        MainWindow.handleKeyEvent(e);
        super.processKeyEvent(e);
    }

    public static void setBackBuffer(Image backBuffer) {
        if (canvas != null) {
            canvas.setBackBuffer(backBuffer);
        }
    }

    public static void submitRepaint() {
        waitRepaint.set(true);
        SwingUtilities.invokeLater(() -> {
            if (canvas != null) {
                canvas.repaint();
            }
        });
        while (waitRepaint.get()) {
            try {
                Thread.sleep(1L);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static class Canvas
    extends JPanel {
        private Image backBuffer = null;

        public Canvas() {
            super(true);
            Dimension d = new Dimension(640, 480);
            this.setSize(d);
            this.setMinimumSize(d);
            this.setPreferredSize(d);
            this.setFocusable(true);
            canvas = this;
        }

        public void setBackBuffer(Image backBuffer) {
            this.backBuffer = backBuffer;
        }

        @Override
        protected void processKeyEvent(KeyEvent e) {
            MainWindow.handleKeyEvent(e);
            super.processKeyEvent(e);
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, this.getWidth(), this.getHeight());
            if (this.backBuffer != null) {
                g.drawImage(this.backBuffer, 0, 0, null);
            }
            waitRepaint.set(false);
        }
    }

    private class GameMenuBar
    extends JMenuBar {
        public GameMenuBar() {
            JMenu quitMenu = new JMenu("Quit");
            JMenu volumeMenu = new JMenu("Volume");
            JMenu versionMenu = new JMenu("Version");
            final Runnable unfocus = () -> {
                quitMenu.setSelected(false);
                volumeMenu.setSelected(false);
                versionMenu.setSelected(false);
            };
            quitMenu.addMenuListener(new MenuListener(){

                @Override
                public void menuSelected(MenuEvent e) {
                    unfocus.run();
                    new QuitDialog(MainWindow.this).setVisible(true);
                }

                @Override
                public void menuCanceled(MenuEvent e) {
                }

                @Override
                public void menuDeselected(MenuEvent e) {
                }
            });
            volumeMenu.addMenuListener(new MenuListener(){

                @Override
                public void menuSelected(MenuEvent e) {
                    unfocus.run();
                    try {
                        Runtime.getRuntime().exec("sndvol32.exe");
                    }
                    catch (IOException e1) {
                        JOptionPane.showMessageDialog(MainWindow.this, "\u30dc\u30ea\u30e5\u30fc\u30e0\u8a2d\u5b9a\u3092\u8d77\u52d5\u3067\u304d\u307e\u305b\u3093\u3067\u3057\u305f", MainWindow.this.getTitle(), 0);
                    }
                }

                @Override
                public void menuCanceled(MenuEvent e) {
                }

                @Override
                public void menuDeselected(MenuEvent e) {
                }
            });
            versionMenu.addMenuListener(new MenuListener(){

                @Override
                public void menuSelected(MenuEvent e) {
                    unfocus.run();
                    new VersionDialog(MainWindow.this).setVisible(true);
                }

                @Override
                public void menuCanceled(MenuEvent e) {
                }

                @Override
                public void menuDeselected(MenuEvent e) {
                }
            });
            this.add(quitMenu);
            this.add(volumeMenu);
            this.add(versionMenu);
        }
    }
}
