package Seminar_2.Task6_Seabattle;
import java.util.Random;

public class Ship {
    int size;
    boolean isVertically;
    int coordX, coordY;

    public Ship(int size) {
        this.size = size;
        Random rd = new Random();
        isVertically = rd.nextBoolean();
        coordX = (int) (Math.random() * 10);
        coordY = (int) (Math.random() * 10);
    }
}
