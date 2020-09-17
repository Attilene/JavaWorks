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
            System.out.println("Your way:");
            if (isGameOver()) {
                mapOut(mapUser);
                mapOut(mapComp);
                break;
            }
        }
    }

    private boolean isGameOver() {
        return false;
    }

    private void userWay() {
        int x, y;
        System.out.println("Input coordinates of cell (x, y):");
        Scanner scan = new Scanner(System.in);
        while (true) {
            x = scan.nextInt();
            y = scan.nextInt();
            if (x >= 10 | x < 0 | y >= 10 | y < 0)
                System.out.println("You are entered incorrect data!");
            break;
        }
        if (mapComp.map[x][y] == 'S') {
            mapComp.map[x][y] = '˟';
            System.out.println("You hit the ship!");
        }
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
    }
}
