package inf112.skeleton.app.Network;

import java.io.IOException;
import java.util.ArrayList;

public class WaitThread implements Runnable {

    private Thread thread;
    private String threadName;
    private Networking connection;
    public ArrayList<Enum> cards = new ArrayList<>();

    public WaitThread(String name, Networking connection){
        threadName = name;
        this.connection = connection;
    }

    @Override
    public void run(){
        try {
            cards = getCards(connection);
            System.out.println("Thread done");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private ArrayList<Enum> getCards(Networking connection) throws IOException, ClassNotFoundException {
        System.out.println("Waiting for cards 1");
        ArrayList<Enum> cards = (ArrayList<Enum>) connection.receiveCards();
        System.out.println("Received cards");
        System.out.println(cards);
        return cards;

    }

    public void start(){
        if (thread == null){
            thread = new Thread(this, threadName);
            thread.start();
        }
    }

}




