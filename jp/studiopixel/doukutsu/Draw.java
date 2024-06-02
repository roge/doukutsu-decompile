/*
 * Decompiled with CFR 0.152.
 */
package jp.studiopixel.doukutsu;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.awt.image.VolatileImage;
import javax.imageio.ImageIO;
import jp.studiopixel.doukutsu.DataLoader;
import jp.studiopixel.doukutsu.Ending;
import jp.studiopixel.doukutsu.Game;
import jp.studiopixel.doukutsu.MainWindow;
import jp.studiopixel.doukutsu.MapName;
import jp.studiopixel.doukutsu.RECT;
import jp.studiopixel.doukutsu.TextScr;

public class Draw {
    public static final int SURFACE_ID_TITLE = 0;
    public static final int SURFACE_ID_PIXEL = 1;
    public static final int SURFACE_ID_LEVEL_TILESET = 2;
    public static final int SURFACE_ID_FADE = 6;
    public static final int SURFACE_ID_ITEM_IMAGE = 8;
    public static final int SURFACE_ID_MAP = 9;
    public static final int SURFACE_ID_SCREEN_GRAB = 10;
    public static final int SURFACE_ID_ARMS = 11;
    public static final int SURFACE_ID_ARMS_IMAGE = 12;
    public static final int SURFACE_ID_ROOM_NAME = 13;
    public static final int SURFACE_ID_STAGE_ITEM = 14;
    public static final int SURFACE_ID_LOADING = 15;
    public static final int SURFACE_ID_MY_CHAR = 16;
    public static final int SURFACE_ID_BULLET = 17;
    public static final int SURFACE_ID_CARET = 19;
    public static final int SURFACE_ID_NPC_SYM = 20;
    public static final int SURFACE_ID_LEVEL_SPRITESET_1 = 21;
    public static final int SURFACE_ID_LEVEL_SPRITESET_2 = 22;
    public static final int SURFACE_ID_NPC_REGU = 23;
    public static final int SURFACE_ID_TEXT_BOX = 26;
    public static final int SURFACE_ID_FACE = 27;
    public static final int SURFACE_ID_LEVEL_BACKGROUND = 28;
    public static final int SURFACE_ID_VALUE_VIEW = 29;
    public static final int SURFACE_ID_TEXT_LINE1 = 30;
    public static final int SURFACE_ID_TEXT_LINE2 = 31;
    public static final int SURFACE_ID_TEXT_LINE3 = 32;
    public static final int SURFACE_ID_TEXT_LINE4 = 33;
    public static final int SURFACE_ID_TEXT_LINE5 = 34;
    public static final int SURFACE_ID_CREDIT_CAST = 35;
    public static final int SURFACE_ID_CREDITS_IMAGE = 36;
    public static final int SURFACE_ID_CASTS = 37;
    public static final int SURFACE_ID_MAX = 40;
    public static RECT grcGame = new RECT(0, 0, 320, 240);
    public static RECT grcFull = new RECT(0, 0, 320, 240);
    private static int mag = 1;
    private static Surface[] surfaces = new Surface[40];
    private static long timeNow = 0L;
    private static long lastTime = 0L;
    private static VolatileImage backBuffer = null;
    private static Graphics2D backBufferGraphics = null;
    private static RECT rcWork = new RECT();
    private static Font font;

    public static boolean Flip_SystemTask() {
        long timeDiff;
        while (!Game.bActive) {
            try {
                Thread.sleep(1L);
                lastTime = System.nanoTime();
            }
            catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        if (lastTime == 0L) {
            lastTime = System.nanoTime();
        }
        while ((timeDiff = (timeNow = System.nanoTime()) - lastTime) < 20000000L) {
            try {
                Thread.sleep(1L);
            }
            catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        lastTime = timeNow >= lastTime + 1000000000L ? timeNow : (lastTime += 20000000L);
        MainWindow.setBackBuffer(backBuffer);
        MainWindow.submitRepaint();
        if (Draw.RestoreSurfaces() != 0) {
            Ending.RestoreStripper();
            MapName.RestoreMapName();
            TextScr.RestoreTextScript();
        }
        return true;
    }

    private static VolatileImage createImage(int width, int height) {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsConfiguration gc = ge.getDefaultScreenDevice().getDefaultConfiguration();
        return gc.createCompatibleVolatileImage(width, height, 3);
    }

    public static boolean StartDirectDraw(String title, int width, int height, int mag) {
        Draw.mag = mag == 0 ? 1 : 2;
        backBuffer = Draw.createImage(width, height);
        backBufferGraphics = backBuffer.createGraphics();
        backBufferGraphics.setComposite(AlphaComposite.getInstance(3, 1.0f));
        return true;
    }

    public static void EndDirectDraw() {
    }

    public static void ReleaseSurface(int surf_no) {
    }

    public static boolean MakeSurface_Resource(String name, int surf_no) {
        return Draw.MakeSurface_File("BITMAP/" + name, surf_no);
    }

    private static BufferedImage colorKey(BufferedImage img) {
        BufferedImage newImg = new BufferedImage(img.getWidth(), img.getHeight(), 2);
        Graphics2D g = newImg.createGraphics();
        g.drawImage((Image)img, 0, 0, null);
        g.dispose();
        for (int y = 0; y < newImg.getHeight(); ++y) {
            for (int x = 0; x < newImg.getWidth(); ++x) {
                int rgb = newImg.getRGB(x, y);
                if (rgb != -16777216) continue;
                newImg.setRGB(x, y, 0);
            }
        }
        return newImg;
    }

    public static boolean MakeSurface_File(String name, int surf_no) {
        try {
            String path = "/" + name + ".pbm";
            BufferedImage img = ImageIO.read(DataLoader.stream(path));
            if (img == null) {
                System.err.println("Failed to load image: " + path);
                return false;
            }
            img = Draw.colorKey(img);
            VolatileImage image = Draw.createImage(img.getWidth() * mag, img.getHeight() * mag);
            Graphics2D g = image.createGraphics();
            g.setComposite(AlphaComposite.getInstance(2, 1.0f));
            g.scale(mag, mag);
            g.drawImage((Image)img, 0, 0, null);
            g.dispose();
            Surface surface = new Surface();
            surface.name = name;
            surface.width = img.getWidth();
            surface.height = img.getHeight();
            surface.system = false;
            surface.image = image;
            Draw.surfaces[surf_no] = surface;
        }
        catch (Exception e) {
            System.err.println("Failed to load image: " + name);
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static boolean ReloadBitmap_Resource(String name, int surf_no) {
        return Draw.ReloadBitmap_File("BITMAP/" + name, surf_no);
    }

    public static boolean ReloadBitmap_File(String name, int surf_no) {
        if (surfaces[surf_no] == null) {
            return Draw.MakeSurface_File(name, surf_no);
        }
        Surface surface = surfaces[surf_no];
        try {
            String path = "/" + name + ".pbm";
            BufferedImage img = ImageIO.read(DataLoader.stream(path));
            if (img == null) {
                System.err.println("Failed to load image: " + path);
                return false;
            }
            img = Draw.colorKey(img);
            Graphics2D g = surface.image.createGraphics();
            g.setComposite(AlphaComposite.getInstance(2, 1.0f));
            g.scale(mag, mag);
            g.drawImage((Image)img, 0, 0, null);
            g.dispose();
        }
        catch (Exception e) {
            System.err.println("Failed to load image: " + name);
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static boolean MakeSurface_Generic(int bxsize, int bysize, int surf_no, boolean bSystem, boolean bTarget) {
        if (surf_no > 40) {
            return false;
        }
        if (surfaces[surf_no] != null) {
            return false;
        }
        VolatileImage image = Draw.createImage(bxsize * mag, bysize * mag);
        Draw.surfaces[surf_no] = new Surface();
        Draw.surfaces[surf_no].width = bxsize;
        Draw.surfaces[surf_no].height = bysize;
        Draw.surfaces[surf_no].system = bSystem;
        Draw.surfaces[surf_no].image = image;
        Draw.surfaces[surf_no].name = "generic";
        return true;
    }

    public static void BackupSurface(int surf_no, RECT rect) {
        if (surfaces[surf_no] == null) {
            return;
        }
        Draw.rcWork.left = rect.left * mag;
        Draw.rcWork.top = rect.top * mag;
        Draw.rcWork.right = rect.right * mag;
        Draw.rcWork.bottom = rect.bottom * mag;
        if (Draw.rcWork.right <= Draw.rcWork.left || Draw.rcWork.bottom <= Draw.rcWork.top) {
            return;
        }
        Graphics2D g = Draw.surfaces[surf_no].image.createGraphics();
        g.setComposite(AlphaComposite.getInstance(2, 1.0f));
        g.drawImage(backBuffer, Draw.rcWork.left, Draw.rcWork.top, Draw.rcWork.right, Draw.rcWork.bottom, Draw.rcWork.left, Draw.rcWork.top, Draw.rcWork.right, Draw.rcWork.bottom, null);
        g.dispose();
    }

    public static void PutBitmap3(RECT rcView, int x, int y, RECT rect, int surf_no) {
        if (surfaces[surf_no] == null) {
            return;
        }
        Draw.rcWork.left = rect.left;
        Draw.rcWork.top = rect.top;
        Draw.rcWork.right = rect.right;
        Draw.rcWork.bottom = rect.bottom;
        if (x + rect.right - rect.left > rcView.right) {
            Draw.rcWork.right -= x + rect.right - rect.left - rcView.right;
        }
        if (x < rcView.left) {
            Draw.rcWork.left += rcView.left - x;
            x = rcView.left;
        }
        if (y + rect.bottom - rect.top > rcView.bottom) {
            Draw.rcWork.bottom -= y + rect.bottom - rect.top - rcView.bottom;
        }
        if (y < rcView.top) {
            Draw.rcWork.top += rcView.top - y;
            y = rcView.top;
        }
        Draw.rcWork.left *= mag;
        Draw.rcWork.top *= mag;
        Draw.rcWork.right *= mag;
        Draw.rcWork.bottom *= mag;
        if (Draw.rcWork.right <= Draw.rcWork.left || Draw.rcWork.bottom <= Draw.rcWork.top) {
            return;
        }
        backBufferGraphics.drawImage(Draw.surfaces[surf_no].image, x * mag, y * mag, x * mag + (Draw.rcWork.right - Draw.rcWork.left), y * mag + (Draw.rcWork.bottom - Draw.rcWork.top), Draw.rcWork.left, Draw.rcWork.top, Draw.rcWork.right, Draw.rcWork.bottom, null);
    }

    public static void PutBitmap4(RECT rcView, int x, int y, RECT rect, int surf_no) {
        if (surfaces[surf_no] == null) {
            return;
        }
        Draw.rcWork.left = rect.left;
        Draw.rcWork.top = rect.top;
        Draw.rcWork.right = rect.right;
        Draw.rcWork.bottom = rect.bottom;
        if (x + rect.right - rect.left > rcView.right) {
            Draw.rcWork.right -= x + rect.right - rect.left - rcView.right;
        }
        if (x < rcView.left) {
            Draw.rcWork.left += rcView.left - x;
            x = rcView.left;
        }
        if (y + rect.bottom - rect.top > rcView.bottom) {
            Draw.rcWork.bottom -= y + rect.bottom - rect.top - rcView.bottom;
        }
        if (y < rcView.top) {
            Draw.rcWork.top += rcView.top - y;
            y = rcView.top;
        }
        Draw.rcWork.left *= mag;
        Draw.rcWork.top *= mag;
        Draw.rcWork.right *= mag;
        Draw.rcWork.bottom *= mag;
        if (Draw.rcWork.right <= Draw.rcWork.left || Draw.rcWork.bottom <= Draw.rcWork.top) {
            return;
        }
        backBufferGraphics.setColor(Color.BLACK);
        backBufferGraphics.fillRect(x * mag, y * mag, Draw.rcWork.right - Draw.rcWork.left, Draw.rcWork.bottom - Draw.rcWork.top);
        backBufferGraphics.drawImage(Draw.surfaces[surf_no].image, x * mag, y * mag, x * mag + (Draw.rcWork.right - Draw.rcWork.left), y * mag + (Draw.rcWork.bottom - Draw.rcWork.top), Draw.rcWork.left, Draw.rcWork.top, Draw.rcWork.right, Draw.rcWork.bottom, null);
    }

    public static void Surface2Surface(int x, int y, RECT rect, int to, int from) {
        if (surfaces[to] == null || surfaces[from] == null) {
            return;
        }
        Draw.rcWork.left = rect.left * mag;
        Draw.rcWork.top = rect.top * mag;
        Draw.rcWork.right = rect.right * mag;
        Draw.rcWork.bottom = rect.bottom * mag;
        if (Draw.rcWork.right <= Draw.rcWork.left || Draw.rcWork.bottom <= Draw.rcWork.top) {
            return;
        }
        Graphics2D g = Draw.surfaces[to].image.createGraphics();
        g.setComposite(AlphaComposite.getInstance(2, 1.0f));
        g.drawImage(Draw.surfaces[from].image, x * mag, y * mag, x * mag + (Draw.rcWork.right - Draw.rcWork.left), y * mag + (Draw.rcWork.bottom - Draw.rcWork.top), Draw.rcWork.left, Draw.rcWork.top, Draw.rcWork.right, Draw.rcWork.bottom, null);
        g.dispose();
    }

    public static void CortBox(RECT rect, int col) {
        backBufferGraphics.setColor(new Color(col));
        backBufferGraphics.fillRect(rect.left * mag, rect.top * mag, (rect.right - rect.left) * mag, (rect.bottom - rect.top) * mag);
    }

    public static void CortBox2(RECT rect, int col, int surf_no) {
        if (surfaces[surf_no] == null) {
            return;
        }
        if (rect.right <= rect.left || rect.bottom <= rect.top) {
            return;
        }
        Graphics2D g = Draw.surfaces[surf_no].image.createGraphics();
        if (col == 0) {
            g.setComposite(AlphaComposite.getInstance(1, 0.0f));
        } else {
            g.setColor(new Color(col));
        }
        g.fillRect(rect.left * mag, rect.top * mag, (rect.right - rect.left) * mag, (rect.bottom - rect.top) * mag);
        g.dispose();
    }

    public static int RestoreSurfaces() {
        return 0;
    }

    public static void InitTextObject(String font_name) {
        font = new Font(font_name, 0, 9 * mag);
    }

    public static void PutText(int x, int y, String text, int color) {
        Draw.doPutText(backBufferGraphics, x, y, text, color);
    }

    public static void PutText2(int x, int y, String text, int color, int surf_no) {
        Graphics2D g = Draw.surfaces[surf_no].image.createGraphics();
        Draw.doPutText(g, x, y, text, color);
        g.dispose();
    }

    private static void doPutText(Graphics2D g, int x, int y, String text, int color) {
        g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g.setColor(new Color(color));
        g.setFont(font);
        g.drawString(text, x * mag, (y + 8) * mag);
    }

    public static void EndTextObject() {
    }

    private static class Surface {
        VolatileImage image;
        String name;
        int width;
        int height;
        boolean system;

        private Surface() {
        }
    }
}
