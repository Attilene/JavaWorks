package Seminar_7;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class ZeroCross {
    char[][] field;
    String[] players;
    char[] badges = {'X', 'O'};
    private int size, x, y;
    Scanner scan;
    Random rd;


    public ZeroCross(int size, String[] names) {
        this.size = size;
        players = new String[names.length];
        System.arraycopy(names, 0, players, 0, names.length);
        x = 0;
        y = 0;
    }

    public void newGame() {
        field = createField();
        fieldOut();
        rd = new Random();
        int index = Math.abs(rd.nextInt() % 2);
        System.out.println("Start new game!");
        while (true) {
            if (index == 2) index = 0;
            if (isDraw()) {
                System.out.println("Draw! Game Over!");
                break;
            }
            System.out.println(players[index] + "`s way:");
            if (!scan()) {
                System.out.println(players[(index + 1) % 2] + " won! Game Over!");
                break;
            }
            if (field[x][y] == ' ')
                field[x][y] = badges[index];
            fieldOut();
            if (isGameOver(badges[index])) {
                System.out.println(players[index] + " won! Game over!");
                break;
            }
            index++;
        }
    }

    public boolean scan() {
        while (true) {
            try {
                System.out.println("To exit, input: -1 -1");
                System.out.print("Input coordinates of cell (x, y): ");
                scan = new Scanner(System.in);
                x = scan.nextInt();
                y = scan.nextInt();
                if (x == -1 & y == -1) return false;
                else if (x >= size | x < 0 | y >= size | y < 0) {
                    throw new InputMismatchException();
                } else break;
            } catch (InputMismatchException e) {
                System.out.println("You are entered incorrect data!");
                System.out.print("Input right coordinates: ");
            }
        }
        return true;
    }

    public boolean isGameOver(char elem){
        int q = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++)
                if (field[i][j] == elem) q++;
            if (q == size) return true;
            else q = 0;
        }
        for (int j = 0; j < size; j++) {
            for (int i = 0; i < size; i++)
                if (field[i][j] == elem) q++;
            if (q == size) return true;
            else q = 0;
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++)
                if (i == j & field[i][j] == elem) q++;
            if (q == size) return true;
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++)
                if (i + j == size - 1 & field[i][j] == elem) q++;
            if (q == size) return true;
        }
        return false;
    }

    public boolean isDraw() {
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                if (field[i][j] == ' ') return false;
        return true;
    }

    public char[][] createField() {
        char[][] field = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                field[i][j] = ' ';
            }
        }
        return field;
    }

    public void fieldOut() {
        System.out.print("  |");
        for(int i = 0; i < size; i++) {
            System.out.print(" " + i);
        }
        System.out.println();
        for (int i = 0; i < 10; i++) {
            System.out.print("͞");
        }
        System.out.println();
        for (int i = 0; i < size; i++) {
            System.out.print(i + " | " );
            for (int j = 0; j < size; j++) {
                System.out.print(field[i][j] + " ");
            }
            System.out.println();
        }
    }
}
