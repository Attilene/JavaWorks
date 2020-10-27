package Seminar_2.Task6_Seabattle;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;


public class Server extends Thread{
    private static final String HOST = "localhost";
    private static final int PORT = 5005;
    public static ArrayList<Connect> connects = new ArrayList<>();
    private ServerSocket serverSocket;
    private Map MapUser1, MapUser2;
    private boolean first_way;

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
        System.out.println("Waiting for players to connect!");
        while (!isStart()) {
            try {
                Connect clientConnection = new Connect(serverSocket.accept());
                Server.connects.add(clientConnection);
                clientConnection.run();
                System.out.println("Client connected: " + clientConnection.name);
                if (clientConnection.getName().equals("Thread-1")) MapUser1 = new Map(clientConnection.name);
                else if (clientConnection.getName().equals("Thread-2")) MapUser2 = new Map(clientConnection.name);
            } catch (IOException ex) {
                disconnect();
            }
        }
        System.out.println("Clients are connected");
        MapUser1.randomLoc();
        MapUser2.randomLoc();
        Server.connects.get(0).send(MapUser1);
        Server.connects.get(0).send(MapUser2);
        Server.connects.get(1).send(MapUser2);
        Server.connects.get(1).send(MapUser1);
        sendMessageAll("Start the game!");
        Random rd = new Random();
        first_way = rd.nextBoolean();
        ways(first_way, MapUser1, MapUser2);
        disconnect();
    }

    public void sendMessageAll(String msg) {
        for(Connect client : connects) {
            client.send(msg);
        }
    }

    public void disconnect() {
        try { serverSocket.close(); }
        catch (IOException e) { System.out.println("Incorrect closing!"); }
    }

    public void ways(boolean first_way, Map mapus, Map mapen) {
        if (first_way) sendMessageAll(mapus.name + " goes first!");
        else sendMessageAll(mapen.name + " goes first!");
        while (true) {
            if (first_way) {
                if (!userWay(mapus, mapen)) break;
                if (isGameOver(mapus)) break;
                if (!userWay(mapen, mapus)) break;
                if (isGameOver(mapen)) break;
            }
            else {
                if (!userWay(mapen, mapus)) break;
                if (isGameOver( mapen)) break;
                if (!userWay(mapus, mapen)) break;
                if (isGameOver(mapus)) break;
            }
        }
        mapus.mapOut();
        mapen.mapOut();
    }

    public boolean isGameOver(Map map) {
        if (User_Interface.isMapEmpty(map)) {
            sendMessageAll(map.name + " are win!!! Game over!");
            return true;
        }
        return false;
    }

    public boolean userWay(Map mapus, Map mapen) {
        int x, y;
        int[] coords;
        int index;
        if (mapus.name.equals(MapUser1.name)) index = 0;
        else index = 1;
//        userMap.mapOut();
//        mapEnemy.mapOut(true);
        sendMessageAll(mapus.name + "`s way:");
        Server.connects.get(index).send("To exit, input: -1 -1");
        Server.connects.get(index).send("Input coordinates of cell (x, y): ");
        while (true) {
            try {
//                Server.connects.get(index).send("Hello");
                coords = (int[]) Server.connects.get(index).receive();
                x = coords[0];
                y = coords[1];
                if (x == -1 & y == -1) { // Выход из игры
                    sendMessageAll(mapen.name + " won!!! Game over!");
                    return false;
                }
                else if (x >= 10 | x < 0 | y >= 10 | y < 0) { throw new InputMismatchException(); }
                else break;
            }
            catch (InputMismatchException e) {
                Server.connects.get(index).send(mapus.name + " are entered incorrect data!");
                Server.connects.get(index).send("Input right coordinates: ");
            }
        }
        Server.connects.get(Math.abs(index - 1)).send(mapus.name + " choose the coordinates: " + x + " " + y);
        if (mapen.map[x][y] == 'S') {
            mapen.map[x][y] = '˟';
            if (!User_Interface.isKilled(mapen, x, y))
                sendMessageAll(mapus.name + " hit the ship!");
            else
                sendMessageAll(mapus.name + " killed the ship!");
            return userWay(mapus, mapen);
        }
        else if (mapen.map[x][y] == ' ' | mapen.map[x][y] == '·') {
            sendMessageAll(mapus.name + " missed!");
            mapen.map[x][y] = '·';
        }
        else if (mapen.map[x][y] == '˟') {
            sendMessageAll(mapus.name + " missed!");
        }
        Server.connects.get(index).send(mapen.map);
        Server.connects.get(Math.abs(index - 1)).send(mapen.map);
        mapus.mapOut();
        mapen.mapOut();
        return true;
    }

    public static boolean isStart() { return Server.connects.size() == 2; }

    public static void main(String[] args) {
        Server server = new Server();
        server.start();
    }

}