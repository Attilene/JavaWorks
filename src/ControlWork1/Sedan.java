package ControlWork1;

public class Sedan extends Car{
    private int height;

    public Sedan(String color, int maxSpeed, int currentSpeed, String box, int price, int height) {
        super(color, maxSpeed, currentSpeed, box, price);
        this.height = height;
    }


}