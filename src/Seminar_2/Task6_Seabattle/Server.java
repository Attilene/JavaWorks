package Seminar_2.Task6_Seabattle;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.util.ArrayList;


public class Server extends Thread{
    private static final String HOST = "localhost";
    private static final int PORT = 5005;
    public static ArrayList<Connect> connects = new ArrayList<>();
    private ServerSocket serverSocket;
    private Map user1Map, user2Map;

    static public int getPort() { return PORT; }
    static public String getHost() { return HOST; }

    public Server() {
        try {
            InetAddress address = InetAddress.getByName(HOST);
            serverSocket = new ServerSocket(PORT, 0, address);
            System.out.println("Server is running: " + serverSocket.getLocalSocketAddress());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        while (true) {
            try {
                Connect clientConnection = new Connect(serverSocket.accept());
                Server.connects.add(clientConnection);
                System.out.println("    Client connected: " + clientConnection.getName());
            } catch (IOException ex) {
                disconnect();
            }
        }
    }

    public void receiveMap() {

    }

    public void sendMessageAll(String msg) {
        for(Connect client : connects) {
            client.send(msg);
        }
    }

    public void disconnect() {
        try {
            serverSocket.close();
//            System.out.println(client);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean isStart() { return Server.connects.size() == 2; }

    public static void main(String[] args) {
        Server server = new Server();
        server.start();
    }

}