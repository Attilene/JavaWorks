package Seminar_2.Task6_Seabattle;

import java.util.Scanner;

public class User_Interface {
    Map mapUser, mapComp;

    public User_Interface() {
        mapUser = new Map();
        mapComp = new Map();
    }

    public void newGame() {
        mapUser.randomLoc();
        mapComp.randomLoc();
        while (true) {
            boolean b;
            b = userWay();
            if (!b)
                break;
            if (isGameOver(true)) {
                break;
            }
            compWay();
            if (isGameOver(false)) {
                break;
            }
        }
        mapOut(mapUser);
        mapOut(mapComp);
    }

    private boolean isGameOver(boolean enemies) {
        if (enemies) {
            if (isMapEmpty(mapComp)) {
                System.out.println("You are win!!! HOORAY!!!");
                System.out.println("Game over!");
                return true;
            }
        }
        else {
            if (isMapEmpty(mapUser)) {
                System.out.println("Computer are win!!! So sad :(");
                System.out.println("Game over!");
                return true;
            }
        }
        return false;
    }

    private boolean isMapEmpty(Map map) {
        for (int i = 0; i < map.map.length; i++) {
            for (int j = 0; j < map.map[i].length; j++) {
                if (map.map[i][j] == 'S')
                    return false;
            }
        }
        return true;
    }

    private boolean userWay() {
        int x, y;
        mapOut(mapUser);
        mapOutSecret(mapComp);
        System.out.println("Your way:");
        System.out.println("To exit, input: -1 -1");
        System.out.println("Input coordinates of cell (x, y):");
        Scanner scan = new Scanner(System.in);
        while (true) {
            x = scan.nextInt();
            y = scan.nextInt();
            if (x == -1 & y == -1) { // Выход из игры
                System.out.println("Draw!!!");
                System.out.println("Game over!");
                return false;
            }
            if (x >= 10 | x < 0 | y >= 10 | y < 0) {
                System.out.println("You are entered incorrect data!");
                System.out.println("Input right coordinates:");
            }
            if (x < 10 & x >= 0 & y < 10 & y >= 0)
                break;
        }
        if (mapComp.map[x][y] == 'S') {
            mapComp.map[x][y] = '˟';
            if (!isKilled(mapComp, x, y))
                System.out.println("You hit the ship!");
            else
                System.out.println("You killed the ship!");
            userWay();
        }
        else if (mapComp.map[x][y] == ' ' | mapComp.map[x][y] == '·') {
            System.out.println("You missed!");
            mapComp.map[x][y] = '·';
        }
        else if (mapComp.map[x][y] == '˟') {
            System.out.println("You missed!");
        }
        return true;
    }

    private void compWay() {
        int x, y;
        mapOut(mapUser);
        mapOutSecret(mapComp);
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

    private boolean isKilled(Map map, int x, int y) {
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

    private void mapOut(Map map) {
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
                System.out.print(map.map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private void mapOutSecret(Map map) {
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
                if (map.map[i][j] != 'S')
                    System.out.print(map.map[i][j] + " ");
                else
                    System.out.print("  ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
