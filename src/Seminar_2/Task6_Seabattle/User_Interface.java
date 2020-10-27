package Seminar_2.Task6_Seabattle;

import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class User_Interface implements Serializable {
    Map mapUser, mapComp, mapUser2;
    boolean mode, first_way;
    Random rd = new Random();
    Scanner scan;
    Client user;
    String name;

    public User_Interface(String name) {
        this.name = name;
        mapUser = new Map(this.name);
        mapComp = new Map("Computer");
    }

    public void newGame() {
        while (true) {
            try {
                System.out.println("Game modes:");
                System.out.println("true - game against computer");
                System.out.println("false - game against another gamer with network");
                System.out.print("Choose game mode: ");
                scan = new Scanner(System.in);
                mode = scan.nextBoolean();
                break;
            }
            catch (InputMismatchException e)
                { System.out.println("You are entered incorrect mode!"); }
        }
        if (!mode) {
            user = new Client(name);
            user.connect();
            user.send(name);
            System.out.println(user.receive().toString());
            mapUser = (Map) user.receive();
            mapUser2 = (Map) user.receive();
            web_game(user);
//            mapUser.mapOut();
        }
        else {
            first_way = rd.nextBoolean();
            mapUser.randomLoc();
            mapComp.randomLoc();
            ways(first_way, mapUser, mapComp);
        }
    }

    public static void ways(boolean first_way, Map mapus, Map mapen) {
        if (first_way) System.out.println(mapus.name + " goes first!");
        else System.out.println(mapen.name + " goes first!");
        while (true) {
            if (first_way) {
                if (!userWay(mapus, mapen)) break;
                if (isGameOver(mapus)) break;
                compWay(mapus, mapen);
                if (isGameOver(mapen)) break;
            }
            else {
                compWay(mapus, mapen);
                if (isGameOver( mapen)) break;
                if (!userWay(mapus, mapen)) break;
                if (isGameOver(mapus)) break;
            }
        }
        mapus.mapOut();
        mapen.mapOut();
    }

    public void web_game(Client user) {
        int x, y;
        String str;
        Scanner scan;
        mapUser.mapOut();
//        mapen.mapOut(true);
        mapUser2.mapOut();
        while (true) {
            scan = new Scanner(System.in);
            str = (String) user.receive();
            if (!str.equals("Input coordinates of cell (x, y): ")) System.out.println(str);
            else {
                System.out.print(str);
                x = scan.nextInt();
                y = scan.nextInt();
                user.send(new int[]{x, y});
            }
            if (str.equals(mapUser.name + " hit the ship!") | str.equals(mapUser.name + " killed the ship!") | str.equals(mapUser.name + " missed!")) {
                System.out.println("OK 1");
                mapUser2.map = (char[][]) user.receive();
                mapUser.mapOut();
//                mapen.mapOut(true);
                mapUser2.mapOut();
            }
            else if (str.equals(mapUser2.name + " hit the ship!") | str.equals(mapUser2.name + " killed the ship!") | str.equals(mapUser2.name + " missed!")) {
                System.out.println("OK 2");
                mapUser.map = (char[][]) user.receive();
                mapUser.mapOut();
//                mapen.mapOut(true);
                mapUser2.mapOut();
            }
            else if ((str.equals(mapUser.name + " won!!! Game over!")) | (str.equals(mapUser2.name + " are win!!! Game over!"))) break;
        }
    }

    public static boolean isGameOver(Map map) {
        if (isMapEmpty(map)) {
            System.out.println(map.name + " are win!!! HOORAY!!! Game over!");
            return true;
        }
        return false;
    }

    public static boolean isMapEmpty(Map map) {
        for (int i = 0; i < map.map.length; i++) {
            for (int j = 0; j < map.map[i].length; j++) {
                if (map.map[i][j] == 'S')
                    return false;
            }
        }
        return true;
    }

    public static boolean userWay(Map userMap, Map mapEnemy) {
        int x, y;
        userMap.mapOut();
        mapEnemy.mapOut(true);
        System.out.println(userMap.name + " way:");
        System.out.println("To exit, input: -1 -1");
        System.out.print("Input coordinates of cell (x, y): ");
        Scanner scan;
        while (true) {
            try {
                scan = new Scanner(System.in);
                x = scan.nextInt();
                y = scan.nextInt();
                if (x == -1 & y == -1) { // Выход из игры
                    System.out.println(mapEnemy.name + " won!!! So sad :( Game over!");
                    return false;
                }
                else if (x >= 10 | x < 0 | y >= 10 | y < 0) {
                    throw new InputMismatchException();
                }
                else
                    break;
            }
            catch (InputMismatchException e) {
                System.out.println(userMap.name + " are entered incorrect data!");
                System.out.print("Input right coordinates: ");
            }
        }
        if (mapEnemy.map[x][y] == 'S') {
            mapEnemy.map[x][y] = '˟';
            if (!isKilled(mapEnemy, x, y))
                System.out.println(userMap.name + " hit the ship!");
            else
                System.out.println(userMap.name + " killed the ship!");
            return userWay(userMap, mapEnemy);
        }
        else if (mapEnemy.map[x][y] == ' ' | mapEnemy.map[x][y] == '·') {
            System.out.println(userMap.name + " missed!");
            mapEnemy.map[x][y] = '·';
        }
        else if (mapEnemy.map[x][y] == '˟') {
            System.out.println(userMap.name + " missed!");
        }
        return true;
    }

    public static void compWay(Map mapus, Map mapen) {
        int x, y;
        mapus.mapOut();
        mapen.mapOut(true);
        System.out.println(mapen.name + " way:");
        x = (int) (Math.random() * 10);
        y = (int) (Math.random() * 10);
        while (mapus.map[x][y] == '·' | mapus.map[x][y] == '˟') {
            x = (int) (Math.random() * 10);
            y = (int) (Math.random() * 10);
        }
        System.out.println(mapen.name + " chose the coordinates:");
        System.out.println(x + " " + y);
        if (mapus.map[x][y] == 'S') {
            mapus.map[x][y] = '˟';
            if (!isKilled(mapus, x, y))
                System.out.println(mapen.name + " hit the ship!");
            else
                System.out.println(mapen.name + " killed the ship!");
            compWay(mapus, mapen);
        }
        else if (mapus.map[x][y] == ' ') {
            System.out.println(mapen.name + " missed!");
            mapus.map[x][y] = '·';
        }
    }

    public static boolean isKilled(Map map, int x, int y) {
        for (int i = 0; i < map.listships.length; i++) {
            for (int j = 0; j < map.listships[i].size; j++) {
                if (map.listships[i].coords[j][0] == x & map.listships[i].coords[j][1] == y)
                    map.listships[i].hit++;
            }
            if (map.listships[i].hit == map.listships[i].size) {
                for (int k = map.listships[i].xlu; k < map.listships[i].xrd; k++) {
                    for (int u = map.listships[i].ylu; u < map.listships[i].yrd; u++) {
                        if (k >= 0 & k < map.map.length & u >= 0 & u < map.map.length)
                            if (map.map[k][u] != '˟')
                                map.map[k][u] = '·';
                    }
                }
                map.listships[i].hit = -1;
                return true;
            }
        }
        return false;
    }
}
