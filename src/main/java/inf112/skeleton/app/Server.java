package inf112.skeleton.app;




import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {

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

    // Wait for client input
    public List<Enum> clientInput() throws IOException, ClassNotFoundException {
        // Get the input stream from the connected socket
        InputStream inputStream = socket.getInputStream();
        objectInputStream = new ObjectInputStream(inputStream);
        // Receive object from client
        List<Enum> cards = (List<Enum>) objectInputStream.readObject();
        return cards;
    }


    public void sendGameState(ArrayList<Player> player) throws IOException {
        // get the output stream from the socket.
        OutputStream outputStream = socket.getOutputStream();
        // create an object output stream from the output stream so we can send an object through it
        objectOutputStream = new ObjectOutputStream(outputStream);

        // send player object
        objectOutputStream.writeObject(player);
    }

    public void closeSocket() throws IOException {
        System.out.println("Closing socket");
        listener.close();
        socket.close();
    }
}