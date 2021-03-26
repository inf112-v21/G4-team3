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
        socket = listener.accept(); // Waiting for connection on this port.
        System.out.println("Received a connection from " + socket);
    }

    public void setUpClient(String ip) throws IOException {
        // Connecting to the ServerSocket at port 4000
        socket = new Socket(ip, 4000); // 127.0.0.1 is localhost
        System.out.println("Connected");
    }

    public void sendCards(ArrayList<Enum> cards) throws IOException {
        // Get the output stream from the socket
        OutputStream outputStream = socket.getOutputStream();
        // Create an object output stream from the output stream and send an object through it
        objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(cards);
    }

    public List<Enum> receiveCards() throws IOException, ClassNotFoundException {
        // Get the input stream from the connected socket
        InputStream inputStream = socket.getInputStream();
        objectInputStream = new ObjectInputStream(inputStream);
        // Receive object from other player
        List<Enum> cards = (List<Enum>) objectInputStream.readObject();
        return cards;
    }
}
