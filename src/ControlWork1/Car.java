package ControlWork1;

import java.util.Scanner;

public abstract class Car {
    private String color, box;
    private Scanner scan = new Scanner(System.in);
    private int maxSpeed, currentSpeed;
    public int price;

    public Car(String color, int maxSpeed, int currentSpeed, String box, int price){
        this.color = color;
        this.maxSpeed = maxSpeed;
        this.currentSpeed = currentSpeed;
        this.box = box;
        this.price = price;
    }

    public void start() {
        int speed = scan.nextInt();
        accelerate(speed);
    }

    public void stop() {
        currentSpeed = 0;
    }

    private void accelerate (int speed) {
        if (speed + currentSpeed <= maxSpeed)
            maxSpeed = speed + currentSpeed;
    }
}
