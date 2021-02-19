package inf112.skeleton.app;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;


public class Client {

    public static void main(String[] args) throws IOException {
        // need host and port, we want to connect to the ServerSocket at port 7777
        Socket socket = new Socket("127.0.0.1", 4000);
        System.out.println("Connected!");

        // get the output stream from the socket.
        OutputStream outputStream = socket.getOutputStream();
        // create an object output stream from the output stream so we can send an object through it
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

        // make a bunch of messages to send.
        List<TestObject> messages = new ArrayList<>();
        //messages.add(new Message("Hello from the other side!"));
        /*
        messages.add(new TestObject());
        TestObject obj = new TestObject();
        obj.changeValue();
        messages.add(obj);
        System.out.println(messages);
        String st = "rr";
        System.out.println(obj.getClass().getPackage());
        */

        TestObject to = new TestObject();
        to.setCards();


        System.out.println("Sending messages to the ServerSocket");
        objectOutputStream.writeObject(to.listCards);

        System.out.println("Closing socket and terminating program.");
        socket.close();
    }
}
/*
        BufferedWriter writerChannel = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        BufferedReader readerChannel = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String line;

        //writerChannel.write(new Date().toString() + "\n\r");
        Scanner input = new Scanner(System.in);
        System.out.println("Type message");
        String message = input.nextLine();
        writerChannel.write(message);
        writerChannel.flush();

        while ((line = readerChannel.readLine()) != null)
        {
            System.out.println(line);
        }
    }

 */
