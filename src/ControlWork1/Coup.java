package ControlWork1;

public class Coup extends Car{
    private int capacity;

    public Coup(String color, int maxSpeed, int currentSpeed, String box, int price, int capacity) {
        super(color, maxSpeed, currentSpeed, box, price);
        this.capacity = capacity;
    }
}
