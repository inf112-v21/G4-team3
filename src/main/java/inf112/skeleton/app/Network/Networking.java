package inf112.skeleton.app.Network;

import inf112.skeleton.app.Network.Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Networking implements Runnable{

    private ServerSocket listener;
    private Socket socket;
    private ObjectInputStream objectInputStream;
    private ObjectOutputStream objectOutputStream;

    private Thread thread;
    private String netType;
    private String ip;
    private Integer port;

    public Networking(String type){
        netType = type;
    }

    @Override
    public void run() {

        if(netType.equals("Server")){
            try {
                setUpServer();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        else if(netType.equals("Client")){
            try {
                setUpClient();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void start(){
        if (thread == null){
            thread = new Thread(this, netType);
            thread.start();
        }
    }

    public void setUpServer()  throws IOException, ClassNotFoundException {
        Server server = new Server();
        server.serverConnect();
        while(true) {
            server.serverActions();
            System.out.println("Round is over");
        }
    }

    public void waitForConnection(int port) throws IOException, ClassNotFoundException {
        listener = new ServerSocket(port);
        System.out.println("ServerSocket is waiting for connections...");
        socket = listener.accept(); // Waiting for connection on this port.
        System.out.println("Received a connection from " + socket);
    }

    public void connectIP(String ip, int port){
        this.ip = ip;
        this.port = port;
    }

    public void setUpClient() throws IOException {
        // Connecting to the ServerSocket at port 4000
        socket = new Socket(ip, port); // 127.0.0.1 is localhost
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
