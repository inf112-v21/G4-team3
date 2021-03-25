package inf112.skeleton.app;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import inf112.skeleton.app.Menu.GameMenu;
import inf112.skeleton.app.Menu.Screens.MainMenu;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static boolean debugmode;
    public static final int boardSizeX = 13;
    public static final int boardSizeY = 10;

    public static void main(String[] args) {
        Lwjgl3ApplicationConfiguration cfg = new Lwjgl3ApplicationConfiguration();
        cfg.setTitle("RobotRally");

        //Board board = new Board();
        //board.createMap();


        int height = 800;
        int k = height / boardSizeY;
        int width = boardSizeX * k;

        cfg.setWindowedMode(width, 1000);
        new Lwjgl3Application(new GameMenu(), cfg);
/*
        Scanner sc= new Scanner(System.in);
        System.out.print("Select mode:\nType 1 for server. Type 2 for client. Type 3 for single player(testing)\n");
        int mode = sc.nextInt();
        System.out.print("Select Debugmode mode: false/true \n");
        debugmode = sc.nextBoolean();
        if (mode == 1) {
            new Lwjgl3Application(new RenderServer(), cfg);
        }
        else if (mode == 2){
            System.out.println("Give host ip-adress, if you want to play on your own pc, ip-address is 127.0.0.1");
            String hostIP = sc.next();
            new Lwjgl3Application(new RenderClient(hostIP), cfg);
        }

        else if (mode == 3){
            new Lwjgl3Application(new RenderSinglePlayer(), cfg);
        }
*/
    }
}