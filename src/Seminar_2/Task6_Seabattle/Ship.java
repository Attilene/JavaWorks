package Seminar_2.Task6_Seabattle;
import java.util.Random;

public class Ship {
    int size, hit = 0;
    int xlu, ylu, xrd, yrd;
    boolean isVertically;
    int coordX, coordY;
    int[][] coords;

    public Ship(int size) {
        this.size = size;
        coords = new int[this.size][2];
        Random rd = new Random();
        isVertically = rd.nextBoolean();
        coordX = (int) (Math.random() * 10);
        coordY = (int) (Math.random() * 10);
    }
}
