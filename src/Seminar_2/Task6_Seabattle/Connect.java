package Seminar_2.Task6_Seabattle;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Connect extends Thread{

    private Socket socket;
    private ObjectInputStream objectInputStream;
    private ObjectOutputStream objectOutputStream;

    public Connect(Socket socket) throws IOException {
        this.socket = socket;
        objectInputStream = new ObjectInputStream(this.socket.getInputStream());
        objectOutputStream = new ObjectOutputStream(this.socket.getOutputStream());
        start();
    }

    public void run() {
        try {
            while (true) {
                Object clientMessage = (Map) objectInputStream.readObject();
                System.out.println(clientMessage);
//                send(new Scanner(System.in).nextLine());
            }
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public void send(Object ... data) {
        try {
            objectOutputStream.writeObject(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Object receive() {
        try {
            return objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
