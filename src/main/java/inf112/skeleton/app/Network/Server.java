package inf112.skeleton.app.Network;

import java.io.IOException;
import java.util.ArrayList;

public class Server {

    private Networking connection1 = new Networking("Client");
    private Networking connection2 = new Networking("Client");
    private ArrayList<Enum> cards1 = new ArrayList<>();
    private ArrayList<Enum> cards2 = new ArrayList<>();

    public void serverConnect() throws IOException, ClassNotFoundException {
        System.out.println("server test");
        connection1.waitForConnection(4000);
        connection2.waitForConnection(4001);
        System.out.println("All connected");
    }

    public void serverActions() throws IOException, ClassNotFoundException {
        // Get cards
        WaitThread thread1 = new WaitThread("thread-1", connection1);
        thread1.start();
        WaitThread thread2 = new WaitThread("thread-2", connection2);
        thread2.start();

        // Send cards
        while(true) {
            cards1 = thread1.cards;
            cards2 = thread2.cards;
            if(cards1.size() > 1 && cards2.size() > 1) {
                System.out.println("send send cards cards");
                System.out.println(cards1);
                System.out.println(cards2);
                connection1.sendCards(cards2);
                connection2.sendCards(cards1);
                break;
            }
        }
    }
}

