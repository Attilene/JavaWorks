package Seminar_2.Task6_Seabattle;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class User_Interface {
    Map mapUser, mapComp;
    boolean mode, first_way;
    Random rd = new Random();
    Scanner scan;
    Client user1;
    String name;

    public User_Interface(String name) {
        mapUser = new Map();
        mapComp = new Map();
        this.name = name;
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
        first_way = rd.nextBoolean();
        mapUser.randomLoc();
        if (!mode) {
            user1 = new Client(name);
            user1.connect();
            user1.send(mapUser);
        }
        else {
            mapComp.randomLoc();
            ways(first_way, mode, mapComp);
        }

    }

    public void ways(boolean first_way, boolean mode, Map map) {
        Map mapEnemy;
        mapEnemy = map;
        if (first_way) System.out.println("User1 goes first!");
        else if (mode) System.out.println("Computer goes first!");
        while (true) {
            if (first_way) {
                if (!userWay(mapEnemy)) break;
                if (isGameOver(true, mode, mapUser)) break;
                if (mode) compWay();
                else user2Way();
                if (isGameOver(false, mode, mapEnemy)) break;
            }
            else {
                if (mode) compWay();
                else user2Way();
                if (isGameOver(false, mode, mapEnemy)) break;
                if (!userWay(mapEnemy)) break;
                if (isGameOver(true, mode, mapUser)) break;
            }
        }
        mapOut(mapUser);
        mapOut(mapEnemy);
    }

    public boolean isGameOver(boolean enemies, boolean mode, Map map) {
        if (enemies) {
            if (isMapEmpty(map)) {
                System.out.println("User1 are win!!! HOORAY!!!");
                System.out.println("Game over!");
                return true;
            }
        }
        else {
            if (mode & isMapEmpty(map)) {
                System.out.println("Computer are win!!! So sad :(");
                System.out.println("Game over!");
                return true;
            }
            else if (!mode & isMapEmpty(map)) {
                System.out.println("User2 are win!!! So sad :(");
                System.out.println("Game over!");
                return true;
            }
        }
        return false;
    }

    public boolean isMapEmpty(Map map) {
        for (int i = 0; i < map.map.length; i++) {
            for (int j = 0; j < map.map[i].length; j++) {
                if (map.map[i][j] == 'S')
                    return false;
            }
        }
        return true;
    }

    public boolean userWay(Map mapEnemy) {
        int x, y;
        mapOut(mapUser);
        mapOut(mapEnemy, true);
        System.out.println("User1 way:");
        System.out.println("To exit, input: -1 -1");
        System.out.print("Input coordinates of cell (x, y): ");
        while (true) {
            try {
                scan = new Scanner(System.in);
                x = scan.nextInt();
                y = scan.nextInt();
                if (x == -1 & y == -1) { // Выход из игры
                    System.out.println("Draw!!! Game over!");
                    return false;
                }
                else if (x >= 10 | x < 0 | y >= 10 | y < 0) {
                    throw new InputMismatchException();
                }
                else
                    break;
            }
            catch (InputMismatchException e) {
                System.out.println("User1 are entered incorrect data!");
                System.out.print("Input right coordinates: ");
            }
        }
        if (mapEnemy.map[x][y] == 'S') {
            mapEnemy.map[x][y] = '˟';
            if (!isKilled(mapEnemy, x, y))
                System.out.println("User1 hit the ship!");
            else
                System.out.println("User1 killed the ship!");
            return userWay(mapEnemy);
        }
        else if (mapEnemy.map[x][y] == ' ' | mapEnemy.map[x][y] == '·') {
            System.out.println("User1 missed!");
            mapEnemy.map[x][y] = '·';
        }
        else if (mapEnemy.map[x][y] == '˟') {
            System.out.println("User1 missed!");
        }
        return true;
    }

    public void user2Way() {
        int x, y;
        mapOut(mapUser);
//        mapOut(mapUser2, true);
        System.out.println("User2 way:");
        x = (int) (Math.random() * 10); // TODO: Нужно переделать для веб-сервера
        y = (int) (Math.random() * 10); // TODO: Нужно переделать для веб-сервера
        System.out.println("User2 chose the coordinates:");
        System.out.println(x + " " + y);
        if (mapUser.map[x][y] == 'S') {
            mapUser.map[x][y] = '˟';
            if (!isKilled(mapUser, x, y))
                System.out.println("User2 hit the ship!");
            else
                System.out.println("User2 killed the ship!");
            compWay();
        }
        else if (mapUser.map[x][y] == ' ' | mapUser.map[x][y] == '·') {
            System.out.println("User2 missed!");
            mapUser.map[x][y] = '·';
        }
        else if (mapUser.map[x][y] == '˟') {
            System.out.println("User2 missed!");
        }
    }

    public void compWay() {
        int x, y;
        mapOut(mapUser);
        mapOut(mapComp, true);
        System.out.println("Computer way:");
        x = (int) (Math.random() * 10);
        y = (int) (Math.random() * 10);
        while (mapUser.map[x][y] == '·' | mapUser.map[x][y] == '˟') {
            x = (int) (Math.random() * 10);
            y = (int) (Math.random() * 10);
        }
        System.out.println("Computer chose the coordinates:");
        System.out.println(x + " " + y);
        if (mapUser.map[x][y] == 'S') {
            mapUser.map[x][y] = '˟';
            if (!isKilled(mapUser, x, y))
                System.out.println("Computer hit the ship!");
            else
                System.out.println("Computer killed the ship!");
            compWay();
        }
        else if (mapUser.map[x][y] == ' ') {
            System.out.println("Computer missed!");
            mapUser.map[x][y] = '·';
        }
    }

    public boolean isKilled(Map map, int x, int y) {
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

    public void mapOut(Map map, boolean secret) {
        System.out.print("  |");
        for(int i = 0; i < map.map.length; i++) {
            System.out.print(" " + i);
        }
        System.out.println();
        for (int i = 0; i < 23; i++) {
            System.out.print("͞");
        }
        System.out.println();
        for (int i = 0; i < map.map.length; i++) {
            System.out.print(i + " | " );
            for (int j = 0; j < map.map.length; j++) {
                if (map.map[i][j] == 'S' & secret) System.out.print("  ");
                else System.out.print(map.map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void mapOut(Map map) {
        mapOut(map, false);
    }
}
