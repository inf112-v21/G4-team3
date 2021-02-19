package inf112.skeleton.app;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

public class Server {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerSocket listener = new ServerSocket(4000);
        System.out.println("ServerSocket awaiting connections...");
        Socket socket = listener.accept(); // blocking call, this will wait until a connection is attempted on this port.
        System.out.println("Connection from " + socket + "!");

        // get the input stream from the connected socket
        InputStream inputStream = socket.getInputStream();
        // create a DataInputStream so we can read data from it.
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        TestObject t = new TestObject();
        System.out.println(t.getClass().getPackage());

        // read the list of messages from the socket
        List<String> listOfMessages = (List<String>) objectInputStream.readObject();
        //TestObject listOfMessages = (TestObject) objectInputStream.readObject();

        //System.out.println("Received [" + listOfMessages.size() + "] messages from: " + socket);
        // print out the text of every message
        System.out.println("All messages:");
        //listOfMessages.forEach((msg)-> System.out.println(msg));
        System.out.println(listOfMessages);

        System.out.println("Closing sockets.");
        listener.close();
        socket.close();
    }
}