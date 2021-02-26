package inf112.skeleton.app;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //new CardDeck();
        //System.out.println(CardDeck.deck);


        Lwjgl3ApplicationConfiguration cfg = new Lwjgl3ApplicationConfiguration();
        cfg.setTitle("RobotRally");
        cfg.setWindowedMode(500, 800);

        Scanner sc= new Scanner(System.in);
        System.out.print("Select mode:\nType 1 for server. Type 2 for client\n");
        int mode= sc.nextInt();

        if (mode == 1) {
            new Lwjgl3Application(new RenderServer(), cfg);
        }
        else if (mode == 2){
            new Lwjgl3Application(new RenderClient(), cfg);
        }

    }
}