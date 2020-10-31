package Seminar_2.Task6_Seabattle;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;


public class Client{
    private static final String HOST = "25.100.170.100";
    private Socket socket;
    private ObjectInputStream objectInputStream;
    private ObjectOutputStream objectOutputStream;
    private InetAddress address;
    private int port;
    private String name;

    public Client(String name) {
        try {
            this.name = name;
            address = InetAddress.getByName(HOST);
            port = Server.getPort();
        } catch (UnknownHostException e) { e.printStackTrace(); }
    }

    public void connect() {
        try {
            socket = new Socket(address, port);
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectInputStream = new ObjectInputStream(socket.getInputStream());
        }
        catch (IOException e) { e.printStackTrace(); }
    }

    public void send(Object data) {
        try { objectOutputStream.writeObject(data); }
        catch (IOException e) { e.printStackTrace(); }
    }

    public Object receive() {
        try { return objectInputStream.readObject(); }
        catch (SocketException e) { System.out.println(); }
        catch (IOException | ClassNotFoundException e) { e.printStackTrace(); }
        return null;
    }
}