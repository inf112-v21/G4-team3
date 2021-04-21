package inf112.skeleton.app;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import inf112.skeleton.app.Menu.GameMenu;

public class Main {
    public static boolean debugmode = false;
    public static final int boardSizeX = 13;
    public static final int boardSizeY = 10;
    public static int finalHeight = 1000;
    public static int finalWidth = 1000;
    public static int mode;

    public static void main(String[] args) {
        Lwjgl3ApplicationConfiguration cfg = new Lwjgl3ApplicationConfiguration();
        cfg.setTitle("RobotRally");

        int height = 800;
        int k = height / boardSizeY;
        int width = boardSizeX * k;

        finalHeight = 1000;
        finalWidth = width;

        cfg.setWindowedMode(finalWidth, finalHeight);
        new Lwjgl3Application(new GameMenu(), cfg);
    }
}