package inf112.skeleton.app;

import java.io.*;
import java.net.Socket;
import java.util.*;


public class Client {

    public Socket socket;
    public ObjectOutputStream objectOutputStream;
    public ObjectInputStream objectInputStream;

    public void setUpClient() throws IOException {
        // need host and port, we want to connect to the ServerSocket at port 7777
        socket = new Socket("127.0.0.1", 4000);
        System.out.println("Connected!");
    }


    public void sendCards(ArrayList<Enum> cards) throws IOException {
        // get the output stream from the socket.
        OutputStream outputStream = socket.getOutputStream();

        // create an object output stream from the output stream so we can send an object through it
        objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(cards);
    }

    public ArrayList<Player> receiveGameState() throws IOException, ClassNotFoundException {
        // get the input stream from the connected socket
        InputStream inputStream = socket.getInputStream();

        // create a DataInputStream so we can read data from it.
        objectInputStream = new ObjectInputStream(inputStream);

        // receive object from client
        ArrayList<Player> players = (ArrayList<Player>) objectInputStream.readObject();
        return players;
    }


    public void closeSocket() throws IOException {
        System.out.println("Closing socket");
        //listener.close();
        socket.close();
    }
}