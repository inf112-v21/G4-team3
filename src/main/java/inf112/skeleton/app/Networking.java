package inf112.skeleton.app;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Networking {

    public ServerSocket listener;
    public Socket socket;
    public ObjectInputStream objectInputStream;
    public ObjectOutputStream objectOutputStream;

    public void setUpServer() throws IOException, ClassNotFoundException {
        listener = new ServerSocket(4000);
        System.out.println("ServerSocket is waiting for connections...");
        socket = listener.accept(); // blocking call, this will wait until a connection is attempted on this port.
        System.out.println("Received a connection from " + socket);
    }

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

    // Wait for client input
    public List<Enum> receiveCards() throws IOException, ClassNotFoundException {
        // Get the input stream from the connected socket
        InputStream inputStream = socket.getInputStream();
        objectInputStream = new ObjectInputStream(inputStream);
        // Receive object from client
        List<Enum> cards = (List<Enum>) objectInputStream.readObject();
        return cards;
    }
}
