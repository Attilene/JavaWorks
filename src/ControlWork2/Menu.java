package ControlWork2;

public abstract class Menu {
    private String name, unit, composition;
    private double price;

    public Menu(String name, int price, String unit, String composition) {
        this.name = name;
        this.price = price;
        this. unit = unit;
        this.composition = composition;
    }

    public double getPrice() {
        return price;
    }

    public String getComposition() {
        return composition;
    }

    public String getUnit() {
        return unit;
    }

    public String getName() {
        return name;
    }
}
